package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;
/* loaded from: classes.dex */
final class f implements DynamiteModule.a {
    @Override // com.google.android.gms.dynamite.DynamiteModule.a
    public final DynamiteModule.a.b a(Context context, String str, DynamiteModule.a.AbstractC0110a aVar) throws DynamiteModule.LoadingException {
        DynamiteModule.a.b bVar = new DynamiteModule.a.b();
        bVar.f9053a = aVar.a(context, str);
        int b10 = aVar.b(context, str, true);
        bVar.f9054b = b10;
        int i10 = bVar.f9053a;
        if (i10 == 0 && b10 == 0) {
            bVar.f9055c = 0;
        } else if (b10 >= i10) {
            bVar.f9055c = 1;
        } else {
            bVar.f9055c = -1;
        }
        return bVar;
    }
}
