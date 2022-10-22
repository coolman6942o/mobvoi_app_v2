package com.mobvoi.android.common.utils;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ConcurrentHashMap;
/* compiled from: AppsSignatureCache.java */
/* loaded from: classes2.dex */
public class c {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: d  reason: collision with root package name */
    private static volatile c f15420d;

    /* renamed from: a  reason: collision with root package name */
    private Context f15421a;

    /* renamed from: b  reason: collision with root package name */
    private final ConcurrentHashMap<String, String[]> f15422b = new ConcurrentHashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private BroadcastReceiver f15423c = new a();

    /* compiled from: AppsSignatureCache.java */
    /* loaded from: classes2.dex */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.PACKAGE_FULLY_REMOVED".equals(intent.getAction())) {
                String schemeSpecificPart = intent.getData().getSchemeSpecificPart();
                k.c("AppsSignatureCache", "package removed: %s", schemeSpecificPart);
                c.this.f15422b.remove(schemeSpecificPart);
            }
        }
    }

    private c(Context context) {
        this.f15421a = context.getApplicationContext();
        d();
    }

    public static c b(Context context) {
        if (f15420d == null) {
            synchronized (c.class) {
                if (f15420d == null) {
                    f15420d = new c(context);
                }
            }
        }
        return f15420d;
    }

    private void d() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_FULLY_REMOVED");
        intentFilter.addDataScheme("package");
        this.f15421a.registerReceiver(this.f15423c, intentFilter);
    }

    public String[] c(String str) throws PackageManager.NameNotFoundException {
        String[] strArr = this.f15422b.get(str);
        if (strArr != null) {
            return strArr;
        }
        try {
            PackageInfo packageInfo = this.f15421a.getPackageManager().getPackageInfo(str, 64);
            String[] strArr2 = new String[packageInfo.signatures.length];
            int i10 = 0;
            while (true) {
                Signature[] signatureArr = packageInfo.signatures;
                if (i10 < signatureArr.length) {
                    strArr2[i10] = f.m(signatureArr[i10].toByteArray());
                    i10++;
                } else {
                    this.f15422b.put(str, strArr2);
                    return strArr2;
                }
            }
        } catch (NoSuchAlgorithmException e10) {
            throw new RuntimeException("Should never happen", e10);
        }
    }
}
