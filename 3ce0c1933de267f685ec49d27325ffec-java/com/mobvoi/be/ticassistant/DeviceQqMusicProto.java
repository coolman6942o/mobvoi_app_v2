package com.mobvoi.be.ticassistant;

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
import com.mobvoi.be.ticassistant.TicAssistantProto;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes2.dex */
public final class DeviceQqMusicProto {

    /* renamed from: a  reason: collision with root package name */
    private static final Descriptors.b f16005a;

    /* renamed from: b  reason: collision with root package name */
    private static final GeneratedMessageV3.e f16006b;

    /* renamed from: c  reason: collision with root package name */
    private static final Descriptors.b f16007c;

    /* renamed from: d  reason: collision with root package name */
    private static final GeneratedMessageV3.e f16008d;

    /* renamed from: e  reason: collision with root package name */
    private static final Descriptors.b f16009e;

    /* renamed from: f  reason: collision with root package name */
    private static final GeneratedMessageV3.e f16010f;

    /* renamed from: g  reason: collision with root package name */
    private static final Descriptors.b f16011g;

    /* renamed from: h  reason: collision with root package name */
    private static final GeneratedMessageV3.e f16012h;

    /* renamed from: i  reason: collision with root package name */
    private static final Descriptors.b f16013i;

    /* renamed from: j  reason: collision with root package name */
    private static final GeneratedMessageV3.e f16014j;

    /* renamed from: k  reason: collision with root package name */
    private static Descriptors.FileDescriptor f16015k;

    /* loaded from: classes2.dex */
    public static final class DeviceQqMusicResponse extends GeneratedMessageV3 implements g0 {
        public static final int ERR_CODE_FIELD_NUMBER = 1;
        public static final int ERR_MSG_FIELD_NUMBER = 2;
        public static final int HAS_LICENSE_FIELD_NUMBER = 7;
        public static final int LICENSE_CODE_FIELD_NUMBER = 4;
        public static final int QQ_INFO_FIELD_NUMBER = 5;
        public static final int QQ_MUSIC_STATUS_FIELD_NUMBER = 3;
        public static final int SIGN_FIELD_NUMBER = 6;
        private static final long serialVersionUID = 0;
        private int errCode_;
        private volatile Object errMsg_;
        private byte memoizedIsInitialized;
        private int typeCase_;
        private Object type_;
        private static final DeviceQqMusicResponse DEFAULT_INSTANCE = new DeviceQqMusicResponse();
        private static final l0<DeviceQqMusicResponse> PARSER = new a();

        /* loaded from: classes2.dex */
        public enum TypeCase implements u.a {
            QQ_MUSIC_STATUS(3),
            LICENSE_CODE(4),
            QQ_INFO(5),
            SIGN(6),
            HAS_LICENSE(7),
            TYPE_NOT_SET(0);
            
            private final int value;

            TypeCase(int i10) {
                this.value = i10;
            }

            public static TypeCase forNumber(int i10) {
                if (i10 == 0) {
                    return TYPE_NOT_SET;
                }
                if (i10 == 3) {
                    return QQ_MUSIC_STATUS;
                }
                if (i10 == 4) {
                    return LICENSE_CODE;
                }
                if (i10 == 5) {
                    return QQ_INFO;
                }
                if (i10 == 6) {
                    return SIGN;
                }
                if (i10 != 7) {
                    return null;
                }
                return HAS_LICENSE;
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
        class a extends com.google.protobuf.c<DeviceQqMusicResponse> {
            a() {
            }

            /* renamed from: a */
            public DeviceQqMusicResponse parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
                return new DeviceQqMusicResponse(iVar, qVar, null);
            }
        }

        /* loaded from: classes2.dex */
        public static final class b extends GeneratedMessageV3.b<b> implements g0 {

            /* renamed from: a  reason: collision with root package name */
            private int f16016a;

            /* renamed from: b  reason: collision with root package name */
            private Object f16017b;

            /* renamed from: c  reason: collision with root package name */
            private int f16018c;

            /* renamed from: d  reason: collision with root package name */
            private Object f16019d;

            /* renamed from: e  reason: collision with root package name */
            private q0<QqMusicStatus, QqMusicStatus.b, d> f16020e;

            /* renamed from: f  reason: collision with root package name */
            private q0<QqMusicInfo, QqMusicInfo.b, c> f16021f;

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
            public DeviceQqMusicResponse build() {
                DeviceQqMusicResponse c10 = buildPartial();
                if (c10.isInitialized()) {
                    return c10;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) c10);
            }

            /* renamed from: c */
            public DeviceQqMusicResponse buildPartial() {
                DeviceQqMusicResponse deviceQqMusicResponse = new DeviceQqMusicResponse(this, (a) null);
                deviceQqMusicResponse.errCode_ = this.f16018c;
                deviceQqMusicResponse.errMsg_ = this.f16019d;
                if (this.f16016a == 3) {
                    q0<QqMusicStatus, QqMusicStatus.b, d> q0Var = this.f16020e;
                    if (q0Var == null) {
                        deviceQqMusicResponse.type_ = this.f16017b;
                    } else {
                        deviceQqMusicResponse.type_ = q0Var.b();
                    }
                }
                if (this.f16016a == 4) {
                    deviceQqMusicResponse.type_ = this.f16017b;
                }
                if (this.f16016a == 5) {
                    q0<QqMusicInfo, QqMusicInfo.b, c> q0Var2 = this.f16021f;
                    if (q0Var2 == null) {
                        deviceQqMusicResponse.type_ = this.f16017b;
                    } else {
                        deviceQqMusicResponse.type_ = q0Var2.b();
                    }
                }
                if (this.f16016a == 6) {
                    deviceQqMusicResponse.type_ = this.f16017b;
                }
                if (this.f16016a == 7) {
                    deviceQqMusicResponse.type_ = this.f16017b;
                }
                deviceQqMusicResponse.typeCase_ = this.f16016a;
                onBuilt();
                return deviceQqMusicResponse;
            }

            /* renamed from: d */
            public b clear() {
                super.clear();
                this.f16018c = 0;
                this.f16019d = "";
                this.f16016a = 0;
                this.f16017b = null;
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
                return DeviceQqMusicProto.f16005a;
            }

