package Entity;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    public ItemShelf[] getInventory() {
        return inventory;
    }

    public void setInventory(ItemShelf[] inventory) {
        this.inventory = inventory;
    }

    ItemShelf[] inventory=null;
    public Inventory(int itemShelfCount) {
        inventory = new ItemShelf[itemShelfCount];
        initialEmptyInventory();
    }

    public void initialEmptyInventory()
    {
        int code = 101;
        for(int i=0;i<inventory.length;i++)
        {
            ItemShelf itemShelf = new ItemShelf();
            itemShelf.setCode(code);
            itemShelf.setSoldout(true);
            inventory[i] = itemShelf;
            code++;
        }
    }

    public void addItem(Item item, int codeNumber)
    {
        for(ItemShelf itemShelf:inventory)
        {
            if(itemShelf.code == codeNumber)
            {
                if(itemShelf.isSoldout()) {
                    itemShelf.setItem(item);
                    itemShelf.setSoldout(false);
                }
            }
        }
    }

    public void updateSoldItem(int codeNumber)
    {
        for(ItemShelf itemShelf: inventory)
        {
            if(itemShelf.code == codeNumber)
            {
                itemShelf.setSoldout(true);
            }
        }
    }

    public Item getItem(int codeNumber)
    {
        Item returnItem = null;
        for(ItemShelf itemShelf: inventory)
        {
            if(itemShelf.code == codeNumber)
            {
                if(itemShelf.soldout) {
                    System.out.println("Item is sold out");
                    break;
                }
                else
                {
                    returnItem = itemShelf.item;
                }
            }
        }
        return returnItem;
    }
}
