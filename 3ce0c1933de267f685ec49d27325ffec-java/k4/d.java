package k4;

import java.lang.Thread;
/* compiled from: BasicLogHandler.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    protected static d f29746b;

    /* renamed from: a  reason: collision with root package name */
    protected Thread.UncaughtExceptionHandler f29747a;

    public static void b(Throwable th2, String str, String str2) {
        th2.printStackTrace();
        d dVar = f29746b;
        if (dVar != null) {
            dVar.a(th2, 1, str, str2);
        }
    }

    protected void a(Throwable th2, int i10, String str, String str2) {
        throw null;
    }
}
