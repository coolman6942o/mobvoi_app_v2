package okhttp3.internal.http2;

import androidx.recyclerview.widget.g;
import gp.b;
import java.io.IOException;
import kotlin.collections.h;
import kotlin.jvm.internal.i;
import okio.ByteString;
import okio.d;
import okio.e;
/* compiled from: Huffman.kt */
/* loaded from: classes3.dex */
public final class f {

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f32174b;

    /* renamed from: d  reason: collision with root package name */
    public static final f f32176d;

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f32173a = {8184, 8388568, 268435426, 268435427, 268435428, 268435429, 268435430, 268435431, 268435432, 16777194, 1073741820, 268435433, 268435434, 1073741821, 268435435, 268435436, 268435437, 268435438, 268435439, 268435440, 268435441, 268435442, 1073741822, 268435443, 268435444, 268435445, 268435446, 268435447, 268435448, 268435449, 268435450, 268435451, 20, 1016, 1017, 4090, 8185, 21, 248, 2042, 1018, 1019, 249, 2043, g.f.DEFAULT_SWIPE_ANIMATION_DURATION, 22, 23, 24, 0, 1, 2, 25, 26, 27, 28, 29, 30, 31, 92, 251, 32764, 32, 4091, 1020, 8186, 33, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 252, 115, 253, 8187, 524272, 8188, 16380, 34, 32765, 3, 35, 4, 36, 5, 37, 38, 39, 6, 116, 117, 40, 41, 42, 7, 43, 118, 44, 8, 9, 45, 119, 120, 121, 122, 123, 32766, 2044, 16381, 8189, 268435452, 1048550, 4194258, 1048551, 1048552, 4194259, 4194260, 4194261, 8388569, 4194262, 8388570, 8388571, 8388572, 8388573, 8388574, 16777195, 8388575, 16777196, 16777197, 4194263, 8388576, 16777198, 8388577, 8388578, 8388579, 8388580, 2097116, 4194264, 8388581, 4194265, 8388582, 8388583, 16777199, 4194266, 2097117, 1048553, 4194267, 4194268, 8388584, 8388585, 2097118, 8388586, 4194269, 4194270, 16777200, 2097119, 4194271, 8388587, 8388588, 2097120, 2097121, 4194272, 2097122, 8388589, 4194273, 8388590, 8388591, 1048554, 4194274, 4194275, 4194276, 8388592, 4194277, 4194278, 8388593, 67108832, 67108833, 1048555, 524273, 4194279, 8388594, 4194280, 33554412, 67108834, 67108835, 67108836, 134217694, 134217695, 67108837, 16777201, 33554413, 524274, 2097123, 67108838, 134217696, 134217697, 67108839, 134217698, 16777202, 2097124, 2097125, 67108840, 67108841, 268435453, 134217699, 134217700, 134217701, 1048556, 16777203, 1048557, 2097126, 4194281, 2097127, 2097128, 8388595, 4194282, 4194283, 33554414, 33554415, 16777204, 16777205, 67108842, 8388596, 67108843, 134217702, 67108844, 67108845, 134217703, 134217704, 134217705, 134217706, 134217707, 268435454, 134217708, 134217709, 134217710, 134217711, 134217712, 67108846};

    /* renamed from: c  reason: collision with root package name */
    private static final a f32175c = new a();

