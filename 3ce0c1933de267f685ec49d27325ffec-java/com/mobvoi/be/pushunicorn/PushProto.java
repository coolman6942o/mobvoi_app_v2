package com.mobvoi.be.pushunicorn;

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
import com.mobvoi.be.common.ConstantProto;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
/* loaded from: classes2.dex */
public final class PushProto {

    /* renamed from: a  reason: collision with root package name */
    private static final Descriptors.b f15873a;

    /* renamed from: b  reason: collision with root package name */
    private static final GeneratedMessageV3.e f15874b;

    /* renamed from: c  reason: collision with root package name */
    private static final Descriptors.b f15875c;

    /* renamed from: d  reason: collision with root package name */
    private static final GeneratedMessageV3.e f15876d;

    /* renamed from: e  reason: collision with root package name */
    private static final Descriptors.b f15877e;

    /* renamed from: f  reason: collision with root package name */
    private static final GeneratedMessageV3.e f15878f;

    /* renamed from: g  reason: collision with root package name */
    private static final Descriptors.b f15879g;

    /* renamed from: h  reason: collision with root package name */
    private static final GeneratedMessageV3.e f15880h;

    /* renamed from: i  reason: collision with root package name */
    private static final Descriptors.b f15881i;

    /* renamed from: j  reason: collision with root package name */
    private static final GeneratedMessageV3.e f15882j;

    /* renamed from: k  reason: collision with root package name */
    private static final Descriptors.b f15883k;

    /* renamed from: l  reason: collision with root package name */
    private static final GeneratedMessageV3.e f15884l;

    /* renamed from: m  reason: collision with root package name */
    private static final Descriptors.b f15885m;

    /* renamed from: n  reason: collision with root package name */
    private static final GeneratedMessageV3.e f15886n;

    /* renamed from: o  reason: collision with root package name */
    private static Descriptors.FileDescriptor f15887o;

    /* loaded from: classes2.dex */
    public static final class DeviceStatusResponse extends GeneratedMessageV3 implements g0 {
        public static final int ERR_CODE_FIELD_NUMBER = 1;
        public static final int ERR_MSG_FIELD_NUMBER = 2;
        public static final int RESULT_LIST_FIELD_NUMBER = 3;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private int errCode_;
        private volatile Object errMsg_;
        private byte memoizedIsInitialized;
        private List<DeviceStatusResult> resultList_;
        private static final DeviceStatusResponse DEFAULT_INSTANCE = new DeviceStatusResponse();
        private static final l0<DeviceStatusResponse> PARSER = new a();

        /* loaded from: classes2.dex */
        class a extends com.google.protobuf.c<DeviceStatusResponse> {
            a() {
            }

            /* renamed from: a */
            public DeviceStatusResponse parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
                return new DeviceStatusResponse(iVar, qVar, null);
            }
        }

        /* loaded from: classes2.dex */
        public static final class b extends GeneratedMessageV3.b<b> implements g0 {

            /* renamed from: a  reason: collision with root package name */
            private int f15888a;

            /* renamed from: b  reason: collision with root package name */
            private int f15889b;

            /* renamed from: c  reason: collision with root package name */
            private Object f15890c;

            /* renamed from: d  reason: collision with root package name */
            private List<DeviceStatusResult> f15891d;

            /* renamed from: e  reason: collision with root package name */
            private o0<DeviceStatusResult, DeviceStatusResult.b, c> f15892e;

            /* synthetic */ b(GeneratedMessageV3.c cVar, a aVar) {
                this(cVar);
            }

            private void i() {
                if ((this.f15888a & 4) != 4) {
                    this.f15891d = new ArrayList(this.f15891d);
                    this.f15888a |= 4;
                }
            }

            private o0<DeviceStatusResult, DeviceStatusResult.b, c> k() {
                if (this.f15892e == null) {
                    this.f15892e = new o0<>(this.f15891d, (this.f15888a & 4) == 4, getParentForChildren(), isClean());
                    this.f15891d = null;
                }
                return this.f15892e;
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
            public DeviceStatusResponse build() {
                DeviceStatusResponse c10 = buildPartial();
                if (c10.isInitialized()) {
                    return c10;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) c10);
            }

            /* renamed from: c */
            public DeviceStatusResponse buildPartial() {
                DeviceStatusResponse deviceStatusResponse = new DeviceStatusResponse(this, (a) null);
                deviceStatusResponse.errCode_ = this.f15889b;
                deviceStatusResponse.errMsg_ = this.f15890c;
                o0<DeviceStatusResult, DeviceStatusResult.b, c> o0Var = this.f15892e;
                if (o0Var == null) {
                    if ((this.f15888a & 4) == 4) {
                        this.f15891d = Collections.unmodifiableList(this.f15891d);
                        this.f15888a &= -5;
                    }
                    deviceStatusResponse.resultList_ = this.f15891d;
                } else {
                    deviceStatusResponse.resultList_ = o0Var.g();
                }
                deviceStatusResponse.bitField0_ = 0;
                onBuilt();
                return deviceStatusResponse;
            }

