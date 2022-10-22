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
import com.google.protobuf.o;
import com.google.protobuf.o0;
import com.google.protobuf.q;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
/* loaded from: classes2.dex */
public final class ProductProto {
    private static Descriptors.FileDescriptor descriptor;
    private static final Descriptors.b internal_static_com_mobvoi_companion_proto_SoundProductResp_descriptor;
    private static final GeneratedMessageV3.e internal_static_com_mobvoi_companion_proto_SoundProductResp_fieldAccessorTable;
    private static final Descriptors.b internal_static_com_mobvoi_companion_proto_SoundProduct_descriptor;
    private static final GeneratedMessageV3.e internal_static_com_mobvoi_companion_proto_SoundProduct_fieldAccessorTable;

    /* loaded from: classes2.dex */
    public static final class SoundProduct extends GeneratedMessageV3 implements SoundProductOrBuilder {
        public static final int ACTUAL_PRICE_FIELD_NUMBER = 4;
        public static final int DISCOUNT_FIELD_NUMBER = 5;
        public static final int PAYMENT_TIME_FIELD_NUMBER = 7;
        public static final int PRICE_PER_HOUR_FIELD_NUMBER = 6;
        public static final int PRODUCT_ID_FIELD_NUMBER = 1;
        public static final int PRODUCT_NAME_FIELD_NUMBER = 2;
        public static final int RAW_PRICE_FIELD_NUMBER = 3;
        private static final long serialVersionUID = 0;
        private volatile Object actualPrice_;
        private volatile Object discount_;
        private byte memoizedIsInitialized;
        private int paymentTime_;
        private volatile Object pricePerHour_;
        private volatile Object productId_;
        private volatile Object productName_;
        private volatile Object rawPrice_;
        private static final SoundProduct DEFAULT_INSTANCE = new SoundProduct();
        private static final l0<SoundProduct> PARSER = new c<SoundProduct>() { // from class: com.mobvoi.companion.proto.ProductProto.SoundProduct.1
            @Override // com.google.protobuf.l0
            public SoundProduct parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
                return new SoundProduct(iVar, qVar);
            }
        };

