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
import com.google.protobuf.m0;
import com.google.protobuf.n0;
import com.google.protobuf.o;
import com.google.protobuf.o0;
import com.google.protobuf.q;
import com.google.protobuf.q0;
import com.google.protobuf.u;
import com.google.protobuf.x;
import com.google.protobuf.y;
import com.mobvoi.companion.proto.ConstantProto;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
/* loaded from: classes2.dex */
public final class SoundProto {
    private static Descriptors.FileDescriptor descriptor;
    private static final Descriptors.b internal_static_com_mobvoi_companion_proto_ConvertConfig_descriptor;
    private static final GeneratedMessageV3.e internal_static_com_mobvoi_companion_proto_ConvertConfig_fieldAccessorTable;
    private static final Descriptors.b internal_static_com_mobvoi_companion_proto_ConvertDataUpdateReq_descriptor;
    private static final GeneratedMessageV3.e internal_static_com_mobvoi_companion_proto_ConvertDataUpdateReq_fieldAccessorTable;
    private static final Descriptors.b internal_static_com_mobvoi_companion_proto_ConvertData_descriptor;
    private static final GeneratedMessageV3.e internal_static_com_mobvoi_companion_proto_ConvertData_fieldAccessorTable;
    private static final Descriptors.b internal_static_com_mobvoi_companion_proto_FileStatusDto_descriptor;
    private static final GeneratedMessageV3.e internal_static_com_mobvoi_companion_proto_FileStatusDto_fieldAccessorTable;
    private static final Descriptors.b internal_static_com_mobvoi_companion_proto_LangInfo_descriptor;
    private static final GeneratedMessageV3.e internal_static_com_mobvoi_companion_proto_LangInfo_fieldAccessorTable;
    private static final Descriptors.b internal_static_com_mobvoi_companion_proto_ModifiedTextReq_descriptor;
    private static final GeneratedMessageV3.e internal_static_com_mobvoi_companion_proto_ModifiedTextReq_fieldAccessorTable;
    private static final Descriptors.b internal_static_com_mobvoi_companion_proto_RenameReq_descriptor;
    private static final GeneratedMessageV3.e internal_static_com_mobvoi_companion_proto_RenameReq_fieldAccessorTable;
    private static final Descriptors.b internal_static_com_mobvoi_companion_proto_SoundConvertConfigResp_descriptor;
    private static final GeneratedMessageV3.e internal_static_com_mobvoi_companion_proto_SoundConvertConfigResp_fieldAccessorTable;
    private static final Descriptors.b internal_static_com_mobvoi_companion_proto_SoundConvertResultResp_descriptor;
    private static final GeneratedMessageV3.e internal_static_com_mobvoi_companion_proto_SoundConvertResultResp_fieldAccessorTable;
    private static final Descriptors.b internal_static_com_mobvoi_companion_proto_SoundFileDetailResp_descriptor;
    private static final GeneratedMessageV3.e internal_static_com_mobvoi_companion_proto_SoundFileDetailResp_fieldAccessorTable;
    private static final Descriptors.b internal_static_com_mobvoi_companion_proto_SoundFileResp_descriptor;
    private static final GeneratedMessageV3.e internal_static_com_mobvoi_companion_proto_SoundFileResp_fieldAccessorTable;
    private static final Descriptors.b internal_static_com_mobvoi_companion_proto_SoundFileUploadStatusResp_descriptor;
    private static final GeneratedMessageV3.e internal_static_com_mobvoi_companion_proto_SoundFileUploadStatusResp_fieldAccessorTable;
    private static final Descriptors.b internal_static_com_mobvoi_companion_proto_SoundFile_descriptor;
    private static final GeneratedMessageV3.e internal_static_com_mobvoi_companion_proto_SoundFile_fieldAccessorTable;

    /* loaded from: classes2.dex */
    public enum Channel implements m0 {
        LEFT(0),
        RIGHT(1),
        UNRECOGNIZED(-1);
        
        public static final int LEFT_VALUE = 0;
        public static final int RIGHT_VALUE = 1;
        private final int value;
        private static final u.b<Channel> internalValueMap = new u.b<Channel>() { // from class: com.mobvoi.companion.proto.SoundProto.Channel.1
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
                return LEFT;
            }
            if (i10 != 1) {
                return null;
            }
            return RIGHT;
        }

