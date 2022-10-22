package s2;

import cn.com.fmsh.tsm.business.enums.EnumCardAppType;
import u2.c;
import z2.b;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static /* synthetic */ a f34292a;

    private /* synthetic */ a() {
        b.a().b();
    }

    public static a b() {
        if (f34292a == null) {
            f34292a = new a();
        }
        return f34292a;
    }

    public t2.a a(EnumCardAppType enumCardAppType) {
        if (!(enumCardAppType == null || enumCardAppType == EnumCardAppType.CARD_APP_TYPE_SH)) {
            return (enumCardAppType == EnumCardAppType.CARD_APP_TYPE_SH_TOUR || enumCardAppType == EnumCardAppType.CARD_APP_TYPE_SH_RENT) ? new u2.b() : new u2.a();
        }
        return new c();
    }
}
