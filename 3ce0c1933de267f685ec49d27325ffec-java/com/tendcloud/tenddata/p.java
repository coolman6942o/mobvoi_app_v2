package com.tendcloud.tenddata;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
/* compiled from: td */
/* loaded from: classes2.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    private static final String f22994a = "RC4/ECB/NoPadding";

    /* renamed from: b  reason: collision with root package name */
    private static final String f22995b = "ARCFOUR";

    /* renamed from: c  reason: collision with root package name */
    private static final String f22996c = "r5czusfu0wjcaz4pp01v2k7qte55xc25fngq4ylby2civ230vdy6uy6goz9w4kgfqjk31l8khfzfvbxj7emcprjyy8nngf0r9dvxzwbhm2uw7ljre52jt95lg0knyp8e5c4go44s3z5ciy58h0tuosmwhupa62rdnkeicgdba6w6f0kenp0xac7so8j1vdbjpqwyprx2ouenv22isustwnpltt9ui5plnijd4bq4013o3mzdkllozn26zwds9x38";

    /* renamed from: d  reason: collision with root package name */
    private static final byte[] f22997d = f22996c.getBytes();

    public static byte[] a(byte[] bArr) {
        Cipher cipher = Cipher.getInstance(f22994a);
        cipher.init(1, new SecretKeySpec(f22997d, f22995b));
        return cipher.doFinal(bArr);
    }

    public static byte[] a(byte[] bArr, String str) {
        Cipher cipher = Cipher.getInstance(f22994a);
        cipher.init(1, new SecretKeySpec(str.getBytes(), f22995b));
        return cipher.doFinal(bArr);
    }
}
