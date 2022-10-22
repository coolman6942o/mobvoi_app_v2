package com.huawei.hms.scankit.p;

import android.text.TextUtils;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.scankit.F;
import com.huawei.hms.scankit.aiscan.common.x;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* compiled from: EmailContentAddressResultParser.java */
/* renamed from: com.huawei.hms.scankit.p.ib  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0597ib extends AbstractC0619pb {

    /* renamed from: g  reason: collision with root package name */
    private static final Pattern f14816g = Pattern.compile("(?:MATMSG:TO:|mailto:|SMTP:)([\\s\\S]+)", 2);

    /* renamed from: h  reason: collision with root package name */
    private static final Pattern f14817h = Pattern.compile("mailto:([\\s\\S]+)\\?subject=([\\s\\S]+)&body=([\\s\\S]+)", 2);

    /* renamed from: i  reason: collision with root package name */
    private static final Pattern f14818i = Pattern.compile("MATMSG:TO:([\\s\\S]+);SUB:([\\s\\S]+);BODY:([\\s\\S]+)", 2);

    /* renamed from: j  reason: collision with root package name */
    private static final Pattern f14819j = Pattern.compile("SMTP:([\\s\\S]+):([\\s\\S]+):([\\s\\S]+)", 2);

    static String c(String str) {
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return str;
        }
    }

    @Override // com.huawei.hms.scankit.p.AbstractC0619pb
    public HmsScan b(x xVar) {
        Matcher matcher;
        Matcher matcher2;
        Matcher matcher3;
        String str;
        String str2;
        String str3;
        String a10 = AbstractC0619pb.a(xVar);
        if (TextUtils.isEmpty(a10) || !f14816g.matcher(a10).matches()) {
            return null;
        }
        try {
            matcher = f14817h.matcher(a10);
            matcher2 = f14818i.matcher(a10);
            matcher3 = f14819j.matcher(a10);
        } catch (RuntimeException | Exception unused) {
        }
        if (matcher.matches()) {
            String group = matcher.group(1);
            str2 = matcher.group(2);
            str3 = matcher.group(3);
            str = group;
        } else if (matcher2.matches()) {
            String group2 = matcher2.group(1);
            String group3 = matcher2.group(2);
            String group4 = matcher2.group(3);
            str = group2;
            str2 = group3;
            str3 = group4;
        } else {
            if (matcher3.matches()) {
                String group5 = matcher3.group(1);
                str2 = matcher3.group(2);
                str = group5;
                str3 = matcher3.group(3);
            }
            return null;
        }
        return new HmsScan(xVar.g(), AbstractC0619pb.a(xVar.b()), str, HmsScan.EMAIL_CONTENT_FORM, xVar.e(), AbstractC0619pb.a(xVar.f()), null, new F(new HmsScan.EmailContent(str, c(str2), c(str3), HmsScan.EmailContent.OTHER_USE_TYPE)));
    }
}
