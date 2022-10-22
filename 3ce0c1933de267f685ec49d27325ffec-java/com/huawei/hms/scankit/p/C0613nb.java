package com.huawei.hms.scankit.p;

import android.text.TextUtils;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.scankit.F;
import com.huawei.hms.scankit.aiscan.common.x;
import java.util.regex.Pattern;
/* compiled from: MarketResultParser.java */
/* renamed from: com.huawei.hms.scankit.p.nb  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0613nb extends AbstractC0619pb {

    /* renamed from: g  reason: collision with root package name */
    private static final Pattern f14884g = Pattern.compile("market://[\\s\\S]*", 2);

    @Override // com.huawei.hms.scankit.p.AbstractC0619pb
    public HmsScan b(x xVar) {
        String a10 = AbstractC0619pb.a(xVar);
        if (TextUtils.isEmpty(a10) || !f14884g.matcher(a10).matches()) {
            return null;
        }
        return new HmsScan(xVar.g(), AbstractC0619pb.a(xVar.b()), a10, HmsScan.URL_FORM, xVar.e(), AbstractC0619pb.a(xVar.f()), null, new F(new HmsScan.LinkUrl("", "")));
    }
}
