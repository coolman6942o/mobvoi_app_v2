package com.mobvoi.companion.profile.healthcomplete;

import android.app.Activity;
import android.os.Bundle;
import android.text.format.Time;
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
import com.amap.api.services.core.AMapException;
import com.mobvoi.companion.base.ui.view.numberpicker.NumberPicker;
import kd.d;
/* compiled from: ChooseBirthdayFragment.java */
/* loaded from: classes2.dex */
public class a extends Fragment implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    NumberPicker f17351a;

    /* renamed from: b  reason: collision with root package name */
    NumberPicker f17352b;

    /* renamed from: c  reason: collision with root package name */
    NumberPicker f17353c;

    /* renamed from: d  reason: collision with root package name */
    ImageView f17354d;

    /* renamed from: e  reason: collision with root package name */
    TextView f17355e;

    /* renamed from: f  reason: collision with root package name */
    f f17356f;

    /* renamed from: g  reason: collision with root package name */
    Time f17357g;

    /* renamed from: h  reason: collision with root package name */
    String[] f17358h;

    /* renamed from: i  reason: collision with root package name */
    String[] f17359i;

    /* renamed from: j  reason: collision with root package name */
    String[] f17360j;

    private String Y(int i10, int i11, int i12) {
        return i10 + "." + i11 + "." + i12;
    }

    public void Z() {
        Time time = new Time();
        this.f17357g = time;
        time.setToNow();
        int i10 = this.f17357g.year;
        this.f17358h = new String[(i10 - AMapException.CODE_AMAP_CLIENT_UNKNOWN_ERROR) + 1];
        for (int i11 = AMapException.CODE_AMAP_CLIENT_UNKNOWN_ERROR; i11 <= this.f17357g.year; i11++) {
            this.f17358h[i11 - 1900] = i11 + "";
        }
        this.f17359i = getActivity().getResources().getStringArray(ce.a.f5742a);
        this.f17360j = new String[31];
        int i12 = 0;
        while (i12 < 31) {
            String[] strArr = this.f17360j;
            StringBuilder sb2 = new StringBuilder();
            int i13 = i12 + 1;
            sb2.append(i13);
            sb2.append("");
            strArr[i12] = sb2.toString();
            i12 = i13;
        }
        d.e(this.f17351a, this.f17352b, this.f17353c, this.f17360j);
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof f) {
            this.f17356f = (f) activity;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        f fVar;
        int id2 = view.getId();
        if (id2 == e.O) {
            String Y = Y(this.f17351a.getValue() + AMapException.CODE_AMAP_CLIENT_UNKNOWN_ERROR, this.f17352b.getValue() + 1, this.f17353c.getValue() + 1);
            f fVar2 = this.f17356f;
            if (fVar2 != null) {
                fVar2.m(4, Y);
                this.f17356f.next();
            }
        } else if (id2 == e.f5773f && (fVar = this.f17356f) != null) {
            fVar.z();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.cloneInContext(new ContextThemeWrapper(getActivity(), i.f5884d)).inflate(f.f5817k, (ViewGroup) null);
        this.f17354d = (ImageView) inflate.findViewById(e.f5773f);
        TextView textView = (TextView) inflate.findViewById(e.f5772e0);
        this.f17355e = textView;
        textView.setText(getResources().getString(h.D));
        this.f17355e.setTextSize(20.0f);
        this.f17354d.setOnClickListener(this);
        this.f17351a = (NumberPicker) inflate.findViewById(e.f5798r0);
        this.f17352b = (NumberPicker) inflate.findViewById(e.N);
        this.f17353c = (NumberPicker) inflate.findViewById(e.f5781j);
        Z();
        this.f17351a.setPickerDividerColor(kc.a.a(requireContext()));
        this.f17352b.setPickerDividerColor(kc.a.a(requireContext()));
        this.f17353c.setPickerDividerColor(kc.a.a(requireContext()));
        this.f17351a.setMaxValue(this.f17358h.length - 1);
        this.f17352b.setMaxValue(11);
        this.f17353c.setMaxValue(30);
        this.f17351a.setMinValue(0);
        this.f17351a.setValue(90);
        this.f17352b.setMinValue(0);
        this.f17353c.setMinValue(0);
        this.f17351a.setDisplayedValues(this.f17358h);
        this.f17352b.setDisplayedValues(this.f17359i);
        this.f17353c.setDisplayedValues(this.f17360j);
        inflate.findViewById(e.O).setOnClickListener(this);
        inflate.setAlpha(0.3f);
        return inflate;
    }
}
