package com.mobvoi.companion.ticpay.pay;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import qd.g;
import qd.j;
import qd.k;
import td.d;
/* loaded from: classes2.dex */
public class PayListView extends ListView implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    private b f17427a;

    /* renamed from: b  reason: collision with root package name */
    private List<d> f17428b;

    /* renamed from: c  reason: collision with root package name */
    private int f17429c = 0;

    /* loaded from: classes2.dex */
    private class b extends BaseAdapter {
        private b() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return PayListView.this.f17428b.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i10) {
            return PayListView.this.f17428b.get(i10);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i10) {
            return i10;
        }

        @Override // android.widget.Adapter
        public View getView(int i10, View view, ViewGroup viewGroup) {
            View view2;
            c cVar;
            if (view == null) {
                cVar = new c();
                view2 = LayoutInflater.from(PayListView.this.getContext()).inflate(k.f33039o, viewGroup, false);
                cVar.f17431a = (ImageView) view2.findViewById(j.f33019w);
                cVar.f17432b = (TextView) view2.findViewById(j.f33018v0);
                cVar.f17433c = (ImageView) view2.findViewById(j.f33017v);
                view2.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
                view2 = view;
            }
            d dVar = (d) PayListView.this.f17428b.get(i10);
            cVar.f17431a.setImageDrawable(dVar.a());
            cVar.f17432b.setText(dVar.c());
            cVar.f17433c.setEnabled(dVar.d());
            return view2;
        }
    }

    /* loaded from: classes2.dex */
    private class c {

        /* renamed from: a  reason: collision with root package name */
        public ImageView f17431a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f17432b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f17433c;

        private c(PayListView payListView) {
        }
    }

    public PayListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }

    private void b() {
        TypedArray obtainTypedArray = getResources().obtainTypedArray(g.f32954b);
        int[] intArray = getResources().getIntArray(g.f32955c);
        String[] stringArray = getResources().getStringArray(g.f32956d);
        this.f17428b = new ArrayList();
        for (int i10 = 0; i10 < stringArray.length; i10++) {
            d dVar = new d();
            dVar.g(intArray[i10]);
            dVar.f(obtainTypedArray.getDrawable(i10));
            dVar.h(stringArray[i10]);
            this.f17428b.add(dVar);
        }
        this.f17428b.get(this.f17429c).e(true);
        obtainTypedArray.recycle();
    }

    public int getPayWayIndex() {
        return this.f17428b.get(this.f17429c).b();
    }

    @Override // android.widget.ListView, android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        b bVar = new b();
        this.f17427a = bVar;
        setAdapter((ListAdapter) bVar);
        setOnItemClickListener(this);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
        this.f17428b.get(this.f17429c).e(false);
        this.f17428b.get(i10).e(true);
        this.f17429c = i10;
        this.f17427a.notifyDataSetChanged();
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    protected void onMeasure(int i10, int i11) {
        super.onMeasure(i10, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }

    public void setPayEnable(int i10) {
        int[] intArray = getResources().getIntArray(g.f32953a);
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < intArray.length; i11++) {
            if ((intArray[i11] & i10) == intArray[i11]) {
                arrayList.add(this.f17428b.get(i11));
            }
        }
        ((d) arrayList.get(this.f17429c)).e(true);
        this.f17428b.clear();
        this.f17428b.addAll(arrayList);
        this.f17427a.notifyDataSetChanged();
    }
}
