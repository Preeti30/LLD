package State;

import Entity.Item;
import Entity.VendingMachine;

public class DispenseProductState extends VendingMachineState
{

    public DispenseProductState(VendingMachine vendingMachine, int codeNumber)
    {
        System.out.println("VM is in dispense state");
        dispenseProduct(vendingMachine, codeNumber);
    }
    public void dispenseProduct(VendingMachine vendingMachine, int codeNumber)
    {
        System.out.println("Dispensing the product for " + codeNumber);
         Item item = vendingMachine.getInventory().getItem(codeNumber);
         vendingMachine.getInventory().updateSoldItem(codeNumber);
         System.out.println("Product has been dispensed");
         vendingMachine.setVendingMachineState(new IdleState());
    }
}
