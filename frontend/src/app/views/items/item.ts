import { Moment } from "moment";

export class Item {
    id!: number;
    asin!: string;
    title! : string;
    description!: string;
    price!: number;
    storage!:number;
    minAvailability!: number;
    image!: string;
    createdAt!: Moment;
    updatedAt!: Moment;
    deletedAt!: Moment;
    categoryId!: number;
}