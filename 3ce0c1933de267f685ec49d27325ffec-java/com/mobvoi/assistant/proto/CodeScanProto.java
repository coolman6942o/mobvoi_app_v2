package com.mobvoi.assistant.proto;

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
public final class CodeScanProto {
    private static Descriptors.FileDescriptor descriptor;
    private static final Descriptors.b internal_static_com_mobvoi_assistant_proto_CodeScanResp_descriptor;
    private static final GeneratedMessageV3.e internal_static_com_mobvoi_assistant_proto_CodeScanResp_fieldAccessorTable;
    private static final Descriptors.b internal_static_com_mobvoi_assistant_proto_RandCodeTokenReq_descriptor;
    private static final GeneratedMessageV3.e internal_static_com_mobvoi_assistant_proto_RandCodeTokenReq_fieldAccessorTable;
    private static final Descriptors.b internal_static_com_mobvoi_assistant_proto_ScanUrlData_descriptor;
    private static final GeneratedMessageV3.e internal_static_com_mobvoi_assistant_proto_ScanUrlData_fieldAccessorTable;
    private static final Descriptors.b internal_static_com_mobvoi_assistant_proto_TokenInfo_descriptor;
    private static final GeneratedMessageV3.e internal_static_com_mobvoi_assistant_proto_TokenInfo_fieldAccessorTable;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mobvoi.assistant.proto.CodeScanProto$2  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$mobvoi$assistant$proto$CodeScanProto$CodeScanResp$RespCase;

