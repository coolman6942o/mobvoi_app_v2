package com.google.protobuf;

import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;
/* compiled from: TypeProto.java */
/* loaded from: classes.dex */
public final class z0 {

    /* renamed from: a  reason: collision with root package name */
    static final Descriptors.b f13390a;

    /* renamed from: b  reason: collision with root package name */
    static final GeneratedMessageV3.e f13391b;

    /* renamed from: c  reason: collision with root package name */
    static final Descriptors.b f13392c;

    /* renamed from: d  reason: collision with root package name */
    static final GeneratedMessageV3.e f13393d;

    /* renamed from: e  reason: collision with root package name */
    static final Descriptors.b f13394e;

    /* renamed from: f  reason: collision with root package name */
    static final GeneratedMessageV3.e f13395f;

    /* renamed from: g  reason: collision with root package name */
    static final Descriptors.b f13396g;

    /* renamed from: h  reason: collision with root package name */
    static final GeneratedMessageV3.e f13397h;

    /* renamed from: i  reason: collision with root package name */
    static final Descriptors.b f13398i;

    /* renamed from: j  reason: collision with root package name */
    static final GeneratedMessageV3.e f13399j;

    /* renamed from: k  reason: collision with root package name */
    private static Descriptors.FileDescriptor f13400k;

    /* compiled from: TypeProto.java */
    /* loaded from: classes.dex */
    static class a implements Descriptors.FileDescriptor.a {
        a() {
        }

        @Override // com.google.protobuf.Descriptors.FileDescriptor.a
        public o assignDescriptors(Descriptors.FileDescriptor fileDescriptor) {
            Descriptors.FileDescriptor unused = z0.f13400k = fileDescriptor;
            return null;
        }
    }

