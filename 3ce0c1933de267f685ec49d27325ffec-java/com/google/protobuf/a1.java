package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.e0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/* compiled from: UnknownFieldSet.java */
/* loaded from: classes.dex */
public final class a1 implements e0 {

    /* renamed from: b  reason: collision with root package name */
    private static final a1 f13156b = new a1(Collections.emptyMap());

    /* renamed from: c  reason: collision with root package name */
    private static final d f13157c = new d();

    /* renamed from: a  reason: collision with root package name */
    private Map<Integer, c> f13158a;

    /* compiled from: UnknownFieldSet.java */
    /* loaded from: classes.dex */
    public static final class b implements e0.a {

        /* renamed from: a  reason: collision with root package name */
        private Map<Integer, c> f13159a;

        /* renamed from: b  reason: collision with root package name */
        private int f13160b;

        /* renamed from: c  reason: collision with root package name */
        private c.a f13161c;

        private b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static b f() {
            b bVar = new b();
            bVar.r();
            return bVar;
        }

        private c.a i(int i10) {
            c.a aVar = this.f13161c;
            if (aVar != null) {
                int i11 = this.f13160b;
                if (i10 == i11) {
                    return aVar;
                }
                b(i11, aVar.g());
            }
            if (i10 == 0) {
                return null;
            }
            c cVar = this.f13159a.get(Integer.valueOf(i10));
            this.f13160b = i10;
            c.a s10 = c.s();
            this.f13161c = s10;
            if (cVar != null) {
                s10.i(cVar);
            }
            return this.f13161c;
        }

        private void r() {
            this.f13159a = Collections.emptyMap();
            this.f13160b = 0;
            this.f13161c = null;
        }

        public b b(int i10, c cVar) {
            if (i10 != 0) {
                if (this.f13161c != null && this.f13160b == i10) {
                    this.f13161c = null;
                    this.f13160b = 0;
                }
                if (this.f13159a.isEmpty()) {
                    this.f13159a = new TreeMap();
                }
                this.f13159a.put(Integer.valueOf(i10), cVar);
                return this;
            }
            throw new IllegalArgumentException("Zero is not a valid field number.");
        }

        /* renamed from: c */
        public a1 build() {
            a1 a1Var;
            i(0);
            if (this.f13159a.isEmpty()) {
                a1Var = a1.c();
            } else {
                a1Var = new a1(Collections.unmodifiableMap(this.f13159a));
            }
            this.f13159a = null;
            return a1Var;
        }

        /* renamed from: d */
        public a1 buildPartial() {
            return build();
        }

        /* renamed from: e */
        public b clone() {
            i(0);
            return a1.g().o(new a1(this.f13159a));
        }

        /* renamed from: g */
        public a1 getDefaultInstanceForType() {
            return a1.c();
        }

        @Override // com.google.protobuf.f0
        public boolean isInitialized() {
            return true;
        }

        public boolean j(int i10) {
            if (i10 != 0) {
                return i10 == this.f13160b || this.f13159a.containsKey(Integer.valueOf(i10));
            }
            throw new IllegalArgumentException("Zero is not a valid field number.");
        }

        public b k(int i10, c cVar) {
            if (i10 != 0) {
                if (j(i10)) {
                    i(i10).i(cVar);
                } else {
                    b(i10, cVar);
                }
                return this;
            }
            throw new IllegalArgumentException("Zero is not a valid field number.");
        }

        public boolean l(int i10, i iVar) throws IOException {
            int a10 = WireFormat.a(i10);
            int b10 = WireFormat.b(i10);
            if (b10 == 0) {
                i(a10).f(iVar.u());
                return true;
            } else if (b10 == 1) {
                i(a10).c(iVar.q());
                return true;
            } else if (b10 == 2) {
                i(a10).e(iVar.m());
                return true;
            } else if (b10 == 3) {
                b g10 = a1.g();
                iVar.s(a10, g10, o.e());
                i(a10).d(g10.build());
                return true;
            } else if (b10 == 4) {
                return false;
            } else {
                if (b10 == 5) {
                    i(a10).b(iVar.p());
                    return true;
                }
                throw InvalidProtocolBufferException.d();
            }
        }

