package ObserverPattern.Observer;

import ObserverPattern.Observable.StockObservable;

public class EmailAlert implements NotificationAlertObserver{
    String email;
    StockObservable observable;
    //constructor injection
    public EmailAlert(String email, StockObservable observable){
        this.email = email;
        this.observable = observable;
    }
    @Override
    public void update() {
        sendMail(email, "product in stock hurry up!");
    }

    private void sendMail(String email, String s) {
        System.out.println("mail send to:" + email);
    }
}
