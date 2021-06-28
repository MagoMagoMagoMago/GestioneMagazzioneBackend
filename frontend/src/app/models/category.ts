import { Moment } from "moment";

export class Category{
    id!: number;
    name!: string;
    description!: string;
    createAt!: Moment;
    updateAt!: Moment;
    deleteAt!: Moment;
}