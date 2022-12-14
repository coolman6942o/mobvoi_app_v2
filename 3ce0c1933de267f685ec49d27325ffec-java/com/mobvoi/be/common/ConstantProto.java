package com.mobvoi.be.common;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.a;
import com.google.protobuf.a1;
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
/* loaded from: classes2.dex */
public final class ConstantProto {

    /* renamed from: a  reason: collision with root package name */
    private static final Descriptors.b f15817a;

    /* renamed from: b  reason: collision with root package name */
    private static final GeneratedMessageV3.e f15818b;

    /* renamed from: c  reason: collision with root package name */
    private static final Descriptors.b f15819c;

    /* renamed from: d  reason: collision with root package name */
    private static final GeneratedMessageV3.e f15820d;

    /* renamed from: e  reason: collision with root package name */
    private static final Descriptors.b f15821e;

    /* renamed from: f  reason: collision with root package name */
    private static final GeneratedMessageV3.e f15822f;

    /* renamed from: g  reason: collision with root package name */
    private static final Descriptors.b f15823g;

    /* renamed from: h  reason: collision with root package name */
    private static final GeneratedMessageV3.e f15824h;

    /* renamed from: i  reason: collision with root package name */
    private static final Descriptors.b f15825i;

    /* renamed from: j  reason: collision with root package name */
    private static final GeneratedMessageV3.e f15826j;

    /* renamed from: k  reason: collision with root package name */
    private static final Descriptors.b f15827k;

    /* renamed from: l  reason: collision with root package name */
    private static final GeneratedMessageV3.e f15828l;

    /* renamed from: m  reason: collision with root package name */
    private static final Descriptors.b f15829m;

    /* renamed from: n  reason: collision with root package name */
    private static final GeneratedMessageV3.e f15830n;

    /* renamed from: o  reason: collision with root package name */
    private static final Descriptors.b f15831o;

    /* renamed from: p  reason: collision with root package name */
    private static final GeneratedMessageV3.e f15832p;

    /* renamed from: q  reason: collision with root package name */
    private static final Descriptors.b f15833q;

    /* renamed from: r  reason: collision with root package name */
    private static final GeneratedMessageV3.e f15834r;

    /* renamed from: s  reason: collision with root package name */
    private static Descriptors.FileDescriptor f15835s;

    /* loaded from: classes2.dex */
    public static final class BindInfo extends GeneratedMessageV3 implements c {
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
        private static final l0<BindInfo> PARSER = new a();

        /* loaded from: classes2.dex */
        class a extends com.google.protobuf.c<BindInfo> {
            a() {
            }

            /* renamed from: a */
            public BindInfo parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
                return new BindInfo(iVar, qVar, null);
            }
        }

        /* loaded from: classes2.dex */
        public static final class b extends GeneratedMessageV3.b<b> implements c {

            /* renamed from: a  reason: collision with root package name */
            private Object f15836a;

            /* renamed from: b  reason: collision with root package name */
            private Object f15837b;

            /* renamed from: c  reason: collision with root package name */
            private int f15838c;

            /* renamed from: d  reason: collision with root package name */
            private Object f15839d;

            /* renamed from: e  reason: collision with root package name */
            private Object f15840e;

            /* renamed from: f  reason: collision with root package name */
            private Object f15841f;

            /* renamed from: g  reason: collision with root package name */
            private Object f15842g;

            /* renamed from: h  reason: collision with root package name */
            private Object f15843h;

            /* renamed from: i  reason: collision with root package name */
            private int f15844i;

            /* renamed from: j  reason: collision with root package name */
            private long f15845j;

            /* renamed from: k  reason: collision with root package name */
            private long f15846k;

            /* renamed from: l  reason: collision with root package name */
            private boolean f15847l;

            /* renamed from: m  reason: collision with root package name */
            private Object f15848m;

            /* synthetic */ b(GeneratedMessageV3.c cVar, a aVar) {
                this(cVar);
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            /* renamed from: a */
            public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.addRepeatedField(fieldDescriptor, obj);
            }

            /* renamed from: b */
            public BindInfo build() {
                BindInfo c10 = buildPartial();
                if (c10.isInitialized()) {
                    return c10;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) c10);
            }

            /* renamed from: c */
            public BindInfo buildPartial() {
                BindInfo bindInfo = new BindInfo(this, (a) null);
                bindInfo.wwid_ = this.f15836a;
                bindInfo.deviceId_ = this.f15837b;
                bindInfo.deviceType_ = this.f15838c;
                bindInfo.deviceName_ = this.f15839d;
                bindInfo.model_ = this.f15840e;
                bindInfo.bluetoothAddress_ = this.f15841f;
                bindInfo.wifiAddress_ = this.f15842g;
                bindInfo.deviceSn_ = this.f15843h;
                bindInfo.onlineStatus_ = this.f15844i;
                bindInfo.createdAt_ = this.f15845j;
                bindInfo.updatedAt_ = this.f15846k;
                bindInfo.connectedQq_ = this.f15847l;
                bindInfo.salesChannel_ = this.f15848m;
                onBuilt();
                return bindInfo;
            }

            /* renamed from: d */
            public b clear() {
                super.clear();
                this.f15836a = "";
                this.f15837b = "";
                this.f15838c = 0;
                this.f15839d = "";
                this.f15840e = "";
                this.f15841f = "";
                this.f15842g = "";
                this.f15843h = "";
                this.f15844i = 0;
                this.f15845j = 0L;
                this.f15846k = 0L;
                this.f15847l = false;
                this.f15848m = "";
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
                return ConstantProto.f15821e;
            }

