package com.google.protobuf;

import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.a;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes.dex */
public final class Duration extends GeneratedMessageV3 implements g0 {
    public static final int NANOS_FIELD_NUMBER = 2;
    public static final int SECONDS_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private byte memoizedIsInitialized;
    private int nanos_;
    private long seconds_;
    private static final Duration DEFAULT_INSTANCE = new Duration();
    private static final l0<Duration> PARSER = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a extends c<Duration> {
        a() {
        }

        /* renamed from: a */
        public Duration parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
            return new Duration(iVar, qVar, null);
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends GeneratedMessageV3.b<b> implements g0 {

        /* renamed from: a  reason: collision with root package name */
        private long f12980a;

        /* renamed from: b  reason: collision with root package name */
        private int f12981b;

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
        public Duration build() {
            Duration c10 = buildPartial();
            if (c10.isInitialized()) {
                return c10;
            }
            throw a.AbstractC0170a.newUninitializedMessageException((d0) c10);
        }

        /* renamed from: c */
        public Duration buildPartial() {
            Duration duration = new Duration(this, (a) null);
            duration.seconds_ = this.f12980a;
            duration.nanos_ = this.f12981b;
            onBuilt();
            return duration;
        }

        /* renamed from: d */
        public b clear() {
            super.clear();
            this.f12980a = 0L;
            this.f12981b = 0;
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
            return j.f13270a;
        }

        /* renamed from: i */
        public Duration getDefaultInstanceForType() {
            return Duration.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.b
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return j.f13271b.e(Duration.class, b.class);
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
            Duration duration = null;
            try {
                try {
                    Duration duration2 = (Duration) Duration.PARSER.parsePartialFrom(iVar, qVar);
                    if (duration2 != null) {
                        k(duration2);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e10) {
                    duration = (Duration) e10.getUnfinishedMessage();
                    try {
                        throw e10.unwrapIOException();
                    } catch (Throwable th3) {
                        th2 = th3;
                        if (duration != null) {
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th4) {
                th2 = th4;
                if (duration != null) {
                    k(duration);
                }
                throw th2;
            }
        }

        public b k(Duration duration) {
            if (duration == Duration.getDefaultInstance()) {
                return this;
            }
            if (duration.getSeconds() != 0) {
                q(duration.getSeconds());
            }
            if (duration.getNanos() != 0) {
                o(duration.getNanos());
            }
            onChanged();
            return this;
        }

        /* renamed from: l */
        public b mergeFrom(d0 d0Var) {
            if (d0Var instanceof Duration) {
                return k((Duration) d0Var);
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

        public b o(int i10) {
            this.f12981b = i10;
            onChanged();
            return this;
        }

        /* renamed from: p */
        public b setRepeatedField2(Descriptors.FieldDescriptor fieldDescriptor, int i10, Object obj) {
            return (b) super.setRepeatedField(fieldDescriptor, i10, obj);
        }

        public b q(long j10) {
            this.f12980a = j10;
            onChanged();
            return this;
        }

        /* renamed from: r */
        public final b setUnknownFields(a1 a1Var) {
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

    /* synthetic */ Duration(i iVar, q qVar, a aVar) throws InvalidProtocolBufferException {
        this(iVar, qVar);
    }

    public static Duration getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.b getDescriptor() {
        return j.f13270a;
    }

    public static b newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Duration parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Duration) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Duration parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static l0<Duration> parser() {
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
        if (!(obj instanceof Duration)) {
            return super.equals(obj);
        }
        Duration duration = (Duration) obj;
        return ((getSeconds() > duration.getSeconds() ? 1 : (getSeconds() == duration.getSeconds() ? 0 : -1)) == 0) && getNanos() == duration.getNanos();
    }

    public int getNanos() {
        return this.nanos_;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
    public l0<Duration> getParserForType() {
        return PARSER;
    }

    public long getSeconds() {
        return this.seconds_;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
    public int getSerializedSize() {
        int i10 = this.memoizedSize;
        if (i10 != -1) {
            return i10;
        }
        int i11 = 0;
        long j10 = this.seconds_;
        if (j10 != 0) {
            i11 = 0 + CodedOutputStream.x(1, j10);
        }
        int i12 = this.nanos_;
        if (i12 != 0) {
            i11 += CodedOutputStream.v(2, i12);
        }
        this.memoizedSize = i11;
        return i11;
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
        int hashCode = ((((((((((779 + getDescriptorForType().hashCode()) * 37) + 1) * 53) + u.h(getSeconds())) * 37) + 2) * 53) + getNanos()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode;
        return hashCode;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
        return j.f13271b.e(Duration.class, b.class);
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
        long j10 = this.seconds_;
        if (j10 != 0) {
            codedOutputStream.y0(1, j10);
        }
        int i10 = this.nanos_;
        if (i10 != 0) {
            codedOutputStream.w0(2, i10);
        }
    }

    /* synthetic */ Duration(GeneratedMessageV3.b bVar, a aVar) {
        this(bVar);
    }

    public static b newBuilder(Duration duration) {
        return DEFAULT_INSTANCE.toBuilder().k(duration);
    }

    public static Duration parseFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, qVar);
    }

    private Duration(GeneratedMessageV3.b<?> bVar) {
        super(bVar);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static Duration parseDelimitedFrom(InputStream inputStream, q qVar) throws IOException {
        return (Duration) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
    }

    public static Duration parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
    public Duration getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
    public b toBuilder() {
        return this == DEFAULT_INSTANCE ? new b((a) null) : new b((a) null).k(this);
    }

    public static Duration parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, qVar);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
    public b newBuilderForType() {
        return newBuilder();
    }

    private Duration() {
        this.memoizedIsInitialized = (byte) -1;
        this.seconds_ = 0L;
        this.nanos_ = 0;
    }

    public static Duration parseFrom(InputStream inputStream) throws IOException {
        return (Duration) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static Duration parseFrom(InputStream inputStream, q qVar) throws IOException {
        return (Duration) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
    }

    private Duration(i iVar, q qVar) throws InvalidProtocolBufferException {
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
                                this.seconds_ = iVar.u();
                            } else if (F == 16) {
                                this.nanos_ = iVar.t();
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

    public static Duration parseFrom(i iVar) throws IOException {
        return (Duration) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
    }

    public static Duration parseFrom(i iVar, q qVar) throws IOException {
        return (Duration) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
    }
}
