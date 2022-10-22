package li;

import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import nj.q;
import okhttp3.b0;
import okhttp3.u;
import okhttp3.v;
import okhttp3.z;
/* compiled from: WatchfaceUrlInterceptor.kt */
/* loaded from: classes2.dex */
public final class a implements v {

    /* compiled from: WatchfaceUrlInterceptor.kt */
    /* renamed from: li.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0383a {
        private C0383a() {
        }

        public /* synthetic */ C0383a(f fVar) {
            this();
        }
    }

    static {
        new C0383a(null);
    }

    @Override // okhttp3.v
    public b0 intercept(v.a chain) {
        String str;
        i.f(chain, "chain");
        z request = chain.request();
        z.a i10 = request.i();
        u l10 = request.l();
        switch (q.g().l()) {
            case 1:
                str = "mcu/watch-face";
                break;
            case 2:
            case 3:
                str = "mcu-square/watch-face";
                break;
            case 4:
                str = "mcu/gta/watch-face";
                break;
            case 5:
                str = "mcu/apollo/watch-face";
                break;
            case 6:
            case 7:
                str = "mcu/gtk/watch-face";
                break;
            default:
                str = null;
                break;
        }
        if (str == null) {
            return chain.a(i10.b());
        }
        return chain.a(i10.q(l10.j().b(str).e()).b());
    }
}
