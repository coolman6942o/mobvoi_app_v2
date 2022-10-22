package com.google.protobuf;

import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.a;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes.dex */
public final class UInt32Value extends GeneratedMessageV3 implements g0 {
    private static final UInt32Value DEFAULT_INSTANCE = new UInt32Value();
    private static final l0<UInt32Value> PARSER = new a();
    public static final int VALUE_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private byte memoizedIsInitialized;
    private int value_;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a extends c<UInt32Value> {
        a() {
        }

        /* renamed from: a */
        public UInt32Value parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
            return new UInt32Value(iVar, qVar, null);
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends GeneratedMessageV3.b<b> implements g0 {

        /* renamed from: a  reason: collision with root package name */
        private int f13134a;

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
        public UInt32Value build() {
            UInt32Value c10 = buildPartial();
            if (c10.isInitialized()) {
                return c10;
            }
            throw a.AbstractC0170a.newUninitializedMessageException((d0) c10);
        }

        /* renamed from: c */
        public UInt32Value buildPartial() {
            UInt32Value uInt32Value = new UInt32Value(this, (a) null);
            uInt32Value.value_ = this.f13134a;
            onBuilt();
            return uInt32Value;
        }

        /* renamed from: d */
        public b clear() {
            super.clear();
            this.f13134a = 0;
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
            return f1.f13233k;
        }

        /* renamed from: i */
        public UInt32Value getDefaultInstanceForType() {
            return UInt32Value.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.b
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return f1.f13234l.e(UInt32Value.class, b.class);
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
            UInt32Value uInt32Value = null;
            try {
                try {
                    UInt32Value uInt32Value2 = (UInt32Value) UInt32Value.PARSER.parsePartialFrom(iVar, qVar);
                    if (uInt32Value2 != null) {
                        l(uInt32Value2);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e10) {
                    uInt32Value = (UInt32Value) e10.getUnfinishedMessage();
                    try {
                        throw e10.unwrapIOException();
                    } catch (Throwable th3) {
                        th2 = th3;
                        if (uInt32Value != null) {
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th4) {
                th2 = th4;
                if (uInt32Value != null) {
                    l(uInt32Value);
                }
                throw th2;
            }
        }

        /* renamed from: k */
        public b mergeFrom(d0 d0Var) {
            if (d0Var instanceof UInt32Value) {
                return l((UInt32Value) d0Var);
            }
            super.mergeFrom(d0Var);
            return this;
        }

        public b l(UInt32Value uInt32Value) {
            if (uInt32Value == UInt32Value.getDefaultInstance()) {
                return this;
            }
            if (uInt32Value.getValue() != 0) {
                q(uInt32Value.getValue());
            }
            onChanged();
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

        public b q(int i10) {
            this.f13134a = i10;
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

    /* synthetic */ UInt32Value(i iVar, q qVar, a aVar) throws InvalidProtocolBufferException {
        this(iVar, qVar);
    }

    public static UInt32Value getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.b getDescriptor() {
        return f1.f13233k;
    }

    public static b newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static UInt32Value parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (UInt32Value) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static UInt32Value parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static l0<UInt32Value> parser() {
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
        if (!(obj instanceof UInt32Value)) {
            return super.equals(obj);
        }
        return getValue() == ((UInt32Value) obj).getValue();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
    public l0<UInt32Value> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
    public int getSerializedSize() {
        int i10 = this.memoizedSize;
        if (i10 != -1) {
            return i10;
        }
        int i11 = 0;
        int i12 = this.value_;
        if (i12 != 0) {
            i11 = 0 + CodedOutputStream.Q(1, i12);
        }
        this.memoizedSize = i11;
        return i11;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.g0
    public final a1 getUnknownFields() {
        return a1.c();
    }

    public int getValue() {
        return this.value_;
    }

    @Override // com.google.protobuf.a
    public int hashCode() {
        int i10 = this.memoizedHashCode;
        if (i10 != 0) {
            return i10;
        }
        int hashCode = ((((((779 + getDescriptorForType().hashCode()) * 37) + 1) * 53) + getValue()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode;
        return hashCode;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
        return f1.f13234l.e(UInt32Value.class, b.class);
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
        int i10 = this.value_;
        if (i10 != 0) {
            codedOutputStream.M0(1, i10);
        }
    }

    /* synthetic */ UInt32Value(GeneratedMessageV3.b bVar, a aVar) {
        this(bVar);
    }

    public static b newBuilder(UInt32Value uInt32Value) {
        return DEFAULT_INSTANCE.toBuilder().l(uInt32Value);
    }

    public static UInt32Value parseFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, qVar);
    }

    private UInt32Value(GeneratedMessageV3.b<?> bVar) {
        super(bVar);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static UInt32Value parseDelimitedFrom(InputStream inputStream, q qVar) throws IOException {
        return (UInt32Value) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
    }

    public static UInt32Value parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
    public UInt32Value getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
    public b toBuilder() {
        return this == DEFAULT_INSTANCE ? new b((a) null) : new b((a) null).l(this);
    }

    public static UInt32Value parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, qVar);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
    public b newBuilderForType() {
        return newBuilder();
    }

    private UInt32Value() {
        this.memoizedIsInitialized = (byte) -1;
        this.value_ = 0;
    }

    public static UInt32Value parseFrom(InputStream inputStream) throws IOException {
        return (UInt32Value) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static UInt32Value parseFrom(InputStream inputStream, q qVar) throws IOException {
        return (UInt32Value) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
    }

    private UInt32Value(i iVar, q qVar) throws InvalidProtocolBufferException {
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
                                this.value_ = iVar.G();
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

    public static UInt32Value parseFrom(i iVar) throws IOException {
        return (UInt32Value) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
    }

    public static UInt32Value parseFrom(i iVar, q qVar) throws IOException {
        return (UInt32Value) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
    }
}
