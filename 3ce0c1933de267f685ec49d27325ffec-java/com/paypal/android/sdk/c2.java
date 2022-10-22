package com.paypal.android.sdk;

import android.text.TextUtils;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import okhttp3.Headers;
import okhttp3.b0;
import okhttp3.v;
import okhttp3.z;
/* loaded from: classes2.dex */
public class c2 implements v {

    /* renamed from: a  reason: collision with root package name */
    private final String f21084a;

    public c2(String str) {
        this.f21084a = str;
    }

    private static String a(String str, String str2) {
        Mac mac = Mac.getInstance("HmacSHA1");
        mac.init(new SecretKeySpec(str.getBytes(), "HmacSHA1"));
        mac.update(str2.getBytes());
        byte[] doFinal = mac.doFinal();
        StringBuilder sb2 = new StringBuilder();
        int length = doFinal.length;
        for (int i10 = 0; i10 < length; i10++) {
            sb2.append(String.format("%02x", Byte.valueOf(doFinal[i10])));
        }
        return sb2.toString();
    }

    @Override // okhttp3.v
    public b0 intercept(v.a aVar) {
        z request = aVar.request();
        String format = String.format("Trace: [%s] %s, %s", this.f21084a, "\"%08.8x: Operation = %80s Duration: %8.2f Iterations: %+4d\"", "memorySize * 8 + offset");
        try {
            Headers f10 = request.f();
            ArrayList arrayList = new ArrayList();
            for (int i10 = 0; i10 < f10.size(); i10++) {
                arrayList.add(f10.name(i10) + ": " + f10.value(i10));
            }
            Collections.sort(arrayList);
            return aVar.a(request.i().m("PayPal-Item-Id").a("PayPal-Item-Id", a(format, TextUtils.join(";", arrayList.toArray()) + request.a())).b());
        } catch (InvalidKeyException | NoSuchAlgorithmException unused) {
            return aVar.a(request);
        }
    }
}
