package com.mobvoi.companion.ticpay.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;
import com.mobvoi.android.common.utils.q;
import com.mobvoi.companion.base.m3.d;
import com.mobvoi.wear.common.base.WearPath;
import qd.j;
import qd.k;
import sd.b;
/* loaded from: classes2.dex */
public class PayDebugActivity extends d implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private CheckBox f17511a;

    /* renamed from: b  reason: collision with root package name */
    private CheckBox f17512b;

    /* renamed from: c  reason: collision with root package name */
    private EditText f17513c;

    /* renamed from: d  reason: collision with root package name */
    private Button f17514d;

    /* renamed from: e  reason: collision with root package name */
    private Button f17515e;

    @Override // com.mobvoi.companion.base.m3.d
    protected int getLayoutId() {
        return k.f33029e;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
        if (compoundButton.getId() == j.V) {
            q.e(getApplication(), WearPath.TicPay.PAY, "bus_card_test_mode", z10);
        } else if (compoundButton.getId() == j.U) {
            q.e(getApplication(), WearPath.TicPay.PAY, "bus_card_alipay_mode", z10);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == j.X) {
            String obj = this.f17513c.getText().toString();
            int i10 = 10;
            if (!TextUtils.isEmpty(obj)) {
                try {
                    i10 = Integer.parseInt(obj);
                } catch (NumberFormatException unused) {
                    Toast.makeText(this, "请输入一个整数", 1).show();
                }
            }
            q.f(getApplication(), WearPath.TicPay.PAY, "bus_card_money_count", i10);
        } else if (view.getId() == j.Y) {
            String str = "SEID: " + b.h().l() + " CPLC: " + b.h().g();
            if (!TextUtils.isEmpty(str) && ud.d.a(this, str)) {
                Toast.makeText(this, "Success copy seid to clipboard: " + str, 0).show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.base.m3.d, androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f17511a = (CheckBox) findViewById(j.V);
        this.f17512b = (CheckBox) findViewById(j.U);
        this.f17513c = (EditText) findViewById(j.W);
        this.f17514d = (Button) findViewById(j.X);
        this.f17515e = (Button) findViewById(j.Y);
        boolean a10 = q.a(getApplication(), WearPath.TicPay.PAY, "bus_card_test_mode", false);
        boolean a11 = q.a(getApplication(), WearPath.TicPay.PAY, "bus_card_alipay_mode", false);
        this.f17511a.setChecked(a10);
        this.f17512b.setChecked(a11);
        this.f17511a.setOnCheckedChangeListener(this);
        this.f17512b.setOnCheckedChangeListener(this);
        this.f17514d.setOnClickListener(this);
        this.f17515e.setOnClickListener(this);
    }
}
