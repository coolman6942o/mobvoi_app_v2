package p3;

import a4.d;
import a4.f;
import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class a {

    /* renamed from: p3.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0448a {
        public static synchronized int a(Context context, String str) {
            synchronized (C0448a.class) {
                d.f("RecordPref", "stat remove " + str);
                if (context != null && !TextUtils.isEmpty(str)) {
                    C0449a c10 = c(context);
                    if (c10.f32549a.isEmpty()) {
                        return 0;
                    }
                    ArrayList arrayList = new ArrayList();
                    for (Map.Entry<String, String> entry : c10.f32549a.entrySet()) {
                        if (str.equals(entry.getValue())) {
                            arrayList.add(entry.getKey());
                        }
                    }
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        c10.f32549a.remove((String) it.next());
                    }
                    d(context, c10);
                    return arrayList.size();
                }
                return 0;
            }
        }

        public static synchronized String b(Context context, String str, String str2) {
            synchronized (C0448a.class) {
                d.f("RecordPref", "stat append " + str2 + " , " + str);
                if (context != null && !TextUtils.isEmpty(str)) {
                    if (TextUtils.isEmpty(str2)) {
                        str2 = UUID.randomUUID().toString();
                    }
                    C0449a c10 = c(context);
                    if (c10.f32549a.size() > 20) {
                        c10.f32549a.clear();
                    }
                    c10.f32549a.put(str2, str);
                    d(context, c10);
                    return str2;
                }
                return null;
            }
        }

        public static synchronized C0449a c(Context context) {
            synchronized (C0448a.class) {
                try {
                    String b10 = f.b(null, context, "alipay_cashier_statistic_record", null);
                    if (TextUtils.isEmpty(b10)) {
                        return new C0449a();
                    }
                    return new C0449a(b10);
                } catch (Throwable th2) {
                    d.d(th2);
                    return new C0449a();
                }
            }
        }

        public static synchronized void d(Context context, C0449a aVar) {
            synchronized (C0448a.class) {
                if (aVar == null) {
                    try {
                        aVar = new C0449a();
                    } catch (Throwable th2) {
                        d.d(th2);
                    }
                }
                f.c(null, context, "alipay_cashier_statistic_record", aVar.a());
            }
        }

        public static synchronized String e(Context context) {
            synchronized (C0448a.class) {
                d.f("RecordPref", "stat peek");
                if (context == null) {
                    return null;
                }
                C0449a c10 = c(context);
                if (c10.f32549a.isEmpty()) {
                    return null;
                }
                return c10.f32549a.entrySet().iterator().next().getValue();
            }
        }

        /* renamed from: p3.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0449a {

            /* renamed from: a  reason: collision with root package name */
            public final LinkedHashMap<String, String> f32549a = new LinkedHashMap<>();

            public C0449a() {
            }

            public String a() {
                try {
                    JSONArray jSONArray = new JSONArray();
                    for (Map.Entry<String, String> entry : this.f32549a.entrySet()) {
                        JSONArray jSONArray2 = new JSONArray();
                        jSONArray2.put(entry.getKey()).put(entry.getValue());
                        jSONArray.put(jSONArray2);
                    }
                    return jSONArray.toString();
                } catch (Throwable th2) {
                    d.d(th2);
                    return new JSONArray().toString();
                }
            }

            public C0449a(String str) {
                try {
                    JSONArray jSONArray = new JSONArray(str);
                    for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                        JSONArray jSONArray2 = jSONArray.getJSONArray(i10);
                        this.f32549a.put(jSONArray2.getString(0), jSONArray2.getString(1));
                    }
                } catch (Throwable th2) {
                    d.d(th2);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: p3.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class RunnableC0450a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f32550a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f32551b;

            public RunnableC0450a(String str, Context context) {
                this.f32550a = str;
                this.f32551b = context;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (TextUtils.isEmpty(this.f32550a) || b.d(this.f32551b, this.f32550a)) {
                    for (int i10 = 0; i10 < 4; i10++) {
                        String e10 = C0448a.e(this.f32551b);
                        if (TextUtils.isEmpty(e10) || !b.d(this.f32551b, e10)) {
                            return;
                        }
                    }
                }
            }
        }

        public static synchronized void a(Context context, String str, String str2) {
            synchronized (b.class) {
                if (context != null) {
                    if (!TextUtils.isEmpty(str)) {
                        C0448a.b(context, str, str2);
                    }
                    new Thread(new RunnableC0450a(str, context)).start();
                }
            }
        }

        public static synchronized void b(Context context, p3.b bVar, String str, String str2) {
            synchronized (b.class) {
                if (context != null && bVar != null && str != null) {
                    a(context, bVar.e(str), str2);
                }
            }
        }

        public static synchronized boolean d(Context context, String str) {
            synchronized (b.class) {
                d.f("mspl", "stat sub " + str);
                if ((r3.a.G().o() ? new w3.c() : new w3.d()).h(null, context, str) == null) {
                    return false;
                }
                C0448a.a(context, str);
                return true;
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class c {
        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:14:0x0025
            	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:92)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
            */
        public static synchronized long a(android.content.Context r6) {
            /*
                java.lang.Class<p3.a$c> r0 = p3.a.c.class
                monitor-enter(r0)
                r1 = 0
                java.lang.String r2 = "alipay_cashier_statistic_v"
                java.lang.String r2 = a4.f.b(r1, r6, r2, r1)     // Catch: java.lang.Throwable -> L15
                boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L15
                if (r3 != 0) goto L15
                long r2 = java.lang.Long.parseLong(r2)     // Catch: java.lang.Throwable -> L15
                goto L17
            L15:
                r2 = 0
            L17:
                r4 = 1
                long r2 = r2 + r4
                java.lang.String r4 = "alipay_cashier_statistic_v"
                java.lang.String r5 = java.lang.Long.toString(r2)     // Catch: java.lang.Throwable -> L23
                a4.f.c(r1, r6, r4, r5)     // Catch: java.lang.Throwable -> L23
            L23:
                monitor-exit(r0)
                return r2
            L25:
                r6 = move-exception
                monitor-exit(r0)
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: p3.a.c.a(android.content.Context):long");
        }
    }

    public static synchronized void a(Context context, y3.a aVar, String str, String str2) {
        synchronized (a.class) {
            if (context != null && aVar != null) {
                try {
                    C0448a.b(context, aVar.f36743i.e(str), str2);
                } catch (Throwable th2) {
                    d.d(th2);
                }
            }
        }
    }

    public static void b(y3.a aVar, String str, String str2) {
        if (aVar != null) {
            aVar.f36743i.g(str, str2);
        }
    }

    public static void c(y3.a aVar, String str, String str2, String str3) {
        if (aVar != null) {
            aVar.f36743i.h(str, str2, str3);
        }
    }

    public static void d(y3.a aVar, String str, String str2, Throwable th2) {
        if (aVar != null) {
            aVar.f36743i.i(str, str2, th2);
        }
    }

    public static void e(y3.a aVar, String str, String str2, Throwable th2, String str3) {
        if (aVar != null) {
            aVar.f36743i.j(str, str2, th2, str3);
        }
    }

    public static void f(y3.a aVar, String str, Throwable th2) {
        if (aVar != null && th2 != null) {
            aVar.f36743i.i(str, th2.getClass().getSimpleName(), th2);
        }
    }

    public static synchronized void g(Context context, y3.a aVar, String str, String str2) {
        synchronized (a.class) {
            if (context != null && aVar != null) {
                b.b(context, aVar.f36743i, str, str2);
            }
        }
    }

    public static void h(y3.a aVar, String str, String str2, String str3) {
        if (aVar != null) {
            aVar.f36743i.n(str, str2, str3);
        }
    }
}
