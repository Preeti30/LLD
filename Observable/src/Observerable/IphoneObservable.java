package Observerable;

import Observer.NotificationAlertObserver;

import java.util.ArrayList;
import java.util.List;

public class IphoneObservable implements StocksObservable {
    List<NotificationAlertObserver> observerList = new ArrayList<>();
    public int stockCount = 0;

    @Override
    public void add(NotificationAlertObserver observer) {
        observerList.add(observer);
    }

    @Override
    public void remove(NotificationAlertObserver observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(NotificationAlertObserver observer:observerList)
        {
            observer.update();
        }
    }

    @Override
    public void setStockAccount(int newStockAdded) {
            if(stockCount==0)
                notifyObservers();
            stockCount += newStockAdded;
    }

    @Override
    public int getStockAccount() {
        return stockCount;
    }
}
