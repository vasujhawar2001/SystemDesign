package DigitalWallet;
import java.util.*;

public class WalletDao {
    private Map<Integer, Wallet> accountMap;

    public WalletDao() {
        this.accountMap = new HashMap<>();;
    }
    public Map<Integer, Wallet> getAccountMap() {
        return accountMap;
    }
    public void setAccountMap(Map<Integer, Wallet> accountMap) {
        this.accountMap = accountMap;
    }
}
