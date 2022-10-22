package bq;

import rx.exceptions.a;
/* compiled from: RxJavaErrorHandler.java */
/* loaded from: classes3.dex */
public abstract class b {
    @Deprecated
    public void a(Throwable th2) {
    }

    public final String b(Object obj) {
        try {
            return c(obj);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            return obj.getClass().getName() + ".errorRendering";
        } catch (Throwable th2) {
            a.e(th2);
            return obj.getClass().getName() + ".errorRendering";
        }
    }

    protected String c(Object obj) throws InterruptedException {
        return null;
    }
}
