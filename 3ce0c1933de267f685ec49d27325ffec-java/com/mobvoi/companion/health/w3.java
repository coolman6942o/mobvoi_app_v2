package com.mobvoi.companion.health;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.h0;
import androidx.lifecycle.x;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.mobvoi.companion.R;
import com.mobvoi.companion.TicAppConstants;
import io.m;
import java.util.ArrayList;
import java.util.Map;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f;
import tc.i;
/* compiled from: TicCareHealthFragment.kt */
/* loaded from: classes2.dex */
public final class w3 extends r1 {

    /* renamed from: g  reason: collision with root package name */
    private y3 f17118g;

    /* renamed from: h  reason: collision with root package name */
    private SwipeRefreshLayout f17119h;

    /* renamed from: i  reason: collision with root package name */
    private CareHealthViewModel f17120i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f17121j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f17122k;

    /* renamed from: f  reason: collision with root package name */
    private final ArrayList<i> f17117f = new ArrayList<>();

    /* renamed from: l  reason: collision with root package name */
    private final HomeTabLifeCycleChecker f17123l = new HomeTabLifeCycleChecker(new b());

    /* compiled from: TicCareHealthFragment.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* compiled from: TicCareHealthFragment.kt */
    /* loaded from: classes2.dex */
    static final class b extends Lambda implements qo.a<m> {
        b() {
            super(0);
        }

