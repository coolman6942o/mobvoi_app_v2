package com.airbnb.lottie;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.airbnb.lottie.parser.moshi.JsonReader;
import j3.t;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import k3.h;
import okio.n;
/* compiled from: LottieCompositionFactory.java */
/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<String, m<com.airbnb.lottie.d>> f6438a = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LottieCompositionFactory.java */
    /* loaded from: classes.dex */
    public class a implements h<com.airbnb.lottie.d> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f6439a;

        a(String str) {
            this.f6439a = str;
        }

        /* renamed from: b */
        public void a(com.airbnb.lottie.d dVar) {
            e.f6438a.remove(this.f6439a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LottieCompositionFactory.java */
    /* loaded from: classes.dex */
    public class b implements h<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f6440a;

        b(String str) {
            this.f6440a = str;
        }

        /* renamed from: b */
        public void a(Throwable th2) {
            e.f6438a.remove(this.f6440a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LottieCompositionFactory.java */
    /* loaded from: classes.dex */
    public class c implements Callable<l<com.airbnb.lottie.d>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f6441a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f6442b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f6443c;

        c(Context context, String str, String str2) {
            this.f6441a = context;
            this.f6442b = str;
            this.f6443c = str2;
        }

        /* renamed from: a */
        public l<com.airbnb.lottie.d> call() {
            return com.airbnb.lottie.network.b.e(this.f6441a, this.f6442b, this.f6443c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LottieCompositionFactory.java */
    /* loaded from: classes.dex */
    public class d implements Callable<l<com.airbnb.lottie.d>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f6444a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f6445b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f6446c;

        d(Context context, String str, String str2) {
            this.f6444a = context;
            this.f6445b = str;
            this.f6446c = str2;
        }

        /* renamed from: a */
        public l<com.airbnb.lottie.d> call() {
            return e.f(this.f6444a, this.f6445b, this.f6446c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LottieCompositionFactory.java */
    /* renamed from: com.airbnb.lottie.e$e  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class CallableC0087e implements Callable<l<com.airbnb.lottie.d>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ WeakReference f6447a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f6448b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f6449c;

        CallableC0087e(WeakReference weakReference, Context context, int i10) {
            this.f6447a = weakReference;
            this.f6448b = context;
            this.f6449c = i10;
        }

        /* renamed from: a */
        public l<com.airbnb.lottie.d> call() {
            Context context = (Context) this.f6447a.get();
            if (context == null) {
                context = this.f6448b;
            }
            return e.n(context, this.f6449c);
        }
    }

    /* compiled from: LottieCompositionFactory.java */
    /* loaded from: classes.dex */
    class f implements Callable<l<com.airbnb.lottie.d>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ InputStream f6450a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f6451b;

        f(InputStream inputStream, String str) {
            this.f6450a = inputStream;
            this.f6451b = str;
        }

        /* renamed from: a */
        public l<com.airbnb.lottie.d> call() {
            return e.h(this.f6450a, this.f6451b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LottieCompositionFactory.java */
    /* loaded from: classes.dex */
    public class g implements Callable<l<com.airbnb.lottie.d>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.airbnb.lottie.d f6452a;

        g(com.airbnb.lottie.d dVar) {
            this.f6452a = dVar;
        }

        /* renamed from: a */
        public l<com.airbnb.lottie.d> call() {
            return new l<>(this.f6452a);
        }
    }

    private static m<com.airbnb.lottie.d> b(String str, Callable<l<com.airbnb.lottie.d>> callable) {
        com.airbnb.lottie.d a10 = str == null ? null : g3.f.b().a(str);
        if (a10 != null) {
            return new m<>(new g(a10));
        }
        if (str != null) {
            Map<String, m<com.airbnb.lottie.d>> map = f6438a;
            if (map.containsKey(str)) {
                return map.get(str);
            }
        }
        m<com.airbnb.lottie.d> mVar = new m<>(callable);
        if (str != null) {
            mVar.f(new a(str));
            mVar.e(new b(str));
            f6438a.put(str, mVar);
        }
        return mVar;
    }

    private static com.airbnb.lottie.g c(com.airbnb.lottie.d dVar, String str) {
        for (com.airbnb.lottie.g gVar : dVar.i().values()) {
            if (gVar.b().equals(str)) {
                return gVar;
            }
        }
        return null;
    }

    public static m<com.airbnb.lottie.d> d(Context context, String str) {
        return e(context, str, "asset_" + str);
    }

    public static m<com.airbnb.lottie.d> e(Context context, String str, String str2) {
        return b(str2, new d(context.getApplicationContext(), str, str2));
    }

    public static l<com.airbnb.lottie.d> f(Context context, String str, String str2) {
        try {
            if (str.endsWith(".zip")) {
                return r(new ZipInputStream(context.getAssets().open(str)), str2);
            }
            return h(context.getAssets().open(str), str2);
        } catch (IOException e10) {
            return new l<>(e10);
        }
    }

    public static m<com.airbnb.lottie.d> g(InputStream inputStream, String str) {
        return b(str, new f(inputStream, str));
    }

    public static l<com.airbnb.lottie.d> h(InputStream inputStream, String str) {
        return i(inputStream, str, true);
    }

    private static l<com.airbnb.lottie.d> i(InputStream inputStream, String str, boolean z10) {
        try {
            return j(JsonReader.E(n.d(n.l(inputStream))), str);
        } finally {
            if (z10) {
                h.c(inputStream);
            }
        }
    }

    public static l<com.airbnb.lottie.d> j(JsonReader jsonReader, String str) {
        return k(jsonReader, str, true);
    }

    private static l<com.airbnb.lottie.d> k(JsonReader jsonReader, String str, boolean z10) {
        try {
            try {
                com.airbnb.lottie.d a10 = t.a(jsonReader);
                if (str != null) {
                    g3.f.b().c(str, a10);
                }
                l<com.airbnb.lottie.d> lVar = new l<>(a10);
                if (z10) {
                    h.c(jsonReader);
                }
                return lVar;
            } catch (Exception e10) {
                l<com.airbnb.lottie.d> lVar2 = new l<>(e10);
                if (z10) {
                    h.c(jsonReader);
                }
                return lVar2;
            }
        } catch (Throwable th2) {
            if (z10) {
                h.c(jsonReader);
            }
            throw th2;
        }
    }

    public static m<com.airbnb.lottie.d> l(Context context, int i10) {
        return m(context, i10, u(context, i10));
    }

    public static m<com.airbnb.lottie.d> m(Context context, int i10, String str) {
        return b(str, new CallableC0087e(new WeakReference(context), context.getApplicationContext(), i10));
    }

    public static l<com.airbnb.lottie.d> n(Context context, int i10) {
        return o(context, i10, u(context, i10));
    }

    public static l<com.airbnb.lottie.d> o(Context context, int i10, String str) {
        try {
            return h(context.getResources().openRawResource(i10), str);
        } catch (Resources.NotFoundException e10) {
            return new l<>(e10);
        }
    }

    public static m<com.airbnb.lottie.d> p(Context context, String str) {
        return q(context, str, "url_" + str);
    }

    public static m<com.airbnb.lottie.d> q(Context context, String str, String str2) {
        return b(str2, new c(context, str, str2));
    }

    public static l<com.airbnb.lottie.d> r(ZipInputStream zipInputStream, String str) {
        try {
            return s(zipInputStream, str);
        } finally {
            h.c(zipInputStream);
        }
    }

    private static l<com.airbnb.lottie.d> s(ZipInputStream zipInputStream, String str) {
        String[] split;
        HashMap hashMap = new HashMap();
        try {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            com.airbnb.lottie.d dVar = null;
            while (nextEntry != null) {
                String name = nextEntry.getName();
                if (name.contains("__MACOSX")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().contains(".json")) {
                    dVar = k(JsonReader.E(n.d(n.l(zipInputStream))), null, false).b();
                } else {
                    if (!name.contains(".png") && !name.contains(".webp")) {
                        zipInputStream.closeEntry();
                    }
                    hashMap.put(name.split("/")[split.length - 1], BitmapFactory.decodeStream(zipInputStream));
                }
                nextEntry = zipInputStream.getNextEntry();
            }
            if (dVar == null) {
                return new l<>(new IllegalArgumentException("Unable to parse composition"));
            }
            for (Map.Entry entry : hashMap.entrySet()) {
                com.airbnb.lottie.g c10 = c(dVar, (String) entry.getKey());
                if (c10 != null) {
                    c10.f(h.l((Bitmap) entry.getValue(), c10.e(), c10.c()));
                }
            }
            for (Map.Entry<String, com.airbnb.lottie.g> entry2 : dVar.i().entrySet()) {
                if (entry2.getValue().a() == null) {
                    return new l<>(new IllegalStateException("There is no image for " + entry2.getValue().b()));
                }
            }
            if (str != null) {
                g3.f.b().c(str, dVar);
            }
            return new l<>(dVar);
        } catch (IOException e10) {
            return new l<>(e10);
        }
    }

    private static boolean t(Context context) {
        return (context.getResources().getConfiguration().uiMode & 48) == 32;
    }

    private static String u(Context context, int i10) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("rawRes");
        sb2.append(t(context) ? "_night_" : "_day_");
        sb2.append(i10);
        return sb2.toString();
    }
}
