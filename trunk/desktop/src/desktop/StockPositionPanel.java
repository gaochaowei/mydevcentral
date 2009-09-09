/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * StockPositionPanel.java
 *
 * Created on Sep 8, 2009, 3:18:12 PM
 */
package desktop;

import desktop.bean.Portfolio;

/**
 *
 * @author Gao.chao.wei
 */
public class StockPositionPanel extends javax.swing.JPanel {

    /** Creates new form StockPositionPanel */
    public StockPositionPanel() {
        initComponents();
    }
    public void setPortfolio(Portfolio p){
        positionList.clear();
        positionList.addAll(p.getStockPositionList());
        stockPositionsAdminPanel.setPortfolio(p);
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        entityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("desktopPU").createEntityManager();
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(desktop.DesktopApp.class).getContext().getResourceMap(StockPositionPanel.class);
        query = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery(resourceMap.getString("query.query")); // NOI18N
        positionList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(query.getResultList());
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        stockPositionsAdminPanel = new desktop.StockPositionsAdminPanel();

        setName("Form"); // NOI18N

        jTabbedPane1.setName("jTabbedPane1"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jTable1.setName("jTable1"); // NOI18N

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, positionList, jTable1);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${stock.name}"));
        columnBinding.setColumnName("Stock.name");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${quantity}"));
        columnBinding.setColumnName("Quantity");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${buyDate}"));
        columnBinding.setColumnName("Buy Date");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${pricePaid}"));
        columnBinding.setColumnName("Price Paid");
        columnBinding.setColumnClass(Double.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${comission}"));
        columnBinding.setColumnName("Comission");
        columnBinding.setColumnClass(Double.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getColumn(0).setHeaderValue(resourceMap.getString("jTable1.columnModel.title5")); // NOI18N
        jTable1.getColumnModel().getColumn(1).setHeaderValue(resourceMap.getString("jTable1.columnModel.title1")); // NOI18N
        jTable1.getColumnModel().getColumn(2).setHeaderValue(resourceMap.getString("jTable1.columnModel.title2")); // NOI18N
        jTable1.getColumnModel().getColumn(3).setHeaderValue(resourceMap.getString("jTable1.columnModel.title3")); // NOI18N
        jTable1.getColumnModel().getColumn(4).setHeaderValue(resourceMap.getString("jTable1.columnModel.title4")); // NOI18N

        jTabbedPane1.addTab(resourceMap.getString("jScrollPane1.TabConstraints.tabTitle"), jScrollPane1); // NOI18N

        stockPositionsAdminPanel.setName("stockPositionsAdminPanel"); // NOI18N
        jTabbedPane1.addTab(resourceMap.getString("stockPositionsAdminPanel.TabConstraints.tabTitle"), stockPositionsAdminPanel); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
        );

        bindingGroup.bind();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager entityManager;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private java.util.List<desktop.bean.StockPosition> positionList;
    private javax.persistence.Query query;
    private desktop.StockPositionsAdminPanel stockPositionsAdminPanel;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}