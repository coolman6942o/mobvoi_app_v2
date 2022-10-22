package com.google.protobuf;

import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;
/* compiled from: AnyProto.java */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    static final Descriptors.b f13220a;

    /* renamed from: b  reason: collision with root package name */
    static final GeneratedMessageV3.e f13221b;

    /* renamed from: c  reason: collision with root package name */
    private static Descriptors.FileDescriptor f13222c;

    /* compiled from: AnyProto.java */
    /* loaded from: classes.dex */
    static class a implements Descriptors.FileDescriptor.a {
        a() {
        }

        @Override // com.google.protobuf.Descriptors.FileDescriptor.a
        public o assignDescriptors(Descriptors.FileDescriptor fileDescriptor) {
            Descriptors.FileDescriptor unused = f.f13222c = fileDescriptor;
            return null;
        }
    }

    static {
        Descriptors.FileDescriptor.q(new String[]{"\n\u0019google/protobuf/any.proto\u0012\u000fgoogle.protobuf\"&\n\u0003Any\u0012\u0010\n\btype_url\u0018\u0001 \u0001(\t\u0012\r\n\u0005value\u0018\u0002 \u0001(\fBo\n\u0013com.google.protobufB\bAnyProtoP\u0001Z%github.com/golang/protobuf/ptypes/any¢\u0002\u0003GPBª\u0002\u001eGoogle.Protobuf.WellKnownTypesb\u0006proto3"}, new Descriptors.FileDescriptor[0], new a());
        Descriptors.b bVar = b().j().get(0);
        f13220a = bVar;
        f13221b = new GeneratedMessageV3.e(bVar, new String[]{"TypeUrl", "Value"});
    }

    public static Descriptors.FileDescriptor b() {
        return f13222c;
    }
}
