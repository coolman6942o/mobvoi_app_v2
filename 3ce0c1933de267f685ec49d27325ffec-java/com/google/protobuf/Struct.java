package com.google.protobuf;

import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.WireFormat;
import com.google.protobuf.a;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Objects;
/* loaded from: classes.dex */
public final class Struct extends GeneratedMessageV3 implements u0 {
    public static final int FIELDS_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private c0<String, Value> fields_;
    private byte memoizedIsInitialized;
    private static final Struct DEFAULT_INSTANCE = new Struct();
    private static final l0<Struct> PARSER = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a extends com.google.protobuf.c<Struct> {
        a() {
        }

        /* renamed from: a */
        public Struct parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
            return new Struct(iVar, qVar, null);
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends GeneratedMessageV3.b<b> implements u0 {

        /* renamed from: a  reason: collision with root package name */
        private c0<String, Value> f13110a;

        /* synthetic */ b(GeneratedMessageV3.c cVar, a aVar) {
            this(cVar);
        }

        private c0<String, Value> j() {
            c0<String, Value> c0Var = this.f13110a;
            return c0Var == null ? c0.h(c.f13111a) : c0Var;
        }

        private c0<String, Value> k() {
            onChanged();
            if (this.f13110a == null) {
                this.f13110a = c0.q(c.f13111a);
            }
            if (!this.f13110a.n()) {
                this.f13110a = this.f13110a.g();
            }
            return this.f13110a;
        }

        private void maybeForceBuilderInitialization() {
            boolean z10 = GeneratedMessageV3.alwaysUseFieldBuilders;
        }

        /* renamed from: a */
        public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (b) super.addRepeatedField(fieldDescriptor, obj);
        }

        /* renamed from: b */
        public Struct build() {
            Struct c10 = buildPartial();
            if (c10.isInitialized()) {
                return c10;
            }
            throw a.AbstractC0170a.newUninitializedMessageException((d0) c10);
        }

        /* renamed from: c */
        public Struct buildPartial() {
            Struct struct = new Struct(this, (a) null);
            struct.fields_ = j();
            struct.fields_.o();
            onBuilt();
            return struct;
        }

        /* renamed from: d */
        public b clear() {
            super.clear();
            k().b();
            return this;
        }

        /* renamed from: e */
        public b clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (b) super.clearField(fieldDescriptor);
        }

        /* renamed from: f */
        public b clearOneof(Descriptors.h hVar) {
            return (b) super.clearOneof(hVar);
        }

