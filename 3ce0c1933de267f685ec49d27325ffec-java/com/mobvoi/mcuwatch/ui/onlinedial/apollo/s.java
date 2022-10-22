package com.mobvoi.mcuwatch.ui.onlinedial.apollo;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.h0;
import androidx.lifecycle.x;
import com.mobvoi.android.common.utils.s;
import com.mobvoi.apollo.client.q;
import com.mobvoi.mcuwatch.ui.customview.OnlineDialGridView;
import com.mobvoi.mcuwatch.ui.customview.j;
import com.mobvoi.mcuwatch.ui.customview.j0;
import com.mobvoi.mcuwatch.ui.customview.t;
import com.mobvoi.mcuwatch.ui.customview.y;
import java.util.List;
import java.util.Objects;
import kotlin.collections.m;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import sh.h;
import sh.k;
/* compiled from: DialCenterFragment.kt */
/* loaded from: classes2.dex */
public final class s extends Fragment implements s.a, t {

    /* renamed from: a  reason: collision with root package name */
    private GridView f19942a;

    /* renamed from: b  reason: collision with root package name */
    private RelativeLayout f19943b;

    /* renamed from: c  reason: collision with root package name */
    private final io.d f19944c;

    /* renamed from: d  reason: collision with root package name */
    private List<? extends yh.c> f19945d;

    /* renamed from: e  reason: collision with root package name */
    private yh.c f19946e;

    /* renamed from: f  reason: collision with root package name */
    private com.mobvoi.android.common.utils.s f19947f = new com.mobvoi.android.common.utils.s(this);

    /* renamed from: g  reason: collision with root package name */
    private j0 f19948g;

    /* compiled from: DialCenterFragment.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DialCenterFragment.kt */
    /* loaded from: classes2.dex */
    public final class b extends BaseAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ s f19949a;

        public b(s this$0) {
            i.f(this$0, "this$0");
            this.f19949a = this$0;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.f19949a.f19945d.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i10) {
            return this.f19949a.f19945d.get(i10);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i10) {
            return i10;
        }