        @Override // qo.a
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            SwipeRefreshLayout swipeRefreshLayout = w3.this.f17119h;
            if (swipeRefreshLayout != null) {
                swipeRefreshLayout.setRefreshing(true);
            }
            CareHealthViewModel careHealthViewModel = w3.this.f17120i;
            if (careHealthViewModel != null) {
                careHealthViewModel.J();
            }
        }
    }

    /* compiled from: TicCareHealthFragment.kt */
    /* loaded from: classes2.dex */
    public static final class c extends RecyclerView.n {

        /* renamed from: a  reason: collision with root package name */
        private final int f17124a;

        c() {
            this.f17124a = w3.this.getResources().getDisplayMetrics().widthPixels;
        }

        private final int i(int i10) {
            Integer a10;
            Integer a11;
            if (i10 <= 0) {
                return 0;
            }
            int i11 = 0;
            int i12 = 0;
            while (true) {
                int i13 = i11 + 1;
                Object obj = w3.this.f17117f.get(i11);
                kotlin.jvm.internal.i.e(obj, "healthCardList[index]");
                i iVar = (i) obj;
                Integer a12 = iVar.a();
                int i14 = 2;
                if (a12 != null && a12.intValue() == 2) {
                    Integer a13 = iVar.a();
                    i14 = a13 == null ? 0 : a13.intValue();
                } else {
                    int i15 = i11 - 1;
                    boolean z10 = i15 < 0 || ((a11 = ((i) w3.this.f17117f.get(i15)).a()) != null && a11.intValue() == 2);
                    boolean z11 = i13 >= w3.this.f17117f.size() || ((a10 = ((i) w3.this.f17117f.get(i13)).a()) != null && a10.intValue() == 2);
                    if (!z10 || !z11) {
                        i14 = 1;
                    }
                }
                i12 += i14;
                if (i13 >= i10) {
                    return i12;
                }
                i11 = i13;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.n
        public void d(Rect outRect, View view, RecyclerView parent, RecyclerView.y state) {
            int i10;
            Integer a10;
            kotlin.jvm.internal.i.f(outRect, "outRect");
            kotlin.jvm.internal.i.f(view, "view");
            kotlin.jvm.internal.i.f(parent, "parent");
            kotlin.jvm.internal.i.f(state, "state");
            int g02 = parent.g0(view);
            outRect.top = (int) ((this.f17124a / 375.0f) * 8);
            Object obj = w3.this.f17117f.get(g02);
            kotlin.jvm.internal.i.e(obj, "healthCardList[childAdapterPosition]");
            i iVar = (i) obj;
            Integer a11 = iVar.a();
            if (a11 != null && a11.intValue() == 2) {
                int i11 = this.f17124a;
                float f10 = 16;
                outRect.left = (int) ((i11 / 375.0f) * f10);
                outRect.right = (int) ((i11 / 375.0f) * f10);
                i10 = 0;
            } else {
                i10 = i(g02);
                if ((i10 + 1) % 2 == 0) {
                    int i12 = this.f17124a;
                    outRect.left = (int) (((i12 / 375.0f) * 7) / 2);
                    outRect.right = (int) ((i12 / 375.0f) * 16);
                } else {
                    int i13 = this.f17124a;
                    outRect.left = (int) ((i13 / 375.0f) * 16);
                    outRect.right = (int) (((i13 / 375.0f) * 7) / 2);
                }
            }
            if (g02 == w3.this.f17117f.size() - 1) {
                outRect.bottom = (int) ((this.f17124a / 375.0f) * 20);
            } else if (g02 == w3.this.f17117f.size() - 2) {
                Integer a12 = iVar.a();
                if ((a12 != null && a12.intValue() == 2) || (((a10 = ((i) w3.this.f17117f.get(g02 + 1)).a()) != null && a10.intValue() == 2) || i10 % 2 != 0)) {
                    outRect.bottom = 0;
                } else {
                    outRect.bottom = (int) ((this.f17124a / 375.0f) * 20);
                }
            } else {
                outRect.bottom = 0;
            }
        }
    }

    /* compiled from: TicCareHealthFragment.kt */
    /* loaded from: classes2.dex */
    public static final class d extends GridLayoutManager.c {
        d() {
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.c
        public int getSpanSize(int i10) {
            Integer a10 = ((i) w3.this.f17117f.get(i10)).a();
            if (a10 == null) {
                return 0;
            }
            return a10.intValue();
        }
    }

    static {
        new a(null);
    }

    private final int h0() {
        return R.layout.fragment_care_health_home_tab;
    }

    private final void i0(Context context, View view) {
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh_layout);
        this.f17119h = swipeRefreshLayout;
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.j() { // from class: com.mobvoi.companion.health.v3
                @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.j
                public final void y() {
                    w3.j0(w3.this);
                }
            });
        }
        View findViewById = view.findViewById(R.id.rv);
        kotlin.jvm.internal.i.e(findViewById, "inflateView.findViewById(R.id.rv)");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 2);
        gridLayoutManager.e3(new d());
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setItemAnimator(null);
        recyclerView.h(new c());
        y3 y3Var = new y3(this.f17117f);
        this.f17118g = y3Var;
        recyclerView.setAdapter(y3Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j0(w3 this$0) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        CareHealthViewModel careHealthViewModel = this$0.f17120i;
        if (careHealthViewModel != null) {
            careHealthViewModel.p(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(w3 this$0, Map map) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        this$0.f17117f.clear();
        kotlin.jvm.internal.i.e(map, "map");
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            xc.b<?> bVar = (xc.b) entry.getValue();
            if (!kotlin.jvm.internal.i.b(str, "CARD_SPORT") || this$0.f17122k) {
                ArrayList<i> arrayList = this$0.f17117f;
                i iVar = new i();
                iVar.e(str);
                iVar.d(Integer.valueOf(bVar.b()));
                iVar.f(bVar);
                m mVar = m.f28349a;
                arrayList.add(iVar);
            }
        }
        y3 y3Var = this$0.f17118g;
        if (y3Var != null) {
            y3Var.notifyDataSetChanged();
        }
        SwipeRefreshLayout swipeRefreshLayout = this$0.f17119h;
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setRefreshing(false);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        androidx.fragment.app.f requireActivity = requireActivity();
        kotlin.jvm.internal.i.e(requireActivity, "requireActivity()");
        this.f17120i = (CareHealthViewModel) new h0(requireActivity).a(CareHealthViewModel.class);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.i.f(inflater, "inflater");
        return inflater.inflate(h0(), viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        z.h().getLifecycle().c(this.f17123l);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.f17121j) {
            CareHealthViewModel careHealthViewModel = this.f17120i;
            if (careHealthViewModel != null) {
                careHealthViewModel.p(false);
                return;
            }
            return;
        }
        this.f17121j = true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.i.f(view, "view");
        super.onViewCreated(view, bundle);
        androidx.fragment.app.f requireActivity = requireActivity();
        kotlin.jvm.internal.i.e(requireActivity, "requireActivity()");
        i0(requireActivity, view);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f17122k = arguments.getBoolean(TicAppConstants.CARE_SHOW_SPORT_DATA);
        }
        CareHealthViewModel careHealthViewModel = this.f17120i;
        if (careHealthViewModel != null) {
            careHealthViewModel.A().i(getViewLifecycleOwner(), new x() { // from class: com.mobvoi.companion.health.u3
                @Override // androidx.lifecycle.x
                public final void a(Object obj) {
                    w3.k0(w3.this, (Map) obj);
                }
            });
        }
        z.h().getLifecycle().a(this.f17123l);
    }
}
