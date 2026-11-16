/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.image.opengles;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;
import javax.microedition.lcdui.Image;
import org.allbinary.graphics.displayable.DisplayInfoSingleton;
import org.allbinary.graphics.opengles.OpenGLLogUtil;
import org.allbinary.opengles.GLUtil;
import org.allbinary.platform.graphics.PlatformBitmapBaseFactory;
import org.allbinary.platform.opengles.PlatformTextureBaseFactory;

@groovy.transform.CompileStatic
public class OpenGLESGL10Image extends OpenGLESImage {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    private final FloatBuffer textureVertexFloatBuffer = ByteBuffer.allocateDirect(4 * 4 * 2).order(ByteOrder.nativeOrder()).asFloatBuffer();

    private final OpenGLESImageDraw realOpenGLESImageDraw = new OpenGLESImageDraw() {
            private final GLUtil glUtil = GLUtil.getInstance();

            private final DisplayInfoSingleton displayInfoSingleton = DisplayInfoSingleton.getInstance();

            private final FloatBuffer textureVertexFloatBuffer = OpenGLESGL10Image.this.textureVertexFloatBuffer;

            private final float[] regionTextureRectangleFloatArray = new float[8];

            private final FloatBuffer regionTextureVertexFloatBuffer = ByteBuffer.allocateDirect(4 * 4 * 2).order(ByteOrder.nativeOrder()).asFloatBuffer();

            private final float[] regionRectangleFloatArray = new float[] {0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f};

            //    };    
            protected final FloatBuffer regionRectangleVertexFloatBuffer = ByteBuffer.allocateDirect(4 * 4 * 3).order(ByteOrder.nativeOrder()).asFloatBuffer();

            @groovy.transform.PackageScope final OpenGLESImageProperties openGLESImageProperties = OpenGLESGL10Image.this.openGLESImageProperties;

            @Override
            public void drawRegion(final GL10 gl, final int viewHeight, final float x_src, final float y_src, final float width, final float height, final int x, final int y, final int z) {
                //PreLogUtil.put(this.commonStrings.START + "Texture", this, "drawRegion");
                final int imageWidth = OpenGLESGL10Image.this.getWidth();
                final int imageHeight = OpenGLESGL10Image.this.getHeight();
                //            regionRectangleFloatArray[10] = regionRectangleFloatArray[7];
                this.regionRectangleFloatArray[7] = ((float) viewHeight);
                this.regionRectangleFloatArray[1] = ((float) (this.regionRectangleFloatArray[7] - height));
                this.regionRectangleFloatArray[3] = width;
                this.regionRectangleFloatArray[4] = this.regionRectangleFloatArray[1];
                this.regionRectangleFloatArray[9] = this.regionRectangleFloatArray[3];
                this.regionRectangleFloatArray[10] = this.regionRectangleFloatArray[7];
                //regionTextureVertexFloatBuffer.rewind();
                this.regionTextureRectangleFloatArray[0] = ((float) (x_src / imageWidth));
                this.regionTextureRectangleFloatArray[1] = ((float) ((((float) (y_src + height))) / imageHeight));
                this.regionTextureRectangleFloatArray[2] = ((float) ((((float) (x_src + width))) / imageWidth));
                this.regionTextureRectangleFloatArray[3] = this.regionTextureRectangleFloatArray[1];
                this.regionTextureRectangleFloatArray[4] = this.regionTextureRectangleFloatArray[0];
                this.regionTextureRectangleFloatArray[5] = ((float) (y_src / imageHeight));
                this.regionTextureRectangleFloatArray[6] = this.regionTextureRectangleFloatArray[2];
                this.regionTextureRectangleFloatArray[7] = this.regionTextureRectangleFloatArray[5];
                final float u_center = ((float) ((((float) (this.regionTextureRectangleFloatArray[0] + this.regionTextureRectangleFloatArray[2]))) / 2.0f));
                final float v_center = ((float) ((((float) (this.regionTextureRectangleFloatArray[5] + this.regionTextureRectangleFloatArray[1]))) / 2.0f));
                this.glUtil.rotateUVs(this.regionTextureRectangleFloatArray, ((float) -this.openGLESImageProperties.@angle), u_center, v_center);
                //Matrix operations in modelview
                gl.glPushMatrix();
                //            imageProcessor.translate(gl, x - (width / 2), (viewHeight - y - (height / 2)));
                final OpenGLESImageProcessor imageProcessor = OpenGLESGL10Image.this.imageProcessor;
                OpenGLESGL10Image.this.openGLESImageTranslate.translate(gl, OpenGLESGL10Image.this, ((float) x), ((float) -y));
                imageProcessor.scale(gl, this.openGLESImageProperties.@scaleX, this.openGLESImageProperties.@scaleY);
                //imageProcessor.scale(gl, scaleX * width, scaleY * height * 2.0f);
                imageProcessor.colorMask(gl, this.openGLESImageProperties.@redf, this.openGLESImageProperties.@greenf, this.openGLESImageProperties.@bluef, this.openGLESImageProperties.@alphaf);
                OpenGLESGL10Image.this.openGLESImageTranslate.translate2(gl, OpenGLESGL10Image.this);
                this.regionRectangleVertexFloatBuffer.put(this.regionRectangleFloatArray);
                this.glUtil.position(this.regionRectangleVertexFloatBuffer, 0);
                gl.glVertexPointer(3, GL10.GL_FLOAT, 0, this.regionRectangleVertexFloatBuffer);
                gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
                gl.glEnable(GL10.GL_TEXTURE_2D);
                gl.glBindTexture(GL10.GL_TEXTURE_2D, this.openGLESImageProperties.@textureID);
                gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
                this.regionTextureVertexFloatBuffer.put(this.regionTextureRectangleFloatArray);
                this.glUtil.position(this.regionTextureVertexFloatBuffer, 0);
                gl.glTexCoordPointer(2, GL10.GL_FLOAT, 0, this.regionTextureVertexFloatBuffer);
                //gl.glDrawArrays(GL10.GL_TRIANGLES, 1, 3);
                gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, 4);
                gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
                gl.glDisableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
                gl.glDisable(GL10.GL_TEXTURE_2D);
                //Restore matrix
                gl.glPopMatrix();
            }

