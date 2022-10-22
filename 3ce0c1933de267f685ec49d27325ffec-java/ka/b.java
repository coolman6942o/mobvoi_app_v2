package ka;

import android.annotation.SuppressLint;
import com.mobvoi.android.common.utils.k;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import kotlin.collections.h;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
/* compiled from: DataParser.kt */
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final AbstractC0367b f29831a;

    /* renamed from: b  reason: collision with root package name */
    private int f29832b;

    /* renamed from: c  reason: collision with root package name */
    private int f29833c;

    /* renamed from: d  reason: collision with root package name */
    private int f29834d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f29835e = true;

    /* renamed from: f  reason: collision with root package name */
    private final ArrayList<byte[]> f29836f = new ArrayList<>();

    /* compiled from: DataParser.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* compiled from: DataParser.kt */
    /* renamed from: ka.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface AbstractC0367b {
        void b(ka.a aVar);
    }

    static {
        new a(null);
    }

    public b(AbstractC0367b bVar) {
        this.f29831a = bVar;
    }

    private final void a(byte[] bArr) {
        if (!this.f29835e) {
            oa.b bVar = oa.b.f31485a;
            if (bVar.b(bArr, 0) == 2062) {
                if (!this.f29836f.isEmpty()) {
                    k.q("DataParser", i.n("data length error: ", bVar.a(e(this.f29836f))));
                }
                d();
            }
        }
    }

    private final void b(int i10, byte[] bArr) {
        ka.a aVar = new ka.a(0, i10, bArr, 1, null);
        AbstractC0367b bVar = this.f29831a;
        if (bVar != null) {
            bVar.b(aVar);
        }
    }

    private final byte[] e(ArrayList<byte[]> arrayList) {
        byte[] bArr = new byte[0];
        for (byte[] bArr2 : arrayList) {
            bArr = h.k(bArr, bArr2);
        }
        return bArr;
    }

    @SuppressLint({"BinaryOperationInTimber"})
    public final void c(byte[] data) {
        byte[] g10;
        byte[] g11;
        i.f(data, "data");
        if (com.mobvoi.apollo.protocol.ble.b.f15583a.a()) {
            k.a("DataParser", "parse data, receivedLength = " + this.f29833c + ", totalLength = " + this.f29834d + ", isHeader = " + this.f29835e + ", data = " + oa.b.f31485a.a(data));
        }
        a(data);
        if (!this.f29835e) {
            this.f29836f.add(data);
            int length = this.f29833c + data.length;
            this.f29833c = length;
            if (length == this.f29834d) {
                b(this.f29832b, e(this.f29836f));
                d();
                return;
            }
            return;
        }
        ByteBuffer order = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        short s10 = order.getShort();
        short s11 = order.getShort();
        short s12 = order.getShort();
        if (s10 == 2062) {
            if (data.length - 6 == s12) {
                g11 = h.g(data, 6, data.length);
                b(s11, g11);
                return;
            }
            this.f29835e = false;
            this.f29832b = s11;
            this.f29834d = s12;
            ArrayList<byte[]> arrayList = this.f29836f;
            g10 = h.g(data, 6, data.length);
            arrayList.add(g10);
            this.f29833c = data.length - 6;
        }
    }

    public final void d() {
        this.f29832b = 0;
        this.f29833c = 0;
        this.f29834d = 0;
        this.f29835e = true;
        this.f29836f.clear();
    }
}
