package i8;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.stream.JsonToken;
import com.mobvoi.wear.lpa.LpaConstants;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
/* compiled from: TypeAdapters.java */
/* loaded from: classes.dex */
public final class n {
    public static final com.google.gson.q<String> A;
    public static final com.google.gson.r D;
    public static final com.google.gson.q<StringBuilder> E;
    public static final com.google.gson.r F;
    public static final com.google.gson.q<StringBuffer> G;
    public static final com.google.gson.r H;
    public static final com.google.gson.q<URL> I;
    public static final com.google.gson.r J;
    public static final com.google.gson.q<URI> K;
    public static final com.google.gson.r L;
    public static final com.google.gson.q<InetAddress> M;
    public static final com.google.gson.r N;
    public static final com.google.gson.q<UUID> O;
    public static final com.google.gson.r P;
    public static final com.google.gson.q<Currency> Q;
    public static final com.google.gson.r R;
    public static final com.google.gson.q<Calendar> T;
    public static final com.google.gson.r U;
    public static final com.google.gson.q<Locale> V;
    public static final com.google.gson.r W;
    public static final com.google.gson.q<com.google.gson.k> X;
    public static final com.google.gson.r Y;

    /* renamed from: a  reason: collision with root package name */
    public static final com.google.gson.q<Class> f28164a;

    /* renamed from: b  reason: collision with root package name */
    public static final com.google.gson.r f28165b;

    /* renamed from: c  reason: collision with root package name */
    public static final com.google.gson.q<BitSet> f28166c;

    /* renamed from: d  reason: collision with root package name */
    public static final com.google.gson.r f28167d;

    /* renamed from: e  reason: collision with root package name */
    public static final com.google.gson.q<Boolean> f28168e;

    /* renamed from: g  reason: collision with root package name */
    public static final com.google.gson.r f28170g;

    /* renamed from: h  reason: collision with root package name */
    public static final com.google.gson.q<Number> f28171h;

    /* renamed from: i  reason: collision with root package name */
    public static final com.google.gson.r f28172i;

    /* renamed from: j  reason: collision with root package name */
    public static final com.google.gson.q<Number> f28173j;

    /* renamed from: k  reason: collision with root package name */
    public static final com.google.gson.r f28174k;

    /* renamed from: l  reason: collision with root package name */
    public static final com.google.gson.q<Number> f28175l;

    /* renamed from: m  reason: collision with root package name */
    public static final com.google.gson.r f28176m;

    /* renamed from: n  reason: collision with root package name */
    public static final com.google.gson.q<AtomicInteger> f28177n;

    /* renamed from: o  reason: collision with root package name */
    public static final com.google.gson.r f28178o;

    /* renamed from: p  reason: collision with root package name */
    public static final com.google.gson.q<AtomicBoolean> f28179p;

    /* renamed from: q  reason: collision with root package name */
    public static final com.google.gson.r f28180q;

    /* renamed from: r  reason: collision with root package name */
    public static final com.google.gson.q<AtomicIntegerArray> f28181r;

    /* renamed from: s  reason: collision with root package name */
    public static final com.google.gson.r f28182s;

    /* renamed from: w  reason: collision with root package name */
    public static final com.google.gson.q<Number> f28186w;

    /* renamed from: x  reason: collision with root package name */
    public static final com.google.gson.r f28187x;

    /* renamed from: y  reason: collision with root package name */
    public static final com.google.gson.q<Character> f28188y;

    /* renamed from: z  reason: collision with root package name */
    public static final com.google.gson.r f28189z;

    /* renamed from: f  reason: collision with root package name */
    public static final com.google.gson.q<Boolean> f28169f = new d0();

    /* renamed from: t  reason: collision with root package name */
    public static final com.google.gson.q<Number> f28183t = new b();

    /* renamed from: u  reason: collision with root package name */
    public static final com.google.gson.q<Number> f28184u = new c();

