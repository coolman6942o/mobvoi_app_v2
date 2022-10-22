package com.huawei.agconnect.config.a;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes.dex */
class f implements b {

    /* renamed from: a  reason: collision with root package name */
    private final Context f13495a;

    /* renamed from: b  reason: collision with root package name */
    private final String f13496b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(Context context, String str) {
        this.f13495a = context;
        this.f13496b = str;
    }

    private static String a(String str) {
        try {
            return "agc_" + c.a(a(str.getBytes("UTF-8")));
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException unused) {
            return "";
        }
    }

    private static byte[] a(byte[] bArr) throws NoSuchAlgorithmException {
        return MessageDigest.getInstance("SHA-256").digest(bArr);
    }

    @Override // com.huawei.agconnect.config.a.b
    public String a(String str, String str2) {
        int identifier;
        String a10 = a(str);
        if (TextUtils.isEmpty(a10) || (identifier = this.f13495a.getResources().getIdentifier(a10, "string", this.f13496b)) == 0) {
            return str2;
        }
        try {
            return this.f13495a.getResources().getString(identifier);
        } catch (Resources.NotFoundException unused) {
            return str2;
        }
    }
}
