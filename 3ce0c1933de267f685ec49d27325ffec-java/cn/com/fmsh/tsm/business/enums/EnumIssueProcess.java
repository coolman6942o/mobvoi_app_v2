package cn.com.fmsh.tsm.business.enums;

import cn.com.fmsh.FM_Exception;
import x2.a;
import x2.b;
import x2.f;
import x2.g;
import x2.h;
/* loaded from: classes.dex */
public enum EnumIssueProcess {
    APPLIED(0, FM_Exception.insert(6, 12, "敺捸巰甽语")),
    SSD_KEY_UPDATED(10, g.a(5, 59, "\u0006C\u000f寀铤差暣斢")),
    APP_LOAD(20, b.b(4, "庅甴巵劲轠")),
    APP_INSTALL(30, f.a("廞畯嶶寈袛", 98)),
    APP_PERSONAL(40, h.e("废畱嶵乿仹匇", 142, 110)),
    APP_ACTIVATION(50, a.b("廇畣嶱澛浨", 3, 120)),
    APP_LOCK(60, g.a(294, 58, "庂畸巸镅寄")),
    APP_REMOVE(70, FM_Exception.insert(184, 24, "庈畼嶾判陸"));
    

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ int f6213a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ String f6214b;

    /* synthetic */ EnumIssueProcess(int i10, String str) {
        this.f6213a = i10;
        this.f6214b = str;
    }

    public static EnumIssueProcess instance(int i10) {
        EnumIssueProcess[] values;
        for (EnumIssueProcess enumIssueProcess : values()) {
            if (enumIssueProcess.getId() == i10) {
                return enumIssueProcess;
            }
        }
        return null;
    }

    public String getDesc() {
        return this.f6214b;
    }

    public int getId() {
        return this.f6213a;
    }
}
