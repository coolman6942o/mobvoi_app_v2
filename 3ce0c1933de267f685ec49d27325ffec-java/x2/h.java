package x2;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes.dex */
public class h {
    public static byte a(String str, byte b10) {
        try {
            return Byte.parseByte(str, 16);
        } catch (Exception unused) {
            return b10;
        }
    }

    public static int b(String str, int i10) {
        try {
            return Integer.parseInt(str);
        } catch (Exception unused) {
            return i10;
        }
    }

    public static String c(String str) {
        return d(null, str);
    }

    public static String d(Date date, String str) {
        if (date == null) {
            date = new Date();
        }
        if (str == null) {
            str = g.a(118, 123, "?8%.\u007f\u0000\u0005nz}4GB?mv,b\u007f");
        }
        return new SimpleDateFormat(str).format(date);
    }

    public static String e(String str, int i10, int i11) {
        int i12 = i10 - 3;
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        int i13 = 0;
        while (i13 != length) {
            i12 += i11;
            i13++;
            charArray[i13] = (char) (charArray[i13] ^ (i12 & 95));
        }
        return String.valueOf(charArray, 0, length).intern();
    }

    public static String f(Exception exc) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        exc.printStackTrace(printStream);
        String byteArrayOutputStream2 = byteArrayOutputStream.toString();
        try {
            printStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream2;
        } catch (IOException unused) {
            return "";
        }
    }
}
