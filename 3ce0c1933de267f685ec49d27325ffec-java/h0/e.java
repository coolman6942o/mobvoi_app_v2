package h0;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import androidx.collection.f;
import h0.f;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FontRequestWorker.java */
/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    static final q.a<String, Typeface> f27651a = new q.a<>(16);

    /* renamed from: b  reason: collision with root package name */
    private static final ExecutorService f27652b = g.a("fonts-androidx", 10, 10000);

    /* renamed from: c  reason: collision with root package name */
    static final Object f27653c = new Object();

    /* renamed from: d  reason: collision with root package name */
    static final f<String, ArrayList<j0.a<C0296e>>> f27654d = new f<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FontRequestWorker.java */
    /* loaded from: classes.dex */
    public class a implements Callable<C0296e> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f27655a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f27656b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ h0.d f27657c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f27658d;

        a(String str, Context context, h0.d dVar, int i10) {
            this.f27655a = str;
            this.f27656b = context;
            this.f27657c = dVar;
            this.f27658d = i10;
        }

        /* renamed from: a */
        public C0296e call() {
            return e.c(this.f27655a, this.f27656b, this.f27657c, this.f27658d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FontRequestWorker.java */
    /* loaded from: classes.dex */
    public class b implements j0.a<C0296e> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h0.a f27659a;

        b(h0.a aVar) {
            this.f27659a = aVar;
        }

        /* renamed from: a */
        public void accept(C0296e eVar) {
            if (eVar == null) {
                eVar = new C0296e(-3);
            }
            this.f27659a.b(eVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FontRequestWorker.java */
    /* loaded from: classes.dex */
    public class c implements Callable<C0296e> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f27660a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f27661b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ h0.d f27662c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f27663d;

        c(String str, Context context, h0.d dVar, int i10) {
            this.f27660a = str;
            this.f27661b = context;
            this.f27662c = dVar;
            this.f27663d = i10;
        }

        /* renamed from: a */
        public C0296e call() {
            try {
                return e.c(this.f27660a, this.f27661b, this.f27662c, this.f27663d);
            } catch (Throwable unused) {
                return new C0296e(-3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FontRequestWorker.java */
    /* loaded from: classes.dex */
    public class d implements j0.a<C0296e> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f27664a;

        d(String str) {
            this.f27664a = str;
        }

        /* renamed from: a */
        public void accept(C0296e eVar) {
            synchronized (e.f27653c) {
                f<String, ArrayList<j0.a<C0296e>>> fVar = e.f27654d;
                ArrayList<j0.a<C0296e>> arrayList = fVar.get(this.f27664a);
                if (arrayList != null) {
                    fVar.remove(this.f27664a);
                    for (int i10 = 0; i10 < arrayList.size(); i10++) {
                        arrayList.get(i10).accept(eVar);
                    }
                }
            }
        }
    }

    private static String a(h0.d dVar, int i10) {
        return dVar.d() + "-" + i10;
    }

    @SuppressLint({"WrongConstant"})
    private static int b(f.a aVar) {
        int i10 = 1;
        if (aVar.c() != 0) {
            return aVar.c() != 1 ? -3 : -2;
        }
        f.b[] b10 = aVar.b();
        if (!(b10 == null || b10.length == 0)) {
            i10 = 0;
            for (f.b bVar : b10) {
                int b11 = bVar.b();
                if (b11 != 0) {
                    if (b11 < 0) {
                        return -3;
                    } else {
                        return b11;
                    }
                }
            }
        }
        return i10;
    }

    static C0296e c(String str, Context context, h0.d dVar, int i10) {
        q.a<String, Typeface> aVar = f27651a;
        Typeface c10 = aVar.c(str);
        if (c10 != null) {
            return new C0296e(c10);
        }
        try {
            f.a d10 = h0.c.d(context, dVar, null);
            int b10 = b(d10);
            if (b10 != 0) {
                return new C0296e(b10);
            }
            Typeface b11 = androidx.core.graphics.a.b(context, null, d10.b(), i10);
            if (b11 == null) {
                return new C0296e(-3);
            }
            aVar.d(str, b11);
            return new C0296e(b11);
        } catch (PackageManager.NameNotFoundException unused) {
            return new C0296e(-1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Typeface d(Context context, h0.d dVar, int i10, Executor executor, h0.a aVar) {
        String a10 = a(dVar, i10);
        Typeface c10 = f27651a.c(a10);
        if (c10 != null) {
            aVar.b(new C0296e(c10));
            return c10;
        }
        b bVar = new b(aVar);
        synchronized (f27653c) {
            androidx.collection.f<String, ArrayList<j0.a<C0296e>>> fVar = f27654d;
            ArrayList<j0.a<C0296e>> arrayList = fVar.get(a10);
            if (arrayList != null) {
                arrayList.add(bVar);
                return null;
            }
            ArrayList<j0.a<C0296e>> arrayList2 = new ArrayList<>();
            arrayList2.add(bVar);
            fVar.put(a10, arrayList2);
            c cVar = new c(a10, context, dVar, i10);
            if (executor == null) {
                executor = f27652b;
            }
            g.b(executor, cVar, new d(a10));
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Typeface e(Context context, h0.d dVar, h0.a aVar, int i10, int i11) {
        String a10 = a(dVar, i10);
        Typeface c10 = f27651a.c(a10);
        if (c10 != null) {
            aVar.b(new C0296e(c10));
            return c10;
        } else if (i11 == -1) {
            C0296e c11 = c(a10, context, dVar, i10);
            aVar.b(c11);
            return c11.f27665a;
        } else {
            try {
                C0296e eVar = (C0296e) g.c(f27652b, new a(a10, context, dVar, i10), i11);
                aVar.b(eVar);
                return eVar.f27665a;
            } catch (InterruptedException unused) {
                aVar.b(new C0296e(-3));
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FontRequestWorker.java */
    /* renamed from: h0.e$e  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0296e {

        /* renamed from: a  reason: collision with root package name */
        final Typeface f27665a;

        /* renamed from: b  reason: collision with root package name */
        final int f27666b;

        C0296e(int i10) {
            this.f27665a = null;
            this.f27666b = i10;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @SuppressLint({"WrongConstant"})
        public boolean a() {
            return this.f27666b == 0;
        }

        @SuppressLint({"WrongConstant"})
        C0296e(Typeface typeface) {
            this.f27665a = typeface;
            this.f27666b = 0;
        }
    }
}
