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
import com.google.protobuf.o0;
import com.google.protobuf.q;
import com.google.protobuf.u;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
/* loaded from: classes2.dex */
public final class Collect {
    private static Descriptors.FileDescriptor descriptor;
    private static final Descriptors.b internal_static_com_mobvoi_assistant_proto_CollectItem_descriptor;
    private static final GeneratedMessageV3.e internal_static_com_mobvoi_assistant_proto_CollectItem_fieldAccessorTable;
    private static final Descriptors.b internal_static_com_mobvoi_assistant_proto_CollectResponse_descriptor;
    private static final GeneratedMessageV3.e internal_static_com_mobvoi_assistant_proto_CollectResponse_fieldAccessorTable;

    /* loaded from: classes2.dex */
    public static final class CollectItem extends GeneratedMessageV3 implements CollectItemOrBuilder {
        public static final int ADD_TIME_FIELD_NUMBER = 1;
        public static final int ARTIST_FIELD_NUMBER = 3;
        public static final int CATEGORY_FIELD_NUMBER = 11;
        public static final int IMAGE_FIELD_NUMBER = 4;
        public static final int ITEM_ID_FIELD_NUMBER = 2;
        public static final int LINK_URL_FIELD_NUMBER = 5;
        public static final int QUERY_FIELD_NUMBER = 6;
        public static final int SOURCE_FIELD_NUMBER = 7;
        public static final int TITLE_FIELD_NUMBER = 8;
        public static final int TYPE_FIELD_NUMBER = 9;
        public static final int USER_ID_FIELD_NUMBER = 10;
        private static final long serialVersionUID = 0;
        private long addTime_;
        private volatile Object artist_;
        private volatile Object category_;
        private volatile Object image_;
        private volatile Object itemId_;
        private volatile Object linkUrl_;
        private byte memoizedIsInitialized;
        private volatile Object query_;
        private volatile Object source_;
        private volatile Object title_;
        private volatile Object type_;
        private volatile Object userId_;
        private static final CollectItem DEFAULT_INSTANCE = new CollectItem();
        private static final l0<CollectItem> PARSER = new c<CollectItem>() { // from class: com.mobvoi.assistant.proto.Collect.CollectItem.1
            @Override // com.google.protobuf.l0
            public CollectItem parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
                return new CollectItem(iVar, qVar);
            }
        };

