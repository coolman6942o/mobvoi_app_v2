package com.google.android.gms.common.api.internal;

import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import b6.g;
import b6.h;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.UnsupportedApiCallException;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.internal.i;
import com.google.android.gms.common.internal.b;
import com.google.android.gms.common.internal.f;
import com.google.android.gms.common.internal.k;
import h6.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class e implements Handler.Callback {

    /* renamed from: n  reason: collision with root package name */
    public static final Status f8553n = new Status(4, "Sign-out occurred while this API call was in progress.");

    /* renamed from: o  reason: collision with root package name */
    private static final Status f8554o = new Status(4, "The user must be signed in to make this API call.");

    /* renamed from: p  reason: collision with root package name */
    private static final Object f8555p = new Object();

    /* renamed from: q  reason: collision with root package name */
    private static e f8556q;

    /* renamed from: d  reason: collision with root package name */
    private final Context f8560d;

    /* renamed from: e  reason: collision with root package name */
    private final com.google.android.gms.common.b f8561e;

    /* renamed from: f  reason: collision with root package name */
    private final g f8562f;

    /* renamed from: j  reason: collision with root package name */
    private v f8566j;

    /* renamed from: m  reason: collision with root package name */
    private final Handler f8569m;

    /* renamed from: a  reason: collision with root package name */
    private long f8557a = 5000;

    /* renamed from: b  reason: collision with root package name */
    private long f8558b = 120000;

    /* renamed from: c  reason: collision with root package name */
    private long f8559c = 10000;

    /* renamed from: g  reason: collision with root package name */
    private final AtomicInteger f8563g = new AtomicInteger(1);

    /* renamed from: h  reason: collision with root package name */
    private final AtomicInteger f8564h = new AtomicInteger(0);

    /* renamed from: i  reason: collision with root package name */
    private final Map<f2<?>, a<?>> f8565i = new ConcurrentHashMap(5, 0.75f, 1);

    /* renamed from: k  reason: collision with root package name */
    private final Set<f2<?>> f8567k = new androidx.collection.b();

    /* renamed from: l  reason: collision with root package name */
    private final Set<f2<?>> f8568l = new androidx.collection.b();

    /* loaded from: classes.dex */
    public class a<O extends a.d> implements d.b, d.c, o2 {

        /* renamed from: b  reason: collision with root package name */
        private final a.f f8571b;

        /* renamed from: c  reason: collision with root package name */
        private final a.b f8572c;

        /* renamed from: d  reason: collision with root package name */
        private final f2<O> f8573d;

        /* renamed from: e  reason: collision with root package name */
        private final s f8574e;

        /* renamed from: h  reason: collision with root package name */
        private final int f8577h;

        /* renamed from: i  reason: collision with root package name */
        private final q1 f8578i;

        /* renamed from: j  reason: collision with root package name */
        private boolean f8579j;

        /* renamed from: a  reason: collision with root package name */
        private final Queue<r0> f8570a = new LinkedList();

        /* renamed from: f  reason: collision with root package name */
        private final Set<h2> f8575f = new HashSet();

        /* renamed from: g  reason: collision with root package name */
        private final Map<i.a<?>, o1> f8576g = new HashMap();

        /* renamed from: k  reason: collision with root package name */
        private final List<b> f8580k = new ArrayList();

        /* renamed from: l  reason: collision with root package name */
        private ConnectionResult f8581l = null;

        public a(com.google.android.gms.common.api.c<O> cVar) {
            a.f k10 = cVar.k(e.this.f8569m.getLooper(), this);
            this.f8571b = k10;
            if (k10 instanceof k) {
                this.f8572c = ((k) k10).q0();
            } else {
                this.f8572c = k10;
            }
            this.f8573d = cVar.o();
            this.f8574e = new s();
            this.f8577h = cVar.i();
            if (k10.t()) {
                this.f8578i = cVar.m(e.this.f8560d, e.this.f8569m);
            } else {
                this.f8578i = null;
            }
        }

        private final void D(r0 r0Var) {
            r0Var.d(this.f8574e, e());
            try {
                r0Var.c(this);
            } catch (DeadObjectException unused) {
                onConnectionSuspended(1);
                this.f8571b.a();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean E(boolean z10) {
            b6.i.d(e.this.f8569m);
            if (!this.f8571b.isConnected() || this.f8576g.size() != 0) {
                return false;
            }
            if (this.f8574e.e()) {
                if (z10) {
                    z();
                }
                return false;
            }
            this.f8571b.a();
            return true;
        }

        private final boolean J(ConnectionResult connectionResult) {
            synchronized (e.f8555p) {
                v unused = e.this.f8566j;
            }
            return false;
        }

        private final void K(ConnectionResult connectionResult) {
            for (h2 h2Var : this.f8575f) {
                String str = null;
                if (h.a(connectionResult, ConnectionResult.f8431e)) {
                    str = this.f8571b.i();
                }
                h2Var.b(this.f8573d, connectionResult, str);
            }
            this.f8575f.clear();
        }

        private final Feature g(Feature[] featureArr) {
            if (!(featureArr == null || featureArr.length == 0)) {
                Feature[] r10 = this.f8571b.r();
                if (r10 == null) {
                    r10 = new Feature[0];
                }
                androidx.collection.a aVar = new androidx.collection.a(r10.length);
                for (Feature feature : r10) {
                    aVar.put(feature.getName(), Long.valueOf(feature.G0()));
                }
                for (Feature feature2 : featureArr) {
                    if (!aVar.containsKey(feature2.getName()) || ((Long) aVar.get(feature2.getName())).longValue() < feature2.G0()) {
                        return feature2;
                    }
                }
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void i(b bVar) {
            if (!this.f8580k.contains(bVar) || this.f8579j) {
                return;
            }
            if (!this.f8571b.isConnected()) {
                a();
            } else {
                t();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void p(b bVar) {
            Feature[] g10;
            if (this.f8580k.remove(bVar)) {
                e.this.f8569m.removeMessages(15, bVar);
                e.this.f8569m.removeMessages(16, bVar);
                Feature feature = bVar.f8584b;
                ArrayList arrayList = new ArrayList(this.f8570a.size());
                for (r0 r0Var : this.f8570a) {
                    if ((r0Var instanceof p1) && (g10 = ((p1) r0Var).g(this)) != null && h6.b.b(g10, feature)) {
                        arrayList.add(r0Var);
                    }
                }
                int size = arrayList.size();
                int i10 = 0;
                while (i10 < size) {
                    Object obj = arrayList.get(i10);
                    i10++;
                    r0 r0Var2 = (r0) obj;
                    this.f8570a.remove(r0Var2);
                    r0Var2.e(new UnsupportedApiCallException(feature));
                }
            }
        }

        private final boolean q(r0 r0Var) {
            if (!(r0Var instanceof p1)) {
                D(r0Var);
                return true;
            }
            p1 p1Var = (p1) r0Var;
            Feature g10 = g(p1Var.g(this));
            if (g10 == null) {
                D(r0Var);
                return true;
            } else if (p1Var.h(this)) {
                b bVar = new b(this.f8573d, g10, null);
                int indexOf = this.f8580k.indexOf(bVar);
                if (indexOf >= 0) {
                    b bVar2 = this.f8580k.get(indexOf);
                    e.this.f8569m.removeMessages(15, bVar2);
                    e.this.f8569m.sendMessageDelayed(Message.obtain(e.this.f8569m, 15, bVar2), e.this.f8557a);
                    return false;
                }
                this.f8580k.add(bVar);
                e.this.f8569m.sendMessageDelayed(Message.obtain(e.this.f8569m, 15, bVar), e.this.f8557a);
                e.this.f8569m.sendMessageDelayed(Message.obtain(e.this.f8569m, 16, bVar), e.this.f8558b);
                ConnectionResult connectionResult = new ConnectionResult(2, null);
                if (J(connectionResult)) {
                    return false;
                }
                e.this.t(connectionResult, this.f8577h);
                return false;
            } else {
                p1Var.e(new UnsupportedApiCallException(g10));
                return false;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void r() {
            w();
            K(ConnectionResult.f8431e);
            y();
            Iterator<o1> it = this.f8576g.values().iterator();
            while (it.hasNext()) {
                o1 next = it.next();
                if (g(next.f8687a.c()) != null) {
                    it.remove();
                } else {
                    try {
                        next.f8687a.d(this.f8572c, new com.google.android.gms.tasks.c<>());
                    } catch (DeadObjectException unused) {
                        onConnectionSuspended(1);
                        this.f8571b.a();
                    } catch (RemoteException unused2) {
                        it.remove();
                    }
                }
            }
            t();
            z();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void s() {
            w();
            this.f8579j = true;
            this.f8574e.g();
            e.this.f8569m.sendMessageDelayed(Message.obtain(e.this.f8569m, 9, this.f8573d), e.this.f8557a);
            e.this.f8569m.sendMessageDelayed(Message.obtain(e.this.f8569m, 11, this.f8573d), e.this.f8558b);
            e.this.f8562f.a();
        }

        private final void t() {
            ArrayList arrayList = new ArrayList(this.f8570a);
            int size = arrayList.size();
            int i10 = 0;
            while (i10 < size) {
                Object obj = arrayList.get(i10);
                i10++;
                r0 r0Var = (r0) obj;
                if (!this.f8571b.isConnected()) {
                    return;
                }
                if (q(r0Var)) {
                    this.f8570a.remove(r0Var);
                }
            }
        }

        private final void y() {
            if (this.f8579j) {
                e.this.f8569m.removeMessages(11, this.f8573d);
                e.this.f8569m.removeMessages(9, this.f8573d);
                this.f8579j = false;
            }
        }

        private final void z() {
            e.this.f8569m.removeMessages(12, this.f8573d);
            e.this.f8569m.sendMessageDelayed(e.this.f8569m.obtainMessage(12, this.f8573d), e.this.f8559c);
        }

        public final boolean A() {
            return E(true);
        }

        final a7.e B() {
            q1 q1Var = this.f8578i;
            if (q1Var == null) {
                return null;
            }
            return q1Var.C2();
        }

        public final void C(Status status) {
            b6.i.d(e.this.f8569m);
            for (r0 r0Var : this.f8570a) {
                r0Var.b(status);
            }
            this.f8570a.clear();
        }

        public final void I(ConnectionResult connectionResult) {
            b6.i.d(e.this.f8569m);
            this.f8571b.a();
            onConnectionFailed(connectionResult);
        }

        public final void a() {
            b6.i.d(e.this.f8569m);
            if (!this.f8571b.isConnected() && !this.f8571b.h()) {
                int b10 = e.this.f8562f.b(e.this.f8560d, this.f8571b);
                if (b10 != 0) {
                    onConnectionFailed(new ConnectionResult(b10, null));
                    return;
                }
                c cVar = new c(this.f8571b, this.f8573d);
                if (this.f8571b.t()) {
                    this.f8578i.B2(cVar);
                }
                this.f8571b.j(cVar);
            }
        }

        public final int b() {
            return this.f8577h;
        }

        @Override // com.google.android.gms.common.api.internal.o2
        public final void c(ConnectionResult connectionResult, com.google.android.gms.common.api.a<?> aVar, boolean z10) {
            if (Looper.myLooper() == e.this.f8569m.getLooper()) {
                onConnectionFailed(connectionResult);
            } else {
                e.this.f8569m.post(new d1(this, connectionResult));
            }
        }

        final boolean d() {
            return this.f8571b.isConnected();
        }

        public final boolean e() {
            return this.f8571b.t();
        }

        public final void f() {
            b6.i.d(e.this.f8569m);
            if (this.f8579j) {
                a();
            }
        }

        public final void j(r0 r0Var) {
            b6.i.d(e.this.f8569m);
            if (!this.f8571b.isConnected()) {
                this.f8570a.add(r0Var);
                ConnectionResult connectionResult = this.f8581l;
                if (connectionResult == null || !connectionResult.J0()) {
                    a();
                } else {
                    onConnectionFailed(this.f8581l);
                }
            } else if (q(r0Var)) {
                z();
            } else {
                this.f8570a.add(r0Var);
            }
        }

        public final void k(h2 h2Var) {
            b6.i.d(e.this.f8569m);
            this.f8575f.add(h2Var);
        }

        public final a.f m() {
            return this.f8571b;
        }

        public final void n() {
            Status status;
            b6.i.d(e.this.f8569m);
            if (this.f8579j) {
                y();
                if (e.this.f8561e.i(e.this.f8560d) == 18) {
                    status = new Status(8, "Connection timed out while waiting for Google Play services update to complete.");
                } else {
                    status = new Status(8, "API failed to connect while resuming due to an unknown error.");
                }
                C(status);
                this.f8571b.a();
            }
        }

        @Override // com.google.android.gms.common.api.d.b
        public final void onConnected(Bundle bundle) {
            if (Looper.myLooper() == e.this.f8569m.getLooper()) {
                r();
            } else {
                e.this.f8569m.post(new b1(this));
            }
        }

        @Override // com.google.android.gms.common.api.d.c
        public final void onConnectionFailed(ConnectionResult connectionResult) {
            b6.i.d(e.this.f8569m);
            q1 q1Var = this.f8578i;
            if (q1Var != null) {
                q1Var.D2();
            }
            w();
            e.this.f8562f.a();
            K(connectionResult);
            if (connectionResult.G0() == 4) {
                C(e.f8554o);
            } else if (this.f8570a.isEmpty()) {
                this.f8581l = connectionResult;
            } else if (!J(connectionResult) && !e.this.t(connectionResult, this.f8577h)) {
                if (connectionResult.G0() == 18) {
                    this.f8579j = true;
                }
                if (this.f8579j) {
                    e.this.f8569m.sendMessageDelayed(Message.obtain(e.this.f8569m, 9, this.f8573d), e.this.f8557a);
                    return;
                }
                String c10 = this.f8573d.c();
                StringBuilder sb2 = new StringBuilder(String.valueOf(c10).length() + 38);
                sb2.append("API: ");
                sb2.append(c10);
                sb2.append(" is not available on this device.");
                C(new Status(17, sb2.toString()));
            }
        }

        @Override // com.google.android.gms.common.api.d.b
        public final void onConnectionSuspended(int i10) {
            if (Looper.myLooper() == e.this.f8569m.getLooper()) {
                s();
            } else {
                e.this.f8569m.post(new c1(this));
            }
        }

        public final void u() {
            b6.i.d(e.this.f8569m);
            C(e.f8553n);
            this.f8574e.f();
            for (i.a aVar : (i.a[]) this.f8576g.keySet().toArray(new i.a[this.f8576g.size()])) {
                j(new e2(aVar, new com.google.android.gms.tasks.c()));
            }
            K(new ConnectionResult(4));
            if (this.f8571b.isConnected()) {
                this.f8571b.l(new e1(this));
            }
        }

        public final Map<i.a<?>, o1> v() {
            return this.f8576g;
        }

        public final void w() {
            b6.i.d(e.this.f8569m);
            this.f8581l = null;
        }

        public final ConnectionResult x() {
            b6.i.d(e.this.f8569m);
            return this.f8581l;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c implements t1, b.c {

        /* renamed from: a  reason: collision with root package name */
        private final a.f f8585a;

        /* renamed from: b  reason: collision with root package name */
        private final f2<?> f8586b;

        /* renamed from: c  reason: collision with root package name */
        private f f8587c = null;

        /* renamed from: d  reason: collision with root package name */
        private Set<Scope> f8588d = null;

        /* renamed from: e  reason: collision with root package name */
        private boolean f8589e = false;

        public c(a.f fVar, f2<?> f2Var) {
            this.f8585a = fVar;
            this.f8586b = f2Var;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void g() {
            f fVar;
            if (this.f8589e && (fVar = this.f8587c) != null) {
                this.f8585a.g(fVar, this.f8588d);
            }
        }

        @Override // com.google.android.gms.common.internal.b.c
        public final void a(ConnectionResult connectionResult) {
            e.this.f8569m.post(new g1(this, connectionResult));
        }

        @Override // com.google.android.gms.common.api.internal.t1
        public final void b(f fVar, Set<Scope> set) {
            if (fVar == null || set == null) {
                Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
                c(new ConnectionResult(4));
                return;
            }
            this.f8587c = fVar;
            this.f8588d = set;
            g();
        }

        @Override // com.google.android.gms.common.api.internal.t1
        public final void c(ConnectionResult connectionResult) {
            ((a) e.this.f8565i.get(this.f8586b)).I(connectionResult);
        }
    }

    private e(Context context, Looper looper, com.google.android.gms.common.b bVar) {
        this.f8560d = context;
        q6.i iVar = new q6.i(looper, this);
        this.f8569m = iVar;
        this.f8561e = bVar;
        this.f8562f = new g(bVar);
        iVar.sendMessage(iVar.obtainMessage(6));
    }

    public static void b() {
        synchronized (f8555p) {
            e eVar = f8556q;
            if (eVar != null) {
                eVar.f8564h.incrementAndGet();
                Handler handler = eVar.f8569m;
                handler.sendMessageAtFrontOfQueue(handler.obtainMessage(10));
            }
        }
    }

    public static e m(Context context) {
        e eVar;
        synchronized (f8555p) {
            if (f8556q == null) {
                HandlerThread handlerThread = new HandlerThread("GoogleApiHandler", 9);
                handlerThread.start();
                f8556q = new e(context.getApplicationContext(), handlerThread.getLooper(), com.google.android.gms.common.b.q());
            }
            eVar = f8556q;
        }
        return eVar;
    }

    private final void n(com.google.android.gms.common.api.c<?> cVar) {
        f2<?> o10 = cVar.o();
        a<?> aVar = this.f8565i.get(o10);
        if (aVar == null) {
            aVar = new a<>(cVar);
            this.f8565i.put(o10, aVar);
        }
        if (aVar.e()) {
            this.f8568l.add(o10);
        }
        aVar.a();
    }

    public static e o() {
        e eVar;
        synchronized (f8555p) {
            b6.i.l(f8556q, "Must guarantee manager is non-null before using getInstance");
            eVar = f8556q;
        }
        return eVar;
    }

    public final void A() {
        Handler handler = this.f8569m;
        handler.sendMessage(handler.obtainMessage(3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a() {
        this.f8564h.incrementAndGet();
        Handler handler = this.f8569m;
        handler.sendMessage(handler.obtainMessage(10));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final PendingIntent c(f2<?> f2Var, int i10) {
        a7.e B;
        a<?> aVar = this.f8565i.get(f2Var);
        if (aVar == null || (B = aVar.B()) == null) {
            return null;
        }
        return PendingIntent.getActivity(this.f8560d, i10, B.s(), 134217728);
    }

    public final <O extends a.d> com.google.android.gms.tasks.b<Boolean> e(com.google.android.gms.common.api.c<O> cVar, i.a<?> aVar) {
        com.google.android.gms.tasks.c cVar2 = new com.google.android.gms.tasks.c();
        e2 e2Var = new e2(aVar, cVar2);
        Handler handler = this.f8569m;
        handler.sendMessage(handler.obtainMessage(13, new n1(e2Var, this.f8564h.get(), cVar)));
        return cVar2.a();
    }

    public final <O extends a.d> com.google.android.gms.tasks.b<Void> f(com.google.android.gms.common.api.c<O> cVar, k<a.b, ?> kVar, q<a.b, ?> qVar) {
        com.google.android.gms.tasks.c cVar2 = new com.google.android.gms.tasks.c();
        c2 c2Var = new c2(new o1(kVar, qVar), cVar2);
        Handler handler = this.f8569m;
        handler.sendMessage(handler.obtainMessage(8, new n1(c2Var, this.f8564h.get(), cVar)));
        return cVar2.a();
    }

    public final com.google.android.gms.tasks.b<Map<f2<?>, String>> g(Iterable<? extends com.google.android.gms.common.api.c<?>> iterable) {
        h2 h2Var = new h2(iterable);
        Handler handler = this.f8569m;
        handler.sendMessage(handler.obtainMessage(2, h2Var));
        return h2Var.a();
    }

    public final void h(ConnectionResult connectionResult, int i10) {
        if (!t(connectionResult, i10)) {
            Handler handler = this.f8569m;
            handler.sendMessage(handler.obtainMessage(5, i10, 0, connectionResult));
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i10 = message.what;
        long j10 = 300000;
        a<?> aVar = null;
        switch (i10) {
            case 1:
                if (((Boolean) message.obj).booleanValue()) {
                    j10 = 10000;
                }
                this.f8559c = j10;
                this.f8569m.removeMessages(12);
                for (f2<?> f2Var : this.f8565i.keySet()) {
                    Handler handler = this.f8569m;
                    handler.sendMessageDelayed(handler.obtainMessage(12, f2Var), this.f8559c);
                }
                break;
            case 2:
                h2 h2Var = (h2) message.obj;
                Iterator<f2<?>> it = h2Var.c().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else {
                        f2<?> next = it.next();
                        a<?> aVar2 = this.f8565i.get(next);
                        if (aVar2 == null) {
                            h2Var.b(next, new ConnectionResult(13), null);
                            break;
                        } else if (aVar2.d()) {
                            h2Var.b(next, ConnectionResult.f8431e, aVar2.m().i());
                        } else if (aVar2.x() != null) {
                            h2Var.b(next, aVar2.x(), null);
                        } else {
                            aVar2.k(h2Var);
                            aVar2.a();
                        }
                    }
                }
            case 3:
                for (a<?> aVar3 : this.f8565i.values()) {
                    aVar3.w();
                    aVar3.a();
                }
                break;
            case 4:
            case 8:
            case 13:
                n1 n1Var = (n1) message.obj;
                a<?> aVar4 = this.f8565i.get(n1Var.f8680c.o());
                if (aVar4 == null) {
                    n(n1Var.f8680c);
                    aVar4 = this.f8565i.get(n1Var.f8680c.o());
                }
                if (!aVar4.e() || this.f8564h.get() == n1Var.f8679b) {
                    aVar4.j(n1Var.f8678a);
                    break;
                } else {
                    n1Var.f8678a.b(f8553n);
                    aVar4.u();
                    break;
                }
                break;
            case 5:
                int i11 = message.arg1;
                ConnectionResult connectionResult = (ConnectionResult) message.obj;
                Iterator<a<?>> it2 = this.f8565i.values().iterator();
                while (true) {
                    if (it2.hasNext()) {
                        a<?> next2 = it2.next();
                        if (next2.b() == i11) {
                            aVar = next2;
                        }
                    }
                }
                if (aVar != null) {
                    String g10 = this.f8561e.g(connectionResult.G0());
                    String H0 = connectionResult.H0();
                    StringBuilder sb2 = new StringBuilder(String.valueOf(g10).length() + 69 + String.valueOf(H0).length());
                    sb2.append("Error resolution was canceled by the user, original error message: ");
                    sb2.append(g10);
                    sb2.append(": ");
                    sb2.append(H0);
                    aVar.C(new Status(17, sb2.toString()));
                    break;
                } else {
                    StringBuilder sb3 = new StringBuilder(76);
                    sb3.append("Could not find API instance ");
                    sb3.append(i11);
                    sb3.append(" while trying to fail enqueued calls.");
                    Log.wtf("GoogleApiManager", sb3.toString(), new Exception());
                    break;
                }
            case 6:
                if (n.a() && (this.f8560d.getApplicationContext() instanceof Application)) {
                    com.google.android.gms.common.api.internal.b.c((Application) this.f8560d.getApplicationContext());
                    com.google.android.gms.common.api.internal.b.b().a(new a1(this));
                    if (!com.google.android.gms.common.api.internal.b.b().f(true)) {
                        this.f8559c = 300000L;
                        break;
                    }
                }
                break;
            case 7:
                n((com.google.android.gms.common.api.c) message.obj);
                break;
            case 9:
                if (this.f8565i.containsKey(message.obj)) {
                    this.f8565i.get(message.obj).f();
                    break;
                }
                break;
            case 10:
                for (f2<?> f2Var2 : this.f8568l) {
                    this.f8565i.remove(f2Var2).u();
                }
                this.f8568l.clear();
                break;
            case 11:
                if (this.f8565i.containsKey(message.obj)) {
                    this.f8565i.get(message.obj).n();
                    break;
                }
                break;
            case 12:
                if (this.f8565i.containsKey(message.obj)) {
                    this.f8565i.get(message.obj).A();
                    break;
                }
                break;
            case 14:
                w wVar = (w) message.obj;
                f2<?> b10 = wVar.b();
                if (!this.f8565i.containsKey(b10)) {
                    wVar.a().c(Boolean.FALSE);
                    break;
                } else {
                    wVar.a().c(Boolean.valueOf(this.f8565i.get(b10).E(false)));
                    break;
                }
            case 15:
                b bVar = (b) message.obj;
                if (this.f8565i.containsKey(bVar.f8583a)) {
                    this.f8565i.get(bVar.f8583a).i(bVar);
                    break;
                }
                break;
            case 16:
                b bVar2 = (b) message.obj;
                if (this.f8565i.containsKey(bVar2.f8583a)) {
                    this.f8565i.get(bVar2.f8583a).p(bVar2);
                    break;
                }
                break;
            default:
                StringBuilder sb4 = new StringBuilder(31);
                sb4.append("Unknown message id: ");
                sb4.append(i10);
                Log.w("GoogleApiManager", sb4.toString());
                return false;
        }
        return true;
    }

    public final void i(com.google.android.gms.common.api.c<?> cVar) {
        Handler handler = this.f8569m;
        handler.sendMessage(handler.obtainMessage(7, cVar));
    }

    public final <O extends a.d> void j(com.google.android.gms.common.api.c<O> cVar, int i10, com.google.android.gms.common.api.internal.c<? extends com.google.android.gms.common.api.h, a.b> cVar2) {
        b2 b2Var = new b2(i10, cVar2);
        Handler handler = this.f8569m;
        handler.sendMessage(handler.obtainMessage(4, new n1(b2Var, this.f8564h.get(), cVar)));
    }

    public final <O extends a.d, ResultT> void k(com.google.android.gms.common.api.c<O> cVar, int i10, o<a.b, ResultT> oVar, com.google.android.gms.tasks.c<ResultT> cVar2, m mVar) {
        d2 d2Var = new d2(i10, oVar, cVar2, mVar);
        Handler handler = this.f8569m;
        handler.sendMessage(handler.obtainMessage(4, new n1(d2Var, this.f8564h.get(), cVar)));
    }

    public final int p() {
        return this.f8563g.getAndIncrement();
    }

    final boolean t(ConnectionResult connectionResult, int i10) {
        return this.f8561e.B(this.f8560d, connectionResult, i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private final f2<?> f8583a;

        /* renamed from: b  reason: collision with root package name */
        private final Feature f8584b;

        private b(f2<?> f2Var, Feature feature) {
            this.f8583a = f2Var;
            this.f8584b = feature;
        }

        public final boolean equals(Object obj) {
            if (obj != null && (obj instanceof b)) {
                b bVar = (b) obj;
                if (h.a(this.f8583a, bVar.f8583a) && h.a(this.f8584b, bVar.f8584b)) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return h.b(this.f8583a, this.f8584b);
        }

        public final String toString() {
            return h.c(this).a("key", this.f8583a).a("feature", this.f8584b).toString();
        }

        /* synthetic */ b(f2 f2Var, Feature feature, a1 a1Var) {
            this(f2Var, feature);
        }
    }
}
