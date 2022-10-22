package com.mobvoi.companion.health;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import androidx.fragment.app.b0;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.x;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.mobvoi.android.common.ui.viewbinding.FragmentViewBindingDelegate;
import com.mobvoi.companion.R;
import com.mobvoi.companion.health.widget.HealthTitleContainer;
import com.mobvoi.companion.wear.WearNode;
import com.mobvoi.companion.wear.WearPairingPool;
import com.mobvoi.wear.common.base.WearPath;
import com.mobvoi.wear.msgproxy.MessageProxyClient;
import io.m;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.l;
import kotlin.reflect.KProperty;
import kotlin.text.t;
import oc.k;
import tc.g;
import tc.i;
import wo.j;
/* compiled from: HealthFragment.kt */
/* loaded from: classes2.dex */
public class HealthFragment extends p1 implements WearPairingPool.f {

    /* renamed from: s  reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f16707s;

    /* renamed from: f  reason: collision with root package name */
    public List<i> f16708f;

    /* renamed from: g  reason: collision with root package name */
    public List<i> f16709g;

    /* renamed from: h  reason: collision with root package name */
    public RecyclerView.n f16710h;

    /* renamed from: i  reason: collision with root package name */
    public t1 f16711i;

    /* renamed from: j  reason: collision with root package name */
    public n0 f16712j;

    /* renamed from: k  reason: collision with root package name */
    public GridLayoutManager f16713k;

    /* renamed from: m  reason: collision with root package name */
    private qo.a<m> f16715m;

    /* renamed from: n  reason: collision with root package name */
    private qo.a<m> f16716n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f16717o;

    /* renamed from: r  reason: collision with root package name */
    private boolean f16720r;

    /* renamed from: l  reason: collision with root package name */
    private final io.d f16714l = b0.a(this, l.b(MainViewModel.class), new HealthFragment$special$$inlined$activityViewModels$default$1(this), new HealthFragment$special$$inlined$activityViewModels$default$2(this));

    /* renamed from: p  reason: collision with root package name */
    private final FragmentViewBindingDelegate f16718p = com.mobvoi.android.common.ui.viewbinding.a.b(this, d.INSTANCE);

    /* renamed from: q  reason: collision with root package name */
    private final b f16719q = new b();

