package com.huawei.hms.scankit.p;

import android.text.TextUtils;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.scankit.F;
import com.huawei.hms.scankit.aiscan.common.x;
import java.util.List;
/* compiled from: DriverInfoResultParser.java */
/* renamed from: com.huawei.hms.scankit.p.hb  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C0593hb extends AbstractC0619pb {

    /* renamed from: g  reason: collision with root package name */
    private static final List<String> f14809g = new C0589gb();

    /* renamed from: h  reason: collision with root package name */
    private String f14810h = "";

    public HmsScan.DriverInfo a(String[] strArr, String str) {
        String[] strArr2 = {"", "", "", "", "", "", "", "", "", "", "", "", "", ""};
        strArr2[0] = str;
        boolean z10 = false;
        for (String str2 : strArr) {
            if (str2.length() <= 3) {
                return null;
            }
            int indexOf = f14809g.indexOf(str2.substring(0, 3));
            if (indexOf != -1) {
                strArr2[indexOf] = str2.substring(3).trim();
                z10 = true;
            }
        }
        if (!z10) {
            return null;
        }
        this.f14810h = strArr2[0] + " " + strArr2[3] + " " + strArr2[1];
        return new HmsScan.DriverInfo(strArr2[0], strArr2[1], strArr2[2], strArr2[3], strArr2[4], strArr2[5], strArr2[6], strArr2[7], strArr2[8], strArr2[9], strArr2[10], strArr2[11], strArr2[12], strArr2[13], null, null, null, null);
    }

    @Override // com.huawei.hms.scankit.p.AbstractC0619pb
    public HmsScan b(x xVar) {
        String a10 = AbstractC0619pb.a(xVar);
        if (!TextUtils.isEmpty(a10) && a10.startsWith("@") && a10.length() > 34 && a10.substring(4, 8).equals("ANSI")) {
            String valueOf = String.valueOf(a10.charAt(1));
            String valueOf2 = String.valueOf(a10.charAt(3));
            String substring = a10.substring(21, 23);
            HmsScan.DriverInfo a11 = a(a10.substring(a10.indexOf(substring, 23) + 2).split(valueOf2)[0].split(valueOf), substring);
            if (a11 != null) {
                return new HmsScan(xVar.g(), AbstractC0619pb.a(xVar.b()), this.f14810h, HmsScan.DRIVER_INFO_FORM, xVar.e(), AbstractC0619pb.a(xVar.f()), null, new F(a11));
            }
        }
        return null;
    }
}
