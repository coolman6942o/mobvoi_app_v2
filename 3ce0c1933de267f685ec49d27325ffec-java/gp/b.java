package gp;

import io.m;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import kotlin.collections.d0;
import kotlin.collections.n;
import kotlin.jvm.internal.i;
import kotlin.text.Regex;
import kotlin.text.u;
import okhttp3.Headers;
import okhttp3.a0;
import okhttp3.b0;
import okhttp3.c0;
import okhttp3.e;
import okhttp3.r;
import okhttp3.y;
import okio.ByteString;
import okio.c;
import okio.t;
import rp.d;
import vo.f;
/* compiled from: Util.kt */
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f27625a;

    /* renamed from: c  reason: collision with root package name */
    public static final c0 f27627c;

    /* renamed from: d  reason: collision with root package name */
    public static final a0 f27628d;

    /* renamed from: e  reason: collision with root package name */
    private static final d f27629e;

    /* renamed from: f  reason: collision with root package name */
    public static final TimeZone f27630f;

    /* renamed from: i  reason: collision with root package name */
    public static final String f27633i;

    /* renamed from: b  reason: collision with root package name */
    public static final Headers f27626b = Headers.Companion.h(new String[0]);

    /* renamed from: g  reason: collision with root package name */
    private static final Regex f27631g = new Regex("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f27632h = false;

    /* compiled from: Util.kt */
    /* loaded from: classes3.dex */
    static final class a implements r.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ r f27634a;

        a(r rVar) {
            this.f27634a = rVar;
        }

        @Override // okhttp3.r.c
        public final r a(e it) {
            i.f(it, "it");
            return this.f27634a;
        }
    }

    /* compiled from: Util.kt */
    /* renamed from: gp.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    static final class ThreadFactoryC0294b implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f27635a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f27636b;

        ThreadFactoryC0294b(String str, boolean z10) {
            this.f27635a = str;
            this.f27636b = z10;
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, this.f27635a);
            thread.setDaemon(this.f27636b);
            return thread;
        }
    }

    static {
        String h02;
        String i02;
        byte[] bArr = new byte[0];
        f27625a = bArr;
        f27627c = c0.b.i(c0.Companion, bArr, null, 1, null);
        f27628d = a0.a.j(a0.Companion, bArr, null, 0, 0, 7, null);
        d.a aVar = d.f33653d;
        ByteString.a aVar2 = ByteString.Companion;
        f27629e = aVar.d(aVar2.b("efbbbf"), aVar2.b("feff"), aVar2.b("fffe"), aVar2.b("0000ffff"), aVar2.b("ffff0000"));
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        i.d(timeZone);
        f27630f = timeZone;
        String name = y.class.getName();
        i.e(name, "OkHttpClient::class.java.name");
        h02 = u.h0(name, "okhttp3.");
        i02 = u.i0(h02, "Client");
        f27633i = i02;
    }

    public static final int A(String indexOfNonWhitespace, int i10) {
        i.f(indexOfNonWhitespace, "$this$indexOfNonWhitespace");
        int length = indexOfNonWhitespace.length();
        while (i10 < length) {
            char charAt = indexOfNonWhitespace.charAt(i10);
            if (charAt != ' ' && charAt != '\t') {
                return i10;
            }
            i10++;
        }
        return indexOfNonWhitespace.length();
    }

    public static final String[] B(String[] intersect, String[] other, Comparator<? super String> comparator) {
        i.f(intersect, "$this$intersect");
        i.f(other, "other");
        i.f(comparator, "comparator");
        ArrayList arrayList = new ArrayList();
        for (String str : intersect) {
            int length = other.length;
            int i10 = 0;
            while (true) {
                if (i10 >= length) {
                    break;
                } else if (comparator.compare(str, other[i10]) == 0) {
                    arrayList.add(str);
                    break;
                } else {
                    i10++;
                }
            }
        }
        Object[] array = arrayList.toArray(new String[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        return (String[]) array;
    }

    public static final boolean C(mp.a isCivilized, File file) {
        i.f(isCivilized, "$this$isCivilized");
        i.f(file, "file");
        okio.r b10 = isCivilized.b(file);
        th = null;
        try {
            try {
                isCivilized.f(file);
                return true;
            } catch (IOException unused) {
                m mVar = m.f28349a;
                oo.b.a(b10, th);
                isCivilized.f(file);
                return false;
            }
        } catch (Throwable th2) {
            try {
                throw th2;
            } finally {
                oo.b.a(b10, th2);
            }
        }
    }

    /* JADX WARN: Finally extract failed */
    public static final boolean D(Socket isHealthy, okio.e source) {
        i.f(isHealthy, "$this$isHealthy");
        i.f(source, "source");
        try {
            int soTimeout = isHealthy.getSoTimeout();
            try {
                isHealthy.setSoTimeout(1);
                boolean z10 = !source.B();
                isHealthy.setSoTimeout(soTimeout);
                return z10;
            } catch (Throwable th2) {
                isHealthy.setSoTimeout(soTimeout);
                throw th2;
            }
        } catch (SocketTimeoutException unused) {
            return true;
        } catch (IOException unused2) {
            return false;
        }
    }

    public static final int E(char c10) {
        if ('0' <= c10 && '9' >= c10) {
            return c10 - '0';
        }
        char c11 = 'a';
        if ('a' > c10 || 'f' < c10) {
            c11 = 'A';
            if ('A' > c10 || 'F' < c10) {
                return -1;
            }
        }
        return (c10 - c11) + 10;
    }

    public static final Charset F(okio.e readBomAsCharset, Charset charset) throws IOException {
        i.f(readBomAsCharset, "$this$readBomAsCharset");
        i.f(charset, "default");
        int e02 = readBomAsCharset.e0(f27629e);
        if (e02 == -1) {
            return charset;
        }
        if (e02 == 0) {
            Charset UTF_8 = StandardCharsets.UTF_8;
            i.e(UTF_8, "UTF_8");
            return UTF_8;
        } else if (e02 == 1) {
            Charset UTF_16BE = StandardCharsets.UTF_16BE;
            i.e(UTF_16BE, "UTF_16BE");
            return UTF_16BE;
        } else if (e02 == 2) {
            Charset UTF_16LE = StandardCharsets.UTF_16LE;
            i.e(UTF_16LE, "UTF_16LE");
            return UTF_16LE;
        } else if (e02 == 3) {
            return kotlin.text.d.f30095d.a();
        } else {
            if (e02 == 4) {
                return kotlin.text.d.f30095d.b();
            }
            throw new AssertionError();
        }
    }

    public static final int G(okio.e readMedium) throws IOException {
        i.f(readMedium, "$this$readMedium");
        return b(readMedium.readByte(), 255) | (b(readMedium.readByte(), 255) << 16) | (b(readMedium.readByte(), 255) << 8);
    }

    public static final int H(c skipAll, byte b10) {
        i.f(skipAll, "$this$skipAll");
        int i10 = 0;
        while (!skipAll.B() && skipAll.u(0L) == b10) {
            i10++;
            skipAll.readByte();
        }
        return i10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0051, code lost:
        if (r5 == Long.MAX_VALUE) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0053, code lost:
        r11.timeout().a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x005b, code lost:
        r11.timeout().d(r0 + r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x007d, code lost:
        if (r5 != Long.MAX_VALUE) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0080, code lost:
        return r12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean I(t skipAll, int i10, TimeUnit timeUnit) throws IOException {
        boolean z10;
        i.f(skipAll, "$this$skipAll");
        i.f(timeUnit, "timeUnit");
        long nanoTime = System.nanoTime();
        long c10 = skipAll.timeout().e() ? skipAll.timeout().c() - nanoTime : Long.MAX_VALUE;
        skipAll.timeout().d(Math.min(c10, timeUnit.toNanos(i10)) + nanoTime);
        try {
            c cVar = new c();
            while (skipAll.read(cVar, 8192L) != -1) {
                cVar.c();
            }
            z10 = true;
        } catch (InterruptedIOException unused) {
            z10 = false;
        } catch (Throwable th2) {
            if (c10 == Long.MAX_VALUE) {
                skipAll.timeout().a();
            } else {
                skipAll.timeout().d(nanoTime + c10);
            }
            throw th2;
        }
    }

    public static final ThreadFactory J(String name, boolean z10) {
        i.f(name, "name");
        return new ThreadFactoryC0294b(name, z10);
    }

    public static final List<lp.a> K(Headers toHeaderList) {
        vo.c k10;
        int p10;
        i.f(toHeaderList, "$this$toHeaderList");
        k10 = f.k(0, toHeaderList.size());
        p10 = n.p(k10, 10);
        ArrayList arrayList = new ArrayList(p10);
        Iterator<Integer> it = k10.iterator();
        while (it.hasNext()) {
            int b10 = ((kotlin.collections.y) it).b();
            arrayList.add(new lp.a(toHeaderList.name(b10), toHeaderList.value(b10)));
        }
        return arrayList;
    }

    public static final Headers L(List<lp.a> toHeaders) {
        i.f(toHeaders, "$this$toHeaders");
        Headers.a aVar = new Headers.a();
        for (lp.a aVar2 : toHeaders) {
            aVar.d(aVar2.a().utf8(), aVar2.b().utf8());
        }
        return aVar.f();
    }

    public static final String M(okhttp3.u toHostHeader, boolean z10) {
        boolean I;
        String str;
        i.f(toHostHeader, "$this$toHostHeader");
        I = u.I(toHostHeader.h(), ":", false, 2, null);
        if (I) {
            str = '[' + toHostHeader.h() + ']';
        } else {
            str = toHostHeader.h();
        }
        if (!z10 && toHostHeader.n() == okhttp3.u.f32275l.c(toHostHeader.t())) {
            return str;
        }
        return str + ':' + toHostHeader.n();
    }

    public static /* synthetic */ String N(okhttp3.u uVar, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        return M(uVar, z10);
    }

    public static final <T> List<T> O(List<? extends T> toImmutableList) {
        List W;
        i.f(toImmutableList, "$this$toImmutableList");
        W = kotlin.collections.u.W(toImmutableList);
        List<T> unmodifiableList = Collections.unmodifiableList(W);
        i.e(unmodifiableList, "Collections.unmodifiableList(toMutableList())");
        return unmodifiableList;
    }

    public static final <K, V> Map<K, V> P(Map<K, ? extends V> toImmutableMap) {
        Map<K, V> e10;
        i.f(toImmutableMap, "$this$toImmutableMap");
        if (toImmutableMap.isEmpty()) {
            e10 = d0.e();
            return e10;
        }
        Map<K, V> unmodifiableMap = Collections.unmodifiableMap(new LinkedHashMap(toImmutableMap));
        i.e(unmodifiableMap, "Collections.unmodifiableMap(LinkedHashMap(this))");
        return unmodifiableMap;
    }

    public static final long Q(String toLongOrDefault, long j10) {
        i.f(toLongOrDefault, "$this$toLongOrDefault");
        try {
            return Long.parseLong(toLongOrDefault);
        } catch (NumberFormatException unused) {
            return j10;
        }
    }

    public static final int R(String str, int i10) {
        if (str != null) {
            try {
                long parseLong = Long.parseLong(str);
                if (parseLong > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
                if (parseLong < 0) {
                    return 0;
                }
                return (int) parseLong;
            } catch (NumberFormatException unused) {
            }
        }
        return i10;
    }

    public static final String S(String trimSubstring, int i10, int i11) {
        i.f(trimSubstring, "$this$trimSubstring");
        int w10 = w(trimSubstring, i10, i11);
        String substring = trimSubstring.substring(w10, y(trimSubstring, w10, i11));
        i.e(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String T(String str, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = str.length();
        }
        return S(str, i10, i11);
    }

    public static final Throwable U(Exception withSuppressed, List<? extends Exception> suppressed) {
        i.f(withSuppressed, "$this$withSuppressed");
        i.f(suppressed, "suppressed");
        if (suppressed.size() > 1) {
            System.out.println(suppressed);
        }
        for (Exception exc : suppressed) {
            io.b.a(withSuppressed, exc);
        }
        return withSuppressed;
    }

    public static final void V(okio.d writeMedium, int i10) throws IOException {
        i.f(writeMedium, "$this$writeMedium");
        writeMedium.C((i10 >>> 16) & 255);
        writeMedium.C((i10 >>> 8) & 255);
        writeMedium.C(i10 & 255);
    }

    public static final <E> void a(List<E> addIfAbsent, E e10) {
        i.f(addIfAbsent, "$this$addIfAbsent");
        if (!addIfAbsent.contains(e10)) {
            addIfAbsent.add(e10);
        }
    }

    public static final int b(byte b10, int i10) {
        return b10 & i10;
    }

    public static final int c(short s10, int i10) {
        return s10 & i10;
    }

    public static final long d(int i10, long j10) {
        return i10 & j10;
    }

    public static final r.c e(r asFactory) {
        i.f(asFactory, "$this$asFactory");
        return new a(asFactory);
    }

    public static final boolean f(String canParseAsIpAddress) {
        i.f(canParseAsIpAddress, "$this$canParseAsIpAddress");
        return f27631g.matches(canParseAsIpAddress);
    }

    public static final boolean g(okhttp3.u canReuseConnectionFor, okhttp3.u other) {
        i.f(canReuseConnectionFor, "$this$canReuseConnectionFor");
        i.f(other, "other");
        return i.b(canReuseConnectionFor.h(), other.h()) && canReuseConnectionFor.n() == other.n() && i.b(canReuseConnectionFor.t(), other.t());
    }

    public static final int h(String name, long j10, TimeUnit timeUnit) {
        i.f(name, "name");
        int i10 = (j10 > 0L ? 1 : (j10 == 0L ? 0 : -1));
        boolean z10 = true;
        if (i10 >= 0) {
            if (timeUnit != null) {
                long millis = timeUnit.toMillis(j10);
                if (millis <= ((long) Integer.MAX_VALUE)) {
                    if (millis == 0 && i10 > 0) {
                        z10 = false;
                    }
                    if (z10) {
                        return (int) millis;
                    }
                    throw new IllegalArgumentException((name + " too small.").toString());
                }
                throw new IllegalArgumentException((name + " too large.").toString());
            }
            throw new IllegalStateException("unit == null".toString());
        }
        throw new IllegalStateException((name + " < 0").toString());
    }

    public static final void i(long j10, long j11, long j12) {
        if ((j11 | j12) < 0 || j11 > j10 || j10 - j11 < j12) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static final void j(Closeable closeQuietly) {
        i.f(closeQuietly, "$this$closeQuietly");
        try {
            closeQuietly.close();
        } catch (RuntimeException e10) {
            throw e10;
        } catch (Exception unused) {
        }
    }

    public static final void k(Socket closeQuietly) {
        i.f(closeQuietly, "$this$closeQuietly");
        try {
            closeQuietly.close();
        } catch (AssertionError e10) {
            throw e10;
        } catch (RuntimeException e11) {
            if (!i.b(e11.getMessage(), "bio == null")) {
                throw e11;
            }
        } catch (Exception unused) {
        }
    }

    public static final String[] l(String[] concat, String value) {
        int u10;
        i.f(concat, "$this$concat");
        i.f(value, "value");
        Object[] copyOf = Arrays.copyOf(concat, concat.length + 1);
        i.e(copyOf, "java.util.Arrays.copyOf(this, newSize)");
        String[] strArr = (String[]) copyOf;
        u10 = kotlin.collections.i.u(strArr);
        strArr[u10] = value;
        return strArr;
    }

    public static final int m(String delimiterOffset, char c10, int i10, int i11) {
        i.f(delimiterOffset, "$this$delimiterOffset");
        while (i10 < i11) {
            if (delimiterOffset.charAt(i10) == c10) {
                return i10;
            }
            i10++;
        }
        return i11;
    }

    public static final int n(String delimiterOffset, String delimiters, int i10, int i11) {
        boolean H;
        i.f(delimiterOffset, "$this$delimiterOffset");
        i.f(delimiters, "delimiters");
        while (i10 < i11) {
            H = u.H(delimiters, delimiterOffset.charAt(i10), false, 2, null);
            if (H) {
                return i10;
            }
            i10++;
        }
        return i11;
    }

    public static /* synthetic */ int o(String str, char c10, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = str.length();
        }
        return m(str, c10, i10, i11);
    }

    public static final boolean p(t discard, int i10, TimeUnit timeUnit) {
        i.f(discard, "$this$discard");
        i.f(timeUnit, "timeUnit");
        try {
            return I(discard, i10, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    public static final String q(String format, Object... args) {
        i.f(format, "format");
        i.f(args, "args");
        kotlin.jvm.internal.n nVar = kotlin.jvm.internal.n.f30086a;
        Locale locale = Locale.US;
        Object[] copyOf = Arrays.copyOf(args, args.length);
        String format2 = String.format(locale, format, Arrays.copyOf(copyOf, copyOf.length));
        i.e(format2, "java.lang.String.format(locale, format, *args)");
        return format2;
    }

    public static final boolean r(String[] hasIntersection, String[] strArr, Comparator<? super String> comparator) {
        i.f(hasIntersection, "$this$hasIntersection");
        i.f(comparator, "comparator");
        if (!(hasIntersection.length == 0) && strArr != null) {
            if (!(strArr.length == 0)) {
                for (String str : hasIntersection) {
                    for (String str2 : strArr) {
                        if (comparator.compare(str, str2) == 0) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static final long s(b0 headersContentLength) {
        i.f(headersContentLength, "$this$headersContentLength");
        String str = headersContentLength.x().get("Content-Length");
        if (str != null) {
            return Q(str, -1L);
        }
        return -1L;
    }

    @SafeVarargs
    public static final <T> List<T> t(T... elements) {
        List j10;
        i.f(elements, "elements");
        Object[] objArr = (Object[]) elements.clone();
        j10 = kotlin.collections.m.j(Arrays.copyOf(objArr, objArr.length));
        List<T> unmodifiableList = Collections.unmodifiableList(j10);
        i.e(unmodifiableList, "Collections.unmodifiable…istOf(*elements.clone()))");
        return unmodifiableList;
    }

    public static final int u(String[] indexOf, String value, Comparator<String> comparator) {
        i.f(indexOf, "$this$indexOf");
        i.f(value, "value");
        i.f(comparator, "comparator");
        int length = indexOf.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (comparator.compare(indexOf[i10], value) == 0) {
                return i10;
            }
        }
        return -1;
    }

    public static final int v(String indexOfControlOrNonAscii) {
        i.f(indexOfControlOrNonAscii, "$this$indexOfControlOrNonAscii");
        int length = indexOfControlOrNonAscii.length();
        for (int i10 = 0; i10 < length; i10++) {
            char charAt = indexOfControlOrNonAscii.charAt(i10);
            if (i.h(charAt, 31) <= 0 || i.h(charAt, 127) >= 0) {
                return i10;
            }
        }
        return -1;
    }

    public static final int w(String indexOfFirstNonAsciiWhitespace, int i10, int i11) {
        i.f(indexOfFirstNonAsciiWhitespace, "$this$indexOfFirstNonAsciiWhitespace");
        while (i10 < i11) {
            char charAt = indexOfFirstNonAsciiWhitespace.charAt(i10);
            if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                return i10;
            }
            i10++;
        }
        return i11;
    }

    public static /* synthetic */ int x(String str, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = str.length();
        }
        return w(str, i10, i11);
    }

    public static final int y(String indexOfLastNonAsciiWhitespace, int i10, int i11) {
        i.f(indexOfLastNonAsciiWhitespace, "$this$indexOfLastNonAsciiWhitespace");
        int i12 = i11 - 1;
        if (i12 >= i10) {
            while (true) {
                char charAt = indexOfLastNonAsciiWhitespace.charAt(i12);
                if (charAt == '\t' || charAt == '\n' || charAt == '\f' || charAt == '\r' || charAt == ' ') {
                    if (i12 == i10) {
                        break;
                    }
                    i12--;
                } else {
                    return i12 + 1;
                }
            }
        }
        return i10;
    }

    public static /* synthetic */ int z(String str, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = str.length();
        }
        return y(str, i10, i11);
    }
}
