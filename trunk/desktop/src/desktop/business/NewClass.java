/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package desktop.business;

import desktop.bean.TradeTransaction;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Gao.chao.wei
 */
public interface NewClass {

    void openTransaction(TradeTransaction txOpen);

    void closeTransaction(TradeTransaction txClose, List<TradeTransaction> txOpenList);

    int getOpenQuantity(String symbol, Date date);

    int getCloseQuantity(String symbol, Date date);
}
