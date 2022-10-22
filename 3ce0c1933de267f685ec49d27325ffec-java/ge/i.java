package ge;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.r;
import com.mobvoi.companion.common.analytics.Module;
import com.mobvoi.device.DevicePairActivity;
import java.util.ArrayList;
import java.util.List;
import je.c;
import le.f;
import le.g;
/* compiled from: DeviceTabFragment.java */
/* loaded from: classes2.dex */
public class i extends ge.a {

    /* renamed from: b  reason: collision with root package name */
    private a f27407b;

    /* renamed from: c  reason: collision with root package name */
    private c f27408c;

    /* renamed from: d  reason: collision with root package name */
    private f f27409d;

    /* renamed from: e  reason: collision with root package name */
    private g f27410e;

    /* compiled from: DeviceTabFragment.java */
    /* loaded from: classes2.dex */
    static class a extends r {

        /* renamed from: h  reason: collision with root package name */
        private final List<Fragment> f27411h;

        /* renamed from: i  reason: collision with root package name */
        private Context f27412i;

        public a(Context context, FragmentManager fragmentManager, List<Fragment> list) {
            super(fragmentManager);
            this.f27412i = context;
            this.f27411h = list;
        }

        @Override // androidx.viewpager.widget.a
        public int d() {
            return this.f27411h.size();
        }

        @Override // androidx.viewpager.widget.a
        public CharSequence f(int i10) {
            if (i10 == 0) {
                return this.f27412i.getString(m.d_res_0x7f14039c);
            }
            return this.f27412i.getString(m.c_res_0x7f14039b);
        }

        @Override // androidx.fragment.app.r
        public Fragment t(int i10) {
            return this.f27411h.get(i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d0(View view) {
        e0();
    }

    private void e0() {
        if (a0()) {
            this.f27398a.startActivity(new Intent(this.f27398a, DevicePairActivity.class));
            sb.a.d(requireContext(), "add_ticwatch");
            return;
        }
        b0();
    }

    @Override // ge.a
    protected View Y(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        c d10 = c.d(layoutInflater);
        this.f27408c = d10;
        return d10.a();
    }

    @Override // ge.a
    protected void Z() {
        this.f27408c.f29559d.setVisibility(0);
        this.f27408c.f29560e.setVisibility(0);
        this.f27408c.f29558c.setVisibility(0);
        this.f27408c.f29558c.setBackgroundResource(j.f27427r);
        this.f27408c.f29558c.setOnClickListener(new View.OnClickListener() { // from class: ge.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                i.this.d0(view);
            }
        });
        ArrayList arrayList = new ArrayList();
        if (this.f27410e == null) {
            this.f27410e = new g();
        }
        if (this.f27409d == null) {
            this.f27409d = new f();
        }
        arrayList.add(this.f27410e);
        arrayList.add(this.f27409d);
        a aVar = this.f27407b;
        if (aVar == null) {
            a aVar2 = new a(this.f27398a, getChildFragmentManager(), arrayList);
            this.f27407b = aVar2;
            this.f27408c.f29560e.setAdapter(aVar2);
        } else {
            aVar.j();
        }
        c cVar = this.f27408c;
        cVar.f29557b.setupWithViewPager(cVar.f29560e);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        sb.a.h(requireActivity(), Module.DEVICE);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        sb.a.i(requireActivity(), Module.DEVICE);
    }
}
