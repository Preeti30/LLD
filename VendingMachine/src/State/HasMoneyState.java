package State;

import Entity.Coin;
import Entity.VendingMachine;

import java.util.List;

public class HasMoneyState extends VendingMachineState {

    public HasMoneyState()
    {
        System.out.println("Vending Machine is in has Money state");
    }
    public void insertCoin( VendingMachine vendingMachine, Coin coin)
    {
        System.out.println("Accepting the coin");
        vendingMachine.getCoinList().add(coin);

    }
    public List<Coin> refundMoney(VendingMachine vendingMachine)
    {
        vendingMachine.setVendingMachineState(new IdleState());
        return vendingMachine.getCoinList();
    }

    public void clickOnProductSelectionButton(VendingMachine vendingMachine)
    {
        vendingMachine.setVendingMachineState(new ProductSelectionState());
    }

}
