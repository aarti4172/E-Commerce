import { Component, OnInit } from '@angular/core';
import { Product } from '../model/Product';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { AdminService } from '../admin.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-update-product',
  templateUrl: './update-product.component.html',
  styleUrls: ['./update-product.component.css']
})
export class UpdateProductComponent implements OnInit {

  product:Product = new Product();
  message: any;
  msg: any;
  productForm: FormGroup;
  submitted=false;

  constructor(private formBuilder: FormBuilder,private adminService: AdminService, private router: Router) { }

  ngOnInit(){
    this.productForm = this.formBuilder.group({
      id:['',Validators.required],
      name:['',[Validators.required,Validators.pattern]],
      image:['',Validators.required],
      price:['',Validators.required],
      rating:['',Validators.required],
      viewed:['',Validators.required],
      numberProducts:['',Validators.required],
      brand:['',[Validators.required,Validators.pattern]],
	    info:['',[Validators.required,Validators.pattern]],
      category:['',[Validators.required,Validators.pattern]],
      activated:['',Validators.required],
      status:['',Validators.required],
      featured:['',Validators.required]
    });
  }

  updateProduct(){
    this.submitted = true;
    if(this.productForm.invalid)
    return;
    else{
    this.adminService.update(this.product).subscribe(data => {
      console.log(data);
      this.product = new Product();
      this.message = data;
      if(this.message==true){
        this.msg="You have successfully updated the product details";
        alert(this.message);
        this.router.navigate(['/productList']);
    }}, err => 
    { console.log(err.stack);
    });
  }
  }

  back(){
    this.router.navigate(['/productList']);
  }
}