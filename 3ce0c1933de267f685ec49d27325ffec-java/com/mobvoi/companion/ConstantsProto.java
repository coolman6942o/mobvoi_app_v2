package com.mobvoi.companion;

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
import com.google.protobuf.o0;
import com.google.protobuf.q;
import com.google.protobuf.q0;
import com.google.protobuf.u;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
/* loaded from: classes2.dex */
public final class ConstantsProto {
    private static Descriptors.FileDescriptor descriptor;
    private static final Descriptors.b internal_static_common_BindInfoResponse_descriptor;
    private static final GeneratedMessageV3.e internal_static_common_BindInfoResponse_fieldAccessorTable;
    private static final Descriptors.b internal_static_common_BindInfo_descriptor;
    private static final GeneratedMessageV3.e internal_static_common_BindInfo_fieldAccessorTable;
    private static final Descriptors.b internal_static_common_HotelAdminResp_descriptor;
    private static final GeneratedMessageV3.e internal_static_common_HotelAdminResp_fieldAccessorTable;
    private static final Descriptors.b internal_static_common_HotelBindData_descriptor;
    private static final GeneratedMessageV3.e internal_static_common_HotelBindData_fieldAccessorTable;
    private static final Descriptors.b internal_static_common_HotelBindResp_descriptor;
    private static final GeneratedMessageV3.e internal_static_common_HotelBindResp_fieldAccessorTable;
    private static final Descriptors.b internal_static_common_TicAssistantRequest_descriptor;
    private static final GeneratedMessageV3.e internal_static_common_TicAssistantRequest_fieldAccessorTable;
    private static final Descriptors.b internal_static_common_TicAssistantResponse_descriptor;
    private static final GeneratedMessageV3.e internal_static_common_TicAssistantResponse_fieldAccessorTable;
    private static final Descriptors.b internal_static_common_UnbindInfo_descriptor;
    private static final GeneratedMessageV3.e internal_static_common_UnbindInfo_fieldAccessorTable;
    private static final Descriptors.b internal_static_common_UpdateInfo_descriptor;
    private static final GeneratedMessageV3.e internal_static_common_UpdateInfo_fieldAccessorTable;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mobvoi.companion.ConstantsProto$2  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$mobvoi$companion$ConstantsProto$TicAssistantRequest$TypeCase;

