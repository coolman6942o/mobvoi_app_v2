package com.mobvoi.companion.profile;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;
import androidx.fragment.app.b0;
import androidx.lifecycle.x;
import ce.e;
import com.mobvoi.android.common.utils.k;
import io.d;
import jd.h;
import jd.k;
import k7.b;
import kb.f;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.l;
import ta.a;
import xd.c;
/* compiled from: AWProfileFragment.kt */
/* loaded from: classes2.dex */
public final class AWProfileFragment extends f {

    /* renamed from: f  reason: collision with root package name */
    private h f17305f;

    /* renamed from: g  reason: collision with root package name */
    private final d f17306g = b0.a(this, l.b(h.class), new AWProfileFragment$special$$inlined$viewModels$default$2(new AWProfileFragment$special$$inlined$viewModels$default$1(this)), null);

    private final int B0() {
        int o10 = a.o();
        if (o10 == -1) {
            return 0;
        }
        if (o10 != 1) {
            return o10 != 2 ? 0 : 2;
        }
        return 1;
    }

    private final h C0() {
        return (h) this.f17306g.getValue();
    }

    private final String D0() {
        String z10 = c.x().z(getContext());
        String string = requireContext().getString(ce.h.J);
        i.e(string, "requireContext().getString(R.string.label_unit_metric)");
        if (!i.b("imperial", z10)) {
            return string;
        }
        String string2 = requireContext().getString(ce.h.I);
        i.e(string2, "requireContext().getString(R.string.label_unit_imperial)");
        return string2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E0(AWProfileFragment this$0, int i10, Object obj) {
        i.f(this$0, "this$0");
        if (8 == i10) {
            this$0.L0();
            this$0.h0().f36193k.setText(this$0.D0());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F0(final AWProfileFragment this$0, Boolean bool) {
        i.f(this$0, "this$0");
        com.mobvoi.android.common.utils.l.a().postDelayed(new Runnable() { // from class: com.mobvoi.companion.profile.f
            @Override // java.lang.Runnable
            public final void run() {
                AWProfileFragment.G0(AWProfileFragment.this);
            }
        }, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G0(AWProfileFragment this$0) {
        i.f(this$0, "this$0");
        this$0.Y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H0(AWProfileFragment this$0, View view) {
        i.f(this$0, "this$0");
        h hVar = this$0.f17305f;
        if (hVar != null) {
            hVar.e();
        } else {
            i.u("mChangePresenter");
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I0(AWProfileFragment this$0, CompoundButton compoundButton, boolean z10) {
        i.f(this$0, "this$0");
        String string = this$0.getResources().getString(ce.h.f5856l);
        i.e(string, "resources.getString(R.string.common_loading)");
        this$0.Z(string);
        h hVar = this$0.f17305f;
        if (hVar != null) {
            hVar.g(z10);
        } else {
            i.u("mChangePresenter");
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J0(final AWProfileFragment this$0, View view) {
        i.f(this$0, "this$0");
        new b(this$0.requireActivity(), ce.i.f5881a).q(ce.h.f5839c0).J(ce.a.f5743b, this$0.B0(), new DialogInterface.OnClickListener() { // from class: com.mobvoi.companion.profile.a
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                AWProfileFragment.K0(AWProfileFragment.this, dialogInterface, i10);
            }
        }).d(true).t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K0(AWProfileFragment this$0, DialogInterface dialogInterface, int i10) {
        i.f(this$0, "this$0");
        dialogInterface.dismiss();
        this$0.M0(i10);
        this$0.O0();
    }

    private final void L0() {
        k.a("TAG", "MainHealthActivity发送广播 sendUpdateUnitMessage");
        Intent intent = new Intent("com.mobvoi.ticpod.service.ACTION_UPDATE_USER_SETTING_UNIT");
        intent.putExtra("distance_unit", !com.mobvoi.companion.base.settings.a.isUnitMetric(com.mobvoi.android.common.utils.b.e()) ? 2 : 1);
        Context context = getContext();
        if (context != null) {
            context.sendBroadcast(intent);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0007, code lost:
        if (r4 != 2) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void M0(int i10) {
        int i11 = 2;
        i11 = -1;
        if (i10 != 0) {
            if (i10 == 1) {
                i11 = 1;
            }
            a.U(i11);
            androidx.appcompat.app.f.G(i11);
        }
        a.U(i11);
        androidx.appcompat.app.f.G(i11);
    }

    private final void N0(String str) {
        androidx.appcompat.app.a supportActionBar = ((androidx.appcompat.app.d) requireActivity()).getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.z(str);
        }
    }

    private final void O0() {
        int i10 = ce.h.f5841d0;
        int o10 = a.o();
        if (o10 != -1) {
            if (o10 == 1) {
                i10 = ce.h.f5843e0;
            } else if (o10 == 2) {
                i10 = ce.h.f5837b0;
            }
        }
        h0().f36190h.setText(i10);
    }

    @Override // kb.f, kb.h
    public void i(String msg) {
        i.f(msg, "msg");
        Toast.makeText(getActivity(), msg, 0).show();
        Y();
        Intent intent = new Intent("mobvoi.main");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setFlags(268468224);
        startActivity(intent);
        androidx.fragment.app.f activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kb.f
    public void i0(View view) {
        i.f(view, "view");
        super.i0(view);
        String string = getResources().getString(ce.h.f5858m);
        i.e(string, "resources.getString(R.string.common_setting)");
        N0(string);
        this.f17305f = new jd.d(requireContext(), C0(), new k.a() { // from class: com.mobvoi.companion.profile.g
            @Override // jd.k.a
            public final void k(int i10, Object obj) {
                AWProfileFragment.E0(AWProfileFragment.this, i10, obj);
            }
        });
        C0().e().i(this, new x() { // from class: com.mobvoi.companion.profile.e
            @Override // androidx.lifecycle.x
            public final void a(Object obj) {
                AWProfileFragment.F0(AWProfileFragment.this, (Boolean) obj);
            }
        });
        h0().f36186d.setVisibility(0);
        h0().f36193k.setText(D0());
        h0().f36187e.setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.companion.profile.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AWProfileFragment.H0(AWProfileFragment.this, view2);
            }
        });
        h0().f36192j.setOnClickListener(this);
        h0().f36191i.setChecked(a.b());
        h0().f36191i.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.mobvoi.companion.profile.d
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                AWProfileFragment.I0(AWProfileFragment.this, compoundButton, z10);
            }
        });
        O0();
        h0().f36185c.setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.companion.profile.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AWProfileFragment.J0(AWProfileFragment.this, view2);
            }
        });
    }

    @Override // kb.f, android.view.View.OnClickListener
    public void onClick(View v10) {
        i.f(v10, "v");
        super.onClick(v10);
        if (v10.getId() == e.U) {
            h hVar = this.f17305f;
            if (hVar != null) {
                hVar.j();
            } else {
                i.u("mChangePresenter");
                throw null;
            }
        }
    }
}
