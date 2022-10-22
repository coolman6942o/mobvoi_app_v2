package com.mobvoi.companion;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.WireFormat;
import com.google.protobuf.a;
import com.google.protobuf.a0;
import com.google.protobuf.a1;
import com.google.protobuf.b;
import com.google.protobuf.c;
import com.google.protobuf.c0;
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
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
/* loaded from: classes2.dex */
public final class FeedbackProto {
    private static Descriptors.FileDescriptor descriptor;
    private static final Descriptors.b internal_static_feedbackhub_FeedbackRequest_AttachmentsEntry_descriptor;
    private static final GeneratedMessageV3.e internal_static_feedbackhub_FeedbackRequest_AttachmentsEntry_fieldAccessorTable;
    private static final Descriptors.b internal_static_feedbackhub_FeedbackRequest_ExtrasEntry_descriptor;
    private static final GeneratedMessageV3.e internal_static_feedbackhub_FeedbackRequest_ExtrasEntry_fieldAccessorTable;
    private static final Descriptors.b internal_static_feedbackhub_FeedbackRequest_descriptor;
    private static final GeneratedMessageV3.e internal_static_feedbackhub_FeedbackRequest_fieldAccessorTable;
    private static final Descriptors.b internal_static_feedbackhub_Feedback_descriptor;
    private static final GeneratedMessageV3.e internal_static_feedbackhub_Feedback_fieldAccessorTable;
    private static final Descriptors.b internal_static_feedbackhub_Feedbacks_descriptor;
    private static final GeneratedMessageV3.e internal_static_feedbackhub_Feedbacks_fieldAccessorTable;
    private static final Descriptors.b internal_static_feedbackhub_FilesAndInfo_FilesEntry_descriptor;
    private static final GeneratedMessageV3.e internal_static_feedbackhub_FilesAndInfo_FilesEntry_fieldAccessorTable;
    private static final Descriptors.b internal_static_feedbackhub_FilesAndInfo_InfoEntry_descriptor;
    private static final GeneratedMessageV3.e internal_static_feedbackhub_FilesAndInfo_InfoEntry_fieldAccessorTable;
    private static final Descriptors.b internal_static_feedbackhub_FilesAndInfo_descriptor;
    private static final GeneratedMessageV3.e internal_static_feedbackhub_FilesAndInfo_fieldAccessorTable;
    private static final Descriptors.b internal_static_feedbackhub_Request_descriptor;
    private static final GeneratedMessageV3.e internal_static_feedbackhub_Request_fieldAccessorTable;
    private static final Descriptors.b internal_static_feedbackhub_Response_descriptor;
    private static final GeneratedMessageV3.e internal_static_feedbackhub_Response_fieldAccessorTable;
    private static final Descriptors.b internal_static_feedbackhub_TicautoLog_descriptor;
    private static final GeneratedMessageV3.e internal_static_feedbackhub_TicautoLog_fieldAccessorTable;
    private static final Descriptors.b internal_static_feedbackhub_TicautoLogs_descriptor;
    private static final GeneratedMessageV3.e internal_static_feedbackhub_TicautoLogs_fieldAccessorTable;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mobvoi.companion.FeedbackProto$2  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$mobvoi$companion$FeedbackProto$Request$TypeCase;
        static final /* synthetic */ int[] $SwitchMap$com$mobvoi$companion$FeedbackProto$Response$TypeCase;

