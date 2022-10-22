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
import com.mobvoi.companion.proto.ConstantProto;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
/* loaded from: classes2.dex */
public final class DeviceProto {
    private static Descriptors.FileDescriptor descriptor;
    private static final Descriptors.b internal_static_com_mobvoi_companion_proto_SoundBindDeviceResp_descriptor;
    private static final GeneratedMessageV3.e internal_static_com_mobvoi_companion_proto_SoundBindDeviceResp_fieldAccessorTable;
    private static final Descriptors.b internal_static_com_mobvoi_companion_proto_SoundBindDevice_descriptor;
    private static final GeneratedMessageV3.e internal_static_com_mobvoi_companion_proto_SoundBindDevice_fieldAccessorTable;
    private static final Descriptors.b internal_static_com_mobvoi_companion_proto_SoundDeviceResp_descriptor;
    private static final GeneratedMessageV3.e internal_static_com_mobvoi_companion_proto_SoundDeviceResp_fieldAccessorTable;
    private static final Descriptors.b internal_static_com_mobvoi_companion_proto_SoundDevice_descriptor;
    private static final GeneratedMessageV3.e internal_static_com_mobvoi_companion_proto_SoundDevice_fieldAccessorTable;

    /* loaded from: classes2.dex */
    public static final class SoundBindDevice extends GeneratedMessageV3 implements SoundBindDeviceOrBuilder {
        public static final int DEVICE_ID_FIELD_NUMBER = 1;
        public static final int DEVICE_TYPE_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private volatile Object deviceId_;
        private volatile Object deviceType_;
        private byte memoizedIsInitialized;
        private static final SoundBindDevice DEFAULT_INSTANCE = new SoundBindDevice();
        private static final l0<SoundBindDevice> PARSER = new c<SoundBindDevice>() { // from class: com.mobvoi.companion.proto.DeviceProto.SoundBindDevice.1
            @Override // com.google.protobuf.l0
            public SoundBindDevice parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
                return new SoundBindDevice(iVar, qVar);
            }
        };

