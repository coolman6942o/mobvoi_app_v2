package g4;

import c4.a;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static String f27257a = "";

    /* renamed from: b  reason: collision with root package name */
    public static String f27258b = "";

    /* renamed from: c  reason: collision with root package name */
    public static String f27259c = "";

    public static synchronized void a(String str) {
        synchronized (d.class) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            d(arrayList);
        }
    }

    public static synchronized void b(String str, String str2, String str3) {
        synchronized (d.class) {
            f27257a = str;
            f27258b = str2;
            f27259c = str3;
        }
    }

    public static synchronized void c(Throwable th2) {
        String str;
        synchronized (d.class) {
            ArrayList arrayList = new ArrayList();
            if (th2 != null) {
                StringWriter stringWriter = new StringWriter();
                th2.printStackTrace(new PrintWriter(stringWriter));
                str = stringWriter.toString();
            } else {
                str = "";
            }
            arrayList.add(str);
            d(arrayList);
        }
    }

    public static synchronized void d(List<String> list) {
        synchronized (d.class) {
            if (!a.d(f27258b) && !a.d(f27259c)) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(f27259c);
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    stringBuffer.append(", " + it.next());
                }
                stringBuffer.append("\n");
                try {
                    File file = new File(f27257a);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    File file2 = new File(f27257a, f27258b);
                    if (!file2.exists()) {
                        file2.createNewFile();
                    }
                    FileWriter fileWriter = ((long) stringBuffer.length()) + file2.length() <= 51200 ? new FileWriter(file2, true) : new FileWriter(file2);
                    fileWriter.write(stringBuffer.toString());
                    fileWriter.flush();
                    fileWriter.close();
                } catch (Exception unused) {
                }
            }
        }
    }
}
