package com.mobvoi.ticcare.ui;

import ak.c;
import ak.d;
import ak.e;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.mobvoi.companion.base.m3.a;
import kk.k;
/* loaded from: classes2.dex */
public class TicCareSettingMainActivity extends a implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private TextView f20792a;

    /* renamed from: b  reason: collision with root package name */
    private View f20793b;

    /* renamed from: c  reason: collision with root package name */
    private View f20794c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f20795d;

    /* renamed from: e  reason: collision with root package name */
    private ImageView f20796e;

    /* renamed from: f  reason: collision with root package name */
    protected Toolbar f20797f;

    /* renamed from: g  reason: collision with root package name */
    private int f20798g;

    /* renamed from: h  reason: collision with root package name */
    private int f20799h;

    private void I(jk.a aVar) {
        getSupportFragmentManager().l().s(d.j_res_0x7f0b029c, aVar).j();
    }

    protected void G() {
        androidx.core.app.a.p(this);
    }

    protected void H() {
        I(new kk.d());
        TypedArray obtainStyledAttributes = getTheme().obtainStyledAttributes(new int[]{16842808, 16843827});
        this.f20799h = obtainStyledAttributes.getColor(0, -7829368);
        this.f20798g = obtainStyledAttributes.getColor(1, -7829368);
        obtainStyledAttributes.recycle();
    }

    protected void initView() {
        TextView textView = (TextView) findViewById(d.Q);
        TextView textView2 = (TextView) findViewById(d.P_res_0x7f0b0864);
        Toolbar toolbar = (Toolbar) findViewById(d.G);
        this.f20797f = toolbar;
        toolbar.setNavigationIcon(c.f220a);
        setSupportActionBar(this.f20797f);
        androidx.appcompat.app.a supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.t(true);
            supportActionBar.u(false);
        }
        FrameLayout frameLayout = (FrameLayout) findViewById(d.j_res_0x7f0b029c);
        this.f20792a = (TextView) findViewById(d.e_res_0x7f0b0176);
        this.f20793b = findViewById(d.d_res_0x7f0b0175);
        this.f20795d = (TextView) findViewById(d.o_res_0x7f0b0324);
        this.f20794c = findViewById(d.n_res_0x7f0b0323);
        ImageView imageView = (ImageView) findViewById(d.f232y);
        this.f20796e = imageView;
        imageView.setOnClickListener(this);
        this.f20792a.setOnClickListener(this);
        this.f20795d.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id2 = view.getId();
        if (id2 == d.f232y) {
            startActivity(new Intent(this, TicCareSettingActivity.class));
        } else if (id2 == d.e_res_0x7f0b0176) {
            this.f20792a.setTextColor(this.f20798g);
            this.f20793b.setVisibility(0);
            this.f20795d.setTextColor(this.f20799h);
            this.f20794c.setVisibility(8);
            I(new kk.d());
        } else if (id2 == d.o_res_0x7f0b0324) {
            this.f20792a.setTextColor(this.f20799h);
            this.f20793b.setVisibility(8);
            this.f20795d.setTextColor(this.f20798g);
            this.f20794c.setVisibility(0);
            I(new k());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.base.m3.a, androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(e.b_res_0x7f0e0057);
        initView();
        H();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        G();
        return true;
    }
}
