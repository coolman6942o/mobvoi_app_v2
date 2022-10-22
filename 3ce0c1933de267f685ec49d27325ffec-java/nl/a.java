package nl;

import cm.d;
import com.realsil.sdk.dfu.exception.LoadFileException;
import java.util.List;
/* loaded from: classes2.dex */
public final class a {
    public static int a(d dVar, cm.a aVar) {
        int i10;
        if (dVar == null || aVar == null || !((i10 = dVar.f6004j) == 5 || i10 == 9 || i10 == 12)) {
            return 4096;
        }
        if (dVar.O()) {
            if (!aVar.f5982e) {
                return LoadFileException.ERROR_SINGLE_NOT_SUPPORT;
            }
            List<vl.a> b10 = aVar.b(dVar.y());
            if (b10 == null || b10.size() <= 0) {
                return LoadFileException.ERROR_PACK_EMPTY;
            }
            for (vl.a aVar2 : b10) {
                if (aVar2.f35836i == 2048) {
                    return 4096;
                }
            }
            return LoadFileException.ERROR_PACK_NS_DUALBANK;
        } else if (!aVar.f5982e) {
            return aVar.a(2048) != null ? 4112 : 4096;
        } else {
            List<vl.a> b11 = aVar.b(dVar.y());
            if (b11 == null || b11.size() <= 0) {
                return LoadFileException.ERROR_PACK_EMPTY;
            }
            for (vl.a aVar3 : b11) {
                if (aVar3.f35836i == 2048) {
                    return 4112;
                }
            }
            return 4096;
        }
    }
}
