import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms'
import { AdminServiceService } from '../admin-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-category-by-category',
  templateUrl: './category-by-category.component.html',
  styleUrls: ['./category-by-category.component.css']
})
export class CategoryByCategoryComponent implements OnInit {

  prCategory: String;
  updateCategory: String;
  message:any;
  msg:any;
  categoryForm: FormGroup;
  submitted: boolean=false;
  constructor(private formBuilder: FormBuilder, private adminService: AdminServiceService, private router: Router) { }

  ngOnInit(){
    this.categoryForm=this.formBuilder.group({
      prCategory:['',Validators.required],
      updateCategory:['',Validators.required]
    });
  }

  updateCate(){
    this.submitted=true;
    this.prCategory = this.categoryForm.controls.prCategory.value;
    this.updateCategory = this.categoryForm.controls.updateCategory.value;
    this.adminService.updateCategoryByCategory(this.prCategory,this.updateCategory).subscribe( data=>{
      this.prCategory = this.categoryForm.controls.prCategory.value;
      this.message = data;
      if(this.message==true){
        this.msg="You have successfully updated the category";
        alert(this.msg);
        this.router.navigate(['/productList']);
    }}, err => 
    { console.log(err.stack);
    });
  }

  back(){
    this.router.navigate(['/updateCategory']);
  }

}


