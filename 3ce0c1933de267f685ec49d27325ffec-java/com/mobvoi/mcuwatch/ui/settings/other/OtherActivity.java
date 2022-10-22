package com.mobvoi.mcuwatch.ui.settings.other;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.mobvoi.assistant.account.AccountConstant;
import com.mobvoi.mcuwatch.engine.f;
import com.mobvoi.mcuwatch.engine.n;
import com.mobvoi.mcuwatch.engine.u;
import com.mobvoi.mcuwatch.ui.menstrualcycle.MenstrualDetailsActivity;
import com.mobvoi.mcuwatch.ui.menstrualcycle.MenstrualSettingActivity;
import com.mobvoi.mcuwatch.ui.settings.other.OtherActivity;
import gn.c;
import gn.p;
import ij.i;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import kj.d;
import kj.e;
import nj.q;
import sh.h;
import sh.k;
import wi.b;
import xi.a;
/* loaded from: classes2.dex */
public class OtherActivity extends b {

    /* renamed from: h  reason: collision with root package name */
    TextView f20148h;

    /* renamed from: i  reason: collision with root package name */
    SwitchMaterial f20149i;

    /* renamed from: j  reason: collision with root package name */
    TextView f20150j;

    /* renamed from: k  reason: collision with root package name */
    TextView f20151k;

    /* renamed from: l  reason: collision with root package name */
    LinearLayout f20152l;

    /* renamed from: m  reason: collision with root package name */
    LinearLayout f20153m;

    /* renamed from: n  reason: collision with root package name */
    LinearLayout f20154n;

    /* renamed from: o  reason: collision with root package name */
    private a f20155o;

    /* renamed from: p  reason: collision with root package name */
    private Dialog f20156p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f20157q;

    /* renamed from: r  reason: collision with root package name */
    private int f20158r;

    /* renamed from: s  reason: collision with root package name */
    private final int[] f20159s = {2, 16, 32, 64, 128, 8192, 8, 256};

    /* renamed from: t  reason: collision with root package name */
    private final ArrayList<Integer> f20160t = new ArrayList<>();

    /* renamed from: u  reason: collision with root package name */
    private boolean f20161u;

