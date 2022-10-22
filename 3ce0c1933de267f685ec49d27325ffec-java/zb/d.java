package zb;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.mobvoi.companion.aw.watchfacecenter.bean.WatchFaceBean;
import com.mobvoi.companion.aw.watchfacecenter.m;
import com.mobvoi.companion.aw.watchfacecenter.n;
import com.mobvoi.companion.aw.watchfacecenter.p;
import com.mobvoi.companion.aw.watchfacecenter.q;
import com.mobvoi.companion.aw.watchfacecenter.s;
import com.mobvoi.companion.aw.watchfacecenter.widget.ImageViewPercentLayout;
import com.mobvoi.companion.aw.watchfacecenter.widget.ImageWatchFaceMask;
import com.mobvoi.companion.aw.watchfacecenter.widget.ImageWatchFaceSelector;
import com.mobvoi.companion.aw.watchfacecenter.widget.c;
import com.mobvoi.companion.setting.CompanionSetting;
import com.mobvoi.wear.common.base.TicwatchModels;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.i;
import kotlin.text.t;
import zb.d;
/* compiled from: WatchFaceDetailAdapter.kt */
/* loaded from: classes2.dex */
public final class d extends RecyclerView.Adapter<RecyclerView.b0> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f37331a;

    /* renamed from: b  reason: collision with root package name */
    private WatchFaceBean f37332b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f37333c;

    /* renamed from: d  reason: collision with root package name */
    private final ArrayList<Integer> f37334d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    private zb.a f37335e;

    /* compiled from: WatchFaceDetailAdapter.kt */
    /* loaded from: classes2.dex */
    public static final class a extends RecyclerView.b0 {

        /* renamed from: a  reason: collision with root package name */
        private final View f37336a;

        /* renamed from: b  reason: collision with root package name */
        private final ImageWatchFaceMask f37337b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            i.f(view, "view");
            this.f37336a = view;
            this.f37337b = (ImageWatchFaceMask) view.findViewById(p.c_res_0x7f0b0366);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(zb.a aVar, View view) {
            if (aVar != null) {
                aVar.v();
            }
        }

        public final void b(Context context, WatchFaceBean watchFaceInfo, final zb.a aVar) {
            i.f(context, "context");
            i.f(watchFaceInfo, "watchFaceInfo");
            com.mobvoi.companion.aw.watchfacecenter.i.a(watchFaceInfo, context).u0(this.f37337b);
            this.f37336a.setOnClickListener(new View.OnClickListener() { // from class: zb.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    d.a.c(a.this, view);
                }
            });
        }
    }

    /* compiled from: WatchFaceDetailAdapter.kt */
    /* loaded from: classes2.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: WatchFaceDetailAdapter.kt */
    /* loaded from: classes2.dex */
    public static final class c extends RecyclerView.b0 {

        /* renamed from: a  reason: collision with root package name */
        private final Switch f37338a;

        /* renamed from: b  reason: collision with root package name */
        private final Switch f37339b;

        /* renamed from: c  reason: collision with root package name */
        private zb.a f37340c;

        /* renamed from: d  reason: collision with root package name */
        private final CompoundButton.OnCheckedChangeListener f37341d = new CompoundButton.OnCheckedChangeListener() { // from class: zb.e
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                d.c.d(d.c.this, compoundButton, z10);
            }
        };

        /* renamed from: e  reason: collision with root package name */
        private final CompoundButton.OnCheckedChangeListener f37342e = new CompoundButton.OnCheckedChangeListener() { // from class: zb.f
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                d.c.e(d.c.this, compoundButton, z10);
            }
        };

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(View view) {
            super(view);
            i.f(view, "view");
            this.f37338a = (Switch) view.findViewById(p.z_res_0x7f0b06fa);
            this.f37339b = (Switch) view.findViewById(p.A_res_0x7f0b06fb);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(c this$0, CompoundButton compoundButton, boolean z10) {
            i.f(this$0, "this$0");
            zb.a aVar = this$0.f37340c;
            if (aVar != null) {
                aVar.J(z10);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(c this$0, CompoundButton compoundButton, boolean z10) {
            i.f(this$0, "this$0");
            zb.a aVar = this$0.f37340c;
            if (aVar != null) {
                aVar.s(z10);
            }
        }

        public final void c(WatchFaceBean watchFaceInfo, zb.a aVar) {
            i.f(watchFaceInfo, "watchFaceInfo");
            this.f37340c = aVar;
            this.f37338a.setOnCheckedChangeListener(null);
            Switch r62 = this.f37338a;
            Integer s10 = watchFaceInfo.s();
            boolean z10 = false;
            r62.setChecked((s10 == null ? 0 : s10.intValue()) == 1);
            this.f37338a.setOnCheckedChangeListener(this.f37341d);
            this.f37339b.setOnCheckedChangeListener(null);
            Switch r63 = this.f37339b;
            Integer t10 = watchFaceInfo.t();
            if ((t10 == null ? 0 : t10.intValue()) == 1) {
                z10 = true;
            }
            r63.setChecked(z10);
            this.f37339b.setOnCheckedChangeListener(this.f37342e);
        }
    }

    /* compiled from: WatchFaceDetailAdapter.kt */
    /* renamed from: zb.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0546d extends RecyclerView.b0 {

        /* renamed from: a  reason: collision with root package name */
        private final TextView f37343a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0546d(View view) {
            super(view);
            i.f(view, "view");
            View findViewById = view.findViewById(p.C_res_0x7f0b079f);
            i.e(findViewById, "view.findViewById(R.id.tvDeveloperName)");
            this.f37343a = (TextView) findViewById;
        }

        public final void a(WatchFaceBean watchFaceInfo) {
            i.f(watchFaceInfo, "watchFaceInfo");
            this.f37343a.setText(TextUtils.isEmpty(watchFaceInfo.e()) ? "" : watchFaceInfo.e());
        }
    }

    /* compiled from: WatchFaceDetailAdapter.kt */
    /* loaded from: classes2.dex */
    public static final class e extends RecyclerView.b0 {

        /* renamed from: a  reason: collision with root package name */
        private final View f37344a;

        /* renamed from: b  reason: collision with root package name */
        private ImageView f37345b;

        /* renamed from: c  reason: collision with root package name */
        private ImageWatchFaceMask f37346c;

        /* renamed from: d  reason: collision with root package name */
        private TextView f37347d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(View view) {
            super(view);
            int i10;
            i.f(view, "view");
            this.f37344a = view;
            View findViewById = view.findViewById(p.e_res_0x7f0b036b);
            i.e(findViewById, "view.findViewById(R.id.ivRealWatch)");
            this.f37345b = (ImageView) findViewById;
            int i11 = p.f_res_0x7f0b0370;
            View findViewById2 = view.findViewById(i11);
            i.e(findViewById2, "view.findViewById(R.id.ivWatchFacePreview)");
            this.f37346c = (ImageWatchFaceMask) findViewById2;
            View findViewById3 = view.findViewById(p.B_res_0x7f0b0796);
            i.e(findViewById3, "view.findViewById(R.id.tvApplyWatchFace)");
            this.f37347d = (TextView) findViewById3;
            boolean isE3 = TicwatchModels.isE3(CompanionSetting.getWearModel());
            boolean isRoverU = TicwatchModels.isRoverU(CompanionSetting.getWearModel());
            ImageView imageView = this.f37345b;
            if (isE3) {
                i10 = n.f16458b;
            } else if (isRoverU) {
                i10 = n.f16460d;
            } else {
                i10 = n.f16459c;
            }
            imageView.setImageResource(i10);
            androidx.constraintlayout.widget.c cVar = new androidx.constraintlayout.widget.c();
            cVar.g((ImageViewPercentLayout) view);
            cVar.u(i11, isE3 ? 0.5f : 0.493f);
            cVar.v(i11, isE3 ? 0.36f : 0.353f);
            cVar.c((ImageViewPercentLayout) view);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(zb.a aVar, View view) {
            if (aVar != null) {
                aVar.N();
            }
        }

        public final void b(Context context, boolean z10, WatchFaceBean watchFaceInfo, final zb.a aVar) {
            String str;
            i.f(context, "context");
            i.f(watchFaceInfo, "watchFaceInfo");
            ImageWatchFaceMask imageWatchFaceMask = this.f37346c;
            imageWatchFaceMask.setNeedShowMask(z10);
            if (z10) {
                Integer s10 = watchFaceInfo.s();
                boolean z11 = s10 != null && s10.intValue() == 1;
                Integer t10 = watchFaceInfo.t();
                imageWatchFaceMask.l(z11, t10 != null && t10.intValue() == 1);
            }
            ImageWatchFaceMask imageWatchFaceMask2 = this.f37346c;
            Integer l10 = watchFaceInfo.l();
            imageWatchFaceMask2.setDirection(l10 == null ? 0 : l10.intValue());
            com.mobvoi.companion.aw.watchfacecenter.i.a(watchFaceInfo, context).u0(imageWatchFaceMask);
            this.f37347d.setOnClickListener(new View.OnClickListener() { // from class: zb.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    d.e.c(a.this, view);
                }
            });
            TextView textView = this.f37347d;
            if (watchFaceInfo.j()) {
                if (i.b(watchFaceInfo.g(), Boolean.TRUE)) {
                    str = context.getString(s.w_res_0x7f141259);
                } else {
                    str = context.getString(s.C_res_0x7f141260, String.valueOf(watchFaceInfo.r()));
                }
            } else if (z10) {
                str = context.getString(s.a_res_0x7f14006c);
            } else {
                str = context.getString(s.q_res_0x7f14090f);
            }
            textView.setText(str);
            this.f37347d.setEnabled(watchFaceInfo.f());
        }
    }

    /* compiled from: WatchFaceDetailAdapter.kt */
    /* loaded from: classes2.dex */
    public static final class f extends RecyclerView.b0 {

        /* renamed from: a  reason: collision with root package name */
        private final View f37348a;

        /* renamed from: b  reason: collision with root package name */
        private final TextView f37349b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(View view) {
            super(view);
            i.f(view, "view");
            this.f37348a = view;
            View findViewById = view.findViewById(p.E_res_0x7f0b07b9);
            i.e(findViewById, "view.findViewById(R.id.tvWatchFaceIntroduction)");
            this.f37349b = (TextView) findViewById;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(View view) {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(com.mobvoi.companion.aw.watchfacecenter.widget.c this_apply, View view) {
            i.f(this_apply, "$this_apply");
            this_apply.s(false);
        }

        public final void c(Context context, WatchFaceBean watchFaceInfo) {
            i.f(context, "context");
            i.f(watchFaceInfo, "watchFaceInfo");
            String d10 = watchFaceInfo.d();
            if (d10 != null) {
                final com.mobvoi.companion.aw.watchfacecenter.widget.c cVar = new com.mobvoi.companion.aw.watchfacecenter.widget.c(this.f37349b);
                cVar.p(d10);
                cVar.q(i.n("...", context.getString(s.y_res_0x7f14125c)));
                CharSequence i10 = cVar.i();
                if (i10 != null) {
                    cVar.r(3, i10.length(), m.c_res_0x7f06062d, i.f37362a);
                }
                cVar.e(false);
                cVar.l().setOnClickListener(new View.OnClickListener() { // from class: zb.h
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        d.f.e(c.this, view);
                    }
                });
            }
        }
    }

    /* compiled from: WatchFaceDetailAdapter.kt */
    /* loaded from: classes2.dex */
    public static final class g extends RecyclerView.b0 {

        /* renamed from: a  reason: collision with root package name */
        private final RecyclerView f37350a;

        /* renamed from: b  reason: collision with root package name */
        private final zb.b f37351b;

        /* renamed from: c  reason: collision with root package name */
        private final int f37352c = aa.d.a(12.0f);

        /* compiled from: WatchFaceDetailAdapter.kt */
        /* loaded from: classes2.dex */
        public static final class a extends RecyclerView.n {
            a() {
            }

            @Override // androidx.recyclerview.widget.RecyclerView.n
            public void d(Rect outRect, View view, RecyclerView parent, RecyclerView.y state) {
                i.f(outRect, "outRect");
                i.f(view, "view");
                i.f(parent, "parent");
                i.f(state, "state");
                outRect.left = g.this.f37352c;
                int g02 = parent.g0(view) + 1;
                RecyclerView.Adapter adapter = parent.getAdapter();
                int i10 = 0;
                if (g02 == (adapter == null ? 0 : adapter.getItemCount())) {
                    i10 = g.this.f37352c;
                }
                outRect.right = i10;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(Context context, View view) {
            super(view);
            i.f(context, "context");
            i.f(view, "view");
            View findViewById = view.findViewById(p.q_res_0x7f0b05b9);
            i.e(findViewById, "view.findViewById(R.id.rvPreviewImages)");
            RecyclerView recyclerView = (RecyclerView) findViewById;
            this.f37350a = recyclerView;
            zb.b bVar = new zb.b(context);
            this.f37351b = bVar;
            recyclerView.setLayoutManager(new LinearLayoutManager(context, 0, false));
            recyclerView.setAdapter(bVar);
            recyclerView.h(new a());
        }

        public final void b(List<String> list) {
            if (list != null) {
                this.f37351b.f(list);
                this.f37351b.notifyDataSetChanged();
            }
        }
    }

    /* compiled from: WatchFaceDetailAdapter.kt */
    /* loaded from: classes2.dex */
    public static final class h extends RecyclerView.b0 {

        /* renamed from: a  reason: collision with root package name */
        private ImageWatchFaceSelector f37354a;

        /* renamed from: b  reason: collision with root package name */
        private ImageWatchFaceSelector f37355b;

        /* renamed from: c  reason: collision with root package name */
        private ImageWatchFaceSelector f37356c;

        /* renamed from: d  reason: collision with root package name */
        private zb.a f37357d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(View view) {
            super(view);
            i.f(view, "view");
            View findViewById = view.findViewById(p.w_res_0x7f0b05fc);
            i.e(findViewById, "view.findViewById(R.id.selectorTop)");
            this.f37354a = (ImageWatchFaceSelector) findViewById;
            View findViewById2 = view.findViewById(p.u_res_0x7f0b05fa);
            i.e(findViewById2, "view.findViewById(R.id.selectorDown)");
            this.f37355b = (ImageWatchFaceSelector) findViewById2;
            View findViewById3 = view.findViewById(p.v_res_0x7f0b05fb);
            i.e(findViewById3, "view.findViewById(R.id.selectorMiddle)");
            this.f37356c = (ImageWatchFaceSelector) findViewById3;
            this.f37354a.setOnClickListener(new View.OnClickListener() { // from class: zb.k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    d.h.d(d.h.this, view2);
                }
            });
            this.f37355b.setOnClickListener(new View.OnClickListener() { // from class: zb.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    d.h.e(d.h.this, view2);
                }
            });
            this.f37356c.setOnClickListener(new View.OnClickListener() { // from class: zb.l
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    d.h.f(d.h.this, view2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(h this$0, View view) {
            i.f(this$0, "this$0");
            this$0.h(0);
            zb.a aVar = this$0.f37357d;
            if (aVar != null) {
                aVar.p(0);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(h this$0, View view) {
            i.f(this$0, "this$0");
            this$0.h(1);
            zb.a aVar = this$0.f37357d;
            if (aVar != null) {
                aVar.p(1);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void f(h this$0, View view) {
            i.f(this$0, "this$0");
            this$0.h(2);
            zb.a aVar = this$0.f37357d;
            if (aVar != null) {
                aVar.p(2);
            }
        }

        private final void h(int i10) {
            if (i10 == 0) {
                this.f37354a.setChosenState(true);
                this.f37355b.setChosenState(false);
                this.f37356c.setChosenState(false);
            } else if (i10 != 1) {
                this.f37354a.setChosenState(false);
                this.f37355b.setChosenState(false);
                this.f37356c.setChosenState(true);
            } else {
                this.f37354a.setChosenState(false);
                this.f37355b.setChosenState(true);
                this.f37356c.setChosenState(false);
            }
        }

        private final void i(boolean z10, boolean z11) {
            this.f37356c.getImageView().l(z10, z11);
            this.f37354a.getImageView().l(z10, z11);
            this.f37355b.getImageView().l(z10, z11);
        }

        public final void g(Context context, WatchFaceBean watchFaceInfo, zb.a aVar) {
            i.f(context, "context");
            i.f(watchFaceInfo, "watchFaceInfo");
            this.f37357d = aVar;
            Integer l10 = watchFaceInfo.l();
            boolean z10 = false;
            h(l10 == null ? 0 : l10.intValue());
            Integer s10 = watchFaceInfo.s();
            boolean z11 = s10 != null && s10.intValue() == 1;
            Integer t10 = watchFaceInfo.t();
            if (t10 != null && t10.intValue() == 1) {
                z10 = true;
            }
            i(z11, z10);
            com.mobvoi.companion.aw.watchfacecenter.i.a(watchFaceInfo, context).u0(this.f37356c.getImageView());
            com.mobvoi.companion.aw.watchfacecenter.i.a(watchFaceInfo, context).u0(this.f37354a.getImageView());
            com.mobvoi.companion.aw.watchfacecenter.i.a(watchFaceInfo, context).u0(this.f37355b.getImageView());
        }
    }

    static {
        new b(null);
    }

    public d(Context context, WatchFaceBean watchFaceInfo) {
        i.f(context, "context");
        i.f(watchFaceInfo, "watchFaceInfo");
        this.f37331a = context;
        this.f37332b = watchFaceInfo;
        f(this.f37332b);
    }

    private final View c(int i10, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.f37331a).inflate(i10, viewGroup, false);
        i.e(inflate, "from(context).inflate(layoutId, parent, false)");
        return inflate;
    }

    public final boolean d() {
        return this.f37333c;
    }

    public final void e(zb.a listener) {
        i.f(listener, "listener");
        this.f37335e = listener;
    }

    public final void f(WatchFaceBean watchFaceInfo) {
        boolean q5;
        List<String> o10;
        i.f(watchFaceInfo, "watchFaceInfo");
        this.f37332b = watchFaceInfo;
        boolean z10 = false;
        q5 = t.q(watchFaceInfo.i(), this.f37331a.getString(s.x_res_0x7f14125b), false, 2, null);
        this.f37333c = q5;
        this.f37332b.A(!q5);
        ArrayList<Integer> arrayList = this.f37334d;
        arrayList.clear();
        arrayList.add(0);
        if (d()) {
            arrayList.add(4);
            arrayList.add(5);
            arrayList.add(6);
            return;
        }
        if (!TextUtils.isEmpty(watchFaceInfo.e())) {
            arrayList.add(1);
        }
        if (watchFaceInfo.o() != null && (!o10.isEmpty())) {
            z10 = true;
        }
        if (z10) {
            arrayList.add(2);
        }
        if (!TextUtils.isEmpty(watchFaceInfo.d())) {
            arrayList.add(3);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f37334d.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i10) {
        Integer num = this.f37334d.get(i10);
        i.e(num, "itemTypeList[position]");
        return num.intValue();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.b0 holder, int i10) {
        i.f(holder, "holder");
        switch (getItemViewType(i10)) {
            case 0:
                ((e) holder).b(this.f37331a, this.f37333c, this.f37332b, this.f37335e);
                return;
            case 1:
                ((C0546d) holder).a(this.f37332b);
                return;
            case 2:
                ((g) holder).b(this.f37332b.o());
                return;
            case 3:
                ((f) holder).c(this.f37331a, this.f37332b);
                return;
            case 4:
                ((h) holder).g(this.f37331a, this.f37332b, this.f37335e);
                return;
            case 5:
                ((c) holder).c(this.f37332b, this.f37335e);
                return;
            case 6:
                ((a) holder).b(this.f37331a, this.f37332b, this.f37335e);
                return;
            default:
                return;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.b0 onCreateViewHolder(ViewGroup parent, int i10) {
        i.f(parent, "parent");
        switch (i10) {
            case 0:
                return new e(c(q.k_res_0x7f0e0181, parent));
            case 1:
                return new C0546d(c(q.j_res_0x7f0e0180, parent));
            case 2:
                return new g(this.f37331a, c(q.n_res_0x7f0e0184, parent));
            case 3:
                return new f(c(q.l_res_0x7f0e0182, parent));
            case 4:
                return new h(c(q.i_res_0x7f0e017f, parent));
            case 5:
                return new c(c(q.h_res_0x7f0e017e, parent));
            case 6:
                return new a(c(q.g_res_0x7f0e017d, parent));
            default:
                return new e(c(q.k_res_0x7f0e0181, parent));
        }
    }
}
