import Entity.*;
import State.VendingMachineState;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        VendingMachine vendingMachine = new VendingMachine();
        try
        {
            System.out.println("Filling up inventory");
            fillUpInventory(vendingMachine);
            displayInventory(vendingMachine);
            System.out.println(" Click on Insert coin button");
            VendingMachineState vendingMachineState = vendingMachine.getVendingMachineState();
            vendingMachineState.clickOnInsertCoinButton(vendingMachine);
            vendingMachineState = vendingMachine.getVendingMachineState();
            vendingMachineState.insertCoin(vendingMachine, Coin.TEN);
            vendingMachineState.clickOnProductSelectionButton(vendingMachine);
            vendingMachineState = vendingMachine.getVendingMachineState();
            vendingMachineState.selectProduct(vendingMachine, 108);
            displayInventory(vendingMachine);

        }
        catch(Exception ex)
        {

        }
    }

    private static void fillUpInventory(VendingMachine vendingMachine) {

        ItemShelf[] slots = vendingMachine.getInventory().getInventory();
        for(int i=0;i<slots.length;i++)
        {
            Item newItem = new Item();
            if(i>=0 && i<3)
                newItem = new Item(2, ItemType.LAYS);
            if(i>=3 && i<5)
                newItem = new Item(3, ItemType.COKE);
            if(i>=5 && i<=10)
                newItem = new Item(5, ItemType.SHAKES);
            slots[i].setItem(newItem);
            slots[i].setSoldout(false);
        }

    }

    private static void displayInventory(VendingMachine vendingMachine)
    {
        System.out.println("Displaying inventory");
        Inventory inventory = vendingMachine.getInventory();
        ItemShelf[] itemShelves = inventory.getInventory();
        for(int i=0;i<itemShelves.length;i++)
        {
            System.out.println( " Code " + itemShelves[i].getCode() + " Price " + itemShelves[i].getItem().getPrice()
            + " ItemType " + itemShelves[i].getItem().getItemType() + " Slot available " + !itemShelves[i].isSoldout());
        }
    }
}