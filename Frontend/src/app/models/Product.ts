import { ProductFeedback } from './ProductFeedback';
import { Cart } from './Cart';

export class Product{
    product_id:number;
	product_name:String;
	product_image:String;
	product_price: DoubleRange;
	product_rating:number;
	no_of_product_viewed:number;
	product_brand:String;
	no_of_products:number;
    product_info:String;
    discount:number;
    product_category:String;
    product_activated: Boolean;
    status:boolean;
    featured:boolean;
    user_id:number;
    productfeedbacks: ProductFeedback;
    customerCarts:Cart;

}