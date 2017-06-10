/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import javax.swing.JLabel;
import javax.swing.JPanel;
import lapr.project.controller.ChangeApplicationController;
import lapr.project.controller.CreateEventController;
import lapr.project.model.Application;
import lapr.project.model.EventCenter;
import lapr.project.model.User;
import lapr.project.utils.AuthenticationService;

/**
 *
 * @author RuiSL
 */
public class ChangeApplicationUI extends javax.swing.JPanel {
 private static final long serialVersionUID = 1L;
 private final EventCenter eventCenter;
 private final ChangeApplicationController changeController;
 private String[] applicationList;
 private User u;
 private Application a;
// private JPanel changeApplicationDataInput;
    /**
     * Creates new form ChangeApplicationUI
     */
    public ChangeApplicationUI(EventCenter eventCenter, ChangeApplicationController changeController) {
        AuthenticationService authentication = new AuthenticationService();
        u=authentication.getAuthenticatedUser();
        String userName=u.getUsername();
        this.eventCenter=eventCenter;
        this.changeController=changeController;
        applicationList=changeController.getApplicationsAsString(userName);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelApplicationSelect = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        applicationSelectList = new javax.swing.JList(applicationList);
        changeApplicationDataInput = new javax.swing.JPanel();

        labelApplicationSelect.setText("Please select Application");

        applicationSelectList.setModel(new javax.swing.AbstractListModel() {
            public int getSize() { return applicationList.length; }
            public Object getElementAt(int i) { return applicationList[i]; }
        });
        applicationSelectList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                applicationSelectListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(applicationSelectList);

        javax.swing.GroupLayout changeApplicationDataInputLayout = new javax.swing.GroupLayout(changeApplicationDataInput);
        changeApplicationDataInput.setLayout(changeApplicationDataInputLayout);
        changeApplicationDataInputLayout.setHorizontalGroup(
            changeApplicationDataInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 175, Short.MAX_VALUE)
        );
        changeApplicationDataInputLayout.setVerticalGroup(
            changeApplicationDataInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 128, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelApplicationSelect)
                    .addComponent(changeApplicationDataInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(213, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelApplicationSelect)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(changeApplicationDataInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void applicationSelectListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_applicationSelectListValueChanged
       Object a=applicationSelectList.getSelectedValue();
       String applicationString= (String) a;
       Application ap=changeController.getApplication(applicationString);
       changeController.selectApplication(ap);
       JLabel label= new JLabel("Application chosen");
       label.setVisible(true);
       changeApplicationDataInput.setVisible(true);
       a=ap;
    }//GEN-LAST:event_applicationSelectListValueChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList applicationSelectList;
    private javax.swing.JPanel changeApplicationDataInput;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelApplicationSelect;
    // End of variables declaration//GEN-END:variables
}
