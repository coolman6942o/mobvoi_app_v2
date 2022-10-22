package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import d7.h;
import java.util.Collection;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MonthAdapter.java */
/* loaded from: classes.dex */
public class j extends BaseAdapter {

    /* renamed from: f  reason: collision with root package name */
    static final int f10839f = p.q().getMaximum(4);

    /* renamed from: a  reason: collision with root package name */
    final Month f10840a;

    /* renamed from: b  reason: collision with root package name */
    final DateSelector<?> f10841b;

    /* renamed from: c  reason: collision with root package name */
    private Collection<Long> f10842c;

    /* renamed from: d  reason: collision with root package name */
    b f10843d;

    /* renamed from: e  reason: collision with root package name */
    final CalendarConstraints f10844e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(Month month, DateSelector<?> dateSelector, CalendarConstraints calendarConstraints) {
        this.f10840a = month;
        this.f10841b = dateSelector;
        this.f10844e = calendarConstraints;
        this.f10842c = dateSelector.r0();
    }

    private void e(Context context) {
        if (this.f10843d == null) {
            this.f10843d = new b(context);
        }
    }

    private boolean h(long j10) {
        for (Long l10 : this.f10841b.r0()) {
            if (p.a(j10) == p.a(l10.longValue())) {
                return true;
            }
        }
        return false;
    }

    private void k(TextView textView, long j10) {
        a aVar;
        if (textView != null) {
            if (this.f10844e.f().i0(j10)) {
                textView.setEnabled(true);
                if (h(j10)) {
                    aVar = this.f10843d.f10764b;
                } else if (p.o().getTimeInMillis() == j10) {
                    aVar = this.f10843d.f10765c;
                } else {
                    aVar = this.f10843d.f10763a;
                }
            } else {
                textView.setEnabled(false);
                aVar = this.f10843d.f10769g;
            }
            aVar.d(textView);
        }
    }

    private void l(MaterialCalendarGridView materialCalendarGridView, long j10) {
        if (Month.c(j10).equals(this.f10840a)) {
            k((TextView) materialCalendarGridView.getChildAt(materialCalendarGridView.getAdapter2().a(this.f10840a.g(j10)) - materialCalendarGridView.getFirstVisiblePosition()), j10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(int i10) {
        return b() + (i10 - 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.f10840a.e();
    }

    /* renamed from: c */
    public Long getItem(int i10) {
        if (i10 < this.f10840a.e() || i10 > i()) {
            return null;
        }
        return Long.valueOf(this.f10840a.f(j(i10)));
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0083 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0084  */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public TextView getView(int i10, View view, ViewGroup viewGroup) {
        Long c10;
        e(viewGroup.getContext());
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(h.f25299q, viewGroup, false);
        }
        int b10 = i10 - b();
        if (b10 >= 0) {
            Month month = this.f10840a;
            if (b10 < month.f10738e) {
                int i11 = b10 + 1;
                textView.setTag(month);
                textView.setText(String.format(textView.getResources().getConfiguration().locale, "%d", Integer.valueOf(i11)));
                long f10 = this.f10840a.f(i11);
                if (this.f10840a.f10736c == Month.d().f10736c) {
                    textView.setContentDescription(d.g(f10));
                } else {
                    textView.setContentDescription(d.l(f10));
                }
                textView.setVisibility(0);
                textView.setEnabled(true);
                c10 = getItem(i10);
                if (c10 != null) {
                    return textView;
                }
                k(textView, c10.longValue());
                return textView;
            }
        }
        textView.setVisibility(8);
        textView.setEnabled(false);
        c10 = getItem(i10);
        if (c10 != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f(int i10) {
        return i10 % this.f10840a.f10737d == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean g(int i10) {
        return (i10 + 1) % this.f10840a.f10737d == 0;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f10840a.f10738e + b();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10 / this.f10840a.f10737d;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int i() {
        return (this.f10840a.e() + this.f10840a.f10738e) - 1;
    }

    int j(int i10) {
        return (i10 - this.f10840a.e()) + 1;
    }

    public void m(MaterialCalendarGridView materialCalendarGridView) {
        for (Long l10 : this.f10842c) {
            l(materialCalendarGridView, l10.longValue());
        }
        DateSelector<?> dateSelector = this.f10841b;
        if (dateSelector != null) {
            for (Long l11 : dateSelector.r0()) {
                l(materialCalendarGridView, l11.longValue());
            }
            this.f10842c = this.f10841b.r0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean n(int i10) {
        return i10 >= b() && i10 <= i();
    }
}
