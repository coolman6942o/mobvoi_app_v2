package com.google.android.gms.common.api.internal;

import a7.e;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.h;
import com.google.android.gms.common.c;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
/* loaded from: classes.dex */
public final class w0 implements k1, o2 {

    /* renamed from: a  reason: collision with root package name */
    private final Lock f8763a;

    /* renamed from: b  reason: collision with root package name */
    private final Condition f8764b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f8765c;

    /* renamed from: d  reason: collision with root package name */
    private final c f8766d;

    /* renamed from: e  reason: collision with root package name */
    private final y0 f8767e;

    /* renamed from: f  reason: collision with root package name */
    final Map<a.c<?>, a.f> f8768f;

    /* renamed from: h  reason: collision with root package name */
    private final b6.c f8770h;

    /* renamed from: i  reason: collision with root package name */
    private final Map<a<?>, Boolean> f8771i;

    /* renamed from: j  reason: collision with root package name */
    private final a.AbstractC0105a<? extends e, a7.a> f8772j;

    /* renamed from: k  reason: collision with root package name */
    private volatile v0 f8773k;

    /* renamed from: m  reason: collision with root package name */
    int f8775m;

    /* renamed from: n  reason: collision with root package name */
    final n0 f8776n;

    /* renamed from: o  reason: collision with root package name */
    final l1 f8777o;

    /* renamed from: g  reason: collision with root package name */
    final Map<a.c<?>, ConnectionResult> f8769g = new HashMap();

    /* renamed from: l  reason: collision with root package name */
    private ConnectionResult f8774l = null;

    public w0(Context context, n0 n0Var, Lock lock, Looper looper, c cVar, Map<a.c<?>, a.f> map, b6.c cVar2, Map<a<?>, Boolean> map2, a.AbstractC0105a<? extends e, a7.a> aVar, ArrayList<n2> arrayList, l1 l1Var) {
        this.f8765c = context;
        this.f8763a = lock;
        this.f8766d = cVar;
        this.f8768f = map;
        this.f8770h = cVar2;
        this.f8771i = map2;
        this.f8772j = aVar;
        this.f8776n = n0Var;
        this.f8777o = l1Var;
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            n2 n2Var = arrayList.get(i10);
            i10++;
            n2Var.a(this);
        }
        this.f8767e = new y0(this, looper);
        this.f8764b = lock.newCondition();
        this.f8773k = new m0(this);
    }

    @Override // com.google.android.gms.common.api.internal.k1
    public final void a() {
        if (this.f8773k.a()) {
            this.f8769g.clear();
        }
    }

    @Override // com.google.android.gms.common.api.internal.k1
    public final void b() {
        this.f8773k.b();
    }

    @Override // com.google.android.gms.common.api.internal.o2
    public final void c(ConnectionResult connectionResult, a<?> aVar, boolean z10) {
        this.f8763a.lock();
        try {
            this.f8773k.c(connectionResult, aVar, z10);
        } finally {
            this.f8763a.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.k1
    public final <A extends a.b, T extends c<? extends h, A>> T d(T t10) {
        t10.q();
        return (T) this.f8773k.d(t10);
    }

    @Override // com.google.android.gms.common.api.internal.k1
    public final void e(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String concat = String.valueOf(str).concat("  ");
        printWriter.append((CharSequence) str).append("mState=").println(this.f8773k);
        for (a<?> aVar : this.f8771i.keySet()) {
            printWriter.append((CharSequence) str).append((CharSequence) aVar.b()).println(":");
            this.f8768f.get(aVar.a()).e(concat, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // com.google.android.gms.common.api.internal.k1
    public final <A extends a.b, R extends h, T extends c<R, A>> T f(T t10) {
        t10.q();
        return (T) this.f8773k.f(t10);
    }

    @Override // com.google.android.gms.common.api.internal.k1
    public final boolean g(l lVar) {
        return false;
    }

    @Override // com.google.android.gms.common.api.internal.k1
    public final void h() {
    }

    @Override // com.google.android.gms.common.api.internal.k1
    public final ConnectionResult i() {
        b();
        while (j()) {
            try {
                this.f8764b.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                return new ConnectionResult(15, null);
            }
        }
        if (isConnected()) {
            return ConnectionResult.f8431e;
        }
        ConnectionResult connectionResult = this.f8774l;
        return connectionResult != null ? connectionResult : new ConnectionResult(13, null);
    }

    @Override // com.google.android.gms.common.api.internal.k1
    public final boolean isConnected() {
        return this.f8773k instanceof y;
    }

    public final boolean j() {
        return this.f8773k instanceof b0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void l(x0 x0Var) {
        this.f8767e.sendMessage(this.f8767e.obtainMessage(1, x0Var));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void m() {
        this.f8763a.lock();
        try {
            this.f8773k = new b0(this, this.f8770h, this.f8771i, this.f8766d, this.f8772j, this.f8763a, this.f8765c);
            this.f8773k.e();
            this.f8764b.signalAll();
        } finally {
            this.f8763a.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void o(RuntimeException runtimeException) {
        this.f8767e.sendMessage(this.f8767e.obtainMessage(2, runtimeException));
    }

    @Override // com.google.android.gms.common.api.d.b
    public final void onConnected(Bundle bundle) {
        this.f8763a.lock();
        try {
            this.f8773k.onConnected(bundle);
        } finally {
            this.f8763a.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.d.b
    public final void onConnectionSuspended(int i10) {
        this.f8763a.lock();
        try {
            this.f8773k.onConnectionSuspended(i10);
        } finally {
            this.f8763a.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void p() {
        this.f8763a.lock();
        try {
            this.f8776n.D();
            this.f8773k = new y(this);
            this.f8773k.e();
            this.f8764b.signalAll();
        } finally {
            this.f8763a.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void q(ConnectionResult connectionResult) {
        this.f8763a.lock();
        try {
            this.f8774l = connectionResult;
            this.f8773k = new m0(this);
            this.f8773k.e();
            this.f8764b.signalAll();
        } finally {
            this.f8763a.unlock();
        }
    }
}
