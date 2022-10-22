package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;
/* loaded from: classes.dex */
final class e implements DynamiteModule.a {
    @Override // com.google.android.gms.dynamite.DynamiteModule.a
    public final DynamiteModule.a.b a(Context context, String str, DynamiteModule.a.AbstractC0110a aVar) throws DynamiteModule.LoadingException {
        DynamiteModule.a.b bVar = new DynamiteModule.a.b();
        int a10 = aVar.a(context, str);
        bVar.f9053a = a10;
        if (a10 != 0) {
            bVar.f9054b = aVar.b(context, str, false);
        } else {
            bVar.f9054b = aVar.b(context, str, true);
        }
        int i10 = bVar.f9053a;
        if (i10 == 0 && bVar.f9054b == 0) {
            bVar.f9055c = 0;
        } else if (i10 >= bVar.f9054b) {
            bVar.f9055c = -1;
        } else {
            bVar.f9055c = 1;
        }
        return bVar;
    }
}
