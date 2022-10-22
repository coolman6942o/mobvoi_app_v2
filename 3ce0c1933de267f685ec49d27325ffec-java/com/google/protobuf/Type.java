package com.google.protobuf;

import com.google.protobuf.Descriptors;
import com.google.protobuf.Field;
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
public final class Type extends GeneratedMessageV3 implements g0 {
    public static final int FIELDS_FIELD_NUMBER = 2;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int ONEOFS_FIELD_NUMBER = 3;
    public static final int OPTIONS_FIELD_NUMBER = 4;
    public static final int SOURCE_CONTEXT_FIELD_NUMBER = 5;
    public static final int SYNTAX_FIELD_NUMBER = 6;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private List<Field> fields_;
    private byte memoizedIsInitialized;
    private volatile Object name_;
    private y oneofs_;
    private List<Option> options_;
    private SourceContext sourceContext_;
    private int syntax_;
    private static final Type DEFAULT_INSTANCE = new Type();
    private static final l0<Type> PARSER = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a extends c<Type> {
        a() {
        }

        /* renamed from: a */
        public Type parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
            return new Type(iVar, qVar, null);
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends GeneratedMessageV3.b<b> implements g0 {

        /* renamed from: a  reason: collision with root package name */
        private int f13124a;

        /* renamed from: b  reason: collision with root package name */
        private Object f13125b;

        /* renamed from: c  reason: collision with root package name */
        private List<Field> f13126c;

        /* renamed from: d  reason: collision with root package name */
        private o0<Field, Field.b, s> f13127d;

        /* renamed from: e  reason: collision with root package name */
        private y f13128e;

        /* renamed from: f  reason: collision with root package name */
        private List<Option> f13129f;

        /* renamed from: g  reason: collision with root package name */
        private o0<Option, Option.b, k0> f13130g;

        /* renamed from: h  reason: collision with root package name */
        private SourceContext f13131h;

        /* renamed from: i  reason: collision with root package name */
        private q0<SourceContext, SourceContext.b, s0> f13132i;

        /* renamed from: j  reason: collision with root package name */
        private int f13133j;

        /* synthetic */ b(GeneratedMessageV3.c cVar, a aVar) {
            this(cVar);
        }

        private void i() {
            if ((this.f13124a & 2) != 2) {
                this.f13126c = new ArrayList(this.f13126c);
                this.f13124a |= 2;
            }
        }

        private void j() {
            if ((this.f13124a & 4) != 4) {
                this.f13128e = new x(this.f13128e);
                this.f13124a |= 4;
            }
        }

        private void k() {
            if ((this.f13124a & 8) != 8) {
                this.f13129f = new ArrayList(this.f13129f);
                this.f13124a |= 8;
            }
        }

        private o0<Field, Field.b, s> m() {
            if (this.f13127d == null) {
                this.f13127d = new o0<>(this.f13126c, (this.f13124a & 2) == 2, getParentForChildren(), isClean());
                this.f13126c = null;
            }
            return this.f13127d;
        }

        private void maybeForceBuilderInitialization() {
            if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                m();
                n();
            }
        }

        private o0<Option, Option.b, k0> n() {
            if (this.f13130g == null) {
                this.f13130g = new o0<>(this.f13129f, (this.f13124a & 8) == 8, getParentForChildren(), isClean());
                this.f13129f = null;
            }
            return this.f13130g;
        }

        /* renamed from: a */
        public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (b) super.addRepeatedField(fieldDescriptor, obj);
        }

        /* renamed from: b */
        public Type build() {
            Type c10 = buildPartial();
            if (c10.isInitialized()) {
                return c10;
            }
            throw a.AbstractC0170a.newUninitializedMessageException((d0) c10);
        }

        /* renamed from: c */
        public Type buildPartial() {
            Type type = new Type(this, (a) null);
            type.name_ = this.f13125b;
            o0<Field, Field.b, s> o0Var = this.f13127d;
            if (o0Var == null) {
                if ((this.f13124a & 2) == 2) {
                    this.f13126c = Collections.unmodifiableList(this.f13126c);
                    this.f13124a &= -3;
                }
                type.fields_ = this.f13126c;
            } else {
                type.fields_ = o0Var.g();
            }
            if ((this.f13124a & 4) == 4) {
                this.f13128e = this.f13128e.u0();
                this.f13124a &= -5;
            }
            type.oneofs_ = this.f13128e;
            o0<Option, Option.b, k0> o0Var2 = this.f13130g;
            if (o0Var2 == null) {
                if ((this.f13124a & 8) == 8) {
                    this.f13129f = Collections.unmodifiableList(this.f13129f);
                    this.f13124a &= -9;
                }
                type.options_ = this.f13129f;
            } else {
                type.options_ = o0Var2.g();
            }
            q0<SourceContext, SourceContext.b, s0> q0Var = this.f13132i;
            if (q0Var == null) {
                type.sourceContext_ = this.f13131h;
            } else {
                type.sourceContext_ = q0Var.b();
            }
            type.syntax_ = this.f13133j;
            type.bitField0_ = 0;
            onBuilt();
            return type;
        }

