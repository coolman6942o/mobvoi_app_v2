package vb;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.mobvoi.companion.aw.ui.WearOsMenuActivity;
import com.mobvoi.companion.aw.ui.pairing.ConnectivityCheckActivity;
import com.mobvoi.companion.aw.ui.quickcontrol.QuickControlActivity;
import com.mobvoi.companion.browser.BasicBrowserActivity;
import com.mobvoi.companion.setting.CompanionSetting;
import com.mobvoi.companion.ui.e;
import com.mobvoi.companion.wear.WearNode;
import com.mobvoi.companion.wear.WearPairingPool;
import com.mobvoi.record.RecordActivity;
import java.util.ArrayList;
import java.util.List;
import od.a;
import od.d;
/* compiled from: TicwatchOverseaUIHelper.java */
/* loaded from: classes2.dex */
public class k extends b {
    private static int p(WearPairingPool.ConnectionState connectionState) {
        if (WearPairingPool.ConnectionState.ConnectedNearby == connectionState) {
            return 1;
        }
        return WearPairingPool.ConnectionState.ConnectedCloud == connectionState ? 2 : 3;
    }

    public static List<e> q(final Context context, final WearNode wearNode) {
        int[] iArr = {a.f31582s, a.f31583t, a.f31580q, a.f31581r, a.f31566c, a.f31579p, a.f31576m};
        int[] iArr2 = {d.B, d.f31592j, d.f31596z, d.A, d.f31590d, d.f31595y, d.f31594x};
        boolean[] zArr = {CompanionSetting.getNewFeartureShowKey(context, CompanionSetting.WATCHFACE_NEW_FEARTURE), false, CompanionSetting.getNewFeartureShowKey(context, CompanionSetting.RECORD_NEW_FEARTURE), CompanionSetting.getNewFeartureShowKey(context, CompanionSetting.SCREENSHORT_NEW_FEARTURE), false, false, false};
        View.OnClickListener[] onClickListenerArr = {new View.OnClickListener() { // from class: vb.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                k.r(WearNode.this, context, view);
            }
        }, new View.OnClickListener() { // from class: vb.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                k.s(WearNode.this, context, view);
            }
        }, new View.OnClickListener() { // from class: vb.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                k.t(WearNode.this, context, view);
            }
        }, new View.OnClickListener() { // from class: vb.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                k.u(WearNode.this, context, view);
            }
        }, new View.OnClickListener() { // from class: vb.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                k.v(WearNode.this, context, view);
            }
        }, new View.OnClickListener() { // from class: vb.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                k.w(WearNode.this, context, view);
            }
        }, new View.OnClickListener() { // from class: vb.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                k.x(WearNode.this, context, view);
            }
        }};
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < 7; i10++) {
            e eVar = new e(iArr2[i10], iArr[i10], zArr[i10], onClickListenerArr[i10]);
            if (i10 == 0) {
                eVar.isWatchFace = true;
            }
            arrayList.add(eVar);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void r(WearNode wearNode, Context context, View view) {
        WearPairingPool.i().d(wearNode.nodeId);
        Intent intent = new Intent("com.mobvoi.companion.action.WATCH_FACE_CENTER");
        intent.setPackage(context.getPackageName());
        ConnectivityCheckActivity.M(context, intent, wearNode);
        CompanionSetting.setNewFeartureShowKey(context, CompanionSetting.WATCHFACE_NEW_FEARTURE, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void s(WearNode wearNode, Context context, View view) {
        WearPairingPool.i().d(wearNode.nodeId);
        Intent intent = new Intent("com.mobvoi.companion.action.ESIM");
        intent.setPackage(context.getPackageName());
        ConnectivityCheckActivity.L(context, intent);
        b.g("communication");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void t(WearNode wearNode, Context context, View view) {
        WearPairingPool.i().d(wearNode.nodeId);
        context.startActivity(new Intent(context, RecordActivity.class));
        CompanionSetting.setNewFeartureShowKey(context, CompanionSetting.RECORD_NEW_FEARTURE, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void u(WearNode wearNode, Context context, View view) {
        WearPairingPool.i().d(wearNode.nodeId);
        Intent intent = new Intent("com.mobvoi.companion.action.SCREENSHOT");
        intent.setPackage(context.getPackageName());
        ConnectivityCheckActivity.M(context, intent, wearNode);
        CompanionSetting.setNewFeartureShowKey(context, CompanionSetting.SCREENSHORT_NEW_FEARTURE, false);
        b.g("screenshot");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void v(WearNode wearNode, Context context, View view) {
        WearNode wearNode2;
        WearPairingPool.i().d(wearNode.nodeId);
        List<WearNode> g10 = WearPairingPool.i().g();
        if (!TextUtils.isEmpty(wearNode.nodeId) && g10 != null && g10.size() > 0) {
            for (int i10 = 0; i10 < g10.size(); i10++) {
                wearNode2 = g10.get(i10);
                if (wearNode2 != null && wearNode.nodeId.equals(wearNode2.nodeId)) {
                    break;
                }
            }
        }
        wearNode2 = null;
        if (wearNode2 != null) {
            Intent intent = new Intent(context, WearOsMenuActivity.class);
            intent.putExtra("connection_state_key", p(wearNode2.connectionState));
            intent.putExtra("node_id_key", wearNode2.nodeId);
            context.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void w(WearNode wearNode, Context context, View view) {
        WearPairingPool.i().d(wearNode.nodeId);
        Intent intent = new Intent(BasicBrowserActivity.ACTION);
        String a10 = b.a();
        com.mobvoi.android.common.utils.k.c("TicwatchOverseaUIHelper", "help url %s", a10);
        intent.putExtra("url", a10);
        intent.setPackage(context.getPackageName());
        context.startActivity(intent);
        b.g("help");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void x(WearNode wearNode, Context context, View view) {
        WearPairingPool.i().d(wearNode.nodeId);
        Intent intent = new Intent(context, QuickControlActivity.class);
        intent.putExtra("node_id_key", wearNode.nodeId);
        context.startActivity(intent);
        b.g("quick_control");
    }
}
