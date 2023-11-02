package OnlineAuction;

public class BidderImpl implements Bidder{
    String name;
    AuctionMediator am;
    public BidderImpl(String name, AuctionMediator am){
        this.name = name;
        this.am = am;
        am.addBidder(this);
    }
    @Override
    public void placeBid(int bidAmount) {
        am.placeBid(this, bidAmount);
    }

    @Override
    public void recieveBidNotification(int bid) {
        System.out.println("Bidder: "+name+" you have a notification, someone put a bid of "+bid+" amount");
    }

    @Override
    public String getName() {
        return name;
    }
}
