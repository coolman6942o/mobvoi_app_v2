package com.mobvoi.companion.aw.watchfacecenter.fragment;

import aa.d;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.h0;
import androidx.lifecycle.x;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cc.e;
import com.mobvoi.companion.aw.watchfacecenter.AWWatchFaceActivity;
import com.mobvoi.companion.aw.watchfacecenter.WatchFaceViewModel;
import com.mobvoi.companion.aw.watchfacecenter.bean.WatchFaceBean;
import com.mobvoi.companion.aw.watchfacecenter.k;
import com.mobvoi.companion.aw.watchfacecenter.p;
import com.mobvoi.companion.aw.watchfacecenter.q;
import com.mobvoi.companion.aw.watchfacecenter.s;
import io.m;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import zb.o;
/* compiled from: MyWatchFaceListFragment.kt */
/* loaded from: classes2.dex */
public final class c extends com.mobvoi.companion.aw.watchfacecenter.fragment.a implements k {

    /* renamed from: c  reason: collision with root package name */
    private int f16381c;

    /* renamed from: d  reason: collision with root package name */
    private WatchFaceViewModel f16382d;

    /* renamed from: e  reason: collision with root package name */
    private o f16383e;

    /* renamed from: f  reason: collision with root package name */
    private RecyclerView f16384f;

    /* compiled from: MyWatchFaceListFragment.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* compiled from: MyWatchFaceListFragment.kt */
    /* loaded from: classes2.dex */
    public static final class b extends RecyclerView.n {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.n
        public void d(Rect outRect, View view, RecyclerView parent, RecyclerView.y state) {
            i.f(outRect, "outRect");
            i.f(view, "view");
            i.f(parent, "parent");
            i.f(state, "state");
            outRect.top = parent.g0(view) / 3 == 0 ? c.this.f16381c : 0;
        }
    }

    static {
        new a(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j0(c this$0, WatchFaceBean bean) {
        i.f(this$0, "this$0");
        o oVar = this$0.f16383e;
        if (oVar != null) {
            i.e(bean, "bean");
            oVar.m(bean);
        }
    }

    private final void k0(String str) {
        WatchFaceViewModel watchFaceViewModel = this.f16382d;
        if (watchFaceViewModel != null) {
            watchFaceViewModel.a0(str);
        } else {
            i.u("viewModel");
            throw null;
        }
    }

    @Override // com.mobvoi.companion.aw.watchfacecenter.k
    public void F(e watchFaceCardBean) {
        i.f(watchFaceCardBean, "watchFaceCardBean");
    }

    @Override // com.mobvoi.companion.aw.watchfacecenter.k
    public void I(WatchFaceBean watchFaceBean) {
        i.f(watchFaceBean, "watchFaceBean");
        if (getActivity() instanceof AWWatchFaceActivity) {
            androidx.fragment.app.f activity = getActivity();
            Objects.requireNonNull(activity, "null cannot be cast to non-null type com.mobvoi.companion.aw.watchfacecenter.AWWatchFaceActivity");
            Bundle bundle = new Bundle();
            bundle.putParcelable("watchface_bean", watchFaceBean);
            m mVar = m.f28349a;
            ((AWWatchFaceActivity) activity).b0("detail_fragment", bundle, a0());
        }
    }

    @Override // com.mobvoi.companion.aw.watchfacecenter.fragment.a
    public int Z() {
        return q.o_res_0x7f0e0186;
    }

    @Override // com.mobvoi.companion.aw.watchfacecenter.fragment.a
    public void b0(Context context) {
        i.f(context, "context");
        androidx.fragment.app.f requireActivity = requireActivity();
        i.e(requireActivity, "requireActivity()");
        WatchFaceViewModel watchFaceViewModel = (WatchFaceViewModel) new h0(requireActivity).a(WatchFaceViewModel.class);
        this.f16382d = watchFaceViewModel;
        if (watchFaceViewModel != null) {
            watchFaceViewModel.t().i(requireActivity(), new x() { // from class: com.mobvoi.companion.aw.watchfacecenter.fragment.b
                @Override // androidx.lifecycle.x
                public final void a(Object obj) {
                    c.j0(c.this, (WatchFaceBean) obj);
                }
            });
            o oVar = this.f16383e;
            if (oVar != null) {
                ArrayList arrayList = new ArrayList();
                WatchFaceViewModel watchFaceViewModel2 = this.f16382d;
                if (watchFaceViewModel2 != null) {
                    List<WatchFaceBean> y10 = watchFaceViewModel2.y(100);
                    if (y10 != null && (!y10.isEmpty())) {
                        arrayList.addAll(y10);
                    }
                    WatchFaceViewModel watchFaceViewModel3 = this.f16382d;
                    if (watchFaceViewModel3 != null) {
                        List<WatchFaceBean> y11 = watchFaceViewModel3.y(101);
                        if (y11 != null && (!y11.isEmpty())) {
                            arrayList.addAll(y11);
                        }
                        m mVar = m.f28349a;
                        oVar.l(arrayList);
                    } else {
                        i.u("viewModel");
                        throw null;
                    }
                } else {
                    i.u("viewModel");
                    throw null;
                }
            }
            String string = getString(s.z_res_0x7f14125d);
            i.e(string, "getString(R.string.watchface_my_list)");
            k0(string);
            return;
        }
        i.u("viewModel");
        throw null;
    }

    @Override // com.mobvoi.companion.aw.watchfacecenter.fragment.a
    protected void c0(Context context) {
        i.f(context, "context");
        this.f16381c = d.b(12.0f, context);
    }

    @Override // com.mobvoi.companion.aw.watchfacecenter.fragment.a
    public void d0(Context context, View view) {
        i.f(context, "context");
        i.f(view, "view");
        View findViewById = view.findViewById(p.p_res_0x7f0b05b8);
        i.e(findViewById, "view.findViewById(R.id.rvMyWatchFace)");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        this.f16384f = recyclerView;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new GridLayoutManager(context, 3));
            o oVar = new o(context, 0, 2, null);
            oVar.k(this);
            m mVar = m.f28349a;
            this.f16383e = oVar;
            recyclerView.setAdapter(oVar);
            recyclerView.h(new b());
            return;
        }
        i.u("rvMyWatchFace");
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z10) {
        super.onHiddenChanged(z10);
        if (!z10) {
            String string = getString(s.z_res_0x7f14125d);
            i.e(string, "getString(R.string.watchface_my_list)");
            k0(string);
            WatchFaceViewModel watchFaceViewModel = this.f16382d;
            if (watchFaceViewModel != null) {
                watchFaceViewModel.r(false);
            } else {
                i.u("viewModel");
                throw null;
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        sb.a.h(requireActivity(), "awMyWf");
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        sb.a.i(requireActivity(), "awMyWf");
    }

    @Override // com.mobvoi.companion.aw.watchfacecenter.k
    public void w(WatchFaceBean watchFaceBean) {
        i.f(watchFaceBean, "watchFaceBean");
        WatchFaceViewModel watchFaceViewModel = this.f16382d;
        if (watchFaceViewModel != null) {
            watchFaceViewModel.B(watchFaceBean, a0());
        } else {
            i.u("viewModel");
            throw null;
        }
    }
}
