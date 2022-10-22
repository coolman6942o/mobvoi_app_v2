package ic;

import android.content.Context;
import android.content.Intent;
import gc.f;
/* compiled from: DefaultShareImpl.java */
/* loaded from: classes2.dex */
public class a implements c {
    @Override // ic.c
    public void a(Context context, String str, String str2, String str3, int i10) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.SUBJECT", str3);
        intent.putExtra("android.intent.extra.TEXT", str);
        intent.putExtra("android.intent.extra.TITLE", str2);
        context.startActivity(Intent.createChooser(intent, context.getString(f.f27362d)));
    }

    @Override // ic.c
    public void b(Context context, boolean z10) {
    }
}