            @Override
            public void draw(final GL10 gl, final int x, final int y, final int z) {
                //PreLogUtil.put(commonStrings.START + "Texture", this, "draw");
                final int width = OpenGLESGL10Image.this.getWidth();
                final int height = OpenGLESGL10Image.this.getHeight();
                //            regionRectangleFloatArray[10] = regionRectangleFloatArray[7];
                this.regionRectangleFloatArray[7] = ((float) this.displayInfoSingleton.getLastHeight());
                this.regionRectangleFloatArray[1] = ((float) (this.regionRectangleFloatArray[7] - height));
                this.regionRectangleFloatArray[3] = ((float) width);
                this.regionRectangleFloatArray[4] = this.regionRectangleFloatArray[1];
                this.regionRectangleFloatArray[9] = this.regionRectangleFloatArray[3];
                this.regionRectangleFloatArray[10] = this.regionRectangleFloatArray[7];
                /*         regionRectangleVertexFloatBuffer.put(0, x);         regionRectangleVertexFloatBuffer.put(7, DisplayInfoSingleton.getInstance().getLastHeight() - y);         regionRectangleVertexFloatBuffer.put(1, regionRectangleVertexFloatBuffer.get(7) - getHeight());          regionRectangleVertexFloatBuffer.put(3, x + getWidth());         regionRectangleVertexFloatBuffer.put(4, regionRectangleVertexFloatBuffer.get(1));          regionRectangleVertexFloatBuffer.put(6, x);         //         //glUtil.position(regionRectangleVertexFloatBuffer, 7);         //regionRectangleVertexFloatBuffer.put(regionRectangleVertexFloatBuffer.get(7));          regionRectangleVertexFloatBuffer.put(9, regionRectangleVertexFloatBuffer.get(3));         regionRectangleVertexFloatBuffer.put(10, regionRectangleVertexFloatBuffer.get(7));              */
                this.regionTextureRectangleFloatArray[0] = 0f;
                this.regionTextureRectangleFloatArray[1] = 1f;
                this.regionTextureRectangleFloatArray[2] = 1f;
                this.regionTextureRectangleFloatArray[3] = 1f;
                this.regionTextureRectangleFloatArray[4] = 0f;
                this.regionTextureRectangleFloatArray[5] = 0f;
                this.regionTextureRectangleFloatArray[6] = 1f;
                this.regionTextureRectangleFloatArray[7] = 0f;
                //Matrix operations in modelview
                gl.glPushMatrix();
                //            imageProcessor.translate(gl, x - (width / 2), (viewHeight - y - (height / 2)));
                OpenGLESGL10Image.this.openGLESImageTranslate.translate(gl, OpenGLESGL10Image.this, ((float) x), ((float) -y));
                final OpenGLESImageProcessor imageProcessor = OpenGLESGL10Image.this.imageProcessor;
                imageProcessor.scale(gl, this.openGLESImageProperties.@scaleX, this.openGLESImageProperties.@scaleY);
                //imageProcessor.scale(gl, scaleX * width, scaleY * height * 2.0f);
                imageProcessor.colorMask(gl, this.openGLESImageProperties.@redf, this.openGLESImageProperties.@greenf, this.openGLESImageProperties.@bluef, this.openGLESImageProperties.@alphaf);
                OpenGLESGL10Image.this.openGLESImageTranslate.translate2(gl, OpenGLESGL10Image.this);
                this.regionRectangleVertexFloatBuffer.put(this.regionRectangleFloatArray);
                this.glUtil.position(this.regionRectangleVertexFloatBuffer, 0);
                gl.glVertexPointer(3, GL10.GL_FLOAT, 0, this.regionRectangleVertexFloatBuffer);
                gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
                gl.glEnable(GL10.GL_TEXTURE_2D);
                gl.glBindTexture(GL10.GL_TEXTURE_2D, this.openGLESImageProperties.@textureID);
                gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
                this.glUtil.rotateUVs(this.regionTextureRectangleFloatArray, ((float) -this.openGLESImageProperties.@angle), 0.5f, 0.5f);
                this.glUtil.position(this.textureVertexFloatBuffer, 0);
                this.textureVertexFloatBuffer.put(this.regionTextureRectangleFloatArray);
                this.glUtil.position(this.textureVertexFloatBuffer, 0);
                gl.glTexCoordPointer(2, GL10.GL_FLOAT, 0, this.textureVertexFloatBuffer);
                //gl.glDrawArrays(GL10.GL_TRIANGLES, 1, 3);            
                gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, 4);
                gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
                gl.glDisableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
                gl.glDisable(GL10.GL_TEXTURE_2D);
                //Restore matrix
                gl.glPopMatrix();
            }

        };

    private OpenGLESImageDraw openGLESImageDraw = OpenGLESImageDraw.getInstance();

    public OpenGLESGL10Image(final Image image, final PlatformBitmapBaseFactory bitmapFactory, final PlatformTextureBaseFactory textureFactory) {
        super(image, bitmapFactory, textureFactory);
        this.initVertices();
    }

    /*     public OpenGLESGL10Image(GL10 gl, Image image, boolean matchColor)     {         super(gl, image, matchColor);          this.initVertices();                  this.update(gl);     }     */
    protected void initVertices() {
        this.textureVertexFloatBuffer.put(0f);
        this.textureVertexFloatBuffer.put(1f);
        this.textureVertexFloatBuffer.put(1f);
        this.textureVertexFloatBuffer.put(1f);
        this.textureVertexFloatBuffer.put(0f);
        this.textureVertexFloatBuffer.put(0f);
        this.textureVertexFloatBuffer.put(1f);
        this.textureVertexFloatBuffer.put(0f);
        this.textureVertexFloatBuffer.rewind();
    }

    @Override
    public void set(final GL gl) {
        final GL10 gl10 = ((GL10) gl);
        if (super.initTexture(gl10)) {
            //}
            this.textureFactory.load(gl10, GL10.GL_TEXTURE_2D, 0, this, 0, true);
            gl10.glDisable(GL10.GL_TEXTURE_2D);
            this.openGLESImageDraw = this.realOpenGLESImageDraw;
            OpenGLLogUtil.getInstance().logError(gl10, this);
        }
    }

    @Override
    public void drawRegion(final GL10 gl, final int viewHeight, final float x_src, final float y_src, final float width, final float height, final int x, final int y, final int z) {
        this.openGLESImageDraw.drawRegion(gl, viewHeight, x_src, y_src, width, height, x, y, z);
    }

    @Override
    public void draw(final GL10 gl, final int x, final int y, final int z) {
        this.openGLESImageDraw.draw(gl, x, y, z);
    }

}


