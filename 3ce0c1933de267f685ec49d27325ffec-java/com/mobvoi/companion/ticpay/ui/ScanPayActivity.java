package com.mobvoi.companion.ticpay.ui;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;
import com.huawei.hms.hmsscankit.OnLightVisibleCallBack;
import com.huawei.hms.hmsscankit.OnResultCallback;
import com.huawei.hms.hmsscankit.RemoteView;
import com.huawei.hms.ml.scan.HmsScan;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.assistant.account.AccountConstant;
import com.mobvoi.companion.ticpay.ui.ScanPayActivity;
import com.mobvoi.wear.permission.PermissionConstant;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import jc.a;
import org.json.JSONObject;
import qd.i;
import qd.j;
import qd.m;
import qd.n;
/* loaded from: classes2.dex */
public class ScanPayActivity extends com.mobvoi.companion.base.m3.d {

    /* renamed from: a  reason: collision with root package name */
    private String f17530a;

    /* renamed from: b  reason: collision with root package name */
    private String f17531b;

    /* renamed from: c  reason: collision with root package name */
    private String f17532c;

    /* renamed from: d  reason: collision with root package name */
    private int f17533d;

    /* renamed from: e  reason: collision with root package name */
    private td.b f17534e;

    /* renamed from: f  reason: collision with root package name */
    private jc.a f17535f;

    /* renamed from: g  reason: collision with root package name */
    private FrameLayout f17536g;

    /* renamed from: h  reason: collision with root package name */
    private RemoteView f17537h;

    /* renamed from: i  reason: collision with root package name */
    private ImageView f17538i;

    /* renamed from: j  reason: collision with root package name */
    int f17539j;

    /* renamed from: k  reason: collision with root package name */
    int f17540k;

    /* renamed from: m  reason: collision with root package name */
    private Dialog f17542m;

    /* renamed from: l  reason: collision with root package name */
    private int[] f17541l = {i.f32962c, i.f32961b};

    /* renamed from: n  reason: collision with root package name */
    private BroadcastReceiver f17543n = new c();

    /* renamed from: o  reason: collision with root package name */
    private td.c f17544o = new d();

    /* loaded from: classes2.dex */
    class a implements OnLightVisibleCallBack {
        a() {
        }

        @Override // com.huawei.hms.hmsscankit.OnLightVisibleCallBack
        public void onVisibleChanged(boolean z10) {
            if (z10) {
                ScanPayActivity.this.f17538i.setVisibility(0);
            }
        }
    }

    /* loaded from: classes2.dex */
    class b implements OnResultCallback {
        b() {
        }

        @Override // com.huawei.hms.hmsscankit.OnResultCallback
        public void onResult(HmsScan[] hmsScanArr) {
            if (hmsScanArr == null || hmsScanArr.length <= 0 || hmsScanArr[0] == null || TextUtils.isEmpty(hmsScanArr[0].getOriginalValue())) {
                ScanPayActivity scanPayActivity = ScanPayActivity.this;
                Toast.makeText(scanPayActivity, scanPayActivity.getString(m.f33102v0), 1).show();
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(hmsScanArr[0].getOriginalValue());
                ScanPayActivity.this.f17530a = jSONObject.getString("order");
                ScanPayActivity.this.f17531b = jSONObject.getString("info");
                ScanPayActivity.this.f17532c = jSONObject.getString("model");
                ScanPayActivity.this.f17533d = jSONObject.getInt("way");
                ScanPayActivity scanPayActivity2 = ScanPayActivity.this;
                scanPayActivity2.f17534e = new td.b(scanPayActivity2, scanPayActivity2.f17544o);
                if (ScanPayActivity.this.f17533d == 3) {
                    ScanPayActivity scanPayActivity3 = ScanPayActivity.this;
                    scanPayActivity3.h0(scanPayActivity3.f17531b);
                } else {
                    ScanPayActivity.this.f17534e.b(ScanPayActivity.this.f17533d, ScanPayActivity.this.f17531b, ScanPayActivity.this.f17532c);
                }
            } catch (Exception e10) {
                k.r("PayActivity", "pay error ", e10, new Object[0]);
                ScanPayActivity scanPayActivity4 = ScanPayActivity.this;
                Toast.makeText(scanPayActivity4, scanPayActivity4.getString(m.f33102v0), 1).show();
            }
        }
    }

