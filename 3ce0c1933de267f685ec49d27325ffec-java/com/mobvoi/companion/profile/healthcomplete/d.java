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
import ce.e;
import ce.f;
import ce.h;
import ce.i;
import com.mobvoi.companion.base.ui.view.numberpicker.NumberPicker;
import kc.a;
/* compiled from: ChooseStepGoalFragment.java */
/* loaded from: classes2.dex */
public class d extends Fragment implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    NumberPicker f17385a;

    /* renamed from: b  reason: collision with root package name */
    ImageView f17386b;

    /* renamed from: c  reason: collision with root package name */
    TextView f17387c;

    /* renamed from: d  reason: collision with root package name */
    f f17388d;

    /* renamed from: e  reason: collision with root package name */
    String[] f17389e;

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof f) {
            this.f17388d = (f) activity;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        f fVar;
        int id2 = view.getId();
        if (id2 == e.Y) {
            String valueOf = String.valueOf((Integer.parseInt(String.valueOf(this.f17385a.getValue())) + 5) * 1000);
            f fVar2 = this.f17388d;
            if (fVar2 != null) {
                fVar2.m(5, valueOf);
                this.f17388d.next();
            }
        } else if (id2 == e.f5773f && (fVar = this.f17388d) != null) {
            fVar.z();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.cloneInContext(new ContextThemeWrapper(getActivity(), i.f5884d)).inflate(f.f5818l, (ViewGroup) null);
        this.f17386b = (ImageView) inflate.findViewById(e.f5773f);
        TextView textView = (TextView) inflate.findViewById(e.f5772e0);
        this.f17387c = textView;
        textView.setText(getResources().getString(h.H));
        this.f17387c.setTextSize(20.0f);
        this.f17386b.setOnClickListener(this);
        this.f17385a = (NumberPicker) inflate.findViewById(e.f5803w);
        this.f17389e = new String[16];
        for (int i10 = 5; i10 <= 20; i10++) {
            this.f17389e[i10 - 5] = (i10 * 1000) + getString(h.X);
        }
        this.f17385a.setMaxValue(15);
        this.f17385a.setMinValue(0);
        this.f17385a.setDisplayedValues(this.f17389e);
        this.f17385a.setValue(3);
        this.f17385a.setPickerDividerColor(a.a(requireContext()));
        int i11 = e.Y;
        ((TextView) inflate.findViewById(i11)).setText(h.f5854k);
        inflate.findViewById(i11).setOnClickListener(this);
        inflate.setAlpha(0.3f);
        return inflate;
    }
}
