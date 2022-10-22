package cn.com.fmsh.communication.core;

import cn.com.fmsh.communication.exception.session.OpenSessionException;
import x2.h;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ byte[] f6065a = new byte[8];

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ byte[] f6066b = new byte[4];

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ byte[] f6067c = new byte[16];

    /* renamed from: d  reason: collision with root package name */
    private /* synthetic */ byte[] f6068d = new byte[4];

    public void a(byte[] bArr) throws OpenSessionException {
        if (bArr != null) {
            if (bArr.length == 32) {
                for (int i10 = 0; i10 < 8; i10++) {
                    this.f6065a[i10] = bArr[i10 + 0];
                }
                for (int i11 = 0; i11 < 4; i11++) {
                    this.f6066b[i11] = bArr[i11 + 8];
                }
                for (int i12 = 0; i12 < 16; i12++) {
                    this.f6067c[i12] = bArr[i12 + 12];
                }
                for (int i13 = 0; i13 < 4; i13++) {
                    this.f6068d[i13] = bArr[i13 + 28];
                }
                return;
            }
            throw new OpenSessionException(h.e("签剬咕廀攠挢锷廢乍呔沍", 3, 124));
        }
    }

    public byte[] b() {
        return this.f6068d;
    }

    public byte[] c() {
        return this.f6067c;
    }

    public byte[] d() {
        return this.f6066b;
    }

    public byte[] e() {
        return this.f6065a;
    }
}
