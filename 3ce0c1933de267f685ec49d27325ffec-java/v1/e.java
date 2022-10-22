package v1;

import a2.a;
import android.content.Context;
import android.os.Build;
import androidx.work.NetworkType;
import androidx.work.k;
import u1.b;
import w1.g;
import y1.p;
/* compiled from: NetworkMeteredController.java */
/* loaded from: classes.dex */
public class e extends c<b> {

    /* renamed from: e  reason: collision with root package name */
    private static final String f35574e = k.f("NetworkMeteredCtrlr");

    public e(Context context, a aVar) {
        super(g.c(context, aVar).d());
    }

    @Override // v1.c
    boolean b(p pVar) {
        return pVar.f36698j.b() == NetworkType.METERED;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: i */
    public boolean c(b bVar) {
        if (Build.VERSION.SDK_INT >= 26) {
            return !bVar.a() || !bVar.b();
        }
        k.c().a(f35574e, "Metered network constraint is not supported before API 26, only checking for connected state.", new Throwable[0]);
        return !bVar.a();
    }
}
