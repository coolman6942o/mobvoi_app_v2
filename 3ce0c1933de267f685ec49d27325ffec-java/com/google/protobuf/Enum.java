package com.google.protobuf;

import com.google.protobuf.Descriptors;
import com.google.protobuf.EnumValue;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Option;
import com.google.protobuf.SourceContext;
import com.google.protobuf.a;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public final class Enum extends GeneratedMessageV3 implements g0 {
    public static final int ENUMVALUE_FIELD_NUMBER = 2;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int OPTIONS_FIELD_NUMBER = 3;
    public static final int SOURCE_CONTEXT_FIELD_NUMBER = 4;
    public static final int SYNTAX_FIELD_NUMBER = 5;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private List<EnumValue> enumvalue_;
    private byte memoizedIsInitialized;
    private volatile Object name_;
    private List<Option> options_;
    private SourceContext sourceContext_;
    private int syntax_;
    private static final Enum DEFAULT_INSTANCE = new Enum();
    private static final l0<Enum> PARSER = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a extends c<Enum> {
        a() {
        }

        /* renamed from: a */
        public Enum parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
            return new Enum(iVar, qVar, null);
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends GeneratedMessageV3.b<b> implements g0 {

        /* renamed from: a  reason: collision with root package name */
        private int f12982a;

        /* renamed from: b  reason: collision with root package name */
        private Object f12983b;

        /* renamed from: c  reason: collision with root package name */
        private List<EnumValue> f12984c;

        /* renamed from: d  reason: collision with root package name */
        private o0<EnumValue, EnumValue.b, m> f12985d;

        /* renamed from: e  reason: collision with root package name */
        private List<Option> f12986e;

        /* renamed from: f  reason: collision with root package name */
        private o0<Option, Option.b, k0> f12987f;

        /* renamed from: g  reason: collision with root package name */
        private SourceContext f12988g;

        /* renamed from: h  reason: collision with root package name */
        private q0<SourceContext, SourceContext.b, s0> f12989h;

        /* renamed from: i  reason: collision with root package name */
        private int f12990i;

        /* synthetic */ b(a aVar) {
            this();
        }

        private void i() {
            if ((this.f12982a & 2) != 2) {
                this.f12984c = new ArrayList(this.f12984c);
                this.f12982a |= 2;
            }
        }

        private void j() {
            if ((this.f12982a & 4) != 4) {
                this.f12986e = new ArrayList(this.f12986e);
                this.f12982a |= 4;
            }
        }

        private o0<EnumValue, EnumValue.b, m> l() {
            if (this.f12985d == null) {
                this.f12985d = new o0<>(this.f12984c, (this.f12982a & 2) == 2, getParentForChildren(), isClean());
                this.f12984c = null;
            }
            return this.f12985d;
        }

        private o0<Option, Option.b, k0> m() {
            if (this.f12987f == null) {
                this.f12987f = new o0<>(this.f12986e, (this.f12982a & 4) == 4, getParentForChildren(), isClean());
                this.f12986e = null;
            }
            return this.f12987f;
        }

        private void maybeForceBuilderInitialization() {
            if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                l();
                m();
            }
        }

        /* renamed from: a */
        public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (b) super.addRepeatedField(fieldDescriptor, obj);
        }

        /* renamed from: b */
        public Enum build() {
            Enum c10 = buildPartial();
            if (c10.isInitialized()) {
                return c10;
            }
            throw a.AbstractC0170a.newUninitializedMessageException((d0) c10);
        }

        /* renamed from: c */
        public Enum buildPartial() {
            Enum r02 = new Enum(this, (a) null);
            r02.name_ = this.f12983b;
            o0<EnumValue, EnumValue.b, m> o0Var = this.f12985d;
            if (o0Var == null) {
                if ((this.f12982a & 2) == 2) {
                    this.f12984c = Collections.unmodifiableList(this.f12984c);
                    this.f12982a &= -3;
                }
                r02.enumvalue_ = this.f12984c;
            } else {
                r02.enumvalue_ = o0Var.g();
            }
            o0<Option, Option.b, k0> o0Var2 = this.f12987f;
            if (o0Var2 == null) {
                if ((this.f12982a & 4) == 4) {
                    this.f12986e = Collections.unmodifiableList(this.f12986e);
                    this.f12982a &= -5;
                }
                r02.options_ = this.f12986e;
            } else {
                r02.options_ = o0Var2.g();
            }
            q0<SourceContext, SourceContext.b, s0> q0Var = this.f12989h;
            if (q0Var == null) {
                r02.sourceContext_ = this.f12988g;
            } else {
                r02.sourceContext_ = q0Var.b();
            }
            r02.syntax_ = this.f12990i;
            r02.bitField0_ = 0;
            onBuilt();
            return r02;
        }

        /* renamed from: d */
        public b clear() {
            super.clear();
            this.f12983b = "";
            o0<EnumValue, EnumValue.b, m> o0Var = this.f12985d;
            if (o0Var == null) {
                this.f12984c = Collections.emptyList();
                this.f12982a &= -3;
            } else {
                o0Var.h();
            }
            o0<Option, Option.b, k0> o0Var2 = this.f12987f;
            if (o0Var2 == null) {
                this.f12986e = Collections.emptyList();
                this.f12982a &= -5;
            } else {
                o0Var2.h();
            }
            if (this.f12989h == null) {
                this.f12988g = null;
            } else {
                this.f12988g = null;
                this.f12989h = null;
            }
            this.f12990i = 0;
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
            return z0.f13394e;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.b
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return z0.f13395f.e(Enum.class, b.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.f0
        public final boolean isInitialized() {
            return true;
        }

        /* renamed from: k */
        public Enum getDefaultInstanceForType() {
            return Enum.getDefaultInstance();
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0023  */
        /* renamed from: n */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b mergeFrom(i iVar, q qVar) throws IOException {
            Throwable th2;
            Enum r02 = null;
            try {
                try {
                    Enum r32 = (Enum) Enum.PARSER.parsePartialFrom(iVar, qVar);
                    if (r32 != null) {
                        o(r32);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e10) {
                    r02 = (Enum) e10.getUnfinishedMessage();
                    try {
                        throw e10.unwrapIOException();
                    } catch (Throwable th3) {
                        th2 = th3;
                        if (r02 != null) {
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th4) {
                th2 = th4;
                if (r02 != null) {
                    o(r02);
                }
                throw th2;
            }
        }

        public b o(Enum r42) {
            if (r42 == Enum.getDefaultInstance()) {
                return this;
            }
            if (!r42.getName().isEmpty()) {
                this.f12983b = r42.name_;
                onChanged();
            }
            o0<Option, Option.b, k0> o0Var = null;
            if (this.f12985d == null) {
                if (!r42.enumvalue_.isEmpty()) {
                    if (this.f12984c.isEmpty()) {
                        this.f12984c = r42.enumvalue_;
                        this.f12982a &= -3;
                    } else {
                        i();
                        this.f12984c.addAll(r42.enumvalue_);
                    }
                    onChanged();
                }
            } else if (!r42.enumvalue_.isEmpty()) {
                if (this.f12985d.u()) {
                    this.f12985d.i();
                    this.f12985d = null;
                    this.f12984c = r42.enumvalue_;
                    this.f12982a &= -3;
                    this.f12985d = GeneratedMessageV3.alwaysUseFieldBuilders ? l() : null;
                } else {
                    this.f12985d.b(r42.enumvalue_);
                }
            }
            if (this.f12987f == null) {
                if (!r42.options_.isEmpty()) {
                    if (this.f12986e.isEmpty()) {
                        this.f12986e = r42.options_;
                        this.f12982a &= -5;
                    } else {
                        j();
                        this.f12986e.addAll(r42.options_);
                    }
                    onChanged();
                }
            } else if (!r42.options_.isEmpty()) {
                if (this.f12987f.u()) {
                    this.f12987f.i();
                    this.f12987f = null;
                    this.f12986e = r42.options_;
                    this.f12982a &= -5;
                    if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                        o0Var = m();
                    }
                    this.f12987f = o0Var;
                } else {
                    this.f12987f.b(r42.options_);
                }
            }
            if (r42.hasSourceContext()) {
                q(r42.getSourceContext());
            }
            if (r42.syntax_ != 0) {
                u(r42.getSyntaxValue());
            }
            onChanged();
            return this;
        }

        /* renamed from: p */
        public b mergeFrom(d0 d0Var) {
            if (d0Var instanceof Enum) {
                return o((Enum) d0Var);
            }
            super.mergeFrom(d0Var);
            return this;
        }

        public b q(SourceContext sourceContext) {
            q0<SourceContext, SourceContext.b, s0> q0Var = this.f12989h;
            if (q0Var == null) {
                SourceContext sourceContext2 = this.f12988g;
                if (sourceContext2 != null) {
                    this.f12988g = SourceContext.newBuilder(sourceContext2).l(sourceContext).buildPartial();
                } else {
                    this.f12988g = sourceContext;
                }
                onChanged();
            } else {
                q0Var.h(sourceContext);
            }
            return this;
        }

        /* renamed from: r */
        public final b mergeUnknownFields(a1 a1Var) {
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

        public b u(int i10) {
            this.f12990i = i10;
            onChanged();
            return this;
        }

        /* renamed from: v */
        public final b setUnknownFields(a1 a1Var) {
            return this;
        }

        /* synthetic */ b(GeneratedMessageV3.c cVar, a aVar) {
            this(cVar);
        }

        private b() {
            this.f12983b = "";
            this.f12984c = Collections.emptyList();
            this.f12986e = Collections.emptyList();
            this.f12988g = null;
            this.f12990i = 0;
            maybeForceBuilderInitialization();
        }

        private b(GeneratedMessageV3.c cVar) {
            super(cVar);
            this.f12983b = "";
            this.f12984c = Collections.emptyList();
            this.f12986e = Collections.emptyList();
            this.f12988g = null;
            this.f12990i = 0;
            maybeForceBuilderInitialization();
        }
    }

    /* synthetic */ Enum(i iVar, q qVar, a aVar) throws InvalidProtocolBufferException {
        this(iVar, qVar);
    }

    public static Enum getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.b getDescriptor() {
        return z0.f13394e;
    }

    public static b newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Enum parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Enum) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Enum parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static l0<Enum> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.a
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Enum)) {
            return super.equals(obj);
        }
        Enum r52 = (Enum) obj;
        boolean z10 = (((getName().equals(r52.getName())) && getEnumvalueList().equals(r52.getEnumvalueList())) && getOptionsList().equals(r52.getOptionsList())) && hasSourceContext() == r52.hasSourceContext();
        if (hasSourceContext()) {
            z10 = z10 && getSourceContext().equals(r52.getSourceContext());
        }
        return z10 && this.syntax_ == r52.syntax_;
    }

    public EnumValue getEnumvalue(int i10) {
        return this.enumvalue_.get(i10);
    }

    public int getEnumvalueCount() {
        return this.enumvalue_.size();
    }

    public List<EnumValue> getEnumvalueList() {
        return this.enumvalue_;
    }

    public m getEnumvalueOrBuilder(int i10) {
        return this.enumvalue_.get(i10);
    }

    public List<? extends m> getEnumvalueOrBuilderList() {
        return this.enumvalue_;
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
    public l0<Enum> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
    public int getSerializedSize() {
        int i10 = this.memoizedSize;
        if (i10 != -1) {
            return i10;
        }
        int computeStringSize = !getNameBytes().isEmpty() ? GeneratedMessageV3.computeStringSize(1, this.name_) + 0 : 0;
        for (int i11 = 0; i11 < this.enumvalue_.size(); i11++) {
            computeStringSize += CodedOutputStream.E(2, this.enumvalue_.get(i11));
        }
        for (int i12 = 0; i12 < this.options_.size(); i12++) {
            computeStringSize += CodedOutputStream.E(3, this.options_.get(i12));
        }
        if (this.sourceContext_ != null) {
            computeStringSize += CodedOutputStream.E(4, getSourceContext());
        }
        if (this.syntax_ != Syntax.SYNTAX_PROTO2.getNumber()) {
            computeStringSize += CodedOutputStream.l(5, this.syntax_);
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
        if (getEnumvalueCount() > 0) {
            hashCode = (((hashCode * 37) + 2) * 53) + getEnumvalueList().hashCode();
        }
        if (getOptionsCount() > 0) {
            hashCode = (((hashCode * 37) + 3) * 53) + getOptionsList().hashCode();
        }
        if (hasSourceContext()) {
            hashCode = (((hashCode * 37) + 4) * 53) + getSourceContext().hashCode();
        }
        int hashCode2 = (((((hashCode * 37) + 5) * 53) + this.syntax_) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode2;
        return hashCode2;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
        return z0.f13395f.e(Enum.class, b.class);
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
    /* renamed from: m */
    public b newBuilderForType(GeneratedMessageV3.c cVar) {
        return new b(cVar, null);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (!getNameBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 1, this.name_);
        }
        for (int i10 = 0; i10 < this.enumvalue_.size(); i10++) {
            codedOutputStream.A0(2, this.enumvalue_.get(i10));
        }
        for (int i11 = 0; i11 < this.options_.size(); i11++) {
            codedOutputStream.A0(3, this.options_.get(i11));
        }
        if (this.sourceContext_ != null) {
            codedOutputStream.A0(4, getSourceContext());
        }
        if (this.syntax_ != Syntax.SYNTAX_PROTO2.getNumber()) {
            codedOutputStream.m0(5, this.syntax_);
        }
    }

    /* synthetic */ Enum(GeneratedMessageV3.b bVar, a aVar) {
        this(bVar);
    }

    public static b newBuilder(Enum r12) {
        return DEFAULT_INSTANCE.toBuilder().o(r12);
    }

    public static Enum parseFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, qVar);
    }

    private Enum(GeneratedMessageV3.b<?> bVar) {
        super(bVar);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static Enum parseDelimitedFrom(InputStream inputStream, q qVar) throws IOException {
        return (Enum) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
    }

    public static Enum parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
    public Enum getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
    public b toBuilder() {
        return this == DEFAULT_INSTANCE ? new b((a) null) : new b((a) null).o(this);
    }

    public static Enum parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, qVar);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
    public b newBuilderForType() {
        return newBuilder();
    }

    private Enum() {
        this.memoizedIsInitialized = (byte) -1;
        this.name_ = "";
        this.enumvalue_ = Collections.emptyList();
        this.options_ = Collections.emptyList();
        this.syntax_ = 0;
    }

    public static Enum parseFrom(InputStream inputStream) throws IOException {
        return (Enum) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static Enum parseFrom(InputStream inputStream, q qVar) throws IOException {
        return (Enum) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
    }

    public static Enum parseFrom(i iVar) throws IOException {
        return (Enum) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Enum(i iVar, q qVar) throws InvalidProtocolBufferException {
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
                            if (!(z11 & true)) {
                                this.enumvalue_ = new ArrayList();
                                z11 |= true;
                            }
                            this.enumvalue_.add(iVar.v(EnumValue.parser(), qVar));
                        } else if (F == 26) {
                            if (!(z11 & true)) {
                                this.options_ = new ArrayList();
                                z11 |= true;
                            }
                            this.options_.add(iVar.v(Option.parser(), qVar));
                        } else if (F == 34) {
                            SourceContext.b bVar = null;
                            SourceContext sourceContext = this.sourceContext_;
                            bVar = sourceContext != null ? sourceContext.toBuilder() : bVar;
                            SourceContext sourceContext2 = (SourceContext) iVar.v(SourceContext.parser(), qVar);
                            this.sourceContext_ = sourceContext2;
                            if (bVar != null) {
                                bVar.l(sourceContext2);
                                this.sourceContext_ = bVar.buildPartial();
                            }
                        } else if (F == 40) {
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
                    this.enumvalue_ = Collections.unmodifiableList(this.enumvalue_);
                }
                if (z11 & true) {
                    this.options_ = Collections.unmodifiableList(this.options_);
                }
                makeExtensionsImmutable();
            }
        }
    }

    public static Enum parseFrom(i iVar, q qVar) throws IOException {
        return (Enum) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
    }
}
