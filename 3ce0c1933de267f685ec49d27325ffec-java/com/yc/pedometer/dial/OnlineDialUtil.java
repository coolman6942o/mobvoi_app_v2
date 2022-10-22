package com.yc.pedometer.dial;

import com.mobvoi.wear.msgproxy.MessageProxyConstants;
import gn.u;
import gn.z;
/* loaded from: classes2.dex */
public class OnlineDialUtil {

    /* renamed from: b  reason: collision with root package name */
    private static OnlineDialUtil f24596b = null;

    /* renamed from: c  reason: collision with root package name */
    public static int f24597c = 20;

    /* renamed from: a  reason: collision with root package name */
    private DialStatus f24598a = DialStatus.RegularDial;

    /* loaded from: classes2.dex */
    public enum DialStatus {
        CustomDial,
        RegularDial
    }

    private OnlineDialUtil() {
    }

    public static void a(String str) {
        u.a("OnlineDialUtil", str);
    }

    public static void b(String str) {
        u.d("OnlineDialUtil", str);
    }

    private int c(byte[] bArr) {
        if (bArr.length > 15) {
            return bArr[15] & 255;
        }
        return 0;
    }

    private int d(byte[] bArr) {
        return ((bArr[11] << 24) & (-16777216)) | (bArr[14] & 255) | ((bArr[13] << 8) & 65280) | ((bArr[12] << 16) & 16711680);
    }

    private int e(StringBuilder sb2, byte[] bArr) {
        if (sb2.substring(4, 12).equals("FFFFFFFF")) {
            a("表示当前没有显示的在线表盘");
            return -1;
        }
        return (bArr[5] & 255) | ((bArr[4] << 8) & 65280) | ((bArr[3] << 16) & 16711680) | ((bArr[2] << 24) & (-16777216));
    }

    private int f(byte[] bArr) {
        return ((bArr[8] << 8) & 65280) | (bArr[9] & 255);
    }

    private int g(byte[] bArr) {
        return ((bArr[6] << 8) & 65280) | (bArr[7] & 255);
    }

    private int h(byte[] bArr) {
        return bArr[10] & 255;
    }

    public static OnlineDialUtil j() {
        if (f24596b == null) {
            f24596b = new OnlineDialUtil();
        }
        return f24596b;
    }

    public DialStatus i() {
        return this.f24598a;
    }

    public void k(StringBuilder sb2, byte[] bArr, z zVar) {
        int e10 = e(sb2, bArr);
        int g10 = g(bArr);
        int f10 = f(bArr);
        int h10 = h(bArr);
        int d10 = d(bArr);
        int c10 = c(bArr);
        zVar.k0(e10);
        zVar.I0(g10 + MessageProxyConstants.NODE_ID_ANY + f10);
        zVar.m0(h10);
        zVar.j0(d10 + "");
        zVar.l0(c10);
        a("dialNumber =" + e10 + ",resolutionWidth =" + g10 + ",resolutionHeight =" + f10 + ",dialScreenType =" + h10 + ",dialMaxDataSize =" + d10 + ",compatible =" + c10);
    }

    public void l(DialStatus dialStatus) {
        this.f24598a = dialStatus;
    }
}
