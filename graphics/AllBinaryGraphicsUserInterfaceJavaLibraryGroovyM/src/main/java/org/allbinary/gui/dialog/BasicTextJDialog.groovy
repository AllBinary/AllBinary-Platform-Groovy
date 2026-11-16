/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.gui.dialog;

import org.allbinary.thread.ARunnable;

/**  *  * @author  USER  */
@groovy.transform.CompileStatic
public class BasicTextJDialog extends javax.swing.JDialog {
    private CloseJDialogListenerInterface closeListenerInterface;

    /** Creates new form BasicTextJDialog */
    public BasicTextJDialog(java.awt.Frame parent, boolean modal, String text) {
        super(parent, modal);
        this.initComponents();
        this.setText(text);
    }

    public void setText(String text) {
        this.textJLabel.setText(text);
    }

    public void addCloseListener(CloseJDialogListenerInterface closeListenerInterface) {
        this.closeListenerInterface = closeListenerInterface;
    }

    public BasicTextJDialog(String text) {
        this.initComponents();
        this.textJLabel.setText(text);
    }

    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        this.jButton1 = new javax.swing.JButton();
        this.textJLabel = new javax.swing.JLabel();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        this.jButton1.setText('OK');
        jButton1.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton1ActionPerformed(evt);
                }

            });
        this.textJLabel.setText('No Text Set');
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(80, 80, 80).addComponent(jButton1)).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(textJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(20, 20, 20).addComponent(textJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(30, 30, 30).addComponent(jButton1)));
        pack();
    }

    // </editor-fold>//GEN-END:initComponents
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        //GEN-HEADEREND:event_jButton1ActionPerformed
        this.setVisible(false);
        if (this.closeListenerInterface != null) {
            this.closeListenerInterface.onClose();
        }
    }

    /**      * @param args the command line arguments      */
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new ARunnable() {
                public void run() {
                    new BasicTextJDialog(new javax.swing.JFrame(), true, 'Test').setVisible(true);
                }

            });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;

    private javax.swing.JLabel textJLabel;

}


