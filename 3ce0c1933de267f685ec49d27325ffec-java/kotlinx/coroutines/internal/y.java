package kotlinx.coroutines.internal;
/* compiled from: SystemProps.kt */
/* loaded from: classes3.dex */
final /* synthetic */ class y {

    /* renamed from: a  reason: collision with root package name */
    private static final int f30245a = Runtime.getRuntime().availableProcessors();

    public static final int a() {
        return f30245a;
    }

    public static final String b(String str) {
        try {
            return System.getProperty(str);
        } catch (SecurityException unused) {
            return null;
        }
    }
}
