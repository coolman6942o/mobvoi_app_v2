package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.pm.PackageManager;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public final class j0 extends z2 {

    /* renamed from: c  reason: collision with root package name */
    private long f9375c;

    /* renamed from: d  reason: collision with root package name */
    private String f9376d;

    /* renamed from: e  reason: collision with root package name */
    private Boolean f9377e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j0(d2 d2Var) {
        super(d2Var);
    }

    public final long A() {
        u();
        return this.f9375c;
    }

    public final String B() {
        u();
        return this.f9376d;
    }

    @Override // com.google.android.gms.internal.measurement.z2
    protected final boolean v() {
        Calendar calendar = Calendar.getInstance();
        this.f9375c = TimeUnit.MINUTES.convert(calendar.get(15) + calendar.get(16), TimeUnit.MILLISECONDS);
        Locale locale = Locale.getDefault();
        String language = locale.getLanguage();
        Locale locale2 = Locale.ENGLISH;
        String lowerCase = language.toLowerCase(locale2);
        String lowerCase2 = locale.getCountry().toLowerCase(locale2);
        StringBuilder sb2 = new StringBuilder(String.valueOf(lowerCase).length() + 1 + String.valueOf(lowerCase2).length());
        sb2.append(lowerCase);
        sb2.append("-");
        sb2.append(lowerCase2);
        this.f9376d = sb2.toString();
        return false;
    }

    public final boolean z(Context context) {
        if (this.f9377e == null) {
            this.f9377e = Boolean.FALSE;
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null) {
                    packageManager.getPackageInfo("com.google.android.gms", 128);
                    this.f9377e = Boolean.TRUE;
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return this.f9377e.booleanValue();
    }
}