    /* loaded from: classes2.dex */
    class c extends BroadcastReceiver {
        c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int intExtra = intent.getIntExtra(PermissionConstant.Columns.STATUS, -1);
            k.c("PayActivity", "pay status %s", Integer.valueOf(intExtra));
            if (intExtra == -4) {
                ScanPayActivity.this.f17544o.b();
            } else if (intExtra == -2) {
                ScanPayActivity.this.f17544o.d();
            } else if (intExtra != 0) {
                ScanPayActivity.this.f17544o.b();
            } else {
                ScanPayActivity.this.f17544o.c();
            }
            b1.a.b(ScanPayActivity.this).e(this);
        }
    }

    /* loaded from: classes2.dex */
    class d implements td.c {
        d() {
        }

        @Override // td.c
        public void a(int i10) {
            k.c("PayActivity", "choosePayWayResult() called with:  payWay = %s", Integer.valueOf(i10));
            ScanPayActivity.this.f17534e.b(i10, ScanPayActivity.this.f17531b, ScanPayActivity.this.f17532c);
            ScanPayActivity.this.f17533d = i10;
        }

        @Override // td.c
        public void b() {
            k.a("PayActivity", "payFailure: ");
        }

        @Override // td.c
        public void c() {
            k.c("PayActivity", "paySuccess, orderType = %s , money = %s", ScanPayActivity.this.f17530a, Integer.valueOf(ScanPayActivity.this.f17533d));
            Toast.makeText(ScanPayActivity.this, m.f33092q0, 0).show();
            ScanPayActivity.this.finish();
        }

        @Override // td.c
        public void d() {
            k.a("PayActivity", "payCancel: ");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class e implements a.AbstractC0354a {
        e() {
        }

        @Override // jc.a.AbstractC0354a
        public void a() {
            ScanPayActivity.this.f17535f.dismiss();
            ScanPayActivity.this.setResult(0);
            ScanPayActivity.this.finish();
        }

        @Override // jc.a.AbstractC0354a
        public void onCancel() {
            ScanPayActivity.this.f17535f.dismiss();
            ScanPayActivity.this.setResult(0);
            ScanPayActivity.this.finish();
        }
    }

    private boolean a0() {
        if (androidx.core.content.b.a(this, "android.permission.CAMERA") == 0) {
            return true;
        }
        if (androidx.core.app.a.w(this, "android.permission.CAMERA")) {
            g0();
        } else {
            androidx.core.app.a.s(this, new String[]{"android.permission.CAMERA"}, 10);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b0(View view) {
        if (this.f17537h.getLightStatus()) {
            this.f17537h.switchLight();
            this.f17538i.setImageResource(this.f17541l[1]);
            return;
        }
        this.f17537h.switchLight();
        this.f17538i.setImageResource(this.f17541l[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c0(DialogInterface dialogInterface, int i10) {
        dialogInterface.dismiss();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d0(DialogInterface dialogInterface, int i10) {
        androidx.core.app.a.s(this, new String[]{"android.permission.CAMERA"}, 10);
    }

    private void e0() {
        this.f17538i.setOnClickListener(new View.OnClickListener() { // from class: ud.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ScanPayActivity.this.b0(view);
            }
        });
    }

    private void g0() {
        if (this.f17542m == null) {
            this.f17542m = new k7.b(this, n.f33112b).d(false).q(m.f33095s).D(getString(m.f33093r, new Object[]{getString(m.f33091q)})).j(m.f33064h, new DialogInterface.OnClickListener() { // from class: ud.f
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i10) {
                    ScanPayActivity.this.c0(dialogInterface, i10);
                }
            }).m(m.f33067i, new DialogInterface.OnClickListener() { // from class: ud.g
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i10) {
                    ScanPayActivity.this.d0(dialogInterface, i10);
                }
            }).a();
        }
        this.f17542m.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h0(String str) {
        try {
            String e10 = AccountConstant.e();
            PayReq payReq = new PayReq();
            JSONObject jSONObject = new JSONObject(str);
            payReq.appId = jSONObject.getString("appid");
            payReq.partnerId = jSONObject.getString("partnerid");
            payReq.prepayId = jSONObject.getString("prepayid");
            payReq.nonceStr = jSONObject.getString("noncestr");
            payReq.timeStamp = jSONObject.getString("timestamp");
            payReq.packageValue = jSONObject.getString("package");
            payReq.sign = jSONObject.getString("sign");
            IWXAPI createWXAPI = WXAPIFactory.createWXAPI(this, e10);
            createWXAPI.registerApp(e10);
            boolean sendReq = createWXAPI.sendReq(payReq);
            k.c("PayActivity", "weixin pay send req  %s , result %s", str, Boolean.valueOf(sendReq));
            if (sendReq) {
                b1.a.b(this).c(this.f17543n, new IntentFilter("action.WEIXIN_PAY"));
            } else {
                f0(getString(m.f33045a1, new Object[]{"", ""}), true);
            }
        } catch (Exception e11) {
            k.r("PayActivity", "start weixin pay error ", e11, new Object[0]);
            f0(getString(m.f33045a1, new Object[]{e11.getMessage(), e11.getLocalizedMessage()}), true);
        }
    }

    protected void f0(String str, boolean z10) {
        if (!isFinishing() && !isDestroyed()) {
            if (this.f17535f == null) {
                jc.a aVar = new jc.a(this);
                this.f17535f = aVar;
                aVar.b(getResources().getString(m.f33043a));
                this.f17535f.setCanceledOnTouchOutside(false);
                this.f17535f.d(new e());
            }
            k.a("PayActivity", "show error dialog.");
            this.f17535f.setCancelable(z10);
            this.f17535f.i(str);
            this.f17535f.show();
        }
    }

    @Override // com.mobvoi.companion.base.m3.d
    protected int getLayoutId() {
        return qd.k.f33032h;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.f, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        this.f17534e.a(i10, i11, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.base.m3.d, androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle(m.E0);
        this.f17536g = (FrameLayout) findViewById(j.f32996k0);
        float f10 = getResources().getDisplayMetrics().density;
        this.f17539j = getResources().getDisplayMetrics().widthPixels;
        this.f17540k = getResources().getDisplayMetrics().heightPixels;
        Rect rect = new Rect();
        int i10 = this.f17539j;
        int i11 = ((int) (f10 * 240.0f)) / 2;
        rect.left = (i10 / 2) - i11;
        rect.right = (i10 / 2) + i11;
        int i12 = this.f17540k;
        rect.top = (i12 / 2) - i11;
        rect.bottom = (i12 / 2) + i11;
        this.f17538i = (ImageView) findViewById(j.f33011s);
        if (a0()) {
            e0();
            RemoteView build = new RemoteView.Builder().setContext(this).setBoundingBox(rect).setFormat(0, new int[0]).build();
            this.f17537h = build;
            build.setOnLightVisibleCallback(new a());
            this.f17537h.setOnResultCallback(new b());
            this.f17537h.onCreate(bundle);
            this.f17536g.addView(this.f17537h, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.base.m3.d, androidx.appcompat.app.d, androidx.fragment.app.f, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        RemoteView remoteView = this.f17537h;
        if (remoteView != null) {
            remoteView.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.f, android.app.Activity
    public void onPause() {
        super.onPause();
        RemoteView remoteView = this.f17537h;
        if (remoteView != null) {
            remoteView.onPause();
        }
        Dialog dialog = this.f17542m;
        if (dialog != null) {
            dialog.dismiss();
            this.f17542m = null;
        }
    }

    @Override // androidx.fragment.app.f, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i10, strArr, iArr);
        if (i10 == 10) {
            finish();
            if (iArr[0] == 0) {
                startActivity(new Intent(this, ScanPayActivity.class));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.f, android.app.Activity
    public void onResume() {
        super.onResume();
        RemoteView remoteView = this.f17537h;
        if (remoteView != null) {
            remoteView.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.d, androidx.fragment.app.f, android.app.Activity
    public void onStart() {
        super.onStart();
        RemoteView remoteView = this.f17537h;
        if (remoteView != null) {
            remoteView.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.d, androidx.fragment.app.f, android.app.Activity
    public void onStop() {
        super.onStop();
        RemoteView remoteView = this.f17537h;
        if (remoteView != null) {
            remoteView.onStop();
        }
    }
}
