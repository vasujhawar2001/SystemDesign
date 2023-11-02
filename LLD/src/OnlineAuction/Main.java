package OnlineAuction;

public class Main {
    // SIMILAR QUESTIONS
    // 1) Airline Management System
    // 2) chat application
    /*
    Mediator pattern is similar to
    1) Observer Pattern   - Observer , Observables
    2) Proxy pattern - Reason - Lazy Loading, Logging
     */
    public static void main(String[] args) {
        AuctionMediator am = new Auction();
        Bidder bidder1 = new BidderImpl("A", am);
        Bidder bidder2 = new BidderImpl("B", am);
        Bidder bidder3 = new BidderImpl("C", am);

        bidder1.placeBid(1000);
        bidder2.placeBid(1500);
        bidder3.placeBid(2500);
        bidder2.placeBid(4000);
    }
}
