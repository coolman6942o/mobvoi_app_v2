package com.google.protobuf;

import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;
/* compiled from: EmptyProto.java */
/* loaded from: classes.dex */
public final class l {

    /* renamed from: a  reason: collision with root package name */
    static final Descriptors.b f13283a;

    /* renamed from: b  reason: collision with root package name */
    static final GeneratedMessageV3.e f13284b;

    /* renamed from: c  reason: collision with root package name */
    private static Descriptors.FileDescriptor f13285c;

    /* compiled from: EmptyProto.java */
    /* loaded from: classes.dex */
    static class a implements Descriptors.FileDescriptor.a {
        a() {
        }

        @Override // com.google.protobuf.Descriptors.FileDescriptor.a
        public o assignDescriptors(Descriptors.FileDescriptor fileDescriptor) {
            Descriptors.FileDescriptor unused = l.f13285c = fileDescriptor;
            return null;
        }
    }

    static {
        Descriptors.FileDescriptor.q(new String[]{"\n\u001bgoogle/protobuf/empty.proto\u0012\u000fgoogle.protobuf\"\u0007\n\u0005EmptyBv\n\u0013com.google.protobufB\nEmptyProtoP\u0001Z'github.com/golang/protobuf/ptypes/emptyø\u0001\u0001¢\u0002\u0003GPBª\u0002\u001eGoogle.Protobuf.WellKnownTypesb\u0006proto3"}, new Descriptors.FileDescriptor[0], new a());
        Descriptors.b bVar = b().j().get(0);
        f13283a = bVar;
        f13284b = new GeneratedMessageV3.e(bVar, new String[0]);
    }

    public static Descriptors.FileDescriptor b() {
        return f13285c;
    }
}
