package com.paypal.android.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.mobvoi.wear.info.SharedWearInfoHelper;
import java.util.Objects;
import java.util.UUID;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private final Context f20965a;

    /* renamed from: b  reason: collision with root package name */
    private final String f20966b;

    /* renamed from: c  reason: collision with root package name */
    private final y0 f20967c;

    public a(Context context, String str, y1 y1Var) {
        Objects.requireNonNull(context, "context == null");
        Objects.requireNonNull(str, "prefs == null");
        this.f20965a = context;
        this.f20966b = str;
        this.f20967c = y1Var.a(this);
    }

    public final String a(String str) {
        return this.f20967c.b(this.f20965a.getSharedPreferences(this.f20966b, 0).getString(str, null));
    }

    public final void b(String str, String str2) {
        SharedPreferences.Editor edit = this.f20965a.getSharedPreferences(this.f20966b, 0).edit();
        edit.putString(str, this.f20967c.a(str2));
        edit.commit();
    }

    public final boolean c() {
        String str;
        ConnectivityManager connectivityManager = (ConnectivityManager) this.f20965a.getSystemService("connectivity");
        if (connectivityManager == null) {
            str = "Unable to retrieve Context.CONNECTIVITY_SERVICE. Ignoring.";
        } else if (connectivityManager.getAllNetworkInfo() == null) {
            str = "ConnectivityManager.getAllNetworkInfo() returned null. Ignoring.";
        } else {
            int i10 = 0;
            for (NetworkInfo networkInfo : connectivityManager.getAllNetworkInfo()) {
                if (networkInfo.isConnectedOrConnecting()) {
                    i10++;
                }
            }
            return i10 > 0;
        }
        Log.w("paypal.sdk", str);
        return true;
    }

    public final int d() {
        return ((TelephonyManager) this.f20965a.getSystemService(SharedWearInfoHelper.PhoneInfo.TABLE)).getPhoneType();
    }

    public final String e(String str) {
        return this.f20967c.a(str);
    }

    public final String f() {
        try {
            PackageManager packageManager = this.f20965a.getPackageManager();
            return packageManager.getPackageInfo(this.f20965a.getPackageName(), 0).applicationInfo.loadLabel(packageManager).toString();
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public final String g(String str) {
        return this.f20967c.b(str);
    }

    public final String h() {
        try {
            return ((TelephonyManager) this.f20965a.getSystemService(SharedWearInfoHelper.PhoneInfo.TABLE)).getSimOperatorName();
        } catch (SecurityException e10) {
            e10.toString();
            return null;
        }
    }

    public final String i() {
        String string = this.f20965a.getSharedPreferences(this.f20966b, 0).getString("InstallationGUID", null);
        if (string != null) {
            return string;
        }
        String uuid = UUID.randomUUID().toString();
        SharedPreferences.Editor edit = this.f20965a.getSharedPreferences(this.f20966b, 0).edit();
        edit.putString("InstallationGUID", uuid);
        edit.commit();
        return uuid;
    }

    public final Context j() {
        return this.f20965a;
    }
}
