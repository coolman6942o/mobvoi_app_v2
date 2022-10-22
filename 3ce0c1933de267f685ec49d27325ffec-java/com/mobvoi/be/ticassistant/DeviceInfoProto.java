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
import com.mobvoi.be.common.ConstantProto;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
/* loaded from: classes2.dex */
public final class DeviceInfoProto {

    /* renamed from: a  reason: collision with root package name */
    private static final Descriptors.b f15955a;

    /* renamed from: b  reason: collision with root package name */
    private static final GeneratedMessageV3.e f15956b;

    /* renamed from: c  reason: collision with root package name */
    private static final Descriptors.b f15957c;

    /* renamed from: d  reason: collision with root package name */
    private static final GeneratedMessageV3.e f15958d;

    /* renamed from: e  reason: collision with root package name */
    private static final Descriptors.b f15959e;

    /* renamed from: f  reason: collision with root package name */
    private static final GeneratedMessageV3.e f15960f;

    /* renamed from: g  reason: collision with root package name */
    private static final Descriptors.b f15961g;

    /* renamed from: h  reason: collision with root package name */
    private static final GeneratedMessageV3.e f15962h;

    /* renamed from: i  reason: collision with root package name */
    private static final Descriptors.b f15963i;

    /* renamed from: j  reason: collision with root package name */
    private static final GeneratedMessageV3.e f15964j;

    /* renamed from: k  reason: collision with root package name */
    private static final Descriptors.b f15965k;

    /* renamed from: l  reason: collision with root package name */
    private static final GeneratedMessageV3.e f15966l;

    /* renamed from: m  reason: collision with root package name */
    private static Descriptors.FileDescriptor f15967m;

    /* loaded from: classes2.dex */
    public static final class BindDataCollection extends GeneratedMessageV3 implements g0 {
        public static final int CHANNEL_FIELD_NUMBER = 3;
        public static final int DEVICE_ID_FIELD_NUMBER = 6;
        public static final int DEVICE_WWID_DATAS_FIELD_NUMBER = 2;
        public static final int LATITUDE_FIELD_NUMBER = 4;
        public static final int LONGITUDE_FIELD_NUMBER = 5;
        public static final int WWID_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private int channel_;
        private volatile Object deviceId_;
        private List<DeviceWwidData> deviceWwidDatas_;
        private double latitude_;
        private double longitude_;
        private byte memoizedIsInitialized;
        private volatile Object wwid_;
        private static final BindDataCollection DEFAULT_INSTANCE = new BindDataCollection();
        private static final l0<BindDataCollection> PARSER = new a();

        /* loaded from: classes2.dex */
        public enum Channel implements m0 {
            CHINA(0),
            OVERSEA(1),
            UNRECOGNIZED(-1);
            
            public static final int CHINA_VALUE = 0;
            public static final int OVERSEA_VALUE = 1;
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
                    return CHINA;
                }
                if (i10 != 1) {
                    return null;
                }
                return OVERSEA;
            }

            public static final Descriptors.d getDescriptor() {
                return BindDataCollection.getDescriptor().j().get(0);
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
        class a extends com.google.protobuf.c<BindDataCollection> {
            a() {
            }

            /* renamed from: a */
            public BindDataCollection parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
                return new BindDataCollection(iVar, qVar, null);
            }
        }

        /* loaded from: classes2.dex */
        public static final class b extends GeneratedMessageV3.b<b> implements g0 {

            /* renamed from: a  reason: collision with root package name */
            private int f15968a;

            /* renamed from: b  reason: collision with root package name */
            private Object f15969b;

            /* renamed from: c  reason: collision with root package name */
            private List<DeviceWwidData> f15970c;

            /* renamed from: d  reason: collision with root package name */
            private o0<DeviceWwidData, DeviceWwidData.b, e> f15971d;

            /* renamed from: e  reason: collision with root package name */
            private int f15972e;

            /* renamed from: f  reason: collision with root package name */
            private double f15973f;

            /* renamed from: g  reason: collision with root package name */
            private double f15974g;

            /* renamed from: h  reason: collision with root package name */
            private Object f15975h;

            /* synthetic */ b(GeneratedMessageV3.c cVar, a aVar) {
                this(cVar);
            }

            private void j() {
                if ((this.f15968a & 2) != 2) {
                    this.f15970c = new ArrayList(this.f15970c);
                    this.f15968a |= 2;
                }
            }

