package com.mobvoi.companion.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.a;
import com.google.protobuf.a1;
import com.google.protobuf.b;
import com.google.protobuf.c;
import com.google.protobuf.d0;
import com.google.protobuf.e0;
import com.google.protobuf.g0;
import com.google.protobuf.i;
import com.google.protobuf.l0;
import com.google.protobuf.m0;
import com.google.protobuf.o;
import com.google.protobuf.q;
import com.google.protobuf.u;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Objects;
/* loaded from: classes2.dex */
public final class PayProto {
    private static Descriptors.FileDescriptor descriptor;
    private static final Descriptors.b internal_static_com_mobvoi_companion_proto_ApplePayReceipt_descriptor;
    private static final GeneratedMessageV3.e internal_static_com_mobvoi_companion_proto_ApplePayReceipt_fieldAccessorTable;
    private static final Descriptors.b internal_static_com_mobvoi_companion_proto_SoundPayResp_descriptor;
    private static final GeneratedMessageV3.e internal_static_com_mobvoi_companion_proto_SoundPayResp_fieldAccessorTable;
    private static final Descriptors.b internal_static_com_mobvoi_companion_proto_SoundPay_descriptor;
    private static final GeneratedMessageV3.e internal_static_com_mobvoi_companion_proto_SoundPay_fieldAccessorTable;

    /* loaded from: classes2.dex */
    public static final class ApplePayReceipt extends GeneratedMessageV3 implements ApplePayReceiptOrBuilder {
        public static final int ORDER_ID_FIELD_NUMBER = 2;
        public static final int RECEIPT_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private byte memoizedIsInitialized;
        private volatile Object orderId_;
        private volatile Object receipt_;
        private static final ApplePayReceipt DEFAULT_INSTANCE = new ApplePayReceipt();
        private static final l0<ApplePayReceipt> PARSER = new c<ApplePayReceipt>() { // from class: com.mobvoi.companion.proto.PayProto.ApplePayReceipt.1
            @Override // com.google.protobuf.l0
            public ApplePayReceipt parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
                return new ApplePayReceipt(iVar, qVar);
            }
        };

