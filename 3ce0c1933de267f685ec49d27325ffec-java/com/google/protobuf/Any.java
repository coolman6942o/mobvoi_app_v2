package com.google.protobuf;

import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.a;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
/* loaded from: classes.dex */
public final class Any extends GeneratedMessageV3 implements e {
    private static final Any DEFAULT_INSTANCE = new Any();
    private static final l0<Any> PARSER = new a();
    public static final int TYPE_URL_FIELD_NUMBER = 1;
    public static final int VALUE_FIELD_NUMBER = 2;
    private static final long serialVersionUID = 0;
    private volatile d0 cachedUnpackValue;
    private byte memoizedIsInitialized;
    private volatile Object typeUrl_;
    private ByteString value_;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a extends c<Any> {
        a() {
        }

        /* renamed from: a */
        public Any parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
            return new Any(iVar, qVar, null);
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends GeneratedMessageV3.b<b> implements e {

        /* renamed from: a  reason: collision with root package name */
        private Object f12684a;

        /* renamed from: b  reason: collision with root package name */
        private ByteString f12685b;

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
        public Any build() {
            Any c10 = buildPartial();
            if (c10.isInitialized()) {
                return c10;
            }
            throw a.AbstractC0170a.newUninitializedMessageException((d0) c10);
        }

        /* renamed from: c */
        public Any buildPartial() {
            Any any = new Any(this, (a) null);
            any.typeUrl_ = this.f12684a;
            any.value_ = this.f12685b;
            onBuilt();
            return any;
        }

        /* renamed from: d */
        public b clear() {
            super.clear();
            this.f12684a = "";
            this.f12685b = ByteString.EMPTY;
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
            return f.f13220a;
        }

        /* renamed from: i */
        public Any getDefaultInstanceForType() {
            return Any.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.b
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return f.f13221b.e(Any.class, b.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.f0
        public final boolean isInitialized() {
            return true;
        }

        public b j(Any any) {
            if (any == Any.getDefaultInstance()) {
                return this;
            }
            if (!any.getTypeUrl().isEmpty()) {
                this.f12684a = any.typeUrl_;
                onChanged();
            }
            if (any.getValue() != ByteString.EMPTY) {
                r(any.getValue());
            }
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0023  */
        /* renamed from: k */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b mergeFrom(i iVar, q qVar) throws IOException {
            Throwable th2;
            Any any = null;
            try {
                try {
                    Any any2 = (Any) Any.PARSER.parsePartialFrom(iVar, qVar);
                    if (any2 != null) {
                        j(any2);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e10) {
                    any = (Any) e10.getUnfinishedMessage();
                    try {
                        throw e10.unwrapIOException();
                    } catch (Throwable th3) {
                        th2 = th3;
                        if (any != null) {
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th4) {
                th2 = th4;
                if (any != null) {
                    j(any);
                }
                throw th2;
            }
        }

        /* renamed from: l */
        public b mergeFrom(d0 d0Var) {
            if (d0Var instanceof Any) {
                return j((Any) d0Var);
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

        public b p(String str) {
            Objects.requireNonNull(str);
            this.f12684a = str;
            onChanged();
            return this;
        }

        /* renamed from: q */
        public final b setUnknownFields(a1 a1Var) {
            return this;
        }

        public b r(ByteString byteString) {
            Objects.requireNonNull(byteString);
            this.f12685b = byteString;
            onChanged();
            return this;
        }

        /* synthetic */ b(GeneratedMessageV3.c cVar, a aVar) {
            this(cVar);
        }

        private b() {
            this.f12684a = "";
            this.f12685b = ByteString.EMPTY;
            maybeForceBuilderInitialization();
        }

        private b(GeneratedMessageV3.c cVar) {
            super(cVar);
            this.f12684a = "";
            this.f12685b = ByteString.EMPTY;
            maybeForceBuilderInitialization();
        }
    }

    /* synthetic */ Any(i iVar, q qVar, a aVar) throws InvalidProtocolBufferException {
        this(iVar, qVar);
    }

    private static String g(String str) {
        int lastIndexOf = str.lastIndexOf(47);
        return lastIndexOf == -1 ? "" : str.substring(lastIndexOf + 1);
    }

    public static Any getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.b getDescriptor() {
        return f.f13220a;
    }

    private static String h(String str, Descriptors.b bVar) {
        if (str.endsWith("/")) {
            return str + bVar.b();
        }
        return str + "/" + bVar.b();
    }

    public static b newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static <T extends d0> Any pack(T t10) {
        return newBuilder().p(h("type.googleapis.com", t10.getDescriptorForType())).r(t10.toByteString()).build();
    }

    public static Any parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Any) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Any parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static l0<Any> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.a
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Any)) {
            return super.equals(obj);
        }
        Any any = (Any) obj;
        return (getTypeUrl().equals(any.getTypeUrl())) && getValue().equals(any.getValue());
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
    public l0<Any> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
    public int getSerializedSize() {
        int i10 = this.memoizedSize;
        if (i10 != -1) {
            return i10;
        }
        int i11 = 0;
        if (!getTypeUrlBytes().isEmpty()) {
            i11 = 0 + GeneratedMessageV3.computeStringSize(1, this.typeUrl_);
        }
        if (!this.value_.isEmpty()) {
            i11 += CodedOutputStream.h(2, this.value_);
        }
        this.memoizedSize = i11;
        return i11;
    }

    public String getTypeUrl() {
        Object obj = this.typeUrl_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.typeUrl_ = stringUtf8;
        return stringUtf8;
    }

    public ByteString getTypeUrlBytes() {
        Object obj = this.typeUrl_;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.typeUrl_ = copyFromUtf8;
        return copyFromUtf8;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.g0
    public final a1 getUnknownFields() {
        return a1.c();
    }

    public ByteString getValue() {
        return this.value_;
    }

    @Override // com.google.protobuf.a
    public int hashCode() {
        int i10 = this.memoizedHashCode;
        if (i10 != 0) {
            return i10;
        }
        int hashCode = ((((((((((779 + getDescriptorForType().hashCode()) * 37) + 1) * 53) + getTypeUrl().hashCode()) * 37) + 2) * 53) + getValue().hashCode()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode;
        return hashCode;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: i */
    public b newBuilderForType(GeneratedMessageV3.c cVar) {
        return new b(cVar, null);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
        return f.f13221b.e(Any.class, b.class);
    }

    public <T extends d0> boolean is(Class<T> cls) {
        return g(getTypeUrl()).equals(((d0) u.b(cls)).getDescriptorForType().b());
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

    public <T extends d0> T unpack(Class<T> cls) throws InvalidProtocolBufferException {
        if (!is(cls)) {
            throw new InvalidProtocolBufferException("Type of the Any message does not match the given class.");
        } else if (this.cachedUnpackValue != null) {
            return (T) this.cachedUnpackValue;
        } else {
            T t10 = (T) ((d0) u.b(cls)).getParserForType().parseFrom(getValue());
            this.cachedUnpackValue = t10;
            return t10;
        }
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (!getTypeUrlBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 1, this.typeUrl_);
        }
        if (!this.value_.isEmpty()) {
            codedOutputStream.i0(2, this.value_);
        }
    }

    /* synthetic */ Any(GeneratedMessageV3.b bVar, a aVar) {
        this(bVar);
    }

    public static b newBuilder(Any any) {
        return DEFAULT_INSTANCE.toBuilder().j(any);
    }

    public static Any parseFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, qVar);
    }

    private Any(GeneratedMessageV3.b<?> bVar) {
        super(bVar);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static Any parseDelimitedFrom(InputStream inputStream, q qVar) throws IOException {
        return (Any) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
    }

    public static Any parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
    public Any getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
    public b toBuilder() {
        return this == DEFAULT_INSTANCE ? new b((a) null) : new b((a) null).j(this);
    }

    public static Any parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, qVar);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
    public b newBuilderForType() {
        return newBuilder();
    }

    private Any() {
        this.memoizedIsInitialized = (byte) -1;
        this.typeUrl_ = "";
        this.value_ = ByteString.EMPTY;
    }

    public static Any parseFrom(InputStream inputStream) throws IOException {
        return (Any) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static <T extends d0> Any pack(T t10, String str) {
        return newBuilder().p(h(str, t10.getDescriptorForType())).r(t10.toByteString()).build();
    }

    public static Any parseFrom(InputStream inputStream, q qVar) throws IOException {
        return (Any) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
    }

    private Any(i iVar, q qVar) throws InvalidProtocolBufferException {
        this();
        boolean z10 = false;
        while (!z10) {
            try {
                try {
                    try {
                        int F = iVar.F();
                        z10 = true;
                        if (F != 0) {
                            if (F == 10) {
                                this.typeUrl_ = iVar.E();
                            } else if (F == 18) {
                                this.value_ = iVar.m();
                            } else if (!iVar.I(F)) {
                            }
                        }
                    } catch (InvalidProtocolBufferException e10) {
                        throw e10.setUnfinishedMessage(this);
                    }
                } catch (IOException e11) {
                    throw new InvalidProtocolBufferException(e11).setUnfinishedMessage(this);
                }
            } finally {
                makeExtensionsImmutable();
            }
        }
    }

    public static Any parseFrom(i iVar) throws IOException {
        return (Any) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
    }

    public static Any parseFrom(i iVar, q qVar) throws IOException {
        return (Any) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
    }
}