            /* renamed from: i */
            public BindInfo getDefaultInstanceForType() {
                return BindInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return ConstantProto.f15822f.e(BindInfo.class, b.class);
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
            public b mergeFrom(i iVar, q qVar) throws IOException {
                Throwable th2;
                BindInfo bindInfo = null;
                try {
                    try {
                        BindInfo bindInfo2 = (BindInfo) BindInfo.PARSER.parsePartialFrom(iVar, qVar);
                        if (bindInfo2 != null) {
                            l(bindInfo2);
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
                        l(bindInfo);
                    }
                    throw th2;
                }
            }

            /* renamed from: k */
            public b mergeFrom(d0 d0Var) {
                if (d0Var instanceof BindInfo) {
                    return l((BindInfo) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            public b l(BindInfo bindInfo) {
                if (bindInfo == BindInfo.getDefaultInstance()) {
                    return this;
                }
                if (!bindInfo.getWwid().isEmpty()) {
                    this.f15836a = bindInfo.wwid_;
                    onChanged();
                }
                if (!bindInfo.getDeviceId().isEmpty()) {
                    this.f15837b = bindInfo.deviceId_;
                    onChanged();
                }
                if (bindInfo.deviceType_ != 0) {
                    p(bindInfo.getDeviceTypeValue());
                }
                if (!bindInfo.getDeviceName().isEmpty()) {
                    this.f15839d = bindInfo.deviceName_;
                    onChanged();
                }
                if (!bindInfo.getModel().isEmpty()) {
                    this.f15840e = bindInfo.model_;
                    onChanged();
                }
                if (!bindInfo.getBluetoothAddress().isEmpty()) {
                    this.f15841f = bindInfo.bluetoothAddress_;
                    onChanged();
                }
                if (!bindInfo.getWifiAddress().isEmpty()) {
                    this.f15842g = bindInfo.wifiAddress_;
                    onChanged();
                }
                if (!bindInfo.getDeviceSn().isEmpty()) {
                    this.f15843h = bindInfo.deviceSn_;
                    onChanged();
                }
                if (bindInfo.onlineStatus_ != 0) {
                    r(bindInfo.getOnlineStatusValue());
                }
                if (bindInfo.getCreatedAt() != 0) {
                    o(bindInfo.getCreatedAt());
                }
                if (bindInfo.getUpdatedAt() != 0) {
                    u(bindInfo.getUpdatedAt());
                }
                if (bindInfo.getConnectedQq()) {
                    n(bindInfo.getConnectedQq());
                }
                if (!bindInfo.getSalesChannel().isEmpty()) {
                    this.f15848m = bindInfo.salesChannel_;
                    onChanged();
                }
                onChanged();
                return this;
            }

            /* renamed from: m */
            public final b mergeUnknownFields(a1 a1Var) {
                return this;
            }

            public b n(boolean z10) {
                this.f15847l = z10;
                onChanged();
                return this;
            }

            public b o(long j10) {
                this.f15845j = j10;
                onChanged();
                return this;
            }

            public b p(int i10) {
                this.f15838c = i10;
                onChanged();
                return this;
            }

            /* renamed from: q */
            public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.setField(fieldDescriptor, obj);
            }

            public b r(int i10) {
                this.f15844i = i10;
                onChanged();
                return this;
            }

            /* renamed from: s */
            public b setRepeatedField2(Descriptors.FieldDescriptor fieldDescriptor, int i10, Object obj) {
                return (b) super.setRepeatedField(fieldDescriptor, i10, obj);
            }

            /* renamed from: t */
            public final b setUnknownFields(a1 a1Var) {
                return this;
            }

            public b u(long j10) {
                this.f15846k = j10;
                onChanged();
                return this;
            }

            /* synthetic */ b(a aVar) {
                this();
            }

            private b() {
                this.f15836a = "";
                this.f15837b = "";
                this.f15838c = 0;
                this.f15839d = "";
                this.f15840e = "";
                this.f15841f = "";
                this.f15842g = "";
                this.f15843h = "";
                this.f15844i = 0;
                this.f15848m = "";
                maybeForceBuilderInitialization();
            }

            private b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.f15836a = "";
                this.f15837b = "";
                this.f15838c = 0;
                this.f15839d = "";
                this.f15840e = "";
                this.f15841f = "";
                this.f15842g = "";
                this.f15843h = "";
                this.f15844i = 0;
                this.f15848m = "";
                maybeForceBuilderInitialization();
            }
        }

        /* synthetic */ BindInfo(i iVar, q qVar, a aVar) throws InvalidProtocolBufferException {
            this(iVar, qVar);
        }

        public static BindInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return ConstantProto.f15821e;
        }

        public static b newBuilder() {
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

        public String getBluetoothAddress() {
            Object obj = this.bluetoothAddress_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.bluetoothAddress_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getBluetoothAddressBytes() {
            Object obj = this.bluetoothAddress_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.bluetoothAddress_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public boolean getConnectedQq() {
            return this.connectedQq_;
        }

        public long getCreatedAt() {
            return this.createdAt_;
        }

        public String getDeviceId() {
            Object obj = this.deviceId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.deviceId_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getDeviceIdBytes() {
            Object obj = this.deviceId_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.deviceId_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public String getDeviceName() {
            Object obj = this.deviceName_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.deviceName_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getDeviceNameBytes() {
            Object obj = this.deviceName_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.deviceName_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public String getDeviceSn() {
            Object obj = this.deviceSn_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.deviceSn_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getDeviceSnBytes() {
            Object obj = this.deviceSn_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.deviceSn_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public DeviceType getDeviceType() {
            DeviceType valueOf = DeviceType.valueOf(this.deviceType_);
            return valueOf == null ? DeviceType.UNRECOGNIZED : valueOf;
        }

        public int getDeviceTypeValue() {
            return this.deviceType_;
        }

        public String getModel() {
            Object obj = this.model_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.model_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getModelBytes() {
            Object obj = this.model_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.model_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public DeviceOnlineStatus getOnlineStatus() {
            DeviceOnlineStatus valueOf = DeviceOnlineStatus.valueOf(this.onlineStatus_);
            return valueOf == null ? DeviceOnlineStatus.UNRECOGNIZED : valueOf;
        }

        public int getOnlineStatusValue() {
            return this.onlineStatus_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public l0<BindInfo> getParserForType() {
            return PARSER;
        }

        public String getSalesChannel() {
            Object obj = this.salesChannel_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.salesChannel_ = stringUtf8;
            return stringUtf8;
        }

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

        public long getUpdatedAt() {
            return this.updatedAt_;
        }

        public String getWifiAddress() {
            Object obj = this.wifiAddress_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.wifiAddress_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getWifiAddressBytes() {
            Object obj = this.wifiAddress_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.wifiAddress_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public String getWwid() {
            Object obj = this.wwid_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.wwid_ = stringUtf8;
            return stringUtf8;
        }

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
            return ConstantProto.f15822f.e(BindInfo.class, b.class);
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

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: z */
        public b newBuilderForType(GeneratedMessageV3.c cVar) {
            return new b(cVar, null);
        }

        /* synthetic */ BindInfo(GeneratedMessageV3.b bVar, a aVar) {
            this(bVar);
        }

        public static b newBuilder(BindInfo bindInfo) {
            return DEFAULT_INSTANCE.toBuilder().l(bindInfo);
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
        public b toBuilder() {
            return this == DEFAULT_INSTANCE ? new b((a) null) : new b((a) null).l(this);
        }

        public static BindInfo parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b newBuilderForType() {
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
    public static final class BindInfoResponse extends GeneratedMessageV3 implements g0 {
        public static final int BIND_INFO_FIELD_NUMBER = 1;
        private static final BindInfoResponse DEFAULT_INSTANCE = new BindInfoResponse();
        private static final l0<BindInfoResponse> PARSER = new a();
        private static final long serialVersionUID = 0;
        private List<BindInfo> bindInfo_;
        private byte memoizedIsInitialized;

        /* loaded from: classes2.dex */
        class a extends com.google.protobuf.c<BindInfoResponse> {
            a() {
            }

            /* renamed from: a */
            public BindInfoResponse parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
                return new BindInfoResponse(iVar, qVar, null);
            }
        }

        /* loaded from: classes2.dex */
        public static final class b extends GeneratedMessageV3.b<b> implements g0 {

            /* renamed from: a  reason: collision with root package name */
            private int f15849a;

            /* renamed from: b  reason: collision with root package name */
            private List<BindInfo> f15850b;

            /* renamed from: c  reason: collision with root package name */
            private o0<BindInfo, BindInfo.b, c> f15851c;

            /* synthetic */ b(GeneratedMessageV3.c cVar, a aVar) {
                this(cVar);
            }

            private void ensureBindInfoIsMutable() {
                if ((this.f15849a & 1) != 1) {
                    this.f15850b = new ArrayList(this.f15850b);
                    this.f15849a |= 1;
                }
            }

            private o0<BindInfo, BindInfo.b, c> getBindInfoFieldBuilder() {
                if (this.f15851c == null) {
                    List<BindInfo> list = this.f15850b;
                    boolean z10 = true;
                    if ((this.f15849a & 1) != 1) {
                        z10 = false;
                    }
                    this.f15851c = new o0<>(list, z10, getParentForChildren(), isClean());
                    this.f15850b = null;
                }
                return this.f15851c;
            }

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                    getBindInfoFieldBuilder();
                }
            }

            /* renamed from: a */
            public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.addRepeatedField(fieldDescriptor, obj);
            }

            /* renamed from: b */
            public BindInfoResponse build() {
                BindInfoResponse c10 = buildPartial();
                if (c10.isInitialized()) {
                    return c10;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) c10);
            }

            /* renamed from: c */
            public BindInfoResponse buildPartial() {
                BindInfoResponse bindInfoResponse = new BindInfoResponse(this, (a) null);
                int i10 = this.f15849a;
                o0<BindInfo, BindInfo.b, c> o0Var = this.f15851c;
                if (o0Var == null) {
                    if ((i10 & 1) == 1) {
                        this.f15850b = Collections.unmodifiableList(this.f15850b);
                        this.f15849a &= -2;
                    }
                    bindInfoResponse.bindInfo_ = this.f15850b;
                } else {
                    bindInfoResponse.bindInfo_ = o0Var.g();
                }
                onBuilt();
                return bindInfoResponse;
            }

            /* renamed from: d */
            public b clear() {
                super.clear();
                o0<BindInfo, BindInfo.b, c> o0Var = this.f15851c;
                if (o0Var == null) {
                    this.f15850b = Collections.emptyList();
                    this.f15849a &= -2;
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
                return ConstantProto.f15827k;
            }

            /* renamed from: i */
            public BindInfoResponse getDefaultInstanceForType() {
                return BindInfoResponse.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return ConstantProto.f15828l.e(BindInfoResponse.class, b.class);
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
            public b mergeFrom(i iVar, q qVar) throws IOException {
                Throwable th2;
                BindInfoResponse bindInfoResponse = null;
                try {
                    try {
                        BindInfoResponse bindInfoResponse2 = (BindInfoResponse) BindInfoResponse.PARSER.parsePartialFrom(iVar, qVar);
                        if (bindInfoResponse2 != null) {
                            l(bindInfoResponse2);
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
                        l(bindInfoResponse);
                    }
                    throw th2;
                }
            }

            /* renamed from: k */
            public b mergeFrom(d0 d0Var) {
                if (d0Var instanceof BindInfoResponse) {
                    return l((BindInfoResponse) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            public b l(BindInfoResponse bindInfoResponse) {
                if (bindInfoResponse == BindInfoResponse.getDefaultInstance()) {
                    return this;
                }
                if (this.f15851c == null) {
                    if (!bindInfoResponse.bindInfo_.isEmpty()) {
                        if (this.f15850b.isEmpty()) {
                            this.f15850b = bindInfoResponse.bindInfo_;
                            this.f15849a &= -2;
                        } else {
                            ensureBindInfoIsMutable();
                            this.f15850b.addAll(bindInfoResponse.bindInfo_);
                        }
                        onChanged();
                    }
                } else if (!bindInfoResponse.bindInfo_.isEmpty()) {
                    if (this.f15851c.u()) {
                        this.f15851c.i();
                        o0<BindInfo, BindInfo.b, c> o0Var = null;
                        this.f15851c = null;
                        this.f15850b = bindInfoResponse.bindInfo_;
                        this.f15849a &= -2;
                        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                            o0Var = getBindInfoFieldBuilder();
                        }
                        this.f15851c = o0Var;
                    } else {
                        this.f15851c.b(bindInfoResponse.bindInfo_);
                    }
                }
                onChanged();
                return this;
            }

            /* renamed from: m */
            public final b mergeUnknownFields(a1 a1Var) {
                return this;
            }

            /* renamed from: n */
            public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.setField(fieldDescriptor, obj);
            }

            /* renamed from: o */
            public b setRepeatedField2(Descriptors.FieldDescriptor fieldDescriptor, int i10, Object obj) {
                return (b) super.setRepeatedField(fieldDescriptor, i10, obj);
            }

            /* renamed from: p */
            public final b setUnknownFields(a1 a1Var) {
                return this;
            }

            /* synthetic */ b(a aVar) {
                this();
            }

            private b() {
                this.f15850b = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.f15850b = Collections.emptyList();
                maybeForceBuilderInitialization();
            }
        }

        /* synthetic */ BindInfoResponse(i iVar, q qVar, a aVar) throws InvalidProtocolBufferException {
            this(iVar, qVar);
        }

        public static BindInfoResponse getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return ConstantProto.f15827k;
        }

        public static b newBuilder() {
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

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: c */
        public b newBuilderForType(GeneratedMessageV3.c cVar) {
            return new b(cVar, null);
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

        public BindInfo getBindInfo(int i10) {
            return this.bindInfo_.get(i10);
        }

        public int getBindInfoCount() {
            return this.bindInfo_.size();
        }

        public List<BindInfo> getBindInfoList() {
            return this.bindInfo_;
        }

        public c getBindInfoOrBuilder(int i10) {
            return this.bindInfo_.get(i10);
        }

        public List<? extends c> getBindInfoOrBuilderList() {
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
            return ConstantProto.f15828l.e(BindInfoResponse.class, b.class);
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

        /* synthetic */ BindInfoResponse(GeneratedMessageV3.b bVar, a aVar) {
            this(bVar);
        }

        public static b newBuilder(BindInfoResponse bindInfoResponse) {
            return DEFAULT_INSTANCE.toBuilder().l(bindInfoResponse);
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
        public b toBuilder() {
            return this == DEFAULT_INSTANCE ? new b((a) null) : new b((a) null).l(this);
        }

        public static BindInfoResponse parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b newBuilderForType() {
            return newBuilder();
        }

        private BindInfoResponse() {
            this.memoizedIsInitialized = (byte) -1;
            this.bindInfo_ = Collections.emptyList();
        }

        public static BindInfoResponse parseFrom(InputStream inputStream) throws IOException {
            return (BindInfoResponse) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
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
        private static final u.b<Channel> internalValueMap = new a();
        private static final Channel[] VALUES = values();

        /* loaded from: classes2.dex */
        class a implements u.b<Channel> {
            a() {
            }
        }

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
            return ConstantProto.t().i().get(2);
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
        private static final u.b<DeviceOnlineStatus> internalValueMap = new a();
        private static final DeviceOnlineStatus[] VALUES = values();

        /* loaded from: classes2.dex */
        class a implements u.b<DeviceOnlineStatus> {
            a() {
            }
        }

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
            return ConstantProto.t().i().get(0);
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
        TIC_KIDS_ON_TIC_WATCH(12),
        TIC_MEET(13),
        MOBVOI_AIRECORDER(14),
        MOBVOI_AISPEAKERPHONE(15),
        UNRECOGNIZED(-1);
        
        public static final int MOBVOI_AIRECORDER_VALUE = 14;
        public static final int MOBVOI_AISPEAKERPHONE_VALUE = 15;
        public static final int TIC_ASSISTANT_IOS_VALUE = 5;
        public static final int TIC_ASSISTANT_OEM_VALUE = 11;
        public static final int TIC_ASSISTANT_VALUE = 4;
        public static final int TIC_BAND_VALUE = 8;
        public static final int TIC_HOME_MINI_VALUE = 6;
        public static final int TIC_HOME_VALUE = 3;
        public static final int TIC_KIDS_ON_TIC_WATCH_VALUE = 12;
        public static final int TIC_KIDS_VALUE = 9;
        public static final int TIC_LIFE_VALUE = 10;
        public static final int TIC_MEET_VALUE = 13;
        public static final int TIC_MIRROR_VALUE = 2;
        public static final int TIC_PODS_VALUE = 7;
        public static final int TIC_WATCH_VALUE = 1;
        public static final int UNKNOWN_DEVICE_TYPE_VALUE = 0;
        private final int value;
        private static final u.b<DeviceType> internalValueMap = new a();
        private static final DeviceType[] VALUES = values();

        /* loaded from: classes2.dex */
        class a implements u.b<DeviceType> {
            a() {
            }
        }

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
                case 12:
                    return TIC_KIDS_ON_TIC_WATCH;
                case 13:
                    return TIC_MEET;
                case 14:
                    return MOBVOI_AIRECORDER;
                case 15:
                    return MOBVOI_AISPEAKERPHONE;
                default:
                    return null;
            }
        }

        public static final Descriptors.d getDescriptor() {
            return ConstantProto.t().i().get(1);
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
    public static final class HotelAdminResp extends GeneratedMessageV3 implements g0 {
        public static final int IS_ADMIN_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private boolean isAdmin_;
        private byte memoizedIsInitialized;
        private static final HotelAdminResp DEFAULT_INSTANCE = new HotelAdminResp();
        private static final l0<HotelAdminResp> PARSER = new a();

        /* loaded from: classes2.dex */
        class a extends com.google.protobuf.c<HotelAdminResp> {
            a() {
            }

            /* renamed from: a */
            public HotelAdminResp parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
                return new HotelAdminResp(iVar, qVar, null);
            }
        }

        /* loaded from: classes2.dex */
        public static final class b extends GeneratedMessageV3.b<b> implements g0 {

            /* renamed from: a  reason: collision with root package name */
            private boolean f15852a;

            /* synthetic */ b(GeneratedMessageV3.c cVar, a aVar) {
                this(cVar);
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            /* renamed from: a */
            public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.addRepeatedField(fieldDescriptor, obj);
            }

            /* renamed from: b */
            public HotelAdminResp build() {
                HotelAdminResp c10 = buildPartial();
                if (c10.isInitialized()) {
                    return c10;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) c10);
            }

            /* renamed from: c */
            public HotelAdminResp buildPartial() {
                HotelAdminResp hotelAdminResp = new HotelAdminResp(this, (a) null);
                hotelAdminResp.isAdmin_ = this.f15852a;
                onBuilt();
                return hotelAdminResp;
            }

            /* renamed from: d */
            public b clear() {
                super.clear();
                this.f15852a = false;
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
                return ConstantProto.f15831o;
            }

            /* renamed from: i */
            public HotelAdminResp getDefaultInstanceForType() {
                return HotelAdminResp.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return ConstantProto.f15832p.e(HotelAdminResp.class, b.class);
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
            public b mergeFrom(i iVar, q qVar) throws IOException {
                Throwable th2;
                HotelAdminResp hotelAdminResp = null;
                try {
                    try {
                        HotelAdminResp hotelAdminResp2 = (HotelAdminResp) HotelAdminResp.PARSER.parsePartialFrom(iVar, qVar);
                        if (hotelAdminResp2 != null) {
                            l(hotelAdminResp2);
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
                        l(hotelAdminResp);
                    }
                    throw th2;
                }
            }

            /* renamed from: k */
            public b mergeFrom(d0 d0Var) {
                if (d0Var instanceof HotelAdminResp) {
                    return l((HotelAdminResp) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            public b l(HotelAdminResp hotelAdminResp) {
                if (hotelAdminResp == HotelAdminResp.getDefaultInstance()) {
                    return this;
                }
                if (hotelAdminResp.getIsAdmin()) {
                    o(hotelAdminResp.getIsAdmin());
                }
                onChanged();
                return this;
            }

            /* renamed from: m */
            public final b mergeUnknownFields(a1 a1Var) {
                return this;
            }

            /* renamed from: n */
            public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.setField(fieldDescriptor, obj);
            }

            public b o(boolean z10) {
                this.f15852a = z10;
                onChanged();
                return this;
            }

            /* renamed from: p */
            public b setRepeatedField2(Descriptors.FieldDescriptor fieldDescriptor, int i10, Object obj) {
                return (b) super.setRepeatedField(fieldDescriptor, i10, obj);
            }

            /* renamed from: q */
            public final b setUnknownFields(a1 a1Var) {
                return this;
            }

            /* synthetic */ b(a aVar) {
                this();
            }

            private b() {
                maybeForceBuilderInitialization();
            }

            private b(GeneratedMessageV3.c cVar) {
                super(cVar);
                maybeForceBuilderInitialization();
            }
        }

        /* synthetic */ HotelAdminResp(i iVar, q qVar, a aVar) throws InvalidProtocolBufferException {
            this(iVar, qVar);
        }

        public static HotelAdminResp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return ConstantProto.f15831o;
        }

        public static b newBuilder() {
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

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: b */
        public b newBuilderForType(GeneratedMessageV3.c cVar) {
            return new b(cVar, null);
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
            return ConstantProto.f15832p.e(HotelAdminResp.class, b.class);
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

        /* synthetic */ HotelAdminResp(GeneratedMessageV3.b bVar, a aVar) {
            this(bVar);
        }

        public static b newBuilder(HotelAdminResp hotelAdminResp) {
            return DEFAULT_INSTANCE.toBuilder().l(hotelAdminResp);
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
        public b toBuilder() {
            return this == DEFAULT_INSTANCE ? new b((a) null) : new b((a) null).l(this);
        }

        public static HotelAdminResp parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b newBuilderForType() {
            return newBuilder();
        }

        private HotelAdminResp() {
            this.memoizedIsInitialized = (byte) -1;
            this.isAdmin_ = false;
        }

        public static HotelAdminResp parseFrom(InputStream inputStream) throws IOException {
            return (HotelAdminResp) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
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
    public static final class HotelBindData extends GeneratedMessageV3 implements d {
        public static final int BIND_INFO_FIELD_NUMBER = 1;
        private static final HotelBindData DEFAULT_INSTANCE = new HotelBindData();
        private static final l0<HotelBindData> PARSER = new a();
        public static final int SUB_TOKEN_FIELD_NUMBER = 3;
        public static final int TOKEN_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private BindInfo bindInfo_;
        private byte memoizedIsInitialized;
        private volatile Object subToken_;
        private volatile Object token_;

        /* loaded from: classes2.dex */
        class a extends com.google.protobuf.c<HotelBindData> {
            a() {
            }

            /* renamed from: a */
            public HotelBindData parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
                return new HotelBindData(iVar, qVar, null);
            }
        }

        /* loaded from: classes2.dex */
        public static final class b extends GeneratedMessageV3.b<b> implements d {

            /* renamed from: a  reason: collision with root package name */
            private BindInfo f15853a;

            /* renamed from: b  reason: collision with root package name */
            private q0<BindInfo, BindInfo.b, c> f15854b;

            /* renamed from: c  reason: collision with root package name */
            private Object f15855c;

            /* renamed from: d  reason: collision with root package name */
            private Object f15856d;

            /* synthetic */ b(GeneratedMessageV3.c cVar, a aVar) {
                this(cVar);
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            /* renamed from: a */
            public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.addRepeatedField(fieldDescriptor, obj);
            }

            /* renamed from: b */
            public HotelBindData build() {
                HotelBindData c10 = buildPartial();
                if (c10.isInitialized()) {
                    return c10;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) c10);
            }

            /* renamed from: c */
            public HotelBindData buildPartial() {
                HotelBindData hotelBindData = new HotelBindData(this, (a) null);
                q0<BindInfo, BindInfo.b, c> q0Var = this.f15854b;
                if (q0Var == null) {
                    hotelBindData.bindInfo_ = this.f15853a;
                } else {
                    hotelBindData.bindInfo_ = q0Var.b();
                }
                hotelBindData.token_ = this.f15855c;
                hotelBindData.subToken_ = this.f15856d;
                onBuilt();
                return hotelBindData;
            }

            /* renamed from: d */
            public b clear() {
                super.clear();
                if (this.f15854b == null) {
                    this.f15853a = null;
                } else {
                    this.f15853a = null;
                    this.f15854b = null;
                }
                this.f15855c = "";
                this.f15856d = "";
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
                return ConstantProto.f15833q;
            }

            /* renamed from: i */
            public HotelBindData getDefaultInstanceForType() {
                return HotelBindData.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return ConstantProto.f15834r.e(HotelBindData.class, b.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.f0
            public final boolean isInitialized() {
                return true;
            }

            public b j(BindInfo bindInfo) {
                q0<BindInfo, BindInfo.b, c> q0Var = this.f15854b;
                if (q0Var == null) {
                    BindInfo bindInfo2 = this.f15853a;
                    if (bindInfo2 != null) {
                        this.f15853a = BindInfo.newBuilder(bindInfo2).l(bindInfo).buildPartial();
                    } else {
                        this.f15853a = bindInfo;
                    }
                    onChanged();
                } else {
                    q0Var.h(bindInfo);
                }
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x0023  */
            /* renamed from: k */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public b mergeFrom(i iVar, q qVar) throws IOException {
                Throwable th2;
                HotelBindData hotelBindData = null;
                try {
                    try {
                        HotelBindData hotelBindData2 = (HotelBindData) HotelBindData.PARSER.parsePartialFrom(iVar, qVar);
                        if (hotelBindData2 != null) {
                            m(hotelBindData2);
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
                        m(hotelBindData);
                    }
                    throw th2;
                }
            }

            /* renamed from: l */
            public b mergeFrom(d0 d0Var) {
                if (d0Var instanceof HotelBindData) {
                    return m((HotelBindData) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            public b m(HotelBindData hotelBindData) {
                if (hotelBindData == HotelBindData.getDefaultInstance()) {
                    return this;
                }
                if (hotelBindData.hasBindInfo()) {
                    j(hotelBindData.getBindInfo());
                }
                if (!hotelBindData.getToken().isEmpty()) {
                    this.f15855c = hotelBindData.token_;
                    onChanged();
                }
                if (!hotelBindData.getSubToken().isEmpty()) {
                    this.f15856d = hotelBindData.subToken_;
                    onChanged();
                }
                onChanged();
                return this;
            }

            /* renamed from: n */
            public final b mergeUnknownFields(a1 a1Var) {
                return this;
            }

            /* renamed from: o */
            public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.setField(fieldDescriptor, obj);
            }

            /* renamed from: p */
            public b setRepeatedField2(Descriptors.FieldDescriptor fieldDescriptor, int i10, Object obj) {
                return (b) super.setRepeatedField(fieldDescriptor, i10, obj);
            }

            /* renamed from: q */
            public final b setUnknownFields(a1 a1Var) {
                return this;
            }

            /* synthetic */ b(a aVar) {
                this();
            }

            private b() {
                this.f15853a = null;
                this.f15855c = "";
                this.f15856d = "";
                maybeForceBuilderInitialization();
            }

            private b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.f15853a = null;
                this.f15855c = "";
                this.f15856d = "";
                maybeForceBuilderInitialization();
            }
        }

        /* synthetic */ HotelBindData(i iVar, q qVar, a aVar) throws InvalidProtocolBufferException {
            this(iVar, qVar);
        }

        public static HotelBindData getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return ConstantProto.f15833q;
        }

        public static b newBuilder() {
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

        public BindInfo getBindInfo() {
            BindInfo bindInfo = this.bindInfo_;
            return bindInfo == null ? BindInfo.getDefaultInstance() : bindInfo;
        }

        public c getBindInfoOrBuilder() {
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

        public String getSubToken() {
            Object obj = this.subToken_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.subToken_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getSubTokenBytes() {
            Object obj = this.subToken_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.subToken_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public String getToken() {
            Object obj = this.token_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.token_ = stringUtf8;
            return stringUtf8;
        }

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

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: h */
        public b newBuilderForType(GeneratedMessageV3.c cVar) {
            return new b(cVar, null);
        }

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
            return ConstantProto.f15834r.e(HotelBindData.class, b.class);
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

        /* synthetic */ HotelBindData(GeneratedMessageV3.b bVar, a aVar) {
            this(bVar);
        }

        public static b newBuilder(HotelBindData hotelBindData) {
            return DEFAULT_INSTANCE.toBuilder().m(hotelBindData);
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
        public b toBuilder() {
            return this == DEFAULT_INSTANCE ? new b((a) null) : new b((a) null).m(this);
        }

        public static HotelBindData parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b newBuilderForType() {
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
                                    BindInfo.b bVar = null;
                                    BindInfo bindInfo = this.bindInfo_;
                                    bVar = bindInfo != null ? bindInfo.toBuilder() : bVar;
                                    BindInfo bindInfo2 = (BindInfo) iVar.v(BindInfo.parser(), qVar);
                                    this.bindInfo_ = bindInfo2;
                                    if (bVar != null) {
                                        bVar.l(bindInfo2);
                                        this.bindInfo_ = bVar.buildPartial();
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
    public static final class HotelBindResp extends GeneratedMessageV3 implements g0 {
        public static final int HOTEL_BIND_DATA_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private List<HotelBindData> hotelBindData_;
        private byte memoizedIsInitialized;
        private static final HotelBindResp DEFAULT_INSTANCE = new HotelBindResp();
        private static final l0<HotelBindResp> PARSER = new a();

        /* loaded from: classes2.dex */
        class a extends com.google.protobuf.c<HotelBindResp> {
            a() {
            }

            /* renamed from: a */
            public HotelBindResp parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
                return new HotelBindResp(iVar, qVar, null);
            }
        }

        /* loaded from: classes2.dex */
        public static final class b extends GeneratedMessageV3.b<b> implements g0 {

            /* renamed from: a  reason: collision with root package name */
            private int f15857a;

            /* renamed from: b  reason: collision with root package name */
            private List<HotelBindData> f15858b;

            /* renamed from: c  reason: collision with root package name */
            private o0<HotelBindData, HotelBindData.b, d> f15859c;

            /* synthetic */ b(GeneratedMessageV3.c cVar, a aVar) {
                this(cVar);
            }

            private void ensureHotelBindDataIsMutable() {
                if ((this.f15857a & 1) != 1) {
                    this.f15858b = new ArrayList(this.f15858b);
                    this.f15857a |= 1;
                }
            }

            private o0<HotelBindData, HotelBindData.b, d> getHotelBindDataFieldBuilder() {
                if (this.f15859c == null) {
                    List<HotelBindData> list = this.f15858b;
                    boolean z10 = true;
                    if ((this.f15857a & 1) != 1) {
                        z10 = false;
                    }
                    this.f15859c = new o0<>(list, z10, getParentForChildren(), isClean());
                    this.f15858b = null;
                }
                return this.f15859c;
            }

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                    getHotelBindDataFieldBuilder();
                }
            }

            /* renamed from: a */
            public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.addRepeatedField(fieldDescriptor, obj);
            }

            /* renamed from: b */
            public HotelBindResp build() {
                HotelBindResp c10 = buildPartial();
                if (c10.isInitialized()) {
                    return c10;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) c10);
            }

            /* renamed from: c */
            public HotelBindResp buildPartial() {
                HotelBindResp hotelBindResp = new HotelBindResp(this, (a) null);
                int i10 = this.f15857a;
                o0<HotelBindData, HotelBindData.b, d> o0Var = this.f15859c;
                if (o0Var == null) {
                    if ((i10 & 1) == 1) {
                        this.f15858b = Collections.unmodifiableList(this.f15858b);
                        this.f15857a &= -2;
                    }
                    hotelBindResp.hotelBindData_ = this.f15858b;
                } else {
                    hotelBindResp.hotelBindData_ = o0Var.g();
                }
                onBuilt();
                return hotelBindResp;
            }

            /* renamed from: d */
            public b clear() {
                super.clear();
                o0<HotelBindData, HotelBindData.b, d> o0Var = this.f15859c;
                if (o0Var == null) {
                    this.f15858b = Collections.emptyList();
                    this.f15857a &= -2;
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
                return ConstantProto.f15829m;
            }

            /* renamed from: i */
            public HotelBindResp getDefaultInstanceForType() {
                return HotelBindResp.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return ConstantProto.f15830n.e(HotelBindResp.class, b.class);
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
            public b mergeFrom(i iVar, q qVar) throws IOException {
                Throwable th2;
                HotelBindResp hotelBindResp = null;
                try {
                    try {
                        HotelBindResp hotelBindResp2 = (HotelBindResp) HotelBindResp.PARSER.parsePartialFrom(iVar, qVar);
                        if (hotelBindResp2 != null) {
                            l(hotelBindResp2);
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
                        l(hotelBindResp);
                    }
                    throw th2;
                }
            }

            /* renamed from: k */
            public b mergeFrom(d0 d0Var) {
                if (d0Var instanceof HotelBindResp) {
                    return l((HotelBindResp) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            public b l(HotelBindResp hotelBindResp) {
                if (hotelBindResp == HotelBindResp.getDefaultInstance()) {
                    return this;
                }
                if (this.f15859c == null) {
                    if (!hotelBindResp.hotelBindData_.isEmpty()) {
                        if (this.f15858b.isEmpty()) {
                            this.f15858b = hotelBindResp.hotelBindData_;
                            this.f15857a &= -2;
                        } else {
                            ensureHotelBindDataIsMutable();
                            this.f15858b.addAll(hotelBindResp.hotelBindData_);
                        }
                        onChanged();
                    }
                } else if (!hotelBindResp.hotelBindData_.isEmpty()) {
                    if (this.f15859c.u()) {
                        this.f15859c.i();
                        o0<HotelBindData, HotelBindData.b, d> o0Var = null;
                        this.f15859c = null;
                        this.f15858b = hotelBindResp.hotelBindData_;
                        this.f15857a &= -2;
                        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                            o0Var = getHotelBindDataFieldBuilder();
                        }
                        this.f15859c = o0Var;
                    } else {
                        this.f15859c.b(hotelBindResp.hotelBindData_);
                    }
                }
                onChanged();
                return this;
            }

            /* renamed from: m */
            public final b mergeUnknownFields(a1 a1Var) {
                return this;
            }

            /* renamed from: n */
            public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.setField(fieldDescriptor, obj);
            }

            /* renamed from: o */
            public b setRepeatedField2(Descriptors.FieldDescriptor fieldDescriptor, int i10, Object obj) {
                return (b) super.setRepeatedField(fieldDescriptor, i10, obj);
            }

            /* renamed from: p */
            public final b setUnknownFields(a1 a1Var) {
                return this;
            }

            /* synthetic */ b(a aVar) {
                this();
            }

            private b() {
                this.f15858b = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.f15858b = Collections.emptyList();
                maybeForceBuilderInitialization();
            }
        }

        /* synthetic */ HotelBindResp(i iVar, q qVar, a aVar) throws InvalidProtocolBufferException {
            this(iVar, qVar);
        }

        public static HotelBindResp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return ConstantProto.f15829m;
        }

        public static b newBuilder() {
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

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: c */
        public b newBuilderForType(GeneratedMessageV3.c cVar) {
            return new b(cVar, null);
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

        public HotelBindData getHotelBindData(int i10) {
            return this.hotelBindData_.get(i10);
        }

        public int getHotelBindDataCount() {
            return this.hotelBindData_.size();
        }

        public List<HotelBindData> getHotelBindDataList() {
            return this.hotelBindData_;
        }

        public d getHotelBindDataOrBuilder(int i10) {
            return this.hotelBindData_.get(i10);
        }

        public List<? extends d> getHotelBindDataOrBuilderList() {
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
            return ConstantProto.f15830n.e(HotelBindResp.class, b.class);
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

        /* synthetic */ HotelBindResp(GeneratedMessageV3.b bVar, a aVar) {
            this(bVar);
        }

        public static b newBuilder(HotelBindResp hotelBindResp) {
            return DEFAULT_INSTANCE.toBuilder().l(hotelBindResp);
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
        public b toBuilder() {
            return this == DEFAULT_INSTANCE ? new b((a) null) : new b((a) null).l(this);
        }

        public static HotelBindResp parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b newBuilderForType() {
            return newBuilder();
        }

        private HotelBindResp() {
            this.memoizedIsInitialized = (byte) -1;
            this.hotelBindData_ = Collections.emptyList();
        }

        public static HotelBindResp parseFrom(InputStream inputStream) throws IOException {
            return (HotelBindResp) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
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
    public static final class TicAssistantRequest extends GeneratedMessageV3 implements g0 {
        public static final int BIND_INFO_FIELD_NUMBER = 1;
        private static final TicAssistantRequest DEFAULT_INSTANCE = new TicAssistantRequest();
        private static final l0<TicAssistantRequest> PARSER = new a();
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

        /* loaded from: classes2.dex */
        class a extends com.google.protobuf.c<TicAssistantRequest> {
            a() {
            }

            /* renamed from: a */
            public TicAssistantRequest parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
                return new TicAssistantRequest(iVar, qVar, null);
            }
        }

        /* loaded from: classes2.dex */
        public static final class b extends GeneratedMessageV3.b<b> implements g0 {

            /* renamed from: a  reason: collision with root package name */
            private int f15860a;

            /* renamed from: b  reason: collision with root package name */
            private Object f15861b;

            /* renamed from: c  reason: collision with root package name */
            private q0<BindInfo, BindInfo.b, c> f15862c;

            /* renamed from: d  reason: collision with root package name */
            private q0<UnbindInfo, UnbindInfo.b, e> f15863d;

            /* renamed from: e  reason: collision with root package name */
            private q0<UpdateInfo, UpdateInfo.b, f> f15864e;

            /* synthetic */ b(GeneratedMessageV3.c cVar, a aVar) {
                this(cVar);
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            /* renamed from: a */
            public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.addRepeatedField(fieldDescriptor, obj);
            }

            /* renamed from: b */
            public TicAssistantRequest build() {
                TicAssistantRequest c10 = buildPartial();
                if (c10.isInitialized()) {
                    return c10;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) c10);
            }

            /* renamed from: c */
            public TicAssistantRequest buildPartial() {
                TicAssistantRequest ticAssistantRequest = new TicAssistantRequest(this, (a) null);
                if (this.f15860a == 1) {
                    q0<BindInfo, BindInfo.b, c> q0Var = this.f15862c;
                    if (q0Var == null) {
                        ticAssistantRequest.type_ = this.f15861b;
                    } else {
                        ticAssistantRequest.type_ = q0Var.b();
                    }
                }
                if (this.f15860a == 2) {
                    q0<UnbindInfo, UnbindInfo.b, e> q0Var2 = this.f15863d;
                    if (q0Var2 == null) {
                        ticAssistantRequest.type_ = this.f15861b;
                    } else {
                        ticAssistantRequest.type_ = q0Var2.b();
                    }
                }
                if (this.f15860a == 3) {
                    q0<UpdateInfo, UpdateInfo.b, f> q0Var3 = this.f15864e;
                    if (q0Var3 == null) {
                        ticAssistantRequest.type_ = this.f15861b;
                    } else {
                        ticAssistantRequest.type_ = q0Var3.b();
                    }
                }
                ticAssistantRequest.typeCase_ = this.f15860a;
                onBuilt();
                return ticAssistantRequest;
            }

            /* renamed from: d */
            public b clear() {
                super.clear();
                this.f15860a = 0;
                this.f15861b = null;
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
                return ConstantProto.f15817a;
            }

            /* renamed from: i */
            public TicAssistantRequest getDefaultInstanceForType() {
                return TicAssistantRequest.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return ConstantProto.f15818b.e(TicAssistantRequest.class, b.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.f0
            public final boolean isInitialized() {
                return true;
            }

            public b j(BindInfo bindInfo) {
                q0<BindInfo, BindInfo.b, c> q0Var = this.f15862c;
                if (q0Var == null) {
                    if (this.f15860a != 1 || this.f15861b == BindInfo.getDefaultInstance()) {
                        this.f15861b = bindInfo;
                    } else {
                        this.f15861b = BindInfo.newBuilder((BindInfo) this.f15861b).l(bindInfo).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.f15860a == 1) {
                        q0Var.h(bindInfo);
                    }
                    this.f15862c.j(bindInfo);
                }
                this.f15860a = 1;
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x0023  */
            /* renamed from: k */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public b mergeFrom(i iVar, q qVar) throws IOException {
                Throwable th2;
                TicAssistantRequest ticAssistantRequest = null;
                try {
                    try {
                        TicAssistantRequest ticAssistantRequest2 = (TicAssistantRequest) TicAssistantRequest.PARSER.parsePartialFrom(iVar, qVar);
                        if (ticAssistantRequest2 != null) {
                            m(ticAssistantRequest2);
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
                        m(ticAssistantRequest);
                    }
                    throw th2;
                }
            }

            /* renamed from: l */
            public b mergeFrom(d0 d0Var) {
                if (d0Var instanceof TicAssistantRequest) {
                    return m((TicAssistantRequest) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            public b m(TicAssistantRequest ticAssistantRequest) {
                if (ticAssistantRequest == TicAssistantRequest.getDefaultInstance()) {
                    return this;
                }
                int i10 = b.f15872a[ticAssistantRequest.getTypeCase().ordinal()];
                if (i10 == 1) {
                    j(ticAssistantRequest.getBindInfo());
                } else if (i10 == 2) {
                    n(ticAssistantRequest.getUnbindInfo());
                } else if (i10 == 3) {
                    p(ticAssistantRequest.getUpdateInfo());
                }
                onChanged();
                return this;
            }

            public b n(UnbindInfo unbindInfo) {
                q0<UnbindInfo, UnbindInfo.b, e> q0Var = this.f15863d;
                if (q0Var == null) {
                    if (this.f15860a != 2 || this.f15861b == UnbindInfo.getDefaultInstance()) {
                        this.f15861b = unbindInfo;
                    } else {
                        this.f15861b = UnbindInfo.newBuilder((UnbindInfo) this.f15861b).l(unbindInfo).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.f15860a == 2) {
                        q0Var.h(unbindInfo);
                    }
                    this.f15863d.j(unbindInfo);
                }
                this.f15860a = 2;
                return this;
            }

            /* renamed from: o */
            public final b mergeUnknownFields(a1 a1Var) {
                return this;
            }

            public b p(UpdateInfo updateInfo) {
                q0<UpdateInfo, UpdateInfo.b, f> q0Var = this.f15864e;
                if (q0Var == null) {
                    if (this.f15860a != 3 || this.f15861b == UpdateInfo.getDefaultInstance()) {
                        this.f15861b = updateInfo;
                    } else {
                        this.f15861b = UpdateInfo.newBuilder((UpdateInfo) this.f15861b).l(updateInfo).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.f15860a == 3) {
                        q0Var.h(updateInfo);
                    }
                    this.f15864e.j(updateInfo);
                }
                this.f15860a = 3;
                return this;
            }

            /* renamed from: q */
            public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.setField(fieldDescriptor, obj);
            }

            /* renamed from: r */
            public b setRepeatedField2(Descriptors.FieldDescriptor fieldDescriptor, int i10, Object obj) {
                return (b) super.setRepeatedField(fieldDescriptor, i10, obj);
            }

            /* renamed from: s */
            public final b setUnknownFields(a1 a1Var) {
                return this;
            }

            /* synthetic */ b(a aVar) {
                this();
            }

            private b() {
                this.f15860a = 0;
                maybeForceBuilderInitialization();
            }

            private b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.f15860a = 0;
                maybeForceBuilderInitialization();
            }
        }

        /* synthetic */ TicAssistantRequest(i iVar, q qVar, a aVar) throws InvalidProtocolBufferException {
            this(iVar, qVar);
        }

        public static TicAssistantRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return ConstantProto.f15817a;
        }

        public static b newBuilder() {
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

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: c */
        public b newBuilderForType(GeneratedMessageV3.c cVar) {
            return new b(cVar, null);
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

        public BindInfo getBindInfo() {
            if (this.typeCase_ == 1) {
                return (BindInfo) this.type_;
            }
            return BindInfo.getDefaultInstance();
        }

        public c getBindInfoOrBuilder() {
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

        public TypeCase getTypeCase() {
            return TypeCase.forNumber(this.typeCase_);
        }

        public UnbindInfo getUnbindInfo() {
            if (this.typeCase_ == 2) {
                return (UnbindInfo) this.type_;
            }
            return UnbindInfo.getDefaultInstance();
        }

        public e getUnbindInfoOrBuilder() {
            if (this.typeCase_ == 2) {
                return (UnbindInfo) this.type_;
            }
            return UnbindInfo.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.g0
        public final a1 getUnknownFields() {
            return a1.c();
        }

        public UpdateInfo getUpdateInfo() {
            if (this.typeCase_ == 3) {
                return (UpdateInfo) this.type_;
            }
            return UpdateInfo.getDefaultInstance();
        }

        public f getUpdateInfoOrBuilder() {
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
            return ConstantProto.f15818b.e(TicAssistantRequest.class, b.class);
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

        /* synthetic */ TicAssistantRequest(GeneratedMessageV3.b bVar, a aVar) {
            this(bVar);
        }

        public static b newBuilder(TicAssistantRequest ticAssistantRequest) {
            return DEFAULT_INSTANCE.toBuilder().m(ticAssistantRequest);
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
        public b toBuilder() {
            return this == DEFAULT_INSTANCE ? new b((a) null) : new b((a) null).m(this);
        }

        public static TicAssistantRequest parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b newBuilderForType() {
            return newBuilder();
        }

        public static TicAssistantRequest parseFrom(InputStream inputStream) throws IOException {
            return (TicAssistantRequest) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
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
                            UpdateInfo.b bVar = null;
                            BindInfo.b builder = null;
                            UnbindInfo.b builder2 = null;
                            if (F == 10) {
                                builder = this.typeCase_ == 1 ? ((BindInfo) this.type_).toBuilder() : builder;
                                e0 v10 = iVar.v(BindInfo.parser(), qVar);
                                this.type_ = v10;
                                if (builder != null) {
                                    builder.l((BindInfo) v10);
                                    this.type_ = builder.buildPartial();
                                }
                                this.typeCase_ = 1;
                            } else if (F == 18) {
                                builder2 = this.typeCase_ == 2 ? ((UnbindInfo) this.type_).toBuilder() : builder2;
                                e0 v11 = iVar.v(UnbindInfo.parser(), qVar);
                                this.type_ = v11;
                                if (builder2 != null) {
                                    builder2.l((UnbindInfo) v11);
                                    this.type_ = builder2.buildPartial();
                                }
                                this.typeCase_ = 2;
                            } else if (F == 26) {
                                bVar = this.typeCase_ == 3 ? ((UpdateInfo) this.type_).toBuilder() : bVar;
                                e0 v12 = iVar.v(UpdateInfo.parser(), qVar);
                                this.type_ = v12;
                                if (bVar != null) {
                                    bVar.l((UpdateInfo) v12);
                                    this.type_ = bVar.buildPartial();
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
    public static final class TicAssistantResponse extends GeneratedMessageV3 implements g0 {
        public static final int ERR_CODE_FIELD_NUMBER = 2;
        public static final int ERR_MSG_FIELD_NUMBER = 3;
        public static final int OK_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private int errCode_;
        private volatile Object errMsg_;
        private byte memoizedIsInitialized;
        private boolean ok_;
        private static final TicAssistantResponse DEFAULT_INSTANCE = new TicAssistantResponse();
        private static final l0<TicAssistantResponse> PARSER = new a();

        /* loaded from: classes2.dex */
        class a extends com.google.protobuf.c<TicAssistantResponse> {
            a() {
            }

            /* renamed from: a */
            public TicAssistantResponse parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
                return new TicAssistantResponse(iVar, qVar, null);
            }
        }

        /* loaded from: classes2.dex */
        public static final class b extends GeneratedMessageV3.b<b> implements g0 {

            /* renamed from: a  reason: collision with root package name */
            private boolean f15865a;

            /* renamed from: b  reason: collision with root package name */
            private int f15866b;

            /* renamed from: c  reason: collision with root package name */
            private Object f15867c;

            /* synthetic */ b(GeneratedMessageV3.c cVar, a aVar) {
                this(cVar);
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            /* renamed from: a */
            public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.addRepeatedField(fieldDescriptor, obj);
            }

            /* renamed from: b */
            public TicAssistantResponse build() {
                TicAssistantResponse c10 = buildPartial();
                if (c10.isInitialized()) {
                    return c10;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) c10);
            }

            /* renamed from: c */
            public TicAssistantResponse buildPartial() {
                TicAssistantResponse ticAssistantResponse = new TicAssistantResponse(this, (a) null);
                ticAssistantResponse.ok_ = this.f15865a;
                ticAssistantResponse.errCode_ = this.f15866b;
                ticAssistantResponse.errMsg_ = this.f15867c;
                onBuilt();
                return ticAssistantResponse;
            }

            /* renamed from: d */
            public b clear() {
                super.clear();
                this.f15865a = false;
                this.f15866b = 0;
                this.f15867c = "";
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
                return ConstantProto.f15819c;
            }

            /* renamed from: i */
            public TicAssistantResponse getDefaultInstanceForType() {
                return TicAssistantResponse.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return ConstantProto.f15820d.e(TicAssistantResponse.class, b.class);
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
            public b mergeFrom(i iVar, q qVar) throws IOException {
                Throwable th2;
                TicAssistantResponse ticAssistantResponse = null;
                try {
                    try {
                        TicAssistantResponse ticAssistantResponse2 = (TicAssistantResponse) TicAssistantResponse.PARSER.parsePartialFrom(iVar, qVar);
                        if (ticAssistantResponse2 != null) {
                            l(ticAssistantResponse2);
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
                        l(ticAssistantResponse);
                    }
                    throw th2;
                }
            }

            /* renamed from: k */
            public b mergeFrom(d0 d0Var) {
                if (d0Var instanceof TicAssistantResponse) {
                    return l((TicAssistantResponse) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            public b l(TicAssistantResponse ticAssistantResponse) {
                if (ticAssistantResponse == TicAssistantResponse.getDefaultInstance()) {
                    return this;
                }
                if (ticAssistantResponse.getOk()) {
                    p(ticAssistantResponse.getOk());
                }
                if (ticAssistantResponse.getErrCode() != 0) {
                    n(ticAssistantResponse.getErrCode());
                }
                if (!ticAssistantResponse.getErrMsg().isEmpty()) {
                    this.f15867c = ticAssistantResponse.errMsg_;
                    onChanged();
                }
                onChanged();
                return this;
            }

            /* renamed from: m */
            public final b mergeUnknownFields(a1 a1Var) {
                return this;
            }

            public b n(int i10) {
                this.f15866b = i10;
                onChanged();
                return this;
            }

            /* renamed from: o */
            public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.setField(fieldDescriptor, obj);
            }

            public b p(boolean z10) {
                this.f15865a = z10;
                onChanged();
                return this;
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
                this.f15867c = "";
                maybeForceBuilderInitialization();
            }

            private b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.f15867c = "";
                maybeForceBuilderInitialization();
            }
        }

        /* synthetic */ TicAssistantResponse(i iVar, q qVar, a aVar) throws InvalidProtocolBufferException {
            this(iVar, qVar);
        }

        public static TicAssistantResponse getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return ConstantProto.f15819c;
        }

        public static b newBuilder() {
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

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: g */
        public b newBuilderForType(GeneratedMessageV3.c cVar) {
            return new b(cVar, null);
        }

        public int getErrCode() {
            return this.errCode_;
        }

        public String getErrMsg() {
            Object obj = this.errMsg_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.errMsg_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getErrMsgBytes() {
            Object obj = this.errMsg_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.errMsg_ = copyFromUtf8;
            return copyFromUtf8;
        }

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
            return ConstantProto.f15820d.e(TicAssistantResponse.class, b.class);
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

        /* synthetic */ TicAssistantResponse(GeneratedMessageV3.b bVar, a aVar) {
            this(bVar);
        }

        public static b newBuilder(TicAssistantResponse ticAssistantResponse) {
            return DEFAULT_INSTANCE.toBuilder().l(ticAssistantResponse);
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
        public b toBuilder() {
            return this == DEFAULT_INSTANCE ? new b((a) null) : new b((a) null).l(this);
        }

        public static TicAssistantResponse parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b newBuilderForType() {
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
    public static final class UnbindInfo extends GeneratedMessageV3 implements e {
        public static final int DEVICE_ID_FIELD_NUMBER = 1;
        public static final int WWID_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private volatile Object deviceId_;
        private byte memoizedIsInitialized;
        private volatile Object wwid_;
        private static final UnbindInfo DEFAULT_INSTANCE = new UnbindInfo();
        private static final l0<UnbindInfo> PARSER = new a();

        /* loaded from: classes2.dex */
        class a extends com.google.protobuf.c<UnbindInfo> {
            a() {
            }

            /* renamed from: a */
            public UnbindInfo parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
                return new UnbindInfo(iVar, qVar, null);
            }
        }

        /* loaded from: classes2.dex */
        public static final class b extends GeneratedMessageV3.b<b> implements e {

            /* renamed from: a  reason: collision with root package name */
            private Object f15868a;

            /* renamed from: b  reason: collision with root package name */
            private Object f15869b;

            /* synthetic */ b(GeneratedMessageV3.c cVar, a aVar) {
                this(cVar);
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            /* renamed from: a */
            public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.addRepeatedField(fieldDescriptor, obj);
            }

            /* renamed from: b */
            public UnbindInfo build() {
                UnbindInfo c10 = buildPartial();
                if (c10.isInitialized()) {
                    return c10;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) c10);
            }

            /* renamed from: c */
            public UnbindInfo buildPartial() {
                UnbindInfo unbindInfo = new UnbindInfo(this, (a) null);
                unbindInfo.deviceId_ = this.f15868a;
                unbindInfo.wwid_ = this.f15869b;
                onBuilt();
                return unbindInfo;
            }

            /* renamed from: d */
            public b clear() {
                super.clear();
                this.f15868a = "";
                this.f15869b = "";
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
                return ConstantProto.f15823g;
            }

            /* renamed from: i */
            public UnbindInfo getDefaultInstanceForType() {
                return UnbindInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return ConstantProto.f15824h.e(UnbindInfo.class, b.class);
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
            public b mergeFrom(i iVar, q qVar) throws IOException {
                Throwable th2;
                UnbindInfo unbindInfo = null;
                try {
                    try {
                        UnbindInfo unbindInfo2 = (UnbindInfo) UnbindInfo.PARSER.parsePartialFrom(iVar, qVar);
                        if (unbindInfo2 != null) {
                            l(unbindInfo2);
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
                        l(unbindInfo);
                    }
                    throw th2;
                }
            }

            /* renamed from: k */
            public b mergeFrom(d0 d0Var) {
                if (d0Var instanceof UnbindInfo) {
                    return l((UnbindInfo) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            public b l(UnbindInfo unbindInfo) {
                if (unbindInfo == UnbindInfo.getDefaultInstance()) {
                    return this;
                }
                if (!unbindInfo.getDeviceId().isEmpty()) {
                    this.f15868a = unbindInfo.deviceId_;
                    onChanged();
                }
                if (!unbindInfo.getWwid().isEmpty()) {
                    this.f15869b = unbindInfo.wwid_;
                    onChanged();
                }
                onChanged();
                return this;
            }

            /* renamed from: m */
            public final b mergeUnknownFields(a1 a1Var) {
                return this;
            }

            /* renamed from: n */
            public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.setField(fieldDescriptor, obj);
            }

            /* renamed from: o */
            public b setRepeatedField2(Descriptors.FieldDescriptor fieldDescriptor, int i10, Object obj) {
                return (b) super.setRepeatedField(fieldDescriptor, i10, obj);
            }

            /* renamed from: p */
            public final b setUnknownFields(a1 a1Var) {
                return this;
            }

            /* synthetic */ b(a aVar) {
                this();
            }

            private b() {
                this.f15868a = "";
                this.f15869b = "";
                maybeForceBuilderInitialization();
            }

            private b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.f15868a = "";
                this.f15869b = "";
                maybeForceBuilderInitialization();
            }
        }

        /* synthetic */ UnbindInfo(i iVar, q qVar, a aVar) throws InvalidProtocolBufferException {
            this(iVar, qVar);
        }

        public static UnbindInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return ConstantProto.f15823g;
        }

        public static b newBuilder() {
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

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: g */
        public b newBuilderForType(GeneratedMessageV3.c cVar) {
            return new b(cVar, null);
        }

        public String getDeviceId() {
            Object obj = this.deviceId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.deviceId_ = stringUtf8;
            return stringUtf8;
        }

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

        public String getWwid() {
            Object obj = this.wwid_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.wwid_ = stringUtf8;
            return stringUtf8;
        }

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
            return ConstantProto.f15824h.e(UnbindInfo.class, b.class);
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

        /* synthetic */ UnbindInfo(GeneratedMessageV3.b bVar, a aVar) {
            this(bVar);
        }

        public static b newBuilder(UnbindInfo unbindInfo) {
            return DEFAULT_INSTANCE.toBuilder().l(unbindInfo);
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
        public b toBuilder() {
            return this == DEFAULT_INSTANCE ? new b((a) null) : new b((a) null).l(this);
        }

        public static UnbindInfo parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b newBuilderForType() {
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
    public static final class UpdateInfo extends GeneratedMessageV3 implements f {
        public static final int DEVICE_ID_FIELD_NUMBER = 1;
        public static final int DEVICE_NAME_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private volatile Object deviceId_;
        private volatile Object deviceName_;
        private byte memoizedIsInitialized;
        private static final UpdateInfo DEFAULT_INSTANCE = new UpdateInfo();
        private static final l0<UpdateInfo> PARSER = new a();

        /* loaded from: classes2.dex */
        class a extends com.google.protobuf.c<UpdateInfo> {
            a() {
            }

            /* renamed from: a */
            public UpdateInfo parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
                return new UpdateInfo(iVar, qVar, null);
            }
        }

        /* loaded from: classes2.dex */
        public static final class b extends GeneratedMessageV3.b<b> implements f {

            /* renamed from: a  reason: collision with root package name */
            private Object f15870a;

            /* renamed from: b  reason: collision with root package name */
            private Object f15871b;

            /* synthetic */ b(GeneratedMessageV3.c cVar, a aVar) {
                this(cVar);
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            /* renamed from: a */
            public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.addRepeatedField(fieldDescriptor, obj);
            }

            /* renamed from: b */
            public UpdateInfo build() {
                UpdateInfo c10 = buildPartial();
                if (c10.isInitialized()) {
                    return c10;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) c10);
            }

            /* renamed from: c */
            public UpdateInfo buildPartial() {
                UpdateInfo updateInfo = new UpdateInfo(this, (a) null);
                updateInfo.deviceId_ = this.f15870a;
                updateInfo.deviceName_ = this.f15871b;
                onBuilt();
                return updateInfo;
            }

            /* renamed from: d */
            public b clear() {
                super.clear();
                this.f15870a = "";
                this.f15871b = "";
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
                return ConstantProto.f15825i;
            }

            /* renamed from: i */
            public UpdateInfo getDefaultInstanceForType() {
                return UpdateInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return ConstantProto.f15826j.e(UpdateInfo.class, b.class);
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
            public b mergeFrom(i iVar, q qVar) throws IOException {
                Throwable th2;
                UpdateInfo updateInfo = null;
                try {
                    try {
                        UpdateInfo updateInfo2 = (UpdateInfo) UpdateInfo.PARSER.parsePartialFrom(iVar, qVar);
                        if (updateInfo2 != null) {
                            l(updateInfo2);
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
                        l(updateInfo);
                    }
                    throw th2;
                }
            }

            /* renamed from: k */
            public b mergeFrom(d0 d0Var) {
                if (d0Var instanceof UpdateInfo) {
                    return l((UpdateInfo) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            public b l(UpdateInfo updateInfo) {
                if (updateInfo == UpdateInfo.getDefaultInstance()) {
                    return this;
                }
                if (!updateInfo.getDeviceId().isEmpty()) {
                    this.f15870a = updateInfo.deviceId_;
                    onChanged();
                }
                if (!updateInfo.getDeviceName().isEmpty()) {
                    this.f15871b = updateInfo.deviceName_;
                    onChanged();
                }
                onChanged();
                return this;
            }

            /* renamed from: m */
            public final b mergeUnknownFields(a1 a1Var) {
                return this;
            }

            /* renamed from: n */
            public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.setField(fieldDescriptor, obj);
            }

            /* renamed from: o */
            public b setRepeatedField2(Descriptors.FieldDescriptor fieldDescriptor, int i10, Object obj) {
                return (b) super.setRepeatedField(fieldDescriptor, i10, obj);
            }

            /* renamed from: p */
            public final b setUnknownFields(a1 a1Var) {
                return this;
            }

            /* synthetic */ b(a aVar) {
                this();
            }

            private b() {
                this.f15870a = "";
                this.f15871b = "";
                maybeForceBuilderInitialization();
            }

            private b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.f15870a = "";
                this.f15871b = "";
                maybeForceBuilderInitialization();
            }
        }

        /* synthetic */ UpdateInfo(i iVar, q qVar, a aVar) throws InvalidProtocolBufferException {
            this(iVar, qVar);
        }

        public static UpdateInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return ConstantProto.f15825i;
        }

        public static b newBuilder() {
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

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: g */
        public b newBuilderForType(GeneratedMessageV3.c cVar) {
            return new b(cVar, null);
        }

        public String getDeviceId() {
            Object obj = this.deviceId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.deviceId_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getDeviceIdBytes() {
            Object obj = this.deviceId_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.deviceId_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public String getDeviceName() {
            Object obj = this.deviceName_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.deviceName_ = stringUtf8;
            return stringUtf8;
        }

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
            return ConstantProto.f15826j.e(UpdateInfo.class, b.class);
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

        /* synthetic */ UpdateInfo(GeneratedMessageV3.b bVar, a aVar) {
            this(bVar);
        }

        public static b newBuilder(UpdateInfo updateInfo) {
            return DEFAULT_INSTANCE.toBuilder().l(updateInfo);
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
        public b toBuilder() {
            return this == DEFAULT_INSTANCE ? new b((a) null) : new b((a) null).l(this);
        }

        public static UpdateInfo parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b newBuilderForType() {
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements Descriptors.FileDescriptor.a {
        a() {
        }

        @Override // com.google.protobuf.Descriptors.FileDescriptor.a
        public o assignDescriptors(Descriptors.FileDescriptor fileDescriptor) {
            Descriptors.FileDescriptor unused = ConstantProto.f15835s = fileDescriptor;
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f15872a;

        static {
            int[] iArr = new int[TicAssistantRequest.TypeCase.values().length];
            f15872a = iArr;
            try {
                iArr[TicAssistantRequest.TypeCase.BIND_INFO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f15872a[TicAssistantRequest.TypeCase.UNBIND_INFO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f15872a[TicAssistantRequest.TypeCase.UPDATE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f15872a[TicAssistantRequest.TypeCase.TYPE_NOT_SET.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface c extends g0 {
    }

    /* loaded from: classes2.dex */
    public interface d extends g0 {
    }

    /* loaded from: classes2.dex */
    public interface e extends g0 {
    }

    /* loaded from: classes2.dex */
    public interface f extends g0 {
    }

    static {
        Descriptors.FileDescriptor.q(new String[]{"\n\u0018becommon/constants.proto\u0012\u0010mobvoi.be.common\"??\u0001\n\u0013TicAssistantRequest\u0012/\n\tbind_info\u0018\u0001 \u0001(\u000b2\u001a.mobvoi.be.common.BindInfoH\u0000\u00123\n\u000bunbind_info\u0018\u0002 \u0001(\u000b2\u001c.mobvoi.be.common.UnbindInfoH\u0000\u00123\n\u000bupdate_info\u0018\u0003 \u0001(\u000b2\u001c.mobvoi.be.common.UpdateInfoH\u0000B\u0006\n\u0004type\"E\n\u0014TicAssistantResponse\u0012\n\n\u0002ok\u0018\u0001 \u0001(\b\u0012\u0010\n\berr_code\u0018\u0002 \u0001(\u0005\u0012\u000f\n\u0007err_msg\u0018\u0003 \u0001(\t\"??\u0002\n\bBindInfo\u0012\f\n\u0004wwid\u0018\u0001 \u0001(\t\u0012\u0011\n\tdevice_id\u0018\u0002 \u0001(\t\u00121\n\u000bdevice_type\u0018\u0003 \u0001(\u000e2\u001c.mobvoi.be.common.DeviceType\u0012", "\u0013\n\u000bdevice_name\u0018\u0004 \u0001(\t\u0012\r\n\u0005model\u0018\u0005 \u0001(\t\u0012\u0019\n\u0011bluetooth_address\u0018\u0006 \u0001(\t\u0012\u0014\n\fwifi_address\u0018\u0007 \u0001(\t\u0012\u0011\n\tdevice_sn\u0018\b \u0001(\t\u0012;\n\ronline_status\u0018\t \u0001(\u000e2$.mobvoi.be.common.DeviceOnlineStatus\u0012\u0012\n\ncreated_at\u0018\n \u0001(\u0003\u0012\u0012\n\nupdated_at\u0018\u000b \u0001(\u0003\u0012\u0014\n\fconnected_qq\u0018\f \u0001(\b\u0012\u0015\n\rsales_channel\u0018\r \u0001(\t\"-\n\nUnbindInfo\u0012\u0011\n\tdevice_id\u0018\u0001 \u0001(\t\u0012\f\n\u0004wwid\u0018\u0002 \u0001(\t\"4\n\nUpdateInfo\u0012\u0011\n\tdevice_id\u0018\u0001 \u0001(\t\u0012\u0013\n\u000bdevice_name\u0018\u0002 \u0001(\t\"A\n\u0010BindInfoResponse\u0012-\n\tbind_info\u0018\u0001 \u0003(\u000b2\u001a.mobvoi.b", "e.common.BindInfo\"I\n\rHotelBindResp\u00128\n\u000fhotel_bind_data\u0018\u0001 \u0003(\u000b2\u001f.mobvoi.be.common.HotelBindData\"\"\n\u000eHotelAdminResp\u0012\u0010\n\bis_admin\u0018\u0001 \u0001(\b\"`\n\rHotelBindData\u0012-\n\tbind_info\u0018\u0001 \u0001(\u000b2\u001a.mobvoi.be.common.BindInfo\u0012\r\n\u0005token\u0018\u0002 \u0001(\t\u0012\u0011\n\tsub_token\u0018\u0003 \u0001(\t*C\n\u0012DeviceOnlineStatus\u0012\u0012\n\u000eUNKNOWN_STATUS\u0010\u0000\u0012\f\n\bOFF_LINE\u0010\u0001\u0012\u000b\n\u0007ON_LINE\u0010\u0002*??\u0002\n\nDeviceType\u0012\u0017\n\u0013UNKNOWN_DEVICE_TYPE\u0010\u0000\u0012\r\n\tTIC_WATCH\u0010\u0001\u0012\u000e\n\nTIC_MIRROR\u0010\u0002\u0012\f\n\bTIC_HOME\u0010\u0003\u0012\u0011\n\rTIC_ASSISTANT\u0010\u0004\u0012", "\u0015\n\u0011TIC_ASSISTANT_IOS\u0010\u0005\u0012\u0011\n\rTIC_HOME_MINI\u0010\u0006\u0012\f\n\bTIC_PODS\u0010\u0007\u0012\f\n\bTIC_BAND\u0010\b\u0012\f\n\bTIC_KIDS\u0010\t\u0012\f\n\bTIC_LIFE\u0010\n\u0012\u0015\n\u0011TIC_ASSISTANT_OEM\u0010\u000b\u0012\u0019\n\u0015TIC_KIDS_ON_TIC_WATCH\u0010\f\u0012\f\n\bTIC_MEET\u0010\r\u0012\u0015\n\u0011MOBVOI_AIRECORDER\u0010\u000e\u0012\u0019\n\u0015MOBVOI_AISPEAKERPHONE\u0010\u000f*G\n\u0007Channel\u0012\u0013\n\u000fUNKNOWN_CHANNEL\u0010\u0000\u0012\u0007\n\u0003DEV\u0010\u0001\u0012\b\n\u0004BETA\u0010\u0002\u0012\u000b\n\u0007RELEASE\u0010\u0003\u0012\u0007\n\u0003ALL\u0010\u0004B%\n\u0014com.mobvoi.be.commonB\rConstantProtob\u0006proto3"}, new Descriptors.FileDescriptor[0], new a());
        Descriptors.b bVar = t().j().get(0);
        f15817a = bVar;
        f15818b = new GeneratedMessageV3.e(bVar, new String[]{"BindInfo", "UnbindInfo", "UpdateInfo", "Type"});
        Descriptors.b bVar2 = t().j().get(1);
        f15819c = bVar2;
        f15820d = new GeneratedMessageV3.e(bVar2, new String[]{"Ok", "ErrCode", "ErrMsg"});
        Descriptors.b bVar3 = t().j().get(2);
        f15821e = bVar3;
        f15822f = new GeneratedMessageV3.e(bVar3, new String[]{"Wwid", "DeviceId", "DeviceType", "DeviceName", "Model", "BluetoothAddress", "WifiAddress", "DeviceSn", "OnlineStatus", "CreatedAt", "UpdatedAt", "ConnectedQq", "SalesChannel"});
        Descriptors.b bVar4 = t().j().get(3);
        f15823g = bVar4;
        f15824h = new GeneratedMessageV3.e(bVar4, new String[]{"DeviceId", "Wwid"});
        Descriptors.b bVar5 = t().j().get(4);
        f15825i = bVar5;
        f15826j = new GeneratedMessageV3.e(bVar5, new String[]{"DeviceId", "DeviceName"});
        Descriptors.b bVar6 = t().j().get(5);
        f15827k = bVar6;
        f15828l = new GeneratedMessageV3.e(bVar6, new String[]{"BindInfo"});
        Descriptors.b bVar7 = t().j().get(6);
        f15829m = bVar7;
        f15830n = new GeneratedMessageV3.e(bVar7, new String[]{"HotelBindData"});
        Descriptors.b bVar8 = t().j().get(7);
        f15831o = bVar8;
        f15832p = new GeneratedMessageV3.e(bVar8, new String[]{"IsAdmin"});
        Descriptors.b bVar9 = t().j().get(8);
        f15833q = bVar9;
        f15834r = new GeneratedMessageV3.e(bVar9, new String[]{"BindInfo", "Token", "SubToken"});
    }

    public static Descriptors.FileDescriptor t() {
        return f15835s;
    }
}
