package OnlineAuction;

import java.util.ArrayList;
import java.util.List;

public class Auction implements  AuctionMediator{

    List<Bidder> bidderList = new ArrayList<>();
    @Override
    public void addBidder(Bidder bidder) {
        bidderList.add(bidder);
    }

    @Override
    public void placeBid(Bidder bidder, int bidAmount) {

        for(Bidder iterator: bidderList){
            if(!iterator.getName().equals(bidder.getName())){
                iterator.recieveBidNotification(bidAmount);
            }
        }

    }
}
