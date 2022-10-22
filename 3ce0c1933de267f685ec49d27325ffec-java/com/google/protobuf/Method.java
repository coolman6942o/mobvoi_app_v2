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
public final class Method extends GeneratedMessageV3 implements h0 {
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int OPTIONS_FIELD_NUMBER = 6;
    public static final int REQUEST_STREAMING_FIELD_NUMBER = 3;
    public static final int REQUEST_TYPE_URL_FIELD_NUMBER = 2;
    public static final int RESPONSE_STREAMING_FIELD_NUMBER = 5;
    public static final int RESPONSE_TYPE_URL_FIELD_NUMBER = 4;
    public static final int SYNTAX_FIELD_NUMBER = 7;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private byte memoizedIsInitialized;
    private volatile Object name_;
    private List<Option> options_;
    private boolean requestStreaming_;
    private volatile Object requestTypeUrl_;
    private boolean responseStreaming_;
    private volatile Object responseTypeUrl_;
    private int syntax_;
    private static final Method DEFAULT_INSTANCE = new Method();
    private static final l0<Method> PARSER = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a extends c<Method> {
        a() {
        }

        /* renamed from: a */
        public Method parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
            return new Method(iVar, qVar, null);
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends GeneratedMessageV3.b<b> implements h0 {

        /* renamed from: a  reason: collision with root package name */
        private int f13094a;

        /* renamed from: b  reason: collision with root package name */
        private Object f13095b;

        /* renamed from: c  reason: collision with root package name */
        private Object f13096c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f13097d;

        /* renamed from: e  reason: collision with root package name */
        private Object f13098e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f13099f;

        /* renamed from: g  reason: collision with root package name */
        private List<Option> f13100g;

        /* renamed from: h  reason: collision with root package name */
        private o0<Option, Option.b, k0> f13101h;

        /* renamed from: i  reason: collision with root package name */
        private int f13102i;

        /* synthetic */ b(GeneratedMessageV3.c cVar, a aVar) {
            this(cVar);
        }

        private void i() {
            if ((this.f13094a & 32) != 32) {
                this.f13100g = new ArrayList(this.f13100g);
                this.f13094a |= 32;
            }
        }

        private o0<Option, Option.b, k0> k() {
            if (this.f13101h == null) {
                this.f13101h = new o0<>(this.f13100g, (this.f13094a & 32) == 32, getParentForChildren(), isClean());
                this.f13100g = null;
            }
            return this.f13101h;
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
        public Method build() {
            Method c10 = buildPartial();
            if (c10.isInitialized()) {
                return c10;
            }
            throw a.AbstractC0170a.newUninitializedMessageException((d0) c10);
        }

        /* renamed from: c */
        public Method buildPartial() {
            Method method = new Method(this, (a) null);
            method.name_ = this.f13095b;
            method.requestTypeUrl_ = this.f13096c;
            method.requestStreaming_ = this.f13097d;
            method.responseTypeUrl_ = this.f13098e;
            method.responseStreaming_ = this.f13099f;
            o0<Option, Option.b, k0> o0Var = this.f13101h;
            if (o0Var == null) {
                if ((this.f13094a & 32) == 32) {
                    this.f13100g = Collections.unmodifiableList(this.f13100g);
                    this.f13094a &= -33;
                }
                method.options_ = this.f13100g;
            } else {
                method.options_ = o0Var.g();
            }
            method.syntax_ = this.f13102i;
            method.bitField0_ = 0;
            onBuilt();
            return method;
        }

        /* renamed from: d */
        public b clear() {
            super.clear();
            this.f13095b = "";
            this.f13096c = "";
            this.f13097d = false;
            this.f13098e = "";
            this.f13099f = false;
            o0<Option, Option.b, k0> o0Var = this.f13101h;
            if (o0Var == null) {
                this.f13100g = Collections.emptyList();
                this.f13094a &= -33;
            } else {
                o0Var.h();
            }
            this.f13102i = 0;
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
            return g.f13244c;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.b
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return g.f13245d.e(Method.class, b.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.f0
        public final boolean isInitialized() {
            return true;
        }

        /* renamed from: j */
        public Method getDefaultInstanceForType() {
            return Method.getDefaultInstance();
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0023  */
        /* renamed from: l */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b mergeFrom(i iVar, q qVar) throws IOException {
            Throwable th2;
            Method method = null;
            try {
                try {
                    Method method2 = (Method) Method.PARSER.parsePartialFrom(iVar, qVar);
                    if (method2 != null) {
                        n(method2);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e10) {
                    method = (Method) e10.getUnfinishedMessage();
                    try {
                        throw e10.unwrapIOException();
                    } catch (Throwable th3) {
                        th2 = th3;
                        if (method != null) {
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th4) {
                th2 = th4;
                if (method != null) {
                    n(method);
                }
                throw th2;
            }
        }

        /* renamed from: m */
        public b mergeFrom(d0 d0Var) {
            if (d0Var instanceof Method) {
                return n((Method) d0Var);
            }
            super.mergeFrom(d0Var);
            return this;
        }

        public b n(Method method) {
            if (method == Method.getDefaultInstance()) {
                return this;
            }
            if (!method.getName().isEmpty()) {
                this.f13095b = method.name_;
                onChanged();
            }
            if (!method.getRequestTypeUrl().isEmpty()) {
                this.f13096c = method.requestTypeUrl_;
                onChanged();
            }
            if (method.getRequestStreaming()) {
                r(method.getRequestStreaming());
            }
            if (!method.getResponseTypeUrl().isEmpty()) {
                this.f13098e = method.responseTypeUrl_;
                onChanged();
            }
            if (method.getResponseStreaming()) {
                s(method.getResponseStreaming());
            }
            if (this.f13101h == null) {
                if (!method.options_.isEmpty()) {
                    if (this.f13100g.isEmpty()) {
                        this.f13100g = method.options_;
                        this.f13094a &= -33;
                    } else {
                        i();
                        this.f13100g.addAll(method.options_);
                    }
                    onChanged();
                }
            } else if (!method.options_.isEmpty()) {
                if (this.f13101h.u()) {
                    this.f13101h.i();
                    o0<Option, Option.b, k0> o0Var = null;
                    this.f13101h = null;
                    this.f13100g = method.options_;
                    this.f13094a &= -33;
                    if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                        o0Var = k();
                    }
                    this.f13101h = o0Var;
                } else {
                    this.f13101h.b(method.options_);
                }
            }
            if (method.syntax_ != 0) {
                t(method.getSyntaxValue());
            }
            onChanged();
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

        /* renamed from: q */
        public b setRepeatedField2(Descriptors.FieldDescriptor fieldDescriptor, int i10, Object obj) {
            return (b) super.setRepeatedField(fieldDescriptor, i10, obj);
        }

        public b r(boolean z10) {
            this.f13097d = z10;
            onChanged();
            return this;
        }

        public b s(boolean z10) {
            this.f13099f = z10;
            onChanged();
            return this;
        }

        public b t(int i10) {
            this.f13102i = i10;
            onChanged();
            return this;
        }

        /* renamed from: u */
        public final b setUnknownFields(a1 a1Var) {
            return this;
        }

        /* synthetic */ b(a aVar) {
            this();
        }

        private b() {
            this.f13095b = "";
            this.f13096c = "";
            this.f13098e = "";
            this.f13100g = Collections.emptyList();
            this.f13102i = 0;
            maybeForceBuilderInitialization();
        }

        private b(GeneratedMessageV3.c cVar) {
            super(cVar);
            this.f13095b = "";
            this.f13096c = "";
            this.f13098e = "";
            this.f13100g = Collections.emptyList();
            this.f13102i = 0;
            maybeForceBuilderInitialization();
        }
    }

    /* synthetic */ Method(i iVar, q qVar, a aVar) throws InvalidProtocolBufferException {
        this(iVar, qVar);
    }

    public static Method getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.b getDescriptor() {
        return g.f13244c;
    }

    public static b newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Method parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Method) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Method parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static l0<Method> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.a
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Method)) {
            return super.equals(obj);
        }
        Method method = (Method) obj;
        return ((((((getName().equals(method.getName())) && getRequestTypeUrl().equals(method.getRequestTypeUrl())) && getRequestStreaming() == method.getRequestStreaming()) && getResponseTypeUrl().equals(method.getResponseTypeUrl())) && getResponseStreaming() == method.getResponseStreaming()) && getOptionsList().equals(method.getOptionsList())) && this.syntax_ == method.syntax_;
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
    public l0<Method> getParserForType() {
        return PARSER;
    }

    public boolean getRequestStreaming() {
        return this.requestStreaming_;
    }

    public String getRequestTypeUrl() {
        Object obj = this.requestTypeUrl_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.requestTypeUrl_ = stringUtf8;
        return stringUtf8;
    }

    public ByteString getRequestTypeUrlBytes() {
        Object obj = this.requestTypeUrl_;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.requestTypeUrl_ = copyFromUtf8;
        return copyFromUtf8;
    }

    public boolean getResponseStreaming() {
        return this.responseStreaming_;
    }

    public String getResponseTypeUrl() {
        Object obj = this.responseTypeUrl_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.responseTypeUrl_ = stringUtf8;
        return stringUtf8;
    }

    public ByteString getResponseTypeUrlBytes() {
        Object obj = this.responseTypeUrl_;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.responseTypeUrl_ = copyFromUtf8;
        return copyFromUtf8;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
    public int getSerializedSize() {
        int i10 = this.memoizedSize;
        if (i10 != -1) {
            return i10;
        }
        int computeStringSize = !getNameBytes().isEmpty() ? GeneratedMessageV3.computeStringSize(1, this.name_) + 0 : 0;
        if (!getRequestTypeUrlBytes().isEmpty()) {
            computeStringSize += GeneratedMessageV3.computeStringSize(2, this.requestTypeUrl_);
        }
        boolean z10 = this.requestStreaming_;
        if (z10) {
            computeStringSize += CodedOutputStream.e(3, z10);
        }
        if (!getResponseTypeUrlBytes().isEmpty()) {
            computeStringSize += GeneratedMessageV3.computeStringSize(4, this.responseTypeUrl_);
        }
        boolean z11 = this.responseStreaming_;
        if (z11) {
            computeStringSize += CodedOutputStream.e(5, z11);
        }
        for (int i11 = 0; i11 < this.options_.size(); i11++) {
            computeStringSize += CodedOutputStream.E(6, this.options_.get(i11));
        }
        if (this.syntax_ != Syntax.SYNTAX_PROTO2.getNumber()) {
            computeStringSize += CodedOutputStream.l(7, this.syntax_);
        }
        this.memoizedSize = computeStringSize;
        return computeStringSize;
    }

    public Syntax getSyntax() {
        Syntax valueOf = Syntax.valueOf(this.syntax_);
        return valueOf == null ? Syntax.UNRECOGNIZED : valueOf;
    }

    public int getSyntaxValue() {
        return this.syntax_;
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
        int hashCode = ((((((((((((((((((((779 + getDescriptorForType().hashCode()) * 37) + 1) * 53) + getName().hashCode()) * 37) + 2) * 53) + getRequestTypeUrl().hashCode()) * 37) + 3) * 53) + u.c(getRequestStreaming())) * 37) + 4) * 53) + getResponseTypeUrl().hashCode()) * 37) + 5) * 53) + u.c(getResponseStreaming());
        if (getOptionsCount() > 0) {
            hashCode = (((hashCode * 37) + 6) * 53) + getOptionsList().hashCode();
        }
        int hashCode2 = (((((hashCode * 37) + 7) * 53) + this.syntax_) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode2;
        return hashCode2;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
        return g.f13245d.e(Method.class, b.class);
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
    /* renamed from: p */
    public b newBuilderForType(GeneratedMessageV3.c cVar) {
        return new b(cVar, null);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (!getNameBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 1, this.name_);
        }
        if (!getRequestTypeUrlBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 2, this.requestTypeUrl_);
        }
        boolean z10 = this.requestStreaming_;
        if (z10) {
            codedOutputStream.e0(3, z10);
        }
        if (!getResponseTypeUrlBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 4, this.responseTypeUrl_);
        }
        boolean z11 = this.responseStreaming_;
        if (z11) {
            codedOutputStream.e0(5, z11);
        }
        for (int i10 = 0; i10 < this.options_.size(); i10++) {
            codedOutputStream.A0(6, this.options_.get(i10));
        }
        if (this.syntax_ != Syntax.SYNTAX_PROTO2.getNumber()) {
            codedOutputStream.m0(7, this.syntax_);
        }
    }

    /* synthetic */ Method(GeneratedMessageV3.b bVar, a aVar) {
        this(bVar);
    }

    public static b newBuilder(Method method) {
        return DEFAULT_INSTANCE.toBuilder().n(method);
    }

    public static Method parseFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, qVar);
    }

    private Method(GeneratedMessageV3.b<?> bVar) {
        super(bVar);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static Method parseDelimitedFrom(InputStream inputStream, q qVar) throws IOException {
        return (Method) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
    }

    public static Method parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
    public Method getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
    public b toBuilder() {
        return this == DEFAULT_INSTANCE ? new b((a) null) : new b((a) null).n(this);
    }

    public static Method parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, qVar);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
    public b newBuilderForType() {
        return newBuilder();
    }

    private Method() {
        this.memoizedIsInitialized = (byte) -1;
        this.name_ = "";
        this.requestTypeUrl_ = "";
        this.requestStreaming_ = false;
        this.responseTypeUrl_ = "";
        this.responseStreaming_ = false;
        this.options_ = Collections.emptyList();
        this.syntax_ = 0;
    }

    public static Method parseFrom(InputStream inputStream) throws IOException {
        return (Method) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static Method parseFrom(InputStream inputStream, q qVar) throws IOException {
        return (Method) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
    }

    public static Method parseFrom(i iVar) throws IOException {
        return (Method) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
    }

    public static Method parseFrom(i iVar, q qVar) throws IOException {
        return (Method) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Method(i iVar, q qVar) throws InvalidProtocolBufferException {
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
                        } else if (F == 18) {
                            this.requestTypeUrl_ = iVar.E();
                        } else if (F == 24) {
                            this.requestStreaming_ = iVar.l();
                        } else if (F == 34) {
                            this.responseTypeUrl_ = iVar.E();
                        } else if (F == 40) {
                            this.responseStreaming_ = iVar.l();
                        } else if (F == 50) {
                            if (!(z11 & true)) {
                                this.options_ = new ArrayList();
                                z11 |= true;
                            }
                            this.options_.add(iVar.v(Option.parser(), qVar));
                        } else if (F == 56) {
                            this.syntax_ = iVar.o();
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
}
