package com.mobvoi.mcuwatch.ui.settings.remind;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.TimePicker;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.mobvoi.mcuwatch.engine.f;
import com.mobvoi.mcuwatch.engine.n;
import com.mobvoi.mcuwatch.engine.u;
import com.mobvoi.mcuwatch.ui.settings.remind.SedentaryRemindActivity;
import ij.i;
import j7.a;
import java.util.Calendar;
import nj.j;
import sh.h;
import sh.k;
import wi.b;
/* loaded from: classes2.dex */
public class SedentaryRemindActivity extends b {

    /* renamed from: h  reason: collision with root package name */
    TextView f20192h;

    /* renamed from: i  reason: collision with root package name */
    TextView f20193i;

    /* renamed from: j  reason: collision with root package name */
    SwitchMaterial f20194j;

    /* renamed from: k  reason: collision with root package name */
    SwitchMaterial f20195k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f20196l;

    /* renamed from: m  reason: collision with root package name */
    private long f20197m;

    /* renamed from: n  reason: collision with root package name */
    private int f20198n;

    /* renamed from: o  reason: collision with root package name */
    private int f20199o;

    /* renamed from: p  reason: collision with root package name */
    private long f20200p;

    /* renamed from: q  reason: collision with root package name */
    private int f20201q;

    /* renamed from: r  reason: collision with root package name */
    private int f20202r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f20203s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f20204t;

    public SedentaryRemindActivity() {
        n nVar = n.f19178a;
        this.f20203s = nVar.D();
        this.f20204t = nVar.E();
    }

