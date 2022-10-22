package com.huawei.hms.framework.network.grs.b;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.a.a;
import com.huawei.hms.framework.network.grs.c.c;
import java.util.Collections;
import java.util.Set;
/* loaded from: classes.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static final String f13850a = "f";

    /* renamed from: b  reason: collision with root package name */
    public static final Set<String> f13851b = Collections.unmodifiableSet(new e(16));

    public static String a(Context context, a aVar, String str, GrsBaseInfo grsBaseInfo, boolean z10) {
        if (TextUtils.isEmpty(str)) {
            Logger.w(f13850a, "routeBy must be not empty string or null.");
            return null;
        } else if (!"no_route".equals(str) && !"unconditional".equals(str)) {
            return b(context, aVar, str, grsBaseInfo, z10);
        } else {
            Logger.v(f13850a, "routeBy equals NO_ROUTE_POLICY");
            return "no_route_country";
        }
    }

    private static String b(Context context, a aVar, String str, GrsBaseInfo grsBaseInfo, boolean z10) {
        String[] split;
        String str2;
        StringBuilder sb2;
        String str3;
        String serCountry = grsBaseInfo.getSerCountry();
        String regCountry = grsBaseInfo.getRegCountry();
        String issueCountry = grsBaseInfo.getIssueCountry();
        for (String str4 : str.split(">")) {
            if (f13851b.contains(str4.trim())) {
                if ("ser_country".equals(str4.trim()) && !TextUtils.isEmpty(serCountry) && !GrsBaseInfo.CountryCodeSource.UNKNOWN.equals(serCountry)) {
                    str2 = f13850a;
                    sb2 = new StringBuilder();
                    str3 = "current route_by is serCountry and routerCountry is:";
                } else if ("reg_country".equals(str4.trim()) && !TextUtils.isEmpty(regCountry) && !GrsBaseInfo.CountryCodeSource.UNKNOWN.equals(regCountry)) {
                    Logger.i(f13850a, "current route_by is regCountry and routerCountry is:" + regCountry);
                    return regCountry;
                } else if ("issue_country".equals(str4.trim()) && !TextUtils.isEmpty(issueCountry) && !GrsBaseInfo.CountryCodeSource.UNKNOWN.equals(issueCountry)) {
                    Logger.i(f13850a, "current route_by is issueCountry and routerCountry is:" + issueCountry);
                    return issueCountry;
                } else if ("geo_ip".equals(str4.trim())) {
                    serCountry = new c(context, aVar, new com.huawei.hms.framework.network.grs.f()).a(z10);
                    str2 = f13850a;
                    sb2 = new StringBuilder();
                    str3 = "current route_by is geo_ip and routerCountry is: ";
                }
                sb2.append(str3);
                sb2.append(serCountry);
                Logger.i(str2, sb2.toString());
                return serCountry;
            }
        }
        return "";
    }
}
