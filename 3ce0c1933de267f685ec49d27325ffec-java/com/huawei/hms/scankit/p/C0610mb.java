package com.huawei.hms.scankit.p;

import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.scankit.F;
import com.huawei.hms.scankit.aiscan.common.x;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* compiled from: LocationCoordinateResultParser.java */
/* renamed from: com.huawei.hms.scankit.p.mb  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C0610mb extends AbstractC0619pb {

    /* renamed from: g  reason: collision with root package name */
    private static final Pattern f14872g = Pattern.compile("geo:([\\s\\-0-9.]+),([\\s\\-0-9.]+)(?:[,?].*)?", 2);

    @Override // com.huawei.hms.scankit.p.AbstractC0619pb
    public HmsScan b(x xVar) {
        String a10 = AbstractC0619pb.a(xVar);
        Matcher matcher = f14872g.matcher(a10);
        if (!matcher.matches()) {
            return null;
        }
        try {
            return new HmsScan(xVar.g(), AbstractC0619pb.a(xVar.b()), a10, HmsScan.LOCATION_COORDINATE_FORM, xVar.e(), AbstractC0619pb.a(xVar.f()), null, new F(new HmsScan.LocationCoordinate(Double.parseDouble(matcher.group(1)), Double.parseDouble(matcher.group(2)))));
        } catch (NumberFormatException unused) {
            return null;
        }
    }
}
