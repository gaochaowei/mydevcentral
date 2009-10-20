package desktop.net;

import desktop.bean.Price;
import desktop.bean.PricePK;
import desktop.bean.Stock;
import desktop.util.CommonUtils;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.skife.csv.CSVReader;
import org.skife.csv.SimpleReader;

public class YahooMarketReader {

    private final static String YAHOO_STOCK_LIST_UTL = "http://download.finance.yahoo.com/d/quotes.csv?s=@%s&f=snl1d1t1c1ohgv";
    private final static String YAHOO_STOCK_PRICE_URL = "http://ichart.finance.yahoo.com/table.csv?s=%1$s&a=%5$d&b=%2$td&c=%2$tY&d=%6$d&e=%3$td&f=%3$tY&g=%4$s&ignore=.csv";

    public enum Frequency {

        YEAR("y"), MONTH("m"), WEEK("w"), DATE("d");
        public String symbol;

        Frequency(String symbol) {
            this.symbol = symbol;
        }
    };

    public static List<Stock> fetchStockList(String indexSymbol) {
        String url = String.format(
                YAHOO_STOCK_LIST_UTL,
                indexSymbol);
        List<String[]> items = null;
        System.out.println(url);
        try {
            URL priceUrl = new URL(url);
            InputStream in = priceUrl.openStream();
            CSVReader reader = new SimpleReader();
            items = reader.parse(in);
            System.out.print(items);
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<Stock> cpv = new ArrayList<Stock>();
        for (String[] ss : items) {
            if (ss.length > 2) {
                System.out.println(ss[0]);
                Stock eq = new Stock();
                eq.setSymbol(ss[0]);
                eq.setName(ss[1]);
                cpv.add(eq);
            }
        }
        return cpv;
    }

    public static List<Price> fetchStockPrice(String symbol) {
        return fetchStockPrice(symbol, null);
    }

    public static List<Price> fetchStockPrice(String symbol,
            Date dateFrom) {
        return fetchStockPrice(symbol, dateFrom, null);
    }

    public static List<Price> fetchStockPrice(String symbol,
            Date from, Date to) {
        return fetchStockPrice(symbol, from, to, Frequency.DATE);
    }

    public static List<Price> fetchStockPrice(String symbol,
            Date from, Date to, Frequency freq) {
        if (from == null) {
            from = CommonUtils.parse("1000/01/01");
        }
        if (to == null) {
            to = new Date();
        }
        int monthFrom = CommonUtils.getMonth(from);
        int monthTo = CommonUtils.getMonth(to);
        String url = String.format(YAHOO_STOCK_PRICE_URL,
                symbol, from, to, freq.symbol, monthFrom, monthTo);
        System.out.println(url);
        List<String[]> items = null;
        try {
            URL priceUrl = new URL(url);
            InputStream in = priceUrl.openStream();
            CSVReader reader = new SimpleReader();
            items = reader.parse(in);
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<Price> pxs = new ArrayList<Price>();
        if (items != null) {
            items.remove(0);
            for (String[] ss : items) {
                if (ss.length > 5) {
                    Price px = new Price();
                    PricePK pk = new PricePK(symbol, CommonUtils.parse(ss[0], "yyyy-MM-dd"));
                    px.setPricePK(pk);
                    px.setPriceOpen(Double.parseDouble(ss[1]));
                    px.setPriceHigh(Double.parseDouble(ss[2]));
                    px.setPriceLow(Double.parseDouble(ss[3]));
                    px.setPriceClose(Double.parseDouble(ss[4]));
                    px.setTradeVolumn(Integer.parseInt(ss[5]));
                    px.setPriceAdj(Double.parseDouble(ss[6]));
                    pxs.add(0, px);
                }
            }
        }
        return pxs;
    }
}
