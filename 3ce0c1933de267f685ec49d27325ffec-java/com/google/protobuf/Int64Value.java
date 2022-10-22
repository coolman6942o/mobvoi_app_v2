package com.google.protobuf;

import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.a;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes.dex */
public final class Int64Value extends GeneratedMessageV3 implements g0 {
    private static final Int64Value DEFAULT_INSTANCE = new Int64Value();
    private static final l0<Int64Value> PARSER = new a();
    public static final int VALUE_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private byte memoizedIsInitialized;
    private long value_;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a extends c<Int64Value> {
        a() {
        }

        /* renamed from: a */
        public Int64Value parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
            return new Int64Value(iVar, qVar, null);
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends GeneratedMessageV3.b<b> implements g0 {

        /* renamed from: a  reason: collision with root package name */
        private long f13087a;

        /* synthetic */ b(GeneratedMessageV3.c cVar, a aVar) {
            this(cVar);
        }

        private void maybeForceBuilderInitialization() {
            boolean z10 = GeneratedMessageV3.alwaysUseFieldBuilders;
        }

        /* renamed from: a */
        public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (b) super.addRepeatedField(fieldDescriptor, obj);
        }

        /* renamed from: b */
        public Int64Value build() {
            Int64Value c10 = buildPartial();
            if (c10.isInitialized()) {
                return c10;
            }
            throw a.AbstractC0170a.newUninitializedMessageException((d0) c10);
        }

        /* renamed from: c */
        public Int64Value buildPartial() {
            Int64Value int64Value = new Int64Value(this, (a) null);
            int64Value.value_ = this.f13087a;
            onBuilt();
            return int64Value;
        }

        /* renamed from: d */
        public b clear() {
            super.clear();
            this.f13087a = 0L;
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
            return f1.f13227e;
        }

        /* renamed from: i */
        public Int64Value getDefaultInstanceForType() {
            return Int64Value.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.b
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return f1.f13228f.e(Int64Value.class, b.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.f0
        public final boolean isInitialized() {
            return true;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0023  */
        /* renamed from: j */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b mergeFrom(i iVar, q qVar) throws IOException {
            Throwable th2;
            Int64Value int64Value = null;
            try {
                try {
                    Int64Value int64Value2 = (Int64Value) Int64Value.PARSER.parsePartialFrom(iVar, qVar);
                    if (int64Value2 != null) {
                        k(int64Value2);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e10) {
                    int64Value = (Int64Value) e10.getUnfinishedMessage();
                    try {
                        throw e10.unwrapIOException();
                    } catch (Throwable th3) {
                        th2 = th3;
                        if (int64Value != null) {
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th4) {
                th2 = th4;
                if (int64Value != null) {
                    k(int64Value);
                }
                throw th2;
            }
        }

        public b k(Int64Value int64Value) {
            if (int64Value == Int64Value.getDefaultInstance()) {
                return this;
            }
            if (int64Value.getValue() != 0) {
                q(int64Value.getValue());
            }
            onChanged();
            return this;
        }

        /* renamed from: l */
        public b mergeFrom(d0 d0Var) {
            if (d0Var instanceof Int64Value) {
                return k((Int64Value) d0Var);
            }
            super.mergeFrom(d0Var);
            return this;
        }

        /* renamed from: m */
        public final b mergeUnknownFields(a1 a1Var) {
            return this;
        }

        /* renamed from: n */
        public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (b) super.setField(fieldDescriptor, obj);
        }

        /* renamed from: o */
        public b setRepeatedField2(Descriptors.FieldDescriptor fieldDescriptor, int i10, Object obj) {
            return (b) super.setRepeatedField(fieldDescriptor, i10, obj);
        }

        /* renamed from: p */
        public final b setUnknownFields(a1 a1Var) {
            return this;
        }

        public b q(long j10) {
            this.f13087a = j10;
            onChanged();
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

    /* synthetic */ Int64Value(i iVar, q qVar, a aVar) throws InvalidProtocolBufferException {
        this(iVar, qVar);
    }

    public static Int64Value getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.b getDescriptor() {
        return f1.f13227e;
    }

    public static b newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Int64Value parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Int64Value) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Int64Value parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static l0<Int64Value> parser() {
        return PARSER;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c */
    public b newBuilderForType(GeneratedMessageV3.c cVar) {
        return new b(cVar, null);
    }

    @Override // com.google.protobuf.a
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Int64Value)) {
            return super.equals(obj);
        }
        return getValue() == ((Int64Value) obj).getValue();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
    public l0<Int64Value> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
    public int getSerializedSize() {
        int i10 = this.memoizedSize;
        if (i10 != -1) {
            return i10;
        }
        int i11 = 0;
        long j10 = this.value_;
        if (j10 != 0) {
            i11 = 0 + CodedOutputStream.x(1, j10);
        }
        this.memoizedSize = i11;
        return i11;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.g0
    public final a1 getUnknownFields() {
        return a1.c();
    }

    public long getValue() {
        return this.value_;
    }

    @Override // com.google.protobuf.a
    public int hashCode() {
        int i10 = this.memoizedHashCode;
        if (i10 != 0) {
            return i10;
        }
        int hashCode = ((((((779 + getDescriptorForType().hashCode()) * 37) + 1) * 53) + u.h(getValue())) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode;
        return hashCode;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
        return f1.f13228f.e(Int64Value.class, b.class);
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
        long j10 = this.value_;
        if (j10 != 0) {
            codedOutputStream.y0(1, j10);
        }
    }

    /* synthetic */ Int64Value(GeneratedMessageV3.b bVar, a aVar) {
        this(bVar);
    }

    public static b newBuilder(Int64Value int64Value) {
        return DEFAULT_INSTANCE.toBuilder().k(int64Value);
    }

    public static Int64Value parseFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, qVar);
    }

    private Int64Value(GeneratedMessageV3.b<?> bVar) {
        super(bVar);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static Int64Value parseDelimitedFrom(InputStream inputStream, q qVar) throws IOException {
        return (Int64Value) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
    }

    public static Int64Value parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
    public Int64Value getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
    public b toBuilder() {
        return this == DEFAULT_INSTANCE ? new b((a) null) : new b((a) null).k(this);
    }

    public static Int64Value parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, qVar);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
    public b newBuilderForType() {
        return newBuilder();
    }

    private Int64Value() {
        this.memoizedIsInitialized = (byte) -1;
        this.value_ = 0L;
    }

    public static Int64Value parseFrom(InputStream inputStream) throws IOException {
        return (Int64Value) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static Int64Value parseFrom(InputStream inputStream, q qVar) throws IOException {
        return (Int64Value) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
    }

    private Int64Value(i iVar, q qVar) throws InvalidProtocolBufferException {
        this();
        boolean z10 = false;
        while (!z10) {
            try {
                try {
                    try {
                        int F = iVar.F();
                        z10 = true;
                        if (F != 0) {
                            if (F == 8) {
                                this.value_ = iVar.u();
                            } else if (!iVar.I(F)) {
                            }
                        }
                    } catch (IOException e10) {
                        throw new InvalidProtocolBufferException(e10).setUnfinishedMessage(this);
                    }
                } catch (InvalidProtocolBufferException e11) {
                    throw e11.setUnfinishedMessage(this);
                }
            } finally {
                makeExtensionsImmutable();
            }
        }
    }

    public static Int64Value parseFrom(i iVar) throws IOException {
        return (Int64Value) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
    }

    public static Int64Value parseFrom(i iVar, q qVar) throws IOException {
        return (Int64Value) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
    }
}
