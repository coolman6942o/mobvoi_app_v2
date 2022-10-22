package cn.com.fmsh.tsm.business.enums;

import cn.com.fmsh.FM_Exception;
import com.realsil.sdk.dfu.DfuException;
import x2.d;
import x2.f;
import x2.g;
import x2.h;
/* loaded from: classes.dex */
public enum EnumBusinessOrderLoadType {
    unknown(0, d.c("板瞣", DfuException.ERROR_GATT_DISCOVER_SERVICE_FAILED)),
    load(1, f.a("映遑儍偹", 230)),
    supplementLoad(2, FM_Exception.insert(3, 15, "衢兓倹")),
    welfareLoad(3, g.a(150, 52, "禉刳儋倾")),
    promotionLoad(4, h.e("葻镅光偯:", 1, 71));
    

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ int f6192a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ String f6193b;

    /* synthetic */ EnumBusinessOrderLoadType(int i10, String str) {
        this.f6192a = i10;
        this.f6193b = str;
    }

    public static EnumBusinessOrderLoadType getBusinessOrderLoadType4ID(int i10) {
        EnumBusinessOrderLoadType[] values;
        for (EnumBusinessOrderLoadType enumBusinessOrderLoadType : values()) {
            if (enumBusinessOrderLoadType.getId() == i10) {
                return enumBusinessOrderLoadType;
            }
        }
        return null;
    }

    public String getDesc() {
        return this.f6193b;
    }

    public int getId() {
        return this.f6192a;
    }
}
