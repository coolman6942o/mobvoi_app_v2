package le;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.vpa.vpacommonlib.FragmentData;
import fk.f;
import ge.l;
import ie.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import qk.a;
import qk.b;
/* compiled from: DeviceMyDeviceFragment.java */
/* loaded from: classes2.dex */
public class g extends d {
    private void m0(List<a> list) {
        List d10;
        HashMap hashMap = new HashMap();
        for (a aVar : list) {
            String deviceType = aVar.getDeviceType();
            if (!TextUtils.equals(deviceType, "tic_care") && (d10 = aVar.d()) != null) {
                hashMap.put(deviceType, d10);
            }
        }
        e.o(hashMap);
    }

    @Override // le.d
    protected int b0() {
        return l.e_res_0x7f0e00c8;
    }

    @Override // le.d
    public List<FragmentData> g0() {
        ArrayList arrayList = new ArrayList();
        for (a aVar : b.g().b()) {
            if (!(aVar instanceof f)) {
                if (aVar instanceof ub.f) {
                    for (Map.Entry<Bundle, Class<? extends Fragment>> entry : ((ub.f) aVar).k().entrySet()) {
                        Bundle key = entry.getKey();
                        String string = key.getString("wear_node_id");
                        FragmentData fragmentData = new FragmentData(entry.getValue(), aVar.getDeviceType() + string);
                        fragmentData.e("argument", key);
                        arrayList.add(fragmentData);
                    }
                } else {
                    Class<?> c10 = aVar.c();
                    if (c10 != null) {
                        k.c("DeviceTabFragment", "dm: %s ,fragment: %s", aVar.getDeviceType(), c10.getName());
                        FragmentData fragmentData2 = new FragmentData(c10, aVar.getDeviceType());
                        fragmentData2.e("argument", aVar.a());
                        arrayList.add(fragmentData2);
                    }
                }
            }
        }
        return arrayList;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        h0();
        m0(b.g().b());
    }
}
