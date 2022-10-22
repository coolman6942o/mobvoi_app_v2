package com.mobvoi.companion.account;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.mobvoi.android.common.utils.k;
import java.util.ArrayList;
import java.util.List;
import o.b;
/* compiled from: CustomTabs.java */
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static String f16131a;

    /* compiled from: CustomTabs.java */
    /* loaded from: classes2.dex */
    public interface a {
        void a(Activity activity, String str);
    }

    public static String a(Context context) {
        String str = f16131a;
        if (str != null) {
            return str;
        }
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://www.example.com"));
        ResolveInfo resolveActivity = packageManager.resolveActivity(intent, 0);
        String str2 = resolveActivity != null ? resolveActivity.activityInfo.packageName : null;
        List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 0);
        ArrayList arrayList = new ArrayList();
        for (ResolveInfo resolveInfo : queryIntentActivities) {
            Intent intent2 = new Intent();
            intent2.setAction("android.support.customtabs.action.CustomTabsService");
            intent2.setPackage(resolveInfo.activityInfo.packageName);
            if (packageManager.resolveService(intent2, 0) != null) {
                arrayList.add(resolveInfo.activityInfo.packageName);
            }
        }
        if (arrayList.isEmpty()) {
            f16131a = null;
        } else if (arrayList.size() == 1) {
            f16131a = (String) arrayList.get(0);
        } else if (!TextUtils.isEmpty(str2) && !b(context, intent) && arrayList.contains(str2)) {
            f16131a = str2;
        } else if (arrayList.contains("com.android.chrome")) {
            f16131a = "com.android.chrome";
        } else if (arrayList.contains("com.chrome.beta")) {
            f16131a = "com.chrome.beta";
        } else if (arrayList.contains("com.chrome.dev")) {
            f16131a = "com.chrome.dev";
        } else if (arrayList.contains("com.google.android.apps.chrome")) {
            f16131a = "com.google.android.apps.chrome";
        }
        return f16131a;
    }

    private static boolean b(Context context, Intent intent) {
        List<ResolveInfo> queryIntentActivities;
        try {
            queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 64);
        } catch (RuntimeException unused) {
            k.d("CustomTabs", "Runtime exception while getting specialized handlers");
        }
        if (queryIntentActivities.size() == 0) {
            return false;
        }
        for (ResolveInfo resolveInfo : queryIntentActivities) {
            IntentFilter intentFilter = resolveInfo.filter;
            if (!(intentFilter == null || intentFilter.countDataAuthorities() == 0 || intentFilter.countDataPaths() == 0 || resolveInfo.activityInfo == null)) {
                return true;
            }
        }
        return false;
    }

    public static void c(Activity activity, b bVar, String str, a aVar) {
        String a10 = a(activity);
        if (a10 != null) {
            bVar.f31349a.setPackage(a10);
            bVar.a(activity, Uri.parse(str));
        } else if (aVar != null) {
            aVar.a(activity, str);
        }
    }
}
