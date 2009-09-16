/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package desktop.business;

import desktop.bean.Price;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;

/**
 *
 * @author Gao.chao.wei
 */
public class PriceHelper {

    private static Map<String, Map<Date, Price>> priceMap = new HashMap<String, Map<Date, Price>>();
    private static Map<String, Price> lastestPriceMap = new HashMap<String, Price>();

    public static Price getPrice(String stockSymbol) {
        if (!priceMap.containsKey(stockSymbol)) {
            addPriceList(stockSymbol);
        }
        return lastestPriceMap.get(stockSymbol);
    }

    public static Price getPrice(String stockSymbol, Date date) {
        if (!priceMap.containsKey(stockSymbol)) {
            addPriceList(stockSymbol);
        }
        return priceMap.get(stockSymbol).get(date);
    }

    private static void addPriceList(String stockSymbol) {
        EntityManager entityManager = javax.persistence.Persistence.createEntityManagerFactory("desktopPU").createEntityManager();
        javax.persistence.Query query = entityManager.createQuery("select p from Price p where p.stock.symbol='" + stockSymbol + "'");
        Map<Date, Price> map = new HashMap<Date, Price>();
        List<Price> priceList = query.getResultList();
        for (Price p : priceList) {
            map.put(p.getPricePK().getPriceDate(), p);
        }
        priceMap.put(stockSymbol, map);
        if (priceList.size() > 0) {
            lastestPriceMap.put(stockSymbol, priceList.get(priceList.size() - 1));
        }
    }
}
