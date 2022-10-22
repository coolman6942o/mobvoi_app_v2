package v1;

import a2.a;
import android.content.Context;
import android.os.Build;
import androidx.work.NetworkType;
import u1.b;
import y1.p;
/* compiled from: NetworkUnmeteredController.java */
/* loaded from: classes.dex */
public class g extends c<b> {
    public g(Context context, a aVar) {
        super(w1.g.c(context, aVar).d());
    }

    @Override // v1.c
    boolean b(p pVar) {
        return pVar.f36698j.b() == NetworkType.UNMETERED || (Build.VERSION.SDK_INT >= 30 && pVar.f36698j.b() == NetworkType.TEMPORARILY_UNMETERED);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: i */
    public boolean c(b bVar) {
        return !bVar.a() || bVar.b();
    }
}
