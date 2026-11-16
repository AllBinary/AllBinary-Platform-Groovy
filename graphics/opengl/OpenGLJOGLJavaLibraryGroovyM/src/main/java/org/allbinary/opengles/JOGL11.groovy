/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package org.allbinary.opengles;

import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;

//JOGLEToKhronosGL11
@groovy.transform.CompileStatic
public class JOGL11 extends JOGL10 implements javax.microedition.khronos.opengles.GL11 {
    //    private final String TARGET = "target: ";
    private final GL2 gl11;

    public JOGL11(final GL gl) {
        this(gl, ((com.jogamp.opengl.GL2) gl));
    }

    public JOGL11(final GL gl, final com.jogamp.opengl.GL2 gl2) {
        super(gl, gl2);
        //PreLogUtil.put(StringUtil.getInstance().EMPTY_STRING, this, this.commonStrings.CONSTRUCTOR);
        this.gl11 = getJOGLGL();
    }

    //    }
    public void glBindBuffer(int target, int buffer) {
        //PreLogUtil.put(stringBuilder.append(TARGET).append(target).append(" buffer: ").append(buffer).toString(), this, "GL11.glBindBuffer");
        this.gl11.glBindBuffer(target, buffer);
    }

    public void glBufferData(int target, int size, java.nio.Buffer data, int usage) {
        //PreLogUtil.put(stringBuilder.append(TARGET).append(target).append(" size: ").append(size).append(" data: ").append(data).append(" usage: ").append(usage).toString(), this, "GL11.glBufferData");
        this.gl11.glBufferData(target, size, data, usage);
    }

    public void glBufferSubData(int target, int offset, int size, java.nio.Buffer data) {
        //PreLogUtil.put(stringBuilder.append(TARGET).append(target).append(" size: ").append(size).append(" data: ").append(data).toString(), this, "GL11.glBufferSubData");
        this.gl11.glBufferSubData(target, offset, size, data);
    }

    public void glClipPlanef(int plane, float[] equation, int offset) {
        //PreLogUtil.put(stringBuilder.append("plane: ").append(plane).append(" equation: ").append(equation.length).toString(), this, "GL11.glClipPlanef");
        this.gl11.glClipPlanef(plane, equation, offset);
    }

    public void glClipPlanef(int plane, java.nio.FloatBuffer equation) {
        //PreLogUtil.put(stringBuilder.append("plane: ").append(plane).append(" equation: ").append(equation).toString(), this, "GL11.glClipPlanef");
        this.gl11.glClipPlanef(plane, equation);
    }

    //    }
    public void glColor4ub(byte red, byte green, byte blue, byte alpha) {
        //PreLogUtil.put(stringBuilder.append(RED).append(red).append(GREEN).append(green).append(BLUE).append(blue).append(ALPHA).append(alpha).toString(), this, "GL11.glColor4ub");
        this.gl11.glColor4ub(red, green, blue, alpha);
    }

    public void glColorPointer(int size, int type, int stride, int offset) {
        //PreLogUtil.put(stringBuilder.append(" size: ").append(size).append(" type: ").append(type).toString(), this, "GL11.glColorPointer");
        this.gl11.glColorPointer(size, type, stride, offset);
    }

    public void glDeleteBuffers(int n, int[] buffers, int offset) {
        //PreLogUtil.put(stringBuilder.append(" n: ").append(n).append(" buffers: ").append(buffers.length).toString(), this, "GL11.glDeleteBuffers");
        this.gl11.glDeleteBuffers(n, buffers, offset);
    }

    public void glDeleteBuffers(int n, java.nio.IntBuffer buffers) {
        //PreLogUtil.put(stringBuilder.append(" n: ").append(n).append(" buffers: ").append(buffers).toString(), this, "GL11.glDeleteBuffers");
        this.gl11.glDeleteBuffers(n, buffers);
    }

