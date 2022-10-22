package com.mobvoi.mcuwatch.ui.settings.remind;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.app.c;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.mobvoi.mcuwatch.engine.n;
import com.mobvoi.mcuwatch.ui.settings.remind.SmartRemindActivity;
import ij.i;
import k7.b;
import kc.d;
import sh.h;
import sh.k;
import wi.e;
/* loaded from: classes2.dex */
public class SmartRemindActivity extends e<i> {

    /* renamed from: b  reason: collision with root package name */
    SwitchMaterial f20205b;

    /* renamed from: c  reason: collision with root package name */
    ConstraintLayout f20206c;

    /* renamed from: d  reason: collision with root package name */
    ConstraintLayout f20207d;

    /* renamed from: e  reason: collision with root package name */
    SwitchMaterial f20208e;

    /* renamed from: f  reason: collision with root package name */
    SwitchMaterial f20209f;

    /* renamed from: g  reason: collision with root package name */
    SwitchMaterial f20210g;

    /* renamed from: h  reason: collision with root package name */
    c f20211h;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S(View view) {
        SedentaryRemindActivity.start(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T(View view) {
        AppRemindActivity.start(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U(DialogInterface dialogInterface, int i10) {
        dialogInterface.dismiss();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V(DialogInterface dialogInterface, int i10) {
        startActivity(new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS"));
    }

    private void X() {
        this.f20211h = new b(this).h(k.e_res_0x7f140063).d(false).j(k.M1, new DialogInterface.OnClickListener() { // from class: lj.i
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                SmartRemindActivity.this.U(dialogInterface, i10);
            }
        }).m(k.N1, new DialogInterface.OnClickListener() { // from class: lj.h
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                SmartRemindActivity.this.V(dialogInterface, i10);
            }
        }).t();
    }

    private void initView() {
        this.f20205b = (SwitchMaterial) findViewById(h.d0_res_0x7f0b013a);
        this.f20206c = (ConstraintLayout) findViewById(h.G0);
        this.f20207d = (ConstraintLayout) findViewById(h.E0);
        this.f20208e = (SwitchMaterial) findViewById(h.i0_res_0x7f0b013f);
        this.f20209f = (SwitchMaterial) findViewById(h.k0_res_0x7f0b0141);
        TextView textView = (TextView) findViewById(h.f34641g3);
        this.f20210g = (SwitchMaterial) findViewById(h.l0_res_0x7f0b0142);
        setTitle(k.J3);
        SwitchMaterial switchMaterial = this.f20205b;
        n nVar = n.f19178a;
        switchMaterial.setChecked(nVar.y());
        this.f20208e.setChecked(nVar.F());
        this.f20209f.setChecked(nVar.I());
        this.f20210g.setChecked(nVar.G());
        this.f20207d.setOnClickListener(new View.OnClickListener() { // from class: lj.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SmartRemindActivity.this.S(view);
            }
        });
        this.f20206c.setOnClickListener(new View.OnClickListener() { // from class: lj.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SmartRemindActivity.this.T(view);
            }
        });
        this.f20205b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.mobvoi.mcuwatch.ui.settings.remind.f
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                SmartRemindActivity.this.W(compoundButton, z10);
            }
        });
        this.f20208e.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.mobvoi.mcuwatch.ui.settings.remind.f
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                SmartRemindActivity.this.W(compoundButton, z10);
            }
        });
        this.f20209f.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.mobvoi.mcuwatch.ui.settings.remind.f
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                SmartRemindActivity.this.W(compoundButton, z10);
            }
        });
        this.f20210g.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.mobvoi.mcuwatch.ui.settings.remind.f
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                SmartRemindActivity.this.W(compoundButton, z10);
            }
        });
    }

    public static void start(Context context) {
        context.startActivity(new Intent(context, SmartRemindActivity.class));
    }

    @Override // wi.e
    protected Class<i> I() {
        return i.class;
    }

    @Override // wi.e
    protected boolean K() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: Q */
    public i H() {
        return new i();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void W(CompoundButton compoundButton, boolean z10) {
        int id2 = compoundButton.getId();
        if (id2 == h.d0_res_0x7f0b013a) {
            n.f19178a.V(z10);
        } else if (id2 == h.i0_res_0x7f0b013f) {
            n.f19178a.f0(z10);
        } else if (id2 == h.k0_res_0x7f0b0141) {
            n.f19178a.m0(z10);
        } else if (id2 == h.l0_res_0x7f0b0142) {
            n.f19178a.k0(z10);
        }
    }

    @Override // com.mobvoi.companion.base.m3.d
    protected int getLayoutId() {
        return sh.i.F;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // wi.e, com.mobvoi.companion.base.m3.d, androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.f, android.app.Activity
    public void onResume() {
        super.onResume();
        if (!d.a(this)) {
            X();
            return;
        }
        c cVar = this.f20211h;
        if (cVar != null && cVar.isShowing()) {
            this.f20211h.dismiss();
        }
    }
}