    public OtherActivity() {
        n nVar = n.f19178a;
        this.f20157q = nVar.u();
        this.f20158r = nVar.m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a0(int i10) {
        this.f20148h.setText(getString(k.f34886w2, new Object[]{Integer.valueOf(i10)}));
        this.f20158r = i10;
        M(1, Integer.valueOf(i10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b0(Object[] objArr) {
        if (((Boolean) objArr[0]).booleanValue()) {
            f.x(u.f19202a, ((Integer) objArr[1]).intValue(), 1);
        } else {
            f.x(u.f19202a, ((Integer) objArr[1]).intValue(), 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c0(Object[] objArr) {
        f.l(u.f19202a, ((Integer) objArr[0]).intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d0(DialogInterface dialogInterface, int i10) {
        this.f20156p.dismiss();
    }

    private void f0(int i10, int i11) {
        TextView textView = (TextView) findViewById(i11);
        Drawable drawable = getResources().getDrawable(i10);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        drawable.setTintList(ColorStateList.valueOf(this.f20161u ? -16777216 : -1));
        textView.setCompoundDrawables(drawable, null, null, null);
    }

    private void g0() {
        if (this.f20156p == null) {
            this.f20156p = new k7.b(this).h(k.N0).d(false).m(k.f34853q0, new DialogInterface.OnClickListener() { // from class: kj.c
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i10) {
                    OtherActivity.this.d0(dialogInterface, i10);
                }
            }).a();
        }
        if (!this.f20156p.isShowing()) {
            this.f20156p.show();
        }
    }

    private void h0() {
        String k10 = n.f19178a.k();
        k10.hashCode();
        char c10 = 65535;
        switch (k10.hashCode()) {
            case -1475608862:
                if (k10.equals("language_france")) {
                    c10 = 0;
                    break;
                }
                break;
            case -1458480051:
                if (k10.equals("language_german")) {
                    c10 = 1;
                    break;
                }
                break;
            case 93777148:
                if (k10.equals("language_italy")) {
                    c10 = 2;
                    break;
                }
                break;
            case 94148703:
                if (k10.equals("language_japan")) {
                    c10 = 3;
                    break;
                }
                break;
            case 96159501:
                if (k10.equals("language_spanish")) {
                    c10 = 4;
                    break;
                }
                break;
            case 102135809:
                if (k10.equals("language_rusia")) {
                    c10 = 5;
                    break;
                }
                break;
            case 504233097:
                if (k10.equals("language_english")) {
                    c10 = 6;
                    break;
                }
                break;
            case 1652559685:
                if (k10.equals("language_portugal")) {
                    c10 = 7;
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
                this.f20151k.setText(getString(k.W3));
                return;
            case 1:
                this.f20151k.setText(getString(k.X3));
                return;
            case 2:
                this.f20151k.setText(getString(k.Y3));
                return;
            case 3:
                this.f20151k.setText(getString(k.Z3));
                return;
            case 4:
                this.f20151k.setText(getString(k.f34785c4));
                return;
            case 5:
                this.f20151k.setText(getString(k.f34779b4));
                return;
            case 6:
                this.f20151k.setText(getString(k.V3));
                return;
            case 7:
                this.f20151k.setText(k.f34773a4);
                return;
            default:
                this.f20151k.setText(getString(k.U3));
                return;
        }
    }

    public static void start(Context context) {
        context.startActivity(new Intent(context, OtherActivity.class));
    }

    @Override // wi.e
    protected Class<i> I() {
        return i.class;
    }

    @Override // wi.e
    protected boolean K() {
        return true;
    }

    @Override // wi.b
    protected void N() {
        int i10 = this.f36241d;
        if (i10 == 0) {
            this.f20149i.setChecked(n.f19178a.u());
            T();
        } else if (i10 == 1) {
            this.f20148h.setText(getString(k.f34886w2, new Object[]{Integer.valueOf(n.f19178a.m())}));
            T();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // wi.b
    public void Q() {
        this.f36243f = false;
        a aVar = new a(this, getResources().getIntArray(sh.b.u_res_0x7f030043));
        this.f20155o = aVar;
        aVar.q(new a.c() { // from class: kj.f
            @Override // xi.a.c
            public final void a(int i10) {
                OtherActivity.this.a0(i10);
            }
        });
        this.f36242e.put(0, d.f29992a);
        this.f36242e.put(1, e.f29993a);
        super.Q();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: Z */
    public i H() {
        return new i();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e0(CompoundButton compoundButton, boolean z10) {
        if (compoundButton.getId() == h.f34618b3) {
            this.f20157q = z10;
            M(0, Boolean.valueOf(z10), Integer.valueOf("imperial".equals(com.mobvoi.companion.base.settings.a.getUnit(this)) ? 2 : 1));
        }
    }

    @Override // com.mobvoi.companion.base.m3.d
    protected int getLayoutId() {
        return sh.i.f34766z;
    }

    @Override // wi.b
    protected void initView() {
        int[] iArr;
        setTitle(k.f34802f4);
        this.f20161u = j7.a.f(j7.a.b(this, 16842801, -1));
        f0(sh.f.f34605z0, h.J1);
        f0(sh.f.A0, h.V3);
        f0(sh.f.f34541e, h.f34690r3);
        f0(sh.f.S0, h.L3);
        f0(sh.f.f34558j1, h.f34659k4);
        this.f20148h = (TextView) findViewById(h.U3);
        this.f20149i = (SwitchMaterial) findViewById(h.f34618b3);
        this.f20150j = (TextView) findViewById(h.f34651i4);
        this.f20151k = (TextView) findViewById(h.H3);
        this.f20152l = (LinearLayout) findViewById(h.P1);
        this.f20153m = (LinearLayout) findViewById(h.E1);
        this.f20154n = (LinearLayout) findViewById(h.L1);
        if (!p.h(this, 32768) || ta.a.t() != AccountConstant.Sex.FEMALE.ordinal()) {
            this.f20154n.setVisibility(8);
        } else {
            this.f20154n.setVisibility(0);
            this.f20154n.setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.mcuwatch.ui.settings.other.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    OtherActivity.this.onClick(view);
                }
            });
        }
        if (!yd.b.c(this)) {
            this.f20152l.setVisibility(8);
        } else {
            for (int i10 : this.f20159s) {
                if (c.c(i10) || q.g().l() == 1) {
                    this.f20160t.add(Integer.valueOf(i10));
                }
            }
            if (this.f20160t.size() > 1) {
                this.f20153m.setVisibility(0);
            }
        }
        SwitchMaterial switchMaterial = this.f20149i;
        n nVar = n.f19178a;
        switchMaterial.setChecked(nVar.u());
        this.f20148h.setText(getString(k.f34886w2, new Object[]{Integer.valueOf(nVar.m())}));
        findViewById(h.J1).setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.mcuwatch.ui.settings.other.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OtherActivity.this.onClick(view);
            }
        });
        findViewById(h.N1).setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.mcuwatch.ui.settings.other.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OtherActivity.this.onClick(view);
            }
        });
        this.f20152l.setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.mcuwatch.ui.settings.other.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OtherActivity.this.onClick(view);
            }
        });
        this.f20153m.setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.mcuwatch.ui.settings.other.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OtherActivity.this.onClick(view);
            }
        });
        this.f20149i.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.mobvoi.mcuwatch.ui.settings.other.c
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                OtherActivity.this.e0(compoundButton, z10);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onClick(View view) {
        int id2 = view.getId();
        if (id2 == h.J1) {
            f.e(u.f19202a);
            g0();
        } else if (id2 == h.N1) {
            this.f20155o.show();
        } else if (id2 == h.P1) {
            startActivity(new Intent(this, TemperatureSettingActivity.class));
        } else if (id2 == h.E1) {
            Intent intent = new Intent(this, DeviceLanguageCheckActivity.class);
            intent.putIntegerArrayListExtra("display_lang", this.f20160t);
            startActivity(intent);
        } else if (id2 != h.L1) {
        } else {
            if (aj.a.f215a.f()) {
                MenstrualDetailsActivity.f19757j.a(this);
            } else {
                MenstrualSettingActivity.f19771i.a(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.f, android.app.Activity
    public void onResume() {
        super.onResume();
        u.f19202a.i0(new WeakReference<>(this));
        if (com.mobvoi.companion.base.settings.a.isTempCelsius(this)) {
            this.f20150j.setText(getString(k.f34898y3));
        } else {
            this.f20150j.setText(getString(k.f34903z3));
        }
        h0();
    }

    @Override // com.mobvoi.mcuwatch.engine.m
    public void p() {
        int i10 = this.f36241d;
        if (i10 == 0) {
            n.f19178a.L(this.f20157q);
            T();
        } else if (i10 == 1) {
            n.f19178a.Z(this.f20158r);
            T();
        }
    }
}
