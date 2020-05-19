import { order_products } from './order_products';
import { Transaction } from './Transaction';

export class Order{
    order_id:number;
    order_amount:number;
    order_status:String;
    products:order_products;
    user_id:number;
    address_id:number;
    transaction:Transaction;
}