package ka;

import java.util.Arrays;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import kotlin.text.d;
/* compiled from: BlePacket.kt */
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final int f29828a;

    /* renamed from: b  reason: collision with root package name */
    private final int f29829b;

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f29830c;

    public a(int i10, int i11, byte[] bArr) {
        this.f29828a = i10;
        this.f29829b = i11;
        this.f29830c = bArr;
    }

    public final int a() {
        return this.f29829b;
    }

    public final int b() {
        return this.f29828a;
    }

    public final byte[] c() {
        return this.f29830c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f29828a == aVar.f29828a && this.f29829b == aVar.f29829b && i.b(this.f29830c, aVar.f29830c);
    }

    public int hashCode() {
        int i10 = ((this.f29828a * 31) + this.f29829b) * 31;
        byte[] bArr = this.f29830c;
        return i10 + (bArr == null ? 0 : Arrays.hashCode(bArr));
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[");
        sb2.append(i.n("commandId=", Integer.valueOf(this.f29829b)));
        if (this.f29830c != null) {
            sb2.append(",");
            sb2.append(i.n("data=", new String(c(), d.f30092a)));
        }
        sb2.append("]");
        String sb3 = sb2.toString();
        i.e(sb3, "builder.toString()");
        return sb3;
    }

    public /* synthetic */ a(int i10, int i11, byte[] bArr, int i12, f fVar) {
        this((i12 & 1) != 0 ? 2062 : i10, i11, bArr);
    }
}
