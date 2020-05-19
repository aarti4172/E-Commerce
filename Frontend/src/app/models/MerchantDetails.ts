import { Product } from './Product';
import { UserAddress } from './UserAddress';
import { ProductFeedback } from './ProductFeedback';
import { Coupon } from './Coupon';
import { User } from './User';

export class MerchantDetails extends User{
    
	phone_number : String;
	alternate_phone_number: String;
    alternate_email:String;
    products:Product;
    user_address:UserAddress;
    product_feedback:ProductFeedback;
    coupons:Coupon;
    isApproved:boolean;
    rating : number;

    constructor(name: any,username: any,password: any,eMail: any,role: any,isACtive: any,securityQueston: any,securityAnswer: any,phone_number: any,alternate_phone_number: any,alternate_email: any,products: any,user_address: any,product_feedback: any,coupons: any,isApproved: any,rating: any)
    {
        super(name,username,password,eMail,role,isACtive,securityQueston,securityAnswer);
       // super();
       // super(name,username,password,eMail,role,isActive,securityQuestion,securityAnswer);
        this.phone_number=phone_number;
        this.alternate_phone_number=alternate_phone_number;
        this.alternate_email=alternate_email;
        this.products=products;
        this.user_address=user_address;
        this.product_feedback=product_feedback;
        this.coupons=coupons;
        this,isApproved=null;
        this.rating=rating;

    }
}