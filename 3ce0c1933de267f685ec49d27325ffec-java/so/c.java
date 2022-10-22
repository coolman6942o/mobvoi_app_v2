package so;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MathJVM.kt */
/* loaded from: classes3.dex */
public class c extends b {
    public static int a(double d10) {
        if (Double.isNaN(d10)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        } else if (d10 > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else {
            if (d10 < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            return (int) Math.round(d10);
        }
    }

    public static int b(float f10) {
        if (!Float.isNaN(f10)) {
            return Math.round(f10);
        }
        throw new IllegalArgumentException("Cannot round NaN value.");
    }
}
