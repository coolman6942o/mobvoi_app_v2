package com.bumptech.glide;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import g5.c;
import g5.i;
import g5.m;
import g5.n;
import g5.p;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import k5.d;
import n5.k;
/* compiled from: RequestManager.java */
/* loaded from: classes.dex */
public class h implements ComponentCallbacks2, i {

    /* renamed from: m  reason: collision with root package name */
    private static final j5.c f7846m = j5.c.k0(Bitmap.class).N();

    /* renamed from: a  reason: collision with root package name */
    protected final com.bumptech.glide.c f7847a;

    /* renamed from: b  reason: collision with root package name */
    protected final Context f7848b;

    /* renamed from: c  reason: collision with root package name */
    final g5.h f7849c;

    /* renamed from: d  reason: collision with root package name */
    private final n f7850d;

    /* renamed from: e  reason: collision with root package name */
    private final m f7851e;

    /* renamed from: f  reason: collision with root package name */
    private final p f7852f;

    /* renamed from: g  reason: collision with root package name */
    private final Runnable f7853g;

    /* renamed from: h  reason: collision with root package name */
    private final Handler f7854h;

    /* renamed from: i  reason: collision with root package name */
    private final g5.c f7855i;

    /* renamed from: j  reason: collision with root package name */
    private final CopyOnWriteArrayList<j5.b<Object>> f7856j;

    /* renamed from: k  reason: collision with root package name */
    private j5.c f7857k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f7858l;

    /* compiled from: RequestManager.java */
    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            h hVar = h.this;
            hVar.f7849c.a(hVar);
        }
    }

    /* compiled from: RequestManager.java */
    /* loaded from: classes.dex */
    private static class b extends d<View, Object> {
        b(View view) {
            super(view);
        }

        @Override // k5.i
        public void a(Object obj, l5.b<? super Object> bVar) {
        }

        @Override // k5.i
        public void c(Drawable drawable) {
        }

        @Override // k5.d
        protected void l(Drawable drawable) {
        }
    }

    /* compiled from: RequestManager.java */
    /* loaded from: classes.dex */
    private class c implements c.a {

        /* renamed from: a  reason: collision with root package name */
        private final n f7860a;

        c(n nVar) {
            this.f7860a = nVar;
        }

        @Override // g5.c.a
        public void a(boolean z10) {
            if (z10) {
                synchronized (h.this) {
                    this.f7860a.e();
                }
            }
        }
    }

    static {
        j5.c.k0(e5.c.class).N();
        j5.c.l0(t4.a.f35050b).V(Priority.LOW).c0(true);
    }

    public h(com.bumptech.glide.c cVar, g5.h hVar, m mVar, Context context) {
        this(cVar, hVar, mVar, new n(), cVar.g(), context);
    }

    private void A(k5.i<?> iVar) {
        boolean z10 = z(iVar);
        j5.a f10 = iVar.f();
        if (!z10 && !this.f7847a.p(iVar) && f10 != null) {
            iVar.d(null);
            f10.clear();
        }
    }

    public <ResourceType> g<ResourceType> i(Class<ResourceType> cls) {
        return new g<>(this.f7847a, this, cls, this.f7848b);
    }

    public g<Bitmap> j() {
        return i(Bitmap.class).a(f7846m);
    }

    public g<Drawable> k() {
        return i(Drawable.class);
    }

    public void l(View view) {
        m(new b(view));
    }

    public void m(k5.i<?> iVar) {
        if (iVar != null) {
            A(iVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<j5.b<Object>> n() {
        return this.f7856j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized j5.c o() {
        return this.f7857k;
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // g5.i
    public synchronized void onDestroy() {
        this.f7852f.onDestroy();
        for (k5.i<?> iVar : this.f7852f.j()) {
            m(iVar);
        }
        this.f7852f.i();
        this.f7850d.b();
        this.f7849c.b(this);
        this.f7849c.b(this.f7855i);
        this.f7854h.removeCallbacks(this.f7853g);
        this.f7847a.s(this);
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
    }

    @Override // g5.i
    public synchronized void onStart() {
        v();
        this.f7852f.onStart();
    }

    @Override // g5.i
    public synchronized void onStop() {
        u();
        this.f7852f.onStop();
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i10) {
        if (i10 == 60 && this.f7858l) {
            t();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <T> i<?, T> p(Class<T> cls) {
        return this.f7847a.i().e(cls);
    }

    public g<Drawable> q(Uri uri) {
        return k().x0(uri);
    }

    public g<Drawable> r(String str) {
        return k().z0(str);
    }

    public synchronized void s() {
        this.f7850d.c();
    }

    public synchronized void t() {
        s();
        for (h hVar : this.f7851e.a()) {
            hVar.s();
        }
    }

    public synchronized String toString() {
        return super.toString() + "{tracker=" + this.f7850d + ", treeNode=" + this.f7851e + "}";
    }

    public synchronized void u() {
        this.f7850d.d();
    }

    public synchronized void v() {
        this.f7850d.f();
    }

    public synchronized h w(j5.c cVar) {
        x(cVar);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void x(j5.c cVar) {
        this.f7857k = cVar.clone().b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void y(k5.i<?> iVar, j5.a aVar) {
        this.f7852f.k(iVar);
        this.f7850d.g(aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean z(k5.i<?> iVar) {
        j5.a f10 = iVar.f();
        if (f10 == null) {
            return true;
        }
        if (!this.f7850d.a(f10)) {
            return false;
        }
        this.f7852f.l(iVar);
        iVar.d(null);
        return true;
    }

    h(com.bumptech.glide.c cVar, g5.h hVar, m mVar, n nVar, g5.d dVar, Context context) {
        this.f7852f = new p();
        a aVar = new a();
        this.f7853g = aVar;
        Handler handler = new Handler(Looper.getMainLooper());
        this.f7854h = handler;
        this.f7847a = cVar;
        this.f7849c = hVar;
        this.f7851e = mVar;
        this.f7850d = nVar;
        this.f7848b = context;
        g5.c a10 = dVar.a(context.getApplicationContext(), new c(nVar));
        this.f7855i = a10;
        if (k.p()) {
            handler.post(aVar);
        } else {
            hVar.a(this);
        }
        hVar.a(a10);
        this.f7856j = new CopyOnWriteArrayList<>(cVar.i().c());
        x(cVar.i().d());
        cVar.o(this);
    }
}
