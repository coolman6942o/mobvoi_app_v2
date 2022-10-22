package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.google.android.material.internal.e;
import com.google.android.material.internal.m;
import com.google.android.material.textfield.TextInputLayout;
import d7.f;
import d7.h;
import d7.j;
import j0.d;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
/* loaded from: classes.dex */
public class SingleDateSelector implements DateSelector<Long> {
    public static final Parcelable.Creator<SingleDateSelector> CREATOR = new b();

    /* renamed from: a  reason: collision with root package name */
    private Long f10754a;

    /* loaded from: classes.dex */
    class a extends c {

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ l f10755g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, DateFormat dateFormat, TextInputLayout textInputLayout, CalendarConstraints calendarConstraints, l lVar) {
            super(str, dateFormat, textInputLayout, calendarConstraints);
            this.f10755g = lVar;
        }

        @Override // com.google.android.material.datepicker.c
        void e() {
            this.f10755g.a();
        }

        @Override // com.google.android.material.datepicker.c
        void f(Long l10) {
            if (l10 == null) {
                SingleDateSelector.this.c();
            } else {
                SingleDateSelector.this.A0(l10.longValue());
            }
            this.f10755g.b(SingleDateSelector.this.w0());
        }
    }

    /* loaded from: classes.dex */
    static class b implements Parcelable.Creator<SingleDateSelector> {
        b() {
        }

        /* renamed from: a */
        public SingleDateSelector createFromParcel(Parcel parcel) {
            SingleDateSelector singleDateSelector = new SingleDateSelector();
            singleDateSelector.f10754a = (Long) parcel.readValue(Long.class.getClassLoader());
            return singleDateSelector;
        }

        /* renamed from: b */
        public SingleDateSelector[] newArray(int i10) {
            return new SingleDateSelector[i10];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        this.f10754a = null;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public void A0(long j10) {
        this.f10754a = Long.valueOf(j10);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public View T(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle, CalendarConstraints calendarConstraints, l<Long> lVar) {
        View inflate = layoutInflater.inflate(h.A, viewGroup, false);
        TextInputLayout textInputLayout = (TextInputLayout) inflate.findViewById(f.Q);
        EditText editText = textInputLayout.getEditText();
        if (e.a()) {
            editText.setInputType(17);
        }
        SimpleDateFormat k10 = p.k();
        String l10 = p.l(inflate.getResources(), k10);
        textInputLayout.setPlaceholderText(l10);
        Long l11 = this.f10754a;
        if (l11 != null) {
            editText.setText(k10.format(l11));
        }
        editText.addTextChangedListener(new a(l10, k10, textInputLayout, calendarConstraints, lVar));
        m.g(editText);
        return inflate;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public int V() {
        return j.f25332w;
    }

    /* renamed from: d */
    public Long w0() {
        return this.f10754a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* renamed from: e */
    public void w(Long l10) {
        this.f10754a = l10 == null ? null : Long.valueOf(p.a(l10.longValue()));
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public int g0(Context context) {
        return t7.b.d(context, d7.b.D, g.class.getCanonicalName());
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public boolean m0() {
        return this.f10754a != null;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public String n(Context context) {
        Resources resources = context.getResources();
        Long l10 = this.f10754a;
        if (l10 == null) {
            return resources.getString(j.f25333x);
        }
        return resources.getString(j.f25331v, d.j(l10.longValue()));
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public Collection<d<Long, Long>> q() {
        return new ArrayList();
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public Collection<Long> r0() {
        ArrayList arrayList = new ArrayList();
        Long l10 = this.f10754a;
        if (l10 != null) {
            arrayList.add(l10);
        }
        return arrayList;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeValue(this.f10754a);
    }
}
