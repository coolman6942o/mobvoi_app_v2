package com.huawei.hms.scankit.p;

import android.content.Context;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsApp;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import java.util.Locale;
/* compiled from: CountryCodeBean.java */
/* loaded from: classes2.dex */
public class La {

    /* renamed from: a  reason: collision with root package name */
    private static final String f14585a = "La";

    /* renamed from: b  reason: collision with root package name */
    private String f14586b = GrsBaseInfo.CountryCodeSource.UNKNOWN;

    /* renamed from: c  reason: collision with root package name */
    private String f14587c;

    public La(Context context, boolean z10) {
        this.f14587c = GrsBaseInfo.CountryCodeSource.UNKNOWN;
        a(context, z10);
        this.f14587c = this.f14587c.toUpperCase(Locale.ENGLISH);
    }

    private boolean b() {
        return !GrsBaseInfo.CountryCodeSource.UNKNOWN.equals(this.f14587c);
    }

    public String a() {
        return this.f14587c;
    }

    private void a(Context context, boolean z10) {
        if (context != null) {
            try {
                this.f14587c = GrsApp.getInstance().getIssueCountryCode(context);
                if (b()) {
                    Logger.i(f14585a, "getCountryCode unknown");
                }
            } catch (NullPointerException unused) {
                Logger.w(f14585a, "get CountryCode error");
            } catch (Exception unused2) {
                Logger.w(f14585a, "get CountryCode error");
            }
        }
    }
}