        public b m(i iVar) throws IOException {
            int F;
            do {
                F = iVar.F();
                if (F == 0) {
                    break;
                }
            } while (l(F, iVar));
            return this;
        }

        /* renamed from: n */
        public b mergeFrom(i iVar, q qVar) throws IOException {
            return m(iVar);
        }

        public b o(a1 a1Var) {
            if (a1Var != a1.c()) {
                for (Map.Entry entry : a1Var.f13158a.entrySet()) {
                    k(((Integer) entry.getKey()).intValue(), (c) entry.getValue());
                }
            }
            return this;
        }

        /* renamed from: p */
        public b mergeFrom(byte[] bArr) throws InvalidProtocolBufferException {
            try {
                i g10 = i.g(bArr);
                m(g10);
                g10.a(0);
                return this;
            } catch (InvalidProtocolBufferException e10) {
                throw e10;
            } catch (IOException e11) {
                throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", e11);
            }
        }

        public b q(int i10, int i11) {
            if (i10 != 0) {
                i(i10).f(i11);
                return this;
            }
            throw new IllegalArgumentException("Zero is not a valid field number.");
        }
    }

    /* compiled from: UnknownFieldSet.java */
    /* loaded from: classes.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        private List<Long> f13162a;

        /* renamed from: b  reason: collision with root package name */
        private List<Integer> f13163b;

        /* renamed from: c  reason: collision with root package name */
        private List<Long> f13164c;

        /* renamed from: d  reason: collision with root package name */
        private List<ByteString> f13165d;

        /* renamed from: e  reason: collision with root package name */
        private List<a1> f13166e;

        /* compiled from: UnknownFieldSet.java */
        /* loaded from: classes.dex */
        public static final class a {

            /* renamed from: a  reason: collision with root package name */
            private c f13167a;

            private a() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static a h() {
                a aVar = new a();
                aVar.f13167a = new c();
                return aVar;
            }

            public a b(int i10) {
                if (this.f13167a.f13163b == null) {
                    this.f13167a.f13163b = new ArrayList();
                }
                this.f13167a.f13163b.add(Integer.valueOf(i10));
                return this;
            }

            public a c(long j10) {
                if (this.f13167a.f13164c == null) {
                    this.f13167a.f13164c = new ArrayList();
                }
                this.f13167a.f13164c.add(Long.valueOf(j10));
                return this;
            }

            public a d(a1 a1Var) {
                if (this.f13167a.f13166e == null) {
                    this.f13167a.f13166e = new ArrayList();
                }
                this.f13167a.f13166e.add(a1Var);
                return this;
            }

            public a e(ByteString byteString) {
                if (this.f13167a.f13165d == null) {
                    this.f13167a.f13165d = new ArrayList();
                }
                this.f13167a.f13165d.add(byteString);
                return this;
            }

            public a f(long j10) {
                if (this.f13167a.f13162a == null) {
                    this.f13167a.f13162a = new ArrayList();
                }
                this.f13167a.f13162a.add(Long.valueOf(j10));
                return this;
            }

