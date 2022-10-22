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
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Objects;
/* loaded from: classes2.dex */
public final class FilecountProto {
    private static Descriptors.FileDescriptor descriptor;
    private static final Descriptors.b internal_static_com_mobvoi_companion_proto_SoundFilecountResp_descriptor;
    private static final GeneratedMessageV3.e internal_static_com_mobvoi_companion_proto_SoundFilecountResp_fieldAccessorTable;

    /* loaded from: classes2.dex */
    public static final class SoundFilecountResp extends GeneratedMessageV3 implements SoundFilecountRespOrBuilder {
        public static final int CONVERTEDCOUNT_FIELD_NUMBER = 4;
        public static final int ERR_CODE_FIELD_NUMBER = 1;
        public static final int ERR_MSG_FIELD_NUMBER = 2;
        public static final int SOUNDFILECOUNT_FIELD_NUMBER = 5;
        public static final int TOTALCOUNT_FIELD_NUMBER = 3;
        private static final long serialVersionUID = 0;
        private int convertedCount_;
        private int errCode_;
        private volatile Object errMsg_;
        private byte memoizedIsInitialized;
        private int soundFileCount_;
        private int totalCount_;
        private static final SoundFilecountResp DEFAULT_INSTANCE = new SoundFilecountResp();
        private static final l0<SoundFilecountResp> PARSER = new c<SoundFilecountResp>() { // from class: com.mobvoi.companion.proto.FilecountProto.SoundFilecountResp.1
            @Override // com.google.protobuf.l0
            public SoundFilecountResp parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
                return new SoundFilecountResp(iVar, qVar);
            }
        };