        public static ApplePayReceipt getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return PayProto.internal_static_com_mobvoi_companion_proto_ApplePayReceipt_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static ApplePayReceipt parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ApplePayReceipt) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static ApplePayReceipt parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static l0<ApplePayReceipt> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ApplePayReceipt)) {
                return super.equals(obj);
            }
            ApplePayReceipt applePayReceipt = (ApplePayReceipt) obj;
            return (getReceipt().equals(applePayReceipt.getReceipt())) && getOrderId().equals(applePayReceipt.getOrderId());
        }

        @Override // com.mobvoi.companion.proto.PayProto.ApplePayReceiptOrBuilder
        public String getOrderId() {
            Object obj = this.orderId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.orderId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.proto.PayProto.ApplePayReceiptOrBuilder
        public ByteString getOrderIdBytes() {
            Object obj = this.orderId_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.orderId_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public l0<ApplePayReceipt> getParserForType() {
            return PARSER;
        }

        @Override // com.mobvoi.companion.proto.PayProto.ApplePayReceiptOrBuilder
        public String getReceipt() {
            Object obj = this.receipt_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.receipt_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.proto.PayProto.ApplePayReceiptOrBuilder
        public ByteString getReceiptBytes() {
            Object obj = this.receipt_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.receipt_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
        public int getSerializedSize() {
            int i10 = this.memoizedSize;
            if (i10 != -1) {
                return i10;
            }
            int i11 = 0;
            if (!getReceiptBytes().isEmpty()) {
                i11 = 0 + GeneratedMessageV3.computeStringSize(1, this.receipt_);
            }
            if (!getOrderIdBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(2, this.orderId_);
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
            int hashCode = ((((((((((779 + getDescriptorForType().hashCode()) * 37) + 1) * 53) + getReceipt().hashCode()) * 37) + 2) * 53) + getOrderId().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return PayProto.internal_static_com_mobvoi_companion_proto_ApplePayReceipt_fieldAccessorTable.e(ApplePayReceipt.class, Builder.class);
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
            if (!getReceiptBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.receipt_);
            }
            if (!getOrderIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.orderId_);
            }
        }

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageV3.b<Builder> implements ApplePayReceiptOrBuilder {
            private Object orderId_;
            private Object receipt_;

            public static final Descriptors.b getDescriptor() {
                return PayProto.internal_static_com_mobvoi_companion_proto_ApplePayReceipt_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            public Builder clearOrderId() {
                this.orderId_ = ApplePayReceipt.getDefaultInstance().getOrderId();
                onChanged();
                return this;
            }

            public Builder clearReceipt() {
                this.receipt_ = ApplePayReceipt.getDefaultInstance().getReceipt();
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a, com.google.protobuf.g0
            public Descriptors.b getDescriptorForType() {
                return PayProto.internal_static_com_mobvoi_companion_proto_ApplePayReceipt_descriptor;
            }

            @Override // com.mobvoi.companion.proto.PayProto.ApplePayReceiptOrBuilder
            public String getOrderId() {
                Object obj = this.orderId_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.orderId_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.proto.PayProto.ApplePayReceiptOrBuilder
            public ByteString getOrderIdBytes() {
                Object obj = this.orderId_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.orderId_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.mobvoi.companion.proto.PayProto.ApplePayReceiptOrBuilder
            public String getReceipt() {
                Object obj = this.receipt_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.receipt_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.proto.PayProto.ApplePayReceiptOrBuilder
            public ByteString getReceiptBytes() {
                Object obj = this.receipt_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.receipt_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return PayProto.internal_static_com_mobvoi_companion_proto_ApplePayReceipt_fieldAccessorTable.e(ApplePayReceipt.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.f0
            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a
            public final Builder mergeUnknownFields(a1 a1Var) {
                return this;
            }

            public Builder setOrderId(String str) {
                Objects.requireNonNull(str);
                this.orderId_ = str;
                onChanged();
                return this;
            }

            public Builder setOrderIdBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                b.checkByteStringIsUtf8(byteString);
                this.orderId_ = byteString;
                onChanged();
                return this;
            }

            public Builder setReceipt(String str) {
                Objects.requireNonNull(str);
                this.receipt_ = str;
                onChanged();
                return this;
            }

            public Builder setReceiptBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                b.checkByteStringIsUtf8(byteString);
                this.receipt_ = byteString;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public final Builder setUnknownFields(a1 a1Var) {
                return this;
            }

            private Builder() {
                this.receipt_ = "";
                this.orderId_ = "";
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.e0.a, com.google.protobuf.d0.a
            public ApplePayReceipt build() {
                ApplePayReceipt buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) buildPartial);
            }

            @Override // com.google.protobuf.e0.a, com.google.protobuf.d0.a
            public ApplePayReceipt buildPartial() {
                ApplePayReceipt applePayReceipt = new ApplePayReceipt(this);
                applePayReceipt.receipt_ = this.receipt_;
                applePayReceipt.orderId_ = this.orderId_;
                onBuilt();
                return applePayReceipt;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.f0, com.google.protobuf.g0
            public ApplePayReceipt getDefaultInstanceForType() {
                return ApplePayReceipt.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: setRepeatedField */
            public Builder setRepeatedField2(Descriptors.FieldDescriptor fieldDescriptor, int i10, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i10, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a
            public Builder clearOneof(Descriptors.h hVar) {
                return (Builder) super.clearOneof(hVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a
            public Builder clear() {
                super.clear();
                this.receipt_ = "";
                this.orderId_ = "";
                return this;
            }

            private Builder(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.receipt_ = "";
                this.orderId_ = "";
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a, com.google.protobuf.b.a
            public Builder clone() {
                return (Builder) super.clone();
            }

            @Override // com.google.protobuf.a.AbstractC0170a, com.google.protobuf.d0.a
            public Builder mergeFrom(d0 d0Var) {
                if (d0Var instanceof ApplePayReceipt) {
                    return mergeFrom((ApplePayReceipt) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            public Builder mergeFrom(ApplePayReceipt applePayReceipt) {
                if (applePayReceipt == ApplePayReceipt.getDefaultInstance()) {
                    return this;
                }
                if (!applePayReceipt.getReceipt().isEmpty()) {
                    this.receipt_ = applePayReceipt.receipt_;
                    onChanged();
                }
                if (!applePayReceipt.getOrderId().isEmpty()) {
                    this.orderId_ = applePayReceipt.orderId_;
                    onChanged();
                }
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x0023  */
            @Override // com.google.protobuf.a.AbstractC0170a, com.google.protobuf.b.a, com.google.protobuf.e0.a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(i iVar, q qVar) throws IOException {
                Throwable th2;
                ApplePayReceipt applePayReceipt = null;
                try {
                    try {
                        ApplePayReceipt applePayReceipt2 = (ApplePayReceipt) ApplePayReceipt.PARSER.parsePartialFrom(iVar, qVar);
                        if (applePayReceipt2 != null) {
                            mergeFrom(applePayReceipt2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e10) {
                        applePayReceipt = (ApplePayReceipt) e10.getUnfinishedMessage();
                        try {
                            throw e10.unwrapIOException();
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (applePayReceipt != null) {
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (applePayReceipt != null) {
                        mergeFrom(applePayReceipt);
                    }
                    throw th2;
                }
            }
        }

        public static Builder newBuilder(ApplePayReceipt applePayReceipt) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(applePayReceipt);
        }

        public static ApplePayReceipt parseFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, qVar);
        }

        private ApplePayReceipt(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static ApplePayReceipt parseDelimitedFrom(InputStream inputStream, q qVar) throws IOException {
            return (ApplePayReceipt) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
        }

        public static ApplePayReceipt parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
        public ApplePayReceipt getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static ApplePayReceipt parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder newBuilderForType() {
            return newBuilder();
        }

        private ApplePayReceipt() {
            this.memoizedIsInitialized = (byte) -1;
            this.receipt_ = "";
            this.orderId_ = "";
        }

        public static ApplePayReceipt parseFrom(InputStream inputStream) throws IOException {
            return (ApplePayReceipt) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.c cVar) {
            return new Builder(cVar);
        }

        public static ApplePayReceipt parseFrom(InputStream inputStream, q qVar) throws IOException {
            return (ApplePayReceipt) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
        }

        private ApplePayReceipt(i iVar, q qVar) throws InvalidProtocolBufferException {
            this();
            boolean z10 = false;
            while (!z10) {
                try {
                    try {
                        try {
                            int F = iVar.F();
                            z10 = true;
                            if (F != 0) {
                                if (F == 10) {
                                    this.receipt_ = iVar.E();
                                } else if (F == 18) {
                                    this.orderId_ = iVar.E();
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

        public static ApplePayReceipt parseFrom(i iVar) throws IOException {
            return (ApplePayReceipt) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
        }

        public static ApplePayReceipt parseFrom(i iVar, q qVar) throws IOException {
            return (ApplePayReceipt) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
        }
    }

    /* loaded from: classes2.dex */
    public interface ApplePayReceiptOrBuilder extends g0 {
        /* synthetic */ List<String> findInitializationErrors();

        @Override // com.google.protobuf.g0
        /* synthetic */ Map<Descriptors.FieldDescriptor, Object> getAllFields();

        @Override // com.google.protobuf.g0
        /* synthetic */ d0 getDefaultInstanceForType();

        @Override // com.google.protobuf.g0
        /* synthetic */ e0 getDefaultInstanceForType();

        @Override // com.google.protobuf.g0
        /* synthetic */ Descriptors.b getDescriptorForType();

        @Override // com.google.protobuf.g0
        /* synthetic */ Object getField(Descriptors.FieldDescriptor fieldDescriptor);

        /* synthetic */ String getInitializationErrorString();

        /* synthetic */ Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.h hVar);

        String getOrderId();

        ByteString getOrderIdBytes();

        String getReceipt();

        ByteString getReceiptBytes();

        /* synthetic */ Object getRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i10);

        /* synthetic */ int getRepeatedFieldCount(Descriptors.FieldDescriptor fieldDescriptor);

        @Override // com.google.protobuf.g0
        /* synthetic */ a1 getUnknownFields();

        @Override // com.google.protobuf.g0
        /* synthetic */ boolean hasField(Descriptors.FieldDescriptor fieldDescriptor);

        /* synthetic */ boolean hasOneof(Descriptors.h hVar);

        @Override // com.google.protobuf.f0
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes2.dex */
    public enum OrderType implements m0 {
        UNKNOWN(0),
        ONE_HOUR(1),
        FIVE_HOUR(2),
        TEN_HOUR(3),
        UNRECOGNIZED(-1);
        
        public static final int FIVE_HOUR_VALUE = 2;
        public static final int ONE_HOUR_VALUE = 1;
        public static final int TEN_HOUR_VALUE = 3;
        public static final int UNKNOWN_VALUE = 0;
        private final int value;
        private static final u.b<OrderType> internalValueMap = new u.b<OrderType>() { // from class: com.mobvoi.companion.proto.PayProto.OrderType.1
            public OrderType findValueByNumber(int i10) {
                return OrderType.forNumber(i10);
            }
        };
        private static final OrderType[] VALUES = values();

        OrderType(int i10) {
            this.value = i10;
        }

        public static OrderType forNumber(int i10) {
            if (i10 == 0) {
                return UNKNOWN;
            }
            if (i10 == 1) {
                return ONE_HOUR;
            }
            if (i10 == 2) {
                return FIVE_HOUR;
            }
            if (i10 != 3) {
                return null;
            }
            return TEN_HOUR;
        }

        public static final Descriptors.d getDescriptor() {
            return PayProto.getDescriptor().i().get(0);
        }

        public static u.b<OrderType> internalGetValueMap() {
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
        public static OrderType valueOf(int i10) {
            return forNumber(i10);
        }

        public static OrderType valueOf(Descriptors.e eVar) {
            if (eVar.g() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            } else if (eVar.f() == -1) {
                return UNRECOGNIZED;
            } else {
                return VALUES[eVar.f()];
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class SoundPay extends GeneratedMessageV3 implements SoundPayOrBuilder {
        public static final int AMOUNT_FIELD_NUMBER = 2;
        public static final int ORDER_TYPE_FIELD_NUMBER = 1;
        public static final int PAYTYPE_FIELD_NUMBER = 5;
        public static final int PRODUCT_ID_FIELD_NUMBER = 3;
        public static final int SOURCE_FIELD_NUMBER = 4;
        private static final long serialVersionUID = 0;
        private volatile Object amount_;
        private byte memoizedIsInitialized;
        private int orderType_;
        private volatile Object payType_;
        private volatile Object productId_;
        private int source_;
        private static final SoundPay DEFAULT_INSTANCE = new SoundPay();
        private static final l0<SoundPay> PARSER = new c<SoundPay>() { // from class: com.mobvoi.companion.proto.PayProto.SoundPay.1
            @Override // com.google.protobuf.l0
            public SoundPay parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
                return new SoundPay(iVar, qVar);
            }
        };

        public static SoundPay getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return PayProto.internal_static_com_mobvoi_companion_proto_SoundPay_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static SoundPay parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (SoundPay) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static SoundPay parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static l0<SoundPay> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof SoundPay)) {
                return super.equals(obj);
            }
            SoundPay soundPay = (SoundPay) obj;
            return ((((this.orderType_ == soundPay.orderType_) && getAmount().equals(soundPay.getAmount())) && getProductId().equals(soundPay.getProductId())) && this.source_ == soundPay.source_) && getPayType().equals(soundPay.getPayType());
        }

        @Override // com.mobvoi.companion.proto.PayProto.SoundPayOrBuilder
        public String getAmount() {
            Object obj = this.amount_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.amount_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.proto.PayProto.SoundPayOrBuilder
        public ByteString getAmountBytes() {
            Object obj = this.amount_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.amount_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.mobvoi.companion.proto.PayProto.SoundPayOrBuilder
        @Deprecated
        public OrderType getOrderType() {
            OrderType valueOf = OrderType.valueOf(this.orderType_);
            return valueOf == null ? OrderType.UNRECOGNIZED : valueOf;
        }

        @Override // com.mobvoi.companion.proto.PayProto.SoundPayOrBuilder
        @Deprecated
        public int getOrderTypeValue() {
            return this.orderType_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public l0<SoundPay> getParserForType() {
            return PARSER;
        }

        @Override // com.mobvoi.companion.proto.PayProto.SoundPayOrBuilder
        public String getPayType() {
            Object obj = this.payType_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.payType_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.proto.PayProto.SoundPayOrBuilder
        public ByteString getPayTypeBytes() {
            Object obj = this.payType_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.payType_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.mobvoi.companion.proto.PayProto.SoundPayOrBuilder
        public String getProductId() {
            Object obj = this.productId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.productId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.proto.PayProto.SoundPayOrBuilder
        public ByteString getProductIdBytes() {
            Object obj = this.productId_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.productId_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
        public int getSerializedSize() {
            int i10 = this.memoizedSize;
            if (i10 != -1) {
                return i10;
            }
            int i11 = 0;
            if (this.orderType_ != OrderType.UNKNOWN.getNumber()) {
                i11 = 0 + CodedOutputStream.l(1, this.orderType_);
            }
            if (!getAmountBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(2, this.amount_);
            }
            if (!getProductIdBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(3, this.productId_);
            }
            if (this.source_ != Source.ANDROID.getNumber()) {
                i11 += CodedOutputStream.l(4, this.source_);
            }
            if (!getPayTypeBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(5, this.payType_);
            }
            this.memoizedSize = i11;
            return i11;
        }

        @Override // com.mobvoi.companion.proto.PayProto.SoundPayOrBuilder
        public Source getSource() {
            Source valueOf = Source.valueOf(this.source_);
            return valueOf == null ? Source.UNRECOGNIZED : valueOf;
        }

        @Override // com.mobvoi.companion.proto.PayProto.SoundPayOrBuilder
        public int getSourceValue() {
            return this.source_;
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
            int hashCode = ((((((((((((((((((((((779 + getDescriptorForType().hashCode()) * 37) + 1) * 53) + this.orderType_) * 37) + 2) * 53) + getAmount().hashCode()) * 37) + 3) * 53) + getProductId().hashCode()) * 37) + 4) * 53) + this.source_) * 37) + 5) * 53) + getPayType().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return PayProto.internal_static_com_mobvoi_companion_proto_SoundPay_fieldAccessorTable.e(SoundPay.class, Builder.class);
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
            if (this.orderType_ != OrderType.UNKNOWN.getNumber()) {
                codedOutputStream.m0(1, this.orderType_);
            }
            if (!getAmountBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.amount_);
            }
            if (!getProductIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 3, this.productId_);
            }
            if (this.source_ != Source.ANDROID.getNumber()) {
                codedOutputStream.m0(4, this.source_);
            }
            if (!getPayTypeBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 5, this.payType_);
            }
        }

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageV3.b<Builder> implements SoundPayOrBuilder {
            private Object amount_;
            private int orderType_;
            private Object payType_;
            private Object productId_;
            private int source_;

            public static final Descriptors.b getDescriptor() {
                return PayProto.internal_static_com_mobvoi_companion_proto_SoundPay_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            public Builder clearAmount() {
                this.amount_ = SoundPay.getDefaultInstance().getAmount();
                onChanged();
                return this;
            }

            @Deprecated
            public Builder clearOrderType() {
                this.orderType_ = 0;
                onChanged();
                return this;
            }

            public Builder clearPayType() {
                this.payType_ = SoundPay.getDefaultInstance().getPayType();
                onChanged();
                return this;
            }

            public Builder clearProductId() {
                this.productId_ = SoundPay.getDefaultInstance().getProductId();
                onChanged();
                return this;
            }

            public Builder clearSource() {
                this.source_ = 0;
                onChanged();
                return this;
            }

            @Override // com.mobvoi.companion.proto.PayProto.SoundPayOrBuilder
            public String getAmount() {
                Object obj = this.amount_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.amount_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.proto.PayProto.SoundPayOrBuilder
            public ByteString getAmountBytes() {
                Object obj = this.amount_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.amount_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a, com.google.protobuf.g0
            public Descriptors.b getDescriptorForType() {
                return PayProto.internal_static_com_mobvoi_companion_proto_SoundPay_descriptor;
            }

            @Override // com.mobvoi.companion.proto.PayProto.SoundPayOrBuilder
            @Deprecated
            public OrderType getOrderType() {
                OrderType valueOf = OrderType.valueOf(this.orderType_);
                return valueOf == null ? OrderType.UNRECOGNIZED : valueOf;
            }

            @Override // com.mobvoi.companion.proto.PayProto.SoundPayOrBuilder
            @Deprecated
            public int getOrderTypeValue() {
                return this.orderType_;
            }

            @Override // com.mobvoi.companion.proto.PayProto.SoundPayOrBuilder
            public String getPayType() {
                Object obj = this.payType_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.payType_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.proto.PayProto.SoundPayOrBuilder
            public ByteString getPayTypeBytes() {
                Object obj = this.payType_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.payType_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.mobvoi.companion.proto.PayProto.SoundPayOrBuilder
            public String getProductId() {
                Object obj = this.productId_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.productId_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.proto.PayProto.SoundPayOrBuilder
            public ByteString getProductIdBytes() {
                Object obj = this.productId_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.productId_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.mobvoi.companion.proto.PayProto.SoundPayOrBuilder
            public Source getSource() {
                Source valueOf = Source.valueOf(this.source_);
                return valueOf == null ? Source.UNRECOGNIZED : valueOf;
            }

            @Override // com.mobvoi.companion.proto.PayProto.SoundPayOrBuilder
            public int getSourceValue() {
                return this.source_;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return PayProto.internal_static_com_mobvoi_companion_proto_SoundPay_fieldAccessorTable.e(SoundPay.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.f0
            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a
            public final Builder mergeUnknownFields(a1 a1Var) {
                return this;
            }

            public Builder setAmount(String str) {
                Objects.requireNonNull(str);
                this.amount_ = str;
                onChanged();
                return this;
            }

            public Builder setAmountBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                b.checkByteStringIsUtf8(byteString);
                this.amount_ = byteString;
                onChanged();
                return this;
            }

            @Deprecated
            public Builder setOrderType(OrderType orderType) {
                Objects.requireNonNull(orderType);
                this.orderType_ = orderType.getNumber();
                onChanged();
                return this;
            }

            @Deprecated
            public Builder setOrderTypeValue(int i10) {
                this.orderType_ = i10;
                onChanged();
                return this;
            }

            public Builder setPayType(String str) {
                Objects.requireNonNull(str);
                this.payType_ = str;
                onChanged();
                return this;
            }

            public Builder setPayTypeBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                b.checkByteStringIsUtf8(byteString);
                this.payType_ = byteString;
                onChanged();
                return this;
            }

            public Builder setProductId(String str) {
                Objects.requireNonNull(str);
                this.productId_ = str;
                onChanged();
                return this;
            }

            public Builder setProductIdBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                b.checkByteStringIsUtf8(byteString);
                this.productId_ = byteString;
                onChanged();
                return this;
            }

            public Builder setSource(Source source) {
                Objects.requireNonNull(source);
                this.source_ = source.getNumber();
                onChanged();
                return this;
            }

            public Builder setSourceValue(int i10) {
                this.source_ = i10;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public final Builder setUnknownFields(a1 a1Var) {
                return this;
            }

            private Builder() {
                this.orderType_ = 0;
                this.amount_ = "";
                this.productId_ = "";
                this.source_ = 0;
                this.payType_ = "";
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.e0.a, com.google.protobuf.d0.a
            public SoundPay build() {
                SoundPay buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) buildPartial);
            }

            @Override // com.google.protobuf.e0.a, com.google.protobuf.d0.a
            public SoundPay buildPartial() {
                SoundPay soundPay = new SoundPay(this);
                soundPay.orderType_ = this.orderType_;
                soundPay.amount_ = this.amount_;
                soundPay.productId_ = this.productId_;
                soundPay.source_ = this.source_;
                soundPay.payType_ = this.payType_;
                onBuilt();
                return soundPay;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.f0, com.google.protobuf.g0
            public SoundPay getDefaultInstanceForType() {
                return SoundPay.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: setRepeatedField */
            public Builder setRepeatedField2(Descriptors.FieldDescriptor fieldDescriptor, int i10, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i10, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a
            public Builder clearOneof(Descriptors.h hVar) {
                return (Builder) super.clearOneof(hVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a
            public Builder clear() {
                super.clear();
                this.orderType_ = 0;
                this.amount_ = "";
                this.productId_ = "";
                this.source_ = 0;
                this.payType_ = "";
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a, com.google.protobuf.b.a
            public Builder clone() {
                return (Builder) super.clone();
            }

            @Override // com.google.protobuf.a.AbstractC0170a, com.google.protobuf.d0.a
            public Builder mergeFrom(d0 d0Var) {
                if (d0Var instanceof SoundPay) {
                    return mergeFrom((SoundPay) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            private Builder(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.orderType_ = 0;
                this.amount_ = "";
                this.productId_ = "";
                this.source_ = 0;
                this.payType_ = "";
                maybeForceBuilderInitialization();
            }

            public Builder mergeFrom(SoundPay soundPay) {
                if (soundPay == SoundPay.getDefaultInstance()) {
                    return this;
                }
                if (soundPay.orderType_ != 0) {
                    setOrderTypeValue(soundPay.getOrderTypeValue());
                }
                if (!soundPay.getAmount().isEmpty()) {
                    this.amount_ = soundPay.amount_;
                    onChanged();
                }
                if (!soundPay.getProductId().isEmpty()) {
                    this.productId_ = soundPay.productId_;
                    onChanged();
                }
                if (soundPay.source_ != 0) {
                    setSourceValue(soundPay.getSourceValue());
                }
                if (!soundPay.getPayType().isEmpty()) {
                    this.payType_ = soundPay.payType_;
                    onChanged();
                }
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x0023  */
            @Override // com.google.protobuf.a.AbstractC0170a, com.google.protobuf.b.a, com.google.protobuf.e0.a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(i iVar, q qVar) throws IOException {
                Throwable th2;
                SoundPay soundPay = null;
                try {
                    try {
                        SoundPay soundPay2 = (SoundPay) SoundPay.PARSER.parsePartialFrom(iVar, qVar);
                        if (soundPay2 != null) {
                            mergeFrom(soundPay2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e10) {
                        soundPay = (SoundPay) e10.getUnfinishedMessage();
                        try {
                            throw e10.unwrapIOException();
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (soundPay != null) {
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (soundPay != null) {
                        mergeFrom(soundPay);
                    }
                    throw th2;
                }
            }
        }

        public static Builder newBuilder(SoundPay soundPay) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(soundPay);
        }

        public static SoundPay parseFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, qVar);
        }

        private SoundPay(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static SoundPay parseDelimitedFrom(InputStream inputStream, q qVar) throws IOException {
            return (SoundPay) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
        }

        public static SoundPay parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
        public SoundPay getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static SoundPay parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder newBuilderForType() {
            return newBuilder();
        }

        private SoundPay() {
            this.memoizedIsInitialized = (byte) -1;
            this.orderType_ = 0;
            this.amount_ = "";
            this.productId_ = "";
            this.source_ = 0;
            this.payType_ = "";
        }

        public static SoundPay parseFrom(InputStream inputStream) throws IOException {
            return (SoundPay) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.c cVar) {
            return new Builder(cVar);
        }

        public static SoundPay parseFrom(InputStream inputStream, q qVar) throws IOException {
            return (SoundPay) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
        }

        public static SoundPay parseFrom(i iVar) throws IOException {
            return (SoundPay) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
        }

        public static SoundPay parseFrom(i iVar, q qVar) throws IOException {
            return (SoundPay) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
        }

        private SoundPay(i iVar, q qVar) throws InvalidProtocolBufferException {
            this();
            boolean z10 = false;
            while (!z10) {
                try {
                    try {
                        int F = iVar.F();
                        z10 = true;
                        if (F != 0) {
                            if (F == 8) {
                                this.orderType_ = iVar.o();
                            } else if (F == 18) {
                                this.amount_ = iVar.E();
                            } else if (F == 26) {
                                this.productId_ = iVar.E();
                            } else if (F == 32) {
                                this.source_ = iVar.o();
                            } else if (F == 42) {
                                this.payType_ = iVar.E();
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
    }

    /* loaded from: classes2.dex */
    public interface SoundPayOrBuilder extends g0 {
        /* synthetic */ List<String> findInitializationErrors();

        @Override // com.google.protobuf.g0
        /* synthetic */ Map<Descriptors.FieldDescriptor, Object> getAllFields();

        String getAmount();

        ByteString getAmountBytes();

        @Override // com.google.protobuf.g0
        /* synthetic */ d0 getDefaultInstanceForType();

        @Override // com.google.protobuf.g0
        /* synthetic */ e0 getDefaultInstanceForType();

        @Override // com.google.protobuf.g0
        /* synthetic */ Descriptors.b getDescriptorForType();

        @Override // com.google.protobuf.g0
        /* synthetic */ Object getField(Descriptors.FieldDescriptor fieldDescriptor);

        /* synthetic */ String getInitializationErrorString();

        /* synthetic */ Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.h hVar);

        @Deprecated
        OrderType getOrderType();

        @Deprecated
        int getOrderTypeValue();

        String getPayType();

        ByteString getPayTypeBytes();

        String getProductId();

        ByteString getProductIdBytes();

        /* synthetic */ Object getRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i10);

        /* synthetic */ int getRepeatedFieldCount(Descriptors.FieldDescriptor fieldDescriptor);

        Source getSource();

        int getSourceValue();

        @Override // com.google.protobuf.g0
        /* synthetic */ a1 getUnknownFields();

        @Override // com.google.protobuf.g0
        /* synthetic */ boolean hasField(Descriptors.FieldDescriptor fieldDescriptor);

        /* synthetic */ boolean hasOneof(Descriptors.h hVar);

        @Override // com.google.protobuf.f0
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes2.dex */
    public static final class SoundPayResp extends GeneratedMessageV3 implements SoundPayRespOrBuilder {
        public static final int AMOUNT_FIELD_NUMBER = 5;
        public static final int ERR_CODE_FIELD_NUMBER = 1;
        public static final int ERR_MSG_FIELD_NUMBER = 2;
        public static final int ORDER_ID_FIELD_NUMBER = 4;
        public static final int PAY_URL_FIELD_NUMBER = 3;
        private static final long serialVersionUID = 0;
        private volatile Object amount_;
        private int errCode_;
        private volatile Object errMsg_;
        private byte memoizedIsInitialized;
        private volatile Object orderId_;
        private volatile Object payUrl_;
        private static final SoundPayResp DEFAULT_INSTANCE = new SoundPayResp();
        private static final l0<SoundPayResp> PARSER = new c<SoundPayResp>() { // from class: com.mobvoi.companion.proto.PayProto.SoundPayResp.1
            @Override // com.google.protobuf.l0
            public SoundPayResp parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
                return new SoundPayResp(iVar, qVar);
            }
        };

        public static SoundPayResp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return PayProto.internal_static_com_mobvoi_companion_proto_SoundPayResp_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static SoundPayResp parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (SoundPayResp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static SoundPayResp parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static l0<SoundPayResp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof SoundPayResp)) {
                return super.equals(obj);
            }
            SoundPayResp soundPayResp = (SoundPayResp) obj;
            return ((((getErrCode() == soundPayResp.getErrCode()) && getErrMsg().equals(soundPayResp.getErrMsg())) && getPayUrl().equals(soundPayResp.getPayUrl())) && getOrderId().equals(soundPayResp.getOrderId())) && getAmount().equals(soundPayResp.getAmount());
        }

        @Override // com.mobvoi.companion.proto.PayProto.SoundPayRespOrBuilder
        public String getAmount() {
            Object obj = this.amount_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.amount_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.proto.PayProto.SoundPayRespOrBuilder
        public ByteString getAmountBytes() {
            Object obj = this.amount_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.amount_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.mobvoi.companion.proto.PayProto.SoundPayRespOrBuilder
        public int getErrCode() {
            return this.errCode_;
        }

        @Override // com.mobvoi.companion.proto.PayProto.SoundPayRespOrBuilder
        public String getErrMsg() {
            Object obj = this.errMsg_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.errMsg_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.proto.PayProto.SoundPayRespOrBuilder
        public ByteString getErrMsgBytes() {
            Object obj = this.errMsg_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.errMsg_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.mobvoi.companion.proto.PayProto.SoundPayRespOrBuilder
        public String getOrderId() {
            Object obj = this.orderId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.orderId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.proto.PayProto.SoundPayRespOrBuilder
        public ByteString getOrderIdBytes() {
            Object obj = this.orderId_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.orderId_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public l0<SoundPayResp> getParserForType() {
            return PARSER;
        }

        @Override // com.mobvoi.companion.proto.PayProto.SoundPayRespOrBuilder
        public String getPayUrl() {
            Object obj = this.payUrl_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.payUrl_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.proto.PayProto.SoundPayRespOrBuilder
        public ByteString getPayUrlBytes() {
            Object obj = this.payUrl_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.payUrl_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
        public int getSerializedSize() {
            int i10 = this.memoizedSize;
            if (i10 != -1) {
                return i10;
            }
            int i11 = 0;
            int i12 = this.errCode_;
            if (i12 != 0) {
                i11 = 0 + CodedOutputStream.v(1, i12);
            }
            if (!getErrMsgBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(2, this.errMsg_);
            }
            if (!getPayUrlBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(3, this.payUrl_);
            }
            if (!getOrderIdBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(4, this.orderId_);
            }
            if (!getAmountBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(5, this.amount_);
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
            int hashCode = ((((((((((((((((((((((779 + getDescriptorForType().hashCode()) * 37) + 1) * 53) + getErrCode()) * 37) + 2) * 53) + getErrMsg().hashCode()) * 37) + 3) * 53) + getPayUrl().hashCode()) * 37) + 4) * 53) + getOrderId().hashCode()) * 37) + 5) * 53) + getAmount().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return PayProto.internal_static_com_mobvoi_companion_proto_SoundPayResp_fieldAccessorTable.e(SoundPayResp.class, Builder.class);
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
            int i10 = this.errCode_;
            if (i10 != 0) {
                codedOutputStream.w0(1, i10);
            }
            if (!getErrMsgBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.errMsg_);
            }
            if (!getPayUrlBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 3, this.payUrl_);
            }
            if (!getOrderIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 4, this.orderId_);
            }
            if (!getAmountBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 5, this.amount_);
            }
        }

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageV3.b<Builder> implements SoundPayRespOrBuilder {
            private Object amount_;
            private int errCode_;
            private Object errMsg_;
            private Object orderId_;
            private Object payUrl_;

            public static final Descriptors.b getDescriptor() {
                return PayProto.internal_static_com_mobvoi_companion_proto_SoundPayResp_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            public Builder clearAmount() {
                this.amount_ = SoundPayResp.getDefaultInstance().getAmount();
                onChanged();
                return this;
            }

            public Builder clearErrCode() {
                this.errCode_ = 0;
                onChanged();
                return this;
            }

            public Builder clearErrMsg() {
                this.errMsg_ = SoundPayResp.getDefaultInstance().getErrMsg();
                onChanged();
                return this;
            }

            public Builder clearOrderId() {
                this.orderId_ = SoundPayResp.getDefaultInstance().getOrderId();
                onChanged();
                return this;
            }

            public Builder clearPayUrl() {
                this.payUrl_ = SoundPayResp.getDefaultInstance().getPayUrl();
                onChanged();
                return this;
            }

            @Override // com.mobvoi.companion.proto.PayProto.SoundPayRespOrBuilder
            public String getAmount() {
                Object obj = this.amount_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.amount_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.proto.PayProto.SoundPayRespOrBuilder
            public ByteString getAmountBytes() {
                Object obj = this.amount_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.amount_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a, com.google.protobuf.g0
            public Descriptors.b getDescriptorForType() {
                return PayProto.internal_static_com_mobvoi_companion_proto_SoundPayResp_descriptor;
            }

            @Override // com.mobvoi.companion.proto.PayProto.SoundPayRespOrBuilder
            public int getErrCode() {
                return this.errCode_;
            }

            @Override // com.mobvoi.companion.proto.PayProto.SoundPayRespOrBuilder
            public String getErrMsg() {
                Object obj = this.errMsg_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.errMsg_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.proto.PayProto.SoundPayRespOrBuilder
            public ByteString getErrMsgBytes() {
                Object obj = this.errMsg_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.errMsg_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.mobvoi.companion.proto.PayProto.SoundPayRespOrBuilder
            public String getOrderId() {
                Object obj = this.orderId_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.orderId_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.proto.PayProto.SoundPayRespOrBuilder
            public ByteString getOrderIdBytes() {
                Object obj = this.orderId_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.orderId_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.mobvoi.companion.proto.PayProto.SoundPayRespOrBuilder
            public String getPayUrl() {
                Object obj = this.payUrl_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.payUrl_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.proto.PayProto.SoundPayRespOrBuilder
            public ByteString getPayUrlBytes() {
                Object obj = this.payUrl_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.payUrl_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return PayProto.internal_static_com_mobvoi_companion_proto_SoundPayResp_fieldAccessorTable.e(SoundPayResp.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.f0
            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a
            public final Builder mergeUnknownFields(a1 a1Var) {
                return this;
            }

            public Builder setAmount(String str) {
                Objects.requireNonNull(str);
                this.amount_ = str;
                onChanged();
                return this;
            }

            public Builder setAmountBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                b.checkByteStringIsUtf8(byteString);
                this.amount_ = byteString;
                onChanged();
                return this;
            }

            public Builder setErrCode(int i10) {
                this.errCode_ = i10;
                onChanged();
                return this;
            }

            public Builder setErrMsg(String str) {
                Objects.requireNonNull(str);
                this.errMsg_ = str;
                onChanged();
                return this;
            }

            public Builder setErrMsgBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                b.checkByteStringIsUtf8(byteString);
                this.errMsg_ = byteString;
                onChanged();
                return this;
            }

            public Builder setOrderId(String str) {
                Objects.requireNonNull(str);
                this.orderId_ = str;
                onChanged();
                return this;
            }

            public Builder setOrderIdBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                b.checkByteStringIsUtf8(byteString);
                this.orderId_ = byteString;
                onChanged();
                return this;
            }

            public Builder setPayUrl(String str) {
                Objects.requireNonNull(str);
                this.payUrl_ = str;
                onChanged();
                return this;
            }

            public Builder setPayUrlBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                b.checkByteStringIsUtf8(byteString);
                this.payUrl_ = byteString;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public final Builder setUnknownFields(a1 a1Var) {
                return this;
            }

            private Builder() {
                this.errMsg_ = "";
                this.payUrl_ = "";
                this.orderId_ = "";
                this.amount_ = "";
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.e0.a, com.google.protobuf.d0.a
            public SoundPayResp build() {
                SoundPayResp buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) buildPartial);
            }

            @Override // com.google.protobuf.e0.a, com.google.protobuf.d0.a
            public SoundPayResp buildPartial() {
                SoundPayResp soundPayResp = new SoundPayResp(this);
                soundPayResp.errCode_ = this.errCode_;
                soundPayResp.errMsg_ = this.errMsg_;
                soundPayResp.payUrl_ = this.payUrl_;
                soundPayResp.orderId_ = this.orderId_;
                soundPayResp.amount_ = this.amount_;
                onBuilt();
                return soundPayResp;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.f0, com.google.protobuf.g0
            public SoundPayResp getDefaultInstanceForType() {
                return SoundPayResp.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            /* renamed from: setRepeatedField */
            public Builder setRepeatedField2(Descriptors.FieldDescriptor fieldDescriptor, int i10, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i10, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a
            public Builder clearOneof(Descriptors.h hVar) {
                return (Builder) super.clearOneof(hVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a
            public Builder clear() {
                super.clear();
                this.errCode_ = 0;
                this.errMsg_ = "";
                this.payUrl_ = "";
                this.orderId_ = "";
                this.amount_ = "";
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a, com.google.protobuf.b.a
            public Builder clone() {
                return (Builder) super.clone();
            }

            @Override // com.google.protobuf.a.AbstractC0170a, com.google.protobuf.d0.a
            public Builder mergeFrom(d0 d0Var) {
                if (d0Var instanceof SoundPayResp) {
                    return mergeFrom((SoundPayResp) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            private Builder(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.errMsg_ = "";
                this.payUrl_ = "";
                this.orderId_ = "";
                this.amount_ = "";
                maybeForceBuilderInitialization();
            }

            public Builder mergeFrom(SoundPayResp soundPayResp) {
                if (soundPayResp == SoundPayResp.getDefaultInstance()) {
                    return this;
                }
                if (soundPayResp.getErrCode() != 0) {
                    setErrCode(soundPayResp.getErrCode());
                }
                if (!soundPayResp.getErrMsg().isEmpty()) {
                    this.errMsg_ = soundPayResp.errMsg_;
                    onChanged();
                }
                if (!soundPayResp.getPayUrl().isEmpty()) {
                    this.payUrl_ = soundPayResp.payUrl_;
                    onChanged();
                }
                if (!soundPayResp.getOrderId().isEmpty()) {
                    this.orderId_ = soundPayResp.orderId_;
                    onChanged();
                }
                if (!soundPayResp.getAmount().isEmpty()) {
                    this.amount_ = soundPayResp.amount_;
                    onChanged();
                }
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x0023  */
            @Override // com.google.protobuf.a.AbstractC0170a, com.google.protobuf.b.a, com.google.protobuf.e0.a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(i iVar, q qVar) throws IOException {
                Throwable th2;
                SoundPayResp soundPayResp = null;
                try {
                    try {
                        SoundPayResp soundPayResp2 = (SoundPayResp) SoundPayResp.PARSER.parsePartialFrom(iVar, qVar);
                        if (soundPayResp2 != null) {
                            mergeFrom(soundPayResp2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e10) {
                        soundPayResp = (SoundPayResp) e10.getUnfinishedMessage();
                        try {
                            throw e10.unwrapIOException();
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (soundPayResp != null) {
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (soundPayResp != null) {
                        mergeFrom(soundPayResp);
                    }
                    throw th2;
                }
            }
        }

        public static Builder newBuilder(SoundPayResp soundPayResp) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(soundPayResp);
        }

        public static SoundPayResp parseFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, qVar);
        }

        private SoundPayResp(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static SoundPayResp parseDelimitedFrom(InputStream inputStream, q qVar) throws IOException {
            return (SoundPayResp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
        }

        public static SoundPayResp parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
        public SoundPayResp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static SoundPayResp parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder newBuilderForType() {
            return newBuilder();
        }

        private SoundPayResp() {
            this.memoizedIsInitialized = (byte) -1;
            this.errCode_ = 0;
            this.errMsg_ = "";
            this.payUrl_ = "";
            this.orderId_ = "";
            this.amount_ = "";
        }

        public static SoundPayResp parseFrom(InputStream inputStream) throws IOException {
            return (SoundPayResp) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.c cVar) {
            return new Builder(cVar);
        }

        public static SoundPayResp parseFrom(InputStream inputStream, q qVar) throws IOException {
            return (SoundPayResp) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
        }

        public static SoundPayResp parseFrom(i iVar) throws IOException {
            return (SoundPayResp) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
        }

        public static SoundPayResp parseFrom(i iVar, q qVar) throws IOException {
            return (SoundPayResp) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
        }

        private SoundPayResp(i iVar, q qVar) throws InvalidProtocolBufferException {
            this();
            boolean z10 = false;
            while (!z10) {
                try {
                    try {
                        int F = iVar.F();
                        z10 = true;
                        if (F != 0) {
                            if (F == 8) {
                                this.errCode_ = iVar.t();
                            } else if (F == 18) {
                                this.errMsg_ = iVar.E();
                            } else if (F == 26) {
                                this.payUrl_ = iVar.E();
                            } else if (F == 34) {
                                this.orderId_ = iVar.E();
                            } else if (F == 42) {
                                this.amount_ = iVar.E();
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
    }

    /* loaded from: classes2.dex */
    public interface SoundPayRespOrBuilder extends g0 {
        /* synthetic */ List<String> findInitializationErrors();

        @Override // com.google.protobuf.g0
        /* synthetic */ Map<Descriptors.FieldDescriptor, Object> getAllFields();

        String getAmount();

        ByteString getAmountBytes();

        @Override // com.google.protobuf.g0
        /* synthetic */ d0 getDefaultInstanceForType();

        @Override // com.google.protobuf.g0
        /* synthetic */ e0 getDefaultInstanceForType();

        @Override // com.google.protobuf.g0
        /* synthetic */ Descriptors.b getDescriptorForType();

        int getErrCode();

        String getErrMsg();

        ByteString getErrMsgBytes();

        @Override // com.google.protobuf.g0
        /* synthetic */ Object getField(Descriptors.FieldDescriptor fieldDescriptor);

        /* synthetic */ String getInitializationErrorString();

        /* synthetic */ Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.h hVar);

        String getOrderId();

        ByteString getOrderIdBytes();

        String getPayUrl();

        ByteString getPayUrlBytes();

        /* synthetic */ Object getRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i10);

        /* synthetic */ int getRepeatedFieldCount(Descriptors.FieldDescriptor fieldDescriptor);

        @Override // com.google.protobuf.g0
        /* synthetic */ a1 getUnknownFields();

        @Override // com.google.protobuf.g0
        /* synthetic */ boolean hasField(Descriptors.FieldDescriptor fieldDescriptor);

        /* synthetic */ boolean hasOneof(Descriptors.h hVar);

        @Override // com.google.protobuf.f0
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes2.dex */
    public enum Source implements m0 {
        ANDROID(0),
        IOS(1),
        WEB(2),
        UNRECOGNIZED(-1);
        
        public static final int ANDROID_VALUE = 0;
        public static final int IOS_VALUE = 1;
        public static final int WEB_VALUE = 2;
        private final int value;
        private static final u.b<Source> internalValueMap = new u.b<Source>() { // from class: com.mobvoi.companion.proto.PayProto.Source.1
            public Source findValueByNumber(int i10) {
                return Source.forNumber(i10);
            }
        };
        private static final Source[] VALUES = values();

        Source(int i10) {
            this.value = i10;
        }

        public static Source forNumber(int i10) {
            if (i10 == 0) {
                return ANDROID;
            }
            if (i10 == 1) {
                return IOS;
            }
            if (i10 != 2) {
                return null;
            }
            return WEB;
        }

        public static final Descriptors.d getDescriptor() {
            return PayProto.getDescriptor().i().get(1);
        }

        public static u.b<Source> internalGetValueMap() {
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
        public static Source valueOf(int i10) {
            return forNumber(i10);
        }

        public static Source valueOf(Descriptors.e eVar) {
            if (eVar.g() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            } else if (eVar.f() == -1) {
                return UNRECOGNIZED;
            } else {
                return VALUES[eVar.f()];
            }
        }
    }

    static {
        Descriptors.FileDescriptor.q(new String[]{"\n\u000fsound_pay.proto\u0012\u001acom.mobvoi.companion.proto\"d\n\fSoundPayResp\u0012\u0010\n\berr_code\u0018\u0001 \u0001(\u0005\u0012\u000f\n\u0007err_msg\u0018\u0002 \u0001(\t\u0012\u000f\n\u0007pay_url\u0018\u0003 \u0001(\t\u0012\u0010\n\border_id\u0018\u0004 \u0001(\t\u0012\u000e\n\u0006amount\u0018\u0005 \u0001(\t\"²\u0001\n\bSoundPay\u0012=\n\norder_type\u0018\u0001 \u0001(\u000e2%.com.mobvoi.companion.proto.OrderTypeB\u0002\u0018\u0001\u0012\u000e\n\u0006amount\u0018\u0002 \u0001(\t\u0012\u0012\n\nproduct_id\u0018\u0003 \u0001(\t\u00122\n\u0006source\u0018\u0004 \u0001(\u000e2\".com.mobvoi.companion.proto.Source\u0012\u000f\n\u0007payType\u0018\u0005 \u0001(\t\"4\n\u000fApplePayReceipt\u0012\u000f\n\u0007receipt\u0018\u0001 \u0001(\t\u0012\u0010\n\border_id\u0018\u0002 \u0001(\t*C\n\tOrderType\u0012\u000b\n\u0007U", "NKNOWN\u0010\u0000\u0012\f\n\bONE_HOUR\u0010\u0001\u0012\r\n\tFIVE_HOUR\u0010\u0002\u0012\f\n\bTEN_HOUR\u0010\u0003*'\n\u0006Source\u0012\u000b\n\u0007ANDROID\u0010\u0000\u0012\u0007\n\u0003IOS\u0010\u0001\u0012\u0007\n\u0003WEB\u0010\u0002B\nB\bPayProtob\u0006proto3"}, new Descriptors.FileDescriptor[0], new Descriptors.FileDescriptor.a() { // from class: com.mobvoi.companion.proto.PayProto.1
            @Override // com.google.protobuf.Descriptors.FileDescriptor.a
            public o assignDescriptors(Descriptors.FileDescriptor fileDescriptor) {
                Descriptors.FileDescriptor unused = PayProto.descriptor = fileDescriptor;
                return null;
            }
        });
        Descriptors.b bVar = getDescriptor().j().get(0);
        internal_static_com_mobvoi_companion_proto_SoundPayResp_descriptor = bVar;
        internal_static_com_mobvoi_companion_proto_SoundPayResp_fieldAccessorTable = new GeneratedMessageV3.e(bVar, new String[]{"ErrCode", "ErrMsg", "PayUrl", "OrderId", "Amount"});
        Descriptors.b bVar2 = getDescriptor().j().get(1);
        internal_static_com_mobvoi_companion_proto_SoundPay_descriptor = bVar2;
        internal_static_com_mobvoi_companion_proto_SoundPay_fieldAccessorTable = new GeneratedMessageV3.e(bVar2, new String[]{"OrderType", "Amount", "ProductId", "Source", "PayType"});
        Descriptors.b bVar3 = getDescriptor().j().get(2);
        internal_static_com_mobvoi_companion_proto_ApplePayReceipt_descriptor = bVar3;
        internal_static_com_mobvoi_companion_proto_ApplePayReceipt_fieldAccessorTable = new GeneratedMessageV3.e(bVar3, new String[]{"Receipt", "OrderId"});
    }

    private PayProto() {
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    public static void registerAllExtensions(o oVar) {
        registerAllExtensions((q) oVar);
    }

    public static void registerAllExtensions(q qVar) {
    }
}
