package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.d0;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.datepicker.f;
import d7.h;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MonthsPagerAdapter.java */
/* loaded from: classes.dex */
public class k extends RecyclerView.Adapter<b> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f10845a;

    /* renamed from: b  reason: collision with root package name */
    private final CalendarConstraints f10846b;

    /* renamed from: c  reason: collision with root package name */
    private final DateSelector<?> f10847c;

    /* renamed from: d  reason: collision with root package name */
    private final f.l f10848d;

    /* renamed from: e  reason: collision with root package name */
    private final int f10849e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MonthsPagerAdapter.java */
    /* loaded from: classes.dex */
    public class a implements AdapterView.OnItemClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MaterialCalendarGridView f10850a;

        a(MaterialCalendarGridView materialCalendarGridView) {
            this.f10850a = materialCalendarGridView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
            if (this.f10850a.getAdapter2().n(i10)) {
                k.this.f10848d.a(this.f10850a.getAdapter2().getItem(i10).longValue());
            }
        }
    }

    /* compiled from: MonthsPagerAdapter.java */
    /* loaded from: classes.dex */
    public static class b extends RecyclerView.b0 {

        /* renamed from: a  reason: collision with root package name */
        final TextView f10852a;

        /* renamed from: b  reason: collision with root package name */
        final MaterialCalendarGridView f10853b;

        b(LinearLayout linearLayout, boolean z10) {
            super(linearLayout);
            TextView textView = (TextView) linearLayout.findViewById(d7.f.D);
            this.f10852a = textView;
            d0.u0(textView, true);
            this.f10853b = (MaterialCalendarGridView) linearLayout.findViewById(d7.f.f25279z);
            if (!z10) {
                textView.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(Context context, DateSelector<?> dateSelector, CalendarConstraints calendarConstraints, f.l lVar) {
        Month j10 = calendarConstraints.j();
        Month g10 = calendarConstraints.g();
        Month i10 = calendarConstraints.i();
        if (j10.compareTo(i10) > 0) {
            throw new IllegalArgumentException("firstPage cannot be after currentPage");
        } else if (i10.compareTo(g10) <= 0) {
            int n02 = j.f10839f * f.n0(context);
            int n03 = g.G0(context) ? f.n0(context) : 0;
            this.f10845a = context;
            this.f10849e = n02 + n03;
            this.f10846b = calendarConstraints;
            this.f10847c = dateSelector;
            this.f10848d = lVar;
            setHasStableIds(true);
        } else {
            throw new IllegalArgumentException("currentPage cannot be after lastPage");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Month d(int i10) {
        return this.f10846b.j().j(i10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharSequence e(int i10) {
        return d(i10).h(this.f10845a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f(Month month) {
        return this.f10846b.j().k(month);
    }

    /* renamed from: g */
    public void onBindViewHolder(b bVar, int i10) {
        Month j10 = this.f10846b.j().j(i10);
        bVar.f10852a.setText(j10.h(bVar.itemView.getContext()));
        MaterialCalendarGridView materialCalendarGridView = (MaterialCalendarGridView) bVar.f10853b.findViewById(d7.f.f25279z);
        if (materialCalendarGridView.getAdapter2() == null || !j10.equals(materialCalendarGridView.getAdapter2().f10840a)) {
            j jVar = new j(j10, this.f10847c, this.f10846b);
            materialCalendarGridView.setNumColumns(j10.f10737d);
            materialCalendarGridView.setAdapter((ListAdapter) jVar);
        } else {
            materialCalendarGridView.invalidate();
            materialCalendarGridView.getAdapter2().m(materialCalendarGridView);
        }
        materialCalendarGridView.setOnItemClickListener(new a(materialCalendarGridView));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f10846b.h();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i10) {
        return this.f10846b.j().j(i10).i();
    }

    /* renamed from: h */
    public b onCreateViewHolder(ViewGroup viewGroup, int i10) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(h.f25302t, viewGroup, false);
        if (!g.G0(viewGroup.getContext())) {
            return new b(linearLayout, false);
        }
        linearLayout.setLayoutParams(new RecyclerView.o(-1, this.f10849e));
        return new b(linearLayout, true);
    }
}