        public static SoundBindDevice getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return DeviceProto.internal_static_com_mobvoi_companion_proto_SoundBindDevice_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static SoundBindDevice parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (SoundBindDevice) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static SoundBindDevice parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static l0<SoundBindDevice> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof SoundBindDevice)) {
                return super.equals(obj);
            }
            SoundBindDevice soundBindDevice = (SoundBindDevice) obj;
            return (getDeviceId().equals(soundBindDevice.getDeviceId())) && getDeviceType().equals(soundBindDevice.getDeviceType());
        }

        @Override // com.mobvoi.companion.proto.DeviceProto.SoundBindDeviceOrBuilder
        public String getDeviceId() {
            Object obj = this.deviceId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.deviceId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.proto.DeviceProto.SoundBindDeviceOrBuilder
        public ByteString getDeviceIdBytes() {
            Object obj = this.deviceId_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.deviceId_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.mobvoi.companion.proto.DeviceProto.SoundBindDeviceOrBuilder
        public String getDeviceType() {
            Object obj = this.deviceType_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.deviceType_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.proto.DeviceProto.SoundBindDeviceOrBuilder
        public ByteString getDeviceTypeBytes() {
            Object obj = this.deviceType_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.deviceType_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public l0<SoundBindDevice> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
        public int getSerializedSize() {
            int i10 = this.memoizedSize;
            if (i10 != -1) {
                return i10;
            }
            int i11 = 0;
            if (!getDeviceIdBytes().isEmpty()) {
                i11 = 0 + GeneratedMessageV3.computeStringSize(1, this.deviceId_);
            }
            if (!getDeviceTypeBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(2, this.deviceType_);
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
            int hashCode = ((((((((((779 + getDescriptorForType().hashCode()) * 37) + 1) * 53) + getDeviceId().hashCode()) * 37) + 2) * 53) + getDeviceType().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return DeviceProto.internal_static_com_mobvoi_companion_proto_SoundBindDevice_fieldAccessorTable.e(SoundBindDevice.class, Builder.class);
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
            if (!getDeviceIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.deviceId_);
            }
            if (!getDeviceTypeBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.deviceType_);
            }
        }

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageV3.b<Builder> implements SoundBindDeviceOrBuilder {
            private Object deviceId_;
            private Object deviceType_;

            public static final Descriptors.b getDescriptor() {
                return DeviceProto.internal_static_com_mobvoi_companion_proto_SoundBindDevice_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            public Builder clearDeviceId() {
                this.deviceId_ = SoundBindDevice.getDefaultInstance().getDeviceId();
                onChanged();
                return this;
            }

            public Builder clearDeviceType() {
                this.deviceType_ = SoundBindDevice.getDefaultInstance().getDeviceType();
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a, com.google.protobuf.g0
            public Descriptors.b getDescriptorForType() {
                return DeviceProto.internal_static_com_mobvoi_companion_proto_SoundBindDevice_descriptor;
            }

            @Override // com.mobvoi.companion.proto.DeviceProto.SoundBindDeviceOrBuilder
            public String getDeviceId() {
                Object obj = this.deviceId_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.deviceId_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.proto.DeviceProto.SoundBindDeviceOrBuilder
            public ByteString getDeviceIdBytes() {
                Object obj = this.deviceId_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.deviceId_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.mobvoi.companion.proto.DeviceProto.SoundBindDeviceOrBuilder
            public String getDeviceType() {
                Object obj = this.deviceType_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.deviceType_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.proto.DeviceProto.SoundBindDeviceOrBuilder
            public ByteString getDeviceTypeBytes() {
                Object obj = this.deviceType_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.deviceType_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return DeviceProto.internal_static_com_mobvoi_companion_proto_SoundBindDevice_fieldAccessorTable.e(SoundBindDevice.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.f0
            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a
            public final Builder mergeUnknownFields(a1 a1Var) {
                return this;
            }

            public Builder setDeviceId(String str) {
                Objects.requireNonNull(str);
                this.deviceId_ = str;
                onChanged();
                return this;
            }

            public Builder setDeviceIdBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                b.checkByteStringIsUtf8(byteString);
                this.deviceId_ = byteString;
                onChanged();
                return this;
            }

            public Builder setDeviceType(String str) {
                Objects.requireNonNull(str);
                this.deviceType_ = str;
                onChanged();
                return this;
            }

            public Builder setDeviceTypeBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                b.checkByteStringIsUtf8(byteString);
                this.deviceType_ = byteString;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public final Builder setUnknownFields(a1 a1Var) {
                return this;
            }

            private Builder() {
                this.deviceId_ = "";
                this.deviceType_ = "";
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.e0.a, com.google.protobuf.d0.a
            public SoundBindDevice build() {
                SoundBindDevice buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) buildPartial);
            }

            @Override // com.google.protobuf.e0.a, com.google.protobuf.d0.a
            public SoundBindDevice buildPartial() {
                SoundBindDevice soundBindDevice = new SoundBindDevice(this);
                soundBindDevice.deviceId_ = this.deviceId_;
                soundBindDevice.deviceType_ = this.deviceType_;
                onBuilt();
                return soundBindDevice;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.f0, com.google.protobuf.g0
            public SoundBindDevice getDefaultInstanceForType() {
                return SoundBindDevice.getDefaultInstance();
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
                this.deviceId_ = "";
                this.deviceType_ = "";
                return this;
            }

            private Builder(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.deviceId_ = "";
                this.deviceType_ = "";
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a, com.google.protobuf.b.a
            public Builder clone() {
                return (Builder) super.clone();
            }

            @Override // com.google.protobuf.a.AbstractC0170a, com.google.protobuf.d0.a
            public Builder mergeFrom(d0 d0Var) {
                if (d0Var instanceof SoundBindDevice) {
                    return mergeFrom((SoundBindDevice) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            public Builder mergeFrom(SoundBindDevice soundBindDevice) {
                if (soundBindDevice == SoundBindDevice.getDefaultInstance()) {
                    return this;
                }
                if (!soundBindDevice.getDeviceId().isEmpty()) {
                    this.deviceId_ = soundBindDevice.deviceId_;
                    onChanged();
                }
                if (!soundBindDevice.getDeviceType().isEmpty()) {
                    this.deviceType_ = soundBindDevice.deviceType_;
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
                SoundBindDevice soundBindDevice = null;
                try {
                    try {
                        SoundBindDevice soundBindDevice2 = (SoundBindDevice) SoundBindDevice.PARSER.parsePartialFrom(iVar, qVar);
                        if (soundBindDevice2 != null) {
                            mergeFrom(soundBindDevice2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e10) {
                        soundBindDevice = (SoundBindDevice) e10.getUnfinishedMessage();
                        try {
                            throw e10.unwrapIOException();
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (soundBindDevice != null) {
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (soundBindDevice != null) {
                        mergeFrom(soundBindDevice);
                    }
                    throw th2;
                }
            }
        }

        public static Builder newBuilder(SoundBindDevice soundBindDevice) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(soundBindDevice);
        }

        public static SoundBindDevice parseFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, qVar);
        }

        private SoundBindDevice(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static SoundBindDevice parseDelimitedFrom(InputStream inputStream, q qVar) throws IOException {
            return (SoundBindDevice) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
        }

        public static SoundBindDevice parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
        public SoundBindDevice getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static SoundBindDevice parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder newBuilderForType() {
            return newBuilder();
        }

        private SoundBindDevice() {
            this.memoizedIsInitialized = (byte) -1;
            this.deviceId_ = "";
            this.deviceType_ = "";
        }

        public static SoundBindDevice parseFrom(InputStream inputStream) throws IOException {
            return (SoundBindDevice) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.c cVar) {
            return new Builder(cVar);
        }

        public static SoundBindDevice parseFrom(InputStream inputStream, q qVar) throws IOException {
            return (SoundBindDevice) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
        }

        private SoundBindDevice(i iVar, q qVar) throws InvalidProtocolBufferException {
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
                                    this.deviceId_ = iVar.E();
                                } else if (F == 18) {
                                    this.deviceType_ = iVar.E();
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

        public static SoundBindDevice parseFrom(i iVar) throws IOException {
            return (SoundBindDevice) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
        }

        public static SoundBindDevice parseFrom(i iVar, q qVar) throws IOException {
            return (SoundBindDevice) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
        }
    }

    /* loaded from: classes2.dex */
    public interface SoundBindDeviceOrBuilder extends g0 {
        /* synthetic */ List<String> findInitializationErrors();

        @Override // com.google.protobuf.g0
        /* synthetic */ Map<Descriptors.FieldDescriptor, Object> getAllFields();

        @Override // com.google.protobuf.g0
        /* synthetic */ d0 getDefaultInstanceForType();

        @Override // com.google.protobuf.g0
        /* synthetic */ e0 getDefaultInstanceForType();

        @Override // com.google.protobuf.g0
        /* synthetic */ Descriptors.b getDescriptorForType();

        String getDeviceId();

        ByteString getDeviceIdBytes();

        String getDeviceType();

        ByteString getDeviceTypeBytes();

        @Override // com.google.protobuf.g0
        /* synthetic */ Object getField(Descriptors.FieldDescriptor fieldDescriptor);

        /* synthetic */ String getInitializationErrorString();

        /* synthetic */ Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.h hVar);

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
    public static final class SoundBindDeviceResp extends GeneratedMessageV3 implements SoundBindDeviceRespOrBuilder {
        public static final int BIND_DEVICES_FIELD_NUMBER = 3;
        public static final int ERR_CODE_FIELD_NUMBER = 1;
        public static final int ERR_MSG_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private List<SoundBindDevice> bindDevices_;
        private int bitField0_;
        private int errCode_;
        private volatile Object errMsg_;
        private byte memoizedIsInitialized;
        private static final SoundBindDeviceResp DEFAULT_INSTANCE = new SoundBindDeviceResp();
        private static final l0<SoundBindDeviceResp> PARSER = new c<SoundBindDeviceResp>() { // from class: com.mobvoi.companion.proto.DeviceProto.SoundBindDeviceResp.1
            @Override // com.google.protobuf.l0
            public SoundBindDeviceResp parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
                return new SoundBindDeviceResp(iVar, qVar);
            }
        };

        public static SoundBindDeviceResp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return DeviceProto.internal_static_com_mobvoi_companion_proto_SoundBindDeviceResp_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static SoundBindDeviceResp parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (SoundBindDeviceResp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static SoundBindDeviceResp parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static l0<SoundBindDeviceResp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof SoundBindDeviceResp)) {
                return super.equals(obj);
            }
            SoundBindDeviceResp soundBindDeviceResp = (SoundBindDeviceResp) obj;
            return ((getErrCode() == soundBindDeviceResp.getErrCode()) && getErrMsg().equals(soundBindDeviceResp.getErrMsg())) && getBindDevicesList().equals(soundBindDeviceResp.getBindDevicesList());
        }

        @Override // com.mobvoi.companion.proto.DeviceProto.SoundBindDeviceRespOrBuilder
        public SoundBindDevice getBindDevices(int i10) {
            return this.bindDevices_.get(i10);
        }

        @Override // com.mobvoi.companion.proto.DeviceProto.SoundBindDeviceRespOrBuilder
        public int getBindDevicesCount() {
            return this.bindDevices_.size();
        }

        @Override // com.mobvoi.companion.proto.DeviceProto.SoundBindDeviceRespOrBuilder
        public List<SoundBindDevice> getBindDevicesList() {
            return this.bindDevices_;
        }

        @Override // com.mobvoi.companion.proto.DeviceProto.SoundBindDeviceRespOrBuilder
        public SoundBindDeviceOrBuilder getBindDevicesOrBuilder(int i10) {
            return this.bindDevices_.get(i10);
        }

        @Override // com.mobvoi.companion.proto.DeviceProto.SoundBindDeviceRespOrBuilder
        public List<? extends SoundBindDeviceOrBuilder> getBindDevicesOrBuilderList() {
            return this.bindDevices_;
        }

        @Override // com.mobvoi.companion.proto.DeviceProto.SoundBindDeviceRespOrBuilder
        public int getErrCode() {
            return this.errCode_;
        }

        @Override // com.mobvoi.companion.proto.DeviceProto.SoundBindDeviceRespOrBuilder
        public String getErrMsg() {
            Object obj = this.errMsg_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.errMsg_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.proto.DeviceProto.SoundBindDeviceRespOrBuilder
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
        public l0<SoundBindDeviceResp> getParserForType() {
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
            for (int i12 = 0; i12 < this.bindDevices_.size(); i12++) {
                v10 += CodedOutputStream.E(3, this.bindDevices_.get(i12));
            }
            this.memoizedSize = v10;
            return v10;
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
            if (getBindDevicesCount() > 0) {
                hashCode = (((hashCode * 37) + 3) * 53) + getBindDevicesList().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return DeviceProto.internal_static_com_mobvoi_companion_proto_SoundBindDeviceResp_fieldAccessorTable.e(SoundBindDeviceResp.class, Builder.class);
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
            for (int i11 = 0; i11 < this.bindDevices_.size(); i11++) {
                codedOutputStream.A0(3, this.bindDevices_.get(i11));
            }
        }

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageV3.b<Builder> implements SoundBindDeviceRespOrBuilder {
            private o0<SoundBindDevice, SoundBindDevice.Builder, SoundBindDeviceOrBuilder> bindDevicesBuilder_;
            private List<SoundBindDevice> bindDevices_;
            private int bitField0_;
            private int errCode_;
            private Object errMsg_;

            private void ensureBindDevicesIsMutable() {
                if ((this.bitField0_ & 4) != 4) {
                    this.bindDevices_ = new ArrayList(this.bindDevices_);
                    this.bitField0_ |= 4;
                }
            }

            private o0<SoundBindDevice, SoundBindDevice.Builder, SoundBindDeviceOrBuilder> getBindDevicesFieldBuilder() {
                if (this.bindDevicesBuilder_ == null) {
                    this.bindDevicesBuilder_ = new o0<>(this.bindDevices_, (this.bitField0_ & 4) == 4, getParentForChildren(), isClean());
                    this.bindDevices_ = null;
                }
                return this.bindDevicesBuilder_;
            }

            public static final Descriptors.b getDescriptor() {
                return DeviceProto.internal_static_com_mobvoi_companion_proto_SoundBindDeviceResp_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                    getBindDevicesFieldBuilder();
                }
            }

            public Builder addAllBindDevices(Iterable<? extends SoundBindDevice> iterable) {
                o0<SoundBindDevice, SoundBindDevice.Builder, SoundBindDeviceOrBuilder> o0Var = this.bindDevicesBuilder_;
                if (o0Var == null) {
                    ensureBindDevicesIsMutable();
                    b.a.addAll(iterable, this.bindDevices_);
                    onChanged();
                } else {
                    o0Var.b(iterable);
                }
                return this;
            }

            public Builder addBindDevices(SoundBindDevice soundBindDevice) {
                o0<SoundBindDevice, SoundBindDevice.Builder, SoundBindDeviceOrBuilder> o0Var = this.bindDevicesBuilder_;
                if (o0Var == null) {
                    Objects.requireNonNull(soundBindDevice);
                    ensureBindDevicesIsMutable();
                    this.bindDevices_.add(soundBindDevice);
                    onChanged();
                } else {
                    o0Var.f(soundBindDevice);
                }
                return this;
            }

            public SoundBindDevice.Builder addBindDevicesBuilder() {
                return getBindDevicesFieldBuilder().d(SoundBindDevice.getDefaultInstance());
            }

            public Builder clearBindDevices() {
                o0<SoundBindDevice, SoundBindDevice.Builder, SoundBindDeviceOrBuilder> o0Var = this.bindDevicesBuilder_;
                if (o0Var == null) {
                    this.bindDevices_ = Collections.emptyList();
                    this.bitField0_ &= -5;
                    onChanged();
                } else {
                    o0Var.h();
                }
                return this;
            }

            public Builder clearErrCode() {
                this.errCode_ = 0;
                onChanged();
                return this;
            }

            public Builder clearErrMsg() {
                this.errMsg_ = SoundBindDeviceResp.getDefaultInstance().getErrMsg();
                onChanged();
                return this;
            }

            @Override // com.mobvoi.companion.proto.DeviceProto.SoundBindDeviceRespOrBuilder
            public SoundBindDevice getBindDevices(int i10) {
                o0<SoundBindDevice, SoundBindDevice.Builder, SoundBindDeviceOrBuilder> o0Var = this.bindDevicesBuilder_;
                if (o0Var == null) {
                    return this.bindDevices_.get(i10);
                }
                return o0Var.o(i10);
            }

            public SoundBindDevice.Builder getBindDevicesBuilder(int i10) {
                return getBindDevicesFieldBuilder().l(i10);
            }

            public List<SoundBindDevice.Builder> getBindDevicesBuilderList() {
                return getBindDevicesFieldBuilder().m();
            }

            @Override // com.mobvoi.companion.proto.DeviceProto.SoundBindDeviceRespOrBuilder
            public int getBindDevicesCount() {
                o0<SoundBindDevice, SoundBindDevice.Builder, SoundBindDeviceOrBuilder> o0Var = this.bindDevicesBuilder_;
                if (o0Var == null) {
                    return this.bindDevices_.size();
                }
                return o0Var.n();
            }

            @Override // com.mobvoi.companion.proto.DeviceProto.SoundBindDeviceRespOrBuilder
            public List<SoundBindDevice> getBindDevicesList() {
                o0<SoundBindDevice, SoundBindDevice.Builder, SoundBindDeviceOrBuilder> o0Var = this.bindDevicesBuilder_;
                if (o0Var == null) {
                    return Collections.unmodifiableList(this.bindDevices_);
                }
                return o0Var.q();
            }

            @Override // com.mobvoi.companion.proto.DeviceProto.SoundBindDeviceRespOrBuilder
            public SoundBindDeviceOrBuilder getBindDevicesOrBuilder(int i10) {
                o0<SoundBindDevice, SoundBindDevice.Builder, SoundBindDeviceOrBuilder> o0Var = this.bindDevicesBuilder_;
                if (o0Var == null) {
                    return this.bindDevices_.get(i10);
                }
                return o0Var.r(i10);
            }

            @Override // com.mobvoi.companion.proto.DeviceProto.SoundBindDeviceRespOrBuilder
            public List<? extends SoundBindDeviceOrBuilder> getBindDevicesOrBuilderList() {
                o0<SoundBindDevice, SoundBindDevice.Builder, SoundBindDeviceOrBuilder> o0Var = this.bindDevicesBuilder_;
                if (o0Var != null) {
                    return o0Var.s();
                }
                return Collections.unmodifiableList(this.bindDevices_);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a, com.google.protobuf.g0
            public Descriptors.b getDescriptorForType() {
                return DeviceProto.internal_static_com_mobvoi_companion_proto_SoundBindDeviceResp_descriptor;
            }

            @Override // com.mobvoi.companion.proto.DeviceProto.SoundBindDeviceRespOrBuilder
            public int getErrCode() {
                return this.errCode_;
            }

            @Override // com.mobvoi.companion.proto.DeviceProto.SoundBindDeviceRespOrBuilder
            public String getErrMsg() {
                Object obj = this.errMsg_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.errMsg_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.proto.DeviceProto.SoundBindDeviceRespOrBuilder
            public ByteString getErrMsgBytes() {
                Object obj = this.errMsg_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.errMsg_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return DeviceProto.internal_static_com_mobvoi_companion_proto_SoundBindDeviceResp_fieldAccessorTable.e(SoundBindDeviceResp.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.f0
            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a
            public final Builder mergeUnknownFields(a1 a1Var) {
                return this;
            }

            public Builder removeBindDevices(int i10) {
                o0<SoundBindDevice, SoundBindDevice.Builder, SoundBindDeviceOrBuilder> o0Var = this.bindDevicesBuilder_;
                if (o0Var == null) {
                    ensureBindDevicesIsMutable();
                    this.bindDevices_.remove(i10);
                    onChanged();
                } else {
                    o0Var.w(i10);
                }
                return this;
            }

            public Builder setBindDevices(int i10, SoundBindDevice soundBindDevice) {
                o0<SoundBindDevice, SoundBindDevice.Builder, SoundBindDeviceOrBuilder> o0Var = this.bindDevicesBuilder_;
                if (o0Var == null) {
                    Objects.requireNonNull(soundBindDevice);
                    ensureBindDevicesIsMutable();
                    this.bindDevices_.set(i10, soundBindDevice);
                    onChanged();
                } else {
                    o0Var.x(i10, soundBindDevice);
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

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public final Builder setUnknownFields(a1 a1Var) {
                return this;
            }

            private Builder() {
                this.errMsg_ = "";
                this.bindDevices_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.e0.a, com.google.protobuf.d0.a
            public SoundBindDeviceResp build() {
                SoundBindDeviceResp buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) buildPartial);
            }

            @Override // com.google.protobuf.e0.a, com.google.protobuf.d0.a
            public SoundBindDeviceResp buildPartial() {
                SoundBindDeviceResp soundBindDeviceResp = new SoundBindDeviceResp(this);
                soundBindDeviceResp.errCode_ = this.errCode_;
                soundBindDeviceResp.errMsg_ = this.errMsg_;
                o0<SoundBindDevice, SoundBindDevice.Builder, SoundBindDeviceOrBuilder> o0Var = this.bindDevicesBuilder_;
                if (o0Var == null) {
                    if ((this.bitField0_ & 4) == 4) {
                        this.bindDevices_ = Collections.unmodifiableList(this.bindDevices_);
                        this.bitField0_ &= -5;
                    }
                    soundBindDeviceResp.bindDevices_ = this.bindDevices_;
                } else {
                    soundBindDeviceResp.bindDevices_ = o0Var.g();
                }
                soundBindDeviceResp.bitField0_ = 0;
                onBuilt();
                return soundBindDeviceResp;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.f0, com.google.protobuf.g0
            public SoundBindDeviceResp getDefaultInstanceForType() {
                return SoundBindDeviceResp.getDefaultInstance();
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

            public SoundBindDevice.Builder addBindDevicesBuilder(int i10) {
                return getBindDevicesFieldBuilder().c(i10, SoundBindDevice.getDefaultInstance());
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
                o0<SoundBindDevice, SoundBindDevice.Builder, SoundBindDeviceOrBuilder> o0Var = this.bindDevicesBuilder_;
                if (o0Var == null) {
                    this.bindDevices_ = Collections.emptyList();
                    this.bitField0_ &= -5;
                } else {
                    o0Var.h();
                }
                return this;
            }

            private Builder(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.errMsg_ = "";
                this.bindDevices_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            public Builder addBindDevices(int i10, SoundBindDevice soundBindDevice) {
                o0<SoundBindDevice, SoundBindDevice.Builder, SoundBindDeviceOrBuilder> o0Var = this.bindDevicesBuilder_;
                if (o0Var == null) {
                    Objects.requireNonNull(soundBindDevice);
                    ensureBindDevicesIsMutable();
                    this.bindDevices_.add(i10, soundBindDevice);
                    onChanged();
                } else {
                    o0Var.e(i10, soundBindDevice);
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a, com.google.protobuf.b.a
            public Builder clone() {
                return (Builder) super.clone();
            }

            @Override // com.google.protobuf.a.AbstractC0170a, com.google.protobuf.d0.a
            public Builder mergeFrom(d0 d0Var) {
                if (d0Var instanceof SoundBindDeviceResp) {
                    return mergeFrom((SoundBindDeviceResp) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            public Builder setBindDevices(int i10, SoundBindDevice.Builder builder) {
                o0<SoundBindDevice, SoundBindDevice.Builder, SoundBindDeviceOrBuilder> o0Var = this.bindDevicesBuilder_;
                if (o0Var == null) {
                    ensureBindDevicesIsMutable();
                    this.bindDevices_.set(i10, builder.build());
                    onChanged();
                } else {
                    o0Var.x(i10, builder.build());
                }
                return this;
            }

            public Builder mergeFrom(SoundBindDeviceResp soundBindDeviceResp) {
                if (soundBindDeviceResp == SoundBindDeviceResp.getDefaultInstance()) {
                    return this;
                }
                if (soundBindDeviceResp.getErrCode() != 0) {
                    setErrCode(soundBindDeviceResp.getErrCode());
                }
                if (!soundBindDeviceResp.getErrMsg().isEmpty()) {
                    this.errMsg_ = soundBindDeviceResp.errMsg_;
                    onChanged();
                }
                if (this.bindDevicesBuilder_ == null) {
                    if (!soundBindDeviceResp.bindDevices_.isEmpty()) {
                        if (this.bindDevices_.isEmpty()) {
                            this.bindDevices_ = soundBindDeviceResp.bindDevices_;
                            this.bitField0_ &= -5;
                        } else {
                            ensureBindDevicesIsMutable();
                            this.bindDevices_.addAll(soundBindDeviceResp.bindDevices_);
                        }
                        onChanged();
                    }
                } else if (!soundBindDeviceResp.bindDevices_.isEmpty()) {
                    if (this.bindDevicesBuilder_.u()) {
                        this.bindDevicesBuilder_.i();
                        o0<SoundBindDevice, SoundBindDevice.Builder, SoundBindDeviceOrBuilder> o0Var = null;
                        this.bindDevicesBuilder_ = null;
                        this.bindDevices_ = soundBindDeviceResp.bindDevices_;
                        this.bitField0_ &= -5;
                        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                            o0Var = getBindDevicesFieldBuilder();
                        }
                        this.bindDevicesBuilder_ = o0Var;
                    } else {
                        this.bindDevicesBuilder_.b(soundBindDeviceResp.bindDevices_);
                    }
                }
                onChanged();
                return this;
            }

            public Builder addBindDevices(SoundBindDevice.Builder builder) {
                o0<SoundBindDevice, SoundBindDevice.Builder, SoundBindDeviceOrBuilder> o0Var = this.bindDevicesBuilder_;
                if (o0Var == null) {
                    ensureBindDevicesIsMutable();
                    this.bindDevices_.add(builder.build());
                    onChanged();
                } else {
                    o0Var.f(builder.build());
                }
                return this;
            }

            public Builder addBindDevices(int i10, SoundBindDevice.Builder builder) {
                o0<SoundBindDevice, SoundBindDevice.Builder, SoundBindDeviceOrBuilder> o0Var = this.bindDevicesBuilder_;
                if (o0Var == null) {
                    ensureBindDevicesIsMutable();
                    this.bindDevices_.add(i10, builder.build());
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
                SoundBindDeviceResp soundBindDeviceResp = null;
                try {
                    try {
                        SoundBindDeviceResp soundBindDeviceResp2 = (SoundBindDeviceResp) SoundBindDeviceResp.PARSER.parsePartialFrom(iVar, qVar);
                        if (soundBindDeviceResp2 != null) {
                            mergeFrom(soundBindDeviceResp2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e10) {
                        soundBindDeviceResp = (SoundBindDeviceResp) e10.getUnfinishedMessage();
                        try {
                            throw e10.unwrapIOException();
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (soundBindDeviceResp != null) {
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (soundBindDeviceResp != null) {
                        mergeFrom(soundBindDeviceResp);
                    }
                    throw th2;
                }
            }
        }

        public static Builder newBuilder(SoundBindDeviceResp soundBindDeviceResp) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(soundBindDeviceResp);
        }

        public static SoundBindDeviceResp parseFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, qVar);
        }

        private SoundBindDeviceResp(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static SoundBindDeviceResp parseDelimitedFrom(InputStream inputStream, q qVar) throws IOException {
            return (SoundBindDeviceResp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
        }

        public static SoundBindDeviceResp parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
        public SoundBindDeviceResp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static SoundBindDeviceResp parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder newBuilderForType() {
            return newBuilder();
        }

        private SoundBindDeviceResp() {
            this.memoizedIsInitialized = (byte) -1;
            this.errCode_ = 0;
            this.errMsg_ = "";
            this.bindDevices_ = Collections.emptyList();
        }

        public static SoundBindDeviceResp parseFrom(InputStream inputStream) throws IOException {
            return (SoundBindDeviceResp) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.c cVar) {
            return new Builder(cVar);
        }

        public static SoundBindDeviceResp parseFrom(InputStream inputStream, q qVar) throws IOException {
            return (SoundBindDeviceResp) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
        }

        public static SoundBindDeviceResp parseFrom(i iVar) throws IOException {
            return (SoundBindDeviceResp) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
        }

        private SoundBindDeviceResp(i iVar, q qVar) throws InvalidProtocolBufferException {
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
                                    this.bindDevices_ = new ArrayList();
                                    z11 |= true;
                                }
                                this.bindDevices_.add((SoundBindDevice) iVar.v(SoundBindDevice.parser(), qVar));
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
                        this.bindDevices_ = Collections.unmodifiableList(this.bindDevices_);
                    }
                    makeExtensionsImmutable();
                }
            }
        }

        public static SoundBindDeviceResp parseFrom(i iVar, q qVar) throws IOException {
            return (SoundBindDeviceResp) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
        }
    }

    /* loaded from: classes2.dex */
    public interface SoundBindDeviceRespOrBuilder extends g0 {
        /* synthetic */ List<String> findInitializationErrors();

        @Override // com.google.protobuf.g0
        /* synthetic */ Map<Descriptors.FieldDescriptor, Object> getAllFields();

        SoundBindDevice getBindDevices(int i10);

        int getBindDevicesCount();

        List<SoundBindDevice> getBindDevicesList();

        SoundBindDeviceOrBuilder getBindDevicesOrBuilder(int i10);

        List<? extends SoundBindDeviceOrBuilder> getBindDevicesOrBuilderList();

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

        @Override // com.google.protobuf.g0
        /* synthetic */ a1 getUnknownFields();

        @Override // com.google.protobuf.g0
        /* synthetic */ boolean hasField(Descriptors.FieldDescriptor fieldDescriptor);

        /* synthetic */ boolean hasOneof(Descriptors.h hVar);

        @Override // com.google.protobuf.f0
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes2.dex */
    public static final class SoundDevice extends GeneratedMessageV3 implements SoundDeviceOrBuilder {
        public static final int DEVICE_ID_FIELD_NUMBER = 1;
        public static final int DEVICE_NAME_FIELD_NUMBER = 2;
        public static final int DEVICE_TYPE_FIELD_NUMBER = 3;
        private static final long serialVersionUID = 0;
        private volatile Object deviceId_;
        private volatile Object deviceName_;
        private int deviceType_;
        private byte memoizedIsInitialized;
        private static final SoundDevice DEFAULT_INSTANCE = new SoundDevice();
        private static final l0<SoundDevice> PARSER = new c<SoundDevice>() { // from class: com.mobvoi.companion.proto.DeviceProto.SoundDevice.1
            @Override // com.google.protobuf.l0
            public SoundDevice parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
                return new SoundDevice(iVar, qVar);
            }
        };

        public static SoundDevice getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return DeviceProto.internal_static_com_mobvoi_companion_proto_SoundDevice_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static SoundDevice parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (SoundDevice) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static SoundDevice parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static l0<SoundDevice> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof SoundDevice)) {
                return super.equals(obj);
            }
            SoundDevice soundDevice = (SoundDevice) obj;
            return ((getDeviceId().equals(soundDevice.getDeviceId())) && getDeviceName().equals(soundDevice.getDeviceName())) && this.deviceType_ == soundDevice.deviceType_;
        }

        @Override // com.mobvoi.companion.proto.DeviceProto.SoundDeviceOrBuilder
        public String getDeviceId() {
            Object obj = this.deviceId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.deviceId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.proto.DeviceProto.SoundDeviceOrBuilder
        public ByteString getDeviceIdBytes() {
            Object obj = this.deviceId_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.deviceId_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.mobvoi.companion.proto.DeviceProto.SoundDeviceOrBuilder
        public String getDeviceName() {
            Object obj = this.deviceName_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.deviceName_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.proto.DeviceProto.SoundDeviceOrBuilder
        public ByteString getDeviceNameBytes() {
            Object obj = this.deviceName_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.deviceName_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.mobvoi.companion.proto.DeviceProto.SoundDeviceOrBuilder
        public ConstantProto.DeviceType getDeviceType() {
            ConstantProto.DeviceType valueOf = ConstantProto.DeviceType.valueOf(this.deviceType_);
            return valueOf == null ? ConstantProto.DeviceType.UNRECOGNIZED : valueOf;
        }

        @Override // com.mobvoi.companion.proto.DeviceProto.SoundDeviceOrBuilder
        public int getDeviceTypeValue() {
            return this.deviceType_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public l0<SoundDevice> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
        public int getSerializedSize() {
            int i10 = this.memoizedSize;
            if (i10 != -1) {
                return i10;
            }
            int i11 = 0;
            if (!getDeviceIdBytes().isEmpty()) {
                i11 = 0 + GeneratedMessageV3.computeStringSize(1, this.deviceId_);
            }
            if (!getDeviceNameBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(2, this.deviceName_);
            }
            if (this.deviceType_ != ConstantProto.DeviceType.UNKNOWN_DEVICE_TYPE.getNumber()) {
                i11 += CodedOutputStream.l(3, this.deviceType_);
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
            int hashCode = ((((((((((((((779 + getDescriptorForType().hashCode()) * 37) + 1) * 53) + getDeviceId().hashCode()) * 37) + 2) * 53) + getDeviceName().hashCode()) * 37) + 3) * 53) + this.deviceType_) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return DeviceProto.internal_static_com_mobvoi_companion_proto_SoundDevice_fieldAccessorTable.e(SoundDevice.class, Builder.class);
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
            if (!getDeviceIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.deviceId_);
            }
            if (!getDeviceNameBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.deviceName_);
            }
            if (this.deviceType_ != ConstantProto.DeviceType.UNKNOWN_DEVICE_TYPE.getNumber()) {
                codedOutputStream.m0(3, this.deviceType_);
            }
        }

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageV3.b<Builder> implements SoundDeviceOrBuilder {
            private Object deviceId_;
            private Object deviceName_;
            private int deviceType_;

            public static final Descriptors.b getDescriptor() {
                return DeviceProto.internal_static_com_mobvoi_companion_proto_SoundDevice_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            public Builder clearDeviceId() {
                this.deviceId_ = SoundDevice.getDefaultInstance().getDeviceId();
                onChanged();
                return this;
            }

            public Builder clearDeviceName() {
                this.deviceName_ = SoundDevice.getDefaultInstance().getDeviceName();
                onChanged();
                return this;
            }

            public Builder clearDeviceType() {
                this.deviceType_ = 0;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a, com.google.protobuf.g0
            public Descriptors.b getDescriptorForType() {
                return DeviceProto.internal_static_com_mobvoi_companion_proto_SoundDevice_descriptor;
            }

            @Override // com.mobvoi.companion.proto.DeviceProto.SoundDeviceOrBuilder
            public String getDeviceId() {
                Object obj = this.deviceId_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.deviceId_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.proto.DeviceProto.SoundDeviceOrBuilder
            public ByteString getDeviceIdBytes() {
                Object obj = this.deviceId_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.deviceId_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.mobvoi.companion.proto.DeviceProto.SoundDeviceOrBuilder
            public String getDeviceName() {
                Object obj = this.deviceName_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.deviceName_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.proto.DeviceProto.SoundDeviceOrBuilder
            public ByteString getDeviceNameBytes() {
                Object obj = this.deviceName_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.deviceName_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.mobvoi.companion.proto.DeviceProto.SoundDeviceOrBuilder
            public ConstantProto.DeviceType getDeviceType() {
                ConstantProto.DeviceType valueOf = ConstantProto.DeviceType.valueOf(this.deviceType_);
                return valueOf == null ? ConstantProto.DeviceType.UNRECOGNIZED : valueOf;
            }

            @Override // com.mobvoi.companion.proto.DeviceProto.SoundDeviceOrBuilder
            public int getDeviceTypeValue() {
                return this.deviceType_;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return DeviceProto.internal_static_com_mobvoi_companion_proto_SoundDevice_fieldAccessorTable.e(SoundDevice.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.f0
            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a
            public final Builder mergeUnknownFields(a1 a1Var) {
                return this;
            }

            public Builder setDeviceId(String str) {
                Objects.requireNonNull(str);
                this.deviceId_ = str;
                onChanged();
                return this;
            }

            public Builder setDeviceIdBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                b.checkByteStringIsUtf8(byteString);
                this.deviceId_ = byteString;
                onChanged();
                return this;
            }

            public Builder setDeviceName(String str) {
                Objects.requireNonNull(str);
                this.deviceName_ = str;
                onChanged();
                return this;
            }

            public Builder setDeviceNameBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                b.checkByteStringIsUtf8(byteString);
                this.deviceName_ = byteString;
                onChanged();
                return this;
            }

            public Builder setDeviceType(ConstantProto.DeviceType deviceType) {
                Objects.requireNonNull(deviceType);
                this.deviceType_ = deviceType.getNumber();
                onChanged();
                return this;
            }

            public Builder setDeviceTypeValue(int i10) {
                this.deviceType_ = i10;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public final Builder setUnknownFields(a1 a1Var) {
                return this;
            }

            private Builder() {
                this.deviceId_ = "";
                this.deviceName_ = "";
                this.deviceType_ = 0;
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.e0.a, com.google.protobuf.d0.a
            public SoundDevice build() {
                SoundDevice buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) buildPartial);
            }

            @Override // com.google.protobuf.e0.a, com.google.protobuf.d0.a
            public SoundDevice buildPartial() {
                SoundDevice soundDevice = new SoundDevice(this);
                soundDevice.deviceId_ = this.deviceId_;
                soundDevice.deviceName_ = this.deviceName_;
                soundDevice.deviceType_ = this.deviceType_;
                onBuilt();
                return soundDevice;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.f0, com.google.protobuf.g0
            public SoundDevice getDefaultInstanceForType() {
                return SoundDevice.getDefaultInstance();
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
                this.deviceId_ = "";
                this.deviceName_ = "";
                this.deviceType_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a, com.google.protobuf.b.a
            public Builder clone() {
                return (Builder) super.clone();
            }

            @Override // com.google.protobuf.a.AbstractC0170a, com.google.protobuf.d0.a
            public Builder mergeFrom(d0 d0Var) {
                if (d0Var instanceof SoundDevice) {
                    return mergeFrom((SoundDevice) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            private Builder(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.deviceId_ = "";
                this.deviceName_ = "";
                this.deviceType_ = 0;
                maybeForceBuilderInitialization();
            }

            public Builder mergeFrom(SoundDevice soundDevice) {
                if (soundDevice == SoundDevice.getDefaultInstance()) {
                    return this;
                }
                if (!soundDevice.getDeviceId().isEmpty()) {
                    this.deviceId_ = soundDevice.deviceId_;
                    onChanged();
                }
                if (!soundDevice.getDeviceName().isEmpty()) {
                    this.deviceName_ = soundDevice.deviceName_;
                    onChanged();
                }
                if (soundDevice.deviceType_ != 0) {
                    setDeviceTypeValue(soundDevice.getDeviceTypeValue());
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
                SoundDevice soundDevice = null;
                try {
                    try {
                        SoundDevice soundDevice2 = (SoundDevice) SoundDevice.PARSER.parsePartialFrom(iVar, qVar);
                        if (soundDevice2 != null) {
                            mergeFrom(soundDevice2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e10) {
                        soundDevice = (SoundDevice) e10.getUnfinishedMessage();
                        try {
                            throw e10.unwrapIOException();
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (soundDevice != null) {
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (soundDevice != null) {
                        mergeFrom(soundDevice);
                    }
                    throw th2;
                }
            }
        }

        public static Builder newBuilder(SoundDevice soundDevice) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(soundDevice);
        }

        public static SoundDevice parseFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, qVar);
        }

        private SoundDevice(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static SoundDevice parseDelimitedFrom(InputStream inputStream, q qVar) throws IOException {
            return (SoundDevice) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
        }

        public static SoundDevice parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
        public SoundDevice getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static SoundDevice parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder newBuilderForType() {
            return newBuilder();
        }

        private SoundDevice() {
            this.memoizedIsInitialized = (byte) -1;
            this.deviceId_ = "";
            this.deviceName_ = "";
            this.deviceType_ = 0;
        }

        public static SoundDevice parseFrom(InputStream inputStream) throws IOException {
            return (SoundDevice) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.c cVar) {
            return new Builder(cVar);
        }

        public static SoundDevice parseFrom(InputStream inputStream, q qVar) throws IOException {
            return (SoundDevice) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
        }

        public static SoundDevice parseFrom(i iVar) throws IOException {
            return (SoundDevice) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
        }

        private SoundDevice(i iVar, q qVar) throws InvalidProtocolBufferException {
            this();
            boolean z10 = false;
            while (!z10) {
                try {
                    try {
                        int F = iVar.F();
                        z10 = true;
                        if (F != 0) {
                            if (F == 10) {
                                this.deviceId_ = iVar.E();
                            } else if (F == 18) {
                                this.deviceName_ = iVar.E();
                            } else if (F == 24) {
                                this.deviceType_ = iVar.o();
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

        public static SoundDevice parseFrom(i iVar, q qVar) throws IOException {
            return (SoundDevice) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
        }
    }

    /* loaded from: classes2.dex */
    public interface SoundDeviceOrBuilder extends g0 {
        /* synthetic */ List<String> findInitializationErrors();

        @Override // com.google.protobuf.g0
        /* synthetic */ Map<Descriptors.FieldDescriptor, Object> getAllFields();

        @Override // com.google.protobuf.g0
        /* synthetic */ d0 getDefaultInstanceForType();

        @Override // com.google.protobuf.g0
        /* synthetic */ e0 getDefaultInstanceForType();

        @Override // com.google.protobuf.g0
        /* synthetic */ Descriptors.b getDescriptorForType();

        String getDeviceId();

        ByteString getDeviceIdBytes();

        String getDeviceName();

        ByteString getDeviceNameBytes();

        ConstantProto.DeviceType getDeviceType();

        int getDeviceTypeValue();

        @Override // com.google.protobuf.g0
        /* synthetic */ Object getField(Descriptors.FieldDescriptor fieldDescriptor);

        /* synthetic */ String getInitializationErrorString();

        /* synthetic */ Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.h hVar);

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
    public static final class SoundDeviceResp extends GeneratedMessageV3 implements SoundDeviceRespOrBuilder {
        public static final int DEVICES_FIELD_NUMBER = 3;
        public static final int ERR_CODE_FIELD_NUMBER = 1;
        public static final int ERR_MSG_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private List<SoundDevice> devices_;
        private int errCode_;
        private volatile Object errMsg_;
        private byte memoizedIsInitialized;
        private static final SoundDeviceResp DEFAULT_INSTANCE = new SoundDeviceResp();
        private static final l0<SoundDeviceResp> PARSER = new c<SoundDeviceResp>() { // from class: com.mobvoi.companion.proto.DeviceProto.SoundDeviceResp.1
            @Override // com.google.protobuf.l0
            public SoundDeviceResp parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
                return new SoundDeviceResp(iVar, qVar);
            }
        };

        public static SoundDeviceResp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return DeviceProto.internal_static_com_mobvoi_companion_proto_SoundDeviceResp_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static SoundDeviceResp parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (SoundDeviceResp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static SoundDeviceResp parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static l0<SoundDeviceResp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof SoundDeviceResp)) {
                return super.equals(obj);
            }
            SoundDeviceResp soundDeviceResp = (SoundDeviceResp) obj;
            return ((getErrCode() == soundDeviceResp.getErrCode()) && getErrMsg().equals(soundDeviceResp.getErrMsg())) && getDevicesList().equals(soundDeviceResp.getDevicesList());
        }

        @Override // com.mobvoi.companion.proto.DeviceProto.SoundDeviceRespOrBuilder
        public SoundDevice getDevices(int i10) {
            return this.devices_.get(i10);
        }

        @Override // com.mobvoi.companion.proto.DeviceProto.SoundDeviceRespOrBuilder
        public int getDevicesCount() {
            return this.devices_.size();
        }

        @Override // com.mobvoi.companion.proto.DeviceProto.SoundDeviceRespOrBuilder
        public List<SoundDevice> getDevicesList() {
            return this.devices_;
        }

        @Override // com.mobvoi.companion.proto.DeviceProto.SoundDeviceRespOrBuilder
        public SoundDeviceOrBuilder getDevicesOrBuilder(int i10) {
            return this.devices_.get(i10);
        }

        @Override // com.mobvoi.companion.proto.DeviceProto.SoundDeviceRespOrBuilder
        public List<? extends SoundDeviceOrBuilder> getDevicesOrBuilderList() {
            return this.devices_;
        }

        @Override // com.mobvoi.companion.proto.DeviceProto.SoundDeviceRespOrBuilder
        public int getErrCode() {
            return this.errCode_;
        }

        @Override // com.mobvoi.companion.proto.DeviceProto.SoundDeviceRespOrBuilder
        public String getErrMsg() {
            Object obj = this.errMsg_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.errMsg_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.proto.DeviceProto.SoundDeviceRespOrBuilder
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
        public l0<SoundDeviceResp> getParserForType() {
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
            for (int i12 = 0; i12 < this.devices_.size(); i12++) {
                v10 += CodedOutputStream.E(3, this.devices_.get(i12));
            }
            this.memoizedSize = v10;
            return v10;
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
            if (getDevicesCount() > 0) {
                hashCode = (((hashCode * 37) + 3) * 53) + getDevicesList().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return DeviceProto.internal_static_com_mobvoi_companion_proto_SoundDeviceResp_fieldAccessorTable.e(SoundDeviceResp.class, Builder.class);
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
            for (int i11 = 0; i11 < this.devices_.size(); i11++) {
                codedOutputStream.A0(3, this.devices_.get(i11));
            }
        }

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageV3.b<Builder> implements SoundDeviceRespOrBuilder {
            private int bitField0_;
            private o0<SoundDevice, SoundDevice.Builder, SoundDeviceOrBuilder> devicesBuilder_;
            private List<SoundDevice> devices_;
            private int errCode_;
            private Object errMsg_;

            private void ensureDevicesIsMutable() {
                if ((this.bitField0_ & 4) != 4) {
                    this.devices_ = new ArrayList(this.devices_);
                    this.bitField0_ |= 4;
                }
            }

            public static final Descriptors.b getDescriptor() {
                return DeviceProto.internal_static_com_mobvoi_companion_proto_SoundDeviceResp_descriptor;
            }

            private o0<SoundDevice, SoundDevice.Builder, SoundDeviceOrBuilder> getDevicesFieldBuilder() {
                if (this.devicesBuilder_ == null) {
                    this.devicesBuilder_ = new o0<>(this.devices_, (this.bitField0_ & 4) == 4, getParentForChildren(), isClean());
                    this.devices_ = null;
                }
                return this.devicesBuilder_;
            }

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                    getDevicesFieldBuilder();
                }
            }

            public Builder addAllDevices(Iterable<? extends SoundDevice> iterable) {
                o0<SoundDevice, SoundDevice.Builder, SoundDeviceOrBuilder> o0Var = this.devicesBuilder_;
                if (o0Var == null) {
                    ensureDevicesIsMutable();
                    b.a.addAll(iterable, this.devices_);
                    onChanged();
                } else {
                    o0Var.b(iterable);
                }
                return this;
            }

            public Builder addDevices(SoundDevice soundDevice) {
                o0<SoundDevice, SoundDevice.Builder, SoundDeviceOrBuilder> o0Var = this.devicesBuilder_;
                if (o0Var == null) {
                    Objects.requireNonNull(soundDevice);
                    ensureDevicesIsMutable();
                    this.devices_.add(soundDevice);
                    onChanged();
                } else {
                    o0Var.f(soundDevice);
                }
                return this;
            }

            public SoundDevice.Builder addDevicesBuilder() {
                return getDevicesFieldBuilder().d(SoundDevice.getDefaultInstance());
            }

            public Builder clearDevices() {
                o0<SoundDevice, SoundDevice.Builder, SoundDeviceOrBuilder> o0Var = this.devicesBuilder_;
                if (o0Var == null) {
                    this.devices_ = Collections.emptyList();
                    this.bitField0_ &= -5;
                    onChanged();
                } else {
                    o0Var.h();
                }
                return this;
            }

            public Builder clearErrCode() {
                this.errCode_ = 0;
                onChanged();
                return this;
            }

            public Builder clearErrMsg() {
                this.errMsg_ = SoundDeviceResp.getDefaultInstance().getErrMsg();
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a, com.google.protobuf.g0
            public Descriptors.b getDescriptorForType() {
                return DeviceProto.internal_static_com_mobvoi_companion_proto_SoundDeviceResp_descriptor;
            }

            @Override // com.mobvoi.companion.proto.DeviceProto.SoundDeviceRespOrBuilder
            public SoundDevice getDevices(int i10) {
                o0<SoundDevice, SoundDevice.Builder, SoundDeviceOrBuilder> o0Var = this.devicesBuilder_;
                if (o0Var == null) {
                    return this.devices_.get(i10);
                }
                return o0Var.o(i10);
            }

            public SoundDevice.Builder getDevicesBuilder(int i10) {
                return getDevicesFieldBuilder().l(i10);
            }

            public List<SoundDevice.Builder> getDevicesBuilderList() {
                return getDevicesFieldBuilder().m();
            }

            @Override // com.mobvoi.companion.proto.DeviceProto.SoundDeviceRespOrBuilder
            public int getDevicesCount() {
                o0<SoundDevice, SoundDevice.Builder, SoundDeviceOrBuilder> o0Var = this.devicesBuilder_;
                if (o0Var == null) {
                    return this.devices_.size();
                }
                return o0Var.n();
            }

            @Override // com.mobvoi.companion.proto.DeviceProto.SoundDeviceRespOrBuilder
            public List<SoundDevice> getDevicesList() {
                o0<SoundDevice, SoundDevice.Builder, SoundDeviceOrBuilder> o0Var = this.devicesBuilder_;
                if (o0Var == null) {
                    return Collections.unmodifiableList(this.devices_);
                }
                return o0Var.q();
            }

            @Override // com.mobvoi.companion.proto.DeviceProto.SoundDeviceRespOrBuilder
            public SoundDeviceOrBuilder getDevicesOrBuilder(int i10) {
                o0<SoundDevice, SoundDevice.Builder, SoundDeviceOrBuilder> o0Var = this.devicesBuilder_;
                if (o0Var == null) {
                    return this.devices_.get(i10);
                }
                return o0Var.r(i10);
            }

            @Override // com.mobvoi.companion.proto.DeviceProto.SoundDeviceRespOrBuilder
            public List<? extends SoundDeviceOrBuilder> getDevicesOrBuilderList() {
                o0<SoundDevice, SoundDevice.Builder, SoundDeviceOrBuilder> o0Var = this.devicesBuilder_;
                if (o0Var != null) {
                    return o0Var.s();
                }
                return Collections.unmodifiableList(this.devices_);
            }

            @Override // com.mobvoi.companion.proto.DeviceProto.SoundDeviceRespOrBuilder
            public int getErrCode() {
                return this.errCode_;
            }

            @Override // com.mobvoi.companion.proto.DeviceProto.SoundDeviceRespOrBuilder
            public String getErrMsg() {
                Object obj = this.errMsg_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.errMsg_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.proto.DeviceProto.SoundDeviceRespOrBuilder
            public ByteString getErrMsgBytes() {
                Object obj = this.errMsg_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.errMsg_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return DeviceProto.internal_static_com_mobvoi_companion_proto_SoundDeviceResp_fieldAccessorTable.e(SoundDeviceResp.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.f0
            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a
            public final Builder mergeUnknownFields(a1 a1Var) {
                return this;
            }

            public Builder removeDevices(int i10) {
                o0<SoundDevice, SoundDevice.Builder, SoundDeviceOrBuilder> o0Var = this.devicesBuilder_;
                if (o0Var == null) {
                    ensureDevicesIsMutable();
                    this.devices_.remove(i10);
                    onChanged();
                } else {
                    o0Var.w(i10);
                }
                return this;
            }

            public Builder setDevices(int i10, SoundDevice soundDevice) {
                o0<SoundDevice, SoundDevice.Builder, SoundDeviceOrBuilder> o0Var = this.devicesBuilder_;
                if (o0Var == null) {
                    Objects.requireNonNull(soundDevice);
                    ensureDevicesIsMutable();
                    this.devices_.set(i10, soundDevice);
                    onChanged();
                } else {
                    o0Var.x(i10, soundDevice);
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

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public final Builder setUnknownFields(a1 a1Var) {
                return this;
            }

            private Builder() {
                this.errMsg_ = "";
                this.devices_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.e0.a, com.google.protobuf.d0.a
            public SoundDeviceResp build() {
                SoundDeviceResp buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) buildPartial);
            }

            @Override // com.google.protobuf.e0.a, com.google.protobuf.d0.a
            public SoundDeviceResp buildPartial() {
                SoundDeviceResp soundDeviceResp = new SoundDeviceResp(this);
                soundDeviceResp.errCode_ = this.errCode_;
                soundDeviceResp.errMsg_ = this.errMsg_;
                o0<SoundDevice, SoundDevice.Builder, SoundDeviceOrBuilder> o0Var = this.devicesBuilder_;
                if (o0Var == null) {
                    if ((this.bitField0_ & 4) == 4) {
                        this.devices_ = Collections.unmodifiableList(this.devices_);
                        this.bitField0_ &= -5;
                    }
                    soundDeviceResp.devices_ = this.devices_;
                } else {
                    soundDeviceResp.devices_ = o0Var.g();
                }
                soundDeviceResp.bitField0_ = 0;
                onBuilt();
                return soundDeviceResp;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.f0, com.google.protobuf.g0
            public SoundDeviceResp getDefaultInstanceForType() {
                return SoundDeviceResp.getDefaultInstance();
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

            public SoundDevice.Builder addDevicesBuilder(int i10) {
                return getDevicesFieldBuilder().c(i10, SoundDevice.getDefaultInstance());
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
                o0<SoundDevice, SoundDevice.Builder, SoundDeviceOrBuilder> o0Var = this.devicesBuilder_;
                if (o0Var == null) {
                    this.devices_ = Collections.emptyList();
                    this.bitField0_ &= -5;
                } else {
                    o0Var.h();
                }
                return this;
            }

            private Builder(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.errMsg_ = "";
                this.devices_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            public Builder addDevices(int i10, SoundDevice soundDevice) {
                o0<SoundDevice, SoundDevice.Builder, SoundDeviceOrBuilder> o0Var = this.devicesBuilder_;
                if (o0Var == null) {
                    Objects.requireNonNull(soundDevice);
                    ensureDevicesIsMutable();
                    this.devices_.add(i10, soundDevice);
                    onChanged();
                } else {
                    o0Var.e(i10, soundDevice);
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a, com.google.protobuf.b.a
            public Builder clone() {
                return (Builder) super.clone();
            }

            @Override // com.google.protobuf.a.AbstractC0170a, com.google.protobuf.d0.a
            public Builder mergeFrom(d0 d0Var) {
                if (d0Var instanceof SoundDeviceResp) {
                    return mergeFrom((SoundDeviceResp) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            public Builder setDevices(int i10, SoundDevice.Builder builder) {
                o0<SoundDevice, SoundDevice.Builder, SoundDeviceOrBuilder> o0Var = this.devicesBuilder_;
                if (o0Var == null) {
                    ensureDevicesIsMutable();
                    this.devices_.set(i10, builder.build());
                    onChanged();
                } else {
                    o0Var.x(i10, builder.build());
                }
                return this;
            }

            public Builder mergeFrom(SoundDeviceResp soundDeviceResp) {
                if (soundDeviceResp == SoundDeviceResp.getDefaultInstance()) {
                    return this;
                }
                if (soundDeviceResp.getErrCode() != 0) {
                    setErrCode(soundDeviceResp.getErrCode());
                }
                if (!soundDeviceResp.getErrMsg().isEmpty()) {
                    this.errMsg_ = soundDeviceResp.errMsg_;
                    onChanged();
                }
                if (this.devicesBuilder_ == null) {
                    if (!soundDeviceResp.devices_.isEmpty()) {
                        if (this.devices_.isEmpty()) {
                            this.devices_ = soundDeviceResp.devices_;
                            this.bitField0_ &= -5;
                        } else {
                            ensureDevicesIsMutable();
                            this.devices_.addAll(soundDeviceResp.devices_);
                        }
                        onChanged();
                    }
                } else if (!soundDeviceResp.devices_.isEmpty()) {
                    if (this.devicesBuilder_.u()) {
                        this.devicesBuilder_.i();
                        o0<SoundDevice, SoundDevice.Builder, SoundDeviceOrBuilder> o0Var = null;
                        this.devicesBuilder_ = null;
                        this.devices_ = soundDeviceResp.devices_;
                        this.bitField0_ &= -5;
                        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                            o0Var = getDevicesFieldBuilder();
                        }
                        this.devicesBuilder_ = o0Var;
                    } else {
                        this.devicesBuilder_.b(soundDeviceResp.devices_);
                    }
                }
                onChanged();
                return this;
            }

            public Builder addDevices(SoundDevice.Builder builder) {
                o0<SoundDevice, SoundDevice.Builder, SoundDeviceOrBuilder> o0Var = this.devicesBuilder_;
                if (o0Var == null) {
                    ensureDevicesIsMutable();
                    this.devices_.add(builder.build());
                    onChanged();
                } else {
                    o0Var.f(builder.build());
                }
                return this;
            }

            public Builder addDevices(int i10, SoundDevice.Builder builder) {
                o0<SoundDevice, SoundDevice.Builder, SoundDeviceOrBuilder> o0Var = this.devicesBuilder_;
                if (o0Var == null) {
                    ensureDevicesIsMutable();
                    this.devices_.add(i10, builder.build());
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
                SoundDeviceResp soundDeviceResp = null;
                try {
                    try {
                        SoundDeviceResp soundDeviceResp2 = (SoundDeviceResp) SoundDeviceResp.PARSER.parsePartialFrom(iVar, qVar);
                        if (soundDeviceResp2 != null) {
                            mergeFrom(soundDeviceResp2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e10) {
                        soundDeviceResp = (SoundDeviceResp) e10.getUnfinishedMessage();
                        try {
                            throw e10.unwrapIOException();
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (soundDeviceResp != null) {
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (soundDeviceResp != null) {
                        mergeFrom(soundDeviceResp);
                    }
                    throw th2;
                }
            }
        }

        public static Builder newBuilder(SoundDeviceResp soundDeviceResp) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(soundDeviceResp);
        }

        public static SoundDeviceResp parseFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, qVar);
        }

        private SoundDeviceResp(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static SoundDeviceResp parseDelimitedFrom(InputStream inputStream, q qVar) throws IOException {
            return (SoundDeviceResp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
        }

        public static SoundDeviceResp parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
        public SoundDeviceResp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static SoundDeviceResp parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder newBuilderForType() {
            return newBuilder();
        }

        private SoundDeviceResp() {
            this.memoizedIsInitialized = (byte) -1;
            this.errCode_ = 0;
            this.errMsg_ = "";
            this.devices_ = Collections.emptyList();
        }

        public static SoundDeviceResp parseFrom(InputStream inputStream) throws IOException {
            return (SoundDeviceResp) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.c cVar) {
            return new Builder(cVar);
        }

        public static SoundDeviceResp parseFrom(InputStream inputStream, q qVar) throws IOException {
            return (SoundDeviceResp) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
        }

        public static SoundDeviceResp parseFrom(i iVar) throws IOException {
            return (SoundDeviceResp) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
        }

        private SoundDeviceResp(i iVar, q qVar) throws InvalidProtocolBufferException {
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
                                    this.devices_ = new ArrayList();
                                    z11 |= true;
                                }
                                this.devices_.add((SoundDevice) iVar.v(SoundDevice.parser(), qVar));
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
                        this.devices_ = Collections.unmodifiableList(this.devices_);
                    }
                    makeExtensionsImmutable();
                }
            }
        }

        public static SoundDeviceResp parseFrom(i iVar, q qVar) throws IOException {
            return (SoundDeviceResp) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
        }
    }

    /* loaded from: classes2.dex */
    public interface SoundDeviceRespOrBuilder extends g0 {
        /* synthetic */ List<String> findInitializationErrors();

        @Override // com.google.protobuf.g0
        /* synthetic */ Map<Descriptors.FieldDescriptor, Object> getAllFields();

        @Override // com.google.protobuf.g0
        /* synthetic */ d0 getDefaultInstanceForType();

        @Override // com.google.protobuf.g0
        /* synthetic */ e0 getDefaultInstanceForType();

        @Override // com.google.protobuf.g0
        /* synthetic */ Descriptors.b getDescriptorForType();

        SoundDevice getDevices(int i10);

        int getDevicesCount();

        List<SoundDevice> getDevicesList();

        SoundDeviceOrBuilder getDevicesOrBuilder(int i10);

        List<? extends SoundDeviceOrBuilder> getDevicesOrBuilderList();

        int getErrCode();

        String getErrMsg();

        ByteString getErrMsgBytes();

        @Override // com.google.protobuf.g0
        /* synthetic */ Object getField(Descriptors.FieldDescriptor fieldDescriptor);

        /* synthetic */ String getInitializationErrorString();

        /* synthetic */ Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.h hVar);

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

    static {
        Descriptors.FileDescriptor.q(new String[]{"\n\u0012sound_device.proto\u0012\u001acom.mobvoi.companion.proto\u001a\u000fconstants.proto\"n\n\u000fSoundDeviceResp\u0012\u0010\n\berr_code\u0018\u0001 \u0001(\u0005\u0012\u000f\n\u0007err_msg\u0018\u0002 \u0001(\t\u00128\n\u0007devices\u0018\u0003 \u0003(\u000b2'.com.mobvoi.companion.proto.SoundDevice\"r\n\u000bSoundDevice\u0012\u0011\n\tdevice_id\u0018\u0001 \u0001(\t\u0012\u0013\n\u000bdevice_name\u0018\u0002 \u0001(\t\u0012;\n\u000bdevice_type\u0018\u0003 \u0001(\u000e2&.com.mobvoi.companion.proto.DeviceType\"{\n\u0013SoundBindDeviceResp\u0012\u0010\n\berr_code\u0018\u0001 \u0001(\u0005\u0012\u000f\n\u0007err_msg\u0018\u0002 \u0001(\t\u0012A\n\fbind_devices\u0018\u0003 \u0003(\u000b2+.com.mobvoi.companion.pro", "to.SoundBindDevice\"9\n\u000fSoundBindDevice\u0012\u0011\n\tdevice_id\u0018\u0001 \u0001(\t\u0012\u0013\n\u000bdevice_type\u0018\u0002 \u0001(\tB\rB\u000bDeviceProtob\u0006proto3"}, new Descriptors.FileDescriptor[]{ConstantProto.getDescriptor()}, new Descriptors.FileDescriptor.a() { // from class: com.mobvoi.companion.proto.DeviceProto.1
            @Override // com.google.protobuf.Descriptors.FileDescriptor.a
            public o assignDescriptors(Descriptors.FileDescriptor fileDescriptor) {
                Descriptors.FileDescriptor unused = DeviceProto.descriptor = fileDescriptor;
                return null;
            }
        });
        Descriptors.b bVar = getDescriptor().j().get(0);
        internal_static_com_mobvoi_companion_proto_SoundDeviceResp_descriptor = bVar;
        internal_static_com_mobvoi_companion_proto_SoundDeviceResp_fieldAccessorTable = new GeneratedMessageV3.e(bVar, new String[]{"ErrCode", "ErrMsg", "Devices"});
        Descriptors.b bVar2 = getDescriptor().j().get(1);
        internal_static_com_mobvoi_companion_proto_SoundDevice_descriptor = bVar2;
        internal_static_com_mobvoi_companion_proto_SoundDevice_fieldAccessorTable = new GeneratedMessageV3.e(bVar2, new String[]{"DeviceId", "DeviceName", "DeviceType"});
        Descriptors.b bVar3 = getDescriptor().j().get(2);
        internal_static_com_mobvoi_companion_proto_SoundBindDeviceResp_descriptor = bVar3;
        internal_static_com_mobvoi_companion_proto_SoundBindDeviceResp_fieldAccessorTable = new GeneratedMessageV3.e(bVar3, new String[]{"ErrCode", "ErrMsg", "BindDevices"});
        Descriptors.b bVar4 = getDescriptor().j().get(3);
        internal_static_com_mobvoi_companion_proto_SoundBindDevice_descriptor = bVar4;
        internal_static_com_mobvoi_companion_proto_SoundBindDevice_fieldAccessorTable = new GeneratedMessageV3.e(bVar4, new String[]{"DeviceId", "DeviceType"});
        ConstantProto.getDescriptor();
    }

    private DeviceProto() {
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
