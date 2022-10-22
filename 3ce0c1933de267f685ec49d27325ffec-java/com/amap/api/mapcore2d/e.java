package com.amap.api.mapcore2d;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* compiled from: MD5.java */
/* loaded from: classes.dex */
public class e {
    public static String a(String str) {
        return g.k(b(str));
    }

    private static byte[] b(String str) {
        try {
            return c(str);
        } catch (Throwable th2) {
            th2.printStackTrace();
            return new byte[0];
        }
    }

    private static byte[] c(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        if (str == null) {
            return null;
        }
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(g.f(str));
        return messageDigest.digest();
    }
}
