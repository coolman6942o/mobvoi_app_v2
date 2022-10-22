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
public final class DeviceAndSceneProto {

    /* renamed from: a  reason: collision with root package name */
    private static final Descriptors.b f15939a;

    /* renamed from: b  reason: collision with root package name */
    private static final GeneratedMessageV3.e f15940b;

    /* renamed from: c  reason: collision with root package name */
    private static final Descriptors.b f15941c;

    /* renamed from: d  reason: collision with root package name */
    private static final GeneratedMessageV3.e f15942d;

    /* renamed from: e  reason: collision with root package name */
    private static Descriptors.FileDescriptor f15943e;

    /* loaded from: classes2.dex */
    public static final class DeviceAndSceneResponse extends GeneratedMessageV3 implements g0 {
        public static final int ERR_CODE_FIELD_NUMBER = 1;
        public static final int ERR_MSG_FIELD_NUMBER = 2;
        public static final int INFO_FIELD_NUMBER = 3;
        private static final long serialVersionUID = 0;
        private int errCode_;
        private volatile Object errMsg_;
        private byte memoizedIsInitialized;
        private int typeCase_;
        private Object type_;
        private static final DeviceAndSceneResponse DEFAULT_INSTANCE = new DeviceAndSceneResponse();
        private static final l0<DeviceAndSceneResponse> PARSER = new a();

        /* loaded from: classes2.dex */
        public enum TypeCase implements u.a {
            INFO(3),
            TYPE_NOT_SET(0);
            
            private final int value;

            TypeCase(int i10) {
                this.value = i10;
            }

            public static TypeCase forNumber(int i10) {
                if (i10 == 0) {
                    return TYPE_NOT_SET;
                }
                if (i10 != 3) {
                    return null;
                }
                return INFO;
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
        class a extends com.google.protobuf.c<DeviceAndSceneResponse> {
            a() {
            }

            /* renamed from: a */
            public DeviceAndSceneResponse parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
                return new DeviceAndSceneResponse(iVar, qVar, null);
            }
        }

        /* loaded from: classes2.dex */
        public static final class b extends GeneratedMessageV3.b<b> implements g0 {

            /* renamed from: a  reason: collision with root package name */
            private int f15944a;

            /* renamed from: b  reason: collision with root package name */
            private Object f15945b;

            /* renamed from: c  reason: collision with root package name */
            private int f15946c;

            /* renamed from: d  reason: collision with root package name */
            private Object f15947d;

            /* renamed from: e  reason: collision with root package name */
            private q0<DeviceInfoAndScene, DeviceInfoAndScene.b, c> f15948e;

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
            public DeviceAndSceneResponse build() {
                DeviceAndSceneResponse c10 = buildPartial();
                if (c10.isInitialized()) {
                    return c10;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) c10);
            }

            /* renamed from: c */
            public DeviceAndSceneResponse buildPartial() {
                DeviceAndSceneResponse deviceAndSceneResponse = new DeviceAndSceneResponse(this, (a) null);
                deviceAndSceneResponse.errCode_ = this.f15946c;
                deviceAndSceneResponse.errMsg_ = this.f15947d;
                if (this.f15944a == 3) {
                    q0<DeviceInfoAndScene, DeviceInfoAndScene.b, c> q0Var = this.f15948e;
                    if (q0Var == null) {
                        deviceAndSceneResponse.type_ = this.f15945b;
                    } else {
                        deviceAndSceneResponse.type_ = q0Var.b();
                    }
                }
                deviceAndSceneResponse.typeCase_ = this.f15944a;
                onBuilt();
                return deviceAndSceneResponse;
            }

            /* renamed from: d */
            public b clear() {
                super.clear();
                this.f15946c = 0;
                this.f15947d = "";
                this.f15944a = 0;
                this.f15945b = null;
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
                return DeviceAndSceneProto.f15939a;
            }

