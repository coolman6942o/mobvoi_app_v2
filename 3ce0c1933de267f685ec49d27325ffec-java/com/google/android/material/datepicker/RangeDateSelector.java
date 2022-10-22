package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.DisplayMetrics;
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
public class RangeDateSelector implements DateSelector<d<Long, Long>> {
    public static final Parcelable.Creator<RangeDateSelector> CREATOR = new c();

    /* renamed from: a  reason: collision with root package name */
    private String f10741a;

    /* renamed from: b  reason: collision with root package name */
    private Long f10742b = null;

    /* renamed from: c  reason: collision with root package name */
    private Long f10743c = null;

    /* renamed from: d  reason: collision with root package name */
    private Long f10744d = null;

    /* renamed from: e  reason: collision with root package name */
    private Long f10745e = null;

    /* loaded from: classes.dex */
    class a extends com.google.android.material.datepicker.c {

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ TextInputLayout f10746g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ TextInputLayout f10747h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ l f10748i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, DateFormat dateFormat, TextInputLayout textInputLayout, CalendarConstraints calendarConstraints, TextInputLayout textInputLayout2, TextInputLayout textInputLayout3, l lVar) {
            super(str, dateFormat, textInputLayout, calendarConstraints);
            this.f10746g = textInputLayout2;
            this.f10747h = textInputLayout3;
            this.f10748i = lVar;
        }

        @Override // com.google.android.material.datepicker.c
        void e() {
            RangeDateSelector.this.f10744d = null;
            RangeDateSelector.this.k(this.f10746g, this.f10747h, this.f10748i);
        }

