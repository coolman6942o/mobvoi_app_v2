package com.mobvoi.companion.ticpay.ui;

import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.view.d0;
import cn.com.fmsh.tsm.business.bean.BusinessOrder;
import cn.com.fmsh.tsm.business.bean.d;
import cn.com.fmsh.tsm.business.exception.BusinessException;
import com.bjleisen.iface.sdk.bean.BusinessOrderInfo;
import com.bjleisen.iface.sdk.bean.resp.PayOrderBusiRespInfo;
import com.bjleisen.iface.sdk.bean.resp.RespInfo;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.android.common.utils.q;
import com.mobvoi.android.common.utils.s;
import com.mobvoi.assistant.account.AccountConstant;
import com.mobvoi.companion.browser.BasicBrowserActivity;
import com.mobvoi.companion.ticpay.ui.BusCardRechargeActivity;
import com.mobvoi.wear.common.base.WearPath;
import com.mobvoi.wear.permission.PermissionConstant;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.unionpay.tsmservice.data.Constant;
import java.util.HashMap;
import org.json.JSONObject;
import qd.e;
import qd.f;
import qd.j;
import qd.l;
import qd.m;
import td.c;
/* loaded from: classes2.dex */
public class BusCardRechargeActivity extends c implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    private CheckBox f17485e;

    /* renamed from: f  reason: collision with root package name */
    private Button f17486f;

    /* renamed from: g  reason: collision with root package name */
    private Button f17487g;

    /* renamed from: h  reason: collision with root package name */
    private Button f17488h;

    /* renamed from: i  reason: collision with root package name */
    private Button f17489i;

    /* renamed from: j  reason: collision with root package name */
    private Button f17490j;

    /* renamed from: k  reason: collision with root package name */
    private TextView f17491k;

    /* renamed from: l  reason: collision with root package name */
    private TextView f17492l;

    /* renamed from: m  reason: collision with root package name */
    private ud.a f17493m;

    /* renamed from: n  reason: collision with root package name */
    private int f17494n;

    /* renamed from: o  reason: collision with root package name */
    private int f17495o;

    /* renamed from: p  reason: collision with root package name */
    private int f17496p;

    /* renamed from: q  reason: collision with root package name */
    private int f17497q;

    /* renamed from: r  reason: collision with root package name */
    private td.b f17498r;

    /* renamed from: s  reason: collision with root package name */
    private ProgressDialog f17499s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f17500t;

    /* renamed from: u  reason: collision with root package name */
    private long f17501u;

    /* renamed from: x  reason: collision with root package name */
    private String f17504x;

    /* renamed from: y  reason: collision with root package name */
    private String f17505y;

    /* renamed from: v  reason: collision with root package name */
    private s f17502v = new s(this);

    /* renamed from: w  reason: collision with root package name */
    private BroadcastReceiver f17503w = new a();

    /* renamed from: z  reason: collision with root package name */
    private c f17506z = new b();

    /* loaded from: classes2.dex */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int intExtra = intent.getIntExtra(PermissionConstant.Columns.STATUS, -1);
            k.c("BusCardRecharge", "pay status %s", Integer.valueOf(intExtra));
            if (intExtra == -4) {
                BusCardRechargeActivity.this.f17506z.b();
            } else if (intExtra == -2) {
                BusCardRechargeActivity.this.f17506z.d();
            } else if (intExtra != 0) {
                BusCardRechargeActivity.this.f17506z.b();
            } else {
                BusCardRechargeActivity.this.f17506z.c();
            }
            b1.a.b(BusCardRechargeActivity.this).e(this);
        }
    }

    /* loaded from: classes2.dex */
    class b implements c {

        /* loaded from: classes2.dex */
        class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ int f17509a;

            a(int i10) {
                this.f17509a = i10;
            }

            @Override // java.lang.Runnable
            public void run() {
                BusCardRechargeActivity busCardRechargeActivity = BusCardRechargeActivity.this;
                String str = busCardRechargeActivity.f17504x;
                int i10 = this.f17509a;
                busCardRechargeActivity.i0(str, i10, i10, sd.c.b(), BusCardRechargeActivity.this.f17497q, false);
            }
        }

        b() {
        }

        @Override // td.c
        public void a(int i10) {
            k.c("BusCardRecharge", "choosePayWayResult() called with:  payWay = %s", Integer.valueOf(i10));
            BusCardRechargeActivity.this.f17498r.b(i10, BusCardRechargeActivity.this.f17505y, BusCardRechargeActivity.this.h0());
            BusCardRechargeActivity.this.f17497q = i10;
        }

        @Override // td.c
        public void b() {
            k.a("BusCardRecharge", "payFailure: ");
            HashMap hashMap = new HashMap();
            hashMap.put("pay_result", "failure");
            hashMap.put("buscard_type", BusCardRechargeActivity.this.f17493m.b());
            e.b().f(sd.b.h().m(), "ticpay_bus_pay_result", "failure", hashMap);
        }

        @Override // td.c
        public void c() {
            int i10 = BusCardRechargeActivity.this.f17495o + BusCardRechargeActivity.this.f17494n;
            k.c("BusCardRecharge", "paySuccess, orderType = %s , money = %s", Integer.valueOf(BusCardRechargeActivity.this.f17496p), Integer.valueOf(i10));
            BusCardRechargeActivity.this.f17502v.postDelayed(new a(i10), 1000L);
            HashMap hashMap = new HashMap();
            hashMap.put("pay_result", Constant.CASH_LOAD_SUCCESS);
            hashMap.put("buscard_type", BusCardRechargeActivity.this.f17493m.b());
            e.b().f(sd.b.h().m(), "ticpay_bus_pay_result", Constant.CASH_LOAD_SUCCESS, hashMap);
        }

        @Override // td.c
        public void d() {
            k.a("BusCardRecharge", "payCancel: ");
            HashMap hashMap = new HashMap();
            hashMap.put("pay_result", Constant.CASH_LOAD_CANCEL);
            hashMap.put("buscard_type", BusCardRechargeActivity.this.f17493m.b());
            e.b().f(sd.b.h().m(), "ticpay_bus_pay_result", Constant.CASH_LOAD_CANCEL, hashMap);
        }
    }

    private void e0() {
        Bundle bundle = new Bundle();
        bundle.putString("card_aid", this.f17493m.appAid);
        f.q(this.f17502v, 3005, bundle);
    }

    private void f0() {
        int i10 = this.f17494n + this.f17493m.balance;
        String str = this.f17500t ? "ticpay_bus_click_open_card" : "ticpay_bus_click_recharge";
        HashMap hashMap = new HashMap();
        hashMap.put("recharge_money", Integer.valueOf(i10));
        hashMap.put("buscard_type", this.f17493m.b());
        e.b().d(sd.b.h().m(), str, hashMap);
        if (this.f17496p == 2) {
            if (i10 > 100000) {
                Toast.makeText(this, m.J, 0).show();
                return;
            } else if (i10 <= 0) {
                Toast.makeText(this, m.f33056e0, 0).show();
                return;
            }
        }
        o0(getString(m.f33081m1));
        g0();
    }

    private void g0() {
        int i10 = this.f17495o;
        int i11 = this.f17494n;
        int i12 = i10 + i11;
        int i13 = 3;
        if (this.f17496p == 1 && i11 > 0) {
            this.f17496p = 3;
        }
        if (qd.a.c(this.f17493m) && this.f17496p == 2) {
            i13 = 4;
        } else if (!"A0000006320101050113581058000000".equals(this.f17493m.appAid)) {
            i13 = sd.b.h().k();
        }
        this.f17497q = i13;
        k.c("BusCardRecharge", "generateNewOrder orderType = %d, money = %d", Integer.valueOf(this.f17496p), Integer.valueOf(i12));
        Bundle bundle = new Bundle();
        bundle.putString("card_aid", this.f17493m.appAid);
        bundle.putInt("order_money", i12);
        bundle.putInt("order_type", this.f17496p);
        bundle.putInt("pay_way", i13);
        f.q(this.f17502v, 3006, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String h0() {
        if (sd.b.h().o()) {
            return td.e.f35139a;
        }
        return td.e.f35140b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i0(String str, int i10, int i11, String str2, int i12, boolean z10) {
        Intent intent = new Intent(this, BusCardOperateActivity.class);
        intent.putExtra("card_aid", this.f17493m.appAid);
        intent.putExtra("order_id", str);
        intent.putExtra("order_type", this.f17496p);
        intent.putExtra("pay_money", i10);
        intent.putExtra("order_money", i11);
        intent.putExtra("pay_way", i12);
        intent.putExtra("order_time", str2);
        intent.putExtra("abnormal_order", z10);
        if (qd.a.c(this.f17493m)) {
            intent.putExtra("main_order_id", this.f17501u);
        }
        startActivity(intent);
        finish();
    }

    private void j0() {
        String h10 = this.f17493m.h();
        if (!TextUtils.isEmpty(h10)) {
            Intent intent = new Intent(BasicBrowserActivity.ACTION);
            intent.putExtra("url", h10);
            intent.putExtra(BasicBrowserActivity.KEY_FLAG_GOBACK, true);
            intent.putExtra(BasicBrowserActivity.KEY_TITLE, getString(m.f33088p));
            intent.setPackage(getPackageName());
            startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void k0(DialogInterface dialogInterface, int i10) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l0(DialogInterface dialogInterface, int i10) {
        f0();
    }

    private void m0() {
        boolean z10 = true;
        this.f17486f.setSelected(this.f17494n == 2000);
        this.f17487g.setSelected(this.f17494n == 5000);
        this.f17488h.setSelected(this.f17494n == 10000);
        this.f17489i.setSelected(this.f17494n == 20000);
        this.f17491k.setText(sd.c.o(this.f17495o));
        this.f17492l.setText(sd.c.o(this.f17494n));
        this.f17490j.setText(getString(m.D0, new Object[]{sd.c.o(this.f17495o + this.f17494n)}));
        Button button = this.f17490j;
        if (!this.f17500t && this.f17495o + this.f17494n <= 0) {
            z10 = false;
        }
        button.setEnabled(z10);
    }

    private void n0() {
        k.a("BusCardRecharge", "show hlht alert dialog.");
        new k7.b(this).h(m.P).d(true).j(m.f33064h, ud.c.f35371a).m(m.f33076l, new DialogInterface.OnClickListener() { // from class: ud.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                BusCardRechargeActivity.this.l0(dialogInterface, i10);
            }
        }).a().show();
    }

    private void o0(String str) {
        if (this.f17499s == null) {
            ProgressDialog progressDialog = new ProgressDialog(this);
            this.f17499s = progressDialog;
            progressDialog.setCancelable(false);
        }
        this.f17499s.setMessage(str);
        this.f17499s.show();
    }

    private void p0(String str, String str2) {
        int i10 = this.f17495o + this.f17494n;
        if (i10 != 0 || !this.f17500t) {
            this.f17504x = str2;
            this.f17505y = str;
            td.b bVar = new td.b(this, this.f17506z);
            this.f17498r = bVar;
            int i11 = this.f17497q;
            if (i11 == 3) {
                q0(str);
            } else {
                bVar.b(i11, str, h0());
            }
        } else {
            i0(str2, i10, i10, sd.c.b(), this.f17497q, false);
        }
    }

    private void q0(String str) {
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
            k.c("BusCardRecharge", "weixin pay send req  %s , result %s", str, Boolean.valueOf(sendReq));
            if (sendReq) {
                b1.a.b(this).c(this.f17503w, new IntentFilter("action.WEIXIN_PAY"));
            } else {
                M(getString(m.f33045a1, new Object[]{getString(m.f33084n1), ""}), true);
            }
        } catch (Exception e11) {
            k.r("BusCardRecharge", "start weixin pay error ", e11, new Object[0]);
            M(getString(m.f33045a1, new Object[]{getString(m.f33084n1), e11.getLocalizedMessage()}), true);
        }
    }

    @Override // com.mobvoi.companion.base.m3.d
    protected int getLayoutId() {
        return qd.k.f33027c;
    }

    @Override // com.mobvoi.companion.ticpay.ui.c, com.mobvoi.android.common.utils.s.a
    public void handleMessage(Message message) {
        String str;
        int i10 = message.what;
        if (i10 == 3005) {
            this.f17499s.dismiss();
            Object obj = message.obj;
            if (obj instanceof BusinessOrder) {
                if (sd.b.h().i("A00000000386980701").j()) {
                    BusinessOrder businessOrder = (BusinessOrder) message.obj;
                    String valueOf = String.valueOf(x2.c.g(businessOrder.getOrder()));
                    k.c("BusCardRecharge", "shtAbnormalOrder id = %s", valueOf);
                    int amount = businessOrder.getAmount();
                    this.f17494n = amount;
                    m0();
                    i0(valueOf, amount, amount, valueOf, 4, true);
                }
            } else if (obj instanceof BusinessOrderInfo) {
                BusinessOrderInfo businessOrderInfo = (BusinessOrderInfo) obj;
                k.c("BusCardRecharge", "checkAbnormalOrder id = %s, type = %d, status = %d", businessOrderInfo.getOrderId(), Integer.valueOf(businessOrderInfo.getOrderType()), Integer.valueOf(businessOrderInfo.getOrderStatus()));
                this.f17494n = businessOrderInfo.getOrderMoney();
                m0();
                i0(businessOrderInfo.getOrderId(), businessOrderInfo.getPayMoney(), businessOrderInfo.getOrderMoney(), businessOrderInfo.getOrderTime(), businessOrderInfo.getPayWay(), true);
            } else {
                k.a("BusCardRecharge", "checkAbnormalOrder: no abnormal order.");
            }
        } else if (i10 == 3006) {
            this.f17499s.dismiss();
            Object obj2 = message.obj;
            if (obj2 instanceof BusinessException) {
                String d10 = sd.c.d((BusinessException) obj2);
                if (d10 != null && d10.endsWith("1106")) {
                    d10 = getString(m.f33097t);
                }
                L(d10);
            } else if (obj2 instanceof d) {
                d dVar = (d) obj2;
                this.f17501u = x2.c.g(dVar.e());
                cn.com.fmsh.tsm.business.bean.e[] f10 = dVar.f();
                if (f10 == null || f10.length <= 0) {
                    L(getString(m.f33045a1, new Object[]{"", ""}));
                    return;
                }
                cn.com.fmsh.tsm.business.bean.e eVar = f10[0];
                int b10 = eVar.b();
                String d11 = eVar.d();
                long g10 = x2.c.g(eVar.c());
                k.c("BusCardRecharge", "sht new order,channel %s, orderId %s thirdPayInfo %s", Integer.valueOf(b10), Long.valueOf(g10), d11);
                p0(d11, String.valueOf(g10));
            } else {
                RespInfo respInfo = (RespInfo) obj2;
                int i11 = -1;
                PayOrderBusiRespInfo payOrderBusiRespInfo = null;
                if (respInfo != null) {
                    i11 = respInfo.getStatus();
                    String desc = respInfo.getDesc();
                    k.c("BusCardRecharge", "generate new order status = %d, desc = %s", Integer.valueOf(i11), desc);
                    payOrderBusiRespInfo = (PayOrderBusiRespInfo) respInfo.getBusiRespInfo();
                    str = desc;
                } else {
                    str = null;
                }
                if (i11 != 0 || payOrderBusiRespInfo == null || (TextUtils.isEmpty(payOrderBusiRespInfo.getPayReqInfo()) && this.f17495o + this.f17494n != 0)) {
                    if (!TextUtils.isEmpty(str)) {
                        L(str);
                    } else {
                        L(getString(m.f33045a1, new Object[]{String.valueOf(i11), str}));
                    }
                    k.a("BusCardRecharge", "Generate order fail");
                    return;
                }
                k.a("BusCardRecharge", "success generate new order");
                p0(payOrderBusiRespInfo.getPayReqInfo(), payOrderBusiRespInfo.getTranOrderId());
            }
        }
    }

    @Override // androidx.fragment.app.f, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        this.f17498r.a(i10, i11, intent);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id2 = view.getId();
        int i10 = 0;
        if (id2 == j.N) {
            if (!view.isSelected()) {
                i10 = 20000;
            }
            this.f17494n = i10;
            m0();
        } else if (id2 == j.M) {
            if (!view.isSelected()) {
                i10 = 2000;
            }
            this.f17494n = i10;
            m0();
        } else if (id2 == j.O) {
            if (!view.isSelected()) {
                i10 = 5000;
            }
            this.f17494n = i10;
            m0();
        } else if (id2 == j.L) {
            if (!view.isSelected()) {
                i10 = 10000;
            }
            this.f17494n = i10;
            m0();
        } else if (id2 == j.T) {
            if (this.f17500t && !this.f17485e.isChecked()) {
                Toast.makeText(this, m.f33075k1, 1).show();
            } else if (!this.f17500t || !"A00000063201010510009156000014A1".equalsIgnoreCase(this.f17493m.appAid)) {
                f0();
            } else {
                n0();
            }
        } else if (id2 == j.f33020w0) {
            j0();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.ticpay.ui.c, com.mobvoi.companion.base.m3.d, androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent.hasExtra("card_aid")) {
            String stringExtra = intent.getStringExtra("card_aid");
            this.f17496p = intent.getIntExtra("order_type", 2);
            this.f17493m = sd.b.h().i(stringExtra);
        }
        ud.a aVar = this.f17493m;
        if (aVar != null) {
            setTitle(aVar.name);
            ImageView imageView = (ImageView) findViewById(j.f32978b0);
            TextView textView = (TextView) findViewById(j.Q);
            TextView textView2 = (TextView) findViewById(j.f32977b);
            String stringExtra2 = intent.getStringExtra("image");
            String stringExtra3 = intent.getStringExtra("text1");
            String stringExtra4 = intent.getStringExtra("text2");
            d0.M0(imageView, stringExtra2);
            d0.M0(textView, stringExtra3);
            d0.M0(textView2, stringExtra4);
            this.f17485e = (CheckBox) findViewById(j.f32995k);
            this.f17486f = (Button) findViewById(j.M);
            this.f17487g = (Button) findViewById(j.O);
            this.f17488h = (Button) findViewById(j.L);
            this.f17489i = (Button) findViewById(j.N);
            this.f17490j = (Button) findViewById(j.T);
            this.f17491k = (TextView) findViewById(j.f32982d0);
            this.f17492l = (TextView) findViewById(j.f32988g0);
            this.f17486f.setOnClickListener(this);
            this.f17487g.setOnClickListener(this);
            this.f17488h.setOnClickListener(this);
            this.f17489i.setOnClickListener(this);
            this.f17490j.setOnClickListener(this);
            findViewById(j.f33020w0).setOnClickListener(this);
            imageView.setImageResource(this.f17493m.iconRes);
            if (this.f17493m.j()) {
                textView.setText(this.f17493m.f35369id);
                textView2.setText(sd.c.o(this.f17493m.balance));
            } else {
                textView.setText(m.f33065h0);
            }
            int i10 = this.f17496p;
            this.f17500t = i10 == 1 || i10 == 3;
            View findViewById = findViewById(j.H);
            View findViewById2 = findViewById(j.D);
            int i11 = this.f17496p;
            if (i11 == 1 || i11 == 3) {
                o0(getString(m.N));
                findViewById.setVisibility(0);
                if (this.f17496p == 1) {
                    findViewById2.setVisibility(8);
                    if ("A00000063201010510009156000014A1".equalsIgnoreCase(this.f17493m.appAid)) {
                        this.f17496p = 3;
                        if (sd.b.h().o()) {
                            this.f17494n = q.b(com.mobvoi.android.common.utils.b.e(), WearPath.TicPay.PAY, "bus_card_money_count", 10);
                        } else {
                            int b10 = q.b(com.mobvoi.android.common.utils.b.e(), WearPath.TicPay.PAY, "bus_card_money_count", 10);
                            if (b10 >= 500) {
                                this.f17494n = b10;
                            } else if (b10 == 123321) {
                                this.f17494n = 100;
                            } else {
                                this.f17494n = 5000;
                            }
                        }
                    }
                }
                this.f17495o = this.f17493m.applet.getCardPrice();
                m0();
                e0();
            } else {
                if (qd.a.c(this.f17493m)) {
                    this.f17486f.setVisibility(8);
                    this.f17487g.setVisibility(8);
                    this.f17489i.setVisibility(0);
                }
                this.f17494n = 10000;
                if (q.b(com.mobvoi.android.common.utils.b.e(), WearPath.TicPay.PAY, "bus_card_money_count", 10) == 123321) {
                    this.f17494n = 100;
                }
                findViewById(j.A).setVisibility(8);
                findViewById.setVisibility(8);
                m0();
            }
            String str = this.f17500t ? "ticpay_bus_page_open_card" : "ticpay_bus_page_recharge";
            HashMap hashMap = new HashMap();
            hashMap.put("buscard_type", this.f17493m.b());
            e.b().g(sd.b.h().m(), str, hashMap);
            return;
        }
        throw new IllegalArgumentException("Must have a card.");
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(l.f33042b, menu);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.ticpay.ui.c, com.mobvoi.companion.base.m3.d, androidx.appcompat.app.d, androidx.fragment.app.f, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ProgressDialog progressDialog = this.f17499s;
        if (progressDialog != null) {
            progressDialog.dismiss();
            this.f17499s = null;
        }
        b1.a.b(this).e(this.f17503w);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != j.f33015u) {
            return super.onOptionsItemSelected(menuItem);
        }
        Intent intent = new Intent(BasicBrowserActivity.ACTION);
        intent.setPackage(getPackageName());
        intent.putExtra("url", "https://activities.mobvoi.com/ticwatch-help2/page/v4/help-ticpay.html?from=ticpay&system=android");
        intent.putExtra(BasicBrowserActivity.KEY_FLAG_GOBACK, true);
        intent.putExtra(BasicBrowserActivity.KEY_TITLE, getString(m.f33090p1));
        startActivity(intent);
        return true;
    }
}
