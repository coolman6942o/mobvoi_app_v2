package n2;

import android.util.Log;
import cn.com.fmsh.script.ApduHandler;
import java.util.Arrays;
import x2.c;
/* compiled from: ApduExternalHandler.java */
/* loaded from: classes.dex */
public abstract class a implements ApduHandler {

    /* renamed from: c  reason: collision with root package name */
    private static final byte[] f31006c = {0, -92, 4, 0, 9};

    /* renamed from: d  reason: collision with root package name */
    private static final String f31007d = "n2.a";

    /* renamed from: a  reason: collision with root package name */
    private volatile byte[] f31008a = null;

    /* renamed from: b  reason: collision with root package name */
    private volatile boolean f31009b = false;

    public abstract void a();

    @Override // cn.com.fmsh.script.ApduHandler
    public abstract boolean b();

    @Override // cn.com.fmsh.script.ApduHandler
    public abstract boolean c();

    @Override // cn.com.fmsh.script.ApduHandler
    public void close() {
        System.out.println("close");
        this.f31008a = null;
        this.f31009b = false;
        a();
    }

    @Override // cn.com.fmsh.script.ApduHandler
    public byte[] d(byte[] bArr) {
        byte[] bArr2;
        if (this.f31008a == null || this.f31009b) {
            bArr2 = null;
        } else {
            String str = f31007d;
            Log.i(str, "  OPEN->" + c.c(this.f31008a));
            bArr2 = g(this.f31008a);
            Log.i(str, "  OPEN<-" + c.c(bArr2));
            this.f31009b = c.q(bArr2);
            if (!this.f31009b) {
                return bArr2;
            }
        }
        String str2 = f31007d;
        Log.i(str2, "HANDLE->" + c.c(bArr));
        if (this.f31008a == null) {
            bArr2 = g(bArr);
        } else if (!Arrays.equals(bArr, this.f31008a) && this.f31009b) {
            bArr2 = g(bArr);
        }
        Log.i(str2, "HANDLE<-" + c.c(bArr2));
        return bArr2;
    }

    @Override // cn.com.fmsh.script.ApduHandler
    public boolean e(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        byte[] bArr2 = (byte[]) f31006c.clone();
        bArr2[4] = (byte) (bArr.length & 255);
        this.f31008a = c.j(bArr2, bArr);
        return true;
    }

    @Override // cn.com.fmsh.script.ApduHandler
    public ApduHandler.ApduHandlerType f() {
        return ApduHandler.ApduHandlerType.BLUETOOTH;
    }

    public abstract byte[] g(byte[] bArr);
}
