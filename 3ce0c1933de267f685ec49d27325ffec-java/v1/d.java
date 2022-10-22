package v1;

import a2.a;
import android.content.Context;
import android.os.Build;
import androidx.work.NetworkType;
import u1.b;
import w1.g;
import y1.p;
/* compiled from: NetworkConnectedController.java */
/* loaded from: classes.dex */
public class d extends c<b> {
    public d(Context context, a aVar) {
        super(g.c(context, aVar).d());
    }

    @Override // v1.c
    boolean b(p pVar) {
        return pVar.f36698j.b() == NetworkType.CONNECTED;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: i */
    public boolean c(b bVar) {
        if (Build.VERSION.SDK_INT >= 26) {
            return !bVar.a() || !bVar.d();
        }
        return !bVar.a();
    }
}
