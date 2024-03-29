/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PortfolioWindow.java
 *
 * Created on Sep 8, 2009, 3:07:20 PM
 */

package desktop;

import desktop.bean.Portfolio;

/**
 *
 * @author Gao.chao.wei
 */
public class PortfolioWindow extends javax.swing.JInternalFrame {

    /** Creates new form PortfolioWindow */
    public PortfolioWindow() {
        initComponents();
        for(Portfolio p:list){
            addPortfolio(p);
        }
    }

    private void addPortfolio(Portfolio p){
        PortfolioDetailPanel pp = new PortfolioDetailPanel();
        pp.setPortfolio(p);
//        jTabbedPane1.addTab(p.getName(), pp); // NOI18N
        jTabbedPane1.insertTab(p.getName(), null, pp, p.getName(), jTabbedPane1.getTabCount()-1);
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
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(desktop.DesktopApp.class).getContext().getResourceMap(PortfolioWindow.class);
        query = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery(resourceMap.getString("query.query")); // NOI18N
        list = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : query.getResultList();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        portfolioPanel = new desktop.PortfolioPanel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setName("Form"); // NOI18N

        jTabbedPane1.setName("jTabbedPane1"); // NOI18N

        portfolioPanel.setName("portfolioPanel"); // NOI18N
        jTabbedPane1.addTab(resourceMap.getString("portfolioPanel.TabConstraints.tabTitle"), portfolioPanel); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager entityManager;
    private javax.swing.JTabbedPane jTabbedPane1;
    private java.util.List<desktop.bean.Portfolio> list;
    private desktop.PortfolioPanel portfolioPanel;
    private javax.persistence.Query query;
    // End of variables declaration//GEN-END:variables

}
