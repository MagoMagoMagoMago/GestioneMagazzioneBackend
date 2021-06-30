import { Moment } from "moment";

export class PurchaseItems{
    
    id!: number; 
    purchase_id!: number; 
    item_id!: number; 
    quantity!: number; 
    unit_price!: number; 
    created_at!: Date; 
    updated_at!: Moment; 
    deleted_at!: Moment; 

}