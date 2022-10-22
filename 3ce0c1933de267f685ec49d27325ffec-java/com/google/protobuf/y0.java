package com.google.protobuf;

import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;
/* compiled from: TimestampProto.java */
/* loaded from: classes.dex */
public final class y0 {

    /* renamed from: a  reason: collision with root package name */
    static final Descriptors.b f13387a;

    /* renamed from: b  reason: collision with root package name */
    static final GeneratedMessageV3.e f13388b;

    /* renamed from: c  reason: collision with root package name */
    private static Descriptors.FileDescriptor f13389c;

    /* compiled from: TimestampProto.java */
    /* loaded from: classes.dex */
    static class a implements Descriptors.FileDescriptor.a {
        a() {
        }

        @Override // com.google.protobuf.Descriptors.FileDescriptor.a
        public o assignDescriptors(Descriptors.FileDescriptor fileDescriptor) {
            Descriptors.FileDescriptor unused = y0.f13389c = fileDescriptor;
            return null;
        }
    }

    static {
        Descriptors.FileDescriptor.q(new String[]{"\n\u001fgoogle/protobuf/timestamp.proto\u0012\u000fgoogle.protobuf\"+\n\tTimestamp\u0012\u000f\n\u0007seconds\u0018\u0001 \u0001(\u0003\u0012\r\n\u0005nanos\u0018\u0002 \u0001(\u0005B~\n\u0013com.google.protobufB\u000eTimestampProtoP\u0001Z+github.com/golang/protobuf/ptypes/timestampø\u0001\u0001¢\u0002\u0003GPBª\u0002\u001eGoogle.Protobuf.WellKnownTypesb\u0006proto3"}, new Descriptors.FileDescriptor[0], new a());
        Descriptors.b bVar = b().j().get(0);
        f13387a = bVar;
        f13388b = new GeneratedMessageV3.e(bVar, new String[]{"Seconds", "Nanos"});
    }

    public static Descriptors.FileDescriptor b() {
        return f13389c;
    }
}
