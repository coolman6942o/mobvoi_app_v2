package w1;

import a2.a;
import android.content.Context;
/* compiled from: Trackers.java */
/* loaded from: classes.dex */
public class g {

    /* renamed from: e  reason: collision with root package name */
    private static g f35942e;

    /* renamed from: a  reason: collision with root package name */
    private a f35943a;

    /* renamed from: b  reason: collision with root package name */
    private b f35944b;

    /* renamed from: c  reason: collision with root package name */
    private e f35945c;

    /* renamed from: d  reason: collision with root package name */
    private f f35946d;

    private g(Context context, a aVar) {
        Context applicationContext = context.getApplicationContext();
        this.f35943a = new a(applicationContext, aVar);
        this.f35944b = new b(applicationContext, aVar);
        this.f35945c = new e(applicationContext, aVar);
        this.f35946d = new f(applicationContext, aVar);
    }

    public static synchronized g c(Context context, a aVar) {
        g gVar;
        synchronized (g.class) {
            if (f35942e == null) {
                f35942e = new g(context, aVar);
            }
            gVar = f35942e;
        }
        return gVar;
    }

    public a a() {
        return this.f35943a;
    }

    public b b() {
        return this.f35944b;
    }

    public e d() {
        return this.f35945c;
    }

    public f e() {
        return this.f35946d;
    }
}
