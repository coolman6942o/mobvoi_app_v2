package com.mobvoi.companion.profile.healthcomplete;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import ce.e;
import ce.f;
import ce.h;
/* compiled from: ChooseGenderFragment.java */
/* loaded from: classes2.dex */
public class b extends Fragment implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    f f17361a;

    /* renamed from: b  reason: collision with root package name */
    private int f17362b = 0;

    /* renamed from: c  reason: collision with root package name */
    ImageView f17363c;

    /* renamed from: d  reason: collision with root package name */
    TextView f17364d;

    /* renamed from: e  reason: collision with root package name */
    TextView f17365e;

    /* renamed from: f  reason: collision with root package name */
    RadioButton f17366f;

    /* renamed from: g  reason: collision with root package name */
    RadioButton f17367g;

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof f) {
            this.f17361a = (f) activity;
        }
    }

    /* JADX WARN: Type inference failed for: r3v5, types: [int, boolean] */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id2 = view.getId();
        if (id2 == e.O) {
            ?? isChecked = this.f17367g.isChecked();
            this.f17362b = isChecked == true ? 1 : 0;
            f fVar = this.f17361a;
            if (fVar != null) {
                fVar.m(3, String.valueOf((int) isChecked));
                this.f17361a.next();
            }
        } else if (id2 == e.f5764a0) {
            ((HealthInfoCompleteActivity) getActivity()).O();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(f.f5821o, (ViewGroup) null);
        inflate.findViewById(e.O).setOnClickListener(this);
        this.f17363c = (ImageView) inflate.findViewById(e.f5773f);
        this.f17364d = (TextView) inflate.findViewById(e.f5772e0);
        this.f17363c.setVisibility(8);
        this.f17364d.setText(getResources().getString(h.f5875u0));
        this.f17364d.setTextSize(20.0f);
        TextView textView = (TextView) inflate.findViewById(e.f5764a0);
        this.f17365e = textView;
        textView.getPaint().setFlags(8);
        this.f17365e.setOnClickListener(this);
        this.f17366f = (RadioButton) inflate.findViewById(e.W);
        this.f17367g = (RadioButton) inflate.findViewById(e.V);
        this.f17366f.setChecked(true);
        return inflate;
    }
}
