package zb;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.c;
import com.bumptech.glide.g;
import com.mobvoi.companion.aw.watchfacecenter.bean.WatchFaceBean;
import com.mobvoi.companion.aw.watchfacecenter.k;
import com.mobvoi.companion.aw.watchfacecenter.n;
import com.mobvoi.companion.aw.watchfacecenter.p;
import com.mobvoi.companion.aw.watchfacecenter.q;
import com.mobvoi.companion.aw.watchfacecenter.s;
import com.mobvoi.companion.aw.watchfacecenter.widget.ImageWatchFaceMask;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import kotlin.text.t;
/* compiled from: WatchFacesAdapter.kt */
/* loaded from: classes2.dex */
public final class o extends RecyclerView.Adapter<a> {

    /* renamed from: a  reason: collision with root package name */
    private Context f37370a;

    /* renamed from: b  reason: collision with root package name */
    private final int f37371b;

    /* renamed from: c  reason: collision with root package name */
    private final ArrayList<WatchFaceBean> f37372c;

    /* renamed from: d  reason: collision with root package name */
    private k f37373d;

    /* compiled from: WatchFacesAdapter.kt */
    /* loaded from: classes2.dex */
    public static final class a extends RecyclerView.b0 {

        /* renamed from: a  reason: collision with root package name */
        private ImageWatchFaceMask f37374a;

        /* renamed from: b  reason: collision with root package name */
        private TextView f37375b;

        /* renamed from: c  reason: collision with root package name */
        private TextView f37376c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            i.f(view, "view");
            View findViewById = view.findViewById(p.b_res_0x7f0b032b);
            Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.mobvoi.companion.aw.watchfacecenter.widget.ImageWatchFaceMask");
            this.f37374a = (ImageWatchFaceMask) findViewById;
            View findViewById2 = view.findViewById(p.m_res_0x7f0b04ba);
            Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
            this.f37375b = (TextView) findViewById2;
            View findViewById3 = view.findViewById(p.B_res_0x7f0b0796);
            Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
            this.f37376c = (TextView) findViewById3;
        }

        public final ImageWatchFaceMask a() {
            return this.f37374a;
        }

        public final TextView b() {
            return this.f37375b;
        }

        public final TextView c() {
            return this.f37376c;
        }
    }

    public /* synthetic */ o(Context context, int i10, int i11, f fVar) {
        this(context, (i11 & 2) != 0 ? 0 : i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(o this$0, WatchFaceBean watchFaceInfo, View view) {
        i.f(this$0, "this$0");
        i.f(watchFaceInfo, "$watchFaceInfo");
        k kVar = this$0.f37373d;
        if (kVar != null) {
            kVar.I(watchFaceInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(o this$0, WatchFaceBean watchFaceInfo, View view) {
        i.f(this$0, "this$0");
        i.f(watchFaceInfo, "$watchFaceInfo");
        k kVar = this$0.f37373d;
        if (kVar != null) {
            kVar.w(watchFaceInfo);
        }
    }

    public final void e(List<WatchFaceBean> list) {
        i.f(list, "list");
        int size = this.f37372c.size();
        this.f37372c.addAll(list);
        notifyItemRangeInserted(size, list.size());
    }

    /* renamed from: f */
    public void onBindViewHolder(a viewHolder, int i10) {
        boolean q5;
        String str;
        i.f(viewHolder, "viewHolder");
        WatchFaceBean watchFaceBean = this.f37372c.get(i10);
        i.e(watchFaceBean, "watchFaceList[position]");
        final WatchFaceBean watchFaceBean2 = watchFaceBean;
        viewHolder.a().setTag(watchFaceBean2.i());
        g<Bitmap> a10 = com.mobvoi.companion.aw.watchfacecenter.i.a(watchFaceBean2, this.f37370a);
        int i11 = n.f16462f;
        a10.U(i11).j(i11).u0(viewHolder.a());
        viewHolder.b().setText(watchFaceBean2.i());
        q5 = t.q(watchFaceBean2.i(), this.f37370a.getString(s.x_res_0x7f14125b), false, 2, null);
        if (q5) {
            viewHolder.a().setNeedShowMask(true);
            ImageWatchFaceMask a11 = viewHolder.a();
            Integer l10 = watchFaceBean2.l();
            a11.setDirection(l10 == null ? 0 : l10.intValue());
        } else {
            viewHolder.a().setNeedShowMask(false);
        }
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: zb.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                o.g(o.this, watchFaceBean2, view);
            }
        });
        viewHolder.c().setOnClickListener(new View.OnClickListener() { // from class: zb.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                o.h(o.this, watchFaceBean2, view);
            }
        });
        TextView c10 = viewHolder.c();
        if (!watchFaceBean2.j()) {
            str = this.f37370a.getString(s.q_res_0x7f14090f);
        } else if (i.b(watchFaceBean2.g(), Boolean.TRUE)) {
            str = this.f37370a.getString(s.w_res_0x7f141259);
        } else {
            str = this.f37370a.getString(s.C_res_0x7f141260, String.valueOf(watchFaceBean2.r()));
        }
        c10.setText(str);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f37371b == 0 ? this.f37372c.size() : Math.min(this.f37372c.size(), this.f37371b);
    }

    /* renamed from: i */
    public a onCreateViewHolder(ViewGroup viewGroup, int i10) {
        i.f(viewGroup, "viewGroup");
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(q.p_res_0x7f0e019d, viewGroup, false);
        i.e(view, "view");
        return new a(view);
    }

    /* renamed from: j */
    public void onViewRecycled(a holder) {
        i.f(holder, "holder");
        super.onViewRecycled(holder);
        c.u(this.f37370a).l(holder.a());
    }

    public final void k(k clickWatchListener) {
        i.f(clickWatchListener, "clickWatchListener");
        this.f37373d = clickWatchListener;
    }

    public final void l(List<WatchFaceBean> list) {
        boolean z10 = false;
        if (list != null && (!list.isEmpty())) {
            z10 = true;
        }
        if (z10) {
            this.f37372c.clear();
            this.f37372c.addAll(list);
            notifyDataSetChanged();
        }
    }

    public final void m(WatchFaceBean watchFaceBean) {
        i.f(watchFaceBean, "watchFaceBean");
        Iterator<WatchFaceBean> it = this.f37372c.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            i10++;
            it.next();
            if (i.b(this.f37372c.get(i10).c(), "com.mobvoi.ticwear.watchface.service.ImageWatchFace")) {
                WatchFaceBean watchFaceBean2 = this.f37372c.get(i10);
                watchFaceBean2.F(watchFaceBean.m());
                watchFaceBean2.E(watchFaceBean.l());
                watchFaceBean2.K(watchFaceBean.t());
                watchFaceBean2.J(watchFaceBean.s());
                notifyItemChanged(i10);
                return;
            }
        }
    }

    public o(Context context, int i10) {
        i.f(context, "context");
        this.f37370a = context;
        this.f37371b = i10;
        this.f37372c = new ArrayList<>();
    }
}
