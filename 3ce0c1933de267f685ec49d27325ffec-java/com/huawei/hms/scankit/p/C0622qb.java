package com.huawei.hms.scankit.p;

import android.text.TextUtils;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.scankit.F;
import com.huawei.hms.scankit.aiscan.common.x;
import java.util.regex.Pattern;
/* compiled from: SMSTOMMSTOResultParser.java */
/* renamed from: com.huawei.hms.scankit.p.qb  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0622qb extends AbstractC0619pb {

    /* renamed from: g  reason: collision with root package name */
    private static final Pattern f14915g = Pattern.compile("(?:mmsto|smsto):([\\s\\S]+)", 2);

    @Override // com.huawei.hms.scankit.p.AbstractC0619pb
    public HmsScan b(x xVar) {
        String str;
        String str2;
        String str3;
        String a10 = AbstractC0619pb.a(xVar);
        if (TextUtils.isEmpty(a10) || !f14915g.matcher(a10).matches()) {
            return null;
        }
        String substring = a10.substring(6);
        int indexOf = substring.indexOf(58);
        if (indexOf >= 0) {
            str = substring.substring(0, indexOf);
            str2 = substring.substring(indexOf + 1);
        } else {
            str2 = "";
            str = substring;
        }
        if (str2.isEmpty()) {
            str3 = str;
        } else {
            str3 = str + "\n" + str2;
        }
        return new HmsScan(xVar.g(), AbstractC0619pb.a(xVar.b()), str3, HmsScan.SMS_FORM, xVar.e(), AbstractC0619pb.a(xVar.f()), null, new F(new HmsScan.SmsContent(str2, str)));
    }
}
