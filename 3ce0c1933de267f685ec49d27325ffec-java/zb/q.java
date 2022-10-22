package zb;

import android.content.Context;
import android.graphics.Typeface;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cc.e;
import com.mobvoi.companion.aw.watchfacecenter.bean.WatchFaceBean;
import com.mobvoi.companion.aw.watchfacecenter.k;
import com.mobvoi.companion.aw.watchfacecenter.n;
import com.mobvoi.companion.aw.watchfacecenter.p;
import com.mobvoi.companion.aw.watchfacecenter.s;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.collections.m;
import kotlin.jvm.internal.i;
import kotlin.text.t;
/* compiled from: WatchFacesCardAdapter.kt */
/* loaded from: classes2.dex */
public final class q extends RecyclerView.Adapter<a> {

    /* renamed from: a  reason: collision with root package name */
    private Context f37379a;

    /* renamed from: b  reason: collision with root package name */
    private k f37380b;

    /* renamed from: c  reason: collision with root package name */
    private SparseArray<e> f37381c = new SparseArray<>();

    /* renamed from: d  reason: collision with root package name */
    private SparseArray<Integer> f37382d = new SparseArray<>();

    /* compiled from: WatchFacesCardAdapter.kt */
    /* loaded from: classes2.dex */
    public static final class a extends RecyclerView.b0 {

        /* renamed from: a  reason: collision with root package name */
        private TextView f37383a;

        /* renamed from: b  reason: collision with root package name */
        private RecyclerView f37384b;

        /* renamed from: c  reason: collision with root package name */
        private TextView f37385c;

        /* renamed from: d  reason: collision with root package name */
        private RelativeLayout f37386d;

        /* renamed from: e  reason: collision with root package name */
        private ImageView f37387e;

        /* renamed from: f  reason: collision with root package name */
        private TextView f37388f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            i.f(view, "view");
            View findViewById = view.findViewById(p.a_res_0x7f0b0169);
            Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
            this.f37383a = (TextView) findViewById;
            View findViewById2 = view.findViewById(p.t_res_0x7f0b05c4);
            Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
            this.f37384b = (RecyclerView) findViewById2;
            View findViewById3 = view.findViewById(p.k_res_0x7f0b049a);
            Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
            this.f37385c = (TextView) findViewById3;
            View findViewById4 = view.findViewById(p.o_res_0x7f0b05a8);
            Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.widget.RelativeLayout");
            this.f37386d = (RelativeLayout) findViewById4;
            View findViewById5 = view.findViewById(p.g_res_0x7f0b0394);
            Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type android.widget.ImageView");
            this.f37387e = (ImageView) findViewById5;
            View findViewById6 = view.findViewById(p.F);
            Objects.requireNonNull(findViewById6, "null cannot be cast to non-null type android.widget.TextView");
            this.f37388f = (TextView) findViewById6;
        }

        public final TextView a() {
            return this.f37383a;
        }

        public final ImageView b() {
            return this.f37387e;
        }

        public final TextView c() {
            return this.f37385c;
        }

        public final RelativeLayout d() {
            return this.f37386d;
        }

        public final RecyclerView e() {
            return this.f37384b;
        }

        public final TextView f() {
            return this.f37388f;
        }
    }

    public q(Context context) {
        i.f(context, "context");
        this.f37379a = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(q this$0, e cardBean, View view) {
        i.f(this$0, "this$0");
        k kVar = this$0.f37380b;
        if (kVar != null) {
            i.e(cardBean, "cardBean");
            kVar.F(cardBean);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0064, code lost:
        if (r0 != false) goto L9;
     */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onBindViewHolder(a viewHolder, int i10) {
        boolean q5;
        boolean q10;
        i.f(viewHolder, "viewHolder");
        final e eVar = this.f37381c.get(i10);
        viewHolder.a().setText(eVar.b());
        viewHolder.a().setTypeface(Typeface.defaultFromStyle(1));
        List<WatchFaceBean> c10 = eVar.c();
        if (c10 != null) {
            RecyclerView.Adapter adapter = viewHolder.e().getAdapter();
            Objects.requireNonNull(adapter, "null cannot be cast to non-null type com.mobvoi.companion.aw.watchfacecenter.adapter.WatchFacesAdapter");
            ((o) adapter).l(c10);
        }
        q5 = t.q(eVar.b(), this.f37379a.getString(s.f16469e), false, 2, null);
        if (!q5) {
            q10 = t.q(eVar.b(), this.f37379a.getString(s.f16472r), false, 2, null);
        }
        if (eVar.d() == 1 || eVar.d() == 2) {
            viewHolder.d().setVisibility(0);
            int d10 = eVar.d();
            if (d10 == 1) {
                viewHolder.b().setBackgroundResource(n.f16462f);
                viewHolder.f().setText(this.f37379a.getString(s.A));
            } else if (d10 == 2) {
                viewHolder.b().setBackgroundResource(n.f16461e);
                viewHolder.f().setText(this.f37379a.getString(s.B));
            }
        } else {
            viewHolder.d().setVisibility(8);
        }
        if (eVar.f()) {
            viewHolder.c().setVisibility(0);
        } else {
            viewHolder.c().setVisibility(8);
        }
        viewHolder.c().setOnClickListener(new View.OnClickListener() { // from class: zb.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                q.e(q.this, eVar, view);
            }
        });
    }

    /* renamed from: f */
    public a onCreateViewHolder(ViewGroup viewGroup, int i10) {
        i.f(viewGroup, "viewGroup");
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(com.mobvoi.companion.aw.watchfacecenter.q.e_res_0x7f0e0149, viewGroup, false);
        i.e(view, "view");
        a aVar = new a(view);
        o oVar = new o(this.f37379a, 6);
        k kVar = this.f37380b;
        if (kVar != null) {
            oVar.k(kVar);
        }
        aVar.e().setLayoutManager(new GridLayoutManager(this.f37379a, 3));
        aVar.e().setAdapter(oVar);
        return aVar;
    }

    public final void g(k clickMoreDataListener) {
        i.f(clickMoreDataListener, "clickMoreDataListener");
        this.f37380b = clickMoreDataListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f37381c.size();
    }

    public final void h(ArrayList<e> watchFaceCardBeanList) {
        i.f(watchFaceCardBeanList, "watchFaceCardBeanList");
        this.f37381c.clear();
        this.f37382d.clear();
        if (!watchFaceCardBeanList.isEmpty()) {
            int i10 = 0;
            for (Object obj : watchFaceCardBeanList) {
                i10++;
                if (i10 < 0) {
                    m.o();
                }
                e eVar = (e) obj;
                this.f37381c.put(i10, eVar);
                this.f37382d.put(eVar.a(), Integer.valueOf(i10));
            }
        }
        notifyDataSetChanged();
    }

    public final void i(WatchFaceBean watchFaceBean) {
        List<WatchFaceBean> c10;
        i.f(watchFaceBean, "watchFaceBean");
        Integer num = this.f37382d.get(100);
        if (num != null) {
            e eVar = this.f37381c.get(num.intValue());
            if (eVar != null && (c10 = eVar.c()) != null && (!c10.isEmpty())) {
                WatchFaceBean watchFaceBean2 = c10.get(0);
                watchFaceBean2.F(watchFaceBean.m());
                watchFaceBean2.E(watchFaceBean.l());
                watchFaceBean2.K(watchFaceBean.t());
                watchFaceBean2.J(watchFaceBean.s());
                notifyItemChanged(this.f37381c.size() - 1);
            }
        }
    }
}
