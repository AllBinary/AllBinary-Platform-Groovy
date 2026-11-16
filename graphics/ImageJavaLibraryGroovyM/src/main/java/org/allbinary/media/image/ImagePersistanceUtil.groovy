/*  * To change this license header, choose License Headers in Project Properties.  * To change this template file, choose Tools | Templates  * and open the template in the editor.  */
/* Generated Code Do Not Modify */
package org.allbinary.media.image;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import org.allbinary.logic.communication.log.LogUtil;
import org.allbinary.logic.io.AbFileOutputStream;
import org.allbinary.logic.io.StreamUtil;
import org.allbinary.logic.io.file.AbFile;
import org.allbinary.string.CommonStrings;
import org.apache.batik.ext.awt.image.codec.png.PNGImageWriter;

/**  *  * @author user  */
@groovy.transform.CompileStatic
public class ImagePersistanceUtil {
    private static final ImagePersistanceUtil instance = new ImagePersistanceUtil();

    public static ImagePersistanceUtil getInstance() {
        return ImagePersistanceUtil.instance;
    }

    protected final LogUtil logUtil = LogUtil.getInstance();

    private final CommonStrings commonStrings = CommonStrings.getInstance();

    public void saveWithBatik(final AbFile file, final BufferedImage bufferedImage) throws Exception {
        final PNGImageWriter batikPNGImageWriter = new PNGImageWriter();
        final AbFileOutputStream fileOutputStream = AbFileOutputStream.createFromAbFile(file);
        try {
            batikPNGImageWriter.writeImage(bufferedImage, fileOutputStream);
        } finally {
            fileOutputStream.flush();
            StreamUtil.getInstance().close(fileOutputStream);
        }
        this.logUtil.putF('Wrote Image: ' + file.getAbsolutePath(), this, this.commonStrings.@SAVE);
    }

    /*  protected static Map defaultColours(String design, String model) {      String ds3tfyDefaultColours = "bod,f35;acc,x01;nos,f10;cli,f10;cap,f10";      Map result = StdUtil.getInstance().createHashMap();   String[] records = ds3tfyDefaultColours.split(";");   for ( int i = 0; i < records.length; i++ ) {    String[] fields = records[i].split(",");    result.put(fields[0], fields[1]);   }      return result;  }     protected static RenderedImage getAlpha(RenderedImage img) {   int alphaBandIndex = 3;      ParameterBlock alphaPb = new ParameterBlock();   alphaPb.addSource(img);   alphaPb.add(new int[]{alphaBandIndex});   RenderedImage alphaImg = (RenderedImage)JAI.create("bandselect", alphaPb);      return alphaImg;  }       */
    public void saveWithImageIO(final String filePath, final BufferedImage bufferedImage) {
        this.saveWithImageIO(new File(filePath), bufferedImage);
    }

    public void saveWithImageIO(final File file, final BufferedImage bufferedImage) {
        ImageWriter writer = null;
        ImageOutputStream ios = null;
        try {
            // Obtain a writer based on the jpeg format.
            final Iterator iter = ImageIO.getImageWritersByFormatName('jpeg');
            // Validate existence of writer.
            if (!iter.hasNext()) {
                this.logUtil.putF('Unable to save image to jpeg file type.', this, this.commonStrings.@SAVE);
                return;
            }
            // Extract writer.
            writer = ((ImageWriter) iter.next());
            // Configure writer output destination.
            ios = ImageIO.createImageOutputStream(file);
            writer.setOutput(ios);
            // Set JPEG compression quality to 95%.
            final ImageWriteParam iwp = writer.getDefaultWriteParam();
            iwp.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
            iwp.setCompressionQuality(0.95f);
            //writer.write(null, (IIOImage) iioImageCacheable.getIioImage(), iwp);
            writer.write(null, new IIOImage(bufferedImage, null, null), iwp);
            //poolInterface.add(iioImageCacheable);
            this.logUtil.putF('Wrote Image: ' + file.getAbsolutePath(), this, this.commonStrings.@SAVE);
        } catch (Exception e) {
            this.logUtil.put(this.commonStrings.@EXCEPTION, this, this.commonStrings.@SAVE, e);
        } finally {
            try {
                if (ios != null) {
                    ios.flush();
                    //StreamUtil.getInstance().close(ios);
                    try {
                        if (ios != null) {
                            this.logUtil.putF(ios.toString(), ios, this.commonStrings.@CLOSE);
                            ios.close();
                        }
                    } catch (Exception e) {
                        this.logUtil.put(commonStrings.@EXCEPTION, ios, commonStrings.@CLOSE, e);
                    }
                }
                if (writer != null) {
                    writer.dispose();
                }
            } catch (IOException e2) {
                this.logUtil.put(this.commonStrings.@EXCEPTION, this, this.commonStrings.@SAVE, e2);
            }
        }
    }

}


