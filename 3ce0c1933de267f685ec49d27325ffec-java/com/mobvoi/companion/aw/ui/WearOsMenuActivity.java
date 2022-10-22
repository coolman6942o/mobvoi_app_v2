package com.mobvoi.companion.aw.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.app.c;
import com.google.android.material.divider.MaterialDivider;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.companion.WearableUiUtils;
import com.mobvoi.companion.aw.ui.WearOsMenuActivity;
import com.mobvoi.companion.aw.ui.pairing.ConnectivityCheckActivity;
import com.mobvoi.companion.base.m3.d;
import com.mobvoi.companion.ui.e;
import com.mobvoi.companion.wear.WearPairingPool;
import com.mobvoi.wear.util.DimensionUtils;
import java.util.ArrayList;
import java.util.List;
import od.b;
import sb.a;
import vb.m;
/* loaded from: classes2.dex */
public class WearOsMenuActivity extends d {

    /* renamed from: a  reason: collision with root package name */
    protected List<e> f16268a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private int f16269b = -1;

    /* renamed from: c  reason: collision with root package name */
    private String f16270c = "";

    /* renamed from: d  reason: collision with root package name */
    private LinearLayout f16271d;

    /* renamed from: e  reason: collision with root package name */
    private c f16272e;

    private void N() {
        this.f16271d.removeAllViews();
        if (this.f16268a.size() > 0) {
            for (int i10 = 0; i10 < this.f16268a.size(); i10++) {
                ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -2);
                pc.c cVar = new pc.c(this);
                cVar.a(this.f16268a.get(i10));
                if (i10 < this.f16268a.size() - 1) {
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, (int) DimensionUtils.dp2px(this, 0.5f));
                    layoutParams2.leftMargin = (int) DimensionUtils.dp2px(this, 50.0f);
                    layoutParams2.gravity = 80;
                    cVar.addView(new MaterialDivider(this), layoutParams2);
                }
                this.f16271d.addView(cVar, layoutParams);
            }
        }
    }

    private void O() {
        a.d(this, "clickBonus");
        WearableUiUtils.showBonusInfo(this);
    }

    private void Q() {
        a.d(this, "clickWeather");
        Intent intent = new Intent("com.mobvoi.companion.action.WEATHER_SETTINGS");
        intent.setPackage(getPackageName());
        ConnectivityCheckActivity.L(this, intent);
    }

    private void S() {
        k.c("TicwearMenuActivity", "Alert dialog for remove node %s", this.f16270c);
        this.f16272e.show();
    }

    private void T() {
        this.f16268a.clear();
        if (!com.mobvoi.companion.base.settings.a.isOversea()) {
            this.f16268a.add(new e(od.d.C, od.a.f31578o, new View.OnClickListener() { // from class: vb.q
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WearOsMenuActivity.this.V(view);
                }
            }));
            this.f16268a.add(new e(od.d.v_res_0x7f14115f, od.a.f31584u, new View.OnClickListener() { // from class: vb.o
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WearOsMenuActivity.this.W(view);
                }
            }));
        }
        this.f16268a.add(new e(od.d.D, od.a.f31577n, new View.OnClickListener() { // from class: vb.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WearOsMenuActivity.this.X(view);
            }
        }));
        N();
    }

    private void U() {
        a.d(this, "clickWearOsFeedback");
        if (com.mobvoi.companion.base.settings.a.isOversea()) {
            Intent intent = new Intent("com.mobvoi.companion.aw.action.FEEDBACK");
            intent.putExtra("common_list_type", 1);
            intent.setPackage(getPackageName());
            startActivity(intent);
            return;
        }
        WearableUiUtils.feedback(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V(View view) {
        O();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W(View view) {
        Q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X(View view) {
        U();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Y(DialogInterface dialogInterface, int i10) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z(DialogInterface dialogInterface, int i10) {
        k.i("TicwearMenuActivity", "Confirm remove node %s", this.f16270c);
        WearPairingPool.i().r(this, this.f16270c);
        com.mobvoi.companion.wear.a.f().j(this.f16270c);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a0(View view) {
        S();
    }

    private void initView() {
        this.f16271d = (LinearLayout) findViewById(b.j_res_0x7f0b046a);
        this.f16272e = new k7.b(this).h(od.d.k_res_0x7f140b01).d(true).j(od.d.f31588b, m.f35726a).m(od.d.f31589c, new DialogInterface.OnClickListener() { // from class: vb.l
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                WearOsMenuActivity.this.Z(dialogInterface, i10);
            }
        }).a();
        View findViewById = findViewById(b.g_res_0x7f0b01fb);
        if (this.f16269b == 3) {
            findViewById.setVisibility(0);
        } else {
            findViewById.setVisibility(8);
        }
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: vb.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WearOsMenuActivity.this.a0(view);
            }
        });
    }

    @Override // com.mobvoi.companion.base.m3.d
    protected int getLayoutId() {
        return od.c.d_res_0x7f0e006c;
    }

    @Override // com.mobvoi.companion.base.m3.d, androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle(od.d.f31590d);
        Intent intent = getIntent();
        if (intent != null) {
            this.f16269b = intent.getIntExtra("connection_state_key", -1);
            this.f16270c = intent.getStringExtra("node_id_key");
        }
        if (!TextUtils.isEmpty(this.f16270c)) {
            initView();
            return;
        }
        throw new IllegalArgumentException("the node id can not be null");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.base.m3.d, androidx.appcompat.app.d, androidx.fragment.app.f, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        c cVar = this.f16272e;
        if (cVar != null && cVar.isShowing()) {
            this.f16272e.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.f, android.app.Activity
    public void onPause() {
        super.onPause();
        a.h(this, "wearOsMenu");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.f, android.app.Activity
    public void onResume() {
        super.onResume();
        a.i(this, "wearOsMenu");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.d, androidx.fragment.app.f, android.app.Activity
    public void onStart() {
        super.onStart();
        T();
    }
}
