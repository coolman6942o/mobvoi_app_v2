package cn.com.fmsh.tsm.business.enums;

import x2.b;
import x2.c;
import x2.d;
import x2.e;
import x2.g;
/* loaded from: classes.dex */
public enum EnumAppActivationStatus {
    noActivity(0, c.i("杶彟逘", 5, 3)),
    activiting(1, d.c("彙遐丶", 230)),
    activitySucess(2, e.a(4, "彙遆扏劝")),
    activityFail(3, d.c("彑遘奢赡", 254)),
    closeing(4, d.c("儥閪乵", 3)),
    closeSucess(5, g.a(3, 59, "儠闣扙力")),
    closeFail(6, b.b(2, "兼闷头贵"));
    

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ int f6183a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ String f6184b;

    /* synthetic */ EnumAppActivationStatus(int i10, String str) {
        this.f6183a = i10;
        this.f6184b = str;
    }

    public static EnumAppActivationStatus getActivationStatus4ID(int i10) {
        EnumAppActivationStatus[] values;
        for (EnumAppActivationStatus enumAppActivationStatus : values()) {
            if (enumAppActivationStatus.getId() == i10) {
                return enumAppActivationStatus;
            }
        }
        return null;
    }

    public String getDesc() {
        return this.f6184b;
    }

    public int getId() {
        return this.f6183a;
    }
}
