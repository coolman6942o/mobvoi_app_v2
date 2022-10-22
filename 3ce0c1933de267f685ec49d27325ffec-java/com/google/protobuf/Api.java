package com.google.protobuf;

import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Method;
import com.google.protobuf.Mixin;
import com.google.protobuf.Option;
import com.google.protobuf.SourceContext;
import com.google.protobuf.a;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public final class Api extends GeneratedMessageV3 implements g0 {
    public static final int METHODS_FIELD_NUMBER = 2;
    public static final int MIXINS_FIELD_NUMBER = 6;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int OPTIONS_FIELD_NUMBER = 3;
    public static final int SOURCE_CONTEXT_FIELD_NUMBER = 5;
    public static final int SYNTAX_FIELD_NUMBER = 7;
    public static final int VERSION_FIELD_NUMBER = 4;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private byte memoizedIsInitialized;
    private List<Method> methods_;
    private List<Mixin> mixins_;
    private volatile Object name_;
    private List<Option> options_;
    private SourceContext sourceContext_;
    private int syntax_;
    private volatile Object version_;
    private static final Api DEFAULT_INSTANCE = new Api();
    private static final l0<Api> PARSER = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a extends c<Api> {
        a() {
        }

        /* renamed from: a */
        public Api parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
            return new Api(iVar, qVar, null);
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends GeneratedMessageV3.b<b> implements g0 {

        /* renamed from: a  reason: collision with root package name */
        private int f12686a;

        /* renamed from: b  reason: collision with root package name */
        private Object f12687b;

        /* renamed from: c  reason: collision with root package name */
        private List<Method> f12688c;

        /* renamed from: d  reason: collision with root package name */
        private o0<Method, Method.b, h0> f12689d;

        /* renamed from: e  reason: collision with root package name */
        private List<Option> f12690e;

        /* renamed from: f  reason: collision with root package name */
        private o0<Option, Option.b, k0> f12691f;

        /* renamed from: g  reason: collision with root package name */
        private Object f12692g;

        /* renamed from: h  reason: collision with root package name */
        private SourceContext f12693h;

        /* renamed from: i  reason: collision with root package name */
        private q0<SourceContext, SourceContext.b, s0> f12694i;

        /* renamed from: j  reason: collision with root package name */
        private List<Mixin> f12695j;

        /* renamed from: k  reason: collision with root package name */
        private o0<Mixin, Mixin.b, i0> f12696k;

        /* renamed from: l  reason: collision with root package name */
        private int f12697l;

        /* synthetic */ b(a aVar) {
            this();
        }

        private void i() {
            if ((this.f12686a & 2) != 2) {
                this.f12688c = new ArrayList(this.f12688c);
                this.f12686a |= 2;
            }
        }

        private void j() {
            if ((this.f12686a & 32) != 32) {
                this.f12695j = new ArrayList(this.f12695j);
                this.f12686a |= 32;
            }
        }

        private void k() {
            if ((this.f12686a & 4) != 4) {
                this.f12690e = new ArrayList(this.f12690e);
                this.f12686a |= 4;
            }
        }

        private o0<Method, Method.b, h0> m() {
            if (this.f12689d == null) {
                this.f12689d = new o0<>(this.f12688c, (this.f12686a & 2) == 2, getParentForChildren(), isClean());
                this.f12688c = null;
            }
            return this.f12689d;
        }

        private void maybeForceBuilderInitialization() {
            if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                m();
                o();
                n();
            }
        }

        private o0<Mixin, Mixin.b, i0> n() {
            if (this.f12696k == null) {
                this.f12696k = new o0<>(this.f12695j, (this.f12686a & 32) == 32, getParentForChildren(), isClean());
                this.f12695j = null;
            }
            return this.f12696k;
        }

        private o0<Option, Option.b, k0> o() {
            if (this.f12691f == null) {
                this.f12691f = new o0<>(this.f12690e, (this.f12686a & 4) == 4, getParentForChildren(), isClean());
                this.f12690e = null;
            }
            return this.f12691f;
        }

        /* renamed from: a */
        public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (b) super.addRepeatedField(fieldDescriptor, obj);
        }

        /* renamed from: b */
        public Api build() {
            Api c10 = buildPartial();
            if (c10.isInitialized()) {
                return c10;
            }
            throw a.AbstractC0170a.newUninitializedMessageException((d0) c10);
        }

        /* renamed from: c */
        public Api buildPartial() {
            Api api = new Api(this, (a) null);
            api.name_ = this.f12687b;
            o0<Method, Method.b, h0> o0Var = this.f12689d;
            if (o0Var == null) {
                if ((this.f12686a & 2) == 2) {
                    this.f12688c = Collections.unmodifiableList(this.f12688c);
                    this.f12686a &= -3;
                }
                api.methods_ = this.f12688c;
            } else {
                api.methods_ = o0Var.g();
            }
            o0<Option, Option.b, k0> o0Var2 = this.f12691f;
            if (o0Var2 == null) {
                if ((this.f12686a & 4) == 4) {
                    this.f12690e = Collections.unmodifiableList(this.f12690e);
                    this.f12686a &= -5;
                }
                api.options_ = this.f12690e;
            } else {
                api.options_ = o0Var2.g();
            }
            api.version_ = this.f12692g;
            q0<SourceContext, SourceContext.b, s0> q0Var = this.f12694i;
            if (q0Var == null) {
                api.sourceContext_ = this.f12693h;
            } else {
                api.sourceContext_ = q0Var.b();
            }
            o0<Mixin, Mixin.b, i0> o0Var3 = this.f12696k;
            if (o0Var3 == null) {
                if ((this.f12686a & 32) == 32) {
                    this.f12695j = Collections.unmodifiableList(this.f12695j);
                    this.f12686a &= -33;
                }
                api.mixins_ = this.f12695j;
            } else {
                api.mixins_ = o0Var3.g();
            }
            api.syntax_ = this.f12697l;
            api.bitField0_ = 0;
            onBuilt();
            return api;
        }

        /* renamed from: d */
        public b clear() {
            super.clear();
            this.f12687b = "";
            o0<Method, Method.b, h0> o0Var = this.f12689d;
            if (o0Var == null) {
                this.f12688c = Collections.emptyList();
                this.f12686a &= -3;
            } else {
                o0Var.h();
            }
            o0<Option, Option.b, k0> o0Var2 = this.f12691f;
            if (o0Var2 == null) {
                this.f12690e = Collections.emptyList();
                this.f12686a &= -5;
            } else {
                o0Var2.h();
            }
            this.f12692g = "";
            if (this.f12694i == null) {
                this.f12693h = null;
            } else {
                this.f12693h = null;
                this.f12694i = null;
            }
            o0<Mixin, Mixin.b, i0> o0Var3 = this.f12696k;
            if (o0Var3 == null) {
                this.f12695j = Collections.emptyList();
                this.f12686a &= -33;
            } else {
                o0Var3.h();
            }
            this.f12697l = 0;
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
            return g.f13242a;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.b
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return g.f13243b.e(Api.class, b.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.f0
        public final boolean isInitialized() {
            return true;
        }

        /* renamed from: l */
        public Api getDefaultInstanceForType() {
            return Api.getDefaultInstance();
        }

        public b p(Api api) {
            if (api == Api.getDefaultInstance()) {
                return this;
            }
            if (!api.getName().isEmpty()) {
                this.f12687b = api.name_;
                onChanged();
            }
            o0<Mixin, Mixin.b, i0> o0Var = null;
            if (this.f12689d == null) {
                if (!api.methods_.isEmpty()) {
                    if (this.f12688c.isEmpty()) {
                        this.f12688c = api.methods_;
                        this.f12686a &= -3;
                    } else {
                        i();
                        this.f12688c.addAll(api.methods_);
                    }
                    onChanged();
                }
            } else if (!api.methods_.isEmpty()) {
                if (this.f12689d.u()) {
                    this.f12689d.i();
                    this.f12689d = null;
                    this.f12688c = api.methods_;
                    this.f12686a &= -3;
                    this.f12689d = GeneratedMessageV3.alwaysUseFieldBuilders ? m() : null;
                } else {
                    this.f12689d.b(api.methods_);
                }
            }
            if (this.f12691f == null) {
                if (!api.options_.isEmpty()) {
                    if (this.f12690e.isEmpty()) {
                        this.f12690e = api.options_;
                        this.f12686a &= -5;
                    } else {
                        k();
                        this.f12690e.addAll(api.options_);
                    }
                    onChanged();
                }
            } else if (!api.options_.isEmpty()) {
                if (this.f12691f.u()) {
                    this.f12691f.i();
                    this.f12691f = null;
                    this.f12690e = api.options_;
                    this.f12686a &= -5;
                    this.f12691f = GeneratedMessageV3.alwaysUseFieldBuilders ? o() : null;
                } else {
                    this.f12691f.b(api.options_);
                }
            }
            if (!api.getVersion().isEmpty()) {
                this.f12692g = api.version_;
                onChanged();
            }
            if (api.hasSourceContext()) {
                s(api.getSourceContext());
            }
            if (this.f12696k == null) {
                if (!api.mixins_.isEmpty()) {
                    if (this.f12695j.isEmpty()) {
                        this.f12695j = api.mixins_;
                        this.f12686a &= -33;
                    } else {
                        j();
                        this.f12695j.addAll(api.mixins_);
                    }
                    onChanged();
                }
            } else if (!api.mixins_.isEmpty()) {
                if (this.f12696k.u()) {
                    this.f12696k.i();
                    this.f12696k = null;
                    this.f12695j = api.mixins_;
                    this.f12686a &= -33;
                    if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                        o0Var = n();
                    }
                    this.f12696k = o0Var;
                } else {
                    this.f12696k.b(api.mixins_);
                }
            }
            if (api.syntax_ != 0) {
                w(api.getSyntaxValue());
            }
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0023  */
        /* renamed from: q */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b mergeFrom(i iVar, q qVar) throws IOException {
            Throwable th2;
            Api api = null;
            try {
                try {
                    Api api2 = (Api) Api.PARSER.parsePartialFrom(iVar, qVar);
                    if (api2 != null) {
                        p(api2);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e10) {
                    api = (Api) e10.getUnfinishedMessage();
                    try {
                        throw e10.unwrapIOException();
                    } catch (Throwable th3) {
                        th2 = th3;
                        if (api != null) {
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th4) {
                th2 = th4;
                if (api != null) {
                    p(api);
                }
                throw th2;
            }
        }

        /* renamed from: r */
        public b mergeFrom(d0 d0Var) {
            if (d0Var instanceof Api) {
                return p((Api) d0Var);
            }
            super.mergeFrom(d0Var);
            return this;
        }

        public b s(SourceContext sourceContext) {
            q0<SourceContext, SourceContext.b, s0> q0Var = this.f12694i;
            if (q0Var == null) {
                SourceContext sourceContext2 = this.f12693h;
                if (sourceContext2 != null) {
                    this.f12693h = SourceContext.newBuilder(sourceContext2).l(sourceContext).buildPartial();
                } else {
                    this.f12693h = sourceContext;
                }
                onChanged();
            } else {
                q0Var.h(sourceContext);
            }
            return this;
        }

        /* renamed from: t */
        public final b mergeUnknownFields(a1 a1Var) {
            return this;
        }

        /* renamed from: u */
        public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (b) super.setField(fieldDescriptor, obj);
        }

        /* renamed from: v */
        public b setRepeatedField2(Descriptors.FieldDescriptor fieldDescriptor, int i10, Object obj) {
            return (b) super.setRepeatedField(fieldDescriptor, i10, obj);
        }

        public b w(int i10) {
            this.f12697l = i10;
            onChanged();
            return this;
        }

        /* renamed from: x */
        public final b setUnknownFields(a1 a1Var) {
            return this;
        }

        /* synthetic */ b(GeneratedMessageV3.c cVar, a aVar) {
            this(cVar);
        }

        private b() {
            this.f12687b = "";
            this.f12688c = Collections.emptyList();
            this.f12690e = Collections.emptyList();
            this.f12692g = "";
            this.f12693h = null;
            this.f12695j = Collections.emptyList();
            this.f12697l = 0;
            maybeForceBuilderInitialization();
        }

        private b(GeneratedMessageV3.c cVar) {
            super(cVar);
            this.f12687b = "";
            this.f12688c = Collections.emptyList();
            this.f12690e = Collections.emptyList();
            this.f12692g = "";
            this.f12693h = null;
            this.f12695j = Collections.emptyList();
            this.f12697l = 0;
            maybeForceBuilderInitialization();
        }
    }

    /* synthetic */ Api(i iVar, q qVar, a aVar) throws InvalidProtocolBufferException {
        this(iVar, qVar);
    }

    public static Api getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.b getDescriptor() {
        return g.f13242a;
    }

    public static b newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Api parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Api) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Api parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static l0<Api> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.a
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Api)) {
            return super.equals(obj);
        }
        Api api = (Api) obj;
        boolean z10 = ((((getName().equals(api.getName())) && getMethodsList().equals(api.getMethodsList())) && getOptionsList().equals(api.getOptionsList())) && getVersion().equals(api.getVersion())) && hasSourceContext() == api.hasSourceContext();
        if (hasSourceContext()) {
            z10 = z10 && getSourceContext().equals(api.getSourceContext());
        }
        return (z10 && getMixinsList().equals(api.getMixinsList())) && this.syntax_ == api.syntax_;
    }

    public Method getMethods(int i10) {
        return this.methods_.get(i10);
    }

    public int getMethodsCount() {
        return this.methods_.size();
    }

    public List<Method> getMethodsList() {
        return this.methods_;
    }

    public h0 getMethodsOrBuilder(int i10) {
        return this.methods_.get(i10);
    }

    public List<? extends h0> getMethodsOrBuilderList() {
        return this.methods_;
    }

    public Mixin getMixins(int i10) {
        return this.mixins_.get(i10);
    }

    public int getMixinsCount() {
        return this.mixins_.size();
    }

    public List<Mixin> getMixinsList() {
        return this.mixins_;
    }

    public i0 getMixinsOrBuilder(int i10) {
        return this.mixins_.get(i10);
    }

    public List<? extends i0> getMixinsOrBuilderList() {
        return this.mixins_;
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
    public l0<Api> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
    public int getSerializedSize() {
        int i10 = this.memoizedSize;
        if (i10 != -1) {
            return i10;
        }
        int computeStringSize = !getNameBytes().isEmpty() ? GeneratedMessageV3.computeStringSize(1, this.name_) + 0 : 0;
        for (int i11 = 0; i11 < this.methods_.size(); i11++) {
            computeStringSize += CodedOutputStream.E(2, this.methods_.get(i11));
        }
        for (int i12 = 0; i12 < this.options_.size(); i12++) {
            computeStringSize += CodedOutputStream.E(3, this.options_.get(i12));
        }
        if (!getVersionBytes().isEmpty()) {
            computeStringSize += GeneratedMessageV3.computeStringSize(4, this.version_);
        }
        if (this.sourceContext_ != null) {
            computeStringSize += CodedOutputStream.E(5, getSourceContext());
        }
        for (int i13 = 0; i13 < this.mixins_.size(); i13++) {
            computeStringSize += CodedOutputStream.E(6, this.mixins_.get(i13));
        }
        if (this.syntax_ != Syntax.SYNTAX_PROTO2.getNumber()) {
            computeStringSize += CodedOutputStream.l(7, this.syntax_);
        }
        this.memoizedSize = computeStringSize;
        return computeStringSize;
    }

    public SourceContext getSourceContext() {
        SourceContext sourceContext = this.sourceContext_;
        return sourceContext == null ? SourceContext.getDefaultInstance() : sourceContext;
    }

    public s0 getSourceContextOrBuilder() {
        return getSourceContext();
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

    public String getVersion() {
        Object obj = this.version_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.version_ = stringUtf8;
        return stringUtf8;
    }

    public ByteString getVersionBytes() {
        Object obj = this.version_;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.version_ = copyFromUtf8;
        return copyFromUtf8;
    }

    public boolean hasSourceContext() {
        return this.sourceContext_ != null;
    }

    @Override // com.google.protobuf.a
    public int hashCode() {
        int i10 = this.memoizedHashCode;
        if (i10 != 0) {
            return i10;
        }
        int hashCode = ((((779 + getDescriptorForType().hashCode()) * 37) + 1) * 53) + getName().hashCode();
        if (getMethodsCount() > 0) {
            hashCode = (((hashCode * 37) + 2) * 53) + getMethodsList().hashCode();
        }
        if (getOptionsCount() > 0) {
            hashCode = (((hashCode * 37) + 3) * 53) + getOptionsList().hashCode();
        }
        int hashCode2 = (((hashCode * 37) + 4) * 53) + getVersion().hashCode();
        if (hasSourceContext()) {
            hashCode2 = (((hashCode2 * 37) + 5) * 53) + getSourceContext().hashCode();
        }
        if (getMixinsCount() > 0) {
            hashCode2 = (((hashCode2 * 37) + 6) * 53) + getMixinsList().hashCode();
        }
        int hashCode3 = (((((hashCode2 * 37) + 7) * 53) + this.syntax_) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode3;
        return hashCode3;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
        return g.f13243b.e(Api.class, b.class);
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
    /* renamed from: q */
    public b newBuilderForType(GeneratedMessageV3.c cVar) {
        return new b(cVar, null);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (!getNameBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 1, this.name_);
        }
        for (int i10 = 0; i10 < this.methods_.size(); i10++) {
            codedOutputStream.A0(2, this.methods_.get(i10));
        }
        for (int i11 = 0; i11 < this.options_.size(); i11++) {
            codedOutputStream.A0(3, this.options_.get(i11));
        }
        if (!getVersionBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 4, this.version_);
        }
        if (this.sourceContext_ != null) {
            codedOutputStream.A0(5, getSourceContext());
        }
        for (int i12 = 0; i12 < this.mixins_.size(); i12++) {
            codedOutputStream.A0(6, this.mixins_.get(i12));
        }
        if (this.syntax_ != Syntax.SYNTAX_PROTO2.getNumber()) {
            codedOutputStream.m0(7, this.syntax_);
        }
    }

    /* synthetic */ Api(GeneratedMessageV3.b bVar, a aVar) {
        this(bVar);
    }

    public static b newBuilder(Api api) {
        return DEFAULT_INSTANCE.toBuilder().p(api);
    }

    public static Api parseFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, qVar);
    }

    private Api(GeneratedMessageV3.b<?> bVar) {
        super(bVar);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static Api parseDelimitedFrom(InputStream inputStream, q qVar) throws IOException {
        return (Api) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
    }

    public static Api parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
    public Api getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
    public b toBuilder() {
        return this == DEFAULT_INSTANCE ? new b((a) null) : new b((a) null).p(this);
    }

    public static Api parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, qVar);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
    public b newBuilderForType() {
        return newBuilder();
    }

    private Api() {
        this.memoizedIsInitialized = (byte) -1;
        this.name_ = "";
        this.methods_ = Collections.emptyList();
        this.options_ = Collections.emptyList();
        this.version_ = "";
        this.mixins_ = Collections.emptyList();
        this.syntax_ = 0;
    }

    public static Api parseFrom(InputStream inputStream) throws IOException {
        return (Api) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static Api parseFrom(InputStream inputStream, q qVar) throws IOException {
        return (Api) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
    }

    public static Api parseFrom(i iVar) throws IOException {
        return (Api) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
    }

    public static Api parseFrom(i iVar, q qVar) throws IOException {
        return (Api) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Api(i iVar, q qVar) throws InvalidProtocolBufferException {
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
                        z10 = true;
                        if (F != 0) {
                            if (F == 10) {
                                this.name_ = iVar.E();
                            } else if (F == 18) {
                                if (!(z11 & true)) {
                                    this.methods_ = new ArrayList();
                                    z11 |= true;
                                }
                                this.methods_.add(iVar.v(Method.parser(), qVar));
                            } else if (F == 26) {
                                if (!(z11 & true)) {
                                    this.options_ = new ArrayList();
                                    z11 |= true;
                                }
                                this.options_.add(iVar.v(Option.parser(), qVar));
                            } else if (F == 34) {
                                this.version_ = iVar.E();
                            } else if (F == 42) {
                                SourceContext.b bVar = null;
                                SourceContext sourceContext = this.sourceContext_;
                                bVar = sourceContext != null ? sourceContext.toBuilder() : bVar;
                                SourceContext sourceContext2 = (SourceContext) iVar.v(SourceContext.parser(), qVar);
                                this.sourceContext_ = sourceContext2;
                                if (bVar != null) {
                                    bVar.l(sourceContext2);
                                    this.sourceContext_ = bVar.buildPartial();
                                }
                            } else if (F == 50) {
                                if (!(z11 & true)) {
                                    this.mixins_ = new ArrayList();
                                    z11 |= true;
                                }
                                this.mixins_.add(iVar.v(Mixin.parser(), qVar));
                            } else if (F == 56) {
                                this.syntax_ = iVar.o();
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
                if (z11 & true) {
                    this.methods_ = Collections.unmodifiableList(this.methods_);
                }
                if (z11 & true) {
                    this.options_ = Collections.unmodifiableList(this.options_);
                }
                if (z11 & true) {
                    this.mixins_ = Collections.unmodifiableList(this.mixins_);
                }
                makeExtensionsImmutable();
            }
        }
    }
}
