package k4;

import android.content.Context;
import com.amap.api.mapcore2d.n;
import java.util.List;
/* compiled from: LogDBOperation.java */
/* loaded from: classes.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    private n f29749a;

    public l(Context context) {
        try {
            this.f29749a = new n(context, n.g(k.class));
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    private void c(String str, Class<? extends m> cls) {
        this.f29749a.k(m.h(str), cls);
    }

    public void a(m mVar) {
        if (mVar != null) {
            String h10 = m.h(mVar.d());
            List f10 = this.f29749a.f(h10, mVar.getClass(), true);
            if (f10 == null || f10.size() == 0) {
                this.f29749a.j(mVar, true);
                return;
            }
            m mVar2 = (m) f10.get(0);
            if (mVar.a() == 0) {
                mVar2.e(mVar2.g() + 1);
            } else {
                mVar2.e(0);
            }
            this.f29749a.l(h10, mVar2, true);
        }
    }

    public void b(String str, Class<? extends m> cls) {
        try {
            c(str, cls);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }
}