    /* renamed from: v  reason: collision with root package name */
    public static final com.google.gson.q<Number> f28185v = new d();
    public static final com.google.gson.q<BigDecimal> B = new h();
    public static final com.google.gson.q<BigInteger> C = new i();
    public static final com.google.gson.r S = new r();
    public static final com.google.gson.r Z = new w();

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    static class a extends com.google.gson.q<AtomicIntegerArray> {
        a() {
        }

        /* renamed from: e */
        public AtomicIntegerArray b(com.google.gson.stream.a aVar) throws IOException {
            ArrayList arrayList = new ArrayList();
            aVar.c();
            while (aVar.v()) {
                try {
                    arrayList.add(Integer.valueOf(aVar.Q()));
                } catch (NumberFormatException e10) {
                    throw new JsonSyntaxException(e10);
                }
            }
            aVar.o();
            int size = arrayList.size();
            AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(size);
            for (int i10 = 0; i10 < size; i10++) {
                atomicIntegerArray.set(i10, ((Integer) arrayList.get(i10)).intValue());
            }
            return atomicIntegerArray;
        }

        /* renamed from: f */
        public void d(com.google.gson.stream.b bVar, AtomicIntegerArray atomicIntegerArray) throws IOException {
            bVar.h();
            int length = atomicIntegerArray.length();
            for (int i10 = 0; i10 < length; i10++) {
                bVar.k0(atomicIntegerArray.get(i10));
            }
            bVar.o();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    public static class a0 implements com.google.gson.r {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Class f28190a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.google.gson.q f28191b;

        /* compiled from: TypeAdapters.java */
        /* loaded from: classes.dex */
        class a extends com.google.gson.q<T1> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Class f28192a;

            a(Class cls) {
                this.f28192a = cls;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object, T1] */
            @Override // com.google.gson.q
            public T1 b(com.google.gson.stream.a aVar) throws IOException {
                ?? b10 = a0.this.f28191b.b(aVar);
                if (b10 == 0 || this.f28192a.isInstance(b10)) {
                    return b10;
                }
                throw new JsonSyntaxException("Expected a " + this.f28192a.getName() + " but was " + b10.getClass().getName());
            }

            @Override // com.google.gson.q
            public void d(com.google.gson.stream.b bVar, T1 t12) throws IOException {
                a0.this.f28191b.d(bVar, t12);
            }
        }

        a0(Class cls, com.google.gson.q qVar) {
            this.f28190a = cls;
            this.f28191b = qVar;
        }

        @Override // com.google.gson.r
        public <T2> com.google.gson.q<T2> a(com.google.gson.e eVar, com.google.gson.reflect.a<T2> aVar) {
            Class<? super T2> rawType = aVar.getRawType();
            if (!this.f28190a.isAssignableFrom(rawType)) {
                return null;
            }
            return new a(rawType);
        }

        public String toString() {
            return "Factory[typeHierarchy=" + this.f28190a.getName() + ",adapter=" + this.f28191b + "]";
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    static class b extends com.google.gson.q<Number> {
        b() {
        }

        /* renamed from: e */
        public Number b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.k0() == JsonToken.NULL) {
                aVar.g0();
                return null;
            }
            try {
                return Long.valueOf(aVar.T());
            } catch (NumberFormatException e10) {
                throw new JsonSyntaxException(e10);
            }
        }

        /* renamed from: f */
        public void d(com.google.gson.stream.b bVar, Number number) throws IOException {
            bVar.o0(number);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    public static /* synthetic */ class b0 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f28194a;

        static {
            int[] iArr = new int[JsonToken.values().length];
            f28194a = iArr;
            try {
                iArr[JsonToken.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f28194a[JsonToken.BOOLEAN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f28194a[JsonToken.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f28194a[JsonToken.NULL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f28194a[JsonToken.BEGIN_ARRAY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f28194a[JsonToken.BEGIN_OBJECT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f28194a[JsonToken.END_DOCUMENT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f28194a[JsonToken.NAME.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f28194a[JsonToken.END_OBJECT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f28194a[JsonToken.END_ARRAY.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    static class c extends com.google.gson.q<Number> {
        c() {
        }

        /* renamed from: e */
        public Number b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.k0() != JsonToken.NULL) {
                return Float.valueOf((float) aVar.O());
            }
            aVar.g0();
            return null;
        }

        /* renamed from: f */
        public void d(com.google.gson.stream.b bVar, Number number) throws IOException {
            bVar.o0(number);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    static class c0 extends com.google.gson.q<Boolean> {
        c0() {
        }

        /* renamed from: e */
        public Boolean b(com.google.gson.stream.a aVar) throws IOException {
            JsonToken k02 = aVar.k0();
            if (k02 == JsonToken.NULL) {
                aVar.g0();
                return null;
            } else if (k02 == JsonToken.STRING) {
                return Boolean.valueOf(Boolean.parseBoolean(aVar.i0()));
            } else {
                return Boolean.valueOf(aVar.I());
            }
        }

        /* renamed from: f */
        public void d(com.google.gson.stream.b bVar, Boolean bool) throws IOException {
            bVar.m0(bool);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    static class d extends com.google.gson.q<Number> {
        d() {
        }

        /* renamed from: e */
        public Number b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.k0() != JsonToken.NULL) {
                return Double.valueOf(aVar.O());
            }
            aVar.g0();
            return null;
        }

        /* renamed from: f */
        public void d(com.google.gson.stream.b bVar, Number number) throws IOException {
            bVar.o0(number);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    static class d0 extends com.google.gson.q<Boolean> {
        d0() {
        }

        /* renamed from: e */
        public Boolean b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.k0() != JsonToken.NULL) {
                return Boolean.valueOf(aVar.i0());
            }
            aVar.g0();
            return null;
        }

        /* renamed from: f */
        public void d(com.google.gson.stream.b bVar, Boolean bool) throws IOException {
            bVar.r0(bool == null ? LpaConstants.VALUE_NULL : bool.toString());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    static class e extends com.google.gson.q<Number> {
        e() {
        }

        /* renamed from: e */
        public Number b(com.google.gson.stream.a aVar) throws IOException {
            JsonToken k02 = aVar.k0();
            int i10 = b0.f28194a[k02.ordinal()];
            if (i10 == 1 || i10 == 3) {
                return new LazilyParsedNumber(aVar.i0());
            }
            if (i10 == 4) {
                aVar.g0();
                return null;
            }
            throw new JsonSyntaxException("Expecting number, got: " + k02);
        }

        /* renamed from: f */
        public void d(com.google.gson.stream.b bVar, Number number) throws IOException {
            bVar.o0(number);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    static class e0 extends com.google.gson.q<Number> {
        e0() {
        }

        /* renamed from: e */
        public Number b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.k0() == JsonToken.NULL) {
                aVar.g0();
                return null;
            }
            try {
                return Byte.valueOf((byte) aVar.Q());
            } catch (NumberFormatException e10) {
                throw new JsonSyntaxException(e10);
            }
        }

        /* renamed from: f */
        public void d(com.google.gson.stream.b bVar, Number number) throws IOException {
            bVar.o0(number);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    static class f extends com.google.gson.q<Character> {
        f() {
        }

        /* renamed from: e */
        public Character b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.k0() == JsonToken.NULL) {
                aVar.g0();
                return null;
            }
            String i02 = aVar.i0();
            if (i02.length() == 1) {
                return Character.valueOf(i02.charAt(0));
            }
            throw new JsonSyntaxException("Expecting character, got: " + i02);
        }

        /* renamed from: f */
        public void d(com.google.gson.stream.b bVar, Character ch2) throws IOException {
            bVar.r0(ch2 == null ? null : String.valueOf(ch2));
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    static class f0 extends com.google.gson.q<Number> {
        f0() {
        }

        /* renamed from: e */
        public Number b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.k0() == JsonToken.NULL) {
                aVar.g0();
                return null;
            }
            try {
                return Short.valueOf((short) aVar.Q());
            } catch (NumberFormatException e10) {
                throw new JsonSyntaxException(e10);
            }
        }

        /* renamed from: f */
        public void d(com.google.gson.stream.b bVar, Number number) throws IOException {
            bVar.o0(number);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    static class g extends com.google.gson.q<String> {
        g() {
        }

        /* renamed from: e */
        public String b(com.google.gson.stream.a aVar) throws IOException {
            JsonToken k02 = aVar.k0();
            if (k02 == JsonToken.NULL) {
                aVar.g0();
                return null;
            } else if (k02 == JsonToken.BOOLEAN) {
                return Boolean.toString(aVar.I());
            } else {
                return aVar.i0();
            }
        }

        /* renamed from: f */
        public void d(com.google.gson.stream.b bVar, String str) throws IOException {
            bVar.r0(str);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    static class g0 extends com.google.gson.q<Number> {
        g0() {
        }

        /* renamed from: e */
        public Number b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.k0() == JsonToken.NULL) {
                aVar.g0();
                return null;
            }
            try {
                return Integer.valueOf(aVar.Q());
            } catch (NumberFormatException e10) {
                throw new JsonSyntaxException(e10);
            }
        }

        /* renamed from: f */
        public void d(com.google.gson.stream.b bVar, Number number) throws IOException {
            bVar.o0(number);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    static class h extends com.google.gson.q<BigDecimal> {
        h() {
        }

        /* renamed from: e */
        public BigDecimal b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.k0() == JsonToken.NULL) {
                aVar.g0();
                return null;
            }
            try {
                return new BigDecimal(aVar.i0());
            } catch (NumberFormatException e10) {
                throw new JsonSyntaxException(e10);
            }
        }

        /* renamed from: f */
        public void d(com.google.gson.stream.b bVar, BigDecimal bigDecimal) throws IOException {
            bVar.o0(bigDecimal);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    static class h0 extends com.google.gson.q<AtomicInteger> {
        h0() {
        }

        /* renamed from: e */
        public AtomicInteger b(com.google.gson.stream.a aVar) throws IOException {
            try {
                return new AtomicInteger(aVar.Q());
            } catch (NumberFormatException e10) {
                throw new JsonSyntaxException(e10);
            }
        }

        /* renamed from: f */
        public void d(com.google.gson.stream.b bVar, AtomicInteger atomicInteger) throws IOException {
            bVar.k0(atomicInteger.get());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    static class i extends com.google.gson.q<BigInteger> {
        i() {
        }

        /* renamed from: e */
        public BigInteger b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.k0() == JsonToken.NULL) {
                aVar.g0();
                return null;
            }
            try {
                return new BigInteger(aVar.i0());
            } catch (NumberFormatException e10) {
                throw new JsonSyntaxException(e10);
            }
        }

        /* renamed from: f */
        public void d(com.google.gson.stream.b bVar, BigInteger bigInteger) throws IOException {
            bVar.o0(bigInteger);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    static class i0 extends com.google.gson.q<AtomicBoolean> {
        i0() {
        }

        /* renamed from: e */
        public AtomicBoolean b(com.google.gson.stream.a aVar) throws IOException {
            return new AtomicBoolean(aVar.I());
        }

        /* renamed from: f */
        public void d(com.google.gson.stream.b bVar, AtomicBoolean atomicBoolean) throws IOException {
            bVar.t0(atomicBoolean.get());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    static class j extends com.google.gson.q<StringBuilder> {
        j() {
        }

        /* renamed from: e */
        public StringBuilder b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.k0() != JsonToken.NULL) {
                return new StringBuilder(aVar.i0());
            }
            aVar.g0();
            return null;
        }

        /* renamed from: f */
        public void d(com.google.gson.stream.b bVar, StringBuilder sb2) throws IOException {
            bVar.r0(sb2 == null ? null : sb2.toString());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    private static final class j0<T extends Enum<T>> extends com.google.gson.q<T> {

        /* renamed from: a  reason: collision with root package name */
        private final Map<String, T> f28195a = new HashMap();

        /* renamed from: b  reason: collision with root package name */
        private final Map<T, String> f28196b = new HashMap();

        public j0(Class<T> cls) {
            T[] enumConstants;
            try {
                for (T t10 : cls.getEnumConstants()) {
                    String name = t10.name();
                    h8.c cVar = (h8.c) cls.getField(name).getAnnotation(h8.c.class);
                    if (cVar != null) {
                        name = cVar.value();
                        for (String str : cVar.alternate()) {
                            this.f28195a.put(str, t10);
                        }
                    }
                    this.f28195a.put(name, t10);
                    this.f28196b.put(t10, name);
                }
            } catch (NoSuchFieldException e10) {
                throw new AssertionError(e10);
            }
        }

        /* renamed from: e */
        public T b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.k0() != JsonToken.NULL) {
                return this.f28195a.get(aVar.i0());
            }
            aVar.g0();
            return null;
        }

        /* renamed from: f */
        public void d(com.google.gson.stream.b bVar, T t10) throws IOException {
            bVar.r0(t10 == null ? null : this.f28196b.get(t10));
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    static class k extends com.google.gson.q<Class> {
        k() {
        }

        /* renamed from: e */
        public Class b(com.google.gson.stream.a aVar) throws IOException {
            throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
        }

        /* renamed from: f */
        public void d(com.google.gson.stream.b bVar, Class cls) throws IOException {
            throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + cls.getName() + ". Forgot to register a type adapter?");
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    static class l extends com.google.gson.q<StringBuffer> {
        l() {
        }

        /* renamed from: e */
        public StringBuffer b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.k0() != JsonToken.NULL) {
                return new StringBuffer(aVar.i0());
            }
            aVar.g0();
            return null;
        }

        /* renamed from: f */
        public void d(com.google.gson.stream.b bVar, StringBuffer stringBuffer) throws IOException {
            bVar.r0(stringBuffer == null ? null : stringBuffer.toString());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    static class m extends com.google.gson.q<URL> {
        m() {
        }

        /* renamed from: e */
        public URL b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.k0() == JsonToken.NULL) {
                aVar.g0();
                return null;
            }
            String i02 = aVar.i0();
            if (LpaConstants.VALUE_NULL.equals(i02)) {
                return null;
            }
            return new URL(i02);
        }

        /* renamed from: f */
        public void d(com.google.gson.stream.b bVar, URL url) throws IOException {
            bVar.r0(url == null ? null : url.toExternalForm());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: i8.n$n  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class C0310n extends com.google.gson.q<URI> {
        C0310n() {
        }

        /* renamed from: e */
        public URI b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.k0() == JsonToken.NULL) {
                aVar.g0();
                return null;
            }
            try {
                String i02 = aVar.i0();
                if (LpaConstants.VALUE_NULL.equals(i02)) {
                    return null;
                }
                return new URI(i02);
            } catch (URISyntaxException e10) {
                throw new JsonIOException(e10);
            }
        }

        /* renamed from: f */
        public void d(com.google.gson.stream.b bVar, URI uri) throws IOException {
            bVar.r0(uri == null ? null : uri.toASCIIString());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    static class o extends com.google.gson.q<InetAddress> {
        o() {
        }

        /* renamed from: e */
        public InetAddress b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.k0() != JsonToken.NULL) {
                return InetAddress.getByName(aVar.i0());
            }
            aVar.g0();
            return null;
        }

        /* renamed from: f */
        public void d(com.google.gson.stream.b bVar, InetAddress inetAddress) throws IOException {
            bVar.r0(inetAddress == null ? null : inetAddress.getHostAddress());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    static class p extends com.google.gson.q<UUID> {
        p() {
        }

        /* renamed from: e */
        public UUID b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.k0() != JsonToken.NULL) {
                return UUID.fromString(aVar.i0());
            }
            aVar.g0();
            return null;
        }

        /* renamed from: f */
        public void d(com.google.gson.stream.b bVar, UUID uuid) throws IOException {
            bVar.r0(uuid == null ? null : uuid.toString());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    static class q extends com.google.gson.q<Currency> {
        q() {
        }

        /* renamed from: e */
        public Currency b(com.google.gson.stream.a aVar) throws IOException {
            return Currency.getInstance(aVar.i0());
        }

        /* renamed from: f */
        public void d(com.google.gson.stream.b bVar, Currency currency) throws IOException {
            bVar.r0(currency.getCurrencyCode());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    static class r implements com.google.gson.r {

        /* compiled from: TypeAdapters.java */
        /* loaded from: classes.dex */
        class a extends com.google.gson.q<Timestamp> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ com.google.gson.q f28197a;

            a(r rVar, com.google.gson.q qVar) {
                this.f28197a = qVar;
            }

            /* renamed from: e */
            public Timestamp b(com.google.gson.stream.a aVar) throws IOException {
                Date date = (Date) this.f28197a.b(aVar);
                if (date != null) {
                    return new Timestamp(date.getTime());
                }
                return null;
            }

            /* renamed from: f */
            public void d(com.google.gson.stream.b bVar, Timestamp timestamp) throws IOException {
                this.f28197a.d(bVar, timestamp);
            }
        }

        r() {
        }

        @Override // com.google.gson.r
        public <T> com.google.gson.q<T> a(com.google.gson.e eVar, com.google.gson.reflect.a<T> aVar) {
            if (aVar.getRawType() != Timestamp.class) {
                return null;
            }
            return new a(this, eVar.m(Date.class));
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    static class s extends com.google.gson.q<Calendar> {
        s() {
        }

        /* renamed from: e */
        public Calendar b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.k0() == JsonToken.NULL) {
                aVar.g0();
                return null;
            }
            aVar.d();
            int i10 = 0;
            int i11 = 0;
            int i12 = 0;
            int i13 = 0;
            int i14 = 0;
            int i15 = 0;
            while (aVar.k0() != JsonToken.END_OBJECT) {
                String V = aVar.V();
                int Q = aVar.Q();
                if ("year".equals(V)) {
                    i10 = Q;
                } else if ("month".equals(V)) {
                    i11 = Q;
                } else if ("dayOfMonth".equals(V)) {
                    i12 = Q;
                } else if ("hourOfDay".equals(V)) {
                    i13 = Q;
                } else if ("minute".equals(V)) {
                    i14 = Q;
                } else if ("second".equals(V)) {
                    i15 = Q;
                }
            }
            aVar.q();
            return new GregorianCalendar(i10, i11, i12, i13, i14, i15);
        }

        /* renamed from: f */
        public void d(com.google.gson.stream.b bVar, Calendar calendar) throws IOException {
            if (calendar == null) {
                bVar.I();
                return;
            }
            bVar.i();
            bVar.x("year");
            bVar.k0(calendar.get(1));
            bVar.x("month");
            bVar.k0(calendar.get(2));
            bVar.x("dayOfMonth");
            bVar.k0(calendar.get(5));
            bVar.x("hourOfDay");
            bVar.k0(calendar.get(11));
            bVar.x("minute");
            bVar.k0(calendar.get(12));
            bVar.x("second");
            bVar.k0(calendar.get(13));
            bVar.q();
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    static class t extends com.google.gson.q<Locale> {
        t() {
        }

        /* renamed from: e */
        public Locale b(com.google.gson.stream.a aVar) throws IOException {
            String str = null;
            if (aVar.k0() == JsonToken.NULL) {
                aVar.g0();
                return null;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(aVar.i0(), "_");
            String nextToken = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String nextToken2 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            if (stringTokenizer.hasMoreElements()) {
                str = stringTokenizer.nextToken();
            }
            if (nextToken2 == null && str == null) {
                return new Locale(nextToken);
            }
            if (str == null) {
                return new Locale(nextToken, nextToken2);
            }
            return new Locale(nextToken, nextToken2, str);
        }

        /* renamed from: f */
        public void d(com.google.gson.stream.b bVar, Locale locale) throws IOException {
            bVar.r0(locale == null ? null : locale.toString());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    static class u extends com.google.gson.q<com.google.gson.k> {
        u() {
        }

        /* renamed from: e */
        public com.google.gson.k b(com.google.gson.stream.a aVar) throws IOException {
            switch (b0.f28194a[aVar.k0().ordinal()]) {
                case 1:
                    return new com.google.gson.n(new LazilyParsedNumber(aVar.i0()));
                case 2:
                    return new com.google.gson.n(Boolean.valueOf(aVar.I()));
                case 3:
                    return new com.google.gson.n(aVar.i0());
                case 4:
                    aVar.g0();
                    return com.google.gson.l.f12652a;
                case 5:
                    com.google.gson.h hVar = new com.google.gson.h();
                    aVar.c();
                    while (aVar.v()) {
                        hVar.h(b(aVar));
                    }
                    aVar.o();
                    return hVar;
                case 6:
                    com.google.gson.m mVar = new com.google.gson.m();
                    aVar.d();
                    while (aVar.v()) {
                        mVar.h(aVar.V(), b(aVar));
                    }
                    aVar.q();
                    return mVar;
                default:
                    throw new IllegalArgumentException();
            }
        }

        /* renamed from: f */
        public void d(com.google.gson.stream.b bVar, com.google.gson.k kVar) throws IOException {
            if (kVar == null || kVar.e()) {
                bVar.I();
            } else if (kVar.g()) {
                com.google.gson.n c10 = kVar.c();
                if (c10.q()) {
                    bVar.o0(c10.m());
                } else if (c10.o()) {
                    bVar.t0(c10.h());
                } else {
                    bVar.r0(c10.n());
                }
            } else if (kVar.d()) {
                bVar.h();
                Iterator<com.google.gson.k> it = kVar.a().iterator();
                while (it.hasNext()) {
                    d(bVar, it.next());
                }
                bVar.o();
            } else if (kVar.f()) {
                bVar.i();
                for (Map.Entry<String, com.google.gson.k> entry : kVar.b().entrySet()) {
                    bVar.x(entry.getKey());
                    d(bVar, entry.getValue());
                }
                bVar.q();
            } else {
                throw new IllegalArgumentException("Couldn't write " + kVar.getClass());
            }
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    static class v extends com.google.gson.q<BitSet> {
        v() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x002b, code lost:
            if (java.lang.Integer.parseInt(r1) != 0) goto L22;
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x002e, code lost:
            r5 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0067, code lost:
            if (r8.Q() != 0) goto L22;
         */
        /* renamed from: e */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public BitSet b(com.google.gson.stream.a aVar) throws IOException {
            BitSet bitSet = new BitSet();
            aVar.c();
            JsonToken k02 = aVar.k0();
            int i10 = 0;
            while (k02 != JsonToken.END_ARRAY) {
                int i11 = b0.f28194a[k02.ordinal()];
                boolean z10 = true;
                if (i11 != 1) {
                    if (i11 == 2) {
                        z10 = aVar.I();
                    } else if (i11 == 3) {
                        String i02 = aVar.i0();
                        try {
                        } catch (NumberFormatException unused) {
                            throw new JsonSyntaxException("Error: Expecting: bitset number value (1, 0), Found: " + i02);
                        }
                    } else {
                        throw new JsonSyntaxException("Invalid bitset value type: " + k02);
                    }
                    if (z10) {
                        bitSet.set(i10);
                    }
                    i10++;
                    k02 = aVar.k0();
                }
            }
            aVar.o();
            return bitSet;
        }

        /* renamed from: f */
        public void d(com.google.gson.stream.b bVar, BitSet bitSet) throws IOException {
            bVar.h();
            int length = bitSet.length();
            for (int i10 = 0; i10 < length; i10++) {
                bVar.k0(bitSet.get(i10) ? 1L : 0L);
            }
            bVar.o();
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    static class w implements com.google.gson.r {
        w() {
        }

        @Override // com.google.gson.r
        public <T> com.google.gson.q<T> a(com.google.gson.e eVar, com.google.gson.reflect.a<T> aVar) {
            Class rawType = aVar.getRawType();
            if (!Enum.class.isAssignableFrom(rawType) || rawType == Enum.class) {
                return null;
            }
            if (!rawType.isEnum()) {
                rawType = (Class<? super Object>) rawType.getSuperclass();
            }
            return new j0(rawType);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    public static class x implements com.google.gson.r {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Class f28198a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.google.gson.q f28199b;

        x(Class cls, com.google.gson.q qVar) {
            this.f28198a = cls;
            this.f28199b = qVar;
        }

        @Override // com.google.gson.r
        public <T> com.google.gson.q<T> a(com.google.gson.e eVar, com.google.gson.reflect.a<T> aVar) {
            if (aVar.getRawType() == this.f28198a) {
                return this.f28199b;
            }
            return null;
        }

        public String toString() {
            return "Factory[type=" + this.f28198a.getName() + ",adapter=" + this.f28199b + "]";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    public static class y implements com.google.gson.r {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Class f28200a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Class f28201b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ com.google.gson.q f28202c;

        y(Class cls, Class cls2, com.google.gson.q qVar) {
            this.f28200a = cls;
            this.f28201b = cls2;
            this.f28202c = qVar;
        }

        @Override // com.google.gson.r
        public <T> com.google.gson.q<T> a(com.google.gson.e eVar, com.google.gson.reflect.a<T> aVar) {
            Class<? super T> rawType = aVar.getRawType();
            if (rawType == this.f28200a || rawType == this.f28201b) {
                return this.f28202c;
            }
            return null;
        }

        public String toString() {
            return "Factory[type=" + this.f28201b.getName() + "+" + this.f28200a.getName() + ",adapter=" + this.f28202c + "]";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    public static class z implements com.google.gson.r {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Class f28203a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Class f28204b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ com.google.gson.q f28205c;

        z(Class cls, Class cls2, com.google.gson.q qVar) {
            this.f28203a = cls;
            this.f28204b = cls2;
            this.f28205c = qVar;
        }

        @Override // com.google.gson.r
        public <T> com.google.gson.q<T> a(com.google.gson.e eVar, com.google.gson.reflect.a<T> aVar) {
            Class<? super T> rawType = aVar.getRawType();
            if (rawType == this.f28203a || rawType == this.f28204b) {
                return this.f28205c;
            }
            return null;
        }

        public String toString() {
            return "Factory[type=" + this.f28203a.getName() + "+" + this.f28204b.getName() + ",adapter=" + this.f28205c + "]";
        }
    }

    static {
        com.google.gson.q<Class> a10 = new k().a();
        f28164a = a10;
        f28165b = a(Class.class, a10);
        com.google.gson.q<BitSet> a11 = new v().a();
        f28166c = a11;
        f28167d = a(BitSet.class, a11);
        c0 c0Var = new c0();
        f28168e = c0Var;
        f28170g = b(Boolean.TYPE, Boolean.class, c0Var);
        e0 e0Var = new e0();
        f28171h = e0Var;
        f28172i = b(Byte.TYPE, Byte.class, e0Var);
        f0 f0Var = new f0();
        f28173j = f0Var;
        f28174k = b(Short.TYPE, Short.class, f0Var);
        g0 g0Var = new g0();
        f28175l = g0Var;
        f28176m = b(Integer.TYPE, Integer.class, g0Var);
        com.google.gson.q<AtomicInteger> a12 = new h0().a();
        f28177n = a12;
        f28178o = a(AtomicInteger.class, a12);
        com.google.gson.q<AtomicBoolean> a13 = new i0().a();
        f28179p = a13;
        f28180q = a(AtomicBoolean.class, a13);
        com.google.gson.q<AtomicIntegerArray> a14 = new a().a();
        f28181r = a14;
        f28182s = a(AtomicIntegerArray.class, a14);
        e eVar = new e();
        f28186w = eVar;
        f28187x = a(Number.class, eVar);
        f fVar = new f();
        f28188y = fVar;
        f28189z = b(Character.TYPE, Character.class, fVar);
        g gVar = new g();
        A = gVar;
        D = a(String.class, gVar);
        j jVar = new j();
        E = jVar;
        F = a(StringBuilder.class, jVar);
        l lVar = new l();
        G = lVar;
        H = a(StringBuffer.class, lVar);
        m mVar = new m();
        I = mVar;
        J = a(URL.class, mVar);
        C0310n nVar = new C0310n();
        K = nVar;
        L = a(URI.class, nVar);
        o oVar = new o();
        M = oVar;
        N = d(InetAddress.class, oVar);
        p pVar = new p();
        O = pVar;
        P = a(UUID.class, pVar);
        com.google.gson.q<Currency> a15 = new q().a();
        Q = a15;
        R = a(Currency.class, a15);
        s sVar = new s();
        T = sVar;
        U = c(Calendar.class, GregorianCalendar.class, sVar);
        t tVar = new t();
        V = tVar;
        W = a(Locale.class, tVar);
        u uVar = new u();
        X = uVar;
        Y = d(com.google.gson.k.class, uVar);
    }

    public static <TT> com.google.gson.r a(Class<TT> cls, com.google.gson.q<TT> qVar) {
        return new x(cls, qVar);
    }

    public static <TT> com.google.gson.r b(Class<TT> cls, Class<TT> cls2, com.google.gson.q<? super TT> qVar) {
        return new y(cls, cls2, qVar);
    }

    public static <TT> com.google.gson.r c(Class<TT> cls, Class<? extends TT> cls2, com.google.gson.q<? super TT> qVar) {
        return new z(cls, cls2, qVar);
    }

    public static <T1> com.google.gson.r d(Class<T1> cls, com.google.gson.q<T1> qVar) {
        return new a0(cls, qVar);
    }
}
