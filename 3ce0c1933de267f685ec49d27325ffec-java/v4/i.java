package v4;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;
/* compiled from: MemorySizeCalculator.java */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    private final int f35602a;

    /* renamed from: b  reason: collision with root package name */
    private final int f35603b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f35604c;

    /* renamed from: d  reason: collision with root package name */
    private final int f35605d;

    /* compiled from: MemorySizeCalculator.java */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: i  reason: collision with root package name */
        static final int f35606i;

        /* renamed from: a  reason: collision with root package name */
        final Context f35607a;

        /* renamed from: b  reason: collision with root package name */
        ActivityManager f35608b;

        /* renamed from: c  reason: collision with root package name */
        c f35609c;

        /* renamed from: e  reason: collision with root package name */
        float f35611e;

        /* renamed from: d  reason: collision with root package name */
        float f35610d = 2.0f;

        /* renamed from: f  reason: collision with root package name */
        float f35612f = 0.4f;

        /* renamed from: g  reason: collision with root package name */
        float f35613g = 0.33f;

        /* renamed from: h  reason: collision with root package name */
        int f35614h = 4194304;

        static {
            f35606i = Build.VERSION.SDK_INT < 26 ? 4 : 1;
        }

        public a(Context context) {
            this.f35611e = f35606i;
            this.f35607a = context;
            this.f35608b = (ActivityManager) context.getSystemService("activity");
            this.f35609c = new b(context.getResources().getDisplayMetrics());
            if (Build.VERSION.SDK_INT >= 26 && i.e(this.f35608b)) {
                this.f35611e = 0.0f;
            }
        }

        public i a() {
            return new i(this);
        }
    }

    /* compiled from: MemorySizeCalculator.java */
    /* loaded from: classes.dex */
    private static final class b implements c {

        /* renamed from: a  reason: collision with root package name */
        private final DisplayMetrics f35615a;

        b(DisplayMetrics displayMetrics) {
            this.f35615a = displayMetrics;
        }

        @Override // v4.i.c
        public int a() {
            return this.f35615a.heightPixels;
        }

        @Override // v4.i.c
        public int b() {
            return this.f35615a.widthPixels;
        }
    }

    /* compiled from: MemorySizeCalculator.java */
    /* loaded from: classes.dex */
    interface c {
        int a();

        int b();
    }

    i(a aVar) {
        int i10;
        this.f35604c = aVar.f35607a;
        if (e(aVar.f35608b)) {
            i10 = aVar.f35614h / 2;
        } else {
            i10 = aVar.f35614h;
        }
        this.f35605d = i10;
        int c10 = c(aVar.f35608b, aVar.f35612f, aVar.f35613g);
        float b10 = aVar.f35609c.b() * aVar.f35609c.a() * 4;
        int round = Math.round(aVar.f35611e * b10);
        int round2 = Math.round(b10 * aVar.f35610d);
        int i11 = c10 - i10;
        int i12 = round2 + round;
        if (i12 <= i11) {
            this.f35603b = round2;
            this.f35602a = round;
        } else {
            float f10 = i11;
            float f11 = aVar.f35611e;
            float f12 = aVar.f35610d;
            float f13 = f10 / (f11 + f12);
            this.f35603b = Math.round(f12 * f13);
            this.f35602a = Math.round(f13 * aVar.f35611e);
        }
        if (Log.isLoggable("MemorySizeCalculator", 3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Calculation complete, Calculated memory cache size: ");
            sb2.append(f(this.f35603b));
            sb2.append(", pool size: ");
            sb2.append(f(this.f35602a));
            sb2.append(", byte array size: ");
            sb2.append(f(i10));
            sb2.append(", memory class limited? ");
            sb2.append(i12 > c10);
            sb2.append(", max size: ");
            sb2.append(f(c10));
            sb2.append(", memoryClass: ");
            sb2.append(aVar.f35608b.getMemoryClass());
            sb2.append(", isLowMemoryDevice: ");
            sb2.append(e(aVar.f35608b));
            Log.d("MemorySizeCalculator", sb2.toString());
        }
    }

    private static int c(ActivityManager activityManager, float f10, float f11) {
        boolean e10 = e(activityManager);
        float memoryClass = activityManager.getMemoryClass() * 1024 * 1024;
        if (e10) {
            f10 = f11;
        }
        return Math.round(memoryClass * f10);
    }

    @TargetApi(19)
    static boolean e(ActivityManager activityManager) {
        if (Build.VERSION.SDK_INT >= 19) {
            return activityManager.isLowRamDevice();
        }
        return true;
    }

    private String f(int i10) {
        return Formatter.formatFileSize(this.f35604c, i10);
    }

    public int a() {
        return this.f35605d;
    }

    public int b() {
        return this.f35602a;
    }

    public int d() {
        return this.f35603b;
    }
}
