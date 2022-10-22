package com.amap.api.services.a;

import android.content.Context;
import android.os.Looper;
import com.amap.api.services.a.o;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import n4.k;
import n4.m;
import n4.n;
/* compiled from: LogProcessor.java */
/* loaded from: classes.dex */
public abstract class l {

    /* renamed from: c  reason: collision with root package name */
    static final List<Object> f7203c = Collections.synchronizedList(new ArrayList());

    /* renamed from: a  reason: collision with root package name */
    private int f7204a;

    /* renamed from: b  reason: collision with root package name */
    private n f7205b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LogProcessor.java */
    /* loaded from: classes.dex */
    public class a implements n {

        /* renamed from: a  reason: collision with root package name */
        private k f7206a;

        a(k kVar) {
            this.f7206a = kVar;
        }

        @Override // n4.n
        public void a(String str) {
            try {
                this.f7206a.b(str, g.b(l.this.p()));
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public l(int i10) {
        this.f7204a = i10;
    }

    public static String a(Context context, e eVar) {
        return r.b(context, eVar);
    }

    private String b(Context context, String str) {
        try {
            return b.c(context, f.e(str));
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    private void j(k kVar, String str, String str2, int i10, boolean z10) {
        n4.l e10 = g.e(i10);
        e10.b(0);
        e10.f(str);
        e10.c(str2);
        kVar.a(e10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v10, types: [com.amap.api.services.a.o] */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4, types: [com.amap.api.services.a.o] */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6, types: [com.amap.api.services.a.o] */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v9, types: [com.amap.api.services.a.o] */
    /* JADX WARN: Type inference failed for: r9v0, types: [n4.k] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v11, types: [com.amap.api.services.a.o$e] */
    /* JADX WARN: Type inference failed for: r9v12, types: [com.amap.api.services.a.o$e] */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v4, types: [com.amap.api.services.a.o$e] */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v6, types: [com.amap.api.services.a.o$e] */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9 */
    private boolean k(Context context, String str, String str2, String str3, k kVar) {
        IOException e10;
        Throwable th2;
        OutputStream outputStream = null;
        try {
            try {
                try {
                    File file = new File(g.c(context, str2));
                    if (!file.exists() && !file.mkdirs()) {
                        return false;
                    }
                    str2 = o.i(file, 1, 1, 20480L);
                    try {
                        str2.x(e(kVar));
                        kVar = str2.h(str);
                        if (kVar != 0) {
                            try {
                                kVar.close();
                            } catch (Throwable th3) {
                                th3.printStackTrace();
                            }
                            if (!str2.O()) {
                                try {
                                    str2.close();
                                } catch (Throwable th4) {
                                    th4.printStackTrace();
                                }
                            }
                            return false;
                        }
                        try {
                            byte[] e11 = f.e(str3);
                            o.d E = str2.E(str);
                            outputStream = E.b(0);
                            outputStream.write(e11);
                            E.c();
                            str2.V();
                            try {
                                outputStream.close();
                            } catch (Throwable th5) {
                                th5.printStackTrace();
                            }
                            if (kVar != 0) {
                                try {
                                    kVar.close();
                                } catch (Throwable th6) {
                                    th6.printStackTrace();
                                }
                            }
                            if (!str2.O()) {
                                try {
                                    str2.close();
                                } catch (Throwable th7) {
                                    th7.printStackTrace();
                                }
                            }
                            return true;
                        } catch (IOException e12) {
                            e10 = e12;
                            e10.printStackTrace();
                            if (outputStream != null) {
                                try {
                                    outputStream.close();
                                } catch (Throwable th8) {
                                    th8.printStackTrace();
                                }
                            }
                            if (kVar != 0) {
                                try {
                                    kVar.close();
                                } catch (Throwable th9) {
                                    th9.printStackTrace();
                                }
                            }
                            if (str2 != 0 && !str2.O()) {
                                str2.close();
                                str2 = str2;
                                kVar = kVar;
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
                            if (kVar != 0) {
                                try {
                                    kVar.close();
                                } catch (Throwable th12) {
                                    th12.printStackTrace();
                                }
                            }
                            if (str2 != 0 && !str2.O()) {
                                str2.close();
                                str2 = str2;
                                kVar = kVar;
                            }
                            return false;
                        }
                    } catch (IOException e13) {
                        e10 = e13;
                        kVar = 0;
                    } catch (Throwable th13) {
                        th2 = th13;
                        kVar = 0;
                    }
                } catch (Throwable th14) {
                    th14.printStackTrace();
                    return false;
                }
            } catch (IOException e14) {
                e10 = e14;
                str2 = 0;
                kVar = 0;
            } catch (Throwable th15) {
                th2 = th15;
                str2 = 0;
                kVar = 0;
            }
        } catch (Throwable th16) {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Throwable th17) {
                    th17.printStackTrace();
                }
            }
            if (kVar != 0) {
                try {
                    kVar.close();
                } catch (Throwable th18) {
                    th18.printStackTrace();
                }
            }
            if (str2 != 0 && !str2.O()) {
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
        return f.c(th2);
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

    private List<e> r(Context context) {
        List<e> list = null;
        try {
            synchronized (Looper.getMainLooper()) {
                list = new m(context, false).b();
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return list;
    }

    protected String c(String str) {
        return d.a(str);
    }

    protected String d(Throwable th2) {
        try {
            return n(th2);
        } catch (Throwable th3) {
            th3.printStackTrace();
            return null;
        }
    }

    protected n e(k kVar) {
        try {
            if (this.f7205b == null) {
                this.f7205b = new a(kVar);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return this.f7205b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(Context context, Throwable th2, String str, String str2) {
        String d10;
        List<e> r10 = r(context);
        if (r10 != null && r10.size() != 0 && (d10 = d(th2)) != null && !"".equals(d10)) {
            for (e eVar : r10) {
                if (l(eVar.f(), d10)) {
                    i(eVar, context, th2, d10.replaceAll("\n", "<br/>"), str, str2);
                    return;
                }
            }
            if (d10.contains("com.amap.api.col")) {
                try {
                    i(f.a(), context, th2, d10, str, str2);
                } catch (ay e10) {
                    e10.printStackTrace();
                }
            }
        }
    }

    protected void g(e eVar) {
    }

    void h(e eVar, Context context, String str, String str2, String str3, String str4) {
        g(eVar);
        String a10 = r.a();
        String a11 = a(context, eVar);
        String a12 = com.amap.api.services.a.a.a(context);
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
            String c11 = r.c(a12, a11, a10, p10, str, sb2.toString());
            if (c11 != null && !"".equals(c11)) {
                String b10 = b(context, c11);
                String m10 = m();
                synchronized (Looper.getMainLooper()) {
                    k kVar = new k(context);
                    j(kVar, eVar.a(), c10, p10, k(context, c10, m10, b10, kVar));
                }
            }
        }
    }

    void i(e eVar, Context context, Throwable th2, String str, String str2, String str3) {
        h(eVar, context, q(th2), str, str2, str3);
    }

    protected String m() {
        return g.f(this.f7204a);
    }

    protected int p() {
        return this.f7204a;
    }
}
