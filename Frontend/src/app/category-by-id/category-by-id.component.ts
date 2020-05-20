import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { AdminService } from '../admin.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-category-by-id',
  templateUrl: './category-by-id.component.html',
  styleUrls: ['./category-by-id.component.css']
})
export class CategoryByIdComponent implements OnInit {

  id:number;
  updateCategory: String;
  message:any;
  msg:any;
  idForm: FormGroup;
  submitted: boolean=false;


  constructor(private formBuilder: FormBuilder, private adminService: AdminService, private router: Router) { }

  ngOnInit(){
    this.idForm=this.formBuilder.group({
      id:['',Validators.required],
      updateCategory:['',Validators.required]
    });
  }

  updateId(){
    this.submitted=true;
    this.id = this.idForm.controls.id.value;
    this.updateCategory = this.idForm.controls.updateCategory.value;
    this.adminService.updateCategoryById(this.id,this.updateCategory).subscribe( data=>{
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
