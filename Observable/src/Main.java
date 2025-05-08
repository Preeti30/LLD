import Observer.EmailObserver;
import Observer.MobileObserver;
import Observer.NotificationAlertObserver;
import Observerable.IphoneObservable;
import Observerable.StocksObservable;

import java.lang.module.ModuleFinder;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        StocksObservable observable = new IphoneObservable();
        NotificationAlertObserver observer1 = new EmailObserver(observable, "preetics");
        NotificationAlertObserver observer2 = new MobileObserver(observable, "preeti");
        observable.add(observer1);
        observable.add(observer2);
        observable.setStockAccount(10);

    }
}