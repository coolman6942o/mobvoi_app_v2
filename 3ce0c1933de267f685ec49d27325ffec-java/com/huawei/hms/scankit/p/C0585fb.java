package com.huawei.hms.scankit.p;

import android.text.TextUtils;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.scankit.F;
import com.huawei.hms.scankit.aiscan.common.x;
import com.tendcloud.tenddata.aa;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* compiled from: BookmarkDoCoMoResultParser.java */
/* renamed from: com.huawei.hms.scankit.p.fb  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0585fb extends AbstractC0619pb {

    /* renamed from: g  reason: collision with root package name */
    private static final Pattern f14790g = Pattern.compile("(?:MEBKM:)([\\s\\S]+)", 2);

    /* renamed from: h  reason: collision with root package name */
    private static final Pattern f14791h = Pattern.compile("(?:http:/?(?!/)|http//)([\\s\\S]+)", 2);

    private static String a(String[] strArr, String str) {
        for (String str2 : strArr) {
            if (str2.startsWith(str)) {
                return AbstractC0619pb.b(str2.substring(str.length()));
            }
        }
        return "";
    }

    @Override // com.huawei.hms.scankit.p.AbstractC0619pb
    public HmsScan b(x xVar) {
        Matcher matcher;
        String a10 = AbstractC0619pb.a(xVar);
        if (TextUtils.isEmpty(a10)) {
            return null;
        }
        Matcher matcher2 = f14790g.matcher(a10);
        if (!matcher2.matches()) {
            return null;
        }
        String[] split = matcher2.group(1).split("(?<=(?<!\\\\)(?:\\\\\\\\){0,100});");
        String a11 = a(split, "TITLE:");
        String a12 = AbstractC0619pb.a(a(split, "URL:"));
        if (a12.length() == 0) {
            return null;
        }
        if (f14791h.matcher(a12).matches()) {
            a12 = a12.substring(0, 4) + aa.f22529a + matcher.group(1);
        }
        String str = a12;
        return new HmsScan(xVar.g(), AbstractC0619pb.a(xVar.b()), str, HmsScan.URL_FORM, xVar.e(), AbstractC0619pb.a(xVar.f()), null, new F(new HmsScan.LinkUrl(a11, str)));
    }
}
