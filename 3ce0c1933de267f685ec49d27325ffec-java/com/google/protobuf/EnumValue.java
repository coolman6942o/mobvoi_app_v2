package com.google.protobuf;

import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Option;
import com.google.protobuf.a;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public final class EnumValue extends GeneratedMessageV3 implements m {
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int NUMBER_FIELD_NUMBER = 2;
    public static final int OPTIONS_FIELD_NUMBER = 3;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private byte memoizedIsInitialized;
    private volatile Object name_;
    private int number_;
    private List<Option> options_;
    private static final EnumValue DEFAULT_INSTANCE = new EnumValue();
    private static final l0<EnumValue> PARSER = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a extends c<EnumValue> {
        a() {
        }

        /* renamed from: a */
        public EnumValue parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
            return new EnumValue(iVar, qVar, null);
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends GeneratedMessageV3.b<b> implements m {

        /* renamed from: a  reason: collision with root package name */
        private int f12991a;

        /* renamed from: b  reason: collision with root package name */
        private Object f12992b;

        /* renamed from: c  reason: collision with root package name */
        private int f12993c;

        /* renamed from: d  reason: collision with root package name */
        private List<Option> f12994d;

        /* renamed from: e  reason: collision with root package name */
        private o0<Option, Option.b, k0> f12995e;

        /* synthetic */ b(a aVar) {
            this();
        }

        private void i() {
            if ((this.f12991a & 4) != 4) {
                this.f12994d = new ArrayList(this.f12994d);
                this.f12991a |= 4;
            }
        }

        private o0<Option, Option.b, k0> k() {
            if (this.f12995e == null) {
                this.f12995e = new o0<>(this.f12994d, (this.f12991a & 4) == 4, getParentForChildren(), isClean());
                this.f12994d = null;
            }
            return this.f12995e;
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
        public EnumValue build() {
            EnumValue c10 = buildPartial();
            if (c10.isInitialized()) {
                return c10;
            }
            throw a.AbstractC0170a.newUninitializedMessageException((d0) c10);
        }

        /* renamed from: c */
        public EnumValue buildPartial() {
            EnumValue enumValue = new EnumValue(this, (a) null);
            enumValue.name_ = this.f12992b;
            enumValue.number_ = this.f12993c;
            o0<Option, Option.b, k0> o0Var = this.f12995e;
            if (o0Var == null) {
                if ((this.f12991a & 4) == 4) {
                    this.f12994d = Collections.unmodifiableList(this.f12994d);
                    this.f12991a &= -5;
                }
                enumValue.options_ = this.f12994d;
            } else {
                enumValue.options_ = o0Var.g();
            }
            enumValue.bitField0_ = 0;
            onBuilt();
            return enumValue;
        }

        /* renamed from: d */
        public b clear() {
            super.clear();
            this.f12992b = "";
            this.f12993c = 0;
            o0<Option, Option.b, k0> o0Var = this.f12995e;
            if (o0Var == null) {
                this.f12994d = Collections.emptyList();
                this.f12991a &= -5;
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
            return z0.f13396g;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.b
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return z0.f13397h.e(EnumValue.class, b.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.f0
        public final boolean isInitialized() {
            return true;
        }

        /* renamed from: j */
        public EnumValue getDefaultInstanceForType() {
            return EnumValue.getDefaultInstance();
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0023  */
        /* renamed from: l */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b mergeFrom(i iVar, q qVar) throws IOException {
            Throwable th2;
            EnumValue enumValue = null;
            try {
                try {
                    EnumValue enumValue2 = (EnumValue) EnumValue.PARSER.parsePartialFrom(iVar, qVar);
                    if (enumValue2 != null) {
                        m(enumValue2);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e10) {
                    enumValue = (EnumValue) e10.getUnfinishedMessage();
                    try {
                        throw e10.unwrapIOException();
                    } catch (Throwable th3) {
                        th2 = th3;
                        if (enumValue != null) {
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th4) {
                th2 = th4;
                if (enumValue != null) {
                    m(enumValue);
                }
                throw th2;
            }
        }

        public b m(EnumValue enumValue) {
            if (enumValue == EnumValue.getDefaultInstance()) {
                return this;
            }
            if (!enumValue.getName().isEmpty()) {
                this.f12992b = enumValue.name_;
                onChanged();
            }
            if (enumValue.getNumber() != 0) {
                q(enumValue.getNumber());
            }
            if (this.f12995e == null) {
                if (!enumValue.options_.isEmpty()) {
                    if (this.f12994d.isEmpty()) {
                        this.f12994d = enumValue.options_;
                        this.f12991a &= -5;
                    } else {
                        i();
                        this.f12994d.addAll(enumValue.options_);
                    }
                    onChanged();
                }
            } else if (!enumValue.options_.isEmpty()) {
                if (this.f12995e.u()) {
                    this.f12995e.i();
                    o0<Option, Option.b, k0> o0Var = null;
                    this.f12995e = null;
                    this.f12994d = enumValue.options_;
                    this.f12991a &= -5;
                    if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                        o0Var = k();
                    }
                    this.f12995e = o0Var;
                } else {
                    this.f12995e.b(enumValue.options_);
                }
            }
            onChanged();
            return this;
        }

        /* renamed from: n */
        public b mergeFrom(d0 d0Var) {
            if (d0Var instanceof EnumValue) {
                return m((EnumValue) d0Var);
            }
            super.mergeFrom(d0Var);
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

        public b q(int i10) {
            this.f12993c = i10;
            onChanged();
            return this;
        }

        /* renamed from: r */
        public b setRepeatedField2(Descriptors.FieldDescriptor fieldDescriptor, int i10, Object obj) {
            return (b) super.setRepeatedField(fieldDescriptor, i10, obj);
        }

        /* renamed from: s */
        public final b setUnknownFields(a1 a1Var) {
            return this;
        }

        /* synthetic */ b(GeneratedMessageV3.c cVar, a aVar) {
            this(cVar);
        }

        private b() {
            this.f12992b = "";
            this.f12994d = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        private b(GeneratedMessageV3.c cVar) {
            super(cVar);
            this.f12992b = "";
            this.f12994d = Collections.emptyList();
            maybeForceBuilderInitialization();
        }
    }

    /* synthetic */ EnumValue(i iVar, q qVar, a aVar) throws InvalidProtocolBufferException {
        this(iVar, qVar);
    }

    public static EnumValue getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.b getDescriptor() {
        return z0.f13396g;
    }

    public static b newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static EnumValue parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (EnumValue) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static EnumValue parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static l0<EnumValue> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.a
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EnumValue)) {
            return super.equals(obj);
        }
        EnumValue enumValue = (EnumValue) obj;
        return ((getName().equals(enumValue.getName())) && getNumber() == enumValue.getNumber()) && getOptionsList().equals(enumValue.getOptionsList());
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

    public int getNumber() {
        return this.number_;
    }

    public Option getOptions(int i10) {
        return this.options_.get(i10);
    }

    public int getOptionsCount() {
        return this.options_.size();
    }

    public List<Option> getOptionsList() {
        return this.options_;
    }

    public k0 getOptionsOrBuilder(int i10) {
        return this.options_.get(i10);
    }

    public List<? extends k0> getOptionsOrBuilderList() {
        return this.options_;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
    public l0<EnumValue> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
    public int getSerializedSize() {
        int i10 = this.memoizedSize;
        if (i10 != -1) {
            return i10;
        }
        int computeStringSize = !getNameBytes().isEmpty() ? GeneratedMessageV3.computeStringSize(1, this.name_) + 0 : 0;
        int i11 = this.number_;
        if (i11 != 0) {
            computeStringSize += CodedOutputStream.v(2, i11);
        }
        for (int i12 = 0; i12 < this.options_.size(); i12++) {
            computeStringSize += CodedOutputStream.E(3, this.options_.get(i12));
        }
        this.memoizedSize = computeStringSize;
        return computeStringSize;
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
        int hashCode = ((((((((779 + getDescriptorForType().hashCode()) * 37) + 1) * 53) + getName().hashCode()) * 37) + 2) * 53) + getNumber();
        if (getOptionsCount() > 0) {
            hashCode = (((hashCode * 37) + 3) * 53) + getOptionsList().hashCode();
        }
        int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode2;
        return hashCode2;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
        return z0.f13397h.e(EnumValue.class, b.class);
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
        if (!getNameBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 1, this.name_);
        }
        int i10 = this.number_;
        if (i10 != 0) {
            codedOutputStream.w0(2, i10);
        }
        for (int i11 = 0; i11 < this.options_.size(); i11++) {
            codedOutputStream.A0(3, this.options_.get(i11));
        }
    }

    /* synthetic */ EnumValue(GeneratedMessageV3.b bVar, a aVar) {
        this(bVar);
    }

    public static b newBuilder(EnumValue enumValue) {
        return DEFAULT_INSTANCE.toBuilder().m(enumValue);
    }

    public static EnumValue parseFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, qVar);
    }

    private EnumValue(GeneratedMessageV3.b<?> bVar) {
        super(bVar);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static EnumValue parseDelimitedFrom(InputStream inputStream, q qVar) throws IOException {
        return (EnumValue) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
    }

    public static EnumValue parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
    public EnumValue getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
    public b toBuilder() {
        return this == DEFAULT_INSTANCE ? new b((a) null) : new b((a) null).m(this);
    }

    public static EnumValue parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, qVar);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
    public b newBuilderForType() {
        return newBuilder();
    }

    private EnumValue() {
        this.memoizedIsInitialized = (byte) -1;
        this.name_ = "";
        this.number_ = 0;
        this.options_ = Collections.emptyList();
    }

    public static EnumValue parseFrom(InputStream inputStream) throws IOException {
        return (EnumValue) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static EnumValue parseFrom(InputStream inputStream, q qVar) throws IOException {
        return (EnumValue) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
    }

    public static EnumValue parseFrom(i iVar) throws IOException {
        return (EnumValue) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private EnumValue(i iVar, q qVar) throws InvalidProtocolBufferException {
        this();
        boolean z10 = false;
        boolean z11 = false;
        while (true) {
            if (z10) {
                break;
            }
            try {
                try {
                    int F = iVar.F();
                    z10 = true;
                    if (F != 0) {
                        if (F == 10) {
                            this.name_ = iVar.E();
                        } else if (F == 16) {
                            this.number_ = iVar.t();
                        } else if (F == 26) {
                            if (!(z11 & true)) {
                                this.options_ = new ArrayList();
                                z11 |= true;
                            }
                            this.options_.add(iVar.v(Option.parser(), qVar));
                        } else if (!iVar.I(F)) {
                        }
                    }
                } catch (InvalidProtocolBufferException e10) {
                    throw e10.setUnfinishedMessage(this);
                } catch (IOException e11) {
                    throw new InvalidProtocolBufferException(e11).setUnfinishedMessage(this);
                }
            } finally {
                if (z11 & true) {
                    this.options_ = Collections.unmodifiableList(this.options_);
                }
                makeExtensionsImmutable();
            }
        }
    }

    public static EnumValue parseFrom(i iVar, q qVar) throws IOException {
        return (EnumValue) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
    }
}
