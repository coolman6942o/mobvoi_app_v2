package com.mobvoi.mcuwatch.ui.card;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import ci.b;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.companion.ui.d;
import com.mobvoi.companion.wear.WearPairingPool;
import com.mobvoi.mcuwatch.engine.n;
import ei.h;
import java.util.List;
import mj.c;
import nj.q;
import pi.a;
import pk.f;
/* compiled from: WatchLiteBaseFragment.java */
/* loaded from: classes2.dex */
public abstract class e extends d implements b.AbstractC0085b, n.a {

    /* renamed from: r  reason: collision with root package name */
    protected String f19485r;

    /* renamed from: s  reason: collision with root package name */
    protected a f19486s;

    /* renamed from: t  reason: collision with root package name */
    protected TicWatchLiteDeviceData f19487t;

    /* renamed from: u  reason: collision with root package name */
    private int f19488u;

    /* renamed from: p  reason: collision with root package name */
    private final dq.b f19483p = new dq.b();

    /* renamed from: q  reason: collision with root package name */
    protected final i f19484q = new i();

    /* renamed from: v  reason: collision with root package name */
    private int f19489v = -7829368;

    private void n0() {
        o0();
        i iVar = this.f19484q;
        iVar.a(iVar.J(this.f19485r).H(xp.a.b()).Y(new yp.b() { // from class: com.mobvoi.mcuwatch.ui.card.b
            @Override // yp.b
            public final void call(Object obj) {
                e.this.q0((Boolean) obj);
            }
        }, d.f19481a));
        i iVar2 = this.f19484q;
        iVar2.a(iVar2.j(this.f19485r).H(xp.a.b()).Y(new yp.b() { // from class: com.mobvoi.mcuwatch.ui.card.a
            @Override // yp.b
            public final void call(Object obj) {
                e.this.s0((pi.a) obj);
            }
        }, c.f19479a));
        u0();
    }

