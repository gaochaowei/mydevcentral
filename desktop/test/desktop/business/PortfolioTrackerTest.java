/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package desktop.business;

import desktop.bean.Portfolio;
import desktop.bean.TradeTransaction;
import javax.persistence.EntityManager;
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
public class PortfolioTrackerTest {

    private PortfolioTracker tracker = null;

    public PortfolioTrackerTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        EntityManager entityManager = javax.persistence.Persistence.createEntityManagerFactory("desktopPU").createEntityManager();
        javax.persistence.Query query = entityManager.createQuery("select p from Portfolio p where p.id=1");
        Portfolio portfolio = (Portfolio) query.getSingleResult();
        tracker = new PortfolioTracker(portfolio);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addTradeTransaction method, of class PortfolioTracker.
     */
    @Test
    public void testAddTradeTransaction() {
        System.out.println("addTradeTransaction");
        System.out.println(tracker);
        System.out.println(tracker.getOpenPositionTrack());
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
