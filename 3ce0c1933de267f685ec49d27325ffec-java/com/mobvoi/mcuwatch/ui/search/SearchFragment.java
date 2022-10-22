package com.mobvoi.mcuwatch.ui.search;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.fragment.app.b0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.mcuwatch.ui.pair.PairActivity;
import io.d;
import java.util.ArrayList;
import java.util.HashSet;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.l;
import kotlin.text.t;
import kotlin.text.u;
import qi.w;
import sh.h;
import sh.i;
import sh.n;
/* compiled from: SearchFragment.kt */
/* loaded from: classes2.dex */
public final class SearchFragment extends hj.a implements View.OnClickListener, n.b {

    /* renamed from: c  reason: collision with root package name */
    private boolean f19982c;

    /* renamed from: d  reason: collision with root package name */
    private RecyclerView f19983d;

    /* renamed from: e  reason: collision with root package name */
    private Button f19984e;

    /* renamed from: f  reason: collision with root package name */
    private final d f19985f;

    /* renamed from: g  reason: collision with root package name */
    private final d f19986g;

    /* renamed from: h  reason: collision with root package name */
    private final d f19987h = b0.a(this, l.b(w.class), new SearchFragment$special$$inlined$activityViewModels$default$1(this), new SearchFragment$special$$inlined$activityViewModels$default$2(this));

    /* renamed from: i  reason: collision with root package name */
    private final int f19988i = i.f34742k0;

    /* compiled from: SearchFragment.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* compiled from: SearchFragment.kt */
    /* loaded from: classes2.dex */
    static final class b extends Lambda implements qo.a<com.mobvoi.mcuwatch.ui.search.a> {
        b() {
            super(0);
        }

        /* renamed from: a */
        public final com.mobvoi.mcuwatch.ui.search.a invoke() {
            Context requireContext = SearchFragment.this.requireContext();
            kotlin.jvm.internal.i.e(requireContext, "requireContext()");
            return new com.mobvoi.mcuwatch.ui.search.a(requireContext, new ArrayList());
        }
    }

    /* compiled from: SearchFragment.kt */
    /* loaded from: classes2.dex */
    static final class c extends Lambda implements qo.a<HashSet<pk.f>> {
        public static final c INSTANCE = new c();

        c() {
            super(0);
        }

        /* renamed from: a */
        public final HashSet<pk.f> invoke() {
            return new HashSet<>();
        }
    }

    static {
        new a(null);
    }

    public SearchFragment() {
        d a10;
        d a11;
        a10 = io.f.a(c.INSTANCE);
        this.f19985f = a10;
        a11 = io.f.a(new b());
        this.f19986g = a11;
    }

    private final boolean i0() {
        return l0().n();
    }

    private final com.mobvoi.mcuwatch.ui.search.a j0() {
        return (com.mobvoi.mcuwatch.ui.search.a) this.f19986g.getValue();
    }

    private final HashSet<pk.f> k0() {
        return (HashSet) this.f19985f.getValue();
    }

    private final w l0() {
        return (w) this.f19987h.getValue();
    }

