package rx.internal.util;
/* compiled from: PlatformDependent.java */
/* loaded from: classes3.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private static final int f34128a;

    /* renamed from: b  reason: collision with root package name */
    private static final boolean f34129b;

    static {
        int c10 = c();
        f34128a = c10;
        f34129b = c10 != 0;
    }

    public static int a() {
        return f34128a;
    }

    public static boolean b() {
        return f34129b;
    }

    private static int c() {
        try {
            return ((Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null)).intValue();
        } catch (Exception unused) {
            return 0;
        }
    }
}
