import { Moment } from "moment";

export class Supplier{
    id!: number;
    name!: string;
    indirizzo!: string;
    email!: string;
    telefono!: string;
    nazione!: string;
    note!: string;
    createAt!: Moment;
    updateAt!: Moment;
    deletedAt!: Moment;
}

export class SupplierInsert{
    name!: string;
    indirizzo!: string;
    email!: string;
    telefono!: string;
    nazione!: string;
    note!: string;
}

export class SupplierUpdate{
    id!: number;
    name!: string;
    indirizzo!: string;
    email!: string;
    telefono!: string;
    nazione!: string;
    note!: string;
}