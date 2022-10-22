package com.google.android.gms.common.api.internal;

import a7.e;
import android.content.Context;
import android.os.Looper;
import b6.c;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.h;
import com.google.android.gms.common.c;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
/* loaded from: classes.dex */
public final class u2 implements k1 {

    /* renamed from: c  reason: collision with root package name */
    private final Map<a<?>, Boolean> f8742c;

    /* renamed from: d  reason: collision with root package name */
    private final e f8743d;

    /* renamed from: e  reason: collision with root package name */
    private final n0 f8744e;

    /* renamed from: f  reason: collision with root package name */
    private final Lock f8745f;

    /* renamed from: g  reason: collision with root package name */
    private final Looper f8746g;

    /* renamed from: h  reason: collision with root package name */
    private final c f8747h;

    /* renamed from: i  reason: collision with root package name */
    private final Condition f8748i;

    /* renamed from: j  reason: collision with root package name */
    private final b6.c f8749j;

    /* renamed from: k  reason: collision with root package name */
    private final boolean f8750k;

    /* renamed from: l  reason: collision with root package name */
    private final boolean f8751l;

    /* renamed from: n  reason: collision with root package name */
    private boolean f8753n;

    /* renamed from: o  reason: collision with root package name */
    private Map<f2<?>, ConnectionResult> f8754o;

    /* renamed from: p  reason: collision with root package name */
    private Map<f2<?>, ConnectionResult> f8755p;

    /* renamed from: q  reason: collision with root package name */
    private r f8756q;

    /* renamed from: r  reason: collision with root package name */
    private ConnectionResult f8757r;

    /* renamed from: a  reason: collision with root package name */
    private final Map<a.c<?>, t2<?>> f8740a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final Map<a.c<?>, t2<?>> f8741b = new HashMap();

    /* renamed from: m  reason: collision with root package name */
    private final Queue<c<?, ?>> f8752m = new LinkedList();