        static {
            int[] iArr = new int[Response.TypeCase.values().length];
            $SwitchMap$com$mobvoi$companion$FeedbackProto$Response$TypeCase = iArr;
            try {
                iArr[Response.TypeCase.FEEDBACK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$mobvoi$companion$FeedbackProto$Response$TypeCase[Response.TypeCase.OSS_URL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$mobvoi$companion$FeedbackProto$Response$TypeCase[Response.TypeCase.FEEDBACKS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$mobvoi$companion$FeedbackProto$Response$TypeCase[Response.TypeCase.UPLOAD_ID.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$mobvoi$companion$FeedbackProto$Response$TypeCase[Response.TypeCase.TYPE_NOT_SET.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr2 = new int[Request.TypeCase.values().length];
            $SwitchMap$com$mobvoi$companion$FeedbackProto$Request$TypeCase = iArr2;
            try {
                iArr2[Request.TypeCase.COMMENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$mobvoi$companion$FeedbackProto$Request$TypeCase[Request.TypeCase.FEEDBACK.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$mobvoi$companion$FeedbackProto$Request$TypeCase[Request.TypeCase.TICAUTO_LOGS.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$mobvoi$companion$FeedbackProto$Request$TypeCase[Request.TypeCase.FILES_AND_INFO.ordinal()] = 4;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$mobvoi$companion$FeedbackProto$Request$TypeCase[Request.TypeCase.TYPE_NOT_SET.ordinal()] = 5;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class Feedback extends GeneratedMessageV3 implements FeedbackOrBuilder {
        public static final int CREATED_AT_FIELD_NUMBER = 12;
        public static final int DELETED_FIELD_NUMBER = 17;
        public static final int DEVICE_ID_FIELD_NUMBER = 18;
        public static final int ID_FIELD_NUMBER = 11;
        public static final int ISSUE_MAIN_FIELD_NUMBER = 14;
        public static final int ISSUE_SUB_FIELD_NUMBER = 15;
        public static final int JIRA_CREATED_FIELD_NUMBER = 9;
        public static final int JIRA_ISSUE_KEY_FIELD_NUMBER = 10;
        public static final int JIRA_STATUS_FIELD_NUMBER = 16;
        public static final int SOURCE_FIELD_NUMBER = 6;
        public static final int SUBSOURCE_FIELD_NUMBER = 7;
        public static final int USER_DESCRIPTION_FIELD_NUMBER = 13;
        public static final int WWID_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private long createdAt_;
        private boolean deleted_;
        private volatile Object deviceId_;
        private int id_;
        private volatile Object issueMain_;
        private volatile Object issueSub_;
        private boolean jiraCreated_;
        private volatile Object jiraIssueKey_;
        private volatile Object jiraStatus_;
        private byte memoizedIsInitialized;
        private volatile Object source_;
        private volatile Object subsource_;
        private volatile Object userDescription_;
        private volatile Object wwid_;
        private static final Feedback DEFAULT_INSTANCE = new Feedback();
        private static final l0<Feedback> PARSER = new c<Feedback>() { // from class: com.mobvoi.companion.FeedbackProto.Feedback.1
            @Override // com.google.protobuf.l0
            public Feedback parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
                return new Feedback(iVar, qVar);
            }
        };

        public static Feedback getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return FeedbackProto.internal_static_feedbackhub_Feedback_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Feedback parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Feedback) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static Feedback parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static l0<Feedback> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Feedback)) {
                return super.equals(obj);
            }
            Feedback feedback = (Feedback) obj;
            return ((((((((((((getId() == feedback.getId()) && (getCreatedAt() > feedback.getCreatedAt() ? 1 : (getCreatedAt() == feedback.getCreatedAt() ? 0 : -1)) == 0) && getWwid().equals(feedback.getWwid())) && getSource().equals(feedback.getSource())) && getSubsource().equals(feedback.getSubsource())) && getJiraCreated() == feedback.getJiraCreated()) && getJiraIssueKey().equals(feedback.getJiraIssueKey())) && getUserDescription().equals(feedback.getUserDescription())) && getIssueMain().equals(feedback.getIssueMain())) && getIssueSub().equals(feedback.getIssueSub())) && getJiraStatus().equals(feedback.getJiraStatus())) && getDeleted() == feedback.getDeleted()) && getDeviceId().equals(feedback.getDeviceId());
        }

        @Override // com.mobvoi.companion.FeedbackProto.FeedbackOrBuilder
        public long getCreatedAt() {
            return this.createdAt_;
        }

        @Override // com.mobvoi.companion.FeedbackProto.FeedbackOrBuilder
        public boolean getDeleted() {
            return this.deleted_;
        }

        @Override // com.mobvoi.companion.FeedbackProto.FeedbackOrBuilder
        public String getDeviceId() {
            Object obj = this.deviceId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.deviceId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.FeedbackProto.FeedbackOrBuilder
        public ByteString getDeviceIdBytes() {
            Object obj = this.deviceId_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.deviceId_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.mobvoi.companion.FeedbackProto.FeedbackOrBuilder
        public int getId() {
            return this.id_;
        }

        @Override // com.mobvoi.companion.FeedbackProto.FeedbackOrBuilder
        public String getIssueMain() {
            Object obj = this.issueMain_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.issueMain_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.FeedbackProto.FeedbackOrBuilder
        public ByteString getIssueMainBytes() {
            Object obj = this.issueMain_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.issueMain_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.mobvoi.companion.FeedbackProto.FeedbackOrBuilder
        public String getIssueSub() {
            Object obj = this.issueSub_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.issueSub_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.FeedbackProto.FeedbackOrBuilder
        public ByteString getIssueSubBytes() {
            Object obj = this.issueSub_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.issueSub_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.mobvoi.companion.FeedbackProto.FeedbackOrBuilder
        public boolean getJiraCreated() {
            return this.jiraCreated_;
        }

        @Override // com.mobvoi.companion.FeedbackProto.FeedbackOrBuilder
        public String getJiraIssueKey() {
            Object obj = this.jiraIssueKey_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.jiraIssueKey_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.FeedbackProto.FeedbackOrBuilder
        public ByteString getJiraIssueKeyBytes() {
            Object obj = this.jiraIssueKey_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.jiraIssueKey_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.mobvoi.companion.FeedbackProto.FeedbackOrBuilder
        public String getJiraStatus() {
            Object obj = this.jiraStatus_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.jiraStatus_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.FeedbackProto.FeedbackOrBuilder
        public ByteString getJiraStatusBytes() {
            Object obj = this.jiraStatus_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.jiraStatus_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public l0<Feedback> getParserForType() {
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
            if (!getSourceBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(6, this.source_);
            }
            if (!getSubsourceBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(7, this.subsource_);
            }
            boolean z10 = this.jiraCreated_;
            if (z10) {
                i11 += CodedOutputStream.e(9, z10);
            }
            if (!getJiraIssueKeyBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(10, this.jiraIssueKey_);
            }
            int i12 = this.id_;
            if (i12 != 0) {
                i11 += CodedOutputStream.v(11, i12);
            }
            long j10 = this.createdAt_;
            if (j10 != 0) {
                i11 += CodedOutputStream.x(12, j10);
            }
            if (!getUserDescriptionBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(13, this.userDescription_);
            }
            if (!getIssueMainBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(14, this.issueMain_);
            }
            if (!getIssueSubBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(15, this.issueSub_);
            }
            if (!getJiraStatusBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(16, this.jiraStatus_);
            }
            boolean z11 = this.deleted_;
            if (z11) {
                i11 += CodedOutputStream.e(17, z11);
            }
            if (!getDeviceIdBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(18, this.deviceId_);
            }
            this.memoizedSize = i11;
            return i11;
        }

        @Override // com.mobvoi.companion.FeedbackProto.FeedbackOrBuilder
        public String getSource() {
            Object obj = this.source_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.source_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.FeedbackProto.FeedbackOrBuilder
        public ByteString getSourceBytes() {
            Object obj = this.source_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.source_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.mobvoi.companion.FeedbackProto.FeedbackOrBuilder
        public String getSubsource() {
            Object obj = this.subsource_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.subsource_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.FeedbackProto.FeedbackOrBuilder
        public ByteString getSubsourceBytes() {
            Object obj = this.subsource_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.subsource_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.g0
        public final a1 getUnknownFields() {
            return a1.c();
        }

        @Override // com.mobvoi.companion.FeedbackProto.FeedbackOrBuilder
        public String getUserDescription() {
            Object obj = this.userDescription_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.userDescription_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.FeedbackProto.FeedbackOrBuilder
        public ByteString getUserDescriptionBytes() {
            Object obj = this.userDescription_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.userDescription_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.mobvoi.companion.FeedbackProto.FeedbackOrBuilder
        public String getWwid() {
            Object obj = this.wwid_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.wwid_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.FeedbackProto.FeedbackOrBuilder
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
            int hashCode = ((((((((((((((((((((((((((((((((((((((((((((((((((((((779 + getDescriptorForType().hashCode()) * 37) + 11) * 53) + getId()) * 37) + 12) * 53) + u.h(getCreatedAt())) * 37) + 1) * 53) + getWwid().hashCode()) * 37) + 6) * 53) + getSource().hashCode()) * 37) + 7) * 53) + getSubsource().hashCode()) * 37) + 9) * 53) + u.c(getJiraCreated())) * 37) + 10) * 53) + getJiraIssueKey().hashCode()) * 37) + 13) * 53) + getUserDescription().hashCode()) * 37) + 14) * 53) + getIssueMain().hashCode()) * 37) + 15) * 53) + getIssueSub().hashCode()) * 37) + 16) * 53) + getJiraStatus().hashCode()) * 37) + 17) * 53) + u.c(getDeleted())) * 37) + 18) * 53) + getDeviceId().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return FeedbackProto.internal_static_feedbackhub_Feedback_fieldAccessorTable.e(Feedback.class, Builder.class);
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
            if (!getSourceBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 6, this.source_);
            }
            if (!getSubsourceBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 7, this.subsource_);
            }
            boolean z10 = this.jiraCreated_;
            if (z10) {
                codedOutputStream.e0(9, z10);
            }
            if (!getJiraIssueKeyBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 10, this.jiraIssueKey_);
            }
            int i10 = this.id_;
            if (i10 != 0) {
                codedOutputStream.w0(11, i10);
            }
            long j10 = this.createdAt_;
            if (j10 != 0) {
                codedOutputStream.y0(12, j10);
            }
            if (!getUserDescriptionBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 13, this.userDescription_);
            }
            if (!getIssueMainBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 14, this.issueMain_);
            }
            if (!getIssueSubBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 15, this.issueSub_);
            }
            if (!getJiraStatusBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 16, this.jiraStatus_);
            }
            boolean z11 = this.deleted_;
            if (z11) {
                codedOutputStream.e0(17, z11);
            }
            if (!getDeviceIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 18, this.deviceId_);
            }
        }

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageV3.b<Builder> implements FeedbackOrBuilder {
            private long createdAt_;
            private boolean deleted_;
            private Object deviceId_;
            private int id_;
            private Object issueMain_;
            private Object issueSub_;
            private boolean jiraCreated_;
            private Object jiraIssueKey_;
            private Object jiraStatus_;
            private Object source_;
            private Object subsource_;
            private Object userDescription_;
            private Object wwid_;

            public static final Descriptors.b getDescriptor() {
                return FeedbackProto.internal_static_feedbackhub_Feedback_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            public Builder clearCreatedAt() {
                this.createdAt_ = 0L;
                onChanged();
                return this;
            }

            public Builder clearDeleted() {
                this.deleted_ = false;
                onChanged();
                return this;
            }

            public Builder clearDeviceId() {
                this.deviceId_ = Feedback.getDefaultInstance().getDeviceId();
                onChanged();
                return this;
            }

            public Builder clearId() {
                this.id_ = 0;
                onChanged();
                return this;
            }

            public Builder clearIssueMain() {
                this.issueMain_ = Feedback.getDefaultInstance().getIssueMain();
                onChanged();
                return this;
            }

            public Builder clearIssueSub() {
                this.issueSub_ = Feedback.getDefaultInstance().getIssueSub();
                onChanged();
                return this;
            }

            public Builder clearJiraCreated() {
                this.jiraCreated_ = false;
                onChanged();
                return this;
            }

            public Builder clearJiraIssueKey() {
                this.jiraIssueKey_ = Feedback.getDefaultInstance().getJiraIssueKey();
                onChanged();
                return this;
            }

            public Builder clearJiraStatus() {
                this.jiraStatus_ = Feedback.getDefaultInstance().getJiraStatus();
                onChanged();
                return this;
            }

            public Builder clearSource() {
                this.source_ = Feedback.getDefaultInstance().getSource();
                onChanged();
                return this;
            }

            public Builder clearSubsource() {
                this.subsource_ = Feedback.getDefaultInstance().getSubsource();
                onChanged();
                return this;
            }

            public Builder clearUserDescription() {
                this.userDescription_ = Feedback.getDefaultInstance().getUserDescription();
                onChanged();
                return this;
            }

            public Builder clearWwid() {
                this.wwid_ = Feedback.getDefaultInstance().getWwid();
                onChanged();
                return this;
            }

            @Override // com.mobvoi.companion.FeedbackProto.FeedbackOrBuilder
            public long getCreatedAt() {
                return this.createdAt_;
            }

            @Override // com.mobvoi.companion.FeedbackProto.FeedbackOrBuilder
            public boolean getDeleted() {
                return this.deleted_;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a, com.google.protobuf.g0
            public Descriptors.b getDescriptorForType() {
                return FeedbackProto.internal_static_feedbackhub_Feedback_descriptor;
            }

            @Override // com.mobvoi.companion.FeedbackProto.FeedbackOrBuilder
            public String getDeviceId() {
                Object obj = this.deviceId_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.deviceId_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.FeedbackProto.FeedbackOrBuilder
            public ByteString getDeviceIdBytes() {
                Object obj = this.deviceId_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.deviceId_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.mobvoi.companion.FeedbackProto.FeedbackOrBuilder
            public int getId() {
                return this.id_;
            }

            @Override // com.mobvoi.companion.FeedbackProto.FeedbackOrBuilder
            public String getIssueMain() {
                Object obj = this.issueMain_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.issueMain_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.FeedbackProto.FeedbackOrBuilder
            public ByteString getIssueMainBytes() {
                Object obj = this.issueMain_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.issueMain_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.mobvoi.companion.FeedbackProto.FeedbackOrBuilder
            public String getIssueSub() {
                Object obj = this.issueSub_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.issueSub_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.FeedbackProto.FeedbackOrBuilder
            public ByteString getIssueSubBytes() {
                Object obj = this.issueSub_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.issueSub_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.mobvoi.companion.FeedbackProto.FeedbackOrBuilder
            public boolean getJiraCreated() {
                return this.jiraCreated_;
            }

            @Override // com.mobvoi.companion.FeedbackProto.FeedbackOrBuilder
            public String getJiraIssueKey() {
                Object obj = this.jiraIssueKey_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.jiraIssueKey_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.FeedbackProto.FeedbackOrBuilder
            public ByteString getJiraIssueKeyBytes() {
                Object obj = this.jiraIssueKey_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.jiraIssueKey_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.mobvoi.companion.FeedbackProto.FeedbackOrBuilder
            public String getJiraStatus() {
                Object obj = this.jiraStatus_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.jiraStatus_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.FeedbackProto.FeedbackOrBuilder
            public ByteString getJiraStatusBytes() {
                Object obj = this.jiraStatus_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.jiraStatus_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.mobvoi.companion.FeedbackProto.FeedbackOrBuilder
            public String getSource() {
                Object obj = this.source_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.source_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.FeedbackProto.FeedbackOrBuilder
            public ByteString getSourceBytes() {
                Object obj = this.source_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.source_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.mobvoi.companion.FeedbackProto.FeedbackOrBuilder
            public String getSubsource() {
                Object obj = this.subsource_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.subsource_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.FeedbackProto.FeedbackOrBuilder
            public ByteString getSubsourceBytes() {
                Object obj = this.subsource_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.subsource_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.mobvoi.companion.FeedbackProto.FeedbackOrBuilder
            public String getUserDescription() {
                Object obj = this.userDescription_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.userDescription_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.FeedbackProto.FeedbackOrBuilder
            public ByteString getUserDescriptionBytes() {
                Object obj = this.userDescription_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.userDescription_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.mobvoi.companion.FeedbackProto.FeedbackOrBuilder
            public String getWwid() {
                Object obj = this.wwid_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.wwid_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.FeedbackProto.FeedbackOrBuilder
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
                return FeedbackProto.internal_static_feedbackhub_Feedback_fieldAccessorTable.e(Feedback.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.f0
            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a
            public final Builder mergeUnknownFields(a1 a1Var) {
                return this;
            }

            public Builder setCreatedAt(long j10) {
                this.createdAt_ = j10;
                onChanged();
                return this;
            }

            public Builder setDeleted(boolean z10) {
                this.deleted_ = z10;
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

            public Builder setId(int i10) {
                this.id_ = i10;
                onChanged();
                return this;
            }

            public Builder setIssueMain(String str) {
                Objects.requireNonNull(str);
                this.issueMain_ = str;
                onChanged();
                return this;
            }

            public Builder setIssueMainBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                b.checkByteStringIsUtf8(byteString);
                this.issueMain_ = byteString;
                onChanged();
                return this;
            }

            public Builder setIssueSub(String str) {
                Objects.requireNonNull(str);
                this.issueSub_ = str;
                onChanged();
                return this;
            }

            public Builder setIssueSubBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                b.checkByteStringIsUtf8(byteString);
                this.issueSub_ = byteString;
                onChanged();
                return this;
            }

            public Builder setJiraCreated(boolean z10) {
                this.jiraCreated_ = z10;
                onChanged();
                return this;
            }

            public Builder setJiraIssueKey(String str) {
                Objects.requireNonNull(str);
                this.jiraIssueKey_ = str;
                onChanged();
                return this;
            }

            public Builder setJiraIssueKeyBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                b.checkByteStringIsUtf8(byteString);
                this.jiraIssueKey_ = byteString;
                onChanged();
                return this;
            }

            public Builder setJiraStatus(String str) {
                Objects.requireNonNull(str);
                this.jiraStatus_ = str;
                onChanged();
                return this;
            }

            public Builder setJiraStatusBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                b.checkByteStringIsUtf8(byteString);
                this.jiraStatus_ = byteString;
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

            public Builder setSubsource(String str) {
                Objects.requireNonNull(str);
                this.subsource_ = str;
                onChanged();
                return this;
            }

            public Builder setSubsourceBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                b.checkByteStringIsUtf8(byteString);
                this.subsource_ = byteString;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public final Builder setUnknownFields(a1 a1Var) {
                return this;
            }

            public Builder setUserDescription(String str) {
                Objects.requireNonNull(str);
                this.userDescription_ = str;
                onChanged();
                return this;
            }

            public Builder setUserDescriptionBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                b.checkByteStringIsUtf8(byteString);
                this.userDescription_ = byteString;
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
                this.source_ = "";
                this.subsource_ = "";
                this.jiraIssueKey_ = "";
                this.userDescription_ = "";
                this.issueMain_ = "";
                this.issueSub_ = "";
                this.jiraStatus_ = "";
                this.deviceId_ = "";
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.e0.a, com.google.protobuf.d0.a
            public Feedback build() {
                Feedback buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) buildPartial);
            }

            @Override // com.google.protobuf.e0.a, com.google.protobuf.d0.a
            public Feedback buildPartial() {
                Feedback feedback = new Feedback(this);
                feedback.id_ = this.id_;
                feedback.createdAt_ = this.createdAt_;
                feedback.wwid_ = this.wwid_;
                feedback.source_ = this.source_;
                feedback.subsource_ = this.subsource_;
                feedback.jiraCreated_ = this.jiraCreated_;
                feedback.jiraIssueKey_ = this.jiraIssueKey_;
                feedback.userDescription_ = this.userDescription_;
                feedback.issueMain_ = this.issueMain_;
                feedback.issueSub_ = this.issueSub_;
                feedback.jiraStatus_ = this.jiraStatus_;
                feedback.deleted_ = this.deleted_;
                feedback.deviceId_ = this.deviceId_;
                onBuilt();
                return feedback;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.f0, com.google.protobuf.g0
            public Feedback getDefaultInstanceForType() {
                return Feedback.getDefaultInstance();
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
                this.id_ = 0;
                this.createdAt_ = 0L;
                this.wwid_ = "";
                this.source_ = "";
                this.subsource_ = "";
                this.jiraCreated_ = false;
                this.jiraIssueKey_ = "";
                this.userDescription_ = "";
                this.issueMain_ = "";
                this.issueSub_ = "";
                this.jiraStatus_ = "";
                this.deleted_ = false;
                this.deviceId_ = "";
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a, com.google.protobuf.b.a
            public Builder clone() {
                return (Builder) super.clone();
            }

            @Override // com.google.protobuf.a.AbstractC0170a, com.google.protobuf.d0.a
            public Builder mergeFrom(d0 d0Var) {
                if (d0Var instanceof Feedback) {
                    return mergeFrom((Feedback) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            public Builder mergeFrom(Feedback feedback) {
                if (feedback == Feedback.getDefaultInstance()) {
                    return this;
                }
                if (feedback.getId() != 0) {
                    setId(feedback.getId());
                }
                if (feedback.getCreatedAt() != 0) {
                    setCreatedAt(feedback.getCreatedAt());
                }
                if (!feedback.getWwid().isEmpty()) {
                    this.wwid_ = feedback.wwid_;
                    onChanged();
                }
                if (!feedback.getSource().isEmpty()) {
                    this.source_ = feedback.source_;
                    onChanged();
                }
                if (!feedback.getSubsource().isEmpty()) {
                    this.subsource_ = feedback.subsource_;
                    onChanged();
                }
                if (feedback.getJiraCreated()) {
                    setJiraCreated(feedback.getJiraCreated());
                }
                if (!feedback.getJiraIssueKey().isEmpty()) {
                    this.jiraIssueKey_ = feedback.jiraIssueKey_;
                    onChanged();
                }
                if (!feedback.getUserDescription().isEmpty()) {
                    this.userDescription_ = feedback.userDescription_;
                    onChanged();
                }
                if (!feedback.getIssueMain().isEmpty()) {
                    this.issueMain_ = feedback.issueMain_;
                    onChanged();
                }
                if (!feedback.getIssueSub().isEmpty()) {
                    this.issueSub_ = feedback.issueSub_;
                    onChanged();
                }
                if (!feedback.getJiraStatus().isEmpty()) {
                    this.jiraStatus_ = feedback.jiraStatus_;
                    onChanged();
                }
                if (feedback.getDeleted()) {
                    setDeleted(feedback.getDeleted());
                }
                if (!feedback.getDeviceId().isEmpty()) {
                    this.deviceId_ = feedback.deviceId_;
                    onChanged();
                }
                onChanged();
                return this;
            }

            private Builder(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.wwid_ = "";
                this.source_ = "";
                this.subsource_ = "";
                this.jiraIssueKey_ = "";
                this.userDescription_ = "";
                this.issueMain_ = "";
                this.issueSub_ = "";
                this.jiraStatus_ = "";
                this.deviceId_ = "";
                maybeForceBuilderInitialization();
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x0023  */
            @Override // com.google.protobuf.a.AbstractC0170a, com.google.protobuf.b.a, com.google.protobuf.e0.a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(i iVar, q qVar) throws IOException {
                Throwable th2;
                Feedback feedback = null;
                try {
                    try {
                        Feedback feedback2 = (Feedback) Feedback.PARSER.parsePartialFrom(iVar, qVar);
                        if (feedback2 != null) {
                            mergeFrom(feedback2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e10) {
                        feedback = (Feedback) e10.getUnfinishedMessage();
                        try {
                            throw e10.unwrapIOException();
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (feedback != null) {
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (feedback != null) {
                        mergeFrom(feedback);
                    }
                    throw th2;
                }
            }
        }

        public static Builder newBuilder(Feedback feedback) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(feedback);
        }

        public static Feedback parseFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, qVar);
        }

        private Feedback(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static Feedback parseDelimitedFrom(InputStream inputStream, q qVar) throws IOException {
            return (Feedback) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
        }

        public static Feedback parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
        public Feedback getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static Feedback parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder newBuilderForType() {
            return newBuilder();
        }

        private Feedback() {
            this.memoizedIsInitialized = (byte) -1;
            this.id_ = 0;
            this.createdAt_ = 0L;
            this.wwid_ = "";
            this.source_ = "";
            this.subsource_ = "";
            this.jiraCreated_ = false;
            this.jiraIssueKey_ = "";
            this.userDescription_ = "";
            this.issueMain_ = "";
            this.issueSub_ = "";
            this.jiraStatus_ = "";
            this.deleted_ = false;
            this.deviceId_ = "";
        }

        public static Feedback parseFrom(InputStream inputStream) throws IOException {
            return (Feedback) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.c cVar) {
            return new Builder(cVar);
        }

        public static Feedback parseFrom(InputStream inputStream, q qVar) throws IOException {
            return (Feedback) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
        }

        public static Feedback parseFrom(i iVar) throws IOException {
            return (Feedback) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
        }

        public static Feedback parseFrom(i iVar, q qVar) throws IOException {
            return (Feedback) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
        }

        private Feedback(i iVar, q qVar) throws InvalidProtocolBufferException {
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
                                case 50:
                                    this.source_ = iVar.E();
                                    continue;
                                case 58:
                                    this.subsource_ = iVar.E();
                                    continue;
                                case 72:
                                    this.jiraCreated_ = iVar.l();
                                    continue;
                                case 82:
                                    this.jiraIssueKey_ = iVar.E();
                                    continue;
                                case 88:
                                    this.id_ = iVar.t();
                                    continue;
                                case 96:
                                    this.createdAt_ = iVar.u();
                                    continue;
                                case 106:
                                    this.userDescription_ = iVar.E();
                                    continue;
                                case 114:
                                    this.issueMain_ = iVar.E();
                                    continue;
                                case 122:
                                    this.issueSub_ = iVar.E();
                                    continue;
                                case 130:
                                    this.jiraStatus_ = iVar.E();
                                    continue;
                                case 136:
                                    this.deleted_ = iVar.l();
                                    continue;
                                case 146:
                                    this.deviceId_ = iVar.E();
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
    public interface FeedbackOrBuilder extends g0 {
        /* synthetic */ List<String> findInitializationErrors();

        @Override // com.google.protobuf.g0
        /* synthetic */ Map<Descriptors.FieldDescriptor, Object> getAllFields();

        long getCreatedAt();

        @Override // com.google.protobuf.g0
        /* synthetic */ d0 getDefaultInstanceForType();

        @Override // com.google.protobuf.g0
        /* synthetic */ e0 getDefaultInstanceForType();

        boolean getDeleted();

        @Override // com.google.protobuf.g0
        /* synthetic */ Descriptors.b getDescriptorForType();

        String getDeviceId();

        ByteString getDeviceIdBytes();

        @Override // com.google.protobuf.g0
        /* synthetic */ Object getField(Descriptors.FieldDescriptor fieldDescriptor);

        int getId();

        /* synthetic */ String getInitializationErrorString();

        String getIssueMain();

        ByteString getIssueMainBytes();

        String getIssueSub();

        ByteString getIssueSubBytes();

        boolean getJiraCreated();

        String getJiraIssueKey();

        ByteString getJiraIssueKeyBytes();

        String getJiraStatus();

        ByteString getJiraStatusBytes();

        /* synthetic */ Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.h hVar);

        /* synthetic */ Object getRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i10);

        /* synthetic */ int getRepeatedFieldCount(Descriptors.FieldDescriptor fieldDescriptor);

        String getSource();

        ByteString getSourceBytes();

        String getSubsource();

        ByteString getSubsourceBytes();

        @Override // com.google.protobuf.g0
        /* synthetic */ a1 getUnknownFields();

        String getUserDescription();

        ByteString getUserDescriptionBytes();

        String getWwid();

        ByteString getWwidBytes();

        @Override // com.google.protobuf.g0
        /* synthetic */ boolean hasField(Descriptors.FieldDescriptor fieldDescriptor);

        /* synthetic */ boolean hasOneof(Descriptors.h hVar);

        @Override // com.google.protobuf.f0
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes2.dex */
    public static final class FeedbackRequest extends GeneratedMessageV3 implements FeedbackRequestOrBuilder {
        public static final int ATTACHMENTS_FIELD_NUMBER = 22;
        public static final int COMPANION_VERSION_FIELD_NUMBER = 21;
        public static final int CONTACT_FIELD_NUMBER = 8;
        public static final int DEVICE_ID_FIELD_NUMBER = 3;
        public static final int EXTRAS_FIELD_NUMBER = 7;
        public static final int FEEDBACK_CLASSIFICATION_FIELD_NUMBER = 6;
        public static final int FEEDBACK_CLASSIFICATION_TEXT_FIELD_NUMBER = 14;
        public static final int FEEDBACK_CONTENT_DETAIL_FIELD_NUMBER = 18;
        public static final int FEEDBACK_CONTENT_FIELD_NUMBER = 5;
        public static final int HAPPENED_AT_FIELD_NUMBER = 15;
        public static final int HOTWORD_EXTRA_FIELD_NUMBER = 19;
        public static final int IS_OVERSEAS_FIELD_NUMBER = 20;
        public static final int MIRROR_MODEL_FIELD_NUMBER = 16;
        public static final int MIRROR_OS_VERSION_FIELD_NUMBER = 17;
        public static final int PHONE_MODEL_FIELD_NUMBER = 9;
        public static final int PHONE_OS_VERSION_FIELD_NUMBER = 10;
        public static final int SOURCE_FIELD_NUMBER = 1;
        public static final int SUBSOURCE_FIELD_NUMBER = 2;
        public static final int WATCH_DEVICE_NAME_FIELD_NUMBER = 12;
        public static final int WATCH_MODEL_FIELD_NUMBER = 11;
        public static final int WATCH_OS_VERSION_FIELD_NUMBER = 13;
        public static final int WWID_FIELD_NUMBER = 4;
        private static final long serialVersionUID = 0;
        private c0<String, ByteString> attachments_;
        private int bitField0_;
        private volatile Object companionVersion_;
        private volatile Object contact_;
        private volatile Object deviceId_;
        private c0<String, String> extras_;
        private volatile Object feedbackClassificationText_;
        private volatile Object feedbackClassification_;
        private volatile Object feedbackContentDetail_;
        private volatile Object feedbackContent_;
        private long happenedAt_;
        private volatile Object hotwordExtra_;
        private boolean isOverseas_;
        private byte memoizedIsInitialized;
        private volatile Object mirrorModel_;
        private volatile Object mirrorOsVersion_;
        private volatile Object phoneModel_;
        private volatile Object phoneOsVersion_;
        private volatile Object source_;
        private volatile Object subsource_;
        private volatile Object watchDeviceName_;
        private volatile Object watchModel_;
        private volatile Object watchOsVersion_;
        private volatile Object wwid_;
        private static final FeedbackRequest DEFAULT_INSTANCE = new FeedbackRequest();
        private static final l0<FeedbackRequest> PARSER = new c<FeedbackRequest>() { // from class: com.mobvoi.companion.FeedbackProto.FeedbackRequest.1
            @Override // com.google.protobuf.l0
            public FeedbackRequest parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
                return new FeedbackRequest(iVar, qVar);
            }
        };

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes2.dex */
        public static final class AttachmentsDefaultEntryHolder {
            static final a0<String, ByteString> defaultEntry = a0.l(FeedbackProto.internal_static_feedbackhub_FeedbackRequest_AttachmentsEntry_descriptor, WireFormat.FieldType.STRING, "", WireFormat.FieldType.BYTES, ByteString.EMPTY);

            private AttachmentsDefaultEntryHolder() {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes2.dex */
        public static final class ExtrasDefaultEntryHolder {
            static final a0<String, String> defaultEntry;

            static {
                Descriptors.b bVar = FeedbackProto.internal_static_feedbackhub_FeedbackRequest_ExtrasEntry_descriptor;
                WireFormat.FieldType fieldType = WireFormat.FieldType.STRING;
                defaultEntry = a0.l(bVar, fieldType, "", fieldType, "");
            }

            private ExtrasDefaultEntryHolder() {
            }
        }

        public static FeedbackRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return FeedbackProto.internal_static_feedbackhub_FeedbackRequest_descriptor;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public c0<String, ByteString> internalGetAttachments() {
            c0<String, ByteString> c0Var = this.attachments_;
            return c0Var == null ? c0.h(AttachmentsDefaultEntryHolder.defaultEntry) : c0Var;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public c0<String, String> internalGetExtras() {
            c0<String, String> c0Var = this.extras_;
            return c0Var == null ? c0.h(ExtrasDefaultEntryHolder.defaultEntry) : c0Var;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static FeedbackRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (FeedbackRequest) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static FeedbackRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static l0<FeedbackRequest> parser() {
            return PARSER;
        }

        @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
        public boolean containsAttachments(String str) {
            Objects.requireNonNull(str);
            return internalGetAttachments().j().containsKey(str);
        }

        @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
        public boolean containsExtras(String str) {
            Objects.requireNonNull(str);
            return internalGetExtras().j().containsKey(str);
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof FeedbackRequest)) {
                return super.equals(obj);
            }
            FeedbackRequest feedbackRequest = (FeedbackRequest) obj;
            return (((((((((((((((((((((getSource().equals(feedbackRequest.getSource())) && getFeedbackContent().equals(feedbackRequest.getFeedbackContent())) && getFeedbackClassification().equals(feedbackRequest.getFeedbackClassification())) && internalGetAttachments().equals(feedbackRequest.internalGetAttachments())) && internalGetExtras().equals(feedbackRequest.internalGetExtras())) && getWwid().equals(feedbackRequest.getWwid())) && getSubsource().equals(feedbackRequest.getSubsource())) && (getHappenedAt() > feedbackRequest.getHappenedAt() ? 1 : (getHappenedAt() == feedbackRequest.getHappenedAt() ? 0 : -1)) == 0) && getDeviceId().equals(feedbackRequest.getDeviceId())) && getContact().equals(feedbackRequest.getContact())) && getPhoneModel().equals(feedbackRequest.getPhoneModel())) && getPhoneOsVersion().equals(feedbackRequest.getPhoneOsVersion())) && getCompanionVersion().equals(feedbackRequest.getCompanionVersion())) && getWatchModel().equals(feedbackRequest.getWatchModel())) && getWatchDeviceName().equals(feedbackRequest.getWatchDeviceName())) && getWatchOsVersion().equals(feedbackRequest.getWatchOsVersion())) && getFeedbackClassificationText().equals(feedbackRequest.getFeedbackClassificationText())) && getIsOverseas() == feedbackRequest.getIsOverseas()) && getMirrorModel().equals(feedbackRequest.getMirrorModel())) && getMirrorOsVersion().equals(feedbackRequest.getMirrorOsVersion())) && getFeedbackContentDetail().equals(feedbackRequest.getFeedbackContentDetail())) && getHotwordExtra().equals(feedbackRequest.getHotwordExtra());
        }

        @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
        @Deprecated
        public Map<String, ByteString> getAttachments() {
            return getAttachmentsMap();
        }

        @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
        public int getAttachmentsCount() {
            return internalGetAttachments().j().size();
        }

        @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
        public Map<String, ByteString> getAttachmentsMap() {
            return internalGetAttachments().j();
        }

        @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
        public ByteString getAttachmentsOrDefault(String str, ByteString byteString) {
            Objects.requireNonNull(str);
            Map<String, ByteString> j10 = internalGetAttachments().j();
            return j10.containsKey(str) ? j10.get(str) : byteString;
        }

        @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
        public ByteString getAttachmentsOrThrow(String str) {
            Objects.requireNonNull(str);
            Map<String, ByteString> j10 = internalGetAttachments().j();
            if (j10.containsKey(str)) {
                return j10.get(str);
            }
            throw new IllegalArgumentException();
        }

        @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
        public String getCompanionVersion() {
            Object obj = this.companionVersion_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.companionVersion_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
        public ByteString getCompanionVersionBytes() {
            Object obj = this.companionVersion_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.companionVersion_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
        public String getContact() {
            Object obj = this.contact_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.contact_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
        public ByteString getContactBytes() {
            Object obj = this.contact_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.contact_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
        public String getDeviceId() {
            Object obj = this.deviceId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.deviceId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
        public ByteString getDeviceIdBytes() {
            Object obj = this.deviceId_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.deviceId_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
        @Deprecated
        public Map<String, String> getExtras() {
            return getExtrasMap();
        }

        @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
        public int getExtrasCount() {
            return internalGetExtras().j().size();
        }

        @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
        public Map<String, String> getExtrasMap() {
            return internalGetExtras().j();
        }

        @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
        public String getExtrasOrDefault(String str, String str2) {
            Objects.requireNonNull(str);
            Map<String, String> j10 = internalGetExtras().j();
            return j10.containsKey(str) ? j10.get(str) : str2;
        }

        @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
        public String getExtrasOrThrow(String str) {
            Objects.requireNonNull(str);
            Map<String, String> j10 = internalGetExtras().j();
            if (j10.containsKey(str)) {
                return j10.get(str);
            }
            throw new IllegalArgumentException();
        }

        @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
        public String getFeedbackClassification() {
            Object obj = this.feedbackClassification_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.feedbackClassification_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
        public ByteString getFeedbackClassificationBytes() {
            Object obj = this.feedbackClassification_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.feedbackClassification_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
        public String getFeedbackClassificationText() {
            Object obj = this.feedbackClassificationText_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.feedbackClassificationText_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
        public ByteString getFeedbackClassificationTextBytes() {
            Object obj = this.feedbackClassificationText_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.feedbackClassificationText_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
        public String getFeedbackContent() {
            Object obj = this.feedbackContent_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.feedbackContent_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
        public ByteString getFeedbackContentBytes() {
            Object obj = this.feedbackContent_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.feedbackContent_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
        @Deprecated
        public String getFeedbackContentDetail() {
            Object obj = this.feedbackContentDetail_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.feedbackContentDetail_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
        @Deprecated
        public ByteString getFeedbackContentDetailBytes() {
            Object obj = this.feedbackContentDetail_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.feedbackContentDetail_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
        public long getHappenedAt() {
            return this.happenedAt_;
        }

        @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
        @Deprecated
        public String getHotwordExtra() {
            Object obj = this.hotwordExtra_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.hotwordExtra_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
        @Deprecated
        public ByteString getHotwordExtraBytes() {
            Object obj = this.hotwordExtra_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.hotwordExtra_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
        public boolean getIsOverseas() {
            return this.isOverseas_;
        }

        @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
        @Deprecated
        public String getMirrorModel() {
            Object obj = this.mirrorModel_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.mirrorModel_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
        @Deprecated
        public ByteString getMirrorModelBytes() {
            Object obj = this.mirrorModel_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.mirrorModel_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
        @Deprecated
        public String getMirrorOsVersion() {
            Object obj = this.mirrorOsVersion_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.mirrorOsVersion_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
        @Deprecated
        public ByteString getMirrorOsVersionBytes() {
            Object obj = this.mirrorOsVersion_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.mirrorOsVersion_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public l0<FeedbackRequest> getParserForType() {
            return PARSER;
        }

        @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
        public String getPhoneModel() {
            Object obj = this.phoneModel_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.phoneModel_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
        public ByteString getPhoneModelBytes() {
            Object obj = this.phoneModel_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.phoneModel_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
        public String getPhoneOsVersion() {
            Object obj = this.phoneOsVersion_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.phoneOsVersion_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
        public ByteString getPhoneOsVersionBytes() {
            Object obj = this.phoneOsVersion_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.phoneOsVersion_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
        public int getSerializedSize() {
            int i10 = this.memoizedSize;
            if (i10 != -1) {
                return i10;
            }
            int i11 = 0;
            if (!getSourceBytes().isEmpty()) {
                i11 = 0 + GeneratedMessageV3.computeStringSize(1, this.source_);
            }
            if (!getSubsourceBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(2, this.subsource_);
            }
            if (!getDeviceIdBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(3, this.deviceId_);
            }
            if (!getWwidBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(4, this.wwid_);
            }
            if (!getFeedbackContentBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(5, this.feedbackContent_);
            }
            if (!getFeedbackClassificationBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(6, this.feedbackClassification_);
            }
            for (Map.Entry<String, String> entry : internalGetExtras().j().entrySet()) {
                i11 += CodedOutputStream.E(7, ExtrasDefaultEntryHolder.defaultEntry.newBuilderForType().n(entry.getKey()).p(entry.getValue()).build());
            }
            if (!getContactBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(8, this.contact_);
            }
            if (!getPhoneModelBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(9, this.phoneModel_);
            }
            if (!getPhoneOsVersionBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(10, this.phoneOsVersion_);
            }
            if (!getWatchModelBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(11, this.watchModel_);
            }
            if (!getWatchDeviceNameBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(12, this.watchDeviceName_);
            }
            if (!getWatchOsVersionBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(13, this.watchOsVersion_);
            }
            if (!getFeedbackClassificationTextBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(14, this.feedbackClassificationText_);
            }
            long j10 = this.happenedAt_;
            if (j10 != 0) {
                i11 += CodedOutputStream.x(15, j10);
            }
            if (!getMirrorModelBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(16, this.mirrorModel_);
            }
            if (!getMirrorOsVersionBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(17, this.mirrorOsVersion_);
            }
            if (!getFeedbackContentDetailBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(18, this.feedbackContentDetail_);
            }
            if (!getHotwordExtraBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(19, this.hotwordExtra_);
            }
            boolean z10 = this.isOverseas_;
            if (z10) {
                i11 += CodedOutputStream.e(20, z10);
            }
            if (!getCompanionVersionBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(21, this.companionVersion_);
            }
            for (Map.Entry<String, ByteString> entry2 : internalGetAttachments().j().entrySet()) {
                i11 += CodedOutputStream.E(22, AttachmentsDefaultEntryHolder.defaultEntry.newBuilderForType().n(entry2.getKey()).p(entry2.getValue()).build());
            }
            this.memoizedSize = i11;
            return i11;
        }

        @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
        public String getSource() {
            Object obj = this.source_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.source_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
        public ByteString getSourceBytes() {
            Object obj = this.source_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.source_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
        public String getSubsource() {
            Object obj = this.subsource_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.subsource_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
        public ByteString getSubsourceBytes() {
            Object obj = this.subsource_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.subsource_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.g0
        public final a1 getUnknownFields() {
            return a1.c();
        }

        @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
        public String getWatchDeviceName() {
            Object obj = this.watchDeviceName_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.watchDeviceName_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
        public ByteString getWatchDeviceNameBytes() {
            Object obj = this.watchDeviceName_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.watchDeviceName_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
        public String getWatchModel() {
            Object obj = this.watchModel_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.watchModel_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
        public ByteString getWatchModelBytes() {
            Object obj = this.watchModel_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.watchModel_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
        public String getWatchOsVersion() {
            Object obj = this.watchOsVersion_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.watchOsVersion_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
        public ByteString getWatchOsVersionBytes() {
            Object obj = this.watchOsVersion_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.watchOsVersion_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
        public String getWwid() {
            Object obj = this.wwid_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.wwid_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
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
            int hashCode = ((((((((((((779 + getDescriptorForType().hashCode()) * 37) + 1) * 53) + getSource().hashCode()) * 37) + 5) * 53) + getFeedbackContent().hashCode()) * 37) + 6) * 53) + getFeedbackClassification().hashCode();
            if (!internalGetAttachments().j().isEmpty()) {
                hashCode = (((hashCode * 37) + 22) * 53) + internalGetAttachments().hashCode();
            }
            if (!internalGetExtras().j().isEmpty()) {
                hashCode = (((hashCode * 37) + 7) * 53) + internalGetExtras().hashCode();
            }
            int hashCode2 = (((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((hashCode * 37) + 4) * 53) + getWwid().hashCode()) * 37) + 2) * 53) + getSubsource().hashCode()) * 37) + 15) * 53) + u.h(getHappenedAt())) * 37) + 3) * 53) + getDeviceId().hashCode()) * 37) + 8) * 53) + getContact().hashCode()) * 37) + 9) * 53) + getPhoneModel().hashCode()) * 37) + 10) * 53) + getPhoneOsVersion().hashCode()) * 37) + 21) * 53) + getCompanionVersion().hashCode()) * 37) + 11) * 53) + getWatchModel().hashCode()) * 37) + 12) * 53) + getWatchDeviceName().hashCode()) * 37) + 13) * 53) + getWatchOsVersion().hashCode()) * 37) + 14) * 53) + getFeedbackClassificationText().hashCode()) * 37) + 20) * 53) + u.c(getIsOverseas())) * 37) + 16) * 53) + getMirrorModel().hashCode()) * 37) + 17) * 53) + getMirrorOsVersion().hashCode()) * 37) + 18) * 53) + getFeedbackContentDetail().hashCode()) * 37) + 19) * 53) + getHotwordExtra().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return FeedbackProto.internal_static_feedbackhub_FeedbackRequest_fieldAccessorTable.e(FeedbackRequest.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected c0 internalGetMapField(int i10) {
            if (i10 == 7) {
                return internalGetExtras();
            }
            if (i10 == 22) {
                return internalGetAttachments();
            }
            throw new RuntimeException("Invalid map field number: " + i10);
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
            if (!getSourceBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.source_);
            }
            if (!getSubsourceBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.subsource_);
            }
            if (!getDeviceIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 3, this.deviceId_);
            }
            if (!getWwidBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 4, this.wwid_);
            }
            if (!getFeedbackContentBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 5, this.feedbackContent_);
            }
            if (!getFeedbackClassificationBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 6, this.feedbackClassification_);
            }
            GeneratedMessageV3.serializeStringMapTo(codedOutputStream, internalGetExtras(), ExtrasDefaultEntryHolder.defaultEntry, 7);
            if (!getContactBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 8, this.contact_);
            }
            if (!getPhoneModelBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 9, this.phoneModel_);
            }
            if (!getPhoneOsVersionBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 10, this.phoneOsVersion_);
            }
            if (!getWatchModelBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 11, this.watchModel_);
            }
            if (!getWatchDeviceNameBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 12, this.watchDeviceName_);
            }
            if (!getWatchOsVersionBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 13, this.watchOsVersion_);
            }
            if (!getFeedbackClassificationTextBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 14, this.feedbackClassificationText_);
            }
            long j10 = this.happenedAt_;
            if (j10 != 0) {
                codedOutputStream.y0(15, j10);
            }
            if (!getMirrorModelBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 16, this.mirrorModel_);
            }
            if (!getMirrorOsVersionBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 17, this.mirrorOsVersion_);
            }
            if (!getFeedbackContentDetailBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 18, this.feedbackContentDetail_);
            }
            if (!getHotwordExtraBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 19, this.hotwordExtra_);
            }
            boolean z10 = this.isOverseas_;
            if (z10) {
                codedOutputStream.e0(20, z10);
            }
            if (!getCompanionVersionBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 21, this.companionVersion_);
            }
            GeneratedMessageV3.serializeStringMapTo(codedOutputStream, internalGetAttachments(), AttachmentsDefaultEntryHolder.defaultEntry, 22);
        }

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageV3.b<Builder> implements FeedbackRequestOrBuilder {
            private c0<String, ByteString> attachments_;
            private int bitField0_;
            private Object companionVersion_;
            private Object contact_;
            private Object deviceId_;
            private c0<String, String> extras_;
            private Object feedbackClassificationText_;
            private Object feedbackClassification_;
            private Object feedbackContentDetail_;
            private Object feedbackContent_;
            private long happenedAt_;
            private Object hotwordExtra_;
            private boolean isOverseas_;
            private Object mirrorModel_;
            private Object mirrorOsVersion_;
            private Object phoneModel_;
            private Object phoneOsVersion_;
            private Object source_;
            private Object subsource_;
            private Object watchDeviceName_;
            private Object watchModel_;
            private Object watchOsVersion_;
            private Object wwid_;

            public static final Descriptors.b getDescriptor() {
                return FeedbackProto.internal_static_feedbackhub_FeedbackRequest_descriptor;
            }

            private c0<String, ByteString> internalGetAttachments() {
                c0<String, ByteString> c0Var = this.attachments_;
                return c0Var == null ? c0.h(AttachmentsDefaultEntryHolder.defaultEntry) : c0Var;
            }

            private c0<String, String> internalGetExtras() {
                c0<String, String> c0Var = this.extras_;
                return c0Var == null ? c0.h(ExtrasDefaultEntryHolder.defaultEntry) : c0Var;
            }

            private c0<String, ByteString> internalGetMutableAttachments() {
                onChanged();
                if (this.attachments_ == null) {
                    this.attachments_ = c0.q(AttachmentsDefaultEntryHolder.defaultEntry);
                }
                if (!this.attachments_.n()) {
                    this.attachments_ = this.attachments_.g();
                }
                return this.attachments_;
            }

            private c0<String, String> internalGetMutableExtras() {
                onChanged();
                if (this.extras_ == null) {
                    this.extras_ = c0.q(ExtrasDefaultEntryHolder.defaultEntry);
                }
                if (!this.extras_.n()) {
                    this.extras_ = this.extras_.g();
                }
                return this.extras_;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            public Builder clearAttachments() {
                getMutableAttachments().clear();
                return this;
            }

            public Builder clearCompanionVersion() {
                this.companionVersion_ = FeedbackRequest.getDefaultInstance().getCompanionVersion();
                onChanged();
                return this;
            }

            public Builder clearContact() {
                this.contact_ = FeedbackRequest.getDefaultInstance().getContact();
                onChanged();
                return this;
            }

            public Builder clearDeviceId() {
                this.deviceId_ = FeedbackRequest.getDefaultInstance().getDeviceId();
                onChanged();
                return this;
            }

            public Builder clearExtras() {
                getMutableExtras().clear();
                return this;
            }

            public Builder clearFeedbackClassification() {
                this.feedbackClassification_ = FeedbackRequest.getDefaultInstance().getFeedbackClassification();
                onChanged();
                return this;
            }

            public Builder clearFeedbackClassificationText() {
                this.feedbackClassificationText_ = FeedbackRequest.getDefaultInstance().getFeedbackClassificationText();
                onChanged();
                return this;
            }

            public Builder clearFeedbackContent() {
                this.feedbackContent_ = FeedbackRequest.getDefaultInstance().getFeedbackContent();
                onChanged();
                return this;
            }

            @Deprecated
            public Builder clearFeedbackContentDetail() {
                this.feedbackContentDetail_ = FeedbackRequest.getDefaultInstance().getFeedbackContentDetail();
                onChanged();
                return this;
            }

            public Builder clearHappenedAt() {
                this.happenedAt_ = 0L;
                onChanged();
                return this;
            }

            @Deprecated
            public Builder clearHotwordExtra() {
                this.hotwordExtra_ = FeedbackRequest.getDefaultInstance().getHotwordExtra();
                onChanged();
                return this;
            }

            public Builder clearIsOverseas() {
                this.isOverseas_ = false;
                onChanged();
                return this;
            }

            @Deprecated
            public Builder clearMirrorModel() {
                this.mirrorModel_ = FeedbackRequest.getDefaultInstance().getMirrorModel();
                onChanged();
                return this;
            }

            @Deprecated
            public Builder clearMirrorOsVersion() {
                this.mirrorOsVersion_ = FeedbackRequest.getDefaultInstance().getMirrorOsVersion();
                onChanged();
                return this;
            }

            public Builder clearPhoneModel() {
                this.phoneModel_ = FeedbackRequest.getDefaultInstance().getPhoneModel();
                onChanged();
                return this;
            }

            public Builder clearPhoneOsVersion() {
                this.phoneOsVersion_ = FeedbackRequest.getDefaultInstance().getPhoneOsVersion();
                onChanged();
                return this;
            }

            public Builder clearSource() {
                this.source_ = FeedbackRequest.getDefaultInstance().getSource();
                onChanged();
                return this;
            }

            public Builder clearSubsource() {
                this.subsource_ = FeedbackRequest.getDefaultInstance().getSubsource();
                onChanged();
                return this;
            }

            public Builder clearWatchDeviceName() {
                this.watchDeviceName_ = FeedbackRequest.getDefaultInstance().getWatchDeviceName();
                onChanged();
                return this;
            }

            public Builder clearWatchModel() {
                this.watchModel_ = FeedbackRequest.getDefaultInstance().getWatchModel();
                onChanged();
                return this;
            }

            public Builder clearWatchOsVersion() {
                this.watchOsVersion_ = FeedbackRequest.getDefaultInstance().getWatchOsVersion();
                onChanged();
                return this;
            }

            public Builder clearWwid() {
                this.wwid_ = FeedbackRequest.getDefaultInstance().getWwid();
                onChanged();
                return this;
            }

            @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
            public boolean containsAttachments(String str) {
                Objects.requireNonNull(str);
                return internalGetAttachments().j().containsKey(str);
            }

            @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
            public boolean containsExtras(String str) {
                Objects.requireNonNull(str);
                return internalGetExtras().j().containsKey(str);
            }

            @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
            @Deprecated
            public Map<String, ByteString> getAttachments() {
                return getAttachmentsMap();
            }

            @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
            public int getAttachmentsCount() {
                return internalGetAttachments().j().size();
            }

            @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
            public Map<String, ByteString> getAttachmentsMap() {
                return internalGetAttachments().j();
            }

            @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
            public ByteString getAttachmentsOrDefault(String str, ByteString byteString) {
                Objects.requireNonNull(str);
                Map<String, ByteString> j10 = internalGetAttachments().j();
                return j10.containsKey(str) ? j10.get(str) : byteString;
            }

            @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
            public ByteString getAttachmentsOrThrow(String str) {
                Objects.requireNonNull(str);
                Map<String, ByteString> j10 = internalGetAttachments().j();
                if (j10.containsKey(str)) {
                    return j10.get(str);
                }
                throw new IllegalArgumentException();
            }

            @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
            public String getCompanionVersion() {
                Object obj = this.companionVersion_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.companionVersion_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
            public ByteString getCompanionVersionBytes() {
                Object obj = this.companionVersion_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.companionVersion_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
            public String getContact() {
                Object obj = this.contact_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.contact_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
            public ByteString getContactBytes() {
                Object obj = this.contact_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.contact_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a, com.google.protobuf.g0
            public Descriptors.b getDescriptorForType() {
                return FeedbackProto.internal_static_feedbackhub_FeedbackRequest_descriptor;
            }

            @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
            public String getDeviceId() {
                Object obj = this.deviceId_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.deviceId_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
            public ByteString getDeviceIdBytes() {
                Object obj = this.deviceId_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.deviceId_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
            @Deprecated
            public Map<String, String> getExtras() {
                return getExtrasMap();
            }

            @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
            public int getExtrasCount() {
                return internalGetExtras().j().size();
            }

            @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
            public Map<String, String> getExtrasMap() {
                return internalGetExtras().j();
            }

            @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
            public String getExtrasOrDefault(String str, String str2) {
                Objects.requireNonNull(str);
                Map<String, String> j10 = internalGetExtras().j();
                return j10.containsKey(str) ? j10.get(str) : str2;
            }

            @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
            public String getExtrasOrThrow(String str) {
                Objects.requireNonNull(str);
                Map<String, String> j10 = internalGetExtras().j();
                if (j10.containsKey(str)) {
                    return j10.get(str);
                }
                throw new IllegalArgumentException();
            }

            @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
            public String getFeedbackClassification() {
                Object obj = this.feedbackClassification_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.feedbackClassification_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
            public ByteString getFeedbackClassificationBytes() {
                Object obj = this.feedbackClassification_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.feedbackClassification_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
            public String getFeedbackClassificationText() {
                Object obj = this.feedbackClassificationText_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.feedbackClassificationText_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
            public ByteString getFeedbackClassificationTextBytes() {
                Object obj = this.feedbackClassificationText_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.feedbackClassificationText_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
            public String getFeedbackContent() {
                Object obj = this.feedbackContent_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.feedbackContent_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
            public ByteString getFeedbackContentBytes() {
                Object obj = this.feedbackContent_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.feedbackContent_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
            @Deprecated
            public String getFeedbackContentDetail() {
                Object obj = this.feedbackContentDetail_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.feedbackContentDetail_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
            @Deprecated
            public ByteString getFeedbackContentDetailBytes() {
                Object obj = this.feedbackContentDetail_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.feedbackContentDetail_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
            public long getHappenedAt() {
                return this.happenedAt_;
            }

            @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
            @Deprecated
            public String getHotwordExtra() {
                Object obj = this.hotwordExtra_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.hotwordExtra_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
            @Deprecated
            public ByteString getHotwordExtraBytes() {
                Object obj = this.hotwordExtra_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.hotwordExtra_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
            public boolean getIsOverseas() {
                return this.isOverseas_;
            }

            @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
            @Deprecated
            public String getMirrorModel() {
                Object obj = this.mirrorModel_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.mirrorModel_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
            @Deprecated
            public ByteString getMirrorModelBytes() {
                Object obj = this.mirrorModel_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.mirrorModel_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
            @Deprecated
            public String getMirrorOsVersion() {
                Object obj = this.mirrorOsVersion_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.mirrorOsVersion_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
            @Deprecated
            public ByteString getMirrorOsVersionBytes() {
                Object obj = this.mirrorOsVersion_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.mirrorOsVersion_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Deprecated
            public Map<String, ByteString> getMutableAttachments() {
                return internalGetMutableAttachments().m();
            }

            @Deprecated
            public Map<String, String> getMutableExtras() {
                return internalGetMutableExtras().m();
            }

            @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
            public String getPhoneModel() {
                Object obj = this.phoneModel_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.phoneModel_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
            public ByteString getPhoneModelBytes() {
                Object obj = this.phoneModel_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.phoneModel_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
            public String getPhoneOsVersion() {
                Object obj = this.phoneOsVersion_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.phoneOsVersion_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
            public ByteString getPhoneOsVersionBytes() {
                Object obj = this.phoneOsVersion_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.phoneOsVersion_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
            public String getSource() {
                Object obj = this.source_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.source_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
            public ByteString getSourceBytes() {
                Object obj = this.source_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.source_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
            public String getSubsource() {
                Object obj = this.subsource_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.subsource_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
            public ByteString getSubsourceBytes() {
                Object obj = this.subsource_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.subsource_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
            public String getWatchDeviceName() {
                Object obj = this.watchDeviceName_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.watchDeviceName_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
            public ByteString getWatchDeviceNameBytes() {
                Object obj = this.watchDeviceName_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.watchDeviceName_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
            public String getWatchModel() {
                Object obj = this.watchModel_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.watchModel_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
            public ByteString getWatchModelBytes() {
                Object obj = this.watchModel_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.watchModel_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
            public String getWatchOsVersion() {
                Object obj = this.watchOsVersion_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.watchOsVersion_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
            public ByteString getWatchOsVersionBytes() {
                Object obj = this.watchOsVersion_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.watchOsVersion_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
            public String getWwid() {
                Object obj = this.wwid_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.wwid_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.FeedbackProto.FeedbackRequestOrBuilder
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
                return FeedbackProto.internal_static_feedbackhub_FeedbackRequest_fieldAccessorTable.e(FeedbackRequest.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected c0 internalGetMapField(int i10) {
                if (i10 == 7) {
                    return internalGetExtras();
                }
                if (i10 == 22) {
                    return internalGetAttachments();
                }
                throw new RuntimeException("Invalid map field number: " + i10);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected c0 internalGetMutableMapField(int i10) {
                if (i10 == 7) {
                    return internalGetMutableExtras();
                }
                if (i10 == 22) {
                    return internalGetMutableAttachments();
                }
                throw new RuntimeException("Invalid map field number: " + i10);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.f0
            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a
            public final Builder mergeUnknownFields(a1 a1Var) {
                return this;
            }

            public Builder putAllAttachments(Map<String, ByteString> map) {
                getMutableAttachments().putAll(map);
                return this;
            }

            public Builder putAllExtras(Map<String, String> map) {
                getMutableExtras().putAll(map);
                return this;
            }

            public Builder putAttachments(String str, ByteString byteString) {
                Objects.requireNonNull(str);
                Objects.requireNonNull(byteString);
                getMutableAttachments().put(str, byteString);
                return this;
            }

            public Builder putExtras(String str, String str2) {
                Objects.requireNonNull(str);
                Objects.requireNonNull(str2);
                getMutableExtras().put(str, str2);
                return this;
            }

            public Builder removeAttachments(String str) {
                Objects.requireNonNull(str);
                getMutableAttachments().remove(str);
                return this;
            }

            public Builder removeExtras(String str) {
                Objects.requireNonNull(str);
                getMutableExtras().remove(str);
                return this;
            }

            public Builder setCompanionVersion(String str) {
                Objects.requireNonNull(str);
                this.companionVersion_ = str;
                onChanged();
                return this;
            }

            public Builder setCompanionVersionBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                b.checkByteStringIsUtf8(byteString);
                this.companionVersion_ = byteString;
                onChanged();
                return this;
            }

            public Builder setContact(String str) {
                Objects.requireNonNull(str);
                this.contact_ = str;
                onChanged();
                return this;
            }

            public Builder setContactBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                b.checkByteStringIsUtf8(byteString);
                this.contact_ = byteString;
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

            public Builder setFeedbackClassification(String str) {
                Objects.requireNonNull(str);
                this.feedbackClassification_ = str;
                onChanged();
                return this;
            }

            public Builder setFeedbackClassificationBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                b.checkByteStringIsUtf8(byteString);
                this.feedbackClassification_ = byteString;
                onChanged();
                return this;
            }

            public Builder setFeedbackClassificationText(String str) {
                Objects.requireNonNull(str);
                this.feedbackClassificationText_ = str;
                onChanged();
                return this;
            }

            public Builder setFeedbackClassificationTextBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                b.checkByteStringIsUtf8(byteString);
                this.feedbackClassificationText_ = byteString;
                onChanged();
                return this;
            }

            public Builder setFeedbackContent(String str) {
                Objects.requireNonNull(str);
                this.feedbackContent_ = str;
                onChanged();
                return this;
            }

            public Builder setFeedbackContentBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                b.checkByteStringIsUtf8(byteString);
                this.feedbackContent_ = byteString;
                onChanged();
                return this;
            }

            @Deprecated
            public Builder setFeedbackContentDetail(String str) {
                Objects.requireNonNull(str);
                this.feedbackContentDetail_ = str;
                onChanged();
                return this;
            }

            @Deprecated
            public Builder setFeedbackContentDetailBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                b.checkByteStringIsUtf8(byteString);
                this.feedbackContentDetail_ = byteString;
                onChanged();
                return this;
            }

            public Builder setHappenedAt(long j10) {
                this.happenedAt_ = j10;
                onChanged();
                return this;
            }

            @Deprecated
            public Builder setHotwordExtra(String str) {
                Objects.requireNonNull(str);
                this.hotwordExtra_ = str;
                onChanged();
                return this;
            }

            @Deprecated
            public Builder setHotwordExtraBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                b.checkByteStringIsUtf8(byteString);
                this.hotwordExtra_ = byteString;
                onChanged();
                return this;
            }

            public Builder setIsOverseas(boolean z10) {
                this.isOverseas_ = z10;
                onChanged();
                return this;
            }

            @Deprecated
            public Builder setMirrorModel(String str) {
                Objects.requireNonNull(str);
                this.mirrorModel_ = str;
                onChanged();
                return this;
            }

            @Deprecated
            public Builder setMirrorModelBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                b.checkByteStringIsUtf8(byteString);
                this.mirrorModel_ = byteString;
                onChanged();
                return this;
            }

            @Deprecated
            public Builder setMirrorOsVersion(String str) {
                Objects.requireNonNull(str);
                this.mirrorOsVersion_ = str;
                onChanged();
                return this;
            }

            @Deprecated
            public Builder setMirrorOsVersionBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                b.checkByteStringIsUtf8(byteString);
                this.mirrorOsVersion_ = byteString;
                onChanged();
                return this;
            }

            public Builder setPhoneModel(String str) {
                Objects.requireNonNull(str);
                this.phoneModel_ = str;
                onChanged();
                return this;
            }

            public Builder setPhoneModelBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                b.checkByteStringIsUtf8(byteString);
                this.phoneModel_ = byteString;
                onChanged();
                return this;
            }

            public Builder setPhoneOsVersion(String str) {
                Objects.requireNonNull(str);
                this.phoneOsVersion_ = str;
                onChanged();
                return this;
            }

            public Builder setPhoneOsVersionBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                b.checkByteStringIsUtf8(byteString);
                this.phoneOsVersion_ = byteString;
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

            public Builder setSubsource(String str) {
                Objects.requireNonNull(str);
                this.subsource_ = str;
                onChanged();
                return this;
            }

            public Builder setSubsourceBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                b.checkByteStringIsUtf8(byteString);
                this.subsource_ = byteString;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public final Builder setUnknownFields(a1 a1Var) {
                return this;
            }

            public Builder setWatchDeviceName(String str) {
                Objects.requireNonNull(str);
                this.watchDeviceName_ = str;
                onChanged();
                return this;
            }

            public Builder setWatchDeviceNameBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                b.checkByteStringIsUtf8(byteString);
                this.watchDeviceName_ = byteString;
                onChanged();
                return this;
            }

            public Builder setWatchModel(String str) {
                Objects.requireNonNull(str);
                this.watchModel_ = str;
                onChanged();
                return this;
            }

            public Builder setWatchModelBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                b.checkByteStringIsUtf8(byteString);
                this.watchModel_ = byteString;
                onChanged();
                return this;
            }

            public Builder setWatchOsVersion(String str) {
                Objects.requireNonNull(str);
                this.watchOsVersion_ = str;
                onChanged();
                return this;
            }

            public Builder setWatchOsVersionBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                b.checkByteStringIsUtf8(byteString);
                this.watchOsVersion_ = byteString;
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
                this.source_ = "";
                this.feedbackContent_ = "";
                this.feedbackClassification_ = "";
                this.wwid_ = "";
                this.subsource_ = "";
                this.deviceId_ = "";
                this.contact_ = "";
                this.phoneModel_ = "";
                this.phoneOsVersion_ = "";
                this.companionVersion_ = "";
                this.watchModel_ = "";
                this.watchDeviceName_ = "";
                this.watchOsVersion_ = "";
                this.feedbackClassificationText_ = "";
                this.mirrorModel_ = "";
                this.mirrorOsVersion_ = "";
                this.feedbackContentDetail_ = "";
                this.hotwordExtra_ = "";
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.e0.a, com.google.protobuf.d0.a
            public FeedbackRequest build() {
                FeedbackRequest buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) buildPartial);
            }

            @Override // com.google.protobuf.e0.a, com.google.protobuf.d0.a
            public FeedbackRequest buildPartial() {
                FeedbackRequest feedbackRequest = new FeedbackRequest(this);
                feedbackRequest.source_ = this.source_;
                feedbackRequest.feedbackContent_ = this.feedbackContent_;
                feedbackRequest.feedbackClassification_ = this.feedbackClassification_;
                feedbackRequest.attachments_ = internalGetAttachments();
                feedbackRequest.attachments_.o();
                feedbackRequest.extras_ = internalGetExtras();
                feedbackRequest.extras_.o();
                feedbackRequest.wwid_ = this.wwid_;
                feedbackRequest.subsource_ = this.subsource_;
                feedbackRequest.happenedAt_ = this.happenedAt_;
                feedbackRequest.deviceId_ = this.deviceId_;
                feedbackRequest.contact_ = this.contact_;
                feedbackRequest.phoneModel_ = this.phoneModel_;
                feedbackRequest.phoneOsVersion_ = this.phoneOsVersion_;
                feedbackRequest.companionVersion_ = this.companionVersion_;
                feedbackRequest.watchModel_ = this.watchModel_;
                feedbackRequest.watchDeviceName_ = this.watchDeviceName_;
                feedbackRequest.watchOsVersion_ = this.watchOsVersion_;
                feedbackRequest.feedbackClassificationText_ = this.feedbackClassificationText_;
                feedbackRequest.isOverseas_ = this.isOverseas_;
                feedbackRequest.mirrorModel_ = this.mirrorModel_;
                feedbackRequest.mirrorOsVersion_ = this.mirrorOsVersion_;
                feedbackRequest.feedbackContentDetail_ = this.feedbackContentDetail_;
                feedbackRequest.hotwordExtra_ = this.hotwordExtra_;
                feedbackRequest.bitField0_ = 0;
                onBuilt();
                return feedbackRequest;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.f0, com.google.protobuf.g0
            public FeedbackRequest getDefaultInstanceForType() {
                return FeedbackRequest.getDefaultInstance();
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
                this.source_ = "";
                this.feedbackContent_ = "";
                this.feedbackClassification_ = "";
                internalGetMutableAttachments().b();
                internalGetMutableExtras().b();
                this.wwid_ = "";
                this.subsource_ = "";
                this.happenedAt_ = 0L;
                this.deviceId_ = "";
                this.contact_ = "";
                this.phoneModel_ = "";
                this.phoneOsVersion_ = "";
                this.companionVersion_ = "";
                this.watchModel_ = "";
                this.watchDeviceName_ = "";
                this.watchOsVersion_ = "";
                this.feedbackClassificationText_ = "";
                this.isOverseas_ = false;
                this.mirrorModel_ = "";
                this.mirrorOsVersion_ = "";
                this.feedbackContentDetail_ = "";
                this.hotwordExtra_ = "";
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a, com.google.protobuf.b.a
            public Builder clone() {
                return (Builder) super.clone();
            }

            @Override // com.google.protobuf.a.AbstractC0170a, com.google.protobuf.d0.a
            public Builder mergeFrom(d0 d0Var) {
                if (d0Var instanceof FeedbackRequest) {
                    return mergeFrom((FeedbackRequest) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            public Builder mergeFrom(FeedbackRequest feedbackRequest) {
                if (feedbackRequest == FeedbackRequest.getDefaultInstance()) {
                    return this;
                }
                if (!feedbackRequest.getSource().isEmpty()) {
                    this.source_ = feedbackRequest.source_;
                    onChanged();
                }
                if (!feedbackRequest.getFeedbackContent().isEmpty()) {
                    this.feedbackContent_ = feedbackRequest.feedbackContent_;
                    onChanged();
                }
                if (!feedbackRequest.getFeedbackClassification().isEmpty()) {
                    this.feedbackClassification_ = feedbackRequest.feedbackClassification_;
                    onChanged();
                }
                internalGetMutableAttachments().p(feedbackRequest.internalGetAttachments());
                internalGetMutableExtras().p(feedbackRequest.internalGetExtras());
                if (!feedbackRequest.getWwid().isEmpty()) {
                    this.wwid_ = feedbackRequest.wwid_;
                    onChanged();
                }
                if (!feedbackRequest.getSubsource().isEmpty()) {
                    this.subsource_ = feedbackRequest.subsource_;
                    onChanged();
                }
                if (feedbackRequest.getHappenedAt() != 0) {
                    setHappenedAt(feedbackRequest.getHappenedAt());
                }
                if (!feedbackRequest.getDeviceId().isEmpty()) {
                    this.deviceId_ = feedbackRequest.deviceId_;
                    onChanged();
                }
                if (!feedbackRequest.getContact().isEmpty()) {
                    this.contact_ = feedbackRequest.contact_;
                    onChanged();
                }
                if (!feedbackRequest.getPhoneModel().isEmpty()) {
                    this.phoneModel_ = feedbackRequest.phoneModel_;
                    onChanged();
                }
                if (!feedbackRequest.getPhoneOsVersion().isEmpty()) {
                    this.phoneOsVersion_ = feedbackRequest.phoneOsVersion_;
                    onChanged();
                }
                if (!feedbackRequest.getCompanionVersion().isEmpty()) {
                    this.companionVersion_ = feedbackRequest.companionVersion_;
                    onChanged();
                }
                if (!feedbackRequest.getWatchModel().isEmpty()) {
                    this.watchModel_ = feedbackRequest.watchModel_;
                    onChanged();
                }
                if (!feedbackRequest.getWatchDeviceName().isEmpty()) {
                    this.watchDeviceName_ = feedbackRequest.watchDeviceName_;
                    onChanged();
                }
                if (!feedbackRequest.getWatchOsVersion().isEmpty()) {
                    this.watchOsVersion_ = feedbackRequest.watchOsVersion_;
                    onChanged();
                }
                if (!feedbackRequest.getFeedbackClassificationText().isEmpty()) {
                    this.feedbackClassificationText_ = feedbackRequest.feedbackClassificationText_;
                    onChanged();
                }
                if (feedbackRequest.getIsOverseas()) {
                    setIsOverseas(feedbackRequest.getIsOverseas());
                }
                if (!feedbackRequest.getMirrorModel().isEmpty()) {
                    this.mirrorModel_ = feedbackRequest.mirrorModel_;
                    onChanged();
                }
                if (!feedbackRequest.getMirrorOsVersion().isEmpty()) {
                    this.mirrorOsVersion_ = feedbackRequest.mirrorOsVersion_;
                    onChanged();
                }
                if (!feedbackRequest.getFeedbackContentDetail().isEmpty()) {
                    this.feedbackContentDetail_ = feedbackRequest.feedbackContentDetail_;
                    onChanged();
                }
                if (!feedbackRequest.getHotwordExtra().isEmpty()) {
                    this.hotwordExtra_ = feedbackRequest.hotwordExtra_;
                    onChanged();
                }
                onChanged();
                return this;
            }

            private Builder(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.source_ = "";
                this.feedbackContent_ = "";
                this.feedbackClassification_ = "";
                this.wwid_ = "";
                this.subsource_ = "";
                this.deviceId_ = "";
                this.contact_ = "";
                this.phoneModel_ = "";
                this.phoneOsVersion_ = "";
                this.companionVersion_ = "";
                this.watchModel_ = "";
                this.watchDeviceName_ = "";
                this.watchOsVersion_ = "";
                this.feedbackClassificationText_ = "";
                this.mirrorModel_ = "";
                this.mirrorOsVersion_ = "";
                this.feedbackContentDetail_ = "";
                this.hotwordExtra_ = "";
                maybeForceBuilderInitialization();
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x0023  */
            @Override // com.google.protobuf.a.AbstractC0170a, com.google.protobuf.b.a, com.google.protobuf.e0.a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(i iVar, q qVar) throws IOException {
                Throwable th2;
                FeedbackRequest feedbackRequest = null;
                try {
                    try {
                        FeedbackRequest feedbackRequest2 = (FeedbackRequest) FeedbackRequest.PARSER.parsePartialFrom(iVar, qVar);
                        if (feedbackRequest2 != null) {
                            mergeFrom(feedbackRequest2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e10) {
                        feedbackRequest = (FeedbackRequest) e10.getUnfinishedMessage();
                        try {
                            throw e10.unwrapIOException();
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (feedbackRequest != null) {
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (feedbackRequest != null) {
                        mergeFrom(feedbackRequest);
                    }
                    throw th2;
                }
            }
        }

        public static Builder newBuilder(FeedbackRequest feedbackRequest) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(feedbackRequest);
        }

        public static FeedbackRequest parseFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, qVar);
        }

        private FeedbackRequest(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static FeedbackRequest parseDelimitedFrom(InputStream inputStream, q qVar) throws IOException {
            return (FeedbackRequest) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
        }

        public static FeedbackRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
        public FeedbackRequest getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static FeedbackRequest parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder newBuilderForType() {
            return newBuilder();
        }

        private FeedbackRequest() {
            this.memoizedIsInitialized = (byte) -1;
            this.source_ = "";
            this.feedbackContent_ = "";
            this.feedbackClassification_ = "";
            this.wwid_ = "";
            this.subsource_ = "";
            this.happenedAt_ = 0L;
            this.deviceId_ = "";
            this.contact_ = "";
            this.phoneModel_ = "";
            this.phoneOsVersion_ = "";
            this.companionVersion_ = "";
            this.watchModel_ = "";
            this.watchDeviceName_ = "";
            this.watchOsVersion_ = "";
            this.feedbackClassificationText_ = "";
            this.isOverseas_ = false;
            this.mirrorModel_ = "";
            this.mirrorOsVersion_ = "";
            this.feedbackContentDetail_ = "";
            this.hotwordExtra_ = "";
        }

        public static FeedbackRequest parseFrom(InputStream inputStream) throws IOException {
            return (FeedbackRequest) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.c cVar) {
            return new Builder(cVar);
        }

        public static FeedbackRequest parseFrom(InputStream inputStream, q qVar) throws IOException {
            return (FeedbackRequest) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
        }

        public static FeedbackRequest parseFrom(i iVar) throws IOException {
            return (FeedbackRequest) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
        }

        public static FeedbackRequest parseFrom(i iVar, q qVar) throws IOException {
            return (FeedbackRequest) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
        }

        private FeedbackRequest(i iVar, q qVar) throws InvalidProtocolBufferException {
            this();
            boolean z10 = false;
            boolean z11 = false;
            while (!z10) {
                try {
                    try {
                        int F = iVar.F();
                        z10 = true;
                        switch (F) {
                            case 0:
                                break;
                            case 10:
                                this.source_ = iVar.E();
                                continue;
                            case 18:
                                this.subsource_ = iVar.E();
                                continue;
                            case 26:
                                this.deviceId_ = iVar.E();
                                continue;
                            case 34:
                                this.wwid_ = iVar.E();
                                continue;
                            case 42:
                                this.feedbackContent_ = iVar.E();
                                continue;
                            case 50:
                                this.feedbackClassification_ = iVar.E();
                                continue;
                            case 58:
                                if (!(z11 & true)) {
                                    this.extras_ = c0.q(ExtrasDefaultEntryHolder.defaultEntry);
                                    z11 |= true;
                                }
                                a0 a0Var = (a0) iVar.v(ExtrasDefaultEntryHolder.defaultEntry.getParserForType(), qVar);
                                this.extras_.m().put((String) a0Var.h(), (String) a0Var.i());
                                continue;
                            case 66:
                                this.contact_ = iVar.E();
                                continue;
                            case 74:
                                this.phoneModel_ = iVar.E();
                                continue;
                            case 82:
                                this.phoneOsVersion_ = iVar.E();
                                continue;
                            case 90:
                                this.watchModel_ = iVar.E();
                                continue;
                            case 98:
                                this.watchDeviceName_ = iVar.E();
                                continue;
                            case 106:
                                this.watchOsVersion_ = iVar.E();
                                continue;
                            case 114:
                                this.feedbackClassificationText_ = iVar.E();
                                continue;
                            case 120:
                                this.happenedAt_ = iVar.u();
                                continue;
                            case 130:
                                this.mirrorModel_ = iVar.E();
                                continue;
                            case 138:
                                this.mirrorOsVersion_ = iVar.E();
                                continue;
                            case 146:
                                this.feedbackContentDetail_ = iVar.E();
                                continue;
                            case 154:
                                this.hotwordExtra_ = iVar.E();
                                continue;
                            case 160:
                                this.isOverseas_ = iVar.l();
                                continue;
                            case 170:
                                this.companionVersion_ = iVar.E();
                                continue;
                            case 178:
                                if (!(z11 & true)) {
                                    this.attachments_ = c0.q(AttachmentsDefaultEntryHolder.defaultEntry);
                                    z11 |= true;
                                }
                                a0 a0Var2 = (a0) iVar.v(AttachmentsDefaultEntryHolder.defaultEntry.getParserForType(), qVar);
                                this.attachments_.m().put((String) a0Var2.h(), (ByteString) a0Var2.i());
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
    public interface FeedbackRequestOrBuilder extends g0 {
        boolean containsAttachments(String str);

        boolean containsExtras(String str);

        /* synthetic */ List<String> findInitializationErrors();

        @Override // com.google.protobuf.g0
        /* synthetic */ Map<Descriptors.FieldDescriptor, Object> getAllFields();

        @Deprecated
        Map<String, ByteString> getAttachments();

        int getAttachmentsCount();

        Map<String, ByteString> getAttachmentsMap();

        ByteString getAttachmentsOrDefault(String str, ByteString byteString);

        ByteString getAttachmentsOrThrow(String str);

        String getCompanionVersion();

        ByteString getCompanionVersionBytes();

        String getContact();

        ByteString getContactBytes();

        @Override // com.google.protobuf.g0
        /* synthetic */ d0 getDefaultInstanceForType();

        @Override // com.google.protobuf.g0
        /* synthetic */ e0 getDefaultInstanceForType();

        @Override // com.google.protobuf.g0
        /* synthetic */ Descriptors.b getDescriptorForType();

        String getDeviceId();

        ByteString getDeviceIdBytes();

        @Deprecated
        Map<String, String> getExtras();

        int getExtrasCount();

        Map<String, String> getExtrasMap();

        String getExtrasOrDefault(String str, String str2);

        String getExtrasOrThrow(String str);

        String getFeedbackClassification();

        ByteString getFeedbackClassificationBytes();

        String getFeedbackClassificationText();

        ByteString getFeedbackClassificationTextBytes();

        String getFeedbackContent();

        ByteString getFeedbackContentBytes();

        @Deprecated
        String getFeedbackContentDetail();

        @Deprecated
        ByteString getFeedbackContentDetailBytes();

        @Override // com.google.protobuf.g0
        /* synthetic */ Object getField(Descriptors.FieldDescriptor fieldDescriptor);

        long getHappenedAt();

        @Deprecated
        String getHotwordExtra();

        @Deprecated
        ByteString getHotwordExtraBytes();

        /* synthetic */ String getInitializationErrorString();

        boolean getIsOverseas();

        @Deprecated
        String getMirrorModel();

        @Deprecated
        ByteString getMirrorModelBytes();

        @Deprecated
        String getMirrorOsVersion();

        @Deprecated
        ByteString getMirrorOsVersionBytes();

        /* synthetic */ Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.h hVar);

        String getPhoneModel();

        ByteString getPhoneModelBytes();

        String getPhoneOsVersion();

        ByteString getPhoneOsVersionBytes();

        /* synthetic */ Object getRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i10);

        /* synthetic */ int getRepeatedFieldCount(Descriptors.FieldDescriptor fieldDescriptor);

        String getSource();

        ByteString getSourceBytes();

        String getSubsource();

        ByteString getSubsourceBytes();

        @Override // com.google.protobuf.g0
        /* synthetic */ a1 getUnknownFields();

        String getWatchDeviceName();

        ByteString getWatchDeviceNameBytes();

        String getWatchModel();

        ByteString getWatchModelBytes();

        String getWatchOsVersion();

        ByteString getWatchOsVersionBytes();

        String getWwid();

        ByteString getWwidBytes();

        @Override // com.google.protobuf.g0
        /* synthetic */ boolean hasField(Descriptors.FieldDescriptor fieldDescriptor);

        /* synthetic */ boolean hasOneof(Descriptors.h hVar);

        @Override // com.google.protobuf.f0
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes2.dex */
    public static final class Feedbacks extends GeneratedMessageV3 implements FeedbacksOrBuilder {
        public static final int DATA_FIELD_NUMBER = 1;
        private static final Feedbacks DEFAULT_INSTANCE = new Feedbacks();
        private static final l0<Feedbacks> PARSER = new c<Feedbacks>() { // from class: com.mobvoi.companion.FeedbackProto.Feedbacks.1
            @Override // com.google.protobuf.l0
            public Feedbacks parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
                return new Feedbacks(iVar, qVar);
            }
        };
        private static final long serialVersionUID = 0;
        private List<Feedback> data_;
        private byte memoizedIsInitialized;

        public static Feedbacks getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return FeedbackProto.internal_static_feedbackhub_Feedbacks_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Feedbacks parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Feedbacks) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static Feedbacks parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static l0<Feedbacks> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Feedbacks)) {
                return super.equals(obj);
            }
            return getDataList().equals(((Feedbacks) obj).getDataList());
        }

        @Override // com.mobvoi.companion.FeedbackProto.FeedbacksOrBuilder
        public Feedback getData(int i10) {
            return this.data_.get(i10);
        }

        @Override // com.mobvoi.companion.FeedbackProto.FeedbacksOrBuilder
        public int getDataCount() {
            return this.data_.size();
        }

        @Override // com.mobvoi.companion.FeedbackProto.FeedbacksOrBuilder
        public List<Feedback> getDataList() {
            return this.data_;
        }

        @Override // com.mobvoi.companion.FeedbackProto.FeedbacksOrBuilder
        public FeedbackOrBuilder getDataOrBuilder(int i10) {
            return this.data_.get(i10);
        }

        @Override // com.mobvoi.companion.FeedbackProto.FeedbacksOrBuilder
        public List<? extends FeedbackOrBuilder> getDataOrBuilderList() {
            return this.data_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public l0<Feedbacks> getParserForType() {
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
            return FeedbackProto.internal_static_feedbackhub_Feedbacks_fieldAccessorTable.e(Feedbacks.class, Builder.class);
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
        public static final class Builder extends GeneratedMessageV3.b<Builder> implements FeedbacksOrBuilder {
            private int bitField0_;
            private o0<Feedback, Feedback.Builder, FeedbackOrBuilder> dataBuilder_;
            private List<Feedback> data_;

            private void ensureDataIsMutable() {
                if ((this.bitField0_ & 1) != 1) {
                    this.data_ = new ArrayList(this.data_);
                    this.bitField0_ |= 1;
                }
            }

            private o0<Feedback, Feedback.Builder, FeedbackOrBuilder> getDataFieldBuilder() {
                if (this.dataBuilder_ == null) {
                    List<Feedback> list = this.data_;
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
                return FeedbackProto.internal_static_feedbackhub_Feedbacks_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                    getDataFieldBuilder();
                }
            }

            public Builder addAllData(Iterable<? extends Feedback> iterable) {
                o0<Feedback, Feedback.Builder, FeedbackOrBuilder> o0Var = this.dataBuilder_;
                if (o0Var == null) {
                    ensureDataIsMutable();
                    b.a.addAll(iterable, this.data_);
                    onChanged();
                } else {
                    o0Var.b(iterable);
                }
                return this;
            }

            public Builder addData(Feedback feedback) {
                o0<Feedback, Feedback.Builder, FeedbackOrBuilder> o0Var = this.dataBuilder_;
                if (o0Var == null) {
                    Objects.requireNonNull(feedback);
                    ensureDataIsMutable();
                    this.data_.add(feedback);
                    onChanged();
                } else {
                    o0Var.f(feedback);
                }
                return this;
            }

            public Feedback.Builder addDataBuilder() {
                return getDataFieldBuilder().d(Feedback.getDefaultInstance());
            }

            public Builder clearData() {
                o0<Feedback, Feedback.Builder, FeedbackOrBuilder> o0Var = this.dataBuilder_;
                if (o0Var == null) {
                    this.data_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    o0Var.h();
                }
                return this;
            }

            @Override // com.mobvoi.companion.FeedbackProto.FeedbacksOrBuilder
            public Feedback getData(int i10) {
                o0<Feedback, Feedback.Builder, FeedbackOrBuilder> o0Var = this.dataBuilder_;
                if (o0Var == null) {
                    return this.data_.get(i10);
                }
                return o0Var.o(i10);
            }

            public Feedback.Builder getDataBuilder(int i10) {
                return getDataFieldBuilder().l(i10);
            }

            public List<Feedback.Builder> getDataBuilderList() {
                return getDataFieldBuilder().m();
            }

            @Override // com.mobvoi.companion.FeedbackProto.FeedbacksOrBuilder
            public int getDataCount() {
                o0<Feedback, Feedback.Builder, FeedbackOrBuilder> o0Var = this.dataBuilder_;
                if (o0Var == null) {
                    return this.data_.size();
                }
                return o0Var.n();
            }

            @Override // com.mobvoi.companion.FeedbackProto.FeedbacksOrBuilder
            public List<Feedback> getDataList() {
                o0<Feedback, Feedback.Builder, FeedbackOrBuilder> o0Var = this.dataBuilder_;
                if (o0Var == null) {
                    return Collections.unmodifiableList(this.data_);
                }
                return o0Var.q();
            }

            @Override // com.mobvoi.companion.FeedbackProto.FeedbacksOrBuilder
            public FeedbackOrBuilder getDataOrBuilder(int i10) {
                o0<Feedback, Feedback.Builder, FeedbackOrBuilder> o0Var = this.dataBuilder_;
                if (o0Var == null) {
                    return this.data_.get(i10);
                }
                return o0Var.r(i10);
            }

            @Override // com.mobvoi.companion.FeedbackProto.FeedbacksOrBuilder
            public List<? extends FeedbackOrBuilder> getDataOrBuilderList() {
                o0<Feedback, Feedback.Builder, FeedbackOrBuilder> o0Var = this.dataBuilder_;
                if (o0Var != null) {
                    return o0Var.s();
                }
                return Collections.unmodifiableList(this.data_);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a, com.google.protobuf.g0
            public Descriptors.b getDescriptorForType() {
                return FeedbackProto.internal_static_feedbackhub_Feedbacks_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return FeedbackProto.internal_static_feedbackhub_Feedbacks_fieldAccessorTable.e(Feedbacks.class, Builder.class);
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
                o0<Feedback, Feedback.Builder, FeedbackOrBuilder> o0Var = this.dataBuilder_;
                if (o0Var == null) {
                    ensureDataIsMutable();
                    this.data_.remove(i10);
                    onChanged();
                } else {
                    o0Var.w(i10);
                }
                return this;
            }

            public Builder setData(int i10, Feedback feedback) {
                o0<Feedback, Feedback.Builder, FeedbackOrBuilder> o0Var = this.dataBuilder_;
                if (o0Var == null) {
                    Objects.requireNonNull(feedback);
                    ensureDataIsMutable();
                    this.data_.set(i10, feedback);
                    onChanged();
                } else {
                    o0Var.x(i10, feedback);
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
            public Feedbacks build() {
                Feedbacks buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) buildPartial);
            }

            @Override // com.google.protobuf.e0.a, com.google.protobuf.d0.a
            public Feedbacks buildPartial() {
                Feedbacks feedbacks = new Feedbacks(this);
                int i10 = this.bitField0_;
                o0<Feedback, Feedback.Builder, FeedbackOrBuilder> o0Var = this.dataBuilder_;
                if (o0Var == null) {
                    if ((i10 & 1) == 1) {
                        this.data_ = Collections.unmodifiableList(this.data_);
                        this.bitField0_ &= -2;
                    }
                    feedbacks.data_ = this.data_;
                } else {
                    feedbacks.data_ = o0Var.g();
                }
                onBuilt();
                return feedbacks;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.f0, com.google.protobuf.g0
            public Feedbacks getDefaultInstanceForType() {
                return Feedbacks.getDefaultInstance();
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

            public Feedback.Builder addDataBuilder(int i10) {
                return getDataFieldBuilder().c(i10, Feedback.getDefaultInstance());
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a
            public Builder clearOneof(Descriptors.h hVar) {
                return (Builder) super.clearOneof(hVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a
            public Builder clear() {
                super.clear();
                o0<Feedback, Feedback.Builder, FeedbackOrBuilder> o0Var = this.dataBuilder_;
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

            public Builder addData(int i10, Feedback feedback) {
                o0<Feedback, Feedback.Builder, FeedbackOrBuilder> o0Var = this.dataBuilder_;
                if (o0Var == null) {
                    Objects.requireNonNull(feedback);
                    ensureDataIsMutable();
                    this.data_.add(i10, feedback);
                    onChanged();
                } else {
                    o0Var.e(i10, feedback);
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a, com.google.protobuf.b.a
            public Builder clone() {
                return (Builder) super.clone();
            }

            @Override // com.google.protobuf.a.AbstractC0170a, com.google.protobuf.d0.a
            public Builder mergeFrom(d0 d0Var) {
                if (d0Var instanceof Feedbacks) {
                    return mergeFrom((Feedbacks) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            public Builder setData(int i10, Feedback.Builder builder) {
                o0<Feedback, Feedback.Builder, FeedbackOrBuilder> o0Var = this.dataBuilder_;
                if (o0Var == null) {
                    ensureDataIsMutable();
                    this.data_.set(i10, builder.build());
                    onChanged();
                } else {
                    o0Var.x(i10, builder.build());
                }
                return this;
            }

            public Builder mergeFrom(Feedbacks feedbacks) {
                if (feedbacks == Feedbacks.getDefaultInstance()) {
                    return this;
                }
                if (this.dataBuilder_ == null) {
                    if (!feedbacks.data_.isEmpty()) {
                        if (this.data_.isEmpty()) {
                            this.data_ = feedbacks.data_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureDataIsMutable();
                            this.data_.addAll(feedbacks.data_);
                        }
                        onChanged();
                    }
                } else if (!feedbacks.data_.isEmpty()) {
                    if (this.dataBuilder_.u()) {
                        this.dataBuilder_.i();
                        o0<Feedback, Feedback.Builder, FeedbackOrBuilder> o0Var = null;
                        this.dataBuilder_ = null;
                        this.data_ = feedbacks.data_;
                        this.bitField0_ &= -2;
                        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                            o0Var = getDataFieldBuilder();
                        }
                        this.dataBuilder_ = o0Var;
                    } else {
                        this.dataBuilder_.b(feedbacks.data_);
                    }
                }
                onChanged();
                return this;
            }

            public Builder addData(Feedback.Builder builder) {
                o0<Feedback, Feedback.Builder, FeedbackOrBuilder> o0Var = this.dataBuilder_;
                if (o0Var == null) {
                    ensureDataIsMutable();
                    this.data_.add(builder.build());
                    onChanged();
                } else {
                    o0Var.f(builder.build());
                }
                return this;
            }

            public Builder addData(int i10, Feedback.Builder builder) {
                o0<Feedback, Feedback.Builder, FeedbackOrBuilder> o0Var = this.dataBuilder_;
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
                Feedbacks feedbacks = null;
                try {
                    try {
                        Feedbacks feedbacks2 = (Feedbacks) Feedbacks.PARSER.parsePartialFrom(iVar, qVar);
                        if (feedbacks2 != null) {
                            mergeFrom(feedbacks2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e10) {
                        feedbacks = (Feedbacks) e10.getUnfinishedMessage();
                        try {
                            throw e10.unwrapIOException();
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (feedbacks != null) {
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (feedbacks != null) {
                        mergeFrom(feedbacks);
                    }
                    throw th2;
                }
            }
        }

        public static Builder newBuilder(Feedbacks feedbacks) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(feedbacks);
        }

        public static Feedbacks parseFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, qVar);
        }

        private Feedbacks(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static Feedbacks parseDelimitedFrom(InputStream inputStream, q qVar) throws IOException {
            return (Feedbacks) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
        }

        public static Feedbacks parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
        public Feedbacks getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static Feedbacks parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder newBuilderForType() {
            return newBuilder();
        }

        private Feedbacks() {
            this.memoizedIsInitialized = (byte) -1;
            this.data_ = Collections.emptyList();
        }

        public static Feedbacks parseFrom(InputStream inputStream) throws IOException {
            return (Feedbacks) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.c cVar) {
            return new Builder(cVar);
        }

        public static Feedbacks parseFrom(InputStream inputStream, q qVar) throws IOException {
            return (Feedbacks) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
        }

        private Feedbacks(i iVar, q qVar) throws InvalidProtocolBufferException {
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
                                this.data_.add((Feedback) iVar.v(Feedback.parser(), qVar));
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

        public static Feedbacks parseFrom(i iVar) throws IOException {
            return (Feedbacks) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
        }

        public static Feedbacks parseFrom(i iVar, q qVar) throws IOException {
            return (Feedbacks) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
        }
    }

    /* loaded from: classes2.dex */
    public interface FeedbacksOrBuilder extends g0 {
        /* synthetic */ List<String> findInitializationErrors();

        @Override // com.google.protobuf.g0
        /* synthetic */ Map<Descriptors.FieldDescriptor, Object> getAllFields();

        Feedback getData(int i10);

        int getDataCount();

        List<Feedback> getDataList();

        FeedbackOrBuilder getDataOrBuilder(int i10);

        List<? extends FeedbackOrBuilder> getDataOrBuilderList();

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
    public static final class FilesAndInfo extends GeneratedMessageV3 implements FilesAndInfoOrBuilder {
        public static final int FILES_FIELD_NUMBER = 1;
        public static final int INFO_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private c0<String, ByteString> files_;
        private c0<String, String> info_;
        private byte memoizedIsInitialized;
        private static final FilesAndInfo DEFAULT_INSTANCE = new FilesAndInfo();
        private static final l0<FilesAndInfo> PARSER = new c<FilesAndInfo>() { // from class: com.mobvoi.companion.FeedbackProto.FilesAndInfo.1
            @Override // com.google.protobuf.l0
            public FilesAndInfo parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
                return new FilesAndInfo(iVar, qVar);
            }
        };

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes2.dex */
        public static final class FilesDefaultEntryHolder {
            static final a0<String, ByteString> defaultEntry = a0.l(FeedbackProto.internal_static_feedbackhub_FilesAndInfo_FilesEntry_descriptor, WireFormat.FieldType.STRING, "", WireFormat.FieldType.BYTES, ByteString.EMPTY);

            private FilesDefaultEntryHolder() {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes2.dex */
        public static final class InfoDefaultEntryHolder {
            static final a0<String, String> defaultEntry;

            static {
                Descriptors.b bVar = FeedbackProto.internal_static_feedbackhub_FilesAndInfo_InfoEntry_descriptor;
                WireFormat.FieldType fieldType = WireFormat.FieldType.STRING;
                defaultEntry = a0.l(bVar, fieldType, "", fieldType, "");
            }

            private InfoDefaultEntryHolder() {
            }
        }

        public static FilesAndInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return FeedbackProto.internal_static_feedbackhub_FilesAndInfo_descriptor;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public c0<String, ByteString> internalGetFiles() {
            c0<String, ByteString> c0Var = this.files_;
            return c0Var == null ? c0.h(FilesDefaultEntryHolder.defaultEntry) : c0Var;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public c0<String, String> internalGetInfo() {
            c0<String, String> c0Var = this.info_;
            return c0Var == null ? c0.h(InfoDefaultEntryHolder.defaultEntry) : c0Var;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static FilesAndInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (FilesAndInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static FilesAndInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static l0<FilesAndInfo> parser() {
            return PARSER;
        }

        @Override // com.mobvoi.companion.FeedbackProto.FilesAndInfoOrBuilder
        public boolean containsFiles(String str) {
            Objects.requireNonNull(str);
            return internalGetFiles().j().containsKey(str);
        }

        @Override // com.mobvoi.companion.FeedbackProto.FilesAndInfoOrBuilder
        public boolean containsInfo(String str) {
            Objects.requireNonNull(str);
            return internalGetInfo().j().containsKey(str);
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof FilesAndInfo)) {
                return super.equals(obj);
            }
            FilesAndInfo filesAndInfo = (FilesAndInfo) obj;
            return (internalGetFiles().equals(filesAndInfo.internalGetFiles())) && internalGetInfo().equals(filesAndInfo.internalGetInfo());
        }

        @Override // com.mobvoi.companion.FeedbackProto.FilesAndInfoOrBuilder
        @Deprecated
        public Map<String, ByteString> getFiles() {
            return getFilesMap();
        }

        @Override // com.mobvoi.companion.FeedbackProto.FilesAndInfoOrBuilder
        public int getFilesCount() {
            return internalGetFiles().j().size();
        }

        @Override // com.mobvoi.companion.FeedbackProto.FilesAndInfoOrBuilder
        public Map<String, ByteString> getFilesMap() {
            return internalGetFiles().j();
        }

        @Override // com.mobvoi.companion.FeedbackProto.FilesAndInfoOrBuilder
        public ByteString getFilesOrDefault(String str, ByteString byteString) {
            Objects.requireNonNull(str);
            Map<String, ByteString> j10 = internalGetFiles().j();
            return j10.containsKey(str) ? j10.get(str) : byteString;
        }

        @Override // com.mobvoi.companion.FeedbackProto.FilesAndInfoOrBuilder
        public ByteString getFilesOrThrow(String str) {
            Objects.requireNonNull(str);
            Map<String, ByteString> j10 = internalGetFiles().j();
            if (j10.containsKey(str)) {
                return j10.get(str);
            }
            throw new IllegalArgumentException();
        }

        @Override // com.mobvoi.companion.FeedbackProto.FilesAndInfoOrBuilder
        @Deprecated
        public Map<String, String> getInfo() {
            return getInfoMap();
        }

        @Override // com.mobvoi.companion.FeedbackProto.FilesAndInfoOrBuilder
        public int getInfoCount() {
            return internalGetInfo().j().size();
        }

        @Override // com.mobvoi.companion.FeedbackProto.FilesAndInfoOrBuilder
        public Map<String, String> getInfoMap() {
            return internalGetInfo().j();
        }

        @Override // com.mobvoi.companion.FeedbackProto.FilesAndInfoOrBuilder
        public String getInfoOrDefault(String str, String str2) {
            Objects.requireNonNull(str);
            Map<String, String> j10 = internalGetInfo().j();
            return j10.containsKey(str) ? j10.get(str) : str2;
        }

        @Override // com.mobvoi.companion.FeedbackProto.FilesAndInfoOrBuilder
        public String getInfoOrThrow(String str) {
            Objects.requireNonNull(str);
            Map<String, String> j10 = internalGetInfo().j();
            if (j10.containsKey(str)) {
                return j10.get(str);
            }
            throw new IllegalArgumentException();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public l0<FilesAndInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
        public int getSerializedSize() {
            int i10 = this.memoizedSize;
            if (i10 != -1) {
                return i10;
            }
            int i11 = 0;
            for (Map.Entry<String, ByteString> entry : internalGetFiles().j().entrySet()) {
                i11 += CodedOutputStream.E(1, FilesDefaultEntryHolder.defaultEntry.newBuilderForType().n(entry.getKey()).p(entry.getValue()).build());
            }
            for (Map.Entry<String, String> entry2 : internalGetInfo().j().entrySet()) {
                i11 += CodedOutputStream.E(2, InfoDefaultEntryHolder.defaultEntry.newBuilderForType().n(entry2.getKey()).p(entry2.getValue()).build());
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
            if (!internalGetFiles().j().isEmpty()) {
                hashCode = (((hashCode * 37) + 1) * 53) + internalGetFiles().hashCode();
            }
            if (!internalGetInfo().j().isEmpty()) {
                hashCode = (((hashCode * 37) + 2) * 53) + internalGetInfo().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return FeedbackProto.internal_static_feedbackhub_FilesAndInfo_fieldAccessorTable.e(FilesAndInfo.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected c0 internalGetMapField(int i10) {
            if (i10 == 1) {
                return internalGetFiles();
            }
            if (i10 == 2) {
                return internalGetInfo();
            }
            throw new RuntimeException("Invalid map field number: " + i10);
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
            GeneratedMessageV3.serializeStringMapTo(codedOutputStream, internalGetFiles(), FilesDefaultEntryHolder.defaultEntry, 1);
            GeneratedMessageV3.serializeStringMapTo(codedOutputStream, internalGetInfo(), InfoDefaultEntryHolder.defaultEntry, 2);
        }

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageV3.b<Builder> implements FilesAndInfoOrBuilder {
            private int bitField0_;
            private c0<String, ByteString> files_;
            private c0<String, String> info_;

            public static final Descriptors.b getDescriptor() {
                return FeedbackProto.internal_static_feedbackhub_FilesAndInfo_descriptor;
            }

            private c0<String, ByteString> internalGetFiles() {
                c0<String, ByteString> c0Var = this.files_;
                return c0Var == null ? c0.h(FilesDefaultEntryHolder.defaultEntry) : c0Var;
            }

            private c0<String, String> internalGetInfo() {
                c0<String, String> c0Var = this.info_;
                return c0Var == null ? c0.h(InfoDefaultEntryHolder.defaultEntry) : c0Var;
            }

            private c0<String, ByteString> internalGetMutableFiles() {
                onChanged();
                if (this.files_ == null) {
                    this.files_ = c0.q(FilesDefaultEntryHolder.defaultEntry);
                }
                if (!this.files_.n()) {
                    this.files_ = this.files_.g();
                }
                return this.files_;
            }

            private c0<String, String> internalGetMutableInfo() {
                onChanged();
                if (this.info_ == null) {
                    this.info_ = c0.q(InfoDefaultEntryHolder.defaultEntry);
                }
                if (!this.info_.n()) {
                    this.info_ = this.info_.g();
                }
                return this.info_;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            public Builder clearFiles() {
                getMutableFiles().clear();
                return this;
            }

            public Builder clearInfo() {
                getMutableInfo().clear();
                return this;
            }

            @Override // com.mobvoi.companion.FeedbackProto.FilesAndInfoOrBuilder
            public boolean containsFiles(String str) {
                Objects.requireNonNull(str);
                return internalGetFiles().j().containsKey(str);
            }

            @Override // com.mobvoi.companion.FeedbackProto.FilesAndInfoOrBuilder
            public boolean containsInfo(String str) {
                Objects.requireNonNull(str);
                return internalGetInfo().j().containsKey(str);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a, com.google.protobuf.g0
            public Descriptors.b getDescriptorForType() {
                return FeedbackProto.internal_static_feedbackhub_FilesAndInfo_descriptor;
            }

            @Override // com.mobvoi.companion.FeedbackProto.FilesAndInfoOrBuilder
            @Deprecated
            public Map<String, ByteString> getFiles() {
                return getFilesMap();
            }

            @Override // com.mobvoi.companion.FeedbackProto.FilesAndInfoOrBuilder
            public int getFilesCount() {
                return internalGetFiles().j().size();
            }

            @Override // com.mobvoi.companion.FeedbackProto.FilesAndInfoOrBuilder
            public Map<String, ByteString> getFilesMap() {
                return internalGetFiles().j();
            }

            @Override // com.mobvoi.companion.FeedbackProto.FilesAndInfoOrBuilder
            public ByteString getFilesOrDefault(String str, ByteString byteString) {
                Objects.requireNonNull(str);
                Map<String, ByteString> j10 = internalGetFiles().j();
                return j10.containsKey(str) ? j10.get(str) : byteString;
            }

            @Override // com.mobvoi.companion.FeedbackProto.FilesAndInfoOrBuilder
            public ByteString getFilesOrThrow(String str) {
                Objects.requireNonNull(str);
                Map<String, ByteString> j10 = internalGetFiles().j();
                if (j10.containsKey(str)) {
                    return j10.get(str);
                }
                throw new IllegalArgumentException();
            }

            @Override // com.mobvoi.companion.FeedbackProto.FilesAndInfoOrBuilder
            @Deprecated
            public Map<String, String> getInfo() {
                return getInfoMap();
            }

            @Override // com.mobvoi.companion.FeedbackProto.FilesAndInfoOrBuilder
            public int getInfoCount() {
                return internalGetInfo().j().size();
            }

            @Override // com.mobvoi.companion.FeedbackProto.FilesAndInfoOrBuilder
            public Map<String, String> getInfoMap() {
                return internalGetInfo().j();
            }

            @Override // com.mobvoi.companion.FeedbackProto.FilesAndInfoOrBuilder
            public String getInfoOrDefault(String str, String str2) {
                Objects.requireNonNull(str);
                Map<String, String> j10 = internalGetInfo().j();
                return j10.containsKey(str) ? j10.get(str) : str2;
            }

            @Override // com.mobvoi.companion.FeedbackProto.FilesAndInfoOrBuilder
            public String getInfoOrThrow(String str) {
                Objects.requireNonNull(str);
                Map<String, String> j10 = internalGetInfo().j();
                if (j10.containsKey(str)) {
                    return j10.get(str);
                }
                throw new IllegalArgumentException();
            }

            @Deprecated
            public Map<String, ByteString> getMutableFiles() {
                return internalGetMutableFiles().m();
            }

            @Deprecated
            public Map<String, String> getMutableInfo() {
                return internalGetMutableInfo().m();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return FeedbackProto.internal_static_feedbackhub_FilesAndInfo_fieldAccessorTable.e(FilesAndInfo.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected c0 internalGetMapField(int i10) {
                if (i10 == 1) {
                    return internalGetFiles();
                }
                if (i10 == 2) {
                    return internalGetInfo();
                }
                throw new RuntimeException("Invalid map field number: " + i10);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected c0 internalGetMutableMapField(int i10) {
                if (i10 == 1) {
                    return internalGetMutableFiles();
                }
                if (i10 == 2) {
                    return internalGetMutableInfo();
                }
                throw new RuntimeException("Invalid map field number: " + i10);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.f0
            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a
            public final Builder mergeUnknownFields(a1 a1Var) {
                return this;
            }

            public Builder putAllFiles(Map<String, ByteString> map) {
                getMutableFiles().putAll(map);
                return this;
            }

            public Builder putAllInfo(Map<String, String> map) {
                getMutableInfo().putAll(map);
                return this;
            }

            public Builder putFiles(String str, ByteString byteString) {
                Objects.requireNonNull(str);
                Objects.requireNonNull(byteString);
                getMutableFiles().put(str, byteString);
                return this;
            }

            public Builder putInfo(String str, String str2) {
                Objects.requireNonNull(str);
                Objects.requireNonNull(str2);
                getMutableInfo().put(str, str2);
                return this;
            }

            public Builder removeFiles(String str) {
                Objects.requireNonNull(str);
                getMutableFiles().remove(str);
                return this;
            }

            public Builder removeInfo(String str) {
                Objects.requireNonNull(str);
                getMutableInfo().remove(str);
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
            public FilesAndInfo build() {
                FilesAndInfo buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) buildPartial);
            }

            @Override // com.google.protobuf.e0.a, com.google.protobuf.d0.a
            public FilesAndInfo buildPartial() {
                FilesAndInfo filesAndInfo = new FilesAndInfo(this);
                filesAndInfo.files_ = internalGetFiles();
                filesAndInfo.files_.o();
                filesAndInfo.info_ = internalGetInfo();
                filesAndInfo.info_.o();
                onBuilt();
                return filesAndInfo;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.f0, com.google.protobuf.g0
            public FilesAndInfo getDefaultInstanceForType() {
                return FilesAndInfo.getDefaultInstance();
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
                internalGetMutableFiles().b();
                internalGetMutableInfo().b();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a, com.google.protobuf.b.a
            public Builder clone() {
                return (Builder) super.clone();
            }

            @Override // com.google.protobuf.a.AbstractC0170a, com.google.protobuf.d0.a
            public Builder mergeFrom(d0 d0Var) {
                if (d0Var instanceof FilesAndInfo) {
                    return mergeFrom((FilesAndInfo) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            public Builder mergeFrom(FilesAndInfo filesAndInfo) {
                if (filesAndInfo == FilesAndInfo.getDefaultInstance()) {
                    return this;
                }
                internalGetMutableFiles().p(filesAndInfo.internalGetFiles());
                internalGetMutableInfo().p(filesAndInfo.internalGetInfo());
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
                FilesAndInfo filesAndInfo = null;
                try {
                    try {
                        FilesAndInfo filesAndInfo2 = (FilesAndInfo) FilesAndInfo.PARSER.parsePartialFrom(iVar, qVar);
                        if (filesAndInfo2 != null) {
                            mergeFrom(filesAndInfo2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e10) {
                        filesAndInfo = (FilesAndInfo) e10.getUnfinishedMessage();
                        try {
                            throw e10.unwrapIOException();
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (filesAndInfo != null) {
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (filesAndInfo != null) {
                        mergeFrom(filesAndInfo);
                    }
                    throw th2;
                }
            }
        }

        public static Builder newBuilder(FilesAndInfo filesAndInfo) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(filesAndInfo);
        }

        public static FilesAndInfo parseFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, qVar);
        }

        private FilesAndInfo(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static FilesAndInfo parseDelimitedFrom(InputStream inputStream, q qVar) throws IOException {
            return (FilesAndInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
        }

        public static FilesAndInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
        public FilesAndInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static FilesAndInfo parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder newBuilderForType() {
            return newBuilder();
        }

        private FilesAndInfo() {
            this.memoizedIsInitialized = (byte) -1;
        }

        public static FilesAndInfo parseFrom(InputStream inputStream) throws IOException {
            return (FilesAndInfo) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.c cVar) {
            return new Builder(cVar);
        }

        private FilesAndInfo(i iVar, q qVar) throws InvalidProtocolBufferException {
            this();
            boolean z10 = false;
            boolean z11 = false;
            while (!z10) {
                try {
                    try {
                        try {
                            int F = iVar.F();
                            if (F != 0) {
                                if (F == 10) {
                                    if (!z11 || !true) {
                                        this.files_ = c0.q(FilesDefaultEntryHolder.defaultEntry);
                                        z11 |= true;
                                    }
                                    a0 a0Var = (a0) iVar.v(FilesDefaultEntryHolder.defaultEntry.getParserForType(), qVar);
                                    this.files_.m().put((String) a0Var.h(), (ByteString) a0Var.i());
                                } else if (F == 18) {
                                    if (!(z11 & true)) {
                                        this.info_ = c0.q(InfoDefaultEntryHolder.defaultEntry);
                                        z11 |= true;
                                    }
                                    a0 a0Var2 = (a0) iVar.v(InfoDefaultEntryHolder.defaultEntry.getParserForType(), qVar);
                                    this.info_.m().put((String) a0Var2.h(), (String) a0Var2.i());
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

        public static FilesAndInfo parseFrom(InputStream inputStream, q qVar) throws IOException {
            return (FilesAndInfo) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
        }

        public static FilesAndInfo parseFrom(i iVar) throws IOException {
            return (FilesAndInfo) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
        }

        public static FilesAndInfo parseFrom(i iVar, q qVar) throws IOException {
            return (FilesAndInfo) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
        }
    }

    /* loaded from: classes2.dex */
    public interface FilesAndInfoOrBuilder extends g0 {
        boolean containsFiles(String str);

        boolean containsInfo(String str);

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

        @Deprecated
        Map<String, ByteString> getFiles();

        int getFilesCount();

        Map<String, ByteString> getFilesMap();

        ByteString getFilesOrDefault(String str, ByteString byteString);

        ByteString getFilesOrThrow(String str);

        @Deprecated
        Map<String, String> getInfo();

        int getInfoCount();

        Map<String, String> getInfoMap();

        String getInfoOrDefault(String str, String str2);

        String getInfoOrThrow(String str);

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
    public static final class Request extends GeneratedMessageV3 implements RequestOrBuilder {
        public static final int COMMENT_FIELD_NUMBER = 1;
        public static final int FEEDBACK_FIELD_NUMBER = 2;
        public static final int FILES_AND_INFO_FIELD_NUMBER = 4;
        public static final int TICAUTO_LOGS_FIELD_NUMBER = 3;
        private static final long serialVersionUID = 0;
        private byte memoizedIsInitialized;
        private int typeCase_;
        private Object type_;
        private static final Request DEFAULT_INSTANCE = new Request();
        private static final l0<Request> PARSER = new c<Request>() { // from class: com.mobvoi.companion.FeedbackProto.Request.1
            @Override // com.google.protobuf.l0
            public Request parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
                return new Request(iVar, qVar);
            }
        };

        /* loaded from: classes2.dex */
        public enum TypeCase implements u.a {
            COMMENT(1),
            FEEDBACK(2),
            TICAUTO_LOGS(3),
            FILES_AND_INFO(4),
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
                    return COMMENT;
                }
                if (i10 == 2) {
                    return FEEDBACK;
                }
                if (i10 == 3) {
                    return TICAUTO_LOGS;
                }
                if (i10 != 4) {
                    return null;
                }
                return FILES_AND_INFO;
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

        public static Request getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return FeedbackProto.internal_static_feedbackhub_Request_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Request parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Request) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static Request parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static l0<Request> parser() {
            return PARSER;
        }

        /* JADX WARN: Code restructure failed: missing block: B:25:0x0040, code lost:
            if (getFilesAndInfo().equals(r6.getFilesAndInfo()) != false) goto L36;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x0051, code lost:
            if (getTicautoLogs().equals(r6.getTicautoLogs()) != false) goto L36;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x0062, code lost:
            if (getFeedback().equals(r6.getFeedback()) != false) goto L36;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x0073, code lost:
            if (getComment().equals(r6.getComment()) != false) goto L36;
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
            if (!(obj instanceof Request)) {
                return super.equals(obj);
            }
            Request request = (Request) obj;
            boolean z11 = getTypeCase().equals(request.getTypeCase());
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
            } else if (i10 == 3) {
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

        @Override // com.mobvoi.companion.FeedbackProto.RequestOrBuilder
        public String getComment() {
            String str = this.typeCase_ == 1 ? this.type_ : "";
            if (str instanceof String) {
                return (String) str;
            }
            String stringUtf8 = ((ByteString) str).toStringUtf8();
            if (this.typeCase_ == 1) {
                this.type_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.FeedbackProto.RequestOrBuilder
        public ByteString getCommentBytes() {
            String str = this.typeCase_ == 1 ? this.type_ : "";
            if (!(str instanceof String)) {
                return (ByteString) str;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) str);
            if (this.typeCase_ == 1) {
                this.type_ = copyFromUtf8;
            }
            return copyFromUtf8;
        }

        @Override // com.mobvoi.companion.FeedbackProto.RequestOrBuilder
        public FeedbackRequest getFeedback() {
            if (this.typeCase_ == 2) {
                return (FeedbackRequest) this.type_;
            }
            return FeedbackRequest.getDefaultInstance();
        }

        @Override // com.mobvoi.companion.FeedbackProto.RequestOrBuilder
        public FeedbackRequestOrBuilder getFeedbackOrBuilder() {
            if (this.typeCase_ == 2) {
                return (FeedbackRequest) this.type_;
            }
            return FeedbackRequest.getDefaultInstance();
        }

        @Override // com.mobvoi.companion.FeedbackProto.RequestOrBuilder
        public FilesAndInfo getFilesAndInfo() {
            if (this.typeCase_ == 4) {
                return (FilesAndInfo) this.type_;
            }
            return FilesAndInfo.getDefaultInstance();
        }

        @Override // com.mobvoi.companion.FeedbackProto.RequestOrBuilder
        public FilesAndInfoOrBuilder getFilesAndInfoOrBuilder() {
            if (this.typeCase_ == 4) {
                return (FilesAndInfo) this.type_;
            }
            return FilesAndInfo.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public l0<Request> getParserForType() {
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
                i11 = 0 + GeneratedMessageV3.computeStringSize(1, this.type_);
            }
            if (this.typeCase_ == 2) {
                i11 += CodedOutputStream.E(2, (FeedbackRequest) this.type_);
            }
            if (this.typeCase_ == 3) {
                i11 += CodedOutputStream.E(3, (TicautoLogs) this.type_);
            }
            if (this.typeCase_ == 4) {
                i11 += CodedOutputStream.E(4, (FilesAndInfo) this.type_);
            }
            this.memoizedSize = i11;
            return i11;
        }

        @Override // com.mobvoi.companion.FeedbackProto.RequestOrBuilder
        public TicautoLogs getTicautoLogs() {
            if (this.typeCase_ == 3) {
                return (TicautoLogs) this.type_;
            }
            return TicautoLogs.getDefaultInstance();
        }

        @Override // com.mobvoi.companion.FeedbackProto.RequestOrBuilder
        public TicautoLogsOrBuilder getTicautoLogsOrBuilder() {
            if (this.typeCase_ == 3) {
                return (TicautoLogs) this.type_;
            }
            return TicautoLogs.getDefaultInstance();
        }

        @Override // com.mobvoi.companion.FeedbackProto.RequestOrBuilder
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
            int hashCode = 779 + getDescriptorForType().hashCode();
            int i13 = this.typeCase_;
            if (i13 == 1) {
                i11 = ((hashCode * 37) + 1) * 53;
                i10 = getComment().hashCode();
            } else if (i13 == 2) {
                i11 = ((hashCode * 37) + 2) * 53;
                i10 = getFeedback().hashCode();
            } else if (i13 != 3) {
                if (i13 == 4) {
                    i11 = ((hashCode * 37) + 4) * 53;
                    i10 = getFilesAndInfo().hashCode();
                }
                int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
                this.memoizedHashCode = hashCode2;
                return hashCode2;
            } else {
                i11 = ((hashCode * 37) + 3) * 53;
                i10 = getTicautoLogs().hashCode();
            }
            hashCode = i11 + i10;
            int hashCode22 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode22;
            return hashCode22;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return FeedbackProto.internal_static_feedbackhub_Request_fieldAccessorTable.e(Request.class, Builder.class);
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
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.type_);
            }
            if (this.typeCase_ == 2) {
                codedOutputStream.A0(2, (FeedbackRequest) this.type_);
            }
            if (this.typeCase_ == 3) {
                codedOutputStream.A0(3, (TicautoLogs) this.type_);
            }
            if (this.typeCase_ == 4) {
                codedOutputStream.A0(4, (FilesAndInfo) this.type_);
            }
        }

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageV3.b<Builder> implements RequestOrBuilder {
            private q0<FeedbackRequest, FeedbackRequest.Builder, FeedbackRequestOrBuilder> feedbackBuilder_;
            private q0<FilesAndInfo, FilesAndInfo.Builder, FilesAndInfoOrBuilder> filesAndInfoBuilder_;
            private q0<TicautoLogs, TicautoLogs.Builder, TicautoLogsOrBuilder> ticautoLogsBuilder_;
            private int typeCase_;
            private Object type_;

            public static final Descriptors.b getDescriptor() {
                return FeedbackProto.internal_static_feedbackhub_Request_descriptor;
            }

            private q0<FeedbackRequest, FeedbackRequest.Builder, FeedbackRequestOrBuilder> getFeedbackFieldBuilder() {
                if (this.feedbackBuilder_ == null) {
                    if (this.typeCase_ != 2) {
                        this.type_ = FeedbackRequest.getDefaultInstance();
                    }
                    this.feedbackBuilder_ = new q0<>((FeedbackRequest) this.type_, getParentForChildren(), isClean());
                    this.type_ = null;
                }
                this.typeCase_ = 2;
                onChanged();
                return this.feedbackBuilder_;
            }

            private q0<FilesAndInfo, FilesAndInfo.Builder, FilesAndInfoOrBuilder> getFilesAndInfoFieldBuilder() {
                if (this.filesAndInfoBuilder_ == null) {
                    if (this.typeCase_ != 4) {
                        this.type_ = FilesAndInfo.getDefaultInstance();
                    }
                    this.filesAndInfoBuilder_ = new q0<>((FilesAndInfo) this.type_, getParentForChildren(), isClean());
                    this.type_ = null;
                }
                this.typeCase_ = 4;
                onChanged();
                return this.filesAndInfoBuilder_;
            }

            private q0<TicautoLogs, TicautoLogs.Builder, TicautoLogsOrBuilder> getTicautoLogsFieldBuilder() {
                if (this.ticautoLogsBuilder_ == null) {
                    if (this.typeCase_ != 3) {
                        this.type_ = TicautoLogs.getDefaultInstance();
                    }
                    this.ticautoLogsBuilder_ = new q0<>((TicautoLogs) this.type_, getParentForChildren(), isClean());
                    this.type_ = null;
                }
                this.typeCase_ = 3;
                onChanged();
                return this.ticautoLogsBuilder_;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            public Builder clearComment() {
                if (this.typeCase_ == 1) {
                    this.typeCase_ = 0;
                    this.type_ = null;
                    onChanged();
                }
                return this;
            }

            public Builder clearFeedback() {
                q0<FeedbackRequest, FeedbackRequest.Builder, FeedbackRequestOrBuilder> q0Var = this.feedbackBuilder_;
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

            public Builder clearFilesAndInfo() {
                q0<FilesAndInfo, FilesAndInfo.Builder, FilesAndInfoOrBuilder> q0Var = this.filesAndInfoBuilder_;
                if (q0Var != null) {
                    if (this.typeCase_ == 4) {
                        this.typeCase_ = 0;
                        this.type_ = null;
                    }
                    q0Var.c();
                } else if (this.typeCase_ == 4) {
                    this.typeCase_ = 0;
                    this.type_ = null;
                    onChanged();
                }
                return this;
            }

            public Builder clearTicautoLogs() {
                q0<TicautoLogs, TicautoLogs.Builder, TicautoLogsOrBuilder> q0Var = this.ticautoLogsBuilder_;
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

            public Builder clearType() {
                this.typeCase_ = 0;
                this.type_ = null;
                onChanged();
                return this;
            }

            @Override // com.mobvoi.companion.FeedbackProto.RequestOrBuilder
            public String getComment() {
                String str = this.typeCase_ == 1 ? this.type_ : "";
                if (str instanceof String) {
                    return (String) str;
                }
                String stringUtf8 = ((ByteString) str).toStringUtf8();
                if (this.typeCase_ == 1) {
                    this.type_ = stringUtf8;
                }
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.FeedbackProto.RequestOrBuilder
            public ByteString getCommentBytes() {
                String str = this.typeCase_ == 1 ? this.type_ : "";
                if (!(str instanceof String)) {
                    return (ByteString) str;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) str);
                if (this.typeCase_ == 1) {
                    this.type_ = copyFromUtf8;
                }
                return copyFromUtf8;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a, com.google.protobuf.g0
            public Descriptors.b getDescriptorForType() {
                return FeedbackProto.internal_static_feedbackhub_Request_descriptor;
            }

            @Override // com.mobvoi.companion.FeedbackProto.RequestOrBuilder
            public FeedbackRequest getFeedback() {
                q0<FeedbackRequest, FeedbackRequest.Builder, FeedbackRequestOrBuilder> q0Var = this.feedbackBuilder_;
                if (q0Var == null) {
                    if (this.typeCase_ == 2) {
                        return (FeedbackRequest) this.type_;
                    }
                    return FeedbackRequest.getDefaultInstance();
                } else if (this.typeCase_ == 2) {
                    return q0Var.f();
                } else {
                    return FeedbackRequest.getDefaultInstance();
                }
            }

            public FeedbackRequest.Builder getFeedbackBuilder() {
                return getFeedbackFieldBuilder().e();
            }

            @Override // com.mobvoi.companion.FeedbackProto.RequestOrBuilder
            public FeedbackRequestOrBuilder getFeedbackOrBuilder() {
                q0<FeedbackRequest, FeedbackRequest.Builder, FeedbackRequestOrBuilder> q0Var;
                int i10 = this.typeCase_;
                if (i10 == 2 && (q0Var = this.feedbackBuilder_) != null) {
                    return q0Var.g();
                }
                if (i10 == 2) {
                    return (FeedbackRequest) this.type_;
                }
                return FeedbackRequest.getDefaultInstance();
            }

            @Override // com.mobvoi.companion.FeedbackProto.RequestOrBuilder
            public FilesAndInfo getFilesAndInfo() {
                q0<FilesAndInfo, FilesAndInfo.Builder, FilesAndInfoOrBuilder> q0Var = this.filesAndInfoBuilder_;
                if (q0Var == null) {
                    if (this.typeCase_ == 4) {
                        return (FilesAndInfo) this.type_;
                    }
                    return FilesAndInfo.getDefaultInstance();
                } else if (this.typeCase_ == 4) {
                    return q0Var.f();
                } else {
                    return FilesAndInfo.getDefaultInstance();
                }
            }

            public FilesAndInfo.Builder getFilesAndInfoBuilder() {
                return getFilesAndInfoFieldBuilder().e();
            }

            @Override // com.mobvoi.companion.FeedbackProto.RequestOrBuilder
            public FilesAndInfoOrBuilder getFilesAndInfoOrBuilder() {
                q0<FilesAndInfo, FilesAndInfo.Builder, FilesAndInfoOrBuilder> q0Var;
                int i10 = this.typeCase_;
                if (i10 == 4 && (q0Var = this.filesAndInfoBuilder_) != null) {
                    return q0Var.g();
                }
                if (i10 == 4) {
                    return (FilesAndInfo) this.type_;
                }
                return FilesAndInfo.getDefaultInstance();
            }

            @Override // com.mobvoi.companion.FeedbackProto.RequestOrBuilder
            public TicautoLogs getTicautoLogs() {
                q0<TicautoLogs, TicautoLogs.Builder, TicautoLogsOrBuilder> q0Var = this.ticautoLogsBuilder_;
                if (q0Var == null) {
                    if (this.typeCase_ == 3) {
                        return (TicautoLogs) this.type_;
                    }
                    return TicautoLogs.getDefaultInstance();
                } else if (this.typeCase_ == 3) {
                    return q0Var.f();
                } else {
                    return TicautoLogs.getDefaultInstance();
                }
            }

            public TicautoLogs.Builder getTicautoLogsBuilder() {
                return getTicautoLogsFieldBuilder().e();
            }

            @Override // com.mobvoi.companion.FeedbackProto.RequestOrBuilder
            public TicautoLogsOrBuilder getTicautoLogsOrBuilder() {
                q0<TicautoLogs, TicautoLogs.Builder, TicautoLogsOrBuilder> q0Var;
                int i10 = this.typeCase_;
                if (i10 == 3 && (q0Var = this.ticautoLogsBuilder_) != null) {
                    return q0Var.g();
                }
                if (i10 == 3) {
                    return (TicautoLogs) this.type_;
                }
                return TicautoLogs.getDefaultInstance();
            }

            @Override // com.mobvoi.companion.FeedbackProto.RequestOrBuilder
            public TypeCase getTypeCase() {
                return TypeCase.forNumber(this.typeCase_);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return FeedbackProto.internal_static_feedbackhub_Request_fieldAccessorTable.e(Request.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.f0
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFeedback(FeedbackRequest feedbackRequest) {
                q0<FeedbackRequest, FeedbackRequest.Builder, FeedbackRequestOrBuilder> q0Var = this.feedbackBuilder_;
                if (q0Var == null) {
                    if (this.typeCase_ != 2 || this.type_ == FeedbackRequest.getDefaultInstance()) {
                        this.type_ = feedbackRequest;
                    } else {
                        this.type_ = FeedbackRequest.newBuilder((FeedbackRequest) this.type_).mergeFrom(feedbackRequest).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.typeCase_ == 2) {
                        q0Var.h(feedbackRequest);
                    }
                    this.feedbackBuilder_.j(feedbackRequest);
                }
                this.typeCase_ = 2;
                return this;
            }

            public Builder mergeFilesAndInfo(FilesAndInfo filesAndInfo) {
                q0<FilesAndInfo, FilesAndInfo.Builder, FilesAndInfoOrBuilder> q0Var = this.filesAndInfoBuilder_;
                if (q0Var == null) {
                    if (this.typeCase_ != 4 || this.type_ == FilesAndInfo.getDefaultInstance()) {
                        this.type_ = filesAndInfo;
                    } else {
                        this.type_ = FilesAndInfo.newBuilder((FilesAndInfo) this.type_).mergeFrom(filesAndInfo).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.typeCase_ == 4) {
                        q0Var.h(filesAndInfo);
                    }
                    this.filesAndInfoBuilder_.j(filesAndInfo);
                }
                this.typeCase_ = 4;
                return this;
            }

            public Builder mergeTicautoLogs(TicautoLogs ticautoLogs) {
                q0<TicautoLogs, TicautoLogs.Builder, TicautoLogsOrBuilder> q0Var = this.ticautoLogsBuilder_;
                if (q0Var == null) {
                    if (this.typeCase_ != 3 || this.type_ == TicautoLogs.getDefaultInstance()) {
                        this.type_ = ticautoLogs;
                    } else {
                        this.type_ = TicautoLogs.newBuilder((TicautoLogs) this.type_).mergeFrom(ticautoLogs).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.typeCase_ == 3) {
                        q0Var.h(ticautoLogs);
                    }
                    this.ticautoLogsBuilder_.j(ticautoLogs);
                }
                this.typeCase_ = 3;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a
            public final Builder mergeUnknownFields(a1 a1Var) {
                return this;
            }

            public Builder setComment(String str) {
                Objects.requireNonNull(str);
                this.typeCase_ = 1;
                this.type_ = str;
                onChanged();
                return this;
            }

            public Builder setCommentBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                b.checkByteStringIsUtf8(byteString);
                this.typeCase_ = 1;
                this.type_ = byteString;
                onChanged();
                return this;
            }

            public Builder setFeedback(FeedbackRequest feedbackRequest) {
                q0<FeedbackRequest, FeedbackRequest.Builder, FeedbackRequestOrBuilder> q0Var = this.feedbackBuilder_;
                if (q0Var == null) {
                    Objects.requireNonNull(feedbackRequest);
                    this.type_ = feedbackRequest;
                    onChanged();
                } else {
                    q0Var.j(feedbackRequest);
                }
                this.typeCase_ = 2;
                return this;
            }

            public Builder setFilesAndInfo(FilesAndInfo filesAndInfo) {
                q0<FilesAndInfo, FilesAndInfo.Builder, FilesAndInfoOrBuilder> q0Var = this.filesAndInfoBuilder_;
                if (q0Var == null) {
                    Objects.requireNonNull(filesAndInfo);
                    this.type_ = filesAndInfo;
                    onChanged();
                } else {
                    q0Var.j(filesAndInfo);
                }
                this.typeCase_ = 4;
                return this;
            }

            public Builder setTicautoLogs(TicautoLogs ticautoLogs) {
                q0<TicautoLogs, TicautoLogs.Builder, TicautoLogsOrBuilder> q0Var = this.ticautoLogsBuilder_;
                if (q0Var == null) {
                    Objects.requireNonNull(ticautoLogs);
                    this.type_ = ticautoLogs;
                    onChanged();
                } else {
                    q0Var.j(ticautoLogs);
                }
                this.typeCase_ = 3;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public final Builder setUnknownFields(a1 a1Var) {
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
            public Request build() {
                Request buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) buildPartial);
            }

            @Override // com.google.protobuf.e0.a, com.google.protobuf.d0.a
            public Request buildPartial() {
                Request request = new Request(this);
                if (this.typeCase_ == 1) {
                    request.type_ = this.type_;
                }
                if (this.typeCase_ == 2) {
                    q0<FeedbackRequest, FeedbackRequest.Builder, FeedbackRequestOrBuilder> q0Var = this.feedbackBuilder_;
                    if (q0Var == null) {
                        request.type_ = this.type_;
                    } else {
                        request.type_ = q0Var.b();
                    }
                }
                if (this.typeCase_ == 3) {
                    q0<TicautoLogs, TicautoLogs.Builder, TicautoLogsOrBuilder> q0Var2 = this.ticautoLogsBuilder_;
                    if (q0Var2 == null) {
                        request.type_ = this.type_;
                    } else {
                        request.type_ = q0Var2.b();
                    }
                }
                if (this.typeCase_ == 4) {
                    q0<FilesAndInfo, FilesAndInfo.Builder, FilesAndInfoOrBuilder> q0Var3 = this.filesAndInfoBuilder_;
                    if (q0Var3 == null) {
                        request.type_ = this.type_;
                    } else {
                        request.type_ = q0Var3.b();
                    }
                }
                request.typeCase_ = this.typeCase_;
                onBuilt();
                return request;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.f0, com.google.protobuf.g0
            public Request getDefaultInstanceForType() {
                return Request.getDefaultInstance();
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
                if (d0Var instanceof Request) {
                    return mergeFrom((Request) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            public Builder setFeedback(FeedbackRequest.Builder builder) {
                q0<FeedbackRequest, FeedbackRequest.Builder, FeedbackRequestOrBuilder> q0Var = this.feedbackBuilder_;
                if (q0Var == null) {
                    this.type_ = builder.build();
                    onChanged();
                } else {
                    q0Var.j(builder.build());
                }
                this.typeCase_ = 2;
                return this;
            }

            public Builder setFilesAndInfo(FilesAndInfo.Builder builder) {
                q0<FilesAndInfo, FilesAndInfo.Builder, FilesAndInfoOrBuilder> q0Var = this.filesAndInfoBuilder_;
                if (q0Var == null) {
                    this.type_ = builder.build();
                    onChanged();
                } else {
                    q0Var.j(builder.build());
                }
                this.typeCase_ = 4;
                return this;
            }

            public Builder setTicautoLogs(TicautoLogs.Builder builder) {
                q0<TicautoLogs, TicautoLogs.Builder, TicautoLogsOrBuilder> q0Var = this.ticautoLogsBuilder_;
                if (q0Var == null) {
                    this.type_ = builder.build();
                    onChanged();
                } else {
                    q0Var.j(builder.build());
                }
                this.typeCase_ = 3;
                return this;
            }

            public Builder mergeFrom(Request request) {
                if (request == Request.getDefaultInstance()) {
                    return this;
                }
                int i10 = AnonymousClass2.$SwitchMap$com$mobvoi$companion$FeedbackProto$Request$TypeCase[request.getTypeCase().ordinal()];
                if (i10 == 1) {
                    this.typeCase_ = 1;
                    this.type_ = request.type_;
                    onChanged();
                } else if (i10 == 2) {
                    mergeFeedback(request.getFeedback());
                } else if (i10 == 3) {
                    mergeTicautoLogs(request.getTicautoLogs());
                } else if (i10 == 4) {
                    mergeFilesAndInfo(request.getFilesAndInfo());
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
                Request request = null;
                try {
                    try {
                        Request request2 = (Request) Request.PARSER.parsePartialFrom(iVar, qVar);
                        if (request2 != null) {
                            mergeFrom(request2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e10) {
                        request = (Request) e10.getUnfinishedMessage();
                        try {
                            throw e10.unwrapIOException();
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (request != null) {
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (request != null) {
                        mergeFrom(request);
                    }
                    throw th2;
                }
            }
        }

        public static Builder newBuilder(Request request) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(request);
        }

        public static Request parseFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, qVar);
        }

        private Request(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.typeCase_ = 0;
            this.memoizedIsInitialized = (byte) -1;
        }

        public static Request parseDelimitedFrom(InputStream inputStream, q qVar) throws IOException {
            return (Request) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
        }

        public static Request parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
        public Request getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static Request parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Request parseFrom(InputStream inputStream) throws IOException {
            return (Request) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.c cVar) {
            return new Builder(cVar);
        }

        private Request() {
            this.typeCase_ = 0;
            this.memoizedIsInitialized = (byte) -1;
        }

        public static Request parseFrom(InputStream inputStream, q qVar) throws IOException {
            return (Request) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
        }

        private Request(i iVar, q qVar) throws InvalidProtocolBufferException {
            this();
            boolean z10 = false;
            while (!z10) {
                try {
                    try {
                        int F = iVar.F();
                        if (F != 0) {
                            if (F != 10) {
                                FilesAndInfo.Builder builder = null;
                                FeedbackRequest.Builder builder2 = null;
                                TicautoLogs.Builder builder3 = null;
                                if (F == 18) {
                                    builder2 = this.typeCase_ == 2 ? ((FeedbackRequest) this.type_).toBuilder() : builder2;
                                    e0 v10 = iVar.v(FeedbackRequest.parser(), qVar);
                                    this.type_ = v10;
                                    if (builder2 != null) {
                                        builder2.mergeFrom((FeedbackRequest) v10);
                                        this.type_ = builder2.buildPartial();
                                    }
                                    this.typeCase_ = 2;
                                } else if (F == 26) {
                                    builder3 = this.typeCase_ == 3 ? ((TicautoLogs) this.type_).toBuilder() : builder3;
                                    e0 v11 = iVar.v(TicautoLogs.parser(), qVar);
                                    this.type_ = v11;
                                    if (builder3 != null) {
                                        builder3.mergeFrom((TicautoLogs) v11);
                                        this.type_ = builder3.buildPartial();
                                    }
                                    this.typeCase_ = 3;
                                } else if (F == 34) {
                                    builder = this.typeCase_ == 4 ? ((FilesAndInfo) this.type_).toBuilder() : builder;
                                    e0 v12 = iVar.v(FilesAndInfo.parser(), qVar);
                                    this.type_ = v12;
                                    if (builder != null) {
                                        builder.mergeFrom((FilesAndInfo) v12);
                                        this.type_ = builder.buildPartial();
                                    }
                                    this.typeCase_ = 4;
                                } else if (!iVar.I(F)) {
                                }
                            } else {
                                String E = iVar.E();
                                this.typeCase_ = 1;
                                this.type_ = E;
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

        public static Request parseFrom(i iVar) throws IOException {
            return (Request) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
        }

        public static Request parseFrom(i iVar, q qVar) throws IOException {
            return (Request) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
        }
    }

    /* loaded from: classes2.dex */
    public interface RequestOrBuilder extends g0 {
        /* synthetic */ List<String> findInitializationErrors();

        @Override // com.google.protobuf.g0
        /* synthetic */ Map<Descriptors.FieldDescriptor, Object> getAllFields();

        String getComment();

        ByteString getCommentBytes();

        @Override // com.google.protobuf.g0
        /* synthetic */ d0 getDefaultInstanceForType();

        @Override // com.google.protobuf.g0
        /* synthetic */ e0 getDefaultInstanceForType();

        @Override // com.google.protobuf.g0
        /* synthetic */ Descriptors.b getDescriptorForType();

        FeedbackRequest getFeedback();

        FeedbackRequestOrBuilder getFeedbackOrBuilder();

        @Override // com.google.protobuf.g0
        /* synthetic */ Object getField(Descriptors.FieldDescriptor fieldDescriptor);

        FilesAndInfo getFilesAndInfo();

        FilesAndInfoOrBuilder getFilesAndInfoOrBuilder();

        /* synthetic */ String getInitializationErrorString();

        /* synthetic */ Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.h hVar);

        /* synthetic */ Object getRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i10);

        /* synthetic */ int getRepeatedFieldCount(Descriptors.FieldDescriptor fieldDescriptor);

        TicautoLogs getTicautoLogs();

        TicautoLogsOrBuilder getTicautoLogsOrBuilder();

        Request.TypeCase getTypeCase();

        @Override // com.google.protobuf.g0
        /* synthetic */ a1 getUnknownFields();

        @Override // com.google.protobuf.g0
        /* synthetic */ boolean hasField(Descriptors.FieldDescriptor fieldDescriptor);

        /* synthetic */ boolean hasOneof(Descriptors.h hVar);

        @Override // com.google.protobuf.f0
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes2.dex */
    public static final class Response extends GeneratedMessageV3 implements ResponseOrBuilder {
        public static final int ERR_MSG_FIELD_NUMBER = 6;
        public static final int FEEDBACKS_FIELD_NUMBER = 8;
        public static final int FEEDBACK_FIELD_NUMBER = 4;
        public static final int OK_FIELD_NUMBER = 3;
        public static final int OSS_URL_FIELD_NUMBER = 7;
        public static final int UPLOAD_ID_FIELD_NUMBER = 9;
        private static final long serialVersionUID = 0;
        private volatile Object errMsg_;
        private byte memoizedIsInitialized;
        private boolean ok_;
        private int typeCase_;
        private Object type_;
        private static final Response DEFAULT_INSTANCE = new Response();
        private static final l0<Response> PARSER = new c<Response>() { // from class: com.mobvoi.companion.FeedbackProto.Response.1
            @Override // com.google.protobuf.l0
            public Response parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
                return new Response(iVar, qVar);
            }
        };

        /* loaded from: classes2.dex */
        public enum TypeCase implements u.a {
            FEEDBACK(4),
            OSS_URL(7),
            FEEDBACKS(8),
            UPLOAD_ID(9),
            TYPE_NOT_SET(0);
            
            private final int value;

            TypeCase(int i10) {
                this.value = i10;
            }

            public static TypeCase forNumber(int i10) {
                if (i10 == 0) {
                    return TYPE_NOT_SET;
                }
                if (i10 == 4) {
                    return FEEDBACK;
                }
                if (i10 == 7) {
                    return OSS_URL;
                }
                if (i10 == 8) {
                    return FEEDBACKS;
                }
                if (i10 != 9) {
                    return null;
                }
                return UPLOAD_ID;
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

        public static Response getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return FeedbackProto.internal_static_feedbackhub_Response_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Response parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Response) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static Response parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static l0<Response> parser() {
            return PARSER;
        }

        /* JADX WARN: Code restructure failed: missing block: B:35:0x0065, code lost:
            if (getUploadId().equals(r6.getUploadId()) != false) goto L46;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x0076, code lost:
            if (getFeedbacks().equals(r6.getFeedbacks()) != false) goto L46;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x0087, code lost:
            if (getOssUrl().equals(r6.getOssUrl()) != false) goto L46;
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x0098, code lost:
            if (getFeedback().equals(r6.getFeedback()) != false) goto L46;
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
            if (!(obj instanceof Response)) {
                return super.equals(obj);
            }
            Response response = (Response) obj;
            boolean z11 = ((getOk() == response.getOk()) && getErrMsg().equals(response.getErrMsg())) && getTypeCase().equals(response.getTypeCase());
            if (!z11) {
                return false;
            }
            int i10 = this.typeCase_;
            if (i10 == 4) {
                if (z11) {
                }
                z10 = false;
                return z10;
            } else if (i10 == 7) {
                if (z11) {
                }
                z10 = false;
                return z10;
            } else if (i10 == 8) {
                if (z11) {
                }
                z10 = false;
                return z10;
            } else if (i10 != 9) {
                return z11;
            } else {
                if (z11) {
                }
                z10 = false;
                return z10;
            }
        }

        @Override // com.mobvoi.companion.FeedbackProto.ResponseOrBuilder
        public String getErrMsg() {
            Object obj = this.errMsg_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.errMsg_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.FeedbackProto.ResponseOrBuilder
        public ByteString getErrMsgBytes() {
            Object obj = this.errMsg_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.errMsg_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.mobvoi.companion.FeedbackProto.ResponseOrBuilder
        public Feedback getFeedback() {
            if (this.typeCase_ == 4) {
                return (Feedback) this.type_;
            }
            return Feedback.getDefaultInstance();
        }

        @Override // com.mobvoi.companion.FeedbackProto.ResponseOrBuilder
        public FeedbackOrBuilder getFeedbackOrBuilder() {
            if (this.typeCase_ == 4) {
                return (Feedback) this.type_;
            }
            return Feedback.getDefaultInstance();
        }

        @Override // com.mobvoi.companion.FeedbackProto.ResponseOrBuilder
        public Feedbacks getFeedbacks() {
            if (this.typeCase_ == 8) {
                return (Feedbacks) this.type_;
            }
            return Feedbacks.getDefaultInstance();
        }

        @Override // com.mobvoi.companion.FeedbackProto.ResponseOrBuilder
        public FeedbacksOrBuilder getFeedbacksOrBuilder() {
            if (this.typeCase_ == 8) {
                return (Feedbacks) this.type_;
            }
            return Feedbacks.getDefaultInstance();
        }

        @Override // com.mobvoi.companion.FeedbackProto.ResponseOrBuilder
        public boolean getOk() {
            return this.ok_;
        }

        @Override // com.mobvoi.companion.FeedbackProto.ResponseOrBuilder
        public String getOssUrl() {
            String str = this.typeCase_ == 7 ? this.type_ : "";
            if (str instanceof String) {
                return (String) str;
            }
            String stringUtf8 = ((ByteString) str).toStringUtf8();
            if (this.typeCase_ == 7) {
                this.type_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.FeedbackProto.ResponseOrBuilder
        public ByteString getOssUrlBytes() {
            String str = this.typeCase_ == 7 ? this.type_ : "";
            if (!(str instanceof String)) {
                return (ByteString) str;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) str);
            if (this.typeCase_ == 7) {
                this.type_ = copyFromUtf8;
            }
            return copyFromUtf8;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public l0<Response> getParserForType() {
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
                i11 = 0 + CodedOutputStream.e(3, z10);
            }
            if (this.typeCase_ == 4) {
                i11 += CodedOutputStream.E(4, (Feedback) this.type_);
            }
            if (!getErrMsgBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(6, this.errMsg_);
            }
            if (this.typeCase_ == 7) {
                i11 += GeneratedMessageV3.computeStringSize(7, this.type_);
            }
            if (this.typeCase_ == 8) {
                i11 += CodedOutputStream.E(8, (Feedbacks) this.type_);
            }
            if (this.typeCase_ == 9) {
                i11 += GeneratedMessageV3.computeStringSize(9, this.type_);
            }
            this.memoizedSize = i11;
            return i11;
        }

        @Override // com.mobvoi.companion.FeedbackProto.ResponseOrBuilder
        public TypeCase getTypeCase() {
            return TypeCase.forNumber(this.typeCase_);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.g0
        public final a1 getUnknownFields() {
            return a1.c();
        }

        @Override // com.mobvoi.companion.FeedbackProto.ResponseOrBuilder
        public String getUploadId() {
            String str = this.typeCase_ == 9 ? this.type_ : "";
            if (str instanceof String) {
                return (String) str;
            }
            String stringUtf8 = ((ByteString) str).toStringUtf8();
            if (this.typeCase_ == 9) {
                this.type_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.FeedbackProto.ResponseOrBuilder
        public ByteString getUploadIdBytes() {
            String str = this.typeCase_ == 9 ? this.type_ : "";
            if (!(str instanceof String)) {
                return (ByteString) str;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) str);
            if (this.typeCase_ == 9) {
                this.type_ = copyFromUtf8;
            }
            return copyFromUtf8;
        }

        @Override // com.google.protobuf.a
        public int hashCode() {
            int i10;
            int i11;
            int i12 = this.memoizedHashCode;
            if (i12 != 0) {
                return i12;
            }
            int hashCode = ((((((((779 + getDescriptorForType().hashCode()) * 37) + 3) * 53) + u.c(getOk())) * 37) + 6) * 53) + getErrMsg().hashCode();
            int i13 = this.typeCase_;
            if (i13 == 4) {
                i11 = ((hashCode * 37) + 4) * 53;
                i10 = getFeedback().hashCode();
            } else if (i13 == 7) {
                i11 = ((hashCode * 37) + 7) * 53;
                i10 = getOssUrl().hashCode();
            } else if (i13 != 8) {
                if (i13 == 9) {
                    i11 = ((hashCode * 37) + 9) * 53;
                    i10 = getUploadId().hashCode();
                }
                int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
                this.memoizedHashCode = hashCode2;
                return hashCode2;
            } else {
                i11 = ((hashCode * 37) + 8) * 53;
                i10 = getFeedbacks().hashCode();
            }
            hashCode = i11 + i10;
            int hashCode22 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode22;
            return hashCode22;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return FeedbackProto.internal_static_feedbackhub_Response_fieldAccessorTable.e(Response.class, Builder.class);
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
                codedOutputStream.e0(3, z10);
            }
            if (this.typeCase_ == 4) {
                codedOutputStream.A0(4, (Feedback) this.type_);
            }
            if (!getErrMsgBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 6, this.errMsg_);
            }
            if (this.typeCase_ == 7) {
                GeneratedMessageV3.writeString(codedOutputStream, 7, this.type_);
            }
            if (this.typeCase_ == 8) {
                codedOutputStream.A0(8, (Feedbacks) this.type_);
            }
            if (this.typeCase_ == 9) {
                GeneratedMessageV3.writeString(codedOutputStream, 9, this.type_);
            }
        }

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageV3.b<Builder> implements ResponseOrBuilder {
            private Object errMsg_;
            private q0<Feedback, Feedback.Builder, FeedbackOrBuilder> feedbackBuilder_;
            private q0<Feedbacks, Feedbacks.Builder, FeedbacksOrBuilder> feedbacksBuilder_;
            private boolean ok_;
            private int typeCase_;
            private Object type_;

            public static final Descriptors.b getDescriptor() {
                return FeedbackProto.internal_static_feedbackhub_Response_descriptor;
            }

            private q0<Feedback, Feedback.Builder, FeedbackOrBuilder> getFeedbackFieldBuilder() {
                if (this.feedbackBuilder_ == null) {
                    if (this.typeCase_ != 4) {
                        this.type_ = Feedback.getDefaultInstance();
                    }
                    this.feedbackBuilder_ = new q0<>((Feedback) this.type_, getParentForChildren(), isClean());
                    this.type_ = null;
                }
                this.typeCase_ = 4;
                onChanged();
                return this.feedbackBuilder_;
            }

            private q0<Feedbacks, Feedbacks.Builder, FeedbacksOrBuilder> getFeedbacksFieldBuilder() {
                if (this.feedbacksBuilder_ == null) {
                    if (this.typeCase_ != 8) {
                        this.type_ = Feedbacks.getDefaultInstance();
                    }
                    this.feedbacksBuilder_ = new q0<>((Feedbacks) this.type_, getParentForChildren(), isClean());
                    this.type_ = null;
                }
                this.typeCase_ = 8;
                onChanged();
                return this.feedbacksBuilder_;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            public Builder clearErrMsg() {
                this.errMsg_ = Response.getDefaultInstance().getErrMsg();
                onChanged();
                return this;
            }

            public Builder clearFeedback() {
                q0<Feedback, Feedback.Builder, FeedbackOrBuilder> q0Var = this.feedbackBuilder_;
                if (q0Var != null) {
                    if (this.typeCase_ == 4) {
                        this.typeCase_ = 0;
                        this.type_ = null;
                    }
                    q0Var.c();
                } else if (this.typeCase_ == 4) {
                    this.typeCase_ = 0;
                    this.type_ = null;
                    onChanged();
                }
                return this;
            }

            public Builder clearFeedbacks() {
                q0<Feedbacks, Feedbacks.Builder, FeedbacksOrBuilder> q0Var = this.feedbacksBuilder_;
                if (q0Var != null) {
                    if (this.typeCase_ == 8) {
                        this.typeCase_ = 0;
                        this.type_ = null;
                    }
                    q0Var.c();
                } else if (this.typeCase_ == 8) {
                    this.typeCase_ = 0;
                    this.type_ = null;
                    onChanged();
                }
                return this;
            }

            public Builder clearOk() {
                this.ok_ = false;
                onChanged();
                return this;
            }

            public Builder clearOssUrl() {
                if (this.typeCase_ == 7) {
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

            public Builder clearUploadId() {
                if (this.typeCase_ == 9) {
                    this.typeCase_ = 0;
                    this.type_ = null;
                    onChanged();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a, com.google.protobuf.g0
            public Descriptors.b getDescriptorForType() {
                return FeedbackProto.internal_static_feedbackhub_Response_descriptor;
            }

            @Override // com.mobvoi.companion.FeedbackProto.ResponseOrBuilder
            public String getErrMsg() {
                Object obj = this.errMsg_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.errMsg_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.FeedbackProto.ResponseOrBuilder
            public ByteString getErrMsgBytes() {
                Object obj = this.errMsg_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.errMsg_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.mobvoi.companion.FeedbackProto.ResponseOrBuilder
            public Feedback getFeedback() {
                q0<Feedback, Feedback.Builder, FeedbackOrBuilder> q0Var = this.feedbackBuilder_;
                if (q0Var == null) {
                    if (this.typeCase_ == 4) {
                        return (Feedback) this.type_;
                    }
                    return Feedback.getDefaultInstance();
                } else if (this.typeCase_ == 4) {
                    return q0Var.f();
                } else {
                    return Feedback.getDefaultInstance();
                }
            }

            public Feedback.Builder getFeedbackBuilder() {
                return getFeedbackFieldBuilder().e();
            }

            @Override // com.mobvoi.companion.FeedbackProto.ResponseOrBuilder
            public FeedbackOrBuilder getFeedbackOrBuilder() {
                q0<Feedback, Feedback.Builder, FeedbackOrBuilder> q0Var;
                int i10 = this.typeCase_;
                if (i10 == 4 && (q0Var = this.feedbackBuilder_) != null) {
                    return q0Var.g();
                }
                if (i10 == 4) {
                    return (Feedback) this.type_;
                }
                return Feedback.getDefaultInstance();
            }

            @Override // com.mobvoi.companion.FeedbackProto.ResponseOrBuilder
            public Feedbacks getFeedbacks() {
                q0<Feedbacks, Feedbacks.Builder, FeedbacksOrBuilder> q0Var = this.feedbacksBuilder_;
                if (q0Var == null) {
                    if (this.typeCase_ == 8) {
                        return (Feedbacks) this.type_;
                    }
                    return Feedbacks.getDefaultInstance();
                } else if (this.typeCase_ == 8) {
                    return q0Var.f();
                } else {
                    return Feedbacks.getDefaultInstance();
                }
            }

            public Feedbacks.Builder getFeedbacksBuilder() {
                return getFeedbacksFieldBuilder().e();
            }

            @Override // com.mobvoi.companion.FeedbackProto.ResponseOrBuilder
            public FeedbacksOrBuilder getFeedbacksOrBuilder() {
                q0<Feedbacks, Feedbacks.Builder, FeedbacksOrBuilder> q0Var;
                int i10 = this.typeCase_;
                if (i10 == 8 && (q0Var = this.feedbacksBuilder_) != null) {
                    return q0Var.g();
                }
                if (i10 == 8) {
                    return (Feedbacks) this.type_;
                }
                return Feedbacks.getDefaultInstance();
            }

            @Override // com.mobvoi.companion.FeedbackProto.ResponseOrBuilder
            public boolean getOk() {
                return this.ok_;
            }

            @Override // com.mobvoi.companion.FeedbackProto.ResponseOrBuilder
            public String getOssUrl() {
                String str = this.typeCase_ == 7 ? this.type_ : "";
                if (str instanceof String) {
                    return (String) str;
                }
                String stringUtf8 = ((ByteString) str).toStringUtf8();
                if (this.typeCase_ == 7) {
                    this.type_ = stringUtf8;
                }
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.FeedbackProto.ResponseOrBuilder
            public ByteString getOssUrlBytes() {
                String str = this.typeCase_ == 7 ? this.type_ : "";
                if (!(str instanceof String)) {
                    return (ByteString) str;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) str);
                if (this.typeCase_ == 7) {
                    this.type_ = copyFromUtf8;
                }
                return copyFromUtf8;
            }

            @Override // com.mobvoi.companion.FeedbackProto.ResponseOrBuilder
            public TypeCase getTypeCase() {
                return TypeCase.forNumber(this.typeCase_);
            }

            @Override // com.mobvoi.companion.FeedbackProto.ResponseOrBuilder
            public String getUploadId() {
                String str = this.typeCase_ == 9 ? this.type_ : "";
                if (str instanceof String) {
                    return (String) str;
                }
                String stringUtf8 = ((ByteString) str).toStringUtf8();
                if (this.typeCase_ == 9) {
                    this.type_ = stringUtf8;
                }
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.FeedbackProto.ResponseOrBuilder
            public ByteString getUploadIdBytes() {
                String str = this.typeCase_ == 9 ? this.type_ : "";
                if (!(str instanceof String)) {
                    return (ByteString) str;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) str);
                if (this.typeCase_ == 9) {
                    this.type_ = copyFromUtf8;
                }
                return copyFromUtf8;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return FeedbackProto.internal_static_feedbackhub_Response_fieldAccessorTable.e(Response.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.f0
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFeedback(Feedback feedback) {
                q0<Feedback, Feedback.Builder, FeedbackOrBuilder> q0Var = this.feedbackBuilder_;
                if (q0Var == null) {
                    if (this.typeCase_ != 4 || this.type_ == Feedback.getDefaultInstance()) {
                        this.type_ = feedback;
                    } else {
                        this.type_ = Feedback.newBuilder((Feedback) this.type_).mergeFrom(feedback).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.typeCase_ == 4) {
                        q0Var.h(feedback);
                    }
                    this.feedbackBuilder_.j(feedback);
                }
                this.typeCase_ = 4;
                return this;
            }

            public Builder mergeFeedbacks(Feedbacks feedbacks) {
                q0<Feedbacks, Feedbacks.Builder, FeedbacksOrBuilder> q0Var = this.feedbacksBuilder_;
                if (q0Var == null) {
                    if (this.typeCase_ != 8 || this.type_ == Feedbacks.getDefaultInstance()) {
                        this.type_ = feedbacks;
                    } else {
                        this.type_ = Feedbacks.newBuilder((Feedbacks) this.type_).mergeFrom(feedbacks).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.typeCase_ == 8) {
                        q0Var.h(feedbacks);
                    }
                    this.feedbacksBuilder_.j(feedbacks);
                }
                this.typeCase_ = 8;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a
            public final Builder mergeUnknownFields(a1 a1Var) {
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

            public Builder setFeedback(Feedback feedback) {
                q0<Feedback, Feedback.Builder, FeedbackOrBuilder> q0Var = this.feedbackBuilder_;
                if (q0Var == null) {
                    Objects.requireNonNull(feedback);
                    this.type_ = feedback;
                    onChanged();
                } else {
                    q0Var.j(feedback);
                }
                this.typeCase_ = 4;
                return this;
            }

            public Builder setFeedbacks(Feedbacks feedbacks) {
                q0<Feedbacks, Feedbacks.Builder, FeedbacksOrBuilder> q0Var = this.feedbacksBuilder_;
                if (q0Var == null) {
                    Objects.requireNonNull(feedbacks);
                    this.type_ = feedbacks;
                    onChanged();
                } else {
                    q0Var.j(feedbacks);
                }
                this.typeCase_ = 8;
                return this;
            }

            public Builder setOk(boolean z10) {
                this.ok_ = z10;
                onChanged();
                return this;
            }

            public Builder setOssUrl(String str) {
                Objects.requireNonNull(str);
                this.typeCase_ = 7;
                this.type_ = str;
                onChanged();
                return this;
            }

            public Builder setOssUrlBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                b.checkByteStringIsUtf8(byteString);
                this.typeCase_ = 7;
                this.type_ = byteString;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public final Builder setUnknownFields(a1 a1Var) {
                return this;
            }

            public Builder setUploadId(String str) {
                Objects.requireNonNull(str);
                this.typeCase_ = 9;
                this.type_ = str;
                onChanged();
                return this;
            }

            public Builder setUploadIdBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                b.checkByteStringIsUtf8(byteString);
                this.typeCase_ = 9;
                this.type_ = byteString;
                onChanged();
                return this;
            }

            private Builder() {
                this.typeCase_ = 0;
                this.errMsg_ = "";
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.e0.a, com.google.protobuf.d0.a
            public Response build() {
                Response buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) buildPartial);
            }

            @Override // com.google.protobuf.e0.a, com.google.protobuf.d0.a
            public Response buildPartial() {
                Response response = new Response(this);
                response.ok_ = this.ok_;
                response.errMsg_ = this.errMsg_;
                if (this.typeCase_ == 4) {
                    q0<Feedback, Feedback.Builder, FeedbackOrBuilder> q0Var = this.feedbackBuilder_;
                    if (q0Var == null) {
                        response.type_ = this.type_;
                    } else {
                        response.type_ = q0Var.b();
                    }
                }
                if (this.typeCase_ == 7) {
                    response.type_ = this.type_;
                }
                if (this.typeCase_ == 8) {
                    q0<Feedbacks, Feedbacks.Builder, FeedbacksOrBuilder> q0Var2 = this.feedbacksBuilder_;
                    if (q0Var2 == null) {
                        response.type_ = this.type_;
                    } else {
                        response.type_ = q0Var2.b();
                    }
                }
                if (this.typeCase_ == 9) {
                    response.type_ = this.type_;
                }
                response.typeCase_ = this.typeCase_;
                onBuilt();
                return response;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.f0, com.google.protobuf.g0
            public Response getDefaultInstanceForType() {
                return Response.getDefaultInstance();
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
                this.errMsg_ = "";
                this.typeCase_ = 0;
                this.type_ = null;
                return this;
            }

            private Builder(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.typeCase_ = 0;
                this.errMsg_ = "";
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a, com.google.protobuf.b.a
            public Builder clone() {
                return (Builder) super.clone();
            }

            @Override // com.google.protobuf.a.AbstractC0170a, com.google.protobuf.d0.a
            public Builder mergeFrom(d0 d0Var) {
                if (d0Var instanceof Response) {
                    return mergeFrom((Response) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            public Builder setFeedback(Feedback.Builder builder) {
                q0<Feedback, Feedback.Builder, FeedbackOrBuilder> q0Var = this.feedbackBuilder_;
                if (q0Var == null) {
                    this.type_ = builder.build();
                    onChanged();
                } else {
                    q0Var.j(builder.build());
                }
                this.typeCase_ = 4;
                return this;
            }

            public Builder setFeedbacks(Feedbacks.Builder builder) {
                q0<Feedbacks, Feedbacks.Builder, FeedbacksOrBuilder> q0Var = this.feedbacksBuilder_;
                if (q0Var == null) {
                    this.type_ = builder.build();
                    onChanged();
                } else {
                    q0Var.j(builder.build());
                }
                this.typeCase_ = 8;
                return this;
            }

            public Builder mergeFrom(Response response) {
                if (response == Response.getDefaultInstance()) {
                    return this;
                }
                if (response.getOk()) {
                    setOk(response.getOk());
                }
                if (!response.getErrMsg().isEmpty()) {
                    this.errMsg_ = response.errMsg_;
                    onChanged();
                }
                int i10 = AnonymousClass2.$SwitchMap$com$mobvoi$companion$FeedbackProto$Response$TypeCase[response.getTypeCase().ordinal()];
                if (i10 == 1) {
                    mergeFeedback(response.getFeedback());
                } else if (i10 == 2) {
                    this.typeCase_ = 7;
                    this.type_ = response.type_;
                    onChanged();
                } else if (i10 == 3) {
                    mergeFeedbacks(response.getFeedbacks());
                } else if (i10 == 4) {
                    this.typeCase_ = 9;
                    this.type_ = response.type_;
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
                Response response = null;
                try {
                    try {
                        Response response2 = (Response) Response.PARSER.parsePartialFrom(iVar, qVar);
                        if (response2 != null) {
                            mergeFrom(response2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e10) {
                        response = (Response) e10.getUnfinishedMessage();
                        try {
                            throw e10.unwrapIOException();
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (response != null) {
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (response != null) {
                        mergeFrom(response);
                    }
                    throw th2;
                }
            }
        }

        public static Builder newBuilder(Response response) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(response);
        }

        public static Response parseFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, qVar);
        }

        private Response(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.typeCase_ = 0;
            this.memoizedIsInitialized = (byte) -1;
        }

        public static Response parseDelimitedFrom(InputStream inputStream, q qVar) throws IOException {
            return (Response) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
        }

        public static Response parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
        public Response getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static Response parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Response parseFrom(InputStream inputStream) throws IOException {
            return (Response) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.c cVar) {
            return new Builder(cVar);
        }

        private Response() {
            this.typeCase_ = 0;
            this.memoizedIsInitialized = (byte) -1;
            this.ok_ = false;
            this.errMsg_ = "";
        }

        public static Response parseFrom(InputStream inputStream, q qVar) throws IOException {
            return (Response) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
        }

        public static Response parseFrom(i iVar) throws IOException {
            return (Response) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
        }

        private Response(i iVar, q qVar) throws InvalidProtocolBufferException {
            this();
            boolean z10 = false;
            while (!z10) {
                try {
                    try {
                        int F = iVar.F();
                        z10 = true;
                        if (F != 0) {
                            if (F != 24) {
                                Feedbacks.Builder builder = null;
                                Feedback.Builder builder2 = null;
                                if (F == 34) {
                                    builder2 = this.typeCase_ == 4 ? ((Feedback) this.type_).toBuilder() : builder2;
                                    e0 v10 = iVar.v(Feedback.parser(), qVar);
                                    this.type_ = v10;
                                    if (builder2 != null) {
                                        builder2.mergeFrom((Feedback) v10);
                                        this.type_ = builder2.buildPartial();
                                    }
                                    this.typeCase_ = 4;
                                } else if (F == 50) {
                                    this.errMsg_ = iVar.E();
                                } else if (F == 58) {
                                    String E = iVar.E();
                                    this.typeCase_ = 7;
                                    this.type_ = E;
                                } else if (F == 66) {
                                    builder = this.typeCase_ == 8 ? ((Feedbacks) this.type_).toBuilder() : builder;
                                    e0 v11 = iVar.v(Feedbacks.parser(), qVar);
                                    this.type_ = v11;
                                    if (builder != null) {
                                        builder.mergeFrom((Feedbacks) v11);
                                        this.type_ = builder.buildPartial();
                                    }
                                    this.typeCase_ = 8;
                                } else if (F == 74) {
                                    String E2 = iVar.E();
                                    this.typeCase_ = 9;
                                    this.type_ = E2;
                                } else if (!iVar.I(F)) {
                                }
                            } else {
                                this.ok_ = iVar.l();
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

        public static Response parseFrom(i iVar, q qVar) throws IOException {
            return (Response) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
        }
    }

    /* loaded from: classes2.dex */
    public interface ResponseOrBuilder extends g0 {
        /* synthetic */ List<String> findInitializationErrors();

        @Override // com.google.protobuf.g0
        /* synthetic */ Map<Descriptors.FieldDescriptor, Object> getAllFields();

        @Override // com.google.protobuf.g0
        /* synthetic */ d0 getDefaultInstanceForType();

        @Override // com.google.protobuf.g0
        /* synthetic */ e0 getDefaultInstanceForType();

        @Override // com.google.protobuf.g0
        /* synthetic */ Descriptors.b getDescriptorForType();

        String getErrMsg();

        ByteString getErrMsgBytes();

        Feedback getFeedback();

        FeedbackOrBuilder getFeedbackOrBuilder();

        Feedbacks getFeedbacks();

        FeedbacksOrBuilder getFeedbacksOrBuilder();

        @Override // com.google.protobuf.g0
        /* synthetic */ Object getField(Descriptors.FieldDescriptor fieldDescriptor);

        /* synthetic */ String getInitializationErrorString();

        boolean getOk();

        /* synthetic */ Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.h hVar);

        String getOssUrl();

        ByteString getOssUrlBytes();

        /* synthetic */ Object getRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i10);

        /* synthetic */ int getRepeatedFieldCount(Descriptors.FieldDescriptor fieldDescriptor);

        Response.TypeCase getTypeCase();

        @Override // com.google.protobuf.g0
        /* synthetic */ a1 getUnknownFields();

        String getUploadId();

        ByteString getUploadIdBytes();

        @Override // com.google.protobuf.g0
        /* synthetic */ boolean hasField(Descriptors.FieldDescriptor fieldDescriptor);

        /* synthetic */ boolean hasOneof(Descriptors.h hVar);

        @Override // com.google.protobuf.f0
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes2.dex */
    public static final class TicautoLog extends GeneratedMessageV3 implements TicautoLogOrBuilder {
        public static final int CRASHLOG_FIELD_NUMBER = 5;
        public static final int DEVICE_ID_FIELD_NUMBER = 9;
        public static final int HAPPENED_AT_FIELD_NUMBER = 4;
        public static final int IMEI_FIELD_NUMBER = 7;
        public static final int PACKAGE_NAME_FIELD_NUMBER = 3;
        public static final int SOURCE_FIELD_NUMBER = 1;
        public static final int SUBSOURCE_FIELD_NUMBER = 2;
        public static final int VERSION_FIELD_NUMBER = 6;
        public static final int WWID_FIELD_NUMBER = 8;
        private static final long serialVersionUID = 0;
        private volatile Object crashlog_;
        private volatile Object deviceId_;
        private long happenedAt_;
        private volatile Object imei_;
        private byte memoizedIsInitialized;
        private volatile Object packageName_;
        private volatile Object source_;
        private volatile Object subsource_;
        private volatile Object version_;
        private volatile Object wwid_;
        private static final TicautoLog DEFAULT_INSTANCE = new TicautoLog();
        private static final l0<TicautoLog> PARSER = new c<TicautoLog>() { // from class: com.mobvoi.companion.FeedbackProto.TicautoLog.1
            @Override // com.google.protobuf.l0
            public TicautoLog parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
                return new TicautoLog(iVar, qVar);
            }
        };

        public static TicautoLog getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return FeedbackProto.internal_static_feedbackhub_TicautoLog_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static TicautoLog parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (TicautoLog) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static TicautoLog parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static l0<TicautoLog> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof TicautoLog)) {
                return super.equals(obj);
            }
            TicautoLog ticautoLog = (TicautoLog) obj;
            return ((((((((getSource().equals(ticautoLog.getSource())) && getSubsource().equals(ticautoLog.getSubsource())) && getPackageName().equals(ticautoLog.getPackageName())) && (getHappenedAt() > ticautoLog.getHappenedAt() ? 1 : (getHappenedAt() == ticautoLog.getHappenedAt() ? 0 : -1)) == 0) && getCrashlog().equals(ticautoLog.getCrashlog())) && getVersion().equals(ticautoLog.getVersion())) && getImei().equals(ticautoLog.getImei())) && getWwid().equals(ticautoLog.getWwid())) && getDeviceId().equals(ticautoLog.getDeviceId());
        }

        @Override // com.mobvoi.companion.FeedbackProto.TicautoLogOrBuilder
        public String getCrashlog() {
            Object obj = this.crashlog_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.crashlog_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.FeedbackProto.TicautoLogOrBuilder
        public ByteString getCrashlogBytes() {
            Object obj = this.crashlog_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.crashlog_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.mobvoi.companion.FeedbackProto.TicautoLogOrBuilder
        public String getDeviceId() {
            Object obj = this.deviceId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.deviceId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.FeedbackProto.TicautoLogOrBuilder
        public ByteString getDeviceIdBytes() {
            Object obj = this.deviceId_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.deviceId_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.mobvoi.companion.FeedbackProto.TicautoLogOrBuilder
        public long getHappenedAt() {
            return this.happenedAt_;
        }

        @Override // com.mobvoi.companion.FeedbackProto.TicautoLogOrBuilder
        public String getImei() {
            Object obj = this.imei_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.imei_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.FeedbackProto.TicautoLogOrBuilder
        public ByteString getImeiBytes() {
            Object obj = this.imei_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.imei_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.mobvoi.companion.FeedbackProto.TicautoLogOrBuilder
        public String getPackageName() {
            Object obj = this.packageName_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.packageName_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.FeedbackProto.TicautoLogOrBuilder
        public ByteString getPackageNameBytes() {
            Object obj = this.packageName_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.packageName_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public l0<TicautoLog> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
        public int getSerializedSize() {
            int i10 = this.memoizedSize;
            if (i10 != -1) {
                return i10;
            }
            int i11 = 0;
            if (!getSourceBytes().isEmpty()) {
                i11 = 0 + GeneratedMessageV3.computeStringSize(1, this.source_);
            }
            if (!getSubsourceBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(2, this.subsource_);
            }
            if (!getPackageNameBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(3, this.packageName_);
            }
            long j10 = this.happenedAt_;
            if (j10 != 0) {
                i11 += CodedOutputStream.x(4, j10);
            }
            if (!getCrashlogBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(5, this.crashlog_);
            }
            if (!getVersionBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(6, this.version_);
            }
            if (!getImeiBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(7, this.imei_);
            }
            if (!getWwidBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(8, this.wwid_);
            }
            if (!getDeviceIdBytes().isEmpty()) {
                i11 += GeneratedMessageV3.computeStringSize(9, this.deviceId_);
            }
            this.memoizedSize = i11;
            return i11;
        }

        @Override // com.mobvoi.companion.FeedbackProto.TicautoLogOrBuilder
        public String getSource() {
            Object obj = this.source_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.source_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.FeedbackProto.TicautoLogOrBuilder
        public ByteString getSourceBytes() {
            Object obj = this.source_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.source_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.mobvoi.companion.FeedbackProto.TicautoLogOrBuilder
        public String getSubsource() {
            Object obj = this.subsource_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.subsource_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.FeedbackProto.TicautoLogOrBuilder
        public ByteString getSubsourceBytes() {
            Object obj = this.subsource_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.subsource_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.g0
        public final a1 getUnknownFields() {
            return a1.c();
        }

        @Override // com.mobvoi.companion.FeedbackProto.TicautoLogOrBuilder
        public String getVersion() {
            Object obj = this.version_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.version_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.FeedbackProto.TicautoLogOrBuilder
        public ByteString getVersionBytes() {
            Object obj = this.version_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.version_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.mobvoi.companion.FeedbackProto.TicautoLogOrBuilder
        public String getWwid() {
            Object obj = this.wwid_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.wwid_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.mobvoi.companion.FeedbackProto.TicautoLogOrBuilder
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
            int hashCode = ((((((((((((((((((((((((((((((((((((((779 + getDescriptorForType().hashCode()) * 37) + 1) * 53) + getSource().hashCode()) * 37) + 2) * 53) + getSubsource().hashCode()) * 37) + 3) * 53) + getPackageName().hashCode()) * 37) + 4) * 53) + u.h(getHappenedAt())) * 37) + 5) * 53) + getCrashlog().hashCode()) * 37) + 6) * 53) + getVersion().hashCode()) * 37) + 7) * 53) + getImei().hashCode()) * 37) + 8) * 53) + getWwid().hashCode()) * 37) + 9) * 53) + getDeviceId().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return FeedbackProto.internal_static_feedbackhub_TicautoLog_fieldAccessorTable.e(TicautoLog.class, Builder.class);
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
            if (!getSourceBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.source_);
            }
            if (!getSubsourceBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.subsource_);
            }
            if (!getPackageNameBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 3, this.packageName_);
            }
            long j10 = this.happenedAt_;
            if (j10 != 0) {
                codedOutputStream.y0(4, j10);
            }
            if (!getCrashlogBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 5, this.crashlog_);
            }
            if (!getVersionBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 6, this.version_);
            }
            if (!getImeiBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 7, this.imei_);
            }
            if (!getWwidBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 8, this.wwid_);
            }
            if (!getDeviceIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 9, this.deviceId_);
            }
        }

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageV3.b<Builder> implements TicautoLogOrBuilder {
            private Object crashlog_;
            private Object deviceId_;
            private long happenedAt_;
            private Object imei_;
            private Object packageName_;
            private Object source_;
            private Object subsource_;
            private Object version_;
            private Object wwid_;

            public static final Descriptors.b getDescriptor() {
                return FeedbackProto.internal_static_feedbackhub_TicautoLog_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            public Builder clearCrashlog() {
                this.crashlog_ = TicautoLog.getDefaultInstance().getCrashlog();
                onChanged();
                return this;
            }

            public Builder clearDeviceId() {
                this.deviceId_ = TicautoLog.getDefaultInstance().getDeviceId();
                onChanged();
                return this;
            }

            public Builder clearHappenedAt() {
                this.happenedAt_ = 0L;
                onChanged();
                return this;
            }

            public Builder clearImei() {
                this.imei_ = TicautoLog.getDefaultInstance().getImei();
                onChanged();
                return this;
            }

            public Builder clearPackageName() {
                this.packageName_ = TicautoLog.getDefaultInstance().getPackageName();
                onChanged();
                return this;
            }

            public Builder clearSource() {
                this.source_ = TicautoLog.getDefaultInstance().getSource();
                onChanged();
                return this;
            }

            public Builder clearSubsource() {
                this.subsource_ = TicautoLog.getDefaultInstance().getSubsource();
                onChanged();
                return this;
            }

            public Builder clearVersion() {
                this.version_ = TicautoLog.getDefaultInstance().getVersion();
                onChanged();
                return this;
            }

            public Builder clearWwid() {
                this.wwid_ = TicautoLog.getDefaultInstance().getWwid();
                onChanged();
                return this;
            }

            @Override // com.mobvoi.companion.FeedbackProto.TicautoLogOrBuilder
            public String getCrashlog() {
                Object obj = this.crashlog_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.crashlog_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.FeedbackProto.TicautoLogOrBuilder
            public ByteString getCrashlogBytes() {
                Object obj = this.crashlog_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.crashlog_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a, com.google.protobuf.g0
            public Descriptors.b getDescriptorForType() {
                return FeedbackProto.internal_static_feedbackhub_TicautoLog_descriptor;
            }

            @Override // com.mobvoi.companion.FeedbackProto.TicautoLogOrBuilder
            public String getDeviceId() {
                Object obj = this.deviceId_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.deviceId_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.FeedbackProto.TicautoLogOrBuilder
            public ByteString getDeviceIdBytes() {
                Object obj = this.deviceId_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.deviceId_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.mobvoi.companion.FeedbackProto.TicautoLogOrBuilder
            public long getHappenedAt() {
                return this.happenedAt_;
            }

            @Override // com.mobvoi.companion.FeedbackProto.TicautoLogOrBuilder
            public String getImei() {
                Object obj = this.imei_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.imei_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.FeedbackProto.TicautoLogOrBuilder
            public ByteString getImeiBytes() {
                Object obj = this.imei_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.imei_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.mobvoi.companion.FeedbackProto.TicautoLogOrBuilder
            public String getPackageName() {
                Object obj = this.packageName_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.packageName_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.FeedbackProto.TicautoLogOrBuilder
            public ByteString getPackageNameBytes() {
                Object obj = this.packageName_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.packageName_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.mobvoi.companion.FeedbackProto.TicautoLogOrBuilder
            public String getSource() {
                Object obj = this.source_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.source_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.FeedbackProto.TicautoLogOrBuilder
            public ByteString getSourceBytes() {
                Object obj = this.source_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.source_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.mobvoi.companion.FeedbackProto.TicautoLogOrBuilder
            public String getSubsource() {
                Object obj = this.subsource_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.subsource_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.FeedbackProto.TicautoLogOrBuilder
            public ByteString getSubsourceBytes() {
                Object obj = this.subsource_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.subsource_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.mobvoi.companion.FeedbackProto.TicautoLogOrBuilder
            public String getVersion() {
                Object obj = this.version_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.version_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.FeedbackProto.TicautoLogOrBuilder
            public ByteString getVersionBytes() {
                Object obj = this.version_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.version_ = copyFromUtf8;
                return copyFromUtf8;
            }

            @Override // com.mobvoi.companion.FeedbackProto.TicautoLogOrBuilder
            public String getWwid() {
                Object obj = this.wwid_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.wwid_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.mobvoi.companion.FeedbackProto.TicautoLogOrBuilder
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
                return FeedbackProto.internal_static_feedbackhub_TicautoLog_fieldAccessorTable.e(TicautoLog.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.f0
            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a
            public final Builder mergeUnknownFields(a1 a1Var) {
                return this;
            }

            public Builder setCrashlog(String str) {
                Objects.requireNonNull(str);
                this.crashlog_ = str;
                onChanged();
                return this;
            }

            public Builder setCrashlogBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                b.checkByteStringIsUtf8(byteString);
                this.crashlog_ = byteString;
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

            public Builder setHappenedAt(long j10) {
                this.happenedAt_ = j10;
                onChanged();
                return this;
            }

            public Builder setImei(String str) {
                Objects.requireNonNull(str);
                this.imei_ = str;
                onChanged();
                return this;
            }

            public Builder setImeiBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                b.checkByteStringIsUtf8(byteString);
                this.imei_ = byteString;
                onChanged();
                return this;
            }

            public Builder setPackageName(String str) {
                Objects.requireNonNull(str);
                this.packageName_ = str;
                onChanged();
                return this;
            }

            public Builder setPackageNameBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                b.checkByteStringIsUtf8(byteString);
                this.packageName_ = byteString;
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

            public Builder setSubsource(String str) {
                Objects.requireNonNull(str);
                this.subsource_ = str;
                onChanged();
                return this;
            }

            public Builder setSubsourceBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                b.checkByteStringIsUtf8(byteString);
                this.subsource_ = byteString;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public final Builder setUnknownFields(a1 a1Var) {
                return this;
            }

            public Builder setVersion(String str) {
                Objects.requireNonNull(str);
                this.version_ = str;
                onChanged();
                return this;
            }

            public Builder setVersionBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                b.checkByteStringIsUtf8(byteString);
                this.version_ = byteString;
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
                this.source_ = "";
                this.subsource_ = "";
                this.packageName_ = "";
                this.crashlog_ = "";
                this.version_ = "";
                this.imei_ = "";
                this.wwid_ = "";
                this.deviceId_ = "";
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.e0.a, com.google.protobuf.d0.a
            public TicautoLog build() {
                TicautoLog buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) buildPartial);
            }

            @Override // com.google.protobuf.e0.a, com.google.protobuf.d0.a
            public TicautoLog buildPartial() {
                TicautoLog ticautoLog = new TicautoLog(this);
                ticautoLog.source_ = this.source_;
                ticautoLog.subsource_ = this.subsource_;
                ticautoLog.packageName_ = this.packageName_;
                ticautoLog.happenedAt_ = this.happenedAt_;
                ticautoLog.crashlog_ = this.crashlog_;
                ticautoLog.version_ = this.version_;
                ticautoLog.imei_ = this.imei_;
                ticautoLog.wwid_ = this.wwid_;
                ticautoLog.deviceId_ = this.deviceId_;
                onBuilt();
                return ticautoLog;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.f0, com.google.protobuf.g0
            public TicautoLog getDefaultInstanceForType() {
                return TicautoLog.getDefaultInstance();
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
                this.source_ = "";
                this.subsource_ = "";
                this.packageName_ = "";
                this.happenedAt_ = 0L;
                this.crashlog_ = "";
                this.version_ = "";
                this.imei_ = "";
                this.wwid_ = "";
                this.deviceId_ = "";
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a, com.google.protobuf.b.a
            public Builder clone() {
                return (Builder) super.clone();
            }

            @Override // com.google.protobuf.a.AbstractC0170a, com.google.protobuf.d0.a
            public Builder mergeFrom(d0 d0Var) {
                if (d0Var instanceof TicautoLog) {
                    return mergeFrom((TicautoLog) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            public Builder mergeFrom(TicautoLog ticautoLog) {
                if (ticautoLog == TicautoLog.getDefaultInstance()) {
                    return this;
                }
                if (!ticautoLog.getSource().isEmpty()) {
                    this.source_ = ticautoLog.source_;
                    onChanged();
                }
                if (!ticautoLog.getSubsource().isEmpty()) {
                    this.subsource_ = ticautoLog.subsource_;
                    onChanged();
                }
                if (!ticautoLog.getPackageName().isEmpty()) {
                    this.packageName_ = ticautoLog.packageName_;
                    onChanged();
                }
                if (ticautoLog.getHappenedAt() != 0) {
                    setHappenedAt(ticautoLog.getHappenedAt());
                }
                if (!ticautoLog.getCrashlog().isEmpty()) {
                    this.crashlog_ = ticautoLog.crashlog_;
                    onChanged();
                }
                if (!ticautoLog.getVersion().isEmpty()) {
                    this.version_ = ticautoLog.version_;
                    onChanged();
                }
                if (!ticautoLog.getImei().isEmpty()) {
                    this.imei_ = ticautoLog.imei_;
                    onChanged();
                }
                if (!ticautoLog.getWwid().isEmpty()) {
                    this.wwid_ = ticautoLog.wwid_;
                    onChanged();
                }
                if (!ticautoLog.getDeviceId().isEmpty()) {
                    this.deviceId_ = ticautoLog.deviceId_;
                    onChanged();
                }
                onChanged();
                return this;
            }

            private Builder(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.source_ = "";
                this.subsource_ = "";
                this.packageName_ = "";
                this.crashlog_ = "";
                this.version_ = "";
                this.imei_ = "";
                this.wwid_ = "";
                this.deviceId_ = "";
                maybeForceBuilderInitialization();
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x0023  */
            @Override // com.google.protobuf.a.AbstractC0170a, com.google.protobuf.b.a, com.google.protobuf.e0.a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(i iVar, q qVar) throws IOException {
                Throwable th2;
                TicautoLog ticautoLog = null;
                try {
                    try {
                        TicautoLog ticautoLog2 = (TicautoLog) TicautoLog.PARSER.parsePartialFrom(iVar, qVar);
                        if (ticautoLog2 != null) {
                            mergeFrom(ticautoLog2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e10) {
                        ticautoLog = (TicautoLog) e10.getUnfinishedMessage();
                        try {
                            throw e10.unwrapIOException();
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (ticautoLog != null) {
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (ticautoLog != null) {
                        mergeFrom(ticautoLog);
                    }
                    throw th2;
                }
            }
        }

        public static Builder newBuilder(TicautoLog ticautoLog) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(ticautoLog);
        }

        public static TicautoLog parseFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, qVar);
        }

        private TicautoLog(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static TicautoLog parseDelimitedFrom(InputStream inputStream, q qVar) throws IOException {
            return (TicautoLog) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
        }

        public static TicautoLog parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
        public TicautoLog getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static TicautoLog parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder newBuilderForType() {
            return newBuilder();
        }

        private TicautoLog() {
            this.memoizedIsInitialized = (byte) -1;
            this.source_ = "";
            this.subsource_ = "";
            this.packageName_ = "";
            this.happenedAt_ = 0L;
            this.crashlog_ = "";
            this.version_ = "";
            this.imei_ = "";
            this.wwid_ = "";
            this.deviceId_ = "";
        }

        public static TicautoLog parseFrom(InputStream inputStream) throws IOException {
            return (TicautoLog) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.c cVar) {
            return new Builder(cVar);
        }

        public static TicautoLog parseFrom(InputStream inputStream, q qVar) throws IOException {
            return (TicautoLog) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
        }

        public static TicautoLog parseFrom(i iVar) throws IOException {
            return (TicautoLog) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
        }

        public static TicautoLog parseFrom(i iVar, q qVar) throws IOException {
            return (TicautoLog) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
        }

        private TicautoLog(i iVar, q qVar) throws InvalidProtocolBufferException {
            this();
            boolean z10 = false;
            while (!z10) {
                try {
                    try {
                        int F = iVar.F();
                        z10 = true;
                        if (F != 0) {
                            if (F == 10) {
                                this.source_ = iVar.E();
                            } else if (F == 18) {
                                this.subsource_ = iVar.E();
                            } else if (F == 26) {
                                this.packageName_ = iVar.E();
                            } else if (F == 32) {
                                this.happenedAt_ = iVar.u();
                            } else if (F == 42) {
                                this.crashlog_ = iVar.E();
                            } else if (F == 50) {
                                this.version_ = iVar.E();
                            } else if (F == 58) {
                                this.imei_ = iVar.E();
                            } else if (F == 66) {
                                this.wwid_ = iVar.E();
                            } else if (F == 74) {
                                this.deviceId_ = iVar.E();
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
    public interface TicautoLogOrBuilder extends g0 {
        /* synthetic */ List<String> findInitializationErrors();

        @Override // com.google.protobuf.g0
        /* synthetic */ Map<Descriptors.FieldDescriptor, Object> getAllFields();

        String getCrashlog();

        ByteString getCrashlogBytes();

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

        long getHappenedAt();

        String getImei();

        ByteString getImeiBytes();

        /* synthetic */ String getInitializationErrorString();

        /* synthetic */ Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.h hVar);

        String getPackageName();

        ByteString getPackageNameBytes();

        /* synthetic */ Object getRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i10);

        /* synthetic */ int getRepeatedFieldCount(Descriptors.FieldDescriptor fieldDescriptor);

        String getSource();

        ByteString getSourceBytes();

        String getSubsource();

        ByteString getSubsourceBytes();

        @Override // com.google.protobuf.g0
        /* synthetic */ a1 getUnknownFields();

        String getVersion();

        ByteString getVersionBytes();

        String getWwid();

        ByteString getWwidBytes();

        @Override // com.google.protobuf.g0
        /* synthetic */ boolean hasField(Descriptors.FieldDescriptor fieldDescriptor);

        /* synthetic */ boolean hasOneof(Descriptors.h hVar);

        @Override // com.google.protobuf.f0
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes2.dex */
    public static final class TicautoLogs extends GeneratedMessageV3 implements TicautoLogsOrBuilder {
        public static final int DATA_FIELD_NUMBER = 1;
        private static final TicautoLogs DEFAULT_INSTANCE = new TicautoLogs();
        private static final l0<TicautoLogs> PARSER = new c<TicautoLogs>() { // from class: com.mobvoi.companion.FeedbackProto.TicautoLogs.1
            @Override // com.google.protobuf.l0
            public TicautoLogs parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
                return new TicautoLogs(iVar, qVar);
            }
        };
        private static final long serialVersionUID = 0;
        private List<TicautoLog> data_;
        private byte memoizedIsInitialized;

        public static TicautoLogs getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return FeedbackProto.internal_static_feedbackhub_TicautoLogs_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static TicautoLogs parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (TicautoLogs) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static TicautoLogs parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static l0<TicautoLogs> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof TicautoLogs)) {
                return super.equals(obj);
            }
            return getDataList().equals(((TicautoLogs) obj).getDataList());
        }

        @Override // com.mobvoi.companion.FeedbackProto.TicautoLogsOrBuilder
        public TicautoLog getData(int i10) {
            return this.data_.get(i10);
        }

        @Override // com.mobvoi.companion.FeedbackProto.TicautoLogsOrBuilder
        public int getDataCount() {
            return this.data_.size();
        }

        @Override // com.mobvoi.companion.FeedbackProto.TicautoLogsOrBuilder
        public List<TicautoLog> getDataList() {
            return this.data_;
        }

        @Override // com.mobvoi.companion.FeedbackProto.TicautoLogsOrBuilder
        public TicautoLogOrBuilder getDataOrBuilder(int i10) {
            return this.data_.get(i10);
        }

        @Override // com.mobvoi.companion.FeedbackProto.TicautoLogsOrBuilder
        public List<? extends TicautoLogOrBuilder> getDataOrBuilderList() {
            return this.data_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public l0<TicautoLogs> getParserForType() {
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
            return FeedbackProto.internal_static_feedbackhub_TicautoLogs_fieldAccessorTable.e(TicautoLogs.class, Builder.class);
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
        public static final class Builder extends GeneratedMessageV3.b<Builder> implements TicautoLogsOrBuilder {
            private int bitField0_;
            private o0<TicautoLog, TicautoLog.Builder, TicautoLogOrBuilder> dataBuilder_;
            private List<TicautoLog> data_;

            private void ensureDataIsMutable() {
                if ((this.bitField0_ & 1) != 1) {
                    this.data_ = new ArrayList(this.data_);
                    this.bitField0_ |= 1;
                }
            }

            private o0<TicautoLog, TicautoLog.Builder, TicautoLogOrBuilder> getDataFieldBuilder() {
                if (this.dataBuilder_ == null) {
                    List<TicautoLog> list = this.data_;
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
                return FeedbackProto.internal_static_feedbackhub_TicautoLogs_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                    getDataFieldBuilder();
                }
            }

            public Builder addAllData(Iterable<? extends TicautoLog> iterable) {
                o0<TicautoLog, TicautoLog.Builder, TicautoLogOrBuilder> o0Var = this.dataBuilder_;
                if (o0Var == null) {
                    ensureDataIsMutable();
                    b.a.addAll(iterable, this.data_);
                    onChanged();
                } else {
                    o0Var.b(iterable);
                }
                return this;
            }

            public Builder addData(TicautoLog ticautoLog) {
                o0<TicautoLog, TicautoLog.Builder, TicautoLogOrBuilder> o0Var = this.dataBuilder_;
                if (o0Var == null) {
                    Objects.requireNonNull(ticautoLog);
                    ensureDataIsMutable();
                    this.data_.add(ticautoLog);
                    onChanged();
                } else {
                    o0Var.f(ticautoLog);
                }
                return this;
            }

            public TicautoLog.Builder addDataBuilder() {
                return getDataFieldBuilder().d(TicautoLog.getDefaultInstance());
            }

            public Builder clearData() {
                o0<TicautoLog, TicautoLog.Builder, TicautoLogOrBuilder> o0Var = this.dataBuilder_;
                if (o0Var == null) {
                    this.data_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    o0Var.h();
                }
                return this;
            }

            @Override // com.mobvoi.companion.FeedbackProto.TicautoLogsOrBuilder
            public TicautoLog getData(int i10) {
                o0<TicautoLog, TicautoLog.Builder, TicautoLogOrBuilder> o0Var = this.dataBuilder_;
                if (o0Var == null) {
                    return this.data_.get(i10);
                }
                return o0Var.o(i10);
            }

            public TicautoLog.Builder getDataBuilder(int i10) {
                return getDataFieldBuilder().l(i10);
            }

            public List<TicautoLog.Builder> getDataBuilderList() {
                return getDataFieldBuilder().m();
            }

            @Override // com.mobvoi.companion.FeedbackProto.TicautoLogsOrBuilder
            public int getDataCount() {
                o0<TicautoLog, TicautoLog.Builder, TicautoLogOrBuilder> o0Var = this.dataBuilder_;
                if (o0Var == null) {
                    return this.data_.size();
                }
                return o0Var.n();
            }

            @Override // com.mobvoi.companion.FeedbackProto.TicautoLogsOrBuilder
            public List<TicautoLog> getDataList() {
                o0<TicautoLog, TicautoLog.Builder, TicautoLogOrBuilder> o0Var = this.dataBuilder_;
                if (o0Var == null) {
                    return Collections.unmodifiableList(this.data_);
                }
                return o0Var.q();
            }

            @Override // com.mobvoi.companion.FeedbackProto.TicautoLogsOrBuilder
            public TicautoLogOrBuilder getDataOrBuilder(int i10) {
                o0<TicautoLog, TicautoLog.Builder, TicautoLogOrBuilder> o0Var = this.dataBuilder_;
                if (o0Var == null) {
                    return this.data_.get(i10);
                }
                return o0Var.r(i10);
            }

            @Override // com.mobvoi.companion.FeedbackProto.TicautoLogsOrBuilder
            public List<? extends TicautoLogOrBuilder> getDataOrBuilderList() {
                o0<TicautoLog, TicautoLog.Builder, TicautoLogOrBuilder> o0Var = this.dataBuilder_;
                if (o0Var != null) {
                    return o0Var.s();
                }
                return Collections.unmodifiableList(this.data_);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a, com.google.protobuf.g0
            public Descriptors.b getDescriptorForType() {
                return FeedbackProto.internal_static_feedbackhub_TicautoLogs_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return FeedbackProto.internal_static_feedbackhub_TicautoLogs_fieldAccessorTable.e(TicautoLogs.class, Builder.class);
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
                o0<TicautoLog, TicautoLog.Builder, TicautoLogOrBuilder> o0Var = this.dataBuilder_;
                if (o0Var == null) {
                    ensureDataIsMutable();
                    this.data_.remove(i10);
                    onChanged();
                } else {
                    o0Var.w(i10);
                }
                return this;
            }

            public Builder setData(int i10, TicautoLog ticautoLog) {
                o0<TicautoLog, TicautoLog.Builder, TicautoLogOrBuilder> o0Var = this.dataBuilder_;
                if (o0Var == null) {
                    Objects.requireNonNull(ticautoLog);
                    ensureDataIsMutable();
                    this.data_.set(i10, ticautoLog);
                    onChanged();
                } else {
                    o0Var.x(i10, ticautoLog);
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
            public TicautoLogs build() {
                TicautoLogs buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) buildPartial);
            }

            @Override // com.google.protobuf.e0.a, com.google.protobuf.d0.a
            public TicautoLogs buildPartial() {
                TicautoLogs ticautoLogs = new TicautoLogs(this);
                int i10 = this.bitField0_;
                o0<TicautoLog, TicautoLog.Builder, TicautoLogOrBuilder> o0Var = this.dataBuilder_;
                if (o0Var == null) {
                    if ((i10 & 1) == 1) {
                        this.data_ = Collections.unmodifiableList(this.data_);
                        this.bitField0_ &= -2;
                    }
                    ticautoLogs.data_ = this.data_;
                } else {
                    ticautoLogs.data_ = o0Var.g();
                }
                onBuilt();
                return ticautoLogs;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.f0, com.google.protobuf.g0
            public TicautoLogs getDefaultInstanceForType() {
                return TicautoLogs.getDefaultInstance();
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

            public TicautoLog.Builder addDataBuilder(int i10) {
                return getDataFieldBuilder().c(i10, TicautoLog.getDefaultInstance());
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a
            public Builder clearOneof(Descriptors.h hVar) {
                return (Builder) super.clearOneof(hVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a
            public Builder clear() {
                super.clear();
                o0<TicautoLog, TicautoLog.Builder, TicautoLogOrBuilder> o0Var = this.dataBuilder_;
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

            public Builder addData(int i10, TicautoLog ticautoLog) {
                o0<TicautoLog, TicautoLog.Builder, TicautoLogOrBuilder> o0Var = this.dataBuilder_;
                if (o0Var == null) {
                    Objects.requireNonNull(ticautoLog);
                    ensureDataIsMutable();
                    this.data_.add(i10, ticautoLog);
                    onChanged();
                } else {
                    o0Var.e(i10, ticautoLog);
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.a.AbstractC0170a, com.google.protobuf.b.a
            public Builder clone() {
                return (Builder) super.clone();
            }

            @Override // com.google.protobuf.a.AbstractC0170a, com.google.protobuf.d0.a
            public Builder mergeFrom(d0 d0Var) {
                if (d0Var instanceof TicautoLogs) {
                    return mergeFrom((TicautoLogs) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            public Builder setData(int i10, TicautoLog.Builder builder) {
                o0<TicautoLog, TicautoLog.Builder, TicautoLogOrBuilder> o0Var = this.dataBuilder_;
                if (o0Var == null) {
                    ensureDataIsMutable();
                    this.data_.set(i10, builder.build());
                    onChanged();
                } else {
                    o0Var.x(i10, builder.build());
                }
                return this;
            }

            public Builder mergeFrom(TicautoLogs ticautoLogs) {
                if (ticautoLogs == TicautoLogs.getDefaultInstance()) {
                    return this;
                }
                if (this.dataBuilder_ == null) {
                    if (!ticautoLogs.data_.isEmpty()) {
                        if (this.data_.isEmpty()) {
                            this.data_ = ticautoLogs.data_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureDataIsMutable();
                            this.data_.addAll(ticautoLogs.data_);
                        }
                        onChanged();
                    }
                } else if (!ticautoLogs.data_.isEmpty()) {
                    if (this.dataBuilder_.u()) {
                        this.dataBuilder_.i();
                        o0<TicautoLog, TicautoLog.Builder, TicautoLogOrBuilder> o0Var = null;
                        this.dataBuilder_ = null;
                        this.data_ = ticautoLogs.data_;
                        this.bitField0_ &= -2;
                        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                            o0Var = getDataFieldBuilder();
                        }
                        this.dataBuilder_ = o0Var;
                    } else {
                        this.dataBuilder_.b(ticautoLogs.data_);
                    }
                }
                onChanged();
                return this;
            }

            public Builder addData(TicautoLog.Builder builder) {
                o0<TicautoLog, TicautoLog.Builder, TicautoLogOrBuilder> o0Var = this.dataBuilder_;
                if (o0Var == null) {
                    ensureDataIsMutable();
                    this.data_.add(builder.build());
                    onChanged();
                } else {
                    o0Var.f(builder.build());
                }
                return this;
            }

            public Builder addData(int i10, TicautoLog.Builder builder) {
                o0<TicautoLog, TicautoLog.Builder, TicautoLogOrBuilder> o0Var = this.dataBuilder_;
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
                TicautoLogs ticautoLogs = null;
                try {
                    try {
                        TicautoLogs ticautoLogs2 = (TicautoLogs) TicautoLogs.PARSER.parsePartialFrom(iVar, qVar);
                        if (ticautoLogs2 != null) {
                            mergeFrom(ticautoLogs2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e10) {
                        ticautoLogs = (TicautoLogs) e10.getUnfinishedMessage();
                        try {
                            throw e10.unwrapIOException();
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (ticautoLogs != null) {
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (ticautoLogs != null) {
                        mergeFrom(ticautoLogs);
                    }
                    throw th2;
                }
            }
        }

        public static Builder newBuilder(TicautoLogs ticautoLogs) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(ticautoLogs);
        }

        public static TicautoLogs parseFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, qVar);
        }

        private TicautoLogs(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static TicautoLogs parseDelimitedFrom(InputStream inputStream, q qVar) throws IOException {
            return (TicautoLogs) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
        }

        public static TicautoLogs parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
        public TicautoLogs getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static TicautoLogs parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public Builder newBuilderForType() {
            return newBuilder();
        }

        private TicautoLogs() {
            this.memoizedIsInitialized = (byte) -1;
            this.data_ = Collections.emptyList();
        }

        public static TicautoLogs parseFrom(InputStream inputStream) throws IOException {
            return (TicautoLogs) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.c cVar) {
            return new Builder(cVar);
        }

        public static TicautoLogs parseFrom(InputStream inputStream, q qVar) throws IOException {
            return (TicautoLogs) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
        }

        private TicautoLogs(i iVar, q qVar) throws InvalidProtocolBufferException {
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
                                this.data_.add((TicautoLog) iVar.v(TicautoLog.parser(), qVar));
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

        public static TicautoLogs parseFrom(i iVar) throws IOException {
            return (TicautoLogs) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
        }

        public static TicautoLogs parseFrom(i iVar, q qVar) throws IOException {
            return (TicautoLogs) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
        }
    }

    /* loaded from: classes2.dex */
    public interface TicautoLogsOrBuilder extends g0 {
        /* synthetic */ List<String> findInitializationErrors();

        @Override // com.google.protobuf.g0
        /* synthetic */ Map<Descriptors.FieldDescriptor, Object> getAllFields();

        TicautoLog getData(int i10);

        int getDataCount();

        List<TicautoLog> getDataList();

        TicautoLogOrBuilder getDataOrBuilder(int i10);

        List<? extends TicautoLogOrBuilder> getDataOrBuilderList();

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

    static {
        Descriptors.FileDescriptor.q(new String[]{"\n\u001afeedbackhub/feedback.proto\u0012\u000bfeedbackhub\"½\u0001\n\u0007Request\u0012\u0011\n\u0007comment\u0018\u0001 \u0001(\tH\u0000\u00120\n\bfeedback\u0018\u0002 \u0001(\u000b2\u001c.feedbackhub.FeedbackRequestH\u0000\u00120\n\fticauto_logs\u0018\u0003 \u0001(\u000b2\u0018.feedbackhub.TicautoLogsH\u0000\u00123\n\u000efiles_and_info\u0018\u0004 \u0001(\u000b2\u0019.feedbackhub.FilesAndInfoH\u0000B\u0006\n\u0004type\"¯\u0001\n\bResponse\u0012\n\n\u0002ok\u0018\u0003 \u0001(\b\u0012\u000f\n\u0007err_msg\u0018\u0006 \u0001(\t\u0012)\n\bfeedback\u0018\u0004 \u0001(\u000b2\u0015.feedbackhub.FeedbackH\u0000\u0012\u0011\n\u0007oss_url\u0018\u0007 \u0001(\tH\u0000\u0012+\n\tfeedbacks\u0018\b \u0001(\u000b2\u0016.feedbackhub.FeedbacksH\u0000\u0012\u0013\n\tupload_id\u0018\t \u0001(", "\tH\u0000B\u0006\n\u0004type\"ß\u0005\n\u000fFeedbackRequest\u0012\u000e\n\u0006source\u0018\u0001 \u0001(\t\u0012\u0018\n\u0010feedback_content\u0018\u0005 \u0001(\t\u0012\u001f\n\u0017feedback_classification\u0018\u0006 \u0001(\t\u0012B\n\u000battachments\u0018\u0016 \u0003(\u000b2-.feedbackhub.FeedbackRequest.AttachmentsEntry\u00128\n\u0006extras\u0018\u0007 \u0003(\u000b2(.feedbackhub.FeedbackRequest.ExtrasEntry\u0012\f\n\u0004wwid\u0018\u0004 \u0001(\t\u0012\u0011\n\tsubsource\u0018\u0002 \u0001(\t\u0012\u0013\n\u000bhappened_at\u0018\u000f \u0001(\u0003\u0012\u0011\n\tdevice_id\u0018\u0003 \u0001(\t\u0012\u000f\n\u0007contact\u0018\b \u0001(\t\u0012\u0013\n\u000bphone_model\u0018\t \u0001(\t\u0012\u0018\n\u0010phone_os_version\u0018\n \u0001(\t\u0012\u0019\n\u0011companion_version\u0018\u0015 \u0001(\t\u0012\u0013\n\u000b", "watch_model\u0018\u000b \u0001(\t\u0012\u0019\n\u0011watch_device_name\u0018\f \u0001(\t\u0012\u0018\n\u0010watch_os_version\u0018\r \u0001(\t\u0012$\n\u001cfeedback_classification_text\u0018\u000e \u0001(\t\u0012\u0013\n\u000bis_overseas\u0018\u0014 \u0001(\b\u0012\u0018\n\fmirror_model\u0018\u0010 \u0001(\tB\u0002\u0018\u0001\u0012\u001d\n\u0011mirror_os_version\u0018\u0011 \u0001(\tB\u0002\u0018\u0001\u0012#\n\u0017feedback_content_detail\u0018\u0012 \u0001(\tB\u0002\u0018\u0001\u0012\u0019\n\rhotword_extra\u0018\u0013 \u0001(\tB\u0002\u0018\u0001\u001a2\n\u0010AttachmentsEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\t\u0012\r\n\u0005value\u0018\u0002 \u0001(\f:\u00028\u0001\u001a-\n\u000bExtrasEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\t\u0012\r\n\u0005value\u0018\u0002 \u0001(\t:\u00028\u0001\"\u0083\u0002\n\bFeedback\u0012\n\n\u0002id\u0018\u000b \u0001(\u0005\u0012\u0012\n\ncreated_at\u0018\f \u0001(\u0003\u0012\f\n\u0004ww", "id\u0018\u0001 \u0001(\t\u0012\u000e\n\u0006source\u0018\u0006 \u0001(\t\u0012\u0011\n\tsubsource\u0018\u0007 \u0001(\t\u0012\u0014\n\fjira_created\u0018\t \u0001(\b\u0012\u0016\n\u000ejira_issue_key\u0018\n \u0001(\t\u0012\u0018\n\u0010user_description\u0018\r \u0001(\t\u0012\u0012\n\nissue_main\u0018\u000e \u0001(\t\u0012\u0011\n\tissue_sub\u0018\u000f \u0001(\t\u0012\u0013\n\u000bjira_status\u0018\u0010 \u0001(\t\u0012\u000f\n\u0007deleted\u0018\u0011 \u0001(\b\u0012\u0011\n\tdevice_id\u0018\u0012 \u0001(\t\"0\n\tFeedbacks\u0012#\n\u0004data\u0018\u0001 \u0003(\u000b2\u0015.feedbackhub.Feedback\"¬\u0001\n\nTicautoLog\u0012\u000e\n\u0006source\u0018\u0001 \u0001(\t\u0012\u0011\n\tsubsource\u0018\u0002 \u0001(\t\u0012\u0014\n\fpackage_name\u0018\u0003 \u0001(\t\u0012\u0013\n\u000bhappened_at\u0018\u0004 \u0001(\u0003\u0012\u0010\n\bcrashlog\u0018\u0005 \u0001(\t\u0012\u000f\n\u0007version\u0018\u0006 \u0001(\t\u0012\f\n\u0004imei\u0018\u0007 ", "\u0001(\t\u0012\f\n\u0004wwid\u0018\b \u0001(\t\u0012\u0011\n\tdevice_id\u0018\t \u0001(\t\"4\n\u000bTicautoLogs\u0012%\n\u0004data\u0018\u0001 \u0003(\u000b2\u0017.feedbackhub.TicautoLog\"Ñ\u0001\n\fFilesAndInfo\u00123\n\u0005files\u0018\u0001 \u0003(\u000b2$.feedbackhub.FilesAndInfo.FilesEntry\u00121\n\u0004info\u0018\u0002 \u0003(\u000b2#.feedbackhub.FilesAndInfo.InfoEntry\u001a,\n\nFilesEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\t\u0012\r\n\u0005value\u0018\u0002 \u0001(\f:\u00028\u0001\u001a+\n\tInfoEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\t\u0012\r\n\u0005value\u0018\u0002 \u0001(\t:\u00028\u0001B%\n\u0014com.mobvoi.companionB\rFeedbackProtob\u0006proto3"}, new Descriptors.FileDescriptor[0], new Descriptors.FileDescriptor.a() { // from class: com.mobvoi.companion.FeedbackProto.1
            @Override // com.google.protobuf.Descriptors.FileDescriptor.a
            public o assignDescriptors(Descriptors.FileDescriptor fileDescriptor) {
                Descriptors.FileDescriptor unused = FeedbackProto.descriptor = fileDescriptor;
                return null;
            }
        });
        Descriptors.b bVar = getDescriptor().j().get(0);
        internal_static_feedbackhub_Request_descriptor = bVar;
        internal_static_feedbackhub_Request_fieldAccessorTable = new GeneratedMessageV3.e(bVar, new String[]{"Comment", "Feedback", "TicautoLogs", "FilesAndInfo", "Type"});
        Descriptors.b bVar2 = getDescriptor().j().get(1);
        internal_static_feedbackhub_Response_descriptor = bVar2;
        internal_static_feedbackhub_Response_fieldAccessorTable = new GeneratedMessageV3.e(bVar2, new String[]{"Ok", "ErrMsg", "Feedback", "OssUrl", "Feedbacks", "UploadId", "Type"});
        Descriptors.b bVar3 = getDescriptor().j().get(2);
        internal_static_feedbackhub_FeedbackRequest_descriptor = bVar3;
        internal_static_feedbackhub_FeedbackRequest_fieldAccessorTable = new GeneratedMessageV3.e(bVar3, new String[]{"Source", "FeedbackContent", "FeedbackClassification", "Attachments", "Extras", "Wwid", "Subsource", "HappenedAt", "DeviceId", "Contact", "PhoneModel", "PhoneOsVersion", "CompanionVersion", "WatchModel", "WatchDeviceName", "WatchOsVersion", "FeedbackClassificationText", "IsOverseas", "MirrorModel", "MirrorOsVersion", "FeedbackContentDetail", "HotwordExtra"});
        Descriptors.b bVar4 = bVar3.m().get(0);
        internal_static_feedbackhub_FeedbackRequest_AttachmentsEntry_descriptor = bVar4;
        internal_static_feedbackhub_FeedbackRequest_AttachmentsEntry_fieldAccessorTable = new GeneratedMessageV3.e(bVar4, new String[]{"Key", "Value"});
        Descriptors.b bVar5 = bVar3.m().get(1);
        internal_static_feedbackhub_FeedbackRequest_ExtrasEntry_descriptor = bVar5;
        internal_static_feedbackhub_FeedbackRequest_ExtrasEntry_fieldAccessorTable = new GeneratedMessageV3.e(bVar5, new String[]{"Key", "Value"});
        Descriptors.b bVar6 = getDescriptor().j().get(3);
        internal_static_feedbackhub_Feedback_descriptor = bVar6;
        internal_static_feedbackhub_Feedback_fieldAccessorTable = new GeneratedMessageV3.e(bVar6, new String[]{"Id", "CreatedAt", "Wwid", "Source", "Subsource", "JiraCreated", "JiraIssueKey", "UserDescription", "IssueMain", "IssueSub", "JiraStatus", "Deleted", "DeviceId"});
        Descriptors.b bVar7 = getDescriptor().j().get(4);
        internal_static_feedbackhub_Feedbacks_descriptor = bVar7;
        internal_static_feedbackhub_Feedbacks_fieldAccessorTable = new GeneratedMessageV3.e(bVar7, new String[]{"Data"});
        Descriptors.b bVar8 = getDescriptor().j().get(5);
        internal_static_feedbackhub_TicautoLog_descriptor = bVar8;
        internal_static_feedbackhub_TicautoLog_fieldAccessorTable = new GeneratedMessageV3.e(bVar8, new String[]{"Source", "Subsource", "PackageName", "HappenedAt", "Crashlog", "Version", "Imei", "Wwid", "DeviceId"});
        Descriptors.b bVar9 = getDescriptor().j().get(6);
        internal_static_feedbackhub_TicautoLogs_descriptor = bVar9;
        internal_static_feedbackhub_TicautoLogs_fieldAccessorTable = new GeneratedMessageV3.e(bVar9, new String[]{"Data"});
        Descriptors.b bVar10 = getDescriptor().j().get(7);
        internal_static_feedbackhub_FilesAndInfo_descriptor = bVar10;
        internal_static_feedbackhub_FilesAndInfo_fieldAccessorTable = new GeneratedMessageV3.e(bVar10, new String[]{"Files", "Info"});
        Descriptors.b bVar11 = bVar10.m().get(0);
        internal_static_feedbackhub_FilesAndInfo_FilesEntry_descriptor = bVar11;
        internal_static_feedbackhub_FilesAndInfo_FilesEntry_fieldAccessorTable = new GeneratedMessageV3.e(bVar11, new String[]{"Key", "Value"});
        Descriptors.b bVar12 = bVar10.m().get(1);
        internal_static_feedbackhub_FilesAndInfo_InfoEntry_descriptor = bVar12;
        internal_static_feedbackhub_FilesAndInfo_InfoEntry_fieldAccessorTable = new GeneratedMessageV3.e(bVar12, new String[]{"Key", "Value"});
    }

    private FeedbackProto() {
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
