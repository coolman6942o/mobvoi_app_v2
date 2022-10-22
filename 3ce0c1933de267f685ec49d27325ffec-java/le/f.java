package le;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.ticcare.ui.ScanCareCodeActivity;
import com.mobvoi.vpa.vpacommonlib.FragmentData;
import ge.l;
import java.util.ArrayList;
import java.util.List;
import qk.a;
import qk.b;
import qk.d;
/* compiled from: DeviceCareFragment.java */
/* loaded from: classes2.dex */
public class f extends d implements d {

    /* renamed from: i  reason: collision with root package name */
    private static final String f30465i = f.class.getSimpleName();

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d0(View view) {
        startActivity(new Intent(this.f30456a, ScanCareCodeActivity.class));
    }

    @Override // le.d
    protected int b0() {
        return l.b_res_0x7f0e00c5;
    }

    @Override // qk.d
    public void d() {
        h0();
    }

    @Override // le.d
    public List<FragmentData> g0() {
        Class<?> c10;
        ArrayList arrayList = new ArrayList();
        for (a aVar : b.g().b()) {
            if ((aVar instanceof fk.f) && (c10 = aVar.c()) != null) {
                k.c(f30465i, "dm: getDeviceType %s, fragment: %s", aVar.getDeviceType(), c10.getName());
                FragmentData fragmentData = new FragmentData(c10, aVar.getDeviceType());
                fragmentData.e("argument", aVar.a());
                arrayList.add(fragmentData);
            }
        }
        return arrayList;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        sb.a.h(requireContext(), "homeCare");
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        sb.a.i(requireContext(), "homeCare");
        h0();
    }

    @Override // le.d, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        fk.f.q(view.getContext()).o(this);
        this.f30460e.setOnClickListener(new View.OnClickListener() { // from class: le.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                f.this.d0(view2);
            }
        });
    }
}
