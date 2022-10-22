package com.google.android.gms.common.api.internal;

import a7.e;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import b6.c;
import b6.i;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.h;
import com.google.android.gms.common.b;
import com.google.android.gms.common.internal.d;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
/* loaded from: classes.dex */
public final class n0 extends d implements l1 {

    /* renamed from: b  reason: collision with root package name */
    private final Lock f8653b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f8654c;

    /* renamed from: d  reason: collision with root package name */
    private final com.google.android.gms.common.internal.d f8655d;

    /* renamed from: f  reason: collision with root package name */
    private final int f8657f;

    /* renamed from: g  reason: collision with root package name */
    private final Context f8658g;

    /* renamed from: h  reason: collision with root package name */
    private final Looper f8659h;

    /* renamed from: j  reason: collision with root package name */
    private volatile boolean f8661j;

    /* renamed from: k  reason: collision with root package name */
    private long f8662k;

    /* renamed from: l  reason: collision with root package name */
    private long f8663l;

    /* renamed from: m  reason: collision with root package name */
    private final t0 f8664m;

    /* renamed from: n  reason: collision with root package name */
    private final b f8665n;

    /* renamed from: o  reason: collision with root package name */
    private i1 f8666o;

    /* renamed from: p  reason: collision with root package name */
    final Map<a.c<?>, a.f> f8667p;

    /* renamed from: q  reason: collision with root package name */
    Set<Scope> f8668q;

    /* renamed from: r  reason: collision with root package name */
    private final c f8669r;

    /* renamed from: s  reason: collision with root package name */
    private final Map<a<?>, Boolean> f8670s;

    /* renamed from: t  reason: collision with root package name */
    private final a.AbstractC0105a<? extends e, a7.a> f8671t;

    /* renamed from: u  reason: collision with root package name */
    private final j f8672u;

    /* renamed from: v  reason: collision with root package name */
    private final ArrayList<n2> f8673v;

    /* renamed from: w  reason: collision with root package name */
    private Integer f8674w;

    /* renamed from: x  reason: collision with root package name */
    Set<v1> f8675x;

    /* renamed from: y  reason: collision with root package name */
    final w1 f8676y;

    /* renamed from: z  reason: collision with root package name */
    private final d.a f8677z;

    /* renamed from: e  reason: collision with root package name */
    private k1 f8656e = null;

    /* renamed from: i  reason: collision with root package name */
    final Queue<c<?, ?>> f8660i = new LinkedList();

    public n0(Context context, Lock lock, Looper looper, c cVar, b bVar, a.AbstractC0105a<? extends e, a7.a> aVar, Map<a<?>, Boolean> map, List<d.b> list, List<d.c> list2, Map<a.c<?>, a.f> map2, int i10, int i11, ArrayList<n2> arrayList, boolean z10) {
        this.f8662k = h6.d.a() ? 10000L : 120000L;
        this.f8663l = 5000L;
        this.f8668q = new HashSet();
        this.f8672u = new j();
        this.f8674w = null;
        this.f8675x = null;
        o0 o0Var = new o0(this);
        this.f8677z = o0Var;
        this.f8658g = context;
        this.f8653b = lock;
        this.f8654c = false;
        this.f8655d = new com.google.android.gms.common.internal.d(looper, o0Var);
        this.f8659h = looper;
        this.f8664m = new t0(this, looper);
        this.f8665n = bVar;
        this.f8657f = i10;
        if (i10 >= 0) {
            this.f8674w = Integer.valueOf(i11);
        }
        this.f8670s = map;
        this.f8667p = map2;
        this.f8673v = arrayList;
        this.f8676y = new w1(map2);
        for (d.b bVar2 : list) {
            this.f8655d.f(bVar2);
        }
        for (d.c cVar2 : list2) {
            this.f8655d.g(cVar2);
        }
        this.f8669r = cVar;
        this.f8671t = aVar;
    }