    private final void m0() {
        l0().a(l0().l().H(xp.a.b()).Y(new yp.b() { // from class: com.mobvoi.mcuwatch.ui.search.c
            @Override // yp.b
            public final void call(Object obj) {
                SearchFragment.n0(SearchFragment.this, (pk.f) obj);
            }
        }, d.f19995a));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(SearchFragment this$0, pk.f bleDevice) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        kotlin.jvm.internal.i.f(bleDevice, "bleDevice");
        if (!this$0.f19982c) {
            this$0.p0(bleDevice);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o0(Throwable th2) {
        k.d("ScanFragment", th2.toString());
    }

    private final void p0(pk.f fVar) {
        Integer num;
        int i10;
        HashSet<pk.f> k02 = k0();
        HashSet<pk.f> hashSet = null;
        if (!k02.isEmpty()) {
            k02 = null;
        }
        if (k02 == null) {
            num = null;
        } else {
            RecyclerView recyclerView = this.f19983d;
            if (recyclerView != null) {
                recyclerView.setVisibility(0);
                num = 0;
            } else {
                kotlin.jvm.internal.i.u("recyclerView");
                throw null;
            }
        }
        if (num == null) {
            i10 = k0().size();
        } else {
            i10 = num.intValue();
        }
        HashSet<pk.f> k03 = k0();
        if (!k03.contains(fVar)) {
            hashSet = k03;
        }
        if (hashSet != null) {
            hashSet.add(fVar);
            j0().d(i10, fVar);
            if (c0()) {
                b0();
            }
        }
    }

    private final boolean q0() {
        return l0().o();
    }

    private final void r0() {
        if (a0().getMode() != 2) {
            l0().C(requireActivity());
            this.f19982c = true;
            new Handler().postDelayed(new Runnable() { // from class: com.mobvoi.mcuwatch.ui.search.b
                @Override // java.lang.Runnable
                public final void run() {
                    SearchFragment.s0(SearchFragment.this);
                }
            }, 10L);
        } else if (!i0() || !q0()) {
            Toast.makeText(requireContext(), sh.k.f34822j4, 0).show();
        } else {
            v0(0);
            l0().C(requireActivity());
            this.f19982c = true;
            l0().w(requireActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(SearchFragment this$0) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        this$0.requireActivity().finish();
    }

    private final void t0() {
        Context context = getContext();
        if (context != null) {
            Button button = this.f19984e;
            if (button != null) {
                button.setBackground(context.getDrawable(sh.f.f34532b));
                Button button2 = this.f19984e;
                if (button2 != null) {
                    button2.setTextColor(context.getResources().getColor(sh.d.f34448h));
                } else {
                    kotlin.jvm.internal.i.u("btnAction");
                    throw null;
                }
            } else {
                kotlin.jvm.internal.i.u("btnAction");
                throw null;
            }
        }
    }

    private final void u0() {
        View findViewById = Y().findViewById(h.D2);
        kotlin.jvm.internal.i.e(findViewById, "customView.findViewById(R.id.recycler_view)");
        this.f19983d = (RecyclerView) findViewById;
        View findViewById2 = Y().findViewById(h.U);
        kotlin.jvm.internal.i.e(findViewById2, "customView.findViewById(R.id.btn_action)");
        this.f19984e = (Button) findViewById2;
        RecyclerView recyclerView = this.f19983d;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
            recyclerView.setAdapter(j0());
            recyclerView.k(new n(recyclerView.getContext(), this));
            Button button = this.f19984e;
            if (button != null) {
                button.setOnClickListener(this);
            } else {
                kotlin.jvm.internal.i.u("btnAction");
                throw null;
            }
        } else {
            kotlin.jvm.internal.i.u("recyclerView");
            throw null;
        }
    }

    private final void v0(int i10) {
        a0().setMode(i10);
        if (i10 == 0) {
            Button button = this.f19984e;
            if (button != null) {
                button.setText(sh.k.f34848p0);
                t0();
                return;
            }
            kotlin.jvm.internal.i.u("btnAction");
            throw null;
        } else if (i10 == 2) {
            Button button2 = this.f19984e;
            if (button2 != null) {
                button2.setText(sh.k.B4);
                t0();
                return;
            }
            kotlin.jvm.internal.i.u("btnAction");
            throw null;
        }
    }

    @Override // hj.a
    public int Z() {
        return this.f19988i;
    }

    @Override // sh.n.b
    public void j(View view, int i10) {
        boolean I;
        String z10;
        k.c("ScanFragment", "onItemClick %d", Integer.valueOf(i10));
        if (!this.f19982c) {
            l0().C(requireActivity());
            this.f19982c = true;
        }
        pk.f fVar = j0().c().get(i10);
        String deviceName = fVar.b();
        if (!TextUtils.isEmpty(deviceName)) {
            kotlin.jvm.internal.i.e(deviceName, "deviceName");
            int i11 = sh.k.O2;
            String string = getString(i11);
            kotlin.jvm.internal.i.e(string, "getString(R.string.ticwatch_gth_plus)");
            I = u.I(deviceName, string, false, 2, null);
            if (I) {
                String string2 = getString(i11);
                kotlin.jvm.internal.i.e(string2, "getString(R.string.ticwatch_gth_plus)");
                String string3 = getString(sh.k.P2);
                kotlin.jvm.internal.i.e(string3, "getString(R.string.ticwatch_gth_pro)");
                z10 = t.z(deviceName, string2, string3, false, 4, null);
                fVar.d(z10);
            }
        }
        PairActivity.Z(requireContext(), fVar, "search_device");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Integer valueOf = view == null ? null : Integer.valueOf(view.getId());
        int i10 = h.U;
        if (valueOf != null && valueOf.intValue() == i10) {
            r0();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (!this.f19982c) {
            l0().C(requireActivity());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.i.f(view, "view");
        super.onViewCreated(view, bundle);
        u0();
        a0().setMode(0);
        m0();
        if (!i0() || !q0()) {
            Toast.makeText(requireContext(), sh.k.f34822j4, 0).show();
        } else {
            l0().A(requireActivity());
        }
    }
}
