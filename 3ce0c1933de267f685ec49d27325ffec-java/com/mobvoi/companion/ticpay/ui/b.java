package com.mobvoi.companion.ticpay.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import qd.b;
import qd.h;
import qd.i;
import qd.j;
import qd.k;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ChooseDefaultCardDialog.java */
/* loaded from: classes2.dex */
public class b<T extends qd.b> extends Dialog implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private b<T>.c f17602a;

    /* renamed from: b  reason: collision with root package name */
    private AbstractC0210b<T> f17603b;

    /* renamed from: c  reason: collision with root package name */
    private T f17604c;

    /* renamed from: d  reason: collision with root package name */
    private T f17605d;

    /* renamed from: e  reason: collision with root package name */
    private ImageView f17606e;

    /* renamed from: f  reason: collision with root package name */
    private int f17607f = -1;

    /* renamed from: g  reason: collision with root package name */
    private final List<T> f17608g = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ChooseDefaultCardDialog.java */
    /* loaded from: classes2.dex */
    public class a implements DialogInterface.OnDismissListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            b.this.f17606e = null;
            b.this.f17605d = null;
            b.this.f17604c = null;
            b.this.f17607f = -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ChooseDefaultCardDialog.java */
    /* renamed from: com.mobvoi.companion.ticpay.ui.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface AbstractC0210b<T> {
        void a(T t10, T t11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ChooseDefaultCardDialog.java */
    /* loaded from: classes2.dex */
    public class c extends RecyclerView.Adapter<d> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ChooseDefaultCardDialog.java */
        /* loaded from: classes2.dex */
        public class a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ d f17611a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ qd.b f17612b;

            a(d dVar, qd.b bVar) {
                this.f17611a = dVar;
                this.f17612b = bVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int adapterPosition = this.f17611a.getAdapterPosition();
                if (b.this.f17607f != adapterPosition) {
                    if (b.this.f17606e != null) {
                        b.this.f17606e.setImageResource(i.f32964e);
                    }
                    this.f17611a.f17617d.setImageResource(i.f32963d);
                    b.this.f17604c = this.f17612b;
                    b.this.f17607f = adapterPosition;
                    b.this.f17606e = this.f17611a.f17617d;
                }
            }
        }

        private c() {
        }

        private void c(T t10, ImageView imageView) {
            String a10 = t10.a();
            if (!TextUtils.isEmpty(t10.a())) {
                com.bumptech.glide.c.u(b.this.getContext()).r(a10).U(i.f32960a).f0(new RoundedCornersTransformation(b.this.getContext(), b.this.getContext().getResources().getDimensionPixelSize(h.f32958b), 0)).u0(imageView);
            } else if (t10 instanceof ud.a) {
                imageView.setImageResource(((ud.a) t10).iconRes);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: d */
        public void onBindViewHolder(d dVar, int i10) {
            qd.b bVar = (qd.b) b.this.f17608g.get(i10);
            if (b.this.f17605d != null && bVar == b.this.f17605d) {
                b.this.f17606e = dVar.f17617d;
            }
            dVar.f17615b.setText(bVar.b());
            dVar.f17616c.setText(bVar.c());
            if (bVar.d()) {
                dVar.f17617d.setImageResource(i.f32963d);
            } else {
                dVar.f17617d.setImageResource(i.f32964e);
            }
            dVar.itemView.setOnClickListener(new a(dVar, bVar));
            c(bVar, dVar.f17614a);
        }

        /* renamed from: e */
        public d onCreateViewHolder(ViewGroup viewGroup, int i10) {
            View inflate = View.inflate(b.this.getContext(), k.f33038n, null);
            inflate.setLayoutParams(new RecyclerView.o(-1, -2));
            return new d(inflate);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return b.this.f17608g.size();
        }

        /* synthetic */ c(b bVar, a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ChooseDefaultCardDialog.java */
    /* loaded from: classes2.dex */
    public static class d extends RecyclerView.b0 {

        /* renamed from: a  reason: collision with root package name */
        ImageView f17614a;

        /* renamed from: b  reason: collision with root package name */
        TextView f17615b;

        /* renamed from: c  reason: collision with root package name */
        TextView f17616c;

        /* renamed from: d  reason: collision with root package name */
        ImageView f17617d;

        d(View view) {
            super(view);
            this.f17614a = (ImageView) view.findViewById(j.f32978b0);
            this.f17615b = (TextView) view.findViewById(j.f33010r0);
            this.f17616c = (TextView) view.findViewById(j.f33004o0);
            this.f17617d = (ImageView) view.findViewById(j.f32997l);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Context context, int i10) {
        super(context, i10);
        i();
    }

    private void i() {
        setContentView(k.f33035k);
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        findViewById(j.f32999m).setOnClickListener(this);
        findViewById(j.P).setOnClickListener(this);
        RecyclerView recyclerView = (RecyclerView) findViewById(j.f32990h0);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.h(new ba.a(0, -3355444, getContext().getResources().getDimensionPixelSize(h.f32959c), 0));
        b<T>.c cVar = new c(this, null);
        this.f17602a = cVar;
        recyclerView.setAdapter(cVar);
        setOnDismissListener(new a());
    }

    public void j(AbstractC0210b<T> bVar) {
        this.f17603b = bVar;
    }

    public void k(List<T> list) {
        synchronized (this.f17608g) {
            this.f17608g.clear();
            if (list != null) {
                for (T t10 : list) {
                    if (t10.d()) {
                        this.f17605d = t10;
                    }
                    this.f17608g.add(t10);
                }
            }
            this.f17602a.notifyDataSetChanged();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AbstractC0210b<T> bVar;
        int id2 = view.getId();
        if (id2 == j.f32999m) {
            dismiss();
        } else if (id2 == j.P) {
            T t10 = this.f17605d;
            T t11 = this.f17604c;
            if (!(t10 == t11 || (bVar = this.f17603b) == null || t11 == null)) {
                bVar.a(t11, t10);
            }
            dismiss();
        }
    }
}