        public static final Descriptors.d getDescriptor() {
            return SoundProto.getDescriptor().i().get(1);
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
    public static final class ConvertConfig extends GeneratedMessageV3 implements ConvertConfigOrBuilder {
        public static final int LANG_LIST_FIELD_NUMBER = 1;
        public static final int SPEAKER_NUM_LIST_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private List<LangInfo> langList_;
        private byte memoizedIsInitialized;
        private int speakerNumListMemoizedSerializedSize;
        private List<Integer> speakerNumList_;
        private static final ConvertConfig DEFAULT_INSTANCE = new ConvertConfig();
        private static final l0<ConvertConfig> PARSER = new c<ConvertConfig>() { // from class: com.mobvoi.companion.proto.SoundProto.ConvertConfig.1
            @Override // com.google.protobuf.l0
            public ConvertConfig parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
                return new ConvertConfig(iVar, qVar);
            }
        };

        public static ConvertConfig getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return SoundProto.internal_static_com_mobvoi_companion_proto_ConvertConfig_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static ConvertConfig parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ConvertConfig) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static ConvertConfig parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static l0<ConvertConfig> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ConvertConfig)) {
                return super.equals(obj);
            }
            ConvertConfig convertConfig = (ConvertConfig) obj;
            return (getLangListList().equals(convertConfig.getLangListList())) && getSpeakerNumListList().equals(convertConfig.getSpeakerNumListList());
        }

        @Override // com.mobvoi.companion.proto.SoundProto.ConvertConfigOrBuilder
        public LangInfo getLangList(int i10) {
            return this.langList_.get(i10);
        }

        @Override // com.mobvoi.companion.proto.SoundProto.ConvertConfigOrBuilder
        public int getLangListCount() {
            return this.langList_.size();
        }

        @Override // com.mobvoi.companion.proto.SoundProto.ConvertConfigOrBuilder
        public List<LangInfo> getLangListList() {
            return this.langList_;
        }

        @Override // com.mobvoi.companion.proto.SoundProto.ConvertConfigOrBuilder
        public LangInfoOrBuilder getLangListOrBuilder(int i10) {
            return this.langList_.get(i10);
        }

        @Override // com.mobvoi.companion.proto.SoundProto.ConvertConfigOrBuilder
        public List<? extends LangInfoOrBuilder> getLangListOrBuilderList() {
            return this.langList_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public l0<ConvertConfig> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
        public int getSerializedSize() {
            int i10 = this.memoizedSize;
            if (i10 != -1) {
                return i10;
            }
            int i11 = 0;
            for (int i12 = 0; i12 < this.langList_.size(); i12++) {
                i11 += CodedOutputStream.E(1, this.langList_.get(i12));
            }
            int i13 = 0;
            for (int i14 = 0; i14 < this.speakerNumList_.size(); i14++) {
                i13 += CodedOutputStream.w(this.speakerNumList_.get(i14).intValue());
            }
            int i15 = i11 + i13;
            if (!getSpeakerNumListList().isEmpty()) {
                i15 = i15 + 1 + CodedOutputStream.w(i13);
            }
            this.speakerNumListMemoizedSerializedSize = i13;
            this.memoizedSize = i15;
            return i15;
        }

        @Override // com.mobvoi.companion.proto.SoundProto.ConvertConfigOrBuilder
        public int getSpeakerNumList(int i10) {
            return this.speakerNumList_.get(i10).intValue();
        }

        @Override // com.mobvoi.companion.proto.SoundProto.ConvertConfigOrBuilder
        public int getSpeakerNumListCount() {
            return this.speakerNumList_.size();
        }

        @Override // com.mobvoi.companion.proto.SoundProto.ConvertConfigOrBuilder
        public List<Integer> getSpeakerNumListList() {
            return this.speakerNumList_;
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
            if (getLangListCount() > 0) {
                hashCode = (((hashCode * 37) + 1) * 53) + getLangListList().hashCode();
            }
            if (getSpeakerNumListCount() > 0) {
                hashCode = (((hashCode * 37) + 2) * 53) + getSpeakerNumListList().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return SoundProto.internal_static_com_mobvoi_companion_proto_ConvertConfig_fieldAccessorTable.e(ConvertConfig.class, Builder.class);
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
            getSerializedSize();
            for (int i10 = 0; i10 < this.langList_.size(); i10++) {
                codedOutputStream.A0(1, this.langList_.get(i10));
            }
            if (getSpeakerNumListList().size() > 0) {
                codedOutputStream.N0(18);
                codedOutputStream.N0(this.speakerNumListMemoizedSerializedSize);
            }
            for (int i11 = 0; i11 < this.speakerNumList_.size(); i11++) {
                codedOutputStream.x0(this.speakerNumList_.get(i11).intValue());
            }
        }

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageV3.b<Builder> implements ConvertConfigOrBuilder {
            private int bitField0_;
            private o0<LangInfo, LangInfo.Builder, LangInfoOrBuilder> langListBuilder_;
            private List<LangInfo> langList_;
            private List<Integer> speakerNumList_;

            private void ensureLangListIsMutable() {
                if ((this.bitField0_ & 1) != 1) {
                    this.langList_ = new ArrayList(this.langList_);
                    this.bitField0_ |= 1;
                }
            }

            private void ensureSpeakerNumListIsMutable() {
                if ((this.bitField0_ & 2) != 2) {
                    this.speakerNumList_ = new ArrayList(this.speakerNumList_);
                    this.bitField0_ |= 2;
                }
            }

            public static final Descriptors.b getDescriptor() {
                return SoundProto.internal_static_com_mobvoi_companion_proto_ConvertConfig_descriptor;
            }

            private o0<LangInfo, LangInfo.Builder, LangInfoOrBuilder> getLangListFieldBuilder() {
                if (this.langListBuilder_ == null) {
                    List<LangInfo> list = this.langList_;
                    boolean z10 = true;
                    if ((this.bitField0_ & 1) != 1) {
                        z10 = false;
                    }
                    this.langListBuilder_ = new o0<>(list, z10, getParentForChildren(), isClean());
                    this.langList_ = null;
                }
                return this.langListBuilder_;
            }

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                    getLangListFieldBuilder();
                }
            }

            public Builder addAllLangList(Iterable<? extends LangInfo> iterable) {
                o0<LangInfo, LangInfo.Builder, LangInfoOrBuilder> o0Var = this.langListBuilder_;
                if (o0Var == null) {
                    ensureLangListIsMutable();
                    b.a.addAll(iterable, this.langList_);
                    onChanged();
                } else {
                    o0Var.b(iterable);
                }
                return this;
            }

            public Builder addAllSpeakerNumList(Iterable<? extends Integer> iterable) {
                ensureSpeakerNumListIsMutable();
                b.a.addAll(iterable, this.speakerNumList_);
                onChanged();
                return this;
            }

            public Builder addLangList(LangInfo langInfo) {
                o0<LangInfo, LangInfo.Builder, LangInfoOrBuilder> o0Var = this.langListBuilder_;
                if (o0Var == null) {
                    Objects.requireNonNull(langInfo);
                    ensureLangListIsMutable();
                    this.langList_.add(langInfo);
                    onChanged();
                } else {
                    o0Var.f(langInfo);
                }
                return this;
            }

            public LangInfo.Builder addLangListBuilder() {
                return getLangListFieldBuilder().d(LangInfo.getDefaultInstance());
            }

            public Builder addSpeakerNumList(int i10) {
                ensureSpeakerNumListIsMutable();
                this.speakerNumList_.add(Integer.valueOf(i10));
                onChanged();
                return this;
            }

            public Builder clearLangList() {
                o0<LangInfo, LangInfo.Builder, LangInfoOrBuilder> o0Var = this.langListBuilder_;
                if (o0Var == null) {
                    this.langList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    o0Var.h();
                }
                return this;
            }

            public Builder clearSpeakerNumList() {
                this.speakerNumList_ = Collections.emptyList();
                this.bitField0_ &= -3;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a, com.google.protobuf.g0
            public Descriptors.b getDescriptorForType() {
                return SoundProto.internal_static_com_mobvoi_companion_proto_ConvertConfig_descriptor;
            }

            @Override // com.mobvoi.companion.proto.SoundProto.ConvertConfigOrBuilder
            public LangInfo getLangList(int i10) {
                o0<LangInfo, LangInfo.Builder, LangInfoOrBuilder> o0Var = this.langListBuilder_;
                if (o0Var == null) {
                    return this.langList_.get(i10);
                }
                return o0Var.o(i10);
            }

            public LangInfo.Builder getLangListBuilder(int i10) {
                return getLangListFieldBuilder().l(i10);
            }

            public List<LangInfo.Builder> getLangListBuilderList() {
                return getLangListFieldBuilder().m();
            }

            @Override // com.mobvoi.companion.proto.SoundProto.ConvertConfigOrBuilder
            public int getLangListCount() {
                o0<LangInfo, LangInfo.Builder, LangInfoOrBuilder> o0Var = this.langListBuilder_;
                if (o0Var == null) {
                    return this.langList_.size();
                }
                return o0Var.n();
            }

            @Override // com.mobvoi.companion.proto.SoundProto.ConvertConfigOrBuilder
            public List<LangInfo> getLangListList() {
                o0<LangInfo, LangInfo.Builder, LangInfoOrBuilder> o0Var = this.langListBuilder_;
                if (o0Var == null) {
                    return Collections.unmodifiableList(this.langList_);
                }
                return o0Var.q();
            }

            @Override // com.mobvoi.companion.proto.SoundProto.ConvertConfigOrBuilder
            public LangInfoOrBuilder getLangListOrBuilder(int i10) {
                o0<LangInfo, LangInfo.Builder, LangInfoOrBuilder> o0Var = this.langListBuilder_;
                if (o0Var == null) {
                    return this.langList_.get(i10);
                }
                return o0Var.r(i10);
            }

            @Override // com.mobvoi.companion.proto.SoundProto.ConvertConfigOrBuilder
            public List<? extends LangInfoOrBuilder> getLangListOrBuilderList() {
                o0<LangInfo, LangInfo.Builder, LangInfoOrBuilder> o0Var = this.langListBuilder_;
                if (o0Var != null) {
                    return o0Var.s();
                }
                return Collections.unmodifiableList(this.langList_);
            }

            @Override // com.mobvoi.companion.proto.SoundProto.ConvertConfigOrBuilder
            public int getSpeakerNumList(int i10) {
                return this.speakerNumList_.get(i10).intValue();
            }

            @Override // com.mobvoi.companion.proto.SoundProto.ConvertConfigOrBuilder
            public int getSpeakerNumListCount() {
                return this.speakerNumList_.size();
            }

            @Override // com.mobvoi.companion.proto.SoundProto.ConvertConfigOrBuilder
            public List<Integer> getSpeakerNumListList() {
                return Collections.unmodifiableList(this.speakerNumList_);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return SoundProto.internal_static_com_mobvoi_companion_proto_ConvertConfig_fieldAccessorTable.e(ConvertConfig.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.f0
            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a
            public final Builder mergeUnknownFields(a1 a1Var) {
                return this;
            }

            public Builder removeLangList(int i10) {
                o0<LangInfo, LangInfo.Builder, LangInfoOrBuilder> o0Var = this.langListBuilder_;
                if (o0Var == null) {
                    ensureLangListIsMutable();
                    this.langList_.remove(i10);
                    onChanged();
                } else {
                    o0Var.w(i10);
                }
                return this;
            }

            public Builder setLangList(int i10, LangInfo langInfo) {
                o0<LangInfo, LangInfo.Builder, LangInfoOrBuilder> o0Var = this.langListBuilder_;
                if (o0Var == null) {
                    Objects.requireNonNull(langInfo);
                    ensureLangListIsMutable();
                    this.langList_.set(i10, langInfo);
                    onChanged();
                } else {
                    o0Var.x(i10, langInfo);
                }
                return this;
            }

            public Builder setSpeakerNumList(int i10, int i11) {
                ensureSpeakerNumListIsMutable();
                this.speakerNumList_.set(i10, Integer.valueOf(i11));
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public final Builder setUnknownFields(a1 a1Var) {
                return this;
            }

            private Builder() {
                this.langList_ = Collections.emptyList();
                this.speakerNumList_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.e0.a, com.google.protobuf.d0.a
            public ConvertConfig build() {
                ConvertConfig buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) buildPartial);
            }

            @Override // com.google.protobuf.e0.a, com.google.protobuf.d0.a
            public ConvertConfig buildPartial() {
                ConvertConfig convertConfig = new ConvertConfig(this);
                int i10 = this.bitField0_;
                o0<LangInfo, LangInfo.Builder, LangInfoOrBuilder> o0Var = this.langListBuilder_;
                if (o0Var == null) {
                    if ((i10 & 1) == 1) {
                        this.langList_ = Collections.unmodifiableList(this.langList_);
                        this.bitField0_ &= -2;
                    }
                    convertConfig.langList_ = this.langList_;
                } else {
                    convertConfig.langList_ = o0Var.g();
                }
                if ((this.bitField0_ & 2) == 2) {
                    this.speakerNumList_ = Collections.unmodifiableList(this.speakerNumList_);
                    this.bitField0_ &= -3;
                }
                convertConfig.speakerNumList_ = this.speakerNumList_;
                onBuilt();
                return convertConfig;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.f0, com.google.protobuf.g0
            public ConvertConfig getDefaultInstanceForType() {
                return ConvertConfig.getDefaultInstance();
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

            public LangInfo.Builder addLangListBuilder(int i10) {
                return getLangListFieldBuilder().c(i10, LangInfo.getDefaultInstance());
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a
            public Builder clearOneof(Descriptors.h hVar) {
                return (Builder) super.clearOneof(hVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a
            public Builder clear() {
                super.clear();
                o0<LangInfo, LangInfo.Builder, LangInfoOrBuilder> o0Var = this.langListBuilder_;
                if (o0Var == null) {
                    this.langList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    o0Var.h();
                }
                this.speakerNumList_ = Collections.emptyList();
                this.bitField0_ &= -3;
                return this;
            }

            private Builder(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.langList_ = Collections.emptyList();
                this.speakerNumList_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            public Builder addLangList(int i10, LangInfo langInfo) {
                o0<LangInfo, LangInfo.Builder, LangInfoOrBuilder> o0Var = this.langListBuilder_;
                if (o0Var == null) {
                    Objects.requireNonNull(langInfo);
                    ensureLangListIsMutable();
                    this.langList_.add(i10, langInfo);
                    onChanged();
                } else {
                    o0Var.e(i10, langInfo);
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a, com.google.protobuf.b.a
            public Builder clone() {
                return (Builder) super.clone();
            }

            @Override // com.google.protobuf.a.AbstractC0170a, com.google.protobuf.d0.a
            public Builder mergeFrom(d0 d0Var) {
                if (d0Var instanceof ConvertConfig) {
                    return mergeFrom((ConvertConfig) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            public Builder setLangList(int i10, LangInfo.Builder builder) {
                o0<LangInfo, LangInfo.Builder, LangInfoOrBuilder> o0Var = this.langListBuilder_;
                if (o0Var == null) {
                    ensureLangListIsMutable();
                    this.langList_.set(i10, builder.build());
                    onChanged();
                } else {
                    o0Var.x(i10, builder.build());
                }
                return this;
            }

            public Builder mergeFrom(ConvertConfig convertConfig) {
                if (convertConfig == ConvertConfig.getDefaultInstance()) {
                    return this;
                }
                if (this.langListBuilder_ == null) {
                    if (!convertConfig.langList_.isEmpty()) {
                        if (this.langList_.isEmpty()) {
                            this.langList_ = convertConfig.langList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureLangListIsMutable();
                            this.langList_.addAll(convertConfig.langList_);
                        }
                        onChanged();
                    }
                } else if (!convertConfig.langList_.isEmpty()) {
                    if (this.langListBuilder_.u()) {
                        this.langListBuilder_.i();
                        o0<LangInfo, LangInfo.Builder, LangInfoOrBuilder> o0Var = null;
                        this.langListBuilder_ = null;
                        this.langList_ = convertConfig.langList_;
                        this.bitField0_ &= -2;
                        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                            o0Var = getLangListFieldBuilder();
                        }
                        this.langListBuilder_ = o0Var;
                    } else {
                        this.langListBuilder_.b(convertConfig.langList_);
                    }
                }
                if (!convertConfig.speakerNumList_.isEmpty()) {
                    if (this.speakerNumList_.isEmpty()) {
                        this.speakerNumList_ = convertConfig.speakerNumList_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureSpeakerNumListIsMutable();
                        this.speakerNumList_.addAll(convertConfig.speakerNumList_);
                    }
                    onChanged();
                }
                onChanged();
                return this;
            }

            public Builder addLangList(LangInfo.Builder builder) {
                o0<LangInfo, LangInfo.Builder, LangInfoOrBuilder> o0Var = this.langListBuilder_;
                if (o0Var == null) {
                    ensureLangListIsMutable();
                    this.langList_.add(builder.build());
                    onChanged();
                } else {
                    o0Var.f(builder.build());
                }
                return this;
            }

            public Builder addLangList(int i10, LangInfo.Builder builder) {
                o0<LangInfo, LangInfo.Builder, LangInfoOrBuilder> o0Var = this.langListBuilder_;
                if (o0Var == null) {
                    ensureLangListIsMutable();
                    this.langList_.add(i10, builder.build());
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
                ConvertConfig convertConfig = null;
                try {
                    try {
                        ConvertConfig convertConfig2 = (ConvertConfig) ConvertConfig.PARSER.parsePartialFrom(iVar, qVar);
                        if (convertConfig2 != null) {
                            mergeFrom(convertConfig2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e10) {
                        convertConfig = (ConvertConfig) e10.getUnfinishedMessage();
                        try {
                            throw e10.unwrapIOException();
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (convertConfig != null) {
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (convertConfig != null) {
                        mergeFrom(convertConfig);
                    }
                    throw th2;
                }
            }
        }

        public static Builder newBuilder(ConvertConfig convertConfig) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(convertConfig);
        }

        public static ConvertConfig parseFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, qVar);
        }

        private ConvertConfig(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.speakerNumListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
        }

        public static ConvertConfig parseDelimitedFrom(InputStream inputStream, q qVar) throws IOException {
            return (ConvertConfig) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
        }

        public static ConvertConfig parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
        public ConvertConfig getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static ConvertConfig parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static ConvertConfig parseFrom(InputStream inputStream) throws IOException {
            return (ConvertConfig) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.c cVar) {
            return new Builder(cVar);
        }

        private ConvertConfig() {
            this.speakerNumListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.langList_ = Collections.emptyList();
            this.speakerNumList_ = Collections.emptyList();
        }

        public static ConvertConfig parseFrom(InputStream inputStream, q qVar) throws IOException {
            return (ConvertConfig) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
        }

        public static ConvertConfig parseFrom(i iVar) throws IOException {
            return (ConvertConfig) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
        }

        private ConvertConfig(i iVar, q qVar) throws InvalidProtocolBufferException {
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
                            if (F != 0) {
                                if (F == 10) {
                                    if (!z11 || !true) {
                                        this.langList_ = new ArrayList();
                                        z11 |= true;
                                    }
                                    this.langList_.add((LangInfo) iVar.v(LangInfo.parser(), qVar));
                                } else if (F == 16) {
                                    if (!(z11 & true)) {
                                        this.speakerNumList_ = new ArrayList();
                                        z11 |= true;
                                    }
                                    this.speakerNumList_.add(Integer.valueOf(iVar.t()));
                                } else if (F == 18) {
                                    int k10 = iVar.k(iVar.x());
                                    if (!(z11 & true) && iVar.d() > 0) {
                                        this.speakerNumList_ = new ArrayList();
                                        z11 |= true;
                                    }
                                    while (iVar.d() > 0) {
                                        this.speakerNumList_.add(Integer.valueOf(iVar.t()));
                                    }
                                    iVar.j(k10);
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
                    if (z11 && true) {
                        this.langList_ = Collections.unmodifiableList(this.langList_);
                    }
                    if (z11 & true) {
                        this.speakerNumList_ = Collections.unmodifiableList(this.speakerNumList_);
                    }
                    makeExtensionsImmutable();
                }
            }
        }

        public static ConvertConfig parseFrom(i iVar, q qVar) throws IOException {
            return (ConvertConfig) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
        }
    }

    /* loaded from: classes2.dex */
    public interface ConvertConfigOrBuilder extends g0 {
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

        LangInfo getLangList(int i10);

        int getLangListCount();

        List<LangInfo> getLangListList();

        LangInfoOrBuilder getLangListOrBuilder(int i10);

        List<? extends LangInfoOrBuilder> getLangListOrBuilderList();

        /* synthetic */ Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.h hVar);

        /* synthetic */ Object getRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i10);

        /* synthetic */ int getRepeatedFieldCount(Descriptors.FieldDescriptor fieldDescriptor);

        int getSpeakerNumList(int i10);

        int getSpeakerNumListCount();

        List<Integer> getSpeakerNumListList();

        @Override // com.google.protobuf.g0
        /* synthetic */ a1 getUnknownFields();

        @Override // com.google.protobuf.g0
        /* synthetic */ boolean hasField(Descriptors.FieldDescriptor fieldDescriptor);

        /* synthetic */ boolean hasOneof(Descriptors.h hVar);

        @Override // com.google.protobuf.f0
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes2.dex */
    public static final class ConvertData extends GeneratedMessageV3 implements ConvertDataOrBuilder {
        public static final int CHANNEL_FIELD_NUMBER = 7;
        public static final int DURATION_FIELD_NUMBER = 2;
        public static final int ID_FIELD_NUMBER = 8;
        public static final int MODIFIED_TEXT_FIELD_NUMBER = 9;
        public static final int OFFSET_FIELD_NUMBER = 1;
        public static final int PARAGRAPH_KEYWORDS_FIELD_NUMBER = 6;
        public static final int SPEAKER_FIELD_NUMBER = 3;
        public static final int SPEAKER_NAME_FIELD_NUMBER = 10;
        public static final int SUMMARY_FIELD_NUMBER = 5;
        public static final int TEXT_FIELD_NUMBER = 4;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private int channel_;
        private int duration_;
        private int id_;
        private byte memoizedIsInitialized;
        private volatile Object modifiedText_;
        private int offset_;
        private y paragraphKeywords_;
        private volatile Object speakerName_;
        private volatile Object speaker_;
        private volatile Object summary_;
        private volatile Object text_;
        private static final ConvertData DEFAULT_INSTANCE = new ConvertData();
        private static final l0<ConvertData> PARSER = new c<ConvertData>() { // from class: com.mobvoi.companion.proto.SoundProto.ConvertData.1
            @Override // com.google.protobuf.l0
            public ConvertData parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
                return new ConvertData(iVar, qVar);
            }
        };

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageV3.b<Builder> implements ConvertDataOrBuilder {
            private int bitField0_;
            private int channel_;
            private int duration_;
            private int id_;
            private Object modifiedText_;
            private int offset_;
            private y paragraphKeywords_;
            private Object speakerName_;
            private Object speaker_;
            private Object summary_;
            private Object text_;

            private void ensureParagraphKeywordsIsMutable() {
                if ((this.bitField0_ & 32) != 32) {
                    this.paragraphKeywords_ = new x(this.paragraphKeywords_);
                    this.bitField0_ |= 32;
                }
            }

            public static final Descriptors.b getDescriptor() {
                return SoundProto.internal_static_com_mobvoi_companion_proto_ConvertData_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            public Builder addAllParagraphKeywords(Iterable<String> iterable) {
                ensureParagraphKeywordsIsMutable();
                b.a.addAll(iterable, this.paragraphKeywords_);
                onChanged();
                return this;
            }

            public Builder addParagraphKeywords(String str) {
                Objects.requireNonNull(str);
                ensureParagraphKeywordsIsMutable();
                this.paragraphKeywords_.add(str);
                onChanged();
                return this;
            }

            public Builder addParagraphKeywordsBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                b.checkByteStringIsUtf8(byteString);
                ensureParagraphKeywordsIsMutable();
                this.paragraphKeywords_.v(byteString);
                onChanged();
                return this;
            }

            public Builder clearChannel() {
                this.channel_ = 0;
                onChanged();
                return this;
            }

            public Builder clearDuration() {
                this.duration_ = 0;
                onChanged();
                return this;
            }

            public Builder clearId() {
                this.id_ = 0;
                onChanged();
                return this;
            }

            public Builder clearModifiedText() {
                this.modifiedText_ = ConvertData.getDefaultInstance().getModifiedText();
                onChanged();
                return this;
            }

            public Builder clearOffset() {
                this.offset_ = 0;
                onChanged();
                return this;
            }

            public Builder clearParagraphKeywords() {
                this.paragraphKeywords_ = x.f13385d;
                this.bitField0_ &= -33;
                onChanged();
                return this;
            }

            public Builder clearSpeaker() {
                this.speaker_ = ConvertData.getDefaultInstance().getSpeaker();
                onChanged();
                return this;
            }

            public Builder clearSpeakerName() {
                this.speakerName_ = ConvertData.getDefaultInstance().getSpeakerName();
                onChanged();
                return this;
            }

            public Builder clearSummary() {
                this.summary_ = ConvertData.getDefaultInstance().getSummary();
                onChanged();
                return this;
            }

            public Builder clearText() {
                this.text_ = ConvertData.getDefaultInstance().getText();
                onChanged();
                return this;
            }

            @Override // com.mobvoi.companion.proto.SoundProto.ConvertDataOrBuilder
            public Channel getChannel() {
                Channel valueOf = Channel.valueOf(this.channel_);
                return valueOf == null ? Channel.UNRECOGNIZED : valueOf;
            }

            @Override // com.mobvoi.companion.proto.SoundProto.ConvertDataOrBuilder
            public int getChannelValue() {
                return this.channel_;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a, com.google.protobuf.g0
            public Descriptors.b getDescriptorForType() {
                return SoundProto.internal_static_com_mobvoi_companion_proto_ConvertData_descriptor;
            }

            @Override // com.mobvoi.companion.proto.SoundProto.ConvertDataOrBuilder
            public int getDuration() {
                return this.duration_;
            }

            @Override // com.mobvoi.companion.proto.SoundProto.ConvertDataOrBuilder
            public int getId() {
                return this.id_;
            }

            @Override // com.mobvoi.companion.proto.SoundProto.ConvertDataOrBuilder
            public String getModifiedText() {
                Object obj = this.modifiedText_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.modifiedText_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.proto.SoundProto.ConvertDataOrBuilder
            public ByteString getModifiedTextBytes() {
                Object obj = this.modifiedText_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.modifiedText_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.mobvoi.companion.proto.SoundProto.ConvertDataOrBuilder
            public int getOffset() {
                return this.offset_;
            }

            @Override // com.mobvoi.companion.proto.SoundProto.ConvertDataOrBuilder
            public String getParagraphKeywords(int i10) {
                return this.paragraphKeywords_.get(i10);
            }

            @Override // com.mobvoi.companion.proto.SoundProto.ConvertDataOrBuilder
            public ByteString getParagraphKeywordsBytes(int i10) {
                return this.paragraphKeywords_.o0(i10);
            }

            @Override // com.mobvoi.companion.proto.SoundProto.ConvertDataOrBuilder
            public int getParagraphKeywordsCount() {
                return this.paragraphKeywords_.size();
            }

            @Override // com.mobvoi.companion.proto.SoundProto.ConvertDataOrBuilder
            public String getSpeaker() {
                Object obj = this.speaker_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.speaker_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.proto.SoundProto.ConvertDataOrBuilder
            public ByteString getSpeakerBytes() {
                Object obj = this.speaker_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.speaker_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.mobvoi.companion.proto.SoundProto.ConvertDataOrBuilder
            public String getSpeakerName() {
                Object obj = this.speakerName_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.speakerName_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.proto.SoundProto.ConvertDataOrBuilder
            public ByteString getSpeakerNameBytes() {
                Object obj = this.speakerName_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.speakerName_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.mobvoi.companion.proto.SoundProto.ConvertDataOrBuilder
            public String getSummary() {
                Object obj = this.summary_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.summary_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.proto.SoundProto.ConvertDataOrBuilder
            public ByteString getSummaryBytes() {
                Object obj = this.summary_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.summary_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.mobvoi.companion.proto.SoundProto.ConvertDataOrBuilder
            public String getText() {
                Object obj = this.text_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.text_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.proto.SoundProto.ConvertDataOrBuilder
            public ByteString getTextBytes() {
                Object obj = this.text_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.text_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return SoundProto.internal_static_com_mobvoi_companion_proto_ConvertData_fieldAccessorTable.e(ConvertData.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.f0
            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a
            public final Builder mergeUnknownFields(a1 a1Var) {
                return this;
            }

            public Builder setChannel(Channel channel) {
                Objects.requireNonNull(channel);
                this.channel_ = channel.getNumber();
                onChanged();
                return this;
            }

            public Builder setChannelValue(int i10) {
                this.channel_ = i10;
                onChanged();
                return this;
            }

            public Builder setDuration(int i10) {
                this.duration_ = i10;
                onChanged();
                return this;
            }

            public Builder setId(int i10) {
                this.id_ = i10;
                onChanged();
                return this;
            }

            public Builder setModifiedText(String str) {
                Objects.requireNonNull(str);
                this.modifiedText_ = str;
                onChanged();
                return this;
            }

            public Builder setModifiedTextBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                b.checkByteStringIsUtf8(byteString);
                this.modifiedText_ = byteString;
                onChanged();
                return this;
            }

            public Builder setOffset(int i10) {
                this.offset_ = i10;
                onChanged();
                return this;
            }

            public Builder setParagraphKeywords(int i10, String str) {
                Objects.requireNonNull(str);
                ensureParagraphKeywordsIsMutable();
                this.paragraphKeywords_.set(i10, str);
                onChanged();
                return this;
            }

            public Builder setSpeaker(String str) {
                Objects.requireNonNull(str);
                this.speaker_ = str;
                onChanged();
                return this;
            }

            public Builder setSpeakerBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                b.checkByteStringIsUtf8(byteString);
                this.speaker_ = byteString;
                onChanged();
                return this;
            }

            public Builder setSpeakerName(String str) {
                Objects.requireNonNull(str);
                this.speakerName_ = str;
                onChanged();
                return this;
            }

            public Builder setSpeakerNameBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                b.checkByteStringIsUtf8(byteString);
                this.speakerName_ = byteString;
                onChanged();
                return this;
            }

            public Builder setSummary(String str) {
                Objects.requireNonNull(str);
                this.summary_ = str;
                onChanged();
                return this;
            }

            public Builder setSummaryBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                b.checkByteStringIsUtf8(byteString);
                this.summary_ = byteString;
                onChanged();
                return this;
            }

            public Builder setText(String str) {
                Objects.requireNonNull(str);
                this.text_ = str;
                onChanged();
                return this;
            }

            public Builder setTextBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                b.checkByteStringIsUtf8(byteString);
                this.text_ = byteString;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public final Builder setUnknownFields(a1 a1Var) {
                return this;
            }

            @Override // com.mobvoi.companion.proto.SoundProto.ConvertDataOrBuilder
            public n0 getParagraphKeywordsList() {
                return this.paragraphKeywords_.u0();
            }

            private Builder() {
                this.speaker_ = "";
                this.text_ = "";
                this.summary_ = "";
                this.paragraphKeywords_ = x.f13385d;
                this.channel_ = 0;
                this.modifiedText_ = "";
                this.speakerName_ = "";
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.e0.a, com.google.protobuf.d0.a
            public ConvertData build() {
                ConvertData buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) buildPartial);
            }

            @Override // com.google.protobuf.e0.a, com.google.protobuf.d0.a
            public ConvertData buildPartial() {
                ConvertData convertData = new ConvertData(this);
                convertData.offset_ = this.offset_;
                convertData.duration_ = this.duration_;
                convertData.speaker_ = this.speaker_;
                convertData.text_ = this.text_;
                convertData.summary_ = this.summary_;
                if ((this.bitField0_ & 32) == 32) {
                    this.paragraphKeywords_ = this.paragraphKeywords_.u0();
                    this.bitField0_ &= -33;
                }
                convertData.paragraphKeywords_ = this.paragraphKeywords_;
                convertData.channel_ = this.channel_;
                convertData.id_ = this.id_;
                convertData.modifiedText_ = this.modifiedText_;
                convertData.speakerName_ = this.speakerName_;
                convertData.bitField0_ = 0;
                onBuilt();
                return convertData;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.f0, com.google.protobuf.g0
            public ConvertData getDefaultInstanceForType() {
                return ConvertData.getDefaultInstance();
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
                this.offset_ = 0;
                this.duration_ = 0;
                this.speaker_ = "";
                this.text_ = "";
                this.summary_ = "";
                this.paragraphKeywords_ = x.f13385d;
                this.bitField0_ &= -33;
                this.channel_ = 0;
                this.id_ = 0;
                this.modifiedText_ = "";
                this.speakerName_ = "";
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a, com.google.protobuf.b.a
            public Builder clone() {
                return (Builder) super.clone();
            }

            @Override // com.google.protobuf.a.AbstractC0170a, com.google.protobuf.d0.a
            public Builder mergeFrom(d0 d0Var) {
                if (d0Var instanceof ConvertData) {
                    return mergeFrom((ConvertData) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            public Builder mergeFrom(ConvertData convertData) {
                if (convertData == ConvertData.getDefaultInstance()) {
                    return this;
                }
                if (convertData.getOffset() != 0) {
                    setOffset(convertData.getOffset());
                }
                if (convertData.getDuration() != 0) {
                    setDuration(convertData.getDuration());
                }
                if (!convertData.getSpeaker().isEmpty()) {
                    this.speaker_ = convertData.speaker_;
                    onChanged();
                }
                if (!convertData.getText().isEmpty()) {
                    this.text_ = convertData.text_;
                    onChanged();
                }
                if (!convertData.getSummary().isEmpty()) {
                    this.summary_ = convertData.summary_;
                    onChanged();
                }
                if (!convertData.paragraphKeywords_.isEmpty()) {
                    if (this.paragraphKeywords_.isEmpty()) {
                        this.paragraphKeywords_ = convertData.paragraphKeywords_;
                        this.bitField0_ &= -33;
                    } else {
                        ensureParagraphKeywordsIsMutable();
                        this.paragraphKeywords_.addAll(convertData.paragraphKeywords_);
                    }
                    onChanged();
                }
                if (convertData.channel_ != 0) {
                    setChannelValue(convertData.getChannelValue());
                }
                if (convertData.getId() != 0) {
                    setId(convertData.getId());
                }
                if (!convertData.getModifiedText().isEmpty()) {
                    this.modifiedText_ = convertData.modifiedText_;
                    onChanged();
                }
                if (!convertData.getSpeakerName().isEmpty()) {
                    this.speakerName_ = convertData.speakerName_;
                    onChanged();
                }
                onChanged();
                return this;
            }

            private Builder(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.speaker_ = "";
                this.text_ = "";
                this.summary_ = "";
                this.paragraphKeywords_ = x.f13385d;
                this.channel_ = 0;
                this.modifiedText_ = "";
                this.speakerName_ = "";
                maybeForceBuilderInitialization();
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x0023  */
            @Override // com.google.protobuf.a.AbstractC0170a, com.google.protobuf.b.a, com.google.protobuf.e0.a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(i iVar, q qVar) throws IOException {
                Throwable th2;
                ConvertData convertData = null;
                try {
                    try {
                        ConvertData convertData2 = (ConvertData) ConvertData.PARSER.parsePartialFrom(iVar, qVar);
                        if (convertData2 != null) {
                            mergeFrom(convertData2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e10) {
                        convertData = (ConvertData) e10.getUnfinishedMessage();
                        try {
                            throw e10.unwrapIOException();
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (convertData != null) {
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (convertData != null) {
                        mergeFrom(convertData);
                    }
                    throw th2;
                }
            }
        }

        public static ConvertData getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return SoundProto.internal_static_com_mobvoi_companion_proto_ConvertData_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static ConvertData parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ConvertData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static ConvertData parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static l0<ConvertData> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ConvertData)) {
                return super.equals(obj);
            }
            ConvertData convertData = (ConvertData) obj;
            return (((((((((getOffset() == convertData.getOffset()) && getDuration() == convertData.getDuration()) && getSpeaker().equals(convertData.getSpeaker())) && getText().equals(convertData.getText())) && getSummary().equals(convertData.getSummary())) && getParagraphKeywordsList().equals(convertData.getParagraphKeywordsList())) && this.channel_ == convertData.channel_) && getId() == convertData.getId()) && getModifiedText().equals(convertData.getModifiedText())) && getSpeakerName().equals(convertData.getSpeakerName());
        }

        @Override // com.mobvoi.companion.proto.SoundProto.ConvertDataOrBuilder
        public Channel getChannel() {
            Channel valueOf = Channel.valueOf(this.channel_);
            return valueOf == null ? Channel.UNRECOGNIZED : valueOf;
        }

        @Override // com.mobvoi.companion.proto.SoundProto.ConvertDataOrBuilder
        public int getChannelValue() {
            return this.channel_;
        }

        @Override // com.mobvoi.companion.proto.SoundProto.ConvertDataOrBuilder
        public int getDuration() {
            return this.duration_;
        }

        @Override // com.mobvoi.companion.proto.SoundProto.ConvertDataOrBuilder
        public int getId() {
            return this.id_;
        }

        @Override // com.mobvoi.companion.proto.SoundProto.ConvertDataOrBuilder
        public String getModifiedText() {
            Object obj = this.modifiedText_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.modifiedText_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.proto.SoundProto.ConvertDataOrBuilder
        public ByteString getModifiedTextBytes() {
            Object obj = this.modifiedText_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.modifiedText_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.mobvoi.companion.proto.SoundProto.ConvertDataOrBuilder
        public int getOffset() {
            return this.offset_;
        }

        @Override // com.mobvoi.companion.proto.SoundProto.ConvertDataOrBuilder
        public String getParagraphKeywords(int i10) {
            return this.paragraphKeywords_.get(i10);
        }

        @Override // com.mobvoi.companion.proto.SoundProto.ConvertDataOrBuilder
        public ByteString getParagraphKeywordsBytes(int i10) {
            return this.paragraphKeywords_.o0(i10);
        }

        @Override // com.mobvoi.companion.proto.SoundProto.ConvertDataOrBuilder
        public int getParagraphKeywordsCount() {
            return this.paragraphKeywords_.size();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public l0<ConvertData> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
        public int getSerializedSize() {
            int i10 = this.memoizedSize;
            if (i10 != -1) {
                return i10;
            }
            int i11 = this.offset_;
            int v10 = i11 != 0 ? CodedOutputStream.v(1, i11) + 0 : 0;
            int i12 = this.duration_;
            if (i12 != 0) {
                v10 += CodedOutputStream.v(2, i12);
            }
            if (!getSpeakerBytes().isEmpty()) {
                v10 += GeneratedMessageV3.computeStringSize(3, this.speaker_);
            }
            if (!getTextBytes().isEmpty()) {
                v10 += GeneratedMessageV3.computeStringSize(4, this.text_);
            }
            if (!getSummaryBytes().isEmpty()) {
                v10 += GeneratedMessageV3.computeStringSize(5, this.summary_);
            }
            int i13 = 0;
            for (int i14 = 0; i14 < this.paragraphKeywords_.size(); i14++) {
                i13 += GeneratedMessageV3.computeStringSizeNoTag(this.paragraphKeywords_.z0(i14));
            }
            int size = v10 + i13 + (getParagraphKeywordsList().size() * 1);
            if (this.channel_ != Channel.LEFT.getNumber()) {
                size += CodedOutputStream.l(7, this.channel_);
            }
            int i15 = this.id_;
            if (i15 != 0) {
                size += CodedOutputStream.v(8, i15);
            }
            if (!getModifiedTextBytes().isEmpty()) {
                size += GeneratedMessageV3.computeStringSize(9, this.modifiedText_);
            }
            if (!getSpeakerNameBytes().isEmpty()) {
                size += GeneratedMessageV3.computeStringSize(10, this.speakerName_);
            }
            this.memoizedSize = size;
            return size;
        }

        @Override // com.mobvoi.companion.proto.SoundProto.ConvertDataOrBuilder
        public String getSpeaker() {
            Object obj = this.speaker_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.speaker_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.proto.SoundProto.ConvertDataOrBuilder
        public ByteString getSpeakerBytes() {
            Object obj = this.speaker_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.speaker_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.mobvoi.companion.proto.SoundProto.ConvertDataOrBuilder
        public String getSpeakerName() {
            Object obj = this.speakerName_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.speakerName_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.proto.SoundProto.ConvertDataOrBuilder
        public ByteString getSpeakerNameBytes() {
            Object obj = this.speakerName_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.speakerName_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.mobvoi.companion.proto.SoundProto.ConvertDataOrBuilder
        public String getSummary() {
            Object obj = this.summary_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.summary_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.proto.SoundProto.ConvertDataOrBuilder
        public ByteString getSummaryBytes() {
            Object obj = this.summary_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.summary_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.mobvoi.companion.proto.SoundProto.ConvertDataOrBuilder
        public String getText() {
            Object obj = this.text_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.text_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.proto.SoundProto.ConvertDataOrBuilder
        public ByteString getTextBytes() {
            Object obj = this.text_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.text_ = copyFromUtf8;
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
            int hashCode = ((((((((((((((((((((779 + getDescriptorForType().hashCode()) * 37) + 1) * 53) + getOffset()) * 37) + 2) * 53) + getDuration()) * 37) + 3) * 53) + getSpeaker().hashCode()) * 37) + 4) * 53) + getText().hashCode()) * 37) + 5) * 53) + getSummary().hashCode();
            if (getParagraphKeywordsCount() > 0) {
                hashCode = (((hashCode * 37) + 6) * 53) + getParagraphKeywordsList().hashCode();
            }
            int id2 = (((((((((((((((((hashCode * 37) + 7) * 53) + this.channel_) * 37) + 8) * 53) + getId()) * 37) + 9) * 53) + getModifiedText().hashCode()) * 37) + 10) * 53) + getSpeakerName().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = id2;
            return id2;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return SoundProto.internal_static_com_mobvoi_companion_proto_ConvertData_fieldAccessorTable.e(ConvertData.class, Builder.class);
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
            int i10 = this.offset_;
            if (i10 != 0) {
                codedOutputStream.w0(1, i10);
            }
            int i11 = this.duration_;
            if (i11 != 0) {
                codedOutputStream.w0(2, i11);
            }
            if (!getSpeakerBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 3, this.speaker_);
            }
            if (!getTextBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 4, this.text_);
            }
            if (!getSummaryBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 5, this.summary_);
            }
            for (int i12 = 0; i12 < this.paragraphKeywords_.size(); i12++) {
                GeneratedMessageV3.writeString(codedOutputStream, 6, this.paragraphKeywords_.z0(i12));
            }
            if (this.channel_ != Channel.LEFT.getNumber()) {
                codedOutputStream.m0(7, this.channel_);
            }
            int i13 = this.id_;
            if (i13 != 0) {
                codedOutputStream.w0(8, i13);
            }
            if (!getModifiedTextBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 9, this.modifiedText_);
            }
            if (!getSpeakerNameBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 10, this.speakerName_);
            }
        }

        public static Builder newBuilder(ConvertData convertData) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(convertData);
        }

        public static ConvertData parseFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, qVar);
        }

        @Override // com.mobvoi.companion.proto.SoundProto.ConvertDataOrBuilder
        public n0 getParagraphKeywordsList() {
            return this.paragraphKeywords_;
        }

        private ConvertData(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static ConvertData parseDelimitedFrom(InputStream inputStream, q qVar) throws IOException {
            return (ConvertData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
        }

        public static ConvertData parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
        public ConvertData getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static ConvertData parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder newBuilderForType() {
            return newBuilder();
        }

        private ConvertData() {
            this.memoizedIsInitialized = (byte) -1;
            this.offset_ = 0;
            this.duration_ = 0;
            this.speaker_ = "";
            this.text_ = "";
            this.summary_ = "";
            this.paragraphKeywords_ = x.f13385d;
            this.channel_ = 0;
            this.id_ = 0;
            this.modifiedText_ = "";
            this.speakerName_ = "";
        }

        public static ConvertData parseFrom(InputStream inputStream) throws IOException {
            return (ConvertData) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.c cVar) {
            return new Builder(cVar);
        }

        public static ConvertData parseFrom(InputStream inputStream, q qVar) throws IOException {
            return (ConvertData) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
        }

        public static ConvertData parseFrom(i iVar) throws IOException {
            return (ConvertData) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
        }

        public static ConvertData parseFrom(i iVar, q qVar) throws IOException {
            return (ConvertData) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v1 */
        /* JADX WARN: Type inference failed for: r1v2, types: [boolean] */
        private ConvertData(i iVar, q qVar) throws InvalidProtocolBufferException {
            this();
            boolean z10 = false;
            boolean z11 = false;
            while (true) {
                ?? r12 = 32;
                if (!z10) {
                    try {
                        try {
                            try {
                                int F = iVar.F();
                                z10 = true;
                                switch (F) {
                                    case 0:
                                        break;
                                    case 8:
                                        this.offset_ = iVar.t();
                                        continue;
                                    case 16:
                                        this.duration_ = iVar.t();
                                        continue;
                                    case 26:
                                        this.speaker_ = iVar.E();
                                        continue;
                                    case 34:
                                        this.text_ = iVar.E();
                                        continue;
                                    case 42:
                                        this.summary_ = iVar.E();
                                        continue;
                                    case 50:
                                        String E = iVar.E();
                                        if (!(z11 & true)) {
                                            this.paragraphKeywords_ = new x();
                                            z11 |= true;
                                        }
                                        this.paragraphKeywords_.add(E);
                                        continue;
                                    case 56:
                                        this.channel_ = iVar.o();
                                        continue;
                                    case 64:
                                        this.id_ = iVar.t();
                                        continue;
                                    case 74:
                                        this.modifiedText_ = iVar.E();
                                        continue;
                                    case 82:
                                        this.speakerName_ = iVar.E();
                                        continue;
                                    default:
                                        r12 = iVar.I(F);
                                        if (r12 == 0) {
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
                        if ((z11 & true) == r12) {
                            this.paragraphKeywords_ = this.paragraphKeywords_.u0();
                        }
                        makeExtensionsImmutable();
                    }
                } else {
                    return;
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface ConvertDataOrBuilder extends g0 {
        /* synthetic */ List<String> findInitializationErrors();

        @Override // com.google.protobuf.g0
        /* synthetic */ Map<Descriptors.FieldDescriptor, Object> getAllFields();

        Channel getChannel();

        int getChannelValue();

        @Override // com.google.protobuf.g0
        /* synthetic */ d0 getDefaultInstanceForType();

        @Override // com.google.protobuf.g0
        /* synthetic */ e0 getDefaultInstanceForType();

        @Override // com.google.protobuf.g0
        /* synthetic */ Descriptors.b getDescriptorForType();

        int getDuration();

        @Override // com.google.protobuf.g0
        /* synthetic */ Object getField(Descriptors.FieldDescriptor fieldDescriptor);

        int getId();

        /* synthetic */ String getInitializationErrorString();

        String getModifiedText();

        ByteString getModifiedTextBytes();

        int getOffset();

        /* synthetic */ Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.h hVar);

        String getParagraphKeywords(int i10);

        ByteString getParagraphKeywordsBytes(int i10);

        int getParagraphKeywordsCount();

        List<String> getParagraphKeywordsList();

        /* synthetic */ Object getRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i10);

        /* synthetic */ int getRepeatedFieldCount(Descriptors.FieldDescriptor fieldDescriptor);

        String getSpeaker();

        ByteString getSpeakerBytes();

        String getSpeakerName();

        ByteString getSpeakerNameBytes();

        String getSummary();

        ByteString getSummaryBytes();

        String getText();

        ByteString getTextBytes();

        @Override // com.google.protobuf.g0
        /* synthetic */ a1 getUnknownFields();

        @Override // com.google.protobuf.g0
        /* synthetic */ boolean hasField(Descriptors.FieldDescriptor fieldDescriptor);

        /* synthetic */ boolean hasOneof(Descriptors.h hVar);

        @Override // com.google.protobuf.f0
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes2.dex */
    public static final class ConvertDataUpdateReq extends GeneratedMessageV3 implements ConvertDataUpdateReqOrBuilder {
        public static final int DATA_FIELD_NUMBER = 1;
        private static final ConvertDataUpdateReq DEFAULT_INSTANCE = new ConvertDataUpdateReq();
        private static final l0<ConvertDataUpdateReq> PARSER = new c<ConvertDataUpdateReq>() { // from class: com.mobvoi.companion.proto.SoundProto.ConvertDataUpdateReq.1
            @Override // com.google.protobuf.l0
            public ConvertDataUpdateReq parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
                return new ConvertDataUpdateReq(iVar, qVar);
            }
        };
        private static final long serialVersionUID = 0;
        private List<ConvertData> data_;
        private byte memoizedIsInitialized;

        public static ConvertDataUpdateReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return SoundProto.internal_static_com_mobvoi_companion_proto_ConvertDataUpdateReq_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static ConvertDataUpdateReq parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ConvertDataUpdateReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static ConvertDataUpdateReq parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static l0<ConvertDataUpdateReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ConvertDataUpdateReq)) {
                return super.equals(obj);
            }
            return getDataList().equals(((ConvertDataUpdateReq) obj).getDataList());
        }

        @Override // com.mobvoi.companion.proto.SoundProto.ConvertDataUpdateReqOrBuilder
        public ConvertData getData(int i10) {
            return this.data_.get(i10);
        }

        @Override // com.mobvoi.companion.proto.SoundProto.ConvertDataUpdateReqOrBuilder
        public int getDataCount() {
            return this.data_.size();
        }

        @Override // com.mobvoi.companion.proto.SoundProto.ConvertDataUpdateReqOrBuilder
        public List<ConvertData> getDataList() {
            return this.data_;
        }

        @Override // com.mobvoi.companion.proto.SoundProto.ConvertDataUpdateReqOrBuilder
        public ConvertDataOrBuilder getDataOrBuilder(int i10) {
            return this.data_.get(i10);
        }

        @Override // com.mobvoi.companion.proto.SoundProto.ConvertDataUpdateReqOrBuilder
        public List<? extends ConvertDataOrBuilder> getDataOrBuilderList() {
            return this.data_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public l0<ConvertDataUpdateReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
        public int getSerializedSize() {
            int i10 = this.memoizedSize;
            if (i10 != -1) {
                return i10;
            }
            int i11 = 0;
            for (int i12 = 0; i12 < this.data_.size(); i12++) {
                i11 += CodedOutputStream.E(1, this.data_.get(i12));
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
            if (getDataCount() > 0) {
                hashCode = (((hashCode * 37) + 1) * 53) + getDataList().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return SoundProto.internal_static_com_mobvoi_companion_proto_ConvertDataUpdateReq_fieldAccessorTable.e(ConvertDataUpdateReq.class, Builder.class);
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
            for (int i10 = 0; i10 < this.data_.size(); i10++) {
                codedOutputStream.A0(1, this.data_.get(i10));
            }
        }

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageV3.b<Builder> implements ConvertDataUpdateReqOrBuilder {
            private int bitField0_;
            private o0<ConvertData, ConvertData.Builder, ConvertDataOrBuilder> dataBuilder_;
            private List<ConvertData> data_;

            private void ensureDataIsMutable() {
                if ((this.bitField0_ & 1) != 1) {
                    this.data_ = new ArrayList(this.data_);
                    this.bitField0_ |= 1;
                }
            }

            private o0<ConvertData, ConvertData.Builder, ConvertDataOrBuilder> getDataFieldBuilder() {
                if (this.dataBuilder_ == null) {
                    List<ConvertData> list = this.data_;
                    boolean z10 = true;
                    if ((this.bitField0_ & 1) != 1) {
                        z10 = false;
                    }
                    this.dataBuilder_ = new o0<>(list, z10, getParentForChildren(), isClean());
                    this.data_ = null;
                }
                return this.dataBuilder_;
            }

            public static final Descriptors.b getDescriptor() {
                return SoundProto.internal_static_com_mobvoi_companion_proto_ConvertDataUpdateReq_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                    getDataFieldBuilder();
                }
            }

            public Builder addAllData(Iterable<? extends ConvertData> iterable) {
                o0<ConvertData, ConvertData.Builder, ConvertDataOrBuilder> o0Var = this.dataBuilder_;
                if (o0Var == null) {
                    ensureDataIsMutable();
                    b.a.addAll(iterable, this.data_);
                    onChanged();
                } else {
                    o0Var.b(iterable);
                }
                return this;
            }

            public Builder addData(ConvertData convertData) {
                o0<ConvertData, ConvertData.Builder, ConvertDataOrBuilder> o0Var = this.dataBuilder_;
                if (o0Var == null) {
                    Objects.requireNonNull(convertData);
                    ensureDataIsMutable();
                    this.data_.add(convertData);
                    onChanged();
                } else {
                    o0Var.f(convertData);
                }
                return this;
            }

            public ConvertData.Builder addDataBuilder() {
                return getDataFieldBuilder().d(ConvertData.getDefaultInstance());
            }

            public Builder clearData() {
                o0<ConvertData, ConvertData.Builder, ConvertDataOrBuilder> o0Var = this.dataBuilder_;
                if (o0Var == null) {
                    this.data_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    o0Var.h();
                }
                return this;
            }

            @Override // com.mobvoi.companion.proto.SoundProto.ConvertDataUpdateReqOrBuilder
            public ConvertData getData(int i10) {
                o0<ConvertData, ConvertData.Builder, ConvertDataOrBuilder> o0Var = this.dataBuilder_;
                if (o0Var == null) {
                    return this.data_.get(i10);
                }
                return o0Var.o(i10);
            }

            public ConvertData.Builder getDataBuilder(int i10) {
                return getDataFieldBuilder().l(i10);
            }

            public List<ConvertData.Builder> getDataBuilderList() {
                return getDataFieldBuilder().m();
            }

            @Override // com.mobvoi.companion.proto.SoundProto.ConvertDataUpdateReqOrBuilder
            public int getDataCount() {
                o0<ConvertData, ConvertData.Builder, ConvertDataOrBuilder> o0Var = this.dataBuilder_;
                if (o0Var == null) {
                    return this.data_.size();
                }
                return o0Var.n();
            }

            @Override // com.mobvoi.companion.proto.SoundProto.ConvertDataUpdateReqOrBuilder
            public List<ConvertData> getDataList() {
                o0<ConvertData, ConvertData.Builder, ConvertDataOrBuilder> o0Var = this.dataBuilder_;
                if (o0Var == null) {
                    return Collections.unmodifiableList(this.data_);
                }
                return o0Var.q();
            }

            @Override // com.mobvoi.companion.proto.SoundProto.ConvertDataUpdateReqOrBuilder
            public ConvertDataOrBuilder getDataOrBuilder(int i10) {
                o0<ConvertData, ConvertData.Builder, ConvertDataOrBuilder> o0Var = this.dataBuilder_;
                if (o0Var == null) {
                    return this.data_.get(i10);
                }
                return o0Var.r(i10);
            }

            @Override // com.mobvoi.companion.proto.SoundProto.ConvertDataUpdateReqOrBuilder
            public List<? extends ConvertDataOrBuilder> getDataOrBuilderList() {
                o0<ConvertData, ConvertData.Builder, ConvertDataOrBuilder> o0Var = this.dataBuilder_;
                if (o0Var != null) {
                    return o0Var.s();
                }
                return Collections.unmodifiableList(this.data_);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a, com.google.protobuf.g0
            public Descriptors.b getDescriptorForType() {
                return SoundProto.internal_static_com_mobvoi_companion_proto_ConvertDataUpdateReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return SoundProto.internal_static_com_mobvoi_companion_proto_ConvertDataUpdateReq_fieldAccessorTable.e(ConvertDataUpdateReq.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.f0
            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a
            public final Builder mergeUnknownFields(a1 a1Var) {
                return this;
            }

            public Builder removeData(int i10) {
                o0<ConvertData, ConvertData.Builder, ConvertDataOrBuilder> o0Var = this.dataBuilder_;
                if (o0Var == null) {
                    ensureDataIsMutable();
                    this.data_.remove(i10);
                    onChanged();
                } else {
                    o0Var.w(i10);
                }
                return this;
            }

            public Builder setData(int i10, ConvertData convertData) {
                o0<ConvertData, ConvertData.Builder, ConvertDataOrBuilder> o0Var = this.dataBuilder_;
                if (o0Var == null) {
                    Objects.requireNonNull(convertData);
                    ensureDataIsMutable();
                    this.data_.set(i10, convertData);
                    onChanged();
                } else {
                    o0Var.x(i10, convertData);
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public final Builder setUnknownFields(a1 a1Var) {
                return this;
            }

            private Builder() {
                this.data_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.e0.a, com.google.protobuf.d0.a
            public ConvertDataUpdateReq build() {
                ConvertDataUpdateReq buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) buildPartial);
            }

            @Override // com.google.protobuf.e0.a, com.google.protobuf.d0.a
            public ConvertDataUpdateReq buildPartial() {
                ConvertDataUpdateReq convertDataUpdateReq = new ConvertDataUpdateReq(this);
                int i10 = this.bitField0_;
                o0<ConvertData, ConvertData.Builder, ConvertDataOrBuilder> o0Var = this.dataBuilder_;
                if (o0Var == null) {
                    if ((i10 & 1) == 1) {
                        this.data_ = Collections.unmodifiableList(this.data_);
                        this.bitField0_ &= -2;
                    }
                    convertDataUpdateReq.data_ = this.data_;
                } else {
                    convertDataUpdateReq.data_ = o0Var.g();
                }
                onBuilt();
                return convertDataUpdateReq;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.f0, com.google.protobuf.g0
            public ConvertDataUpdateReq getDefaultInstanceForType() {
                return ConvertDataUpdateReq.getDefaultInstance();
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

            public ConvertData.Builder addDataBuilder(int i10) {
                return getDataFieldBuilder().c(i10, ConvertData.getDefaultInstance());
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a
            public Builder clearOneof(Descriptors.h hVar) {
                return (Builder) super.clearOneof(hVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a
            public Builder clear() {
                super.clear();
                o0<ConvertData, ConvertData.Builder, ConvertDataOrBuilder> o0Var = this.dataBuilder_;
                if (o0Var == null) {
                    this.data_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    o0Var.h();
                }
                return this;
            }

            private Builder(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.data_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            public Builder addData(int i10, ConvertData convertData) {
                o0<ConvertData, ConvertData.Builder, ConvertDataOrBuilder> o0Var = this.dataBuilder_;
                if (o0Var == null) {
                    Objects.requireNonNull(convertData);
                    ensureDataIsMutable();
                    this.data_.add(i10, convertData);
                    onChanged();
                } else {
                    o0Var.e(i10, convertData);
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a, com.google.protobuf.b.a
            public Builder clone() {
                return (Builder) super.clone();
            }

            @Override // com.google.protobuf.a.AbstractC0170a, com.google.protobuf.d0.a
            public Builder mergeFrom(d0 d0Var) {
                if (d0Var instanceof ConvertDataUpdateReq) {
                    return mergeFrom((ConvertDataUpdateReq) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            public Builder setData(int i10, ConvertData.Builder builder) {
                o0<ConvertData, ConvertData.Builder, ConvertDataOrBuilder> o0Var = this.dataBuilder_;
                if (o0Var == null) {
                    ensureDataIsMutable();
                    this.data_.set(i10, builder.build());
                    onChanged();
                } else {
                    o0Var.x(i10, builder.build());
                }
                return this;
            }

            public Builder mergeFrom(ConvertDataUpdateReq convertDataUpdateReq) {
                if (convertDataUpdateReq == ConvertDataUpdateReq.getDefaultInstance()) {
                    return this;
                }
                if (this.dataBuilder_ == null) {
                    if (!convertDataUpdateReq.data_.isEmpty()) {
                        if (this.data_.isEmpty()) {
                            this.data_ = convertDataUpdateReq.data_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureDataIsMutable();
                            this.data_.addAll(convertDataUpdateReq.data_);
                        }
                        onChanged();
                    }
                } else if (!convertDataUpdateReq.data_.isEmpty()) {
                    if (this.dataBuilder_.u()) {
                        this.dataBuilder_.i();
                        o0<ConvertData, ConvertData.Builder, ConvertDataOrBuilder> o0Var = null;
                        this.dataBuilder_ = null;
                        this.data_ = convertDataUpdateReq.data_;
                        this.bitField0_ &= -2;
                        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                            o0Var = getDataFieldBuilder();
                        }
                        this.dataBuilder_ = o0Var;
                    } else {
                        this.dataBuilder_.b(convertDataUpdateReq.data_);
                    }
                }
                onChanged();
                return this;
            }

            public Builder addData(ConvertData.Builder builder) {
                o0<ConvertData, ConvertData.Builder, ConvertDataOrBuilder> o0Var = this.dataBuilder_;
                if (o0Var == null) {
                    ensureDataIsMutable();
                    this.data_.add(builder.build());
                    onChanged();
                } else {
                    o0Var.f(builder.build());
                }
                return this;
            }

            public Builder addData(int i10, ConvertData.Builder builder) {
                o0<ConvertData, ConvertData.Builder, ConvertDataOrBuilder> o0Var = this.dataBuilder_;
                if (o0Var == null) {
                    ensureDataIsMutable();
                    this.data_.add(i10, builder.build());
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
                ConvertDataUpdateReq convertDataUpdateReq = null;
                try {
                    try {
                        ConvertDataUpdateReq convertDataUpdateReq2 = (ConvertDataUpdateReq) ConvertDataUpdateReq.PARSER.parsePartialFrom(iVar, qVar);
                        if (convertDataUpdateReq2 != null) {
                            mergeFrom(convertDataUpdateReq2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e10) {
                        convertDataUpdateReq = (ConvertDataUpdateReq) e10.getUnfinishedMessage();
                        try {
                            throw e10.unwrapIOException();
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (convertDataUpdateReq != null) {
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (convertDataUpdateReq != null) {
                        mergeFrom(convertDataUpdateReq);
                    }
                    throw th2;
                }
            }
        }

        public static Builder newBuilder(ConvertDataUpdateReq convertDataUpdateReq) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(convertDataUpdateReq);
        }

        public static ConvertDataUpdateReq parseFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, qVar);
        }

        private ConvertDataUpdateReq(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static ConvertDataUpdateReq parseDelimitedFrom(InputStream inputStream, q qVar) throws IOException {
            return (ConvertDataUpdateReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
        }

        public static ConvertDataUpdateReq parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
        public ConvertDataUpdateReq getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static ConvertDataUpdateReq parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder newBuilderForType() {
            return newBuilder();
        }

        private ConvertDataUpdateReq() {
            this.memoizedIsInitialized = (byte) -1;
            this.data_ = Collections.emptyList();
        }

        public static ConvertDataUpdateReq parseFrom(InputStream inputStream) throws IOException {
            return (ConvertDataUpdateReq) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.c cVar) {
            return new Builder(cVar);
        }

        public static ConvertDataUpdateReq parseFrom(InputStream inputStream, q qVar) throws IOException {
            return (ConvertDataUpdateReq) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
        }

        private ConvertDataUpdateReq(i iVar, q qVar) throws InvalidProtocolBufferException {
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
                                    this.data_ = new ArrayList();
                                    z11 |= true;
                                }
                                this.data_.add((ConvertData) iVar.v(ConvertData.parser(), qVar));
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
                        this.data_ = Collections.unmodifiableList(this.data_);
                    }
                    makeExtensionsImmutable();
                }
            }
        }

        public static ConvertDataUpdateReq parseFrom(i iVar) throws IOException {
            return (ConvertDataUpdateReq) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
        }

        public static ConvertDataUpdateReq parseFrom(i iVar, q qVar) throws IOException {
            return (ConvertDataUpdateReq) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
        }
    }

    /* loaded from: classes2.dex */
    public interface ConvertDataUpdateReqOrBuilder extends g0 {
        /* synthetic */ List<String> findInitializationErrors();

        @Override // com.google.protobuf.g0
        /* synthetic */ Map<Descriptors.FieldDescriptor, Object> getAllFields();

        ConvertData getData(int i10);

        int getDataCount();

        List<ConvertData> getDataList();

        ConvertDataOrBuilder getDataOrBuilder(int i10);

        List<? extends ConvertDataOrBuilder> getDataOrBuilderList();

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
    public enum FileStatus implements m0 {
        DEFAULT(0),
        CONVERTING(1),
        CONVERTED(2),
        CONVERT_FAILED(3),
        UNRECOGNIZED(-1);
        
        public static final int CONVERTED_VALUE = 2;
        public static final int CONVERTING_VALUE = 1;
        public static final int CONVERT_FAILED_VALUE = 3;
        public static final int DEFAULT_VALUE = 0;
        private final int value;
        private static final u.b<FileStatus> internalValueMap = new u.b<FileStatus>() { // from class: com.mobvoi.companion.proto.SoundProto.FileStatus.1
            public FileStatus findValueByNumber(int i10) {
                return FileStatus.forNumber(i10);
            }
        };
        private static final FileStatus[] VALUES = values();

        FileStatus(int i10) {
            this.value = i10;
        }

        public static FileStatus forNumber(int i10) {
            if (i10 == 0) {
                return DEFAULT;
            }
            if (i10 == 1) {
                return CONVERTING;
            }
            if (i10 == 2) {
                return CONVERTED;
            }
            if (i10 != 3) {
                return null;
            }
            return CONVERT_FAILED;
        }

        public static final Descriptors.d getDescriptor() {
            return SoundProto.getDescriptor().i().get(0);
        }

        public static u.b<FileStatus> internalGetValueMap() {
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
        public static FileStatus valueOf(int i10) {
            return forNumber(i10);
        }

        public static FileStatus valueOf(Descriptors.e eVar) {
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
    public static final class FileStatusDto extends GeneratedMessageV3 implements FileStatusDtoOrBuilder {
        public static final int FILE_ID_FIELD_NUMBER = 1;
        public static final int FILE_STATUS_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private volatile Object fileId_;
        private volatile Object fileStatus_;
        private byte memoizedIsInitialized;
        private static final FileStatusDto DEFAULT_INSTANCE = new FileStatusDto();
        private static final l0<FileStatusDto> PARSER = new c<FileStatusDto>() { // from class: com.mobvoi.companion.proto.SoundProto.FileStatusDto.1
            @Override // com.google.protobuf.l0
            public FileStatusDto parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
                return new FileStatusDto(iVar, qVar);
            }
        };

        public static FileStatusDto getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return SoundProto.internal_static_com_mobvoi_companion_proto_FileStatusDto_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static FileStatusDto parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (FileStatusDto) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static FileStatusDto parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static l0<FileStatusDto> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof FileStatusDto)) {
                return super.equals(obj);
            }
            FileStatusDto fileStatusDto = (FileStatusDto) obj;
            return (getFileId().equals(fileStatusDto.getFileId())) && getFileStatus().equals(fileStatusDto.getFileStatus());
        }

        @Override // com.mobvoi.companion.proto.SoundProto.FileStatusDtoOrBuilder
        public String getFileId() {
            Object obj = this.fileId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.fileId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.proto.SoundProto.FileStatusDtoOrBuilder
        public ByteString getFileIdBytes() {
            Object obj = this.fileId_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.fileId_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.mobvoi.companion.proto.SoundProto.FileStatusDtoOrBuilder
        public String getFileStatus() {
            Object obj = this.fileStatus_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.fileStatus_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.proto.SoundProto.FileStatusDtoOrBuilder
        public ByteString getFileStatusBytes() {
            Object obj = this.fileStatus_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.fileStatus_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public l0<FileStatusDto> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
        public int getSerializedSize() {
            int i10 = this.memoizedSize;
            if (i10 != -1) {
                return i10;
            }
            int i11 = 0;
            if (!getFileIdBytes().isEmpty()) {
                i11 = 0 + GeneratedMessageV3.computeStringSize(1, this.fileId_);
            }
            if (!getFileStatusBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(2, this.fileStatus_);
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
            int hashCode = ((((((((((779 + getDescriptorForType().hashCode()) * 37) + 1) * 53) + getFileId().hashCode()) * 37) + 2) * 53) + getFileStatus().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return SoundProto.internal_static_com_mobvoi_companion_proto_FileStatusDto_fieldAccessorTable.e(FileStatusDto.class, Builder.class);
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
            if (!getFileIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.fileId_);
            }
            if (!getFileStatusBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.fileStatus_);
            }
        }

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageV3.b<Builder> implements FileStatusDtoOrBuilder {
            private Object fileId_;
            private Object fileStatus_;

            public static final Descriptors.b getDescriptor() {
                return SoundProto.internal_static_com_mobvoi_companion_proto_FileStatusDto_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            public Builder clearFileId() {
                this.fileId_ = FileStatusDto.getDefaultInstance().getFileId();
                onChanged();
                return this;
            }

            public Builder clearFileStatus() {
                this.fileStatus_ = FileStatusDto.getDefaultInstance().getFileStatus();
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a, com.google.protobuf.g0
            public Descriptors.b getDescriptorForType() {
                return SoundProto.internal_static_com_mobvoi_companion_proto_FileStatusDto_descriptor;
            }

            @Override // com.mobvoi.companion.proto.SoundProto.FileStatusDtoOrBuilder
            public String getFileId() {
                Object obj = this.fileId_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.fileId_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.proto.SoundProto.FileStatusDtoOrBuilder
            public ByteString getFileIdBytes() {
                Object obj = this.fileId_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.fileId_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.mobvoi.companion.proto.SoundProto.FileStatusDtoOrBuilder
            public String getFileStatus() {
                Object obj = this.fileStatus_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.fileStatus_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.proto.SoundProto.FileStatusDtoOrBuilder
            public ByteString getFileStatusBytes() {
                Object obj = this.fileStatus_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.fileStatus_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return SoundProto.internal_static_com_mobvoi_companion_proto_FileStatusDto_fieldAccessorTable.e(FileStatusDto.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.f0
            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a
            public final Builder mergeUnknownFields(a1 a1Var) {
                return this;
            }

            public Builder setFileId(String str) {
                Objects.requireNonNull(str);
                this.fileId_ = str;
                onChanged();
                return this;
            }

            public Builder setFileIdBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                b.checkByteStringIsUtf8(byteString);
                this.fileId_ = byteString;
                onChanged();
                return this;
            }

            public Builder setFileStatus(String str) {
                Objects.requireNonNull(str);
                this.fileStatus_ = str;
                onChanged();
                return this;
            }

            public Builder setFileStatusBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                b.checkByteStringIsUtf8(byteString);
                this.fileStatus_ = byteString;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public final Builder setUnknownFields(a1 a1Var) {
                return this;
            }

            private Builder() {
                this.fileId_ = "";
                this.fileStatus_ = "";
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.e0.a, com.google.protobuf.d0.a
            public FileStatusDto build() {
                FileStatusDto buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) buildPartial);
            }

            @Override // com.google.protobuf.e0.a, com.google.protobuf.d0.a
            public FileStatusDto buildPartial() {
                FileStatusDto fileStatusDto = new FileStatusDto(this);
                fileStatusDto.fileId_ = this.fileId_;
                fileStatusDto.fileStatus_ = this.fileStatus_;
                onBuilt();
                return fileStatusDto;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.f0, com.google.protobuf.g0
            public FileStatusDto getDefaultInstanceForType() {
                return FileStatusDto.getDefaultInstance();
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
                this.fileId_ = "";
                this.fileStatus_ = "";
                return this;
            }

            private Builder(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.fileId_ = "";
                this.fileStatus_ = "";
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a, com.google.protobuf.b.a
            public Builder clone() {
                return (Builder) super.clone();
            }

            @Override // com.google.protobuf.a.AbstractC0170a, com.google.protobuf.d0.a
            public Builder mergeFrom(d0 d0Var) {
                if (d0Var instanceof FileStatusDto) {
                    return mergeFrom((FileStatusDto) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            public Builder mergeFrom(FileStatusDto fileStatusDto) {
                if (fileStatusDto == FileStatusDto.getDefaultInstance()) {
                    return this;
                }
                if (!fileStatusDto.getFileId().isEmpty()) {
                    this.fileId_ = fileStatusDto.fileId_;
                    onChanged();
                }
                if (!fileStatusDto.getFileStatus().isEmpty()) {
                    this.fileStatus_ = fileStatusDto.fileStatus_;
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
                FileStatusDto fileStatusDto = null;
                try {
                    try {
                        FileStatusDto fileStatusDto2 = (FileStatusDto) FileStatusDto.PARSER.parsePartialFrom(iVar, qVar);
                        if (fileStatusDto2 != null) {
                            mergeFrom(fileStatusDto2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e10) {
                        fileStatusDto = (FileStatusDto) e10.getUnfinishedMessage();
                        try {
                            throw e10.unwrapIOException();
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (fileStatusDto != null) {
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (fileStatusDto != null) {
                        mergeFrom(fileStatusDto);
                    }
                    throw th2;
                }
            }
        }

        public static Builder newBuilder(FileStatusDto fileStatusDto) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(fileStatusDto);
        }

        public static FileStatusDto parseFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, qVar);
        }

        private FileStatusDto(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static FileStatusDto parseDelimitedFrom(InputStream inputStream, q qVar) throws IOException {
            return (FileStatusDto) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
        }

        public static FileStatusDto parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
        public FileStatusDto getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static FileStatusDto parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder newBuilderForType() {
            return newBuilder();
        }

        private FileStatusDto() {
            this.memoizedIsInitialized = (byte) -1;
            this.fileId_ = "";
            this.fileStatus_ = "";
        }

        public static FileStatusDto parseFrom(InputStream inputStream) throws IOException {
            return (FileStatusDto) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.c cVar) {
            return new Builder(cVar);
        }

        public static FileStatusDto parseFrom(InputStream inputStream, q qVar) throws IOException {
            return (FileStatusDto) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
        }

        private FileStatusDto(i iVar, q qVar) throws InvalidProtocolBufferException {
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
                                    this.fileId_ = iVar.E();
                                } else if (F == 18) {
                                    this.fileStatus_ = iVar.E();
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

        public static FileStatusDto parseFrom(i iVar) throws IOException {
            return (FileStatusDto) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
        }

        public static FileStatusDto parseFrom(i iVar, q qVar) throws IOException {
            return (FileStatusDto) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
        }
    }

    /* loaded from: classes2.dex */
    public interface FileStatusDtoOrBuilder extends g0 {
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

        String getFileId();

        ByteString getFileIdBytes();

        String getFileStatus();

        ByteString getFileStatusBytes();

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
    public static final class LangInfo extends GeneratedMessageV3 implements LangInfoOrBuilder {
        public static final int CODE_FIELD_NUMBER = 2;
        public static final int NAME_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private volatile Object code_;
        private byte memoizedIsInitialized;
        private volatile Object name_;
        private static final LangInfo DEFAULT_INSTANCE = new LangInfo();
        private static final l0<LangInfo> PARSER = new c<LangInfo>() { // from class: com.mobvoi.companion.proto.SoundProto.LangInfo.1
            @Override // com.google.protobuf.l0
            public LangInfo parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
                return new LangInfo(iVar, qVar);
            }
        };

        public static LangInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return SoundProto.internal_static_com_mobvoi_companion_proto_LangInfo_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static LangInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (LangInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static LangInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static l0<LangInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof LangInfo)) {
                return super.equals(obj);
            }
            LangInfo langInfo = (LangInfo) obj;
            return (getName().equals(langInfo.getName())) && getCode().equals(langInfo.getCode());
        }

        @Override // com.mobvoi.companion.proto.SoundProto.LangInfoOrBuilder
        public String getCode() {
            Object obj = this.code_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.code_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.proto.SoundProto.LangInfoOrBuilder
        public ByteString getCodeBytes() {
            Object obj = this.code_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.code_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.mobvoi.companion.proto.SoundProto.LangInfoOrBuilder
        public String getName() {
            Object obj = this.name_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.name_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.proto.SoundProto.LangInfoOrBuilder
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
        public l0<LangInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
        public int getSerializedSize() {
            int i10 = this.memoizedSize;
            if (i10 != -1) {
                return i10;
            }
            int i11 = 0;
            if (!getNameBytes().isEmpty()) {
                i11 = 0 + GeneratedMessageV3.computeStringSize(1, this.name_);
            }
            if (!getCodeBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(2, this.code_);
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
            int hashCode = ((((((((((779 + getDescriptorForType().hashCode()) * 37) + 1) * 53) + getName().hashCode()) * 37) + 2) * 53) + getCode().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return SoundProto.internal_static_com_mobvoi_companion_proto_LangInfo_fieldAccessorTable.e(LangInfo.class, Builder.class);
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
            if (!getNameBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.name_);
            }
            if (!getCodeBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.code_);
            }
        }

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageV3.b<Builder> implements LangInfoOrBuilder {
            private Object code_;
            private Object name_;

            public static final Descriptors.b getDescriptor() {
                return SoundProto.internal_static_com_mobvoi_companion_proto_LangInfo_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            public Builder clearCode() {
                this.code_ = LangInfo.getDefaultInstance().getCode();
                onChanged();
                return this;
            }

            public Builder clearName() {
                this.name_ = LangInfo.getDefaultInstance().getName();
                onChanged();
                return this;
            }

            @Override // com.mobvoi.companion.proto.SoundProto.LangInfoOrBuilder
            public String getCode() {
                Object obj = this.code_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.code_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.proto.SoundProto.LangInfoOrBuilder
            public ByteString getCodeBytes() {
                Object obj = this.code_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.code_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a, com.google.protobuf.g0
            public Descriptors.b getDescriptorForType() {
                return SoundProto.internal_static_com_mobvoi_companion_proto_LangInfo_descriptor;
            }

            @Override // com.mobvoi.companion.proto.SoundProto.LangInfoOrBuilder
            public String getName() {
                Object obj = this.name_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.name_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.proto.SoundProto.LangInfoOrBuilder
            public ByteString getNameBytes() {
                Object obj = this.name_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.name_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return SoundProto.internal_static_com_mobvoi_companion_proto_LangInfo_fieldAccessorTable.e(LangInfo.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.f0
            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a
            public final Builder mergeUnknownFields(a1 a1Var) {
                return this;
            }

            public Builder setCode(String str) {
                Objects.requireNonNull(str);
                this.code_ = str;
                onChanged();
                return this;
            }

            public Builder setCodeBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                b.checkByteStringIsUtf8(byteString);
                this.code_ = byteString;
                onChanged();
                return this;
            }

            public Builder setName(String str) {
                Objects.requireNonNull(str);
                this.name_ = str;
                onChanged();
                return this;
            }

            public Builder setNameBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                b.checkByteStringIsUtf8(byteString);
                this.name_ = byteString;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public final Builder setUnknownFields(a1 a1Var) {
                return this;
            }

            private Builder() {
                this.name_ = "";
                this.code_ = "";
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.e0.a, com.google.protobuf.d0.a
            public LangInfo build() {
                LangInfo buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) buildPartial);
            }

            @Override // com.google.protobuf.e0.a, com.google.protobuf.d0.a
            public LangInfo buildPartial() {
                LangInfo langInfo = new LangInfo(this);
                langInfo.name_ = this.name_;
                langInfo.code_ = this.code_;
                onBuilt();
                return langInfo;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.f0, com.google.protobuf.g0
            public LangInfo getDefaultInstanceForType() {
                return LangInfo.getDefaultInstance();
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
                this.name_ = "";
                this.code_ = "";
                return this;
            }

            private Builder(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.name_ = "";
                this.code_ = "";
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a, com.google.protobuf.b.a
            public Builder clone() {
                return (Builder) super.clone();
            }

            @Override // com.google.protobuf.a.AbstractC0170a, com.google.protobuf.d0.a
            public Builder mergeFrom(d0 d0Var) {
                if (d0Var instanceof LangInfo) {
                    return mergeFrom((LangInfo) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            public Builder mergeFrom(LangInfo langInfo) {
                if (langInfo == LangInfo.getDefaultInstance()) {
                    return this;
                }
                if (!langInfo.getName().isEmpty()) {
                    this.name_ = langInfo.name_;
                    onChanged();
                }
                if (!langInfo.getCode().isEmpty()) {
                    this.code_ = langInfo.code_;
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
                LangInfo langInfo = null;
                try {
                    try {
                        LangInfo langInfo2 = (LangInfo) LangInfo.PARSER.parsePartialFrom(iVar, qVar);
                        if (langInfo2 != null) {
                            mergeFrom(langInfo2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e10) {
                        langInfo = (LangInfo) e10.getUnfinishedMessage();
                        try {
                            throw e10.unwrapIOException();
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (langInfo != null) {
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (langInfo != null) {
                        mergeFrom(langInfo);
                    }
                    throw th2;
                }
            }
        }

        public static Builder newBuilder(LangInfo langInfo) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(langInfo);
        }

        public static LangInfo parseFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, qVar);
        }

        private LangInfo(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static LangInfo parseDelimitedFrom(InputStream inputStream, q qVar) throws IOException {
            return (LangInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
        }

        public static LangInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
        public LangInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static LangInfo parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder newBuilderForType() {
            return newBuilder();
        }

        private LangInfo() {
            this.memoizedIsInitialized = (byte) -1;
            this.name_ = "";
            this.code_ = "";
        }

        public static LangInfo parseFrom(InputStream inputStream) throws IOException {
            return (LangInfo) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.c cVar) {
            return new Builder(cVar);
        }

        public static LangInfo parseFrom(InputStream inputStream, q qVar) throws IOException {
            return (LangInfo) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
        }

        private LangInfo(i iVar, q qVar) throws InvalidProtocolBufferException {
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
                                    this.name_ = iVar.E();
                                } else if (F == 18) {
                                    this.code_ = iVar.E();
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

        public static LangInfo parseFrom(i iVar) throws IOException {
            return (LangInfo) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
        }

        public static LangInfo parseFrom(i iVar, q qVar) throws IOException {
            return (LangInfo) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
        }
    }

    /* loaded from: classes2.dex */
    public interface LangInfoOrBuilder extends g0 {
        /* synthetic */ List<String> findInitializationErrors();

        @Override // com.google.protobuf.g0
        /* synthetic */ Map<Descriptors.FieldDescriptor, Object> getAllFields();

        String getCode();

        ByteString getCodeBytes();

        @Override // com.google.protobuf.g0
        /* synthetic */ d0 getDefaultInstanceForType();

        @Override // com.google.protobuf.g0
        /* synthetic */ e0 getDefaultInstanceForType();

        @Override // com.google.protobuf.g0
        /* synthetic */ Descriptors.b getDescriptorForType();

        @Override // com.google.protobuf.g0
        /* synthetic */ Object getField(Descriptors.FieldDescriptor fieldDescriptor);

        /* synthetic */ String getInitializationErrorString();

        String getName();

        ByteString getNameBytes();

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
    public static final class ModifiedTextReq extends GeneratedMessageV3 implements ModifiedTextReqOrBuilder {
        public static final int FILE_ID_FIELD_NUMBER = 1;
        public static final int MODIFIED_TEXT_FIELD_NUMBER = 3;
        public static final int OFFSET_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private volatile Object fileId_;
        private byte memoizedIsInitialized;
        private volatile Object modifiedText_;
        private int offset_;
        private static final ModifiedTextReq DEFAULT_INSTANCE = new ModifiedTextReq();
        private static final l0<ModifiedTextReq> PARSER = new c<ModifiedTextReq>() { // from class: com.mobvoi.companion.proto.SoundProto.ModifiedTextReq.1
            @Override // com.google.protobuf.l0
            public ModifiedTextReq parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
                return new ModifiedTextReq(iVar, qVar);
            }
        };

        public static ModifiedTextReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return SoundProto.internal_static_com_mobvoi_companion_proto_ModifiedTextReq_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static ModifiedTextReq parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ModifiedTextReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static ModifiedTextReq parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static l0<ModifiedTextReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ModifiedTextReq)) {
                return super.equals(obj);
            }
            ModifiedTextReq modifiedTextReq = (ModifiedTextReq) obj;
            return ((getFileId().equals(modifiedTextReq.getFileId())) && getOffset() == modifiedTextReq.getOffset()) && getModifiedText().equals(modifiedTextReq.getModifiedText());
        }

        @Override // com.mobvoi.companion.proto.SoundProto.ModifiedTextReqOrBuilder
        public String getFileId() {
            Object obj = this.fileId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.fileId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.proto.SoundProto.ModifiedTextReqOrBuilder
        public ByteString getFileIdBytes() {
            Object obj = this.fileId_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.fileId_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.mobvoi.companion.proto.SoundProto.ModifiedTextReqOrBuilder
        public String getModifiedText() {
            Object obj = this.modifiedText_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.modifiedText_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.proto.SoundProto.ModifiedTextReqOrBuilder
        public ByteString getModifiedTextBytes() {
            Object obj = this.modifiedText_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.modifiedText_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.mobvoi.companion.proto.SoundProto.ModifiedTextReqOrBuilder
        public int getOffset() {
            return this.offset_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public l0<ModifiedTextReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
        public int getSerializedSize() {
            int i10 = this.memoizedSize;
            if (i10 != -1) {
                return i10;
            }
            int i11 = 0;
            if (!getFileIdBytes().isEmpty()) {
                i11 = 0 + GeneratedMessageV3.computeStringSize(1, this.fileId_);
            }
            int i12 = this.offset_;
            if (i12 != 0) {
                i11 += CodedOutputStream.v(2, i12);
            }
            if (!getModifiedTextBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(3, this.modifiedText_);
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
            int hashCode = ((((((((((((((779 + getDescriptorForType().hashCode()) * 37) + 1) * 53) + getFileId().hashCode()) * 37) + 2) * 53) + getOffset()) * 37) + 3) * 53) + getModifiedText().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return SoundProto.internal_static_com_mobvoi_companion_proto_ModifiedTextReq_fieldAccessorTable.e(ModifiedTextReq.class, Builder.class);
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
            if (!getFileIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.fileId_);
            }
            int i10 = this.offset_;
            if (i10 != 0) {
                codedOutputStream.w0(2, i10);
            }
            if (!getModifiedTextBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 3, this.modifiedText_);
            }
        }

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageV3.b<Builder> implements ModifiedTextReqOrBuilder {
            private Object fileId_;
            private Object modifiedText_;
            private int offset_;

            public static final Descriptors.b getDescriptor() {
                return SoundProto.internal_static_com_mobvoi_companion_proto_ModifiedTextReq_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            public Builder clearFileId() {
                this.fileId_ = ModifiedTextReq.getDefaultInstance().getFileId();
                onChanged();
                return this;
            }

            public Builder clearModifiedText() {
                this.modifiedText_ = ModifiedTextReq.getDefaultInstance().getModifiedText();
                onChanged();
                return this;
            }

            public Builder clearOffset() {
                this.offset_ = 0;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a, com.google.protobuf.g0
            public Descriptors.b getDescriptorForType() {
                return SoundProto.internal_static_com_mobvoi_companion_proto_ModifiedTextReq_descriptor;
            }

            @Override // com.mobvoi.companion.proto.SoundProto.ModifiedTextReqOrBuilder
            public String getFileId() {
                Object obj = this.fileId_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.fileId_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.proto.SoundProto.ModifiedTextReqOrBuilder
            public ByteString getFileIdBytes() {
                Object obj = this.fileId_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.fileId_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.mobvoi.companion.proto.SoundProto.ModifiedTextReqOrBuilder
            public String getModifiedText() {
                Object obj = this.modifiedText_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.modifiedText_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.proto.SoundProto.ModifiedTextReqOrBuilder
            public ByteString getModifiedTextBytes() {
                Object obj = this.modifiedText_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.modifiedText_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.mobvoi.companion.proto.SoundProto.ModifiedTextReqOrBuilder
            public int getOffset() {
                return this.offset_;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return SoundProto.internal_static_com_mobvoi_companion_proto_ModifiedTextReq_fieldAccessorTable.e(ModifiedTextReq.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.f0
            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a
            public final Builder mergeUnknownFields(a1 a1Var) {
                return this;
            }

            public Builder setFileId(String str) {
                Objects.requireNonNull(str);
                this.fileId_ = str;
                onChanged();
                return this;
            }

            public Builder setFileIdBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                b.checkByteStringIsUtf8(byteString);
                this.fileId_ = byteString;
                onChanged();
                return this;
            }

            public Builder setModifiedText(String str) {
                Objects.requireNonNull(str);
                this.modifiedText_ = str;
                onChanged();
                return this;
            }

            public Builder setModifiedTextBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                b.checkByteStringIsUtf8(byteString);
                this.modifiedText_ = byteString;
                onChanged();
                return this;
            }

            public Builder setOffset(int i10) {
                this.offset_ = i10;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public final Builder setUnknownFields(a1 a1Var) {
                return this;
            }

            private Builder() {
                this.fileId_ = "";
                this.modifiedText_ = "";
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.e0.a, com.google.protobuf.d0.a
            public ModifiedTextReq build() {
                ModifiedTextReq buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) buildPartial);
            }

            @Override // com.google.protobuf.e0.a, com.google.protobuf.d0.a
            public ModifiedTextReq buildPartial() {
                ModifiedTextReq modifiedTextReq = new ModifiedTextReq(this);
                modifiedTextReq.fileId_ = this.fileId_;
                modifiedTextReq.offset_ = this.offset_;
                modifiedTextReq.modifiedText_ = this.modifiedText_;
                onBuilt();
                return modifiedTextReq;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.f0, com.google.protobuf.g0
            public ModifiedTextReq getDefaultInstanceForType() {
                return ModifiedTextReq.getDefaultInstance();
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
                this.fileId_ = "";
                this.offset_ = 0;
                this.modifiedText_ = "";
                return this;
            }

            private Builder(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.fileId_ = "";
                this.modifiedText_ = "";
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a, com.google.protobuf.b.a
            public Builder clone() {
                return (Builder) super.clone();
            }

            @Override // com.google.protobuf.a.AbstractC0170a, com.google.protobuf.d0.a
            public Builder mergeFrom(d0 d0Var) {
                if (d0Var instanceof ModifiedTextReq) {
                    return mergeFrom((ModifiedTextReq) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            public Builder mergeFrom(ModifiedTextReq modifiedTextReq) {
                if (modifiedTextReq == ModifiedTextReq.getDefaultInstance()) {
                    return this;
                }
                if (!modifiedTextReq.getFileId().isEmpty()) {
                    this.fileId_ = modifiedTextReq.fileId_;
                    onChanged();
                }
                if (modifiedTextReq.getOffset() != 0) {
                    setOffset(modifiedTextReq.getOffset());
                }
                if (!modifiedTextReq.getModifiedText().isEmpty()) {
                    this.modifiedText_ = modifiedTextReq.modifiedText_;
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
                ModifiedTextReq modifiedTextReq = null;
                try {
                    try {
                        ModifiedTextReq modifiedTextReq2 = (ModifiedTextReq) ModifiedTextReq.PARSER.parsePartialFrom(iVar, qVar);
                        if (modifiedTextReq2 != null) {
                            mergeFrom(modifiedTextReq2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e10) {
                        modifiedTextReq = (ModifiedTextReq) e10.getUnfinishedMessage();
                        try {
                            throw e10.unwrapIOException();
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (modifiedTextReq != null) {
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (modifiedTextReq != null) {
                        mergeFrom(modifiedTextReq);
                    }
                    throw th2;
                }
            }
        }

        public static Builder newBuilder(ModifiedTextReq modifiedTextReq) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(modifiedTextReq);
        }

        public static ModifiedTextReq parseFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, qVar);
        }

        private ModifiedTextReq(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static ModifiedTextReq parseDelimitedFrom(InputStream inputStream, q qVar) throws IOException {
            return (ModifiedTextReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
        }

        public static ModifiedTextReq parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
        public ModifiedTextReq getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static ModifiedTextReq parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder newBuilderForType() {
            return newBuilder();
        }

        private ModifiedTextReq() {
            this.memoizedIsInitialized = (byte) -1;
            this.fileId_ = "";
            this.offset_ = 0;
            this.modifiedText_ = "";
        }

        public static ModifiedTextReq parseFrom(InputStream inputStream) throws IOException {
            return (ModifiedTextReq) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.c cVar) {
            return new Builder(cVar);
        }

        public static ModifiedTextReq parseFrom(InputStream inputStream, q qVar) throws IOException {
            return (ModifiedTextReq) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
        }

        public static ModifiedTextReq parseFrom(i iVar) throws IOException {
            return (ModifiedTextReq) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
        }

        private ModifiedTextReq(i iVar, q qVar) throws InvalidProtocolBufferException {
            this();
            boolean z10 = false;
            while (!z10) {
                try {
                    try {
                        int F = iVar.F();
                        z10 = true;
                        if (F != 0) {
                            if (F == 10) {
                                this.fileId_ = iVar.E();
                            } else if (F == 16) {
                                this.offset_ = iVar.t();
                            } else if (F == 26) {
                                this.modifiedText_ = iVar.E();
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

        public static ModifiedTextReq parseFrom(i iVar, q qVar) throws IOException {
            return (ModifiedTextReq) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
        }
    }

    /* loaded from: classes2.dex */
    public interface ModifiedTextReqOrBuilder extends g0 {
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

        String getFileId();

        ByteString getFileIdBytes();

        /* synthetic */ String getInitializationErrorString();

        String getModifiedText();

        ByteString getModifiedTextBytes();

        int getOffset();

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
    public static final class RenameReq extends GeneratedMessageV3 implements RenameReqOrBuilder {
        public static final int FILE_ID_FIELD_NUMBER = 1;
        public static final int FILE_NAME_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private volatile Object fileId_;
        private volatile Object fileName_;
        private byte memoizedIsInitialized;
        private static final RenameReq DEFAULT_INSTANCE = new RenameReq();
        private static final l0<RenameReq> PARSER = new c<RenameReq>() { // from class: com.mobvoi.companion.proto.SoundProto.RenameReq.1
            @Override // com.google.protobuf.l0
            public RenameReq parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
                return new RenameReq(iVar, qVar);
            }
        };

        public static RenameReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return SoundProto.internal_static_com_mobvoi_companion_proto_RenameReq_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static RenameReq parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (RenameReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static RenameReq parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static l0<RenameReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof RenameReq)) {
                return super.equals(obj);
            }
            RenameReq renameReq = (RenameReq) obj;
            return (getFileId().equals(renameReq.getFileId())) && getFileName().equals(renameReq.getFileName());
        }

        @Override // com.mobvoi.companion.proto.SoundProto.RenameReqOrBuilder
        public String getFileId() {
            Object obj = this.fileId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.fileId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.proto.SoundProto.RenameReqOrBuilder
        public ByteString getFileIdBytes() {
            Object obj = this.fileId_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.fileId_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.mobvoi.companion.proto.SoundProto.RenameReqOrBuilder
        public String getFileName() {
            Object obj = this.fileName_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.fileName_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.proto.SoundProto.RenameReqOrBuilder
        public ByteString getFileNameBytes() {
            Object obj = this.fileName_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.fileName_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public l0<RenameReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
        public int getSerializedSize() {
            int i10 = this.memoizedSize;
            if (i10 != -1) {
                return i10;
            }
            int i11 = 0;
            if (!getFileIdBytes().isEmpty()) {
                i11 = 0 + GeneratedMessageV3.computeStringSize(1, this.fileId_);
            }
            if (!getFileNameBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(2, this.fileName_);
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
            int hashCode = ((((((((((779 + getDescriptorForType().hashCode()) * 37) + 1) * 53) + getFileId().hashCode()) * 37) + 2) * 53) + getFileName().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return SoundProto.internal_static_com_mobvoi_companion_proto_RenameReq_fieldAccessorTable.e(RenameReq.class, Builder.class);
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
            if (!getFileIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.fileId_);
            }
            if (!getFileNameBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.fileName_);
            }
        }

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageV3.b<Builder> implements RenameReqOrBuilder {
            private Object fileId_;
            private Object fileName_;

            public static final Descriptors.b getDescriptor() {
                return SoundProto.internal_static_com_mobvoi_companion_proto_RenameReq_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            public Builder clearFileId() {
                this.fileId_ = RenameReq.getDefaultInstance().getFileId();
                onChanged();
                return this;
            }

            public Builder clearFileName() {
                this.fileName_ = RenameReq.getDefaultInstance().getFileName();
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a, com.google.protobuf.g0
            public Descriptors.b getDescriptorForType() {
                return SoundProto.internal_static_com_mobvoi_companion_proto_RenameReq_descriptor;
            }

            @Override // com.mobvoi.companion.proto.SoundProto.RenameReqOrBuilder
            public String getFileId() {
                Object obj = this.fileId_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.fileId_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.proto.SoundProto.RenameReqOrBuilder
            public ByteString getFileIdBytes() {
                Object obj = this.fileId_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.fileId_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.mobvoi.companion.proto.SoundProto.RenameReqOrBuilder
            public String getFileName() {
                Object obj = this.fileName_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.fileName_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.proto.SoundProto.RenameReqOrBuilder
            public ByteString getFileNameBytes() {
                Object obj = this.fileName_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.fileName_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return SoundProto.internal_static_com_mobvoi_companion_proto_RenameReq_fieldAccessorTable.e(RenameReq.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.f0
            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a
            public final Builder mergeUnknownFields(a1 a1Var) {
                return this;
            }

            public Builder setFileId(String str) {
                Objects.requireNonNull(str);
                this.fileId_ = str;
                onChanged();
                return this;
            }

            public Builder setFileIdBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                b.checkByteStringIsUtf8(byteString);
                this.fileId_ = byteString;
                onChanged();
                return this;
            }

            public Builder setFileName(String str) {
                Objects.requireNonNull(str);
                this.fileName_ = str;
                onChanged();
                return this;
            }

            public Builder setFileNameBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                b.checkByteStringIsUtf8(byteString);
                this.fileName_ = byteString;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public final Builder setUnknownFields(a1 a1Var) {
                return this;
            }

            private Builder() {
                this.fileId_ = "";
                this.fileName_ = "";
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.e0.a, com.google.protobuf.d0.a
            public RenameReq build() {
                RenameReq buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) buildPartial);
            }

            @Override // com.google.protobuf.e0.a, com.google.protobuf.d0.a
            public RenameReq buildPartial() {
                RenameReq renameReq = new RenameReq(this);
                renameReq.fileId_ = this.fileId_;
                renameReq.fileName_ = this.fileName_;
                onBuilt();
                return renameReq;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.f0, com.google.protobuf.g0
            public RenameReq getDefaultInstanceForType() {
                return RenameReq.getDefaultInstance();
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
                this.fileId_ = "";
                this.fileName_ = "";
                return this;
            }

            private Builder(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.fileId_ = "";
                this.fileName_ = "";
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a, com.google.protobuf.b.a
            public Builder clone() {
                return (Builder) super.clone();
            }

            @Override // com.google.protobuf.a.AbstractC0170a, com.google.protobuf.d0.a
            public Builder mergeFrom(d0 d0Var) {
                if (d0Var instanceof RenameReq) {
                    return mergeFrom((RenameReq) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            public Builder mergeFrom(RenameReq renameReq) {
                if (renameReq == RenameReq.getDefaultInstance()) {
                    return this;
                }
                if (!renameReq.getFileId().isEmpty()) {
                    this.fileId_ = renameReq.fileId_;
                    onChanged();
                }
                if (!renameReq.getFileName().isEmpty()) {
                    this.fileName_ = renameReq.fileName_;
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
                RenameReq renameReq = null;
                try {
                    try {
                        RenameReq renameReq2 = (RenameReq) RenameReq.PARSER.parsePartialFrom(iVar, qVar);
                        if (renameReq2 != null) {
                            mergeFrom(renameReq2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e10) {
                        renameReq = (RenameReq) e10.getUnfinishedMessage();
                        try {
                            throw e10.unwrapIOException();
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (renameReq != null) {
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (renameReq != null) {
                        mergeFrom(renameReq);
                    }
                    throw th2;
                }
            }
        }

        public static Builder newBuilder(RenameReq renameReq) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(renameReq);
        }

        public static RenameReq parseFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, qVar);
        }

        private RenameReq(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static RenameReq parseDelimitedFrom(InputStream inputStream, q qVar) throws IOException {
            return (RenameReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
        }

        public static RenameReq parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
        public RenameReq getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static RenameReq parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder newBuilderForType() {
            return newBuilder();
        }

        private RenameReq() {
            this.memoizedIsInitialized = (byte) -1;
            this.fileId_ = "";
            this.fileName_ = "";
        }

        public static RenameReq parseFrom(InputStream inputStream) throws IOException {
            return (RenameReq) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.c cVar) {
            return new Builder(cVar);
        }

        public static RenameReq parseFrom(InputStream inputStream, q qVar) throws IOException {
            return (RenameReq) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
        }

        private RenameReq(i iVar, q qVar) throws InvalidProtocolBufferException {
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
                                    this.fileId_ = iVar.E();
                                } else if (F == 18) {
                                    this.fileName_ = iVar.E();
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

        public static RenameReq parseFrom(i iVar) throws IOException {
            return (RenameReq) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
        }

        public static RenameReq parseFrom(i iVar, q qVar) throws IOException {
            return (RenameReq) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
        }
    }

    /* loaded from: classes2.dex */
    public interface RenameReqOrBuilder extends g0 {
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

        String getFileId();

        ByteString getFileIdBytes();

        String getFileName();

        ByteString getFileNameBytes();

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
    public static final class SoundConvertConfigResp extends GeneratedMessageV3 implements SoundConvertConfigRespOrBuilder {
        public static final int CONVERT_CONFIG_FIELD_NUMBER = 3;
        public static final int ERR_CODE_FIELD_NUMBER = 1;
        public static final int ERR_MSG_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private ConvertConfig convertConfig_;
        private int errCode_;
        private volatile Object errMsg_;
        private byte memoizedIsInitialized;
        private static final SoundConvertConfigResp DEFAULT_INSTANCE = new SoundConvertConfigResp();
        private static final l0<SoundConvertConfigResp> PARSER = new c<SoundConvertConfigResp>() { // from class: com.mobvoi.companion.proto.SoundProto.SoundConvertConfigResp.1
            @Override // com.google.protobuf.l0
            public SoundConvertConfigResp parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
                return new SoundConvertConfigResp(iVar, qVar);
            }
        };

        public static SoundConvertConfigResp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return SoundProto.internal_static_com_mobvoi_companion_proto_SoundConvertConfigResp_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static SoundConvertConfigResp parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (SoundConvertConfigResp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static SoundConvertConfigResp parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static l0<SoundConvertConfigResp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            boolean z10 = true;
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof SoundConvertConfigResp)) {
                return super.equals(obj);
            }
            SoundConvertConfigResp soundConvertConfigResp = (SoundConvertConfigResp) obj;
            boolean z11 = ((getErrCode() == soundConvertConfigResp.getErrCode()) && getErrMsg().equals(soundConvertConfigResp.getErrMsg())) && hasConvertConfig() == soundConvertConfigResp.hasConvertConfig();
            if (!hasConvertConfig()) {
                return z11;
            }
            if (!z11 || !getConvertConfig().equals(soundConvertConfigResp.getConvertConfig())) {
                z10 = false;
            }
            return z10;
        }

        @Override // com.mobvoi.companion.proto.SoundProto.SoundConvertConfigRespOrBuilder
        public ConvertConfig getConvertConfig() {
            ConvertConfig convertConfig = this.convertConfig_;
            return convertConfig == null ? ConvertConfig.getDefaultInstance() : convertConfig;
        }

        @Override // com.mobvoi.companion.proto.SoundProto.SoundConvertConfigRespOrBuilder
        public ConvertConfigOrBuilder getConvertConfigOrBuilder() {
            return getConvertConfig();
        }

        @Override // com.mobvoi.companion.proto.SoundProto.SoundConvertConfigRespOrBuilder
        public int getErrCode() {
            return this.errCode_;
        }

        @Override // com.mobvoi.companion.proto.SoundProto.SoundConvertConfigRespOrBuilder
        public String getErrMsg() {
            Object obj = this.errMsg_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.errMsg_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.proto.SoundProto.SoundConvertConfigRespOrBuilder
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
        public l0<SoundConvertConfigResp> getParserForType() {
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
            if (this.convertConfig_ != null) {
                i11 += CodedOutputStream.E(3, getConvertConfig());
            }
            this.memoizedSize = i11;
            return i11;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.g0
        public final a1 getUnknownFields() {
            return a1.c();
        }

        @Override // com.mobvoi.companion.proto.SoundProto.SoundConvertConfigRespOrBuilder
        public boolean hasConvertConfig() {
            return this.convertConfig_ != null;
        }

        @Override // com.google.protobuf.a
        public int hashCode() {
            int i10 = this.memoizedHashCode;
            if (i10 != 0) {
                return i10;
            }
            int hashCode = ((((((((779 + getDescriptorForType().hashCode()) * 37) + 1) * 53) + getErrCode()) * 37) + 2) * 53) + getErrMsg().hashCode();
            if (hasConvertConfig()) {
                hashCode = (((hashCode * 37) + 3) * 53) + getConvertConfig().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return SoundProto.internal_static_com_mobvoi_companion_proto_SoundConvertConfigResp_fieldAccessorTable.e(SoundConvertConfigResp.class, Builder.class);
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
            if (this.convertConfig_ != null) {
                codedOutputStream.A0(3, getConvertConfig());
            }
        }

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageV3.b<Builder> implements SoundConvertConfigRespOrBuilder {
            private q0<ConvertConfig, ConvertConfig.Builder, ConvertConfigOrBuilder> convertConfigBuilder_;
            private ConvertConfig convertConfig_;
            private int errCode_;
            private Object errMsg_;

            private q0<ConvertConfig, ConvertConfig.Builder, ConvertConfigOrBuilder> getConvertConfigFieldBuilder() {
                if (this.convertConfigBuilder_ == null) {
                    this.convertConfigBuilder_ = new q0<>(getConvertConfig(), getParentForChildren(), isClean());
                    this.convertConfig_ = null;
                }
                return this.convertConfigBuilder_;
            }

            public static final Descriptors.b getDescriptor() {
                return SoundProto.internal_static_com_mobvoi_companion_proto_SoundConvertConfigResp_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            public Builder clearConvertConfig() {
                if (this.convertConfigBuilder_ == null) {
                    this.convertConfig_ = null;
                    onChanged();
                } else {
                    this.convertConfig_ = null;
                    this.convertConfigBuilder_ = null;
                }
                return this;
            }

            public Builder clearErrCode() {
                this.errCode_ = 0;
                onChanged();
                return this;
            }

            public Builder clearErrMsg() {
                this.errMsg_ = SoundConvertConfigResp.getDefaultInstance().getErrMsg();
                onChanged();
                return this;
            }

            @Override // com.mobvoi.companion.proto.SoundProto.SoundConvertConfigRespOrBuilder
            public ConvertConfig getConvertConfig() {
                q0<ConvertConfig, ConvertConfig.Builder, ConvertConfigOrBuilder> q0Var = this.convertConfigBuilder_;
                if (q0Var != null) {
                    return q0Var.f();
                }
                ConvertConfig convertConfig = this.convertConfig_;
                return convertConfig == null ? ConvertConfig.getDefaultInstance() : convertConfig;
            }

            public ConvertConfig.Builder getConvertConfigBuilder() {
                onChanged();
                return getConvertConfigFieldBuilder().e();
            }

            @Override // com.mobvoi.companion.proto.SoundProto.SoundConvertConfigRespOrBuilder
            public ConvertConfigOrBuilder getConvertConfigOrBuilder() {
                q0<ConvertConfig, ConvertConfig.Builder, ConvertConfigOrBuilder> q0Var = this.convertConfigBuilder_;
                if (q0Var != null) {
                    return q0Var.g();
                }
                ConvertConfig convertConfig = this.convertConfig_;
                return convertConfig == null ? ConvertConfig.getDefaultInstance() : convertConfig;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a, com.google.protobuf.g0
            public Descriptors.b getDescriptorForType() {
                return SoundProto.internal_static_com_mobvoi_companion_proto_SoundConvertConfigResp_descriptor;
            }

            @Override // com.mobvoi.companion.proto.SoundProto.SoundConvertConfigRespOrBuilder
            public int getErrCode() {
                return this.errCode_;
            }

            @Override // com.mobvoi.companion.proto.SoundProto.SoundConvertConfigRespOrBuilder
            public String getErrMsg() {
                Object obj = this.errMsg_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.errMsg_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.proto.SoundProto.SoundConvertConfigRespOrBuilder
            public ByteString getErrMsgBytes() {
                Object obj = this.errMsg_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.errMsg_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.mobvoi.companion.proto.SoundProto.SoundConvertConfigRespOrBuilder
            public boolean hasConvertConfig() {
                return (this.convertConfigBuilder_ == null && this.convertConfig_ == null) ? false : true;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return SoundProto.internal_static_com_mobvoi_companion_proto_SoundConvertConfigResp_fieldAccessorTable.e(SoundConvertConfigResp.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.f0
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeConvertConfig(ConvertConfig convertConfig) {
                q0<ConvertConfig, ConvertConfig.Builder, ConvertConfigOrBuilder> q0Var = this.convertConfigBuilder_;
                if (q0Var == null) {
                    ConvertConfig convertConfig2 = this.convertConfig_;
                    if (convertConfig2 != null) {
                        this.convertConfig_ = ConvertConfig.newBuilder(convertConfig2).mergeFrom(convertConfig).buildPartial();
                    } else {
                        this.convertConfig_ = convertConfig;
                    }
                    onChanged();
                } else {
                    q0Var.h(convertConfig);
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a
            public final Builder mergeUnknownFields(a1 a1Var) {
                return this;
            }

            public Builder setConvertConfig(ConvertConfig convertConfig) {
                q0<ConvertConfig, ConvertConfig.Builder, ConvertConfigOrBuilder> q0Var = this.convertConfigBuilder_;
                if (q0Var == null) {
                    Objects.requireNonNull(convertConfig);
                    this.convertConfig_ = convertConfig;
                    onChanged();
                } else {
                    q0Var.j(convertConfig);
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
                this.convertConfig_ = null;
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.e0.a, com.google.protobuf.d0.a
            public SoundConvertConfigResp build() {
                SoundConvertConfigResp buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) buildPartial);
            }

            @Override // com.google.protobuf.e0.a, com.google.protobuf.d0.a
            public SoundConvertConfigResp buildPartial() {
                SoundConvertConfigResp soundConvertConfigResp = new SoundConvertConfigResp(this);
                soundConvertConfigResp.errCode_ = this.errCode_;
                soundConvertConfigResp.errMsg_ = this.errMsg_;
                q0<ConvertConfig, ConvertConfig.Builder, ConvertConfigOrBuilder> q0Var = this.convertConfigBuilder_;
                if (q0Var == null) {
                    soundConvertConfigResp.convertConfig_ = this.convertConfig_;
                } else {
                    soundConvertConfigResp.convertConfig_ = q0Var.b();
                }
                onBuilt();
                return soundConvertConfigResp;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.f0, com.google.protobuf.g0
            public SoundConvertConfigResp getDefaultInstanceForType() {
                return SoundConvertConfigResp.getDefaultInstance();
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
                if (this.convertConfigBuilder_ == null) {
                    this.convertConfig_ = null;
                } else {
                    this.convertConfig_ = null;
                    this.convertConfigBuilder_ = null;
                }
                return this;
            }

            public Builder setConvertConfig(ConvertConfig.Builder builder) {
                q0<ConvertConfig, ConvertConfig.Builder, ConvertConfigOrBuilder> q0Var = this.convertConfigBuilder_;
                if (q0Var == null) {
                    this.convertConfig_ = builder.build();
                    onChanged();
                } else {
                    q0Var.j(builder.build());
                }
                return this;
            }

            private Builder(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.errMsg_ = "";
                this.convertConfig_ = null;
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a, com.google.protobuf.b.a
            public Builder clone() {
                return (Builder) super.clone();
            }

            @Override // com.google.protobuf.a.AbstractC0170a, com.google.protobuf.d0.a
            public Builder mergeFrom(d0 d0Var) {
                if (d0Var instanceof SoundConvertConfigResp) {
                    return mergeFrom((SoundConvertConfigResp) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            public Builder mergeFrom(SoundConvertConfigResp soundConvertConfigResp) {
                if (soundConvertConfigResp == SoundConvertConfigResp.getDefaultInstance()) {
                    return this;
                }
                if (soundConvertConfigResp.getErrCode() != 0) {
                    setErrCode(soundConvertConfigResp.getErrCode());
                }
                if (!soundConvertConfigResp.getErrMsg().isEmpty()) {
                    this.errMsg_ = soundConvertConfigResp.errMsg_;
                    onChanged();
                }
                if (soundConvertConfigResp.hasConvertConfig()) {
                    mergeConvertConfig(soundConvertConfigResp.getConvertConfig());
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
                SoundConvertConfigResp soundConvertConfigResp = null;
                try {
                    try {
                        SoundConvertConfigResp soundConvertConfigResp2 = (SoundConvertConfigResp) SoundConvertConfigResp.PARSER.parsePartialFrom(iVar, qVar);
                        if (soundConvertConfigResp2 != null) {
                            mergeFrom(soundConvertConfigResp2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e10) {
                        soundConvertConfigResp = (SoundConvertConfigResp) e10.getUnfinishedMessage();
                        try {
                            throw e10.unwrapIOException();
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (soundConvertConfigResp != null) {
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (soundConvertConfigResp != null) {
                        mergeFrom(soundConvertConfigResp);
                    }
                    throw th2;
                }
            }
        }

        public static Builder newBuilder(SoundConvertConfigResp soundConvertConfigResp) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(soundConvertConfigResp);
        }

        public static SoundConvertConfigResp parseFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, qVar);
        }

        private SoundConvertConfigResp(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static SoundConvertConfigResp parseDelimitedFrom(InputStream inputStream, q qVar) throws IOException {
            return (SoundConvertConfigResp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
        }

        public static SoundConvertConfigResp parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
        public SoundConvertConfigResp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static SoundConvertConfigResp parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder newBuilderForType() {
            return newBuilder();
        }

        private SoundConvertConfigResp() {
            this.memoizedIsInitialized = (byte) -1;
            this.errCode_ = 0;
            this.errMsg_ = "";
        }

        public static SoundConvertConfigResp parseFrom(InputStream inputStream) throws IOException {
            return (SoundConvertConfigResp) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.c cVar) {
            return new Builder(cVar);
        }

        public static SoundConvertConfigResp parseFrom(InputStream inputStream, q qVar) throws IOException {
            return (SoundConvertConfigResp) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
        }

        private SoundConvertConfigResp(i iVar, q qVar) throws InvalidProtocolBufferException {
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
                                } else if (F == 26) {
                                    ConvertConfig.Builder builder = null;
                                    ConvertConfig convertConfig = this.convertConfig_;
                                    builder = convertConfig != null ? convertConfig.toBuilder() : builder;
                                    ConvertConfig convertConfig2 = (ConvertConfig) iVar.v(ConvertConfig.parser(), qVar);
                                    this.convertConfig_ = convertConfig2;
                                    if (builder != null) {
                                        builder.mergeFrom(convertConfig2);
                                        this.convertConfig_ = builder.buildPartial();
                                    }
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

        public static SoundConvertConfigResp parseFrom(i iVar) throws IOException {
            return (SoundConvertConfigResp) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
        }

        public static SoundConvertConfigResp parseFrom(i iVar, q qVar) throws IOException {
            return (SoundConvertConfigResp) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
        }
    }

    /* loaded from: classes2.dex */
    public interface SoundConvertConfigRespOrBuilder extends g0 {
        /* synthetic */ List<String> findInitializationErrors();

        @Override // com.google.protobuf.g0
        /* synthetic */ Map<Descriptors.FieldDescriptor, Object> getAllFields();

        ConvertConfig getConvertConfig();

        ConvertConfigOrBuilder getConvertConfigOrBuilder();

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

        boolean hasConvertConfig();

        @Override // com.google.protobuf.g0
        /* synthetic */ boolean hasField(Descriptors.FieldDescriptor fieldDescriptor);

        /* synthetic */ boolean hasOneof(Descriptors.h hVar);

        @Override // com.google.protobuf.f0
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes2.dex */
    public static final class SoundConvertResultResp extends GeneratedMessageV3 implements SoundConvertResultRespOrBuilder {
        public static final int DATA_FIELD_NUMBER = 3;
        public static final int ERR_CODE_FIELD_NUMBER = 1;
        public static final int ERR_MSG_FIELD_NUMBER = 2;
        public static final int FILE_ID_FIELD_NUMBER = 5;
        public static final int PERCENTAGE_FIELD_NUMBER = 4;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private List<ConvertData> data_;
        private int errCode_;
        private volatile Object errMsg_;
        private volatile Object fileId_;
        private byte memoizedIsInitialized;
        private float percentage_;
        private static final SoundConvertResultResp DEFAULT_INSTANCE = new SoundConvertResultResp();
        private static final l0<SoundConvertResultResp> PARSER = new c<SoundConvertResultResp>() { // from class: com.mobvoi.companion.proto.SoundProto.SoundConvertResultResp.1
            @Override // com.google.protobuf.l0
            public SoundConvertResultResp parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
                return new SoundConvertResultResp(iVar, qVar);
            }
        };

        public static SoundConvertResultResp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return SoundProto.internal_static_com_mobvoi_companion_proto_SoundConvertResultResp_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static SoundConvertResultResp parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (SoundConvertResultResp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static SoundConvertResultResp parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static l0<SoundConvertResultResp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof SoundConvertResultResp)) {
                return super.equals(obj);
            }
            SoundConvertResultResp soundConvertResultResp = (SoundConvertResultResp) obj;
            return ((((getErrCode() == soundConvertResultResp.getErrCode()) && getErrMsg().equals(soundConvertResultResp.getErrMsg())) && getDataList().equals(soundConvertResultResp.getDataList())) && Float.floatToIntBits(getPercentage()) == Float.floatToIntBits(soundConvertResultResp.getPercentage())) && getFileId().equals(soundConvertResultResp.getFileId());
        }

        @Override // com.mobvoi.companion.proto.SoundProto.SoundConvertResultRespOrBuilder
        public ConvertData getData(int i10) {
            return this.data_.get(i10);
        }

        @Override // com.mobvoi.companion.proto.SoundProto.SoundConvertResultRespOrBuilder
        public int getDataCount() {
            return this.data_.size();
        }

        @Override // com.mobvoi.companion.proto.SoundProto.SoundConvertResultRespOrBuilder
        public List<ConvertData> getDataList() {
            return this.data_;
        }

        @Override // com.mobvoi.companion.proto.SoundProto.SoundConvertResultRespOrBuilder
        public ConvertDataOrBuilder getDataOrBuilder(int i10) {
            return this.data_.get(i10);
        }

        @Override // com.mobvoi.companion.proto.SoundProto.SoundConvertResultRespOrBuilder
        public List<? extends ConvertDataOrBuilder> getDataOrBuilderList() {
            return this.data_;
        }

        @Override // com.mobvoi.companion.proto.SoundProto.SoundConvertResultRespOrBuilder
        public int getErrCode() {
            return this.errCode_;
        }

        @Override // com.mobvoi.companion.proto.SoundProto.SoundConvertResultRespOrBuilder
        public String getErrMsg() {
            Object obj = this.errMsg_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.errMsg_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.proto.SoundProto.SoundConvertResultRespOrBuilder
        public ByteString getErrMsgBytes() {
            Object obj = this.errMsg_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.errMsg_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.mobvoi.companion.proto.SoundProto.SoundConvertResultRespOrBuilder
        public String getFileId() {
            Object obj = this.fileId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.fileId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.proto.SoundProto.SoundConvertResultRespOrBuilder
        public ByteString getFileIdBytes() {
            Object obj = this.fileId_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.fileId_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public l0<SoundConvertResultResp> getParserForType() {
            return PARSER;
        }

        @Override // com.mobvoi.companion.proto.SoundProto.SoundConvertResultRespOrBuilder
        public float getPercentage() {
            return this.percentage_;
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
            for (int i12 = 0; i12 < this.data_.size(); i12++) {
                v10 += CodedOutputStream.E(3, this.data_.get(i12));
            }
            float f10 = this.percentage_;
            if (f10 != 0.0f) {
                v10 += CodedOutputStream.r(4, f10);
            }
            if (!getFileIdBytes().isEmpty()) {
                v10 += GeneratedMessageV3.computeStringSize(5, this.fileId_);
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
            if (getDataCount() > 0) {
                hashCode = (((hashCode * 37) + 3) * 53) + getDataList().hashCode();
            }
            int floatToIntBits = (((((((((hashCode * 37) + 4) * 53) + Float.floatToIntBits(getPercentage())) * 37) + 5) * 53) + getFileId().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = floatToIntBits;
            return floatToIntBits;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return SoundProto.internal_static_com_mobvoi_companion_proto_SoundConvertResultResp_fieldAccessorTable.e(SoundConvertResultResp.class, Builder.class);
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
            for (int i11 = 0; i11 < this.data_.size(); i11++) {
                codedOutputStream.A0(3, this.data_.get(i11));
            }
            float f10 = this.percentage_;
            if (f10 != 0.0f) {
                codedOutputStream.s0(4, f10);
            }
            if (!getFileIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 5, this.fileId_);
            }
        }

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageV3.b<Builder> implements SoundConvertResultRespOrBuilder {
            private int bitField0_;
            private o0<ConvertData, ConvertData.Builder, ConvertDataOrBuilder> dataBuilder_;
            private List<ConvertData> data_;
            private int errCode_;
            private Object errMsg_;
            private Object fileId_;
            private float percentage_;

            private void ensureDataIsMutable() {
                if ((this.bitField0_ & 4) != 4) {
                    this.data_ = new ArrayList(this.data_);
                    this.bitField0_ |= 4;
                }
            }

            private o0<ConvertData, ConvertData.Builder, ConvertDataOrBuilder> getDataFieldBuilder() {
                if (this.dataBuilder_ == null) {
                    this.dataBuilder_ = new o0<>(this.data_, (this.bitField0_ & 4) == 4, getParentForChildren(), isClean());
                    this.data_ = null;
                }
                return this.dataBuilder_;
            }

            public static final Descriptors.b getDescriptor() {
                return SoundProto.internal_static_com_mobvoi_companion_proto_SoundConvertResultResp_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                    getDataFieldBuilder();
                }
            }

            public Builder addAllData(Iterable<? extends ConvertData> iterable) {
                o0<ConvertData, ConvertData.Builder, ConvertDataOrBuilder> o0Var = this.dataBuilder_;
                if (o0Var == null) {
                    ensureDataIsMutable();
                    b.a.addAll(iterable, this.data_);
                    onChanged();
                } else {
                    o0Var.b(iterable);
                }
                return this;
            }

            public Builder addData(ConvertData convertData) {
                o0<ConvertData, ConvertData.Builder, ConvertDataOrBuilder> o0Var = this.dataBuilder_;
                if (o0Var == null) {
                    Objects.requireNonNull(convertData);
                    ensureDataIsMutable();
                    this.data_.add(convertData);
                    onChanged();
                } else {
                    o0Var.f(convertData);
                }
                return this;
            }

            public ConvertData.Builder addDataBuilder() {
                return getDataFieldBuilder().d(ConvertData.getDefaultInstance());
            }

            public Builder clearData() {
                o0<ConvertData, ConvertData.Builder, ConvertDataOrBuilder> o0Var = this.dataBuilder_;
                if (o0Var == null) {
                    this.data_ = Collections.emptyList();
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
                this.errMsg_ = SoundConvertResultResp.getDefaultInstance().getErrMsg();
                onChanged();
                return this;
            }

            public Builder clearFileId() {
                this.fileId_ = SoundConvertResultResp.getDefaultInstance().getFileId();
                onChanged();
                return this;
            }

            public Builder clearPercentage() {
                this.percentage_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // com.mobvoi.companion.proto.SoundProto.SoundConvertResultRespOrBuilder
            public ConvertData getData(int i10) {
                o0<ConvertData, ConvertData.Builder, ConvertDataOrBuilder> o0Var = this.dataBuilder_;
                if (o0Var == null) {
                    return this.data_.get(i10);
                }
                return o0Var.o(i10);
            }

            public ConvertData.Builder getDataBuilder(int i10) {
                return getDataFieldBuilder().l(i10);
            }

            public List<ConvertData.Builder> getDataBuilderList() {
                return getDataFieldBuilder().m();
            }

            @Override // com.mobvoi.companion.proto.SoundProto.SoundConvertResultRespOrBuilder
            public int getDataCount() {
                o0<ConvertData, ConvertData.Builder, ConvertDataOrBuilder> o0Var = this.dataBuilder_;
                if (o0Var == null) {
                    return this.data_.size();
                }
                return o0Var.n();
            }

            @Override // com.mobvoi.companion.proto.SoundProto.SoundConvertResultRespOrBuilder
            public List<ConvertData> getDataList() {
                o0<ConvertData, ConvertData.Builder, ConvertDataOrBuilder> o0Var = this.dataBuilder_;
                if (o0Var == null) {
                    return Collections.unmodifiableList(this.data_);
                }
                return o0Var.q();
            }

            @Override // com.mobvoi.companion.proto.SoundProto.SoundConvertResultRespOrBuilder
            public ConvertDataOrBuilder getDataOrBuilder(int i10) {
                o0<ConvertData, ConvertData.Builder, ConvertDataOrBuilder> o0Var = this.dataBuilder_;
                if (o0Var == null) {
                    return this.data_.get(i10);
                }
                return o0Var.r(i10);
            }

            @Override // com.mobvoi.companion.proto.SoundProto.SoundConvertResultRespOrBuilder
            public List<? extends ConvertDataOrBuilder> getDataOrBuilderList() {
                o0<ConvertData, ConvertData.Builder, ConvertDataOrBuilder> o0Var = this.dataBuilder_;
                if (o0Var != null) {
                    return o0Var.s();
                }
                return Collections.unmodifiableList(this.data_);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a, com.google.protobuf.g0
            public Descriptors.b getDescriptorForType() {
                return SoundProto.internal_static_com_mobvoi_companion_proto_SoundConvertResultResp_descriptor;
            }

            @Override // com.mobvoi.companion.proto.SoundProto.SoundConvertResultRespOrBuilder
            public int getErrCode() {
                return this.errCode_;
            }

            @Override // com.mobvoi.companion.proto.SoundProto.SoundConvertResultRespOrBuilder
            public String getErrMsg() {
                Object obj = this.errMsg_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.errMsg_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.proto.SoundProto.SoundConvertResultRespOrBuilder
            public ByteString getErrMsgBytes() {
                Object obj = this.errMsg_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.errMsg_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.mobvoi.companion.proto.SoundProto.SoundConvertResultRespOrBuilder
            public String getFileId() {
                Object obj = this.fileId_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.fileId_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.proto.SoundProto.SoundConvertResultRespOrBuilder
            public ByteString getFileIdBytes() {
                Object obj = this.fileId_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.fileId_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.mobvoi.companion.proto.SoundProto.SoundConvertResultRespOrBuilder
            public float getPercentage() {
                return this.percentage_;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return SoundProto.internal_static_com_mobvoi_companion_proto_SoundConvertResultResp_fieldAccessorTable.e(SoundConvertResultResp.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.f0
            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a
            public final Builder mergeUnknownFields(a1 a1Var) {
                return this;
            }

            public Builder removeData(int i10) {
                o0<ConvertData, ConvertData.Builder, ConvertDataOrBuilder> o0Var = this.dataBuilder_;
                if (o0Var == null) {
                    ensureDataIsMutable();
                    this.data_.remove(i10);
                    onChanged();
                } else {
                    o0Var.w(i10);
                }
                return this;
            }

            public Builder setData(int i10, ConvertData convertData) {
                o0<ConvertData, ConvertData.Builder, ConvertDataOrBuilder> o0Var = this.dataBuilder_;
                if (o0Var == null) {
                    Objects.requireNonNull(convertData);
                    ensureDataIsMutable();
                    this.data_.set(i10, convertData);
                    onChanged();
                } else {
                    o0Var.x(i10, convertData);
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

            public Builder setFileId(String str) {
                Objects.requireNonNull(str);
                this.fileId_ = str;
                onChanged();
                return this;
            }

            public Builder setFileIdBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                b.checkByteStringIsUtf8(byteString);
                this.fileId_ = byteString;
                onChanged();
                return this;
            }

            public Builder setPercentage(float f10) {
                this.percentage_ = f10;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public final Builder setUnknownFields(a1 a1Var) {
                return this;
            }

            private Builder() {
                this.errMsg_ = "";
                this.data_ = Collections.emptyList();
                this.fileId_ = "";
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.e0.a, com.google.protobuf.d0.a
            public SoundConvertResultResp build() {
                SoundConvertResultResp buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) buildPartial);
            }

            @Override // com.google.protobuf.e0.a, com.google.protobuf.d0.a
            public SoundConvertResultResp buildPartial() {
                SoundConvertResultResp soundConvertResultResp = new SoundConvertResultResp(this);
                soundConvertResultResp.errCode_ = this.errCode_;
                soundConvertResultResp.errMsg_ = this.errMsg_;
                o0<ConvertData, ConvertData.Builder, ConvertDataOrBuilder> o0Var = this.dataBuilder_;
                if (o0Var == null) {
                    if ((this.bitField0_ & 4) == 4) {
                        this.data_ = Collections.unmodifiableList(this.data_);
                        this.bitField0_ &= -5;
                    }
                    soundConvertResultResp.data_ = this.data_;
                } else {
                    soundConvertResultResp.data_ = o0Var.g();
                }
                soundConvertResultResp.percentage_ = this.percentage_;
                soundConvertResultResp.fileId_ = this.fileId_;
                soundConvertResultResp.bitField0_ = 0;
                onBuilt();
                return soundConvertResultResp;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.f0, com.google.protobuf.g0
            public SoundConvertResultResp getDefaultInstanceForType() {
                return SoundConvertResultResp.getDefaultInstance();
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

            public ConvertData.Builder addDataBuilder(int i10) {
                return getDataFieldBuilder().c(i10, ConvertData.getDefaultInstance());
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
                o0<ConvertData, ConvertData.Builder, ConvertDataOrBuilder> o0Var = this.dataBuilder_;
                if (o0Var == null) {
                    this.data_ = Collections.emptyList();
                    this.bitField0_ &= -5;
                } else {
                    o0Var.h();
                }
                this.percentage_ = 0.0f;
                this.fileId_ = "";
                return this;
            }

            public Builder addData(int i10, ConvertData convertData) {
                o0<ConvertData, ConvertData.Builder, ConvertDataOrBuilder> o0Var = this.dataBuilder_;
                if (o0Var == null) {
                    Objects.requireNonNull(convertData);
                    ensureDataIsMutable();
                    this.data_.add(i10, convertData);
                    onChanged();
                } else {
                    o0Var.e(i10, convertData);
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a, com.google.protobuf.b.a
            public Builder clone() {
                return (Builder) super.clone();
            }

            @Override // com.google.protobuf.a.AbstractC0170a, com.google.protobuf.d0.a
            public Builder mergeFrom(d0 d0Var) {
                if (d0Var instanceof SoundConvertResultResp) {
                    return mergeFrom((SoundConvertResultResp) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            public Builder setData(int i10, ConvertData.Builder builder) {
                o0<ConvertData, ConvertData.Builder, ConvertDataOrBuilder> o0Var = this.dataBuilder_;
                if (o0Var == null) {
                    ensureDataIsMutable();
                    this.data_.set(i10, builder.build());
                    onChanged();
                } else {
                    o0Var.x(i10, builder.build());
                }
                return this;
            }

            private Builder(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.errMsg_ = "";
                this.data_ = Collections.emptyList();
                this.fileId_ = "";
                maybeForceBuilderInitialization();
            }

            public Builder mergeFrom(SoundConvertResultResp soundConvertResultResp) {
                if (soundConvertResultResp == SoundConvertResultResp.getDefaultInstance()) {
                    return this;
                }
                if (soundConvertResultResp.getErrCode() != 0) {
                    setErrCode(soundConvertResultResp.getErrCode());
                }
                if (!soundConvertResultResp.getErrMsg().isEmpty()) {
                    this.errMsg_ = soundConvertResultResp.errMsg_;
                    onChanged();
                }
                if (this.dataBuilder_ == null) {
                    if (!soundConvertResultResp.data_.isEmpty()) {
                        if (this.data_.isEmpty()) {
                            this.data_ = soundConvertResultResp.data_;
                            this.bitField0_ &= -5;
                        } else {
                            ensureDataIsMutable();
                            this.data_.addAll(soundConvertResultResp.data_);
                        }
                        onChanged();
                    }
                } else if (!soundConvertResultResp.data_.isEmpty()) {
                    if (this.dataBuilder_.u()) {
                        this.dataBuilder_.i();
                        o0<ConvertData, ConvertData.Builder, ConvertDataOrBuilder> o0Var = null;
                        this.dataBuilder_ = null;
                        this.data_ = soundConvertResultResp.data_;
                        this.bitField0_ &= -5;
                        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                            o0Var = getDataFieldBuilder();
                        }
                        this.dataBuilder_ = o0Var;
                    } else {
                        this.dataBuilder_.b(soundConvertResultResp.data_);
                    }
                }
                if (soundConvertResultResp.getPercentage() != 0.0f) {
                    setPercentage(soundConvertResultResp.getPercentage());
                }
                if (!soundConvertResultResp.getFileId().isEmpty()) {
                    this.fileId_ = soundConvertResultResp.fileId_;
                    onChanged();
                }
                onChanged();
                return this;
            }

            public Builder addData(ConvertData.Builder builder) {
                o0<ConvertData, ConvertData.Builder, ConvertDataOrBuilder> o0Var = this.dataBuilder_;
                if (o0Var == null) {
                    ensureDataIsMutable();
                    this.data_.add(builder.build());
                    onChanged();
                } else {
                    o0Var.f(builder.build());
                }
                return this;
            }

            public Builder addData(int i10, ConvertData.Builder builder) {
                o0<ConvertData, ConvertData.Builder, ConvertDataOrBuilder> o0Var = this.dataBuilder_;
                if (o0Var == null) {
                    ensureDataIsMutable();
                    this.data_.add(i10, builder.build());
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
                SoundConvertResultResp soundConvertResultResp = null;
                try {
                    try {
                        SoundConvertResultResp soundConvertResultResp2 = (SoundConvertResultResp) SoundConvertResultResp.PARSER.parsePartialFrom(iVar, qVar);
                        if (soundConvertResultResp2 != null) {
                            mergeFrom(soundConvertResultResp2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e10) {
                        soundConvertResultResp = (SoundConvertResultResp) e10.getUnfinishedMessage();
                        try {
                            throw e10.unwrapIOException();
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (soundConvertResultResp != null) {
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (soundConvertResultResp != null) {
                        mergeFrom(soundConvertResultResp);
                    }
                    throw th2;
                }
            }
        }

        public static Builder newBuilder(SoundConvertResultResp soundConvertResultResp) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(soundConvertResultResp);
        }

        public static SoundConvertResultResp parseFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, qVar);
        }

        private SoundConvertResultResp(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static SoundConvertResultResp parseDelimitedFrom(InputStream inputStream, q qVar) throws IOException {
            return (SoundConvertResultResp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
        }

        public static SoundConvertResultResp parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
        public SoundConvertResultResp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static SoundConvertResultResp parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder newBuilderForType() {
            return newBuilder();
        }

        private SoundConvertResultResp() {
            this.memoizedIsInitialized = (byte) -1;
            this.errCode_ = 0;
            this.errMsg_ = "";
            this.data_ = Collections.emptyList();
            this.percentage_ = 0.0f;
            this.fileId_ = "";
        }

        public static SoundConvertResultResp parseFrom(InputStream inputStream) throws IOException {
            return (SoundConvertResultResp) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.c cVar) {
            return new Builder(cVar);
        }

        public static SoundConvertResultResp parseFrom(InputStream inputStream, q qVar) throws IOException {
            return (SoundConvertResultResp) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
        }

        public static SoundConvertResultResp parseFrom(i iVar) throws IOException {
            return (SoundConvertResultResp) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
        }

        public static SoundConvertResultResp parseFrom(i iVar, q qVar) throws IOException {
            return (SoundConvertResultResp) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
        }

        private SoundConvertResultResp(i iVar, q qVar) throws InvalidProtocolBufferException {
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
                                    this.data_ = new ArrayList();
                                    z11 |= true;
                                }
                                this.data_.add((ConvertData) iVar.v(ConvertData.parser(), qVar));
                            } else if (F == 37) {
                                this.percentage_ = iVar.r();
                            } else if (F == 42) {
                                this.fileId_ = iVar.E();
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
                        this.data_ = Collections.unmodifiableList(this.data_);
                    }
                    makeExtensionsImmutable();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface SoundConvertResultRespOrBuilder extends g0 {
        /* synthetic */ List<String> findInitializationErrors();

        @Override // com.google.protobuf.g0
        /* synthetic */ Map<Descriptors.FieldDescriptor, Object> getAllFields();

        ConvertData getData(int i10);

        int getDataCount();

        List<ConvertData> getDataList();

        ConvertDataOrBuilder getDataOrBuilder(int i10);

        List<? extends ConvertDataOrBuilder> getDataOrBuilderList();

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

        String getFileId();

        ByteString getFileIdBytes();

        /* synthetic */ String getInitializationErrorString();

        /* synthetic */ Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.h hVar);

        float getPercentage();

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
    public static final class SoundFile extends GeneratedMessageV3 implements SoundFileOrBuilder {
        public static final int DEVICE_ID_FIELD_NUMBER = 1;
        public static final int DEVICE_TYPE_FIELD_NUMBER = 11;
        public static final int DURATION_FIELD_NUMBER = 6;
        public static final int FILE_ID_FIELD_NUMBER = 2;
        public static final int FILE_NAME_FIELD_NUMBER = 3;
        public static final int FILE_SIZE_FIELD_NUMBER = 5;
        public static final int FILE_STATUS_FIELD_NUMBER = 10;
        public static final int FILE_URL_FIELD_NUMBER = 4;
        public static final int FIRST_PARAGRAPH_FIELD_NUMBER = 13;
        public static final int FLAGS_FIELD_NUMBER = 9;
        public static final int KEYWORDS_FIELD_NUMBER = 14;
        public static final int PERCENTAGE_FIELD_NUMBER = 12;
        public static final int SPEAKER_NUM_FIELD_NUMBER = 8;
        public static final int TIMESTAMP_FIELD_NUMBER = 7;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private volatile Object deviceId_;
        private int deviceType_;
        private int duration_;
        private volatile Object fileId_;
        private volatile Object fileName_;
        private long fileSize_;
        private int fileStatus_;
        private volatile Object fileUrl_;
        private volatile Object firstParagraph_;
        private int flagsMemoizedSerializedSize;
        private List<Integer> flags_;
        private y keywords_;
        private byte memoizedIsInitialized;
        private volatile Object percentage_;
        private int speakerNum_;
        private long timestamp_;
        private static final SoundFile DEFAULT_INSTANCE = new SoundFile();
        private static final l0<SoundFile> PARSER = new c<SoundFile>() { // from class: com.mobvoi.companion.proto.SoundProto.SoundFile.1
            @Override // com.google.protobuf.l0
            public SoundFile parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
                return new SoundFile(iVar, qVar);
            }
        };

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageV3.b<Builder> implements SoundFileOrBuilder {
            private int bitField0_;
            private Object deviceId_;
            private int deviceType_;
            private int duration_;
            private Object fileId_;
            private Object fileName_;
            private long fileSize_;
            private int fileStatus_;
            private Object fileUrl_;
            private Object firstParagraph_;
            private List<Integer> flags_;
            private y keywords_;
            private Object percentage_;
            private int speakerNum_;
            private long timestamp_;

            private void ensureFlagsIsMutable() {
                if ((this.bitField0_ & 256) != 256) {
                    this.flags_ = new ArrayList(this.flags_);
                    this.bitField0_ |= 256;
                }
            }

            private void ensureKeywordsIsMutable() {
                if ((this.bitField0_ & 8192) != 8192) {
                    this.keywords_ = new x(this.keywords_);
                    this.bitField0_ |= 8192;
                }
            }

            public static final Descriptors.b getDescriptor() {
                return SoundProto.internal_static_com_mobvoi_companion_proto_SoundFile_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            public Builder addAllFlags(Iterable<? extends Integer> iterable) {
                ensureFlagsIsMutable();
                b.a.addAll(iterable, this.flags_);
                onChanged();
                return this;
            }

            public Builder addAllKeywords(Iterable<String> iterable) {
                ensureKeywordsIsMutable();
                b.a.addAll(iterable, this.keywords_);
                onChanged();
                return this;
            }

            public Builder addFlags(int i10) {
                ensureFlagsIsMutable();
                this.flags_.add(Integer.valueOf(i10));
                onChanged();
                return this;
            }

            public Builder addKeywords(String str) {
                Objects.requireNonNull(str);
                ensureKeywordsIsMutable();
                this.keywords_.add(str);
                onChanged();
                return this;
            }

            public Builder addKeywordsBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                b.checkByteStringIsUtf8(byteString);
                ensureKeywordsIsMutable();
                this.keywords_.v(byteString);
                onChanged();
                return this;
            }

            public Builder clearDeviceId() {
                this.deviceId_ = SoundFile.getDefaultInstance().getDeviceId();
                onChanged();
                return this;
            }

            public Builder clearDeviceType() {
                this.deviceType_ = 0;
                onChanged();
                return this;
            }

            public Builder clearDuration() {
                this.duration_ = 0;
                onChanged();
                return this;
            }

            public Builder clearFileId() {
                this.fileId_ = SoundFile.getDefaultInstance().getFileId();
                onChanged();
                return this;
            }

            public Builder clearFileName() {
                this.fileName_ = SoundFile.getDefaultInstance().getFileName();
                onChanged();
                return this;
            }

            public Builder clearFileSize() {
                this.fileSize_ = 0L;
                onChanged();
                return this;
            }

            public Builder clearFileStatus() {
                this.fileStatus_ = 0;
                onChanged();
                return this;
            }

            public Builder clearFileUrl() {
                this.fileUrl_ = SoundFile.getDefaultInstance().getFileUrl();
                onChanged();
                return this;
            }

            public Builder clearFirstParagraph() {
                this.firstParagraph_ = SoundFile.getDefaultInstance().getFirstParagraph();
                onChanged();
                return this;
            }

            public Builder clearFlags() {
                this.flags_ = Collections.emptyList();
                this.bitField0_ &= -257;
                onChanged();
                return this;
            }

            public Builder clearKeywords() {
                this.keywords_ = x.f13385d;
                this.bitField0_ &= -8193;
                onChanged();
                return this;
            }

            public Builder clearPercentage() {
                this.percentage_ = SoundFile.getDefaultInstance().getPercentage();
                onChanged();
                return this;
            }

            public Builder clearSpeakerNum() {
                this.speakerNum_ = 0;
                onChanged();
                return this;
            }

            public Builder clearTimestamp() {
                this.timestamp_ = 0L;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a, com.google.protobuf.g0
            public Descriptors.b getDescriptorForType() {
                return SoundProto.internal_static_com_mobvoi_companion_proto_SoundFile_descriptor;
            }

            @Override // com.mobvoi.companion.proto.SoundProto.SoundFileOrBuilder
            public String getDeviceId() {
                Object obj = this.deviceId_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.deviceId_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.proto.SoundProto.SoundFileOrBuilder
            public ByteString getDeviceIdBytes() {
                Object obj = this.deviceId_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.deviceId_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.mobvoi.companion.proto.SoundProto.SoundFileOrBuilder
            public ConstantProto.DeviceType getDeviceType() {
                ConstantProto.DeviceType valueOf = ConstantProto.DeviceType.valueOf(this.deviceType_);
                return valueOf == null ? ConstantProto.DeviceType.UNRECOGNIZED : valueOf;
            }

            @Override // com.mobvoi.companion.proto.SoundProto.SoundFileOrBuilder
            public int getDeviceTypeValue() {
                return this.deviceType_;
            }

            @Override // com.mobvoi.companion.proto.SoundProto.SoundFileOrBuilder
            public int getDuration() {
                return this.duration_;
            }

            @Override // com.mobvoi.companion.proto.SoundProto.SoundFileOrBuilder
            public String getFileId() {
                Object obj = this.fileId_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.fileId_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.proto.SoundProto.SoundFileOrBuilder
            public ByteString getFileIdBytes() {
                Object obj = this.fileId_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.fileId_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.mobvoi.companion.proto.SoundProto.SoundFileOrBuilder
            public String getFileName() {
                Object obj = this.fileName_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.fileName_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.proto.SoundProto.SoundFileOrBuilder
            public ByteString getFileNameBytes() {
                Object obj = this.fileName_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.fileName_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.mobvoi.companion.proto.SoundProto.SoundFileOrBuilder
            public long getFileSize() {
                return this.fileSize_;
            }

            @Override // com.mobvoi.companion.proto.SoundProto.SoundFileOrBuilder
            public FileStatus getFileStatus() {
                FileStatus valueOf = FileStatus.valueOf(this.fileStatus_);
                return valueOf == null ? FileStatus.UNRECOGNIZED : valueOf;
            }

            @Override // com.mobvoi.companion.proto.SoundProto.SoundFileOrBuilder
            public int getFileStatusValue() {
                return this.fileStatus_;
            }

            @Override // com.mobvoi.companion.proto.SoundProto.SoundFileOrBuilder
            public String getFileUrl() {
                Object obj = this.fileUrl_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.fileUrl_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.proto.SoundProto.SoundFileOrBuilder
            public ByteString getFileUrlBytes() {
                Object obj = this.fileUrl_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.fileUrl_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.mobvoi.companion.proto.SoundProto.SoundFileOrBuilder
            public String getFirstParagraph() {
                Object obj = this.firstParagraph_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.firstParagraph_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.proto.SoundProto.SoundFileOrBuilder
            public ByteString getFirstParagraphBytes() {
                Object obj = this.firstParagraph_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.firstParagraph_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.mobvoi.companion.proto.SoundProto.SoundFileOrBuilder
            public int getFlags(int i10) {
                return this.flags_.get(i10).intValue();
            }

            @Override // com.mobvoi.companion.proto.SoundProto.SoundFileOrBuilder
            public int getFlagsCount() {
                return this.flags_.size();
            }

            @Override // com.mobvoi.companion.proto.SoundProto.SoundFileOrBuilder
            public List<Integer> getFlagsList() {
                return Collections.unmodifiableList(this.flags_);
            }

            @Override // com.mobvoi.companion.proto.SoundProto.SoundFileOrBuilder
            public String getKeywords(int i10) {
                return this.keywords_.get(i10);
            }

            @Override // com.mobvoi.companion.proto.SoundProto.SoundFileOrBuilder
            public ByteString getKeywordsBytes(int i10) {
                return this.keywords_.o0(i10);
            }

            @Override // com.mobvoi.companion.proto.SoundProto.SoundFileOrBuilder
            public int getKeywordsCount() {
                return this.keywords_.size();
            }

            @Override // com.mobvoi.companion.proto.SoundProto.SoundFileOrBuilder
            public String getPercentage() {
                Object obj = this.percentage_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.percentage_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.proto.SoundProto.SoundFileOrBuilder
            public ByteString getPercentageBytes() {
                Object obj = this.percentage_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.percentage_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.mobvoi.companion.proto.SoundProto.SoundFileOrBuilder
            public int getSpeakerNum() {
                return this.speakerNum_;
            }

            @Override // com.mobvoi.companion.proto.SoundProto.SoundFileOrBuilder
            public long getTimestamp() {
                return this.timestamp_;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return SoundProto.internal_static_com_mobvoi_companion_proto_SoundFile_fieldAccessorTable.e(SoundFile.class, Builder.class);
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

            public Builder setDuration(int i10) {
                this.duration_ = i10;
                onChanged();
                return this;
            }

            public Builder setFileId(String str) {
                Objects.requireNonNull(str);
                this.fileId_ = str;
                onChanged();
                return this;
            }

            public Builder setFileIdBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                b.checkByteStringIsUtf8(byteString);
                this.fileId_ = byteString;
                onChanged();
                return this;
            }

            public Builder setFileName(String str) {
                Objects.requireNonNull(str);
                this.fileName_ = str;
                onChanged();
                return this;
            }

            public Builder setFileNameBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                b.checkByteStringIsUtf8(byteString);
                this.fileName_ = byteString;
                onChanged();
                return this;
            }

            public Builder setFileSize(long j10) {
                this.fileSize_ = j10;
                onChanged();
                return this;
            }

            public Builder setFileStatus(FileStatus fileStatus) {
                Objects.requireNonNull(fileStatus);
                this.fileStatus_ = fileStatus.getNumber();
                onChanged();
                return this;
            }

            public Builder setFileStatusValue(int i10) {
                this.fileStatus_ = i10;
                onChanged();
                return this;
            }

            public Builder setFileUrl(String str) {
                Objects.requireNonNull(str);
                this.fileUrl_ = str;
                onChanged();
                return this;
            }

            public Builder setFileUrlBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                b.checkByteStringIsUtf8(byteString);
                this.fileUrl_ = byteString;
                onChanged();
                return this;
            }

            public Builder setFirstParagraph(String str) {
                Objects.requireNonNull(str);
                this.firstParagraph_ = str;
                onChanged();
                return this;
            }

            public Builder setFirstParagraphBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                b.checkByteStringIsUtf8(byteString);
                this.firstParagraph_ = byteString;
                onChanged();
                return this;
            }

            public Builder setFlags(int i10, int i11) {
                ensureFlagsIsMutable();
                this.flags_.set(i10, Integer.valueOf(i11));
                onChanged();
                return this;
            }

            public Builder setKeywords(int i10, String str) {
                Objects.requireNonNull(str);
                ensureKeywordsIsMutable();
                this.keywords_.set(i10, str);
                onChanged();
                return this;
            }

            public Builder setPercentage(String str) {
                Objects.requireNonNull(str);
                this.percentage_ = str;
                onChanged();
                return this;
            }

            public Builder setPercentageBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                b.checkByteStringIsUtf8(byteString);
                this.percentage_ = byteString;
                onChanged();
                return this;
            }

            public Builder setSpeakerNum(int i10) {
                this.speakerNum_ = i10;
                onChanged();
                return this;
            }

            public Builder setTimestamp(long j10) {
                this.timestamp_ = j10;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public final Builder setUnknownFields(a1 a1Var) {
                return this;
            }

            @Override // com.mobvoi.companion.proto.SoundProto.SoundFileOrBuilder
            public n0 getKeywordsList() {
                return this.keywords_.u0();
            }

            private Builder() {
                this.deviceId_ = "";
                this.fileId_ = "";
                this.fileName_ = "";
                this.fileUrl_ = "";
                this.flags_ = Collections.emptyList();
                this.fileStatus_ = 0;
                this.deviceType_ = 0;
                this.percentage_ = "";
                this.firstParagraph_ = "";
                this.keywords_ = x.f13385d;
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.e0.a, com.google.protobuf.d0.a
            public SoundFile build() {
                SoundFile buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) buildPartial);
            }

            @Override // com.google.protobuf.e0.a, com.google.protobuf.d0.a
            public SoundFile buildPartial() {
                SoundFile soundFile = new SoundFile(this);
                soundFile.deviceId_ = this.deviceId_;
                soundFile.fileId_ = this.fileId_;
                soundFile.fileName_ = this.fileName_;
                soundFile.fileUrl_ = this.fileUrl_;
                soundFile.fileSize_ = this.fileSize_;
                soundFile.duration_ = this.duration_;
                soundFile.timestamp_ = this.timestamp_;
                soundFile.speakerNum_ = this.speakerNum_;
                if ((this.bitField0_ & 256) == 256) {
                    this.flags_ = Collections.unmodifiableList(this.flags_);
                    this.bitField0_ &= -257;
                }
                soundFile.flags_ = this.flags_;
                soundFile.fileStatus_ = this.fileStatus_;
                soundFile.deviceType_ = this.deviceType_;
                soundFile.percentage_ = this.percentage_;
                soundFile.firstParagraph_ = this.firstParagraph_;
                if ((this.bitField0_ & 8192) == 8192) {
                    this.keywords_ = this.keywords_.u0();
                    this.bitField0_ &= -8193;
                }
                soundFile.keywords_ = this.keywords_;
                soundFile.bitField0_ = 0;
                onBuilt();
                return soundFile;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.f0, com.google.protobuf.g0
            public SoundFile getDefaultInstanceForType() {
                return SoundFile.getDefaultInstance();
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
                this.fileId_ = "";
                this.fileName_ = "";
                this.fileUrl_ = "";
                this.fileSize_ = 0L;
                this.duration_ = 0;
                this.timestamp_ = 0L;
                this.speakerNum_ = 0;
                this.flags_ = Collections.emptyList();
                int i10 = this.bitField0_ & (-257);
                this.bitField0_ = i10;
                this.fileStatus_ = 0;
                this.deviceType_ = 0;
                this.percentage_ = "";
                this.firstParagraph_ = "";
                this.keywords_ = x.f13385d;
                this.bitField0_ = i10 & (-8193);
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a, com.google.protobuf.b.a
            public Builder clone() {
                return (Builder) super.clone();
            }

            @Override // com.google.protobuf.a.AbstractC0170a, com.google.protobuf.d0.a
            public Builder mergeFrom(d0 d0Var) {
                if (d0Var instanceof SoundFile) {
                    return mergeFrom((SoundFile) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            public Builder mergeFrom(SoundFile soundFile) {
                if (soundFile == SoundFile.getDefaultInstance()) {
                    return this;
                }
                if (!soundFile.getDeviceId().isEmpty()) {
                    this.deviceId_ = soundFile.deviceId_;
                    onChanged();
                }
                if (!soundFile.getFileId().isEmpty()) {
                    this.fileId_ = soundFile.fileId_;
                    onChanged();
                }
                if (!soundFile.getFileName().isEmpty()) {
                    this.fileName_ = soundFile.fileName_;
                    onChanged();
                }
                if (!soundFile.getFileUrl().isEmpty()) {
                    this.fileUrl_ = soundFile.fileUrl_;
                    onChanged();
                }
                if (soundFile.getFileSize() != 0) {
                    setFileSize(soundFile.getFileSize());
                }
                if (soundFile.getDuration() != 0) {
                    setDuration(soundFile.getDuration());
                }
                if (soundFile.getTimestamp() != 0) {
                    setTimestamp(soundFile.getTimestamp());
                }
                if (soundFile.getSpeakerNum() != 0) {
                    setSpeakerNum(soundFile.getSpeakerNum());
                }
                if (!soundFile.flags_.isEmpty()) {
                    if (this.flags_.isEmpty()) {
                        this.flags_ = soundFile.flags_;
                        this.bitField0_ &= -257;
                    } else {
                        ensureFlagsIsMutable();
                        this.flags_.addAll(soundFile.flags_);
                    }
                    onChanged();
                }
                if (soundFile.fileStatus_ != 0) {
                    setFileStatusValue(soundFile.getFileStatusValue());
                }
                if (soundFile.deviceType_ != 0) {
                    setDeviceTypeValue(soundFile.getDeviceTypeValue());
                }
                if (!soundFile.getPercentage().isEmpty()) {
                    this.percentage_ = soundFile.percentage_;
                    onChanged();
                }
                if (!soundFile.getFirstParagraph().isEmpty()) {
                    this.firstParagraph_ = soundFile.firstParagraph_;
                    onChanged();
                }
                if (!soundFile.keywords_.isEmpty()) {
                    if (this.keywords_.isEmpty()) {
                        this.keywords_ = soundFile.keywords_;
                        this.bitField0_ &= -8193;
                    } else {
                        ensureKeywordsIsMutable();
                        this.keywords_.addAll(soundFile.keywords_);
                    }
                    onChanged();
                }
                onChanged();
                return this;
            }

            private Builder(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.deviceId_ = "";
                this.fileId_ = "";
                this.fileName_ = "";
                this.fileUrl_ = "";
                this.flags_ = Collections.emptyList();
                this.fileStatus_ = 0;
                this.deviceType_ = 0;
                this.percentage_ = "";
                this.firstParagraph_ = "";
                this.keywords_ = x.f13385d;
                maybeForceBuilderInitialization();
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x0023  */
            @Override // com.google.protobuf.a.AbstractC0170a, com.google.protobuf.b.a, com.google.protobuf.e0.a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(i iVar, q qVar) throws IOException {
                Throwable th2;
                SoundFile soundFile = null;
                try {
                    try {
                        SoundFile soundFile2 = (SoundFile) SoundFile.PARSER.parsePartialFrom(iVar, qVar);
                        if (soundFile2 != null) {
                            mergeFrom(soundFile2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e10) {
                        soundFile = (SoundFile) e10.getUnfinishedMessage();
                        try {
                            throw e10.unwrapIOException();
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (soundFile != null) {
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (soundFile != null) {
                        mergeFrom(soundFile);
                    }
                    throw th2;
                }
            }
        }

        public static SoundFile getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return SoundProto.internal_static_com_mobvoi_companion_proto_SoundFile_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static SoundFile parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (SoundFile) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static SoundFile parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static l0<SoundFile> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof SoundFile)) {
                return super.equals(obj);
            }
            SoundFile soundFile = (SoundFile) obj;
            return (((((((((((((getDeviceId().equals(soundFile.getDeviceId())) && getFileId().equals(soundFile.getFileId())) && getFileName().equals(soundFile.getFileName())) && getFileUrl().equals(soundFile.getFileUrl())) && (getFileSize() > soundFile.getFileSize() ? 1 : (getFileSize() == soundFile.getFileSize() ? 0 : -1)) == 0) && getDuration() == soundFile.getDuration()) && (getTimestamp() > soundFile.getTimestamp() ? 1 : (getTimestamp() == soundFile.getTimestamp() ? 0 : -1)) == 0) && getSpeakerNum() == soundFile.getSpeakerNum()) && getFlagsList().equals(soundFile.getFlagsList())) && this.fileStatus_ == soundFile.fileStatus_) && this.deviceType_ == soundFile.deviceType_) && getPercentage().equals(soundFile.getPercentage())) && getFirstParagraph().equals(soundFile.getFirstParagraph())) && getKeywordsList().equals(soundFile.getKeywordsList());
        }

        @Override // com.mobvoi.companion.proto.SoundProto.SoundFileOrBuilder
        public String getDeviceId() {
            Object obj = this.deviceId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.deviceId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.proto.SoundProto.SoundFileOrBuilder
        public ByteString getDeviceIdBytes() {
            Object obj = this.deviceId_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.deviceId_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.mobvoi.companion.proto.SoundProto.SoundFileOrBuilder
        public ConstantProto.DeviceType getDeviceType() {
            ConstantProto.DeviceType valueOf = ConstantProto.DeviceType.valueOf(this.deviceType_);
            return valueOf == null ? ConstantProto.DeviceType.UNRECOGNIZED : valueOf;
        }

        @Override // com.mobvoi.companion.proto.SoundProto.SoundFileOrBuilder
        public int getDeviceTypeValue() {
            return this.deviceType_;
        }

        @Override // com.mobvoi.companion.proto.SoundProto.SoundFileOrBuilder
        public int getDuration() {
            return this.duration_;
        }

        @Override // com.mobvoi.companion.proto.SoundProto.SoundFileOrBuilder
        public String getFileId() {
            Object obj = this.fileId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.fileId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.proto.SoundProto.SoundFileOrBuilder
        public ByteString getFileIdBytes() {
            Object obj = this.fileId_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.fileId_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.mobvoi.companion.proto.SoundProto.SoundFileOrBuilder
        public String getFileName() {
            Object obj = this.fileName_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.fileName_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.proto.SoundProto.SoundFileOrBuilder
        public ByteString getFileNameBytes() {
            Object obj = this.fileName_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.fileName_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.mobvoi.companion.proto.SoundProto.SoundFileOrBuilder
        public long getFileSize() {
            return this.fileSize_;
        }

        @Override // com.mobvoi.companion.proto.SoundProto.SoundFileOrBuilder
        public FileStatus getFileStatus() {
            FileStatus valueOf = FileStatus.valueOf(this.fileStatus_);
            return valueOf == null ? FileStatus.UNRECOGNIZED : valueOf;
        }

        @Override // com.mobvoi.companion.proto.SoundProto.SoundFileOrBuilder
        public int getFileStatusValue() {
            return this.fileStatus_;
        }

        @Override // com.mobvoi.companion.proto.SoundProto.SoundFileOrBuilder
        public String getFileUrl() {
            Object obj = this.fileUrl_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.fileUrl_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.proto.SoundProto.SoundFileOrBuilder
        public ByteString getFileUrlBytes() {
            Object obj = this.fileUrl_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.fileUrl_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.mobvoi.companion.proto.SoundProto.SoundFileOrBuilder
        public String getFirstParagraph() {
            Object obj = this.firstParagraph_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.firstParagraph_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.proto.SoundProto.SoundFileOrBuilder
        public ByteString getFirstParagraphBytes() {
            Object obj = this.firstParagraph_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.firstParagraph_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.mobvoi.companion.proto.SoundProto.SoundFileOrBuilder
        public int getFlags(int i10) {
            return this.flags_.get(i10).intValue();
        }

        @Override // com.mobvoi.companion.proto.SoundProto.SoundFileOrBuilder
        public int getFlagsCount() {
            return this.flags_.size();
        }

        @Override // com.mobvoi.companion.proto.SoundProto.SoundFileOrBuilder
        public List<Integer> getFlagsList() {
            return this.flags_;
        }

        @Override // com.mobvoi.companion.proto.SoundProto.SoundFileOrBuilder
        public String getKeywords(int i10) {
            return this.keywords_.get(i10);
        }

        @Override // com.mobvoi.companion.proto.SoundProto.SoundFileOrBuilder
        public ByteString getKeywordsBytes(int i10) {
            return this.keywords_.o0(i10);
        }

        @Override // com.mobvoi.companion.proto.SoundProto.SoundFileOrBuilder
        public int getKeywordsCount() {
            return this.keywords_.size();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public l0<SoundFile> getParserForType() {
            return PARSER;
        }

        @Override // com.mobvoi.companion.proto.SoundProto.SoundFileOrBuilder
        public String getPercentage() {
            Object obj = this.percentage_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.percentage_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.proto.SoundProto.SoundFileOrBuilder
        public ByteString getPercentageBytes() {
            Object obj = this.percentage_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.percentage_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
        public int getSerializedSize() {
            int i10 = this.memoizedSize;
            if (i10 != -1) {
                return i10;
            }
            int computeStringSize = !getDeviceIdBytes().isEmpty() ? GeneratedMessageV3.computeStringSize(1, this.deviceId_) + 0 : 0;
            if (!getFileIdBytes().isEmpty()) {
                computeStringSize += GeneratedMessageV3.computeStringSize(2, this.fileId_);
            }
            if (!getFileNameBytes().isEmpty()) {
                computeStringSize += GeneratedMessageV3.computeStringSize(3, this.fileName_);
            }
            if (!getFileUrlBytes().isEmpty()) {
                computeStringSize += GeneratedMessageV3.computeStringSize(4, this.fileUrl_);
            }
            long j10 = this.fileSize_;
            if (j10 != 0) {
                computeStringSize += CodedOutputStream.x(5, j10);
            }
            int i11 = this.duration_;
            if (i11 != 0) {
                computeStringSize += CodedOutputStream.v(6, i11);
            }
            long j11 = this.timestamp_;
            if (j11 != 0) {
                computeStringSize += CodedOutputStream.x(7, j11);
            }
            int i12 = this.speakerNum_;
            if (i12 != 0) {
                computeStringSize += CodedOutputStream.v(8, i12);
            }
            int i13 = 0;
            for (int i14 = 0; i14 < this.flags_.size(); i14++) {
                i13 += CodedOutputStream.w(this.flags_.get(i14).intValue());
            }
            int i15 = computeStringSize + i13;
            if (!getFlagsList().isEmpty()) {
                i15 = i15 + 1 + CodedOutputStream.w(i13);
            }
            this.flagsMemoizedSerializedSize = i13;
            if (this.fileStatus_ != FileStatus.DEFAULT.getNumber()) {
                i15 += CodedOutputStream.l(10, this.fileStatus_);
            }
            if (this.deviceType_ != ConstantProto.DeviceType.UNKNOWN_DEVICE_TYPE.getNumber()) {
                i15 += CodedOutputStream.l(11, this.deviceType_);
            }
            if (!getPercentageBytes().isEmpty()) {
                i15 += GeneratedMessageV3.computeStringSize(12, this.percentage_);
            }
            if (!getFirstParagraphBytes().isEmpty()) {
                i15 += GeneratedMessageV3.computeStringSize(13, this.firstParagraph_);
            }
            int i16 = 0;
            for (int i17 = 0; i17 < this.keywords_.size(); i17++) {
                i16 += GeneratedMessageV3.computeStringSizeNoTag(this.keywords_.z0(i17));
            }
            int size = i15 + i16 + (getKeywordsList().size() * 1);
            this.memoizedSize = size;
            return size;
        }

        @Override // com.mobvoi.companion.proto.SoundProto.SoundFileOrBuilder
        public int getSpeakerNum() {
            return this.speakerNum_;
        }

        @Override // com.mobvoi.companion.proto.SoundProto.SoundFileOrBuilder
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
            int hashCode = ((((((((((((((((((((((((((((((((779 + getDescriptorForType().hashCode()) * 37) + 1) * 53) + getDeviceId().hashCode()) * 37) + 2) * 53) + getFileId().hashCode()) * 37) + 3) * 53) + getFileName().hashCode()) * 37) + 4) * 53) + getFileUrl().hashCode()) * 37) + 5) * 53) + u.h(getFileSize())) * 37) + 6) * 53) + getDuration()) * 37) + 7) * 53) + u.h(getTimestamp())) * 37) + 8) * 53) + getSpeakerNum();
            if (getFlagsCount() > 0) {
                hashCode = (((hashCode * 37) + 9) * 53) + getFlagsList().hashCode();
            }
            int hashCode2 = (((((((((((((((hashCode * 37) + 10) * 53) + this.fileStatus_) * 37) + 11) * 53) + this.deviceType_) * 37) + 12) * 53) + getPercentage().hashCode()) * 37) + 13) * 53) + getFirstParagraph().hashCode();
            if (getKeywordsCount() > 0) {
                hashCode2 = (((hashCode2 * 37) + 14) * 53) + getKeywordsList().hashCode();
            }
            int hashCode3 = (hashCode2 * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode3;
            return hashCode3;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return SoundProto.internal_static_com_mobvoi_companion_proto_SoundFile_fieldAccessorTable.e(SoundFile.class, Builder.class);
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
            getSerializedSize();
            if (!getDeviceIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.deviceId_);
            }
            if (!getFileIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.fileId_);
            }
            if (!getFileNameBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 3, this.fileName_);
            }
            if (!getFileUrlBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 4, this.fileUrl_);
            }
            long j10 = this.fileSize_;
            if (j10 != 0) {
                codedOutputStream.y0(5, j10);
            }
            int i10 = this.duration_;
            if (i10 != 0) {
                codedOutputStream.w0(6, i10);
            }
            long j11 = this.timestamp_;
            if (j11 != 0) {
                codedOutputStream.y0(7, j11);
            }
            int i11 = this.speakerNum_;
            if (i11 != 0) {
                codedOutputStream.w0(8, i11);
            }
            if (getFlagsList().size() > 0) {
                codedOutputStream.N0(74);
                codedOutputStream.N0(this.flagsMemoizedSerializedSize);
            }
            for (int i12 = 0; i12 < this.flags_.size(); i12++) {
                codedOutputStream.x0(this.flags_.get(i12).intValue());
            }
            if (this.fileStatus_ != FileStatus.DEFAULT.getNumber()) {
                codedOutputStream.m0(10, this.fileStatus_);
            }
            if (this.deviceType_ != ConstantProto.DeviceType.UNKNOWN_DEVICE_TYPE.getNumber()) {
                codedOutputStream.m0(11, this.deviceType_);
            }
            if (!getPercentageBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 12, this.percentage_);
            }
            if (!getFirstParagraphBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 13, this.firstParagraph_);
            }
            for (int i13 = 0; i13 < this.keywords_.size(); i13++) {
                GeneratedMessageV3.writeString(codedOutputStream, 14, this.keywords_.z0(i13));
            }
        }

        public static Builder newBuilder(SoundFile soundFile) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(soundFile);
        }

        public static SoundFile parseFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, qVar);
        }

        @Override // com.mobvoi.companion.proto.SoundProto.SoundFileOrBuilder
        public n0 getKeywordsList() {
            return this.keywords_;
        }

        private SoundFile(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.flagsMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
        }

        public static SoundFile parseDelimitedFrom(InputStream inputStream, q qVar) throws IOException {
            return (SoundFile) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
        }

        public static SoundFile parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
        public SoundFile getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static SoundFile parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static SoundFile parseFrom(InputStream inputStream) throws IOException {
            return (SoundFile) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.c cVar) {
            return new Builder(cVar);
        }

        private SoundFile() {
            this.flagsMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.deviceId_ = "";
            this.fileId_ = "";
            this.fileName_ = "";
            this.fileUrl_ = "";
            this.fileSize_ = 0L;
            this.duration_ = 0;
            this.timestamp_ = 0L;
            this.speakerNum_ = 0;
            this.flags_ = Collections.emptyList();
            this.fileStatus_ = 0;
            this.deviceType_ = 0;
            this.percentage_ = "";
            this.firstParagraph_ = "";
            this.keywords_ = x.f13385d;
        }

        public static SoundFile parseFrom(InputStream inputStream, q qVar) throws IOException {
            return (SoundFile) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
        }

        public static SoundFile parseFrom(i iVar) throws IOException {
            return (SoundFile) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
        }

        public static SoundFile parseFrom(i iVar, q qVar) throws IOException {
            return (SoundFile) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v1 */
        /* JADX WARN: Type inference failed for: r1v2, types: [boolean] */
        private SoundFile(i iVar, q qVar) throws InvalidProtocolBufferException {
            this();
            boolean z10 = false;
            boolean z11 = false;
            while (true) {
                ?? r12 = 8192;
                if (!z10) {
                    try {
                        try {
                            try {
                                int F = iVar.F();
                                z10 = true;
                                switch (F) {
                                    case 0:
                                        break;
                                    case 10:
                                        this.deviceId_ = iVar.E();
                                        continue;
                                    case 18:
                                        this.fileId_ = iVar.E();
                                        continue;
                                    case 26:
                                        this.fileName_ = iVar.E();
                                        continue;
                                    case 34:
                                        this.fileUrl_ = iVar.E();
                                        continue;
                                    case 40:
                                        this.fileSize_ = iVar.u();
                                        continue;
                                    case 48:
                                        this.duration_ = iVar.t();
                                        continue;
                                    case 56:
                                        this.timestamp_ = iVar.u();
                                        continue;
                                    case 64:
                                        this.speakerNum_ = iVar.t();
                                        continue;
                                    case 72:
                                        if (!(z11 & true)) {
                                            this.flags_ = new ArrayList();
                                            z11 |= true;
                                        }
                                        this.flags_.add(Integer.valueOf(iVar.t()));
                                        continue;
                                    case 74:
                                        int k10 = iVar.k(iVar.x());
                                        if (!(z11 & true) && iVar.d() > 0) {
                                            this.flags_ = new ArrayList();
                                            z11 |= true;
                                        }
                                        while (iVar.d() > 0) {
                                            this.flags_.add(Integer.valueOf(iVar.t()));
                                        }
                                        iVar.j(k10);
                                        continue;
                                        break;
                                    case 80:
                                        this.fileStatus_ = iVar.o();
                                        continue;
                                    case 88:
                                        this.deviceType_ = iVar.o();
                                        continue;
                                    case 98:
                                        this.percentage_ = iVar.E();
                                        continue;
                                    case 106:
                                        this.firstParagraph_ = iVar.E();
                                        continue;
                                    case 114:
                                        String E = iVar.E();
                                        if (!(z11 & true)) {
                                            this.keywords_ = new x();
                                            z11 |= true;
                                        }
                                        this.keywords_.add(E);
                                        continue;
                                    default:
                                        r12 = iVar.I(F);
                                        if (r12 == 0) {
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
                        if (z11 & true) {
                            this.flags_ = Collections.unmodifiableList(this.flags_);
                        }
                        if ((z11 & true) == r12) {
                            this.keywords_ = this.keywords_.u0();
                        }
                        makeExtensionsImmutable();
                    }
                } else {
                    return;
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class SoundFileDetailResp extends GeneratedMessageV3 implements SoundFileDetailRespOrBuilder {
        public static final int CONVERT_DATA_FIELD_NUMBER = 4;
        public static final int ERR_CODE_FIELD_NUMBER = 1;
        public static final int ERR_MSG_FIELD_NUMBER = 2;
        public static final int SOUND_FILE_FIELD_NUMBER = 3;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private List<ConvertData> convertData_;
        private int errCode_;
        private volatile Object errMsg_;
        private byte memoizedIsInitialized;
        private SoundFile soundFile_;
        private static final SoundFileDetailResp DEFAULT_INSTANCE = new SoundFileDetailResp();
        private static final l0<SoundFileDetailResp> PARSER = new c<SoundFileDetailResp>() { // from class: com.mobvoi.companion.proto.SoundProto.SoundFileDetailResp.1
            @Override // com.google.protobuf.l0
            public SoundFileDetailResp parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
                return new SoundFileDetailResp(iVar, qVar);
            }
        };

        public static SoundFileDetailResp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return SoundProto.internal_static_com_mobvoi_companion_proto_SoundFileDetailResp_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static SoundFileDetailResp parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (SoundFileDetailResp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static SoundFileDetailResp parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static l0<SoundFileDetailResp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof SoundFileDetailResp)) {
                return super.equals(obj);
            }
            SoundFileDetailResp soundFileDetailResp = (SoundFileDetailResp) obj;
            boolean z10 = ((getErrCode() == soundFileDetailResp.getErrCode()) && getErrMsg().equals(soundFileDetailResp.getErrMsg())) && hasSoundFile() == soundFileDetailResp.hasSoundFile();
            if (hasSoundFile()) {
                z10 = z10 && getSoundFile().equals(soundFileDetailResp.getSoundFile());
            }
            return z10 && getConvertDataList().equals(soundFileDetailResp.getConvertDataList());
        }

        @Override // com.mobvoi.companion.proto.SoundProto.SoundFileDetailRespOrBuilder
        public ConvertData getConvertData(int i10) {
            return this.convertData_.get(i10);
        }

        @Override // com.mobvoi.companion.proto.SoundProto.SoundFileDetailRespOrBuilder
        public int getConvertDataCount() {
            return this.convertData_.size();
        }

        @Override // com.mobvoi.companion.proto.SoundProto.SoundFileDetailRespOrBuilder
        public List<ConvertData> getConvertDataList() {
            return this.convertData_;
        }

        @Override // com.mobvoi.companion.proto.SoundProto.SoundFileDetailRespOrBuilder
        public ConvertDataOrBuilder getConvertDataOrBuilder(int i10) {
            return this.convertData_.get(i10);
        }

        @Override // com.mobvoi.companion.proto.SoundProto.SoundFileDetailRespOrBuilder
        public List<? extends ConvertDataOrBuilder> getConvertDataOrBuilderList() {
            return this.convertData_;
        }

        @Override // com.mobvoi.companion.proto.SoundProto.SoundFileDetailRespOrBuilder
        public int getErrCode() {
            return this.errCode_;
        }

        @Override // com.mobvoi.companion.proto.SoundProto.SoundFileDetailRespOrBuilder
        public String getErrMsg() {
            Object obj = this.errMsg_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.errMsg_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.proto.SoundProto.SoundFileDetailRespOrBuilder
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
        public l0<SoundFileDetailResp> getParserForType() {
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
            if (this.soundFile_ != null) {
                v10 += CodedOutputStream.E(3, getSoundFile());
            }
            for (int i12 = 0; i12 < this.convertData_.size(); i12++) {
                v10 += CodedOutputStream.E(4, this.convertData_.get(i12));
            }
            this.memoizedSize = v10;
            return v10;
        }

        @Override // com.mobvoi.companion.proto.SoundProto.SoundFileDetailRespOrBuilder
        public SoundFile getSoundFile() {
            SoundFile soundFile = this.soundFile_;
            return soundFile == null ? SoundFile.getDefaultInstance() : soundFile;
        }

        @Override // com.mobvoi.companion.proto.SoundProto.SoundFileDetailRespOrBuilder
        public SoundFileOrBuilder getSoundFileOrBuilder() {
            return getSoundFile();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.g0
        public final a1 getUnknownFields() {
            return a1.c();
        }

        @Override // com.mobvoi.companion.proto.SoundProto.SoundFileDetailRespOrBuilder
        public boolean hasSoundFile() {
            return this.soundFile_ != null;
        }

        @Override // com.google.protobuf.a
        public int hashCode() {
            int i10 = this.memoizedHashCode;
            if (i10 != 0) {
                return i10;
            }
            int hashCode = ((((((((779 + getDescriptorForType().hashCode()) * 37) + 1) * 53) + getErrCode()) * 37) + 2) * 53) + getErrMsg().hashCode();
            if (hasSoundFile()) {
                hashCode = (((hashCode * 37) + 3) * 53) + getSoundFile().hashCode();
            }
            if (getConvertDataCount() > 0) {
                hashCode = (((hashCode * 37) + 4) * 53) + getConvertDataList().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return SoundProto.internal_static_com_mobvoi_companion_proto_SoundFileDetailResp_fieldAccessorTable.e(SoundFileDetailResp.class, Builder.class);
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
            if (this.soundFile_ != null) {
                codedOutputStream.A0(3, getSoundFile());
            }
            for (int i11 = 0; i11 < this.convertData_.size(); i11++) {
                codedOutputStream.A0(4, this.convertData_.get(i11));
            }
        }

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageV3.b<Builder> implements SoundFileDetailRespOrBuilder {
            private int bitField0_;
            private o0<ConvertData, ConvertData.Builder, ConvertDataOrBuilder> convertDataBuilder_;
            private List<ConvertData> convertData_;
            private int errCode_;
            private Object errMsg_;
            private q0<SoundFile, SoundFile.Builder, SoundFileOrBuilder> soundFileBuilder_;
            private SoundFile soundFile_;

            private void ensureConvertDataIsMutable() {
                if ((this.bitField0_ & 8) != 8) {
                    this.convertData_ = new ArrayList(this.convertData_);
                    this.bitField0_ |= 8;
                }
            }

            private o0<ConvertData, ConvertData.Builder, ConvertDataOrBuilder> getConvertDataFieldBuilder() {
                if (this.convertDataBuilder_ == null) {
                    this.convertDataBuilder_ = new o0<>(this.convertData_, (this.bitField0_ & 8) == 8, getParentForChildren(), isClean());
                    this.convertData_ = null;
                }
                return this.convertDataBuilder_;
            }

            public static final Descriptors.b getDescriptor() {
                return SoundProto.internal_static_com_mobvoi_companion_proto_SoundFileDetailResp_descriptor;
            }

            private q0<SoundFile, SoundFile.Builder, SoundFileOrBuilder> getSoundFileFieldBuilder() {
                if (this.soundFileBuilder_ == null) {
                    this.soundFileBuilder_ = new q0<>(getSoundFile(), getParentForChildren(), isClean());
                    this.soundFile_ = null;
                }
                return this.soundFileBuilder_;
            }

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                    getConvertDataFieldBuilder();
                }
            }

            public Builder addAllConvertData(Iterable<? extends ConvertData> iterable) {
                o0<ConvertData, ConvertData.Builder, ConvertDataOrBuilder> o0Var = this.convertDataBuilder_;
                if (o0Var == null) {
                    ensureConvertDataIsMutable();
                    b.a.addAll(iterable, this.convertData_);
                    onChanged();
                } else {
                    o0Var.b(iterable);
                }
                return this;
            }

            public Builder addConvertData(ConvertData convertData) {
                o0<ConvertData, ConvertData.Builder, ConvertDataOrBuilder> o0Var = this.convertDataBuilder_;
                if (o0Var == null) {
                    Objects.requireNonNull(convertData);
                    ensureConvertDataIsMutable();
                    this.convertData_.add(convertData);
                    onChanged();
                } else {
                    o0Var.f(convertData);
                }
                return this;
            }

            public ConvertData.Builder addConvertDataBuilder() {
                return getConvertDataFieldBuilder().d(ConvertData.getDefaultInstance());
            }

            public Builder clearConvertData() {
                o0<ConvertData, ConvertData.Builder, ConvertDataOrBuilder> o0Var = this.convertDataBuilder_;
                if (o0Var == null) {
                    this.convertData_ = Collections.emptyList();
                    this.bitField0_ &= -9;
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
                this.errMsg_ = SoundFileDetailResp.getDefaultInstance().getErrMsg();
                onChanged();
                return this;
            }

            public Builder clearSoundFile() {
                if (this.soundFileBuilder_ == null) {
                    this.soundFile_ = null;
                    onChanged();
                } else {
                    this.soundFile_ = null;
                    this.soundFileBuilder_ = null;
                }
                return this;
            }

            @Override // com.mobvoi.companion.proto.SoundProto.SoundFileDetailRespOrBuilder
            public ConvertData getConvertData(int i10) {
                o0<ConvertData, ConvertData.Builder, ConvertDataOrBuilder> o0Var = this.convertDataBuilder_;
                if (o0Var == null) {
                    return this.convertData_.get(i10);
                }
                return o0Var.o(i10);
            }

            public ConvertData.Builder getConvertDataBuilder(int i10) {
                return getConvertDataFieldBuilder().l(i10);
            }

            public List<ConvertData.Builder> getConvertDataBuilderList() {
                return getConvertDataFieldBuilder().m();
            }

            @Override // com.mobvoi.companion.proto.SoundProto.SoundFileDetailRespOrBuilder
            public int getConvertDataCount() {
                o0<ConvertData, ConvertData.Builder, ConvertDataOrBuilder> o0Var = this.convertDataBuilder_;
                if (o0Var == null) {
                    return this.convertData_.size();
                }
                return o0Var.n();
            }

            @Override // com.mobvoi.companion.proto.SoundProto.SoundFileDetailRespOrBuilder
            public List<ConvertData> getConvertDataList() {
                o0<ConvertData, ConvertData.Builder, ConvertDataOrBuilder> o0Var = this.convertDataBuilder_;
                if (o0Var == null) {
                    return Collections.unmodifiableList(this.convertData_);
                }
                return o0Var.q();
            }

            @Override // com.mobvoi.companion.proto.SoundProto.SoundFileDetailRespOrBuilder
            public ConvertDataOrBuilder getConvertDataOrBuilder(int i10) {
                o0<ConvertData, ConvertData.Builder, ConvertDataOrBuilder> o0Var = this.convertDataBuilder_;
                if (o0Var == null) {
                    return this.convertData_.get(i10);
                }
                return o0Var.r(i10);
            }

            @Override // com.mobvoi.companion.proto.SoundProto.SoundFileDetailRespOrBuilder
            public List<? extends ConvertDataOrBuilder> getConvertDataOrBuilderList() {
                o0<ConvertData, ConvertData.Builder, ConvertDataOrBuilder> o0Var = this.convertDataBuilder_;
                if (o0Var != null) {
                    return o0Var.s();
                }
                return Collections.unmodifiableList(this.convertData_);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a, com.google.protobuf.g0
            public Descriptors.b getDescriptorForType() {
                return SoundProto.internal_static_com_mobvoi_companion_proto_SoundFileDetailResp_descriptor;
            }

            @Override // com.mobvoi.companion.proto.SoundProto.SoundFileDetailRespOrBuilder
            public int getErrCode() {
                return this.errCode_;
            }

            @Override // com.mobvoi.companion.proto.SoundProto.SoundFileDetailRespOrBuilder
            public String getErrMsg() {
                Object obj = this.errMsg_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.errMsg_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.proto.SoundProto.SoundFileDetailRespOrBuilder
            public ByteString getErrMsgBytes() {
                Object obj = this.errMsg_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.errMsg_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.mobvoi.companion.proto.SoundProto.SoundFileDetailRespOrBuilder
            public SoundFile getSoundFile() {
                q0<SoundFile, SoundFile.Builder, SoundFileOrBuilder> q0Var = this.soundFileBuilder_;
                if (q0Var != null) {
                    return q0Var.f();
                }
                SoundFile soundFile = this.soundFile_;
                return soundFile == null ? SoundFile.getDefaultInstance() : soundFile;
            }

            public SoundFile.Builder getSoundFileBuilder() {
                onChanged();
                return getSoundFileFieldBuilder().e();
            }

            @Override // com.mobvoi.companion.proto.SoundProto.SoundFileDetailRespOrBuilder
            public SoundFileOrBuilder getSoundFileOrBuilder() {
                q0<SoundFile, SoundFile.Builder, SoundFileOrBuilder> q0Var = this.soundFileBuilder_;
                if (q0Var != null) {
                    return q0Var.g();
                }
                SoundFile soundFile = this.soundFile_;
                return soundFile == null ? SoundFile.getDefaultInstance() : soundFile;
            }

            @Override // com.mobvoi.companion.proto.SoundProto.SoundFileDetailRespOrBuilder
            public boolean hasSoundFile() {
                return (this.soundFileBuilder_ == null && this.soundFile_ == null) ? false : true;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return SoundProto.internal_static_com_mobvoi_companion_proto_SoundFileDetailResp_fieldAccessorTable.e(SoundFileDetailResp.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.f0
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeSoundFile(SoundFile soundFile) {
                q0<SoundFile, SoundFile.Builder, SoundFileOrBuilder> q0Var = this.soundFileBuilder_;
                if (q0Var == null) {
                    SoundFile soundFile2 = this.soundFile_;
                    if (soundFile2 != null) {
                        this.soundFile_ = SoundFile.newBuilder(soundFile2).mergeFrom(soundFile).buildPartial();
                    } else {
                        this.soundFile_ = soundFile;
                    }
                    onChanged();
                } else {
                    q0Var.h(soundFile);
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a
            public final Builder mergeUnknownFields(a1 a1Var) {
                return this;
            }

            public Builder removeConvertData(int i10) {
                o0<ConvertData, ConvertData.Builder, ConvertDataOrBuilder> o0Var = this.convertDataBuilder_;
                if (o0Var == null) {
                    ensureConvertDataIsMutable();
                    this.convertData_.remove(i10);
                    onChanged();
                } else {
                    o0Var.w(i10);
                }
                return this;
            }

            public Builder setConvertData(int i10, ConvertData convertData) {
                o0<ConvertData, ConvertData.Builder, ConvertDataOrBuilder> o0Var = this.convertDataBuilder_;
                if (o0Var == null) {
                    Objects.requireNonNull(convertData);
                    ensureConvertDataIsMutable();
                    this.convertData_.set(i10, convertData);
                    onChanged();
                } else {
                    o0Var.x(i10, convertData);
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

            public Builder setSoundFile(SoundFile soundFile) {
                q0<SoundFile, SoundFile.Builder, SoundFileOrBuilder> q0Var = this.soundFileBuilder_;
                if (q0Var == null) {
                    Objects.requireNonNull(soundFile);
                    this.soundFile_ = soundFile;
                    onChanged();
                } else {
                    q0Var.j(soundFile);
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public final Builder setUnknownFields(a1 a1Var) {
                return this;
            }

            private Builder() {
                this.errMsg_ = "";
                this.soundFile_ = null;
                this.convertData_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.e0.a, com.google.protobuf.d0.a
            public SoundFileDetailResp build() {
                SoundFileDetailResp buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) buildPartial);
            }

            @Override // com.google.protobuf.e0.a, com.google.protobuf.d0.a
            public SoundFileDetailResp buildPartial() {
                SoundFileDetailResp soundFileDetailResp = new SoundFileDetailResp(this);
                soundFileDetailResp.errCode_ = this.errCode_;
                soundFileDetailResp.errMsg_ = this.errMsg_;
                q0<SoundFile, SoundFile.Builder, SoundFileOrBuilder> q0Var = this.soundFileBuilder_;
                if (q0Var == null) {
                    soundFileDetailResp.soundFile_ = this.soundFile_;
                } else {
                    soundFileDetailResp.soundFile_ = q0Var.b();
                }
                o0<ConvertData, ConvertData.Builder, ConvertDataOrBuilder> o0Var = this.convertDataBuilder_;
                if (o0Var == null) {
                    if ((this.bitField0_ & 8) == 8) {
                        this.convertData_ = Collections.unmodifiableList(this.convertData_);
                        this.bitField0_ &= -9;
                    }
                    soundFileDetailResp.convertData_ = this.convertData_;
                } else {
                    soundFileDetailResp.convertData_ = o0Var.g();
                }
                soundFileDetailResp.bitField0_ = 0;
                onBuilt();
                return soundFileDetailResp;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.f0, com.google.protobuf.g0
            public SoundFileDetailResp getDefaultInstanceForType() {
                return SoundFileDetailResp.getDefaultInstance();
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

            public ConvertData.Builder addConvertDataBuilder(int i10) {
                return getConvertDataFieldBuilder().c(i10, ConvertData.getDefaultInstance());
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
                if (this.soundFileBuilder_ == null) {
                    this.soundFile_ = null;
                } else {
                    this.soundFile_ = null;
                    this.soundFileBuilder_ = null;
                }
                o0<ConvertData, ConvertData.Builder, ConvertDataOrBuilder> o0Var = this.convertDataBuilder_;
                if (o0Var == null) {
                    this.convertData_ = Collections.emptyList();
                    this.bitField0_ &= -9;
                } else {
                    o0Var.h();
                }
                return this;
            }

            public Builder setSoundFile(SoundFile.Builder builder) {
                q0<SoundFile, SoundFile.Builder, SoundFileOrBuilder> q0Var = this.soundFileBuilder_;
                if (q0Var == null) {
                    this.soundFile_ = builder.build();
                    onChanged();
                } else {
                    q0Var.j(builder.build());
                }
                return this;
            }

            public Builder addConvertData(int i10, ConvertData convertData) {
                o0<ConvertData, ConvertData.Builder, ConvertDataOrBuilder> o0Var = this.convertDataBuilder_;
                if (o0Var == null) {
                    Objects.requireNonNull(convertData);
                    ensureConvertDataIsMutable();
                    this.convertData_.add(i10, convertData);
                    onChanged();
                } else {
                    o0Var.e(i10, convertData);
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a, com.google.protobuf.b.a
            public Builder clone() {
                return (Builder) super.clone();
            }

            @Override // com.google.protobuf.a.AbstractC0170a, com.google.protobuf.d0.a
            public Builder mergeFrom(d0 d0Var) {
                if (d0Var instanceof SoundFileDetailResp) {
                    return mergeFrom((SoundFileDetailResp) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            public Builder setConvertData(int i10, ConvertData.Builder builder) {
                o0<ConvertData, ConvertData.Builder, ConvertDataOrBuilder> o0Var = this.convertDataBuilder_;
                if (o0Var == null) {
                    ensureConvertDataIsMutable();
                    this.convertData_.set(i10, builder.build());
                    onChanged();
                } else {
                    o0Var.x(i10, builder.build());
                }
                return this;
            }

            private Builder(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.errMsg_ = "";
                this.soundFile_ = null;
                this.convertData_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            public Builder mergeFrom(SoundFileDetailResp soundFileDetailResp) {
                if (soundFileDetailResp == SoundFileDetailResp.getDefaultInstance()) {
                    return this;
                }
                if (soundFileDetailResp.getErrCode() != 0) {
                    setErrCode(soundFileDetailResp.getErrCode());
                }
                if (!soundFileDetailResp.getErrMsg().isEmpty()) {
                    this.errMsg_ = soundFileDetailResp.errMsg_;
                    onChanged();
                }
                if (soundFileDetailResp.hasSoundFile()) {
                    mergeSoundFile(soundFileDetailResp.getSoundFile());
                }
                if (this.convertDataBuilder_ == null) {
                    if (!soundFileDetailResp.convertData_.isEmpty()) {
                        if (this.convertData_.isEmpty()) {
                            this.convertData_ = soundFileDetailResp.convertData_;
                            this.bitField0_ &= -9;
                        } else {
                            ensureConvertDataIsMutable();
                            this.convertData_.addAll(soundFileDetailResp.convertData_);
                        }
                        onChanged();
                    }
                } else if (!soundFileDetailResp.convertData_.isEmpty()) {
                    if (this.convertDataBuilder_.u()) {
                        this.convertDataBuilder_.i();
                        o0<ConvertData, ConvertData.Builder, ConvertDataOrBuilder> o0Var = null;
                        this.convertDataBuilder_ = null;
                        this.convertData_ = soundFileDetailResp.convertData_;
                        this.bitField0_ &= -9;
                        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                            o0Var = getConvertDataFieldBuilder();
                        }
                        this.convertDataBuilder_ = o0Var;
                    } else {
                        this.convertDataBuilder_.b(soundFileDetailResp.convertData_);
                    }
                }
                onChanged();
                return this;
            }

            public Builder addConvertData(ConvertData.Builder builder) {
                o0<ConvertData, ConvertData.Builder, ConvertDataOrBuilder> o0Var = this.convertDataBuilder_;
                if (o0Var == null) {
                    ensureConvertDataIsMutable();
                    this.convertData_.add(builder.build());
                    onChanged();
                } else {
                    o0Var.f(builder.build());
                }
                return this;
            }

            public Builder addConvertData(int i10, ConvertData.Builder builder) {
                o0<ConvertData, ConvertData.Builder, ConvertDataOrBuilder> o0Var = this.convertDataBuilder_;
                if (o0Var == null) {
                    ensureConvertDataIsMutable();
                    this.convertData_.add(i10, builder.build());
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
                SoundFileDetailResp soundFileDetailResp = null;
                try {
                    try {
                        SoundFileDetailResp soundFileDetailResp2 = (SoundFileDetailResp) SoundFileDetailResp.PARSER.parsePartialFrom(iVar, qVar);
                        if (soundFileDetailResp2 != null) {
                            mergeFrom(soundFileDetailResp2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e10) {
                        soundFileDetailResp = (SoundFileDetailResp) e10.getUnfinishedMessage();
                        try {
                            throw e10.unwrapIOException();
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (soundFileDetailResp != null) {
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (soundFileDetailResp != null) {
                        mergeFrom(soundFileDetailResp);
                    }
                    throw th2;
                }
            }
        }

        public static Builder newBuilder(SoundFileDetailResp soundFileDetailResp) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(soundFileDetailResp);
        }

        public static SoundFileDetailResp parseFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, qVar);
        }

        private SoundFileDetailResp(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static SoundFileDetailResp parseDelimitedFrom(InputStream inputStream, q qVar) throws IOException {
            return (SoundFileDetailResp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
        }

        public static SoundFileDetailResp parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
        public SoundFileDetailResp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static SoundFileDetailResp parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder newBuilderForType() {
            return newBuilder();
        }

        private SoundFileDetailResp() {
            this.memoizedIsInitialized = (byte) -1;
            this.errCode_ = 0;
            this.errMsg_ = "";
            this.convertData_ = Collections.emptyList();
        }

        public static SoundFileDetailResp parseFrom(InputStream inputStream) throws IOException {
            return (SoundFileDetailResp) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.c cVar) {
            return new Builder(cVar);
        }

        public static SoundFileDetailResp parseFrom(InputStream inputStream, q qVar) throws IOException {
            return (SoundFileDetailResp) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
        }

        public static SoundFileDetailResp parseFrom(i iVar) throws IOException {
            return (SoundFileDetailResp) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
        }

        private SoundFileDetailResp(i iVar, q qVar) throws InvalidProtocolBufferException {
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
                                if (F == 8) {
                                    this.errCode_ = iVar.t();
                                } else if (F == 18) {
                                    this.errMsg_ = iVar.E();
                                } else if (F == 26) {
                                    SoundFile.Builder builder = null;
                                    SoundFile soundFile = this.soundFile_;
                                    builder = soundFile != null ? soundFile.toBuilder() : builder;
                                    SoundFile soundFile2 = (SoundFile) iVar.v(SoundFile.parser(), qVar);
                                    this.soundFile_ = soundFile2;
                                    if (builder != null) {
                                        builder.mergeFrom(soundFile2);
                                        this.soundFile_ = builder.buildPartial();
                                    }
                                } else if (F == 34) {
                                    if (!(z11 & true)) {
                                        this.convertData_ = new ArrayList();
                                        z11 |= true;
                                    }
                                    this.convertData_.add((ConvertData) iVar.v(ConvertData.parser(), qVar));
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
                    if (z11 & true) {
                        this.convertData_ = Collections.unmodifiableList(this.convertData_);
                    }
                    makeExtensionsImmutable();
                }
            }
        }

        public static SoundFileDetailResp parseFrom(i iVar, q qVar) throws IOException {
            return (SoundFileDetailResp) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
        }
    }

    /* loaded from: classes2.dex */
    public interface SoundFileDetailRespOrBuilder extends g0 {
        /* synthetic */ List<String> findInitializationErrors();

        @Override // com.google.protobuf.g0
        /* synthetic */ Map<Descriptors.FieldDescriptor, Object> getAllFields();

        ConvertData getConvertData(int i10);

        int getConvertDataCount();

        List<ConvertData> getConvertDataList();

        ConvertDataOrBuilder getConvertDataOrBuilder(int i10);

        List<? extends ConvertDataOrBuilder> getConvertDataOrBuilderList();

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

        SoundFile getSoundFile();

        SoundFileOrBuilder getSoundFileOrBuilder();

        @Override // com.google.protobuf.g0
        /* synthetic */ a1 getUnknownFields();

        @Override // com.google.protobuf.g0
        /* synthetic */ boolean hasField(Descriptors.FieldDescriptor fieldDescriptor);

        /* synthetic */ boolean hasOneof(Descriptors.h hVar);

        boolean hasSoundFile();

        @Override // com.google.protobuf.f0
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes2.dex */
    public interface SoundFileOrBuilder extends g0 {
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

        ConstantProto.DeviceType getDeviceType();

        int getDeviceTypeValue();

        int getDuration();

        @Override // com.google.protobuf.g0
        /* synthetic */ Object getField(Descriptors.FieldDescriptor fieldDescriptor);

        String getFileId();

        ByteString getFileIdBytes();

        String getFileName();

        ByteString getFileNameBytes();

        long getFileSize();

        FileStatus getFileStatus();

        int getFileStatusValue();

        String getFileUrl();

        ByteString getFileUrlBytes();

        String getFirstParagraph();

        ByteString getFirstParagraphBytes();

        int getFlags(int i10);

        int getFlagsCount();

        List<Integer> getFlagsList();

        /* synthetic */ String getInitializationErrorString();

        String getKeywords(int i10);

        ByteString getKeywordsBytes(int i10);

        int getKeywordsCount();

        List<String> getKeywordsList();

        /* synthetic */ Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.h hVar);

        String getPercentage();

        ByteString getPercentageBytes();

        /* synthetic */ Object getRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i10);

        /* synthetic */ int getRepeatedFieldCount(Descriptors.FieldDescriptor fieldDescriptor);

        int getSpeakerNum();

        long getTimestamp();

        @Override // com.google.protobuf.g0
        /* synthetic */ a1 getUnknownFields();

        @Override // com.google.protobuf.g0
        /* synthetic */ boolean hasField(Descriptors.FieldDescriptor fieldDescriptor);

        /* synthetic */ boolean hasOneof(Descriptors.h hVar);

        @Override // com.google.protobuf.f0
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes2.dex */
    public static final class SoundFileResp extends GeneratedMessageV3 implements SoundFileRespOrBuilder {
        public static final int ERR_CODE_FIELD_NUMBER = 1;
        public static final int ERR_MSG_FIELD_NUMBER = 2;
        public static final int SOUND_FILES_FIELD_NUMBER = 3;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private int errCode_;
        private volatile Object errMsg_;
        private byte memoizedIsInitialized;
        private List<SoundFile> soundFiles_;
        private static final SoundFileResp DEFAULT_INSTANCE = new SoundFileResp();
        private static final l0<SoundFileResp> PARSER = new c<SoundFileResp>() { // from class: com.mobvoi.companion.proto.SoundProto.SoundFileResp.1
            @Override // com.google.protobuf.l0
            public SoundFileResp parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
                return new SoundFileResp(iVar, qVar);
            }
        };

        public static SoundFileResp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return SoundProto.internal_static_com_mobvoi_companion_proto_SoundFileResp_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static SoundFileResp parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (SoundFileResp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static SoundFileResp parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static l0<SoundFileResp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof SoundFileResp)) {
                return super.equals(obj);
            }
            SoundFileResp soundFileResp = (SoundFileResp) obj;
            return ((getErrCode() == soundFileResp.getErrCode()) && getErrMsg().equals(soundFileResp.getErrMsg())) && getSoundFilesList().equals(soundFileResp.getSoundFilesList());
        }

        @Override // com.mobvoi.companion.proto.SoundProto.SoundFileRespOrBuilder
        public int getErrCode() {
            return this.errCode_;
        }

        @Override // com.mobvoi.companion.proto.SoundProto.SoundFileRespOrBuilder
        public String getErrMsg() {
            Object obj = this.errMsg_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.errMsg_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.proto.SoundProto.SoundFileRespOrBuilder
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
        public l0<SoundFileResp> getParserForType() {
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
            for (int i12 = 0; i12 < this.soundFiles_.size(); i12++) {
                v10 += CodedOutputStream.E(3, this.soundFiles_.get(i12));
            }
            this.memoizedSize = v10;
            return v10;
        }

        @Override // com.mobvoi.companion.proto.SoundProto.SoundFileRespOrBuilder
        public SoundFile getSoundFiles(int i10) {
            return this.soundFiles_.get(i10);
        }

        @Override // com.mobvoi.companion.proto.SoundProto.SoundFileRespOrBuilder
        public int getSoundFilesCount() {
            return this.soundFiles_.size();
        }

        @Override // com.mobvoi.companion.proto.SoundProto.SoundFileRespOrBuilder
        public List<SoundFile> getSoundFilesList() {
            return this.soundFiles_;
        }

        @Override // com.mobvoi.companion.proto.SoundProto.SoundFileRespOrBuilder
        public SoundFileOrBuilder getSoundFilesOrBuilder(int i10) {
            return this.soundFiles_.get(i10);
        }

        @Override // com.mobvoi.companion.proto.SoundProto.SoundFileRespOrBuilder
        public List<? extends SoundFileOrBuilder> getSoundFilesOrBuilderList() {
            return this.soundFiles_;
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
            if (getSoundFilesCount() > 0) {
                hashCode = (((hashCode * 37) + 3) * 53) + getSoundFilesList().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return SoundProto.internal_static_com_mobvoi_companion_proto_SoundFileResp_fieldAccessorTable.e(SoundFileResp.class, Builder.class);
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
            for (int i11 = 0; i11 < this.soundFiles_.size(); i11++) {
                codedOutputStream.A0(3, this.soundFiles_.get(i11));
            }
        }

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageV3.b<Builder> implements SoundFileRespOrBuilder {
            private int bitField0_;
            private int errCode_;
            private Object errMsg_;
            private o0<SoundFile, SoundFile.Builder, SoundFileOrBuilder> soundFilesBuilder_;
            private List<SoundFile> soundFiles_;

            private void ensureSoundFilesIsMutable() {
                if ((this.bitField0_ & 4) != 4) {
                    this.soundFiles_ = new ArrayList(this.soundFiles_);
                    this.bitField0_ |= 4;
                }
            }

            public static final Descriptors.b getDescriptor() {
                return SoundProto.internal_static_com_mobvoi_companion_proto_SoundFileResp_descriptor;
            }

            private o0<SoundFile, SoundFile.Builder, SoundFileOrBuilder> getSoundFilesFieldBuilder() {
                if (this.soundFilesBuilder_ == null) {
                    this.soundFilesBuilder_ = new o0<>(this.soundFiles_, (this.bitField0_ & 4) == 4, getParentForChildren(), isClean());
                    this.soundFiles_ = null;
                }
                return this.soundFilesBuilder_;
            }

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                    getSoundFilesFieldBuilder();
                }
            }

            public Builder addAllSoundFiles(Iterable<? extends SoundFile> iterable) {
                o0<SoundFile, SoundFile.Builder, SoundFileOrBuilder> o0Var = this.soundFilesBuilder_;
                if (o0Var == null) {
                    ensureSoundFilesIsMutable();
                    b.a.addAll(iterable, this.soundFiles_);
                    onChanged();
                } else {
                    o0Var.b(iterable);
                }
                return this;
            }

            public Builder addSoundFiles(SoundFile soundFile) {
                o0<SoundFile, SoundFile.Builder, SoundFileOrBuilder> o0Var = this.soundFilesBuilder_;
                if (o0Var == null) {
                    Objects.requireNonNull(soundFile);
                    ensureSoundFilesIsMutable();
                    this.soundFiles_.add(soundFile);
                    onChanged();
                } else {
                    o0Var.f(soundFile);
                }
                return this;
            }

            public SoundFile.Builder addSoundFilesBuilder() {
                return getSoundFilesFieldBuilder().d(SoundFile.getDefaultInstance());
            }

            public Builder clearErrCode() {
                this.errCode_ = 0;
                onChanged();
                return this;
            }

            public Builder clearErrMsg() {
                this.errMsg_ = SoundFileResp.getDefaultInstance().getErrMsg();
                onChanged();
                return this;
            }

            public Builder clearSoundFiles() {
                o0<SoundFile, SoundFile.Builder, SoundFileOrBuilder> o0Var = this.soundFilesBuilder_;
                if (o0Var == null) {
                    this.soundFiles_ = Collections.emptyList();
                    this.bitField0_ &= -5;
                    onChanged();
                } else {
                    o0Var.h();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a, com.google.protobuf.g0
            public Descriptors.b getDescriptorForType() {
                return SoundProto.internal_static_com_mobvoi_companion_proto_SoundFileResp_descriptor;
            }

            @Override // com.mobvoi.companion.proto.SoundProto.SoundFileRespOrBuilder
            public int getErrCode() {
                return this.errCode_;
            }

            @Override // com.mobvoi.companion.proto.SoundProto.SoundFileRespOrBuilder
            public String getErrMsg() {
                Object obj = this.errMsg_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.errMsg_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.proto.SoundProto.SoundFileRespOrBuilder
            public ByteString getErrMsgBytes() {
                Object obj = this.errMsg_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.errMsg_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.mobvoi.companion.proto.SoundProto.SoundFileRespOrBuilder
            public SoundFile getSoundFiles(int i10) {
                o0<SoundFile, SoundFile.Builder, SoundFileOrBuilder> o0Var = this.soundFilesBuilder_;
                if (o0Var == null) {
                    return this.soundFiles_.get(i10);
                }
                return o0Var.o(i10);
            }

            public SoundFile.Builder getSoundFilesBuilder(int i10) {
                return getSoundFilesFieldBuilder().l(i10);
            }

            public List<SoundFile.Builder> getSoundFilesBuilderList() {
                return getSoundFilesFieldBuilder().m();
            }

            @Override // com.mobvoi.companion.proto.SoundProto.SoundFileRespOrBuilder
            public int getSoundFilesCount() {
                o0<SoundFile, SoundFile.Builder, SoundFileOrBuilder> o0Var = this.soundFilesBuilder_;
                if (o0Var == null) {
                    return this.soundFiles_.size();
                }
                return o0Var.n();
            }

            @Override // com.mobvoi.companion.proto.SoundProto.SoundFileRespOrBuilder
            public List<SoundFile> getSoundFilesList() {
                o0<SoundFile, SoundFile.Builder, SoundFileOrBuilder> o0Var = this.soundFilesBuilder_;
                if (o0Var == null) {
                    return Collections.unmodifiableList(this.soundFiles_);
                }
                return o0Var.q();
            }

            @Override // com.mobvoi.companion.proto.SoundProto.SoundFileRespOrBuilder
            public SoundFileOrBuilder getSoundFilesOrBuilder(int i10) {
                o0<SoundFile, SoundFile.Builder, SoundFileOrBuilder> o0Var = this.soundFilesBuilder_;
                if (o0Var == null) {
                    return this.soundFiles_.get(i10);
                }
                return o0Var.r(i10);
            }

            @Override // com.mobvoi.companion.proto.SoundProto.SoundFileRespOrBuilder
            public List<? extends SoundFileOrBuilder> getSoundFilesOrBuilderList() {
                o0<SoundFile, SoundFile.Builder, SoundFileOrBuilder> o0Var = this.soundFilesBuilder_;
                if (o0Var != null) {
                    return o0Var.s();
                }
                return Collections.unmodifiableList(this.soundFiles_);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return SoundProto.internal_static_com_mobvoi_companion_proto_SoundFileResp_fieldAccessorTable.e(SoundFileResp.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.f0
            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a
            public final Builder mergeUnknownFields(a1 a1Var) {
                return this;
            }

            public Builder removeSoundFiles(int i10) {
                o0<SoundFile, SoundFile.Builder, SoundFileOrBuilder> o0Var = this.soundFilesBuilder_;
                if (o0Var == null) {
                    ensureSoundFilesIsMutable();
                    this.soundFiles_.remove(i10);
                    onChanged();
                } else {
                    o0Var.w(i10);
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

            public Builder setSoundFiles(int i10, SoundFile soundFile) {
                o0<SoundFile, SoundFile.Builder, SoundFileOrBuilder> o0Var = this.soundFilesBuilder_;
                if (o0Var == null) {
                    Objects.requireNonNull(soundFile);
                    ensureSoundFilesIsMutable();
                    this.soundFiles_.set(i10, soundFile);
                    onChanged();
                } else {
                    o0Var.x(i10, soundFile);
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public final Builder setUnknownFields(a1 a1Var) {
                return this;
            }

            private Builder() {
                this.errMsg_ = "";
                this.soundFiles_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.e0.a, com.google.protobuf.d0.a
            public SoundFileResp build() {
                SoundFileResp buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) buildPartial);
            }

            @Override // com.google.protobuf.e0.a, com.google.protobuf.d0.a
            public SoundFileResp buildPartial() {
                SoundFileResp soundFileResp = new SoundFileResp(this);
                soundFileResp.errCode_ = this.errCode_;
                soundFileResp.errMsg_ = this.errMsg_;
                o0<SoundFile, SoundFile.Builder, SoundFileOrBuilder> o0Var = this.soundFilesBuilder_;
                if (o0Var == null) {
                    if ((this.bitField0_ & 4) == 4) {
                        this.soundFiles_ = Collections.unmodifiableList(this.soundFiles_);
                        this.bitField0_ &= -5;
                    }
                    soundFileResp.soundFiles_ = this.soundFiles_;
                } else {
                    soundFileResp.soundFiles_ = o0Var.g();
                }
                soundFileResp.bitField0_ = 0;
                onBuilt();
                return soundFileResp;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.f0, com.google.protobuf.g0
            public SoundFileResp getDefaultInstanceForType() {
                return SoundFileResp.getDefaultInstance();
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

            public SoundFile.Builder addSoundFilesBuilder(int i10) {
                return getSoundFilesFieldBuilder().c(i10, SoundFile.getDefaultInstance());
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
                o0<SoundFile, SoundFile.Builder, SoundFileOrBuilder> o0Var = this.soundFilesBuilder_;
                if (o0Var == null) {
                    this.soundFiles_ = Collections.emptyList();
                    this.bitField0_ &= -5;
                } else {
                    o0Var.h();
                }
                return this;
            }

            private Builder(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.errMsg_ = "";
                this.soundFiles_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            public Builder addSoundFiles(int i10, SoundFile soundFile) {
                o0<SoundFile, SoundFile.Builder, SoundFileOrBuilder> o0Var = this.soundFilesBuilder_;
                if (o0Var == null) {
                    Objects.requireNonNull(soundFile);
                    ensureSoundFilesIsMutable();
                    this.soundFiles_.add(i10, soundFile);
                    onChanged();
                } else {
                    o0Var.e(i10, soundFile);
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a, com.google.protobuf.b.a
            public Builder clone() {
                return (Builder) super.clone();
            }

            @Override // com.google.protobuf.a.AbstractC0170a, com.google.protobuf.d0.a
            public Builder mergeFrom(d0 d0Var) {
                if (d0Var instanceof SoundFileResp) {
                    return mergeFrom((SoundFileResp) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            public Builder setSoundFiles(int i10, SoundFile.Builder builder) {
                o0<SoundFile, SoundFile.Builder, SoundFileOrBuilder> o0Var = this.soundFilesBuilder_;
                if (o0Var == null) {
                    ensureSoundFilesIsMutable();
                    this.soundFiles_.set(i10, builder.build());
                    onChanged();
                } else {
                    o0Var.x(i10, builder.build());
                }
                return this;
            }

            public Builder mergeFrom(SoundFileResp soundFileResp) {
                if (soundFileResp == SoundFileResp.getDefaultInstance()) {
                    return this;
                }
                if (soundFileResp.getErrCode() != 0) {
                    setErrCode(soundFileResp.getErrCode());
                }
                if (!soundFileResp.getErrMsg().isEmpty()) {
                    this.errMsg_ = soundFileResp.errMsg_;
                    onChanged();
                }
                if (this.soundFilesBuilder_ == null) {
                    if (!soundFileResp.soundFiles_.isEmpty()) {
                        if (this.soundFiles_.isEmpty()) {
                            this.soundFiles_ = soundFileResp.soundFiles_;
                            this.bitField0_ &= -5;
                        } else {
                            ensureSoundFilesIsMutable();
                            this.soundFiles_.addAll(soundFileResp.soundFiles_);
                        }
                        onChanged();
                    }
                } else if (!soundFileResp.soundFiles_.isEmpty()) {
                    if (this.soundFilesBuilder_.u()) {
                        this.soundFilesBuilder_.i();
                        o0<SoundFile, SoundFile.Builder, SoundFileOrBuilder> o0Var = null;
                        this.soundFilesBuilder_ = null;
                        this.soundFiles_ = soundFileResp.soundFiles_;
                        this.bitField0_ &= -5;
                        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                            o0Var = getSoundFilesFieldBuilder();
                        }
                        this.soundFilesBuilder_ = o0Var;
                    } else {
                        this.soundFilesBuilder_.b(soundFileResp.soundFiles_);
                    }
                }
                onChanged();
                return this;
            }

            public Builder addSoundFiles(SoundFile.Builder builder) {
                o0<SoundFile, SoundFile.Builder, SoundFileOrBuilder> o0Var = this.soundFilesBuilder_;
                if (o0Var == null) {
                    ensureSoundFilesIsMutable();
                    this.soundFiles_.add(builder.build());
                    onChanged();
                } else {
                    o0Var.f(builder.build());
                }
                return this;
            }

            public Builder addSoundFiles(int i10, SoundFile.Builder builder) {
                o0<SoundFile, SoundFile.Builder, SoundFileOrBuilder> o0Var = this.soundFilesBuilder_;
                if (o0Var == null) {
                    ensureSoundFilesIsMutable();
                    this.soundFiles_.add(i10, builder.build());
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
                SoundFileResp soundFileResp = null;
                try {
                    try {
                        SoundFileResp soundFileResp2 = (SoundFileResp) SoundFileResp.PARSER.parsePartialFrom(iVar, qVar);
                        if (soundFileResp2 != null) {
                            mergeFrom(soundFileResp2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e10) {
                        soundFileResp = (SoundFileResp) e10.getUnfinishedMessage();
                        try {
                            throw e10.unwrapIOException();
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (soundFileResp != null) {
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (soundFileResp != null) {
                        mergeFrom(soundFileResp);
                    }
                    throw th2;
                }
            }
        }

        public static Builder newBuilder(SoundFileResp soundFileResp) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(soundFileResp);
        }

        public static SoundFileResp parseFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, qVar);
        }

        private SoundFileResp(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static SoundFileResp parseDelimitedFrom(InputStream inputStream, q qVar) throws IOException {
            return (SoundFileResp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
        }

        public static SoundFileResp parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
        public SoundFileResp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static SoundFileResp parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder newBuilderForType() {
            return newBuilder();
        }

        private SoundFileResp() {
            this.memoizedIsInitialized = (byte) -1;
            this.errCode_ = 0;
            this.errMsg_ = "";
            this.soundFiles_ = Collections.emptyList();
        }

        public static SoundFileResp parseFrom(InputStream inputStream) throws IOException {
            return (SoundFileResp) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.c cVar) {
            return new Builder(cVar);
        }

        public static SoundFileResp parseFrom(InputStream inputStream, q qVar) throws IOException {
            return (SoundFileResp) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
        }

        public static SoundFileResp parseFrom(i iVar) throws IOException {
            return (SoundFileResp) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
        }

        private SoundFileResp(i iVar, q qVar) throws InvalidProtocolBufferException {
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
                                    this.soundFiles_ = new ArrayList();
                                    z11 |= true;
                                }
                                this.soundFiles_.add((SoundFile) iVar.v(SoundFile.parser(), qVar));
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
                        this.soundFiles_ = Collections.unmodifiableList(this.soundFiles_);
                    }
                    makeExtensionsImmutable();
                }
            }
        }

        public static SoundFileResp parseFrom(i iVar, q qVar) throws IOException {
            return (SoundFileResp) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
        }
    }

    /* loaded from: classes2.dex */
    public interface SoundFileRespOrBuilder extends g0 {
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

        SoundFile getSoundFiles(int i10);

        int getSoundFilesCount();

        List<SoundFile> getSoundFilesList();

        SoundFileOrBuilder getSoundFilesOrBuilder(int i10);

        List<? extends SoundFileOrBuilder> getSoundFilesOrBuilderList();

        @Override // com.google.protobuf.g0
        /* synthetic */ a1 getUnknownFields();

        @Override // com.google.protobuf.g0
        /* synthetic */ boolean hasField(Descriptors.FieldDescriptor fieldDescriptor);

        /* synthetic */ boolean hasOneof(Descriptors.h hVar);

        @Override // com.google.protobuf.f0
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes2.dex */
    public static final class SoundFileUploadStatusResp extends GeneratedMessageV3 implements SoundFileUploadStatusRespOrBuilder {
        public static final int ERR_CODE_FIELD_NUMBER = 1;
        public static final int ERR_MSG_FIELD_NUMBER = 2;
        public static final int FILESTATUSDTO_FIELD_NUMBER = 3;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private int errCode_;
        private volatile Object errMsg_;
        private List<FileStatusDto> fileStatusDto_;
        private byte memoizedIsInitialized;
        private static final SoundFileUploadStatusResp DEFAULT_INSTANCE = new SoundFileUploadStatusResp();
        private static final l0<SoundFileUploadStatusResp> PARSER = new c<SoundFileUploadStatusResp>() { // from class: com.mobvoi.companion.proto.SoundProto.SoundFileUploadStatusResp.1
            @Override // com.google.protobuf.l0
            public SoundFileUploadStatusResp parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
                return new SoundFileUploadStatusResp(iVar, qVar);
            }
        };

        public static SoundFileUploadStatusResp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return SoundProto.internal_static_com_mobvoi_companion_proto_SoundFileUploadStatusResp_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static SoundFileUploadStatusResp parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (SoundFileUploadStatusResp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static SoundFileUploadStatusResp parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static l0<SoundFileUploadStatusResp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof SoundFileUploadStatusResp)) {
                return super.equals(obj);
            }
            SoundFileUploadStatusResp soundFileUploadStatusResp = (SoundFileUploadStatusResp) obj;
            return ((getErrCode() == soundFileUploadStatusResp.getErrCode()) && getErrMsg().equals(soundFileUploadStatusResp.getErrMsg())) && getFileStatusDtoList().equals(soundFileUploadStatusResp.getFileStatusDtoList());
        }

        @Override // com.mobvoi.companion.proto.SoundProto.SoundFileUploadStatusRespOrBuilder
        public int getErrCode() {
            return this.errCode_;
        }

        @Override // com.mobvoi.companion.proto.SoundProto.SoundFileUploadStatusRespOrBuilder
        public String getErrMsg() {
            Object obj = this.errMsg_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.errMsg_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.proto.SoundProto.SoundFileUploadStatusRespOrBuilder
        public ByteString getErrMsgBytes() {
            Object obj = this.errMsg_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.errMsg_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.mobvoi.companion.proto.SoundProto.SoundFileUploadStatusRespOrBuilder
        public FileStatusDto getFileStatusDto(int i10) {
            return this.fileStatusDto_.get(i10);
        }

        @Override // com.mobvoi.companion.proto.SoundProto.SoundFileUploadStatusRespOrBuilder
        public int getFileStatusDtoCount() {
            return this.fileStatusDto_.size();
        }

        @Override // com.mobvoi.companion.proto.SoundProto.SoundFileUploadStatusRespOrBuilder
        public List<FileStatusDto> getFileStatusDtoList() {
            return this.fileStatusDto_;
        }

        @Override // com.mobvoi.companion.proto.SoundProto.SoundFileUploadStatusRespOrBuilder
        public FileStatusDtoOrBuilder getFileStatusDtoOrBuilder(int i10) {
            return this.fileStatusDto_.get(i10);
        }

        @Override // com.mobvoi.companion.proto.SoundProto.SoundFileUploadStatusRespOrBuilder
        public List<? extends FileStatusDtoOrBuilder> getFileStatusDtoOrBuilderList() {
            return this.fileStatusDto_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public l0<SoundFileUploadStatusResp> getParserForType() {
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
            for (int i12 = 0; i12 < this.fileStatusDto_.size(); i12++) {
                v10 += CodedOutputStream.E(3, this.fileStatusDto_.get(i12));
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
            if (getFileStatusDtoCount() > 0) {
                hashCode = (((hashCode * 37) + 3) * 53) + getFileStatusDtoList().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return SoundProto.internal_static_com_mobvoi_companion_proto_SoundFileUploadStatusResp_fieldAccessorTable.e(SoundFileUploadStatusResp.class, Builder.class);
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
            for (int i11 = 0; i11 < this.fileStatusDto_.size(); i11++) {
                codedOutputStream.A0(3, this.fileStatusDto_.get(i11));
            }
        }

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageV3.b<Builder> implements SoundFileUploadStatusRespOrBuilder {
            private int bitField0_;
            private int errCode_;
            private Object errMsg_;
            private o0<FileStatusDto, FileStatusDto.Builder, FileStatusDtoOrBuilder> fileStatusDtoBuilder_;
            private List<FileStatusDto> fileStatusDto_;

            private void ensureFileStatusDtoIsMutable() {
                if ((this.bitField0_ & 4) != 4) {
                    this.fileStatusDto_ = new ArrayList(this.fileStatusDto_);
                    this.bitField0_ |= 4;
                }
            }

            public static final Descriptors.b getDescriptor() {
                return SoundProto.internal_static_com_mobvoi_companion_proto_SoundFileUploadStatusResp_descriptor;
            }

            private o0<FileStatusDto, FileStatusDto.Builder, FileStatusDtoOrBuilder> getFileStatusDtoFieldBuilder() {
                if (this.fileStatusDtoBuilder_ == null) {
                    this.fileStatusDtoBuilder_ = new o0<>(this.fileStatusDto_, (this.bitField0_ & 4) == 4, getParentForChildren(), isClean());
                    this.fileStatusDto_ = null;
                }
                return this.fileStatusDtoBuilder_;
            }

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                    getFileStatusDtoFieldBuilder();
                }
            }

            public Builder addAllFileStatusDto(Iterable<? extends FileStatusDto> iterable) {
                o0<FileStatusDto, FileStatusDto.Builder, FileStatusDtoOrBuilder> o0Var = this.fileStatusDtoBuilder_;
                if (o0Var == null) {
                    ensureFileStatusDtoIsMutable();
                    b.a.addAll(iterable, this.fileStatusDto_);
                    onChanged();
                } else {
                    o0Var.b(iterable);
                }
                return this;
            }

            public Builder addFileStatusDto(FileStatusDto fileStatusDto) {
                o0<FileStatusDto, FileStatusDto.Builder, FileStatusDtoOrBuilder> o0Var = this.fileStatusDtoBuilder_;
                if (o0Var == null) {
                    Objects.requireNonNull(fileStatusDto);
                    ensureFileStatusDtoIsMutable();
                    this.fileStatusDto_.add(fileStatusDto);
                    onChanged();
                } else {
                    o0Var.f(fileStatusDto);
                }
                return this;
            }

            public FileStatusDto.Builder addFileStatusDtoBuilder() {
                return getFileStatusDtoFieldBuilder().d(FileStatusDto.getDefaultInstance());
            }

            public Builder clearErrCode() {
                this.errCode_ = 0;
                onChanged();
                return this;
            }

            public Builder clearErrMsg() {
                this.errMsg_ = SoundFileUploadStatusResp.getDefaultInstance().getErrMsg();
                onChanged();
                return this;
            }

            public Builder clearFileStatusDto() {
                o0<FileStatusDto, FileStatusDto.Builder, FileStatusDtoOrBuilder> o0Var = this.fileStatusDtoBuilder_;
                if (o0Var == null) {
                    this.fileStatusDto_ = Collections.emptyList();
                    this.bitField0_ &= -5;
                    onChanged();
                } else {
                    o0Var.h();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a, com.google.protobuf.g0
            public Descriptors.b getDescriptorForType() {
                return SoundProto.internal_static_com_mobvoi_companion_proto_SoundFileUploadStatusResp_descriptor;
            }

            @Override // com.mobvoi.companion.proto.SoundProto.SoundFileUploadStatusRespOrBuilder
            public int getErrCode() {
                return this.errCode_;
            }

            @Override // com.mobvoi.companion.proto.SoundProto.SoundFileUploadStatusRespOrBuilder
            public String getErrMsg() {
                Object obj = this.errMsg_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.errMsg_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.proto.SoundProto.SoundFileUploadStatusRespOrBuilder
            public ByteString getErrMsgBytes() {
                Object obj = this.errMsg_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.errMsg_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.mobvoi.companion.proto.SoundProto.SoundFileUploadStatusRespOrBuilder
            public FileStatusDto getFileStatusDto(int i10) {
                o0<FileStatusDto, FileStatusDto.Builder, FileStatusDtoOrBuilder> o0Var = this.fileStatusDtoBuilder_;
                if (o0Var == null) {
                    return this.fileStatusDto_.get(i10);
                }
                return o0Var.o(i10);
            }

            public FileStatusDto.Builder getFileStatusDtoBuilder(int i10) {
                return getFileStatusDtoFieldBuilder().l(i10);
            }

            public List<FileStatusDto.Builder> getFileStatusDtoBuilderList() {
                return getFileStatusDtoFieldBuilder().m();
            }

            @Override // com.mobvoi.companion.proto.SoundProto.SoundFileUploadStatusRespOrBuilder
            public int getFileStatusDtoCount() {
                o0<FileStatusDto, FileStatusDto.Builder, FileStatusDtoOrBuilder> o0Var = this.fileStatusDtoBuilder_;
                if (o0Var == null) {
                    return this.fileStatusDto_.size();
                }
                return o0Var.n();
            }

            @Override // com.mobvoi.companion.proto.SoundProto.SoundFileUploadStatusRespOrBuilder
            public List<FileStatusDto> getFileStatusDtoList() {
                o0<FileStatusDto, FileStatusDto.Builder, FileStatusDtoOrBuilder> o0Var = this.fileStatusDtoBuilder_;
                if (o0Var == null) {
                    return Collections.unmodifiableList(this.fileStatusDto_);
                }
                return o0Var.q();
            }

            @Override // com.mobvoi.companion.proto.SoundProto.SoundFileUploadStatusRespOrBuilder
            public FileStatusDtoOrBuilder getFileStatusDtoOrBuilder(int i10) {
                o0<FileStatusDto, FileStatusDto.Builder, FileStatusDtoOrBuilder> o0Var = this.fileStatusDtoBuilder_;
                if (o0Var == null) {
                    return this.fileStatusDto_.get(i10);
                }
                return o0Var.r(i10);
            }

            @Override // com.mobvoi.companion.proto.SoundProto.SoundFileUploadStatusRespOrBuilder
            public List<? extends FileStatusDtoOrBuilder> getFileStatusDtoOrBuilderList() {
                o0<FileStatusDto, FileStatusDto.Builder, FileStatusDtoOrBuilder> o0Var = this.fileStatusDtoBuilder_;
                if (o0Var != null) {
                    return o0Var.s();
                }
                return Collections.unmodifiableList(this.fileStatusDto_);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return SoundProto.internal_static_com_mobvoi_companion_proto_SoundFileUploadStatusResp_fieldAccessorTable.e(SoundFileUploadStatusResp.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.f0
            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a
            public final Builder mergeUnknownFields(a1 a1Var) {
                return this;
            }

            public Builder removeFileStatusDto(int i10) {
                o0<FileStatusDto, FileStatusDto.Builder, FileStatusDtoOrBuilder> o0Var = this.fileStatusDtoBuilder_;
                if (o0Var == null) {
                    ensureFileStatusDtoIsMutable();
                    this.fileStatusDto_.remove(i10);
                    onChanged();
                } else {
                    o0Var.w(i10);
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

            public Builder setFileStatusDto(int i10, FileStatusDto fileStatusDto) {
                o0<FileStatusDto, FileStatusDto.Builder, FileStatusDtoOrBuilder> o0Var = this.fileStatusDtoBuilder_;
                if (o0Var == null) {
                    Objects.requireNonNull(fileStatusDto);
                    ensureFileStatusDtoIsMutable();
                    this.fileStatusDto_.set(i10, fileStatusDto);
                    onChanged();
                } else {
                    o0Var.x(i10, fileStatusDto);
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public final Builder setUnknownFields(a1 a1Var) {
                return this;
            }

            private Builder() {
                this.errMsg_ = "";
                this.fileStatusDto_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.e0.a, com.google.protobuf.d0.a
            public SoundFileUploadStatusResp build() {
                SoundFileUploadStatusResp buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) buildPartial);
            }

            @Override // com.google.protobuf.e0.a, com.google.protobuf.d0.a
            public SoundFileUploadStatusResp buildPartial() {
                SoundFileUploadStatusResp soundFileUploadStatusResp = new SoundFileUploadStatusResp(this);
                soundFileUploadStatusResp.errCode_ = this.errCode_;
                soundFileUploadStatusResp.errMsg_ = this.errMsg_;
                o0<FileStatusDto, FileStatusDto.Builder, FileStatusDtoOrBuilder> o0Var = this.fileStatusDtoBuilder_;
                if (o0Var == null) {
                    if ((this.bitField0_ & 4) == 4) {
                        this.fileStatusDto_ = Collections.unmodifiableList(this.fileStatusDto_);
                        this.bitField0_ &= -5;
                    }
                    soundFileUploadStatusResp.fileStatusDto_ = this.fileStatusDto_;
                } else {
                    soundFileUploadStatusResp.fileStatusDto_ = o0Var.g();
                }
                soundFileUploadStatusResp.bitField0_ = 0;
                onBuilt();
                return soundFileUploadStatusResp;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.f0, com.google.protobuf.g0
            public SoundFileUploadStatusResp getDefaultInstanceForType() {
                return SoundFileUploadStatusResp.getDefaultInstance();
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

            public FileStatusDto.Builder addFileStatusDtoBuilder(int i10) {
                return getFileStatusDtoFieldBuilder().c(i10, FileStatusDto.getDefaultInstance());
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
                o0<FileStatusDto, FileStatusDto.Builder, FileStatusDtoOrBuilder> o0Var = this.fileStatusDtoBuilder_;
                if (o0Var == null) {
                    this.fileStatusDto_ = Collections.emptyList();
                    this.bitField0_ &= -5;
                } else {
                    o0Var.h();
                }
                return this;
            }

            private Builder(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.errMsg_ = "";
                this.fileStatusDto_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            public Builder addFileStatusDto(int i10, FileStatusDto fileStatusDto) {
                o0<FileStatusDto, FileStatusDto.Builder, FileStatusDtoOrBuilder> o0Var = this.fileStatusDtoBuilder_;
                if (o0Var == null) {
                    Objects.requireNonNull(fileStatusDto);
                    ensureFileStatusDtoIsMutable();
                    this.fileStatusDto_.add(i10, fileStatusDto);
                    onChanged();
                } else {
                    o0Var.e(i10, fileStatusDto);
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a, com.google.protobuf.b.a
            public Builder clone() {
                return (Builder) super.clone();
            }

            @Override // com.google.protobuf.a.AbstractC0170a, com.google.protobuf.d0.a
            public Builder mergeFrom(d0 d0Var) {
                if (d0Var instanceof SoundFileUploadStatusResp) {
                    return mergeFrom((SoundFileUploadStatusResp) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            public Builder setFileStatusDto(int i10, FileStatusDto.Builder builder) {
                o0<FileStatusDto, FileStatusDto.Builder, FileStatusDtoOrBuilder> o0Var = this.fileStatusDtoBuilder_;
                if (o0Var == null) {
                    ensureFileStatusDtoIsMutable();
                    this.fileStatusDto_.set(i10, builder.build());
                    onChanged();
                } else {
                    o0Var.x(i10, builder.build());
                }
                return this;
            }

            public Builder mergeFrom(SoundFileUploadStatusResp soundFileUploadStatusResp) {
                if (soundFileUploadStatusResp == SoundFileUploadStatusResp.getDefaultInstance()) {
                    return this;
                }
                if (soundFileUploadStatusResp.getErrCode() != 0) {
                    setErrCode(soundFileUploadStatusResp.getErrCode());
                }
                if (!soundFileUploadStatusResp.getErrMsg().isEmpty()) {
                    this.errMsg_ = soundFileUploadStatusResp.errMsg_;
                    onChanged();
                }
                if (this.fileStatusDtoBuilder_ == null) {
                    if (!soundFileUploadStatusResp.fileStatusDto_.isEmpty()) {
                        if (this.fileStatusDto_.isEmpty()) {
                            this.fileStatusDto_ = soundFileUploadStatusResp.fileStatusDto_;
                            this.bitField0_ &= -5;
                        } else {
                            ensureFileStatusDtoIsMutable();
                            this.fileStatusDto_.addAll(soundFileUploadStatusResp.fileStatusDto_);
                        }
                        onChanged();
                    }
                } else if (!soundFileUploadStatusResp.fileStatusDto_.isEmpty()) {
                    if (this.fileStatusDtoBuilder_.u()) {
                        this.fileStatusDtoBuilder_.i();
                        o0<FileStatusDto, FileStatusDto.Builder, FileStatusDtoOrBuilder> o0Var = null;
                        this.fileStatusDtoBuilder_ = null;
                        this.fileStatusDto_ = soundFileUploadStatusResp.fileStatusDto_;
                        this.bitField0_ &= -5;
                        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                            o0Var = getFileStatusDtoFieldBuilder();
                        }
                        this.fileStatusDtoBuilder_ = o0Var;
                    } else {
                        this.fileStatusDtoBuilder_.b(soundFileUploadStatusResp.fileStatusDto_);
                    }
                }
                onChanged();
                return this;
            }

            public Builder addFileStatusDto(FileStatusDto.Builder builder) {
                o0<FileStatusDto, FileStatusDto.Builder, FileStatusDtoOrBuilder> o0Var = this.fileStatusDtoBuilder_;
                if (o0Var == null) {
                    ensureFileStatusDtoIsMutable();
                    this.fileStatusDto_.add(builder.build());
                    onChanged();
                } else {
                    o0Var.f(builder.build());
                }
                return this;
            }

            public Builder addFileStatusDto(int i10, FileStatusDto.Builder builder) {
                o0<FileStatusDto, FileStatusDto.Builder, FileStatusDtoOrBuilder> o0Var = this.fileStatusDtoBuilder_;
                if (o0Var == null) {
                    ensureFileStatusDtoIsMutable();
                    this.fileStatusDto_.add(i10, builder.build());
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
                SoundFileUploadStatusResp soundFileUploadStatusResp = null;
                try {
                    try {
                        SoundFileUploadStatusResp soundFileUploadStatusResp2 = (SoundFileUploadStatusResp) SoundFileUploadStatusResp.PARSER.parsePartialFrom(iVar, qVar);
                        if (soundFileUploadStatusResp2 != null) {
                            mergeFrom(soundFileUploadStatusResp2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e10) {
                        soundFileUploadStatusResp = (SoundFileUploadStatusResp) e10.getUnfinishedMessage();
                        try {
                            throw e10.unwrapIOException();
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (soundFileUploadStatusResp != null) {
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (soundFileUploadStatusResp != null) {
                        mergeFrom(soundFileUploadStatusResp);
                    }
                    throw th2;
                }
            }
        }

        public static Builder newBuilder(SoundFileUploadStatusResp soundFileUploadStatusResp) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(soundFileUploadStatusResp);
        }

        public static SoundFileUploadStatusResp parseFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, qVar);
        }

        private SoundFileUploadStatusResp(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static SoundFileUploadStatusResp parseDelimitedFrom(InputStream inputStream, q qVar) throws IOException {
            return (SoundFileUploadStatusResp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
        }

        public static SoundFileUploadStatusResp parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
        public SoundFileUploadStatusResp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static SoundFileUploadStatusResp parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder newBuilderForType() {
            return newBuilder();
        }

        private SoundFileUploadStatusResp() {
            this.memoizedIsInitialized = (byte) -1;
            this.errCode_ = 0;
            this.errMsg_ = "";
            this.fileStatusDto_ = Collections.emptyList();
        }

        public static SoundFileUploadStatusResp parseFrom(InputStream inputStream) throws IOException {
            return (SoundFileUploadStatusResp) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.c cVar) {
            return new Builder(cVar);
        }

        public static SoundFileUploadStatusResp parseFrom(InputStream inputStream, q qVar) throws IOException {
            return (SoundFileUploadStatusResp) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
        }

        public static SoundFileUploadStatusResp parseFrom(i iVar) throws IOException {
            return (SoundFileUploadStatusResp) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
        }

        private SoundFileUploadStatusResp(i iVar, q qVar) throws InvalidProtocolBufferException {
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
                                    this.fileStatusDto_ = new ArrayList();
                                    z11 |= true;
                                }
                                this.fileStatusDto_.add((FileStatusDto) iVar.v(FileStatusDto.parser(), qVar));
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
                        this.fileStatusDto_ = Collections.unmodifiableList(this.fileStatusDto_);
                    }
                    makeExtensionsImmutable();
                }
            }
        }

        public static SoundFileUploadStatusResp parseFrom(i iVar, q qVar) throws IOException {
            return (SoundFileUploadStatusResp) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
        }
    }

    /* loaded from: classes2.dex */
    public interface SoundFileUploadStatusRespOrBuilder extends g0 {
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

        FileStatusDto getFileStatusDto(int i10);

        int getFileStatusDtoCount();

        List<FileStatusDto> getFileStatusDtoList();

        FileStatusDtoOrBuilder getFileStatusDtoOrBuilder(int i10);

        List<? extends FileStatusDtoOrBuilder> getFileStatusDtoOrBuilderList();

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
        Descriptors.FileDescriptor.q(new String[]{"\n\u000bsound.proto\u0012\u001acom.mobvoi.companion.proto\u001a\u000fconstants.proto\"n\n\rSoundFileResp\u0012\u0010\n\berr_code\u0018\u0001 \u0001(\u0005\u0012\u000f\n\u0007err_msg\u0018\u0002 \u0001(\t\u0012:\n\u000bsound_files\u0018\u0003 \u0003(\u000b2%.com.mobvoi.companion.proto.SoundFile\"é\u0002\n\tSoundFile\u0012\u0011\n\tdevice_id\u0018\u0001 \u0001(\t\u0012\u000f\n\u0007file_id\u0018\u0002 \u0001(\t\u0012\u0011\n\tfile_name\u0018\u0003 \u0001(\t\u0012\u0010\n\bfile_url\u0018\u0004 \u0001(\t\u0012\u0011\n\tfile_size\u0018\u0005 \u0001(\u0003\u0012\u0010\n\bduration\u0018\u0006 \u0001(\u0005\u0012\u0011\n\ttimestamp\u0018\u0007 \u0001(\u0003\u0012\u0013\n\u000bspeaker_num\u0018\b \u0001(\u0005\u0012\r\n\u0005flags\u0018\t \u0003(\u0005\u0012;\n\u000bfile_status\u0018\n \u0001(\u000e2&.com.mobvoi.companion.proto.", "FileStatus\u0012;\n\u000bdevice_type\u0018\u000b \u0001(\u000e2&.com.mobvoi.companion.proto.DeviceType\u0012\u0012\n\npercentage\u0018\f \u0001(\t\u0012\u0017\n\u000ffirst_paragraph\u0018\r \u0001(\t\u0012\u0010\n\bkeywords\u0018\u000e \u0003(\t\"/\n\tRenameReq\u0012\u000f\n\u0007file_id\u0018\u0001 \u0001(\t\u0012\u0011\n\tfile_name\u0018\u0002 \u0001(\t\"\u0097\u0001\n\u0016SoundConvertResultResp\u0012\u0010\n\berr_code\u0018\u0001 \u0001(\u0005\u0012\u000f\n\u0007err_msg\u0018\u0002 \u0001(\t\u00125\n\u0004data\u0018\u0003 \u0003(\u000b2'.com.mobvoi.companion.proto.ConvertData\u0012\u0012\n\npercentage\u0018\u0004 \u0001(\u0002\u0012\u000f\n\u0007file_id\u0018\u0005 \u0001(\t\"M\n\u0014ConvertDataUpdateReq\u00125\n\u0004data\u0018\u0001 \u0003(\u000b2'.com.mobvoi.companion.p", "roto.ConvertData\"ê\u0001\n\u000bConvertData\u0012\u000e\n\u0006offset\u0018\u0001 \u0001(\u0005\u0012\u0010\n\bduration\u0018\u0002 \u0001(\u0005\u0012\u000f\n\u0007speaker\u0018\u0003 \u0001(\t\u0012\f\n\u0004text\u0018\u0004 \u0001(\t\u0012\u000f\n\u0007summary\u0018\u0005 \u0001(\t\u0012\u001a\n\u0012paragraph_keywords\u0018\u0006 \u0003(\t\u00124\n\u0007channel\u0018\u0007 \u0001(\u000e2#.com.mobvoi.companion.proto.Channel\u0012\n\n\u0002id\u0018\b \u0001(\u0005\u0012\u0015\n\rmodified_text\u0018\t \u0001(\t\u0012\u0014\n\fspeaker_name\u0018\n \u0001(\t\"~\n\u0016SoundConvertConfigResp\u0012\u0010\n\berr_code\u0018\u0001 \u0001(\u0005\u0012\u000f\n\u0007err_msg\u0018\u0002 \u0001(\t\u0012A\n\u000econvert_config\u0018\u0003 \u0001(\u000b2).com.mobvoi.companion.proto.ConvertConfig\"b\n\rConvertConfig\u00127", "\n\tlang_list\u0018\u0001 \u0003(\u000b2$.com.mobvoi.companion.proto.LangInfo\u0012\u0018\n\u0010speaker_num_list\u0018\u0002 \u0003(\u0005\"&\n\bLangInfo\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u0012\f\n\u0004code\u0018\u0002 \u0001(\t\"²\u0001\n\u0013SoundFileDetailResp\u0012\u0010\n\berr_code\u0018\u0001 \u0001(\u0005\u0012\u000f\n\u0007err_msg\u0018\u0002 \u0001(\t\u00129\n\nsound_file\u0018\u0003 \u0001(\u000b2%.com.mobvoi.companion.proto.SoundFile\u0012=\n\fconvert_data\u0018\u0004 \u0003(\u000b2'.com.mobvoi.companion.proto.ConvertData\"I\n\u000fModifiedTextReq\u0012\u000f\n\u0007file_id\u0018\u0001 \u0001(\t\u0012\u000e\n\u0006offset\u0018\u0002 \u0001(\u0005\u0012\u0015\n\rmodified_text\u0018\u0003 \u0001(\t\"5\n\rFileStatusDto\u0012\u000f\n\u0007fi", "le_id\u0018\u0001 \u0001(\t\u0012\u0013\n\u000bfile_status\u0018\u0002 \u0001(\t\"\u0080\u0001\n\u0019SoundFileUploadStatusResp\u0012\u0010\n\berr_code\u0018\u0001 \u0001(\u0005\u0012\u000f\n\u0007err_msg\u0018\u0002 \u0001(\t\u0012@\n\rfileStatusDto\u0018\u0003 \u0003(\u000b2).com.mobvoi.companion.proto.FileStatusDto*L\n\nFileStatus\u0012\u000b\n\u0007DEFAULT\u0010\u0000\u0012\u000e\n\nCONVERTING\u0010\u0001\u0012\r\n\tCONVERTED\u0010\u0002\u0012\u0012\n\u000eCONVERT_FAILED\u0010\u0003*\u001e\n\u0007Channel\u0012\b\n\u0004LEFT\u0010\u0000\u0012\t\n\u0005RIGHT\u0010\u0001B\fB\nSoundProtob\u0006proto3"}, new Descriptors.FileDescriptor[]{ConstantProto.getDescriptor()}, new Descriptors.FileDescriptor.a() { // from class: com.mobvoi.companion.proto.SoundProto.1
            @Override // com.google.protobuf.Descriptors.FileDescriptor.a
            public o assignDescriptors(Descriptors.FileDescriptor fileDescriptor) {
                Descriptors.FileDescriptor unused = SoundProto.descriptor = fileDescriptor;
                return null;
            }
        });
        Descriptors.b bVar = getDescriptor().j().get(0);
        internal_static_com_mobvoi_companion_proto_SoundFileResp_descriptor = bVar;
        internal_static_com_mobvoi_companion_proto_SoundFileResp_fieldAccessorTable = new GeneratedMessageV3.e(bVar, new String[]{"ErrCode", "ErrMsg", "SoundFiles"});
        Descriptors.b bVar2 = getDescriptor().j().get(1);
        internal_static_com_mobvoi_companion_proto_SoundFile_descriptor = bVar2;
        internal_static_com_mobvoi_companion_proto_SoundFile_fieldAccessorTable = new GeneratedMessageV3.e(bVar2, new String[]{"DeviceId", "FileId", "FileName", "FileUrl", "FileSize", "Duration", "Timestamp", "SpeakerNum", "Flags", "FileStatus", "DeviceType", "Percentage", "FirstParagraph", "Keywords"});
        Descriptors.b bVar3 = getDescriptor().j().get(2);
        internal_static_com_mobvoi_companion_proto_RenameReq_descriptor = bVar3;
        internal_static_com_mobvoi_companion_proto_RenameReq_fieldAccessorTable = new GeneratedMessageV3.e(bVar3, new String[]{"FileId", "FileName"});
        Descriptors.b bVar4 = getDescriptor().j().get(3);
        internal_static_com_mobvoi_companion_proto_SoundConvertResultResp_descriptor = bVar4;
        internal_static_com_mobvoi_companion_proto_SoundConvertResultResp_fieldAccessorTable = new GeneratedMessageV3.e(bVar4, new String[]{"ErrCode", "ErrMsg", "Data", "Percentage", "FileId"});
        Descriptors.b bVar5 = getDescriptor().j().get(4);
        internal_static_com_mobvoi_companion_proto_ConvertDataUpdateReq_descriptor = bVar5;
        internal_static_com_mobvoi_companion_proto_ConvertDataUpdateReq_fieldAccessorTable = new GeneratedMessageV3.e(bVar5, new String[]{"Data"});
        Descriptors.b bVar6 = getDescriptor().j().get(5);
        internal_static_com_mobvoi_companion_proto_ConvertData_descriptor = bVar6;
        internal_static_com_mobvoi_companion_proto_ConvertData_fieldAccessorTable = new GeneratedMessageV3.e(bVar6, new String[]{"Offset", "Duration", "Speaker", "Text", "Summary", "ParagraphKeywords", "Channel", "Id", "ModifiedText", "SpeakerName"});
        Descriptors.b bVar7 = getDescriptor().j().get(6);
        internal_static_com_mobvoi_companion_proto_SoundConvertConfigResp_descriptor = bVar7;
        internal_static_com_mobvoi_companion_proto_SoundConvertConfigResp_fieldAccessorTable = new GeneratedMessageV3.e(bVar7, new String[]{"ErrCode", "ErrMsg", "ConvertConfig"});
        Descriptors.b bVar8 = getDescriptor().j().get(7);
        internal_static_com_mobvoi_companion_proto_ConvertConfig_descriptor = bVar8;
        internal_static_com_mobvoi_companion_proto_ConvertConfig_fieldAccessorTable = new GeneratedMessageV3.e(bVar8, new String[]{"LangList", "SpeakerNumList"});
        Descriptors.b bVar9 = getDescriptor().j().get(8);
        internal_static_com_mobvoi_companion_proto_LangInfo_descriptor = bVar9;
        internal_static_com_mobvoi_companion_proto_LangInfo_fieldAccessorTable = new GeneratedMessageV3.e(bVar9, new String[]{"Name", "Code"});
        Descriptors.b bVar10 = getDescriptor().j().get(9);
        internal_static_com_mobvoi_companion_proto_SoundFileDetailResp_descriptor = bVar10;
        internal_static_com_mobvoi_companion_proto_SoundFileDetailResp_fieldAccessorTable = new GeneratedMessageV3.e(bVar10, new String[]{"ErrCode", "ErrMsg", "SoundFile", "ConvertData"});
        Descriptors.b bVar11 = getDescriptor().j().get(10);
        internal_static_com_mobvoi_companion_proto_ModifiedTextReq_descriptor = bVar11;
        internal_static_com_mobvoi_companion_proto_ModifiedTextReq_fieldAccessorTable = new GeneratedMessageV3.e(bVar11, new String[]{"FileId", "Offset", "ModifiedText"});
        Descriptors.b bVar12 = getDescriptor().j().get(11);
        internal_static_com_mobvoi_companion_proto_FileStatusDto_descriptor = bVar12;
        internal_static_com_mobvoi_companion_proto_FileStatusDto_fieldAccessorTable = new GeneratedMessageV3.e(bVar12, new String[]{"FileId", "FileStatus"});
        Descriptors.b bVar13 = getDescriptor().j().get(12);
        internal_static_com_mobvoi_companion_proto_SoundFileUploadStatusResp_descriptor = bVar13;
        internal_static_com_mobvoi_companion_proto_SoundFileUploadStatusResp_fieldAccessorTable = new GeneratedMessageV3.e(bVar13, new String[]{"ErrCode", "ErrMsg", "FileStatusDto"});
        ConstantProto.getDescriptor();
    }

    private SoundProto() {
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
