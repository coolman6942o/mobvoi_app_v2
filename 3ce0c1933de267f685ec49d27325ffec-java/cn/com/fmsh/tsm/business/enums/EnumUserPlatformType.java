package cn.com.fmsh.tsm.business.enums;

import x2.b;
import x2.c;
/* loaded from: classes.dex */
public enum EnumUserPlatformType {
    NFCOS(1, c.i("\u0014\u0003S\u0014U粪练年厢", 3, 75)),
    THIRD(2, b.b(3, "笼丒斿幢召"));
    

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ int f6234a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ String f6235b;

    /* synthetic */ EnumUserPlatformType(int i10, String str) {
        this.f6234a = i10;
        this.f6235b = str;
    }

    public static EnumUserPlatformType getActivationStatus4ID(int i10) {
        EnumUserPlatformType[] values;
        for (EnumUserPlatformType enumUserPlatformType : values()) {
            if (enumUserPlatformType.getId() == i10) {
                return enumUserPlatformType;
            }
        }
        return null;
    }

    public String getDesc() {
        return this.f6235b;
    }

    public int getId() {
        return this.f6234a;
    }
}
