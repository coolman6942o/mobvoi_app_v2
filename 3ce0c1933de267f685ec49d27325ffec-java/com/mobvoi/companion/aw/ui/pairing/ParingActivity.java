package com.mobvoi.companion.aw.ui.pairing;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.mobvoi.companion.device.PiiAlterActivity;
import com.mobvoi.companion.wear.WearNode;
import com.mobvoi.companion.wear.WearPairingPool;
import com.mobvoi.wear.util.AwUtils;
import java.util.List;
/* loaded from: classes2.dex */
public class ParingActivity extends com.mobvoi.companion.base.m3.d implements WearPairingPool.f, View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private ImageView f16325a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f16326b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f16327c;

    /* renamed from: d  reason: collision with root package name */
    private Button f16328d;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final Context f16329a;

        @Override // java.lang.Runnable
        public void run() {
            vb.b.c(this.f16329a);
        }

        private b(Context context) {
            this.f16329a = context;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final Context f16330a;

        @Override // java.lang.Runnable
        public void run() {
            vb.b.d(this.f16330a);
        }

        private c(Context context) {
            this.f16330a = context;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final ParingActivity f16331a;

        @Override // java.lang.Runnable
        public void run() {
            this.f16331a.H();
        }

        private d(ParingActivity paringActivity) {
            this.f16331a = paringActivity;
        }
    }

    private void I() {
        if (!vb.b.b(this)) {
            this.f16325a.setImageResource(od.a.f31567d);
            this.f16326b.setVisibility(8);
            if (com.mobvoi.companion.base.settings.a.isOversea()) {
                this.f16327c.setText(getString(od.d.o_res_0x7f140c38, new Object[]{getString(od.d.r_res_0x7f140c3b), AwUtils.getWearOsName(this)}));
            } else {
                this.f16327c.setText(getString(od.d.o_res_0x7f140c38, new Object[]{getString(od.d.l_res_0x7f140c35), AwUtils.getWearOsName(this)}));
            }
            this.f16328d.setText(od.d.m_res_0x7f140c36);
            this.f16328d.setTag(new c(this));
        } else if (WearPairingPool.i().l()) {
            this.f16325a.setImageResource(od.a.f31567d);
            this.f16326b.setVisibility(8);
            this.f16327c.setText(getString(od.d.q_res_0x7f140c3a, new Object[]{AwUtils.getWearOsName(this)}));
            this.f16328d.setText(getString(od.d.n_res_0x7f140c37, new Object[]{AwUtils.getWearOsName(this)}));
            this.f16328d.setTag(new b(this));
        } else {
            this.f16325a.setImageResource(od.a.f31567d);
            this.f16326b.setVisibility(0);
            this.f16327c.setText(od.d.p_res_0x7f140c39);
            this.f16328d.setText(od.d.s_res_0x7f140c3c);
            this.f16328d.setTag(new d());
        }
    }

    private void initView() {
        this.f16325a = (ImageView) findViewById(od.b.h_res_0x7f0b0336);
        this.f16326b = (ImageView) findViewById(od.b.i_res_0x7f0b0338);
        this.f16327c = (TextView) findViewById(od.b.l_res_0x7f0b073b);
        Button button = (Button) findViewById(od.b.f31585b);
        this.f16328d = button;
        button.setOnClickListener(this);
    }

    public void H() {
        if (ta.a.b() || ta.a.A()) {
            finish();
        } else if (com.mobvoi.companion.base.settings.a.isOversea()) {
            startActivity(new Intent(this, PiiAlterActivity.class));
        }
        finish();
    }

    @Override // com.mobvoi.companion.base.m3.d
    protected int getLayoutId() {
        return od.c.b_res_0x7f0e0047;
    }

    @Override // com.mobvoi.companion.wear.WearPairingPool.f
    public void l(List<WearNode> list, String str) {
        I();
    }

    public void onAction(View view) {
        if (view.getTag() instanceof Runnable) {
            ((Runnable) view.getTag()).run();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == od.b.f31585b) {
            onAction(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.base.m3.d, androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        setTitle("");
        WearPairingPool.i().c(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.base.m3.d, androidx.appcompat.app.d, androidx.fragment.app.f, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        WearPairingPool.i().q(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.f, android.app.Activity
    public void onResume() {
        super.onResume();
        I();
    }
}
