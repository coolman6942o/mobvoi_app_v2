package com.amap.api.mapcore2d;

import android.content.Context;
import android.os.Looper;
import com.amap.api.mapcore2d.p;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import k4.l;
import k4.n;
import k4.o;
/* compiled from: LogProcessor.java */
/* loaded from: classes.dex */
public abstract class m {

    /* renamed from: c  reason: collision with root package name */
    static final List<Object> f6999c = Collections.synchronizedList(new ArrayList());

    /* renamed from: a  reason: collision with root package name */
    private int f7000a;

    /* renamed from: b  reason: collision with root package name */
    private o f7001b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LogProcessor.java */
    /* loaded from: classes.dex */
    public class a implements o {

        /* renamed from: a  reason: collision with root package name */
        private l f7002a;

        a(l lVar) {
            this.f7002a = lVar;
        }

        @Override // k4.o
        public void a(String str) {
            try {
                this.f7002a.b(str, h.b(m.this.p()));
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public m(int i10) {
        this.f7000a = i10;
    }

    public static String a(Context context, f fVar) {
        return s.b(context, fVar);
    }

    private String b(Context context, String str) {
        try {
            return c.c(context, g.f(str));
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    private void j(l lVar, String str, String str2, int i10, boolean z10) {
        k4.m e10 = h.e(i10);
        e10.b(0);
        e10.f(str);
        e10.c(str2);
        lVar.a(e10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v10, types: [com.amap.api.mapcore2d.p] */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4, types: [com.amap.api.mapcore2d.p] */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6, types: [com.amap.api.mapcore2d.p] */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v9, types: [com.amap.api.mapcore2d.p] */
    /* JADX WARN: Type inference failed for: r9v0, types: [k4.l] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v11, types: [com.amap.api.mapcore2d.p$e] */
    /* JADX WARN: Type inference failed for: r9v12, types: [com.amap.api.mapcore2d.p$e] */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v4, types: [com.amap.api.mapcore2d.p$e] */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v6, types: [com.amap.api.mapcore2d.p$e] */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9 */
    private boolean k(Context context, String str, String str2, String str3, l lVar) {
        IOException e10;
        Throwable th2;
        OutputStream outputStream = null;
        try {
            try {
                try {
                    File file = new File(h.c(context, str2));
                    if (!file.exists() && !file.mkdirs()) {
                        return false;
                    }
                    str2 = p.i(file, 1, 1, 20480L);
                    try {
                        str2.w(e(lVar));
                        lVar = str2.h(str);
                        if (lVar != 0) {
                            try {
                                lVar.close();
                            } catch (Throwable th3) {
                                th3.printStackTrace();
                            }
                            if (!str2.W()) {
                                try {
                                    str2.close();
                                } catch (Throwable th4) {
                                    th4.printStackTrace();
                                }
                            }
                            return false;
                        }
                        try {
                            byte[] f10 = g.f(str3);
                            p.d x10 = str2.x(str);
                            outputStream = x10.b(0);
                            outputStream.write(f10);
                            x10.c();
                            str2.h0();
                            try {
                                outputStream.close();
                            } catch (Throwable th5) {
                                th5.printStackTrace();
                            }
                            if (lVar != 0) {
                                try {
                                    lVar.close();
                                } catch (Throwable th6) {
                                    th6.printStackTrace();
                                }
                            }
                            if (!str2.W()) {
                                try {
                                    str2.close();
                                } catch (Throwable th7) {
                                    th7.printStackTrace();
                                }
                            }
                            return true;
                        } catch (IOException e11) {
                            e10 = e11;
                            e10.printStackTrace();
                            if (outputStream != null) {
                                try {
                                    outputStream.close();
                                } catch (Throwable th8) {
                                    th8.printStackTrace();
                                }
                            }
                            if (lVar != 0) {
                                try {
                                    lVar.close();
                                } catch (Throwable th9) {
                                    th9.printStackTrace();
                                }
                            }
                            if (str2 != 0 && !str2.W()) {
                                str2.close();
                                str2 = str2;
                                lVar = lVar;
                            }
                            return false;
                        } catch (Throwable th10) {
                            th2 = th10;
                            th2.printStackTrace();
                            if (outputStream != null) {
                                try {
                                    outputStream.close();
                                } catch (Throwable th11) {
                                    th11.printStackTrace();
                                }
                            }
                            if (lVar != 0) {
                                try {
                                    lVar.close();
                                } catch (Throwable th12) {
                                    th12.printStackTrace();
                                }
                            }
                            if (str2 != 0 && !str2.W()) {
                                str2.close();
                                str2 = str2;
                                lVar = lVar;
                            }
                            return false;
                        }
                    } catch (IOException e12) {
                        e10 = e12;
                        lVar = 0;
                    } catch (Throwable th13) {
                        th2 = th13;
                        lVar = 0;
                    }
                } catch (Throwable th14) {
                    th14.printStackTrace();
                    return false;
                }
            } catch (IOException e13) {
                e10 = e13;
                str2 = 0;
                lVar = 0;
            } catch (Throwable th15) {
                th2 = th15;
                str2 = 0;
                lVar = 0;
            }
        } catch (Throwable th16) {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Throwable th17) {
                    th17.printStackTrace();
                }
            }
            if (lVar != 0) {
                try {
                    lVar.close();
                } catch (Throwable th18) {
                    th18.printStackTrace();
                }
            }
            if (str2 != 0 && !str2.W()) {
                try {
                    str2.close();
                } catch (Throwable th19) {
                    th19.printStackTrace();
                }
            }
            throw th16;
        }
    }

    public static boolean l(String[] strArr, String str) {
        if (!(strArr == null || str == null)) {
            try {
                for (String str2 : str.split("\n")) {
                    if (o(strArr, str2.trim())) {
                        return true;
                    }
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        return false;
    }

    public static String n(Throwable th2) {
        return g.c(th2);
    }

    public static boolean o(String[] strArr, String str) {
        if (!(strArr == null || str == null)) {
            try {
                for (String str2 : strArr) {
                    str = str.trim();
                    if (str.startsWith("at ")) {
                        if (str.contains(str2 + ".") && str.endsWith(")")) {
                            return true;
                        }
                    }
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        return false;
    }

    private String q(Throwable th2) {
        return th2.toString();
    }

    private List<f> r(Context context) {
        List<f> list = null;
        try {
            synchronized (Looper.getMainLooper()) {
                list = new n(context, false).b();
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return list;
    }

    protected String c(String str) {
        return e.a(str);
    }

    protected String d(Throwable th2) {
        try {
            return n(th2);
        } catch (Throwable th3) {
            th3.printStackTrace();
            return null;
        }
    }

    protected o e(l lVar) {
        try {
            if (this.f7001b == null) {
                this.f7001b = new a(lVar);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return this.f7001b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(Context context, Throwable th2, String str, String str2) {
        String d10;
        List<f> r10 = r(context);
        if (r10 != null && r10.size() != 0 && (d10 = d(th2)) != null && !"".equals(d10)) {
            for (f fVar : r10) {
                if (l(fVar.f(), d10)) {
                    i(fVar, context, th2, d10.replaceAll("\n", "<br/>"), str, str2);
                    return;
                }
            }
            if (d10.contains("com.amap.api.col")) {
                try {
                    i(g.a(), context, th2, d10, str, str2);
                } catch (co e10) {
                    e10.printStackTrace();
                }
            }
        }
    }

    protected void g(f fVar) {
    }

    void h(f fVar, Context context, String str, String str2, String str3, String str4) {
        g(fVar);
        String a10 = s.a();
        String a11 = a(context, fVar);
        String a12 = b.a(context);
        if (str != null && !"".equals(str)) {
            int p10 = p();
            StringBuilder sb2 = new StringBuilder();
            if (str3 != null) {
                sb2.append("class:");
                sb2.append(str3);
            }
            if (str4 != null) {
                sb2.append(" method:");
                sb2.append(str4);
                sb2.append("$");
                sb2.append("<br/>");
            }
            sb2.append(str2);
            String c10 = c(str2);
            String c11 = s.c(a12, a11, a10, p10, str, sb2.toString());
            if (c11 != null && !"".equals(c11)) {
                String b10 = b(context, c11);
                String m10 = m();
                synchronized (Looper.getMainLooper()) {
                    l lVar = new l(context);
                    j(lVar, fVar.a(), c10, p10, k(context, c10, m10, b10, lVar));
                }
            }
        }
    }

    void i(f fVar, Context context, Throwable th2, String str, String str2, String str3) {
        h(fVar, context, q(th2), str, str2, str3);
    }

    protected String m() {
        return h.f(this.f7000a);
    }

    protected int p() {
        return this.f7000a;
    }
}
