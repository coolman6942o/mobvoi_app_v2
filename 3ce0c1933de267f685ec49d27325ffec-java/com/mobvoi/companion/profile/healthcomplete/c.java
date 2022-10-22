package com.mobvoi.companion.profile.healthcomplete;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import ce.e;
import ce.f;
import ce.h;
import ce.i;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.companion.base.ui.view.numberpicker.NumberPicker;
import com.mobvoi.companion.unit.UnitPolicy;
import com.mobvoi.wear.util.UnitsUtility;
/* compiled from: ChooseHeightFragment.java */
/* loaded from: classes2.dex */
public class c extends Fragment implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    private String[] f17369b;

    /* renamed from: c  reason: collision with root package name */
    private String[] f17370c;

    /* renamed from: d  reason: collision with root package name */
    private String[] f17371d;

    /* renamed from: e  reason: collision with root package name */
    f f17372e;

    /* renamed from: f  reason: collision with root package name */
    private NumberPicker f17373f;

    /* renamed from: g  reason: collision with root package name */
    private NumberPicker f17374g;

    /* renamed from: h  reason: collision with root package name */
    private NumberPicker f17375h;

    /* renamed from: i  reason: collision with root package name */
    ImageView f17376i;

    /* renamed from: j  reason: collision with root package name */
    TextView f17377j;

    /* renamed from: k  reason: collision with root package name */
    private wd.a f17378k;

    /* renamed from: m  reason: collision with root package name */
    private View f17380m;

    /* renamed from: n  reason: collision with root package name */
    private View f17381n;

    /* renamed from: o  reason: collision with root package name */
    private RadioGroup f17382o;

    /* renamed from: a  reason: collision with root package name */
    private final String f17368a = c.class.getSimpleName();

    /* renamed from: l  reason: collision with root package name */
    private UnitPolicy.UNIT f17379l = UnitPolicy.UNIT.METRIC;

    /* renamed from: p  reason: collision with root package name */
    private float f17383p = 170.0f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ChooseHeightFragment.java */
    /* loaded from: classes2.dex */
    public class a implements RadioGroup.OnCheckedChangeListener {
        a() {
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public void onCheckedChanged(RadioGroup radioGroup, int i10) {
            if (i10 == e.L) {
                c cVar = c.this;
                UnitPolicy.UNIT unit = UnitPolicy.UNIT.METRIC;
                cVar.f17378k = UnitPolicy.c(unit);
                c.this.f17379l = unit;
                c.this.f17380m.setVisibility(0);
                c.this.f17381n.setVisibility(4);
                c cVar2 = c.this;
                cVar2.f17383p = Float.valueOf(UnitsUtility.inch2Cm(cVar2.f17373f.getValue(), c.this.f17374g.getValue())).floatValue();
                String str = c.this.f17368a;
                k.h(str, "metric -- " + c.this.f17373f.getValue() + " " + c.this.f17374g.getValue() + " " + c.this.f17383p);
                c.this.f17375h.setValue((int) c.this.f17383p);
                xd.c.x().H(c.this.getActivity(), "metric");
                ((HealthInfoCompleteActivity) c.this.getActivity()).N("metric");
            } else if (i10 == e.A) {
                c cVar3 = c.this;
                UnitPolicy.UNIT unit2 = UnitPolicy.UNIT.IMPERIAL;
                cVar3.f17378k = UnitPolicy.c(unit2);
                c.this.f17379l = unit2;
                c.this.f17380m.setVisibility(4);
                c.this.f17381n.setVisibility(0);
                c cVar4 = c.this;
                cVar4.f17383p = cVar4.f17375h.getValue();
                float cm2Inch = UnitsUtility.cm2Inch((int) c.this.f17383p);
                int i11 = (int) cm2Inch;
                if (cm2Inch > i11) {
                    i11++;
                }
                c.this.f17373f.setValue(i11 / 12);
                c.this.f17374g.setValue(i11 % 12);
                String str2 = c.this.f17368a;
                k.h(str2, "imperial -- " + c.this.f17373f.getValue() + " " + c.this.f17374g.getValue() + " " + c.this.f17383p);
                xd.c.x().H(c.this.getActivity(), "imperial");
                ((HealthInfoCompleteActivity) c.this.getActivity()).N("imperial");
            }
        }
    }

    private void i0() {
        this.f17369b = new String[8];
        for (int i10 = 1; i10 <= 8; i10++) {
            this.f17369b[i10 - 1] = i10 + "'";
        }
        this.f17370c = new String[12];
        for (int i11 = 0; i11 <= 11; i11++) {
            this.f17370c[i11 + 0] = i11 + "''";
        }
        int intValue = Float.valueOf(UnitsUtility.inch2Cm(8, 11)).intValue();
        int intValue2 = Float.valueOf(UnitsUtility.inch2Cm(1, 0)).intValue();
        this.f17371d = new String[(intValue - intValue2) + 1];
        for (int i12 = intValue2; i12 <= intValue; i12++) {
            this.f17371d[i12 - intValue2] = i12 + "CM";
        }
        j0();
    }

    private void k0(View view) {
        this.f17373f = (NumberPicker) view.findViewById(e.f5793p);
        this.f17374g = (NumberPicker) view.findViewById(e.C);
        int i10 = e.M;
        this.f17375h = (NumberPicker) view.findViewById(i10);
        this.f17376i = (ImageView) view.findViewById(e.f5773f);
        TextView textView = (TextView) view.findViewById(e.f5772e0);
        this.f17377j = textView;
        textView.setText(getResources().getString(h.F));
        this.f17377j.setTextSize(20.0f);
        this.f17376i.setOnClickListener(this);
        view.findViewById(e.Y).setOnClickListener(this);
        view.setAlpha(0.3f);
        this.f17380m = view.findViewById(i10);
        this.f17381n = view.findViewById(e.B);
        RadioGroup radioGroup = (RadioGroup) view.findViewById(e.X);
        this.f17382o = radioGroup;
        radioGroup.setOnCheckedChangeListener(new a());
        if (com.mobvoi.companion.base.settings.a.isUnitMetric(getActivity())) {
            ((RadioButton) this.f17382o.findViewById(e.L)).setChecked(true);
        } else {
            ((RadioButton) this.f17382o.findViewById(e.A)).setChecked(true);
        }
    }

    public void j0() {
        this.f17373f.setPickerDividerColor(kc.a.a(requireContext()));
        this.f17374g.setPickerDividerColor(kc.a.a(requireContext()));
        this.f17373f.setMaxValue(8);
        this.f17373f.setMinValue(1);
        this.f17374g.setMaxValue(11);
        this.f17374g.setMinValue(0);
        if (this.f17378k.h("170") != null && this.f17378k.h("170").length > 1) {
            this.f17373f.setValue(this.f17378k.h("170")[0]);
            this.f17374g.setValue(this.f17378k.h("170")[1]);
        }
        this.f17373f.setDisplayedValues(this.f17369b);
        this.f17374g.setDisplayedValues(this.f17370c);
        int intValue = Float.valueOf(UnitsUtility.inch2Cm(8, 11)).intValue();
        int intValue2 = Float.valueOf(UnitsUtility.inch2Cm(1, 0)).intValue();
        this.f17375h.setPickerDividerColor(kc.a.a(requireContext()));
        this.f17375h.setMaxValue(intValue);
        this.f17375h.setMinValue(intValue2);
        if (this.f17378k.h("170") != null && this.f17378k.h("170").length > 0) {
            this.f17375h.setValue(this.f17378k.h("170")[0]);
        }
        this.f17375h.setDisplayedValues(this.f17371d);
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof f) {
            this.f17372e = (f) activity;
        }
        this.f17378k = UnitPolicy.c(UnitPolicy.UNIT.METRIC);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        f fVar;
        String str;
        int id2 = view.getId();
        if (id2 == e.Y) {
            int value = this.f17373f.getValue();
            int value2 = this.f17374g.getValue();
            if (this.f17379l == UnitPolicy.UNIT.METRIC) {
                str = String.valueOf(this.f17375h.getValue());
            } else {
                str = this.f17378k.f(Integer.valueOf(value), Integer.valueOf(value2));
            }
            f fVar2 = this.f17372e;
            if (fVar2 != null) {
                fVar2.m(2, str);
                this.f17372e.next();
            }
        } else if (id2 == e.f5773f && (fVar = this.f17372e) != null) {
            fVar.z();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.cloneInContext(new ContextThemeWrapper(getActivity(), i.f5884d)).inflate(f.f5819m, viewGroup, false);
        k0(inflate);
        i0();
        return inflate;
    }
}
