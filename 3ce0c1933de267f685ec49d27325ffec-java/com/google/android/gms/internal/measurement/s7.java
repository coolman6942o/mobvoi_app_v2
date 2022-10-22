package com.google.android.gms.internal.measurement;
/* loaded from: classes.dex */
final class s7 {

    /* renamed from: a  reason: collision with root package name */
    private static final Class<?> f9668a = a("libcore.io.Memory");

    /* renamed from: b  reason: collision with root package name */
    private static final boolean f9669b;

    static {
        f9669b = a("org.robolectric.Robolectric") != null;
    }

    private static <T> Class<T> a(String str) {
        try {
            return (Class<T>) Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b() {
        return f9668a != null && !f9669b;
    }
}
