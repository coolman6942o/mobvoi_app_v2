package com.google.protobuf;

import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.a;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes.dex */
public final class Mixin extends GeneratedMessageV3 implements i0 {
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int ROOT_FIELD_NUMBER = 2;
    private static final long serialVersionUID = 0;
    private byte memoizedIsInitialized;
    private volatile Object name_;
    private volatile Object root_;
    private static final Mixin DEFAULT_INSTANCE = new Mixin();
    private static final l0<Mixin> PARSER = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a extends c<Mixin> {
        a() {
        }

        /* renamed from: a */
        public Mixin parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
            return new Mixin(iVar, qVar, null);
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends GeneratedMessageV3.b<b> implements i0 {

        /* renamed from: a  reason: collision with root package name */
        private Object f13103a;

        /* renamed from: b  reason: collision with root package name */
        private Object f13104b;

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
        public Mixin build() {
            Mixin c10 = buildPartial();
            if (c10.isInitialized()) {
                return c10;
            }
            throw a.AbstractC0170a.newUninitializedMessageException((d0) c10);
        }

        /* renamed from: c */
        public Mixin buildPartial() {
            Mixin mixin = new Mixin(this, (a) null);
            mixin.name_ = this.f13103a;
            mixin.root_ = this.f13104b;
            onBuilt();
            return mixin;
        }

        /* renamed from: d */
        public b clear() {
            super.clear();
            this.f13103a = "";
            this.f13104b = "";
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
            return g.f13246e;
        }

        /* renamed from: i */
        public Mixin getDefaultInstanceForType() {
            return Mixin.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.b
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return g.f13247f.e(Mixin.class, b.class);
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
            Mixin mixin = null;
            try {
                try {
                    Mixin mixin2 = (Mixin) Mixin.PARSER.parsePartialFrom(iVar, qVar);
                    if (mixin2 != null) {
                        l(mixin2);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e10) {
                    mixin = (Mixin) e10.getUnfinishedMessage();
                    try {
                        throw e10.unwrapIOException();
                    } catch (Throwable th3) {
                        th2 = th3;
                        if (mixin != null) {
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th4) {
                th2 = th4;
                if (mixin != null) {
                    l(mixin);
                }
                throw th2;
            }
        }

        /* renamed from: k */
        public b mergeFrom(d0 d0Var) {
            if (d0Var instanceof Mixin) {
                return l((Mixin) d0Var);
            }
            super.mergeFrom(d0Var);
            return this;
        }

        public b l(Mixin mixin) {
            if (mixin == Mixin.getDefaultInstance()) {
                return this;
            }
            if (!mixin.getName().isEmpty()) {
                this.f13103a = mixin.name_;
                onChanged();
            }
            if (!mixin.getRoot().isEmpty()) {
                this.f13104b = mixin.root_;
                onChanged();
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

        /* synthetic */ b(a aVar) {
            this();
        }

        private b() {
            this.f13103a = "";
            this.f13104b = "";
            maybeForceBuilderInitialization();
        }

        private b(GeneratedMessageV3.c cVar) {
            super(cVar);
            this.f13103a = "";
            this.f13104b = "";
            maybeForceBuilderInitialization();
        }
    }

    /* synthetic */ Mixin(i iVar, q qVar, a aVar) throws InvalidProtocolBufferException {
        this(iVar, qVar);
    }

    public static Mixin getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.b getDescriptor() {
        return g.f13246e;
    }

    public static b newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Mixin parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Mixin) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Mixin parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static l0<Mixin> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.a
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Mixin)) {
            return super.equals(obj);
        }
        Mixin mixin = (Mixin) obj;
        return (getName().equals(mixin.getName())) && getRoot().equals(mixin.getRoot());
    }

    public String getName() {
        Object obj = this.name_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.name_ = stringUtf8;
        return stringUtf8;
    }

    public ByteString getNameBytes() {
        Object obj = this.name_;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.name_ = copyFromUtf8;
        return copyFromUtf8;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
    public l0<Mixin> getParserForType() {
        return PARSER;
    }

    public String getRoot() {
        Object obj = this.root_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.root_ = stringUtf8;
        return stringUtf8;
    }

    public ByteString getRootBytes() {
        Object obj = this.root_;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.root_ = copyFromUtf8;
        return copyFromUtf8;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
    public int getSerializedSize() {
        int i10 = this.memoizedSize;
        if (i10 != -1) {
            return i10;
        }
        int i11 = 0;
        if (!getNameBytes().isEmpty()) {
            i11 = 0 + GeneratedMessageV3.computeStringSize(1, this.name_);
        }
        if (!getRootBytes().isEmpty()) {
            i11 += GeneratedMessageV3.computeStringSize(2, this.root_);
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
        int hashCode = ((((((((((779 + getDescriptorForType().hashCode()) * 37) + 1) * 53) + getName().hashCode()) * 37) + 2) * 53) + getRoot().hashCode()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode;
        return hashCode;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
        return g.f13247f.e(Mixin.class, b.class);
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
        if (!getNameBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 1, this.name_);
        }
        if (!getRootBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 2, this.root_);
        }
    }

    /* synthetic */ Mixin(GeneratedMessageV3.b bVar, a aVar) {
        this(bVar);
    }

    public static b newBuilder(Mixin mixin) {
        return DEFAULT_INSTANCE.toBuilder().l(mixin);
    }

    public static Mixin parseFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, qVar);
    }

    private Mixin(GeneratedMessageV3.b<?> bVar) {
        super(bVar);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static Mixin parseDelimitedFrom(InputStream inputStream, q qVar) throws IOException {
        return (Mixin) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
    }

    public static Mixin parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
    public Mixin getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
    public b toBuilder() {
        return this == DEFAULT_INSTANCE ? new b((a) null) : new b((a) null).l(this);
    }

    public static Mixin parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, qVar);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
    public b newBuilderForType() {
        return newBuilder();
    }

    private Mixin() {
        this.memoizedIsInitialized = (byte) -1;
        this.name_ = "";
        this.root_ = "";
    }

    public static Mixin parseFrom(InputStream inputStream) throws IOException {
        return (Mixin) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static Mixin parseFrom(InputStream inputStream, q qVar) throws IOException {
        return (Mixin) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
    }

    private Mixin(i iVar, q qVar) throws InvalidProtocolBufferException {
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
                                this.name_ = iVar.E();
                            } else if (F == 18) {
                                this.root_ = iVar.E();
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

    public static Mixin parseFrom(i iVar) throws IOException {
        return (Mixin) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
    }

    public static Mixin parseFrom(i iVar, q qVar) throws IOException {
        return (Mixin) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
    }
}
