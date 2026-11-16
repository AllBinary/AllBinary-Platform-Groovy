/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.image.gui;

import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
import org.allbinary.graphics.displayable.CanvasStrings;
import org.allbinary.logic.communication.log.LogUtil;
import org.allbinary.logic.io.file.AbFile;
import org.allbinary.logic.string.StringMaker;
import org.allbinary.media.image.ImagePersistanceUtil;
import org.allbinary.media.image.ImageProcessorInput;
import org.allbinary.media.image.ImageProcessorInputCompositeInterface;
import org.allbinary.media.image.ImageUtil;
import org.allbinary.string.CommonStrings;
import org.allbinary.util.BasicArrayList;
import org.allbinary.util.BasicArrayListD;

/**  *  * @author User  */
@groovy.transform.CompileStatic
public class CreateIconImagesJPanel extends javax.swing.JPanel implements ImageProcessorInputCompositeInterface {
    protected final LogUtil logUtil = LogUtil.getInstance();

    private final CommonStrings commonStrings = CommonStrings.getInstance();

    private ImageProcessorInput imageProcessorInput;

    public CreateIconImagesJPanel(final ImageProcessorInput imageProcessorInput) throws Exception {
        super();
        initComponents();
        this.imageProcessorInput = imageProcessorInput;
        String[] numberStringArray = new String[101];
        numberStringArray[0] = Integer.toString(-1);
        for (int index = 1; index < 100; index++) {
            numberStringArray[index] = Integer.toString(index);
        }
        final Raster araster = this.imageProcessorInput.getBufferedImageArray()[0].getAlphaRaster();
        if (araster == null) {
            System.out.println('there is no Alpha channel!!!!!!!!!');
        } else {
            System.out.println('Alpha channel found !');
        }
    }

    public void process() {
        new Thread() {
                @Override
                public void run() {
                    final LogUtil logUtil = LogUtil.getInstance();
                    try {
                        final ImageUtil imageUtil = ImageUtil.getInstance();
                        final StringMaker stringMaker = new StringMaker();
                        final ImageProcessorInput imageProcessorInput = CreateIconImagesJPanel.this.getImageProcessorInput();
                        final File[] files = imageProcessorInput.getFiles();
                        final BasicArrayList iconWidthList = new BasicArrayListD();
                        final BasicArrayList iconHeightList = new BasicArrayListD();
                        //android
                        iconWidthList.add(864);
                        iconHeightList.add(864);
                        //                        iconHeightList.add(1024);
                        final String ANDROID = 'android-icon-';
                        final String IOS = 'ios-icon-';
                        final int size = iconWidthList.size();
                        int width = 0;
                        int height = 0;
                        for (int index2 = 0; index2 < size; index2++) {
                            width = (((Integer) iconWidthList.get(index2))).intValue();
                            height = (((Integer) iconHeightList.get(index2))).intValue();
                            BufferedImage[] generatedBufferedImageArray = imageUtil.createBufferedImage3(imageProcessorInput.getBufferedImageArray(), width, height, true);
                            final ImagePersistanceUtil imagePersistanceUtil = ImagePersistanceUtil.getInstance();
                            for (int index = 0; index < generatedBufferedImageArray.length; index++) {
                                final String filePath = files[index].getAbsolutePath();
                                final int endIndex = filePath.lastIndexOf(((int) ('\\' as char)));
                                final String path = filePath.substring(0, endIndex + 1);
                                stringMaker.delete(0, stringMaker.length());
                                stringMaker.append(path).append(ANDROID).appendint(width).append(CanvasStrings.getInstance().@_PNG);
                                String newFilePath = stringMaker.toString();
                                imagePersistanceUtil.saveWithBatik(AbFile.createAbFile(newFilePath), generatedBufferedImageArray[index]);
                                stringMaker.delete(0, stringMaker.length());
                                stringMaker.append(path).append(IOS).appendint(width).append(CanvasStrings.getInstance().@_PNG);
                                newFilePath = stringMaker.toString();
                                imagePersistanceUtil.saveWithBatik(AbFile.createAbFile(newFilePath), generatedBufferedImageArray[index]);
                            }
                        }
                        CreateIconImagesJPanel.this.getParent().repaint();
                    } catch (Exception e) {
                        logUtil.put(commonStrings.@EXCEPTION, this, commonStrings.@RUN, e);
                    }
                }

            }.start();
    }

    public ImageProcessorInput getImageProcessorInput() {
        return this.imageProcessorInput;
    }

    public void setImageProcessorInput(ImageProcessorInput imageProcessorInput) {
        this.imageProcessorInput = imageProcessorInput;
    }

    /**      * This method is called from within the constructor to initialize the form.      * WARNING: Do NOT modify this code. The content of this method is always      * regenerated by the Form Editor.      */
    @SuppressWarnings('unchecked')
    private void initComponents() {
        this.aboveJButton = new javax.swing.JButton();
        this.aboveJButton.setText('Process');
        this.aboveJButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    aboveJButtonActionPerformed(evt);
                }

            });
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(aboveJButton).addGap(0, 335, Short.MAX_VALUE)));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(aboveJButton).addContainerGap(286, Short.MAX_VALUE)));
    }

    // </editor-fold>//GEN-END:initComponents
    private void aboveJButtonActionPerformed(java.awt.event.ActionEvent evt) {
        //GEN-FIRST:event_aboveJButtonActionPerformed
        this.process();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aboveJButton;

}


