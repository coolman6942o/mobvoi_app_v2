package androidx.lifecycle;

import android.os.Handler;
import androidx.lifecycle.Lifecycle;
/* compiled from: ServiceLifecycleDispatcher.java */
/* loaded from: classes.dex */
public class d0 {

    /* renamed from: a  reason: collision with root package name */
    private final q f3303a;

    /* renamed from: b  reason: collision with root package name */
    private final Handler f3304b = new Handler();

    /* renamed from: c  reason: collision with root package name */
    private a f3305c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ServiceLifecycleDispatcher.java */
    /* loaded from: classes.dex */
    public static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final q f3306a;

        /* renamed from: b  reason: collision with root package name */
        final Lifecycle.Event f3307b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f3308c = false;

        a(q qVar, Lifecycle.Event event) {
            this.f3306a = qVar;
            this.f3307b = event;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.f3308c) {
                this.f3306a.h(this.f3307b);
                this.f3308c = true;
            }
        }
    }

    public d0(p pVar) {
        this.f3303a = new q(pVar);
    }

    private void f(Lifecycle.Event event) {
        a aVar = this.f3305c;
        if (aVar != null) {
            aVar.run();
        }
        a aVar2 = new a(this.f3303a, event);
        this.f3305c = aVar2;
        this.f3304b.postAtFrontOfQueue(aVar2);
    }

    public Lifecycle a() {
        return this.f3303a;
    }

    public void b() {
        f(Lifecycle.Event.ON_START);
    }

    public void c() {
        f(Lifecycle.Event.ON_CREATE);
    }

    public void d() {
        f(Lifecycle.Event.ON_STOP);
        f(Lifecycle.Event.ON_DESTROY);
    }

    public void e() {
        f(Lifecycle.Event.ON_START);
    }
}
