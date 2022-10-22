package n4;

import android.content.Context;
import com.amap.api.services.a.m;
import java.util.List;
/* compiled from: LogDBOperation.java */
/* loaded from: classes.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    private m f31016a;

    public k(Context context) {
        try {
            this.f31016a = new m(context, m.g(j.class));
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    private void c(String str, Class<? extends l> cls) {
        this.f31016a.k(l.h(str), cls);
    }

    public void a(l lVar) {
        if (lVar != null) {
            String h10 = l.h(lVar.d());
            List f10 = this.f31016a.f(h10, lVar.getClass(), true);
            if (f10 == null || f10.size() == 0) {
                this.f31016a.j(lVar, true);
                return;
            }
            l lVar2 = (l) f10.get(0);
            if (lVar.a() == 0) {
                lVar2.e(lVar2.g() + 1);
            } else {
                lVar2.e(0);
            }
            this.f31016a.l(h10, lVar2, true);
        }
    }

    public void b(String str, Class<? extends l> cls) {
        try {
            c(str, cls);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }
}
