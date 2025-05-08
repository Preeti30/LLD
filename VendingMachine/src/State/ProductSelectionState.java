package State;

import Entity.Coin;
import Entity.Item;
import Entity.VendingMachine;

import java.util.List;

public class ProductSelectionState extends VendingMachineState{

    public ProductSelectionState()
    {
        System.out.println("VM is in Product selection state");
    }

    public void selectProduct(VendingMachine vendingMachine, int codeNumber)
    {
       Item item = vendingMachine.getInventory().getItem(codeNumber);
       int paidByUser = 0;
       List<Coin> coinList = vendingMachine.getCoinList();
       for(Coin coin: coinList)
       {
           paidByUser += coin.value;
       }
       if(paidByUser<item.getPrice())
       {
           System.out.println("Insufficient fund");
           refundMoney(vendingMachine);
       }
       else if(paidByUser>=item.getPrice())
       {
           if(paidByUser>item.getPrice())
           {
               getChange(vendingMachine, paidByUser-item.getPrice());
           }
           vendingMachine.setVendingMachineState(new DispenseProductState(vendingMachine, codeNumber));
       }
    }

    public int getChange(VendingMachine vendingMachine, int amount)
    {
        System.out.println("Returned the change in the Coin Dispense Tray: "+ amount);
        return amount;
    }
}
