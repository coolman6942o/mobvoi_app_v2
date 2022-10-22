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
import com.google.protobuf.u;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
/* loaded from: classes2.dex */
public final class SoundConverDurationProto {
    private static Descriptors.FileDescriptor descriptor;
    private static final Descriptors.b internal_static_com_mobvoi_companion_proto_SoundConverDurationResp_descriptor;
    private static final GeneratedMessageV3.e internal_static_com_mobvoi_companion_proto_SoundConverDurationResp_fieldAccessorTable;
    private static final Descriptors.b internal_static_com_mobvoi_companion_proto_SoundConverDuration_descriptor;
    private static final GeneratedMessageV3.e internal_static_com_mobvoi_companion_proto_SoundConverDuration_fieldAccessorTable;

    /* loaded from: classes2.dex */
    public static final class SoundConverDuration extends GeneratedMessageV3 implements SoundConverDurationOrBuilder {
        public static final int CARD_ID_FIELD_NUMBER = 2;
        public static final int CREATED_AT_FIELD_NUMBER = 6;
        public static final int EXPIRED_AT_FIELD_NUMBER = 5;
        public static final int REMAINING_DURATION_FIELD_NUMBER = 4;
        public static final int STATUS_FIELD_NUMBER = 7;
        public static final int TOTAL_DURATION_FIELD_NUMBER = 3;
        public static final int TYPE_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private volatile Object cardId_;
        private long createdAt_;
        private long expiredAt_;
        private byte memoizedIsInitialized;
        private long remainingDuration_;
        private volatile Object status_;
        private long totalDuration_;
        private int type_;
        private static final SoundConverDuration DEFAULT_INSTANCE = new SoundConverDuration();
        private static final l0<SoundConverDuration> PARSER = new c<SoundConverDuration>() { // from class: com.mobvoi.companion.proto.SoundConverDurationProto.SoundConverDuration.1
            @Override // com.google.protobuf.l0
            public SoundConverDuration parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
                return new SoundConverDuration(iVar, qVar);
            }
        };

