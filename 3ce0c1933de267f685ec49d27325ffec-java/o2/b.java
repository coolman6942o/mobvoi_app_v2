package o2;

import cn.com.fmsh.script.ApduHandler;
import cn.com.fmsh.script.a;
import q2.c;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static volatile /* synthetic */ b f31403a;

    private /* synthetic */ b() {
    }

    public static b a() {
        if (f31403a == null) {
            c();
        }
        return f31403a;
    }

    public static void c() {
        if (f31403a == null) {
            f31403a = new b();
        }
    }

    public a b(ApduHandler apduHandler) {
        return new c(apduHandler);
    }
}
