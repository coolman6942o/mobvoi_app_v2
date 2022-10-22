package com.huawei.hms.scankit.p;

import android.text.TextUtils;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.scankit.F;
import com.huawei.hms.scankit.aiscan.common.x;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* compiled from: AddressBookDoCoMoResultParser.java */
/* renamed from: com.huawei.hms.scankit.p.db  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0577db extends AbstractC0619pb {

    /* renamed from: g  reason: collision with root package name */
    private static final Pattern f14774g = Pattern.compile("(?:MECARD:)([\\s\\S]+)", 2);

    private static HmsScan.PeopleName a(String str, String str2) {
        HmsScan.PeopleName peopleName = new HmsScan.PeopleName("", "", "", "", "", "", "");
        peopleName.spelling = str2;
        int indexOf = str.indexOf(",");
        if (indexOf < 0) {
            peopleName.fullName = str;
            String[] split = str.split(" ");
            if (split.length > 0) {
                peopleName.givenName = split[0];
            }
            if (split.length > 1) {
                peopleName.familyName = split[1];
            }
        } else {
            peopleName.familyName = str.substring(0, indexOf);
            int i10 = indexOf + 1;
            int indexOf2 = str.indexOf(",", i10);
            if (indexOf2 < 0) {
                peopleName.givenName = str.substring(i10);
            } else {
                peopleName.givenName = str.substring(i10, indexOf2);
            }
            peopleName.fullName = peopleName.givenName + " " + peopleName.familyName;
        }
        return peopleName;
    }

    private static HmsScan.TelPhoneNumber[] c(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return new HmsScan.TelPhoneNumber[0];
        }
        HmsScan.TelPhoneNumber[] telPhoneNumberArr = new HmsScan.TelPhoneNumber[strArr.length];
        for (int i10 = 0; i10 < strArr.length; i10++) {
            telPhoneNumberArr[i10] = new HmsScan.TelPhoneNumber(HmsScan.TelPhoneNumber.OTHER_USE_TYPE, strArr[i10]);
        }
        return telPhoneNumberArr;
    }

    @Override // com.huawei.hms.scankit.p.AbstractC0619pb
    public HmsScan b(x xVar) {
        String a10 = AbstractC0619pb.a(xVar);
        if (TextUtils.isEmpty(a10)) {
            return null;
        }
        Matcher matcher = f14774g.matcher(a10);
        if (!matcher.matches()) {
            return null;
        }
        String[] split = matcher.group(1).split("(?<=(?<!\\\\)(?:\\\\\\\\){0,100});");
        String a11 = a(split, "N:");
        if (a11.length() == 0) {
            return null;
        }
        String[] b10 = b(split, "TEL:");
        String[] b11 = b(split, "EMAIL:");
        String[] b12 = b(split, "ADR:");
        String[] b13 = b(split, "URL:");
        String a12 = a(split, "SOUND:");
        HmsScan.ContactDetail contactDetail = new HmsScan.ContactDetail(a(a11, a12), "", a(split, "ORG:"), c(b10), b(b11), a(b12), b13, a(split, "NOTE:"));
        return new HmsScan(xVar.g(), AbstractC0619pb.a(xVar.b()), contactDetail.peopleName.fullName, HmsScan.CONTACT_DETAIL_FORM, xVar.e(), AbstractC0619pb.a(xVar.f()), null, new F(contactDetail));
    }

    private static HmsScan.AddressInfo[] a(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return new HmsScan.AddressInfo[0];
        }
        HmsScan.AddressInfo[] addressInfoArr = new HmsScan.AddressInfo[strArr.length];
        for (int i10 = 0; i10 < strArr.length; i10++) {
            addressInfoArr[i10] = new HmsScan.AddressInfo(new String[]{strArr[i10]}, HmsScan.AddressInfo.OTHER_USE_TYPE);
        }
        return addressInfoArr;
    }

    private static String a(String[] strArr, String str) {
        for (String str2 : strArr) {
            if (str2.startsWith(str)) {
                return AbstractC0619pb.b(str2.substring(str.length()));
            }
        }
        return "";
    }

    private static HmsScan.EmailContent[] b(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return new HmsScan.EmailContent[0];
        }
        HmsScan.EmailContent[] emailContentArr = new HmsScan.EmailContent[strArr.length];
        for (int i10 = 0; i10 < strArr.length; i10++) {
            emailContentArr[i10] = new HmsScan.EmailContent(strArr[i10], "", "", HmsScan.EmailContent.OTHER_USE_TYPE);
        }
        return emailContentArr;
    }

    private static String[] b(String[] strArr, String str) {
        ArrayList arrayList = new ArrayList(5);
        for (String str2 : strArr) {
            if (str2.startsWith(str)) {
                arrayList.add(AbstractC0619pb.b(str2.substring(str.length())));
            }
        }
        return (String[]) arrayList.toArray(AbstractC0619pb.f14895f);
    }
}