    private final void B() {
        this.f8655d.b();
        this.f8656e.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C() {
        this.f8653b.lock();
        try {
            if (D()) {
                B();
            }
        } finally {
            this.f8653b.unlock();
        }
    }

    private final void I(int i10) {
        Integer num = this.f8674w;
        if (num == null) {
            this.f8674w = Integer.valueOf(i10);
        } else if (num.intValue() != i10) {
            String J = J(i10);
            String J2 = J(this.f8674w.intValue());
            StringBuilder sb2 = new StringBuilder(String.valueOf(J).length() + 51 + String.valueOf(J2).length());
            sb2.append("Cannot use sign-in mode: ");
            sb2.append(J);
            sb2.append(". Mode was already set to ");
            sb2.append(J2);
            throw new IllegalStateException(sb2.toString());
        }
        if (this.f8656e == null) {
            boolean z10 = false;
            boolean z11 = false;
            for (a.f fVar : this.f8667p.values()) {
                if (fVar.t()) {
                    z10 = true;
                }
                if (fVar.f()) {
                    z11 = true;
                }
            }
            int intValue = this.f8674w.intValue();
            if (intValue != 1) {
                if (intValue == 2 && z10) {
                    if (this.f8654c) {
                        this.f8656e = new u2(this.f8658g, this.f8653b, this.f8659h, this.f8665n, this.f8667p, this.f8669r, this.f8670s, this.f8671t, this.f8673v, this, true);
                        return;
                    } else {
                        this.f8656e = p2.k(this.f8658g, this, this.f8653b, this.f8659h, this.f8665n, this.f8667p, this.f8669r, this.f8670s, this.f8671t, this.f8673v);
                        return;
                    }
                }
            } else if (!z10) {
                throw new IllegalStateException("SIGN_IN_MODE_REQUIRED cannot be used on a GoogleApiClient that does not contain any authenticated APIs. Use connect() instead.");
            } else if (z11) {
                throw new IllegalStateException("Cannot use SIGN_IN_MODE_REQUIRED with GOOGLE_SIGN_IN_API. Use connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            if (!this.f8654c || z11) {
                this.f8656e = new w0(this.f8658g, this, this.f8653b, this.f8659h, this.f8665n, this.f8667p, this.f8669r, this.f8670s, this.f8671t, this.f8673v, this);
            } else {
                this.f8656e = new u2(this.f8658g, this.f8653b, this.f8659h, this.f8665n, this.f8667p, this.f8669r, this.f8670s, this.f8671t, this.f8673v, this, false);
            }
        }
    }

    private static String J(int i10) {
        return i10 != 1 ? i10 != 2 ? i10 != 3 ? GrsBaseInfo.CountryCodeSource.UNKNOWN : "SIGN_IN_MODE_NONE" : "SIGN_IN_MODE_OPTIONAL" : "SIGN_IN_MODE_REQUIRED";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w() {
        this.f8653b.lock();
        try {
            if (this.f8661j) {
                B();
            }
        } finally {
            this.f8653b.unlock();
        }
    }

    public static int x(Iterable<a.f> iterable, boolean z10) {
        boolean z11 = false;
        boolean z12 = false;
        for (a.f fVar : iterable) {
            if (fVar.t()) {
                z11 = true;
            }
            if (fVar.f()) {
                z12 = true;
            }
        }
        if (z11) {
            return (!z12 || !z10) ? 1 : 2;
        }
        return 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y(com.google.android.gms.common.api.d dVar, n nVar, boolean z10) {
        d6.a.f25137d.a(dVar).e(new s0(this, nVar, z10, dVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean D() {
        if (!this.f8661j) {
            return false;
        }
        this.f8661j = false;
        this.f8664m.removeMessages(2);
        this.f8664m.removeMessages(1);
        i1 i1Var = this.f8666o;
        if (i1Var != null) {
            i1Var.a();
            this.f8666o = null;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Finally extract failed */
    public final boolean E() {
        this.f8653b.lock();
        try {
            Set<v1> set = this.f8675x;
            if (set == null) {
                this.f8653b.unlock();
                return false;
            }
            boolean z10 = !set.isEmpty();
            this.f8653b.unlock();
            return z10;
        } catch (Throwable th2) {
            this.f8653b.unlock();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String F() {
        StringWriter stringWriter = new StringWriter();
        i("", null, new PrintWriter(stringWriter), null);
        return stringWriter.toString();
    }

    @Override // com.google.android.gms.common.api.internal.l1
    public final void a(ConnectionResult connectionResult) {
        if (!this.f8665n.k(this.f8658g, connectionResult.G0())) {
            D();
        }
        if (!this.f8661j) {
            this.f8655d.c(connectionResult);
            this.f8655d.a();
        }
    }

    @Override // com.google.android.gms.common.api.internal.l1
    public final void b(Bundle bundle) {
        while (!this.f8660i.isEmpty()) {
            k(this.f8660i.remove());
        }
        this.f8655d.d(bundle);
    }

    @Override // com.google.android.gms.common.api.internal.l1
    public final void c(int i10, boolean z10) {
        if (i10 == 1 && !z10 && !this.f8661j) {
            this.f8661j = true;
            if (this.f8666o == null && !h6.d.a()) {
                this.f8666o = this.f8665n.w(this.f8658g.getApplicationContext(), new u0(this));
            }
            t0 t0Var = this.f8664m;
            t0Var.sendMessageDelayed(t0Var.obtainMessage(1), this.f8662k);
            t0 t0Var2 = this.f8664m;
            t0Var2.sendMessageDelayed(t0Var2.obtainMessage(2), this.f8663l);
        }
        this.f8676y.c();
        this.f8655d.e(i10);
        this.f8655d.a();
        if (i10 == 2) {
            B();
        }
    }

    @Override // com.google.android.gms.common.api.d
    public final ConnectionResult d() {
        boolean z10 = true;
        i.o(Looper.myLooper() != Looper.getMainLooper(), "blockingConnect must not be called on the UI thread");
        this.f8653b.lock();
        try {
            if (this.f8657f >= 0) {
                if (this.f8674w == null) {
                    z10 = false;
                }
                i.o(z10, "Sign-in mode should have been set explicitly by auto-manage.");
            } else {
                Integer num = this.f8674w;
                if (num == null) {
                    this.f8674w = Integer.valueOf(x(this.f8667p.values(), false));
                } else if (num.intValue() == 2) {
                    throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
                }
            }
            I(this.f8674w.intValue());
            this.f8655d.b();
            return this.f8656e.i();
        } finally {
            this.f8653b.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.d
    public final com.google.android.gms.common.api.e<Status> e() {
        i.o(p(), "GoogleApiClient is not connected yet.");
        i.o(this.f8674w.intValue() != 2, "Cannot use clearDefaultAccountAndReconnect with GOOGLE_SIGN_IN_API");
        n nVar = new n(this);
        if (this.f8667p.containsKey(d6.a.f25134a)) {
            y(this, nVar, false);
        } else {
            AtomicReference atomicReference = new AtomicReference();
            com.google.android.gms.common.api.d e10 = new d.a(this.f8658g).a(d6.a.f25136c).c(new p0(this, atomicReference, nVar)).d(new q0(this, nVar)).i(this.f8664m).e();
            atomicReference.set(e10);
            e10.f();
        }
        return nVar;
    }

    @Override // com.google.android.gms.common.api.d
    public final void f() {
        this.f8653b.lock();
        try {
            boolean z10 = false;
            if (this.f8657f >= 0) {
                if (this.f8674w != null) {
                    z10 = true;
                }
                i.o(z10, "Sign-in mode should have been set explicitly by auto-manage.");
            } else {
                Integer num = this.f8674w;
                if (num == null) {
                    this.f8674w = Integer.valueOf(x(this.f8667p.values(), false));
                } else if (num.intValue() == 2) {
                    throw new IllegalStateException("Cannot call connect() when SignInMode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
                }
            }
            g(this.f8674w.intValue());
        } finally {
            this.f8653b.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.d
    public final void g(int i10) {
        this.f8653b.lock();
        boolean z10 = true;
        if (!(i10 == 3 || i10 == 1 || i10 == 2)) {
            z10 = false;
        }
        try {
            StringBuilder sb2 = new StringBuilder(33);
            sb2.append("Illegal sign-in mode: ");
            sb2.append(i10);
            i.b(z10, sb2.toString());
            I(i10);
            B();
        } finally {
            this.f8653b.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.d
    public final void h() {
        this.f8653b.lock();
        try {
            this.f8676y.a();
            k1 k1Var = this.f8656e;
            if (k1Var != null) {
                k1Var.a();
            }
            this.f8672u.c();
            for (c<?, ?> cVar : this.f8660i) {
                cVar.m(null);
                cVar.c();
            }
            this.f8660i.clear();
            if (this.f8656e != null) {
                D();
                this.f8655d.a();
            }
        } finally {
            this.f8653b.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.d
    public final void i(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append((CharSequence) str).append("mContext=").println(this.f8658g);
        printWriter.append((CharSequence) str).append("mResuming=").print(this.f8661j);
        printWriter.append(" mWorkQueue.size()=").print(this.f8660i.size());
        printWriter.append(" mUnconsumedApiCalls.size()=").println(this.f8676y.f8780a.size());
        k1 k1Var = this.f8656e;
        if (k1Var != null) {
            k1Var.e(str, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // com.google.android.gms.common.api.d
    public final <A extends a.b, R extends h, T extends c<R, A>> T j(T t10) {
        i.b(t10.t() != null, "This task can not be enqueued (it's probably a Batch or malformed)");
        boolean containsKey = this.f8667p.containsKey(t10.t());
        String b10 = t10.s() != null ? t10.s().b() : "the API";
        StringBuilder sb2 = new StringBuilder(String.valueOf(b10).length() + 65);
        sb2.append("GoogleApiClient is not configured to use ");
        sb2.append(b10);
        sb2.append(" required for this call.");
        i.b(containsKey, sb2.toString());
        this.f8653b.lock();
        try {
            k1 k1Var = this.f8656e;
            if (k1Var != null) {
                return (T) k1Var.f(t10);
            }
            this.f8660i.add(t10);
            return t10;
        } finally {
            this.f8653b.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.d
    public final <A extends a.b, T extends c<? extends h, A>> T k(T t10) {
        i.b(t10.t() != null, "This task can not be executed (it's probably a Batch or malformed)");
        boolean containsKey = this.f8667p.containsKey(t10.t());
        String b10 = t10.s() != null ? t10.s().b() : "the API";
        StringBuilder sb2 = new StringBuilder(String.valueOf(b10).length() + 65);
        sb2.append("GoogleApiClient is not configured to use ");
        sb2.append(b10);
        sb2.append(" required for this call.");
        i.b(containsKey, sb2.toString());
        this.f8653b.lock();
        try {
            if (this.f8656e == null) {
                throw new IllegalStateException("GoogleApiClient is not connected yet.");
            } else if (!this.f8661j) {
                return (T) this.f8656e.d(t10);
            } else {
                this.f8660i.add(t10);
                while (!this.f8660i.isEmpty()) {
                    c<?, ?> remove = this.f8660i.remove();
                    this.f8676y.b(remove);
                    remove.x(Status.f8445f);
                }
                return t10;
            }
        } finally {
            this.f8653b.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.d
    public final <C extends a.f> C m(a.c<C> cVar) {
        C c10 = (C) this.f8667p.get(cVar);
        i.l(c10, "Appropriate Api was not requested.");
        return c10;
    }

    @Override // com.google.android.gms.common.api.d
    public final Context n() {
        return this.f8658g;
    }

    @Override // com.google.android.gms.common.api.d
    public final Looper o() {
        return this.f8659h;
    }

    @Override // com.google.android.gms.common.api.d
    public final boolean p() {
        k1 k1Var = this.f8656e;
        return k1Var != null && k1Var.isConnected();
    }

    @Override // com.google.android.gms.common.api.d
    public final boolean q(l lVar) {
        k1 k1Var = this.f8656e;
        return k1Var != null && k1Var.g(lVar);
    }

    @Override // com.google.android.gms.common.api.d
    public final void r() {
        k1 k1Var = this.f8656e;
        if (k1Var != null) {
            k1Var.h();
        }
    }

    @Override // com.google.android.gms.common.api.d
    public final void s() {
        h();
        f();
    }

    @Override // com.google.android.gms.common.api.d
    public final void t(d.c cVar) {
        this.f8655d.g(cVar);
    }

    @Override // com.google.android.gms.common.api.d
    public final void u(d.c cVar) {
        this.f8655d.h(cVar);
    }
}
