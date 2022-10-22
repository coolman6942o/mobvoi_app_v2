package a3;

import cn.com.fmsh.FM_Exception;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.Arrays;
import x2.c;
import x2.d;
import x2.e;
import x2.f;
import z2.a;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    /* synthetic */ a f80a = null;

    private /* synthetic */ b() {
    }

    public static b a() {
        return new b();
    }

    public byte[] b(a aVar, int i10, DataInputStream dataInputStream) throws IOException {
        int a10;
        if (this.f80a == null) {
            this.f80a = z2.b.a().b();
        }
        if (aVar != null && (a10 = aVar.a(dataInputStream)) > 0) {
            if (i10 <= 0) {
                i10 = 5000;
            }
            byte[] bArr = new byte[a10];
            long currentTimeMillis = System.currentTimeMillis();
            int i11 = 0;
            while (i11 < a10) {
                if (System.currentTimeMillis() - currentTimeMillis >= i10) {
                    a aVar2 = this.f80a;
                    if (aVar2 != null) {
                        aVar2.a(x2.a.b("\u00063;?5(eJehlfi|", 4, 2), c.i("措厈敿捱跊早", 184, 48));
                    }
                    throw new IOException(d.c("坼捂富盃旮闽A", 1) + i10 + f.a("V再术控敩剬捞富锬延盉攺挩", 3));
                }
                i11 += dataInputStream.read(bArr, i11, a10 - i11);
            }
            return bArr;
        }
        return c(dataInputStream);
    }

    public byte[] c(DataInputStream dataInputStream) throws IOException {
        byte[] bArr = new byte[1024];
        int available = dataInputStream.available();
        a aVar = this.f80a;
        if (aVar != null) {
            String a10 = e.a(6, "\t;ban|hXrx}pzp");
            aVar.a(a10, FM_Exception.insert(154, 7, "ZdxrS/8:\"\u000e0978m'oc}jfpzs#w") + available);
        }
        byte[] bArr2 = null;
        while (true) {
            int read = dataInputStream.read(bArr);
            if (read <= 0) {
                return bArr2;
            }
            a aVar2 = this.f80a;
            if (aVar2 != null) {
                String a11 = e.a(144, "WmhkxbrR|ngjl~");
                aVar2.a(a11, c.i("51,wmjj1xrtztk<", 5, 3) + read);
            }
            if (bArr2 == null) {
                bArr2 = Arrays.copyOf(bArr, read);
            } else {
                c.s(bArr2, Arrays.copyOf(bArr, read));
            }
        }
    }
}