    public void glDrawElements(int mode, int count, int type, int offset) {
        //PreLogUtil.put(stringBuilder.append(" mode: ").append(mode).append(" count: ").append(count).append(" type: ").append(type).toString(), this, "GL11.glDrawElements");
        this.gl11.glDrawElements(mode, count, type, offset);
    }

    public void glGenBuffers(int n, int[] buffers, int offset) {
        //PreLogUtil.put(stringBuilder.append(" n: ").append(n).append(" buffers: ").append(buffers.length).toString(), this, "GL11.glGenBuffers");
        this.gl11.glGenBuffers(n, buffers, offset);
    }

    public void glGenBuffers(int n, java.nio.IntBuffer buffers) {
        //PreLogUtil.put(stringBuilder.append(" n: ").append(n).append(" buffers: ").append(buffers).toString(), this, "GL11.glGenBuffers");
        this.gl11.glGenBuffers(n, buffers);
    }

    //    }
    public void glGetBufferParameteriv(int target, int pname, int[] params, int offset) {
        //PreLogUtil.put(stringBuilder.append(TARGET).append(target).append(PNAME).append(pname).append(PARAMS).append(params.length).toString(), this, "GL11.glGetBufferParameteriv");
        this.gl11.glGetBufferParameteriv(target, pname, params, offset);
    }

    public void glGetBufferParameteriv(int target, int pname, java.nio.IntBuffer params) {
        //PreLogUtil.put(stringBuilder.append(TARGET).append(target).append(PNAME).append(pname).append(PARAMS).append(params).toString(), this, "GL11.glGetBufferParameteriv");
        this.gl11.glGetBufferParameteriv(target, pname, params);
    }

    public void glGetClipPlanef(int pname, float[] eqn, int offset) {
        //PreLogUtil.put(stringBuilder.append(PNAME).append(pname).append(" eqn: ").append(eqn.length).toString(), this, "GL11.glGetClipPlanef");
        this.gl11.glGetClipPlanef(pname, eqn, offset);
    }

    public void glGetClipPlanef(int pname, java.nio.FloatBuffer eqn) {
        //PreLogUtil.put(stringBuilder.append(PNAME).append(pname).append(" eqn: ").append(eqn).toString(), this, "GL11.glGetClipPlanef");
        this.gl11.glGetClipPlanef(pname, eqn);
    }

    //    }
    public void glGetFloatv(int pname, float[] params, int offset) {
        //PreLogUtil.put(stringBuilder.append(PNAME).append(pname).append(PARAMS).append(params).toString(), this, "GL11.glGetFloatv");
        this.gl11.glGetFloatv(pname, params, offset);
    }

    public void glGetFloatv(int pname, java.nio.FloatBuffer params) {
        //PreLogUtil.put(stringBuilder.append(PNAME).append(pname).append(PARAMS).append(params).toString(), this, "GL11.glGetFloatv");
        this.gl11.glGetFloatv(pname, params);
    }

    public void glGetLightfv(int light, int pname, float[] params, int offset) {
        //PreLogUtil.put(stringBuilder.append(LIGHT).append(light).append(PNAME).append(pname).append(PARAMS).append(params).toString(), this, "GL11.glGetLightfv");
        this.gl11.glGetLightfv(light, pname, params, offset);
    }

    public void glGetLightfv(int light, int pname, java.nio.FloatBuffer params) {
        //PreLogUtil.put(stringBuilder.append(LIGHT).append(light).append(PNAME).append(pname).append(PARAMS).append(params).toString(), this, "GL11.glGetLightfv");
        this.gl11.glGetLightfv(light, pname, params);
    }

    //    }
    public void glGetMaterialfv(int face, int pname, float[] params, int offset) {
        //PreLogUtil.put(stringBuilder.append(FACE).append(face).append(PNAME).append(pname).append(PARAMS).append(params.length).toString(), this, "GL11.glGetMaterialfv");
        this.gl11.glGetMaterialfv(face, pname, params, offset);
    }

