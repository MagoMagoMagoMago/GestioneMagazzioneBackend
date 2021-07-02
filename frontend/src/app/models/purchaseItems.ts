import { Moment } from "moment";

export class PurchaseItems{
    
    id!: number; 
    purchase_id!: number; 
    item!: string;
    quantity!: number; 
    unit_price!: number; 
    created_at!: Date; 
    updated_at!: Moment; 
    deleted_at!: Moment; 

}