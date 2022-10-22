package s6;

import java.io.PrintStream;
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    private static final h f34327a;

    /* loaded from: classes.dex */
    static final class a extends h {
        a() {
        }

        @Override // s6.h
        public final void a(Throwable th2, Throwable th3) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    static {
        h hVar;
        Integer num;
        Throwable th2;
        try {
            num = a();
        } catch (Throwable th3) {
            th2 = th3;
            num = null;
        }
        if (num != null) {
            try {
            } catch (Throwable th4) {
                th2 = th4;
                PrintStream printStream = System.err;
                String name = a.class.getName();
                StringBuilder sb2 = new StringBuilder(name.length() + 132);
                sb2.append("An error has occured when initializing the try-with-resources desuguring strategy. The default strategy ");
                sb2.append(name);
                sb2.append("will be used. The error is: ");
                printStream.println(sb2.toString());
                th2.printStackTrace(System.err);
                hVar = new a();
                f34327a = hVar;
                if (num != null) {
                }
            }
            if (num.intValue() >= 19) {
                hVar = new l();
                f34327a = hVar;
                if (num != null) {
                    num.intValue();
                    return;
                }
                return;
            }
        }
        hVar = Boolean.getBoolean("com.google.devtools.build.android.desugar.runtime.twr_disable_mimic") ^ true ? new k() : new a();
        f34327a = hVar;
        if (num != null) {
        }
    }

    private static Integer a() {
        try {
            return (Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
        } catch (Exception e10) {
            System.err.println("Failed to retrieve value from android.os.Build$VERSION.SDK_INT due to the following exception.");
            e10.printStackTrace(System.err);
            return null;
        }
    }

    public static void b(Throwable th2, Throwable th3) {
        f34327a.a(th2, th3);
    }
}
