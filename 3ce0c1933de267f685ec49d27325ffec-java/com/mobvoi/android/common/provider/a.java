package com.mobvoi.android.common.provider;

import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.mobvoi.android.common.utils.b;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.wear.contacts.ContactConstant;
import com.mobvoi.wear.permission.PermissionConstant;
import com.mobvoi.wear.providers.HealthDataProviderContracts;
/* compiled from: InfoProviderClient.java */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private ContentResolver f15282a;

    /* renamed from: b  reason: collision with root package name */
    private String f15283b;

    public a(Context context, String str) {
        this.f15282a = context.getApplicationContext().getContentResolver();
        this.f15283b = str;
    }

    private boolean h(Uri uri) {
        Application e10 = b.e();
        return (e10 == null || e10.getPackageManager().resolveContentProvider(uri.getAuthority(), 0) == null) ? false : true;
    }

    public boolean a(String str, String str2, boolean z10) {
        String f10 = f(str, str2, null);
        return !TextUtils.isEmpty(f10) ? Boolean.parseBoolean(f10) : z10;
    }

    public double b(String str, String str2, double d10) {
        try {
            String f10 = f(str, str2, null);
            if (!TextUtils.isEmpty(f10)) {
                return Double.parseDouble(f10);
            }
        } catch (NumberFormatException e10) {
            k.r("InfoProviderClient", "Failed to get double value for [%s] in table [%s]", e10, str2, str);
        }
        return d10;
    }

    public float c(String str, String str2, float f10) {
        try {
            String f11 = f(str, str2, null);
            if (!TextUtils.isEmpty(f11)) {
                return Float.parseFloat(f11);
            }
        } catch (NumberFormatException e10) {
            k.r("InfoProviderClient", "Failed to get double value for [%s] in table [%s]", e10, str2, str);
        }
        return f10;
    }

    public int d(String str, String str2, int i10) {
        try {
            String f10 = f(str, str2, null);
            if (!TextUtils.isEmpty(f10)) {
                return Integer.parseInt(f10);
            }
        } catch (NumberFormatException e10) {
            k.r("InfoProviderClient", "Failed to get int value for [%s] in table [%s]", e10, str2, str);
        }
        return i10;
    }

    public long e(String str, String str2, long j10) {
        try {
            String f10 = f(str, str2, null);
            if (!TextUtils.isEmpty(f10)) {
                return Long.parseLong(f10);
            }
        } catch (NumberFormatException e10) {
            k.r("InfoProviderClient", "Failed to get long value for [%s] in table [%s]", e10, str2, str);
        }
        return j10;
    }

    public String f(String str, String str2, String str3) {
        try {
            Uri g10 = g(str, str2);
            Bundle bundle = new Bundle();
            bundle.putString("table", str);
            bundle.putString(ContactConstant.CallsRecordKeys.NAME, str2);
            Bundle call = this.f15282a.call(g10, "get", (String) null, bundle);
            if (call == null) {
                k.f("InfoProviderClient", "Cannot call method [%s]", "get");
                return str3;
            }
            String string = call.getString(HealthDataProviderContracts.NAME_VALUE);
            return string == null ? str3 : string;
        } catch (SecurityException e10) {
            throw e10;
        } catch (Exception e11) {
            k.r("InfoProviderClient", "Failed to get value for [%s] in table [%s]", e11, str2, str);
            return str3;
        }
    }

    public Uri g(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            str = "default";
        }
        return new Uri.Builder().scheme("content").authority(this.f15283b).appendPath(str).appendPath(str2).build();
    }

    public boolean i(String str, String str2, boolean z10) {
        return n(str, str2, Boolean.toString(z10));
    }

    public boolean j(String str, String str2, double d10) {
        return n(str, str2, Double.toString(d10));
    }

    public boolean k(String str, String str2, float f10) {
        return n(str, str2, Float.toString(f10));
    }

    public boolean l(String str, String str2, int i10) {
        return n(str, str2, Integer.toString(i10));
    }

    public boolean m(String str, String str2, long j10) {
        return n(str, str2, Long.toString(j10));
    }

    public boolean n(String str, String str2, String str3) {
        try {
            Uri g10 = g(str, str2);
            Bundle bundle = new Bundle();
            bundle.putString("table", str);
            bundle.putString(ContactConstant.CallsRecordKeys.NAME, str2);
            bundle.putString(HealthDataProviderContracts.NAME_VALUE, str3);
            Bundle call = this.f15282a.call(g10, "put", (String) null, bundle);
            if (call == null) {
                k.f("InfoProviderClient", "Cannot call method [%s] for name [%s]", "put", str2);
                return false;
            }
            boolean z10 = call.getBoolean(PermissionConstant.Columns.STATUS);
            String string = call.getString(HealthDataProviderContracts.NAME_VALUE);
            if (z10 && !TextUtils.equals(string, str3)) {
                this.f15282a.notifyChange(g10, null);
            }
            return z10;
        } catch (SecurityException e10) {
            throw e10;
        } catch (Exception e11) {
            k.r("InfoProviderClient", "Failed to put value for [%s] in table [%s]", e11, str2, str);
            return false;
        }
    }

    public void o(Uri uri, ContentObserver contentObserver) {
        this.f15282a.registerContentObserver(uri, true, contentObserver);
    }

    public void p(String str, String str2, ContentObserver contentObserver) {
        Uri g10 = g(str, str2);
        if (h(g10)) {
            this.f15282a.registerContentObserver(g10, true, contentObserver);
        }
    }

    public boolean q(String str, String str2) {
        try {
            Uri g10 = g(str, str2);
            Bundle bundle = new Bundle();
            bundle.putString("table", str);
            bundle.putString(ContactConstant.CallsRecordKeys.NAME, str2);
            Bundle call = this.f15282a.call(g10, "remove", (String) null, bundle);
            if (call == null) {
                k.f("InfoProviderClient", "Cannot call method [%s]", "remove");
                return false;
            }
            boolean z10 = call.getBoolean(PermissionConstant.Columns.STATUS);
            String string = call.getString(HealthDataProviderContracts.NAME_VALUE);
            if (z10 && !TextUtils.isEmpty(string)) {
                this.f15282a.notifyChange(g10, null);
            }
            return z10;
        } catch (SecurityException e10) {
            throw e10;
        } catch (Exception e11) {
            k.r("InfoProviderClient", "Failed to remove [%s] in table [%s]", e11, str2, str);
            return false;
        }
    }

    public void r(ContentObserver contentObserver) {
        this.f15282a.unregisterContentObserver(contentObserver);
    }
}
