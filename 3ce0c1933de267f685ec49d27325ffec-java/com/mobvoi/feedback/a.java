package com.mobvoi.feedback;

import a5.j;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.c;
import com.mobvoi.feedback.bean.FeedBackImageEntity;
import java.util.ArrayList;
import java.util.List;
import ne.t;
import ne.u;
import ne.v;
import ne.w;
import ne.x;
/* compiled from: FeedbackImageListAdapter.java */
/* loaded from: classes2.dex */
class a extends RecyclerView.Adapter<b> implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private final Context f17888a;

    /* renamed from: b  reason: collision with root package name */
    private List<FeedBackImageEntity> f17889b;

    /* renamed from: c  reason: collision with root package name */
    private final int f17890c;

    /* renamed from: d  reason: collision with root package name */
    private AbstractC0212a f17891d;

    /* compiled from: FeedbackImageListAdapter.java */
    /* renamed from: com.mobvoi.feedback.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    interface AbstractC0212a {
        void s(int i10);

        void t();
    }

    /* compiled from: FeedbackImageListAdapter.java */
    /* loaded from: classes2.dex */
    public static class b extends se.a {

        /* renamed from: a  reason: collision with root package name */
        ImageView f17892a;

        /* renamed from: b  reason: collision with root package name */
        ImageView f17893b;

        public b(View view) {
            super(view);
            this.f17892a = (ImageView) view.findViewById(w.f31200o);
            this.f17893b = (ImageView) view.findViewById(w.f31193h);
        }
    }

    public a(Context context, List<FeedBackImageEntity> list) {
        this.f17888a = context;
        this.f17889b = list;
        this.f17890c = context.getResources().getDimensionPixelSize(u.f31179a);
    }

    /* renamed from: c */
    public void onBindViewHolder(b bVar, int i10) {
        if (i10 != getItemCount() - 1 || this.f17889b.size() >= getItemCount()) {
            bVar.itemView.setClickable(false);
            bVar.f17893b.setVisibility(0);
            bVar.f17893b.setTag(bVar);
            bVar.f17893b.setOnClickListener(this);
            bVar.f17892a.setBackgroundResource(v.f31183b);
            c.u(this.f17888a).q(this.f17889b.get(i10).f17897b).c().a(j5.c.j0(new j(this.f17890c))).u0(bVar.f17892a);
            return;
        }
        bVar.itemView.setOnClickListener(this);
        bVar.itemView.setClickable(true);
        bVar.f17893b.setVisibility(8);
        bVar.f17892a.setImageResource(v.f31182a);
        bVar.f17892a.setBackgroundColor(androidx.core.content.b.c(this.f17888a, t.f31178a));
    }

    /* renamed from: d */
    public b onCreateViewHolder(ViewGroup viewGroup, int i10) {
        return new b(LayoutInflater.from(this.f17888a).inflate(x.f31211e, viewGroup, false));
    }

    public void e(AbstractC0212a aVar) {
        this.f17891d = aVar;
    }

    public void f(ArrayList<FeedBackImageEntity> arrayList) {
        this.f17889b = arrayList;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return Math.min(9, this.f17889b.size() + 1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AbstractC0212a aVar;
        int id2 = view.getId();
        if (id2 == w.f31188c) {
            AbstractC0212a aVar2 = this.f17891d;
            if (aVar2 != null) {
                aVar2.t();
            }
        } else if (id2 == w.f31193h && (aVar = this.f17891d) != null) {
            aVar.s(((b) view.getTag()).getAdapterPosition());
        }
    }
}
