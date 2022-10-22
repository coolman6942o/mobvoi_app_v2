package com.google.protobuf;

import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Value;
import com.google.protobuf.a;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public final class ListValue extends GeneratedMessageV3 implements z {
    private static final ListValue DEFAULT_INSTANCE = new ListValue();
    private static final l0<ListValue> PARSER = new a();
    public static final int VALUES_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private byte memoizedIsInitialized;
    private List<Value> values_;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a extends c<ListValue> {
        a() {
        }

        /* renamed from: a */
        public ListValue parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
            return new ListValue(iVar, qVar, null);
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends GeneratedMessageV3.b<b> implements z {

        /* renamed from: a  reason: collision with root package name */
        private int f13088a;

        /* renamed from: b  reason: collision with root package name */
        private List<Value> f13089b;

        /* renamed from: c  reason: collision with root package name */
        private o0<Value, Value.c, e1> f13090c;

        /* synthetic */ b(GeneratedMessageV3.c cVar, a aVar) {
            this(cVar);
        }

        private void i() {
            if ((this.f13088a & 1) != 1) {
                this.f13089b = new ArrayList(this.f13089b);
                this.f13088a |= 1;
            }
        }

        private o0<Value, Value.c, e1> k() {
            if (this.f13090c == null) {
                List<Value> list = this.f13089b;
                boolean z10 = true;
                if ((this.f13088a & 1) != 1) {
                    z10 = false;
                }
                this.f13090c = new o0<>(list, z10, getParentForChildren(), isClean());
                this.f13089b = null;
            }
            return this.f13090c;
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
        public ListValue build() {
            ListValue c10 = buildPartial();
            if (c10.isInitialized()) {
                return c10;
            }
            throw a.AbstractC0170a.newUninitializedMessageException((d0) c10);
        }

        /* renamed from: c */
        public ListValue buildPartial() {
            ListValue listValue = new ListValue(this, (a) null);
            int i10 = this.f13088a;
            o0<Value, Value.c, e1> o0Var = this.f13090c;
            if (o0Var == null) {
                if ((i10 & 1) == 1) {
                    this.f13089b = Collections.unmodifiableList(this.f13089b);
                    this.f13088a &= -2;
                }
                listValue.values_ = this.f13089b;
            } else {
                listValue.values_ = o0Var.g();
            }
            onBuilt();
            return listValue;
        }

        /* renamed from: d */
        public b clear() {
            super.clear();
            o0<Value, Value.c, e1> o0Var = this.f13090c;
            if (o0Var == null) {
                this.f13089b = Collections.emptyList();
                this.f13088a &= -2;
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
            return v0.f13375f;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.b
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return v0.f13376g.e(ListValue.class, b.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.f0
        public final boolean isInitialized() {
            return true;
        }

        /* renamed from: j */
        public ListValue getDefaultInstanceForType() {
            return ListValue.getDefaultInstance();
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0023  */
        /* renamed from: l */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b mergeFrom(i iVar, q qVar) throws IOException {
            Throwable th2;
            ListValue listValue = null;
            try {
                try {
                    ListValue listValue2 = (ListValue) ListValue.PARSER.parsePartialFrom(iVar, qVar);
                    if (listValue2 != null) {
                        m(listValue2);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e10) {
                    listValue = (ListValue) e10.getUnfinishedMessage();
                    try {
                        throw e10.unwrapIOException();
                    } catch (Throwable th3) {
                        th2 = th3;
                        if (listValue != null) {
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th4) {
                th2 = th4;
                if (listValue != null) {
                    m(listValue);
                }
                throw th2;
            }
        }

        public b m(ListValue listValue) {
            if (listValue == ListValue.getDefaultInstance()) {
                return this;
            }
            if (this.f13090c == null) {
                if (!listValue.values_.isEmpty()) {
                    if (this.f13089b.isEmpty()) {
                        this.f13089b = listValue.values_;
                        this.f13088a &= -2;
                    } else {
                        i();
                        this.f13089b.addAll(listValue.values_);
                    }
                    onChanged();
                }
            } else if (!listValue.values_.isEmpty()) {
                if (this.f13090c.u()) {
                    this.f13090c.i();
                    o0<Value, Value.c, e1> o0Var = null;
                    this.f13090c = null;
                    this.f13089b = listValue.values_;
                    this.f13088a &= -2;
                    if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                        o0Var = k();
                    }
                    this.f13090c = o0Var;
                } else {
                    this.f13090c.b(listValue.values_);
                }
            }
            onChanged();
            return this;
        }

        /* renamed from: n */
        public b mergeFrom(d0 d0Var) {
            if (d0Var instanceof ListValue) {
                return m((ListValue) d0Var);
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

        /* renamed from: q */
        public b setRepeatedField2(Descriptors.FieldDescriptor fieldDescriptor, int i10, Object obj) {
            return (b) super.setRepeatedField(fieldDescriptor, i10, obj);
        }

        /* renamed from: r */
        public final b setUnknownFields(a1 a1Var) {
            return this;
        }

        /* synthetic */ b(a aVar) {
            this();
        }

        private b() {
            this.f13089b = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        private b(GeneratedMessageV3.c cVar) {
            super(cVar);
            this.f13089b = Collections.emptyList();
            maybeForceBuilderInitialization();
        }
    }

    /* synthetic */ ListValue(i iVar, q qVar, a aVar) throws InvalidProtocolBufferException {
        this(iVar, qVar);
    }

    public static ListValue getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.b getDescriptor() {
        return v0.f13375f;
    }

    public static b newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static ListValue parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (ListValue) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static ListValue parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static l0<ListValue> parser() {
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
        if (!(obj instanceof ListValue)) {
            return super.equals(obj);
        }
        return getValuesList().equals(((ListValue) obj).getValuesList());
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
    public l0<ListValue> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
    public int getSerializedSize() {
        int i10 = this.memoizedSize;
        if (i10 != -1) {
            return i10;
        }
        int i11 = 0;
        for (int i12 = 0; i12 < this.values_.size(); i12++) {
            i11 += CodedOutputStream.E(1, this.values_.get(i12));
        }
        this.memoizedSize = i11;
        return i11;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.g0
    public final a1 getUnknownFields() {
        return a1.c();
    }

    public Value getValues(int i10) {
        return this.values_.get(i10);
    }

    public int getValuesCount() {
        return this.values_.size();
    }

    public List<Value> getValuesList() {
        return this.values_;
    }

    public e1 getValuesOrBuilder(int i10) {
        return this.values_.get(i10);
    }

    public List<? extends e1> getValuesOrBuilderList() {
        return this.values_;
    }

    @Override // com.google.protobuf.a
    public int hashCode() {
        int i10 = this.memoizedHashCode;
        if (i10 != 0) {
            return i10;
        }
        int hashCode = 779 + getDescriptorForType().hashCode();
        if (getValuesCount() > 0) {
            hashCode = (((hashCode * 37) + 1) * 53) + getValuesList().hashCode();
        }
        int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode2;
        return hashCode2;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
        return v0.f13376g.e(ListValue.class, b.class);
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
        for (int i10 = 0; i10 < this.values_.size(); i10++) {
            codedOutputStream.A0(1, this.values_.get(i10));
        }
    }

    /* synthetic */ ListValue(GeneratedMessageV3.b bVar, a aVar) {
        this(bVar);
    }

    public static b newBuilder(ListValue listValue) {
        return DEFAULT_INSTANCE.toBuilder().m(listValue);
    }

    public static ListValue parseFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, qVar);
    }

    private ListValue(GeneratedMessageV3.b<?> bVar) {
        super(bVar);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static ListValue parseDelimitedFrom(InputStream inputStream, q qVar) throws IOException {
        return (ListValue) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
    }

    public static ListValue parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
    public ListValue getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
    public b toBuilder() {
        return this == DEFAULT_INSTANCE ? new b((a) null) : new b((a) null).m(this);
    }

    public static ListValue parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, qVar);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
    public b newBuilderForType() {
        return newBuilder();
    }

    private ListValue() {
        this.memoizedIsInitialized = (byte) -1;
        this.values_ = Collections.emptyList();
    }

    public static ListValue parseFrom(InputStream inputStream) throws IOException {
        return (ListValue) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static ListValue parseFrom(InputStream inputStream, q qVar) throws IOException {
        return (ListValue) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ListValue(i iVar, q qVar) throws InvalidProtocolBufferException {
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
                    if (F != 0) {
                        if (F == 10) {
                            if (!z11 || !true) {
                                this.values_ = new ArrayList();
                                z11 |= true;
                            }
                            this.values_.add(iVar.v(Value.parser(), qVar));
                        } else if (!iVar.I(F)) {
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
                    this.values_ = Collections.unmodifiableList(this.values_);
                }
                makeExtensionsImmutable();
            }
        }
    }

    public static ListValue parseFrom(i iVar) throws IOException {
        return (ListValue) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
    }

    public static ListValue parseFrom(i iVar, q qVar) throws IOException {
        return (ListValue) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
    }
}
