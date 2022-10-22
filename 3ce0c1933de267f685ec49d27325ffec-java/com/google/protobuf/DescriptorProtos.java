package com.google.protobuf;

import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.a;
import com.google.protobuf.a1;
import com.google.protobuf.u;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
/* loaded from: classes.dex */
public final class DescriptorProtos {
    private static final Descriptors.b A;
    private static final GeneratedMessageV3.e B;
    private static final Descriptors.b C;
    private static final GeneratedMessageV3.e D;
    private static final Descriptors.b E;
    private static final GeneratedMessageV3.e F;
    private static final Descriptors.b G;
    private static final GeneratedMessageV3.e H;
    private static final Descriptors.b I;
    private static final GeneratedMessageV3.e J;
    private static final Descriptors.b K;
    private static final GeneratedMessageV3.e L;
    private static final Descriptors.b M;
    private static final GeneratedMessageV3.e N;
    private static final Descriptors.b O;
    private static final GeneratedMessageV3.e P;
    private static final Descriptors.b Q;
    private static final GeneratedMessageV3.e R;
    private static final Descriptors.b S;
    private static final GeneratedMessageV3.e T;
    private static final Descriptors.b U;
    private static final GeneratedMessageV3.e V;
    private static final Descriptors.b W;
    private static final GeneratedMessageV3.e X;
    private static Descriptors.FileDescriptor Y;

    /* renamed from: a  reason: collision with root package name */
    private static final Descriptors.b f12722a;

    /* renamed from: b  reason: collision with root package name */
    private static final GeneratedMessageV3.e f12723b;

    /* renamed from: c  reason: collision with root package name */
    private static final Descriptors.b f12724c;

    /* renamed from: d  reason: collision with root package name */
    private static final GeneratedMessageV3.e f12725d;

    /* renamed from: e  reason: collision with root package name */
    private static final Descriptors.b f12726e;

    /* renamed from: f  reason: collision with root package name */
    private static final GeneratedMessageV3.e f12727f;

    /* renamed from: g  reason: collision with root package name */
    private static final Descriptors.b f12728g;

    /* renamed from: h  reason: collision with root package name */
    private static final GeneratedMessageV3.e f12729h;

    /* renamed from: i  reason: collision with root package name */
    private static final Descriptors.b f12730i;

    /* renamed from: j  reason: collision with root package name */
    private static final GeneratedMessageV3.e f12731j;

    /* renamed from: k  reason: collision with root package name */
    private static final Descriptors.b f12732k;

    /* renamed from: l  reason: collision with root package name */
    private static final GeneratedMessageV3.e f12733l;

    /* renamed from: m  reason: collision with root package name */
    private static final Descriptors.b f12734m;

    /* renamed from: n  reason: collision with root package name */
    private static final GeneratedMessageV3.e f12735n;

    /* renamed from: o  reason: collision with root package name */
    private static final Descriptors.b f12736o;

    /* renamed from: p  reason: collision with root package name */
    private static final GeneratedMessageV3.e f12737p;

    /* renamed from: q  reason: collision with root package name */
    private static final Descriptors.b f12738q;

    /* renamed from: r  reason: collision with root package name */
    private static final GeneratedMessageV3.e f12739r;

    /* renamed from: s  reason: collision with root package name */
    private static final Descriptors.b f12740s;

    /* renamed from: t  reason: collision with root package name */
    private static final GeneratedMessageV3.e f12741t;

    /* renamed from: u  reason: collision with root package name */
    private static final Descriptors.b f12742u;

    /* renamed from: v  reason: collision with root package name */
    private static final GeneratedMessageV3.e f12743v;

    /* renamed from: w  reason: collision with root package name */
    private static final Descriptors.b f12744w;

    /* renamed from: x  reason: collision with root package name */
    private static final GeneratedMessageV3.e f12745x;

    /* renamed from: y  reason: collision with root package name */
    private static final Descriptors.b f12746y;

    /* renamed from: z  reason: collision with root package name */
    private static final GeneratedMessageV3.e f12747z;

    /* loaded from: classes.dex */
    public static final class DescriptorProto extends GeneratedMessageV3 implements b {
        public static final int ENUM_TYPE_FIELD_NUMBER = 4;
        public static final int EXTENSION_FIELD_NUMBER = 6;
        public static final int EXTENSION_RANGE_FIELD_NUMBER = 5;
        public static final int FIELD_FIELD_NUMBER = 2;
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int NESTED_TYPE_FIELD_NUMBER = 3;
        public static final int ONEOF_DECL_FIELD_NUMBER = 8;
        public static final int OPTIONS_FIELD_NUMBER = 7;
        public static final int RESERVED_NAME_FIELD_NUMBER = 10;
        public static final int RESERVED_RANGE_FIELD_NUMBER = 9;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private List<EnumDescriptorProto> enumType_;
        private List<ExtensionRange> extensionRange_;
        private List<FieldDescriptorProto> extension_;
        private List<FieldDescriptorProto> field_;
        private byte memoizedIsInitialized;
        private volatile Object name_;
        private List<DescriptorProto> nestedType_;
        private List<OneofDescriptorProto> oneofDecl_;
        private MessageOptions options_;
        private y reservedName_;
        private List<ReservedRange> reservedRange_;
        private static final DescriptorProto DEFAULT_INSTANCE = new DescriptorProto();
        @Deprecated
        public static final l0<DescriptorProto> PARSER = new a();

        /* loaded from: classes.dex */
        public static final class ExtensionRange extends GeneratedMessageV3 implements c {
            public static final int END_FIELD_NUMBER = 2;
            public static final int START_FIELD_NUMBER = 1;
            private static final long serialVersionUID = 0;
            private int bitField0_;
            private int end_;
            private byte memoizedIsInitialized;
            private int start_;
            private static final ExtensionRange DEFAULT_INSTANCE = new ExtensionRange();
            @Deprecated
            public static final l0<ExtensionRange> PARSER = new a();

            /* loaded from: classes.dex */
            static class a extends com.google.protobuf.c<ExtensionRange> {
                a() {
                }

                /* renamed from: a */
                public ExtensionRange parsePartialFrom(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
                    return new ExtensionRange(iVar, qVar, null);
                }
            }

            /* loaded from: classes.dex */
            public static final class b extends GeneratedMessageV3.b<b> implements c {

                /* renamed from: a  reason: collision with root package name */
                private int f12748a;

                /* renamed from: b  reason: collision with root package name */
                private int f12749b;

                /* renamed from: c  reason: collision with root package name */
                private int f12750c;

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
                public ExtensionRange build() {
                    ExtensionRange c10 = buildPartial();
                    if (c10.isInitialized()) {
                        return c10;
                    }
                    throw a.AbstractC0170a.newUninitializedMessageException((d0) c10);
                }

                /* renamed from: c */
                public ExtensionRange buildPartial() {
                    ExtensionRange extensionRange = new ExtensionRange(this, (a) null);
                    int i10 = this.f12748a;
                    int i11 = 1;
                    if ((i10 & 1) != 1) {
                        i11 = 0;
                    }
                    extensionRange.start_ = this.f12749b;
                    if ((i10 & 2) == 2) {
                        i11 |= 2;
                    }
                    extensionRange.end_ = this.f12750c;
                    extensionRange.bitField0_ = i11;
                    onBuilt();
                    return extensionRange;
                }

                /* renamed from: d */
                public b clear() {
                    super.clear();
                    this.f12749b = 0;
                    int i10 = this.f12748a & (-2);
                    this.f12748a = i10;
                    this.f12750c = 0;
                    this.f12748a = i10 & (-3);
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
                    return DescriptorProtos.f12728g;
                }

                /* renamed from: i */
                public ExtensionRange getDefaultInstanceForType() {
                    return ExtensionRange.getDefaultInstance();
                }

                @Override // com.google.protobuf.GeneratedMessageV3.b
                protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                    return DescriptorProtos.f12729h.e(ExtensionRange.class, b.class);
                }

                @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.f0
                public final boolean isInitialized() {
                    return true;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0021  */
                /* renamed from: j */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public b mergeFrom(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws IOException {
                    Throwable th2;
                    ExtensionRange extensionRange = null;
                    try {
                        try {
                            ExtensionRange parsePartialFrom = ExtensionRange.PARSER.parsePartialFrom(iVar, qVar);
                            if (parsePartialFrom != null) {
                                k(parsePartialFrom);
                            }
                            return this;
                        } catch (InvalidProtocolBufferException e10) {
                            extensionRange = (ExtensionRange) e10.getUnfinishedMessage();
                            try {
                                throw e10.unwrapIOException();
                            } catch (Throwable th3) {
                                th2 = th3;
                                if (extensionRange != null) {
                                    k(extensionRange);
                                }
                                throw th2;
                            }
                        }
                    } catch (Throwable th4) {
                        th2 = th4;
                        if (extensionRange != null) {
                        }
                        throw th2;
                    }
                }

                public b k(ExtensionRange extensionRange) {
                    if (extensionRange == ExtensionRange.getDefaultInstance()) {
                        return this;
                    }
                    if (extensionRange.hasStart()) {
                        q(extensionRange.getStart());
                    }
                    if (extensionRange.hasEnd()) {
                        n(extensionRange.getEnd());
                    }
                    mergeUnknownFields(extensionRange.unknownFields);
                    onChanged();
                    return this;
                }

                /* renamed from: l */
                public b mergeFrom(d0 d0Var) {
                    if (d0Var instanceof ExtensionRange) {
                        return k((ExtensionRange) d0Var);
                    }
                    super.mergeFrom(d0Var);
                    return this;
                }

                /* renamed from: m */
                public final b mergeUnknownFields(a1 a1Var) {
                    return (b) super.mergeUnknownFields(a1Var);
                }

                public b n(int i10) {
                    this.f12748a |= 2;
                    this.f12750c = i10;
                    onChanged();
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

                public b q(int i10) {
                    this.f12748a |= 1;
                    this.f12749b = i10;
                    onChanged();
                    return this;
                }

                /* renamed from: r */
                public final b setUnknownFields(a1 a1Var) {
                    return (b) super.setUnknownFields(a1Var);
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

            /* synthetic */ ExtensionRange(com.google.protobuf.i iVar, com.google.protobuf.q qVar, a aVar) throws InvalidProtocolBufferException {
                this(iVar, qVar);
            }

            public static ExtensionRange getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static final Descriptors.b getDescriptor() {
                return DescriptorProtos.f12728g;
            }

            public static b newBuilder() {
                return DEFAULT_INSTANCE.toBuilder();
            }

            public static ExtensionRange parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (ExtensionRange) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
            }

            public static ExtensionRange parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteString);
            }

            public static l0<ExtensionRange> parser() {
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
                if (!(obj instanceof ExtensionRange)) {
                    return super.equals(obj);
                }
                ExtensionRange extensionRange = (ExtensionRange) obj;
                boolean z10 = hasStart() == extensionRange.hasStart();
                if (hasStart()) {
                    z10 = z10 && getStart() == extensionRange.getStart();
                }
                boolean z11 = z10 && hasEnd() == extensionRange.hasEnd();
                if (hasEnd()) {
                    z11 = z11 && getEnd() == extensionRange.getEnd();
                }
                return z11 && this.unknownFields.equals(extensionRange.unknownFields);
            }

            public int getEnd() {
                return this.end_;
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
            public l0<ExtensionRange> getParserForType() {
                return PARSER;
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
            public int getSerializedSize() {
                int i10 = this.memoizedSize;
                if (i10 != -1) {
                    return i10;
                }
                int i11 = 0;
                if ((this.bitField0_ & 1) == 1) {
                    i11 = 0 + CodedOutputStream.v(1, this.start_);
                }
                if ((this.bitField0_ & 2) == 2) {
                    i11 += CodedOutputStream.v(2, this.end_);
                }
                int serializedSize = i11 + this.unknownFields.getSerializedSize();
                this.memoizedSize = serializedSize;
                return serializedSize;
            }

            public int getStart() {
                return this.start_;
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.g0
            public final a1 getUnknownFields() {
                return this.unknownFields;
            }

            public boolean hasEnd() {
                return (this.bitField0_ & 2) == 2;
            }

            public boolean hasStart() {
                return (this.bitField0_ & 1) == 1;
            }

            @Override // com.google.protobuf.a
            public int hashCode() {
                int i10 = this.memoizedHashCode;
                if (i10 != 0) {
                    return i10;
                }
                int hashCode = 779 + getDescriptorForType().hashCode();
                if (hasStart()) {
                    hashCode = (((hashCode * 37) + 1) * 53) + getStart();
                }
                if (hasEnd()) {
                    hashCode = (((hashCode * 37) + 2) * 53) + getEnd();
                }
                int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
                this.memoizedHashCode = hashCode2;
                return hashCode2;
            }

            @Override // com.google.protobuf.GeneratedMessageV3
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return DescriptorProtos.f12729h.e(ExtensionRange.class, b.class);
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
                if ((this.bitField0_ & 1) == 1) {
                    codedOutputStream.w0(1, this.start_);
                }
                if ((this.bitField0_ & 2) == 2) {
                    codedOutputStream.w0(2, this.end_);
                }
                this.unknownFields.writeTo(codedOutputStream);
            }

            /* synthetic */ ExtensionRange(GeneratedMessageV3.b bVar, a aVar) {
                this(bVar);
            }

            public static b newBuilder(ExtensionRange extensionRange) {
                return DEFAULT_INSTANCE.toBuilder().k(extensionRange);
            }

            public static ExtensionRange parseFrom(ByteString byteString, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteString, qVar);
            }

            private ExtensionRange(GeneratedMessageV3.b<?> bVar) {
                super(bVar);
                this.memoizedIsInitialized = (byte) -1;
            }

            public static ExtensionRange parseDelimitedFrom(InputStream inputStream, com.google.protobuf.q qVar) throws IOException {
                return (ExtensionRange) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
            }

            public static ExtensionRange parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(bArr);
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
            public ExtensionRange getDefaultInstanceForType() {
                return DEFAULT_INSTANCE;
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
            public b toBuilder() {
                return this == DEFAULT_INSTANCE ? new b((a) null) : new b((a) null).k(this);
            }

            public static ExtensionRange parseFrom(byte[] bArr, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(bArr, qVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
            public b newBuilderForType() {
                return newBuilder();
            }

            private ExtensionRange() {
                this.memoizedIsInitialized = (byte) -1;
                this.start_ = 0;
                this.end_ = 0;
            }

            public static ExtensionRange parseFrom(InputStream inputStream) throws IOException {
                return (ExtensionRange) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
            }

            public static ExtensionRange parseFrom(InputStream inputStream, com.google.protobuf.q qVar) throws IOException {
                return (ExtensionRange) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
            }

            private ExtensionRange(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
                this();
                a1.b g10 = a1.g();
                boolean z10 = false;
                while (!z10) {
                    try {
                        try {
                            int F = iVar.F();
                            if (F != 0) {
                                if (F == 8) {
                                    this.bitField0_ |= 1;
                                    this.start_ = iVar.t();
                                } else if (F == 16) {
                                    this.bitField0_ |= 2;
                                    this.end_ = iVar.t();
                                } else if (!parseUnknownField(iVar, g10, qVar, F)) {
                                }
                            }
                            z10 = true;
                        } catch (InvalidProtocolBufferException e10) {
                            throw e10.setUnfinishedMessage(this);
                        } catch (IOException e11) {
                            throw new InvalidProtocolBufferException(e11).setUnfinishedMessage(this);
                        }
                    } finally {
                        this.unknownFields = g10.build();
                        makeExtensionsImmutable();
                    }
                }
            }

            public static ExtensionRange parseFrom(com.google.protobuf.i iVar) throws IOException {
                return (ExtensionRange) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
            }

            public static ExtensionRange parseFrom(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws IOException {
                return (ExtensionRange) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
            }
        }

        /* loaded from: classes.dex */
        public static final class ReservedRange extends GeneratedMessageV3 implements d {
            public static final int END_FIELD_NUMBER = 2;
            public static final int START_FIELD_NUMBER = 1;
            private static final long serialVersionUID = 0;
            private int bitField0_;
            private int end_;
            private byte memoizedIsInitialized;
            private int start_;
            private static final ReservedRange DEFAULT_INSTANCE = new ReservedRange();
            @Deprecated
            public static final l0<ReservedRange> PARSER = new a();

            /* loaded from: classes.dex */
            static class a extends com.google.protobuf.c<ReservedRange> {
                a() {
                }

                /* renamed from: a */
                public ReservedRange parsePartialFrom(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
                    return new ReservedRange(iVar, qVar, null);
                }
            }

            /* loaded from: classes.dex */
            public static final class b extends GeneratedMessageV3.b<b> implements d {

                /* renamed from: a  reason: collision with root package name */
                private int f12751a;

                /* renamed from: b  reason: collision with root package name */
                private int f12752b;

                /* renamed from: c  reason: collision with root package name */
                private int f12753c;

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
                public ReservedRange build() {
                    ReservedRange c10 = buildPartial();
                    if (c10.isInitialized()) {
                        return c10;
                    }
                    throw a.AbstractC0170a.newUninitializedMessageException((d0) c10);
                }

                /* renamed from: c */
                public ReservedRange buildPartial() {
                    ReservedRange reservedRange = new ReservedRange(this, (a) null);
                    int i10 = this.f12751a;
                    int i11 = 1;
                    if ((i10 & 1) != 1) {
                        i11 = 0;
                    }
                    reservedRange.start_ = this.f12752b;
                    if ((i10 & 2) == 2) {
                        i11 |= 2;
                    }
                    reservedRange.end_ = this.f12753c;
                    reservedRange.bitField0_ = i11;
                    onBuilt();
                    return reservedRange;
                }

                /* renamed from: d */
                public b clear() {
                    super.clear();
                    this.f12752b = 0;
                    int i10 = this.f12751a & (-2);
                    this.f12751a = i10;
                    this.f12753c = 0;
                    this.f12751a = i10 & (-3);
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
                    return DescriptorProtos.f12730i;
                }

                /* renamed from: i */
                public ReservedRange getDefaultInstanceForType() {
                    return ReservedRange.getDefaultInstance();
                }

                @Override // com.google.protobuf.GeneratedMessageV3.b
                protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                    return DescriptorProtos.f12731j.e(ReservedRange.class, b.class);
                }

                @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.f0
                public final boolean isInitialized() {
                    return true;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0021  */
                /* renamed from: j */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public b mergeFrom(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws IOException {
                    Throwable th2;
                    ReservedRange reservedRange = null;
                    try {
                        try {
                            ReservedRange parsePartialFrom = ReservedRange.PARSER.parsePartialFrom(iVar, qVar);
                            if (parsePartialFrom != null) {
                                k(parsePartialFrom);
                            }
                            return this;
                        } catch (InvalidProtocolBufferException e10) {
                            reservedRange = (ReservedRange) e10.getUnfinishedMessage();
                            try {
                                throw e10.unwrapIOException();
                            } catch (Throwable th3) {
                                th2 = th3;
                                if (reservedRange != null) {
                                    k(reservedRange);
                                }
                                throw th2;
                            }
                        }
                    } catch (Throwable th4) {
                        th2 = th4;
                        if (reservedRange != null) {
                        }
                        throw th2;
                    }
                }

                public b k(ReservedRange reservedRange) {
                    if (reservedRange == ReservedRange.getDefaultInstance()) {
                        return this;
                    }
                    if (reservedRange.hasStart()) {
                        q(reservedRange.getStart());
                    }
                    if (reservedRange.hasEnd()) {
                        n(reservedRange.getEnd());
                    }
                    mergeUnknownFields(reservedRange.unknownFields);
                    onChanged();
                    return this;
                }

                /* renamed from: l */
                public b mergeFrom(d0 d0Var) {
                    if (d0Var instanceof ReservedRange) {
                        return k((ReservedRange) d0Var);
                    }
                    super.mergeFrom(d0Var);
                    return this;
                }

                /* renamed from: m */
                public final b mergeUnknownFields(a1 a1Var) {
                    return (b) super.mergeUnknownFields(a1Var);
                }

                public b n(int i10) {
                    this.f12751a |= 2;
                    this.f12753c = i10;
                    onChanged();
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

                public b q(int i10) {
                    this.f12751a |= 1;
                    this.f12752b = i10;
                    onChanged();
                    return this;
                }

                /* renamed from: r */
                public final b setUnknownFields(a1 a1Var) {
                    return (b) super.setUnknownFields(a1Var);
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

            /* synthetic */ ReservedRange(com.google.protobuf.i iVar, com.google.protobuf.q qVar, a aVar) throws InvalidProtocolBufferException {
                this(iVar, qVar);
            }

            public static ReservedRange getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static final Descriptors.b getDescriptor() {
                return DescriptorProtos.f12730i;
            }

            public static b newBuilder() {
                return DEFAULT_INSTANCE.toBuilder();
            }

            public static ReservedRange parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (ReservedRange) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
            }

            public static ReservedRange parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteString);
            }

            public static l0<ReservedRange> parser() {
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
                if (!(obj instanceof ReservedRange)) {
                    return super.equals(obj);
                }
                ReservedRange reservedRange = (ReservedRange) obj;
                boolean z10 = hasStart() == reservedRange.hasStart();
                if (hasStart()) {
                    z10 = z10 && getStart() == reservedRange.getStart();
                }
                boolean z11 = z10 && hasEnd() == reservedRange.hasEnd();
                if (hasEnd()) {
                    z11 = z11 && getEnd() == reservedRange.getEnd();
                }
                return z11 && this.unknownFields.equals(reservedRange.unknownFields);
            }

            public int getEnd() {
                return this.end_;
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
            public l0<ReservedRange> getParserForType() {
                return PARSER;
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
            public int getSerializedSize() {
                int i10 = this.memoizedSize;
                if (i10 != -1) {
                    return i10;
                }
                int i11 = 0;
                if ((this.bitField0_ & 1) == 1) {
                    i11 = 0 + CodedOutputStream.v(1, this.start_);
                }
                if ((this.bitField0_ & 2) == 2) {
                    i11 += CodedOutputStream.v(2, this.end_);
                }
                int serializedSize = i11 + this.unknownFields.getSerializedSize();
                this.memoizedSize = serializedSize;
                return serializedSize;
            }

            public int getStart() {
                return this.start_;
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.g0
            public final a1 getUnknownFields() {
                return this.unknownFields;
            }

            public boolean hasEnd() {
                return (this.bitField0_ & 2) == 2;
            }

            public boolean hasStart() {
                return (this.bitField0_ & 1) == 1;
            }

            @Override // com.google.protobuf.a
            public int hashCode() {
                int i10 = this.memoizedHashCode;
                if (i10 != 0) {
                    return i10;
                }
                int hashCode = 779 + getDescriptorForType().hashCode();
                if (hasStart()) {
                    hashCode = (((hashCode * 37) + 1) * 53) + getStart();
                }
                if (hasEnd()) {
                    hashCode = (((hashCode * 37) + 2) * 53) + getEnd();
                }
                int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
                this.memoizedHashCode = hashCode2;
                return hashCode2;
            }

            @Override // com.google.protobuf.GeneratedMessageV3
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return DescriptorProtos.f12731j.e(ReservedRange.class, b.class);
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
                if ((this.bitField0_ & 1) == 1) {
                    codedOutputStream.w0(1, this.start_);
                }
                if ((this.bitField0_ & 2) == 2) {
                    codedOutputStream.w0(2, this.end_);
                }
                this.unknownFields.writeTo(codedOutputStream);
            }

            /* synthetic */ ReservedRange(GeneratedMessageV3.b bVar, a aVar) {
                this(bVar);
            }

            public static b newBuilder(ReservedRange reservedRange) {
                return DEFAULT_INSTANCE.toBuilder().k(reservedRange);
            }

            public static ReservedRange parseFrom(ByteString byteString, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteString, qVar);
            }

            private ReservedRange(GeneratedMessageV3.b<?> bVar) {
                super(bVar);
                this.memoizedIsInitialized = (byte) -1;
            }

            public static ReservedRange parseDelimitedFrom(InputStream inputStream, com.google.protobuf.q qVar) throws IOException {
                return (ReservedRange) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
            }

            public static ReservedRange parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(bArr);
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
            public ReservedRange getDefaultInstanceForType() {
                return DEFAULT_INSTANCE;
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
            public b toBuilder() {
                return this == DEFAULT_INSTANCE ? new b((a) null) : new b((a) null).k(this);
            }

            public static ReservedRange parseFrom(byte[] bArr, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(bArr, qVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
            public b newBuilderForType() {
                return newBuilder();
            }

            private ReservedRange() {
                this.memoizedIsInitialized = (byte) -1;
                this.start_ = 0;
                this.end_ = 0;
            }

            public static ReservedRange parseFrom(InputStream inputStream) throws IOException {
                return (ReservedRange) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
            }

            public static ReservedRange parseFrom(InputStream inputStream, com.google.protobuf.q qVar) throws IOException {
                return (ReservedRange) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
            }

            private ReservedRange(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
                this();
                a1.b g10 = a1.g();
                boolean z10 = false;
                while (!z10) {
                    try {
                        try {
                            int F = iVar.F();
                            if (F != 0) {
                                if (F == 8) {
                                    this.bitField0_ |= 1;
                                    this.start_ = iVar.t();
                                } else if (F == 16) {
                                    this.bitField0_ |= 2;
                                    this.end_ = iVar.t();
                                } else if (!parseUnknownField(iVar, g10, qVar, F)) {
                                }
                            }
                            z10 = true;
                        } catch (InvalidProtocolBufferException e10) {
                            throw e10.setUnfinishedMessage(this);
                        } catch (IOException e11) {
                            throw new InvalidProtocolBufferException(e11).setUnfinishedMessage(this);
                        }
                    } finally {
                        this.unknownFields = g10.build();
                        makeExtensionsImmutable();
                    }
                }
            }

            public static ReservedRange parseFrom(com.google.protobuf.i iVar) throws IOException {
                return (ReservedRange) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
            }

            public static ReservedRange parseFrom(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws IOException {
                return (ReservedRange) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
            }
        }

        /* loaded from: classes.dex */
        static class a extends com.google.protobuf.c<DescriptorProto> {
            a() {
            }

            /* renamed from: a */
            public DescriptorProto parsePartialFrom(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
                return new DescriptorProto(iVar, qVar, null);
            }
        }

        /* loaded from: classes.dex */
        public static final class b extends GeneratedMessageV3.b<b> implements b {

            /* renamed from: a  reason: collision with root package name */
            private int f12754a;

            /* renamed from: b  reason: collision with root package name */
            private Object f12755b;

            /* renamed from: c  reason: collision with root package name */
            private List<FieldDescriptorProto> f12756c;

            /* renamed from: d  reason: collision with root package name */
            private o0<FieldDescriptorProto, FieldDescriptorProto.b, g> f12757d;

            /* renamed from: e  reason: collision with root package name */
            private List<FieldDescriptorProto> f12758e;

            /* renamed from: f  reason: collision with root package name */
            private o0<FieldDescriptorProto, FieldDescriptorProto.b, g> f12759f;

            /* renamed from: g  reason: collision with root package name */
            private List<DescriptorProto> f12760g;

            /* renamed from: h  reason: collision with root package name */
            private o0<DescriptorProto, b, b> f12761h;

            /* renamed from: i  reason: collision with root package name */
            private List<EnumDescriptorProto> f12762i;

            /* renamed from: j  reason: collision with root package name */
            private o0<EnumDescriptorProto, EnumDescriptorProto.b, c> f12763j;

            /* renamed from: k  reason: collision with root package name */
            private List<ExtensionRange> f12764k;

            /* renamed from: l  reason: collision with root package name */
            private o0<ExtensionRange, ExtensionRange.b, c> f12765l;

            /* renamed from: m  reason: collision with root package name */
            private List<OneofDescriptorProto> f12766m;

            /* renamed from: n  reason: collision with root package name */
            private o0<OneofDescriptorProto, OneofDescriptorProto.b, n> f12767n;

            /* renamed from: o  reason: collision with root package name */
            private MessageOptions f12768o;

            /* renamed from: p  reason: collision with root package name */
            private q0<MessageOptions, MessageOptions.b, k> f12769p;

            /* renamed from: q  reason: collision with root package name */
            private List<ReservedRange> f12770q;

            /* renamed from: r  reason: collision with root package name */
            private o0<ReservedRange, ReservedRange.b, d> f12771r;

            /* renamed from: s  reason: collision with root package name */
            private y f12772s;

            /* synthetic */ b(a aVar) {
                this();
            }

            private o0<FieldDescriptorProto, FieldDescriptorProto.b, g> B() {
                if (this.f12757d == null) {
                    this.f12757d = new o0<>(this.f12756c, (this.f12754a & 2) == 2, getParentForChildren(), isClean());
                    this.f12756c = null;
                }
                return this.f12757d;
            }

            private o0<DescriptorProto, b, b> E() {
                if (this.f12761h == null) {
                    this.f12761h = new o0<>(this.f12760g, (this.f12754a & 8) == 8, getParentForChildren(), isClean());
                    this.f12760g = null;
                }
                return this.f12761h;
            }

            private o0<OneofDescriptorProto, OneofDescriptorProto.b, n> H() {
                if (this.f12767n == null) {
                    this.f12767n = new o0<>(this.f12766m, (this.f12754a & 64) == 64, getParentForChildren(), isClean());
                    this.f12766m = null;
                }
                return this.f12767n;
            }

            private q0<MessageOptions, MessageOptions.b, k> J() {
                if (this.f12769p == null) {
                    this.f12769p = new q0<>(I(), getParentForChildren(), isClean());
                    this.f12768o = null;
                }
                return this.f12769p;
            }

            private o0<ReservedRange, ReservedRange.b, d> K() {
                if (this.f12771r == null) {
                    this.f12771r = new o0<>(this.f12770q, (this.f12754a & 256) == 256, getParentForChildren(), isClean());
                    this.f12770q = null;
                }
                return this.f12771r;
            }

            private void j() {
                if ((this.f12754a & 16) != 16) {
                    this.f12762i = new ArrayList(this.f12762i);
                    this.f12754a |= 16;
                }
            }

            private void k() {
                if ((this.f12754a & 4) != 4) {
                    this.f12758e = new ArrayList(this.f12758e);
                    this.f12754a |= 4;
                }
            }

            private void l() {
                if ((this.f12754a & 32) != 32) {
                    this.f12764k = new ArrayList(this.f12764k);
                    this.f12754a |= 32;
                }
            }

            private void m() {
                if ((this.f12754a & 2) != 2) {
                    this.f12756c = new ArrayList(this.f12756c);
                    this.f12754a |= 2;
                }
            }

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                    B();
                    x();
                    E();
                    u();
                    y();
                    H();
                    J();
                    K();
                }
            }

            private void n() {
                if ((this.f12754a & 8) != 8) {
                    this.f12760g = new ArrayList(this.f12760g);
                    this.f12754a |= 8;
                }
            }

            private void o() {
                if ((this.f12754a & 64) != 64) {
                    this.f12766m = new ArrayList(this.f12766m);
                    this.f12754a |= 64;
                }
            }

            private void p() {
                if ((this.f12754a & 512) != 512) {
                    this.f12772s = new x(this.f12772s);
                    this.f12754a |= 512;
                }
            }

            private void q() {
                if ((this.f12754a & 256) != 256) {
                    this.f12770q = new ArrayList(this.f12770q);
                    this.f12754a |= 256;
                }
            }

            private o0<EnumDescriptorProto, EnumDescriptorProto.b, c> u() {
                if (this.f12763j == null) {
                    this.f12763j = new o0<>(this.f12762i, (this.f12754a & 16) == 16, getParentForChildren(), isClean());
                    this.f12762i = null;
                }
                return this.f12763j;
            }

            private o0<FieldDescriptorProto, FieldDescriptorProto.b, g> x() {
                if (this.f12759f == null) {
                    this.f12759f = new o0<>(this.f12758e, (this.f12754a & 4) == 4, getParentForChildren(), isClean());
                    this.f12758e = null;
                }
                return this.f12759f;
            }

            private o0<ExtensionRange, ExtensionRange.b, c> y() {
                if (this.f12765l == null) {
                    this.f12765l = new o0<>(this.f12764k, (this.f12754a & 32) == 32, getParentForChildren(), isClean());
                    this.f12764k = null;
                }
                return this.f12765l;
            }

            public int A() {
                o0<FieldDescriptorProto, FieldDescriptorProto.b, g> o0Var = this.f12757d;
                if (o0Var == null) {
                    return this.f12756c.size();
                }
                return o0Var.n();
            }

            public DescriptorProto C(int i10) {
                o0<DescriptorProto, b, b> o0Var = this.f12761h;
                if (o0Var == null) {
                    return this.f12760g.get(i10);
                }
                return o0Var.o(i10);
            }

            public int D() {
                o0<DescriptorProto, b, b> o0Var = this.f12761h;
                if (o0Var == null) {
                    return this.f12760g.size();
                }
                return o0Var.n();
            }

            public OneofDescriptorProto F(int i10) {
                o0<OneofDescriptorProto, OneofDescriptorProto.b, n> o0Var = this.f12767n;
                if (o0Var == null) {
                    return this.f12766m.get(i10);
                }
                return o0Var.o(i10);
            }

            public int G() {
                o0<OneofDescriptorProto, OneofDescriptorProto.b, n> o0Var = this.f12767n;
                if (o0Var == null) {
                    return this.f12766m.size();
                }
                return o0Var.n();
            }

            public MessageOptions I() {
                q0<MessageOptions, MessageOptions.b, k> q0Var = this.f12769p;
                if (q0Var != null) {
                    return q0Var.f();
                }
                MessageOptions messageOptions = this.f12768o;
                return messageOptions == null ? MessageOptions.getDefaultInstance() : messageOptions;
            }

            public boolean L() {
                return (this.f12754a & 128) == 128;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x0021  */
            /* renamed from: M */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public b mergeFrom(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws IOException {
                Throwable th2;
                DescriptorProto descriptorProto = null;
                try {
                    try {
                        DescriptorProto parsePartialFrom = DescriptorProto.PARSER.parsePartialFrom(iVar, qVar);
                        if (parsePartialFrom != null) {
                            N(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e10) {
                        descriptorProto = (DescriptorProto) e10.getUnfinishedMessage();
                        try {
                            throw e10.unwrapIOException();
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (descriptorProto != null) {
                                N(descriptorProto);
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (descriptorProto != null) {
                    }
                    throw th2;
                }
            }

            public b N(DescriptorProto descriptorProto) {
                if (descriptorProto == DescriptorProto.getDefaultInstance()) {
                    return this;
                }
                if (descriptorProto.hasName()) {
                    this.f12754a |= 1;
                    this.f12755b = descriptorProto.name_;
                    onChanged();
                }
                o0<ReservedRange, ReservedRange.b, d> o0Var = null;
                if (this.f12757d == null) {
                    if (!descriptorProto.field_.isEmpty()) {
                        if (this.f12756c.isEmpty()) {
                            this.f12756c = descriptorProto.field_;
                            this.f12754a &= -3;
                        } else {
                            m();
                            this.f12756c.addAll(descriptorProto.field_);
                        }
                        onChanged();
                    }
                } else if (!descriptorProto.field_.isEmpty()) {
                    if (this.f12757d.u()) {
                        this.f12757d.i();
                        this.f12757d = null;
                        this.f12756c = descriptorProto.field_;
                        this.f12754a &= -3;
                        this.f12757d = GeneratedMessageV3.alwaysUseFieldBuilders ? B() : null;
                    } else {
                        this.f12757d.b(descriptorProto.field_);
                    }
                }
                if (this.f12759f == null) {
                    if (!descriptorProto.extension_.isEmpty()) {
                        if (this.f12758e.isEmpty()) {
                            this.f12758e = descriptorProto.extension_;
                            this.f12754a &= -5;
                        } else {
                            k();
                            this.f12758e.addAll(descriptorProto.extension_);
                        }
                        onChanged();
                    }
                } else if (!descriptorProto.extension_.isEmpty()) {
                    if (this.f12759f.u()) {
                        this.f12759f.i();
                        this.f12759f = null;
                        this.f12758e = descriptorProto.extension_;
                        this.f12754a &= -5;
                        this.f12759f = GeneratedMessageV3.alwaysUseFieldBuilders ? x() : null;
                    } else {
                        this.f12759f.b(descriptorProto.extension_);
                    }
                }
                if (this.f12761h == null) {
                    if (!descriptorProto.nestedType_.isEmpty()) {
                        if (this.f12760g.isEmpty()) {
                            this.f12760g = descriptorProto.nestedType_;
                            this.f12754a &= -9;
                        } else {
                            n();
                            this.f12760g.addAll(descriptorProto.nestedType_);
                        }
                        onChanged();
                    }
                } else if (!descriptorProto.nestedType_.isEmpty()) {
                    if (this.f12761h.u()) {
                        this.f12761h.i();
                        this.f12761h = null;
                        this.f12760g = descriptorProto.nestedType_;
                        this.f12754a &= -9;
                        this.f12761h = GeneratedMessageV3.alwaysUseFieldBuilders ? E() : null;
                    } else {
                        this.f12761h.b(descriptorProto.nestedType_);
                    }
                }
                if (this.f12763j == null) {
                    if (!descriptorProto.enumType_.isEmpty()) {
                        if (this.f12762i.isEmpty()) {
                            this.f12762i = descriptorProto.enumType_;
                            this.f12754a &= -17;
                        } else {
                            j();
                            this.f12762i.addAll(descriptorProto.enumType_);
                        }
                        onChanged();
                    }
                } else if (!descriptorProto.enumType_.isEmpty()) {
                    if (this.f12763j.u()) {
                        this.f12763j.i();
                        this.f12763j = null;
                        this.f12762i = descriptorProto.enumType_;
                        this.f12754a &= -17;
                        this.f12763j = GeneratedMessageV3.alwaysUseFieldBuilders ? u() : null;
                    } else {
                        this.f12763j.b(descriptorProto.enumType_);
                    }
                }
                if (this.f12765l == null) {
                    if (!descriptorProto.extensionRange_.isEmpty()) {
                        if (this.f12764k.isEmpty()) {
                            this.f12764k = descriptorProto.extensionRange_;
                            this.f12754a &= -33;
                        } else {
                            l();
                            this.f12764k.addAll(descriptorProto.extensionRange_);
                        }
                        onChanged();
                    }
                } else if (!descriptorProto.extensionRange_.isEmpty()) {
                    if (this.f12765l.u()) {
                        this.f12765l.i();
                        this.f12765l = null;
                        this.f12764k = descriptorProto.extensionRange_;
                        this.f12754a &= -33;
                        this.f12765l = GeneratedMessageV3.alwaysUseFieldBuilders ? y() : null;
                    } else {
                        this.f12765l.b(descriptorProto.extensionRange_);
                    }
                }
                if (this.f12767n == null) {
                    if (!descriptorProto.oneofDecl_.isEmpty()) {
                        if (this.f12766m.isEmpty()) {
                            this.f12766m = descriptorProto.oneofDecl_;
                            this.f12754a &= -65;
                        } else {
                            o();
                            this.f12766m.addAll(descriptorProto.oneofDecl_);
                        }
                        onChanged();
                    }
                } else if (!descriptorProto.oneofDecl_.isEmpty()) {
                    if (this.f12767n.u()) {
                        this.f12767n.i();
                        this.f12767n = null;
                        this.f12766m = descriptorProto.oneofDecl_;
                        this.f12754a &= -65;
                        this.f12767n = GeneratedMessageV3.alwaysUseFieldBuilders ? H() : null;
                    } else {
                        this.f12767n.b(descriptorProto.oneofDecl_);
                    }
                }
                if (descriptorProto.hasOptions()) {
                    P(descriptorProto.getOptions());
                }
                if (this.f12771r == null) {
                    if (!descriptorProto.reservedRange_.isEmpty()) {
                        if (this.f12770q.isEmpty()) {
                            this.f12770q = descriptorProto.reservedRange_;
                            this.f12754a &= -257;
                        } else {
                            q();
                            this.f12770q.addAll(descriptorProto.reservedRange_);
                        }
                        onChanged();
                    }
                } else if (!descriptorProto.reservedRange_.isEmpty()) {
                    if (this.f12771r.u()) {
                        this.f12771r.i();
                        this.f12771r = null;
                        this.f12770q = descriptorProto.reservedRange_;
                        this.f12754a &= -257;
                        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                            o0Var = K();
                        }
                        this.f12771r = o0Var;
                    } else {
                        this.f12771r.b(descriptorProto.reservedRange_);
                    }
                }
                if (!descriptorProto.reservedName_.isEmpty()) {
                    if (this.f12772s.isEmpty()) {
                        this.f12772s = descriptorProto.reservedName_;
                        this.f12754a &= -513;
                    } else {
                        p();
                        this.f12772s.addAll(descriptorProto.reservedName_);
                    }
                    onChanged();
                }
                mergeUnknownFields(descriptorProto.unknownFields);
                onChanged();
                return this;
            }

            /* renamed from: O */
            public b mergeFrom(d0 d0Var) {
                if (d0Var instanceof DescriptorProto) {
                    return N((DescriptorProto) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            public b P(MessageOptions messageOptions) {
                MessageOptions messageOptions2;
                q0<MessageOptions, MessageOptions.b, k> q0Var = this.f12769p;
                if (q0Var == null) {
                    if ((this.f12754a & 128) != 128 || (messageOptions2 = this.f12768o) == null || messageOptions2 == MessageOptions.getDefaultInstance()) {
                        this.f12768o = messageOptions;
                    } else {
                        this.f12768o = MessageOptions.newBuilder(this.f12768o).A(messageOptions).buildPartial();
                    }
                    onChanged();
                } else {
                    q0Var.h(messageOptions);
                }
                this.f12754a |= 128;
                return this;
            }

            /* renamed from: Q */
            public final b mergeUnknownFields(a1 a1Var) {
                return (b) super.mergeUnknownFields(a1Var);
            }

            /* renamed from: R */
            public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.setField(fieldDescriptor, obj);
            }

            public b S(String str) {
                Objects.requireNonNull(str);
                this.f12754a |= 1;
                this.f12755b = str;
                onChanged();
                return this;
            }

            /* renamed from: T */
            public b setRepeatedField2(Descriptors.FieldDescriptor fieldDescriptor, int i10, Object obj) {
                return (b) super.setRepeatedField(fieldDescriptor, i10, obj);
            }

            /* renamed from: U */
            public final b setUnknownFields(a1 a1Var) {
                return (b) super.setUnknownFields(a1Var);
            }

            public b a(ExtensionRange extensionRange) {
                o0<ExtensionRange, ExtensionRange.b, c> o0Var = this.f12765l;
                if (o0Var == null) {
                    Objects.requireNonNull(extensionRange);
                    l();
                    this.f12764k.add(extensionRange);
                    onChanged();
                } else {
                    o0Var.f(extensionRange);
                }
                return this;
            }

            /* renamed from: b */
            public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.addRepeatedField(fieldDescriptor, obj);
            }

            /* renamed from: c */
            public DescriptorProto build() {
                DescriptorProto d10 = buildPartial();
                if (d10.isInitialized()) {
                    return d10;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) d10);
            }

            /* renamed from: d */
            public DescriptorProto buildPartial() {
                DescriptorProto descriptorProto = new DescriptorProto(this, (a) null);
                int i10 = this.f12754a;
                int i11 = 1;
                if ((i10 & 1) != 1) {
                    i11 = 0;
                }
                descriptorProto.name_ = this.f12755b;
                o0<FieldDescriptorProto, FieldDescriptorProto.b, g> o0Var = this.f12757d;
                if (o0Var == null) {
                    if ((this.f12754a & 2) == 2) {
                        this.f12756c = Collections.unmodifiableList(this.f12756c);
                        this.f12754a &= -3;
                    }
                    descriptorProto.field_ = this.f12756c;
                } else {
                    descriptorProto.field_ = o0Var.g();
                }
                o0<FieldDescriptorProto, FieldDescriptorProto.b, g> o0Var2 = this.f12759f;
                if (o0Var2 == null) {
                    if ((this.f12754a & 4) == 4) {
                        this.f12758e = Collections.unmodifiableList(this.f12758e);
                        this.f12754a &= -5;
                    }
                    descriptorProto.extension_ = this.f12758e;
                } else {
                    descriptorProto.extension_ = o0Var2.g();
                }
                o0<DescriptorProto, b, b> o0Var3 = this.f12761h;
                if (o0Var3 == null) {
                    if ((this.f12754a & 8) == 8) {
                        this.f12760g = Collections.unmodifiableList(this.f12760g);
                        this.f12754a &= -9;
                    }
                    descriptorProto.nestedType_ = this.f12760g;
                } else {
                    descriptorProto.nestedType_ = o0Var3.g();
                }
                o0<EnumDescriptorProto, EnumDescriptorProto.b, c> o0Var4 = this.f12763j;
                if (o0Var4 == null) {
                    if ((this.f12754a & 16) == 16) {
                        this.f12762i = Collections.unmodifiableList(this.f12762i);
                        this.f12754a &= -17;
                    }
                    descriptorProto.enumType_ = this.f12762i;
                } else {
                    descriptorProto.enumType_ = o0Var4.g();
                }
                o0<ExtensionRange, ExtensionRange.b, c> o0Var5 = this.f12765l;
                if (o0Var5 == null) {
                    if ((this.f12754a & 32) == 32) {
                        this.f12764k = Collections.unmodifiableList(this.f12764k);
                        this.f12754a &= -33;
                    }
                    descriptorProto.extensionRange_ = this.f12764k;
                } else {
                    descriptorProto.extensionRange_ = o0Var5.g();
                }
                o0<OneofDescriptorProto, OneofDescriptorProto.b, n> o0Var6 = this.f12767n;
                if (o0Var6 == null) {
                    if ((this.f12754a & 64) == 64) {
                        this.f12766m = Collections.unmodifiableList(this.f12766m);
                        this.f12754a &= -65;
                    }
                    descriptorProto.oneofDecl_ = this.f12766m;
                } else {
                    descriptorProto.oneofDecl_ = o0Var6.g();
                }
                if ((i10 & 128) == 128) {
                    i11 |= 2;
                }
                q0<MessageOptions, MessageOptions.b, k> q0Var = this.f12769p;
                if (q0Var == null) {
                    descriptorProto.options_ = this.f12768o;
                } else {
                    descriptorProto.options_ = q0Var.b();
                }
                o0<ReservedRange, ReservedRange.b, d> o0Var7 = this.f12771r;
                if (o0Var7 == null) {
                    if ((this.f12754a & 256) == 256) {
                        this.f12770q = Collections.unmodifiableList(this.f12770q);
                        this.f12754a &= -257;
                    }
                    descriptorProto.reservedRange_ = this.f12770q;
                } else {
                    descriptorProto.reservedRange_ = o0Var7.g();
                }
                if ((this.f12754a & 512) == 512) {
                    this.f12772s = this.f12772s.u0();
                    this.f12754a &= -513;
                }
                descriptorProto.reservedName_ = this.f12772s;
                descriptorProto.bitField0_ = i11;
                onBuilt();
                return descriptorProto;
            }

            /* renamed from: e */
            public b clear() {
                super.clear();
                this.f12755b = "";
                this.f12754a &= -2;
                o0<FieldDescriptorProto, FieldDescriptorProto.b, g> o0Var = this.f12757d;
                if (o0Var == null) {
                    this.f12756c = Collections.emptyList();
                    this.f12754a &= -3;
                } else {
                    o0Var.h();
                }
                o0<FieldDescriptorProto, FieldDescriptorProto.b, g> o0Var2 = this.f12759f;
                if (o0Var2 == null) {
                    this.f12758e = Collections.emptyList();
                    this.f12754a &= -5;
                } else {
                    o0Var2.h();
                }
                o0<DescriptorProto, b, b> o0Var3 = this.f12761h;
                if (o0Var3 == null) {
                    this.f12760g = Collections.emptyList();
                    this.f12754a &= -9;
                } else {
                    o0Var3.h();
                }
                o0<EnumDescriptorProto, EnumDescriptorProto.b, c> o0Var4 = this.f12763j;
                if (o0Var4 == null) {
                    this.f12762i = Collections.emptyList();
                    this.f12754a &= -17;
                } else {
                    o0Var4.h();
                }
                o0<ExtensionRange, ExtensionRange.b, c> o0Var5 = this.f12765l;
                if (o0Var5 == null) {
                    this.f12764k = Collections.emptyList();
                    this.f12754a &= -33;
                } else {
                    o0Var5.h();
                }
                o0<OneofDescriptorProto, OneofDescriptorProto.b, n> o0Var6 = this.f12767n;
                if (o0Var6 == null) {
                    this.f12766m = Collections.emptyList();
                    this.f12754a &= -65;
                } else {
                    o0Var6.h();
                }
                q0<MessageOptions, MessageOptions.b, k> q0Var = this.f12769p;
                if (q0Var == null) {
                    this.f12768o = null;
                } else {
                    q0Var.c();
                }
                this.f12754a &= -129;
                o0<ReservedRange, ReservedRange.b, d> o0Var7 = this.f12771r;
                if (o0Var7 == null) {
                    this.f12770q = Collections.emptyList();
                    this.f12754a &= -257;
                } else {
                    o0Var7.h();
                }
                this.f12772s = x.f13385d;
                this.f12754a &= -513;
                return this;
            }

            /* renamed from: f */
            public b clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (b) super.clearField(fieldDescriptor);
            }

            /* renamed from: g */
            public b clearOneof(Descriptors.h hVar) {
                return (b) super.clearOneof(hVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a, com.google.protobuf.g0
            public Descriptors.b getDescriptorForType() {
                return DescriptorProtos.f12726e;
            }

            /* renamed from: i */
            public b clone() {
                return (b) super.clone();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return DescriptorProtos.f12727f.e(DescriptorProto.class, b.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.f0
            public final boolean isInitialized() {
                for (int i10 = 0; i10 < A(); i10++) {
                    if (!z(i10).isInitialized()) {
                        return false;
                    }
                }
                for (int i11 = 0; i11 < w(); i11++) {
                    if (!v(i11).isInitialized()) {
                        return false;
                    }
                }
                for (int i12 = 0; i12 < D(); i12++) {
                    if (!C(i12).isInitialized()) {
                        return false;
                    }
                }
                for (int i13 = 0; i13 < t(); i13++) {
                    if (!s(i13).isInitialized()) {
                        return false;
                    }
                }
                for (int i14 = 0; i14 < G(); i14++) {
                    if (!F(i14).isInitialized()) {
                        return false;
                    }
                }
                return !L() || I().isInitialized();
            }

            /* renamed from: r */
            public DescriptorProto getDefaultInstanceForType() {
                return DescriptorProto.getDefaultInstance();
            }

            public EnumDescriptorProto s(int i10) {
                o0<EnumDescriptorProto, EnumDescriptorProto.b, c> o0Var = this.f12763j;
                if (o0Var == null) {
                    return this.f12762i.get(i10);
                }
                return o0Var.o(i10);
            }

            public int t() {
                o0<EnumDescriptorProto, EnumDescriptorProto.b, c> o0Var = this.f12763j;
                if (o0Var == null) {
                    return this.f12762i.size();
                }
                return o0Var.n();
            }

            public FieldDescriptorProto v(int i10) {
                o0<FieldDescriptorProto, FieldDescriptorProto.b, g> o0Var = this.f12759f;
                if (o0Var == null) {
                    return this.f12758e.get(i10);
                }
                return o0Var.o(i10);
            }

            public int w() {
                o0<FieldDescriptorProto, FieldDescriptorProto.b, g> o0Var = this.f12759f;
                if (o0Var == null) {
                    return this.f12758e.size();
                }
                return o0Var.n();
            }

            public FieldDescriptorProto z(int i10) {
                o0<FieldDescriptorProto, FieldDescriptorProto.b, g> o0Var = this.f12757d;
                if (o0Var == null) {
                    return this.f12756c.get(i10);
                }
                return o0Var.o(i10);
            }

            /* synthetic */ b(GeneratedMessageV3.c cVar, a aVar) {
                this(cVar);
            }

            private b() {
                this.f12755b = "";
                this.f12756c = Collections.emptyList();
                this.f12758e = Collections.emptyList();
                this.f12760g = Collections.emptyList();
                this.f12762i = Collections.emptyList();
                this.f12764k = Collections.emptyList();
                this.f12766m = Collections.emptyList();
                this.f12768o = null;
                this.f12770q = Collections.emptyList();
                this.f12772s = x.f13385d;
                maybeForceBuilderInitialization();
            }

            private b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.f12755b = "";
                this.f12756c = Collections.emptyList();
                this.f12758e = Collections.emptyList();
                this.f12760g = Collections.emptyList();
                this.f12762i = Collections.emptyList();
                this.f12764k = Collections.emptyList();
                this.f12766m = Collections.emptyList();
                this.f12768o = null;
                this.f12770q = Collections.emptyList();
                this.f12772s = x.f13385d;
                maybeForceBuilderInitialization();
            }
        }

        /* loaded from: classes.dex */
        public interface c extends g0 {
        }

        /* loaded from: classes.dex */
        public interface d extends g0 {
        }

        /* synthetic */ DescriptorProto(com.google.protobuf.i iVar, com.google.protobuf.q qVar, a aVar) throws InvalidProtocolBufferException {
            this(iVar, qVar);
        }

        public static DescriptorProto getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return DescriptorProtos.f12726e;
        }

        public static b newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static DescriptorProto parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (DescriptorProto) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static DescriptorProto parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static l0<DescriptorProto> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof DescriptorProto)) {
                return super.equals(obj);
            }
            DescriptorProto descriptorProto = (DescriptorProto) obj;
            boolean z10 = hasName() == descriptorProto.hasName();
            if (hasName()) {
                z10 = z10 && getName().equals(descriptorProto.getName());
            }
            boolean z11 = ((((((z10 && getFieldList().equals(descriptorProto.getFieldList())) && getExtensionList().equals(descriptorProto.getExtensionList())) && getNestedTypeList().equals(descriptorProto.getNestedTypeList())) && getEnumTypeList().equals(descriptorProto.getEnumTypeList())) && getExtensionRangeList().equals(descriptorProto.getExtensionRangeList())) && getOneofDeclList().equals(descriptorProto.getOneofDeclList())) && hasOptions() == descriptorProto.hasOptions();
            if (hasOptions()) {
                z11 = z11 && getOptions().equals(descriptorProto.getOptions());
            }
            return ((z11 && getReservedRangeList().equals(descriptorProto.getReservedRangeList())) && getReservedNameList().equals(descriptorProto.getReservedNameList())) && this.unknownFields.equals(descriptorProto.unknownFields);
        }

        public EnumDescriptorProto getEnumType(int i10) {
            return this.enumType_.get(i10);
        }

        public int getEnumTypeCount() {
            return this.enumType_.size();
        }

        public List<EnumDescriptorProto> getEnumTypeList() {
            return this.enumType_;
        }

        public c getEnumTypeOrBuilder(int i10) {
            return this.enumType_.get(i10);
        }

        public List<? extends c> getEnumTypeOrBuilderList() {
            return this.enumType_;
        }

        public FieldDescriptorProto getExtension(int i10) {
            return this.extension_.get(i10);
        }

        public int getExtensionCount() {
            return this.extension_.size();
        }

        public List<FieldDescriptorProto> getExtensionList() {
            return this.extension_;
        }

        public g getExtensionOrBuilder(int i10) {
            return this.extension_.get(i10);
        }

        public List<? extends g> getExtensionOrBuilderList() {
            return this.extension_;
        }

        public ExtensionRange getExtensionRange(int i10) {
            return this.extensionRange_.get(i10);
        }

        public int getExtensionRangeCount() {
            return this.extensionRange_.size();
        }

        public List<ExtensionRange> getExtensionRangeList() {
            return this.extensionRange_;
        }

        public c getExtensionRangeOrBuilder(int i10) {
            return this.extensionRange_.get(i10);
        }

        public List<? extends c> getExtensionRangeOrBuilderList() {
            return this.extensionRange_;
        }

        public FieldDescriptorProto getField(int i10) {
            return this.field_.get(i10);
        }

        public int getFieldCount() {
            return this.field_.size();
        }

        public List<FieldDescriptorProto> getFieldList() {
            return this.field_;
        }

        public g getFieldOrBuilder(int i10) {
            return this.field_.get(i10);
        }

        public List<? extends g> getFieldOrBuilderList() {
            return this.field_;
        }

        public String getName() {
            Object obj = this.name_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.name_ = stringUtf8;
            }
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

        public DescriptorProto getNestedType(int i10) {
            return this.nestedType_.get(i10);
        }

        public int getNestedTypeCount() {
            return this.nestedType_.size();
        }

        public List<DescriptorProto> getNestedTypeList() {
            return this.nestedType_;
        }

        public b getNestedTypeOrBuilder(int i10) {
            return this.nestedType_.get(i10);
        }

        public List<? extends b> getNestedTypeOrBuilderList() {
            return this.nestedType_;
        }

        public OneofDescriptorProto getOneofDecl(int i10) {
            return this.oneofDecl_.get(i10);
        }

        public int getOneofDeclCount() {
            return this.oneofDecl_.size();
        }

        public List<OneofDescriptorProto> getOneofDeclList() {
            return this.oneofDecl_;
        }

        public n getOneofDeclOrBuilder(int i10) {
            return this.oneofDecl_.get(i10);
        }

        public List<? extends n> getOneofDeclOrBuilderList() {
            return this.oneofDecl_;
        }

        public MessageOptions getOptions() {
            MessageOptions messageOptions = this.options_;
            return messageOptions == null ? MessageOptions.getDefaultInstance() : messageOptions;
        }

        public k getOptionsOrBuilder() {
            MessageOptions messageOptions = this.options_;
            return messageOptions == null ? MessageOptions.getDefaultInstance() : messageOptions;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public l0<DescriptorProto> getParserForType() {
            return PARSER;
        }

        public String getReservedName(int i10) {
            return this.reservedName_.get(i10);
        }

        public ByteString getReservedNameBytes(int i10) {
            return this.reservedName_.o0(i10);
        }

        public int getReservedNameCount() {
            return this.reservedName_.size();
        }

        public ReservedRange getReservedRange(int i10) {
            return this.reservedRange_.get(i10);
        }

        public int getReservedRangeCount() {
            return this.reservedRange_.size();
        }

        public List<ReservedRange> getReservedRangeList() {
            return this.reservedRange_;
        }

        public d getReservedRangeOrBuilder(int i10) {
            return this.reservedRange_.get(i10);
        }

        public List<? extends d> getReservedRangeOrBuilderList() {
            return this.reservedRange_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
        public int getSerializedSize() {
            int i10 = this.memoizedSize;
            if (i10 != -1) {
                return i10;
            }
            int computeStringSize = (this.bitField0_ & 1) == 1 ? GeneratedMessageV3.computeStringSize(1, this.name_) + 0 : 0;
            for (int i11 = 0; i11 < this.field_.size(); i11++) {
                computeStringSize += CodedOutputStream.E(2, this.field_.get(i11));
            }
            for (int i12 = 0; i12 < this.nestedType_.size(); i12++) {
                computeStringSize += CodedOutputStream.E(3, this.nestedType_.get(i12));
            }
            for (int i13 = 0; i13 < this.enumType_.size(); i13++) {
                computeStringSize += CodedOutputStream.E(4, this.enumType_.get(i13));
            }
            for (int i14 = 0; i14 < this.extensionRange_.size(); i14++) {
                computeStringSize += CodedOutputStream.E(5, this.extensionRange_.get(i14));
            }
            for (int i15 = 0; i15 < this.extension_.size(); i15++) {
                computeStringSize += CodedOutputStream.E(6, this.extension_.get(i15));
            }
            if ((this.bitField0_ & 2) == 2) {
                computeStringSize += CodedOutputStream.E(7, getOptions());
            }
            for (int i16 = 0; i16 < this.oneofDecl_.size(); i16++) {
                computeStringSize += CodedOutputStream.E(8, this.oneofDecl_.get(i16));
            }
            for (int i17 = 0; i17 < this.reservedRange_.size(); i17++) {
                computeStringSize += CodedOutputStream.E(9, this.reservedRange_.get(i17));
            }
            int i18 = 0;
            for (int i19 = 0; i19 < this.reservedName_.size(); i19++) {
                i18 += GeneratedMessageV3.computeStringSizeNoTag(this.reservedName_.z0(i19));
            }
            int size = computeStringSize + i18 + (getReservedNameList().size() * 1) + this.unknownFields.getSerializedSize();
            this.memoizedSize = size;
            return size;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.g0
        public final a1 getUnknownFields() {
            return this.unknownFields;
        }

        public boolean hasName() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasOptions() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // com.google.protobuf.a
        public int hashCode() {
            int i10 = this.memoizedHashCode;
            if (i10 != 0) {
                return i10;
            }
            int hashCode = 779 + getDescriptorForType().hashCode();
            if (hasName()) {
                hashCode = (((hashCode * 37) + 1) * 53) + getName().hashCode();
            }
            if (getFieldCount() > 0) {
                hashCode = (((hashCode * 37) + 2) * 53) + getFieldList().hashCode();
            }
            if (getExtensionCount() > 0) {
                hashCode = (((hashCode * 37) + 6) * 53) + getExtensionList().hashCode();
            }
            if (getNestedTypeCount() > 0) {
                hashCode = (((hashCode * 37) + 3) * 53) + getNestedTypeList().hashCode();
            }
            if (getEnumTypeCount() > 0) {
                hashCode = (((hashCode * 37) + 4) * 53) + getEnumTypeList().hashCode();
            }
            if (getExtensionRangeCount() > 0) {
                hashCode = (((hashCode * 37) + 5) * 53) + getExtensionRangeList().hashCode();
            }
            if (getOneofDeclCount() > 0) {
                hashCode = (((hashCode * 37) + 8) * 53) + getOneofDeclList().hashCode();
            }
            if (hasOptions()) {
                hashCode = (((hashCode * 37) + 7) * 53) + getOptions().hashCode();
            }
            if (getReservedRangeCount() > 0) {
                hashCode = (((hashCode * 37) + 9) * 53) + getReservedRangeList().hashCode();
            }
            if (getReservedNameCount() > 0) {
                hashCode = (((hashCode * 37) + 10) * 53) + getReservedNameList().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return DescriptorProtos.f12727f.e(DescriptorProto.class, b.class);
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
            for (int i10 = 0; i10 < getFieldCount(); i10++) {
                if (!getField(i10).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            for (int i11 = 0; i11 < getExtensionCount(); i11++) {
                if (!getExtension(i11).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            for (int i12 = 0; i12 < getNestedTypeCount(); i12++) {
                if (!getNestedType(i12).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            for (int i13 = 0; i13 < getEnumTypeCount(); i13++) {
                if (!getEnumType(i13).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            for (int i14 = 0; i14 < getOneofDeclCount(); i14++) {
                if (!getOneofDecl(i14).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (!hasOptions() || getOptions().isInitialized()) {
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: w */
        public b newBuilderForType(GeneratedMessageV3.c cVar) {
            return new b(cVar, null);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if ((this.bitField0_ & 1) == 1) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.name_);
            }
            for (int i10 = 0; i10 < this.field_.size(); i10++) {
                codedOutputStream.A0(2, this.field_.get(i10));
            }
            for (int i11 = 0; i11 < this.nestedType_.size(); i11++) {
                codedOutputStream.A0(3, this.nestedType_.get(i11));
            }
            for (int i12 = 0; i12 < this.enumType_.size(); i12++) {
                codedOutputStream.A0(4, this.enumType_.get(i12));
            }
            for (int i13 = 0; i13 < this.extensionRange_.size(); i13++) {
                codedOutputStream.A0(5, this.extensionRange_.get(i13));
            }
            for (int i14 = 0; i14 < this.extension_.size(); i14++) {
                codedOutputStream.A0(6, this.extension_.get(i14));
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.A0(7, getOptions());
            }
            for (int i15 = 0; i15 < this.oneofDecl_.size(); i15++) {
                codedOutputStream.A0(8, this.oneofDecl_.get(i15));
            }
            for (int i16 = 0; i16 < this.reservedRange_.size(); i16++) {
                codedOutputStream.A0(9, this.reservedRange_.get(i16));
            }
            for (int i17 = 0; i17 < this.reservedName_.size(); i17++) {
                GeneratedMessageV3.writeString(codedOutputStream, 10, this.reservedName_.z0(i17));
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        /* synthetic */ DescriptorProto(GeneratedMessageV3.b bVar, a aVar) {
            this(bVar);
        }

        public static b newBuilder(DescriptorProto descriptorProto) {
            return DEFAULT_INSTANCE.toBuilder().N(descriptorProto);
        }

        public static DescriptorProto parseFrom(ByteString byteString, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, qVar);
        }

        public n0 getReservedNameList() {
            return this.reservedName_;
        }

        private DescriptorProto(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static DescriptorProto parseDelimitedFrom(InputStream inputStream, com.google.protobuf.q qVar) throws IOException {
            return (DescriptorProto) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
        }

        public static DescriptorProto parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
        public DescriptorProto getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b toBuilder() {
            return this == DEFAULT_INSTANCE ? new b((a) null) : new b((a) null).N(this);
        }

        public static DescriptorProto parseFrom(byte[] bArr, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b newBuilderForType() {
            return newBuilder();
        }

        private DescriptorProto() {
            this.memoizedIsInitialized = (byte) -1;
            this.name_ = "";
            this.field_ = Collections.emptyList();
            this.extension_ = Collections.emptyList();
            this.nestedType_ = Collections.emptyList();
            this.enumType_ = Collections.emptyList();
            this.extensionRange_ = Collections.emptyList();
            this.oneofDecl_ = Collections.emptyList();
            this.reservedRange_ = Collections.emptyList();
            this.reservedName_ = x.f13385d;
        }

        public static DescriptorProto parseFrom(InputStream inputStream) throws IOException {
            return (DescriptorProto) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static DescriptorProto parseFrom(InputStream inputStream, com.google.protobuf.q qVar) throws IOException {
            return (DescriptorProto) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
        }

        public static DescriptorProto parseFrom(com.google.protobuf.i iVar) throws IOException {
            return (DescriptorProto) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
        }

        public static DescriptorProto parseFrom(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws IOException {
            return (DescriptorProto) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private DescriptorProto(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
            this();
            a1.b g10 = a1.g();
            boolean z10 = false;
            boolean z11 = false;
            while (true) {
                if (!z10) {
                    try {
                        try {
                            try {
                                int F = iVar.F();
                                switch (F) {
                                    case 0:
                                        break;
                                    case 10:
                                        ByteString m10 = iVar.m();
                                        this.bitField0_ |= 1;
                                        this.name_ = m10;
                                        continue;
                                    case 18:
                                        if (!(z11 & true)) {
                                            this.field_ = new ArrayList();
                                            z11 |= true;
                                        }
                                        this.field_.add(iVar.v(FieldDescriptorProto.PARSER, qVar));
                                        continue;
                                    case 26:
                                        if (!(z11 & true)) {
                                            this.nestedType_ = new ArrayList();
                                            z11 |= true;
                                        }
                                        this.nestedType_.add(iVar.v(PARSER, qVar));
                                        continue;
                                    case 34:
                                        if (!(z11 & true)) {
                                            this.enumType_ = new ArrayList();
                                            z11 |= true;
                                        }
                                        this.enumType_.add(iVar.v(EnumDescriptorProto.PARSER, qVar));
                                        continue;
                                    case 42:
                                        if (!(z11 & true)) {
                                            this.extensionRange_ = new ArrayList();
                                            z11 |= true;
                                        }
                                        this.extensionRange_.add(iVar.v(ExtensionRange.PARSER, qVar));
                                        continue;
                                    case 50:
                                        if (!(z11 & true)) {
                                            this.extension_ = new ArrayList();
                                            z11 |= true;
                                        }
                                        this.extension_.add(iVar.v(FieldDescriptorProto.PARSER, qVar));
                                        continue;
                                    case 58:
                                        MessageOptions.b builder = (this.bitField0_ & 2) == 2 ? this.options_.toBuilder() : null;
                                        MessageOptions messageOptions = (MessageOptions) iVar.v(MessageOptions.PARSER, qVar);
                                        this.options_ = messageOptions;
                                        if (builder != null) {
                                            builder.A(messageOptions);
                                            this.options_ = builder.buildPartial();
                                        }
                                        this.bitField0_ |= 2;
                                        continue;
                                    case 66:
                                        if (!(z11 & true)) {
                                            this.oneofDecl_ = new ArrayList();
                                            z11 |= true;
                                        }
                                        this.oneofDecl_.add(iVar.v(OneofDescriptorProto.PARSER, qVar));
                                        continue;
                                    case 74:
                                        if (!(z11 & true)) {
                                            this.reservedRange_ = new ArrayList();
                                            z11 |= true;
                                        }
                                        this.reservedRange_.add(iVar.v(ReservedRange.PARSER, qVar));
                                        continue;
                                    case 82:
                                        ByteString m11 = iVar.m();
                                        if (!(z11 & true)) {
                                            this.reservedName_ = new x();
                                            z11 |= true;
                                        }
                                        this.reservedName_.v(m11);
                                        continue;
                                    default:
                                        if (!parseUnknownField(iVar, g10, qVar, F)) {
                                            break;
                                        } else {
                                            continue;
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
                        if (z11 & true) {
                            this.field_ = Collections.unmodifiableList(this.field_);
                        }
                        if (z11 & true) {
                            this.nestedType_ = Collections.unmodifiableList(this.nestedType_);
                        }
                        if (z11 & true) {
                            this.enumType_ = Collections.unmodifiableList(this.enumType_);
                        }
                        if (z11 & true) {
                            this.extensionRange_ = Collections.unmodifiableList(this.extensionRange_);
                        }
                        if (z11 & true) {
                            this.extension_ = Collections.unmodifiableList(this.extension_);
                        }
                        if (z11 & true) {
                            this.oneofDecl_ = Collections.unmodifiableList(this.oneofDecl_);
                        }
                        if (z11 & true) {
                            this.reservedRange_ = Collections.unmodifiableList(this.reservedRange_);
                        }
                        if ((z11 & true) == 512) {
                            this.reservedName_ = this.reservedName_.u0();
                        }
                        this.unknownFields = g10.build();
                        makeExtensionsImmutable();
                    }
                } else {
                    return;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class EnumDescriptorProto extends GeneratedMessageV3 implements c {
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int OPTIONS_FIELD_NUMBER = 3;
        public static final int VALUE_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private byte memoizedIsInitialized;
        private volatile Object name_;
        private EnumOptions options_;
        private List<EnumValueDescriptorProto> value_;
        private static final EnumDescriptorProto DEFAULT_INSTANCE = new EnumDescriptorProto();
        @Deprecated
        public static final l0<EnumDescriptorProto> PARSER = new a();

        /* loaded from: classes.dex */
        static class a extends com.google.protobuf.c<EnumDescriptorProto> {
            a() {
            }

            /* renamed from: a */
            public EnumDescriptorProto parsePartialFrom(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
                return new EnumDescriptorProto(iVar, qVar, null);
            }
        }

        /* loaded from: classes.dex */
        public static final class b extends GeneratedMessageV3.b<b> implements c {

            /* renamed from: a  reason: collision with root package name */
            private int f12773a;

            /* renamed from: b  reason: collision with root package name */
            private Object f12774b;

            /* renamed from: c  reason: collision with root package name */
            private List<EnumValueDescriptorProto> f12775c;

            /* renamed from: d  reason: collision with root package name */
            private o0<EnumValueDescriptorProto, EnumValueDescriptorProto.b, e> f12776d;

            /* renamed from: e  reason: collision with root package name */
            private EnumOptions f12777e;

            /* renamed from: f  reason: collision with root package name */
            private q0<EnumOptions, EnumOptions.b, d> f12778f;

            /* synthetic */ b(a aVar) {
                this();
            }

            private void i() {
                if ((this.f12773a & 2) != 2) {
                    this.f12775c = new ArrayList(this.f12775c);
                    this.f12773a |= 2;
                }
            }

            private q0<EnumOptions, EnumOptions.b, d> l() {
                if (this.f12778f == null) {
                    this.f12778f = new q0<>(k(), getParentForChildren(), isClean());
                    this.f12777e = null;
                }
                return this.f12778f;
            }

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                    o();
                    l();
                }
            }

            private o0<EnumValueDescriptorProto, EnumValueDescriptorProto.b, e> o() {
                if (this.f12776d == null) {
                    this.f12776d = new o0<>(this.f12775c, (this.f12773a & 2) == 2, getParentForChildren(), isClean());
                    this.f12775c = null;
                }
                return this.f12776d;
            }

            /* renamed from: a */
            public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.addRepeatedField(fieldDescriptor, obj);
            }

            /* renamed from: b */
            public EnumDescriptorProto build() {
                EnumDescriptorProto c10 = buildPartial();
                if (c10.isInitialized()) {
                    return c10;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) c10);
            }

            /* renamed from: c */
            public EnumDescriptorProto buildPartial() {
                EnumDescriptorProto enumDescriptorProto = new EnumDescriptorProto(this, (a) null);
                int i10 = this.f12773a;
                int i11 = 1;
                if ((i10 & 1) != 1) {
                    i11 = 0;
                }
                enumDescriptorProto.name_ = this.f12774b;
                o0<EnumValueDescriptorProto, EnumValueDescriptorProto.b, e> o0Var = this.f12776d;
                if (o0Var == null) {
                    if ((this.f12773a & 2) == 2) {
                        this.f12775c = Collections.unmodifiableList(this.f12775c);
                        this.f12773a &= -3;
                    }
                    enumDescriptorProto.value_ = this.f12775c;
                } else {
                    enumDescriptorProto.value_ = o0Var.g();
                }
                if ((i10 & 4) == 4) {
                    i11 |= 2;
                }
                q0<EnumOptions, EnumOptions.b, d> q0Var = this.f12778f;
                if (q0Var == null) {
                    enumDescriptorProto.options_ = this.f12777e;
                } else {
                    enumDescriptorProto.options_ = q0Var.b();
                }
                enumDescriptorProto.bitField0_ = i11;
                onBuilt();
                return enumDescriptorProto;
            }

            /* renamed from: d */
            public b clear() {
                super.clear();
                this.f12774b = "";
                this.f12773a &= -2;
                o0<EnumValueDescriptorProto, EnumValueDescriptorProto.b, e> o0Var = this.f12776d;
                if (o0Var == null) {
                    this.f12775c = Collections.emptyList();
                    this.f12773a &= -3;
                } else {
                    o0Var.h();
                }
                q0<EnumOptions, EnumOptions.b, d> q0Var = this.f12778f;
                if (q0Var == null) {
                    this.f12777e = null;
                } else {
                    q0Var.c();
                }
                this.f12773a &= -5;
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
                return DescriptorProtos.f12736o;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return DescriptorProtos.f12737p.e(EnumDescriptorProto.class, b.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.f0
            public final boolean isInitialized() {
                for (int i10 = 0; i10 < n(); i10++) {
                    if (!m(i10).isInitialized()) {
                        return false;
                    }
                }
                return !p() || k().isInitialized();
            }

            /* renamed from: j */
            public EnumDescriptorProto getDefaultInstanceForType() {
                return EnumDescriptorProto.getDefaultInstance();
            }

            public EnumOptions k() {
                q0<EnumOptions, EnumOptions.b, d> q0Var = this.f12778f;
                if (q0Var != null) {
                    return q0Var.f();
                }
                EnumOptions enumOptions = this.f12777e;
                return enumOptions == null ? EnumOptions.getDefaultInstance() : enumOptions;
            }

            public EnumValueDescriptorProto m(int i10) {
                o0<EnumValueDescriptorProto, EnumValueDescriptorProto.b, e> o0Var = this.f12776d;
                if (o0Var == null) {
                    return this.f12775c.get(i10);
                }
                return o0Var.o(i10);
            }

            public int n() {
                o0<EnumValueDescriptorProto, EnumValueDescriptorProto.b, e> o0Var = this.f12776d;
                if (o0Var == null) {
                    return this.f12775c.size();
                }
                return o0Var.n();
            }

            public boolean p() {
                return (this.f12773a & 4) == 4;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x0021  */
            /* renamed from: q */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public b mergeFrom(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws IOException {
                Throwable th2;
                EnumDescriptorProto enumDescriptorProto = null;
                try {
                    try {
                        EnumDescriptorProto parsePartialFrom = EnumDescriptorProto.PARSER.parsePartialFrom(iVar, qVar);
                        if (parsePartialFrom != null) {
                            r(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e10) {
                        enumDescriptorProto = (EnumDescriptorProto) e10.getUnfinishedMessage();
                        try {
                            throw e10.unwrapIOException();
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (enumDescriptorProto != null) {
                                r(enumDescriptorProto);
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (enumDescriptorProto != null) {
                    }
                    throw th2;
                }
            }

            public b r(EnumDescriptorProto enumDescriptorProto) {
                if (enumDescriptorProto == EnumDescriptorProto.getDefaultInstance()) {
                    return this;
                }
                if (enumDescriptorProto.hasName()) {
                    this.f12773a |= 1;
                    this.f12774b = enumDescriptorProto.name_;
                    onChanged();
                }
                if (this.f12776d == null) {
                    if (!enumDescriptorProto.value_.isEmpty()) {
                        if (this.f12775c.isEmpty()) {
                            this.f12775c = enumDescriptorProto.value_;
                            this.f12773a &= -3;
                        } else {
                            i();
                            this.f12775c.addAll(enumDescriptorProto.value_);
                        }
                        onChanged();
                    }
                } else if (!enumDescriptorProto.value_.isEmpty()) {
                    if (this.f12776d.u()) {
                        this.f12776d.i();
                        o0<EnumValueDescriptorProto, EnumValueDescriptorProto.b, e> o0Var = null;
                        this.f12776d = null;
                        this.f12775c = enumDescriptorProto.value_;
                        this.f12773a &= -3;
                        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                            o0Var = o();
                        }
                        this.f12776d = o0Var;
                    } else {
                        this.f12776d.b(enumDescriptorProto.value_);
                    }
                }
                if (enumDescriptorProto.hasOptions()) {
                    t(enumDescriptorProto.getOptions());
                }
                mergeUnknownFields(enumDescriptorProto.unknownFields);
                onChanged();
                return this;
            }

            /* renamed from: s */
            public b mergeFrom(d0 d0Var) {
                if (d0Var instanceof EnumDescriptorProto) {
                    return r((EnumDescriptorProto) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            public b t(EnumOptions enumOptions) {
                EnumOptions enumOptions2;
                q0<EnumOptions, EnumOptions.b, d> q0Var = this.f12778f;
                if (q0Var == null) {
                    if ((this.f12773a & 4) != 4 || (enumOptions2 = this.f12777e) == null || enumOptions2 == EnumOptions.getDefaultInstance()) {
                        this.f12777e = enumOptions;
                    } else {
                        this.f12777e = EnumOptions.newBuilder(this.f12777e).A(enumOptions).buildPartial();
                    }
                    onChanged();
                } else {
                    q0Var.h(enumOptions);
                }
                this.f12773a |= 4;
                return this;
            }

            /* renamed from: u */
            public final b mergeUnknownFields(a1 a1Var) {
                return (b) super.mergeUnknownFields(a1Var);
            }

            /* renamed from: v */
            public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.setField(fieldDescriptor, obj);
            }

            /* renamed from: w */
            public b setRepeatedField2(Descriptors.FieldDescriptor fieldDescriptor, int i10, Object obj) {
                return (b) super.setRepeatedField(fieldDescriptor, i10, obj);
            }

            /* renamed from: x */
            public final b setUnknownFields(a1 a1Var) {
                return (b) super.setUnknownFields(a1Var);
            }

            /* synthetic */ b(GeneratedMessageV3.c cVar, a aVar) {
                this(cVar);
            }

            private b() {
                this.f12774b = "";
                this.f12775c = Collections.emptyList();
                this.f12777e = null;
                maybeForceBuilderInitialization();
            }

            private b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.f12774b = "";
                this.f12775c = Collections.emptyList();
                this.f12777e = null;
                maybeForceBuilderInitialization();
            }
        }

        /* synthetic */ EnumDescriptorProto(com.google.protobuf.i iVar, com.google.protobuf.q qVar, a aVar) throws InvalidProtocolBufferException {
            this(iVar, qVar);
        }

        public static EnumDescriptorProto getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return DescriptorProtos.f12736o;
        }

        public static b newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static EnumDescriptorProto parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (EnumDescriptorProto) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static EnumDescriptorProto parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static l0<EnumDescriptorProto> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof EnumDescriptorProto)) {
                return super.equals(obj);
            }
            EnumDescriptorProto enumDescriptorProto = (EnumDescriptorProto) obj;
            boolean z10 = hasName() == enumDescriptorProto.hasName();
            if (hasName()) {
                z10 = z10 && getName().equals(enumDescriptorProto.getName());
            }
            boolean z11 = (z10 && getValueList().equals(enumDescriptorProto.getValueList())) && hasOptions() == enumDescriptorProto.hasOptions();
            if (hasOptions()) {
                z11 = z11 && getOptions().equals(enumDescriptorProto.getOptions());
            }
            return z11 && this.unknownFields.equals(enumDescriptorProto.unknownFields);
        }

        public String getName() {
            Object obj = this.name_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.name_ = stringUtf8;
            }
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

        public EnumOptions getOptions() {
            EnumOptions enumOptions = this.options_;
            return enumOptions == null ? EnumOptions.getDefaultInstance() : enumOptions;
        }

        public d getOptionsOrBuilder() {
            EnumOptions enumOptions = this.options_;
            return enumOptions == null ? EnumOptions.getDefaultInstance() : enumOptions;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public l0<EnumDescriptorProto> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
        public int getSerializedSize() {
            int i10 = this.memoizedSize;
            if (i10 != -1) {
                return i10;
            }
            int computeStringSize = (this.bitField0_ & 1) == 1 ? GeneratedMessageV3.computeStringSize(1, this.name_) + 0 : 0;
            for (int i11 = 0; i11 < this.value_.size(); i11++) {
                computeStringSize += CodedOutputStream.E(2, this.value_.get(i11));
            }
            if ((this.bitField0_ & 2) == 2) {
                computeStringSize += CodedOutputStream.E(3, getOptions());
            }
            int serializedSize = computeStringSize + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.g0
        public final a1 getUnknownFields() {
            return this.unknownFields;
        }

        public EnumValueDescriptorProto getValue(int i10) {
            return this.value_.get(i10);
        }

        public int getValueCount() {
            return this.value_.size();
        }

        public List<EnumValueDescriptorProto> getValueList() {
            return this.value_;
        }

        public e getValueOrBuilder(int i10) {
            return this.value_.get(i10);
        }

        public List<? extends e> getValueOrBuilderList() {
            return this.value_;
        }

        public boolean hasName() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasOptions() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // com.google.protobuf.a
        public int hashCode() {
            int i10 = this.memoizedHashCode;
            if (i10 != 0) {
                return i10;
            }
            int hashCode = 779 + getDescriptorForType().hashCode();
            if (hasName()) {
                hashCode = (((hashCode * 37) + 1) * 53) + getName().hashCode();
            }
            if (getValueCount() > 0) {
                hashCode = (((hashCode * 37) + 2) * 53) + getValueList().hashCode();
            }
            if (hasOptions()) {
                hashCode = (((hashCode * 37) + 3) * 53) + getOptions().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: i */
        public b newBuilderForType(GeneratedMessageV3.c cVar) {
            return new b(cVar, null);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return DescriptorProtos.f12737p.e(EnumDescriptorProto.class, b.class);
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
            for (int i10 = 0; i10 < getValueCount(); i10++) {
                if (!getValue(i10).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (!hasOptions() || getOptions().isInitialized()) {
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if ((this.bitField0_ & 1) == 1) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.name_);
            }
            for (int i10 = 0; i10 < this.value_.size(); i10++) {
                codedOutputStream.A0(2, this.value_.get(i10));
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.A0(3, getOptions());
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        /* synthetic */ EnumDescriptorProto(GeneratedMessageV3.b bVar, a aVar) {
            this(bVar);
        }

        public static b newBuilder(EnumDescriptorProto enumDescriptorProto) {
            return DEFAULT_INSTANCE.toBuilder().r(enumDescriptorProto);
        }

        public static EnumDescriptorProto parseFrom(ByteString byteString, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, qVar);
        }

        private EnumDescriptorProto(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static EnumDescriptorProto parseDelimitedFrom(InputStream inputStream, com.google.protobuf.q qVar) throws IOException {
            return (EnumDescriptorProto) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
        }

        public static EnumDescriptorProto parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
        public EnumDescriptorProto getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b toBuilder() {
            return this == DEFAULT_INSTANCE ? new b((a) null) : new b((a) null).r(this);
        }

        public static EnumDescriptorProto parseFrom(byte[] bArr, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b newBuilderForType() {
            return newBuilder();
        }

        private EnumDescriptorProto() {
            this.memoizedIsInitialized = (byte) -1;
            this.name_ = "";
            this.value_ = Collections.emptyList();
        }

        public static EnumDescriptorProto parseFrom(InputStream inputStream) throws IOException {
            return (EnumDescriptorProto) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static EnumDescriptorProto parseFrom(InputStream inputStream, com.google.protobuf.q qVar) throws IOException {
            return (EnumDescriptorProto) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private EnumDescriptorProto(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
            this();
            a1.b g10 = a1.g();
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
                                    ByteString m10 = iVar.m();
                                    this.bitField0_ = 1 | this.bitField0_;
                                    this.name_ = m10;
                                } else if (F == 18) {
                                    if (!(z11 & true)) {
                                        this.value_ = new ArrayList();
                                        z11 |= true;
                                    }
                                    this.value_.add(iVar.v(EnumValueDescriptorProto.PARSER, qVar));
                                } else if (F == 26) {
                                    EnumOptions.b builder = (this.bitField0_ & 2) == 2 ? this.options_.toBuilder() : null;
                                    EnumOptions enumOptions = (EnumOptions) iVar.v(EnumOptions.PARSER, qVar);
                                    this.options_ = enumOptions;
                                    if (builder != null) {
                                        builder.A(enumOptions);
                                        this.options_ = builder.buildPartial();
                                    }
                                    this.bitField0_ |= 2;
                                } else if (!parseUnknownField(iVar, g10, qVar, F)) {
                                }
                            }
                            z10 = true;
                        } catch (InvalidProtocolBufferException e10) {
                            throw e10.setUnfinishedMessage(this);
                        }
                    } catch (IOException e11) {
                        throw new InvalidProtocolBufferException(e11).setUnfinishedMessage(this);
                    }
                } finally {
                    if (z11 & true) {
                        this.value_ = Collections.unmodifiableList(this.value_);
                    }
                    this.unknownFields = g10.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static EnumDescriptorProto parseFrom(com.google.protobuf.i iVar) throws IOException {
            return (EnumDescriptorProto) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
        }

        public static EnumDescriptorProto parseFrom(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws IOException {
            return (EnumDescriptorProto) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
        }
    }

    /* loaded from: classes.dex */
    public static final class EnumOptions extends GeneratedMessageV3.ExtendableMessage<EnumOptions> implements d {
        public static final int ALLOW_ALIAS_FIELD_NUMBER = 2;
        public static final int DEPRECATED_FIELD_NUMBER = 3;
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        private static final long serialVersionUID = 0;
        private boolean allowAlias_;
        private int bitField0_;
        private boolean deprecated_;
        private byte memoizedIsInitialized;
        private List<UninterpretedOption> uninterpretedOption_;
        private static final EnumOptions DEFAULT_INSTANCE = new EnumOptions();
        @Deprecated
        public static final l0<EnumOptions> PARSER = new a();

        /* loaded from: classes.dex */
        static class a extends com.google.protobuf.c<EnumOptions> {
            a() {
            }

            /* renamed from: a */
            public EnumOptions parsePartialFrom(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
                return new EnumOptions(iVar, qVar, null);
            }
        }

        /* loaded from: classes.dex */
        public static final class b extends GeneratedMessageV3.d<EnumOptions, b> implements d {

            /* renamed from: b  reason: collision with root package name */
            private int f12779b;

            /* renamed from: c  reason: collision with root package name */
            private boolean f12780c;

            /* renamed from: d  reason: collision with root package name */
            private boolean f12781d;

            /* renamed from: e  reason: collision with root package name */
            private List<UninterpretedOption> f12782e;

            /* renamed from: f  reason: collision with root package name */
            private o0<UninterpretedOption, UninterpretedOption.b, s> f12783f;

            /* synthetic */ b(a aVar) {
                this();
            }

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                    y();
                }
            }

            private void u() {
                if ((this.f12779b & 4) != 4) {
                    this.f12782e = new ArrayList(this.f12782e);
                    this.f12779b |= 4;
                }
            }

            private o0<UninterpretedOption, UninterpretedOption.b, s> y() {
                if (this.f12783f == null) {
                    this.f12783f = new o0<>(this.f12782e, (this.f12779b & 4) == 4, getParentForChildren(), isClean());
                    this.f12782e = null;
                }
                return this.f12783f;
            }

            public b A(EnumOptions enumOptions) {
                if (enumOptions == EnumOptions.getDefaultInstance()) {
                    return this;
                }
                if (enumOptions.hasAllowAlias()) {
                    D(enumOptions.getAllowAlias());
                }
                if (enumOptions.hasDeprecated()) {
                    E(enumOptions.getDeprecated());
                }
                if (this.f12783f == null) {
                    if (!enumOptions.uninterpretedOption_.isEmpty()) {
                        if (this.f12782e.isEmpty()) {
                            this.f12782e = enumOptions.uninterpretedOption_;
                            this.f12779b &= -5;
                        } else {
                            u();
                            this.f12782e.addAll(enumOptions.uninterpretedOption_);
                        }
                        onChanged();
                    }
                } else if (!enumOptions.uninterpretedOption_.isEmpty()) {
                    if (this.f12783f.u()) {
                        this.f12783f.i();
                        o0<UninterpretedOption, UninterpretedOption.b, s> o0Var = null;
                        this.f12783f = null;
                        this.f12782e = enumOptions.uninterpretedOption_;
                        this.f12779b &= -5;
                        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                            o0Var = y();
                        }
                        this.f12783f = o0Var;
                    } else {
                        this.f12783f.b(enumOptions.uninterpretedOption_);
                    }
                }
                j(enumOptions);
                mergeUnknownFields(enumOptions.unknownFields);
                onChanged();
                return this;
            }

            /* renamed from: B */
            public b mergeFrom(d0 d0Var) {
                if (d0Var instanceof EnumOptions) {
                    return A((EnumOptions) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            /* renamed from: C */
            public final b mergeUnknownFields(a1 a1Var) {
                return (b) super.mergeUnknownFields(a1Var);
            }

            public b D(boolean z10) {
                this.f12779b |= 1;
                this.f12780c = z10;
                onChanged();
                return this;
            }

            public b E(boolean z10) {
                this.f12779b |= 2;
                this.f12781d = z10;
                onChanged();
                return this;
            }

            /* renamed from: F */
            public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.setField(fieldDescriptor, obj);
            }

            /* renamed from: G */
            public b setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i10, Object obj) {
                return (b) super.setRepeatedField(fieldDescriptor, i10, obj);
            }

            /* renamed from: H */
            public final b setUnknownFields(a1 a1Var) {
                return (b) super.setUnknownFields(a1Var);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a, com.google.protobuf.g0
            public Descriptors.b getDescriptorForType() {
                return DescriptorProtos.E;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return DescriptorProtos.F.e(EnumOptions.class, b.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.d, com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.f0
            public final boolean isInitialized() {
                for (int i10 = 0; i10 < x(); i10++) {
                    if (!w(i10).isInitialized()) {
                        return false;
                    }
                }
                return i();
            }

            /* renamed from: n */
            public b b(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.addRepeatedField(fieldDescriptor, obj);
            }

            /* renamed from: o */
            public EnumOptions build() {
                EnumOptions p10 = buildPartial();
                if (p10.isInitialized()) {
                    return p10;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) p10);
            }

            /* renamed from: p */
            public EnumOptions buildPartial() {
                EnumOptions enumOptions = new EnumOptions(this, (a) null);
                int i10 = this.f12779b;
                int i11 = 1;
                if ((i10 & 1) != 1) {
                    i11 = 0;
                }
                enumOptions.allowAlias_ = this.f12780c;
                if ((i10 & 2) == 2) {
                    i11 |= 2;
                }
                enumOptions.deprecated_ = this.f12781d;
                o0<UninterpretedOption, UninterpretedOption.b, s> o0Var = this.f12783f;
                if (o0Var == null) {
                    if ((this.f12779b & 4) == 4) {
                        this.f12782e = Collections.unmodifiableList(this.f12782e);
                        this.f12779b &= -5;
                    }
                    enumOptions.uninterpretedOption_ = this.f12782e;
                } else {
                    enumOptions.uninterpretedOption_ = o0Var.g();
                }
                enumOptions.bitField0_ = i11;
                onBuilt();
                return enumOptions;
            }

            /* renamed from: q */
            public b d() {
                super.clear();
                this.f12780c = false;
                int i10 = this.f12779b & (-2);
                this.f12779b = i10;
                this.f12781d = false;
                this.f12779b = i10 & (-3);
                o0<UninterpretedOption, UninterpretedOption.b, s> o0Var = this.f12783f;
                if (o0Var == null) {
                    this.f12782e = Collections.emptyList();
                    this.f12779b &= -5;
                } else {
                    o0Var.h();
                }
                return this;
            }

            /* renamed from: r */
            public b e(Descriptors.FieldDescriptor fieldDescriptor) {
                return (b) super.clearField(fieldDescriptor);
            }

            /* renamed from: s */
            public b clearOneof(Descriptors.h hVar) {
                return (b) super.clearOneof(hVar);
            }

            /* renamed from: t */
            public b f() {
                return (b) super.clone();
            }

            /* renamed from: v */
            public EnumOptions getDefaultInstanceForType() {
                return EnumOptions.getDefaultInstance();
            }

            public UninterpretedOption w(int i10) {
                o0<UninterpretedOption, UninterpretedOption.b, s> o0Var = this.f12783f;
                if (o0Var == null) {
                    return this.f12782e.get(i10);
                }
                return o0Var.o(i10);
            }

            public int x() {
                o0<UninterpretedOption, UninterpretedOption.b, s> o0Var = this.f12783f;
                if (o0Var == null) {
                    return this.f12782e.size();
                }
                return o0Var.n();
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x0021  */
            /* renamed from: z */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public b mergeFrom(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws IOException {
                Throwable th2;
                EnumOptions enumOptions = null;
                try {
                    try {
                        EnumOptions parsePartialFrom = EnumOptions.PARSER.parsePartialFrom(iVar, qVar);
                        if (parsePartialFrom != null) {
                            A(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e10) {
                        enumOptions = (EnumOptions) e10.getUnfinishedMessage();
                        try {
                            throw e10.unwrapIOException();
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (enumOptions != null) {
                                A(enumOptions);
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (enumOptions != null) {
                    }
                    throw th2;
                }
            }

            /* synthetic */ b(GeneratedMessageV3.c cVar, a aVar) {
                this(cVar);
            }

            private b() {
                this.f12782e = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.f12782e = Collections.emptyList();
                maybeForceBuilderInitialization();
            }
        }

        /* synthetic */ EnumOptions(com.google.protobuf.i iVar, com.google.protobuf.q qVar, a aVar) throws InvalidProtocolBufferException {
            this(iVar, qVar);
        }

        public static EnumOptions getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return DescriptorProtos.E;
        }

        public static b newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static EnumOptions parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (EnumOptions) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static EnumOptions parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static l0<EnumOptions> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof EnumOptions)) {
                return super.equals(obj);
            }
            EnumOptions enumOptions = (EnumOptions) obj;
            boolean z10 = hasAllowAlias() == enumOptions.hasAllowAlias();
            if (hasAllowAlias()) {
                z10 = z10 && getAllowAlias() == enumOptions.getAllowAlias();
            }
            boolean z11 = z10 && hasDeprecated() == enumOptions.hasDeprecated();
            if (hasDeprecated()) {
                z11 = z11 && getDeprecated() == enumOptions.getDeprecated();
            }
            return ((z11 && getUninterpretedOptionList().equals(enumOptions.getUninterpretedOptionList())) && this.unknownFields.equals(enumOptions.unknownFields)) && d().equals(enumOptions.d());
        }

        public boolean getAllowAlias() {
            return this.allowAlias_;
        }

        public boolean getDeprecated() {
            return this.deprecated_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public l0<EnumOptions> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
        public int getSerializedSize() {
            int i10 = this.memoizedSize;
            if (i10 != -1) {
                return i10;
            }
            int e10 = (this.bitField0_ & 1) == 1 ? CodedOutputStream.e(2, this.allowAlias_) + 0 : 0;
            if ((this.bitField0_ & 2) == 2) {
                e10 += CodedOutputStream.e(3, this.deprecated_);
            }
            for (int i11 = 0; i11 < this.uninterpretedOption_.size(); i11++) {
                e10 += CodedOutputStream.E(999, this.uninterpretedOption_.get(i11));
            }
            int c10 = e10 + c() + this.unknownFields.getSerializedSize();
            this.memoizedSize = c10;
            return c10;
        }

        public UninterpretedOption getUninterpretedOption(int i10) {
            return this.uninterpretedOption_.get(i10);
        }

        public int getUninterpretedOptionCount() {
            return this.uninterpretedOption_.size();
        }

        public List<UninterpretedOption> getUninterpretedOptionList() {
            return this.uninterpretedOption_;
        }

        public s getUninterpretedOptionOrBuilder(int i10) {
            return this.uninterpretedOption_.get(i10);
        }

        public List<? extends s> getUninterpretedOptionOrBuilderList() {
            return this.uninterpretedOption_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.g0
        public final a1 getUnknownFields() {
            return this.unknownFields;
        }

        public boolean hasAllowAlias() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasDeprecated() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // com.google.protobuf.a
        public int hashCode() {
            int i10 = this.memoizedHashCode;
            if (i10 != 0) {
                return i10;
            }
            int hashCode = 779 + getDescriptorForType().hashCode();
            if (hasAllowAlias()) {
                hashCode = (((hashCode * 37) + 2) * 53) + u.c(getAllowAlias());
            }
            if (hasDeprecated()) {
                hashCode = (((hashCode * 37) + 3) * 53) + u.c(getDeprecated());
            }
            if (getUninterpretedOptionCount() > 0) {
                hashCode = (((hashCode * 37) + 999) * 53) + getUninterpretedOptionList().hashCode();
            }
            int hashFields = (com.google.protobuf.a.hashFields(hashCode, d()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashFields;
            return hashFields;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return DescriptorProtos.F.e(EnumOptions.class, b.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessage, com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.f0
        public final boolean isInitialized() {
            byte b10 = this.memoizedIsInitialized;
            if (b10 == 1) {
                return true;
            }
            if (b10 == 0) {
                return false;
            }
            for (int i10 = 0; i10 < getUninterpretedOptionCount(); i10++) {
                if (!getUninterpretedOption(i10).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (!b()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: o */
        public b newBuilderForType(GeneratedMessageV3.c cVar) {
            return new b(cVar, null);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            GeneratedMessageV3.ExtendableMessage<MessageType>.a g10 = g();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.e0(2, this.allowAlias_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.e0(3, this.deprecated_);
            }
            for (int i10 = 0; i10 < this.uninterpretedOption_.size(); i10++) {
                codedOutputStream.A0(999, this.uninterpretedOption_.get(i10));
            }
            g10.a(536870912, codedOutputStream);
            this.unknownFields.writeTo(codedOutputStream);
        }

        /* synthetic */ EnumOptions(GeneratedMessageV3.d dVar, a aVar) {
            this(dVar);
        }

        public static b newBuilder(EnumOptions enumOptions) {
            return DEFAULT_INSTANCE.toBuilder().A(enumOptions);
        }

        public static EnumOptions parseFrom(ByteString byteString, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, qVar);
        }

        private EnumOptions(GeneratedMessageV3.d<EnumOptions, ?> dVar) {
            super(dVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static EnumOptions parseDelimitedFrom(InputStream inputStream, com.google.protobuf.q qVar) throws IOException {
            return (EnumOptions) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
        }

        public static EnumOptions parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessage, com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
        public EnumOptions getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessage, com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b toBuilder() {
            return this == DEFAULT_INSTANCE ? new b((a) null) : new b((a) null).A(this);
        }

        public static EnumOptions parseFrom(byte[] bArr, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessage, com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b newBuilderForType() {
            return newBuilder();
        }

        private EnumOptions() {
            this.memoizedIsInitialized = (byte) -1;
            this.allowAlias_ = false;
            this.deprecated_ = false;
            this.uninterpretedOption_ = Collections.emptyList();
        }

        public static EnumOptions parseFrom(InputStream inputStream) throws IOException {
            return (EnumOptions) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static EnumOptions parseFrom(InputStream inputStream, com.google.protobuf.q qVar) throws IOException {
            return (EnumOptions) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
        }

        public static EnumOptions parseFrom(com.google.protobuf.i iVar) throws IOException {
            return (EnumOptions) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private EnumOptions(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
            this();
            a1.b g10 = a1.g();
            boolean z10 = false;
            boolean z11 = false;
            while (true) {
                if (z10) {
                    break;
                }
                try {
                    try {
                        int F = iVar.F();
                        if (F != 0) {
                            if (F == 16) {
                                this.bitField0_ |= 1;
                                this.allowAlias_ = iVar.l();
                            } else if (F == 24) {
                                this.bitField0_ |= 2;
                                this.deprecated_ = iVar.l();
                            } else if (F == 7994) {
                                if (!(z11 & true)) {
                                    this.uninterpretedOption_ = new ArrayList();
                                    z11 |= true;
                                }
                                this.uninterpretedOption_.add(iVar.v(UninterpretedOption.PARSER, qVar));
                            } else if (!parseUnknownField(iVar, g10, qVar, F)) {
                            }
                        }
                        z10 = true;
                    } catch (InvalidProtocolBufferException e10) {
                        throw e10.setUnfinishedMessage(this);
                    } catch (IOException e11) {
                        throw new InvalidProtocolBufferException(e11).setUnfinishedMessage(this);
                    }
                } finally {
                    if (z11 & true) {
                        this.uninterpretedOption_ = Collections.unmodifiableList(this.uninterpretedOption_);
                    }
                    this.unknownFields = g10.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static EnumOptions parseFrom(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws IOException {
            return (EnumOptions) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
        }
    }

    /* loaded from: classes.dex */
    public static final class EnumValueDescriptorProto extends GeneratedMessageV3 implements e {
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int NUMBER_FIELD_NUMBER = 2;
        public static final int OPTIONS_FIELD_NUMBER = 3;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private byte memoizedIsInitialized;
        private volatile Object name_;
        private int number_;
        private EnumValueOptions options_;
        private static final EnumValueDescriptorProto DEFAULT_INSTANCE = new EnumValueDescriptorProto();
        @Deprecated
        public static final l0<EnumValueDescriptorProto> PARSER = new a();

        /* loaded from: classes.dex */
        static class a extends com.google.protobuf.c<EnumValueDescriptorProto> {
            a() {
            }

            /* renamed from: a */
            public EnumValueDescriptorProto parsePartialFrom(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
                return new EnumValueDescriptorProto(iVar, qVar, null);
            }
        }

        /* loaded from: classes.dex */
        public static final class b extends GeneratedMessageV3.b<b> implements e {

            /* renamed from: a  reason: collision with root package name */
            private int f12784a;

            /* renamed from: b  reason: collision with root package name */
            private Object f12785b;

            /* renamed from: c  reason: collision with root package name */
            private int f12786c;

            /* renamed from: d  reason: collision with root package name */
            private EnumValueOptions f12787d;

            /* renamed from: e  reason: collision with root package name */
            private q0<EnumValueOptions, EnumValueOptions.b, f> f12788e;

            /* synthetic */ b(a aVar) {
                this();
            }

            private q0<EnumValueOptions, EnumValueOptions.b, f> k() {
                if (this.f12788e == null) {
                    this.f12788e = new q0<>(j(), getParentForChildren(), isClean());
                    this.f12787d = null;
                }
                return this.f12788e;
            }

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                    k();
                }
            }

            /* renamed from: a */
            public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.addRepeatedField(fieldDescriptor, obj);
            }

            /* renamed from: b */
            public EnumValueDescriptorProto build() {
                EnumValueDescriptorProto c10 = buildPartial();
                if (c10.isInitialized()) {
                    return c10;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) c10);
            }

            /* renamed from: c */
            public EnumValueDescriptorProto buildPartial() {
                EnumValueDescriptorProto enumValueDescriptorProto = new EnumValueDescriptorProto(this, (a) null);
                int i10 = this.f12784a;
                int i11 = 1;
                if ((i10 & 1) != 1) {
                    i11 = 0;
                }
                enumValueDescriptorProto.name_ = this.f12785b;
                if ((i10 & 2) == 2) {
                    i11 |= 2;
                }
                enumValueDescriptorProto.number_ = this.f12786c;
                if ((i10 & 4) == 4) {
                    i11 |= 4;
                }
                q0<EnumValueOptions, EnumValueOptions.b, f> q0Var = this.f12788e;
                if (q0Var == null) {
                    enumValueDescriptorProto.options_ = this.f12787d;
                } else {
                    enumValueDescriptorProto.options_ = q0Var.b();
                }
                enumValueDescriptorProto.bitField0_ = i11;
                onBuilt();
                return enumValueDescriptorProto;
            }

            /* renamed from: d */
            public b clear() {
                super.clear();
                this.f12785b = "";
                int i10 = this.f12784a & (-2);
                this.f12784a = i10;
                this.f12786c = 0;
                this.f12784a = i10 & (-3);
                q0<EnumValueOptions, EnumValueOptions.b, f> q0Var = this.f12788e;
                if (q0Var == null) {
                    this.f12787d = null;
                } else {
                    q0Var.c();
                }
                this.f12784a &= -5;
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
                return DescriptorProtos.f12738q;
            }

            /* renamed from: i */
            public EnumValueDescriptorProto getDefaultInstanceForType() {
                return EnumValueDescriptorProto.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return DescriptorProtos.f12739r.e(EnumValueDescriptorProto.class, b.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.f0
            public final boolean isInitialized() {
                return !l() || j().isInitialized();
            }

            public EnumValueOptions j() {
                q0<EnumValueOptions, EnumValueOptions.b, f> q0Var = this.f12788e;
                if (q0Var != null) {
                    return q0Var.f();
                }
                EnumValueOptions enumValueOptions = this.f12787d;
                return enumValueOptions == null ? EnumValueOptions.getDefaultInstance() : enumValueOptions;
            }

            public boolean l() {
                return (this.f12784a & 4) == 4;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x0021  */
            /* renamed from: m */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public b mergeFrom(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws IOException {
                Throwable th2;
                EnumValueDescriptorProto enumValueDescriptorProto = null;
                try {
                    try {
                        EnumValueDescriptorProto parsePartialFrom = EnumValueDescriptorProto.PARSER.parsePartialFrom(iVar, qVar);
                        if (parsePartialFrom != null) {
                            n(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e10) {
                        enumValueDescriptorProto = (EnumValueDescriptorProto) e10.getUnfinishedMessage();
                        try {
                            throw e10.unwrapIOException();
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (enumValueDescriptorProto != null) {
                                n(enumValueDescriptorProto);
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (enumValueDescriptorProto != null) {
                    }
                    throw th2;
                }
            }

            public b n(EnumValueDescriptorProto enumValueDescriptorProto) {
                if (enumValueDescriptorProto == EnumValueDescriptorProto.getDefaultInstance()) {
                    return this;
                }
                if (enumValueDescriptorProto.hasName()) {
                    this.f12784a |= 1;
                    this.f12785b = enumValueDescriptorProto.name_;
                    onChanged();
                }
                if (enumValueDescriptorProto.hasNumber()) {
                    t(enumValueDescriptorProto.getNumber());
                }
                if (enumValueDescriptorProto.hasOptions()) {
                    p(enumValueDescriptorProto.getOptions());
                }
                mergeUnknownFields(enumValueDescriptorProto.unknownFields);
                onChanged();
                return this;
            }

            /* renamed from: o */
            public b mergeFrom(d0 d0Var) {
                if (d0Var instanceof EnumValueDescriptorProto) {
                    return n((EnumValueDescriptorProto) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            public b p(EnumValueOptions enumValueOptions) {
                EnumValueOptions enumValueOptions2;
                q0<EnumValueOptions, EnumValueOptions.b, f> q0Var = this.f12788e;
                if (q0Var == null) {
                    if ((this.f12784a & 4) != 4 || (enumValueOptions2 = this.f12787d) == null || enumValueOptions2 == EnumValueOptions.getDefaultInstance()) {
                        this.f12787d = enumValueOptions;
                    } else {
                        this.f12787d = EnumValueOptions.newBuilder(this.f12787d).A(enumValueOptions).buildPartial();
                    }
                    onChanged();
                } else {
                    q0Var.h(enumValueOptions);
                }
                this.f12784a |= 4;
                return this;
            }

            /* renamed from: q */
            public final b mergeUnknownFields(a1 a1Var) {
                return (b) super.mergeUnknownFields(a1Var);
            }

            /* renamed from: r */
            public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.setField(fieldDescriptor, obj);
            }

            public b s(String str) {
                Objects.requireNonNull(str);
                this.f12784a |= 1;
                this.f12785b = str;
                onChanged();
                return this;
            }

            public b t(int i10) {
                this.f12784a |= 2;
                this.f12786c = i10;
                onChanged();
                return this;
            }

            /* renamed from: u */
            public b setRepeatedField2(Descriptors.FieldDescriptor fieldDescriptor, int i10, Object obj) {
                return (b) super.setRepeatedField(fieldDescriptor, i10, obj);
            }

            /* renamed from: v */
            public final b setUnknownFields(a1 a1Var) {
                return (b) super.setUnknownFields(a1Var);
            }

            /* synthetic */ b(GeneratedMessageV3.c cVar, a aVar) {
                this(cVar);
            }

            private b() {
                this.f12785b = "";
                this.f12787d = null;
                maybeForceBuilderInitialization();
            }

            private b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.f12785b = "";
                this.f12787d = null;
                maybeForceBuilderInitialization();
            }
        }

        /* synthetic */ EnumValueDescriptorProto(com.google.protobuf.i iVar, com.google.protobuf.q qVar, a aVar) throws InvalidProtocolBufferException {
            this(iVar, qVar);
        }

        public static EnumValueDescriptorProto getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return DescriptorProtos.f12738q;
        }

        public static b newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static EnumValueDescriptorProto parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (EnumValueDescriptorProto) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static EnumValueDescriptorProto parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static l0<EnumValueDescriptorProto> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof EnumValueDescriptorProto)) {
                return super.equals(obj);
            }
            EnumValueDescriptorProto enumValueDescriptorProto = (EnumValueDescriptorProto) obj;
            boolean z10 = hasName() == enumValueDescriptorProto.hasName();
            if (hasName()) {
                z10 = z10 && getName().equals(enumValueDescriptorProto.getName());
            }
            boolean z11 = z10 && hasNumber() == enumValueDescriptorProto.hasNumber();
            if (hasNumber()) {
                z11 = z11 && getNumber() == enumValueDescriptorProto.getNumber();
            }
            boolean z12 = z11 && hasOptions() == enumValueDescriptorProto.hasOptions();
            if (hasOptions()) {
                z12 = z12 && getOptions().equals(enumValueDescriptorProto.getOptions());
            }
            return z12 && this.unknownFields.equals(enumValueDescriptorProto.unknownFields);
        }

        public String getName() {
            Object obj = this.name_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.name_ = stringUtf8;
            }
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

        public int getNumber() {
            return this.number_;
        }

        public EnumValueOptions getOptions() {
            EnumValueOptions enumValueOptions = this.options_;
            return enumValueOptions == null ? EnumValueOptions.getDefaultInstance() : enumValueOptions;
        }

        public f getOptionsOrBuilder() {
            EnumValueOptions enumValueOptions = this.options_;
            return enumValueOptions == null ? EnumValueOptions.getDefaultInstance() : enumValueOptions;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public l0<EnumValueDescriptorProto> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
        public int getSerializedSize() {
            int i10 = this.memoizedSize;
            if (i10 != -1) {
                return i10;
            }
            int i11 = 0;
            if ((this.bitField0_ & 1) == 1) {
                i11 = 0 + GeneratedMessageV3.computeStringSize(1, this.name_);
            }
            if ((this.bitField0_ & 2) == 2) {
                i11 += CodedOutputStream.v(2, this.number_);
            }
            if ((this.bitField0_ & 4) == 4) {
                i11 += CodedOutputStream.E(3, getOptions());
            }
            int serializedSize = i11 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.g0
        public final a1 getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: h */
        public b newBuilderForType(GeneratedMessageV3.c cVar) {
            return new b(cVar, null);
        }

        public boolean hasName() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasNumber() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean hasOptions() {
            return (this.bitField0_ & 4) == 4;
        }

        @Override // com.google.protobuf.a
        public int hashCode() {
            int i10 = this.memoizedHashCode;
            if (i10 != 0) {
                return i10;
            }
            int hashCode = 779 + getDescriptorForType().hashCode();
            if (hasName()) {
                hashCode = (((hashCode * 37) + 1) * 53) + getName().hashCode();
            }
            if (hasNumber()) {
                hashCode = (((hashCode * 37) + 2) * 53) + getNumber();
            }
            if (hasOptions()) {
                hashCode = (((hashCode * 37) + 3) * 53) + getOptions().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return DescriptorProtos.f12739r.e(EnumValueDescriptorProto.class, b.class);
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
            if (!hasOptions() || getOptions().isInitialized()) {
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if ((this.bitField0_ & 1) == 1) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.name_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.w0(2, this.number_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.A0(3, getOptions());
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        /* synthetic */ EnumValueDescriptorProto(GeneratedMessageV3.b bVar, a aVar) {
            this(bVar);
        }

        public static b newBuilder(EnumValueDescriptorProto enumValueDescriptorProto) {
            return DEFAULT_INSTANCE.toBuilder().n(enumValueDescriptorProto);
        }

        public static EnumValueDescriptorProto parseFrom(ByteString byteString, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, qVar);
        }

        private EnumValueDescriptorProto(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static EnumValueDescriptorProto parseDelimitedFrom(InputStream inputStream, com.google.protobuf.q qVar) throws IOException {
            return (EnumValueDescriptorProto) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
        }

        public static EnumValueDescriptorProto parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
        public EnumValueDescriptorProto getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b toBuilder() {
            return this == DEFAULT_INSTANCE ? new b((a) null) : new b((a) null).n(this);
        }

        public static EnumValueDescriptorProto parseFrom(byte[] bArr, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b newBuilderForType() {
            return newBuilder();
        }

        private EnumValueDescriptorProto() {
            this.memoizedIsInitialized = (byte) -1;
            this.name_ = "";
            this.number_ = 0;
        }

        public static EnumValueDescriptorProto parseFrom(InputStream inputStream) throws IOException {
            return (EnumValueDescriptorProto) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static EnumValueDescriptorProto parseFrom(InputStream inputStream, com.google.protobuf.q qVar) throws IOException {
            return (EnumValueDescriptorProto) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
        }

        private EnumValueDescriptorProto(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
            this();
            a1.b g10 = a1.g();
            boolean z10 = false;
            while (!z10) {
                try {
                    try {
                        int F = iVar.F();
                        if (F != 0) {
                            if (F == 10) {
                                ByteString m10 = iVar.m();
                                this.bitField0_ = 1 | this.bitField0_;
                                this.name_ = m10;
                            } else if (F == 16) {
                                this.bitField0_ |= 2;
                                this.number_ = iVar.t();
                            } else if (F == 26) {
                                EnumValueOptions.b builder = (this.bitField0_ & 4) == 4 ? this.options_.toBuilder() : null;
                                EnumValueOptions enumValueOptions = (EnumValueOptions) iVar.v(EnumValueOptions.PARSER, qVar);
                                this.options_ = enumValueOptions;
                                if (builder != null) {
                                    builder.A(enumValueOptions);
                                    this.options_ = builder.buildPartial();
                                }
                                this.bitField0_ |= 4;
                            } else if (!parseUnknownField(iVar, g10, qVar, F)) {
                            }
                        }
                        z10 = true;
                    } catch (InvalidProtocolBufferException e10) {
                        throw e10.setUnfinishedMessage(this);
                    } catch (IOException e11) {
                        throw new InvalidProtocolBufferException(e11).setUnfinishedMessage(this);
                    }
                } finally {
                    this.unknownFields = g10.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static EnumValueDescriptorProto parseFrom(com.google.protobuf.i iVar) throws IOException {
            return (EnumValueDescriptorProto) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
        }

        public static EnumValueDescriptorProto parseFrom(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws IOException {
            return (EnumValueDescriptorProto) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
        }
    }

    /* loaded from: classes.dex */
    public static final class EnumValueOptions extends GeneratedMessageV3.ExtendableMessage<EnumValueOptions> implements f {
        public static final int DEPRECATED_FIELD_NUMBER = 1;
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private boolean deprecated_;
        private byte memoizedIsInitialized;
        private List<UninterpretedOption> uninterpretedOption_;
        private static final EnumValueOptions DEFAULT_INSTANCE = new EnumValueOptions();
        @Deprecated
        public static final l0<EnumValueOptions> PARSER = new a();

        /* loaded from: classes.dex */
        static class a extends com.google.protobuf.c<EnumValueOptions> {
            a() {
            }

            /* renamed from: a */
            public EnumValueOptions parsePartialFrom(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
                return new EnumValueOptions(iVar, qVar, null);
            }
        }

        /* loaded from: classes.dex */
        public static final class b extends GeneratedMessageV3.d<EnumValueOptions, b> implements f {

            /* renamed from: b  reason: collision with root package name */
            private int f12789b;

            /* renamed from: c  reason: collision with root package name */
            private boolean f12790c;

            /* renamed from: d  reason: collision with root package name */
            private List<UninterpretedOption> f12791d;

            /* renamed from: e  reason: collision with root package name */
            private o0<UninterpretedOption, UninterpretedOption.b, s> f12792e;

            /* synthetic */ b(a aVar) {
                this();
            }

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                    y();
                }
            }

            private void u() {
                if ((this.f12789b & 2) != 2) {
                    this.f12791d = new ArrayList(this.f12791d);
                    this.f12789b |= 2;
                }
            }

            private o0<UninterpretedOption, UninterpretedOption.b, s> y() {
                if (this.f12792e == null) {
                    this.f12792e = new o0<>(this.f12791d, (this.f12789b & 2) == 2, getParentForChildren(), isClean());
                    this.f12791d = null;
                }
                return this.f12792e;
            }

            public b A(EnumValueOptions enumValueOptions) {
                if (enumValueOptions == EnumValueOptions.getDefaultInstance()) {
                    return this;
                }
                if (enumValueOptions.hasDeprecated()) {
                    D(enumValueOptions.getDeprecated());
                }
                if (this.f12792e == null) {
                    if (!enumValueOptions.uninterpretedOption_.isEmpty()) {
                        if (this.f12791d.isEmpty()) {
                            this.f12791d = enumValueOptions.uninterpretedOption_;
                            this.f12789b &= -3;
                        } else {
                            u();
                            this.f12791d.addAll(enumValueOptions.uninterpretedOption_);
                        }
                        onChanged();
                    }
                } else if (!enumValueOptions.uninterpretedOption_.isEmpty()) {
                    if (this.f12792e.u()) {
                        this.f12792e.i();
                        o0<UninterpretedOption, UninterpretedOption.b, s> o0Var = null;
                        this.f12792e = null;
                        this.f12791d = enumValueOptions.uninterpretedOption_;
                        this.f12789b &= -3;
                        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                            o0Var = y();
                        }
                        this.f12792e = o0Var;
                    } else {
                        this.f12792e.b(enumValueOptions.uninterpretedOption_);
                    }
                }
                j(enumValueOptions);
                mergeUnknownFields(enumValueOptions.unknownFields);
                onChanged();
                return this;
            }

            /* renamed from: B */
            public b mergeFrom(d0 d0Var) {
                if (d0Var instanceof EnumValueOptions) {
                    return A((EnumValueOptions) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            /* renamed from: C */
            public final b mergeUnknownFields(a1 a1Var) {
                return (b) super.mergeUnknownFields(a1Var);
            }

            public b D(boolean z10) {
                this.f12789b |= 1;
                this.f12790c = z10;
                onChanged();
                return this;
            }

            /* renamed from: E */
            public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.setField(fieldDescriptor, obj);
            }

            /* renamed from: F */
            public b setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i10, Object obj) {
                return (b) super.setRepeatedField(fieldDescriptor, i10, obj);
            }

            /* renamed from: G */
            public final b setUnknownFields(a1 a1Var) {
                return (b) super.setUnknownFields(a1Var);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a, com.google.protobuf.g0
            public Descriptors.b getDescriptorForType() {
                return DescriptorProtos.G;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return DescriptorProtos.H.e(EnumValueOptions.class, b.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.d, com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.f0
            public final boolean isInitialized() {
                for (int i10 = 0; i10 < x(); i10++) {
                    if (!w(i10).isInitialized()) {
                        return false;
                    }
                }
                return i();
            }

            /* renamed from: n */
            public b b(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.addRepeatedField(fieldDescriptor, obj);
            }

            /* renamed from: o */
            public EnumValueOptions build() {
                EnumValueOptions p10 = buildPartial();
                if (p10.isInitialized()) {
                    return p10;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) p10);
            }

            /* renamed from: p */
            public EnumValueOptions buildPartial() {
                EnumValueOptions enumValueOptions = new EnumValueOptions(this, (a) null);
                int i10 = 1;
                if ((this.f12789b & 1) != 1) {
                    i10 = 0;
                }
                enumValueOptions.deprecated_ = this.f12790c;
                o0<UninterpretedOption, UninterpretedOption.b, s> o0Var = this.f12792e;
                if (o0Var == null) {
                    if ((this.f12789b & 2) == 2) {
                        this.f12791d = Collections.unmodifiableList(this.f12791d);
                        this.f12789b &= -3;
                    }
                    enumValueOptions.uninterpretedOption_ = this.f12791d;
                } else {
                    enumValueOptions.uninterpretedOption_ = o0Var.g();
                }
                enumValueOptions.bitField0_ = i10;
                onBuilt();
                return enumValueOptions;
            }

            /* renamed from: q */
            public b d() {
                super.clear();
                this.f12790c = false;
                this.f12789b &= -2;
                o0<UninterpretedOption, UninterpretedOption.b, s> o0Var = this.f12792e;
                if (o0Var == null) {
                    this.f12791d = Collections.emptyList();
                    this.f12789b &= -3;
                } else {
                    o0Var.h();
                }
                return this;
            }

            /* renamed from: r */
            public b e(Descriptors.FieldDescriptor fieldDescriptor) {
                return (b) super.clearField(fieldDescriptor);
            }

            /* renamed from: s */
            public b clearOneof(Descriptors.h hVar) {
                return (b) super.clearOneof(hVar);
            }

            /* renamed from: t */
            public b f() {
                return (b) super.clone();
            }

            /* renamed from: v */
            public EnumValueOptions getDefaultInstanceForType() {
                return EnumValueOptions.getDefaultInstance();
            }

            public UninterpretedOption w(int i10) {
                o0<UninterpretedOption, UninterpretedOption.b, s> o0Var = this.f12792e;
                if (o0Var == null) {
                    return this.f12791d.get(i10);
                }
                return o0Var.o(i10);
            }

            public int x() {
                o0<UninterpretedOption, UninterpretedOption.b, s> o0Var = this.f12792e;
                if (o0Var == null) {
                    return this.f12791d.size();
                }
                return o0Var.n();
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x0021  */
            /* renamed from: z */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public b mergeFrom(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws IOException {
                Throwable th2;
                EnumValueOptions enumValueOptions = null;
                try {
                    try {
                        EnumValueOptions parsePartialFrom = EnumValueOptions.PARSER.parsePartialFrom(iVar, qVar);
                        if (parsePartialFrom != null) {
                            A(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e10) {
                        enumValueOptions = (EnumValueOptions) e10.getUnfinishedMessage();
                        try {
                            throw e10.unwrapIOException();
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (enumValueOptions != null) {
                                A(enumValueOptions);
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (enumValueOptions != null) {
                    }
                    throw th2;
                }
            }

            /* synthetic */ b(GeneratedMessageV3.c cVar, a aVar) {
                this(cVar);
            }

            private b() {
                this.f12791d = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.f12791d = Collections.emptyList();
                maybeForceBuilderInitialization();
            }
        }

        /* synthetic */ EnumValueOptions(com.google.protobuf.i iVar, com.google.protobuf.q qVar, a aVar) throws InvalidProtocolBufferException {
            this(iVar, qVar);
        }

        public static EnumValueOptions getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return DescriptorProtos.G;
        }

        public static b newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static EnumValueOptions parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (EnumValueOptions) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static EnumValueOptions parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static l0<EnumValueOptions> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof EnumValueOptions)) {
                return super.equals(obj);
            }
            EnumValueOptions enumValueOptions = (EnumValueOptions) obj;
            boolean z10 = hasDeprecated() == enumValueOptions.hasDeprecated();
            if (hasDeprecated()) {
                z10 = z10 && getDeprecated() == enumValueOptions.getDeprecated();
            }
            return ((z10 && getUninterpretedOptionList().equals(enumValueOptions.getUninterpretedOptionList())) && this.unknownFields.equals(enumValueOptions.unknownFields)) && d().equals(enumValueOptions.d());
        }

        public boolean getDeprecated() {
            return this.deprecated_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public l0<EnumValueOptions> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
        public int getSerializedSize() {
            int i10 = this.memoizedSize;
            if (i10 != -1) {
                return i10;
            }
            int e10 = (this.bitField0_ & 1) == 1 ? CodedOutputStream.e(1, this.deprecated_) + 0 : 0;
            for (int i11 = 0; i11 < this.uninterpretedOption_.size(); i11++) {
                e10 += CodedOutputStream.E(999, this.uninterpretedOption_.get(i11));
            }
            int c10 = e10 + c() + this.unknownFields.getSerializedSize();
            this.memoizedSize = c10;
            return c10;
        }

        public UninterpretedOption getUninterpretedOption(int i10) {
            return this.uninterpretedOption_.get(i10);
        }

        public int getUninterpretedOptionCount() {
            return this.uninterpretedOption_.size();
        }

        public List<UninterpretedOption> getUninterpretedOptionList() {
            return this.uninterpretedOption_;
        }

        public s getUninterpretedOptionOrBuilder(int i10) {
            return this.uninterpretedOption_.get(i10);
        }

        public List<? extends s> getUninterpretedOptionOrBuilderList() {
            return this.uninterpretedOption_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.g0
        public final a1 getUnknownFields() {
            return this.unknownFields;
        }

        public boolean hasDeprecated() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // com.google.protobuf.a
        public int hashCode() {
            int i10 = this.memoizedHashCode;
            if (i10 != 0) {
                return i10;
            }
            int hashCode = 779 + getDescriptorForType().hashCode();
            if (hasDeprecated()) {
                hashCode = (((hashCode * 37) + 1) * 53) + u.c(getDeprecated());
            }
            if (getUninterpretedOptionCount() > 0) {
                hashCode = (((hashCode * 37) + 999) * 53) + getUninterpretedOptionList().hashCode();
            }
            int hashFields = (com.google.protobuf.a.hashFields(hashCode, d()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashFields;
            return hashFields;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return DescriptorProtos.H.e(EnumValueOptions.class, b.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessage, com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.f0
        public final boolean isInitialized() {
            byte b10 = this.memoizedIsInitialized;
            if (b10 == 1) {
                return true;
            }
            if (b10 == 0) {
                return false;
            }
            for (int i10 = 0; i10 < getUninterpretedOptionCount(); i10++) {
                if (!getUninterpretedOption(i10).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (!b()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: n */
        public b newBuilderForType(GeneratedMessageV3.c cVar) {
            return new b(cVar, null);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            GeneratedMessageV3.ExtendableMessage<MessageType>.a g10 = g();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.e0(1, this.deprecated_);
            }
            for (int i10 = 0; i10 < this.uninterpretedOption_.size(); i10++) {
                codedOutputStream.A0(999, this.uninterpretedOption_.get(i10));
            }
            g10.a(536870912, codedOutputStream);
            this.unknownFields.writeTo(codedOutputStream);
        }

        /* synthetic */ EnumValueOptions(GeneratedMessageV3.d dVar, a aVar) {
            this(dVar);
        }

        public static b newBuilder(EnumValueOptions enumValueOptions) {
            return DEFAULT_INSTANCE.toBuilder().A(enumValueOptions);
        }

        public static EnumValueOptions parseFrom(ByteString byteString, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, qVar);
        }

        private EnumValueOptions(GeneratedMessageV3.d<EnumValueOptions, ?> dVar) {
            super(dVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static EnumValueOptions parseDelimitedFrom(InputStream inputStream, com.google.protobuf.q qVar) throws IOException {
            return (EnumValueOptions) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
        }

        public static EnumValueOptions parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessage, com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
        public EnumValueOptions getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessage, com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b toBuilder() {
            return this == DEFAULT_INSTANCE ? new b((a) null) : new b((a) null).A(this);
        }

        public static EnumValueOptions parseFrom(byte[] bArr, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessage, com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b newBuilderForType() {
            return newBuilder();
        }

        private EnumValueOptions() {
            this.memoizedIsInitialized = (byte) -1;
            this.deprecated_ = false;
            this.uninterpretedOption_ = Collections.emptyList();
        }

        public static EnumValueOptions parseFrom(InputStream inputStream) throws IOException {
            return (EnumValueOptions) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static EnumValueOptions parseFrom(InputStream inputStream, com.google.protobuf.q qVar) throws IOException {
            return (EnumValueOptions) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private EnumValueOptions(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
            this();
            a1.b g10 = a1.g();
            boolean z10 = false;
            boolean z11 = false;
            while (true) {
                if (z10) {
                    break;
                }
                try {
                    try {
                        int F = iVar.F();
                        if (F != 0) {
                            if (F == 8) {
                                this.bitField0_ |= 1;
                                this.deprecated_ = iVar.l();
                            } else if (F == 7994) {
                                if (!(z11 & true)) {
                                    this.uninterpretedOption_ = new ArrayList();
                                    z11 |= true;
                                }
                                this.uninterpretedOption_.add(iVar.v(UninterpretedOption.PARSER, qVar));
                            } else if (!parseUnknownField(iVar, g10, qVar, F)) {
                            }
                        }
                        z10 = true;
                    } catch (InvalidProtocolBufferException e10) {
                        throw e10.setUnfinishedMessage(this);
                    } catch (IOException e11) {
                        throw new InvalidProtocolBufferException(e11).setUnfinishedMessage(this);
                    }
                } finally {
                    if (z11 & true) {
                        this.uninterpretedOption_ = Collections.unmodifiableList(this.uninterpretedOption_);
                    }
                    this.unknownFields = g10.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static EnumValueOptions parseFrom(com.google.protobuf.i iVar) throws IOException {
            return (EnumValueOptions) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
        }

        public static EnumValueOptions parseFrom(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws IOException {
            return (EnumValueOptions) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
        }
    }

    /* loaded from: classes.dex */
    public static final class FieldDescriptorProto extends GeneratedMessageV3 implements g {
        public static final int DEFAULT_VALUE_FIELD_NUMBER = 7;
        public static final int EXTENDEE_FIELD_NUMBER = 2;
        public static final int JSON_NAME_FIELD_NUMBER = 10;
        public static final int LABEL_FIELD_NUMBER = 4;
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int NUMBER_FIELD_NUMBER = 3;
        public static final int ONEOF_INDEX_FIELD_NUMBER = 9;
        public static final int OPTIONS_FIELD_NUMBER = 8;
        public static final int TYPE_FIELD_NUMBER = 5;
        public static final int TYPE_NAME_FIELD_NUMBER = 6;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private volatile Object defaultValue_;
        private volatile Object extendee_;
        private volatile Object jsonName_;
        private int label_;
        private byte memoizedIsInitialized;
        private volatile Object name_;
        private int number_;
        private int oneofIndex_;
        private FieldOptions options_;
        private volatile Object typeName_;
        private int type_;
        private static final FieldDescriptorProto DEFAULT_INSTANCE = new FieldDescriptorProto();
        @Deprecated
        public static final l0<FieldDescriptorProto> PARSER = new a();

        /* loaded from: classes.dex */
        public enum Label implements m0 {
            LABEL_OPTIONAL(1),
            LABEL_REQUIRED(2),
            LABEL_REPEATED(3);
            
            public static final int LABEL_OPTIONAL_VALUE = 1;
            public static final int LABEL_REPEATED_VALUE = 3;
            public static final int LABEL_REQUIRED_VALUE = 2;
            private final int value;
            private static final u.b<Label> internalValueMap = new a();
            private static final Label[] VALUES = values();

            /* loaded from: classes.dex */
            static class a implements u.b<Label> {
                a() {
                }
            }

            Label(int i10) {
                this.value = i10;
            }

            public static Label forNumber(int i10) {
                if (i10 == 1) {
                    return LABEL_OPTIONAL;
                }
                if (i10 == 2) {
                    return LABEL_REQUIRED;
                }
                if (i10 != 3) {
                    return null;
                }
                return LABEL_REPEATED;
            }

            public static final Descriptors.d getDescriptor() {
                return FieldDescriptorProto.getDescriptor().j().get(1);
            }

            public static u.b<Label> internalGetValueMap() {
                return internalValueMap;
            }

            public final Descriptors.d getDescriptorForType() {
                return getDescriptor();
            }

            @Override // com.google.protobuf.u.a
            public final int getNumber() {
                return this.value;
            }

            public final Descriptors.e getValueDescriptor() {
                return getDescriptor().i().get(ordinal());
            }

            @Deprecated
            public static Label valueOf(int i10) {
                return forNumber(i10);
            }

            public static Label valueOf(Descriptors.e eVar) {
                if (eVar.g() == getDescriptor()) {
                    return VALUES[eVar.f()];
                }
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            }
        }

        /* loaded from: classes.dex */
        public enum Type implements m0 {
            TYPE_DOUBLE(1),
            TYPE_FLOAT(2),
            TYPE_INT64(3),
            TYPE_UINT64(4),
            TYPE_INT32(5),
            TYPE_FIXED64(6),
            TYPE_FIXED32(7),
            TYPE_BOOL(8),
            TYPE_STRING(9),
            TYPE_GROUP(10),
            TYPE_MESSAGE(11),
            TYPE_BYTES(12),
            TYPE_UINT32(13),
            TYPE_ENUM(14),
            TYPE_SFIXED32(15),
            TYPE_SFIXED64(16),
            TYPE_SINT32(17),
            TYPE_SINT64(18);
            
            public static final int TYPE_BOOL_VALUE = 8;
            public static final int TYPE_BYTES_VALUE = 12;
            public static final int TYPE_DOUBLE_VALUE = 1;
            public static final int TYPE_ENUM_VALUE = 14;
            public static final int TYPE_FIXED32_VALUE = 7;
            public static final int TYPE_FIXED64_VALUE = 6;
            public static final int TYPE_FLOAT_VALUE = 2;
            public static final int TYPE_GROUP_VALUE = 10;
            public static final int TYPE_INT32_VALUE = 5;
            public static final int TYPE_INT64_VALUE = 3;
            public static final int TYPE_MESSAGE_VALUE = 11;
            public static final int TYPE_SFIXED32_VALUE = 15;
            public static final int TYPE_SFIXED64_VALUE = 16;
            public static final int TYPE_SINT32_VALUE = 17;
            public static final int TYPE_SINT64_VALUE = 18;
            public static final int TYPE_STRING_VALUE = 9;
            public static final int TYPE_UINT32_VALUE = 13;
            public static final int TYPE_UINT64_VALUE = 4;
            private final int value;
            private static final u.b<Type> internalValueMap = new a();
            private static final Type[] VALUES = values();

            /* loaded from: classes.dex */
            static class a implements u.b<Type> {
                a() {
                }
            }

            Type(int i10) {
                this.value = i10;
            }

            public static Type forNumber(int i10) {
                switch (i10) {
                    case 1:
                        return TYPE_DOUBLE;
                    case 2:
                        return TYPE_FLOAT;
                    case 3:
                        return TYPE_INT64;
                    case 4:
                        return TYPE_UINT64;
                    case 5:
                        return TYPE_INT32;
                    case 6:
                        return TYPE_FIXED64;
                    case 7:
                        return TYPE_FIXED32;
                    case 8:
                        return TYPE_BOOL;
                    case 9:
                        return TYPE_STRING;
                    case 10:
                        return TYPE_GROUP;
                    case 11:
                        return TYPE_MESSAGE;
                    case 12:
                        return TYPE_BYTES;
                    case 13:
                        return TYPE_UINT32;
                    case 14:
                        return TYPE_ENUM;
                    case 15:
                        return TYPE_SFIXED32;
                    case 16:
                        return TYPE_SFIXED64;
                    case 17:
                        return TYPE_SINT32;
                    case 18:
                        return TYPE_SINT64;
                    default:
                        return null;
                }
            }

            public static final Descriptors.d getDescriptor() {
                return FieldDescriptorProto.getDescriptor().j().get(0);
            }

            public static u.b<Type> internalGetValueMap() {
                return internalValueMap;
            }

            public final Descriptors.d getDescriptorForType() {
                return getDescriptor();
            }

            @Override // com.google.protobuf.u.a
            public final int getNumber() {
                return this.value;
            }

            public final Descriptors.e getValueDescriptor() {
                return getDescriptor().i().get(ordinal());
            }

            @Deprecated
            public static Type valueOf(int i10) {
                return forNumber(i10);
            }

            public static Type valueOf(Descriptors.e eVar) {
                if (eVar.g() == getDescriptor()) {
                    return VALUES[eVar.f()];
                }
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            }
        }

        /* loaded from: classes.dex */
        static class a extends com.google.protobuf.c<FieldDescriptorProto> {
            a() {
            }

            /* renamed from: a */
            public FieldDescriptorProto parsePartialFrom(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
                return new FieldDescriptorProto(iVar, qVar, null);
            }
        }

        /* loaded from: classes.dex */
        public static final class b extends GeneratedMessageV3.b<b> implements g {

            /* renamed from: a  reason: collision with root package name */
            private int f12793a;

            /* renamed from: b  reason: collision with root package name */
            private Object f12794b;

            /* renamed from: c  reason: collision with root package name */
            private int f12795c;

            /* renamed from: d  reason: collision with root package name */
            private int f12796d;

            /* renamed from: e  reason: collision with root package name */
            private int f12797e;

            /* renamed from: f  reason: collision with root package name */
            private Object f12798f;

            /* renamed from: g  reason: collision with root package name */
            private Object f12799g;

            /* renamed from: h  reason: collision with root package name */
            private Object f12800h;

            /* renamed from: i  reason: collision with root package name */
            private int f12801i;

            /* renamed from: j  reason: collision with root package name */
            private Object f12802j;

            /* renamed from: k  reason: collision with root package name */
            private FieldOptions f12803k;

            /* renamed from: l  reason: collision with root package name */
            private q0<FieldOptions, FieldOptions.b, h> f12804l;

            /* synthetic */ b(a aVar) {
                this();
            }

            private q0<FieldOptions, FieldOptions.b, h> k() {
                if (this.f12804l == null) {
                    this.f12804l = new q0<>(j(), getParentForChildren(), isClean());
                    this.f12803k = null;
                }
                return this.f12804l;
            }

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                    k();
                }
            }

            /* renamed from: a */
            public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.addRepeatedField(fieldDescriptor, obj);
            }

            /* renamed from: b */
            public FieldDescriptorProto build() {
                FieldDescriptorProto c10 = buildPartial();
                if (c10.isInitialized()) {
                    return c10;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) c10);
            }

            /* renamed from: c */
            public FieldDescriptorProto buildPartial() {
                FieldDescriptorProto fieldDescriptorProto = new FieldDescriptorProto(this, (a) null);
                int i10 = this.f12793a;
                int i11 = 1;
                if ((i10 & 1) != 1) {
                    i11 = 0;
                }
                fieldDescriptorProto.name_ = this.f12794b;
                if ((i10 & 2) == 2) {
                    i11 |= 2;
                }
                fieldDescriptorProto.number_ = this.f12795c;
                if ((i10 & 4) == 4) {
                    i11 |= 4;
                }
                fieldDescriptorProto.label_ = this.f12796d;
                if ((i10 & 8) == 8) {
                    i11 |= 8;
                }
                fieldDescriptorProto.type_ = this.f12797e;
                if ((i10 & 16) == 16) {
                    i11 |= 16;
                }
                fieldDescriptorProto.typeName_ = this.f12798f;
                if ((i10 & 32) == 32) {
                    i11 |= 32;
                }
                fieldDescriptorProto.extendee_ = this.f12799g;
                if ((i10 & 64) == 64) {
                    i11 |= 64;
                }
                fieldDescriptorProto.defaultValue_ = this.f12800h;
                if ((i10 & 128) == 128) {
                    i11 |= 128;
                }
                fieldDescriptorProto.oneofIndex_ = this.f12801i;
                if ((i10 & 256) == 256) {
                    i11 |= 256;
                }
                fieldDescriptorProto.jsonName_ = this.f12802j;
                if ((i10 & 512) == 512) {
                    i11 |= 512;
                }
                q0<FieldOptions, FieldOptions.b, h> q0Var = this.f12804l;
                if (q0Var == null) {
                    fieldDescriptorProto.options_ = this.f12803k;
                } else {
                    fieldDescriptorProto.options_ = q0Var.b();
                }
                fieldDescriptorProto.bitField0_ = i11;
                onBuilt();
                return fieldDescriptorProto;
            }

            /* renamed from: d */
            public b clear() {
                super.clear();
                this.f12794b = "";
                int i10 = this.f12793a & (-2);
                this.f12793a = i10;
                this.f12795c = 0;
                int i11 = i10 & (-3);
                this.f12793a = i11;
                this.f12796d = 1;
                int i12 = i11 & (-5);
                this.f12793a = i12;
                this.f12797e = 1;
                int i13 = i12 & (-9);
                this.f12793a = i13;
                this.f12798f = "";
                int i14 = i13 & (-17);
                this.f12793a = i14;
                this.f12799g = "";
                int i15 = i14 & (-33);
                this.f12793a = i15;
                this.f12800h = "";
                int i16 = i15 & (-65);
                this.f12793a = i16;
                this.f12801i = 0;
                int i17 = i16 & (-129);
                this.f12793a = i17;
                this.f12802j = "";
                this.f12793a = i17 & (-257);
                q0<FieldOptions, FieldOptions.b, h> q0Var = this.f12804l;
                if (q0Var == null) {
                    this.f12803k = null;
                } else {
                    q0Var.c();
                }
                this.f12793a &= -513;
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
                return DescriptorProtos.f12732k;
            }

            /* renamed from: i */
            public FieldDescriptorProto getDefaultInstanceForType() {
                return FieldDescriptorProto.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return DescriptorProtos.f12733l.e(FieldDescriptorProto.class, b.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.f0
            public final boolean isInitialized() {
                return !l() || j().isInitialized();
            }

            public FieldOptions j() {
                q0<FieldOptions, FieldOptions.b, h> q0Var = this.f12804l;
                if (q0Var != null) {
                    return q0Var.f();
                }
                FieldOptions fieldOptions = this.f12803k;
                return fieldOptions == null ? FieldOptions.getDefaultInstance() : fieldOptions;
            }

            public boolean l() {
                return (this.f12793a & 512) == 512;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x0021  */
            /* renamed from: m */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public b mergeFrom(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws IOException {
                Throwable th2;
                FieldDescriptorProto fieldDescriptorProto = null;
                try {
                    try {
                        FieldDescriptorProto parsePartialFrom = FieldDescriptorProto.PARSER.parsePartialFrom(iVar, qVar);
                        if (parsePartialFrom != null) {
                            n(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e10) {
                        fieldDescriptorProto = (FieldDescriptorProto) e10.getUnfinishedMessage();
                        try {
                            throw e10.unwrapIOException();
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (fieldDescriptorProto != null) {
                                n(fieldDescriptorProto);
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (fieldDescriptorProto != null) {
                    }
                    throw th2;
                }
            }

            public b n(FieldDescriptorProto fieldDescriptorProto) {
                if (fieldDescriptorProto == FieldDescriptorProto.getDefaultInstance()) {
                    return this;
                }
                if (fieldDescriptorProto.hasName()) {
                    this.f12793a |= 1;
                    this.f12794b = fieldDescriptorProto.name_;
                    onChanged();
                }
                if (fieldDescriptorProto.hasNumber()) {
                    t(fieldDescriptorProto.getNumber());
                }
                if (fieldDescriptorProto.hasLabel()) {
                    s(fieldDescriptorProto.getLabel());
                }
                if (fieldDescriptorProto.hasType()) {
                    w(fieldDescriptorProto.getType());
                }
                if (fieldDescriptorProto.hasTypeName()) {
                    this.f12793a |= 16;
                    this.f12798f = fieldDescriptorProto.typeName_;
                    onChanged();
                }
                if (fieldDescriptorProto.hasExtendee()) {
                    this.f12793a |= 32;
                    this.f12799g = fieldDescriptorProto.extendee_;
                    onChanged();
                }
                if (fieldDescriptorProto.hasDefaultValue()) {
                    this.f12793a |= 64;
                    this.f12800h = fieldDescriptorProto.defaultValue_;
                    onChanged();
                }
                if (fieldDescriptorProto.hasOneofIndex()) {
                    u(fieldDescriptorProto.getOneofIndex());
                }
                if (fieldDescriptorProto.hasJsonName()) {
                    this.f12793a |= 256;
                    this.f12802j = fieldDescriptorProto.jsonName_;
                    onChanged();
                }
                if (fieldDescriptorProto.hasOptions()) {
                    p(fieldDescriptorProto.getOptions());
                }
                mergeUnknownFields(fieldDescriptorProto.unknownFields);
                onChanged();
                return this;
            }

            /* renamed from: o */
            public b mergeFrom(d0 d0Var) {
                if (d0Var instanceof FieldDescriptorProto) {
                    return n((FieldDescriptorProto) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            public b p(FieldOptions fieldOptions) {
                FieldOptions fieldOptions2;
                q0<FieldOptions, FieldOptions.b, h> q0Var = this.f12804l;
                if (q0Var == null) {
                    if ((this.f12793a & 512) != 512 || (fieldOptions2 = this.f12803k) == null || fieldOptions2 == FieldOptions.getDefaultInstance()) {
                        this.f12803k = fieldOptions;
                    } else {
                        this.f12803k = FieldOptions.newBuilder(this.f12803k).A(fieldOptions).buildPartial();
                    }
                    onChanged();
                } else {
                    q0Var.h(fieldOptions);
                }
                this.f12793a |= 512;
                return this;
            }

            /* renamed from: q */
            public final b mergeUnknownFields(a1 a1Var) {
                return (b) super.mergeUnknownFields(a1Var);
            }

            /* renamed from: r */
            public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.setField(fieldDescriptor, obj);
            }

            public b s(Label label) {
                Objects.requireNonNull(label);
                this.f12793a |= 4;
                this.f12796d = label.getNumber();
                onChanged();
                return this;
            }

            public b t(int i10) {
                this.f12793a |= 2;
                this.f12795c = i10;
                onChanged();
                return this;
            }

            public b u(int i10) {
                this.f12793a |= 128;
                this.f12801i = i10;
                onChanged();
                return this;
            }

            /* renamed from: v */
            public b setRepeatedField2(Descriptors.FieldDescriptor fieldDescriptor, int i10, Object obj) {
                return (b) super.setRepeatedField(fieldDescriptor, i10, obj);
            }

            public b w(Type type) {
                Objects.requireNonNull(type);
                this.f12793a |= 8;
                this.f12797e = type.getNumber();
                onChanged();
                return this;
            }

            /* renamed from: x */
            public final b setUnknownFields(a1 a1Var) {
                return (b) super.setUnknownFields(a1Var);
            }

            /* synthetic */ b(GeneratedMessageV3.c cVar, a aVar) {
                this(cVar);
            }

            private b() {
                this.f12794b = "";
                this.f12796d = 1;
                this.f12797e = 1;
                this.f12798f = "";
                this.f12799g = "";
                this.f12800h = "";
                this.f12802j = "";
                this.f12803k = null;
                maybeForceBuilderInitialization();
            }

            private b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.f12794b = "";
                this.f12796d = 1;
                this.f12797e = 1;
                this.f12798f = "";
                this.f12799g = "";
                this.f12800h = "";
                this.f12802j = "";
                this.f12803k = null;
                maybeForceBuilderInitialization();
            }
        }

        /* synthetic */ FieldDescriptorProto(com.google.protobuf.i iVar, com.google.protobuf.q qVar, a aVar) throws InvalidProtocolBufferException {
            this(iVar, qVar);
        }

        public static FieldDescriptorProto getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return DescriptorProtos.f12732k;
        }

        public static b newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static FieldDescriptorProto parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (FieldDescriptorProto) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static FieldDescriptorProto parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static l0<FieldDescriptorProto> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof FieldDescriptorProto)) {
                return super.equals(obj);
            }
            FieldDescriptorProto fieldDescriptorProto = (FieldDescriptorProto) obj;
            boolean z10 = hasName() == fieldDescriptorProto.hasName();
            if (hasName()) {
                z10 = z10 && getName().equals(fieldDescriptorProto.getName());
            }
            boolean z11 = z10 && hasNumber() == fieldDescriptorProto.hasNumber();
            if (hasNumber()) {
                z11 = z11 && getNumber() == fieldDescriptorProto.getNumber();
            }
            boolean z12 = z11 && hasLabel() == fieldDescriptorProto.hasLabel();
            if (hasLabel()) {
                z12 = z12 && this.label_ == fieldDescriptorProto.label_;
            }
            boolean z13 = z12 && hasType() == fieldDescriptorProto.hasType();
            if (hasType()) {
                z13 = z13 && this.type_ == fieldDescriptorProto.type_;
            }
            boolean z14 = z13 && hasTypeName() == fieldDescriptorProto.hasTypeName();
            if (hasTypeName()) {
                z14 = z14 && getTypeName().equals(fieldDescriptorProto.getTypeName());
            }
            boolean z15 = z14 && hasExtendee() == fieldDescriptorProto.hasExtendee();
            if (hasExtendee()) {
                z15 = z15 && getExtendee().equals(fieldDescriptorProto.getExtendee());
            }
            boolean z16 = z15 && hasDefaultValue() == fieldDescriptorProto.hasDefaultValue();
            if (hasDefaultValue()) {
                z16 = z16 && getDefaultValue().equals(fieldDescriptorProto.getDefaultValue());
            }
            boolean z17 = z16 && hasOneofIndex() == fieldDescriptorProto.hasOneofIndex();
            if (hasOneofIndex()) {
                z17 = z17 && getOneofIndex() == fieldDescriptorProto.getOneofIndex();
            }
            boolean z18 = z17 && hasJsonName() == fieldDescriptorProto.hasJsonName();
            if (hasJsonName()) {
                z18 = z18 && getJsonName().equals(fieldDescriptorProto.getJsonName());
            }
            boolean z19 = z18 && hasOptions() == fieldDescriptorProto.hasOptions();
            if (hasOptions()) {
                z19 = z19 && getOptions().equals(fieldDescriptorProto.getOptions());
            }
            return z19 && this.unknownFields.equals(fieldDescriptorProto.unknownFields);
        }

        public String getDefaultValue() {
            Object obj = this.defaultValue_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.defaultValue_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getDefaultValueBytes() {
            Object obj = this.defaultValue_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.defaultValue_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public String getExtendee() {
            Object obj = this.extendee_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.extendee_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getExtendeeBytes() {
            Object obj = this.extendee_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.extendee_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public String getJsonName() {
            Object obj = this.jsonName_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.jsonName_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getJsonNameBytes() {
            Object obj = this.jsonName_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.jsonName_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public Label getLabel() {
            Label valueOf = Label.valueOf(this.label_);
            return valueOf == null ? Label.LABEL_OPTIONAL : valueOf;
        }

        public String getName() {
            Object obj = this.name_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.name_ = stringUtf8;
            }
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

        public int getNumber() {
            return this.number_;
        }

        public int getOneofIndex() {
            return this.oneofIndex_;
        }

        public FieldOptions getOptions() {
            FieldOptions fieldOptions = this.options_;
            return fieldOptions == null ? FieldOptions.getDefaultInstance() : fieldOptions;
        }

        public h getOptionsOrBuilder() {
            FieldOptions fieldOptions = this.options_;
            return fieldOptions == null ? FieldOptions.getDefaultInstance() : fieldOptions;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public l0<FieldDescriptorProto> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
        public int getSerializedSize() {
            int i10 = this.memoizedSize;
            if (i10 != -1) {
                return i10;
            }
            int i11 = 0;
            if ((this.bitField0_ & 1) == 1) {
                i11 = 0 + GeneratedMessageV3.computeStringSize(1, this.name_);
            }
            if ((this.bitField0_ & 32) == 32) {
                i11 += GeneratedMessageV3.computeStringSize(2, this.extendee_);
            }
            if ((this.bitField0_ & 2) == 2) {
                i11 += CodedOutputStream.v(3, this.number_);
            }
            if ((this.bitField0_ & 4) == 4) {
                i11 += CodedOutputStream.l(4, this.label_);
            }
            if ((this.bitField0_ & 8) == 8) {
                i11 += CodedOutputStream.l(5, this.type_);
            }
            if ((this.bitField0_ & 16) == 16) {
                i11 += GeneratedMessageV3.computeStringSize(6, this.typeName_);
            }
            if ((this.bitField0_ & 64) == 64) {
                i11 += GeneratedMessageV3.computeStringSize(7, this.defaultValue_);
            }
            if ((this.bitField0_ & 512) == 512) {
                i11 += CodedOutputStream.E(8, getOptions());
            }
            if ((this.bitField0_ & 128) == 128) {
                i11 += CodedOutputStream.v(9, this.oneofIndex_);
            }
            if ((this.bitField0_ & 256) == 256) {
                i11 += GeneratedMessageV3.computeStringSize(10, this.jsonName_);
            }
            int serializedSize = i11 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        public Type getType() {
            Type valueOf = Type.valueOf(this.type_);
            return valueOf == null ? Type.TYPE_DOUBLE : valueOf;
        }

        public String getTypeName() {
            Object obj = this.typeName_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.typeName_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getTypeNameBytes() {
            Object obj = this.typeName_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.typeName_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.g0
        public final a1 getUnknownFields() {
            return this.unknownFields;
        }

        public boolean hasDefaultValue() {
            return (this.bitField0_ & 64) == 64;
        }

        public boolean hasExtendee() {
            return (this.bitField0_ & 32) == 32;
        }

        public boolean hasJsonName() {
            return (this.bitField0_ & 256) == 256;
        }

        public boolean hasLabel() {
            return (this.bitField0_ & 4) == 4;
        }

        public boolean hasName() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasNumber() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean hasOneofIndex() {
            return (this.bitField0_ & 128) == 128;
        }

        public boolean hasOptions() {
            return (this.bitField0_ & 512) == 512;
        }

        public boolean hasType() {
            return (this.bitField0_ & 8) == 8;
        }

        public boolean hasTypeName() {
            return (this.bitField0_ & 16) == 16;
        }

        @Override // com.google.protobuf.a
        public int hashCode() {
            int i10 = this.memoizedHashCode;
            if (i10 != 0) {
                return i10;
            }
            int hashCode = 779 + getDescriptorForType().hashCode();
            if (hasName()) {
                hashCode = (((hashCode * 37) + 1) * 53) + getName().hashCode();
            }
            if (hasNumber()) {
                hashCode = (((hashCode * 37) + 3) * 53) + getNumber();
            }
            if (hasLabel()) {
                hashCode = (((hashCode * 37) + 4) * 53) + this.label_;
            }
            if (hasType()) {
                hashCode = (((hashCode * 37) + 5) * 53) + this.type_;
            }
            if (hasTypeName()) {
                hashCode = (((hashCode * 37) + 6) * 53) + getTypeName().hashCode();
            }
            if (hasExtendee()) {
                hashCode = (((hashCode * 37) + 2) * 53) + getExtendee().hashCode();
            }
            if (hasDefaultValue()) {
                hashCode = (((hashCode * 37) + 7) * 53) + getDefaultValue().hashCode();
            }
            if (hasOneofIndex()) {
                hashCode = (((hashCode * 37) + 9) * 53) + getOneofIndex();
            }
            if (hasJsonName()) {
                hashCode = (((hashCode * 37) + 10) * 53) + getJsonName().hashCode();
            }
            if (hasOptions()) {
                hashCode = (((hashCode * 37) + 8) * 53) + getOptions().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return DescriptorProtos.f12733l.e(FieldDescriptorProto.class, b.class);
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
            if (!hasOptions() || getOptions().isInitialized()) {
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: s */
        public b newBuilderForType(GeneratedMessageV3.c cVar) {
            return new b(cVar, null);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if ((this.bitField0_ & 1) == 1) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.name_);
            }
            if ((this.bitField0_ & 32) == 32) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.extendee_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.w0(3, this.number_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.m0(4, this.label_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.m0(5, this.type_);
            }
            if ((this.bitField0_ & 16) == 16) {
                GeneratedMessageV3.writeString(codedOutputStream, 6, this.typeName_);
            }
            if ((this.bitField0_ & 64) == 64) {
                GeneratedMessageV3.writeString(codedOutputStream, 7, this.defaultValue_);
            }
            if ((this.bitField0_ & 512) == 512) {
                codedOutputStream.A0(8, getOptions());
            }
            if ((this.bitField0_ & 128) == 128) {
                codedOutputStream.w0(9, this.oneofIndex_);
            }
            if ((this.bitField0_ & 256) == 256) {
                GeneratedMessageV3.writeString(codedOutputStream, 10, this.jsonName_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        /* synthetic */ FieldDescriptorProto(GeneratedMessageV3.b bVar, a aVar) {
            this(bVar);
        }

        public static b newBuilder(FieldDescriptorProto fieldDescriptorProto) {
            return DEFAULT_INSTANCE.toBuilder().n(fieldDescriptorProto);
        }

        public static FieldDescriptorProto parseFrom(ByteString byteString, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, qVar);
        }

        private FieldDescriptorProto(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static FieldDescriptorProto parseDelimitedFrom(InputStream inputStream, com.google.protobuf.q qVar) throws IOException {
            return (FieldDescriptorProto) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
        }

        public static FieldDescriptorProto parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
        public FieldDescriptorProto getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b toBuilder() {
            return this == DEFAULT_INSTANCE ? new b((a) null) : new b((a) null).n(this);
        }

        public static FieldDescriptorProto parseFrom(byte[] bArr, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b newBuilderForType() {
            return newBuilder();
        }

        private FieldDescriptorProto() {
            this.memoizedIsInitialized = (byte) -1;
            this.name_ = "";
            this.number_ = 0;
            this.label_ = 1;
            this.type_ = 1;
            this.typeName_ = "";
            this.extendee_ = "";
            this.defaultValue_ = "";
            this.oneofIndex_ = 0;
            this.jsonName_ = "";
        }

        public static FieldDescriptorProto parseFrom(InputStream inputStream) throws IOException {
            return (FieldDescriptorProto) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static FieldDescriptorProto parseFrom(InputStream inputStream, com.google.protobuf.q qVar) throws IOException {
            return (FieldDescriptorProto) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
        }

        public static FieldDescriptorProto parseFrom(com.google.protobuf.i iVar) throws IOException {
            return (FieldDescriptorProto) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
        }

        public static FieldDescriptorProto parseFrom(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws IOException {
            return (FieldDescriptorProto) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
        }

        private FieldDescriptorProto(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
            this();
            a1.b g10 = a1.g();
            boolean z10 = false;
            while (!z10) {
                try {
                    try {
                        int F = iVar.F();
                        switch (F) {
                            case 0:
                                break;
                            case 10:
                                ByteString m10 = iVar.m();
                                this.bitField0_ = 1 | this.bitField0_;
                                this.name_ = m10;
                                continue;
                            case 18:
                                ByteString m11 = iVar.m();
                                this.bitField0_ |= 32;
                                this.extendee_ = m11;
                                continue;
                            case 24:
                                this.bitField0_ |= 2;
                                this.number_ = iVar.t();
                                continue;
                            case 32:
                                int o10 = iVar.o();
                                if (Label.valueOf(o10) == null) {
                                    g10.q(4, o10);
                                    continue;
                                } else {
                                    this.bitField0_ |= 4;
                                    this.label_ = o10;
                                }
                            case 40:
                                int o11 = iVar.o();
                                if (Type.valueOf(o11) == null) {
                                    g10.q(5, o11);
                                    continue;
                                } else {
                                    this.bitField0_ |= 8;
                                    this.type_ = o11;
                                }
                            case 50:
                                ByteString m12 = iVar.m();
                                this.bitField0_ |= 16;
                                this.typeName_ = m12;
                                continue;
                            case 58:
                                ByteString m13 = iVar.m();
                                this.bitField0_ |= 64;
                                this.defaultValue_ = m13;
                                continue;
                            case 66:
                                FieldOptions.b builder = (this.bitField0_ & 512) == 512 ? this.options_.toBuilder() : null;
                                FieldOptions fieldOptions = (FieldOptions) iVar.v(FieldOptions.PARSER, qVar);
                                this.options_ = fieldOptions;
                                if (builder != null) {
                                    builder.A(fieldOptions);
                                    this.options_ = builder.buildPartial();
                                }
                                this.bitField0_ |= 512;
                                continue;
                            case 72:
                                this.bitField0_ |= 128;
                                this.oneofIndex_ = iVar.t();
                                continue;
                            case 82:
                                ByteString m14 = iVar.m();
                                this.bitField0_ |= 256;
                                this.jsonName_ = m14;
                                continue;
                            default:
                                if (!parseUnknownField(iVar, g10, qVar, F)) {
                                    break;
                                } else {
                                    continue;
                                }
                        }
                        z10 = true;
                    } catch (InvalidProtocolBufferException e10) {
                        throw e10.setUnfinishedMessage(this);
                    } catch (IOException e11) {
                        throw new InvalidProtocolBufferException(e11).setUnfinishedMessage(this);
                    }
                } finally {
                    this.unknownFields = g10.build();
                    makeExtensionsImmutable();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class FieldOptions extends GeneratedMessageV3.ExtendableMessage<FieldOptions> implements h {
        public static final int CTYPE_FIELD_NUMBER = 1;
        public static final int DEPRECATED_FIELD_NUMBER = 3;
        public static final int JSTYPE_FIELD_NUMBER = 6;
        public static final int LAZY_FIELD_NUMBER = 5;
        public static final int PACKED_FIELD_NUMBER = 2;
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        public static final int WEAK_FIELD_NUMBER = 10;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private int ctype_;
        private boolean deprecated_;
        private int jstype_;
        private boolean lazy_;
        private byte memoizedIsInitialized;
        private boolean packed_;
        private List<UninterpretedOption> uninterpretedOption_;
        private boolean weak_;
        private static final FieldOptions DEFAULT_INSTANCE = new FieldOptions();
        @Deprecated
        public static final l0<FieldOptions> PARSER = new a();

        /* loaded from: classes.dex */
        public enum CType implements m0 {
            STRING(0),
            CORD(1),
            STRING_PIECE(2);
            
            public static final int CORD_VALUE = 1;
            public static final int STRING_PIECE_VALUE = 2;
            public static final int STRING_VALUE = 0;
            private final int value;
            private static final u.b<CType> internalValueMap = new a();
            private static final CType[] VALUES = values();

            /* loaded from: classes.dex */
            static class a implements u.b<CType> {
                a() {
                }
            }

            CType(int i10) {
                this.value = i10;
            }

            public static CType forNumber(int i10) {
                if (i10 == 0) {
                    return STRING;
                }
                if (i10 == 1) {
                    return CORD;
                }
                if (i10 != 2) {
                    return null;
                }
                return STRING_PIECE;
            }

            public static final Descriptors.d getDescriptor() {
                return FieldOptions.getDescriptor().j().get(0);
            }

            public static u.b<CType> internalGetValueMap() {
                return internalValueMap;
            }

            public final Descriptors.d getDescriptorForType() {
                return getDescriptor();
            }

            @Override // com.google.protobuf.u.a
            public final int getNumber() {
                return this.value;
            }

            public final Descriptors.e getValueDescriptor() {
                return getDescriptor().i().get(ordinal());
            }

            @Deprecated
            public static CType valueOf(int i10) {
                return forNumber(i10);
            }

            public static CType valueOf(Descriptors.e eVar) {
                if (eVar.g() == getDescriptor()) {
                    return VALUES[eVar.f()];
                }
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            }
        }

        /* loaded from: classes.dex */
        public enum JSType implements m0 {
            JS_NORMAL(0),
            JS_STRING(1),
            JS_NUMBER(2);
            
            public static final int JS_NORMAL_VALUE = 0;
            public static final int JS_NUMBER_VALUE = 2;
            public static final int JS_STRING_VALUE = 1;
            private final int value;
            private static final u.b<JSType> internalValueMap = new a();
            private static final JSType[] VALUES = values();

            /* loaded from: classes.dex */
            static class a implements u.b<JSType> {
                a() {
                }
            }

            JSType(int i10) {
                this.value = i10;
            }

            public static JSType forNumber(int i10) {
                if (i10 == 0) {
                    return JS_NORMAL;
                }
                if (i10 == 1) {
                    return JS_STRING;
                }
                if (i10 != 2) {
                    return null;
                }
                return JS_NUMBER;
            }

            public static final Descriptors.d getDescriptor() {
                return FieldOptions.getDescriptor().j().get(1);
            }

            public static u.b<JSType> internalGetValueMap() {
                return internalValueMap;
            }

            public final Descriptors.d getDescriptorForType() {
                return getDescriptor();
            }

            @Override // com.google.protobuf.u.a
            public final int getNumber() {
                return this.value;
            }

            public final Descriptors.e getValueDescriptor() {
                return getDescriptor().i().get(ordinal());
            }

            @Deprecated
            public static JSType valueOf(int i10) {
                return forNumber(i10);
            }

            public static JSType valueOf(Descriptors.e eVar) {
                if (eVar.g() == getDescriptor()) {
                    return VALUES[eVar.f()];
                }
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            }
        }

        /* loaded from: classes.dex */
        static class a extends com.google.protobuf.c<FieldOptions> {
            a() {
            }

            /* renamed from: a */
            public FieldOptions parsePartialFrom(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
                return new FieldOptions(iVar, qVar, null);
            }
        }

        /* loaded from: classes.dex */
        public static final class b extends GeneratedMessageV3.d<FieldOptions, b> implements h {

            /* renamed from: b  reason: collision with root package name */
            private int f12805b;

            /* renamed from: c  reason: collision with root package name */
            private int f12806c;

            /* renamed from: d  reason: collision with root package name */
            private boolean f12807d;

            /* renamed from: e  reason: collision with root package name */
            private int f12808e;

            /* renamed from: f  reason: collision with root package name */
            private boolean f12809f;

            /* renamed from: g  reason: collision with root package name */
            private boolean f12810g;

            /* renamed from: h  reason: collision with root package name */
            private boolean f12811h;

            /* renamed from: i  reason: collision with root package name */
            private List<UninterpretedOption> f12812i;

            /* renamed from: j  reason: collision with root package name */
            private o0<UninterpretedOption, UninterpretedOption.b, s> f12813j;

            /* synthetic */ b(a aVar) {
                this();
            }

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                    y();
                }
            }

            private void u() {
                if ((this.f12805b & 64) != 64) {
                    this.f12812i = new ArrayList(this.f12812i);
                    this.f12805b |= 64;
                }
            }

            private o0<UninterpretedOption, UninterpretedOption.b, s> y() {
                if (this.f12813j == null) {
                    this.f12813j = new o0<>(this.f12812i, (this.f12805b & 64) == 64, getParentForChildren(), isClean());
                    this.f12812i = null;
                }
                return this.f12813j;
            }

            public b A(FieldOptions fieldOptions) {
                if (fieldOptions == FieldOptions.getDefaultInstance()) {
                    return this;
                }
                if (fieldOptions.hasCtype()) {
                    D(fieldOptions.getCtype());
                }
                if (fieldOptions.hasPacked()) {
                    I(fieldOptions.getPacked());
                }
                if (fieldOptions.hasJstype()) {
                    G(fieldOptions.getJstype());
                }
                if (fieldOptions.hasLazy()) {
                    H(fieldOptions.getLazy());
                }
                if (fieldOptions.hasDeprecated()) {
                    E(fieldOptions.getDeprecated());
                }
                if (fieldOptions.hasWeak()) {
                    L(fieldOptions.getWeak());
                }
                if (this.f12813j == null) {
                    if (!fieldOptions.uninterpretedOption_.isEmpty()) {
                        if (this.f12812i.isEmpty()) {
                            this.f12812i = fieldOptions.uninterpretedOption_;
                            this.f12805b &= -65;
                        } else {
                            u();
                            this.f12812i.addAll(fieldOptions.uninterpretedOption_);
                        }
                        onChanged();
                    }
                } else if (!fieldOptions.uninterpretedOption_.isEmpty()) {
                    if (this.f12813j.u()) {
                        this.f12813j.i();
                        o0<UninterpretedOption, UninterpretedOption.b, s> o0Var = null;
                        this.f12813j = null;
                        this.f12812i = fieldOptions.uninterpretedOption_;
                        this.f12805b &= -65;
                        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                            o0Var = y();
                        }
                        this.f12813j = o0Var;
                    } else {
                        this.f12813j.b(fieldOptions.uninterpretedOption_);
                    }
                }
                j(fieldOptions);
                mergeUnknownFields(fieldOptions.unknownFields);
                onChanged();
                return this;
            }

            /* renamed from: B */
            public b mergeFrom(d0 d0Var) {
                if (d0Var instanceof FieldOptions) {
                    return A((FieldOptions) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            /* renamed from: C */
            public final b mergeUnknownFields(a1 a1Var) {
                return (b) super.mergeUnknownFields(a1Var);
            }

            public b D(CType cType) {
                Objects.requireNonNull(cType);
                this.f12805b |= 1;
                this.f12806c = cType.getNumber();
                onChanged();
                return this;
            }

            public b E(boolean z10) {
                this.f12805b |= 16;
                this.f12810g = z10;
                onChanged();
                return this;
            }

            /* renamed from: F */
            public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.setField(fieldDescriptor, obj);
            }

            public b G(JSType jSType) {
                Objects.requireNonNull(jSType);
                this.f12805b |= 4;
                this.f12808e = jSType.getNumber();
                onChanged();
                return this;
            }

            public b H(boolean z10) {
                this.f12805b |= 8;
                this.f12809f = z10;
                onChanged();
                return this;
            }

            public b I(boolean z10) {
                this.f12805b |= 2;
                this.f12807d = z10;
                onChanged();
                return this;
            }

            /* renamed from: J */
            public b setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i10, Object obj) {
                return (b) super.setRepeatedField(fieldDescriptor, i10, obj);
            }

            /* renamed from: K */
            public final b setUnknownFields(a1 a1Var) {
                return (b) super.setUnknownFields(a1Var);
            }

            public b L(boolean z10) {
                this.f12805b |= 32;
                this.f12811h = z10;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a, com.google.protobuf.g0
            public Descriptors.b getDescriptorForType() {
                return DescriptorProtos.A;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return DescriptorProtos.B.e(FieldOptions.class, b.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.d, com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.f0
            public final boolean isInitialized() {
                for (int i10 = 0; i10 < x(); i10++) {
                    if (!w(i10).isInitialized()) {
                        return false;
                    }
                }
                return i();
            }

            /* renamed from: n */
            public b b(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.addRepeatedField(fieldDescriptor, obj);
            }

            /* renamed from: o */
            public FieldOptions build() {
                FieldOptions p10 = buildPartial();
                if (p10.isInitialized()) {
                    return p10;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) p10);
            }

            /* renamed from: p */
            public FieldOptions buildPartial() {
                FieldOptions fieldOptions = new FieldOptions(this, (a) null);
                int i10 = this.f12805b;
                int i11 = 1;
                if ((i10 & 1) != 1) {
                    i11 = 0;
                }
                fieldOptions.ctype_ = this.f12806c;
                if ((i10 & 2) == 2) {
                    i11 |= 2;
                }
                fieldOptions.packed_ = this.f12807d;
                if ((i10 & 4) == 4) {
                    i11 |= 4;
                }
                fieldOptions.jstype_ = this.f12808e;
                if ((i10 & 8) == 8) {
                    i11 |= 8;
                }
                fieldOptions.lazy_ = this.f12809f;
                if ((i10 & 16) == 16) {
                    i11 |= 16;
                }
                fieldOptions.deprecated_ = this.f12810g;
                if ((i10 & 32) == 32) {
                    i11 |= 32;
                }
                fieldOptions.weak_ = this.f12811h;
                o0<UninterpretedOption, UninterpretedOption.b, s> o0Var = this.f12813j;
                if (o0Var == null) {
                    if ((this.f12805b & 64) == 64) {
                        this.f12812i = Collections.unmodifiableList(this.f12812i);
                        this.f12805b &= -65;
                    }
                    fieldOptions.uninterpretedOption_ = this.f12812i;
                } else {
                    fieldOptions.uninterpretedOption_ = o0Var.g();
                }
                fieldOptions.bitField0_ = i11;
                onBuilt();
                return fieldOptions;
            }

            /* renamed from: q */
            public b d() {
                super.clear();
                this.f12806c = 0;
                int i10 = this.f12805b & (-2);
                this.f12805b = i10;
                this.f12807d = false;
                int i11 = i10 & (-3);
                this.f12805b = i11;
                this.f12808e = 0;
                int i12 = i11 & (-5);
                this.f12805b = i12;
                this.f12809f = false;
                int i13 = i12 & (-9);
                this.f12805b = i13;
                this.f12810g = false;
                int i14 = i13 & (-17);
                this.f12805b = i14;
                this.f12811h = false;
                this.f12805b = i14 & (-33);
                o0<UninterpretedOption, UninterpretedOption.b, s> o0Var = this.f12813j;
                if (o0Var == null) {
                    this.f12812i = Collections.emptyList();
                    this.f12805b &= -65;
                } else {
                    o0Var.h();
                }
                return this;
            }

            /* renamed from: r */
            public b e(Descriptors.FieldDescriptor fieldDescriptor) {
                return (b) super.clearField(fieldDescriptor);
            }

            /* renamed from: s */
            public b clearOneof(Descriptors.h hVar) {
                return (b) super.clearOneof(hVar);
            }

            /* renamed from: t */
            public b f() {
                return (b) super.clone();
            }

            /* renamed from: v */
            public FieldOptions getDefaultInstanceForType() {
                return FieldOptions.getDefaultInstance();
            }

            public UninterpretedOption w(int i10) {
                o0<UninterpretedOption, UninterpretedOption.b, s> o0Var = this.f12813j;
                if (o0Var == null) {
                    return this.f12812i.get(i10);
                }
                return o0Var.o(i10);
            }

            public int x() {
                o0<UninterpretedOption, UninterpretedOption.b, s> o0Var = this.f12813j;
                if (o0Var == null) {
                    return this.f12812i.size();
                }
                return o0Var.n();
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x0021  */
            /* renamed from: z */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public b mergeFrom(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws IOException {
                Throwable th2;
                FieldOptions fieldOptions = null;
                try {
                    try {
                        FieldOptions parsePartialFrom = FieldOptions.PARSER.parsePartialFrom(iVar, qVar);
                        if (parsePartialFrom != null) {
                            A(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e10) {
                        fieldOptions = (FieldOptions) e10.getUnfinishedMessage();
                        try {
                            throw e10.unwrapIOException();
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (fieldOptions != null) {
                                A(fieldOptions);
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (fieldOptions != null) {
                    }
                    throw th2;
                }
            }

            /* synthetic */ b(GeneratedMessageV3.c cVar, a aVar) {
                this(cVar);
            }

            private b() {
                this.f12806c = 0;
                this.f12808e = 0;
                this.f12812i = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.f12806c = 0;
                this.f12808e = 0;
                this.f12812i = Collections.emptyList();
                maybeForceBuilderInitialization();
            }
        }

        /* synthetic */ FieldOptions(com.google.protobuf.i iVar, com.google.protobuf.q qVar, a aVar) throws InvalidProtocolBufferException {
            this(iVar, qVar);
        }

        public static FieldOptions getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return DescriptorProtos.A;
        }

        public static b newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static FieldOptions parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (FieldOptions) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static FieldOptions parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static l0<FieldOptions> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof FieldOptions)) {
                return super.equals(obj);
            }
            FieldOptions fieldOptions = (FieldOptions) obj;
            boolean z10 = hasCtype() == fieldOptions.hasCtype();
            if (hasCtype()) {
                z10 = z10 && this.ctype_ == fieldOptions.ctype_;
            }
            boolean z11 = z10 && hasPacked() == fieldOptions.hasPacked();
            if (hasPacked()) {
                z11 = z11 && getPacked() == fieldOptions.getPacked();
            }
            boolean z12 = z11 && hasJstype() == fieldOptions.hasJstype();
            if (hasJstype()) {
                z12 = z12 && this.jstype_ == fieldOptions.jstype_;
            }
            boolean z13 = z12 && hasLazy() == fieldOptions.hasLazy();
            if (hasLazy()) {
                z13 = z13 && getLazy() == fieldOptions.getLazy();
            }
            boolean z14 = z13 && hasDeprecated() == fieldOptions.hasDeprecated();
            if (hasDeprecated()) {
                z14 = z14 && getDeprecated() == fieldOptions.getDeprecated();
            }
            boolean z15 = z14 && hasWeak() == fieldOptions.hasWeak();
            if (hasWeak()) {
                z15 = z15 && getWeak() == fieldOptions.getWeak();
            }
            return ((z15 && getUninterpretedOptionList().equals(fieldOptions.getUninterpretedOptionList())) && this.unknownFields.equals(fieldOptions.unknownFields)) && d().equals(fieldOptions.d());
        }

        public CType getCtype() {
            CType valueOf = CType.valueOf(this.ctype_);
            return valueOf == null ? CType.STRING : valueOf;
        }

        public boolean getDeprecated() {
            return this.deprecated_;
        }

        public JSType getJstype() {
            JSType valueOf = JSType.valueOf(this.jstype_);
            return valueOf == null ? JSType.JS_NORMAL : valueOf;
        }

        public boolean getLazy() {
            return this.lazy_;
        }

        public boolean getPacked() {
            return this.packed_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public l0<FieldOptions> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
        public int getSerializedSize() {
            int i10 = this.memoizedSize;
            if (i10 != -1) {
                return i10;
            }
            int l10 = (this.bitField0_ & 1) == 1 ? CodedOutputStream.l(1, this.ctype_) + 0 : 0;
            if ((this.bitField0_ & 2) == 2) {
                l10 += CodedOutputStream.e(2, this.packed_);
            }
            if ((this.bitField0_ & 16) == 16) {
                l10 += CodedOutputStream.e(3, this.deprecated_);
            }
            if ((this.bitField0_ & 8) == 8) {
                l10 += CodedOutputStream.e(5, this.lazy_);
            }
            if ((this.bitField0_ & 4) == 4) {
                l10 += CodedOutputStream.l(6, this.jstype_);
            }
            if ((this.bitField0_ & 32) == 32) {
                l10 += CodedOutputStream.e(10, this.weak_);
            }
            for (int i11 = 0; i11 < this.uninterpretedOption_.size(); i11++) {
                l10 += CodedOutputStream.E(999, this.uninterpretedOption_.get(i11));
            }
            int c10 = l10 + c() + this.unknownFields.getSerializedSize();
            this.memoizedSize = c10;
            return c10;
        }

        public UninterpretedOption getUninterpretedOption(int i10) {
            return this.uninterpretedOption_.get(i10);
        }

        public int getUninterpretedOptionCount() {
            return this.uninterpretedOption_.size();
        }

        public List<UninterpretedOption> getUninterpretedOptionList() {
            return this.uninterpretedOption_;
        }

        public s getUninterpretedOptionOrBuilder(int i10) {
            return this.uninterpretedOption_.get(i10);
        }

        public List<? extends s> getUninterpretedOptionOrBuilderList() {
            return this.uninterpretedOption_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.g0
        public final a1 getUnknownFields() {
            return this.unknownFields;
        }

        public boolean getWeak() {
            return this.weak_;
        }

        public boolean hasCtype() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasDeprecated() {
            return (this.bitField0_ & 16) == 16;
        }

        public boolean hasJstype() {
            return (this.bitField0_ & 4) == 4;
        }

        public boolean hasLazy() {
            return (this.bitField0_ & 8) == 8;
        }

        public boolean hasPacked() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean hasWeak() {
            return (this.bitField0_ & 32) == 32;
        }

        @Override // com.google.protobuf.a
        public int hashCode() {
            int i10 = this.memoizedHashCode;
            if (i10 != 0) {
                return i10;
            }
            int hashCode = 779 + getDescriptorForType().hashCode();
            if (hasCtype()) {
                hashCode = (((hashCode * 37) + 1) * 53) + this.ctype_;
            }
            if (hasPacked()) {
                hashCode = (((hashCode * 37) + 2) * 53) + u.c(getPacked());
            }
            if (hasJstype()) {
                hashCode = (((hashCode * 37) + 6) * 53) + this.jstype_;
            }
            if (hasLazy()) {
                hashCode = (((hashCode * 37) + 5) * 53) + u.c(getLazy());
            }
            if (hasDeprecated()) {
                hashCode = (((hashCode * 37) + 3) * 53) + u.c(getDeprecated());
            }
            if (hasWeak()) {
                hashCode = (((hashCode * 37) + 10) * 53) + u.c(getWeak());
            }
            if (getUninterpretedOptionCount() > 0) {
                hashCode = (((hashCode * 37) + 999) * 53) + getUninterpretedOptionList().hashCode();
            }
            int hashFields = (com.google.protobuf.a.hashFields(hashCode, d()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashFields;
            return hashFields;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return DescriptorProtos.B.e(FieldOptions.class, b.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessage, com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.f0
        public final boolean isInitialized() {
            byte b10 = this.memoizedIsInitialized;
            if (b10 == 1) {
                return true;
            }
            if (b10 == 0) {
                return false;
            }
            for (int i10 = 0; i10 < getUninterpretedOptionCount(); i10++) {
                if (!getUninterpretedOption(i10).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (!b()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: s */
        public b newBuilderForType(GeneratedMessageV3.c cVar) {
            return new b(cVar, null);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            GeneratedMessageV3.ExtendableMessage<MessageType>.a g10 = g();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.m0(1, this.ctype_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.e0(2, this.packed_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.e0(3, this.deprecated_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.e0(5, this.lazy_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.m0(6, this.jstype_);
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.e0(10, this.weak_);
            }
            for (int i10 = 0; i10 < this.uninterpretedOption_.size(); i10++) {
                codedOutputStream.A0(999, this.uninterpretedOption_.get(i10));
            }
            g10.a(536870912, codedOutputStream);
            this.unknownFields.writeTo(codedOutputStream);
        }

        /* synthetic */ FieldOptions(GeneratedMessageV3.d dVar, a aVar) {
            this(dVar);
        }

        public static b newBuilder(FieldOptions fieldOptions) {
            return DEFAULT_INSTANCE.toBuilder().A(fieldOptions);
        }

        public static FieldOptions parseFrom(ByteString byteString, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, qVar);
        }

        private FieldOptions(GeneratedMessageV3.d<FieldOptions, ?> dVar) {
            super(dVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static FieldOptions parseDelimitedFrom(InputStream inputStream, com.google.protobuf.q qVar) throws IOException {
            return (FieldOptions) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
        }

        public static FieldOptions parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessage, com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
        public FieldOptions getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessage, com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b toBuilder() {
            return this == DEFAULT_INSTANCE ? new b((a) null) : new b((a) null).A(this);
        }

        public static FieldOptions parseFrom(byte[] bArr, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessage, com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b newBuilderForType() {
            return newBuilder();
        }

        private FieldOptions() {
            this.memoizedIsInitialized = (byte) -1;
            this.ctype_ = 0;
            this.packed_ = false;
            this.jstype_ = 0;
            this.lazy_ = false;
            this.deprecated_ = false;
            this.weak_ = false;
            this.uninterpretedOption_ = Collections.emptyList();
        }

        public static FieldOptions parseFrom(InputStream inputStream) throws IOException {
            return (FieldOptions) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static FieldOptions parseFrom(InputStream inputStream, com.google.protobuf.q qVar) throws IOException {
            return (FieldOptions) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
        }

        public static FieldOptions parseFrom(com.google.protobuf.i iVar) throws IOException {
            return (FieldOptions) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
        }

        public static FieldOptions parseFrom(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws IOException {
            return (FieldOptions) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private FieldOptions(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
            this();
            a1.b g10 = a1.g();
            boolean z10 = false;
            boolean z11 = false;
            while (true) {
                if (z10) {
                    break;
                }
                try {
                    try {
                        int F = iVar.F();
                        if (F != 0) {
                            if (F == 8) {
                                int o10 = iVar.o();
                                if (CType.valueOf(o10) == null) {
                                    g10.q(1, o10);
                                } else {
                                    this.bitField0_ = 1 | this.bitField0_;
                                    this.ctype_ = o10;
                                }
                            } else if (F == 16) {
                                this.bitField0_ |= 2;
                                this.packed_ = iVar.l();
                            } else if (F == 24) {
                                this.bitField0_ |= 16;
                                this.deprecated_ = iVar.l();
                            } else if (F == 40) {
                                this.bitField0_ |= 8;
                                this.lazy_ = iVar.l();
                            } else if (F == 48) {
                                int o11 = iVar.o();
                                if (JSType.valueOf(o11) == null) {
                                    g10.q(6, o11);
                                } else {
                                    this.bitField0_ |= 4;
                                    this.jstype_ = o11;
                                }
                            } else if (F == 80) {
                                this.bitField0_ |= 32;
                                this.weak_ = iVar.l();
                            } else if (F == 7994) {
                                if (!(z11 & true)) {
                                    this.uninterpretedOption_ = new ArrayList();
                                    z11 |= true;
                                }
                                this.uninterpretedOption_.add(iVar.v(UninterpretedOption.PARSER, qVar));
                            } else if (!parseUnknownField(iVar, g10, qVar, F)) {
                            }
                        }
                        z10 = true;
                    } catch (InvalidProtocolBufferException e10) {
                        throw e10.setUnfinishedMessage(this);
                    } catch (IOException e11) {
                        throw new InvalidProtocolBufferException(e11).setUnfinishedMessage(this);
                    }
                } finally {
                    if (z11 & true) {
                        this.uninterpretedOption_ = Collections.unmodifiableList(this.uninterpretedOption_);
                    }
                    this.unknownFields = g10.build();
                    makeExtensionsImmutable();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class FileDescriptorProto extends GeneratedMessageV3 implements i {
        public static final int DEPENDENCY_FIELD_NUMBER = 3;
        public static final int ENUM_TYPE_FIELD_NUMBER = 5;
        public static final int EXTENSION_FIELD_NUMBER = 7;
        public static final int MESSAGE_TYPE_FIELD_NUMBER = 4;
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int OPTIONS_FIELD_NUMBER = 8;
        public static final int PACKAGE_FIELD_NUMBER = 2;
        public static final int PUBLIC_DEPENDENCY_FIELD_NUMBER = 10;
        public static final int SERVICE_FIELD_NUMBER = 6;
        public static final int SOURCE_CODE_INFO_FIELD_NUMBER = 9;
        public static final int SYNTAX_FIELD_NUMBER = 12;
        public static final int WEAK_DEPENDENCY_FIELD_NUMBER = 11;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private y dependency_;
        private List<EnumDescriptorProto> enumType_;
        private List<FieldDescriptorProto> extension_;
        private byte memoizedIsInitialized;
        private List<DescriptorProto> messageType_;
        private volatile Object name_;
        private FileOptions options_;
        private volatile Object package_;
        private List<Integer> publicDependency_;
        private List<ServiceDescriptorProto> service_;
        private SourceCodeInfo sourceCodeInfo_;
        private volatile Object syntax_;
        private List<Integer> weakDependency_;
        private static final FileDescriptorProto DEFAULT_INSTANCE = new FileDescriptorProto();
        @Deprecated
        public static final l0<FileDescriptorProto> PARSER = new a();

        /* loaded from: classes.dex */
        static class a extends com.google.protobuf.c<FileDescriptorProto> {
            a() {
            }

            /* renamed from: a */
            public FileDescriptorProto parsePartialFrom(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
                return new FileDescriptorProto(iVar, qVar, null);
            }
        }

        /* loaded from: classes.dex */
        public static final class b extends GeneratedMessageV3.b<b> implements i {

            /* renamed from: a  reason: collision with root package name */
            private int f12814a;

            /* renamed from: b  reason: collision with root package name */
            private Object f12815b;

            /* renamed from: c  reason: collision with root package name */
            private Object f12816c;

            /* renamed from: d  reason: collision with root package name */
            private y f12817d;

            /* renamed from: e  reason: collision with root package name */
            private List<Integer> f12818e;

            /* renamed from: f  reason: collision with root package name */
            private List<Integer> f12819f;

            /* renamed from: g  reason: collision with root package name */
            private List<DescriptorProto> f12820g;

            /* renamed from: h  reason: collision with root package name */
            private o0<DescriptorProto, DescriptorProto.b, b> f12821h;

            /* renamed from: i  reason: collision with root package name */
            private List<EnumDescriptorProto> f12822i;

            /* renamed from: j  reason: collision with root package name */
            private o0<EnumDescriptorProto, EnumDescriptorProto.b, c> f12823j;

            /* renamed from: k  reason: collision with root package name */
            private List<ServiceDescriptorProto> f12824k;

            /* renamed from: l  reason: collision with root package name */
            private o0<ServiceDescriptorProto, ServiceDescriptorProto.b, p> f12825l;

            /* renamed from: m  reason: collision with root package name */
            private List<FieldDescriptorProto> f12826m;

            /* renamed from: n  reason: collision with root package name */
            private o0<FieldDescriptorProto, FieldDescriptorProto.b, g> f12827n;

            /* renamed from: o  reason: collision with root package name */
            private FileOptions f12828o;

            /* renamed from: p  reason: collision with root package name */
            private q0<FileOptions, FileOptions.b, j> f12829p;

            /* renamed from: q  reason: collision with root package name */
            private SourceCodeInfo f12830q;

            /* renamed from: r  reason: collision with root package name */
            private q0<SourceCodeInfo, SourceCodeInfo.b, r> f12831r;

            /* renamed from: s  reason: collision with root package name */
            private Object f12832s;

            /* synthetic */ b(a aVar) {
                this();
            }

            private q0<FileOptions, FileOptions.b, j> B() {
                if (this.f12829p == null) {
                    this.f12829p = new q0<>(A(), getParentForChildren(), isClean());
                    this.f12828o = null;
                }
                return this.f12829p;
            }

            private o0<ServiceDescriptorProto, ServiceDescriptorProto.b, p> E() {
                if (this.f12825l == null) {
                    this.f12825l = new o0<>(this.f12824k, (this.f12814a & 128) == 128, getParentForChildren(), isClean());
                    this.f12824k = null;
                }
                return this.f12825l;
            }

            private q0<SourceCodeInfo, SourceCodeInfo.b, r> G() {
                if (this.f12831r == null) {
                    this.f12831r = new q0<>(F(), getParentForChildren(), isClean());
                    this.f12830q = null;
                }
                return this.f12831r;
            }

            private void j() {
                if ((this.f12814a & 4) != 4) {
                    this.f12817d = new x(this.f12817d);
                    this.f12814a |= 4;
                }
            }

            private void k() {
                if ((this.f12814a & 64) != 64) {
                    this.f12822i = new ArrayList(this.f12822i);
                    this.f12814a |= 64;
                }
            }

            private void l() {
                if ((this.f12814a & 256) != 256) {
                    this.f12826m = new ArrayList(this.f12826m);
                    this.f12814a |= 256;
                }
            }

            private void m() {
                if ((this.f12814a & 32) != 32) {
                    this.f12820g = new ArrayList(this.f12820g);
                    this.f12814a |= 32;
                }
            }

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                    z();
                    t();
                    E();
                    w();
                    B();
                    G();
                }
            }

            private void n() {
                if ((this.f12814a & 8) != 8) {
                    this.f12818e = new ArrayList(this.f12818e);
                    this.f12814a |= 8;
                }
            }

            private void o() {
                if ((this.f12814a & 128) != 128) {
                    this.f12824k = new ArrayList(this.f12824k);
                    this.f12814a |= 128;
                }
            }

            private void p() {
                if ((this.f12814a & 16) != 16) {
                    this.f12819f = new ArrayList(this.f12819f);
                    this.f12814a |= 16;
                }
            }

            private o0<EnumDescriptorProto, EnumDescriptorProto.b, c> t() {
                if (this.f12823j == null) {
                    this.f12823j = new o0<>(this.f12822i, (this.f12814a & 64) == 64, getParentForChildren(), isClean());
                    this.f12822i = null;
                }
                return this.f12823j;
            }

            private o0<FieldDescriptorProto, FieldDescriptorProto.b, g> w() {
                if (this.f12827n == null) {
                    this.f12827n = new o0<>(this.f12826m, (this.f12814a & 256) == 256, getParentForChildren(), isClean());
                    this.f12826m = null;
                }
                return this.f12827n;
            }

            private o0<DescriptorProto, DescriptorProto.b, b> z() {
                if (this.f12821h == null) {
                    this.f12821h = new o0<>(this.f12820g, (this.f12814a & 32) == 32, getParentForChildren(), isClean());
                    this.f12820g = null;
                }
                return this.f12821h;
            }

            public FileOptions A() {
                q0<FileOptions, FileOptions.b, j> q0Var = this.f12829p;
                if (q0Var != null) {
                    return q0Var.f();
                }
                FileOptions fileOptions = this.f12828o;
                return fileOptions == null ? FileOptions.getDefaultInstance() : fileOptions;
            }

            public ServiceDescriptorProto C(int i10) {
                o0<ServiceDescriptorProto, ServiceDescriptorProto.b, p> o0Var = this.f12825l;
                if (o0Var == null) {
                    return this.f12824k.get(i10);
                }
                return o0Var.o(i10);
            }

            public int D() {
                o0<ServiceDescriptorProto, ServiceDescriptorProto.b, p> o0Var = this.f12825l;
                if (o0Var == null) {
                    return this.f12824k.size();
                }
                return o0Var.n();
            }

            public SourceCodeInfo F() {
                q0<SourceCodeInfo, SourceCodeInfo.b, r> q0Var = this.f12831r;
                if (q0Var != null) {
                    return q0Var.f();
                }
                SourceCodeInfo sourceCodeInfo = this.f12830q;
                return sourceCodeInfo == null ? SourceCodeInfo.getDefaultInstance() : sourceCodeInfo;
            }

            public boolean H() {
                return (this.f12814a & 512) == 512;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x0021  */
            /* renamed from: I */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public b mergeFrom(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws IOException {
                Throwable th2;
                FileDescriptorProto fileDescriptorProto = null;
                try {
                    try {
                        FileDescriptorProto parsePartialFrom = FileDescriptorProto.PARSER.parsePartialFrom(iVar, qVar);
                        if (parsePartialFrom != null) {
                            J(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e10) {
                        fileDescriptorProto = (FileDescriptorProto) e10.getUnfinishedMessage();
                        try {
                            throw e10.unwrapIOException();
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (fileDescriptorProto != null) {
                                J(fileDescriptorProto);
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (fileDescriptorProto != null) {
                    }
                    throw th2;
                }
            }

            public b J(FileDescriptorProto fileDescriptorProto) {
                if (fileDescriptorProto == FileDescriptorProto.getDefaultInstance()) {
                    return this;
                }
                if (fileDescriptorProto.hasName()) {
                    this.f12814a |= 1;
                    this.f12815b = fileDescriptorProto.name_;
                    onChanged();
                }
                if (fileDescriptorProto.hasPackage()) {
                    this.f12814a |= 2;
                    this.f12816c = fileDescriptorProto.package_;
                    onChanged();
                }
                if (!fileDescriptorProto.dependency_.isEmpty()) {
                    if (this.f12817d.isEmpty()) {
                        this.f12817d = fileDescriptorProto.dependency_;
                        this.f12814a &= -5;
                    } else {
                        j();
                        this.f12817d.addAll(fileDescriptorProto.dependency_);
                    }
                    onChanged();
                }
                if (!fileDescriptorProto.publicDependency_.isEmpty()) {
                    if (this.f12818e.isEmpty()) {
                        this.f12818e = fileDescriptorProto.publicDependency_;
                        this.f12814a &= -9;
                    } else {
                        n();
                        this.f12818e.addAll(fileDescriptorProto.publicDependency_);
                    }
                    onChanged();
                }
                if (!fileDescriptorProto.weakDependency_.isEmpty()) {
                    if (this.f12819f.isEmpty()) {
                        this.f12819f = fileDescriptorProto.weakDependency_;
                        this.f12814a &= -17;
                    } else {
                        p();
                        this.f12819f.addAll(fileDescriptorProto.weakDependency_);
                    }
                    onChanged();
                }
                o0<FieldDescriptorProto, FieldDescriptorProto.b, g> o0Var = null;
                if (this.f12821h == null) {
                    if (!fileDescriptorProto.messageType_.isEmpty()) {
                        if (this.f12820g.isEmpty()) {
                            this.f12820g = fileDescriptorProto.messageType_;
                            this.f12814a &= -33;
                        } else {
                            m();
                            this.f12820g.addAll(fileDescriptorProto.messageType_);
                        }
                        onChanged();
                    }
                } else if (!fileDescriptorProto.messageType_.isEmpty()) {
                    if (this.f12821h.u()) {
                        this.f12821h.i();
                        this.f12821h = null;
                        this.f12820g = fileDescriptorProto.messageType_;
                        this.f12814a &= -33;
                        this.f12821h = GeneratedMessageV3.alwaysUseFieldBuilders ? z() : null;
                    } else {
                        this.f12821h.b(fileDescriptorProto.messageType_);
                    }
                }
                if (this.f12823j == null) {
                    if (!fileDescriptorProto.enumType_.isEmpty()) {
                        if (this.f12822i.isEmpty()) {
                            this.f12822i = fileDescriptorProto.enumType_;
                            this.f12814a &= -65;
                        } else {
                            k();
                            this.f12822i.addAll(fileDescriptorProto.enumType_);
                        }
                        onChanged();
                    }
                } else if (!fileDescriptorProto.enumType_.isEmpty()) {
                    if (this.f12823j.u()) {
                        this.f12823j.i();
                        this.f12823j = null;
                        this.f12822i = fileDescriptorProto.enumType_;
                        this.f12814a &= -65;
                        this.f12823j = GeneratedMessageV3.alwaysUseFieldBuilders ? t() : null;
                    } else {
                        this.f12823j.b(fileDescriptorProto.enumType_);
                    }
                }
                if (this.f12825l == null) {
                    if (!fileDescriptorProto.service_.isEmpty()) {
                        if (this.f12824k.isEmpty()) {
                            this.f12824k = fileDescriptorProto.service_;
                            this.f12814a &= -129;
                        } else {
                            o();
                            this.f12824k.addAll(fileDescriptorProto.service_);
                        }
                        onChanged();
                    }
                } else if (!fileDescriptorProto.service_.isEmpty()) {
                    if (this.f12825l.u()) {
                        this.f12825l.i();
                        this.f12825l = null;
                        this.f12824k = fileDescriptorProto.service_;
                        this.f12814a &= -129;
                        this.f12825l = GeneratedMessageV3.alwaysUseFieldBuilders ? E() : null;
                    } else {
                        this.f12825l.b(fileDescriptorProto.service_);
                    }
                }
                if (this.f12827n == null) {
                    if (!fileDescriptorProto.extension_.isEmpty()) {
                        if (this.f12826m.isEmpty()) {
                            this.f12826m = fileDescriptorProto.extension_;
                            this.f12814a &= -257;
                        } else {
                            l();
                            this.f12826m.addAll(fileDescriptorProto.extension_);
                        }
                        onChanged();
                    }
                } else if (!fileDescriptorProto.extension_.isEmpty()) {
                    if (this.f12827n.u()) {
                        this.f12827n.i();
                        this.f12827n = null;
                        this.f12826m = fileDescriptorProto.extension_;
                        this.f12814a &= -257;
                        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                            o0Var = w();
                        }
                        this.f12827n = o0Var;
                    } else {
                        this.f12827n.b(fileDescriptorProto.extension_);
                    }
                }
                if (fileDescriptorProto.hasOptions()) {
                    L(fileDescriptorProto.getOptions());
                }
                if (fileDescriptorProto.hasSourceCodeInfo()) {
                    M(fileDescriptorProto.getSourceCodeInfo());
                }
                if (fileDescriptorProto.hasSyntax()) {
                    this.f12814a |= 2048;
                    this.f12832s = fileDescriptorProto.syntax_;
                    onChanged();
                }
                mergeUnknownFields(fileDescriptorProto.unknownFields);
                onChanged();
                return this;
            }

            /* renamed from: K */
            public b mergeFrom(d0 d0Var) {
                if (d0Var instanceof FileDescriptorProto) {
                    return J((FileDescriptorProto) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            public b L(FileOptions fileOptions) {
                FileOptions fileOptions2;
                q0<FileOptions, FileOptions.b, j> q0Var = this.f12829p;
                if (q0Var == null) {
                    if ((this.f12814a & 512) != 512 || (fileOptions2 = this.f12828o) == null || fileOptions2 == FileOptions.getDefaultInstance()) {
                        this.f12828o = fileOptions;
                    } else {
                        this.f12828o = FileOptions.newBuilder(this.f12828o).A(fileOptions).buildPartial();
                    }
                    onChanged();
                } else {
                    q0Var.h(fileOptions);
                }
                this.f12814a |= 512;
                return this;
            }

            public b M(SourceCodeInfo sourceCodeInfo) {
                SourceCodeInfo sourceCodeInfo2;
                q0<SourceCodeInfo, SourceCodeInfo.b, r> q0Var = this.f12831r;
                if (q0Var == null) {
                    if ((this.f12814a & 1024) != 1024 || (sourceCodeInfo2 = this.f12830q) == null || sourceCodeInfo2 == SourceCodeInfo.getDefaultInstance()) {
                        this.f12830q = sourceCodeInfo;
                    } else {
                        this.f12830q = SourceCodeInfo.newBuilder(this.f12830q).m(sourceCodeInfo).buildPartial();
                    }
                    onChanged();
                } else {
                    q0Var.h(sourceCodeInfo);
                }
                this.f12814a |= 1024;
                return this;
            }

            /* renamed from: N */
            public final b mergeUnknownFields(a1 a1Var) {
                return (b) super.mergeUnknownFields(a1Var);
            }

            /* renamed from: O */
            public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.setField(fieldDescriptor, obj);
            }

            public b P(String str) {
                Objects.requireNonNull(str);
                this.f12814a |= 1;
                this.f12815b = str;
                onChanged();
                return this;
            }

            public b Q(String str) {
                Objects.requireNonNull(str);
                this.f12814a |= 2;
                this.f12816c = str;
                onChanged();
                return this;
            }

            /* renamed from: R */
            public b setRepeatedField2(Descriptors.FieldDescriptor fieldDescriptor, int i10, Object obj) {
                return (b) super.setRepeatedField(fieldDescriptor, i10, obj);
            }

            /* renamed from: S */
            public final b setUnknownFields(a1 a1Var) {
                return (b) super.setUnknownFields(a1Var);
            }

            public b a(DescriptorProto descriptorProto) {
                o0<DescriptorProto, DescriptorProto.b, b> o0Var = this.f12821h;
                if (o0Var == null) {
                    Objects.requireNonNull(descriptorProto);
                    m();
                    this.f12820g.add(descriptorProto);
                    onChanged();
                } else {
                    o0Var.f(descriptorProto);
                }
                return this;
            }

            /* renamed from: b */
            public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.addRepeatedField(fieldDescriptor, obj);
            }

            /* renamed from: c */
            public FileDescriptorProto build() {
                FileDescriptorProto d10 = buildPartial();
                if (d10.isInitialized()) {
                    return d10;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) d10);
            }

            /* renamed from: d */
            public FileDescriptorProto buildPartial() {
                FileDescriptorProto fileDescriptorProto = new FileDescriptorProto(this, (a) null);
                int i10 = this.f12814a;
                int i11 = 1;
                if ((i10 & 1) != 1) {
                    i11 = 0;
                }
                fileDescriptorProto.name_ = this.f12815b;
                if ((i10 & 2) == 2) {
                    i11 |= 2;
                }
                fileDescriptorProto.package_ = this.f12816c;
                if ((this.f12814a & 4) == 4) {
                    this.f12817d = this.f12817d.u0();
                    this.f12814a &= -5;
                }
                fileDescriptorProto.dependency_ = this.f12817d;
                if ((this.f12814a & 8) == 8) {
                    this.f12818e = Collections.unmodifiableList(this.f12818e);
                    this.f12814a &= -9;
                }
                fileDescriptorProto.publicDependency_ = this.f12818e;
                if ((this.f12814a & 16) == 16) {
                    this.f12819f = Collections.unmodifiableList(this.f12819f);
                    this.f12814a &= -17;
                }
                fileDescriptorProto.weakDependency_ = this.f12819f;
                o0<DescriptorProto, DescriptorProto.b, b> o0Var = this.f12821h;
                if (o0Var == null) {
                    if ((this.f12814a & 32) == 32) {
                        this.f12820g = Collections.unmodifiableList(this.f12820g);
                        this.f12814a &= -33;
                    }
                    fileDescriptorProto.messageType_ = this.f12820g;
                } else {
                    fileDescriptorProto.messageType_ = o0Var.g();
                }
                o0<EnumDescriptorProto, EnumDescriptorProto.b, c> o0Var2 = this.f12823j;
                if (o0Var2 == null) {
                    if ((this.f12814a & 64) == 64) {
                        this.f12822i = Collections.unmodifiableList(this.f12822i);
                        this.f12814a &= -65;
                    }
                    fileDescriptorProto.enumType_ = this.f12822i;
                } else {
                    fileDescriptorProto.enumType_ = o0Var2.g();
                }
                o0<ServiceDescriptorProto, ServiceDescriptorProto.b, p> o0Var3 = this.f12825l;
                if (o0Var3 == null) {
                    if ((this.f12814a & 128) == 128) {
                        this.f12824k = Collections.unmodifiableList(this.f12824k);
                        this.f12814a &= -129;
                    }
                    fileDescriptorProto.service_ = this.f12824k;
                } else {
                    fileDescriptorProto.service_ = o0Var3.g();
                }
                o0<FieldDescriptorProto, FieldDescriptorProto.b, g> o0Var4 = this.f12827n;
                if (o0Var4 == null) {
                    if ((this.f12814a & 256) == 256) {
                        this.f12826m = Collections.unmodifiableList(this.f12826m);
                        this.f12814a &= -257;
                    }
                    fileDescriptorProto.extension_ = this.f12826m;
                } else {
                    fileDescriptorProto.extension_ = o0Var4.g();
                }
                if ((i10 & 512) == 512) {
                    i11 |= 4;
                }
                q0<FileOptions, FileOptions.b, j> q0Var = this.f12829p;
                if (q0Var == null) {
                    fileDescriptorProto.options_ = this.f12828o;
                } else {
                    fileDescriptorProto.options_ = q0Var.b();
                }
                if ((i10 & 1024) == 1024) {
                    i11 |= 8;
                }
                q0<SourceCodeInfo, SourceCodeInfo.b, r> q0Var2 = this.f12831r;
                if (q0Var2 == null) {
                    fileDescriptorProto.sourceCodeInfo_ = this.f12830q;
                } else {
                    fileDescriptorProto.sourceCodeInfo_ = q0Var2.b();
                }
                if ((i10 & 2048) == 2048) {
                    i11 |= 16;
                }
                fileDescriptorProto.syntax_ = this.f12832s;
                fileDescriptorProto.bitField0_ = i11;
                onBuilt();
                return fileDescriptorProto;
            }

            /* renamed from: e */
            public b clear() {
                super.clear();
                this.f12815b = "";
                int i10 = this.f12814a & (-2);
                this.f12814a = i10;
                this.f12816c = "";
                int i11 = i10 & (-3);
                this.f12814a = i11;
                this.f12817d = x.f13385d;
                this.f12814a = i11 & (-5);
                this.f12818e = Collections.emptyList();
                this.f12814a &= -9;
                this.f12819f = Collections.emptyList();
                this.f12814a &= -17;
                o0<DescriptorProto, DescriptorProto.b, b> o0Var = this.f12821h;
                if (o0Var == null) {
                    this.f12820g = Collections.emptyList();
                    this.f12814a &= -33;
                } else {
                    o0Var.h();
                }
                o0<EnumDescriptorProto, EnumDescriptorProto.b, c> o0Var2 = this.f12823j;
                if (o0Var2 == null) {
                    this.f12822i = Collections.emptyList();
                    this.f12814a &= -65;
                } else {
                    o0Var2.h();
                }
                o0<ServiceDescriptorProto, ServiceDescriptorProto.b, p> o0Var3 = this.f12825l;
                if (o0Var3 == null) {
                    this.f12824k = Collections.emptyList();
                    this.f12814a &= -129;
                } else {
                    o0Var3.h();
                }
                o0<FieldDescriptorProto, FieldDescriptorProto.b, g> o0Var4 = this.f12827n;
                if (o0Var4 == null) {
                    this.f12826m = Collections.emptyList();
                    this.f12814a &= -257;
                } else {
                    o0Var4.h();
                }
                q0<FileOptions, FileOptions.b, j> q0Var = this.f12829p;
                if (q0Var == null) {
                    this.f12828o = null;
                } else {
                    q0Var.c();
                }
                this.f12814a &= -513;
                q0<SourceCodeInfo, SourceCodeInfo.b, r> q0Var2 = this.f12831r;
                if (q0Var2 == null) {
                    this.f12830q = null;
                } else {
                    q0Var2.c();
                }
                int i12 = this.f12814a & (-1025);
                this.f12814a = i12;
                this.f12832s = "";
                this.f12814a = i12 & (-2049);
                return this;
            }

            /* renamed from: f */
            public b clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (b) super.clearField(fieldDescriptor);
            }

            /* renamed from: g */
            public b clearOneof(Descriptors.h hVar) {
                return (b) super.clearOneof(hVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a, com.google.protobuf.g0
            public Descriptors.b getDescriptorForType() {
                return DescriptorProtos.f12724c;
            }

            /* renamed from: i */
            public b clone() {
                return (b) super.clone();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return DescriptorProtos.f12725d.e(FileDescriptorProto.class, b.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.f0
            public final boolean isInitialized() {
                for (int i10 = 0; i10 < y(); i10++) {
                    if (!x(i10).isInitialized()) {
                        return false;
                    }
                }
                for (int i11 = 0; i11 < s(); i11++) {
                    if (!r(i11).isInitialized()) {
                        return false;
                    }
                }
                for (int i12 = 0; i12 < D(); i12++) {
                    if (!C(i12).isInitialized()) {
                        return false;
                    }
                }
                for (int i13 = 0; i13 < v(); i13++) {
                    if (!u(i13).isInitialized()) {
                        return false;
                    }
                }
                return !H() || A().isInitialized();
            }

            /* renamed from: q */
            public FileDescriptorProto getDefaultInstanceForType() {
                return FileDescriptorProto.getDefaultInstance();
            }

            public EnumDescriptorProto r(int i10) {
                o0<EnumDescriptorProto, EnumDescriptorProto.b, c> o0Var = this.f12823j;
                if (o0Var == null) {
                    return this.f12822i.get(i10);
                }
                return o0Var.o(i10);
            }

            public int s() {
                o0<EnumDescriptorProto, EnumDescriptorProto.b, c> o0Var = this.f12823j;
                if (o0Var == null) {
                    return this.f12822i.size();
                }
                return o0Var.n();
            }

            public FieldDescriptorProto u(int i10) {
                o0<FieldDescriptorProto, FieldDescriptorProto.b, g> o0Var = this.f12827n;
                if (o0Var == null) {
                    return this.f12826m.get(i10);
                }
                return o0Var.o(i10);
            }

            public int v() {
                o0<FieldDescriptorProto, FieldDescriptorProto.b, g> o0Var = this.f12827n;
                if (o0Var == null) {
                    return this.f12826m.size();
                }
                return o0Var.n();
            }

            public DescriptorProto x(int i10) {
                o0<DescriptorProto, DescriptorProto.b, b> o0Var = this.f12821h;
                if (o0Var == null) {
                    return this.f12820g.get(i10);
                }
                return o0Var.o(i10);
            }

            public int y() {
                o0<DescriptorProto, DescriptorProto.b, b> o0Var = this.f12821h;
                if (o0Var == null) {
                    return this.f12820g.size();
                }
                return o0Var.n();
            }

            /* synthetic */ b(GeneratedMessageV3.c cVar, a aVar) {
                this(cVar);
            }

            private b() {
                this.f12815b = "";
                this.f12816c = "";
                this.f12817d = x.f13385d;
                this.f12818e = Collections.emptyList();
                this.f12819f = Collections.emptyList();
                this.f12820g = Collections.emptyList();
                this.f12822i = Collections.emptyList();
                this.f12824k = Collections.emptyList();
                this.f12826m = Collections.emptyList();
                this.f12828o = null;
                this.f12830q = null;
                this.f12832s = "";
                maybeForceBuilderInitialization();
            }

            private b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.f12815b = "";
                this.f12816c = "";
                this.f12817d = x.f13385d;
                this.f12818e = Collections.emptyList();
                this.f12819f = Collections.emptyList();
                this.f12820g = Collections.emptyList();
                this.f12822i = Collections.emptyList();
                this.f12824k = Collections.emptyList();
                this.f12826m = Collections.emptyList();
                this.f12828o = null;
                this.f12830q = null;
                this.f12832s = "";
                maybeForceBuilderInitialization();
            }
        }

        /* synthetic */ FileDescriptorProto(com.google.protobuf.i iVar, com.google.protobuf.q qVar, a aVar) throws InvalidProtocolBufferException {
            this(iVar, qVar);
        }

        public static FileDescriptorProto getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return DescriptorProtos.f12724c;
        }

        public static b newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static FileDescriptorProto parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (FileDescriptorProto) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static FileDescriptorProto parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static l0<FileDescriptorProto> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof FileDescriptorProto)) {
                return super.equals(obj);
            }
            FileDescriptorProto fileDescriptorProto = (FileDescriptorProto) obj;
            boolean z10 = hasName() == fileDescriptorProto.hasName();
            if (hasName()) {
                z10 = z10 && getName().equals(fileDescriptorProto.getName());
            }
            boolean z11 = z10 && hasPackage() == fileDescriptorProto.hasPackage();
            if (hasPackage()) {
                z11 = z11 && getPackage().equals(fileDescriptorProto.getPackage());
            }
            boolean z12 = (((((((z11 && getDependencyList().equals(fileDescriptorProto.getDependencyList())) && getPublicDependencyList().equals(fileDescriptorProto.getPublicDependencyList())) && getWeakDependencyList().equals(fileDescriptorProto.getWeakDependencyList())) && getMessageTypeList().equals(fileDescriptorProto.getMessageTypeList())) && getEnumTypeList().equals(fileDescriptorProto.getEnumTypeList())) && getServiceList().equals(fileDescriptorProto.getServiceList())) && getExtensionList().equals(fileDescriptorProto.getExtensionList())) && hasOptions() == fileDescriptorProto.hasOptions();
            if (hasOptions()) {
                z12 = z12 && getOptions().equals(fileDescriptorProto.getOptions());
            }
            boolean z13 = z12 && hasSourceCodeInfo() == fileDescriptorProto.hasSourceCodeInfo();
            if (hasSourceCodeInfo()) {
                z13 = z13 && getSourceCodeInfo().equals(fileDescriptorProto.getSourceCodeInfo());
            }
            boolean z14 = z13 && hasSyntax() == fileDescriptorProto.hasSyntax();
            if (hasSyntax()) {
                z14 = z14 && getSyntax().equals(fileDescriptorProto.getSyntax());
            }
            return z14 && this.unknownFields.equals(fileDescriptorProto.unknownFields);
        }

        public String getDependency(int i10) {
            return this.dependency_.get(i10);
        }

        public ByteString getDependencyBytes(int i10) {
            return this.dependency_.o0(i10);
        }

        public int getDependencyCount() {
            return this.dependency_.size();
        }

        public EnumDescriptorProto getEnumType(int i10) {
            return this.enumType_.get(i10);
        }

        public int getEnumTypeCount() {
            return this.enumType_.size();
        }

        public List<EnumDescriptorProto> getEnumTypeList() {
            return this.enumType_;
        }

        public c getEnumTypeOrBuilder(int i10) {
            return this.enumType_.get(i10);
        }

        public List<? extends c> getEnumTypeOrBuilderList() {
            return this.enumType_;
        }

        public FieldDescriptorProto getExtension(int i10) {
            return this.extension_.get(i10);
        }

        public int getExtensionCount() {
            return this.extension_.size();
        }

        public List<FieldDescriptorProto> getExtensionList() {
            return this.extension_;
        }

        public g getExtensionOrBuilder(int i10) {
            return this.extension_.get(i10);
        }

        public List<? extends g> getExtensionOrBuilderList() {
            return this.extension_;
        }

        public DescriptorProto getMessageType(int i10) {
            return this.messageType_.get(i10);
        }

        public int getMessageTypeCount() {
            return this.messageType_.size();
        }

        public List<DescriptorProto> getMessageTypeList() {
            return this.messageType_;
        }

        public b getMessageTypeOrBuilder(int i10) {
            return this.messageType_.get(i10);
        }

        public List<? extends b> getMessageTypeOrBuilderList() {
            return this.messageType_;
        }

        public String getName() {
            Object obj = this.name_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.name_ = stringUtf8;
            }
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

        public FileOptions getOptions() {
            FileOptions fileOptions = this.options_;
            return fileOptions == null ? FileOptions.getDefaultInstance() : fileOptions;
        }

        public j getOptionsOrBuilder() {
            FileOptions fileOptions = this.options_;
            return fileOptions == null ? FileOptions.getDefaultInstance() : fileOptions;
        }

        public String getPackage() {
            Object obj = this.package_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.package_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getPackageBytes() {
            Object obj = this.package_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.package_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public l0<FileDescriptorProto> getParserForType() {
            return PARSER;
        }

        public int getPublicDependency(int i10) {
            return this.publicDependency_.get(i10).intValue();
        }

        public int getPublicDependencyCount() {
            return this.publicDependency_.size();
        }

        public List<Integer> getPublicDependencyList() {
            return this.publicDependency_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
        public int getSerializedSize() {
            int i10 = this.memoizedSize;
            if (i10 != -1) {
                return i10;
            }
            int computeStringSize = (this.bitField0_ & 1) == 1 ? GeneratedMessageV3.computeStringSize(1, this.name_) + 0 : 0;
            if ((this.bitField0_ & 2) == 2) {
                computeStringSize += GeneratedMessageV3.computeStringSize(2, this.package_);
            }
            int i11 = 0;
            for (int i12 = 0; i12 < this.dependency_.size(); i12++) {
                i11 += GeneratedMessageV3.computeStringSizeNoTag(this.dependency_.z0(i12));
            }
            int size = computeStringSize + i11 + (getDependencyList().size() * 1);
            for (int i13 = 0; i13 < this.messageType_.size(); i13++) {
                size += CodedOutputStream.E(4, this.messageType_.get(i13));
            }
            for (int i14 = 0; i14 < this.enumType_.size(); i14++) {
                size += CodedOutputStream.E(5, this.enumType_.get(i14));
            }
            for (int i15 = 0; i15 < this.service_.size(); i15++) {
                size += CodedOutputStream.E(6, this.service_.get(i15));
            }
            for (int i16 = 0; i16 < this.extension_.size(); i16++) {
                size += CodedOutputStream.E(7, this.extension_.get(i16));
            }
            if ((this.bitField0_ & 4) == 4) {
                size += CodedOutputStream.E(8, getOptions());
            }
            if ((this.bitField0_ & 8) == 8) {
                size += CodedOutputStream.E(9, getSourceCodeInfo());
            }
            int i17 = 0;
            for (int i18 = 0; i18 < this.publicDependency_.size(); i18++) {
                i17 += CodedOutputStream.w(this.publicDependency_.get(i18).intValue());
            }
            int size2 = size + i17 + (getPublicDependencyList().size() * 1);
            int i19 = 0;
            for (int i20 = 0; i20 < this.weakDependency_.size(); i20++) {
                i19 += CodedOutputStream.w(this.weakDependency_.get(i20).intValue());
            }
            int size3 = size2 + i19 + (getWeakDependencyList().size() * 1);
            if ((this.bitField0_ & 16) == 16) {
                size3 += GeneratedMessageV3.computeStringSize(12, this.syntax_);
            }
            int serializedSize = size3 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        public ServiceDescriptorProto getService(int i10) {
            return this.service_.get(i10);
        }

        public int getServiceCount() {
            return this.service_.size();
        }

        public List<ServiceDescriptorProto> getServiceList() {
            return this.service_;
        }

        public p getServiceOrBuilder(int i10) {
            return this.service_.get(i10);
        }

        public List<? extends p> getServiceOrBuilderList() {
            return this.service_;
        }

        public SourceCodeInfo getSourceCodeInfo() {
            SourceCodeInfo sourceCodeInfo = this.sourceCodeInfo_;
            return sourceCodeInfo == null ? SourceCodeInfo.getDefaultInstance() : sourceCodeInfo;
        }

        public r getSourceCodeInfoOrBuilder() {
            SourceCodeInfo sourceCodeInfo = this.sourceCodeInfo_;
            return sourceCodeInfo == null ? SourceCodeInfo.getDefaultInstance() : sourceCodeInfo;
        }

        public String getSyntax() {
            Object obj = this.syntax_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.syntax_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getSyntaxBytes() {
            Object obj = this.syntax_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.syntax_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.g0
        public final a1 getUnknownFields() {
            return this.unknownFields;
        }

        public int getWeakDependency(int i10) {
            return this.weakDependency_.get(i10).intValue();
        }

        public int getWeakDependencyCount() {
            return this.weakDependency_.size();
        }

        public List<Integer> getWeakDependencyList() {
            return this.weakDependency_;
        }

        public boolean hasName() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasOptions() {
            return (this.bitField0_ & 4) == 4;
        }

        public boolean hasPackage() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean hasSourceCodeInfo() {
            return (this.bitField0_ & 8) == 8;
        }

        public boolean hasSyntax() {
            return (this.bitField0_ & 16) == 16;
        }

        @Override // com.google.protobuf.a
        public int hashCode() {
            int i10 = this.memoizedHashCode;
            if (i10 != 0) {
                return i10;
            }
            int hashCode = 779 + getDescriptorForType().hashCode();
            if (hasName()) {
                hashCode = (((hashCode * 37) + 1) * 53) + getName().hashCode();
            }
            if (hasPackage()) {
                hashCode = (((hashCode * 37) + 2) * 53) + getPackage().hashCode();
            }
            if (getDependencyCount() > 0) {
                hashCode = (((hashCode * 37) + 3) * 53) + getDependencyList().hashCode();
            }
            if (getPublicDependencyCount() > 0) {
                hashCode = (((hashCode * 37) + 10) * 53) + getPublicDependencyList().hashCode();
            }
            if (getWeakDependencyCount() > 0) {
                hashCode = (((hashCode * 37) + 11) * 53) + getWeakDependencyList().hashCode();
            }
            if (getMessageTypeCount() > 0) {
                hashCode = (((hashCode * 37) + 4) * 53) + getMessageTypeList().hashCode();
            }
            if (getEnumTypeCount() > 0) {
                hashCode = (((hashCode * 37) + 5) * 53) + getEnumTypeList().hashCode();
            }
            if (getServiceCount() > 0) {
                hashCode = (((hashCode * 37) + 6) * 53) + getServiceList().hashCode();
            }
            if (getExtensionCount() > 0) {
                hashCode = (((hashCode * 37) + 7) * 53) + getExtensionList().hashCode();
            }
            if (hasOptions()) {
                hashCode = (((hashCode * 37) + 8) * 53) + getOptions().hashCode();
            }
            if (hasSourceCodeInfo()) {
                hashCode = (((hashCode * 37) + 9) * 53) + getSourceCodeInfo().hashCode();
            }
            if (hasSyntax()) {
                hashCode = (((hashCode * 37) + 12) * 53) + getSyntax().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return DescriptorProtos.f12725d.e(FileDescriptorProto.class, b.class);
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
            for (int i10 = 0; i10 < getMessageTypeCount(); i10++) {
                if (!getMessageType(i10).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            for (int i11 = 0; i11 < getEnumTypeCount(); i11++) {
                if (!getEnumType(i11).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            for (int i12 = 0; i12 < getServiceCount(); i12++) {
                if (!getService(i12).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            for (int i13 = 0; i13 < getExtensionCount(); i13++) {
                if (!getExtension(i13).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (!hasOptions() || getOptions().isInitialized()) {
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if ((this.bitField0_ & 1) == 1) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.name_);
            }
            if ((this.bitField0_ & 2) == 2) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.package_);
            }
            for (int i10 = 0; i10 < this.dependency_.size(); i10++) {
                GeneratedMessageV3.writeString(codedOutputStream, 3, this.dependency_.z0(i10));
            }
            for (int i11 = 0; i11 < this.messageType_.size(); i11++) {
                codedOutputStream.A0(4, this.messageType_.get(i11));
            }
            for (int i12 = 0; i12 < this.enumType_.size(); i12++) {
                codedOutputStream.A0(5, this.enumType_.get(i12));
            }
            for (int i13 = 0; i13 < this.service_.size(); i13++) {
                codedOutputStream.A0(6, this.service_.get(i13));
            }
            for (int i14 = 0; i14 < this.extension_.size(); i14++) {
                codedOutputStream.A0(7, this.extension_.get(i14));
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.A0(8, getOptions());
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.A0(9, getSourceCodeInfo());
            }
            for (int i15 = 0; i15 < this.publicDependency_.size(); i15++) {
                codedOutputStream.w0(10, this.publicDependency_.get(i15).intValue());
            }
            for (int i16 = 0; i16 < this.weakDependency_.size(); i16++) {
                codedOutputStream.w0(11, this.weakDependency_.get(i16).intValue());
            }
            if ((this.bitField0_ & 16) == 16) {
                GeneratedMessageV3.writeString(codedOutputStream, 12, this.syntax_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: z */
        public b newBuilderForType(GeneratedMessageV3.c cVar) {
            return new b(cVar, null);
        }

        /* synthetic */ FileDescriptorProto(GeneratedMessageV3.b bVar, a aVar) {
            this(bVar);
        }

        public static b newBuilder(FileDescriptorProto fileDescriptorProto) {
            return DEFAULT_INSTANCE.toBuilder().J(fileDescriptorProto);
        }

        public static FileDescriptorProto parseFrom(ByteString byteString, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, qVar);
        }

        public n0 getDependencyList() {
            return this.dependency_;
        }

        private FileDescriptorProto(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static FileDescriptorProto parseDelimitedFrom(InputStream inputStream, com.google.protobuf.q qVar) throws IOException {
            return (FileDescriptorProto) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
        }

        public static FileDescriptorProto parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
        public FileDescriptorProto getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b toBuilder() {
            return this == DEFAULT_INSTANCE ? new b((a) null) : new b((a) null).J(this);
        }

        public static FileDescriptorProto parseFrom(byte[] bArr, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b newBuilderForType() {
            return newBuilder();
        }

        private FileDescriptorProto() {
            this.memoizedIsInitialized = (byte) -1;
            this.name_ = "";
            this.package_ = "";
            this.dependency_ = x.f13385d;
            this.publicDependency_ = Collections.emptyList();
            this.weakDependency_ = Collections.emptyList();
            this.messageType_ = Collections.emptyList();
            this.enumType_ = Collections.emptyList();
            this.service_ = Collections.emptyList();
            this.extension_ = Collections.emptyList();
            this.syntax_ = "";
        }

        public static FileDescriptorProto parseFrom(InputStream inputStream) throws IOException {
            return (FileDescriptorProto) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static FileDescriptorProto parseFrom(InputStream inputStream, com.google.protobuf.q qVar) throws IOException {
            return (FileDescriptorProto) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
        }

        public static FileDescriptorProto parseFrom(com.google.protobuf.i iVar) throws IOException {
            return (FileDescriptorProto) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
        }

        public static FileDescriptorProto parseFrom(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws IOException {
            return (FileDescriptorProto) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v0 */
        /* JADX WARN: Type inference failed for: r3v1 */
        /* JADX WARN: Type inference failed for: r3v2, types: [boolean] */
        private FileDescriptorProto(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
            this();
            a1.b g10 = a1.g();
            boolean z10 = false;
            boolean z11 = false;
            while (true) {
                ?? r32 = 256;
                if (!z10) {
                    try {
                        try {
                            try {
                                int F = iVar.F();
                                FileOptions.b bVar = null;
                                SourceCodeInfo.b builder = null;
                                switch (F) {
                                    case 0:
                                        break;
                                    case 10:
                                        ByteString m10 = iVar.m();
                                        this.bitField0_ |= 1;
                                        this.name_ = m10;
                                        continue;
                                    case 18:
                                        ByteString m11 = iVar.m();
                                        this.bitField0_ |= 2;
                                        this.package_ = m11;
                                        continue;
                                    case 26:
                                        ByteString m12 = iVar.m();
                                        boolean z12 = z11 & true;
                                        z11 = z11;
                                        if (!z12) {
                                            this.dependency_ = new x();
                                            z11 |= true;
                                        }
                                        this.dependency_.v(m12);
                                        continue;
                                    case 34:
                                        boolean z13 = z11 & true;
                                        z11 = z11;
                                        if (!z13) {
                                            this.messageType_ = new ArrayList();
                                            z11 |= true;
                                        }
                                        this.messageType_.add(iVar.v(DescriptorProto.PARSER, qVar));
                                        continue;
                                    case 42:
                                        boolean z14 = z11 & true;
                                        z11 = z11;
                                        if (!z14) {
                                            this.enumType_ = new ArrayList();
                                            z11 |= true;
                                        }
                                        this.enumType_.add(iVar.v(EnumDescriptorProto.PARSER, qVar));
                                        continue;
                                    case 50:
                                        boolean z15 = z11 & true;
                                        z11 = z11;
                                        if (!z15) {
                                            this.service_ = new ArrayList();
                                            z11 |= true;
                                        }
                                        this.service_.add(iVar.v(ServiceDescriptorProto.PARSER, qVar));
                                        continue;
                                    case 58:
                                        boolean z16 = z11 & true;
                                        z11 = z11;
                                        if (!z16) {
                                            this.extension_ = new ArrayList();
                                            z11 |= true;
                                        }
                                        this.extension_.add(iVar.v(FieldDescriptorProto.PARSER, qVar));
                                        continue;
                                    case 66:
                                        bVar = (this.bitField0_ & 4) == 4 ? this.options_.toBuilder() : bVar;
                                        FileOptions fileOptions = (FileOptions) iVar.v(FileOptions.PARSER, qVar);
                                        this.options_ = fileOptions;
                                        if (bVar != null) {
                                            bVar.A(fileOptions);
                                            this.options_ = bVar.buildPartial();
                                        }
                                        this.bitField0_ |= 4;
                                        continue;
                                    case 74:
                                        builder = (this.bitField0_ & 8) == 8 ? this.sourceCodeInfo_.toBuilder() : builder;
                                        SourceCodeInfo sourceCodeInfo = (SourceCodeInfo) iVar.v(SourceCodeInfo.PARSER, qVar);
                                        this.sourceCodeInfo_ = sourceCodeInfo;
                                        if (builder != null) {
                                            builder.m(sourceCodeInfo);
                                            this.sourceCodeInfo_ = builder.buildPartial();
                                        }
                                        this.bitField0_ |= 8;
                                        continue;
                                    case 80:
                                        boolean z17 = z11 & true;
                                        z11 = z11;
                                        if (!z17) {
                                            this.publicDependency_ = new ArrayList();
                                            z11 |= true;
                                        }
                                        this.publicDependency_.add(Integer.valueOf(iVar.t()));
                                        continue;
                                    case 82:
                                        int k10 = iVar.k(iVar.x());
                                        boolean z18 = z11 & true;
                                        z11 = z11;
                                        if (!z18) {
                                            z11 = z11;
                                            if (iVar.d() > 0) {
                                                this.publicDependency_ = new ArrayList();
                                                z11 |= true;
                                            }
                                        }
                                        while (iVar.d() > 0) {
                                            this.publicDependency_.add(Integer.valueOf(iVar.t()));
                                        }
                                        iVar.j(k10);
                                        continue;
                                    case 88:
                                        boolean z19 = z11 & true;
                                        z11 = z11;
                                        if (!z19) {
                                            this.weakDependency_ = new ArrayList();
                                            z11 |= true;
                                        }
                                        this.weakDependency_.add(Integer.valueOf(iVar.t()));
                                        continue;
                                    case 90:
                                        int k11 = iVar.k(iVar.x());
                                        boolean z20 = z11 & true;
                                        z11 = z11;
                                        if (!z20) {
                                            z11 = z11;
                                            if (iVar.d() > 0) {
                                                this.weakDependency_ = new ArrayList();
                                                z11 |= true;
                                            }
                                        }
                                        while (iVar.d() > 0) {
                                            this.weakDependency_.add(Integer.valueOf(iVar.t()));
                                        }
                                        iVar.j(k11);
                                        continue;
                                    case 98:
                                        ByteString m13 = iVar.m();
                                        this.bitField0_ |= 16;
                                        this.syntax_ = m13;
                                        continue;
                                    default:
                                        r32 = parseUnknownField(iVar, g10, qVar, F);
                                        if (r32 == 0) {
                                            break;
                                        } else {
                                            continue;
                                        }
                                }
                                z10 = true;
                            } catch (InvalidProtocolBufferException e10) {
                                throw e10.setUnfinishedMessage(this);
                            }
                        } catch (IOException e11) {
                            throw new InvalidProtocolBufferException(e11).setUnfinishedMessage(this);
                        }
                    } finally {
                        if (z11 & true) {
                            this.dependency_ = this.dependency_.u0();
                        }
                        if (z11 & true) {
                            this.messageType_ = Collections.unmodifiableList(this.messageType_);
                        }
                        if (z11 & true) {
                            this.enumType_ = Collections.unmodifiableList(this.enumType_);
                        }
                        if (z11 & true) {
                            this.service_ = Collections.unmodifiableList(this.service_);
                        }
                        if ((z11 & true) == r32) {
                            this.extension_ = Collections.unmodifiableList(this.extension_);
                        }
                        if (z11 & true) {
                            this.publicDependency_ = Collections.unmodifiableList(this.publicDependency_);
                        }
                        if (z11 & true) {
                            this.weakDependency_ = Collections.unmodifiableList(this.weakDependency_);
                        }
                        this.unknownFields = g10.build();
                        makeExtensionsImmutable();
                    }
                } else {
                    return;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class FileDescriptorSet extends GeneratedMessageV3 implements g0 {
        public static final int FILE_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private List<FileDescriptorProto> file_;
        private byte memoizedIsInitialized;
        private static final FileDescriptorSet DEFAULT_INSTANCE = new FileDescriptorSet();
        @Deprecated
        public static final l0<FileDescriptorSet> PARSER = new a();

        /* loaded from: classes.dex */
        static class a extends com.google.protobuf.c<FileDescriptorSet> {
            a() {
            }

            /* renamed from: a */
            public FileDescriptorSet parsePartialFrom(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
                return new FileDescriptorSet(iVar, qVar, null);
            }
        }

        /* loaded from: classes.dex */
        public static final class b extends GeneratedMessageV3.b<b> implements g0 {

            /* renamed from: a  reason: collision with root package name */
            private int f12833a;

            /* renamed from: b  reason: collision with root package name */
            private List<FileDescriptorProto> f12834b;

            /* renamed from: c  reason: collision with root package name */
            private o0<FileDescriptorProto, FileDescriptorProto.b, i> f12835c;

            /* synthetic */ b(a aVar) {
                this();
            }

            private void i() {
                if ((this.f12833a & 1) != 1) {
                    this.f12834b = new ArrayList(this.f12834b);
                    this.f12833a |= 1;
                }
            }

            private o0<FileDescriptorProto, FileDescriptorProto.b, i> m() {
                if (this.f12835c == null) {
                    List<FileDescriptorProto> list = this.f12834b;
                    boolean z10 = true;
                    if ((this.f12833a & 1) != 1) {
                        z10 = false;
                    }
                    this.f12835c = new o0<>(list, z10, getParentForChildren(), isClean());
                    this.f12834b = null;
                }
                return this.f12835c;
            }

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                    m();
                }
            }

            /* renamed from: a */
            public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.addRepeatedField(fieldDescriptor, obj);
            }

            /* renamed from: b */
            public FileDescriptorSet build() {
                FileDescriptorSet c10 = buildPartial();
                if (c10.isInitialized()) {
                    return c10;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) c10);
            }

            /* renamed from: c */
            public FileDescriptorSet buildPartial() {
                FileDescriptorSet fileDescriptorSet = new FileDescriptorSet(this, (a) null);
                int i10 = this.f12833a;
                o0<FileDescriptorProto, FileDescriptorProto.b, i> o0Var = this.f12835c;
                if (o0Var == null) {
                    if ((i10 & 1) == 1) {
                        this.f12834b = Collections.unmodifiableList(this.f12834b);
                        this.f12833a &= -2;
                    }
                    fileDescriptorSet.file_ = this.f12834b;
                } else {
                    fileDescriptorSet.file_ = o0Var.g();
                }
                onBuilt();
                return fileDescriptorSet;
            }

            /* renamed from: d */
            public b clear() {
                super.clear();
                o0<FileDescriptorProto, FileDescriptorProto.b, i> o0Var = this.f12835c;
                if (o0Var == null) {
                    this.f12834b = Collections.emptyList();
                    this.f12833a &= -2;
                } else {
                    o0Var.h();
                }
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
                return DescriptorProtos.f12722a;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return DescriptorProtos.f12723b.e(FileDescriptorSet.class, b.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.f0
            public final boolean isInitialized() {
                for (int i10 = 0; i10 < l(); i10++) {
                    if (!k(i10).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }

            /* renamed from: j */
            public FileDescriptorSet getDefaultInstanceForType() {
                return FileDescriptorSet.getDefaultInstance();
            }

            public FileDescriptorProto k(int i10) {
                o0<FileDescriptorProto, FileDescriptorProto.b, i> o0Var = this.f12835c;
                if (o0Var == null) {
                    return this.f12834b.get(i10);
                }
                return o0Var.o(i10);
            }

            public int l() {
                o0<FileDescriptorProto, FileDescriptorProto.b, i> o0Var = this.f12835c;
                if (o0Var == null) {
                    return this.f12834b.size();
                }
                return o0Var.n();
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x0021  */
            /* renamed from: n */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public b mergeFrom(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws IOException {
                Throwable th2;
                FileDescriptorSet fileDescriptorSet = null;
                try {
                    try {
                        FileDescriptorSet parsePartialFrom = FileDescriptorSet.PARSER.parsePartialFrom(iVar, qVar);
                        if (parsePartialFrom != null) {
                            o(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e10) {
                        fileDescriptorSet = (FileDescriptorSet) e10.getUnfinishedMessage();
                        try {
                            throw e10.unwrapIOException();
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (fileDescriptorSet != null) {
                                o(fileDescriptorSet);
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (fileDescriptorSet != null) {
                    }
                    throw th2;
                }
            }

            public b o(FileDescriptorSet fileDescriptorSet) {
                if (fileDescriptorSet == FileDescriptorSet.getDefaultInstance()) {
                    return this;
                }
                if (this.f12835c == null) {
                    if (!fileDescriptorSet.file_.isEmpty()) {
                        if (this.f12834b.isEmpty()) {
                            this.f12834b = fileDescriptorSet.file_;
                            this.f12833a &= -2;
                        } else {
                            i();
                            this.f12834b.addAll(fileDescriptorSet.file_);
                        }
                        onChanged();
                    }
                } else if (!fileDescriptorSet.file_.isEmpty()) {
                    if (this.f12835c.u()) {
                        this.f12835c.i();
                        o0<FileDescriptorProto, FileDescriptorProto.b, i> o0Var = null;
                        this.f12835c = null;
                        this.f12834b = fileDescriptorSet.file_;
                        this.f12833a &= -2;
                        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                            o0Var = m();
                        }
                        this.f12835c = o0Var;
                    } else {
                        this.f12835c.b(fileDescriptorSet.file_);
                    }
                }
                mergeUnknownFields(fileDescriptorSet.unknownFields);
                onChanged();
                return this;
            }

            /* renamed from: p */
            public b mergeFrom(d0 d0Var) {
                if (d0Var instanceof FileDescriptorSet) {
                    return o((FileDescriptorSet) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            /* renamed from: q */
            public final b mergeUnknownFields(a1 a1Var) {
                return (b) super.mergeUnknownFields(a1Var);
            }

            /* renamed from: r */
            public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.setField(fieldDescriptor, obj);
            }

            /* renamed from: s */
            public b setRepeatedField2(Descriptors.FieldDescriptor fieldDescriptor, int i10, Object obj) {
                return (b) super.setRepeatedField(fieldDescriptor, i10, obj);
            }

            /* renamed from: t */
            public final b setUnknownFields(a1 a1Var) {
                return (b) super.setUnknownFields(a1Var);
            }

            /* synthetic */ b(GeneratedMessageV3.c cVar, a aVar) {
                this(cVar);
            }

            private b() {
                this.f12834b = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.f12834b = Collections.emptyList();
                maybeForceBuilderInitialization();
            }
        }

        /* synthetic */ FileDescriptorSet(com.google.protobuf.i iVar, com.google.protobuf.q qVar, a aVar) throws InvalidProtocolBufferException {
            this(iVar, qVar);
        }

        public static FileDescriptorSet getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return DescriptorProtos.f12722a;
        }

        public static b newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static FileDescriptorSet parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (FileDescriptorSet) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static FileDescriptorSet parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static l0<FileDescriptorSet> parser() {
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
            if (!(obj instanceof FileDescriptorSet)) {
                return super.equals(obj);
            }
            FileDescriptorSet fileDescriptorSet = (FileDescriptorSet) obj;
            return (getFileList().equals(fileDescriptorSet.getFileList())) && this.unknownFields.equals(fileDescriptorSet.unknownFields);
        }

        public FileDescriptorProto getFile(int i10) {
            return this.file_.get(i10);
        }

        public int getFileCount() {
            return this.file_.size();
        }

        public List<FileDescriptorProto> getFileList() {
            return this.file_;
        }

        public i getFileOrBuilder(int i10) {
            return this.file_.get(i10);
        }

        public List<? extends i> getFileOrBuilderList() {
            return this.file_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public l0<FileDescriptorSet> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
        public int getSerializedSize() {
            int i10 = this.memoizedSize;
            if (i10 != -1) {
                return i10;
            }
            int i11 = 0;
            for (int i12 = 0; i12 < this.file_.size(); i12++) {
                i11 += CodedOutputStream.E(1, this.file_.get(i12));
            }
            int serializedSize = i11 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.g0
        public final a1 getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.google.protobuf.a
        public int hashCode() {
            int i10 = this.memoizedHashCode;
            if (i10 != 0) {
                return i10;
            }
            int hashCode = 779 + getDescriptorForType().hashCode();
            if (getFileCount() > 0) {
                hashCode = (((hashCode * 37) + 1) * 53) + getFileList().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return DescriptorProtos.f12723b.e(FileDescriptorSet.class, b.class);
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
            for (int i10 = 0; i10 < getFileCount(); i10++) {
                if (!getFile(i10).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            for (int i10 = 0; i10 < this.file_.size(); i10++) {
                codedOutputStream.A0(1, this.file_.get(i10));
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        /* synthetic */ FileDescriptorSet(GeneratedMessageV3.b bVar, a aVar) {
            this(bVar);
        }

        public static b newBuilder(FileDescriptorSet fileDescriptorSet) {
            return DEFAULT_INSTANCE.toBuilder().o(fileDescriptorSet);
        }

        public static FileDescriptorSet parseFrom(ByteString byteString, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, qVar);
        }

        private FileDescriptorSet(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static FileDescriptorSet parseDelimitedFrom(InputStream inputStream, com.google.protobuf.q qVar) throws IOException {
            return (FileDescriptorSet) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
        }

        public static FileDescriptorSet parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
        public FileDescriptorSet getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b toBuilder() {
            return this == DEFAULT_INSTANCE ? new b((a) null) : new b((a) null).o(this);
        }

        public static FileDescriptorSet parseFrom(byte[] bArr, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b newBuilderForType() {
            return newBuilder();
        }

        private FileDescriptorSet() {
            this.memoizedIsInitialized = (byte) -1;
            this.file_ = Collections.emptyList();
        }

        public static FileDescriptorSet parseFrom(InputStream inputStream) throws IOException {
            return (FileDescriptorSet) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static FileDescriptorSet parseFrom(InputStream inputStream, com.google.protobuf.q qVar) throws IOException {
            return (FileDescriptorSet) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private FileDescriptorSet(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
            this();
            a1.b g10 = a1.g();
            boolean z10 = false;
            boolean z11 = false;
            while (true) {
                if (z10) {
                    break;
                }
                try {
                    try {
                        int F = iVar.F();
                        if (F != 0) {
                            if (F == 10) {
                                if (!z11 || !true) {
                                    this.file_ = new ArrayList();
                                    z11 |= true;
                                }
                                this.file_.add(iVar.v(FileDescriptorProto.PARSER, qVar));
                            } else if (!parseUnknownField(iVar, g10, qVar, F)) {
                            }
                        }
                        z10 = true;
                    } catch (InvalidProtocolBufferException e10) {
                        throw e10.setUnfinishedMessage(this);
                    } catch (IOException e11) {
                        throw new InvalidProtocolBufferException(e11).setUnfinishedMessage(this);
                    }
                } finally {
                    if (z11 && true) {
                        this.file_ = Collections.unmodifiableList(this.file_);
                    }
                    this.unknownFields = g10.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static FileDescriptorSet parseFrom(com.google.protobuf.i iVar) throws IOException {
            return (FileDescriptorSet) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
        }

        public static FileDescriptorSet parseFrom(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws IOException {
            return (FileDescriptorSet) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
        }
    }

    /* loaded from: classes.dex */
    public static final class FileOptions extends GeneratedMessageV3.ExtendableMessage<FileOptions> implements j {
        public static final int CC_ENABLE_ARENAS_FIELD_NUMBER = 31;
        public static final int CC_GENERIC_SERVICES_FIELD_NUMBER = 16;
        public static final int CSHARP_NAMESPACE_FIELD_NUMBER = 37;
        public static final int DEPRECATED_FIELD_NUMBER = 23;
        public static final int GO_PACKAGE_FIELD_NUMBER = 11;
        public static final int JAVA_GENERATE_EQUALS_AND_HASH_FIELD_NUMBER = 20;
        public static final int JAVA_GENERIC_SERVICES_FIELD_NUMBER = 17;
        public static final int JAVA_MULTIPLE_FILES_FIELD_NUMBER = 10;
        public static final int JAVA_OUTER_CLASSNAME_FIELD_NUMBER = 8;
        public static final int JAVA_PACKAGE_FIELD_NUMBER = 1;
        public static final int JAVA_STRING_CHECK_UTF8_FIELD_NUMBER = 27;
        public static final int OBJC_CLASS_PREFIX_FIELD_NUMBER = 36;
        public static final int OPTIMIZE_FOR_FIELD_NUMBER = 9;
        public static final int PY_GENERIC_SERVICES_FIELD_NUMBER = 18;
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private boolean ccEnableArenas_;
        private boolean ccGenericServices_;
        private volatile Object csharpNamespace_;
        private boolean deprecated_;
        private volatile Object goPackage_;
        private boolean javaGenerateEqualsAndHash_;
        private boolean javaGenericServices_;
        private boolean javaMultipleFiles_;
        private volatile Object javaOuterClassname_;
        private volatile Object javaPackage_;
        private boolean javaStringCheckUtf8_;
        private byte memoizedIsInitialized;
        private volatile Object objcClassPrefix_;
        private int optimizeFor_;
        private boolean pyGenericServices_;
        private List<UninterpretedOption> uninterpretedOption_;
        private static final FileOptions DEFAULT_INSTANCE = new FileOptions();
        @Deprecated
        public static final l0<FileOptions> PARSER = new a();

        /* loaded from: classes.dex */
        public enum OptimizeMode implements m0 {
            SPEED(1),
            CODE_SIZE(2),
            LITE_RUNTIME(3);
            
            public static final int CODE_SIZE_VALUE = 2;
            public static final int LITE_RUNTIME_VALUE = 3;
            public static final int SPEED_VALUE = 1;
            private final int value;
            private static final u.b<OptimizeMode> internalValueMap = new a();
            private static final OptimizeMode[] VALUES = values();

            /* loaded from: classes.dex */
            static class a implements u.b<OptimizeMode> {
                a() {
                }
            }

            OptimizeMode(int i10) {
                this.value = i10;
            }

            public static OptimizeMode forNumber(int i10) {
                if (i10 == 1) {
                    return SPEED;
                }
                if (i10 == 2) {
                    return CODE_SIZE;
                }
                if (i10 != 3) {
                    return null;
                }
                return LITE_RUNTIME;
            }

            public static final Descriptors.d getDescriptor() {
                return FileOptions.getDescriptor().j().get(0);
            }

            public static u.b<OptimizeMode> internalGetValueMap() {
                return internalValueMap;
            }

            public final Descriptors.d getDescriptorForType() {
                return getDescriptor();
            }

            @Override // com.google.protobuf.u.a
            public final int getNumber() {
                return this.value;
            }

            public final Descriptors.e getValueDescriptor() {
                return getDescriptor().i().get(ordinal());
            }

            @Deprecated
            public static OptimizeMode valueOf(int i10) {
                return forNumber(i10);
            }

            public static OptimizeMode valueOf(Descriptors.e eVar) {
                if (eVar.g() == getDescriptor()) {
                    return VALUES[eVar.f()];
                }
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            }
        }

        /* loaded from: classes.dex */
        static class a extends com.google.protobuf.c<FileOptions> {
            a() {
            }

            /* renamed from: a */
            public FileOptions parsePartialFrom(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
                return new FileOptions(iVar, qVar, null);
            }
        }

        /* loaded from: classes.dex */
        public static final class b extends GeneratedMessageV3.d<FileOptions, b> implements j {

            /* renamed from: b  reason: collision with root package name */
            private int f12836b;

            /* renamed from: c  reason: collision with root package name */
            private Object f12837c;

            /* renamed from: d  reason: collision with root package name */
            private Object f12838d;

            /* renamed from: e  reason: collision with root package name */
            private boolean f12839e;

            /* renamed from: f  reason: collision with root package name */
            private boolean f12840f;

            /* renamed from: g  reason: collision with root package name */
            private boolean f12841g;

            /* renamed from: h  reason: collision with root package name */
            private int f12842h;

            /* renamed from: i  reason: collision with root package name */
            private Object f12843i;

            /* renamed from: j  reason: collision with root package name */
            private boolean f12844j;

            /* renamed from: k  reason: collision with root package name */
            private boolean f12845k;

            /* renamed from: l  reason: collision with root package name */
            private boolean f12846l;

            /* renamed from: m  reason: collision with root package name */
            private boolean f12847m;

            /* renamed from: n  reason: collision with root package name */
            private boolean f12848n;

            /* renamed from: o  reason: collision with root package name */
            private Object f12849o;

            /* renamed from: p  reason: collision with root package name */
            private Object f12850p;

            /* renamed from: q  reason: collision with root package name */
            private List<UninterpretedOption> f12851q;

            /* renamed from: r  reason: collision with root package name */
            private o0<UninterpretedOption, UninterpretedOption.b, s> f12852r;

            /* synthetic */ b(a aVar) {
                this();
            }

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                    y();
                }
            }

            private void u() {
                if ((this.f12836b & 16384) != 16384) {
                    this.f12851q = new ArrayList(this.f12851q);
                    this.f12836b |= 16384;
                }
            }

            private o0<UninterpretedOption, UninterpretedOption.b, s> y() {
                if (this.f12852r == null) {
                    this.f12852r = new o0<>(this.f12851q, (this.f12836b & 16384) == 16384, getParentForChildren(), isClean());
                    this.f12851q = null;
                }
                return this.f12852r;
            }

            public b A(FileOptions fileOptions) {
                if (fileOptions == FileOptions.getDefaultInstance()) {
                    return this;
                }
                if (fileOptions.hasJavaPackage()) {
                    this.f12836b |= 1;
                    this.f12837c = fileOptions.javaPackage_;
                    onChanged();
                }
                if (fileOptions.hasJavaOuterClassname()) {
                    this.f12836b |= 2;
                    this.f12838d = fileOptions.javaOuterClassname_;
                    onChanged();
                }
                if (fileOptions.hasJavaMultipleFiles()) {
                    J(fileOptions.getJavaMultipleFiles());
                }
                if (fileOptions.hasJavaGenerateEqualsAndHash()) {
                    H(fileOptions.getJavaGenerateEqualsAndHash());
                }
                if (fileOptions.hasJavaStringCheckUtf8()) {
                    K(fileOptions.getJavaStringCheckUtf8());
                }
                if (fileOptions.hasOptimizeFor()) {
                    L(fileOptions.getOptimizeFor());
                }
                if (fileOptions.hasGoPackage()) {
                    this.f12836b |= 64;
                    this.f12843i = fileOptions.goPackage_;
                    onChanged();
                }
                if (fileOptions.hasCcGenericServices()) {
                    E(fileOptions.getCcGenericServices());
                }
                if (fileOptions.hasJavaGenericServices()) {
                    I(fileOptions.getJavaGenericServices());
                }
                if (fileOptions.hasPyGenericServices()) {
                    M(fileOptions.getPyGenericServices());
                }
                if (fileOptions.hasDeprecated()) {
                    F(fileOptions.getDeprecated());
                }
                if (fileOptions.hasCcEnableArenas()) {
                    D(fileOptions.getCcEnableArenas());
                }
                if (fileOptions.hasObjcClassPrefix()) {
                    this.f12836b |= 4096;
                    this.f12849o = fileOptions.objcClassPrefix_;
                    onChanged();
                }
                if (fileOptions.hasCsharpNamespace()) {
                    this.f12836b |= 8192;
                    this.f12850p = fileOptions.csharpNamespace_;
                    onChanged();
                }
                if (this.f12852r == null) {
                    if (!fileOptions.uninterpretedOption_.isEmpty()) {
                        if (this.f12851q.isEmpty()) {
                            this.f12851q = fileOptions.uninterpretedOption_;
                            this.f12836b &= -16385;
                        } else {
                            u();
                            this.f12851q.addAll(fileOptions.uninterpretedOption_);
                        }
                        onChanged();
                    }
                } else if (!fileOptions.uninterpretedOption_.isEmpty()) {
                    if (this.f12852r.u()) {
                        this.f12852r.i();
                        o0<UninterpretedOption, UninterpretedOption.b, s> o0Var = null;
                        this.f12852r = null;
                        this.f12851q = fileOptions.uninterpretedOption_;
                        this.f12836b &= -16385;
                        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                            o0Var = y();
                        }
                        this.f12852r = o0Var;
                    } else {
                        this.f12852r.b(fileOptions.uninterpretedOption_);
                    }
                }
                j(fileOptions);
                mergeUnknownFields(fileOptions.unknownFields);
                onChanged();
                return this;
            }

            /* renamed from: B */
            public b mergeFrom(d0 d0Var) {
                if (d0Var instanceof FileOptions) {
                    return A((FileOptions) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            /* renamed from: C */
            public final b mergeUnknownFields(a1 a1Var) {
                return (b) super.mergeUnknownFields(a1Var);
            }

            public b D(boolean z10) {
                this.f12836b |= 2048;
                this.f12848n = z10;
                onChanged();
                return this;
            }

            public b E(boolean z10) {
                this.f12836b |= 128;
                this.f12844j = z10;
                onChanged();
                return this;
            }

            public b F(boolean z10) {
                this.f12836b |= 1024;
                this.f12847m = z10;
                onChanged();
                return this;
            }

            /* renamed from: G */
            public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.setField(fieldDescriptor, obj);
            }

            @Deprecated
            public b H(boolean z10) {
                this.f12836b |= 8;
                this.f12840f = z10;
                onChanged();
                return this;
            }

            public b I(boolean z10) {
                this.f12836b |= 256;
                this.f12845k = z10;
                onChanged();
                return this;
            }

            public b J(boolean z10) {
                this.f12836b |= 4;
                this.f12839e = z10;
                onChanged();
                return this;
            }

            public b K(boolean z10) {
                this.f12836b |= 16;
                this.f12841g = z10;
                onChanged();
                return this;
            }

            public b L(OptimizeMode optimizeMode) {
                Objects.requireNonNull(optimizeMode);
                this.f12836b |= 32;
                this.f12842h = optimizeMode.getNumber();
                onChanged();
                return this;
            }

            public b M(boolean z10) {
                this.f12836b |= 512;
                this.f12846l = z10;
                onChanged();
                return this;
            }

            /* renamed from: N */
            public b setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i10, Object obj) {
                return (b) super.setRepeatedField(fieldDescriptor, i10, obj);
            }

            /* renamed from: O */
            public final b setUnknownFields(a1 a1Var) {
                return (b) super.setUnknownFields(a1Var);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a, com.google.protobuf.g0
            public Descriptors.b getDescriptorForType() {
                return DescriptorProtos.f12744w;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return DescriptorProtos.f12745x.e(FileOptions.class, b.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.d, com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.f0
            public final boolean isInitialized() {
                for (int i10 = 0; i10 < x(); i10++) {
                    if (!w(i10).isInitialized()) {
                        return false;
                    }
                }
                return i();
            }

            /* renamed from: n */
            public b b(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.addRepeatedField(fieldDescriptor, obj);
            }

            /* renamed from: o */
            public FileOptions build() {
                FileOptions p10 = buildPartial();
                if (p10.isInitialized()) {
                    return p10;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) p10);
            }

            /* renamed from: p */
            public FileOptions buildPartial() {
                FileOptions fileOptions = new FileOptions(this, (a) null);
                int i10 = this.f12836b;
                int i11 = 1;
                if ((i10 & 1) != 1) {
                    i11 = 0;
                }
                fileOptions.javaPackage_ = this.f12837c;
                if ((i10 & 2) == 2) {
                    i11 |= 2;
                }
                fileOptions.javaOuterClassname_ = this.f12838d;
                if ((i10 & 4) == 4) {
                    i11 |= 4;
                }
                fileOptions.javaMultipleFiles_ = this.f12839e;
                if ((i10 & 8) == 8) {
                    i11 |= 8;
                }
                fileOptions.javaGenerateEqualsAndHash_ = this.f12840f;
                if ((i10 & 16) == 16) {
                    i11 |= 16;
                }
                fileOptions.javaStringCheckUtf8_ = this.f12841g;
                if ((i10 & 32) == 32) {
                    i11 |= 32;
                }
                fileOptions.optimizeFor_ = this.f12842h;
                if ((i10 & 64) == 64) {
                    i11 |= 64;
                }
                fileOptions.goPackage_ = this.f12843i;
                if ((i10 & 128) == 128) {
                    i11 |= 128;
                }
                fileOptions.ccGenericServices_ = this.f12844j;
                if ((i10 & 256) == 256) {
                    i11 |= 256;
                }
                fileOptions.javaGenericServices_ = this.f12845k;
                if ((i10 & 512) == 512) {
                    i11 |= 512;
                }
                fileOptions.pyGenericServices_ = this.f12846l;
                if ((i10 & 1024) == 1024) {
                    i11 |= 1024;
                }
                fileOptions.deprecated_ = this.f12847m;
                if ((i10 & 2048) == 2048) {
                    i11 |= 2048;
                }
                fileOptions.ccEnableArenas_ = this.f12848n;
                if ((i10 & 4096) == 4096) {
                    i11 |= 4096;
                }
                fileOptions.objcClassPrefix_ = this.f12849o;
                if ((i10 & 8192) == 8192) {
                    i11 |= 8192;
                }
                fileOptions.csharpNamespace_ = this.f12850p;
                o0<UninterpretedOption, UninterpretedOption.b, s> o0Var = this.f12852r;
                if (o0Var == null) {
                    if ((this.f12836b & 16384) == 16384) {
                        this.f12851q = Collections.unmodifiableList(this.f12851q);
                        this.f12836b &= -16385;
                    }
                    fileOptions.uninterpretedOption_ = this.f12851q;
                } else {
                    fileOptions.uninterpretedOption_ = o0Var.g();
                }
                fileOptions.bitField0_ = i11;
                onBuilt();
                return fileOptions;
            }

            /* renamed from: q */
            public b d() {
                super.clear();
                this.f12837c = "";
                int i10 = this.f12836b & (-2);
                this.f12836b = i10;
                this.f12838d = "";
                int i11 = i10 & (-3);
                this.f12836b = i11;
                this.f12839e = false;
                int i12 = i11 & (-5);
                this.f12836b = i12;
                this.f12840f = false;
                int i13 = i12 & (-9);
                this.f12836b = i13;
                this.f12841g = false;
                int i14 = i13 & (-17);
                this.f12836b = i14;
                this.f12842h = 1;
                int i15 = i14 & (-33);
                this.f12836b = i15;
                this.f12843i = "";
                int i16 = i15 & (-65);
                this.f12836b = i16;
                this.f12844j = false;
                int i17 = i16 & (-129);
                this.f12836b = i17;
                this.f12845k = false;
                int i18 = i17 & (-257);
                this.f12836b = i18;
                this.f12846l = false;
                int i19 = i18 & (-513);
                this.f12836b = i19;
                this.f12847m = false;
                int i20 = i19 & (-1025);
                this.f12836b = i20;
                this.f12848n = false;
                int i21 = i20 & (-2049);
                this.f12836b = i21;
                this.f12849o = "";
                int i22 = i21 & (-4097);
                this.f12836b = i22;
                this.f12850p = "";
                this.f12836b = i22 & (-8193);
                o0<UninterpretedOption, UninterpretedOption.b, s> o0Var = this.f12852r;
                if (o0Var == null) {
                    this.f12851q = Collections.emptyList();
                    this.f12836b &= -16385;
                } else {
                    o0Var.h();
                }
                return this;
            }

            /* renamed from: r */
            public b e(Descriptors.FieldDescriptor fieldDescriptor) {
                return (b) super.clearField(fieldDescriptor);
            }

            /* renamed from: s */
            public b clearOneof(Descriptors.h hVar) {
                return (b) super.clearOneof(hVar);
            }

            /* renamed from: t */
            public b f() {
                return (b) super.clone();
            }

            /* renamed from: v */
            public FileOptions getDefaultInstanceForType() {
                return FileOptions.getDefaultInstance();
            }

            public UninterpretedOption w(int i10) {
                o0<UninterpretedOption, UninterpretedOption.b, s> o0Var = this.f12852r;
                if (o0Var == null) {
                    return this.f12851q.get(i10);
                }
                return o0Var.o(i10);
            }

            public int x() {
                o0<UninterpretedOption, UninterpretedOption.b, s> o0Var = this.f12852r;
                if (o0Var == null) {
                    return this.f12851q.size();
                }
                return o0Var.n();
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x0021  */
            /* renamed from: z */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public b mergeFrom(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws IOException {
                Throwable th2;
                FileOptions fileOptions = null;
                try {
                    try {
                        FileOptions parsePartialFrom = FileOptions.PARSER.parsePartialFrom(iVar, qVar);
                        if (parsePartialFrom != null) {
                            A(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e10) {
                        fileOptions = (FileOptions) e10.getUnfinishedMessage();
                        try {
                            throw e10.unwrapIOException();
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (fileOptions != null) {
                                A(fileOptions);
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (fileOptions != null) {
                    }
                    throw th2;
                }
            }

            /* synthetic */ b(GeneratedMessageV3.c cVar, a aVar) {
                this(cVar);
            }

            private b() {
                this.f12837c = "";
                this.f12838d = "";
                this.f12842h = 1;
                this.f12843i = "";
                this.f12849o = "";
                this.f12850p = "";
                this.f12851q = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.f12837c = "";
                this.f12838d = "";
                this.f12842h = 1;
                this.f12843i = "";
                this.f12849o = "";
                this.f12850p = "";
                this.f12851q = Collections.emptyList();
                maybeForceBuilderInitialization();
            }
        }

        /* synthetic */ FileOptions(com.google.protobuf.i iVar, com.google.protobuf.q qVar, a aVar) throws InvalidProtocolBufferException {
            this(iVar, qVar);
        }

        public static FileOptions getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return DescriptorProtos.f12744w;
        }

        public static b newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static FileOptions parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (FileOptions) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static FileOptions parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static l0<FileOptions> parser() {
            return PARSER;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: F */
        public b newBuilderForType(GeneratedMessageV3.c cVar) {
            return new b(cVar, null);
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof FileOptions)) {
                return super.equals(obj);
            }
            FileOptions fileOptions = (FileOptions) obj;
            boolean z10 = hasJavaPackage() == fileOptions.hasJavaPackage();
            if (hasJavaPackage()) {
                z10 = z10 && getJavaPackage().equals(fileOptions.getJavaPackage());
            }
            boolean z11 = z10 && hasJavaOuterClassname() == fileOptions.hasJavaOuterClassname();
            if (hasJavaOuterClassname()) {
                z11 = z11 && getJavaOuterClassname().equals(fileOptions.getJavaOuterClassname());
            }
            boolean z12 = z11 && hasJavaMultipleFiles() == fileOptions.hasJavaMultipleFiles();
            if (hasJavaMultipleFiles()) {
                z12 = z12 && getJavaMultipleFiles() == fileOptions.getJavaMultipleFiles();
            }
            boolean z13 = z12 && hasJavaGenerateEqualsAndHash() == fileOptions.hasJavaGenerateEqualsAndHash();
            if (hasJavaGenerateEqualsAndHash()) {
                z13 = z13 && getJavaGenerateEqualsAndHash() == fileOptions.getJavaGenerateEqualsAndHash();
            }
            boolean z14 = z13 && hasJavaStringCheckUtf8() == fileOptions.hasJavaStringCheckUtf8();
            if (hasJavaStringCheckUtf8()) {
                z14 = z14 && getJavaStringCheckUtf8() == fileOptions.getJavaStringCheckUtf8();
            }
            boolean z15 = z14 && hasOptimizeFor() == fileOptions.hasOptimizeFor();
            if (hasOptimizeFor()) {
                z15 = z15 && this.optimizeFor_ == fileOptions.optimizeFor_;
            }
            boolean z16 = z15 && hasGoPackage() == fileOptions.hasGoPackage();
            if (hasGoPackage()) {
                z16 = z16 && getGoPackage().equals(fileOptions.getGoPackage());
            }
            boolean z17 = z16 && hasCcGenericServices() == fileOptions.hasCcGenericServices();
            if (hasCcGenericServices()) {
                z17 = z17 && getCcGenericServices() == fileOptions.getCcGenericServices();
            }
            boolean z18 = z17 && hasJavaGenericServices() == fileOptions.hasJavaGenericServices();
            if (hasJavaGenericServices()) {
                z18 = z18 && getJavaGenericServices() == fileOptions.getJavaGenericServices();
            }
            boolean z19 = z18 && hasPyGenericServices() == fileOptions.hasPyGenericServices();
            if (hasPyGenericServices()) {
                z19 = z19 && getPyGenericServices() == fileOptions.getPyGenericServices();
            }
            boolean z20 = z19 && hasDeprecated() == fileOptions.hasDeprecated();
            if (hasDeprecated()) {
                z20 = z20 && getDeprecated() == fileOptions.getDeprecated();
            }
            boolean z21 = z20 && hasCcEnableArenas() == fileOptions.hasCcEnableArenas();
            if (hasCcEnableArenas()) {
                z21 = z21 && getCcEnableArenas() == fileOptions.getCcEnableArenas();
            }
            boolean z22 = z21 && hasObjcClassPrefix() == fileOptions.hasObjcClassPrefix();
            if (hasObjcClassPrefix()) {
                z22 = z22 && getObjcClassPrefix().equals(fileOptions.getObjcClassPrefix());
            }
            boolean z23 = z22 && hasCsharpNamespace() == fileOptions.hasCsharpNamespace();
            if (hasCsharpNamespace()) {
                z23 = z23 && getCsharpNamespace().equals(fileOptions.getCsharpNamespace());
            }
            return ((z23 && getUninterpretedOptionList().equals(fileOptions.getUninterpretedOptionList())) && this.unknownFields.equals(fileOptions.unknownFields)) && d().equals(fileOptions.d());
        }

        public boolean getCcEnableArenas() {
            return this.ccEnableArenas_;
        }

        public boolean getCcGenericServices() {
            return this.ccGenericServices_;
        }

        public String getCsharpNamespace() {
            Object obj = this.csharpNamespace_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.csharpNamespace_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getCsharpNamespaceBytes() {
            Object obj = this.csharpNamespace_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.csharpNamespace_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public boolean getDeprecated() {
            return this.deprecated_;
        }

        public String getGoPackage() {
            Object obj = this.goPackage_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.goPackage_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getGoPackageBytes() {
            Object obj = this.goPackage_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.goPackage_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Deprecated
        public boolean getJavaGenerateEqualsAndHash() {
            return this.javaGenerateEqualsAndHash_;
        }

        public boolean getJavaGenericServices() {
            return this.javaGenericServices_;
        }

        public boolean getJavaMultipleFiles() {
            return this.javaMultipleFiles_;
        }

        public String getJavaOuterClassname() {
            Object obj = this.javaOuterClassname_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.javaOuterClassname_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getJavaOuterClassnameBytes() {
            Object obj = this.javaOuterClassname_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.javaOuterClassname_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public String getJavaPackage() {
            Object obj = this.javaPackage_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.javaPackage_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getJavaPackageBytes() {
            Object obj = this.javaPackage_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.javaPackage_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public boolean getJavaStringCheckUtf8() {
            return this.javaStringCheckUtf8_;
        }

        public String getObjcClassPrefix() {
            Object obj = this.objcClassPrefix_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.objcClassPrefix_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getObjcClassPrefixBytes() {
            Object obj = this.objcClassPrefix_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.objcClassPrefix_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public OptimizeMode getOptimizeFor() {
            OptimizeMode valueOf = OptimizeMode.valueOf(this.optimizeFor_);
            return valueOf == null ? OptimizeMode.SPEED : valueOf;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public l0<FileOptions> getParserForType() {
            return PARSER;
        }

        public boolean getPyGenericServices() {
            return this.pyGenericServices_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
        public int getSerializedSize() {
            int i10 = this.memoizedSize;
            if (i10 != -1) {
                return i10;
            }
            int computeStringSize = (this.bitField0_ & 1) == 1 ? GeneratedMessageV3.computeStringSize(1, this.javaPackage_) + 0 : 0;
            if ((this.bitField0_ & 2) == 2) {
                computeStringSize += GeneratedMessageV3.computeStringSize(8, this.javaOuterClassname_);
            }
            if ((this.bitField0_ & 32) == 32) {
                computeStringSize += CodedOutputStream.l(9, this.optimizeFor_);
            }
            if ((this.bitField0_ & 4) == 4) {
                computeStringSize += CodedOutputStream.e(10, this.javaMultipleFiles_);
            }
            if ((this.bitField0_ & 64) == 64) {
                computeStringSize += GeneratedMessageV3.computeStringSize(11, this.goPackage_);
            }
            if ((this.bitField0_ & 128) == 128) {
                computeStringSize += CodedOutputStream.e(16, this.ccGenericServices_);
            }
            if ((this.bitField0_ & 256) == 256) {
                computeStringSize += CodedOutputStream.e(17, this.javaGenericServices_);
            }
            if ((this.bitField0_ & 512) == 512) {
                computeStringSize += CodedOutputStream.e(18, this.pyGenericServices_);
            }
            if ((this.bitField0_ & 8) == 8) {
                computeStringSize += CodedOutputStream.e(20, this.javaGenerateEqualsAndHash_);
            }
            if ((this.bitField0_ & 1024) == 1024) {
                computeStringSize += CodedOutputStream.e(23, this.deprecated_);
            }
            if ((this.bitField0_ & 16) == 16) {
                computeStringSize += CodedOutputStream.e(27, this.javaStringCheckUtf8_);
            }
            if ((this.bitField0_ & 2048) == 2048) {
                computeStringSize += CodedOutputStream.e(31, this.ccEnableArenas_);
            }
            if ((this.bitField0_ & 4096) == 4096) {
                computeStringSize += GeneratedMessageV3.computeStringSize(36, this.objcClassPrefix_);
            }
            if ((this.bitField0_ & 8192) == 8192) {
                computeStringSize += GeneratedMessageV3.computeStringSize(37, this.csharpNamespace_);
            }
            for (int i11 = 0; i11 < this.uninterpretedOption_.size(); i11++) {
                computeStringSize += CodedOutputStream.E(999, this.uninterpretedOption_.get(i11));
            }
            int c10 = computeStringSize + c() + this.unknownFields.getSerializedSize();
            this.memoizedSize = c10;
            return c10;
        }

        public UninterpretedOption getUninterpretedOption(int i10) {
            return this.uninterpretedOption_.get(i10);
        }

        public int getUninterpretedOptionCount() {
            return this.uninterpretedOption_.size();
        }

        public List<UninterpretedOption> getUninterpretedOptionList() {
            return this.uninterpretedOption_;
        }

        public s getUninterpretedOptionOrBuilder(int i10) {
            return this.uninterpretedOption_.get(i10);
        }

        public List<? extends s> getUninterpretedOptionOrBuilderList() {
            return this.uninterpretedOption_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.g0
        public final a1 getUnknownFields() {
            return this.unknownFields;
        }

        public boolean hasCcEnableArenas() {
            return (this.bitField0_ & 2048) == 2048;
        }

        public boolean hasCcGenericServices() {
            return (this.bitField0_ & 128) == 128;
        }

        public boolean hasCsharpNamespace() {
            return (this.bitField0_ & 8192) == 8192;
        }

        public boolean hasDeprecated() {
            return (this.bitField0_ & 1024) == 1024;
        }

        public boolean hasGoPackage() {
            return (this.bitField0_ & 64) == 64;
        }

        @Deprecated
        public boolean hasJavaGenerateEqualsAndHash() {
            return (this.bitField0_ & 8) == 8;
        }

        public boolean hasJavaGenericServices() {
            return (this.bitField0_ & 256) == 256;
        }

        public boolean hasJavaMultipleFiles() {
            return (this.bitField0_ & 4) == 4;
        }

        public boolean hasJavaOuterClassname() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean hasJavaPackage() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasJavaStringCheckUtf8() {
            return (this.bitField0_ & 16) == 16;
        }

        public boolean hasObjcClassPrefix() {
            return (this.bitField0_ & 4096) == 4096;
        }

        public boolean hasOptimizeFor() {
            return (this.bitField0_ & 32) == 32;
        }

        public boolean hasPyGenericServices() {
            return (this.bitField0_ & 512) == 512;
        }

        @Override // com.google.protobuf.a
        public int hashCode() {
            int i10 = this.memoizedHashCode;
            if (i10 != 0) {
                return i10;
            }
            int hashCode = 779 + getDescriptorForType().hashCode();
            if (hasJavaPackage()) {
                hashCode = (((hashCode * 37) + 1) * 53) + getJavaPackage().hashCode();
            }
            if (hasJavaOuterClassname()) {
                hashCode = (((hashCode * 37) + 8) * 53) + getJavaOuterClassname().hashCode();
            }
            if (hasJavaMultipleFiles()) {
                hashCode = (((hashCode * 37) + 10) * 53) + u.c(getJavaMultipleFiles());
            }
            if (hasJavaGenerateEqualsAndHash()) {
                hashCode = (((hashCode * 37) + 20) * 53) + u.c(getJavaGenerateEqualsAndHash());
            }
            if (hasJavaStringCheckUtf8()) {
                hashCode = (((hashCode * 37) + 27) * 53) + u.c(getJavaStringCheckUtf8());
            }
            if (hasOptimizeFor()) {
                hashCode = (((hashCode * 37) + 9) * 53) + this.optimizeFor_;
            }
            if (hasGoPackage()) {
                hashCode = (((hashCode * 37) + 11) * 53) + getGoPackage().hashCode();
            }
            if (hasCcGenericServices()) {
                hashCode = (((hashCode * 37) + 16) * 53) + u.c(getCcGenericServices());
            }
            if (hasJavaGenericServices()) {
                hashCode = (((hashCode * 37) + 17) * 53) + u.c(getJavaGenericServices());
            }
            if (hasPyGenericServices()) {
                hashCode = (((hashCode * 37) + 18) * 53) + u.c(getPyGenericServices());
            }
            if (hasDeprecated()) {
                hashCode = (((hashCode * 37) + 23) * 53) + u.c(getDeprecated());
            }
            if (hasCcEnableArenas()) {
                hashCode = (((hashCode * 37) + 31) * 53) + u.c(getCcEnableArenas());
            }
            if (hasObjcClassPrefix()) {
                hashCode = (((hashCode * 37) + 36) * 53) + getObjcClassPrefix().hashCode();
            }
            if (hasCsharpNamespace()) {
                hashCode = (((hashCode * 37) + 37) * 53) + getCsharpNamespace().hashCode();
            }
            if (getUninterpretedOptionCount() > 0) {
                hashCode = (((hashCode * 37) + 999) * 53) + getUninterpretedOptionList().hashCode();
            }
            int hashFields = (com.google.protobuf.a.hashFields(hashCode, d()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashFields;
            return hashFields;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return DescriptorProtos.f12745x.e(FileOptions.class, b.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessage, com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.f0
        public final boolean isInitialized() {
            byte b10 = this.memoizedIsInitialized;
            if (b10 == 1) {
                return true;
            }
            if (b10 == 0) {
                return false;
            }
            for (int i10 = 0; i10 < getUninterpretedOptionCount(); i10++) {
                if (!getUninterpretedOption(i10).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (!b()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            GeneratedMessageV3.ExtendableMessage<MessageType>.a g10 = g();
            if ((this.bitField0_ & 1) == 1) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.javaPackage_);
            }
            if ((this.bitField0_ & 2) == 2) {
                GeneratedMessageV3.writeString(codedOutputStream, 8, this.javaOuterClassname_);
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.m0(9, this.optimizeFor_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.e0(10, this.javaMultipleFiles_);
            }
            if ((this.bitField0_ & 64) == 64) {
                GeneratedMessageV3.writeString(codedOutputStream, 11, this.goPackage_);
            }
            if ((this.bitField0_ & 128) == 128) {
                codedOutputStream.e0(16, this.ccGenericServices_);
            }
            if ((this.bitField0_ & 256) == 256) {
                codedOutputStream.e0(17, this.javaGenericServices_);
            }
            if ((this.bitField0_ & 512) == 512) {
                codedOutputStream.e0(18, this.pyGenericServices_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.e0(20, this.javaGenerateEqualsAndHash_);
            }
            if ((this.bitField0_ & 1024) == 1024) {
                codedOutputStream.e0(23, this.deprecated_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.e0(27, this.javaStringCheckUtf8_);
            }
            if ((this.bitField0_ & 2048) == 2048) {
                codedOutputStream.e0(31, this.ccEnableArenas_);
            }
            if ((this.bitField0_ & 4096) == 4096) {
                GeneratedMessageV3.writeString(codedOutputStream, 36, this.objcClassPrefix_);
            }
            if ((this.bitField0_ & 8192) == 8192) {
                GeneratedMessageV3.writeString(codedOutputStream, 37, this.csharpNamespace_);
            }
            for (int i10 = 0; i10 < this.uninterpretedOption_.size(); i10++) {
                codedOutputStream.A0(999, this.uninterpretedOption_.get(i10));
            }
            g10.a(536870912, codedOutputStream);
            this.unknownFields.writeTo(codedOutputStream);
        }

        /* synthetic */ FileOptions(GeneratedMessageV3.d dVar, a aVar) {
            this(dVar);
        }

        public static b newBuilder(FileOptions fileOptions) {
            return DEFAULT_INSTANCE.toBuilder().A(fileOptions);
        }

        public static FileOptions parseFrom(ByteString byteString, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, qVar);
        }

        private FileOptions(GeneratedMessageV3.d<FileOptions, ?> dVar) {
            super(dVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static FileOptions parseDelimitedFrom(InputStream inputStream, com.google.protobuf.q qVar) throws IOException {
            return (FileOptions) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
        }

        public static FileOptions parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessage, com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
        public FileOptions getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessage, com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b toBuilder() {
            return this == DEFAULT_INSTANCE ? new b((a) null) : new b((a) null).A(this);
        }

        public static FileOptions parseFrom(byte[] bArr, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessage, com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b newBuilderForType() {
            return newBuilder();
        }

        private FileOptions() {
            this.memoizedIsInitialized = (byte) -1;
            this.javaPackage_ = "";
            this.javaOuterClassname_ = "";
            this.javaMultipleFiles_ = false;
            this.javaGenerateEqualsAndHash_ = false;
            this.javaStringCheckUtf8_ = false;
            this.optimizeFor_ = 1;
            this.goPackage_ = "";
            this.ccGenericServices_ = false;
            this.javaGenericServices_ = false;
            this.pyGenericServices_ = false;
            this.deprecated_ = false;
            this.ccEnableArenas_ = false;
            this.objcClassPrefix_ = "";
            this.csharpNamespace_ = "";
            this.uninterpretedOption_ = Collections.emptyList();
        }

        public static FileOptions parseFrom(InputStream inputStream) throws IOException {
            return (FileOptions) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static FileOptions parseFrom(InputStream inputStream, com.google.protobuf.q qVar) throws IOException {
            return (FileOptions) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
        }

        public static FileOptions parseFrom(com.google.protobuf.i iVar) throws IOException {
            return (FileOptions) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
        }

        public static FileOptions parseFrom(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws IOException {
            return (FileOptions) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v0 */
        /* JADX WARN: Type inference failed for: r3v1 */
        /* JADX WARN: Type inference failed for: r3v2, types: [boolean] */
        private FileOptions(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
            this();
            a1.b g10 = a1.g();
            boolean z10 = false;
            boolean z11 = false;
            while (true) {
                ?? r32 = 16384;
                if (!z10) {
                    try {
                        try {
                            try {
                                int F = iVar.F();
                                switch (F) {
                                    case 0:
                                        break;
                                    case 10:
                                        ByteString m10 = iVar.m();
                                        this.bitField0_ = 1 | this.bitField0_;
                                        this.javaPackage_ = m10;
                                        continue;
                                    case 66:
                                        ByteString m11 = iVar.m();
                                        this.bitField0_ |= 2;
                                        this.javaOuterClassname_ = m11;
                                        continue;
                                    case 72:
                                        int o10 = iVar.o();
                                        if (OptimizeMode.valueOf(o10) == null) {
                                            g10.q(9, o10);
                                            continue;
                                        } else {
                                            this.bitField0_ |= 32;
                                            this.optimizeFor_ = o10;
                                        }
                                    case 80:
                                        this.bitField0_ |= 4;
                                        this.javaMultipleFiles_ = iVar.l();
                                        continue;
                                    case 90:
                                        ByteString m12 = iVar.m();
                                        this.bitField0_ |= 64;
                                        this.goPackage_ = m12;
                                        continue;
                                    case 128:
                                        this.bitField0_ |= 128;
                                        this.ccGenericServices_ = iVar.l();
                                        continue;
                                    case 136:
                                        this.bitField0_ |= 256;
                                        this.javaGenericServices_ = iVar.l();
                                        continue;
                                    case 144:
                                        this.bitField0_ |= 512;
                                        this.pyGenericServices_ = iVar.l();
                                        continue;
                                    case 160:
                                        this.bitField0_ |= 8;
                                        this.javaGenerateEqualsAndHash_ = iVar.l();
                                        continue;
                                    case 184:
                                        this.bitField0_ |= 1024;
                                        this.deprecated_ = iVar.l();
                                        continue;
                                    case 216:
                                        this.bitField0_ |= 16;
                                        this.javaStringCheckUtf8_ = iVar.l();
                                        continue;
                                    case 248:
                                        this.bitField0_ |= 2048;
                                        this.ccEnableArenas_ = iVar.l();
                                        continue;
                                    case 290:
                                        ByteString m13 = iVar.m();
                                        this.bitField0_ |= 4096;
                                        this.objcClassPrefix_ = m13;
                                        continue;
                                    case 298:
                                        ByteString m14 = iVar.m();
                                        this.bitField0_ |= 8192;
                                        this.csharpNamespace_ = m14;
                                        continue;
                                    case 7994:
                                        if (!(z11 & true)) {
                                            this.uninterpretedOption_ = new ArrayList();
                                            z11 |= true;
                                        }
                                        this.uninterpretedOption_.add(iVar.v(UninterpretedOption.PARSER, qVar));
                                        continue;
                                    default:
                                        r32 = parseUnknownField(iVar, g10, qVar, F);
                                        if (r32 == 0) {
                                            break;
                                        } else {
                                            continue;
                                        }
                                }
                                z10 = true;
                            } catch (InvalidProtocolBufferException e10) {
                                throw e10.setUnfinishedMessage(this);
                            }
                        } catch (IOException e11) {
                            throw new InvalidProtocolBufferException(e11).setUnfinishedMessage(this);
                        }
                    } finally {
                        if ((z11 & true) == r32) {
                            this.uninterpretedOption_ = Collections.unmodifiableList(this.uninterpretedOption_);
                        }
                        this.unknownFields = g10.build();
                        makeExtensionsImmutable();
                    }
                } else {
                    return;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class GeneratedCodeInfo extends GeneratedMessageV3 implements g0 {
        public static final int ANNOTATION_FIELD_NUMBER = 1;
        private static final GeneratedCodeInfo DEFAULT_INSTANCE = new GeneratedCodeInfo();
        @Deprecated
        public static final l0<GeneratedCodeInfo> PARSER = new a();
        private static final long serialVersionUID = 0;
        private List<Annotation> annotation_;
        private byte memoizedIsInitialized;

        /* loaded from: classes.dex */
        public static final class Annotation extends GeneratedMessageV3 implements b {
            public static final int BEGIN_FIELD_NUMBER = 3;
            public static final int END_FIELD_NUMBER = 4;
            public static final int PATH_FIELD_NUMBER = 1;
            public static final int SOURCE_FILE_FIELD_NUMBER = 2;
            private static final long serialVersionUID = 0;
            private int begin_;
            private int bitField0_;
            private int end_;
            private byte memoizedIsInitialized;
            private int pathMemoizedSerializedSize;
            private List<Integer> path_;
            private volatile Object sourceFile_;
            private static final Annotation DEFAULT_INSTANCE = new Annotation();
            @Deprecated
            public static final l0<Annotation> PARSER = new a();

            /* loaded from: classes.dex */
            static class a extends com.google.protobuf.c<Annotation> {
                a() {
                }

                /* renamed from: a */
                public Annotation parsePartialFrom(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
                    return new Annotation(iVar, qVar, null);
                }
            }

            /* loaded from: classes.dex */
            public static final class b extends GeneratedMessageV3.b<b> implements b {

                /* renamed from: a  reason: collision with root package name */
                private int f12853a;

                /* renamed from: b  reason: collision with root package name */
                private List<Integer> f12854b;

                /* renamed from: c  reason: collision with root package name */
                private Object f12855c;

                /* renamed from: d  reason: collision with root package name */
                private int f12856d;

                /* renamed from: e  reason: collision with root package name */
                private int f12857e;

                /* synthetic */ b(a aVar) {
                    this();
                }

                private void i() {
                    if ((this.f12853a & 1) != 1) {
                        this.f12854b = new ArrayList(this.f12854b);
                        this.f12853a |= 1;
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
                public Annotation build() {
                    Annotation c10 = buildPartial();
                    if (c10.isInitialized()) {
                        return c10;
                    }
                    throw a.AbstractC0170a.newUninitializedMessageException((d0) c10);
                }

                /* renamed from: c */
                public Annotation buildPartial() {
                    Annotation annotation = new Annotation(this, (a) null);
                    int i10 = this.f12853a;
                    int i11 = 1;
                    if ((i10 & 1) == 1) {
                        this.f12854b = Collections.unmodifiableList(this.f12854b);
                        this.f12853a &= -2;
                    }
                    annotation.path_ = this.f12854b;
                    if ((i10 & 2) != 2) {
                        i11 = 0;
                    }
                    annotation.sourceFile_ = this.f12855c;
                    if ((i10 & 4) == 4) {
                        i11 |= 2;
                    }
                    annotation.begin_ = this.f12856d;
                    if ((i10 & 8) == 8) {
                        i11 |= 4;
                    }
                    annotation.end_ = this.f12857e;
                    annotation.bitField0_ = i11;
                    onBuilt();
                    return annotation;
                }

                /* renamed from: d */
                public b clear() {
                    super.clear();
                    this.f12854b = Collections.emptyList();
                    int i10 = this.f12853a & (-2);
                    this.f12853a = i10;
                    this.f12855c = "";
                    int i11 = i10 & (-3);
                    this.f12853a = i11;
                    this.f12856d = 0;
                    int i12 = i11 & (-5);
                    this.f12853a = i12;
                    this.f12857e = 0;
                    this.f12853a = i12 & (-9);
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
                    return DescriptorProtos.W;
                }

                @Override // com.google.protobuf.GeneratedMessageV3.b
                protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                    return DescriptorProtos.X.e(Annotation.class, b.class);
                }

                @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.f0
                public final boolean isInitialized() {
                    return true;
                }

                /* renamed from: j */
                public Annotation getDefaultInstanceForType() {
                    return Annotation.getDefaultInstance();
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0021  */
                /* renamed from: k */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public b mergeFrom(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws IOException {
                    Throwable th2;
                    Annotation annotation = null;
                    try {
                        try {
                            Annotation parsePartialFrom = Annotation.PARSER.parsePartialFrom(iVar, qVar);
                            if (parsePartialFrom != null) {
                                l(parsePartialFrom);
                            }
                            return this;
                        } catch (InvalidProtocolBufferException e10) {
                            annotation = (Annotation) e10.getUnfinishedMessage();
                            try {
                                throw e10.unwrapIOException();
                            } catch (Throwable th3) {
                                th2 = th3;
                                if (annotation != null) {
                                    l(annotation);
                                }
                                throw th2;
                            }
                        }
                    } catch (Throwable th4) {
                        th2 = th4;
                        if (annotation != null) {
                        }
                        throw th2;
                    }
                }

                public b l(Annotation annotation) {
                    if (annotation == Annotation.getDefaultInstance()) {
                        return this;
                    }
                    if (!annotation.path_.isEmpty()) {
                        if (this.f12854b.isEmpty()) {
                            this.f12854b = annotation.path_;
                            this.f12853a &= -2;
                        } else {
                            i();
                            this.f12854b.addAll(annotation.path_);
                        }
                        onChanged();
                    }
                    if (annotation.hasSourceFile()) {
                        this.f12853a |= 2;
                        this.f12855c = annotation.sourceFile_;
                        onChanged();
                    }
                    if (annotation.hasBegin()) {
                        o(annotation.getBegin());
                    }
                    if (annotation.hasEnd()) {
                        p(annotation.getEnd());
                    }
                    mergeUnknownFields(annotation.unknownFields);
                    onChanged();
                    return this;
                }

                /* renamed from: m */
                public b mergeFrom(d0 d0Var) {
                    if (d0Var instanceof Annotation) {
                        return l((Annotation) d0Var);
                    }
                    super.mergeFrom(d0Var);
                    return this;
                }

                /* renamed from: n */
                public final b mergeUnknownFields(a1 a1Var) {
                    return (b) super.mergeUnknownFields(a1Var);
                }

                public b o(int i10) {
                    this.f12853a |= 4;
                    this.f12856d = i10;
                    onChanged();
                    return this;
                }

                public b p(int i10) {
                    this.f12853a |= 8;
                    this.f12857e = i10;
                    onChanged();
                    return this;
                }

                /* renamed from: q */
                public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                    return (b) super.setField(fieldDescriptor, obj);
                }

                /* renamed from: r */
                public b setRepeatedField2(Descriptors.FieldDescriptor fieldDescriptor, int i10, Object obj) {
                    return (b) super.setRepeatedField(fieldDescriptor, i10, obj);
                }

                /* renamed from: s */
                public final b setUnknownFields(a1 a1Var) {
                    return (b) super.setUnknownFields(a1Var);
                }

                /* synthetic */ b(GeneratedMessageV3.c cVar, a aVar) {
                    this(cVar);
                }

                private b() {
                    this.f12854b = Collections.emptyList();
                    this.f12855c = "";
                    maybeForceBuilderInitialization();
                }

                private b(GeneratedMessageV3.c cVar) {
                    super(cVar);
                    this.f12854b = Collections.emptyList();
                    this.f12855c = "";
                    maybeForceBuilderInitialization();
                }
            }

            /* synthetic */ Annotation(com.google.protobuf.i iVar, com.google.protobuf.q qVar, a aVar) throws InvalidProtocolBufferException {
                this(iVar, qVar);
            }

            public static Annotation getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static final Descriptors.b getDescriptor() {
                return DescriptorProtos.W;
            }

            public static b newBuilder() {
                return DEFAULT_INSTANCE.toBuilder();
            }

            public static Annotation parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (Annotation) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
            }

            public static Annotation parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteString);
            }

            public static l0<Annotation> parser() {
                return PARSER;
            }

            @Override // com.google.protobuf.a
            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof Annotation)) {
                    return super.equals(obj);
                }
                Annotation annotation = (Annotation) obj;
                boolean z10 = (getPathList().equals(annotation.getPathList())) && hasSourceFile() == annotation.hasSourceFile();
                if (hasSourceFile()) {
                    z10 = z10 && getSourceFile().equals(annotation.getSourceFile());
                }
                boolean z11 = z10 && hasBegin() == annotation.hasBegin();
                if (hasBegin()) {
                    z11 = z11 && getBegin() == annotation.getBegin();
                }
                boolean z12 = z11 && hasEnd() == annotation.hasEnd();
                if (hasEnd()) {
                    z12 = z12 && getEnd() == annotation.getEnd();
                }
                return z12 && this.unknownFields.equals(annotation.unknownFields);
            }

            public int getBegin() {
                return this.begin_;
            }

            public int getEnd() {
                return this.end_;
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
            public l0<Annotation> getParserForType() {
                return PARSER;
            }

            public int getPath(int i10) {
                return this.path_.get(i10).intValue();
            }

            public int getPathCount() {
                return this.path_.size();
            }

            public List<Integer> getPathList() {
                return this.path_;
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
            public int getSerializedSize() {
                int i10 = this.memoizedSize;
                if (i10 != -1) {
                    return i10;
                }
                int i11 = 0;
                for (int i12 = 0; i12 < this.path_.size(); i12++) {
                    i11 += CodedOutputStream.w(this.path_.get(i12).intValue());
                }
                int i13 = 0 + i11;
                if (!getPathList().isEmpty()) {
                    i13 = i13 + 1 + CodedOutputStream.w(i11);
                }
                this.pathMemoizedSerializedSize = i11;
                if ((this.bitField0_ & 1) == 1) {
                    i13 += GeneratedMessageV3.computeStringSize(2, this.sourceFile_);
                }
                if ((this.bitField0_ & 2) == 2) {
                    i13 += CodedOutputStream.v(3, this.begin_);
                }
                if ((this.bitField0_ & 4) == 4) {
                    i13 += CodedOutputStream.v(4, this.end_);
                }
                int serializedSize = i13 + this.unknownFields.getSerializedSize();
                this.memoizedSize = serializedSize;
                return serializedSize;
            }

            public String getSourceFile() {
                Object obj = this.sourceFile_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                ByteString byteString = (ByteString) obj;
                String stringUtf8 = byteString.toStringUtf8();
                if (byteString.isValidUtf8()) {
                    this.sourceFile_ = stringUtf8;
                }
                return stringUtf8;
            }

            public ByteString getSourceFileBytes() {
                Object obj = this.sourceFile_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.sourceFile_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.g0
            public final a1 getUnknownFields() {
                return this.unknownFields;
            }

            public boolean hasBegin() {
                return (this.bitField0_ & 2) == 2;
            }

            public boolean hasEnd() {
                return (this.bitField0_ & 4) == 4;
            }

            public boolean hasSourceFile() {
                return (this.bitField0_ & 1) == 1;
            }

            @Override // com.google.protobuf.a
            public int hashCode() {
                int i10 = this.memoizedHashCode;
                if (i10 != 0) {
                    return i10;
                }
                int hashCode = 779 + getDescriptorForType().hashCode();
                if (getPathCount() > 0) {
                    hashCode = (((hashCode * 37) + 1) * 53) + getPathList().hashCode();
                }
                if (hasSourceFile()) {
                    hashCode = (((hashCode * 37) + 2) * 53) + getSourceFile().hashCode();
                }
                if (hasBegin()) {
                    hashCode = (((hashCode * 37) + 3) * 53) + getBegin();
                }
                if (hasEnd()) {
                    hashCode = (((hashCode * 37) + 4) * 53) + getEnd();
                }
                int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
                this.memoizedHashCode = hashCode2;
                return hashCode2;
            }

            @Override // com.google.protobuf.GeneratedMessageV3
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return DescriptorProtos.X.e(Annotation.class, b.class);
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

            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: j */
            public b newBuilderForType(GeneratedMessageV3.c cVar) {
                return new b(cVar, null);
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
            public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                getSerializedSize();
                if (getPathList().size() > 0) {
                    codedOutputStream.N0(10);
                    codedOutputStream.N0(this.pathMemoizedSerializedSize);
                }
                for (int i10 = 0; i10 < this.path_.size(); i10++) {
                    codedOutputStream.x0(this.path_.get(i10).intValue());
                }
                if ((this.bitField0_ & 1) == 1) {
                    GeneratedMessageV3.writeString(codedOutputStream, 2, this.sourceFile_);
                }
                if ((this.bitField0_ & 2) == 2) {
                    codedOutputStream.w0(3, this.begin_);
                }
                if ((this.bitField0_ & 4) == 4) {
                    codedOutputStream.w0(4, this.end_);
                }
                this.unknownFields.writeTo(codedOutputStream);
            }

            /* synthetic */ Annotation(GeneratedMessageV3.b bVar, a aVar) {
                this(bVar);
            }

            public static b newBuilder(Annotation annotation) {
                return DEFAULT_INSTANCE.toBuilder().l(annotation);
            }

            public static Annotation parseFrom(ByteString byteString, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteString, qVar);
            }

            private Annotation(GeneratedMessageV3.b<?> bVar) {
                super(bVar);
                this.pathMemoizedSerializedSize = -1;
                this.memoizedIsInitialized = (byte) -1;
            }

            public static Annotation parseDelimitedFrom(InputStream inputStream, com.google.protobuf.q qVar) throws IOException {
                return (Annotation) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
            }

            public static Annotation parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(bArr);
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
            public Annotation getDefaultInstanceForType() {
                return DEFAULT_INSTANCE;
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
            public b toBuilder() {
                return this == DEFAULT_INSTANCE ? new b((a) null) : new b((a) null).l(this);
            }

            public static Annotation parseFrom(byte[] bArr, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(bArr, qVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
            public b newBuilderForType() {
                return newBuilder();
            }

            public static Annotation parseFrom(InputStream inputStream) throws IOException {
                return (Annotation) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
            }

            private Annotation() {
                this.pathMemoizedSerializedSize = -1;
                this.memoizedIsInitialized = (byte) -1;
                this.path_ = Collections.emptyList();
                this.sourceFile_ = "";
                this.begin_ = 0;
                this.end_ = 0;
            }

            public static Annotation parseFrom(InputStream inputStream, com.google.protobuf.q qVar) throws IOException {
                return (Annotation) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
            }

            public static Annotation parseFrom(com.google.protobuf.i iVar) throws IOException {
                return (Annotation) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
            }

            public static Annotation parseFrom(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws IOException {
                return (Annotation) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
            }

            private Annotation(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
                this();
                a1.b g10 = a1.g();
                boolean z10 = false;
                boolean z11 = false;
                while (true) {
                    if (z10) {
                        break;
                    }
                    try {
                        try {
                            int F = iVar.F();
                            if (F != 0) {
                                if (F == 8) {
                                    if (!z11 || !true) {
                                        this.path_ = new ArrayList();
                                        z11 |= true;
                                    }
                                    this.path_.add(Integer.valueOf(iVar.t()));
                                } else if (F == 10) {
                                    int k10 = iVar.k(iVar.x());
                                    if ((!z11 || !true) && iVar.d() > 0) {
                                        this.path_ = new ArrayList();
                                        z11 |= true;
                                    }
                                    while (iVar.d() > 0) {
                                        this.path_.add(Integer.valueOf(iVar.t()));
                                    }
                                    iVar.j(k10);
                                } else if (F == 18) {
                                    ByteString m10 = iVar.m();
                                    this.bitField0_ |= 1;
                                    this.sourceFile_ = m10;
                                } else if (F == 24) {
                                    this.bitField0_ |= 2;
                                    this.begin_ = iVar.t();
                                } else if (F == 32) {
                                    this.bitField0_ |= 4;
                                    this.end_ = iVar.t();
                                } else if (!parseUnknownField(iVar, g10, qVar, F)) {
                                }
                            }
                            z10 = true;
                        } catch (InvalidProtocolBufferException e10) {
                            throw e10.setUnfinishedMessage(this);
                        } catch (IOException e11) {
                            throw new InvalidProtocolBufferException(e11).setUnfinishedMessage(this);
                        }
                    } finally {
                        if (z11 && true) {
                            this.path_ = Collections.unmodifiableList(this.path_);
                        }
                        this.unknownFields = g10.build();
                        makeExtensionsImmutable();
                    }
                }
            }
        }

        /* loaded from: classes.dex */
        static class a extends com.google.protobuf.c<GeneratedCodeInfo> {
            a() {
            }

            /* renamed from: a */
            public GeneratedCodeInfo parsePartialFrom(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
                return new GeneratedCodeInfo(iVar, qVar, null);
            }
        }

        /* loaded from: classes.dex */
        public interface b extends g0 {
        }

        /* loaded from: classes.dex */
        public static final class c extends GeneratedMessageV3.b<c> implements g0 {

            /* renamed from: a  reason: collision with root package name */
            private int f12858a;

            /* renamed from: b  reason: collision with root package name */
            private List<Annotation> f12859b;

            /* renamed from: c  reason: collision with root package name */
            private o0<Annotation, Annotation.b, b> f12860c;

            /* synthetic */ c(a aVar) {
                this();
            }

            private void i() {
                if ((this.f12858a & 1) != 1) {
                    this.f12859b = new ArrayList(this.f12859b);
                    this.f12858a |= 1;
                }
            }

            private o0<Annotation, Annotation.b, b> j() {
                if (this.f12860c == null) {
                    List<Annotation> list = this.f12859b;
                    boolean z10 = true;
                    if ((this.f12858a & 1) != 1) {
                        z10 = false;
                    }
                    this.f12860c = new o0<>(list, z10, getParentForChildren(), isClean());
                    this.f12859b = null;
                }
                return this.f12860c;
            }

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                    j();
                }
            }

            /* renamed from: a */
            public c addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (c) super.addRepeatedField(fieldDescriptor, obj);
            }

            /* renamed from: b */
            public GeneratedCodeInfo build() {
                GeneratedCodeInfo c10 = buildPartial();
                if (c10.isInitialized()) {
                    return c10;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) c10);
            }

            /* renamed from: c */
            public GeneratedCodeInfo buildPartial() {
                GeneratedCodeInfo generatedCodeInfo = new GeneratedCodeInfo(this, (a) null);
                int i10 = this.f12858a;
                o0<Annotation, Annotation.b, b> o0Var = this.f12860c;
                if (o0Var == null) {
                    if ((i10 & 1) == 1) {
                        this.f12859b = Collections.unmodifiableList(this.f12859b);
                        this.f12858a &= -2;
                    }
                    generatedCodeInfo.annotation_ = this.f12859b;
                } else {
                    generatedCodeInfo.annotation_ = o0Var.g();
                }
                onBuilt();
                return generatedCodeInfo;
            }

            /* renamed from: d */
            public c clear() {
                super.clear();
                o0<Annotation, Annotation.b, b> o0Var = this.f12860c;
                if (o0Var == null) {
                    this.f12859b = Collections.emptyList();
                    this.f12858a &= -2;
                } else {
                    o0Var.h();
                }
                return this;
            }

            /* renamed from: e */
            public c clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (c) super.clearField(fieldDescriptor);
            }

            /* renamed from: f */
            public c clearOneof(Descriptors.h hVar) {
                return (c) super.clearOneof(hVar);
            }

            /* renamed from: g */
            public c clone() {
                return (c) super.clone();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a, com.google.protobuf.g0
            public Descriptors.b getDescriptorForType() {
                return DescriptorProtos.U;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return DescriptorProtos.V.e(GeneratedCodeInfo.class, c.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.f0
            public final boolean isInitialized() {
                return true;
            }

            /* renamed from: k */
            public GeneratedCodeInfo getDefaultInstanceForType() {
                return GeneratedCodeInfo.getDefaultInstance();
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x0021  */
            /* renamed from: l */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public c mergeFrom(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws IOException {
                Throwable th2;
                GeneratedCodeInfo generatedCodeInfo = null;
                try {
                    try {
                        GeneratedCodeInfo parsePartialFrom = GeneratedCodeInfo.PARSER.parsePartialFrom(iVar, qVar);
                        if (parsePartialFrom != null) {
                            m(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e10) {
                        generatedCodeInfo = (GeneratedCodeInfo) e10.getUnfinishedMessage();
                        try {
                            throw e10.unwrapIOException();
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (generatedCodeInfo != null) {
                                m(generatedCodeInfo);
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (generatedCodeInfo != null) {
                    }
                    throw th2;
                }
            }

            public c m(GeneratedCodeInfo generatedCodeInfo) {
                if (generatedCodeInfo == GeneratedCodeInfo.getDefaultInstance()) {
                    return this;
                }
                if (this.f12860c == null) {
                    if (!generatedCodeInfo.annotation_.isEmpty()) {
                        if (this.f12859b.isEmpty()) {
                            this.f12859b = generatedCodeInfo.annotation_;
                            this.f12858a &= -2;
                        } else {
                            i();
                            this.f12859b.addAll(generatedCodeInfo.annotation_);
                        }
                        onChanged();
                    }
                } else if (!generatedCodeInfo.annotation_.isEmpty()) {
                    if (this.f12860c.u()) {
                        this.f12860c.i();
                        o0<Annotation, Annotation.b, b> o0Var = null;
                        this.f12860c = null;
                        this.f12859b = generatedCodeInfo.annotation_;
                        this.f12858a &= -2;
                        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                            o0Var = j();
                        }
                        this.f12860c = o0Var;
                    } else {
                        this.f12860c.b(generatedCodeInfo.annotation_);
                    }
                }
                mergeUnknownFields(generatedCodeInfo.unknownFields);
                onChanged();
                return this;
            }

            /* renamed from: n */
            public c mergeFrom(d0 d0Var) {
                if (d0Var instanceof GeneratedCodeInfo) {
                    return m((GeneratedCodeInfo) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            /* renamed from: o */
            public final c mergeUnknownFields(a1 a1Var) {
                return (c) super.mergeUnknownFields(a1Var);
            }

            /* renamed from: p */
            public c setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (c) super.setField(fieldDescriptor, obj);
            }

            /* renamed from: q */
            public c setRepeatedField2(Descriptors.FieldDescriptor fieldDescriptor, int i10, Object obj) {
                return (c) super.setRepeatedField(fieldDescriptor, i10, obj);
            }

            /* renamed from: r */
            public final c setUnknownFields(a1 a1Var) {
                return (c) super.setUnknownFields(a1Var);
            }

            /* synthetic */ c(GeneratedMessageV3.c cVar, a aVar) {
                this(cVar);
            }

            private c() {
                this.f12859b = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private c(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.f12859b = Collections.emptyList();
                maybeForceBuilderInitialization();
            }
        }

        /* synthetic */ GeneratedCodeInfo(com.google.protobuf.i iVar, com.google.protobuf.q qVar, a aVar) throws InvalidProtocolBufferException {
            this(iVar, qVar);
        }

        public static GeneratedCodeInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return DescriptorProtos.U;
        }

        public static c newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static GeneratedCodeInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (GeneratedCodeInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static GeneratedCodeInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static l0<GeneratedCodeInfo> parser() {
            return PARSER;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: c */
        public c newBuilderForType(GeneratedMessageV3.c cVar) {
            return new c(cVar, null);
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof GeneratedCodeInfo)) {
                return super.equals(obj);
            }
            GeneratedCodeInfo generatedCodeInfo = (GeneratedCodeInfo) obj;
            return (getAnnotationList().equals(generatedCodeInfo.getAnnotationList())) && this.unknownFields.equals(generatedCodeInfo.unknownFields);
        }

        public Annotation getAnnotation(int i10) {
            return this.annotation_.get(i10);
        }

        public int getAnnotationCount() {
            return this.annotation_.size();
        }

        public List<Annotation> getAnnotationList() {
            return this.annotation_;
        }

        public b getAnnotationOrBuilder(int i10) {
            return this.annotation_.get(i10);
        }

        public List<? extends b> getAnnotationOrBuilderList() {
            return this.annotation_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public l0<GeneratedCodeInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
        public int getSerializedSize() {
            int i10 = this.memoizedSize;
            if (i10 != -1) {
                return i10;
            }
            int i11 = 0;
            for (int i12 = 0; i12 < this.annotation_.size(); i12++) {
                i11 += CodedOutputStream.E(1, this.annotation_.get(i12));
            }
            int serializedSize = i11 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.g0
        public final a1 getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.google.protobuf.a
        public int hashCode() {
            int i10 = this.memoizedHashCode;
            if (i10 != 0) {
                return i10;
            }
            int hashCode = 779 + getDescriptorForType().hashCode();
            if (getAnnotationCount() > 0) {
                hashCode = (((hashCode * 37) + 1) * 53) + getAnnotationList().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return DescriptorProtos.V.e(GeneratedCodeInfo.class, c.class);
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
            for (int i10 = 0; i10 < this.annotation_.size(); i10++) {
                codedOutputStream.A0(1, this.annotation_.get(i10));
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        /* synthetic */ GeneratedCodeInfo(GeneratedMessageV3.b bVar, a aVar) {
            this(bVar);
        }

        public static c newBuilder(GeneratedCodeInfo generatedCodeInfo) {
            return DEFAULT_INSTANCE.toBuilder().m(generatedCodeInfo);
        }

        public static GeneratedCodeInfo parseFrom(ByteString byteString, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, qVar);
        }

        private GeneratedCodeInfo(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static GeneratedCodeInfo parseDelimitedFrom(InputStream inputStream, com.google.protobuf.q qVar) throws IOException {
            return (GeneratedCodeInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
        }

        public static GeneratedCodeInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
        public GeneratedCodeInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public c toBuilder() {
            return this == DEFAULT_INSTANCE ? new c((a) null) : new c((a) null).m(this);
        }

        public static GeneratedCodeInfo parseFrom(byte[] bArr, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public c newBuilderForType() {
            return newBuilder();
        }

        private GeneratedCodeInfo() {
            this.memoizedIsInitialized = (byte) -1;
            this.annotation_ = Collections.emptyList();
        }

        public static GeneratedCodeInfo parseFrom(InputStream inputStream) throws IOException {
            return (GeneratedCodeInfo) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static GeneratedCodeInfo parseFrom(InputStream inputStream, com.google.protobuf.q qVar) throws IOException {
            return (GeneratedCodeInfo) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private GeneratedCodeInfo(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
            this();
            a1.b g10 = a1.g();
            boolean z10 = false;
            boolean z11 = false;
            while (true) {
                if (z10) {
                    break;
                }
                try {
                    try {
                        int F = iVar.F();
                        if (F != 0) {
                            if (F == 10) {
                                if (!z11 || !true) {
                                    this.annotation_ = new ArrayList();
                                    z11 |= true;
                                }
                                this.annotation_.add(iVar.v(Annotation.PARSER, qVar));
                            } else if (!parseUnknownField(iVar, g10, qVar, F)) {
                            }
                        }
                        z10 = true;
                    } catch (InvalidProtocolBufferException e10) {
                        throw e10.setUnfinishedMessage(this);
                    } catch (IOException e11) {
                        throw new InvalidProtocolBufferException(e11).setUnfinishedMessage(this);
                    }
                } finally {
                    if (z11 && true) {
                        this.annotation_ = Collections.unmodifiableList(this.annotation_);
                    }
                    this.unknownFields = g10.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static GeneratedCodeInfo parseFrom(com.google.protobuf.i iVar) throws IOException {
            return (GeneratedCodeInfo) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
        }

        public static GeneratedCodeInfo parseFrom(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws IOException {
            return (GeneratedCodeInfo) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
        }
    }

    /* loaded from: classes.dex */
    public static final class MessageOptions extends GeneratedMessageV3.ExtendableMessage<MessageOptions> implements k {
        public static final int DEPRECATED_FIELD_NUMBER = 3;
        public static final int MAP_ENTRY_FIELD_NUMBER = 7;
        public static final int MESSAGE_SET_WIRE_FORMAT_FIELD_NUMBER = 1;
        public static final int NO_STANDARD_DESCRIPTOR_ACCESSOR_FIELD_NUMBER = 2;
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private boolean deprecated_;
        private boolean mapEntry_;
        private byte memoizedIsInitialized;
        private boolean messageSetWireFormat_;
        private boolean noStandardDescriptorAccessor_;
        private List<UninterpretedOption> uninterpretedOption_;
        private static final MessageOptions DEFAULT_INSTANCE = new MessageOptions();
        @Deprecated
        public static final l0<MessageOptions> PARSER = new a();

        /* loaded from: classes.dex */
        static class a extends com.google.protobuf.c<MessageOptions> {
            a() {
            }

            /* renamed from: a */
            public MessageOptions parsePartialFrom(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
                return new MessageOptions(iVar, qVar, null);
            }
        }

        /* loaded from: classes.dex */
        public static final class b extends GeneratedMessageV3.d<MessageOptions, b> implements k {

            /* renamed from: b  reason: collision with root package name */
            private int f12861b;

            /* renamed from: c  reason: collision with root package name */
            private boolean f12862c;

            /* renamed from: d  reason: collision with root package name */
            private boolean f12863d;

            /* renamed from: e  reason: collision with root package name */
            private boolean f12864e;

            /* renamed from: f  reason: collision with root package name */
            private boolean f12865f;

            /* renamed from: g  reason: collision with root package name */
            private List<UninterpretedOption> f12866g;

            /* renamed from: h  reason: collision with root package name */
            private o0<UninterpretedOption, UninterpretedOption.b, s> f12867h;

            /* synthetic */ b(a aVar) {
                this();
            }

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                    y();
                }
            }

            private void u() {
                if ((this.f12861b & 16) != 16) {
                    this.f12866g = new ArrayList(this.f12866g);
                    this.f12861b |= 16;
                }
            }

            private o0<UninterpretedOption, UninterpretedOption.b, s> y() {
                if (this.f12867h == null) {
                    this.f12867h = new o0<>(this.f12866g, (this.f12861b & 16) == 16, getParentForChildren(), isClean());
                    this.f12866g = null;
                }
                return this.f12867h;
            }

            public b A(MessageOptions messageOptions) {
                if (messageOptions == MessageOptions.getDefaultInstance()) {
                    return this;
                }
                if (messageOptions.hasMessageSetWireFormat()) {
                    G(messageOptions.getMessageSetWireFormat());
                }
                if (messageOptions.hasNoStandardDescriptorAccessor()) {
                    H(messageOptions.getNoStandardDescriptorAccessor());
                }
                if (messageOptions.hasDeprecated()) {
                    D(messageOptions.getDeprecated());
                }
                if (messageOptions.hasMapEntry()) {
                    F(messageOptions.getMapEntry());
                }
                if (this.f12867h == null) {
                    if (!messageOptions.uninterpretedOption_.isEmpty()) {
                        if (this.f12866g.isEmpty()) {
                            this.f12866g = messageOptions.uninterpretedOption_;
                            this.f12861b &= -17;
                        } else {
                            u();
                            this.f12866g.addAll(messageOptions.uninterpretedOption_);
                        }
                        onChanged();
                    }
                } else if (!messageOptions.uninterpretedOption_.isEmpty()) {
                    if (this.f12867h.u()) {
                        this.f12867h.i();
                        o0<UninterpretedOption, UninterpretedOption.b, s> o0Var = null;
                        this.f12867h = null;
                        this.f12866g = messageOptions.uninterpretedOption_;
                        this.f12861b &= -17;
                        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                            o0Var = y();
                        }
                        this.f12867h = o0Var;
                    } else {
                        this.f12867h.b(messageOptions.uninterpretedOption_);
                    }
                }
                j(messageOptions);
                mergeUnknownFields(messageOptions.unknownFields);
                onChanged();
                return this;
            }

            /* renamed from: B */
            public b mergeFrom(d0 d0Var) {
                if (d0Var instanceof MessageOptions) {
                    return A((MessageOptions) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            /* renamed from: C */
            public final b mergeUnknownFields(a1 a1Var) {
                return (b) super.mergeUnknownFields(a1Var);
            }

            public b D(boolean z10) {
                this.f12861b |= 4;
                this.f12864e = z10;
                onChanged();
                return this;
            }

            /* renamed from: E */
            public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.setField(fieldDescriptor, obj);
            }

            public b F(boolean z10) {
                this.f12861b |= 8;
                this.f12865f = z10;
                onChanged();
                return this;
            }

            public b G(boolean z10) {
                this.f12861b |= 1;
                this.f12862c = z10;
                onChanged();
                return this;
            }

            public b H(boolean z10) {
                this.f12861b |= 2;
                this.f12863d = z10;
                onChanged();
                return this;
            }

            /* renamed from: I */
            public b setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i10, Object obj) {
                return (b) super.setRepeatedField(fieldDescriptor, i10, obj);
            }

            /* renamed from: J */
            public final b setUnknownFields(a1 a1Var) {
                return (b) super.setUnknownFields(a1Var);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a, com.google.protobuf.g0
            public Descriptors.b getDescriptorForType() {
                return DescriptorProtos.f12746y;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return DescriptorProtos.f12747z.e(MessageOptions.class, b.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.d, com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.f0
            public final boolean isInitialized() {
                for (int i10 = 0; i10 < x(); i10++) {
                    if (!w(i10).isInitialized()) {
                        return false;
                    }
                }
                return i();
            }

            /* renamed from: n */
            public b b(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.addRepeatedField(fieldDescriptor, obj);
            }

            /* renamed from: o */
            public MessageOptions build() {
                MessageOptions p10 = buildPartial();
                if (p10.isInitialized()) {
                    return p10;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) p10);
            }

            /* renamed from: p */
            public MessageOptions buildPartial() {
                MessageOptions messageOptions = new MessageOptions(this, (a) null);
                int i10 = this.f12861b;
                int i11 = 1;
                if ((i10 & 1) != 1) {
                    i11 = 0;
                }
                messageOptions.messageSetWireFormat_ = this.f12862c;
                if ((i10 & 2) == 2) {
                    i11 |= 2;
                }
                messageOptions.noStandardDescriptorAccessor_ = this.f12863d;
                if ((i10 & 4) == 4) {
                    i11 |= 4;
                }
                messageOptions.deprecated_ = this.f12864e;
                if ((i10 & 8) == 8) {
                    i11 |= 8;
                }
                messageOptions.mapEntry_ = this.f12865f;
                o0<UninterpretedOption, UninterpretedOption.b, s> o0Var = this.f12867h;
                if (o0Var == null) {
                    if ((this.f12861b & 16) == 16) {
                        this.f12866g = Collections.unmodifiableList(this.f12866g);
                        this.f12861b &= -17;
                    }
                    messageOptions.uninterpretedOption_ = this.f12866g;
                } else {
                    messageOptions.uninterpretedOption_ = o0Var.g();
                }
                messageOptions.bitField0_ = i11;
                onBuilt();
                return messageOptions;
            }

            /* renamed from: q */
            public b d() {
                super.clear();
                this.f12862c = false;
                int i10 = this.f12861b & (-2);
                this.f12861b = i10;
                this.f12863d = false;
                int i11 = i10 & (-3);
                this.f12861b = i11;
                this.f12864e = false;
                int i12 = i11 & (-5);
                this.f12861b = i12;
                this.f12865f = false;
                this.f12861b = i12 & (-9);
                o0<UninterpretedOption, UninterpretedOption.b, s> o0Var = this.f12867h;
                if (o0Var == null) {
                    this.f12866g = Collections.emptyList();
                    this.f12861b &= -17;
                } else {
                    o0Var.h();
                }
                return this;
            }

            /* renamed from: r */
            public b e(Descriptors.FieldDescriptor fieldDescriptor) {
                return (b) super.clearField(fieldDescriptor);
            }

            /* renamed from: s */
            public b clearOneof(Descriptors.h hVar) {
                return (b) super.clearOneof(hVar);
            }

            /* renamed from: t */
            public b f() {
                return (b) super.clone();
            }

            /* renamed from: v */
            public MessageOptions getDefaultInstanceForType() {
                return MessageOptions.getDefaultInstance();
            }

            public UninterpretedOption w(int i10) {
                o0<UninterpretedOption, UninterpretedOption.b, s> o0Var = this.f12867h;
                if (o0Var == null) {
                    return this.f12866g.get(i10);
                }
                return o0Var.o(i10);
            }

            public int x() {
                o0<UninterpretedOption, UninterpretedOption.b, s> o0Var = this.f12867h;
                if (o0Var == null) {
                    return this.f12866g.size();
                }
                return o0Var.n();
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x0021  */
            /* renamed from: z */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public b mergeFrom(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws IOException {
                Throwable th2;
                MessageOptions messageOptions = null;
                try {
                    try {
                        MessageOptions parsePartialFrom = MessageOptions.PARSER.parsePartialFrom(iVar, qVar);
                        if (parsePartialFrom != null) {
                            A(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e10) {
                        messageOptions = (MessageOptions) e10.getUnfinishedMessage();
                        try {
                            throw e10.unwrapIOException();
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (messageOptions != null) {
                                A(messageOptions);
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (messageOptions != null) {
                    }
                    throw th2;
                }
            }

            /* synthetic */ b(GeneratedMessageV3.c cVar, a aVar) {
                this(cVar);
            }

            private b() {
                this.f12866g = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.f12866g = Collections.emptyList();
                maybeForceBuilderInitialization();
            }
        }

        /* synthetic */ MessageOptions(com.google.protobuf.i iVar, com.google.protobuf.q qVar, a aVar) throws InvalidProtocolBufferException {
            this(iVar, qVar);
        }

        public static MessageOptions getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return DescriptorProtos.f12746y;
        }

        public static b newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static MessageOptions parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (MessageOptions) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static MessageOptions parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static l0<MessageOptions> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof MessageOptions)) {
                return super.equals(obj);
            }
            MessageOptions messageOptions = (MessageOptions) obj;
            boolean z10 = hasMessageSetWireFormat() == messageOptions.hasMessageSetWireFormat();
            if (hasMessageSetWireFormat()) {
                z10 = z10 && getMessageSetWireFormat() == messageOptions.getMessageSetWireFormat();
            }
            boolean z11 = z10 && hasNoStandardDescriptorAccessor() == messageOptions.hasNoStandardDescriptorAccessor();
            if (hasNoStandardDescriptorAccessor()) {
                z11 = z11 && getNoStandardDescriptorAccessor() == messageOptions.getNoStandardDescriptorAccessor();
            }
            boolean z12 = z11 && hasDeprecated() == messageOptions.hasDeprecated();
            if (hasDeprecated()) {
                z12 = z12 && getDeprecated() == messageOptions.getDeprecated();
            }
            boolean z13 = z12 && hasMapEntry() == messageOptions.hasMapEntry();
            if (hasMapEntry()) {
                z13 = z13 && getMapEntry() == messageOptions.getMapEntry();
            }
            return ((z13 && getUninterpretedOptionList().equals(messageOptions.getUninterpretedOptionList())) && this.unknownFields.equals(messageOptions.unknownFields)) && d().equals(messageOptions.d());
        }

        public boolean getDeprecated() {
            return this.deprecated_;
        }

        public boolean getMapEntry() {
            return this.mapEntry_;
        }

        public boolean getMessageSetWireFormat() {
            return this.messageSetWireFormat_;
        }

        public boolean getNoStandardDescriptorAccessor() {
            return this.noStandardDescriptorAccessor_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public l0<MessageOptions> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
        public int getSerializedSize() {
            int i10 = this.memoizedSize;
            if (i10 != -1) {
                return i10;
            }
            int e10 = (this.bitField0_ & 1) == 1 ? CodedOutputStream.e(1, this.messageSetWireFormat_) + 0 : 0;
            if ((this.bitField0_ & 2) == 2) {
                e10 += CodedOutputStream.e(2, this.noStandardDescriptorAccessor_);
            }
            if ((this.bitField0_ & 4) == 4) {
                e10 += CodedOutputStream.e(3, this.deprecated_);
            }
            if ((this.bitField0_ & 8) == 8) {
                e10 += CodedOutputStream.e(7, this.mapEntry_);
            }
            for (int i11 = 0; i11 < this.uninterpretedOption_.size(); i11++) {
                e10 += CodedOutputStream.E(999, this.uninterpretedOption_.get(i11));
            }
            int c10 = e10 + c() + this.unknownFields.getSerializedSize();
            this.memoizedSize = c10;
            return c10;
        }

        public UninterpretedOption getUninterpretedOption(int i10) {
            return this.uninterpretedOption_.get(i10);
        }

        public int getUninterpretedOptionCount() {
            return this.uninterpretedOption_.size();
        }

        public List<UninterpretedOption> getUninterpretedOptionList() {
            return this.uninterpretedOption_;
        }

        public s getUninterpretedOptionOrBuilder(int i10) {
            return this.uninterpretedOption_.get(i10);
        }

        public List<? extends s> getUninterpretedOptionOrBuilderList() {
            return this.uninterpretedOption_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.g0
        public final a1 getUnknownFields() {
            return this.unknownFields;
        }

        public boolean hasDeprecated() {
            return (this.bitField0_ & 4) == 4;
        }

        public boolean hasMapEntry() {
            return (this.bitField0_ & 8) == 8;
        }

        public boolean hasMessageSetWireFormat() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasNoStandardDescriptorAccessor() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // com.google.protobuf.a
        public int hashCode() {
            int i10 = this.memoizedHashCode;
            if (i10 != 0) {
                return i10;
            }
            int hashCode = 779 + getDescriptorForType().hashCode();
            if (hasMessageSetWireFormat()) {
                hashCode = (((hashCode * 37) + 1) * 53) + u.c(getMessageSetWireFormat());
            }
            if (hasNoStandardDescriptorAccessor()) {
                hashCode = (((hashCode * 37) + 2) * 53) + u.c(getNoStandardDescriptorAccessor());
            }
            if (hasDeprecated()) {
                hashCode = (((hashCode * 37) + 3) * 53) + u.c(getDeprecated());
            }
            if (hasMapEntry()) {
                hashCode = (((hashCode * 37) + 7) * 53) + u.c(getMapEntry());
            }
            if (getUninterpretedOptionCount() > 0) {
                hashCode = (((hashCode * 37) + 999) * 53) + getUninterpretedOptionList().hashCode();
            }
            int hashFields = (com.google.protobuf.a.hashFields(hashCode, d()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashFields;
            return hashFields;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return DescriptorProtos.f12747z.e(MessageOptions.class, b.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessage, com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.f0
        public final boolean isInitialized() {
            byte b10 = this.memoizedIsInitialized;
            if (b10 == 1) {
                return true;
            }
            if (b10 == 0) {
                return false;
            }
            for (int i10 = 0; i10 < getUninterpretedOptionCount(); i10++) {
                if (!getUninterpretedOption(i10).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (!b()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: q */
        public b newBuilderForType(GeneratedMessageV3.c cVar) {
            return new b(cVar, null);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            GeneratedMessageV3.ExtendableMessage<MessageType>.a g10 = g();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.e0(1, this.messageSetWireFormat_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.e0(2, this.noStandardDescriptorAccessor_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.e0(3, this.deprecated_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.e0(7, this.mapEntry_);
            }
            for (int i10 = 0; i10 < this.uninterpretedOption_.size(); i10++) {
                codedOutputStream.A0(999, this.uninterpretedOption_.get(i10));
            }
            g10.a(536870912, codedOutputStream);
            this.unknownFields.writeTo(codedOutputStream);
        }

        /* synthetic */ MessageOptions(GeneratedMessageV3.d dVar, a aVar) {
            this(dVar);
        }

        public static b newBuilder(MessageOptions messageOptions) {
            return DEFAULT_INSTANCE.toBuilder().A(messageOptions);
        }

        public static MessageOptions parseFrom(ByteString byteString, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, qVar);
        }

        private MessageOptions(GeneratedMessageV3.d<MessageOptions, ?> dVar) {
            super(dVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static MessageOptions parseDelimitedFrom(InputStream inputStream, com.google.protobuf.q qVar) throws IOException {
            return (MessageOptions) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
        }

        public static MessageOptions parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessage, com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
        public MessageOptions getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessage, com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b toBuilder() {
            return this == DEFAULT_INSTANCE ? new b((a) null) : new b((a) null).A(this);
        }

        public static MessageOptions parseFrom(byte[] bArr, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessage, com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b newBuilderForType() {
            return newBuilder();
        }

        private MessageOptions() {
            this.memoizedIsInitialized = (byte) -1;
            this.messageSetWireFormat_ = false;
            this.noStandardDescriptorAccessor_ = false;
            this.deprecated_ = false;
            this.mapEntry_ = false;
            this.uninterpretedOption_ = Collections.emptyList();
        }

        public static MessageOptions parseFrom(InputStream inputStream) throws IOException {
            return (MessageOptions) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static MessageOptions parseFrom(InputStream inputStream, com.google.protobuf.q qVar) throws IOException {
            return (MessageOptions) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
        }

        public static MessageOptions parseFrom(com.google.protobuf.i iVar) throws IOException {
            return (MessageOptions) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
        }

        public static MessageOptions parseFrom(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws IOException {
            return (MessageOptions) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private MessageOptions(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
            this();
            a1.b g10 = a1.g();
            boolean z10 = false;
            boolean z11 = false;
            while (true) {
                if (z10) {
                    break;
                }
                try {
                    try {
                        int F = iVar.F();
                        if (F != 0) {
                            if (F == 8) {
                                this.bitField0_ |= 1;
                                this.messageSetWireFormat_ = iVar.l();
                            } else if (F == 16) {
                                this.bitField0_ |= 2;
                                this.noStandardDescriptorAccessor_ = iVar.l();
                            } else if (F == 24) {
                                this.bitField0_ |= 4;
                                this.deprecated_ = iVar.l();
                            } else if (F == 56) {
                                this.bitField0_ |= 8;
                                this.mapEntry_ = iVar.l();
                            } else if (F == 7994) {
                                if (!(z11 & true)) {
                                    this.uninterpretedOption_ = new ArrayList();
                                    z11 |= true;
                                }
                                this.uninterpretedOption_.add(iVar.v(UninterpretedOption.PARSER, qVar));
                            } else if (!parseUnknownField(iVar, g10, qVar, F)) {
                            }
                        }
                        z10 = true;
                    } catch (InvalidProtocolBufferException e10) {
                        throw e10.setUnfinishedMessage(this);
                    } catch (IOException e11) {
                        throw new InvalidProtocolBufferException(e11).setUnfinishedMessage(this);
                    }
                } finally {
                    if (z11 & true) {
                        this.uninterpretedOption_ = Collections.unmodifiableList(this.uninterpretedOption_);
                    }
                    this.unknownFields = g10.build();
                    makeExtensionsImmutable();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class MethodDescriptorProto extends GeneratedMessageV3 implements l {
        public static final int CLIENT_STREAMING_FIELD_NUMBER = 5;
        public static final int INPUT_TYPE_FIELD_NUMBER = 2;
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int OPTIONS_FIELD_NUMBER = 4;
        public static final int OUTPUT_TYPE_FIELD_NUMBER = 3;
        public static final int SERVER_STREAMING_FIELD_NUMBER = 6;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private boolean clientStreaming_;
        private volatile Object inputType_;
        private byte memoizedIsInitialized;
        private volatile Object name_;
        private MethodOptions options_;
        private volatile Object outputType_;
        private boolean serverStreaming_;
        private static final MethodDescriptorProto DEFAULT_INSTANCE = new MethodDescriptorProto();
        @Deprecated
        public static final l0<MethodDescriptorProto> PARSER = new a();

        /* loaded from: classes.dex */
        static class a extends com.google.protobuf.c<MethodDescriptorProto> {
            a() {
            }

            /* renamed from: a */
            public MethodDescriptorProto parsePartialFrom(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
                return new MethodDescriptorProto(iVar, qVar, null);
            }
        }

        /* loaded from: classes.dex */
        public static final class b extends GeneratedMessageV3.b<b> implements l {

            /* renamed from: a  reason: collision with root package name */
            private int f12868a;

            /* renamed from: b  reason: collision with root package name */
            private Object f12869b;

            /* renamed from: c  reason: collision with root package name */
            private Object f12870c;

            /* renamed from: d  reason: collision with root package name */
            private Object f12871d;

            /* renamed from: e  reason: collision with root package name */
            private MethodOptions f12872e;

            /* renamed from: f  reason: collision with root package name */
            private q0<MethodOptions, MethodOptions.b, m> f12873f;

            /* renamed from: g  reason: collision with root package name */
            private boolean f12874g;

            /* renamed from: h  reason: collision with root package name */
            private boolean f12875h;

            /* synthetic */ b(a aVar) {
                this();
            }

            private q0<MethodOptions, MethodOptions.b, m> k() {
                if (this.f12873f == null) {
                    this.f12873f = new q0<>(j(), getParentForChildren(), isClean());
                    this.f12872e = null;
                }
                return this.f12873f;
            }

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                    k();
                }
            }

            /* renamed from: a */
            public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.addRepeatedField(fieldDescriptor, obj);
            }

            /* renamed from: b */
            public MethodDescriptorProto build() {
                MethodDescriptorProto c10 = buildPartial();
                if (c10.isInitialized()) {
                    return c10;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) c10);
            }

            /* renamed from: c */
            public MethodDescriptorProto buildPartial() {
                MethodDescriptorProto methodDescriptorProto = new MethodDescriptorProto(this, (a) null);
                int i10 = this.f12868a;
                int i11 = 1;
                if ((i10 & 1) != 1) {
                    i11 = 0;
                }
                methodDescriptorProto.name_ = this.f12869b;
                if ((i10 & 2) == 2) {
                    i11 |= 2;
                }
                methodDescriptorProto.inputType_ = this.f12870c;
                if ((i10 & 4) == 4) {
                    i11 |= 4;
                }
                methodDescriptorProto.outputType_ = this.f12871d;
                if ((i10 & 8) == 8) {
                    i11 |= 8;
                }
                q0<MethodOptions, MethodOptions.b, m> q0Var = this.f12873f;
                if (q0Var == null) {
                    methodDescriptorProto.options_ = this.f12872e;
                } else {
                    methodDescriptorProto.options_ = q0Var.b();
                }
                if ((i10 & 16) == 16) {
                    i11 |= 16;
                }
                methodDescriptorProto.clientStreaming_ = this.f12874g;
                if ((i10 & 32) == 32) {
                    i11 |= 32;
                }
                methodDescriptorProto.serverStreaming_ = this.f12875h;
                methodDescriptorProto.bitField0_ = i11;
                onBuilt();
                return methodDescriptorProto;
            }

            /* renamed from: d */
            public b clear() {
                super.clear();
                this.f12869b = "";
                int i10 = this.f12868a & (-2);
                this.f12868a = i10;
                this.f12870c = "";
                int i11 = i10 & (-3);
                this.f12868a = i11;
                this.f12871d = "";
                this.f12868a = i11 & (-5);
                q0<MethodOptions, MethodOptions.b, m> q0Var = this.f12873f;
                if (q0Var == null) {
                    this.f12872e = null;
                } else {
                    q0Var.c();
                }
                int i12 = this.f12868a & (-9);
                this.f12868a = i12;
                this.f12874g = false;
                int i13 = i12 & (-17);
                this.f12868a = i13;
                this.f12875h = false;
                this.f12868a = i13 & (-33);
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
                return DescriptorProtos.f12742u;
            }

            /* renamed from: i */
            public MethodDescriptorProto getDefaultInstanceForType() {
                return MethodDescriptorProto.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return DescriptorProtos.f12743v.e(MethodDescriptorProto.class, b.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.f0
            public final boolean isInitialized() {
                return !l() || j().isInitialized();
            }

            public MethodOptions j() {
                q0<MethodOptions, MethodOptions.b, m> q0Var = this.f12873f;
                if (q0Var != null) {
                    return q0Var.f();
                }
                MethodOptions methodOptions = this.f12872e;
                return methodOptions == null ? MethodOptions.getDefaultInstance() : methodOptions;
            }

            public boolean l() {
                return (this.f12868a & 8) == 8;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x0021  */
            /* renamed from: m */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public b mergeFrom(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws IOException {
                Throwable th2;
                MethodDescriptorProto methodDescriptorProto = null;
                try {
                    try {
                        MethodDescriptorProto parsePartialFrom = MethodDescriptorProto.PARSER.parsePartialFrom(iVar, qVar);
                        if (parsePartialFrom != null) {
                            n(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e10) {
                        methodDescriptorProto = (MethodDescriptorProto) e10.getUnfinishedMessage();
                        try {
                            throw e10.unwrapIOException();
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (methodDescriptorProto != null) {
                                n(methodDescriptorProto);
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (methodDescriptorProto != null) {
                    }
                    throw th2;
                }
            }

            public b n(MethodDescriptorProto methodDescriptorProto) {
                if (methodDescriptorProto == MethodDescriptorProto.getDefaultInstance()) {
                    return this;
                }
                if (methodDescriptorProto.hasName()) {
                    this.f12868a |= 1;
                    this.f12869b = methodDescriptorProto.name_;
                    onChanged();
                }
                if (methodDescriptorProto.hasInputType()) {
                    this.f12868a |= 2;
                    this.f12870c = methodDescriptorProto.inputType_;
                    onChanged();
                }
                if (methodDescriptorProto.hasOutputType()) {
                    this.f12868a |= 4;
                    this.f12871d = methodDescriptorProto.outputType_;
                    onChanged();
                }
                if (methodDescriptorProto.hasOptions()) {
                    p(methodDescriptorProto.getOptions());
                }
                if (methodDescriptorProto.hasClientStreaming()) {
                    r(methodDescriptorProto.getClientStreaming());
                }
                if (methodDescriptorProto.hasServerStreaming()) {
                    u(methodDescriptorProto.getServerStreaming());
                }
                mergeUnknownFields(methodDescriptorProto.unknownFields);
                onChanged();
                return this;
            }

            /* renamed from: o */
            public b mergeFrom(d0 d0Var) {
                if (d0Var instanceof MethodDescriptorProto) {
                    return n((MethodDescriptorProto) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            public b p(MethodOptions methodOptions) {
                MethodOptions methodOptions2;
                q0<MethodOptions, MethodOptions.b, m> q0Var = this.f12873f;
                if (q0Var == null) {
                    if ((this.f12868a & 8) != 8 || (methodOptions2 = this.f12872e) == null || methodOptions2 == MethodOptions.getDefaultInstance()) {
                        this.f12872e = methodOptions;
                    } else {
                        this.f12872e = MethodOptions.newBuilder(this.f12872e).A(methodOptions).buildPartial();
                    }
                    onChanged();
                } else {
                    q0Var.h(methodOptions);
                }
                this.f12868a |= 8;
                return this;
            }

            /* renamed from: q */
            public final b mergeUnknownFields(a1 a1Var) {
                return (b) super.mergeUnknownFields(a1Var);
            }

            public b r(boolean z10) {
                this.f12868a |= 16;
                this.f12874g = z10;
                onChanged();
                return this;
            }

            /* renamed from: s */
            public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.setField(fieldDescriptor, obj);
            }

            /* renamed from: t */
            public b setRepeatedField2(Descriptors.FieldDescriptor fieldDescriptor, int i10, Object obj) {
                return (b) super.setRepeatedField(fieldDescriptor, i10, obj);
            }

            public b u(boolean z10) {
                this.f12868a |= 32;
                this.f12875h = z10;
                onChanged();
                return this;
            }

            /* renamed from: v */
            public final b setUnknownFields(a1 a1Var) {
                return (b) super.setUnknownFields(a1Var);
            }

            /* synthetic */ b(GeneratedMessageV3.c cVar, a aVar) {
                this(cVar);
            }

            private b() {
                this.f12869b = "";
                this.f12870c = "";
                this.f12871d = "";
                this.f12872e = null;
                maybeForceBuilderInitialization();
            }

            private b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.f12869b = "";
                this.f12870c = "";
                this.f12871d = "";
                this.f12872e = null;
                maybeForceBuilderInitialization();
            }
        }

        /* synthetic */ MethodDescriptorProto(com.google.protobuf.i iVar, com.google.protobuf.q qVar, a aVar) throws InvalidProtocolBufferException {
            this(iVar, qVar);
        }

        public static MethodDescriptorProto getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return DescriptorProtos.f12742u;
        }

        public static b newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static MethodDescriptorProto parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (MethodDescriptorProto) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static MethodDescriptorProto parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static l0<MethodDescriptorProto> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof MethodDescriptorProto)) {
                return super.equals(obj);
            }
            MethodDescriptorProto methodDescriptorProto = (MethodDescriptorProto) obj;
            boolean z10 = hasName() == methodDescriptorProto.hasName();
            if (hasName()) {
                z10 = z10 && getName().equals(methodDescriptorProto.getName());
            }
            boolean z11 = z10 && hasInputType() == methodDescriptorProto.hasInputType();
            if (hasInputType()) {
                z11 = z11 && getInputType().equals(methodDescriptorProto.getInputType());
            }
            boolean z12 = z11 && hasOutputType() == methodDescriptorProto.hasOutputType();
            if (hasOutputType()) {
                z12 = z12 && getOutputType().equals(methodDescriptorProto.getOutputType());
            }
            boolean z13 = z12 && hasOptions() == methodDescriptorProto.hasOptions();
            if (hasOptions()) {
                z13 = z13 && getOptions().equals(methodDescriptorProto.getOptions());
            }
            boolean z14 = z13 && hasClientStreaming() == methodDescriptorProto.hasClientStreaming();
            if (hasClientStreaming()) {
                z14 = z14 && getClientStreaming() == methodDescriptorProto.getClientStreaming();
            }
            boolean z15 = z14 && hasServerStreaming() == methodDescriptorProto.hasServerStreaming();
            if (hasServerStreaming()) {
                z15 = z15 && getServerStreaming() == methodDescriptorProto.getServerStreaming();
            }
            return z15 && this.unknownFields.equals(methodDescriptorProto.unknownFields);
        }

        public boolean getClientStreaming() {
            return this.clientStreaming_;
        }

        public String getInputType() {
            Object obj = this.inputType_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.inputType_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getInputTypeBytes() {
            Object obj = this.inputType_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.inputType_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public String getName() {
            Object obj = this.name_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.name_ = stringUtf8;
            }
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

        public MethodOptions getOptions() {
            MethodOptions methodOptions = this.options_;
            return methodOptions == null ? MethodOptions.getDefaultInstance() : methodOptions;
        }

        public m getOptionsOrBuilder() {
            MethodOptions methodOptions = this.options_;
            return methodOptions == null ? MethodOptions.getDefaultInstance() : methodOptions;
        }

        public String getOutputType() {
            Object obj = this.outputType_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.outputType_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getOutputTypeBytes() {
            Object obj = this.outputType_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.outputType_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public l0<MethodDescriptorProto> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
        public int getSerializedSize() {
            int i10 = this.memoizedSize;
            if (i10 != -1) {
                return i10;
            }
            int i11 = 0;
            if ((this.bitField0_ & 1) == 1) {
                i11 = 0 + GeneratedMessageV3.computeStringSize(1, this.name_);
            }
            if ((this.bitField0_ & 2) == 2) {
                i11 += GeneratedMessageV3.computeStringSize(2, this.inputType_);
            }
            if ((this.bitField0_ & 4) == 4) {
                i11 += GeneratedMessageV3.computeStringSize(3, this.outputType_);
            }
            if ((this.bitField0_ & 8) == 8) {
                i11 += CodedOutputStream.E(4, getOptions());
            }
            if ((this.bitField0_ & 16) == 16) {
                i11 += CodedOutputStream.e(5, this.clientStreaming_);
            }
            if ((this.bitField0_ & 32) == 32) {
                i11 += CodedOutputStream.e(6, this.serverStreaming_);
            }
            int serializedSize = i11 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        public boolean getServerStreaming() {
            return this.serverStreaming_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.g0
        public final a1 getUnknownFields() {
            return this.unknownFields;
        }

        public boolean hasClientStreaming() {
            return (this.bitField0_ & 16) == 16;
        }

        public boolean hasInputType() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean hasName() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasOptions() {
            return (this.bitField0_ & 8) == 8;
        }

        public boolean hasOutputType() {
            return (this.bitField0_ & 4) == 4;
        }

        public boolean hasServerStreaming() {
            return (this.bitField0_ & 32) == 32;
        }

        @Override // com.google.protobuf.a
        public int hashCode() {
            int i10 = this.memoizedHashCode;
            if (i10 != 0) {
                return i10;
            }
            int hashCode = 779 + getDescriptorForType().hashCode();
            if (hasName()) {
                hashCode = (((hashCode * 37) + 1) * 53) + getName().hashCode();
            }
            if (hasInputType()) {
                hashCode = (((hashCode * 37) + 2) * 53) + getInputType().hashCode();
            }
            if (hasOutputType()) {
                hashCode = (((hashCode * 37) + 3) * 53) + getOutputType().hashCode();
            }
            if (hasOptions()) {
                hashCode = (((hashCode * 37) + 4) * 53) + getOptions().hashCode();
            }
            if (hasClientStreaming()) {
                hashCode = (((hashCode * 37) + 5) * 53) + u.c(getClientStreaming());
            }
            if (hasServerStreaming()) {
                hashCode = (((hashCode * 37) + 6) * 53) + u.c(getServerStreaming());
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return DescriptorProtos.f12743v.e(MethodDescriptorProto.class, b.class);
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
            if (!hasOptions() || getOptions().isInitialized()) {
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: m */
        public b newBuilderForType(GeneratedMessageV3.c cVar) {
            return new b(cVar, null);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if ((this.bitField0_ & 1) == 1) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.name_);
            }
            if ((this.bitField0_ & 2) == 2) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.inputType_);
            }
            if ((this.bitField0_ & 4) == 4) {
                GeneratedMessageV3.writeString(codedOutputStream, 3, this.outputType_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.A0(4, getOptions());
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.e0(5, this.clientStreaming_);
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.e0(6, this.serverStreaming_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        /* synthetic */ MethodDescriptorProto(GeneratedMessageV3.b bVar, a aVar) {
            this(bVar);
        }

        public static b newBuilder(MethodDescriptorProto methodDescriptorProto) {
            return DEFAULT_INSTANCE.toBuilder().n(methodDescriptorProto);
        }

        public static MethodDescriptorProto parseFrom(ByteString byteString, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, qVar);
        }

        private MethodDescriptorProto(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static MethodDescriptorProto parseDelimitedFrom(InputStream inputStream, com.google.protobuf.q qVar) throws IOException {
            return (MethodDescriptorProto) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
        }

        public static MethodDescriptorProto parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
        public MethodDescriptorProto getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b toBuilder() {
            return this == DEFAULT_INSTANCE ? new b((a) null) : new b((a) null).n(this);
        }

        public static MethodDescriptorProto parseFrom(byte[] bArr, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b newBuilderForType() {
            return newBuilder();
        }

        private MethodDescriptorProto() {
            this.memoizedIsInitialized = (byte) -1;
            this.name_ = "";
            this.inputType_ = "";
            this.outputType_ = "";
            this.clientStreaming_ = false;
            this.serverStreaming_ = false;
        }

        public static MethodDescriptorProto parseFrom(InputStream inputStream) throws IOException {
            return (MethodDescriptorProto) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static MethodDescriptorProto parseFrom(InputStream inputStream, com.google.protobuf.q qVar) throws IOException {
            return (MethodDescriptorProto) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
        }

        public static MethodDescriptorProto parseFrom(com.google.protobuf.i iVar) throws IOException {
            return (MethodDescriptorProto) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
        }

        public static MethodDescriptorProto parseFrom(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws IOException {
            return (MethodDescriptorProto) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
        }

        private MethodDescriptorProto(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
            this();
            a1.b g10 = a1.g();
            boolean z10 = false;
            while (!z10) {
                try {
                    try {
                        int F = iVar.F();
                        if (F != 0) {
                            if (F == 10) {
                                ByteString m10 = iVar.m();
                                this.bitField0_ = 1 | this.bitField0_;
                                this.name_ = m10;
                            } else if (F == 18) {
                                ByteString m11 = iVar.m();
                                this.bitField0_ |= 2;
                                this.inputType_ = m11;
                            } else if (F == 26) {
                                ByteString m12 = iVar.m();
                                this.bitField0_ |= 4;
                                this.outputType_ = m12;
                            } else if (F == 34) {
                                MethodOptions.b builder = (this.bitField0_ & 8) == 8 ? this.options_.toBuilder() : null;
                                MethodOptions methodOptions = (MethodOptions) iVar.v(MethodOptions.PARSER, qVar);
                                this.options_ = methodOptions;
                                if (builder != null) {
                                    builder.A(methodOptions);
                                    this.options_ = builder.buildPartial();
                                }
                                this.bitField0_ |= 8;
                            } else if (F == 40) {
                                this.bitField0_ |= 16;
                                this.clientStreaming_ = iVar.l();
                            } else if (F == 48) {
                                this.bitField0_ |= 32;
                                this.serverStreaming_ = iVar.l();
                            } else if (!parseUnknownField(iVar, g10, qVar, F)) {
                            }
                        }
                        z10 = true;
                    } catch (InvalidProtocolBufferException e10) {
                        throw e10.setUnfinishedMessage(this);
                    } catch (IOException e11) {
                        throw new InvalidProtocolBufferException(e11).setUnfinishedMessage(this);
                    }
                } finally {
                    this.unknownFields = g10.build();
                    makeExtensionsImmutable();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class MethodOptions extends GeneratedMessageV3.ExtendableMessage<MethodOptions> implements m {
        public static final int DEPRECATED_FIELD_NUMBER = 33;
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private boolean deprecated_;
        private byte memoizedIsInitialized;
        private List<UninterpretedOption> uninterpretedOption_;
        private static final MethodOptions DEFAULT_INSTANCE = new MethodOptions();
        @Deprecated
        public static final l0<MethodOptions> PARSER = new a();

        /* loaded from: classes.dex */
        static class a extends com.google.protobuf.c<MethodOptions> {
            a() {
            }

            /* renamed from: a */
            public MethodOptions parsePartialFrom(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
                return new MethodOptions(iVar, qVar, null);
            }
        }

        /* loaded from: classes.dex */
        public static final class b extends GeneratedMessageV3.d<MethodOptions, b> implements m {

            /* renamed from: b  reason: collision with root package name */
            private int f12876b;

            /* renamed from: c  reason: collision with root package name */
            private boolean f12877c;

            /* renamed from: d  reason: collision with root package name */
            private List<UninterpretedOption> f12878d;

            /* renamed from: e  reason: collision with root package name */
            private o0<UninterpretedOption, UninterpretedOption.b, s> f12879e;

            /* synthetic */ b(a aVar) {
                this();
            }

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                    y();
                }
            }

            private void u() {
                if ((this.f12876b & 2) != 2) {
                    this.f12878d = new ArrayList(this.f12878d);
                    this.f12876b |= 2;
                }
            }

            private o0<UninterpretedOption, UninterpretedOption.b, s> y() {
                if (this.f12879e == null) {
                    this.f12879e = new o0<>(this.f12878d, (this.f12876b & 2) == 2, getParentForChildren(), isClean());
                    this.f12878d = null;
                }
                return this.f12879e;
            }

            public b A(MethodOptions methodOptions) {
                if (methodOptions == MethodOptions.getDefaultInstance()) {
                    return this;
                }
                if (methodOptions.hasDeprecated()) {
                    D(methodOptions.getDeprecated());
                }
                if (this.f12879e == null) {
                    if (!methodOptions.uninterpretedOption_.isEmpty()) {
                        if (this.f12878d.isEmpty()) {
                            this.f12878d = methodOptions.uninterpretedOption_;
                            this.f12876b &= -3;
                        } else {
                            u();
                            this.f12878d.addAll(methodOptions.uninterpretedOption_);
                        }
                        onChanged();
                    }
                } else if (!methodOptions.uninterpretedOption_.isEmpty()) {
                    if (this.f12879e.u()) {
                        this.f12879e.i();
                        o0<UninterpretedOption, UninterpretedOption.b, s> o0Var = null;
                        this.f12879e = null;
                        this.f12878d = methodOptions.uninterpretedOption_;
                        this.f12876b &= -3;
                        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                            o0Var = y();
                        }
                        this.f12879e = o0Var;
                    } else {
                        this.f12879e.b(methodOptions.uninterpretedOption_);
                    }
                }
                j(methodOptions);
                mergeUnknownFields(methodOptions.unknownFields);
                onChanged();
                return this;
            }

            /* renamed from: B */
            public b mergeFrom(d0 d0Var) {
                if (d0Var instanceof MethodOptions) {
                    return A((MethodOptions) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            /* renamed from: C */
            public final b mergeUnknownFields(a1 a1Var) {
                return (b) super.mergeUnknownFields(a1Var);
            }

            public b D(boolean z10) {
                this.f12876b |= 1;
                this.f12877c = z10;
                onChanged();
                return this;
            }

            /* renamed from: E */
            public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.setField(fieldDescriptor, obj);
            }

            /* renamed from: F */
            public b setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i10, Object obj) {
                return (b) super.setRepeatedField(fieldDescriptor, i10, obj);
            }

            /* renamed from: G */
            public final b setUnknownFields(a1 a1Var) {
                return (b) super.setUnknownFields(a1Var);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a, com.google.protobuf.g0
            public Descriptors.b getDescriptorForType() {
                return DescriptorProtos.K;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return DescriptorProtos.L.e(MethodOptions.class, b.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.d, com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.f0
            public final boolean isInitialized() {
                for (int i10 = 0; i10 < x(); i10++) {
                    if (!w(i10).isInitialized()) {
                        return false;
                    }
                }
                return i();
            }

            /* renamed from: n */
            public b b(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.addRepeatedField(fieldDescriptor, obj);
            }

            /* renamed from: o */
            public MethodOptions build() {
                MethodOptions p10 = buildPartial();
                if (p10.isInitialized()) {
                    return p10;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) p10);
            }

            /* renamed from: p */
            public MethodOptions buildPartial() {
                MethodOptions methodOptions = new MethodOptions(this, (a) null);
                int i10 = 1;
                if ((this.f12876b & 1) != 1) {
                    i10 = 0;
                }
                methodOptions.deprecated_ = this.f12877c;
                o0<UninterpretedOption, UninterpretedOption.b, s> o0Var = this.f12879e;
                if (o0Var == null) {
                    if ((this.f12876b & 2) == 2) {
                        this.f12878d = Collections.unmodifiableList(this.f12878d);
                        this.f12876b &= -3;
                    }
                    methodOptions.uninterpretedOption_ = this.f12878d;
                } else {
                    methodOptions.uninterpretedOption_ = o0Var.g();
                }
                methodOptions.bitField0_ = i10;
                onBuilt();
                return methodOptions;
            }

            /* renamed from: q */
            public b d() {
                super.clear();
                this.f12877c = false;
                this.f12876b &= -2;
                o0<UninterpretedOption, UninterpretedOption.b, s> o0Var = this.f12879e;
                if (o0Var == null) {
                    this.f12878d = Collections.emptyList();
                    this.f12876b &= -3;
                } else {
                    o0Var.h();
                }
                return this;
            }

            /* renamed from: r */
            public b e(Descriptors.FieldDescriptor fieldDescriptor) {
                return (b) super.clearField(fieldDescriptor);
            }

            /* renamed from: s */
            public b clearOneof(Descriptors.h hVar) {
                return (b) super.clearOneof(hVar);
            }

            /* renamed from: t */
            public b f() {
                return (b) super.clone();
            }

            /* renamed from: v */
            public MethodOptions getDefaultInstanceForType() {
                return MethodOptions.getDefaultInstance();
            }

            public UninterpretedOption w(int i10) {
                o0<UninterpretedOption, UninterpretedOption.b, s> o0Var = this.f12879e;
                if (o0Var == null) {
                    return this.f12878d.get(i10);
                }
                return o0Var.o(i10);
            }

            public int x() {
                o0<UninterpretedOption, UninterpretedOption.b, s> o0Var = this.f12879e;
                if (o0Var == null) {
                    return this.f12878d.size();
                }
                return o0Var.n();
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x0021  */
            /* renamed from: z */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public b mergeFrom(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws IOException {
                Throwable th2;
                MethodOptions methodOptions = null;
                try {
                    try {
                        MethodOptions parsePartialFrom = MethodOptions.PARSER.parsePartialFrom(iVar, qVar);
                        if (parsePartialFrom != null) {
                            A(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e10) {
                        methodOptions = (MethodOptions) e10.getUnfinishedMessage();
                        try {
                            throw e10.unwrapIOException();
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (methodOptions != null) {
                                A(methodOptions);
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (methodOptions != null) {
                    }
                    throw th2;
                }
            }

            /* synthetic */ b(GeneratedMessageV3.c cVar, a aVar) {
                this(cVar);
            }

            private b() {
                this.f12878d = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.f12878d = Collections.emptyList();
                maybeForceBuilderInitialization();
            }
        }

        /* synthetic */ MethodOptions(com.google.protobuf.i iVar, com.google.protobuf.q qVar, a aVar) throws InvalidProtocolBufferException {
            this(iVar, qVar);
        }

        public static MethodOptions getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return DescriptorProtos.K;
        }

        public static b newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static MethodOptions parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (MethodOptions) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static MethodOptions parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static l0<MethodOptions> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof MethodOptions)) {
                return super.equals(obj);
            }
            MethodOptions methodOptions = (MethodOptions) obj;
            boolean z10 = hasDeprecated() == methodOptions.hasDeprecated();
            if (hasDeprecated()) {
                z10 = z10 && getDeprecated() == methodOptions.getDeprecated();
            }
            return ((z10 && getUninterpretedOptionList().equals(methodOptions.getUninterpretedOptionList())) && this.unknownFields.equals(methodOptions.unknownFields)) && d().equals(methodOptions.d());
        }

        public boolean getDeprecated() {
            return this.deprecated_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public l0<MethodOptions> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
        public int getSerializedSize() {
            int i10 = this.memoizedSize;
            if (i10 != -1) {
                return i10;
            }
            int e10 = (this.bitField0_ & 1) == 1 ? CodedOutputStream.e(33, this.deprecated_) + 0 : 0;
            for (int i11 = 0; i11 < this.uninterpretedOption_.size(); i11++) {
                e10 += CodedOutputStream.E(999, this.uninterpretedOption_.get(i11));
            }
            int c10 = e10 + c() + this.unknownFields.getSerializedSize();
            this.memoizedSize = c10;
            return c10;
        }

        public UninterpretedOption getUninterpretedOption(int i10) {
            return this.uninterpretedOption_.get(i10);
        }

        public int getUninterpretedOptionCount() {
            return this.uninterpretedOption_.size();
        }

        public List<UninterpretedOption> getUninterpretedOptionList() {
            return this.uninterpretedOption_;
        }

        public s getUninterpretedOptionOrBuilder(int i10) {
            return this.uninterpretedOption_.get(i10);
        }

        public List<? extends s> getUninterpretedOptionOrBuilderList() {
            return this.uninterpretedOption_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.g0
        public final a1 getUnknownFields() {
            return this.unknownFields;
        }

        public boolean hasDeprecated() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // com.google.protobuf.a
        public int hashCode() {
            int i10 = this.memoizedHashCode;
            if (i10 != 0) {
                return i10;
            }
            int hashCode = 779 + getDescriptorForType().hashCode();
            if (hasDeprecated()) {
                hashCode = (((hashCode * 37) + 33) * 53) + u.c(getDeprecated());
            }
            if (getUninterpretedOptionCount() > 0) {
                hashCode = (((hashCode * 37) + 999) * 53) + getUninterpretedOptionList().hashCode();
            }
            int hashFields = (com.google.protobuf.a.hashFields(hashCode, d()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashFields;
            return hashFields;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return DescriptorProtos.L.e(MethodOptions.class, b.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessage, com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.f0
        public final boolean isInitialized() {
            byte b10 = this.memoizedIsInitialized;
            if (b10 == 1) {
                return true;
            }
            if (b10 == 0) {
                return false;
            }
            for (int i10 = 0; i10 < getUninterpretedOptionCount(); i10++) {
                if (!getUninterpretedOption(i10).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (!b()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: n */
        public b newBuilderForType(GeneratedMessageV3.c cVar) {
            return new b(cVar, null);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            GeneratedMessageV3.ExtendableMessage<MessageType>.a g10 = g();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.e0(33, this.deprecated_);
            }
            for (int i10 = 0; i10 < this.uninterpretedOption_.size(); i10++) {
                codedOutputStream.A0(999, this.uninterpretedOption_.get(i10));
            }
            g10.a(536870912, codedOutputStream);
            this.unknownFields.writeTo(codedOutputStream);
        }

        /* synthetic */ MethodOptions(GeneratedMessageV3.d dVar, a aVar) {
            this(dVar);
        }

        public static b newBuilder(MethodOptions methodOptions) {
            return DEFAULT_INSTANCE.toBuilder().A(methodOptions);
        }

        public static MethodOptions parseFrom(ByteString byteString, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, qVar);
        }

        private MethodOptions(GeneratedMessageV3.d<MethodOptions, ?> dVar) {
            super(dVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static MethodOptions parseDelimitedFrom(InputStream inputStream, com.google.protobuf.q qVar) throws IOException {
            return (MethodOptions) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
        }

        public static MethodOptions parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessage, com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
        public MethodOptions getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessage, com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b toBuilder() {
            return this == DEFAULT_INSTANCE ? new b((a) null) : new b((a) null).A(this);
        }

        public static MethodOptions parseFrom(byte[] bArr, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessage, com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b newBuilderForType() {
            return newBuilder();
        }

        private MethodOptions() {
            this.memoizedIsInitialized = (byte) -1;
            this.deprecated_ = false;
            this.uninterpretedOption_ = Collections.emptyList();
        }

        public static MethodOptions parseFrom(InputStream inputStream) throws IOException {
            return (MethodOptions) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static MethodOptions parseFrom(InputStream inputStream, com.google.protobuf.q qVar) throws IOException {
            return (MethodOptions) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private MethodOptions(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
            this();
            a1.b g10 = a1.g();
            boolean z10 = false;
            boolean z11 = false;
            while (true) {
                if (z10) {
                    break;
                }
                try {
                    try {
                        int F = iVar.F();
                        if (F != 0) {
                            if (F == 264) {
                                this.bitField0_ |= 1;
                                this.deprecated_ = iVar.l();
                            } else if (F == 7994) {
                                if (!(z11 & true)) {
                                    this.uninterpretedOption_ = new ArrayList();
                                    z11 |= true;
                                }
                                this.uninterpretedOption_.add(iVar.v(UninterpretedOption.PARSER, qVar));
                            } else if (!parseUnknownField(iVar, g10, qVar, F)) {
                            }
                        }
                        z10 = true;
                    } catch (InvalidProtocolBufferException e10) {
                        throw e10.setUnfinishedMessage(this);
                    } catch (IOException e11) {
                        throw new InvalidProtocolBufferException(e11).setUnfinishedMessage(this);
                    }
                } finally {
                    if (z11 & true) {
                        this.uninterpretedOption_ = Collections.unmodifiableList(this.uninterpretedOption_);
                    }
                    this.unknownFields = g10.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static MethodOptions parseFrom(com.google.protobuf.i iVar) throws IOException {
            return (MethodOptions) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
        }

        public static MethodOptions parseFrom(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws IOException {
            return (MethodOptions) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
        }
    }

    /* loaded from: classes.dex */
    public static final class OneofDescriptorProto extends GeneratedMessageV3 implements n {
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int OPTIONS_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private byte memoizedIsInitialized;
        private volatile Object name_;
        private OneofOptions options_;
        private static final OneofDescriptorProto DEFAULT_INSTANCE = new OneofDescriptorProto();
        @Deprecated
        public static final l0<OneofDescriptorProto> PARSER = new a();

        /* loaded from: classes.dex */
        static class a extends com.google.protobuf.c<OneofDescriptorProto> {
            a() {
            }

            /* renamed from: a */
            public OneofDescriptorProto parsePartialFrom(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
                return new OneofDescriptorProto(iVar, qVar, null);
            }
        }

        /* loaded from: classes.dex */
        public static final class b extends GeneratedMessageV3.b<b> implements n {

            /* renamed from: a  reason: collision with root package name */
            private int f12880a;

            /* renamed from: b  reason: collision with root package name */
            private Object f12881b;

            /* renamed from: c  reason: collision with root package name */
            private OneofOptions f12882c;

            /* renamed from: d  reason: collision with root package name */
            private q0<OneofOptions, OneofOptions.b, o> f12883d;

            /* synthetic */ b(a aVar) {
                this();
            }

            private q0<OneofOptions, OneofOptions.b, o> k() {
                if (this.f12883d == null) {
                    this.f12883d = new q0<>(j(), getParentForChildren(), isClean());
                    this.f12882c = null;
                }
                return this.f12883d;
            }

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                    k();
                }
            }

            /* renamed from: a */
            public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.addRepeatedField(fieldDescriptor, obj);
            }

            /* renamed from: b */
            public OneofDescriptorProto build() {
                OneofDescriptorProto c10 = buildPartial();
                if (c10.isInitialized()) {
                    return c10;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) c10);
            }

            /* renamed from: c */
            public OneofDescriptorProto buildPartial() {
                OneofDescriptorProto oneofDescriptorProto = new OneofDescriptorProto(this, (a) null);
                int i10 = this.f12880a;
                int i11 = 1;
                if ((i10 & 1) != 1) {
                    i11 = 0;
                }
                oneofDescriptorProto.name_ = this.f12881b;
                if ((i10 & 2) == 2) {
                    i11 |= 2;
                }
                q0<OneofOptions, OneofOptions.b, o> q0Var = this.f12883d;
                if (q0Var == null) {
                    oneofDescriptorProto.options_ = this.f12882c;
                } else {
                    oneofDescriptorProto.options_ = q0Var.b();
                }
                oneofDescriptorProto.bitField0_ = i11;
                onBuilt();
                return oneofDescriptorProto;
            }

            /* renamed from: d */
            public b clear() {
                super.clear();
                this.f12881b = "";
                this.f12880a &= -2;
                q0<OneofOptions, OneofOptions.b, o> q0Var = this.f12883d;
                if (q0Var == null) {
                    this.f12882c = null;
                } else {
                    q0Var.c();
                }
                this.f12880a &= -3;
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
                return DescriptorProtos.f12734m;
            }

            /* renamed from: i */
            public OneofDescriptorProto getDefaultInstanceForType() {
                return OneofDescriptorProto.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return DescriptorProtos.f12735n.e(OneofDescriptorProto.class, b.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.f0
            public final boolean isInitialized() {
                return !l() || j().isInitialized();
            }

            public OneofOptions j() {
                q0<OneofOptions, OneofOptions.b, o> q0Var = this.f12883d;
                if (q0Var != null) {
                    return q0Var.f();
                }
                OneofOptions oneofOptions = this.f12882c;
                return oneofOptions == null ? OneofOptions.getDefaultInstance() : oneofOptions;
            }

            public boolean l() {
                return (this.f12880a & 2) == 2;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x0021  */
            /* renamed from: m */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public b mergeFrom(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws IOException {
                Throwable th2;
                OneofDescriptorProto oneofDescriptorProto = null;
                try {
                    try {
                        OneofDescriptorProto parsePartialFrom = OneofDescriptorProto.PARSER.parsePartialFrom(iVar, qVar);
                        if (parsePartialFrom != null) {
                            n(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e10) {
                        oneofDescriptorProto = (OneofDescriptorProto) e10.getUnfinishedMessage();
                        try {
                            throw e10.unwrapIOException();
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (oneofDescriptorProto != null) {
                                n(oneofDescriptorProto);
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (oneofDescriptorProto != null) {
                    }
                    throw th2;
                }
            }

            public b n(OneofDescriptorProto oneofDescriptorProto) {
                if (oneofDescriptorProto == OneofDescriptorProto.getDefaultInstance()) {
                    return this;
                }
                if (oneofDescriptorProto.hasName()) {
                    this.f12880a |= 1;
                    this.f12881b = oneofDescriptorProto.name_;
                    onChanged();
                }
                if (oneofDescriptorProto.hasOptions()) {
                    p(oneofDescriptorProto.getOptions());
                }
                mergeUnknownFields(oneofDescriptorProto.unknownFields);
                onChanged();
                return this;
            }

            /* renamed from: o */
            public b mergeFrom(d0 d0Var) {
                if (d0Var instanceof OneofDescriptorProto) {
                    return n((OneofDescriptorProto) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            public b p(OneofOptions oneofOptions) {
                OneofOptions oneofOptions2;
                q0<OneofOptions, OneofOptions.b, o> q0Var = this.f12883d;
                if (q0Var == null) {
                    if ((this.f12880a & 2) != 2 || (oneofOptions2 = this.f12882c) == null || oneofOptions2 == OneofOptions.getDefaultInstance()) {
                        this.f12882c = oneofOptions;
                    } else {
                        this.f12882c = OneofOptions.newBuilder(this.f12882c).A(oneofOptions).buildPartial();
                    }
                    onChanged();
                } else {
                    q0Var.h(oneofOptions);
                }
                this.f12880a |= 2;
                return this;
            }

            /* renamed from: q */
            public final b mergeUnknownFields(a1 a1Var) {
                return (b) super.mergeUnknownFields(a1Var);
            }

            /* renamed from: r */
            public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.setField(fieldDescriptor, obj);
            }

            /* renamed from: s */
            public b setRepeatedField2(Descriptors.FieldDescriptor fieldDescriptor, int i10, Object obj) {
                return (b) super.setRepeatedField(fieldDescriptor, i10, obj);
            }

            /* renamed from: t */
            public final b setUnknownFields(a1 a1Var) {
                return (b) super.setUnknownFields(a1Var);
            }

            /* synthetic */ b(GeneratedMessageV3.c cVar, a aVar) {
                this(cVar);
            }

            private b() {
                this.f12881b = "";
                this.f12882c = null;
                maybeForceBuilderInitialization();
            }

            private b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.f12881b = "";
                this.f12882c = null;
                maybeForceBuilderInitialization();
            }
        }

        /* synthetic */ OneofDescriptorProto(com.google.protobuf.i iVar, com.google.protobuf.q qVar, a aVar) throws InvalidProtocolBufferException {
            this(iVar, qVar);
        }

        public static OneofDescriptorProto getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return DescriptorProtos.f12734m;
        }

        public static b newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static OneofDescriptorProto parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (OneofDescriptorProto) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static OneofDescriptorProto parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static l0<OneofDescriptorProto> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof OneofDescriptorProto)) {
                return super.equals(obj);
            }
            OneofDescriptorProto oneofDescriptorProto = (OneofDescriptorProto) obj;
            boolean z10 = hasName() == oneofDescriptorProto.hasName();
            if (hasName()) {
                z10 = z10 && getName().equals(oneofDescriptorProto.getName());
            }
            boolean z11 = z10 && hasOptions() == oneofDescriptorProto.hasOptions();
            if (hasOptions()) {
                z11 = z11 && getOptions().equals(oneofDescriptorProto.getOptions());
            }
            return z11 && this.unknownFields.equals(oneofDescriptorProto.unknownFields);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: g */
        public b newBuilderForType(GeneratedMessageV3.c cVar) {
            return new b(cVar, null);
        }

        public String getName() {
            Object obj = this.name_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.name_ = stringUtf8;
            }
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

        public OneofOptions getOptions() {
            OneofOptions oneofOptions = this.options_;
            return oneofOptions == null ? OneofOptions.getDefaultInstance() : oneofOptions;
        }

        public o getOptionsOrBuilder() {
            OneofOptions oneofOptions = this.options_;
            return oneofOptions == null ? OneofOptions.getDefaultInstance() : oneofOptions;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public l0<OneofDescriptorProto> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
        public int getSerializedSize() {
            int i10 = this.memoizedSize;
            if (i10 != -1) {
                return i10;
            }
            int i11 = 0;
            if ((this.bitField0_ & 1) == 1) {
                i11 = 0 + GeneratedMessageV3.computeStringSize(1, this.name_);
            }
            if ((this.bitField0_ & 2) == 2) {
                i11 += CodedOutputStream.E(2, getOptions());
            }
            int serializedSize = i11 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.g0
        public final a1 getUnknownFields() {
            return this.unknownFields;
        }

        public boolean hasName() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasOptions() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // com.google.protobuf.a
        public int hashCode() {
            int i10 = this.memoizedHashCode;
            if (i10 != 0) {
                return i10;
            }
            int hashCode = 779 + getDescriptorForType().hashCode();
            if (hasName()) {
                hashCode = (((hashCode * 37) + 1) * 53) + getName().hashCode();
            }
            if (hasOptions()) {
                hashCode = (((hashCode * 37) + 2) * 53) + getOptions().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return DescriptorProtos.f12735n.e(OneofDescriptorProto.class, b.class);
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
            if (!hasOptions() || getOptions().isInitialized()) {
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if ((this.bitField0_ & 1) == 1) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.name_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.A0(2, getOptions());
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        /* synthetic */ OneofDescriptorProto(GeneratedMessageV3.b bVar, a aVar) {
            this(bVar);
        }

        public static b newBuilder(OneofDescriptorProto oneofDescriptorProto) {
            return DEFAULT_INSTANCE.toBuilder().n(oneofDescriptorProto);
        }

        public static OneofDescriptorProto parseFrom(ByteString byteString, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, qVar);
        }

        private OneofDescriptorProto(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static OneofDescriptorProto parseDelimitedFrom(InputStream inputStream, com.google.protobuf.q qVar) throws IOException {
            return (OneofDescriptorProto) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
        }

        public static OneofDescriptorProto parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
        public OneofDescriptorProto getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b toBuilder() {
            return this == DEFAULT_INSTANCE ? new b((a) null) : new b((a) null).n(this);
        }

        public static OneofDescriptorProto parseFrom(byte[] bArr, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b newBuilderForType() {
            return newBuilder();
        }

        private OneofDescriptorProto() {
            this.memoizedIsInitialized = (byte) -1;
            this.name_ = "";
        }

        public static OneofDescriptorProto parseFrom(InputStream inputStream) throws IOException {
            return (OneofDescriptorProto) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static OneofDescriptorProto parseFrom(InputStream inputStream, com.google.protobuf.q qVar) throws IOException {
            return (OneofDescriptorProto) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
        }

        private OneofDescriptorProto(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
            this();
            a1.b g10 = a1.g();
            boolean z10 = false;
            while (!z10) {
                try {
                    try {
                        int F = iVar.F();
                        if (F != 0) {
                            if (F == 10) {
                                ByteString m10 = iVar.m();
                                this.bitField0_ = 1 | this.bitField0_;
                                this.name_ = m10;
                            } else if (F == 18) {
                                OneofOptions.b builder = (this.bitField0_ & 2) == 2 ? this.options_.toBuilder() : null;
                                OneofOptions oneofOptions = (OneofOptions) iVar.v(OneofOptions.PARSER, qVar);
                                this.options_ = oneofOptions;
                                if (builder != null) {
                                    builder.A(oneofOptions);
                                    this.options_ = builder.buildPartial();
                                }
                                this.bitField0_ |= 2;
                            } else if (!parseUnknownField(iVar, g10, qVar, F)) {
                            }
                        }
                        z10 = true;
                    } catch (InvalidProtocolBufferException e10) {
                        throw e10.setUnfinishedMessage(this);
                    } catch (IOException e11) {
                        throw new InvalidProtocolBufferException(e11).setUnfinishedMessage(this);
                    }
                } finally {
                    this.unknownFields = g10.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static OneofDescriptorProto parseFrom(com.google.protobuf.i iVar) throws IOException {
            return (OneofDescriptorProto) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
        }

        public static OneofDescriptorProto parseFrom(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws IOException {
            return (OneofDescriptorProto) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
        }
    }

    /* loaded from: classes.dex */
    public static final class OneofOptions extends GeneratedMessageV3.ExtendableMessage<OneofOptions> implements o {
        private static final OneofOptions DEFAULT_INSTANCE = new OneofOptions();
        @Deprecated
        public static final l0<OneofOptions> PARSER = new a();
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        private static final long serialVersionUID = 0;
        private byte memoizedIsInitialized;
        private List<UninterpretedOption> uninterpretedOption_;

        /* loaded from: classes.dex */
        static class a extends com.google.protobuf.c<OneofOptions> {
            a() {
            }

            /* renamed from: a */
            public OneofOptions parsePartialFrom(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
                return new OneofOptions(iVar, qVar, null);
            }
        }

        /* loaded from: classes.dex */
        public static final class b extends GeneratedMessageV3.d<OneofOptions, b> implements o {

            /* renamed from: b  reason: collision with root package name */
            private int f12884b;

            /* renamed from: c  reason: collision with root package name */
            private List<UninterpretedOption> f12885c;

            /* renamed from: d  reason: collision with root package name */
            private o0<UninterpretedOption, UninterpretedOption.b, s> f12886d;

            /* synthetic */ b(a aVar) {
                this();
            }

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                    y();
                }
            }

            private void u() {
                if ((this.f12884b & 1) != 1) {
                    this.f12885c = new ArrayList(this.f12885c);
                    this.f12884b |= 1;
                }
            }

            private o0<UninterpretedOption, UninterpretedOption.b, s> y() {
                if (this.f12886d == null) {
                    List<UninterpretedOption> list = this.f12885c;
                    boolean z10 = true;
                    if ((this.f12884b & 1) != 1) {
                        z10 = false;
                    }
                    this.f12886d = new o0<>(list, z10, getParentForChildren(), isClean());
                    this.f12885c = null;
                }
                return this.f12886d;
            }

            public b A(OneofOptions oneofOptions) {
                if (oneofOptions == OneofOptions.getDefaultInstance()) {
                    return this;
                }
                if (this.f12886d == null) {
                    if (!oneofOptions.uninterpretedOption_.isEmpty()) {
                        if (this.f12885c.isEmpty()) {
                            this.f12885c = oneofOptions.uninterpretedOption_;
                            this.f12884b &= -2;
                        } else {
                            u();
                            this.f12885c.addAll(oneofOptions.uninterpretedOption_);
                        }
                        onChanged();
                    }
                } else if (!oneofOptions.uninterpretedOption_.isEmpty()) {
                    if (this.f12886d.u()) {
                        this.f12886d.i();
                        o0<UninterpretedOption, UninterpretedOption.b, s> o0Var = null;
                        this.f12886d = null;
                        this.f12885c = oneofOptions.uninterpretedOption_;
                        this.f12884b &= -2;
                        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                            o0Var = y();
                        }
                        this.f12886d = o0Var;
                    } else {
                        this.f12886d.b(oneofOptions.uninterpretedOption_);
                    }
                }
                j(oneofOptions);
                mergeUnknownFields(oneofOptions.unknownFields);
                onChanged();
                return this;
            }

            /* renamed from: B */
            public b mergeFrom(d0 d0Var) {
                if (d0Var instanceof OneofOptions) {
                    return A((OneofOptions) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            /* renamed from: C */
            public final b mergeUnknownFields(a1 a1Var) {
                return (b) super.mergeUnknownFields(a1Var);
            }

            /* renamed from: D */
            public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.setField(fieldDescriptor, obj);
            }

            /* renamed from: E */
            public b setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i10, Object obj) {
                return (b) super.setRepeatedField(fieldDescriptor, i10, obj);
            }

            /* renamed from: F */
            public final b setUnknownFields(a1 a1Var) {
                return (b) super.setUnknownFields(a1Var);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a, com.google.protobuf.g0
            public Descriptors.b getDescriptorForType() {
                return DescriptorProtos.C;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return DescriptorProtos.D.e(OneofOptions.class, b.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.d, com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.f0
            public final boolean isInitialized() {
                for (int i10 = 0; i10 < x(); i10++) {
                    if (!w(i10).isInitialized()) {
                        return false;
                    }
                }
                return i();
            }

            /* renamed from: n */
            public b b(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.addRepeatedField(fieldDescriptor, obj);
            }

            /* renamed from: o */
            public OneofOptions build() {
                OneofOptions p10 = buildPartial();
                if (p10.isInitialized()) {
                    return p10;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) p10);
            }

            /* renamed from: p */
            public OneofOptions buildPartial() {
                OneofOptions oneofOptions = new OneofOptions(this, (a) null);
                int i10 = this.f12884b;
                o0<UninterpretedOption, UninterpretedOption.b, s> o0Var = this.f12886d;
                if (o0Var == null) {
                    if ((i10 & 1) == 1) {
                        this.f12885c = Collections.unmodifiableList(this.f12885c);
                        this.f12884b &= -2;
                    }
                    oneofOptions.uninterpretedOption_ = this.f12885c;
                } else {
                    oneofOptions.uninterpretedOption_ = o0Var.g();
                }
                onBuilt();
                return oneofOptions;
            }

            /* renamed from: q */
            public b d() {
                super.clear();
                o0<UninterpretedOption, UninterpretedOption.b, s> o0Var = this.f12886d;
                if (o0Var == null) {
                    this.f12885c = Collections.emptyList();
                    this.f12884b &= -2;
                } else {
                    o0Var.h();
                }
                return this;
            }

            /* renamed from: r */
            public b e(Descriptors.FieldDescriptor fieldDescriptor) {
                return (b) super.clearField(fieldDescriptor);
            }

            /* renamed from: s */
            public b clearOneof(Descriptors.h hVar) {
                return (b) super.clearOneof(hVar);
            }

            /* renamed from: t */
            public b f() {
                return (b) super.clone();
            }

            /* renamed from: v */
            public OneofOptions getDefaultInstanceForType() {
                return OneofOptions.getDefaultInstance();
            }

            public UninterpretedOption w(int i10) {
                o0<UninterpretedOption, UninterpretedOption.b, s> o0Var = this.f12886d;
                if (o0Var == null) {
                    return this.f12885c.get(i10);
                }
                return o0Var.o(i10);
            }

            public int x() {
                o0<UninterpretedOption, UninterpretedOption.b, s> o0Var = this.f12886d;
                if (o0Var == null) {
                    return this.f12885c.size();
                }
                return o0Var.n();
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x0021  */
            /* renamed from: z */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public b mergeFrom(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws IOException {
                Throwable th2;
                OneofOptions oneofOptions = null;
                try {
                    try {
                        OneofOptions parsePartialFrom = OneofOptions.PARSER.parsePartialFrom(iVar, qVar);
                        if (parsePartialFrom != null) {
                            A(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e10) {
                        oneofOptions = (OneofOptions) e10.getUnfinishedMessage();
                        try {
                            throw e10.unwrapIOException();
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (oneofOptions != null) {
                                A(oneofOptions);
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (oneofOptions != null) {
                    }
                    throw th2;
                }
            }

            /* synthetic */ b(GeneratedMessageV3.c cVar, a aVar) {
                this(cVar);
            }

            private b() {
                this.f12885c = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.f12885c = Collections.emptyList();
                maybeForceBuilderInitialization();
            }
        }

        /* synthetic */ OneofOptions(com.google.protobuf.i iVar, com.google.protobuf.q qVar, a aVar) throws InvalidProtocolBufferException {
            this(iVar, qVar);
        }

        public static OneofOptions getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return DescriptorProtos.C;
        }

        public static b newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static OneofOptions parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (OneofOptions) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static OneofOptions parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static l0<OneofOptions> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof OneofOptions)) {
                return super.equals(obj);
            }
            OneofOptions oneofOptions = (OneofOptions) obj;
            return ((getUninterpretedOptionList().equals(oneofOptions.getUninterpretedOptionList())) && this.unknownFields.equals(oneofOptions.unknownFields)) && d().equals(oneofOptions.d());
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public l0<OneofOptions> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
        public int getSerializedSize() {
            int i10 = this.memoizedSize;
            if (i10 != -1) {
                return i10;
            }
            int i11 = 0;
            for (int i12 = 0; i12 < this.uninterpretedOption_.size(); i12++) {
                i11 += CodedOutputStream.E(999, this.uninterpretedOption_.get(i12));
            }
            int c10 = i11 + c() + this.unknownFields.getSerializedSize();
            this.memoizedSize = c10;
            return c10;
        }

        public UninterpretedOption getUninterpretedOption(int i10) {
            return this.uninterpretedOption_.get(i10);
        }

        public int getUninterpretedOptionCount() {
            return this.uninterpretedOption_.size();
        }

        public List<UninterpretedOption> getUninterpretedOptionList() {
            return this.uninterpretedOption_;
        }

        public s getUninterpretedOptionOrBuilder(int i10) {
            return this.uninterpretedOption_.get(i10);
        }

        public List<? extends s> getUninterpretedOptionOrBuilderList() {
            return this.uninterpretedOption_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.g0
        public final a1 getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.google.protobuf.a
        public int hashCode() {
            int i10 = this.memoizedHashCode;
            if (i10 != 0) {
                return i10;
            }
            int hashCode = 779 + getDescriptorForType().hashCode();
            if (getUninterpretedOptionCount() > 0) {
                hashCode = (((hashCode * 37) + 999) * 53) + getUninterpretedOptionList().hashCode();
            }
            int hashFields = (com.google.protobuf.a.hashFields(hashCode, d()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashFields;
            return hashFields;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return DescriptorProtos.D.e(OneofOptions.class, b.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessage, com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.f0
        public final boolean isInitialized() {
            byte b10 = this.memoizedIsInitialized;
            if (b10 == 1) {
                return true;
            }
            if (b10 == 0) {
                return false;
            }
            for (int i10 = 0; i10 < getUninterpretedOptionCount(); i10++) {
                if (!getUninterpretedOption(i10).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (!b()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: l */
        public b newBuilderForType(GeneratedMessageV3.c cVar) {
            return new b(cVar, null);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            GeneratedMessageV3.ExtendableMessage<MessageType>.a g10 = g();
            for (int i10 = 0; i10 < this.uninterpretedOption_.size(); i10++) {
                codedOutputStream.A0(999, this.uninterpretedOption_.get(i10));
            }
            g10.a(536870912, codedOutputStream);
            this.unknownFields.writeTo(codedOutputStream);
        }

        /* synthetic */ OneofOptions(GeneratedMessageV3.d dVar, a aVar) {
            this(dVar);
        }

        public static b newBuilder(OneofOptions oneofOptions) {
            return DEFAULT_INSTANCE.toBuilder().A(oneofOptions);
        }

        public static OneofOptions parseFrom(ByteString byteString, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, qVar);
        }

        private OneofOptions(GeneratedMessageV3.d<OneofOptions, ?> dVar) {
            super(dVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static OneofOptions parseDelimitedFrom(InputStream inputStream, com.google.protobuf.q qVar) throws IOException {
            return (OneofOptions) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
        }

        public static OneofOptions parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessage, com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
        public OneofOptions getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessage, com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b toBuilder() {
            return this == DEFAULT_INSTANCE ? new b((a) null) : new b((a) null).A(this);
        }

        public static OneofOptions parseFrom(byte[] bArr, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessage, com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b newBuilderForType() {
            return newBuilder();
        }

        private OneofOptions() {
            this.memoizedIsInitialized = (byte) -1;
            this.uninterpretedOption_ = Collections.emptyList();
        }

        public static OneofOptions parseFrom(InputStream inputStream) throws IOException {
            return (OneofOptions) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static OneofOptions parseFrom(InputStream inputStream, com.google.protobuf.q qVar) throws IOException {
            return (OneofOptions) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private OneofOptions(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
            this();
            a1.b g10 = a1.g();
            boolean z10 = false;
            boolean z11 = false;
            while (true) {
                if (z10) {
                    break;
                }
                try {
                    try {
                        int F = iVar.F();
                        if (F != 0) {
                            if (F == 7994) {
                                if (!z11 || !true) {
                                    this.uninterpretedOption_ = new ArrayList();
                                    z11 |= true;
                                }
                                this.uninterpretedOption_.add(iVar.v(UninterpretedOption.PARSER, qVar));
                            } else if (!parseUnknownField(iVar, g10, qVar, F)) {
                            }
                        }
                        z10 = true;
                    } catch (InvalidProtocolBufferException e10) {
                        throw e10.setUnfinishedMessage(this);
                    } catch (IOException e11) {
                        throw new InvalidProtocolBufferException(e11).setUnfinishedMessage(this);
                    }
                } finally {
                    if (z11 && true) {
                        this.uninterpretedOption_ = Collections.unmodifiableList(this.uninterpretedOption_);
                    }
                    this.unknownFields = g10.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static OneofOptions parseFrom(com.google.protobuf.i iVar) throws IOException {
            return (OneofOptions) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
        }

        public static OneofOptions parseFrom(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws IOException {
            return (OneofOptions) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
        }
    }

    /* loaded from: classes.dex */
    public static final class ServiceDescriptorProto extends GeneratedMessageV3 implements p {
        public static final int METHOD_FIELD_NUMBER = 2;
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int OPTIONS_FIELD_NUMBER = 3;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private byte memoizedIsInitialized;
        private List<MethodDescriptorProto> method_;
        private volatile Object name_;
        private ServiceOptions options_;
        private static final ServiceDescriptorProto DEFAULT_INSTANCE = new ServiceDescriptorProto();
        @Deprecated
        public static final l0<ServiceDescriptorProto> PARSER = new a();

        /* loaded from: classes.dex */
        static class a extends com.google.protobuf.c<ServiceDescriptorProto> {
            a() {
            }

            /* renamed from: a */
            public ServiceDescriptorProto parsePartialFrom(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
                return new ServiceDescriptorProto(iVar, qVar, null);
            }
        }

        /* loaded from: classes.dex */
        public static final class b extends GeneratedMessageV3.b<b> implements p {

            /* renamed from: a  reason: collision with root package name */
            private int f12887a;

            /* renamed from: b  reason: collision with root package name */
            private Object f12888b;

            /* renamed from: c  reason: collision with root package name */
            private List<MethodDescriptorProto> f12889c;

            /* renamed from: d  reason: collision with root package name */
            private o0<MethodDescriptorProto, MethodDescriptorProto.b, l> f12890d;

            /* renamed from: e  reason: collision with root package name */
            private ServiceOptions f12891e;

            /* renamed from: f  reason: collision with root package name */
            private q0<ServiceOptions, ServiceOptions.b, q> f12892f;

            /* synthetic */ b(a aVar) {
                this();
            }

            private void i() {
                if ((this.f12887a & 2) != 2) {
                    this.f12889c = new ArrayList(this.f12889c);
                    this.f12887a |= 2;
                }
            }

            private o0<MethodDescriptorProto, MethodDescriptorProto.b, l> m() {
                if (this.f12890d == null) {
                    this.f12890d = new o0<>(this.f12889c, (this.f12887a & 2) == 2, getParentForChildren(), isClean());
                    this.f12889c = null;
                }
                return this.f12890d;
            }

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                    m();
                    o();
                }
            }

            private q0<ServiceOptions, ServiceOptions.b, q> o() {
                if (this.f12892f == null) {
                    this.f12892f = new q0<>(n(), getParentForChildren(), isClean());
                    this.f12891e = null;
                }
                return this.f12892f;
            }

            /* renamed from: a */
            public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.addRepeatedField(fieldDescriptor, obj);
            }

            /* renamed from: b */
            public ServiceDescriptorProto build() {
                ServiceDescriptorProto c10 = buildPartial();
                if (c10.isInitialized()) {
                    return c10;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) c10);
            }

            /* renamed from: c */
            public ServiceDescriptorProto buildPartial() {
                ServiceDescriptorProto serviceDescriptorProto = new ServiceDescriptorProto(this, (a) null);
                int i10 = this.f12887a;
                int i11 = 1;
                if ((i10 & 1) != 1) {
                    i11 = 0;
                }
                serviceDescriptorProto.name_ = this.f12888b;
                o0<MethodDescriptorProto, MethodDescriptorProto.b, l> o0Var = this.f12890d;
                if (o0Var == null) {
                    if ((this.f12887a & 2) == 2) {
                        this.f12889c = Collections.unmodifiableList(this.f12889c);
                        this.f12887a &= -3;
                    }
                    serviceDescriptorProto.method_ = this.f12889c;
                } else {
                    serviceDescriptorProto.method_ = o0Var.g();
                }
                if ((i10 & 4) == 4) {
                    i11 |= 2;
                }
                q0<ServiceOptions, ServiceOptions.b, q> q0Var = this.f12892f;
                if (q0Var == null) {
                    serviceDescriptorProto.options_ = this.f12891e;
                } else {
                    serviceDescriptorProto.options_ = q0Var.b();
                }
                serviceDescriptorProto.bitField0_ = i11;
                onBuilt();
                return serviceDescriptorProto;
            }

            /* renamed from: d */
            public b clear() {
                super.clear();
                this.f12888b = "";
                this.f12887a &= -2;
                o0<MethodDescriptorProto, MethodDescriptorProto.b, l> o0Var = this.f12890d;
                if (o0Var == null) {
                    this.f12889c = Collections.emptyList();
                    this.f12887a &= -3;
                } else {
                    o0Var.h();
                }
                q0<ServiceOptions, ServiceOptions.b, q> q0Var = this.f12892f;
                if (q0Var == null) {
                    this.f12891e = null;
                } else {
                    q0Var.c();
                }
                this.f12887a &= -5;
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
                return DescriptorProtos.f12740s;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return DescriptorProtos.f12741t.e(ServiceDescriptorProto.class, b.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.f0
            public final boolean isInitialized() {
                for (int i10 = 0; i10 < l(); i10++) {
                    if (!k(i10).isInitialized()) {
                        return false;
                    }
                }
                return !p() || n().isInitialized();
            }

            /* renamed from: j */
            public ServiceDescriptorProto getDefaultInstanceForType() {
                return ServiceDescriptorProto.getDefaultInstance();
            }

            public MethodDescriptorProto k(int i10) {
                o0<MethodDescriptorProto, MethodDescriptorProto.b, l> o0Var = this.f12890d;
                if (o0Var == null) {
                    return this.f12889c.get(i10);
                }
                return o0Var.o(i10);
            }

            public int l() {
                o0<MethodDescriptorProto, MethodDescriptorProto.b, l> o0Var = this.f12890d;
                if (o0Var == null) {
                    return this.f12889c.size();
                }
                return o0Var.n();
            }

            public ServiceOptions n() {
                q0<ServiceOptions, ServiceOptions.b, q> q0Var = this.f12892f;
                if (q0Var != null) {
                    return q0Var.f();
                }
                ServiceOptions serviceOptions = this.f12891e;
                return serviceOptions == null ? ServiceOptions.getDefaultInstance() : serviceOptions;
            }

            public boolean p() {
                return (this.f12887a & 4) == 4;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x0021  */
            /* renamed from: q */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public b mergeFrom(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws IOException {
                Throwable th2;
                ServiceDescriptorProto serviceDescriptorProto = null;
                try {
                    try {
                        ServiceDescriptorProto parsePartialFrom = ServiceDescriptorProto.PARSER.parsePartialFrom(iVar, qVar);
                        if (parsePartialFrom != null) {
                            r(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e10) {
                        serviceDescriptorProto = (ServiceDescriptorProto) e10.getUnfinishedMessage();
                        try {
                            throw e10.unwrapIOException();
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (serviceDescriptorProto != null) {
                                r(serviceDescriptorProto);
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (serviceDescriptorProto != null) {
                    }
                    throw th2;
                }
            }

            public b r(ServiceDescriptorProto serviceDescriptorProto) {
                if (serviceDescriptorProto == ServiceDescriptorProto.getDefaultInstance()) {
                    return this;
                }
                if (serviceDescriptorProto.hasName()) {
                    this.f12887a |= 1;
                    this.f12888b = serviceDescriptorProto.name_;
                    onChanged();
                }
                if (this.f12890d == null) {
                    if (!serviceDescriptorProto.method_.isEmpty()) {
                        if (this.f12889c.isEmpty()) {
                            this.f12889c = serviceDescriptorProto.method_;
                            this.f12887a &= -3;
                        } else {
                            i();
                            this.f12889c.addAll(serviceDescriptorProto.method_);
                        }
                        onChanged();
                    }
                } else if (!serviceDescriptorProto.method_.isEmpty()) {
                    if (this.f12890d.u()) {
                        this.f12890d.i();
                        o0<MethodDescriptorProto, MethodDescriptorProto.b, l> o0Var = null;
                        this.f12890d = null;
                        this.f12889c = serviceDescriptorProto.method_;
                        this.f12887a &= -3;
                        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                            o0Var = m();
                        }
                        this.f12890d = o0Var;
                    } else {
                        this.f12890d.b(serviceDescriptorProto.method_);
                    }
                }
                if (serviceDescriptorProto.hasOptions()) {
                    t(serviceDescriptorProto.getOptions());
                }
                mergeUnknownFields(serviceDescriptorProto.unknownFields);
                onChanged();
                return this;
            }

            /* renamed from: s */
            public b mergeFrom(d0 d0Var) {
                if (d0Var instanceof ServiceDescriptorProto) {
                    return r((ServiceDescriptorProto) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            public b t(ServiceOptions serviceOptions) {
                ServiceOptions serviceOptions2;
                q0<ServiceOptions, ServiceOptions.b, q> q0Var = this.f12892f;
                if (q0Var == null) {
                    if ((this.f12887a & 4) != 4 || (serviceOptions2 = this.f12891e) == null || serviceOptions2 == ServiceOptions.getDefaultInstance()) {
                        this.f12891e = serviceOptions;
                    } else {
                        this.f12891e = ServiceOptions.newBuilder(this.f12891e).A(serviceOptions).buildPartial();
                    }
                    onChanged();
                } else {
                    q0Var.h(serviceOptions);
                }
                this.f12887a |= 4;
                return this;
            }

            /* renamed from: u */
            public final b mergeUnknownFields(a1 a1Var) {
                return (b) super.mergeUnknownFields(a1Var);
            }

            /* renamed from: v */
            public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.setField(fieldDescriptor, obj);
            }

            /* renamed from: w */
            public b setRepeatedField2(Descriptors.FieldDescriptor fieldDescriptor, int i10, Object obj) {
                return (b) super.setRepeatedField(fieldDescriptor, i10, obj);
            }

            /* renamed from: x */
            public final b setUnknownFields(a1 a1Var) {
                return (b) super.setUnknownFields(a1Var);
            }

            /* synthetic */ b(GeneratedMessageV3.c cVar, a aVar) {
                this(cVar);
            }

            private b() {
                this.f12888b = "";
                this.f12889c = Collections.emptyList();
                this.f12891e = null;
                maybeForceBuilderInitialization();
            }

            private b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.f12888b = "";
                this.f12889c = Collections.emptyList();
                this.f12891e = null;
                maybeForceBuilderInitialization();
            }
        }

        /* synthetic */ ServiceDescriptorProto(com.google.protobuf.i iVar, com.google.protobuf.q qVar, a aVar) throws InvalidProtocolBufferException {
            this(iVar, qVar);
        }

        public static ServiceDescriptorProto getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return DescriptorProtos.f12740s;
        }

        public static b newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static ServiceDescriptorProto parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ServiceDescriptorProto) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static ServiceDescriptorProto parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static l0<ServiceDescriptorProto> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ServiceDescriptorProto)) {
                return super.equals(obj);
            }
            ServiceDescriptorProto serviceDescriptorProto = (ServiceDescriptorProto) obj;
            boolean z10 = hasName() == serviceDescriptorProto.hasName();
            if (hasName()) {
                z10 = z10 && getName().equals(serviceDescriptorProto.getName());
            }
            boolean z11 = (z10 && getMethodList().equals(serviceDescriptorProto.getMethodList())) && hasOptions() == serviceDescriptorProto.hasOptions();
            if (hasOptions()) {
                z11 = z11 && getOptions().equals(serviceDescriptorProto.getOptions());
            }
            return z11 && this.unknownFields.equals(serviceDescriptorProto.unknownFields);
        }

        public MethodDescriptorProto getMethod(int i10) {
            return this.method_.get(i10);
        }

        public int getMethodCount() {
            return this.method_.size();
        }

        public List<MethodDescriptorProto> getMethodList() {
            return this.method_;
        }

        public l getMethodOrBuilder(int i10) {
            return this.method_.get(i10);
        }

        public List<? extends l> getMethodOrBuilderList() {
            return this.method_;
        }

        public String getName() {
            Object obj = this.name_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.name_ = stringUtf8;
            }
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

        public ServiceOptions getOptions() {
            ServiceOptions serviceOptions = this.options_;
            return serviceOptions == null ? ServiceOptions.getDefaultInstance() : serviceOptions;
        }

        public q getOptionsOrBuilder() {
            ServiceOptions serviceOptions = this.options_;
            return serviceOptions == null ? ServiceOptions.getDefaultInstance() : serviceOptions;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public l0<ServiceDescriptorProto> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
        public int getSerializedSize() {
            int i10 = this.memoizedSize;
            if (i10 != -1) {
                return i10;
            }
            int computeStringSize = (this.bitField0_ & 1) == 1 ? GeneratedMessageV3.computeStringSize(1, this.name_) + 0 : 0;
            for (int i11 = 0; i11 < this.method_.size(); i11++) {
                computeStringSize += CodedOutputStream.E(2, this.method_.get(i11));
            }
            if ((this.bitField0_ & 2) == 2) {
                computeStringSize += CodedOutputStream.E(3, getOptions());
            }
            int serializedSize = computeStringSize + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.g0
        public final a1 getUnknownFields() {
            return this.unknownFields;
        }

        public boolean hasName() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasOptions() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // com.google.protobuf.a
        public int hashCode() {
            int i10 = this.memoizedHashCode;
            if (i10 != 0) {
                return i10;
            }
            int hashCode = 779 + getDescriptorForType().hashCode();
            if (hasName()) {
                hashCode = (((hashCode * 37) + 1) * 53) + getName().hashCode();
            }
            if (getMethodCount() > 0) {
                hashCode = (((hashCode * 37) + 2) * 53) + getMethodList().hashCode();
            }
            if (hasOptions()) {
                hashCode = (((hashCode * 37) + 3) * 53) + getOptions().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: i */
        public b newBuilderForType(GeneratedMessageV3.c cVar) {
            return new b(cVar, null);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return DescriptorProtos.f12741t.e(ServiceDescriptorProto.class, b.class);
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
            for (int i10 = 0; i10 < getMethodCount(); i10++) {
                if (!getMethod(i10).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (!hasOptions() || getOptions().isInitialized()) {
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if ((this.bitField0_ & 1) == 1) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.name_);
            }
            for (int i10 = 0; i10 < this.method_.size(); i10++) {
                codedOutputStream.A0(2, this.method_.get(i10));
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.A0(3, getOptions());
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        /* synthetic */ ServiceDescriptorProto(GeneratedMessageV3.b bVar, a aVar) {
            this(bVar);
        }

        public static b newBuilder(ServiceDescriptorProto serviceDescriptorProto) {
            return DEFAULT_INSTANCE.toBuilder().r(serviceDescriptorProto);
        }

        public static ServiceDescriptorProto parseFrom(ByteString byteString, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, qVar);
        }

        private ServiceDescriptorProto(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static ServiceDescriptorProto parseDelimitedFrom(InputStream inputStream, com.google.protobuf.q qVar) throws IOException {
            return (ServiceDescriptorProto) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
        }

        public static ServiceDescriptorProto parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
        public ServiceDescriptorProto getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b toBuilder() {
            return this == DEFAULT_INSTANCE ? new b((a) null) : new b((a) null).r(this);
        }

        public static ServiceDescriptorProto parseFrom(byte[] bArr, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b newBuilderForType() {
            return newBuilder();
        }

        private ServiceDescriptorProto() {
            this.memoizedIsInitialized = (byte) -1;
            this.name_ = "";
            this.method_ = Collections.emptyList();
        }

        public static ServiceDescriptorProto parseFrom(InputStream inputStream) throws IOException {
            return (ServiceDescriptorProto) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static ServiceDescriptorProto parseFrom(InputStream inputStream, com.google.protobuf.q qVar) throws IOException {
            return (ServiceDescriptorProto) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private ServiceDescriptorProto(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
            this();
            a1.b g10 = a1.g();
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
                                    ByteString m10 = iVar.m();
                                    this.bitField0_ = 1 | this.bitField0_;
                                    this.name_ = m10;
                                } else if (F == 18) {
                                    if (!(z11 & true)) {
                                        this.method_ = new ArrayList();
                                        z11 |= true;
                                    }
                                    this.method_.add(iVar.v(MethodDescriptorProto.PARSER, qVar));
                                } else if (F == 26) {
                                    ServiceOptions.b builder = (this.bitField0_ & 2) == 2 ? this.options_.toBuilder() : null;
                                    ServiceOptions serviceOptions = (ServiceOptions) iVar.v(ServiceOptions.PARSER, qVar);
                                    this.options_ = serviceOptions;
                                    if (builder != null) {
                                        builder.A(serviceOptions);
                                        this.options_ = builder.buildPartial();
                                    }
                                    this.bitField0_ |= 2;
                                } else if (!parseUnknownField(iVar, g10, qVar, F)) {
                                }
                            }
                            z10 = true;
                        } catch (InvalidProtocolBufferException e10) {
                            throw e10.setUnfinishedMessage(this);
                        }
                    } catch (IOException e11) {
                        throw new InvalidProtocolBufferException(e11).setUnfinishedMessage(this);
                    }
                } finally {
                    if (z11 & true) {
                        this.method_ = Collections.unmodifiableList(this.method_);
                    }
                    this.unknownFields = g10.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static ServiceDescriptorProto parseFrom(com.google.protobuf.i iVar) throws IOException {
            return (ServiceDescriptorProto) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
        }

        public static ServiceDescriptorProto parseFrom(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws IOException {
            return (ServiceDescriptorProto) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
        }
    }

    /* loaded from: classes.dex */
    public static final class ServiceOptions extends GeneratedMessageV3.ExtendableMessage<ServiceOptions> implements q {
        public static final int DEPRECATED_FIELD_NUMBER = 33;
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private boolean deprecated_;
        private byte memoizedIsInitialized;
        private List<UninterpretedOption> uninterpretedOption_;
        private static final ServiceOptions DEFAULT_INSTANCE = new ServiceOptions();
        @Deprecated
        public static final l0<ServiceOptions> PARSER = new a();

        /* loaded from: classes.dex */
        static class a extends com.google.protobuf.c<ServiceOptions> {
            a() {
            }

            /* renamed from: a */
            public ServiceOptions parsePartialFrom(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
                return new ServiceOptions(iVar, qVar, null);
            }
        }

        /* loaded from: classes.dex */
        public static final class b extends GeneratedMessageV3.d<ServiceOptions, b> implements q {

            /* renamed from: b  reason: collision with root package name */
            private int f12893b;

            /* renamed from: c  reason: collision with root package name */
            private boolean f12894c;

            /* renamed from: d  reason: collision with root package name */
            private List<UninterpretedOption> f12895d;

            /* renamed from: e  reason: collision with root package name */
            private o0<UninterpretedOption, UninterpretedOption.b, s> f12896e;

            /* synthetic */ b(a aVar) {
                this();
            }

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                    y();
                }
            }

            private void u() {
                if ((this.f12893b & 2) != 2) {
                    this.f12895d = new ArrayList(this.f12895d);
                    this.f12893b |= 2;
                }
            }

            private o0<UninterpretedOption, UninterpretedOption.b, s> y() {
                if (this.f12896e == null) {
                    this.f12896e = new o0<>(this.f12895d, (this.f12893b & 2) == 2, getParentForChildren(), isClean());
                    this.f12895d = null;
                }
                return this.f12896e;
            }

            public b A(ServiceOptions serviceOptions) {
                if (serviceOptions == ServiceOptions.getDefaultInstance()) {
                    return this;
                }
                if (serviceOptions.hasDeprecated()) {
                    D(serviceOptions.getDeprecated());
                }
                if (this.f12896e == null) {
                    if (!serviceOptions.uninterpretedOption_.isEmpty()) {
                        if (this.f12895d.isEmpty()) {
                            this.f12895d = serviceOptions.uninterpretedOption_;
                            this.f12893b &= -3;
                        } else {
                            u();
                            this.f12895d.addAll(serviceOptions.uninterpretedOption_);
                        }
                        onChanged();
                    }
                } else if (!serviceOptions.uninterpretedOption_.isEmpty()) {
                    if (this.f12896e.u()) {
                        this.f12896e.i();
                        o0<UninterpretedOption, UninterpretedOption.b, s> o0Var = null;
                        this.f12896e = null;
                        this.f12895d = serviceOptions.uninterpretedOption_;
                        this.f12893b &= -3;
                        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                            o0Var = y();
                        }
                        this.f12896e = o0Var;
                    } else {
                        this.f12896e.b(serviceOptions.uninterpretedOption_);
                    }
                }
                j(serviceOptions);
                mergeUnknownFields(serviceOptions.unknownFields);
                onChanged();
                return this;
            }

            /* renamed from: B */
            public b mergeFrom(d0 d0Var) {
                if (d0Var instanceof ServiceOptions) {
                    return A((ServiceOptions) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            /* renamed from: C */
            public final b mergeUnknownFields(a1 a1Var) {
                return (b) super.mergeUnknownFields(a1Var);
            }

            public b D(boolean z10) {
                this.f12893b |= 1;
                this.f12894c = z10;
                onChanged();
                return this;
            }

            /* renamed from: E */
            public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.setField(fieldDescriptor, obj);
            }

            /* renamed from: F */
            public b setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i10, Object obj) {
                return (b) super.setRepeatedField(fieldDescriptor, i10, obj);
            }

            /* renamed from: G */
            public final b setUnknownFields(a1 a1Var) {
                return (b) super.setUnknownFields(a1Var);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a, com.google.protobuf.g0
            public Descriptors.b getDescriptorForType() {
                return DescriptorProtos.I;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return DescriptorProtos.J.e(ServiceOptions.class, b.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.d, com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.f0
            public final boolean isInitialized() {
                for (int i10 = 0; i10 < x(); i10++) {
                    if (!w(i10).isInitialized()) {
                        return false;
                    }
                }
                return i();
            }

            /* renamed from: n */
            public b b(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.addRepeatedField(fieldDescriptor, obj);
            }

            /* renamed from: o */
            public ServiceOptions build() {
                ServiceOptions p10 = buildPartial();
                if (p10.isInitialized()) {
                    return p10;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) p10);
            }

            /* renamed from: p */
            public ServiceOptions buildPartial() {
                ServiceOptions serviceOptions = new ServiceOptions(this, (a) null);
                int i10 = 1;
                if ((this.f12893b & 1) != 1) {
                    i10 = 0;
                }
                serviceOptions.deprecated_ = this.f12894c;
                o0<UninterpretedOption, UninterpretedOption.b, s> o0Var = this.f12896e;
                if (o0Var == null) {
                    if ((this.f12893b & 2) == 2) {
                        this.f12895d = Collections.unmodifiableList(this.f12895d);
                        this.f12893b &= -3;
                    }
                    serviceOptions.uninterpretedOption_ = this.f12895d;
                } else {
                    serviceOptions.uninterpretedOption_ = o0Var.g();
                }
                serviceOptions.bitField0_ = i10;
                onBuilt();
                return serviceOptions;
            }

            /* renamed from: q */
            public b d() {
                super.clear();
                this.f12894c = false;
                this.f12893b &= -2;
                o0<UninterpretedOption, UninterpretedOption.b, s> o0Var = this.f12896e;
                if (o0Var == null) {
                    this.f12895d = Collections.emptyList();
                    this.f12893b &= -3;
                } else {
                    o0Var.h();
                }
                return this;
            }

            /* renamed from: r */
            public b e(Descriptors.FieldDescriptor fieldDescriptor) {
                return (b) super.clearField(fieldDescriptor);
            }

            /* renamed from: s */
            public b clearOneof(Descriptors.h hVar) {
                return (b) super.clearOneof(hVar);
            }

            /* renamed from: t */
            public b f() {
                return (b) super.clone();
            }

            /* renamed from: v */
            public ServiceOptions getDefaultInstanceForType() {
                return ServiceOptions.getDefaultInstance();
            }

            public UninterpretedOption w(int i10) {
                o0<UninterpretedOption, UninterpretedOption.b, s> o0Var = this.f12896e;
                if (o0Var == null) {
                    return this.f12895d.get(i10);
                }
                return o0Var.o(i10);
            }

            public int x() {
                o0<UninterpretedOption, UninterpretedOption.b, s> o0Var = this.f12896e;
                if (o0Var == null) {
                    return this.f12895d.size();
                }
                return o0Var.n();
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x0021  */
            /* renamed from: z */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public b mergeFrom(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws IOException {
                Throwable th2;
                ServiceOptions serviceOptions = null;
                try {
                    try {
                        ServiceOptions parsePartialFrom = ServiceOptions.PARSER.parsePartialFrom(iVar, qVar);
                        if (parsePartialFrom != null) {
                            A(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e10) {
                        serviceOptions = (ServiceOptions) e10.getUnfinishedMessage();
                        try {
                            throw e10.unwrapIOException();
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (serviceOptions != null) {
                                A(serviceOptions);
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (serviceOptions != null) {
                    }
                    throw th2;
                }
            }

            /* synthetic */ b(GeneratedMessageV3.c cVar, a aVar) {
                this(cVar);
            }

            private b() {
                this.f12895d = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.f12895d = Collections.emptyList();
                maybeForceBuilderInitialization();
            }
        }

        /* synthetic */ ServiceOptions(com.google.protobuf.i iVar, com.google.protobuf.q qVar, a aVar) throws InvalidProtocolBufferException {
            this(iVar, qVar);
        }

        public static ServiceOptions getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return DescriptorProtos.I;
        }

        public static b newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static ServiceOptions parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ServiceOptions) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static ServiceOptions parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static l0<ServiceOptions> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ServiceOptions)) {
                return super.equals(obj);
            }
            ServiceOptions serviceOptions = (ServiceOptions) obj;
            boolean z10 = hasDeprecated() == serviceOptions.hasDeprecated();
            if (hasDeprecated()) {
                z10 = z10 && getDeprecated() == serviceOptions.getDeprecated();
            }
            return ((z10 && getUninterpretedOptionList().equals(serviceOptions.getUninterpretedOptionList())) && this.unknownFields.equals(serviceOptions.unknownFields)) && d().equals(serviceOptions.d());
        }

        public boolean getDeprecated() {
            return this.deprecated_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public l0<ServiceOptions> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
        public int getSerializedSize() {
            int i10 = this.memoizedSize;
            if (i10 != -1) {
                return i10;
            }
            int e10 = (this.bitField0_ & 1) == 1 ? CodedOutputStream.e(33, this.deprecated_) + 0 : 0;
            for (int i11 = 0; i11 < this.uninterpretedOption_.size(); i11++) {
                e10 += CodedOutputStream.E(999, this.uninterpretedOption_.get(i11));
            }
            int c10 = e10 + c() + this.unknownFields.getSerializedSize();
            this.memoizedSize = c10;
            return c10;
        }

        public UninterpretedOption getUninterpretedOption(int i10) {
            return this.uninterpretedOption_.get(i10);
        }

        public int getUninterpretedOptionCount() {
            return this.uninterpretedOption_.size();
        }

        public List<UninterpretedOption> getUninterpretedOptionList() {
            return this.uninterpretedOption_;
        }

        public s getUninterpretedOptionOrBuilder(int i10) {
            return this.uninterpretedOption_.get(i10);
        }

        public List<? extends s> getUninterpretedOptionOrBuilderList() {
            return this.uninterpretedOption_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.g0
        public final a1 getUnknownFields() {
            return this.unknownFields;
        }

        public boolean hasDeprecated() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // com.google.protobuf.a
        public int hashCode() {
            int i10 = this.memoizedHashCode;
            if (i10 != 0) {
                return i10;
            }
            int hashCode = 779 + getDescriptorForType().hashCode();
            if (hasDeprecated()) {
                hashCode = (((hashCode * 37) + 33) * 53) + u.c(getDeprecated());
            }
            if (getUninterpretedOptionCount() > 0) {
                hashCode = (((hashCode * 37) + 999) * 53) + getUninterpretedOptionList().hashCode();
            }
            int hashFields = (com.google.protobuf.a.hashFields(hashCode, d()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashFields;
            return hashFields;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return DescriptorProtos.J.e(ServiceOptions.class, b.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessage, com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.f0
        public final boolean isInitialized() {
            byte b10 = this.memoizedIsInitialized;
            if (b10 == 1) {
                return true;
            }
            if (b10 == 0) {
                return false;
            }
            for (int i10 = 0; i10 < getUninterpretedOptionCount(); i10++) {
                if (!getUninterpretedOption(i10).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (!b()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: n */
        public b newBuilderForType(GeneratedMessageV3.c cVar) {
            return new b(cVar, null);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            GeneratedMessageV3.ExtendableMessage<MessageType>.a g10 = g();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.e0(33, this.deprecated_);
            }
            for (int i10 = 0; i10 < this.uninterpretedOption_.size(); i10++) {
                codedOutputStream.A0(999, this.uninterpretedOption_.get(i10));
            }
            g10.a(536870912, codedOutputStream);
            this.unknownFields.writeTo(codedOutputStream);
        }

        /* synthetic */ ServiceOptions(GeneratedMessageV3.d dVar, a aVar) {
            this(dVar);
        }

        public static b newBuilder(ServiceOptions serviceOptions) {
            return DEFAULT_INSTANCE.toBuilder().A(serviceOptions);
        }

        public static ServiceOptions parseFrom(ByteString byteString, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, qVar);
        }

        private ServiceOptions(GeneratedMessageV3.d<ServiceOptions, ?> dVar) {
            super(dVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static ServiceOptions parseDelimitedFrom(InputStream inputStream, com.google.protobuf.q qVar) throws IOException {
            return (ServiceOptions) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
        }

        public static ServiceOptions parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessage, com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
        public ServiceOptions getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessage, com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b toBuilder() {
            return this == DEFAULT_INSTANCE ? new b((a) null) : new b((a) null).A(this);
        }

        public static ServiceOptions parseFrom(byte[] bArr, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessage, com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b newBuilderForType() {
            return newBuilder();
        }

        private ServiceOptions() {
            this.memoizedIsInitialized = (byte) -1;
            this.deprecated_ = false;
            this.uninterpretedOption_ = Collections.emptyList();
        }

        public static ServiceOptions parseFrom(InputStream inputStream) throws IOException {
            return (ServiceOptions) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static ServiceOptions parseFrom(InputStream inputStream, com.google.protobuf.q qVar) throws IOException {
            return (ServiceOptions) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private ServiceOptions(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
            this();
            a1.b g10 = a1.g();
            boolean z10 = false;
            boolean z11 = false;
            while (true) {
                if (z10) {
                    break;
                }
                try {
                    try {
                        int F = iVar.F();
                        if (F != 0) {
                            if (F == 264) {
                                this.bitField0_ |= 1;
                                this.deprecated_ = iVar.l();
                            } else if (F == 7994) {
                                if (!(z11 & true)) {
                                    this.uninterpretedOption_ = new ArrayList();
                                    z11 |= true;
                                }
                                this.uninterpretedOption_.add(iVar.v(UninterpretedOption.PARSER, qVar));
                            } else if (!parseUnknownField(iVar, g10, qVar, F)) {
                            }
                        }
                        z10 = true;
                    } catch (InvalidProtocolBufferException e10) {
                        throw e10.setUnfinishedMessage(this);
                    } catch (IOException e11) {
                        throw new InvalidProtocolBufferException(e11).setUnfinishedMessage(this);
                    }
                } finally {
                    if (z11 & true) {
                        this.uninterpretedOption_ = Collections.unmodifiableList(this.uninterpretedOption_);
                    }
                    this.unknownFields = g10.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static ServiceOptions parseFrom(com.google.protobuf.i iVar) throws IOException {
            return (ServiceOptions) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
        }

        public static ServiceOptions parseFrom(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws IOException {
            return (ServiceOptions) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
        }
    }

    /* loaded from: classes.dex */
    public static final class SourceCodeInfo extends GeneratedMessageV3 implements r {
        public static final int LOCATION_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private List<Location> location_;
        private byte memoizedIsInitialized;
        private static final SourceCodeInfo DEFAULT_INSTANCE = new SourceCodeInfo();
        @Deprecated
        public static final l0<SourceCodeInfo> PARSER = new a();

        /* loaded from: classes.dex */
        public static final class Location extends GeneratedMessageV3 implements c {
            public static final int LEADING_COMMENTS_FIELD_NUMBER = 3;
            public static final int LEADING_DETACHED_COMMENTS_FIELD_NUMBER = 6;
            public static final int PATH_FIELD_NUMBER = 1;
            public static final int SPAN_FIELD_NUMBER = 2;
            public static final int TRAILING_COMMENTS_FIELD_NUMBER = 4;
            private static final long serialVersionUID = 0;
            private int bitField0_;
            private volatile Object leadingComments_;
            private y leadingDetachedComments_;
            private byte memoizedIsInitialized;
            private int pathMemoizedSerializedSize;
            private List<Integer> path_;
            private int spanMemoizedSerializedSize;
            private List<Integer> span_;
            private volatile Object trailingComments_;
            private static final Location DEFAULT_INSTANCE = new Location();
            @Deprecated
            public static final l0<Location> PARSER = new a();

            /* loaded from: classes.dex */
            static class a extends com.google.protobuf.c<Location> {
                a() {
                }

                /* renamed from: a */
                public Location parsePartialFrom(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
                    return new Location(iVar, qVar, null);
                }
            }

            /* loaded from: classes.dex */
            public static final class b extends GeneratedMessageV3.b<b> implements c {

                /* renamed from: a  reason: collision with root package name */
                private int f12897a;

                /* renamed from: b  reason: collision with root package name */
                private List<Integer> f12898b;

                /* renamed from: c  reason: collision with root package name */
                private List<Integer> f12899c;

                /* renamed from: d  reason: collision with root package name */
                private Object f12900d;

                /* renamed from: e  reason: collision with root package name */
                private Object f12901e;

                /* renamed from: f  reason: collision with root package name */
                private y f12902f;

                /* synthetic */ b(a aVar) {
                    this();
                }

                private void i() {
                    if ((this.f12897a & 16) != 16) {
                        this.f12902f = new x(this.f12902f);
                        this.f12897a |= 16;
                    }
                }

                private void j() {
                    if ((this.f12897a & 1) != 1) {
                        this.f12898b = new ArrayList(this.f12898b);
                        this.f12897a |= 1;
                    }
                }

                private void k() {
                    if ((this.f12897a & 2) != 2) {
                        this.f12899c = new ArrayList(this.f12899c);
                        this.f12897a |= 2;
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
                public Location build() {
                    Location c10 = buildPartial();
                    if (c10.isInitialized()) {
                        return c10;
                    }
                    throw a.AbstractC0170a.newUninitializedMessageException((d0) c10);
                }

                /* renamed from: c */
                public Location buildPartial() {
                    Location location = new Location(this, (a) null);
                    int i10 = this.f12897a;
                    int i11 = 1;
                    if ((i10 & 1) == 1) {
                        this.f12898b = Collections.unmodifiableList(this.f12898b);
                        this.f12897a &= -2;
                    }
                    location.path_ = this.f12898b;
                    if ((this.f12897a & 2) == 2) {
                        this.f12899c = Collections.unmodifiableList(this.f12899c);
                        this.f12897a &= -3;
                    }
                    location.span_ = this.f12899c;
                    if ((i10 & 4) != 4) {
                        i11 = 0;
                    }
                    location.leadingComments_ = this.f12900d;
                    if ((i10 & 8) == 8) {
                        i11 |= 2;
                    }
                    location.trailingComments_ = this.f12901e;
                    if ((this.f12897a & 16) == 16) {
                        this.f12902f = this.f12902f.u0();
                        this.f12897a &= -17;
                    }
                    location.leadingDetachedComments_ = this.f12902f;
                    location.bitField0_ = i11;
                    onBuilt();
                    return location;
                }

                /* renamed from: d */
                public b clear() {
                    super.clear();
                    this.f12898b = Collections.emptyList();
                    this.f12897a &= -2;
                    this.f12899c = Collections.emptyList();
                    int i10 = this.f12897a & (-3);
                    this.f12897a = i10;
                    this.f12900d = "";
                    int i11 = i10 & (-5);
                    this.f12897a = i11;
                    this.f12901e = "";
                    int i12 = i11 & (-9);
                    this.f12897a = i12;
                    this.f12902f = x.f13385d;
                    this.f12897a = i12 & (-17);
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
                    return DescriptorProtos.S;
                }

                @Override // com.google.protobuf.GeneratedMessageV3.b
                protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                    return DescriptorProtos.T.e(Location.class, b.class);
                }

                @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.f0
                public final boolean isInitialized() {
                    return true;
                }

                /* renamed from: l */
                public Location getDefaultInstanceForType() {
                    return Location.getDefaultInstance();
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0021  */
                /* renamed from: m */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public b mergeFrom(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws IOException {
                    Throwable th2;
                    Location location = null;
                    try {
                        try {
                            Location parsePartialFrom = Location.PARSER.parsePartialFrom(iVar, qVar);
                            if (parsePartialFrom != null) {
                                n(parsePartialFrom);
                            }
                            return this;
                        } catch (InvalidProtocolBufferException e10) {
                            location = (Location) e10.getUnfinishedMessage();
                            try {
                                throw e10.unwrapIOException();
                            } catch (Throwable th3) {
                                th2 = th3;
                                if (location != null) {
                                    n(location);
                                }
                                throw th2;
                            }
                        }
                    } catch (Throwable th4) {
                        th2 = th4;
                        if (location != null) {
                        }
                        throw th2;
                    }
                }

                public b n(Location location) {
                    if (location == Location.getDefaultInstance()) {
                        return this;
                    }
                    if (!location.path_.isEmpty()) {
                        if (this.f12898b.isEmpty()) {
                            this.f12898b = location.path_;
                            this.f12897a &= -2;
                        } else {
                            j();
                            this.f12898b.addAll(location.path_);
                        }
                        onChanged();
                    }
                    if (!location.span_.isEmpty()) {
                        if (this.f12899c.isEmpty()) {
                            this.f12899c = location.span_;
                            this.f12897a &= -3;
                        } else {
                            k();
                            this.f12899c.addAll(location.span_);
                        }
                        onChanged();
                    }
                    if (location.hasLeadingComments()) {
                        this.f12897a |= 4;
                        this.f12900d = location.leadingComments_;
                        onChanged();
                    }
                    if (location.hasTrailingComments()) {
                        this.f12897a |= 8;
                        this.f12901e = location.trailingComments_;
                        onChanged();
                    }
                    if (!location.leadingDetachedComments_.isEmpty()) {
                        if (this.f12902f.isEmpty()) {
                            this.f12902f = location.leadingDetachedComments_;
                            this.f12897a &= -17;
                        } else {
                            i();
                            this.f12902f.addAll(location.leadingDetachedComments_);
                        }
                        onChanged();
                    }
                    mergeUnknownFields(location.unknownFields);
                    onChanged();
                    return this;
                }

                /* renamed from: o */
                public b mergeFrom(d0 d0Var) {
                    if (d0Var instanceof Location) {
                        return n((Location) d0Var);
                    }
                    super.mergeFrom(d0Var);
                    return this;
                }

                /* renamed from: p */
                public final b mergeUnknownFields(a1 a1Var) {
                    return (b) super.mergeUnknownFields(a1Var);
                }

                /* renamed from: q */
                public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                    return (b) super.setField(fieldDescriptor, obj);
                }

                /* renamed from: r */
                public b setRepeatedField2(Descriptors.FieldDescriptor fieldDescriptor, int i10, Object obj) {
                    return (b) super.setRepeatedField(fieldDescriptor, i10, obj);
                }

                /* renamed from: s */
                public final b setUnknownFields(a1 a1Var) {
                    return (b) super.setUnknownFields(a1Var);
                }

                /* synthetic */ b(GeneratedMessageV3.c cVar, a aVar) {
                    this(cVar);
                }

                private b() {
                    this.f12898b = Collections.emptyList();
                    this.f12899c = Collections.emptyList();
                    this.f12900d = "";
                    this.f12901e = "";
                    this.f12902f = x.f13385d;
                    maybeForceBuilderInitialization();
                }

                private b(GeneratedMessageV3.c cVar) {
                    super(cVar);
                    this.f12898b = Collections.emptyList();
                    this.f12899c = Collections.emptyList();
                    this.f12900d = "";
                    this.f12901e = "";
                    this.f12902f = x.f13385d;
                    maybeForceBuilderInitialization();
                }
            }

            /* synthetic */ Location(com.google.protobuf.i iVar, com.google.protobuf.q qVar, a aVar) throws InvalidProtocolBufferException {
                this(iVar, qVar);
            }

            public static Location getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static final Descriptors.b getDescriptor() {
                return DescriptorProtos.S;
            }

            public static b newBuilder() {
                return DEFAULT_INSTANCE.toBuilder();
            }

            public static Location parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (Location) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
            }

            public static Location parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteString);
            }

            public static l0<Location> parser() {
                return PARSER;
            }

            @Override // com.google.protobuf.a
            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof Location)) {
                    return super.equals(obj);
                }
                Location location = (Location) obj;
                boolean z10 = ((getPathList().equals(location.getPathList())) && getSpanList().equals(location.getSpanList())) && hasLeadingComments() == location.hasLeadingComments();
                if (hasLeadingComments()) {
                    z10 = z10 && getLeadingComments().equals(location.getLeadingComments());
                }
                boolean z11 = z10 && hasTrailingComments() == location.hasTrailingComments();
                if (hasTrailingComments()) {
                    z11 = z11 && getTrailingComments().equals(location.getTrailingComments());
                }
                return (z11 && getLeadingDetachedCommentsList().equals(location.getLeadingDetachedCommentsList())) && this.unknownFields.equals(location.unknownFields);
            }

            public String getLeadingComments() {
                Object obj = this.leadingComments_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                ByteString byteString = (ByteString) obj;
                String stringUtf8 = byteString.toStringUtf8();
                if (byteString.isValidUtf8()) {
                    this.leadingComments_ = stringUtf8;
                }
                return stringUtf8;
            }

            public ByteString getLeadingCommentsBytes() {
                Object obj = this.leadingComments_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.leadingComments_ = copyFromUtf8;
                return copyFromUtf8;
            }

            public String getLeadingDetachedComments(int i10) {
                return this.leadingDetachedComments_.get(i10);
            }

            public ByteString getLeadingDetachedCommentsBytes(int i10) {
                return this.leadingDetachedComments_.o0(i10);
            }

            public int getLeadingDetachedCommentsCount() {
                return this.leadingDetachedComments_.size();
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
            public l0<Location> getParserForType() {
                return PARSER;
            }

            public int getPath(int i10) {
                return this.path_.get(i10).intValue();
            }

            public int getPathCount() {
                return this.path_.size();
            }

            public List<Integer> getPathList() {
                return this.path_;
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
            public int getSerializedSize() {
                int i10 = this.memoizedSize;
                if (i10 != -1) {
                    return i10;
                }
                int i11 = 0;
                for (int i12 = 0; i12 < this.path_.size(); i12++) {
                    i11 += CodedOutputStream.w(this.path_.get(i12).intValue());
                }
                int i13 = 0 + i11;
                if (!getPathList().isEmpty()) {
                    i13 = i13 + 1 + CodedOutputStream.w(i11);
                }
                this.pathMemoizedSerializedSize = i11;
                int i14 = 0;
                for (int i15 = 0; i15 < this.span_.size(); i15++) {
                    i14 += CodedOutputStream.w(this.span_.get(i15).intValue());
                }
                int i16 = i13 + i14;
                if (!getSpanList().isEmpty()) {
                    i16 = i16 + 1 + CodedOutputStream.w(i14);
                }
                this.spanMemoizedSerializedSize = i14;
                if ((this.bitField0_ & 1) == 1) {
                    i16 += GeneratedMessageV3.computeStringSize(3, this.leadingComments_);
                }
                if ((this.bitField0_ & 2) == 2) {
                    i16 += GeneratedMessageV3.computeStringSize(4, this.trailingComments_);
                }
                int i17 = 0;
                for (int i18 = 0; i18 < this.leadingDetachedComments_.size(); i18++) {
                    i17 += GeneratedMessageV3.computeStringSizeNoTag(this.leadingDetachedComments_.z0(i18));
                }
                int size = i16 + i17 + (getLeadingDetachedCommentsList().size() * 1) + this.unknownFields.getSerializedSize();
                this.memoizedSize = size;
                return size;
            }

            public int getSpan(int i10) {
                return this.span_.get(i10).intValue();
            }

            public int getSpanCount() {
                return this.span_.size();
            }

            public List<Integer> getSpanList() {
                return this.span_;
            }

            public String getTrailingComments() {
                Object obj = this.trailingComments_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                ByteString byteString = (ByteString) obj;
                String stringUtf8 = byteString.toStringUtf8();
                if (byteString.isValidUtf8()) {
                    this.trailingComments_ = stringUtf8;
                }
                return stringUtf8;
            }

            public ByteString getTrailingCommentsBytes() {
                Object obj = this.trailingComments_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.trailingComments_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.g0
            public final a1 getUnknownFields() {
                return this.unknownFields;
            }

            public boolean hasLeadingComments() {
                return (this.bitField0_ & 1) == 1;
            }

            public boolean hasTrailingComments() {
                return (this.bitField0_ & 2) == 2;
            }

            @Override // com.google.protobuf.a
            public int hashCode() {
                int i10 = this.memoizedHashCode;
                if (i10 != 0) {
                    return i10;
                }
                int hashCode = 779 + getDescriptorForType().hashCode();
                if (getPathCount() > 0) {
                    hashCode = (((hashCode * 37) + 1) * 53) + getPathList().hashCode();
                }
                if (getSpanCount() > 0) {
                    hashCode = (((hashCode * 37) + 2) * 53) + getSpanList().hashCode();
                }
                if (hasLeadingComments()) {
                    hashCode = (((hashCode * 37) + 3) * 53) + getLeadingComments().hashCode();
                }
                if (hasTrailingComments()) {
                    hashCode = (((hashCode * 37) + 4) * 53) + getTrailingComments().hashCode();
                }
                if (getLeadingDetachedCommentsCount() > 0) {
                    hashCode = (((hashCode * 37) + 6) * 53) + getLeadingDetachedCommentsList().hashCode();
                }
                int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
                this.memoizedHashCode = hashCode2;
                return hashCode2;
            }

            @Override // com.google.protobuf.GeneratedMessageV3
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return DescriptorProtos.T.e(Location.class, b.class);
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

            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: n */
            public b newBuilderForType(GeneratedMessageV3.c cVar) {
                return new b(cVar, null);
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
            public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                getSerializedSize();
                if (getPathList().size() > 0) {
                    codedOutputStream.N0(10);
                    codedOutputStream.N0(this.pathMemoizedSerializedSize);
                }
                for (int i10 = 0; i10 < this.path_.size(); i10++) {
                    codedOutputStream.x0(this.path_.get(i10).intValue());
                }
                if (getSpanList().size() > 0) {
                    codedOutputStream.N0(18);
                    codedOutputStream.N0(this.spanMemoizedSerializedSize);
                }
                for (int i11 = 0; i11 < this.span_.size(); i11++) {
                    codedOutputStream.x0(this.span_.get(i11).intValue());
                }
                if ((this.bitField0_ & 1) == 1) {
                    GeneratedMessageV3.writeString(codedOutputStream, 3, this.leadingComments_);
                }
                if ((this.bitField0_ & 2) == 2) {
                    GeneratedMessageV3.writeString(codedOutputStream, 4, this.trailingComments_);
                }
                for (int i12 = 0; i12 < this.leadingDetachedComments_.size(); i12++) {
                    GeneratedMessageV3.writeString(codedOutputStream, 6, this.leadingDetachedComments_.z0(i12));
                }
                this.unknownFields.writeTo(codedOutputStream);
            }

            /* synthetic */ Location(GeneratedMessageV3.b bVar, a aVar) {
                this(bVar);
            }

            public static b newBuilder(Location location) {
                return DEFAULT_INSTANCE.toBuilder().n(location);
            }

            public static Location parseFrom(ByteString byteString, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteString, qVar);
            }

            public n0 getLeadingDetachedCommentsList() {
                return this.leadingDetachedComments_;
            }

            private Location(GeneratedMessageV3.b<?> bVar) {
                super(bVar);
                this.pathMemoizedSerializedSize = -1;
                this.spanMemoizedSerializedSize = -1;
                this.memoizedIsInitialized = (byte) -1;
            }

            public static Location parseDelimitedFrom(InputStream inputStream, com.google.protobuf.q qVar) throws IOException {
                return (Location) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
            }

            public static Location parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(bArr);
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
            public Location getDefaultInstanceForType() {
                return DEFAULT_INSTANCE;
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
            public b toBuilder() {
                return this == DEFAULT_INSTANCE ? new b((a) null) : new b((a) null).n(this);
            }

            public static Location parseFrom(byte[] bArr, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(bArr, qVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
            public b newBuilderForType() {
                return newBuilder();
            }

            public static Location parseFrom(InputStream inputStream) throws IOException {
                return (Location) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
            }

            private Location() {
                this.pathMemoizedSerializedSize = -1;
                this.spanMemoizedSerializedSize = -1;
                this.memoizedIsInitialized = (byte) -1;
                this.path_ = Collections.emptyList();
                this.span_ = Collections.emptyList();
                this.leadingComments_ = "";
                this.trailingComments_ = "";
                this.leadingDetachedComments_ = x.f13385d;
            }

            public static Location parseFrom(InputStream inputStream, com.google.protobuf.q qVar) throws IOException {
                return (Location) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
            }

            public static Location parseFrom(com.google.protobuf.i iVar) throws IOException {
                return (Location) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
            }

            public static Location parseFrom(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws IOException {
                return (Location) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
            }

            private Location(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
                this();
                a1.b g10 = a1.g();
                boolean z10 = false;
                boolean z11 = false;
                while (true) {
                    if (z10) {
                        break;
                    }
                    try {
                        try {
                            int F = iVar.F();
                            if (F != 0) {
                                if (F == 8) {
                                    if (!z11 || !true) {
                                        this.path_ = new ArrayList();
                                        z11 |= true;
                                    }
                                    this.path_.add(Integer.valueOf(iVar.t()));
                                } else if (F == 10) {
                                    int k10 = iVar.k(iVar.x());
                                    if ((!z11 || !true) && iVar.d() > 0) {
                                        this.path_ = new ArrayList();
                                        z11 |= true;
                                    }
                                    while (iVar.d() > 0) {
                                        this.path_.add(Integer.valueOf(iVar.t()));
                                    }
                                    iVar.j(k10);
                                } else if (F == 16) {
                                    if (!(z11 & true)) {
                                        this.span_ = new ArrayList();
                                        z11 |= true;
                                    }
                                    this.span_.add(Integer.valueOf(iVar.t()));
                                } else if (F == 18) {
                                    int k11 = iVar.k(iVar.x());
                                    if (!(z11 & true) && iVar.d() > 0) {
                                        this.span_ = new ArrayList();
                                        z11 |= true;
                                    }
                                    while (iVar.d() > 0) {
                                        this.span_.add(Integer.valueOf(iVar.t()));
                                    }
                                    iVar.j(k11);
                                } else if (F == 26) {
                                    ByteString m10 = iVar.m();
                                    this.bitField0_ |= 1;
                                    this.leadingComments_ = m10;
                                } else if (F == 34) {
                                    ByteString m11 = iVar.m();
                                    this.bitField0_ |= 2;
                                    this.trailingComments_ = m11;
                                } else if (F == 50) {
                                    ByteString m12 = iVar.m();
                                    if (!(z11 & true)) {
                                        this.leadingDetachedComments_ = new x();
                                        z11 |= true;
                                    }
                                    this.leadingDetachedComments_.v(m12);
                                } else if (!parseUnknownField(iVar, g10, qVar, F)) {
                                }
                            }
                            z10 = true;
                        } catch (InvalidProtocolBufferException e10) {
                            throw e10.setUnfinishedMessage(this);
                        } catch (IOException e11) {
                            throw new InvalidProtocolBufferException(e11).setUnfinishedMessage(this);
                        }
                    } finally {
                        if (z11 && true) {
                            this.path_ = Collections.unmodifiableList(this.path_);
                        }
                        if (z11 & true) {
                            this.span_ = Collections.unmodifiableList(this.span_);
                        }
                        if (z11 & true) {
                            this.leadingDetachedComments_ = this.leadingDetachedComments_.u0();
                        }
                        this.unknownFields = g10.build();
                        makeExtensionsImmutable();
                    }
                }
            }
        }

        /* loaded from: classes.dex */
        static class a extends com.google.protobuf.c<SourceCodeInfo> {
            a() {
            }

            /* renamed from: a */
            public SourceCodeInfo parsePartialFrom(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
                return new SourceCodeInfo(iVar, qVar, null);
            }
        }

        /* loaded from: classes.dex */
        public static final class b extends GeneratedMessageV3.b<b> implements r {

            /* renamed from: a  reason: collision with root package name */
            private int f12903a;

            /* renamed from: b  reason: collision with root package name */
            private List<Location> f12904b;

            /* renamed from: c  reason: collision with root package name */
            private o0<Location, Location.b, c> f12905c;

            /* synthetic */ b(a aVar) {
                this();
            }

            private void i() {
                if ((this.f12903a & 1) != 1) {
                    this.f12904b = new ArrayList(this.f12904b);
                    this.f12903a |= 1;
                }
            }

            private o0<Location, Location.b, c> k() {
                if (this.f12905c == null) {
                    List<Location> list = this.f12904b;
                    boolean z10 = true;
                    if ((this.f12903a & 1) != 1) {
                        z10 = false;
                    }
                    this.f12905c = new o0<>(list, z10, getParentForChildren(), isClean());
                    this.f12904b = null;
                }
                return this.f12905c;
            }

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                    k();
                }
            }

            /* renamed from: a */
            public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.addRepeatedField(fieldDescriptor, obj);
            }

            /* renamed from: b */
            public SourceCodeInfo build() {
                SourceCodeInfo c10 = buildPartial();
                if (c10.isInitialized()) {
                    return c10;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) c10);
            }

            /* renamed from: c */
            public SourceCodeInfo buildPartial() {
                SourceCodeInfo sourceCodeInfo = new SourceCodeInfo(this, (a) null);
                int i10 = this.f12903a;
                o0<Location, Location.b, c> o0Var = this.f12905c;
                if (o0Var == null) {
                    if ((i10 & 1) == 1) {
                        this.f12904b = Collections.unmodifiableList(this.f12904b);
                        this.f12903a &= -2;
                    }
                    sourceCodeInfo.location_ = this.f12904b;
                } else {
                    sourceCodeInfo.location_ = o0Var.g();
                }
                onBuilt();
                return sourceCodeInfo;
            }

            /* renamed from: d */
            public b clear() {
                super.clear();
                o0<Location, Location.b, c> o0Var = this.f12905c;
                if (o0Var == null) {
                    this.f12904b = Collections.emptyList();
                    this.f12903a &= -2;
                } else {
                    o0Var.h();
                }
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
                return DescriptorProtos.Q;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return DescriptorProtos.R.e(SourceCodeInfo.class, b.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.f0
            public final boolean isInitialized() {
                return true;
            }

            /* renamed from: j */
            public SourceCodeInfo getDefaultInstanceForType() {
                return SourceCodeInfo.getDefaultInstance();
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x0021  */
            /* renamed from: l */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public b mergeFrom(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws IOException {
                Throwable th2;
                SourceCodeInfo sourceCodeInfo = null;
                try {
                    try {
                        SourceCodeInfo parsePartialFrom = SourceCodeInfo.PARSER.parsePartialFrom(iVar, qVar);
                        if (parsePartialFrom != null) {
                            m(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e10) {
                        sourceCodeInfo = (SourceCodeInfo) e10.getUnfinishedMessage();
                        try {
                            throw e10.unwrapIOException();
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (sourceCodeInfo != null) {
                                m(sourceCodeInfo);
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (sourceCodeInfo != null) {
                    }
                    throw th2;
                }
            }

            public b m(SourceCodeInfo sourceCodeInfo) {
                if (sourceCodeInfo == SourceCodeInfo.getDefaultInstance()) {
                    return this;
                }
                if (this.f12905c == null) {
                    if (!sourceCodeInfo.location_.isEmpty()) {
                        if (this.f12904b.isEmpty()) {
                            this.f12904b = sourceCodeInfo.location_;
                            this.f12903a &= -2;
                        } else {
                            i();
                            this.f12904b.addAll(sourceCodeInfo.location_);
                        }
                        onChanged();
                    }
                } else if (!sourceCodeInfo.location_.isEmpty()) {
                    if (this.f12905c.u()) {
                        this.f12905c.i();
                        o0<Location, Location.b, c> o0Var = null;
                        this.f12905c = null;
                        this.f12904b = sourceCodeInfo.location_;
                        this.f12903a &= -2;
                        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                            o0Var = k();
                        }
                        this.f12905c = o0Var;
                    } else {
                        this.f12905c.b(sourceCodeInfo.location_);
                    }
                }
                mergeUnknownFields(sourceCodeInfo.unknownFields);
                onChanged();
                return this;
            }

            /* renamed from: n */
            public b mergeFrom(d0 d0Var) {
                if (d0Var instanceof SourceCodeInfo) {
                    return m((SourceCodeInfo) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            /* renamed from: o */
            public final b mergeUnknownFields(a1 a1Var) {
                return (b) super.mergeUnknownFields(a1Var);
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
                return (b) super.setUnknownFields(a1Var);
            }

            /* synthetic */ b(GeneratedMessageV3.c cVar, a aVar) {
                this(cVar);
            }

            private b() {
                this.f12904b = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.f12904b = Collections.emptyList();
                maybeForceBuilderInitialization();
            }
        }

        /* loaded from: classes.dex */
        public interface c extends g0 {
        }

        /* synthetic */ SourceCodeInfo(com.google.protobuf.i iVar, com.google.protobuf.q qVar, a aVar) throws InvalidProtocolBufferException {
            this(iVar, qVar);
        }

        public static SourceCodeInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return DescriptorProtos.Q;
        }

        public static b newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static SourceCodeInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (SourceCodeInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static SourceCodeInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static l0<SourceCodeInfo> parser() {
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
            if (!(obj instanceof SourceCodeInfo)) {
                return super.equals(obj);
            }
            SourceCodeInfo sourceCodeInfo = (SourceCodeInfo) obj;
            return (getLocationList().equals(sourceCodeInfo.getLocationList())) && this.unknownFields.equals(sourceCodeInfo.unknownFields);
        }

        public Location getLocation(int i10) {
            return this.location_.get(i10);
        }

        public int getLocationCount() {
            return this.location_.size();
        }

        public List<Location> getLocationList() {
            return this.location_;
        }

        public c getLocationOrBuilder(int i10) {
            return this.location_.get(i10);
        }

        public List<? extends c> getLocationOrBuilderList() {
            return this.location_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public l0<SourceCodeInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
        public int getSerializedSize() {
            int i10 = this.memoizedSize;
            if (i10 != -1) {
                return i10;
            }
            int i11 = 0;
            for (int i12 = 0; i12 < this.location_.size(); i12++) {
                i11 += CodedOutputStream.E(1, this.location_.get(i12));
            }
            int serializedSize = i11 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.g0
        public final a1 getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.google.protobuf.a
        public int hashCode() {
            int i10 = this.memoizedHashCode;
            if (i10 != 0) {
                return i10;
            }
            int hashCode = 779 + getDescriptorForType().hashCode();
            if (getLocationCount() > 0) {
                hashCode = (((hashCode * 37) + 1) * 53) + getLocationList().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return DescriptorProtos.R.e(SourceCodeInfo.class, b.class);
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
            for (int i10 = 0; i10 < this.location_.size(); i10++) {
                codedOutputStream.A0(1, this.location_.get(i10));
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        /* synthetic */ SourceCodeInfo(GeneratedMessageV3.b bVar, a aVar) {
            this(bVar);
        }

        public static b newBuilder(SourceCodeInfo sourceCodeInfo) {
            return DEFAULT_INSTANCE.toBuilder().m(sourceCodeInfo);
        }

        public static SourceCodeInfo parseFrom(ByteString byteString, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, qVar);
        }

        private SourceCodeInfo(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static SourceCodeInfo parseDelimitedFrom(InputStream inputStream, com.google.protobuf.q qVar) throws IOException {
            return (SourceCodeInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
        }

        public static SourceCodeInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
        public SourceCodeInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b toBuilder() {
            return this == DEFAULT_INSTANCE ? new b((a) null) : new b((a) null).m(this);
        }

        public static SourceCodeInfo parseFrom(byte[] bArr, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b newBuilderForType() {
            return newBuilder();
        }

        private SourceCodeInfo() {
            this.memoizedIsInitialized = (byte) -1;
            this.location_ = Collections.emptyList();
        }

        public static SourceCodeInfo parseFrom(InputStream inputStream) throws IOException {
            return (SourceCodeInfo) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static SourceCodeInfo parseFrom(InputStream inputStream, com.google.protobuf.q qVar) throws IOException {
            return (SourceCodeInfo) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private SourceCodeInfo(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
            this();
            a1.b g10 = a1.g();
            boolean z10 = false;
            boolean z11 = false;
            while (true) {
                if (z10) {
                    break;
                }
                try {
                    try {
                        int F = iVar.F();
                        if (F != 0) {
                            if (F == 10) {
                                if (!z11 || !true) {
                                    this.location_ = new ArrayList();
                                    z11 |= true;
                                }
                                this.location_.add(iVar.v(Location.PARSER, qVar));
                            } else if (!parseUnknownField(iVar, g10, qVar, F)) {
                            }
                        }
                        z10 = true;
                    } catch (InvalidProtocolBufferException e10) {
                        throw e10.setUnfinishedMessage(this);
                    } catch (IOException e11) {
                        throw new InvalidProtocolBufferException(e11).setUnfinishedMessage(this);
                    }
                } finally {
                    if (z11 && true) {
                        this.location_ = Collections.unmodifiableList(this.location_);
                    }
                    this.unknownFields = g10.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static SourceCodeInfo parseFrom(com.google.protobuf.i iVar) throws IOException {
            return (SourceCodeInfo) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
        }

        public static SourceCodeInfo parseFrom(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws IOException {
            return (SourceCodeInfo) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
        }
    }

    /* loaded from: classes.dex */
    public static final class UninterpretedOption extends GeneratedMessageV3 implements s {
        public static final int AGGREGATE_VALUE_FIELD_NUMBER = 8;
        public static final int DOUBLE_VALUE_FIELD_NUMBER = 6;
        public static final int IDENTIFIER_VALUE_FIELD_NUMBER = 3;
        public static final int NAME_FIELD_NUMBER = 2;
        public static final int NEGATIVE_INT_VALUE_FIELD_NUMBER = 5;
        public static final int POSITIVE_INT_VALUE_FIELD_NUMBER = 4;
        public static final int STRING_VALUE_FIELD_NUMBER = 7;
        private static final long serialVersionUID = 0;
        private volatile Object aggregateValue_;
        private int bitField0_;
        private double doubleValue_;
        private volatile Object identifierValue_;
        private byte memoizedIsInitialized;
        private List<NamePart> name_;
        private long negativeIntValue_;
        private long positiveIntValue_;
        private ByteString stringValue_;
        private static final UninterpretedOption DEFAULT_INSTANCE = new UninterpretedOption();
        @Deprecated
        public static final l0<UninterpretedOption> PARSER = new a();

        /* loaded from: classes.dex */
        public static final class NamePart extends GeneratedMessageV3 implements c {
            public static final int IS_EXTENSION_FIELD_NUMBER = 2;
            public static final int NAME_PART_FIELD_NUMBER = 1;
            private static final long serialVersionUID = 0;
            private int bitField0_;
            private boolean isExtension_;
            private byte memoizedIsInitialized;
            private volatile Object namePart_;
            private static final NamePart DEFAULT_INSTANCE = new NamePart();
            @Deprecated
            public static final l0<NamePart> PARSER = new a();

            /* loaded from: classes.dex */
            static class a extends com.google.protobuf.c<NamePart> {
                a() {
                }

                /* renamed from: a */
                public NamePart parsePartialFrom(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
                    return new NamePart(iVar, qVar, null);
                }
            }

            /* loaded from: classes.dex */
            public static final class b extends GeneratedMessageV3.b<b> implements c {

                /* renamed from: a  reason: collision with root package name */
                private int f12906a;

                /* renamed from: b  reason: collision with root package name */
                private Object f12907b;

                /* renamed from: c  reason: collision with root package name */
                private boolean f12908c;

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
                public NamePart build() {
                    NamePart c10 = buildPartial();
                    if (c10.isInitialized()) {
                        return c10;
                    }
                    throw a.AbstractC0170a.newUninitializedMessageException((d0) c10);
                }

                /* renamed from: c */
                public NamePart buildPartial() {
                    NamePart namePart = new NamePart(this, (a) null);
                    int i10 = this.f12906a;
                    int i11 = 1;
                    if ((i10 & 1) != 1) {
                        i11 = 0;
                    }
                    namePart.namePart_ = this.f12907b;
                    if ((i10 & 2) == 2) {
                        i11 |= 2;
                    }
                    namePart.isExtension_ = this.f12908c;
                    namePart.bitField0_ = i11;
                    onBuilt();
                    return namePart;
                }

                /* renamed from: d */
                public b clear() {
                    super.clear();
                    this.f12907b = "";
                    int i10 = this.f12906a & (-2);
                    this.f12906a = i10;
                    this.f12908c = false;
                    this.f12906a = i10 & (-3);
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
                    return DescriptorProtos.O;
                }

                /* renamed from: i */
                public NamePart getDefaultInstanceForType() {
                    return NamePart.getDefaultInstance();
                }

                @Override // com.google.protobuf.GeneratedMessageV3.b
                protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                    return DescriptorProtos.P.e(NamePart.class, b.class);
                }

                @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.f0
                public final boolean isInitialized() {
                    return k() && j();
                }

                public boolean j() {
                    return (this.f12906a & 2) == 2;
                }

                public boolean k() {
                    return (this.f12906a & 1) == 1;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0021  */
                /* renamed from: l */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public b mergeFrom(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws IOException {
                    Throwable th2;
                    NamePart namePart = null;
                    try {
                        try {
                            NamePart parsePartialFrom = NamePart.PARSER.parsePartialFrom(iVar, qVar);
                            if (parsePartialFrom != null) {
                                m(parsePartialFrom);
                            }
                            return this;
                        } catch (InvalidProtocolBufferException e10) {
                            namePart = (NamePart) e10.getUnfinishedMessage();
                            try {
                                throw e10.unwrapIOException();
                            } catch (Throwable th3) {
                                th2 = th3;
                                if (namePart != null) {
                                    m(namePart);
                                }
                                throw th2;
                            }
                        }
                    } catch (Throwable th4) {
                        th2 = th4;
                        if (namePart != null) {
                        }
                        throw th2;
                    }
                }

                public b m(NamePart namePart) {
                    if (namePart == NamePart.getDefaultInstance()) {
                        return this;
                    }
                    if (namePart.hasNamePart()) {
                        this.f12906a |= 1;
                        this.f12907b = namePart.namePart_;
                        onChanged();
                    }
                    if (namePart.hasIsExtension()) {
                        q(namePart.getIsExtension());
                    }
                    mergeUnknownFields(namePart.unknownFields);
                    onChanged();
                    return this;
                }

                /* renamed from: n */
                public b mergeFrom(d0 d0Var) {
                    if (d0Var instanceof NamePart) {
                        return m((NamePart) d0Var);
                    }
                    super.mergeFrom(d0Var);
                    return this;
                }

                /* renamed from: o */
                public final b mergeUnknownFields(a1 a1Var) {
                    return (b) super.mergeUnknownFields(a1Var);
                }

                /* renamed from: p */
                public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                    return (b) super.setField(fieldDescriptor, obj);
                }

                public b q(boolean z10) {
                    this.f12906a |= 2;
                    this.f12908c = z10;
                    onChanged();
                    return this;
                }

                /* renamed from: r */
                public b setRepeatedField2(Descriptors.FieldDescriptor fieldDescriptor, int i10, Object obj) {
                    return (b) super.setRepeatedField(fieldDescriptor, i10, obj);
                }

                /* renamed from: s */
                public final b setUnknownFields(a1 a1Var) {
                    return (b) super.setUnknownFields(a1Var);
                }

                /* synthetic */ b(GeneratedMessageV3.c cVar, a aVar) {
                    this(cVar);
                }

                private b() {
                    this.f12907b = "";
                    maybeForceBuilderInitialization();
                }

                private b(GeneratedMessageV3.c cVar) {
                    super(cVar);
                    this.f12907b = "";
                    maybeForceBuilderInitialization();
                }
            }

            /* synthetic */ NamePart(com.google.protobuf.i iVar, com.google.protobuf.q qVar, a aVar) throws InvalidProtocolBufferException {
                this(iVar, qVar);
            }

            public static NamePart getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static final Descriptors.b getDescriptor() {
                return DescriptorProtos.O;
            }

            public static b newBuilder() {
                return DEFAULT_INSTANCE.toBuilder();
            }

            public static NamePart parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (NamePart) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
            }

            public static NamePart parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteString);
            }

            public static l0<NamePart> parser() {
                return PARSER;
            }

            @Override // com.google.protobuf.a
            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof NamePart)) {
                    return super.equals(obj);
                }
                NamePart namePart = (NamePart) obj;
                boolean z10 = hasNamePart() == namePart.hasNamePart();
                if (hasNamePart()) {
                    z10 = z10 && getNamePart().equals(namePart.getNamePart());
                }
                boolean z11 = z10 && hasIsExtension() == namePart.hasIsExtension();
                if (hasIsExtension()) {
                    z11 = z11 && getIsExtension() == namePart.getIsExtension();
                }
                return z11 && this.unknownFields.equals(namePart.unknownFields);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: g */
            public b newBuilderForType(GeneratedMessageV3.c cVar) {
                return new b(cVar, null);
            }

            public boolean getIsExtension() {
                return this.isExtension_;
            }

            public String getNamePart() {
                Object obj = this.namePart_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                ByteString byteString = (ByteString) obj;
                String stringUtf8 = byteString.toStringUtf8();
                if (byteString.isValidUtf8()) {
                    this.namePart_ = stringUtf8;
                }
                return stringUtf8;
            }

            public ByteString getNamePartBytes() {
                Object obj = this.namePart_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.namePart_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
            public l0<NamePart> getParserForType() {
                return PARSER;
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
            public int getSerializedSize() {
                int i10 = this.memoizedSize;
                if (i10 != -1) {
                    return i10;
                }
                int i11 = 0;
                if ((this.bitField0_ & 1) == 1) {
                    i11 = 0 + GeneratedMessageV3.computeStringSize(1, this.namePart_);
                }
                if ((this.bitField0_ & 2) == 2) {
                    i11 += CodedOutputStream.e(2, this.isExtension_);
                }
                int serializedSize = i11 + this.unknownFields.getSerializedSize();
                this.memoizedSize = serializedSize;
                return serializedSize;
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.g0
            public final a1 getUnknownFields() {
                return this.unknownFields;
            }

            public boolean hasIsExtension() {
                return (this.bitField0_ & 2) == 2;
            }

            public boolean hasNamePart() {
                return (this.bitField0_ & 1) == 1;
            }

            @Override // com.google.protobuf.a
            public int hashCode() {
                int i10 = this.memoizedHashCode;
                if (i10 != 0) {
                    return i10;
                }
                int hashCode = 779 + getDescriptorForType().hashCode();
                if (hasNamePart()) {
                    hashCode = (((hashCode * 37) + 1) * 53) + getNamePart().hashCode();
                }
                if (hasIsExtension()) {
                    hashCode = (((hashCode * 37) + 2) * 53) + u.c(getIsExtension());
                }
                int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
                this.memoizedHashCode = hashCode2;
                return hashCode2;
            }

            @Override // com.google.protobuf.GeneratedMessageV3
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return DescriptorProtos.P.e(NamePart.class, b.class);
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
                if (!hasNamePart()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                } else if (!hasIsExtension()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                } else {
                    this.memoizedIsInitialized = (byte) 1;
                    return true;
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
            public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                if ((this.bitField0_ & 1) == 1) {
                    GeneratedMessageV3.writeString(codedOutputStream, 1, this.namePart_);
                }
                if ((this.bitField0_ & 2) == 2) {
                    codedOutputStream.e0(2, this.isExtension_);
                }
                this.unknownFields.writeTo(codedOutputStream);
            }

            /* synthetic */ NamePart(GeneratedMessageV3.b bVar, a aVar) {
                this(bVar);
            }

            public static b newBuilder(NamePart namePart) {
                return DEFAULT_INSTANCE.toBuilder().m(namePart);
            }

            public static NamePart parseFrom(ByteString byteString, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteString, qVar);
            }

            private NamePart(GeneratedMessageV3.b<?> bVar) {
                super(bVar);
                this.memoizedIsInitialized = (byte) -1;
            }

            public static NamePart parseDelimitedFrom(InputStream inputStream, com.google.protobuf.q qVar) throws IOException {
                return (NamePart) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
            }

            public static NamePart parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(bArr);
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
            public NamePart getDefaultInstanceForType() {
                return DEFAULT_INSTANCE;
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
            public b toBuilder() {
                return this == DEFAULT_INSTANCE ? new b((a) null) : new b((a) null).m(this);
            }

            public static NamePart parseFrom(byte[] bArr, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(bArr, qVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
            public b newBuilderForType() {
                return newBuilder();
            }

            private NamePart() {
                this.memoizedIsInitialized = (byte) -1;
                this.namePart_ = "";
                this.isExtension_ = false;
            }

            public static NamePart parseFrom(InputStream inputStream) throws IOException {
                return (NamePart) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
            }

            public static NamePart parseFrom(InputStream inputStream, com.google.protobuf.q qVar) throws IOException {
                return (NamePart) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
            }

            private NamePart(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
                this();
                a1.b g10 = a1.g();
                boolean z10 = false;
                while (!z10) {
                    try {
                        try {
                            int F = iVar.F();
                            if (F != 0) {
                                if (F == 10) {
                                    ByteString m10 = iVar.m();
                                    this.bitField0_ = 1 | this.bitField0_;
                                    this.namePart_ = m10;
                                } else if (F == 16) {
                                    this.bitField0_ |= 2;
                                    this.isExtension_ = iVar.l();
                                } else if (!parseUnknownField(iVar, g10, qVar, F)) {
                                }
                            }
                            z10 = true;
                        } catch (InvalidProtocolBufferException e10) {
                            throw e10.setUnfinishedMessage(this);
                        } catch (IOException e11) {
                            throw new InvalidProtocolBufferException(e11).setUnfinishedMessage(this);
                        }
                    } finally {
                        this.unknownFields = g10.build();
                        makeExtensionsImmutable();
                    }
                }
            }

            public static NamePart parseFrom(com.google.protobuf.i iVar) throws IOException {
                return (NamePart) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
            }

            public static NamePart parseFrom(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws IOException {
                return (NamePart) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
            }
        }

        /* loaded from: classes.dex */
        static class a extends com.google.protobuf.c<UninterpretedOption> {
            a() {
            }

            /* renamed from: a */
            public UninterpretedOption parsePartialFrom(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
                return new UninterpretedOption(iVar, qVar, null);
            }
        }

        /* loaded from: classes.dex */
        public static final class b extends GeneratedMessageV3.b<b> implements s {

            /* renamed from: a  reason: collision with root package name */
            private int f12909a;

            /* renamed from: b  reason: collision with root package name */
            private List<NamePart> f12910b;

            /* renamed from: c  reason: collision with root package name */
            private o0<NamePart, NamePart.b, c> f12911c;

            /* renamed from: d  reason: collision with root package name */
            private Object f12912d;

            /* renamed from: e  reason: collision with root package name */
            private long f12913e;

            /* renamed from: f  reason: collision with root package name */
            private long f12914f;

            /* renamed from: g  reason: collision with root package name */
            private double f12915g;

            /* renamed from: h  reason: collision with root package name */
            private ByteString f12916h;

            /* renamed from: i  reason: collision with root package name */
            private Object f12917i;

            /* synthetic */ b(a aVar) {
                this();
            }

            private void i() {
                if ((this.f12909a & 1) != 1) {
                    this.f12910b = new ArrayList(this.f12910b);
                    this.f12909a |= 1;
                }
            }

            private o0<NamePart, NamePart.b, c> m() {
                if (this.f12911c == null) {
                    List<NamePart> list = this.f12910b;
                    boolean z10 = true;
                    if ((this.f12909a & 1) != 1) {
                        z10 = false;
                    }
                    this.f12911c = new o0<>(list, z10, getParentForChildren(), isClean());
                    this.f12910b = null;
                }
                return this.f12911c;
            }

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                    m();
                }
            }

            /* renamed from: a */
            public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.addRepeatedField(fieldDescriptor, obj);
            }

            /* renamed from: b */
            public UninterpretedOption build() {
                UninterpretedOption c10 = buildPartial();
                if (c10.isInitialized()) {
                    return c10;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) c10);
            }

            /* renamed from: c */
            public UninterpretedOption buildPartial() {
                UninterpretedOption uninterpretedOption = new UninterpretedOption(this, (a) null);
                int i10 = this.f12909a;
                o0<NamePart, NamePart.b, c> o0Var = this.f12911c;
                int i11 = 1;
                if (o0Var == null) {
                    if ((i10 & 1) == 1) {
                        this.f12910b = Collections.unmodifiableList(this.f12910b);
                        this.f12909a &= -2;
                    }
                    uninterpretedOption.name_ = this.f12910b;
                } else {
                    uninterpretedOption.name_ = o0Var.g();
                }
                if ((i10 & 2) != 2) {
                    i11 = 0;
                }
                uninterpretedOption.identifierValue_ = this.f12912d;
                if ((i10 & 4) == 4) {
                    i11 |= 2;
                }
                uninterpretedOption.positiveIntValue_ = this.f12913e;
                if ((i10 & 8) == 8) {
                    i11 |= 4;
                }
                uninterpretedOption.negativeIntValue_ = this.f12914f;
                if ((i10 & 16) == 16) {
                    i11 |= 8;
                }
                uninterpretedOption.doubleValue_ = this.f12915g;
                if ((i10 & 32) == 32) {
                    i11 |= 16;
                }
                uninterpretedOption.stringValue_ = this.f12916h;
                if ((i10 & 64) == 64) {
                    i11 |= 32;
                }
                uninterpretedOption.aggregateValue_ = this.f12917i;
                uninterpretedOption.bitField0_ = i11;
                onBuilt();
                return uninterpretedOption;
            }

            /* renamed from: d */
            public b clear() {
                super.clear();
                o0<NamePart, NamePart.b, c> o0Var = this.f12911c;
                if (o0Var == null) {
                    this.f12910b = Collections.emptyList();
                    this.f12909a &= -2;
                } else {
                    o0Var.h();
                }
                this.f12912d = "";
                int i10 = this.f12909a & (-3);
                this.f12909a = i10;
                this.f12913e = 0L;
                int i11 = i10 & (-5);
                this.f12909a = i11;
                this.f12914f = 0L;
                int i12 = i11 & (-9);
                this.f12909a = i12;
                this.f12915g = 0.0d;
                int i13 = i12 & (-17);
                this.f12909a = i13;
                this.f12916h = ByteString.EMPTY;
                int i14 = i13 & (-33);
                this.f12909a = i14;
                this.f12917i = "";
                this.f12909a = i14 & (-65);
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
                return DescriptorProtos.M;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return DescriptorProtos.N.e(UninterpretedOption.class, b.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.f0
            public final boolean isInitialized() {
                for (int i10 = 0; i10 < l(); i10++) {
                    if (!k(i10).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }

            /* renamed from: j */
            public UninterpretedOption getDefaultInstanceForType() {
                return UninterpretedOption.getDefaultInstance();
            }

            public NamePart k(int i10) {
                o0<NamePart, NamePart.b, c> o0Var = this.f12911c;
                if (o0Var == null) {
                    return this.f12910b.get(i10);
                }
                return o0Var.o(i10);
            }

            public int l() {
                o0<NamePart, NamePart.b, c> o0Var = this.f12911c;
                if (o0Var == null) {
                    return this.f12910b.size();
                }
                return o0Var.n();
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x0021  */
            /* renamed from: n */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public b mergeFrom(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws IOException {
                Throwable th2;
                UninterpretedOption uninterpretedOption = null;
                try {
                    try {
                        UninterpretedOption parsePartialFrom = UninterpretedOption.PARSER.parsePartialFrom(iVar, qVar);
                        if (parsePartialFrom != null) {
                            o(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e10) {
                        uninterpretedOption = (UninterpretedOption) e10.getUnfinishedMessage();
                        try {
                            throw e10.unwrapIOException();
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (uninterpretedOption != null) {
                                o(uninterpretedOption);
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (uninterpretedOption != null) {
                    }
                    throw th2;
                }
            }

            public b o(UninterpretedOption uninterpretedOption) {
                if (uninterpretedOption == UninterpretedOption.getDefaultInstance()) {
                    return this;
                }
                if (this.f12911c == null) {
                    if (!uninterpretedOption.name_.isEmpty()) {
                        if (this.f12910b.isEmpty()) {
                            this.f12910b = uninterpretedOption.name_;
                            this.f12909a &= -2;
                        } else {
                            i();
                            this.f12910b.addAll(uninterpretedOption.name_);
                        }
                        onChanged();
                    }
                } else if (!uninterpretedOption.name_.isEmpty()) {
                    if (this.f12911c.u()) {
                        this.f12911c.i();
                        o0<NamePart, NamePart.b, c> o0Var = null;
                        this.f12911c = null;
                        this.f12910b = uninterpretedOption.name_;
                        this.f12909a &= -2;
                        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                            o0Var = m();
                        }
                        this.f12911c = o0Var;
                    } else {
                        this.f12911c.b(uninterpretedOption.name_);
                    }
                }
                if (uninterpretedOption.hasIdentifierValue()) {
                    this.f12909a |= 2;
                    this.f12912d = uninterpretedOption.identifierValue_;
                    onChanged();
                }
                if (uninterpretedOption.hasPositiveIntValue()) {
                    u(uninterpretedOption.getPositiveIntValue());
                }
                if (uninterpretedOption.hasNegativeIntValue()) {
                    t(uninterpretedOption.getNegativeIntValue());
                }
                if (uninterpretedOption.hasDoubleValue()) {
                    r(uninterpretedOption.getDoubleValue());
                }
                if (uninterpretedOption.hasStringValue()) {
                    w(uninterpretedOption.getStringValue());
                }
                if (uninterpretedOption.hasAggregateValue()) {
                    this.f12909a |= 64;
                    this.f12917i = uninterpretedOption.aggregateValue_;
                    onChanged();
                }
                mergeUnknownFields(uninterpretedOption.unknownFields);
                onChanged();
                return this;
            }

            /* renamed from: p */
            public b mergeFrom(d0 d0Var) {
                if (d0Var instanceof UninterpretedOption) {
                    return o((UninterpretedOption) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            /* renamed from: q */
            public final b mergeUnknownFields(a1 a1Var) {
                return (b) super.mergeUnknownFields(a1Var);
            }

            public b r(double d10) {
                this.f12909a |= 16;
                this.f12915g = d10;
                onChanged();
                return this;
            }

            /* renamed from: s */
            public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.setField(fieldDescriptor, obj);
            }

            public b t(long j10) {
                this.f12909a |= 8;
                this.f12914f = j10;
                onChanged();
                return this;
            }

            public b u(long j10) {
                this.f12909a |= 4;
                this.f12913e = j10;
                onChanged();
                return this;
            }

            /* renamed from: v */
            public b setRepeatedField2(Descriptors.FieldDescriptor fieldDescriptor, int i10, Object obj) {
                return (b) super.setRepeatedField(fieldDescriptor, i10, obj);
            }

            public b w(ByteString byteString) {
                Objects.requireNonNull(byteString);
                this.f12909a |= 32;
                this.f12916h = byteString;
                onChanged();
                return this;
            }

            /* renamed from: x */
            public final b setUnknownFields(a1 a1Var) {
                return (b) super.setUnknownFields(a1Var);
            }

            /* synthetic */ b(GeneratedMessageV3.c cVar, a aVar) {
                this(cVar);
            }

            private b() {
                this.f12910b = Collections.emptyList();
                this.f12912d = "";
                this.f12916h = ByteString.EMPTY;
                this.f12917i = "";
                maybeForceBuilderInitialization();
            }

            private b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.f12910b = Collections.emptyList();
                this.f12912d = "";
                this.f12916h = ByteString.EMPTY;
                this.f12917i = "";
                maybeForceBuilderInitialization();
            }
        }

        /* loaded from: classes.dex */
        public interface c extends g0 {
        }

        /* synthetic */ UninterpretedOption(com.google.protobuf.i iVar, com.google.protobuf.q qVar, a aVar) throws InvalidProtocolBufferException {
            this(iVar, qVar);
        }

        public static UninterpretedOption getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return DescriptorProtos.M;
        }

        public static b newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static UninterpretedOption parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (UninterpretedOption) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static UninterpretedOption parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static l0<UninterpretedOption> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof UninterpretedOption)) {
                return super.equals(obj);
            }
            UninterpretedOption uninterpretedOption = (UninterpretedOption) obj;
            boolean z10 = (getNameList().equals(uninterpretedOption.getNameList())) && hasIdentifierValue() == uninterpretedOption.hasIdentifierValue();
            if (hasIdentifierValue()) {
                z10 = z10 && getIdentifierValue().equals(uninterpretedOption.getIdentifierValue());
            }
            boolean z11 = z10 && hasPositiveIntValue() == uninterpretedOption.hasPositiveIntValue();
            if (hasPositiveIntValue()) {
                z11 = z11 && getPositiveIntValue() == uninterpretedOption.getPositiveIntValue();
            }
            boolean z12 = z11 && hasNegativeIntValue() == uninterpretedOption.hasNegativeIntValue();
            if (hasNegativeIntValue()) {
                z12 = z12 && getNegativeIntValue() == uninterpretedOption.getNegativeIntValue();
            }
            boolean z13 = z12 && hasDoubleValue() == uninterpretedOption.hasDoubleValue();
            if (hasDoubleValue()) {
                z13 = z13 && Double.doubleToLongBits(getDoubleValue()) == Double.doubleToLongBits(uninterpretedOption.getDoubleValue());
            }
            boolean z14 = z13 && hasStringValue() == uninterpretedOption.hasStringValue();
            if (hasStringValue()) {
                z14 = z14 && getStringValue().equals(uninterpretedOption.getStringValue());
            }
            boolean z15 = z14 && hasAggregateValue() == uninterpretedOption.hasAggregateValue();
            if (hasAggregateValue()) {
                z15 = z15 && getAggregateValue().equals(uninterpretedOption.getAggregateValue());
            }
            return z15 && this.unknownFields.equals(uninterpretedOption.unknownFields);
        }

        public String getAggregateValue() {
            Object obj = this.aggregateValue_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.aggregateValue_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getAggregateValueBytes() {
            Object obj = this.aggregateValue_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.aggregateValue_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public double getDoubleValue() {
            return this.doubleValue_;
        }

        public String getIdentifierValue() {
            Object obj = this.identifierValue_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.identifierValue_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getIdentifierValueBytes() {
            Object obj = this.identifierValue_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.identifierValue_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public NamePart getName(int i10) {
            return this.name_.get(i10);
        }

        public int getNameCount() {
            return this.name_.size();
        }

        public List<NamePart> getNameList() {
            return this.name_;
        }

        public c getNameOrBuilder(int i10) {
            return this.name_.get(i10);
        }

        public List<? extends c> getNameOrBuilderList() {
            return this.name_;
        }

        public long getNegativeIntValue() {
            return this.negativeIntValue_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public l0<UninterpretedOption> getParserForType() {
            return PARSER;
        }

        public long getPositiveIntValue() {
            return this.positiveIntValue_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
        public int getSerializedSize() {
            int i10 = this.memoizedSize;
            if (i10 != -1) {
                return i10;
            }
            int i11 = 0;
            for (int i12 = 0; i12 < this.name_.size(); i12++) {
                i11 += CodedOutputStream.E(2, this.name_.get(i12));
            }
            if ((this.bitField0_ & 1) == 1) {
                i11 += GeneratedMessageV3.computeStringSize(3, this.identifierValue_);
            }
            if ((this.bitField0_ & 2) == 2) {
                i11 += CodedOutputStream.S(4, this.positiveIntValue_);
            }
            if ((this.bitField0_ & 4) == 4) {
                i11 += CodedOutputStream.x(5, this.negativeIntValue_);
            }
            if ((this.bitField0_ & 8) == 8) {
                i11 += CodedOutputStream.j(6, this.doubleValue_);
            }
            if ((this.bitField0_ & 16) == 16) {
                i11 += CodedOutputStream.h(7, this.stringValue_);
            }
            if ((this.bitField0_ & 32) == 32) {
                i11 += GeneratedMessageV3.computeStringSize(8, this.aggregateValue_);
            }
            int serializedSize = i11 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        public ByteString getStringValue() {
            return this.stringValue_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.g0
        public final a1 getUnknownFields() {
            return this.unknownFields;
        }

        public boolean hasAggregateValue() {
            return (this.bitField0_ & 32) == 32;
        }

        public boolean hasDoubleValue() {
            return (this.bitField0_ & 8) == 8;
        }

        public boolean hasIdentifierValue() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasNegativeIntValue() {
            return (this.bitField0_ & 4) == 4;
        }

        public boolean hasPositiveIntValue() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean hasStringValue() {
            return (this.bitField0_ & 16) == 16;
        }

        @Override // com.google.protobuf.a
        public int hashCode() {
            int i10 = this.memoizedHashCode;
            if (i10 != 0) {
                return i10;
            }
            int hashCode = 779 + getDescriptorForType().hashCode();
            if (getNameCount() > 0) {
                hashCode = (((hashCode * 37) + 2) * 53) + getNameList().hashCode();
            }
            if (hasIdentifierValue()) {
                hashCode = (((hashCode * 37) + 3) * 53) + getIdentifierValue().hashCode();
            }
            if (hasPositiveIntValue()) {
                hashCode = (((hashCode * 37) + 4) * 53) + u.h(getPositiveIntValue());
            }
            if (hasNegativeIntValue()) {
                hashCode = (((hashCode * 37) + 5) * 53) + u.h(getNegativeIntValue());
            }
            if (hasDoubleValue()) {
                hashCode = (((hashCode * 37) + 6) * 53) + u.h(Double.doubleToLongBits(getDoubleValue()));
            }
            if (hasStringValue()) {
                hashCode = (((hashCode * 37) + 7) * 53) + getStringValue().hashCode();
            }
            if (hasAggregateValue()) {
                hashCode = (((hashCode * 37) + 8) * 53) + getAggregateValue().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return DescriptorProtos.N.e(UninterpretedOption.class, b.class);
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
            for (int i10 = 0; i10 < getNameCount(); i10++) {
                if (!getName(i10).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: n */
        public b newBuilderForType(GeneratedMessageV3.c cVar) {
            return new b(cVar, null);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            for (int i10 = 0; i10 < this.name_.size(); i10++) {
                codedOutputStream.A0(2, this.name_.get(i10));
            }
            if ((this.bitField0_ & 1) == 1) {
                GeneratedMessageV3.writeString(codedOutputStream, 3, this.identifierValue_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.O0(4, this.positiveIntValue_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.y0(5, this.negativeIntValue_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.k0(6, this.doubleValue_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.i0(7, this.stringValue_);
            }
            if ((this.bitField0_ & 32) == 32) {
                GeneratedMessageV3.writeString(codedOutputStream, 8, this.aggregateValue_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        /* synthetic */ UninterpretedOption(GeneratedMessageV3.b bVar, a aVar) {
            this(bVar);
        }

        public static b newBuilder(UninterpretedOption uninterpretedOption) {
            return DEFAULT_INSTANCE.toBuilder().o(uninterpretedOption);
        }

        public static UninterpretedOption parseFrom(ByteString byteString, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, qVar);
        }

        private UninterpretedOption(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static UninterpretedOption parseDelimitedFrom(InputStream inputStream, com.google.protobuf.q qVar) throws IOException {
            return (UninterpretedOption) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
        }

        public static UninterpretedOption parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
        public UninterpretedOption getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b toBuilder() {
            return this == DEFAULT_INSTANCE ? new b((a) null) : new b((a) null).o(this);
        }

        public static UninterpretedOption parseFrom(byte[] bArr, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b newBuilderForType() {
            return newBuilder();
        }

        private UninterpretedOption() {
            this.memoizedIsInitialized = (byte) -1;
            this.name_ = Collections.emptyList();
            this.identifierValue_ = "";
            this.positiveIntValue_ = 0L;
            this.negativeIntValue_ = 0L;
            this.doubleValue_ = 0.0d;
            this.stringValue_ = ByteString.EMPTY;
            this.aggregateValue_ = "";
        }

        public static UninterpretedOption parseFrom(InputStream inputStream) throws IOException {
            return (UninterpretedOption) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static UninterpretedOption parseFrom(InputStream inputStream, com.google.protobuf.q qVar) throws IOException {
            return (UninterpretedOption) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
        }

        public static UninterpretedOption parseFrom(com.google.protobuf.i iVar) throws IOException {
            return (UninterpretedOption) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
        }

        public static UninterpretedOption parseFrom(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws IOException {
            return (UninterpretedOption) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private UninterpretedOption(com.google.protobuf.i iVar, com.google.protobuf.q qVar) throws InvalidProtocolBufferException {
            this();
            a1.b g10 = a1.g();
            boolean z10 = false;
            boolean z11 = false;
            while (true) {
                if (z10) {
                    break;
                }
                try {
                    try {
                        int F = iVar.F();
                        if (F != 0) {
                            if (F == 18) {
                                if (!z11 || !true) {
                                    this.name_ = new ArrayList();
                                    z11 |= true;
                                }
                                this.name_.add(iVar.v(NamePart.PARSER, qVar));
                            } else if (F == 26) {
                                ByteString m10 = iVar.m();
                                this.bitField0_ |= 1;
                                this.identifierValue_ = m10;
                            } else if (F == 32) {
                                this.bitField0_ |= 2;
                                this.positiveIntValue_ = iVar.H();
                            } else if (F == 40) {
                                this.bitField0_ |= 4;
                                this.negativeIntValue_ = iVar.u();
                            } else if (F == 49) {
                                this.bitField0_ |= 8;
                                this.doubleValue_ = iVar.n();
                            } else if (F == 58) {
                                this.bitField0_ |= 16;
                                this.stringValue_ = iVar.m();
                            } else if (F == 66) {
                                ByteString m11 = iVar.m();
                                this.bitField0_ = 32 | this.bitField0_;
                                this.aggregateValue_ = m11;
                            } else if (!parseUnknownField(iVar, g10, qVar, F)) {
                            }
                        }
                        z10 = true;
                    } catch (InvalidProtocolBufferException e10) {
                        throw e10.setUnfinishedMessage(this);
                    } catch (IOException e11) {
                        throw new InvalidProtocolBufferException(e11).setUnfinishedMessage(this);
                    }
                } finally {
                    if (z11 && true) {
                        this.name_ = Collections.unmodifiableList(this.name_);
                    }
                    this.unknownFields = g10.build();
                    makeExtensionsImmutable();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a implements Descriptors.FileDescriptor.a {
        a() {
        }

        @Override // com.google.protobuf.Descriptors.FileDescriptor.a
        public com.google.protobuf.o assignDescriptors(Descriptors.FileDescriptor fileDescriptor) {
            Descriptors.FileDescriptor unused = DescriptorProtos.Y = fileDescriptor;
            return null;
        }
    }

    /* loaded from: classes.dex */
    public interface b extends g0 {
    }

    /* loaded from: classes.dex */
    public interface c extends g0 {
    }

    /* loaded from: classes.dex */
    public interface d extends g0 {
    }

    /* loaded from: classes.dex */
    public interface e extends g0 {
    }

    /* loaded from: classes.dex */
    public interface f extends g0 {
    }

    /* loaded from: classes.dex */
    public interface g extends g0 {
    }

    /* loaded from: classes.dex */
    public interface h extends g0 {
    }

    /* loaded from: classes.dex */
    public interface i extends g0 {
    }

    /* loaded from: classes.dex */
    public interface j extends g0 {
    }

    /* loaded from: classes.dex */
    public interface k extends g0 {
    }

    /* loaded from: classes.dex */
    public interface l extends g0 {
    }

    /* loaded from: classes.dex */
    public interface m extends g0 {
    }

    /* loaded from: classes.dex */
    public interface n extends g0 {
    }

    /* loaded from: classes.dex */
    public interface o extends g0 {
    }

    /* loaded from: classes.dex */
    public interface p extends g0 {
    }

    /* loaded from: classes.dex */
    public interface q extends g0 {
    }

    /* loaded from: classes.dex */
    public interface r extends g0 {
    }

    /* loaded from: classes.dex */
    public interface s extends g0 {
    }

    static {
        Descriptors.FileDescriptor.q(new String[]{"\n google/protobuf/descriptor.proto\u0012\u000fgoogle.protobuf\"G\n\u0011FileDescriptorSet\u00122\n\u0004file\u0018\u0001 \u0003(\u000b2$.google.protobuf.FileDescriptorProto\"Û\u0003\n\u0013FileDescriptorProto\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u0012\u000f\n\u0007package\u0018\u0002 \u0001(\t\u0012\u0012\n\ndependency\u0018\u0003 \u0003(\t\u0012\u0019\n\u0011public_dependency\u0018\n \u0003(\u0005\u0012\u0017\n\u000fweak_dependency\u0018\u000b \u0003(\u0005\u00126\n\fmessage_type\u0018\u0004 \u0003(\u000b2 .google.protobuf.DescriptorProto\u00127\n\tenum_type\u0018\u0005 \u0003(\u000b2$.google.protobuf.EnumDescriptorProto\u00128\n\u0007service\u0018\u0006 \u0003(\u000b2'.google.protobuf.", "ServiceDescriptorProto\u00128\n\textension\u0018\u0007 \u0003(\u000b2%.google.protobuf.FieldDescriptorProto\u0012-\n\u0007options\u0018\b \u0001(\u000b2\u001c.google.protobuf.FileOptions\u00129\n\u0010source_code_info\u0018\t \u0001(\u000b2\u001f.google.protobuf.SourceCodeInfo\u0012\u000e\n\u0006syntax\u0018\f \u0001(\t\"ð\u0004\n\u000fDescriptorProto\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u00124\n\u0005field\u0018\u0002 \u0003(\u000b2%.google.protobuf.FieldDescriptorProto\u00128\n\textension\u0018\u0006 \u0003(\u000b2%.google.protobuf.FieldDescriptorProto\u00125\n\u000bnested_type\u0018\u0003 \u0003(\u000b2 .google.protobuf.DescriptorPr", "oto\u00127\n\tenum_type\u0018\u0004 \u0003(\u000b2$.google.protobuf.EnumDescriptorProto\u0012H\n\u000fextension_range\u0018\u0005 \u0003(\u000b2/.google.protobuf.DescriptorProto.ExtensionRange\u00129\n\noneof_decl\u0018\b \u0003(\u000b2%.google.protobuf.OneofDescriptorProto\u00120\n\u0007options\u0018\u0007 \u0001(\u000b2\u001f.google.protobuf.MessageOptions\u0012F\n\u000ereserved_range\u0018\t \u0003(\u000b2..google.protobuf.DescriptorProto.ReservedRange\u0012\u0015\n\rreserved_name\u0018\n \u0003(\t\u001a,\n\u000eExtensionRange\u0012\r\n\u0005start\u0018\u0001 \u0001(\u0005\u0012\u000b\n\u0003end\u0018\u0002 \u0001(\u0005\u001a+\n\rReservedRang", "e\u0012\r\n\u0005start\u0018\u0001 \u0001(\u0005\u0012\u000b\n\u0003end\u0018\u0002 \u0001(\u0005\"¼\u0005\n\u0014FieldDescriptorProto\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u0012\u000e\n\u0006number\u0018\u0003 \u0001(\u0005\u0012:\n\u0005label\u0018\u0004 \u0001(\u000e2+.google.protobuf.FieldDescriptorProto.Label\u00128\n\u0004type\u0018\u0005 \u0001(\u000e2*.google.protobuf.FieldDescriptorProto.Type\u0012\u0011\n\ttype_name\u0018\u0006 \u0001(\t\u0012\u0010\n\bextendee\u0018\u0002 \u0001(\t\u0012\u0015\n\rdefault_value\u0018\u0007 \u0001(\t\u0012\u0013\n\u000boneof_index\u0018\t \u0001(\u0005\u0012\u0011\n\tjson_name\u0018\n \u0001(\t\u0012.\n\u0007options\u0018\b \u0001(\u000b2\u001d.google.protobuf.FieldOptions\"¶\u0002\n\u0004Type\u0012\u000f\n\u000bTYPE_DOUBLE\u0010\u0001\u0012\u000e\n\nTYPE_FLOAT\u0010\u0002\u0012\u000e\n\nTYPE", "_INT64\u0010\u0003\u0012\u000f\n\u000bTYPE_UINT64\u0010\u0004\u0012\u000e\n\nTYPE_INT32\u0010\u0005\u0012\u0010\n\fTYPE_FIXED64\u0010\u0006\u0012\u0010\n\fTYPE_FIXED32\u0010\u0007\u0012\r\n\tTYPE_BOOL\u0010\b\u0012\u000f\n\u000bTYPE_STRING\u0010\t\u0012\u000e\n\nTYPE_GROUP\u0010\n\u0012\u0010\n\fTYPE_MESSAGE\u0010\u000b\u0012\u000e\n\nTYPE_BYTES\u0010\f\u0012\u000f\n\u000bTYPE_UINT32\u0010\r\u0012\r\n\tTYPE_ENUM\u0010\u000e\u0012\u0011\n\rTYPE_SFIXED32\u0010\u000f\u0012\u0011\n\rTYPE_SFIXED64\u0010\u0010\u0012\u000f\n\u000bTYPE_SINT32\u0010\u0011\u0012\u000f\n\u000bTYPE_SINT64\u0010\u0012\"C\n\u0005Label\u0012\u0012\n\u000eLABEL_OPTIONAL\u0010\u0001\u0012\u0012\n\u000eLABEL_REQUIRED\u0010\u0002\u0012\u0012\n\u000eLABEL_REPEATED\u0010\u0003\"T\n\u0014OneofDescriptorProto\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u0012.\n\u0007options\u0018\u0002 \u0001(\u000b2\u001d.google.pro", "tobuf.OneofOptions\"\u008c\u0001\n\u0013EnumDescriptorProto\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u00128\n\u0005value\u0018\u0002 \u0003(\u000b2).google.protobuf.EnumValueDescriptorProto\u0012-\n\u0007options\u0018\u0003 \u0001(\u000b2\u001c.google.protobuf.EnumOptions\"l\n\u0018EnumValueDescriptorProto\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u0012\u000e\n\u0006number\u0018\u0002 \u0001(\u0005\u00122\n\u0007options\u0018\u0003 \u0001(\u000b2!.google.protobuf.EnumValueOptions\"\u0090\u0001\n\u0016ServiceDescriptorProto\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u00126\n\u0006method\u0018\u0002 \u0003(\u000b2&.google.protobuf.MethodDescriptorProto\u00120\n\u0007options\u0018\u0003 \u0001(\u000b2\u001f.google.proto", "buf.ServiceOptions\"Á\u0001\n\u0015MethodDescriptorProto\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u0012\u0012\n\ninput_type\u0018\u0002 \u0001(\t\u0012\u0013\n\u000boutput_type\u0018\u0003 \u0001(\t\u0012/\n\u0007options\u0018\u0004 \u0001(\u000b2\u001e.google.protobuf.MethodOptions\u0012\u001f\n\u0010client_streaming\u0018\u0005 \u0001(\b:\u0005false\u0012\u001f\n\u0010server_streaming\u0018\u0006 \u0001(\b:\u0005false\"\u0084\u0005\n\u000bFileOptions\u0012\u0014\n\fjava_package\u0018\u0001 \u0001(\t\u0012\u001c\n\u0014java_outer_classname\u0018\b \u0001(\t\u0012\"\n\u0013java_multiple_files\u0018\n \u0001(\b:\u0005false\u0012)\n\u001djava_generate_equals_and_hash\u0018\u0014 \u0001(\bB\u0002\u0018\u0001\u0012%\n\u0016java_string_check_utf8\u0018\u001b \u0001(\b:\u0005false", "\u0012F\n\foptimize_for\u0018\t \u0001(\u000e2).google.protobuf.FileOptions.OptimizeMode:\u0005SPEED\u0012\u0012\n\ngo_package\u0018\u000b \u0001(\t\u0012\"\n\u0013cc_generic_services\u0018\u0010 \u0001(\b:\u0005false\u0012$\n\u0015java_generic_services\u0018\u0011 \u0001(\b:\u0005false\u0012\"\n\u0013py_generic_services\u0018\u0012 \u0001(\b:\u0005false\u0012\u0019\n\ndeprecated\u0018\u0017 \u0001(\b:\u0005false\u0012\u001f\n\u0010cc_enable_arenas\u0018\u001f \u0001(\b:\u0005false\u0012\u0019\n\u0011objc_class_prefix\u0018$ \u0001(\t\u0012\u0018\n\u0010csharp_namespace\u0018% \u0001(\t\u0012C\n\u0014uninterpreted_option\u0018ç\u0007 \u0003(\u000b2$.google.protobuf.UninterpretedOption\":\n\fOptimizeMode", "\u0012\t\n\u0005SPEED\u0010\u0001\u0012\r\n\tCODE_SIZE\u0010\u0002\u0012\u0010\n\fLITE_RUNTIME\u0010\u0003*\t\bè\u0007\u0010\u0080\u0080\u0080\u0080\u0002J\u0004\b&\u0010'\"ì\u0001\n\u000eMessageOptions\u0012&\n\u0017message_set_wire_format\u0018\u0001 \u0001(\b:\u0005false\u0012.\n\u001fno_standard_descriptor_accessor\u0018\u0002 \u0001(\b:\u0005false\u0012\u0019\n\ndeprecated\u0018\u0003 \u0001(\b:\u0005false\u0012\u0011\n\tmap_entry\u0018\u0007 \u0001(\b\u0012C\n\u0014uninterpreted_option\u0018ç\u0007 \u0003(\u000b2$.google.protobuf.UninterpretedOption*\t\bè\u0007\u0010\u0080\u0080\u0080\u0080\u0002J\u0004\b\b\u0010\t\"\u009e\u0003\n\fFieldOptions\u0012:\n\u0005ctype\u0018\u0001 \u0001(\u000e2#.google.protobuf.FieldOptions.CType:\u0006STRING\u0012\u000e\n\u0006packed\u0018\u0002 \u0001(\b\u0012?\n\u0006jst", "ype\u0018\u0006 \u0001(\u000e2$.google.protobuf.FieldOptions.JSType:\tJS_NORMAL\u0012\u0013\n\u0004lazy\u0018\u0005 \u0001(\b:\u0005false\u0012\u0019\n\ndeprecated\u0018\u0003 \u0001(\b:\u0005false\u0012\u0013\n\u0004weak\u0018\n \u0001(\b:\u0005false\u0012C\n\u0014uninterpreted_option\u0018ç\u0007 \u0003(\u000b2$.google.protobuf.UninterpretedOption\"/\n\u0005CType\u0012\n\n\u0006STRING\u0010\u0000\u0012\b\n\u0004CORD\u0010\u0001\u0012\u0010\n\fSTRING_PIECE\u0010\u0002\"5\n\u0006JSType\u0012\r\n\tJS_NORMAL\u0010\u0000\u0012\r\n\tJS_STRING\u0010\u0001\u0012\r\n\tJS_NUMBER\u0010\u0002*\t\bè\u0007\u0010\u0080\u0080\u0080\u0080\u0002J\u0004\b\u0004\u0010\u0005\"^\n\fOneofOptions\u0012C\n\u0014uninterpreted_option\u0018ç\u0007 \u0003(\u000b2$.google.protobuf.UninterpretedOpti", "on*\t\bè\u0007\u0010\u0080\u0080\u0080\u0080\u0002\"\u008d\u0001\n\u000bEnumOptions\u0012\u0013\n\u000ballow_alias\u0018\u0002 \u0001(\b\u0012\u0019\n\ndeprecated\u0018\u0003 \u0001(\b:\u0005false\u0012C\n\u0014uninterpreted_option\u0018ç\u0007 \u0003(\u000b2$.google.protobuf.UninterpretedOption*\t\bè\u0007\u0010\u0080\u0080\u0080\u0080\u0002\"}\n\u0010EnumValueOptions\u0012\u0019\n\ndeprecated\u0018\u0001 \u0001(\b:\u0005false\u0012C\n\u0014uninterpreted_option\u0018ç\u0007 \u0003(\u000b2$.google.protobuf.UninterpretedOption*\t\bè\u0007\u0010\u0080\u0080\u0080\u0080\u0002\"{\n\u000eServiceOptions\u0012\u0019\n\ndeprecated\u0018! \u0001(\b:\u0005false\u0012C\n\u0014uninterpreted_option\u0018ç\u0007 \u0003(\u000b2$.google.protobuf.UninterpretedOption*\t", "\bè\u0007\u0010\u0080\u0080\u0080\u0080\u0002\"z\n\rMethodOptions\u0012\u0019\n\ndeprecated\u0018! \u0001(\b:\u0005false\u0012C\n\u0014uninterpreted_option\u0018ç\u0007 \u0003(\u000b2$.google.protobuf.UninterpretedOption*\t\bè\u0007\u0010\u0080\u0080\u0080\u0080\u0002\"\u009e\u0002\n\u0013UninterpretedOption\u0012;\n\u0004name\u0018\u0002 \u0003(\u000b2-.google.protobuf.UninterpretedOption.NamePart\u0012\u0018\n\u0010identifier_value\u0018\u0003 \u0001(\t\u0012\u001a\n\u0012positive_int_value\u0018\u0004 \u0001(\u0004\u0012\u001a\n\u0012negative_int_value\u0018\u0005 \u0001(\u0003\u0012\u0014\n\fdouble_value\u0018\u0006 \u0001(\u0001\u0012\u0014\n\fstring_value\u0018\u0007 \u0001(\f\u0012\u0017\n\u000faggregate_value\u0018\b \u0001(\t\u001a3\n\bNamePart\u0012\u0011\n\tname_part\u0018\u0001 \u0002(\t", "\u0012\u0014\n\fis_extension\u0018\u0002 \u0002(\b\"Õ\u0001\n\u000eSourceCodeInfo\u0012:\n\blocation\u0018\u0001 \u0003(\u000b2(.google.protobuf.SourceCodeInfo.Location\u001a\u0086\u0001\n\bLocation\u0012\u0010\n\u0004path\u0018\u0001 \u0003(\u0005B\u0002\u0010\u0001\u0012\u0010\n\u0004span\u0018\u0002 \u0003(\u0005B\u0002\u0010\u0001\u0012\u0018\n\u0010leading_comments\u0018\u0003 \u0001(\t\u0012\u0019\n\u0011trailing_comments\u0018\u0004 \u0001(\t\u0012!\n\u0019leading_detached_comments\u0018\u0006 \u0003(\t\"§\u0001\n\u0011GeneratedCodeInfo\u0012A\n\nannotation\u0018\u0001 \u0003(\u000b2-.google.protobuf.GeneratedCodeInfo.Annotation\u001aO\n\nAnnotation\u0012\u0010\n\u0004path\u0018\u0001 \u0003(\u0005B\u0002\u0010\u0001\u0012\u0013\n\u000bsource_file\u0018\u0002 \u0001(\t\u0012\r\n\u0005begin\u0018\u0003 \u0001(\u0005\u0012\u000b\n\u0003e", "nd\u0018\u0004 \u0001(\u0005BX\n\u0013com.google.protobufB\u0010DescriptorProtosH\u0001Z\ndescriptor¢\u0002\u0003GPBª\u0002\u001aGoogle.Protobuf.Reflection"}, new Descriptors.FileDescriptor[0], new a());
        Descriptors.b bVar = Z().j().get(0);
        f12722a = bVar;
        f12723b = new GeneratedMessageV3.e(bVar, new String[]{"File"});
        Descriptors.b bVar2 = Z().j().get(1);
        f12724c = bVar2;
        f12725d = new GeneratedMessageV3.e(bVar2, new String[]{"Name", "Package", "Dependency", "PublicDependency", "WeakDependency", "MessageType", "EnumType", "Service", "Extension", "Options", "SourceCodeInfo", "Syntax"});
        Descriptors.b bVar3 = Z().j().get(2);
        f12726e = bVar3;
        f12727f = new GeneratedMessageV3.e(bVar3, new String[]{"Name", "Field", "Extension", "NestedType", "EnumType", "ExtensionRange", "OneofDecl", "Options", "ReservedRange", "ReservedName"});
        Descriptors.b bVar4 = bVar3.m().get(0);
        f12728g = bVar4;
        f12729h = new GeneratedMessageV3.e(bVar4, new String[]{"Start", "End"});
        Descriptors.b bVar5 = bVar3.m().get(1);
        f12730i = bVar5;
        f12731j = new GeneratedMessageV3.e(bVar5, new String[]{"Start", "End"});
        Descriptors.b bVar6 = Z().j().get(3);
        f12732k = bVar6;
        f12733l = new GeneratedMessageV3.e(bVar6, new String[]{"Name", "Number", "Label", "Type", "TypeName", "Extendee", "DefaultValue", "OneofIndex", "JsonName", "Options"});
        Descriptors.b bVar7 = Z().j().get(4);
        f12734m = bVar7;
        f12735n = new GeneratedMessageV3.e(bVar7, new String[]{"Name", "Options"});
        Descriptors.b bVar8 = Z().j().get(5);
        f12736o = bVar8;
        f12737p = new GeneratedMessageV3.e(bVar8, new String[]{"Name", "Value", "Options"});
        Descriptors.b bVar9 = Z().j().get(6);
        f12738q = bVar9;
        f12739r = new GeneratedMessageV3.e(bVar9, new String[]{"Name", "Number", "Options"});
        Descriptors.b bVar10 = Z().j().get(7);
        f12740s = bVar10;
        f12741t = new GeneratedMessageV3.e(bVar10, new String[]{"Name", "Method", "Options"});
        Descriptors.b bVar11 = Z().j().get(8);
        f12742u = bVar11;
        f12743v = new GeneratedMessageV3.e(bVar11, new String[]{"Name", "InputType", "OutputType", "Options", "ClientStreaming", "ServerStreaming"});
        Descriptors.b bVar12 = Z().j().get(9);
        f12744w = bVar12;
        f12745x = new GeneratedMessageV3.e(bVar12, new String[]{"JavaPackage", "JavaOuterClassname", "JavaMultipleFiles", "JavaGenerateEqualsAndHash", "JavaStringCheckUtf8", "OptimizeFor", "GoPackage", "CcGenericServices", "JavaGenericServices", "PyGenericServices", "Deprecated", "CcEnableArenas", "ObjcClassPrefix", "CsharpNamespace", "UninterpretedOption"});
        Descriptors.b bVar13 = Z().j().get(10);
        f12746y = bVar13;
        f12747z = new GeneratedMessageV3.e(bVar13, new String[]{"MessageSetWireFormat", "NoStandardDescriptorAccessor", "Deprecated", "MapEntry", "UninterpretedOption"});
        Descriptors.b bVar14 = Z().j().get(11);
        A = bVar14;
        B = new GeneratedMessageV3.e(bVar14, new String[]{"Ctype", "Packed", "Jstype", "Lazy", "Deprecated", "Weak", "UninterpretedOption"});
        Descriptors.b bVar15 = Z().j().get(12);
        C = bVar15;
        D = new GeneratedMessageV3.e(bVar15, new String[]{"UninterpretedOption"});
        Descriptors.b bVar16 = Z().j().get(13);
        E = bVar16;
        F = new GeneratedMessageV3.e(bVar16, new String[]{"AllowAlias", "Deprecated", "UninterpretedOption"});
        Descriptors.b bVar17 = Z().j().get(14);
        G = bVar17;
        H = new GeneratedMessageV3.e(bVar17, new String[]{"Deprecated", "UninterpretedOption"});
        Descriptors.b bVar18 = Z().j().get(15);
        I = bVar18;
        J = new GeneratedMessageV3.e(bVar18, new String[]{"Deprecated", "UninterpretedOption"});
        Descriptors.b bVar19 = Z().j().get(16);
        K = bVar19;
        L = new GeneratedMessageV3.e(bVar19, new String[]{"Deprecated", "UninterpretedOption"});
        Descriptors.b bVar20 = Z().j().get(17);
        M = bVar20;
        N = new GeneratedMessageV3.e(bVar20, new String[]{"Name", "IdentifierValue", "PositiveIntValue", "NegativeIntValue", "DoubleValue", "StringValue", "AggregateValue"});
        Descriptors.b bVar21 = bVar20.m().get(0);
        O = bVar21;
        P = new GeneratedMessageV3.e(bVar21, new String[]{"NamePart", "IsExtension"});
        Descriptors.b bVar22 = Z().j().get(18);
        Q = bVar22;
        R = new GeneratedMessageV3.e(bVar22, new String[]{"Location"});
        Descriptors.b bVar23 = bVar22.m().get(0);
        S = bVar23;
        T = new GeneratedMessageV3.e(bVar23, new String[]{"Path", "Span", "LeadingComments", "TrailingComments", "LeadingDetachedComments"});
        Descriptors.b bVar24 = Z().j().get(19);
        U = bVar24;
        V = new GeneratedMessageV3.e(bVar24, new String[]{"Annotation"});
        Descriptors.b bVar25 = bVar24.m().get(0);
        W = bVar25;
        X = new GeneratedMessageV3.e(bVar25, new String[]{"Path", "SourceFile", "Begin", "End"});
    }

    public static Descriptors.FileDescriptor Z() {
        return Y;
    }
}