            /* renamed from: i */
            public DeviceQqMusicResponse getDefaultInstanceForType() {
                return DeviceQqMusicResponse.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return DeviceQqMusicProto.f16006b.e(DeviceQqMusicResponse.class, b.class);
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
                DeviceQqMusicResponse deviceQqMusicResponse = null;
                try {
                    try {
                        DeviceQqMusicResponse deviceQqMusicResponse2 = (DeviceQqMusicResponse) DeviceQqMusicResponse.PARSER.parsePartialFrom(iVar, qVar);
                        if (deviceQqMusicResponse2 != null) {
                            l(deviceQqMusicResponse2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e10) {
                        deviceQqMusicResponse = (DeviceQqMusicResponse) e10.getUnfinishedMessage();
                        try {
                            throw e10.unwrapIOException();
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (deviceQqMusicResponse != null) {
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (deviceQqMusicResponse != null) {
                        l(deviceQqMusicResponse);
                    }
                    throw th2;
                }
            }

            /* renamed from: k */
            public b mergeFrom(d0 d0Var) {
                if (d0Var instanceof DeviceQqMusicResponse) {
                    return l((DeviceQqMusicResponse) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            public b l(DeviceQqMusicResponse deviceQqMusicResponse) {
                if (deviceQqMusicResponse == DeviceQqMusicResponse.getDefaultInstance()) {
                    return this;
                }
                if (deviceQqMusicResponse.getErrCode() != 0) {
                    p(deviceQqMusicResponse.getErrCode());
                }
                if (!deviceQqMusicResponse.getErrMsg().isEmpty()) {
                    this.f16019d = deviceQqMusicResponse.errMsg_;
                    onChanged();
                }
                int i10 = b.f16041a[deviceQqMusicResponse.getTypeCase().ordinal()];
                if (i10 == 1) {
                    n(deviceQqMusicResponse.getQqMusicStatus());
                } else if (i10 == 2) {
                    this.f16016a = 4;
                    this.f16017b = deviceQqMusicResponse.type_;
                    onChanged();
                } else if (i10 == 3) {
                    m(deviceQqMusicResponse.getQqInfo());
                } else if (i10 == 4) {
                    this.f16016a = 6;
                    this.f16017b = deviceQqMusicResponse.type_;
                    onChanged();
                } else if (i10 == 5) {
                    r(deviceQqMusicResponse.getHasLicense());
                }
                onChanged();
                return this;
            }

            public b m(QqMusicInfo qqMusicInfo) {
                q0<QqMusicInfo, QqMusicInfo.b, c> q0Var = this.f16021f;
                if (q0Var == null) {
                    if (this.f16016a != 5 || this.f16017b == QqMusicInfo.getDefaultInstance()) {
                        this.f16017b = qqMusicInfo;
                    } else {
                        this.f16017b = QqMusicInfo.newBuilder((QqMusicInfo) this.f16017b).n(qqMusicInfo).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.f16016a == 5) {
                        q0Var.h(qqMusicInfo);
                    }
                    this.f16021f.j(qqMusicInfo);
                }
                this.f16016a = 5;
                return this;
            }

            public b n(QqMusicStatus qqMusicStatus) {
                q0<QqMusicStatus, QqMusicStatus.b, d> q0Var = this.f16020e;
                if (q0Var == null) {
                    if (this.f16016a != 3 || this.f16017b == QqMusicStatus.getDefaultInstance()) {
                        this.f16017b = qqMusicStatus;
                    } else {
                        this.f16017b = QqMusicStatus.newBuilder((QqMusicStatus) this.f16017b).m(qqMusicStatus).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.f16016a == 3) {
                        q0Var.h(qqMusicStatus);
                    }
                    this.f16020e.j(qqMusicStatus);
                }
                this.f16016a = 3;
                return this;
            }

            /* renamed from: o */
            public final b mergeUnknownFields(a1 a1Var) {
                return this;
            }

            public b p(int i10) {
                this.f16018c = i10;
                onChanged();
                return this;
            }

            /* renamed from: q */
            public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.setField(fieldDescriptor, obj);
            }

            public b r(boolean z10) {
                this.f16016a = 7;
                this.f16017b = Boolean.valueOf(z10);
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

            /* synthetic */ b(a aVar) {
                this();
            }

            private b() {
                this.f16016a = 0;
                this.f16019d = "";
                maybeForceBuilderInitialization();
            }

            private b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.f16016a = 0;
                this.f16019d = "";
                maybeForceBuilderInitialization();
            }
        }

        /* synthetic */ DeviceQqMusicResponse(i iVar, q qVar, a aVar) throws InvalidProtocolBufferException {
            this(iVar, qVar);
        }

        public static DeviceQqMusicResponse getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return DeviceQqMusicProto.f16005a;
        }

        public static b newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static DeviceQqMusicResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (DeviceQqMusicResponse) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static DeviceQqMusicResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static l0<DeviceQqMusicResponse> parser() {
            return PARSER;
        }

        /* JADX WARN: Code restructure failed: missing block: B:37:0x0062, code lost:
            if (getHasLicense() == r6.getHasLicense()) goto L51;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x0073, code lost:
            if (getSign().equals(r6.getSign()) != false) goto L51;
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x0084, code lost:
            if (getQqInfo().equals(r6.getQqInfo()) != false) goto L51;
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x0095, code lost:
            if (getLicenseCode().equals(r6.getLicenseCode()) != false) goto L51;
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x00a6, code lost:
            if (getQqMusicStatus().equals(r6.getQqMusicStatus()) != false) goto L51;
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
            if (!(obj instanceof DeviceQqMusicResponse)) {
                return super.equals(obj);
            }
            DeviceQqMusicResponse deviceQqMusicResponse = (DeviceQqMusicResponse) obj;
            boolean z11 = ((getErrCode() == deviceQqMusicResponse.getErrCode()) && getErrMsg().equals(deviceQqMusicResponse.getErrMsg())) && getTypeCase().equals(deviceQqMusicResponse.getTypeCase());
            if (!z11) {
                return false;
            }
            int i10 = this.typeCase_;
            if (i10 == 3) {
                if (z11) {
                }
                z10 = false;
                return z10;
            } else if (i10 == 4) {
                if (z11) {
                }
                z10 = false;
                return z10;
            } else if (i10 == 5) {
                if (z11) {
                }
                z10 = false;
                return z10;
            } else if (i10 == 6) {
                if (z11) {
                }
                z10 = false;
                return z10;
            } else if (i10 != 7) {
                return z11;
            } else {
                if (z11) {
                }
                z10 = false;
                return z10;
            }
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

        public boolean getHasLicense() {
            if (this.typeCase_ == 7) {
                return ((Boolean) this.type_).booleanValue();
            }
            return false;
        }

        public String getLicenseCode() {
            String str = this.typeCase_ == 4 ? this.type_ : "";
            if (str instanceof String) {
                return (String) str;
            }
            String stringUtf8 = ((ByteString) str).toStringUtf8();
            if (this.typeCase_ == 4) {
                this.type_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getLicenseCodeBytes() {
            String str = this.typeCase_ == 4 ? this.type_ : "";
            if (!(str instanceof String)) {
                return (ByteString) str;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) str);
            if (this.typeCase_ == 4) {
                this.type_ = copyFromUtf8;
            }
            return copyFromUtf8;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public l0<DeviceQqMusicResponse> getParserForType() {
            return PARSER;
        }

        public QqMusicInfo getQqInfo() {
            if (this.typeCase_ == 5) {
                return (QqMusicInfo) this.type_;
            }
            return QqMusicInfo.getDefaultInstance();
        }

        public c getQqInfoOrBuilder() {
            if (this.typeCase_ == 5) {
                return (QqMusicInfo) this.type_;
            }
            return QqMusicInfo.getDefaultInstance();
        }

        public QqMusicStatus getQqMusicStatus() {
            if (this.typeCase_ == 3) {
                return (QqMusicStatus) this.type_;
            }
            return QqMusicStatus.getDefaultInstance();
        }

        public d getQqMusicStatusOrBuilder() {
            if (this.typeCase_ == 3) {
                return (QqMusicStatus) this.type_;
            }
            return QqMusicStatus.getDefaultInstance();
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
            if (this.typeCase_ == 3) {
                i11 += CodedOutputStream.E(3, (QqMusicStatus) this.type_);
            }
            if (this.typeCase_ == 4) {
                i11 += GeneratedMessageV3.computeStringSize(4, this.type_);
            }
            if (this.typeCase_ == 5) {
                i11 += CodedOutputStream.E(5, (QqMusicInfo) this.type_);
            }
            if (this.typeCase_ == 6) {
                i11 += GeneratedMessageV3.computeStringSize(6, this.type_);
            }
            if (this.typeCase_ == 7) {
                i11 += CodedOutputStream.e(7, ((Boolean) this.type_).booleanValue());
            }
            this.memoizedSize = i11;
            return i11;
        }

        public String getSign() {
            String str = this.typeCase_ == 6 ? this.type_ : "";
            if (str instanceof String) {
                return (String) str;
            }
            String stringUtf8 = ((ByteString) str).toStringUtf8();
            if (this.typeCase_ == 6) {
                this.type_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getSignBytes() {
            String str = this.typeCase_ == 6 ? this.type_ : "";
            if (!(str instanceof String)) {
                return (ByteString) str;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) str);
            if (this.typeCase_ == 6) {
                this.type_ = copyFromUtf8;
            }
            return copyFromUtf8;
        }

        public TypeCase getTypeCase() {
            return TypeCase.forNumber(this.typeCase_);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.g0
        public final a1 getUnknownFields() {
            return a1.c();
        }

        @Override // com.google.protobuf.a
        public int hashCode() {
            int i10;
            int i11;
            int i12 = this.memoizedHashCode;
            if (i12 != 0) {
                return i12;
            }
            int hashCode = ((((((((779 + getDescriptorForType().hashCode()) * 37) + 1) * 53) + getErrCode()) * 37) + 2) * 53) + getErrMsg().hashCode();
            int i13 = this.typeCase_;
            if (i13 == 3) {
                i11 = ((hashCode * 37) + 3) * 53;
                i10 = getQqMusicStatus().hashCode();
            } else if (i13 == 4) {
                i11 = ((hashCode * 37) + 4) * 53;
                i10 = getLicenseCode().hashCode();
            } else if (i13 == 5) {
                i11 = ((hashCode * 37) + 5) * 53;
                i10 = getQqInfo().hashCode();
            } else if (i13 != 6) {
                if (i13 == 7) {
                    i11 = ((hashCode * 37) + 7) * 53;
                    i10 = u.c(getHasLicense());
                }
                int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
                this.memoizedHashCode = hashCode2;
                return hashCode2;
            } else {
                i11 = ((hashCode * 37) + 6) * 53;
                i10 = getSign().hashCode();
            }
            hashCode = i11 + i10;
            int hashCode22 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode22;
            return hashCode22;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: i */
        public b newBuilderForType(GeneratedMessageV3.c cVar) {
            return new b(cVar, null);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return DeviceQqMusicProto.f16006b.e(DeviceQqMusicResponse.class, b.class);
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
            if (this.typeCase_ == 3) {
                codedOutputStream.A0(3, (QqMusicStatus) this.type_);
            }
            if (this.typeCase_ == 4) {
                GeneratedMessageV3.writeString(codedOutputStream, 4, this.type_);
            }
            if (this.typeCase_ == 5) {
                codedOutputStream.A0(5, (QqMusicInfo) this.type_);
            }
            if (this.typeCase_ == 6) {
                GeneratedMessageV3.writeString(codedOutputStream, 6, this.type_);
            }
            if (this.typeCase_ == 7) {
                codedOutputStream.e0(7, ((Boolean) this.type_).booleanValue());
            }
        }

        /* synthetic */ DeviceQqMusicResponse(GeneratedMessageV3.b bVar, a aVar) {
            this(bVar);
        }

        public static b newBuilder(DeviceQqMusicResponse deviceQqMusicResponse) {
            return DEFAULT_INSTANCE.toBuilder().l(deviceQqMusicResponse);
        }

        public static DeviceQqMusicResponse parseFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, qVar);
        }

        private DeviceQqMusicResponse(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.typeCase_ = 0;
            this.memoizedIsInitialized = (byte) -1;
        }

        public static DeviceQqMusicResponse parseDelimitedFrom(InputStream inputStream, q qVar) throws IOException {
            return (DeviceQqMusicResponse) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
        }

        public static DeviceQqMusicResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
        public DeviceQqMusicResponse getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b toBuilder() {
            return this == DEFAULT_INSTANCE ? new b((a) null) : new b((a) null).l(this);
        }

        public static DeviceQqMusicResponse parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b newBuilderForType() {
            return newBuilder();
        }

        public static DeviceQqMusicResponse parseFrom(InputStream inputStream) throws IOException {
            return (DeviceQqMusicResponse) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        private DeviceQqMusicResponse() {
            this.typeCase_ = 0;
            this.memoizedIsInitialized = (byte) -1;
            this.errCode_ = 0;
            this.errMsg_ = "";
        }

        public static DeviceQqMusicResponse parseFrom(InputStream inputStream, q qVar) throws IOException {
            return (DeviceQqMusicResponse) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
        }

        public static DeviceQqMusicResponse parseFrom(i iVar) throws IOException {
            return (DeviceQqMusicResponse) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
        }

        private DeviceQqMusicResponse(i iVar, q qVar) throws InvalidProtocolBufferException {
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
                            } else if (F != 18) {
                                QqMusicInfo.b bVar = null;
                                QqMusicStatus.b builder = null;
                                if (F == 26) {
                                    builder = this.typeCase_ == 3 ? ((QqMusicStatus) this.type_).toBuilder() : builder;
                                    e0 v10 = iVar.v(QqMusicStatus.parser(), qVar);
                                    this.type_ = v10;
                                    if (builder != null) {
                                        builder.m((QqMusicStatus) v10);
                                        this.type_ = builder.buildPartial();
                                    }
                                    this.typeCase_ = 3;
                                } else if (F == 34) {
                                    String E = iVar.E();
                                    this.typeCase_ = 4;
                                    this.type_ = E;
                                } else if (F == 42) {
                                    bVar = this.typeCase_ == 5 ? ((QqMusicInfo) this.type_).toBuilder() : bVar;
                                    e0 v11 = iVar.v(QqMusicInfo.parser(), qVar);
                                    this.type_ = v11;
                                    if (bVar != null) {
                                        bVar.n((QqMusicInfo) v11);
                                        this.type_ = bVar.buildPartial();
                                    }
                                    this.typeCase_ = 5;
                                } else if (F == 50) {
                                    String E2 = iVar.E();
                                    this.typeCase_ = 6;
                                    this.type_ = E2;
                                } else if (F == 56) {
                                    this.typeCase_ = 7;
                                    this.type_ = Boolean.valueOf(iVar.l());
                                } else if (!iVar.I(F)) {
                                }
                            } else {
                                this.errMsg_ = iVar.E();
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

        public static DeviceQqMusicResponse parseFrom(i iVar, q qVar) throws IOException {
            return (DeviceQqMusicResponse) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
        }
    }

    /* loaded from: classes2.dex */
    public static final class QqMusicInfo extends GeneratedMessageV3 implements c {
        private static final QqMusicInfo DEFAULT_INSTANCE = new QqMusicInfo();
        private static final l0<QqMusicInfo> PARSER = new a();
        public static final int QQ_VIP_INFO_FIELD_NUMBER = 1;
        public static final int TIC_HOME_INFOS_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private byte memoizedIsInitialized;
        private QqVipInfo qqVipInfo_;
        private List<TicHomeInfo> ticHomeInfos_;

        /* loaded from: classes2.dex */
        class a extends com.google.protobuf.c<QqMusicInfo> {
            a() {
            }

            /* renamed from: a */
            public QqMusicInfo parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
                return new QqMusicInfo(iVar, qVar, null);
            }
        }

        /* loaded from: classes2.dex */
        public static final class b extends GeneratedMessageV3.b<b> implements c {

            /* renamed from: a  reason: collision with root package name */
            private int f16022a;

            /* renamed from: b  reason: collision with root package name */
            private QqVipInfo f16023b;

            /* renamed from: c  reason: collision with root package name */
            private q0<QqVipInfo, QqVipInfo.b, e> f16024c;

            /* renamed from: d  reason: collision with root package name */
            private List<TicHomeInfo> f16025d;

            /* renamed from: e  reason: collision with root package name */
            private o0<TicHomeInfo, TicHomeInfo.b, f> f16026e;

            /* synthetic */ b(GeneratedMessageV3.c cVar, a aVar) {
                this(cVar);
            }

            private void i() {
                if ((this.f16022a & 2) != 2) {
                    this.f16025d = new ArrayList(this.f16025d);
                    this.f16022a |= 2;
                }
            }

            private o0<TicHomeInfo, TicHomeInfo.b, f> k() {
                if (this.f16026e == null) {
                    this.f16026e = new o0<>(this.f16025d, (this.f16022a & 2) == 2, getParentForChildren(), isClean());
                    this.f16025d = null;
                }
                return this.f16026e;
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
            public QqMusicInfo build() {
                QqMusicInfo c10 = buildPartial();
                if (c10.isInitialized()) {
                    return c10;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) c10);
            }

            /* renamed from: c */
            public QqMusicInfo buildPartial() {
                QqMusicInfo qqMusicInfo = new QqMusicInfo(this, (a) null);
                q0<QqVipInfo, QqVipInfo.b, e> q0Var = this.f16024c;
                if (q0Var == null) {
                    qqMusicInfo.qqVipInfo_ = this.f16023b;
                } else {
                    qqMusicInfo.qqVipInfo_ = q0Var.b();
                }
                o0<TicHomeInfo, TicHomeInfo.b, f> o0Var = this.f16026e;
                if (o0Var == null) {
                    if ((this.f16022a & 2) == 2) {
                        this.f16025d = Collections.unmodifiableList(this.f16025d);
                        this.f16022a &= -3;
                    }
                    qqMusicInfo.ticHomeInfos_ = this.f16025d;
                } else {
                    qqMusicInfo.ticHomeInfos_ = o0Var.g();
                }
                qqMusicInfo.bitField0_ = 0;
                onBuilt();
                return qqMusicInfo;
            }

            /* renamed from: d */
            public b clear() {
                super.clear();
                if (this.f16024c == null) {
                    this.f16023b = null;
                } else {
                    this.f16023b = null;
                    this.f16024c = null;
                }
                o0<TicHomeInfo, TicHomeInfo.b, f> o0Var = this.f16026e;
                if (o0Var == null) {
                    this.f16025d = Collections.emptyList();
                    this.f16022a &= -3;
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
                return DeviceQqMusicProto.f16009e;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return DeviceQqMusicProto.f16010f.e(QqMusicInfo.class, b.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.f0
            public final boolean isInitialized() {
                return true;
            }

            /* renamed from: j */
            public QqMusicInfo getDefaultInstanceForType() {
                return QqMusicInfo.getDefaultInstance();
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x0023  */
            /* renamed from: l */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public b mergeFrom(i iVar, q qVar) throws IOException {
                Throwable th2;
                QqMusicInfo qqMusicInfo = null;
                try {
                    try {
                        QqMusicInfo qqMusicInfo2 = (QqMusicInfo) QqMusicInfo.PARSER.parsePartialFrom(iVar, qVar);
                        if (qqMusicInfo2 != null) {
                            n(qqMusicInfo2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e10) {
                        qqMusicInfo = (QqMusicInfo) e10.getUnfinishedMessage();
                        try {
                            throw e10.unwrapIOException();
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (qqMusicInfo != null) {
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (qqMusicInfo != null) {
                        n(qqMusicInfo);
                    }
                    throw th2;
                }
            }

            /* renamed from: m */
            public b mergeFrom(d0 d0Var) {
                if (d0Var instanceof QqMusicInfo) {
                    return n((QqMusicInfo) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            public b n(QqMusicInfo qqMusicInfo) {
                if (qqMusicInfo == QqMusicInfo.getDefaultInstance()) {
                    return this;
                }
                if (qqMusicInfo.hasQqVipInfo()) {
                    o(qqMusicInfo.getQqVipInfo());
                }
                if (this.f16026e == null) {
                    if (!qqMusicInfo.ticHomeInfos_.isEmpty()) {
                        if (this.f16025d.isEmpty()) {
                            this.f16025d = qqMusicInfo.ticHomeInfos_;
                            this.f16022a &= -3;
                        } else {
                            i();
                            this.f16025d.addAll(qqMusicInfo.ticHomeInfos_);
                        }
                        onChanged();
                    }
                } else if (!qqMusicInfo.ticHomeInfos_.isEmpty()) {
                    if (this.f16026e.u()) {
                        this.f16026e.i();
                        o0<TicHomeInfo, TicHomeInfo.b, f> o0Var = null;
                        this.f16026e = null;
                        this.f16025d = qqMusicInfo.ticHomeInfos_;
                        this.f16022a &= -3;
                        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                            o0Var = k();
                        }
                        this.f16026e = o0Var;
                    } else {
                        this.f16026e.b(qqMusicInfo.ticHomeInfos_);
                    }
                }
                onChanged();
                return this;
            }

            public b o(QqVipInfo qqVipInfo) {
                q0<QqVipInfo, QqVipInfo.b, e> q0Var = this.f16024c;
                if (q0Var == null) {
                    QqVipInfo qqVipInfo2 = this.f16023b;
                    if (qqVipInfo2 != null) {
                        this.f16023b = QqVipInfo.newBuilder(qqVipInfo2).l(qqVipInfo).buildPartial();
                    } else {
                        this.f16023b = qqVipInfo;
                    }
                    onChanged();
                } else {
                    q0Var.h(qqVipInfo);
                }
                return this;
            }

            /* renamed from: p */
            public final b mergeUnknownFields(a1 a1Var) {
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
                this.f16023b = null;
                this.f16025d = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.f16023b = null;
                this.f16025d = Collections.emptyList();
                maybeForceBuilderInitialization();
            }
        }

        /* synthetic */ QqMusicInfo(i iVar, q qVar, a aVar) throws InvalidProtocolBufferException {
            this(iVar, qVar);
        }

        public static QqMusicInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return DeviceQqMusicProto.f16009e;
        }

        public static b newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static QqMusicInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (QqMusicInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static QqMusicInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static l0<QqMusicInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof QqMusicInfo)) {
                return super.equals(obj);
            }
            QqMusicInfo qqMusicInfo = (QqMusicInfo) obj;
            boolean z10 = hasQqVipInfo() == qqMusicInfo.hasQqVipInfo();
            if (hasQqVipInfo()) {
                z10 = z10 && getQqVipInfo().equals(qqMusicInfo.getQqVipInfo());
            }
            return z10 && getTicHomeInfosList().equals(qqMusicInfo.getTicHomeInfosList());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: g */
        public b newBuilderForType(GeneratedMessageV3.c cVar) {
            return new b(cVar, null);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public l0<QqMusicInfo> getParserForType() {
            return PARSER;
        }

        public QqVipInfo getQqVipInfo() {
            QqVipInfo qqVipInfo = this.qqVipInfo_;
            return qqVipInfo == null ? QqVipInfo.getDefaultInstance() : qqVipInfo;
        }

        public e getQqVipInfoOrBuilder() {
            return getQqVipInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
        public int getSerializedSize() {
            int i10 = this.memoizedSize;
            if (i10 != -1) {
                return i10;
            }
            int E = this.qqVipInfo_ != null ? CodedOutputStream.E(1, getQqVipInfo()) + 0 : 0;
            for (int i11 = 0; i11 < this.ticHomeInfos_.size(); i11++) {
                E += CodedOutputStream.E(2, this.ticHomeInfos_.get(i11));
            }
            this.memoizedSize = E;
            return E;
        }

        public TicHomeInfo getTicHomeInfos(int i10) {
            return this.ticHomeInfos_.get(i10);
        }

        public int getTicHomeInfosCount() {
            return this.ticHomeInfos_.size();
        }

        public List<TicHomeInfo> getTicHomeInfosList() {
            return this.ticHomeInfos_;
        }

        public f getTicHomeInfosOrBuilder(int i10) {
            return this.ticHomeInfos_.get(i10);
        }

        public List<? extends f> getTicHomeInfosOrBuilderList() {
            return this.ticHomeInfos_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.g0
        public final a1 getUnknownFields() {
            return a1.c();
        }

        public boolean hasQqVipInfo() {
            return this.qqVipInfo_ != null;
        }

        @Override // com.google.protobuf.a
        public int hashCode() {
            int i10 = this.memoizedHashCode;
            if (i10 != 0) {
                return i10;
            }
            int hashCode = 779 + getDescriptorForType().hashCode();
            if (hasQqVipInfo()) {
                hashCode = (((hashCode * 37) + 1) * 53) + getQqVipInfo().hashCode();
            }
            if (getTicHomeInfosCount() > 0) {
                hashCode = (((hashCode * 37) + 2) * 53) + getTicHomeInfosList().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return DeviceQqMusicProto.f16010f.e(QqMusicInfo.class, b.class);
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
            if (this.qqVipInfo_ != null) {
                codedOutputStream.A0(1, getQqVipInfo());
            }
            for (int i10 = 0; i10 < this.ticHomeInfos_.size(); i10++) {
                codedOutputStream.A0(2, this.ticHomeInfos_.get(i10));
            }
        }

        /* synthetic */ QqMusicInfo(GeneratedMessageV3.b bVar, a aVar) {
            this(bVar);
        }

        public static b newBuilder(QqMusicInfo qqMusicInfo) {
            return DEFAULT_INSTANCE.toBuilder().n(qqMusicInfo);
        }

        public static QqMusicInfo parseFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, qVar);
        }

        private QqMusicInfo(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static QqMusicInfo parseDelimitedFrom(InputStream inputStream, q qVar) throws IOException {
            return (QqMusicInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
        }

        public static QqMusicInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
        public QqMusicInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b toBuilder() {
            return this == DEFAULT_INSTANCE ? new b((a) null) : new b((a) null).n(this);
        }

        public static QqMusicInfo parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b newBuilderForType() {
            return newBuilder();
        }

        private QqMusicInfo() {
            this.memoizedIsInitialized = (byte) -1;
            this.ticHomeInfos_ = Collections.emptyList();
        }

        public static QqMusicInfo parseFrom(InputStream inputStream) throws IOException {
            return (QqMusicInfo) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static QqMusicInfo parseFrom(InputStream inputStream, q qVar) throws IOException {
            return (QqMusicInfo) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
        }

        private QqMusicInfo(i iVar, q qVar) throws InvalidProtocolBufferException {
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
                            if (F == 10) {
                                QqVipInfo.b bVar = null;
                                QqVipInfo qqVipInfo = this.qqVipInfo_;
                                bVar = qqVipInfo != null ? qqVipInfo.toBuilder() : bVar;
                                QqVipInfo qqVipInfo2 = (QqVipInfo) iVar.v(QqVipInfo.parser(), qVar);
                                this.qqVipInfo_ = qqVipInfo2;
                                if (bVar != null) {
                                    bVar.l(qqVipInfo2);
                                    this.qqVipInfo_ = bVar.buildPartial();
                                }
                            } else if (F == 18) {
                                if (!(z11 & true)) {
                                    this.ticHomeInfos_ = new ArrayList();
                                    z11 |= true;
                                }
                                this.ticHomeInfos_.add((TicHomeInfo) iVar.v(TicHomeInfo.parser(), qVar));
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
                        this.ticHomeInfos_ = Collections.unmodifiableList(this.ticHomeInfos_);
                    }
                    makeExtensionsImmutable();
                }
            }
        }

        public static QqMusicInfo parseFrom(i iVar) throws IOException {
            return (QqMusicInfo) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
        }

        public static QqMusicInfo parseFrom(i iVar, q qVar) throws IOException {
            return (QqMusicInfo) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
        }
    }

    /* loaded from: classes2.dex */
    public static final class QqMusicStatus extends GeneratedMessageV3 implements d {
        public static final int BIND_INFO_RESPONSE_FIELD_NUMBER = 2;
        private static final QqMusicStatus DEFAULT_INSTANCE = new QqMusicStatus();
        private static final l0<QqMusicStatus> PARSER = new a();
        public static final int QQ_MUSIC_STATUS_CODE_FIELD_NUMBER = 1;
        public static final int QQ_NICKNAME_FIELD_NUMBER = 3;
        public static final int QQ_VIP_END_TIME_FIELD_NUMBER = 4;
        private static final long serialVersionUID = 0;
        private TicAssistantProto.BindInfoResponse bindInfoResponse_;
        private byte memoizedIsInitialized;
        private int qqMusicStatusCode_;
        private volatile Object qqNickname_;
        private long qqVipEndTime_;

        /* loaded from: classes2.dex */
        public enum QqMusicStatusCode implements m0 {
            DEFAULT(0),
            SUCCESS(1),
            CHARGED_AND_NEED_LICENSE(2),
            NEED_CHARGE(3),
            NEED_CHARGE_AND_LICENSE(4),
            OVER_LIMIT(5),
            NEED_CHARGE_AND_NO_LICENSE(6),
            UNRECOGNIZED(-1);
            
            public static final int CHARGED_AND_NEED_LICENSE_VALUE = 2;
            public static final int DEFAULT_VALUE = 0;
            public static final int NEED_CHARGE_AND_LICENSE_VALUE = 4;
            public static final int NEED_CHARGE_AND_NO_LICENSE_VALUE = 6;
            public static final int NEED_CHARGE_VALUE = 3;
            public static final int OVER_LIMIT_VALUE = 5;
            public static final int SUCCESS_VALUE = 1;
            private final int value;
            private static final u.b<QqMusicStatusCode> internalValueMap = new a();
            private static final QqMusicStatusCode[] VALUES = values();

            /* loaded from: classes2.dex */
            class a implements u.b<QqMusicStatusCode> {
                a() {
                }
            }

            QqMusicStatusCode(int i10) {
                this.value = i10;
            }

            public static QqMusicStatusCode forNumber(int i10) {
                switch (i10) {
                    case 0:
                        return DEFAULT;
                    case 1:
                        return SUCCESS;
                    case 2:
                        return CHARGED_AND_NEED_LICENSE;
                    case 3:
                        return NEED_CHARGE;
                    case 4:
                        return NEED_CHARGE_AND_LICENSE;
                    case 5:
                        return OVER_LIMIT;
                    case 6:
                        return NEED_CHARGE_AND_NO_LICENSE;
                    default:
                        return null;
                }
            }

            public static final Descriptors.d getDescriptor() {
                return QqMusicStatus.getDescriptor().j().get(0);
            }

            public static u.b<QqMusicStatusCode> internalGetValueMap() {
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
            public static QqMusicStatusCode valueOf(int i10) {
                return forNumber(i10);
            }

            public static QqMusicStatusCode valueOf(Descriptors.e eVar) {
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
        class a extends com.google.protobuf.c<QqMusicStatus> {
            a() {
            }

            /* renamed from: a */
            public QqMusicStatus parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
                return new QqMusicStatus(iVar, qVar, null);
            }
        }

        /* loaded from: classes2.dex */
        public static final class b extends GeneratedMessageV3.b<b> implements d {

            /* renamed from: a  reason: collision with root package name */
            private int f16027a;

            /* renamed from: b  reason: collision with root package name */
            private TicAssistantProto.BindInfoResponse f16028b;

            /* renamed from: c  reason: collision with root package name */
            private q0<TicAssistantProto.BindInfoResponse, TicAssistantProto.BindInfoResponse.b, TicAssistantProto.d> f16029c;

            /* renamed from: d  reason: collision with root package name */
            private Object f16030d;

            /* renamed from: e  reason: collision with root package name */
            private long f16031e;

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
            public QqMusicStatus build() {
                QqMusicStatus c10 = buildPartial();
                if (c10.isInitialized()) {
                    return c10;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) c10);
            }

            /* renamed from: c */
            public QqMusicStatus buildPartial() {
                QqMusicStatus qqMusicStatus = new QqMusicStatus(this, (a) null);
                qqMusicStatus.qqMusicStatusCode_ = this.f16027a;
                q0<TicAssistantProto.BindInfoResponse, TicAssistantProto.BindInfoResponse.b, TicAssistantProto.d> q0Var = this.f16029c;
                if (q0Var == null) {
                    qqMusicStatus.bindInfoResponse_ = this.f16028b;
                } else {
                    qqMusicStatus.bindInfoResponse_ = q0Var.b();
                }
                qqMusicStatus.qqNickname_ = this.f16030d;
                qqMusicStatus.qqVipEndTime_ = this.f16031e;
                onBuilt();
                return qqMusicStatus;
            }

            /* renamed from: d */
            public b clear() {
                super.clear();
                this.f16027a = 0;
                if (this.f16029c == null) {
                    this.f16028b = null;
                } else {
                    this.f16028b = null;
                    this.f16029c = null;
                }
                this.f16030d = "";
                this.f16031e = 0L;
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
                return DeviceQqMusicProto.f16007c;
            }

            /* renamed from: i */
            public QqMusicStatus getDefaultInstanceForType() {
                return QqMusicStatus.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return DeviceQqMusicProto.f16008d.e(QqMusicStatus.class, b.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.f0
            public final boolean isInitialized() {
                return true;
            }

            public b j(TicAssistantProto.BindInfoResponse bindInfoResponse) {
                q0<TicAssistantProto.BindInfoResponse, TicAssistantProto.BindInfoResponse.b, TicAssistantProto.d> q0Var = this.f16029c;
                if (q0Var == null) {
                    TicAssistantProto.BindInfoResponse bindInfoResponse2 = this.f16028b;
                    if (bindInfoResponse2 != null) {
                        this.f16028b = TicAssistantProto.BindInfoResponse.newBuilder(bindInfoResponse2).l(bindInfoResponse).buildPartial();
                    } else {
                        this.f16028b = bindInfoResponse;
                    }
                    onChanged();
                } else {
                    q0Var.h(bindInfoResponse);
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
                QqMusicStatus qqMusicStatus = null;
                try {
                    try {
                        QqMusicStatus qqMusicStatus2 = (QqMusicStatus) QqMusicStatus.PARSER.parsePartialFrom(iVar, qVar);
                        if (qqMusicStatus2 != null) {
                            m(qqMusicStatus2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e10) {
                        qqMusicStatus = (QqMusicStatus) e10.getUnfinishedMessage();
                        try {
                            throw e10.unwrapIOException();
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (qqMusicStatus != null) {
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (qqMusicStatus != null) {
                        m(qqMusicStatus);
                    }
                    throw th2;
                }
            }

            /* renamed from: l */
            public b mergeFrom(d0 d0Var) {
                if (d0Var instanceof QqMusicStatus) {
                    return m((QqMusicStatus) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            public b m(QqMusicStatus qqMusicStatus) {
                if (qqMusicStatus == QqMusicStatus.getDefaultInstance()) {
                    return this;
                }
                if (qqMusicStatus.qqMusicStatusCode_ != 0) {
                    p(qqMusicStatus.getQqMusicStatusCodeValue());
                }
                if (qqMusicStatus.hasBindInfoResponse()) {
                    j(qqMusicStatus.getBindInfoResponse());
                }
                if (!qqMusicStatus.getQqNickname().isEmpty()) {
                    this.f16030d = qqMusicStatus.qqNickname_;
                    onChanged();
                }
                if (qqMusicStatus.getQqVipEndTime() != 0) {
                    q(qqMusicStatus.getQqVipEndTime());
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

            public b p(int i10) {
                this.f16027a = i10;
                onChanged();
                return this;
            }

            public b q(long j10) {
                this.f16031e = j10;
                onChanged();
                return this;
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
                this.f16027a = 0;
                this.f16028b = null;
                this.f16030d = "";
                maybeForceBuilderInitialization();
            }

            private b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.f16027a = 0;
                this.f16028b = null;
                this.f16030d = "";
                maybeForceBuilderInitialization();
            }
        }

        /* synthetic */ QqMusicStatus(i iVar, q qVar, a aVar) throws InvalidProtocolBufferException {
            this(iVar, qVar);
        }

        public static QqMusicStatus getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return DeviceQqMusicProto.f16007c;
        }

        public static b newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static QqMusicStatus parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (QqMusicStatus) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static QqMusicStatus parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static l0<QqMusicStatus> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof QqMusicStatus)) {
                return super.equals(obj);
            }
            QqMusicStatus qqMusicStatus = (QqMusicStatus) obj;
            boolean z10 = (this.qqMusicStatusCode_ == qqMusicStatus.qqMusicStatusCode_) && hasBindInfoResponse() == qqMusicStatus.hasBindInfoResponse();
            if (hasBindInfoResponse()) {
                z10 = z10 && getBindInfoResponse().equals(qqMusicStatus.getBindInfoResponse());
            }
            return (z10 && getQqNickname().equals(qqMusicStatus.getQqNickname())) && getQqVipEndTime() == qqMusicStatus.getQqVipEndTime();
        }

        public TicAssistantProto.BindInfoResponse getBindInfoResponse() {
            TicAssistantProto.BindInfoResponse bindInfoResponse = this.bindInfoResponse_;
            return bindInfoResponse == null ? TicAssistantProto.BindInfoResponse.getDefaultInstance() : bindInfoResponse;
        }

        public TicAssistantProto.d getBindInfoResponseOrBuilder() {
            return getBindInfoResponse();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public l0<QqMusicStatus> getParserForType() {
            return PARSER;
        }

        public QqMusicStatusCode getQqMusicStatusCode() {
            QqMusicStatusCode valueOf = QqMusicStatusCode.valueOf(this.qqMusicStatusCode_);
            return valueOf == null ? QqMusicStatusCode.UNRECOGNIZED : valueOf;
        }

        public int getQqMusicStatusCodeValue() {
            return this.qqMusicStatusCode_;
        }

        public String getQqNickname() {
            Object obj = this.qqNickname_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.qqNickname_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getQqNicknameBytes() {
            Object obj = this.qqNickname_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.qqNickname_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public long getQqVipEndTime() {
            return this.qqVipEndTime_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
        public int getSerializedSize() {
            int i10 = this.memoizedSize;
            if (i10 != -1) {
                return i10;
            }
            int i11 = 0;
            if (this.qqMusicStatusCode_ != QqMusicStatusCode.DEFAULT.getNumber()) {
                i11 = 0 + CodedOutputStream.l(1, this.qqMusicStatusCode_);
            }
            if (this.bindInfoResponse_ != null) {
                i11 += CodedOutputStream.E(2, getBindInfoResponse());
            }
            if (!getQqNicknameBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(3, this.qqNickname_);
            }
            long j10 = this.qqVipEndTime_;
            if (j10 != 0) {
                i11 += CodedOutputStream.x(4, j10);
            }
            this.memoizedSize = i11;
            return i11;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.g0
        public final a1 getUnknownFields() {
            return a1.c();
        }

        public boolean hasBindInfoResponse() {
            return this.bindInfoResponse_ != null;
        }

        @Override // com.google.protobuf.a
        public int hashCode() {
            int i10 = this.memoizedHashCode;
            if (i10 != 0) {
                return i10;
            }
            int hashCode = ((((779 + getDescriptorForType().hashCode()) * 37) + 1) * 53) + this.qqMusicStatusCode_;
            if (hasBindInfoResponse()) {
                hashCode = (((hashCode * 37) + 2) * 53) + getBindInfoResponse().hashCode();
            }
            int hashCode2 = (((((((((hashCode * 37) + 3) * 53) + getQqNickname().hashCode()) * 37) + 4) * 53) + u.h(getQqVipEndTime())) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return DeviceQqMusicProto.f16008d.e(QqMusicStatus.class, b.class);
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
        /* renamed from: j */
        public b newBuilderForType(GeneratedMessageV3.c cVar) {
            return new b(cVar, null);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (this.qqMusicStatusCode_ != QqMusicStatusCode.DEFAULT.getNumber()) {
                codedOutputStream.m0(1, this.qqMusicStatusCode_);
            }
            if (this.bindInfoResponse_ != null) {
                codedOutputStream.A0(2, getBindInfoResponse());
            }
            if (!getQqNicknameBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 3, this.qqNickname_);
            }
            long j10 = this.qqVipEndTime_;
            if (j10 != 0) {
                codedOutputStream.y0(4, j10);
            }
        }

        /* synthetic */ QqMusicStatus(GeneratedMessageV3.b bVar, a aVar) {
            this(bVar);
        }

        public static b newBuilder(QqMusicStatus qqMusicStatus) {
            return DEFAULT_INSTANCE.toBuilder().m(qqMusicStatus);
        }

        public static QqMusicStatus parseFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, qVar);
        }

        private QqMusicStatus(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static QqMusicStatus parseDelimitedFrom(InputStream inputStream, q qVar) throws IOException {
            return (QqMusicStatus) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
        }

        public static QqMusicStatus parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
        public QqMusicStatus getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b toBuilder() {
            return this == DEFAULT_INSTANCE ? new b((a) null) : new b((a) null).m(this);
        }

        public static QqMusicStatus parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b newBuilderForType() {
            return newBuilder();
        }

        private QqMusicStatus() {
            this.memoizedIsInitialized = (byte) -1;
            this.qqMusicStatusCode_ = 0;
            this.qqNickname_ = "";
            this.qqVipEndTime_ = 0L;
        }

        public static QqMusicStatus parseFrom(InputStream inputStream) throws IOException {
            return (QqMusicStatus) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static QqMusicStatus parseFrom(InputStream inputStream, q qVar) throws IOException {
            return (QqMusicStatus) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
        }

        public static QqMusicStatus parseFrom(i iVar) throws IOException {
            return (QqMusicStatus) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
        }

        private QqMusicStatus(i iVar, q qVar) throws InvalidProtocolBufferException {
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
                                    this.qqMusicStatusCode_ = iVar.o();
                                } else if (F == 18) {
                                    TicAssistantProto.BindInfoResponse.b bVar = null;
                                    TicAssistantProto.BindInfoResponse bindInfoResponse = this.bindInfoResponse_;
                                    bVar = bindInfoResponse != null ? bindInfoResponse.toBuilder() : bVar;
                                    TicAssistantProto.BindInfoResponse bindInfoResponse2 = (TicAssistantProto.BindInfoResponse) iVar.v(TicAssistantProto.BindInfoResponse.parser(), qVar);
                                    this.bindInfoResponse_ = bindInfoResponse2;
                                    if (bVar != null) {
                                        bVar.l(bindInfoResponse2);
                                        this.bindInfoResponse_ = bVar.buildPartial();
                                    }
                                } else if (F == 26) {
                                    this.qqNickname_ = iVar.E();
                                } else if (F == 32) {
                                    this.qqVipEndTime_ = iVar.u();
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

        public static QqMusicStatus parseFrom(i iVar, q qVar) throws IOException {
            return (QqMusicStatus) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
        }
    }

    /* loaded from: classes2.dex */
    public static final class QqVipInfo extends GeneratedMessageV3 implements e {
        public static final int END_TIME_FIELD_NUMBER = 4;
        public static final int START_TIME_FIELD_NUMBER = 3;
        public static final int VIP_FLAG_FIELD_NUMBER = 1;
        public static final int VIP_NAME_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private long endTime_;
        private byte memoizedIsInitialized;
        private long startTime_;
        private int vipFlag_;
        private volatile Object vipName_;
        private static final QqVipInfo DEFAULT_INSTANCE = new QqVipInfo();
        private static final l0<QqVipInfo> PARSER = new a();

        /* loaded from: classes2.dex */
        class a extends com.google.protobuf.c<QqVipInfo> {
            a() {
            }

            /* renamed from: a */
            public QqVipInfo parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
                return new QqVipInfo(iVar, qVar, null);
            }
        }

        /* loaded from: classes2.dex */
        public static final class b extends GeneratedMessageV3.b<b> implements e {

            /* renamed from: a  reason: collision with root package name */
            private int f16032a;

            /* renamed from: b  reason: collision with root package name */
            private Object f16033b;

            /* renamed from: c  reason: collision with root package name */
            private long f16034c;

            /* renamed from: d  reason: collision with root package name */
            private long f16035d;

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
            public QqVipInfo build() {
                QqVipInfo c10 = buildPartial();
                if (c10.isInitialized()) {
                    return c10;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) c10);
            }

            /* renamed from: c */
            public QqVipInfo buildPartial() {
                QqVipInfo qqVipInfo = new QqVipInfo(this, (a) null);
                qqVipInfo.vipFlag_ = this.f16032a;
                qqVipInfo.vipName_ = this.f16033b;
                qqVipInfo.startTime_ = this.f16034c;
                qqVipInfo.endTime_ = this.f16035d;
                onBuilt();
                return qqVipInfo;
            }

            /* renamed from: d */
            public b clear() {
                super.clear();
                this.f16032a = 0;
                this.f16033b = "";
                this.f16034c = 0L;
                this.f16035d = 0L;
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
                return DeviceQqMusicProto.f16011g;
            }

            /* renamed from: i */
            public QqVipInfo getDefaultInstanceForType() {
                return QqVipInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return DeviceQqMusicProto.f16012h.e(QqVipInfo.class, b.class);
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
                QqVipInfo qqVipInfo = null;
                try {
                    try {
                        QqVipInfo qqVipInfo2 = (QqVipInfo) QqVipInfo.PARSER.parsePartialFrom(iVar, qVar);
                        if (qqVipInfo2 != null) {
                            l(qqVipInfo2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e10) {
                        qqVipInfo = (QqVipInfo) e10.getUnfinishedMessage();
                        try {
                            throw e10.unwrapIOException();
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (qqVipInfo != null) {
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (qqVipInfo != null) {
                        l(qqVipInfo);
                    }
                    throw th2;
                }
            }

            /* renamed from: k */
            public b mergeFrom(d0 d0Var) {
                if (d0Var instanceof QqVipInfo) {
                    return l((QqVipInfo) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            public b l(QqVipInfo qqVipInfo) {
                if (qqVipInfo == QqVipInfo.getDefaultInstance()) {
                    return this;
                }
                if (qqVipInfo.getVipFlag() != 0) {
                    s(qqVipInfo.getVipFlag());
                }
                if (!qqVipInfo.getVipName().isEmpty()) {
                    this.f16033b = qqVipInfo.vipName_;
                    onChanged();
                }
                if (qqVipInfo.getStartTime() != 0) {
                    q(qqVipInfo.getStartTime());
                }
                if (qqVipInfo.getEndTime() != 0) {
                    n(qqVipInfo.getEndTime());
                }
                onChanged();
                return this;
            }

            /* renamed from: m */
            public final b mergeUnknownFields(a1 a1Var) {
                return this;
            }

            public b n(long j10) {
                this.f16035d = j10;
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

            public b q(long j10) {
                this.f16034c = j10;
                onChanged();
                return this;
            }

            /* renamed from: r */
            public final b setUnknownFields(a1 a1Var) {
                return this;
            }

            public b s(int i10) {
                this.f16032a = i10;
                onChanged();
                return this;
            }

            /* synthetic */ b(a aVar) {
                this();
            }

            private b() {
                this.f16033b = "";
                maybeForceBuilderInitialization();
            }

            private b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.f16033b = "";
                maybeForceBuilderInitialization();
            }
        }

        /* synthetic */ QqVipInfo(i iVar, q qVar, a aVar) throws InvalidProtocolBufferException {
            this(iVar, qVar);
        }

        public static QqVipInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return DeviceQqMusicProto.f16011g;
        }

        public static b newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static QqVipInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (QqVipInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static QqVipInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static l0<QqVipInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof QqVipInfo)) {
                return super.equals(obj);
            }
            QqVipInfo qqVipInfo = (QqVipInfo) obj;
            return (((getVipFlag() == qqVipInfo.getVipFlag()) && getVipName().equals(qqVipInfo.getVipName())) && (getStartTime() > qqVipInfo.getStartTime() ? 1 : (getStartTime() == qqVipInfo.getStartTime() ? 0 : -1)) == 0) && getEndTime() == qqVipInfo.getEndTime();
        }

        public long getEndTime() {
            return this.endTime_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public l0<QqVipInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
        public int getSerializedSize() {
            int i10 = this.memoizedSize;
            if (i10 != -1) {
                return i10;
            }
            int i11 = 0;
            int i12 = this.vipFlag_;
            if (i12 != 0) {
                i11 = 0 + CodedOutputStream.v(1, i12);
            }
            if (!getVipNameBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(2, this.vipName_);
            }
            long j10 = this.startTime_;
            if (j10 != 0) {
                i11 += CodedOutputStream.x(3, j10);
            }
            long j11 = this.endTime_;
            if (j11 != 0) {
                i11 += CodedOutputStream.x(4, j11);
            }
            this.memoizedSize = i11;
            return i11;
        }

        public long getStartTime() {
            return this.startTime_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.g0
        public final a1 getUnknownFields() {
            return a1.c();
        }

        public int getVipFlag() {
            return this.vipFlag_;
        }

        public String getVipName() {
            Object obj = this.vipName_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.vipName_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getVipNameBytes() {
            Object obj = this.vipName_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.vipName_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.google.protobuf.a
        public int hashCode() {
            int i10 = this.memoizedHashCode;
            if (i10 != 0) {
                return i10;
            }
            int hashCode = ((((((((((((((((((779 + getDescriptorForType().hashCode()) * 37) + 1) * 53) + getVipFlag()) * 37) + 2) * 53) + getVipName().hashCode()) * 37) + 3) * 53) + u.h(getStartTime())) * 37) + 4) * 53) + u.h(getEndTime())) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return DeviceQqMusicProto.f16012h.e(QqVipInfo.class, b.class);
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
        /* renamed from: j */
        public b newBuilderForType(GeneratedMessageV3.c cVar) {
            return new b(cVar, null);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            int i10 = this.vipFlag_;
            if (i10 != 0) {
                codedOutputStream.w0(1, i10);
            }
            if (!getVipNameBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.vipName_);
            }
            long j10 = this.startTime_;
            if (j10 != 0) {
                codedOutputStream.y0(3, j10);
            }
            long j11 = this.endTime_;
            if (j11 != 0) {
                codedOutputStream.y0(4, j11);
            }
        }

        /* synthetic */ QqVipInfo(GeneratedMessageV3.b bVar, a aVar) {
            this(bVar);
        }

        public static b newBuilder(QqVipInfo qqVipInfo) {
            return DEFAULT_INSTANCE.toBuilder().l(qqVipInfo);
        }

        public static QqVipInfo parseFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, qVar);
        }

        private QqVipInfo(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static QqVipInfo parseDelimitedFrom(InputStream inputStream, q qVar) throws IOException {
            return (QqVipInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
        }

        public static QqVipInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
        public QqVipInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b toBuilder() {
            return this == DEFAULT_INSTANCE ? new b((a) null) : new b((a) null).l(this);
        }

        public static QqVipInfo parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b newBuilderForType() {
            return newBuilder();
        }

        private QqVipInfo() {
            this.memoizedIsInitialized = (byte) -1;
            this.vipFlag_ = 0;
            this.vipName_ = "";
            this.startTime_ = 0L;
            this.endTime_ = 0L;
        }

        public static QqVipInfo parseFrom(InputStream inputStream) throws IOException {
            return (QqVipInfo) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static QqVipInfo parseFrom(InputStream inputStream, q qVar) throws IOException {
            return (QqVipInfo) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
        }

        public static QqVipInfo parseFrom(i iVar) throws IOException {
            return (QqVipInfo) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
        }

        private QqVipInfo(i iVar, q qVar) throws InvalidProtocolBufferException {
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
                                    this.vipFlag_ = iVar.t();
                                } else if (F == 18) {
                                    this.vipName_ = iVar.E();
                                } else if (F == 24) {
                                    this.startTime_ = iVar.u();
                                } else if (F == 32) {
                                    this.endTime_ = iVar.u();
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

        public static QqVipInfo parseFrom(i iVar, q qVar) throws IOException {
            return (QqVipInfo) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
        }
    }

    /* loaded from: classes2.dex */
    public static final class TicHomeInfo extends GeneratedMessageV3 implements f {
        public static final int CONNECTED_QQ_FIELD_NUMBER = 5;
        public static final int DEVICE_ID_FIELD_NUMBER = 2;
        public static final int HAS_LICENSE_FIELD_NUMBER = 4;
        public static final int NAME_FIELD_NUMBER = 3;
        public static final int WWID_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private boolean connectedQq_;
        private volatile Object deviceId_;
        private boolean hasLicense_;
        private byte memoizedIsInitialized;
        private volatile Object name_;
        private volatile Object wwid_;
        private static final TicHomeInfo DEFAULT_INSTANCE = new TicHomeInfo();
        private static final l0<TicHomeInfo> PARSER = new a();

        /* loaded from: classes2.dex */
        class a extends com.google.protobuf.c<TicHomeInfo> {
            a() {
            }

            /* renamed from: a */
            public TicHomeInfo parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
                return new TicHomeInfo(iVar, qVar, null);
            }
        }

        /* loaded from: classes2.dex */
        public static final class b extends GeneratedMessageV3.b<b> implements f {

            /* renamed from: a  reason: collision with root package name */
            private Object f16036a;

            /* renamed from: b  reason: collision with root package name */
            private Object f16037b;

            /* renamed from: c  reason: collision with root package name */
            private Object f16038c;

            /* renamed from: d  reason: collision with root package name */
            private boolean f16039d;

            /* renamed from: e  reason: collision with root package name */
            private boolean f16040e;

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
            public TicHomeInfo build() {
                TicHomeInfo c10 = buildPartial();
                if (c10.isInitialized()) {
                    return c10;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) c10);
            }

            /* renamed from: c */
            public TicHomeInfo buildPartial() {
                TicHomeInfo ticHomeInfo = new TicHomeInfo(this, (a) null);
                ticHomeInfo.wwid_ = this.f16036a;
                ticHomeInfo.deviceId_ = this.f16037b;
                ticHomeInfo.name_ = this.f16038c;
                ticHomeInfo.hasLicense_ = this.f16039d;
                ticHomeInfo.connectedQq_ = this.f16040e;
                onBuilt();
                return ticHomeInfo;
            }

            /* renamed from: d */
            public b clear() {
                super.clear();
                this.f16036a = "";
                this.f16037b = "";
                this.f16038c = "";
                this.f16039d = false;
                this.f16040e = false;
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
                return DeviceQqMusicProto.f16013i;
            }

            /* renamed from: i */
            public TicHomeInfo getDefaultInstanceForType() {
                return TicHomeInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return DeviceQqMusicProto.f16014j.e(TicHomeInfo.class, b.class);
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
                TicHomeInfo ticHomeInfo = null;
                try {
                    try {
                        TicHomeInfo ticHomeInfo2 = (TicHomeInfo) TicHomeInfo.PARSER.parsePartialFrom(iVar, qVar);
                        if (ticHomeInfo2 != null) {
                            l(ticHomeInfo2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e10) {
                        ticHomeInfo = (TicHomeInfo) e10.getUnfinishedMessage();
                        try {
                            throw e10.unwrapIOException();
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (ticHomeInfo != null) {
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (ticHomeInfo != null) {
                        l(ticHomeInfo);
                    }
                    throw th2;
                }
            }

            /* renamed from: k */
            public b mergeFrom(d0 d0Var) {
                if (d0Var instanceof TicHomeInfo) {
                    return l((TicHomeInfo) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            public b l(TicHomeInfo ticHomeInfo) {
                if (ticHomeInfo == TicHomeInfo.getDefaultInstance()) {
                    return this;
                }
                if (!ticHomeInfo.getWwid().isEmpty()) {
                    this.f16036a = ticHomeInfo.wwid_;
                    onChanged();
                }
                if (!ticHomeInfo.getDeviceId().isEmpty()) {
                    this.f16037b = ticHomeInfo.deviceId_;
                    onChanged();
                }
                if (!ticHomeInfo.getName().isEmpty()) {
                    this.f16038c = ticHomeInfo.name_;
                    onChanged();
                }
                if (ticHomeInfo.getHasLicense()) {
                    p(ticHomeInfo.getHasLicense());
                }
                if (ticHomeInfo.getConnectedQq()) {
                    n(ticHomeInfo.getConnectedQq());
                }
                onChanged();
                return this;
            }

            /* renamed from: m */
            public final b mergeUnknownFields(a1 a1Var) {
                return this;
            }

            public b n(boolean z10) {
                this.f16040e = z10;
                onChanged();
                return this;
            }

            /* renamed from: o */
            public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.setField(fieldDescriptor, obj);
            }

            public b p(boolean z10) {
                this.f16039d = z10;
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
                this.f16036a = "";
                this.f16037b = "";
                this.f16038c = "";
                maybeForceBuilderInitialization();
            }

            private b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.f16036a = "";
                this.f16037b = "";
                this.f16038c = "";
                maybeForceBuilderInitialization();
            }
        }

        /* synthetic */ TicHomeInfo(i iVar, q qVar, a aVar) throws InvalidProtocolBufferException {
            this(iVar, qVar);
        }

        public static TicHomeInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return DeviceQqMusicProto.f16013i;
        }

        public static b newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static TicHomeInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (TicHomeInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static TicHomeInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static l0<TicHomeInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof TicHomeInfo)) {
                return super.equals(obj);
            }
            TicHomeInfo ticHomeInfo = (TicHomeInfo) obj;
            return ((((getWwid().equals(ticHomeInfo.getWwid())) && getDeviceId().equals(ticHomeInfo.getDeviceId())) && getName().equals(ticHomeInfo.getName())) && getHasLicense() == ticHomeInfo.getHasLicense()) && getConnectedQq() == ticHomeInfo.getConnectedQq();
        }

        public boolean getConnectedQq() {
            return this.connectedQq_;
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

        public boolean getHasLicense() {
            return this.hasLicense_;
        }

        public String getName() {
            Object obj = this.name_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.name_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getNameBytes() {
            Object obj = this.name_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.name_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public l0<TicHomeInfo> getParserForType() {
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
            if (!getDeviceIdBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(2, this.deviceId_);
            }
            if (!getNameBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(3, this.name_);
            }
            boolean z10 = this.hasLicense_;
            if (z10) {
                i11 += CodedOutputStream.e(4, z10);
            }
            boolean z11 = this.connectedQq_;
            if (z11) {
                i11 += CodedOutputStream.e(5, z11);
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
            int hashCode = ((((((((((((((((((((((779 + getDescriptorForType().hashCode()) * 37) + 1) * 53) + getWwid().hashCode()) * 37) + 2) * 53) + getDeviceId().hashCode()) * 37) + 3) * 53) + getName().hashCode()) * 37) + 4) * 53) + u.c(getHasLicense())) * 37) + 5) * 53) + u.c(getConnectedQq())) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return DeviceQqMusicProto.f16014j.e(TicHomeInfo.class, b.class);
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
        /* renamed from: m */
        public b newBuilderForType(GeneratedMessageV3.c cVar) {
            return new b(cVar, null);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (!getWwidBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.wwid_);
            }
            if (!getDeviceIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.deviceId_);
            }
            if (!getNameBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 3, this.name_);
            }
            boolean z10 = this.hasLicense_;
            if (z10) {
                codedOutputStream.e0(4, z10);
            }
            boolean z11 = this.connectedQq_;
            if (z11) {
                codedOutputStream.e0(5, z11);
            }
        }

        /* synthetic */ TicHomeInfo(GeneratedMessageV3.b bVar, a aVar) {
            this(bVar);
        }

        public static b newBuilder(TicHomeInfo ticHomeInfo) {
            return DEFAULT_INSTANCE.toBuilder().l(ticHomeInfo);
        }

        public static TicHomeInfo parseFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, qVar);
        }

        private TicHomeInfo(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static TicHomeInfo parseDelimitedFrom(InputStream inputStream, q qVar) throws IOException {
            return (TicHomeInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
        }

        public static TicHomeInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
        public TicHomeInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b toBuilder() {
            return this == DEFAULT_INSTANCE ? new b((a) null) : new b((a) null).l(this);
        }

        public static TicHomeInfo parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b newBuilderForType() {
            return newBuilder();
        }

        private TicHomeInfo() {
            this.memoizedIsInitialized = (byte) -1;
            this.wwid_ = "";
            this.deviceId_ = "";
            this.name_ = "";
            this.hasLicense_ = false;
            this.connectedQq_ = false;
        }

        public static TicHomeInfo parseFrom(InputStream inputStream) throws IOException {
            return (TicHomeInfo) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static TicHomeInfo parseFrom(InputStream inputStream, q qVar) throws IOException {
            return (TicHomeInfo) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
        }

        public static TicHomeInfo parseFrom(i iVar) throws IOException {
            return (TicHomeInfo) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
        }

        public static TicHomeInfo parseFrom(i iVar, q qVar) throws IOException {
            return (TicHomeInfo) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
        }

        private TicHomeInfo(i iVar, q qVar) throws InvalidProtocolBufferException {
            this();
            boolean z10 = false;
            while (!z10) {
                try {
                    try {
                        int F = iVar.F();
                        z10 = true;
                        if (F != 0) {
                            if (F == 10) {
                                this.wwid_ = iVar.E();
                            } else if (F == 18) {
                                this.deviceId_ = iVar.E();
                            } else if (F == 26) {
                                this.name_ = iVar.E();
                            } else if (F == 32) {
                                this.hasLicense_ = iVar.l();
                            } else if (F == 40) {
                                this.connectedQq_ = iVar.l();
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements Descriptors.FileDescriptor.a {
        a() {
        }

        @Override // com.google.protobuf.Descriptors.FileDescriptor.a
        public o assignDescriptors(Descriptors.FileDescriptor fileDescriptor) {
            Descriptors.FileDescriptor unused = DeviceQqMusicProto.f16015k = fileDescriptor;
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f16041a;

        static {
            int[] iArr = new int[DeviceQqMusicResponse.TypeCase.values().length];
            f16041a = iArr;
            try {
                iArr[DeviceQqMusicResponse.TypeCase.QQ_MUSIC_STATUS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f16041a[DeviceQqMusicResponse.TypeCase.LICENSE_CODE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f16041a[DeviceQqMusicResponse.TypeCase.QQ_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f16041a[DeviceQqMusicResponse.TypeCase.SIGN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f16041a[DeviceQqMusicResponse.TypeCase.HAS_LICENSE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f16041a[DeviceQqMusicResponse.TypeCase.TYPE_NOT_SET.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
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
        Descriptors.FileDescriptor.q(new String[]{"\n\"ticassistant/device_qq_music.proto\u0012\u0013mobvoi.be.assistant\u001a ticassistant/tic_assistant.proto\"õ\u0001\n\u0015DeviceQqMusicResponse\u0012\u0010\n\berr_code\u0018\u0001 \u0001(\u0005\u0012\u000f\n\u0007err_msg\u0018\u0002 \u0001(\t\u0012=\n\u000fqq_music_status\u0018\u0003 \u0001(\u000b2\".mobvoi.be.assistant.QqMusicStatusH\u0000\u0012\u0016\n\flicense_code\u0018\u0004 \u0001(\tH\u0000\u00123\n\u0007qq_info\u0018\u0005 \u0001(\u000b2 .mobvoi.be.assistant.QqMusicInfoH\u0000\u0012\u000e\n\u0004sign\u0018\u0006 \u0001(\tH\u0000\u0012\u0015\n\u000bhas_license\u0018\u0007 \u0001(\bH\u0000B\u0006\n\u0004type\"\u0080\u0003\n\rQqMusicStatus\u0012R\n\u0014qq_music_status_code\u0018\u0001 \u0001(\u000e24.mobvoi.be.", "assistant.QqMusicStatus.QqMusicStatusCode\u0012A\n\u0012bind_info_response\u0018\u0002 \u0001(\u000b2%.mobvoi.be.assistant.BindInfoResponse\u0012\u0013\n\u000bqq_nickname\u0018\u0003 \u0001(\t\u0012\u0017\n\u000fqq_vip_end_time\u0018\u0004 \u0001(\u0003\"©\u0001\n\u0011QqMusicStatusCode\u0012\u000b\n\u0007DEFAULT\u0010\u0000\u0012\u000b\n\u0007SUCCESS\u0010\u0001\u0012\u001c\n\u0018CHARGED_AND_NEED_LICENSE\u0010\u0002\u0012\u000f\n\u000bNEED_CHARGE\u0010\u0003\u0012\u001b\n\u0017NEED_CHARGE_AND_LICENSE\u0010\u0004\u0012\u000e\n\nOVER_LIMIT\u0010\u0005\u0012\u001e\n\u001aNEED_CHARGE_AND_NO_LICENSE\u0010\u0006\"|\n\u000bQqMusicInfo\u00123\n\u000bqq_vip_info\u0018\u0001 \u0001(\u000b2\u001e.mobvoi.be.assistant.QqVipInfo\u00128\n\u000eti", "c_home_infos\u0018\u0002 \u0003(\u000b2 .mobvoi.be.assistant.TicHomeInfo\"U\n\tQqVipInfo\u0012\u0010\n\bvip_flag\u0018\u0001 \u0001(\u0005\u0012\u0010\n\bvip_name\u0018\u0002 \u0001(\t\u0012\u0012\n\nstart_time\u0018\u0003 \u0001(\u0003\u0012\u0010\n\bend_time\u0018\u0004 \u0001(\u0003\"g\n\u000bTicHomeInfo\u0012\f\n\u0004wwid\u0018\u0001 \u0001(\t\u0012\u0011\n\tdevice_id\u0018\u0002 \u0001(\t\u0012\f\n\u0004name\u0018\u0003 \u0001(\t\u0012\u0013\n\u000bhas_license\u0018\u0004 \u0001(\b\u0012\u0014\n\fconnected_qq\u0018\u0005 \u0001(\bB0\n\u001acom.mobvoi.be.ticassistantB\u0012DeviceQqMusicProtob\u0006proto3"}, new Descriptors.FileDescriptor[]{TicAssistantProto.t()}, new a());
        Descriptors.b bVar = l().j().get(0);
        f16005a = bVar;
        f16006b = new GeneratedMessageV3.e(bVar, new String[]{"ErrCode", "ErrMsg", "QqMusicStatus", "LicenseCode", "QqInfo", "Sign", "HasLicense", "Type"});
        Descriptors.b bVar2 = l().j().get(1);
        f16007c = bVar2;
        f16008d = new GeneratedMessageV3.e(bVar2, new String[]{"QqMusicStatusCode", "BindInfoResponse", "QqNickname", "QqVipEndTime"});
        Descriptors.b bVar3 = l().j().get(2);
        f16009e = bVar3;
        f16010f = new GeneratedMessageV3.e(bVar3, new String[]{"QqVipInfo", "TicHomeInfos"});
        Descriptors.b bVar4 = l().j().get(3);
        f16011g = bVar4;
        f16012h = new GeneratedMessageV3.e(bVar4, new String[]{"VipFlag", "VipName", "StartTime", "EndTime"});
        Descriptors.b bVar5 = l().j().get(4);
        f16013i = bVar5;
        f16014j = new GeneratedMessageV3.e(bVar5, new String[]{"Wwid", "DeviceId", "Name", "HasLicense", "ConnectedQq"});
        TicAssistantProto.t();
    }

    public static Descriptors.FileDescriptor l() {
        return f16015k;
    }
}
