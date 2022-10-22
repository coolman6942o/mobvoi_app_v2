package cn.com.fmsh.tsm.business.enums;

import x2.a;
import x2.f;
/* loaded from: classes.dex */
public enum EnumCardBusinessOpType {
    ORDER(1, f.a("讯货濇洿", 5)),
    UNSUBSCRIBE(2, a.b("達诹", 4, 103));
    

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ int f6207a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ String f6208b;

    /* synthetic */ EnumCardBusinessOpType(int i10, String str) {
        this.f6207a = i10;
        this.f6208b = str;
    }

    public static EnumCardBusinessOpType getCardIoType(int i10) {
        EnumCardBusinessOpType[] values;
        for (EnumCardBusinessOpType enumCardBusinessOpType : values()) {
            if (enumCardBusinessOpType.getId() == i10) {
                return enumCardBusinessOpType;
            }
        }
        return null;
    }

    public String getDesc() {
        return this.f6208b;
    }

    public int getId() {
        return this.f6207a;
    }
}
