package com.google.protobuf;

import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.ListValue;
import com.google.protobuf.Struct;
import com.google.protobuf.a;
import com.google.protobuf.u;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes.dex */
public final class Value extends GeneratedMessageV3 implements e1 {
    public static final int BOOL_VALUE_FIELD_NUMBER = 4;
    public static final int LIST_VALUE_FIELD_NUMBER = 6;
    public static final int NULL_VALUE_FIELD_NUMBER = 1;
    public static final int NUMBER_VALUE_FIELD_NUMBER = 2;
    public static final int STRING_VALUE_FIELD_NUMBER = 3;
    public static final int STRUCT_VALUE_FIELD_NUMBER = 5;
    private static final long serialVersionUID = 0;
    private int kindCase_;
    private Object kind_;
    private byte memoizedIsInitialized;
    private static final Value DEFAULT_INSTANCE = new Value();
    private static final l0<Value> PARSER = new a();

    /* loaded from: classes.dex */
    public enum KindCase implements u.a {
        NULL_VALUE(1),
        NUMBER_VALUE(2),
        STRING_VALUE(3),
        BOOL_VALUE(4),
        STRUCT_VALUE(5),
        LIST_VALUE(6),
        KIND_NOT_SET(0);
        
        private final int value;

        KindCase(int i10) {
            this.value = i10;
        }

        public static KindCase forNumber(int i10) {
            switch (i10) {
                case 0:
                    return KIND_NOT_SET;
                case 1:
                    return NULL_VALUE;
                case 2:
                    return NUMBER_VALUE;
                case 3:
                    return STRING_VALUE;
                case 4:
                    return BOOL_VALUE;
                case 5:
                    return STRUCT_VALUE;
                case 6:
                    return LIST_VALUE;
                default:
                    return null;
            }
        }

        @Override // com.google.protobuf.u.a
        public int getNumber() {
            return this.value;
        }