    public u2(Context context, Lock lock, Looper looper, c cVar, Map<a.c<?>, a.f> map, b6.c cVar2, Map<a<?>, Boolean> map2, a.AbstractC0105a<? extends e, a7.a> aVar, ArrayList<n2> arrayList, n0 n0Var, boolean z10) {
        boolean z11;
        boolean z12;
        boolean z13;
        this.f8745f = lock;
        this.f8746g = looper;
        this.f8748i = lock.newCondition();
        this.f8747h = cVar;
        this.f8744e = n0Var;
        this.f8742c = map2;
        this.f8749j = cVar2;
        this.f8750k = z10;
        HashMap hashMap = new HashMap();
        for (a<?> aVar2 : map2.keySet()) {
            hashMap.put(aVar2.a(), aVar2);
        }
        HashMap hashMap2 = new HashMap();
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            n2 n2Var = arrayList.get(i10);
            i10++;
            n2 n2Var2 = n2Var;
            hashMap2.put(n2Var2.f8681a, n2Var2);
        }
        boolean z14 = true;
        boolean z15 = false;
        boolean z16 = false;
        for (Map.Entry<a.c<?>, a.f> entry : map.entrySet()) {
            a aVar3 = (a) hashMap.get(entry.getKey());
            a.f value = entry.getValue();
            if (value.o()) {
                z12 = z14;
                if (!this.f8742c.get(aVar3).booleanValue()) {
                    z13 = true;
                    z11 = true;
                } else {
                    z11 = z16;
                    z13 = true;
                }
            } else {
                z13 = z15;
                z11 = z16;
                z12 = false;
            }
            t2<?> t2Var = new t2<>(context, aVar3, looper, value, (n2) hashMap2.get(aVar3), cVar2, aVar);
            this.f8740a.put(entry.getKey(), t2Var);
            if (value.t()) {
                this.f8741b.put(entry.getKey(), t2Var);
            }
            z15 = z13;
            z14 = z12;
            z16 = z11;
        }
        this.f8751l = z15 && !z14 && !z16;
        this.f8743d = e.o();
    }

    private final ConnectionResult k(a.c<?> cVar) {
        this.f8745f.lock();
        try {
            t2<?> t2Var = this.f8740a.get(cVar);
            Map<f2<?>, ConnectionResult> map = this.f8754o;
            if (map != null && t2Var != null) {
                return map.get(t2Var.o());
            }
            this.f8745f.unlock();
            return null;
        } finally {
            this.f8745f.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean o(t2<?> t2Var, ConnectionResult connectionResult) {
        return !connectionResult.K0() && !connectionResult.J0() && this.f8742c.get(t2Var.g()).booleanValue() && t2Var.p().o() && this.f8747h.m(connectionResult.G0());
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001f A[Catch: all -> 0x0044, TryCatch #0 {all -> 0x0044, blocks: (B:3:0x0005, B:5:0x000a, B:8:0x000f, B:9:0x0019, B:11:0x001f, B:13:0x002b), top: B:24:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean r() {
        this.f8745f.lock();
        try {
            if (this.f8753n && this.f8750k) {
                for (a.c<?> cVar : this.f8741b.keySet()) {
                    ConnectionResult k10 = k(cVar);
                    if (k10 == null || !k10.K0()) {
                        return false;
                    }
                    while (r0.hasNext()) {
                    }
                }
                this.f8745f.unlock();
                return true;
            }
            return false;
        } finally {
            this.f8745f.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s() {
        if (this.f8749j == null) {
            this.f8744e.f8668q = Collections.emptySet();
            return;
        }
        HashSet hashSet = new HashSet(this.f8749j.j());
        Map<a<?>, c.b> g10 = this.f8749j.g();
        for (a<?> aVar : g10.keySet()) {
            ConnectionResult c10 = c(aVar);
            if (c10 != null && c10.K0()) {
                hashSet.addAll(g10.get(aVar).f5059a);
            }
        }
        this.f8744e.f8668q = hashSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t() {
        while (!this.f8752m.isEmpty()) {
            d(this.f8752m.remove());
        }
        this.f8744e.b(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ConnectionResult u() {
        int i10 = 0;
        ConnectionResult connectionResult = null;
        ConnectionResult connectionResult2 = null;
        int i11 = 0;
        for (t2<?> t2Var : this.f8740a.values()) {
            a<?> g10 = t2Var.g();
            ConnectionResult connectionResult3 = this.f8754o.get(t2Var.o());
            if (!connectionResult3.K0() && (!this.f8742c.get(g10).booleanValue() || connectionResult3.J0() || this.f8747h.m(connectionResult3.G0()))) {
                if (connectionResult3.G0() != 4 || !this.f8750k) {
                    int b10 = g10.c().b();
                    if (connectionResult == null || i10 > b10) {
                        connectionResult = connectionResult3;
                        i10 = b10;
                    }
                } else {
                    int b11 = g10.c().b();
                    if (connectionResult2 == null || i11 > b11) {
                        connectionResult2 = connectionResult3;
                        i11 = b11;
                    }
                }
            }
        }
        return (connectionResult == null || connectionResult2 == null || i10 <= i11) ? connectionResult : connectionResult2;
    }

    private final <T extends c<? extends h, ? extends a.b>> boolean w(T t10) {
        a.c<?> t11 = t10.t();
        ConnectionResult k10 = k(t11);
        if (k10 == null || k10.G0() != 4) {
            return false;
        }
        t10.x(new Status(4, null, this.f8743d.c(this.f8740a.get(t11).o(), System.identityHashCode(this.f8744e))));
        return true;
    }

    @Override // com.google.android.gms.common.api.internal.k1
    public final void a() {
        this.f8745f.lock();
        try {
            this.f8753n = false;
            this.f8754o = null;
            this.f8755p = null;
            r rVar = this.f8756q;
            if (rVar != null) {
                rVar.b();
                this.f8756q = null;
            }
            this.f8757r = null;
            while (!this.f8752m.isEmpty()) {
                c<?, ?> remove = this.f8752m.remove();
                remove.m(null);
                remove.c();
            }
            this.f8748i.signalAll();
        } finally {
            this.f8745f.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.k1
    public final void b() {
        this.f8745f.lock();
        try {
            if (!this.f8753n) {
                this.f8753n = true;
                this.f8754o = null;
                this.f8755p = null;
                this.f8756q = null;
                this.f8757r = null;
                this.f8743d.A();
                this.f8743d.g(this.f8740a.values()).c(new i6.a(this.f8746g), new w2(this));
            }
        } finally {
            this.f8745f.unlock();
        }
    }

    public final ConnectionResult c(a<?> aVar) {
        return k(aVar.a());
    }

    @Override // com.google.android.gms.common.api.internal.k1
    public final <A extends a.b, T extends c<? extends h, A>> T d(T t10) {
        a.c<A> t11 = t10.t();
        if (this.f8750k && w(t10)) {
            return t10;
        }
        this.f8744e.f8676y.b(t10);
        return (T) this.f8740a.get(t11).f(t10);
    }

    @Override // com.google.android.gms.common.api.internal.k1
    public final void e(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    @Override // com.google.android.gms.common.api.internal.k1
    public final <A extends a.b, R extends h, T extends c<R, A>> T f(T t10) {
        if (this.f8750k && w(t10)) {
            return t10;
        }
        if (!isConnected()) {
            this.f8752m.add(t10);
            return t10;
        }
        this.f8744e.f8676y.b(t10);
        return (T) this.f8740a.get(t10.t()).b(t10);
    }

    /* JADX WARN: Finally extract failed */
    @Override // com.google.android.gms.common.api.internal.k1
    public final boolean g(l lVar) {
        this.f8745f.lock();
        try {
            if (!this.f8753n || r()) {
                this.f8745f.unlock();
                return false;
            }
            this.f8743d.A();
            this.f8756q = new r(this, lVar);
            this.f8743d.g(this.f8741b.values()).c(new i6.a(this.f8746g), this.f8756q);
            this.f8745f.unlock();
            return true;
        } catch (Throwable th2) {
            this.f8745f.unlock();
            throw th2;
        }
    }

    @Override // com.google.android.gms.common.api.internal.k1
    public final void h() {
        this.f8745f.lock();
        try {
            this.f8743d.a();
            r rVar = this.f8756q;
            if (rVar != null) {
                rVar.b();
                this.f8756q = null;
            }
            if (this.f8755p == null) {
                this.f8755p = new androidx.collection.a(this.f8741b.size());
            }
            ConnectionResult connectionResult = new ConnectionResult(4);
            for (t2<?> t2Var : this.f8741b.values()) {
                this.f8755p.put(t2Var.o(), connectionResult);
            }
            Map<f2<?>, ConnectionResult> map = this.f8754o;
            if (map != null) {
                map.putAll(this.f8755p);
            }
        } finally {
            this.f8745f.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.k1
    public final ConnectionResult i() {
        b();
        while (j()) {
            try {
                this.f8748i.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                return new ConnectionResult(15, null);
            }
        }
        if (isConnected()) {
            return ConnectionResult.f8431e;
        }
        ConnectionResult connectionResult = this.f8757r;
        return connectionResult != null ? connectionResult : new ConnectionResult(13, null);
    }

    @Override // com.google.android.gms.common.api.internal.k1
    public final boolean isConnected() {
        boolean z10;
        this.f8745f.lock();
        try {
            if (this.f8754o != null) {
                if (this.f8757r == null) {
                    z10 = true;
                    return z10;
                }
            }
            z10 = false;
            return z10;
        } finally {
            this.f8745f.unlock();
        }
    }

    public final boolean j() {
        boolean z10;
        this.f8745f.lock();
        try {
            if (this.f8754o == null) {
                if (this.f8753n) {
                    z10 = true;
                    return z10;
                }
            }
            z10 = false;
            return z10;
        } finally {
            this.f8745f.unlock();
        }
    }
}
