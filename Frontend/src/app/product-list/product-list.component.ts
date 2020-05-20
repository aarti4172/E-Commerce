import { Component, OnInit } from '@angular/core';
import { AdminService } from '../admin.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  result:any;
  msg:any;
  message:any;
  constructor(private adminService: AdminService, private router: Router) { }

  ngOnInit(){
    this.listOfProducts();
  }

  listOfProducts(){
    this.adminService.getAllProducts().subscribe(data => {
      console.log(data);
      this.result=data;
    }, err => 
    { console.log(err.stack);
    });
  }

  remove(pid){
    if(confirm("Are you sure you want to remove the product?")){
    this.adminService.removeProduct(pid).subscribe(data => {
      console.log(data);
      this.msg=data;
      if(this.msg==true)
      {
        this.message="Successfully removed the product";
        alert(this.message);
        this.listOfProducts();
      }
    }, err =>
    { console.log(err.stack);
    })
  }
  }

  update(){
    this.router.navigate(['/updateProduct']);
  }

  back(){
    this.router.navigate(['/admin']);
  }
}