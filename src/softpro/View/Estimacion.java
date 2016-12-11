package softpro.View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;
import org.jfree.ui.RefineryUtilities;
import softpro.Controller.CommandSet;
import softpro.Model.Scrum.ScrumProject;
import softpro.Model.Scrum.UserStory;
import softpro.Persistence.ProjectLoader;

public class Estimacion extends javax.swing.JPanel {

    private final Gantt gantt = new Gantt();
    private final addUserStory addDialog = new addUserStory();
    private final deleteUserStory deleteDialog = new deleteUserStory();
    private final modifyUserStory modifyDialog = new modifyUserStory();
    private final ScrumProject project = ProjectLoader.loadScrumProject(2);
    private final CommandSet actionSet;
    public Estimacion() {
        initComponents();
        this.actionSet = new CommandSet();
        addDialog.pack();
        RefineryUtilities.centerFrameOnScreen(addDialog);
        addDialog.setVisible(false);
        deleteDialog.pack();
        RefineryUtilities.centerFrameOnScreen(deleteDialog);
        deleteDialog.setVisible(false);
        modifyDialog.pack();
        RefineryUtilities.centerFrameOnScreen(modifyDialog);
        modifyDialog.setVisible(false);
        //Diagrama de Gantt
        gantt.pack();
        RefineryUtilities.centerFrameOnScreen(gantt);
        gantt.setVisible(false);
    }

    @SuppressWarnings("empty-statement")
    private DefaultTableModel createTableDataModel() {
        ArrayList<UserStory> userStoryList = new ArrayList<>();
        Iterator<UserStory> iterator = project.getBacklog().iterator();
        while (iterator.hasNext()) {
            userStoryList.add(iterator.next());
        }
        String[][] data = new String[100][10];
        String[] header = {"Descripcion", "Tiempo Est.", "Prioridad"};
        int i = 0;

        for (UserStory userStory : userStoryList) {
            data[i][0] = userStory.getDescription();
            data[i][1] = String.valueOf(userStory.getPoints());
            data[i][2] = String.valueOf(userStory.getPriority());
            i++;
        }
        return new DefaultTableModel(data, header);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addButton = new javax.swing.JButton();
        modifyButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        showDiagramButton = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ESTIMACIÓN", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 13))); // NOI18N

        addButton.setText("Añadir");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        modifyButton.setText("Modificar");
        modifyButton.setEnabled(false);
        modifyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Eliminar");
        deleteButton.setEnabled(false);
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        jTable1.setModel(this.createTableDataModel());
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTable1PropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        showDiagramButton.setText("Mostrar Diagrama de Gant");
        showDiagramButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showDiagramButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(172, 172, 172)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addButton)
                        .addGap(18, 18, 18)
                        .addComponent(modifyButton)
                        .addGap(18, 18, 18)
                        .addComponent(deleteButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(showDiagramButton, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(modifyButton)
                    .addComponent(deleteButton))
                .addGap(18, 18, 18)
                .addComponent(showDiagramButton)
                .addContainerGap(84, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        addDialog.setVisible(true);
    }//GEN-LAST:event_addButtonActionPerformed

    private void showDiagramButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showDiagramButtonActionPerformed
        gantt.setVisible(true);
    }//GEN-LAST:event_showDiagramButtonActionPerformed

    private void modifyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyButtonActionPerformed
        modifyDialog.setVisible(true);
    }//GEN-LAST:event_modifyButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        String description = (String) jTable1.getValueAt(jTable1.getSelectedRow(), 0);
        String index = project.getBacklog().findIdStoryByDescription(description);
        HashMap<String, String> arguments = new HashMap<>();
        arguments.put("storyID",index);
        boolean r = actionSet.getProjectAction(Operation.DELETE_STORY).execute(project, arguments);
        System.out.println(r);
        jTable1.setModel(createTableDataModel());
        //deleteDialog.setVisible(true);
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        modifyButton.setEnabled(true);
        deleteButton.setEnabled(true);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTable1PropertyChange

    }//GEN-LAST:event_jTable1PropertyChange

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton modifyButton;
    private javax.swing.JButton showDiagramButton;
    // End of variables declaration//GEN-END:variables
}