package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.flags.d;
import com.google.android.gms.flags.impl.a;
import k6.b;
@DynamiteApi
/* loaded from: classes.dex */
public class FlagProviderImpl extends d.a {

    /* renamed from: a  reason: collision with root package name */
    private boolean f9064a = false;

    /* renamed from: b  reason: collision with root package name */
    private SharedPreferences f9065b;

    @Override // com.google.android.gms.flags.d
    public boolean getBooleanFlagValue(String str, boolean z10, int i10) {
        return !this.f9064a ? z10 : a.C0113a.a(this.f9065b, str, Boolean.valueOf(z10)).booleanValue();
    }

    @Override // com.google.android.gms.flags.d
    public int getIntFlagValue(String str, int i10, int i11) {
        return !this.f9064a ? i10 : a.b.a(this.f9065b, str, Integer.valueOf(i10)).intValue();
    }

    @Override // com.google.android.gms.flags.d
    public long getLongFlagValue(String str, long j10, int i10) {
        return !this.f9064a ? j10 : a.c.a(this.f9065b, str, Long.valueOf(j10)).longValue();
    }

    @Override // com.google.android.gms.flags.d
    public String getStringFlagValue(String str, String str2, int i10) {
        return !this.f9064a ? str2 : a.d.a(this.f9065b, str, str2);
    }

    @Override // com.google.android.gms.flags.d
    public void init(b bVar) {
        Context context = (Context) k6.d.U1(bVar);
        if (!this.f9064a) {
            try {
                this.f9065b = b.a(context.createPackageContext("com.google.android.gms", 0));
                this.f9064a = true;
            } catch (PackageManager.NameNotFoundException unused) {
            } catch (Exception e10) {
                String valueOf = String.valueOf(e10.getMessage());
                Log.w("FlagProviderImpl", valueOf.length() != 0 ? "Could not retrieve sdk flags, continuing with defaults: ".concat(valueOf) : new String("Could not retrieve sdk flags, continuing with defaults: "));
            }
        }
    }
}
