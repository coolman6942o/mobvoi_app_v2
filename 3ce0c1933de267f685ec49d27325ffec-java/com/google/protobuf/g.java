package com.google.protobuf;

import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;
/* compiled from: ApiProto.java */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    static final Descriptors.b f13242a;

    /* renamed from: b  reason: collision with root package name */
    static final GeneratedMessageV3.e f13243b;

    /* renamed from: c  reason: collision with root package name */
    static final Descriptors.b f13244c;

    /* renamed from: d  reason: collision with root package name */
    static final GeneratedMessageV3.e f13245d;

    /* renamed from: e  reason: collision with root package name */
    static final Descriptors.b f13246e;

    /* renamed from: f  reason: collision with root package name */
    static final GeneratedMessageV3.e f13247f;

    /* renamed from: g  reason: collision with root package name */
    private static Descriptors.FileDescriptor f13248g;

    /* compiled from: ApiProto.java */
    /* loaded from: classes.dex */
    static class a implements Descriptors.FileDescriptor.a {
        a() {
        }

        @Override // com.google.protobuf.Descriptors.FileDescriptor.a
        public o assignDescriptors(Descriptors.FileDescriptor fileDescriptor) {
            Descriptors.FileDescriptor unused = g.f13248g = fileDescriptor;
            return null;
        }
    }

    static {
        Descriptors.FileDescriptor.q(new String[]{"\n\u0019google/protobuf/api.proto\u0012\u000fgoogle.protobuf\u001a$google/protobuf/source_context.proto\u001a\u001agoogle/protobuf/type.proto\"\u0081\u0002\n\u0003Api\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u0012(\n\u0007methods\u0018\u0002 \u0003(\u000b2\u0017.google.protobuf.Method\u0012(\n\u0007options\u0018\u0003 \u0003(\u000b2\u0017.google.protobuf.Option\u0012\u000f\n\u0007version\u0018\u0004 \u0001(\t\u00126\n\u000esource_context\u0018\u0005 \u0001(\u000b2\u001e.google.protobuf.SourceContext\u0012&\n\u0006mixins\u0018\u0006 \u0003(\u000b2\u0016.google.protobuf.Mixin\u0012'\n\u0006syntax\u0018\u0007 \u0001(\u000e2\u0017.google.protobuf.Syntax\"Õ\u0001\n\u0006Method\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u0012\u0018\n\u0010r", "equest_type_url\u0018\u0002 \u0001(\t\u0012\u0019\n\u0011request_streaming\u0018\u0003 \u0001(\b\u0012\u0019\n\u0011response_type_url\u0018\u0004 \u0001(\t\u0012\u001a\n\u0012response_streaming\u0018\u0005 \u0001(\b\u0012(\n\u0007options\u0018\u0006 \u0003(\u000b2\u0017.google.protobuf.Option\u0012'\n\u0006syntax\u0018\u0007 \u0001(\u000e2\u0017.google.protobuf.Syntax\"#\n\u0005Mixin\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u0012\f\n\u0004root\u0018\u0002 \u0001(\tBH\n\u0013com.google.protobufB\bApiProtoP\u0001¢\u0002\u0003GPBª\u0002\u001eGoogle.Protobuf.WellKnownTypesb\u0006proto3"}, new Descriptors.FileDescriptor[]{t0.b(), z0.b()}, new a());
        Descriptors.b bVar = b().j().get(0);
        f13242a = bVar;
        f13243b = new GeneratedMessageV3.e(bVar, new String[]{"Name", "Methods", "Options", "Version", "SourceContext", "Mixins", "Syntax"});
        Descriptors.b bVar2 = b().j().get(1);
        f13244c = bVar2;
        f13245d = new GeneratedMessageV3.e(bVar2, new String[]{"Name", "RequestTypeUrl", "RequestStreaming", "ResponseTypeUrl", "ResponseStreaming", "Options", "Syntax"});
        Descriptors.b bVar3 = b().j().get(2);
        f13246e = bVar3;
        f13247f = new GeneratedMessageV3.e(bVar3, new String[]{"Name", "Root"});
        t0.b();
        z0.b();
    }

    public static Descriptors.FileDescriptor b() {
        return f13248g;
    }
}
