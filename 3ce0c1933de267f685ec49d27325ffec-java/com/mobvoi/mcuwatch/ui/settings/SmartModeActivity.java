package com.mobvoi.mcuwatch.ui.settings;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.mobvoi.mcuwatch.engine.f;
import com.mobvoi.mcuwatch.engine.n;
import com.mobvoi.mcuwatch.engine.u;
import com.mobvoi.mcuwatch.ui.settings.SmartModeActivity;
import com.mobvoi.mcuwatch.ui.settings.alarm.AlarmRemindActivity;
import com.mobvoi.mcuwatch.ui.settings.remind.NotDisturbActivity;
import ij.i;
import ij.m;
import ij.o;
import ij.p;
import ij.q;
import java.lang.ref.WeakReference;
import nj.j;
import sh.h;
import sh.k;
import wi.b;
/* loaded from: classes2.dex */
public class SmartModeActivity extends b {

    /* renamed from: h  reason: collision with root package name */
    SwitchMaterial f20007h;

    /* renamed from: i  reason: collision with root package name */
    SwitchMaterial f20008i;

    /* renamed from: j  reason: collision with root package name */
    SwitchMaterial f20009j;

    /* renamed from: k  reason: collision with root package name */
    SwitchMaterial f20010k;

    /* renamed from: l  reason: collision with root package name */
    SwitchMaterial f20011l;

    /* renamed from: m  reason: collision with root package name */
    RelativeLayout f20012m;

    /* renamed from: n  reason: collision with root package name */
    RelativeLayout f20013n;

    /* renamed from: o  reason: collision with root package name */
    RelativeLayout f20014o;

    /* renamed from: p  reason: collision with root package name */
    View f20015p;

    /* renamed from: q  reason: collision with root package name */
    RelativeLayout f20016q;

    /* renamed from: r  reason: collision with root package name */
    View f20017r;

    /* renamed from: s  reason: collision with root package name */
    RelativeLayout f20018s;

    /* renamed from: t  reason: collision with root package name */
    View f20019t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f20020u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f20021v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f20022w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f20023x;

    /* renamed from: y  reason: collision with root package name */
    private boolean f20024y;

    /* renamed from: z  reason: collision with root package name */
    private Handler f20025z = new Handler(Looper.getMainLooper());

    public SmartModeActivity() {
        n nVar = n.f19178a;
        this.f20020u = nVar.x();
        this.f20021v = nVar.B();
        this.f20022w = nVar.H();
        this.f20023x = nVar.w();
        this.f20024y = nVar.C();
    }

