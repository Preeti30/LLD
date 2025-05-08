package Observer;

import Observerable.StocksObservable;

public class EmailObserver implements NotificationAlertObserver{

    StocksObservable observable;
    String emailId;
    public EmailObserver(StocksObservable observable, String emailID)
    {
        this.observable = observable;
        this.emailId = emailID;
    }
    public void update()
    {
        //obj.getStockAccount();
        sendEmail();
    }

    private void sendEmail() {
        System.out.println("Send email");
    }
}
