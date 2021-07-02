import { Moment } from "moment";

export class Purchases {
    id!: number;
    numberInvoice!: number;
    note!: string; 
    dateInvoice!: Date;
    supplier!: string;
    createdAt!: Moment;
    updateAt!: Moment;
    deletedAt!: Moment;
}

export class PurchaseInsert{
    id!: number | null;
    number_invoice!: number;
    note!: string; 
    date_invoice!: string;
    supplier!: { id: number};
    createdAt = null;
    updateAt = null;
    deletedAt = null;
}

export class PurchaseItem{ 
    id!: number | null;
    purchase_id!: number; 
    item_id!: number;
    quantity!: number;
    unit_price!: number; 
    created_at = null;
    updated_at = null; 
    deleted_at = null;
}