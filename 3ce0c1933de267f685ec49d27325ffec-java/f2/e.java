package f2;

import cn.com.fmsh.communication.message.exception.FMCommunicationMessageException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import x2.c;
import x2.g;
/* loaded from: classes.dex */
public class e {

    /* loaded from: classes.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        private /* synthetic */ byte[] f26339a;

        /* renamed from: b  reason: collision with root package name */
        private /* synthetic */ byte[] f26340b;

        public a(e eVar, byte[] bArr, byte[] bArr2, byte[] bArr3) {
            this.f26339a = bArr;
            this.f26340b = bArr3;
        }

        public byte[] a() {
            return this.f26340b;
        }

        public byte[] b() {
            return this.f26339a;
        }
    }

    public static e a() {
        return new e();
    }

    public List<a> b(byte[] bArr, int i10) throws FMCommunicationMessageException {
        int read;
        byte[] bArr2;
        ArrayList arrayList = new ArrayList();
        if (i10 < 1) {
            throw new FMCommunicationMessageException(g.a(4, 31, "\u0000_D攡挾觬枞斻｀伫兯盍\u001c敷捨锺廢与吊沔"));
        } else if (bArr == null || bArr.length < i10 + 1) {
            throw new FMCommunicationMessageException(x2.a.b("\u0006\u0007\u0012攭挸覬柘斷６伳兩皁敮捹丝吁泗", 2, 121));
        } else {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            byte[] bArr3 = new byte[2];
            while (true) {
                byte[] bArr4 = new byte[i10];
                try {
                    if (byteArrayInputStream.read(bArr4) != -1 && (read = byteArrayInputStream.read()) >= 0) {
                        if (read != 0) {
                            if (read == 255) {
                                int read2 = byteArrayInputStream.read(bArr3);
                                byte[] bArr5 = {0, bArr3[0], bArr3[1]};
                                read = c.e(bArr5);
                                if (read2 == -1) {
                                    break;
                                }
                                bArr2 = bArr5;
                            } else {
                                bArr2 = new byte[]{(byte) read};
                            }
                            byte[] bArr6 = new byte[read];
                            byteArrayInputStream.read(bArr6);
                            arrayList.add(new a(this, bArr4, bArr2, bArr6));
                        }
                    }
                } catch (IOException unused) {
                }
            }
            return arrayList;
        }
    }
}
