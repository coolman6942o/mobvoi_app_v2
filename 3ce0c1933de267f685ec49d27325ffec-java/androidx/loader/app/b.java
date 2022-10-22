package androidx.loader.app;

import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.collection.g;
import androidx.lifecycle.f0;
import androidx.lifecycle.h0;
import androidx.lifecycle.i0;
import androidx.lifecycle.p;
import androidx.lifecycle.w;
import androidx.lifecycle.x;
import androidx.loader.app.a;
import androidx.loader.content.c;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LoaderManagerImpl.java */
/* loaded from: classes.dex */
public class b extends androidx.loader.app.a {

    /* renamed from: c  reason: collision with root package name */
    static boolean f3352c = false;

    /* renamed from: a  reason: collision with root package name */
    private final p f3353a;

    /* renamed from: b  reason: collision with root package name */
    private final c f3354b;

    /* compiled from: LoaderManagerImpl.java */
    /* loaded from: classes.dex */
    public static class a<D> extends w<D> implements c.AbstractC0037c<D> {

        /* renamed from: l  reason: collision with root package name */
        private final int f3355l;

        /* renamed from: m  reason: collision with root package name */
        private final Bundle f3356m;

        /* renamed from: n  reason: collision with root package name */
        private final androidx.loader.content.c<D> f3357n;

        /* renamed from: o  reason: collision with root package name */
        private p f3358o;

        /* renamed from: p  reason: collision with root package name */
        private C0035b<D> f3359p;

        /* renamed from: q  reason: collision with root package name */
        private androidx.loader.content.c<D> f3360q;

        a(int i10, Bundle bundle, androidx.loader.content.c<D> cVar, androidx.loader.content.c<D> cVar2) {
            this.f3355l = i10;
            this.f3356m = bundle;
            this.f3357n = cVar;
            this.f3360q = cVar2;
            cVar.t(i10, this);
        }

