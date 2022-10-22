package com.mobvoi.companion.aw.watchfacecenter.fragment;

import aa.d;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.h0;
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
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import io.m;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import kotlin.text.t;
import rx.c;
import rx.j;
import vm.g;
import zb.o;
/* compiled from: WatchFaceListMoreFragment.kt */
/* loaded from: classes2.dex */
public final class w extends com.mobvoi.companion.aw.watchfacecenter.fragment.a implements k {

    /* renamed from: c  reason: collision with root package name */
    private o f16423c;

    /* renamed from: d  reason: collision with root package name */
    private WatchFaceViewModel f16424d;

    /* renamed from: e  reason: collision with root package name */
    private String f16425e;

    /* renamed from: f  reason: collision with root package name */
    private int f16426f = 1;

    /* renamed from: g  reason: collision with root package name */
    private int f16427g;

    /* renamed from: h  reason: collision with root package name */
    private int f16428h;

    /* renamed from: i  reason: collision with root package name */
    private int f16429i;

    /* renamed from: j  reason: collision with root package name */
    private RecyclerView f16430j;

    /* renamed from: k  reason: collision with root package name */
    private SmartRefreshLayout f16431k;

    /* renamed from: l  reason: collision with root package name */
    private View f16432l;

    /* compiled from: WatchFaceListMoreFragment.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* compiled from: WatchFaceListMoreFragment.kt */
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
            outRect.top = parent.g0(view) / 3 == 0 ? w.this.f16429i : 0;
        }
    }

    static {
        new a(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m0(w this$0, sm.f it) {
        i.f(this$0, "this$0");
        i.f(it, "it");
        this$0.f16426f = 1;
        Context requireContext = this$0.requireContext();
        i.e(requireContext, "requireContext()");
        this$0.p0(requireContext, this$0.f16426f, 21, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(w this$0, sm.f it) {
        i.f(this$0, "this$0");
        i.f(it, "it");
        this$0.f16426f++;
        Context requireContext = this$0.requireContext();
        i.e(requireContext, "requireContext()");
        this$0.p0(requireContext, this$0.f16426f, 21, true);
    }

    private final void o0(List<WatchFaceBean> list, boolean z10) {
        boolean z11 = false;
        if (z10) {
            o oVar = this.f16423c;
            if (oVar != null) {
                oVar.e(list);
                SmartRefreshLayout smartRefreshLayout = this.f16431k;
                if (smartRefreshLayout != null) {
                    smartRefreshLayout.p();
                    SmartRefreshLayout smartRefreshLayout2 = this.f16431k;
                    if (smartRefreshLayout2 != null) {
                        if (list.size() >= 21) {
                            z11 = true;
                        }
                        smartRefreshLayout2.F(z11);
                    } else {
                        i.u("smartRefreshLayout");
                        throw null;
                    }
                } else {
                    i.u("smartRefreshLayout");
                    throw null;
                }
            } else {
                i.u("moreWatchAdapter");
                throw null;
            }
        } else {
            o oVar2 = this.f16423c;
            if (oVar2 != null) {
                oVar2.l(list);
                SmartRefreshLayout smartRefreshLayout3 = this.f16431k;
                if (smartRefreshLayout3 != null) {
                    smartRefreshLayout3.u();
                    SmartRefreshLayout smartRefreshLayout4 = this.f16431k;
                    if (smartRefreshLayout4 != null) {
                        if (list.size() >= 21) {
                            z11 = true;
                        }
                        smartRefreshLayout4.F(z11);
                    } else {
                        i.u("smartRefreshLayout");
                        throw null;
                    }
                } else {
                    i.u("smartRefreshLayout");
                    throw null;
                }
            } else {
                i.u("moreWatchAdapter");
                throw null;
            }
        }
        t0(1);
    }

    private final void p0(Context context, int i10, int i11, final boolean z10) {
        c<ArrayList<WatchFaceBean>> cVar;
        int i12 = this.f16428h;
        if (i12 == 0) {
            WatchFaceViewModel watchFaceViewModel = this.f16424d;
            if (watchFaceViewModel != null) {
                cVar = watchFaceViewModel.U(context, i10, i11);
            } else {
                i.u("viewModel");
                throw null;
            }
        } else {
            WatchFaceViewModel watchFaceViewModel2 = this.f16424d;
            if (watchFaceViewModel2 != null) {
                cVar = watchFaceViewModel2.V(context, i10, i11, 6, i12);
            } else {
                i.u("viewModel");
                throw null;
            }
        }
        WatchFaceViewModel watchFaceViewModel3 = this.f16424d;
        if (watchFaceViewModel3 != null) {
            j Y = cVar.Z(cq.a.c()).H(xp.a.b()).Y(new yp.b() { // from class: com.mobvoi.companion.aw.watchfacecenter.fragment.u
                @Override // yp.b
                public final void call(Object obj) {
                    w.q0(w.this, z10, (ArrayList) obj);
                }
            }, v.f16422a);
            i.e(Y, "observable\n            .subscribeOn(Schedulers.io())\n            .observeOn(AndroidSchedulers.mainThread())\n            .subscribe({ list ->\n                onGetWatchFaceList(list, isLoadMore)\n            }, { throwable ->\n                LogUtil.e(TAG, throwable.message)\n            })");
            watchFaceViewModel3.o(Y);
            return;
        }
        i.u("viewModel");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q0(w this$0, boolean z10, ArrayList list) {
        i.f(this$0, "this$0");
        i.e(list, "list");
        this$0.o0(list, z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r0(Throwable th2) {
        com.mobvoi.android.common.utils.k.d("WatchFaceListMoreFragment", th2.getMessage());
    }

    private final void s0() {
        String str = this.f16425e;
        if (str != null) {
            WatchFaceViewModel watchFaceViewModel = this.f16424d;
            if (watchFaceViewModel != null) {
                watchFaceViewModel.a0(str);
            } else {
                i.u("viewModel");
                throw null;
            }
        }
    }

    private final void t0(int i10) {
        if (i10 == 0) {
            View view = this.f16432l;
            if (view != null) {
                view.setVisibility(0);
                RecyclerView recyclerView = this.f16430j;
                if (recyclerView != null) {
                    recyclerView.setVisibility(8);
                } else {
                    i.u("moreWatchListRv");
                    throw null;
                }
            } else {
                i.u("rlLoading");
                throw null;
            }
        } else if (i10 == 1) {
            View view2 = this.f16432l;
            if (view2 != null) {
                view2.setVisibility(8);
                RecyclerView recyclerView2 = this.f16430j;
                if (recyclerView2 != null) {
                    recyclerView2.setVisibility(0);
                } else {
                    i.u("moreWatchListRv");
                    throw null;
                }
            } else {
                i.u("rlLoading");
                throw null;
            }
        }
    }

    @Override // com.mobvoi.companion.aw.watchfacecenter.k
    public void F(e watchFaceCardBean) {
        i.f(watchFaceCardBean, "watchFaceCardBean");
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
        return q.d_res_0x7f0e00d9;
    }

    @Override // com.mobvoi.companion.aw.watchfacecenter.fragment.a
    public void b0(Context context) {
        boolean q5;
        boolean q10;
        i.f(context, "context");
        androidx.fragment.app.f requireActivity = requireActivity();
        i.e(requireActivity, "requireActivity()");
        this.f16424d = (WatchFaceViewModel) new h0(requireActivity).a(WatchFaceViewModel.class);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f16427g = arguments.getInt("cardIndex");
            this.f16425e = arguments.getString("cardName");
            this.f16428h = arguments.getInt("secondId");
        }
        q5 = t.q(this.f16425e, getString(s.f16471h), false, 2, null);
        if (!q5) {
            q10 = t.q(this.f16425e, getString(s.f16469e), false, 2, null);
            if (!q10) {
                SmartRefreshLayout smartRefreshLayout = this.f16431k;
                if (smartRefreshLayout != null) {
                    smartRefreshLayout.setEnabled(true);
                    SmartRefreshLayout smartRefreshLayout2 = this.f16431k;
                    if (smartRefreshLayout2 != null) {
                        smartRefreshLayout2.G(false);
                        SmartRefreshLayout smartRefreshLayout3 = this.f16431k;
                        if (smartRefreshLayout3 != null) {
                            smartRefreshLayout3.F(false);
                            Context requireContext = requireContext();
                            i.e(requireContext, "requireContext()");
                            p0(requireContext, this.f16426f, 21, false);
                            s0();
                            return;
                        }
                        i.u("smartRefreshLayout");
                        throw null;
                    }
                    i.u("smartRefreshLayout");
                    throw null;
                }
                i.u("smartRefreshLayout");
                throw null;
            }
        }
        o oVar = this.f16423c;
        if (oVar != null) {
            WatchFaceViewModel watchFaceViewModel = this.f16424d;
            if (watchFaceViewModel != null) {
                oVar.l(watchFaceViewModel.y(this.f16427g));
                t0(1);
                SmartRefreshLayout smartRefreshLayout4 = this.f16431k;
                if (smartRefreshLayout4 != null) {
                    smartRefreshLayout4.setEnabled(false);
                    s0();
                    return;
                }
                i.u("smartRefreshLayout");
                throw null;
            }
            i.u("viewModel");
            throw null;
        }
        i.u("moreWatchAdapter");
        throw null;
    }

    @Override // com.mobvoi.companion.aw.watchfacecenter.fragment.a
    protected void c0(Context context) {
        i.f(context, "context");
        this.f16429i = d.b(12.0f, context);
    }

    @Override // com.mobvoi.companion.aw.watchfacecenter.fragment.a
    public void d0(Context context, View view) {
        i.f(context, "context");
        i.f(view, "view");
        View findViewById = view.findViewById(p.j_res_0x7f0b0499);
        i.e(findViewById, "view.findViewById(R.id.moreWatchListRv)");
        this.f16430j = (RecyclerView) findViewById;
        View findViewById2 = view.findViewById(p.x_res_0x7f0b0663);
        i.e(findViewById2, "view.findViewById(R.id.smartRefreshLayout)");
        this.f16431k = (SmartRefreshLayout) findViewById2;
        View findViewById3 = view.findViewById(p.n_res_0x7f0b059e);
        i.e(findViewById3, "view.findViewById(R.id.rlLoading)");
        this.f16432l = findViewById3;
        RecyclerView recyclerView = this.f16430j;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new GridLayoutManager(context, 3));
            o oVar = new o(context, 0, 2, null);
            oVar.k(this);
            m mVar = m.f28349a;
            this.f16423c = oVar;
            RecyclerView recyclerView2 = this.f16430j;
            if (recyclerView2 != null) {
                recyclerView2.setAdapter(oVar);
                RecyclerView recyclerView3 = this.f16430j;
                if (recyclerView3 != null) {
                    recyclerView3.h(new b());
                    t0(0);
                    SmartRefreshLayout smartRefreshLayout = this.f16431k;
                    if (smartRefreshLayout != null) {
                        smartRefreshLayout.J(new g() { // from class: com.mobvoi.companion.aw.watchfacecenter.fragment.t
                            @Override // vm.g
                            public final void c(sm.f fVar) {
                                w.m0(w.this, fVar);
                            }
                        });
                        SmartRefreshLayout smartRefreshLayout2 = this.f16431k;
                        if (smartRefreshLayout2 != null) {
                            smartRefreshLayout2.I(new vm.e() { // from class: com.mobvoi.companion.aw.watchfacecenter.fragment.s
                                @Override // vm.e
                                public final void a(sm.f fVar) {
                                    w.n0(w.this, fVar);
                                }
                            });
                        } else {
                            i.u("smartRefreshLayout");
                            throw null;
                        }
                    } else {
                        i.u("smartRefreshLayout");
                        throw null;
                    }
                } else {
                    i.u("moreWatchListRv");
                    throw null;
                }
            } else {
                i.u("moreWatchListRv");
                throw null;
            }
        } else {
            i.u("moreWatchListRv");
            throw null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z10) {
        super.onHiddenChanged(z10);
        if (!z10) {
            s0();
            WatchFaceViewModel watchFaceViewModel = this.f16424d;
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
        sb.a.h(requireActivity(), "awCategoryWf");
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        sb.a.i(requireActivity(), "awCategoryWf");
    }

    @Override // com.mobvoi.companion.aw.watchfacecenter.k
    public void w(WatchFaceBean watchFaceBean) {
        i.f(watchFaceBean, "watchFaceBean");
        WatchFaceViewModel watchFaceViewModel = this.f16424d;
        if (watchFaceViewModel != null) {
            watchFaceViewModel.B(watchFaceBean, a0());
            f0(watchFaceBean, "wfCatListClickBtn", this.f16425e);
            return;
        }
        i.u("viewModel");
        throw null;
    }
}