        @Override // android.widget.Adapter
        public View getView(int i10, View view, ViewGroup viewGroup) {
            c cVar;
            boolean z10 = false;
            if (view == null) {
                view = LayoutInflater.from(this.f19949a.requireContext()).inflate(sh.i.f34735d1, viewGroup, false);
                i.e(view, "from(requireContext()).inflate(R.layout.xxitemwatch, parent, false)");
                cVar = new c(view);
                view.setTag(cVar);
            } else {
                Object tag = view.getTag();
                Objects.requireNonNull(tag, "null cannot be cast to non-null type com.mobvoi.mcuwatch.ui.onlinedial.apollo.DialCenterFragment.ViewHolder");
                cVar = (c) tag;
            }
            OnlineDialGridView onlineDialGridView = viewGroup instanceof OnlineDialGridView ? (OnlineDialGridView) viewGroup : null;
            if (onlineDialGridView != null && onlineDialGridView.f19586a) {
                z10 = true;
            }
            if (z10) {
                return view;
            }
            yh.c cVar2 = (yh.c) this.f19949a.f19945d.get(i10);
            cVar.b().setText(cVar2.title);
            com.bumptech.glide.c.v(this.f19949a).r(cVar2.watchFaceUrl).u0(cVar.a());
            return view;
        }
    }

    /* compiled from: DialCenterFragment.kt */
    /* loaded from: classes2.dex */
    private static final class c {

        /* renamed from: a  reason: collision with root package name */
        private final ImageView f19950a;

        /* renamed from: b  reason: collision with root package name */
        private final TextView f19951b;

        public c(View view) {
            i.f(view, "view");
            View findViewById = view.findViewById(h.f34669n1);
            i.e(findViewById, "view.findViewById(R.id.ivBiaoPan)");
            this.f19950a = (ImageView) findViewById;
            View findViewById2 = view.findViewById(h.f34676o4);
            i.e(findViewById2, "view.findViewById(R.id.txtTitle)");
            this.f19951b = (TextView) findViewById2;
        }

        public final ImageView a() {
            return this.f19950a;
        }

        public final TextView b() {
            return this.f19951b;
        }
    }

    /* compiled from: DialCenterFragment.kt */
    /* loaded from: classes2.dex */
    static final class d extends Lambda implements qo.a<v> {
        d() {
            super(0);
        }

        /* renamed from: a */
        public final v invoke() {
            androidx.fragment.app.f requireActivity = s.this.requireActivity();
            i.e(requireActivity, "requireActivity()");
            return (v) new h0(requireActivity).a(v.class);
        }
    }

    static {
        new a(null);
    }

    public s() {
        super(sh.i.V);
        io.d a10;
        List<? extends yh.c> g10;
        a10 = io.f.a(new d());
        this.f19944c = a10;
        g10 = m.g();
        this.f19945d = g10;
    }

    private final void b0() {
        j0 j0Var = this.f19948g;
        if (j0Var != null) {
            j0Var.dismiss();
        }
        this.f19948g = null;
    }

    private final v c0() {
        return (v) this.f19944c.getValue();
    }

    private final void d0() {
        List<? extends yh.c> list = this.f19945d;
        if (list == null || list.isEmpty()) {
            RelativeLayout relativeLayout = this.f19943b;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(0);
            } else {
                i.u("noDialTip");
                throw null;
            }
        } else {
            RelativeLayout relativeLayout2 = this.f19943b;
            if (relativeLayout2 != null) {
                relativeLayout2.setVisibility(8);
            } else {
                i.u("noDialTip");
                throw null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e0(s this$0, AdapterView adapterView, View view, int i10, long j10) {
        i.f(this$0, "this$0");
        if (!q.f15504a.B()) {
            y.b(1, this$0.requireContext());
            return;
        }
        this$0.f19946e = this$0.f19945d.get(i10);
        Context requireContext = this$0.requireContext();
        i.e(requireContext, "requireContext()");
        yh.c cVar = this$0.f19946e;
        i.d(cVar);
        j jVar = new j(requireContext, cVar, false, this$0.f19947f, this$0);
        this$0.f19948g = jVar;
        jVar.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f0(s this$0, b dialAdapter, List list) {
        i.f(this$0, "this$0");
        i.f(dialAdapter, "$dialAdapter");
        if (list != null) {
            this$0.f19945d = list;
            dialAdapter.notifyDataSetChanged();
            this$0.d0();
        }
    }

    @Override // com.mobvoi.android.common.utils.s.a
    public void handleMessage(Message message) {
        if (getContext() != null) {
            Integer valueOf = message == null ? null : Integer.valueOf(message.what);
            if (valueOf != null && valueOf.intValue() == 0) {
                b0();
                aa.c.d(requireContext().getResources().getString(k.f34875u2));
            } else if (valueOf != null && valueOf.intValue() == 10) {
                b0();
                aa.c.d(getResources().getString(k.A3));
            } else if (valueOf != null && valueOf.intValue() == 11) {
                b0();
                aa.c.d(getResources().getString(k.S3));
            } else if (valueOf != null && valueOf.intValue() == 12) {
                b0();
                aa.c.d(getResources().getString(k.O3));
            } else if (valueOf != null && valueOf.intValue() == 13) {
                b0();
                aa.c.d(getResources().getString(k.R3));
            } else if (valueOf != null && valueOf.intValue() == 14) {
                b0();
                aa.c.d(getResources().getString(k.Q3));
            }
        }
    }

    @Override // com.mobvoi.mcuwatch.ui.customview.t
    public void n() {
        if (nj.k.f31276a) {
            aa.c.d(getResources().getString(k.P3));
        } else {
            b0();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        b0();
        this.f19947f.removeCallbacksAndMessages(null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        i.f(view, "view");
        View findViewById = view.findViewById(h.D4);
        i.e(findViewById, "view.findViewById(R.id.xxListView)");
        this.f19942a = (GridView) findViewById;
        View findViewById2 = view.findViewById(h.f34670n2);
        i.e(findViewById2, "view.findViewById(R.id.no_dial_tip)");
        this.f19943b = (RelativeLayout) findViewById2;
        final b bVar = new b(this);
        GridView gridView = this.f19942a;
        if (gridView != null) {
            gridView.setAdapter((ListAdapter) bVar);
            d0();
            GridView gridView2 = this.f19942a;
            if (gridView2 != null) {
                gridView2.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.mobvoi.mcuwatch.ui.onlinedial.apollo.q
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public final void onItemClick(AdapterView adapterView, View view2, int i10, long j10) {
                        s.e0(s.this, adapterView, view2, i10, j10);
                    }
                });
                c0().c().i(getViewLifecycleOwner(), new x() { // from class: com.mobvoi.mcuwatch.ui.onlinedial.apollo.r
                    @Override // androidx.lifecycle.x
                    public final void a(Object obj) {
                        s.f0(s.this, bVar, (List) obj);
                    }
                });
                return;
            }
            i.u("dialGridView");
            throw null;
        }
        i.u("dialGridView");
        throw null;
    }
}
