package ea;

import com.mobvoi.apollo.client.c0;
import com.realsil.sdk.dfu.DfuException;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
/* compiled from: DialListener.kt */
/* loaded from: classes2.dex */
public abstract class a extends c0 {

    /* compiled from: DialListener.kt */
    /* renamed from: ea.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0280a {
        private C0280a() {
        }

        public /* synthetic */ C0280a(f fVar) {
            this();
        }
    }

    static {
        new C0280a(null);
    }

    public a() {
        super(Integer.valueOf((int) DfuException.ERROR_FILE_IO_EXCEPTION));
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0011, code lost:
        if (r4[0] == 0) goto L13;
     */
    @Override // com.mobvoi.apollo.client.c0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m(byte[] bArr) {
        boolean z10;
        if (bArr != null) {
            z10 = true;
            if (!(bArr.length == 0)) {
            }
        }
        z10 = false;
        if (z10) {
            p();
            return;
        }
        i.d(bArr);
        l(bArr[0]);
    }

    public abstract void p();
}
