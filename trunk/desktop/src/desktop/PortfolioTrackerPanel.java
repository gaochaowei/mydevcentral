/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PortfolioTrackerPanel.java
 *
 * Created on Sep 16, 2009, 2:05:20 PM
 */
package desktop;

import desktop.bean.Price;
import desktop.bean.StockPosition;
import desktop.business.PortfolioTracker;
import desktop.business.PriceHelper;
import desktop.util.CommonUtils;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.apache.commons.lang.time.DateUtils;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;

/**
 *
 * @author Gao.chao.wei
 */
public class PortfolioTrackerPanel extends javax.swing.JPanel {

    private PortfolioTracker tracker;

    /** Creates new form PortfolioTrackerPanel */
    public PortfolioTrackerPanel() {
        initComponents();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            public void run() {
                JFrame frame = new JFrame();
                PortfolioTrackerPanel pp = new PortfolioTrackerPanel();
                frame.setContentPane(pp);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }

    public void setPortfolioTracker(PortfolioTracker tracker) {
        this.tracker = tracker;
        this.setLayout(new BorderLayout());
        this.add(createDemoPanel(), BorderLayout.CENTER);
    }

    public JPanel createDemoPanel() {
        return new ChartPanel(createChart(createDataset()));
    }

    private XYDataset createDataset() {
        TimeSeries timeseries1 = new TimeSeries("Market Value");
        TimeSeries timeseries2 = new TimeSeries("Cost");
        TimeSeries timeseries3 = new TimeSeries("Realized Profit");
        TimeSeries timeseries4 = new TimeSeries("Unrealized Profit");
        TimeSeries timeseries5 = new TimeSeries("Commission");
        List<Date> dateList = tracker.getOpenPositionTrack().getDateList();
        if (dateList.size() > 0) {
            Date date = dateList.get(0);
            while (date.before(new Date())) {
                Day day = new Day(date);
                double value = 0;
                double cost = 0;
                List<StockPosition> ps = tracker.getOpenPositionList(date);
                boolean marketDay = false;
                for (StockPosition p : ps) {
                    Price pc = PriceHelper.getPrice(p.getOpenTransaction().getStock().getSymbol(), date);
                    cost += p.getOpenTransaction().getPrice() * p.getQuantity();
                    if (pc != null) {
                        marketDay = true;
                        value += pc.getPriceAdj() * p.getQuantity();
                    }else{
                        marketDay = false;
                        break;
                    }
                }
//                System.out.println("+++ " + date + " " + dateList);
                if (marketDay) {
                    timeseries1.add(day, value);
                    timeseries4.add(day, value - cost);
//                    System.out.println("\tmarket date " + date + " " + (value - cost));
                }

                if (dateList.contains(date)) {
                    if (ps.size() == 0) {
                        timeseries1.add(day, 0);
                        timeseries4.add(day, 0);
                        cost = 0;
                    }
                    timeseries2.add(day, cost);
                    double rp = 0;
                    for (StockPosition p : tracker.getClosePositionList(date)) {
                        rp += p.getQuantity() * (p.getCloseTransaction().getPrice() - p.getOpenTransaction().getPrice());
                    }
                    timeseries3.add(day, rp);
//                    System.out.println("\t*** " + day + " " + value + " " + cost + " " + rp + " " + (value - cost));
                }
                //get close position list                
                date = DateUtils.addDays(date, 1);
                date = CommonUtils.sqlDate(date);
//                date = DateUtils.truncate(date, Calendar.DATE);
            }
        }

        TimeSeriesCollection timeseriescollection = new TimeSeriesCollection();
        timeseriescollection.addSeries(timeseries1);
        timeseriescollection.addSeries(timeseries2);
        timeseriescollection.addSeries(timeseries3);
        timeseriescollection.addSeries(timeseries4);
        return timeseriescollection;
    }

    private static JFreeChart createChart(XYDataset xydataset) {
        JFreeChart jfreechart = ChartFactory.createTimeSeriesChart("Portfolio Performance", "Date", "Value($)", xydataset, true, true, false);
        XYPlot xyplot = (XYPlot) jfreechart.getPlot();
        xyplot.setDomainPannable(true);
        xyplot.setRangePannable(false);
        xyplot.setDomainCrosshairVisible(true);
        xyplot.setRangeCrosshairVisible(true);
        org.jfree.chart.renderer.xy.XYItemRenderer xyitemrenderer = xyplot.getRenderer();
        if (xyitemrenderer instanceof XYLineAndShapeRenderer) {
            XYLineAndShapeRenderer xylineandshaperenderer = (XYLineAndShapeRenderer) xyitemrenderer;
            xylineandshaperenderer.setBaseShapesVisible(false);
        }
        DateAxis dateaxis = (DateAxis) xyplot.getDomainAxis();
        dateaxis.setDateFormatOverride(new SimpleDateFormat("dd/MM/yyyy"));
        return jfreechart;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setName("Form"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
