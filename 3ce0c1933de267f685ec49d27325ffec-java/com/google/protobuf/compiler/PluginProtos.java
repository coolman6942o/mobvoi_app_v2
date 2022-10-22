package com.google.protobuf.compiler;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.DescriptorProtos;
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
import com.google.protobuf.n0;
import com.google.protobuf.o;
import com.google.protobuf.o0;
import com.google.protobuf.q;
import com.google.protobuf.x;
import com.google.protobuf.y;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public final class PluginProtos {

    /* renamed from: a  reason: collision with root package name */
    private static final Descriptors.b f13198a;

    /* renamed from: b  reason: collision with root package name */
    private static final GeneratedMessageV3.e f13199b;

    /* renamed from: c  reason: collision with root package name */
    private static final Descriptors.b f13200c;

    /* renamed from: d  reason: collision with root package name */
    private static final GeneratedMessageV3.e f13201d;

    /* renamed from: e  reason: collision with root package name */
    private static final Descriptors.b f13202e;

    /* renamed from: f  reason: collision with root package name */
    private static final GeneratedMessageV3.e f13203f;

    /* renamed from: g  reason: collision with root package name */
    private static Descriptors.FileDescriptor f13204g;

    /* loaded from: classes.dex */
    public static final class CodeGeneratorRequest extends GeneratedMessageV3 implements g0 {
        public static final int FILE_TO_GENERATE_FIELD_NUMBER = 1;
        public static final int PARAMETER_FIELD_NUMBER = 2;
        public static final int PROTO_FILE_FIELD_NUMBER = 15;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private y fileToGenerate_;
        private byte memoizedIsInitialized;
        private volatile Object parameter_;
        private List<DescriptorProtos.FileDescriptorProto> protoFile_;
        private static final CodeGeneratorRequest DEFAULT_INSTANCE = new CodeGeneratorRequest();
        @Deprecated
        public static final l0<CodeGeneratorRequest> PARSER = new a();

        /* loaded from: classes.dex */
        static class a extends c<CodeGeneratorRequest> {
            a() {
            }

            /* renamed from: a */
            public CodeGeneratorRequest parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
                return new CodeGeneratorRequest(iVar, qVar, null);
            }
        }

        /* loaded from: classes.dex */
        public static final class b extends GeneratedMessageV3.b<b> implements g0 {

            /* renamed from: a  reason: collision with root package name */
            private int f13205a;

            /* renamed from: b  reason: collision with root package name */
            private y f13206b;

            /* renamed from: c  reason: collision with root package name */
            private Object f13207c;

            /* renamed from: d  reason: collision with root package name */
            private List<DescriptorProtos.FileDescriptorProto> f13208d;

            /* renamed from: e  reason: collision with root package name */
            private o0<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.b, DescriptorProtos.i> f13209e;

            /* synthetic */ b(GeneratedMessageV3.c cVar, a aVar) {
                this(cVar);
            }

            private void i() {
                if ((this.f13205a & 1) != 1) {
                    this.f13206b = new x(this.f13206b);
                    this.f13205a |= 1;
                }
            }

            private void j() {
                if ((this.f13205a & 4) != 4) {
                    this.f13208d = new ArrayList(this.f13208d);
                    this.f13205a |= 4;
                }
            }

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                    n();
                }
            }

            private o0<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.b, DescriptorProtos.i> n() {
                if (this.f13209e == null) {
                    this.f13209e = new o0<>(this.f13208d, (this.f13205a & 4) == 4, getParentForChildren(), isClean());
                    this.f13208d = null;
                }
                return this.f13209e;
            }

            /* renamed from: a */
            public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (b) super.addRepeatedField(fieldDescriptor, obj);
            }

            /* renamed from: b */
            public CodeGeneratorRequest build() {
                CodeGeneratorRequest c10 = buildPartial();
                if (c10.isInitialized()) {
                    return c10;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) c10);
            }

            /* renamed from: c */
            public CodeGeneratorRequest buildPartial() {
                CodeGeneratorRequest codeGeneratorRequest = new CodeGeneratorRequest(this, (a) null);
                int i10 = this.f13205a;
                int i11 = 1;
                if ((i10 & 1) == 1) {
                    this.f13206b = this.f13206b.u0();
                    this.f13205a &= -2;
                }
                codeGeneratorRequest.fileToGenerate_ = this.f13206b;
                if ((i10 & 2) != 2) {
                    i11 = 0;
                }
                codeGeneratorRequest.parameter_ = this.f13207c;
                o0<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.b, DescriptorProtos.i> o0Var = this.f13209e;
                if (o0Var == null) {
                    if ((this.f13205a & 4) == 4) {
                        this.f13208d = Collections.unmodifiableList(this.f13208d);
                        this.f13205a &= -5;
                    }
                    codeGeneratorRequest.protoFile_ = this.f13208d;
                } else {
                    codeGeneratorRequest.protoFile_ = o0Var.g();
                }
                codeGeneratorRequest.bitField0_ = i11;
                onBuilt();
                return codeGeneratorRequest;
            }

            /* renamed from: d */
            public b clear() {
                super.clear();
                this.f13206b = x.f13385d;
                int i10 = this.f13205a & (-2);
                this.f13205a = i10;
                this.f13207c = "";
                this.f13205a = i10 & (-3);
                o0<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.b, DescriptorProtos.i> o0Var = this.f13209e;
                if (o0Var == null) {
                    this.f13208d = Collections.emptyList();
                    this.f13205a &= -5;
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
                return PluginProtos.f13198a;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return PluginProtos.f13199b.e(CodeGeneratorRequest.class, b.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.f0
            public final boolean isInitialized() {
                for (int i10 = 0; i10 < m(); i10++) {
                    if (!l(i10).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }

            /* renamed from: k */
            public CodeGeneratorRequest getDefaultInstanceForType() {
                return CodeGeneratorRequest.getDefaultInstance();
            }

            public DescriptorProtos.FileDescriptorProto l(int i10) {
                o0<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.b, DescriptorProtos.i> o0Var = this.f13209e;
                if (o0Var == null) {
                    return this.f13208d.get(i10);
                }
                return o0Var.o(i10);
            }

            public int m() {
                o0<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.b, DescriptorProtos.i> o0Var = this.f13209e;
                if (o0Var == null) {
                    return this.f13208d.size();
                }
                return o0Var.n();
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x0021  */
            /* renamed from: o */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public b mergeFrom(i iVar, q qVar) throws IOException {
                Throwable th2;
                CodeGeneratorRequest codeGeneratorRequest = null;
                try {
                    try {
                        CodeGeneratorRequest parsePartialFrom = CodeGeneratorRequest.PARSER.parsePartialFrom(iVar, qVar);
                        if (parsePartialFrom != null) {
                            q(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e10) {
                        codeGeneratorRequest = (CodeGeneratorRequest) e10.getUnfinishedMessage();
                        try {
                            throw e10.unwrapIOException();
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (codeGeneratorRequest != null) {
                                q(codeGeneratorRequest);
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (codeGeneratorRequest != null) {
                    }
                    throw th2;
                }
            }

            /* renamed from: p */
            public b mergeFrom(d0 d0Var) {
                if (d0Var instanceof CodeGeneratorRequest) {
                    return q((CodeGeneratorRequest) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            public b q(CodeGeneratorRequest codeGeneratorRequest) {
                if (codeGeneratorRequest == CodeGeneratorRequest.getDefaultInstance()) {
                    return this;
                }
                if (!codeGeneratorRequest.fileToGenerate_.isEmpty()) {
                    if (this.f13206b.isEmpty()) {
                        this.f13206b = codeGeneratorRequest.fileToGenerate_;
                        this.f13205a &= -2;
                    } else {
                        i();
                        this.f13206b.addAll(codeGeneratorRequest.fileToGenerate_);
                    }
                    onChanged();
                }
                if (codeGeneratorRequest.hasParameter()) {
                    this.f13205a |= 2;
                    this.f13207c = codeGeneratorRequest.parameter_;
                    onChanged();
                }
                if (this.f13209e == null) {
                    if (!codeGeneratorRequest.protoFile_.isEmpty()) {
                        if (this.f13208d.isEmpty()) {
                            this.f13208d = codeGeneratorRequest.protoFile_;
                            this.f13205a &= -5;
                        } else {
                            j();
                            this.f13208d.addAll(codeGeneratorRequest.protoFile_);
                        }
                        onChanged();
                    }
                } else if (!codeGeneratorRequest.protoFile_.isEmpty()) {
                    if (this.f13209e.u()) {
                        this.f13209e.i();
                        o0<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.b, DescriptorProtos.i> o0Var = null;
                        this.f13209e = null;
                        this.f13208d = codeGeneratorRequest.protoFile_;
                        this.f13205a &= -5;
                        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                            o0Var = n();
                        }
                        this.f13209e = o0Var;
                    } else {
                        this.f13209e.b(codeGeneratorRequest.protoFile_);
                    }
                }
                mergeUnknownFields(((GeneratedMessageV3) codeGeneratorRequest).unknownFields);
                onChanged();
                return this;
            }

            /* renamed from: r */
            public final b mergeUnknownFields(a1 a1Var) {
                return (b) super.mergeUnknownFields(a1Var);
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
                return (b) super.setUnknownFields(a1Var);
            }

            /* synthetic */ b(a aVar) {
                this();
            }

            private b() {
                this.f13206b = x.f13385d;
                this.f13207c = "";
                this.f13208d = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.f13206b = x.f13385d;
                this.f13207c = "";
                this.f13208d = Collections.emptyList();
                maybeForceBuilderInitialization();
            }
        }

        /* synthetic */ CodeGeneratorRequest(i iVar, q qVar, a aVar) throws InvalidProtocolBufferException {
            this(iVar, qVar);
        }

        public static CodeGeneratorRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return PluginProtos.f13198a;
        }

        public static b newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static CodeGeneratorRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (CodeGeneratorRequest) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static CodeGeneratorRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static l0<CodeGeneratorRequest> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof CodeGeneratorRequest)) {
                return super.equals(obj);
            }
            CodeGeneratorRequest codeGeneratorRequest = (CodeGeneratorRequest) obj;
            boolean z10 = (getFileToGenerateList().equals(codeGeneratorRequest.getFileToGenerateList())) && hasParameter() == codeGeneratorRequest.hasParameter();
            if (hasParameter()) {
                z10 = z10 && getParameter().equals(codeGeneratorRequest.getParameter());
            }
            return (z10 && getProtoFileList().equals(codeGeneratorRequest.getProtoFileList())) && this.unknownFields.equals(codeGeneratorRequest.unknownFields);
        }

        public String getFileToGenerate(int i10) {
            return this.fileToGenerate_.get(i10);
        }

        public ByteString getFileToGenerateBytes(int i10) {
            return this.fileToGenerate_.o0(i10);
        }

        public int getFileToGenerateCount() {
            return this.fileToGenerate_.size();
        }

        public String getParameter() {
            Object obj = this.parameter_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.parameter_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getParameterBytes() {
            Object obj = this.parameter_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.parameter_ = copyFromUtf8;
            return copyFromUtf8;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public l0<CodeGeneratorRequest> getParserForType() {
            return PARSER;
        }

        public DescriptorProtos.FileDescriptorProto getProtoFile(int i10) {
            return this.protoFile_.get(i10);
        }

        public int getProtoFileCount() {
            return this.protoFile_.size();
        }

        public List<DescriptorProtos.FileDescriptorProto> getProtoFileList() {
            return this.protoFile_;
        }

        public DescriptorProtos.i getProtoFileOrBuilder(int i10) {
            return this.protoFile_.get(i10);
        }

        public List<? extends DescriptorProtos.i> getProtoFileOrBuilderList() {
            return this.protoFile_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
        public int getSerializedSize() {
            int i10 = this.memoizedSize;
            if (i10 != -1) {
                return i10;
            }
            int i11 = 0;
            for (int i12 = 0; i12 < this.fileToGenerate_.size(); i12++) {
                i11 += GeneratedMessageV3.computeStringSizeNoTag(this.fileToGenerate_.z0(i12));
            }
            int size = i11 + 0 + (getFileToGenerateList().size() * 1);
            if ((this.bitField0_ & 1) == 1) {
                size += GeneratedMessageV3.computeStringSize(2, this.parameter_);
            }
            for (int i13 = 0; i13 < this.protoFile_.size(); i13++) {
                size += CodedOutputStream.E(15, this.protoFile_.get(i13));
            }
            int serializedSize = size + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.g0
        public final a1 getUnknownFields() {
            return this.unknownFields;
        }

        public boolean hasParameter() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // com.google.protobuf.a
        public int hashCode() {
            int i10 = this.memoizedHashCode;
            if (i10 != 0) {
                return i10;
            }
            int hashCode = 779 + getDescriptorForType().hashCode();
            if (getFileToGenerateCount() > 0) {
                hashCode = (((hashCode * 37) + 1) * 53) + getFileToGenerateList().hashCode();
            }
            if (hasParameter()) {
                hashCode = (((hashCode * 37) + 2) * 53) + getParameter().hashCode();
            }
            if (getProtoFileCount() > 0) {
                hashCode = (((hashCode * 37) + 15) * 53) + getProtoFileList().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return PluginProtos.f13199b.e(CodeGeneratorRequest.class, b.class);
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
            for (int i10 = 0; i10 < getProtoFileCount(); i10++) {
                if (!getProtoFile(i10).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
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
            for (int i10 = 0; i10 < this.fileToGenerate_.size(); i10++) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.fileToGenerate_.z0(i10));
            }
            if ((this.bitField0_ & 1) == 1) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.parameter_);
            }
            for (int i11 = 0; i11 < this.protoFile_.size(); i11++) {
                codedOutputStream.A0(15, this.protoFile_.get(i11));
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        /* synthetic */ CodeGeneratorRequest(GeneratedMessageV3.b bVar, a aVar) {
            this(bVar);
        }

        public static b newBuilder(CodeGeneratorRequest codeGeneratorRequest) {
            return DEFAULT_INSTANCE.toBuilder().q(codeGeneratorRequest);
        }

        public static CodeGeneratorRequest parseFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, qVar);
        }

        public n0 getFileToGenerateList() {
            return this.fileToGenerate_;
        }

        private CodeGeneratorRequest(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static CodeGeneratorRequest parseDelimitedFrom(InputStream inputStream, q qVar) throws IOException {
            return (CodeGeneratorRequest) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
        }

        public static CodeGeneratorRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
        public CodeGeneratorRequest getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b toBuilder() {
            return this == DEFAULT_INSTANCE ? new b((a) null) : new b((a) null).q(this);
        }

        public static CodeGeneratorRequest parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b newBuilderForType() {
            return newBuilder();
        }

        private CodeGeneratorRequest() {
            this.memoizedIsInitialized = (byte) -1;
            this.fileToGenerate_ = x.f13385d;
            this.parameter_ = "";
            this.protoFile_ = Collections.emptyList();
        }

        public static CodeGeneratorRequest parseFrom(InputStream inputStream) throws IOException {
            return (CodeGeneratorRequest) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static CodeGeneratorRequest parseFrom(InputStream inputStream, q qVar) throws IOException {
            return (CodeGeneratorRequest) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
        }

        public static CodeGeneratorRequest parseFrom(i iVar) throws IOException {
            return (CodeGeneratorRequest) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private CodeGeneratorRequest(i iVar, q qVar) throws InvalidProtocolBufferException {
            this();
            a1.b g10 = a1.g();
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
                                    ByteString m10 = iVar.m();
                                    if (!z11 || !true) {
                                        this.fileToGenerate_ = new x();
                                        z11 |= true;
                                    }
                                    this.fileToGenerate_.v(m10);
                                } else if (F == 18) {
                                    ByteString m11 = iVar.m();
                                    this.bitField0_ |= 1;
                                    this.parameter_ = m11;
                                } else if (F == 122) {
                                    if (!(z11 & true)) {
                                        this.protoFile_ = new ArrayList();
                                        z11 |= true;
                                    }
                                    this.protoFile_.add(iVar.v(DescriptorProtos.FileDescriptorProto.PARSER, qVar));
                                } else if (!parseUnknownField(iVar, g10, qVar, F)) {
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
                    if (z11 && true) {
                        this.fileToGenerate_ = this.fileToGenerate_.u0();
                    }
                    if (z11 & true) {
                        this.protoFile_ = Collections.unmodifiableList(this.protoFile_);
                    }
                    this.unknownFields = g10.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static CodeGeneratorRequest parseFrom(i iVar, q qVar) throws IOException {
            return (CodeGeneratorRequest) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
        }
    }

    /* loaded from: classes.dex */
    public static final class CodeGeneratorResponse extends GeneratedMessageV3 implements g0 {
        public static final int ERROR_FIELD_NUMBER = 1;
        public static final int FILE_FIELD_NUMBER = 15;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private volatile Object error_;
        private List<File> file_;
        private byte memoizedIsInitialized;
        private static final CodeGeneratorResponse DEFAULT_INSTANCE = new CodeGeneratorResponse();
        @Deprecated
        public static final l0<CodeGeneratorResponse> PARSER = new a();

        /* loaded from: classes.dex */
        public static final class File extends GeneratedMessageV3 implements c {
            public static final int CONTENT_FIELD_NUMBER = 15;
            public static final int INSERTION_POINT_FIELD_NUMBER = 2;
            public static final int NAME_FIELD_NUMBER = 1;
            private static final long serialVersionUID = 0;
            private int bitField0_;
            private volatile Object content_;
            private volatile Object insertionPoint_;
            private byte memoizedIsInitialized;
            private volatile Object name_;
            private static final File DEFAULT_INSTANCE = new File();
            @Deprecated
            public static final l0<File> PARSER = new a();

            /* loaded from: classes.dex */
            static class a extends com.google.protobuf.c<File> {
                a() {
                }

                /* renamed from: a */
                public File parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
                    return new File(iVar, qVar, null);
                }
            }

            /* loaded from: classes.dex */
            public static final class b extends GeneratedMessageV3.b<b> implements c {

                /* renamed from: a  reason: collision with root package name */
                private int f13210a;

                /* renamed from: b  reason: collision with root package name */
                private Object f13211b;

                /* renamed from: c  reason: collision with root package name */
                private Object f13212c;

                /* renamed from: d  reason: collision with root package name */
                private Object f13213d;

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
                public File build() {
                    File c10 = buildPartial();
                    if (c10.isInitialized()) {
                        return c10;
                    }
                    throw a.AbstractC0170a.newUninitializedMessageException((d0) c10);
                }

                /* renamed from: c */
                public File buildPartial() {
                    File file = new File(this, (a) null);
                    int i10 = this.f13210a;
                    int i11 = 1;
                    if ((i10 & 1) != 1) {
                        i11 = 0;
                    }
                    file.name_ = this.f13211b;
                    if ((i10 & 2) == 2) {
                        i11 |= 2;
                    }
                    file.insertionPoint_ = this.f13212c;
                    if ((i10 & 4) == 4) {
                        i11 |= 4;
                    }
                    file.content_ = this.f13213d;
                    file.bitField0_ = i11;
                    onBuilt();
                    return file;
                }

                /* renamed from: d */
                public b clear() {
                    super.clear();
                    this.f13211b = "";
                    int i10 = this.f13210a & (-2);
                    this.f13210a = i10;
                    this.f13212c = "";
                    int i11 = i10 & (-3);
                    this.f13210a = i11;
                    this.f13213d = "";
                    this.f13210a = i11 & (-5);
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
                    return PluginProtos.f13202e;
                }

                /* renamed from: i */
                public File getDefaultInstanceForType() {
                    return File.getDefaultInstance();
                }

                @Override // com.google.protobuf.GeneratedMessageV3.b
                protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                    return PluginProtos.f13203f.e(File.class, b.class);
                }

                @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.f0
                public final boolean isInitialized() {
                    return true;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0021  */
                /* renamed from: j */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public b mergeFrom(i iVar, q qVar) throws IOException {
                    Throwable th2;
                    File file = null;
                    try {
                        try {
                            File parsePartialFrom = File.PARSER.parsePartialFrom(iVar, qVar);
                            if (parsePartialFrom != null) {
                                l(parsePartialFrom);
                            }
                            return this;
                        } catch (InvalidProtocolBufferException e10) {
                            file = (File) e10.getUnfinishedMessage();
                            try {
                                throw e10.unwrapIOException();
                            } catch (Throwable th3) {
                                th2 = th3;
                                if (file != null) {
                                    l(file);
                                }
                                throw th2;
                            }
                        }
                    } catch (Throwable th4) {
                        th2 = th4;
                        if (file != null) {
                        }
                        throw th2;
                    }
                }

                /* renamed from: k */
                public b mergeFrom(d0 d0Var) {
                    if (d0Var instanceof File) {
                        return l((File) d0Var);
                    }
                    super.mergeFrom(d0Var);
                    return this;
                }

                public b l(File file) {
                    if (file == File.getDefaultInstance()) {
                        return this;
                    }
                    if (file.hasName()) {
                        this.f13210a |= 1;
                        this.f13211b = file.name_;
                        onChanged();
                    }
                    if (file.hasInsertionPoint()) {
                        this.f13210a |= 2;
                        this.f13212c = file.insertionPoint_;
                        onChanged();
                    }
                    if (file.hasContent()) {
                        this.f13210a |= 4;
                        this.f13213d = file.content_;
                        onChanged();
                    }
                    mergeUnknownFields(((GeneratedMessageV3) file).unknownFields);
                    onChanged();
                    return this;
                }

                /* renamed from: m */
                public final b mergeUnknownFields(a1 a1Var) {
                    return (b) super.mergeUnknownFields(a1Var);
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
                    return (b) super.setUnknownFields(a1Var);
                }

                /* synthetic */ b(a aVar) {
                    this();
                }

                private b() {
                    this.f13211b = "";
                    this.f13212c = "";
                    this.f13213d = "";
                    maybeForceBuilderInitialization();
                }

                private b(GeneratedMessageV3.c cVar) {
                    super(cVar);
                    this.f13211b = "";
                    this.f13212c = "";
                    this.f13213d = "";
                    maybeForceBuilderInitialization();
                }
            }

            /* synthetic */ File(i iVar, q qVar, a aVar) throws InvalidProtocolBufferException {
                this(iVar, qVar);
            }

            public static File getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static final Descriptors.b getDescriptor() {
                return PluginProtos.f13202e;
            }

            public static b newBuilder() {
                return DEFAULT_INSTANCE.toBuilder();
            }

            public static File parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (File) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
            }

            public static File parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteString);
            }

            public static l0<File> parser() {
                return PARSER;
            }

            @Override // com.google.protobuf.a
            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof File)) {
                    return super.equals(obj);
                }
                File file = (File) obj;
                boolean z10 = hasName() == file.hasName();
                if (hasName()) {
                    z10 = z10 && getName().equals(file.getName());
                }
                boolean z11 = z10 && hasInsertionPoint() == file.hasInsertionPoint();
                if (hasInsertionPoint()) {
                    z11 = z11 && getInsertionPoint().equals(file.getInsertionPoint());
                }
                boolean z12 = z11 && hasContent() == file.hasContent();
                if (hasContent()) {
                    z12 = z12 && getContent().equals(file.getContent());
                }
                return z12 && this.unknownFields.equals(file.unknownFields);
            }

            public String getContent() {
                Object obj = this.content_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                ByteString byteString = (ByteString) obj;
                String stringUtf8 = byteString.toStringUtf8();
                if (byteString.isValidUtf8()) {
                    this.content_ = stringUtf8;
                }
                return stringUtf8;
            }

            public ByteString getContentBytes() {
                Object obj = this.content_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.content_ = copyFromUtf8;
                return copyFromUtf8;
            }

            public String getInsertionPoint() {
                Object obj = this.insertionPoint_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                ByteString byteString = (ByteString) obj;
                String stringUtf8 = byteString.toStringUtf8();
                if (byteString.isValidUtf8()) {
                    this.insertionPoint_ = stringUtf8;
                }
                return stringUtf8;
            }

            public ByteString getInsertionPointBytes() {
                Object obj = this.insertionPoint_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.insertionPoint_ = copyFromUtf8;
                return copyFromUtf8;
            }

            public String getName() {
                Object obj = this.name_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                ByteString byteString = (ByteString) obj;
                String stringUtf8 = byteString.toStringUtf8();
                if (byteString.isValidUtf8()) {
                    this.name_ = stringUtf8;
                }
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
            public l0<File> getParserForType() {
                return PARSER;
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
            public int getSerializedSize() {
                int i10 = this.memoizedSize;
                if (i10 != -1) {
                    return i10;
                }
                int i11 = 0;
                if ((this.bitField0_ & 1) == 1) {
                    i11 = 0 + GeneratedMessageV3.computeStringSize(1, this.name_);
                }
                if ((this.bitField0_ & 2) == 2) {
                    i11 += GeneratedMessageV3.computeStringSize(2, this.insertionPoint_);
                }
                if ((this.bitField0_ & 4) == 4) {
                    i11 += GeneratedMessageV3.computeStringSize(15, this.content_);
                }
                int serializedSize = i11 + this.unknownFields.getSerializedSize();
                this.memoizedSize = serializedSize;
                return serializedSize;
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.g0
            public final a1 getUnknownFields() {
                return this.unknownFields;
            }

            public boolean hasContent() {
                return (this.bitField0_ & 4) == 4;
            }

            public boolean hasInsertionPoint() {
                return (this.bitField0_ & 2) == 2;
            }

            public boolean hasName() {
                return (this.bitField0_ & 1) == 1;
            }

            @Override // com.google.protobuf.a
            public int hashCode() {
                int i10 = this.memoizedHashCode;
                if (i10 != 0) {
                    return i10;
                }
                int hashCode = 779 + getDescriptorForType().hashCode();
                if (hasName()) {
                    hashCode = (((hashCode * 37) + 1) * 53) + getName().hashCode();
                }
                if (hasInsertionPoint()) {
                    hashCode = (((hashCode * 37) + 2) * 53) + getInsertionPoint().hashCode();
                }
                if (hasContent()) {
                    hashCode = (((hashCode * 37) + 15) * 53) + getContent().hashCode();
                }
                int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
                this.memoizedHashCode = hashCode2;
                return hashCode2;
            }

            @Override // com.google.protobuf.GeneratedMessageV3
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return PluginProtos.f13203f.e(File.class, b.class);
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
                if ((this.bitField0_ & 1) == 1) {
                    GeneratedMessageV3.writeString(codedOutputStream, 1, this.name_);
                }
                if ((this.bitField0_ & 2) == 2) {
                    GeneratedMessageV3.writeString(codedOutputStream, 2, this.insertionPoint_);
                }
                if ((this.bitField0_ & 4) == 4) {
                    GeneratedMessageV3.writeString(codedOutputStream, 15, this.content_);
                }
                this.unknownFields.writeTo(codedOutputStream);
            }

            /* synthetic */ File(GeneratedMessageV3.b bVar, a aVar) {
                this(bVar);
            }

            public static b newBuilder(File file) {
                return DEFAULT_INSTANCE.toBuilder().l(file);
            }

            public static File parseFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteString, qVar);
            }

            private File(GeneratedMessageV3.b<?> bVar) {
                super(bVar);
                this.memoizedIsInitialized = (byte) -1;
            }

            public static File parseDelimitedFrom(InputStream inputStream, q qVar) throws IOException {
                return (File) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
            }

            public static File parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(bArr);
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
            public File getDefaultInstanceForType() {
                return DEFAULT_INSTANCE;
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
            public b toBuilder() {
                return this == DEFAULT_INSTANCE ? new b((a) null) : new b((a) null).l(this);
            }

            public static File parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(bArr, qVar);
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
            public b newBuilderForType() {
                return newBuilder();
            }

            private File() {
                this.memoizedIsInitialized = (byte) -1;
                this.name_ = "";
                this.insertionPoint_ = "";
                this.content_ = "";
            }

            public static File parseFrom(InputStream inputStream) throws IOException {
                return (File) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
            }

            public static File parseFrom(InputStream inputStream, q qVar) throws IOException {
                return (File) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
            }

            public static File parseFrom(i iVar) throws IOException {
                return (File) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
            }

            private File(i iVar, q qVar) throws InvalidProtocolBufferException {
                this();
                a1.b g10 = a1.g();
                boolean z10 = false;
                while (!z10) {
                    try {
                        try {
                            try {
                                int F = iVar.F();
                                if (F != 0) {
                                    if (F == 10) {
                                        ByteString m10 = iVar.m();
                                        this.bitField0_ = 1 | this.bitField0_;
                                        this.name_ = m10;
                                    } else if (F == 18) {
                                        ByteString m11 = iVar.m();
                                        this.bitField0_ |= 2;
                                        this.insertionPoint_ = m11;
                                    } else if (F == 122) {
                                        ByteString m12 = iVar.m();
                                        this.bitField0_ |= 4;
                                        this.content_ = m12;
                                    } else if (!parseUnknownField(iVar, g10, qVar, F)) {
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
                        this.unknownFields = g10.build();
                        makeExtensionsImmutable();
                    }
                }
            }

            public static File parseFrom(i iVar, q qVar) throws IOException {
                return (File) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
            }
        }

        /* loaded from: classes.dex */
        static class a extends com.google.protobuf.c<CodeGeneratorResponse> {
            a() {
            }

            /* renamed from: a */
            public CodeGeneratorResponse parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
                return new CodeGeneratorResponse(iVar, qVar, null);
            }
        }

        /* loaded from: classes.dex */
        public static final class b extends GeneratedMessageV3.b<b> implements g0 {

            /* renamed from: a  reason: collision with root package name */
            private int f13214a;

            /* renamed from: b  reason: collision with root package name */
            private Object f13215b;

            /* renamed from: c  reason: collision with root package name */
            private List<File> f13216c;

            /* renamed from: d  reason: collision with root package name */
            private o0<File, File.b, c> f13217d;

            /* synthetic */ b(GeneratedMessageV3.c cVar, a aVar) {
                this(cVar);
            }

            private void i() {
                if ((this.f13214a & 2) != 2) {
                    this.f13216c = new ArrayList(this.f13216c);
                    this.f13214a |= 2;
                }
            }

            private o0<File, File.b, c> k() {
                if (this.f13217d == null) {
                    this.f13217d = new o0<>(this.f13216c, (this.f13214a & 2) == 2, getParentForChildren(), isClean());
                    this.f13216c = null;
                }
                return this.f13217d;
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
            public CodeGeneratorResponse build() {
                CodeGeneratorResponse c10 = buildPartial();
                if (c10.isInitialized()) {
                    return c10;
                }
                throw a.AbstractC0170a.newUninitializedMessageException((d0) c10);
            }

            /* renamed from: c */
            public CodeGeneratorResponse buildPartial() {
                CodeGeneratorResponse codeGeneratorResponse = new CodeGeneratorResponse(this, (a) null);
                int i10 = 1;
                if ((this.f13214a & 1) != 1) {
                    i10 = 0;
                }
                codeGeneratorResponse.error_ = this.f13215b;
                o0<File, File.b, c> o0Var = this.f13217d;
                if (o0Var == null) {
                    if ((this.f13214a & 2) == 2) {
                        this.f13216c = Collections.unmodifiableList(this.f13216c);
                        this.f13214a &= -3;
                    }
                    codeGeneratorResponse.file_ = this.f13216c;
                } else {
                    codeGeneratorResponse.file_ = o0Var.g();
                }
                codeGeneratorResponse.bitField0_ = i10;
                onBuilt();
                return codeGeneratorResponse;
            }

            /* renamed from: d */
            public b clear() {
                super.clear();
                this.f13215b = "";
                this.f13214a &= -2;
                o0<File, File.b, c> o0Var = this.f13217d;
                if (o0Var == null) {
                    this.f13216c = Collections.emptyList();
                    this.f13214a &= -3;
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
                return PluginProtos.f13200c;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b
            protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
                return PluginProtos.f13201d.e(CodeGeneratorResponse.class, b.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.f0
            public final boolean isInitialized() {
                return true;
            }

            /* renamed from: j */
            public CodeGeneratorResponse getDefaultInstanceForType() {
                return CodeGeneratorResponse.getDefaultInstance();
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x0021  */
            /* renamed from: l */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public b mergeFrom(i iVar, q qVar) throws IOException {
                Throwable th2;
                CodeGeneratorResponse codeGeneratorResponse = null;
                try {
                    try {
                        CodeGeneratorResponse parsePartialFrom = CodeGeneratorResponse.PARSER.parsePartialFrom(iVar, qVar);
                        if (parsePartialFrom != null) {
                            n(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e10) {
                        codeGeneratorResponse = (CodeGeneratorResponse) e10.getUnfinishedMessage();
                        try {
                            throw e10.unwrapIOException();
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (codeGeneratorResponse != null) {
                                n(codeGeneratorResponse);
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (codeGeneratorResponse != null) {
                    }
                    throw th2;
                }
            }

            /* renamed from: m */
            public b mergeFrom(d0 d0Var) {
                if (d0Var instanceof CodeGeneratorResponse) {
                    return n((CodeGeneratorResponse) d0Var);
                }
                super.mergeFrom(d0Var);
                return this;
            }

            public b n(CodeGeneratorResponse codeGeneratorResponse) {
                if (codeGeneratorResponse == CodeGeneratorResponse.getDefaultInstance()) {
                    return this;
                }
                if (codeGeneratorResponse.hasError()) {
                    this.f13214a |= 1;
                    this.f13215b = codeGeneratorResponse.error_;
                    onChanged();
                }
                if (this.f13217d == null) {
                    if (!codeGeneratorResponse.file_.isEmpty()) {
                        if (this.f13216c.isEmpty()) {
                            this.f13216c = codeGeneratorResponse.file_;
                            this.f13214a &= -3;
                        } else {
                            i();
                            this.f13216c.addAll(codeGeneratorResponse.file_);
                        }
                        onChanged();
                    }
                } else if (!codeGeneratorResponse.file_.isEmpty()) {
                    if (this.f13217d.u()) {
                        this.f13217d.i();
                        o0<File, File.b, c> o0Var = null;
                        this.f13217d = null;
                        this.f13216c = codeGeneratorResponse.file_;
                        this.f13214a &= -3;
                        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                            o0Var = k();
                        }
                        this.f13217d = o0Var;
                    } else {
                        this.f13217d.b(codeGeneratorResponse.file_);
                    }
                }
                mergeUnknownFields(((GeneratedMessageV3) codeGeneratorResponse).unknownFields);
                onChanged();
                return this;
            }

            /* renamed from: o */
            public final b mergeUnknownFields(a1 a1Var) {
                return (b) super.mergeUnknownFields(a1Var);
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
                return (b) super.setUnknownFields(a1Var);
            }

            /* synthetic */ b(a aVar) {
                this();
            }

            private b() {
                this.f13215b = "";
                this.f13216c = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private b(GeneratedMessageV3.c cVar) {
                super(cVar);
                this.f13215b = "";
                this.f13216c = Collections.emptyList();
                maybeForceBuilderInitialization();
            }
        }

        /* loaded from: classes.dex */
        public interface c extends g0 {
        }

        /* synthetic */ CodeGeneratorResponse(i iVar, q qVar, a aVar) throws InvalidProtocolBufferException {
            this(iVar, qVar);
        }

        public static CodeGeneratorResponse getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.b getDescriptor() {
            return PluginProtos.f13200c;
        }

        public static b newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static CodeGeneratorResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (CodeGeneratorResponse) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static CodeGeneratorResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static l0<CodeGeneratorResponse> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof CodeGeneratorResponse)) {
                return super.equals(obj);
            }
            CodeGeneratorResponse codeGeneratorResponse = (CodeGeneratorResponse) obj;
            boolean z10 = hasError() == codeGeneratorResponse.hasError();
            if (hasError()) {
                z10 = z10 && getError().equals(codeGeneratorResponse.getError());
            }
            return (z10 && getFileList().equals(codeGeneratorResponse.getFileList())) && this.unknownFields.equals(codeGeneratorResponse.unknownFields);
        }

        public String getError() {
            Object obj = this.error_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.error_ = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getErrorBytes() {
            Object obj = this.error_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.error_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public File getFile(int i10) {
            return this.file_.get(i10);
        }

        public int getFileCount() {
            return this.file_.size();
        }

        public List<File> getFileList() {
            return this.file_;
        }

        public c getFileOrBuilder(int i10) {
            return this.file_.get(i10);
        }

        public List<? extends c> getFileOrBuilderList() {
            return this.file_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public l0<CodeGeneratorResponse> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.e0
        public int getSerializedSize() {
            int i10 = this.memoizedSize;
            if (i10 != -1) {
                return i10;
            }
            int computeStringSize = (this.bitField0_ & 1) == 1 ? GeneratedMessageV3.computeStringSize(1, this.error_) + 0 : 0;
            for (int i11 = 0; i11 < this.file_.size(); i11++) {
                computeStringSize += CodedOutputStream.E(15, this.file_.get(i11));
            }
            int serializedSize = computeStringSize + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.g0
        public final a1 getUnknownFields() {
            return this.unknownFields;
        }

        public boolean hasError() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // com.google.protobuf.a
        public int hashCode() {
            int i10 = this.memoizedHashCode;
            if (i10 != 0) {
                return i10;
            }
            int hashCode = 779 + getDescriptorForType().hashCode();
            if (hasError()) {
                hashCode = (((hashCode * 37) + 1) * 53) + getError().hashCode();
            }
            if (getFileCount() > 0) {
                hashCode = (((hashCode * 37) + 15) * 53) + getFileList().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.e internalGetFieldAccessorTable() {
            return PluginProtos.f13201d.e(CodeGeneratorResponse.class, b.class);
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
            if ((this.bitField0_ & 1) == 1) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.error_);
            }
            for (int i10 = 0; i10 < this.file_.size(); i10++) {
                codedOutputStream.A0(15, this.file_.get(i10));
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        /* synthetic */ CodeGeneratorResponse(GeneratedMessageV3.b bVar, a aVar) {
            this(bVar);
        }

        public static b newBuilder(CodeGeneratorResponse codeGeneratorResponse) {
            return DEFAULT_INSTANCE.toBuilder().n(codeGeneratorResponse);
        }

        public static CodeGeneratorResponse parseFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, qVar);
        }

        private CodeGeneratorResponse(GeneratedMessageV3.b<?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static CodeGeneratorResponse parseDelimitedFrom(InputStream inputStream, q qVar) throws IOException {
            return (CodeGeneratorResponse) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, qVar);
        }

        public static CodeGeneratorResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
        public CodeGeneratorResponse getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b toBuilder() {
            return this == DEFAULT_INSTANCE ? new b((a) null) : new b((a) null).n(this);
        }

        public static CodeGeneratorResponse parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, qVar);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public b newBuilderForType() {
            return newBuilder();
        }

        private CodeGeneratorResponse() {
            this.memoizedIsInitialized = (byte) -1;
            this.error_ = "";
            this.file_ = Collections.emptyList();
        }

        public static CodeGeneratorResponse parseFrom(InputStream inputStream) throws IOException {
            return (CodeGeneratorResponse) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static CodeGeneratorResponse parseFrom(InputStream inputStream, q qVar) throws IOException {
            return (CodeGeneratorResponse) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, qVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private CodeGeneratorResponse(i iVar, q qVar) throws InvalidProtocolBufferException {
            this();
            a1.b g10 = a1.g();
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
                                ByteString m10 = iVar.m();
                                this.bitField0_ = 1 | this.bitField0_;
                                this.error_ = m10;
                            } else if (F == 122) {
                                if (!(z11 & true)) {
                                    this.file_ = new ArrayList();
                                    z11 |= true;
                                }
                                this.file_.add(iVar.v(File.PARSER, qVar));
                            } else if (!parseUnknownField(iVar, g10, qVar, F)) {
                            }
                        }
                        z10 = true;
                    } catch (InvalidProtocolBufferException e10) {
                        throw e10.setUnfinishedMessage(this);
                    } catch (IOException e11) {
                        throw new InvalidProtocolBufferException(e11).setUnfinishedMessage(this);
                    }
                } finally {
                    if (z11 & true) {
                        this.file_ = Collections.unmodifiableList(this.file_);
                    }
                    this.unknownFields = g10.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static CodeGeneratorResponse parseFrom(i iVar) throws IOException {
            return (CodeGeneratorResponse) GeneratedMessageV3.parseWithIOException(PARSER, iVar);
        }

        public static CodeGeneratorResponse parseFrom(i iVar, q qVar) throws IOException {
            return (CodeGeneratorResponse) GeneratedMessageV3.parseWithIOException(PARSER, iVar, qVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a implements Descriptors.FileDescriptor.a {
        a() {
        }

        @Override // com.google.protobuf.Descriptors.FileDescriptor.a
        public o assignDescriptors(Descriptors.FileDescriptor fileDescriptor) {
            Descriptors.FileDescriptor unused = PluginProtos.f13204g = fileDescriptor;
            return null;
        }
    }

    static {
        Descriptors.FileDescriptor.q(new String[]{"\n%google/protobuf/compiler/plugin.proto\u0012\u0018google.protobuf.compiler\u001a google/protobuf/descriptor.proto\"}\n\u0014CodeGeneratorRequest\u0012\u0018\n\u0010file_to_generate\u0018\u0001 \u0003(\t\u0012\u0011\n\tparameter\u0018\u0002 \u0001(\t\u00128\n\nproto_file\u0018\u000f \u0003(\u000b2$.google.protobuf.FileDescriptorProto\"ª\u0001\n\u0015CodeGeneratorResponse\u0012\r\n\u0005error\u0018\u0001 \u0001(\t\u0012B\n\u0004file\u0018\u000f \u0003(\u000b24.google.protobuf.compiler.CodeGeneratorResponse.File\u001a>\n\u0004File\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u0012\u0017\n\u000finsertion_point\u0018\u0002 \u0001(\t\u0012\u000f\n\u0007content\u0018\u000f \u0001(\tB", "7\n\u001ccom.google.protobuf.compilerB\fPluginProtosZ\tplugin_go"}, new Descriptors.FileDescriptor[]{DescriptorProtos.Z()}, new a());
        Descriptors.b bVar = h().j().get(0);
        f13198a = bVar;
        f13199b = new GeneratedMessageV3.e(bVar, new String[]{"FileToGenerate", "Parameter", "ProtoFile"});
        Descriptors.b bVar2 = h().j().get(1);
        f13200c = bVar2;
        f13201d = new GeneratedMessageV3.e(bVar2, new String[]{"Error", "File"});
        Descriptors.b bVar3 = bVar2.m().get(0);
        f13202e = bVar3;
        f13203f = new GeneratedMessageV3.e(bVar3, new String[]{"Name", "InsertionPoint", "Content"});
        DescriptorProtos.Z();
    }

    public static Descriptors.FileDescriptor h() {
        return f13204g;
    }
}
