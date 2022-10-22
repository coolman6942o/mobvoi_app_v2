package com.mobvoi.device;

import aa.d;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Build;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.tabs.TabLayout;
import com.mobvoi.companion.TicwearUiUtils;
import com.mobvoi.companion.setting.CompanionSetting;
import com.mobvoi.device.DeviceListFragment;
import com.mobvoi.device.DeviceProvider;
import com.mobvoi.ticcare.ui.ScanCareCodeActivity;
import ge.f;
import ge.m;
import hc.e;
import java.util.List;
/* loaded from: classes2.dex */
public class DeviceListFragment extends ge.a {

    /* renamed from: b  reason: collision with root package name */
    private je.b f17839b;

    /* renamed from: c  reason: collision with root package name */
    private List<DeviceProvider.DeviceData> f17840c;

    /* renamed from: d  reason: collision with root package name */
    private final SparseArray<View.OnClickListener> f17841d = new SparseArray<>();

    /* renamed from: e  reason: collision with root package name */
    private int f17842e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements TabLayout.d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ he.a f17843a;

        a(he.a aVar) {
            this.f17843a = aVar;
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void a(TabLayout.g gVar) {
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void b(TabLayout.g gVar) {
            this.f17843a.f(((DeviceProvider.DeviceData) DeviceListFragment.this.f17840c.get(gVar.g())).f17851e);
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void c(TabLayout.g gVar) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface b {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class c extends RecyclerView.n {

        /* renamed from: a  reason: collision with root package name */
        private final int f17845a;

        /* renamed from: b  reason: collision with root package name */
        private final int f17846b;

        public c(int i10, int i11) {
            this.f17845a = i10;
            this.f17846b = i11;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.n
        public void d(Rect rect, View view, RecyclerView recyclerView, RecyclerView.y yVar) {
            super.d(rect, view, recyclerView, yVar);
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            if (linearLayoutManager == null) {
                return;
            }
            if (linearLayoutManager.n2() == 1) {
                if (recyclerView.g0(view) == 0) {
                    rect.top = this.f17846b;
                }
                rect.bottom = this.f17846b / 2;
                return;
            }
            if (recyclerView.g0(view) == linearLayoutManager.Z() - 1) {
                rect.right = this.f17845a;
            }
            rect.left = this.f17845a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A0(DialogInterface dialogInterface, int i10) {
        E0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void B0(DialogInterface dialogInterface, int i10) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D0(DialogInterface dialogInterface, int i10) {
        F0();
    }

    private void E0() {
        Context requireContext = requireContext();
        if (com.mobvoi.companion.base.settings.a.isOversea()) {
            TicwearUiUtils.AndroidWear.openPlayStore(requireContext, "com.mobvoi.companion.ai");
        } else {
            TicwearUiUtils.AndroidWear.openUrl(requireContext, "http://mushroom.chumenwenwen.com/api/download?app=mecury_companion&channel=temp&version=latest");
        }
    }

    private void F0() {
        if (e.i(requireContext(), "android.permission.ACCESS_FINE_LOCATION")) {
            e.b(this, 101, "android.permission.ACCESS_BACKGROUND_LOCATION");
        } else {
            e.b(this, 100, "android.permission.ACCESS_FINE_LOCATION");
        }
    }

    private void G0() {
        new k7.b(requireActivity()).q(m.f27433k).h(com.mobvoi.companion.base.settings.a.isOversea() ? m.h_res_0x7f1403c7 : m.g_res_0x7f1403c6).m(m.f_res_0x7f1403c5, new DialogInterface.OnClickListener() { // from class: ge.d
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                DeviceListFragment.this.A0(dialogInterface, i10);
            }
        }).j(m.f27432i, f.f27404a).t();
    }

    private void H0(Context context) {
        new k7.b(context).q(m.f27435m).h(m.f27434l).d(false).j(m.f27431b, ge.e.f27403a).m(m.f27436n, new DialogInterface.OnClickListener() { // from class: ge.c
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                DeviceListFragment.this.D0(dialogInterface, i10);
            }
        }).t();
        CompanionSetting.setShowRequestBgLocDialog(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I0() {
        qk.b.g().f("ticlite_mcu").f(5);
    }

    private void J0(int i10) {
        this.f17842e = i10;
        if (Build.VERSION.SDK_INT < 29 || s0()) {
            qk.b.g().f("ticlite_mcu").f(this.f17842e);
        } else if (CompanionSetting.needShowRequestBgLocDialog()) {
            H0(requireContext());
        } else {
            F0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K0() {
        J0(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L0() {
        J0(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M0() {
        J0(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N0() {
        J0(6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O0() {
        J0(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P0() {
        vb.b.e(requireActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q0() {
        startActivity(new Intent("com.mobvoi.companion.action.SETUP"));
    }

    private boolean s0() {
        return e.i(requireContext(), "android.permission.ACCESS_BACKGROUND_LOCATION");
    }

    private void u0() {
        this.f17841d.put(29, v0(new b() { // from class: com.mobvoi.device.e
            @Override // com.mobvoi.device.DeviceListFragment.b
            public final void a() {
                DeviceListFragment.this.x0();
            }
        }));
        if (com.mobvoi.companion.base.settings.a.isW3Oversea(requireContext())) {
            this.f17841d.put(31, v0(new b() { // from class: com.mobvoi.device.f
                @Override // com.mobvoi.device.DeviceListFragment.b
                public final void a() {
                    DeviceListFragment.this.Q0();
                }
            }));
            return;
        }
        this.f17841d.put(15, v0(new b() { // from class: com.mobvoi.device.c
            @Override // com.mobvoi.device.DeviceListFragment.b
            public final void a() {
                DeviceListFragment.this.P0();
            }
        }));
        this.f17841d.put(31, v0(new b() { // from class: com.mobvoi.device.c
            @Override // com.mobvoi.device.DeviceListFragment.b
            public final void a() {
                DeviceListFragment.this.P0();
            }
        }));
        this.f17841d.put(16, v0(new b() { // from class: com.mobvoi.device.c
            @Override // com.mobvoi.device.DeviceListFragment.b
            public final void a() {
                DeviceListFragment.this.P0();
            }
        }));
        this.f17841d.put(19, v0(new b() { // from class: com.mobvoi.device.d
            @Override // com.mobvoi.device.DeviceListFragment.b
            public final void a() {
                DeviceListFragment.this.M0();
            }
        }));
        this.f17841d.put(38, v0(new b() { // from class: com.mobvoi.device.c
            @Override // com.mobvoi.device.DeviceListFragment.b
            public final void a() {
                DeviceListFragment.this.P0();
            }
        }));
        this.f17841d.put(12, v0(new b() { // from class: com.mobvoi.device.c
            @Override // com.mobvoi.device.DeviceListFragment.b
            public final void a() {
                DeviceListFragment.this.P0();
            }
        }));
        this.f17841d.put(32, v0(new b() { // from class: com.mobvoi.device.j
            @Override // com.mobvoi.device.DeviceListFragment.b
            public final void a() {
                DeviceListFragment.this.K0();
            }
        }));
        this.f17841d.put(34, v0(new b() { // from class: com.mobvoi.device.i
            @Override // com.mobvoi.device.DeviceListFragment.b
            public final void a() {
                DeviceListFragment.this.N0();
            }
        }));
        this.f17841d.put(33, v0(new b() { // from class: com.mobvoi.device.b
            @Override // com.mobvoi.device.DeviceListFragment.b
            public final void a() {
                DeviceListFragment.this.I0();
            }
        }));
        this.f17841d.put(10, v0(new b() { // from class: com.mobvoi.device.c
            @Override // com.mobvoi.device.DeviceListFragment.b
            public final void a() {
                DeviceListFragment.this.P0();
            }
        }));
        this.f17841d.put(11, v0(new b() { // from class: com.mobvoi.device.c
            @Override // com.mobvoi.device.DeviceListFragment.b
            public final void a() {
                DeviceListFragment.this.P0();
            }
        }));
        this.f17841d.put(13, v0(new b() { // from class: com.mobvoi.device.c
            @Override // com.mobvoi.device.DeviceListFragment.b
            public final void a() {
                DeviceListFragment.this.P0();
            }
        }));
        this.f17841d.put(14, v0(new b() { // from class: com.mobvoi.device.c
            @Override // com.mobvoi.device.DeviceListFragment.b
            public final void a() {
                DeviceListFragment.this.P0();
            }
        }));
        this.f17841d.put(17, v0(new b() { // from class: com.mobvoi.device.h
            @Override // com.mobvoi.device.DeviceListFragment.b
            public final void a() {
                DeviceListFragment.this.O0();
            }
        }));
        this.f17841d.put(18, v0(new b() { // from class: com.mobvoi.device.g
            @Override // com.mobvoi.device.DeviceListFragment.b
            public final void a() {
                DeviceListFragment.this.L0();
            }
        }));
        this.f17841d.put(20, new View.OnClickListener() { // from class: ge.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DeviceListFragment.this.y0(view);
            }
        });
    }

    private View.OnClickListener v0(final b bVar) {
        return new View.OnClickListener() { // from class: com.mobvoi.device.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DeviceListFragment.this.z0(bVar, view);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x0() {
        sb.a.d(requireActivity(), "clickAddTicCare");
        startActivity(new Intent(requireActivity(), ScanCareCodeActivity.class));
        requireActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y0(View view) {
        G0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z0(b bVar, View view) {
        if (a0()) {
            bVar.a();
        } else {
            b0();
        }
    }

    @Override // ge.a
    protected View Y(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        je.b d10 = je.b.d(layoutInflater);
        this.f17839b = d10;
        return d10.a();
    }

    @Override // ge.a
    protected void Z() {
        t0();
        w0();
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i10, strArr, iArr);
        if (i10 == 100) {
            if (iArr.length <= 0 || iArr[0] != 0) {
                qk.b.g().f("ticlite_mcu").f(this.f17842e);
            } else {
                e.b(this, 101, "android.permission.ACCESS_BACKGROUND_LOCATION");
            }
        } else if (i10 == 101) {
            qk.b.g().f("ticlite_mcu").f(this.f17842e);
        }
    }

    public void t0() {
        u0();
        this.f17840c = DeviceProvider.b(com.mobvoi.companion.base.settings.a.isOversea());
    }

    protected void w0() {
        he.a aVar = new he.a();
        this.f17839b.f29555c.d(new a(aVar));
        this.f17839b.f29554b.setLayoutManager(new LinearLayoutManager(requireActivity(), 1, false));
        aVar.f(this.f17840c.get(0).f17851e);
        aVar.e(this.f17841d);
        this.f17839b.f29554b.setAdapter(aVar);
        this.f17839b.f29554b.h(new c(0, d.a(16.0f)));
    }
}
