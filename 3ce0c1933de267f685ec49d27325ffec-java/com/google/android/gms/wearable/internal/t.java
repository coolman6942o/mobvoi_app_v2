package com.google.android.gms.wearable.internal;

import c7.f0;
import c7.o0;
import com.google.android.gms.common.api.internal.d;
import com.google.android.gms.wearable.k;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
final class t extends r<k.a> {
    public t(d<k.a> dVar) {
        super(dVar);
    }

    @Override // c7.a, com.google.android.gms.wearable.internal.d
    public final void l(zzea zzeaVar) {
        ArrayList arrayList = new ArrayList();
        List<zzfo> list = zzeaVar.f10267b;
        if (list != null) {
            arrayList.addAll(list);
        }
        m1(new f0(o0.a(zzeaVar.f10266a), arrayList));
    }
}
