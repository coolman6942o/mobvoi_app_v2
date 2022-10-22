package com.google.android.material.datepicker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.datepicker.f;
import d7.h;
import d7.j;
import java.util.Calendar;
import java.util.Locale;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: YearGridAdapter.java */
/* loaded from: classes.dex */
public class q extends RecyclerView.Adapter<b> {

    /* renamed from: a  reason: collision with root package name */
    private final f<?> f10859a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: YearGridAdapter.java */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f10860a;

        a(int i10) {
            this.f10860a = i10;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            q.this.f10859a.s0(q.this.f10859a.j0().e(Month.b(this.f10860a, q.this.f10859a.l0().f10735b)));
            q.this.f10859a.t0(f.k.DAY);
        }
    }

    /* compiled from: YearGridAdapter.java */
    /* loaded from: classes.dex */
    public static class b extends RecyclerView.b0 {

        /* renamed from: a  reason: collision with root package name */
        final TextView f10862a;

        b(TextView textView) {
            super(textView);
            this.f10862a = textView;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(f<?> fVar) {
        this.f10859a = fVar;
    }

    private View.OnClickListener d(int i10) {
        return new a(i10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e(int i10) {
        return i10 - this.f10859a.j0().j().f10736c;
    }

    int f(int i10) {
        return this.f10859a.j0().j().f10736c + i10;
    }

    /* renamed from: g */
    public void onBindViewHolder(b bVar, int i10) {
        int f10 = f(i10);
        String string = bVar.f10862a.getContext().getString(j.D);
        bVar.f10862a.setText(String.format(Locale.getDefault(), "%d", Integer.valueOf(f10)));
        bVar.f10862a.setContentDescription(String.format(string, Integer.valueOf(f10)));
        com.google.android.material.datepicker.b k02 = this.f10859a.k0();
        Calendar o10 = p.o();
        com.google.android.material.datepicker.a aVar = o10.get(1) == f10 ? k02.f10768f : k02.f10766d;
        for (Long l10 : this.f10859a.m0().r0()) {
            o10.setTimeInMillis(l10.longValue());
            if (o10.get(1) == f10) {
                aVar = k02.f10767e;
            }
        }
        aVar.d(bVar.f10862a);
        bVar.f10862a.setOnClickListener(d(f10));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f10859a.j0().k();
    }

    /* renamed from: h */
    public b onCreateViewHolder(ViewGroup viewGroup, int i10) {
        return new b((TextView) LayoutInflater.from(viewGroup.getContext()).inflate(h.f25304v, viewGroup, false));
    }
}
