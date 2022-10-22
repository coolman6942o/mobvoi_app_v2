package com.google.android.material.datepicker;

import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;
/* compiled from: MaterialTextInputPicker.java */
/* loaded from: classes.dex */
public final class i<S> extends m<S> {

    /* renamed from: b  reason: collision with root package name */
    private int f10835b;

    /* renamed from: c  reason: collision with root package name */
    private DateSelector<S> f10836c;

    /* renamed from: d  reason: collision with root package name */
    private CalendarConstraints f10837d;

    /* compiled from: MaterialTextInputPicker.java */
    /* loaded from: classes.dex */
    class a extends l<S> {
        a() {
        }

        @Override // com.google.android.material.datepicker.l
        public void a() {
            Iterator<l<S>> it = i.this.f10854a.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }

        @Override // com.google.android.material.datepicker.l
        public void b(S s10) {
            Iterator<l<S>> it = i.this.f10854a.iterator();
            while (it.hasNext()) {
                it.next().b(s10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> i<T> a0(DateSelector<T> dateSelector, int i10, CalendarConstraints calendarConstraints) {
        i<T> iVar = new i<>();
        Bundle bundle = new Bundle();
        bundle.putInt("THEME_RES_ID_KEY", i10);
        bundle.putParcelable("DATE_SELECTOR_KEY", dateSelector);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", calendarConstraints);
        iVar.setArguments(bundle);
        return iVar;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.f10835b = bundle.getInt("THEME_RES_ID_KEY");
        this.f10836c = (DateSelector) bundle.getParcelable("DATE_SELECTOR_KEY");
        this.f10837d = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return this.f10836c.T(layoutInflater.cloneInContext(new ContextThemeWrapper(getContext(), this.f10835b)), viewGroup, bundle, this.f10837d, new a());
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("THEME_RES_ID_KEY", this.f10835b);
        bundle.putParcelable("DATE_SELECTOR_KEY", this.f10836c);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.f10837d);
    }
}
