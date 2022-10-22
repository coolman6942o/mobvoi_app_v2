package com.huawei.hms.scankit.p;

import android.text.TextUtils;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.scankit.F;
import com.huawei.hms.scankit.aiscan.common.x;
import com.tendcloud.tenddata.aa;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* compiled from: URIResultParser.java */
/* renamed from: com.huawei.hms.scankit.p.sb  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0627sb extends AbstractC0619pb {

    /* renamed from: g  reason: collision with root package name */
    private static final Pattern f14923g = Pattern.compile("(?:uri|url):([\\s\\S]*)", 2);

    /* renamed from: h  reason: collision with root package name */
    private static final Pattern f14924h = Pattern.compile("(?:http:/?(?!/)|http//)([\\s\\S]+)", 2);

    @Override // com.huawei.hms.scankit.p.AbstractC0619pb
    public HmsScan b(x xVar) {
        Matcher matcher;
        String a10 = AbstractC0619pb.a(xVar);
        if (TextUtils.isEmpty(a10) || !f14923g.matcher(a10).matches()) {
            return null;
        }
        String substring = a10.substring(4);
        if (f14924h.matcher(substring).matches()) {
            substring = substring.substring(0, 4) + aa.f22529a + matcher.group(1);
        }
        return new HmsScan(xVar.g(), AbstractC0619pb.a(xVar.b()), AbstractC0619pb.a(substring), HmsScan.URL_FORM, xVar.e(), AbstractC0619pb.a(xVar.f()), null, new F(new HmsScan.LinkUrl("", "")));
    }
}
