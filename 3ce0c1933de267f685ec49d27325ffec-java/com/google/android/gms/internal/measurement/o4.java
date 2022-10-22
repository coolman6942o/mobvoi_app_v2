package com.google.android.gms.internal.measurement;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import b6.i;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.b;
import g6.a;
/* loaded from: classes.dex */
public final class o4 implements ServiceConnection, b.a, b.AbstractC0108b {

    /* renamed from: a  reason: collision with root package name */
    private volatile boolean f9552a;

    /* renamed from: b  reason: collision with root package name */
    private volatile y0 f9553b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ a4 f9554c;

    /* JADX INFO: Access modifiers changed from: protected */
    public o4(a4 a4Var) {
        this.f9554c = a4Var;
    }

    public final void b(Intent intent) {
        o4 o4Var;
        this.f9554c.e();
        Context context = this.f9554c.getContext();
        a b10 = a.b();
        synchronized (this) {
            if (this.f9552a) {
                this.f9554c.c().R().a("Connection attempt already in progress");
                return;
            }
            this.f9554c.c().R().a("Using local app measurement service");
            this.f9552a = true;
            o4Var = this.f9554c.f9159c;
            b10.a(context, intent, o4Var, 129);
        }
    }

    public final void c() {
        this.f9554c.e();
        Context context = this.f9554c.getContext();
        synchronized (this) {
            if (this.f9552a) {
                this.f9554c.c().R().a("Connection attempt already in progress");
            } else if (this.f9553b != null) {
                this.f9554c.c().R().a("Already awaiting connection attempt");
            } else {
                this.f9553b = new y0(context, Looper.getMainLooper(), this, this);
                this.f9554c.c().R().a("Connecting to remote service");
                this.f9552a = true;
                this.f9553b.x();
            }
        }
    }

    @Override // com.google.android.gms.common.internal.b.a
    public final void onConnected(Bundle bundle) {
        i.f("MeasurementServiceConnection.onConnected");
        synchronized (this) {
            try {
                this.f9553b = null;
                this.f9554c.d().J(new r4(this, this.f9553b.G()));
            } catch (DeadObjectException | IllegalStateException unused) {
                this.f9553b = null;
                this.f9552a = false;
            }
        }
    }

    @Override // com.google.android.gms.common.internal.b.AbstractC0108b
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        i.f("MeasurementServiceConnection.onConnectionFailed");
        z0 v02 = this.f9554c.f9815a.v0();
        if (v02 != null) {
            v02.N().d("Service connection failed", connectionResult);
        }
        synchronized (this) {
            this.f9552a = false;
            this.f9553b = null;
        }
        this.f9554c.d().J(new t4(this));
    }

    @Override // com.google.android.gms.common.internal.b.a
    public final void onConnectionSuspended(int i10) {
        i.f("MeasurementServiceConnection.onConnectionSuspended");
        this.f9554c.c().Q().a("Service connection suspended");
        this.f9554c.d().J(new s4(this));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        o4 o4Var;
        i.f("MeasurementServiceConnection.onServiceConnected");
        synchronized (this) {
            if (iBinder == null) {
                this.f9552a = false;
                this.f9554c.c().K().a("Service connected with null binder");
                return;
            }
            r0 r0Var = null;
            try {
                String interfaceDescriptor = iBinder.getInterfaceDescriptor();
                if ("com.google.android.gms.measurement.internal.IMeasurementService".equals(interfaceDescriptor)) {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                    r0Var = queryLocalInterface instanceof r0 ? (r0) queryLocalInterface : new t0(iBinder);
                    this.f9554c.c().R().a("Bound to IMeasurementService interface");
                } else {
                    this.f9554c.c().K().d("Got binder with a wrong descriptor", interfaceDescriptor);
                }
            } catch (RemoteException unused) {
                this.f9554c.c().K().a("Service connect failed to get IMeasurementService");
            }
            if (r0Var == null) {
                this.f9552a = false;
                try {
                    a b10 = a.b();
                    Context context = this.f9554c.getContext();
                    o4Var = this.f9554c.f9159c;
                    b10.c(context, o4Var);
                } catch (IllegalArgumentException unused2) {
                }
            } else {
                this.f9554c.d().J(new p4(this, r0Var));
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        i.f("MeasurementServiceConnection.onServiceDisconnected");
        this.f9554c.c().Q().a("Service disconnected");
        this.f9554c.d().J(new q4(this, componentName));
    }
}
