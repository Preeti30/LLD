package Model;

public class Payment {

    public Payment()
    {

    }
    int amount;
    public int payAmount(Bill bill)
    {
        return bill.billAmount;
    }
}
