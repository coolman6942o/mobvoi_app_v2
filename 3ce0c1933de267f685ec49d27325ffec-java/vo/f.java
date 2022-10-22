package vo;

import kotlin.jvm.internal.i;
import vo.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: _Ranges.kt */
/* loaded from: classes3.dex */
public class f extends e {
    public static float b(float f10, float f11) {
        return f10 < f11 ? f11 : f10;
    }

    public static int c(int i10, int i11) {
        return i10 < i11 ? i11 : i10;
    }

    public static long d(long j10, long j11) {
        return j10 < j11 ? j11 : j10;
    }

    public static float e(float f10, float f11) {
        return f10 > f11 ? f11 : f10;
    }

    public static int f(int i10, int i11) {
        return i10 > i11 ? i11 : i10;
    }

    public static long g(long j10, long j11) {
        return j10 > j11 ? j11 : j10;
    }

    public static int h(int i10, int i11, int i12) {
        if (i11 <= i12) {
            return i10 < i11 ? i11 : i10 > i12 ? i12 : i10;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i12 + " is less than minimum " + i11 + '.');
    }

    public static a i(int i10, int i11) {
        return a.f35841d.a(i10, i11, -1);
    }

    public static a j(a step, int i10) {
        i.f(step, "$this$step");
        e.a(i10 > 0, Integer.valueOf(i10));
        a.C0517a aVar = a.f35841d;
        int a10 = step.a();
        int b10 = step.b();
        if (step.d() <= 0) {
            i10 = -i10;
        }
        return aVar.a(a10, b10, i10);
    }

    public static c k(int i10, int i11) {
        if (i11 <= Integer.MIN_VALUE) {
            return c.f35850f.a();
        }
        return new c(i10, i11 - 1);
    }
}
