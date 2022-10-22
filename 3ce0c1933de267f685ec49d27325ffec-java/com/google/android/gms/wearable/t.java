package com.google.android.gms.wearable;

import android.content.Context;
import android.os.Looper;
import b6.c;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.d;
import com.google.android.gms.wearable.internal.x;
import com.google.android.gms.wearable.l;
/* loaded from: classes.dex */
final class t extends a.AbstractC0105a<x, l.a> {
    @Override // com.google.android.gms.common.api.a.AbstractC0105a
    public final /* synthetic */ x c(Context context, Looper looper, c cVar, l.a aVar, d.b bVar, d.c cVar2) {
        if (aVar == null) {
            new l.a(new l.a.C0117a(), null);
        }
        return new x(context, looper, bVar, cVar2, cVar);
    }
}
