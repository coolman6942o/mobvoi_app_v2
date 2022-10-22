package com.mobvoi.companion.aw.ui.pairing;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.companion.aw.ui.pairing.ConnectivityCheckActivity;
import com.mobvoi.companion.base.m3.a;
import com.mobvoi.companion.wear.WearNode;
import com.mobvoi.companion.wear.WearPairingPool;
import com.mobvoi.wear.info.WearInfo;
import java.lang.ref.WeakReference;
import java.util.List;
import od.c;
import od.d;
import uc.b;
/* loaded from: classes2.dex */
public class ConnectivityCheckActivity extends a implements View.OnClickListener, WearPairingPool.f {

    /* renamed from: i  reason: collision with root package name */
    private static WeakReference<Context> f16314i;

    /* renamed from: j  reason: collision with root package name */
    private static WeakReference<Class<?>> f16315j;

    /* renamed from: k  reason: collision with root package name */
    private static WeakReference<Integer> f16316k;

    /* renamed from: a  reason: collision with root package name */
    private Button f16317a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f16318b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f16319c;

    /* renamed from: d  reason: collision with root package name */
    private LottieAnimationView f16320d;

    /* renamed from: e  reason: collision with root package name */
    private Handler f16321e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f16322f = false;

    /* renamed from: g  reason: collision with root package name */
    private boolean f16323g = false;

    /* renamed from: h  reason: collision with root package name */
    private String f16324h;

    private static b H() {
        String h10 = WearPairingPool.i().h();
        WearInfo c10 = com.mobvoi.companion.wear.a.f().c(h10);
        if (c10 != null) {
            return new b(c10.wearDeviceId, c10.btAddress, 2, h10);
        }
        return null;
    }

    private static void I(WeakReference<Context> weakReference, WeakReference<Class<?>> weakReference2, WeakReference<Integer> weakReference3) {
        if (weakReference != null && weakReference2 != null) {
            k.a("ConnectivityCheck", "StartOriginalActivity");
            Context context = weakReference.get();
            Class<?> cls = weakReference2.get();
            if (cls != null && context != null) {
                k.c("ConnectivityCheck", "LocalActivity == %s", cls.getSimpleName());
                if ("BindWechatSportActivity".equals(cls.getSimpleName())) {
                    ((uc.a) kc.b.b().a(uc.a.class)).a(context, H());
                } else if ("RecordActivity".equals(cls.getSimpleName())) {
                    Intent intent = new Intent(context, cls);
                    intent.putExtra("isFromWatch", true);
                    context.startActivity(intent);
                } else {
                    context.startActivity(new Intent(context, cls));
                }
            }
        }
    }

    @TargetApi(21)
    private void J() {
        WearPairingPool.i().c(this);
        this.f16317a.setVisibility(8);
        this.f16320d.setImageAssetsFolder("images");
        this.f16320d.setAnimation("loading.json");
        this.f16320d.o();
        this.f16318b.setText(getString(d.e_res_0x7f1402a7));
        this.f16319c.setText(getString(d.h_res_0x7f1402ac));
        this.f16321e.postDelayed(new Runnable() { // from class: wb.a
            @Override // java.lang.Runnable
            public final void run() {
                ConnectivityCheckActivity.this.K();
            }
        }, 15000L);
        this.f16322f = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(21)
    public void K() {
        this.f16318b.setText(getString(d.g_res_0x7f1402ab));
        this.f16319c.setText(getString(d.f_res_0x7f1402aa));
        if (this.f16320d.m()) {
            this.f16320d.g();
        }
        this.f16320d.setImageDrawable(getDrawable(od.a.f31565b));
        this.f16317a.setVisibility(0);
        this.f16317a.setText(getString(d.f31587a));
        this.f16317a.setBackground(getDrawable(od.a.a_res_0x7f0800c2));
    }

    public static void L(Context context, Intent intent) {
        f16314i = new WeakReference<>(context);
        if (yd.k.a()) {
            context.startActivity(intent);
        } else {
            context.startActivity(new Intent(context, ConnectivityCheckActivity.class));
        }
    }

    public static void M(Context context, Intent intent, WearNode wearNode) {
        if (yd.k.b(wearNode)) {
            intent.putExtra("extra_node_id", wearNode.nodeId);
        } else {
            intent = new Intent(context, ConnectivityCheckActivity.class);
        }
        context.startActivity(intent);
    }

    @Override // com.mobvoi.companion.wear.WearPairingPool.f
    public void l(List<WearNode> list, String str) {
        k.a("ConnectivityCheck", "onPairNodesChanged " + str + ", mNodeId == " + this.f16324h + " isConnected " + yd.k.a());
        for (WearNode wearNode : list) {
            k.a("ConnectivityCheck", "NodeInfo: nodeId == " + wearNode.nodeId + " nodeState == " + wearNode.connectionState);
            if (wearNode.connectionState == WearPairingPool.ConnectionState.ConnectedNearby && this.f16324h.equals(wearNode.nodeId)) {
                I(f16314i, f16315j, f16316k);
                finish();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != od.b.c_res_0x7f0b01ac) {
            return;
        }
        if (this.f16322f) {
            Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(getPackageName());
            launchIntentForPackage.addFlags(67108864);
            startActivity(launchIntentForPackage);
            return;
        }
        vb.b.c(this);
        this.f16323g = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.base.m3.a, androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    @TargetApi(21)
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setStatusBarColor(j7.a.b(this, 16842801, -1));
        setContentView(c.a_res_0x7f0e0032);
        Button button = (Button) findViewById(od.b.c_res_0x7f0b01ac);
        this.f16317a = button;
        button.setOnClickListener(this);
        this.f16318b = (TextView) findViewById(od.b.f_res_0x7f0b01af);
        this.f16319c = (TextView) findViewById(od.b.e_res_0x7f0b01ae);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) findViewById(od.b.d_res_0x7f0b01ad);
        this.f16320d = lottieAnimationView;
        lottieAnimationView.setImageDrawable(getDrawable(od.a.f31565b));
        this.f16321e = new Handler();
        this.f16324h = WearPairingPool.i().h();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.d, androidx.fragment.app.f, android.app.Activity
    public void onDestroy() {
        k.a("ConnectivityCheck", "clean some listeners and callbacks");
        this.f16321e.removeCallbacksAndMessages(null);
        WearPairingPool.i().q(this);
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        if (this.f16323g) {
            k.a("ConnectivityCheck", "onRestart: connectedState " + yd.k.a() + " hasTry " + this.f16322f);
            if (!yd.k.a() && !this.f16322f) {
                J();
            } else if (yd.k.a()) {
                I(f16314i, f16315j, f16316k);
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.d, androidx.fragment.app.f, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.f16320d.m()) {
            k.a("ConnectivityCheck", "canceling animation");
            this.f16320d.g();
        }
    }
}
