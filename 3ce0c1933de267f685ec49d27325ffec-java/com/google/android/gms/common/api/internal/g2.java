package com.google.android.gms.common.api.internal;

import android.util.Log;
import android.util.SparseArray;
import b6.i;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.d;
import java.io.FileDescriptor;
import java.io.PrintWriter;
/* loaded from: classes.dex */
public class g2 extends i2 {

    /* renamed from: f  reason: collision with root package name */
    private final SparseArray<a> f8611f = new SparseArray<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements d.c {

        /* renamed from: a  reason: collision with root package name */
        public final int f8612a;

        /* renamed from: b  reason: collision with root package name */
        public final d f8613b;

        /* renamed from: c  reason: collision with root package name */
        public final d.c f8614c;

        public a(int i10, d dVar, d.c cVar) {
            this.f8612a = i10;
            this.f8613b = dVar;
            this.f8614c = cVar;
            dVar.t(this);
        }

        @Override // com.google.android.gms.common.api.d.c
        public final void onConnectionFailed(ConnectionResult connectionResult) {
            String valueOf = String.valueOf(connectionResult);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 27);
            sb2.append("beginFailureResolution for ");
            sb2.append(valueOf);
            Log.d("AutoManageHelper", sb2.toString());
            g2.this.n(connectionResult, this.f8612a);
        }
    }

    private g2(h hVar) {
        super(hVar);
        this.f8504a.g("AutoManageHelper", this);
    }

    public static g2 q(g gVar) {
        h d10 = LifecycleCallback.d(gVar);
        g2 g2Var = (g2) d10.t("AutoManageHelper", g2.class);
        return g2Var != null ? g2Var : new g2(d10);
    }

    private final a t(int i10) {
        if (this.f8611f.size() <= i10) {
            return null;
        }
        SparseArray<a> sparseArray = this.f8611f;
        return sparseArray.get(sparseArray.keyAt(i10));
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        for (int i10 = 0; i10 < this.f8611f.size(); i10++) {
            a t10 = t(i10);
            if (t10 != null) {
                printWriter.append((CharSequence) str).append("GoogleApiClient #").print(t10.f8612a);
                printWriter.println(":");
                t10.f8613b.i(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.i2, com.google.android.gms.common.api.internal.LifecycleCallback
    public void j() {
        super.j();
        boolean z10 = this.f8633b;
        String valueOf = String.valueOf(this.f8611f);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 14);
        sb2.append("onStart ");
        sb2.append(z10);
        sb2.append(" ");
        sb2.append(valueOf);
        Log.d("AutoManageHelper", sb2.toString());
        if (this.f8634c.get() == null) {
            for (int i10 = 0; i10 < this.f8611f.size(); i10++) {
                a t10 = t(i10);
                if (t10 != null) {
                    t10.f8613b.f();
                }
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.i2, com.google.android.gms.common.api.internal.LifecycleCallback
    public void k() {
        super.k();
        for (int i10 = 0; i10 < this.f8611f.size(); i10++) {
            a t10 = t(i10);
            if (t10 != null) {
                t10.f8613b.h();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.i2
    public final void m(ConnectionResult connectionResult, int i10) {
        Log.w("AutoManageHelper", "Unresolved error while connecting client. Stopping auto-manage.");
        if (i10 < 0) {
            Log.wtf("AutoManageHelper", "AutoManageLifecycleHelper received onErrorResolutionFailed callback but no failing client ID is set", new Exception());
            return;
        }
        a aVar = this.f8611f.get(i10);
        if (aVar != null) {
            r(i10);
            d.c cVar = aVar.f8614c;
            if (cVar != null) {
                cVar.onConnectionFailed(connectionResult);
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.i2
    protected final void o() {
        for (int i10 = 0; i10 < this.f8611f.size(); i10++) {
            a t10 = t(i10);
            if (t10 != null) {
                t10.f8613b.f();
            }
        }
    }

    public final void r(int i10) {
        a aVar = this.f8611f.get(i10);
        this.f8611f.remove(i10);
        if (aVar != null) {
            aVar.f8613b.u(aVar);
            aVar.f8613b.h();
        }
    }

    public final void s(int i10, d dVar, d.c cVar) {
        i.l(dVar, "GoogleApiClient instance cannot be null");
        boolean z10 = this.f8611f.indexOfKey(i10) < 0;
        StringBuilder sb2 = new StringBuilder(54);
        sb2.append("Already managing a GoogleApiClient with id ");
        sb2.append(i10);
        i.o(z10, sb2.toString());
        j2 j2Var = this.f8634c.get();
        boolean z11 = this.f8633b;
        String valueOf = String.valueOf(j2Var);
        StringBuilder sb3 = new StringBuilder(valueOf.length() + 49);
        sb3.append("starting AutoManage for client ");
        sb3.append(i10);
        sb3.append(" ");
        sb3.append(z11);
        sb3.append(" ");
        sb3.append(valueOf);
        Log.d("AutoManageHelper", sb3.toString());
        this.f8611f.put(i10, new a(i10, dVar, cVar));
        if (this.f8633b && j2Var == null) {
            String valueOf2 = String.valueOf(dVar);
            StringBuilder sb4 = new StringBuilder(valueOf2.length() + 11);
            sb4.append("connecting ");
            sb4.append(valueOf2);
            Log.d("AutoManageHelper", sb4.toString());
            dVar.f();
        }
    }
}
