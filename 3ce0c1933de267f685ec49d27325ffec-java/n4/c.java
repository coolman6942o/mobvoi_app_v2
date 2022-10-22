package n4;

import java.lang.Thread;
/* compiled from: BasicLogHandler.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    protected static c f31013b;

    /* renamed from: a  reason: collision with root package name */
    protected Thread.UncaughtExceptionHandler f31014a;

    public static void b(Throwable th2, String str, String str2) {
        th2.printStackTrace();
        c cVar = f31013b;
        if (cVar != null) {
            cVar.a(th2, 1, str, str2);
        }
    }

    protected void a(Throwable th2, int i10, String str, String str2) {
        throw null;
    }
}
