package com.google.protobuf;

import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;
/* compiled from: StructProto.java */
/* loaded from: classes.dex */
public final class v0 {

    /* renamed from: a  reason: collision with root package name */
    static final Descriptors.b f13370a;

    /* renamed from: b  reason: collision with root package name */
    static final GeneratedMessageV3.e f13371b;

    /* renamed from: c  reason: collision with root package name */
    static final Descriptors.b f13372c;

    /* renamed from: d  reason: collision with root package name */
    static final Descriptors.b f13373d;

    /* renamed from: e  reason: collision with root package name */
    static final GeneratedMessageV3.e f13374e;

    /* renamed from: f  reason: collision with root package name */
    static final Descriptors.b f13375f;

    /* renamed from: g  reason: collision with root package name */
    static final GeneratedMessageV3.e f13376g;

    /* renamed from: h  reason: collision with root package name */
    private static Descriptors.FileDescriptor f13377h;

    /* compiled from: StructProto.java */
    /* loaded from: classes.dex */
    static class a implements Descriptors.FileDescriptor.a {
        a() {
        }

        @Override // com.google.protobuf.Descriptors.FileDescriptor.a
        public o assignDescriptors(Descriptors.FileDescriptor fileDescriptor) {
            Descriptors.FileDescriptor unused = v0.f13377h = fileDescriptor;
            return null;
        }
    }

    static {
        Descriptors.FileDescriptor.q(new String[]{"\n\u001cgoogle/protobuf/struct.proto\u0012\u000fgoogle.protobuf\"\u0084\u0001\n\u0006Struct\u00123\n\u0006fields\u0018\u0001 \u0003(\u000b2#.google.protobuf.Struct.FieldsEntry\u001aE\n\u000bFieldsEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\t\u0012%\n\u0005value\u0018\u0002 \u0001(\u000b2\u0016.google.protobuf.Value:\u00028\u0001\"ê\u0001\n\u0005Value\u00120\n\nnull_value\u0018\u0001 \u0001(\u000e2\u001a.google.protobuf.NullValueH\u0000\u0012\u0016\n\fnumber_value\u0018\u0002 \u0001(\u0001H\u0000\u0012\u0016\n\fstring_value\u0018\u0003 \u0001(\tH\u0000\u0012\u0014\n\nbool_value\u0018\u0004 \u0001(\bH\u0000\u0012/\n\fstruct_value\u0018\u0005 \u0001(\u000b2\u0017.google.protobuf.StructH\u0000\u00120\n\nlist_value\u0018\u0006 \u0001(\u000b2\u001a.google.protobuf.", "ListValueH\u0000B\u0006\n\u0004kind\"3\n\tListValue\u0012&\n\u0006values\u0018\u0001 \u0003(\u000b2\u0016.google.protobuf.Value*\u001b\n\tNullValue\u0012\u000e\n\nNULL_VALUE\u0010\u0000B\u0081\u0001\n\u0013com.google.protobufB\u000bStructProtoP\u0001Z1github.com/golang/protobuf/ptypes/struct;structpbø\u0001\u0001¢\u0002\u0003GPBª\u0002\u001eGoogle.Protobuf.WellKnownTypesb\u0006proto3"}, new Descriptors.FileDescriptor[0], new a());
        Descriptors.b bVar = b().j().get(0);
        f13370a = bVar;
        f13371b = new GeneratedMessageV3.e(bVar, new String[]{"Fields"});
        Descriptors.b bVar2 = bVar.m().get(0);
        f13372c = bVar2;
        new GeneratedMessageV3.e(bVar2, new String[]{"Key", "Value"});
        Descriptors.b bVar3 = b().j().get(1);
        f13373d = bVar3;
        f13374e = new GeneratedMessageV3.e(bVar3, new String[]{"NullValue", "NumberValue", "StringValue", "BoolValue", "StructValue", "ListValue", "Kind"});
        Descriptors.b bVar4 = b().j().get(2);
        f13375f = bVar4;
        f13376g = new GeneratedMessageV3.e(bVar4, new String[]{"Values"});
    }

    public static Descriptors.FileDescriptor b() {
        return f13377h;
    }
}
