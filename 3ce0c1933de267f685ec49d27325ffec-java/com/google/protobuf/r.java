package com.google.protobuf;

import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;
/* compiled from: FieldMaskProto.java */
/* loaded from: classes.dex */
public final class r {

    /* renamed from: a  reason: collision with root package name */
    static final Descriptors.b f13337a;

    /* renamed from: b  reason: collision with root package name */
    static final GeneratedMessageV3.e f13338b;

    /* renamed from: c  reason: collision with root package name */
    private static Descriptors.FileDescriptor f13339c;

    /* compiled from: FieldMaskProto.java */
    /* loaded from: classes.dex */
    static class a implements Descriptors.FileDescriptor.a {
        a() {
        }

        @Override // com.google.protobuf.Descriptors.FileDescriptor.a
        public o assignDescriptors(Descriptors.FileDescriptor fileDescriptor) {
            Descriptors.FileDescriptor unused = r.f13339c = fileDescriptor;
            return null;
        }
    }

    static {
        Descriptors.FileDescriptor.q(new String[]{"\n google/protobuf/field_mask.proto\u0012\u000fgoogle.protobuf\"\u001a\n\tFieldMask\u0012\r\n\u0005paths\u0018\u0001 \u0003(\tBN\n\u0013com.google.protobufB\u000eFieldMaskProtoP\u0001¢\u0002\u0003GPBª\u0002\u001eGoogle.Protobuf.WellKnownTypesb\u0006proto3"}, new Descriptors.FileDescriptor[0], new a());
        Descriptors.b bVar = b().j().get(0);
        f13337a = bVar;
        f13338b = new GeneratedMessageV3.e(bVar, new String[]{"Paths"});
    }

    public static Descriptors.FileDescriptor b() {
        return f13339c;
    }
}
