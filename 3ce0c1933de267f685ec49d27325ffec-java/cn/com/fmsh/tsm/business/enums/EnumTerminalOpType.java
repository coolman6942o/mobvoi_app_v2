package cn.com.fmsh.tsm.business.enums;

import cn.com.fmsh.FM_Exception;
import x2.a;
import x2.c;
/* loaded from: classes.dex */
public enum EnumTerminalOpType {
    ANDROID(1, a.b("\u0010X_\u0012JC\u000b", 1, 37)),
    IOS(2, FM_Exception.insert(3, 29, "nK\u0012")),
    WINDOWS(3, c.i("+.<ygd-", 5, 107));
    

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ int f6228a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ String f6229b;

    /* synthetic */ EnumTerminalOpType(int i10, String str) {
        this.f6228a = i10;
        this.f6229b = str;
    }

    public static EnumTerminalOpType getEnumTerminalOpType4ID(int i10) {
        EnumTerminalOpType[] values;
        for (EnumTerminalOpType enumTerminalOpType : values()) {
            if (enumTerminalOpType.getId() == i10) {
                return enumTerminalOpType;
            }
        }
        return null;
    }

    public String getDesc() {
        return this.f6229b;
    }

    public int getId() {
        return this.f6228a;
    }
}
