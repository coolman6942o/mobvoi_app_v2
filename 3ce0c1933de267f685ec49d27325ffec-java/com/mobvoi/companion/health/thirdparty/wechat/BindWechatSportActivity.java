package com.mobvoi.companion.health.thirdparty.wechat;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import ce.e;
import ce.f;
import ce.h;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.companion.base.m3.d;
import com.mobvoi.companion.health.thirdparty.wechat.u;
import com.mobvoi.companion.share.a;
import com.mobvoi.wear.common.base.WearPath;
import com.mobvoi.wear.msgproxy.MessageProxyClient;
import rx.c;
import yp.b;
import yp.g;
/* loaded from: classes2.dex */
public class BindWechatSportActivity extends d implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private String f17057a = null;

    /* renamed from: b  reason: collision with root package name */
    private String f17058b = null;

    /* renamed from: c  reason: collision with root package name */
    private String f17059c = null;

    /* renamed from: d  reason: collision with root package name */
    private String f17060d = null;

    /* renamed from: e  reason: collision with root package name */
    private int f17061e;

    /* renamed from: f  reason: collision with root package name */
    private ProgressBar f17062f;

    /* renamed from: g  reason: collision with root package name */
    private Button f17063g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f17064h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f17065i;

    private void O() {
        if (TextUtils.isEmpty(this.f17060d)) {
            Toast.makeText(this, h.f5860n, 0).show();
        } else if (!new a(this).a()) {
            Toast.makeText(this, h.f5871s0, 0).show();
        } else {
            c0();
            x.a(ta.a.x(), this.f17060d, new b() { // from class: com.mobvoi.companion.health.thirdparty.wechat.i
                @Override // yp.b
                public final void call(Object obj) {
                    BindWechatSportActivity.this.Q((u) obj);
                }
            }, new b() { // from class: com.mobvoi.companion.health.thirdparty.wechat.l
                @Override // yp.b
                public final void call(Object obj) {
                    BindWechatSportActivity.this.S((Throwable) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q(u uVar) {
        k.a("BindWechatSport", "onWechatAuthResponse " + uVar);
        if (uVar != null) {
            u.a aVar = uVar.deviceInfo;
            String str = aVar.deviceId;
            String str2 = aVar.ticket;
            int i10 = this.f17061e;
            if (i10 == 1) {
                t.h(this, str);
            } else if (i10 == 2) {
                t.i(this, this.f17060d, str);
            }
            t.l(this, str2);
            if (!TextUtils.isEmpty(this.f17057a)) {
                MessageProxyClient.getInstance().sendMessage(this.f17057a, WearPath.Health.OPEN_WECHAT_QR_TICKET, str2.getBytes());
            } else {
                MessageProxyClient.getInstance().sendMessage(WearPath.Health.OPEN_WECHAT_QR_TICKET, str2.getBytes());
            }
            d0();
            b0();
            return;
        }
        Toast.makeText(this, h.R, 0).show();
        d0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S(Throwable th2) {
        k.e("BindWechatSport", "error auth wechat ", th2);
        Toast.makeText(this, h.R, 0).show();
        d0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ c T(z zVar) {
        k.a("BindWechatSport", "onTokenResponse " + zVar);
        return x.f17089a.a().e(zVar.token, this.f17059c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U(y yVar) {
        k.a("BindWechatSport", "onStatusResponse " + yVar);
        if (yVar != null) {
            d0();
            if ("2".equals(yVar.status)) {
                k.a("BindWechatSport", "Already bind!");
                Z();
                t.j(this, true);
                return;
            }
            k.a("BindWechatSport", "Not binded");
            a0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V(Throwable th2) {
        k.e("BindWechatSport", "onRequestError", th2);
        d0();
        Toast.makeText(this, getString(h.R), 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void W(DialogInterface dialogInterface, int i10) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void X(DialogInterface dialogInterface, int i10) {
    }

    private void Y() {
        c0();
        if (TextUtils.isEmpty(this.f17059c)) {
            d0();
            a0();
            return;
        }
        x.f17089a.a().d().Z(cq.a.c()).v(new g() { // from class: com.mobvoi.companion.health.thirdparty.wechat.m
            @Override // yp.g
            public final Object call(Object obj) {
                c T;
                T = BindWechatSportActivity.this.T((z) obj);
                return T;
            }
        }).H(xp.a.b()).Y(new b() { // from class: com.mobvoi.companion.health.thirdparty.wechat.j
            @Override // yp.b
            public final void call(Object obj) {
                BindWechatSportActivity.this.U((y) obj);
            }
        }, new b() { // from class: com.mobvoi.companion.health.thirdparty.wechat.k
            @Override // yp.b
            public final void call(Object obj) {
                BindWechatSportActivity.this.V((Throwable) obj);
            }
        });
    }

    private void Z() {
        this.f17064h.setText(getResources().getString(h.f5861n0));
        this.f17063g.setText(getResources().getString(h.f5859m0));
        this.f17063g.setBackground(getResources().getDrawable(ce.d.f5762j));
        this.f17063g.setVisibility(0);
        this.f17064h.setVisibility(0);
        this.f17065i = true;
    }

    private void a0() {
        if (this.f17061e == 3) {
            this.f17064h.setText(getResources().getString(h.f5880z));
            this.f17063g.setVisibility(8);
        } else {
            this.f17064h.setText(getResources().getString(h.f5879y));
            this.f17063g.setText(getResources().getString(h.f5857l0));
            this.f17063g.setVisibility(0);
            this.f17063g.setBackground(getResources().getDrawable(ce.d.f5761i));
        }
        this.f17064h.setVisibility(0);
        this.f17065i = false;
    }

    private void b0() {
        new k7.b(this).h(h.f5855k0).d(true).j(h.f5844f, h.f17076a).m(h.f5873t0, g.f17075a).a().show();
    }

    private void c0() {
        this.f17062f.setVisibility(0);
    }

    private void d0() {
        this.f17062f.setVisibility(8);
    }

    @Override // com.mobvoi.companion.base.m3.d
    protected int getLayoutId() {
        return f.f5811e;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != e.f5769d) {
            return;
        }
        if (!this.f17065i) {
            O();
        } else {
            a0();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.base.m3.d, androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle(h.f5857l0);
        this.f17062f = (ProgressBar) findViewById(e.I);
        Button button = (Button) findViewById(e.f5769d);
        this.f17063g = button;
        button.setOnClickListener(this);
        this.f17064h = (TextView) findViewById(e.K);
        Intent intent = getIntent();
        if (intent != null && intent.getExtras() != null) {
            this.f17057a = intent.getExtras().getString("extra_key_wechat_node_id");
            this.f17058b = intent.getExtras().getString("extra_key_wechat_device_id");
            k.a("BindWechatSport", "Restore Device id from intent, " + this.f17058b);
            this.f17061e = intent.getExtras().getInt("extra_key_wechat_device_type");
            String string = intent.getExtras().getString("extra_key_wechat_mac_address");
            this.f17060d = string;
            int i10 = this.f17061e;
            if (i10 == 3) {
                this.f17059c = this.f17058b;
            } else if (i10 == 1) {
                this.f17059c = t.a(this);
            } else if (i10 == 2) {
                if (TextUtils.isEmpty(string)) {
                    k.q("BindWechatSport", "Mac address is not specified.");
                    finish();
                }
                this.f17059c = t.b(this, this.f17060d);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.base.m3.d, androidx.appcompat.app.d, androidx.fragment.app.f, android.app.Activity
    public void onDestroy() {
        x.j();
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.f, android.app.Activity
    public void onResume() {
        super.onResume();
        Y();
    }
}
