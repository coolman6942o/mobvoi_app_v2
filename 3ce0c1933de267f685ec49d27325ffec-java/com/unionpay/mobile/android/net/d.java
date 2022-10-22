package com.unionpay.mobile.android.net;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.unionpay.mobile.android.utils.c;
import java.net.URL;
import java.util.HashMap;
/* loaded from: classes2.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private int f23563a;

    /* renamed from: b  reason: collision with root package name */
    private String f23564b;

    /* renamed from: c  reason: collision with root package name */
    private HashMap<String, String> f23565c;

    /* renamed from: d  reason: collision with root package name */
    private byte[] f23566d;

    /* renamed from: e  reason: collision with root package name */
    private String f23567e;

    /* renamed from: f  reason: collision with root package name */
    private String f23568f;

    public d(String str) {
        this.f23563a = 1;
        this.f23564b = str;
        this.f23565c = null;
        this.f23566d = null;
    }

    public d(String str, byte[] bArr) {
        this.f23563a = 1;
        this.f23564b = str;
        this.f23565c = null;
        this.f23566d = bArr;
    }

    public final URL a() {
        String str;
        try {
            if (!TextUtils.isEmpty(this.f23568f)) {
                str = this.f23564b + this.f23568f;
            } else {
                str = this.f23564b;
            }
            return new URL(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public final void a(Context context, String str, String str2) {
        this.f23568f = "?" + c.d(str) + "&0," + c.b(context) + ContainerUtils.FIELD_DELIMITER + c.e(str2);
    }

    public final void a(String str) {
        if (str != null) {
            this.f23567e = str;
            this.f23566d = str.getBytes();
        }
    }

    public final void a(HashMap<String, String> hashMap) {
        this.f23565c = hashMap;
    }

    public final String b() {
        return this.f23563a == 1 ? "POST" : "GET";
    }

    public final String c() {
        return this.f23567e;
    }

    public final HashMap<String, String> d() {
        return this.f23565c;
    }
}
