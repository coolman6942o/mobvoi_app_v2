package ub;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.h0;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.companion.setting.CompanionSetting;
import com.mobvoi.companion.ui.e;
import com.mobvoi.companion.wear.WearNode;
import com.mobvoi.companion.wear.WearPairingPool;
import com.mobvoi.record.RecordViewModel;
import com.mobvoi.wear.common.base.TicwatchModels;
import com.mobvoi.wear.common.base.WearPath;
import com.mobvoi.wear.msgproxy.MessageProxyClient;
import com.mobvoi.wear.msgproxy.MessageProxyException;
import fg.f;
import java.util.List;
import pc.b;
import vb.c;
import yb.a;
/* compiled from: TicWatchNewHealthCardFragment.java */
/* loaded from: classes2.dex */
public abstract class h extends b implements WearPairingPool.f {

    /* renamed from: s  reason: collision with root package name */
    private static int f35365s = 10;

    /* renamed from: p  reason: collision with root package name */
    protected WearNode f35366p;

    /* renamed from: q  reason: collision with root package name */
    private RecordViewModel f35367q;

    /* renamed from: r  reason: collision with root package name */
    private int f35368r = 1;

    private void n0() {
        RecordViewModel recordViewModel = (RecordViewModel) new h0(this).a(RecordViewModel.class);
        this.f35367q = recordViewModel;
        recordViewModel.C().i(getViewLifecycleOwner(), g.f35364a);
        this.f35367q.D(this.f35368r, f35365s);
    }

    private void o0() {
        WearNode wearNode = this.f35366p;
        if (wearNode != null) {
            this.f32729b = wearNode.nodeName;
            q0(wearNode);
            r0();
            h0(this.f32729b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void p0(List list) {
        if (list != null && list.size() > 0) {
            a.b(true);
        }
    }

    private void q0(WearNode wearNode) {
    }

    private void r0() {
        String wearModel = CompanionSetting.getWearModel(this.f35366p);
        if (TicwatchModels.isRover(wearModel)) {
            this.f32731d.setImageResource(od.a.f31572i);
        } else if (TicwatchModels.isJupiter(wearModel) || TicwatchModels.isPro2021(wearModel)) {
            this.f32731d.setImageResource(od.a.f31571h);
        } else if (TicwatchModels.isE2(wearModel)) {
            this.f32731d.setImageResource(od.a.f31569f);
        } else if (TicwatchModels.isC2(wearModel) || TicwatchModels.isSakura2020(wearModel)) {
            this.f32731d.setImageResource(od.a.f31568e);
        } else if (TicwatchModels.isE3(wearModel)) {
            this.f32731d.setImageResource(od.a.f31570g);
        } else if (TicwatchModels.isRover3X(wearModel) || TicwatchModels.isRover3U_4G(wearModel)) {
            this.f32731d.setImageResource(od.a.f31574k);
        } else if (TicwatchModels.isRover3U_BT(wearModel)) {
            this.f32731d.setImageResource(od.a.f31573j);
        } else if (TicwatchModels.isLily(wearModel) || TicwatchModels.isLotus(wearModel)) {
            this.f32731d.setImageResource(od.a.f31575l);
        } else {
            this.f32731d.setImageResource(od.a.f31571h);
        }
        e0();
    }

    @Override // pc.b
    protected void g0() {
        try {
            if (MessageProxyClient.getInstance().hasConnectedNodes()) {
                k.a("TicwatchHealthCard", "onResume, send battery sync to all nodes.");
                MessageProxyClient.getInstance().sendMessage(WearPath.Companion.SYNC_WEAR_BATTERY);
            }
        } catch (MessageProxyException unused) {
        }
    }

    @Override // com.mobvoi.companion.wear.WearPairingPool.f
    public void l(List<WearNode> list, String str) {
        int i10;
        if (this.f35366p != null) {
            for (WearNode wearNode : list) {
                if (wearNode.nodeId.equals(this.f35366p.nodeId)) {
                    this.f35366p = wearNode;
                    if (!TextUtils.isEmpty(wearNode.nodeName)) {
                        this.f32729b = wearNode.nodeName;
                        WearPairingPool.ConnectionState connectionState = wearNode.connectionState;
                        if (connectionState == WearPairingPool.ConnectionState.ConnectedNearby) {
                            i10 = 1;
                        } else {
                            i10 = connectionState == WearPairingPool.ConnectionState.Disconnected ? 3 : 2;
                        }
                        this.f32730c = i10;
                        this.f32728a = wearNode.batteryLevel;
                    }
                    if (wearNode.nodeId.equals(str)) {
                        com.mobvoi.companion.wear.a.f().b(str);
                        return;
                    }
                    return;
                }
            }
        }
    }

    public abstract List<e> m0();

    @Override // pc.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f35366p = (WearNode) arguments.get("wear_node");
        }
        this.f32739l.f(m0());
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        WearPairingPool.i().q(this);
    }

    @Override // pc.b, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (c.i().h() != null) {
            f.b(getActivity());
            c.i().k();
        }
    }

    @Override // pc.b, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        WearPairingPool.i().c(this);
        o0();
        n0();
    }
}
