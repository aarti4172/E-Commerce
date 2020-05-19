export class Transaction{
    transaction_id:number;
    order_id:number;
    transaction_date:Date;
    transaction_money:number;
    transaction_method:String;//credit,debit,UPI,Wallet
    transaction_status:String;//Success,Fail,Pending
}