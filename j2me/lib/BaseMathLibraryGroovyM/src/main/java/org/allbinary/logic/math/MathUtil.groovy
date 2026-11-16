/* Generated Code Do Not Modify */
package org.allbinary.logic.math;

import jsinterop.annotations.JsType;

/**  *  * @author user  */
@JsType
@groovy.transform.CompileStatic
public class MathUtil {
    private static final MathUtil instance = new MathUtil();

    public static MathUtil getInstance() {
        return MathUtil.instance;
    }

    public int getTotalDigits(int digits) {
        int total = 0;
        while (digits > 0) {
            digits = Math.divideExact(digits, 10);
            total++;
        }
        return total;
    }

    public int sqrt(final int value) {
        if (value <= 1) {
            return value;
        }
        int accumulated = value >> 1;
        int result = (accumulated + (Math.divideExact(value, accumulated))) >> 1;
        do {
            accumulated = result;
            result = (accumulated + (Math.divideExact(value, accumulated))) >> 1;
        } while (accumulated > result);
        return accumulated;
    }

    //1000
    private final int ACCURACY = 100;

    public double sqrtd(int x) {
        if (x == 0) {
            return ((double) 0.0f);
        }
        if (x < 0) {
            return ((double) -1.0f);
        }
        double result = ((double) x);
        for (int index = 0; index < this.ACCURACY; index++) {
            result = (result + (x / result)) / 2;
        }
        return result;
    }

    public int abs(int value) {
        return (value < 0) ? -value : value;
    }

    public long abslong(long value) {
        return (value < 0) ? -value : value;
    }

    public int min(int value, int value2) {
        return (value <= value2) ? value : value2;
    }

    public int max(int value, int value2) {
        return (value >= value2) ? value : value2;
    }

}


