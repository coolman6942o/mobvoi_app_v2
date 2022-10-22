package com.google.protobuf;

import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;
/* compiled from: SourceContextProto.java */
/* loaded from: classes.dex */
public final class t0 {

    /* renamed from: a  reason: collision with root package name */
    static final Descriptors.b f13361a;

    /* renamed from: b  reason: collision with root package name */
    static final GeneratedMessageV3.e f13362b;

    /* renamed from: c  reason: collision with root package name */
    private static Descriptors.FileDescriptor f13363c;

    /* compiled from: SourceContextProto.java */
    /* loaded from: classes.dex */
    static class a implements Descriptors.FileDescriptor.a {
        a() {
        }

        @Override // com.google.protobuf.Descriptors.FileDescriptor.a
        public o assignDescriptors(Descriptors.FileDescriptor fileDescriptor) {
            Descriptors.FileDescriptor unused = t0.f13363c = fileDescriptor;
            return null;
        }
    }

    static {
        Descriptors.FileDescriptor.q(new String[]{"\n$google/protobuf/source_context.proto\u0012\u000fgoogle.protobuf\"\"\n\rSourceContext\u0012\u0011\n\tfile_name\u0018\u0001 \u0001(\tBR\n\u0013com.google.protobufB\u0012SourceContextProtoP\u0001¢\u0002\u0003GPBª\u0002\u001eGoogle.Protobuf.WellKnownTypesb\u0006proto3"}, new Descriptors.FileDescriptor[0], new a());
        Descriptors.b bVar = b().j().get(0);
        f13361a = bVar;
        f13362b = new GeneratedMessageV3.e(bVar, new String[]{"FileName"});
    }

    public static Descriptors.FileDescriptor b() {
        return f13363c;
    }
}
