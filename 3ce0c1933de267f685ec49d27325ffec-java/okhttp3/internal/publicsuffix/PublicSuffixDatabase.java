package okhttp3.internal.publicsuffix;

import com.mobvoi.wear.msgproxy.MessageProxyConstants;
import gp.b;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.collections.l;
import kotlin.collections.m;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import kotlin.text.u;
import okhttp3.internal.platform.h;
import okio.e;
import okio.k;
import okio.n;
/* compiled from: PublicSuffixDatabase.kt */
/* loaded from: classes3.dex */
public final class PublicSuffixDatabase {

    /* renamed from: f  reason: collision with root package name */
    private static final List<String> f32215f;

    /* renamed from: a  reason: collision with root package name */
    private final AtomicBoolean f32218a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    private final CountDownLatch f32219b = new CountDownLatch(1);

    /* renamed from: c  reason: collision with root package name */
    private byte[] f32220c;

    /* renamed from: d  reason: collision with root package name */
    private byte[] f32221d;

    /* renamed from: h  reason: collision with root package name */
    public static final a f32217h = new a(null);

    /* renamed from: e  reason: collision with root package name */
    private static final byte[] f32214e = {(byte) 42};

    /* renamed from: g  reason: collision with root package name */
    private static final PublicSuffixDatabase f32216g = new PublicSuffixDatabase();

