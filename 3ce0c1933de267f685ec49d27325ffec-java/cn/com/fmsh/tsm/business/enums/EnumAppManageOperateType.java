package cn.com.fmsh.tsm.business.enums;

import cn.com.fmsh.FM_Exception;
import x2.a;
import x2.b;
import x2.e;
import x2.f;
import x2.g;
/* loaded from: classes.dex */
public enum EnumAppManageOperateType {
    APP_LOCK(1, e.a(2, "匶乐廉用兰闫")),
    APP_UNLOCK(2, f.a("卭七庒甫开呲", 132)),
    APP_STATUS_QUERY(3, a.b("匲乐底甠彜剛犫怅柮诰", 3, 7)),
    APP_DELETE(4, b.b(2, "卮丐庑甸刻阢")),
    APP_MOVE(5, g.a(62, 30, "卯乆廞甠过冾")),
    APP_DOWNLOAD(6, FM_Exception.insert(44, 118, "危丌庈町刨阺"));
    

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ int f6186a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ String f6187b;

    /* synthetic */ EnumAppManageOperateType(int i10, String str) {
        this.f6186a = i10;
        this.f6187b = str;
    }

    public static EnumAppManageOperateType instance(int i10) {
        EnumAppManageOperateType[] values;
        for (EnumAppManageOperateType enumAppManageOperateType : values()) {
            if (enumAppManageOperateType.getId() == i10) {
                return enumAppManageOperateType;
            }
        }
        return null;
    }

    public String getDesc() {
        return this.f6187b;
    }

    public int getId() {
        return this.f6186a;
    }
}
