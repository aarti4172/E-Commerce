import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Product } from 'src/app/models/Product';
import { AdminService } from 'src/app/service/admin.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  products:Product[]=[];
  searchTerm;
  location:String;
  constructor(private router:Router,
    private adminService:AdminService) { }

  ngOnInit() {

    this.adminService.getAllProducts().subscribe(
      data=>{
        this.products=data;
        //this.location=this.products.productImage;
   
      },
      error=>{
        console.log(error);
      }
    );
    
  }

  // featured(){
  //   this.adminService.getFeaturedProducts().subscribe(
  //     data=>{
  //       this.products = data;
  //     },
  //     error=>{
  //       console.log(error);
  //     }
  //   )
  // }

  deleteProduct(productId:number)
  {
    this.adminService.deleteProduct(productId);
    alert("Deleted");
  }

  update(){
    this.router.navigate(['/updateProduct']);
  }

  back()
  {
      this.router.navigate(['/admin']);
  }
}
