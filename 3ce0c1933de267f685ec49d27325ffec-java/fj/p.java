package fj;

import android.content.Context;
import android.os.Build;
import androidx.fragment.app.f;
import com.mobvoi.mcuwatch.engine.u;
import ei.h;
import fi.a;
import java.util.Iterator;
import java.util.List;
import qi.w;
import rx.c;
import yp.g;
/* compiled from: WatchLitePairViewModel.java */
/* loaded from: classes2.dex */
public class p extends w {
    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean J(Object obj) {
        return Boolean.valueOf(obj instanceof a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ a K(Object obj) {
        return (a) obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean L(String str, a aVar) {
        return Boolean.valueOf(aVar.d(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ c M(Context context, Boolean bool) {
        if (bool.booleanValue()) {
            return j.h((f) context, "android.permission.BLUETOOTH_SCAN", "android.permission.BLUETOOTH_CONNECT");
        }
        return c.A(this.f33188d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: O */
    public c<a> N(Context context, final String str, List<e> list) {
        boolean z10;
        Iterator<e> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                if (!it.next().f27050a) {
                    z10 = false;
                    break;
                }
            } else {
                z10 = true;
                break;
            }
        }
        if (!z10) {
            return c.A(new a(0, str));
        }
        h.a().g(context, str);
        return ci.a.b().c().u(n.f27064a).D(o.f27065a).u(new g() { // from class: fj.m
            @Override // yp.g
            public final Object call(Object obj) {
                Boolean L;
                L = p.L(str, (a) obj);
                return L;
            }
        });
    }

    public c<String> I() {
        return u.f19202a.D();
    }

    public c<a> P(final Context context, final String str) {
        this.f33188d.clear();
        return c.A(Boolean.valueOf(Build.VERSION.SDK_INT > 30)).v(new g() { // from class: fj.k
            @Override // yp.g
            public final Object call(Object obj) {
                c M;
                M = p.this.M(context, (Boolean) obj);
                return M;
            }
        }).v(new g() { // from class: fj.l
            @Override // yp.g
            public final Object call(Object obj) {
                c N;
                N = p.this.N(context, str, (List) obj);
                return N;
            }
        });
    }
}
