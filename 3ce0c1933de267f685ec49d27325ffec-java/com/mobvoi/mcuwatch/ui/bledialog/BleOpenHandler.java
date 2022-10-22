package com.mobvoi.mcuwatch.ui.bledialog;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.widget.Toast;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.d;
import androidx.lifecycle.e;
import androidx.lifecycle.p;
import fj.j;
import jc.a;
import sh.k;
/* loaded from: classes2.dex */
public class BleOpenHandler implements e {

    /* renamed from: g  reason: collision with root package name */
    private static final IntentFilter f19456g = new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED");

    /* renamed from: a  reason: collision with root package name */
    private jc.a f19457a;

    /* renamed from: c  reason: collision with root package name */
    private final Context f19459c;

    /* renamed from: d  reason: collision with root package name */
    private c f19460d;

    /* renamed from: e  reason: collision with root package name */
    private Lifecycle f19461e;

    /* renamed from: b  reason: collision with root package name */
    private boolean f19458b = false;

    /* renamed from: f  reason: collision with root package name */
    private final BroadcastReceiver f19462f = new a();

    /* loaded from: classes2.dex */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getIntExtra("android.bluetooth.adapter.extra.STATE", 10) == 12) {
                BleOpenHandler.this.l();
                if (BleOpenHandler.this.f19460d != null) {
                    BleOpenHandler.this.f19460d.A();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements a.AbstractC0354a {
        b() {
        }

        @Override // jc.a.AbstractC0354a
        public void a() {
            BleOpenHandler.this.f19457a.dismiss();
            if (j.e(BleOpenHandler.this.f19459c)) {
                BluetoothAdapter.getDefaultAdapter().enable();
            } else {
                Toast.makeText(BleOpenHandler.this.f19459c, k.Z1, 0).show();
            }
        }

        @Override // jc.a.AbstractC0354a
        public void onCancel() {
        }
    }

    /* loaded from: classes2.dex */
    public interface c {
        void A();
    }

    public BleOpenHandler(Context context, c cVar, Lifecycle lifecycle) {
        this.f19459c = context;
        this.f19460d = cVar;
        this.f19461e = lifecycle;
        lifecycle.a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        jc.a aVar;
        Context context = this.f19459c;
        if ((!(context instanceof Activity) || !((Activity) context).isDestroyed()) && (aVar = this.f19457a) != null && aVar.isShowing()) {
            this.f19457a.dismiss();
        }
    }

    private void m() {
        if (!this.f19458b) {
            this.f19459c.registerReceiver(this.f19462f, f19456g);
            this.f19458b = true;
        }
    }

    @Override // androidx.lifecycle.h
    public /* synthetic */ void a(p pVar) {
        d.d(this, pVar);
    }

    @Override // androidx.lifecycle.h
    public void b(p pVar) {
        m();
    }

    @Override // androidx.lifecycle.h
    public /* synthetic */ void e(p pVar) {
        d.c(this, pVar);
    }

    @Override // androidx.lifecycle.h
    public /* synthetic */ void f(p pVar) {
        d.f(this, pVar);
    }

    @Override // androidx.lifecycle.h
    public void g(p pVar) {
        o();
        l();
    }

    @Override // androidx.lifecycle.h
    public /* synthetic */ void i(p pVar) {
        d.e(this, pVar);
    }

    public void n() {
        jc.a aVar = this.f19457a;
        if (aVar == null || !aVar.isShowing()) {
            m();
            jc.a aVar2 = new jc.a(this.f19459c);
            this.f19457a = aVar2;
            aVar2.setTitle(k.S);
            this.f19457a.b(this.f19459c.getString(k.W));
            this.f19457a.d(new b());
            this.f19457a.show();
        }
    }

    public void o() {
        if (this.f19458b) {
            this.f19459c.unregisterReceiver(this.f19462f);
            this.f19458b = false;
        }
    }
}
