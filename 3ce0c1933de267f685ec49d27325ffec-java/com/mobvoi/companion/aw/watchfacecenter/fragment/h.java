package com.mobvoi.companion.aw.watchfacecenter.fragment;

import aa.d;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.lifecycle.h0;
import androidx.lifecycle.x;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import cc.e;
import com.mobvoi.companion.aw.watchfacecenter.AWWatchFaceActivity;
import com.mobvoi.companion.aw.watchfacecenter.WatchFaceViewModel;
import com.mobvoi.companion.aw.watchfacecenter.bean.WatchFaceBean;
import com.mobvoi.companion.aw.watchfacecenter.k;
import com.mobvoi.companion.aw.watchfacecenter.p;
import com.mobvoi.companion.aw.watchfacecenter.r;
import com.mobvoi.companion.aw.watchfacecenter.s;
import io.m;
import java.util.ArrayList;
import java.util.Objects;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import rx.j;
import zb.q;
/* compiled from: WatchFaceCardListFragment.kt */
/* loaded from: classes2.dex */
public final class h extends com.mobvoi.companion.aw.watchfacecenter.fragment.a implements k {

    /* renamed from: c  reason: collision with root package name */
    private q f16390c;

    /* renamed from: d  reason: collision with root package name */
    private WatchFaceViewModel f16391d;

    /* renamed from: e  reason: collision with root package name */
    private int f16392e;

    /* renamed from: f  reason: collision with root package name */
    private int f16393f;

    /* renamed from: g  reason: collision with root package name */
    private RecyclerView f16394g;

    /* renamed from: h  reason: collision with root package name */
    private SwipeRefreshLayout f16395h;