        @Override // androidx.loader.content.c.AbstractC0037c
        public void a(androidx.loader.content.c<D> cVar, D d10) {
            if (b.f3352c) {
                Log.v("LoaderManager", "onLoadComplete: " + this);
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                o(d10);
                return;
            }
            if (b.f3352c) {
                Log.w("LoaderManager", "onLoadComplete was incorrectly called on a background thread");
            }
            m(d10);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.lifecycle.LiveData
        public void k() {
            if (b.f3352c) {
                Log.v("LoaderManager", "  Starting: " + this);
            }
            this.f3357n.w();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.lifecycle.LiveData
        public void l() {
            if (b.f3352c) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.f3357n.x();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.LiveData
        public void n(x<? super D> xVar) {
            super.n(xVar);
            this.f3358o = null;
            this.f3359p = null;
        }

        @Override // androidx.lifecycle.w, androidx.lifecycle.LiveData
        public void o(D d10) {
            super.o(d10);
            androidx.loader.content.c<D> cVar = this.f3360q;
            if (cVar != null) {
                cVar.u();
                this.f3360q = null;
            }
        }

        androidx.loader.content.c<D> p(boolean z10) {
            if (b.f3352c) {
                Log.v("LoaderManager", "  Destroying: " + this);
            }
            this.f3357n.b();
            this.f3357n.a();
            C0035b<D> bVar = this.f3359p;
            if (bVar != null) {
                n(bVar);
                if (z10) {
                    bVar.d();
                }
            }
            this.f3357n.z(this);
            if ((bVar == null || bVar.c()) && !z10) {
                return this.f3357n;
            }
            this.f3357n.u();
            return this.f3360q;
        }

        public void q(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.f3355l);
            printWriter.print(" mArgs=");
            printWriter.println(this.f3356m);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.f3357n);
            androidx.loader.content.c<D> cVar = this.f3357n;
            cVar.g(str + "  ", fileDescriptor, printWriter, strArr);
            if (this.f3359p != null) {
                printWriter.print(str);
                printWriter.print("mCallbacks=");
                printWriter.println(this.f3359p);
                C0035b<D> bVar = this.f3359p;
                bVar.b(str + "  ", printWriter);
            }
            printWriter.print(str);
            printWriter.print("mData=");
            printWriter.println(r().d(f()));
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.println(h());
        }

        androidx.loader.content.c<D> r() {
            return this.f3357n;
        }

        void s() {
            p pVar = this.f3358o;
            C0035b<D> bVar = this.f3359p;
            if (pVar != null && bVar != null) {
                super.n(bVar);
                i(pVar, bVar);
            }
        }

        androidx.loader.content.c<D> t(p pVar, a.AbstractC0034a<D> aVar) {
            C0035b<D> bVar = new C0035b<>(this.f3357n, aVar);
            i(pVar, bVar);
            C0035b<D> bVar2 = this.f3359p;
            if (bVar2 != null) {
                n(bVar2);
            }
            this.f3358o = pVar;
            this.f3359p = bVar;
            return this.f3357n;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder(64);
            sb2.append("LoaderInfo{");
            sb2.append(Integer.toHexString(System.identityHashCode(this)));
            sb2.append(" #");
            sb2.append(this.f3355l);
            sb2.append(" : ");
            j0.b.a(this.f3357n, sb2);
            sb2.append("}}");
            return sb2.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LoaderManagerImpl.java */
    /* renamed from: androidx.loader.app.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0035b<D> implements x<D> {

        /* renamed from: a  reason: collision with root package name */
        private final androidx.loader.content.c<D> f3361a;

        /* renamed from: b  reason: collision with root package name */
        private final a.AbstractC0034a<D> f3362b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f3363c = false;

        C0035b(androidx.loader.content.c<D> cVar, a.AbstractC0034a<D> aVar) {
            this.f3361a = cVar;
            this.f3362b = aVar;
        }

        @Override // androidx.lifecycle.x
        public void a(D d10) {
            if (b.f3352c) {
                Log.v("LoaderManager", "  onLoadFinished in " + this.f3361a + ": " + this.f3361a.d(d10));
            }
            this.f3362b.o(this.f3361a, d10);
            this.f3363c = true;
        }

        public void b(String str, PrintWriter printWriter) {
            printWriter.print(str);
            printWriter.print("mDeliveredData=");
            printWriter.println(this.f3363c);
        }

        boolean c() {
            return this.f3363c;
        }

        void d() {
            if (this.f3363c) {
                if (b.f3352c) {
                    Log.v("LoaderManager", "  Resetting: " + this.f3361a);
                }
                this.f3362b.V(this.f3361a);
            }
        }

        public String toString() {
            return this.f3362b.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LoaderManagerImpl.java */
    /* loaded from: classes.dex */
    public static class c extends f0 {

        /* renamed from: c  reason: collision with root package name */
        private static final h0.b f3364c = new a();

        /* renamed from: a  reason: collision with root package name */
        private g<a> f3365a = new g<>();

        /* renamed from: b  reason: collision with root package name */
        private boolean f3366b = false;

        /* compiled from: LoaderManagerImpl.java */
        /* loaded from: classes.dex */
        static class a implements h0.b {
            a() {
            }

            @Override // androidx.lifecycle.h0.b
            public <T extends f0> T a(Class<T> cls) {
                return new c();
            }
        }

        c() {
        }

        static c c(i0 i0Var) {
            return (c) new h0(i0Var, f3364c).a(c.class);
        }

        public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.f3365a.l() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                String str2 = str + "    ";
                for (int i10 = 0; i10 < this.f3365a.l(); i10++) {
                    a m10 = this.f3365a.m(i10);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.f3365a.i(i10));
                    printWriter.print(": ");
                    printWriter.println(m10.toString());
                    m10.q(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }

        void b() {
            this.f3366b = false;
        }

        <D> a<D> d(int i10) {
            return this.f3365a.e(i10);
        }

        boolean e() {
            return this.f3366b;
        }

        void f() {
            int l10 = this.f3365a.l();
            for (int i10 = 0; i10 < l10; i10++) {
                this.f3365a.m(i10).s();
            }
        }

        void g(int i10, a aVar) {
            this.f3365a.j(i10, aVar);
        }

        void h() {
            this.f3366b = true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.lifecycle.f0
        public void onCleared() {
            super.onCleared();
            int l10 = this.f3365a.l();
            for (int i10 = 0; i10 < l10; i10++) {
                this.f3365a.m(i10).p(true);
            }
            this.f3365a.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(p pVar, i0 i0Var) {
        this.f3353a = pVar;
        this.f3354b = c.c(i0Var);
    }

    /* JADX WARN: Finally extract failed */
    private <D> androidx.loader.content.c<D> e(int i10, Bundle bundle, a.AbstractC0034a<D> aVar, androidx.loader.content.c<D> cVar) {
        try {
            this.f3354b.h();
            androidx.loader.content.c<D> r10 = aVar.r(i10, bundle);
            if (r10 != null) {
                if (r10.getClass().isMemberClass() && !Modifier.isStatic(r10.getClass().getModifiers())) {
                    throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + r10);
                }
                a aVar2 = new a(i10, bundle, r10, cVar);
                if (f3352c) {
                    Log.v("LoaderManager", "  Created new loader " + aVar2);
                }
                this.f3354b.g(i10, aVar2);
                this.f3354b.b();
                return aVar2.t(this.f3353a, aVar);
            }
            throw new IllegalArgumentException("Object returned from onCreateLoader must not be null");
        } catch (Throwable th2) {
            this.f3354b.b();
            throw th2;
        }
    }

    @Override // androidx.loader.app.a
    @Deprecated
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f3354b.a(str, fileDescriptor, printWriter, strArr);
    }

    @Override // androidx.loader.app.a
    public <D> androidx.loader.content.c<D> c(int i10, Bundle bundle, a.AbstractC0034a<D> aVar) {
        if (this.f3354b.e()) {
            throw new IllegalStateException("Called while creating a loader");
        } else if (Looper.getMainLooper() == Looper.myLooper()) {
            a<D> d10 = this.f3354b.d(i10);
            if (f3352c) {
                Log.v("LoaderManager", "initLoader in " + this + ": args=" + bundle);
            }
            if (d10 == null) {
                return e(i10, bundle, aVar, null);
            }
            if (f3352c) {
                Log.v("LoaderManager", "  Re-using existing loader " + d10);
            }
            return d10.t(this.f3353a, aVar);
        } else {
            throw new IllegalStateException("initLoader must be called on the main thread");
        }
    }

    @Override // androidx.loader.app.a
    public void d() {
        this.f3354b.f();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append("LoaderManager{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append(" in ");
        j0.b.a(this.f3353a, sb2);
        sb2.append("}}");
        return sb2.toString();
    }
}
