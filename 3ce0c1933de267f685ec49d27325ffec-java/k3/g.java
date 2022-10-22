package k3;

import android.graphics.Path;
import android.graphics.PointF;
import d3.k;
import g3.a;
import g3.d;
import java.util.List;
/* compiled from: MiscUtils.java */
/* loaded from: classes.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private static PointF f29736a = new PointF();

    public static PointF a(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    public static float b(float f10, float f11, float f12) {
        return Math.max(f11, Math.min(f12, f10));
    }

    public static int c(int i10, int i11, int i12) {
        return Math.max(i11, Math.min(i12, i10));
    }

    public static boolean d(float f10, float f11, float f12) {
        return f10 >= f11 && f10 <= f12;
    }

    private static int e(int i10, int i11) {
        int i12 = i10 / i11;
        return (((i10 ^ i11) >= 0) || i10 % i11 == 0) ? i12 : i12 - 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int f(float f10, float f11) {
        return g((int) f10, (int) f11);
    }

    private static int g(int i10, int i11) {
        return i10 - (i11 * e(i10, i11));
    }

    public static void h(i3.g gVar, Path path) {
        path.reset();
        PointF b10 = gVar.b();
        path.moveTo(b10.x, b10.y);
        f29736a.set(b10.x, b10.y);
        for (int i10 = 0; i10 < gVar.a().size(); i10++) {
            a aVar = gVar.a().get(i10);
            PointF a10 = aVar.a();
            PointF b11 = aVar.b();
            PointF c10 = aVar.c();
            if (!a10.equals(f29736a) || !b11.equals(c10)) {
                path.cubicTo(a10.x, a10.y, b11.x, b11.y, c10.x, c10.y);
            } else {
                path.lineTo(c10.x, c10.y);
            }
            f29736a.set(c10.x, c10.y);
        }
        if (gVar.d()) {
            path.close();
        }
    }

    public static double i(double d10, double d11, double d12) {
        return d10 + (d12 * (d11 - d10));
    }

    public static float j(float f10, float f11, float f12) {
        return f10 + (f12 * (f11 - f10));
    }

    public static int k(int i10, int i11, float f10) {
        return (int) (i10 + (f10 * (i11 - i10)));
    }

    public static void l(d dVar, int i10, List<d> list, d dVar2, k kVar) {
        if (dVar.c(kVar.getName(), i10)) {
            list.add(dVar2.a(kVar.getName()).i(kVar));
        }
    }
}
