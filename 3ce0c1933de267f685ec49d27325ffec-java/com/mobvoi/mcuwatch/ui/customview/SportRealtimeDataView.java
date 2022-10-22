package com.mobvoi.mcuwatch.ui.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.mobvoi.companion.base.settings.a;
import com.mobvoi.mcuwatch.bean.SportControlBean;
import mj.b;
import nj.j;
import sh.e;
import sh.h;
import sh.i;
import sh.k;
/* loaded from: classes2.dex */
public class SportRealtimeDataView extends ConstraintLayout implements b {
    private TextView A;
    private TextView B;
    private TextView C;
    private TextView D;
    private TextView E;
    private int F;

    /* renamed from: u  reason: collision with root package name */
    private final Context f19616u;

    /* renamed from: v  reason: collision with root package name */
    private TextView f19617v;

    /* renamed from: w  reason: collision with root package name */
    private TextView f19618w;

    /* renamed from: x  reason: collision with root package name */
    private TextView f19619x;

    /* renamed from: y  reason: collision with root package name */
    private TextView f19620y;

    /* renamed from: z  reason: collision with root package name */
    private TextView f19621z;

    public SportRealtimeDataView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void E() {
        LayoutInflater.from(this.f19616u).inflate(i.X0, (ViewGroup) this, true);
        this.f19617v = (TextView) findViewById(h.Y3);
        this.f19618w = (TextView) findViewById(h.I3);
        this.f19619x = (TextView) findViewById(h.f34632e4);
        this.f19620y = (TextView) findViewById(h.Z3);
        this.f19621z = (TextView) findViewById(h.f34628d4);
        this.A = (TextView) findViewById(h.f34619b4);
        this.B = (TextView) findViewById(h.f34614a4);
        this.C = (TextView) findViewById(h.W3);
        this.D = (TextView) findViewById(h.X3);
        this.E = (TextView) findViewById(h.f34623c4);
        if (a.isUnitMetric(com.mobvoi.android.common.utils.b.e())) {
            this.f19618w.setText(getResources().getString(k.f34891x1));
            this.E.setText(getResources().getString(k.f34901z1));
            return;
        }
        this.f19618w.setText(getResources().getString(k.f34885w1));
        this.E.setText(getResources().getString(k.f34896y1));
    }

    public void F(SportControlBean sportControlBean) {
        this.f19620y.setText(j.i(sportControlBean.f19133b));
        this.f19617v.setText(j.f(sportControlBean.f19132a));
        this.A.setText(j.j(sportControlBean.f19135d));
        this.D.setText(j.h(sportControlBean.f19134c));
        this.C.setText(sportControlBean.f19138g);
        this.B.setText(String.valueOf(sportControlBean.f19137f));
        if (this.F == 2) {
            this.f19621z.setText(j.g(sportControlBean.f19139h));
        } else {
            this.f19621z.setText(String.valueOf(sportControlBean.f19136e));
        }
    }

    @Override // mj.b
    public void a(int i10) {
        if (i10 == 4) {
            ConstraintLayout.b bVar = (ConstraintLayout.b) getLayoutParams();
            ((ViewGroup.MarginLayoutParams) bVar).bottomMargin = (int) getResources().getDimension(e.f34499k1);
            setLayoutParams(bVar);
        }
    }

    @Override // mj.b
    public void d(int i10) {
        this.F = i10;
        if (i10 == 2) {
            this.f19619x.setText(getResources().getString(k.f34880v1));
        } else {
            this.f19619x.setText(getResources().getString(k.B1));
        }
    }

    public SportRealtimeDataView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f19616u = context;
        E();
    }
}