        @Deprecated
        public static KindCase valueOf(int i10) {
            return forNumber(i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a extends com.google.protobuf.c<Value> {
        a() {
        }

        /* renamed from: a */
        public Value parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
            return new Value(iVar, qVar, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f13136a;

        static {
            int[] iArr = new int[KindCase.values().length];
            f13136a = iArr;
            try {
                iArr[KindCase.NULL_VALUE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f13136a[KindCase.NUMBER_VALUE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f13136a[KindCase.STRING_VALUE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f13136a[KindCase.BOOL_VALUE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f13136a[KindCase.STRUCT_VALUE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f13136a[KindCase.LIST_VALUE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f13136a[KindCase.KIND_NOT_SET.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class c extends GeneratedMessageV3.b<c> implements e1 {

        /* renamed from: a  reason: collision with root package name */
        private int f13137a;

        /* renamed from: b  reason: collision with root package name */
        private Object f13138b;

        /* renamed from: c  reason: collision with root package name */
        private q0<Struct, Struct.b, u0> f13139c;

        /* renamed from: d  reason: collision with root package name */
        private q0<ListValue, ListValue.b, z> f13140d;

        /* synthetic */ c(GeneratedMessageV3.c cVar, a aVar) {
            this(cVar);
        }

        private void maybeForceBuilderInitialization() {
            boolean z10 = GeneratedMessageV3.alwaysUseFieldBuilders;
        }

        /* renamed from: a */
        public c addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (c) super.addRepeatedField(fieldDescriptor, obj);
        }

        /* renamed from: b */
        public Value build() {
            Value c10 = buildPartial();
            if (c10.isInitialized()) {
                return c10;
            }
            throw a.AbstractC0170a.newUninitializedMessageException((d0) c10);
        }

        /* renamed from: c */
        public Value buildPartial() {
            Value value = new Value(this, (a) null);
            if (this.f13137a == 1) {
                value.kind_ = this.f13138b;
            }
            if (this.f13137a == 2) {
                value.kind_ = this.f13138b;
            }
            if (this.f13137a == 3) {
                value.kind_ = this.f13138b;
            }
            if (this.f13137a == 4) {
                value.kind_ = this.f13138b;
            }
            if (this.f13137a == 5) {
                q0<Struct, Struct.b, u0> q0Var = this.f13139c;
                if (q0Var == null) {
                    value.kind_ = this.f13138b;
                } else {
                    value.kind_ = q0Var.b();
                }
            }
            if (this.f13137a == 6) {
                q0<ListValue, ListValue.b, z> q0Var2 = this.f13140d;
                if (q0Var2 == null) {
                    value.kind_ = this.f13138b;
                } else {
                    value.kind_ = q0Var2.b();
                }
            }
            value.kindCase_ = this.f13137a;
            onBuilt();
            return value;
        }

        /* renamed from: d */
        public c clear() {
            super.clear();
            this.f13137a = 0;
            this.f13138b = null;
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
            return v0.f13373d;
        }

        /* renamed from: i */
        public Value getDefaultInstanceForType() {
            return Value.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.b
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return v0.f13374e.e(Value.class, c.class);
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
        public c mergeFrom(i iVar, q qVar) throws IOException {
            Throwable th2;
            Value value = null;
            try {
                try {
                    Value value2 = (Value) Value.PARSER.parsePartialFrom(iVar, qVar);
                    if (value2 != null) {
                        l(value2);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e10) {
                    value = (Value) e10.getUnfinishedMessage();
                    try {
                        throw e10.unwrapIOException();
                    } catch (Throwable th3) {
                        th2 = th3;
                        if (value != null) {
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th4) {
                th2 = th4;
                if (value != null) {
                    l(value);
                }
                throw th2;
            }
        }

        /* renamed from: k */
        public c mergeFrom(d0 d0Var) {
            if (d0Var instanceof Value) {
                return l((Value) d0Var);
            }
            super.mergeFrom(d0Var);
            return this;
        }

        public c l(Value value) {
            if (value == Value.getDefaultInstance()) {
                return this;
            }
            switch (b.f13136a[value.getKindCase().ordinal()]) {
                case 1:
                    r(value.getNullValueValue());
                    break;
                case 2:
                    s(value.getNumberValue());
                    break;
                case 3:
                    this.f13137a = 3;
                    this.f13138b = value.kind_;
                    onChanged();
                    break;
                case 4:
                    p(value.getBoolValue());
                    break;
                case 5:
                    n(value.getStructValue());
                    break;
                case 6:
                    m(value.getListValue());
                    break;
            }
            onChanged();
            return this;
        }

        public c m(ListValue listValue) {
            q0<ListValue, ListValue.b, z> q0Var = this.f13140d;
            if (q0Var == null) {
                if (this.f13137a != 6 || this.f13138b == ListValue.getDefaultInstance()) {
                    this.f13138b = listValue;
                } else {
                    this.f13138b = ListValue.newBuilder((ListValue) this.f13138b).m(listValue).buildPartial();
                }
                onChanged();
            } else {
                if (this.f13137a == 6) {
                    q0Var.h(listValue);
                }
                this.f13140d.j(listValue);
            }
            this.f13137a = 6;
            return this;
        }

        public c n(Struct struct) {
            q0<Struct, Struct.b, u0> q0Var = this.f13139c;
            if (q0Var == null) {
                if (this.f13137a != 5 || this.f13138b == Struct.getDefaultInstance()) {
                    this.f13138b = struct;
                } else {
                    this.f13138b = Struct.newBuilder((Struct) this.f13138b).n(struct).buildPartial();
                }
                onChanged();
            } else {
                if (this.f13137a == 5) {
                    q0Var.h(struct);
                }
                this.f13139c.j(struct);
            }
            this.f13137a = 5;
            return this;
        }

        /* renamed from: o */
        public final c mergeUnknownFields(a1 a1Var) {
            return this;
        }

        public c p(boolean z10) {
            this.f13137a = 4;
            this.f13138b = Boolean.valueOf(z10);
            onChanged();
            return this;
        }

        /* renamed from: q */
        public c setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (c) super.setField(fieldDescriptor, obj);
        }

        public c r(int i10) {
            this.f13137a = 1;
            this.f13138b = Integer.valueOf(i10);
            onChanged();
            return this;
        }

        public c s(double d10) {
            this.f13137a = 2;
            this.f13138b = Double.valueOf(d10);
            onChanged();
            return this;
        }

        /* renamed from: t */
        public c setRepeatedField2(Descriptors.FieldDescriptor fieldDescriptor, int i10, Object obj) {
            return (c) super.setRepeatedField(fieldDescriptor, i10, obj);
        }

        /* renamed from: u */
        public final c setUnknownFields(a1 a1Var) {
            return this;
        }

        /* synthetic */ c(a aVar) {
            this();
        }

        private c() {
            this.f13137a = 0;
            maybeForceBuilderInitialization();
        }

        private c(GeneratedMessageV3.c cVar) {
            super(cVar);
            this.f13137a = 0;
            maybeForceBuilderInitialization();
        }
    }

    /* synthetic */ Value(i iVar, q qVar, a aVar) throws InvalidProtocolBufferException {
        this(iVar, qVar);
    }

    public static Value getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.b getDescriptor() {
        return v0.f13373d;
    }

    public static c newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Value parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Value) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Value parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static l0<Value> parser() {
        return PARSER;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0039, code lost:
        if (getListValue().equals(r8.getListValue()) != false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004a, code lost:
        if (getStructValue().equals(r8.getStructValue()) != false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0057, code lost:
        if (getBoolValue() == r8.getBoolValue()) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0068, code lost:
        if (getStringValue().equals(r8.getStringValue()) != false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x007f, code lost:
        if (java.lang.Double.doubleToLongBits(getNumberValue()) == java.lang.Double.doubleToLongBits(r8.getNumberValue())) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x008c, code lost:
        if (getNullValueValue() == r8.getNullValueValue()) goto L36;
     */
    @Override // com.google.protobuf.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean equals(Object obj) {
        boolean z10 = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Value)) {
            return super.equals(obj);
        }
        Value value = (Value) obj;
        boolean z11 = getKindCase().equals(value.getKindCase());
        if (!z11) {
            return false;
        }
        switch (this.kindCase_) {
            case 1:
                if (z11) {
                    break;
                }
                z10 = false;
                break;
            case 2:
                if (z11) {
                    break;
                }
                z10 = false;
                break;
            case 3:
                if (z11) {
                    break;
                }
                z10 = false;
                break;
            case 4:
                if (z11) {
                    break;
                }
                z10 = false;
                break;
            case 5:
                if (z11) {
                    break;
                }
                z10 = false;
                break;
            case 6:
                if (z11) {
                    break;
                }
                z10 = false;
                break;
            default:
                return z11;
        }
        return z10;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: g */
    public c newBuilderForType(GeneratedMessageV3.c cVar) {
        return new c(cVar, null);
    }

    public boolean getBoolValue() {
        if (this.kindCase_ == 4) {
            return ((Boolean) this.kind_).booleanValue();
        }
        return false;
    }

    public KindCase getKindCase() {
        return KindCase.forNumber(this.kindCase_);
    }

    public ListValue getListValue() {
        if (this.kindCase_ == 6) {
            return (ListValue) this.kind_;
        }
        return ListValue.getDefaultInstance();
    }

    public z getListValueOrBuilder() {
        if (this.kindCase_ == 6) {
            return (ListValue) this.kind_;
        }
        return ListValue.getDefaultInstance();
    }

    public NullValue getNullValue() {
        if (this.kindCase_ != 1) {
            return NullValue.NULL_VALUE;
        }
        NullValue valueOf = NullValue.valueOf(((Integer) this.kind_).intValue());
        return valueOf == null ? NullValue.UNRECOGNIZED : valueOf;
    }

    public int getNullValueValue() {
        if (this.kindCase_ == 1) {
            return ((Integer) this.kind_).intValue();
        }
        return 0;
    }

    public double getNumberValue() {
        if (this.kindCase_ == 2) {
            return ((Double) this.kind_).doubleValue();
        }
        return 0.0d;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
    public l0<Value> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
    public int getSerializedSize() {
        int i10 = this.memoizedSize;
        if (i10 != -1) {
            return i10;
        }
        int i11 = 0;
        if (this.kindCase_ == 1) {
            i11 = 0 + CodedOutputStream.l(1, ((Integer) this.kind_).intValue());
        }
        if (this.kindCase_ == 2) {
            i11 += CodedOutputStream.j(2, ((Double) this.kind_).doubleValue());
        }
        if (this.kindCase_ == 3) {
            i11 += GeneratedMessageV3.computeStringSize(3, this.kind_);
        }
        if (this.kindCase_ == 4) {
            i11 += CodedOutputStream.e(4, ((Boolean) this.kind_).booleanValue());
        }
        if (this.kindCase_ == 5) {
            i11 += CodedOutputStream.E(5, (Struct) this.kind_);
        }
        if (this.kindCase_ == 6) {
            i11 += CodedOutputStream.E(6, (ListValue) this.kind_);
        }
        this.memoizedSize = i11;
        return i11;
    }

    public String getStringValue() {
        String str = this.kindCase_ == 3 ? this.kind_ : "";
        if (str instanceof String) {
            return (String) str;
        }
        String stringUtf8 = ((ByteString) str).toStringUtf8();
        if (this.kindCase_ == 3) {
            this.kind_ = stringUtf8;
        }
        return stringUtf8;
    }

    public ByteString getStringValueBytes() {
        String str = this.kindCase_ == 3 ? this.kind_ : "";
        if (!(str instanceof String)) {
            return (ByteString) str;
        }
        ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) str);
        if (this.kindCase_ == 3) {
            this.kind_ = copyFromUtf8;
        }
        return copyFromUtf8;
    }

    public Struct getStructValue() {
        if (this.kindCase_ == 5) {
            return (Struct) this.kind_;
        }
        return Struct.getDefaultInstance();
    }

    public u0 getStructValueOrBuilder() {
        if (this.kindCase_ == 5) {
            return (Struct) this.kind_;
        }
        return Struct.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.g0
    public final a1 getUnknownFields() {
        return a1.c();
    }

    @Override // com.google.protobuf.a
    public int hashCode() {
        int i10;
        int i11;
        int i12 = this.memoizedHashCode;
        if (i12 != 0) {
            return i12;
        }
        int hashCode = 779 + getDescriptorForType().hashCode();
        switch (this.kindCase_) {
            case 1:
                i11 = ((hashCode * 37) + 1) * 53;
                i10 = getNullValueValue();
                hashCode = i11 + i10;
                int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
                this.memoizedHashCode = hashCode2;
                return hashCode2;
            case 2:
                i11 = ((hashCode * 37) + 2) * 53;
                i10 = u.h(Double.doubleToLongBits(getNumberValue()));
                hashCode = i11 + i10;
                int hashCode22 = (hashCode * 29) + this.unknownFields.hashCode();
                this.memoizedHashCode = hashCode22;
                return hashCode22;
            case 3:
                i11 = ((hashCode * 37) + 3) * 53;
                i10 = getStringValue().hashCode();
                hashCode = i11 + i10;
                int hashCode222 = (hashCode * 29) + this.unknownFields.hashCode();
                this.memoizedHashCode = hashCode222;
                return hashCode222;
            case 4:
                i11 = ((hashCode * 37) + 4) * 53;
                i10 = u.c(getBoolValue());
                hashCode = i11 + i10;
                int hashCode2222 = (hashCode * 29) + this.unknownFields.hashCode();
                this.memoizedHashCode = hashCode2222;
                return hashCode2222;
            case 5:
                i11 = ((hashCode * 37) + 5) * 53;
                i10 = getStructValue().hashCode();
                hashCode = i11 + i10;
                int hashCode22222 = (hashCode * 29) + this.unknownFields.hashCode();
                this.memoizedHashCode = hashCode22222;
                return hashCode22222;
            case 6:
                i11 = ((hashCode * 37) + 6) * 53;
                i10 = getListValue().hashCode();
                hashCode = i11 + i10;
                int hashCode222222 = (hashCode * 29) + this.unknownFields.hashCode();
                this.memoizedHashCode = hashCode222222;
                return hashCode222222;
            default:
                int hashCode2222222 = (hashCode * 29) + this.unknownFields.hashCode();
                this.memoizedHashCode = hashCode2222222;
                return hashCode2222222;
        }
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
        return v0.f13374e.e(Value.class, c.class);
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
        if (this.kindCase_ == 1) {
            codedOutputStream.m0(1, ((Integer) this.kind_).intValue());
        }
        if (this.kindCase_ == 2) {
            codedOutputStream.k0(2, ((Double) this.kind_).doubleValue());
        }
        if (this.kindCase_ == 3) {
            GeneratedMessageV3.writeString(codedOutputStream, 3, this.kind_);
        }
        if (this.kindCase_ == 4) {
            codedOutputStream.e0(4, ((Boolean) this.kind_).booleanValue());
        }
        if (this.kindCase_ == 5) {
            codedOutputStream.A0(5, (Struct) this.kind_);
        }
        if (this.kindCase_ == 6) {
            codedOutputStream.A0(6, (ListValue) this.kind_);
        }
    }

    /* synthetic */ Value(GeneratedMessageV3.b bVar, a aVar) {
        this(bVar);
    }

    public static c newBuilder(Value value) {
        return DEFAULT_INSTANCE.toBuilder().l(value);
    }

    public static Value parseFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, qVar);
    }

    private Value(GeneratedMessageV3.b<?> bVar) {
        super(bVar);
        this.kindCase_ = 0;
        this.memoizedIsInitialized = (byte) -1;
    }

    public static Value parseDelimitedFrom(InputStream inputStream, q qVar) throws IOException {
        return (Value) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
    }

    public static Value parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
    public Value getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
    public c toBuilder() {
        return this == DEFAULT_INSTANCE ? new c((a) null) : new c((a) null).l(this);
    }

    public static Value parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, qVar);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
    public c newBuilderForType() {
        return newBuilder();
    }

    public static Value parseFrom(InputStream inputStream) throws IOException {
        return (Value) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    private Value() {
        this.kindCase_ = 0;
        this.memoizedIsInitialized = (byte) -1;
    }

    public static Value parseFrom(InputStream inputStream, q qVar) throws IOException {
        return (Value) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
    }

    private Value(i iVar, q qVar) throws InvalidProtocolBufferException {
        this();
        boolean z10 = false;
        while (!z10) {
            try {
                try {
                    int F = iVar.F();
                    if (F != 0) {
                        if (F == 8) {
                            int o10 = iVar.o();
                            this.kindCase_ = 1;
                            this.kind_ = Integer.valueOf(o10);
                        } else if (F == 17) {
                            this.kindCase_ = 2;
                            this.kind_ = Double.valueOf(iVar.n());
                        } else if (F == 26) {
                            String E = iVar.E();
                            this.kindCase_ = 3;
                            this.kind_ = E;
                        } else if (F != 32) {
                            ListValue.b bVar = null;
                            Struct.b builder = null;
                            if (F == 42) {
                                builder = this.kindCase_ == 5 ? ((Struct) this.kind_).toBuilder() : builder;
                                e0 v10 = iVar.v(Struct.parser(), qVar);
                                this.kind_ = v10;
                                if (builder != null) {
                                    builder.n((Struct) v10);
                                    this.kind_ = builder.buildPartial();
                                }
                                this.kindCase_ = 5;
                            } else if (F == 50) {
                                bVar = this.kindCase_ == 6 ? ((ListValue) this.kind_).toBuilder() : bVar;
                                e0 v11 = iVar.v(ListValue.parser(), qVar);
                                this.kind_ = v11;
                                if (bVar != null) {
                                    bVar.m((ListValue) v11);
                                    this.kind_ = bVar.buildPartial();
                                }
                                this.kindCase_ = 6;
                            } else if (!iVar.I(F)) {
                            }
                        } else {
                            this.kindCase_ = 4;
                            this.kind_ = Boolean.valueOf(iVar.l());
                        }
                    }
                    z10 = true;
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

    public static Value parseFrom(i iVar) throws IOException {
        return (Value) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
    }

    public static Value parseFrom(i iVar, q qVar) throws IOException {
        return (Value) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
    }
}