        /* renamed from: g */
        public b clone() {
            return (b) super.clone();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a, com.google.protobuf.g0
        public Descriptors.b getDescriptorForType() {
            return v0.f13370a;
        }

        /* renamed from: i */
        public Struct getDefaultInstanceForType() {
            return Struct.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.b
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return v0.f13371b.e(Struct.class, b.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.b
        protected c0 internalGetMapField(int i10) {
            if (i10 == 1) {
                return j();
            }
            throw new RuntimeException("Invalid map field number: " + i10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.b
        protected c0 internalGetMutableMapField(int i10) {
            if (i10 == 1) {
                return k();
            }
            throw new RuntimeException("Invalid map field number: " + i10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.f0
        public final boolean isInitialized() {
            return true;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0023  */
        /* renamed from: l */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b mergeFrom(i iVar, q qVar) throws IOException {
            Throwable th2;
            Struct struct = null;
            try {
                try {
                    Struct struct2 = (Struct) Struct.PARSER.parsePartialFrom(iVar, qVar);
                    if (struct2 != null) {
                        n(struct2);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e10) {
                    struct = (Struct) e10.getUnfinishedMessage();
                    try {
                        throw e10.unwrapIOException();
                    } catch (Throwable th3) {
                        th2 = th3;
                        if (struct != null) {
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th4) {
                th2 = th4;
                if (struct != null) {
                    n(struct);
                }
                throw th2;
            }
        }

        /* renamed from: m */
        public b mergeFrom(d0 d0Var) {
            if (d0Var instanceof Struct) {
                return n((Struct) d0Var);
            }
            super.mergeFrom(d0Var);
            return this;
        }

        public b n(Struct struct) {
            if (struct == Struct.getDefaultInstance()) {
                return this;
            }
            k().p(struct.g());
            onChanged();
            return this;
        }

        /* renamed from: o */
        public final b mergeUnknownFields(a1 a1Var) {
            return this;
        }

        /* renamed from: p */
        public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (b) super.setField(fieldDescriptor, obj);
        }

        /* renamed from: q */
        public b setRepeatedField2(Descriptors.FieldDescriptor fieldDescriptor, int i10, Object obj) {
            return (b) super.setRepeatedField(fieldDescriptor, i10, obj);
        }

        /* renamed from: r */
        public final b setUnknownFields(a1 a1Var) {
            return this;
        }

        /* synthetic */ b(a aVar) {
            this();
        }

        private b() {
            maybeForceBuilderInitialization();
        }

        private b(GeneratedMessageV3.c cVar) {
            super(cVar);
            maybeForceBuilderInitialization();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        static final a0<String, Value> f13111a = a0.l(v0.f13372c, WireFormat.FieldType.STRING, "", WireFormat.FieldType.MESSAGE, Value.getDefaultInstance());
    }

    /* synthetic */ Struct(i iVar, q qVar, a aVar) throws InvalidProtocolBufferException {
        this(iVar, qVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c0<String, Value> g() {
        c0<String, Value> c0Var = this.fields_;
        return c0Var == null ? c0.h(c.f13111a) : c0Var;
    }

    public static Struct getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.b getDescriptor() {
        return v0.f13370a;
    }

    public static b newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Struct parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Struct) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Struct parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static l0<Struct> parser() {
        return PARSER;
    }

    public boolean containsFields(String str) {
        Objects.requireNonNull(str);
        return g().j().containsKey(str);
    }

    @Override // com.google.protobuf.a
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Struct)) {
            return super.equals(obj);
        }
        return g().equals(((Struct) obj).g());
    }

    @Deprecated
    public Map<String, Value> getFields() {
        return getFieldsMap();
    }

    public int getFieldsCount() {
        return g().j().size();
    }

    public Map<String, Value> getFieldsMap() {
        return g().j();
    }

    public Value getFieldsOrDefault(String str, Value value) {
        Objects.requireNonNull(str);
        Map<String, Value> j10 = g().j();
        return j10.containsKey(str) ? j10.get(str) : value;
    }

    public Value getFieldsOrThrow(String str) {
        Objects.requireNonNull(str);
        Map<String, Value> j10 = g().j();
        if (j10.containsKey(str)) {
            return j10.get(str);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
    public l0<Struct> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
    public int getSerializedSize() {
        int i10 = this.memoizedSize;
        if (i10 != -1) {
            return i10;
        }
        int i11 = 0;
        for (Map.Entry<String, Value> entry : g().j().entrySet()) {
            i11 += CodedOutputStream.E(1, c.f13111a.newBuilderForType().n(entry.getKey()).p(entry.getValue()).build());
        }
        this.memoizedSize = i11;
        return i11;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.g0
    public final a1 getUnknownFields() {
        return a1.c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: h */
    public b newBuilderForType(GeneratedMessageV3.c cVar) {
        return new b(cVar, null);
    }

    @Override // com.google.protobuf.a
    public int hashCode() {
        int i10 = this.memoizedHashCode;
        if (i10 != 0) {
            return i10;
        }
        int hashCode = 779 + getDescriptorForType().hashCode();
        if (!g().j().isEmpty()) {
            hashCode = (((hashCode * 37) + 1) * 53) + g().hashCode();
        }
        int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode2;
        return hashCode2;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
        return v0.f13371b.e(Struct.class, b.class);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    protected c0 internalGetMapField(int i10) {
        if (i10 == 1) {
            return g();
        }
        throw new RuntimeException("Invalid map field number: " + i10);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.f0
    public final boolean isInitialized() {
        byte b10 = this.memoizedIsInitialized;
        if (b10 == 1) {
            return true;
        }
        if (b10 == 0) {
            return false;
        }
        this.memoizedIsInitialized = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        GeneratedMessageV3.serializeStringMapTo(codedOutputStream, g(), c.f13111a, 1);
    }

    /* synthetic */ Struct(GeneratedMessageV3.b bVar, a aVar) {
        this(bVar);
    }

    public static b newBuilder(Struct struct) {
        return DEFAULT_INSTANCE.toBuilder().n(struct);
    }

    public static Struct parseFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, qVar);
    }

    private Struct(GeneratedMessageV3.b<?> bVar) {
        super(bVar);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static Struct parseDelimitedFrom(InputStream inputStream, q qVar) throws IOException {
        return (Struct) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
    }

    public static Struct parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
    public Struct getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
    public b toBuilder() {
        return this == DEFAULT_INSTANCE ? new b((a) null) : new b((a) null).n(this);
    }

    public static Struct parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, qVar);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
    public b newBuilderForType() {
        return newBuilder();
    }

    private Struct() {
        this.memoizedIsInitialized = (byte) -1;
    }

    public static Struct parseFrom(InputStream inputStream) throws IOException {
        return (Struct) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    /* JADX WARN: Type inference failed for: r2v7, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object] */
    private Struct(i iVar, q qVar) throws InvalidProtocolBufferException {
        this();
        boolean z10 = false;
        boolean z11 = false;
        while (!z10) {
            try {
                try {
                    int F = iVar.F();
                    if (F != 0) {
                        if (F == 10) {
                            if (!z11 || !true) {
                                this.fields_ = c0.q(c.f13111a);
                                z11 |= true;
                            }
                            a0 a0Var = (a0) iVar.v(c.f13111a.getParserForType(), qVar);
                            this.fields_.m().put(a0Var.h(), a0Var.i());
                        } else if (!iVar.I(F)) {
                        }
                    }
                    z10 = true;
                } catch (InvalidProtocolBufferException e10) {
                    throw e10.setUnfinishedMessage(this);
                } catch (IOException e11) {
                    throw new InvalidProtocolBufferException(e11).setUnfinishedMessage(this);
                }
            } finally {
                makeExtensionsImmutable();
            }
        }
    }

    public static Struct parseFrom(InputStream inputStream, q qVar) throws IOException {
        return (Struct) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
    }

    public static Struct parseFrom(i iVar) throws IOException {
        return (Struct) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
    }

    public static Struct parseFrom(i iVar, q qVar) throws IOException {
        return (Struct) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
    }
}
