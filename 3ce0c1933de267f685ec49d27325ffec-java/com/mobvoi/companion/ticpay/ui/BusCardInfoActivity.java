package com.mobvoi.companion.ticpay.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.view.d0;
import cn.com.fmsh.tsm.business.exception.BusinessException;
import com.bjleisen.iface.sdk.bean.resp.RespInfo;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.android.common.utils.s;
import java.util.HashMap;
import qd.e;
import qd.f;
import qd.j;
import qd.l;
import qd.m;
import sd.b;
import sd.c;
import ud.a;
/* loaded from: classes2.dex */
public class BusCardInfoActivity extends c implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    private a f17450e;

    /* renamed from: f  reason: collision with root package name */
    private ProgressDialog f17451f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f17452g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f17453h;

    /* renamed from: i  reason: collision with root package name */
    private s f17454i = new s(this);

    private void N() {
        U(getString(m.T));
        a aVar = this.f17450e;
        String str = aVar.ssdAid;
        if (str == null) {
            k.s("BusCardInfoActivity", "delete ssd error , card  %s", aVar);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("param", str);
        f.q(this.f17454i, 3004, bundle);
    }

    private void O() {
        U(getString(m.S));
        a aVar = this.f17450e;
        String str = aVar.appAid;
        if (str == null) {
            k.s("BusCardInfoActivity", "delete applet error , card  %s", aVar);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("param", str);
        bundle.putString("card_aid", this.f17450e.appAid);
        f.q(this.f17454i, 3020, bundle);
    }

    private void Q() {
        ProgressDialog progressDialog = this.f17451f;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.f17451f.dismiss();
        }
    }

    private void S() {
        Intent intent = new Intent(this, AbnormalOrderActivity.class);
        intent.putExtra("card_aid", this.f17450e.appAid);
        intent.putExtra("charge_record", true);
        startActivity(intent);
    }

    private boolean T() {
        return !"9156000014010001".equalsIgnoreCase(this.f17450e.appAid);
    }

    private void U(String str) {
        if (this.f17451f == null) {
            this.f17451f = new ProgressDialog(this);
        }
        this.f17451f.setMessage(str);
        this.f17451f.setCancelable(false);
        this.f17451f.setCanceledOnTouchOutside(false);
        this.f17451f.show();
    }

    private void V() {
        Intent intent = new Intent(this, BusCardRechargeActivity.class);
        intent.putExtra("card_aid", this.f17450e.appAid);
        intent.putExtra("order_type", 2);
        startActivity(intent);
    }

    private void W() {
        Intent intent = new Intent(this, TradeInfoActivity.class);
        intent.putExtra("card_aid", this.f17450e.appAid);
        startActivity(intent);
    }

    @Override // com.mobvoi.companion.base.m3.d
    protected int getLayoutId() {
        return qd.k.f33025a;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0077  */
    @Override // com.mobvoi.companion.ticpay.ui.c, com.mobvoi.android.common.utils.s.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handleMessage(Message message) {
        boolean z10;
        int i10 = message.what;
        if (i10 == 3004) {
            Q();
            int intValue = ((Integer) message.obj).intValue();
            if (intValue == 100000) {
                Toast.makeText(this, "Delete success.", 0).show();
                this.f17450e.k();
                b1.a.b(getApplicationContext()).d(new Intent("action.DELETE_BUS_CARD"));
                finish();
                return;
            }
            Toast.makeText(this, "Delete error status = " + intValue, 0).show();
        } else if (i10 == 3020) {
            Q();
            int i11 = -1;
            if (qd.a.c(this.f17450e)) {
                Object obj = message.obj;
                if (!(obj instanceof BusinessException) && (obj instanceof Boolean)) {
                    z10 = ((Boolean) obj).booleanValue();
                    if (!z10) {
                        Toast.makeText(this, "Delete success.", 0).show();
                        this.f17450e.k();
                        b1.a.b(getApplicationContext()).d(new Intent("action.DELETE_BUS_CARD"));
                        finish();
                        return;
                    }
                    Toast.makeText(this, "Delete error status = " + i11, 0).show();
                    return;
                }
                z10 = false;
                if (!z10) {
                }
            } else {
                RespInfo respInfo = (RespInfo) message.obj;
                i11 = respInfo.getStatus();
                k.c("BusCardInfoActivity", "deleteApplet onPostExecute status = %d, desc = %s.", Integer.valueOf(i11), respInfo.getDesc());
                if (i11 == 0) {
                    z10 = true;
                    if (!z10) {
                    }
                }
                z10 = false;
                if (!z10) {
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != j.f32986f0) {
            return;
        }
        if (this.f17450e.j()) {
            V();
        } else {
            L(this.f17450e.g());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.ticpay.ui.c, com.mobvoi.companion.base.m3.d, androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ImageView imageView = (ImageView) findViewById(j.f32978b0);
        TextView textView = (TextView) findViewById(j.f32980c0);
        this.f17452g = (TextView) findViewById(j.f32977b);
        this.f17453h = (TextView) findViewById(j.f32983e);
        TextView textView2 = (TextView) findViewById(j.f33000m0);
        TextView textView3 = (TextView) findViewById(j.f32987g);
        TextView textView4 = (TextView) findViewById(j.f32989h);
        TextView textView5 = (TextView) findViewById(j.f33005p);
        findViewById(j.f32986f0).setOnClickListener(this);
        String stringExtra = getIntent().getStringExtra("image");
        String stringExtra2 = getIntent().getStringExtra("text1");
        String stringExtra3 = getIntent().getStringExtra("text2");
        d0.M0(imageView, stringExtra);
        d0.M0(textView, stringExtra2);
        d0.M0(this.f17452g, stringExtra3);
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("card_aid")) {
            this.f17450e = b.h().i(intent.getStringExtra("card_aid"));
        }
        a aVar = this.f17450e;
        if (aVar != null) {
            setTitle(aVar.name);
            imageView.setImageResource(this.f17450e.iconRes);
            textView.setText(this.f17450e.f35369id);
            textView3.setText(this.f17450e.f35369id);
            textView4.setText(c.l(this.f17450e.openDate));
            textView5.setText(c.l(this.f17450e.expireDate));
            if (this.f17450e.j()) {
                textView2.setVisibility(8);
            } else {
                textView2.setVisibility(0);
                textView2.setText(m.f33109z);
            }
            HashMap hashMap = new HashMap();
            hashMap.put("buscard_type", this.f17450e.b());
            e.b().g(b.h().m(), "ticpay_bus_page_card_info", hashMap);
            return;
        }
        throw new IllegalArgumentException("Must have a card.");
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(l.f33041a, menu);
        if (b.h().o()) {
            menu.findItem(j.f33003o).setVisible(true);
            if (T()) {
                menu.findItem(j.f33001n).setVisible(true);
            }
        }
        if (qd.a.c(this.f17450e)) {
            menu.findItem(j.f32993j).setVisible(true);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.ticpay.ui.c, com.mobvoi.companion.base.m3.d, androidx.appcompat.app.d, androidx.fragment.app.f, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Q();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == j.f33016u0) {
            W();
            return true;
        } else if (menuItem.getItemId() == j.f32993j) {
            S();
            return true;
        } else if (menuItem.getItemId() == j.f33003o) {
            N();
            return true;
        } else if (menuItem.getItemId() != j.f33001n) {
            return super.onOptionsItemSelected(menuItem);
        } else {
            O();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.f, android.app.Activity
    public void onResume() {
        super.onResume();
        String o10 = c.o(this.f17450e.balance);
        this.f17452g.setText(o10);
        this.f17453h.setText(o10);
    }
}
