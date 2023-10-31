package ObserverPattern.Observable;

import ObserverPattern.Observer.NotificationAlertObserver;

import javax.management.Notification;
import java.util.ArrayList;
import java.util.List;

public class IphoneObservable implements StockObservable{
    public List<NotificationAlertObserver> list = new ArrayList<>();
    public int stockCount = 0;

    public void add(NotificationAlertObserver obj) {
        list.add(obj);
    }


    public void remove(NotificationAlertObserver obj) {
        list.remove(obj);
    }

    public void notifySubscribers() {
        for(NotificationAlertObserver obj : list){
            obj.update();
        }
    }

    @Override
    public void setStockCount() {

    }

    public void setStockCount(int newStock) {
        if(stockCount==0){
            notifySubscribers();
        }
        stockCount += newStock;
    }

    public int getStockCount() {
        return stockCount;
    }
}
