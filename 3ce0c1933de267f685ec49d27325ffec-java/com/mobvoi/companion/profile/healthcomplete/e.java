package com.mobvoi.companion.profile.healthcomplete;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import ce.f;
import ce.h;
import ce.i;
import com.mobvoi.companion.base.ui.view.numberpicker.NumberPicker;
import com.mobvoi.companion.profile.healthcomplete.HealthInfoCompleteActivity;
import com.mobvoi.companion.unit.UnitPolicy;
import wd.a;
/* compiled from: ChooseWeightFragment.java */
/* loaded from: classes2.dex */
public class e extends Fragment implements View.OnClickListener, HealthInfoCompleteActivity.a {

    /* renamed from: a  reason: collision with root package name */
    NumberPicker f17390a;

    /* renamed from: b  reason: collision with root package name */
    ImageView f17391b;

    /* renamed from: c  reason: collision with root package name */
    TextView f17392c;

    /* renamed from: d  reason: collision with root package name */
    f f17393d;

    /* renamed from: e  reason: collision with root package name */
    String[] f17394e;

    /* renamed from: f  reason: collision with root package name */
    private a f17395f;

    private void Y() {
        String str;
        if (com.mobvoi.companion.base.settings.a.isUnitMetric(getActivity())) {
            this.f17395f = UnitPolicy.c(UnitPolicy.UNIT.METRIC);
            str = "kg";
        } else {
            this.f17395f = UnitPolicy.c(UnitPolicy.UNIT.IMPERIAL);
            str = "lbs";
        }
        for (int i10 = 30; i10 <= 450; i10++) {
            this.f17394e[i10 - 30] = i10 + str;
        }
        int a10 = this.f17395f.a("70");
        this.f17390a.setMinValue(0);
        this.f17390a.setMaxValue(420);
        this.f17390a.setValue(a10 - 30);
        this.f17390a.setDisplayedValues(this.f17394e);
        this.f17390a.setPickerDividerColor(kc.a.a(requireContext()));
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof f) {
            this.f17393d = (f) activity;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        f fVar;
        int id2 = view.getId();
        if (id2 == ce.e.Y) {
            String valueOf = String.valueOf(Integer.parseInt(String.valueOf(this.f17390a.getValue())) + 30);
            f fVar2 = this.f17393d;
            if (fVar2 != null) {
                fVar2.m(1, this.f17395f.b(valueOf));
                this.f17393d.next();
            }
        } else if (id2 == ce.e.f5773f && (fVar = this.f17393d) != null) {
            fVar.z();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.cloneInContext(new ContextThemeWrapper(getActivity(), i.f5884d)).inflate(f.f5820n, (ViewGroup) null);
        this.f17391b = (ImageView) inflate.findViewById(ce.e.f5773f);
        TextView textView = (TextView) inflate.findViewById(ce.e.f5772e0);
        this.f17392c = textView;
        textView.setText(getResources().getString(h.L));
        this.f17392c.setTextSize(20.0f);
        this.f17391b.setOnClickListener(this);
        this.f17390a = (NumberPicker) inflate.findViewById(ce.e.f5796q0);
        this.f17394e = new String[421];
        inflate.findViewById(ce.e.Y).setOnClickListener(this);
        inflate.setAlpha(0.3f);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        ((HealthInfoCompleteActivity) getActivity()).S(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Y();
        ((HealthInfoCompleteActivity) getActivity()).Q(this);
    }

    @Override // com.mobvoi.companion.profile.healthcomplete.HealthInfoCompleteActivity.a
    public void q(String str) {
        Y();
    }
}
