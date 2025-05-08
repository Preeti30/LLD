package Observerable;

import Observer.NotificationAlertObserver;

public interface StocksObservable {
    public void add (NotificationAlertObserver observer);
    public void remove(NotificationAlertObserver observer);
    public void notifyObservers();
    public void setStockAccount(int newStockAdded);
    public int getStockAccount();
}