    private void e0() {
        this.f20007h = (SwitchMaterial) findViewById(h.f34633f0);
        this.f20009j = (SwitchMaterial) findViewById(h.f34638g0);
        this.f20008i = (SwitchMaterial) findViewById(h.f34643h0);
        this.f20010k = (SwitchMaterial) findViewById(h.e0_res_0x7f0b013b);
        this.f20012m = (RelativeLayout) findViewById(h.F0);
        this.f20011l = (SwitchMaterial) findViewById(h.j0_res_0x7f0b0140);
        this.f20013n = (RelativeLayout) findViewById(h.H0);
        this.f20014o = (RelativeLayout) findViewById(h.J2);
        this.f20015p = findViewById(h.W1);
        this.f20016q = (RelativeLayout) findViewById(h.K2);
        this.f20017r = findViewById(h.X1);
        this.f20018s = (RelativeLayout) findViewById(h.I2);
        this.f20019t = findViewById(h.V1);
        SwitchMaterial switchMaterial = this.f20007h;
        n nVar = n.f19178a;
        switchMaterial.setChecked(nVar.x());
        this.f20009j.setChecked(nVar.B());
        this.f20008i.setChecked(nVar.H());
        this.f20010k.setChecked(nVar.w());
        this.f20007h.setOnCheckedChangeListener(new b(this));
        this.f20009j.setOnCheckedChangeListener(new b(this));
        this.f20008i.setOnCheckedChangeListener(new b(this));
        this.f20010k.setOnCheckedChangeListener(new b(this));
        this.f20011l.setOnCheckedChangeListener(new b(this));
        this.f20012m.setOnClickListener(new View.OnClickListener() { // from class: ij.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SmartModeActivity.this.k0(view);
            }
        });
        this.f20013n.setOnClickListener(new View.OnClickListener() { // from class: ij.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SmartModeActivity.this.l0(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f0(Object[] objArr) {
        f.i(u.f19202a, ((Boolean) objArr[0]).booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void g0(Object[] objArr) {
        f.E(u.f19202a, ((Boolean) objArr[0]).booleanValue(), 10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void h0(Object[] objArr) {
        f.L(u.f19202a, ((Boolean) objArr[0]).booleanValue(), 10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void i0(Object[] objArr) {
        f.B(u.f19202a, ((Boolean) objArr[0]).booleanValue(), 10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void j0(Object[] objArr) {
        f.o(u.f19202a, ((Boolean) objArr[0]).booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k0(View view) {
        NotDisturbActivity.start(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l0(View view) {
        AlarmRemindActivity.start(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m0() {
        this.f20011l.setOnCheckedChangeListener(null);
        this.f20011l.setChecked(n.f19178a.C());
        this.f20011l.setOnCheckedChangeListener(new b(this));
    }

    private void o0() {
        this.f20025z.post(new Runnable() { // from class: ij.l
            @Override // java.lang.Runnable
            public final void run() {
                SmartModeActivity.this.m0();
            }
        });
    }

    private void p0(int i10, boolean z10) {
        if (i10 == h.f34633f0) {
            this.f20020u = z10;
            M(0, Boolean.valueOf(z10));
        } else if (i10 == h.f34638g0) {
            this.f20021v = z10;
            M(1, Boolean.valueOf(z10));
        } else if (i10 == h.f34643h0) {
            this.f20022w = z10;
            M(2, Boolean.valueOf(z10));
        } else if (i10 == h.e0_res_0x7f0b013b) {
            this.f20023x = z10;
            M(3, Boolean.valueOf(z10));
        } else if (i10 == h.j0_res_0x7f0b0140) {
            this.f20024y = z10;
            M(4, Boolean.valueOf(z10));
        }
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
            this.f20007h.setChecked(n.f19178a.x());
            T();
        } else if (i10 == 1) {
            this.f20009j.setChecked(n.f19178a.B());
            T();
        } else if (i10 == 2) {
            this.f20008i.setChecked(n.f19178a.H());
            T();
        } else if (i10 == 3) {
            this.f20010k.setChecked(n.f19178a.w());
            T();
        } else if (i10 == 4) {
            o0();
            T();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // wi.b
    public void Q() {
        this.f36243f = false;
        this.f36242e.put(0, p.f28296a);
        this.f36242e.put(1, ij.n.f28294a);
        this.f36242e.put(2, q.f28297a);
        this.f36242e.put(3, o.f28295a);
        this.f36242e.put(4, m.f28293a);
        super.Q();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: d0 */
    public i H() {
        return new i();
    }

    @Override // com.mobvoi.companion.base.m3.d
    protected int getLayoutId() {
        return sh.i.E;
    }

    @Override // wi.b
    protected void initView() {
        e0();
        setTitle(k.I3);
        if (!j.d(64)) {
            this.f20014o.setVisibility(8);
            this.f20015p.setVisibility(8);
        }
        if (!j.d(16384)) {
            this.f20018s.setVisibility(8);
            this.f20019t.setVisibility(8);
        }
        if (!j.d(8)) {
            this.f20016q.setVisibility(8);
            this.f20017r.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n0(CompoundButton compoundButton, boolean z10) {
        p0(compoundButton.getId(), z10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.f, android.app.Activity
    public void onResume() {
        super.onResume();
        u.f19202a.i0(new WeakReference<>(this));
        o0();
    }

    @Override // com.mobvoi.mcuwatch.engine.m
    public void p() {
        int i10 = this.f36241d;
        if (i10 == 0) {
            n.f19178a.U(this.f20020u);
            T();
        } else if (i10 == 1) {
            n.f19178a.a0(this.f20021v);
            T();
        } else if (i10 == 2) {
            n.f19178a.l0(this.f20022w);
            T();
        } else if (i10 == 3) {
            n.f19178a.R(this.f20023x);
            T();
        } else if (i10 == 4) {
            n.f19178a.b0(this.f20024y);
            T();
        }
    }
}
