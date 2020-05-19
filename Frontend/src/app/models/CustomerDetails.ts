import { CommonFeedback } from './CommonFeedback';
import { Cart } from './Cart';
import { ProductFeedback } from './ProductFeedback';
import { UserAddress } from './UserAddress';
import { Order } from './Order';
import { User } from './User';

export class CustomerDetails  extends User{
    
	phone_number : String;
	alternate_phone_number: String;
    alternate_email:String;
	address:String;
	common_feedback:CommonFeedback;
	product_feedback:ProductFeedback;
	orders:Order;
	cart:Cart;
	addresses:UserAddress;

	constructor(name: any, username: any, password: any, eMail: any, role: any, isActive: any, securityQuestion: any, securityAnswer: any,phone_number: any,alternate_phone_number: any,alternate_email: any,
		address: any,common_feedback: any,product_feedback: any,orders: any,cart: any,addresses: any)
	{
	
		super(name,username,password,eMail,role,isActive,securityQuestion,securityAnswer);
		this.phone_number=phone_number;
		this.alternate_phone_number=alternate_phone_number;
		this.alternate_email=alternate_email;
		this.address=address;
		this.common_feedback=common_feedback;
		this.product_feedback=product_feedback;
		this.orders=orders;
		this.cart=cart;
		this.addresses=addresses;

	}
	
   
}