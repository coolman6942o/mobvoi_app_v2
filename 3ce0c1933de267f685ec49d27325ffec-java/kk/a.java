package kk;

import ak.e;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.mobvoi.ticcare.common.model.bean.TicCareDeviceInfo;
import ik.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import qk.d;
/* compiled from: TicCareDeviceFragment.java */
/* loaded from: classes2.dex */
public class a extends Fragment implements d {

    /* renamed from: a  reason: collision with root package name */
    private List<TicCareDeviceInfo> f29997a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private f f29998b;

    @Override // qk.d
    public void d() {
        if (this.f29998b != null) {
            List<TicCareDeviceInfo> r10 = fk.f.q(getActivity()).r();
            this.f29997a = r10;
            this.f29998b.k(r10);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(e.i_res_0x7f0e0192, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f29997a = arguments.getParcelableArrayList("extra.device_list");
            RecyclerView recyclerView = (RecyclerView) view.findViewById(ak.d.f227p);
            HashMap hashMap = new HashMap();
            hashMap.put("bottom_decoration", 20);
            recyclerView.h(new fk.a(hashMap));
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            f fVar = new f();
            this.f29998b = fVar;
            fVar.k(this.f29997a);
            recyclerView.setAdapter(this.f29998b);
        }
        fk.f.q(view.getContext()).o(this);
    }
}