    static {
        f fVar = new f();
        f32176d = fVar;
        byte[] bArr = {13, 23, 28, 28, 28, 28, 28, 28, 28, 24, 30, 28, 28, 30, 28, 28, 28, 28, 28, 28, 28, 28, 30, 28, 28, 28, 28, 28, 28, 28, 28, 28, 6, 10, 10, 12, 13, 6, 8, 11, 10, 10, 8, 11, 8, 6, 6, 6, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 7, 8, 15, 6, 12, 10, 13, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 7, 8, 13, 19, 13, 14, 6, 15, 5, 6, 5, 6, 5, 6, 6, 6, 5, 7, 7, 6, 6, 6, 5, 6, 7, 6, 5, 5, 6, 7, 7, 7, 7, 7, 15, 11, 14, 13, 28, 20, 22, 20, 20, 22, 22, 22, 23, 22, 23, 23, 23, 23, 23, 24, 23, 24, 24, 22, 23, 24, 23, 23, 23, 23, 21, 22, 23, 22, 23, 23, 24, 22, 21, 20, 22, 22, 23, 23, 21, 23, 22, 22, 24, 21, 22, 23, 23, 21, 21, 22, 21, 23, 22, 23, 23, 20, 22, 22, 22, 23, 22, 22, 23, 26, 26, 20, 19, 22, 23, 22, 25, 26, 26, 26, 27, 27, 26, 24, 25, 19, 21, 26, 27, 27, 26, 27, 24, 21, 21, 26, 26, 28, 27, 27, 27, 20, 24, 20, 21, 22, 21, 21, 23, 22, 22, 25, 25, 24, 24, 26, 23, 26, 27, 26, 26, 27, 27, 27, 27, 27, 28, 27, 27, 27, 27, 27, 26};
        f32174b = bArr;
        int length = bArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            fVar.a(i10, f32173a[i10], f32174b[i10]);
        }
    }

    private f() {
    }

    private final void a(int i10, int i11, int i12) {
        a aVar = new a(i10, i12);
        a aVar2 = f32175c;
        while (i12 > 8) {
            i12 -= 8;
            int i13 = (i11 >>> i12) & 255;
            a[] a10 = aVar2.a();
            i.d(a10);
            a aVar3 = a10[i13];
            if (aVar3 == null) {
                aVar3 = new a();
                a10[i13] = aVar3;
            }
            aVar2 = aVar3;
        }
        int i14 = 8 - i12;
        int i15 = (i11 << i14) & 255;
        a[] a11 = aVar2.a();
        i.d(a11);
        h.i(a11, aVar, i15, (1 << i14) + i15);
    }

    public final void b(e source, long j10, d sink) {
        i.f(source, "source");
        i.f(sink, "sink");
        a aVar = f32175c;
        int i10 = 0;
        int i11 = 0;
        for (long j11 = 0; j11 < j10; j11++) {
            i10 = (i10 << 8) | b.b(source.readByte(), 255);
            i11 += 8;
            while (i11 >= 8) {
                int i12 = i11 - 8;
                a[] a10 = aVar.a();
                i.d(a10);
                aVar = a10[(i10 >>> i12) & 255];
                i.d(aVar);
                if (aVar.a() == null) {
                    sink.C(aVar.b());
                    i11 -= aVar.c();
                    aVar = f32175c;
                } else {
                    i11 = i12;
                }
            }
        }
        while (i11 > 0) {
            a[] a11 = aVar.a();
            i.d(a11);
            a aVar2 = a11[(i10 << (8 - i11)) & 255];
            i.d(aVar2);
            if (aVar2.a() == null && aVar2.c() <= i11) {
                sink.C(aVar2.b());
                i11 -= aVar2.c();
                aVar = f32175c;
            } else {
                return;
            }
        }
    }

    public final void c(ByteString source, d sink) throws IOException {
        i.f(source, "source");
        i.f(sink, "sink");
        int size = source.size();
        long j10 = 0;
        int i10 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            int b10 = b.b(source.getByte(i11), 255);
            int i12 = f32173a[b10];
            byte b11 = f32174b[b10];
            j10 = (j10 << b11) | i12;
            i10 += b11;
            while (i10 >= 8) {
                i10 = (i10 == true ? 1 : 0) - 8;
                sink.C((int) (j10 >> i10));
            }
        }
        if (i10 > 0) {
            sink.C((int) ((j10 << (8 - i10)) | (255 >>> (i10 == 1 ? 1L : 0L))));
        }
    }

    public final int d(ByteString bytes) {
        i.f(bytes, "bytes");
        int size = bytes.size();
        long j10 = 0;
        for (int i10 = 0; i10 < size; i10++) {
            j10 += f32174b[b.b(bytes.getByte(i10), 255)];
        }
        return (int) ((j10 + 7) >> 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Huffman.kt */
    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final a[] f32177a;

        /* renamed from: b  reason: collision with root package name */
        private final int f32178b;

        /* renamed from: c  reason: collision with root package name */
        private final int f32179c;

        public a() {
            this.f32177a = new a[256];
            this.f32178b = 0;
            this.f32179c = 0;
        }

        public final a[] a() {
            return this.f32177a;
        }

        public final int b() {
            return this.f32178b;
        }

        public final int c() {
            return this.f32179c;
        }

        public a(int i10, int i11) {
            this.f32177a = null;
            this.f32178b = i10;
            int i12 = i11 & 7;
            this.f32179c = i12 == 0 ? 8 : i12;
        }
    }
}