        /* renamed from: d */
        public b clear() {
            super.clear();
            this.f13125b = "";
            o0<Field, Field.b, s> o0Var = this.f13127d;
            if (o0Var == null) {
                this.f13126c = Collections.emptyList();
                this.f13124a &= -3;
            } else {
                o0Var.h();
            }
            this.f13128e = x.f13385d;
            this.f13124a &= -5;
            o0<Option, Option.b, k0> o0Var2 = this.f13130g;
            if (o0Var2 == null) {
                this.f13129f = Collections.emptyList();
                this.f13124a &= -9;
            } else {
                o0Var2.h();
            }
            if (this.f13132i == null) {
                this.f13131h = null;
            } else {
                this.f13131h = null;
                this.f13132i = null;
            }
            this.f13133j = 0;
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
            return z0.f13390a;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.b
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return z0.f13391b.e(Type.class, b.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.f0
        public final boolean isInitialized() {
            return true;
        }

        /* renamed from: l */
        public Type getDefaultInstanceForType() {
            return Type.getDefaultInstance();
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0023  */
        /* renamed from: o */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b mergeFrom(i iVar, q qVar) throws IOException {
            Throwable th2;
            Type type = null;
            try {
                try {
                    Type type2 = (Type) Type.PARSER.parsePartialFrom(iVar, qVar);
                    if (type2 != null) {
                        q(type2);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e10) {
                    type = (Type) e10.getUnfinishedMessage();
                    try {
                        throw e10.unwrapIOException();
                    } catch (Throwable th3) {
                        th2 = th3;
                        if (type != null) {
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th4) {
                th2 = th4;
                if (type != null) {
                    q(type);
                }
                throw th2;
            }
        }

        /* renamed from: p */
        public b mergeFrom(d0 d0Var) {
            if (d0Var instanceof Type) {
                return q((Type) d0Var);
            }
            super.mergeFrom(d0Var);
            return this;
        }

        public b q(Type type) {
            if (type == Type.getDefaultInstance()) {
                return this;
            }
            if (!type.getName().isEmpty()) {
                this.f13125b = type.name_;
                onChanged();
            }
            o0<Option, Option.b, k0> o0Var = null;
            if (this.f13127d == null) {
                if (!type.fields_.isEmpty()) {
                    if (this.f13126c.isEmpty()) {
                        this.f13126c = type.fields_;
                        this.f13124a &= -3;
                    } else {
                        i();
                        this.f13126c.addAll(type.fields_);
                    }
                    onChanged();
                }
            } else if (!type.fields_.isEmpty()) {
                if (this.f13127d.u()) {
                    this.f13127d.i();
                    this.f13127d = null;
                    this.f13126c = type.fields_;
                    this.f13124a &= -3;
                    this.f13127d = GeneratedMessageV3.alwaysUseFieldBuilders ? m() : null;
                } else {
                    this.f13127d.b(type.fields_);
                }
            }
            if (!type.oneofs_.isEmpty()) {
                if (this.f13128e.isEmpty()) {
                    this.f13128e = type.oneofs_;
                    this.f13124a &= -5;
                } else {
                    j();
                    this.f13128e.addAll(type.oneofs_);
                }
                onChanged();
            }
            if (this.f13130g == null) {
                if (!type.options_.isEmpty()) {
                    if (this.f13129f.isEmpty()) {
                        this.f13129f = type.options_;
                        this.f13124a &= -9;
                    } else {
                        k();
                        this.f13129f.addAll(type.options_);
                    }
                    onChanged();
                }
            } else if (!type.options_.isEmpty()) {
                if (this.f13130g.u()) {
                    this.f13130g.i();
                    this.f13130g = null;
                    this.f13129f = type.options_;
                    this.f13124a &= -9;
                    if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                        o0Var = n();
                    }
                    this.f13130g = o0Var;
                } else {
                    this.f13130g.b(type.options_);
                }
            }
            if (type.hasSourceContext()) {
                r(type.getSourceContext());
            }
            if (type.syntax_ != 0) {
                v(type.getSyntaxValue());
            }
            onChanged();
            return this;
        }

        public b r(SourceContext sourceContext) {
            q0<SourceContext, SourceContext.b, s0> q0Var = this.f13132i;
            if (q0Var == null) {
                SourceContext sourceContext2 = this.f13131h;
                if (sourceContext2 != null) {
                    this.f13131h = SourceContext.newBuilder(sourceContext2).l(sourceContext).buildPartial();
                } else {
                    this.f13131h = sourceContext;
                }
                onChanged();
            } else {
                q0Var.h(sourceContext);
            }
            return this;
        }

        /* renamed from: s */
        public final b mergeUnknownFields(a1 a1Var) {
            return this;
        }

        /* renamed from: t */
        public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (b) super.setField(fieldDescriptor, obj);
        }

        /* renamed from: u */
        public b setRepeatedField2(Descriptors.FieldDescriptor fieldDescriptor, int i10, Object obj) {
            return (b) super.setRepeatedField(fieldDescriptor, i10, obj);
        }

        public b v(int i10) {
            this.f13133j = i10;
            onChanged();
            return this;
        }

        /* renamed from: w */
        public final b setUnknownFields(a1 a1Var) {
            return this;
        }

        /* synthetic */ b(a aVar) {
            this();
        }

        private b() {
            this.f13125b = "";
            this.f13126c = Collections.emptyList();
            this.f13128e = x.f13385d;
            this.f13129f = Collections.emptyList();
            this.f13131h = null;
            this.f13133j = 0;
            maybeForceBuilderInitialization();
        }

        private b(GeneratedMessageV3.c cVar) {
            super(cVar);
            this.f13125b = "";
            this.f13126c = Collections.emptyList();
            this.f13128e = x.f13385d;
            this.f13129f = Collections.emptyList();
            this.f13131h = null;
            this.f13133j = 0;
            maybeForceBuilderInitialization();
        }
    }

    /* synthetic */ Type(i iVar, q qVar, a aVar) throws InvalidProtocolBufferException {
        this(iVar, qVar);
    }

    public static Type getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.b getDescriptor() {
        return z0.f13390a;
    }

    public static b newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Type parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Type) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Type parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static l0<Type> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.a
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Type)) {
            return super.equals(obj);
        }
        Type type = (Type) obj;
        boolean z10 = ((((getName().equals(type.getName())) && getFieldsList().equals(type.getFieldsList())) && getOneofsList().equals(type.getOneofsList())) && getOptionsList().equals(type.getOptionsList())) && hasSourceContext() == type.hasSourceContext();
        if (hasSourceContext()) {
            z10 = z10 && getSourceContext().equals(type.getSourceContext());
        }
        return z10 && this.syntax_ == type.syntax_;
    }

