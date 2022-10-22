package com.google.android.gms.common.api.internal;

import a7.e;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import b6.i;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.h;
import com.google.android.gms.common.c;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.locks.Lock;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class p2 implements k1 {

    /* renamed from: a  reason: collision with root package name */
    private final Context f8692a;

    /* renamed from: b  reason: collision with root package name */
    private final n0 f8693b;

    /* renamed from: c  reason: collision with root package name */
    private final Looper f8694c;

    /* renamed from: d  reason: collision with root package name */
    private final w0 f8695d;

    /* renamed from: e  reason: collision with root package name */
    private final w0 f8696e;

    /* renamed from: f  reason: collision with root package name */
    private final Map<a.c<?>, w0> f8697f;

    /* renamed from: h  reason: collision with root package name */
    private final a.f f8699h;

    /* renamed from: i  reason: collision with root package name */
    private Bundle f8700i;

    /* renamed from: m  reason: collision with root package name */
    private final Lock f8704m;

    /* renamed from: g  reason: collision with root package name */
    private final Set<l> f8698g = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: j  reason: collision with root package name */
    private ConnectionResult f8701j = null;

    /* renamed from: k  reason: collision with root package name */
    private ConnectionResult f8702k = null;

    /* renamed from: l  reason: collision with root package name */
    private boolean f8703l = false;

    /* renamed from: n  reason: collision with root package name */
    private int f8705n = 0;

    private p2(Context context, n0 n0Var, Lock lock, Looper looper, c cVar, Map<a.c<?>, a.f> map, Map<a.c<?>, a.f> map2, b6.c cVar2, a.AbstractC0105a<? extends e, a7.a> aVar, a.f fVar, ArrayList<n2> arrayList, ArrayList<n2> arrayList2, Map<a<?>, Boolean> map3, Map<a<?>, Boolean> map4) {
        this.f8692a = context;
        this.f8693b = n0Var;
        this.f8704m = lock;
        this.f8694c = looper;
        this.f8699h = fVar;
        this.f8695d = new w0(context, n0Var, lock, looper, cVar, map2, null, map4, null, arrayList2, new r2(this, null));
        this.f8696e = new w0(context, n0Var, lock, looper, cVar, map, cVar2, map3, aVar, arrayList, new s2(this, null));
        androidx.collection.a aVar2 = new androidx.collection.a();
        for (a.c<?> cVar3 : map2.keySet()) {
            aVar2.put(cVar3, this.f8695d);
        }
        for (a.c<?> cVar4 : map.keySet()) {
            aVar2.put(cVar4, this.f8696e);
        }
        this.f8697f = Collections.unmodifiableMap(aVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B() {
        ConnectionResult connectionResult;
        if (w(this.f8701j)) {
            if (w(this.f8702k) || D()) {
                int i10 = this.f8705n;
                if (i10 != 1) {
                    if (i10 != 2) {
                        Log.wtf("CompositeGAC", "Attempted to call success callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new AssertionError());
                        this.f8705n = 0;
                        return;
                    }
                    this.f8693b.b(this.f8700i);
                }
                C();
                this.f8705n = 0;
                return;
            }
            ConnectionResult connectionResult2 = this.f8702k;
            if (connectionResult2 == null) {
                return;
            }
            if (this.f8705n == 1) {
                C();
                return;
            }
            o(connectionResult2);
            this.f8695d.a();
        } else if (this.f8701j == null || !w(this.f8702k)) {
            ConnectionResult connectionResult3 = this.f8701j;
            if (connectionResult3 != null && (connectionResult = this.f8702k) != null) {
                if (this.f8696e.f8775m < this.f8695d.f8775m) {
                    connectionResult3 = connectionResult;
                }
                o(connectionResult3);
            }
        } else {
            this.f8696e.a();
            o(this.f8701j);
        }
    }

    private final void C() {
        for (l lVar : this.f8698g) {
            lVar.onComplete();
        }
        this.f8698g.clear();
    }

    private final boolean D() {
        ConnectionResult connectionResult = this.f8702k;
        return connectionResult != null && connectionResult.G0() == 4;
    }

    public static p2 k(Context context, n0 n0Var, Lock lock, Looper looper, c cVar, Map<a.c<?>, a.f> map, b6.c cVar2, Map<a<?>, Boolean> map2, a.AbstractC0105a<? extends e, a7.a> aVar, ArrayList<n2> arrayList) {
        androidx.collection.a aVar2 = new androidx.collection.a();
        androidx.collection.a aVar3 = new androidx.collection.a();
        a.f fVar = null;
        for (Map.Entry<a.c<?>, a.f> entry : map.entrySet()) {
            a.f value = entry.getValue();
            if (value.f()) {
                fVar = value;
            }
            if (value.t()) {
                aVar2.put(entry.getKey(), value);
            } else {
                aVar3.put(entry.getKey(), value);
            }
        }
        i.o(!aVar2.isEmpty(), "CompositeGoogleApiClient should not be used without any APIs that require sign-in.");
        androidx.collection.a aVar4 = new androidx.collection.a();
        androidx.collection.a aVar5 = new androidx.collection.a();
        for (a<?> aVar6 : map2.keySet()) {
            a.c<?> a10 = aVar6.a();
            if (aVar2.containsKey(a10)) {
                aVar4.put(aVar6, map2.get(aVar6));
            } else if (aVar3.containsKey(a10)) {
                aVar5.put(aVar6, map2.get(aVar6));
            } else {
                throw new IllegalStateException("Each API in the isOptionalMap must have a corresponding client in the clients map.");
            }
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            n2 n2Var = arrayList.get(i10);
            i10++;
            n2 n2Var2 = n2Var;
            if (aVar4.containsKey(n2Var2.f8681a)) {
                arrayList2.add(n2Var2);
            } else if (aVar5.containsKey(n2Var2.f8681a)) {
                arrayList3.add(n2Var2);
            } else {
                throw new IllegalStateException("Each ClientCallbacks must have a corresponding API in the isOptionalMap");
            }
        }
        return new p2(context, n0Var, lock, looper, cVar, aVar2, aVar3, cVar2, aVar, fVar, arrayList2, arrayList3, aVar4, aVar5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(int i10, boolean z10) {
        this.f8693b.c(i10, z10);
        this.f8702k = null;
        this.f8701j = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(Bundle bundle) {
        Bundle bundle2 = this.f8700i;
        if (bundle2 == null) {
            this.f8700i = bundle;
        } else if (bundle != null) {
            bundle2.putAll(bundle);
        }
    }

    private final void o(ConnectionResult connectionResult) {
        int i10 = this.f8705n;
        if (i10 != 1) {
            if (i10 != 2) {
                Log.wtf("CompositeGAC", "Attempted to call failure callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
                this.f8705n = 0;
            }
            this.f8693b.a(connectionResult);
        }
        C();
        this.f8705n = 0;
    }

    private final boolean r(c<? extends h, ? extends a.b> cVar) {
        a.c<? extends a.b> t10 = cVar.t();
        i.b(this.f8697f.containsKey(t10), "GoogleApiClient is not configured to use the API required for this call.");
        return this.f8697f.get(t10).equals(this.f8696e);
    }

    private final PendingIntent t() {
        if (this.f8699h == null) {
            return null;
        }
        return PendingIntent.getActivity(this.f8692a, System.identityHashCode(this.f8693b), this.f8699h.s(), 134217728);
    }

    private static boolean w(ConnectionResult connectionResult) {
        return connectionResult != null && connectionResult.K0();
    }

    @Override // com.google.android.gms.common.api.internal.k1
    public final void a() {
        this.f8702k = null;
        this.f8701j = null;
        this.f8705n = 0;
        this.f8695d.a();
        this.f8696e.a();
        C();
    }

    @Override // com.google.android.gms.common.api.internal.k1
    public final void b() {
        this.f8705n = 2;
        this.f8703l = false;
        this.f8702k = null;
        this.f8701j = null;
        this.f8695d.b();
        this.f8696e.b();
    }

    public final boolean c() {
        this.f8704m.lock();
        try {
            return this.f8705n == 2;
        } finally {
            this.f8704m.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.k1
    public final <A extends a.b, T extends c<? extends h, A>> T d(T t10) {
        if (!r(t10)) {
            return (T) this.f8695d.d(t10);
        }
        if (!D()) {
            return (T) this.f8696e.d(t10);
        }
        t10.x(new Status(4, null, t()));
        return t10;
    }

    @Override // com.google.android.gms.common.api.internal.k1
    public final void e(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append((CharSequence) str).append("authClient").println(":");
        this.f8696e.e(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
        printWriter.append((CharSequence) str).append("anonClient").println(":");
        this.f8695d.e(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
    }

    @Override // com.google.android.gms.common.api.internal.k1
    public final <A extends a.b, R extends h, T extends c<R, A>> T f(T t10) {
        if (!r(t10)) {
            return (T) this.f8695d.f(t10);
        }
        if (!D()) {
            return (T) this.f8696e.f(t10);
        }
        t10.x(new Status(4, null, t()));
        return t10;
    }

    @Override // com.google.android.gms.common.api.internal.k1
    public final boolean g(l lVar) {
        this.f8704m.lock();
        try {
            if ((c() || isConnected()) && !this.f8696e.isConnected()) {
                this.f8698g.add(lVar);
                if (this.f8705n == 0) {
                    this.f8705n = 1;
                }
                this.f8702k = null;
                this.f8696e.b();
                return true;
            }
            this.f8704m.unlock();
            return false;
        } finally {
            this.f8704m.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.k1
    public final void h() {
        this.f8704m.lock();
        try {
            boolean c10 = c();
            this.f8696e.a();
            this.f8702k = new ConnectionResult(4);
            if (c10) {
                new q6.i(this.f8694c).post(new q2(this));
            } else {
                C();
            }
        } finally {
            this.f8704m.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.k1
    public final ConnectionResult i() {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001e, code lost:
        if (r2.f8705n == 1) goto L12;
     */
    @Override // com.google.android.gms.common.api.internal.k1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean isConnected() {
        this.f8704m.lock();
        try {
            boolean z10 = true;
            if (this.f8695d.isConnected()) {
                if (!this.f8696e.isConnected() && !D()) {
                }
                return z10;
            }
            z10 = false;
            return z10;
        } finally {
            this.f8704m.unlock();
        }
    }
}
