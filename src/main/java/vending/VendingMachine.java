package vending;

import java.util.List;

/**
 *
 * @author Omkar
 */
public interface VendingMachine {

    public long selectItemAndGetPrice(Item item)throws SoldOutException;

    public void insertCoin(Coin coin);

    public List<Coin> refund()throws NotSufficientChangeException,NotFullPaidException;

    public Bucket<Item, List<Coin>> collectItemAndChange()throws NotSufficientChangeException,NotFullPaidException;

    public void reset();
}