    /* compiled from: WatchFaceCardListFragment.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* compiled from: WatchFaceCardListFragment.kt */
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
            int g02 = parent.g0(view);
            RecyclerView.Adapter adapter = parent.getAdapter();
            int i10 = 0;
            boolean z10 = g02 == (adapter == null ? -1 : adapter.getItemCount());
            h hVar = h.this;
            outRect.left = 0;
            outRect.right = 0;
            outRect.top = hVar.f16392e;
            if (z10) {
                i10 = hVar.f16393f;
            }
            outRect.bottom = i10;
        }
    }

    static {
        new a(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(h this$0, WatchFaceBean bean) {
        i.f(this$0, "this$0");
        RecyclerView recyclerView = this$0.f16394g;
        if (recyclerView != null) {
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            Objects.requireNonNull(adapter, "null cannot be cast to non-null type com.mobvoi.companion.aw.watchfacecenter.adapter.WatchFacesCardAdapter");
            i.e(bean, "bean");
            ((q) adapter).i(bean);
            return;
        }
        i.u("rvWatchFaceList");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o0(h this$0) {
        i.f(this$0, "this$0");
        SwipeRefreshLayout swipeRefreshLayout = this$0.f16395h;
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setRefreshing(false);
            SwipeRefreshLayout swipeRefreshLayout2 = this$0.f16395h;
            if (swipeRefreshLayout2 != null) {
                swipeRefreshLayout2.setEnabled(false);
            } else {
                i.u("swipeRefreshLayout");
                throw null;
            }
        } else {
            i.u("swipeRefreshLayout");
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p0(h this$0, ArrayList list) {
        i.f(this$0, "this$0");
        q qVar = this$0.f16390c;
        if (qVar != null) {
            i.e(list, "list");
            qVar.h(list);
            return;
        }
        i.u("watchFacesCardAdapter");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q0(Throwable th2) {
        com.mobvoi.android.common.utils.k.d("WatchFaceCardListFragment", th2.getMessage());
    }

    @Override // com.mobvoi.companion.aw.watchfacecenter.k
    public void F(e watchFaceCardBean) {
        i.f(watchFaceCardBean, "watchFaceCardBean");
        Bundle bundle = new Bundle();
        bundle.putString("cardName", watchFaceCardBean.b());
        bundle.putInt("cardIndex", watchFaceCardBean.a());
        bundle.putInt("secondId", watchFaceCardBean.e());
        Context context = getContext();
        Objects.requireNonNull(context, "null cannot be cast to non-null type com.mobvoi.companion.aw.watchfacecenter.AWWatchFaceActivity");
        ((AWWatchFaceActivity) context).b0("more_watch_fragment", bundle, a0());
    }

    @Override // com.mobvoi.companion.aw.watchfacecenter.k
    public void I(WatchFaceBean watchFaceBean) {
        i.f(watchFaceBean, "watchFaceBean");
        Context context = getContext();
        Objects.requireNonNull(context, "null cannot be cast to non-null type com.mobvoi.companion.aw.watchfacecenter.AWWatchFaceActivity");
        Bundle bundle = new Bundle();
        bundle.putParcelable("watchface_bean", watchFaceBean);
        m mVar = m.f28349a;
        ((AWWatchFaceActivity) context).b0("detail_fragment", bundle, a0());
    }

    @Override // com.mobvoi.companion.aw.watchfacecenter.fragment.a
    public int Z() {
        return com.mobvoi.companion.aw.watchfacecenter.q.c_res_0x7f0e00d6;
    }

    @Override // com.mobvoi.companion.aw.watchfacecenter.fragment.a
    public void b0(Context context) {
        i.f(context, "context");
        androidx.fragment.app.f requireActivity = requireActivity();
        i.e(requireActivity, "requireActivity()");
        WatchFaceViewModel watchFaceViewModel = (WatchFaceViewModel) new h0(requireActivity).a(WatchFaceViewModel.class);
        this.f16391d = watchFaceViewModel;
        if (watchFaceViewModel != null) {
            String string = context.getString(s.D);
            i.e(string, "context.getString(R.string.watchfaces_center_title)");
            watchFaceViewModel.a0(string);
            WatchFaceViewModel watchFaceViewModel2 = this.f16391d;
            if (watchFaceViewModel2 != null) {
                watchFaceViewModel2.t().i(requireActivity(), new x() { // from class: com.mobvoi.companion.aw.watchfacecenter.fragment.d
                    @Override // androidx.lifecycle.x
                    public final void a(Object obj) {
                        h.n0(h.this, (WatchFaceBean) obj);
                    }
                });
                WatchFaceViewModel watchFaceViewModel3 = this.f16391d;
                if (watchFaceViewModel3 == null) {
                    i.u("viewModel");
                    throw null;
                } else if (watchFaceViewModel3 != null) {
                    j Y = watchFaceViewModel3.I(context).r(new yp.a() { // from class: com.mobvoi.companion.aw.watchfacecenter.fragment.e
                        @Override // yp.a
                        public final void call() {
                            h.o0(h.this);
                        }
                    }).Y(new yp.b() { // from class: com.mobvoi.companion.aw.watchfacecenter.fragment.f
                        @Override // yp.b
                        public final void call(Object obj) {
                            h.p0(h.this, (ArrayList) obj);
                        }
                    }, g.f16389a);
                    i.e(Y, "viewModel.requestCardsList(context)\n            .doOnTerminate {\n                swipeRefreshLayout.isRefreshing = false\n                swipeRefreshLayout.isEnabled = false\n            }.subscribe({ list ->\n                watchFacesCardAdapter.setWatchFaces(list)\n            }, { throwable ->\n                LogUtil.e(TAG, throwable.message)\n            })");
                    watchFaceViewModel3.o(Y);
                } else {
                    i.u("viewModel");
                    throw null;
                }
            } else {
                i.u("viewModel");
                throw null;
            }
        } else {
            i.u("viewModel");
            throw null;
        }
    }

    @Override // com.mobvoi.companion.aw.watchfacecenter.fragment.a
    protected void c0(Context context) {
        i.f(context, "context");
        this.f16392e = d.b(12.0f, context);
        this.f16393f = d.b(38.0f, context);
    }

    @Override // com.mobvoi.companion.aw.watchfacecenter.fragment.a
    public void d0(Context context, View view) {
        i.f(context, "context");
        i.f(view, "view");
        View findViewById = view.findViewById(p.s_res_0x7f0b05bb);
        i.e(findViewById, "view.findViewById(R.id.rvWatchFaceList)");
        this.f16394g = (RecyclerView) findViewById;
        View findViewById2 = view.findViewById(p.y_res_0x7f0b06f7);
        i.e(findViewById2, "view.findViewById(R.id.swipeRefreshLayout)");
        this.f16395h = (SwipeRefreshLayout) findViewById2;
        RecyclerView recyclerView = this.f16394g;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            q qVar = new q(context);
            qVar.g(this);
            m mVar = m.f28349a;
            this.f16390c = qVar;
            recyclerView.setAdapter(qVar);
            recyclerView.h(new b());
            SwipeRefreshLayout swipeRefreshLayout = this.f16395h;
            if (swipeRefreshLayout != null) {
                swipeRefreshLayout.setColorSchemeResources(com.mobvoi.companion.aw.watchfacecenter.m.d_res_0x7f06062e);
                swipeRefreshLayout.setRefreshing(true);
                return;
            }
            i.u("swipeRefreshLayout");
            throw null;
        }
        i.u("rvWatchFaceList");
        throw null;
    }

    @Override // com.mobvoi.companion.aw.watchfacecenter.fragment.a, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        i.f(menu, "menu");
        i.f(inflater, "inflater");
        inflater.inflate(r.a_res_0x7f0f000f, menu);
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z10) {
        super.onHiddenChanged(z10);
        if (!z10) {
            WatchFaceViewModel watchFaceViewModel = this.f16391d;
            if (watchFaceViewModel != null) {
                String string = requireActivity().getString(s.D);
                i.e(string, "requireActivity().getString(R.string.watchfaces_center_title)");
                watchFaceViewModel.a0(string);
                WatchFaceViewModel watchFaceViewModel2 = this.f16391d;
                if (watchFaceViewModel2 != null) {
                    watchFaceViewModel2.r(true);
                } else {
                    i.u("viewModel");
                    throw null;
                }
            } else {
                i.u("viewModel");
                throw null;
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem item) {
        i.f(item, "item");
        if (item.getItemId() != p.l_res_0x7f0b04b7) {
            return super.onOptionsItemSelected(item);
        }
        Context context = getContext();
        Objects.requireNonNull(context, "null cannot be cast to non-null type com.mobvoi.companion.aw.watchfacecenter.AWWatchFaceActivity");
        ((AWWatchFaceActivity) context).b0("my_watch_face_fragment", null, a0());
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        sb.a.h(requireActivity(), "awWfCenter");
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        sb.a.i(requireActivity(), "awWfCenter");
    }

    @Override // com.mobvoi.companion.aw.watchfacecenter.k
    public void w(WatchFaceBean watchFaceBean) {
        i.f(watchFaceBean, "watchFaceBean");
        WatchFaceViewModel watchFaceViewModel = this.f16391d;
        if (watchFaceViewModel != null) {
            watchFaceViewModel.B(watchFaceBean, a0());
            com.mobvoi.companion.aw.watchfacecenter.fragment.a.g0(this, watchFaceBean, "wfListClickBtn", null, 4, null);
            return;
        }
        i.u("viewModel");
        throw null;
    }
}