        static {
            int[] iArr = new int[TicAssistantRequest.TypeCase.values().length];
            $SwitchMap$com$mobvoi$companion$ConstantsProto$TicAssistantRequest$TypeCase = iArr;
            try {
                iArr[TicAssistantRequest.TypeCase.BIND_INFO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$mobvoi$companion$ConstantsProto$TicAssistantRequest$TypeCase[TicAssistantRequest.TypeCase.UNBIND_INFO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$mobvoi$companion$ConstantsProto$TicAssistantRequest$TypeCase[TicAssistantRequest.TypeCase.UPDATE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$mobvoi$companion$ConstantsProto$TicAssistantRequest$TypeCase[TicAssistantRequest.TypeCase.TYPE_NOT_SET.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class BindInfo extends GeneratedMessageV3 implements BindInfoOrBuilder {
        public static final int BLUETOOTH_ADDRESS_FIELD_NUMBER = 6;
        public static final int CONNECTED_QQ_FIELD_NUMBER = 12;
        public static final int CREATED_AT_FIELD_NUMBER = 10;
        public static final int DEVICE_ID_FIELD_NUMBER = 2;
        public static final int DEVICE_NAME_FIELD_NUMBER = 4;
        public static final int DEVICE_SN_FIELD_NUMBER = 8;
        public static final int DEVICE_TYPE_FIELD_NUMBER = 3;
        public static final int MODEL_FIELD_NUMBER = 5;
        public static final int ONLINE_STATUS_FIELD_NUMBER = 9;
        public static final int SALES_CHANNEL_FIELD_NUMBER = 13;
        public static final int UPDATED_AT_FIELD_NUMBER = 11;
        public static final int WIFI_ADDRESS_FIELD_NUMBER = 7;
        public static final int WWID_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private volatile Object bluetoothAddress_;
        private boolean connectedQq_;
        private long createdAt_;
        private volatile Object deviceId_;
        private volatile Object deviceName_;
        private volatile Object deviceSn_;
        private int deviceType_;
        private byte memoizedIsInitialized;
        private volatile Object model_;
        private int onlineStatus_;
        private volatile Object salesChannel_;
        private long updatedAt_;
        private volatile Object wifiAddress_;
        private volatile Object wwid_;
        private static final BindInfo DEFAULT_INSTANCE = new BindInfo();
        private static final l0<BindInfo> PARSER = new c<BindInfo>() { // from class: com.mobvoi.companion.ConstantsProto.BindInfo.1
            @Override // com.google.protobuf.l0
            public BindInfo parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
                return new BindInfo(iVar, qVar);
            }
        };

        public static BindInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return ConstantsProto.internal_static_common_BindInfo_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static BindInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (BindInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static BindInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static l0<BindInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof BindInfo)) {
                return super.equals(obj);
            }
            BindInfo bindInfo = (BindInfo) obj;
            return ((((((((((((getWwid().equals(bindInfo.getWwid())) && getDeviceId().equals(bindInfo.getDeviceId())) && this.deviceType_ == bindInfo.deviceType_) && getDeviceName().equals(bindInfo.getDeviceName())) && getModel().equals(bindInfo.getModel())) && getBluetoothAddress().equals(bindInfo.getBluetoothAddress())) && getWifiAddress().equals(bindInfo.getWifiAddress())) && getDeviceSn().equals(bindInfo.getDeviceSn())) && this.onlineStatus_ == bindInfo.onlineStatus_) && (getCreatedAt() > bindInfo.getCreatedAt() ? 1 : (getCreatedAt() == bindInfo.getCreatedAt() ? 0 : -1)) == 0) && (getUpdatedAt() > bindInfo.getUpdatedAt() ? 1 : (getUpdatedAt() == bindInfo.getUpdatedAt() ? 0 : -1)) == 0) && getConnectedQq() == bindInfo.getConnectedQq()) && getSalesChannel().equals(bindInfo.getSalesChannel());
        }

        @Override // com.mobvoi.companion.ConstantsProto.BindInfoOrBuilder
        public String getBluetoothAddress() {
            Object obj = this.bluetoothAddress_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.bluetoothAddress_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.ConstantsProto.BindInfoOrBuilder
        public ByteString getBluetoothAddressBytes() {
            Object obj = this.bluetoothAddress_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.bluetoothAddress_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.mobvoi.companion.ConstantsProto.BindInfoOrBuilder
        public boolean getConnectedQq() {
            return this.connectedQq_;
        }

        @Override // com.mobvoi.companion.ConstantsProto.BindInfoOrBuilder
        public long getCreatedAt() {
            return this.createdAt_;
        }

        @Override // com.mobvoi.companion.ConstantsProto.BindInfoOrBuilder
        public String getDeviceId() {
            Object obj = this.deviceId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.deviceId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.ConstantsProto.BindInfoOrBuilder
        public ByteString getDeviceIdBytes() {
            Object obj = this.deviceId_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.deviceId_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.mobvoi.companion.ConstantsProto.BindInfoOrBuilder
        public String getDeviceName() {
            Object obj = this.deviceName_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.deviceName_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.ConstantsProto.BindInfoOrBuilder
        public ByteString getDeviceNameBytes() {
            Object obj = this.deviceName_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.deviceName_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.mobvoi.companion.ConstantsProto.BindInfoOrBuilder
        public String getDeviceSn() {
            Object obj = this.deviceSn_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.deviceSn_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.ConstantsProto.BindInfoOrBuilder
        public ByteString getDeviceSnBytes() {
            Object obj = this.deviceSn_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.deviceSn_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.mobvoi.companion.ConstantsProto.BindInfoOrBuilder
        public DeviceType getDeviceType() {
            DeviceType valueOf = DeviceType.valueOf(this.deviceType_);
            return valueOf == null ? DeviceType.UNRECOGNIZED : valueOf;
        }

        @Override // com.mobvoi.companion.ConstantsProto.BindInfoOrBuilder
        public int getDeviceTypeValue() {
            return this.deviceType_;
        }

        @Override // com.mobvoi.companion.ConstantsProto.BindInfoOrBuilder
        public String getModel() {
            Object obj = this.model_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.model_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.ConstantsProto.BindInfoOrBuilder
        public ByteString getModelBytes() {
            Object obj = this.model_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.model_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.mobvoi.companion.ConstantsProto.BindInfoOrBuilder
        public DeviceOnlineStatus getOnlineStatus() {
            DeviceOnlineStatus valueOf = DeviceOnlineStatus.valueOf(this.onlineStatus_);
            return valueOf == null ? DeviceOnlineStatus.UNRECOGNIZED : valueOf;
        }

        @Override // com.mobvoi.companion.ConstantsProto.BindInfoOrBuilder
        public int getOnlineStatusValue() {
            return this.onlineStatus_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public l0<BindInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.mobvoi.companion.ConstantsProto.BindInfoOrBuilder
        public String getSalesChannel() {
            Object obj = this.salesChannel_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.salesChannel_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.ConstantsProto.BindInfoOrBuilder
        public ByteString getSalesChannelBytes() {
            Object obj = this.salesChannel_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.salesChannel_ = copyFromUtf8;
            return copyFromUtf8;
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
            if (!getDeviceIdBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(2, this.deviceId_);
            }
            if (this.deviceType_ != DeviceType.UNKNOWN_DEVICE_TYPE.getNumber()) {
                i11 += CodedOutputStream.l(3, this.deviceType_);
            }
            if (!getDeviceNameBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(4, this.deviceName_);
            }
            if (!getModelBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(5, this.model_);
            }
            if (!getBluetoothAddressBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(6, this.bluetoothAddress_);
            }
            if (!getWifiAddressBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(7, this.wifiAddress_);
            }
            if (!getDeviceSnBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(8, this.deviceSn_);
            }
            if (this.onlineStatus_ != DeviceOnlineStatus.UNKNOWN_STATUS.getNumber()) {
                i11 += CodedOutputStream.l(9, this.onlineStatus_);
            }
            long j10 = this.createdAt_;
            if (j10 != 0) {
                i11 += CodedOutputStream.x(10, j10);
            }
            long j11 = this.updatedAt_;
            if (j11 != 0) {
                i11 += CodedOutputStream.x(11, j11);
            }
            boolean z10 = this.connectedQq_;
            if (z10) {
                i11 += CodedOutputStream.e(12, z10);
            }
            if (!getSalesChannelBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(13, this.salesChannel_);
            }
            this.memoizedSize = i11;
            return i11;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.g0
        public final a1 getUnknownFields() {
            return a1.c();
        }

        @Override // com.mobvoi.companion.ConstantsProto.BindInfoOrBuilder
        public long getUpdatedAt() {
            return this.updatedAt_;
        }

        @Override // com.mobvoi.companion.ConstantsProto.BindInfoOrBuilder
        public String getWifiAddress() {
            Object obj = this.wifiAddress_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.wifiAddress_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.ConstantsProto.BindInfoOrBuilder
        public ByteString getWifiAddressBytes() {
            Object obj = this.wifiAddress_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.wifiAddress_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.mobvoi.companion.ConstantsProto.BindInfoOrBuilder
        public String getWwid() {
            Object obj = this.wwid_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.wwid_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.ConstantsProto.BindInfoOrBuilder
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
            int hashCode = ((((((((((((((((((((((((((((((((((((((((((((((((((((((779 + getDescriptorForType().hashCode()) * 37) + 1) * 53) + getWwid().hashCode()) * 37) + 2) * 53) + getDeviceId().hashCode()) * 37) + 3) * 53) + this.deviceType_) * 37) + 4) * 53) + getDeviceName().hashCode()) * 37) + 5) * 53) + getModel().hashCode()) * 37) + 6) * 53) + getBluetoothAddress().hashCode()) * 37) + 7) * 53) + getWifiAddress().hashCode()) * 37) + 8) * 53) + getDeviceSn().hashCode()) * 37) + 9) * 53) + this.onlineStatus_) * 37) + 10) * 53) + u.h(getCreatedAt())) * 37) + 11) * 53) + u.h(getUpdatedAt())) * 37) + 12) * 53) + u.c(getConnectedQq())) * 37) + 13) * 53) + getSalesChannel().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return ConstantsProto.internal_static_common_BindInfo_fieldAccessorTable.e(BindInfo.class, Builder.class);
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
            if (!getDeviceIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.deviceId_);
            }
            if (this.deviceType_ != DeviceType.UNKNOWN_DEVICE_TYPE.getNumber()) {
                codedOutputStream.m0(3, this.deviceType_);
            }
            if (!getDeviceNameBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 4, this.deviceName_);
            }
            if (!getModelBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 5, this.model_);
            }
            if (!getBluetoothAddressBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 6, this.bluetoothAddress_);
            }
            if (!getWifiAddressBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 7, this.wifiAddress_);
            }
            if (!getDeviceSnBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 8, this.deviceSn_);
            }
            if (this.onlineStatus_ != DeviceOnlineStatus.UNKNOWN_STATUS.getNumber()) {
                codedOutputStream.m0(9, this.onlineStatus_);
            }
            long j10 = this.createdAt_;
            if (j10 != 0) {
                codedOutputStream.y0(10, j10);
            }
            long j11 = this.updatedAt_;
            if (j11 != 0) {
                codedOutputStream.y0(11, j11);
            }
            boolean z10 = this.connectedQq_;
            if (z10) {
                codedOutputStream.e0(12, z10);
            }
            if (!getSalesChannelBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 13, this.salesChannel_);
            }
        }

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageV3.b<Builder> implements BindInfoOrBuilder {
            private Object bluetoothAddress_;
            private boolean connectedQq_;
            private long createdAt_;
            private Object deviceId_;
            private Object deviceName_;
            private Object deviceSn_;
            private int deviceType_;
            private Object model_;
            private int onlineStatus_;
            private Object salesChannel_;
            private long updatedAt_;
            private Object wifiAddress_;
            private Object wwid_;

            public static final Descriptors.b getDescriptor() {
                return ConstantsProto.internal_static_common_BindInfo_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            public Builder clearBluetoothAddress() {
                this.bluetoothAddress_ = BindInfo.getDefaultInstance().getBluetoothAddress();
                onChanged();
                return this;
            }

            public Builder clearConnectedQq() {
                this.connectedQq_ = false;
                onChanged();
                return this;
            }

            public Builder clearCreatedAt() {
                this.createdAt_ = 0L;
                onChanged();
                return this;
            }

            public Builder clearDeviceId() {
                this.deviceId_ = BindInfo.getDefaultInstance().getDeviceId();
                onChanged();
                return this;
            }

            public Builder clearDeviceName() {
                this.deviceName_ = BindInfo.getDefaultInstance().getDeviceName();
                onChanged();
                return this;
            }

            public Builder clearDeviceSn() {
                this.deviceSn_ = BindInfo.getDefaultInstance().getDeviceSn();
                onChanged();
                return this;
            }

            public Builder clearDeviceType() {
                this.deviceType_ = 0;
                onChanged();
                return this;
            }

            public Builder clearModel() {
                this.model_ = BindInfo.getDefaultInstance().getModel();
                onChanged();
                return this;
            }

            public Builder clearOnlineStatus() {
                this.onlineStatus_ = 0;
                onChanged();
                return this;
            }

            public Builder clearSalesChannel() {
                this.salesChannel_ = BindInfo.getDefaultInstance().getSalesChannel();
                onChanged();
                return this;
            }

            public Builder clearUpdatedAt() {
                this.updatedAt_ = 0L;
                onChanged();
                return this;
            }

            public Builder clearWifiAddress() {
                this.wifiAddress_ = BindInfo.getDefaultInstance().getWifiAddress();
                onChanged();
                return this;
            }

            public Builder clearWwid() {
                this.wwid_ = BindInfo.getDefaultInstance().getWwid();
                onChanged();
                return this;
            }

            @Override // com.mobvoi.companion.ConstantsProto.BindInfoOrBuilder
            public String getBluetoothAddress() {
                Object obj = this.bluetoothAddress_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.bluetoothAddress_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.ConstantsProto.BindInfoOrBuilder
            public ByteString getBluetoothAddressBytes() {
                Object obj = this.bluetoothAddress_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.bluetoothAddress_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.mobvoi.companion.ConstantsProto.BindInfoOrBuilder
            public boolean getConnectedQq() {
                return this.connectedQq_;
            }

            @Override // com.mobvoi.companion.ConstantsProto.BindInfoOrBuilder
            public long getCreatedAt() {
                return this.createdAt_;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a, com.google.protobuf.g0
            public Descriptors.b getDescriptorForType() {
                return ConstantsProto.internal_static_common_BindInfo_descriptor;
            }

            @Override // com.mobvoi.companion.ConstantsProto.BindInfoOrBuilder
            public String getDeviceId() {
                Object obj = this.deviceId_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.deviceId_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.ConstantsProto.BindInfoOrBuilder
            public ByteString getDeviceIdBytes() {
                Object obj = this.deviceId_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.deviceId_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.mobvoi.companion.ConstantsProto.BindInfoOrBuilder
            public String getDeviceName() {
                Object obj = this.deviceName_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.deviceName_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.ConstantsProto.BindInfoOrBuilder
            public ByteString getDeviceNameBytes() {
                Object obj = this.deviceName_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.deviceName_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.mobvoi.companion.ConstantsProto.BindInfoOrBuilder
            public String getDeviceSn() {
                Object obj = this.deviceSn_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.deviceSn_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.ConstantsProto.BindInfoOrBuilder
            public ByteString getDeviceSnBytes() {
                Object obj = this.deviceSn_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.deviceSn_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.mobvoi.companion.ConstantsProto.BindInfoOrBuilder
            public DeviceType getDeviceType() {
                DeviceType valueOf = DeviceType.valueOf(this.deviceType_);
                return valueOf == null ? DeviceType.UNRECOGNIZED : valueOf;
            }

            @Override // com.mobvoi.companion.ConstantsProto.BindInfoOrBuilder
            public int getDeviceTypeValue() {
                return this.deviceType_;
            }

            @Override // com.mobvoi.companion.ConstantsProto.BindInfoOrBuilder
            public String getModel() {
                Object obj = this.model_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.model_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.ConstantsProto.BindInfoOrBuilder
            public ByteString getModelBytes() {
                Object obj = this.model_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.model_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.mobvoi.companion.ConstantsProto.BindInfoOrBuilder
            public DeviceOnlineStatus getOnlineStatus() {
                DeviceOnlineStatus valueOf = DeviceOnlineStatus.valueOf(this.onlineStatus_);
                return valueOf == null ? DeviceOnlineStatus.UNRECOGNIZED : valueOf;
            }

            @Override // com.mobvoi.companion.ConstantsProto.BindInfoOrBuilder
            public int getOnlineStatusValue() {
                return this.onlineStatus_;
            }

            @Override // com.mobvoi.companion.ConstantsProto.BindInfoOrBuilder
            public String getSalesChannel() {
                Object obj = this.salesChannel_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.salesChannel_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.ConstantsProto.BindInfoOrBuilder
            public ByteString getSalesChannelBytes() {
                Object obj = this.salesChannel_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.salesChannel_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.mobvoi.companion.ConstantsProto.BindInfoOrBuilder
            public long getUpdatedAt() {
                return this.updatedAt_;
            }

            @Override // com.mobvoi.companion.ConstantsProto.BindInfoOrBuilder
            public String getWifiAddress() {
                Object obj = this.wifiAddress_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.wifiAddress_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.ConstantsProto.BindInfoOrBuilder
            public ByteString getWifiAddressBytes() {
                Object obj = this.wifiAddress_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.wifiAddress_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.mobvoi.companion.ConstantsProto.BindInfoOrBuilder
            public String getWwid() {
                Object obj = this.wwid_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.wwid_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.ConstantsProto.BindInfoOrBuilder
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
                return ConstantsProto.internal_static_common_BindInfo_fieldAccessorTable.e(BindInfo.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.f0
            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a
            public final Builder mergeUnknownFields(a1 a1Var) {
                return this;
            }

            public Builder setBluetoothAddress(String str) {
                Objects.requireNonNull(str);
                this.bluetoothAddress_ = str;
                onChanged();
                return this;
            }

            public Builder setBluetoothAddressBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                b.checkByteStringIsUtf8(byteString);
                this.bluetoothAddress_ = byteString;
                onChanged();
                return this;
            }

            public Builder setConnectedQq(boolean z10) {
                this.connectedQq_ = z10;
                onChanged();
                return this;
            }

            public Builder setCreatedAt(long j10) {
                this.createdAt_ = j10;
                onChanged();
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

            public Builder setDeviceSn(String str) {
                Objects.requireNonNull(str);
                this.deviceSn_ = str;
                onChanged();
                return this;
            }

            public Builder setDeviceSnBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                b.checkByteStringIsUtf8(byteString);
                this.deviceSn_ = byteString;
                onChanged();
                return this;
            }

            public Builder setDeviceType(DeviceType deviceType) {
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

            public Builder setModel(String str) {
                Objects.requireNonNull(str);
                this.model_ = str;
                onChanged();
                return this;
            }

            public Builder setModelBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                b.checkByteStringIsUtf8(byteString);
                this.model_ = byteString;
                onChanged();
                return this;
            }

            public Builder setOnlineStatus(DeviceOnlineStatus deviceOnlineStatus) {
                Objects.requireNonNull(deviceOnlineStatus);
                this.onlineStatus_ = deviceOnlineStatus.getNumber();
                onChanged();
                return this;
            }

            public Builder setOnlineStatusValue(int i10) {
                this.onlineStatus_ = i10;
                onChanged();
                return this;
            }

            public Builder setSalesChannel(String str) {
                Objects.requireNonNull(str);
                this.salesChannel_ = str;
                onChanged();
                return this;
            }

            public Builder setSalesChannelBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                b.checkByteStringIsUtf8(byteString);
                this.salesChannel_ = byteString;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public final Builder setUnknownFields(a1 a1Var) {
                return this;
            }

            public Builder setUpdatedAt(long j10) {
                this.updatedAt_ = j10;
                onChanged();
                return this;
            }

            public Builder setWifiAddress(String str) {
                Objects.requireNonNull(str);
                this.wifiAddress_ = str;
                onChanged();
                return this;
            }

            public Builder setWifiAddressBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                b.checkByteStringIsUtf8(byteString);
                this.wifiAddress_ = byteString;
                onChanged();
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
                this.deviceId_ = "";
                this.deviceType_ = 0;
                this.deviceName_ = "";
                this.model_ = "";
                this.bluetoothAddress_ = "";
                this.wifiAddress_ = "";
                this.deviceSn_ = "";
                this.onlineStatus_ = 0;
                this.salesChannel_ = "";
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.e0.a, com.google.protobuf.d0.a
            public BindInfo build() {
                BindInfo buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) buildPartial);
            }

            @Override // com.google.protobuf.e0.a, com.google.protobuf.d0.a
            public BindInfo buildPartial() {
                BindInfo bindInfo = new BindInfo(this);
                bindInfo.wwid_ = this.wwid_;
                bindInfo.deviceId_ = this.deviceId_;
                bindInfo.deviceType_ = this.deviceType_;
                bindInfo.deviceName_ = this.deviceName_;
                bindInfo.model_ = this.model_;
                bindInfo.bluetoothAddress_ = this.bluetoothAddress_;
                bindInfo.wifiAddress_ = this.wifiAddress_;
                bindInfo.deviceSn_ = this.deviceSn_;
                bindInfo.onlineStatus_ = this.onlineStatus_;
                bindInfo.createdAt_ = this.createdAt_;
                bindInfo.updatedAt_ = this.updatedAt_;
                bindInfo.connectedQq_ = this.connectedQq_;
                bindInfo.salesChannel_ = this.salesChannel_;
                onBuilt();
                return bindInfo;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.f0, com.google.protobuf.g0
            public BindInfo getDefaultInstanceForType() {
                return BindInfo.getDefaultInstance();
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
                this.deviceId_ = "";
                this.deviceType_ = 0;
                this.deviceName_ = "";
                this.model_ = "";
                this.bluetoothAddress_ = "";
                this.wifiAddress_ = "";
                this.deviceSn_ = "";
                this.onlineStatus_ = 0;
                this.createdAt_ = 0L;
                this.updatedAt_ = 0L;
                this.connectedQq_ = false;
                this.salesChannel_ = "";
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a, com.google.protobuf.b.a
            public Builder clone() {
                return (Builder) super.clone();
            }

            @Override // com.google.protobuf.a.AbstractC0170a, com.google.protobuf.d0.a
            public Builder mergeFrom(d0 d0Var) {
                if (d0Var instanceof BindInfo) {
                    return mergeFrom((BindInfo) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            public Builder mergeFrom(BindInfo bindInfo) {
                if (bindInfo == BindInfo.getDefaultInstance()) {
                    return this;
                }
                if (!bindInfo.getWwid().isEmpty()) {
                    this.wwid_ = bindInfo.wwid_;
                    onChanged();
                }
                if (!bindInfo.getDeviceId().isEmpty()) {
                    this.deviceId_ = bindInfo.deviceId_;
                    onChanged();
                }
                if (bindInfo.deviceType_ != 0) {
                    setDeviceTypeValue(bindInfo.getDeviceTypeValue());
                }
                if (!bindInfo.getDeviceName().isEmpty()) {
                    this.deviceName_ = bindInfo.deviceName_;
                    onChanged();
                }
                if (!bindInfo.getModel().isEmpty()) {
                    this.model_ = bindInfo.model_;
                    onChanged();
                }
                if (!bindInfo.getBluetoothAddress().isEmpty()) {
                    this.bluetoothAddress_ = bindInfo.bluetoothAddress_;
                    onChanged();
                }
                if (!bindInfo.getWifiAddress().isEmpty()) {
                    this.wifiAddress_ = bindInfo.wifiAddress_;
                    onChanged();
                }
                if (!bindInfo.getDeviceSn().isEmpty()) {
                    this.deviceSn_ = bindInfo.deviceSn_;
                    onChanged();
                }
                if (bindInfo.onlineStatus_ != 0) {
                    setOnlineStatusValue(bindInfo.getOnlineStatusValue());
                }
                if (bindInfo.getCreatedAt() != 0) {
                    setCreatedAt(bindInfo.getCreatedAt());
                }
                if (bindInfo.getUpdatedAt() != 0) {
                    setUpdatedAt(bindInfo.getUpdatedAt());
                }
                if (bindInfo.getConnectedQq()) {
                    setConnectedQq(bindInfo.getConnectedQq());
                }
                if (!bindInfo.getSalesChannel().isEmpty()) {
                    this.salesChannel_ = bindInfo.salesChannel_;
                    onChanged();
                }
                onChanged();
                return this;
            }

            private Builder(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.wwid_ = "";
                this.deviceId_ = "";
                this.deviceType_ = 0;
                this.deviceName_ = "";
                this.model_ = "";
                this.bluetoothAddress_ = "";
                this.wifiAddress_ = "";
                this.deviceSn_ = "";
                this.onlineStatus_ = 0;
                this.salesChannel_ = "";
                maybeForceBuilderInitialization();
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x0023  */
            @Override // com.google.protobuf.a.AbstractC0170a, com.google.protobuf.b.a, com.google.protobuf.e0.a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(i iVar, q qVar) throws IOException {
                Throwable th2;
                BindInfo bindInfo = null;
                try {
                    try {
                        BindInfo bindInfo2 = (BindInfo) BindInfo.PARSER.parsePartialFrom(iVar, qVar);
                        if (bindInfo2 != null) {
                            mergeFrom(bindInfo2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e10) {
                        bindInfo = (BindInfo) e10.getUnfinishedMessage();
                        try {
                            throw e10.unwrapIOException();
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (bindInfo != null) {
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (bindInfo != null) {
                        mergeFrom(bindInfo);
                    }
                    throw th2;
                }
            }
        }

        public static Builder newBuilder(BindInfo bindInfo) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(bindInfo);
        }

        public static BindInfo parseFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, qVar);
        }

        private BindInfo(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static BindInfo parseDelimitedFrom(InputStream inputStream, q qVar) throws IOException {
            return (BindInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
        }

        public static BindInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
        public BindInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static BindInfo parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder newBuilderForType() {
            return newBuilder();
        }

        private BindInfo() {
            this.memoizedIsInitialized = (byte) -1;
            this.wwid_ = "";
            this.deviceId_ = "";
            this.deviceType_ = 0;
            this.deviceName_ = "";
            this.model_ = "";
            this.bluetoothAddress_ = "";
            this.wifiAddress_ = "";
            this.deviceSn_ = "";
            this.onlineStatus_ = 0;
            this.createdAt_ = 0L;
            this.updatedAt_ = 0L;
            this.connectedQq_ = false;
            this.salesChannel_ = "";
        }

        public static BindInfo parseFrom(InputStream inputStream) throws IOException {
            return (BindInfo) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.c cVar) {
            return new Builder(cVar);
        }

        public static BindInfo parseFrom(InputStream inputStream, q qVar) throws IOException {
            return (BindInfo) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
        }

        public static BindInfo parseFrom(i iVar) throws IOException {
            return (BindInfo) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
        }

        public static BindInfo parseFrom(i iVar, q qVar) throws IOException {
            return (BindInfo) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
        }

        private BindInfo(i iVar, q qVar) throws InvalidProtocolBufferException {
            this();
            boolean z10 = false;
            while (!z10) {
                try {
                    try {
                        try {
                            int F = iVar.F();
                            z10 = true;
                            switch (F) {
                                case 0:
                                    break;
                                case 10:
                                    this.wwid_ = iVar.E();
                                    continue;
                                case 18:
                                    this.deviceId_ = iVar.E();
                                    continue;
                                case 24:
                                    this.deviceType_ = iVar.o();
                                    continue;
                                case 34:
                                    this.deviceName_ = iVar.E();
                                    continue;
                                case 42:
                                    this.model_ = iVar.E();
                                    continue;
                                case 50:
                                    this.bluetoothAddress_ = iVar.E();
                                    continue;
                                case 58:
                                    this.wifiAddress_ = iVar.E();
                                    continue;
                                case 66:
                                    this.deviceSn_ = iVar.E();
                                    continue;
                                case 72:
                                    this.onlineStatus_ = iVar.o();
                                    continue;
                                case 80:
                                    this.createdAt_ = iVar.u();
                                    continue;
                                case 88:
                                    this.updatedAt_ = iVar.u();
                                    continue;
                                case 96:
                                    this.connectedQq_ = iVar.l();
                                    continue;
                                case 106:
                                    this.salesChannel_ = iVar.E();
                                    continue;
                                default:
                                    if (!iVar.I(F)) {
                                        break;
                                    } else {
                                        continue;
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
    public interface BindInfoOrBuilder extends g0 {
        /* synthetic */ List<String> findInitializationErrors();

        @Override // com.google.protobuf.g0
        /* synthetic */ Map<Descriptors.FieldDescriptor, Object> getAllFields();

        String getBluetoothAddress();

        ByteString getBluetoothAddressBytes();

        boolean getConnectedQq();

        long getCreatedAt();

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

        String getDeviceSn();

        ByteString getDeviceSnBytes();

        DeviceType getDeviceType();

        int getDeviceTypeValue();

        @Override // com.google.protobuf.g0
        /* synthetic */ Object getField(Descriptors.FieldDescriptor fieldDescriptor);

        /* synthetic */ String getInitializationErrorString();

        String getModel();

        ByteString getModelBytes();

        /* synthetic */ Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.h hVar);

        DeviceOnlineStatus getOnlineStatus();

        int getOnlineStatusValue();

        /* synthetic */ Object getRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i10);

        /* synthetic */ int getRepeatedFieldCount(Descriptors.FieldDescriptor fieldDescriptor);

        String getSalesChannel();

        ByteString getSalesChannelBytes();

        @Override // com.google.protobuf.g0
        /* synthetic */ a1 getUnknownFields();

        long getUpdatedAt();

        String getWifiAddress();

        ByteString getWifiAddressBytes();

        String getWwid();

        ByteString getWwidBytes();

        @Override // com.google.protobuf.g0
        /* synthetic */ boolean hasField(Descriptors.FieldDescriptor fieldDescriptor);

        /* synthetic */ boolean hasOneof(Descriptors.h hVar);

        @Override // com.google.protobuf.f0
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes2.dex */
    public static final class BindInfoResponse extends GeneratedMessageV3 implements BindInfoResponseOrBuilder {
        public static final int BIND_INFO_FIELD_NUMBER = 1;
        private static final BindInfoResponse DEFAULT_INSTANCE = new BindInfoResponse();
        private static final l0<BindInfoResponse> PARSER = new c<BindInfoResponse>() { // from class: com.mobvoi.companion.ConstantsProto.BindInfoResponse.1
            @Override // com.google.protobuf.l0
            public BindInfoResponse parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
                return new BindInfoResponse(iVar, qVar);
            }
        };
        private static final long serialVersionUID = 0;
        private List<BindInfo> bindInfo_;
        private byte memoizedIsInitialized;

        public static BindInfoResponse getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return ConstantsProto.internal_static_common_BindInfoResponse_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static BindInfoResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (BindInfoResponse) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static BindInfoResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static l0<BindInfoResponse> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof BindInfoResponse)) {
                return super.equals(obj);
            }
            return getBindInfoList().equals(((BindInfoResponse) obj).getBindInfoList());
        }

        @Override // com.mobvoi.companion.ConstantsProto.BindInfoResponseOrBuilder
        public BindInfo getBindInfo(int i10) {
            return this.bindInfo_.get(i10);
        }

        @Override // com.mobvoi.companion.ConstantsProto.BindInfoResponseOrBuilder
        public int getBindInfoCount() {
            return this.bindInfo_.size();
        }

        @Override // com.mobvoi.companion.ConstantsProto.BindInfoResponseOrBuilder
        public List<BindInfo> getBindInfoList() {
            return this.bindInfo_;
        }

        @Override // com.mobvoi.companion.ConstantsProto.BindInfoResponseOrBuilder
        public BindInfoOrBuilder getBindInfoOrBuilder(int i10) {
            return this.bindInfo_.get(i10);
        }

        @Override // com.mobvoi.companion.ConstantsProto.BindInfoResponseOrBuilder
        public List<? extends BindInfoOrBuilder> getBindInfoOrBuilderList() {
            return this.bindInfo_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public l0<BindInfoResponse> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
        public int getSerializedSize() {
            int i10 = this.memoizedSize;
            if (i10 != -1) {
                return i10;
            }
            int i11 = 0;
            for (int i12 = 0; i12 < this.bindInfo_.size(); i12++) {
                i11 += CodedOutputStream.E(1, this.bindInfo_.get(i12));
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
            int hashCode = 779 + getDescriptorForType().hashCode();
            if (getBindInfoCount() > 0) {
                hashCode = (((hashCode * 37) + 1) * 53) + getBindInfoList().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return ConstantsProto.internal_static_common_BindInfoResponse_fieldAccessorTable.e(BindInfoResponse.class, Builder.class);
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
            for (int i10 = 0; i10 < this.bindInfo_.size(); i10++) {
                codedOutputStream.A0(1, this.bindInfo_.get(i10));
            }
        }

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageV3.b<Builder> implements BindInfoResponseOrBuilder {
            private o0<BindInfo, BindInfo.Builder, BindInfoOrBuilder> bindInfoBuilder_;
            private List<BindInfo> bindInfo_;
            private int bitField0_;

            private void ensureBindInfoIsMutable() {
                if ((this.bitField0_ & 1) != 1) {
                    this.bindInfo_ = new ArrayList(this.bindInfo_);
                    this.bitField0_ |= 1;
                }
            }

            private o0<BindInfo, BindInfo.Builder, BindInfoOrBuilder> getBindInfoFieldBuilder() {
                if (this.bindInfoBuilder_ == null) {
                    List<BindInfo> list = this.bindInfo_;
                    boolean z10 = true;
                    if ((this.bitField0_ & 1) != 1) {
                        z10 = false;
                    }
                    this.bindInfoBuilder_ = new o0<>(list, z10, getParentForChildren(), isClean());
                    this.bindInfo_ = null;
                }
                return this.bindInfoBuilder_;
            }

            public static final Descriptors.b getDescriptor() {
                return ConstantsProto.internal_static_common_BindInfoResponse_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                    getBindInfoFieldBuilder();
                }
            }

            public Builder addAllBindInfo(Iterable<? extends BindInfo> iterable) {
                o0<BindInfo, BindInfo.Builder, BindInfoOrBuilder> o0Var = this.bindInfoBuilder_;
                if (o0Var == null) {
                    ensureBindInfoIsMutable();
                    b.a.addAll(iterable, this.bindInfo_);
                    onChanged();
                } else {
                    o0Var.b(iterable);
                }
                return this;
            }

            public Builder addBindInfo(BindInfo bindInfo) {
                o0<BindInfo, BindInfo.Builder, BindInfoOrBuilder> o0Var = this.bindInfoBuilder_;
                if (o0Var == null) {
                    Objects.requireNonNull(bindInfo);
                    ensureBindInfoIsMutable();
                    this.bindInfo_.add(bindInfo);
                    onChanged();
                } else {
                    o0Var.f(bindInfo);
                }
                return this;
            }

            public BindInfo.Builder addBindInfoBuilder() {
                return getBindInfoFieldBuilder().d(BindInfo.getDefaultInstance());
            }

            public Builder clearBindInfo() {
                o0<BindInfo, BindInfo.Builder, BindInfoOrBuilder> o0Var = this.bindInfoBuilder_;
                if (o0Var == null) {
                    this.bindInfo_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    o0Var.h();
                }
                return this;
            }

            @Override // com.mobvoi.companion.ConstantsProto.BindInfoResponseOrBuilder
            public BindInfo getBindInfo(int i10) {
                o0<BindInfo, BindInfo.Builder, BindInfoOrBuilder> o0Var = this.bindInfoBuilder_;
                if (o0Var == null) {
                    return this.bindInfo_.get(i10);
                }
                return o0Var.o(i10);
            }

            public BindInfo.Builder getBindInfoBuilder(int i10) {
                return getBindInfoFieldBuilder().l(i10);
            }

            public List<BindInfo.Builder> getBindInfoBuilderList() {
                return getBindInfoFieldBuilder().m();
            }

            @Override // com.mobvoi.companion.ConstantsProto.BindInfoResponseOrBuilder
            public int getBindInfoCount() {
                o0<BindInfo, BindInfo.Builder, BindInfoOrBuilder> o0Var = this.bindInfoBuilder_;
                if (o0Var == null) {
                    return this.bindInfo_.size();
                }
                return o0Var.n();
            }

            @Override // com.mobvoi.companion.ConstantsProto.BindInfoResponseOrBuilder
            public List<BindInfo> getBindInfoList() {
                o0<BindInfo, BindInfo.Builder, BindInfoOrBuilder> o0Var = this.bindInfoBuilder_;
                if (o0Var == null) {
                    return Collections.unmodifiableList(this.bindInfo_);
                }
                return o0Var.q();
            }

            @Override // com.mobvoi.companion.ConstantsProto.BindInfoResponseOrBuilder
            public BindInfoOrBuilder getBindInfoOrBuilder(int i10) {
                o0<BindInfo, BindInfo.Builder, BindInfoOrBuilder> o0Var = this.bindInfoBuilder_;
                if (o0Var == null) {
                    return this.bindInfo_.get(i10);
                }
                return o0Var.r(i10);
            }

            @Override // com.mobvoi.companion.ConstantsProto.BindInfoResponseOrBuilder
            public List<? extends BindInfoOrBuilder> getBindInfoOrBuilderList() {
                o0<BindInfo, BindInfo.Builder, BindInfoOrBuilder> o0Var = this.bindInfoBuilder_;
                if (o0Var != null) {
                    return o0Var.s();
                }
                return Collections.unmodifiableList(this.bindInfo_);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a, com.google.protobuf.g0
            public Descriptors.b getDescriptorForType() {
                return ConstantsProto.internal_static_common_BindInfoResponse_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return ConstantsProto.internal_static_common_BindInfoResponse_fieldAccessorTable.e(BindInfoResponse.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.f0
            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a
            public final Builder mergeUnknownFields(a1 a1Var) {
                return this;
            }

            public Builder removeBindInfo(int i10) {
                o0<BindInfo, BindInfo.Builder, BindInfoOrBuilder> o0Var = this.bindInfoBuilder_;
                if (o0Var == null) {
                    ensureBindInfoIsMutable();
                    this.bindInfo_.remove(i10);
                    onChanged();
                } else {
                    o0Var.w(i10);
                }
                return this;
            }

            public Builder setBindInfo(int i10, BindInfo bindInfo) {
                o0<BindInfo, BindInfo.Builder, BindInfoOrBuilder> o0Var = this.bindInfoBuilder_;
                if (o0Var == null) {
                    Objects.requireNonNull(bindInfo);
                    ensureBindInfoIsMutable();
                    this.bindInfo_.set(i10, bindInfo);
                    onChanged();
                } else {
                    o0Var.x(i10, bindInfo);
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public final Builder setUnknownFields(a1 a1Var) {
                return this;
            }

            private Builder() {
                this.bindInfo_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.e0.a, com.google.protobuf.d0.a
            public BindInfoResponse build() {
                BindInfoResponse buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) buildPartial);
            }

            @Override // com.google.protobuf.e0.a, com.google.protobuf.d0.a
            public BindInfoResponse buildPartial() {
                BindInfoResponse bindInfoResponse = new BindInfoResponse(this);
                int i10 = this.bitField0_;
                o0<BindInfo, BindInfo.Builder, BindInfoOrBuilder> o0Var = this.bindInfoBuilder_;
                if (o0Var == null) {
                    if ((i10 & 1) == 1) {
                        this.bindInfo_ = Collections.unmodifiableList(this.bindInfo_);
                        this.bitField0_ &= -2;
                    }
                    bindInfoResponse.bindInfo_ = this.bindInfo_;
                } else {
                    bindInfoResponse.bindInfo_ = o0Var.g();
                }
                onBuilt();
                return bindInfoResponse;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.f0, com.google.protobuf.g0
            public BindInfoResponse getDefaultInstanceForType() {
                return BindInfoResponse.getDefaultInstance();
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

            public BindInfo.Builder addBindInfoBuilder(int i10) {
                return getBindInfoFieldBuilder().c(i10, BindInfo.getDefaultInstance());
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a
            public Builder clearOneof(Descriptors.h hVar) {
                return (Builder) super.clearOneof(hVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a
            public Builder clear() {
                super.clear();
                o0<BindInfo, BindInfo.Builder, BindInfoOrBuilder> o0Var = this.bindInfoBuilder_;
                if (o0Var == null) {
                    this.bindInfo_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    o0Var.h();
                }
                return this;
            }

            private Builder(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.bindInfo_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            public Builder addBindInfo(int i10, BindInfo bindInfo) {
                o0<BindInfo, BindInfo.Builder, BindInfoOrBuilder> o0Var = this.bindInfoBuilder_;
                if (o0Var == null) {
                    Objects.requireNonNull(bindInfo);
                    ensureBindInfoIsMutable();
                    this.bindInfo_.add(i10, bindInfo);
                    onChanged();
                } else {
                    o0Var.e(i10, bindInfo);
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a, com.google.protobuf.b.a
            public Builder clone() {
                return (Builder) super.clone();
            }

            @Override // com.google.protobuf.a.AbstractC0170a, com.google.protobuf.d0.a
            public Builder mergeFrom(d0 d0Var) {
                if (d0Var instanceof BindInfoResponse) {
                    return mergeFrom((BindInfoResponse) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            public Builder setBindInfo(int i10, BindInfo.Builder builder) {
                o0<BindInfo, BindInfo.Builder, BindInfoOrBuilder> o0Var = this.bindInfoBuilder_;
                if (o0Var == null) {
                    ensureBindInfoIsMutable();
                    this.bindInfo_.set(i10, builder.build());
                    onChanged();
                } else {
                    o0Var.x(i10, builder.build());
                }
                return this;
            }

            public Builder mergeFrom(BindInfoResponse bindInfoResponse) {
                if (bindInfoResponse == BindInfoResponse.getDefaultInstance()) {
                    return this;
                }
                if (this.bindInfoBuilder_ == null) {
                    if (!bindInfoResponse.bindInfo_.isEmpty()) {
                        if (this.bindInfo_.isEmpty()) {
                            this.bindInfo_ = bindInfoResponse.bindInfo_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureBindInfoIsMutable();
                            this.bindInfo_.addAll(bindInfoResponse.bindInfo_);
                        }
                        onChanged();
                    }
                } else if (!bindInfoResponse.bindInfo_.isEmpty()) {
                    if (this.bindInfoBuilder_.u()) {
                        this.bindInfoBuilder_.i();
                        o0<BindInfo, BindInfo.Builder, BindInfoOrBuilder> o0Var = null;
                        this.bindInfoBuilder_ = null;
                        this.bindInfo_ = bindInfoResponse.bindInfo_;
                        this.bitField0_ &= -2;
                        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                            o0Var = getBindInfoFieldBuilder();
                        }
                        this.bindInfoBuilder_ = o0Var;
                    } else {
                        this.bindInfoBuilder_.b(bindInfoResponse.bindInfo_);
                    }
                }
                onChanged();
                return this;
            }

            public Builder addBindInfo(BindInfo.Builder builder) {
                o0<BindInfo, BindInfo.Builder, BindInfoOrBuilder> o0Var = this.bindInfoBuilder_;
                if (o0Var == null) {
                    ensureBindInfoIsMutable();
                    this.bindInfo_.add(builder.build());
                    onChanged();
                } else {
                    o0Var.f(builder.build());
                }
                return this;
            }

            public Builder addBindInfo(int i10, BindInfo.Builder builder) {
                o0<BindInfo, BindInfo.Builder, BindInfoOrBuilder> o0Var = this.bindInfoBuilder_;
                if (o0Var == null) {
                    ensureBindInfoIsMutable();
                    this.bindInfo_.add(i10, builder.build());
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
                BindInfoResponse bindInfoResponse = null;
                try {
                    try {
                        BindInfoResponse bindInfoResponse2 = (BindInfoResponse) BindInfoResponse.PARSER.parsePartialFrom(iVar, qVar);
                        if (bindInfoResponse2 != null) {
                            mergeFrom(bindInfoResponse2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e10) {
                        bindInfoResponse = (BindInfoResponse) e10.getUnfinishedMessage();
                        try {
                            throw e10.unwrapIOException();
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (bindInfoResponse != null) {
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (bindInfoResponse != null) {
                        mergeFrom(bindInfoResponse);
                    }
                    throw th2;
                }
            }
        }

        public static Builder newBuilder(BindInfoResponse bindInfoResponse) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(bindInfoResponse);
        }

        public static BindInfoResponse parseFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, qVar);
        }

        private BindInfoResponse(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static BindInfoResponse parseDelimitedFrom(InputStream inputStream, q qVar) throws IOException {
            return (BindInfoResponse) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
        }

        public static BindInfoResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
        public BindInfoResponse getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static BindInfoResponse parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder newBuilderForType() {
            return newBuilder();
        }

        private BindInfoResponse() {
            this.memoizedIsInitialized = (byte) -1;
            this.bindInfo_ = Collections.emptyList();
        }

        public static BindInfoResponse parseFrom(InputStream inputStream) throws IOException {
            return (BindInfoResponse) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.c cVar) {
            return new Builder(cVar);
        }

        public static BindInfoResponse parseFrom(InputStream inputStream, q qVar) throws IOException {
            return (BindInfoResponse) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
        }

        private BindInfoResponse(i iVar, q qVar) throws InvalidProtocolBufferException {
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
                                    this.bindInfo_ = new ArrayList();
                                    z11 |= true;
                                }
                                this.bindInfo_.add((BindInfo) iVar.v(BindInfo.parser(), qVar));
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
                        this.bindInfo_ = Collections.unmodifiableList(this.bindInfo_);
                    }
                    makeExtensionsImmutable();
                }
            }
        }

        public static BindInfoResponse parseFrom(i iVar) throws IOException {
            return (BindInfoResponse) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
        }

        public static BindInfoResponse parseFrom(i iVar, q qVar) throws IOException {
            return (BindInfoResponse) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
        }
    }

    /* loaded from: classes2.dex */
    public interface BindInfoResponseOrBuilder extends g0 {
        /* synthetic */ List<String> findInitializationErrors();

        @Override // com.google.protobuf.g0
        /* synthetic */ Map<Descriptors.FieldDescriptor, Object> getAllFields();

        BindInfo getBindInfo(int i10);

        int getBindInfoCount();

        List<BindInfo> getBindInfoList();

        BindInfoOrBuilder getBindInfoOrBuilder(int i10);

        List<? extends BindInfoOrBuilder> getBindInfoOrBuilderList();

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
    public enum Channel implements m0 {
        UNKNOWN_CHANNEL(0),
        DEV(1),
        BETA(2),
        RELEASE(3),
        ALL(4),
        UNRECOGNIZED(-1);
        
        public static final int ALL_VALUE = 4;
        public static final int BETA_VALUE = 2;
        public static final int DEV_VALUE = 1;
        public static final int RELEASE_VALUE = 3;
        public static final int UNKNOWN_CHANNEL_VALUE = 0;
        private final int value;
        private static final u.b<Channel> internalValueMap = new u.b<Channel>() { // from class: com.mobvoi.companion.ConstantsProto.Channel.1
            public Channel findValueByNumber(int i10) {
                return Channel.forNumber(i10);
            }
        };
        private static final Channel[] VALUES = values();

        Channel(int i10) {
            this.value = i10;
        }

        public static Channel forNumber(int i10) {
            if (i10 == 0) {
                return UNKNOWN_CHANNEL;
            }
            if (i10 == 1) {
                return DEV;
            }
            if (i10 == 2) {
                return BETA;
            }
            if (i10 == 3) {
                return RELEASE;
            }
            if (i10 != 4) {
                return null;
            }
            return ALL;
        }

        public static final Descriptors.d getDescriptor() {
            return ConstantsProto.getDescriptor().i().get(2);
        }

        public static u.b<Channel> internalGetValueMap() {
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
        public static Channel valueOf(int i10) {
            return forNumber(i10);
        }

        public static Channel valueOf(Descriptors.e eVar) {
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
    public enum DeviceOnlineStatus implements m0 {
        UNKNOWN_STATUS(0),
        OFF_LINE(1),
        ON_LINE(2),
        UNRECOGNIZED(-1);
        
        public static final int OFF_LINE_VALUE = 1;
        public static final int ON_LINE_VALUE = 2;
        public static final int UNKNOWN_STATUS_VALUE = 0;
        private final int value;
        private static final u.b<DeviceOnlineStatus> internalValueMap = new u.b<DeviceOnlineStatus>() { // from class: com.mobvoi.companion.ConstantsProto.DeviceOnlineStatus.1
            public DeviceOnlineStatus findValueByNumber(int i10) {
                return DeviceOnlineStatus.forNumber(i10);
            }
        };
        private static final DeviceOnlineStatus[] VALUES = values();

        DeviceOnlineStatus(int i10) {
            this.value = i10;
        }

        public static DeviceOnlineStatus forNumber(int i10) {
            if (i10 == 0) {
                return UNKNOWN_STATUS;
            }
            if (i10 == 1) {
                return OFF_LINE;
            }
            if (i10 != 2) {
                return null;
            }
            return ON_LINE;
        }

        public static final Descriptors.d getDescriptor() {
            return ConstantsProto.getDescriptor().i().get(0);
        }

        public static u.b<DeviceOnlineStatus> internalGetValueMap() {
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
        public static DeviceOnlineStatus valueOf(int i10) {
            return forNumber(i10);
        }

        public static DeviceOnlineStatus valueOf(Descriptors.e eVar) {
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
    public enum DeviceType implements m0 {
        UNKNOWN_DEVICE_TYPE(0),
        TIC_WATCH(1),
        TIC_MIRROR(2),
        TIC_HOME(3),
        TIC_ASSISTANT(4),
        TIC_ASSISTANT_IOS(5),
        TIC_HOME_MINI(6),
        TIC_PODS(7),
        TIC_BAND(8),
        TIC_KIDS(9),
        TIC_LIFE(10),
        TIC_ASSISTANT_OEM(11),
        UNRECOGNIZED(-1);
        
        public static final int TIC_ASSISTANT_IOS_VALUE = 5;
        public static final int TIC_ASSISTANT_OEM_VALUE = 11;
        public static final int TIC_ASSISTANT_VALUE = 4;
        public static final int TIC_BAND_VALUE = 8;
        public static final int TIC_HOME_MINI_VALUE = 6;
        public static final int TIC_HOME_VALUE = 3;
        public static final int TIC_KIDS_VALUE = 9;
        public static final int TIC_LIFE_VALUE = 10;
        public static final int TIC_MIRROR_VALUE = 2;
        public static final int TIC_PODS_VALUE = 7;
        public static final int TIC_WATCH_VALUE = 1;
        public static final int UNKNOWN_DEVICE_TYPE_VALUE = 0;
        private final int value;
        private static final u.b<DeviceType> internalValueMap = new u.b<DeviceType>() { // from class: com.mobvoi.companion.ConstantsProto.DeviceType.1
            public DeviceType findValueByNumber(int i10) {
                return DeviceType.forNumber(i10);
            }
        };
        private static final DeviceType[] VALUES = values();

        DeviceType(int i10) {
            this.value = i10;
        }

        public static DeviceType forNumber(int i10) {
            switch (i10) {
                case 0:
                    return UNKNOWN_DEVICE_TYPE;
                case 1:
                    return TIC_WATCH;
                case 2:
                    return TIC_MIRROR;
                case 3:
                    return TIC_HOME;
                case 4:
                    return TIC_ASSISTANT;
                case 5:
                    return TIC_ASSISTANT_IOS;
                case 6:
                    return TIC_HOME_MINI;
                case 7:
                    return TIC_PODS;
                case 8:
                    return TIC_BAND;
                case 9:
                    return TIC_KIDS;
                case 10:
                    return TIC_LIFE;
                case 11:
                    return TIC_ASSISTANT_OEM;
                default:
                    return null;
            }
        }

        public static final Descriptors.d getDescriptor() {
            return ConstantsProto.getDescriptor().i().get(1);
        }

        public static u.b<DeviceType> internalGetValueMap() {
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
        public static DeviceType valueOf(int i10) {
            return forNumber(i10);
        }

        public static DeviceType valueOf(Descriptors.e eVar) {
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
    public static final class HotelAdminResp extends GeneratedMessageV3 implements HotelAdminRespOrBuilder {
        public static final int IS_ADMIN_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private boolean isAdmin_;
        private byte memoizedIsInitialized;
        private static final HotelAdminResp DEFAULT_INSTANCE = new HotelAdminResp();
        private static final l0<HotelAdminResp> PARSER = new c<HotelAdminResp>() { // from class: com.mobvoi.companion.ConstantsProto.HotelAdminResp.1
            @Override // com.google.protobuf.l0
            public HotelAdminResp parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
                return new HotelAdminResp(iVar, qVar);
            }
        };

        public static HotelAdminResp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return ConstantsProto.internal_static_common_HotelAdminResp_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static HotelAdminResp parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (HotelAdminResp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static HotelAdminResp parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static l0<HotelAdminResp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof HotelAdminResp)) {
                return super.equals(obj);
            }
            return getIsAdmin() == ((HotelAdminResp) obj).getIsAdmin();
        }

        @Override // com.mobvoi.companion.ConstantsProto.HotelAdminRespOrBuilder
        public boolean getIsAdmin() {
            return this.isAdmin_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public l0<HotelAdminResp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
        public int getSerializedSize() {
            int i10 = this.memoizedSize;
            if (i10 != -1) {
                return i10;
            }
            int i11 = 0;
            boolean z10 = this.isAdmin_;
            if (z10) {
                i11 = 0 + CodedOutputStream.e(1, z10);
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
            int hashCode = ((((((779 + getDescriptorForType().hashCode()) * 37) + 1) * 53) + u.c(getIsAdmin())) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return ConstantsProto.internal_static_common_HotelAdminResp_fieldAccessorTable.e(HotelAdminResp.class, Builder.class);
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
            boolean z10 = this.isAdmin_;
            if (z10) {
                codedOutputStream.e0(1, z10);
            }
        }

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageV3.b<Builder> implements HotelAdminRespOrBuilder {
            private boolean isAdmin_;

            public static final Descriptors.b getDescriptor() {
                return ConstantsProto.internal_static_common_HotelAdminResp_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            public Builder clearIsAdmin() {
                this.isAdmin_ = false;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a, com.google.protobuf.g0
            public Descriptors.b getDescriptorForType() {
                return ConstantsProto.internal_static_common_HotelAdminResp_descriptor;
            }

            @Override // com.mobvoi.companion.ConstantsProto.HotelAdminRespOrBuilder
            public boolean getIsAdmin() {
                return this.isAdmin_;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return ConstantsProto.internal_static_common_HotelAdminResp_fieldAccessorTable.e(HotelAdminResp.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.f0
            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a
            public final Builder mergeUnknownFields(a1 a1Var) {
                return this;
            }

            public Builder setIsAdmin(boolean z10) {
                this.isAdmin_ = z10;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public final Builder setUnknownFields(a1 a1Var) {
                return this;
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.e0.a, com.google.protobuf.d0.a
            public HotelAdminResp build() {
                HotelAdminResp buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) buildPartial);
            }

            @Override // com.google.protobuf.e0.a, com.google.protobuf.d0.a
            public HotelAdminResp buildPartial() {
                HotelAdminResp hotelAdminResp = new HotelAdminResp(this);
                hotelAdminResp.isAdmin_ = this.isAdmin_;
                onBuilt();
                return hotelAdminResp;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.f0, com.google.protobuf.g0
            public HotelAdminResp getDefaultInstanceForType() {
                return HotelAdminResp.getDefaultInstance();
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

            private Builder(GeneratedMessageV3.c cVar) {
                super(cVar);
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a
            public Builder clear() {
                super.clear();
                this.isAdmin_ = false;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a, com.google.protobuf.b.a
            public Builder clone() {
                return (Builder) super.clone();
            }

            @Override // com.google.protobuf.a.AbstractC0170a, com.google.protobuf.d0.a
            public Builder mergeFrom(d0 d0Var) {
                if (d0Var instanceof HotelAdminResp) {
                    return mergeFrom((HotelAdminResp) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            public Builder mergeFrom(HotelAdminResp hotelAdminResp) {
                if (hotelAdminResp == HotelAdminResp.getDefaultInstance()) {
                    return this;
                }
                if (hotelAdminResp.getIsAdmin()) {
                    setIsAdmin(hotelAdminResp.getIsAdmin());
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
                HotelAdminResp hotelAdminResp = null;
                try {
                    try {
                        HotelAdminResp hotelAdminResp2 = (HotelAdminResp) HotelAdminResp.PARSER.parsePartialFrom(iVar, qVar);
                        if (hotelAdminResp2 != null) {
                            mergeFrom(hotelAdminResp2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e10) {
                        hotelAdminResp = (HotelAdminResp) e10.getUnfinishedMessage();
                        try {
                            throw e10.unwrapIOException();
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (hotelAdminResp != null) {
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (hotelAdminResp != null) {
                        mergeFrom(hotelAdminResp);
                    }
                    throw th2;
                }
            }
        }

        public static Builder newBuilder(HotelAdminResp hotelAdminResp) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(hotelAdminResp);
        }

        public static HotelAdminResp parseFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, qVar);
        }

        private HotelAdminResp(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static HotelAdminResp parseDelimitedFrom(InputStream inputStream, q qVar) throws IOException {
            return (HotelAdminResp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
        }

        public static HotelAdminResp parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
        public HotelAdminResp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static HotelAdminResp parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder newBuilderForType() {
            return newBuilder();
        }

        private HotelAdminResp() {
            this.memoizedIsInitialized = (byte) -1;
            this.isAdmin_ = false;
        }

        public static HotelAdminResp parseFrom(InputStream inputStream) throws IOException {
            return (HotelAdminResp) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.c cVar) {
            return new Builder(cVar);
        }

        public static HotelAdminResp parseFrom(InputStream inputStream, q qVar) throws IOException {
            return (HotelAdminResp) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
        }

        private HotelAdminResp(i iVar, q qVar) throws InvalidProtocolBufferException {
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
                                    this.isAdmin_ = iVar.l();
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

        public static HotelAdminResp parseFrom(i iVar) throws IOException {
            return (HotelAdminResp) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
        }

        public static HotelAdminResp parseFrom(i iVar, q qVar) throws IOException {
            return (HotelAdminResp) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
        }
    }

    /* loaded from: classes2.dex */
    public interface HotelAdminRespOrBuilder extends g0 {
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

        boolean getIsAdmin();

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
    public static final class HotelBindData extends GeneratedMessageV3 implements HotelBindDataOrBuilder {
        public static final int BIND_INFO_FIELD_NUMBER = 1;
        private static final HotelBindData DEFAULT_INSTANCE = new HotelBindData();
        private static final l0<HotelBindData> PARSER = new c<HotelBindData>() { // from class: com.mobvoi.companion.ConstantsProto.HotelBindData.1
            @Override // com.google.protobuf.l0
            public HotelBindData parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
                return new HotelBindData(iVar, qVar);
            }
        };
        public static final int SUB_TOKEN_FIELD_NUMBER = 3;
        public static final int TOKEN_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private BindInfo bindInfo_;
        private byte memoizedIsInitialized;
        private volatile Object subToken_;
        private volatile Object token_;

        public static HotelBindData getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return ConstantsProto.internal_static_common_HotelBindData_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static HotelBindData parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (HotelBindData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static HotelBindData parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static l0<HotelBindData> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof HotelBindData)) {
                return super.equals(obj);
            }
            HotelBindData hotelBindData = (HotelBindData) obj;
            boolean z10 = hasBindInfo() == hotelBindData.hasBindInfo();
            if (hasBindInfo()) {
                z10 = z10 && getBindInfo().equals(hotelBindData.getBindInfo());
            }
            return (z10 && getToken().equals(hotelBindData.getToken())) && getSubToken().equals(hotelBindData.getSubToken());
        }

        @Override // com.mobvoi.companion.ConstantsProto.HotelBindDataOrBuilder
        public BindInfo getBindInfo() {
            BindInfo bindInfo = this.bindInfo_;
            return bindInfo == null ? BindInfo.getDefaultInstance() : bindInfo;
        }

        @Override // com.mobvoi.companion.ConstantsProto.HotelBindDataOrBuilder
        public BindInfoOrBuilder getBindInfoOrBuilder() {
            return getBindInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public l0<HotelBindData> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
        public int getSerializedSize() {
            int i10 = this.memoizedSize;
            if (i10 != -1) {
                return i10;
            }
            int i11 = 0;
            if (this.bindInfo_ != null) {
                i11 = 0 + CodedOutputStream.E(1, getBindInfo());
            }
            if (!getTokenBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(2, this.token_);
            }
            if (!getSubTokenBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(3, this.subToken_);
            }
            this.memoizedSize = i11;
            return i11;
        }

        @Override // com.mobvoi.companion.ConstantsProto.HotelBindDataOrBuilder
        public String getSubToken() {
            Object obj = this.subToken_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.subToken_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.ConstantsProto.HotelBindDataOrBuilder
        public ByteString getSubTokenBytes() {
            Object obj = this.subToken_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.subToken_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.mobvoi.companion.ConstantsProto.HotelBindDataOrBuilder
        public String getToken() {
            Object obj = this.token_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.token_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.ConstantsProto.HotelBindDataOrBuilder
        public ByteString getTokenBytes() {
            Object obj = this.token_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.token_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.g0
        public final a1 getUnknownFields() {
            return a1.c();
        }

        @Override // com.mobvoi.companion.ConstantsProto.HotelBindDataOrBuilder
        public boolean hasBindInfo() {
            return this.bindInfo_ != null;
        }

        @Override // com.google.protobuf.a
        public int hashCode() {
            int i10 = this.memoizedHashCode;
            if (i10 != 0) {
                return i10;
            }
            int hashCode = 779 + getDescriptorForType().hashCode();
            if (hasBindInfo()) {
                hashCode = (((hashCode * 37) + 1) * 53) + getBindInfo().hashCode();
            }
            int hashCode2 = (((((((((hashCode * 37) + 2) * 53) + getToken().hashCode()) * 37) + 3) * 53) + getSubToken().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return ConstantsProto.internal_static_common_HotelBindData_fieldAccessorTable.e(HotelBindData.class, Builder.class);
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
            if (this.bindInfo_ != null) {
                codedOutputStream.A0(1, getBindInfo());
            }
            if (!getTokenBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.token_);
            }
            if (!getSubTokenBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 3, this.subToken_);
            }
        }

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageV3.b<Builder> implements HotelBindDataOrBuilder {
            private q0<BindInfo, BindInfo.Builder, BindInfoOrBuilder> bindInfoBuilder_;
            private BindInfo bindInfo_;
            private Object subToken_;
            private Object token_;

            private q0<BindInfo, BindInfo.Builder, BindInfoOrBuilder> getBindInfoFieldBuilder() {
                if (this.bindInfoBuilder_ == null) {
                    this.bindInfoBuilder_ = new q0<>(getBindInfo(), getParentForChildren(), isClean());
                    this.bindInfo_ = null;
                }
                return this.bindInfoBuilder_;
            }

            public static final Descriptors.b getDescriptor() {
                return ConstantsProto.internal_static_common_HotelBindData_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            public Builder clearBindInfo() {
                if (this.bindInfoBuilder_ == null) {
                    this.bindInfo_ = null;
                    onChanged();
                } else {
                    this.bindInfo_ = null;
                    this.bindInfoBuilder_ = null;
                }
                return this;
            }

            public Builder clearSubToken() {
                this.subToken_ = HotelBindData.getDefaultInstance().getSubToken();
                onChanged();
                return this;
            }

            public Builder clearToken() {
                this.token_ = HotelBindData.getDefaultInstance().getToken();
                onChanged();
                return this;
            }

            @Override // com.mobvoi.companion.ConstantsProto.HotelBindDataOrBuilder
            public BindInfo getBindInfo() {
                q0<BindInfo, BindInfo.Builder, BindInfoOrBuilder> q0Var = this.bindInfoBuilder_;
                if (q0Var != null) {
                    return q0Var.f();
                }
                BindInfo bindInfo = this.bindInfo_;
                return bindInfo == null ? BindInfo.getDefaultInstance() : bindInfo;
            }

            public BindInfo.Builder getBindInfoBuilder() {
                onChanged();
                return getBindInfoFieldBuilder().e();
            }

            @Override // com.mobvoi.companion.ConstantsProto.HotelBindDataOrBuilder
            public BindInfoOrBuilder getBindInfoOrBuilder() {
                q0<BindInfo, BindInfo.Builder, BindInfoOrBuilder> q0Var = this.bindInfoBuilder_;
                if (q0Var != null) {
                    return q0Var.g();
                }
                BindInfo bindInfo = this.bindInfo_;
                return bindInfo == null ? BindInfo.getDefaultInstance() : bindInfo;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a, com.google.protobuf.g0
            public Descriptors.b getDescriptorForType() {
                return ConstantsProto.internal_static_common_HotelBindData_descriptor;
            }

            @Override // com.mobvoi.companion.ConstantsProto.HotelBindDataOrBuilder
            public String getSubToken() {
                Object obj = this.subToken_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.subToken_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.ConstantsProto.HotelBindDataOrBuilder
            public ByteString getSubTokenBytes() {
                Object obj = this.subToken_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.subToken_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.mobvoi.companion.ConstantsProto.HotelBindDataOrBuilder
            public String getToken() {
                Object obj = this.token_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.token_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.ConstantsProto.HotelBindDataOrBuilder
            public ByteString getTokenBytes() {
                Object obj = this.token_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.token_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.mobvoi.companion.ConstantsProto.HotelBindDataOrBuilder
            public boolean hasBindInfo() {
                return (this.bindInfoBuilder_ == null && this.bindInfo_ == null) ? false : true;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return ConstantsProto.internal_static_common_HotelBindData_fieldAccessorTable.e(HotelBindData.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.f0
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeBindInfo(BindInfo bindInfo) {
                q0<BindInfo, BindInfo.Builder, BindInfoOrBuilder> q0Var = this.bindInfoBuilder_;
                if (q0Var == null) {
                    BindInfo bindInfo2 = this.bindInfo_;
                    if (bindInfo2 != null) {
                        this.bindInfo_ = BindInfo.newBuilder(bindInfo2).mergeFrom(bindInfo).buildPartial();
                    } else {
                        this.bindInfo_ = bindInfo;
                    }
                    onChanged();
                } else {
                    q0Var.h(bindInfo);
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a
            public final Builder mergeUnknownFields(a1 a1Var) {
                return this;
            }

            public Builder setBindInfo(BindInfo bindInfo) {
                q0<BindInfo, BindInfo.Builder, BindInfoOrBuilder> q0Var = this.bindInfoBuilder_;
                if (q0Var == null) {
                    Objects.requireNonNull(bindInfo);
                    this.bindInfo_ = bindInfo;
                    onChanged();
                } else {
                    q0Var.j(bindInfo);
                }
                return this;
            }

            public Builder setSubToken(String str) {
                Objects.requireNonNull(str);
                this.subToken_ = str;
                onChanged();
                return this;
            }

            public Builder setSubTokenBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                b.checkByteStringIsUtf8(byteString);
                this.subToken_ = byteString;
                onChanged();
                return this;
            }

            public Builder setToken(String str) {
                Objects.requireNonNull(str);
                this.token_ = str;
                onChanged();
                return this;
            }

            public Builder setTokenBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                b.checkByteStringIsUtf8(byteString);
                this.token_ = byteString;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public final Builder setUnknownFields(a1 a1Var) {
                return this;
            }

            private Builder() {
                this.bindInfo_ = null;
                this.token_ = "";
                this.subToken_ = "";
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.e0.a, com.google.protobuf.d0.a
            public HotelBindData build() {
                HotelBindData buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) buildPartial);
            }

            @Override // com.google.protobuf.e0.a, com.google.protobuf.d0.a
            public HotelBindData buildPartial() {
                HotelBindData hotelBindData = new HotelBindData(this);
                q0<BindInfo, BindInfo.Builder, BindInfoOrBuilder> q0Var = this.bindInfoBuilder_;
                if (q0Var == null) {
                    hotelBindData.bindInfo_ = this.bindInfo_;
                } else {
                    hotelBindData.bindInfo_ = q0Var.b();
                }
                hotelBindData.token_ = this.token_;
                hotelBindData.subToken_ = this.subToken_;
                onBuilt();
                return hotelBindData;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.f0, com.google.protobuf.g0
            public HotelBindData getDefaultInstanceForType() {
                return HotelBindData.getDefaultInstance();
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
                if (this.bindInfoBuilder_ == null) {
                    this.bindInfo_ = null;
                } else {
                    this.bindInfo_ = null;
                    this.bindInfoBuilder_ = null;
                }
                this.token_ = "";
                this.subToken_ = "";
                return this;
            }

            public Builder setBindInfo(BindInfo.Builder builder) {
                q0<BindInfo, BindInfo.Builder, BindInfoOrBuilder> q0Var = this.bindInfoBuilder_;
                if (q0Var == null) {
                    this.bindInfo_ = builder.build();
                    onChanged();
                } else {
                    q0Var.j(builder.build());
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a, com.google.protobuf.b.a
            public Builder clone() {
                return (Builder) super.clone();
            }

            @Override // com.google.protobuf.a.AbstractC0170a, com.google.protobuf.d0.a
            public Builder mergeFrom(d0 d0Var) {
                if (d0Var instanceof HotelBindData) {
                    return mergeFrom((HotelBindData) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            private Builder(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.bindInfo_ = null;
                this.token_ = "";
                this.subToken_ = "";
                maybeForceBuilderInitialization();
            }

            public Builder mergeFrom(HotelBindData hotelBindData) {
                if (hotelBindData == HotelBindData.getDefaultInstance()) {
                    return this;
                }
                if (hotelBindData.hasBindInfo()) {
                    mergeBindInfo(hotelBindData.getBindInfo());
                }
                if (!hotelBindData.getToken().isEmpty()) {
                    this.token_ = hotelBindData.token_;
                    onChanged();
                }
                if (!hotelBindData.getSubToken().isEmpty()) {
                    this.subToken_ = hotelBindData.subToken_;
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
                HotelBindData hotelBindData = null;
                try {
                    try {
                        HotelBindData hotelBindData2 = (HotelBindData) HotelBindData.PARSER.parsePartialFrom(iVar, qVar);
                        if (hotelBindData2 != null) {
                            mergeFrom(hotelBindData2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e10) {
                        hotelBindData = (HotelBindData) e10.getUnfinishedMessage();
                        try {
                            throw e10.unwrapIOException();
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (hotelBindData != null) {
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (hotelBindData != null) {
                        mergeFrom(hotelBindData);
                    }
                    throw th2;
                }
            }
        }

        public static Builder newBuilder(HotelBindData hotelBindData) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(hotelBindData);
        }

        public static HotelBindData parseFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, qVar);
        }

        private HotelBindData(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static HotelBindData parseDelimitedFrom(InputStream inputStream, q qVar) throws IOException {
            return (HotelBindData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
        }

        public static HotelBindData parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
        public HotelBindData getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static HotelBindData parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder newBuilderForType() {
            return newBuilder();
        }

        private HotelBindData() {
            this.memoizedIsInitialized = (byte) -1;
            this.token_ = "";
            this.subToken_ = "";
        }

        public static HotelBindData parseFrom(InputStream inputStream) throws IOException {
            return (HotelBindData) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.c cVar) {
            return new Builder(cVar);
        }

        public static HotelBindData parseFrom(InputStream inputStream, q qVar) throws IOException {
            return (HotelBindData) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
        }

        private HotelBindData(i iVar, q qVar) throws InvalidProtocolBufferException {
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
                                    BindInfo.Builder builder = null;
                                    BindInfo bindInfo = this.bindInfo_;
                                    builder = bindInfo != null ? bindInfo.toBuilder() : builder;
                                    BindInfo bindInfo2 = (BindInfo) iVar.v(BindInfo.parser(), qVar);
                                    this.bindInfo_ = bindInfo2;
                                    if (builder != null) {
                                        builder.mergeFrom(bindInfo2);
                                        this.bindInfo_ = builder.buildPartial();
                                    }
                                } else if (F == 18) {
                                    this.token_ = iVar.E();
                                } else if (F == 26) {
                                    this.subToken_ = iVar.E();
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

        public static HotelBindData parseFrom(i iVar) throws IOException {
            return (HotelBindData) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
        }

        public static HotelBindData parseFrom(i iVar, q qVar) throws IOException {
            return (HotelBindData) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
        }
    }

    /* loaded from: classes2.dex */
    public interface HotelBindDataOrBuilder extends g0 {
        /* synthetic */ List<String> findInitializationErrors();

        @Override // com.google.protobuf.g0
        /* synthetic */ Map<Descriptors.FieldDescriptor, Object> getAllFields();

        BindInfo getBindInfo();

        BindInfoOrBuilder getBindInfoOrBuilder();

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

        /* synthetic */ Object getRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i10);

        /* synthetic */ int getRepeatedFieldCount(Descriptors.FieldDescriptor fieldDescriptor);

        String getSubToken();

        ByteString getSubTokenBytes();

        String getToken();

        ByteString getTokenBytes();

        @Override // com.google.protobuf.g0
        /* synthetic */ a1 getUnknownFields();

        boolean hasBindInfo();

        @Override // com.google.protobuf.g0
        /* synthetic */ boolean hasField(Descriptors.FieldDescriptor fieldDescriptor);

        /* synthetic */ boolean hasOneof(Descriptors.h hVar);

        @Override // com.google.protobuf.f0
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes2.dex */
    public static final class HotelBindResp extends GeneratedMessageV3 implements HotelBindRespOrBuilder {
        public static final int HOTEL_BIND_DATA_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private List<HotelBindData> hotelBindData_;
        private byte memoizedIsInitialized;
        private static final HotelBindResp DEFAULT_INSTANCE = new HotelBindResp();
        private static final l0<HotelBindResp> PARSER = new c<HotelBindResp>() { // from class: com.mobvoi.companion.ConstantsProto.HotelBindResp.1
            @Override // com.google.protobuf.l0
            public HotelBindResp parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
                return new HotelBindResp(iVar, qVar);
            }
        };

        public static HotelBindResp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return ConstantsProto.internal_static_common_HotelBindResp_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static HotelBindResp parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (HotelBindResp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static HotelBindResp parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static l0<HotelBindResp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof HotelBindResp)) {
                return super.equals(obj);
            }
            return getHotelBindDataList().equals(((HotelBindResp) obj).getHotelBindDataList());
        }

        @Override // com.mobvoi.companion.ConstantsProto.HotelBindRespOrBuilder
        public HotelBindData getHotelBindData(int i10) {
            return this.hotelBindData_.get(i10);
        }

        @Override // com.mobvoi.companion.ConstantsProto.HotelBindRespOrBuilder
        public int getHotelBindDataCount() {
            return this.hotelBindData_.size();
        }

        @Override // com.mobvoi.companion.ConstantsProto.HotelBindRespOrBuilder
        public List<HotelBindData> getHotelBindDataList() {
            return this.hotelBindData_;
        }

        @Override // com.mobvoi.companion.ConstantsProto.HotelBindRespOrBuilder
        public HotelBindDataOrBuilder getHotelBindDataOrBuilder(int i10) {
            return this.hotelBindData_.get(i10);
        }

        @Override // com.mobvoi.companion.ConstantsProto.HotelBindRespOrBuilder
        public List<? extends HotelBindDataOrBuilder> getHotelBindDataOrBuilderList() {
            return this.hotelBindData_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public l0<HotelBindResp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
        public int getSerializedSize() {
            int i10 = this.memoizedSize;
            if (i10 != -1) {
                return i10;
            }
            int i11 = 0;
            for (int i12 = 0; i12 < this.hotelBindData_.size(); i12++) {
                i11 += CodedOutputStream.E(1, this.hotelBindData_.get(i12));
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
            int hashCode = 779 + getDescriptorForType().hashCode();
            if (getHotelBindDataCount() > 0) {
                hashCode = (((hashCode * 37) + 1) * 53) + getHotelBindDataList().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return ConstantsProto.internal_static_common_HotelBindResp_fieldAccessorTable.e(HotelBindResp.class, Builder.class);
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
            for (int i10 = 0; i10 < this.hotelBindData_.size(); i10++) {
                codedOutputStream.A0(1, this.hotelBindData_.get(i10));
            }
        }

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageV3.b<Builder> implements HotelBindRespOrBuilder {
            private int bitField0_;
            private o0<HotelBindData, HotelBindData.Builder, HotelBindDataOrBuilder> hotelBindDataBuilder_;
            private List<HotelBindData> hotelBindData_;

            private void ensureHotelBindDataIsMutable() {
                if ((this.bitField0_ & 1) != 1) {
                    this.hotelBindData_ = new ArrayList(this.hotelBindData_);
                    this.bitField0_ |= 1;
                }
            }

            public static final Descriptors.b getDescriptor() {
                return ConstantsProto.internal_static_common_HotelBindResp_descriptor;
            }

            private o0<HotelBindData, HotelBindData.Builder, HotelBindDataOrBuilder> getHotelBindDataFieldBuilder() {
                if (this.hotelBindDataBuilder_ == null) {
                    List<HotelBindData> list = this.hotelBindData_;
                    boolean z10 = true;
                    if ((this.bitField0_ & 1) != 1) {
                        z10 = false;
                    }
                    this.hotelBindDataBuilder_ = new o0<>(list, z10, getParentForChildren(), isClean());
                    this.hotelBindData_ = null;
                }
                return this.hotelBindDataBuilder_;
            }

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                    getHotelBindDataFieldBuilder();
                }
            }

            public Builder addAllHotelBindData(Iterable<? extends HotelBindData> iterable) {
                o0<HotelBindData, HotelBindData.Builder, HotelBindDataOrBuilder> o0Var = this.hotelBindDataBuilder_;
                if (o0Var == null) {
                    ensureHotelBindDataIsMutable();
                    b.a.addAll(iterable, this.hotelBindData_);
                    onChanged();
                } else {
                    o0Var.b(iterable);
                }
                return this;
            }

            public Builder addHotelBindData(HotelBindData hotelBindData) {
                o0<HotelBindData, HotelBindData.Builder, HotelBindDataOrBuilder> o0Var = this.hotelBindDataBuilder_;
                if (o0Var == null) {
                    Objects.requireNonNull(hotelBindData);
                    ensureHotelBindDataIsMutable();
                    this.hotelBindData_.add(hotelBindData);
                    onChanged();
                } else {
                    o0Var.f(hotelBindData);
                }
                return this;
            }

            public HotelBindData.Builder addHotelBindDataBuilder() {
                return getHotelBindDataFieldBuilder().d(HotelBindData.getDefaultInstance());
            }

            public Builder clearHotelBindData() {
                o0<HotelBindData, HotelBindData.Builder, HotelBindDataOrBuilder> o0Var = this.hotelBindDataBuilder_;
                if (o0Var == null) {
                    this.hotelBindData_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    o0Var.h();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a, com.google.protobuf.g0
            public Descriptors.b getDescriptorForType() {
                return ConstantsProto.internal_static_common_HotelBindResp_descriptor;
            }

            @Override // com.mobvoi.companion.ConstantsProto.HotelBindRespOrBuilder
            public HotelBindData getHotelBindData(int i10) {
                o0<HotelBindData, HotelBindData.Builder, HotelBindDataOrBuilder> o0Var = this.hotelBindDataBuilder_;
                if (o0Var == null) {
                    return this.hotelBindData_.get(i10);
                }
                return o0Var.o(i10);
            }

            public HotelBindData.Builder getHotelBindDataBuilder(int i10) {
                return getHotelBindDataFieldBuilder().l(i10);
            }

            public List<HotelBindData.Builder> getHotelBindDataBuilderList() {
                return getHotelBindDataFieldBuilder().m();
            }

            @Override // com.mobvoi.companion.ConstantsProto.HotelBindRespOrBuilder
            public int getHotelBindDataCount() {
                o0<HotelBindData, HotelBindData.Builder, HotelBindDataOrBuilder> o0Var = this.hotelBindDataBuilder_;
                if (o0Var == null) {
                    return this.hotelBindData_.size();
                }
                return o0Var.n();
            }

            @Override // com.mobvoi.companion.ConstantsProto.HotelBindRespOrBuilder
            public List<HotelBindData> getHotelBindDataList() {
                o0<HotelBindData, HotelBindData.Builder, HotelBindDataOrBuilder> o0Var = this.hotelBindDataBuilder_;
                if (o0Var == null) {
                    return Collections.unmodifiableList(this.hotelBindData_);
                }
                return o0Var.q();
            }

            @Override // com.mobvoi.companion.ConstantsProto.HotelBindRespOrBuilder
            public HotelBindDataOrBuilder getHotelBindDataOrBuilder(int i10) {
                o0<HotelBindData, HotelBindData.Builder, HotelBindDataOrBuilder> o0Var = this.hotelBindDataBuilder_;
                if (o0Var == null) {
                    return this.hotelBindData_.get(i10);
                }
                return o0Var.r(i10);
            }

            @Override // com.mobvoi.companion.ConstantsProto.HotelBindRespOrBuilder
            public List<? extends HotelBindDataOrBuilder> getHotelBindDataOrBuilderList() {
                o0<HotelBindData, HotelBindData.Builder, HotelBindDataOrBuilder> o0Var = this.hotelBindDataBuilder_;
                if (o0Var != null) {
                    return o0Var.s();
                }
                return Collections.unmodifiableList(this.hotelBindData_);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return ConstantsProto.internal_static_common_HotelBindResp_fieldAccessorTable.e(HotelBindResp.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.f0
            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a
            public final Builder mergeUnknownFields(a1 a1Var) {
                return this;
            }

            public Builder removeHotelBindData(int i10) {
                o0<HotelBindData, HotelBindData.Builder, HotelBindDataOrBuilder> o0Var = this.hotelBindDataBuilder_;
                if (o0Var == null) {
                    ensureHotelBindDataIsMutable();
                    this.hotelBindData_.remove(i10);
                    onChanged();
                } else {
                    o0Var.w(i10);
                }
                return this;
            }

            public Builder setHotelBindData(int i10, HotelBindData hotelBindData) {
                o0<HotelBindData, HotelBindData.Builder, HotelBindDataOrBuilder> o0Var = this.hotelBindDataBuilder_;
                if (o0Var == null) {
                    Objects.requireNonNull(hotelBindData);
                    ensureHotelBindDataIsMutable();
                    this.hotelBindData_.set(i10, hotelBindData);
                    onChanged();
                } else {
                    o0Var.x(i10, hotelBindData);
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public final Builder setUnknownFields(a1 a1Var) {
                return this;
            }

            private Builder() {
                this.hotelBindData_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.e0.a, com.google.protobuf.d0.a
            public HotelBindResp build() {
                HotelBindResp buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) buildPartial);
            }

            @Override // com.google.protobuf.e0.a, com.google.protobuf.d0.a
            public HotelBindResp buildPartial() {
                HotelBindResp hotelBindResp = new HotelBindResp(this);
                int i10 = this.bitField0_;
                o0<HotelBindData, HotelBindData.Builder, HotelBindDataOrBuilder> o0Var = this.hotelBindDataBuilder_;
                if (o0Var == null) {
                    if ((i10 & 1) == 1) {
                        this.hotelBindData_ = Collections.unmodifiableList(this.hotelBindData_);
                        this.bitField0_ &= -2;
                    }
                    hotelBindResp.hotelBindData_ = this.hotelBindData_;
                } else {
                    hotelBindResp.hotelBindData_ = o0Var.g();
                }
                onBuilt();
                return hotelBindResp;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.f0, com.google.protobuf.g0
            public HotelBindResp getDefaultInstanceForType() {
                return HotelBindResp.getDefaultInstance();
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

            public HotelBindData.Builder addHotelBindDataBuilder(int i10) {
                return getHotelBindDataFieldBuilder().c(i10, HotelBindData.getDefaultInstance());
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a
            public Builder clearOneof(Descriptors.h hVar) {
                return (Builder) super.clearOneof(hVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a
            public Builder clear() {
                super.clear();
                o0<HotelBindData, HotelBindData.Builder, HotelBindDataOrBuilder> o0Var = this.hotelBindDataBuilder_;
                if (o0Var == null) {
                    this.hotelBindData_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    o0Var.h();
                }
                return this;
            }

            private Builder(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.hotelBindData_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            public Builder addHotelBindData(int i10, HotelBindData hotelBindData) {
                o0<HotelBindData, HotelBindData.Builder, HotelBindDataOrBuilder> o0Var = this.hotelBindDataBuilder_;
                if (o0Var == null) {
                    Objects.requireNonNull(hotelBindData);
                    ensureHotelBindDataIsMutable();
                    this.hotelBindData_.add(i10, hotelBindData);
                    onChanged();
                } else {
                    o0Var.e(i10, hotelBindData);
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a, com.google.protobuf.b.a
            public Builder clone() {
                return (Builder) super.clone();
            }

            @Override // com.google.protobuf.a.AbstractC0170a, com.google.protobuf.d0.a
            public Builder mergeFrom(d0 d0Var) {
                if (d0Var instanceof HotelBindResp) {
                    return mergeFrom((HotelBindResp) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            public Builder setHotelBindData(int i10, HotelBindData.Builder builder) {
                o0<HotelBindData, HotelBindData.Builder, HotelBindDataOrBuilder> o0Var = this.hotelBindDataBuilder_;
                if (o0Var == null) {
                    ensureHotelBindDataIsMutable();
                    this.hotelBindData_.set(i10, builder.build());
                    onChanged();
                } else {
                    o0Var.x(i10, builder.build());
                }
                return this;
            }

            public Builder mergeFrom(HotelBindResp hotelBindResp) {
                if (hotelBindResp == HotelBindResp.getDefaultInstance()) {
                    return this;
                }
                if (this.hotelBindDataBuilder_ == null) {
                    if (!hotelBindResp.hotelBindData_.isEmpty()) {
                        if (this.hotelBindData_.isEmpty()) {
                            this.hotelBindData_ = hotelBindResp.hotelBindData_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureHotelBindDataIsMutable();
                            this.hotelBindData_.addAll(hotelBindResp.hotelBindData_);
                        }
                        onChanged();
                    }
                } else if (!hotelBindResp.hotelBindData_.isEmpty()) {
                    if (this.hotelBindDataBuilder_.u()) {
                        this.hotelBindDataBuilder_.i();
                        o0<HotelBindData, HotelBindData.Builder, HotelBindDataOrBuilder> o0Var = null;
                        this.hotelBindDataBuilder_ = null;
                        this.hotelBindData_ = hotelBindResp.hotelBindData_;
                        this.bitField0_ &= -2;
                        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                            o0Var = getHotelBindDataFieldBuilder();
                        }
                        this.hotelBindDataBuilder_ = o0Var;
                    } else {
                        this.hotelBindDataBuilder_.b(hotelBindResp.hotelBindData_);
                    }
                }
                onChanged();
                return this;
            }

            public Builder addHotelBindData(HotelBindData.Builder builder) {
                o0<HotelBindData, HotelBindData.Builder, HotelBindDataOrBuilder> o0Var = this.hotelBindDataBuilder_;
                if (o0Var == null) {
                    ensureHotelBindDataIsMutable();
                    this.hotelBindData_.add(builder.build());
                    onChanged();
                } else {
                    o0Var.f(builder.build());
                }
                return this;
            }

            public Builder addHotelBindData(int i10, HotelBindData.Builder builder) {
                o0<HotelBindData, HotelBindData.Builder, HotelBindDataOrBuilder> o0Var = this.hotelBindDataBuilder_;
                if (o0Var == null) {
                    ensureHotelBindDataIsMutable();
                    this.hotelBindData_.add(i10, builder.build());
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
                HotelBindResp hotelBindResp = null;
                try {
                    try {
                        HotelBindResp hotelBindResp2 = (HotelBindResp) HotelBindResp.PARSER.parsePartialFrom(iVar, qVar);
                        if (hotelBindResp2 != null) {
                            mergeFrom(hotelBindResp2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e10) {
                        hotelBindResp = (HotelBindResp) e10.getUnfinishedMessage();
                        try {
                            throw e10.unwrapIOException();
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (hotelBindResp != null) {
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (hotelBindResp != null) {
                        mergeFrom(hotelBindResp);
                    }
                    throw th2;
                }
            }
        }

        public static Builder newBuilder(HotelBindResp hotelBindResp) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(hotelBindResp);
        }

        public static HotelBindResp parseFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, qVar);
        }

        private HotelBindResp(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static HotelBindResp parseDelimitedFrom(InputStream inputStream, q qVar) throws IOException {
            return (HotelBindResp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
        }

        public static HotelBindResp parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
        public HotelBindResp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static HotelBindResp parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder newBuilderForType() {
            return newBuilder();
        }

        private HotelBindResp() {
            this.memoizedIsInitialized = (byte) -1;
            this.hotelBindData_ = Collections.emptyList();
        }

        public static HotelBindResp parseFrom(InputStream inputStream) throws IOException {
            return (HotelBindResp) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.c cVar) {
            return new Builder(cVar);
        }

        public static HotelBindResp parseFrom(InputStream inputStream, q qVar) throws IOException {
            return (HotelBindResp) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
        }

        private HotelBindResp(i iVar, q qVar) throws InvalidProtocolBufferException {
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
                                    this.hotelBindData_ = new ArrayList();
                                    z11 |= true;
                                }
                                this.hotelBindData_.add((HotelBindData) iVar.v(HotelBindData.parser(), qVar));
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
                        this.hotelBindData_ = Collections.unmodifiableList(this.hotelBindData_);
                    }
                    makeExtensionsImmutable();
                }
            }
        }

        public static HotelBindResp parseFrom(i iVar) throws IOException {
            return (HotelBindResp) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
        }

        public static HotelBindResp parseFrom(i iVar, q qVar) throws IOException {
            return (HotelBindResp) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
        }
    }

    /* loaded from: classes2.dex */
    public interface HotelBindRespOrBuilder extends g0 {
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

        HotelBindData getHotelBindData(int i10);

        int getHotelBindDataCount();

        List<HotelBindData> getHotelBindDataList();

        HotelBindDataOrBuilder getHotelBindDataOrBuilder(int i10);

        List<? extends HotelBindDataOrBuilder> getHotelBindDataOrBuilderList();

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
    public static final class TicAssistantRequest extends GeneratedMessageV3 implements TicAssistantRequestOrBuilder {
        public static final int BIND_INFO_FIELD_NUMBER = 1;
        private static final TicAssistantRequest DEFAULT_INSTANCE = new TicAssistantRequest();
        private static final l0<TicAssistantRequest> PARSER = new c<TicAssistantRequest>() { // from class: com.mobvoi.companion.ConstantsProto.TicAssistantRequest.1
            @Override // com.google.protobuf.l0
            public TicAssistantRequest parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
                return new TicAssistantRequest(iVar, qVar);
            }
        };
        public static final int UNBIND_INFO_FIELD_NUMBER = 2;
        public static final int UPDATE_INFO_FIELD_NUMBER = 3;
        private static final long serialVersionUID = 0;
        private byte memoizedIsInitialized;
        private int typeCase_;
        private Object type_;

        /* loaded from: classes2.dex */
        public enum TypeCase implements u.a {
            BIND_INFO(1),
            UNBIND_INFO(2),
            UPDATE_INFO(3),
            TYPE_NOT_SET(0);
            
            private final int value;

            TypeCase(int i10) {
                this.value = i10;
            }

            public static TypeCase forNumber(int i10) {
                if (i10 == 0) {
                    return TYPE_NOT_SET;
                }
                if (i10 == 1) {
                    return BIND_INFO;
                }
                if (i10 == 2) {
                    return UNBIND_INFO;
                }
                if (i10 != 3) {
                    return null;
                }
                return UPDATE_INFO;
            }

            @Override // com.google.protobuf.u.a
            public int getNumber() {
                return this.value;
            }

            @Deprecated
            public static TypeCase valueOf(int i10) {
                return forNumber(i10);
            }
        }

        public static TicAssistantRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return ConstantsProto.internal_static_common_TicAssistantRequest_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static TicAssistantRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (TicAssistantRequest) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static TicAssistantRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static l0<TicAssistantRequest> parser() {
            return PARSER;
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x003d, code lost:
            if (getUpdateInfo().equals(r6.getUpdateInfo()) != false) goto L31;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x004e, code lost:
            if (getUnbindInfo().equals(r6.getUnbindInfo()) != false) goto L31;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x005f, code lost:
            if (getBindInfo().equals(r6.getBindInfo()) != false) goto L31;
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
            if (!(obj instanceof TicAssistantRequest)) {
                return super.equals(obj);
            }
            TicAssistantRequest ticAssistantRequest = (TicAssistantRequest) obj;
            boolean z11 = getTypeCase().equals(ticAssistantRequest.getTypeCase());
            if (!z11) {
                return false;
            }
            int i10 = this.typeCase_;
            if (i10 == 1) {
                if (z11) {
                }
                z10 = false;
                return z10;
            } else if (i10 == 2) {
                if (z11) {
                }
                z10 = false;
                return z10;
            } else if (i10 != 3) {
                return z11;
            } else {
                if (z11) {
                }
                z10 = false;
                return z10;
            }
        }

        @Override // com.mobvoi.companion.ConstantsProto.TicAssistantRequestOrBuilder
        public BindInfo getBindInfo() {
            if (this.typeCase_ == 1) {
                return (BindInfo) this.type_;
            }
            return BindInfo.getDefaultInstance();
        }

        @Override // com.mobvoi.companion.ConstantsProto.TicAssistantRequestOrBuilder
        public BindInfoOrBuilder getBindInfoOrBuilder() {
            if (this.typeCase_ == 1) {
                return (BindInfo) this.type_;
            }
            return BindInfo.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public l0<TicAssistantRequest> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
        public int getSerializedSize() {
            int i10 = this.memoizedSize;
            if (i10 != -1) {
                return i10;
            }
            int i11 = 0;
            if (this.typeCase_ == 1) {
                i11 = 0 + CodedOutputStream.E(1, (BindInfo) this.type_);
            }
            if (this.typeCase_ == 2) {
                i11 += CodedOutputStream.E(2, (UnbindInfo) this.type_);
            }
            if (this.typeCase_ == 3) {
                i11 += CodedOutputStream.E(3, (UpdateInfo) this.type_);
            }
            this.memoizedSize = i11;
            return i11;
        }

        @Override // com.mobvoi.companion.ConstantsProto.TicAssistantRequestOrBuilder
        public TypeCase getTypeCase() {
            return TypeCase.forNumber(this.typeCase_);
        }

        @Override // com.mobvoi.companion.ConstantsProto.TicAssistantRequestOrBuilder
        public UnbindInfo getUnbindInfo() {
            if (this.typeCase_ == 2) {
                return (UnbindInfo) this.type_;
            }
            return UnbindInfo.getDefaultInstance();
        }

        @Override // com.mobvoi.companion.ConstantsProto.TicAssistantRequestOrBuilder
        public UnbindInfoOrBuilder getUnbindInfoOrBuilder() {
            if (this.typeCase_ == 2) {
                return (UnbindInfo) this.type_;
            }
            return UnbindInfo.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.g0
        public final a1 getUnknownFields() {
            return a1.c();
        }

        @Override // com.mobvoi.companion.ConstantsProto.TicAssistantRequestOrBuilder
        public UpdateInfo getUpdateInfo() {
            if (this.typeCase_ == 3) {
                return (UpdateInfo) this.type_;
            }
            return UpdateInfo.getDefaultInstance();
        }

        @Override // com.mobvoi.companion.ConstantsProto.TicAssistantRequestOrBuilder
        public UpdateInfoOrBuilder getUpdateInfoOrBuilder() {
            if (this.typeCase_ == 3) {
                return (UpdateInfo) this.type_;
            }
            return UpdateInfo.getDefaultInstance();
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
            int i13 = this.typeCase_;
            if (i13 == 1) {
                i11 = ((hashCode * 37) + 1) * 53;
                i10 = getBindInfo().hashCode();
            } else if (i13 != 2) {
                if (i13 == 3) {
                    i11 = ((hashCode * 37) + 3) * 53;
                    i10 = getUpdateInfo().hashCode();
                }
                int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
                this.memoizedHashCode = hashCode2;
                return hashCode2;
            } else {
                i11 = ((hashCode * 37) + 2) * 53;
                i10 = getUnbindInfo().hashCode();
            }
            hashCode = i11 + i10;
            int hashCode22 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode22;
            return hashCode22;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return ConstantsProto.internal_static_common_TicAssistantRequest_fieldAccessorTable.e(TicAssistantRequest.class, Builder.class);
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
            if (this.typeCase_ == 1) {
                codedOutputStream.A0(1, (BindInfo) this.type_);
            }
            if (this.typeCase_ == 2) {
                codedOutputStream.A0(2, (UnbindInfo) this.type_);
            }
            if (this.typeCase_ == 3) {
                codedOutputStream.A0(3, (UpdateInfo) this.type_);
            }
        }

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageV3.b<Builder> implements TicAssistantRequestOrBuilder {
            private q0<BindInfo, BindInfo.Builder, BindInfoOrBuilder> bindInfoBuilder_;
            private int typeCase_;
            private Object type_;
            private q0<UnbindInfo, UnbindInfo.Builder, UnbindInfoOrBuilder> unbindInfoBuilder_;
            private q0<UpdateInfo, UpdateInfo.Builder, UpdateInfoOrBuilder> updateInfoBuilder_;

            private q0<BindInfo, BindInfo.Builder, BindInfoOrBuilder> getBindInfoFieldBuilder() {
                if (this.bindInfoBuilder_ == null) {
                    if (this.typeCase_ != 1) {
                        this.type_ = BindInfo.getDefaultInstance();
                    }
                    this.bindInfoBuilder_ = new q0<>((BindInfo) this.type_, getParentForChildren(), isClean());
                    this.type_ = null;
                }
                this.typeCase_ = 1;
                onChanged();
                return this.bindInfoBuilder_;
            }

            public static final Descriptors.b getDescriptor() {
                return ConstantsProto.internal_static_common_TicAssistantRequest_descriptor;
            }

            private q0<UnbindInfo, UnbindInfo.Builder, UnbindInfoOrBuilder> getUnbindInfoFieldBuilder() {
                if (this.unbindInfoBuilder_ == null) {
                    if (this.typeCase_ != 2) {
                        this.type_ = UnbindInfo.getDefaultInstance();
                    }
                    this.unbindInfoBuilder_ = new q0<>((UnbindInfo) this.type_, getParentForChildren(), isClean());
                    this.type_ = null;
                }
                this.typeCase_ = 2;
                onChanged();
                return this.unbindInfoBuilder_;
            }

            private q0<UpdateInfo, UpdateInfo.Builder, UpdateInfoOrBuilder> getUpdateInfoFieldBuilder() {
                if (this.updateInfoBuilder_ == null) {
                    if (this.typeCase_ != 3) {
                        this.type_ = UpdateInfo.getDefaultInstance();
                    }
                    this.updateInfoBuilder_ = new q0<>((UpdateInfo) this.type_, getParentForChildren(), isClean());
                    this.type_ = null;
                }
                this.typeCase_ = 3;
                onChanged();
                return this.updateInfoBuilder_;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            public Builder clearBindInfo() {
                q0<BindInfo, BindInfo.Builder, BindInfoOrBuilder> q0Var = this.bindInfoBuilder_;
                if (q0Var != null) {
                    if (this.typeCase_ == 1) {
                        this.typeCase_ = 0;
                        this.type_ = null;
                    }
                    q0Var.c();
                } else if (this.typeCase_ == 1) {
                    this.typeCase_ = 0;
                    this.type_ = null;
                    onChanged();
                }
                return this;
            }

            public Builder clearType() {
                this.typeCase_ = 0;
                this.type_ = null;
                onChanged();
                return this;
            }

            public Builder clearUnbindInfo() {
                q0<UnbindInfo, UnbindInfo.Builder, UnbindInfoOrBuilder> q0Var = this.unbindInfoBuilder_;
                if (q0Var != null) {
                    if (this.typeCase_ == 2) {
                        this.typeCase_ = 0;
                        this.type_ = null;
                    }
                    q0Var.c();
                } else if (this.typeCase_ == 2) {
                    this.typeCase_ = 0;
                    this.type_ = null;
                    onChanged();
                }
                return this;
            }

            public Builder clearUpdateInfo() {
                q0<UpdateInfo, UpdateInfo.Builder, UpdateInfoOrBuilder> q0Var = this.updateInfoBuilder_;
                if (q0Var != null) {
                    if (this.typeCase_ == 3) {
                        this.typeCase_ = 0;
                        this.type_ = null;
                    }
                    q0Var.c();
                } else if (this.typeCase_ == 3) {
                    this.typeCase_ = 0;
                    this.type_ = null;
                    onChanged();
                }
                return this;
            }

            @Override // com.mobvoi.companion.ConstantsProto.TicAssistantRequestOrBuilder
            public BindInfo getBindInfo() {
                q0<BindInfo, BindInfo.Builder, BindInfoOrBuilder> q0Var = this.bindInfoBuilder_;
                if (q0Var == null) {
                    if (this.typeCase_ == 1) {
                        return (BindInfo) this.type_;
                    }
                    return BindInfo.getDefaultInstance();
                } else if (this.typeCase_ == 1) {
                    return q0Var.f();
                } else {
                    return BindInfo.getDefaultInstance();
                }
            }

            public BindInfo.Builder getBindInfoBuilder() {
                return getBindInfoFieldBuilder().e();
            }

            @Override // com.mobvoi.companion.ConstantsProto.TicAssistantRequestOrBuilder
            public BindInfoOrBuilder getBindInfoOrBuilder() {
                q0<BindInfo, BindInfo.Builder, BindInfoOrBuilder> q0Var;
                int i10 = this.typeCase_;
                if (i10 == 1 && (q0Var = this.bindInfoBuilder_) != null) {
                    return q0Var.g();
                }
                if (i10 == 1) {
                    return (BindInfo) this.type_;
                }
                return BindInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a, com.google.protobuf.g0
            public Descriptors.b getDescriptorForType() {
                return ConstantsProto.internal_static_common_TicAssistantRequest_descriptor;
            }

            @Override // com.mobvoi.companion.ConstantsProto.TicAssistantRequestOrBuilder
            public TypeCase getTypeCase() {
                return TypeCase.forNumber(this.typeCase_);
            }

            @Override // com.mobvoi.companion.ConstantsProto.TicAssistantRequestOrBuilder
            public UnbindInfo getUnbindInfo() {
                q0<UnbindInfo, UnbindInfo.Builder, UnbindInfoOrBuilder> q0Var = this.unbindInfoBuilder_;
                if (q0Var == null) {
                    if (this.typeCase_ == 2) {
                        return (UnbindInfo) this.type_;
                    }
                    return UnbindInfo.getDefaultInstance();
                } else if (this.typeCase_ == 2) {
                    return q0Var.f();
                } else {
                    return UnbindInfo.getDefaultInstance();
                }
            }

            public UnbindInfo.Builder getUnbindInfoBuilder() {
                return getUnbindInfoFieldBuilder().e();
            }

            @Override // com.mobvoi.companion.ConstantsProto.TicAssistantRequestOrBuilder
            public UnbindInfoOrBuilder getUnbindInfoOrBuilder() {
                q0<UnbindInfo, UnbindInfo.Builder, UnbindInfoOrBuilder> q0Var;
                int i10 = this.typeCase_;
                if (i10 == 2 && (q0Var = this.unbindInfoBuilder_) != null) {
                    return q0Var.g();
                }
                if (i10 == 2) {
                    return (UnbindInfo) this.type_;
                }
                return UnbindInfo.getDefaultInstance();
            }

            @Override // com.mobvoi.companion.ConstantsProto.TicAssistantRequestOrBuilder
            public UpdateInfo getUpdateInfo() {
                q0<UpdateInfo, UpdateInfo.Builder, UpdateInfoOrBuilder> q0Var = this.updateInfoBuilder_;
                if (q0Var == null) {
                    if (this.typeCase_ == 3) {
                        return (UpdateInfo) this.type_;
                    }
                    return UpdateInfo.getDefaultInstance();
                } else if (this.typeCase_ == 3) {
                    return q0Var.f();
                } else {
                    return UpdateInfo.getDefaultInstance();
                }
            }

            public UpdateInfo.Builder getUpdateInfoBuilder() {
                return getUpdateInfoFieldBuilder().e();
            }

            @Override // com.mobvoi.companion.ConstantsProto.TicAssistantRequestOrBuilder
            public UpdateInfoOrBuilder getUpdateInfoOrBuilder() {
                q0<UpdateInfo, UpdateInfo.Builder, UpdateInfoOrBuilder> q0Var;
                int i10 = this.typeCase_;
                if (i10 == 3 && (q0Var = this.updateInfoBuilder_) != null) {
                    return q0Var.g();
                }
                if (i10 == 3) {
                    return (UpdateInfo) this.type_;
                }
                return UpdateInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return ConstantsProto.internal_static_common_TicAssistantRequest_fieldAccessorTable.e(TicAssistantRequest.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.f0
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeBindInfo(BindInfo bindInfo) {
                q0<BindInfo, BindInfo.Builder, BindInfoOrBuilder> q0Var = this.bindInfoBuilder_;
                if (q0Var == null) {
                    if (this.typeCase_ != 1 || this.type_ == BindInfo.getDefaultInstance()) {
                        this.type_ = bindInfo;
                    } else {
                        this.type_ = BindInfo.newBuilder((BindInfo) this.type_).mergeFrom(bindInfo).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.typeCase_ == 1) {
                        q0Var.h(bindInfo);
                    }
                    this.bindInfoBuilder_.j(bindInfo);
                }
                this.typeCase_ = 1;
                return this;
            }

            public Builder mergeUnbindInfo(UnbindInfo unbindInfo) {
                q0<UnbindInfo, UnbindInfo.Builder, UnbindInfoOrBuilder> q0Var = this.unbindInfoBuilder_;
                if (q0Var == null) {
                    if (this.typeCase_ != 2 || this.type_ == UnbindInfo.getDefaultInstance()) {
                        this.type_ = unbindInfo;
                    } else {
                        this.type_ = UnbindInfo.newBuilder((UnbindInfo) this.type_).mergeFrom(unbindInfo).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.typeCase_ == 2) {
                        q0Var.h(unbindInfo);
                    }
                    this.unbindInfoBuilder_.j(unbindInfo);
                }
                this.typeCase_ = 2;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a
            public final Builder mergeUnknownFields(a1 a1Var) {
                return this;
            }

            public Builder mergeUpdateInfo(UpdateInfo updateInfo) {
                q0<UpdateInfo, UpdateInfo.Builder, UpdateInfoOrBuilder> q0Var = this.updateInfoBuilder_;
                if (q0Var == null) {
                    if (this.typeCase_ != 3 || this.type_ == UpdateInfo.getDefaultInstance()) {
                        this.type_ = updateInfo;
                    } else {
                        this.type_ = UpdateInfo.newBuilder((UpdateInfo) this.type_).mergeFrom(updateInfo).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.typeCase_ == 3) {
                        q0Var.h(updateInfo);
                    }
                    this.updateInfoBuilder_.j(updateInfo);
                }
                this.typeCase_ = 3;
                return this;
            }

            public Builder setBindInfo(BindInfo bindInfo) {
                q0<BindInfo, BindInfo.Builder, BindInfoOrBuilder> q0Var = this.bindInfoBuilder_;
                if (q0Var == null) {
                    Objects.requireNonNull(bindInfo);
                    this.type_ = bindInfo;
                    onChanged();
                } else {
                    q0Var.j(bindInfo);
                }
                this.typeCase_ = 1;
                return this;
            }

            public Builder setUnbindInfo(UnbindInfo unbindInfo) {
                q0<UnbindInfo, UnbindInfo.Builder, UnbindInfoOrBuilder> q0Var = this.unbindInfoBuilder_;
                if (q0Var == null) {
                    Objects.requireNonNull(unbindInfo);
                    this.type_ = unbindInfo;
                    onChanged();
                } else {
                    q0Var.j(unbindInfo);
                }
                this.typeCase_ = 2;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public final Builder setUnknownFields(a1 a1Var) {
                return this;
            }

            public Builder setUpdateInfo(UpdateInfo updateInfo) {
                q0<UpdateInfo, UpdateInfo.Builder, UpdateInfoOrBuilder> q0Var = this.updateInfoBuilder_;
                if (q0Var == null) {
                    Objects.requireNonNull(updateInfo);
                    this.type_ = updateInfo;
                    onChanged();
                } else {
                    q0Var.j(updateInfo);
                }
                this.typeCase_ = 3;
                return this;
            }

            private Builder() {
                this.typeCase_ = 0;
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.e0.a, com.google.protobuf.d0.a
            public TicAssistantRequest build() {
                TicAssistantRequest buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) buildPartial);
            }

            @Override // com.google.protobuf.e0.a, com.google.protobuf.d0.a
            public TicAssistantRequest buildPartial() {
                TicAssistantRequest ticAssistantRequest = new TicAssistantRequest(this);
                if (this.typeCase_ == 1) {
                    q0<BindInfo, BindInfo.Builder, BindInfoOrBuilder> q0Var = this.bindInfoBuilder_;
                    if (q0Var == null) {
                        ticAssistantRequest.type_ = this.type_;
                    } else {
                        ticAssistantRequest.type_ = q0Var.b();
                    }
                }
                if (this.typeCase_ == 2) {
                    q0<UnbindInfo, UnbindInfo.Builder, UnbindInfoOrBuilder> q0Var2 = this.unbindInfoBuilder_;
                    if (q0Var2 == null) {
                        ticAssistantRequest.type_ = this.type_;
                    } else {
                        ticAssistantRequest.type_ = q0Var2.b();
                    }
                }
                if (this.typeCase_ == 3) {
                    q0<UpdateInfo, UpdateInfo.Builder, UpdateInfoOrBuilder> q0Var3 = this.updateInfoBuilder_;
                    if (q0Var3 == null) {
                        ticAssistantRequest.type_ = this.type_;
                    } else {
                        ticAssistantRequest.type_ = q0Var3.b();
                    }
                }
                ticAssistantRequest.typeCase_ = this.typeCase_;
                onBuilt();
                return ticAssistantRequest;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.f0, com.google.protobuf.g0
            public TicAssistantRequest getDefaultInstanceForType() {
                return TicAssistantRequest.getDefaultInstance();
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
                this.typeCase_ = 0;
                this.type_ = null;
                return this;
            }

            private Builder(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.typeCase_ = 0;
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a, com.google.protobuf.b.a
            public Builder clone() {
                return (Builder) super.clone();
            }

            @Override // com.google.protobuf.a.AbstractC0170a, com.google.protobuf.d0.a
            public Builder mergeFrom(d0 d0Var) {
                if (d0Var instanceof TicAssistantRequest) {
                    return mergeFrom((TicAssistantRequest) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            public Builder setBindInfo(BindInfo.Builder builder) {
                q0<BindInfo, BindInfo.Builder, BindInfoOrBuilder> q0Var = this.bindInfoBuilder_;
                if (q0Var == null) {
                    this.type_ = builder.build();
                    onChanged();
                } else {
                    q0Var.j(builder.build());
                }
                this.typeCase_ = 1;
                return this;
            }

            public Builder setUnbindInfo(UnbindInfo.Builder builder) {
                q0<UnbindInfo, UnbindInfo.Builder, UnbindInfoOrBuilder> q0Var = this.unbindInfoBuilder_;
                if (q0Var == null) {
                    this.type_ = builder.build();
                    onChanged();
                } else {
                    q0Var.j(builder.build());
                }
                this.typeCase_ = 2;
                return this;
            }

            public Builder setUpdateInfo(UpdateInfo.Builder builder) {
                q0<UpdateInfo, UpdateInfo.Builder, UpdateInfoOrBuilder> q0Var = this.updateInfoBuilder_;
                if (q0Var == null) {
                    this.type_ = builder.build();
                    onChanged();
                } else {
                    q0Var.j(builder.build());
                }
                this.typeCase_ = 3;
                return this;
            }

            public Builder mergeFrom(TicAssistantRequest ticAssistantRequest) {
                if (ticAssistantRequest == TicAssistantRequest.getDefaultInstance()) {
                    return this;
                }
                int i10 = AnonymousClass2.$SwitchMap$com$mobvoi$companion$ConstantsProto$TicAssistantRequest$TypeCase[ticAssistantRequest.getTypeCase().ordinal()];
                if (i10 == 1) {
                    mergeBindInfo(ticAssistantRequest.getBindInfo());
                } else if (i10 == 2) {
                    mergeUnbindInfo(ticAssistantRequest.getUnbindInfo());
                } else if (i10 == 3) {
                    mergeUpdateInfo(ticAssistantRequest.getUpdateInfo());
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
                TicAssistantRequest ticAssistantRequest = null;
                try {
                    try {
                        TicAssistantRequest ticAssistantRequest2 = (TicAssistantRequest) TicAssistantRequest.PARSER.parsePartialFrom(iVar, qVar);
                        if (ticAssistantRequest2 != null) {
                            mergeFrom(ticAssistantRequest2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e10) {
                        ticAssistantRequest = (TicAssistantRequest) e10.getUnfinishedMessage();
                        try {
                            throw e10.unwrapIOException();
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (ticAssistantRequest != null) {
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (ticAssistantRequest != null) {
                        mergeFrom(ticAssistantRequest);
                    }
                    throw th2;
                }
            }
        }

        public static Builder newBuilder(TicAssistantRequest ticAssistantRequest) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(ticAssistantRequest);
        }

        public static TicAssistantRequest parseFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, qVar);
        }

        private TicAssistantRequest(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.typeCase_ = 0;
            this.memoizedIsInitialized = (byte) -1;
        }

        public static TicAssistantRequest parseDelimitedFrom(InputStream inputStream, q qVar) throws IOException {
            return (TicAssistantRequest) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
        }

        public static TicAssistantRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
        public TicAssistantRequest getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static TicAssistantRequest parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static TicAssistantRequest parseFrom(InputStream inputStream) throws IOException {
            return (TicAssistantRequest) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.c cVar) {
            return new Builder(cVar);
        }

        private TicAssistantRequest() {
            this.typeCase_ = 0;
            this.memoizedIsInitialized = (byte) -1;
        }

        public static TicAssistantRequest parseFrom(InputStream inputStream, q qVar) throws IOException {
            return (TicAssistantRequest) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
        }

        private TicAssistantRequest(i iVar, q qVar) throws InvalidProtocolBufferException {
            this();
            boolean z10 = false;
            while (!z10) {
                try {
                    try {
                        int F = iVar.F();
                        if (F != 0) {
                            UpdateInfo.Builder builder = null;
                            BindInfo.Builder builder2 = null;
                            UnbindInfo.Builder builder3 = null;
                            if (F == 10) {
                                builder2 = this.typeCase_ == 1 ? ((BindInfo) this.type_).toBuilder() : builder2;
                                e0 v10 = iVar.v(BindInfo.parser(), qVar);
                                this.type_ = v10;
                                if (builder2 != null) {
                                    builder2.mergeFrom((BindInfo) v10);
                                    this.type_ = builder2.buildPartial();
                                }
                                this.typeCase_ = 1;
                            } else if (F == 18) {
                                builder3 = this.typeCase_ == 2 ? ((UnbindInfo) this.type_).toBuilder() : builder3;
                                e0 v11 = iVar.v(UnbindInfo.parser(), qVar);
                                this.type_ = v11;
                                if (builder3 != null) {
                                    builder3.mergeFrom((UnbindInfo) v11);
                                    this.type_ = builder3.buildPartial();
                                }
                                this.typeCase_ = 2;
                            } else if (F == 26) {
                                builder = this.typeCase_ == 3 ? ((UpdateInfo) this.type_).toBuilder() : builder;
                                e0 v12 = iVar.v(UpdateInfo.parser(), qVar);
                                this.type_ = v12;
                                if (builder != null) {
                                    builder.mergeFrom((UpdateInfo) v12);
                                    this.type_ = builder.buildPartial();
                                }
                                this.typeCase_ = 3;
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
                    makeExtensionsImmutable();
                }
            }
        }

        public static TicAssistantRequest parseFrom(i iVar) throws IOException {
            return (TicAssistantRequest) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
        }

        public static TicAssistantRequest parseFrom(i iVar, q qVar) throws IOException {
            return (TicAssistantRequest) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
        }
    }

    /* loaded from: classes2.dex */
    public interface TicAssistantRequestOrBuilder extends g0 {
        /* synthetic */ List<String> findInitializationErrors();

        @Override // com.google.protobuf.g0
        /* synthetic */ Map<Descriptors.FieldDescriptor, Object> getAllFields();

        BindInfo getBindInfo();

        BindInfoOrBuilder getBindInfoOrBuilder();

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

        /* synthetic */ Object getRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i10);

        /* synthetic */ int getRepeatedFieldCount(Descriptors.FieldDescriptor fieldDescriptor);

        TicAssistantRequest.TypeCase getTypeCase();

        UnbindInfo getUnbindInfo();

        UnbindInfoOrBuilder getUnbindInfoOrBuilder();

        @Override // com.google.protobuf.g0
        /* synthetic */ a1 getUnknownFields();

        UpdateInfo getUpdateInfo();

        UpdateInfoOrBuilder getUpdateInfoOrBuilder();

        @Override // com.google.protobuf.g0
        /* synthetic */ boolean hasField(Descriptors.FieldDescriptor fieldDescriptor);

        /* synthetic */ boolean hasOneof(Descriptors.h hVar);

        @Override // com.google.protobuf.f0
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes2.dex */
    public static final class TicAssistantResponse extends GeneratedMessageV3 implements TicAssistantResponseOrBuilder {
        public static final int ERR_CODE_FIELD_NUMBER = 2;
        public static final int ERR_MSG_FIELD_NUMBER = 3;
        public static final int OK_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private int errCode_;
        private volatile Object errMsg_;
        private byte memoizedIsInitialized;
        private boolean ok_;
        private static final TicAssistantResponse DEFAULT_INSTANCE = new TicAssistantResponse();
        private static final l0<TicAssistantResponse> PARSER = new c<TicAssistantResponse>() { // from class: com.mobvoi.companion.ConstantsProto.TicAssistantResponse.1
            @Override // com.google.protobuf.l0
            public TicAssistantResponse parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
                return new TicAssistantResponse(iVar, qVar);
            }
        };

        public static TicAssistantResponse getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return ConstantsProto.internal_static_common_TicAssistantResponse_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static TicAssistantResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (TicAssistantResponse) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static TicAssistantResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static l0<TicAssistantResponse> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof TicAssistantResponse)) {
                return super.equals(obj);
            }
            TicAssistantResponse ticAssistantResponse = (TicAssistantResponse) obj;
            return ((getOk() == ticAssistantResponse.getOk()) && getErrCode() == ticAssistantResponse.getErrCode()) && getErrMsg().equals(ticAssistantResponse.getErrMsg());
        }

        @Override // com.mobvoi.companion.ConstantsProto.TicAssistantResponseOrBuilder
        public int getErrCode() {
            return this.errCode_;
        }

        @Override // com.mobvoi.companion.ConstantsProto.TicAssistantResponseOrBuilder
        public String getErrMsg() {
            Object obj = this.errMsg_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.errMsg_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.ConstantsProto.TicAssistantResponseOrBuilder
        public ByteString getErrMsgBytes() {
            Object obj = this.errMsg_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.errMsg_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.mobvoi.companion.ConstantsProto.TicAssistantResponseOrBuilder
        public boolean getOk() {
            return this.ok_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public l0<TicAssistantResponse> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
        public int getSerializedSize() {
            int i10 = this.memoizedSize;
            if (i10 != -1) {
                return i10;
            }
            int i11 = 0;
            boolean z10 = this.ok_;
            if (z10) {
                i11 = 0 + CodedOutputStream.e(1, z10);
            }
            int i12 = this.errCode_;
            if (i12 != 0) {
                i11 += CodedOutputStream.v(2, i12);
            }
            if (!getErrMsgBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(3, this.errMsg_);
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
            int hashCode = ((((((((((((((779 + getDescriptorForType().hashCode()) * 37) + 1) * 53) + u.c(getOk())) * 37) + 2) * 53) + getErrCode()) * 37) + 3) * 53) + getErrMsg().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return ConstantsProto.internal_static_common_TicAssistantResponse_fieldAccessorTable.e(TicAssistantResponse.class, Builder.class);
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
            boolean z10 = this.ok_;
            if (z10) {
                codedOutputStream.e0(1, z10);
            }
            int i10 = this.errCode_;
            if (i10 != 0) {
                codedOutputStream.w0(2, i10);
            }
            if (!getErrMsgBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 3, this.errMsg_);
            }
        }

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageV3.b<Builder> implements TicAssistantResponseOrBuilder {
            private int errCode_;
            private Object errMsg_;
            private boolean ok_;

            public static final Descriptors.b getDescriptor() {
                return ConstantsProto.internal_static_common_TicAssistantResponse_descriptor;
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
                this.errMsg_ = TicAssistantResponse.getDefaultInstance().getErrMsg();
                onChanged();
                return this;
            }

            public Builder clearOk() {
                this.ok_ = false;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a, com.google.protobuf.g0
            public Descriptors.b getDescriptorForType() {
                return ConstantsProto.internal_static_common_TicAssistantResponse_descriptor;
            }

            @Override // com.mobvoi.companion.ConstantsProto.TicAssistantResponseOrBuilder
            public int getErrCode() {
                return this.errCode_;
            }

            @Override // com.mobvoi.companion.ConstantsProto.TicAssistantResponseOrBuilder
            public String getErrMsg() {
                Object obj = this.errMsg_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.errMsg_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.ConstantsProto.TicAssistantResponseOrBuilder
            public ByteString getErrMsgBytes() {
                Object obj = this.errMsg_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.errMsg_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.mobvoi.companion.ConstantsProto.TicAssistantResponseOrBuilder
            public boolean getOk() {
                return this.ok_;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return ConstantsProto.internal_static_common_TicAssistantResponse_fieldAccessorTable.e(TicAssistantResponse.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.f0
            public final boolean isInitialized() {
                return true;
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

            public Builder setOk(boolean z10) {
                this.ok_ = z10;
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
            public TicAssistantResponse build() {
                TicAssistantResponse buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) buildPartial);
            }

            @Override // com.google.protobuf.e0.a, com.google.protobuf.d0.a
            public TicAssistantResponse buildPartial() {
                TicAssistantResponse ticAssistantResponse = new TicAssistantResponse(this);
                ticAssistantResponse.ok_ = this.ok_;
                ticAssistantResponse.errCode_ = this.errCode_;
                ticAssistantResponse.errMsg_ = this.errMsg_;
                onBuilt();
                return ticAssistantResponse;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.f0, com.google.protobuf.g0
            public TicAssistantResponse getDefaultInstanceForType() {
                return TicAssistantResponse.getDefaultInstance();
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
                this.ok_ = false;
                this.errCode_ = 0;
                this.errMsg_ = "";
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
                if (d0Var instanceof TicAssistantResponse) {
                    return mergeFrom((TicAssistantResponse) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            public Builder mergeFrom(TicAssistantResponse ticAssistantResponse) {
                if (ticAssistantResponse == TicAssistantResponse.getDefaultInstance()) {
                    return this;
                }
                if (ticAssistantResponse.getOk()) {
                    setOk(ticAssistantResponse.getOk());
                }
                if (ticAssistantResponse.getErrCode() != 0) {
                    setErrCode(ticAssistantResponse.getErrCode());
                }
                if (!ticAssistantResponse.getErrMsg().isEmpty()) {
                    this.errMsg_ = ticAssistantResponse.errMsg_;
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
                TicAssistantResponse ticAssistantResponse = null;
                try {
                    try {
                        TicAssistantResponse ticAssistantResponse2 = (TicAssistantResponse) TicAssistantResponse.PARSER.parsePartialFrom(iVar, qVar);
                        if (ticAssistantResponse2 != null) {
                            mergeFrom(ticAssistantResponse2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e10) {
                        ticAssistantResponse = (TicAssistantResponse) e10.getUnfinishedMessage();
                        try {
                            throw e10.unwrapIOException();
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (ticAssistantResponse != null) {
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (ticAssistantResponse != null) {
                        mergeFrom(ticAssistantResponse);
                    }
                    throw th2;
                }
            }
        }

        public static Builder newBuilder(TicAssistantResponse ticAssistantResponse) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(ticAssistantResponse);
        }

        public static TicAssistantResponse parseFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, qVar);
        }

        private TicAssistantResponse(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static TicAssistantResponse parseDelimitedFrom(InputStream inputStream, q qVar) throws IOException {
            return (TicAssistantResponse) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
        }

        public static TicAssistantResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
        public TicAssistantResponse getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static TicAssistantResponse parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder newBuilderForType() {
            return newBuilder();
        }

        private TicAssistantResponse() {
            this.memoizedIsInitialized = (byte) -1;
            this.ok_ = false;
            this.errCode_ = 0;
            this.errMsg_ = "";
        }

        public static TicAssistantResponse parseFrom(InputStream inputStream) throws IOException {
            return (TicAssistantResponse) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.c cVar) {
            return new Builder(cVar);
        }

        public static TicAssistantResponse parseFrom(InputStream inputStream, q qVar) throws IOException {
            return (TicAssistantResponse) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
        }

        public static TicAssistantResponse parseFrom(i iVar) throws IOException {
            return (TicAssistantResponse) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
        }

        private TicAssistantResponse(i iVar, q qVar) throws InvalidProtocolBufferException {
            this();
            boolean z10 = false;
            while (!z10) {
                try {
                    try {
                        int F = iVar.F();
                        z10 = true;
                        if (F != 0) {
                            if (F == 8) {
                                this.ok_ = iVar.l();
                            } else if (F == 16) {
                                this.errCode_ = iVar.t();
                            } else if (F == 26) {
                                this.errMsg_ = iVar.E();
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

        public static TicAssistantResponse parseFrom(i iVar, q qVar) throws IOException {
            return (TicAssistantResponse) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
        }
    }

    /* loaded from: classes2.dex */
    public interface TicAssistantResponseOrBuilder extends g0 {
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

        boolean getOk();

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
    public static final class UnbindInfo extends GeneratedMessageV3 implements UnbindInfoOrBuilder {
        public static final int DEVICE_ID_FIELD_NUMBER = 1;
        public static final int WWID_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private volatile Object deviceId_;
        private byte memoizedIsInitialized;
        private volatile Object wwid_;
        private static final UnbindInfo DEFAULT_INSTANCE = new UnbindInfo();
        private static final l0<UnbindInfo> PARSER = new c<UnbindInfo>() { // from class: com.mobvoi.companion.ConstantsProto.UnbindInfo.1
            @Override // com.google.protobuf.l0
            public UnbindInfo parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
                return new UnbindInfo(iVar, qVar);
            }
        };

        public static UnbindInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return ConstantsProto.internal_static_common_UnbindInfo_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static UnbindInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (UnbindInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static UnbindInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static l0<UnbindInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof UnbindInfo)) {
                return super.equals(obj);
            }
            UnbindInfo unbindInfo = (UnbindInfo) obj;
            return (getDeviceId().equals(unbindInfo.getDeviceId())) && getWwid().equals(unbindInfo.getWwid());
        }

        @Override // com.mobvoi.companion.ConstantsProto.UnbindInfoOrBuilder
        public String getDeviceId() {
            Object obj = this.deviceId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.deviceId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.ConstantsProto.UnbindInfoOrBuilder
        public ByteString getDeviceIdBytes() {
            Object obj = this.deviceId_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.deviceId_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public l0<UnbindInfo> getParserForType() {
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
            if (!getWwidBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(2, this.wwid_);
            }
            this.memoizedSize = i11;
            return i11;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.g0
        public final a1 getUnknownFields() {
            return a1.c();
        }

        @Override // com.mobvoi.companion.ConstantsProto.UnbindInfoOrBuilder
        public String getWwid() {
            Object obj = this.wwid_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.wwid_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.ConstantsProto.UnbindInfoOrBuilder
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
            int hashCode = ((((((((((779 + getDescriptorForType().hashCode()) * 37) + 1) * 53) + getDeviceId().hashCode()) * 37) + 2) * 53) + getWwid().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return ConstantsProto.internal_static_common_UnbindInfo_fieldAccessorTable.e(UnbindInfo.class, Builder.class);
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
            if (!getWwidBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.wwid_);
            }
        }

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageV3.b<Builder> implements UnbindInfoOrBuilder {
            private Object deviceId_;
            private Object wwid_;

            public static final Descriptors.b getDescriptor() {
                return ConstantsProto.internal_static_common_UnbindInfo_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            public Builder clearDeviceId() {
                this.deviceId_ = UnbindInfo.getDefaultInstance().getDeviceId();
                onChanged();
                return this;
            }

            public Builder clearWwid() {
                this.wwid_ = UnbindInfo.getDefaultInstance().getWwid();
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a, com.google.protobuf.g0
            public Descriptors.b getDescriptorForType() {
                return ConstantsProto.internal_static_common_UnbindInfo_descriptor;
            }

            @Override // com.mobvoi.companion.ConstantsProto.UnbindInfoOrBuilder
            public String getDeviceId() {
                Object obj = this.deviceId_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.deviceId_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.ConstantsProto.UnbindInfoOrBuilder
            public ByteString getDeviceIdBytes() {
                Object obj = this.deviceId_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.deviceId_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.mobvoi.companion.ConstantsProto.UnbindInfoOrBuilder
            public String getWwid() {
                Object obj = this.wwid_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.wwid_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.ConstantsProto.UnbindInfoOrBuilder
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
                return ConstantsProto.internal_static_common_UnbindInfo_fieldAccessorTable.e(UnbindInfo.class, Builder.class);
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
                this.deviceId_ = "";
                this.wwid_ = "";
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.e0.a, com.google.protobuf.d0.a
            public UnbindInfo build() {
                UnbindInfo buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) buildPartial);
            }

            @Override // com.google.protobuf.e0.a, com.google.protobuf.d0.a
            public UnbindInfo buildPartial() {
                UnbindInfo unbindInfo = new UnbindInfo(this);
                unbindInfo.deviceId_ = this.deviceId_;
                unbindInfo.wwid_ = this.wwid_;
                onBuilt();
                return unbindInfo;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.f0, com.google.protobuf.g0
            public UnbindInfo getDefaultInstanceForType() {
                return UnbindInfo.getDefaultInstance();
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
                this.wwid_ = "";
                return this;
            }

            private Builder(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.deviceId_ = "";
                this.wwid_ = "";
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a, com.google.protobuf.b.a
            public Builder clone() {
                return (Builder) super.clone();
            }

            @Override // com.google.protobuf.a.AbstractC0170a, com.google.protobuf.d0.a
            public Builder mergeFrom(d0 d0Var) {
                if (d0Var instanceof UnbindInfo) {
                    return mergeFrom((UnbindInfo) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            public Builder mergeFrom(UnbindInfo unbindInfo) {
                if (unbindInfo == UnbindInfo.getDefaultInstance()) {
                    return this;
                }
                if (!unbindInfo.getDeviceId().isEmpty()) {
                    this.deviceId_ = unbindInfo.deviceId_;
                    onChanged();
                }
                if (!unbindInfo.getWwid().isEmpty()) {
                    this.wwid_ = unbindInfo.wwid_;
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
                UnbindInfo unbindInfo = null;
                try {
                    try {
                        UnbindInfo unbindInfo2 = (UnbindInfo) UnbindInfo.PARSER.parsePartialFrom(iVar, qVar);
                        if (unbindInfo2 != null) {
                            mergeFrom(unbindInfo2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e10) {
                        unbindInfo = (UnbindInfo) e10.getUnfinishedMessage();
                        try {
                            throw e10.unwrapIOException();
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (unbindInfo != null) {
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (unbindInfo != null) {
                        mergeFrom(unbindInfo);
                    }
                    throw th2;
                }
            }
        }

        public static Builder newBuilder(UnbindInfo unbindInfo) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(unbindInfo);
        }

        public static UnbindInfo parseFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, qVar);
        }

        private UnbindInfo(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static UnbindInfo parseDelimitedFrom(InputStream inputStream, q qVar) throws IOException {
            return (UnbindInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
        }

        public static UnbindInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
        public UnbindInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static UnbindInfo parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder newBuilderForType() {
            return newBuilder();
        }

        private UnbindInfo() {
            this.memoizedIsInitialized = (byte) -1;
            this.deviceId_ = "";
            this.wwid_ = "";
        }

        public static UnbindInfo parseFrom(InputStream inputStream) throws IOException {
            return (UnbindInfo) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.c cVar) {
            return new Builder(cVar);
        }

        public static UnbindInfo parseFrom(InputStream inputStream, q qVar) throws IOException {
            return (UnbindInfo) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
        }

        private UnbindInfo(i iVar, q qVar) throws InvalidProtocolBufferException {
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
                                    this.wwid_ = iVar.E();
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

        public static UnbindInfo parseFrom(i iVar) throws IOException {
            return (UnbindInfo) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
        }

        public static UnbindInfo parseFrom(i iVar, q qVar) throws IOException {
            return (UnbindInfo) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
        }
    }

    /* loaded from: classes2.dex */
    public interface UnbindInfoOrBuilder extends g0 {
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

        @Override // com.google.protobuf.g0
        /* synthetic */ Object getField(Descriptors.FieldDescriptor fieldDescriptor);

        /* synthetic */ String getInitializationErrorString();

        /* synthetic */ Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.h hVar);

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
    public static final class UpdateInfo extends GeneratedMessageV3 implements UpdateInfoOrBuilder {
        public static final int DEVICE_ID_FIELD_NUMBER = 1;
        public static final int DEVICE_NAME_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private volatile Object deviceId_;
        private volatile Object deviceName_;
        private byte memoizedIsInitialized;
        private static final UpdateInfo DEFAULT_INSTANCE = new UpdateInfo();
        private static final l0<UpdateInfo> PARSER = new c<UpdateInfo>() { // from class: com.mobvoi.companion.ConstantsProto.UpdateInfo.1
            @Override // com.google.protobuf.l0
            public UpdateInfo parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
                return new UpdateInfo(iVar, qVar);
            }
        };

        public static UpdateInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return ConstantsProto.internal_static_common_UpdateInfo_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static UpdateInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (UpdateInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static UpdateInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static l0<UpdateInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof UpdateInfo)) {
                return super.equals(obj);
            }
            UpdateInfo updateInfo = (UpdateInfo) obj;
            return (getDeviceId().equals(updateInfo.getDeviceId())) && getDeviceName().equals(updateInfo.getDeviceName());
        }

        @Override // com.mobvoi.companion.ConstantsProto.UpdateInfoOrBuilder
        public String getDeviceId() {
            Object obj = this.deviceId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.deviceId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.ConstantsProto.UpdateInfoOrBuilder
        public ByteString getDeviceIdBytes() {
            Object obj = this.deviceId_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.deviceId_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.mobvoi.companion.ConstantsProto.UpdateInfoOrBuilder
        public String getDeviceName() {
            Object obj = this.deviceName_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.deviceName_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.ConstantsProto.UpdateInfoOrBuilder
        public ByteString getDeviceNameBytes() {
            Object obj = this.deviceName_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.deviceName_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public l0<UpdateInfo> getParserForType() {
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
            int hashCode = ((((((((((779 + getDescriptorForType().hashCode()) * 37) + 1) * 53) + getDeviceId().hashCode()) * 37) + 2) * 53) + getDeviceName().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return ConstantsProto.internal_static_common_UpdateInfo_fieldAccessorTable.e(UpdateInfo.class, Builder.class);
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
        }

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageV3.b<Builder> implements UpdateInfoOrBuilder {
            private Object deviceId_;
            private Object deviceName_;

            public static final Descriptors.b getDescriptor() {
                return ConstantsProto.internal_static_common_UpdateInfo_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            public Builder clearDeviceId() {
                this.deviceId_ = UpdateInfo.getDefaultInstance().getDeviceId();
                onChanged();
                return this;
            }

            public Builder clearDeviceName() {
                this.deviceName_ = UpdateInfo.getDefaultInstance().getDeviceName();
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a, com.google.protobuf.g0
            public Descriptors.b getDescriptorForType() {
                return ConstantsProto.internal_static_common_UpdateInfo_descriptor;
            }

            @Override // com.mobvoi.companion.ConstantsProto.UpdateInfoOrBuilder
            public String getDeviceId() {
                Object obj = this.deviceId_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.deviceId_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.ConstantsProto.UpdateInfoOrBuilder
            public ByteString getDeviceIdBytes() {
                Object obj = this.deviceId_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.deviceId_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.mobvoi.companion.ConstantsProto.UpdateInfoOrBuilder
            public String getDeviceName() {
                Object obj = this.deviceName_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.deviceName_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.ConstantsProto.UpdateInfoOrBuilder
            public ByteString getDeviceNameBytes() {
                Object obj = this.deviceName_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.deviceName_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return ConstantsProto.internal_static_common_UpdateInfo_fieldAccessorTable.e(UpdateInfo.class, Builder.class);
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

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public final Builder setUnknownFields(a1 a1Var) {
                return this;
            }

            private Builder() {
                this.deviceId_ = "";
                this.deviceName_ = "";
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.e0.a, com.google.protobuf.d0.a
            public UpdateInfo build() {
                UpdateInfo buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) buildPartial);
            }

            @Override // com.google.protobuf.e0.a, com.google.protobuf.d0.a
            public UpdateInfo buildPartial() {
                UpdateInfo updateInfo = new UpdateInfo(this);
                updateInfo.deviceId_ = this.deviceId_;
                updateInfo.deviceName_ = this.deviceName_;
                onBuilt();
                return updateInfo;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.f0, com.google.protobuf.g0
            public UpdateInfo getDefaultInstanceForType() {
                return UpdateInfo.getDefaultInstance();
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
                return this;
            }

            private Builder(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.deviceId_ = "";
                this.deviceName_ = "";
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a, com.google.protobuf.b.a
            public Builder clone() {
                return (Builder) super.clone();
            }

            @Override // com.google.protobuf.a.AbstractC0170a, com.google.protobuf.d0.a
            public Builder mergeFrom(d0 d0Var) {
                if (d0Var instanceof UpdateInfo) {
                    return mergeFrom((UpdateInfo) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            public Builder mergeFrom(UpdateInfo updateInfo) {
                if (updateInfo == UpdateInfo.getDefaultInstance()) {
                    return this;
                }
                if (!updateInfo.getDeviceId().isEmpty()) {
                    this.deviceId_ = updateInfo.deviceId_;
                    onChanged();
                }
                if (!updateInfo.getDeviceName().isEmpty()) {
                    this.deviceName_ = updateInfo.deviceName_;
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
                UpdateInfo updateInfo = null;
                try {
                    try {
                        UpdateInfo updateInfo2 = (UpdateInfo) UpdateInfo.PARSER.parsePartialFrom(iVar, qVar);
                        if (updateInfo2 != null) {
                            mergeFrom(updateInfo2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e10) {
                        updateInfo = (UpdateInfo) e10.getUnfinishedMessage();
                        try {
                            throw e10.unwrapIOException();
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (updateInfo != null) {
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (updateInfo != null) {
                        mergeFrom(updateInfo);
                    }
                    throw th2;
                }
            }
        }

        public static Builder newBuilder(UpdateInfo updateInfo) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(updateInfo);
        }

        public static UpdateInfo parseFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, qVar);
        }

        private UpdateInfo(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static UpdateInfo parseDelimitedFrom(InputStream inputStream, q qVar) throws IOException {
            return (UpdateInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
        }

        public static UpdateInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
        public UpdateInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static UpdateInfo parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder newBuilderForType() {
            return newBuilder();
        }

        private UpdateInfo() {
            this.memoizedIsInitialized = (byte) -1;
            this.deviceId_ = "";
            this.deviceName_ = "";
        }

        public static UpdateInfo parseFrom(InputStream inputStream) throws IOException {
            return (UpdateInfo) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.c cVar) {
            return new Builder(cVar);
        }

        public static UpdateInfo parseFrom(InputStream inputStream, q qVar) throws IOException {
            return (UpdateInfo) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
        }

        private UpdateInfo(i iVar, q qVar) throws InvalidProtocolBufferException {
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
                                    this.deviceName_ = iVar.E();
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

        public static UpdateInfo parseFrom(i iVar) throws IOException {
            return (UpdateInfo) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
        }

        public static UpdateInfo parseFrom(i iVar, q qVar) throws IOException {
            return (UpdateInfo) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
        }
    }

    /* loaded from: classes2.dex */
    public interface UpdateInfoOrBuilder extends g0 {
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
        Descriptors.FileDescriptor.q(new String[]{"\n\u0016common/constants.proto\u0012\u0006common\"\u009a\u0001\n\u0013TicAssistantRequest\u0012%\n\tbind_info\u0018\u0001 \u0001(\u000b2\u0010.common.BindInfoH\u0000\u0012)\n\u000bunbind_info\u0018\u0002 \u0001(\u000b2\u0012.common.UnbindInfoH\u0000\u0012)\n\u000bupdate_info\u0018\u0003 \u0001(\u000b2\u0012.common.UpdateInfoH\u0000B\u0006\n\u0004type\"E\n\u0014TicAssistantResponse\u0012\n\n\u0002ok\u0018\u0001 \u0001(\b\u0012\u0010\n\berr_code\u0018\u0002 \u0001(\u0005\u0012\u000f\n\u0007err_msg\u0018\u0003 \u0001(\t\"Ä\u0002\n\bBindInfo\u0012\f\n\u0004wwid\u0018\u0001 \u0001(\t\u0012\u0011\n\tdevice_id\u0018\u0002 \u0001(\t\u0012'\n\u000bdevice_type\u0018\u0003 \u0001(\u000e2\u0012.common.DeviceType\u0012\u0013\n\u000bdevice_name\u0018\u0004 \u0001(\t\u0012\r\n\u0005model\u0018\u0005 \u0001(\t\u0012\u0019\n\u0011bluetooth_add", "ress\u0018\u0006 \u0001(\t\u0012\u0014\n\fwifi_address\u0018\u0007 \u0001(\t\u0012\u0011\n\tdevice_sn\u0018\b \u0001(\t\u00121\n\ronline_status\u0018\t \u0001(\u000e2\u001a.common.DeviceOnlineStatus\u0012\u0012\n\ncreated_at\u0018\n \u0001(\u0003\u0012\u0012\n\nupdated_at\u0018\u000b \u0001(\u0003\u0012\u0014\n\fconnected_qq\u0018\f \u0001(\b\u0012\u0015\n\rsales_channel\u0018\r \u0001(\t\"-\n\nUnbindInfo\u0012\u0011\n\tdevice_id\u0018\u0001 \u0001(\t\u0012\f\n\u0004wwid\u0018\u0002 \u0001(\t\"4\n\nUpdateInfo\u0012\u0011\n\tdevice_id\u0018\u0001 \u0001(\t\u0012\u0013\n\u000bdevice_name\u0018\u0002 \u0001(\t\"7\n\u0010BindInfoResponse\u0012#\n\tbind_info\u0018\u0001 \u0003(\u000b2\u0010.common.BindInfo\"?\n\rHotelBindResp\u0012.\n\u000fhotel_bind_data\u0018\u0001 \u0003(\u000b2\u0015.common.Hot", "elBindData\"\"\n\u000eHotelAdminResp\u0012\u0010\n\bis_admin\u0018\u0001 \u0001(\b\"V\n\rHotelBindData\u0012#\n\tbind_info\u0018\u0001 \u0001(\u000b2\u0010.common.BindInfo\u0012\r\n\u0005token\u0018\u0002 \u0001(\t\u0012\u0011\n\tsub_token\u0018\u0003 \u0001(\t*C\n\u0012DeviceOnlineStatus\u0012\u0012\n\u000eUNKNOWN_STATUS\u0010\u0000\u0012\f\n\bOFF_LINE\u0010\u0001\u0012\u000b\n\u0007ON_LINE\u0010\u0002*Þ\u0001\n\nDeviceType\u0012\u0017\n\u0013UNKNOWN_DEVICE_TYPE\u0010\u0000\u0012\r\n\tTIC_WATCH\u0010\u0001\u0012\u000e\n\nTIC_MIRROR\u0010\u0002\u0012\f\n\bTIC_HOME\u0010\u0003\u0012\u0011\n\rTIC_ASSISTANT\u0010\u0004\u0012\u0015\n\u0011TIC_ASSISTANT_IOS\u0010\u0005\u0012\u0011\n\rTIC_HOME_MINI\u0010\u0006\u0012\f\n\bTIC_PODS\u0010\u0007\u0012\f\n\bTIC_BAND\u0010\b\u0012\f\n\bTIC_KIDS\u0010\t\u0012\f\n\bTIC_L", "IFE\u0010\n\u0012\u0015\n\u0011TIC_ASSISTANT_OEM\u0010\u000b*G\n\u0007Channel\u0012\u0013\n\u000fUNKNOWN_CHANNEL\u0010\u0000\u0012\u0007\n\u0003DEV\u0010\u0001\u0012\b\n\u0004BETA\u0010\u0002\u0012\u000b\n\u0007RELEASE\u0010\u0003\u0012\u0007\n\u0003ALL\u0010\u0004B&\n\u0014com.mobvoi.companionB\u000eConstantsProtob\u0006proto3"}, new Descriptors.FileDescriptor[0], new Descriptors.FileDescriptor.a() { // from class: com.mobvoi.companion.ConstantsProto.1
            @Override // com.google.protobuf.Descriptors.FileDescriptor.a
            public o assignDescriptors(Descriptors.FileDescriptor fileDescriptor) {
                Descriptors.FileDescriptor unused = ConstantsProto.descriptor = fileDescriptor;
                return null;
            }
        });
        Descriptors.b bVar = getDescriptor().j().get(0);
        internal_static_common_TicAssistantRequest_descriptor = bVar;
        internal_static_common_TicAssistantRequest_fieldAccessorTable = new GeneratedMessageV3.e(bVar, new String[]{"BindInfo", "UnbindInfo", "UpdateInfo", "Type"});
        Descriptors.b bVar2 = getDescriptor().j().get(1);
        internal_static_common_TicAssistantResponse_descriptor = bVar2;
        internal_static_common_TicAssistantResponse_fieldAccessorTable = new GeneratedMessageV3.e(bVar2, new String[]{"Ok", "ErrCode", "ErrMsg"});
        Descriptors.b bVar3 = getDescriptor().j().get(2);
        internal_static_common_BindInfo_descriptor = bVar3;
        internal_static_common_BindInfo_fieldAccessorTable = new GeneratedMessageV3.e(bVar3, new String[]{"Wwid", "DeviceId", "DeviceType", "DeviceName", "Model", "BluetoothAddress", "WifiAddress", "DeviceSn", "OnlineStatus", "CreatedAt", "UpdatedAt", "ConnectedQq", "SalesChannel"});
        Descriptors.b bVar4 = getDescriptor().j().get(3);
        internal_static_common_UnbindInfo_descriptor = bVar4;
        internal_static_common_UnbindInfo_fieldAccessorTable = new GeneratedMessageV3.e(bVar4, new String[]{"DeviceId", "Wwid"});
        Descriptors.b bVar5 = getDescriptor().j().get(4);
        internal_static_common_UpdateInfo_descriptor = bVar5;
        internal_static_common_UpdateInfo_fieldAccessorTable = new GeneratedMessageV3.e(bVar5, new String[]{"DeviceId", "DeviceName"});
        Descriptors.b bVar6 = getDescriptor().j().get(5);
        internal_static_common_BindInfoResponse_descriptor = bVar6;
        internal_static_common_BindInfoResponse_fieldAccessorTable = new GeneratedMessageV3.e(bVar6, new String[]{"BindInfo"});
        Descriptors.b bVar7 = getDescriptor().j().get(6);
        internal_static_common_HotelBindResp_descriptor = bVar7;
        internal_static_common_HotelBindResp_fieldAccessorTable = new GeneratedMessageV3.e(bVar7, new String[]{"HotelBindData"});
        Descriptors.b bVar8 = getDescriptor().j().get(7);
        internal_static_common_HotelAdminResp_descriptor = bVar8;
        internal_static_common_HotelAdminResp_fieldAccessorTable = new GeneratedMessageV3.e(bVar8, new String[]{"IsAdmin"});
        Descriptors.b bVar9 = getDescriptor().j().get(8);
        internal_static_common_HotelBindData_descriptor = bVar9;
        internal_static_common_HotelBindData_fieldAccessorTable = new GeneratedMessageV3.e(bVar9, new String[]{"BindInfo", "Token", "SubToken"});
    }

    private ConstantsProto() {
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
