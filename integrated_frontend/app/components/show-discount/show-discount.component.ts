import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Product } from 'src/app/models/Product';
import { AdminService } from 'src/app/service/admin.service';

@Component({
  selector: 'app-show-discount',
  templateUrl: './show-discount.component.html',
  styleUrls: ['./show-discount.component.css']
})
export class ShowDiscountComponent implements OnInit {
  searchTerm;
  product:Product;
  constructor(private router:Router,private adminService:AdminService) { }

  ngOnInit() {
    this.adminService.getAllProducts().subscribe(data=>{this.product=data},error=>{console.log(error)});
  }
  back()
  {
    
    this.router.navigate(['admin']);
  }

}