    /* compiled from: PublicSuffixDatabase.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String b(byte[] bArr, byte[][] bArr2, int i10) {
            int i11;
            boolean z10;
            int i12;
            int b10;
            int length = bArr.length;
            int i13 = 0;
            while (i13 < length) {
                int i14 = (i13 + length) / 2;
                while (i14 > -1 && bArr[i14] != ((byte) 10)) {
                    i14--;
                }
                int i15 = i14 + 1;
                int i16 = 1;
                while (true) {
                    i11 = i15 + i16;
                    if (bArr[i11] == ((byte) 10)) {
                        break;
                    }
                    i16++;
                }
                int i17 = i11 - i15;
                int i18 = i10;
                boolean z11 = false;
                int i19 = 0;
                int i20 = 0;
                while (true) {
                    if (z11) {
                        i12 = 46;
                        z10 = false;
                    } else {
                        i12 = b.b(bArr2[i18][i19], 255);
                        z10 = z11;
                    }
                    b10 = i12 - b.b(bArr[i15 + i20], 255);
                    if (b10 != 0) {
                        break;
                    }
                    i20++;
                    i19++;
                    if (i20 == i17) {
                        break;
                    } else if (bArr2[i18].length != i19) {
                        z11 = z10;
                    } else if (i18 == bArr2.length - 1) {
                        break;
                    } else {
                        i18++;
                        i19 = -1;
                        z11 = true;
                    }
                }
                if (b10 >= 0) {
                    if (b10 <= 0) {
                        int i21 = i17 - i20;
                        int length2 = bArr2[i18].length - i19;
                        int length3 = bArr2.length;
                        for (int i22 = i18 + 1; i22 < length3; i22++) {
                            length2 += bArr2[i22].length;
                        }
                        if (length2 >= i21) {
                            if (length2 <= i21) {
                                Charset UTF_8 = StandardCharsets.UTF_8;
                                i.e(UTF_8, "UTF_8");
                                return new String(bArr, i15, i17, UTF_8);
                            }
                        }
                    }
                    i13 = i11 + 1;
                }
                length = i15 - 1;
            }
            return null;
        }

        public final PublicSuffixDatabase c() {
            return PublicSuffixDatabase.f32216g;
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    static {
        List<String> b10;
        b10 = l.b(MessageProxyConstants.NODE_ID_ANY);
        f32215f = b10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x00e0, code lost:
        r4 = kotlin.text.u.n0(r8, new char[]{'.'}, false, 0, 6, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00f7, code lost:
        r1 = kotlin.text.u.n0(r5, new char[]{'.'}, false, 0, 6, null);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final List<String> b(List<String> list) {
        String str;
        String str2;
        String str3;
        List<String> list2;
        List<String> list3;
        List<String> n02;
        if (this.f32218a.get() || !this.f32218a.compareAndSet(false, true)) {
            try {
                this.f32219b.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        } else {
            e();
        }
        if (this.f32220c != null) {
            int size = list.size();
            byte[][] bArr = new byte[size];
            for (int i10 = 0; i10 < size; i10++) {
                String str4 = list.get(i10);
                Charset UTF_8 = StandardCharsets.UTF_8;
                i.e(UTF_8, "UTF_8");
                Objects.requireNonNull(str4, "null cannot be cast to non-null type java.lang.String");
                byte[] bytes = str4.getBytes(UTF_8);
                i.e(bytes, "(this as java.lang.String).getBytes(charset)");
                bArr[i10] = bytes;
            }
            int i11 = 0;
            while (true) {
                str = null;
                if (i11 >= size) {
                    str2 = null;
                    break;
                }
                a aVar = f32217h;
                byte[] bArr2 = this.f32220c;
                if (bArr2 == null) {
                    i.u("publicSuffixListBytes");
                }
                str2 = aVar.b(bArr2, bArr, i11);
                if (str2 != null) {
                    break;
                }
                i11++;
            }
            if (size > 1) {
                byte[][] bArr3 = (byte[][]) bArr.clone();
                int length = bArr3.length - 1;
                for (int i12 = 0; i12 < length; i12++) {
                    bArr3[i12] = f32214e;
                    a aVar2 = f32217h;
                    byte[] bArr4 = this.f32220c;
                    if (bArr4 == null) {
                        i.u("publicSuffixListBytes");
                    }
                    String b10 = aVar2.b(bArr4, bArr3, i12);
                    if (b10 != null) {
                        str3 = b10;
                        break;
                    }
                }
            }
            str3 = null;
            if (str3 != null) {
                int i13 = size - 1;
                int i14 = 0;
                while (true) {
                    if (i14 >= i13) {
                        break;
                    }
                    a aVar3 = f32217h;
                    byte[] bArr5 = this.f32221d;
                    if (bArr5 == null) {
                        i.u("publicSuffixExceptionListBytes");
                    }
                    String b11 = aVar3.b(bArr5, bArr, i14);
                    if (b11 != null) {
                        str = b11;
                        break;
                    }
                    i14++;
                }
            }
            if (str != null) {
                n02 = u.n0('!' + str, new char[]{'.'}, false, 0, 6, null);
                return n02;
            } else if (str2 == null && str3 == null) {
                return f32215f;
            } else {
                if (str2 == null || list2 == null) {
                    list2 = m.g();
                }
                if (str3 == null || list3 == null) {
                    list3 = m.g();
                }
                return list2.size() > list3.size() ? list2 : list3;
            }
        } else {
            throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.".toString());
        }
    }

    private final void d() throws IOException {
        InputStream resourceAsStream = PublicSuffixDatabase.class.getResourceAsStream("publicsuffixes.gz");
        if (resourceAsStream != null) {
            e d10 = n.d(new k(n.l(resourceAsStream)));
            th = null;
            try {
                byte[] p02 = d10.p0(d10.readInt());
                byte[] p03 = d10.p0(d10.readInt());
                io.m mVar = io.m.f28349a;
                synchronized (this) {
                    i.d(p02);
                    this.f32220c = p02;
                    i.d(p03);
                    this.f32221d = p03;
                }
                this.f32219b.countDown();
            } finally {
                try {
                    throw th;
                } finally {
                }
            }
        }
    }

    private final void e() {
        boolean z10 = false;
        while (true) {
            try {
                try {
                    d();
                    break;
                } catch (InterruptedIOException unused) {
                    Thread.interrupted();
                    z10 = true;
                } catch (IOException e10) {
                    h.f32213c.g().k("Failed to read public suffix list", 5, e10);
                    if (z10) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                    return;
                }
            } catch (Throwable th2) {
                if (z10) {
                    Thread.currentThread().interrupt();
                }
                throw th2;
            }
        }
        if (z10) {
            Thread.currentThread().interrupt();
        }
    }

    private final List<String> f(String str) {
        List<String> n02;
        List<String> D;
        n02 = u.n0(str, new char[]{'.'}, false, 0, 6, null);
        if (!i.b((String) kotlin.collections.k.L(n02), "")) {
            return n02;
        }
        D = kotlin.collections.u.D(n02, 1);
        return D;
    }

    public final String c(String domain) {
        int i10;
        int i11;
        xo.e B;
        xo.e g10;
        String j10;
        i.f(domain, "domain");
        String unicodeDomain = IDN.toUnicode(domain);
        i.e(unicodeDomain, "unicodeDomain");
        List<String> f10 = f(unicodeDomain);
        List<String> b10 = b(f10);
        if (f10.size() == b10.size() && b10.get(0).charAt(0) != '!') {
            return null;
        }
        if (b10.get(0).charAt(0) == '!') {
            i11 = f10.size();
            i10 = b10.size();
        } else {
            i11 = f10.size();
            i10 = b10.size() + 1;
        }
        B = kotlin.collections.u.B(f(domain));
        g10 = xo.m.g(B, i11 - i10);
        j10 = xo.m.j(g10, ".", null, null, 0, null, null, 62, null);
        return j10;
    }
}
