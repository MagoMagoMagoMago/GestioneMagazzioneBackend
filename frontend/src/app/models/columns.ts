export class Column{
    name!: string;
    text!: string;
    visible!: boolean;

    constructor(name: string, text: string, visible: boolean){
        this.name = name;
        this.text = text;
        this.visible = visible;
    }
}