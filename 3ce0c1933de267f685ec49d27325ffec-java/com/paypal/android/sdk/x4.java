package com.paypal.android.sdk;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import com.paypal.android.sdk.payments.PayPalService;
/* loaded from: classes2.dex */
public class x4 {

    /* renamed from: a  reason: collision with root package name */
    private final Context f22066a;

    public x4(Context context) {
        this.f22066a = context;
    }

    private boolean b() {
        try {
            PackageManager packageManager = this.f22066a.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(this.f22066a.getPackageName(), 4);
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(this.f22066a.getPackageName(), 128);
            ServiceInfo[] serviceInfoArr = packageInfo.services;
            if (serviceInfoArr != null) {
                for (ServiceInfo serviceInfo : serviceInfoArr) {
                    if (serviceInfo.name.equals(PayPalService.class.getName())) {
                        this.f22066a.getPackageName();
                        String str = applicationInfo.processName;
                        if (!serviceInfo.exported && str.equals(serviceInfo.processName)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException e10) {
            throw new RuntimeException("Exception loading manifest" + e10.getMessage());
        }
    }

    public final void a() {
        if (!b()) {
            throw new RuntimeException("Please declare the following in your manifest, and ensure it runs in the same process as your application:<service android:name=\"com.paypal.android.sdk.payments.PayPalService\" android:exported=\"false\" />");
        }
    }
}
