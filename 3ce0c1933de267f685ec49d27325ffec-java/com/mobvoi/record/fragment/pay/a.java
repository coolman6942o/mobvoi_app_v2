package com.mobvoi.record.fragment.pay;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.mobvoi.companion.proto.ProductProto;
import com.mobvoi.record.g;
import com.mobvoi.record.h;
import com.mobvoi.record.i;
import com.mobvoi.record.k;
import com.mobvoi.record.utils.d;
import java.util.List;
/* compiled from: ProductListAdapter.java */
/* loaded from: classes2.dex */
public class a extends RecyclerView.Adapter<b> {

    /* renamed from: a  reason: collision with root package name */
    private Context f20515a;

    /* renamed from: b  reason: collision with root package name */
    private List<ProductProto.SoundProduct> f20516b;

    /* renamed from: c  reason: collision with root package name */
    private c f20517c;

    /* renamed from: d  reason: collision with root package name */
    private int f20518d = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ProductListAdapter.java */
    /* renamed from: com.mobvoi.record.fragment.pay.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class View$OnClickListenerC0237a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f20519a;

        View$OnClickListenerC0237a(int i10) {
            this.f20519a = i10;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f20517c != null) {
                a.this.f20517c.a(this.f20519a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ProductListAdapter.java */
    /* loaded from: classes2.dex */
    public static class b extends RecyclerView.b0 {

        /* renamed from: a  reason: collision with root package name */
        private TextView f20521a;

        /* renamed from: b  reason: collision with root package name */
        private TextView f20522b;

        /* renamed from: c  reason: collision with root package name */
        private TextView f20523c;

        public b(View view) {
            super(view);
            this.f20523c = (TextView) view.findViewById(h.O0);
            this.f20521a = (TextView) view.findViewById(h.P0);
            this.f20522b = (TextView) view.findViewById(h.Q0);
        }
    }

    /* compiled from: ProductListAdapter.java */
    /* loaded from: classes2.dex */
    public interface c {
        void a(int i10);
    }

    public a(Context context, List<ProductProto.SoundProduct> list) {
        this.f20515a = context;
        this.f20516b = list;
    }

    /* renamed from: d */
    public void onBindViewHolder(b bVar, int i10) {
        bVar.f20521a.setText(d.c(this.f20515a, this.f20516b.get(i10).getPaymentTime()));
        if (this.f20515a.getPackageName().equals("com.mobvoi.companion.aw")) {
            bVar.f20523c.setText(String.format(this.f20515a.getResources().getString(k.F), this.f20516b.get(i10).getPricePerHour()));
            bVar.f20522b.setText(String.format(this.f20515a.getResources().getString(k.J), this.f20516b.get(i10).getActualPrice()));
        } else {
            bVar.f20523c.setText(String.format(this.f20515a.getResources().getString(k.E), this.f20516b.get(i10).getPricePerHour()));
            bVar.f20522b.setText(String.format(this.f20515a.getResources().getString(k.I), this.f20516b.get(i10).getActualPrice()));
        }
        if (this.f20518d == i10) {
            bVar.itemView.setBackgroundResource(g.f20566c);
        } else {
            bVar.itemView.setBackgroundResource(g.f20565b);
        }
        bVar.itemView.setOnClickListener(new View$OnClickListenerC0237a(i10));
    }

    /* renamed from: e */
    public b onCreateViewHolder(ViewGroup viewGroup, int i10) {
        return new b(LayoutInflater.from(this.f20515a).inflate(i.f20650q, viewGroup, false));
    }

    public void f(c cVar) {
        this.f20517c = cVar;
    }

    public void g(int i10) {
        this.f20518d = i10;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f20516b.size();
    }
}
