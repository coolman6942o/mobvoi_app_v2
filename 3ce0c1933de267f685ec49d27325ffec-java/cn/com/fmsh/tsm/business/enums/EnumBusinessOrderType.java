package cn.com.fmsh.tsm.business.enums;

import cn.com.fmsh.FM_Exception;
import x2.b;
import x2.c;
import x2.d;
import x2.e;
import x2.f;
import x2.h;
/* loaded from: classes.dex */
public enum EnumBusinessOrderType {
    ORDER_TYPE_RECHARGE(1, b.b(234, "儒倾讯卍")),
    ORDER_TYPE_ISSUE(2, f.a("叟卪讪卐", 6)),
    ORDER_TYPE_PROMOTION(3, e.a(3, "供镛诼協")),
    TRANSFER(4, d.c("輸赣说匒", 1)),
    ORDER_TYPE_ADDED(5, c.i("蠹儜偪诱包", 5, 125)),
    ORDER_TYPE_WELFARE(6, FM_Exception.insert(194, 6, "秉剥诰匍")),
    UNKNOW(0, h.e("杴瞷", 1, 116));
    

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ int f6198a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ String f6199b;

    /* synthetic */ EnumBusinessOrderType(int i10, String str) {
        this.f6198a = i10;
        this.f6199b = str;
    }

    public static EnumBusinessOrderType instance(int i10) {
        EnumBusinessOrderType[] values;
        for (EnumBusinessOrderType enumBusinessOrderType : values()) {
            if (enumBusinessOrderType.getId() == i10) {
                return enumBusinessOrderType;
            }
        }
        return null;
    }

    public String getDesc() {
        return this.f6199b;
    }

    public int getId() {
        return this.f6198a;
    }
}
