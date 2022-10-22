package ud;

import android.app.Application;
import com.bjleisen.iface.sdk.bean.Applet;
import com.bjleisen.iface.sdk.enums.EnumCardAppStatus;
import com.mobvoi.android.common.json.JsonBean;
import qd.b;
import qd.m;
/* compiled from: BusCardItem.java */
/* loaded from: classes2.dex */
public class a extends b implements Comparable<a>, JsonBean {
    public final String appAid;
    public Applet applet;
    public int balance;
    public String cityLabel;
    public String expireDate;
    public int iconRes;

    /* renamed from: id  reason: collision with root package name */
    public String f35369id;
    public boolean isDefault;
    public final boolean isShanghai;
    public String name;
    public String openDate;
    public String ssdAid;
    public EnumCardAppStatus status;

    public a(String str) {
        this.appAid = str;
        this.isShanghai = "A00000000386980701".equalsIgnoreCase(str);
    }

    @Override // qd.b
    public String a() {
        return null;
    }

    @Override // qd.b
    public String b() {
        return this.name;
    }

    @Override // qd.b
    public String c() {
        return this.f35369id;
    }

    @Override // qd.b
    public boolean d() {
        return this.isDefault;
    }

    /* renamed from: e */
    public int compareTo(a aVar) {
        if (j() && !aVar.j()) {
            return -1;
        }
        if (!j() && aVar.j()) {
            return 1;
        }
        boolean z10 = this.isDefault;
        if (z10 && !aVar.isDefault) {
            return -1;
        }
        if (z10 || !aVar.isDefault) {
            return this.name.compareTo(aVar.name);
        }
        return 1;
    }

    public String f() {
        return this.appAid;
    }

    public String g() {
        Application e10 = com.mobvoi.android.common.utils.b.e();
        EnumCardAppStatus enumCardAppStatus = this.status;
        if (enumCardAppStatus == EnumCardAppStatus.CARD_STATUS_WALLET_ERROR) {
            return e10.getString(m.B);
        }
        if (enumCardAppStatus == EnumCardAppStatus.CARD_STATUS_BLACKLIST) {
            return e10.getString(m.f33101v);
        }
        if (enumCardAppStatus == EnumCardAppStatus.CARD_STATUS_DISABLE) {
            return e10.getString(m.f33103w);
        }
        if (enumCardAppStatus == EnumCardAppStatus.CARD_STATUS_UNENABLED_DATE) {
            return e10.getString(m.A);
        }
        if (enumCardAppStatus == EnumCardAppStatus.CARD_STATUS_OUT_DATE) {
            return e10.getString(m.f33107y);
        }
        if (enumCardAppStatus == EnumCardAppStatus.CARD_STATUS_INVALID_DATE) {
            return e10.getString(m.f33105x);
        }
        return e10.getString(m.S0);
    }

    public String h() {
        String str;
        String str2 = this.appAid;
        str2.hashCode();
        char c10 = 65535;
        switch (str2.hashCode()) {
            case -1902101501:
                if (str2.equals("A0000006320101050113581058000000")) {
                    c10 = 0;
                    break;
                }
                break;
            case -1716420643:
                if (str2.equals("D156000015CCECB8AECDA8BFA8")) {
                    c10 = 1;
                    break;
                }
                break;
            case 295611974:
                if (str2.equals("A00000063201010510009156000014A1")) {
                    c10 = 2;
                    break;
                }
                break;
            case 962774391:
                if (str2.equals("A00000000386980701")) {
                    c10 = 3;
                    break;
                }
                break;
            case 1147544287:
                if (str2.equals("535A542E57414C4C45542E454E56")) {
                    c10 = 4;
                    break;
                }
                break;
            case 1538063549:
                if (str2.equals("D1560001360103000057485401000001")) {
                    c10 = 5;
                    break;
                }
                break;
            case 1801564062:
                if (str2.equals("9156000014010001")) {
                    c10 = 6;
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
                str = "yangcheng";
                break;
            case 1:
                str = "chengdu";
                break;
            case 2:
                str = "beijinghutong";
                break;
            case 3:
                str = "shanghai";
                break;
            case 4:
                str = "shenzhen";
                break;
            case 5:
                str = "wuhan";
                break;
            case 6:
                str = "beijing";
                break;
            default:
                str = "";
                break;
        }
        return "https://activities.mobvoi.com/ticwatch-help2/page/ticpay-user-agreement.html?city=" + str;
    }

    public boolean i() {
        Applet applet = this.applet;
        return applet != null && applet.getDownType() == 1;
    }

    public boolean j() {
        return this.status == EnumCardAppStatus.CARD_STATUS_OK;
    }

    public void k() {
        Applet applet = this.applet;
        if (applet != null) {
            applet.setDownType(0);
        }
        this.balance = 0;
        this.isDefault = false;
        this.f35369id = null;
        this.status = EnumCardAppStatus.CARD_STATUS_APPLET_NO_EXIST;
    }
}
