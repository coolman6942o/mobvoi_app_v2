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
import com.google.protobuf.q;
import com.google.protobuf.q0;
import com.google.protobuf.u;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Objects;
/* loaded from: classes2.dex */
public final class AccountProto {
    private static Descriptors.FileDescriptor descriptor;
    private static final Descriptors.b internal_static_com_mobvoi_companion_proto_SoundAccountResp_descriptor;
    private static final GeneratedMessageV3.e internal_static_com_mobvoi_companion_proto_SoundAccountResp_fieldAccessorTable;
    private static final Descriptors.b internal_static_com_mobvoi_companion_proto_SoundAccount_descriptor;
    private static final GeneratedMessageV3.e internal_static_com_mobvoi_companion_proto_SoundAccount_fieldAccessorTable;

    /* loaded from: classes2.dex */
    public static final class SoundAccount extends GeneratedMessageV3 implements SoundAccountOrBuilder {
        private static final SoundAccount DEFAULT_INSTANCE = new SoundAccount();
        private static final l0<SoundAccount> PARSER = new c<SoundAccount>() { // from class: com.mobvoi.companion.proto.AccountProto.SoundAccount.1
            @Override // com.google.protobuf.l0
            public SoundAccount parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
                return new SoundAccount(iVar, qVar);
            }
        };
        public static final int PAYMENT_TIME_FIELD_NUMBER = 2;
        public static final int WWID_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private byte memoizedIsInitialized;
        private long paymentTime_;
        private volatile Object wwid_;

