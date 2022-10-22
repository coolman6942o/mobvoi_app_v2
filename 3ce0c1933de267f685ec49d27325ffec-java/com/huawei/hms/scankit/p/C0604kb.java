package com.huawei.hms.scankit.p;

import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.scankit.F;
import com.huawei.hms.scankit.aiscan.common.x;
import com.tendcloud.tenddata.aa;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* compiled from: HTTPResultParser.java */
/* renamed from: com.huawei.hms.scankit.p.kb  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0604kb extends AbstractC0619pb {

    /* renamed from: g  reason: collision with root package name */
    private static final Pattern f14850g = Pattern.compile("(?:http:|http//|https://)([\\s\\S]+)", 2);

    /* renamed from: h  reason: collision with root package name */
    private static final Pattern f14851h = Pattern.compile("(?:http:/?(?!/)|http//)([\\s\\S]+)", 2);

    @Override // com.huawei.hms.scankit.p.AbstractC0619pb
    public HmsScan b(x xVar) {
        Matcher matcher;
        String a10 = AbstractC0619pb.a(xVar);
        if (!f14850g.matcher(a10).matches()) {
            return null;
        }
        if (f14851h.matcher(a10).matches()) {
            a10 = a10.substring(0, 4) + aa.f22529a + matcher.group(1);
        }
        String a11 = AbstractC0619pb.a(a10);
        if (a11.length() == 7) {
            return null;
        }
        return new HmsScan(xVar.g(), AbstractC0619pb.a(xVar.b()), a11, HmsScan.URL_FORM, xVar.e(), AbstractC0619pb.a(xVar.f()), null, new F(new HmsScan.LinkUrl("", a11)));
    }
}