    static {
        Descriptors.FileDescriptor.q(new String[]{"\n\u001agoogle/protobuf/type.proto\u0012\u000fgoogle.protobuf\u001a\u0019google/protobuf/any.proto\u001a$google/protobuf/source_context.proto\"×\u0001\n\u0004Type\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u0012&\n\u0006fields\u0018\u0002 \u0003(\u000b2\u0016.google.protobuf.Field\u0012\u000e\n\u0006oneofs\u0018\u0003 \u0003(\t\u0012(\n\u0007options\u0018\u0004 \u0003(\u000b2\u0017.google.protobuf.Option\u00126\n\u000esource_context\u0018\u0005 \u0001(\u000b2\u001e.google.protobuf.SourceContext\u0012'\n\u0006syntax\u0018\u0006 \u0001(\u000e2\u0017.google.protobuf.Syntax\"Õ\u0005\n\u0005Field\u0012)\n\u0004kind\u0018\u0001 \u0001(\u000e2\u001b.google.protobuf.Field.Kind\u00127\n\u000bcardinality\u0018\u0002 \u0001", "(\u000e2\".google.protobuf.Field.Cardinality\u0012\u000e\n\u0006number\u0018\u0003 \u0001(\u0005\u0012\f\n\u0004name\u0018\u0004 \u0001(\t\u0012\u0010\n\btype_url\u0018\u0006 \u0001(\t\u0012\u0013\n\u000boneof_index\u0018\u0007 \u0001(\u0005\u0012\u000e\n\u0006packed\u0018\b \u0001(\b\u0012(\n\u0007options\u0018\t \u0003(\u000b2\u0017.google.protobuf.Option\u0012\u0011\n\tjson_name\u0018\n \u0001(\t\u0012\u0015\n\rdefault_value\u0018\u000b \u0001(\t\"È\u0002\n\u0004Kind\u0012\u0010\n\fTYPE_UNKNOWN\u0010\u0000\u0012\u000f\n\u000bTYPE_DOUBLE\u0010\u0001\u0012\u000e\n\nTYPE_FLOAT\u0010\u0002\u0012\u000e\n\nTYPE_INT64\u0010\u0003\u0012\u000f\n\u000bTYPE_UINT64\u0010\u0004\u0012\u000e\n\nTYPE_INT32\u0010\u0005\u0012\u0010\n\fTYPE_FIXED64\u0010\u0006\u0012\u0010\n\fTYPE_FIXED32\u0010\u0007\u0012\r\n\tTYPE_BOOL\u0010\b\u0012\u000f\n\u000bTYPE_STRING\u0010\t\u0012\u000e\n\nTYPE_GROUP\u0010\n", "\u0012\u0010\n\fTYPE_MESSAGE\u0010\u000b\u0012\u000e\n\nTYPE_BYTES\u0010\f\u0012\u000f\n\u000bTYPE_UINT32\u0010\r\u0012\r\n\tTYPE_ENUM\u0010\u000e\u0012\u0011\n\rTYPE_SFIXED32\u0010\u000f\u0012\u0011\n\rTYPE_SFIXED64\u0010\u0010\u0012\u000f\n\u000bTYPE_SINT32\u0010\u0011\u0012\u000f\n\u000bTYPE_SINT64\u0010\u0012\"t\n\u000bCardinality\u0012\u0017\n\u0013CARDINALITY_UNKNOWN\u0010\u0000\u0012\u0018\n\u0014CARDINALITY_OPTIONAL\u0010\u0001\u0012\u0018\n\u0014CARDINALITY_REQUIRED\u0010\u0002\u0012\u0018\n\u0014CARDINALITY_REPEATED\u0010\u0003\"Î\u0001\n\u0004Enum\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u0012-\n\tenumvalue\u0018\u0002 \u0003(\u000b2\u001a.google.protobuf.EnumValue\u0012(\n\u0007options\u0018\u0003 \u0003(\u000b2\u0017.google.protobuf.Option\u00126\n\u000esource_context\u0018\u0004 \u0001(\u000b2\u001e.googl", "e.protobuf.SourceContext\u0012'\n\u0006syntax\u0018\u0005 \u0001(\u000e2\u0017.google.protobuf.Syntax\"S\n\tEnumValue\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u0012\u000e\n\u0006number\u0018\u0002 \u0001(\u0005\u0012(\n\u0007options\u0018\u0003 \u0003(\u000b2\u0017.google.protobuf.Option\";\n\u0006Option\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u0012#\n\u0005value\u0018\u0002 \u0001(\u000b2\u0014.google.protobuf.Any*.\n\u0006Syntax\u0012\u0011\n\rSYNTAX_PROTO2\u0010\u0000\u0012\u0011\n\rSYNTAX_PROTO3\u0010\u0001BL\n\u0013com.google.protobufB\tTypeProtoP\u0001ø\u0001\u0001¢\u0002\u0003GPBª\u0002\u001eGoogle.Protobuf.WellKnownTypesb\u0006proto3"}, new Descriptors.FileDescriptor[]{f.b(), t0.b()}, new a());
        Descriptors.b bVar = b().j().get(0);
        f13390a = bVar;
        f13391b = new GeneratedMessageV3.e(bVar, new String[]{"Name", "Fields", "Oneofs", "Options", "SourceContext", "Syntax"});
        Descriptors.b bVar2 = b().j().get(1);
        f13392c = bVar2;
        f13393d = new GeneratedMessageV3.e(bVar2, new String[]{"Kind", "Cardinality", "Number", "Name", "TypeUrl", "OneofIndex", "Packed", "Options", "JsonName", "DefaultValue"});
        Descriptors.b bVar3 = b().j().get(2);
        f13394e = bVar3;
        f13395f = new GeneratedMessageV3.e(bVar3, new String[]{"Name", "Enumvalue", "Options", "SourceContext", "Syntax"});
        Descriptors.b bVar4 = b().j().get(3);
        f13396g = bVar4;
        f13397h = new GeneratedMessageV3.e(bVar4, new String[]{"Name", "Number", "Options"});
        Descriptors.b bVar5 = b().j().get(4);
        f13398i = bVar5;
        f13399j = new GeneratedMessageV3.e(bVar5, new String[]{"Name", "Value"});
        f.b();
        t0.b();
    }

    public static Descriptors.FileDescriptor b() {
        return f13400k;
    }
}
