package pk;

import java.util.UUID;
import java.util.concurrent.TimeUnit;
/* compiled from: DataConvert.java */
/* loaded from: classes2.dex */
public final /* synthetic */ class h {
    public static long a(i _this, long j10) {
        return TimeUnit.SECONDS.toMillis(j10);
    }

    public static String b(i _this) {
        return e.f().a().b();
    }

    public static String c(i _this) {
        return n.b();
    }

    public static String d(i _this) {
        return UUID.randomUUID().toString();
    }

    public static String e(i _this) {
        return e.f().a().getWwid();
    }
}