        public static CollectItem getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return Collect.internal_static_com_mobvoi_assistant_proto_CollectItem_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static CollectItem parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (CollectItem) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static CollectItem parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static l0<CollectItem> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof CollectItem)) {
                return super.equals(obj);
            }
            CollectItem collectItem = (CollectItem) obj;
            return (((((((((((getAddTime() > collectItem.getAddTime() ? 1 : (getAddTime() == collectItem.getAddTime() ? 0 : -1)) == 0) && getItemId().equals(collectItem.getItemId())) && getArtist().equals(collectItem.getArtist())) && getImage().equals(collectItem.getImage())) && getLinkUrl().equals(collectItem.getLinkUrl())) && getQuery().equals(collectItem.getQuery())) && getSource().equals(collectItem.getSource())) && getTitle().equals(collectItem.getTitle())) && getType().equals(collectItem.getType())) && getUserId().equals(collectItem.getUserId())) && getCategory().equals(collectItem.getCategory());
        }

        @Override // com.mobvoi.assistant.proto.Collect.CollectItemOrBuilder
        public long getAddTime() {
            return this.addTime_;
        }

        @Override // com.mobvoi.assistant.proto.Collect.CollectItemOrBuilder
        public String getArtist() {
            Object obj = this.artist_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.artist_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.assistant.proto.Collect.CollectItemOrBuilder
        public ByteString getArtistBytes() {
            Object obj = this.artist_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.artist_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.mobvoi.assistant.proto.Collect.CollectItemOrBuilder
        public String getCategory() {
            Object obj = this.category_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.category_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.assistant.proto.Collect.CollectItemOrBuilder
        public ByteString getCategoryBytes() {
            Object obj = this.category_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.category_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.mobvoi.assistant.proto.Collect.CollectItemOrBuilder
        public String getImage() {
            Object obj = this.image_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.image_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.assistant.proto.Collect.CollectItemOrBuilder
        public ByteString getImageBytes() {
            Object obj = this.image_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.image_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.mobvoi.assistant.proto.Collect.CollectItemOrBuilder
        public String getItemId() {
            Object obj = this.itemId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.itemId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.assistant.proto.Collect.CollectItemOrBuilder
        public ByteString getItemIdBytes() {
            Object obj = this.itemId_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.itemId_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.mobvoi.assistant.proto.Collect.CollectItemOrBuilder
        public String getLinkUrl() {
            Object obj = this.linkUrl_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.linkUrl_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.assistant.proto.Collect.CollectItemOrBuilder
        public ByteString getLinkUrlBytes() {
            Object obj = this.linkUrl_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.linkUrl_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public l0<CollectItem> getParserForType() {
            return PARSER;
        }

        @Override // com.mobvoi.assistant.proto.Collect.CollectItemOrBuilder
        public String getQuery() {
            Object obj = this.query_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.query_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.assistant.proto.Collect.CollectItemOrBuilder
        public ByteString getQueryBytes() {
            Object obj = this.query_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.query_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
        public int getSerializedSize() {
            int i10 = this.memoizedSize;
            if (i10 != -1) {
                return i10;
            }
            int i11 = 0;
            long j10 = this.addTime_;
            if (j10 != 0) {
                i11 = 0 + CodedOutputStream.x(1, j10);
            }
            if (!getItemIdBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(2, this.itemId_);
            }
            if (!getArtistBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(3, this.artist_);
            }
            if (!getImageBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(4, this.image_);
            }
            if (!getLinkUrlBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(5, this.linkUrl_);
            }
            if (!getQueryBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(6, this.query_);
            }
            if (!getSourceBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(7, this.source_);
            }
            if (!getTitleBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(8, this.title_);
            }
            if (!getTypeBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(9, this.type_);
            }
            if (!getUserIdBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(10, this.userId_);
            }
            if (!getCategoryBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(11, this.category_);
            }
            this.memoizedSize = i11;
            return i11;
        }

        @Override // com.mobvoi.assistant.proto.Collect.CollectItemOrBuilder
        public String getSource() {
            Object obj = this.source_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.source_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.assistant.proto.Collect.CollectItemOrBuilder
        public ByteString getSourceBytes() {
            Object obj = this.source_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.source_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.mobvoi.assistant.proto.Collect.CollectItemOrBuilder
        public String getTitle() {
            Object obj = this.title_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.title_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.assistant.proto.Collect.CollectItemOrBuilder
        public ByteString getTitleBytes() {
            Object obj = this.title_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.title_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.mobvoi.assistant.proto.Collect.CollectItemOrBuilder
        public String getType() {
            Object obj = this.type_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.type_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.assistant.proto.Collect.CollectItemOrBuilder
        public ByteString getTypeBytes() {
            Object obj = this.type_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.type_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.g0
        public final a1 getUnknownFields() {
            return a1.c();
        }

        @Override // com.mobvoi.assistant.proto.Collect.CollectItemOrBuilder
        public String getUserId() {
            Object obj = this.userId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.userId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.assistant.proto.Collect.CollectItemOrBuilder
        public ByteString getUserIdBytes() {
            Object obj = this.userId_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.userId_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.google.protobuf.a
        public int hashCode() {
            int i10 = this.memoizedHashCode;
            if (i10 != 0) {
                return i10;
            }
            int hashCode = ((((((((((((((((((((((((((((((((((((((((((((((779 + getDescriptorForType().hashCode()) * 37) + 1) * 53) + u.h(getAddTime())) * 37) + 2) * 53) + getItemId().hashCode()) * 37) + 3) * 53) + getArtist().hashCode()) * 37) + 4) * 53) + getImage().hashCode()) * 37) + 5) * 53) + getLinkUrl().hashCode()) * 37) + 6) * 53) + getQuery().hashCode()) * 37) + 7) * 53) + getSource().hashCode()) * 37) + 8) * 53) + getTitle().hashCode()) * 37) + 9) * 53) + getType().hashCode()) * 37) + 10) * 53) + getUserId().hashCode()) * 37) + 11) * 53) + getCategory().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return Collect.internal_static_com_mobvoi_assistant_proto_CollectItem_fieldAccessorTable.e(CollectItem.class, Builder.class);
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
            long j10 = this.addTime_;
            if (j10 != 0) {
                codedOutputStream.y0(1, j10);
            }
            if (!getItemIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.itemId_);
            }
            if (!getArtistBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 3, this.artist_);
            }
            if (!getImageBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 4, this.image_);
            }
            if (!getLinkUrlBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 5, this.linkUrl_);
            }
            if (!getQueryBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 6, this.query_);
            }
            if (!getSourceBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 7, this.source_);
            }
            if (!getTitleBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 8, this.title_);
            }
            if (!getTypeBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 9, this.type_);
            }
            if (!getUserIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 10, this.userId_);
            }
            if (!getCategoryBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 11, this.category_);
            }
        }

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageV3.b<Builder> implements CollectItemOrBuilder {
            private long addTime_;
            private Object artist_;
            private Object category_;
            private Object image_;
            private Object itemId_;
            private Object linkUrl_;
            private Object query_;
            private Object source_;
            private Object title_;
            private Object type_;
            private Object userId_;

            public static final Descriptors.b getDescriptor() {
                return Collect.internal_static_com_mobvoi_assistant_proto_CollectItem_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            public Builder clearAddTime() {
                this.addTime_ = 0L;
                onChanged();
                return this;
            }

            public Builder clearArtist() {
                this.artist_ = CollectItem.getDefaultInstance().getArtist();
                onChanged();
                return this;
            }

            public Builder clearCategory() {
                this.category_ = CollectItem.getDefaultInstance().getCategory();
                onChanged();
                return this;
            }

            public Builder clearImage() {
                this.image_ = CollectItem.getDefaultInstance().getImage();
                onChanged();
                return this;
            }

            public Builder clearItemId() {
                this.itemId_ = CollectItem.getDefaultInstance().getItemId();
                onChanged();
                return this;
            }

            public Builder clearLinkUrl() {
                this.linkUrl_ = CollectItem.getDefaultInstance().getLinkUrl();
                onChanged();
                return this;
            }

            public Builder clearQuery() {
                this.query_ = CollectItem.getDefaultInstance().getQuery();
                onChanged();
                return this;
            }

            public Builder clearSource() {
                this.source_ = CollectItem.getDefaultInstance().getSource();
                onChanged();
                return this;
            }

            public Builder clearTitle() {
                this.title_ = CollectItem.getDefaultInstance().getTitle();
                onChanged();
                return this;
            }

            public Builder clearType() {
                this.type_ = CollectItem.getDefaultInstance().getType();
                onChanged();
                return this;
            }

            public Builder clearUserId() {
                this.userId_ = CollectItem.getDefaultInstance().getUserId();
                onChanged();
                return this;
            }

            @Override // com.mobvoi.assistant.proto.Collect.CollectItemOrBuilder
            public long getAddTime() {
                return this.addTime_;
            }

            @Override // com.mobvoi.assistant.proto.Collect.CollectItemOrBuilder
            public String getArtist() {
                Object obj = this.artist_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.artist_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.assistant.proto.Collect.CollectItemOrBuilder
            public ByteString getArtistBytes() {
                Object obj = this.artist_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.artist_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.mobvoi.assistant.proto.Collect.CollectItemOrBuilder
            public String getCategory() {
                Object obj = this.category_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.category_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.assistant.proto.Collect.CollectItemOrBuilder
            public ByteString getCategoryBytes() {
                Object obj = this.category_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.category_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a, com.google.protobuf.g0
            public Descriptors.b getDescriptorForType() {
                return Collect.internal_static_com_mobvoi_assistant_proto_CollectItem_descriptor;
            }

            @Override // com.mobvoi.assistant.proto.Collect.CollectItemOrBuilder
            public String getImage() {
                Object obj = this.image_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.image_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.assistant.proto.Collect.CollectItemOrBuilder
            public ByteString getImageBytes() {
                Object obj = this.image_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.image_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.mobvoi.assistant.proto.Collect.CollectItemOrBuilder
            public String getItemId() {
                Object obj = this.itemId_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.itemId_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.assistant.proto.Collect.CollectItemOrBuilder
            public ByteString getItemIdBytes() {
                Object obj = this.itemId_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.itemId_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.mobvoi.assistant.proto.Collect.CollectItemOrBuilder
            public String getLinkUrl() {
                Object obj = this.linkUrl_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.linkUrl_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.assistant.proto.Collect.CollectItemOrBuilder
            public ByteString getLinkUrlBytes() {
                Object obj = this.linkUrl_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.linkUrl_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.mobvoi.assistant.proto.Collect.CollectItemOrBuilder
            public String getQuery() {
                Object obj = this.query_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.query_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.assistant.proto.Collect.CollectItemOrBuilder
            public ByteString getQueryBytes() {
                Object obj = this.query_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.query_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.mobvoi.assistant.proto.Collect.CollectItemOrBuilder
            public String getSource() {
                Object obj = this.source_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.source_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.assistant.proto.Collect.CollectItemOrBuilder
            public ByteString getSourceBytes() {
                Object obj = this.source_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.source_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.mobvoi.assistant.proto.Collect.CollectItemOrBuilder
            public String getTitle() {
                Object obj = this.title_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.title_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.assistant.proto.Collect.CollectItemOrBuilder
            public ByteString getTitleBytes() {
                Object obj = this.title_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.title_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.mobvoi.assistant.proto.Collect.CollectItemOrBuilder
            public String getType() {
                Object obj = this.type_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.type_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.assistant.proto.Collect.CollectItemOrBuilder
            public ByteString getTypeBytes() {
                Object obj = this.type_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.type_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.mobvoi.assistant.proto.Collect.CollectItemOrBuilder
            public String getUserId() {
                Object obj = this.userId_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.userId_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.assistant.proto.Collect.CollectItemOrBuilder
            public ByteString getUserIdBytes() {
                Object obj = this.userId_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.userId_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return Collect.internal_static_com_mobvoi_assistant_proto_CollectItem_fieldAccessorTable.e(CollectItem.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.f0
            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a
            public final Builder mergeUnknownFields(a1 a1Var) {
                return this;
            }

            public Builder setAddTime(long j10) {
                this.addTime_ = j10;
                onChanged();
                return this;
            }

            public Builder setArtist(String str) {
                Objects.requireNonNull(str);
                this.artist_ = str;
                onChanged();
                return this;
            }

            public Builder setArtistBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                b.checkByteStringIsUtf8(byteString);
                this.artist_ = byteString;
                onChanged();
                return this;
            }

            public Builder setCategory(String str) {
                Objects.requireNonNull(str);
                this.category_ = str;
                onChanged();
                return this;
            }

            public Builder setCategoryBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                b.checkByteStringIsUtf8(byteString);
                this.category_ = byteString;
                onChanged();
                return this;
            }

            public Builder setImage(String str) {
                Objects.requireNonNull(str);
                this.image_ = str;
                onChanged();
                return this;
            }

            public Builder setImageBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                b.checkByteStringIsUtf8(byteString);
                this.image_ = byteString;
                onChanged();
                return this;
            }

            public Builder setItemId(String str) {
                Objects.requireNonNull(str);
                this.itemId_ = str;
                onChanged();
                return this;
            }

            public Builder setItemIdBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                b.checkByteStringIsUtf8(byteString);
                this.itemId_ = byteString;
                onChanged();
                return this;
            }

            public Builder setLinkUrl(String str) {
                Objects.requireNonNull(str);
                this.linkUrl_ = str;
                onChanged();
                return this;
            }

            public Builder setLinkUrlBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                b.checkByteStringIsUtf8(byteString);
                this.linkUrl_ = byteString;
                onChanged();
                return this;
            }

            public Builder setQuery(String str) {
                Objects.requireNonNull(str);
                this.query_ = str;
                onChanged();
                return this;
            }

            public Builder setQueryBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                b.checkByteStringIsUtf8(byteString);
                this.query_ = byteString;
                onChanged();
                return this;
            }

            public Builder setSource(String str) {
                Objects.requireNonNull(str);
                this.source_ = str;
                onChanged();
                return this;
            }

            public Builder setSourceBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                b.checkByteStringIsUtf8(byteString);
                this.source_ = byteString;
                onChanged();
                return this;
            }

            public Builder setTitle(String str) {
                Objects.requireNonNull(str);
                this.title_ = str;
                onChanged();
                return this;
            }

            public Builder setTitleBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                b.checkByteStringIsUtf8(byteString);
                this.title_ = byteString;
                onChanged();
                return this;
            }

            public Builder setType(String str) {
                Objects.requireNonNull(str);
                this.type_ = str;
                onChanged();
                return this;
            }

            public Builder setTypeBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                b.checkByteStringIsUtf8(byteString);
                this.type_ = byteString;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public final Builder setUnknownFields(a1 a1Var) {
                return this;
            }

            public Builder setUserId(String str) {
                Objects.requireNonNull(str);
                this.userId_ = str;
                onChanged();
                return this;
            }

            public Builder setUserIdBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                b.checkByteStringIsUtf8(byteString);
                this.userId_ = byteString;
                onChanged();
                return this;
            }

            private Builder() {
                this.itemId_ = "";
                this.artist_ = "";
                this.image_ = "";
                this.linkUrl_ = "";
                this.query_ = "";
                this.source_ = "";
                this.title_ = "";
                this.type_ = "";
                this.userId_ = "";
                this.category_ = "";
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.e0.a, com.google.protobuf.d0.a
            public CollectItem build() {
                CollectItem buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) buildPartial);
            }

            @Override // com.google.protobuf.e0.a, com.google.protobuf.d0.a
            public CollectItem buildPartial() {
                CollectItem collectItem = new CollectItem(this);
                collectItem.addTime_ = this.addTime_;
                collectItem.itemId_ = this.itemId_;
                collectItem.artist_ = this.artist_;
                collectItem.image_ = this.image_;
                collectItem.linkUrl_ = this.linkUrl_;
                collectItem.query_ = this.query_;
                collectItem.source_ = this.source_;
                collectItem.title_ = this.title_;
                collectItem.type_ = this.type_;
                collectItem.userId_ = this.userId_;
                collectItem.category_ = this.category_;
                onBuilt();
                return collectItem;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.f0, com.google.protobuf.g0
            public CollectItem getDefaultInstanceForType() {
                return CollectItem.getDefaultInstance();
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
                this.addTime_ = 0L;
                this.itemId_ = "";
                this.artist_ = "";
                this.image_ = "";
                this.linkUrl_ = "";
                this.query_ = "";
                this.source_ = "";
                this.title_ = "";
                this.type_ = "";
                this.userId_ = "";
                this.category_ = "";
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a, com.google.protobuf.b.a
            public Builder clone() {
                return (Builder) super.clone();
            }

            @Override // com.google.protobuf.a.AbstractC0170a, com.google.protobuf.d0.a
            public Builder mergeFrom(d0 d0Var) {
                if (d0Var instanceof CollectItem) {
                    return mergeFrom((CollectItem) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            public Builder mergeFrom(CollectItem collectItem) {
                if (collectItem == CollectItem.getDefaultInstance()) {
                    return this;
                }
                if (collectItem.getAddTime() != 0) {
                    setAddTime(collectItem.getAddTime());
                }
                if (!collectItem.getItemId().isEmpty()) {
                    this.itemId_ = collectItem.itemId_;
                    onChanged();
                }
                if (!collectItem.getArtist().isEmpty()) {
                    this.artist_ = collectItem.artist_;
                    onChanged();
                }
                if (!collectItem.getImage().isEmpty()) {
                    this.image_ = collectItem.image_;
                    onChanged();
                }
                if (!collectItem.getLinkUrl().isEmpty()) {
                    this.linkUrl_ = collectItem.linkUrl_;
                    onChanged();
                }
                if (!collectItem.getQuery().isEmpty()) {
                    this.query_ = collectItem.query_;
                    onChanged();
                }
                if (!collectItem.getSource().isEmpty()) {
                    this.source_ = collectItem.source_;
                    onChanged();
                }
                if (!collectItem.getTitle().isEmpty()) {
                    this.title_ = collectItem.title_;
                    onChanged();
                }
                if (!collectItem.getType().isEmpty()) {
                    this.type_ = collectItem.type_;
                    onChanged();
                }
                if (!collectItem.getUserId().isEmpty()) {
                    this.userId_ = collectItem.userId_;
                    onChanged();
                }
                if (!collectItem.getCategory().isEmpty()) {
                    this.category_ = collectItem.category_;
                    onChanged();
                }
                onChanged();
                return this;
            }

            private Builder(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.itemId_ = "";
                this.artist_ = "";
                this.image_ = "";
                this.linkUrl_ = "";
                this.query_ = "";
                this.source_ = "";
                this.title_ = "";
                this.type_ = "";
                this.userId_ = "";
                this.category_ = "";
                maybeForceBuilderInitialization();
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x0023  */
            @Override // com.google.protobuf.a.AbstractC0170a, com.google.protobuf.b.a, com.google.protobuf.e0.a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(i iVar, q qVar) throws IOException {
                Throwable th2;
                CollectItem collectItem = null;
                try {
                    try {
                        CollectItem collectItem2 = (CollectItem) CollectItem.PARSER.parsePartialFrom(iVar, qVar);
                        if (collectItem2 != null) {
                            mergeFrom(collectItem2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e10) {
                        collectItem = (CollectItem) e10.getUnfinishedMessage();
                        try {
                            throw e10.unwrapIOException();
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (collectItem != null) {
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (collectItem != null) {
                        mergeFrom(collectItem);
                    }
                    throw th2;
                }
            }
        }

        public static Builder newBuilder(CollectItem collectItem) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(collectItem);
        }

        public static CollectItem parseFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, qVar);
        }

        private CollectItem(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static CollectItem parseDelimitedFrom(InputStream inputStream, q qVar) throws IOException {
            return (CollectItem) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
        }

        public static CollectItem parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
        public CollectItem getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static CollectItem parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder newBuilderForType() {
            return newBuilder();
        }

        private CollectItem() {
            this.memoizedIsInitialized = (byte) -1;
            this.addTime_ = 0L;
            this.itemId_ = "";
            this.artist_ = "";
            this.image_ = "";
            this.linkUrl_ = "";
            this.query_ = "";
            this.source_ = "";
            this.title_ = "";
            this.type_ = "";
            this.userId_ = "";
            this.category_ = "";
        }

        public static CollectItem parseFrom(InputStream inputStream) throws IOException {
            return (CollectItem) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.c cVar) {
            return new Builder(cVar);
        }

        public static CollectItem parseFrom(InputStream inputStream, q qVar) throws IOException {
            return (CollectItem) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
        }

        public static CollectItem parseFrom(i iVar) throws IOException {
            return (CollectItem) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
        }

        public static CollectItem parseFrom(i iVar, q qVar) throws IOException {
            return (CollectItem) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
        }

        private CollectItem(i iVar, q qVar) throws InvalidProtocolBufferException {
            this();
            boolean z10 = false;
            while (!z10) {
                try {
                    try {
                        int F = iVar.F();
                        z10 = true;
                        switch (F) {
                            case 0:
                                break;
                            case 8:
                                this.addTime_ = iVar.u();
                                continue;
                            case 18:
                                this.itemId_ = iVar.E();
                                continue;
                            case 26:
                                this.artist_ = iVar.E();
                                continue;
                            case 34:
                                this.image_ = iVar.E();
                                continue;
                            case 42:
                                this.linkUrl_ = iVar.E();
                                continue;
                            case 50:
                                this.query_ = iVar.E();
                                continue;
                            case 58:
                                this.source_ = iVar.E();
                                continue;
                            case 66:
                                this.title_ = iVar.E();
                                continue;
                            case 74:
                                this.type_ = iVar.E();
                                continue;
                            case 82:
                                this.userId_ = iVar.E();
                                continue;
                            case 90:
                                this.category_ = iVar.E();
                                continue;
                            default:
                                if (!iVar.I(F)) {
                                    break;
                                } else {
                                    continue;
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
    public interface CollectItemOrBuilder extends g0 {
        /* synthetic */ List<String> findInitializationErrors();

        long getAddTime();

        @Override // com.google.protobuf.g0
        /* synthetic */ Map<Descriptors.FieldDescriptor, Object> getAllFields();

        String getArtist();

        ByteString getArtistBytes();

        String getCategory();

        ByteString getCategoryBytes();

        @Override // com.google.protobuf.g0
        /* synthetic */ d0 getDefaultInstanceForType();

        @Override // com.google.protobuf.g0
        /* synthetic */ e0 getDefaultInstanceForType();

        @Override // com.google.protobuf.g0
        /* synthetic */ Descriptors.b getDescriptorForType();

        @Override // com.google.protobuf.g0
        /* synthetic */ Object getField(Descriptors.FieldDescriptor fieldDescriptor);

        String getImage();

        ByteString getImageBytes();

        /* synthetic */ String getInitializationErrorString();

        String getItemId();

        ByteString getItemIdBytes();

        String getLinkUrl();

        ByteString getLinkUrlBytes();

        /* synthetic */ Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.h hVar);

        String getQuery();

        ByteString getQueryBytes();

        /* synthetic */ Object getRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i10);

        /* synthetic */ int getRepeatedFieldCount(Descriptors.FieldDescriptor fieldDescriptor);

        String getSource();

        ByteString getSourceBytes();

        String getTitle();

        ByteString getTitleBytes();

        String getType();

        ByteString getTypeBytes();

        @Override // com.google.protobuf.g0
        /* synthetic */ a1 getUnknownFields();

        String getUserId();

        ByteString getUserIdBytes();

        @Override // com.google.protobuf.g0
        /* synthetic */ boolean hasField(Descriptors.FieldDescriptor fieldDescriptor);

        /* synthetic */ boolean hasOneof(Descriptors.h hVar);

        @Override // com.google.protobuf.f0
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes2.dex */
    public static final class CollectResponse extends GeneratedMessageV3 implements CollectResponseOrBuilder {
        public static final int ERR_CODE_FIELD_NUMBER = 1;
        public static final int ERR_MSG_FIELD_NUMBER = 2;
        public static final int ITEMS_FIELD_NUMBER = 3;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private int errCode_;
        private volatile Object errMsg_;
        private List<CollectItem> items_;
        private byte memoizedIsInitialized;
        private static final CollectResponse DEFAULT_INSTANCE = new CollectResponse();
        private static final l0<CollectResponse> PARSER = new c<CollectResponse>() { // from class: com.mobvoi.assistant.proto.Collect.CollectResponse.1
            @Override // com.google.protobuf.l0
            public CollectResponse parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
                return new CollectResponse(iVar, qVar);
            }
        };

        public static CollectResponse getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return Collect.internal_static_com_mobvoi_assistant_proto_CollectResponse_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static CollectResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (CollectResponse) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static CollectResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static l0<CollectResponse> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof CollectResponse)) {
                return super.equals(obj);
            }
            CollectResponse collectResponse = (CollectResponse) obj;
            return ((getErrCode() == collectResponse.getErrCode()) && getErrMsg().equals(collectResponse.getErrMsg())) && getItemsList().equals(collectResponse.getItemsList());
        }

        @Override // com.mobvoi.assistant.proto.Collect.CollectResponseOrBuilder
        public int getErrCode() {
            return this.errCode_;
        }

        @Override // com.mobvoi.assistant.proto.Collect.CollectResponseOrBuilder
        public String getErrMsg() {
            Object obj = this.errMsg_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.errMsg_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.assistant.proto.Collect.CollectResponseOrBuilder
        public ByteString getErrMsgBytes() {
            Object obj = this.errMsg_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.errMsg_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.mobvoi.assistant.proto.Collect.CollectResponseOrBuilder
        public CollectItem getItems(int i10) {
            return this.items_.get(i10);
        }

        @Override // com.mobvoi.assistant.proto.Collect.CollectResponseOrBuilder
        public int getItemsCount() {
            return this.items_.size();
        }

        @Override // com.mobvoi.assistant.proto.Collect.CollectResponseOrBuilder
        public List<CollectItem> getItemsList() {
            return this.items_;
        }

        @Override // com.mobvoi.assistant.proto.Collect.CollectResponseOrBuilder
        public CollectItemOrBuilder getItemsOrBuilder(int i10) {
            return this.items_.get(i10);
        }

        @Override // com.mobvoi.assistant.proto.Collect.CollectResponseOrBuilder
        public List<? extends CollectItemOrBuilder> getItemsOrBuilderList() {
            return this.items_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public l0<CollectResponse> getParserForType() {
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
            for (int i12 = 0; i12 < this.items_.size(); i12++) {
                v10 += CodedOutputStream.E(3, this.items_.get(i12));
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
            if (getItemsCount() > 0) {
                hashCode = (((hashCode * 37) + 3) * 53) + getItemsList().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return Collect.internal_static_com_mobvoi_assistant_proto_CollectResponse_fieldAccessorTable.e(CollectResponse.class, Builder.class);
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
            for (int i11 = 0; i11 < this.items_.size(); i11++) {
                codedOutputStream.A0(3, this.items_.get(i11));
            }
        }

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageV3.b<Builder> implements CollectResponseOrBuilder {
            private int bitField0_;
            private int errCode_;
            private Object errMsg_;
            private o0<CollectItem, CollectItem.Builder, CollectItemOrBuilder> itemsBuilder_;
            private List<CollectItem> items_;

            private void ensureItemsIsMutable() {
                if ((this.bitField0_ & 4) != 4) {
                    this.items_ = new ArrayList(this.items_);
                    this.bitField0_ |= 4;
                }
            }

            public static final Descriptors.b getDescriptor() {
                return Collect.internal_static_com_mobvoi_assistant_proto_CollectResponse_descriptor;
            }

            private o0<CollectItem, CollectItem.Builder, CollectItemOrBuilder> getItemsFieldBuilder() {
                if (this.itemsBuilder_ == null) {
                    this.itemsBuilder_ = new o0<>(this.items_, (this.bitField0_ & 4) == 4, getParentForChildren(), isClean());
                    this.items_ = null;
                }
                return this.itemsBuilder_;
            }

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                    getItemsFieldBuilder();
                }
            }

            public Builder addAllItems(Iterable<? extends CollectItem> iterable) {
                o0<CollectItem, CollectItem.Builder, CollectItemOrBuilder> o0Var = this.itemsBuilder_;
                if (o0Var == null) {
                    ensureItemsIsMutable();
                    b.a.addAll(iterable, this.items_);
                    onChanged();
                } else {
                    o0Var.b(iterable);
                }
                return this;
            }

            public Builder addItems(CollectItem collectItem) {
                o0<CollectItem, CollectItem.Builder, CollectItemOrBuilder> o0Var = this.itemsBuilder_;
                if (o0Var == null) {
                    Objects.requireNonNull(collectItem);
                    ensureItemsIsMutable();
                    this.items_.add(collectItem);
                    onChanged();
                } else {
                    o0Var.f(collectItem);
                }
                return this;
            }

            public CollectItem.Builder addItemsBuilder() {
                return getItemsFieldBuilder().d(CollectItem.getDefaultInstance());
            }

            public Builder clearErrCode() {
                this.errCode_ = 0;
                onChanged();
                return this;
            }

            public Builder clearErrMsg() {
                this.errMsg_ = CollectResponse.getDefaultInstance().getErrMsg();
                onChanged();
                return this;
            }

            public Builder clearItems() {
                o0<CollectItem, CollectItem.Builder, CollectItemOrBuilder> o0Var = this.itemsBuilder_;
                if (o0Var == null) {
                    this.items_ = Collections.emptyList();
                    this.bitField0_ &= -5;
                    onChanged();
                } else {
                    o0Var.h();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a, com.google.protobuf.g0
            public Descriptors.b getDescriptorForType() {
                return Collect.internal_static_com_mobvoi_assistant_proto_CollectResponse_descriptor;
            }

            @Override // com.mobvoi.assistant.proto.Collect.CollectResponseOrBuilder
            public int getErrCode() {
                return this.errCode_;
            }

            @Override // com.mobvoi.assistant.proto.Collect.CollectResponseOrBuilder
            public String getErrMsg() {
                Object obj = this.errMsg_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.errMsg_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.assistant.proto.Collect.CollectResponseOrBuilder
            public ByteString getErrMsgBytes() {
                Object obj = this.errMsg_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.errMsg_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.mobvoi.assistant.proto.Collect.CollectResponseOrBuilder
            public CollectItem getItems(int i10) {
                o0<CollectItem, CollectItem.Builder, CollectItemOrBuilder> o0Var = this.itemsBuilder_;
                if (o0Var == null) {
                    return this.items_.get(i10);
                }
                return o0Var.o(i10);
            }

            public CollectItem.Builder getItemsBuilder(int i10) {
                return getItemsFieldBuilder().l(i10);
            }

            public List<CollectItem.Builder> getItemsBuilderList() {
                return getItemsFieldBuilder().m();
            }

            @Override // com.mobvoi.assistant.proto.Collect.CollectResponseOrBuilder
            public int getItemsCount() {
                o0<CollectItem, CollectItem.Builder, CollectItemOrBuilder> o0Var = this.itemsBuilder_;
                if (o0Var == null) {
                    return this.items_.size();
                }
                return o0Var.n();
            }

            @Override // com.mobvoi.assistant.proto.Collect.CollectResponseOrBuilder
            public List<CollectItem> getItemsList() {
                o0<CollectItem, CollectItem.Builder, CollectItemOrBuilder> o0Var = this.itemsBuilder_;
                if (o0Var == null) {
                    return Collections.unmodifiableList(this.items_);
                }
                return o0Var.q();
            }

            @Override // com.mobvoi.assistant.proto.Collect.CollectResponseOrBuilder
            public CollectItemOrBuilder getItemsOrBuilder(int i10) {
                o0<CollectItem, CollectItem.Builder, CollectItemOrBuilder> o0Var = this.itemsBuilder_;
                if (o0Var == null) {
                    return this.items_.get(i10);
                }
                return o0Var.r(i10);
            }

            @Override // com.mobvoi.assistant.proto.Collect.CollectResponseOrBuilder
            public List<? extends CollectItemOrBuilder> getItemsOrBuilderList() {
                o0<CollectItem, CollectItem.Builder, CollectItemOrBuilder> o0Var = this.itemsBuilder_;
                if (o0Var != null) {
                    return o0Var.s();
                }
                return Collections.unmodifiableList(this.items_);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return Collect.internal_static_com_mobvoi_assistant_proto_CollectResponse_fieldAccessorTable.e(CollectResponse.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.f0
            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a
            public final Builder mergeUnknownFields(a1 a1Var) {
                return this;
            }

            public Builder removeItems(int i10) {
                o0<CollectItem, CollectItem.Builder, CollectItemOrBuilder> o0Var = this.itemsBuilder_;
                if (o0Var == null) {
                    ensureItemsIsMutable();
                    this.items_.remove(i10);
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

            public Builder setItems(int i10, CollectItem collectItem) {
                o0<CollectItem, CollectItem.Builder, CollectItemOrBuilder> o0Var = this.itemsBuilder_;
                if (o0Var == null) {
                    Objects.requireNonNull(collectItem);
                    ensureItemsIsMutable();
                    this.items_.set(i10, collectItem);
                    onChanged();
                } else {
                    o0Var.x(i10, collectItem);
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public final Builder setUnknownFields(a1 a1Var) {
                return this;
            }

            private Builder() {
                this.errMsg_ = "";
                this.items_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.e0.a, com.google.protobuf.d0.a
            public CollectResponse build() {
                CollectResponse buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) buildPartial);
            }

            @Override // com.google.protobuf.e0.a, com.google.protobuf.d0.a
            public CollectResponse buildPartial() {
                CollectResponse collectResponse = new CollectResponse(this);
                collectResponse.errCode_ = this.errCode_;
                collectResponse.errMsg_ = this.errMsg_;
                o0<CollectItem, CollectItem.Builder, CollectItemOrBuilder> o0Var = this.itemsBuilder_;
                if (o0Var == null) {
                    if ((this.bitField0_ & 4) == 4) {
                        this.items_ = Collections.unmodifiableList(this.items_);
                        this.bitField0_ &= -5;
                    }
                    collectResponse.items_ = this.items_;
                } else {
                    collectResponse.items_ = o0Var.g();
                }
                collectResponse.bitField0_ = 0;
                onBuilt();
                return collectResponse;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.f0, com.google.protobuf.g0
            public CollectResponse getDefaultInstanceForType() {
                return CollectResponse.getDefaultInstance();
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

            public CollectItem.Builder addItemsBuilder(int i10) {
                return getItemsFieldBuilder().c(i10, CollectItem.getDefaultInstance());
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
                o0<CollectItem, CollectItem.Builder, CollectItemOrBuilder> o0Var = this.itemsBuilder_;
                if (o0Var == null) {
                    this.items_ = Collections.emptyList();
                    this.bitField0_ &= -5;
                } else {
                    o0Var.h();
                }
                return this;
            }

            private Builder(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.errMsg_ = "";
                this.items_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            public Builder addItems(int i10, CollectItem collectItem) {
                o0<CollectItem, CollectItem.Builder, CollectItemOrBuilder> o0Var = this.itemsBuilder_;
                if (o0Var == null) {
                    Objects.requireNonNull(collectItem);
                    ensureItemsIsMutable();
                    this.items_.add(i10, collectItem);
                    onChanged();
                } else {
                    o0Var.e(i10, collectItem);
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a, com.google.protobuf.b.a
            public Builder clone() {
                return (Builder) super.clone();
            }

            @Override // com.google.protobuf.a.AbstractC0170a, com.google.protobuf.d0.a
            public Builder mergeFrom(d0 d0Var) {
                if (d0Var instanceof CollectResponse) {
                    return mergeFrom((CollectResponse) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            public Builder setItems(int i10, CollectItem.Builder builder) {
                o0<CollectItem, CollectItem.Builder, CollectItemOrBuilder> o0Var = this.itemsBuilder_;
                if (o0Var == null) {
                    ensureItemsIsMutable();
                    this.items_.set(i10, builder.build());
                    onChanged();
                } else {
                    o0Var.x(i10, builder.build());
                }
                return this;
            }

            public Builder mergeFrom(CollectResponse collectResponse) {
                if (collectResponse == CollectResponse.getDefaultInstance()) {
                    return this;
                }
                if (collectResponse.getErrCode() != 0) {
                    setErrCode(collectResponse.getErrCode());
                }
                if (!collectResponse.getErrMsg().isEmpty()) {
                    this.errMsg_ = collectResponse.errMsg_;
                    onChanged();
                }
                if (this.itemsBuilder_ == null) {
                    if (!collectResponse.items_.isEmpty()) {
                        if (this.items_.isEmpty()) {
                            this.items_ = collectResponse.items_;
                            this.bitField0_ &= -5;
                        } else {
                            ensureItemsIsMutable();
                            this.items_.addAll(collectResponse.items_);
                        }
                        onChanged();
                    }
                } else if (!collectResponse.items_.isEmpty()) {
                    if (this.itemsBuilder_.u()) {
                        this.itemsBuilder_.i();
                        o0<CollectItem, CollectItem.Builder, CollectItemOrBuilder> o0Var = null;
                        this.itemsBuilder_ = null;
                        this.items_ = collectResponse.items_;
                        this.bitField0_ &= -5;
                        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                            o0Var = getItemsFieldBuilder();
                        }
                        this.itemsBuilder_ = o0Var;
                    } else {
                        this.itemsBuilder_.b(collectResponse.items_);
                    }
                }
                onChanged();
                return this;
            }

            public Builder addItems(CollectItem.Builder builder) {
                o0<CollectItem, CollectItem.Builder, CollectItemOrBuilder> o0Var = this.itemsBuilder_;
                if (o0Var == null) {
                    ensureItemsIsMutable();
                    this.items_.add(builder.build());
                    onChanged();
                } else {
                    o0Var.f(builder.build());
                }
                return this;
            }

            public Builder addItems(int i10, CollectItem.Builder builder) {
                o0<CollectItem, CollectItem.Builder, CollectItemOrBuilder> o0Var = this.itemsBuilder_;
                if (o0Var == null) {
                    ensureItemsIsMutable();
                    this.items_.add(i10, builder.build());
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
                CollectResponse collectResponse = null;
                try {
                    try {
                        CollectResponse collectResponse2 = (CollectResponse) CollectResponse.PARSER.parsePartialFrom(iVar, qVar);
                        if (collectResponse2 != null) {
                            mergeFrom(collectResponse2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e10) {
                        collectResponse = (CollectResponse) e10.getUnfinishedMessage();
                        try {
                            throw e10.unwrapIOException();
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (collectResponse != null) {
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (collectResponse != null) {
                        mergeFrom(collectResponse);
                    }
                    throw th2;
                }
            }
        }

        public static Builder newBuilder(CollectResponse collectResponse) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(collectResponse);
        }

        public static CollectResponse parseFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, qVar);
        }

        private CollectResponse(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static CollectResponse parseDelimitedFrom(InputStream inputStream, q qVar) throws IOException {
            return (CollectResponse) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
        }

        public static CollectResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
        public CollectResponse getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static CollectResponse parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder newBuilderForType() {
            return newBuilder();
        }

        private CollectResponse() {
            this.memoizedIsInitialized = (byte) -1;
            this.errCode_ = 0;
            this.errMsg_ = "";
            this.items_ = Collections.emptyList();
        }

        public static CollectResponse parseFrom(InputStream inputStream) throws IOException {
            return (CollectResponse) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.c cVar) {
            return new Builder(cVar);
        }

        public static CollectResponse parseFrom(InputStream inputStream, q qVar) throws IOException {
            return (CollectResponse) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
        }

        public static CollectResponse parseFrom(i iVar) throws IOException {
            return (CollectResponse) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
        }

        private CollectResponse(i iVar, q qVar) throws InvalidProtocolBufferException {
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
                                    this.items_ = new ArrayList();
                                    z11 |= true;
                                }
                                this.items_.add((CollectItem) iVar.v(CollectItem.parser(), qVar));
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
                        this.items_ = Collections.unmodifiableList(this.items_);
                    }
                    makeExtensionsImmutable();
                }
            }
        }

        public static CollectResponse parseFrom(i iVar, q qVar) throws IOException {
            return (CollectResponse) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
        }
    }

    /* loaded from: classes2.dex */
    public interface CollectResponseOrBuilder extends g0 {
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

        CollectItem getItems(int i10);

        int getItemsCount();

        List<CollectItem> getItemsList();

        CollectItemOrBuilder getItemsOrBuilder(int i10);

        List<? extends CollectItemOrBuilder> getItemsOrBuilderList();

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
        Descriptors.FileDescriptor.q(new String[]{"\n\rcollect.proto\u0012\u001acom.mobvoi.assistant.proto\"À\u0001\n\u000bCollectItem\u0012\u0010\n\badd_time\u0018\u0001 \u0001(\u0003\u0012\u000f\n\u0007item_id\u0018\u0002 \u0001(\t\u0012\u000e\n\u0006artist\u0018\u0003 \u0001(\t\u0012\r\n\u0005image\u0018\u0004 \u0001(\t\u0012\u0010\n\blink_url\u0018\u0005 \u0001(\t\u0012\r\n\u0005query\u0018\u0006 \u0001(\t\u0012\u000e\n\u0006source\u0018\u0007 \u0001(\t\u0012\r\n\u0005title\u0018\b \u0001(\t\u0012\f\n\u0004type\u0018\t \u0001(\t\u0012\u000f\n\u0007user_id\u0018\n \u0001(\t\u0012\u0010\n\bcategory\u0018\u000b \u0001(\t\"l\n\u000fCollectResponse\u0012\u0010\n\berr_code\u0018\u0001 \u0001(\u0005\u0012\u000f\n\u0007err_msg\u0018\u0002 \u0001(\t\u00126\n\u0005items\u0018\u0003 \u0003(\u000b2'.com.mobvoi.assistant.proto.CollectItemB\tB\u0007Collectb\u0006proto3"}, new Descriptors.FileDescriptor[0], new Descriptors.FileDescriptor.a() { // from class: com.mobvoi.assistant.proto.Collect.1
            @Override // com.google.protobuf.Descriptors.FileDescriptor.a
            public o assignDescriptors(Descriptors.FileDescriptor fileDescriptor) {
                Descriptors.FileDescriptor unused = Collect.descriptor = fileDescriptor;
                return null;
            }
        });
        Descriptors.b bVar = getDescriptor().j().get(0);
        internal_static_com_mobvoi_assistant_proto_CollectItem_descriptor = bVar;
        internal_static_com_mobvoi_assistant_proto_CollectItem_fieldAccessorTable = new GeneratedMessageV3.e(bVar, new String[]{"AddTime", "ItemId", "Artist", "Image", "LinkUrl", "Query", "Source", "Title", "Type", "UserId", "Category"});
        Descriptors.b bVar2 = getDescriptor().j().get(1);
        internal_static_com_mobvoi_assistant_proto_CollectResponse_descriptor = bVar2;
        internal_static_com_mobvoi_assistant_proto_CollectResponse_fieldAccessorTable = new GeneratedMessageV3.e(bVar2, new String[]{"ErrCode", "ErrMsg", "Items"});
    }

    private Collect() {
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
