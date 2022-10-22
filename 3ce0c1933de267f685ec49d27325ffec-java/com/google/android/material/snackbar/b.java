package com.google.android.material.snackbar;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;
/* compiled from: SnackbarManager.java */
/* loaded from: classes.dex */
class b {

    /* renamed from: e  reason: collision with root package name */
    private static b f11324e;

    /* renamed from: a  reason: collision with root package name */
    private final Object f11325a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private final Handler f11326b = new Handler(Looper.getMainLooper(), new a());

    /* renamed from: c  reason: collision with root package name */
    private c f11327c;

    /* renamed from: d  reason: collision with root package name */
    private c f11328d;

    /* compiled from: SnackbarManager.java */
    /* loaded from: classes.dex */
    class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            b.this.d((c) message.obj);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SnackbarManager.java */
    /* renamed from: com.google.android.material.snackbar.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface AbstractC0129b {
        void a();

        void b(int i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SnackbarManager.java */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        final WeakReference<AbstractC0129b> f11330a;

        /* renamed from: b  reason: collision with root package name */
        int f11331b;

        /* renamed from: c  reason: collision with root package name */
        boolean f11332c;

        c(int i10, AbstractC0129b bVar) {
            this.f11330a = new WeakReference<>(bVar);
            this.f11331b = i10;
        }

        boolean a(AbstractC0129b bVar) {
            return bVar != null && this.f11330a.get() == bVar;
        }
    }

    private b() {
    }

    private boolean a(c cVar, int i10) {
        AbstractC0129b bVar = cVar.f11330a.get();
        if (bVar == null) {
            return false;
        }
        this.f11326b.removeCallbacksAndMessages(cVar);
        bVar.b(i10);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b c() {
        if (f11324e == null) {
            f11324e = new b();
        }
        return f11324e;
    }

    private boolean f(AbstractC0129b bVar) {
        c cVar = this.f11327c;
        return cVar != null && cVar.a(bVar);
    }

    private boolean g(AbstractC0129b bVar) {
        c cVar = this.f11328d;
        return cVar != null && cVar.a(bVar);
    }

    private void l(c cVar) {
        int i10 = cVar.f11331b;
        if (i10 != -2) {
            i10 = 2750;
            if (i10 <= 0 && i10 == -1) {
                i10 = 1500;
            }
            this.f11326b.removeCallbacksAndMessages(cVar);
            Handler handler = this.f11326b;
            handler.sendMessageDelayed(Message.obtain(handler, 0, cVar), i10);
        }
    }

    private void n() {
        c cVar = this.f11328d;
        if (cVar != null) {
            this.f11327c = cVar;
            this.f11328d = null;
            AbstractC0129b bVar = cVar.f11330a.get();
            if (bVar != null) {
                bVar.a();
            } else {
                this.f11327c = null;
            }
        }
    }

    public void b(AbstractC0129b bVar, int i10) {
        synchronized (this.f11325a) {
            if (f(bVar)) {
                a(this.f11327c, i10);
            } else if (g(bVar)) {
                a(this.f11328d, i10);
            }
        }
    }

    void d(c cVar) {
        synchronized (this.f11325a) {
            if (this.f11327c == cVar || this.f11328d == cVar) {
                a(cVar, 2);
            }
        }
    }

    public boolean e(AbstractC0129b bVar) {
        boolean z10;
        synchronized (this.f11325a) {
            if (!f(bVar) && !g(bVar)) {
                z10 = false;
            }
            z10 = true;
        }
        return z10;
    }

    public void h(AbstractC0129b bVar) {
        synchronized (this.f11325a) {
            if (f(bVar)) {
                this.f11327c = null;
                if (this.f11328d != null) {
                    n();
                }
            }
        }
    }

    public void i(AbstractC0129b bVar) {
        synchronized (this.f11325a) {
            if (f(bVar)) {
                l(this.f11327c);
            }
        }
    }

    public void j(AbstractC0129b bVar) {
        synchronized (this.f11325a) {
            if (f(bVar)) {
                c cVar = this.f11327c;
                if (!cVar.f11332c) {
                    cVar.f11332c = true;
                    this.f11326b.removeCallbacksAndMessages(cVar);
                }
            }
        }
    }

    public void k(AbstractC0129b bVar) {
        synchronized (this.f11325a) {
            if (f(bVar)) {
                c cVar = this.f11327c;
                if (cVar.f11332c) {
                    cVar.f11332c = false;
                    l(cVar);
                }
            }
        }
    }

    public void m(int i10, AbstractC0129b bVar) {
        synchronized (this.f11325a) {
            if (f(bVar)) {
                c cVar = this.f11327c;
                cVar.f11331b = i10;
                this.f11326b.removeCallbacksAndMessages(cVar);
                l(this.f11327c);
                return;
            }
            if (g(bVar)) {
                this.f11328d.f11331b = i10;
            } else {
                this.f11328d = new c(i10, bVar);
            }
            c cVar2 = this.f11327c;
            if (cVar2 == null || !a(cVar2, 4)) {
                this.f11327c = null;
                n();
            }
        }
    }
}
