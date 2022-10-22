package h1;
/* compiled from: SneakyThrow.java */
/* loaded from: classes.dex */
public class e {
    public static void a(Exception exc) {
        b(exc);
    }

    private static <E extends Throwable> void b(Throwable th2) throws Throwable {
        throw th2;
    }
}
