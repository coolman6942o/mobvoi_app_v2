package cn.com.fmsh.tsm.business.enums;

import androidx.recyclerview.widget.g;
import cn.com.fmsh.FM_Exception;
import x2.a;
/* loaded from: classes.dex */
public enum EnumOrderType {
    MAIN(1, FM_Exception.insert(6, 22, "丱订千")),
    BUSINESS(2, FM_Exception.insert(2, 96, "东勧诤卓")),
    PAY(3, a.b("敥从诠匛", g.f.DEFAULT_SWIPE_ANIMATION_DURATION, 44));
    

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ int f6219a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ String f6220b;

    /* synthetic */ EnumOrderType(int i10, String str) {
        this.f6219a = i10;
        this.f6220b = str;
    }

    public static EnumOrderType instance(int i10) {
        EnumOrderType[] values;
        for (EnumOrderType enumOrderType : values()) {
            if (enumOrderType.getId() == i10) {
                return enumOrderType;
            }
        }
        return null;
    }

    public String getDesc() {
        return this.f6220b;
    }

    public int getId() {
        return this.f6219a;
    }
}
