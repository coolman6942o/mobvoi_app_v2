package nd;

import android.app.Activity;
import android.content.Context;
import com.mobvoi.android.common.utils.k;
import ic.c;
/* compiled from: ShareLauncherImpl.java */
/* loaded from: classes2.dex */
public class d implements c {
    @Override // ic.c
    public void a(Context context, String str, String str2, String str3, int i10) {
        if (!(context instanceof Activity)) {
            k.d("ShareLauncher", "Can't share text without Activity context");
        } else {
            b.h((Activity) context, str, str2, str3, i10);
        }
    }

    @Override // ic.c
    public void b(Context context, boolean z10) {
        b.g(context);
    }
}
