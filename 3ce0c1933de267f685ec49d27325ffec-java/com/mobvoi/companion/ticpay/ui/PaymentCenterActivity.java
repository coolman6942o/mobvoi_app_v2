package com.mobvoi.companion.ticpay.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.companion.base.perms.PermissionActivity;
import com.mobvoi.companion.setting.CompanionSetting;
import hc.e;
import qd.m;
import qd.o;
import rx.j;
/* loaded from: classes2.dex */
public class PaymentCenterActivity extends com.mobvoi.companion.ticpay.ui.c {

    /* renamed from: h  reason: collision with root package name */
    private static final String[] f17516h = {"android.permission.READ_PHONE_STATE"};

    /* renamed from: e  reason: collision with root package name */
    private j f17517e;

    /* renamed from: f  reason: collision with root package name */
    private BroadcastReceiver f17518f = new a();

    /* renamed from: g  reason: collision with root package name */
    private int f17519g;

    /* loaded from: classes2.dex */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("action.NFC_DISABLED".equals(action)) {
                PaymentCenterActivity paymentCenterActivity = PaymentCenterActivity.this;
                paymentCenterActivity.f17619b = true;
                paymentCenterActivity.M(paymentCenterActivity.getString(m.G), false);
            } else if ("action.SE_NOT_INIT".equals(action)) {
                PaymentCenterActivity paymentCenterActivity2 = PaymentCenterActivity.this;
                paymentCenterActivity2.f17619b = true;
                paymentCenterActivity2.M(paymentCenterActivity2.getString(m.Q0), false);
            }
        }
    }

    /* loaded from: classes2.dex */
    class b implements yp.b<rd.b> {
        b() {
        }

        /* renamed from: a */
        public void call(rd.b bVar) {
            PaymentCenterActivity.this.T(bVar);
        }
    }

    /* loaded from: classes2.dex */
    class c implements yp.b<Throwable> {
        c() {
        }

        /* renamed from: a */
        public void call(Throwable th2) {
            PaymentCenterActivity.this.U(th2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PaymentCenterActivity.this.V();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T(rd.b bVar) {
        k.c("PayCenterAct", "upload account result: %s", bVar);
        if (bVar.b()) {
            rd.c.b(this, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(Throwable th2) {
        k.e("PayCenterAct", "upload account error:", th2);
        th2.printStackTrace();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"MissingPermission"})
    public void V() {
        View findViewById = findViewById(16908290);
        if (!com.mobvoi.android.common.utils.m.b(this)) {
            findViewById.setOnClickListener(new d());
            return;
        }
        findViewById.setOnClickListener(null);
        findViewById(qd.j.F).setVisibility(8);
        getSupportFragmentManager().l().c(qd.j.f33013t, new com.mobvoi.companion.ticpay.ui.a(), "PayCenterAct").j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean W(View view) {
        view.getContext().startActivity(new Intent(view.getContext(), PayDebugActivity.class));
        return true;
    }

    private static void X() {
        if (Build.VERSION.SDK_INT >= 23) {
            Application e10 = com.mobvoi.android.common.utils.b.e();
            String[] strArr = f17516h;
            if (!e.i(e10, strArr)) {
                String string = com.mobvoi.android.common.utils.b.e().getString(m.K0);
                PermissionActivity.start(com.mobvoi.android.common.utils.b.e(), strArr, string, string);
            }
        }
    }

    public static void Y(Context context, int i10) {
        if (androidx.core.content.b.a(context, "android.permission.READ_PHONE_STATE") != 0) {
            X();
            return;
        }
        Intent intent = new Intent(context, PaymentCenterActivity.class);
        intent.putExtra("extra_index", i10);
        if (!(context instanceof Activity)) {
            intent.setFlags(268435456);
        }
        context.startActivity(intent);
    }

    @Override // com.mobvoi.companion.base.m3.d
    protected int getLayoutId() {
        return qd.k.f33031g;
    }

    @Override // com.mobvoi.companion.ticpay.ui.c, com.mobvoi.companion.base.m3.d, androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (CompanionSetting.TICPAY_PLATFORM_APOLLO.equals(CompanionSetting.getTicpayPlatform())) {
            sd.b.h().s((qd.d) kc.b.b().a(qd.d.class));
        } else {
            sd.b.h().s(o.k(this));
        }
        int intExtra = getIntent().getIntExtra("extra_index", 0);
        this.f17519g = intExtra;
        this.f17618a = true;
        if (intExtra == 1) {
            setTitle(m.f33082n);
            V();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("action.NFC_DISABLED");
            intentFilter.addAction("action.SE_NOT_INIT");
            b1.a.b(this).c(this.f17518f, intentFilter);
            findViewById(qd.j.f33012s0).setOnLongClickListener(ud.e.f35372a);
            Context applicationContext = getApplicationContext();
            if (rd.c.a(applicationContext)) {
                this.f17517e = rd.c.c(applicationContext, new b(), new c());
                return;
            }
            return;
        }
        setTitle(m.f33079m);
        Toast.makeText(this, "当前版本不支持该功能，请联系客服！", 1).show();
        finish();
    }

    @Override // com.mobvoi.companion.ticpay.ui.c, com.mobvoi.companion.base.m3.d, androidx.appcompat.app.d, androidx.fragment.app.f, android.app.Activity
    protected void onDestroy() {
        b1.a.b(this).e(this.f17518f);
        j jVar = this.f17517e;
        if (jVar != null && !jVar.isUnsubscribed()) {
            this.f17517e.unsubscribe();
        }
        super.onDestroy();
    }
}
