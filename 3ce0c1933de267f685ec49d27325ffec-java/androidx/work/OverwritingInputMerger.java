package androidx.work;

import androidx.work.d;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public final class OverwritingInputMerger extends h {
    @Override // androidx.work.h
    public d b(List<d> list) {
        d.a aVar = new d.a();
        HashMap hashMap = new HashMap();
        for (d dVar : list) {
            hashMap.putAll(dVar.h());
        }
        aVar.d(hashMap);
        return aVar.a();
    }
}
