package com.unionpay.mobile.android.pboctransaction;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.unionpay.mobile.android.fully.a;
import com.unionpay.mobile.android.model.c;
import com.unionpay.mobile.android.pboctransaction.samsung.f;
import com.unionpay.mobile.android.utils.PreferenceUtils;
import com.unionpay.mobile.android.utils.k;
import com.unionpay.tsmservice.data.Constant;
import com.unionpay.tsmservice.data.ResultCode;
import java.nio.ByteBuffer;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class d {

    /* renamed from: c  reason: collision with root package name */
    c f23757c;

    /* renamed from: d  reason: collision with root package name */
    a f23758d;

    /* renamed from: f  reason: collision with root package name */
    private String f23760f;

    /* renamed from: l  reason: collision with root package name */
    private static Date f23753l = new Date(System.currentTimeMillis());

    /* renamed from: m  reason: collision with root package name */
    private static String f23754m = new SimpleDateFormat("yyyyMMddhhmmss").format((java.util.Date) f23753l);

    /* renamed from: o  reason: collision with root package name */
    private static HashMap<String, String> f23755o = new HashMap<>();

    /* renamed from: a  reason: collision with root package name */
    public static String f23751a = "A0000003330101010000000000010000";

    /* renamed from: b  reason: collision with root package name */
    public static String f23752b = "A0000003330101020001050001000000";

    /* renamed from: s  reason: collision with root package name */
    private static d f23756s = null;

    /* renamed from: g  reason: collision with root package name */
    private byte f23761g = 0;

    /* renamed from: h  reason: collision with root package name */
    private byte f23762h = 0;

    /* renamed from: i  reason: collision with root package name */
    private byte f23763i = 1;

    /* renamed from: j  reason: collision with root package name */
    private boolean f23764j = true;

    /* renamed from: k  reason: collision with root package name */
    private boolean f23765k = true;

    /* renamed from: n  reason: collision with root package name */
    private String f23766n = null;

    /* renamed from: p  reason: collision with root package name */
    private final String f23767p = "A0000003334355502D4D4F42494C45";

    /* renamed from: q  reason: collision with root package name */
    private boolean f23768q = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f23759e = false;

    /* renamed from: r  reason: collision with root package name */
    private String f23769r = "";

    public d(c cVar, a aVar, String str) {
        this.f23760f = "1.4";
        this.f23760f = str;
        this.f23757c = cVar;
        this.f23758d = aVar;
    }

    private static String a(String str, String str2) {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        if (str == null) {
            return null;
        }
        byte[] a10 = e.a(str);
        int i19 = 0;
        while (i19 < a10.length) {
            int i20 = 1;
            int i21 = ((byte) (a10[i19] & 31)) == 31 ? 2 : 1;
            byte[] bArr = new byte[i21];
            System.arraycopy(a10, i19, bArr, 0, i21);
            if (e.a(bArr, i21).compareToIgnoreCase(str2) == 0) {
                int i22 = i19 + i21;
                if (((byte) (a10[i22] & 128)) != Byte.MIN_VALUE) {
                    i13 = a10[i22];
                } else {
                    i20 = 1 + (a10[i22] & 127);
                    if (i20 == 2) {
                        i13 = a10[i22 + 1];
                    } else {
                        if (i20 == 3) {
                            i11 = (a10[i22 + 1] & 255) << 8;
                            i12 = a10[i22 + 2];
                        } else if (i20 == 4) {
                            i11 = ((a10[i22 + 1] & 255) << 16) | ((a10[i22 + 2] & 255) << 8);
                            i12 = a10[i22 + 3];
                        } else {
                            i10 = 0;
                            byte[] bArr2 = new byte[i10];
                            System.arraycopy(a10, i22 + i20, bArr2, 0, i10);
                            return e.a(bArr2, i10);
                        }
                        i10 = i11 | (i12 & 255);
                        byte[] bArr22 = new byte[i10];
                        System.arraycopy(a10, i22 + i20, bArr22, 0, i10);
                        return e.a(bArr22, i10);
                    }
                }
                i10 = i13 & 255;
                byte[] bArr222 = new byte[i10];
                System.arraycopy(a10, i22 + i20, bArr222, 0, i10);
                return e.a(bArr222, i10);
            }
            int i23 = a10[i19] & 32;
            int i24 = i19 + i21;
            int length = a10.length;
            if (i23 != 32) {
                if (i24 >= length || ((byte) (a10[i24] & 128)) != 0) {
                    i20 = i24 < a10.length ? (a10[i24] & 127) + 1 : 0;
                    if (i20 != 2 || (i17 = i24 + 1) >= a10.length) {
                        i14 = (i20 != 3 || (i16 = i24 + 2) >= a10.length) ? (i20 != 4 || (i15 = i24 + 2) >= a10.length) ? 0 : ((a10[i15] & 255) << 8) | ((a10[i24 + 1] & 255) << 16) | (a10[i24 + 3] & 255) : (a10[i16] & 255) | ((a10[i24 + 1] & 255) << 8);
                        i20 += i14;
                    } else {
                        i18 = a10[i17];
                    }
                } else {
                    i18 = a10[i24];
                }
                i14 = i18 & 255;
                i20 += i14;
            } else if (i24 < length && ((byte) (a10[i24] & 128)) == Byte.MIN_VALUE) {
                i20 = 1 + (a10[i24] & 127);
            }
            i19 = i24 + i20;
        }
        return null;
    }

    private static String a(String str, boolean z10) {
        StringBuffer stringBuffer = new StringBuffer();
        byte[] bytes = str.toUpperCase().getBytes();
        int length = bytes.length;
        for (int i10 = 0; i10 < length; i10++) {
            stringBuffer.append(String.format("%02X", Byte.valueOf(bytes[i10])));
        }
        int length2 = (stringBuffer.length() / 2) + (stringBuffer.length() % 2);
        if (!z10) {
            int i11 = length2 % 8;
            int i12 = i11 != 0 ? (8 - i11) + length2 : length2;
            byte[] bArr = new byte[i12];
            System.arraycopy(e.a(stringBuffer.toString()), 0, bArr, 0, length2);
            return e.a(bArr, i12);
        }
        int i13 = length2 + 1;
        int i14 = i13 % 8;
        if (i14 != 0) {
            i13 += 8 - i14;
        }
        byte[] bArr2 = new byte[i13];
        System.arraycopy(e.a(stringBuffer.toString()), 0, bArr2, 0, length2);
        bArr2[length2] = Byte.MIN_VALUE;
        return e.a(bArr2, i13);
    }

    private String a(byte[] bArr) {
        int i10 = 0;
        byte b10 = bArr[0];
        byte b11 = this.f23761g;
        bArr[0] = (byte) (b10 | b11);
        byte[] a10 = this.f23757c.a(bArr, b11);
        int length = a10 != null ? a10.length : 0;
        if (length >= 2 && a10[length - 2] == 97) {
            byte b12 = a10[length - 1];
            byte b13 = this.f23761g;
            a10 = this.f23757c.a(new byte[]{b13, -64, 0, 0, b12}, b13);
            length = a10 != null ? a10.length : 0;
        }
        if (length >= 2 && a10[length - 2] == 108) {
            bArr[bArr.length - 1] = a10[length - 1];
            a10 = this.f23757c.a(bArr, this.f23761g);
            if (a10 != null) {
                i10 = a10.length;
            }
            length = i10;
        }
        if (length > 2) {
            int i11 = length - 2;
            if (a10[i11] == -112 && a10[length - 1] == 0) {
                return e.a(a10, i11);
            }
        }
        if (length == 2 && a10[length - 2] == -112 && a10[length - 1] == 0) {
            return e.a(a10, 2);
        }
        return null;
    }

    private String a(byte[] bArr, String str) {
        bArr[4] = (byte) (str.length() / 2);
        byte[] bArr2 = new byte[(str.length() / 2) + 5];
        System.arraycopy(bArr, 0, bArr2, 0, 5);
        System.arraycopy(e.a(str), 0, bArr2, 5, str.length() / 2);
        return a(bArr2);
    }

    private static void a(String str, StringBuffer stringBuffer) {
        String str2 = f23755o.get(str);
        String a10 = e.a(new byte[]{(byte) (str2.length() / 2)}, 1);
        stringBuffer.append(str);
        stringBuffer.append(a10);
        stringBuffer.append(str2);
    }

    private String b(String str) {
        c cVar = this.f23757c;
        if (cVar instanceof f) {
            return cVar.a(str);
        }
        this.f23761g = this.f23762h;
        if (str == null) {
            return null;
        }
        String a10 = e.a(new byte[]{Integer.valueOf(str.length() / 2).byteValue()});
        return a(e.a("00a40400" + a10 + str));
    }

    private void b(byte[] bArr) {
        int length = (f23754m.length() / 2) + 1;
        byte[] bArr2 = new byte[length];
        System.arraycopy(e.a(f23754m), 0, bArr2, 0, f23754m.length() / 2);
        bArr2[length - 1] = Byte.MIN_VALUE;
        bArr[4] = (byte) length;
        byte[] bArr3 = new byte[length + 5];
        System.arraycopy(bArr, 0, bArr3, 0, 5);
        System.arraycopy(bArr2, 0, bArr3, 5, length);
        a(bArr3);
    }

    private String c(String str) {
        if (str == null || "9000".equals(str)) {
            StringBuffer stringBuffer = new StringBuffer("80A800000b8309");
            for (String str2 : i("9F7A019F02065F2A02")) {
                Iterator<String> it = f23755o.keySet().iterator();
                while (true) {
                    if (it.hasNext()) {
                        String next = it.next();
                        if (str2.compareToIgnoreCase(next) == 0) {
                            stringBuffer.append(f23755o.get(next));
                            break;
                        }
                    }
                }
            }
            return a(e.a(stringBuffer.toString()));
        }
        k.c("uppay", "test for gongshang version 2");
        StringBuffer stringBuffer2 = new StringBuffer("");
        String a10 = a(str, "9F38");
        if (TextUtils.isEmpty(a10)) {
            ByteBuffer allocate = ByteBuffer.allocate(7);
            allocate.put(Byte.MIN_VALUE).put((byte) -88).put((byte) 0).put((byte) 0).put((byte) 2).put((byte) -125).put((byte) 0);
            return a(allocate.array());
        }
        for (String str3 : i(a10)) {
            Iterator<String> it2 = f23755o.keySet().iterator();
            while (true) {
                if (it2.hasNext()) {
                    String next2 = it2.next();
                    if (str3.compareToIgnoreCase(next2) == 0) {
                        stringBuffer2.append(f23755o.get(next2));
                        break;
                    }
                }
            }
        }
        byte[] a11 = e.a(stringBuffer2.toString());
        ByteBuffer allocate2 = ByteBuffer.allocate(a11.length + 7);
        allocate2.put(Byte.MIN_VALUE).put((byte) -88).put((byte) 0).put((byte) 0).put((byte) (a11.length + 2)).put((byte) -125).put((byte) a11.length).put(a11);
        return a(allocate2.array());
    }

    private String d(String str) {
        Exception e10;
        String a10 = a(str, "80");
        if (a10 == null) {
            return null;
        }
        int i10 = 4;
        f23755o.put("82", a10.substring(0, 4));
        byte[] a11 = e.a(a10.substring(4));
        ArrayList<String> arrayList = new ArrayList();
        arrayList.add("5A");
        arrayList.add("5F34");
        arrayList.add("9F1F");
        arrayList.add("57");
        arrayList.add("5F24");
        arrayList.add("9F10");
        arrayList.add("8C");
        arrayList.add("8D");
        int i11 = 0;
        while (i11 < a11.length) {
            try {
                byte[] bArr = new byte[5];
                bArr[0] = 0;
                bArr[1] = -78;
                bArr[2] = 0;
                bArr[3] = 0;
                bArr[i10] = 0;
                byte[] bArr2 = new byte[i10];
                System.arraycopy(a11, i11, bArr2, 0, i10);
                i11 += 4;
                byte b10 = bArr2[1];
                for (char c10 = 2; b10 <= bArr2[c10]; c10 = 2) {
                    bArr[i10] = 0;
                    bArr[3] = (byte) ((bArr2[0] & (-8)) | i10);
                    bArr[c10] = b10;
                    b10 = (byte) (b10 + 1);
                    try {
                        String a12 = a(bArr);
                        if (a12 != null) {
                            for (String str2 : arrayList) {
                                String a13 = a(a12, str2);
                                if (a13 != null) {
                                    f23755o.put(str2, a13);
                                }
                            }
                        }
                        i10 = 4;
                    } catch (Exception e11) {
                        e10 = e11;
                        e10.printStackTrace();
                        return f23755o.get("8C");
                    }
                }
            } catch (Exception e12) {
                e10 = e12;
            }
        }
        StringBuffer stringBuffer = new StringBuffer(f23755o.get("5F34"));
        stringBuffer.insert(0, "0");
        f23755o.put("5F34", stringBuffer.toString());
        return f23755o.get("8C");
    }

    private static void d() {
        String substring = f23754m.substring(2, 8);
        long time = new Date(System.currentTimeMillis()).getTime();
        String valueOf = String.valueOf(time);
        String format = valueOf.length() < 8 ? String.format("%08d", Long.valueOf(time)) : valueOf.substring(valueOf.length() - 8, valueOf.length());
        f23755o.put("9F26", "");
        f23755o.put("9F27", "80");
        f23755o.put("9F10", "");
        f23755o.put("9F37", format);
        f23755o.put("9F36", "");
        f23755o.put("95", "0000000800");
        f23755o.put("9A", substring);
        f23755o.put("9C", "45");
        f23755o.put("9F02", Constant.DEFAULT_BALANCE);
        f23755o.put("5F2A", "0156");
        f23755o.put("82", "");
        f23755o.put("9F1A", "0156");
        f23755o.put("9F03", Constant.DEFAULT_BALANCE);
        f23755o.put("9F33", "A04000");
        f23755o.put("9F34", "420300");
        f23755o.put("9F35", "34");
        f23755o.put("9F1E", "3030303030303030");
        f23755o.put("84", "");
        f23755o.put("9F09", "0001");
        f23755o.put("9F74", "");
        f23755o.put("9F63", "");
        f23755o.put("9F7A", "01");
        f23755o.put("9F21", f23754m.substring(8));
        f23755o.put("9F4E", "0000000000000000000000000000000000000000");
        f23755o.put("DF31", "0100000000");
        f23755o.put("9F66", "36800000");
        f23755o.put("DF60", "00");
    }

    private String e(String str) {
        StringBuffer stringBuffer = new StringBuffer("80AE800034");
        for (String str2 : i(str)) {
            Iterator<String> it = f23755o.keySet().iterator();
            while (true) {
                if (it.hasNext()) {
                    String next = it.next();
                    if (str2.compareToIgnoreCase(next) == 0) {
                        stringBuffer.append(f23755o.get(next));
                        break;
                    }
                }
            }
        }
        String a10 = a(e.a(stringBuffer.toString()));
        if (a10 != null) {
            f23755o.put("9F27", a10.substring(4, 6));
            f23755o.put("9F36", a10.substring(6, 10));
            f23755o.put("9F26", a10.substring(10, 26));
            f23755o.put("9F10", a10.substring(26));
        }
        return a10;
    }

    private boolean e() {
        String str = f23755o.get("5A");
        while (str.substring(str.length() - 1, str.length()).equalsIgnoreCase("f")) {
            str = str.substring(0, str.length() - 1);
        }
        String f10 = f(str);
        if (!(f10 == null || f10.length() == 0)) {
            f23755o.put("AN1", f10);
            String f11 = f("00000001");
            if (!(f11 == null || f11.length() == 0)) {
                f23755o.put("TID", f11);
                String f12 = f(f23755o.get("9F02"));
                if (!(f12 == null || f12.length() == 0)) {
                    f23755o.put("AMT", f12);
                    String f13 = f("156");
                    if (!(f13 == null || f13.length() == 0)) {
                        f23755o.put("CUR", f13);
                        String str2 = f23755o.get("57");
                        while (true) {
                            if (!str2.substring(str2.length() - 1, str2.length()).equalsIgnoreCase("f") && !str2.substring(str2.length() - 1, str2.length()).equalsIgnoreCase("F")) {
                                break;
                            }
                            str2 = str2.substring(0, str2.length() - 1);
                        }
                        String f14 = f(str2);
                        if (f14 == null || f14.length() == 0) {
                            return false;
                        }
                        f23755o.put("TD2", f14);
                        if (f23755o.get("5F24") != null && f23755o.get("5F24").length() == 6) {
                            String f15 = f(f23755o.get("5F24").substring(0, 4));
                            if (f15 == null || f15.length() == 0) {
                                return false;
                            }
                            f23755o.put("ED", f15);
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private String f() {
        this.f23761g = this.f23763i;
        String a10 = a(new byte[]{0, -80, -126, 0, 10});
        if (!(a10 == null || a10.length() == 0)) {
            f23755o.put("CSN", a10);
        }
        this.f23761g = this.f23762h;
        return a10;
    }

    private String f(String str) {
        this.f23761g = this.f23763i;
        String a10 = a(str, false);
        b(new byte[]{Byte.MIN_VALUE, 26, 19, 1, 0});
        String a11 = a(new byte[]{Byte.MIN_VALUE, -6, 0, 0, 0}, a10);
        this.f23761g = this.f23762h;
        return a11;
    }

    private static Bundle g() {
        Bundle bundle = new Bundle();
        bundle.putString("action_resp_code", "0000");
        return bundle;
    }

    private String g(String str) {
        this.f23761g = this.f23763i;
        byte[] bArr = {Byte.MIN_VALUE, 26, 20, 1, 0};
        byte[] bArr2 = {Byte.MIN_VALUE, -6, 0, 0, 0};
        StringBuilder sb2 = new StringBuilder();
        sb2.append(String.format("%02d", Integer.valueOf(str.length())));
        sb2.append(str);
        String sb3 = sb2.toString();
        StringBuffer stringBuffer = new StringBuffer(sb3);
        for (int i10 = 0; i10 < 16 - sb3.length(); i10++) {
            stringBuffer.append("F");
        }
        b(bArr);
        String a10 = a(bArr2, stringBuffer.toString());
        if (a10 != null) {
            f23755o.put("PIN", a10);
        }
        this.f23761g = this.f23762h;
        return a10;
    }

    private String h(String str) {
        this.f23761g = this.f23763i;
        byte[] bArr = {Byte.MIN_VALUE, -6, 1, 0, 0};
        String a10 = a(str, true);
        b(new byte[]{Byte.MIN_VALUE, 26, 21, 1, 8});
        while (a10.length() > 448) {
            bArr[2] = 3;
            a(bArr, a10.substring(0, 448).toUpperCase());
            a10 = a10.substring(448);
        }
        bArr[2] = 1;
        if (Build.VERSION.SDK_INT <= 10) {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e10) {
                e10.printStackTrace();
            }
        }
        String a11 = a(bArr, a10);
        k.c("uppay", "encryptMac in resp" + a11);
        if (a11 != null) {
            f23755o.put("MAC", a11.toUpperCase());
        }
        this.f23761g = this.f23762h;
        return a11 != null ? a11.toUpperCase() : a11;
    }

    private static List<String> i(String str) {
        ArrayList arrayList = new ArrayList();
        if (str == null) {
            return arrayList;
        }
        byte[] a10 = e.a(str);
        int i10 = 0;
        while (i10 < a10.length) {
            int i11 = 1;
            int i12 = ((byte) (a10[i10] & 31)) == 31 ? 2 : 1;
            byte[] bArr = new byte[i12];
            System.arraycopy(a10, i10, bArr, 0, i12);
            arrayList.add(e.a(bArr, i12));
            int i13 = i10 + i12;
            if (i13 < a10.length && ((byte) (a10[i13] & 128)) == Byte.MIN_VALUE) {
                i11 = 1 + (a10[i13] & 127);
            }
            i10 = i13 + i11;
        }
        return arrayList;
    }

    public final synchronized Bundle a(int i10, String str, HashMap<String, String> hashMap, String str2) {
        k.c("uppay", "startUPCardPurchase() +++");
        Bundle g10 = g();
        String str3 = "";
        this.f23757c.b();
        String a10 = a();
        if (!(a10 == null || a10.length() == 0)) {
            k.c("uppay", " ************T1=" + f23754m);
            f23755o.put("PIN", str);
            String g11 = g(PreferenceUtils.decPrefData(f23755o.get("PIN"), str2));
            if (!(g11 == null || g11.length() == 0)) {
                k.c("uppay", " ************T2=" + f23754m);
                String a11 = a(i10, f23754m);
                if (!(a11 == null || a11.length() == 0)) {
                    String f10 = f();
                    if (!(f10 == null || f10.length() == 0)) {
                        String c10 = e.c(a11.substring(40, 60));
                        String substring = a11.substring(60, 100);
                        String substring2 = a11.substring(100, 208);
                        String substring3 = a11.substring(216, 232);
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("v", this.f23760f);
                            jSONObject.put("cmd", "pay");
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject.put(Constant.KEY_PARAMS, jSONObject2);
                            jSONObject2.put("pay_type", "2");
                            jSONObject2.put("pay_mode", "1");
                            jSONObject2.put("bind", "no");
                            jSONObject2.put("carrier_tp", "1");
                            jSONObject2.put("track2_data", substring);
                            jSONObject2.put("track3_data", substring2);
                            jSONObject2.put("csn", f23755o.get("CSN"));
                            jSONObject2.put("submit_time", f23754m);
                            jSONObject2.put("sp_id", "8889");
                            jSONObject2.put(Constant.KEY_PIN, f23755o.get("PIN"));
                            jSONObject2.put(Constant.KEY_PAN, c10);
                            jSONObject2.put("dynamic_key_data", substring3);
                            jSONObject2.put("carrier_app_tp", "1");
                            if (!(hashMap == null || hashMap.keySet() == null || hashMap.keySet().size() <= 0)) {
                                hashMap.remove(Constant.KEY_PAN);
                                hashMap.remove(Constant.KEY_PIN);
                                for (String str4 : hashMap.keySet()) {
                                    jSONObject2.put(str4, hashMap.get(str4));
                                }
                            }
                            str3 = jSONObject.toString();
                        } catch (JSONException e10) {
                            e10.printStackTrace();
                        }
                        k.c("uppay", " ************T3=" + f23754m);
                        g10.putString("action_resp_message", this.f23758d.a(str3));
                        this.f23757c.c();
                        d();
                        return g10;
                    }
                    this.f23757c.c();
                    g10.putString("action_resp_code", ResultCode.ERROR_INTERFACE_GET_SMS_AUTH_CODE);
                    return g10;
                }
                this.f23757c.c();
                g10.putString("action_resp_code", ResultCode.ERROR_INTERFACE_GET_SMS_AUTH_CODE);
                return g10;
            }
            this.f23757c.c();
            g10.putString("action_resp_code", ResultCode.ERROR_INTERFACE_GET_SMS_AUTH_CODE);
            return g10;
        }
        this.f23757c.c();
        g10.putString("action_resp_code", ResultCode.ERROR_INTERFACE_GET_SMS_AUTH_CODE);
        return g10;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x01a6 A[Catch: all -> 0x0525, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0058, B:8:0x006a, B:10:0x00af, B:13:0x00b7, B:15:0x00d7, B:18:0x00df, B:20:0x00ff, B:23:0x0107, B:25:0x0127, B:28:0x012e, B:30:0x014e, B:33:0x0155, B:35:0x0175, B:38:0x017f, B:44:0x019c, B:46:0x01a6, B:49:0x01ad, B:51:0x01db, B:54:0x01e3, B:56:0x01f0, B:59:0x0205, B:61:0x027b, B:63:0x0285, B:65:0x028f, B:67:0x0299, B:69:0x02a3, B:72:0x02af, B:74:0x02c3, B:75:0x02ce, B:77:0x02d8, B:78:0x02e3, B:80:0x02ed, B:81:0x02f8, B:83:0x0302, B:84:0x030d, B:86:0x032a, B:87:0x0335, B:89:0x0339, B:91:0x0343, B:92:0x034e, B:94:0x0358, B:95:0x0363, B:97:0x036d, B:98:0x0378, B:99:0x037e, B:101:0x0384, B:103:0x038c, B:104:0x03a1, B:106:0x03c5, B:108:0x03cd, B:110:0x042a, B:112:0x0437, B:114:0x0473, B:115:0x0480, B:117:0x048a, B:119:0x0499, B:121:0x049f, B:123:0x04a9, B:124:0x04bb, B:126:0x04c1, B:127:0x04cf, B:128:0x04d3, B:131:0x04ed, B:133:0x04fb, B:136:0x0509, B:139:0x0517), top: B:144:0x0001, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01ad A[Catch: all -> 0x0525, TRY_ENTER, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0058, B:8:0x006a, B:10:0x00af, B:13:0x00b7, B:15:0x00d7, B:18:0x00df, B:20:0x00ff, B:23:0x0107, B:25:0x0127, B:28:0x012e, B:30:0x014e, B:33:0x0155, B:35:0x0175, B:38:0x017f, B:44:0x019c, B:46:0x01a6, B:49:0x01ad, B:51:0x01db, B:54:0x01e3, B:56:0x01f0, B:59:0x0205, B:61:0x027b, B:63:0x0285, B:65:0x028f, B:67:0x0299, B:69:0x02a3, B:72:0x02af, B:74:0x02c3, B:75:0x02ce, B:77:0x02d8, B:78:0x02e3, B:80:0x02ed, B:81:0x02f8, B:83:0x0302, B:84:0x030d, B:86:0x032a, B:87:0x0335, B:89:0x0339, B:91:0x0343, B:92:0x034e, B:94:0x0358, B:95:0x0363, B:97:0x036d, B:98:0x0378, B:99:0x037e, B:101:0x0384, B:103:0x038c, B:104:0x03a1, B:106:0x03c5, B:108:0x03cd, B:110:0x042a, B:112:0x0437, B:114:0x0473, B:115:0x0480, B:117:0x048a, B:119:0x0499, B:121:0x049f, B:123:0x04a9, B:124:0x04bb, B:126:0x04c1, B:127:0x04cf, B:128:0x04d3, B:131:0x04ed, B:133:0x04fb, B:136:0x0509, B:139:0x0517), top: B:144:0x0001, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized Bundle a(AppIdentification appIdentification, String str, String str2, HashMap<String, String> hashMap, HashMap<String, String> hashMap2, String str3) {
        String str4;
        String str5;
        this.f23757c.b();
        k.c("uppay", "startPBOCPurchase() +++");
        f23755o.clear();
        d();
        f23755o.put("PIN", str);
        f23755o.put("9F02", hashMap.get("trans_amt"));
        f23755o.put("9F1A", "0156");
        f23755o.put("5F2A", hashMap.get("trans currcy code"));
        f23755o.put("9C", hashMap.get("trans_type"));
        String a10 = appIdentification.a();
        if (!a10.startsWith("A000000333")) {
            this.f23757c.c();
            Bundle g10 = g();
            g10.putString("action_resp_code", ResultCode.ERROR_INTERFACE_GET_SMS_AUTH_CODE);
            return g10;
        }
        Bundle g11 = g();
        f23753l = new Date(System.currentTimeMillis());
        String format = new SimpleDateFormat("yyyyMMddHHmmss").format((java.util.Date) f23753l);
        f23754m = format;
        this.f23766n = new String(format);
        k.c("uppay", "selectUPCard");
        String a11 = a();
        k.c("uppay", "selectUPCard return: " + a11);
        if (!(a11 == null || a11.length() == 0)) {
            k.c("uppay", "selectPBOC");
            String b10 = b(a10);
            k.c("uppay", "selectPBOC return: " + b10);
            if (!(b10 == null || b10.length() == 0)) {
                k.c("uppay", "GPO");
                String c10 = c(b10);
                k.c("uppay", "gpo return: " + c10);
                if (!(c10 == null || c10.length() == 0)) {
                    k.c("uppay", "CDOL1");
                    String d10 = d(c10);
                    k.c("uppay", "CDOL1 return: " + d10);
                    if (!(d10 == null || d10.length() == 0)) {
                        k.c("uppay", "GAC1");
                        String e10 = e(d10);
                        k.c("uppay", "GAC1 return: " + e10);
                        if (!(e10 == null || e10.length() == 0)) {
                            k.c("uppay", "csn");
                            String f10 = f();
                            k.c("uppay", "csn return: " + f10);
                            if (f10 == null || f10.length() == 0) {
                                str4 = "action_resp_code";
                                str5 = ResultCode.ERROR_INTERFACE_GET_SMS_AUTH_CODE;
                                g11.putString(str4, str5);
                            }
                            if (g11.getString("action_resp_code") == "0000") {
                                this.f23757c.c();
                                return g11;
                            }
                            k.c("uppay", "encryptPIN");
                            String g12 = g(PreferenceUtils.decPrefData(f23755o.get("PIN"), str3));
                            k.c("uppay", "encryptPIN return:" + g12);
                            if (!(g12 == null || g12.length() == 0)) {
                                k.c("uppay", "encryptData");
                                if (!e()) {
                                    k.c("uppay", "encryptData false");
                                    this.f23757c.c();
                                    g11.putString("action_resp_code", ResultCode.ERROR_INTERFACE_GET_SMS_AUTH_CODE);
                                    return g11;
                                }
                                k.c("uppay", "initDCData");
                                StringBuffer stringBuffer = new StringBuffer();
                                a("9F26", stringBuffer);
                                a("9F27", stringBuffer);
                                a("9F10", stringBuffer);
                                a("9F37", stringBuffer);
                                a("9F36", stringBuffer);
                                a("95", stringBuffer);
                                a("9A", stringBuffer);
                                a("9C", stringBuffer);
                                a("9F02", stringBuffer);
                                a("5F2A", stringBuffer);
                                a("82", stringBuffer);
                                a("9F1A", stringBuffer);
                                a("9F03", stringBuffer);
                                a("9F33", stringBuffer);
                                a("9F34", stringBuffer);
                                a("9F35", stringBuffer);
                                a("9F1E", stringBuffer);
                                f23755o.put("DCD", stringBuffer.toString());
                                if (!(f23755o.get("TID") == null || f23755o.get("AMT") == null || f23755o.get("CUR") == null || f23755o.get("AN1") == null || f23755o.get("CSN") == null || f23755o.get("5F34") == null)) {
                                    ArrayList arrayList = new ArrayList();
                                    arrayList.add(f23754m);
                                    if (f23755o.get("TID") != null) {
                                        arrayList.add(f23755o.get("TID"));
                                    }
                                    if (f23755o.get("AMT") != null) {
                                        arrayList.add(f23755o.get("AMT"));
                                    }
                                    if (f23755o.get("CUR") != null) {
                                        arrayList.add(f23755o.get("CUR"));
                                    }
                                    if (f23755o.get("AN1") != null) {
                                        arrayList.add(f23755o.get("AN1"));
                                    }
                                    HashMap<String, String> hashMap3 = f23755o;
                                    hashMap3.put("AN1", e.c(hashMap3.get("5A")));
                                    if (f23755o.get("CSN") != null) {
                                        arrayList.add(f23755o.get("CSN"));
                                    }
                                    if (this.f23768q && f23755o.get("ED") != null) {
                                        arrayList.add(f23755o.get("ED"));
                                    }
                                    if (f23755o.get("5F34") != null) {
                                        arrayList.add(f23755o.get("5F34"));
                                    }
                                    if (f23755o.get("DCD") != null) {
                                        arrayList.add(f23755o.get("DCD"));
                                    }
                                    String str6 = "";
                                    Iterator it = arrayList.iterator();
                                    while (it.hasNext()) {
                                        String str7 = (String) it.next();
                                        if (str7 != null) {
                                            str6 = str6 + str7 + " ";
                                        }
                                    }
                                    String trim = str6.trim();
                                    k.c("uppay", "encryptMac");
                                    String h10 = h(trim);
                                    k.c("uppay", "encryptMac result" + h10);
                                    if (h10 == null || h10.length() == 0) {
                                        this.f23757c.c();
                                        g11.putString("action_resp_code", ResultCode.ERROR_INTERFACE_GET_SMS_AUTH_CODE);
                                        return g11;
                                    }
                                    try {
                                        JSONObject jSONObject = new JSONObject();
                                        jSONObject.put("v", this.f23760f);
                                        jSONObject.put("cmd", "pay");
                                        JSONObject jSONObject2 = new JSONObject();
                                        jSONObject.put(Constant.KEY_PARAMS, jSONObject2);
                                        jSONObject2.put("pay_type", "2");
                                        jSONObject2.put("pay_mode", "1");
                                        jSONObject2.put("bind", "no");
                                        jSONObject2.put("carrier_tp", str2);
                                        jSONObject2.put("icc_data", f23755o.get("DCD"));
                                        jSONObject2.put("csn", f23755o.get("CSN"));
                                        jSONObject2.put("card_seq_id", f23755o.get("5F34") != null ? f23755o.get("5F34") : "");
                                        jSONObject2.put("submit_time", f23754m);
                                        jSONObject2.put("sp_id", "8889");
                                        jSONObject2.put(Constant.KEY_PIN, f23755o.get("PIN"));
                                        jSONObject2.put(Constant.KEY_PAN, f23755o.get("AN1"));
                                        jSONObject2.put("carrier_app_tp", "2");
                                        if (f23755o.get("ED") != null) {
                                            jSONObject2.put("expire", f23755o.get("ED"));
                                        }
                                        if (f23755o.get("TD2") != null) {
                                            jSONObject2.put("track2_data", f23755o.get("TD2"));
                                        }
                                        if (!(hashMap2 == null || hashMap2.keySet() == null || hashMap2.keySet().size() <= 0)) {
                                            hashMap2.remove(Constant.KEY_PAN);
                                            hashMap2.remove(Constant.KEY_PIN);
                                            for (String str8 : hashMap2.keySet()) {
                                                jSONObject2.put(str8, hashMap2.get(str8));
                                            }
                                        }
                                        String jSONObject3 = jSONObject.toString();
                                        k.c("uppay", jSONObject3);
                                        g11.putString("action_resp_message", this.f23758d.a(jSONObject3));
                                        this.f23757c.c();
                                        d();
                                        return g11;
                                    } catch (JSONException unused) {
                                        this.f23757c.c();
                                        g11.putString("action_resp_code", ResultCode.ERROR_INTERFACE_GET_SMS_AUTH_CODE);
                                        return g11;
                                    }
                                }
                                this.f23757c.c();
                                g11.putString("action_resp_code", ResultCode.ERROR_INTERFACE_GET_SMS_AUTH_CODE);
                                return g11;
                            }
                            this.f23757c.c();
                            g11.putString("action_resp_code", ResultCode.ERROR_INTERFACE_GET_SMS_AUTH_CODE);
                            return g11;
                        }
                        str4 = "action_resp_code";
                        str5 = ResultCode.ERROR_INTERFACE_GET_SMS_AUTH_CODE;
                        g11.putString(str4, str5);
                        if (g11.getString("action_resp_code") == "0000") {
                        }
                    }
                    str4 = "action_resp_code";
                    str5 = ResultCode.ERROR_INTERFACE_GET_SMS_AUTH_CODE;
                    g11.putString(str4, str5);
                    if (g11.getString("action_resp_code") == "0000") {
                    }
                }
                str4 = "action_resp_code";
                str5 = ResultCode.ERROR_INTERFACE_ECASH_TOPUP;
                g11.putString(str4, str5);
                if (g11.getString("action_resp_code") == "0000") {
                }
            }
            str4 = "action_resp_code";
            str5 = ResultCode.ERROR_INTERFACE_GET_SMS_AUTH_CODE;
            g11.putString(str4, str5);
            if (g11.getString("action_resp_code") == "0000") {
            }
        }
        str4 = "action_resp_code";
        str5 = ResultCode.ERROR_INTERFACE_GET_SMS_AUTH_CODE;
        g11.putString(str4, str5);
        if (g11.getString("action_resp_code") == "0000") {
        }
    }

    public final String a() {
        c cVar = this.f23757c;
        if (cVar instanceof f) {
            return cVar.a("A0000003334355502D4D4F42494C45");
        }
        this.f23761g = this.f23763i;
        return a(new byte[]{0, -92, 4, 0, 15, -96, 0, 0, 3, 51, 67, 85, 80, 45, 77, 79, 66, 73, 76, 69});
    }

    public final String a(int i10, String str) {
        String str2;
        this.f23761g = this.f23763i;
        if (Integer.toHexString(i10).length() == 1) {
            str2 = "0" + Integer.toHexString(i10);
        } else {
            str2 = Integer.toHexString(i10);
        }
        return a(e.a("80F802" + str2 + "08" + str + "80"));
    }

    public final synchronized String a(AppIdentification appIdentification) {
        String a10 = appIdentification.a();
        d();
        b(a10);
        String c10 = c(null);
        if (!(c10 == null || c10.length() == 0)) {
            String d10 = d(c10);
            if (!(d10 == null || d10.length() == 0)) {
                return f23755o.get("5A");
            }
            return null;
        }
        return null;
    }

    public final String a(String str) {
        this.f23757c.d();
        String b10 = b(str);
        this.f23757c.d();
        return a(b10, "84");
    }

    public final ArrayList<c> b() {
        this.f23757c.d();
        this.f23757c.b();
        ArrayList<c> a10 = this.f23757c.a(this);
        this.f23757c.c();
        return a10;
    }

    public final String c() {
        this.f23761g = this.f23763i;
        return a(e.a("80F2000102"));
    }
}
