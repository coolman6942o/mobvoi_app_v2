package com.unionpay.mobile.android.pboctransaction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes2.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    static HashMap<String, String> f23770a = new f();

    private static String a(String str, String str2) {
        if (str != null && str.length() > str2.length()) {
            while (str.substring(str.length() - str2.length(), str.length()).equalsIgnoreCase(str2)) {
                str = str.substring(0, str.length() - str2.length());
            }
        }
        return str;
    }

    public static final String a(byte[] bArr) {
        return a(bArr, bArr.length);
    }

    public static final String a(byte[] bArr, int i10) {
        StringBuilder sb2 = new StringBuilder("");
        if (bArr == null || i10 <= 0) {
            return null;
        }
        for (int i11 = 0; i11 < i10; i11++) {
            String hexString = Integer.toHexString(bArr[i11] & 255);
            if (hexString.length() < 2) {
                sb2.append(0);
            }
            sb2.append(hexString);
        }
        return sb2.toString().toUpperCase();
    }

    private static boolean a(ArrayList<AppIdentification> arrayList, String str) {
        if (str == null) {
            return false;
        }
        Iterator<AppIdentification> it = arrayList.iterator();
        while (it.hasNext()) {
            if (it.next().a().equalsIgnoreCase(str)) {
                return false;
            }
        }
        return true;
    }

    public static final byte[] a(String str) {
        if (str == null || str.equals("")) {
            return null;
        }
        String upperCase = str.toUpperCase();
        int length = upperCase.length() / 2;
        char[] charArray = upperCase.toCharArray();
        byte[] bArr = new byte[length];
        for (int i10 = 0; i10 < length; i10++) {
            int i11 = i10 * 2;
            bArr[i10] = (byte) (((byte) "0123456789ABCDEF".indexOf(charArray[i11 + 1])) | (((byte) "0123456789ABCDEF".indexOf(charArray[i11])) << 4));
        }
        return bArr;
    }

    public static final ArrayList<AppIdentification> b(String str) {
        if (str == null || str.length() <= 4) {
            return null;
        }
        ArrayList<AppIdentification> arrayList = new ArrayList<>();
        String substring = str.substring(str.length() - 4);
        if (substring != null && substring.equalsIgnoreCase("9000")) {
            int i10 = 0;
            String substring2 = str.substring(0, str.length() - 4);
            while (substring2 != null && substring2.length() > 0 && i10 != -1) {
                int indexOf = substring2.indexOf("61", i10);
                if (indexOf == -1) {
                    break;
                }
                int i11 = indexOf + 2;
                int i12 = indexOf + 4;
                String substring3 = substring2.substring(i11, i12);
                int i13 = indexOf + 6;
                String substring4 = substring2.substring(i12, i13);
                String substring5 = (Integer.parseInt(substring4, 16) * 2) + i13 < substring2.length() ? substring2.substring(i13, (Integer.parseInt(substring4, 16) * 2) + i13) : "";
                int parseInt = (Integer.parseInt(substring3, 16) * 2) + i11;
                if (parseInt <= substring2.length()) {
                    i11 = parseInt;
                }
                String trim = substring5.trim();
                if (trim.length() > 8 && !trim.equalsIgnoreCase("A0000003334355502D4D4F42494C45") && a(arrayList, trim)) {
                    arrayList.add(new AppIdentification(trim, null));
                }
                i10 = i11;
            }
        }
        return arrayList;
    }

    public static String c(String str) {
        return a(str, "F");
    }

    public static String d(String str) {
        return a(str, "00");
    }

    public static String e(String str) {
        return f23770a.containsKey(str) ? f23770a.get(str) : "";
    }
}
