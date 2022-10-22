package cn.com.fmsh.tsm.business.enums;

import x2.c;
import x2.d;
import x2.f;
import x2.g;
import x2.h;
/* loaded from: classes.dex */
public enum EnumBackInfoType {
    TRAFFIC_CARD(0, f.a("亭逜卢应畵", 1)),
    RECHARGE_REFUND(1, h.e("儛健叞透歴", 1, 91)),
    CHANGE_MOVE(2, c.i("捹卿友禿贃", 196, 99)),
    SUBWAY_PAY(3, g.a(5, 75, "坥钁內仲制匭")),
    IMPROVE_ADVICE(4, g.a(218, 18, "動股敷善廨讪")),
    OTHER(5, d.c("仼道医廟甴", 5));
    

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ int f6189a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ String f6190b;

    /* synthetic */ EnumBackInfoType(int i10, String str) {
        this.f6189a = i10;
        this.f6190b = str;
    }

    public static EnumBackInfoType instance(int i10) {
        EnumBackInfoType[] values;
        for (EnumBackInfoType enumBackInfoType : values()) {
            if (enumBackInfoType.getId() == i10) {
                return enumBackInfoType;
            }
        }
        return null;
    }

    public String getDesc() {
        return this.f6190b;
    }

    public int getId() {
        return this.f6189a;
    }
}
