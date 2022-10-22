package com.mobvoi.record.fragment.pay;

import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.lifecycle.h0;
import androidx.lifecycle.x;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.googlecode.protobuf.format.JsonFormat;
import com.mobvoi.companion.browser.BasicBrowserActivity;
import com.mobvoi.companion.proto.PayProto;
import com.mobvoi.companion.proto.ProductProto;
import com.mobvoi.record.RecordViewModel;
import com.mobvoi.record.fragment.pay.a;
import com.mobvoi.record.h;
import com.mobvoi.record.i;
import com.mobvoi.record.k;
import com.mobvoi.record.utils.b;
import com.mobvoi.wear.permission.PermissionConstant;
import com.paypal.android.sdk.payments.PaymentConfirmation;
import com.unionpay.tsmservice.data.Constant;
import java.math.BigDecimal;
import java.util.List;
/* loaded from: classes2.dex */
public class PayActivity extends com.mobvoi.companion.base.m3.d implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private RecyclerView f20496a;

    /* renamed from: b  reason: collision with root package name */
    private RecordViewModel f20497b;

    /* renamed from: c  reason: collision with root package name */
    private com.mobvoi.record.fragment.pay.a f20498c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f20499d;

    /* renamed from: e  reason: collision with root package name */
    private Button f20500e;

    /* renamed from: f  reason: collision with root package name */
    private PayProto.SoundPay f20501f;

    /* renamed from: g  reason: collision with root package name */
    com.mobvoi.record.utils.b f20502g;

    /* renamed from: h  reason: collision with root package name */
    private String f20503h;

    /* renamed from: i  reason: collision with root package name */
    private String f20504i;

    /* renamed from: j  reason: collision with root package name */
    private String f20505j;

    /* renamed from: k  reason: collision with root package name */
    private ProgressDialog f20506k;

    /* renamed from: l  reason: collision with root package name */
    private BroadcastReceiver f20507l = new a();

    /* loaded from: classes2.dex */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int intExtra = intent.getIntExtra(PermissionConstant.Columns.STATUS, -1);
            Log.d("PayActivity", "onReceive: " + intExtra);
            if (intExtra == -2) {
                Toast.makeText(PayActivity.this, k.U, 1).show();
            } else if (intExtra != 0) {
                Toast.makeText(PayActivity.this, k.V, 1).show();
            } else {
                Toast.makeText(PayActivity.this, k.W, 1).show();
                PayActivity.this.c0();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements x<List<ProductProto.SoundProduct>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes2.dex */
        public class a implements a.c {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ List f20510a;

            a(List list) {
                this.f20510a = list;
            }

            @Override // com.mobvoi.record.fragment.pay.a.c
            public void a(int i10) {
                PayActivity.this.f20498c.g(i10);
                PayActivity.this.f20505j = ((ProductProto.SoundProduct) this.f20510a.get(i10)).getProductName();
                if (PayActivity.this.getPackageName().equals("com.mobvoi.companion.aw")) {
                    PayActivity.this.f20499d.setText(PayActivity.this.getString(k.f20680x, new Object[]{((ProductProto.SoundProduct) this.f20510a.get(i10)).getActualPrice()}));
                } else {
                    PayActivity.this.f20499d.setText(PayActivity.this.getString(k.f20679w, new Object[]{((ProductProto.SoundProduct) this.f20510a.get(i10)).getActualPrice()}));
                }
                PayActivity payActivity = PayActivity.this;
                payActivity.f20501f = payActivity.Z(((ProductProto.SoundProduct) this.f20510a.get(i10)).getActualPrice(), ((ProductProto.SoundProduct) this.f20510a.get(i10)).getProductId());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.mobvoi.record.fragment.pay.PayActivity$b$b  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0236b extends RecyclerView.n {
            C0236b(b bVar) {
            }

            @Override // androidx.recyclerview.widget.RecyclerView.n
            public void d(Rect rect, View view, RecyclerView recyclerView, RecyclerView.y yVar) {
                rect.bottom = aa.d.a(10.0f);
            }
        }

        b() {
        }

        /* renamed from: b */
        public void a(List<ProductProto.SoundProduct> list) {
            PayActivity payActivity = PayActivity.this;
            payActivity.f20498c = new com.mobvoi.record.fragment.pay.a(payActivity, list);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(PayActivity.this);
            linearLayoutManager.B2(1);
            PayActivity.this.f20496a.setLayoutManager(linearLayoutManager);
            PayActivity.this.f20498c.f(new a(list));
            PayActivity.this.f20496a.h(new C0236b(this));
            PayActivity.this.f20496a.setAdapter(PayActivity.this.f20498c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements x<PayProto.SoundPayResp> {
        c() {
        }

        /* renamed from: b */
        public void a(PayProto.SoundPayResp soundPayResp) {
            PayActivity.this.a0();
            if (soundPayResp != null) {
                com.mobvoi.android.common.utils.k.c("PayActivity", "onChanged: %s", JsonFormat.i(soundPayResp));
                if (PayActivity.this.getPackageName().equals("com.mobvoi.companion.aw")) {
                    PayActivity.this.f20503h = soundPayResp.getAmount();
                    PayActivity.this.f20504i = soundPayResp.getOrderId();
                    com.mobvoi.record.utils.b bVar = PayActivity.this.f20502g;
                    if (bVar != null) {
                        bVar.d(new BigDecimal(PayActivity.this.f20503h), Constant.KEY_CURRENCYTYPE_USD, PayActivity.this.f20505j);
                        return;
                    }
                    return;
                }
                String payUrl = soundPayResp.getPayUrl();
                Intent intent = new Intent(BasicBrowserActivity.ACTION);
                intent.putExtra("url", payUrl);
                intent.addFlags(268435456);
                intent.setPackage(PayActivity.this.getPackageName());
                if (intent.resolveActivity(PayActivity.this.getPackageManager()) != null) {
                    PayActivity.this.startActivity(intent);
                    return;
                }
                return;
            }
            Toast.makeText(PayActivity.this.getApplicationContext(), k.C, 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class d implements x<String> {
        d() {
        }

        /* renamed from: b */
        public void a(String str) {
            Toast.makeText(PayActivity.this, "Success!", 1).show();
            PayActivity.this.c0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class e implements b.a {
        e() {
        }

        @Override // com.mobvoi.record.utils.b.a
        public void a(PaymentConfirmation paymentConfirmation, String str) {
            if (paymentConfirmation == null || !TextUtils.isEmpty(str)) {
                Toast.makeText(PayActivity.this, str, 1).show();
                return;
            }
            com.mobvoi.android.common.utils.k.a("PayActivity", "onResult: -------" + str + "-----" + paymentConfirmation.a().a());
            PayActivity.this.f20497b.K(PayActivity.this.f20504i);
        }

        @Override // com.mobvoi.record.utils.b.a
        public void b() {
            PayActivity payActivity = PayActivity.this;
            if (payActivity.f20502g != null && !TextUtils.isEmpty(payActivity.f20503h) && !TextUtils.isEmpty(PayActivity.this.f20505j)) {
                PayActivity.this.f20502g.d(new BigDecimal(PayActivity.this.f20503h), Constant.KEY_CURRENCYTYPE_USD, PayActivity.this.f20505j);
            }
        }
    }

    private void Y() {
        this.f20497b.f20365c.i(this, new b());
        this.f20497b.f20367e.i(this, new c());
        this.f20497b.f20366d.i(this, new d());
        this.f20502g = com.mobvoi.record.utils.b.a(this, new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PayProto.SoundPay Z(String str, String str2) {
        if (getPackageName().equals("com.mobvoi.companion.aw")) {
            return PayProto.SoundPay.newBuilder().setAmount(str).setProductId(str2).setSource(PayProto.Source.ANDROID).setPayType("paypal").build();
        }
        return PayProto.SoundPay.newBuilder().setAmount(str).setProductId(str2).setSource(PayProto.Source.ANDROID).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a0() {
        ProgressDialog progressDialog = this.f20506k;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.f20506k.dismiss();
        }
    }

    private void b0() {
        this.f20496a = (RecyclerView) findViewById(h.f20590f0);
        this.f20499d = (TextView) findViewById(h.f20621t0);
        Button button = (Button) findViewById(h.f20614q);
        this.f20500e = button;
        button.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c0() {
        Intent intent = new Intent();
        intent.putExtra(Constant.CASH_LOAD_SUCCESS, true);
        setResult(-1, intent);
        finish();
    }

    private void d0(String str) {
        if (this.f20506k == null) {
            this.f20506k = new ProgressDialog(this);
        }
        this.f20506k.setMessage(str);
        this.f20506k.setCanceledOnTouchOutside(false);
        this.f20506k.show();
    }

    @Override // com.mobvoi.companion.base.m3.d
    protected int getLayoutId() {
        return i.f20635b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.f, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        com.mobvoi.record.utils.b bVar = this.f20502g;
        if (bVar != null) {
            bVar.b(i10, i11, intent);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != h.f20614q) {
            return;
        }
        if (this.f20501f == null) {
            Toast.makeText(this, getString(k.G), 1).show();
            return;
        }
        d0(getString(k.D));
        this.f20497b.J(this.f20501f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.base.m3.d, androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f20497b = (RecordViewModel) new h0(this).a(RecordViewModel.class);
        setTitle(k.H);
        b0();
        String packageName = getPackageName();
        if (packageName.equals("com.mobvoi.companion.aw") || packageName.equals(com.mobvoi.companion.base.settings.a.WEAR3_OVERSEA_PKG)) {
            this.f20497b.z();
        } else {
            this.f20497b.y();
        }
        Y();
        b1.a.b(this).c(this.f20507l, new IntentFilter("action.WEIXIN_PAY"));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.base.m3.d, androidx.appcompat.app.d, androidx.fragment.app.f, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        b1.a.b(this).e(this.f20507l);
        com.mobvoi.record.utils.b bVar = this.f20502g;
        if (bVar != null) {
            bVar.c();
        }
    }
}
