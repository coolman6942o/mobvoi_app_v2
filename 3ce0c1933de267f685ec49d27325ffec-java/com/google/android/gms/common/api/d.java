package com.google.android.gms.common.api;

import a7.e;
import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.fragment.app.f;
import b6.c;
import b6.i;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.internal.g;
import com.google.android.gms.common.api.internal.g2;
import com.google.android.gms.common.api.internal.l;
import com.google.android.gms.common.api.internal.n0;
import com.google.android.gms.common.api.internal.n2;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a  reason: collision with root package name */
    private static final Set<d> f8467a = Collections.newSetFromMap(new WeakHashMap());

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private Account f8468a;

        /* renamed from: d  reason: collision with root package name */
        private int f8471d;

        /* renamed from: e  reason: collision with root package name */
        private View f8472e;

        /* renamed from: f  reason: collision with root package name */
        private String f8473f;

        /* renamed from: g  reason: collision with root package name */
        private String f8474g;

        /* renamed from: i  reason: collision with root package name */
        private final Context f8476i;

        /* renamed from: k  reason: collision with root package name */
        private g f8478k;

        /* renamed from: m  reason: collision with root package name */
        private c f8480m;

        /* renamed from: n  reason: collision with root package name */
        private Looper f8481n;

        /* renamed from: b  reason: collision with root package name */
        private final Set<Scope> f8469b = new HashSet();

        /* renamed from: c  reason: collision with root package name */
        private final Set<Scope> f8470c = new HashSet();

        /* renamed from: h  reason: collision with root package name */
        private final Map<com.google.android.gms.common.api.a<?>, c.b> f8475h = new androidx.collection.a();

        /* renamed from: j  reason: collision with root package name */
        private final Map<com.google.android.gms.common.api.a<?>, a.d> f8477j = new androidx.collection.a();

        /* renamed from: l  reason: collision with root package name */
        private int f8479l = -1;

        /* renamed from: o  reason: collision with root package name */
        private com.google.android.gms.common.b f8482o = com.google.android.gms.common.b.q();

        /* renamed from: p  reason: collision with root package name */
        private a.AbstractC0105a<? extends e, a7.a> f8483p = a7.b.f121c;

        /* renamed from: q  reason: collision with root package name */
        private final ArrayList<b> f8484q = new ArrayList<>();

        /* renamed from: r  reason: collision with root package name */
        private final ArrayList<c> f8485r = new ArrayList<>();

        public a(Context context) {
            this.f8476i = context;
            this.f8481n = context.getMainLooper();
            this.f8473f = context.getPackageName();
            this.f8474g = context.getClass().getName();
        }

        public final a a(com.google.android.gms.common.api.a<Object> aVar) {
            i.l(aVar, "Api must not be null");
            this.f8477j.put(aVar, null);
            List<Scope> a10 = aVar.c().a(null);
            this.f8470c.addAll(a10);
            this.f8469b.addAll(a10);
            return this;
        }

        public final <O extends a.d.c> a b(com.google.android.gms.common.api.a<O> aVar, O o10) {
            i.l(aVar, "Api must not be null");
            i.l(o10, "Null options are not permitted for this Api");
            this.f8477j.put(aVar, o10);
            List<Scope> a10 = aVar.c().a(o10);
            this.f8470c.addAll(a10);
            this.f8469b.addAll(a10);
            return this;
        }

        public final a c(b bVar) {
            i.l(bVar, "Listener must not be null");
            this.f8484q.add(bVar);
            return this;
        }

        public final a d(c cVar) {
            i.l(cVar, "Listener must not be null");
            this.f8485r.add(cVar);
            return this;
        }

        /* JADX WARN: Type inference failed for: r4v17, types: [com.google.android.gms.common.api.a$f, java.lang.Object] */
        public final d e() {
            i.b(!this.f8477j.isEmpty(), "must call addApi() to add at least one API");
            b6.c f10 = f();
            com.google.android.gms.common.api.a<?> aVar = null;
            Map<com.google.android.gms.common.api.a<?>, c.b> g10 = f10.g();
            androidx.collection.a aVar2 = new androidx.collection.a();
            androidx.collection.a aVar3 = new androidx.collection.a();
            ArrayList arrayList = new ArrayList();
            boolean z10 = false;
            for (com.google.android.gms.common.api.a<?> aVar4 : this.f8477j.keySet()) {
                a.d dVar = this.f8477j.get(aVar4);
                boolean z11 = g10.get(aVar4) != null;
                aVar2.put(aVar4, Boolean.valueOf(z11));
                n2 n2Var = new n2(aVar4, z11);
                arrayList.add(n2Var);
                a.AbstractC0105a<?, ?> d10 = aVar4.d();
                ?? c10 = d10.c(this.f8476i, this.f8481n, f10, dVar, n2Var, n2Var);
                aVar3.put(aVar4.a(), c10);
                if (d10.b() == 1) {
                    z10 = dVar != null;
                }
                if (c10.f()) {
                    if (aVar == null) {
                        aVar = aVar4;
                    } else {
                        String b10 = aVar4.b();
                        String b11 = aVar.b();
                        StringBuilder sb2 = new StringBuilder(String.valueOf(b10).length() + 21 + String.valueOf(b11).length());
                        sb2.append(b10);
                        sb2.append(" cannot be used with ");
                        sb2.append(b11);
                        throw new IllegalStateException(sb2.toString());
                    }
                }
            }
            if (aVar != null) {
                if (!z10) {
                    i.p(this.f8468a == null, "Must not set an account in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead", aVar.b());
                    i.p(this.f8469b.equals(this.f8470c), "Must not set scopes in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead.", aVar.b());
                } else {
                    String b12 = aVar.b();
                    StringBuilder sb3 = new StringBuilder(String.valueOf(b12).length() + 82);
                    sb3.append("With using ");
                    sb3.append(b12);
                    sb3.append(", GamesOptions can only be specified within GoogleSignInOptions.Builder");
                    throw new IllegalStateException(sb3.toString());
                }
            }
            n0 n0Var = new n0(this.f8476i, new ReentrantLock(), this.f8481n, f10, this.f8482o, this.f8483p, aVar2, this.f8484q, this.f8485r, aVar3, this.f8479l, n0.x(aVar3.values(), true), arrayList, false);
            synchronized (d.f8467a) {
                d.f8467a.add(n0Var);
            }
            if (this.f8479l >= 0) {
                g2.q(this.f8478k).s(this.f8479l, n0Var, this.f8480m);
            }
            return n0Var;
        }

        public final b6.c f() {
            a7.a aVar = a7.a.f110i;
            Map<com.google.android.gms.common.api.a<?>, a.d> map = this.f8477j;
            com.google.android.gms.common.api.a<a7.a> aVar2 = a7.b.f123e;
            if (map.containsKey(aVar2)) {
                aVar = (a7.a) this.f8477j.get(aVar2);
            }
            return new b6.c(this.f8468a, this.f8469b, this.f8475h, this.f8471d, this.f8472e, this.f8473f, this.f8474g, aVar, false);
        }

        public final a g(f fVar, int i10, c cVar) {
            g gVar = new g(fVar);
            i.b(i10 >= 0, "clientId must be non-negative");
            this.f8479l = i10;
            this.f8480m = cVar;
            this.f8478k = gVar;
            return this;
        }

        public final a h(f fVar, c cVar) {
            return g(fVar, 0, cVar);
        }

        public final a i(Handler handler) {
            i.l(handler, "Handler must not be null");
            this.f8481n = handler.getLooper();
            return this;
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void onConnected(Bundle bundle);

        void onConnectionSuspended(int i10);
    }

    /* loaded from: classes.dex */
    public interface c {
        void onConnectionFailed(ConnectionResult connectionResult);
    }

    public static Set<d> l() {
        Set<d> set = f8467a;
        synchronized (set) {
        }
        return set;
    }

    public abstract ConnectionResult d();

    public abstract e<Status> e();

    public abstract void f();

    public void g(int i10) {
        throw new UnsupportedOperationException();
    }

    public abstract void h();

    public abstract void i(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public <A extends a.b, R extends h, T extends com.google.android.gms.common.api.internal.c<R, A>> T j(T t10) {
        throw new UnsupportedOperationException();
    }

    public <A extends a.b, T extends com.google.android.gms.common.api.internal.c<? extends h, A>> T k(T t10) {
        throw new UnsupportedOperationException();
    }

    public <C extends a.f> C m(a.c<C> cVar) {
        throw new UnsupportedOperationException();
    }

    public Context n() {
        throw new UnsupportedOperationException();
    }

    public Looper o() {
        throw new UnsupportedOperationException();
    }

    public abstract boolean p();

    public boolean q(l lVar) {
        throw new UnsupportedOperationException();
    }

    public void r() {
        throw new UnsupportedOperationException();
    }

    public abstract void s();

    public abstract void t(c cVar);

    public abstract void u(c cVar);
}
