package com.mobvoi.mcuwatch.ui.settings.other;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import com.mobvoi.companion.base.settings.a;
import com.mobvoi.mcuwatch.ui.settings.other.TemperatureSettingActivity;
import ij.i;
import sh.h;
import sh.k;
import wi.b;
/* loaded from: classes2.dex */
public class TemperatureSettingActivity extends b {

    /* renamed from: h  reason: collision with root package name */
    ImageView f20162h;

    /* renamed from: i  reason: collision with root package name */
    ImageView f20163i;

    /* renamed from: j  reason: collision with root package name */
    private String f20164j;

    private void X() {
        if (a.isTempCelsius(this)) {
            this.f20162h.setVisibility(0);
            this.f20163i.setVisibility(8);
            return;
        }
        this.f20162h.setVisibility(8);
        this.f20163i.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y(Object[] objArr) {
        a0(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z(Object[] objArr) {
        a0(1);
    }

    private void a0(int i10) {
        Intent intent = new Intent("com.mobvoi.ticpod.service.ACTION_UPDATE_USER_SETTING_GOAL");
        intent.putExtra("tmp_unit", i10);
        sendBroadcast(intent);
    }

    @Override // wi.e
    protected Class<i> I() {
        return i.class;
    }

    @Override // wi.b
    protected void N() {
        int i10 = this.f36241d;
        if (i10 == 0 || i10 == 1) {
            X();
            T();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // wi.b
    public void Q() {
        super.Q();
        this.f36242e.put(0, new b.a() { // from class: kj.g
            @Override // wi.b.a
            public final void a(Object[] objArr) {
                TemperatureSettingActivity.this.Y(objArr);
            }
        });
        this.f36242e.put(1, new b.a() { // from class: kj.h
            @Override // wi.b.a
            public final void a(Object[] objArr) {
                TemperatureSettingActivity.this.Z(objArr);
            }
        });
    }

    @Override // com.mobvoi.companion.base.m3.d
    protected int getLayoutId() {
        return sh.i.H;
    }

    @Override // wi.b
    protected void initView() {
        setTitle(k.f34893x3);
        this.f20162h = (ImageView) findViewById(h.f34704v1);
        this.f20163i = (ImageView) findViewById(h.f34714x1);
        X();
        this.f20164j = a.getTempUnit(this);
        findViewById(h.D1).setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.mcuwatch.ui.settings.other.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TemperatureSettingActivity.this.onClick(view);
            }
        });
        findViewById(h.H1).setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.mcuwatch.ui.settings.other.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TemperatureSettingActivity.this.onClick(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onClick(View view) {
        int id2 = view.getId();
        if (id2 == h.D1) {
            this.f20162h.setVisibility(0);
            this.f20163i.setVisibility(8);
            this.f20164j = "celsius";
            M(0, new Object[0]);
        } else if (id2 == h.H1) {
            this.f20162h.setVisibility(8);
            this.f20163i.setVisibility(0);
            this.f20164j = "fahrenheit";
            M(1, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // wi.b, wi.e, com.mobvoi.companion.base.m3.d, androidx.appcompat.app.d, androidx.fragment.app.f, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f36240c.removeCallbacks(this.f36244g);
    }

    @Override // com.mobvoi.mcuwatch.engine.m
    public void p() {
        int i10 = this.f36241d;
        if (i10 == 0 || i10 == 1) {
            a.setTempUnit(this, this.f20164j);
            T();
        }
    }
}
