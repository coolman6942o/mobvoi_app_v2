package nj;

import com.mobvoi.mcuwatch.engine.f;
import com.mobvoi.mcuwatch.engine.u;
import kotlin.jvm.internal.i;
/* compiled from: NotificationBinTransfer.kt */
/* loaded from: classes2.dex */
public final class r {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f31286a;

    /* renamed from: b  reason: collision with root package name */
    private int f31287b;

    /* renamed from: c  reason: collision with root package name */
    private int f31288c = 4096;

    /* renamed from: d  reason: collision with root package name */
    private int f31289d;

    /* renamed from: e  reason: collision with root package name */
    private int f31290e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f31291f;

    public r(byte[] data) {
        i.f(data, "data");
        this.f31286a = data;
        this.f31287b = data.length;
    }

    public static /* synthetic */ void d(r rVar, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        rVar.c(z10);
    }

    public final void a() {
        if (this.f31291f) {
            c(true);
        }
    }

    public final void b() {
        this.f31287b = this.f31286a.length;
        this.f31288c = 4096;
        this.f31289d = 0;
        this.f31290e = 0;
        this.f31291f = false;
    }

    public final void c(boolean z10) {
        byte[] bArr;
        if (z10) {
            this.f31290e -= this.f31289d;
        }
        int i10 = this.f31287b;
        int i11 = this.f31288c;
        if (i10 > i11) {
            bArr = new byte[i11];
        } else {
            bArr = new byte[i10];
        }
        int length = bArr.length;
        this.f31289d = length;
        System.arraycopy(this.f31286a, this.f31290e, bArr, 0, length);
        this.f31291f = true;
        f.f(u.f19202a, this.f31290e, bArr);
        this.f31290e += this.f31289d;
    }

    public final void e() {
        int length = this.f31286a.length - this.f31290e;
        this.f31287b = length;
        if (length > 0) {
            d(this, false, 1, null);
        } else {
            f.g(u.f19202a);
        }
    }
}
