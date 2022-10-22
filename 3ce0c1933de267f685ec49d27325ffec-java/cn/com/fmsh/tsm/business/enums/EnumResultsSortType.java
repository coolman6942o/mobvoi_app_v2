package cn.com.fmsh.tsm.business.enums;

import cn.com.fmsh.FM_Exception;
import x2.a;
/* loaded from: classes.dex */
public enum EnumResultsSortType {
    FORWARD(1, FM_Exception.insert(5, 67, "吘刁柪记＝匫尔仐袪枡该盎孚毥：v")),
    BACKWARD(2, a.b("呂吅枦诹｛卸奤仕袸枮诡盟孄毾＊", 3, 56));
    

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ int f6225a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ String f6226b;

    /* synthetic */ EnumResultsSortType(int i10, String str) {
        this.f6225a = i10;
        this.f6226b = str;
    }

    public static EnumResultsSortType instance(int i10) {
        EnumResultsSortType[] values;
        for (EnumResultsSortType enumResultsSortType : values()) {
            if (enumResultsSortType.getId() == i10) {
                return enumResultsSortType;
            }
        }
        return null;
    }

    public String getDesc() {
        return this.f6226b;
    }

    public int getId() {
        return this.f6225a;
    }
}
