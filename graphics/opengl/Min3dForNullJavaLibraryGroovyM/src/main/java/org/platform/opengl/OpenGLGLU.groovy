/* Generated Code Do Not Modify */
package org.platform.opengl;

import javax.microedition.khronos.opengles.GL10;

/**  *  * @author User  */
@groovy.transform.CompileStatic
public class OpenGLGLU {
    private static final OpenGLGLU instance = new OpenGLGLU();

    /**      * @return the instance      */
    public static OpenGLGLU getInstance() {
        return OpenGLGLU.instance;
    }

    public void gluLookAt(final GL10 gl, final float eyeX, final float eyeY, final float eyeZ, final float centerX, final float centerY, final float centerZ, final float upX, final float upY, final float upZ) {
        throw new RuntimeException();
    }

    public int gluProject(final GL10 gl, float objX, float objY, float objZ, float[] model, int modelOffset, float[] project, int projectOffset, int[] view, int viewOffset, float[] win, int winOffset) {
        throw new RuntimeException();
    }

    public int gluUnProject(final GL10 gl, final float winX, final float winY, final float winZ, final float[] model, final int modelOffset, final float[] project, final int projectOffset, final int[] view, final int viewOffset, float[] obj, final int objOffset) {
        throw new RuntimeException();
    }

    //    }
    public void glFrustumf(final GL10 gl, final float lt, final float rt, final float btm, final float top, final float zNear, final float zFar) {
        throw new RuntimeException();
    }

}


