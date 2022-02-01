package projet_java_iai;

import java.awt.Image;
import java.awt.print.PrinterException;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Kenneth
 */
public class MainFrame extends javax.swing.JFrame {
     
    /**
     * Creates new form NewJFrame
     */
    
    String dbUsername="root";
    String dbPassword="";
    String dbServerUrl="jdbc:mysql://localhost:3306/stock_mngmt";
    String dbClassPathUrl="com.mysql.jdbc.Driver";
    
    String artCode="";
    String artLibelle="";
    String artPrix="";
    String artQuantite="";
    String artDateCreation="";
    Connection connx;
    DefaultTableModel model;
    
    public MainFrame() {
        initComponents();
        connx=databaseConnection();
        populateJTableFromMysqlDatabase();
    }

    public Connection databaseConnection(){
        Connection conn;
        try {
            //chargement Driver
            Class.forName(dbClassPathUrl);
             JOptionPane.showMessageDialog(null, "Driver Chargé");
            //Connection
            conn=DriverManager.getConnection(dbServerUrl,dbUsername,
                    dbPassword);
            JOptionPane.showMessageDialog(null, "Connecté");
            return conn;
        } catch (SQLException ex) {
            ex.printStackTrace();
           
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
           return null;
    }
    
    public ArrayList<Article> articlesList(){
        ArrayList<Article> articleLists=new ArrayList<Article>();
        String selectAllSQLQuery="SELECT * FROM article";
        Statement stmt;
        ResultSet rs;

        try {
            stmt=connx.createStatement();
            rs=stmt.executeQuery(selectAllSQLQuery);


            while(rs.next()){
                Article article=new Article();
                article.setCode(rs.getInt("Code"));
                article.setLibelle(rs.getString("Libelle"));
                article.setPrix(rs.getDouble("Prix"));
                article.setQuantite(rs.getInt("Quantite"));
                article.setDateCreation(rs.getString("DateCreation"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return articleLists;
    }
    
    //Remplir le jTable
    public void populateJTableFromMysqlDatabase(){
        ArrayList<Article> dataArray=articlesList();
        model=(DefaultTableModel) tbMain.getModel();
        model.setRowCount(0);
        Object[] rows=new Object[5];
        for (int i=0;i<dataArray.size();i++){
            rows[0]=dataArray.get(i).getCode();
            rows[1]=dataArray.get(i).getLibelle();
            rows[2]=dataArray.get(i).getPrix();
            rows[3]=dataArray.get(i).getQuantite();
            rows[4]=dataArray.get(i).getDateCreation();
            model.addRow(rows);
        }
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbMain = new javax.swing.JTable();
        lbTableTitle = new javax.swing.JLabel();
        btAddQt = new javax.swing.JButton();
        btSellQt = new javax.swing.JButton();
        jSpinner1 = new javax.swing.JSpinner();
        jSpinner2 = new javax.swing.JSpinner();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestion de stock");
        setMinimumSize(new java.awt.Dimension(600, 500));

        tbMain.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Code", "Libellé", "Prix", "Quantité", "Date de création"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbMain.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tbMain);
        if (tbMain.getColumnModel().getColumnCount() > 0) {
            tbMain.getColumnModel().getColumn(0).setMinWidth(40);
            tbMain.getColumnModel().getColumn(0).setPreferredWidth(60);
            tbMain.getColumnModel().getColumn(0).setMaxWidth(70);
            tbMain.getColumnModel().getColumn(2).setMinWidth(70);
            tbMain.getColumnModel().getColumn(2).setPreferredWidth(100);
            tbMain.getColumnModel().getColumn(2).setMaxWidth(120);
            tbMain.getColumnModel().getColumn(3).setMinWidth(50);
            tbMain.getColumnModel().getColumn(3).setPreferredWidth(80);
            tbMain.getColumnModel().getColumn(3).setMaxWidth(100);
            tbMain.getColumnModel().getColumn(4).setMinWidth(100);
            tbMain.getColumnModel().getColumn(4).setPreferredWidth(120);
            tbMain.getColumnModel().getColumn(4).setMaxWidth(140);
        }

        lbTableTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTableTitle.setText("Liste complète des articles");

        btAddQt.setText("Approvisioner");

        btSellQt.setText("Vendre");

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Article");

        jMenuItem2.setText("Enregistrer");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem3.setText("Modifier");
        jMenu2.add(jMenuItem3);

        jMenuItem4.setText("Supprimer");
        jMenu2.add(jMenuItem4);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTableTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btAddQt, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(jSpinner2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btSellQt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(80, 80, 80))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lbTableTitle)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btSellQt)
                    .addComponent(btAddQt))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAddQt;
    private javax.swing.JButton btSellQt;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JLabel lbTableTitle;
    private javax.swing.JTable tbMain;
    // End of variables declaration//GEN-END:variables
}