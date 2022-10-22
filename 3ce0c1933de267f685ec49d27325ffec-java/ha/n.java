package ha;

import ia.d;
import kotlin.jvm.internal.i;
/* compiled from: Config.kt */
/* loaded from: classes2.dex */
public final class n {
    public static final d a(m mVar, String mid) {
        i.f(mVar, "<this>");
        i.f(mid, "mid");
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        o oVar = o.f27794a;
        return new d(mid, mVar.b(), mVar.d(), mVar.a(), mVar.getDeviceType(), currentTimeMillis, oVar.a(mid + mVar.getProductId() + currentTimeMillis, mVar.c()), "IOT4.0_R41388", "0", "0", "WIFI");
    }
}
