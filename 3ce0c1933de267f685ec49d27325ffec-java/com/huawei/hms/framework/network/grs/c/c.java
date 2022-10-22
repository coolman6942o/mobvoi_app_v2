package com.huawei.hms.framework.network.grs.c;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.a.a;
import com.huawei.hms.framework.network.grs.b;
import com.huawei.hms.framework.network.grs.d.e;
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private Context f13877a;

    /* renamed from: b  reason: collision with root package name */
    private GrsBaseInfo f13878b;

    /* renamed from: c  reason: collision with root package name */
    private a f13879c;

    public c(Context context, a aVar, GrsBaseInfo grsBaseInfo) {
        this.f13877a = context;
        this.f13878b = grsBaseInfo;
        this.f13879c = aVar;
    }

    public String a(boolean z10) {
        String a10 = com.huawei.hms.framework.network.grs.a.a(this.f13879c.a().a("geoipCountryCode", ""), "geoip.countrycode", "ROOT");
        Logger.i("GeoipCountry", "geoIpCountry is: " + a10);
        String a11 = this.f13879c.a().a("geoipCountryCodetime", "0");
        long j10 = 0;
        if (!TextUtils.isEmpty(a11) && a11.matches("\\d+")) {
            try {
                j10 = Long.parseLong(a11);
            } catch (NumberFormatException e10) {
                Logger.w("GeoipCountry", "convert urlParamKey from String to Long catch NumberFormatException.", e10);
            }
        }
        if (TextUtils.isEmpty(a10) || e.a(Long.valueOf(j10))) {
            com.huawei.hms.framework.network.grs.c.b.c cVar = new com.huawei.hms.framework.network.grs.c.b.c(this.f13878b, this.f13877a);
            cVar.a("geoip.countrycode");
            if (z10) {
                f a12 = this.f13879c.b().a(cVar, "geoip.countrycode");
                if (a12 != null) {
                    a10 = com.huawei.hms.framework.network.grs.a.a(a12.i(), "geoip.countrycode", "ROOT");
                }
                Logger.i("GeoipCountry", "sync request to query geoip.countrycode is:" + a10);
            } else {
                Logger.i("GeoipCountry", "async request to query geoip.countrycode");
                this.f13879c.b().a(cVar, (b) null, "geoip.countrycode");
            }
        }
        return a10;
    }
}
