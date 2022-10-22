package com.google.protobuf;

import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.a;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes.dex */
public final class DoubleValue extends GeneratedMessageV3 implements g0 {
    private static final DoubleValue DEFAULT_INSTANCE = new DoubleValue();
    private static final l0<DoubleValue> PARSER = new a();
    public static final int VALUE_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private byte memoizedIsInitialized;
    private double value_;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a extends c<DoubleValue> {
        a() {
        }

        /* renamed from: a */
        public DoubleValue parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
            return new DoubleValue(iVar, qVar, null);
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends GeneratedMessageV3.b<b> implements g0 {

        /* renamed from: a  reason: collision with root package name */
        private double f12979a;

        /* synthetic */ b(a aVar) {
            this();
        }

        private void maybeForceBuilderInitialization() {
            boolean z10 = GeneratedMessageV3.alwaysUseFieldBuilders;
        }

        /* renamed from: a */
        public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (b) super.addRepeatedField(fieldDescriptor, obj);
        }

        /* renamed from: b */
        public DoubleValue build() {
            DoubleValue c10 = buildPartial();
            if (c10.isInitialized()) {
                return c10;
            }
            throw a.AbstractC0170a.newUninitializedMessageException((d0) c10);
        }

        /* renamed from: c */
        public DoubleValue buildPartial() {
            DoubleValue doubleValue = new DoubleValue(this, (a) null);
            doubleValue.value_ = this.f12979a;
            onBuilt();
            return doubleValue;
        }

        /* renamed from: d */
        public b clear() {
            super.clear();
            this.f12979a = 0.0d;
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
            return f1.f13223a;
        }

        /* renamed from: i */
        public DoubleValue getDefaultInstanceForType() {
            return DoubleValue.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.b
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return f1.f13224b.e(DoubleValue.class, b.class);
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
            DoubleValue doubleValue = null;
            try {
                try {
                    DoubleValue doubleValue2 = (DoubleValue) DoubleValue.PARSER.parsePartialFrom(iVar, qVar);
                    if (doubleValue2 != null) {
                        k(doubleValue2);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e10) {
                    doubleValue = (DoubleValue) e10.getUnfinishedMessage();
                    try {
                        throw e10.unwrapIOException();
                    } catch (Throwable th3) {
                        th2 = th3;
                        if (doubleValue != null) {
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th4) {
                th2 = th4;
                if (doubleValue != null) {
                    k(doubleValue);
                }
                throw th2;
            }
        }

        public b k(DoubleValue doubleValue) {
            if (doubleValue == DoubleValue.getDefaultInstance()) {
                return this;
            }
            if (doubleValue.getValue() != 0.0d) {
                q(doubleValue.getValue());
            }
            onChanged();
            return this;
        }

        /* renamed from: l */
        public b mergeFrom(d0 d0Var) {
            if (d0Var instanceof DoubleValue) {
                return k((DoubleValue) d0Var);
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

        public b q(double d10) {
            this.f12979a = d10;
            onChanged();
            return this;
        }

        /* synthetic */ b(GeneratedMessageV3.c cVar, a aVar) {
            this(cVar);
        }

        private b() {
            maybeForceBuilderInitialization();
        }

        private b(GeneratedMessageV3.c cVar) {
            super(cVar);
            maybeForceBuilderInitialization();
        }
    }

    /* synthetic */ DoubleValue(i iVar, q qVar, a aVar) throws InvalidProtocolBufferException {
        this(iVar, qVar);
    }

    public static DoubleValue getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.b getDescriptor() {
        return f1.f13223a;
    }

    public static b newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static DoubleValue parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (DoubleValue) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static DoubleValue parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static l0<DoubleValue> parser() {
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
        if (!(obj instanceof DoubleValue)) {
            return super.equals(obj);
        }
        return Double.doubleToLongBits(getValue()) == Double.doubleToLongBits(((DoubleValue) obj).getValue());
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
    public l0<DoubleValue> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
    public int getSerializedSize() {
        int i10 = this.memoizedSize;
        if (i10 != -1) {
            return i10;
        }
        int i11 = 0;
        double d10 = this.value_;
        if (d10 != 0.0d) {
            i11 = 0 + CodedOutputStream.j(1, d10);
        }
        this.memoizedSize = i11;
        return i11;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.g0
    public final a1 getUnknownFields() {
        return a1.c();
    }

    public double getValue() {
        return this.value_;
    }

    @Override // com.google.protobuf.a
    public int hashCode() {
        int i10 = this.memoizedHashCode;
        if (i10 != 0) {
            return i10;
        }
        int hashCode = ((((((779 + getDescriptorForType().hashCode()) * 37) + 1) * 53) + u.h(Double.doubleToLongBits(getValue()))) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode;
        return hashCode;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
        return f1.f13224b.e(DoubleValue.class, b.class);
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
        double d10 = this.value_;
        if (d10 != 0.0d) {
            codedOutputStream.k0(1, d10);
        }
    }

    /* synthetic */ DoubleValue(GeneratedMessageV3.b bVar, a aVar) {
        this(bVar);
    }

    public static b newBuilder(DoubleValue doubleValue) {
        return DEFAULT_INSTANCE.toBuilder().k(doubleValue);
    }

    public static DoubleValue parseFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, qVar);
    }

    private DoubleValue(GeneratedMessageV3.b<?> bVar) {
        super(bVar);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static DoubleValue parseDelimitedFrom(InputStream inputStream, q qVar) throws IOException {
        return (DoubleValue) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
    }

    public static DoubleValue parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
    public DoubleValue getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
    public b toBuilder() {
        return this == DEFAULT_INSTANCE ? new b((a) null) : new b((a) null).k(this);
    }

    public static DoubleValue parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, qVar);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
    public b newBuilderForType() {
        return newBuilder();
    }

    private DoubleValue() {
        this.memoizedIsInitialized = (byte) -1;
        this.value_ = 0.0d;
    }

    public static DoubleValue parseFrom(InputStream inputStream) throws IOException {
        return (DoubleValue) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static DoubleValue parseFrom(InputStream inputStream, q qVar) throws IOException {
        return (DoubleValue) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
    }

    private DoubleValue(i iVar, q qVar) throws InvalidProtocolBufferException {
        this();
        boolean z10 = false;
        while (!z10) {
            try {
                try {
                    try {
                        int F = iVar.F();
                        z10 = true;
                        if (F != 0) {
                            if (F == 9) {
                                this.value_ = iVar.n();
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

    public static DoubleValue parseFrom(i iVar) throws IOException {
        return (DoubleValue) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
    }

    public static DoubleValue parseFrom(i iVar, q qVar) throws IOException {
        return (DoubleValue) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
    }
}
