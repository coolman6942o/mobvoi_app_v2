package m2;

import x2.c;
/* compiled from: TagUitl.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static int f30601a = 255;

    public static byte[] a(byte b10, byte[] bArr) {
        if (bArr == null) {
            return new byte[0];
        }
        int length = bArr.length;
        return c.j(new byte[]{b10}, length > f30601a ? new byte[]{-1, (byte) ((65280 & length) >> 8), (byte) (length & 255)} : new byte[]{(byte) (length & 255)}, bArr);
    }
}
