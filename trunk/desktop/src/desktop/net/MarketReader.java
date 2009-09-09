package desktop.net;

import desktop.bean.Price;
import desktop.bean.PricePK;
import desktop.bean.Stock;
import desktop.util.CommonUtils;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;



public class MarketReader {

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
        CSVFile csv = readCSV(url, false);
        List<Stock> cpv = new ArrayList<Stock>();
        for (String[] ss : csv.data) {
            Stock eq = new Stock();
            eq.setSymbol(ss[0]);
            eq.setName(ss[1]);
            cpv.add(eq);
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
            from = CommonUtils.parse("01/01/1000");
        }
        if (to == null) {
            to = new Date();
        }
        int monthFrom = CommonUtils.getMonth(from);
        int monthTo = CommonUtils.getMonth(to);
        String url = String.format(YAHOO_STOCK_PRICE_URL,
                symbol, from, to, freq.symbol, monthFrom, monthTo);
        CSVFile csv = readCSV(url, true);
        List<Price> pxs = new ArrayList<Price>();
        for (String[] ss : csv.data) {
            Price px = new Price();
            PricePK pk = new PricePK(symbol,CommonUtils.parse(ss[0], "yyyy-MM-dd"));
            px.setPricePK(pk);
            px.setPriceOpen(Double.parseDouble(ss[1]));
            px.setPriceHigh(Double.parseDouble(ss[2]));
            px.setPriceLow(Double.parseDouble(ss[3]));
            px.setPriceClose(Double.parseDouble(ss[4]));
            px.setTradeVolumn(Integer.parseInt(ss[5]));
            px.setPriceAdj(Double.parseDouble(ss[6]));
            pxs.add(0, px);
        }
        return pxs;
    }

    private static CSVFile readCSV(String url, boolean hasHeader) {
        System.out.println(url);
        CSVFile csv = new CSVFile();
        try {
            URL yahoo = new URL(url);
            URLConnection yc = yahoo.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
            String line;
            if (hasHeader && !StringUtils.isEmpty(line = in.readLine())) {
                csv.header = readRow(line);
                System.out.println("> " + line);
            }
            List<String[]> datav = new ArrayList<String[]>();
            while (!StringUtils.isEmpty(line = in.readLine())) {
                System.out.println("> " + line);
                datav.add(readRow(line));
            }
            csv.data = new String[datav.size()][];
            datav.toArray(csv.data);
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return csv;
    }
    private static String[] readRow(String row){
        String []ss = StringUtils.split(row, ",");
        for(int i=0;i<ss.length;i++){
            String s = ss[i];
            if(s.startsWith("\"")&&s.endsWith("\"")){
                s = s.substring(1,s.length()-1);
                ss[i]=s;
            }
        }
        return ss;
    }
}
