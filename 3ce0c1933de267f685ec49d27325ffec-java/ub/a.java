package ub;

import com.mobvoi.companion.ui.e;
import com.mobvoi.wear.common.base.TicwatchModels;
import com.mobvoi.wear.info.WearInfo;
import java.util.List;
import vb.k;
/* compiled from: AwOverseaCardFragment.java */
/* loaded from: classes2.dex */
public class a extends h {
    @Override // ub.h
    public List<e> m0() {
        List<e> q5 = k.q(requireActivity(), this.f35366p);
        e eVar = q5.get(1);
        e eVar2 = q5.get(0);
        e eVar3 = q5.get(2);
        e eVar4 = q5.get(3);
        q5.get(5);
        e eVar5 = q5.get(6);
        if (this.f35366p == null) {
            q5.remove(eVar2);
            q5.remove(eVar3);
            q5.remove(eVar4);
            q5.remove(eVar);
            return q5;
        }
        WearInfo i10 = com.mobvoi.companion.wear.a.f().i(this.f35366p.nodeId);
        if (i10 == null) {
            com.mobvoi.android.common.utils.k.q("TicwatchHealthCard", "No current wear info set");
            q5.remove(eVar2);
            q5.remove(eVar3);
            q5.remove(eVar4);
            q5.remove(eVar);
            return q5;
        }
        String str = i10.wearType;
        boolean startsWith = str.startsWith("TicWatch Pro 3");
        boolean startsWith2 = str.startsWith(TicwatchModels.TICWATCH_E3);
        if (!startsWith && !startsWith2) {
            q5.remove(eVar2);
            q5.remove(eVar4);
            if (!yb.a.a()) {
                q5.remove(eVar3);
            }
        }
        if (!TicwatchModels.TICWATCH_PRO_4G.equals(str)) {
            q5.remove(eVar);
        }
        if (!TicwatchModels.isOverseaRoverU(str)) {
            q5.remove(eVar5);
        }
        return q5;
    }
}
