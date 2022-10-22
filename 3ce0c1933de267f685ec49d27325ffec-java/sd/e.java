package sd;

import com.laser.tsm.sdk.AppConfig;
import com.mobvoi.android.common.utils.b;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.wear.common.base.WearPath;
import n2.a;
import qd.o;
/* compiled from: ShanghaiApduHandler.java */
/* loaded from: classes2.dex */
public class e extends a {
    @Override // n2.a
    public void a() {
        o.k(b.e()).n();
        k.c("ShanghaiApduHandler", "disConnect() called , Thread %s", Thread.currentThread());
    }

    @Override // n2.a, cn.com.fmsh.script.ApduHandler
    public boolean b() {
        k.a("ShanghaiApduHandler", "connect: ");
        return o.k(b.e()).isConnected();
    }

    @Override // n2.a, cn.com.fmsh.script.ApduHandler
    public boolean c() {
        k.a("ShanghaiApduHandler", "isConnect: ");
        return false;
    }

    @Override // n2.a
    public byte[] g(byte[] bArr) {
        k.c("ShanghaiApduHandler", "transmit  apdu %s", mk.b.a(bArr));
        if (mk.a.d(bArr, mk.a.f30840e) && bArr.length == 5) {
            bArr = mk.b.b(AppConfig.APDU_SELECT);
            k.c("ShanghaiApduHandler", "transmit  apdu changed %s", mk.b.a(bArr));
        }
        byte[] d10 = o.k(b.e()).d(WearPath.TicPay.APDU, bArr);
        k.c("ShanghaiApduHandler", "transmit  res %s", mk.b.a(d10));
        return d10;
    }
}
