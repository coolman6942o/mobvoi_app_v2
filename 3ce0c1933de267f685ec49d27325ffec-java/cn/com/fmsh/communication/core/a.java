package cn.com.fmsh.communication.core;

import java.io.DataInputStream;
import java.io.IOException;
import x2.c;
import x2.g;
import z2.b;
/* loaded from: classes.dex */
public class a implements a3.a {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ z2.a f6063a = null;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ String f6064b = a.class.getName();

    @Override // a3.a
    public int a(DataInputStream dataInputStream) throws IOException {
        if (this.f6063a != null) {
            this.f6063a = b.a().b();
        }
        if (dataInputStream == null) {
            return -1;
        }
        int available = dataInputStream.available();
        z2.a aVar = this.f6063a;
        if (aVar != null) {
            String str = this.f6064b;
            aVar.a(str, g.a(3, 118, "\u0017(+4\u0002/gxwJ{w>0*}2?~|g`uafc") + available);
        }
        byte readByte = dataInputStream.readByte();
        byte readByte2 = dataInputStream.readByte();
        while (true) {
            if (readByte == (~readByte2)) {
                byte readByte3 = dataInputStream.readByte();
                byte readByte4 = dataInputStream.readByte();
                if (readByte2 == (readByte3 ^ readByte4)) {
                    return c.e(new byte[]{0, 0, readByte3, readByte4});
                }
            }
            readByte2 = dataInputStream.readByte();
            readByte = readByte2;
        }
    }

    @Override // a3.a
    public byte[] b(int i10) {
        byte[] n10 = c.n(i10, 2);
        byte[] bArr = {(byte) (~bArr[1]), (byte) (n10[0] ^ n10[1]), n10[0], n10[1]};
        return bArr;
    }
}
