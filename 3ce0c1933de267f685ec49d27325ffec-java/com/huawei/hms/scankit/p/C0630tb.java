package com.huawei.hms.scankit.p;

import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.scankit.F;
import com.huawei.hms.scankit.aiscan.common.x;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* compiled from: VCardResultParser.java */
/* renamed from: com.huawei.hms.scankit.p.tb  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0630tb extends AbstractC0619pb {

    /* renamed from: g  reason: collision with root package name */
    private static final Pattern f14928g = Pattern.compile("\r?\n[ \t]");

    /* renamed from: h  reason: collision with root package name */
    private static final Pattern f14929h = Pattern.compile(ContainerUtils.KEY_VALUE_DELIMITER);

    /* renamed from: i  reason: collision with root package name */
    private static final Pattern f14930i = Pattern.compile(";");

    /* renamed from: j  reason: collision with root package name */
    private static final Pattern f14931j = Pattern.compile("(?<!\\\\);+");

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00d3, code lost:
        r4 = r1;
        r3 = 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static List<List<String>> a(CharSequence charSequence, String str, boolean z10, boolean z11) {
        String str2;
        int i10;
        ArrayList arrayList;
        int indexOf;
        int i11;
        String str3;
        int length = str.length();
        int i12 = 0;
        int i13 = 0;
        ArrayList arrayList2 = null;
        while (i13 < length) {
            Matcher matcher = Pattern.compile("(?:^|\n)" + ((Object) charSequence) + "(?:;([^:\n(?![ |\t])]*))?:").matcher(str);
            if (i13 > 0) {
                i13--;
            }
            if (!matcher.find(i13)) {
                break;
            }
            int end = matcher.end(i12);
            String group = matcher.group(1);
            if (group != null) {
                String[] split = f14930i.split(group);
                int length2 = split.length;
                int i14 = i12;
                i10 = i14;
                arrayList = null;
                str2 = null;
                while (i14 < length2) {
                    String str4 = split[i14];
                    if (arrayList == null) {
                        arrayList = new ArrayList(1);
                    }
                    arrayList.add(str4);
                    String[] split2 = f14929h.split(str4, 2);
                    if (split2.length > 1) {
                        String str5 = split2[i12];
                        String str6 = split2[1];
                        if ("ENCODING".equalsIgnoreCase(str5) && "QUOTED-PRINTABLE".equalsIgnoreCase(str6)) {
                            i10 = 1;
                        } else if ("CHARSET".equalsIgnoreCase(str5)) {
                            str2 = str6;
                        } else {
                            "VALUE".equalsIgnoreCase(str5);
                        }
                    }
                    i14++;
                    i12 = 0;
                }
            } else {
                arrayList = null;
                i10 = 0;
                str2 = null;
            }
            int i15 = end;
            while (true) {
                indexOf = str.indexOf(10, i15);
                if (indexOf >= 0) {
                    if (indexOf < str.length() - 1) {
                        int i16 = indexOf + 1;
                        if (str.charAt(i16) == ' ' || str.charAt(i16) == '\t') {
                            i15 = indexOf + 2;
                        }
                    }
                    if (i10 == 0 || ((indexOf < 1 || str.charAt(indexOf - 1) != '=') && (indexOf < 2 || str.charAt(indexOf - 2) != '='))) {
                        break;
                    }
                    i15 = indexOf + 1;
                } else {
                    break;
                }
            }
            if (indexOf > end) {
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList(1);
                }
                if (indexOf >= 1 && str.charAt(indexOf - 1) == '\r') {
                    indexOf--;
                }
                String substring = str.substring(end, indexOf);
                if (z10) {
                    substring = substring.trim();
                }
                if (i10 != 0) {
                    str3 = a((CharSequence) substring, str2);
                    if (z11) {
                        str3 = f14931j.matcher(str3).replaceAll(" ").trim();
                    }
                } else {
                    if (z11) {
                        substring = f14931j.matcher(substring).replaceAll(" ").trim();
                    }
                    str3 = f14928g.matcher(substring).replaceAll("");
                }
                if (arrayList == null) {
                    ArrayList arrayList3 = new ArrayList(1);
                    arrayList3.add(str3);
                    arrayList2.add(arrayList3);
                } else {
                    i11 = 0;
                    arrayList.add(0, str3);
                    arrayList2.add(arrayList);
                    i13 = indexOf + 1;
                    i12 = i11;
                }
            }
            i11 = 0;
            i13 = indexOf + 1;
            i12 = i11;
        }
        return arrayList2;
    }

    private static HmsScan.TelPhoneNumber[] c(String[] strArr, String[] strArr2) {
        if (strArr.length != strArr2.length) {
            return new HmsScan.TelPhoneNumber[0];
        }
        HmsScan.TelPhoneNumber[] telPhoneNumberArr = new HmsScan.TelPhoneNumber[strArr.length];
        for (int i10 = 0; i10 < strArr.length; i10++) {
            int i11 = HmsScan.TelPhoneNumber.OTHER_USE_TYPE;
            HmsScan.TelPhoneNumber telPhoneNumber = new HmsScan.TelPhoneNumber(i11, strArr2[i10]);
            if (strArr[i10] != null) {
                if (strArr[i10].equals("WORK")) {
                    telPhoneNumber.useType = HmsScan.TelPhoneNumber.OFFICE_USE_TYPE;
                } else if (strArr[i10].equals("HOME")) {
                    telPhoneNumber.useType = HmsScan.TelPhoneNumber.RESIDENTIAL_USE_TYPE;
                } else if (strArr[i10].equals("CELL")) {
                    telPhoneNumber.useType = HmsScan.TelPhoneNumber.CELLPHONE_NUMBER_USE_TYPE;
                } else if (strArr[i10].equals("FAX")) {
                    telPhoneNumber.useType = HmsScan.TelPhoneNumber.FAX_USE_TYPE;
                } else {
                    telPhoneNumber.useType = i11;
                }
            }
            telPhoneNumberArr[i10] = telPhoneNumber;
        }
        return telPhoneNumberArr;
    }

    @Override // com.huawei.hms.scankit.p.AbstractC0619pb
    public HmsScan b(x xVar) {
        String a10 = AbstractC0619pb.a(xVar);
        if (!a10.startsWith("BEGIN:VCARD")) {
            return null;
        }
        String str = a10 + "\n";
        String b10 = b((CharSequence) "N", str, true, false);
        if (b10 == null || b10.isEmpty() || b10.split(";").length == 0) {
            return null;
        }
        String b11 = b((CharSequence) "FN", str, true, false);
        if (b11 == null || b11.isEmpty()) {
            b11 = c(b10);
        }
        String str2 = b11;
        List<List<String>> a11 = a((CharSequence) "TEL", str, true, false);
        List<List<String>> a12 = a((CharSequence) "EMAIL", str, true, false);
        List<List<String>> a13 = a((CharSequence) "ADR", str, true, true);
        return new HmsScan(xVar.g(), AbstractC0619pb.a(xVar.b()), str2, HmsScan.CONTACT_DETAIL_FORM, xVar.e(), AbstractC0619pb.a(xVar.f()), null, new F(new HmsScan.ContactDetail(a(b10, str2), b((CharSequence) "TITLE", str, true, false), b((CharSequence) "ORG", str, true, true), c(b(a11), a(a11)), b(b(a12), a(a12)), a(b(a13), a(a13)), a(a((CharSequence) "URL", str, true, false)), null)));
    }

    private static String c(String str) {
        int indexOf;
        if (str == null || str.isEmpty()) {
            return null;
        }
        String[] strArr = new String[5];
        int i10 = 0;
        int i11 = 0;
        while (i10 < 4 && (indexOf = str.indexOf(59, i11)) >= 0) {
            strArr[i10] = str.substring(i11, indexOf);
            i10++;
            i11 = indexOf + 1;
        }
        strArr[i10] = str.substring(i11);
        StringBuilder sb2 = new StringBuilder(100);
        a(strArr, 3, sb2);
        a(strArr, 1, sb2);
        a(strArr, 2, sb2);
        a(strArr, 0, sb2);
        a(strArr, 4, sb2);
        return sb2.toString().trim();
    }

    private static String b(CharSequence charSequence, String str, boolean z10, boolean z11) {
        List<List<String>> a10 = a(charSequence, str, z10, z11);
        String str2 = "";
        if (a10 != null && !a10.isEmpty()) {
            for (List<String> list : a10) {
                if (list.get(0) != null && !list.get(0).isEmpty()) {
                    str2 = list.get(0);
                }
            }
        }
        return str2;
    }

    private static String[] b(Collection<List<String>> collection) {
        if (collection == null || collection.isEmpty()) {
            return new String[0];
        }
        ArrayList arrayList = new ArrayList(collection.size());
        for (List<String> list : collection) {
            String str = list.get(0);
            if (str != null && !str.isEmpty()) {
                String str2 = null;
                int i10 = 1;
                while (true) {
                    if (i10 >= list.size()) {
                        break;
                    }
                    String str3 = list.get(i10);
                    int indexOf = str3.indexOf(61);
                    if (indexOf < 0) {
                        str2 = str3;
                        break;
                    } else if ("TYPE".equals(str3.substring(0, indexOf))) {
                        str2 = str3.substring(indexOf + 1);
                        break;
                    } else {
                        i10++;
                    }
                }
                arrayList.add(str2);
            }
        }
        return (String[]) arrayList.toArray(AbstractC0619pb.f14895f);
    }

    private static String a(CharSequence charSequence, String str) {
        char charAt;
        int length = charSequence.length();
        StringBuilder sb2 = new StringBuilder(length);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i10 = 0;
        while (i10 < length) {
            char charAt2 = charSequence.charAt(i10);
            if (!(charAt2 == '\n' || charAt2 == '\r')) {
                if (charAt2 != '=') {
                    a(byteArrayOutputStream, str, sb2);
                    sb2.append(charAt2);
                } else if (!(i10 >= length - 2 || (charAt = charSequence.charAt(i10 + 1)) == '\r' || charAt == '\n')) {
                    i10 += 2;
                    char charAt3 = charSequence.charAt(i10);
                    int a10 = AbstractC0619pb.a(charAt);
                    int a11 = AbstractC0619pb.a(charAt3);
                    if (a10 >= 0 && a11 >= 0) {
                        byteArrayOutputStream.write((a10 << 4) + a11);
                    }
                }
            }
            i10++;
        }
        a(byteArrayOutputStream, str, sb2);
        return sb2.toString();
    }

    private static HmsScan.EmailContent[] b(String[] strArr, String[] strArr2) {
        if (strArr.length != strArr2.length) {
            return new HmsScan.EmailContent[0];
        }
        HmsScan.EmailContent[] emailContentArr = new HmsScan.EmailContent[strArr.length];
        for (int i10 = 0; i10 < strArr.length; i10++) {
            HmsScan.EmailContent emailContent = new HmsScan.EmailContent(strArr2[i10], "", "", HmsScan.EmailContent.OTHER_USE_TYPE);
            if (strArr[i10] != null) {
                if (strArr[i10].equals("WORK")) {
                    emailContent.addressType = HmsScan.EmailContent.OFFICE_USE_TYPE;
                } else if (strArr[i10].equals("HOME")) {
                    emailContent.addressType = HmsScan.TelPhoneNumber.RESIDENTIAL_USE_TYPE;
                }
            }
            emailContentArr[i10] = emailContent;
        }
        return emailContentArr;
    }

    private static void a(ByteArrayOutputStream byteArrayOutputStream, String str, StringBuilder sb2) {
        String str2;
        if (byteArrayOutputStream.size() > 0) {
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (str == null) {
                str2 = new String(byteArray, StandardCharsets.UTF_8);
            } else {
                try {
                    str2 = new String(byteArray, str);
                } catch (UnsupportedEncodingException unused) {
                    str2 = new String(byteArray, StandardCharsets.UTF_8);
                }
            }
            byteArrayOutputStream.reset();
            sb2.append(str2);
        }
    }

    private static String[] a(Collection<List<String>> collection) {
        if (collection == null || collection.isEmpty()) {
            return new String[0];
        }
        ArrayList arrayList = new ArrayList(collection.size());
        for (List<String> list : collection) {
            String str = list.get(0);
            if (str != null && !str.isEmpty()) {
                arrayList.add(str);
            }
        }
        return (String[]) arrayList.toArray(AbstractC0619pb.f14895f);
    }

    private static HmsScan.PeopleName a(String str, String str2) {
        HmsScan.PeopleName peopleName = new HmsScan.PeopleName("", "", "", "", "", "", "");
        if (str != null) {
            String[] split = str.split(";");
            if (split.length > 0) {
                peopleName.familyName = split[0];
            }
            if (split.length > 1) {
                peopleName.givenName = split[1];
            }
            if (split.length > 2) {
                peopleName.middleName = split[2];
            }
            if (split.length > 3) {
                peopleName.namePrefix = split[3];
            }
            if (split.length > 4) {
                peopleName.nameSuffix = split[4];
            }
        }
        if (str2 != null) {
            peopleName.fullName = str2;
        }
        return peopleName;
    }

    private static HmsScan.AddressInfo[] a(String[] strArr, String[] strArr2) {
        if (strArr.length != strArr2.length) {
            return new HmsScan.AddressInfo[0];
        }
        HmsScan.AddressInfo[] addressInfoArr = new HmsScan.AddressInfo[strArr.length];
        for (int i10 = 0; i10 < strArr.length; i10++) {
            HmsScan.AddressInfo addressInfo = new HmsScan.AddressInfo(new String[]{strArr2[i10]}, HmsScan.AddressInfo.OTHER_USE_TYPE);
            if (strArr[i10] != null) {
                if (strArr[i10].equals("WORK")) {
                    addressInfo.addressType = HmsScan.AddressInfo.OFFICE_TYPE;
                } else if (strArr[i10].equals("HOME")) {
                    addressInfo.addressType = HmsScan.AddressInfo.RESIDENTIAL_USE_TYPE;
                }
            }
            addressInfoArr[i10] = addressInfo;
        }
        return addressInfoArr;
    }

    private static void a(String[] strArr, int i10, StringBuilder sb2) {
        if (strArr[i10] != null && !strArr[i10].isEmpty()) {
            if (sb2.length() > 0) {
                sb2.append(' ');
            }
            sb2.append(strArr[i10]);
        }
    }
}
