import { Component, OnInit } from '@angular/core';
import { CommonFeedback} from 'src/app/models/CommonFeedBack';
import { Router } from '@angular/router';
import { AdminService } from 'src/app/service/admin.service';


@Component({
  selector: 'app-cfd',
  templateUrl: './getAllCommonFeedBack.component.html'
})
export class GetAllCommonFeedBackComponent implements OnInit {

  cfdList: CommonFeedback[];
  searchTerm;


  constructor(private router:Router,
    private adminService:AdminService) { }


    

    approveRequest(feedbackId){
      this.adminService.forwardRequestToMerchant(feedbackId).subscribe();
    

  }

    approveResponse(feedbackId){
      this.adminService.forwardResponseToCustomer(feedbackId).subscribe()
  }

    
  ngOnInit(){
    this.adminService.getAllCommonFeedback().subscribe(
        data=>{
            this.cfdList=data;
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


}

