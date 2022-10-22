package com.mobvoi.companion.health;

import android.os.Bundle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import androidx.lifecycle.g0;
import androidx.lifecycle.x;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mobvoi.companion.health.entity.a;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.l;
import tc.d;
import tc.e;
import tc.f;
/* compiled from: MedalCenterActivity.kt */
/* loaded from: classes2.dex */
public final class MedalCenterActivity extends q1 {

    /* renamed from: d  reason: collision with root package name */
    public MonthMedalAdapter f16777d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayoutManager f16778e;

    /* renamed from: f  reason: collision with root package name */
    public Runnable f16779f;

    /* renamed from: g  reason: collision with root package name */
    public List<d> f16780g;

    /* renamed from: h  reason: collision with root package name */
    private final io.d f16781h = new g0(l.b(SportMedalViewModel.class), new MedalCenterActivity$special$$inlined$viewModels$default$2(this), new MedalCenterActivity$special$$inlined$viewModels$default$1(this));

    /* renamed from: i  reason: collision with root package name */
    private final io.d f16782i = com.mobvoi.android.common.ui.viewbinding.a.a(this, c.INSTANCE);

    /* renamed from: j  reason: collision with root package name */
    private int f16783j;

    /* compiled from: MedalCenterActivity.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* compiled from: MedalCenterActivity.kt */
    /* loaded from: classes2.dex */
    public static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final MedalCenterActivity f16784a;

        public b(MedalCenterActivity activity) {
            i.f(activity, "activity");
            this.f16784a = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f16784a.S().setEnableLoadMore(true);
            this.f16784a.U().h();
        }
    }

    /* compiled from: MedalCenterActivity.kt */
    /* loaded from: classes2.dex */
    /* synthetic */ class c extends FunctionReferenceImpl implements qo.l<LayoutInflater, oc.c> {
        public static final c INSTANCE = new c();

        c() {
            super(1, oc.c.class, "inflate", "inflate(Landroid/view/LayoutInflater;)Lcom/mobvoi/companion/databinding/ActivityMedalCenterBinding;", 0);
        }

        /* renamed from: g */
        public final oc.c invoke(LayoutInflater p02) {
            i.f(p02, "p0");
            return oc.c.d(p02);
        }
    }

    static {
        new a(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SportMedalViewModel U() {
        return (SportMedalViewModel) this.f16781h.getValue();
    }

    private final oc.c V() {
        return (oc.c) this.f16782i.getValue();
    }

    private final void W() {
        U().j().i(this, new x() { // from class: com.mobvoi.companion.health.z2
            @Override // androidx.lifecycle.x
            public final void a(Object obj) {
                MedalCenterActivity.X(MedalCenterActivity.this, (Pair) obj);
            }
        });
        U().i().i(this, new x() { // from class: com.mobvoi.companion.health.y2
            @Override // androidx.lifecycle.x
            public final void a(Object obj) {
                MedalCenterActivity.Y(MedalCenterActivity.this, (Pair) obj);
            }
        });
        U().h();
        S().bindToRecyclerView(V().f31505c);
        V().f31505c.setLayoutManager(Q());
        S().setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() { // from class: com.mobvoi.companion.health.a3
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.RequestLoadMoreListener
            public final void onLoadMoreRequested() {
                MedalCenterActivity.Z(MedalCenterActivity.this);
            }
        }, V().f31505c);
        S().enableLoadMoreEndClick(true);
        S().disableLoadMoreIfNotFullPage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(MedalCenterActivity this$0, Pair weekMedalResponsePair) {
        i.f(this$0, "this$0");
        i.f(weekMedalResponsePair, "weekMedalResponsePair");
        this$0.T().clear();
        Object obj = weekMedalResponsePair.first;
        i.e(obj, "weekMedalResponsePair.first");
        if (((Boolean) obj).booleanValue()) {
            a.C0205a aVar = com.mobvoi.companion.health.entity.a.f16843f;
            Object obj2 = weekMedalResponsePair.second;
            i.d(obj2);
            this$0.T().add(new d(0, aVar.b((f.a) obj2)));
            this$0.S().setNewData(this$0.T());
            return;
        }
        this$0.T().add(new d(0, new com.mobvoi.companion.health.entity.a()));
        this$0.T().add(new d(2));
        this$0.S().setNewData(this$0.T());
        this$0.S().setEnableLoadMore(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(MedalCenterActivity this$0, Pair monthMedalResponsePair) {
        i.f(this$0, "this$0");
        i.f(monthMedalResponsePair, "monthMedalResponsePair");
        Object obj = monthMedalResponsePair.first;
        i.e(obj, "monthMedalResponsePair.first");
        if (((Boolean) obj).booleanValue()) {
            int size = this$0.T().size();
            List<e.a> list = (List) monthMedalResponsePair.second;
            if (list != null) {
                Collections.reverse(list);
                for (e.a aVar : list) {
                    this$0.T().add(new d(1, com.mobvoi.companion.health.entity.a.f16843f.a(aVar)));
                }
                int size2 = this$0.T().size();
                if (size < size2) {
                    while (true) {
                        int i10 = size + 1;
                        this$0.S().setData(size, this$0.T().get(size));
                        if (i10 >= size2) {
                            break;
                        }
                        size = i10;
                    }
                }
            }
            this$0.S().loadMoreComplete();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(MedalCenterActivity this$0) {
        i.f(this$0, "this$0");
        this$0.b0();
        this$0.f16783j++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a0(MedalCenterActivity this$0, View view) {
        i.f(this$0, "this$0");
        this$0.finish();
    }

    private final void b0() {
        U().k(this.f16783j == 0);
    }

    private final void initView() {
        V().f31504b.setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.companion.health.x2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MedalCenterActivity.a0(MedalCenterActivity.this, view);
            }
        });
    }

    public final LinearLayoutManager Q() {
        LinearLayoutManager linearLayoutManager = this.f16778e;
        if (linearLayoutManager != null) {
            return linearLayoutManager;
        }
        i.u("linearLayoutManager");
        throw null;
    }

    public final MonthMedalAdapter S() {
        MonthMedalAdapter monthMedalAdapter = this.f16777d;
        if (monthMedalAdapter != null) {
            return monthMedalAdapter;
        }
        i.u("monthMedalAdapter");
        throw null;
    }

    public final List<d> T() {
        List<d> list = this.f16780g;
        if (list != null) {
            return list;
        }
        i.u("sportMedalMultiBeanList");
        throw null;
    }

    @Override // com.mobvoi.companion.base.m3.a
    public boolean needFitsSystemWindows() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.base.m3.a, androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(V().a());
        W();
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.f, android.app.Activity
    public void onPause() {
        super.onPause();
        sb.a.h(this, "medalCenter");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.f, android.app.Activity
    public void onResume() {
        super.onResume();
        sb.a.i(this, "medalCenter");
    }
}
