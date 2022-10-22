package com.google.protobuf;

import com.google.protobuf.Any;
import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.a;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes.dex */
public final class Option extends GeneratedMessageV3 implements k0 {
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int VALUE_FIELD_NUMBER = 2;
    private static final long serialVersionUID = 0;
    private byte memoizedIsInitialized;
    private volatile Object name_;
    private Any value_;
    private static final Option DEFAULT_INSTANCE = new Option();
    private static final l0<Option> PARSER = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a extends c<Option> {
        a() {
        }

        /* renamed from: a */
        public Option parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
            return new Option(iVar, qVar, null);
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends GeneratedMessageV3.b<b> implements k0 {

        /* renamed from: a  reason: collision with root package name */
        private Object f13105a;

        /* renamed from: b  reason: collision with root package name */
        private Any f13106b;

        /* renamed from: c  reason: collision with root package name */
        private q0<Any, Any.b, e> f13107c;

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
        public Option build() {
            Option c10 = buildPartial();
            if (c10.isInitialized()) {
                return c10;
            }
            throw a.AbstractC0170a.newUninitializedMessageException((d0) c10);
        }

        /* renamed from: c */
        public Option buildPartial() {
            Option option = new Option(this, (a) null);
            option.name_ = this.f13105a;
            q0<Any, Any.b, e> q0Var = this.f13107c;
            if (q0Var == null) {
                option.value_ = this.f13106b;
            } else {
                option.value_ = q0Var.b();
            }
            onBuilt();
            return option;
        }

        /* renamed from: d */
        public b clear() {
            super.clear();
            this.f13105a = "";
            if (this.f13107c == null) {
                this.f13106b = null;
            } else {
                this.f13106b = null;
                this.f13107c = null;
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
            return z0.f13398i;
        }

        /* renamed from: i */
        public Option getDefaultInstanceForType() {
            return Option.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.b
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return z0.f13399j.e(Option.class, b.class);
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
            Option option = null;
            try {
                try {
                    Option option2 = (Option) Option.PARSER.parsePartialFrom(iVar, qVar);
                    if (option2 != null) {
                        l(option2);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e10) {
                    option = (Option) e10.getUnfinishedMessage();
                    try {
                        throw e10.unwrapIOException();
                    } catch (Throwable th3) {
                        th2 = th3;
                        if (option != null) {
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th4) {
                th2 = th4;
                if (option != null) {
                    l(option);
                }
                throw th2;
            }
        }

        /* renamed from: k */
        public b mergeFrom(d0 d0Var) {
            if (d0Var instanceof Option) {
                return l((Option) d0Var);
            }
            super.mergeFrom(d0Var);
            return this;
        }

        public b l(Option option) {
            if (option == Option.getDefaultInstance()) {
                return this;
            }
            if (!option.getName().isEmpty()) {
                this.f13105a = option.name_;
                onChanged();
            }
            if (option.hasValue()) {
                n(option.getValue());
            }
            onChanged();
            return this;
        }

        /* renamed from: m */
        public final b mergeUnknownFields(a1 a1Var) {
            return this;
        }

        public b n(Any any) {
            q0<Any, Any.b, e> q0Var = this.f13107c;
            if (q0Var == null) {
                Any any2 = this.f13106b;
                if (any2 != null) {
                    this.f13106b = Any.newBuilder(any2).j(any).buildPartial();
                } else {
                    this.f13106b = any;
                }
                onChanged();
            } else {
                q0Var.h(any);
            }
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

        /* synthetic */ b(a aVar) {
            this();
        }

        private b() {
            this.f13105a = "";
            this.f13106b = null;
            maybeForceBuilderInitialization();
        }

        private b(GeneratedMessageV3.c cVar) {
            super(cVar);
            this.f13105a = "";
            this.f13106b = null;
            maybeForceBuilderInitialization();
        }
    }

    /* synthetic */ Option(i iVar, q qVar, a aVar) throws InvalidProtocolBufferException {
        this(iVar, qVar);
    }

    public static Option getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.b getDescriptor() {
        return z0.f13398i;
    }

    public static b newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Option parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Option) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Option parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static l0<Option> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.a
    public boolean equals(Object obj) {
        boolean z10 = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Option)) {
            return super.equals(obj);
        }
        Option option = (Option) obj;
        boolean z11 = (getName().equals(option.getName())) && hasValue() == option.hasValue();
        if (!hasValue()) {
            return z11;
        }
        if (!z11 || !getValue().equals(option.getValue())) {
            z10 = false;
        }
        return z10;
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
    public l0<Option> getParserForType() {
        return PARSER;
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
        if (this.value_ != null) {
            i11 += CodedOutputStream.E(2, getValue());
        }
        this.memoizedSize = i11;
        return i11;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.g0
    public final a1 getUnknownFields() {
        return a1.c();
    }

    public Any getValue() {
        Any any = this.value_;
        return any == null ? Any.getDefaultInstance() : any;
    }

    public e getValueOrBuilder() {
        return getValue();
    }

    public boolean hasValue() {
        return this.value_ != null;
    }

    @Override // com.google.protobuf.a
    public int hashCode() {
        int i10 = this.memoizedHashCode;
        if (i10 != 0) {
            return i10;
        }
        int hashCode = ((((779 + getDescriptorForType().hashCode()) * 37) + 1) * 53) + getName().hashCode();
        if (hasValue()) {
            hashCode = (((hashCode * 37) + 2) * 53) + getValue().hashCode();
        }
        int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode2;
        return hashCode2;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
        return z0.f13399j.e(Option.class, b.class);
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
        if (this.value_ != null) {
            codedOutputStream.A0(2, getValue());
        }
    }

    /* synthetic */ Option(GeneratedMessageV3.b bVar, a aVar) {
        this(bVar);
    }

    public static b newBuilder(Option option) {
        return DEFAULT_INSTANCE.toBuilder().l(option);
    }

    public static Option parseFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, qVar);
    }

    private Option(GeneratedMessageV3.b<?> bVar) {
        super(bVar);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static Option parseDelimitedFrom(InputStream inputStream, q qVar) throws IOException {
        return (Option) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
    }

    public static Option parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
    public Option getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
    public b toBuilder() {
        return this == DEFAULT_INSTANCE ? new b((a) null) : new b((a) null).l(this);
    }

    public static Option parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, qVar);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
    public b newBuilderForType() {
        return newBuilder();
    }

    private Option() {
        this.memoizedIsInitialized = (byte) -1;
        this.name_ = "";
    }

    public static Option parseFrom(InputStream inputStream) throws IOException {
        return (Option) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static Option parseFrom(InputStream inputStream, q qVar) throws IOException {
        return (Option) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
    }

    private Option(i iVar, q qVar) throws InvalidProtocolBufferException {
        this();
        boolean z10 = false;
        while (!z10) {
            try {
                try {
                    int F = iVar.F();
                    z10 = true;
                    if (F != 0) {
                        if (F == 10) {
                            this.name_ = iVar.E();
                        } else if (F == 18) {
                            Any.b bVar = null;
                            Any any = this.value_;
                            bVar = any != null ? any.toBuilder() : bVar;
                            Any any2 = (Any) iVar.v(Any.parser(), qVar);
                            this.value_ = any2;
                            if (bVar != null) {
                                bVar.j(any2);
                                this.value_ = bVar.buildPartial();
                            }
                        } else if (!iVar.I(F)) {
                        }
                    }
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

    public static Option parseFrom(i iVar) throws IOException {
        return (Option) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
    }

    public static Option parseFrom(i iVar, q qVar) throws IOException {
        return (Option) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
    }
}
