package Entity;

import State.IdleState;
import State.VendingMachineState;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    public VendingMachineState getVendingMachineState() {
        return vendingMachineState;
    }
    public VendingMachine()
    {
        System.out.println("In VM");
        vendingMachineState = new IdleState();
        coinList = new ArrayList<>();
        inventory = new Inventory(10);
    }

    public void setVendingMachineState(VendingMachineState vendingMachineState) {
        this.vendingMachineState = vendingMachineState;
    }

    private VendingMachineState vendingMachineState;

    public List<Coin> getCoinList() {
        return coinList;
    }

    public void setCoinList(List<Coin> coinList) {
        this.coinList = coinList;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    private List<Coin> coinList;
    private Inventory inventory;

}
