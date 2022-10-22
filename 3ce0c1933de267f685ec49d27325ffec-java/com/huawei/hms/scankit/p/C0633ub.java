package com.huawei.hms.scankit.p;

import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.scankit.F;
import com.huawei.hms.scankit.aiscan.common.x;
import java.util.List;
/* compiled from: VEventResultParser.java */
/* renamed from: com.huawei.hms.scankit.p.ub  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0633ub extends AbstractC0619pb {
    private static void a(String[] strArr, HmsScan.EventTime eventTime) {
        if (!(strArr == null || strArr.length == 0)) {
            for (String str : strArr) {
                C0601jb.a(str, eventTime);
            }
        }
    }

    @Override // com.huawei.hms.scankit.p.AbstractC0619pb
    public HmsScan b(x xVar) {
        String a10 = AbstractC0619pb.a(xVar);
        if (!a10.startsWith("BEGIN:VEVENT")) {
            return null;
        }
        String str = a10 + "\n";
        String a11 = a("SUMMARY", str, true);
        String a12 = a("LOCATION", str, true);
        String a13 = a("ORGANIZER", str, true);
        String a14 = a("DESCRIPTION", str, true);
        String a15 = a("STATUS", str, true);
        String[] b10 = b("DTSTART", str, true);
        String[] b11 = b("DTEND", str, true);
        HmsScan.EventTime eventTime = new HmsScan.EventTime(-1, -1, -1, -1, -1, -1, false, "");
        HmsScan.EventTime eventTime2 = new HmsScan.EventTime(-1, -1, -1, -1, -1, -1, false, "");
        a(b10, eventTime);
        a(b11, eventTime2);
        return new HmsScan(xVar.g(), AbstractC0619pb.a(xVar.b()), a11, HmsScan.EVENT_INFO_FORM, xVar.e(), AbstractC0619pb.a(xVar.f()), null, new F(new HmsScan.EventInfo(a11, eventTime, eventTime2, a12, a14, a13, a15)));
    }

    private static String a(CharSequence charSequence, String str, boolean z10) {
        List<List<String>> a10 = C0630tb.a(charSequence, str, z10, false);
        return (a10 == null || a10.isEmpty()) ? "" : a10.get(a10.size() - 1).get(0);
    }

    private static String[] b(CharSequence charSequence, String str, boolean z10) {
        List<List<String>> a10 = C0630tb.a(charSequence, str, z10, false);
        if (a10 == null || a10.isEmpty()) {
            return new String[0];
        }
        int size = a10.size();
        String[] strArr = new String[size];
        for (int i10 = 0; i10 < size; i10++) {
            strArr[i10] = a10.get(i10).get(0);
        }
        return strArr;
    }
}
