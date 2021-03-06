/*
 * Autopsy Forensic Browser
 *
 * Copyright 2011 Basis Technology Corp.
 * Contact: carrier <at> sleuthkit <dot> org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

 /*
 * KnownStatusSearchPanel.java
 *
 * Created on Oct 19, 2011, 11:45:44 AM
 */
package org.sleuthkit.autopsy.filesearch;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import javax.swing.JCheckBox;

/**
 *
 * @author pmartel
 */
class KnownStatusSearchPanel extends javax.swing.JPanel {

    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    /**
     * Creates new form KnownStatusSearchPanel
     */
    KnownStatusSearchPanel() {
        initComponents();
        setComponentsEnabled();
    }

    JCheckBox getKnownCheckBox() {
        return knownCheckBox;
    }

    JCheckBox getKnownBadOptionCheckBox() {
        return knownBadOptionCheckBox;
    }

    JCheckBox getKnownOptionCheckBox() {
        return knownOptionCheckBox;
    }

    JCheckBox getUnknownOptionCheckBox() {
        return unknownOptionCheckBox;
    }

    private void setComponentsEnabled() {
        boolean enabled = this.knownCheckBox.isSelected();
        this.unknownOptionCheckBox.setEnabled(enabled);
        this.knownOptionCheckBox.setEnabled(enabled);
        this.knownBadOptionCheckBox.setEnabled(enabled);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        pcs.addPropertyChangeListener(pcl);
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        pcs.removePropertyChangeListener(pcl);
    }

    boolean isValidSearch() {
        return this.unknownOptionCheckBox.isSelected() || this.knownBadOptionCheckBox.isSelected() || this.knownOptionCheckBox.isSelected();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        knownCheckBox = new javax.swing.JCheckBox();
        unknownOptionCheckBox = new javax.swing.JCheckBox();
        knownOptionCheckBox = new javax.swing.JCheckBox();
        knownBadOptionCheckBox = new javax.swing.JCheckBox();

        knownCheckBox.setText(org.openide.util.NbBundle.getMessage(KnownStatusSearchPanel.class, "KnownStatusSearchPanel.knownCheckBox.text")); // NOI18N
        knownCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                knownCheckBoxActionPerformed(evt);
            }
        });

        unknownOptionCheckBox.setSelected(true);
        unknownOptionCheckBox.setText(org.openide.util.NbBundle.getMessage(KnownStatusSearchPanel.class, "KnownStatusSearchPanel.unknownOptionCheckBox.text")); // NOI18N
        unknownOptionCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unknownOptionCheckBoxActionPerformed(evt);
            }
        });

        knownOptionCheckBox.setSelected(true);
        knownOptionCheckBox.setText(org.openide.util.NbBundle.getMessage(KnownStatusSearchPanel.class, "KnownStatusSearchPanel.knownOptionCheckBox.text")); // NOI18N
        knownOptionCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                knownOptionCheckBoxActionPerformed(evt);
            }
        });

        knownBadOptionCheckBox.setSelected(true);
        knownBadOptionCheckBox.setText(org.openide.util.NbBundle.getMessage(KnownStatusSearchPanel.class, "KnownStatusSearchPanel.knownBadOptionCheckBox.text")); // NOI18N
        knownBadOptionCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                knownBadOptionCheckBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(knownCheckBox)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(unknownOptionCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(knownOptionCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(knownBadOptionCheckBox)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(knownCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(unknownOptionCheckBox)
                    .addComponent(knownOptionCheckBox)
                    .addComponent(knownBadOptionCheckBox)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void knownOptionCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_knownOptionCheckBoxActionPerformed
        pcs.firePropertyChange(FileSearchPanel.EVENT.CHECKED.toString(), null, null);
    }//GEN-LAST:event_knownOptionCheckBoxActionPerformed

    private void knownCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_knownCheckBoxActionPerformed
        setComponentsEnabled();
        pcs.firePropertyChange(FileSearchPanel.EVENT.CHECKED.toString(), null, null);
    }//GEN-LAST:event_knownCheckBoxActionPerformed

    private void unknownOptionCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unknownOptionCheckBoxActionPerformed
        pcs.firePropertyChange(FileSearchPanel.EVENT.CHECKED.toString(), null, null);
    }//GEN-LAST:event_unknownOptionCheckBoxActionPerformed

    private void knownBadOptionCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_knownBadOptionCheckBoxActionPerformed
        pcs.firePropertyChange(FileSearchPanel.EVENT.CHECKED.toString(), null, null);
    }//GEN-LAST:event_knownBadOptionCheckBoxActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox knownBadOptionCheckBox;
    private javax.swing.JCheckBox knownCheckBox;
    private javax.swing.JCheckBox knownOptionCheckBox;
    private javax.swing.JCheckBox unknownOptionCheckBox;
    // End of variables declaration//GEN-END:variables
}
