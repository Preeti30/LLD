package Observer;

import Observerable.StocksObservable;
public class MobileObserver implements NotificationAlertObserver {

    StocksObservable observable;
    String userName;

    public MobileObserver(StocksObservable observable, String name)
    {
        this.observable = observable;
        this.userName = name;
    }


    public void update()
    {
        sendMessage();
    }

    private void sendMessage() {
        System.out.println("Message sent to" + userName);
    }
}
