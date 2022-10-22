package j3;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.collection.g;
import com.airbnb.lottie.d;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.huawei.hms.scankit.C0559e;
import java.io.IOException;
import java.lang.ref.WeakReference;
import k3.h;
import l0.b;
import l3.a;
/* compiled from: KeyframeParser.java */
/* loaded from: classes.dex */
class q {

    /* renamed from: b  reason: collision with root package name */
    private static g<WeakReference<Interpolator>> f29425b;

    /* renamed from: a  reason: collision with root package name */
    private static final Interpolator f29424a = new LinearInterpolator();

    /* renamed from: c  reason: collision with root package name */
    static JsonReader.a f29426c = JsonReader.a.a("t", "s", C0559e.f14347a, "o", "i", "h", "to", "ti");

    q() {
    }

    private static WeakReference<Interpolator> a(int i10) {
        WeakReference<Interpolator> e10;
        synchronized (q.class) {
            e10 = e().e(i10);
        }
        return e10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> a<T> b(JsonReader jsonReader, d dVar, float f10, j0<T> j0Var, boolean z10) throws IOException {
        if (z10) {
            return c(dVar, jsonReader, f10, j0Var);
        }
        return d(jsonReader, f10, j0Var);
    }

    private static <T> a<T> c(d dVar, JsonReader jsonReader, float f10, j0<T> j0Var) throws IOException {
        Interpolator interpolator;
        T t10;
        Interpolator interpolator2;
        jsonReader.h();
        Interpolator interpolator3 = null;
        boolean z10 = false;
        float f11 = 0.0f;
        PointF pointF = null;
        PointF pointF2 = null;
        T t11 = null;
        T t12 = null;
        PointF pointF3 = null;
        PointF pointF4 = null;
        while (jsonReader.o()) {
            switch (jsonReader.Q(f29426c)) {
                case 0:
                    f11 = (float) jsonReader.u();
                    break;
                case 1:
                    t12 = j0Var.a(jsonReader, f10);
                    break;
                case 2:
                    t11 = j0Var.a(jsonReader, f10);
                    break;
                case 3:
                    pointF = p.e(jsonReader, f10);
                    break;
                case 4:
                    pointF2 = p.e(jsonReader, f10);
                    break;
                case 5:
                    if (jsonReader.v() != 1) {
                        z10 = false;
                        break;
                    } else {
                        z10 = true;
                        break;
                    }
                case 6:
                    pointF4 = p.e(jsonReader, f10);
                    break;
                case 7:
                    pointF3 = p.e(jsonReader, f10);
                    break;
                default:
                    jsonReader.V();
                    break;
            }
        }
        jsonReader.n();
        if (z10) {
            interpolator = f29424a;
            t10 = t12;
        } else {
            if (pointF == null || pointF2 == null) {
                interpolator = f29424a;
            } else {
                float f12 = -f10;
                pointF.x = k3.g.b(pointF.x, f12, f10);
                pointF.y = k3.g.b(pointF.y, -100.0f, 100.0f);
                pointF2.x = k3.g.b(pointF2.x, f12, f10);
                float b10 = k3.g.b(pointF2.y, -100.0f, 100.0f);
                pointF2.y = b10;
                int i10 = h.i(pointF.x, pointF.y, pointF2.x, b10);
                WeakReference<Interpolator> a10 = a(i10);
                if (a10 != null) {
                    interpolator3 = a10.get();
                }
                if (a10 == null || interpolator3 == null) {
                    pointF.x /= f10;
                    pointF.y /= f10;
                    float f13 = pointF2.x / f10;
                    pointF2.x = f13;
                    float f14 = pointF2.y / f10;
                    pointF2.y = f14;
                    try {
                        interpolator2 = b.a(pointF.x, pointF.y, f13, f14);
                    } catch (IllegalArgumentException e10) {
                        if (e10.getMessage().equals("The Path cannot loop back on itself.")) {
                            interpolator2 = b.a(Math.min(pointF.x, 1.0f), pointF.y, Math.max(pointF2.x, 0.0f), pointF2.y);
                        } else {
                            interpolator2 = new LinearInterpolator();
                        }
                    }
                    interpolator3 = interpolator2;
                    try {
                        f(i10, new WeakReference(interpolator3));
                    } catch (ArrayIndexOutOfBoundsException unused) {
                    }
                }
                interpolator = interpolator3;
            }
            t10 = t11;
        }
        a<T> aVar = new a<>(dVar, t12, t10, interpolator, f11, null);
        aVar.f30415m = pointF4;
        aVar.f30416n = pointF3;
        return aVar;
    }

    private static <T> a<T> d(JsonReader jsonReader, float f10, j0<T> j0Var) throws IOException {
        return new a<>(j0Var.a(jsonReader, f10));
    }

    private static g<WeakReference<Interpolator>> e() {
        if (f29425b == null) {
            f29425b = new g<>();
        }
        return f29425b;
    }

    private static void f(int i10, WeakReference<Interpolator> weakReference) {
        synchronized (q.class) {
            f29425b.j(i10, weakReference);
        }
    }
}
