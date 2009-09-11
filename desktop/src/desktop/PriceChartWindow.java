/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PriceChartWindow.java
 *
 * Created on Sep 7, 2009, 2:23:53 PM
 */
package desktop;

import desktop.bean.Price;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.Day;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.ohlc.OHLCSeries;
import org.jfree.data.time.ohlc.OHLCSeriesCollection;

/**
 *
 * @author Gao.chao.wei
 */
public class PriceChartWindow extends javax.swing.JInternalFrame {

    /** Creates new form PriceChartWindow */
    public PriceChartWindow() {
        super();
        initComponents();
        OHLCSeries data = new OHLCSeries("D05.SI");
        for (Price p : list) {
            RegularTimePeriod t = new Day(p.getPricePK().getPriceDate());
            data.add(t, p.getPriceOpen(), p.getPriceHigh(), p.getPriceLow(), p.getPriceClose());
            if (data.getItemCount() > 10) {
                break;
            }
        }
        OHLCSeriesCollection ds = new OHLCSeriesCollection();
        ds.addSeries(data);
        org.jfree.chart.JFreeChart c = ChartFactory.createCandlestickChart("D05.SI", "Date", "Price", ds, false);
        XYPlot xyplot = (XYPlot) c.getPlot();
        xyplot.setDomainPannable(true);
        NumberAxis numberaxis = (NumberAxis) xyplot.getRangeAxis();
        numberaxis.setAutoRangeIncludesZero(false);
        numberaxis.setUpperMargin(0.0D);
        numberaxis.setLowerMargin(0.0D);

        org.jfree.chart.ChartPanel cp = new ChartPanel(c);
        cp.setMouseWheelEnabled(true);
        this.setContentPane(cp);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        entityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("desktopPU").createEntityManager();
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(desktop.DesktopApp.class).getContext().getResourceMap(PriceChartWindow.class);
        query = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery(resourceMap.getString("query.query")); // NOI18N
        list = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(query.getResultList());

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setName("Form"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 394, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 278, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager entityManager;
    private java.util.List<desktop.bean.Price> list;
    private javax.persistence.Query query;
    // End of variables declaration//GEN-END:variables
}