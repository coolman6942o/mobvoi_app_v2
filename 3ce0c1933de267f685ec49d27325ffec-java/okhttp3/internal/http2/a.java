package okhttp3.internal.http2;

import com.mobvoi.wear.common.base.Constants;
import com.mobvoi.wear.contacts.ContactConstant;
import com.mobvoi.wear.info.SharedWearInfoHelper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.h;
import kotlin.collections.u;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import okio.ByteString;
import okio.c;
import okio.e;
import okio.n;
import okio.t;
/* compiled from: Hpack.kt */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final lp.a[] f32034a;

    /* renamed from: b  reason: collision with root package name */
    private static final Map<ByteString, Integer> f32035b;

    /* renamed from: c  reason: collision with root package name */
    public static final a f32036c;

    static {
        a aVar = new a();
        f32036c = aVar;
        ByteString byteString = lp.a.f30567f;
        ByteString byteString2 = lp.a.f30568g;
        ByteString byteString3 = lp.a.f30569h;
        ByteString byteString4 = lp.a.f30566e;
        f32034a = new lp.a[]{new lp.a(lp.a.f30570i, ""), new lp.a(byteString, "GET"), new lp.a(byteString, "POST"), new lp.a(byteString2, "/"), new lp.a(byteString2, "/index.html"), new lp.a(byteString3, "http"), new lp.a(byteString3, "https"), new lp.a(byteString4, "200"), new lp.a(byteString4, "204"), new lp.a(byteString4, "206"), new lp.a(byteString4, "304"), new lp.a(byteString4, "400"), new lp.a(byteString4, "404"), new lp.a(byteString4, "500"), new lp.a("accept-charset", ""), new lp.a("accept-encoding", "gzip, deflate"), new lp.a("accept-language", ""), new lp.a("accept-ranges", ""), new lp.a("accept", ""), new lp.a("access-control-allow-origin", ""), new lp.a("age", ""), new lp.a("allow", ""), new lp.a("authorization", ""), new lp.a("cache-control", ""), new lp.a("content-disposition", ""), new lp.a("content-encoding", ""), new lp.a("content-language", ""), new lp.a("content-length", ""), new lp.a("content-location", ""), new lp.a("content-range", ""), new lp.a("content-type", ""), new lp.a("cookie", ""), new lp.a(ContactConstant.CallsRecordKeys.DATE, ""), new lp.a("etag", ""), new lp.a("expect", ""), new lp.a("expires", ""), new lp.a(Constants.WatchfaceMarket.MARKET_ENTER_FROM, ""), new lp.a("host", ""), new lp.a("if-match", ""), new lp.a("if-modified-since", ""), new lp.a("if-none-match", ""), new lp.a("if-range", ""), new lp.a("if-unmodified-since", ""), new lp.a("last-modified", ""), new lp.a("link", ""), new lp.a(SharedWearInfoHelper.LocationInfo.TABLE, ""), new lp.a("max-forwards", ""), new lp.a("proxy-authenticate", ""), new lp.a("proxy-authorization", ""), new lp.a("range", ""), new lp.a("referer", ""), new lp.a("refresh", ""), new lp.a("retry-after", ""), new lp.a("server", ""), new lp.a("set-cookie", ""), new lp.a("strict-transport-security", ""), new lp.a("transfer-encoding", ""), new lp.a("user-agent", ""), new lp.a("vary", ""), new lp.a("via", ""), new lp.a("www-authenticate", "")};
        f32035b = aVar.d();
    }

    private a() {
    }

    private final Map<ByteString, Integer> d() {
        lp.a[] aVarArr = f32034a;
        LinkedHashMap linkedHashMap = new LinkedHashMap(aVarArr.length);
        int length = aVarArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            lp.a[] aVarArr2 = f32034a;
            if (!linkedHashMap.containsKey(aVarArr2[i10].f30572b)) {
                linkedHashMap.put(aVarArr2[i10].f30572b, Integer.valueOf(i10));
            }
        }
        Map<ByteString, Integer> unmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        i.e(unmodifiableMap, "Collections.unmodifiableMap(result)");
        return unmodifiableMap;
    }

    public final ByteString a(ByteString name) throws IOException {
        i.f(name, "name");
        int size = name.size();
        for (int i10 = 0; i10 < size; i10++) {
            byte b10 = (byte) 65;
            byte b11 = (byte) 90;
            byte b12 = name.getByte(i10);
            if (b10 <= b12 && b11 >= b12) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + name.utf8());
            }
        }
        return name;
    }

    public final Map<ByteString, Integer> b() {
        return f32035b;
    }

    public final lp.a[] c() {
        return f32034a;
    }

    /* compiled from: Hpack.kt */
    /* renamed from: okhttp3.internal.http2.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0430a {

        /* renamed from: a  reason: collision with root package name */
        private final List<lp.a> f32037a;

        /* renamed from: b  reason: collision with root package name */
        private final e f32038b;

        /* renamed from: c  reason: collision with root package name */
        public lp.a[] f32039c;

        /* renamed from: d  reason: collision with root package name */
        private int f32040d;

        /* renamed from: e  reason: collision with root package name */
        public int f32041e;

        /* renamed from: f  reason: collision with root package name */
        public int f32042f;

        /* renamed from: g  reason: collision with root package name */
        private final int f32043g;

        /* renamed from: h  reason: collision with root package name */
        private int f32044h;

        public C0430a(t source, int i10, int i11) {
            i.f(source, "source");
            this.f32043g = i10;
            this.f32044h = i11;
            this.f32037a = new ArrayList();
            this.f32038b = n.d(source);
            lp.a[] aVarArr = new lp.a[8];
            this.f32039c = aVarArr;
            this.f32040d = aVarArr.length - 1;
        }

        private final void a() {
            int i10 = this.f32044h;
            int i11 = this.f32042f;
            if (i10 >= i11) {
                return;
            }
            if (i10 == 0) {
                b();
            } else {
                d(i11 - i10);
            }
        }

        private final void b() {
            h.j(this.f32039c, null, 0, 0, 6, null);
            this.f32040d = this.f32039c.length - 1;
            this.f32041e = 0;
            this.f32042f = 0;
        }

        private final int c(int i10) {
            return this.f32040d + 1 + i10;
        }

        private final int d(int i10) {
            int i11;
            int i12 = 0;
            if (i10 > 0) {
                int length = this.f32039c.length;
                while (true) {
                    length--;
                    i11 = this.f32040d;
                    if (length < i11 || i10 <= 0) {
                        break;
                    }
                    lp.a aVar = this.f32039c[length];
                    i.d(aVar);
                    int i13 = aVar.f30571a;
                    i10 -= i13;
                    this.f32042f -= i13;
                    this.f32041e--;
                    i12++;
                }
                lp.a[] aVarArr = this.f32039c;
                System.arraycopy(aVarArr, i11 + 1, aVarArr, i11 + 1 + i12, this.f32041e);
                this.f32040d += i12;
            }
            return i12;
        }

        private final ByteString f(int i10) throws IOException {
            if (h(i10)) {
                return a.f32036c.c()[i10].f30572b;
            }
            int c10 = c(i10 - a.f32036c.c().length);
            if (c10 >= 0) {
                lp.a[] aVarArr = this.f32039c;
                if (c10 < aVarArr.length) {
                    lp.a aVar = aVarArr[c10];
                    i.d(aVar);
                    return aVar.f30572b;
                }
            }
            throw new IOException("Header index too large " + (i10 + 1));
        }

        private final void g(int i10, lp.a aVar) {
            this.f32037a.add(aVar);
            int i11 = aVar.f30571a;
            if (i10 != -1) {
                lp.a aVar2 = this.f32039c[c(i10)];
                i.d(aVar2);
                i11 -= aVar2.f30571a;
            }
            int i12 = this.f32044h;
            if (i11 > i12) {
                b();
                return;
            }
            int d10 = d((this.f32042f + i11) - i12);
            if (i10 == -1) {
                int i13 = this.f32041e + 1;
                lp.a[] aVarArr = this.f32039c;
                if (i13 > aVarArr.length) {
                    lp.a[] aVarArr2 = new lp.a[aVarArr.length * 2];
                    System.arraycopy(aVarArr, 0, aVarArr2, aVarArr.length, aVarArr.length);
                    this.f32040d = this.f32039c.length - 1;
                    this.f32039c = aVarArr2;
                }
                int i14 = this.f32040d;
                this.f32040d = i14 - 1;
                this.f32039c[i14] = aVar;
                this.f32041e++;
            } else {
                this.f32039c[i10 + c(i10) + d10] = aVar;
            }
            this.f32042f += i11;
        }

        private final boolean h(int i10) {
            return i10 >= 0 && i10 <= a.f32036c.c().length - 1;
        }

        private final int i() throws IOException {
            return gp.b.b(this.f32038b.readByte(), 255);
        }

        private final void l(int i10) throws IOException {
            if (h(i10)) {
                this.f32037a.add(a.f32036c.c()[i10]);
                return;
            }
            int c10 = c(i10 - a.f32036c.c().length);
            if (c10 >= 0) {
                lp.a[] aVarArr = this.f32039c;
                if (c10 < aVarArr.length) {
                    List<lp.a> list = this.f32037a;
                    lp.a aVar = aVarArr[c10];
                    i.d(aVar);
                    list.add(aVar);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i10 + 1));
        }

        private final void n(int i10) throws IOException {
            g(-1, new lp.a(f(i10), j()));
        }

        private final void o() throws IOException {
            g(-1, new lp.a(a.f32036c.a(j()), j()));
        }

        private final void p(int i10) throws IOException {
            this.f32037a.add(new lp.a(f(i10), j()));
        }

        private final void q() throws IOException {
            this.f32037a.add(new lp.a(a.f32036c.a(j()), j()));
        }

        public final List<lp.a> e() {
            List<lp.a> U;
            U = u.U(this.f32037a);
            this.f32037a.clear();
            return U;
        }

        public final ByteString j() throws IOException {
            int i10 = i();
            boolean z10 = (i10 & 128) == 128;
            long m10 = m(i10, 127);
            if (!z10) {
                return this.f32038b.k(m10);
            }
            c cVar = new c();
            f.f32176d.b(this.f32038b, m10, cVar);
            return cVar.d0();
        }

        public final void k() throws IOException {
            while (!this.f32038b.B()) {
                int b10 = gp.b.b(this.f32038b.readByte(), 255);
                if (b10 == 128) {
                    throw new IOException("index == 0");
                } else if ((b10 & 128) == 128) {
                    l(m(b10, 127) - 1);
                } else if (b10 == 64) {
                    o();
                } else if ((b10 & 64) == 64) {
                    n(m(b10, 63) - 1);
                } else if ((b10 & 32) == 32) {
                    int m10 = m(b10, 31);
                    this.f32044h = m10;
                    if (m10 < 0 || m10 > this.f32043g) {
                        throw new IOException("Invalid dynamic table size update " + this.f32044h);
                    }
                    a();
                } else if (b10 == 16 || b10 == 0) {
                    q();
                } else {
                    p(m(b10, 15) - 1);
                }
            }
        }

        public final int m(int i10, int i11) throws IOException {
            int i12 = i10 & i11;
            if (i12 < i11) {
                return i12;
            }
            int i13 = 0;
            while (true) {
                int i14 = i();
                if ((i14 & 128) == 0) {
                    return i11 + (i14 << i13);
                }
                i11 += (i14 & 127) << i13;
                i13 += 7;
            }
        }

        public /* synthetic */ C0430a(t tVar, int i10, int i11, int i12, f fVar) {
            this(tVar, i10, (i12 & 4) != 0 ? i10 : i11);
        }
    }

    /* compiled from: Hpack.kt */
    /* loaded from: classes3.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private int f32045a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f32046b;

        /* renamed from: c  reason: collision with root package name */
        public int f32047c;

        /* renamed from: d  reason: collision with root package name */
        public lp.a[] f32048d;

        /* renamed from: e  reason: collision with root package name */
        private int f32049e;

        /* renamed from: f  reason: collision with root package name */
        public int f32050f;

        /* renamed from: g  reason: collision with root package name */
        public int f32051g;

        /* renamed from: h  reason: collision with root package name */
        public int f32052h;

        /* renamed from: i  reason: collision with root package name */
        private final boolean f32053i;

        /* renamed from: j  reason: collision with root package name */
        private final c f32054j;

        public b(int i10, boolean z10, c out) {
            i.f(out, "out");
            this.f32052h = i10;
            this.f32053i = z10;
            this.f32054j = out;
            this.f32045a = Integer.MAX_VALUE;
            this.f32047c = i10;
            lp.a[] aVarArr = new lp.a[8];
            this.f32048d = aVarArr;
            this.f32049e = aVarArr.length - 1;
        }

        private final void a() {
            int i10 = this.f32047c;
            int i11 = this.f32051g;
            if (i10 >= i11) {
                return;
            }
            if (i10 == 0) {
                b();
            } else {
                c(i11 - i10);
            }
        }

        private final void b() {
            h.j(this.f32048d, null, 0, 0, 6, null);
            this.f32049e = this.f32048d.length - 1;
            this.f32050f = 0;
            this.f32051g = 0;
        }

        private final int c(int i10) {
            int i11;
            int i12 = 0;
            if (i10 > 0) {
                int length = this.f32048d.length;
                while (true) {
                    length--;
                    i11 = this.f32049e;
                    if (length < i11 || i10 <= 0) {
                        break;
                    }
                    lp.a aVar = this.f32048d[length];
                    i.d(aVar);
                    i10 -= aVar.f30571a;
                    int i13 = this.f32051g;
                    lp.a aVar2 = this.f32048d[length];
                    i.d(aVar2);
                    this.f32051g = i13 - aVar2.f30571a;
                    this.f32050f--;
                    i12++;
                }
                lp.a[] aVarArr = this.f32048d;
                System.arraycopy(aVarArr, i11 + 1, aVarArr, i11 + 1 + i12, this.f32050f);
                lp.a[] aVarArr2 = this.f32048d;
                int i14 = this.f32049e;
                Arrays.fill(aVarArr2, i14 + 1, i14 + 1 + i12, (Object) null);
                this.f32049e += i12;
            }
            return i12;
        }

        private final void d(lp.a aVar) {
            int i10 = aVar.f30571a;
            int i11 = this.f32047c;
            if (i10 > i11) {
                b();
                return;
            }
            c((this.f32051g + i10) - i11);
            int i12 = this.f32050f + 1;
            lp.a[] aVarArr = this.f32048d;
            if (i12 > aVarArr.length) {
                lp.a[] aVarArr2 = new lp.a[aVarArr.length * 2];
                System.arraycopy(aVarArr, 0, aVarArr2, aVarArr.length, aVarArr.length);
                this.f32049e = this.f32048d.length - 1;
                this.f32048d = aVarArr2;
            }
            int i13 = this.f32049e;
            this.f32049e = i13 - 1;
            this.f32048d[i13] = aVar;
            this.f32050f++;
            this.f32051g += i10;
        }

        public final void e(int i10) {
            this.f32052h = i10;
            int min = Math.min(i10, 16384);
            int i11 = this.f32047c;
            if (i11 != min) {
                if (min < i11) {
                    this.f32045a = Math.min(this.f32045a, min);
                }
                this.f32046b = true;
                this.f32047c = min;
                a();
            }
        }

        public final void f(ByteString data) throws IOException {
            i.f(data, "data");
            if (this.f32053i) {
                f fVar = f.f32176d;
                if (fVar.d(data) < data.size()) {
                    c cVar = new c();
                    fVar.c(data, cVar);
                    ByteString d02 = cVar.d0();
                    h(d02.size(), 127, 128);
                    this.f32054j.v0(d02);
                    return;
                }
            }
            h(data.size(), 127, 0);
            this.f32054j.v0(data);
        }

        public final void g(List<lp.a> headerBlock) throws IOException {
            int i10;
            int i11;
            i.f(headerBlock, "headerBlock");
            if (this.f32046b) {
                int i12 = this.f32045a;
                if (i12 < this.f32047c) {
                    h(i12, 31, 32);
                }
                this.f32046b = false;
                this.f32045a = Integer.MAX_VALUE;
                h(this.f32047c, 31, 32);
            }
            int size = headerBlock.size();
            for (int i13 = 0; i13 < size; i13++) {
                lp.a aVar = headerBlock.get(i13);
                ByteString asciiLowercase = aVar.f30572b.toAsciiLowercase();
                ByteString byteString = aVar.f30573c;
                a aVar2 = a.f32036c;
                Integer num = aVar2.b().get(asciiLowercase);
                if (num != null) {
                    i10 = num.intValue() + 1;
                    if (2 <= i10 && 7 >= i10) {
                        if (i.b(aVar2.c()[i10 - 1].f30573c, byteString)) {
                            i11 = i10;
                        } else if (i.b(aVar2.c()[i10].f30573c, byteString)) {
                            i10++;
                            i11 = i10;
                        }
                    }
                    i11 = i10;
                    i10 = -1;
                } else {
                    i11 = -1;
                    i10 = -1;
                }
                if (i10 == -1) {
                    int i14 = this.f32049e + 1;
                    int length = this.f32048d.length;
                    while (true) {
                        if (i14 >= length) {
                            break;
                        }
                        lp.a aVar3 = this.f32048d[i14];
                        i.d(aVar3);
                        if (i.b(aVar3.f30572b, asciiLowercase)) {
                            lp.a aVar4 = this.f32048d[i14];
                            i.d(aVar4);
                            if (i.b(aVar4.f30573c, byteString)) {
                                i10 = a.f32036c.c().length + (i14 - this.f32049e);
                                break;
                            } else if (i11 == -1) {
                                i11 = (i14 - this.f32049e) + a.f32036c.c().length;
                            }
                        }
                        i14++;
                    }
                }
                if (i10 != -1) {
                    h(i10, 127, 128);
                } else if (i11 == -1) {
                    this.f32054j.C(64);
                    f(asciiLowercase);
                    f(byteString);
                    d(aVar);
                } else if (!asciiLowercase.startsWith(lp.a.f30565d) || !(!i.b(lp.a.f30570i, asciiLowercase))) {
                    h(i11, 63, 64);
                    f(byteString);
                    d(aVar);
                } else {
                    h(i11, 15, 0);
                    f(byteString);
                }
            }
        }

        public final void h(int i10, int i11, int i12) {
            if (i10 < i11) {
                this.f32054j.C(i10 | i12);
                return;
            }
            this.f32054j.C(i12 | i11);
            int i13 = i10 - i11;
            while (i13 >= 128) {
                this.f32054j.C(128 | (i13 & 127));
                i13 >>>= 7;
            }
            this.f32054j.C(i13);
        }

        public /* synthetic */ b(int i10, boolean z10, c cVar, int i11, f fVar) {
            this((i11 & 1) != 0 ? 4096 : i10, (i11 & 2) != 0 ? true : z10, cVar);
        }
    }
}
