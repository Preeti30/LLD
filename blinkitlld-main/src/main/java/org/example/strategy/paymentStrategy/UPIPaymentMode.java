package org.example.strategy.paymentStrategy;

import org.example.strategy.PaymentMode;

public class UPIPaymentMode implements PaymentMode {

    @Override
    public boolean makePayment() {
        return true;
    }
}
