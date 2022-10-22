package com.huawei.hms.scankit.p;

import android.text.TextUtils;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.scankit.F;
import com.huawei.hms.scankit.aiscan.common.x;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* compiled from: WifiResultParser.java */
/* renamed from: com.huawei.hms.scankit.p.vb  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0636vb extends AbstractC0619pb {

    /* renamed from: g  reason: collision with root package name */
    private static final Pattern f14992g = Pattern.compile("WIFI:[^:]", 2);

    private static int c(String str) {
        if (str == null) {
            return 0;
        }
        if (str.equalsIgnoreCase("WEP")) {
            return 2;
        }
        if ((str.equalsIgnoreCase("WPA") | str.equalsIgnoreCase("WPA2") | str.equalsIgnoreCase("WPA/WPA2")) || str.equalsIgnoreCase("WPA2/WPA")) {
            return 1;
        }
        return str.equalsIgnoreCase("SAE") ? 3 : 0;
    }

    @Override // com.huawei.hms.scankit.p.AbstractC0619pb
    public HmsScan b(x xVar) {
        String str;
        String a10 = AbstractC0619pb.a(xVar);
        if (TextUtils.isEmpty(a10)) {
            return null;
        }
        Matcher matcher = f14992g.matcher(a10);
        if (matcher.find() && matcher.start() == 0) {
            String substring = a10.substring(5);
            if (!substring.endsWith(";")) {
                substring = substring + ";";
            }
            String b10 = AbstractC0619pb.b("S:", substring, ';', false);
            if (b10 != null && !b10.isEmpty()) {
                String b11 = AbstractC0619pb.b("P:", substring, ';', false);
                String b12 = AbstractC0619pb.b("T:", substring, ';', false);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(b10);
                if (b11 == null || b11.isEmpty()) {
                    str = "";
                } else {
                    str = " " + b11;
                }
                sb2.append(str);
                return new HmsScan(xVar.g(), AbstractC0619pb.a(xVar.b()), sb2.toString(), HmsScan.WIFI_CONNECT_INFO_FORM, xVar.e(), AbstractC0619pb.a(xVar.f()), null, new F(new HmsScan.WiFiConnectionInfo(b10, b11, c(b12))));
            }
        }
        return null;
    }
}
