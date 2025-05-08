package Entity;

public class ItemShelf {
//    public ItemShelf(Item item, int code, boolean soldout) {
//        this.item = item;
//        this.code = code;
//        this.soldout = soldout;
//    }

    Item item;

    public int getCode() {
        return code;
    }

    public Item getItem() {
        return item;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    int code;

    public boolean isSoldout() {
        return soldout;
    }

    public void setSoldout(boolean soldout) {
        this.soldout = soldout;
    }

    boolean soldout;

}