    public void glGetMaterialfv(int face, int pname, java.nio.FloatBuffer params) {
        //PreLogUtil.put(stringBuilder.append(FACE).append(face).append(PNAME).append(pname).append(PARAMS).append(params).toString(), this, "GL11.glGetMaterialfv");
        this.gl11.glGetMaterialfv(face, pname, params);
    }

    //    }
    public void glGetTexEnviv(int env, int pname, int[] params, int offset) {
        //PreLogUtil.put(stringBuilder.append("env: ").append(env).append(PNAME).append(pname).append(PARAMS).append(params).toString(), this, "GL11.glGetTexEnviv");
        this.gl11.glGetTexEnviv(env, pname, params, offset);
    }

    public void glGetTexEnviv(int env, int pname, java.nio.IntBuffer params) {
        //PreLogUtil.put(stringBuilder.append("env: ").append(env).append(PNAME).append(pname).append(PARAMS).append(params).toString(), this, "GL11.glGetTexEnviv");
        this.gl11.glGetTexEnviv(env, pname, params);
    }

    //    }
    public void glGetTexParameterfv(int target, int pname, float[] params, int offset) {
        //PreLogUtil.put(stringBuilder.append(TARGET).append(target).append(PNAME).append(pname).append(PARAMS).append(params.length).toString(), this, "GL11.glGetTexParameterfv");
        this.gl11.glGetTexParameterfv(target, pname, params, offset);
    }

    public void glGetTexParameterfv(int target, int pname, java.nio.FloatBuffer params) {
        //PreLogUtil.put(stringBuilder.append(TARGET).append(target).append(PNAME).append(pname).append(PARAMS).append(params).toString(), this, "GL11.glGetTexParameterfv");
        this.gl11.glGetTexParameterfv(target, pname, params);
    }

    public void glGetTexParameteriv(int target, int pname, int[] params, int offset) {
        //PreLogUtil.put(stringBuilder.append(TARGET).append(target).append(PNAME).append(pname).append(PARAMS).append(params).toString(), this, "GL11.glGetTexParameteriv");
        this.gl11.glGetTexParameteriv(target, pname, params, offset);
    }

    public void glGetTexParameteriv(int target, int pname, java.nio.IntBuffer params) {
        //PreLogUtil.put(stringBuilder.append(TARGET).append(target).append(PNAME).append(pname).append(PARAMS).append(params).toString(), this, "GL11.glGetTexParameteriv");
        this.gl11.glGetTexParameteriv(target, pname, params);
    }

    //    }
    public boolean glIsBuffer(int buffer) {
        //PreLogUtil.put(stringBuilder.append("buffer: ").append(buffer).toString(), this, "GL11.glIsBuffer");
        return this.gl11.glIsBuffer(buffer);
    }

    public boolean glIsEnabled(int cap) {
        //PreLogUtil.put(stringBuilder.append("cap: ").append(cap).toString(), this, "GL11.glIsEnabled");
        return this.gl11.glIsEnabled(cap);
    }

    public boolean glIsTexture(int texture) {
        //PreLogUtil.put(stringBuilder.append("texture: ").append(texture).toString(), this, "GL11.texture");
        return this.gl11.glIsTexture(texture);
    }

    public void glNormalPointer(int type, int stride, int offset) {
        //PreLogUtil.put(stringBuilder.append("type: ").append(type).append(" stride: ").append(stride).toString(), this, "GL11.glNormalPointer");
        this.gl11.glNormalPointer(type, stride, offset);
    }

    public void glPointParameterf(int pname, float param) {
        //PreLogUtil.put(stringBuilder.append(PNAME).append(pname).append(PARAM).append(param).toString(), this, "GL11.glPointParameterf");
        this.gl11.glPointParameterf(pname, param);
    }

    public void glPointParameterfv(int pname, float[] params, int offset) {
        //PreLogUtil.put(stringBuilder.append(PNAME).append(pname).append(PARAMS).append(params).toString(), this, "GL11.glPointParameterfv");
        this.gl11.glPointParameterfv(pname, params, offset);
    }

