package a7;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.d;
/* loaded from: classes.dex */
final class c extends a.AbstractC0105a<com.google.android.gms.signin.internal.a, a> {
    @Override // com.google.android.gms.common.api.a.AbstractC0105a
    public final /* synthetic */ com.google.android.gms.signin.internal.a c(Context context, Looper looper, b6.c cVar, a aVar, d.b bVar, d.c cVar2) {
        a aVar2 = aVar;
        if (aVar2 == null) {
            aVar2 = a.f110i;
        }
        return new com.google.android.gms.signin.internal.a(context, looper, true, cVar, aVar2, bVar, cVar2);
    }
}
