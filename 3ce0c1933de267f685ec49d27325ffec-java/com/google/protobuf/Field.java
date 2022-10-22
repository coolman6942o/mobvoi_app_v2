package com.google.protobuf;

import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Option;
import com.google.protobuf.a;
import com.google.protobuf.u;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public final class Field extends GeneratedMessageV3 implements s {
    public static final int CARDINALITY_FIELD_NUMBER = 2;
    public static final int DEFAULT_VALUE_FIELD_NUMBER = 11;
    public static final int JSON_NAME_FIELD_NUMBER = 10;
    public static final int KIND_FIELD_NUMBER = 1;
    public static final int NAME_FIELD_NUMBER = 4;
    public static final int NUMBER_FIELD_NUMBER = 3;
    public static final int ONEOF_INDEX_FIELD_NUMBER = 7;
    public static final int OPTIONS_FIELD_NUMBER = 9;
    public static final int PACKED_FIELD_NUMBER = 8;
    public static final int TYPE_URL_FIELD_NUMBER = 6;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private int cardinality_;
    private volatile Object defaultValue_;
    private volatile Object jsonName_;
    private int kind_;
    private byte memoizedIsInitialized;
    private volatile Object name_;
    private int number_;
    private int oneofIndex_;
    private List<Option> options_;
    private boolean packed_;
    private volatile Object typeUrl_;
    private static final Field DEFAULT_INSTANCE = new Field();
    private static final l0<Field> PARSER = new a();

    /* loaded from: classes.dex */
    public enum Cardinality implements m0 {
        CARDINALITY_UNKNOWN(0),
        CARDINALITY_OPTIONAL(1),
        CARDINALITY_REQUIRED(2),
        CARDINALITY_REPEATED(3),
        UNRECOGNIZED(-1);
        
        public static final int CARDINALITY_OPTIONAL_VALUE = 1;
        public static final int CARDINALITY_REPEATED_VALUE = 3;
        public static final int CARDINALITY_REQUIRED_VALUE = 2;
        public static final int CARDINALITY_UNKNOWN_VALUE = 0;
        private final int value;
        private static final u.b<Cardinality> internalValueMap = new a();
        private static final Cardinality[] VALUES = values();

        /* loaded from: classes.dex */
        static class a implements u.b<Cardinality> {
            a() {
            }
        }

        Cardinality(int i10) {
            this.value = i10;
        }

        public static Cardinality forNumber(int i10) {
            if (i10 == 0) {
                return CARDINALITY_UNKNOWN;
            }
            if (i10 == 1) {
                return CARDINALITY_OPTIONAL;
            }
            if (i10 == 2) {
                return CARDINALITY_REQUIRED;
            }
            if (i10 != 3) {
                return null;
            }
            return CARDINALITY_REPEATED;
        }

        public static final Descriptors.d getDescriptor() {
            return Field.getDescriptor().j().get(1);
        }

        public static u.b<Cardinality> internalGetValueMap() {
            return internalValueMap;
        }

        public final Descriptors.d getDescriptorForType() {
            return getDescriptor();
        }

        @Override // com.google.protobuf.u.a
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        public final Descriptors.e getValueDescriptor() {
            return getDescriptor().i().get(ordinal());
        }

        @Deprecated
        public static Cardinality valueOf(int i10) {
            return forNumber(i10);
        }

        public static Cardinality valueOf(Descriptors.e eVar) {
            if (eVar.g() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            } else if (eVar.f() == -1) {
                return UNRECOGNIZED;
            } else {
                return VALUES[eVar.f()];
            }
        }
    }

    /* loaded from: classes.dex */
    public enum Kind implements m0 {
        TYPE_UNKNOWN(0),
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
        TYPE_SINT64(18),
        UNRECOGNIZED(-1);
        
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
        public static final int TYPE_UNKNOWN_VALUE = 0;
        private final int value;
        private static final u.b<Kind> internalValueMap = new a();
        private static final Kind[] VALUES = values();

        /* loaded from: classes.dex */
        static class a implements u.b<Kind> {
            a() {
            }
        }

        Kind(int i10) {
            this.value = i10;
        }

        public static Kind forNumber(int i10) {
            switch (i10) {
                case 0:
                    return TYPE_UNKNOWN;
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
            return Field.getDescriptor().j().get(0);
        }

        public static u.b<Kind> internalGetValueMap() {
            return internalValueMap;
        }

        public final Descriptors.d getDescriptorForType() {
            return getDescriptor();
        }

        @Override // com.google.protobuf.u.a
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        public final Descriptors.e getValueDescriptor() {
            return getDescriptor().i().get(ordinal());
        }

        @Deprecated
        public static Kind valueOf(int i10) {
            return forNumber(i10);
        }

        public static Kind valueOf(Descriptors.e eVar) {
            if (eVar.g() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            } else if (eVar.f() == -1) {
                return UNRECOGNIZED;
            } else {
                return VALUES[eVar.f()];
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a extends c<Field> {
        a() {
        }

        /* renamed from: a */
        public Field parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
            return new Field(iVar, qVar, null);
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends GeneratedMessageV3.b<b> implements s {

        /* renamed from: a  reason: collision with root package name */
        private int f12996a;

        /* renamed from: b  reason: collision with root package name */
        private int f12997b;

        /* renamed from: c  reason: collision with root package name */
        private int f12998c;

        /* renamed from: d  reason: collision with root package name */
        private int f12999d;

        /* renamed from: e  reason: collision with root package name */
        private Object f13000e;

        /* renamed from: f  reason: collision with root package name */
        private Object f13001f;

        /* renamed from: g  reason: collision with root package name */
        private int f13002g;

        /* renamed from: h  reason: collision with root package name */
        private boolean f13003h;

        /* renamed from: i  reason: collision with root package name */
        private List<Option> f13004i;

        /* renamed from: j  reason: collision with root package name */
        private o0<Option, Option.b, k0> f13005j;

        /* renamed from: k  reason: collision with root package name */
        private Object f13006k;

        /* renamed from: l  reason: collision with root package name */
        private Object f13007l;

        /* synthetic */ b(a aVar) {
            this();
        }

        private void i() {
            if ((this.f12996a & 128) != 128) {
                this.f13004i = new ArrayList(this.f13004i);
                this.f12996a |= 128;
            }
        }

        private o0<Option, Option.b, k0> k() {
            if (this.f13005j == null) {
                this.f13005j = new o0<>(this.f13004i, (this.f12996a & 128) == 128, getParentForChildren(), isClean());
                this.f13004i = null;
            }
            return this.f13005j;
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
        public Field build() {
            Field c10 = buildPartial();
            if (c10.isInitialized()) {
                return c10;
            }
            throw a.AbstractC0170a.newUninitializedMessageException((d0) c10);
        }

        /* renamed from: c */
        public Field buildPartial() {
            Field field = new Field(this, (a) null);
            field.kind_ = this.f12997b;
            field.cardinality_ = this.f12998c;
            field.number_ = this.f12999d;
            field.name_ = this.f13000e;
            field.typeUrl_ = this.f13001f;
            field.oneofIndex_ = this.f13002g;
            field.packed_ = this.f13003h;
            o0<Option, Option.b, k0> o0Var = this.f13005j;
            if (o0Var == null) {
                if ((this.f12996a & 128) == 128) {
                    this.f13004i = Collections.unmodifiableList(this.f13004i);
                    this.f12996a &= -129;
                }
                field.options_ = this.f13004i;
            } else {
                field.options_ = o0Var.g();
            }
            field.jsonName_ = this.f13006k;
            field.defaultValue_ = this.f13007l;
            field.bitField0_ = 0;
            onBuilt();
            return field;
        }

        /* renamed from: d */
        public b clear() {
            super.clear();
            this.f12997b = 0;
            this.f12998c = 0;
            this.f12999d = 0;
            this.f13000e = "";
            this.f13001f = "";
            this.f13002g = 0;
            this.f13003h = false;
            o0<Option, Option.b, k0> o0Var = this.f13005j;
            if (o0Var == null) {
                this.f13004i = Collections.emptyList();
                this.f12996a &= -129;
            } else {
                o0Var.h();
            }
            this.f13006k = "";
            this.f13007l = "";
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
            return z0.f13392c;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.b
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return z0.f13393d.e(Field.class, b.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.f0
        public final boolean isInitialized() {
            return true;
        }

        /* renamed from: j */
        public Field getDefaultInstanceForType() {
            return Field.getDefaultInstance();
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0023  */
        /* renamed from: l */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b mergeFrom(i iVar, q qVar) throws IOException {
            Throwable th2;
            Field field = null;
            try {
                try {
                    Field field2 = (Field) Field.PARSER.parsePartialFrom(iVar, qVar);
                    if (field2 != null) {
                        m(field2);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e10) {
                    field = (Field) e10.getUnfinishedMessage();
                    try {
                        throw e10.unwrapIOException();
                    } catch (Throwable th3) {
                        th2 = th3;
                        if (field != null) {
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th4) {
                th2 = th4;
                if (field != null) {
                    m(field);
                }
                throw th2;
            }
        }

        public b m(Field field) {
            if (field == Field.getDefaultInstance()) {
                return this;
            }
            if (field.kind_ != 0) {
                r(field.getKindValue());
            }
            if (field.cardinality_ != 0) {
                p(field.getCardinalityValue());
            }
            if (field.getNumber() != 0) {
                s(field.getNumber());
            }
            if (!field.getName().isEmpty()) {
                this.f13000e = field.name_;
                onChanged();
            }
            if (!field.getTypeUrl().isEmpty()) {
                this.f13001f = field.typeUrl_;
                onChanged();
            }
            if (field.getOneofIndex() != 0) {
                t(field.getOneofIndex());
            }
            if (field.getPacked()) {
                u(field.getPacked());
            }
            if (this.f13005j == null) {
                if (!field.options_.isEmpty()) {
                    if (this.f13004i.isEmpty()) {
                        this.f13004i = field.options_;
                        this.f12996a &= -129;
                    } else {
                        i();
                        this.f13004i.addAll(field.options_);
                    }
                    onChanged();
                }
            } else if (!field.options_.isEmpty()) {
                if (this.f13005j.u()) {
                    this.f13005j.i();
                    o0<Option, Option.b, k0> o0Var = null;
                    this.f13005j = null;
                    this.f13004i = field.options_;
                    this.f12996a &= -129;
                    if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                        o0Var = k();
                    }
                    this.f13005j = o0Var;
                } else {
                    this.f13005j.b(field.options_);
                }
            }
            if (!field.getJsonName().isEmpty()) {
                this.f13006k = field.jsonName_;
                onChanged();
            }
            if (!field.getDefaultValue().isEmpty()) {
                this.f13007l = field.defaultValue_;
                onChanged();
            }
            onChanged();
            return this;
        }

        /* renamed from: n */
        public b mergeFrom(d0 d0Var) {
            if (d0Var instanceof Field) {
                return m((Field) d0Var);
            }
            super.mergeFrom(d0Var);
            return this;
        }

        /* renamed from: o */
        public final b mergeUnknownFields(a1 a1Var) {
            return this;
        }

        public b p(int i10) {
            this.f12998c = i10;
            onChanged();
            return this;
        }

        /* renamed from: q */
        public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (b) super.setField(fieldDescriptor, obj);
        }

        public b r(int i10) {
            this.f12997b = i10;
            onChanged();
            return this;
        }

        public b s(int i10) {
            this.f12999d = i10;
            onChanged();
            return this;
        }

        public b t(int i10) {
            this.f13002g = i10;
            onChanged();
            return this;
        }

        public b u(boolean z10) {
            this.f13003h = z10;
            onChanged();
            return this;
        }

        /* renamed from: v */
        public b setRepeatedField2(Descriptors.FieldDescriptor fieldDescriptor, int i10, Object obj) {
            return (b) super.setRepeatedField(fieldDescriptor, i10, obj);
        }

        /* renamed from: w */
        public final b setUnknownFields(a1 a1Var) {
            return this;
        }

        /* synthetic */ b(GeneratedMessageV3.c cVar, a aVar) {
            this(cVar);
        }

        private b() {
            this.f12997b = 0;
            this.f12998c = 0;
            this.f13000e = "";
            this.f13001f = "";
            this.f13004i = Collections.emptyList();
            this.f13006k = "";
            this.f13007l = "";
            maybeForceBuilderInitialization();
        }

        private b(GeneratedMessageV3.c cVar) {
            super(cVar);
            this.f12997b = 0;
            this.f12998c = 0;
            this.f13000e = "";
            this.f13001f = "";
            this.f13004i = Collections.emptyList();
            this.f13006k = "";
            this.f13007l = "";
            maybeForceBuilderInitialization();
        }
    }

    /* synthetic */ Field(i iVar, q qVar, a aVar) throws InvalidProtocolBufferException {
        this(iVar, qVar);
    }

    public static Field getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.b getDescriptor() {
        return z0.f13392c;
    }

    public static b newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Field parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Field) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Field parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static l0<Field> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.a
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Field)) {
            return super.equals(obj);
        }
        Field field = (Field) obj;
        return (((((((((this.kind_ == field.kind_) && this.cardinality_ == field.cardinality_) && getNumber() == field.getNumber()) && getName().equals(field.getName())) && getTypeUrl().equals(field.getTypeUrl())) && getOneofIndex() == field.getOneofIndex()) && getPacked() == field.getPacked()) && getOptionsList().equals(field.getOptionsList())) && getJsonName().equals(field.getJsonName())) && getDefaultValue().equals(field.getDefaultValue());
    }

    public Cardinality getCardinality() {
        Cardinality valueOf = Cardinality.valueOf(this.cardinality_);
        return valueOf == null ? Cardinality.UNRECOGNIZED : valueOf;
    }

    public int getCardinalityValue() {
        return this.cardinality_;
    }

    public String getDefaultValue() {
        Object obj = this.defaultValue_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.defaultValue_ = stringUtf8;
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

    public String getJsonName() {
        Object obj = this.jsonName_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.jsonName_ = stringUtf8;
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

    public Kind getKind() {
        Kind valueOf = Kind.valueOf(this.kind_);
        return valueOf == null ? Kind.UNRECOGNIZED : valueOf;
    }

    public int getKindValue() {
        return this.kind_;
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

    public int getOneofIndex() {
        return this.oneofIndex_;
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

    public boolean getPacked() {
        return this.packed_;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
    public l0<Field> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
    public int getSerializedSize() {
        int i10 = this.memoizedSize;
        if (i10 != -1) {
            return i10;
        }
        int l10 = this.kind_ != Kind.TYPE_UNKNOWN.getNumber() ? CodedOutputStream.l(1, this.kind_) + 0 : 0;
        if (this.cardinality_ != Cardinality.CARDINALITY_UNKNOWN.getNumber()) {
            l10 += CodedOutputStream.l(2, this.cardinality_);
        }
        int i11 = this.number_;
        if (i11 != 0) {
            l10 += CodedOutputStream.v(3, i11);
        }
        if (!getNameBytes().isEmpty()) {
            l10 += GeneratedMessageV3.computeStringSize(4, this.name_);
        }
        if (!getTypeUrlBytes().isEmpty()) {
            l10 += GeneratedMessageV3.computeStringSize(6, this.typeUrl_);
        }
        int i12 = this.oneofIndex_;
        if (i12 != 0) {
            l10 += CodedOutputStream.v(7, i12);
        }
        boolean z10 = this.packed_;
        if (z10) {
            l10 += CodedOutputStream.e(8, z10);
        }
        for (int i13 = 0; i13 < this.options_.size(); i13++) {
            l10 += CodedOutputStream.E(9, this.options_.get(i13));
        }
        if (!getJsonNameBytes().isEmpty()) {
            l10 += GeneratedMessageV3.computeStringSize(10, this.jsonName_);
        }
        if (!getDefaultValueBytes().isEmpty()) {
            l10 += GeneratedMessageV3.computeStringSize(11, this.defaultValue_);
        }
        this.memoizedSize = l10;
        return l10;
    }

    public String getTypeUrl() {
        Object obj = this.typeUrl_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.typeUrl_ = stringUtf8;
        return stringUtf8;
    }

    public ByteString getTypeUrlBytes() {
        Object obj = this.typeUrl_;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.typeUrl_ = copyFromUtf8;
        return copyFromUtf8;
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
        int hashCode = ((((((((((((((((((((((((((((779 + getDescriptorForType().hashCode()) * 37) + 1) * 53) + this.kind_) * 37) + 2) * 53) + this.cardinality_) * 37) + 3) * 53) + getNumber()) * 37) + 4) * 53) + getName().hashCode()) * 37) + 6) * 53) + getTypeUrl().hashCode()) * 37) + 7) * 53) + getOneofIndex()) * 37) + 8) * 53) + u.c(getPacked());
        if (getOptionsCount() > 0) {
            hashCode = (((hashCode * 37) + 9) * 53) + getOptionsList().hashCode();
        }
        int hashCode2 = (((((((((hashCode * 37) + 10) * 53) + getJsonName().hashCode()) * 37) + 11) * 53) + getDefaultValue().hashCode()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode2;
        return hashCode2;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
        return z0.f13393d.e(Field.class, b.class);
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
    /* renamed from: v */
    public b newBuilderForType(GeneratedMessageV3.c cVar) {
        return new b(cVar, null);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (this.kind_ != Kind.TYPE_UNKNOWN.getNumber()) {
            codedOutputStream.m0(1, this.kind_);
        }
        if (this.cardinality_ != Cardinality.CARDINALITY_UNKNOWN.getNumber()) {
            codedOutputStream.m0(2, this.cardinality_);
        }
        int i10 = this.number_;
        if (i10 != 0) {
            codedOutputStream.w0(3, i10);
        }
        if (!getNameBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 4, this.name_);
        }
        if (!getTypeUrlBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 6, this.typeUrl_);
        }
        int i11 = this.oneofIndex_;
        if (i11 != 0) {
            codedOutputStream.w0(7, i11);
        }
        boolean z10 = this.packed_;
        if (z10) {
            codedOutputStream.e0(8, z10);
        }
        for (int i12 = 0; i12 < this.options_.size(); i12++) {
            codedOutputStream.A0(9, this.options_.get(i12));
        }
        if (!getJsonNameBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 10, this.jsonName_);
        }
        if (!getDefaultValueBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 11, this.defaultValue_);
        }
    }

    /* synthetic */ Field(GeneratedMessageV3.b bVar, a aVar) {
        this(bVar);
    }

    public static b newBuilder(Field field) {
        return DEFAULT_INSTANCE.toBuilder().m(field);
    }

    public static Field parseFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, qVar);
    }

    private Field(GeneratedMessageV3.b<?> bVar) {
        super(bVar);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static Field parseDelimitedFrom(InputStream inputStream, q qVar) throws IOException {
        return (Field) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
    }

    public static Field parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
    public Field getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
    public b toBuilder() {
        return this == DEFAULT_INSTANCE ? new b((a) null) : new b((a) null).m(this);
    }

    public static Field parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, qVar);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
    public b newBuilderForType() {
        return newBuilder();
    }

    private Field() {
        this.memoizedIsInitialized = (byte) -1;
        this.kind_ = 0;
        this.cardinality_ = 0;
        this.number_ = 0;
        this.name_ = "";
        this.typeUrl_ = "";
        this.oneofIndex_ = 0;
        this.packed_ = false;
        this.options_ = Collections.emptyList();
        this.jsonName_ = "";
        this.defaultValue_ = "";
    }

    public static Field parseFrom(InputStream inputStream) throws IOException {
        return (Field) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static Field parseFrom(InputStream inputStream, q qVar) throws IOException {
        return (Field) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
    }

    public static Field parseFrom(i iVar) throws IOException {
        return (Field) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
    }

    public static Field parseFrom(i iVar, q qVar) throws IOException {
        return (Field) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [boolean] */
    private Field(i iVar, q qVar) throws InvalidProtocolBufferException {
        this();
        boolean z10 = false;
        boolean z11 = false;
        while (true) {
            ?? r22 = 128;
            if (!z10) {
                try {
                    try {
                        int F = iVar.F();
                        z10 = true;
                        switch (F) {
                            case 0:
                                break;
                            case 8:
                                this.kind_ = iVar.o();
                                continue;
                            case 16:
                                this.cardinality_ = iVar.o();
                                continue;
                            case 24:
                                this.number_ = iVar.t();
                                continue;
                            case 34:
                                this.name_ = iVar.E();
                                continue;
                            case 50:
                                this.typeUrl_ = iVar.E();
                                continue;
                            case 56:
                                this.oneofIndex_ = iVar.t();
                                continue;
                            case 64:
                                this.packed_ = iVar.l();
                                continue;
                            case 74:
                                if (!(z11 & true)) {
                                    this.options_ = new ArrayList();
                                    z11 |= true;
                                }
                                this.options_.add(iVar.v(Option.parser(), qVar));
                                continue;
                            case 82:
                                this.jsonName_ = iVar.E();
                                continue;
                            case 90:
                                this.defaultValue_ = iVar.E();
                                continue;
                            default:
                                r22 = iVar.I(F);
                                if (r22 == 0) {
                                    break;
                                } else {
                                    continue;
                                }
                        }
                    } catch (InvalidProtocolBufferException e10) {
                        throw e10.setUnfinishedMessage(this);
                    } catch (IOException e11) {
                        throw new InvalidProtocolBufferException(e11).setUnfinishedMessage(this);
                    }
                } finally {
                    if ((z11 & true) == r22) {
                        this.options_ = Collections.unmodifiableList(this.options_);
                    }
                    makeExtensionsImmutable();
                }
            } else {
                return;
            }
        }
    }
}