            /* renamed from: i */
            public DeviceAndSceneResponse getDefaultInstanceForType() {
                return DeviceAndSceneResponse.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return DeviceAndSceneProto.f15940b.e(DeviceAndSceneResponse.class, b.class);
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
                DeviceAndSceneResponse deviceAndSceneResponse = null;
                try {
                    try {
                        DeviceAndSceneResponse deviceAndSceneResponse2 = (DeviceAndSceneResponse) DeviceAndSceneResponse.PARSER.parsePartialFrom(iVar, qVar);
                        if (deviceAndSceneResponse2 != null) {
                            l(deviceAndSceneResponse2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e10) {
                        deviceAndSceneResponse = (DeviceAndSceneResponse) e10.getUnfinishedMessage();
                        try {
                            throw e10.unwrapIOException();
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (deviceAndSceneResponse != null) {
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (deviceAndSceneResponse != null) {
                        l(deviceAndSceneResponse);
                    }
                    throw th2;
                }
            }

            /* renamed from: k */
            public b mergeFrom(d0 d0Var) {
                if (d0Var instanceof DeviceAndSceneResponse) {
                    return l((DeviceAndSceneResponse) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            public b l(DeviceAndSceneResponse deviceAndSceneResponse) {
                if (deviceAndSceneResponse == DeviceAndSceneResponse.getDefaultInstance()) {
                    return this;
                }
                if (deviceAndSceneResponse.getErrCode() != 0) {
                    o(deviceAndSceneResponse.getErrCode());
                }
                if (!deviceAndSceneResponse.getErrMsg().isEmpty()) {
                    this.f15947d = deviceAndSceneResponse.errMsg_;
                    onChanged();
                }
                if (b.f15954a[deviceAndSceneResponse.getTypeCase().ordinal()] == 1) {
                    m(deviceAndSceneResponse.getInfo());
                }
                onChanged();
                return this;
            }

            public b m(DeviceInfoAndScene deviceInfoAndScene) {
                q0<DeviceInfoAndScene, DeviceInfoAndScene.b, c> q0Var = this.f15948e;
                if (q0Var == null) {
                    if (this.f15944a != 3 || this.f15945b == DeviceInfoAndScene.getDefaultInstance()) {
                        this.f15945b = deviceInfoAndScene;
                    } else {
                        this.f15945b = DeviceInfoAndScene.newBuilder((DeviceInfoAndScene) this.f15945b).l(deviceInfoAndScene).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.f15944a == 3) {
                        q0Var.h(deviceInfoAndScene);
                    }
                    this.f15948e.j(deviceInfoAndScene);
                }
                this.f15944a = 3;
                return this;
            }

            /* renamed from: n */
            public final b mergeUnknownFields(a1 a1Var) {
                return this;
            }

            public b o(int i10) {
                this.f15946c = i10;
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
                this.f15944a = 0;
                this.f15947d = "";
                maybeForceBuilderInitialization();
            }

            private b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.f15944a = 0;
                this.f15947d = "";
                maybeForceBuilderInitialization();
            }
        }

        /* synthetic */ DeviceAndSceneResponse(i iVar, q qVar, a aVar) throws InvalidProtocolBufferException {
            this(iVar, qVar);
        }

        public static DeviceAndSceneResponse getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return DeviceAndSceneProto.f15939a;
        }

        public static b newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static DeviceAndSceneResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (DeviceAndSceneResponse) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static DeviceAndSceneResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static l0<DeviceAndSceneResponse> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            boolean z10 = true;
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof DeviceAndSceneResponse)) {
                return super.equals(obj);
            }
            DeviceAndSceneResponse deviceAndSceneResponse = (DeviceAndSceneResponse) obj;
            boolean z11 = ((getErrCode() == deviceAndSceneResponse.getErrCode()) && getErrMsg().equals(deviceAndSceneResponse.getErrMsg())) && getTypeCase().equals(deviceAndSceneResponse.getTypeCase());
            if (!z11) {
                return false;
            }
            if (this.typeCase_ != 3) {
                return z11;
            }
            if (!z11 || !getInfo().equals(deviceAndSceneResponse.getInfo())) {
                z10 = false;
            }
            return z10;
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

        public DeviceInfoAndScene getInfo() {
            if (this.typeCase_ == 3) {
                return (DeviceInfoAndScene) this.type_;
            }
            return DeviceInfoAndScene.getDefaultInstance();
        }

        public c getInfoOrBuilder() {
            if (this.typeCase_ == 3) {
                return (DeviceInfoAndScene) this.type_;
            }
            return DeviceInfoAndScene.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public l0<DeviceAndSceneResponse> getParserForType() {
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
            if (this.typeCase_ == 3) {
                i11 += CodedOutputStream.E(3, (DeviceInfoAndScene) this.type_);
            }
            this.memoizedSize = i11;
            return i11;
        }

        public TypeCase getTypeCase() {
            return TypeCase.forNumber(this.typeCase_);
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

        @Override // com.google.protobuf.a
        public int hashCode() {
            int i10 = this.memoizedHashCode;
            if (i10 != 0) {
                return i10;
            }
            int hashCode = ((((((((779 + getDescriptorForType().hashCode()) * 37) + 1) * 53) + getErrCode()) * 37) + 2) * 53) + getErrMsg().hashCode();
            if (this.typeCase_ == 3) {
                hashCode = (((hashCode * 37) + 3) * 53) + getInfo().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return DeviceAndSceneProto.f15940b.e(DeviceAndSceneResponse.class, b.class);
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
                codedOutputStream.A0(3, (DeviceInfoAndScene) this.type_);
            }
        }

        /* synthetic */ DeviceAndSceneResponse(GeneratedMessageV3.b bVar, a aVar) {
            this(bVar);
        }

        public static b newBuilder(DeviceAndSceneResponse deviceAndSceneResponse) {
            return DEFAULT_INSTANCE.toBuilder().l(deviceAndSceneResponse);
        }

        public static DeviceAndSceneResponse parseFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, qVar);
        }

        private DeviceAndSceneResponse(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.typeCase_ = 0;
            this.memoizedIsInitialized = (byte) -1;
        }

        public static DeviceAndSceneResponse parseDelimitedFrom(InputStream inputStream, q qVar) throws IOException {
            return (DeviceAndSceneResponse) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
        }

        public static DeviceAndSceneResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
        public DeviceAndSceneResponse getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b toBuilder() {
            return this == DEFAULT_INSTANCE ? new b((a) null) : new b((a) null).l(this);
        }

        public static DeviceAndSceneResponse parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b newBuilderForType() {
            return newBuilder();
        }

        public static DeviceAndSceneResponse parseFrom(InputStream inputStream) throws IOException {
            return (DeviceAndSceneResponse) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        private DeviceAndSceneResponse() {
            this.typeCase_ = 0;
            this.memoizedIsInitialized = (byte) -1;
            this.errCode_ = 0;
            this.errMsg_ = "";
        }

        public static DeviceAndSceneResponse parseFrom(InputStream inputStream, q qVar) throws IOException {
            return (DeviceAndSceneResponse) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
        }

        public static DeviceAndSceneResponse parseFrom(i iVar) throws IOException {
            return (DeviceAndSceneResponse) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
        }

        private DeviceAndSceneResponse(i iVar, q qVar) throws InvalidProtocolBufferException {
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
                            } else if (F == 26) {
                                DeviceInfoAndScene.b builder = this.typeCase_ == 3 ? ((DeviceInfoAndScene) this.type_).toBuilder() : null;
                                e0 v10 = iVar.v(DeviceInfoAndScene.parser(), qVar);
                                this.type_ = v10;
                                if (builder != null) {
                                    builder.l((DeviceInfoAndScene) v10);
                                    this.type_ = builder.buildPartial();
                                }
                                this.typeCase_ = 3;
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

        public static DeviceAndSceneResponse parseFrom(i iVar, q qVar) throws IOException {
            return (DeviceAndSceneResponse) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
        }
    }

    /* loaded from: classes2.dex */
    public static final class DeviceInfoAndScene extends GeneratedMessageV3 implements c {
        public static final int BIND_INFO_FIELD_NUMBER = 1;
        public static final int DEVICES_FIELD_NUMBER = 2;
        public static final int SCENARIOS_FIELD_NUMBER = 3;
        private static final long serialVersionUID = 0;
        private List<TicAssistantProto.BindInfo> bindInfo_;
        private int bitField0_;
        private volatile Object devices_;
        private byte memoizedIsInitialized;
        private volatile Object scenarios_;
        private static final DeviceInfoAndScene DEFAULT_INSTANCE = new DeviceInfoAndScene();
        private static final l0<DeviceInfoAndScene> PARSER = new a();

        /* loaded from: classes2.dex */
        class a extends com.google.protobuf.c<DeviceInfoAndScene> {
            a() {
            }

            /* renamed from: a */
            public DeviceInfoAndScene parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
                return new DeviceInfoAndScene(iVar, qVar, null);
            }
        }

        /* loaded from: classes2.dex */
        public static final class b extends GeneratedMessageV3.b<b> implements c {

            /* renamed from: a  reason: collision with root package name */
            private int f15949a;

            /* renamed from: b  reason: collision with root package name */
            private List<TicAssistantProto.BindInfo> f15950b;

            /* renamed from: c  reason: collision with root package name */
            private o0<TicAssistantProto.BindInfo, TicAssistantProto.BindInfo.b, TicAssistantProto.c> f15951c;

            /* renamed from: d  reason: collision with root package name */
            private Object f15952d;

            /* renamed from: e  reason: collision with root package name */
            private Object f15953e;

            /* synthetic */ b(GeneratedMessageV3.c cVar, a aVar) {
                this(cVar);
            }

            private void ensureBindInfoIsMutable() {
                if ((this.f15949a & 1) != 1) {
                    this.f15950b = new ArrayList(this.f15950b);
                    this.f15949a |= 1;
                }
            }

            private o0<TicAssistantProto.BindInfo, TicAssistantProto.BindInfo.b, TicAssistantProto.c> getBindInfoFieldBuilder() {
                if (this.f15951c == null) {
                    List<TicAssistantProto.BindInfo> list = this.f15950b;
                    boolean z10 = true;
                    if ((this.f15949a & 1) != 1) {
                        z10 = false;
                    }
                    this.f15951c = new o0<>(list, z10, getParentForChildren(), isClean());
                    this.f15950b = null;
                }
                return this.f15951c;
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
            public DeviceInfoAndScene build() {
                DeviceInfoAndScene c10 = buildPartial();
                if (c10.isInitialized()) {
                    return c10;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) c10);
            }

            /* renamed from: c */
            public DeviceInfoAndScene buildPartial() {
                DeviceInfoAndScene deviceInfoAndScene = new DeviceInfoAndScene(this, (a) null);
                int i10 = this.f15949a;
                o0<TicAssistantProto.BindInfo, TicAssistantProto.BindInfo.b, TicAssistantProto.c> o0Var = this.f15951c;
                if (o0Var == null) {
                    if ((i10 & 1) == 1) {
                        this.f15950b = Collections.unmodifiableList(this.f15950b);
                        this.f15949a &= -2;
                    }
                    deviceInfoAndScene.bindInfo_ = this.f15950b;
                } else {
                    deviceInfoAndScene.bindInfo_ = o0Var.g();
                }
                deviceInfoAndScene.devices_ = this.f15952d;
                deviceInfoAndScene.scenarios_ = this.f15953e;
                deviceInfoAndScene.bitField0_ = 0;
                onBuilt();
                return deviceInfoAndScene;
            }

            /* renamed from: d */
            public b clear() {
                super.clear();
                o0<TicAssistantProto.BindInfo, TicAssistantProto.BindInfo.b, TicAssistantProto.c> o0Var = this.f15951c;
                if (o0Var == null) {
                    this.f15950b = Collections.emptyList();
                    this.f15949a &= -2;
                } else {
                    o0Var.h();
                }
                this.f15952d = "";
                this.f15953e = "";
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
                return DeviceAndSceneProto.f15941c;
            }

            /* renamed from: i */
            public DeviceInfoAndScene getDefaultInstanceForType() {
                return DeviceInfoAndScene.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return DeviceAndSceneProto.f15942d.e(DeviceInfoAndScene.class, b.class);
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
                DeviceInfoAndScene deviceInfoAndScene = null;
                try {
                    try {
                        DeviceInfoAndScene deviceInfoAndScene2 = (DeviceInfoAndScene) DeviceInfoAndScene.PARSER.parsePartialFrom(iVar, qVar);
                        if (deviceInfoAndScene2 != null) {
                            l(deviceInfoAndScene2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e10) {
                        deviceInfoAndScene = (DeviceInfoAndScene) e10.getUnfinishedMessage();
                        try {
                            throw e10.unwrapIOException();
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (deviceInfoAndScene != null) {
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (deviceInfoAndScene != null) {
                        l(deviceInfoAndScene);
                    }
                    throw th2;
                }
            }

            /* renamed from: k */
            public b mergeFrom(d0 d0Var) {
                if (d0Var instanceof DeviceInfoAndScene) {
                    return l((DeviceInfoAndScene) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            public b l(DeviceInfoAndScene deviceInfoAndScene) {
                if (deviceInfoAndScene == DeviceInfoAndScene.getDefaultInstance()) {
                    return this;
                }
                if (this.f15951c == null) {
                    if (!deviceInfoAndScene.bindInfo_.isEmpty()) {
                        if (this.f15950b.isEmpty()) {
                            this.f15950b = deviceInfoAndScene.bindInfo_;
                            this.f15949a &= -2;
                        } else {
                            ensureBindInfoIsMutable();
                            this.f15950b.addAll(deviceInfoAndScene.bindInfo_);
                        }
                        onChanged();
                    }
                } else if (!deviceInfoAndScene.bindInfo_.isEmpty()) {
                    if (this.f15951c.u()) {
                        this.f15951c.i();
                        o0<TicAssistantProto.BindInfo, TicAssistantProto.BindInfo.b, TicAssistantProto.c> o0Var = null;
                        this.f15951c = null;
                        this.f15950b = deviceInfoAndScene.bindInfo_;
                        this.f15949a &= -2;
                        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                            o0Var = getBindInfoFieldBuilder();
                        }
                        this.f15951c = o0Var;
                    } else {
                        this.f15951c.b(deviceInfoAndScene.bindInfo_);
                    }
                }
                if (!deviceInfoAndScene.getDevices().isEmpty()) {
                    this.f15952d = deviceInfoAndScene.devices_;
                    onChanged();
                }
                if (!deviceInfoAndScene.getScenarios().isEmpty()) {
                    this.f15953e = deviceInfoAndScene.scenarios_;
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
                this.f15950b = Collections.emptyList();
                this.f15952d = "";
                this.f15953e = "";
                maybeForceBuilderInitialization();
            }

            private b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.f15950b = Collections.emptyList();
                this.f15952d = "";
                this.f15953e = "";
                maybeForceBuilderInitialization();
            }
        }

        /* synthetic */ DeviceInfoAndScene(i iVar, q qVar, a aVar) throws InvalidProtocolBufferException {
            this(iVar, qVar);
        }

        public static DeviceInfoAndScene getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return DeviceAndSceneProto.f15941c;
        }

        public static b newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static DeviceInfoAndScene parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (DeviceInfoAndScene) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static DeviceInfoAndScene parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static l0<DeviceInfoAndScene> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof DeviceInfoAndScene)) {
                return super.equals(obj);
            }
            DeviceInfoAndScene deviceInfoAndScene = (DeviceInfoAndScene) obj;
            return ((getBindInfoList().equals(deviceInfoAndScene.getBindInfoList())) && getDevices().equals(deviceInfoAndScene.getDevices())) && getScenarios().equals(deviceInfoAndScene.getScenarios());
        }

        public TicAssistantProto.BindInfo getBindInfo(int i10) {
            return this.bindInfo_.get(i10);
        }

        public int getBindInfoCount() {
            return this.bindInfo_.size();
        }

        public List<TicAssistantProto.BindInfo> getBindInfoList() {
            return this.bindInfo_;
        }

        public TicAssistantProto.c getBindInfoOrBuilder(int i10) {
            return this.bindInfo_.get(i10);
        }

        public List<? extends TicAssistantProto.c> getBindInfoOrBuilderList() {
            return this.bindInfo_;
        }

        public String getDevices() {
            Object obj = this.devices_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.devices_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getDevicesBytes() {
            Object obj = this.devices_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.devices_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public l0<DeviceInfoAndScene> getParserForType() {
            return PARSER;
        }

        public String getScenarios() {
            Object obj = this.scenarios_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.scenarios_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getScenariosBytes() {
            Object obj = this.scenarios_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.scenarios_ = copyFromUtf8;
            return copyFromUtf8;
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
            if (!getDevicesBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(2, this.devices_);
            }
            if (!getScenariosBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(3, this.scenarios_);
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
            int hashCode2 = (((((((((hashCode * 37) + 2) * 53) + getDevices().hashCode()) * 37) + 3) * 53) + getScenarios().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return DeviceAndSceneProto.f15942d.e(DeviceInfoAndScene.class, b.class);
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
            for (int i10 = 0; i10 < this.bindInfo_.size(); i10++) {
                codedOutputStream.A0(1, this.bindInfo_.get(i10));
            }
            if (!getDevicesBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.devices_);
            }
            if (!getScenariosBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 3, this.scenarios_);
            }
        }

        /* synthetic */ DeviceInfoAndScene(GeneratedMessageV3.b bVar, a aVar) {
            this(bVar);
        }

        public static b newBuilder(DeviceInfoAndScene deviceInfoAndScene) {
            return DEFAULT_INSTANCE.toBuilder().l(deviceInfoAndScene);
        }

        public static DeviceInfoAndScene parseFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, qVar);
        }

        private DeviceInfoAndScene(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static DeviceInfoAndScene parseDelimitedFrom(InputStream inputStream, q qVar) throws IOException {
            return (DeviceInfoAndScene) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
        }

        public static DeviceInfoAndScene parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
        public DeviceInfoAndScene getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b toBuilder() {
            return this == DEFAULT_INSTANCE ? new b((a) null) : new b((a) null).l(this);
        }

        public static DeviceInfoAndScene parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b newBuilderForType() {
            return newBuilder();
        }

        private DeviceInfoAndScene() {
            this.memoizedIsInitialized = (byte) -1;
            this.bindInfo_ = Collections.emptyList();
            this.devices_ = "";
            this.scenarios_ = "";
        }

        public static DeviceInfoAndScene parseFrom(InputStream inputStream) throws IOException {
            return (DeviceInfoAndScene) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static DeviceInfoAndScene parseFrom(InputStream inputStream, q qVar) throws IOException {
            return (DeviceInfoAndScene) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
        }

        public static DeviceInfoAndScene parseFrom(i iVar) throws IOException {
            return (DeviceInfoAndScene) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
        }

        private DeviceInfoAndScene(i iVar, q qVar) throws InvalidProtocolBufferException {
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
                                this.bindInfo_.add((TicAssistantProto.BindInfo) iVar.v(TicAssistantProto.BindInfo.parser(), qVar));
                            } else if (F == 18) {
                                this.devices_ = iVar.E();
                            } else if (F == 26) {
                                this.scenarios_ = iVar.E();
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

        public static DeviceInfoAndScene parseFrom(i iVar, q qVar) throws IOException {
            return (DeviceInfoAndScene) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements Descriptors.FileDescriptor.a {
        a() {
        }

        @Override // com.google.protobuf.Descriptors.FileDescriptor.a
        public o assignDescriptors(Descriptors.FileDescriptor fileDescriptor) {
            Descriptors.FileDescriptor unused = DeviceAndSceneProto.f15943e = fileDescriptor;
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f15954a;

        static {
            int[] iArr = new int[DeviceAndSceneResponse.TypeCase.values().length];
            f15954a = iArr;
            try {
                iArr[DeviceAndSceneResponse.TypeCase.INFO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f15954a[DeviceAndSceneResponse.TypeCase.TYPE_NOT_SET.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface c extends g0 {
    }

    static {
        Descriptors.FileDescriptor.q(new String[]{"\n#ticassistant/device_and_scene.proto\u0012\u0013mobvoi.be.assistant\u001a ticassistant/tic_assistant.proto\"|\n\u0016DeviceAndSceneResponse\u0012\u0010\n\berr_code\u0018\u0001 \u0001(\u0005\u0012\u000f\n\u0007err_msg\u0018\u0002 \u0001(\t\u00127\n\u0004info\u0018\u0003 \u0001(\u000b2'.mobvoi.be.assistant.DeviceInfoAndSceneH\u0000B\u0006\n\u0004type\"j\n\u0012DeviceInfoAndScene\u00120\n\tbind_info\u0018\u0001 \u0003(\u000b2\u001d.mobvoi.be.assistant.BindInfo\u0012\u000f\n\u0007devices\u0018\u0002 \u0001(\t\u0012\u0011\n\tscenarios\u0018\u0003 \u0001(\tB1\n\u001acom.mobvoi.be.ticassistantB\u0013DeviceAndSceneProtob\u0006proto3"}, new Descriptors.FileDescriptor[]{TicAssistantProto.t()}, new a());
        Descriptors.b bVar = f().j().get(0);
        f15939a = bVar;
        f15940b = new GeneratedMessageV3.e(bVar, new String[]{"ErrCode", "ErrMsg", "Info", "Type"});
        Descriptors.b bVar2 = f().j().get(1);
        f15941c = bVar2;
        f15942d = new GeneratedMessageV3.e(bVar2, new String[]{"BindInfo", "Devices", "Scenarios"});
        TicAssistantProto.t();
    }

    public static Descriptors.FileDescriptor f() {
        return f15943e;
    }
}
