package cn.com.fmsh.tsm.business.enums;

import cn.com.fmsh.FM_Exception;
import x2.a;
import x2.b;
import x2.c;
import x2.d;
import x2.f;
import x2.h;
/* loaded from: classes.dex */
public enum EnumRechargeMode {
    COMPANY_GIVE(0, c.i("唟扸伝悻", 2, 86)),
    ALIPAY_ONE_KEY(1, d.c("敹亟寅义锴攤仄", 3)),
    ALIPAY_SECURE(2, b.b(118, "攬他宄宍內攵亝")),
    UNIONPAY(3, d.c("钠耓斸匨7卪兰叵儗奨`", 3)),
    UNIONPAY_CARD(49, c.i("钯聇杄卦l卺儹号儀夤", 130, 58)),
    UNIONPAY_FM(4, f.a("铸聟%夈旤忱", 6)),
    UNIONPAY_CARD_FM(65, h.e("钩聜杘医.奁斳徰赡厧9", 2, 41)),
    CARD_SHIFT_CAPITAL(58, c.i("亱遑占蠲先偿q丂厪额厀祯4", 318, 54)),
    MIPAY_MI(81, a.b("屝簩敭仒", 2, 104)),
    SAMSUNG_PAY(86, a.b("九晐攥仝", 4, 91)),
    UNIONPAY_CARD_PT(87, d.c("钠耓村匨7鹄泬丄晁", 3)),
    MOBILE_PROMOTION(60, d.c("禯勭侕镇0丄叵颍厍礥", 1)),
    HW_PAY(69, d.c("卙串敶互", 292)),
    LKL_PAY(80, FM_Exception.insert(5, 125, "拀卧拊支亅"));
    

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ int f6222a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ String f6223b;

    /* synthetic */ EnumRechargeMode(int i10, String str) {
        this.f6222a = i10;
        this.f6223b = str;
    }

    public static EnumRechargeMode instance(int i10) {
        EnumRechargeMode[] values;
        for (EnumRechargeMode enumRechargeMode : values()) {
            if (enumRechargeMode.getId() == i10) {
                return enumRechargeMode;
            }
        }
        return null;
    }

    public String getDesc() {
        return this.f6223b;
    }

    public int getId() {
        return this.f6222a;
    }
}
