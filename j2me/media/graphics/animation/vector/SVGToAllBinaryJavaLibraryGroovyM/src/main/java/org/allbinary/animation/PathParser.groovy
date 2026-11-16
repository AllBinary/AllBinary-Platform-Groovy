/* Generated Code Do Not Modify */
package org.allbinary.animation;

import org.allbinary.util.BasicArrayList;
import org.allbinary.util.BasicArrayListD;
import org.allbinary.logic.StdUtil;

@groovy.transform.CompileStatic
public class PathParser {
    // Basic space/comma string tokenizer
    private static String[] tokenize(String d) {
        final BasicArrayList tokens = new BasicArrayListD();
        final StringBuffer sb = new StringBuffer();
        for (int i = 0; i < d.length(); i++) {
            char c = d.charAt(i);
            if (c == (' ' as char) || c == (',' as char) || c == ('\t' as char) || c == ('\n' as char) || c == ('\r' as char)) {
                if (sb.length() > 0) {
                    tokens.add(sb.toString());
                    sb.setLength(0);
                }
            } else if (c == ('M' as char) || c == ('m' as char) || c == ('L' as char) || c == ('l' as char) || c == ('V' as char) || c == ('v' as char) || c == ('C' as char) || c == ('c' as char) || c == ('Z' as char) || c == ('z' as char)) {
                if (sb.length() > 0) {
                    tokens.add(sb.toString());
                    sb.setLength(0);
                }
                tokens.add(String.valueOf(c));
            } else {
                sb.append(c);
            }
        }
        if (sb.length() > 0) {
            tokens.add(sb.toString());
        }
        final String[] res = new String[tokens.size()];
        tokens.toArrayType(res);
        return res;
    }

    public static int parsePath(String d, int[] outX, int[] outY, int maxPoints) {
        String[] tokens = tokenize(d);
        int[] count = new int[] {0};
        final FixedPoint fixedPoint = FixedPoint.getInstance();
        int curX = 0, curY = 0;
        int startX = 0, startY = 0;
        int idx = 0;
        while (idx < tokens.length) {
            String tok = tokens[idx++];
            char cmd = tok.charAt(0);
            if (cmd == ('M' as char) || cmd == ('m' as char)) {
                int x = fixedPoint.toFixed(Double.parseDouble(tokens[idx++]));
                int y = fixedPoint.toFixed(Double.parseDouble(tokens[idx++]));
                if (cmd == ('m' as char)) {
                    x += curX;
                    y += curY;
                }
                curX = x;
                curY = y;
                startX = x;
                startY = y;
                outX[count[0]] = curX;
                outY[count[0]] = curY;
                count[0]++;
            } else if (cmd == ('L' as char) || cmd == ('l' as char)) {
                int x = fixedPoint.toFixed(Double.parseDouble(tokens[idx++]));
                int y = fixedPoint.toFixed(Double.parseDouble(tokens[idx++]));
                if (cmd == ('l' as char)) {
                    x += curX;
                    y += curY;
                }
                curX = x;
                curY = y;
                outX[count[0]] = curX;
                outY[count[0]] = curY;
                count[0]++;
            } else if (cmd == ('V' as char) || cmd == ('v' as char)) {
                int y = fixedPoint.toFixed(Double.parseDouble(tokens[idx++]));
                if (cmd == ('v' as char)) {
                    y += curY;
                }
                curY = y;
                outX[count[0]] = curX;
                outY[count[0]] = curY;
                count[0]++;
            } else if (cmd == ('C' as char) || cmd == ('c' as char)) {
                int x1 = fixedPoint.toFixed(Double.parseDouble(tokens[idx++]));
                int y1 = fixedPoint.toFixed(Double.parseDouble(tokens[idx++]));
                int x2 = fixedPoint.toFixed(Double.parseDouble(tokens[idx++]));
                int y2 = fixedPoint.toFixed(Double.parseDouble(tokens[idx++]));
                int x3 = fixedPoint.toFixed(Double.parseDouble(tokens[idx++]));
                int y3 = fixedPoint.toFixed(Double.parseDouble(tokens[idx++]));
                if (cmd == ('c' as char)) {
                    x1 += curX;
                    y1 += curY;
                    x2 += curX;
                    y2 += curY;
                    x3 += curX;
                    y3 += curY;
                }
                PGUtil.getInstance().flattenCubicBezier(curX, curY, x1, y1, x2, y2, x3, y3, outX, outY, count, maxPoints);
                curX = x3;
                curY = y3;
            } else if (cmd == ('Z' as char) || cmd == ('z' as char)) {
                curX = startX;
                curY = startY;
                outX[count[0]] = curX;
                outY[count[0]] = curY;
                count[0]++;
            }
            // Implicit next points handler (if next token is a number instead of a command)
            while (idx < tokens.length && !isCommand(tokens[idx])) {
                // If it was lineTo/MoveTo parameters following without explicit token
                if (cmd == ('M' as char) || cmd == ('m' as char) || cmd == ('L' as char) || cmd == ('l' as char)) {
                    int x = fixedPoint.toFixed(Double.parseDouble(tokens[idx++]));
                    int y = fixedPoint.toFixed(Double.parseDouble(tokens[idx++]));
                    if (cmd == ('m' as char) || cmd == ('l' as char)) {
                        x += curX;
                        y += curY;
                    }
                    curX = x;
                    curY = y;
                    outX[count[0]] = curX;
                    outY[count[0]] = curY;
                    count[0]++;
                } else if (cmd == ('V' as char) || cmd == ('v' as char)) {
                    int y = fixedPoint.toFixed(Double.parseDouble(tokens[idx++]));
                    if (cmd == ('v' as char)) {
                        y += curY;
                    }
                    curY = y;
                    outX[count[0]] = curX;
                    outY[count[0]] = curY;
                    count[0]++;
                }
            }
        }
        return count[0];
    }

    private static boolean isCommand(String tok) {
        char c = tok.charAt(0);
        return 'MmLlVvCcZz'.indexOf(((int) c)) >= 0;
    }

}


