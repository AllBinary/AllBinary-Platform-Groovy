/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.image.opengles;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;
import javax.microedition.lcdui.Image;
import org.allbinary.graphics.opengles.OpenGLLogUtil;
import org.allbinary.graphics.displayable.DisplayInfoSingleton;
import org.allbinary.opengles.GLUtil;
import org.allbinary.platform.graphics.PlatformBitmapBaseFactory;
import org.allbinary.platform.opengles.PlatformTextureBaseFactory;

//This is not actually VBO impl
@groovy.transform.CompileStatic
public class OpenGLESGL11VBOImage extends OpenGLESImage {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    private final GLUtil glUtil = GLUtil.getInstance();

    private FloatBuffer textureVertexFloatBuffer = ByteBuffer.allocateDirect(4 * 4 * 2).order(ByteOrder.nativeOrder()).asFloatBuffer();

    public OpenGLESGL11VBOImage(final Image image, final PlatformBitmapBaseFactory bitmapFactory, final PlatformTextureBaseFactory textureFactory) {
        super(image, bitmapFactory, textureFactory);
        this.initVertices();
        this.regionRectangleVertexFloatBuffer.put(FloatBuffer.wrap(this.regionRectangleFloatArray));
        this.regionTextureVertexFloatBuffer.put(FloatBuffer.wrap(this.regionTextureRectangleFloatArray));
    }

    /*     public OpenGLESGL10Image(GL10 gl, Image image, boolean matchColor)     {         super(gl, image, matchColor);          this.init();                  this.update(gl);     }     */
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
            OpenGLLogUtil.getInstance().logError(gl10, this);
        }
    }

    protected final float[] regionRectangleFloatArray = new float[] {0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f};

    protected FloatBuffer regionRectangleVertexFloatBuffer = ByteBuffer.allocateDirect(4 * 4 * 3).order(ByteOrder.nativeOrder()).asFloatBuffer();

    private final float[] regionTextureRectangleFloatArray = new float[8];

    private FloatBuffer regionTextureVertexFloatBuffer = ByteBuffer.allocateDirect(4 * 4 * 2).order(ByteOrder.nativeOrder()).asFloatBuffer();

    @Override
    public void drawRegion(final GL10 gl, final int viewHeight, final float x_src, final float y_src, final float width, final float height, final int x, final int y, final int z) {
        this.regionRectangleFloatArray[0] = x;
        this.regionRectangleFloatArray[7] = viewHeight - y;
        this.regionRectangleFloatArray[1] = ((float) (this.regionRectangleFloatArray[7] - height));
        this.regionRectangleFloatArray[3] = ((float) (x + width));
        this.regionRectangleFloatArray[4] = this.regionRectangleFloatArray[1];
        this.regionRectangleFloatArray[6] = x;
        this.regionRectangleFloatArray[9] = this.regionRectangleFloatArray[3];
        this.regionRectangleFloatArray[10] = this.regionRectangleFloatArray[7];
        //regionTextureVertexFloatBuffer.rewind();
        this.regionTextureRectangleFloatArray[0] = ((float) (x_src / this.getWidth()));
        this.regionTextureRectangleFloatArray[1] = ((float) ((((float) (y_src + height))) / this.getHeight()));
        this.regionTextureRectangleFloatArray[2] = ((float) ((((float) (x_src + width))) / this.getWidth()));
        this.regionTextureRectangleFloatArray[3] = this.regionTextureRectangleFloatArray[1];
        this.regionTextureRectangleFloatArray[4] = this.regionTextureRectangleFloatArray[0];
        this.regionTextureRectangleFloatArray[5] = ((float) (y_src / this.getHeight()));
        this.regionTextureRectangleFloatArray[6] = this.regionTextureRectangleFloatArray[2];
        this.regionTextureRectangleFloatArray[7] = this.regionTextureRectangleFloatArray[5];
        /*         float textureX1 = x_src / this.getWidth();         float textureY1 = y_src / this.getHeight();         float textureY2 = ((float) (y_src + height)) / this.getHeight();         float textureX2 = ((float) (x_src + width)) / this.getWidth();                  textureVertexFloatBuffer.put(textureX1);         textureVertexFloatBuffer.put(textureY2);          textureVertexFloatBuffer.put(textureX2);         textureVertexFloatBuffer.put(textureY2);          textureVertexFloatBuffer.put(textureX1);         textureVertexFloatBuffer.put(textureY1);          textureVertexFloatBuffer.put(textureX2);         textureVertexFloatBuffer.put(textureY1);         */
        this.glUtil.position(this.regionRectangleVertexFloatBuffer, 0);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, this.regionRectangleVertexFloatBuffer);
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glEnable(GL10.GL_TEXTURE_2D);
        gl.glBindTexture(GL10.GL_TEXTURE_2D, this.openGLESImageProperties.@textureID);
        gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
        this.glUtil.position(this.regionTextureVertexFloatBuffer, 0);
        gl.glTexCoordPointer(2, GL10.GL_FLOAT, 0, this.regionTextureVertexFloatBuffer);
        // ((GL11Ext) gl).glDrawTexiOES(x, a - y, z, width, height);
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, 4);
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glDisableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
        gl.glDisable(GL10.GL_TEXTURE_2D);
    }

    @Override
    public void draw(final GL10 gl, final int x, final int y, final int z) {
        this.regionRectangleFloatArray[0] = x;
        this.regionRectangleFloatArray[7] = ((float) (DisplayInfoSingleton.getInstance().getLastHeight() - y));
        this.regionRectangleFloatArray[1] = ((float) (this.regionRectangleFloatArray[7] - this.getHeight()));
        this.regionRectangleFloatArray[3] = ((float) (x + this.getWidth()));
        this.regionRectangleFloatArray[4] = this.regionRectangleFloatArray[1];
        this.regionRectangleFloatArray[6] = x;
        //regionRectangleVertexFloatBuffer.put(regionRectangleVertexFloatBuffer.get(7));
        this.regionRectangleFloatArray[9] = this.regionRectangleFloatArray[3];
        this.regionRectangleFloatArray[10] = this.regionRectangleFloatArray[7];
        //textureVertexFloatBuffer.rewind();
        this.glUtil.position(this.regionRectangleVertexFloatBuffer, 0);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, this.regionRectangleVertexFloatBuffer);
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glEnable(GL10.GL_TEXTURE_2D);
        gl.glBindTexture(GL10.GL_TEXTURE_2D, this.openGLESImageProperties.@textureID);
        gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
        this.glUtil.position(this.textureVertexFloatBuffer, 0);
        gl.glTexCoordPointer(2, GL10.GL_FLOAT, 0, this.textureVertexFloatBuffer);
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, 4);
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glDisableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
        gl.glDisable(GL10.GL_TEXTURE_2D);
    }

}


