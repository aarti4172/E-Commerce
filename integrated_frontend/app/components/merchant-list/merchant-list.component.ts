import { Component, OnInit } from '@angular/core';
import { RouteReuseStrategy, Router } from '@angular/router';
import { MerchantDetails } from 'src/app/models/MerchantDetails';
import { AdminService } from 'src/app/service/admin.service';

@Component({
  selector: 'app-merchant-list',
  templateUrl: './merchant-list.component.html',
  styleUrls: ['./merchant-list.component.css']
})
export class MerchantListComponent implements OnInit {
  merchantList:MerchantDetails[];
  searchTerm;
  constructor(private router:Router,
    private adminService:AdminService) { }

  ngOnInit() {
this.adminService.getAllMerchant().subscribe(
  data=>{
    this.merchantList=data;
    console.log(data);

  },
  error=>{
    console.log(error);
  }
)

  }
  back()
  {
      this.router.navigate(['admin']);
  }
  deleteMerchant(userId:number){

    this.adminService.deleteMerchant(userId).subscribe(data=>{console.log(data)},
    error=>{
      console.log(error)
    });
    window.location.reload();
  }
}
