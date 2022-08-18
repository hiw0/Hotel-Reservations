/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DatabaseMetaData;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * Cameron Rose
 * 220263159
 * Project 2
 */
public class guestlist extends javax.swing.JFrame {
Connection conn;
ResultSet rs;
Statement smt;
DatabaseMetaData md;
PreparedStatement psd;
    /**
     * Creates new form guestlist
     */
    public guestlist() {
        initComponents();
         doconnect();
    }
public void doconnect()
{
  try
    {
       String Driver="org.apache.derby.jdbc.EmbeddedDriver";
       String mydata="guestdata";
       String url="jdbc:derby:"+mydata+";create=true";
               conn=DriverManager.getConnection(url);
               
        smt=conn.createStatement();
         DatabaseMetaData dbmd = conn.getMetaData();
rs = dbmd.getTables(null, "APP", "guest".toUpperCase(), null);


        String qurer="CREATE TABLE guest (ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), NAME VARCHAR(100) NOT NULL,ADDRESS VARCHAR(300) NOT NULL,MOB VARCHAR(11) NOT NULL)";

        if(!rs.next()){
 smt.executeUpdate(qurer);
 smt.executeUpdate("INSERT INTO guest values(DEFAULT,'Cameron','Rose','95080803009')");
}

rs.close();
smt.close();

smt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);


String query1="SELECT * FROM guest";
rs=smt.executeQuery(query1);
rs.next();

int uid=rs.getInt("ID");

String named=rs.getString("NAME");
String address=rs.getString("ADDRESS");
String mom=rs.getString("MOB");
jTextField1.setText(named);
jTextField2.setText(address);
jTextField3.setText(mom);



    }
    catch(SQLException err)
    {
      JOptionPane.showMessageDialog(guestlist.this, err.getMessage());
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

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GUEST LIST");
        setResizable(false);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/guest/guist.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("NAME");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("ADDRESS");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("MOBILE");

        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jTextField2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jTextField3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setText("NEW");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setText("SAVE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton4.setText("DELETE");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton5.setText("REFRESH LIST");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton6.setText("Close");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3))
                                .addGap(104, 104, 104)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                                    .addComponent(jTextField2)
                                    .addComponent(jTextField3)))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton5)
                                .addGap(18, 18, 18)
                                .addComponent(jButton6)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton5)
                    .addComponent(jButton6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        jTextField1.setText(" ");
        jTextField2.setText(" ");
        jTextField3.setText(" ");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        String gname=jTextField1.getText();
        String gaddress=jTextField2.getText();
        String mobl=jTextField3.getText();
        try{
           
           
           
          
       
        rs.moveToInsertRow();
       
                   PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO guest values (DEFAULT, ?,?, ?)");
                   

preparedStatement.setString(1, gname);
preparedStatement.setString(2, gaddress);
preparedStatement.setString(3, mobl);
int rowsInserted=preparedStatement.executeUpdate();
                
           
           
           
           
          
smt.close();
  rs.close();          
smt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);


String query1="SELECT * FROM guest";
rs=smt.executeQuery(query1);
rs.next();

int uid=rs.getInt("ID");

String named=rs.getString("NAME");
String address=rs.getString("ADDRESS");
String mom=rs.getString("MOB");
jTextField1.setText(named);
jTextField2.setText(address);
jTextField3.setText(mom);

  }
       catch(SQLException err){
           JOptionPane.showMessageDialog(guestlist.this, err.getMessage());
       }
                

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
         try{
            
            
       rs.deleteRow();
       smt.close();
rs.close();
                


smt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
String query1="SELECT * FROM guest";
rs=smt.executeQuery(query1);
rs.next();

int uid=rs.getInt("ID");

String named=rs.getString("NAME");
String address=rs.getString("ADDRESS");
String mom=rs.getString("MOB");
jTextField1.setText(named);
jTextField2.setText(address);
jTextField3.setText(mom);


  }
       catch(SQLException err){
           JOptionPane.showMessageDialog(guestlist.this, err.getMessage());
       }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        
         try{
             Connection connn;
ResultSet rss;

Statement smtt;
DatabaseMetaData mdd;
PreparedStatement psdd;
         String Driver="org.apache.derby.jdbc.EmbeddedDriver";
       String mydata="guestdata";
       String url="jdbc:derby:"+mydata+";create=true";
               connn=DriverManager.getConnection(url);
               
        smtt=connn.createStatement();
    String query2="SELECT * FROM guest";
rss=smtt.executeQuery(query2);
ResultSetMetaData meta = rss.getMetaData();
            int numberOfColumns = meta.getColumnCount();
DefaultTableModel dtm = new DefaultTableModel();
dtm.addColumn("ID");
dtm.addColumn("NAME");
dtm.addColumn("ADDRESS");
dtm.addColumn("MOB");
 while (rss.next())
            {
                Object [] rowData = new Object[numberOfColumns];
                for (int i = 0; i < rowData.length; ++i)
                {
                    rowData[i] = rss.getObject(i+1);
                }
                dtm.addRow(rowData);
            }
            jTable1.setModel(dtm);
            
    }
    catch(SQLException err)
    {
      JOptionPane.showMessageDialog(guestlist.this, err.getMessage());
    }
    
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(guestlist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(guestlist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(guestlist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(guestlist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new guestlist().setVisible(true);
            }
        });
    } 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