            /* renamed from: d */
            public b clear() {
                super.clear();
                this.f15889b = 0;
                this.f15890c = "";
                o0<DeviceStatusResult, DeviceStatusResult.b, c> o0Var = this.f15892e;
                if (o0Var == null) {
                    this.f15891d = Collections.emptyList();
                    this.f15888a &= -5;
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
                return PushProto.f15879g;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return PushProto.f15880h.e(DeviceStatusResponse.class, b.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.f0
            public final boolean isInitialized() {
                return true;
            }

            /* renamed from: j */
            public DeviceStatusResponse getDefaultInstanceForType() {
                return DeviceStatusResponse.getDefaultInstance();
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x0023  */
            /* renamed from: l */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public b mergeFrom(i iVar, q qVar) throws IOException {
                Throwable th2;
                DeviceStatusResponse deviceStatusResponse = null;
                try {
                    try {
                        DeviceStatusResponse deviceStatusResponse2 = (DeviceStatusResponse) DeviceStatusResponse.PARSER.parsePartialFrom(iVar, qVar);
                        if (deviceStatusResponse2 != null) {
                            n(deviceStatusResponse2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e10) {
                        deviceStatusResponse = (DeviceStatusResponse) e10.getUnfinishedMessage();
                        try {
                            throw e10.unwrapIOException();
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (deviceStatusResponse != null) {
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (deviceStatusResponse != null) {
                        n(deviceStatusResponse);
                    }
                    throw th2;
                }
            }

            /* renamed from: m */
            public b mergeFrom(d0 d0Var) {
                if (d0Var instanceof DeviceStatusResponse) {
                    return n((DeviceStatusResponse) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            public b n(DeviceStatusResponse deviceStatusResponse) {
                if (deviceStatusResponse == DeviceStatusResponse.getDefaultInstance()) {
                    return this;
                }
                if (deviceStatusResponse.getErrCode() != 0) {
                    p(deviceStatusResponse.getErrCode());
                }
                if (!deviceStatusResponse.getErrMsg().isEmpty()) {
                    this.f15890c = deviceStatusResponse.errMsg_;
                    onChanged();
                }
                if (this.f15892e == null) {
                    if (!deviceStatusResponse.resultList_.isEmpty()) {
                        if (this.f15891d.isEmpty()) {
                            this.f15891d = deviceStatusResponse.resultList_;
                            this.f15888a &= -5;
                        } else {
                            i();
                            this.f15891d.addAll(deviceStatusResponse.resultList_);
                        }
                        onChanged();
                    }
                } else if (!deviceStatusResponse.resultList_.isEmpty()) {
                    if (this.f15892e.u()) {
                        this.f15892e.i();
                        o0<DeviceStatusResult, DeviceStatusResult.b, c> o0Var = null;
                        this.f15892e = null;
                        this.f15891d = deviceStatusResponse.resultList_;
                        this.f15888a &= -5;
                        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                            o0Var = k();
                        }
                        this.f15892e = o0Var;
                    } else {
                        this.f15892e.b(deviceStatusResponse.resultList_);
                    }
                }
                onChanged();
                return this;
            }

            /* renamed from: o */
            public final b mergeUnknownFields(a1 a1Var) {
                return this;
            }

            public b p(int i10) {
                this.f15889b = i10;
                onChanged();
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
                this.f15890c = "";
                this.f15891d = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.f15890c = "";
                this.f15891d = Collections.emptyList();
                maybeForceBuilderInitialization();
            }
        }

        /* synthetic */ DeviceStatusResponse(i iVar, q qVar, a aVar) throws InvalidProtocolBufferException {
            this(iVar, qVar);
        }

        public static DeviceStatusResponse getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return PushProto.f15879g;
        }

        public static b newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static DeviceStatusResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (DeviceStatusResponse) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static DeviceStatusResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static l0<DeviceStatusResponse> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof DeviceStatusResponse)) {
                return super.equals(obj);
            }
            DeviceStatusResponse deviceStatusResponse = (DeviceStatusResponse) obj;
            return ((getErrCode() == deviceStatusResponse.getErrCode()) && getErrMsg().equals(deviceStatusResponse.getErrMsg())) && getResultListList().equals(deviceStatusResponse.getResultListList());
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
        public l0<DeviceStatusResponse> getParserForType() {
            return PARSER;
        }

        public DeviceStatusResult getResultList(int i10) {
            return this.resultList_.get(i10);
        }

        public int getResultListCount() {
            return this.resultList_.size();
        }

        public List<DeviceStatusResult> getResultListList() {
            return this.resultList_;
        }

        public c getResultListOrBuilder(int i10) {
            return this.resultList_.get(i10);
        }

        public List<? extends c> getResultListOrBuilderList() {
            return this.resultList_;
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
            for (int i12 = 0; i12 < this.resultList_.size(); i12++) {
                v10 += CodedOutputStream.E(3, this.resultList_.get(i12));
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
            if (getResultListCount() > 0) {
                hashCode = (((hashCode * 37) + 3) * 53) + getResultListList().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return PushProto.f15880h.e(DeviceStatusResponse.class, b.class);
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
            int i10 = this.errCode_;
            if (i10 != 0) {
                codedOutputStream.w0(1, i10);
            }
            if (!getErrMsgBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.errMsg_);
            }
            for (int i11 = 0; i11 < this.resultList_.size(); i11++) {
                codedOutputStream.A0(3, this.resultList_.get(i11));
            }
        }

        /* synthetic */ DeviceStatusResponse(GeneratedMessageV3.b bVar, a aVar) {
            this(bVar);
        }

        public static b newBuilder(DeviceStatusResponse deviceStatusResponse) {
            return DEFAULT_INSTANCE.toBuilder().n(deviceStatusResponse);
        }

        public static DeviceStatusResponse parseFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, qVar);
        }

        private DeviceStatusResponse(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static DeviceStatusResponse parseDelimitedFrom(InputStream inputStream, q qVar) throws IOException {
            return (DeviceStatusResponse) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
        }

        public static DeviceStatusResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
        public DeviceStatusResponse getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b toBuilder() {
            return this == DEFAULT_INSTANCE ? new b((a) null) : new b((a) null).n(this);
        }

        public static DeviceStatusResponse parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b newBuilderForType() {
            return newBuilder();
        }

        private DeviceStatusResponse() {
            this.memoizedIsInitialized = (byte) -1;
            this.errCode_ = 0;
            this.errMsg_ = "";
            this.resultList_ = Collections.emptyList();
        }

        public static DeviceStatusResponse parseFrom(InputStream inputStream) throws IOException {
            return (DeviceStatusResponse) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static DeviceStatusResponse parseFrom(InputStream inputStream, q qVar) throws IOException {
            return (DeviceStatusResponse) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
        }

        public static DeviceStatusResponse parseFrom(i iVar) throws IOException {
            return (DeviceStatusResponse) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
        }

        private DeviceStatusResponse(i iVar, q qVar) throws InvalidProtocolBufferException {
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
                                    this.resultList_ = new ArrayList();
                                    z11 |= true;
                                }
                                this.resultList_.add((DeviceStatusResult) iVar.v(DeviceStatusResult.parser(), qVar));
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
                        this.resultList_ = Collections.unmodifiableList(this.resultList_);
                    }
                    makeExtensionsImmutable();
                }
            }
        }

        public static DeviceStatusResponse parseFrom(i iVar, q qVar) throws IOException {
            return (DeviceStatusResponse) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
        }
    }

    /* loaded from: classes2.dex */
    public static final class DeviceStatusResult extends GeneratedMessageV3 implements c {
        public static final int CHANNEL_FIELD_NUMBER = 6;
        public static final int CLIENT_ID_FIELD_NUMBER = 4;
        public static final int DEVICE_ID_FIELD_NUMBER = 3;
        public static final int DEVICE_TYPE_FIELD_NUMBER = 2;
        public static final int RESULT_FIELD_NUMBER = 5;
        public static final int WWID_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private int channel_;
        private volatile Object clientId_;
        private volatile Object deviceId_;
        private int deviceType_;
        private byte memoizedIsInitialized;
        private int result_;
        private volatile Object wwid_;
        private static final DeviceStatusResult DEFAULT_INSTANCE = new DeviceStatusResult();
        private static final l0<DeviceStatusResult> PARSER = new a();

        /* loaded from: classes2.dex */
        class a extends com.google.protobuf.c<DeviceStatusResult> {
            a() {
            }

            /* renamed from: a */
            public DeviceStatusResult parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
                return new DeviceStatusResult(iVar, qVar, null);
            }
        }

        /* loaded from: classes2.dex */
        public static final class b extends GeneratedMessageV3.b<b> implements c {

            /* renamed from: a  reason: collision with root package name */
            private Object f15893a;

            /* renamed from: b  reason: collision with root package name */
            private int f15894b;

            /* renamed from: c  reason: collision with root package name */
            private Object f15895c;

            /* renamed from: d  reason: collision with root package name */
            private Object f15896d;

            /* renamed from: e  reason: collision with root package name */
            private int f15897e;

            /* renamed from: f  reason: collision with root package name */
            private int f15898f;

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
            public DeviceStatusResult build() {
                DeviceStatusResult c10 = buildPartial();
                if (c10.isInitialized()) {
                    return c10;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) c10);
            }

            /* renamed from: c */
            public DeviceStatusResult buildPartial() {
                DeviceStatusResult deviceStatusResult = new DeviceStatusResult(this, (a) null);
                deviceStatusResult.wwid_ = this.f15893a;
                deviceStatusResult.deviceType_ = this.f15894b;
                deviceStatusResult.deviceId_ = this.f15895c;
                deviceStatusResult.clientId_ = this.f15896d;
                deviceStatusResult.result_ = this.f15897e;
                deviceStatusResult.channel_ = this.f15898f;
                onBuilt();
                return deviceStatusResult;
            }

            /* renamed from: d */
            public b clear() {
                super.clear();
                this.f15893a = "";
                this.f15894b = 0;
                this.f15895c = "";
                this.f15896d = "";
                this.f15897e = 0;
                this.f15898f = 0;
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
                return PushProto.f15881i;
            }

            /* renamed from: i */
            public DeviceStatusResult getDefaultInstanceForType() {
                return DeviceStatusResult.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return PushProto.f15882j.e(DeviceStatusResult.class, b.class);
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
                DeviceStatusResult deviceStatusResult = null;
                try {
                    try {
                        DeviceStatusResult deviceStatusResult2 = (DeviceStatusResult) DeviceStatusResult.PARSER.parsePartialFrom(iVar, qVar);
                        if (deviceStatusResult2 != null) {
                            l(deviceStatusResult2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e10) {
                        deviceStatusResult = (DeviceStatusResult) e10.getUnfinishedMessage();
                        try {
                            throw e10.unwrapIOException();
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (deviceStatusResult != null) {
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (deviceStatusResult != null) {
                        l(deviceStatusResult);
                    }
                    throw th2;
                }
            }

            /* renamed from: k */
            public b mergeFrom(d0 d0Var) {
                if (d0Var instanceof DeviceStatusResult) {
                    return l((DeviceStatusResult) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            public b l(DeviceStatusResult deviceStatusResult) {
                if (deviceStatusResult == DeviceStatusResult.getDefaultInstance()) {
                    return this;
                }
                if (!deviceStatusResult.getWwid().isEmpty()) {
                    this.f15893a = deviceStatusResult.wwid_;
                    onChanged();
                }
                if (deviceStatusResult.deviceType_ != 0) {
                    o(deviceStatusResult.getDeviceTypeValue());
                }
                if (!deviceStatusResult.getDeviceId().isEmpty()) {
                    this.f15895c = deviceStatusResult.deviceId_;
                    onChanged();
                }
                if (!deviceStatusResult.getClientId().isEmpty()) {
                    this.f15896d = deviceStatusResult.clientId_;
                    onChanged();
                }
                if (deviceStatusResult.result_ != 0) {
                    r(deviceStatusResult.getResultValue());
                }
                if (deviceStatusResult.channel_ != 0) {
                    n(deviceStatusResult.getChannelValue());
                }
                onChanged();
                return this;
            }

            /* renamed from: m */
            public final b mergeUnknownFields(a1 a1Var) {
                return this;
            }

            public b n(int i10) {
                this.f15898f = i10;
                onChanged();
                return this;
            }

            public b o(int i10) {
                this.f15894b = i10;
                onChanged();
                return this;
            }

            /* renamed from: p */
            public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.setField(fieldDescriptor, obj);
            }

            /* renamed from: q */
            public b setRepeatedField2(Descriptors.FieldDescriptor fieldDescriptor, int i10, Object obj) {
                return (b) super.setRepeatedField(fieldDescriptor, i10, obj);
            }

            public b r(int i10) {
                this.f15897e = i10;
                onChanged();
                return this;
            }

            /* renamed from: s */
            public final b setUnknownFields(a1 a1Var) {
                return this;
            }

            /* synthetic */ b(a aVar) {
                this();
            }

            private b() {
                this.f15893a = "";
                this.f15894b = 0;
                this.f15895c = "";
                this.f15896d = "";
                this.f15897e = 0;
                this.f15898f = 0;
                maybeForceBuilderInitialization();
            }

            private b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.f15893a = "";
                this.f15894b = 0;
                this.f15895c = "";
                this.f15896d = "";
                this.f15897e = 0;
                this.f15898f = 0;
                maybeForceBuilderInitialization();
            }
        }

        /* synthetic */ DeviceStatusResult(i iVar, q qVar, a aVar) throws InvalidProtocolBufferException {
            this(iVar, qVar);
        }

        public static DeviceStatusResult getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return PushProto.f15881i;
        }

        public static b newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static DeviceStatusResult parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (DeviceStatusResult) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static DeviceStatusResult parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static l0<DeviceStatusResult> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof DeviceStatusResult)) {
                return super.equals(obj);
            }
            DeviceStatusResult deviceStatusResult = (DeviceStatusResult) obj;
            return (((((getWwid().equals(deviceStatusResult.getWwid())) && this.deviceType_ == deviceStatusResult.deviceType_) && getDeviceId().equals(deviceStatusResult.getDeviceId())) && getClientId().equals(deviceStatusResult.getClientId())) && this.result_ == deviceStatusResult.result_) && this.channel_ == deviceStatusResult.channel_;
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

        public ConstantProto.DeviceType getDeviceType() {
            ConstantProto.DeviceType valueOf = ConstantProto.DeviceType.valueOf(this.deviceType_);
            return valueOf == null ? ConstantProto.DeviceType.UNRECOGNIZED : valueOf;
        }

        public int getDeviceTypeValue() {
            return this.deviceType_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public l0<DeviceStatusResult> getParserForType() {
            return PARSER;
        }

        public ConstantProto.DeviceOnlineStatus getResult() {
            ConstantProto.DeviceOnlineStatus valueOf = ConstantProto.DeviceOnlineStatus.valueOf(this.result_);
            return valueOf == null ? ConstantProto.DeviceOnlineStatus.UNRECOGNIZED : valueOf;
        }

        public int getResultValue() {
            return this.result_;
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
            if (this.result_ != ConstantProto.DeviceOnlineStatus.UNKNOWN_STATUS.getNumber()) {
                i11 += CodedOutputStream.l(5, this.result_);
            }
            if (this.channel_ != ConstantProto.Channel.UNKNOWN_CHANNEL.getNumber()) {
                i11 += CodedOutputStream.l(6, this.channel_);
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
            int hashCode = ((((((((((((((((((((((((((779 + getDescriptorForType().hashCode()) * 37) + 1) * 53) + getWwid().hashCode()) * 37) + 2) * 53) + this.deviceType_) * 37) + 3) * 53) + getDeviceId().hashCode()) * 37) + 4) * 53) + getClientId().hashCode()) * 37) + 5) * 53) + this.result_) * 37) + 6) * 53) + this.channel_) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return PushProto.f15882j.e(DeviceStatusResult.class, b.class);
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
        /* renamed from: q */
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
            if (this.result_ != ConstantProto.DeviceOnlineStatus.UNKNOWN_STATUS.getNumber()) {
                codedOutputStream.m0(5, this.result_);
            }
            if (this.channel_ != ConstantProto.Channel.UNKNOWN_CHANNEL.getNumber()) {
                codedOutputStream.m0(6, this.channel_);
            }
        }

        /* synthetic */ DeviceStatusResult(GeneratedMessageV3.b bVar, a aVar) {
            this(bVar);
        }

        public static b newBuilder(DeviceStatusResult deviceStatusResult) {
            return DEFAULT_INSTANCE.toBuilder().l(deviceStatusResult);
        }

        public static DeviceStatusResult parseFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, qVar);
        }

        private DeviceStatusResult(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static DeviceStatusResult parseDelimitedFrom(InputStream inputStream, q qVar) throws IOException {
            return (DeviceStatusResult) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
        }

        public static DeviceStatusResult parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
        public DeviceStatusResult getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b toBuilder() {
            return this == DEFAULT_INSTANCE ? new b((a) null) : new b((a) null).l(this);
        }

        public static DeviceStatusResult parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b newBuilderForType() {
            return newBuilder();
        }

        private DeviceStatusResult() {
            this.memoizedIsInitialized = (byte) -1;
            this.wwid_ = "";
            this.deviceType_ = 0;
            this.deviceId_ = "";
            this.clientId_ = "";
            this.result_ = 0;
            this.channel_ = 0;
        }

        public static DeviceStatusResult parseFrom(InputStream inputStream) throws IOException {
            return (DeviceStatusResult) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static DeviceStatusResult parseFrom(InputStream inputStream, q qVar) throws IOException {
            return (DeviceStatusResult) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
        }

        public static DeviceStatusResult parseFrom(i iVar) throws IOException {
            return (DeviceStatusResult) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
        }

        public static DeviceStatusResult parseFrom(i iVar, q qVar) throws IOException {
            return (DeviceStatusResult) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
        }

        private DeviceStatusResult(i iVar, q qVar) throws InvalidProtocolBufferException {
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
                            } else if (F == 16) {
                                this.deviceType_ = iVar.o();
                            } else if (F == 26) {
                                this.deviceId_ = iVar.E();
                            } else if (F == 34) {
                                this.clientId_ = iVar.E();
                            } else if (F == 40) {
                                this.result_ = iVar.o();
                            } else if (F == 48) {
                                this.channel_ = iVar.o();
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
    public static final class MessageContent extends GeneratedMessageV3 implements d {
        public static final int MESSAGE_ID_FIELD_NUMBER = 4;
        public static final int PATH_FIELD_NUMBER = 2;
        public static final int PAYLOAD_FIELD_NUMBER = 1;
        public static final int SOURCE_FIELD_NUMBER = 3;
        public static final int TIMESTAMP_FIELD_NUMBER = 5;
        private static final long serialVersionUID = 0;
        private byte memoizedIsInitialized;
        private volatile Object messageId_;
        private volatile Object path_;
        private ByteString payload_;
        private volatile Object source_;
        private long timestamp_;
        private static final MessageContent DEFAULT_INSTANCE = new MessageContent();
        private static final l0<MessageContent> PARSER = new a();

        /* loaded from: classes2.dex */
        class a extends com.google.protobuf.c<MessageContent> {
            a() {
            }

            /* renamed from: a */
            public MessageContent parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
                return new MessageContent(iVar, qVar, null);
            }
        }

        /* loaded from: classes2.dex */
        public static final class b extends GeneratedMessageV3.b<b> implements d {

            /* renamed from: a  reason: collision with root package name */
            private ByteString f15899a;

            /* renamed from: b  reason: collision with root package name */
            private Object f15900b;

            /* renamed from: c  reason: collision with root package name */
            private Object f15901c;

            /* renamed from: d  reason: collision with root package name */
            private Object f15902d;

            /* renamed from: e  reason: collision with root package name */
            private long f15903e;

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
            public MessageContent build() {
                MessageContent c10 = buildPartial();
                if (c10.isInitialized()) {
                    return c10;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) c10);
            }

            /* renamed from: c */
            public MessageContent buildPartial() {
                MessageContent messageContent = new MessageContent(this, (a) null);
                messageContent.payload_ = this.f15899a;
                messageContent.path_ = this.f15900b;
                messageContent.source_ = this.f15901c;
                messageContent.messageId_ = this.f15902d;
                messageContent.timestamp_ = this.f15903e;
                onBuilt();
                return messageContent;
            }

            /* renamed from: d */
            public b clear() {
                super.clear();
                this.f15899a = ByteString.EMPTY;
                this.f15900b = "";
                this.f15901c = "";
                this.f15902d = "";
                this.f15903e = 0L;
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
                return PushProto.f15885m;
            }

            /* renamed from: i */
            public MessageContent getDefaultInstanceForType() {
                return MessageContent.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return PushProto.f15886n.e(MessageContent.class, b.class);
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
                MessageContent messageContent = null;
                try {
                    try {
                        MessageContent messageContent2 = (MessageContent) MessageContent.PARSER.parsePartialFrom(iVar, qVar);
                        if (messageContent2 != null) {
                            l(messageContent2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e10) {
                        messageContent = (MessageContent) e10.getUnfinishedMessage();
                        try {
                            throw e10.unwrapIOException();
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (messageContent != null) {
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (messageContent != null) {
                        l(messageContent);
                    }
                    throw th2;
                }
            }

            /* renamed from: k */
            public b mergeFrom(d0 d0Var) {
                if (d0Var instanceof MessageContent) {
                    return l((MessageContent) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            public b l(MessageContent messageContent) {
                if (messageContent == MessageContent.getDefaultInstance()) {
                    return this;
                }
                if (messageContent.getPayload() != ByteString.EMPTY) {
                    o(messageContent.getPayload());
                }
                if (!messageContent.getPath().isEmpty()) {
                    this.f15900b = messageContent.path_;
                    onChanged();
                }
                if (!messageContent.getSource().isEmpty()) {
                    this.f15901c = messageContent.source_;
                    onChanged();
                }
                if (!messageContent.getMessageId().isEmpty()) {
                    this.f15902d = messageContent.messageId_;
                    onChanged();
                }
                if (messageContent.getTimestamp() != 0) {
                    q(messageContent.getTimestamp());
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

            public b o(ByteString byteString) {
                Objects.requireNonNull(byteString);
                this.f15899a = byteString;
                onChanged();
                return this;
            }

            /* renamed from: p */
            public b setRepeatedField2(Descriptors.FieldDescriptor fieldDescriptor, int i10, Object obj) {
                return (b) super.setRepeatedField(fieldDescriptor, i10, obj);
            }

            public b q(long j10) {
                this.f15903e = j10;
                onChanged();
                return this;
            }

            /* renamed from: r */
            public final b setUnknownFields(a1 a1Var) {
                return this;
            }

            /* synthetic */ b(a aVar) {
                this();
            }

            private b() {
                this.f15899a = ByteString.EMPTY;
                this.f15900b = "";
                this.f15901c = "";
                this.f15902d = "";
                maybeForceBuilderInitialization();
            }

            private b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.f15899a = ByteString.EMPTY;
                this.f15900b = "";
                this.f15901c = "";
                this.f15902d = "";
                maybeForceBuilderInitialization();
            }
        }

        /* synthetic */ MessageContent(i iVar, q qVar, a aVar) throws InvalidProtocolBufferException {
            this(iVar, qVar);
        }

        public static MessageContent getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return PushProto.f15885m;
        }

        public static b newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static MessageContent parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (MessageContent) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static MessageContent parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static l0<MessageContent> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof MessageContent)) {
                return super.equals(obj);
            }
            MessageContent messageContent = (MessageContent) obj;
            return ((((getPayload().equals(messageContent.getPayload())) && getPath().equals(messageContent.getPath())) && getSource().equals(messageContent.getSource())) && getMessageId().equals(messageContent.getMessageId())) && getTimestamp() == messageContent.getTimestamp();
        }

        public String getMessageId() {
            Object obj = this.messageId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.messageId_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getMessageIdBytes() {
            Object obj = this.messageId_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.messageId_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public l0<MessageContent> getParserForType() {
            return PARSER;
        }

        public String getPath() {
            Object obj = this.path_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.path_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getPathBytes() {
            Object obj = this.path_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.path_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public ByteString getPayload() {
            return this.payload_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
        public int getSerializedSize() {
            int i10 = this.memoizedSize;
            if (i10 != -1) {
                return i10;
            }
            int i11 = 0;
            if (!this.payload_.isEmpty()) {
                i11 = 0 + CodedOutputStream.h(1, this.payload_);
            }
            if (!getPathBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(2, this.path_);
            }
            if (!getSourceBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(3, this.source_);
            }
            if (!getMessageIdBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(4, this.messageId_);
            }
            long j10 = this.timestamp_;
            if (j10 != 0) {
                i11 += CodedOutputStream.x(5, j10);
            }
            this.memoizedSize = i11;
            return i11;
        }

        public String getSource() {
            Object obj = this.source_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.source_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getSourceBytes() {
            Object obj = this.source_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.source_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public long getTimestamp() {
            return this.timestamp_;
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
            int hashCode = ((((((((((((((((((((((779 + getDescriptorForType().hashCode()) * 37) + 1) * 53) + getPayload().hashCode()) * 37) + 2) * 53) + getPath().hashCode()) * 37) + 3) * 53) + getSource().hashCode()) * 37) + 4) * 53) + getMessageId().hashCode()) * 37) + 5) * 53) + u.h(getTimestamp())) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return PushProto.f15886n.e(MessageContent.class, b.class);
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
        /* renamed from: l */
        public b newBuilderForType(GeneratedMessageV3.c cVar) {
            return new b(cVar, null);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (!this.payload_.isEmpty()) {
                codedOutputStream.i0(1, this.payload_);
            }
            if (!getPathBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.path_);
            }
            if (!getSourceBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 3, this.source_);
            }
            if (!getMessageIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 4, this.messageId_);
            }
            long j10 = this.timestamp_;
            if (j10 != 0) {
                codedOutputStream.y0(5, j10);
            }
        }

        /* synthetic */ MessageContent(GeneratedMessageV3.b bVar, a aVar) {
            this(bVar);
        }

        public static b newBuilder(MessageContent messageContent) {
            return DEFAULT_INSTANCE.toBuilder().l(messageContent);
        }

        public static MessageContent parseFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, qVar);
        }

        private MessageContent(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static MessageContent parseDelimitedFrom(InputStream inputStream, q qVar) throws IOException {
            return (MessageContent) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
        }

        public static MessageContent parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
        public MessageContent getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b toBuilder() {
            return this == DEFAULT_INSTANCE ? new b((a) null) : new b((a) null).l(this);
        }

        public static MessageContent parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b newBuilderForType() {
            return newBuilder();
        }

        private MessageContent() {
            this.memoizedIsInitialized = (byte) -1;
            this.payload_ = ByteString.EMPTY;
            this.path_ = "";
            this.source_ = "";
            this.messageId_ = "";
            this.timestamp_ = 0L;
        }

        public static MessageContent parseFrom(InputStream inputStream) throws IOException {
            return (MessageContent) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static MessageContent parseFrom(InputStream inputStream, q qVar) throws IOException {
            return (MessageContent) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
        }

        public static MessageContent parseFrom(i iVar) throws IOException {
            return (MessageContent) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
        }

        public static MessageContent parseFrom(i iVar, q qVar) throws IOException {
            return (MessageContent) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
        }

        private MessageContent(i iVar, q qVar) throws InvalidProtocolBufferException {
            this();
            boolean z10 = false;
            while (!z10) {
                try {
                    try {
                        int F = iVar.F();
                        z10 = true;
                        if (F != 0) {
                            if (F == 10) {
                                this.payload_ = iVar.m();
                            } else if (F == 18) {
                                this.path_ = iVar.E();
                            } else if (F == 26) {
                                this.source_ = iVar.E();
                            } else if (F == 34) {
                                this.messageId_ = iVar.E();
                            } else if (F == 40) {
                                this.timestamp_ = iVar.u();
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
    public enum PushNetWorkType implements m0 {
        NOT_LIMIT(0),
        WIFI(1),
        UNRECOGNIZED(-1);
        
        public static final int NOT_LIMIT_VALUE = 0;
        public static final int WIFI_VALUE = 1;
        private final int value;
        private static final u.b<PushNetWorkType> internalValueMap = new a();
        private static final PushNetWorkType[] VALUES = values();

        /* loaded from: classes2.dex */
        class a implements u.b<PushNetWorkType> {
            a() {
            }
        }

        PushNetWorkType(int i10) {
            this.value = i10;
        }

        public static PushNetWorkType forNumber(int i10) {
            if (i10 == 0) {
                return NOT_LIMIT;
            }
            if (i10 != 1) {
                return null;
            }
            return WIFI;
        }

        public static final Descriptors.d getDescriptor() {
            return PushProto.p().i().get(0);
        }

        public static u.b<PushNetWorkType> internalGetValueMap() {
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
        public static PushNetWorkType valueOf(int i10) {
            return forNumber(i10);
        }

        public static PushNetWorkType valueOf(Descriptors.e eVar) {
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
    public static final class PushRequest extends GeneratedMessageV3 implements g0 {
        public static final int CLIENT_ID_FIELD_NUMBER = 3;
        public static final int DEVICE_ID_FIELD_NUMBER = 2;
        public static final int SINGLE_MESSAGE_FIELD_NUMBER = 4;
        public static final int TRANSMISSION_TYPE_FIELD_NUMBER = 5;
        public static final int WWID_FIELD_NUMBER = 6;
        public static final int WWID_PUSH_REQUEST_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private int idCase_;
        private Object id_;
        private byte memoizedIsInitialized;
        private SingleMessage singleMessage_;
        private int transmissionType_;
        private static final PushRequest DEFAULT_INSTANCE = new PushRequest();
        private static final l0<PushRequest> PARSER = new a();

        /* loaded from: classes2.dex */
        public enum IdCase implements u.a {
            WWID_PUSH_REQUEST(1),
            DEVICE_ID(2),
            CLIENT_ID(3),
            WWID(6),
            ID_NOT_SET(0);
            
            private final int value;

            IdCase(int i10) {
                this.value = i10;
            }

            public static IdCase forNumber(int i10) {
                if (i10 == 0) {
                    return ID_NOT_SET;
                }
                if (i10 == 1) {
                    return WWID_PUSH_REQUEST;
                }
                if (i10 == 2) {
                    return DEVICE_ID;
                }
                if (i10 == 3) {
                    return CLIENT_ID;
                }
                if (i10 != 6) {
                    return null;
                }
                return WWID;
            }

            @Override // com.google.protobuf.u.a
            public int getNumber() {
                return this.value;
            }

            @Deprecated
            public static IdCase valueOf(int i10) {
                return forNumber(i10);
            }
        }

        /* loaded from: classes2.dex */
        class a extends com.google.protobuf.c<PushRequest> {
            a() {
            }

            /* renamed from: a */
            public PushRequest parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
                return new PushRequest(iVar, qVar, null);
            }
        }

        /* loaded from: classes2.dex */
        public static final class b extends GeneratedMessageV3.b<b> implements g0 {

            /* renamed from: a  reason: collision with root package name */
            private int f15904a;

            /* renamed from: b  reason: collision with root package name */
            private Object f15905b;

            /* renamed from: c  reason: collision with root package name */
            private q0<WwidPushRequest, WwidPushRequest.b, f> f15906c;

            /* renamed from: d  reason: collision with root package name */
            private SingleMessage f15907d;

            /* renamed from: e  reason: collision with root package name */
            private q0<SingleMessage, SingleMessage.b, e> f15908e;

            /* renamed from: f  reason: collision with root package name */
            private int f15909f;

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
            public PushRequest build() {
                PushRequest c10 = buildPartial();
                if (c10.isInitialized()) {
                    return c10;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) c10);
            }

            /* renamed from: c */
            public PushRequest buildPartial() {
                PushRequest pushRequest = new PushRequest(this, (a) null);
                if (this.f15904a == 1) {
                    q0<WwidPushRequest, WwidPushRequest.b, f> q0Var = this.f15906c;
                    if (q0Var == null) {
                        pushRequest.id_ = this.f15905b;
                    } else {
                        pushRequest.id_ = q0Var.b();
                    }
                }
                if (this.f15904a == 2) {
                    pushRequest.id_ = this.f15905b;
                }
                if (this.f15904a == 3) {
                    pushRequest.id_ = this.f15905b;
                }
                if (this.f15904a == 6) {
                    pushRequest.id_ = this.f15905b;
                }
                q0<SingleMessage, SingleMessage.b, e> q0Var2 = this.f15908e;
                if (q0Var2 == null) {
                    pushRequest.singleMessage_ = this.f15907d;
                } else {
                    pushRequest.singleMessage_ = q0Var2.b();
                }
                pushRequest.transmissionType_ = this.f15909f;
                pushRequest.idCase_ = this.f15904a;
                onBuilt();
                return pushRequest;
            }

            /* renamed from: d */
            public b clear() {
                super.clear();
                if (this.f15908e == null) {
                    this.f15907d = null;
                } else {
                    this.f15907d = null;
                    this.f15908e = null;
                }
                this.f15909f = 0;
                this.f15904a = 0;
                this.f15905b = null;
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
                return PushProto.f15873a;
            }

            /* renamed from: i */
            public PushRequest getDefaultInstanceForType() {
                return PushRequest.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return PushProto.f15874b.e(PushRequest.class, b.class);
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
                PushRequest pushRequest = null;
                try {
                    try {
                        PushRequest pushRequest2 = (PushRequest) PushRequest.PARSER.parsePartialFrom(iVar, qVar);
                        if (pushRequest2 != null) {
                            l(pushRequest2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e10) {
                        pushRequest = (PushRequest) e10.getUnfinishedMessage();
                        try {
                            throw e10.unwrapIOException();
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (pushRequest != null) {
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (pushRequest != null) {
                        l(pushRequest);
                    }
                    throw th2;
                }
            }

            /* renamed from: k */
            public b mergeFrom(d0 d0Var) {
                if (d0Var instanceof PushRequest) {
                    return l((PushRequest) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            public b l(PushRequest pushRequest) {
                if (pushRequest == PushRequest.getDefaultInstance()) {
                    return this;
                }
                if (pushRequest.hasSingleMessage()) {
                    m(pushRequest.getSingleMessage());
                }
                if (pushRequest.transmissionType_ != 0) {
                    r(pushRequest.getTransmissionTypeValue());
                }
                int i10 = b.f15921a[pushRequest.getIdCase().ordinal()];
                if (i10 == 1) {
                    o(pushRequest.getWwidPushRequest());
                } else if (i10 == 2) {
                    this.f15904a = 2;
                    this.f15905b = pushRequest.id_;
                    onChanged();
                } else if (i10 == 3) {
                    this.f15904a = 3;
                    this.f15905b = pushRequest.id_;
                    onChanged();
                } else if (i10 == 4) {
                    this.f15904a = 6;
                    this.f15905b = pushRequest.id_;
                    onChanged();
                }
                onChanged();
                return this;
            }

            public b m(SingleMessage singleMessage) {
                q0<SingleMessage, SingleMessage.b, e> q0Var = this.f15908e;
                if (q0Var == null) {
                    SingleMessage singleMessage2 = this.f15907d;
                    if (singleMessage2 != null) {
                        this.f15907d = SingleMessage.newBuilder(singleMessage2).m(singleMessage).buildPartial();
                    } else {
                        this.f15907d = singleMessage;
                    }
                    onChanged();
                } else {
                    q0Var.h(singleMessage);
                }
                return this;
            }

            /* renamed from: n */
            public final b mergeUnknownFields(a1 a1Var) {
                return this;
            }

            public b o(WwidPushRequest wwidPushRequest) {
                q0<WwidPushRequest, WwidPushRequest.b, f> q0Var = this.f15906c;
                if (q0Var == null) {
                    if (this.f15904a != 1 || this.f15905b == WwidPushRequest.getDefaultInstance()) {
                        this.f15905b = wwidPushRequest;
                    } else {
                        this.f15905b = WwidPushRequest.newBuilder((WwidPushRequest) this.f15905b).l(wwidPushRequest).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.f15904a == 1) {
                        q0Var.h(wwidPushRequest);
                    }
                    this.f15906c.j(wwidPushRequest);
                }
                this.f15904a = 1;
                return this;
            }

            /* renamed from: p */
            public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.setField(fieldDescriptor, obj);
            }

            /* renamed from: q */
            public b setRepeatedField2(Descriptors.FieldDescriptor fieldDescriptor, int i10, Object obj) {
                return (b) super.setRepeatedField(fieldDescriptor, i10, obj);
            }

            public b r(int i10) {
                this.f15909f = i10;
                onChanged();
                return this;
            }

            /* renamed from: s */
            public final b setUnknownFields(a1 a1Var) {
                return this;
            }

            /* synthetic */ b(a aVar) {
                this();
            }

            private b() {
                this.f15904a = 0;
                this.f15907d = null;
                this.f15909f = 0;
                maybeForceBuilderInitialization();
            }

            private b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.f15904a = 0;
                this.f15907d = null;
                this.f15909f = 0;
                maybeForceBuilderInitialization();
            }
        }

        /* synthetic */ PushRequest(i iVar, q qVar, a aVar) throws InvalidProtocolBufferException {
            this(iVar, qVar);
        }

        public static PushRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return PushProto.f15873a;
        }

        public static b newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static PushRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (PushRequest) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static PushRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static l0<PushRequest> parser() {
            return PARSER;
        }

        /* JADX WARN: Code restructure failed: missing block: B:42:0x0073, code lost:
            if (getWwid().equals(r6.getWwid()) != false) goto L53;
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x0084, code lost:
            if (getClientId().equals(r6.getClientId()) != false) goto L53;
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x0095, code lost:
            if (getDeviceId().equals(r6.getDeviceId()) != false) goto L53;
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x00a6, code lost:
            if (getWwidPushRequest().equals(r6.getWwidPushRequest()) != false) goto L53;
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
            if (!(obj instanceof PushRequest)) {
                return super.equals(obj);
            }
            PushRequest pushRequest = (PushRequest) obj;
            boolean z11 = hasSingleMessage() == pushRequest.hasSingleMessage();
            if (hasSingleMessage()) {
                z11 = z11 && getSingleMessage().equals(pushRequest.getSingleMessage());
            }
            boolean z12 = (z11 && this.transmissionType_ == pushRequest.transmissionType_) && getIdCase().equals(pushRequest.getIdCase());
            if (!z12) {
                return false;
            }
            int i10 = this.idCase_;
            if (i10 == 1) {
                if (z12) {
                }
                z10 = false;
                return z10;
            } else if (i10 == 2) {
                if (z12) {
                }
                z10 = false;
                return z10;
            } else if (i10 == 3) {
                if (z12) {
                }
                z10 = false;
                return z10;
            } else if (i10 != 6) {
                return z12;
            } else {
                if (z12) {
                }
                z10 = false;
                return z10;
            }
        }

        public String getClientId() {
            String str = this.idCase_ == 3 ? this.id_ : "";
            if (str instanceof String) {
                return (String) str;
            }
            String stringUtf8 = ((ByteString) str).toStringUtf8();
            if (this.idCase_ == 3) {
                this.id_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getClientIdBytes() {
            String str = this.idCase_ == 3 ? this.id_ : "";
            if (!(str instanceof String)) {
                return (ByteString) str;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) str);
            if (this.idCase_ == 3) {
                this.id_ = copyFromUtf8;
            }
            return copyFromUtf8;
        }

        public String getDeviceId() {
            String str = this.idCase_ == 2 ? this.id_ : "";
            if (str instanceof String) {
                return (String) str;
            }
            String stringUtf8 = ((ByteString) str).toStringUtf8();
            if (this.idCase_ == 2) {
                this.id_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getDeviceIdBytes() {
            String str = this.idCase_ == 2 ? this.id_ : "";
            if (!(str instanceof String)) {
                return (ByteString) str;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) str);
            if (this.idCase_ == 2) {
                this.id_ = copyFromUtf8;
            }
            return copyFromUtf8;
        }

        public IdCase getIdCase() {
            return IdCase.forNumber(this.idCase_);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public l0<PushRequest> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
        public int getSerializedSize() {
            int i10 = this.memoizedSize;
            if (i10 != -1) {
                return i10;
            }
            int i11 = 0;
            if (this.idCase_ == 1) {
                i11 = 0 + CodedOutputStream.E(1, (WwidPushRequest) this.id_);
            }
            if (this.idCase_ == 2) {
                i11 += GeneratedMessageV3.computeStringSize(2, this.id_);
            }
            if (this.idCase_ == 3) {
                i11 += GeneratedMessageV3.computeStringSize(3, this.id_);
            }
            if (this.singleMessage_ != null) {
                i11 += CodedOutputStream.E(4, getSingleMessage());
            }
            if (this.transmissionType_ != TransmissionType.NOT_DEFINE.getNumber()) {
                i11 += CodedOutputStream.l(5, this.transmissionType_);
            }
            if (this.idCase_ == 6) {
                i11 += GeneratedMessageV3.computeStringSize(6, this.id_);
            }
            this.memoizedSize = i11;
            return i11;
        }

        public SingleMessage getSingleMessage() {
            SingleMessage singleMessage = this.singleMessage_;
            return singleMessage == null ? SingleMessage.getDefaultInstance() : singleMessage;
        }

        public e getSingleMessageOrBuilder() {
            return getSingleMessage();
        }

        public TransmissionType getTransmissionType() {
            TransmissionType valueOf = TransmissionType.valueOf(this.transmissionType_);
            return valueOf == null ? TransmissionType.UNRECOGNIZED : valueOf;
        }

        public int getTransmissionTypeValue() {
            return this.transmissionType_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.g0
        public final a1 getUnknownFields() {
            return a1.c();
        }

        public String getWwid() {
            String str = this.idCase_ == 6 ? this.id_ : "";
            if (str instanceof String) {
                return (String) str;
            }
            String stringUtf8 = ((ByteString) str).toStringUtf8();
            if (this.idCase_ == 6) {
                this.id_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getWwidBytes() {
            String str = this.idCase_ == 6 ? this.id_ : "";
            if (!(str instanceof String)) {
                return (ByteString) str;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) str);
            if (this.idCase_ == 6) {
                this.id_ = copyFromUtf8;
            }
            return copyFromUtf8;
        }

        public WwidPushRequest getWwidPushRequest() {
            if (this.idCase_ == 1) {
                return (WwidPushRequest) this.id_;
            }
            return WwidPushRequest.getDefaultInstance();
        }

        public f getWwidPushRequestOrBuilder() {
            if (this.idCase_ == 1) {
                return (WwidPushRequest) this.id_;
            }
            return WwidPushRequest.getDefaultInstance();
        }

        public boolean hasSingleMessage() {
            return this.singleMessage_ != null;
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
            if (hasSingleMessage()) {
                hashCode = (((hashCode * 37) + 4) * 53) + getSingleMessage().hashCode();
            }
            int i13 = (((hashCode * 37) + 5) * 53) + this.transmissionType_;
            int i14 = this.idCase_;
            if (i14 == 1) {
                i11 = ((i13 * 37) + 1) * 53;
                i10 = getWwidPushRequest().hashCode();
            } else if (i14 == 2) {
                i11 = ((i13 * 37) + 2) * 53;
                i10 = getDeviceId().hashCode();
            } else if (i14 != 3) {
                if (i14 == 6) {
                    i11 = ((i13 * 37) + 6) * 53;
                    i10 = getWwid().hashCode();
                }
                int hashCode2 = (i13 * 29) + this.unknownFields.hashCode();
                this.memoizedHashCode = hashCode2;
                return hashCode2;
            } else {
                i11 = ((i13 * 37) + 3) * 53;
                i10 = getClientId().hashCode();
            }
            i13 = i11 + i10;
            int hashCode22 = (i13 * 29) + this.unknownFields.hashCode();
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
            return PushProto.f15874b.e(PushRequest.class, b.class);
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
            if (this.idCase_ == 1) {
                codedOutputStream.A0(1, (WwidPushRequest) this.id_);
            }
            if (this.idCase_ == 2) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.id_);
            }
            if (this.idCase_ == 3) {
                GeneratedMessageV3.writeString(codedOutputStream, 3, this.id_);
            }
            if (this.singleMessage_ != null) {
                codedOutputStream.A0(4, getSingleMessage());
            }
            if (this.transmissionType_ != TransmissionType.NOT_DEFINE.getNumber()) {
                codedOutputStream.m0(5, this.transmissionType_);
            }
            if (this.idCase_ == 6) {
                GeneratedMessageV3.writeString(codedOutputStream, 6, this.id_);
            }
        }

        /* synthetic */ PushRequest(GeneratedMessageV3.b bVar, a aVar) {
            this(bVar);
        }

        public static b newBuilder(PushRequest pushRequest) {
            return DEFAULT_INSTANCE.toBuilder().l(pushRequest);
        }

        public static PushRequest parseFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, qVar);
        }

        private PushRequest(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.idCase_ = 0;
            this.memoizedIsInitialized = (byte) -1;
        }

        public static PushRequest parseDelimitedFrom(InputStream inputStream, q qVar) throws IOException {
            return (PushRequest) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
        }

        public static PushRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
        public PushRequest getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b toBuilder() {
            return this == DEFAULT_INSTANCE ? new b((a) null) : new b((a) null).l(this);
        }

        public static PushRequest parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b newBuilderForType() {
            return newBuilder();
        }

        public static PushRequest parseFrom(InputStream inputStream) throws IOException {
            return (PushRequest) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        private PushRequest() {
            this.idCase_ = 0;
            this.memoizedIsInitialized = (byte) -1;
            this.transmissionType_ = 0;
        }

        public static PushRequest parseFrom(InputStream inputStream, q qVar) throws IOException {
            return (PushRequest) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
        }

        public static PushRequest parseFrom(i iVar) throws IOException {
            return (PushRequest) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
        }

        private PushRequest(i iVar, q qVar) throws InvalidProtocolBufferException {
            this();
            boolean z10 = false;
            while (!z10) {
                try {
                    try {
                        try {
                            int F = iVar.F();
                            if (F != 0) {
                                SingleMessage.b bVar = null;
                                WwidPushRequest.b builder = null;
                                if (F == 10) {
                                    builder = this.idCase_ == 1 ? ((WwidPushRequest) this.id_).toBuilder() : builder;
                                    e0 v10 = iVar.v(WwidPushRequest.parser(), qVar);
                                    this.id_ = v10;
                                    if (builder != null) {
                                        builder.l((WwidPushRequest) v10);
                                        this.id_ = builder.buildPartial();
                                    }
                                    this.idCase_ = 1;
                                } else if (F == 18) {
                                    String E = iVar.E();
                                    this.idCase_ = 2;
                                    this.id_ = E;
                                } else if (F == 26) {
                                    String E2 = iVar.E();
                                    this.idCase_ = 3;
                                    this.id_ = E2;
                                } else if (F == 34) {
                                    SingleMessage singleMessage = this.singleMessage_;
                                    bVar = singleMessage != null ? singleMessage.toBuilder() : bVar;
                                    SingleMessage singleMessage2 = (SingleMessage) iVar.v(SingleMessage.parser(), qVar);
                                    this.singleMessage_ = singleMessage2;
                                    if (bVar != null) {
                                        bVar.m(singleMessage2);
                                        this.singleMessage_ = bVar.buildPartial();
                                    }
                                } else if (F == 40) {
                                    this.transmissionType_ = iVar.o();
                                } else if (F == 50) {
                                    String E3 = iVar.E();
                                    this.idCase_ = 6;
                                    this.id_ = E3;
                                } else if (!iVar.I(F)) {
                                }
                            }
                            z10 = true;
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

        public static PushRequest parseFrom(i iVar, q qVar) throws IOException {
            return (PushRequest) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
        }
    }

    /* loaded from: classes2.dex */
    public static final class PushResponse extends GeneratedMessageV3 implements g0 {
        public static final int ERR_CODE_FIELD_NUMBER = 1;
        public static final int ERR_MSG_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private int errCode_;
        private volatile Object errMsg_;
        private byte memoizedIsInitialized;
        private static final PushResponse DEFAULT_INSTANCE = new PushResponse();
        private static final l0<PushResponse> PARSER = new a();

        /* loaded from: classes2.dex */
        class a extends com.google.protobuf.c<PushResponse> {
            a() {
            }

            /* renamed from: a */
            public PushResponse parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
                return new PushResponse(iVar, qVar, null);
            }
        }

        /* loaded from: classes2.dex */
        public static final class b extends GeneratedMessageV3.b<b> implements g0 {

            /* renamed from: a  reason: collision with root package name */
            private int f15910a;

            /* renamed from: b  reason: collision with root package name */
            private Object f15911b;

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
            public PushResponse build() {
                PushResponse c10 = buildPartial();
                if (c10.isInitialized()) {
                    return c10;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) c10);
            }

            /* renamed from: c */
            public PushResponse buildPartial() {
                PushResponse pushResponse = new PushResponse(this, (a) null);
                pushResponse.errCode_ = this.f15910a;
                pushResponse.errMsg_ = this.f15911b;
                onBuilt();
                return pushResponse;
            }

            /* renamed from: d */
            public b clear() {
                super.clear();
                this.f15910a = 0;
                this.f15911b = "";
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
                return PushProto.f15875c;
            }

            /* renamed from: i */
            public PushResponse getDefaultInstanceForType() {
                return PushResponse.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return PushProto.f15876d.e(PushResponse.class, b.class);
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
                PushResponse pushResponse = null;
                try {
                    try {
                        PushResponse pushResponse2 = (PushResponse) PushResponse.PARSER.parsePartialFrom(iVar, qVar);
                        if (pushResponse2 != null) {
                            l(pushResponse2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e10) {
                        pushResponse = (PushResponse) e10.getUnfinishedMessage();
                        try {
                            throw e10.unwrapIOException();
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (pushResponse != null) {
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (pushResponse != null) {
                        l(pushResponse);
                    }
                    throw th2;
                }
            }

            /* renamed from: k */
            public b mergeFrom(d0 d0Var) {
                if (d0Var instanceof PushResponse) {
                    return l((PushResponse) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            public b l(PushResponse pushResponse) {
                if (pushResponse == PushResponse.getDefaultInstance()) {
                    return this;
                }
                if (pushResponse.getErrCode() != 0) {
                    n(pushResponse.getErrCode());
                }
                if (!pushResponse.getErrMsg().isEmpty()) {
                    this.f15911b = pushResponse.errMsg_;
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
                this.f15910a = i10;
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
                this.f15911b = "";
                maybeForceBuilderInitialization();
            }

            private b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.f15911b = "";
                maybeForceBuilderInitialization();
            }
        }

        /* synthetic */ PushResponse(i iVar, q qVar, a aVar) throws InvalidProtocolBufferException {
            this(iVar, qVar);
        }

        public static PushResponse getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return PushProto.f15875c;
        }

        public static b newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static PushResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (PushResponse) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static PushResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static l0<PushResponse> parser() {
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
            if (!(obj instanceof PushResponse)) {
                return super.equals(obj);
            }
            PushResponse pushResponse = (PushResponse) obj;
            return (getErrCode() == pushResponse.getErrCode()) && getErrMsg().equals(pushResponse.getErrMsg());
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
        public l0<PushResponse> getParserForType() {
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
            return PushProto.f15876d.e(PushResponse.class, b.class);
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

        /* synthetic */ PushResponse(GeneratedMessageV3.b bVar, a aVar) {
            this(bVar);
        }

        public static b newBuilder(PushResponse pushResponse) {
            return DEFAULT_INSTANCE.toBuilder().l(pushResponse);
        }

        public static PushResponse parseFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, qVar);
        }

        private PushResponse(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static PushResponse parseDelimitedFrom(InputStream inputStream, q qVar) throws IOException {
            return (PushResponse) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
        }

        public static PushResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
        public PushResponse getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b toBuilder() {
            return this == DEFAULT_INSTANCE ? new b((a) null) : new b((a) null).l(this);
        }

        public static PushResponse parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b newBuilderForType() {
            return newBuilder();
        }

        private PushResponse() {
            this.memoizedIsInitialized = (byte) -1;
            this.errCode_ = 0;
            this.errMsg_ = "";
        }

        public static PushResponse parseFrom(InputStream inputStream) throws IOException {
            return (PushResponse) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static PushResponse parseFrom(InputStream inputStream, q qVar) throws IOException {
            return (PushResponse) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
        }

        private PushResponse(i iVar, q qVar) throws InvalidProtocolBufferException {
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

        public static PushResponse parseFrom(i iVar) throws IOException {
            return (PushResponse) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
        }

        public static PushResponse parseFrom(i iVar, q qVar) throws IOException {
            return (PushResponse) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
        }
    }

    /* loaded from: classes2.dex */
    public static final class SingleMessage extends GeneratedMessageV3 implements e {
        public static final int CONTENT_FIELD_NUMBER = 7;
        public static final int NOT_OFFLINE_FIELD_NUMBER = 4;
        public static final int OFFLINE_EXPIRE_TIME_FIELD_NUMBER = 5;
        public static final int PRIORITY_FIELD_NUMBER = 3;
        public static final int PUSH_NETWORK_TYPE_FIELD_NUMBER = 6;
        private static final long serialVersionUID = 0;
        private MessageContent content_;
        private byte memoizedIsInitialized;
        private boolean notOffline_;
        private long offlineExpireTime_;
        private int priority_;
        private int pushNetworkType_;
        private static final SingleMessage DEFAULT_INSTANCE = new SingleMessage();
        private static final l0<SingleMessage> PARSER = new a();

        /* loaded from: classes2.dex */
        class a extends com.google.protobuf.c<SingleMessage> {
            a() {
            }

            /* renamed from: a */
            public SingleMessage parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
                return new SingleMessage(iVar, qVar, null);
            }
        }

        /* loaded from: classes2.dex */
        public static final class b extends GeneratedMessageV3.b<b> implements e {

            /* renamed from: a  reason: collision with root package name */
            private int f15912a;

            /* renamed from: b  reason: collision with root package name */
            private boolean f15913b;

            /* renamed from: c  reason: collision with root package name */
            private long f15914c;

            /* renamed from: d  reason: collision with root package name */
            private int f15915d;

            /* renamed from: e  reason: collision with root package name */
            private MessageContent f15916e;

            /* renamed from: f  reason: collision with root package name */
            private q0<MessageContent, MessageContent.b, d> f15917f;

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
            public SingleMessage build() {
                SingleMessage c10 = buildPartial();
                if (c10.isInitialized()) {
                    return c10;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) c10);
            }

            /* renamed from: c */
            public SingleMessage buildPartial() {
                SingleMessage singleMessage = new SingleMessage(this, (a) null);
                singleMessage.priority_ = this.f15912a;
                singleMessage.notOffline_ = this.f15913b;
                singleMessage.offlineExpireTime_ = this.f15914c;
                singleMessage.pushNetworkType_ = this.f15915d;
                q0<MessageContent, MessageContent.b, d> q0Var = this.f15917f;
                if (q0Var == null) {
                    singleMessage.content_ = this.f15916e;
                } else {
                    singleMessage.content_ = q0Var.b();
                }
                onBuilt();
                return singleMessage;
            }

            /* renamed from: d */
            public b clear() {
                super.clear();
                this.f15912a = 0;
                this.f15913b = false;
                this.f15914c = 0L;
                this.f15915d = 0;
                if (this.f15917f == null) {
                    this.f15916e = null;
                } else {
                    this.f15916e = null;
                    this.f15917f = null;
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
                return PushProto.f15883k;
            }

            /* renamed from: i */
            public SingleMessage getDefaultInstanceForType() {
                return SingleMessage.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return PushProto.f15884l.e(SingleMessage.class, b.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.f0
            public final boolean isInitialized() {
                return true;
            }

            public b j(MessageContent messageContent) {
                q0<MessageContent, MessageContent.b, d> q0Var = this.f15917f;
                if (q0Var == null) {
                    MessageContent messageContent2 = this.f15916e;
                    if (messageContent2 != null) {
                        this.f15916e = MessageContent.newBuilder(messageContent2).l(messageContent).buildPartial();
                    } else {
                        this.f15916e = messageContent;
                    }
                    onChanged();
                } else {
                    q0Var.h(messageContent);
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
                SingleMessage singleMessage = null;
                try {
                    try {
                        SingleMessage singleMessage2 = (SingleMessage) SingleMessage.PARSER.parsePartialFrom(iVar, qVar);
                        if (singleMessage2 != null) {
                            m(singleMessage2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e10) {
                        singleMessage = (SingleMessage) e10.getUnfinishedMessage();
                        try {
                            throw e10.unwrapIOException();
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (singleMessage != null) {
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (singleMessage != null) {
                        m(singleMessage);
                    }
                    throw th2;
                }
            }

            /* renamed from: l */
            public b mergeFrom(d0 d0Var) {
                if (d0Var instanceof SingleMessage) {
                    return m((SingleMessage) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            public b m(SingleMessage singleMessage) {
                if (singleMessage == SingleMessage.getDefaultInstance()) {
                    return this;
                }
                if (singleMessage.getPriority() != 0) {
                    r(singleMessage.getPriority());
                }
                if (singleMessage.getNotOffline()) {
                    p(singleMessage.getNotOffline());
                }
                if (singleMessage.getOfflineExpireTime() != 0) {
                    q(singleMessage.getOfflineExpireTime());
                }
                if (singleMessage.pushNetworkType_ != 0) {
                    s(singleMessage.getPushNetworkTypeValue());
                }
                if (singleMessage.hasContent()) {
                    j(singleMessage.getContent());
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

            public b p(boolean z10) {
                this.f15913b = z10;
                onChanged();
                return this;
            }

            public b q(long j10) {
                this.f15914c = j10;
                onChanged();
                return this;
            }

            public b r(int i10) {
                this.f15912a = i10;
                onChanged();
                return this;
            }

            public b s(int i10) {
                this.f15915d = i10;
                onChanged();
                return this;
            }

            /* renamed from: t */
            public b setRepeatedField2(Descriptors.FieldDescriptor fieldDescriptor, int i10, Object obj) {
                return (b) super.setRepeatedField(fieldDescriptor, i10, obj);
            }

            /* renamed from: u */
            public final b setUnknownFields(a1 a1Var) {
                return this;
            }

            /* synthetic */ b(a aVar) {
                this();
            }

            private b() {
                this.f15915d = 0;
                this.f15916e = null;
                maybeForceBuilderInitialization();
            }

            private b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.f15915d = 0;
                this.f15916e = null;
                maybeForceBuilderInitialization();
            }
        }

        /* synthetic */ SingleMessage(i iVar, q qVar, a aVar) throws InvalidProtocolBufferException {
            this(iVar, qVar);
        }

        public static SingleMessage getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return PushProto.f15883k;
        }

        public static b newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static SingleMessage parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (SingleMessage) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static SingleMessage parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static l0<SingleMessage> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            boolean z10 = true;
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof SingleMessage)) {
                return super.equals(obj);
            }
            SingleMessage singleMessage = (SingleMessage) obj;
            boolean z11 = ((((getPriority() == singleMessage.getPriority()) && getNotOffline() == singleMessage.getNotOffline()) && (getOfflineExpireTime() > singleMessage.getOfflineExpireTime() ? 1 : (getOfflineExpireTime() == singleMessage.getOfflineExpireTime() ? 0 : -1)) == 0) && this.pushNetworkType_ == singleMessage.pushNetworkType_) && hasContent() == singleMessage.hasContent();
            if (!hasContent()) {
                return z11;
            }
            if (!z11 || !getContent().equals(singleMessage.getContent())) {
                z10 = false;
            }
            return z10;
        }

        public MessageContent getContent() {
            MessageContent messageContent = this.content_;
            return messageContent == null ? MessageContent.getDefaultInstance() : messageContent;
        }

        public d getContentOrBuilder() {
            return getContent();
        }

        public boolean getNotOffline() {
            return this.notOffline_;
        }

        public long getOfflineExpireTime() {
            return this.offlineExpireTime_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public l0<SingleMessage> getParserForType() {
            return PARSER;
        }

        public int getPriority() {
            return this.priority_;
        }

        public PushNetWorkType getPushNetworkType() {
            PushNetWorkType valueOf = PushNetWorkType.valueOf(this.pushNetworkType_);
            return valueOf == null ? PushNetWorkType.UNRECOGNIZED : valueOf;
        }

        public int getPushNetworkTypeValue() {
            return this.pushNetworkType_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
        public int getSerializedSize() {
            int i10 = this.memoizedSize;
            if (i10 != -1) {
                return i10;
            }
            int i11 = 0;
            int i12 = this.priority_;
            if (i12 != 0) {
                i11 = 0 + CodedOutputStream.v(3, i12);
            }
            boolean z10 = this.notOffline_;
            if (z10) {
                i11 += CodedOutputStream.e(4, z10);
            }
            long j10 = this.offlineExpireTime_;
            if (j10 != 0) {
                i11 += CodedOutputStream.x(5, j10);
            }
            if (this.pushNetworkType_ != PushNetWorkType.NOT_LIMIT.getNumber()) {
                i11 += CodedOutputStream.l(6, this.pushNetworkType_);
            }
            if (this.content_ != null) {
                i11 += CodedOutputStream.E(7, getContent());
            }
            this.memoizedSize = i11;
            return i11;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.g0
        public final a1 getUnknownFields() {
            return a1.c();
        }

        public boolean hasContent() {
            return this.content_ != null;
        }

        @Override // com.google.protobuf.a
        public int hashCode() {
            int i10 = this.memoizedHashCode;
            if (i10 != 0) {
                return i10;
            }
            int hashCode = ((((((((((((((((779 + getDescriptorForType().hashCode()) * 37) + 3) * 53) + getPriority()) * 37) + 4) * 53) + u.c(getNotOffline())) * 37) + 5) * 53) + u.h(getOfflineExpireTime())) * 37) + 6) * 53) + this.pushNetworkType_;
            if (hasContent()) {
                hashCode = (((hashCode * 37) + 7) * 53) + getContent().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return PushProto.f15884l.e(SingleMessage.class, b.class);
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
        /* renamed from: k */
        public b newBuilderForType(GeneratedMessageV3.c cVar) {
            return new b(cVar, null);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            int i10 = this.priority_;
            if (i10 != 0) {
                codedOutputStream.w0(3, i10);
            }
            boolean z10 = this.notOffline_;
            if (z10) {
                codedOutputStream.e0(4, z10);
            }
            long j10 = this.offlineExpireTime_;
            if (j10 != 0) {
                codedOutputStream.y0(5, j10);
            }
            if (this.pushNetworkType_ != PushNetWorkType.NOT_LIMIT.getNumber()) {
                codedOutputStream.m0(6, this.pushNetworkType_);
            }
            if (this.content_ != null) {
                codedOutputStream.A0(7, getContent());
            }
        }

        /* synthetic */ SingleMessage(GeneratedMessageV3.b bVar, a aVar) {
            this(bVar);
        }

        public static b newBuilder(SingleMessage singleMessage) {
            return DEFAULT_INSTANCE.toBuilder().m(singleMessage);
        }

        public static SingleMessage parseFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, qVar);
        }

        private SingleMessage(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static SingleMessage parseDelimitedFrom(InputStream inputStream, q qVar) throws IOException {
            return (SingleMessage) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
        }

        public static SingleMessage parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
        public SingleMessage getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b toBuilder() {
            return this == DEFAULT_INSTANCE ? new b((a) null) : new b((a) null).m(this);
        }

        public static SingleMessage parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b newBuilderForType() {
            return newBuilder();
        }

        private SingleMessage() {
            this.memoizedIsInitialized = (byte) -1;
            this.priority_ = 0;
            this.notOffline_ = false;
            this.offlineExpireTime_ = 0L;
            this.pushNetworkType_ = 0;
        }

        public static SingleMessage parseFrom(InputStream inputStream) throws IOException {
            return (SingleMessage) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static SingleMessage parseFrom(InputStream inputStream, q qVar) throws IOException {
            return (SingleMessage) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
        }

        public static SingleMessage parseFrom(i iVar) throws IOException {
            return (SingleMessage) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
        }

        private SingleMessage(i iVar, q qVar) throws InvalidProtocolBufferException {
            this();
            boolean z10 = false;
            while (!z10) {
                try {
                    try {
                        int F = iVar.F();
                        z10 = true;
                        if (F != 0) {
                            if (F == 24) {
                                this.priority_ = iVar.t();
                            } else if (F == 32) {
                                this.notOffline_ = iVar.l();
                            } else if (F == 40) {
                                this.offlineExpireTime_ = iVar.u();
                            } else if (F == 48) {
                                this.pushNetworkType_ = iVar.o();
                            } else if (F == 58) {
                                MessageContent.b bVar = null;
                                MessageContent messageContent = this.content_;
                                bVar = messageContent != null ? messageContent.toBuilder() : bVar;
                                MessageContent messageContent2 = (MessageContent) iVar.v(MessageContent.parser(), qVar);
                                this.content_ = messageContent2;
                                if (bVar != null) {
                                    bVar.l(messageContent2);
                                    this.content_ = bVar.buildPartial();
                                }
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

        public static SingleMessage parseFrom(i iVar, q qVar) throws IOException {
            return (SingleMessage) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
        }
    }

    /* loaded from: classes2.dex */
    public enum TransmissionType implements m0 {
        NOT_DEFINE(0),
        FORCE_LAUNCH(1),
        WAIT_LAUNCH(2),
        UNRECOGNIZED(-1);
        
        public static final int FORCE_LAUNCH_VALUE = 1;
        public static final int NOT_DEFINE_VALUE = 0;
        public static final int WAIT_LAUNCH_VALUE = 2;
        private final int value;
        private static final u.b<TransmissionType> internalValueMap = new a();
        private static final TransmissionType[] VALUES = values();

        /* loaded from: classes2.dex */
        class a implements u.b<TransmissionType> {
            a() {
            }
        }

        TransmissionType(int i10) {
            this.value = i10;
        }

        public static TransmissionType forNumber(int i10) {
            if (i10 == 0) {
                return NOT_DEFINE;
            }
            if (i10 == 1) {
                return FORCE_LAUNCH;
            }
            if (i10 != 2) {
                return null;
            }
            return WAIT_LAUNCH;
        }

        public static final Descriptors.d getDescriptor() {
            return PushProto.p().i().get(1);
        }

        public static u.b<TransmissionType> internalGetValueMap() {
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
        public static TransmissionType valueOf(int i10) {
            return forNumber(i10);
        }

        public static TransmissionType valueOf(Descriptors.e eVar) {
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
    public static final class WwidPushRequest extends GeneratedMessageV3 implements f {
        public static final int CHANNEL_FIELD_NUMBER = 3;
        public static final int DEVICE_TYPE_FIELD_NUMBER = 2;
        public static final int WWID_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private int channel_;
        private int deviceType_;
        private byte memoizedIsInitialized;
        private volatile Object wwid_;
        private static final WwidPushRequest DEFAULT_INSTANCE = new WwidPushRequest();
        private static final l0<WwidPushRequest> PARSER = new a();

        /* loaded from: classes2.dex */
        class a extends com.google.protobuf.c<WwidPushRequest> {
            a() {
            }

            /* renamed from: a */
            public WwidPushRequest parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
                return new WwidPushRequest(iVar, qVar, null);
            }
        }

        /* loaded from: classes2.dex */
        public static final class b extends GeneratedMessageV3.b<b> implements f {

            /* renamed from: a  reason: collision with root package name */
            private Object f15918a;

            /* renamed from: b  reason: collision with root package name */
            private int f15919b;

            /* renamed from: c  reason: collision with root package name */
            private int f15920c;

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
            public WwidPushRequest build() {
                WwidPushRequest c10 = buildPartial();
                if (c10.isInitialized()) {
                    return c10;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) c10);
            }

            /* renamed from: c */
            public WwidPushRequest buildPartial() {
                WwidPushRequest wwidPushRequest = new WwidPushRequest(this, (a) null);
                wwidPushRequest.wwid_ = this.f15918a;
                wwidPushRequest.deviceType_ = this.f15919b;
                wwidPushRequest.channel_ = this.f15920c;
                onBuilt();
                return wwidPushRequest;
            }

            /* renamed from: d */
            public b clear() {
                super.clear();
                this.f15918a = "";
                this.f15919b = 0;
                this.f15920c = 0;
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
                return PushProto.f15877e;
            }

            /* renamed from: i */
            public WwidPushRequest getDefaultInstanceForType() {
                return WwidPushRequest.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return PushProto.f15878f.e(WwidPushRequest.class, b.class);
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
                WwidPushRequest wwidPushRequest = null;
                try {
                    try {
                        WwidPushRequest wwidPushRequest2 = (WwidPushRequest) WwidPushRequest.PARSER.parsePartialFrom(iVar, qVar);
                        if (wwidPushRequest2 != null) {
                            l(wwidPushRequest2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e10) {
                        wwidPushRequest = (WwidPushRequest) e10.getUnfinishedMessage();
                        try {
                            throw e10.unwrapIOException();
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (wwidPushRequest != null) {
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (wwidPushRequest != null) {
                        l(wwidPushRequest);
                    }
                    throw th2;
                }
            }

            /* renamed from: k */
            public b mergeFrom(d0 d0Var) {
                if (d0Var instanceof WwidPushRequest) {
                    return l((WwidPushRequest) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            public b l(WwidPushRequest wwidPushRequest) {
                if (wwidPushRequest == WwidPushRequest.getDefaultInstance()) {
                    return this;
                }
                if (!wwidPushRequest.getWwid().isEmpty()) {
                    this.f15918a = wwidPushRequest.wwid_;
                    onChanged();
                }
                if (wwidPushRequest.deviceType_ != 0) {
                    o(wwidPushRequest.getDeviceTypeValue());
                }
                if (wwidPushRequest.channel_ != 0) {
                    n(wwidPushRequest.getChannelValue());
                }
                onChanged();
                return this;
            }

            /* renamed from: m */
            public final b mergeUnknownFields(a1 a1Var) {
                return this;
            }

            public b n(int i10) {
                this.f15920c = i10;
                onChanged();
                return this;
            }

            public b o(int i10) {
                this.f15919b = i10;
                onChanged();
                return this;
            }

            /* renamed from: p */
            public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.setField(fieldDescriptor, obj);
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
                this.f15918a = "";
                this.f15919b = 0;
                this.f15920c = 0;
                maybeForceBuilderInitialization();
            }

            private b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.f15918a = "";
                this.f15919b = 0;
                this.f15920c = 0;
                maybeForceBuilderInitialization();
            }
        }

        /* synthetic */ WwidPushRequest(i iVar, q qVar, a aVar) throws InvalidProtocolBufferException {
            this(iVar, qVar);
        }

        public static WwidPushRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return PushProto.f15877e;
        }

        public static b newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static WwidPushRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (WwidPushRequest) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static WwidPushRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static l0<WwidPushRequest> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof WwidPushRequest)) {
                return super.equals(obj);
            }
            WwidPushRequest wwidPushRequest = (WwidPushRequest) obj;
            return ((getWwid().equals(wwidPushRequest.getWwid())) && this.deviceType_ == wwidPushRequest.deviceType_) && this.channel_ == wwidPushRequest.channel_;
        }

        public ConstantProto.Channel getChannel() {
            ConstantProto.Channel valueOf = ConstantProto.Channel.valueOf(this.channel_);
            return valueOf == null ? ConstantProto.Channel.UNRECOGNIZED : valueOf;
        }

        public int getChannelValue() {
            return this.channel_;
        }

        public ConstantProto.DeviceType getDeviceType() {
            ConstantProto.DeviceType valueOf = ConstantProto.DeviceType.valueOf(this.deviceType_);
            return valueOf == null ? ConstantProto.DeviceType.UNRECOGNIZED : valueOf;
        }

        public int getDeviceTypeValue() {
            return this.deviceType_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public l0<WwidPushRequest> getParserForType() {
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
            if (this.channel_ != ConstantProto.Channel.UNKNOWN_CHANNEL.getNumber()) {
                i11 += CodedOutputStream.l(3, this.channel_);
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
            int hashCode = ((((((((((((((779 + getDescriptorForType().hashCode()) * 37) + 1) * 53) + getWwid().hashCode()) * 37) + 2) * 53) + this.deviceType_) * 37) + 3) * 53) + this.channel_) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return PushProto.f15878f.e(WwidPushRequest.class, b.class);
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
            if (!getWwidBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.wwid_);
            }
            if (this.deviceType_ != ConstantProto.DeviceType.UNKNOWN_DEVICE_TYPE.getNumber()) {
                codedOutputStream.m0(2, this.deviceType_);
            }
            if (this.channel_ != ConstantProto.Channel.UNKNOWN_CHANNEL.getNumber()) {
                codedOutputStream.m0(3, this.channel_);
            }
        }

        /* synthetic */ WwidPushRequest(GeneratedMessageV3.b bVar, a aVar) {
            this(bVar);
        }

        public static b newBuilder(WwidPushRequest wwidPushRequest) {
            return DEFAULT_INSTANCE.toBuilder().l(wwidPushRequest);
        }

        public static WwidPushRequest parseFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, qVar);
        }

        private WwidPushRequest(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static WwidPushRequest parseDelimitedFrom(InputStream inputStream, q qVar) throws IOException {
            return (WwidPushRequest) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
        }

        public static WwidPushRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
        public WwidPushRequest getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b toBuilder() {
            return this == DEFAULT_INSTANCE ? new b((a) null) : new b((a) null).l(this);
        }

        public static WwidPushRequest parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b newBuilderForType() {
            return newBuilder();
        }

        private WwidPushRequest() {
            this.memoizedIsInitialized = (byte) -1;
            this.wwid_ = "";
            this.deviceType_ = 0;
            this.channel_ = 0;
        }

        public static WwidPushRequest parseFrom(InputStream inputStream) throws IOException {
            return (WwidPushRequest) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static WwidPushRequest parseFrom(InputStream inputStream, q qVar) throws IOException {
            return (WwidPushRequest) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
        }

        public static WwidPushRequest parseFrom(i iVar) throws IOException {
            return (WwidPushRequest) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
        }

        private WwidPushRequest(i iVar, q qVar) throws InvalidProtocolBufferException {
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
                            } else if (F == 16) {
                                this.deviceType_ = iVar.o();
                            } else if (F == 24) {
                                this.channel_ = iVar.o();
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

        public static WwidPushRequest parseFrom(i iVar, q qVar) throws IOException {
            return (WwidPushRequest) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements Descriptors.FileDescriptor.a {
        a() {
        }

        @Override // com.google.protobuf.Descriptors.FileDescriptor.a
        public o assignDescriptors(Descriptors.FileDescriptor fileDescriptor) {
            Descriptors.FileDescriptor unused = PushProto.f15887o = fileDescriptor;
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f15921a;

        static {
            int[] iArr = new int[PushRequest.IdCase.values().length];
            f15921a = iArr;
            try {
                iArr[PushRequest.IdCase.WWID_PUSH_REQUEST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f15921a[PushRequest.IdCase.DEVICE_ID.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f15921a[PushRequest.IdCase.CLIENT_ID.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f15921a[PushRequest.IdCase.WWID.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f15921a[PushRequest.IdCase.ID_NOT_SET.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
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
        Descriptors.FileDescriptor.q(new String[]{"\n\u001epushunicorn/push_message.proto\u0012\u000emobvoi.be.push\u001a\u0018becommon/constants.proto\u001a\u001epushunicorn/push_unicorn.proto\"ÿ\u0001\n\u000bPushRequest\u0012<\n\u0011wwid_push_request\u0018\u0001 \u0001(\u000b2\u001f.mobvoi.be.push.WwidPushRequestH\u0000\u0012\u0013\n\tdevice_id\u0018\u0002 \u0001(\tH\u0000\u0012\u0013\n\tclient_id\u0018\u0003 \u0001(\tH\u0000\u0012\u000e\n\u0004wwid\u0018\u0006 \u0001(\tH\u0000\u00125\n\u000esingle_message\u0018\u0004 \u0001(\u000b2\u001d.mobvoi.be.push.SingleMessage\u0012;\n\u0011transmission_type\u0018\u0005 \u0001(\u000e2 .mobvoi.be.push.TransmissionTypeB\u0004\n\u0002id\"1\n\fPushResponse\u0012\u0010\n\berr_code\u0018\u0001 \u0001(\u0005\u0012\u000f", "\n\u0007err_msg\u0018\u0002 \u0001(\t\"~\n\u000fWwidPushRequest\u0012\f\n\u0004wwid\u0018\u0001 \u0001(\t\u00121\n\u000bdevice_type\u0018\u0002 \u0001(\u000e2\u001c.mobvoi.be.common.DeviceType\u0012*\n\u0007channel\u0018\u0003 \u0001(\u000e2\u0019.mobvoi.be.common.Channel\"r\n\u0014DeviceStatusResponse\u0012\u0010\n\berr_code\u0018\u0001 \u0001(\u0005\u0012\u000f\n\u0007err_msg\u0018\u0002 \u0001(\t\u00127\n\u000bresult_list\u0018\u0003 \u0003(\u000b2\".mobvoi.be.push.DeviceStatusResult\"Ý\u0001\n\u0012DeviceStatusResult\u0012\f\n\u0004wwid\u0018\u0001 \u0001(\t\u00121\n\u000bdevice_type\u0018\u0002 \u0001(\u000e2\u001c.mobvoi.be.common.DeviceType\u0012\u0011\n\tdevice_id\u0018\u0003 \u0001(\t\u0012\u0011\n\tclient_id\u0018\u0004 \u0001(\t\u00124\n\u0006result\u0018\u0005 \u0001(", "\u000e2$.mobvoi.be.common.DeviceOnlineStatus\u0012*\n\u0007channel\u0018\u0006 \u0001(\u000e2\u0019.mobvoi.be.common.Channel\"À\u0001\n\rSingleMessage\u0012\u0010\n\bpriority\u0018\u0003 \u0001(\u0005\u0012\u0013\n\u000bnot_offline\u0018\u0004 \u0001(\b\u0012\u001b\n\u0013offline_expire_time\u0018\u0005 \u0001(\u0003\u0012:\n\u0011push_network_type\u0018\u0006 \u0001(\u000e2\u001f.mobvoi.be.push.PushNetWorkType\u0012/\n\u0007content\u0018\u0007 \u0001(\u000b2\u001e.mobvoi.be.push.MessageContent\"f\n\u000eMessageContent\u0012\u000f\n\u0007payload\u0018\u0001 \u0001(\f\u0012\f\n\u0004path\u0018\u0002 \u0001(\t\u0012\u000e\n\u0006source\u0018\u0003 \u0001(\t\u0012\u0012\n\nmessage_id\u0018\u0004 \u0001(\t\u0012\u0011\n\ttimestamp\u0018\u0005 \u0001(\u0003**\n\u000fPushNetWorkTyp", "e\u0012\r\n\tNOT_LIMIT\u0010\u0000\u0012\b\n\u0004WIFI\u0010\u0001*E\n\u0010TransmissionType\u0012\u000e\n\nNOT_DEFINE\u0010\u0000\u0012\u0010\n\fFORCE_LAUNCH\u0010\u0001\u0012\u000f\n\u000bWAIT_LAUNCH\u0010\u0002B&\n\u0019com.mobvoi.be.pushunicornB\tPushProtob\u0006proto3"}, new Descriptors.FileDescriptor[]{ConstantProto.t(), PushUnicornProto.h()}, new a());
        Descriptors.b bVar = p().j().get(0);
        f15873a = bVar;
        f15874b = new GeneratedMessageV3.e(bVar, new String[]{"WwidPushRequest", "DeviceId", "ClientId", "Wwid", "SingleMessage", "TransmissionType", "Id"});
        Descriptors.b bVar2 = p().j().get(1);
        f15875c = bVar2;
        f15876d = new GeneratedMessageV3.e(bVar2, new String[]{"ErrCode", "ErrMsg"});
        Descriptors.b bVar3 = p().j().get(2);
        f15877e = bVar3;
        f15878f = new GeneratedMessageV3.e(bVar3, new String[]{"Wwid", "DeviceType", "Channel"});
        Descriptors.b bVar4 = p().j().get(3);
        f15879g = bVar4;
        f15880h = new GeneratedMessageV3.e(bVar4, new String[]{"ErrCode", "ErrMsg", "ResultList"});
        Descriptors.b bVar5 = p().j().get(4);
        f15881i = bVar5;
        f15882j = new GeneratedMessageV3.e(bVar5, new String[]{"Wwid", "DeviceType", "DeviceId", "ClientId", "Result", "Channel"});
        Descriptors.b bVar6 = p().j().get(5);
        f15883k = bVar6;
        f15884l = new GeneratedMessageV3.e(bVar6, new String[]{"Priority", "NotOffline", "OfflineExpireTime", "PushNetworkType", "Content"});
        Descriptors.b bVar7 = p().j().get(6);
        f15885m = bVar7;
        f15886n = new GeneratedMessageV3.e(bVar7, new String[]{"Payload", "Path", "Source", "MessageId", "Timestamp"});
        ConstantProto.t();
        PushUnicornProto.h();
    }

    public static Descriptors.FileDescriptor p() {
        return f15887o;
    }
}
