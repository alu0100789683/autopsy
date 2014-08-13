/*
 * Autopsy Forensic Browser
 *
 * Copyright 2014 Basis Technology Corp.
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


package org.sleuthkit.autopsy.diagnostics;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import org.openide.windows.WindowManager;
import org.sleuthkit.autopsy.casemodule.Case;
import org.sleuthkit.datamodel.AbstractFile;
import org.sleuthkit.datamodel.Image;
import org.sleuthkit.datamodel.SleuthkitCase;
import org.sleuthkit.datamodel.TskCoreException;

public class PerformancePanel extends javax.swing.JDialog {

    /**
     * Creates new form PerformancePanel
     */
    public PerformancePanel() {
        super((JFrame) WindowManager.getDefault().getMainWindow(), "Performance Diagnostics", true);
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

        jLabel1 = new javax.swing.JLabel();
        imgReadLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        dbReadLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        fileReadLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cpuTimeLabel = new javax.swing.JLabel();
        startButton = new javax.swing.JButton();
        statusLabel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(PerformancePanel.class, "PerformancePanel.jLabel1.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(imgReadLabel, org.openide.util.NbBundle.getMessage(PerformancePanel.class, "PerformancePanel.imgReadLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(PerformancePanel.class, "PerformancePanel.jLabel2.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(dbReadLabel, org.openide.util.NbBundle.getMessage(PerformancePanel.class, "PerformancePanel.dbReadLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel4, org.openide.util.NbBundle.getMessage(PerformancePanel.class, "PerformancePanel.jLabel4.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(fileReadLabel, org.openide.util.NbBundle.getMessage(PerformancePanel.class, "PerformancePanel.fileReadLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel3, org.openide.util.NbBundle.getMessage(PerformancePanel.class, "PerformancePanel.jLabel3.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(cpuTimeLabel, org.openide.util.NbBundle.getMessage(PerformancePanel.class, "PerformancePanel.cpuTimeLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(startButton, org.openide.util.NbBundle.getMessage(PerformancePanel.class, "PerformancePanel.startButton.text")); // NOI18N
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(statusLabel, org.openide.util.NbBundle.getMessage(PerformancePanel.class, "PerformancePanel.statusLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel5, org.openide.util.NbBundle.getMessage(PerformancePanel.class, "PerformancePanel.jLabel5.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fileReadLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dbReadLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cpuTimeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(imgReadLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(startButton)
                            .addComponent(jLabel5))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(statusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cpuTimeLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imgReadLabel)
                    .addComponent(jLabel1))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(fileReadLabel))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(dbReadLabel))
                .addGap(18, 18, 18)
                .addComponent(statusLabel)
                .addGap(9, 9, 9)
                .addComponent(startButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        // TODO add your handling code here:
        startButton.setEnabled(false);
        SwingWorker worker = new PerformanceTestWorker();
        worker.execute();
        
    }//GEN-LAST:event_startButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cpuTimeLabel;
    private javax.swing.JLabel dbReadLabel;
    private javax.swing.JLabel fileReadLabel;
    private javax.swing.JLabel imgReadLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton startButton;
    private javax.swing.JLabel statusLabel;
    // End of variables declaration//GEN-END:variables

    class PerformanceTestWorker extends SwingWorker {
        private long cpuStats;
        private long imgReadStats;
        private long dbStats;
        private long fileReadStats;
        
        @Override
        protected Object doInBackground() throws Exception {
            setCpuLabel("");
            setImgLabel("");
            setDbLabel("");
            setFileReadLabel("");
            
            doCpuTest();
            doImgTest();
            doFileReadTest();
            doDbTest();
            
            return null;
        }
        
        private void setCpuLabel(final String msg) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    cpuTimeLabel.setText(msg);
                }
            });
        }
        
        private void setImgLabel(final String msg) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    imgReadLabel.setText(msg);
                }
            });
        }
        
        private void setFileReadLabel(final String msg) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    fileReadLabel.setText(msg);
                }
            });
        }
        
        private void setDbLabel(final String msg) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    dbReadLabel.setText(msg);
                }
            });
        }
        
        private void setStatusMsg(final String msg) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    statusLabel.setText(msg);
                }
            });
        }
        
        
        private void doCpuTest() {
            final String msg = "Running CPU Test";
            
            MessageDigest md;
            long start = new Date().getTime();
            try {
                md = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException ex) {
                setCpuLabel("MD5 Algo not found");
                return;
            }
            
            byte[] buf = new byte[256 * 1024];
            long bytesRead = 0;
            for (int a = 0; a < 50; a++) {
                if (a % 10 == 0)
                    setStatusMsg(msg + " " + a * 100 / 50 + "%");
                for (byte b = Byte.MIN_VALUE; b < Byte.MAX_VALUE; b++) {
                    Arrays.fill(buf, b);
                    md.update(buf);
                    bytesRead += buf.length;
                }
            }
            md.digest();

            long end = new Date().getTime();
            cpuStats = (bytesRead / (1024 * 1024)) / ((end - start) / 1000);
            
            setCpuLabel(cpuStats + " MB hashed / sec");
            setStatusMsg("");
        }
        
        private void doImgTest() {
            imgReadStats = 0;
            setStatusMsg("Running Image Reading Test");
            
            Case curCase;
            try {
                curCase = Case.getCurrentCase();
            }
            catch (Exception e) {   
                setImgLabel("Case Not Open");
                setStatusMsg("");
                return;
            }
                
            List<Image> images;
            try {
                images = curCase.getImages();
            } catch (TskCoreException ex) {
                setImgLabel("No Images In Case");
                setStatusMsg("");
                return;
            }
            
            if (images.isEmpty()) {
                setImgLabel("No Images In Case");
                setStatusMsg("");
                return;
            }
            
            long start = new Date().getTime();

            Image image = images.get(0);

            byte[] buf = new byte[4096];
            long bytesRead = 0;
            
            // random starting point to prevent caching from effecting it
            Random rand = new Random();
            long curOffset = rand.nextLong();
            if (curOffset < 0) {
                curOffset *= -1;
            }
            curOffset = curOffset % (image.getSize() / 2);
            curOffset = 512 * ((curOffset + 511) / 512);
            
            //long curOffset = 0;
            while (bytesRead < 1000 * 1024 * 1024 ) {
                long read;
                try {
                    read = image.read(buf, curOffset, buf.length);
                } catch (TskCoreException ex) {
                    break;
                }
                if (read <= 0)
                    break;
                bytesRead += read;
                curOffset += read;
            }
            long end = new Date().getTime();
            long elapsed = (end - start) / 1000;
            if (elapsed > 0) 
                imgReadStats = (bytesRead / (1024 * 1024))  / elapsed;
            else
                imgReadStats = 0;
            setImgLabel(imgReadStats + " MB read / sec (" + bytesRead + ")");
            setStatusMsg("");   
        }
        
        private void doFileReadTest() {
            fileReadStats = 0;
            
            if (true) {
                setFileReadLabel("Skipped");
            }
            
            setStatusMsg("Running File Reading Test");
            
            Case curCase;
            try {
                curCase = Case.getCurrentCase();
            }
            catch (Exception e) {   
                setFileReadLabel("Case Not Open");
                setStatusMsg("");
                return;
            }
                
            List<Image> images;
            try {
                images = curCase.getImages();
            } catch (TskCoreException ex) {
                setFileReadLabel("No Images In Case");
                setStatusMsg("");
                return;
            }
            
            if (images.isEmpty()) {
                setFileReadLabel("No Images In Case");
                setStatusMsg("");
                return;
            }

            Image image = images.get(0);
            File file = new File(image.getPaths()[0]);
            if (file.exists() == false) {
                setFileReadLabel("Image Path Doesn't Exist");
                setStatusMsg("");
                return;
            }
            
            FileReader fileReader;
            try {
                fileReader = new FileReader(file);
            } catch (FileNotFoundException ex) {
                setFileReadLabel("Error making file reader");
                setStatusMsg("");
                return;
            }
            
            long start = new Date().getTime();
            // random starting point to prevent caching from effecting it
            // make RandomAccessFile instad
            /*Random rand = new Random();
            long curOffset = rand.nextLong();
            if (curOffset < 0) {
                curOffset *= -1;
            }
            curOffset = curOffset % (file.length());
            curOffset = 512 * ((curOffset + 511) / 512);
            try {
                fileReader.skip(curOffset);
            } catch (IOException ex) {
                setFileReadLabel("Error seeking: " + curOffset);
                return;
            }*/
            
            char[] buf = new char[4096];
            int bytesRead = 0;
            while (bytesRead < 1000 * 1024 * 1024 ) {
                long read;
                try {
                    read = fileReader.read(buf, 0, buf.length);
                } catch (IOException ex) {
                    break;
                }
                if (read <= 0)
                    break;
                bytesRead += read;
            }
            long end = new Date().getTime();
            long elapsed = (end - start) / 1000;
            if (elapsed > 0) 
                fileReadStats = (bytesRead / (1024 * 1024))  / elapsed;
            else
                fileReadStats = 0;
            setFileReadLabel(fileReadStats + " MB read / sec (" + bytesRead + ")");
            setStatusMsg("");   
        }
        
        private void doDbTest() {
            dbStats = 0;
            setStatusMsg("Running DB Test");
            
            Case curCase;
            try {
                curCase = Case.getCurrentCase();
            }
            catch (Exception e) {
                setDbLabel("Case Not Open");
                return;
            }
            
            try {
                SleuthkitCase tskCase = curCase.getSleuthkitCase();
                long start = new Date().getTime();

                List<AbstractFile> files = tskCase.findAllFilesWhere("obj_id < 50000");
                
                long end = new Date().getTime();
                long elapsed = (end - start) / 1000;
                if (elapsed > 0) 
                    dbStats = files.size() /  elapsed;
                else
                    dbStats = 0;
            
                setDbLabel(dbStats + " records / sec");
            } catch (TskCoreException ex) {
                setDbLabel("Error Performing Query");
            }
            
            setStatusMsg("");
        }
        
        @Override
        protected void done() {
            try {
                get();
            } catch (InterruptedException | ExecutionException ex) {
                setStatusMsg("Error: " + ex.getMessage());
            }
            startButton.setEnabled(true);
        }
    }
}

