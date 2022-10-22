package cn.com.fmsh.tsm.business.enums;

import cn.com.fmsh.FM_Exception;
import com.realsil.sdk.dfu.DfuException;
import x2.c;
import x2.d;
import x2.e;
import x2.h;
/* loaded from: classes.dex */
public enum EnumBusinessOrderStatus {
    noOrder(0, FM_Exception.insert(2, 9, "本训贵")),
    orderIng(1, d.c("诣贿丮8术瞳该赵纚枆", 206)),
    orderSucess(2, e.a(2, "诵起才功")),
    orderFail(3, e.a(5, "诸走失账")),
    unsubscribeing(4, c.i("逕讧丸", 62, 112)),
    unsubscribeSucess(5, h.e("送讨戃劃", 4, 9)),
    unsubscribeFail(6, FM_Exception.insert(DfuException.ERROR_NO_SERVICE_FOUND_OR_LOSS, 21, "逊讽夥赬"));
    

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ int f6195a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ String f6196b;

    /* synthetic */ EnumBusinessOrderStatus(int i10, String str) {
        this.f6195a = i10;
        this.f6196b = str;
    }

    public static EnumBusinessOrderStatus getBusinessOrderStatus4ID(int i10) {
        EnumBusinessOrderStatus[] values;
        for (EnumBusinessOrderStatus enumBusinessOrderStatus : values()) {
            if (enumBusinessOrderStatus.getId() == i10) {
                return enumBusinessOrderStatus;
            }
        }
        return null;
    }

    public String getDesc() {
        return this.f6196b;
    }

    public int getId() {
        return this.f6195a;
    }
}
