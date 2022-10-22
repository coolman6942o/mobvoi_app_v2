package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;
/* loaded from: classes.dex */
final class c implements DynamiteModule.a {
    @Override // com.google.android.gms.dynamite.DynamiteModule.a
    public final DynamiteModule.a.b a(Context context, String str, DynamiteModule.a.AbstractC0110a aVar) throws DynamiteModule.LoadingException {
        DynamiteModule.a.b bVar = new DynamiteModule.a.b();
        int a10 = aVar.a(context, str);
        bVar.f9053a = a10;
        if (a10 != 0) {
            bVar.f9055c = -1;
        } else {
            int b10 = aVar.b(context, str, true);
            bVar.f9054b = b10;
            if (b10 != 0) {
                bVar.f9055c = 1;
            }
        }
        return bVar;
    }
}
