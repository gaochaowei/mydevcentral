/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package desktop.net;

import desktop.bean.Price;
import desktop.bean.PricePK;
import desktop.util.CommonUtils;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.skife.csv.CSVReader;
import org.skife.csv.SimpleReader;

/**
 *
 * @author Gao.chao.wei
 */
public class SGXMarketReader {

    private final static String SGX_HISTORIC_PRICE_DOWNLOAD_URL = "http://info.sgx.com/webprices.nsf/SecuritiesHistoricalPrice/%s/$File/SESPrice.dat";

    public static List<Price> fetchStockPriceList(Date date) {
        List<Price> priceList = new ArrayList<Price>();
        String url = String.format(SGX_HISTORIC_PRICE_DOWNLOAD_URL, CommonUtils.format(date, "yyyy-MM-dd"));
        System.out.println(url);
        List<String[]> items = null;
        try {
            URL priceUrl = new URL(url);
            InputStream in = priceUrl.openStream();
            CSVReader reader = new SimpleReader();
            reader.setSeperator(';');
            reader.setTrim(true);
            items = reader.parse(in);
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (items != null) {
            for (String[] ss : items) {
                if (ss.length > 14) {
                    Price px = new Price();
                    PricePK pk = new PricePK(ss[14]+".SI", CommonUtils.parse(ss[0], "yyyy-MM-dd"));
                    px.setPricePK(pk);
                    px.setPriceOpen(Double.parseDouble(ss[12]));
                    px.setPriceHigh(Double.parseDouble(ss[4]));
                    px.setPriceLow(Double.parseDouble(ss[5]));
                    px.setPriceClose(Double.parseDouble(ss[6]));
                    px.setTradeVolumn(Integer.parseInt(ss[8]));
                    px.setPriceAdj(Double.parseDouble(ss[6]));
                    priceList.add(px);
                }
            }
        }
        return priceList;
    }
}
