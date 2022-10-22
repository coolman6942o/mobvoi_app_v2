package com.mobvoi.assistant.data.network.model;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.WireFormat;
import com.google.protobuf.a;
import com.google.protobuf.a0;
import com.google.protobuf.a1;
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

    /* renamed from: a  reason: collision with root package name */
    private static final Descriptors.b f15743a;

    /* renamed from: b  reason: collision with root package name */
    private static final GeneratedMessageV3.e f15744b;

    /* renamed from: c  reason: collision with root package name */
    private static final Descriptors.b f15745c;

    /* renamed from: d  reason: collision with root package name */
    private static final GeneratedMessageV3.e f15746d;

    /* renamed from: e  reason: collision with root package name */
    private static final Descriptors.b f15747e;

    /* renamed from: f  reason: collision with root package name */
    private static final GeneratedMessageV3.e f15748f;

    /* renamed from: g  reason: collision with root package name */
    private static final Descriptors.b f15749g;

    /* renamed from: h  reason: collision with root package name */
    private static final Descriptors.b f15750h;

    /* renamed from: i  reason: collision with root package name */
    private static final Descriptors.b f15751i;

    /* renamed from: j  reason: collision with root package name */
    private static final GeneratedMessageV3.e f15752j;

    /* renamed from: k  reason: collision with root package name */
    private static final Descriptors.b f15753k;

    /* renamed from: l  reason: collision with root package name */
    private static final GeneratedMessageV3.e f15754l;

    /* renamed from: m  reason: collision with root package name */
    private static final Descriptors.b f15755m;

    /* renamed from: n  reason: collision with root package name */
    private static final GeneratedMessageV3.e f15756n;

    /* renamed from: o  reason: collision with root package name */
    private static Descriptors.FileDescriptor f15757o;

    /* loaded from: classes2.dex */
    public static final class Feedback extends GeneratedMessageV3 implements c {
        public static final int CREATED_AT_FIELD_NUMBER = 12;
        public static final int ID_FIELD_NUMBER = 11;
        public static final int JIRA_CREATED_FIELD_NUMBER = 9;
        public static final int JIRA_ISSUE_KEY_FIELD_NUMBER = 10;
        public static final int SOURCE_FIELD_NUMBER = 6;
        public static final int SUBSOURCE_FIELD_NUMBER = 7;
        public static final int WWID_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private long createdAt_;
        private int id_;
        private boolean jiraCreated_;
        private volatile Object jiraIssueKey_;
        private byte memoizedIsInitialized;
        private volatile Object source_;
        private volatile Object subsource_;
        private volatile Object wwid_;
        private static final Feedback DEFAULT_INSTANCE = new Feedback();
        private static final l0<Feedback> PARSER = new a();

        /* loaded from: classes2.dex */
        class a extends com.google.protobuf.c<Feedback> {
            a() {
            }

            /* renamed from: a */
            public Feedback parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
                return new Feedback(iVar, qVar, null);
            }
        }

        /* loaded from: classes2.dex */
        public static final class b extends GeneratedMessageV3.b<b> implements c {

            /* renamed from: a  reason: collision with root package name */
            private int f15758a;

            /* renamed from: b  reason: collision with root package name */
            private long f15759b;

            /* renamed from: c  reason: collision with root package name */
            private Object f15760c;

            /* renamed from: d  reason: collision with root package name */
            private Object f15761d;

            /* renamed from: e  reason: collision with root package name */
            private Object f15762e;

            /* renamed from: f  reason: collision with root package name */
            private boolean f15763f;

            /* renamed from: g  reason: collision with root package name */
            private Object f15764g;

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
            public Feedback build() {
                Feedback c10 = buildPartial();
                if (c10.isInitialized()) {
                    return c10;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) c10);
            }

            /* renamed from: c */
            public Feedback buildPartial() {
                Feedback feedback = new Feedback(this, (a) null);
                feedback.id_ = this.f15758a;
                feedback.createdAt_ = this.f15759b;
                feedback.wwid_ = this.f15760c;
                feedback.source_ = this.f15761d;
                feedback.subsource_ = this.f15762e;
                feedback.jiraCreated_ = this.f15763f;
                feedback.jiraIssueKey_ = this.f15764g;
                onBuilt();
                return feedback;
            }

            /* renamed from: d */
            public b clear() {
                super.clear();
                this.f15758a = 0;
                this.f15759b = 0L;
                this.f15760c = "";
                this.f15761d = "";
                this.f15762e = "";
                this.f15763f = false;
                this.f15764g = "";
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
                return FeedbackProto.f15751i;
            }

            /* renamed from: i */
            public Feedback getDefaultInstanceForType() {
                return Feedback.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return FeedbackProto.f15752j.e(Feedback.class, b.class);
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
                Feedback feedback = null;
                try {
                    try {
                        Feedback feedback2 = (Feedback) Feedback.PARSER.parsePartialFrom(iVar, qVar);
                        if (feedback2 != null) {
                            l(feedback2);
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
                        l(feedback);
                    }
                    throw th2;
                }
            }

            /* renamed from: k */
            public b mergeFrom(d0 d0Var) {
                if (d0Var instanceof Feedback) {
                    return l((Feedback) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            public b l(Feedback feedback) {
                if (feedback == Feedback.getDefaultInstance()) {
                    return this;
                }
                if (feedback.getId() != 0) {
                    p(feedback.getId());
                }
                if (feedback.getCreatedAt() != 0) {
                    n(feedback.getCreatedAt());
                }
                if (!feedback.getWwid().isEmpty()) {
                    this.f15760c = feedback.wwid_;
                    onChanged();
                }
                if (!feedback.getSource().isEmpty()) {
                    this.f15761d = feedback.source_;
                    onChanged();
                }
                if (!feedback.getSubsource().isEmpty()) {
                    this.f15762e = feedback.subsource_;
                    onChanged();
                }
                if (feedback.getJiraCreated()) {
                    q(feedback.getJiraCreated());
                }
                if (!feedback.getJiraIssueKey().isEmpty()) {
                    this.f15764g = feedback.jiraIssueKey_;
                    onChanged();
                }
                onChanged();
                return this;
            }

            /* renamed from: m */
            public final b mergeUnknownFields(a1 a1Var) {
                return this;
            }

            public b n(long j10) {
                this.f15759b = j10;
                onChanged();
                return this;
            }

            /* renamed from: o */
            public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.setField(fieldDescriptor, obj);
            }

            public b p(int i10) {
                this.f15758a = i10;
                onChanged();
                return this;
            }

            public b q(boolean z10) {
                this.f15763f = z10;
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
                this.f15760c = "";
                this.f15761d = "";
                this.f15762e = "";
                this.f15764g = "";
                maybeForceBuilderInitialization();
            }

            private b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.f15760c = "";
                this.f15761d = "";
                this.f15762e = "";
                this.f15764g = "";
                maybeForceBuilderInitialization();
            }
        }

        /* synthetic */ Feedback(i iVar, q qVar, a aVar) throws InvalidProtocolBufferException {
            this(iVar, qVar);
        }

        public static Feedback getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return FeedbackProto.f15751i;
        }

        public static b newBuilder() {
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
            return ((((((getId() == feedback.getId()) && (getCreatedAt() > feedback.getCreatedAt() ? 1 : (getCreatedAt() == feedback.getCreatedAt() ? 0 : -1)) == 0) && getWwid().equals(feedback.getWwid())) && getSource().equals(feedback.getSource())) && getSubsource().equals(feedback.getSubsource())) && getJiraCreated() == feedback.getJiraCreated()) && getJiraIssueKey().equals(feedback.getJiraIssueKey());
        }

        public long getCreatedAt() {
            return this.createdAt_;
        }

        public int getId() {
            return this.id_;
        }

        public boolean getJiraCreated() {
            return this.jiraCreated_;
        }

        public String getJiraIssueKey() {
            Object obj = this.jiraIssueKey_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.jiraIssueKey_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getJiraIssueKeyBytes() {
            Object obj = this.jiraIssueKey_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.jiraIssueKey_ = copyFromUtf8;
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

        public String getSubsource() {
            Object obj = this.subsource_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.subsource_ = stringUtf8;
            return stringUtf8;
        }

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
            int hashCode = ((((((((((((((((((((((((((((((779 + getDescriptorForType().hashCode()) * 37) + 11) * 53) + getId()) * 37) + 12) * 53) + u.h(getCreatedAt())) * 37) + 1) * 53) + getWwid().hashCode()) * 37) + 6) * 53) + getSource().hashCode()) * 37) + 7) * 53) + getSubsource().hashCode()) * 37) + 9) * 53) + u.c(getJiraCreated())) * 37) + 10) * 53) + getJiraIssueKey().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return FeedbackProto.f15752j.e(Feedback.class, b.class);
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
        /* renamed from: p */
        public b newBuilderForType(GeneratedMessageV3.c cVar) {
            return new b(cVar, null);
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
        }

        /* synthetic */ Feedback(GeneratedMessageV3.b bVar, a aVar) {
            this(bVar);
        }

        public static b newBuilder(Feedback feedback) {
            return DEFAULT_INSTANCE.toBuilder().l(feedback);
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
        public b toBuilder() {
            return this == DEFAULT_INSTANCE ? new b((a) null) : new b((a) null).l(this);
        }

        public static Feedback parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b newBuilderForType() {
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
        }

        public static Feedback parseFrom(InputStream inputStream) throws IOException {
            return (Feedback) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
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
                            if (F != 0) {
                                if (F == 10) {
                                    this.wwid_ = iVar.E();
                                } else if (F == 50) {
                                    this.source_ = iVar.E();
                                } else if (F == 58) {
                                    this.subsource_ = iVar.E();
                                } else if (F == 72) {
                                    this.jiraCreated_ = iVar.l();
                                } else if (F == 82) {
                                    this.jiraIssueKey_ = iVar.E();
                                } else if (F == 88) {
                                    this.id_ = iVar.t();
                                } else if (F == 96) {
                                    this.createdAt_ = iVar.u();
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
    public static final class FeedbackRequest extends GeneratedMessageV3 implements d {
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
        private static final l0<FeedbackRequest> PARSER = new a();

        /* loaded from: classes2.dex */
        class a extends com.google.protobuf.c<FeedbackRequest> {
            a() {
            }

            /* renamed from: a */
            public FeedbackRequest parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
                return new FeedbackRequest(iVar, qVar, null);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes2.dex */
        public static final class b {

            /* renamed from: a  reason: collision with root package name */
            static final a0<String, ByteString> f15765a = a0.l(FeedbackProto.f15749g, WireFormat.FieldType.STRING, "", WireFormat.FieldType.BYTES, ByteString.EMPTY);
        }

        /* loaded from: classes2.dex */
        public static final class c extends GeneratedMessageV3.b<c> implements d {

            /* renamed from: a  reason: collision with root package name */
            private Object f15766a;

            /* renamed from: b  reason: collision with root package name */
            private Object f15767b;

            /* renamed from: c  reason: collision with root package name */
            private Object f15768c;

            /* renamed from: d  reason: collision with root package name */
            private Object f15769d;

            /* renamed from: e  reason: collision with root package name */
            private c0<String, ByteString> f15770e;

            /* renamed from: f  reason: collision with root package name */
            private c0<String, String> f15771f;

            /* renamed from: g  reason: collision with root package name */
            private Object f15772g;

            /* renamed from: h  reason: collision with root package name */
            private Object f15773h;

            /* renamed from: i  reason: collision with root package name */
            private Object f15774i;

            /* renamed from: j  reason: collision with root package name */
            private Object f15775j;

            /* renamed from: k  reason: collision with root package name */
            private Object f15776k;

            /* renamed from: l  reason: collision with root package name */
            private Object f15777l;

            /* renamed from: m  reason: collision with root package name */
            private Object f15778m;

            /* renamed from: n  reason: collision with root package name */
            private Object f15779n;

            /* renamed from: o  reason: collision with root package name */
            private Object f15780o;

            /* renamed from: p  reason: collision with root package name */
            private long f15781p;

            /* renamed from: q  reason: collision with root package name */
            private boolean f15782q;

            /* renamed from: r  reason: collision with root package name */
            private Object f15783r;

            /* renamed from: s  reason: collision with root package name */
            private Object f15784s;

            /* renamed from: t  reason: collision with root package name */
            private Object f15785t;

            /* renamed from: u  reason: collision with root package name */
            private Object f15786u;

            /* renamed from: v  reason: collision with root package name */
            private Object f15787v;

            /* synthetic */ c(GeneratedMessageV3.c cVar, a aVar) {
                this(cVar);
            }

            private c0<String, ByteString> internalGetAttachments() {
                c0<String, ByteString> c0Var = this.f15770e;
                return c0Var == null ? c0.h(b.f15765a) : c0Var;
            }

            private c0<String, String> internalGetExtras() {
                c0<String, String> c0Var = this.f15771f;
                return c0Var == null ? c0.h(d.f15788a) : c0Var;
            }

            private c0<String, ByteString> internalGetMutableAttachments() {
                onChanged();
                if (this.f15770e == null) {
                    this.f15770e = c0.q(b.f15765a);
                }
                if (!this.f15770e.n()) {
                    this.f15770e = this.f15770e.g();
                }
                return this.f15770e;
            }

            private c0<String, String> internalGetMutableExtras() {
                onChanged();
                if (this.f15771f == null) {
                    this.f15771f = c0.q(d.f15788a);
                }
                if (!this.f15771f.n()) {
                    this.f15771f = this.f15771f.g();
                }
                return this.f15771f;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            /* renamed from: a */
            public c addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (c) super.addRepeatedField(fieldDescriptor, obj);
            }

            /* renamed from: b */
            public FeedbackRequest build() {
                FeedbackRequest c10 = buildPartial();
                if (c10.isInitialized()) {
                    return c10;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) c10);
            }

            /* renamed from: c */
            public FeedbackRequest buildPartial() {
                FeedbackRequest feedbackRequest = new FeedbackRequest(this, (a) null);
                feedbackRequest.source_ = this.f15766a;
                feedbackRequest.subsource_ = this.f15767b;
                feedbackRequest.feedbackContent_ = this.f15768c;
                feedbackRequest.feedbackClassification_ = this.f15769d;
                feedbackRequest.attachments_ = internalGetAttachments();
                feedbackRequest.attachments_.o();
                feedbackRequest.extras_ = internalGetExtras();
                feedbackRequest.extras_.o();
                feedbackRequest.wwid_ = this.f15772g;
                feedbackRequest.contact_ = this.f15773h;
                feedbackRequest.phoneModel_ = this.f15774i;
                feedbackRequest.phoneOsVersion_ = this.f15775j;
                feedbackRequest.companionVersion_ = this.f15776k;
                feedbackRequest.watchModel_ = this.f15777l;
                feedbackRequest.watchDeviceName_ = this.f15778m;
                feedbackRequest.watchOsVersion_ = this.f15779n;
                feedbackRequest.feedbackClassificationText_ = this.f15780o;
                feedbackRequest.happenedAt_ = this.f15781p;
                feedbackRequest.isOverseas_ = this.f15782q;
                feedbackRequest.deviceId_ = this.f15783r;
                feedbackRequest.mirrorModel_ = this.f15784s;
                feedbackRequest.mirrorOsVersion_ = this.f15785t;
                feedbackRequest.feedbackContentDetail_ = this.f15786u;
                feedbackRequest.hotwordExtra_ = this.f15787v;
                feedbackRequest.bitField0_ = 0;
                onBuilt();
                return feedbackRequest;
            }

            /* renamed from: d */
            public c clear() {
                super.clear();
                this.f15766a = "";
                this.f15767b = "";
                this.f15768c = "";
                this.f15769d = "";
                internalGetMutableAttachments().b();
                internalGetMutableExtras().b();
                this.f15772g = "";
                this.f15773h = "";
                this.f15774i = "";
                this.f15775j = "";
                this.f15776k = "";
                this.f15777l = "";
                this.f15778m = "";
                this.f15779n = "";
                this.f15780o = "";
                this.f15781p = 0L;
                this.f15782q = false;
                this.f15783r = "";
                this.f15784s = "";
                this.f15785t = "";
                this.f15786u = "";
                this.f15787v = "";
                return this;
            }

            /* renamed from: e */
            public c clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (c) super.clearField(fieldDescriptor);
            }

            /* renamed from: f */
            public c clearOneof(Descriptors.h hVar) {
                return (c) super.clearOneof(hVar);
            }

            /* renamed from: g */
            public c clone() {
                return (c) super.clone();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.d0.a, com.google.protobuf.g0
            public Descriptors.b getDescriptorForType() {
                return FeedbackProto.f15747e;
            }

            /* renamed from: i */
            public FeedbackRequest getDefaultInstanceForType() {
                return FeedbackRequest.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return FeedbackProto.f15748f.e(FeedbackRequest.class, c.class);
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

            /* JADX WARN: Removed duplicated region for block: B:15:0x0023  */
            /* renamed from: j */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public c mergeFrom(i iVar, q qVar) throws IOException {
                Throwable th2;
                FeedbackRequest feedbackRequest = null;
                try {
                    try {
                        FeedbackRequest feedbackRequest2 = (FeedbackRequest) FeedbackRequest.PARSER.parsePartialFrom(iVar, qVar);
                        if (feedbackRequest2 != null) {
                            l(feedbackRequest2);
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
                        l(feedbackRequest);
                    }
                    throw th2;
                }
            }

            /* renamed from: k */
            public c mergeFrom(d0 d0Var) {
                if (d0Var instanceof FeedbackRequest) {
                    return l((FeedbackRequest) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            public c l(FeedbackRequest feedbackRequest) {
                if (feedbackRequest == FeedbackRequest.getDefaultInstance()) {
                    return this;
                }
                if (!feedbackRequest.getSource().isEmpty()) {
                    this.f15766a = feedbackRequest.source_;
                    onChanged();
                }
                if (!feedbackRequest.getSubsource().isEmpty()) {
                    this.f15767b = feedbackRequest.subsource_;
                    onChanged();
                }
                if (!feedbackRequest.getFeedbackContent().isEmpty()) {
                    this.f15768c = feedbackRequest.feedbackContent_;
                    onChanged();
                }
                if (!feedbackRequest.getFeedbackClassification().isEmpty()) {
                    this.f15769d = feedbackRequest.feedbackClassification_;
                    onChanged();
                }
                internalGetMutableAttachments().p(feedbackRequest.internalGetAttachments());
                internalGetMutableExtras().p(feedbackRequest.internalGetExtras());
                if (!feedbackRequest.getWwid().isEmpty()) {
                    this.f15772g = feedbackRequest.wwid_;
                    onChanged();
                }
                if (!feedbackRequest.getContact().isEmpty()) {
                    this.f15773h = feedbackRequest.contact_;
                    onChanged();
                }
                if (!feedbackRequest.getPhoneModel().isEmpty()) {
                    this.f15774i = feedbackRequest.phoneModel_;
                    onChanged();
                }
                if (!feedbackRequest.getPhoneOsVersion().isEmpty()) {
                    this.f15775j = feedbackRequest.phoneOsVersion_;
                    onChanged();
                }
                if (!feedbackRequest.getCompanionVersion().isEmpty()) {
                    this.f15776k = feedbackRequest.companionVersion_;
                    onChanged();
                }
                if (!feedbackRequest.getWatchModel().isEmpty()) {
                    this.f15777l = feedbackRequest.watchModel_;
                    onChanged();
                }
                if (!feedbackRequest.getWatchDeviceName().isEmpty()) {
                    this.f15778m = feedbackRequest.watchDeviceName_;
                    onChanged();
                }
                if (!feedbackRequest.getWatchOsVersion().isEmpty()) {
                    this.f15779n = feedbackRequest.watchOsVersion_;
                    onChanged();
                }
                if (!feedbackRequest.getFeedbackClassificationText().isEmpty()) {
                    this.f15780o = feedbackRequest.feedbackClassificationText_;
                    onChanged();
                }
                if (feedbackRequest.getHappenedAt() != 0) {
                    o(feedbackRequest.getHappenedAt());
                }
                if (feedbackRequest.getIsOverseas()) {
                    p(feedbackRequest.getIsOverseas());
                }
                if (!feedbackRequest.getDeviceId().isEmpty()) {
                    this.f15783r = feedbackRequest.deviceId_;
                    onChanged();
                }
                if (!feedbackRequest.getMirrorModel().isEmpty()) {
                    this.f15784s = feedbackRequest.mirrorModel_;
                    onChanged();
                }
                if (!feedbackRequest.getMirrorOsVersion().isEmpty()) {
                    this.f15785t = feedbackRequest.mirrorOsVersion_;
                    onChanged();
                }
                if (!feedbackRequest.getFeedbackContentDetail().isEmpty()) {
                    this.f15786u = feedbackRequest.feedbackContentDetail_;
                    onChanged();
                }
                if (!feedbackRequest.getHotwordExtra().isEmpty()) {
                    this.f15787v = feedbackRequest.hotwordExtra_;
                    onChanged();
                }
                onChanged();
                return this;
            }

            /* renamed from: m */
            public final c mergeUnknownFields(a1 a1Var) {
                return this;
            }

            /* renamed from: n */
            public c setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (c) super.setField(fieldDescriptor, obj);
            }

            public c o(long j10) {
                this.f15781p = j10;
                onChanged();
                return this;
            }

            public c p(boolean z10) {
                this.f15782q = z10;
                onChanged();
                return this;
            }

            /* renamed from: q */
            public c setRepeatedField2(Descriptors.FieldDescriptor fieldDescriptor, int i10, Object obj) {
                return (c) super.setRepeatedField(fieldDescriptor, i10, obj);
            }

            /* renamed from: r */
            public final c setUnknownFields(a1 a1Var) {
                return this;
            }

            /* synthetic */ c(a aVar) {
                this();
            }

            private c() {
                this.f15766a = "";
                this.f15767b = "";
                this.f15768c = "";
                this.f15769d = "";
                this.f15772g = "";
                this.f15773h = "";
                this.f15774i = "";
                this.f15775j = "";
                this.f15776k = "";
                this.f15777l = "";
                this.f15778m = "";
                this.f15779n = "";
                this.f15780o = "";
                this.f15783r = "";
                this.f15784s = "";
                this.f15785t = "";
                this.f15786u = "";
                this.f15787v = "";
                maybeForceBuilderInitialization();
            }

            private c(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.f15766a = "";
                this.f15767b = "";
                this.f15768c = "";
                this.f15769d = "";
                this.f15772g = "";
                this.f15773h = "";
                this.f15774i = "";
                this.f15775j = "";
                this.f15776k = "";
                this.f15777l = "";
                this.f15778m = "";
                this.f15779n = "";
                this.f15780o = "";
                this.f15783r = "";
                this.f15784s = "";
                this.f15785t = "";
                this.f15786u = "";
                this.f15787v = "";
                maybeForceBuilderInitialization();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes2.dex */
        public static final class d {

            /* renamed from: a  reason: collision with root package name */
            static final a0<String, String> f15788a;

            static {
                Descriptors.b bVar = FeedbackProto.f15750h;
                WireFormat.FieldType fieldType = WireFormat.FieldType.STRING;
                f15788a = a0.l(bVar, fieldType, "", fieldType, "");
            }
        }

        /* synthetic */ FeedbackRequest(i iVar, q qVar, a aVar) throws InvalidProtocolBufferException {
            this(iVar, qVar);
        }

        public static FeedbackRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return FeedbackProto.f15747e;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public c0<String, ByteString> internalGetAttachments() {
            c0<String, ByteString> c0Var = this.attachments_;
            return c0Var == null ? c0.h(b.f15765a) : c0Var;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public c0<String, String> internalGetExtras() {
            c0<String, String> c0Var = this.extras_;
            return c0Var == null ? c0.h(d.f15788a) : c0Var;
        }

        public static c newBuilder() {
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

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: X */
        public c newBuilderForType(GeneratedMessageV3.c cVar) {
            return new c(cVar, null);
        }

        public boolean containsAttachments(String str) {
            Objects.requireNonNull(str);
            return internalGetAttachments().j().containsKey(str);
        }

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
            return (((((((((((((((((((((getSource().equals(feedbackRequest.getSource())) && getSubsource().equals(feedbackRequest.getSubsource())) && getFeedbackContent().equals(feedbackRequest.getFeedbackContent())) && getFeedbackClassification().equals(feedbackRequest.getFeedbackClassification())) && internalGetAttachments().equals(feedbackRequest.internalGetAttachments())) && internalGetExtras().equals(feedbackRequest.internalGetExtras())) && getWwid().equals(feedbackRequest.getWwid())) && getContact().equals(feedbackRequest.getContact())) && getPhoneModel().equals(feedbackRequest.getPhoneModel())) && getPhoneOsVersion().equals(feedbackRequest.getPhoneOsVersion())) && getCompanionVersion().equals(feedbackRequest.getCompanionVersion())) && getWatchModel().equals(feedbackRequest.getWatchModel())) && getWatchDeviceName().equals(feedbackRequest.getWatchDeviceName())) && getWatchOsVersion().equals(feedbackRequest.getWatchOsVersion())) && getFeedbackClassificationText().equals(feedbackRequest.getFeedbackClassificationText())) && (getHappenedAt() > feedbackRequest.getHappenedAt() ? 1 : (getHappenedAt() == feedbackRequest.getHappenedAt() ? 0 : -1)) == 0) && getIsOverseas() == feedbackRequest.getIsOverseas()) && getDeviceId().equals(feedbackRequest.getDeviceId())) && getMirrorModel().equals(feedbackRequest.getMirrorModel())) && getMirrorOsVersion().equals(feedbackRequest.getMirrorOsVersion())) && getFeedbackContentDetail().equals(feedbackRequest.getFeedbackContentDetail())) && getHotwordExtra().equals(feedbackRequest.getHotwordExtra());
        }

        @Deprecated
        public Map<String, ByteString> getAttachments() {
            return getAttachmentsMap();
        }

        public int getAttachmentsCount() {
            return internalGetAttachments().j().size();
        }

        public Map<String, ByteString> getAttachmentsMap() {
            return internalGetAttachments().j();
        }

        public ByteString getAttachmentsOrDefault(String str, ByteString byteString) {
            Objects.requireNonNull(str);
            Map<String, ByteString> j10 = internalGetAttachments().j();
            return j10.containsKey(str) ? j10.get(str) : byteString;
        }

        public ByteString getAttachmentsOrThrow(String str) {
            Objects.requireNonNull(str);
            Map<String, ByteString> j10 = internalGetAttachments().j();
            if (j10.containsKey(str)) {
                return j10.get(str);
            }
            throw new IllegalArgumentException();
        }

        public String getCompanionVersion() {
            Object obj = this.companionVersion_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.companionVersion_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getCompanionVersionBytes() {
            Object obj = this.companionVersion_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.companionVersion_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public String getContact() {
            Object obj = this.contact_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.contact_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getContactBytes() {
            Object obj = this.contact_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.contact_ = copyFromUtf8;
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

        @Deprecated
        public Map<String, String> getExtras() {
            return getExtrasMap();
        }

        public int getExtrasCount() {
            return internalGetExtras().j().size();
        }

        public Map<String, String> getExtrasMap() {
            return internalGetExtras().j();
        }

        public String getExtrasOrDefault(String str, String str2) {
            Objects.requireNonNull(str);
            Map<String, String> j10 = internalGetExtras().j();
            return j10.containsKey(str) ? j10.get(str) : str2;
        }

        public String getExtrasOrThrow(String str) {
            Objects.requireNonNull(str);
            Map<String, String> j10 = internalGetExtras().j();
            if (j10.containsKey(str)) {
                return j10.get(str);
            }
            throw new IllegalArgumentException();
        }

        public String getFeedbackClassification() {
            Object obj = this.feedbackClassification_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.feedbackClassification_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getFeedbackClassificationBytes() {
            Object obj = this.feedbackClassification_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.feedbackClassification_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public String getFeedbackClassificationText() {
            Object obj = this.feedbackClassificationText_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.feedbackClassificationText_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getFeedbackClassificationTextBytes() {
            Object obj = this.feedbackClassificationText_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.feedbackClassificationText_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public String getFeedbackContent() {
            Object obj = this.feedbackContent_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.feedbackContent_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getFeedbackContentBytes() {
            Object obj = this.feedbackContent_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.feedbackContent_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public String getFeedbackContentDetail() {
            Object obj = this.feedbackContentDetail_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.feedbackContentDetail_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getFeedbackContentDetailBytes() {
            Object obj = this.feedbackContentDetail_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.feedbackContentDetail_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public long getHappenedAt() {
            return this.happenedAt_;
        }

        public String getHotwordExtra() {
            Object obj = this.hotwordExtra_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.hotwordExtra_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getHotwordExtraBytes() {
            Object obj = this.hotwordExtra_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.hotwordExtra_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public boolean getIsOverseas() {
            return this.isOverseas_;
        }

        public String getMirrorModel() {
            Object obj = this.mirrorModel_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.mirrorModel_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getMirrorModelBytes() {
            Object obj = this.mirrorModel_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.mirrorModel_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public String getMirrorOsVersion() {
            Object obj = this.mirrorOsVersion_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.mirrorOsVersion_ = stringUtf8;
            return stringUtf8;
        }

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

        public String getPhoneModel() {
            Object obj = this.phoneModel_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.phoneModel_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getPhoneModelBytes() {
            Object obj = this.phoneModel_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.phoneModel_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public String getPhoneOsVersion() {
            Object obj = this.phoneOsVersion_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.phoneOsVersion_ = stringUtf8;
            return stringUtf8;
        }

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
                i11 += CodedOutputStream.E(7, d.f15788a.newBuilderForType().n(entry.getKey()).p(entry.getValue()).build());
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
                i11 += CodedOutputStream.E(22, b.f15765a.newBuilderForType().n(entry2.getKey()).p(entry2.getValue()).build());
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

        public String getSubsource() {
            Object obj = this.subsource_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.subsource_ = stringUtf8;
            return stringUtf8;
        }

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

        public String getWatchDeviceName() {
            Object obj = this.watchDeviceName_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.watchDeviceName_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getWatchDeviceNameBytes() {
            Object obj = this.watchDeviceName_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.watchDeviceName_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public String getWatchModel() {
            Object obj = this.watchModel_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.watchModel_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getWatchModelBytes() {
            Object obj = this.watchModel_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.watchModel_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public String getWatchOsVersion() {
            Object obj = this.watchOsVersion_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.watchOsVersion_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getWatchOsVersionBytes() {
            Object obj = this.watchOsVersion_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.watchOsVersion_ = copyFromUtf8;
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
            int hashCode = ((((((((((((((((779 + getDescriptorForType().hashCode()) * 37) + 1) * 53) + getSource().hashCode()) * 37) + 2) * 53) + getSubsource().hashCode()) * 37) + 5) * 53) + getFeedbackContent().hashCode()) * 37) + 6) * 53) + getFeedbackClassification().hashCode();
            if (!internalGetAttachments().j().isEmpty()) {
                hashCode = (((hashCode * 37) + 22) * 53) + internalGetAttachments().hashCode();
            }
            if (!internalGetExtras().j().isEmpty()) {
                hashCode = (((hashCode * 37) + 7) * 53) + internalGetExtras().hashCode();
            }
            int hashCode2 = (((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((hashCode * 37) + 4) * 53) + getWwid().hashCode()) * 37) + 8) * 53) + getContact().hashCode()) * 37) + 9) * 53) + getPhoneModel().hashCode()) * 37) + 10) * 53) + getPhoneOsVersion().hashCode()) * 37) + 21) * 53) + getCompanionVersion().hashCode()) * 37) + 11) * 53) + getWatchModel().hashCode()) * 37) + 12) * 53) + getWatchDeviceName().hashCode()) * 37) + 13) * 53) + getWatchOsVersion().hashCode()) * 37) + 14) * 53) + getFeedbackClassificationText().hashCode()) * 37) + 15) * 53) + u.h(getHappenedAt())) * 37) + 20) * 53) + u.c(getIsOverseas())) * 37) + 3) * 53) + getDeviceId().hashCode()) * 37) + 16) * 53) + getMirrorModel().hashCode()) * 37) + 17) * 53) + getMirrorOsVersion().hashCode()) * 37) + 18) * 53) + getFeedbackContentDetail().hashCode()) * 37) + 19) * 53) + getHotwordExtra().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return FeedbackProto.f15748f.e(FeedbackRequest.class, c.class);
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
            for (Map.Entry<String, String> entry : internalGetExtras().j().entrySet()) {
                codedOutputStream.A0(7, d.f15788a.newBuilderForType().n(entry.getKey()).p(entry.getValue()).build());
            }
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
            for (Map.Entry<String, ByteString> entry2 : internalGetAttachments().j().entrySet()) {
                codedOutputStream.A0(22, b.f15765a.newBuilderForType().n(entry2.getKey()).p(entry2.getValue()).build());
            }
        }

        /* synthetic */ FeedbackRequest(GeneratedMessageV3.b bVar, a aVar) {
            this(bVar);
        }

        public static c newBuilder(FeedbackRequest feedbackRequest) {
            return DEFAULT_INSTANCE.toBuilder().l(feedbackRequest);
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
        public c toBuilder() {
            return this == DEFAULT_INSTANCE ? new c((a) null) : new c((a) null).l(this);
        }

        public static FeedbackRequest parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public c newBuilderForType() {
            return newBuilder();
        }

        private FeedbackRequest() {
            this.memoizedIsInitialized = (byte) -1;
            this.source_ = "";
            this.subsource_ = "";
            this.feedbackContent_ = "";
            this.feedbackClassification_ = "";
            this.wwid_ = "";
            this.contact_ = "";
            this.phoneModel_ = "";
            this.phoneOsVersion_ = "";
            this.companionVersion_ = "";
            this.watchModel_ = "";
            this.watchDeviceName_ = "";
            this.watchOsVersion_ = "";
            this.feedbackClassificationText_ = "";
            this.happenedAt_ = 0L;
            this.isOverseas_ = false;
            this.deviceId_ = "";
            this.mirrorModel_ = "";
            this.mirrorOsVersion_ = "";
            this.feedbackContentDetail_ = "";
            this.hotwordExtra_ = "";
        }

        public static FeedbackRequest parseFrom(InputStream inputStream) throws IOException {
            return (FeedbackRequest) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
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
                                    this.extras_ = c0.q(d.f15788a);
                                    z11 |= true;
                                }
                                a0 a0Var = (a0) iVar.v(d.f15788a.getParserForType(), qVar);
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
                                    this.attachments_ = c0.q(b.f15765a);
                                    z11 |= true;
                                }
                                a0 a0Var2 = (a0) iVar.v(b.f15765a.getParserForType(), qVar);
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
    public static final class Request extends GeneratedMessageV3 implements g0 {
        public static final int COMMENT_FIELD_NUMBER = 1;
        public static final int FEEDBACK_FIELD_NUMBER = 2;
        public static final int TICAUTO_LOGS_FIELD_NUMBER = 3;
        private static final long serialVersionUID = 0;
        private byte memoizedIsInitialized;
        private int typeCase_;
        private Object type_;
        private static final Request DEFAULT_INSTANCE = new Request();
        private static final l0<Request> PARSER = new a();

        /* loaded from: classes2.dex */
        public enum TypeCase implements u.a {
            COMMENT(1),
            FEEDBACK(2),
            TICAUTO_LOGS(3),
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
                if (i10 != 3) {
                    return null;
                }
                return TICAUTO_LOGS;
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
        class a extends com.google.protobuf.c<Request> {
            a() {
            }

            /* renamed from: a */
            public Request parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
                return new Request(iVar, qVar, null);
            }
        }

        /* loaded from: classes2.dex */
        public static final class b extends GeneratedMessageV3.b<b> implements g0 {

            /* renamed from: a  reason: collision with root package name */
            private int f15789a;

            /* renamed from: b  reason: collision with root package name */
            private Object f15790b;

            /* renamed from: c  reason: collision with root package name */
            private q0<FeedbackRequest, FeedbackRequest.c, d> f15791c;

            /* renamed from: d  reason: collision with root package name */
            private q0<TicautoLogs, TicautoLogs.b, f> f15792d;

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
            public Request build() {
                Request c10 = buildPartial();
                if (c10.isInitialized()) {
                    return c10;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) c10);
            }

            /* renamed from: c */
            public Request buildPartial() {
                Request request = new Request(this, (a) null);
                if (this.f15789a == 1) {
                    request.type_ = this.f15790b;
                }
                if (this.f15789a == 2) {
                    q0<FeedbackRequest, FeedbackRequest.c, d> q0Var = this.f15791c;
                    if (q0Var == null) {
                        request.type_ = this.f15790b;
                    } else {
                        request.type_ = q0Var.b();
                    }
                }
                if (this.f15789a == 3) {
                    q0<TicautoLogs, TicautoLogs.b, f> q0Var2 = this.f15792d;
                    if (q0Var2 == null) {
                        request.type_ = this.f15790b;
                    } else {
                        request.type_ = q0Var2.b();
                    }
                }
                request.typeCase_ = this.f15789a;
                onBuilt();
                return request;
            }

            /* renamed from: d */
            public b clear() {
                super.clear();
                this.f15789a = 0;
                this.f15790b = null;
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
                return FeedbackProto.f15743a;
            }

            /* renamed from: i */
            public Request getDefaultInstanceForType() {
                return Request.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return FeedbackProto.f15744b.e(Request.class, b.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.f0
            public final boolean isInitialized() {
                return true;
            }

            public b j(FeedbackRequest feedbackRequest) {
                q0<FeedbackRequest, FeedbackRequest.c, d> q0Var = this.f15791c;
                if (q0Var == null) {
                    if (this.f15789a != 2 || this.f15790b == FeedbackRequest.getDefaultInstance()) {
                        this.f15790b = feedbackRequest;
                    } else {
                        this.f15790b = FeedbackRequest.newBuilder((FeedbackRequest) this.f15790b).l(feedbackRequest).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.f15789a == 2) {
                        q0Var.h(feedbackRequest);
                    }
                    this.f15791c.j(feedbackRequest);
                }
                this.f15789a = 2;
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x0023  */
            /* renamed from: k */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public b mergeFrom(i iVar, q qVar) throws IOException {
                Throwable th2;
                Request request = null;
                try {
                    try {
                        Request request2 = (Request) Request.PARSER.parsePartialFrom(iVar, qVar);
                        if (request2 != null) {
                            m(request2);
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
                        m(request);
                    }
                    throw th2;
                }
            }

            /* renamed from: l */
            public b mergeFrom(d0 d0Var) {
                if (d0Var instanceof Request) {
                    return m((Request) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            public b m(Request request) {
                if (request == Request.getDefaultInstance()) {
                    return this;
                }
                int i10 = b.f15808a[request.getTypeCase().ordinal()];
                if (i10 == 1) {
                    this.f15789a = 1;
                    this.f15790b = request.type_;
                    onChanged();
                } else if (i10 == 2) {
                    j(request.getFeedback());
                } else if (i10 == 3) {
                    n(request.getTicautoLogs());
                }
                onChanged();
                return this;
            }

            public b n(TicautoLogs ticautoLogs) {
                q0<TicautoLogs, TicautoLogs.b, f> q0Var = this.f15792d;
                if (q0Var == null) {
                    if (this.f15789a != 3 || this.f15790b == TicautoLogs.getDefaultInstance()) {
                        this.f15790b = ticautoLogs;
                    } else {
                        this.f15790b = TicautoLogs.newBuilder((TicautoLogs) this.f15790b).l(ticautoLogs).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.f15789a == 3) {
                        q0Var.h(ticautoLogs);
                    }
                    this.f15792d.j(ticautoLogs);
                }
                this.f15789a = 3;
                return this;
            }

            /* renamed from: o */
            public final b mergeUnknownFields(a1 a1Var) {
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
                this.f15789a = 0;
                maybeForceBuilderInitialization();
            }

            private b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.f15789a = 0;
                maybeForceBuilderInitialization();
            }
        }

        /* synthetic */ Request(i iVar, q qVar, a aVar) throws InvalidProtocolBufferException {
            this(iVar, qVar);
        }

        public static Request getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return FeedbackProto.f15743a;
        }

        public static b newBuilder() {
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

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: d */
        public b newBuilderForType(GeneratedMessageV3.c cVar) {
            return new b(cVar, null);
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x003d, code lost:
            if (getTicautoLogs().equals(r6.getTicautoLogs()) != false) goto L31;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x004e, code lost:
            if (getFeedback().equals(r6.getFeedback()) != false) goto L31;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x005f, code lost:
            if (getComment().equals(r6.getComment()) != false) goto L31;
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
            } else if (i10 != 3) {
                return z11;
            } else {
                if (z11) {
                }
                z10 = false;
                return z10;
            }
        }

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

        public FeedbackRequest getFeedback() {
            if (this.typeCase_ == 2) {
                return (FeedbackRequest) this.type_;
            }
            return FeedbackRequest.getDefaultInstance();
        }

        public d getFeedbackOrBuilder() {
            if (this.typeCase_ == 2) {
                return (FeedbackRequest) this.type_;
            }
            return FeedbackRequest.getDefaultInstance();
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
            this.memoizedSize = i11;
            return i11;
        }

        public TicautoLogs getTicautoLogs() {
            if (this.typeCase_ == 3) {
                return (TicautoLogs) this.type_;
            }
            return TicautoLogs.getDefaultInstance();
        }

        public f getTicautoLogsOrBuilder() {
            if (this.typeCase_ == 3) {
                return (TicautoLogs) this.type_;
            }
            return TicautoLogs.getDefaultInstance();
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
            int hashCode = 779 + getDescriptorForType().hashCode();
            int i13 = this.typeCase_;
            if (i13 == 1) {
                i11 = ((hashCode * 37) + 1) * 53;
                i10 = getComment().hashCode();
            } else if (i13 != 2) {
                if (i13 == 3) {
                    i11 = ((hashCode * 37) + 3) * 53;
                    i10 = getTicautoLogs().hashCode();
                }
                int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
                this.memoizedHashCode = hashCode2;
                return hashCode2;
            } else {
                i11 = ((hashCode * 37) + 2) * 53;
                i10 = getFeedback().hashCode();
            }
            hashCode = i11 + i10;
            int hashCode22 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode22;
            return hashCode22;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return FeedbackProto.f15744b.e(Request.class, b.class);
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
        }

        /* synthetic */ Request(GeneratedMessageV3.b bVar, a aVar) {
            this(bVar);
        }

        public static b newBuilder(Request request) {
            return DEFAULT_INSTANCE.toBuilder().m(request);
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
        public b toBuilder() {
            return this == DEFAULT_INSTANCE ? new b((a) null) : new b((a) null).m(this);
        }

        public static Request parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b newBuilderForType() {
            return newBuilder();
        }

        public static Request parseFrom(InputStream inputStream) throws IOException {
            return (Request) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
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
                                TicautoLogs.b bVar = null;
                                FeedbackRequest.c builder = null;
                                if (F == 18) {
                                    builder = this.typeCase_ == 2 ? ((FeedbackRequest) this.type_).toBuilder() : builder;
                                    e0 v10 = iVar.v(FeedbackRequest.parser(), qVar);
                                    this.type_ = v10;
                                    if (builder != null) {
                                        builder.l((FeedbackRequest) v10);
                                        this.type_ = builder.buildPartial();
                                    }
                                    this.typeCase_ = 2;
                                } else if (F == 26) {
                                    bVar = this.typeCase_ == 3 ? ((TicautoLogs) this.type_).toBuilder() : bVar;
                                    e0 v11 = iVar.v(TicautoLogs.parser(), qVar);
                                    this.type_ = v11;
                                    if (bVar != null) {
                                        bVar.l((TicautoLogs) v11);
                                        this.type_ = bVar.buildPartial();
                                    }
                                    this.typeCase_ = 3;
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
    public static final class Response extends GeneratedMessageV3 implements g0 {
        public static final int FEEDBACK_FIELD_NUMBER = 4;
        public static final int OK_FIELD_NUMBER = 3;
        private static final long serialVersionUID = 0;
        private Feedback feedback_;
        private byte memoizedIsInitialized;
        private boolean ok_;
        private static final Response DEFAULT_INSTANCE = new Response();
        private static final l0<Response> PARSER = new a();

        /* loaded from: classes2.dex */
        class a extends com.google.protobuf.c<Response> {
            a() {
            }

            /* renamed from: a */
            public Response parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
                return new Response(iVar, qVar, null);
            }
        }

        /* loaded from: classes2.dex */
        public static final class b extends GeneratedMessageV3.b<b> implements g0 {

            /* renamed from: a  reason: collision with root package name */
            private boolean f15793a;

            /* renamed from: b  reason: collision with root package name */
            private Feedback f15794b;

            /* renamed from: c  reason: collision with root package name */
            private q0<Feedback, Feedback.b, c> f15795c;

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
            public Response build() {
                Response c10 = buildPartial();
                if (c10.isInitialized()) {
                    return c10;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) c10);
            }

            /* renamed from: c */
            public Response buildPartial() {
                Response response = new Response(this, (a) null);
                response.ok_ = this.f15793a;
                q0<Feedback, Feedback.b, c> q0Var = this.f15795c;
                if (q0Var == null) {
                    response.feedback_ = this.f15794b;
                } else {
                    response.feedback_ = q0Var.b();
                }
                onBuilt();
                return response;
            }

            /* renamed from: d */
            public b clear() {
                super.clear();
                this.f15793a = false;
                if (this.f15795c == null) {
                    this.f15794b = null;
                } else {
                    this.f15794b = null;
                    this.f15795c = null;
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
                return FeedbackProto.f15745c;
            }

            /* renamed from: i */
            public Response getDefaultInstanceForType() {
                return Response.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return FeedbackProto.f15746d.e(Response.class, b.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.f0
            public final boolean isInitialized() {
                return true;
            }

            public b j(Feedback feedback) {
                q0<Feedback, Feedback.b, c> q0Var = this.f15795c;
                if (q0Var == null) {
                    Feedback feedback2 = this.f15794b;
                    if (feedback2 != null) {
                        this.f15794b = Feedback.newBuilder(feedback2).l(feedback).buildPartial();
                    } else {
                        this.f15794b = feedback;
                    }
                    onChanged();
                } else {
                    q0Var.h(feedback);
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
                Response response = null;
                try {
                    try {
                        Response response2 = (Response) Response.PARSER.parsePartialFrom(iVar, qVar);
                        if (response2 != null) {
                            m(response2);
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
                        m(response);
                    }
                    throw th2;
                }
            }

            /* renamed from: l */
            public b mergeFrom(d0 d0Var) {
                if (d0Var instanceof Response) {
                    return m((Response) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            public b m(Response response) {
                if (response == Response.getDefaultInstance()) {
                    return this;
                }
                if (response.getOk()) {
                    p(response.getOk());
                }
                if (response.hasFeedback()) {
                    j(response.getFeedback());
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
                this.f15793a = z10;
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
                this.f15794b = null;
                maybeForceBuilderInitialization();
            }

            private b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.f15794b = null;
                maybeForceBuilderInitialization();
            }
        }

        /* synthetic */ Response(i iVar, q qVar, a aVar) throws InvalidProtocolBufferException {
            this(iVar, qVar);
        }

        public static Response getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return FeedbackProto.f15745c;
        }

        public static b newBuilder() {
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

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: c */
        public b newBuilderForType(GeneratedMessageV3.c cVar) {
            return new b(cVar, null);
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            boolean z10 = true;
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Response)) {
                return super.equals(obj);
            }
            Response response = (Response) obj;
            boolean z11 = (getOk() == response.getOk()) && hasFeedback() == response.hasFeedback();
            if (!hasFeedback()) {
                return z11;
            }
            if (!z11 || !getFeedback().equals(response.getFeedback())) {
                z10 = false;
            }
            return z10;
        }

        public Feedback getFeedback() {
            Feedback feedback = this.feedback_;
            return feedback == null ? Feedback.getDefaultInstance() : feedback;
        }

        public c getFeedbackOrBuilder() {
            return getFeedback();
        }

        public boolean getOk() {
            return this.ok_;
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
            if (this.feedback_ != null) {
                i11 += CodedOutputStream.E(4, getFeedback());
            }
            this.memoizedSize = i11;
            return i11;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.g0
        public final a1 getUnknownFields() {
            return a1.c();
        }

        public boolean hasFeedback() {
            return this.feedback_ != null;
        }

        @Override // com.google.protobuf.a
        public int hashCode() {
            int i10 = this.memoizedHashCode;
            if (i10 != 0) {
                return i10;
            }
            int hashCode = ((((779 + getDescriptorForType().hashCode()) * 37) + 3) * 53) + u.c(getOk());
            if (hasFeedback()) {
                hashCode = (((hashCode * 37) + 4) * 53) + getFeedback().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return FeedbackProto.f15746d.e(Response.class, b.class);
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
            if (this.feedback_ != null) {
                codedOutputStream.A0(4, getFeedback());
            }
        }

        /* synthetic */ Response(GeneratedMessageV3.b bVar, a aVar) {
            this(bVar);
        }

        public static b newBuilder(Response response) {
            return DEFAULT_INSTANCE.toBuilder().m(response);
        }

        public static Response parseFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, qVar);
        }

        private Response(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
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
        public b toBuilder() {
            return this == DEFAULT_INSTANCE ? new b((a) null) : new b((a) null).m(this);
        }

        public static Response parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b newBuilderForType() {
            return newBuilder();
        }

        private Response() {
            this.memoizedIsInitialized = (byte) -1;
            this.ok_ = false;
        }

        public static Response parseFrom(InputStream inputStream) throws IOException {
            return (Response) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static Response parseFrom(InputStream inputStream, q qVar) throws IOException {
            return (Response) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
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
                            if (F == 24) {
                                this.ok_ = iVar.l();
                            } else if (F == 34) {
                                Feedback.b bVar = null;
                                Feedback feedback = this.feedback_;
                                bVar = feedback != null ? feedback.toBuilder() : bVar;
                                Feedback feedback2 = (Feedback) iVar.v(Feedback.parser(), qVar);
                                this.feedback_ = feedback2;
                                if (bVar != null) {
                                    bVar.l(feedback2);
                                    this.feedback_ = bVar.buildPartial();
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

        public static Response parseFrom(i iVar) throws IOException {
            return (Response) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
        }

        public static Response parseFrom(i iVar, q qVar) throws IOException {
            return (Response) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
        }
    }

    /* loaded from: classes2.dex */
    public static final class TicautoLog extends GeneratedMessageV3 implements e {
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
        private static final l0<TicautoLog> PARSER = new a();

        /* loaded from: classes2.dex */
        class a extends com.google.protobuf.c<TicautoLog> {
            a() {
            }

            /* renamed from: a */
            public TicautoLog parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
                return new TicautoLog(iVar, qVar, null);
            }
        }

        /* loaded from: classes2.dex */
        public static final class b extends GeneratedMessageV3.b<b> implements e {

            /* renamed from: a  reason: collision with root package name */
            private Object f15796a;

            /* renamed from: b  reason: collision with root package name */
            private Object f15797b;

            /* renamed from: c  reason: collision with root package name */
            private Object f15798c;

            /* renamed from: d  reason: collision with root package name */
            private long f15799d;

            /* renamed from: e  reason: collision with root package name */
            private Object f15800e;

            /* renamed from: f  reason: collision with root package name */
            private Object f15801f;

            /* renamed from: g  reason: collision with root package name */
            private Object f15802g;

            /* renamed from: h  reason: collision with root package name */
            private Object f15803h;

            /* renamed from: i  reason: collision with root package name */
            private Object f15804i;

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
            public TicautoLog build() {
                TicautoLog c10 = buildPartial();
                if (c10.isInitialized()) {
                    return c10;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) c10);
            }

            /* renamed from: c */
            public TicautoLog buildPartial() {
                TicautoLog ticautoLog = new TicautoLog(this, (a) null);
                ticautoLog.source_ = this.f15796a;
                ticautoLog.subsource_ = this.f15797b;
                ticautoLog.packageName_ = this.f15798c;
                ticautoLog.happenedAt_ = this.f15799d;
                ticautoLog.crashlog_ = this.f15800e;
                ticautoLog.version_ = this.f15801f;
                ticautoLog.imei_ = this.f15802g;
                ticautoLog.wwid_ = this.f15803h;
                ticautoLog.deviceId_ = this.f15804i;
                onBuilt();
                return ticautoLog;
            }

            /* renamed from: d */
            public b clear() {
                super.clear();
                this.f15796a = "";
                this.f15797b = "";
                this.f15798c = "";
                this.f15799d = 0L;
                this.f15800e = "";
                this.f15801f = "";
                this.f15802g = "";
                this.f15803h = "";
                this.f15804i = "";
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
                return FeedbackProto.f15753k;
            }

            /* renamed from: i */
            public TicautoLog getDefaultInstanceForType() {
                return TicautoLog.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return FeedbackProto.f15754l.e(TicautoLog.class, b.class);
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
                TicautoLog ticautoLog = null;
                try {
                    try {
                        TicautoLog ticautoLog2 = (TicautoLog) TicautoLog.PARSER.parsePartialFrom(iVar, qVar);
                        if (ticautoLog2 != null) {
                            l(ticautoLog2);
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
                        l(ticautoLog);
                    }
                    throw th2;
                }
            }

            /* renamed from: k */
            public b mergeFrom(d0 d0Var) {
                if (d0Var instanceof TicautoLog) {
                    return l((TicautoLog) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            public b l(TicautoLog ticautoLog) {
                if (ticautoLog == TicautoLog.getDefaultInstance()) {
                    return this;
                }
                if (!ticautoLog.getSource().isEmpty()) {
                    this.f15796a = ticautoLog.source_;
                    onChanged();
                }
                if (!ticautoLog.getSubsource().isEmpty()) {
                    this.f15797b = ticautoLog.subsource_;
                    onChanged();
                }
                if (!ticautoLog.getPackageName().isEmpty()) {
                    this.f15798c = ticautoLog.packageName_;
                    onChanged();
                }
                if (ticautoLog.getHappenedAt() != 0) {
                    o(ticautoLog.getHappenedAt());
                }
                if (!ticautoLog.getCrashlog().isEmpty()) {
                    this.f15800e = ticautoLog.crashlog_;
                    onChanged();
                }
                if (!ticautoLog.getVersion().isEmpty()) {
                    this.f15801f = ticautoLog.version_;
                    onChanged();
                }
                if (!ticautoLog.getImei().isEmpty()) {
                    this.f15802g = ticautoLog.imei_;
                    onChanged();
                }
                if (!ticautoLog.getWwid().isEmpty()) {
                    this.f15803h = ticautoLog.wwid_;
                    onChanged();
                }
                if (!ticautoLog.getDeviceId().isEmpty()) {
                    this.f15804i = ticautoLog.deviceId_;
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

            public b o(long j10) {
                this.f15799d = j10;
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
                this.f15796a = "";
                this.f15797b = "";
                this.f15798c = "";
                this.f15800e = "";
                this.f15801f = "";
                this.f15802g = "";
                this.f15803h = "";
                this.f15804i = "";
                maybeForceBuilderInitialization();
            }

            private b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.f15796a = "";
                this.f15797b = "";
                this.f15798c = "";
                this.f15800e = "";
                this.f15801f = "";
                this.f15802g = "";
                this.f15803h = "";
                this.f15804i = "";
                maybeForceBuilderInitialization();
            }
        }

        /* synthetic */ TicautoLog(i iVar, q qVar, a aVar) throws InvalidProtocolBufferException {
            this(iVar, qVar);
        }

        public static TicautoLog getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return FeedbackProto.f15753k;
        }

        public static b newBuilder() {
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

        public String getCrashlog() {
            Object obj = this.crashlog_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.crashlog_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getCrashlogBytes() {
            Object obj = this.crashlog_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.crashlog_ = copyFromUtf8;
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

        public long getHappenedAt() {
            return this.happenedAt_;
        }

        public String getImei() {
            Object obj = this.imei_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.imei_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getImeiBytes() {
            Object obj = this.imei_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.imei_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public String getPackageName() {
            Object obj = this.packageName_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.packageName_ = stringUtf8;
            return stringUtf8;
        }

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

        public String getSubsource() {
            Object obj = this.subsource_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.subsource_ = stringUtf8;
            return stringUtf8;
        }

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

        public String getVersion() {
            Object obj = this.version_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.version_ = stringUtf8;
            return stringUtf8;
        }

        public ByteString getVersionBytes() {
            Object obj = this.version_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.version_ = copyFromUtf8;
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
            int hashCode = ((((((((((((((((((((((((((((((((((((((779 + getDescriptorForType().hashCode()) * 37) + 1) * 53) + getSource().hashCode()) * 37) + 2) * 53) + getSubsource().hashCode()) * 37) + 3) * 53) + getPackageName().hashCode()) * 37) + 4) * 53) + u.h(getHappenedAt())) * 37) + 5) * 53) + getCrashlog().hashCode()) * 37) + 6) * 53) + getVersion().hashCode()) * 37) + 7) * 53) + getImei().hashCode()) * 37) + 8) * 53) + getWwid().hashCode()) * 37) + 9) * 53) + getDeviceId().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return FeedbackProto.f15754l.e(TicautoLog.class, b.class);
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
        /* renamed from: v */
        public b newBuilderForType(GeneratedMessageV3.c cVar) {
            return new b(cVar, null);
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

        /* synthetic */ TicautoLog(GeneratedMessageV3.b bVar, a aVar) {
            this(bVar);
        }

        public static b newBuilder(TicautoLog ticautoLog) {
            return DEFAULT_INSTANCE.toBuilder().l(ticautoLog);
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
        public b toBuilder() {
            return this == DEFAULT_INSTANCE ? new b((a) null) : new b((a) null).l(this);
        }

        public static TicautoLog parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b newBuilderForType() {
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
    public static final class TicautoLogs extends GeneratedMessageV3 implements f {
        public static final int DATA_FIELD_NUMBER = 1;
        private static final TicautoLogs DEFAULT_INSTANCE = new TicautoLogs();
        private static final l0<TicautoLogs> PARSER = new a();
        private static final long serialVersionUID = 0;
        private List<TicautoLog> data_;
        private byte memoizedIsInitialized;

        /* loaded from: classes2.dex */
        class a extends com.google.protobuf.c<TicautoLogs> {
            a() {
            }

            /* renamed from: a */
            public TicautoLogs parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
                return new TicautoLogs(iVar, qVar, null);
            }
        }

        /* loaded from: classes2.dex */
        public static final class b extends GeneratedMessageV3.b<b> implements f {

            /* renamed from: a  reason: collision with root package name */
            private int f15805a;

            /* renamed from: b  reason: collision with root package name */
            private List<TicautoLog> f15806b;

            /* renamed from: c  reason: collision with root package name */
            private o0<TicautoLog, TicautoLog.b, e> f15807c;

            /* synthetic */ b(GeneratedMessageV3.c cVar, a aVar) {
                this(cVar);
            }

            private void ensureDataIsMutable() {
                if ((this.f15805a & 1) != 1) {
                    this.f15806b = new ArrayList(this.f15806b);
                    this.f15805a |= 1;
                }
            }

            private o0<TicautoLog, TicautoLog.b, e> getDataFieldBuilder() {
                if (this.f15807c == null) {
                    List<TicautoLog> list = this.f15806b;
                    boolean z10 = true;
                    if ((this.f15805a & 1) != 1) {
                        z10 = false;
                    }
                    this.f15807c = new o0<>(list, z10, getParentForChildren(), isClean());
                    this.f15806b = null;
                }
                return this.f15807c;
            }

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                    getDataFieldBuilder();
                }
            }

            /* renamed from: a */
            public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.addRepeatedField(fieldDescriptor, obj);
            }

            /* renamed from: b */
            public TicautoLogs build() {
                TicautoLogs c10 = buildPartial();
                if (c10.isInitialized()) {
                    return c10;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) c10);
            }

            /* renamed from: c */
            public TicautoLogs buildPartial() {
                TicautoLogs ticautoLogs = new TicautoLogs(this, (a) null);
                int i10 = this.f15805a;
                o0<TicautoLog, TicautoLog.b, e> o0Var = this.f15807c;
                if (o0Var == null) {
                    if ((i10 & 1) == 1) {
                        this.f15806b = Collections.unmodifiableList(this.f15806b);
                        this.f15805a &= -2;
                    }
                    ticautoLogs.data_ = this.f15806b;
                } else {
                    ticautoLogs.data_ = o0Var.g();
                }
                onBuilt();
                return ticautoLogs;
            }

            /* renamed from: d */
            public b clear() {
                super.clear();
                o0<TicautoLog, TicautoLog.b, e> o0Var = this.f15807c;
                if (o0Var == null) {
                    this.f15806b = Collections.emptyList();
                    this.f15805a &= -2;
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
                return FeedbackProto.f15755m;
            }

            /* renamed from: i */
            public TicautoLogs getDefaultInstanceForType() {
                return TicautoLogs.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return FeedbackProto.f15756n.e(TicautoLogs.class, b.class);
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
                TicautoLogs ticautoLogs = null;
                try {
                    try {
                        TicautoLogs ticautoLogs2 = (TicautoLogs) TicautoLogs.PARSER.parsePartialFrom(iVar, qVar);
                        if (ticautoLogs2 != null) {
                            l(ticautoLogs2);
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
                        l(ticautoLogs);
                    }
                    throw th2;
                }
            }

            /* renamed from: k */
            public b mergeFrom(d0 d0Var) {
                if (d0Var instanceof TicautoLogs) {
                    return l((TicautoLogs) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            public b l(TicautoLogs ticautoLogs) {
                if (ticautoLogs == TicautoLogs.getDefaultInstance()) {
                    return this;
                }
                if (this.f15807c == null) {
                    if (!ticautoLogs.data_.isEmpty()) {
                        if (this.f15806b.isEmpty()) {
                            this.f15806b = ticautoLogs.data_;
                            this.f15805a &= -2;
                        } else {
                            ensureDataIsMutable();
                            this.f15806b.addAll(ticautoLogs.data_);
                        }
                        onChanged();
                    }
                } else if (!ticautoLogs.data_.isEmpty()) {
                    if (this.f15807c.u()) {
                        this.f15807c.i();
                        o0<TicautoLog, TicautoLog.b, e> o0Var = null;
                        this.f15807c = null;
                        this.f15806b = ticautoLogs.data_;
                        this.f15805a &= -2;
                        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                            o0Var = getDataFieldBuilder();
                        }
                        this.f15807c = o0Var;
                    } else {
                        this.f15807c.b(ticautoLogs.data_);
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
                this.f15806b = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.f15806b = Collections.emptyList();
                maybeForceBuilderInitialization();
            }
        }

        /* synthetic */ TicautoLogs(i iVar, q qVar, a aVar) throws InvalidProtocolBufferException {
            this(iVar, qVar);
        }

        public static TicautoLogs getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return FeedbackProto.f15755m;
        }

        public static b newBuilder() {
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

        public TicautoLog getData(int i10) {
            return this.data_.get(i10);
        }

        public int getDataCount() {
            return this.data_.size();
        }

        public List<TicautoLog> getDataList() {
            return this.data_;
        }

        public e getDataOrBuilder(int i10) {
            return this.data_.get(i10);
        }

        public List<? extends e> getDataOrBuilderList() {
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
            return FeedbackProto.f15756n.e(TicautoLogs.class, b.class);
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

        /* synthetic */ TicautoLogs(GeneratedMessageV3.b bVar, a aVar) {
            this(bVar);
        }

        public static b newBuilder(TicautoLogs ticautoLogs) {
            return DEFAULT_INSTANCE.toBuilder().l(ticautoLogs);
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
        public b toBuilder() {
            return this == DEFAULT_INSTANCE ? new b((a) null) : new b((a) null).l(this);
        }

        public static TicautoLogs parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b newBuilderForType() {
            return newBuilder();
        }

        private TicautoLogs() {
            this.memoizedIsInitialized = (byte) -1;
            this.data_ = Collections.emptyList();
        }

        public static TicautoLogs parseFrom(InputStream inputStream) throws IOException {
            return (TicautoLogs) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements Descriptors.FileDescriptor.a {
        a() {
        }

        @Override // com.google.protobuf.Descriptors.FileDescriptor.a
        public o assignDescriptors(Descriptors.FileDescriptor fileDescriptor) {
            Descriptors.FileDescriptor unused = FeedbackProto.f15757o = fileDescriptor;
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f15808a;

        static {
            int[] iArr = new int[Request.TypeCase.values().length];
            f15808a = iArr;
            try {
                iArr[Request.TypeCase.COMMENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f15808a[Request.TypeCase.FEEDBACK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f15808a[Request.TypeCase.TICAUTO_LOGS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f15808a[Request.TypeCase.TYPE_NOT_SET.ordinal()] = 4;
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
        Descriptors.FileDescriptor.q(new String[]{"\n\u000efeedback.proto\u0012\u000bfeedbackhub\"\u0088\u0001\n\u0007Request\u0012\u0011\n\u0007comment\u0018\u0001 \u0001(\tH\u0000\u00120\n\bfeedback\u0018\u0002 \u0001(\u000b2\u001c.feedbackhub.FeedbackRequestH\u0000\u00120\n\fticauto_logs\u0018\u0003 \u0001(\u000b2\u0018.feedbackhub.TicautoLogsH\u0000B\u0006\n\u0004type\"?\n\bResponse\u0012\n\n\u0002ok\u0018\u0003 \u0001(\b\u0012'\n\bfeedback\u0018\u0004 \u0001(\u000b2\u0015.feedbackhub.Feedback\"Ï\u0005\n\u000fFeedbackRequest\u0012\u000e\n\u0006source\u0018\u0001 \u0001(\t\u0012\u0011\n\tsubsource\u0018\u0002 \u0001(\t\u0012\u0018\n\u0010feedback_content\u0018\u0005 \u0001(\t\u0012\u001f\n\u0017feedback_classification\u0018\u0006 \u0001(\t\u0012B\n\u000battachments\u0018\u0016 \u0003(\u000b2-.feedbackhub.FeedbackRequest.A", "ttachmentsEntry\u00128\n\u0006extras\u0018\u0007 \u0003(\u000b2(.feedbackhub.FeedbackRequest.ExtrasEntry\u0012\f\n\u0004wwid\u0018\u0004 \u0001(\t\u0012\u000f\n\u0007contact\u0018\b \u0001(\t\u0012\u0013\n\u000bphone_model\u0018\t \u0001(\t\u0012\u0018\n\u0010phone_os_version\u0018\n \u0001(\t\u0012\u0019\n\u0011companion_version\u0018\u0015 \u0001(\t\u0012\u0013\n\u000bwatch_model\u0018\u000b \u0001(\t\u0012\u0019\n\u0011watch_device_name\u0018\f \u0001(\t\u0012\u0018\n\u0010watch_os_version\u0018\r \u0001(\t\u0012$\n\u001cfeedback_classification_text\u0018\u000e \u0001(\t\u0012\u0013\n\u000bhappened_at\u0018\u000f \u0001(\u0003\u0012\u0013\n\u000bis_overseas\u0018\u0014 \u0001(\b\u0012\u0011\n\tdevice_id\u0018\u0003 \u0001(\t\u0012\u0014\n\fmirror_model\u0018\u0010 \u0001(\t\u0012\u0019\n\u0011mirror_os_version\u0018\u0011 \u0001(\t", "\u0012\u001f\n\u0017feedback_content_detail\u0018\u0012 \u0001(\t\u0012\u0015\n\rhotword_extra\u0018\u0013 \u0001(\t\u001a2\n\u0010AttachmentsEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\t\u0012\r\n\u0005value\u0018\u0002 \u0001(\f:\u00028\u0001\u001a-\n\u000bExtrasEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\t\u0012\r\n\u0005value\u0018\u0002 \u0001(\t:\u00028\u0001\"\u0089\u0001\n\bFeedback\u0012\n\n\u0002id\u0018\u000b \u0001(\u0005\u0012\u0012\n\ncreated_at\u0018\f \u0001(\u0003\u0012\f\n\u0004wwid\u0018\u0001 \u0001(\t\u0012\u000e\n\u0006source\u0018\u0006 \u0001(\t\u0012\u0011\n\tsubsource\u0018\u0007 \u0001(\t\u0012\u0014\n\fjira_created\u0018\t \u0001(\b\u0012\u0016\n\u000ejira_issue_key\u0018\n \u0001(\t\"¬\u0001\n\nTicautoLog\u0012\u000e\n\u0006source\u0018\u0001 \u0001(\t\u0012\u0011\n\tsubsource\u0018\u0002 \u0001(\t\u0012\u0014\n\fpackage_name\u0018\u0003 \u0001(\t\u0012\u0013\n\u000bhappened_at\u0018\u0004 \u0001(\u0003\u0012\u0010\n\bcrashlog", "\u0018\u0005 \u0001(\t\u0012\u000f\n\u0007version\u0018\u0006 \u0001(\t\u0012\f\n\u0004imei\u0018\u0007 \u0001(\t\u0012\f\n\u0004wwid\u0018\b \u0001(\t\u0012\u0011\n\tdevice_id\u0018\t \u0001(\t\"4\n\u000bTicautoLogs\u0012%\n\u0004data\u0018\u0001 \u0003(\u000b2\u0017.feedbackhub.TicautoLogB8\n'com.mobvoi.assistant.data.network.modelB\rFeedbackProtob\u0006proto3"}, new Descriptors.FileDescriptor[0], new a());
        Descriptors.b bVar = p().j().get(0);
        f15743a = bVar;
        f15744b = new GeneratedMessageV3.e(bVar, new String[]{"Comment", "Feedback", "TicautoLogs", "Type"});
        Descriptors.b bVar2 = p().j().get(1);
        f15745c = bVar2;
        f15746d = new GeneratedMessageV3.e(bVar2, new String[]{"Ok", "Feedback"});
        Descriptors.b bVar3 = p().j().get(2);
        f15747e = bVar3;
        f15748f = new GeneratedMessageV3.e(bVar3, new String[]{"Source", "Subsource", "FeedbackContent", "FeedbackClassification", "Attachments", "Extras", "Wwid", "Contact", "PhoneModel", "PhoneOsVersion", "CompanionVersion", "WatchModel", "WatchDeviceName", "WatchOsVersion", "FeedbackClassificationText", "HappenedAt", "IsOverseas", "DeviceId", "MirrorModel", "MirrorOsVersion", "FeedbackContentDetail", "HotwordExtra"});
        Descriptors.b bVar4 = bVar3.m().get(0);
        f15749g = bVar4;
        new GeneratedMessageV3.e(bVar4, new String[]{"Key", "Value"});
        Descriptors.b bVar5 = bVar3.m().get(1);
        f15750h = bVar5;
        new GeneratedMessageV3.e(bVar5, new String[]{"Key", "Value"});
        Descriptors.b bVar6 = p().j().get(3);
        f15751i = bVar6;
        f15752j = new GeneratedMessageV3.e(bVar6, new String[]{"Id", "CreatedAt", "Wwid", "Source", "Subsource", "JiraCreated", "JiraIssueKey"});
        Descriptors.b bVar7 = p().j().get(4);
        f15753k = bVar7;
        f15754l = new GeneratedMessageV3.e(bVar7, new String[]{"Source", "Subsource", "PackageName", "HappenedAt", "Crashlog", "Version", "Imei", "Wwid", "DeviceId"});
        Descriptors.b bVar8 = p().j().get(5);
        f15755m = bVar8;
        f15756n = new GeneratedMessageV3.e(bVar8, new String[]{"Data"});
    }

    public static Descriptors.FileDescriptor p() {
        return f15757o;
    }
}