        public static SoundProduct getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return ProductProto.internal_static_com_mobvoi_companion_proto_SoundProduct_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static SoundProduct parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (SoundProduct) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static SoundProduct parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static l0<SoundProduct> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof SoundProduct)) {
                return super.equals(obj);
            }
            SoundProduct soundProduct = (SoundProduct) obj;
            return ((((((getProductId().equals(soundProduct.getProductId())) && getProductName().equals(soundProduct.getProductName())) && getRawPrice().equals(soundProduct.getRawPrice())) && getActualPrice().equals(soundProduct.getActualPrice())) && getDiscount().equals(soundProduct.getDiscount())) && getPricePerHour().equals(soundProduct.getPricePerHour())) && getPaymentTime() == soundProduct.getPaymentTime();
        }

        @Override // com.mobvoi.companion.proto.ProductProto.SoundProductOrBuilder
        public String getActualPrice() {
            Object obj = this.actualPrice_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.actualPrice_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.proto.ProductProto.SoundProductOrBuilder
        public ByteString getActualPriceBytes() {
            Object obj = this.actualPrice_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.actualPrice_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.mobvoi.companion.proto.ProductProto.SoundProductOrBuilder
        public String getDiscount() {
            Object obj = this.discount_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.discount_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.proto.ProductProto.SoundProductOrBuilder
        public ByteString getDiscountBytes() {
            Object obj = this.discount_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.discount_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public l0<SoundProduct> getParserForType() {
            return PARSER;
        }

        @Override // com.mobvoi.companion.proto.ProductProto.SoundProductOrBuilder
        public int getPaymentTime() {
            return this.paymentTime_;
        }

        @Override // com.mobvoi.companion.proto.ProductProto.SoundProductOrBuilder
        public String getPricePerHour() {
            Object obj = this.pricePerHour_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.pricePerHour_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.proto.ProductProto.SoundProductOrBuilder
        public ByteString getPricePerHourBytes() {
            Object obj = this.pricePerHour_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.pricePerHour_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.mobvoi.companion.proto.ProductProto.SoundProductOrBuilder
        public String getProductId() {
            Object obj = this.productId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.productId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.proto.ProductProto.SoundProductOrBuilder
        public ByteString getProductIdBytes() {
            Object obj = this.productId_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.productId_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.mobvoi.companion.proto.ProductProto.SoundProductOrBuilder
        public String getProductName() {
            Object obj = this.productName_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.productName_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.proto.ProductProto.SoundProductOrBuilder
        public ByteString getProductNameBytes() {
            Object obj = this.productName_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.productName_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.mobvoi.companion.proto.ProductProto.SoundProductOrBuilder
        public String getRawPrice() {
            Object obj = this.rawPrice_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.rawPrice_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.proto.ProductProto.SoundProductOrBuilder
        public ByteString getRawPriceBytes() {
            Object obj = this.rawPrice_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.rawPrice_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
        public int getSerializedSize() {
            int i10 = this.memoizedSize;
            if (i10 != -1) {
                return i10;
            }
            int i11 = 0;
            if (!getProductIdBytes().isEmpty()) {
                i11 = 0 + GeneratedMessageV3.computeStringSize(1, this.productId_);
            }
            if (!getProductNameBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(2, this.productName_);
            }
            if (!getRawPriceBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(3, this.rawPrice_);
            }
            if (!getActualPriceBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(4, this.actualPrice_);
            }
            if (!getDiscountBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(5, this.discount_);
            }
            if (!getPricePerHourBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(6, this.pricePerHour_);
            }
            int i12 = this.paymentTime_;
            if (i12 != 0) {
                i11 += CodedOutputStream.v(7, i12);
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
            int hashCode = ((((((((((((((((((((((((((((((779 + getDescriptorForType().hashCode()) * 37) + 1) * 53) + getProductId().hashCode()) * 37) + 2) * 53) + getProductName().hashCode()) * 37) + 3) * 53) + getRawPrice().hashCode()) * 37) + 4) * 53) + getActualPrice().hashCode()) * 37) + 5) * 53) + getDiscount().hashCode()) * 37) + 6) * 53) + getPricePerHour().hashCode()) * 37) + 7) * 53) + getPaymentTime()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return ProductProto.internal_static_com_mobvoi_companion_proto_SoundProduct_fieldAccessorTable.e(SoundProduct.class, Builder.class);
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
            if (!getProductIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.productId_);
            }
            if (!getProductNameBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.productName_);
            }
            if (!getRawPriceBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 3, this.rawPrice_);
            }
            if (!getActualPriceBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 4, this.actualPrice_);
            }
            if (!getDiscountBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 5, this.discount_);
            }
            if (!getPricePerHourBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 6, this.pricePerHour_);
            }
            int i10 = this.paymentTime_;
            if (i10 != 0) {
                codedOutputStream.w0(7, i10);
            }
        }

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageV3.b<Builder> implements SoundProductOrBuilder {
            private Object actualPrice_;
            private Object discount_;
            private int paymentTime_;
            private Object pricePerHour_;
            private Object productId_;
            private Object productName_;
            private Object rawPrice_;

            public static final Descriptors.b getDescriptor() {
                return ProductProto.internal_static_com_mobvoi_companion_proto_SoundProduct_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            public Builder clearActualPrice() {
                this.actualPrice_ = SoundProduct.getDefaultInstance().getActualPrice();
                onChanged();
                return this;
            }

            public Builder clearDiscount() {
                this.discount_ = SoundProduct.getDefaultInstance().getDiscount();
                onChanged();
                return this;
            }

            public Builder clearPaymentTime() {
                this.paymentTime_ = 0;
                onChanged();
                return this;
            }

            public Builder clearPricePerHour() {
                this.pricePerHour_ = SoundProduct.getDefaultInstance().getPricePerHour();
                onChanged();
                return this;
            }

            public Builder clearProductId() {
                this.productId_ = SoundProduct.getDefaultInstance().getProductId();
                onChanged();
                return this;
            }

            public Builder clearProductName() {
                this.productName_ = SoundProduct.getDefaultInstance().getProductName();
                onChanged();
                return this;
            }

            public Builder clearRawPrice() {
                this.rawPrice_ = SoundProduct.getDefaultInstance().getRawPrice();
                onChanged();
                return this;
            }

            @Override // com.mobvoi.companion.proto.ProductProto.SoundProductOrBuilder
            public String getActualPrice() {
                Object obj = this.actualPrice_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.actualPrice_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.proto.ProductProto.SoundProductOrBuilder
            public ByteString getActualPriceBytes() {
                Object obj = this.actualPrice_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.actualPrice_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a, com.google.protobuf.g0
            public Descriptors.b getDescriptorForType() {
                return ProductProto.internal_static_com_mobvoi_companion_proto_SoundProduct_descriptor;
            }

            @Override // com.mobvoi.companion.proto.ProductProto.SoundProductOrBuilder
            public String getDiscount() {
                Object obj = this.discount_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.discount_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.proto.ProductProto.SoundProductOrBuilder
            public ByteString getDiscountBytes() {
                Object obj = this.discount_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.discount_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.mobvoi.companion.proto.ProductProto.SoundProductOrBuilder
            public int getPaymentTime() {
                return this.paymentTime_;
            }

            @Override // com.mobvoi.companion.proto.ProductProto.SoundProductOrBuilder
            public String getPricePerHour() {
                Object obj = this.pricePerHour_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.pricePerHour_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.proto.ProductProto.SoundProductOrBuilder
            public ByteString getPricePerHourBytes() {
                Object obj = this.pricePerHour_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.pricePerHour_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.mobvoi.companion.proto.ProductProto.SoundProductOrBuilder
            public String getProductId() {
                Object obj = this.productId_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.productId_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.proto.ProductProto.SoundProductOrBuilder
            public ByteString getProductIdBytes() {
                Object obj = this.productId_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.productId_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.mobvoi.companion.proto.ProductProto.SoundProductOrBuilder
            public String getProductName() {
                Object obj = this.productName_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.productName_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.proto.ProductProto.SoundProductOrBuilder
            public ByteString getProductNameBytes() {
                Object obj = this.productName_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.productName_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.mobvoi.companion.proto.ProductProto.SoundProductOrBuilder
            public String getRawPrice() {
                Object obj = this.rawPrice_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.rawPrice_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.proto.ProductProto.SoundProductOrBuilder
            public ByteString getRawPriceBytes() {
                Object obj = this.rawPrice_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.rawPrice_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return ProductProto.internal_static_com_mobvoi_companion_proto_SoundProduct_fieldAccessorTable.e(SoundProduct.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.f0
            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a
            public final Builder mergeUnknownFields(a1 a1Var) {
                return this;
            }

            public Builder setActualPrice(String str) {
                Objects.requireNonNull(str);
                this.actualPrice_ = str;
                onChanged();
                return this;
            }

            public Builder setActualPriceBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                b.checkByteStringIsUtf8(byteString);
                this.actualPrice_ = byteString;
                onChanged();
                return this;
            }

            public Builder setDiscount(String str) {
                Objects.requireNonNull(str);
                this.discount_ = str;
                onChanged();
                return this;
            }

            public Builder setDiscountBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                b.checkByteStringIsUtf8(byteString);
                this.discount_ = byteString;
                onChanged();
                return this;
            }

            public Builder setPaymentTime(int i10) {
                this.paymentTime_ = i10;
                onChanged();
                return this;
            }

            public Builder setPricePerHour(String str) {
                Objects.requireNonNull(str);
                this.pricePerHour_ = str;
                onChanged();
                return this;
            }

            public Builder setPricePerHourBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                b.checkByteStringIsUtf8(byteString);
                this.pricePerHour_ = byteString;
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

            public Builder setProductName(String str) {
                Objects.requireNonNull(str);
                this.productName_ = str;
                onChanged();
                return this;
            }

            public Builder setProductNameBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                b.checkByteStringIsUtf8(byteString);
                this.productName_ = byteString;
                onChanged();
                return this;
            }

            public Builder setRawPrice(String str) {
                Objects.requireNonNull(str);
                this.rawPrice_ = str;
                onChanged();
                return this;
            }

            public Builder setRawPriceBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                b.checkByteStringIsUtf8(byteString);
                this.rawPrice_ = byteString;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public final Builder setUnknownFields(a1 a1Var) {
                return this;
            }

            private Builder() {
                this.productId_ = "";
                this.productName_ = "";
                this.rawPrice_ = "";
                this.actualPrice_ = "";
                this.discount_ = "";
                this.pricePerHour_ = "";
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.e0.a, com.google.protobuf.d0.a
            public SoundProduct build() {
                SoundProduct buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) buildPartial);
            }

            @Override // com.google.protobuf.e0.a, com.google.protobuf.d0.a
            public SoundProduct buildPartial() {
                SoundProduct soundProduct = new SoundProduct(this);
                soundProduct.productId_ = this.productId_;
                soundProduct.productName_ = this.productName_;
                soundProduct.rawPrice_ = this.rawPrice_;
                soundProduct.actualPrice_ = this.actualPrice_;
                soundProduct.discount_ = this.discount_;
                soundProduct.pricePerHour_ = this.pricePerHour_;
                soundProduct.paymentTime_ = this.paymentTime_;
                onBuilt();
                return soundProduct;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.f0, com.google.protobuf.g0
            public SoundProduct getDefaultInstanceForType() {
                return SoundProduct.getDefaultInstance();
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
                this.productId_ = "";
                this.productName_ = "";
                this.rawPrice_ = "";
                this.actualPrice_ = "";
                this.discount_ = "";
                this.pricePerHour_ = "";
                this.paymentTime_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a, com.google.protobuf.b.a
            public Builder clone() {
                return (Builder) super.clone();
            }

            @Override // com.google.protobuf.a.AbstractC0170a, com.google.protobuf.d0.a
            public Builder mergeFrom(d0 d0Var) {
                if (d0Var instanceof SoundProduct) {
                    return mergeFrom((SoundProduct) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            public Builder mergeFrom(SoundProduct soundProduct) {
                if (soundProduct == SoundProduct.getDefaultInstance()) {
                    return this;
                }
                if (!soundProduct.getProductId().isEmpty()) {
                    this.productId_ = soundProduct.productId_;
                    onChanged();
                }
                if (!soundProduct.getProductName().isEmpty()) {
                    this.productName_ = soundProduct.productName_;
                    onChanged();
                }
                if (!soundProduct.getRawPrice().isEmpty()) {
                    this.rawPrice_ = soundProduct.rawPrice_;
                    onChanged();
                }
                if (!soundProduct.getActualPrice().isEmpty()) {
                    this.actualPrice_ = soundProduct.actualPrice_;
                    onChanged();
                }
                if (!soundProduct.getDiscount().isEmpty()) {
                    this.discount_ = soundProduct.discount_;
                    onChanged();
                }
                if (!soundProduct.getPricePerHour().isEmpty()) {
                    this.pricePerHour_ = soundProduct.pricePerHour_;
                    onChanged();
                }
                if (soundProduct.getPaymentTime() != 0) {
                    setPaymentTime(soundProduct.getPaymentTime());
                }
                onChanged();
                return this;
            }

            private Builder(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.productId_ = "";
                this.productName_ = "";
                this.rawPrice_ = "";
                this.actualPrice_ = "";
                this.discount_ = "";
                this.pricePerHour_ = "";
                maybeForceBuilderInitialization();
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x0023  */
            @Override // com.google.protobuf.a.AbstractC0170a, com.google.protobuf.b.a, com.google.protobuf.e0.a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(i iVar, q qVar) throws IOException {
                Throwable th2;
                SoundProduct soundProduct = null;
                try {
                    try {
                        SoundProduct soundProduct2 = (SoundProduct) SoundProduct.PARSER.parsePartialFrom(iVar, qVar);
                        if (soundProduct2 != null) {
                            mergeFrom(soundProduct2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e10) {
                        soundProduct = (SoundProduct) e10.getUnfinishedMessage();
                        try {
                            throw e10.unwrapIOException();
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (soundProduct != null) {
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (soundProduct != null) {
                        mergeFrom(soundProduct);
                    }
                    throw th2;
                }
            }
        }

        public static Builder newBuilder(SoundProduct soundProduct) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(soundProduct);
        }

        public static SoundProduct parseFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, qVar);
        }

        private SoundProduct(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static SoundProduct parseDelimitedFrom(InputStream inputStream, q qVar) throws IOException {
            return (SoundProduct) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
        }

        public static SoundProduct parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
        public SoundProduct getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static SoundProduct parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder newBuilderForType() {
            return newBuilder();
        }

        private SoundProduct() {
            this.memoizedIsInitialized = (byte) -1;
            this.productId_ = "";
            this.productName_ = "";
            this.rawPrice_ = "";
            this.actualPrice_ = "";
            this.discount_ = "";
            this.pricePerHour_ = "";
            this.paymentTime_ = 0;
        }

        public static SoundProduct parseFrom(InputStream inputStream) throws IOException {
            return (SoundProduct) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.c cVar) {
            return new Builder(cVar);
        }

        public static SoundProduct parseFrom(InputStream inputStream, q qVar) throws IOException {
            return (SoundProduct) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
        }

        public static SoundProduct parseFrom(i iVar) throws IOException {
            return (SoundProduct) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
        }

        public static SoundProduct parseFrom(i iVar, q qVar) throws IOException {
            return (SoundProduct) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
        }

        private SoundProduct(i iVar, q qVar) throws InvalidProtocolBufferException {
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
                                    this.productId_ = iVar.E();
                                } else if (F == 18) {
                                    this.productName_ = iVar.E();
                                } else if (F == 26) {
                                    this.rawPrice_ = iVar.E();
                                } else if (F == 34) {
                                    this.actualPrice_ = iVar.E();
                                } else if (F == 42) {
                                    this.discount_ = iVar.E();
                                } else if (F == 50) {
                                    this.pricePerHour_ = iVar.E();
                                } else if (F == 56) {
                                    this.paymentTime_ = iVar.t();
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
                    makeExtensionsImmutable();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface SoundProductOrBuilder extends g0 {
        /* synthetic */ List<String> findInitializationErrors();

        String getActualPrice();

        ByteString getActualPriceBytes();

        @Override // com.google.protobuf.g0
        /* synthetic */ Map<Descriptors.FieldDescriptor, Object> getAllFields();

        @Override // com.google.protobuf.g0
        /* synthetic */ d0 getDefaultInstanceForType();

        @Override // com.google.protobuf.g0
        /* synthetic */ e0 getDefaultInstanceForType();

        @Override // com.google.protobuf.g0
        /* synthetic */ Descriptors.b getDescriptorForType();

        String getDiscount();

        ByteString getDiscountBytes();

        @Override // com.google.protobuf.g0
        /* synthetic */ Object getField(Descriptors.FieldDescriptor fieldDescriptor);

        /* synthetic */ String getInitializationErrorString();

        /* synthetic */ Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.h hVar);

        int getPaymentTime();

        String getPricePerHour();

        ByteString getPricePerHourBytes();

        String getProductId();

        ByteString getProductIdBytes();

        String getProductName();

        ByteString getProductNameBytes();

        String getRawPrice();

        ByteString getRawPriceBytes();

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
    public static final class SoundProductResp extends GeneratedMessageV3 implements SoundProductRespOrBuilder {
        public static final int ERR_CODE_FIELD_NUMBER = 1;
        public static final int ERR_MSG_FIELD_NUMBER = 2;
        public static final int SOUND_PRODUCTS_FIELD_NUMBER = 3;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private int errCode_;
        private volatile Object errMsg_;
        private byte memoizedIsInitialized;
        private List<SoundProduct> soundProducts_;
        private static final SoundProductResp DEFAULT_INSTANCE = new SoundProductResp();
        private static final l0<SoundProductResp> PARSER = new c<SoundProductResp>() { // from class: com.mobvoi.companion.proto.ProductProto.SoundProductResp.1
            @Override // com.google.protobuf.l0
            public SoundProductResp parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
                return new SoundProductResp(iVar, qVar);
            }
        };

        public static SoundProductResp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return ProductProto.internal_static_com_mobvoi_companion_proto_SoundProductResp_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static SoundProductResp parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (SoundProductResp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static SoundProductResp parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static l0<SoundProductResp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof SoundProductResp)) {
                return super.equals(obj);
            }
            SoundProductResp soundProductResp = (SoundProductResp) obj;
            return ((getErrCode() == soundProductResp.getErrCode()) && getErrMsg().equals(soundProductResp.getErrMsg())) && getSoundProductsList().equals(soundProductResp.getSoundProductsList());
        }

        @Override // com.mobvoi.companion.proto.ProductProto.SoundProductRespOrBuilder
        public int getErrCode() {
            return this.errCode_;
        }

        @Override // com.mobvoi.companion.proto.ProductProto.SoundProductRespOrBuilder
        public String getErrMsg() {
            Object obj = this.errMsg_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.errMsg_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.proto.ProductProto.SoundProductRespOrBuilder
        public ByteString getErrMsgBytes() {
            Object obj = this.errMsg_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.errMsg_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public l0<SoundProductResp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
        public int getSerializedSize() {
            int i10 = this.memoizedSize;
            if (i10 != -1) {
                return i10;
            }
            int i11 = this.errCode_;
            int v10 = i11 != 0 ? CodedOutputStream.v(1, i11) + 0 : 0;
            if (!getErrMsgBytes().isEmpty()) {
                v10 += GeneratedMessageV3.computeStringSize(2, this.errMsg_);
            }
            for (int i12 = 0; i12 < this.soundProducts_.size(); i12++) {
                v10 += CodedOutputStream.E(3, this.soundProducts_.get(i12));
            }
            this.memoizedSize = v10;
            return v10;
        }

        @Override // com.mobvoi.companion.proto.ProductProto.SoundProductRespOrBuilder
        public SoundProduct getSoundProducts(int i10) {
            return this.soundProducts_.get(i10);
        }

        @Override // com.mobvoi.companion.proto.ProductProto.SoundProductRespOrBuilder
        public int getSoundProductsCount() {
            return this.soundProducts_.size();
        }

        @Override // com.mobvoi.companion.proto.ProductProto.SoundProductRespOrBuilder
        public List<SoundProduct> getSoundProductsList() {
            return this.soundProducts_;
        }

        @Override // com.mobvoi.companion.proto.ProductProto.SoundProductRespOrBuilder
        public SoundProductOrBuilder getSoundProductsOrBuilder(int i10) {
            return this.soundProducts_.get(i10);
        }

        @Override // com.mobvoi.companion.proto.ProductProto.SoundProductRespOrBuilder
        public List<? extends SoundProductOrBuilder> getSoundProductsOrBuilderList() {
            return this.soundProducts_;
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
            int hashCode = ((((((((779 + getDescriptorForType().hashCode()) * 37) + 1) * 53) + getErrCode()) * 37) + 2) * 53) + getErrMsg().hashCode();
            if (getSoundProductsCount() > 0) {
                hashCode = (((hashCode * 37) + 3) * 53) + getSoundProductsList().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return ProductProto.internal_static_com_mobvoi_companion_proto_SoundProductResp_fieldAccessorTable.e(SoundProductResp.class, Builder.class);
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
            for (int i11 = 0; i11 < this.soundProducts_.size(); i11++) {
                codedOutputStream.A0(3, this.soundProducts_.get(i11));
            }
        }

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageV3.b<Builder> implements SoundProductRespOrBuilder {
            private int bitField0_;
            private int errCode_;
            private Object errMsg_;
            private o0<SoundProduct, SoundProduct.Builder, SoundProductOrBuilder> soundProductsBuilder_;
            private List<SoundProduct> soundProducts_;

            private void ensureSoundProductsIsMutable() {
                if ((this.bitField0_ & 4) != 4) {
                    this.soundProducts_ = new ArrayList(this.soundProducts_);
                    this.bitField0_ |= 4;
                }
            }

            public static final Descriptors.b getDescriptor() {
                return ProductProto.internal_static_com_mobvoi_companion_proto_SoundProductResp_descriptor;
            }

            private o0<SoundProduct, SoundProduct.Builder, SoundProductOrBuilder> getSoundProductsFieldBuilder() {
                if (this.soundProductsBuilder_ == null) {
                    this.soundProductsBuilder_ = new o0<>(this.soundProducts_, (this.bitField0_ & 4) == 4, getParentForChildren(), isClean());
                    this.soundProducts_ = null;
                }
                return this.soundProductsBuilder_;
            }

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                    getSoundProductsFieldBuilder();
                }
            }

            public Builder addAllSoundProducts(Iterable<? extends SoundProduct> iterable) {
                o0<SoundProduct, SoundProduct.Builder, SoundProductOrBuilder> o0Var = this.soundProductsBuilder_;
                if (o0Var == null) {
                    ensureSoundProductsIsMutable();
                    b.a.addAll(iterable, this.soundProducts_);
                    onChanged();
                } else {
                    o0Var.b(iterable);
                }
                return this;
            }

            public Builder addSoundProducts(SoundProduct soundProduct) {
                o0<SoundProduct, SoundProduct.Builder, SoundProductOrBuilder> o0Var = this.soundProductsBuilder_;
                if (o0Var == null) {
                    Objects.requireNonNull(soundProduct);
                    ensureSoundProductsIsMutable();
                    this.soundProducts_.add(soundProduct);
                    onChanged();
                } else {
                    o0Var.f(soundProduct);
                }
                return this;
            }

            public SoundProduct.Builder addSoundProductsBuilder() {
                return getSoundProductsFieldBuilder().d(SoundProduct.getDefaultInstance());
            }

            public Builder clearErrCode() {
                this.errCode_ = 0;
                onChanged();
                return this;
            }

            public Builder clearErrMsg() {
                this.errMsg_ = SoundProductResp.getDefaultInstance().getErrMsg();
                onChanged();
                return this;
            }

            public Builder clearSoundProducts() {
                o0<SoundProduct, SoundProduct.Builder, SoundProductOrBuilder> o0Var = this.soundProductsBuilder_;
                if (o0Var == null) {
                    this.soundProducts_ = Collections.emptyList();
                    this.bitField0_ &= -5;
                    onChanged();
                } else {
                    o0Var.h();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a, com.google.protobuf.g0
            public Descriptors.b getDescriptorForType() {
                return ProductProto.internal_static_com_mobvoi_companion_proto_SoundProductResp_descriptor;
            }

            @Override // com.mobvoi.companion.proto.ProductProto.SoundProductRespOrBuilder
            public int getErrCode() {
                return this.errCode_;
            }

            @Override // com.mobvoi.companion.proto.ProductProto.SoundProductRespOrBuilder
            public String getErrMsg() {
                Object obj = this.errMsg_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.errMsg_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.proto.ProductProto.SoundProductRespOrBuilder
            public ByteString getErrMsgBytes() {
                Object obj = this.errMsg_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.errMsg_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.mobvoi.companion.proto.ProductProto.SoundProductRespOrBuilder
            public SoundProduct getSoundProducts(int i10) {
                o0<SoundProduct, SoundProduct.Builder, SoundProductOrBuilder> o0Var = this.soundProductsBuilder_;
                if (o0Var == null) {
                    return this.soundProducts_.get(i10);
                }
                return o0Var.o(i10);
            }

            public SoundProduct.Builder getSoundProductsBuilder(int i10) {
                return getSoundProductsFieldBuilder().l(i10);
            }

            public List<SoundProduct.Builder> getSoundProductsBuilderList() {
                return getSoundProductsFieldBuilder().m();
            }

            @Override // com.mobvoi.companion.proto.ProductProto.SoundProductRespOrBuilder
            public int getSoundProductsCount() {
                o0<SoundProduct, SoundProduct.Builder, SoundProductOrBuilder> o0Var = this.soundProductsBuilder_;
                if (o0Var == null) {
                    return this.soundProducts_.size();
                }
                return o0Var.n();
            }

            @Override // com.mobvoi.companion.proto.ProductProto.SoundProductRespOrBuilder
            public List<SoundProduct> getSoundProductsList() {
                o0<SoundProduct, SoundProduct.Builder, SoundProductOrBuilder> o0Var = this.soundProductsBuilder_;
                if (o0Var == null) {
                    return Collections.unmodifiableList(this.soundProducts_);
                }
                return o0Var.q();
            }

            @Override // com.mobvoi.companion.proto.ProductProto.SoundProductRespOrBuilder
            public SoundProductOrBuilder getSoundProductsOrBuilder(int i10) {
                o0<SoundProduct, SoundProduct.Builder, SoundProductOrBuilder> o0Var = this.soundProductsBuilder_;
                if (o0Var == null) {
                    return this.soundProducts_.get(i10);
                }
                return o0Var.r(i10);
            }

            @Override // com.mobvoi.companion.proto.ProductProto.SoundProductRespOrBuilder
            public List<? extends SoundProductOrBuilder> getSoundProductsOrBuilderList() {
                o0<SoundProduct, SoundProduct.Builder, SoundProductOrBuilder> o0Var = this.soundProductsBuilder_;
                if (o0Var != null) {
                    return o0Var.s();
                }
                return Collections.unmodifiableList(this.soundProducts_);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return ProductProto.internal_static_com_mobvoi_companion_proto_SoundProductResp_fieldAccessorTable.e(SoundProductResp.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.f0
            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a
            public final Builder mergeUnknownFields(a1 a1Var) {
                return this;
            }

            public Builder removeSoundProducts(int i10) {
                o0<SoundProduct, SoundProduct.Builder, SoundProductOrBuilder> o0Var = this.soundProductsBuilder_;
                if (o0Var == null) {
                    ensureSoundProductsIsMutable();
                    this.soundProducts_.remove(i10);
                    onChanged();
                } else {
                    o0Var.w(i10);
                }
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

            public Builder setSoundProducts(int i10, SoundProduct soundProduct) {
                o0<SoundProduct, SoundProduct.Builder, SoundProductOrBuilder> o0Var = this.soundProductsBuilder_;
                if (o0Var == null) {
                    Objects.requireNonNull(soundProduct);
                    ensureSoundProductsIsMutable();
                    this.soundProducts_.set(i10, soundProduct);
                    onChanged();
                } else {
                    o0Var.x(i10, soundProduct);
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public final Builder setUnknownFields(a1 a1Var) {
                return this;
            }

            private Builder() {
                this.errMsg_ = "";
                this.soundProducts_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.e0.a, com.google.protobuf.d0.a
            public SoundProductResp build() {
                SoundProductResp buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) buildPartial);
            }

            @Override // com.google.protobuf.e0.a, com.google.protobuf.d0.a
            public SoundProductResp buildPartial() {
                SoundProductResp soundProductResp = new SoundProductResp(this);
                soundProductResp.errCode_ = this.errCode_;
                soundProductResp.errMsg_ = this.errMsg_;
                o0<SoundProduct, SoundProduct.Builder, SoundProductOrBuilder> o0Var = this.soundProductsBuilder_;
                if (o0Var == null) {
                    if ((this.bitField0_ & 4) == 4) {
                        this.soundProducts_ = Collections.unmodifiableList(this.soundProducts_);
                        this.bitField0_ &= -5;
                    }
                    soundProductResp.soundProducts_ = this.soundProducts_;
                } else {
                    soundProductResp.soundProducts_ = o0Var.g();
                }
                soundProductResp.bitField0_ = 0;
                onBuilt();
                return soundProductResp;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.f0, com.google.protobuf.g0
            public SoundProductResp getDefaultInstanceForType() {
                return SoundProductResp.getDefaultInstance();
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

            public SoundProduct.Builder addSoundProductsBuilder(int i10) {
                return getSoundProductsFieldBuilder().c(i10, SoundProduct.getDefaultInstance());
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
                o0<SoundProduct, SoundProduct.Builder, SoundProductOrBuilder> o0Var = this.soundProductsBuilder_;
                if (o0Var == null) {
                    this.soundProducts_ = Collections.emptyList();
                    this.bitField0_ &= -5;
                } else {
                    o0Var.h();
                }
                return this;
            }

            private Builder(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.errMsg_ = "";
                this.soundProducts_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            public Builder addSoundProducts(int i10, SoundProduct soundProduct) {
                o0<SoundProduct, SoundProduct.Builder, SoundProductOrBuilder> o0Var = this.soundProductsBuilder_;
                if (o0Var == null) {
                    Objects.requireNonNull(soundProduct);
                    ensureSoundProductsIsMutable();
                    this.soundProducts_.add(i10, soundProduct);
                    onChanged();
                } else {
                    o0Var.e(i10, soundProduct);
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a, com.google.protobuf.b.a
            public Builder clone() {
                return (Builder) super.clone();
            }

            @Override // com.google.protobuf.a.AbstractC0170a, com.google.protobuf.d0.a
            public Builder mergeFrom(d0 d0Var) {
                if (d0Var instanceof SoundProductResp) {
                    return mergeFrom((SoundProductResp) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            public Builder setSoundProducts(int i10, SoundProduct.Builder builder) {
                o0<SoundProduct, SoundProduct.Builder, SoundProductOrBuilder> o0Var = this.soundProductsBuilder_;
                if (o0Var == null) {
                    ensureSoundProductsIsMutable();
                    this.soundProducts_.set(i10, builder.build());
                    onChanged();
                } else {
                    o0Var.x(i10, builder.build());
                }
                return this;
            }

            public Builder mergeFrom(SoundProductResp soundProductResp) {
                if (soundProductResp == SoundProductResp.getDefaultInstance()) {
                    return this;
                }
                if (soundProductResp.getErrCode() != 0) {
                    setErrCode(soundProductResp.getErrCode());
                }
                if (!soundProductResp.getErrMsg().isEmpty()) {
                    this.errMsg_ = soundProductResp.errMsg_;
                    onChanged();
                }
                if (this.soundProductsBuilder_ == null) {
                    if (!soundProductResp.soundProducts_.isEmpty()) {
                        if (this.soundProducts_.isEmpty()) {
                            this.soundProducts_ = soundProductResp.soundProducts_;
                            this.bitField0_ &= -5;
                        } else {
                            ensureSoundProductsIsMutable();
                            this.soundProducts_.addAll(soundProductResp.soundProducts_);
                        }
                        onChanged();
                    }
                } else if (!soundProductResp.soundProducts_.isEmpty()) {
                    if (this.soundProductsBuilder_.u()) {
                        this.soundProductsBuilder_.i();
                        o0<SoundProduct, SoundProduct.Builder, SoundProductOrBuilder> o0Var = null;
                        this.soundProductsBuilder_ = null;
                        this.soundProducts_ = soundProductResp.soundProducts_;
                        this.bitField0_ &= -5;
                        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                            o0Var = getSoundProductsFieldBuilder();
                        }
                        this.soundProductsBuilder_ = o0Var;
                    } else {
                        this.soundProductsBuilder_.b(soundProductResp.soundProducts_);
                    }
                }
                onChanged();
                return this;
            }

            public Builder addSoundProducts(SoundProduct.Builder builder) {
                o0<SoundProduct, SoundProduct.Builder, SoundProductOrBuilder> o0Var = this.soundProductsBuilder_;
                if (o0Var == null) {
                    ensureSoundProductsIsMutable();
                    this.soundProducts_.add(builder.build());
                    onChanged();
                } else {
                    o0Var.f(builder.build());
                }
                return this;
            }

            public Builder addSoundProducts(int i10, SoundProduct.Builder builder) {
                o0<SoundProduct, SoundProduct.Builder, SoundProductOrBuilder> o0Var = this.soundProductsBuilder_;
                if (o0Var == null) {
                    ensureSoundProductsIsMutable();
                    this.soundProducts_.add(i10, builder.build());
                    onChanged();
                } else {
                    o0Var.e(i10, builder.build());
                }
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x0023  */
            @Override // com.google.protobuf.a.AbstractC0170a, com.google.protobuf.b.a, com.google.protobuf.e0.a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(i iVar, q qVar) throws IOException {
                Throwable th2;
                SoundProductResp soundProductResp = null;
                try {
                    try {
                        SoundProductResp soundProductResp2 = (SoundProductResp) SoundProductResp.PARSER.parsePartialFrom(iVar, qVar);
                        if (soundProductResp2 != null) {
                            mergeFrom(soundProductResp2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e10) {
                        soundProductResp = (SoundProductResp) e10.getUnfinishedMessage();
                        try {
                            throw e10.unwrapIOException();
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (soundProductResp != null) {
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (soundProductResp != null) {
                        mergeFrom(soundProductResp);
                    }
                    throw th2;
                }
            }
        }

        public static Builder newBuilder(SoundProductResp soundProductResp) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(soundProductResp);
        }

        public static SoundProductResp parseFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, qVar);
        }

        private SoundProductResp(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static SoundProductResp parseDelimitedFrom(InputStream inputStream, q qVar) throws IOException {
            return (SoundProductResp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
        }

        public static SoundProductResp parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
        public SoundProductResp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static SoundProductResp parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder newBuilderForType() {
            return newBuilder();
        }

        private SoundProductResp() {
            this.memoizedIsInitialized = (byte) -1;
            this.errCode_ = 0;
            this.errMsg_ = "";
            this.soundProducts_ = Collections.emptyList();
        }

        public static SoundProductResp parseFrom(InputStream inputStream) throws IOException {
            return (SoundProductResp) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.c cVar) {
            return new Builder(cVar);
        }

        public static SoundProductResp parseFrom(InputStream inputStream, q qVar) throws IOException {
            return (SoundProductResp) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
        }

        public static SoundProductResp parseFrom(i iVar) throws IOException {
            return (SoundProductResp) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
        }

        private SoundProductResp(i iVar, q qVar) throws InvalidProtocolBufferException {
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
                            if (F == 8) {
                                this.errCode_ = iVar.t();
                            } else if (F == 18) {
                                this.errMsg_ = iVar.E();
                            } else if (F == 26) {
                                if (!(z11 & true)) {
                                    this.soundProducts_ = new ArrayList();
                                    z11 |= true;
                                }
                                this.soundProducts_.add((SoundProduct) iVar.v(SoundProduct.parser(), qVar));
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
                        this.soundProducts_ = Collections.unmodifiableList(this.soundProducts_);
                    }
                    makeExtensionsImmutable();
                }
            }
        }

        public static SoundProductResp parseFrom(i iVar, q qVar) throws IOException {
            return (SoundProductResp) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
        }
    }

    /* loaded from: classes2.dex */
    public interface SoundProductRespOrBuilder extends g0 {
        /* synthetic */ List<String> findInitializationErrors();

        @Override // com.google.protobuf.g0
        /* synthetic */ Map<Descriptors.FieldDescriptor, Object> getAllFields();

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

        /* synthetic */ Object getRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i10);

        /* synthetic */ int getRepeatedFieldCount(Descriptors.FieldDescriptor fieldDescriptor);

        SoundProduct getSoundProducts(int i10);

        int getSoundProductsCount();

        List<SoundProduct> getSoundProductsList();

        SoundProductOrBuilder getSoundProductsOrBuilder(int i10);

        List<? extends SoundProductOrBuilder> getSoundProductsOrBuilderList();

        @Override // com.google.protobuf.g0
        /* synthetic */ a1 getUnknownFields();

        @Override // com.google.protobuf.g0
        /* synthetic */ boolean hasField(Descriptors.FieldDescriptor fieldDescriptor);

        /* synthetic */ boolean hasOneof(Descriptors.h hVar);

        @Override // com.google.protobuf.f0
        /* synthetic */ boolean isInitialized();
    }

    static {
        Descriptors.FileDescriptor.q(new String[]{"\n\u0013sound_product.proto\u0012\u001acom.mobvoi.companion.proto\"w\n\u0010SoundProductResp\u0012\u0010\n\berr_code\u0018\u0001 \u0001(\u0005\u0012\u000f\n\u0007err_msg\u0018\u0002 \u0001(\t\u0012@\n\u000esound_products\u0018\u0003 \u0003(\u000b2(.com.mobvoi.companion.proto.SoundProduct\"¡\u0001\n\fSoundProduct\u0012\u0012\n\nproduct_id\u0018\u0001 \u0001(\t\u0012\u0014\n\fproduct_name\u0018\u0002 \u0001(\t\u0012\u0011\n\traw_price\u0018\u0003 \u0001(\t\u0012\u0014\n\factual_price\u0018\u0004 \u0001(\t\u0012\u0010\n\bdiscount\u0018\u0005 \u0001(\t\u0012\u0016\n\u000eprice_per_hour\u0018\u0006 \u0001(\t\u0012\u0014\n\fpayment_time\u0018\u0007 \u0001(\u0005B\u000eB\fProductProtob\u0006proto3"}, new Descriptors.FileDescriptor[0], new Descriptors.FileDescriptor.a() { // from class: com.mobvoi.companion.proto.ProductProto.1
            @Override // com.google.protobuf.Descriptors.FileDescriptor.a
            public o assignDescriptors(Descriptors.FileDescriptor fileDescriptor) {
                Descriptors.FileDescriptor unused = ProductProto.descriptor = fileDescriptor;
                return null;
            }
        });
        Descriptors.b bVar = getDescriptor().j().get(0);
        internal_static_com_mobvoi_companion_proto_SoundProductResp_descriptor = bVar;
        internal_static_com_mobvoi_companion_proto_SoundProductResp_fieldAccessorTable = new GeneratedMessageV3.e(bVar, new String[]{"ErrCode", "ErrMsg", "SoundProducts"});
        Descriptors.b bVar2 = getDescriptor().j().get(1);
        internal_static_com_mobvoi_companion_proto_SoundProduct_descriptor = bVar2;
        internal_static_com_mobvoi_companion_proto_SoundProduct_fieldAccessorTable = new GeneratedMessageV3.e(bVar2, new String[]{"ProductId", "ProductName", "RawPrice", "ActualPrice", "Discount", "PricePerHour", "PaymentTime"});
    }

    private ProductProto() {
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
