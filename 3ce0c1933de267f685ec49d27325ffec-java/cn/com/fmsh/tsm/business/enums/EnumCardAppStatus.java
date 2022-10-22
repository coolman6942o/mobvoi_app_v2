package cn.com.fmsh.tsm.business.enums;

import cn.com.fmsh.FM_Exception;
import x2.a;
import x2.b;
import x2.c;
import x2.e;
/* loaded from: classes.dex */
public enum EnumCardAppStatus {
    STATUS_NO_APP(1, c.i("廍电杫富裌", 2, 36)),
    STATUS_LOADED(2, e.a(4, "厶戻蠓裇轸斏份B^US_Y")),
    STATUS_INSTALL(3, e.a(5, "乐洪交這卧庝甤宆裗")),
    STATUS_PERSONALIZED(4, b.b(1, "丄浮亠逕卻乯仪卍")),
    STATUS_ACTIVATE(5, a.b("乞浣亰過匵弔逎", 4, 32)),
    STATUS_UNKNOW(10, FM_Exception.insert(5, 114, "朣瞾狻恞"));
    

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ int f6201a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ String f6202b;

    /* synthetic */ EnumCardAppStatus(int i10, String str) {
        this.f6201a = i10;
        this.f6202b = str;
    }

    public static EnumCardAppStatus instance(int i10) {
        EnumCardAppStatus[] values;
        for (EnumCardAppStatus enumCardAppStatus : values()) {
            if (enumCardAppStatus.getId() == i10) {
                return enumCardAppStatus;
            }
        }
        return null;
    }

    public String getDesc() {
        return this.f6202b;
    }

    public int getId() {
        return this.f6201a;
    }
}
