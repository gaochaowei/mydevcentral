/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package desktop.net;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gao.chao.wei
 */
public class MarketReaderTest {

    public MarketReaderTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of fetchStockList method, of class YahooMarketReader.
     */
    @Test
    public void testFetchStockList() {
        System.out.println("fetchStockList");
        String indexSymbol = "^STI";
        List result = YahooMarketReader.fetchStockList(indexSymbol);
        assertTrue(result!=null&&result.size()>0);
        fail("The test case is a prototype.");
    }
}