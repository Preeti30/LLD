package State;

import Entity.Item;
import Entity.VendingMachine;

import java.util.ArrayList;

public class IdleState extends VendingMachineState {

    public IdleState()
    {
        System.out.println("Currently machine is in idle state");
    }

    public void IdleState(VendingMachine vendingMachine)
    {
        vendingMachine.setCoinList(new ArrayList<>());
    }
    public void clickOnInsertCoinButton(VendingMachine vendingMachine)
    {
        vendingMachine.setVendingMachineState(new HasMoneyState());
    }
    public void updateInventory(VendingMachine vendingMachine, int codeNumber, Item item)
    {
        vendingMachine.getInventory().initialEmptyInventory();
    }
}
