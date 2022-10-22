package com.paypal.android.sdk;

import android.content.Context;
import android.content.pm.PackageManager;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes2.dex */
public class w4 {

    /* renamed from: b  reason: collision with root package name */
    private static final List f22049b = Arrays.asList("android.permission.ACCESS_NETWORK_STATE", "android.permission.INTERNET");

    /* renamed from: a  reason: collision with root package name */
    private final Context f22050a;

    public w4(Context context) {
        this.f22050a = context;
    }

    public final void a() {
        try {
            HashSet hashSet = new HashSet(f22049b);
            String[] strArr = this.f22050a.getPackageManager().getPackageInfo(this.f22050a.getPackageName(), 4096).requestedPermissions;
            if (strArr != null) {
                for (String str : strArr) {
                    hashSet.remove(str);
                }
            }
            if (!hashSet.isEmpty()) {
                throw new RuntimeException("Missing required permissions in manifest:" + hashSet);
            }
        } catch (PackageManager.NameNotFoundException e10) {
            throw new RuntimeException("Exception loading manifest" + e10.getMessage());
        }
    }
}
