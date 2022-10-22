package com.mobvoi.companion.aw.base;

import android.content.Context;
import android.content.pm.PackageManager;
import com.mobvoi.android.common.utils.b;
import com.mobvoi.companion.base.settings.a;
import com.mobvoi.wear.common.base.Constants;
import ra.g;
/* compiled from: AppConfig.java */
/* loaded from: classes2.dex */
public class d {
    public static g a(Context context) {
        g gVar = new g();
        try {
            String packageName = context.getPackageName();
            String str = context.getPackageManager().getPackageInfo(packageName, 0).versionName;
            int i10 = context.getPackageManager().getPackageInfo(packageName, 0).versionCode;
            gVar.b(packageName);
            gVar.d("ticwatch");
            gVar.c(a.isOversea() ? "i18n" : Constants.Setting.CHINA_REGION);
            gVar.e(String.valueOf(i10));
            gVar.f(str);
            return gVar;
        } catch (PackageManager.NameNotFoundException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public static String b(Context context) {
        return b.j().getAbsolutePath();
    }
}
