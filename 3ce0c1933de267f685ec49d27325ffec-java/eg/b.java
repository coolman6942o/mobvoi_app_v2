package eg;
/* compiled from: CalculateUtils.java */
/* loaded from: classes2.dex */
public class b {
    public static int a(int i10, int i11) {
        return i10 <= 0 ? i11 : i10;
    }

    public static int b(int i10, int i11) {
        if (i11 <= 0) {
            return 0;
        }
        return Math.round((i10 * 100.0f) / i11);
    }

    public static int c(float f10) {
        return Math.round(f10 * 100.0f);
    }
}
