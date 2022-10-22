package cn.com.fmsh.tsm.business.enums;

import cn.com.fmsh.FM_Exception;
import com.realsil.sdk.dfu.DfuException;
import x2.b;
import x2.d;
import x2.e;
import x2.f;
import x2.g;
import x2.h;
/* loaded from: classes.dex */
public enum EnumTradeType {
    bus(1, f.a("兢亯", 38)),
    privilege(2, d.c("住您份晙", 4)),
    subwayConsumption(3, FM_Exception.insert(2, 126, "轮遗亦通淖赥")),
    subwayUpdate(4, b.b(204, "輱逗仫遀曱斠")),
    maglev(5, e.a(DfuException.ERROR_READ_PATCH_INFO_ERROR, "磄悤浥")),
    recharge(6, e.a(5, "償贙")),
    ferry(7, d.c("轳港", 202)),
    taxi(8, d.c("冬禘", 3)),
    expressway(9, g.a(2, 120, "骊違儮趵")),
    park(10, FM_Exception.insert(4, 26, "偔轤圦")),
    gasStation(11, FM_Exception.insert(172, 104, "劰没站")),
    onlineRecharge(12, d.c("缉乃償贏", 5)),
    onlineConsumption(13, f.a("罝七涎贺", 4)),
    elseTrade(14, f.a("兼仑亠昒", 2)),
    Consumption(15, h.e("淗贤", 2, 62)),
    CompositeConsumption(16, f.a("夆吀涍贻", 3));
    

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ int f6231a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ String f6232b;

    /* synthetic */ EnumTradeType(int i10, String str) {
        this.f6231a = i10;
        this.f6232b = str;
    }

    public String getDesc() {
        return this.f6232b;
    }

    public int getId() {
        return this.f6231a;
    }
}
