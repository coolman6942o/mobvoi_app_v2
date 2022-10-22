package com.google.android.gms.wearable.internal;

import b6.i;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.e;
import com.google.android.gms.wearable.a;
/* loaded from: classes.dex */
public final class z implements a {
    @Override // com.google.android.gms.wearable.a
    public final e<a.b> a(d dVar, String str, int i10) {
        boolean z10 = true;
        if (!(i10 == 0 || i10 == 1)) {
            z10 = false;
        }
        i.a(z10);
        return dVar.j(new a0(this, dVar, str, i10));
    }
}
