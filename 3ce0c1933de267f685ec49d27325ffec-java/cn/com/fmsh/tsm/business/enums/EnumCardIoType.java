package cn.com.fmsh.tsm.business.enums;

import cn.com.fmsh.FM_Exception;
import x2.c;
import x2.h;
/* loaded from: classes.dex */
public enum EnumCardIoType {
    CARD_IO_UNKNOW(0, h.e("末瞭", 4, 103)),
    CARD_IO_TYPE_OUT(1, FM_Exception.insert(4, 40, "夞郸犴立卩ｘ桟卡ぉ归彺匡ａ")),
    CARD_IO_TYPE_IN(2, c.i("凎卢３@\u0002\u000e区影怊あ>\u0000N彡怚ｚ", 116, 24));
    

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ int f6210a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ String f6211b;

    /* synthetic */ EnumCardIoType(int i10, String str) {
        this.f6210a = i10;
        this.f6211b = str;
    }

    public static EnumCardIoType getCardIoType(int i10) {
        EnumCardIoType[] values;
        for (EnumCardIoType enumCardIoType : values()) {
            if (enumCardIoType.getId() == i10) {
                return enumCardIoType;
            }
        }
        return null;
    }

    public String getDesc() {
        return this.f6211b;
    }

    public int getId() {
        return this.f6210a;
    }
}
