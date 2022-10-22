package cn.com.fmsh.tsm.business.enums;

import x2.b;
import x2.d;
import x2.f;
import x2.h;
/* loaded from: classes.dex */
public enum EnumCardAppType {
    CARD_APP_TYPE_SH(1, h.e("丈浣亢适匫", 5, 18)),
    CARD_APP_TYPE_LNT(2, b.b(5, "岿半递")),
    CARD_APP_TYPE_SH_TOUR(3, f.a("一浰旁渹卿", 162)),
    CARD_APP_TYPE_SH_RENT(4, d.c("乞洲瞻禘卹", 1));
    

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ int f6204a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ String f6205b;

    /* synthetic */ EnumCardAppType(int i10, String str) {
        this.f6204a = i10;
        this.f6205b = str;
    }

    public static EnumCardAppType instance(int i10) {
        EnumCardAppType[] values;
        for (EnumCardAppType enumCardAppType : values()) {
            if (enumCardAppType.getId() == i10) {
                return enumCardAppType;
            }
        }
        return null;
    }

    public String getDesc() {
        return this.f6205b;
    }

    public int getId() {
        return this.f6204a;
    }
}
