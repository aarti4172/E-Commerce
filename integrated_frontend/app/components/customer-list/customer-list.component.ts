import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CustomerDetails } from 'src/app/models/CustomerDetails';
import { AdminService } from 'src/app/service/admin.service';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {

  customerList:CustomerDetails[];
  searchTerm:any;
  constructor(private router:Router,private adminService:AdminService ) { }

  ngOnInit() {
    this.adminService.getAllUser().subscribe(
      data=>{this.customerList=data;
      console.log(data);},
      error=>{console.log(error);
      });
  }
  back()
  {
      this.router.navigate(['admin']);
  }
   

  deleteuser(user_id:number)
  {
    this.adminService.deleteUser(user_id).subscribe(
      data=>{
        console.log(data);
      },
      error=>{
        console.log(error);
      }
      
    );
    window.location.reload();
  }
}
