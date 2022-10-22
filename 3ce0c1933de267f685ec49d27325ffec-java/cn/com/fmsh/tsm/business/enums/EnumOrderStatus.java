package cn.com.fmsh.tsm.business.enums;

import x2.a;
import x2.b;
import x2.c;
import x2.d;
import x2.e;
import x2.f;
import x2.h;
/* loaded from: classes.dex */
public enum EnumOrderStatus {
    notExist(0, f.a("讯卟上孜圩", 5)),
    notPay(1, a.b("松攠仒", 4, 27)),
    hasPaid(2, d.c("嶧亞歩", 2)),
    success(3, e.a(2, "仳晉才功")),
    failure(4, h.e("份昞夰贰", 252, 20)),
    unsettled(5, e.a(2, "仳晉狫态朩矣")),
    apilyForRefund(6, f.a("畣论遊歹乩", 232)),
    hasRefunded(7, f.a("嶾遉歸", 196)),
    refundFailure(8, a.b("違欩奨贾", 5, 66)),
    payFailure(9, d.c("亀歷奫赮", 5)),
    waitForPay(10, e.a(4, "応敳亇")),
    recharging(11, c.i("仡遉占儊偡並", 206, 46)),
    dubious(12, e.a(3, "厷痊赸径夀琁")),
    invalid(13, b.b(234, "诵南兾闵")),
    unknown(99, e.a(3, "杲瞾"));
    

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ int f6216a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ String f6217b;

    /* synthetic */ EnumOrderStatus(int i10, String str) {
        this.f6216a = i10;
        this.f6217b = str;
    }

    public static EnumOrderStatus getOrderStatus4ID(int i10) {
        EnumOrderStatus[] values;
        for (EnumOrderStatus enumOrderStatus : values()) {
            if (enumOrderStatus.getId() == i10) {
                return enumOrderStatus;
            }
        }
        return null;
    }

    public String getDesc() {
        return this.f6217b;
    }

    public int getId() {
        return this.f6216a;
    }
}
