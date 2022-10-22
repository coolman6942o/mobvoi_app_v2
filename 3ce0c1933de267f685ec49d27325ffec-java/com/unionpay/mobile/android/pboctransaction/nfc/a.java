package com.unionpay.mobile.android.pboctransaction.nfc;

import android.text.TextUtils;
import android.util.Log;
import com.unionpay.mobile.android.pboctransaction.e;
import com.unionpay.mobile.android.pboctransaction.nfc.b;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: d  reason: collision with root package name */
    protected static final byte[] f23778d = {50, 80, 65, 89, 46, 83, 89, 83, 46, 68, 68, 70, 48, 49};

    /* renamed from: a  reason: collision with root package name */
    protected String f23779a = "UnionPay Card";

    /* renamed from: b  reason: collision with root package name */
    com.unionpay.mobile.android.fully.a f23780b;

    /* renamed from: c  reason: collision with root package name */
    b.C0264b f23781c;

    public a(com.unionpay.mobile.android.fully.a aVar, b.C0264b bVar) {
        this.f23780b = aVar;
        this.f23781c = bVar;
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

    private static List<String> a(String str) {
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

    public static void b(String str, HashMap<String, String> hashMap) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("82");
        arrayList.add("9F36");
        arrayList.add("9F10");
        arrayList.add("9F26");
        arrayList.add("5F34");
        arrayList.add("57");
        arrayList.add("9F63");
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            try {
                String str2 = (String) arrayList.get(i10);
                String a10 = a(str, str2);
                if (a10 != null) {
                    hashMap.put(str2, a10);
                }
            } catch (Exception e10) {
                e10.printStackTrace();
                return;
            }
        }
        StringBuffer stringBuffer = new StringBuffer(hashMap.get("5F34"));
        stringBuffer.insert(0, "0");
        hashMap.put("5F34", stringBuffer.toString());
        String str3 = hashMap.get("57");
        while (true) {
            if (!str3.substring(str3.length() - 1, str3.length()).equalsIgnoreCase("f") && !str3.substring(str3.length() - 1, str3.length()).equalsIgnoreCase("F")) {
                break;
            }
            str3 = str3.substring(0, str3.length() - 1);
        }
        hashMap.put("TD2", str3);
        int indexOf = str3.indexOf("D");
        String substring = str3.substring(0, indexOf);
        if (substring.endsWith("F") || substring.endsWith("f")) {
            substring = substring.substring(0, substring.length() - 1);
        }
        hashMap.put("AN1", substring);
        hashMap.put("ED", str3.substring(indexOf + 1, indexOf + 5));
        hashMap.put("AMT", hashMap.get("9F02"));
        if (hashMap.containsKey("9F10") && ((byte) (e.a(hashMap.get("9F10"))[4] & 48)) == 32) {
            hashMap.put("9F27", "80");
        }
    }

    public final String a() {
        b.a a10 = this.f23781c.a(f23778d);
        if (!a10.b()) {
            return null;
        }
        String a11 = a(a10.toString(), "4F");
        if (!a11.startsWith("A000000333")) {
            return "noSupUnionpay";
        }
        b.a a12 = this.f23781c.a(e.a(a11));
        if (!a12.b()) {
            return null;
        }
        return a12.toString();
    }

    public final String a(String str, HashMap<String, String> hashMap) {
        String a10 = a(str, "9F38");
        StringBuffer stringBuffer = new StringBuffer();
        for (String str2 : a(a10)) {
            Iterator<String> it = hashMap.keySet().iterator();
            while (true) {
                if (it.hasNext()) {
                    String next = it.next();
                    if (str2.compareToIgnoreCase(next) == 0) {
                        stringBuffer.append(hashMap.get(next));
                        break;
                    }
                }
            }
        }
        b.C0264b bVar = this.f23781c;
        byte[] a11 = e.a(stringBuffer.toString());
        ByteBuffer allocate = ByteBuffer.allocate(a11.length + 7);
        allocate.put(Byte.MIN_VALUE).put((byte) -88).put((byte) 0).put((byte) 0).put((byte) (a11.length + 2)).put((byte) -125).put((byte) a11.length).put(a11);
        Log.e("PBOC Transceive", b.C0264b.c(allocate.array()));
        b.a aVar = new b.a(bVar.b(allocate.array()));
        Log.e("PBOC receive", b.C0264b.c(aVar.a()));
        if (!aVar.b()) {
            return null;
        }
        String a12 = a(aVar.toString(), "9F10");
        if (TextUtils.isEmpty(a12) || ((byte) (e.a(a12)[4] & 48)) == 32) {
            return aVar.toString();
        }
        return null;
    }
}