        @Override // com.google.android.material.datepicker.c
        void f(Long l10) {
            RangeDateSelector.this.f10744d = l10;
            RangeDateSelector.this.k(this.f10746g, this.f10747h, this.f10748i);
        }
    }

    /* loaded from: classes.dex */
    class b extends com.google.android.material.datepicker.c {

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ TextInputLayout f10750g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ TextInputLayout f10751h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ l f10752i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, DateFormat dateFormat, TextInputLayout textInputLayout, CalendarConstraints calendarConstraints, TextInputLayout textInputLayout2, TextInputLayout textInputLayout3, l lVar) {
            super(str, dateFormat, textInputLayout, calendarConstraints);
            this.f10750g = textInputLayout2;
            this.f10751h = textInputLayout3;
            this.f10752i = lVar;
        }

        @Override // com.google.android.material.datepicker.c
        void e() {
            RangeDateSelector.this.f10745e = null;
            RangeDateSelector.this.k(this.f10750g, this.f10751h, this.f10752i);
        }

        @Override // com.google.android.material.datepicker.c
        void f(Long l10) {
            RangeDateSelector.this.f10745e = l10;
            RangeDateSelector.this.k(this.f10750g, this.f10751h, this.f10752i);
        }
    }

    /* loaded from: classes.dex */
    static class c implements Parcelable.Creator<RangeDateSelector> {
        c() {
        }

        /* renamed from: a */
        public RangeDateSelector createFromParcel(Parcel parcel) {
            RangeDateSelector rangeDateSelector = new RangeDateSelector();
            rangeDateSelector.f10742b = (Long) parcel.readValue(Long.class.getClassLoader());
            rangeDateSelector.f10743c = (Long) parcel.readValue(Long.class.getClassLoader());
            return rangeDateSelector;
        }

        /* renamed from: b */
        public RangeDateSelector[] newArray(int i10) {
            return new RangeDateSelector[i10];
        }
    }

    private void f(TextInputLayout textInputLayout, TextInputLayout textInputLayout2) {
        if (textInputLayout.getError() != null && this.f10741a.contentEquals(textInputLayout.getError())) {
            textInputLayout.setError(null);
        }
        if (textInputLayout2.getError() != null && " ".contentEquals(textInputLayout2.getError())) {
            textInputLayout2.setError(null);
        }
    }

    private boolean h(long j10, long j11) {
        return j10 <= j11;
    }

    private void i(TextInputLayout textInputLayout, TextInputLayout textInputLayout2) {
        textInputLayout.setError(this.f10741a);
        textInputLayout2.setError(" ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(TextInputLayout textInputLayout, TextInputLayout textInputLayout2, l<d<Long, Long>> lVar) {
        Long l10 = this.f10744d;
        if (l10 == null || this.f10745e == null) {
            f(textInputLayout, textInputLayout2);
            lVar.a();
        } else if (h(l10.longValue(), this.f10745e.longValue())) {
            this.f10742b = this.f10744d;
            this.f10743c = this.f10745e;
            lVar.b(w0());
        } else {
            i(textInputLayout, textInputLayout2);
            lVar.a();
        }
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public void A0(long j10) {
        Long l10 = this.f10742b;
        if (l10 == null) {
            this.f10742b = Long.valueOf(j10);
        } else if (this.f10743c != null || !h(l10.longValue(), j10)) {
            this.f10743c = null;
            this.f10742b = Long.valueOf(j10);
        } else {
            this.f10743c = Long.valueOf(j10);
        }
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public View T(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle, CalendarConstraints calendarConstraints, l<d<Long, Long>> lVar) {
        View inflate = layoutInflater.inflate(h.B, viewGroup, false);
        TextInputLayout textInputLayout = (TextInputLayout) inflate.findViewById(f.S);
        TextInputLayout textInputLayout2 = (TextInputLayout) inflate.findViewById(f.R);
        EditText editText = textInputLayout.getEditText();
        EditText editText2 = textInputLayout2.getEditText();
        if (e.a()) {
            editText.setInputType(17);
            editText2.setInputType(17);
        }
        this.f10741a = inflate.getResources().getString(j.C);
        SimpleDateFormat k10 = p.k();
        Long l10 = this.f10742b;
        if (l10 != null) {
            editText.setText(k10.format(l10));
            this.f10744d = this.f10742b;
        }
        Long l11 = this.f10743c;
        if (l11 != null) {
            editText2.setText(k10.format(l11));
            this.f10745e = this.f10743c;
        }
        String l12 = p.l(inflate.getResources(), k10);
        textInputLayout.setPlaceholderText(l12);
        textInputLayout2.setPlaceholderText(l12);
        editText.addTextChangedListener(new a(l12, k10, textInputLayout, calendarConstraints, textInputLayout, textInputLayout2, lVar));
        editText2.addTextChangedListener(new b(l12, k10, textInputLayout2, calendarConstraints, textInputLayout, textInputLayout2, lVar));
        m.g(editText);
        return inflate;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public int V() {
        return j.I;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* renamed from: g */
    public d<Long, Long> w0() {
        return new d<>(this.f10742b, this.f10743c);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public int g0(Context context) {
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        return t7.b.d(context, Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels) > resources.getDimensionPixelSize(d7.d.f25189d0) ? d7.b.D : d7.b.B, g.class.getCanonicalName());
    }

    /* renamed from: j */
    public void w(d<Long, Long> dVar) {
        Long l10 = dVar.f29364a;
        if (!(l10 == null || dVar.f29365b == null)) {
            j0.h.a(h(l10.longValue(), dVar.f29365b.longValue()));
        }
        Long l11 = dVar.f29364a;
        Long l12 = null;
        this.f10742b = l11 == null ? null : Long.valueOf(p.a(l11.longValue()));
        Long l13 = dVar.f29365b;
        if (l13 != null) {
            l12 = Long.valueOf(p.a(l13.longValue()));
        }
        this.f10743c = l12;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public boolean m0() {
        Long l10 = this.f10742b;
        return (l10 == null || this.f10743c == null || !h(l10.longValue(), this.f10743c.longValue())) ? false : true;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public String n(Context context) {
        Resources resources = context.getResources();
        Long l10 = this.f10742b;
        if (l10 == null && this.f10743c == null) {
            return resources.getString(j.J);
        }
        Long l11 = this.f10743c;
        if (l11 == null) {
            return resources.getString(j.G, d.c(l10.longValue()));
        }
        if (l10 == null) {
            return resources.getString(j.F, d.c(l11.longValue()));
        }
        d<String, String> a10 = d.a(l10, l11);
        return resources.getString(j.H, a10.f29364a, a10.f29365b);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public Collection<d<Long, Long>> q() {
        if (this.f10742b == null || this.f10743c == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new d(this.f10742b, this.f10743c));
        return arrayList;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public Collection<Long> r0() {
        ArrayList arrayList = new ArrayList();
        Long l10 = this.f10742b;
        if (l10 != null) {
            arrayList.add(l10);
        }
        Long l11 = this.f10743c;
        if (l11 != null) {
            arrayList.add(l11);
        }
        return arrayList;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeValue(this.f10742b);
        parcel.writeValue(this.f10743c);
    }
}