    public void glPointParameterfv(int pname, java.nio.FloatBuffer params) {
        //PreLogUtil.put(stringBuilder.append(PNAME).append(pname).append(PARAMS).append(params).toString(), this, "GL11.glPointParameterfv");
        this.gl11.glPointParameterfv(pname, params);
    }

    //    }
    public void glTexCoordPointer(int size, int type, int stride, int offset) {
        //PreLogUtil.put(stringBuilder.append("size: ").append(size).append(" type: ").append(type).append(" stride: ").append(stride).toString(), this, "GL11.glTexCoordPointer");
        this.gl11.glTexCoordPointer(size, type, stride, offset);
    }

    public void glTexEnvi(int target, int pname, int param) {
        //PreLogUtil.put(stringBuilder.append(TARGET).append(target).append(PNAME).append(pname).append(PARAM).append(param).toString(), this, "GL11.glTexEnvi");
        this.gl11.glTexEnvi(target, pname, param);
    }

    public void glTexEnviv(int target, int pname, int[] params, int offset) {
        //PreLogUtil.put(stringBuilder.append(TARGET).append(target).append(PNAME).append(pname).append(PARAMS).append(params.length).toString(), this, "GL11.glTexEnvi");
        this.gl11.glTexEnviv(target, pname, params, offset);
    }

    public void glTexEnviv(int target, int pname, java.nio.IntBuffer params) {
        //PreLogUtil.put(stringBuilder.append(TARGET).append(target).append(PNAME).append(pname).append(PARAMS).append(params).toString(), this, "GL11.glTexEnvi");
        this.gl11.glTexEnviv(target, pname, params);
    }

    public void glTexParameterfv(int target, int pname, float[] params, int offset) {
        //PreLogUtil.put(stringBuilder.append(TARGET).append(target).append(PNAME).append(pname).append(PARAMS).append(params).toString(), this, "GL11.glTexParameterfv");
        this.gl11.glTexParameterfv(target, pname, params, offset);
    }

    public void glTexParameterfv(int target, int pname, java.nio.FloatBuffer params) {
        //PreLogUtil.put(stringBuilder.append(TARGET).append(target).append(PNAME).append(pname).append(PARAMS).append(params).toString(), this, "GL11.glTexParameterfv");
        this.gl11.glTexParameterfv(target, pname, params);
    }

    public void glTexParameteri(int target, int pname, int param) {
        //PreLogUtil.put(stringBuilder.append(TARGET).append(target).append(PNAME).append(pname).append(PARAM).append(param).toString(), this, "GL11.glTexParameteri");
        this.gl11.glTexParameteri(target, pname, param);
    }

    public void glTexParameteriv(int target, int pname, int[] params, int offset) {
        //PreLogUtil.put(stringBuilder.append(TARGET).append(target).append(PNAME).append(pname).append(PARAMS).append(params).toString(), this, "GL11.glTexParameteriv");
        this.gl11.glTexParameteriv(target, pname, params, offset);
    }

    public void glTexParameteriv(int target, int pname, java.nio.IntBuffer params) {
        //PreLogUtil.put(stringBuilder.append(TARGET).append(target).append(PNAME).append(pname).append(PARAMS).append(params).toString(), this, "GL11.glTexParameteriv");
        this.gl11.glTexParameteriv(target, pname, params);
    }

    public void glTexParameterxv(int target, int pname, int[] params, int offset) {
        //PreLogUtil.put(stringBuilder.append(TARGET).append(target).append(PNAME).append(pname).append(PARAMS).append(params).toString(), this, "GL11.glTexParameteriv");
        this.gl11.glTexParameteriv(target, pname, params, offset);
    }

    //    }
    public void glVertexPointer(int size, int type, int stride, int offset) {
        //PreLogUtil.put(stringBuilder.append(" size: ").append(size).append(" type: ").append(type).toString(), this, "GL11.glVertexPointer");
        this.gl11.glVertexPointer(size, type, stride, offset);
    }

}