            public c g() {
                if (this.f13167a.f13162a == null) {
                    this.f13167a.f13162a = Collections.emptyList();
                } else {
                    c cVar = this.f13167a;
                    cVar.f13162a = Collections.unmodifiableList(cVar.f13162a);
                }
                if (this.f13167a.f13163b == null) {
                    this.f13167a.f13163b = Collections.emptyList();
                } else {
                    c cVar2 = this.f13167a;
                    cVar2.f13163b = Collections.unmodifiableList(cVar2.f13163b);
                }
                if (this.f13167a.f13164c == null) {
                    this.f13167a.f13164c = Collections.emptyList();
                } else {
                    c cVar3 = this.f13167a;
                    cVar3.f13164c = Collections.unmodifiableList(cVar3.f13164c);
                }
                if (this.f13167a.f13165d == null) {
                    this.f13167a.f13165d = Collections.emptyList();
                } else {
                    c cVar4 = this.f13167a;
                    cVar4.f13165d = Collections.unmodifiableList(cVar4.f13165d);
                }
                if (this.f13167a.f13166e == null) {
                    this.f13167a.f13166e = Collections.emptyList();
                } else {
                    c cVar5 = this.f13167a;
                    cVar5.f13166e = Collections.unmodifiableList(cVar5.f13166e);
                }
                c cVar6 = this.f13167a;
                this.f13167a = null;
                return cVar6;
            }

            public a i(c cVar) {
                if (!cVar.f13162a.isEmpty()) {
                    if (this.f13167a.f13162a == null) {
                        this.f13167a.f13162a = new ArrayList();
                    }
                    this.f13167a.f13162a.addAll(cVar.f13162a);
                }
                if (!cVar.f13163b.isEmpty()) {
                    if (this.f13167a.f13163b == null) {
                        this.f13167a.f13163b = new ArrayList();
                    }
                    this.f13167a.f13163b.addAll(cVar.f13163b);
                }
                if (!cVar.f13164c.isEmpty()) {
                    if (this.f13167a.f13164c == null) {
                        this.f13167a.f13164c = new ArrayList();
                    }
                    this.f13167a.f13164c.addAll(cVar.f13164c);
                }
                if (!cVar.f13165d.isEmpty()) {
                    if (this.f13167a.f13165d == null) {
                        this.f13167a.f13165d = new ArrayList();
                    }
                    this.f13167a.f13165d.addAll(cVar.f13165d);
                }
                if (!cVar.f13166e.isEmpty()) {
                    if (this.f13167a.f13166e == null) {
                        this.f13167a.f13166e = new ArrayList();
                    }
                    this.f13167a.f13166e.addAll(cVar.f13166e);
                }
                return this;
            }
        }

        static {
            s().g();
        }

        private Object[] n() {
            return new Object[]{this.f13162a, this.f13163b, this.f13164c, this.f13165d, this.f13166e};
        }

        public static a s() {
            return a.h();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            return Arrays.equals(n(), ((c) obj).n());
        }

        public int hashCode() {
            return Arrays.hashCode(n());
        }

        public List<Integer> k() {
            return this.f13163b;
        }

        public List<Long> l() {
            return this.f13164c;
        }

        public List<a1> m() {
            return this.f13166e;
        }

        public List<ByteString> o() {
            return this.f13165d;
        }

        public int p(int i10) {
            int i11 = 0;
            for (Long l10 : this.f13162a) {
                i11 += CodedOutputStream.S(i10, l10.longValue());
            }
            for (Integer num : this.f13163b) {
                i11 += CodedOutputStream.n(i10, num.intValue());
            }
            for (Long l11 : this.f13164c) {
                i11 += CodedOutputStream.p(i10, l11.longValue());
            }
            for (ByteString byteString : this.f13165d) {
                i11 += CodedOutputStream.h(i10, byteString);
            }
            for (a1 a1Var : this.f13166e) {
                i11 += CodedOutputStream.t(i10, a1Var);
            }
            return i11;
        }

        public int q(int i10) {
            int i11 = 0;
            for (ByteString byteString : this.f13165d) {
                i11 += CodedOutputStream.H(i10, byteString);
            }
            return i11;
        }

        public List<Long> r() {
            return this.f13162a;
        }

        public void t(int i10, CodedOutputStream codedOutputStream) throws IOException {
            for (ByteString byteString : this.f13165d) {
                codedOutputStream.D0(i10, byteString);
            }
        }

