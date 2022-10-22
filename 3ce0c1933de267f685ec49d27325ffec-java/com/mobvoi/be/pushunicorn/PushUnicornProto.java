package com.mobvoi.be.pushunicorn;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.a;
import com.google.protobuf.a1;
import com.google.protobuf.c;
import com.google.protobuf.d0;
import com.google.protobuf.g0;
import com.google.protobuf.i;
import com.google.protobuf.l0;
import com.google.protobuf.o;
import com.google.protobuf.q;
import com.mobvoi.be.common.ConstantProto;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
/* loaded from: classes2.dex */
public final class PushUnicornProto {

    /* renamed from: a  reason: collision with root package name */
    private static final Descriptors.b f15922a;

    /* renamed from: b  reason: collision with root package name */
    private static final GeneratedMessageV3.e f15923b;

    /* renamed from: c  reason: collision with root package name */
    private static final Descriptors.b f15924c;

    /* renamed from: d  reason: collision with root package name */
    private static final GeneratedMessageV3.e f15925d;

    /* renamed from: e  reason: collision with root package name */
    private static final Descriptors.b f15926e;

    /* renamed from: f  reason: collision with root package name */
    private static final GeneratedMessageV3.e f15927f;

    /* renamed from: g  reason: collision with root package name */
    private static Descriptors.FileDescriptor f15928g;

    /* loaded from: classes2.dex */
    public static final class UserPushRequest extends GeneratedMessageV3 implements g0 {
        public static final int CHANNEL_FIELD_NUMBER = 5;
        public static final int CLIENT_ID_FIELD_NUMBER = 4;
        public static final int DEVICE_ID_FIELD_NUMBER = 3;
        public static final int DEVICE_TOKEN_ANDROID_FIELD_NUMBER = 6;
        public static final int DEVICE_TOKEN_IOS_FIELD_NUMBER = 7;
        public static final int DEVICE_TYPE_FIELD_NUMBER = 2;
        public static final int WWID_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private int channel_;
        private volatile Object clientId_;
        private volatile Object deviceId_;
        private volatile Object deviceTokenAndroid_;
        private volatile Object deviceTokenIos_;
        private int deviceType_;
        private byte memoizedIsInitialized;
        private volatile Object wwid_;
        private static final UserPushRequest DEFAULT_INSTANCE = new UserPushRequest();
        private static final l0<UserPushRequest> PARSER = new a();

        /* loaded from: classes2.dex */
        class a extends c<UserPushRequest> {
            a() {
            }

            /* renamed from: a */
            public UserPushRequest parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
                return new UserPushRequest(iVar, qVar, null);
            }
        }

        /* loaded from: classes2.dex */
        public static final class b extends GeneratedMessageV3.b<b> implements g0 {

            /* renamed from: a  reason: collision with root package name */
            private Object f15929a;

            /* renamed from: b  reason: collision with root package name */
            private int f15930b;

            /* renamed from: c  reason: collision with root package name */
            private int f15931c;

            /* renamed from: d  reason: collision with root package name */
            private Object f15932d;

            /* renamed from: e  reason: collision with root package name */
            private Object f15933e;

            /* renamed from: f  reason: collision with root package name */
            private Object f15934f;

            /* renamed from: g  reason: collision with root package name */
            private Object f15935g;

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
            public UserPushRequest build() {
                UserPushRequest c10 = buildPartial();
                if (c10.isInitialized()) {
                    return c10;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) c10);
            }

            /* renamed from: c */
            public UserPushRequest buildPartial() {
                UserPushRequest userPushRequest = new UserPushRequest(this, (a) null);
                userPushRequest.wwid_ = this.f15929a;
                userPushRequest.deviceType_ = this.f15930b;
                userPushRequest.channel_ = this.f15931c;
                userPushRequest.deviceId_ = this.f15932d;
                userPushRequest.clientId_ = this.f15933e;
                userPushRequest.deviceTokenAndroid_ = this.f15934f;
                userPushRequest.deviceTokenIos_ = this.f15935g;
                onBuilt();
                return userPushRequest;
            }

