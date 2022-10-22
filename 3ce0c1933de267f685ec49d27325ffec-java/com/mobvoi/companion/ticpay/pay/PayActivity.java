package com.mobvoi.companion.ticpay.pay;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import qd.j;
import qd.k;
/* loaded from: classes2.dex */
public class PayActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    private ImageButton f17420a;

    /* renamed from: b  reason: collision with root package name */
    private Button f17421b;

    /* renamed from: c  reason: collision with root package name */
    private PayListView f17422c;

    /* renamed from: d  reason: collision with root package name */
    private int f17423d = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PayActivity.this.setResult(0);
            PayActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PayActivity.this.setResult(0);
            PayActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int payWayIndex = PayActivity.this.f17422c.getPayWayIndex();
            Intent intent = new Intent();
            intent.putExtra("payway", payWayIndex);
            PayActivity.this.setResult(-1, intent);
            PayActivity.this.finish();
        }
    }

    private void b() {
        this.f17423d = getIntent().getIntExtra("enable", -1);
    }

    private void c() {
        this.f17420a.setOnClickListener(new b());
        this.f17421b.setOnClickListener(new c());
    }

    private void d() {
        findViewById(j.f33022x0).setOnClickListener(new a());
        this.f17420a = (ImageButton) findViewById(j.f33021x);
        this.f17421b = (Button) findViewById(j.f32979c);
        PayListView payListView = (PayListView) findViewById(j.J);
        this.f17422c = payListView;
        payListView.setPayEnable(this.f17423d);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(k.f33030f);
        b();
        d();
        c();
    }
}
