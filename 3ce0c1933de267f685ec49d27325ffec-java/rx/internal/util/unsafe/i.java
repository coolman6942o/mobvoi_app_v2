package rx.internal.util.unsafe;
/* compiled from: Pow2.java */
/* loaded from: classes3.dex */
public final class i {
    public static boolean a(int i10) {
        return (i10 & (i10 + (-1))) == 0;
    }

    public static int b(int i10) {
        return 1 << (32 - Integer.numberOfLeadingZeros(i10 - 1));
    }
}