            /* renamed from: d */
            public b clear() {
                super.clear();
                this.f15929a = "";
                this.f15930b = 0;
                this.f15931c = 0;
                this.f15932d = "";
                this.f15933e = "";
                this.f15934f = "";
                this.f15935g = "";
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
                return PushUnicornProto.f15922a;
            }

            /* renamed from: i */
            public UserPushRequest getDefaultInstanceForType() {
                return UserPushRequest.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return PushUnicornProto.f15923b.e(UserPushRequest.class, b.class);
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
                UserPushRequest userPushRequest = null;
                try {
                    try {
                        UserPushRequest userPushRequest2 = (UserPushRequest) UserPushRequest.PARSER.parsePartialFrom(iVar, qVar);
                        if (userPushRequest2 != null) {
                            l(userPushRequest2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e10) {
                        userPushRequest = (UserPushRequest) e10.getUnfinishedMessage();
                        try {
                            throw e10.unwrapIOException();
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (userPushRequest != null) {
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (userPushRequest != null) {
                        l(userPushRequest);
                    }
                    throw th2;
                }
            }

            /* renamed from: k */
            public b mergeFrom(d0 d0Var) {
                if (d0Var instanceof UserPushRequest) {
                    return l((UserPushRequest) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            public b l(UserPushRequest userPushRequest) {
                if (userPushRequest == UserPushRequest.getDefaultInstance()) {
                    return this;
                }
                if (!userPushRequest.getWwid().isEmpty()) {
                    this.f15929a = userPushRequest.wwid_;
                    onChanged();
                }
                if (userPushRequest.deviceType_ != 0) {
                    r(userPushRequest.getDeviceTypeValue());
                }
                if (userPushRequest.channel_ != 0) {
                    n(userPushRequest.getChannelValue());
                }
                if (!userPushRequest.getDeviceId().isEmpty()) {
                    this.f15932d = userPushRequest.deviceId_;
                    onChanged();
                }
                if (!userPushRequest.getClientId().isEmpty()) {
                    this.f15933e = userPushRequest.clientId_;
                    onChanged();
                }
                if (!userPushRequest.getDeviceTokenAndroid().isEmpty()) {
                    this.f15934f = userPushRequest.deviceTokenAndroid_;
                    onChanged();
                }
                if (!userPushRequest.getDeviceTokenIos().isEmpty()) {
                    this.f15935g = userPushRequest.deviceTokenIos_;
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
                this.f15931c = i10;
                onChanged();
                return this;
            }

            public b o(String str) {
                Objects.requireNonNull(str);
                this.f15932d = str;
                onChanged();
                return this;
            }

            public b p(String str) {
                Objects.requireNonNull(str);
                this.f15934f = str;
                onChanged();
                return this;
            }

            public b q(ConstantProto.DeviceType deviceType) {
                Objects.requireNonNull(deviceType);
                this.f15930b = deviceType.getNumber();
                onChanged();
                return this;
            }

            public b r(int i10) {
                this.f15930b = i10;
                onChanged();
                return this;
            }

            /* renamed from: s */
            public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.setField(fieldDescriptor, obj);
            }

            /* renamed from: t */
            public b setRepeatedField2(Descriptors.FieldDescriptor fieldDescriptor, int i10, Object obj) {
                return (b) super.setRepeatedField(fieldDescriptor, i10, obj);
            }

            /* renamed from: u */
            public final b setUnknownFields(a1 a1Var) {
                return this;
            }

            public b v(String str) {
                Objects.requireNonNull(str);
                this.f15929a = str;
                onChanged();
                return this;
            }

            /* synthetic */ b(a aVar) {
                this();
            }

            private b() {
                this.f15929a = "";
                this.f15930b = 0;
                this.f15931c = 0;
                this.f15932d = "";
                this.f15933e = "";
                this.f15934f = "";
                this.f15935g = "";
                maybeForceBuilderInitialization();
            }

            private b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.f15929a = "";
                this.f15930b = 0;
                this.f15931c = 0;
                this.f15932d = "";
                this.f15933e = "";
                this.f15934f = "";
                this.f15935g = "";
                maybeForceBuilderInitialization();
            }
        }

        /* synthetic */ UserPushRequest(i iVar, q qVar, a aVar) throws InvalidProtocolBufferException {
            this(iVar, qVar);
        }

        public static UserPushRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return PushUnicornProto.f15922a;
        }

        public static b newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static UserPushRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (UserPushRequest) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static UserPushRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static l0<UserPushRequest> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof UserPushRequest)) {
                return super.equals(obj);
            }
            UserPushRequest userPushRequest = (UserPushRequest) obj;
            return ((((((getWwid().equals(userPushRequest.getWwid())) && this.deviceType_ == userPushRequest.deviceType_) && this.channel_ == userPushRequest.channel_) && getDeviceId().equals(userPushRequest.getDeviceId())) && getClientId().equals(userPushRequest.getClientId())) && getDeviceTokenAndroid().equals(userPushRequest.getDeviceTokenAndroid())) && getDeviceTokenIos().equals(userPushRequest.getDeviceTokenIos());
        }

        public ConstantProto.Channel getChannel() {
            ConstantProto.Channel valueOf = ConstantProto.Channel.valueOf(this.channel_);
            return valueOf == null ? ConstantProto.Channel.UNRECOGNIZED : valueOf;
        }

        public int getChannelValue() {
            return this.channel_;
        }

        public String getClientId() {
            Object obj = this.clientId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.clientId_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getClientIdBytes() {
            Object obj = this.clientId_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.clientId_ = copyFromUtf8;
            return copyFromUtf8;
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

        public String getDeviceTokenAndroid() {
            Object obj = this.deviceTokenAndroid_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.deviceTokenAndroid_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getDeviceTokenAndroidBytes() {
            Object obj = this.deviceTokenAndroid_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.deviceTokenAndroid_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public String getDeviceTokenIos() {
            Object obj = this.deviceTokenIos_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.deviceTokenIos_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getDeviceTokenIosBytes() {
            Object obj = this.deviceTokenIos_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.deviceTokenIos_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public ConstantProto.DeviceType getDeviceType() {
            ConstantProto.DeviceType valueOf = ConstantProto.DeviceType.valueOf(this.deviceType_);
            return valueOf == null ? ConstantProto.DeviceType.UNRECOGNIZED : valueOf;
        }

        public int getDeviceTypeValue() {
            return this.deviceType_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public l0<UserPushRequest> getParserForType() {
            return PARSER;
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
            if (this.deviceType_ != ConstantProto.DeviceType.UNKNOWN_DEVICE_TYPE.getNumber()) {
                i11 += CodedOutputStream.l(2, this.deviceType_);
            }
            if (!getDeviceIdBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(3, this.deviceId_);
            }
            if (!getClientIdBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(4, this.clientId_);
            }
            if (this.channel_ != ConstantProto.Channel.UNKNOWN_CHANNEL.getNumber()) {
                i11 += CodedOutputStream.l(5, this.channel_);
            }
            if (!getDeviceTokenAndroidBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(6, this.deviceTokenAndroid_);
            }
            if (!getDeviceTokenIosBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(7, this.deviceTokenIos_);
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
            int hashCode = ((((((((((((((((((((((((((((((779 + getDescriptorForType().hashCode()) * 37) + 1) * 53) + getWwid().hashCode()) * 37) + 2) * 53) + this.deviceType_) * 37) + 5) * 53) + this.channel_) * 37) + 3) * 53) + getDeviceId().hashCode()) * 37) + 4) * 53) + getClientId().hashCode()) * 37) + 6) * 53) + getDeviceTokenAndroid().hashCode()) * 37) + 7) * 53) + getDeviceTokenIos().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return PushUnicornProto.f15923b.e(UserPushRequest.class, b.class);
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

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: r */
        public b newBuilderForType(GeneratedMessageV3.c cVar) {
            return new b(cVar, null);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (!getWwidBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.wwid_);
            }
            if (this.deviceType_ != ConstantProto.DeviceType.UNKNOWN_DEVICE_TYPE.getNumber()) {
                codedOutputStream.m0(2, this.deviceType_);
            }
            if (!getDeviceIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 3, this.deviceId_);
            }
            if (!getClientIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 4, this.clientId_);
            }
            if (this.channel_ != ConstantProto.Channel.UNKNOWN_CHANNEL.getNumber()) {
                codedOutputStream.m0(5, this.channel_);
            }
            if (!getDeviceTokenAndroidBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 6, this.deviceTokenAndroid_);
            }
            if (!getDeviceTokenIosBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 7, this.deviceTokenIos_);
            }
        }

        /* synthetic */ UserPushRequest(GeneratedMessageV3.b bVar, a aVar) {
            this(bVar);
        }

        public static b newBuilder(UserPushRequest userPushRequest) {
            return DEFAULT_INSTANCE.toBuilder().l(userPushRequest);
        }

        public static UserPushRequest parseFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, qVar);
        }

        private UserPushRequest(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static UserPushRequest parseDelimitedFrom(InputStream inputStream, q qVar) throws IOException {
            return (UserPushRequest) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
        }

        public static UserPushRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
        public UserPushRequest getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b toBuilder() {
            return this == DEFAULT_INSTANCE ? new b((a) null) : new b((a) null).l(this);
        }

        public static UserPushRequest parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b newBuilderForType() {
            return newBuilder();
        }

        private UserPushRequest() {
            this.memoizedIsInitialized = (byte) -1;
            this.wwid_ = "";
            this.deviceType_ = 0;
            this.channel_ = 0;
            this.deviceId_ = "";
            this.clientId_ = "";
            this.deviceTokenAndroid_ = "";
            this.deviceTokenIos_ = "";
        }

        public static UserPushRequest parseFrom(InputStream inputStream) throws IOException {
            return (UserPushRequest) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static UserPushRequest parseFrom(InputStream inputStream, q qVar) throws IOException {
            return (UserPushRequest) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
        }

        public static UserPushRequest parseFrom(i iVar) throws IOException {
            return (UserPushRequest) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
        }

        public static UserPushRequest parseFrom(i iVar, q qVar) throws IOException {
            return (UserPushRequest) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
        }

        private UserPushRequest(i iVar, q qVar) throws InvalidProtocolBufferException {
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
                                    this.deviceType_ = iVar.o();
                                } else if (F == 26) {
                                    this.deviceId_ = iVar.E();
                                } else if (F == 34) {
                                    this.clientId_ = iVar.E();
                                } else if (F == 40) {
                                    this.channel_ = iVar.o();
                                } else if (F == 50) {
                                    this.deviceTokenAndroid_ = iVar.E();
                                } else if (F == 58) {
                                    this.deviceTokenIos_ = iVar.E();
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
    public static final class UserPushResponse extends GeneratedMessageV3 implements g0 {
        public static final int ERR_CODE_FIELD_NUMBER = 1;
        public static final int ERR_MSG_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private int errCode_;
        private volatile Object errMsg_;
        private byte memoizedIsInitialized;
        private static final UserPushResponse DEFAULT_INSTANCE = new UserPushResponse();
        private static final l0<UserPushResponse> PARSER = new a();

        /* loaded from: classes2.dex */
        class a extends c<UserPushResponse> {
            a() {
            }

            /* renamed from: a */
            public UserPushResponse parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
                return new UserPushResponse(iVar, qVar, null);
            }
        }

        /* loaded from: classes2.dex */
        public static final class b extends GeneratedMessageV3.b<b> implements g0 {

            /* renamed from: a  reason: collision with root package name */
            private int f15936a;

            /* renamed from: b  reason: collision with root package name */
            private Object f15937b;

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
            public UserPushResponse build() {
                UserPushResponse c10 = buildPartial();
                if (c10.isInitialized()) {
                    return c10;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) c10);
            }

            /* renamed from: c */
            public UserPushResponse buildPartial() {
                UserPushResponse userPushResponse = new UserPushResponse(this, (a) null);
                userPushResponse.errCode_ = this.f15936a;
                userPushResponse.errMsg_ = this.f15937b;
                onBuilt();
                return userPushResponse;
            }

            /* renamed from: d */
            public b clear() {
                super.clear();
                this.f15936a = 0;
                this.f15937b = "";
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
                return PushUnicornProto.f15926e;
            }

            /* renamed from: i */
            public UserPushResponse getDefaultInstanceForType() {
                return UserPushResponse.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return PushUnicornProto.f15927f.e(UserPushResponse.class, b.class);
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
                UserPushResponse userPushResponse = null;
                try {
                    try {
                        UserPushResponse userPushResponse2 = (UserPushResponse) UserPushResponse.PARSER.parsePartialFrom(iVar, qVar);
                        if (userPushResponse2 != null) {
                            l(userPushResponse2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e10) {
                        userPushResponse = (UserPushResponse) e10.getUnfinishedMessage();
                        try {
                            throw e10.unwrapIOException();
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (userPushResponse != null) {
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (userPushResponse != null) {
                        l(userPushResponse);
                    }
                    throw th2;
                }
            }

            /* renamed from: k */
            public b mergeFrom(d0 d0Var) {
                if (d0Var instanceof UserPushResponse) {
                    return l((UserPushResponse) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            public b l(UserPushResponse userPushResponse) {
                if (userPushResponse == UserPushResponse.getDefaultInstance()) {
                    return this;
                }
                if (userPushResponse.getErrCode() != 0) {
                    n(userPushResponse.getErrCode());
                }
                if (!userPushResponse.getErrMsg().isEmpty()) {
                    this.f15937b = userPushResponse.errMsg_;
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
                this.f15936a = i10;
                onChanged();
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
                this.f15937b = "";
                maybeForceBuilderInitialization();
            }

            private b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.f15937b = "";
                maybeForceBuilderInitialization();
            }
        }

        /* synthetic */ UserPushResponse(i iVar, q qVar, a aVar) throws InvalidProtocolBufferException {
            this(iVar, qVar);
        }

        public static UserPushResponse getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return PushUnicornProto.f15926e;
        }

        public static b newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static UserPushResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (UserPushResponse) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static UserPushResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static l0<UserPushResponse> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof UserPushResponse)) {
                return super.equals(obj);
            }
            UserPushResponse userPushResponse = (UserPushResponse) obj;
            return (getErrCode() == userPushResponse.getErrCode()) && getErrMsg().equals(userPushResponse.getErrMsg());
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

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public l0<UserPushResponse> getParserForType() {
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
            int hashCode = ((((((((((779 + getDescriptorForType().hashCode()) * 37) + 1) * 53) + getErrCode()) * 37) + 2) * 53) + getErrMsg().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return PushUnicornProto.f15927f.e(UserPushResponse.class, b.class);
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
        }

        /* synthetic */ UserPushResponse(GeneratedMessageV3.b bVar, a aVar) {
            this(bVar);
        }

        public static b newBuilder(UserPushResponse userPushResponse) {
            return DEFAULT_INSTANCE.toBuilder().l(userPushResponse);
        }

        public static UserPushResponse parseFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, qVar);
        }

        private UserPushResponse(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static UserPushResponse parseDelimitedFrom(InputStream inputStream, q qVar) throws IOException {
            return (UserPushResponse) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
        }

        public static UserPushResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
        public UserPushResponse getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b toBuilder() {
            return this == DEFAULT_INSTANCE ? new b((a) null) : new b((a) null).l(this);
        }

        public static UserPushResponse parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b newBuilderForType() {
            return newBuilder();
        }

        private UserPushResponse() {
            this.memoizedIsInitialized = (byte) -1;
            this.errCode_ = 0;
            this.errMsg_ = "";
        }

        public static UserPushResponse parseFrom(InputStream inputStream) throws IOException {
            return (UserPushResponse) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static UserPushResponse parseFrom(InputStream inputStream, q qVar) throws IOException {
            return (UserPushResponse) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
        }

        private UserPushResponse(i iVar, q qVar) throws InvalidProtocolBufferException {
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

        public static UserPushResponse parseFrom(i iVar) throws IOException {
            return (UserPushResponse) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
        }

        public static UserPushResponse parseFrom(i iVar, q qVar) throws IOException {
            return (UserPushResponse) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
        }
    }

    /* loaded from: classes2.dex */
    public static final class UserUnbindRequest extends GeneratedMessageV3 implements g0 {
        public static final int DEVICE_ID_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private volatile Object deviceId_;
        private byte memoizedIsInitialized;
        private static final UserUnbindRequest DEFAULT_INSTANCE = new UserUnbindRequest();
        private static final l0<UserUnbindRequest> PARSER = new a();

        /* loaded from: classes2.dex */
        class a extends c<UserUnbindRequest> {
            a() {
            }

            /* renamed from: a */
            public UserUnbindRequest parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
                return new UserUnbindRequest(iVar, qVar, null);
            }
        }

        /* loaded from: classes2.dex */
        public static final class b extends GeneratedMessageV3.b<b> implements g0 {

            /* renamed from: a  reason: collision with root package name */
            private Object f15938a;

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
            public UserUnbindRequest build() {
                UserUnbindRequest c10 = buildPartial();
                if (c10.isInitialized()) {
                    return c10;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) c10);
            }

            /* renamed from: c */
            public UserUnbindRequest buildPartial() {
                UserUnbindRequest userUnbindRequest = new UserUnbindRequest(this, (a) null);
                userUnbindRequest.deviceId_ = this.f15938a;
                onBuilt();
                return userUnbindRequest;
            }

            /* renamed from: d */
            public b clear() {
                super.clear();
                this.f15938a = "";
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
                return PushUnicornProto.f15924c;
            }

            /* renamed from: i */
            public UserUnbindRequest getDefaultInstanceForType() {
                return UserUnbindRequest.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return PushUnicornProto.f15925d.e(UserUnbindRequest.class, b.class);
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
                UserUnbindRequest userUnbindRequest = null;
                try {
                    try {
                        UserUnbindRequest userUnbindRequest2 = (UserUnbindRequest) UserUnbindRequest.PARSER.parsePartialFrom(iVar, qVar);
                        if (userUnbindRequest2 != null) {
                            l(userUnbindRequest2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e10) {
                        userUnbindRequest = (UserUnbindRequest) e10.getUnfinishedMessage();
                        try {
                            throw e10.unwrapIOException();
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (userUnbindRequest != null) {
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (userUnbindRequest != null) {
                        l(userUnbindRequest);
                    }
                    throw th2;
                }
            }

            /* renamed from: k */
            public b mergeFrom(d0 d0Var) {
                if (d0Var instanceof UserUnbindRequest) {
                    return l((UserUnbindRequest) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            public b l(UserUnbindRequest userUnbindRequest) {
                if (userUnbindRequest == UserUnbindRequest.getDefaultInstance()) {
                    return this;
                }
                if (!userUnbindRequest.getDeviceId().isEmpty()) {
                    this.f15938a = userUnbindRequest.deviceId_;
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
                this.f15938a = "";
                maybeForceBuilderInitialization();
            }

            private b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.f15938a = "";
                maybeForceBuilderInitialization();
            }
        }

        /* synthetic */ UserUnbindRequest(i iVar, q qVar, a aVar) throws InvalidProtocolBufferException {
            this(iVar, qVar);
        }

        public static UserUnbindRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return PushUnicornProto.f15924c;
        }

        public static b newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static UserUnbindRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (UserUnbindRequest) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static UserUnbindRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static l0<UserUnbindRequest> parser() {
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
            if (!(obj instanceof UserUnbindRequest)) {
                return super.equals(obj);
            }
            return getDeviceId().equals(((UserUnbindRequest) obj).getDeviceId());
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
        public l0<UserUnbindRequest> getParserForType() {
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
            int hashCode = ((((((779 + getDescriptorForType().hashCode()) * 37) + 1) * 53) + getDeviceId().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return PushUnicornProto.f15925d.e(UserUnbindRequest.class, b.class);
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
        }

        /* synthetic */ UserUnbindRequest(GeneratedMessageV3.b bVar, a aVar) {
            this(bVar);
        }

        public static b newBuilder(UserUnbindRequest userUnbindRequest) {
            return DEFAULT_INSTANCE.toBuilder().l(userUnbindRequest);
        }

        public static UserUnbindRequest parseFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, qVar);
        }

        private UserUnbindRequest(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static UserUnbindRequest parseDelimitedFrom(InputStream inputStream, q qVar) throws IOException {
            return (UserUnbindRequest) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
        }

        public static UserUnbindRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
        public UserUnbindRequest getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b toBuilder() {
            return this == DEFAULT_INSTANCE ? new b((a) null) : new b((a) null).l(this);
        }

        public static UserUnbindRequest parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b newBuilderForType() {
            return newBuilder();
        }

        private UserUnbindRequest() {
            this.memoizedIsInitialized = (byte) -1;
            this.deviceId_ = "";
        }

        public static UserUnbindRequest parseFrom(InputStream inputStream) throws IOException {
            return (UserUnbindRequest) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static UserUnbindRequest parseFrom(InputStream inputStream, q qVar) throws IOException {
            return (UserUnbindRequest) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
        }

        private UserUnbindRequest(i iVar, q qVar) throws InvalidProtocolBufferException {
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

        public static UserUnbindRequest parseFrom(i iVar) throws IOException {
            return (UserUnbindRequest) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
        }

        public static UserUnbindRequest parseFrom(i iVar, q qVar) throws IOException {
            return (UserUnbindRequest) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements Descriptors.FileDescriptor.a {
        a() {
        }

        @Override // com.google.protobuf.Descriptors.FileDescriptor.a
        public o assignDescriptors(Descriptors.FileDescriptor fileDescriptor) {
            Descriptors.FileDescriptor unused = PushUnicornProto.f15928g = fileDescriptor;
            return null;
        }
    }

    static {
        Descriptors.FileDescriptor.q(new String[]{"\n\u001epushunicorn/push_unicorn.proto\u0012\u000emobvoi.be.push\u001a\u0018becommon/constants.proto\"Ü\u0001\n\u000fUserPushRequest\u0012\f\n\u0004wwid\u0018\u0001 \u0001(\t\u00121\n\u000bdevice_type\u0018\u0002 \u0001(\u000e2\u001c.mobvoi.be.common.DeviceType\u0012*\n\u0007channel\u0018\u0005 \u0001(\u000e2\u0019.mobvoi.be.common.Channel\u0012\u0011\n\tdevice_id\u0018\u0003 \u0001(\t\u0012\u0011\n\tclient_id\u0018\u0004 \u0001(\t\u0012\u001c\n\u0014device_token_android\u0018\u0006 \u0001(\t\u0012\u0018\n\u0010device_token_ios\u0018\u0007 \u0001(\t\"&\n\u0011UserUnbindRequest\u0012\u0011\n\tdevice_id\u0018\u0001 \u0001(\t\"5\n\u0010UserPushResponse\u0012\u0010\n\berr_code\u0018\u0001 \u0001(\u0005\u0012\u000f\n\u0007err_msg\u0018\u0002 \u0001(\tB-\n\u0019com.", "mobvoi.be.pushunicornB\u0010PushUnicornProtob\u0006proto3"}, new Descriptors.FileDescriptor[]{ConstantProto.t()}, new a());
        Descriptors.b bVar = h().j().get(0);
        f15922a = bVar;
        f15923b = new GeneratedMessageV3.e(bVar, new String[]{"Wwid", "DeviceType", "Channel", "DeviceId", "ClientId", "DeviceTokenAndroid", "DeviceTokenIos"});
        Descriptors.b bVar2 = h().j().get(1);
        f15924c = bVar2;
        f15925d = new GeneratedMessageV3.e(bVar2, new String[]{"DeviceId"});
        Descriptors.b bVar3 = h().j().get(2);
        f15926e = bVar3;
        f15927f = new GeneratedMessageV3.e(bVar3, new String[]{"ErrCode", "ErrMsg"});
        ConstantProto.t();
    }

    public static Descriptors.FileDescriptor h() {
        return f15928g;
    }
}
