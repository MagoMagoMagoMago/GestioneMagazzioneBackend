import { Injectable } from '@angular/core';
import { ItemToCart } from 'src/app/models/cart';
import { Item } from 'src/app/models/item';

@Injectable({
  providedIn: 'root'
})
export class CartService {
  quanityItemsToCart: number = Number(sessionStorage.getItem("quantityItemsToCart"));
  itemsToCart: Item[] = JSON.parse(sessionStorage.getItem("itemsToCart")!);

  constructor() { }

  public addItemToCartSessionStorage(item: Item, quantity: number): void{
    let items: ItemToCart[] = this.getItemsOnCartSessionStorage();

    let itemOnCart = items.findIndex(x => x.item.id == item.id);
    if(itemOnCart >= 0){
      items[itemOnCart] = {item: item, quantity: items[itemOnCart].quantity + quantity};
    }else{
      items.push({item: item, quantity: quantity});
    }
    
    sessionStorage.setItem("itemsToCart", JSON.stringify(items));
  }

  public getItemsOnCartSessionStorage(): ItemToCart[] {
    if (sessionStorage.getItem("itemsToCart") != null) {
      return JSON.parse(sessionStorage.getItem("itemsToCart")!);
    }else{
      return [];
    }
  }

  public clearItemsOnCartSessionStorage(): void {
    sessionStorage.setItem("itemsToCart", JSON.stringify([]));
  }

  public setQuantity(item: ItemToCart): void{
    let items: ItemToCart[] = this.getItemsOnCartSessionStorage();

    if (item.quantity > 0) {
      items.find(x => x.item.id == item.item.id)!.quantity = item.quantity;
    }else{
      items = items.filter(x => x.item.id !==item.item.id);
    }
    sessionStorage.setItem("itemsToCart", JSON.stringify(items));
  }

  public getTotalAmount(): number{
    let total: number = 0;
    this.getItemsOnCartSessionStorage().forEach(element => {
      total = total + (element.quantity * element.item.price);
    });
    return total;
  }
}