        public static SoundAccount getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return AccountProto.internal_static_com_mobvoi_companion_proto_SoundAccount_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static SoundAccount parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (SoundAccount) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static SoundAccount parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static l0<SoundAccount> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof SoundAccount)) {
                return super.equals(obj);
            }
            SoundAccount soundAccount = (SoundAccount) obj;
            return (getWwid().equals(soundAccount.getWwid())) && getPaymentTime() == soundAccount.getPaymentTime();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public l0<SoundAccount> getParserForType() {
            return PARSER;
        }

        @Override // com.mobvoi.companion.proto.AccountProto.SoundAccountOrBuilder
        public long getPaymentTime() {
            return this.paymentTime_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
        public int getSerializedSize() {
            int i10 = this.memoizedSize;
            if (i10 != -1) {
                return i10;
            }
            int i11 = 0;
            if (!getWwidBytes().isEmpty()) {
                i11 = 0 + GeneratedMessageV3.computeStringSize(1, this.wwid_);
            }
            long j10 = this.paymentTime_;
            if (j10 != 0) {
                i11 += CodedOutputStream.x(2, j10);
            }
            this.memoizedSize = i11;
            return i11;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.g0
        public final a1 getUnknownFields() {
            return a1.c();
        }

        @Override // com.mobvoi.companion.proto.AccountProto.SoundAccountOrBuilder
        public String getWwid() {
            Object obj = this.wwid_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.wwid_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.proto.AccountProto.SoundAccountOrBuilder
        public ByteString getWwidBytes() {
            Object obj = this.wwid_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.wwid_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.google.protobuf.a
        public int hashCode() {
            int i10 = this.memoizedHashCode;
            if (i10 != 0) {
                return i10;
            }
            int hashCode = ((((((((((779 + getDescriptorForType().hashCode()) * 37) + 1) * 53) + getWwid().hashCode()) * 37) + 2) * 53) + u.h(getPaymentTime())) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return AccountProto.internal_static_com_mobvoi_companion_proto_SoundAccount_fieldAccessorTable.e(SoundAccount.class, Builder.class);
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
            if (!getWwidBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.wwid_);
            }
            long j10 = this.paymentTime_;
            if (j10 != 0) {
                codedOutputStream.y0(2, j10);
            }
        }

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageV3.b<Builder> implements SoundAccountOrBuilder {
            private long paymentTime_;
            private Object wwid_;

            public static final Descriptors.b getDescriptor() {
                return AccountProto.internal_static_com_mobvoi_companion_proto_SoundAccount_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            public Builder clearPaymentTime() {
                this.paymentTime_ = 0L;
                onChanged();
                return this;
            }

            public Builder clearWwid() {
                this.wwid_ = SoundAccount.getDefaultInstance().getWwid();
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a, com.google.protobuf.g0
            public Descriptors.b getDescriptorForType() {
                return AccountProto.internal_static_com_mobvoi_companion_proto_SoundAccount_descriptor;
            }

            @Override // com.mobvoi.companion.proto.AccountProto.SoundAccountOrBuilder
            public long getPaymentTime() {
                return this.paymentTime_;
            }

            @Override // com.mobvoi.companion.proto.AccountProto.SoundAccountOrBuilder
            public String getWwid() {
                Object obj = this.wwid_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.wwid_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.proto.AccountProto.SoundAccountOrBuilder
            public ByteString getWwidBytes() {
                Object obj = this.wwid_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.wwid_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return AccountProto.internal_static_com_mobvoi_companion_proto_SoundAccount_fieldAccessorTable.e(SoundAccount.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.f0
            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a
            public final Builder mergeUnknownFields(a1 a1Var) {
                return this;
            }

            public Builder setPaymentTime(long j10) {
                this.paymentTime_ = j10;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public final Builder setUnknownFields(a1 a1Var) {
                return this;
            }

            public Builder setWwid(String str) {
                Objects.requireNonNull(str);
                this.wwid_ = str;
                onChanged();
                return this;
            }

            public Builder setWwidBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                b.checkByteStringIsUtf8(byteString);
                this.wwid_ = byteString;
                onChanged();
                return this;
            }

            private Builder() {
                this.wwid_ = "";
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.e0.a, com.google.protobuf.d0.a
            public SoundAccount build() {
                SoundAccount buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) buildPartial);
            }

            @Override // com.google.protobuf.e0.a, com.google.protobuf.d0.a
            public SoundAccount buildPartial() {
                SoundAccount soundAccount = new SoundAccount(this);
                soundAccount.wwid_ = this.wwid_;
                soundAccount.paymentTime_ = this.paymentTime_;
                onBuilt();
                return soundAccount;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.f0, com.google.protobuf.g0
            public SoundAccount getDefaultInstanceForType() {
                return SoundAccount.getDefaultInstance();
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
                this.wwid_ = "";
                this.paymentTime_ = 0L;
                return this;
            }

            private Builder(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.wwid_ = "";
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a, com.google.protobuf.b.a
            public Builder clone() {
                return (Builder) super.clone();
            }

            @Override // com.google.protobuf.a.AbstractC0170a, com.google.protobuf.d0.a
            public Builder mergeFrom(d0 d0Var) {
                if (d0Var instanceof SoundAccount) {
                    return mergeFrom((SoundAccount) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            public Builder mergeFrom(SoundAccount soundAccount) {
                if (soundAccount == SoundAccount.getDefaultInstance()) {
                    return this;
                }
                if (!soundAccount.getWwid().isEmpty()) {
                    this.wwid_ = soundAccount.wwid_;
                    onChanged();
                }
                if (soundAccount.getPaymentTime() != 0) {
                    setPaymentTime(soundAccount.getPaymentTime());
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
                SoundAccount soundAccount = null;
                try {
                    try {
                        SoundAccount soundAccount2 = (SoundAccount) SoundAccount.PARSER.parsePartialFrom(iVar, qVar);
                        if (soundAccount2 != null) {
                            mergeFrom(soundAccount2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e10) {
                        soundAccount = (SoundAccount) e10.getUnfinishedMessage();
                        try {
                            throw e10.unwrapIOException();
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (soundAccount != null) {
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (soundAccount != null) {
                        mergeFrom(soundAccount);
                    }
                    throw th2;
                }
            }
        }

        public static Builder newBuilder(SoundAccount soundAccount) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(soundAccount);
        }

        public static SoundAccount parseFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, qVar);
        }

        private SoundAccount(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static SoundAccount parseDelimitedFrom(InputStream inputStream, q qVar) throws IOException {
            return (SoundAccount) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
        }

        public static SoundAccount parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
        public SoundAccount getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static SoundAccount parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder newBuilderForType() {
            return newBuilder();
        }

        private SoundAccount() {
            this.memoizedIsInitialized = (byte) -1;
            this.wwid_ = "";
            this.paymentTime_ = 0L;
        }

        public static SoundAccount parseFrom(InputStream inputStream) throws IOException {
            return (SoundAccount) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.c cVar) {
            return new Builder(cVar);
        }

        public static SoundAccount parseFrom(InputStream inputStream, q qVar) throws IOException {
            return (SoundAccount) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
        }

        private SoundAccount(i iVar, q qVar) throws InvalidProtocolBufferException {
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
                                    this.wwid_ = iVar.E();
                                } else if (F == 16) {
                                    this.paymentTime_ = iVar.u();
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

        public static SoundAccount parseFrom(i iVar) throws IOException {
            return (SoundAccount) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
        }

        public static SoundAccount parseFrom(i iVar, q qVar) throws IOException {
            return (SoundAccount) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
        }
    }

    /* loaded from: classes2.dex */
    public interface SoundAccountOrBuilder extends g0 {
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

        long getPaymentTime();

        /* synthetic */ Object getRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i10);

        /* synthetic */ int getRepeatedFieldCount(Descriptors.FieldDescriptor fieldDescriptor);

        @Override // com.google.protobuf.g0
        /* synthetic */ a1 getUnknownFields();

        String getWwid();

        ByteString getWwidBytes();

        @Override // com.google.protobuf.g0
        /* synthetic */ boolean hasField(Descriptors.FieldDescriptor fieldDescriptor);

        /* synthetic */ boolean hasOneof(Descriptors.h hVar);

        @Override // com.google.protobuf.f0
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes2.dex */
    public static final class SoundAccountResp extends GeneratedMessageV3 implements SoundAccountRespOrBuilder {
        public static final int ERR_CODE_FIELD_NUMBER = 1;
        public static final int ERR_MSG_FIELD_NUMBER = 2;
        public static final int SOUND_ACCOUNT_FIELD_NUMBER = 3;
        private static final long serialVersionUID = 0;
        private int errCode_;
        private volatile Object errMsg_;
        private byte memoizedIsInitialized;
        private SoundAccount soundAccount_;
        private static final SoundAccountResp DEFAULT_INSTANCE = new SoundAccountResp();
        private static final l0<SoundAccountResp> PARSER = new c<SoundAccountResp>() { // from class: com.mobvoi.companion.proto.AccountProto.SoundAccountResp.1
            @Override // com.google.protobuf.l0
            public SoundAccountResp parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
                return new SoundAccountResp(iVar, qVar);
            }
        };

        public static SoundAccountResp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return AccountProto.internal_static_com_mobvoi_companion_proto_SoundAccountResp_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static SoundAccountResp parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (SoundAccountResp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static SoundAccountResp parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static l0<SoundAccountResp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            boolean z10 = true;
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof SoundAccountResp)) {
                return super.equals(obj);
            }
            SoundAccountResp soundAccountResp = (SoundAccountResp) obj;
            boolean z11 = ((getErrCode() == soundAccountResp.getErrCode()) && getErrMsg().equals(soundAccountResp.getErrMsg())) && hasSoundAccount() == soundAccountResp.hasSoundAccount();
            if (!hasSoundAccount()) {
                return z11;
            }
            if (!z11 || !getSoundAccount().equals(soundAccountResp.getSoundAccount())) {
                z10 = false;
            }
            return z10;
        }

        @Override // com.mobvoi.companion.proto.AccountProto.SoundAccountRespOrBuilder
        public int getErrCode() {
            return this.errCode_;
        }

        @Override // com.mobvoi.companion.proto.AccountProto.SoundAccountRespOrBuilder
        public String getErrMsg() {
            Object obj = this.errMsg_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.errMsg_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.proto.AccountProto.SoundAccountRespOrBuilder
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
        public l0<SoundAccountResp> getParserForType() {
            return PARSER;
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
            if (this.soundAccount_ != null) {
                i11 += CodedOutputStream.E(3, getSoundAccount());
            }
            this.memoizedSize = i11;
            return i11;
        }

        @Override // com.mobvoi.companion.proto.AccountProto.SoundAccountRespOrBuilder
        public SoundAccount getSoundAccount() {
            SoundAccount soundAccount = this.soundAccount_;
            return soundAccount == null ? SoundAccount.getDefaultInstance() : soundAccount;
        }

        @Override // com.mobvoi.companion.proto.AccountProto.SoundAccountRespOrBuilder
        public SoundAccountOrBuilder getSoundAccountOrBuilder() {
            return getSoundAccount();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.g0
        public final a1 getUnknownFields() {
            return a1.c();
        }

        @Override // com.mobvoi.companion.proto.AccountProto.SoundAccountRespOrBuilder
        public boolean hasSoundAccount() {
            return this.soundAccount_ != null;
        }

        @Override // com.google.protobuf.a
        public int hashCode() {
            int i10 = this.memoizedHashCode;
            if (i10 != 0) {
                return i10;
            }
            int hashCode = ((((((((779 + getDescriptorForType().hashCode()) * 37) + 1) * 53) + getErrCode()) * 37) + 2) * 53) + getErrMsg().hashCode();
            if (hasSoundAccount()) {
                hashCode = (((hashCode * 37) + 3) * 53) + getSoundAccount().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return AccountProto.internal_static_com_mobvoi_companion_proto_SoundAccountResp_fieldAccessorTable.e(SoundAccountResp.class, Builder.class);
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
            if (this.soundAccount_ != null) {
                codedOutputStream.A0(3, getSoundAccount());
            }
        }

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageV3.b<Builder> implements SoundAccountRespOrBuilder {
            private int errCode_;
            private Object errMsg_;
            private q0<SoundAccount, SoundAccount.Builder, SoundAccountOrBuilder> soundAccountBuilder_;
            private SoundAccount soundAccount_;

            public static final Descriptors.b getDescriptor() {
                return AccountProto.internal_static_com_mobvoi_companion_proto_SoundAccountResp_descriptor;
            }

            private q0<SoundAccount, SoundAccount.Builder, SoundAccountOrBuilder> getSoundAccountFieldBuilder() {
                if (this.soundAccountBuilder_ == null) {
                    this.soundAccountBuilder_ = new q0<>(getSoundAccount(), getParentForChildren(), isClean());
                    this.soundAccount_ = null;
                }
                return this.soundAccountBuilder_;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            public Builder clearErrCode() {
                this.errCode_ = 0;
                onChanged();
                return this;
            }

            public Builder clearErrMsg() {
                this.errMsg_ = SoundAccountResp.getDefaultInstance().getErrMsg();
                onChanged();
                return this;
            }

            public Builder clearSoundAccount() {
                if (this.soundAccountBuilder_ == null) {
                    this.soundAccount_ = null;
                    onChanged();
                } else {
                    this.soundAccount_ = null;
                    this.soundAccountBuilder_ = null;
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a, com.google.protobuf.g0
            public Descriptors.b getDescriptorForType() {
                return AccountProto.internal_static_com_mobvoi_companion_proto_SoundAccountResp_descriptor;
            }

            @Override // com.mobvoi.companion.proto.AccountProto.SoundAccountRespOrBuilder
            public int getErrCode() {
                return this.errCode_;
            }

            @Override // com.mobvoi.companion.proto.AccountProto.SoundAccountRespOrBuilder
            public String getErrMsg() {
                Object obj = this.errMsg_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.errMsg_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.proto.AccountProto.SoundAccountRespOrBuilder
            public ByteString getErrMsgBytes() {
                Object obj = this.errMsg_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.errMsg_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.mobvoi.companion.proto.AccountProto.SoundAccountRespOrBuilder
            public SoundAccount getSoundAccount() {
                q0<SoundAccount, SoundAccount.Builder, SoundAccountOrBuilder> q0Var = this.soundAccountBuilder_;
                if (q0Var != null) {
                    return q0Var.f();
                }
                SoundAccount soundAccount = this.soundAccount_;
                return soundAccount == null ? SoundAccount.getDefaultInstance() : soundAccount;
            }

            public SoundAccount.Builder getSoundAccountBuilder() {
                onChanged();
                return getSoundAccountFieldBuilder().e();
            }

            @Override // com.mobvoi.companion.proto.AccountProto.SoundAccountRespOrBuilder
            public SoundAccountOrBuilder getSoundAccountOrBuilder() {
                q0<SoundAccount, SoundAccount.Builder, SoundAccountOrBuilder> q0Var = this.soundAccountBuilder_;
                if (q0Var != null) {
                    return q0Var.g();
                }
                SoundAccount soundAccount = this.soundAccount_;
                return soundAccount == null ? SoundAccount.getDefaultInstance() : soundAccount;
            }

            @Override // com.mobvoi.companion.proto.AccountProto.SoundAccountRespOrBuilder
            public boolean hasSoundAccount() {
                return (this.soundAccountBuilder_ == null && this.soundAccount_ == null) ? false : true;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return AccountProto.internal_static_com_mobvoi_companion_proto_SoundAccountResp_fieldAccessorTable.e(SoundAccountResp.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.f0
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeSoundAccount(SoundAccount soundAccount) {
                q0<SoundAccount, SoundAccount.Builder, SoundAccountOrBuilder> q0Var = this.soundAccountBuilder_;
                if (q0Var == null) {
                    SoundAccount soundAccount2 = this.soundAccount_;
                    if (soundAccount2 != null) {
                        this.soundAccount_ = SoundAccount.newBuilder(soundAccount2).mergeFrom(soundAccount).buildPartial();
                    } else {
                        this.soundAccount_ = soundAccount;
                    }
                    onChanged();
                } else {
                    q0Var.h(soundAccount);
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a
            public final Builder mergeUnknownFields(a1 a1Var) {
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

            public Builder setSoundAccount(SoundAccount soundAccount) {
                q0<SoundAccount, SoundAccount.Builder, SoundAccountOrBuilder> q0Var = this.soundAccountBuilder_;
                if (q0Var == null) {
                    Objects.requireNonNull(soundAccount);
                    this.soundAccount_ = soundAccount;
                    onChanged();
                } else {
                    q0Var.j(soundAccount);
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public final Builder setUnknownFields(a1 a1Var) {
                return this;
            }

            private Builder() {
                this.errMsg_ = "";
                this.soundAccount_ = null;
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.e0.a, com.google.protobuf.d0.a
            public SoundAccountResp build() {
                SoundAccountResp buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) buildPartial);
            }

            @Override // com.google.protobuf.e0.a, com.google.protobuf.d0.a
            public SoundAccountResp buildPartial() {
                SoundAccountResp soundAccountResp = new SoundAccountResp(this);
                soundAccountResp.errCode_ = this.errCode_;
                soundAccountResp.errMsg_ = this.errMsg_;
                q0<SoundAccount, SoundAccount.Builder, SoundAccountOrBuilder> q0Var = this.soundAccountBuilder_;
                if (q0Var == null) {
                    soundAccountResp.soundAccount_ = this.soundAccount_;
                } else {
                    soundAccountResp.soundAccount_ = q0Var.b();
                }
                onBuilt();
                return soundAccountResp;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.f0, com.google.protobuf.g0
            public SoundAccountResp getDefaultInstanceForType() {
                return SoundAccountResp.getDefaultInstance();
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
                if (this.soundAccountBuilder_ == null) {
                    this.soundAccount_ = null;
                } else {
                    this.soundAccount_ = null;
                    this.soundAccountBuilder_ = null;
                }
                return this;
            }

            public Builder setSoundAccount(SoundAccount.Builder builder) {
                q0<SoundAccount, SoundAccount.Builder, SoundAccountOrBuilder> q0Var = this.soundAccountBuilder_;
                if (q0Var == null) {
                    this.soundAccount_ = builder.build();
                    onChanged();
                } else {
                    q0Var.j(builder.build());
                }
                return this;
            }

            private Builder(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.errMsg_ = "";
                this.soundAccount_ = null;
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a, com.google.protobuf.b.a
            public Builder clone() {
                return (Builder) super.clone();
            }

            @Override // com.google.protobuf.a.AbstractC0170a, com.google.protobuf.d0.a
            public Builder mergeFrom(d0 d0Var) {
                if (d0Var instanceof SoundAccountResp) {
                    return mergeFrom((SoundAccountResp) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            public Builder mergeFrom(SoundAccountResp soundAccountResp) {
                if (soundAccountResp == SoundAccountResp.getDefaultInstance()) {
                    return this;
                }
                if (soundAccountResp.getErrCode() != 0) {
                    setErrCode(soundAccountResp.getErrCode());
                }
                if (!soundAccountResp.getErrMsg().isEmpty()) {
                    this.errMsg_ = soundAccountResp.errMsg_;
                    onChanged();
                }
                if (soundAccountResp.hasSoundAccount()) {
                    mergeSoundAccount(soundAccountResp.getSoundAccount());
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
                SoundAccountResp soundAccountResp = null;
                try {
                    try {
                        SoundAccountResp soundAccountResp2 = (SoundAccountResp) SoundAccountResp.PARSER.parsePartialFrom(iVar, qVar);
                        if (soundAccountResp2 != null) {
                            mergeFrom(soundAccountResp2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e10) {
                        soundAccountResp = (SoundAccountResp) e10.getUnfinishedMessage();
                        try {
                            throw e10.unwrapIOException();
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (soundAccountResp != null) {
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (soundAccountResp != null) {
                        mergeFrom(soundAccountResp);
                    }
                    throw th2;
                }
            }
        }

        public static Builder newBuilder(SoundAccountResp soundAccountResp) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(soundAccountResp);
        }

        public static SoundAccountResp parseFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, qVar);
        }

        private SoundAccountResp(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static SoundAccountResp parseDelimitedFrom(InputStream inputStream, q qVar) throws IOException {
            return (SoundAccountResp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
        }

        public static SoundAccountResp parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
        public SoundAccountResp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static SoundAccountResp parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder newBuilderForType() {
            return newBuilder();
        }

        private SoundAccountResp() {
            this.memoizedIsInitialized = (byte) -1;
            this.errCode_ = 0;
            this.errMsg_ = "";
        }

        public static SoundAccountResp parseFrom(InputStream inputStream) throws IOException {
            return (SoundAccountResp) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.c cVar) {
            return new Builder(cVar);
        }

        public static SoundAccountResp parseFrom(InputStream inputStream, q qVar) throws IOException {
            return (SoundAccountResp) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
        }

        private SoundAccountResp(i iVar, q qVar) throws InvalidProtocolBufferException {
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
                                    this.errCode_ = iVar.t();
                                } else if (F == 18) {
                                    this.errMsg_ = iVar.E();
                                } else if (F == 26) {
                                    SoundAccount.Builder builder = null;
                                    SoundAccount soundAccount = this.soundAccount_;
                                    builder = soundAccount != null ? soundAccount.toBuilder() : builder;
                                    SoundAccount soundAccount2 = (SoundAccount) iVar.v(SoundAccount.parser(), qVar);
                                    this.soundAccount_ = soundAccount2;
                                    if (builder != null) {
                                        builder.mergeFrom(soundAccount2);
                                        this.soundAccount_ = builder.buildPartial();
                                    }
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

        public static SoundAccountResp parseFrom(i iVar) throws IOException {
            return (SoundAccountResp) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
        }

        public static SoundAccountResp parseFrom(i iVar, q qVar) throws IOException {
            return (SoundAccountResp) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
        }
    }

    /* loaded from: classes2.dex */
    public interface SoundAccountRespOrBuilder extends g0 {
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

        SoundAccount getSoundAccount();

        SoundAccountOrBuilder getSoundAccountOrBuilder();

        @Override // com.google.protobuf.g0
        /* synthetic */ a1 getUnknownFields();

        @Override // com.google.protobuf.g0
        /* synthetic */ boolean hasField(Descriptors.FieldDescriptor fieldDescriptor);

        /* synthetic */ boolean hasOneof(Descriptors.h hVar);

        boolean hasSoundAccount();

        @Override // com.google.protobuf.f0
        /* synthetic */ boolean isInitialized();
    }

    static {
        Descriptors.FileDescriptor.q(new String[]{"\n\u0013sound_account.proto\u0012\u001acom.mobvoi.companion.proto\"v\n\u0010SoundAccountResp\u0012\u0010\n\berr_code\u0018\u0001 \u0001(\u0005\u0012\u000f\n\u0007err_msg\u0018\u0002 \u0001(\t\u0012?\n\rsound_account\u0018\u0003 \u0001(\u000b2(.com.mobvoi.companion.proto.SoundAccount\"2\n\fSoundAccount\u0012\f\n\u0004wwid\u0018\u0001 \u0001(\t\u0012\u0014\n\fpayment_time\u0018\u0002 \u0001(\u0003B\u000eB\fAccountProtob\u0006proto3"}, new Descriptors.FileDescriptor[0], new Descriptors.FileDescriptor.a() { // from class: com.mobvoi.companion.proto.AccountProto.1
            @Override // com.google.protobuf.Descriptors.FileDescriptor.a
            public o assignDescriptors(Descriptors.FileDescriptor fileDescriptor) {
                Descriptors.FileDescriptor unused = AccountProto.descriptor = fileDescriptor;
                return null;
            }
        });
        Descriptors.b bVar = getDescriptor().j().get(0);
        internal_static_com_mobvoi_companion_proto_SoundAccountResp_descriptor = bVar;
        internal_static_com_mobvoi_companion_proto_SoundAccountResp_fieldAccessorTable = new GeneratedMessageV3.e(bVar, new String[]{"ErrCode", "ErrMsg", "SoundAccount"});
        Descriptors.b bVar2 = getDescriptor().j().get(1);
        internal_static_com_mobvoi_companion_proto_SoundAccount_descriptor = bVar2;
        internal_static_com_mobvoi_companion_proto_SoundAccount_fieldAccessorTable = new GeneratedMessageV3.e(bVar2, new String[]{"Wwid", "PaymentTime"});
    }

    private AccountProto() {
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