        public static SoundConverDuration getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return SoundConverDurationProto.internal_static_com_mobvoi_companion_proto_SoundConverDuration_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static SoundConverDuration parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (SoundConverDuration) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static SoundConverDuration parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static l0<SoundConverDuration> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof SoundConverDuration)) {
                return super.equals(obj);
            }
            SoundConverDuration soundConverDuration = (SoundConverDuration) obj;
            return ((((((getType() == soundConverDuration.getType()) && getCardId().equals(soundConverDuration.getCardId())) && (getTotalDuration() > soundConverDuration.getTotalDuration() ? 1 : (getTotalDuration() == soundConverDuration.getTotalDuration() ? 0 : -1)) == 0) && (getRemainingDuration() > soundConverDuration.getRemainingDuration() ? 1 : (getRemainingDuration() == soundConverDuration.getRemainingDuration() ? 0 : -1)) == 0) && (getExpiredAt() > soundConverDuration.getExpiredAt() ? 1 : (getExpiredAt() == soundConverDuration.getExpiredAt() ? 0 : -1)) == 0) && (getCreatedAt() > soundConverDuration.getCreatedAt() ? 1 : (getCreatedAt() == soundConverDuration.getCreatedAt() ? 0 : -1)) == 0) && getStatus().equals(soundConverDuration.getStatus());
        }

        @Override // com.mobvoi.companion.proto.SoundConverDurationProto.SoundConverDurationOrBuilder
        public String getCardId() {
            Object obj = this.cardId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.cardId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.proto.SoundConverDurationProto.SoundConverDurationOrBuilder
        public ByteString getCardIdBytes() {
            Object obj = this.cardId_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.cardId_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.mobvoi.companion.proto.SoundConverDurationProto.SoundConverDurationOrBuilder
        public long getCreatedAt() {
            return this.createdAt_;
        }

        @Override // com.mobvoi.companion.proto.SoundConverDurationProto.SoundConverDurationOrBuilder
        public long getExpiredAt() {
            return this.expiredAt_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public l0<SoundConverDuration> getParserForType() {
            return PARSER;
        }

        @Override // com.mobvoi.companion.proto.SoundConverDurationProto.SoundConverDurationOrBuilder
        public long getRemainingDuration() {
            return this.remainingDuration_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
        public int getSerializedSize() {
            int i10 = this.memoizedSize;
            if (i10 != -1) {
                return i10;
            }
            int i11 = 0;
            int i12 = this.type_;
            if (i12 != 0) {
                i11 = 0 + CodedOutputStream.v(1, i12);
            }
            if (!getCardIdBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(2, this.cardId_);
            }
            long j10 = this.totalDuration_;
            if (j10 != 0) {
                i11 += CodedOutputStream.x(3, j10);
            }
            long j11 = this.remainingDuration_;
            if (j11 != 0) {
                i11 += CodedOutputStream.x(4, j11);
            }
            long j12 = this.expiredAt_;
            if (j12 != 0) {
                i11 += CodedOutputStream.x(5, j12);
            }
            long j13 = this.createdAt_;
            if (j13 != 0) {
                i11 += CodedOutputStream.x(6, j13);
            }
            if (!getStatusBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(7, this.status_);
            }
            this.memoizedSize = i11;
            return i11;
        }

        @Override // com.mobvoi.companion.proto.SoundConverDurationProto.SoundConverDurationOrBuilder
        public String getStatus() {
            Object obj = this.status_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.status_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.proto.SoundConverDurationProto.SoundConverDurationOrBuilder
        public ByteString getStatusBytes() {
            Object obj = this.status_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.status_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.mobvoi.companion.proto.SoundConverDurationProto.SoundConverDurationOrBuilder
        public long getTotalDuration() {
            return this.totalDuration_;
        }

        @Override // com.mobvoi.companion.proto.SoundConverDurationProto.SoundConverDurationOrBuilder
        public int getType() {
            return this.type_;
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
            int hashCode = ((((((((((((((((((((((((((((((779 + getDescriptorForType().hashCode()) * 37) + 1) * 53) + getType()) * 37) + 2) * 53) + getCardId().hashCode()) * 37) + 3) * 53) + u.h(getTotalDuration())) * 37) + 4) * 53) + u.h(getRemainingDuration())) * 37) + 5) * 53) + u.h(getExpiredAt())) * 37) + 6) * 53) + u.h(getCreatedAt())) * 37) + 7) * 53) + getStatus().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return SoundConverDurationProto.internal_static_com_mobvoi_companion_proto_SoundConverDuration_fieldAccessorTable.e(SoundConverDuration.class, Builder.class);
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
            int i10 = this.type_;
            if (i10 != 0) {
                codedOutputStream.w0(1, i10);
            }
            if (!getCardIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.cardId_);
            }
            long j10 = this.totalDuration_;
            if (j10 != 0) {
                codedOutputStream.y0(3, j10);
            }
            long j11 = this.remainingDuration_;
            if (j11 != 0) {
                codedOutputStream.y0(4, j11);
            }
            long j12 = this.expiredAt_;
            if (j12 != 0) {
                codedOutputStream.y0(5, j12);
            }
            long j13 = this.createdAt_;
            if (j13 != 0) {
                codedOutputStream.y0(6, j13);
            }
            if (!getStatusBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 7, this.status_);
            }
        }

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageV3.b<Builder> implements SoundConverDurationOrBuilder {
            private Object cardId_;
            private long createdAt_;
            private long expiredAt_;
            private long remainingDuration_;
            private Object status_;
            private long totalDuration_;
            private int type_;

            public static final Descriptors.b getDescriptor() {
                return SoundConverDurationProto.internal_static_com_mobvoi_companion_proto_SoundConverDuration_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            public Builder clearCardId() {
                this.cardId_ = SoundConverDuration.getDefaultInstance().getCardId();
                onChanged();
                return this;
            }

            public Builder clearCreatedAt() {
                this.createdAt_ = 0L;
                onChanged();
                return this;
            }

            public Builder clearExpiredAt() {
                this.expiredAt_ = 0L;
                onChanged();
                return this;
            }

            public Builder clearRemainingDuration() {
                this.remainingDuration_ = 0L;
                onChanged();
                return this;
            }

            public Builder clearStatus() {
                this.status_ = SoundConverDuration.getDefaultInstance().getStatus();
                onChanged();
                return this;
            }

            public Builder clearTotalDuration() {
                this.totalDuration_ = 0L;
                onChanged();
                return this;
            }

            public Builder clearType() {
                this.type_ = 0;
                onChanged();
                return this;
            }

            @Override // com.mobvoi.companion.proto.SoundConverDurationProto.SoundConverDurationOrBuilder
            public String getCardId() {
                Object obj = this.cardId_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.cardId_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.proto.SoundConverDurationProto.SoundConverDurationOrBuilder
            public ByteString getCardIdBytes() {
                Object obj = this.cardId_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.cardId_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.mobvoi.companion.proto.SoundConverDurationProto.SoundConverDurationOrBuilder
            public long getCreatedAt() {
                return this.createdAt_;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a, com.google.protobuf.g0
            public Descriptors.b getDescriptorForType() {
                return SoundConverDurationProto.internal_static_com_mobvoi_companion_proto_SoundConverDuration_descriptor;
            }

            @Override // com.mobvoi.companion.proto.SoundConverDurationProto.SoundConverDurationOrBuilder
            public long getExpiredAt() {
                return this.expiredAt_;
            }

            @Override // com.mobvoi.companion.proto.SoundConverDurationProto.SoundConverDurationOrBuilder
            public long getRemainingDuration() {
                return this.remainingDuration_;
            }

            @Override // com.mobvoi.companion.proto.SoundConverDurationProto.SoundConverDurationOrBuilder
            public String getStatus() {
                Object obj = this.status_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.status_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.proto.SoundConverDurationProto.SoundConverDurationOrBuilder
            public ByteString getStatusBytes() {
                Object obj = this.status_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.status_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.mobvoi.companion.proto.SoundConverDurationProto.SoundConverDurationOrBuilder
            public long getTotalDuration() {
                return this.totalDuration_;
            }

            @Override // com.mobvoi.companion.proto.SoundConverDurationProto.SoundConverDurationOrBuilder
            public int getType() {
                return this.type_;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return SoundConverDurationProto.internal_static_com_mobvoi_companion_proto_SoundConverDuration_fieldAccessorTable.e(SoundConverDuration.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.f0
            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a
            public final Builder mergeUnknownFields(a1 a1Var) {
                return this;
            }

            public Builder setCardId(String str) {
                Objects.requireNonNull(str);
                this.cardId_ = str;
                onChanged();
                return this;
            }

            public Builder setCardIdBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                b.checkByteStringIsUtf8(byteString);
                this.cardId_ = byteString;
                onChanged();
                return this;
            }

            public Builder setCreatedAt(long j10) {
                this.createdAt_ = j10;
                onChanged();
                return this;
            }

            public Builder setExpiredAt(long j10) {
                this.expiredAt_ = j10;
                onChanged();
                return this;
            }

            public Builder setRemainingDuration(long j10) {
                this.remainingDuration_ = j10;
                onChanged();
                return this;
            }

            public Builder setStatus(String str) {
                Objects.requireNonNull(str);
                this.status_ = str;
                onChanged();
                return this;
            }

            public Builder setStatusBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                b.checkByteStringIsUtf8(byteString);
                this.status_ = byteString;
                onChanged();
                return this;
            }

            public Builder setTotalDuration(long j10) {
                this.totalDuration_ = j10;
                onChanged();
                return this;
            }

            public Builder setType(int i10) {
                this.type_ = i10;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public final Builder setUnknownFields(a1 a1Var) {
                return this;
            }

            private Builder() {
                this.cardId_ = "";
                this.status_ = "";
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.e0.a, com.google.protobuf.d0.a
            public SoundConverDuration build() {
                SoundConverDuration buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) buildPartial);
            }

            @Override // com.google.protobuf.e0.a, com.google.protobuf.d0.a
            public SoundConverDuration buildPartial() {
                SoundConverDuration soundConverDuration = new SoundConverDuration(this);
                soundConverDuration.type_ = this.type_;
                soundConverDuration.cardId_ = this.cardId_;
                soundConverDuration.totalDuration_ = this.totalDuration_;
                soundConverDuration.remainingDuration_ = this.remainingDuration_;
                soundConverDuration.expiredAt_ = this.expiredAt_;
                soundConverDuration.createdAt_ = this.createdAt_;
                soundConverDuration.status_ = this.status_;
                onBuilt();
                return soundConverDuration;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.f0, com.google.protobuf.g0
            public SoundConverDuration getDefaultInstanceForType() {
                return SoundConverDuration.getDefaultInstance();
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
                this.type_ = 0;
                this.cardId_ = "";
                this.totalDuration_ = 0L;
                this.remainingDuration_ = 0L;
                this.expiredAt_ = 0L;
                this.createdAt_ = 0L;
                this.status_ = "";
                return this;
            }

            private Builder(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.cardId_ = "";
                this.status_ = "";
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a, com.google.protobuf.b.a
            public Builder clone() {
                return (Builder) super.clone();
            }

            @Override // com.google.protobuf.a.AbstractC0170a, com.google.protobuf.d0.a
            public Builder mergeFrom(d0 d0Var) {
                if (d0Var instanceof SoundConverDuration) {
                    return mergeFrom((SoundConverDuration) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            public Builder mergeFrom(SoundConverDuration soundConverDuration) {
                if (soundConverDuration == SoundConverDuration.getDefaultInstance()) {
                    return this;
                }
                if (soundConverDuration.getType() != 0) {
                    setType(soundConverDuration.getType());
                }
                if (!soundConverDuration.getCardId().isEmpty()) {
                    this.cardId_ = soundConverDuration.cardId_;
                    onChanged();
                }
                if (soundConverDuration.getTotalDuration() != 0) {
                    setTotalDuration(soundConverDuration.getTotalDuration());
                }
                if (soundConverDuration.getRemainingDuration() != 0) {
                    setRemainingDuration(soundConverDuration.getRemainingDuration());
                }
                if (soundConverDuration.getExpiredAt() != 0) {
                    setExpiredAt(soundConverDuration.getExpiredAt());
                }
                if (soundConverDuration.getCreatedAt() != 0) {
                    setCreatedAt(soundConverDuration.getCreatedAt());
                }
                if (!soundConverDuration.getStatus().isEmpty()) {
                    this.status_ = soundConverDuration.status_;
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
                SoundConverDuration soundConverDuration = null;
                try {
                    try {
                        SoundConverDuration soundConverDuration2 = (SoundConverDuration) SoundConverDuration.PARSER.parsePartialFrom(iVar, qVar);
                        if (soundConverDuration2 != null) {
                            mergeFrom(soundConverDuration2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e10) {
                        soundConverDuration = (SoundConverDuration) e10.getUnfinishedMessage();
                        try {
                            throw e10.unwrapIOException();
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (soundConverDuration != null) {
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (soundConverDuration != null) {
                        mergeFrom(soundConverDuration);
                    }
                    throw th2;
                }
            }
        }

        public static Builder newBuilder(SoundConverDuration soundConverDuration) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(soundConverDuration);
        }

        public static SoundConverDuration parseFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, qVar);
        }

        private SoundConverDuration(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static SoundConverDuration parseDelimitedFrom(InputStream inputStream, q qVar) throws IOException {
            return (SoundConverDuration) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
        }

        public static SoundConverDuration parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
        public SoundConverDuration getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static SoundConverDuration parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder newBuilderForType() {
            return newBuilder();
        }

        private SoundConverDuration() {
            this.memoizedIsInitialized = (byte) -1;
            this.type_ = 0;
            this.cardId_ = "";
            this.totalDuration_ = 0L;
            this.remainingDuration_ = 0L;
            this.expiredAt_ = 0L;
            this.createdAt_ = 0L;
            this.status_ = "";
        }

        public static SoundConverDuration parseFrom(InputStream inputStream) throws IOException {
            return (SoundConverDuration) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.c cVar) {
            return new Builder(cVar);
        }

        public static SoundConverDuration parseFrom(InputStream inputStream, q qVar) throws IOException {
            return (SoundConverDuration) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
        }

        public static SoundConverDuration parseFrom(i iVar) throws IOException {
            return (SoundConverDuration) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
        }

        public static SoundConverDuration parseFrom(i iVar, q qVar) throws IOException {
            return (SoundConverDuration) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
        }

        private SoundConverDuration(i iVar, q qVar) throws InvalidProtocolBufferException {
            this();
            boolean z10 = false;
            while (!z10) {
                try {
                    try {
                        try {
                            int F = iVar.F();
                            z10 = true;
                            if (F != 0) {
                                if (F == 8) {
                                    this.type_ = iVar.t();
                                } else if (F == 18) {
                                    this.cardId_ = iVar.E();
                                } else if (F == 24) {
                                    this.totalDuration_ = iVar.u();
                                } else if (F == 32) {
                                    this.remainingDuration_ = iVar.u();
                                } else if (F == 40) {
                                    this.expiredAt_ = iVar.u();
                                } else if (F == 48) {
                                    this.createdAt_ = iVar.u();
                                } else if (F == 58) {
                                    this.status_ = iVar.E();
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
    public interface SoundConverDurationOrBuilder extends g0 {
        /* synthetic */ List<String> findInitializationErrors();

        @Override // com.google.protobuf.g0
        /* synthetic */ Map<Descriptors.FieldDescriptor, Object> getAllFields();

        String getCardId();

        ByteString getCardIdBytes();

        long getCreatedAt();

        @Override // com.google.protobuf.g0
        /* synthetic */ d0 getDefaultInstanceForType();

        @Override // com.google.protobuf.g0
        /* synthetic */ e0 getDefaultInstanceForType();

        @Override // com.google.protobuf.g0
        /* synthetic */ Descriptors.b getDescriptorForType();

        long getExpiredAt();

        @Override // com.google.protobuf.g0
        /* synthetic */ Object getField(Descriptors.FieldDescriptor fieldDescriptor);

        /* synthetic */ String getInitializationErrorString();

        /* synthetic */ Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.h hVar);

        long getRemainingDuration();

        /* synthetic */ Object getRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i10);

        /* synthetic */ int getRepeatedFieldCount(Descriptors.FieldDescriptor fieldDescriptor);

        String getStatus();

        ByteString getStatusBytes();

        long getTotalDuration();

        int getType();

        @Override // com.google.protobuf.g0
        /* synthetic */ a1 getUnknownFields();

        @Override // com.google.protobuf.g0
        /* synthetic */ boolean hasField(Descriptors.FieldDescriptor fieldDescriptor);

        /* synthetic */ boolean hasOneof(Descriptors.h hVar);

        @Override // com.google.protobuf.f0
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes2.dex */
    public static final class SoundConverDurationResp extends GeneratedMessageV3 implements SoundConverDurationRespOrBuilder {
        public static final int ERR_CODE_FIELD_NUMBER = 1;
        public static final int ERR_MSG_FIELD_NUMBER = 2;
        public static final int REMAIN_DURATION_FIELD_NUMBER = 3;
        public static final int SOUND_CONVER_DURATION_FIELD_NUMBER = 4;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private int errCode_;
        private volatile Object errMsg_;
        private byte memoizedIsInitialized;
        private long remainDuration_;
        private List<SoundConverDuration> soundConverDuration_;
        private static final SoundConverDurationResp DEFAULT_INSTANCE = new SoundConverDurationResp();
        private static final l0<SoundConverDurationResp> PARSER = new c<SoundConverDurationResp>() { // from class: com.mobvoi.companion.proto.SoundConverDurationProto.SoundConverDurationResp.1
            @Override // com.google.protobuf.l0
            public SoundConverDurationResp parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
                return new SoundConverDurationResp(iVar, qVar);
            }
        };

        public static SoundConverDurationResp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return SoundConverDurationProto.internal_static_com_mobvoi_companion_proto_SoundConverDurationResp_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static SoundConverDurationResp parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (SoundConverDurationResp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static SoundConverDurationResp parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static l0<SoundConverDurationResp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof SoundConverDurationResp)) {
                return super.equals(obj);
            }
            SoundConverDurationResp soundConverDurationResp = (SoundConverDurationResp) obj;
            return (((getErrCode() == soundConverDurationResp.getErrCode()) && getErrMsg().equals(soundConverDurationResp.getErrMsg())) && (getRemainDuration() > soundConverDurationResp.getRemainDuration() ? 1 : (getRemainDuration() == soundConverDurationResp.getRemainDuration() ? 0 : -1)) == 0) && getSoundConverDurationList().equals(soundConverDurationResp.getSoundConverDurationList());
        }

        @Override // com.mobvoi.companion.proto.SoundConverDurationProto.SoundConverDurationRespOrBuilder
        public int getErrCode() {
            return this.errCode_;
        }

        @Override // com.mobvoi.companion.proto.SoundConverDurationProto.SoundConverDurationRespOrBuilder
        public String getErrMsg() {
            Object obj = this.errMsg_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.errMsg_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.proto.SoundConverDurationProto.SoundConverDurationRespOrBuilder
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
        public l0<SoundConverDurationResp> getParserForType() {
            return PARSER;
        }

        @Override // com.mobvoi.companion.proto.SoundConverDurationProto.SoundConverDurationRespOrBuilder
        public long getRemainDuration() {
            return this.remainDuration_;
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
            long j10 = this.remainDuration_;
            if (j10 != 0) {
                v10 += CodedOutputStream.x(3, j10);
            }
            for (int i12 = 0; i12 < this.soundConverDuration_.size(); i12++) {
                v10 += CodedOutputStream.E(4, this.soundConverDuration_.get(i12));
            }
            this.memoizedSize = v10;
            return v10;
        }

        @Override // com.mobvoi.companion.proto.SoundConverDurationProto.SoundConverDurationRespOrBuilder
        public SoundConverDuration getSoundConverDuration(int i10) {
            return this.soundConverDuration_.get(i10);
        }

        @Override // com.mobvoi.companion.proto.SoundConverDurationProto.SoundConverDurationRespOrBuilder
        public int getSoundConverDurationCount() {
            return this.soundConverDuration_.size();
        }

        @Override // com.mobvoi.companion.proto.SoundConverDurationProto.SoundConverDurationRespOrBuilder
        public List<SoundConverDuration> getSoundConverDurationList() {
            return this.soundConverDuration_;
        }

        @Override // com.mobvoi.companion.proto.SoundConverDurationProto.SoundConverDurationRespOrBuilder
        public SoundConverDurationOrBuilder getSoundConverDurationOrBuilder(int i10) {
            return this.soundConverDuration_.get(i10);
        }

        @Override // com.mobvoi.companion.proto.SoundConverDurationProto.SoundConverDurationRespOrBuilder
        public List<? extends SoundConverDurationOrBuilder> getSoundConverDurationOrBuilderList() {
            return this.soundConverDuration_;
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
            int hashCode = ((((((((((((779 + getDescriptorForType().hashCode()) * 37) + 1) * 53) + getErrCode()) * 37) + 2) * 53) + getErrMsg().hashCode()) * 37) + 3) * 53) + u.h(getRemainDuration());
            if (getSoundConverDurationCount() > 0) {
                hashCode = (((hashCode * 37) + 4) * 53) + getSoundConverDurationList().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return SoundConverDurationProto.internal_static_com_mobvoi_companion_proto_SoundConverDurationResp_fieldAccessorTable.e(SoundConverDurationResp.class, Builder.class);
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
            long j10 = this.remainDuration_;
            if (j10 != 0) {
                codedOutputStream.y0(3, j10);
            }
            for (int i11 = 0; i11 < this.soundConverDuration_.size(); i11++) {
                codedOutputStream.A0(4, this.soundConverDuration_.get(i11));
            }
        }

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageV3.b<Builder> implements SoundConverDurationRespOrBuilder {
            private int bitField0_;
            private int errCode_;
            private Object errMsg_;
            private long remainDuration_;
            private o0<SoundConverDuration, SoundConverDuration.Builder, SoundConverDurationOrBuilder> soundConverDurationBuilder_;
            private List<SoundConverDuration> soundConverDuration_;

            private void ensureSoundConverDurationIsMutable() {
                if ((this.bitField0_ & 8) != 8) {
                    this.soundConverDuration_ = new ArrayList(this.soundConverDuration_);
                    this.bitField0_ |= 8;
                }
            }

            public static final Descriptors.b getDescriptor() {
                return SoundConverDurationProto.internal_static_com_mobvoi_companion_proto_SoundConverDurationResp_descriptor;
            }

            private o0<SoundConverDuration, SoundConverDuration.Builder, SoundConverDurationOrBuilder> getSoundConverDurationFieldBuilder() {
                if (this.soundConverDurationBuilder_ == null) {
                    this.soundConverDurationBuilder_ = new o0<>(this.soundConverDuration_, (this.bitField0_ & 8) == 8, getParentForChildren(), isClean());
                    this.soundConverDuration_ = null;
                }
                return this.soundConverDurationBuilder_;
            }

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                    getSoundConverDurationFieldBuilder();
                }
            }

            public Builder addAllSoundConverDuration(Iterable<? extends SoundConverDuration> iterable) {
                o0<SoundConverDuration, SoundConverDuration.Builder, SoundConverDurationOrBuilder> o0Var = this.soundConverDurationBuilder_;
                if (o0Var == null) {
                    ensureSoundConverDurationIsMutable();
                    b.a.addAll(iterable, this.soundConverDuration_);
                    onChanged();
                } else {
                    o0Var.b(iterable);
                }
                return this;
            }

            public Builder addSoundConverDuration(SoundConverDuration soundConverDuration) {
                o0<SoundConverDuration, SoundConverDuration.Builder, SoundConverDurationOrBuilder> o0Var = this.soundConverDurationBuilder_;
                if (o0Var == null) {
                    Objects.requireNonNull(soundConverDuration);
                    ensureSoundConverDurationIsMutable();
                    this.soundConverDuration_.add(soundConverDuration);
                    onChanged();
                } else {
                    o0Var.f(soundConverDuration);
                }
                return this;
            }

            public SoundConverDuration.Builder addSoundConverDurationBuilder() {
                return getSoundConverDurationFieldBuilder().d(SoundConverDuration.getDefaultInstance());
            }

            public Builder clearErrCode() {
                this.errCode_ = 0;
                onChanged();
                return this;
            }

            public Builder clearErrMsg() {
                this.errMsg_ = SoundConverDurationResp.getDefaultInstance().getErrMsg();
                onChanged();
                return this;
            }

            public Builder clearRemainDuration() {
                this.remainDuration_ = 0L;
                onChanged();
                return this;
            }

            public Builder clearSoundConverDuration() {
                o0<SoundConverDuration, SoundConverDuration.Builder, SoundConverDurationOrBuilder> o0Var = this.soundConverDurationBuilder_;
                if (o0Var == null) {
                    this.soundConverDuration_ = Collections.emptyList();
                    this.bitField0_ &= -9;
                    onChanged();
                } else {
                    o0Var.h();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a, com.google.protobuf.g0
            public Descriptors.b getDescriptorForType() {
                return SoundConverDurationProto.internal_static_com_mobvoi_companion_proto_SoundConverDurationResp_descriptor;
            }

            @Override // com.mobvoi.companion.proto.SoundConverDurationProto.SoundConverDurationRespOrBuilder
            public int getErrCode() {
                return this.errCode_;
            }

            @Override // com.mobvoi.companion.proto.SoundConverDurationProto.SoundConverDurationRespOrBuilder
            public String getErrMsg() {
                Object obj = this.errMsg_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.errMsg_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.proto.SoundConverDurationProto.SoundConverDurationRespOrBuilder
            public ByteString getErrMsgBytes() {
                Object obj = this.errMsg_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.errMsg_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.mobvoi.companion.proto.SoundConverDurationProto.SoundConverDurationRespOrBuilder
            public long getRemainDuration() {
                return this.remainDuration_;
            }

            @Override // com.mobvoi.companion.proto.SoundConverDurationProto.SoundConverDurationRespOrBuilder
            public SoundConverDuration getSoundConverDuration(int i10) {
                o0<SoundConverDuration, SoundConverDuration.Builder, SoundConverDurationOrBuilder> o0Var = this.soundConverDurationBuilder_;
                if (o0Var == null) {
                    return this.soundConverDuration_.get(i10);
                }
                return o0Var.o(i10);
            }

            public SoundConverDuration.Builder getSoundConverDurationBuilder(int i10) {
                return getSoundConverDurationFieldBuilder().l(i10);
            }

            public List<SoundConverDuration.Builder> getSoundConverDurationBuilderList() {
                return getSoundConverDurationFieldBuilder().m();
            }

            @Override // com.mobvoi.companion.proto.SoundConverDurationProto.SoundConverDurationRespOrBuilder
            public int getSoundConverDurationCount() {
                o0<SoundConverDuration, SoundConverDuration.Builder, SoundConverDurationOrBuilder> o0Var = this.soundConverDurationBuilder_;
                if (o0Var == null) {
                    return this.soundConverDuration_.size();
                }
                return o0Var.n();
            }

            @Override // com.mobvoi.companion.proto.SoundConverDurationProto.SoundConverDurationRespOrBuilder
            public List<SoundConverDuration> getSoundConverDurationList() {
                o0<SoundConverDuration, SoundConverDuration.Builder, SoundConverDurationOrBuilder> o0Var = this.soundConverDurationBuilder_;
                if (o0Var == null) {
                    return Collections.unmodifiableList(this.soundConverDuration_);
                }
                return o0Var.q();
            }

            @Override // com.mobvoi.companion.proto.SoundConverDurationProto.SoundConverDurationRespOrBuilder
            public SoundConverDurationOrBuilder getSoundConverDurationOrBuilder(int i10) {
                o0<SoundConverDuration, SoundConverDuration.Builder, SoundConverDurationOrBuilder> o0Var = this.soundConverDurationBuilder_;
                if (o0Var == null) {
                    return this.soundConverDuration_.get(i10);
                }
                return o0Var.r(i10);
            }

            @Override // com.mobvoi.companion.proto.SoundConverDurationProto.SoundConverDurationRespOrBuilder
            public List<? extends SoundConverDurationOrBuilder> getSoundConverDurationOrBuilderList() {
                o0<SoundConverDuration, SoundConverDuration.Builder, SoundConverDurationOrBuilder> o0Var = this.soundConverDurationBuilder_;
                if (o0Var != null) {
                    return o0Var.s();
                }
                return Collections.unmodifiableList(this.soundConverDuration_);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return SoundConverDurationProto.internal_static_com_mobvoi_companion_proto_SoundConverDurationResp_fieldAccessorTable.e(SoundConverDurationResp.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.f0
            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a
            public final Builder mergeUnknownFields(a1 a1Var) {
                return this;
            }

            public Builder removeSoundConverDuration(int i10) {
                o0<SoundConverDuration, SoundConverDuration.Builder, SoundConverDurationOrBuilder> o0Var = this.soundConverDurationBuilder_;
                if (o0Var == null) {
                    ensureSoundConverDurationIsMutable();
                    this.soundConverDuration_.remove(i10);
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

            public Builder setRemainDuration(long j10) {
                this.remainDuration_ = j10;
                onChanged();
                return this;
            }

            public Builder setSoundConverDuration(int i10, SoundConverDuration soundConverDuration) {
                o0<SoundConverDuration, SoundConverDuration.Builder, SoundConverDurationOrBuilder> o0Var = this.soundConverDurationBuilder_;
                if (o0Var == null) {
                    Objects.requireNonNull(soundConverDuration);
                    ensureSoundConverDurationIsMutable();
                    this.soundConverDuration_.set(i10, soundConverDuration);
                    onChanged();
                } else {
                    o0Var.x(i10, soundConverDuration);
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public final Builder setUnknownFields(a1 a1Var) {
                return this;
            }

            private Builder() {
                this.errMsg_ = "";
                this.soundConverDuration_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.e0.a, com.google.protobuf.d0.a
            public SoundConverDurationResp build() {
                SoundConverDurationResp buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) buildPartial);
            }

            @Override // com.google.protobuf.e0.a, com.google.protobuf.d0.a
            public SoundConverDurationResp buildPartial() {
                SoundConverDurationResp soundConverDurationResp = new SoundConverDurationResp(this);
                soundConverDurationResp.errCode_ = this.errCode_;
                soundConverDurationResp.errMsg_ = this.errMsg_;
                soundConverDurationResp.remainDuration_ = this.remainDuration_;
                o0<SoundConverDuration, SoundConverDuration.Builder, SoundConverDurationOrBuilder> o0Var = this.soundConverDurationBuilder_;
                if (o0Var == null) {
                    if ((this.bitField0_ & 8) == 8) {
                        this.soundConverDuration_ = Collections.unmodifiableList(this.soundConverDuration_);
                        this.bitField0_ &= -9;
                    }
                    soundConverDurationResp.soundConverDuration_ = this.soundConverDuration_;
                } else {
                    soundConverDurationResp.soundConverDuration_ = o0Var.g();
                }
                soundConverDurationResp.bitField0_ = 0;
                onBuilt();
                return soundConverDurationResp;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.f0, com.google.protobuf.g0
            public SoundConverDurationResp getDefaultInstanceForType() {
                return SoundConverDurationResp.getDefaultInstance();
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

            public SoundConverDuration.Builder addSoundConverDurationBuilder(int i10) {
                return getSoundConverDurationFieldBuilder().c(i10, SoundConverDuration.getDefaultInstance());
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
                this.remainDuration_ = 0L;
                o0<SoundConverDuration, SoundConverDuration.Builder, SoundConverDurationOrBuilder> o0Var = this.soundConverDurationBuilder_;
                if (o0Var == null) {
                    this.soundConverDuration_ = Collections.emptyList();
                    this.bitField0_ &= -9;
                } else {
                    o0Var.h();
                }
                return this;
            }

            private Builder(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.errMsg_ = "";
                this.soundConverDuration_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            public Builder addSoundConverDuration(int i10, SoundConverDuration soundConverDuration) {
                o0<SoundConverDuration, SoundConverDuration.Builder, SoundConverDurationOrBuilder> o0Var = this.soundConverDurationBuilder_;
                if (o0Var == null) {
                    Objects.requireNonNull(soundConverDuration);
                    ensureSoundConverDurationIsMutable();
                    this.soundConverDuration_.add(i10, soundConverDuration);
                    onChanged();
                } else {
                    o0Var.e(i10, soundConverDuration);
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a, com.google.protobuf.b.a
            public Builder clone() {
                return (Builder) super.clone();
            }

            @Override // com.google.protobuf.a.AbstractC0170a, com.google.protobuf.d0.a
            public Builder mergeFrom(d0 d0Var) {
                if (d0Var instanceof SoundConverDurationResp) {
                    return mergeFrom((SoundConverDurationResp) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            public Builder setSoundConverDuration(int i10, SoundConverDuration.Builder builder) {
                o0<SoundConverDuration, SoundConverDuration.Builder, SoundConverDurationOrBuilder> o0Var = this.soundConverDurationBuilder_;
                if (o0Var == null) {
                    ensureSoundConverDurationIsMutable();
                    this.soundConverDuration_.set(i10, builder.build());
                    onChanged();
                } else {
                    o0Var.x(i10, builder.build());
                }
                return this;
            }

            public Builder mergeFrom(SoundConverDurationResp soundConverDurationResp) {
                if (soundConverDurationResp == SoundConverDurationResp.getDefaultInstance()) {
                    return this;
                }
                if (soundConverDurationResp.getErrCode() != 0) {
                    setErrCode(soundConverDurationResp.getErrCode());
                }
                if (!soundConverDurationResp.getErrMsg().isEmpty()) {
                    this.errMsg_ = soundConverDurationResp.errMsg_;
                    onChanged();
                }
                if (soundConverDurationResp.getRemainDuration() != 0) {
                    setRemainDuration(soundConverDurationResp.getRemainDuration());
                }
                if (this.soundConverDurationBuilder_ == null) {
                    if (!soundConverDurationResp.soundConverDuration_.isEmpty()) {
                        if (this.soundConverDuration_.isEmpty()) {
                            this.soundConverDuration_ = soundConverDurationResp.soundConverDuration_;
                            this.bitField0_ &= -9;
                        } else {
                            ensureSoundConverDurationIsMutable();
                            this.soundConverDuration_.addAll(soundConverDurationResp.soundConverDuration_);
                        }
                        onChanged();
                    }
                } else if (!soundConverDurationResp.soundConverDuration_.isEmpty()) {
                    if (this.soundConverDurationBuilder_.u()) {
                        this.soundConverDurationBuilder_.i();
                        o0<SoundConverDuration, SoundConverDuration.Builder, SoundConverDurationOrBuilder> o0Var = null;
                        this.soundConverDurationBuilder_ = null;
                        this.soundConverDuration_ = soundConverDurationResp.soundConverDuration_;
                        this.bitField0_ &= -9;
                        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                            o0Var = getSoundConverDurationFieldBuilder();
                        }
                        this.soundConverDurationBuilder_ = o0Var;
                    } else {
                        this.soundConverDurationBuilder_.b(soundConverDurationResp.soundConverDuration_);
                    }
                }
                onChanged();
                return this;
            }

            public Builder addSoundConverDuration(SoundConverDuration.Builder builder) {
                o0<SoundConverDuration, SoundConverDuration.Builder, SoundConverDurationOrBuilder> o0Var = this.soundConverDurationBuilder_;
                if (o0Var == null) {
                    ensureSoundConverDurationIsMutable();
                    this.soundConverDuration_.add(builder.build());
                    onChanged();
                } else {
                    o0Var.f(builder.build());
                }
                return this;
            }

            public Builder addSoundConverDuration(int i10, SoundConverDuration.Builder builder) {
                o0<SoundConverDuration, SoundConverDuration.Builder, SoundConverDurationOrBuilder> o0Var = this.soundConverDurationBuilder_;
                if (o0Var == null) {
                    ensureSoundConverDurationIsMutable();
                    this.soundConverDuration_.add(i10, builder.build());
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
                SoundConverDurationResp soundConverDurationResp = null;
                try {
                    try {
                        SoundConverDurationResp soundConverDurationResp2 = (SoundConverDurationResp) SoundConverDurationResp.PARSER.parsePartialFrom(iVar, qVar);
                        if (soundConverDurationResp2 != null) {
                            mergeFrom(soundConverDurationResp2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e10) {
                        soundConverDurationResp = (SoundConverDurationResp) e10.getUnfinishedMessage();
                        try {
                            throw e10.unwrapIOException();
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (soundConverDurationResp != null) {
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (soundConverDurationResp != null) {
                        mergeFrom(soundConverDurationResp);
                    }
                    throw th2;
                }
            }
        }

        public static Builder newBuilder(SoundConverDurationResp soundConverDurationResp) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(soundConverDurationResp);
        }

        public static SoundConverDurationResp parseFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, qVar);
        }

        private SoundConverDurationResp(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static SoundConverDurationResp parseDelimitedFrom(InputStream inputStream, q qVar) throws IOException {
            return (SoundConverDurationResp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
        }

        public static SoundConverDurationResp parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
        public SoundConverDurationResp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static SoundConverDurationResp parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder newBuilderForType() {
            return newBuilder();
        }

        private SoundConverDurationResp() {
            this.memoizedIsInitialized = (byte) -1;
            this.errCode_ = 0;
            this.errMsg_ = "";
            this.remainDuration_ = 0L;
            this.soundConverDuration_ = Collections.emptyList();
        }

        public static SoundConverDurationResp parseFrom(InputStream inputStream) throws IOException {
            return (SoundConverDurationResp) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.c cVar) {
            return new Builder(cVar);
        }

        public static SoundConverDurationResp parseFrom(InputStream inputStream, q qVar) throws IOException {
            return (SoundConverDurationResp) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
        }

        public static SoundConverDurationResp parseFrom(i iVar) throws IOException {
            return (SoundConverDurationResp) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
        }

        private SoundConverDurationResp(i iVar, q qVar) throws InvalidProtocolBufferException {
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
                            } else if (F == 24) {
                                this.remainDuration_ = iVar.u();
                            } else if (F == 34) {
                                if (!(z11 & true)) {
                                    this.soundConverDuration_ = new ArrayList();
                                    z11 |= true;
                                }
                                this.soundConverDuration_.add((SoundConverDuration) iVar.v(SoundConverDuration.parser(), qVar));
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
                        this.soundConverDuration_ = Collections.unmodifiableList(this.soundConverDuration_);
                    }
                    makeExtensionsImmutable();
                }
            }
        }

        public static SoundConverDurationResp parseFrom(i iVar, q qVar) throws IOException {
            return (SoundConverDurationResp) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
        }
    }

    /* loaded from: classes2.dex */
    public interface SoundConverDurationRespOrBuilder extends g0 {
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

        long getRemainDuration();

        /* synthetic */ Object getRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i10);

        /* synthetic */ int getRepeatedFieldCount(Descriptors.FieldDescriptor fieldDescriptor);

        SoundConverDuration getSoundConverDuration(int i10);

        int getSoundConverDurationCount();

        List<SoundConverDuration> getSoundConverDurationList();

        SoundConverDurationOrBuilder getSoundConverDurationOrBuilder(int i10);

        List<? extends SoundConverDurationOrBuilder> getSoundConverDurationOrBuilderList();

        @Override // com.google.protobuf.g0
        /* synthetic */ a1 getUnknownFields();

        @Override // com.google.protobuf.g0
        /* synthetic */ boolean hasField(Descriptors.FieldDescriptor fieldDescriptor);

        /* synthetic */ boolean hasOneof(Descriptors.h hVar);

        @Override // com.google.protobuf.f0
        /* synthetic */ boolean isInitialized();
    }

    static {
        Descriptors.FileDescriptor.q(new String[]{"\n\u001bsound_conver_duration.proto\u0012\u001acom.mobvoi.companion.proto\"¥\u0001\n\u0017SoundConverDurationResp\u0012\u0010\n\berr_code\u0018\u0001 \u0001(\u0005\u0012\u000f\n\u0007err_msg\u0018\u0002 \u0001(\t\u0012\u0017\n\u000fremain_duration\u0018\u0003 \u0001(\u0003\u0012N\n\u0015sound_conver_duration\u0018\u0004 \u0003(\u000b2/.com.mobvoi.companion.proto.SoundConverDuration\" \u0001\n\u0013SoundConverDuration\u0012\f\n\u0004type\u0018\u0001 \u0001(\u0005\u0012\u000f\n\u0007card_id\u0018\u0002 \u0001(\t\u0012\u0016\n\u000etotal_duration\u0018\u0003 \u0001(\u0003\u0012\u001a\n\u0012remaining_duration\u0018\u0004 \u0001(\u0003\u0012\u0012\n\nexpired_at\u0018\u0005 \u0001(\u0003\u0012\u0012\n\ncreated_at\u0018\u0006 \u0001(\u0003\u0012\u000e\n\u0006status\u0018\u0007 \u0001(\tB\u001aB\u0018SoundCon", "verDurationProtob\u0006proto3"}, new Descriptors.FileDescriptor[0], new Descriptors.FileDescriptor.a() { // from class: com.mobvoi.companion.proto.SoundConverDurationProto.1
            @Override // com.google.protobuf.Descriptors.FileDescriptor.a
            public o assignDescriptors(Descriptors.FileDescriptor fileDescriptor) {
                Descriptors.FileDescriptor unused = SoundConverDurationProto.descriptor = fileDescriptor;
                return null;
            }
        });
        Descriptors.b bVar = getDescriptor().j().get(0);
        internal_static_com_mobvoi_companion_proto_SoundConverDurationResp_descriptor = bVar;
        internal_static_com_mobvoi_companion_proto_SoundConverDurationResp_fieldAccessorTable = new GeneratedMessageV3.e(bVar, new String[]{"ErrCode", "ErrMsg", "RemainDuration", "SoundConverDuration"});
        Descriptors.b bVar2 = getDescriptor().j().get(1);
        internal_static_com_mobvoi_companion_proto_SoundConverDuration_descriptor = bVar2;
        internal_static_com_mobvoi_companion_proto_SoundConverDuration_fieldAccessorTable = new GeneratedMessageV3.e(bVar2, new String[]{"Type", "CardId", "TotalDuration", "RemainingDuration", "ExpiredAt", "CreatedAt", "Status"});
    }

    private SoundConverDurationProto() {
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
