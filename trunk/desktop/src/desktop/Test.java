package desktop;


import desktop.bean.Portfolio;
import desktop.bean.Price;
import desktop.bean.Stock;
import desktop.bean.StockPosition;
import desktop.util.CommonUtils;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gao.chao.wei
 */
public class Test {

    public static Stock getStock(){
        Stock stock = new Stock();
        stock.setSymbol("D05.SI");
        stock.setName("DBS Group");
        stock.setPriceList(getPriceList());
        return stock;
    }

    public static List<Price> getPriceList(){
        List<Price> list = new ArrayList<Price>();
        return list;
    }

    public static List<Portfolio> getPortfolioList(){
        List<Portfolio> list = new ArrayList<Portfolio>();
        list.add(getPortfolio());
        return list;
    }
    public static Portfolio getPortfolio(){
        Portfolio p = new Portfolio();
        p.setId(1);
        p.setName("Test Portfolio");
        p.setRemark("this is a testing portfolio");
        return p;
    }

    public static List<StockPosition> getStockPositionList(){
        List<StockPosition> list = new ArrayList<StockPosition>();
        StockPosition p = new StockPosition();
        p.setStock(getStock());
        p.setStartDate(CommonUtils.parse("18/03/2009"));
        p.setQuantity(1000);
        p.setStartPrice(7.36);
        list.add(p);
        return list;
    }

}