        public void u(int i10, CodedOutputStream codedOutputStream) throws IOException {
            for (Long l10 : this.f13162a) {
                codedOutputStream.O0(i10, l10.longValue());
            }
            for (Integer num : this.f13163b) {
                codedOutputStream.o0(i10, num.intValue());
            }
            for (Long l11 : this.f13164c) {
                codedOutputStream.q0(i10, l11.longValue());
            }
            for (ByteString byteString : this.f13165d) {
                codedOutputStream.i0(i10, byteString);
            }
            for (a1 a1Var : this.f13166e) {
                codedOutputStream.u0(i10, a1Var);
            }
        }

        private c() {
        }
    }

    /* compiled from: UnknownFieldSet.java */
    /* loaded from: classes.dex */
    public static final class d extends com.google.protobuf.c<a1> {
        /* renamed from: a */
        public a1 parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
            b g10 = a1.g();
            try {
                g10.m(iVar);
                return g10.buildPartial();
            } catch (InvalidProtocolBufferException e10) {
                throw e10.setUnfinishedMessage(g10.buildPartial());
            } catch (IOException e11) {
                throw new InvalidProtocolBufferException(e11.getMessage()).setUnfinishedMessage(g10.buildPartial());
            }
        }
    }

    public static a1 c() {
        return f13156b;
    }

    public static b g() {
        return b.f();
    }

    public static b h(a1 a1Var) {
        return g().o(a1Var);
    }

    public Map<Integer, c> b() {
        return this.f13158a;
    }

    /* renamed from: d */
    public a1 getDefaultInstanceForType() {
        return f13156b;
    }

    /* renamed from: e */
    public final d getParserForType() {
        return f13157c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a1) && this.f13158a.equals(((a1) obj).f13158a);
    }

    public int f() {
        int i10 = 0;
        for (Map.Entry<Integer, c> entry : this.f13158a.entrySet()) {
            i10 += entry.getValue().q(entry.getKey().intValue());
        }
        return i10;
    }

    @Override // com.google.protobuf.e0
    public int getSerializedSize() {
        int i10 = 0;
        for (Map.Entry<Integer, c> entry : this.f13158a.entrySet()) {
            i10 += entry.getValue().p(entry.getKey().intValue());
        }
        return i10;
    }

    public int hashCode() {
        return this.f13158a.hashCode();
    }

    /* renamed from: i */
    public b newBuilderForType() {
        return g();
    }

    @Override // com.google.protobuf.f0
    public boolean isInitialized() {
        return true;
    }

    /* renamed from: j */
    public b toBuilder() {
        return g().o(this);
    }

    public void k(CodedOutputStream codedOutputStream) throws IOException {
        for (Map.Entry<Integer, c> entry : this.f13158a.entrySet()) {
            entry.getValue().t(entry.getKey().intValue(), codedOutputStream);
        }
    }

    @Override // com.google.protobuf.e0
    public byte[] toByteArray() {
        try {
            byte[] bArr = new byte[getSerializedSize()];
            CodedOutputStream a02 = CodedOutputStream.a0(bArr);
            writeTo(a02);
            a02.d();
            return bArr;
        } catch (IOException e10) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e10);
        }
    }

    @Override // com.google.protobuf.e0
    public ByteString toByteString() {
        try {
            ByteString.f i10 = ByteString.i(getSerializedSize());
            writeTo(i10.b());
            return i10.a();
        } catch (IOException e10) {
            throw new RuntimeException("Serializing to a ByteString threw an IOException (should never happen).", e10);
        }
    }

    public String toString() {
        return TextFormat.p(this);
    }

    @Override // com.google.protobuf.e0
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        for (Map.Entry<Integer, c> entry : this.f13158a.entrySet()) {
            entry.getValue().u(entry.getKey().intValue(), codedOutputStream);
        }
    }

    private a1() {
    }

    private a1(Map<Integer, c> map) {
        this.f13158a = map;
    }
}