    private void o0() {
        f a10 = mi.a.a();
        if (a10 != null) {
            this.f19485r = a10.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q0(Boolean bool) {
        k.c("WatchLiteBaseFragment", "connectState changed %b", bool);
        x0();
        c.e().c(bool.booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s0(a aVar) {
        k.a("WatchLiteBaseFragment", "entity changed %s " + aVar);
        if (aVar != null) {
            a aVar2 = this.f19486s;
            if (aVar2 == null || !aVar2.macAddress.equals(aVar.macAddress)) {
                this.f19486s = aVar;
                if (this.f19487t == null) {
                    this.f19487t = new TicWatchLiteDeviceData(aVar, requireActivity(), this.f19484q, getViewLifecycleOwner());
                }
                this.f19487t.l(this.f19486s);
                x0();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void t0(Throwable th2) {
        k.r("WatchLiteBaseFragment", "Update ui fail", th2, new Object[0]);
    }

    private void v0(List<com.mobvoi.companion.ui.e> list) {
        this.f17633d.clear();
        this.f17633d.addAll(list);
        this.f17644o.f(this.f17633d);
    }

    private void x0() {
        h0();
    }

    @Override // com.mobvoi.mcuwatch.engine.n.a
    public void U(SharedPreferences sharedPreferences, String str) {
        if ("key_ble_battery".equals(str)) {
            h0();
        }
    }

    @Override // com.mobvoi.companion.ui.d
    public pc.d c0() {
        return this.f19487t;
    }

    @Override // com.mobvoi.companion.ui.d
    protected String d0() {
        return "ticlite_mcu";
    }

    @Override // com.mobvoi.companion.ui.d
    public void h0() {
        WearPairingPool.ConnectionState connectionState;
        super.h0();
        if (getContext() != null && this.f19486s != null) {
            int l10 = q.g().l();
            this.f19488u = l10;
            switch (l10) {
                case 1:
                    this.f17634e.setImageResource(sh.f.J);
                    break;
                case 2:
                    this.f17634e.setImageResource(sh.f.F);
                    break;
                case 3:
                    this.f17634e.setImageResource(sh.f.G);
                    break;
                case 4:
                    this.f17634e.setImageResource(sh.f.E);
                    break;
                case 5:
                    this.f17634e.setImageResource(sh.f.I);
                    break;
                case 6:
                case 7:
                    this.f17634e.setImageResource(sh.f.H);
                    break;
            }
            a aVar = this.f19486s;
            if (aVar.macAddress != null) {
                this.f17635f.setText(aVar.name);
                int e10 = n.f19178a.e();
                k.a("WatchLiteBaseFragment", "isConnected " + ci.a.b().f(this.f19486s.macAddress));
                if (isAdded()) {
                    if (ci.a.b().f(this.f19486s.macAddress)) {
                        connectionState = WearPairingPool.ConnectionState.ConnectedNearby;
                    } else {
                        connectionState = WearPairingPool.ConnectionState.Disconnected;
                    }
                    w0(connectionState, e10);
                }
            }
        }
    }

    protected abstract List<com.mobvoi.companion.ui.e> m0();

    @Override // com.mobvoi.companion.ui.d, com.mobvoi.companion.ui.a, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        n.f19178a.K("key_ble_battery", this);
    }

    @Override // com.mobvoi.companion.ui.a, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // com.mobvoi.companion.ui.d, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f19484q.onCleared();
        this.f19483p.b();
        b.e().g(this);
    }

    @Override // com.mobvoi.companion.ui.b, androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i10, strArr, iArr);
        if (i10 == 10001) {
            b.e().f();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f19489v = j7.a.b(requireActivity(), 16842806, -7829368);
        n0();
        b.e().b(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean p0() {
        if (this.f19484q.m(this.f19485r)) {
            return false;
        }
        Toast.makeText(getActivity(), sh.k.V, 0).show();
        return true;
    }

    @Override // com.mobvoi.companion.ui.d, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z10) {
        super.setUserVisibleHint(z10);
        if (z10) {
            zd.b.a(d0(), getActivity());
        }
    }

    protected void u0() {
        v0(m0());
    }

    public void w0(WearPairingPool.ConnectionState connectionState, int i10) {
        k.a("WatchLiteBaseFragment", "the connecttion status is: " + connectionState + "  the battery level is: " + i10);
        if (WearPairingPool.ConnectionState.ConnectedNearby.equals(connectionState)) {
            this.f17636g.setImageResource(sh.f.f34602y0);
            this.f17637h.setText(sh.k.f34858r0);
            this.f17637h.setTextColor(getResources().getColor(sh.d.f34450j));
            this.f17638i.setVisibility(0);
            this.f17639j.setVisibility(0);
            if (i10 > -1) {
                this.f17639j.setText(getResources().getString(sh.k.f34849p1, Integer.valueOf(i10)));
                this.f17638i.setBattery(i10);
            }
        } else if (WearPairingPool.ConnectionState.ConnectedCloud.equals(connectionState)) {
            this.f17636g.setImageResource(sh.f.f34592v);
            this.f17637h.setText(sh.k.f34838n0);
            this.f17637h.setTextColor(getResources().getColor(sh.d.f34450j));
            this.f17638i.setVisibility(8);
            this.f17639j.setVisibility(8);
        } else {
            this.f17636g.setImageResource(sh.f.P0);
            this.f17637h.setText(sh.k.f34863s0);
            this.f17637h.setTextColor(this.f19489v);
            this.f17638i.setVisibility(8);
            this.f17639j.setVisibility(8);
        }
    }

    @Override // ci.b.AbstractC0085b
    public void y(boolean z10) {
        if (z10 || TextUtils.isEmpty(this.f19485r)) {
            return;
        }
        if (mi.a.a() != null) {
            ci.a.b().g(new fi.a(1, this.f19485r));
            k.a("WatchLiteBaseFragment", "onStatusChange,enable:" + z10);
            h.a().j(requireContext());
            return;
        }
        ci.a.b().g(new fi.a(0, this.f19485r));
    }
}
