package androidx.core.graphics;

import a0.e;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.util.Log;
import com.huawei.agconnect.exception.AGCServerException;
import h0.f;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TypefaceCompatBaseImpl.java */
/* loaded from: classes.dex */
public class g {
    @SuppressLint({"BanConcurrentHashMap"})

    /* renamed from: a  reason: collision with root package name */
    private ConcurrentHashMap<Long, e.b> f2478a = new ConcurrentHashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TypefaceCompatBaseImpl.java */
    /* loaded from: classes.dex */
    public class a implements c<f.b> {
        a(g gVar) {
        }

        /* renamed from: c */
        public int a(f.b bVar) {
            return bVar.e();
        }

        /* renamed from: d */
        public boolean b(f.b bVar) {
            return bVar.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TypefaceCompatBaseImpl.java */
    /* loaded from: classes.dex */
    public class b implements c<e.c> {
        b(g gVar) {
        }

        /* renamed from: c */
        public int a(e.c cVar) {
            return cVar.e();
        }

        /* renamed from: d */
        public boolean b(e.c cVar) {
            return cVar.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TypefaceCompatBaseImpl.java */
    /* loaded from: classes.dex */
    public interface c<T> {
        int a(T t10);

        boolean b(T t10);
    }

    private void a(Typeface typeface, e.b bVar) {
        long j10 = j(typeface);
        if (j10 != 0) {
            this.f2478a.put(Long.valueOf(j10), bVar);
        }
    }

    private e.c f(e.b bVar, int i10) {
        return (e.c) g(bVar.a(), i10, new b(this));
    }

    private static <T> T g(T[] tArr, int i10, c<T> cVar) {
        int i11 = (i10 & 1) == 0 ? AGCServerException.AUTHENTICATION_INVALID : 700;
        boolean z10 = (i10 & 2) != 0;
        T t10 = null;
        int i12 = Integer.MAX_VALUE;
        for (T t11 : tArr) {
            int abs = (Math.abs(cVar.a(t11) - i11) * 2) + (cVar.b(t11) == z10 ? 0 : 1);
            if (t10 == null || i12 > abs) {
                t10 = t11;
                i12 = abs;
            }
        }
        return t10;
    }

    private static long j(Typeface typeface) {
        if (typeface == null) {
            return 0L;
        }
        try {
            Field declaredField = Typeface.class.getDeclaredField("native_instance");
            declaredField.setAccessible(true);
            return ((Number) declaredField.get(typeface)).longValue();
        } catch (IllegalAccessException e10) {
            Log.e("TypefaceCompatBaseImpl", "Could not retrieve font from family.", e10);
            return 0L;
        } catch (NoSuchFieldException e11) {
            Log.e("TypefaceCompatBaseImpl", "Could not retrieve font from family.", e11);
            return 0L;
        }
    }

    public Typeface b(Context context, e.b bVar, Resources resources, int i10) {
        e.c f10 = f(bVar, i10);
        if (f10 == null) {
            return null;
        }
        Typeface d10 = androidx.core.graphics.a.d(context, resources, f10.b(), f10.a(), i10);
        a(d10, bVar);
        return d10;
    }

    public Typeface c(Context context, CancellationSignal cancellationSignal, f.b[] bVarArr, int i10) {
        InputStream inputStream;
        Throwable th2;
        InputStream inputStream2 = null;
        if (bVarArr.length < 1) {
            return null;
        }
        try {
            inputStream = context.getContentResolver().openInputStream(h(bVarArr, i10).d());
        } catch (IOException unused) {
            inputStream = null;
        } catch (Throwable th3) {
            th2 = th3;
        }
        try {
            Typeface d10 = d(context, inputStream);
            b0.e.a(inputStream);
            return d10;
        } catch (IOException unused2) {
            b0.e.a(inputStream);
            return null;
        } catch (Throwable th4) {
            th2 = th4;
            inputStream2 = inputStream;
            b0.e.a(inputStream2);
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Typeface d(Context context, InputStream inputStream) {
        File e10 = b0.e.e(context);
        if (e10 == null) {
            return null;
        }
        try {
            if (!b0.e.d(e10, inputStream)) {
                return null;
            }
            return Typeface.createFromFile(e10.getPath());
        } catch (RuntimeException unused) {
            return null;
        } finally {
            e10.delete();
        }
    }

    public Typeface e(Context context, Resources resources, int i10, String str, int i11) {
        File e10 = b0.e.e(context);
        if (e10 == null) {
            return null;
        }
        try {
            if (!b0.e.c(e10, resources, i10)) {
                return null;
            }
            return Typeface.createFromFile(e10.getPath());
        } catch (RuntimeException unused) {
            return null;
        } finally {
            e10.delete();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public f.b h(f.b[] bVarArr, int i10) {
        return (f.b) g(bVarArr, i10, new a(this));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e.b i(Typeface typeface) {
        long j10 = j(typeface);
        if (j10 == 0) {
            return null;
        }
        return this.f2478a.get(Long.valueOf(j10));
    }
}