        public static SoundFilecountResp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return FilecountProto.internal_static_com_mobvoi_companion_proto_SoundFilecountResp_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static SoundFilecountResp parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (SoundFilecountResp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static SoundFilecountResp parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static l0<SoundFilecountResp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof SoundFilecountResp)) {
                return super.equals(obj);
            }
            SoundFilecountResp soundFilecountResp = (SoundFilecountResp) obj;
            return ((((getErrCode() == soundFilecountResp.getErrCode()) && getErrMsg().equals(soundFilecountResp.getErrMsg())) && getTotalCount() == soundFilecountResp.getTotalCount()) && getConvertedCount() == soundFilecountResp.getConvertedCount()) && getSoundFileCount() == soundFilecountResp.getSoundFileCount();
        }

        @Override // com.mobvoi.companion.proto.FilecountProto.SoundFilecountRespOrBuilder
        public int getConvertedCount() {
            return this.convertedCount_;
        }

        @Override // com.mobvoi.companion.proto.FilecountProto.SoundFilecountRespOrBuilder
        public int getErrCode() {
            return this.errCode_;
        }

        @Override // com.mobvoi.companion.proto.FilecountProto.SoundFilecountRespOrBuilder
        public String getErrMsg() {
            Object obj = this.errMsg_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.errMsg_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.proto.FilecountProto.SoundFilecountRespOrBuilder
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
        public l0<SoundFilecountResp> getParserForType() {
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
            int i13 = this.totalCount_;
            if (i13 != 0) {
                i11 += CodedOutputStream.v(3, i13);
            }
            int i14 = this.convertedCount_;
            if (i14 != 0) {
                i11 += CodedOutputStream.v(4, i14);
            }
            int i15 = this.soundFileCount_;
            if (i15 != 0) {
                i11 += CodedOutputStream.v(5, i15);
            }
            this.memoizedSize = i11;
            return i11;
        }

        @Override // com.mobvoi.companion.proto.FilecountProto.SoundFilecountRespOrBuilder
        public int getSoundFileCount() {
            return this.soundFileCount_;
        }

        @Override // com.mobvoi.companion.proto.FilecountProto.SoundFilecountRespOrBuilder
        public int getTotalCount() {
            return this.totalCount_;
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
            int hashCode = ((((((((((((((((((((((779 + getDescriptorForType().hashCode()) * 37) + 1) * 53) + getErrCode()) * 37) + 2) * 53) + getErrMsg().hashCode()) * 37) + 3) * 53) + getTotalCount()) * 37) + 4) * 53) + getConvertedCount()) * 37) + 5) * 53) + getSoundFileCount()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return FilecountProto.internal_static_com_mobvoi_companion_proto_SoundFilecountResp_fieldAccessorTable.e(SoundFilecountResp.class, Builder.class);
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
            int i11 = this.totalCount_;
            if (i11 != 0) {
                codedOutputStream.w0(3, i11);
            }
            int i12 = this.convertedCount_;
            if (i12 != 0) {
                codedOutputStream.w0(4, i12);
            }
            int i13 = this.soundFileCount_;
            if (i13 != 0) {
                codedOutputStream.w0(5, i13);
            }
        }

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageV3.b<Builder> implements SoundFilecountRespOrBuilder {
            private int convertedCount_;
            private int errCode_;
            private Object errMsg_;
            private int soundFileCount_;
            private int totalCount_;

            public static final Descriptors.b getDescriptor() {
                return FilecountProto.internal_static_com_mobvoi_companion_proto_SoundFilecountResp_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            public Builder clearConvertedCount() {
                this.convertedCount_ = 0;
                onChanged();
                return this;
            }

            public Builder clearErrCode() {
                this.errCode_ = 0;
                onChanged();
                return this;
            }

            public Builder clearErrMsg() {
                this.errMsg_ = SoundFilecountResp.getDefaultInstance().getErrMsg();
                onChanged();
                return this;
            }

            public Builder clearSoundFileCount() {
                this.soundFileCount_ = 0;
                onChanged();
                return this;
            }

            public Builder clearTotalCount() {
                this.totalCount_ = 0;
                onChanged();
                return this;
            }

            @Override // com.mobvoi.companion.proto.FilecountProto.SoundFilecountRespOrBuilder
            public int getConvertedCount() {
                return this.convertedCount_;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a, com.google.protobuf.g0
            public Descriptors.b getDescriptorForType() {
                return FilecountProto.internal_static_com_mobvoi_companion_proto_SoundFilecountResp_descriptor;
            }

            @Override // com.mobvoi.companion.proto.FilecountProto.SoundFilecountRespOrBuilder
            public int getErrCode() {
                return this.errCode_;
            }

            @Override // com.mobvoi.companion.proto.FilecountProto.SoundFilecountRespOrBuilder
            public String getErrMsg() {
                Object obj = this.errMsg_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.errMsg_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.proto.FilecountProto.SoundFilecountRespOrBuilder
            public ByteString getErrMsgBytes() {
                Object obj = this.errMsg_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.errMsg_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.mobvoi.companion.proto.FilecountProto.SoundFilecountRespOrBuilder
            public int getSoundFileCount() {
                return this.soundFileCount_;
            }

            @Override // com.mobvoi.companion.proto.FilecountProto.SoundFilecountRespOrBuilder
            public int getTotalCount() {
                return this.totalCount_;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return FilecountProto.internal_static_com_mobvoi_companion_proto_SoundFilecountResp_fieldAccessorTable.e(SoundFilecountResp.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.f0
            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a
            public final Builder mergeUnknownFields(a1 a1Var) {
                return this;
            }

            public Builder setConvertedCount(int i10) {
                this.convertedCount_ = i10;
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

            public Builder setSoundFileCount(int i10) {
                this.soundFileCount_ = i10;
                onChanged();
                return this;
            }

            public Builder setTotalCount(int i10) {
                this.totalCount_ = i10;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public final Builder setUnknownFields(a1 a1Var) {
                return this;
            }

            private Builder() {
                this.errMsg_ = "";
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.e0.a, com.google.protobuf.d0.a
            public SoundFilecountResp build() {
                SoundFilecountResp buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) buildPartial);
            }

            @Override // com.google.protobuf.e0.a, com.google.protobuf.d0.a
            public SoundFilecountResp buildPartial() {
                SoundFilecountResp soundFilecountResp = new SoundFilecountResp(this);
                soundFilecountResp.errCode_ = this.errCode_;
                soundFilecountResp.errMsg_ = this.errMsg_;
                soundFilecountResp.totalCount_ = this.totalCount_;
                soundFilecountResp.convertedCount_ = this.convertedCount_;
                soundFilecountResp.soundFileCount_ = this.soundFileCount_;
                onBuilt();
                return soundFilecountResp;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.f0, com.google.protobuf.g0
            public SoundFilecountResp getDefaultInstanceForType() {
                return SoundFilecountResp.getDefaultInstance();
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
                this.totalCount_ = 0;
                this.convertedCount_ = 0;
                this.soundFileCount_ = 0;
                return this;
            }

            private Builder(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.errMsg_ = "";
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a, com.google.protobuf.b.a
            public Builder clone() {
                return (Builder) super.clone();
            }

            @Override // com.google.protobuf.a.AbstractC0170a, com.google.protobuf.d0.a
            public Builder mergeFrom(d0 d0Var) {
                if (d0Var instanceof SoundFilecountResp) {
                    return mergeFrom((SoundFilecountResp) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            public Builder mergeFrom(SoundFilecountResp soundFilecountResp) {
                if (soundFilecountResp == SoundFilecountResp.getDefaultInstance()) {
                    return this;
                }
                if (soundFilecountResp.getErrCode() != 0) {
                    setErrCode(soundFilecountResp.getErrCode());
                }
                if (!soundFilecountResp.getErrMsg().isEmpty()) {
                    this.errMsg_ = soundFilecountResp.errMsg_;
                    onChanged();
                }
                if (soundFilecountResp.getTotalCount() != 0) {
                    setTotalCount(soundFilecountResp.getTotalCount());
                }
                if (soundFilecountResp.getConvertedCount() != 0) {
                    setConvertedCount(soundFilecountResp.getConvertedCount());
                }
                if (soundFilecountResp.getSoundFileCount() != 0) {
                    setSoundFileCount(soundFilecountResp.getSoundFileCount());
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
                SoundFilecountResp soundFilecountResp = null;
                try {
                    try {
                        SoundFilecountResp soundFilecountResp2 = (SoundFilecountResp) SoundFilecountResp.PARSER.parsePartialFrom(iVar, qVar);
                        if (soundFilecountResp2 != null) {
                            mergeFrom(soundFilecountResp2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e10) {
                        soundFilecountResp = (SoundFilecountResp) e10.getUnfinishedMessage();
                        try {
                            throw e10.unwrapIOException();
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (soundFilecountResp != null) {
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (soundFilecountResp != null) {
                        mergeFrom(soundFilecountResp);
                    }
                    throw th2;
                }
            }
        }

        public static Builder newBuilder(SoundFilecountResp soundFilecountResp) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(soundFilecountResp);
        }

        public static SoundFilecountResp parseFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, qVar);
        }

        private SoundFilecountResp(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static SoundFilecountResp parseDelimitedFrom(InputStream inputStream, q qVar) throws IOException {
            return (SoundFilecountResp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
        }

        public static SoundFilecountResp parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
        public SoundFilecountResp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static SoundFilecountResp parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder newBuilderForType() {
            return newBuilder();
        }

        private SoundFilecountResp() {
            this.memoizedIsInitialized = (byte) -1;
            this.errCode_ = 0;
            this.errMsg_ = "";
            this.totalCount_ = 0;
            this.convertedCount_ = 0;
            this.soundFileCount_ = 0;
        }

        public static SoundFilecountResp parseFrom(InputStream inputStream) throws IOException {
            return (SoundFilecountResp) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.c cVar) {
            return new Builder(cVar);
        }

        public static SoundFilecountResp parseFrom(InputStream inputStream, q qVar) throws IOException {
            return (SoundFilecountResp) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
        }

        public static SoundFilecountResp parseFrom(i iVar) throws IOException {
            return (SoundFilecountResp) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
        }

        public static SoundFilecountResp parseFrom(i iVar, q qVar) throws IOException {
            return (SoundFilecountResp) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
        }

        private SoundFilecountResp(i iVar, q qVar) throws InvalidProtocolBufferException {
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
                            } else if (F == 24) {
                                this.totalCount_ = iVar.t();
                            } else if (F == 32) {
                                this.convertedCount_ = iVar.t();
                            } else if (F == 40) {
                                this.soundFileCount_ = iVar.t();
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
    public interface SoundFilecountRespOrBuilder extends g0 {
        /* synthetic */ List<String> findInitializationErrors();

        @Override // com.google.protobuf.g0
        /* synthetic */ Map<Descriptors.FieldDescriptor, Object> getAllFields();

        int getConvertedCount();

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

        int getSoundFileCount();

        int getTotalCount();

        @Override // com.google.protobuf.g0
        /* synthetic */ a1 getUnknownFields();

        @Override // com.google.protobuf.g0
        /* synthetic */ boolean hasField(Descriptors.FieldDescriptor fieldDescriptor);

        /* synthetic */ boolean hasOneof(Descriptors.h hVar);

        @Override // com.google.protobuf.f0
        /* synthetic */ boolean isInitialized();
    }

    static {
        Descriptors.FileDescriptor.q(new String[]{"\n\u0015sound_filecount.proto\u0012\u001acom.mobvoi.companion.proto\"{\n\u0012SoundFilecountResp\u0012\u0010\n\berr_code\u0018\u0001 \u0001(\u0005\u0012\u000f\n\u0007err_msg\u0018\u0002 \u0001(\t\u0012\u0012\n\ntotalCount\u0018\u0003 \u0001(\u0005\u0012\u0016\n\u000econvertedCount\u0018\u0004 \u0001(\u0005\u0012\u0016\n\u000esoundFileCount\u0018\u0005 \u0001(\u0005B\u0010B\u000eFilecountProtob\u0006proto3"}, new Descriptors.FileDescriptor[0], new Descriptors.FileDescriptor.a() { // from class: com.mobvoi.companion.proto.FilecountProto.1
            @Override // com.google.protobuf.Descriptors.FileDescriptor.a
            public o assignDescriptors(Descriptors.FileDescriptor fileDescriptor) {
                Descriptors.FileDescriptor unused = FilecountProto.descriptor = fileDescriptor;
                return null;
            }
        });
        Descriptors.b bVar = getDescriptor().j().get(0);
        internal_static_com_mobvoi_companion_proto_SoundFilecountResp_descriptor = bVar;
        internal_static_com_mobvoi_companion_proto_SoundFilecountResp_fieldAccessorTable = new GeneratedMessageV3.e(bVar, new String[]{"ErrCode", "ErrMsg", "TotalCount", "ConvertedCount", "SoundFileCount"});
    }

    private FilecountProto() {
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
