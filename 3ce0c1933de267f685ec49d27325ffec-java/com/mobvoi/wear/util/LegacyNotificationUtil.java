package com.mobvoi.wear.util;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.core.app.k;
import androidx.core.app.p;
import java.util.Locale;
/* loaded from: classes2.dex */
public class LegacyNotificationUtil {
    public static void addRemoteInputResultsToIntentForGmail(Intent intent, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj instanceof CharSequence) {
                bundle2.putString(str, obj.toString());
            }
        }
        intent.setClipData(ClipData.newIntent("com.google.android.wearable.extras", new Intent().putExtras(bundle2)));
    }

    private static Bundle[] getBundleArrayFromBundle(Bundle bundle, String str) {
        Parcelable[] parcelableArray = bundle.getParcelableArray(str);
        if ((parcelableArray instanceof Bundle[]) || parcelableArray == null) {
            return (Bundle[]) parcelableArray;
        }
        int length = parcelableArray.length;
        Bundle[] bundleArr = new Bundle[length];
        for (int i10 = 0; i10 < length; i10++) {
            bundleArr[i10] = (Bundle) parcelableArray[i10];
        }
        return bundleArr;
    }

    public static String getGroup(Notification notification) {
        String c10 = k.c(notification);
        if (c10 != null) {
            return c10;
        }
        Bundle b10 = k.b(notification);
        if (b10 != null) {
            return b10.getString("android.support.wearable.groupKey");
        }
        return null;
    }

    public static Drawable getIconWithPackageName(Context context, String str, int i10, boolean z10) {
        if (!z10) {
            try {
                context = context.createPackageContext(str, 2);
            } catch (PackageManager.NameNotFoundException unused) {
                context = null;
            }
        }
        if (context != null) {
            try {
                return context.getResources().getDrawable(i10);
            } catch (Resources.NotFoundException unused2) {
            }
        }
        return null;
    }

    public static String getSortKey(Notification notification) {
        int i10;
        String f10 = k.f(notification);
        if (f10 != null) {
            return f10;
        }
        Bundle b10 = k.b(notification);
        if (b10 == null || b10.getString("android.support.wearable.groupKey") == null || (i10 = b10.getInt("android.support.wearable.groupOrder")) == -1) {
            return null;
        }
        return getSortKeyForLegacyOrder(i10);
    }

    private static String getSortKeyForLegacyOrder(int i10) {
        return String.format(Locale.US, "%010d", Long.valueOf(i10 + 2147483648L));
    }

    public static k.f getWearableOptions(Notification notification) {
        Parcelable[] parcelableArray;
        k.f fVar = new k.f(notification);
        Bundle b10 = k.b(notification);
        if (!(b10 == null || (parcelableArray = b10.getParcelableArray("android.support.wearable.actions")) == null || parcelableArray.length <= 0)) {
            fVar.b();
            for (Parcelable parcelable : parcelableArray) {
                fVar.a(parseLegacyWearableAction((Bundle) parcelable));
            }
        }
        return fVar;
    }

    public static boolean isGroupSummary(Notification notification) {
        if (k.g(notification)) {
            return true;
        }
        Bundle b10 = k.b(notification);
        return (b10 == null || b10.getString("android.support.wearable.groupKey") == null || b10.getInt("android.support.wearable.groupOrder") != -1) ? false : true;
    }

    public static boolean isLegacyGmailNotification(String str, Notification notification) {
        Bundle b10;
        return "com.google.android.gm".equals(str) && (b10 = k.b(notification)) != null && b10.containsKey("android.support.wearable.groupOrder");
    }

    public static boolean isLegacyGmailUndoNotification(String str, Notification notification) {
        if ("com.google.android.gm".equals(str) && !k.d(notification)) {
            Bundle b10 = k.b(notification);
            if (b10.getCharSequence("android.title") == null && b10.getCharSequence("android.text") == null) {
                return true;
            }
        }
        return false;
    }

    private static p parseLegacyRemoteInputBundle(Bundle bundle) {
        return new p.a(bundle.getString("return_key")).d(bundle.getString("label")).c(bundle.getStringArray("choices")).b(bundle.getBoolean("allowFreeFormInput")).a();
    }

    private static p[] parseLegacyRemoteInputBundles(Bundle[] bundleArr) {
        if (bundleArr == null) {
            return null;
        }
        p[] pVarArr = new p[bundleArr.length];
        for (int i10 = 0; i10 < bundleArr.length; i10++) {
            pVarArr[i10] = parseLegacyRemoteInputBundle(bundleArr[i10]);
        }
        return pVarArr;
    }

    private static k.a parseLegacyWearableAction(Bundle bundle) {
        Bundle bundle2 = (Bundle) bundle.getParcelable("extras");
        k.a.C0017a aVar = new k.a.C0017a(bundle.getInt("icon"), bundle.getCharSequence("title"), (PendingIntent) bundle.getParcelable("action_intent"));
        if (bundle2 != null) {
            aVar.a(bundle2);
            p[] parseLegacyRemoteInputBundles = parseLegacyRemoteInputBundles(getBundleArrayFromBundle(bundle2, "android.support.wearable.remoteInputs"));
            if (parseLegacyRemoteInputBundles != null) {
                for (p pVar : parseLegacyRemoteInputBundles) {
                    aVar.b(pVar);
                }
            }
        }
        return aVar.c();
    }
}