        static {
            int[] iArr = new int[CodeScanResp.RespCase.values().length];
            $SwitchMap$com$mobvoi$assistant$proto$CodeScanProto$CodeScanResp$RespCase = iArr;
            try {
                iArr[CodeScanResp.RespCase.SCAN_URL_DATA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$mobvoi$assistant$proto$CodeScanProto$CodeScanResp$RespCase[CodeScanResp.RespCase.TOKEN_INFO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$mobvoi$assistant$proto$CodeScanProto$CodeScanResp$RespCase[CodeScanResp.RespCase.RESP_NOT_SET.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class CodeScanResp extends GeneratedMessageV3 implements CodeScanRespOrBuilder {
        public static final int ERR_CODE_FIELD_NUMBER = 1;
        public static final int ERR_MSG_FIELD_NUMBER = 2;
        public static final int SCAN_URL_DATA_FIELD_NUMBER = 3;
        public static final int TOKEN_INFO_FIELD_NUMBER = 4;
        private static final long serialVersionUID = 0;
        private int errCode_;
        private volatile Object errMsg_;
        private byte memoizedIsInitialized;
        private int respCase_;
        private Object resp_;
        private static final CodeScanResp DEFAULT_INSTANCE = new CodeScanResp();
        private static final l0<CodeScanResp> PARSER = new c<CodeScanResp>() { // from class: com.mobvoi.assistant.proto.CodeScanProto.CodeScanResp.1
            @Override // com.google.protobuf.l0
            public CodeScanResp parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
                return new CodeScanResp(iVar, qVar);
            }
        };

        /* loaded from: classes2.dex */
        public enum RespCase implements u.a {
            SCAN_URL_DATA(3),
            TOKEN_INFO(4),
            RESP_NOT_SET(0);
            
            private final int value;

            RespCase(int i10) {
                this.value = i10;
            }

            public static RespCase forNumber(int i10) {
                if (i10 == 0) {
                    return RESP_NOT_SET;
                }
                if (i10 == 3) {
                    return SCAN_URL_DATA;
                }
                if (i10 != 4) {
                    return null;
                }
                return TOKEN_INFO;
            }

            @Override // com.google.protobuf.u.a
            public int getNumber() {
                return this.value;
            }

            @Deprecated
            public static RespCase valueOf(int i10) {
                return forNumber(i10);
            }
        }

        public static CodeScanResp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return CodeScanProto.internal_static_com_mobvoi_assistant_proto_CodeScanResp_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static CodeScanResp parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (CodeScanResp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static CodeScanResp parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static l0<CodeScanResp> parser() {
            return PARSER;
        }

        /* JADX WARN: Code restructure failed: missing block: B:31:0x005d, code lost:
            if (getTokenInfo().equals(r6.getTokenInfo()) != false) goto L36;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x006e, code lost:
            if (getScanUrlData().equals(r6.getScanUrlData()) != false) goto L36;
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
            if (!(obj instanceof CodeScanResp)) {
                return super.equals(obj);
            }
            CodeScanResp codeScanResp = (CodeScanResp) obj;
            boolean z11 = ((getErrCode() == codeScanResp.getErrCode()) && getErrMsg().equals(codeScanResp.getErrMsg())) && getRespCase().equals(codeScanResp.getRespCase());
            if (!z11) {
                return false;
            }
            int i10 = this.respCase_;
            if (i10 == 3) {
                if (z11) {
                }
                z10 = false;
                return z10;
            } else if (i10 != 4) {
                return z11;
            } else {
                if (z11) {
                }
                z10 = false;
                return z10;
            }
        }

        @Override // com.mobvoi.assistant.proto.CodeScanProto.CodeScanRespOrBuilder
        public int getErrCode() {
            return this.errCode_;
        }

        @Override // com.mobvoi.assistant.proto.CodeScanProto.CodeScanRespOrBuilder
        public String getErrMsg() {
            Object obj = this.errMsg_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.errMsg_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.assistant.proto.CodeScanProto.CodeScanRespOrBuilder
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
        public l0<CodeScanResp> getParserForType() {
            return PARSER;
        }

        @Override // com.mobvoi.assistant.proto.CodeScanProto.CodeScanRespOrBuilder
        public RespCase getRespCase() {
            return RespCase.forNumber(this.respCase_);
        }

        @Override // com.mobvoi.assistant.proto.CodeScanProto.CodeScanRespOrBuilder
        public ScanUrlData getScanUrlData() {
            if (this.respCase_ == 3) {
                return (ScanUrlData) this.resp_;
            }
            return ScanUrlData.getDefaultInstance();
        }

        @Override // com.mobvoi.assistant.proto.CodeScanProto.CodeScanRespOrBuilder
        public ScanUrlDataOrBuilder getScanUrlDataOrBuilder() {
            if (this.respCase_ == 3) {
                return (ScanUrlData) this.resp_;
            }
            return ScanUrlData.getDefaultInstance();
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
            if (this.respCase_ == 3) {
                i11 += CodedOutputStream.E(3, (ScanUrlData) this.resp_);
            }
            if (this.respCase_ == 4) {
                i11 += CodedOutputStream.E(4, (TokenInfo) this.resp_);
            }
            this.memoizedSize = i11;
            return i11;
        }

        @Override // com.mobvoi.assistant.proto.CodeScanProto.CodeScanRespOrBuilder
        public TokenInfo getTokenInfo() {
            if (this.respCase_ == 4) {
                return (TokenInfo) this.resp_;
            }
            return TokenInfo.getDefaultInstance();
        }

        @Override // com.mobvoi.assistant.proto.CodeScanProto.CodeScanRespOrBuilder
        public TokenInfoOrBuilder getTokenInfoOrBuilder() {
            if (this.respCase_ == 4) {
                return (TokenInfo) this.resp_;
            }
            return TokenInfo.getDefaultInstance();
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
            int i13 = this.respCase_;
            if (i13 != 3) {
                if (i13 == 4) {
                    i11 = ((hashCode * 37) + 4) * 53;
                    i10 = getTokenInfo().hashCode();
                }
                int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
                this.memoizedHashCode = hashCode2;
                return hashCode2;
            }
            i11 = ((hashCode * 37) + 3) * 53;
            i10 = getScanUrlData().hashCode();
            hashCode = i11 + i10;
            int hashCode22 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode22;
            return hashCode22;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return CodeScanProto.internal_static_com_mobvoi_assistant_proto_CodeScanResp_fieldAccessorTable.e(CodeScanResp.class, Builder.class);
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
            if (this.respCase_ == 3) {
                codedOutputStream.A0(3, (ScanUrlData) this.resp_);
            }
            if (this.respCase_ == 4) {
                codedOutputStream.A0(4, (TokenInfo) this.resp_);
            }
        }

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageV3.b<Builder> implements CodeScanRespOrBuilder {
            private int errCode_;
            private Object errMsg_;
            private int respCase_;
            private Object resp_;
            private q0<ScanUrlData, ScanUrlData.Builder, ScanUrlDataOrBuilder> scanUrlDataBuilder_;
            private q0<TokenInfo, TokenInfo.Builder, TokenInfoOrBuilder> tokenInfoBuilder_;

            public static final Descriptors.b getDescriptor() {
                return CodeScanProto.internal_static_com_mobvoi_assistant_proto_CodeScanResp_descriptor;
            }

            private q0<ScanUrlData, ScanUrlData.Builder, ScanUrlDataOrBuilder> getScanUrlDataFieldBuilder() {
                if (this.scanUrlDataBuilder_ == null) {
                    if (this.respCase_ != 3) {
                        this.resp_ = ScanUrlData.getDefaultInstance();
                    }
                    this.scanUrlDataBuilder_ = new q0<>((ScanUrlData) this.resp_, getParentForChildren(), isClean());
                    this.resp_ = null;
                }
                this.respCase_ = 3;
                onChanged();
                return this.scanUrlDataBuilder_;
            }

            private q0<TokenInfo, TokenInfo.Builder, TokenInfoOrBuilder> getTokenInfoFieldBuilder() {
                if (this.tokenInfoBuilder_ == null) {
                    if (this.respCase_ != 4) {
                        this.resp_ = TokenInfo.getDefaultInstance();
                    }
                    this.tokenInfoBuilder_ = new q0<>((TokenInfo) this.resp_, getParentForChildren(), isClean());
                    this.resp_ = null;
                }
                this.respCase_ = 4;
                onChanged();
                return this.tokenInfoBuilder_;
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
                this.errMsg_ = CodeScanResp.getDefaultInstance().getErrMsg();
                onChanged();
                return this;
            }

            public Builder clearResp() {
                this.respCase_ = 0;
                this.resp_ = null;
                onChanged();
                return this;
            }

            public Builder clearScanUrlData() {
                q0<ScanUrlData, ScanUrlData.Builder, ScanUrlDataOrBuilder> q0Var = this.scanUrlDataBuilder_;
                if (q0Var != null) {
                    if (this.respCase_ == 3) {
                        this.respCase_ = 0;
                        this.resp_ = null;
                    }
                    q0Var.c();
                } else if (this.respCase_ == 3) {
                    this.respCase_ = 0;
                    this.resp_ = null;
                    onChanged();
                }
                return this;
            }

            public Builder clearTokenInfo() {
                q0<TokenInfo, TokenInfo.Builder, TokenInfoOrBuilder> q0Var = this.tokenInfoBuilder_;
                if (q0Var != null) {
                    if (this.respCase_ == 4) {
                        this.respCase_ = 0;
                        this.resp_ = null;
                    }
                    q0Var.c();
                } else if (this.respCase_ == 4) {
                    this.respCase_ = 0;
                    this.resp_ = null;
                    onChanged();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a, com.google.protobuf.g0
            public Descriptors.b getDescriptorForType() {
                return CodeScanProto.internal_static_com_mobvoi_assistant_proto_CodeScanResp_descriptor;
            }

            @Override // com.mobvoi.assistant.proto.CodeScanProto.CodeScanRespOrBuilder
            public int getErrCode() {
                return this.errCode_;
            }

            @Override // com.mobvoi.assistant.proto.CodeScanProto.CodeScanRespOrBuilder
            public String getErrMsg() {
                Object obj = this.errMsg_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.errMsg_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.assistant.proto.CodeScanProto.CodeScanRespOrBuilder
            public ByteString getErrMsgBytes() {
                Object obj = this.errMsg_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.errMsg_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.mobvoi.assistant.proto.CodeScanProto.CodeScanRespOrBuilder
            public RespCase getRespCase() {
                return RespCase.forNumber(this.respCase_);
            }

            @Override // com.mobvoi.assistant.proto.CodeScanProto.CodeScanRespOrBuilder
            public ScanUrlData getScanUrlData() {
                q0<ScanUrlData, ScanUrlData.Builder, ScanUrlDataOrBuilder> q0Var = this.scanUrlDataBuilder_;
                if (q0Var == null) {
                    if (this.respCase_ == 3) {
                        return (ScanUrlData) this.resp_;
                    }
                    return ScanUrlData.getDefaultInstance();
                } else if (this.respCase_ == 3) {
                    return q0Var.f();
                } else {
                    return ScanUrlData.getDefaultInstance();
                }
            }

            public ScanUrlData.Builder getScanUrlDataBuilder() {
                return getScanUrlDataFieldBuilder().e();
            }

            @Override // com.mobvoi.assistant.proto.CodeScanProto.CodeScanRespOrBuilder
            public ScanUrlDataOrBuilder getScanUrlDataOrBuilder() {
                q0<ScanUrlData, ScanUrlData.Builder, ScanUrlDataOrBuilder> q0Var;
                int i10 = this.respCase_;
                if (i10 == 3 && (q0Var = this.scanUrlDataBuilder_) != null) {
                    return q0Var.g();
                }
                if (i10 == 3) {
                    return (ScanUrlData) this.resp_;
                }
                return ScanUrlData.getDefaultInstance();
            }

            @Override // com.mobvoi.assistant.proto.CodeScanProto.CodeScanRespOrBuilder
            public TokenInfo getTokenInfo() {
                q0<TokenInfo, TokenInfo.Builder, TokenInfoOrBuilder> q0Var = this.tokenInfoBuilder_;
                if (q0Var == null) {
                    if (this.respCase_ == 4) {
                        return (TokenInfo) this.resp_;
                    }
                    return TokenInfo.getDefaultInstance();
                } else if (this.respCase_ == 4) {
                    return q0Var.f();
                } else {
                    return TokenInfo.getDefaultInstance();
                }
            }

            public TokenInfo.Builder getTokenInfoBuilder() {
                return getTokenInfoFieldBuilder().e();
            }

            @Override // com.mobvoi.assistant.proto.CodeScanProto.CodeScanRespOrBuilder
            public TokenInfoOrBuilder getTokenInfoOrBuilder() {
                q0<TokenInfo, TokenInfo.Builder, TokenInfoOrBuilder> q0Var;
                int i10 = this.respCase_;
                if (i10 == 4 && (q0Var = this.tokenInfoBuilder_) != null) {
                    return q0Var.g();
                }
                if (i10 == 4) {
                    return (TokenInfo) this.resp_;
                }
                return TokenInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return CodeScanProto.internal_static_com_mobvoi_assistant_proto_CodeScanResp_fieldAccessorTable.e(CodeScanResp.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.f0
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeScanUrlData(ScanUrlData scanUrlData) {
                q0<ScanUrlData, ScanUrlData.Builder, ScanUrlDataOrBuilder> q0Var = this.scanUrlDataBuilder_;
                if (q0Var == null) {
                    if (this.respCase_ != 3 || this.resp_ == ScanUrlData.getDefaultInstance()) {
                        this.resp_ = scanUrlData;
                    } else {
                        this.resp_ = ScanUrlData.newBuilder((ScanUrlData) this.resp_).mergeFrom(scanUrlData).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.respCase_ == 3) {
                        q0Var.h(scanUrlData);
                    }
                    this.scanUrlDataBuilder_.j(scanUrlData);
                }
                this.respCase_ = 3;
                return this;
            }

            public Builder mergeTokenInfo(TokenInfo tokenInfo) {
                q0<TokenInfo, TokenInfo.Builder, TokenInfoOrBuilder> q0Var = this.tokenInfoBuilder_;
                if (q0Var == null) {
                    if (this.respCase_ != 4 || this.resp_ == TokenInfo.getDefaultInstance()) {
                        this.resp_ = tokenInfo;
                    } else {
                        this.resp_ = TokenInfo.newBuilder((TokenInfo) this.resp_).mergeFrom(tokenInfo).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.respCase_ == 4) {
                        q0Var.h(tokenInfo);
                    }
                    this.tokenInfoBuilder_.j(tokenInfo);
                }
                this.respCase_ = 4;
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

            public Builder setScanUrlData(ScanUrlData scanUrlData) {
                q0<ScanUrlData, ScanUrlData.Builder, ScanUrlDataOrBuilder> q0Var = this.scanUrlDataBuilder_;
                if (q0Var == null) {
                    Objects.requireNonNull(scanUrlData);
                    this.resp_ = scanUrlData;
                    onChanged();
                } else {
                    q0Var.j(scanUrlData);
                }
                this.respCase_ = 3;
                return this;
            }

            public Builder setTokenInfo(TokenInfo tokenInfo) {
                q0<TokenInfo, TokenInfo.Builder, TokenInfoOrBuilder> q0Var = this.tokenInfoBuilder_;
                if (q0Var == null) {
                    Objects.requireNonNull(tokenInfo);
                    this.resp_ = tokenInfo;
                    onChanged();
                } else {
                    q0Var.j(tokenInfo);
                }
                this.respCase_ = 4;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public final Builder setUnknownFields(a1 a1Var) {
                return this;
            }

            private Builder() {
                this.respCase_ = 0;
                this.errMsg_ = "";
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.e0.a, com.google.protobuf.d0.a
            public CodeScanResp build() {
                CodeScanResp buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) buildPartial);
            }

            @Override // com.google.protobuf.e0.a, com.google.protobuf.d0.a
            public CodeScanResp buildPartial() {
                CodeScanResp codeScanResp = new CodeScanResp(this);
                codeScanResp.errCode_ = this.errCode_;
                codeScanResp.errMsg_ = this.errMsg_;
                if (this.respCase_ == 3) {
                    q0<ScanUrlData, ScanUrlData.Builder, ScanUrlDataOrBuilder> q0Var = this.scanUrlDataBuilder_;
                    if (q0Var == null) {
                        codeScanResp.resp_ = this.resp_;
                    } else {
                        codeScanResp.resp_ = q0Var.b();
                    }
                }
                if (this.respCase_ == 4) {
                    q0<TokenInfo, TokenInfo.Builder, TokenInfoOrBuilder> q0Var2 = this.tokenInfoBuilder_;
                    if (q0Var2 == null) {
                        codeScanResp.resp_ = this.resp_;
                    } else {
                        codeScanResp.resp_ = q0Var2.b();
                    }
                }
                codeScanResp.respCase_ = this.respCase_;
                onBuilt();
                return codeScanResp;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.f0, com.google.protobuf.g0
            public CodeScanResp getDefaultInstanceForType() {
                return CodeScanResp.getDefaultInstance();
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
                this.respCase_ = 0;
                this.resp_ = null;
                return this;
            }

            private Builder(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.respCase_ = 0;
                this.errMsg_ = "";
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a, com.google.protobuf.b.a
            public Builder clone() {
                return (Builder) super.clone();
            }

            @Override // com.google.protobuf.a.AbstractC0170a, com.google.protobuf.d0.a
            public Builder mergeFrom(d0 d0Var) {
                if (d0Var instanceof CodeScanResp) {
                    return mergeFrom((CodeScanResp) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            public Builder setScanUrlData(ScanUrlData.Builder builder) {
                q0<ScanUrlData, ScanUrlData.Builder, ScanUrlDataOrBuilder> q0Var = this.scanUrlDataBuilder_;
                if (q0Var == null) {
                    this.resp_ = builder.build();
                    onChanged();
                } else {
                    q0Var.j(builder.build());
                }
                this.respCase_ = 3;
                return this;
            }

            public Builder setTokenInfo(TokenInfo.Builder builder) {
                q0<TokenInfo, TokenInfo.Builder, TokenInfoOrBuilder> q0Var = this.tokenInfoBuilder_;
                if (q0Var == null) {
                    this.resp_ = builder.build();
                    onChanged();
                } else {
                    q0Var.j(builder.build());
                }
                this.respCase_ = 4;
                return this;
            }

            public Builder mergeFrom(CodeScanResp codeScanResp) {
                if (codeScanResp == CodeScanResp.getDefaultInstance()) {
                    return this;
                }
                if (codeScanResp.getErrCode() != 0) {
                    setErrCode(codeScanResp.getErrCode());
                }
                if (!codeScanResp.getErrMsg().isEmpty()) {
                    this.errMsg_ = codeScanResp.errMsg_;
                    onChanged();
                }
                int i10 = AnonymousClass2.$SwitchMap$com$mobvoi$assistant$proto$CodeScanProto$CodeScanResp$RespCase[codeScanResp.getRespCase().ordinal()];
                if (i10 == 1) {
                    mergeScanUrlData(codeScanResp.getScanUrlData());
                } else if (i10 == 2) {
                    mergeTokenInfo(codeScanResp.getTokenInfo());
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
                CodeScanResp codeScanResp = null;
                try {
                    try {
                        CodeScanResp codeScanResp2 = (CodeScanResp) CodeScanResp.PARSER.parsePartialFrom(iVar, qVar);
                        if (codeScanResp2 != null) {
                            mergeFrom(codeScanResp2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e10) {
                        codeScanResp = (CodeScanResp) e10.getUnfinishedMessage();
                        try {
                            throw e10.unwrapIOException();
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (codeScanResp != null) {
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (codeScanResp != null) {
                        mergeFrom(codeScanResp);
                    }
                    throw th2;
                }
            }
        }

        public static Builder newBuilder(CodeScanResp codeScanResp) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(codeScanResp);
        }

        public static CodeScanResp parseFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, qVar);
        }

        private CodeScanResp(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.respCase_ = 0;
            this.memoizedIsInitialized = (byte) -1;
        }

        public static CodeScanResp parseDelimitedFrom(InputStream inputStream, q qVar) throws IOException {
            return (CodeScanResp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
        }

        public static CodeScanResp parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
        public CodeScanResp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static CodeScanResp parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static CodeScanResp parseFrom(InputStream inputStream) throws IOException {
            return (CodeScanResp) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.c cVar) {
            return new Builder(cVar);
        }

        private CodeScanResp() {
            this.respCase_ = 0;
            this.memoizedIsInitialized = (byte) -1;
            this.errCode_ = 0;
            this.errMsg_ = "";
        }

        public static CodeScanResp parseFrom(InputStream inputStream, q qVar) throws IOException {
            return (CodeScanResp) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
        }

        public static CodeScanResp parseFrom(i iVar) throws IOException {
            return (CodeScanResp) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
        }

        private CodeScanResp(i iVar, q qVar) throws InvalidProtocolBufferException {
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
                                } else if (F != 18) {
                                    TokenInfo.Builder builder = null;
                                    ScanUrlData.Builder builder2 = null;
                                    if (F == 26) {
                                        builder2 = this.respCase_ == 3 ? ((ScanUrlData) this.resp_).toBuilder() : builder2;
                                        e0 v10 = iVar.v(ScanUrlData.parser(), qVar);
                                        this.resp_ = v10;
                                        if (builder2 != null) {
                                            builder2.mergeFrom((ScanUrlData) v10);
                                            this.resp_ = builder2.buildPartial();
                                        }
                                        this.respCase_ = 3;
                                    } else if (F == 34) {
                                        builder = this.respCase_ == 4 ? ((TokenInfo) this.resp_).toBuilder() : builder;
                                        e0 v11 = iVar.v(TokenInfo.parser(), qVar);
                                        this.resp_ = v11;
                                        if (builder != null) {
                                            builder.mergeFrom((TokenInfo) v11);
                                            this.resp_ = builder.buildPartial();
                                        }
                                        this.respCase_ = 4;
                                    } else if (!iVar.I(F)) {
                                    }
                                } else {
                                    this.errMsg_ = iVar.E();
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

        public static CodeScanResp parseFrom(i iVar, q qVar) throws IOException {
            return (CodeScanResp) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
        }
    }

    /* loaded from: classes2.dex */
    public interface CodeScanRespOrBuilder extends g0 {
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

        CodeScanResp.RespCase getRespCase();

        ScanUrlData getScanUrlData();

        ScanUrlDataOrBuilder getScanUrlDataOrBuilder();

        TokenInfo getTokenInfo();

        TokenInfoOrBuilder getTokenInfoOrBuilder();

        @Override // com.google.protobuf.g0
        /* synthetic */ a1 getUnknownFields();

        @Override // com.google.protobuf.g0
        /* synthetic */ boolean hasField(Descriptors.FieldDescriptor fieldDescriptor);

        /* synthetic */ boolean hasOneof(Descriptors.h hVar);

        @Override // com.google.protobuf.f0
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes2.dex */
    public static final class RandCodeTokenReq extends GeneratedMessageV3 implements RandCodeTokenReqOrBuilder {
        public static final int APP_FIELD_NUMBER = 3;
        private static final RandCodeTokenReq DEFAULT_INSTANCE = new RandCodeTokenReq();
        private static final l0<RandCodeTokenReq> PARSER = new c<RandCodeTokenReq>() { // from class: com.mobvoi.assistant.proto.CodeScanProto.RandCodeTokenReq.1
            @Override // com.google.protobuf.l0
            public RandCodeTokenReq parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
                return new RandCodeTokenReq(iVar, qVar);
            }
        };
        public static final int RAND_CODE_FIELD_NUMBER = 1;
        public static final int TOKEN_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private volatile Object app_;
        private byte memoizedIsInitialized;
        private volatile Object randCode_;
        private volatile Object token_;

        public static RandCodeTokenReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return CodeScanProto.internal_static_com_mobvoi_assistant_proto_RandCodeTokenReq_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static RandCodeTokenReq parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (RandCodeTokenReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static RandCodeTokenReq parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static l0<RandCodeTokenReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof RandCodeTokenReq)) {
                return super.equals(obj);
            }
            RandCodeTokenReq randCodeTokenReq = (RandCodeTokenReq) obj;
            return ((getRandCode().equals(randCodeTokenReq.getRandCode())) && getToken().equals(randCodeTokenReq.getToken())) && getApp().equals(randCodeTokenReq.getApp());
        }

        @Override // com.mobvoi.assistant.proto.CodeScanProto.RandCodeTokenReqOrBuilder
        public String getApp() {
            Object obj = this.app_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.app_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.assistant.proto.CodeScanProto.RandCodeTokenReqOrBuilder
        public ByteString getAppBytes() {
            Object obj = this.app_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.app_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public l0<RandCodeTokenReq> getParserForType() {
            return PARSER;
        }

        @Override // com.mobvoi.assistant.proto.CodeScanProto.RandCodeTokenReqOrBuilder
        public String getRandCode() {
            Object obj = this.randCode_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.randCode_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.assistant.proto.CodeScanProto.RandCodeTokenReqOrBuilder
        public ByteString getRandCodeBytes() {
            Object obj = this.randCode_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.randCode_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
        public int getSerializedSize() {
            int i10 = this.memoizedSize;
            if (i10 != -1) {
                return i10;
            }
            int i11 = 0;
            if (!getRandCodeBytes().isEmpty()) {
                i11 = 0 + GeneratedMessageV3.computeStringSize(1, this.randCode_);
            }
            if (!getTokenBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(2, this.token_);
            }
            if (!getAppBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(3, this.app_);
            }
            this.memoizedSize = i11;
            return i11;
        }

        @Override // com.mobvoi.assistant.proto.CodeScanProto.RandCodeTokenReqOrBuilder
        public String getToken() {
            Object obj = this.token_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.token_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.assistant.proto.CodeScanProto.RandCodeTokenReqOrBuilder
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

        @Override // com.google.protobuf.a
        public int hashCode() {
            int i10 = this.memoizedHashCode;
            if (i10 != 0) {
                return i10;
            }
            int hashCode = ((((((((((((((779 + getDescriptorForType().hashCode()) * 37) + 1) * 53) + getRandCode().hashCode()) * 37) + 2) * 53) + getToken().hashCode()) * 37) + 3) * 53) + getApp().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return CodeScanProto.internal_static_com_mobvoi_assistant_proto_RandCodeTokenReq_fieldAccessorTable.e(RandCodeTokenReq.class, Builder.class);
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
            if (!getRandCodeBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.randCode_);
            }
            if (!getTokenBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.token_);
            }
            if (!getAppBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 3, this.app_);
            }
        }

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageV3.b<Builder> implements RandCodeTokenReqOrBuilder {
            private Object app_;
            private Object randCode_;
            private Object token_;

            public static final Descriptors.b getDescriptor() {
                return CodeScanProto.internal_static_com_mobvoi_assistant_proto_RandCodeTokenReq_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            public Builder clearApp() {
                this.app_ = RandCodeTokenReq.getDefaultInstance().getApp();
                onChanged();
                return this;
            }

            public Builder clearRandCode() {
                this.randCode_ = RandCodeTokenReq.getDefaultInstance().getRandCode();
                onChanged();
                return this;
            }

            public Builder clearToken() {
                this.token_ = RandCodeTokenReq.getDefaultInstance().getToken();
                onChanged();
                return this;
            }

            @Override // com.mobvoi.assistant.proto.CodeScanProto.RandCodeTokenReqOrBuilder
            public String getApp() {
                Object obj = this.app_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.app_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.assistant.proto.CodeScanProto.RandCodeTokenReqOrBuilder
            public ByteString getAppBytes() {
                Object obj = this.app_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.app_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a, com.google.protobuf.g0
            public Descriptors.b getDescriptorForType() {
                return CodeScanProto.internal_static_com_mobvoi_assistant_proto_RandCodeTokenReq_descriptor;
            }

            @Override // com.mobvoi.assistant.proto.CodeScanProto.RandCodeTokenReqOrBuilder
            public String getRandCode() {
                Object obj = this.randCode_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.randCode_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.assistant.proto.CodeScanProto.RandCodeTokenReqOrBuilder
            public ByteString getRandCodeBytes() {
                Object obj = this.randCode_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.randCode_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.mobvoi.assistant.proto.CodeScanProto.RandCodeTokenReqOrBuilder
            public String getToken() {
                Object obj = this.token_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.token_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.assistant.proto.CodeScanProto.RandCodeTokenReqOrBuilder
            public ByteString getTokenBytes() {
                Object obj = this.token_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.token_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return CodeScanProto.internal_static_com_mobvoi_assistant_proto_RandCodeTokenReq_fieldAccessorTable.e(RandCodeTokenReq.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.f0
            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a
            public final Builder mergeUnknownFields(a1 a1Var) {
                return this;
            }

            public Builder setApp(String str) {
                Objects.requireNonNull(str);
                this.app_ = str;
                onChanged();
                return this;
            }

            public Builder setAppBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                b.checkByteStringIsUtf8(byteString);
                this.app_ = byteString;
                onChanged();
                return this;
            }

            public Builder setRandCode(String str) {
                Objects.requireNonNull(str);
                this.randCode_ = str;
                onChanged();
                return this;
            }

            public Builder setRandCodeBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                b.checkByteStringIsUtf8(byteString);
                this.randCode_ = byteString;
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
                this.randCode_ = "";
                this.token_ = "";
                this.app_ = "";
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.e0.a, com.google.protobuf.d0.a
            public RandCodeTokenReq build() {
                RandCodeTokenReq buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) buildPartial);
            }

            @Override // com.google.protobuf.e0.a, com.google.protobuf.d0.a
            public RandCodeTokenReq buildPartial() {
                RandCodeTokenReq randCodeTokenReq = new RandCodeTokenReq(this);
                randCodeTokenReq.randCode_ = this.randCode_;
                randCodeTokenReq.token_ = this.token_;
                randCodeTokenReq.app_ = this.app_;
                onBuilt();
                return randCodeTokenReq;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.f0, com.google.protobuf.g0
            public RandCodeTokenReq getDefaultInstanceForType() {
                return RandCodeTokenReq.getDefaultInstance();
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
                this.randCode_ = "";
                this.token_ = "";
                this.app_ = "";
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a, com.google.protobuf.b.a
            public Builder clone() {
                return (Builder) super.clone();
            }

            @Override // com.google.protobuf.a.AbstractC0170a, com.google.protobuf.d0.a
            public Builder mergeFrom(d0 d0Var) {
                if (d0Var instanceof RandCodeTokenReq) {
                    return mergeFrom((RandCodeTokenReq) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            private Builder(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.randCode_ = "";
                this.token_ = "";
                this.app_ = "";
                maybeForceBuilderInitialization();
            }

            public Builder mergeFrom(RandCodeTokenReq randCodeTokenReq) {
                if (randCodeTokenReq == RandCodeTokenReq.getDefaultInstance()) {
                    return this;
                }
                if (!randCodeTokenReq.getRandCode().isEmpty()) {
                    this.randCode_ = randCodeTokenReq.randCode_;
                    onChanged();
                }
                if (!randCodeTokenReq.getToken().isEmpty()) {
                    this.token_ = randCodeTokenReq.token_;
                    onChanged();
                }
                if (!randCodeTokenReq.getApp().isEmpty()) {
                    this.app_ = randCodeTokenReq.app_;
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
                RandCodeTokenReq randCodeTokenReq = null;
                try {
                    try {
                        RandCodeTokenReq randCodeTokenReq2 = (RandCodeTokenReq) RandCodeTokenReq.PARSER.parsePartialFrom(iVar, qVar);
                        if (randCodeTokenReq2 != null) {
                            mergeFrom(randCodeTokenReq2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e10) {
                        randCodeTokenReq = (RandCodeTokenReq) e10.getUnfinishedMessage();
                        try {
                            throw e10.unwrapIOException();
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (randCodeTokenReq != null) {
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (randCodeTokenReq != null) {
                        mergeFrom(randCodeTokenReq);
                    }
                    throw th2;
                }
            }
        }

        public static Builder newBuilder(RandCodeTokenReq randCodeTokenReq) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(randCodeTokenReq);
        }

        public static RandCodeTokenReq parseFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, qVar);
        }

        private RandCodeTokenReq(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static RandCodeTokenReq parseDelimitedFrom(InputStream inputStream, q qVar) throws IOException {
            return (RandCodeTokenReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
        }

        public static RandCodeTokenReq parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
        public RandCodeTokenReq getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static RandCodeTokenReq parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder newBuilderForType() {
            return newBuilder();
        }

        private RandCodeTokenReq() {
            this.memoizedIsInitialized = (byte) -1;
            this.randCode_ = "";
            this.token_ = "";
            this.app_ = "";
        }

        public static RandCodeTokenReq parseFrom(InputStream inputStream) throws IOException {
            return (RandCodeTokenReq) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.c cVar) {
            return new Builder(cVar);
        }

        public static RandCodeTokenReq parseFrom(InputStream inputStream, q qVar) throws IOException {
            return (RandCodeTokenReq) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
        }

        public static RandCodeTokenReq parseFrom(i iVar) throws IOException {
            return (RandCodeTokenReq) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
        }

        private RandCodeTokenReq(i iVar, q qVar) throws InvalidProtocolBufferException {
            this();
            boolean z10 = false;
            while (!z10) {
                try {
                    try {
                        int F = iVar.F();
                        z10 = true;
                        if (F != 0) {
                            if (F == 10) {
                                this.randCode_ = iVar.E();
                            } else if (F == 18) {
                                this.token_ = iVar.E();
                            } else if (F == 26) {
                                this.app_ = iVar.E();
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

        public static RandCodeTokenReq parseFrom(i iVar, q qVar) throws IOException {
            return (RandCodeTokenReq) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
        }
    }

    /* loaded from: classes2.dex */
    public interface RandCodeTokenReqOrBuilder extends g0 {
        /* synthetic */ List<String> findInitializationErrors();

        @Override // com.google.protobuf.g0
        /* synthetic */ Map<Descriptors.FieldDescriptor, Object> getAllFields();

        String getApp();

        ByteString getAppBytes();

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

        String getRandCode();

        ByteString getRandCodeBytes();

        /* synthetic */ Object getRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i10);

        /* synthetic */ int getRepeatedFieldCount(Descriptors.FieldDescriptor fieldDescriptor);

        String getToken();

        ByteString getTokenBytes();

        @Override // com.google.protobuf.g0
        /* synthetic */ a1 getUnknownFields();

        @Override // com.google.protobuf.g0
        /* synthetic */ boolean hasField(Descriptors.FieldDescriptor fieldDescriptor);

        /* synthetic */ boolean hasOneof(Descriptors.h hVar);

        @Override // com.google.protobuf.f0
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes2.dex */
    public static final class ScanUrlData extends GeneratedMessageV3 implements ScanUrlDataOrBuilder {
        private static final ScanUrlData DEFAULT_INSTANCE = new ScanUrlData();
        private static final l0<ScanUrlData> PARSER = new c<ScanUrlData>() { // from class: com.mobvoi.assistant.proto.CodeScanProto.ScanUrlData.1
            @Override // com.google.protobuf.l0
            public ScanUrlData parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
                return new ScanUrlData(iVar, qVar);
            }
        };
        public static final int RAND_CODE_FIELD_NUMBER = 2;
        public static final int URL_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private byte memoizedIsInitialized;
        private volatile Object randCode_;
        private volatile Object url_;

        public static ScanUrlData getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return CodeScanProto.internal_static_com_mobvoi_assistant_proto_ScanUrlData_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static ScanUrlData parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ScanUrlData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static ScanUrlData parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static l0<ScanUrlData> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ScanUrlData)) {
                return super.equals(obj);
            }
            ScanUrlData scanUrlData = (ScanUrlData) obj;
            return (getUrl().equals(scanUrlData.getUrl())) && getRandCode().equals(scanUrlData.getRandCode());
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public l0<ScanUrlData> getParserForType() {
            return PARSER;
        }

        @Override // com.mobvoi.assistant.proto.CodeScanProto.ScanUrlDataOrBuilder
        public String getRandCode() {
            Object obj = this.randCode_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.randCode_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.assistant.proto.CodeScanProto.ScanUrlDataOrBuilder
        public ByteString getRandCodeBytes() {
            Object obj = this.randCode_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.randCode_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
        public int getSerializedSize() {
            int i10 = this.memoizedSize;
            if (i10 != -1) {
                return i10;
            }
            int i11 = 0;
            if (!getUrlBytes().isEmpty()) {
                i11 = 0 + GeneratedMessageV3.computeStringSize(1, this.url_);
            }
            if (!getRandCodeBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(2, this.randCode_);
            }
            this.memoizedSize = i11;
            return i11;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.g0
        public final a1 getUnknownFields() {
            return a1.c();
        }

        @Override // com.mobvoi.assistant.proto.CodeScanProto.ScanUrlDataOrBuilder
        public String getUrl() {
            Object obj = this.url_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.url_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.assistant.proto.CodeScanProto.ScanUrlDataOrBuilder
        public ByteString getUrlBytes() {
            Object obj = this.url_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.url_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.google.protobuf.a
        public int hashCode() {
            int i10 = this.memoizedHashCode;
            if (i10 != 0) {
                return i10;
            }
            int hashCode = ((((((((((779 + getDescriptorForType().hashCode()) * 37) + 1) * 53) + getUrl().hashCode()) * 37) + 2) * 53) + getRandCode().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return CodeScanProto.internal_static_com_mobvoi_assistant_proto_ScanUrlData_fieldAccessorTable.e(ScanUrlData.class, Builder.class);
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
            if (!getUrlBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.url_);
            }
            if (!getRandCodeBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.randCode_);
            }
        }

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageV3.b<Builder> implements ScanUrlDataOrBuilder {
            private Object randCode_;
            private Object url_;

            public static final Descriptors.b getDescriptor() {
                return CodeScanProto.internal_static_com_mobvoi_assistant_proto_ScanUrlData_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            public Builder clearRandCode() {
                this.randCode_ = ScanUrlData.getDefaultInstance().getRandCode();
                onChanged();
                return this;
            }

            public Builder clearUrl() {
                this.url_ = ScanUrlData.getDefaultInstance().getUrl();
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a, com.google.protobuf.g0
            public Descriptors.b getDescriptorForType() {
                return CodeScanProto.internal_static_com_mobvoi_assistant_proto_ScanUrlData_descriptor;
            }

            @Override // com.mobvoi.assistant.proto.CodeScanProto.ScanUrlDataOrBuilder
            public String getRandCode() {
                Object obj = this.randCode_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.randCode_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.assistant.proto.CodeScanProto.ScanUrlDataOrBuilder
            public ByteString getRandCodeBytes() {
                Object obj = this.randCode_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.randCode_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.mobvoi.assistant.proto.CodeScanProto.ScanUrlDataOrBuilder
            public String getUrl() {
                Object obj = this.url_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.url_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.assistant.proto.CodeScanProto.ScanUrlDataOrBuilder
            public ByteString getUrlBytes() {
                Object obj = this.url_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.url_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return CodeScanProto.internal_static_com_mobvoi_assistant_proto_ScanUrlData_fieldAccessorTable.e(ScanUrlData.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.f0
            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a
            public final Builder mergeUnknownFields(a1 a1Var) {
                return this;
            }

            public Builder setRandCode(String str) {
                Objects.requireNonNull(str);
                this.randCode_ = str;
                onChanged();
                return this;
            }

            public Builder setRandCodeBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                b.checkByteStringIsUtf8(byteString);
                this.randCode_ = byteString;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public final Builder setUnknownFields(a1 a1Var) {
                return this;
            }

            public Builder setUrl(String str) {
                Objects.requireNonNull(str);
                this.url_ = str;
                onChanged();
                return this;
            }

            public Builder setUrlBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                b.checkByteStringIsUtf8(byteString);
                this.url_ = byteString;
                onChanged();
                return this;
            }

            private Builder() {
                this.url_ = "";
                this.randCode_ = "";
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.e0.a, com.google.protobuf.d0.a
            public ScanUrlData build() {
                ScanUrlData buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) buildPartial);
            }

            @Override // com.google.protobuf.e0.a, com.google.protobuf.d0.a
            public ScanUrlData buildPartial() {
                ScanUrlData scanUrlData = new ScanUrlData(this);
                scanUrlData.url_ = this.url_;
                scanUrlData.randCode_ = this.randCode_;
                onBuilt();
                return scanUrlData;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.f0, com.google.protobuf.g0
            public ScanUrlData getDefaultInstanceForType() {
                return ScanUrlData.getDefaultInstance();
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
                this.url_ = "";
                this.randCode_ = "";
                return this;
            }

            private Builder(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.url_ = "";
                this.randCode_ = "";
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a, com.google.protobuf.b.a
            public Builder clone() {
                return (Builder) super.clone();
            }

            @Override // com.google.protobuf.a.AbstractC0170a, com.google.protobuf.d0.a
            public Builder mergeFrom(d0 d0Var) {
                if (d0Var instanceof ScanUrlData) {
                    return mergeFrom((ScanUrlData) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            public Builder mergeFrom(ScanUrlData scanUrlData) {
                if (scanUrlData == ScanUrlData.getDefaultInstance()) {
                    return this;
                }
                if (!scanUrlData.getUrl().isEmpty()) {
                    this.url_ = scanUrlData.url_;
                    onChanged();
                }
                if (!scanUrlData.getRandCode().isEmpty()) {
                    this.randCode_ = scanUrlData.randCode_;
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
                ScanUrlData scanUrlData = null;
                try {
                    try {
                        ScanUrlData scanUrlData2 = (ScanUrlData) ScanUrlData.PARSER.parsePartialFrom(iVar, qVar);
                        if (scanUrlData2 != null) {
                            mergeFrom(scanUrlData2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e10) {
                        scanUrlData = (ScanUrlData) e10.getUnfinishedMessage();
                        try {
                            throw e10.unwrapIOException();
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (scanUrlData != null) {
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (scanUrlData != null) {
                        mergeFrom(scanUrlData);
                    }
                    throw th2;
                }
            }
        }

        public static Builder newBuilder(ScanUrlData scanUrlData) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(scanUrlData);
        }

        public static ScanUrlData parseFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, qVar);
        }

        private ScanUrlData(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static ScanUrlData parseDelimitedFrom(InputStream inputStream, q qVar) throws IOException {
            return (ScanUrlData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
        }

        public static ScanUrlData parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
        public ScanUrlData getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static ScanUrlData parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder newBuilderForType() {
            return newBuilder();
        }

        private ScanUrlData() {
            this.memoizedIsInitialized = (byte) -1;
            this.url_ = "";
            this.randCode_ = "";
        }

        public static ScanUrlData parseFrom(InputStream inputStream) throws IOException {
            return (ScanUrlData) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.c cVar) {
            return new Builder(cVar);
        }

        public static ScanUrlData parseFrom(InputStream inputStream, q qVar) throws IOException {
            return (ScanUrlData) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
        }

        private ScanUrlData(i iVar, q qVar) throws InvalidProtocolBufferException {
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
                                    this.url_ = iVar.E();
                                } else if (F == 18) {
                                    this.randCode_ = iVar.E();
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

        public static ScanUrlData parseFrom(i iVar) throws IOException {
            return (ScanUrlData) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
        }

        public static ScanUrlData parseFrom(i iVar, q qVar) throws IOException {
            return (ScanUrlData) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
        }
    }

    /* loaded from: classes2.dex */
    public interface ScanUrlDataOrBuilder extends g0 {
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

        String getRandCode();

        ByteString getRandCodeBytes();

        /* synthetic */ Object getRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i10);

        /* synthetic */ int getRepeatedFieldCount(Descriptors.FieldDescriptor fieldDescriptor);

        @Override // com.google.protobuf.g0
        /* synthetic */ a1 getUnknownFields();

        String getUrl();

        ByteString getUrlBytes();

        @Override // com.google.protobuf.g0
        /* synthetic */ boolean hasField(Descriptors.FieldDescriptor fieldDescriptor);

        /* synthetic */ boolean hasOneof(Descriptors.h hVar);

        @Override // com.google.protobuf.f0
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes2.dex */
    public static final class TokenInfo extends GeneratedMessageV3 implements TokenInfoOrBuilder {
        private static final TokenInfo DEFAULT_INSTANCE = new TokenInfo();
        private static final l0<TokenInfo> PARSER = new c<TokenInfo>() { // from class: com.mobvoi.assistant.proto.CodeScanProto.TokenInfo.1
            @Override // com.google.protobuf.l0
            public TokenInfo parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
                return new TokenInfo(iVar, qVar);
            }
        };
        public static final int TOKEN_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private byte memoizedIsInitialized;
        private volatile Object token_;

        public static TokenInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return CodeScanProto.internal_static_com_mobvoi_assistant_proto_TokenInfo_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static TokenInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (TokenInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static TokenInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static l0<TokenInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof TokenInfo)) {
                return super.equals(obj);
            }
            return getToken().equals(((TokenInfo) obj).getToken());
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public l0<TokenInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
        public int getSerializedSize() {
            int i10 = this.memoizedSize;
            if (i10 != -1) {
                return i10;
            }
            int i11 = 0;
            if (!getTokenBytes().isEmpty()) {
                i11 = 0 + GeneratedMessageV3.computeStringSize(1, this.token_);
            }
            this.memoizedSize = i11;
            return i11;
        }

        @Override // com.mobvoi.assistant.proto.CodeScanProto.TokenInfoOrBuilder
        public String getToken() {
            Object obj = this.token_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.token_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.assistant.proto.CodeScanProto.TokenInfoOrBuilder
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

        @Override // com.google.protobuf.a
        public int hashCode() {
            int i10 = this.memoizedHashCode;
            if (i10 != 0) {
                return i10;
            }
            int hashCode = ((((((779 + getDescriptorForType().hashCode()) * 37) + 1) * 53) + getToken().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return CodeScanProto.internal_static_com_mobvoi_assistant_proto_TokenInfo_fieldAccessorTable.e(TokenInfo.class, Builder.class);
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
            if (!getTokenBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.token_);
            }
        }

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageV3.b<Builder> implements TokenInfoOrBuilder {
            private Object token_;

            public static final Descriptors.b getDescriptor() {
                return CodeScanProto.internal_static_com_mobvoi_assistant_proto_TokenInfo_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            public Builder clearToken() {
                this.token_ = TokenInfo.getDefaultInstance().getToken();
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a, com.google.protobuf.g0
            public Descriptors.b getDescriptorForType() {
                return CodeScanProto.internal_static_com_mobvoi_assistant_proto_TokenInfo_descriptor;
            }

            @Override // com.mobvoi.assistant.proto.CodeScanProto.TokenInfoOrBuilder
            public String getToken() {
                Object obj = this.token_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.token_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.assistant.proto.CodeScanProto.TokenInfoOrBuilder
            public ByteString getTokenBytes() {
                Object obj = this.token_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.token_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return CodeScanProto.internal_static_com_mobvoi_assistant_proto_TokenInfo_fieldAccessorTable.e(TokenInfo.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.f0
            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a
            public final Builder mergeUnknownFields(a1 a1Var) {
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
                this.token_ = "";
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.e0.a, com.google.protobuf.d0.a
            public TokenInfo build() {
                TokenInfo buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) buildPartial);
            }

            @Override // com.google.protobuf.e0.a, com.google.protobuf.d0.a
            public TokenInfo buildPartial() {
                TokenInfo tokenInfo = new TokenInfo(this);
                tokenInfo.token_ = this.token_;
                onBuilt();
                return tokenInfo;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.f0, com.google.protobuf.g0
            public TokenInfo getDefaultInstanceForType() {
                return TokenInfo.getDefaultInstance();
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
                this.token_ = "";
                return this;
            }

            private Builder(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.token_ = "";
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a, com.google.protobuf.b.a
            public Builder clone() {
                return (Builder) super.clone();
            }

            @Override // com.google.protobuf.a.AbstractC0170a, com.google.protobuf.d0.a
            public Builder mergeFrom(d0 d0Var) {
                if (d0Var instanceof TokenInfo) {
                    return mergeFrom((TokenInfo) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            public Builder mergeFrom(TokenInfo tokenInfo) {
                if (tokenInfo == TokenInfo.getDefaultInstance()) {
                    return this;
                }
                if (!tokenInfo.getToken().isEmpty()) {
                    this.token_ = tokenInfo.token_;
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
                TokenInfo tokenInfo = null;
                try {
                    try {
                        TokenInfo tokenInfo2 = (TokenInfo) TokenInfo.PARSER.parsePartialFrom(iVar, qVar);
                        if (tokenInfo2 != null) {
                            mergeFrom(tokenInfo2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e10) {
                        tokenInfo = (TokenInfo) e10.getUnfinishedMessage();
                        try {
                            throw e10.unwrapIOException();
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (tokenInfo != null) {
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (tokenInfo != null) {
                        mergeFrom(tokenInfo);
                    }
                    throw th2;
                }
            }
        }

        public static Builder newBuilder(TokenInfo tokenInfo) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(tokenInfo);
        }

        public static TokenInfo parseFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, qVar);
        }

        private TokenInfo(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static TokenInfo parseDelimitedFrom(InputStream inputStream, q qVar) throws IOException {
            return (TokenInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
        }

        public static TokenInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
        public TokenInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static TokenInfo parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder newBuilderForType() {
            return newBuilder();
        }

        private TokenInfo() {
            this.memoizedIsInitialized = (byte) -1;
            this.token_ = "";
        }

        public static TokenInfo parseFrom(InputStream inputStream) throws IOException {
            return (TokenInfo) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.c cVar) {
            return new Builder(cVar);
        }

        public static TokenInfo parseFrom(InputStream inputStream, q qVar) throws IOException {
            return (TokenInfo) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
        }

        private TokenInfo(i iVar, q qVar) throws InvalidProtocolBufferException {
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
                                    this.token_ = iVar.E();
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

        public static TokenInfo parseFrom(i iVar) throws IOException {
            return (TokenInfo) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
        }

        public static TokenInfo parseFrom(i iVar, q qVar) throws IOException {
            return (TokenInfo) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
        }
    }

    /* loaded from: classes2.dex */
    public interface TokenInfoOrBuilder extends g0 {
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

        /* synthetic */ Object getRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i10);

        /* synthetic */ int getRepeatedFieldCount(Descriptors.FieldDescriptor fieldDescriptor);

        String getToken();

        ByteString getTokenBytes();

        @Override // com.google.protobuf.g0
        /* synthetic */ a1 getUnknownFields();

        @Override // com.google.protobuf.g0
        /* synthetic */ boolean hasField(Descriptors.FieldDescriptor fieldDescriptor);

        /* synthetic */ boolean hasOneof(Descriptors.h hVar);

        @Override // com.google.protobuf.f0
        /* synthetic */ boolean isInitialized();
    }

    static {
        Descriptors.FileDescriptor.q(new String[]{"\n\u000fcode_scan.proto\u0012\u001acom.mobvoi.assistant.proto\"¸\u0001\n\fCodeScanResp\u0012\u0010\n\berr_code\u0018\u0001 \u0001(\u0005\u0012\u000f\n\u0007err_msg\u0018\u0002 \u0001(\t\u0012@\n\rscan_url_data\u0018\u0003 \u0001(\u000b2'.com.mobvoi.assistant.proto.ScanUrlDataH\u0000\u0012;\n\ntoken_info\u0018\u0004 \u0001(\u000b2%.com.mobvoi.assistant.proto.TokenInfoH\u0000B\u0006\n\u0004resp\"A\n\u0010RandCodeTokenReq\u0012\u0011\n\trand_code\u0018\u0001 \u0001(\t\u0012\r\n\u0005token\u0018\u0002 \u0001(\t\u0012\u000b\n\u0003app\u0018\u0003 \u0001(\t\"-\n\u000bScanUrlData\u0012\u000b\n\u0003url\u0018\u0001 \u0001(\t\u0012\u0011\n\trand_code\u0018\u0002 \u0001(\t\"\u001a\n\tTokenInfo\u0012\r\n\u0005token\u0018\u0001 \u0001(\tB+\n\u001acom.mobvoi.assistant.p", "rotoB\rCodeScanProtob\u0006proto3"}, new Descriptors.FileDescriptor[0], new Descriptors.FileDescriptor.a() { // from class: com.mobvoi.assistant.proto.CodeScanProto.1
            @Override // com.google.protobuf.Descriptors.FileDescriptor.a
            public o assignDescriptors(Descriptors.FileDescriptor fileDescriptor) {
                Descriptors.FileDescriptor unused = CodeScanProto.descriptor = fileDescriptor;
                return null;
            }
        });
        Descriptors.b bVar = getDescriptor().j().get(0);
        internal_static_com_mobvoi_assistant_proto_CodeScanResp_descriptor = bVar;
        internal_static_com_mobvoi_assistant_proto_CodeScanResp_fieldAccessorTable = new GeneratedMessageV3.e(bVar, new String[]{"ErrCode", "ErrMsg", "ScanUrlData", "TokenInfo", "Resp"});
        Descriptors.b bVar2 = getDescriptor().j().get(1);
        internal_static_com_mobvoi_assistant_proto_RandCodeTokenReq_descriptor = bVar2;
        internal_static_com_mobvoi_assistant_proto_RandCodeTokenReq_fieldAccessorTable = new GeneratedMessageV3.e(bVar2, new String[]{"RandCode", "Token", "App"});
        Descriptors.b bVar3 = getDescriptor().j().get(2);
        internal_static_com_mobvoi_assistant_proto_ScanUrlData_descriptor = bVar3;
        internal_static_com_mobvoi_assistant_proto_ScanUrlData_fieldAccessorTable = new GeneratedMessageV3.e(bVar3, new String[]{"Url", "RandCode"});
        Descriptors.b bVar4 = getDescriptor().j().get(3);
        internal_static_com_mobvoi_assistant_proto_TokenInfo_descriptor = bVar4;
        internal_static_com_mobvoi_assistant_proto_TokenInfo_fieldAccessorTable = new GeneratedMessageV3.e(bVar4, new String[]{"Token"});
    }

    private CodeScanProto() {
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
