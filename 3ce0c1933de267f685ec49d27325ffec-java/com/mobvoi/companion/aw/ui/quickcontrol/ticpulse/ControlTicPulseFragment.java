package com.mobvoi.companion.aw.ui.quickcontrol.ticpulse;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.android.common.utils.m;
import com.mobvoi.companion.aw.ui.quickcontrol.ticpulse.c;
import io.d;
import io.f;
import k7.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.i;
import nf.h;
import wf.q;
/* compiled from: ControlTicPulseFragment.kt */
/* loaded from: classes2.dex */
public final class ControlTicPulseFragment extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    private pd.a f16337a;

    /* renamed from: b  reason: collision with root package name */
    private h<q> f16338b;

    /* renamed from: c  reason: collision with root package name */
    private final d f16339c;

    /* compiled from: ControlTicPulseFragment.kt */
    /* loaded from: classes2.dex */
    static final class a extends Lambda implements qo.a<String> {
        a() {
            super(0);
        }

        @Override // qo.a
        public final String invoke() {
            c.a aVar = c.f16342b;
            Bundle requireArguments = ControlTicPulseFragment.this.requireArguments();
            i.e(requireArguments, "requireArguments()");
            return aVar.a(requireArguments).a();
        }
    }

    public ControlTicPulseFragment() {
        d a10;
        a10 = f.a(new a());
        this.f16339c = a10;
    }

    private final String a0() {
        return (String) this.f16339c.getValue();
    }

    private final void b0() {
        pd.a aVar = this.f16337a;
        if (aVar != null) {
            aVar.f32757b.setChecked(of.h.b().i(requireContext()));
            pd.a aVar2 = this.f16337a;
            if (aVar2 != null) {
                aVar2.f32757b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.mobvoi.companion.aw.ui.quickcontrol.ticpulse.a
                    @Override // android.widget.CompoundButton.OnCheckedChangeListener
                    public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                        ControlTicPulseFragment.c0(ControlTicPulseFragment.this, compoundButton, z10);
                    }
                });
            } else {
                i.u("binding");
                throw null;
            }
        } else {
            i.u("binding");
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c0(ControlTicPulseFragment this$0, CompoundButton compoundButton, boolean z10) {
        i.f(this$0, "this$0");
        if (!m.b(this$0.requireActivity())) {
            Toast.makeText(this$0.requireActivity(), od.d.f31591i, 0).show();
            pd.a aVar = this$0.f16337a;
            if (aVar != null) {
                aVar.f32757b.setChecked(!z10);
            } else {
                i.u("binding");
                throw null;
            }
        } else if (TextUtils.isEmpty(this$0.a0())) {
            pd.a aVar2 = this$0.f16337a;
            if (aVar2 != null) {
                aVar2.f32757b.setChecked(!z10);
                k.a("sssss", "mNodeId 为空");
                return;
            }
            i.u("binding");
            throw null;
        } else if (!z10 || of.h.b().c(this$0.requireContext())) {
            of.h.b().m(this$0.requireContext(), "rri", z10 ? "1" : "0", ta.a.s());
        } else {
            pd.a aVar3 = this$0.f16337a;
            if (aVar3 != null) {
                aVar3.f32757b.setChecked(!z10);
                k.a("sssss", "不支持rri");
                this$0.e0();
                return;
            }
            i.u("binding");
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d0(ControlTicPulseFragment this$0, h hVar, q data) {
        i.f(this$0, "this$0");
        i.f(data, "data");
        if (data.type == "rri") {
            of.h.b().l(this$0.requireContext(), data.value);
            pd.a aVar = this$0.f16337a;
            if (aVar != null) {
                aVar.f32757b.setChecked(i.b("1", data.value));
                fd.a.e(this$0.a0());
                return;
            }
            i.u("binding");
            throw null;
        }
    }

    private final void e0() {
        new b(requireContext()).D(getString(od.d.u_res_0x7f140fcc)).d(false).m(od.d.f31587a, null).a().show();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        i.f(inflater, "inflater");
        pd.a d10 = pd.a.d(inflater, viewGroup, false);
        i.e(d10, "inflate(inflater, container, false)");
        this.f16337a = d10;
        h<q> h10 = of.h.b().h();
        if (h10 == null) {
            h10 = null;
        } else {
            h10.a(new nf.k() { // from class: com.mobvoi.companion.aw.ui.quickcontrol.ticpulse.b
                @Override // nf.k
                public final void i(h hVar, Object obj) {
                    ControlTicPulseFragment.d0(ControlTicPulseFragment.this, hVar, (q) obj);
                }
            });
            io.m mVar = io.m.f28349a;
        }
        this.f16338b = h10;
        pd.a aVar = this.f16337a;
        if (aVar != null) {
            return aVar.a();
        }
        i.u("binding");
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        h<q> hVar = this.f16338b;
        if (hVar != null) {
            i.d(hVar);
            hVar.d();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        i.f(view, "view");
        super.onViewCreated(view, bundle);
        requireActivity().setTitle(getString(od.d.t_res_0x7f140d64));
        b0();
    }
}
