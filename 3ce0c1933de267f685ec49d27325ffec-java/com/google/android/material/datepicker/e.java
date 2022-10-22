package com.google.android.material.datepicker;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import d7.h;
import d7.j;
import java.util.Calendar;
import java.util.Locale;
/* compiled from: DaysOfWeekAdapter.java */
/* loaded from: classes.dex */
class e extends BaseAdapter {

    /* renamed from: d  reason: collision with root package name */
    private static final int f10781d;

    /* renamed from: a  reason: collision with root package name */
    private final Calendar f10782a;

    /* renamed from: b  reason: collision with root package name */
    private final int f10783b;

    /* renamed from: c  reason: collision with root package name */
    private final int f10784c;

    static {
        f10781d = Build.VERSION.SDK_INT >= 26 ? 4 : 1;
    }

    public e() {
        Calendar q5 = p.q();
        this.f10782a = q5;
        this.f10783b = q5.getMaximum(7);
        this.f10784c = q5.getFirstDayOfWeek();
    }

    private int b(int i10) {
        int i11 = i10 + this.f10784c;
        int i12 = this.f10783b;
        return i11 > i12 ? i11 - i12 : i11;
    }

    /* renamed from: a */
    public Integer getItem(int i10) {
        if (i10 >= this.f10783b) {
            return null;
        }
        return Integer.valueOf(b(i10));
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f10783b;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return 0L;
    }

    @Override // android.widget.Adapter
    @SuppressLint({"WrongConstant"})
    public View getView(int i10, View view, ViewGroup viewGroup) {
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(h.f25300r, viewGroup, false);
        }
        this.f10782a.set(7, b(i10));
        textView.setText(this.f10782a.getDisplayName(7, f10781d, textView.getResources().getConfiguration().locale));
        textView.setContentDescription(String.format(viewGroup.getContext().getString(j.f25334y), this.f10782a.getDisplayName(7, 2, Locale.getDefault())));
        return textView;
    }
}
