package com.google.protobuf;

import com.google.protobuf.Descriptors;
import com.google.protobuf.WireFormat;
import com.google.protobuf.a1;
import com.google.protobuf.d0;
import com.google.protobuf.o;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class MessageReflection {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface MergeTarget {

        /* loaded from: classes.dex */
        public enum ContainerType {
            MESSAGE,
            EXTENSION_SET
        }

        Object a(i iVar, q qVar, Descriptors.FieldDescriptor fieldDescriptor, d0 d0Var) throws IOException;

        MergeTarget addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj);

        Object b(i iVar, q qVar, Descriptors.FieldDescriptor fieldDescriptor, d0 d0Var) throws IOException;

        o.b c(o oVar, Descriptors.b bVar, int i10);

        ContainerType d();

        WireFormat.b e(Descriptors.FieldDescriptor fieldDescriptor);

        Object f(ByteString byteString, q qVar, Descriptors.FieldDescriptor fieldDescriptor, d0 d0Var) throws IOException;

        boolean hasField(Descriptors.FieldDescriptor fieldDescriptor);

        MergeTarget setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj);
    }

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f13091a;

        static {
            int[] iArr = new int[Descriptors.FieldDescriptor.Type.values().length];
            f13091a = iArr;
            try {
                iArr[Descriptors.FieldDescriptor.Type.GROUP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f13091a[Descriptors.FieldDescriptor.Type.MESSAGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f13091a[Descriptors.FieldDescriptor.Type.ENUM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes.dex */
    static class b implements MergeTarget {

        /* renamed from: a  reason: collision with root package name */
        private final d0.a f13092a;

        public b(d0.a aVar) {
            this.f13092a = aVar;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object a(i iVar, q qVar, Descriptors.FieldDescriptor fieldDescriptor, d0 d0Var) throws IOException {
            d0.a aVar;
            d0 d0Var2;
            if (d0Var != null) {
                aVar = d0Var.newBuilderForType();
            } else {
                aVar = this.f13092a.newBuilderForField(fieldDescriptor);
            }
            if (!fieldDescriptor.o() && (d0Var2 = (d0) g(fieldDescriptor)) != null) {
                aVar.mergeFrom(d0Var2);
            }
            iVar.w(aVar, qVar);
            return aVar.buildPartial();
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            this.f13092a.addRepeatedField(fieldDescriptor, obj);
            return this;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object b(i iVar, q qVar, Descriptors.FieldDescriptor fieldDescriptor, d0 d0Var) throws IOException {
            d0.a aVar;
            d0 d0Var2;
            if (d0Var != null) {
                aVar = d0Var.newBuilderForType();
            } else {
                aVar = this.f13092a.newBuilderForField(fieldDescriptor);
            }
            if (!fieldDescriptor.o() && (d0Var2 = (d0) g(fieldDescriptor)) != null) {
                aVar.mergeFrom(d0Var2);
            }
            iVar.s(fieldDescriptor.getNumber(), aVar, qVar);
            return aVar.buildPartial();
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public o.b c(o oVar, Descriptors.b bVar, int i10) {
            return oVar.d(bVar, i10);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget.ContainerType d() {
            return MergeTarget.ContainerType.MESSAGE;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public WireFormat.b e(Descriptors.FieldDescriptor fieldDescriptor) {
            if (fieldDescriptor.D()) {
                return WireFormat.b.STRICT;
            }
            fieldDescriptor.o();
            return WireFormat.b.LOOSE;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object f(ByteString byteString, q qVar, Descriptors.FieldDescriptor fieldDescriptor, d0 d0Var) throws IOException {
            d0.a aVar;
            d0 d0Var2;
            if (d0Var != null) {
                aVar = d0Var.newBuilderForType();
            } else {
                aVar = this.f13092a.newBuilderForField(fieldDescriptor);
            }
            if (!fieldDescriptor.o() && (d0Var2 = (d0) g(fieldDescriptor)) != null) {
                aVar.mergeFrom(d0Var2);
            }
            aVar.mergeFrom(byteString, qVar);
            return aVar.buildPartial();
        }

        public Object g(Descriptors.FieldDescriptor fieldDescriptor) {
            return this.f13092a.getField(fieldDescriptor);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public boolean hasField(Descriptors.FieldDescriptor fieldDescriptor) {
            return this.f13092a.hasField(fieldDescriptor);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            this.f13092a.setField(fieldDescriptor, obj);
            return this;
        }
    }

    /* loaded from: classes.dex */
    static class c implements MergeTarget {

        /* renamed from: a  reason: collision with root package name */
        private final t<Descriptors.FieldDescriptor> f13093a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(t<Descriptors.FieldDescriptor> tVar) {
            this.f13093a = tVar;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object a(i iVar, q qVar, Descriptors.FieldDescriptor fieldDescriptor, d0 d0Var) throws IOException {
            d0 d0Var2;
            d0.a newBuilderForType = d0Var.newBuilderForType();
            if (!fieldDescriptor.o() && (d0Var2 = (d0) g(fieldDescriptor)) != null) {
                newBuilderForType.mergeFrom(d0Var2);
            }
            iVar.w(newBuilderForType, qVar);
            return newBuilderForType.buildPartial();
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            this.f13093a.a(fieldDescriptor, obj);
            return this;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object b(i iVar, q qVar, Descriptors.FieldDescriptor fieldDescriptor, d0 d0Var) throws IOException {
            d0 d0Var2;
            d0.a newBuilderForType = d0Var.newBuilderForType();
            if (!fieldDescriptor.o() && (d0Var2 = (d0) g(fieldDescriptor)) != null) {
                newBuilderForType.mergeFrom(d0Var2);
            }
            iVar.s(fieldDescriptor.getNumber(), newBuilderForType, qVar);
            return newBuilderForType.buildPartial();
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public o.b c(o oVar, Descriptors.b bVar, int i10) {
            return oVar.d(bVar, i10);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget.ContainerType d() {
            return MergeTarget.ContainerType.EXTENSION_SET;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public WireFormat.b e(Descriptors.FieldDescriptor fieldDescriptor) {
            if (fieldDescriptor.D()) {
                return WireFormat.b.STRICT;
            }
            return WireFormat.b.LOOSE;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object f(ByteString byteString, q qVar, Descriptors.FieldDescriptor fieldDescriptor, d0 d0Var) throws IOException {
            d0 d0Var2;
            d0.a newBuilderForType = d0Var.newBuilderForType();
            if (!fieldDescriptor.o() && (d0Var2 = (d0) g(fieldDescriptor)) != null) {
                newBuilderForType.mergeFrom(d0Var2);
            }
            newBuilderForType.mergeFrom(byteString, qVar);
            return newBuilderForType.buildPartial();
        }

        public Object g(Descriptors.FieldDescriptor fieldDescriptor) {
            return this.f13093a.l(fieldDescriptor);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public boolean hasField(Descriptors.FieldDescriptor fieldDescriptor) {
            return this.f13093a.s(fieldDescriptor);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            this.f13093a.C(fieldDescriptor, obj);
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(List<String> list) {
        StringBuilder sb2 = new StringBuilder();
        for (String str : list) {
            if (sb2.length() > 0) {
                sb2.append(", ");
            }
            sb2.append(str);
        }
        return sb2.toString();
    }

    private static void b(i iVar, o.b bVar, q qVar, MergeTarget mergeTarget) throws IOException {
        Descriptors.FieldDescriptor fieldDescriptor = bVar.f13306a;
        mergeTarget.setField(fieldDescriptor, mergeTarget.a(iVar, qVar, fieldDescriptor, bVar.f13307b));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<String> c(g0 g0Var) {
        ArrayList arrayList = new ArrayList();
        d(g0Var, "", arrayList);
        return arrayList;
    }

    private static void d(g0 g0Var, String str, List<String> list) {
        for (Descriptors.FieldDescriptor fieldDescriptor : g0Var.getDescriptorForType().l()) {
            if (fieldDescriptor.C() && !g0Var.hasField(fieldDescriptor)) {
                list.add(str + fieldDescriptor.c());
            }
        }
        for (Map.Entry<Descriptors.FieldDescriptor, Object> entry : g0Var.getAllFields().entrySet()) {
            Descriptors.FieldDescriptor key = entry.getKey();
            Object value = entry.getValue();
            if (key.u() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                if (key.o()) {
                    int i10 = 0;
                    for (g0 g0Var2 : (List) value) {
                        i10++;
                        d(g0Var2, j(str, key, i10), list);
                    }
                } else if (g0Var.hasField(key)) {
                    d((g0) value, j(str, key, -1), list);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int e(d0 d0Var, Map<Descriptors.FieldDescriptor, Object> map) {
        int i10;
        int i11;
        boolean messageSetWireFormat = d0Var.getDescriptorForType().q().getMessageSetWireFormat();
        int i12 = 0;
        for (Map.Entry<Descriptors.FieldDescriptor, Object> entry : map.entrySet()) {
            Descriptors.FieldDescriptor key = entry.getKey();
            Object value = entry.getValue();
            if (!messageSetWireFormat || !key.y() || key.x() != Descriptors.FieldDescriptor.Type.MESSAGE || key.o()) {
                i11 = t.i(key, value);
            } else {
                i11 = CodedOutputStream.D(key.getNumber(), (d0) value);
            }
            i12 += i11;
        }
        a1 unknownFields = d0Var.getUnknownFields();
        if (messageSetWireFormat) {
            i10 = unknownFields.f();
        } else {
            i10 = unknownFields.getSerializedSize();
        }
        return i12 + i10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean f(g0 g0Var) {
        for (Descriptors.FieldDescriptor fieldDescriptor : g0Var.getDescriptorForType().l()) {
            if (fieldDescriptor.C() && !g0Var.hasField(fieldDescriptor)) {
                return false;
            }
        }
        for (Map.Entry<Descriptors.FieldDescriptor, Object> entry : g0Var.getAllFields().entrySet()) {
            Descriptors.FieldDescriptor key = entry.getKey();
            if (key.u() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                if (key.o()) {
                    for (d0 d0Var : (List) entry.getValue()) {
                        if (!d0Var.isInitialized()) {
                            return false;
                        }
                    }
                    continue;
                } else if (!((d0) entry.getValue()).isInitialized()) {
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0098  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean g(i iVar, a1.b bVar, q qVar, Descriptors.b bVar2, MergeTarget mergeTarget, int i10) throws IOException {
        d0 d0Var;
        boolean z10;
        boolean z11;
        Object obj;
        o.b c10;
        if (!bVar2.q().getMessageSetWireFormat() || i10 != WireFormat.f13141a) {
            int b10 = WireFormat.b(i10);
            int a10 = WireFormat.a(i10);
            Descriptors.FieldDescriptor fieldDescriptor = null;
            if (bVar2.u(a10)) {
                if ((qVar instanceof o) && (c10 = mergeTarget.c((o) qVar, bVar2, a10)) != null) {
                    Descriptors.FieldDescriptor fieldDescriptor2 = c10.f13306a;
                    d0 d0Var2 = c10.f13307b;
                    if (d0Var2 == null && fieldDescriptor2.u() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                        throw new IllegalStateException("Message-typed extension lacked default instance: " + fieldDescriptor2.b());
                    }
                    d0Var = d0Var2;
                    fieldDescriptor = fieldDescriptor2;
                    z10 = false;
                    if (fieldDescriptor != null) {
                        if (b10 == t.r(fieldDescriptor.p(), false)) {
                            z11 = false;
                        } else if (fieldDescriptor.B() && b10 == t.r(fieldDescriptor.p(), true)) {
                            z11 = true;
                        }
                        if (z10) {
                            return bVar.l(i10, iVar);
                        }
                        if (z11) {
                            int k10 = iVar.k(iVar.x());
                            if (fieldDescriptor.p() == WireFormat.FieldType.ENUM) {
                                while (iVar.d() > 0) {
                                    int o10 = iVar.o();
                                    if (fieldDescriptor.a().v()) {
                                        mergeTarget.addRepeatedField(fieldDescriptor, fieldDescriptor.m().h(o10));
                                    } else {
                                        Descriptors.e g10 = fieldDescriptor.m().g(o10);
                                        if (g10 == null) {
                                            return true;
                                        }
                                        mergeTarget.addRepeatedField(fieldDescriptor, g10);
                                    }
                                }
                            } else {
                                while (iVar.d() > 0) {
                                    mergeTarget.addRepeatedField(fieldDescriptor, WireFormat.d(iVar, fieldDescriptor.p(), mergeTarget.e(fieldDescriptor)));
                                }
                            }
                            iVar.j(k10);
                        } else {
                            int i11 = a.f13091a[fieldDescriptor.x().ordinal()];
                            if (i11 == 1) {
                                obj = mergeTarget.b(iVar, qVar, fieldDescriptor, d0Var);
                            } else if (i11 == 2) {
                                obj = mergeTarget.a(iVar, qVar, fieldDescriptor, d0Var);
                            } else if (i11 != 3) {
                                obj = WireFormat.d(iVar, fieldDescriptor.p(), mergeTarget.e(fieldDescriptor));
                            } else {
                                int o11 = iVar.o();
                                if (fieldDescriptor.a().v()) {
                                    obj = fieldDescriptor.m().h(o11);
                                } else {
                                    Descriptors.e g11 = fieldDescriptor.m().g(o11);
                                    if (g11 == null) {
                                        bVar.q(a10, o11);
                                        return true;
                                    }
                                    obj = g11;
                                }
                            }
                            if (fieldDescriptor.o()) {
                                mergeTarget.addRepeatedField(fieldDescriptor, obj);
                            } else {
                                mergeTarget.setField(fieldDescriptor, obj);
                            }
                        }
                        return true;
                    }
                    z11 = false;
                    z10 = true;
                    if (z10) {
                    }
                }
                d0Var = null;
                z10 = false;
                if (fieldDescriptor != null) {
                }
                z11 = false;
                z10 = true;
                if (z10) {
                }
            } else {
                if (mergeTarget.d() == MergeTarget.ContainerType.MESSAGE) {
                    fieldDescriptor = bVar2.i(a10);
                    d0Var = null;
                    z10 = false;
                    if (fieldDescriptor != null) {
                    }
                    z11 = false;
                    z10 = true;
                    if (z10) {
                    }
                }
                d0Var = null;
                z10 = false;
                if (fieldDescriptor != null) {
                }
                z11 = false;
                z10 = true;
                if (z10) {
                }
            }
        } else {
            i(iVar, bVar, qVar, bVar2, mergeTarget);
            return true;
        }
    }

    private static void h(ByteString byteString, o.b bVar, q qVar, MergeTarget mergeTarget) throws IOException {
        Descriptors.FieldDescriptor fieldDescriptor = bVar.f13306a;
        if (mergeTarget.hasField(fieldDescriptor) || q.b()) {
            mergeTarget.setField(fieldDescriptor, mergeTarget.f(byteString, qVar, fieldDescriptor, bVar.f13307b));
        } else {
            mergeTarget.setField(fieldDescriptor, new v(bVar.f13307b, qVar, byteString));
        }
    }

    private static void i(i iVar, a1.b bVar, q qVar, Descriptors.b bVar2, MergeTarget mergeTarget) throws IOException {
        int i10 = 0;
        ByteString byteString = null;
        o.b bVar3 = null;
        while (true) {
            int F = iVar.F();
            if (F == 0) {
                break;
            } else if (F == WireFormat.f13143c) {
                i10 = iVar.G();
                if (i10 != 0 && (qVar instanceof o)) {
                    bVar3 = mergeTarget.c((o) qVar, bVar2, i10);
                }
            } else if (F == WireFormat.f13144d) {
                if (i10 == 0 || bVar3 == null || !q.b()) {
                    byteString = iVar.m();
                } else {
                    b(iVar, bVar3, qVar, mergeTarget);
                    byteString = null;
                }
            } else if (!iVar.I(F)) {
                break;
            }
        }
        iVar.a(WireFormat.f13142b);
        if (byteString != null && i10 != 0) {
            if (bVar3 != null) {
                h(byteString, bVar3, qVar, mergeTarget);
            } else {
                bVar.k(i10, a1.c.s().e(byteString).g());
            }
        }
    }

    private static String j(String str, Descriptors.FieldDescriptor fieldDescriptor, int i10) {
        StringBuilder sb2 = new StringBuilder(str);
        if (fieldDescriptor.y()) {
            sb2.append('(');
            sb2.append(fieldDescriptor.b());
            sb2.append(')');
        } else {
            sb2.append(fieldDescriptor.c());
        }
        if (i10 != -1) {
            sb2.append('[');
            sb2.append(i10);
            sb2.append(']');
        }
        sb2.append('.');
        return sb2.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void k(d0 d0Var, Map<Descriptors.FieldDescriptor, Object> map, CodedOutputStream codedOutputStream, boolean z10) throws IOException {
        boolean messageSetWireFormat = d0Var.getDescriptorForType().q().getMessageSetWireFormat();
        if (z10) {
            TreeMap treeMap = new TreeMap(map);
            for (Descriptors.FieldDescriptor fieldDescriptor : d0Var.getDescriptorForType().l()) {
                if (fieldDescriptor.C() && !treeMap.containsKey(fieldDescriptor)) {
                    treeMap.put(fieldDescriptor, d0Var.getField(fieldDescriptor));
                }
            }
            map = treeMap;
        }
        for (Map.Entry<Descriptors.FieldDescriptor, Object> entry : map.entrySet()) {
            Descriptors.FieldDescriptor key = entry.getKey();
            Object value = entry.getValue();
            if (!messageSetWireFormat || !key.y() || key.x() != Descriptors.FieldDescriptor.Type.MESSAGE || key.o()) {
                t.H(key, value, codedOutputStream);
            } else {
                codedOutputStream.C0(key.getNumber(), (d0) value);
            }
        }
        a1 unknownFields = d0Var.getUnknownFields();
        if (messageSetWireFormat) {
            unknownFields.k(codedOutputStream);
        } else {
            unknownFields.writeTo(codedOutputStream);
        }
    }
}
