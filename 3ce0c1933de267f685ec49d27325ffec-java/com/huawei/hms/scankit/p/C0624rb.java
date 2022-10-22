package com.huawei.hms.scankit.p;

import android.text.TextUtils;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.scankit.F;
import com.huawei.hms.scankit.aiscan.common.x;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* compiled from: TelPhoneNumberResultParser.java */
/* renamed from: com.huawei.hms.scankit.p.rb  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0624rb extends AbstractC0619pb {

    /* renamed from: g  reason: collision with root package name */
    private static final Pattern f14918g = Pattern.compile("tel:([\\s\\S]+)", 2);

    @Override // com.huawei.hms.scankit.p.AbstractC0619pb
    public HmsScan b(x xVar) {
        String a10 = AbstractC0619pb.a(xVar);
        if (TextUtils.isEmpty(a10)) {
            return null;
        }
        Matcher matcher = f14918g.matcher(a10);
        if (!matcher.matches()) {
            return null;
        }
        String group = matcher.group(1);
        return new HmsScan(xVar.g(), AbstractC0619pb.a(xVar.b()), group, HmsScan.TEL_PHONE_NUMBER_FORM, xVar.e(), AbstractC0619pb.a(xVar.f()), null, new F(new HmsScan.TelPhoneNumber(HmsScan.TelPhoneNumber.OTHER_USE_TYPE, group)));
    }
}
