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
import com.mobvoi.mcuwatch.ui.settings.remind.NotDisturbActivity;
import ij.i;
import j7.a;
import java.util.Calendar;
import nj.j;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.c;
import sh.h;
import sh.k;
import wi.b;
/* loaded from: classes2.dex */
public class NotDisturbActivity extends b {

    /* renamed from: h  reason: collision with root package name */
    SwitchMaterial f20180h;

    /* renamed from: i  reason: collision with root package name */
    TextView f20181i;

    /* renamed from: j  reason: collision with root package name */
    TextView f20182j;

    /* renamed from: k  reason: collision with root package name */
    private long f20183k;

    /* renamed from: l  reason: collision with root package name */
    private int f20184l;

    /* renamed from: m  reason: collision with root package name */
    private int f20185m;

    /* renamed from: n  reason: collision with root package name */
    private long f20186n;

    /* renamed from: o  reason: collision with root package name */
    private int f20187o;

    /* renamed from: p  reason: collision with root package name */
    private int f20188p;

    /* renamed from: q  reason: collision with root package name */
    private TextView f20189q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f20190r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f20191s = n.f19178a.A();

    private void Z() {
        n nVar = n.f19178a;
        long p10 = nVar.p();
        long g10 = nVar.g();
        Calendar calendar = Calendar.getInstance();
        if (p10 == 0) {
            calendar.set(11, 22);
            calendar.set(12, 0);
            calendar.set(13, 0);
            nVar.g0(calendar.getTimeInMillis());
        }
        if (g10 == 0) {
            calendar.set(11, 8);
            calendar.set(12, 0);
            calendar.set(13, 0);
            nVar.S(calendar.getTimeInMillis());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a0(Object[] objArr) {
        f.k(u.f19202a, ((Boolean) objArr[0]).booleanValue(), this.f20184l, this.f20185m, this.f20187o, this.f20188p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b0(Object[] objArr) {
        f.k(u.f19202a, ((Boolean) objArr[0]).booleanValue(), this.f20184l, this.f20185m, this.f20187o, this.f20188p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c0(Calendar calendar, boolean z10, TimePicker timePicker, int i10, int i11) {
        calendar.set(11, i10);
        calendar.set(12, i11);
        calendar.set(13, 0);
        d0(i10, i11, calendar.getTimeInMillis(), z10);
    }

    private void d0(int i10, int i11, long j10, boolean z10) {
        this.f20189q = this.f20181i;
        this.f20190r = z10;
        if (z10) {
            this.f20183k = j10;
            this.f20184l = i10;
            this.f20185m = i11;
        } else {
            this.f20186n = j10;
            this.f20187o = i10;
            this.f20188p = i11;
            this.f20189q = this.f20182j;
        }
        g0(j10, this.f20189q);
        M(1, Boolean.valueOf(this.f20180h.isChecked()));
    }

    private void f0(long j10, final boolean z10) {
        final Calendar calendar = Calendar.getInstance();
        if (j10 > 0) {
            calendar.setTimeInMillis(j10);
        }
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, j.c(this), new TimePickerDialog.OnTimeSetListener() { // from class: lj.a
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public final void onTimeSet(TimePicker timePicker, int i10, int i11) {
                NotDisturbActivity.this.c0(calendar, z10, timePicker, i10, i11);
            }
        }, calendar.get(11), calendar.get(12), true);
        timePickerDialog.show();
        int b10 = a.b(this, 16842806, -7829368);
        timePickerDialog.getButton(-1).setTextColor(b10);
        timePickerDialog.getButton(-2).setTextColor(b10);
    }

    private void g0(long j10, TextView textView) {
        if (j10 > 0) {
            textView.setText(nj.u.a(j10));
        } else {
            textView.setText("");
        }
    }

    public static void start(Context context) {
        context.startActivity(new Intent(context, NotDisturbActivity.class));
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
            this.f20180h.setChecked(n.f19178a.A());
            T();
        } else if (i10 == 1) {
            g0(this.f20190r ? n.f19178a.p() : n.f19178a.g(), this.f20189q);
            T();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // wi.b
    public void Q() {
        super.Q();
        if (!this.f20191s) {
            Z();
        }
        n nVar = n.f19178a;
        long p10 = nVar.p();
        this.f20183k = p10;
        this.f20184l = nj.u.c(p10, 11);
        this.f20185m = nj.u.c(this.f20183k, 12);
        long g10 = nVar.g();
        this.f20186n = g10;
        this.f20187o = nj.u.c(g10, 11);
        this.f20188p = nj.u.c(this.f20186n, 12);
        c.c().o(this);
        this.f36242e.put(0, new b.a() { // from class: lj.c
            @Override // wi.b.a
            public final void a(Object[] objArr) {
                NotDisturbActivity.this.a0(objArr);
            }
        });
        this.f36242e.put(1, new b.a() { // from class: lj.b
            @Override // wi.b.a
            public final void a(Object[] objArr) {
                NotDisturbActivity.this.b0(objArr);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: Y */
    public i H() {
        return new i();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e0(CompoundButton compoundButton, boolean z10) {
        if (compoundButton.getId() == h.c0_res_0x7f0b0139) {
            this.f20191s = z10;
            M(0, Boolean.valueOf(this.f20180h.isChecked()));
        }
    }

    @Override // com.mobvoi.companion.base.m3.d
    protected int getLayoutId() {
        return sh.i.f34762x;
    }

    @Override // wi.b
    protected void initView() {
        this.f20180h = (SwitchMaterial) findViewById(h.c0_res_0x7f0b0139);
        this.f20181i = (TextView) findViewById(h.f34637f4);
        this.f20182j = (TextView) findViewById(h.J3);
        setTitle(k.f34817i4);
        g0(this.f20183k, this.f20181i);
        g0(this.f20186n, this.f20182j);
        this.f20180h.setChecked(n.f19178a.A());
        this.f20180h.setOnCheckedChangeListener(new c(this));
        findViewById(h.G1).setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.mcuwatch.ui.settings.remind.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NotDisturbActivity.this.onClick(view);
            }
        });
        findViewById(h.F1).setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.mcuwatch.ui.settings.remind.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NotDisturbActivity.this.onClick(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onClick(View view) {
        int id2 = view.getId();
        if (id2 == h.G1) {
            f0(this.f20183k, true);
        } else if (id2 == h.F1) {
            f0(this.f20186n, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // wi.b, wi.e, com.mobvoi.companion.base.m3.d, androidx.appcompat.app.d, androidx.fragment.app.f, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        c.c().q(this);
    }

    @org.greenrobot.eventbus.k(threadMode = ThreadMode.MAIN)
    public void onJoinEvent(qc.a aVar) {
        if (aVar.b() == 1 && (aVar.a() instanceof Boolean)) {
            this.f20180h.setOnCheckedChangeListener(null);
            this.f20180h.setChecked(((Boolean) aVar.a()).booleanValue());
            this.f20180h.setOnCheckedChangeListener(new c(this));
        }
    }

    @Override // com.mobvoi.mcuwatch.engine.m
    public void p() {
        int i10 = this.f36241d;
        if (i10 == 0) {
            n.f19178a.Y(this.f20191s);
            T();
        } else if (i10 == 1) {
            if (this.f20190r) {
                n.f19178a.g0(this.f20183k);
            } else {
                n.f19178a.S(this.f20186n);
            }
            T();
        }
    }
}
