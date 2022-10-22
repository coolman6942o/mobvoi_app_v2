package ak;

import android.content.Intent;
import com.mobvoi.android.common.utils.b;
/* compiled from: TiccareApplication.java */
/* loaded from: classes2.dex */
public class h {

    /* compiled from: TiccareApplication.java */
    /* loaded from: classes2.dex */
    private static class a {

        /* renamed from: a  reason: collision with root package name */
        private static final h f248a = new h();
    }

    public static h a() {
        return a.f248a;
    }

    public void b(boolean z10) {
        if (z10) {
            b1.a.b(b.e()).d(new Intent("action.app_foregound"));
        }
    }
}
