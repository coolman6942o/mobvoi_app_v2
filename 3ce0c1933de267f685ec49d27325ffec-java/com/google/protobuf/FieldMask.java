package com.google.protobuf;

import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.a;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes.dex */
public final class FieldMask extends GeneratedMessageV3 implements g0 {
    private static final FieldMask DEFAULT_INSTANCE = new FieldMask();
    private static final l0<FieldMask> PARSER = new a();
    public static final int PATHS_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private byte memoizedIsInitialized;
    private y paths_;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a extends c<FieldMask> {
        a() {
        }

        /* renamed from: a */
        public FieldMask parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
            return new FieldMask(iVar, qVar, null);
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends GeneratedMessageV3.b<b> implements g0 {

        /* renamed from: a  reason: collision with root package name */
        private int f13008a;

        /* renamed from: b  reason: collision with root package name */
        private y f13009b;

        /* synthetic */ b(a aVar) {
            this();
        }

        private void i() {
            if ((this.f13008a & 1) != 1) {
                this.f13009b = new x(this.f13009b);
                this.f13008a |= 1;
            }
        }

        private void maybeForceBuilderInitialization() {
            boolean z10 = GeneratedMessageV3.alwaysUseFieldBuilders;
        }

        /* renamed from: a */
        public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (b) super.addRepeatedField(fieldDescriptor, obj);
        }

        /* renamed from: b */
        public FieldMask build() {
            FieldMask c10 = buildPartial();
            if (c10.isInitialized()) {
                return c10;
            }
            throw a.AbstractC0170a.newUninitializedMessageException((d0) c10);
        }

        /* renamed from: c */
        public FieldMask buildPartial() {
            FieldMask fieldMask = new FieldMask(this, (a) null);
            if ((this.f13008a & 1) == 1) {
                this.f13009b = this.f13009b.u0();
                this.f13008a &= -2;
            }
            fieldMask.paths_ = this.f13009b;
            onBuilt();
            return fieldMask;
        }

        /* renamed from: d */
        public b clear() {
            super.clear();
            this.f13009b = x.f13385d;
            this.f13008a &= -2;
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
            return r.f13337a;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.b
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return r.f13338b.e(FieldMask.class, b.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.f0
        public final boolean isInitialized() {
            return true;
        }

        /* renamed from: j */
        public FieldMask getDefaultInstanceForType() {
            return FieldMask.getDefaultInstance();
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0023  */
        /* renamed from: k */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b mergeFrom(i iVar, q qVar) throws IOException {
            Throwable th2;
            FieldMask fieldMask = null;
            try {
                try {
                    FieldMask fieldMask2 = (FieldMask) FieldMask.PARSER.parsePartialFrom(iVar, qVar);
                    if (fieldMask2 != null) {
                        l(fieldMask2);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e10) {
                    fieldMask = (FieldMask) e10.getUnfinishedMessage();
                    try {
                        throw e10.unwrapIOException();
                    } catch (Throwable th3) {
                        th2 = th3;
                        if (fieldMask != null) {
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th4) {
                th2 = th4;
                if (fieldMask != null) {
                    l(fieldMask);
                }
                throw th2;
            }
        }

        public b l(FieldMask fieldMask) {
            if (fieldMask == FieldMask.getDefaultInstance()) {
                return this;
            }
            if (!fieldMask.paths_.isEmpty()) {
                if (this.f13009b.isEmpty()) {
                    this.f13009b = fieldMask.paths_;
                    this.f13008a &= -2;
                } else {
                    i();
                    this.f13009b.addAll(fieldMask.paths_);
                }
                onChanged();
            }
            onChanged();
            return this;
        }

        /* renamed from: m */
        public b mergeFrom(d0 d0Var) {
            if (d0Var instanceof FieldMask) {
                return l((FieldMask) d0Var);
            }
            super.mergeFrom(d0Var);
            return this;
        }

        /* renamed from: n */
        public final b mergeUnknownFields(a1 a1Var) {
            return this;
        }

        /* renamed from: o */
        public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (b) super.setField(fieldDescriptor, obj);
        }

        /* renamed from: p */
        public b setRepeatedField2(Descriptors.FieldDescriptor fieldDescriptor, int i10, Object obj) {
            return (b) super.setRepeatedField(fieldDescriptor, i10, obj);
        }

        /* renamed from: q */
        public final b setUnknownFields(a1 a1Var) {
            return this;
        }

        /* synthetic */ b(GeneratedMessageV3.c cVar, a aVar) {
            this(cVar);
        }

        private b() {
            this.f13009b = x.f13385d;
            maybeForceBuilderInitialization();
        }

        private b(GeneratedMessageV3.c cVar) {
            super(cVar);
            this.f13009b = x.f13385d;
            maybeForceBuilderInitialization();
        }
    }

    /* synthetic */ FieldMask(i iVar, q qVar, a aVar) throws InvalidProtocolBufferException {
        this(iVar, qVar);
    }

    public static FieldMask getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.b getDescriptor() {
        return r.f13337a;
    }

    public static b newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static FieldMask parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (FieldMask) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static FieldMask parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static l0<FieldMask> parser() {
        return PARSER;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: d */
    public b newBuilderForType(GeneratedMessageV3.c cVar) {
        return new b(cVar, null);
    }

    @Override // com.google.protobuf.a
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FieldMask)) {
            return super.equals(obj);
        }
        return getPathsList().equals(((FieldMask) obj).getPathsList());
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
    public l0<FieldMask> getParserForType() {
        return PARSER;
    }

    public String getPaths(int i10) {
        return this.paths_.get(i10);
    }

    public ByteString getPathsBytes(int i10) {
        return this.paths_.o0(i10);
    }

    public int getPathsCount() {
        return this.paths_.size();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
    public int getSerializedSize() {
        int i10 = this.memoizedSize;
        if (i10 != -1) {
            return i10;
        }
        int i11 = 0;
        for (int i12 = 0; i12 < this.paths_.size(); i12++) {
            i11 += GeneratedMessageV3.computeStringSizeNoTag(this.paths_.z0(i12));
        }
        int size = 0 + i11 + (getPathsList().size() * 1);
        this.memoizedSize = size;
        return size;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.g0
    public final a1 getUnknownFields() {
        return a1.c();
    }

    @Override // com.google.protobuf.a
    public int hashCode() {
        int i10 = this.memoizedHashCode;
        if (i10 != 0) {
            return i10;
        }
        int hashCode = 779 + getDescriptorForType().hashCode();
        if (getPathsCount() > 0) {
            hashCode = (((hashCode * 37) + 1) * 53) + getPathsList().hashCode();
        }
        int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode2;
        return hashCode2;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
        return r.f13338b.e(FieldMask.class, b.class);
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
        for (int i10 = 0; i10 < this.paths_.size(); i10++) {
            GeneratedMessageV3.writeString(codedOutputStream, 1, this.paths_.z0(i10));
        }
    }

    /* synthetic */ FieldMask(GeneratedMessageV3.b bVar, a aVar) {
        this(bVar);
    }

    public static b newBuilder(FieldMask fieldMask) {
        return DEFAULT_INSTANCE.toBuilder().l(fieldMask);
    }

    public static FieldMask parseFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, qVar);
    }

    public n0 getPathsList() {
        return this.paths_;
    }

    private FieldMask(GeneratedMessageV3.b<?> bVar) {
        super(bVar);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static FieldMask parseDelimitedFrom(InputStream inputStream, q qVar) throws IOException {
        return (FieldMask) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
    }

    public static FieldMask parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
    public FieldMask getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
    public b toBuilder() {
        return this == DEFAULT_INSTANCE ? new b((a) null) : new b((a) null).l(this);
    }

    public static FieldMask parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, qVar);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
    public b newBuilderForType() {
        return newBuilder();
    }

    private FieldMask() {
        this.memoizedIsInitialized = (byte) -1;
        this.paths_ = x.f13385d;
    }

    public static FieldMask parseFrom(InputStream inputStream) throws IOException {
        return (FieldMask) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static FieldMask parseFrom(InputStream inputStream, q qVar) throws IOException {
        return (FieldMask) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
    }

    private FieldMask(i iVar, q qVar) throws InvalidProtocolBufferException {
        this();
        boolean z10 = false;
        boolean z11 = false;
        while (true) {
            if (z10) {
                break;
            }
            try {
                try {
                    try {
                        int F = iVar.F();
                        if (F != 0) {
                            if (F == 10) {
                                String E = iVar.E();
                                if (!z11 || !true) {
                                    this.paths_ = new x();
                                    z11 |= true;
                                }
                                this.paths_.add(E);
                            } else if (!iVar.I(F)) {
                            }
                        }
                        z10 = true;
                    } catch (IOException e10) {
                        throw new InvalidProtocolBufferException(e10).setUnfinishedMessage(this);
                    }
                } catch (InvalidProtocolBufferException e11) {
                    throw e11.setUnfinishedMessage(this);
                }
            } finally {
                if (z11 && true) {
                    this.paths_ = this.paths_.u0();
                }
                makeExtensionsImmutable();
            }
        }
    }

    public static FieldMask parseFrom(i iVar) throws IOException {
        return (FieldMask) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
    }

    public static FieldMask parseFrom(i iVar, q qVar) throws IOException {
        return (FieldMask) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
    }
}
