import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Coupon } from 'src/app/models/Coupon';
import { Observable } from 'rxjs';
import { AdminService } from 'src/app/service/admin.service';

@Component({
  selector: 'app-show-promocode',
  templateUrl: './show-promocode.component.html',
  styleUrls: ['./show-promocode.component.css']
})
export class ShowPromocodeComponent implements OnInit {

  searchTerm ;
  coupon: Coupon[];
  couponId:number;
  couponCode:string;
  submitted=false;
  error=null;
  subId=true;
  subCode=true;
  
  coupon1: Coupon = new Coupon();


  constructor(private couponService: AdminService, private router: Router) { }

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
     this.couponService.getPromocodes().subscribe(
      data=>{
        this.coupon=data;
      },
      error=>{
        console.log(error);
      }
    );
  }

  searchById(){
    this.subId=false;
    this.subCode=true;
  }

  searchByCode(){
    this.subId=true;
    this.subCode=false;
  }
  deletePrromocode(Id)
  {
    this.couponService.deletePromocode(Id).subscribe(data=>{console.log(data)},error=>{console.log(error)});
    window.location.reload();
  }

 /* showCouponsById() {
    this.submitted=true;
    this.couponService.getCouponById(this.couponId, this.coupon)
    .subscribe((data) => {
      console.log(data)
      this.coupon1=data;
    }, error =>{ this.error=error;
      console.log(error.error);
      this.error=error.error.message;
      this.submitted=false
     });
  }

 /* showCouponsByCode() {
    this.submitted=true;
    this.couponService.getCouponByCode(this.couponCode,this.coupon)
    .subscribe((data) => {
      console.log(data)
      this.coupon1=data;
    }, error =>{ this.error=error;
      console.log(error.error);
      this.error=error.error;
      this.submitted=false
     });
  
    }
*/
    backToCoupons() {
      this.submitted=false;
      this.subId=true;
      this.subCode=true;
    }
  back()
  {
    
    this.router.navigate(['admin']);
    }

}
