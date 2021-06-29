import { Moment } from "moment";

export class Purchases {
    id!: number;
    number_invoice!: number;
    note!: string; 
    date_invoice!: Date;
    supplier!: string;
    createdAt!: Moment;
    updateAt!: Moment;
    deletedAt!: Moment;
}