    /* compiled from: HealthFragment.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* compiled from: HealthFragment.kt */
    /* loaded from: classes2.dex */
    public static final class b extends BroadcastReceiver {
        b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            kotlin.jvm.internal.i.f(context, "context");
            kotlin.jvm.internal.i.f(intent, "intent");
            if (kotlin.jvm.internal.i.b("com.mobvoi.compainion.ACTION_UPDATE_CARD_FINISH", intent.getAction())) {
                HealthFragment.this.y0().f31540d.o1(0);
                HealthFragment.this.y0().f31541e.setRefreshing(true);
                HealthFragment.this.z0().w0(true);
            }
        }
    }

    /* compiled from: HealthFragment.kt */
    /* loaded from: classes2.dex */
    public static final class c implements l3 {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f16723b;

        c(Context context) {
            this.f16723b = context;
        }

        @Override // com.mobvoi.companion.health.l3
        public void a() {
            HealthFragment.this.O0();
        }

        @Override // com.mobvoi.companion.health.l3
        public void b() {
            this.f16723b.startActivity(new Intent(this.f16723b, MedalCenterActivity.class));
            qo.a<m> u02 = HealthFragment.this.u0();
            if (u02 != null) {
                u02.invoke();
            }
        }
    }

    /* compiled from: HealthFragment.kt */
    /* loaded from: classes2.dex */
    /* synthetic */ class d extends FunctionReferenceImpl implements qo.l<View, k> {
        public static final d INSTANCE = new d();

        d() {
            super(1, k.class, "bind", "bind(Landroid/view/View;)Lcom/mobvoi/companion/databinding/FragmentHealthHomeTabBinding;", 0);
        }

        /* renamed from: g */
        public final k invoke(View p02) {
            kotlin.jvm.internal.i.f(p02, "p0");
            return k.b(p02);
        }
    }

    static {
        j[] jVarArr = new j[2];
        jVarArr[1] = l.h(new PropertyReference1Impl(l.b(HealthFragment.class), "viewBinding", "getViewBinding()Lcom/mobvoi/companion/databinding/FragmentHealthHomeTabBinding;"));
        f16707s = jVarArr;
        new a(null);
    }

    public HealthFragment() {
        super(R.layout.fragment_health_home_tab);
    }

    private final void A0(Context context) {
        y0().f31541e.setOnRefreshListener(new SwipeRefreshLayout.j() { // from class: com.mobvoi.companion.health.a1
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.j
            public final void y() {
                HealthFragment.B0(HealthFragment.this);
            }
        });
        y0().f31539c.setOnClickListener(new c(context));
        RecyclerView recyclerView = y0().f31540d;
        recyclerView.setLayoutManager(q0());
        recyclerView.setItemAnimator(null);
        recyclerView.h(t0());
        n0 p02 = p0();
        p02.d(y0().f31539c);
        p02.e(y0().f31538b);
        m mVar = m.f28349a;
        recyclerView.l(p02);
        t1 s02 = s0();
        s02.g(y0().f31539c);
        recyclerView.setAdapter(s02);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B0(HealthFragment this$0) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        qo.a<m> w02 = this$0.w0();
        if (w02 != null) {
            w02.invoke();
        }
        this$0.z0().w0(true);
    }

    private final void C0() {
        MessageProxyClient messageProxyClient = MessageProxyClient.getInstance();
        byte[] bytes = "{\"intent\":\"intent:#Intent;action=com.mobvoi.health.action.DATA_SYNC;S.path=sync;end\",\"permission\":\"\",\"type\":2}".getBytes(kotlin.text.d.f30092a);
        kotlin.jvm.internal.i.e(bytes, "(this as java.lang.String).getBytes(charset)");
        messageProxyClient.sendMessage(WearPath.Companion.LAUNCH_INTENT, bytes);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D0(HealthFragment this$0, Boolean success) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        kotlin.jvm.internal.i.e(success, "success");
        if (success.booleanValue() && !this$0.x0()) {
            this$0.y0().f31541e.setRefreshing(true);
            qo.a<m> w02 = this$0.w0();
            if (w02 != null) {
                w02.invoke();
            }
            this$0.z0().w0(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E0(HealthFragment this$0, Boolean success) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        if (this$0.x0()) {
            this$0.N0(false);
            this$0.y0().f31541e.setRefreshing(false);
            kotlin.jvm.internal.i.e(success, "success");
            if (success.booleanValue()) {
                Toast.makeText(this$0.requireContext(), R.string.home_tab_refresh_success, 0).show();
            } else {
                Toast.makeText(this$0.requireContext(), R.string.home_tab_refresh_failed, 0).show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F0(HealthFragment this$0, Map map) {
        boolean q5;
        kotlin.jvm.internal.i.f(this$0, "this$0");
        this$0.v0().clear();
        this$0.v0().addAll(this$0.r0());
        this$0.r0().clear();
        this$0.r0().add(new i(2, "EMPTY_CARD_ONLY_CLIENT"));
        try {
            kotlin.jvm.internal.i.e(map, "map");
            for (Map.Entry entry : map.entrySet()) {
                xc.b<?> bVar = (xc.b) entry.getValue();
                List<i> r02 = this$0.r0();
                i iVar = new i();
                iVar.e((String) entry.getKey());
                iVar.d(Integer.valueOf(bVar.b()));
                iVar.f(bVar);
                m mVar = m.f28349a;
                r02.add(iVar);
            }
        } catch (ConcurrentModificationException e10) {
            com.mobvoi.android.common.utils.k.d("HealthFragment", kotlin.jvm.internal.i.n("Error happens when traversing LinkedHashMap: ", e10.getMessage()));
        }
        i iVar2 = new i(1, "CARD_MANAGE_ONLY_CLIENT");
        iVar2.f(new xc.c());
        this$0.r0().add(iVar2);
        if (this$0.v0().isEmpty() || this$0.v0().size() != this$0.r0().size()) {
            this$0.s0().notifyDataSetChanged();
        } else {
            int size = this$0.r0().size();
            if (size > 0) {
                int i10 = 0;
                while (true) {
                    int i11 = i10 + 1;
                    q5 = t.q(this$0.v0().get(i10).b(), this$0.r0().get(i10).b(), false, 2, null);
                    if (q5) {
                        this$0.s0().notifyItemChanged(i10, this$0.r0().get(i10).c());
                    } else {
                        this$0.s0().notifyItemRemoved(i10);
                        this$0.s0().notifyItemInserted(i10);
                    }
                    if (i11 >= size) {
                        break;
                    }
                    i10 = i11;
                }
            }
        }
        if (!this$0.x0()) {
            this$0.y0().f31541e.setRefreshing(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G0(HealthFragment this$0, i artyServerCardData) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        int i10 = 0;
        for (Object obj : this$0.r0()) {
            i10++;
            if (i10 < 0) {
                kotlin.collections.m.o();
            }
            if (kotlin.jvm.internal.i.b(((i) obj).b(), artyServerCardData.b())) {
                List<i> r02 = this$0.r0();
                kotlin.jvm.internal.i.e(artyServerCardData, "artyServerCardData");
                r02.set(i10, artyServerCardData);
                this$0.s0().notifyItemChanged(i10, artyServerCardData.c());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H0(HealthFragment this$0, g gVar) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        b4[] b10 = s1.b();
        Integer c10 = gVar.c();
        b4 b4Var = b10[(c10 == null ? 1 : c10.intValue()) - 1];
        HomeMedalView homeMedalView = this$0.y0().f31539c;
        Integer c11 = gVar.c();
        homeMedalView.b((c11 == null ? 1 : c11.intValue()) - 1);
        int a10 = gVar.a();
        int b11 = gVar.b();
        this$0.y0().f31539c.i(a10, b11);
        this$0.y0().f31541e.setColorSchemeResources(b4Var.d());
        this$0.y0().f31542f.setText(this$0.requireContext().getString(R.string.home_tab_title_summary, Integer.valueOf(a10), Integer.valueOf(b11)));
        HealthTitleContainer healthTitleContainer = this$0.y0().f31538b;
        Context requireContext = this$0.requireContext();
        kotlin.jvm.internal.i.e(requireContext, "requireContext()");
        healthTitleContainer.a(requireContext, b4Var.d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I0(HealthFragment this$0, Boolean isForeground) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        kotlin.jvm.internal.i.e(isForeground, "isForeground");
        if (isForeground.booleanValue() && this$0.getLifecycle().b().isAtLeast(Lifecycle.State.RESUMED) && !this$0.x0()) {
            com.mobvoi.android.common.utils.k.d("HealthFragment", kotlin.jvm.internal.i.n("isForeground change ", this$0.getLifecycle().b()));
            this$0.y0().f31541e.setRefreshing(true);
            qo.a<m> w02 = this$0.w0();
            if (w02 != null) {
                w02.invoke();
            }
            this$0.z0().w0(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J0(HealthFragment this$0, Boolean failed) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        kotlin.jvm.internal.i.e(failed, "failed");
        if (failed.booleanValue()) {
            this$0.y0().f31541e.setRefreshing(false);
            Toast.makeText(this$0.requireContext(), R.string.home_tab_refresh_failed, 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K0(HealthFragment this$0, Boolean success) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        kotlin.jvm.internal.i.e(success, "success");
        if (success.booleanValue() && !this$0.x0()) {
            Toast.makeText(this$0.requireContext(), R.string.home_tab_refresh_success, 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O0() {
        new k7.b(requireActivity()).q(R.string.high_intensity_exercise_title).D(getString(R.string.high_intensity_exercise_paragraph, getString(R.string.high_intensity_exercise_paragraph_one), getString(R.string.high_intensity_exercise_paragraph_two), getString(R.string.high_intensity_exercise_paragraph_three))).d(false).m(R.string.common_gotIt, r0.f16942a).t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P0(DialogInterface dialogInterface, int i10) {
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final k y0() {
        return (k) this.f16718p.b(this, f16707s[1]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MainViewModel z0() {
        return (MainViewModel) this.f16714l.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void L0(qo.a<m> aVar) {
        this.f16715m = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void M0(qo.a<m> aVar) {
        this.f16716n = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void N0(boolean z10) {
        this.f16717o = z10;
    }

    @Override // com.mobvoi.companion.wear.WearPairingPool.f
    public void l(List<WearNode> wearNodes, String currentNodeId) {
        kotlin.jvm.internal.i.f(wearNodes, "wearNodes");
        kotlin.jvm.internal.i.f(currentNodeId, "currentNodeId");
        for (WearNode wearNode : wearNodes) {
            if (kotlin.jvm.internal.i.b(wearNode.nodeId, currentNodeId)) {
                if (!(TextUtils.isEmpty(wearNode.nodeName) || wearNode.connectionState == WearPairingPool.ConnectionState.Disconnected)) {
                    C0();
                    return;
                }
                return;
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        b1.a.b(requireContext()).e(this.f16719q);
        WearPairingPool.i().q(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.f16720r = true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        int i10 = 0;
        for (Object obj : r0()) {
            i10++;
            if (i10 < 0) {
                kotlin.collections.m.o();
            }
            i iVar = (i) obj;
            if (kotlin.jvm.internal.i.b(iVar.b(), "CARD_MCU_ACTIVITY") || kotlin.jvm.internal.i.b(iVar.b(), "CARD_TEMPERATION")) {
                com.mobvoi.android.common.utils.k.a("HealthFragment", kotlin.jvm.internal.i.n("App Unit needs change: index is ", Integer.valueOf(i10)));
                s0().notifyItemChanged(i10);
            }
        }
        C0();
        com.mobvoi.android.common.utils.k.c("HealthFragment", "Should do refresh when resume? %b", Boolean.valueOf(this.f16720r));
        if (this.f16720r) {
            y0().f31540d.o1(0);
            y0().f31541e.setRefreshing(true);
            z0().w0(true);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.f16720r = false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.i.f(view, "view");
        super.onViewCreated(view, bundle);
        androidx.fragment.app.f requireActivity = requireActivity();
        kotlin.jvm.internal.i.e(requireActivity, "requireActivity()");
        A0(requireActivity);
        z0().e0().i(getViewLifecycleOwner(), new x() { // from class: com.mobvoi.companion.health.z0
            @Override // androidx.lifecycle.x
            public final void a(Object obj) {
                HealthFragment.F0(HealthFragment.this, (Map) obj);
            }
        });
        z0().T().i(getViewLifecycleOwner(), new x() { // from class: com.mobvoi.companion.health.t0
            @Override // androidx.lifecycle.x
            public final void a(Object obj) {
                HealthFragment.G0(HealthFragment.this, (i) obj);
            }
        });
        z0().q0().i(getViewLifecycleOwner(), new x() { // from class: com.mobvoi.companion.health.s0
            @Override // androidx.lifecycle.x
            public final void a(Object obj) {
                HealthFragment.H0(HealthFragment.this, (g) obj);
            }
        });
        z0().O().i(getViewLifecycleOwner(), new x() { // from class: com.mobvoi.companion.health.w0
            @Override // androidx.lifecycle.x
            public final void a(Object obj) {
                HealthFragment.I0(HealthFragment.this, (Boolean) obj);
            }
        });
        z0().X().i(getViewLifecycleOwner(), new x() { // from class: com.mobvoi.companion.health.v0
            @Override // androidx.lifecycle.x
            public final void a(Object obj) {
                HealthFragment.J0(HealthFragment.this, (Boolean) obj);
            }
        });
        z0().Y().i(getViewLifecycleOwner(), new x() { // from class: com.mobvoi.companion.health.x0
            @Override // androidx.lifecycle.x
            public final void a(Object obj) {
                HealthFragment.K0(HealthFragment.this, (Boolean) obj);
            }
        });
        z0().U().i(getViewLifecycleOwner(), new x() { // from class: com.mobvoi.companion.health.y0
            @Override // androidx.lifecycle.x
            public final void a(Object obj) {
                HealthFragment.D0(HealthFragment.this, (Boolean) obj);
            }
        });
        z0().u0().i(getViewLifecycleOwner(), new x() { // from class: com.mobvoi.companion.health.u0
            @Override // androidx.lifecycle.x
            public final void a(Object obj) {
                HealthFragment.E0(HealthFragment.this, (Boolean) obj);
            }
        });
        WearPairingPool.i().c(this);
        b1.a.b(requireContext()).c(this.f16719q, new IntentFilter("com.mobvoi.compainion.ACTION_UPDATE_CARD_FINISH"));
    }

    public final n0 p0() {
        n0 n0Var = this.f16712j;
        if (n0Var != null) {
            return n0Var;
        }
        kotlin.jvm.internal.i.u("customScrollListener");
        throw null;
    }

    public final GridLayoutManager q0() {
        GridLayoutManager gridLayoutManager = this.f16713k;
        if (gridLayoutManager != null) {
            return gridLayoutManager;
        }
        kotlin.jvm.internal.i.u("gridLayoutManager");
        throw null;
    }

    public final List<i> r0() {
        List<i> list = this.f16709g;
        if (list != null) {
            return list;
        }
        kotlin.jvm.internal.i.u("healthCardList");
        throw null;
    }

    public final t1 s0() {
        t1 t1Var = this.f16711i;
        if (t1Var != null) {
            return t1Var;
        }
        kotlin.jvm.internal.i.u("homeTabAdapter");
        throw null;
    }

    public final RecyclerView.n t0() {
        RecyclerView.n nVar = this.f16710h;
        if (nVar != null) {
            return nVar;
        }
        kotlin.jvm.internal.i.u("itemDecoration");
        throw null;
    }

    protected final qo.a<m> u0() {
        return this.f16715m;
    }

    public final List<i> v0() {
        List<i> list = this.f16708f;
        if (list != null) {
            return list;
        }
        kotlin.jvm.internal.i.u("oldHealthCardList");
        throw null;
    }

    protected final qo.a<m> w0() {
        return this.f16716n;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean x0() {
        return this.f16717o;
    }
}
