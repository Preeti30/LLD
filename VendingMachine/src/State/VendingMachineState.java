package State;

import Entity.Coin;
import Entity.Item;
import Entity.VendingMachine;

import java.util.List;

public class VendingMachineState {

    public void clickOnInsertCoinButton(VendingMachine vendingMachine)
    {
        System.out.println("oops!! Something went wrong");
    }
    public void insertCoin( VendingMachine vendingMachine, Coin coin)
    {
        System.out.println("oops!! Something went wrong");
    }
    public void clickOnProductSelectionButton(VendingMachine vendingMachine)
    {
        System.out.println("oops!! Something went wrong");
    }
    public void selectProduct(VendingMachine vendingMachine, int codeNumber)
    {
        System.out.println("oops!! Something went wrong");
    }
    public void dispenseProduct(VendingMachine vendingMachine, int codeNumber)
    {
        System.out.println("oops!! Something went wrong");
    }
    public int getChange(VendingMachine vendingMachine, int changeMoney)
    {
        System.out.println("oops!! Something went wrong");
        return 0;
    }
    public List<Coin> refundMoney(VendingMachine vendingMachine)
    {
        System.out.println("oops!! Something went wrong");
        return null;
    }
    public void clickOnCancelButton(VendingMachine vendingMachine)
    {
        System.out.println("oops!! Something went wrong");
    }
    public void updateInventory(VendingMachine vendingMachine, int codeNumber, Item item)
    {
        System.out.println("oops!! Something went wrong");
    }
}