            private o0<DeviceWwidData, DeviceWwidData.b, e> l() {
                if (this.f15971d == null) {
                    this.f15971d = new o0<>(this.f15970c, (this.f15968a & 2) == 2, getParentForChildren(), isClean());
                    this.f15970c = null;
                }
                return this.f15971d;
            }

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                    l();
                }
            }

            public b a(DeviceWwidData deviceWwidData) {
                o0<DeviceWwidData, DeviceWwidData.b, e> o0Var = this.f15971d;
                if (o0Var == null) {
                    Objects.requireNonNull(deviceWwidData);
                    j();
                    this.f15970c.add(deviceWwidData);
                    onChanged();
                } else {
                    o0Var.f(deviceWwidData);
                }
                return this;
            }

            /* renamed from: b */
            public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.addRepeatedField(fieldDescriptor, obj);
            }

            /* renamed from: c */
            public BindDataCollection build() {
                BindDataCollection d10 = buildPartial();
                if (d10.isInitialized()) {
                    return d10;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) d10);
            }

            /* renamed from: d */
            public BindDataCollection buildPartial() {
                BindDataCollection bindDataCollection = new BindDataCollection(this, (a) null);
                bindDataCollection.wwid_ = this.f15969b;
                o0<DeviceWwidData, DeviceWwidData.b, e> o0Var = this.f15971d;
                if (o0Var == null) {
                    if ((this.f15968a & 2) == 2) {
                        this.f15970c = Collections.unmodifiableList(this.f15970c);
                        this.f15968a &= -3;
                    }
                    bindDataCollection.deviceWwidDatas_ = this.f15970c;
                } else {
                    bindDataCollection.deviceWwidDatas_ = o0Var.g();
                }
                bindDataCollection.channel_ = this.f15972e;
                bindDataCollection.latitude_ = this.f15973f;
                bindDataCollection.longitude_ = this.f15974g;
                bindDataCollection.deviceId_ = this.f15975h;
                bindDataCollection.bitField0_ = 0;
                onBuilt();
                return bindDataCollection;
            }

            /* renamed from: e */
            public b clear() {
                super.clear();
                this.f15969b = "";
                o0<DeviceWwidData, DeviceWwidData.b, e> o0Var = this.f15971d;
                if (o0Var == null) {
                    this.f15970c = Collections.emptyList();
                    this.f15968a &= -3;
                } else {
                    o0Var.h();
                }
                this.f15972e = 0;
                this.f15973f = 0.0d;
                this.f15974g = 0.0d;
                this.f15975h = "";
                return this;
            }

            /* renamed from: f */
            public b clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (b) super.clearField(fieldDescriptor);
            }

            /* renamed from: g */
            public b clearOneof(Descriptors.h hVar) {
                return (b) super.clearOneof(hVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a, com.google.protobuf.g0
            public Descriptors.b getDescriptorForType() {
                return DeviceInfoProto.f15965k;
            }

            /* renamed from: i */
            public b clone() {
                return (b) super.clone();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return DeviceInfoProto.f15966l.e(BindDataCollection.class, b.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.f0
            public final boolean isInitialized() {
                return true;
            }

            /* renamed from: k */
            public BindDataCollection getDefaultInstanceForType() {
                return BindDataCollection.getDefaultInstance();
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x0023  */
            /* renamed from: m */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public b mergeFrom(i iVar, q qVar) throws IOException {
                Throwable th2;
                BindDataCollection bindDataCollection = null;
                try {
                    try {
                        BindDataCollection bindDataCollection2 = (BindDataCollection) BindDataCollection.PARSER.parsePartialFrom(iVar, qVar);
                        if (bindDataCollection2 != null) {
                            o(bindDataCollection2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e10) {
                        bindDataCollection = (BindDataCollection) e10.getUnfinishedMessage();
                        try {
                            throw e10.unwrapIOException();
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (bindDataCollection != null) {
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (bindDataCollection != null) {
                        o(bindDataCollection);
                    }
                    throw th2;
                }
            }

            /* renamed from: n */
            public b mergeFrom(d0 d0Var) {
                if (d0Var instanceof BindDataCollection) {
                    return o((BindDataCollection) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            public b o(BindDataCollection bindDataCollection) {
                if (bindDataCollection == BindDataCollection.getDefaultInstance()) {
                    return this;
                }
                if (!bindDataCollection.getWwid().isEmpty()) {
                    this.f15969b = bindDataCollection.wwid_;
                    onChanged();
                }
                if (this.f15971d == null) {
                    if (!bindDataCollection.deviceWwidDatas_.isEmpty()) {
                        if (this.f15970c.isEmpty()) {
                            this.f15970c = bindDataCollection.deviceWwidDatas_;
                            this.f15968a &= -3;
                        } else {
                            j();
                            this.f15970c.addAll(bindDataCollection.deviceWwidDatas_);
                        }
                        onChanged();
                    }
                } else if (!bindDataCollection.deviceWwidDatas_.isEmpty()) {
                    if (this.f15971d.u()) {
                        this.f15971d.i();
                        o0<DeviceWwidData, DeviceWwidData.b, e> o0Var = null;
                        this.f15971d = null;
                        this.f15970c = bindDataCollection.deviceWwidDatas_;
                        this.f15968a &= -3;
                        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                            o0Var = l();
                        }
                        this.f15971d = o0Var;
                    } else {
                        this.f15971d.b(bindDataCollection.deviceWwidDatas_);
                    }
                }
                if (bindDataCollection.channel_ != 0) {
                    r(bindDataCollection.getChannelValue());
                }
                if (bindDataCollection.getLatitude() != 0.0d) {
                    u(bindDataCollection.getLatitude());
                }
                if (bindDataCollection.getLongitude() != 0.0d) {
                    v(bindDataCollection.getLongitude());
                }
                if (!bindDataCollection.getDeviceId().isEmpty()) {
                    this.f15975h = bindDataCollection.deviceId_;
                    onChanged();
                }
                onChanged();
                return this;
            }

            /* renamed from: p */
            public final b mergeUnknownFields(a1 a1Var) {
                return this;
            }

            public b q(Channel channel) {
                Objects.requireNonNull(channel);
                this.f15972e = channel.getNumber();
                onChanged();
                return this;
            }

            public b r(int i10) {
                this.f15972e = i10;
                onChanged();
                return this;
            }

            public b s(String str) {
                Objects.requireNonNull(str);
                this.f15975h = str;
                onChanged();
                return this;
            }

            /* renamed from: t */
            public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.setField(fieldDescriptor, obj);
            }

            public b u(double d10) {
                this.f15973f = d10;
                onChanged();
                return this;
            }

            public b v(double d10) {
                this.f15974g = d10;
                onChanged();
                return this;
            }

            /* renamed from: w */
            public b setRepeatedField2(Descriptors.FieldDescriptor fieldDescriptor, int i10, Object obj) {
                return (b) super.setRepeatedField(fieldDescriptor, i10, obj);
            }

            /* renamed from: x */
            public final b setUnknownFields(a1 a1Var) {
                return this;
            }

            public b y(String str) {
                Objects.requireNonNull(str);
                this.f15969b = str;
                onChanged();
                return this;
            }

            /* synthetic */ b(a aVar) {
                this();
            }

            private b() {
                this.f15969b = "";
                this.f15970c = Collections.emptyList();
                this.f15972e = 0;
                this.f15975h = "";
                maybeForceBuilderInitialization();
            }

            private b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.f15969b = "";
                this.f15970c = Collections.emptyList();
                this.f15972e = 0;
                this.f15975h = "";
                maybeForceBuilderInitialization();
            }
        }

        /* synthetic */ BindDataCollection(i iVar, q qVar, a aVar) throws InvalidProtocolBufferException {
            this(iVar, qVar);
        }

        public static BindDataCollection getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return DeviceInfoProto.f15965k;
        }

        public static b newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static BindDataCollection parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (BindDataCollection) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static BindDataCollection parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static l0<BindDataCollection> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof BindDataCollection)) {
                return super.equals(obj);
            }
            BindDataCollection bindDataCollection = (BindDataCollection) obj;
            return (((((getWwid().equals(bindDataCollection.getWwid())) && getDeviceWwidDatasList().equals(bindDataCollection.getDeviceWwidDatasList())) && this.channel_ == bindDataCollection.channel_) && (Double.doubleToLongBits(getLatitude()) > Double.doubleToLongBits(bindDataCollection.getLatitude()) ? 1 : (Double.doubleToLongBits(getLatitude()) == Double.doubleToLongBits(bindDataCollection.getLatitude()) ? 0 : -1)) == 0) && (Double.doubleToLongBits(getLongitude()) > Double.doubleToLongBits(bindDataCollection.getLongitude()) ? 1 : (Double.doubleToLongBits(getLongitude()) == Double.doubleToLongBits(bindDataCollection.getLongitude()) ? 0 : -1)) == 0) && getDeviceId().equals(bindDataCollection.getDeviceId());
        }

        public Channel getChannel() {
            Channel valueOf = Channel.valueOf(this.channel_);
            return valueOf == null ? Channel.UNRECOGNIZED : valueOf;
        }

        public int getChannelValue() {
            return this.channel_;
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

        public DeviceWwidData getDeviceWwidDatas(int i10) {
            return this.deviceWwidDatas_.get(i10);
        }

        public int getDeviceWwidDatasCount() {
            return this.deviceWwidDatas_.size();
        }

        public List<DeviceWwidData> getDeviceWwidDatasList() {
            return this.deviceWwidDatas_;
        }

        public e getDeviceWwidDatasOrBuilder(int i10) {
            return this.deviceWwidDatas_.get(i10);
        }

        public List<? extends e> getDeviceWwidDatasOrBuilderList() {
            return this.deviceWwidDatas_;
        }

        public double getLatitude() {
            return this.latitude_;
        }

        public double getLongitude() {
            return this.longitude_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public l0<BindDataCollection> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
        public int getSerializedSize() {
            int i10 = this.memoizedSize;
            if (i10 != -1) {
                return i10;
            }
            int computeStringSize = !getWwidBytes().isEmpty() ? GeneratedMessageV3.computeStringSize(1, this.wwid_) + 0 : 0;
            for (int i11 = 0; i11 < this.deviceWwidDatas_.size(); i11++) {
                computeStringSize += CodedOutputStream.E(2, this.deviceWwidDatas_.get(i11));
            }
            if (this.channel_ != Channel.CHINA.getNumber()) {
                computeStringSize += CodedOutputStream.l(3, this.channel_);
            }
            double d10 = this.latitude_;
            if (d10 != 0.0d) {
                computeStringSize += CodedOutputStream.j(4, d10);
            }
            double d11 = this.longitude_;
            if (d11 != 0.0d) {
                computeStringSize += CodedOutputStream.j(5, d11);
            }
            if (!getDeviceIdBytes().isEmpty()) {
                computeStringSize += GeneratedMessageV3.computeStringSize(6, this.deviceId_);
            }
            this.memoizedSize = computeStringSize;
            return computeStringSize;
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
            int hashCode = ((((779 + getDescriptorForType().hashCode()) * 37) + 1) * 53) + getWwid().hashCode();
            if (getDeviceWwidDatasCount() > 0) {
                hashCode = (((hashCode * 37) + 2) * 53) + getDeviceWwidDatasList().hashCode();
            }
            int h10 = (((((((((((((((((hashCode * 37) + 3) * 53) + this.channel_) * 37) + 4) * 53) + u.h(Double.doubleToLongBits(getLatitude()))) * 37) + 5) * 53) + u.h(Double.doubleToLongBits(getLongitude()))) * 37) + 6) * 53) + getDeviceId().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = h10;
            return h10;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return DeviceInfoProto.f15966l.e(BindDataCollection.class, b.class);
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
            for (int i10 = 0; i10 < this.deviceWwidDatas_.size(); i10++) {
                codedOutputStream.A0(2, this.deviceWwidDatas_.get(i10));
            }
            if (this.channel_ != Channel.CHINA.getNumber()) {
                codedOutputStream.m0(3, this.channel_);
            }
            double d10 = this.latitude_;
            if (d10 != 0.0d) {
                codedOutputStream.k0(4, d10);
            }
            double d11 = this.longitude_;
            if (d11 != 0.0d) {
                codedOutputStream.k0(5, d11);
            }
            if (!getDeviceIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 6, this.deviceId_);
            }
        }

        /* synthetic */ BindDataCollection(GeneratedMessageV3.b bVar, a aVar) {
            this(bVar);
        }

        public static b newBuilder(BindDataCollection bindDataCollection) {
            return DEFAULT_INSTANCE.toBuilder().o(bindDataCollection);
        }

        public static BindDataCollection parseFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, qVar);
        }

        private BindDataCollection(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static BindDataCollection parseDelimitedFrom(InputStream inputStream, q qVar) throws IOException {
            return (BindDataCollection) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
        }

        public static BindDataCollection parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
        public BindDataCollection getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b toBuilder() {
            return this == DEFAULT_INSTANCE ? new b((a) null) : new b((a) null).o(this);
        }

        public static BindDataCollection parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b newBuilderForType() {
            return newBuilder();
        }

        private BindDataCollection() {
            this.memoizedIsInitialized = (byte) -1;
            this.wwid_ = "";
            this.deviceWwidDatas_ = Collections.emptyList();
            this.channel_ = 0;
            this.latitude_ = 0.0d;
            this.longitude_ = 0.0d;
            this.deviceId_ = "";
        }

        public static BindDataCollection parseFrom(InputStream inputStream) throws IOException {
            return (BindDataCollection) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static BindDataCollection parseFrom(InputStream inputStream, q qVar) throws IOException {
            return (BindDataCollection) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
        }

        public static BindDataCollection parseFrom(i iVar) throws IOException {
            return (BindDataCollection) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
        }

        public static BindDataCollection parseFrom(i iVar, q qVar) throws IOException {
            return (BindDataCollection) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
        }

        private BindDataCollection(i iVar, q qVar) throws InvalidProtocolBufferException {
            this();
            boolean z10 = false;
            boolean z11 = false;
            while (true) {
                if (z10) {
                    break;
                }
                try {
                    try {
                        try {
                            int F = iVar.F();
                            z10 = true;
                            if (F != 0) {
                                if (F == 10) {
                                    this.wwid_ = iVar.E();
                                } else if (F == 18) {
                                    if (!(z11 & true)) {
                                        this.deviceWwidDatas_ = new ArrayList();
                                        z11 |= true;
                                    }
                                    this.deviceWwidDatas_.add((DeviceWwidData) iVar.v(DeviceWwidData.parser(), qVar));
                                } else if (F == 24) {
                                    this.channel_ = iVar.o();
                                } else if (F == 33) {
                                    this.latitude_ = iVar.n();
                                } else if (F == 41) {
                                    this.longitude_ = iVar.n();
                                } else if (F == 50) {
                                    this.deviceId_ = iVar.E();
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
                    if (z11 & true) {
                        this.deviceWwidDatas_ = Collections.unmodifiableList(this.deviceWwidDatas_);
                    }
                    makeExtensionsImmutable();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class DeviceAddressInfo extends GeneratedMessageV3 implements c {
        public static final int CITY_FIELD_NUMBER = 3;
        public static final int COUNTRY_NAME_FIELD_NUMBER = 1;
        public static final int LATITUDE_FIELD_NUMBER = 5;
        public static final int LONGITUDE_FIELD_NUMBER = 6;
        public static final int PROVINCE_FIELD_NUMBER = 2;
        public static final int SUBLOCALITY_FIELD_NUMBER = 4;
        private static final long serialVersionUID = 0;
        private volatile Object city_;
        private volatile Object countryName_;
        private double latitude_;
        private double longitude_;
        private byte memoizedIsInitialized;
        private volatile Object province_;
        private volatile Object sublocality_;
        private static final DeviceAddressInfo DEFAULT_INSTANCE = new DeviceAddressInfo();
        private static final l0<DeviceAddressInfo> PARSER = new a();

        /* loaded from: classes2.dex */
        class a extends com.google.protobuf.c<DeviceAddressInfo> {
            a() {
            }

            /* renamed from: a */
            public DeviceAddressInfo parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
                return new DeviceAddressInfo(iVar, qVar, null);
            }
        }

        /* loaded from: classes2.dex */
        public static final class b extends GeneratedMessageV3.b<b> implements c {

            /* renamed from: a  reason: collision with root package name */
            private Object f15976a;

            /* renamed from: b  reason: collision with root package name */
            private Object f15977b;

            /* renamed from: c  reason: collision with root package name */
            private Object f15978c;

            /* renamed from: d  reason: collision with root package name */
            private Object f15979d;

            /* renamed from: e  reason: collision with root package name */
            private double f15980e;

            /* renamed from: f  reason: collision with root package name */
            private double f15981f;

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
            public DeviceAddressInfo build() {
                DeviceAddressInfo c10 = buildPartial();
                if (c10.isInitialized()) {
                    return c10;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) c10);
            }

            /* renamed from: c */
            public DeviceAddressInfo buildPartial() {
                DeviceAddressInfo deviceAddressInfo = new DeviceAddressInfo(this, (a) null);
                deviceAddressInfo.countryName_ = this.f15976a;
                deviceAddressInfo.province_ = this.f15977b;
                deviceAddressInfo.city_ = this.f15978c;
                deviceAddressInfo.sublocality_ = this.f15979d;
                deviceAddressInfo.latitude_ = this.f15980e;
                deviceAddressInfo.longitude_ = this.f15981f;
                onBuilt();
                return deviceAddressInfo;
            }

            /* renamed from: d */
            public b clear() {
                super.clear();
                this.f15976a = "";
                this.f15977b = "";
                this.f15978c = "";
                this.f15979d = "";
                this.f15980e = 0.0d;
                this.f15981f = 0.0d;
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
                return DeviceInfoProto.f15957c;
            }

            /* renamed from: i */
            public DeviceAddressInfo getDefaultInstanceForType() {
                return DeviceAddressInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return DeviceInfoProto.f15958d.e(DeviceAddressInfo.class, b.class);
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
                DeviceAddressInfo deviceAddressInfo = null;
                try {
                    try {
                        DeviceAddressInfo deviceAddressInfo2 = (DeviceAddressInfo) DeviceAddressInfo.PARSER.parsePartialFrom(iVar, qVar);
                        if (deviceAddressInfo2 != null) {
                            l(deviceAddressInfo2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e10) {
                        deviceAddressInfo = (DeviceAddressInfo) e10.getUnfinishedMessage();
                        try {
                            throw e10.unwrapIOException();
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (deviceAddressInfo != null) {
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (deviceAddressInfo != null) {
                        l(deviceAddressInfo);
                    }
                    throw th2;
                }
            }

            /* renamed from: k */
            public b mergeFrom(d0 d0Var) {
                if (d0Var instanceof DeviceAddressInfo) {
                    return l((DeviceAddressInfo) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            public b l(DeviceAddressInfo deviceAddressInfo) {
                if (deviceAddressInfo == DeviceAddressInfo.getDefaultInstance()) {
                    return this;
                }
                if (!deviceAddressInfo.getCountryName().isEmpty()) {
                    this.f15976a = deviceAddressInfo.countryName_;
                    onChanged();
                }
                if (!deviceAddressInfo.getProvince().isEmpty()) {
                    this.f15977b = deviceAddressInfo.province_;
                    onChanged();
                }
                if (!deviceAddressInfo.getCity().isEmpty()) {
                    this.f15978c = deviceAddressInfo.city_;
                    onChanged();
                }
                if (!deviceAddressInfo.getSublocality().isEmpty()) {
                    this.f15979d = deviceAddressInfo.sublocality_;
                    onChanged();
                }
                if (deviceAddressInfo.getLatitude() != 0.0d) {
                    o(deviceAddressInfo.getLatitude());
                }
                if (deviceAddressInfo.getLongitude() != 0.0d) {
                    p(deviceAddressInfo.getLongitude());
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

            public b o(double d10) {
                this.f15980e = d10;
                onChanged();
                return this;
            }

            public b p(double d10) {
                this.f15981f = d10;
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
                this.f15976a = "";
                this.f15977b = "";
                this.f15978c = "";
                this.f15979d = "";
                maybeForceBuilderInitialization();
            }

            private b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.f15976a = "";
                this.f15977b = "";
                this.f15978c = "";
                this.f15979d = "";
                maybeForceBuilderInitialization();
            }
        }

        /* synthetic */ DeviceAddressInfo(i iVar, q qVar, a aVar) throws InvalidProtocolBufferException {
            this(iVar, qVar);
        }

        public static DeviceAddressInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return DeviceInfoProto.f15957c;
        }

        public static b newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static DeviceAddressInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (DeviceAddressInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static DeviceAddressInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static l0<DeviceAddressInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof DeviceAddressInfo)) {
                return super.equals(obj);
            }
            DeviceAddressInfo deviceAddressInfo = (DeviceAddressInfo) obj;
            return (((((getCountryName().equals(deviceAddressInfo.getCountryName())) && getProvince().equals(deviceAddressInfo.getProvince())) && getCity().equals(deviceAddressInfo.getCity())) && getSublocality().equals(deviceAddressInfo.getSublocality())) && (Double.doubleToLongBits(getLatitude()) > Double.doubleToLongBits(deviceAddressInfo.getLatitude()) ? 1 : (Double.doubleToLongBits(getLatitude()) == Double.doubleToLongBits(deviceAddressInfo.getLatitude()) ? 0 : -1)) == 0) && Double.doubleToLongBits(getLongitude()) == Double.doubleToLongBits(deviceAddressInfo.getLongitude());
        }

        public String getCity() {
            Object obj = this.city_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.city_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getCityBytes() {
            Object obj = this.city_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.city_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public String getCountryName() {
            Object obj = this.countryName_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.countryName_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getCountryNameBytes() {
            Object obj = this.countryName_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.countryName_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public double getLatitude() {
            return this.latitude_;
        }

        public double getLongitude() {
            return this.longitude_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public l0<DeviceAddressInfo> getParserForType() {
            return PARSER;
        }

        public String getProvince() {
            Object obj = this.province_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.province_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getProvinceBytes() {
            Object obj = this.province_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.province_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
        public int getSerializedSize() {
            int i10 = this.memoizedSize;
            if (i10 != -1) {
                return i10;
            }
            int i11 = 0;
            if (!getCountryNameBytes().isEmpty()) {
                i11 = 0 + GeneratedMessageV3.computeStringSize(1, this.countryName_);
            }
            if (!getProvinceBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(2, this.province_);
            }
            if (!getCityBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(3, this.city_);
            }
            if (!getSublocalityBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(4, this.sublocality_);
            }
            double d10 = this.latitude_;
            if (d10 != 0.0d) {
                i11 += CodedOutputStream.j(5, d10);
            }
            double d11 = this.longitude_;
            if (d11 != 0.0d) {
                i11 += CodedOutputStream.j(6, d11);
            }
            this.memoizedSize = i11;
            return i11;
        }

        public String getSublocality() {
            Object obj = this.sublocality_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.sublocality_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getSublocalityBytes() {
            Object obj = this.sublocality_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.sublocality_ = copyFromUtf8;
            return copyFromUtf8;
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
            int hashCode = ((((((((((((((((((((((((((779 + getDescriptorForType().hashCode()) * 37) + 1) * 53) + getCountryName().hashCode()) * 37) + 2) * 53) + getProvince().hashCode()) * 37) + 3) * 53) + getCity().hashCode()) * 37) + 4) * 53) + getSublocality().hashCode()) * 37) + 5) * 53) + u.h(Double.doubleToLongBits(getLatitude()))) * 37) + 6) * 53) + u.h(Double.doubleToLongBits(getLongitude()))) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return DeviceInfoProto.f15958d.e(DeviceAddressInfo.class, b.class);
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
        /* renamed from: n */
        public b newBuilderForType(GeneratedMessageV3.c cVar) {
            return new b(cVar, null);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (!getCountryNameBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.countryName_);
            }
            if (!getProvinceBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.province_);
            }
            if (!getCityBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 3, this.city_);
            }
            if (!getSublocalityBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 4, this.sublocality_);
            }
            double d10 = this.latitude_;
            if (d10 != 0.0d) {
                codedOutputStream.k0(5, d10);
            }
            double d11 = this.longitude_;
            if (d11 != 0.0d) {
                codedOutputStream.k0(6, d11);
            }
        }

        /* synthetic */ DeviceAddressInfo(GeneratedMessageV3.b bVar, a aVar) {
            this(bVar);
        }

        public static b newBuilder(DeviceAddressInfo deviceAddressInfo) {
            return DEFAULT_INSTANCE.toBuilder().l(deviceAddressInfo);
        }

        public static DeviceAddressInfo parseFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, qVar);
        }

        private DeviceAddressInfo(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static DeviceAddressInfo parseDelimitedFrom(InputStream inputStream, q qVar) throws IOException {
            return (DeviceAddressInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
        }

        public static DeviceAddressInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
        public DeviceAddressInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b toBuilder() {
            return this == DEFAULT_INSTANCE ? new b((a) null) : new b((a) null).l(this);
        }

        public static DeviceAddressInfo parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b newBuilderForType() {
            return newBuilder();
        }

        private DeviceAddressInfo() {
            this.memoizedIsInitialized = (byte) -1;
            this.countryName_ = "";
            this.province_ = "";
            this.city_ = "";
            this.sublocality_ = "";
            this.latitude_ = 0.0d;
            this.longitude_ = 0.0d;
        }

        public static DeviceAddressInfo parseFrom(InputStream inputStream) throws IOException {
            return (DeviceAddressInfo) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static DeviceAddressInfo parseFrom(InputStream inputStream, q qVar) throws IOException {
            return (DeviceAddressInfo) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
        }

        public static DeviceAddressInfo parseFrom(i iVar) throws IOException {
            return (DeviceAddressInfo) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
        }

        public static DeviceAddressInfo parseFrom(i iVar, q qVar) throws IOException {
            return (DeviceAddressInfo) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
        }

        private DeviceAddressInfo(i iVar, q qVar) throws InvalidProtocolBufferException {
            this();
            boolean z10 = false;
            while (!z10) {
                try {
                    try {
                        int F = iVar.F();
                        z10 = true;
                        if (F != 0) {
                            if (F == 10) {
                                this.countryName_ = iVar.E();
                            } else if (F == 18) {
                                this.province_ = iVar.E();
                            } else if (F == 26) {
                                this.city_ = iVar.E();
                            } else if (F == 34) {
                                this.sublocality_ = iVar.E();
                            } else if (F == 41) {
                                this.latitude_ = iVar.n();
                            } else if (F == 49) {
                                this.longitude_ = iVar.n();
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
    public static final class DeviceInfo extends GeneratedMessageV3 implements d {
        public static final int CHANNEL_FIELD_NUMBER = 6;
        public static final int DEVICE_ADDRESS_INFO_FIELD_NUMBER = 8;
        public static final int DEVICE_ID_FIELD_NUMBER = 2;
        public static final int DEVICE_TYPE_FIELD_NUMBER = 3;
        public static final int OS_FIELD_NUMBER = 7;
        public static final int VERSION_NAME_FIELD_NUMBER = 4;
        public static final int VERSION_NUMBER_FIELD_NUMBER = 5;
        public static final int WWID_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private volatile Object channel_;
        private DeviceAddressInfo deviceAddressInfo_;
        private volatile Object deviceId_;
        private int deviceType_;
        private byte memoizedIsInitialized;
        private volatile Object os_;
        private volatile Object versionName_;
        private volatile Object versionNumber_;
        private volatile Object wwid_;
        private static final DeviceInfo DEFAULT_INSTANCE = new DeviceInfo();
        private static final l0<DeviceInfo> PARSER = new a();

        /* loaded from: classes2.dex */
        class a extends com.google.protobuf.c<DeviceInfo> {
            a() {
            }

            /* renamed from: a */
            public DeviceInfo parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
                return new DeviceInfo(iVar, qVar, null);
            }
        }

        /* loaded from: classes2.dex */
        public static final class b extends GeneratedMessageV3.b<b> implements d {

            /* renamed from: a  reason: collision with root package name */
            private Object f15982a;

            /* renamed from: b  reason: collision with root package name */
            private Object f15983b;

            /* renamed from: c  reason: collision with root package name */
            private int f15984c;

            /* renamed from: d  reason: collision with root package name */
            private Object f15985d;

            /* renamed from: e  reason: collision with root package name */
            private Object f15986e;

            /* renamed from: f  reason: collision with root package name */
            private Object f15987f;

            /* renamed from: g  reason: collision with root package name */
            private Object f15988g;

            /* renamed from: h  reason: collision with root package name */
            private DeviceAddressInfo f15989h;

            /* renamed from: i  reason: collision with root package name */
            private q0<DeviceAddressInfo, DeviceAddressInfo.b, c> f15990i;

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
            public DeviceInfo build() {
                DeviceInfo c10 = buildPartial();
                if (c10.isInitialized()) {
                    return c10;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) c10);
            }

            /* renamed from: c */
            public DeviceInfo buildPartial() {
                DeviceInfo deviceInfo = new DeviceInfo(this, (a) null);
                deviceInfo.wwid_ = this.f15982a;
                deviceInfo.deviceId_ = this.f15983b;
                deviceInfo.deviceType_ = this.f15984c;
                deviceInfo.versionName_ = this.f15985d;
                deviceInfo.versionNumber_ = this.f15986e;
                deviceInfo.channel_ = this.f15987f;
                deviceInfo.os_ = this.f15988g;
                q0<DeviceAddressInfo, DeviceAddressInfo.b, c> q0Var = this.f15990i;
                if (q0Var == null) {
                    deviceInfo.deviceAddressInfo_ = this.f15989h;
                } else {
                    deviceInfo.deviceAddressInfo_ = q0Var.b();
                }
                onBuilt();
                return deviceInfo;
            }

            /* renamed from: d */
            public b clear() {
                super.clear();
                this.f15982a = "";
                this.f15983b = "";
                this.f15984c = 0;
                this.f15985d = "";
                this.f15986e = "";
                this.f15987f = "";
                this.f15988g = "";
                if (this.f15990i == null) {
                    this.f15989h = null;
                } else {
                    this.f15989h = null;
                    this.f15990i = null;
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
                return DeviceInfoProto.f15955a;
            }

            /* renamed from: i */
            public DeviceInfo getDefaultInstanceForType() {
                return DeviceInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return DeviceInfoProto.f15956b.e(DeviceInfo.class, b.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.f0
            public final boolean isInitialized() {
                return true;
            }

            public b j(DeviceAddressInfo deviceAddressInfo) {
                q0<DeviceAddressInfo, DeviceAddressInfo.b, c> q0Var = this.f15990i;
                if (q0Var == null) {
                    DeviceAddressInfo deviceAddressInfo2 = this.f15989h;
                    if (deviceAddressInfo2 != null) {
                        this.f15989h = DeviceAddressInfo.newBuilder(deviceAddressInfo2).l(deviceAddressInfo).buildPartial();
                    } else {
                        this.f15989h = deviceAddressInfo;
                    }
                    onChanged();
                } else {
                    q0Var.h(deviceAddressInfo);
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
                DeviceInfo deviceInfo = null;
                try {
                    try {
                        DeviceInfo deviceInfo2 = (DeviceInfo) DeviceInfo.PARSER.parsePartialFrom(iVar, qVar);
                        if (deviceInfo2 != null) {
                            m(deviceInfo2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e10) {
                        deviceInfo = (DeviceInfo) e10.getUnfinishedMessage();
                        try {
                            throw e10.unwrapIOException();
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (deviceInfo != null) {
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (deviceInfo != null) {
                        m(deviceInfo);
                    }
                    throw th2;
                }
            }

            /* renamed from: l */
            public b mergeFrom(d0 d0Var) {
                if (d0Var instanceof DeviceInfo) {
                    return m((DeviceInfo) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            public b m(DeviceInfo deviceInfo) {
                if (deviceInfo == DeviceInfo.getDefaultInstance()) {
                    return this;
                }
                if (!deviceInfo.getWwid().isEmpty()) {
                    this.f15982a = deviceInfo.wwid_;
                    onChanged();
                }
                if (!deviceInfo.getDeviceId().isEmpty()) {
                    this.f15983b = deviceInfo.deviceId_;
                    onChanged();
                }
                if (deviceInfo.deviceType_ != 0) {
                    o(deviceInfo.getDeviceTypeValue());
                }
                if (!deviceInfo.getVersionName().isEmpty()) {
                    this.f15985d = deviceInfo.versionName_;
                    onChanged();
                }
                if (!deviceInfo.getVersionNumber().isEmpty()) {
                    this.f15986e = deviceInfo.versionNumber_;
                    onChanged();
                }
                if (!deviceInfo.getChannel().isEmpty()) {
                    this.f15987f = deviceInfo.channel_;
                    onChanged();
                }
                if (!deviceInfo.getOs().isEmpty()) {
                    this.f15988g = deviceInfo.os_;
                    onChanged();
                }
                if (deviceInfo.hasDeviceAddressInfo()) {
                    j(deviceInfo.getDeviceAddressInfo());
                }
                onChanged();
                return this;
            }

            /* renamed from: n */
            public final b mergeUnknownFields(a1 a1Var) {
                return this;
            }

            public b o(int i10) {
                this.f15984c = i10;
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
                this.f15982a = "";
                this.f15983b = "";
                this.f15984c = 0;
                this.f15985d = "";
                this.f15986e = "";
                this.f15987f = "";
                this.f15988g = "";
                this.f15989h = null;
                maybeForceBuilderInitialization();
            }

            private b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.f15982a = "";
                this.f15983b = "";
                this.f15984c = 0;
                this.f15985d = "";
                this.f15986e = "";
                this.f15987f = "";
                this.f15988g = "";
                this.f15989h = null;
                maybeForceBuilderInitialization();
            }
        }

        /* synthetic */ DeviceInfo(i iVar, q qVar, a aVar) throws InvalidProtocolBufferException {
            this(iVar, qVar);
        }

        public static DeviceInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return DeviceInfoProto.f15955a;
        }

        public static b newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static DeviceInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (DeviceInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static DeviceInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static l0<DeviceInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            boolean z10 = true;
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof DeviceInfo)) {
                return super.equals(obj);
            }
            DeviceInfo deviceInfo = (DeviceInfo) obj;
            boolean z11 = (((((((getWwid().equals(deviceInfo.getWwid())) && getDeviceId().equals(deviceInfo.getDeviceId())) && this.deviceType_ == deviceInfo.deviceType_) && getVersionName().equals(deviceInfo.getVersionName())) && getVersionNumber().equals(deviceInfo.getVersionNumber())) && getChannel().equals(deviceInfo.getChannel())) && getOs().equals(deviceInfo.getOs())) && hasDeviceAddressInfo() == deviceInfo.hasDeviceAddressInfo();
            if (!hasDeviceAddressInfo()) {
                return z11;
            }
            if (!z11 || !getDeviceAddressInfo().equals(deviceInfo.getDeviceAddressInfo())) {
                z10 = false;
            }
            return z10;
        }

        public String getChannel() {
            Object obj = this.channel_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.channel_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getChannelBytes() {
            Object obj = this.channel_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.channel_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public DeviceAddressInfo getDeviceAddressInfo() {
            DeviceAddressInfo deviceAddressInfo = this.deviceAddressInfo_;
            return deviceAddressInfo == null ? DeviceAddressInfo.getDefaultInstance() : deviceAddressInfo;
        }

        public c getDeviceAddressInfoOrBuilder() {
            return getDeviceAddressInfo();
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

        public String getOs() {
            Object obj = this.os_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.os_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getOsBytes() {
            Object obj = this.os_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.os_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public l0<DeviceInfo> getParserForType() {
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
            if (this.deviceType_ != ConstantProto.DeviceType.UNKNOWN_DEVICE_TYPE.getNumber()) {
                i11 += CodedOutputStream.l(3, this.deviceType_);
            }
            if (!getVersionNameBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(4, this.versionName_);
            }
            if (!getVersionNumberBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(5, this.versionNumber_);
            }
            if (!getChannelBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(6, this.channel_);
            }
            if (!getOsBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(7, this.os_);
            }
            if (this.deviceAddressInfo_ != null) {
                i11 += CodedOutputStream.E(8, getDeviceAddressInfo());
            }
            this.memoizedSize = i11;
            return i11;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.g0
        public final a1 getUnknownFields() {
            return a1.c();
        }

        public String getVersionName() {
            Object obj = this.versionName_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.versionName_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getVersionNameBytes() {
            Object obj = this.versionName_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.versionName_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public String getVersionNumber() {
            Object obj = this.versionNumber_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.versionNumber_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getVersionNumberBytes() {
            Object obj = this.versionNumber_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.versionNumber_ = copyFromUtf8;
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

        public boolean hasDeviceAddressInfo() {
            return this.deviceAddressInfo_ != null;
        }

        @Override // com.google.protobuf.a
        public int hashCode() {
            int i10 = this.memoizedHashCode;
            if (i10 != 0) {
                return i10;
            }
            int hashCode = ((((((((((((((((((((((((((((779 + getDescriptorForType().hashCode()) * 37) + 1) * 53) + getWwid().hashCode()) * 37) + 2) * 53) + getDeviceId().hashCode()) * 37) + 3) * 53) + this.deviceType_) * 37) + 4) * 53) + getVersionName().hashCode()) * 37) + 5) * 53) + getVersionNumber().hashCode()) * 37) + 6) * 53) + getChannel().hashCode()) * 37) + 7) * 53) + getOs().hashCode();
            if (hasDeviceAddressInfo()) {
                hashCode = (((hashCode * 37) + 8) * 53) + getDeviceAddressInfo().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return DeviceInfoProto.f15956b.e(DeviceInfo.class, b.class);
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
        /* renamed from: s */
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
            if (this.deviceType_ != ConstantProto.DeviceType.UNKNOWN_DEVICE_TYPE.getNumber()) {
                codedOutputStream.m0(3, this.deviceType_);
            }
            if (!getVersionNameBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 4, this.versionName_);
            }
            if (!getVersionNumberBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 5, this.versionNumber_);
            }
            if (!getChannelBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 6, this.channel_);
            }
            if (!getOsBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 7, this.os_);
            }
            if (this.deviceAddressInfo_ != null) {
                codedOutputStream.A0(8, getDeviceAddressInfo());
            }
        }

        /* synthetic */ DeviceInfo(GeneratedMessageV3.b bVar, a aVar) {
            this(bVar);
        }

        public static b newBuilder(DeviceInfo deviceInfo) {
            return DEFAULT_INSTANCE.toBuilder().m(deviceInfo);
        }

        public static DeviceInfo parseFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, qVar);
        }

        private DeviceInfo(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static DeviceInfo parseDelimitedFrom(InputStream inputStream, q qVar) throws IOException {
            return (DeviceInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
        }

        public static DeviceInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
        public DeviceInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b toBuilder() {
            return this == DEFAULT_INSTANCE ? new b((a) null) : new b((a) null).m(this);
        }

        public static DeviceInfo parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b newBuilderForType() {
            return newBuilder();
        }

        private DeviceInfo() {
            this.memoizedIsInitialized = (byte) -1;
            this.wwid_ = "";
            this.deviceId_ = "";
            this.deviceType_ = 0;
            this.versionName_ = "";
            this.versionNumber_ = "";
            this.channel_ = "";
            this.os_ = "";
        }

        public static DeviceInfo parseFrom(InputStream inputStream) throws IOException {
            return (DeviceInfo) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static DeviceInfo parseFrom(InputStream inputStream, q qVar) throws IOException {
            return (DeviceInfo) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
        }

        public static DeviceInfo parseFrom(i iVar) throws IOException {
            return (DeviceInfo) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
        }

        public static DeviceInfo parseFrom(i iVar, q qVar) throws IOException {
            return (DeviceInfo) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
        }

        private DeviceInfo(i iVar, q qVar) throws InvalidProtocolBufferException {
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
                            } else if (F == 24) {
                                this.deviceType_ = iVar.o();
                            } else if (F == 34) {
                                this.versionName_ = iVar.E();
                            } else if (F == 42) {
                                this.versionNumber_ = iVar.E();
                            } else if (F == 50) {
                                this.channel_ = iVar.E();
                            } else if (F == 58) {
                                this.os_ = iVar.E();
                            } else if (F == 66) {
                                DeviceAddressInfo.b bVar = null;
                                DeviceAddressInfo deviceAddressInfo = this.deviceAddressInfo_;
                                bVar = deviceAddressInfo != null ? deviceAddressInfo.toBuilder() : bVar;
                                DeviceAddressInfo deviceAddressInfo2 = (DeviceAddressInfo) iVar.v(DeviceAddressInfo.parser(), qVar);
                                this.deviceAddressInfo_ = deviceAddressInfo2;
                                if (bVar != null) {
                                    bVar.l(deviceAddressInfo2);
                                    this.deviceAddressInfo_ = bVar.buildPartial();
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
    }

    /* loaded from: classes2.dex */
    public static final class DeviceInfoRequest extends GeneratedMessageV3 implements g0 {
        public static final int DEVICE_INFO_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private byte memoizedIsInitialized;
        private int typeCase_;
        private Object type_;
        private static final DeviceInfoRequest DEFAULT_INSTANCE = new DeviceInfoRequest();
        private static final l0<DeviceInfoRequest> PARSER = new a();

        /* loaded from: classes2.dex */
        public enum TypeCase implements u.a {
            DEVICE_INFO(1),
            TYPE_NOT_SET(0);
            
            private final int value;

            TypeCase(int i10) {
                this.value = i10;
            }

            public static TypeCase forNumber(int i10) {
                if (i10 == 0) {
                    return TYPE_NOT_SET;
                }
                if (i10 != 1) {
                    return null;
                }
                return DEVICE_INFO;
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
        class a extends com.google.protobuf.c<DeviceInfoRequest> {
            a() {
            }

            /* renamed from: a */
            public DeviceInfoRequest parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
                return new DeviceInfoRequest(iVar, qVar, null);
            }
        }

        /* loaded from: classes2.dex */
        public static final class b extends GeneratedMessageV3.b<b> implements g0 {

            /* renamed from: a  reason: collision with root package name */
            private int f15991a;

            /* renamed from: b  reason: collision with root package name */
            private Object f15992b;

            /* renamed from: c  reason: collision with root package name */
            private q0<DeviceInfo, DeviceInfo.b, d> f15993c;

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
            public DeviceInfoRequest build() {
                DeviceInfoRequest c10 = buildPartial();
                if (c10.isInitialized()) {
                    return c10;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) c10);
            }

            /* renamed from: c */
            public DeviceInfoRequest buildPartial() {
                DeviceInfoRequest deviceInfoRequest = new DeviceInfoRequest(this, (a) null);
                if (this.f15991a == 1) {
                    q0<DeviceInfo, DeviceInfo.b, d> q0Var = this.f15993c;
                    if (q0Var == null) {
                        deviceInfoRequest.type_ = this.f15992b;
                    } else {
                        deviceInfoRequest.type_ = q0Var.b();
                    }
                }
                deviceInfoRequest.typeCase_ = this.f15991a;
                onBuilt();
                return deviceInfoRequest;
            }

            /* renamed from: d */
            public b clear() {
                super.clear();
                this.f15991a = 0;
                this.f15992b = null;
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
                return DeviceInfoProto.f15959e;
            }

            /* renamed from: i */
            public DeviceInfoRequest getDefaultInstanceForType() {
                return DeviceInfoRequest.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return DeviceInfoProto.f15960f.e(DeviceInfoRequest.class, b.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.f0
            public final boolean isInitialized() {
                return true;
            }

            public b j(DeviceInfo deviceInfo) {
                q0<DeviceInfo, DeviceInfo.b, d> q0Var = this.f15993c;
                if (q0Var == null) {
                    if (this.f15991a != 1 || this.f15992b == DeviceInfo.getDefaultInstance()) {
                        this.f15992b = deviceInfo;
                    } else {
                        this.f15992b = DeviceInfo.newBuilder((DeviceInfo) this.f15992b).m(deviceInfo).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.f15991a == 1) {
                        q0Var.h(deviceInfo);
                    }
                    this.f15993c.j(deviceInfo);
                }
                this.f15991a = 1;
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x0023  */
            /* renamed from: k */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public b mergeFrom(i iVar, q qVar) throws IOException {
                Throwable th2;
                DeviceInfoRequest deviceInfoRequest = null;
                try {
                    try {
                        DeviceInfoRequest deviceInfoRequest2 = (DeviceInfoRequest) DeviceInfoRequest.PARSER.parsePartialFrom(iVar, qVar);
                        if (deviceInfoRequest2 != null) {
                            m(deviceInfoRequest2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e10) {
                        deviceInfoRequest = (DeviceInfoRequest) e10.getUnfinishedMessage();
                        try {
                            throw e10.unwrapIOException();
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (deviceInfoRequest != null) {
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (deviceInfoRequest != null) {
                        m(deviceInfoRequest);
                    }
                    throw th2;
                }
            }

            /* renamed from: l */
            public b mergeFrom(d0 d0Var) {
                if (d0Var instanceof DeviceInfoRequest) {
                    return m((DeviceInfoRequest) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            public b m(DeviceInfoRequest deviceInfoRequest) {
                if (deviceInfoRequest == DeviceInfoRequest.getDefaultInstance()) {
                    return this;
                }
                if (b.f16003a[deviceInfoRequest.getTypeCase().ordinal()] == 1) {
                    j(deviceInfoRequest.getDeviceInfo());
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
                this.f15991a = 0;
                maybeForceBuilderInitialization();
            }

            private b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.f15991a = 0;
                maybeForceBuilderInitialization();
            }
        }

        /* synthetic */ DeviceInfoRequest(i iVar, q qVar, a aVar) throws InvalidProtocolBufferException {
            this(iVar, qVar);
        }

        public static DeviceInfoRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return DeviceInfoProto.f15959e;
        }

        public static b newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static DeviceInfoRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (DeviceInfoRequest) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static DeviceInfoRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static l0<DeviceInfoRequest> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            boolean z10 = true;
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof DeviceInfoRequest)) {
                return super.equals(obj);
            }
            DeviceInfoRequest deviceInfoRequest = (DeviceInfoRequest) obj;
            boolean z11 = getTypeCase().equals(deviceInfoRequest.getTypeCase());
            if (!z11) {
                return false;
            }
            if (this.typeCase_ != 1) {
                return z11;
            }
            if (!z11 || !getDeviceInfo().equals(deviceInfoRequest.getDeviceInfo())) {
                z10 = false;
            }
            return z10;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: g */
        public b newBuilderForType(GeneratedMessageV3.c cVar) {
            return new b(cVar, null);
        }

        public DeviceInfo getDeviceInfo() {
            if (this.typeCase_ == 1) {
                return (DeviceInfo) this.type_;
            }
            return DeviceInfo.getDefaultInstance();
        }

        public d getDeviceInfoOrBuilder() {
            if (this.typeCase_ == 1) {
                return (DeviceInfo) this.type_;
            }
            return DeviceInfo.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public l0<DeviceInfoRequest> getParserForType() {
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
                i11 = 0 + CodedOutputStream.E(1, (DeviceInfo) this.type_);
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

        @Override // com.google.protobuf.a
        public int hashCode() {
            int i10 = this.memoizedHashCode;
            if (i10 != 0) {
                return i10;
            }
            int hashCode = 779 + getDescriptorForType().hashCode();
            if (this.typeCase_ == 1) {
                hashCode = (((hashCode * 37) + 1) * 53) + getDeviceInfo().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return DeviceInfoProto.f15960f.e(DeviceInfoRequest.class, b.class);
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
                codedOutputStream.A0(1, (DeviceInfo) this.type_);
            }
        }

        /* synthetic */ DeviceInfoRequest(GeneratedMessageV3.b bVar, a aVar) {
            this(bVar);
        }

        public static b newBuilder(DeviceInfoRequest deviceInfoRequest) {
            return DEFAULT_INSTANCE.toBuilder().m(deviceInfoRequest);
        }

        public static DeviceInfoRequest parseFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, qVar);
        }

        private DeviceInfoRequest(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.typeCase_ = 0;
            this.memoizedIsInitialized = (byte) -1;
        }

        public static DeviceInfoRequest parseDelimitedFrom(InputStream inputStream, q qVar) throws IOException {
            return (DeviceInfoRequest) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
        }

        public static DeviceInfoRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
        public DeviceInfoRequest getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b toBuilder() {
            return this == DEFAULT_INSTANCE ? new b((a) null) : new b((a) null).m(this);
        }

        public static DeviceInfoRequest parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b newBuilderForType() {
            return newBuilder();
        }

        public static DeviceInfoRequest parseFrom(InputStream inputStream) throws IOException {
            return (DeviceInfoRequest) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        private DeviceInfoRequest() {
            this.typeCase_ = 0;
            this.memoizedIsInitialized = (byte) -1;
        }

        public static DeviceInfoRequest parseFrom(InputStream inputStream, q qVar) throws IOException {
            return (DeviceInfoRequest) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
        }

        private DeviceInfoRequest(i iVar, q qVar) throws InvalidProtocolBufferException {
            this();
            boolean z10 = false;
            while (!z10) {
                try {
                    try {
                        try {
                            int F = iVar.F();
                            if (F != 0) {
                                if (F == 10) {
                                    DeviceInfo.b builder = this.typeCase_ == 1 ? ((DeviceInfo) this.type_).toBuilder() : null;
                                    e0 v10 = iVar.v(DeviceInfo.parser(), qVar);
                                    this.type_ = v10;
                                    if (builder != null) {
                                        builder.m((DeviceInfo) v10);
                                        this.type_ = builder.buildPartial();
                                    }
                                    this.typeCase_ = 1;
                                } else if (!iVar.I(F)) {
                                }
                            }
                            z10 = true;
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

        public static DeviceInfoRequest parseFrom(i iVar) throws IOException {
            return (DeviceInfoRequest) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
        }

        public static DeviceInfoRequest parseFrom(i iVar, q qVar) throws IOException {
            return (DeviceInfoRequest) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
        }
    }

    /* loaded from: classes2.dex */
    public static final class DeviceInfoResponse extends GeneratedMessageV3 implements g0 {
        public static final int CODE_FIELD_NUMBER = 2;
        public static final int DEVICE_INFO_FIELD_NUMBER = 4;
        public static final int MSG_FIELD_NUMBER = 3;
        public static final int OK_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private int code_;
        private byte memoizedIsInitialized;
        private volatile Object msg_;
        private boolean ok_;
        private int typeCase_;
        private Object type_;
        private static final DeviceInfoResponse DEFAULT_INSTANCE = new DeviceInfoResponse();
        private static final l0<DeviceInfoResponse> PARSER = new a();

        /* loaded from: classes2.dex */
        public enum TypeCase implements u.a {
            DEVICE_INFO(4),
            TYPE_NOT_SET(0);
            
            private final int value;

            TypeCase(int i10) {
                this.value = i10;
            }

            public static TypeCase forNumber(int i10) {
                if (i10 == 0) {
                    return TYPE_NOT_SET;
                }
                if (i10 != 4) {
                    return null;
                }
                return DEVICE_INFO;
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
        class a extends com.google.protobuf.c<DeviceInfoResponse> {
            a() {
            }

            /* renamed from: a */
            public DeviceInfoResponse parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
                return new DeviceInfoResponse(iVar, qVar, null);
            }
        }

        /* loaded from: classes2.dex */
        public static final class b extends GeneratedMessageV3.b<b> implements g0 {

            /* renamed from: a  reason: collision with root package name */
            private int f15994a;

            /* renamed from: b  reason: collision with root package name */
            private Object f15995b;

            /* renamed from: c  reason: collision with root package name */
            private boolean f15996c;

            /* renamed from: d  reason: collision with root package name */
            private int f15997d;

            /* renamed from: e  reason: collision with root package name */
            private Object f15998e;

            /* renamed from: f  reason: collision with root package name */
            private q0<DeviceInfo, DeviceInfo.b, d> f15999f;

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
            public DeviceInfoResponse build() {
                DeviceInfoResponse c10 = buildPartial();
                if (c10.isInitialized()) {
                    return c10;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) c10);
            }

            /* renamed from: c */
            public DeviceInfoResponse buildPartial() {
                DeviceInfoResponse deviceInfoResponse = new DeviceInfoResponse(this, (a) null);
                deviceInfoResponse.ok_ = this.f15996c;
                deviceInfoResponse.code_ = this.f15997d;
                deviceInfoResponse.msg_ = this.f15998e;
                if (this.f15994a == 4) {
                    q0<DeviceInfo, DeviceInfo.b, d> q0Var = this.f15999f;
                    if (q0Var == null) {
                        deviceInfoResponse.type_ = this.f15995b;
                    } else {
                        deviceInfoResponse.type_ = q0Var.b();
                    }
                }
                deviceInfoResponse.typeCase_ = this.f15994a;
                onBuilt();
                return deviceInfoResponse;
            }

            /* renamed from: d */
            public b clear() {
                super.clear();
                this.f15996c = false;
                this.f15997d = 0;
                this.f15998e = "";
                this.f15994a = 0;
                this.f15995b = null;
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
                return DeviceInfoProto.f15961g;
            }

            /* renamed from: i */
            public DeviceInfoResponse getDefaultInstanceForType() {
                return DeviceInfoResponse.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return DeviceInfoProto.f15962h.e(DeviceInfoResponse.class, b.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.f0
            public final boolean isInitialized() {
                return true;
            }

            public b j(DeviceInfo deviceInfo) {
                q0<DeviceInfo, DeviceInfo.b, d> q0Var = this.f15999f;
                if (q0Var == null) {
                    if (this.f15994a != 4 || this.f15995b == DeviceInfo.getDefaultInstance()) {
                        this.f15995b = deviceInfo;
                    } else {
                        this.f15995b = DeviceInfo.newBuilder((DeviceInfo) this.f15995b).m(deviceInfo).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.f15994a == 4) {
                        q0Var.h(deviceInfo);
                    }
                    this.f15999f.j(deviceInfo);
                }
                this.f15994a = 4;
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x0023  */
            /* renamed from: k */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public b mergeFrom(i iVar, q qVar) throws IOException {
                Throwable th2;
                DeviceInfoResponse deviceInfoResponse = null;
                try {
                    try {
                        DeviceInfoResponse deviceInfoResponse2 = (DeviceInfoResponse) DeviceInfoResponse.PARSER.parsePartialFrom(iVar, qVar);
                        if (deviceInfoResponse2 != null) {
                            m(deviceInfoResponse2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e10) {
                        deviceInfoResponse = (DeviceInfoResponse) e10.getUnfinishedMessage();
                        try {
                            throw e10.unwrapIOException();
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (deviceInfoResponse != null) {
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (deviceInfoResponse != null) {
                        m(deviceInfoResponse);
                    }
                    throw th2;
                }
            }

            /* renamed from: l */
            public b mergeFrom(d0 d0Var) {
                if (d0Var instanceof DeviceInfoResponse) {
                    return m((DeviceInfoResponse) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            public b m(DeviceInfoResponse deviceInfoResponse) {
                if (deviceInfoResponse == DeviceInfoResponse.getDefaultInstance()) {
                    return this;
                }
                if (deviceInfoResponse.getOk()) {
                    q(deviceInfoResponse.getOk());
                }
                if (deviceInfoResponse.getCode() != 0) {
                    o(deviceInfoResponse.getCode());
                }
                if (!deviceInfoResponse.getMsg().isEmpty()) {
                    this.f15998e = deviceInfoResponse.msg_;
                    onChanged();
                }
                if (b.f16004b[deviceInfoResponse.getTypeCase().ordinal()] == 1) {
                    j(deviceInfoResponse.getDeviceInfo());
                }
                onChanged();
                return this;
            }

            /* renamed from: n */
            public final b mergeUnknownFields(a1 a1Var) {
                return this;
            }

            public b o(int i10) {
                this.f15997d = i10;
                onChanged();
                return this;
            }

            /* renamed from: p */
            public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.setField(fieldDescriptor, obj);
            }

            public b q(boolean z10) {
                this.f15996c = z10;
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
                this.f15994a = 0;
                this.f15998e = "";
                maybeForceBuilderInitialization();
            }

            private b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.f15994a = 0;
                this.f15998e = "";
                maybeForceBuilderInitialization();
            }
        }

        /* synthetic */ DeviceInfoResponse(i iVar, q qVar, a aVar) throws InvalidProtocolBufferException {
            this(iVar, qVar);
        }

        public static DeviceInfoResponse getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return DeviceInfoProto.f15961g;
        }

        public static b newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static DeviceInfoResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (DeviceInfoResponse) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static DeviceInfoResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static l0<DeviceInfoResponse> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            boolean z10 = true;
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof DeviceInfoResponse)) {
                return super.equals(obj);
            }
            DeviceInfoResponse deviceInfoResponse = (DeviceInfoResponse) obj;
            boolean z11 = (((getOk() == deviceInfoResponse.getOk()) && getCode() == deviceInfoResponse.getCode()) && getMsg().equals(deviceInfoResponse.getMsg())) && getTypeCase().equals(deviceInfoResponse.getTypeCase());
            if (!z11) {
                return false;
            }
            if (this.typeCase_ != 4) {
                return z11;
            }
            if (!z11 || !getDeviceInfo().equals(deviceInfoResponse.getDeviceInfo())) {
                z10 = false;
            }
            return z10;
        }

        public int getCode() {
            return this.code_;
        }

        public DeviceInfo getDeviceInfo() {
            if (this.typeCase_ == 4) {
                return (DeviceInfo) this.type_;
            }
            return DeviceInfo.getDefaultInstance();
        }

        public d getDeviceInfoOrBuilder() {
            if (this.typeCase_ == 4) {
                return (DeviceInfo) this.type_;
            }
            return DeviceInfo.getDefaultInstance();
        }

        public String getMsg() {
            Object obj = this.msg_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.msg_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getMsgBytes() {
            Object obj = this.msg_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.msg_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public boolean getOk() {
            return this.ok_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public l0<DeviceInfoResponse> getParserForType() {
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
            int i12 = this.code_;
            if (i12 != 0) {
                i11 += CodedOutputStream.v(2, i12);
            }
            if (!getMsgBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(3, this.msg_);
            }
            if (this.typeCase_ == 4) {
                i11 += CodedOutputStream.E(4, (DeviceInfo) this.type_);
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

        @Override // com.google.protobuf.a
        public int hashCode() {
            int i10 = this.memoizedHashCode;
            if (i10 != 0) {
                return i10;
            }
            int hashCode = ((((((((((((779 + getDescriptorForType().hashCode()) * 37) + 1) * 53) + u.c(getOk())) * 37) + 2) * 53) + getCode()) * 37) + 3) * 53) + getMsg().hashCode();
            if (this.typeCase_ == 4) {
                hashCode = (((hashCode * 37) + 4) * 53) + getDeviceInfo().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return DeviceInfoProto.f15962h.e(DeviceInfoResponse.class, b.class);
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
            boolean z10 = this.ok_;
            if (z10) {
                codedOutputStream.e0(1, z10);
            }
            int i10 = this.code_;
            if (i10 != 0) {
                codedOutputStream.w0(2, i10);
            }
            if (!getMsgBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 3, this.msg_);
            }
            if (this.typeCase_ == 4) {
                codedOutputStream.A0(4, (DeviceInfo) this.type_);
            }
        }

        /* synthetic */ DeviceInfoResponse(GeneratedMessageV3.b bVar, a aVar) {
            this(bVar);
        }

        public static b newBuilder(DeviceInfoResponse deviceInfoResponse) {
            return DEFAULT_INSTANCE.toBuilder().m(deviceInfoResponse);
        }

        public static DeviceInfoResponse parseFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, qVar);
        }

        private DeviceInfoResponse(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.typeCase_ = 0;
            this.memoizedIsInitialized = (byte) -1;
        }

        public static DeviceInfoResponse parseDelimitedFrom(InputStream inputStream, q qVar) throws IOException {
            return (DeviceInfoResponse) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
        }

        public static DeviceInfoResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
        public DeviceInfoResponse getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b toBuilder() {
            return this == DEFAULT_INSTANCE ? new b((a) null) : new b((a) null).m(this);
        }

        public static DeviceInfoResponse parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b newBuilderForType() {
            return newBuilder();
        }

        public static DeviceInfoResponse parseFrom(InputStream inputStream) throws IOException {
            return (DeviceInfoResponse) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        private DeviceInfoResponse() {
            this.typeCase_ = 0;
            this.memoizedIsInitialized = (byte) -1;
            this.ok_ = false;
            this.code_ = 0;
            this.msg_ = "";
        }

        public static DeviceInfoResponse parseFrom(InputStream inputStream, q qVar) throws IOException {
            return (DeviceInfoResponse) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
        }

        public static DeviceInfoResponse parseFrom(i iVar) throws IOException {
            return (DeviceInfoResponse) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
        }

        public static DeviceInfoResponse parseFrom(i iVar, q qVar) throws IOException {
            return (DeviceInfoResponse) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
        }

        private DeviceInfoResponse(i iVar, q qVar) throws InvalidProtocolBufferException {
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
                                    this.ok_ = iVar.l();
                                } else if (F == 16) {
                                    this.code_ = iVar.t();
                                } else if (F == 26) {
                                    this.msg_ = iVar.E();
                                } else if (F == 34) {
                                    DeviceInfo.b builder = this.typeCase_ == 4 ? ((DeviceInfo) this.type_).toBuilder() : null;
                                    e0 v10 = iVar.v(DeviceInfo.parser(), qVar);
                                    this.type_ = v10;
                                    if (builder != null) {
                                        builder.m((DeviceInfo) v10);
                                        this.type_ = builder.buildPartial();
                                    }
                                    this.typeCase_ = 4;
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
    public static final class DeviceWwidData extends GeneratedMessageV3 implements e {
        public static final int DEVICE_ID_FIELD_NUMBER = 1;
        public static final int DEVICE_TYPE_FIELD_NUMBER = 2;
        public static final int MODEL_FIELD_NUMBER = 3;
        private static final long serialVersionUID = 0;
        private volatile Object deviceId_;
        private int deviceType_;
        private byte memoizedIsInitialized;
        private volatile Object model_;
        private static final DeviceWwidData DEFAULT_INSTANCE = new DeviceWwidData();
        private static final l0<DeviceWwidData> PARSER = new a();

        /* loaded from: classes2.dex */
        class a extends com.google.protobuf.c<DeviceWwidData> {
            a() {
            }

            /* renamed from: a */
            public DeviceWwidData parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
                return new DeviceWwidData(iVar, qVar, null);
            }
        }

        /* loaded from: classes2.dex */
        public static final class b extends GeneratedMessageV3.b<b> implements e {

            /* renamed from: a  reason: collision with root package name */
            private Object f16000a;

            /* renamed from: b  reason: collision with root package name */
            private int f16001b;

            /* renamed from: c  reason: collision with root package name */
            private Object f16002c;

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
            public DeviceWwidData build() {
                DeviceWwidData c10 = buildPartial();
                if (c10.isInitialized()) {
                    return c10;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) c10);
            }

            /* renamed from: c */
            public DeviceWwidData buildPartial() {
                DeviceWwidData deviceWwidData = new DeviceWwidData(this, (a) null);
                deviceWwidData.deviceId_ = this.f16000a;
                deviceWwidData.deviceType_ = this.f16001b;
                deviceWwidData.model_ = this.f16002c;
                onBuilt();
                return deviceWwidData;
            }

            /* renamed from: d */
            public b clear() {
                super.clear();
                this.f16000a = "";
                this.f16001b = 0;
                this.f16002c = "";
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
                return DeviceInfoProto.f15963i;
            }

            /* renamed from: i */
            public DeviceWwidData getDefaultInstanceForType() {
                return DeviceWwidData.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return DeviceInfoProto.f15964j.e(DeviceWwidData.class, b.class);
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
                DeviceWwidData deviceWwidData = null;
                try {
                    try {
                        DeviceWwidData deviceWwidData2 = (DeviceWwidData) DeviceWwidData.PARSER.parsePartialFrom(iVar, qVar);
                        if (deviceWwidData2 != null) {
                            l(deviceWwidData2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e10) {
                        deviceWwidData = (DeviceWwidData) e10.getUnfinishedMessage();
                        try {
                            throw e10.unwrapIOException();
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (deviceWwidData != null) {
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (deviceWwidData != null) {
                        l(deviceWwidData);
                    }
                    throw th2;
                }
            }

            /* renamed from: k */
            public b mergeFrom(d0 d0Var) {
                if (d0Var instanceof DeviceWwidData) {
                    return l((DeviceWwidData) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            public b l(DeviceWwidData deviceWwidData) {
                if (deviceWwidData == DeviceWwidData.getDefaultInstance()) {
                    return this;
                }
                if (!deviceWwidData.getDeviceId().isEmpty()) {
                    this.f16000a = deviceWwidData.deviceId_;
                    onChanged();
                }
                if (deviceWwidData.deviceType_ != 0) {
                    p(deviceWwidData.getDeviceTypeValue());
                }
                if (!deviceWwidData.getModel().isEmpty()) {
                    this.f16002c = deviceWwidData.model_;
                    onChanged();
                }
                onChanged();
                return this;
            }

            /* renamed from: m */
            public final b mergeUnknownFields(a1 a1Var) {
                return this;
            }

            public b n(String str) {
                Objects.requireNonNull(str);
                this.f16000a = str;
                onChanged();
                return this;
            }

            public b o(ConstantProto.DeviceType deviceType) {
                Objects.requireNonNull(deviceType);
                this.f16001b = deviceType.getNumber();
                onChanged();
                return this;
            }

            public b p(int i10) {
                this.f16001b = i10;
                onChanged();
                return this;
            }

            /* renamed from: q */
            public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.setField(fieldDescriptor, obj);
            }

            public b r(String str) {
                Objects.requireNonNull(str);
                this.f16002c = str;
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
                this.f16000a = "";
                this.f16001b = 0;
                this.f16002c = "";
                maybeForceBuilderInitialization();
            }

            private b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.f16000a = "";
                this.f16001b = 0;
                this.f16002c = "";
                maybeForceBuilderInitialization();
            }
        }

        /* synthetic */ DeviceWwidData(i iVar, q qVar, a aVar) throws InvalidProtocolBufferException {
            this(iVar, qVar);
        }

        public static DeviceWwidData getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return DeviceInfoProto.f15963i;
        }

        public static b newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static DeviceWwidData parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (DeviceWwidData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static DeviceWwidData parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static l0<DeviceWwidData> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof DeviceWwidData)) {
                return super.equals(obj);
            }
            DeviceWwidData deviceWwidData = (DeviceWwidData) obj;
            return ((getDeviceId().equals(deviceWwidData.getDeviceId())) && this.deviceType_ == deviceWwidData.deviceType_) && getModel().equals(deviceWwidData.getModel());
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

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public l0<DeviceWwidData> getParserForType() {
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
            if (this.deviceType_ != ConstantProto.DeviceType.UNKNOWN_DEVICE_TYPE.getNumber()) {
                i11 += CodedOutputStream.l(2, this.deviceType_);
            }
            if (!getModelBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(3, this.model_);
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
            int hashCode = ((((((((((((((779 + getDescriptorForType().hashCode()) * 37) + 1) * 53) + getDeviceId().hashCode()) * 37) + 2) * 53) + this.deviceType_) * 37) + 3) * 53) + getModel().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return DeviceInfoProto.f15964j.e(DeviceWwidData.class, b.class);
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
            if (!getDeviceIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.deviceId_);
            }
            if (this.deviceType_ != ConstantProto.DeviceType.UNKNOWN_DEVICE_TYPE.getNumber()) {
                codedOutputStream.m0(2, this.deviceType_);
            }
            if (!getModelBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 3, this.model_);
            }
        }

        /* synthetic */ DeviceWwidData(GeneratedMessageV3.b bVar, a aVar) {
            this(bVar);
        }

        public static b newBuilder(DeviceWwidData deviceWwidData) {
            return DEFAULT_INSTANCE.toBuilder().l(deviceWwidData);
        }

        public static DeviceWwidData parseFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, qVar);
        }

        private DeviceWwidData(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static DeviceWwidData parseDelimitedFrom(InputStream inputStream, q qVar) throws IOException {
            return (DeviceWwidData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
        }

        public static DeviceWwidData parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
        public DeviceWwidData getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b toBuilder() {
            return this == DEFAULT_INSTANCE ? new b((a) null) : new b((a) null).l(this);
        }

        public static DeviceWwidData parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b newBuilderForType() {
            return newBuilder();
        }

        private DeviceWwidData() {
            this.memoizedIsInitialized = (byte) -1;
            this.deviceId_ = "";
            this.deviceType_ = 0;
            this.model_ = "";
        }

        public static DeviceWwidData parseFrom(InputStream inputStream) throws IOException {
            return (DeviceWwidData) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static DeviceWwidData parseFrom(InputStream inputStream, q qVar) throws IOException {
            return (DeviceWwidData) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
        }

        public static DeviceWwidData parseFrom(i iVar) throws IOException {
            return (DeviceWwidData) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
        }

        private DeviceWwidData(i iVar, q qVar) throws InvalidProtocolBufferException {
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
                            } else if (F == 16) {
                                this.deviceType_ = iVar.o();
                            } else if (F == 26) {
                                this.model_ = iVar.E();
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

        public static DeviceWwidData parseFrom(i iVar, q qVar) throws IOException {
            return (DeviceWwidData) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements Descriptors.FileDescriptor.a {
        a() {
        }

        @Override // com.google.protobuf.Descriptors.FileDescriptor.a
        public o assignDescriptors(Descriptors.FileDescriptor fileDescriptor) {
            Descriptors.FileDescriptor unused = DeviceInfoProto.f15967m = fileDescriptor;
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f16003a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f16004b;

        static {
            int[] iArr = new int[DeviceInfoResponse.TypeCase.values().length];
            f16004b = iArr;
            try {
                iArr[DeviceInfoResponse.TypeCase.DEVICE_INFO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f16004b[DeviceInfoResponse.TypeCase.TYPE_NOT_SET.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[DeviceInfoRequest.TypeCase.values().length];
            f16003a = iArr2;
            try {
                iArr2[DeviceInfoRequest.TypeCase.DEVICE_INFO.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f16003a[DeviceInfoRequest.TypeCase.TYPE_NOT_SET.ordinal()] = 2;
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

    static {
        Descriptors.FileDescriptor.q(new String[]{"\n\u001eticassistant/device_info.proto\u0012\u0013mobvoi.be.assistant\u001a\u0018becommon/constants.proto\"ð\u0001\n\nDeviceInfo\u0012\f\n\u0004wwid\u0018\u0001 \u0001(\t\u0012\u0011\n\tdevice_id\u0018\u0002 \u0001(\t\u00121\n\u000bdevice_type\u0018\u0003 \u0001(\u000e2\u001c.mobvoi.be.common.DeviceType\u0012\u0014\n\fversion_name\u0018\u0004 \u0001(\t\u0012\u0016\n\u000eversion_number\u0018\u0005 \u0001(\t\u0012\u000f\n\u0007channel\u0018\u0006 \u0001(\t\u0012\n\n\u0002os\u0018\u0007 \u0001(\t\u0012C\n\u0013device_address_info\u0018\b \u0001(\u000b2&.mobvoi.be.assistant.DeviceAddressInfo\"\u0083\u0001\n\u0011DeviceAddressInfo\u0012\u0014\n\fcountry_name\u0018\u0001 \u0001(\t\u0012\u0010\n\bprovince\u0018\u0002 \u0001(\t\u0012\f\n\u0004city\u0018\u0003 \u0001(\t\u0012\u0013", "\n\u000bsublocality\u0018\u0004 \u0001(\t\u0012\u0010\n\blatitude\u0018\u0005 \u0001(\u0001\u0012\u0011\n\tlongitude\u0018\u0006 \u0001(\u0001\"S\n\u0011DeviceInfoRequest\u00126\n\u000bdevice_info\u0018\u0001 \u0001(\u000b2\u001f.mobvoi.be.assistant.DeviceInfoH\u0000B\u0006\n\u0004type\"{\n\u0012DeviceInfoResponse\u0012\n\n\u0002ok\u0018\u0001 \u0001(\b\u0012\f\n\u0004code\u0018\u0002 \u0001(\u0005\u0012\u000b\n\u0003msg\u0018\u0003 \u0001(\t\u00126\n\u000bdevice_info\u0018\u0004 \u0001(\u000b2\u001f.mobvoi.be.assistant.DeviceInfoH\u0000B\u0006\n\u0004type\"e\n\u000eDeviceWwidData\u0012\u0011\n\tdevice_id\u0018\u0001 \u0001(\t\u00121\n\u000bdevice_type\u0018\u0002 \u0001(\u000e2\u001c.mobvoi.be.common.DeviceType\u0012\r\n\u0005model\u0018\u0003 \u0001(\t\"ÿ\u0001\n\u0012BindDataCollection\u0012\f\n\u0004wwid", "\u0018\u0001 \u0001(\t\u0012>\n\u0011device_wwid_datas\u0018\u0002 \u0003(\u000b2#.mobvoi.be.assistant.DeviceWwidData\u0012@\n\u0007channel\u0018\u0003 \u0001(\u000e2/.mobvoi.be.assistant.BindDataCollection.Channel\u0012\u0010\n\blatitude\u0018\u0004 \u0001(\u0001\u0012\u0011\n\tlongitude\u0018\u0005 \u0001(\u0001\u0012\u0011\n\tdevice_id\u0018\u0006 \u0001(\t\"!\n\u0007Channel\u0012\t\n\u0005CHINA\u0010\u0000\u0012\u000b\n\u0007OVERSEA\u0010\u0001B-\n\u001acom.mobvoi.be.ticassistantB\u000fDeviceInfoProtob\u0006proto3"}, new Descriptors.FileDescriptor[]{ConstantProto.t()}, new a());
        Descriptors.b bVar = n().j().get(0);
        f15955a = bVar;
        f15956b = new GeneratedMessageV3.e(bVar, new String[]{"Wwid", "DeviceId", "DeviceType", "VersionName", "VersionNumber", "Channel", "Os", "DeviceAddressInfo"});
        Descriptors.b bVar2 = n().j().get(1);
        f15957c = bVar2;
        f15958d = new GeneratedMessageV3.e(bVar2, new String[]{"CountryName", "Province", "City", "Sublocality", "Latitude", "Longitude"});
        Descriptors.b bVar3 = n().j().get(2);
        f15959e = bVar3;
        f15960f = new GeneratedMessageV3.e(bVar3, new String[]{"DeviceInfo", "Type"});
        Descriptors.b bVar4 = n().j().get(3);
        f15961g = bVar4;
        f15962h = new GeneratedMessageV3.e(bVar4, new String[]{"Ok", "Code", "Msg", "DeviceInfo", "Type"});
        Descriptors.b bVar5 = n().j().get(4);
        f15963i = bVar5;
        f15964j = new GeneratedMessageV3.e(bVar5, new String[]{"DeviceId", "DeviceType", "Model"});
        Descriptors.b bVar6 = n().j().get(5);
        f15965k = bVar6;
        f15966l = new GeneratedMessageV3.e(bVar6, new String[]{"Wwid", "DeviceWwidDatas", "Channel", "Latitude", "Longitude", "DeviceId"});
        ConstantProto.t();
    }

    public static Descriptors.FileDescriptor n() {
        return f15967m;
    }
}