    public Field getFields(int i10) {
        return this.fields_.get(i10);
    }

    public int getFieldsCount() {
        return this.fields_.size();
    }

    public List<Field> getFieldsList() {
        return this.fields_;
    }

    public s getFieldsOrBuilder(int i10) {
        return this.fields_.get(i10);
    }

    public List<? extends s> getFieldsOrBuilderList() {
        return this.fields_;
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

    public String getOneofs(int i10) {
        return this.oneofs_.get(i10);
    }

    public ByteString getOneofsBytes(int i10) {
        return this.oneofs_.o0(i10);
    }

    public int getOneofsCount() {
        return this.oneofs_.size();
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
    public l0<Type> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
    public int getSerializedSize() {
        int i10 = this.memoizedSize;
        if (i10 != -1) {
            return i10;
        }
        int computeStringSize = !getNameBytes().isEmpty() ? GeneratedMessageV3.computeStringSize(1, this.name_) + 0 : 0;
        for (int i11 = 0; i11 < this.fields_.size(); i11++) {
            computeStringSize += CodedOutputStream.E(2, this.fields_.get(i11));
        }
        int i12 = 0;
        for (int i13 = 0; i13 < this.oneofs_.size(); i13++) {
            i12 += GeneratedMessageV3.computeStringSizeNoTag(this.oneofs_.z0(i13));
        }
        int size = computeStringSize + i12 + (getOneofsList().size() * 1);
        for (int i14 = 0; i14 < this.options_.size(); i14++) {
            size += CodedOutputStream.E(4, this.options_.get(i14));
        }
        if (this.sourceContext_ != null) {
            size += CodedOutputStream.E(5, getSourceContext());
        }
        if (this.syntax_ != Syntax.SYNTAX_PROTO2.getNumber()) {
            size += CodedOutputStream.l(6, this.syntax_);
        }
        this.memoizedSize = size;
        return size;
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
        if (getFieldsCount() > 0) {
            hashCode = (((hashCode * 37) + 2) * 53) + getFieldsList().hashCode();
        }
        if (getOneofsCount() > 0) {
            hashCode = (((hashCode * 37) + 3) * 53) + getOneofsList().hashCode();
        }
        if (getOptionsCount() > 0) {
            hashCode = (((hashCode * 37) + 4) * 53) + getOptionsList().hashCode();
        }
        if (hasSourceContext()) {
            hashCode = (((hashCode * 37) + 5) * 53) + getSourceContext().hashCode();
        }
        int hashCode2 = (((((hashCode * 37) + 6) * 53) + this.syntax_) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode2;
        return hashCode2;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
        return z0.f13391b.e(Type.class, b.class);
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
    /* renamed from: o */
    public b newBuilderForType(GeneratedMessageV3.c cVar) {
        return new b(cVar, null);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (!getNameBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 1, this.name_);
        }
        for (int i10 = 0; i10 < this.fields_.size(); i10++) {
            codedOutputStream.A0(2, this.fields_.get(i10));
        }
        for (int i11 = 0; i11 < this.oneofs_.size(); i11++) {
            GeneratedMessageV3.writeString(codedOutputStream, 3, this.oneofs_.z0(i11));
        }
        for (int i12 = 0; i12 < this.options_.size(); i12++) {
            codedOutputStream.A0(4, this.options_.get(i12));
        }
        if (this.sourceContext_ != null) {
            codedOutputStream.A0(5, getSourceContext());
        }
        if (this.syntax_ != Syntax.SYNTAX_PROTO2.getNumber()) {
            codedOutputStream.m0(6, this.syntax_);
        }
    }

    /* synthetic */ Type(GeneratedMessageV3.b bVar, a aVar) {
        this(bVar);
    }

    public static b newBuilder(Type type) {
        return DEFAULT_INSTANCE.toBuilder().q(type);
    }

    public static Type parseFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, qVar);
    }

    public n0 getOneofsList() {
        return this.oneofs_;
    }

    private Type(GeneratedMessageV3.b<?> bVar) {
        super(bVar);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static Type parseDelimitedFrom(InputStream inputStream, q qVar) throws IOException {
        return (Type) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
    }

    public static Type parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
    public Type getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
    public b toBuilder() {
        return this == DEFAULT_INSTANCE ? new b((a) null) : new b((a) null).q(this);
    }

    public static Type parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, qVar);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
    public b newBuilderForType() {
        return newBuilder();
    }

    private Type() {
        this.memoizedIsInitialized = (byte) -1;
        this.name_ = "";
        this.fields_ = Collections.emptyList();
        this.oneofs_ = x.f13385d;
        this.options_ = Collections.emptyList();
        this.syntax_ = 0;
    }

    public static Type parseFrom(InputStream inputStream) throws IOException {
        return (Type) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static Type parseFrom(InputStream inputStream, q qVar) throws IOException {
        return (Type) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
    }

    public static Type parseFrom(i iVar) throws IOException {
        return (Type) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
    }

    public static Type parseFrom(i iVar, q qVar) throws IOException {
        return (Type) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Type(i iVar, q qVar) throws InvalidProtocolBufferException {
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
                                    this.fields_ = new ArrayList();
                                    z11 |= true;
                                }
                                this.fields_.add(iVar.v(Field.parser(), qVar));
                            } else if (F == 26) {
                                String E = iVar.E();
                                if (!(z11 & true)) {
                                    this.oneofs_ = new x();
                                    z11 |= true;
                                }
                                this.oneofs_.add(E);
                            } else if (F == 34) {
                                if (!(z11 & true)) {
                                    this.options_ = new ArrayList();
                                    z11 |= true;
                                }
                                this.options_.add(iVar.v(Option.parser(), qVar));
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
                            } else if (F == 48) {
                                this.syntax_ = iVar.o();
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
                if (z11 & true) {
                    this.fields_ = Collections.unmodifiableList(this.fields_);
                }
                if (z11 & true) {
                    this.oneofs_ = this.oneofs_.u0();
                }
                if (z11 & true) {
                    this.options_ = Collections.unmodifiableList(this.options_);
                }
                makeExtensionsImmutable();
            }
        }
    }
}
