package Entity;

public class Item {

    public Item()
    {

    }
    public Item(int price, ItemType itemType) {
        this.price = price;
        this.itemType = itemType;
    }

    public int getPrice() {
        return price;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    ItemType itemType;
    int price;
}
