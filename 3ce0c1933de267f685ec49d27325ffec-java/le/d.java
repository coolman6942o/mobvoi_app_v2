package le;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.assistant.account.AccountHomeActivity;
import com.mobvoi.device.DevicePairActivity;
import com.mobvoi.vpa.vpacommonlib.FragmentData;
import com.mobvoi.vpa.vpacommonlib.b;
import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.c;
import ta.a;
/* compiled from: BaseTabFragment.java */
/* loaded from: classes2.dex */
public abstract class d extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    protected Activity f30456a;

    /* renamed from: b  reason: collision with root package name */
    protected RecyclerView f30457b;

    /* renamed from: c  reason: collision with root package name */
    protected CardView f30458c;

    /* renamed from: d  reason: collision with root package name */
    protected TextView f30459d;

    /* renamed from: e  reason: collision with root package name */
    protected View f30460e;

    /* renamed from: f  reason: collision with root package name */
    private b f30461f;

    /* renamed from: g  reason: collision with root package name */
    private List<FragmentData> f30462g;

    /* renamed from: h  reason: collision with root package name */
    private final dq.b f30463h = new dq.b();

    private boolean c0() {
        return !TextUtils.isEmpty(a.s());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d0(View view) {
        l0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e0(Long l10) {
        if (this.f30462g.size() == 0) {
            this.f30458c.setVisibility(0);
            this.f30457b.setVisibility(8);
            this.f30459d.setVisibility(8);
        }
    }

    private void i0() {
        k.h("BaseDeviceFragment", " onResume showContentView mFragmentDataList.size() = " + this.f30462g.size());
        if (this.f30462g.size() == 0) {
            this.f30463h.a(c.e0(2000L, TimeUnit.MILLISECONDS).H(xp.a.b()).Y(new yp.b() { // from class: le.b
                @Override // yp.b
                public final void call(Object obj) {
                    d.this.e0((Long) obj);
                }
            }, c.f30455a));
            return;
        }
        this.f30458c.setVisibility(8);
        this.f30457b.setVisibility(0);
        this.f30459d.setVisibility(8);
    }

    private void j0() {
        this.f30458c.setVisibility(8);
        this.f30457b.setVisibility(8);
        this.f30459d.setVisibility(0);
    }

    private void k0() {
        Intent intent = new Intent(this.f30456a, AccountHomeActivity.class);
        intent.putExtra("key_type", "key_login");
        startActivity(intent);
    }

    private void l0() {
        if (c0()) {
            this.f30456a.startActivity(new Intent(this.f30456a, DevicePairActivity.class));
            sb.a.d(requireContext(), "add_ticwatch");
            return;
        }
        k0();
    }

    protected abstract int b0();

    protected abstract List<FragmentData> g0();

    public void h0() {
        if (this.f30461f != null) {
            this.f30462g = g0();
            i0();
            this.f30461f.n(this.f30462g, true);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(b0(), viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f30463h.b();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f30456a = requireActivity();
        this.f30457b = (RecyclerView) view.findViewById(ge.k.g_res_0x7f0b0588);
        this.f30458c = (CardView) view.findViewById(ge.k.b_res_0x7f0b016b);
        this.f30459d = (TextView) view.findViewById(ge.k.j_res_0x7f0b0809);
        View findViewById = view.findViewById(ge.k.a_res_0x7f0b0122);
        this.f30460e = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: le.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                d.this.d0(view2);
            }
        });
        List<FragmentData> g02 = g0();
        this.f30462g = g02;
        this.f30461f = new b(g02, getChildFragmentManager());
        this.f30457b.setLayoutManager(new LinearLayoutManager(this.f30456a));
        this.f30457b.h(new me.a(0, 0, aa.d.a(8.0f), 0));
        this.f30457b.setAdapter(this.f30461f);
        j0();
    }
}
