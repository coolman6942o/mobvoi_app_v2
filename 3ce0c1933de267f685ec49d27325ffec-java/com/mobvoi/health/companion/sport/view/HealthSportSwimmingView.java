package com.mobvoi.health.companion.sport.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mobvoi.companion.base.settings.a;
import com.mobvoi.fitness.core.data.pojo.SportDataType;
import ef.f0;
import fg.o;
import fg.p;
import fg.q;
import fg.s;
import fg.t;
import fg.u;
import java.util.ArrayList;
import java.util.List;
import lf.b;
import lf.c;
/* loaded from: classes2.dex */
public class HealthSportSwimmingView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private GridView f18836a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f18837b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f18838c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f18839d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f18840e;

    /* renamed from: f  reason: collision with root package name */
    private ListView f18841f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f18842g;

    public HealthSportSwimmingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    private void a() {
        View inflate = LayoutInflater.from(getContext()).inflate(t.K, (ViewGroup) this, true);
        this.f18840e = (TextView) inflate.findViewById(s.f26811x4);
        this.f18839d = (TextView) inflate.findViewById(s.f26797v4);
        this.f18836a = (GridView) inflate.findViewById(s.H4);
        this.f18837b = (TextView) inflate.findViewById(s.E4);
        this.f18838c = (TextView) inflate.findViewById(s.f26804w4);
        this.f18841f = (ListView) inflate.findViewById(s.A4);
        d(new ArrayList(), null);
        setSwimmingSegment(new ArrayList());
    }

    private void b(TextView textView, SportDataType sportDataType, float f10, int i10) {
        boolean z10 = !a.isUnitMetric(getContext());
        textView.setText(new SpannableStringBuilder(getContext().getString(i10)).append((CharSequence) "\n").append(b.a(c.d(sportDataType, f10, z10) + c.a(getResources(), z10, sportDataType), 0, getResources().getColor(o.f26489v0))));
    }

    @SuppressLint({"DefaultLocale"})
    public void c(float f10, int i10) {
        b(this.f18837b, SportDataType.SwimTrips, Math.max((int) f10, 0), u.R4);
        b(this.f18838c, SportDataType.SwimPoolLength, i10, u.f26997x4);
    }

    public void d(List<f0> list, View.OnClickListener onClickListener) {
        GridView gridView = this.f18836a;
        Context context = getContext();
        if (!this.f18842g) {
            onClickListener = null;
        }
        gridView.setAdapter((ListAdapter) new ch.b(context, list, onClickListener));
    }

    public void setDetailed(boolean z10) {
        this.f18842g = z10;
        if (z10) {
            TextView textView = this.f18839d;
            int i10 = q.f26561e0;
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, i10, 0);
            this.f18840e.setCompoundDrawablesWithIntrinsicBounds(0, 0, i10, 0);
            return;
        }
        this.f18839d.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f18840e.getLayoutParams();
        layoutParams.addRule(14);
        this.f18840e.setTextColor(getResources().getColor(o.f26491w0));
        this.f18840e.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(p.B);
        this.f18840e.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
        TextView textView2 = this.f18840e;
        int i11 = q.f26565f0;
        textView2.setCompoundDrawablesWithIntrinsicBounds(0, i11, 0, i11);
        this.f18840e.setLayoutParams(layoutParams);
    }

    public void setSwimmingSegment(List<gh.a> list) {
        this.f18841f.setAdapter((ListAdapter) new ch.a(getContext(), list));
    }
}