    private void Z() {
        if (this.f20197m <= 0 && this.f20200p <= 0) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(11, 8);
            calendar.set(12, 0);
            calendar.set(13, 0);
            g0(8, 0, calendar.getTimeInMillis(), true);
            calendar.set(11, 22);
            calendar.set(12, 0);
            calendar.set(13, 0);
            g0(22, 0, calendar.getTimeInMillis(), false);
        }
    }

    private int b0(long j10, int i10) {
        if (j10 <= 0) {
            return 0;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j10);
        return calendar.get(i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c0(Object[] objArr) {
        i0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d0(Object[] objArr) {
        i0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e0(Object[] objArr) {
        i0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f0(Calendar calendar, boolean z10, TimePicker timePicker, int i10, int i11) {
        calendar.set(11, i10);
        calendar.set(12, i11);
        calendar.set(13, 0);
        g0(i10, i11, calendar.getTimeInMillis(), z10);
    }

    private void g0(int i10, int i11, long j10, boolean z10) {
        this.f20196l = z10;
        TextView textView = this.f20192h;
        if (z10) {
            this.f20197m = j10;
            this.f20198n = i10;
            this.f20199o = i11;
        } else {
            this.f20200p = j10;
            this.f20201q = i10;
            this.f20202r = i11;
            textView = this.f20193i;
        }
        k0(j10, textView);
        M(2, new Object[0]);
    }

    private void i0() {
        boolean isChecked = this.f20194j.isChecked();
        f.p(u.f19202a, isChecked ? 1 : 0, this.f20198n, this.f20199o, this.f20201q, this.f20202r, this.f20195k.isChecked());
    }

    private void j0(long j10, final boolean z10) {
        final Calendar calendar = Calendar.getInstance();
        if (j10 > 0) {
            calendar.setTimeInMillis(j10);
        }
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, j.c(this), new TimePickerDialog.OnTimeSetListener() { // from class: lj.d
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public final void onTimeSet(TimePicker timePicker, int i10, int i11) {
                SedentaryRemindActivity.this.f0(calendar, z10, timePicker, i10, i11);
            }
        }, calendar.get(11), calendar.get(12), true);
        timePickerDialog.show();
        int b10 = a.b(this, 16842806, -7829368);
        timePickerDialog.getButton(-1).setTextColor(b10);
        timePickerDialog.getButton(-2).setTextColor(b10);
    }

    private void k0(long j10, TextView textView) {
        if (j10 > 0) {
            textView.setText(nj.u.a(j10));
        } else {
            textView.setText("");
        }
    }

    public static void start(Context context) {
        context.startActivity(new Intent(context, SedentaryRemindActivity.class));
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
            this.f20194j.setChecked(n.f19178a.D());
            T();
        } else if (i10 == 1) {
            this.f20195k.setChecked(n.f19178a.E());
            T();
        } else if (i10 == 2) {
            if (this.f20196l) {
                k0(n.f19178a.q(), this.f20192h);
            } else {
                k0(n.f19178a.h(), this.f20193i);
            }
            T();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // wi.b
    public void Q() {
        super.Q();
        n nVar = n.f19178a;
        long q5 = nVar.q();
        this.f20197m = q5;
        this.f20198n = b0(q5, 11);
        this.f20199o = b0(this.f20197m, 12);
        long h10 = nVar.h();
        this.f20200p = h10;
        this.f20201q = b0(h10, 11);
        this.f20202r = b0(this.f20200p, 12);
        this.f36242e.put(0, new b.a() { // from class: lj.g
            @Override // wi.b.a
            public final void a(Object[] objArr) {
                SedentaryRemindActivity.this.c0(objArr);
            }
        });
        this.f36242e.put(1, new b.a() { // from class: lj.e
            @Override // wi.b.a
            public final void a(Object[] objArr) {
                SedentaryRemindActivity.this.d0(objArr);
            }
        });
        this.f36242e.put(2, new b.a() { // from class: lj.f
            @Override // wi.b.a
            public final void a(Object[] objArr) {
                SedentaryRemindActivity.this.e0(objArr);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a0 */
    public i H() {
        return new i();
    }

    @Override // com.mobvoi.companion.base.m3.d
    protected int getLayoutId() {
        return sh.i.C;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h0(CompoundButton compoundButton, boolean z10) {
        int id2 = compoundButton.getId();
        if (id2 == h.f34691r4) {
            this.f20203s = z10;
            Z();
            M(0, new Object[0]);
        } else if (id2 == h.Q0) {
            this.f20204t = z10;
            M(1, new Object[0]);
        }
    }

    @Override // wi.b
    protected void initView() {
        this.f20192h = (TextView) findViewById(h.f34637f4);
        this.f20193i = (TextView) findViewById(h.J3);
        this.f20194j = (SwitchMaterial) findViewById(h.f34691r4);
        this.f20195k = (SwitchMaterial) findViewById(h.Q0);
        setTitle(k.G4);
        SwitchMaterial switchMaterial = this.f20194j;
        n nVar = n.f19178a;
        switchMaterial.setChecked(nVar.D());
        this.f20195k.setChecked(nVar.E());
        Z();
        k0(this.f20197m, this.f20192h);
        k0(this.f20200p, this.f20193i);
        this.f20194j.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.mobvoi.mcuwatch.ui.settings.remind.e
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                SedentaryRemindActivity.this.h0(compoundButton, z10);
            }
        });
        this.f20195k.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.mobvoi.mcuwatch.ui.settings.remind.e
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                SedentaryRemindActivity.this.h0(compoundButton, z10);
            }
        });
        findViewById(h.G1).setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.mcuwatch.ui.settings.remind.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SedentaryRemindActivity.this.onClick(view);
            }
        });
        findViewById(h.F1).setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.mcuwatch.ui.settings.remind.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SedentaryRemindActivity.this.onClick(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onClick(View view) {
        int id2 = view.getId();
        if (id2 == h.G1) {
            j0(this.f20197m, true);
        } else if (id2 == h.F1) {
            j0(this.f20200p, false);
        }
    }

    @Override // com.mobvoi.mcuwatch.engine.m
    public void p() {
        int i10 = this.f36241d;
        if (i10 == 0) {
            n.f19178a.d0(this.f20203s);
            T();
        } else if (i10 == 1) {
            n.f19178a.e0(this.f20204t);
            T();
        } else if (i10 == 2) {
            if (this.f20196l) {
                n.f19178a.h0(this.f20197m);
            } else {
                n.f19178a.T(this.f20200p);
            }
            T();
        }
    }
}
