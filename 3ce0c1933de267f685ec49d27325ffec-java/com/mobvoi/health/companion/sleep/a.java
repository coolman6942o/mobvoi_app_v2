package com.mobvoi.health.companion.sleep;

import aa.d;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.mobvoi.health.companion.sleep.a;
import com.mobvoi.health.companion.sleep.c;
import com.mobvoi.health.companion.sleep.view.SleepDetailBloodOxygenView;
import com.mobvoi.health.companion.sleep.view.SleepHeartRateView;
import com.mobvoi.health.companion.sleep.view.SleepTypePercentBar;
import com.mobvoi.health.companion.sleep.view.SleepTypeView;
import com.mobvoi.sleep.data.pojo.SleepRecord;
import fg.k;
import fg.o;
import fg.s;
import fg.t;
import fg.u;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import kh.d0;
import nf.e;
import nf.f;
import nf.g;
import nf.h;
import nf.j;
import nf.m;
/* compiled from: HealthSleepSharesFragment.java */
/* loaded from: classes2.dex */
public class a extends e implements f<d0> {
    private TextView A;
    private TextView B;
    private TextView C;
    private TextView D;
    private NestedScrollView E;
    private Button F;
    private String G;
    private String H;

    /* renamed from: d  reason: collision with root package name */
    private Bitmap f18597d;

    /* renamed from: f  reason: collision with root package name */
    private SleepTypeView f18599f;

    /* renamed from: g  reason: collision with root package name */
    private SleepTypePercentBar f18600g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f18601h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f18602i;

    /* renamed from: j  reason: collision with root package name */
    private TextView f18603j;

    /* renamed from: k  reason: collision with root package name */
    private TextView f18604k;

    /* renamed from: l  reason: collision with root package name */
    private TextView f18605l;

    /* renamed from: m  reason: collision with root package name */
    private TextView f18606m;

    /* renamed from: n  reason: collision with root package name */
    private TextView f18607n;

    /* renamed from: o  reason: collision with root package name */
    private TextView f18608o;

    /* renamed from: p  reason: collision with root package name */
    private TextView f18609p;

    /* renamed from: q  reason: collision with root package name */
    private TextView f18610q;

    /* renamed from: r  reason: collision with root package name */
    private TextView f18611r;

    /* renamed from: s  reason: collision with root package name */
    private TextView f18612s;

    /* renamed from: t  reason: collision with root package name */
    private SleepHeartRateView f18613t;

    /* renamed from: u  reason: collision with root package name */
    private SleepDetailBloodOxygenView f18614u;

    /* renamed from: v  reason: collision with root package name */
    private TextView f18615v;

    /* renamed from: w  reason: collision with root package name */
    private TextView f18616w;

    /* renamed from: x  reason: collision with root package name */
    private TextView f18617x;

    /* renamed from: y  reason: collision with root package name */
    private TextView f18618y;

    /* renamed from: z  reason: collision with root package name */
    private TextView f18619z;

