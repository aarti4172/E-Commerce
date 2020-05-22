import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AdminService } from 'src/app/service/admin.service';

@Component({
  selector: 'app-update-category',
  templateUrl: './update-category.component.html',
  styleUrls: ['./update-category.component.css']
})
export class UpdateCategoryComponent implements OnInit {

  prCategory: String;
  updateCategory: String;
  message:any;
  msg:any;
  categoryForm: FormGroup;
  submitted: boolean=false;

  constructor(private formBuilder: FormBuilder, private adminService: AdminService, private router: Router) { }

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
        this.router.navigate(['/showProduct']);
    }
    else{
      this.msg="Please enter correct category";
      alert(this.msg);
      this.router.navigate(['/updateCategory']);
    }
  }, err => 
    { console.log(err.stack);
    });
  }

  back(){
    this.router.navigate(['/showProduct']);
  }

}
