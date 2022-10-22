package com.paypal.android.sdk;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import java.util.Collection;
import java.util.HashSet;
/* loaded from: classes2.dex */
public final class v4 {

    /* renamed from: a  reason: collision with root package name */
    private final Context f22038a;

    public v4(Context context) {
        this.f22038a = context;
    }

    public final void a(Collection collection) {
        try {
            HashSet hashSet = new HashSet(collection);
            ActivityInfo[] activityInfoArr = this.f22038a.getPackageManager().getPackageInfo(this.f22038a.getPackageName(), 1).activities;
            if (activityInfoArr != null) {
                for (ActivityInfo activityInfo : activityInfoArr) {
                    hashSet.remove(activityInfo.name);
                }
            }
            if (!hashSet.isEmpty()) {
                throw new RuntimeException("Missing required activities in manifest:" + hashSet);
            }
        } catch (PackageManager.NameNotFoundException e10) {
            throw new RuntimeException("Exception loading manifest" + e10.getMessage());
        }
    }
}