    /* renamed from: e  reason: collision with root package name */
    private m f18598e = new m();
    private View.OnClickListener I = new View.OnClickListener() { // from class: sg.a
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            com.mobvoi.health.companion.sleep.a.this.e0(view);
        }
    };

    private Bitmap d0() {
        this.f18597d = Bitmap.createBitmap(this.E.getWidth(), this.E.getChildAt(0).getHeight() - d.a(70.0f), Bitmap.Config.ARGB_8888);
        this.E.draw(new Canvas(this.f18597d));
        return this.f18597d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e0(View view) {
        Bitmap d02;
        if (view.getId() == s.G2 && (d02 = d0()) != null) {
            new k(getContext()).execute(d02);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f0(h hVar, c.b bVar) {
        String str;
        String string = getString(u.f26877d4);
        if (bVar != null) {
            this.B.setText(bVar.f18637b.f20743g + string);
            String format = new SimpleDateFormat(getString(u.f26961r4)).format(Long.valueOf(bVar.f18637b.f20741e));
            String charSequence = zj.d.a(getActivity(), bVar.f18637b.f20740d).toString();
            String charSequence2 = zj.d.a(getActivity(), bVar.f18637b.f20741e).toString();
            String string2 = getString(u.f26889f4, charSequence, charSequence2);
            this.f18619z.setText(format + " " + string2);
            this.C.setText(charSequence);
            this.D.setText(charSequence2);
            int d10 = zj.d.d(bVar.f18637b.g(SleepRecord.TimeType.InBed));
            int i10 = d10 / 60;
            int i11 = d10 % 60;
            StringBuilder sb2 = new StringBuilder();
            if (i10 > 0) {
                sb2.append(i10);
                sb2.append(this.G);
                sb2.append(i11);
                sb2.append(this.H);
            } else {
                sb2.append(i11);
                sb2.append(this.H);
            }
            this.A.setText(sb2.toString());
            this.f18599f.setSleepRecord(bVar.f18637b);
            ArrayList arrayList = new ArrayList();
            arrayList.add(new sg.e(bVar.f18638c, bVar.f18643h, SleepRecord.TimeType.Awake));
            arrayList.add(new sg.e(bVar.f18639d, bVar.f18644i, SleepRecord.TimeType.Rem));
            arrayList.add(new sg.e(bVar.f18640e, bVar.f18645j, SleepRecord.TimeType.LightSleep));
            arrayList.add(new sg.e(bVar.f18641f, bVar.f18646k, SleepRecord.TimeType.DeepSleep));
            this.f18600g.setPercents(arrayList);
            this.f18601h.setText(getString(u.T4) + " " + bVar.f18638c + string);
            this.f18602i.setText(getString(u.W4) + " " + bVar.f18639d + string);
            this.f18603j.setText(getString(u.V4) + " " + bVar.f18640e + string);
            this.f18604k.setText(getString(u.U4) + " " + bVar.f18641f + string);
            g0(this.f18605l, bVar.f18643h);
            g0(this.f18606m, bVar.f18644i);
            g0(this.f18607n, bVar.f18645j);
            g0(this.f18608o, bVar.f18646k);
            SleepRecord sleepRecord = bVar.f18637b;
            this.f18613t.setSleepRecord(sleepRecord);
            if (sleepRecord != null) {
                this.f18612s.setVisibility(0);
                this.f18609p.setText(String.valueOf(Math.round(sleepRecord.f20744h)));
                TextView textView = this.f18610q;
                float f10 = sleepRecord.f20746j;
                String str2 = "-";
                textView.setText(f10 > 0.0f ? String.valueOf(Math.round(f10)) : str2);
                TextView textView2 = this.f18611r;
                float f11 = sleepRecord.f20745i;
                textView2.setText(f11 > 0.0f ? String.valueOf(Math.round(f11)) : str2);
                this.f18614u.c(sleepRecord.f(), sleepRecord.f20740d, sleepRecord.f20741e);
                if (sleepRecord.f() != null) {
                    yj.d f12 = sleepRecord.f();
                    String string3 = getString(u.X2);
                    TextView textView3 = this.f18616w;
                    if (f12.max > 0) {
                        str = f12.max + string3;
                    } else {
                        str = str2;
                    }
                    textView3.setText(str);
                    TextView textView4 = this.f18617x;
                    if (f12.min > 0) {
                        str2 = f12.min + string3;
                    }
                    textView4.setText(str2);
                    if (f12.avg > 0) {
                        this.f18615v.setText(f12.avg + string3);
                    }
                    this.f18618y.setVisibility(0);
                    if (sleepRecord.f().a()) {
                        this.f18618y.setTextColor(getResources().getColor(o.f26448b));
                        this.f18618y.setText(u.f26896h);
                        return;
                    }
                    this.f18618y.setTextColor(getResources().getColor(o.f26446a));
                    this.f18618y.setText(u.f26890g);
                    return;
                }
                this.f18616w.setText(str2);
                this.f18617x.setText(str2);
                return;
            }
            return;
        }
        this.f18601h.setText(getString(u.T4) + " 0" + string);
        this.f18602i.setText(getString(u.W4) + " 0" + string);
        this.f18603j.setText(getString(u.V4) + " 0" + string);
        this.f18604k.setText(getString(u.U4) + " 0" + string);
        g0(this.f18605l, 0L);
        g0(this.f18606m, 0L);
        g0(this.f18607n, 0L);
        g0(this.f18608o, 0L);
    }

    private void g0(TextView textView, long j10) {
        h0(textView, j10, true);
    }

    private void h0(TextView textView, long j10, boolean z10) {
        int d10 = zj.d.d(j10);
        int i10 = d10 / 60;
        int i11 = d10 % 60;
        StringBuffer stringBuffer = new StringBuffer();
        if (i10 > 0) {
            if (z10) {
                stringBuffer.append(i10);
                stringBuffer.append(" ");
                stringBuffer.append(this.G);
                stringBuffer.append(" ");
                stringBuffer.append(i11);
                stringBuffer.append(" ");
                stringBuffer.append(this.H);
            } else {
                stringBuffer.append(i10);
                stringBuffer.append(this.G);
                stringBuffer.append(i11);
                stringBuffer.append(this.H);
            }
        } else if (z10) {
            stringBuffer.append(i11);
            stringBuffer.append(" ");
            stringBuffer.append(this.H);
        } else {
            stringBuffer.append(i11);
            stringBuffer.append(this.H);
        }
        textView.setText(stringBuffer.toString());
    }

    @Override // nf.e
    protected f Z() {
        return this;
    }

    @Override // nf.e
    protected g a0() {
        return new d0(getArguments().getString("sleepId"));
    }

    /* renamed from: i0 */
    public void setViewModel(d0 d0Var) {
        this.f18598e.clear();
        if (d0Var != null) {
            this.f18598e.a(j.c(d0Var.n(), new nf.k() { // from class: sg.b
                @Override // nf.k
                public final void i(h hVar, Object obj) {
                    a.this.f0(hVar, (c.b) obj);
                }
            }));
        }
    }

    @Override // nf.b, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(t.f26850x, viewGroup, false);
        this.G = getString(u.f26947p2);
        this.H = getString(u.f26953q2);
        return inflate;
    }

    @Override // nf.e, nf.b, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.E = (NestedScrollView) view.findViewById(s.I2);
        Button button = (Button) view.findViewById(s.G2);
        this.F = button;
        button.setOnClickListener(this.I);
        this.f18599f = (SleepTypeView) view.findViewById(s.C3);
        this.f18600g = (SleepTypePercentBar) view.findViewById(s.f26824z3);
        this.f18601h = (TextView) view.findViewById(s.f26775s3);
        this.f18605l = (TextView) view.findViewById(s.f26782t3);
        this.f18602i = (TextView) view.findViewById(s.A3);
        this.f18606m = (TextView) view.findViewById(s.B3);
        this.f18603j = (TextView) view.findViewById(s.f26803w3);
        this.f18607n = (TextView) view.findViewById(s.f26810x3);
        this.f18604k = (TextView) view.findViewById(s.f26789u3);
        this.f18608o = (TextView) view.findViewById(s.f26796v3);
        this.f18609p = (TextView) view.findViewById(s.f26758q);
        this.f18610q = (TextView) view.findViewById(s.W0);
        this.f18611r = (TextView) view.findViewById(s.Y0);
        this.f18612s = (TextView) view.findViewById(s.f26751p);
        this.f18618y = (TextView) view.findViewById(s.Q2);
        this.f18615v = (TextView) view.findViewById(s.R2);
        this.f18616w = (TextView) view.findViewById(s.C);
        this.f18617x = (TextView) view.findViewById(s.E);
        this.f18613t = (SleepHeartRateView) view.findViewById(s.f26678e3);
        this.f18614u = (SleepDetailBloodOxygenView) view.findViewById(s.S2);
        TextView textView = (TextView) view.findViewById(s.f26741n3);
        this.f18619z = (TextView) view.findViewById(s.f26734m3);
        this.A = (TextView) view.findViewById(s.Z2);
        TextView textView2 = (TextView) view.findViewById(s.Y2);
        this.B = (TextView) view.findViewById(s.f26657b3);
        TextView textView3 = (TextView) view.findViewById(s.f26650a3);
        this.C = (TextView) view.findViewById(s.H0);
        TextView textView4 = (TextView) view.findViewById(s.G0);
        this.D = (TextView) view.findViewById(s.L0);
        TextView textView5 = (TextView) view.findViewById(s.K0);
    }
}
