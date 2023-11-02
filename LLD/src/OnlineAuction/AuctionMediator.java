package OnlineAuction;

public interface AuctionMediator {
    void addBidder(Bidder bidder);
    void placeBid(Bidder bidder, int bidAmount);
}
