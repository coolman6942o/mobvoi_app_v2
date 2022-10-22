package com.google.protobuf;

import com.google.protobuf.WireFormat;
import com.google.protobuf.e0;
import java.io.IOException;
import java.util.AbstractMap;
import java.util.Map;
/* compiled from: MapEntryLite.java */
/* loaded from: classes.dex */
public class b0<K, V> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MapEntryLite.java */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f13169a;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            f13169a = iArr;
            try {
                iArr[WireFormat.FieldType.MESSAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f13169a[WireFormat.FieldType.ENUM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f13169a[WireFormat.FieldType.GROUP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* compiled from: MapEntryLite.java */
    /* loaded from: classes.dex */
    static class b<K, V> {

        /* renamed from: a  reason: collision with root package name */
        public final WireFormat.FieldType f13170a;

        /* renamed from: b  reason: collision with root package name */
        public final K f13171b;

        /* renamed from: c  reason: collision with root package name */
        public final WireFormat.FieldType f13172c;

        /* renamed from: d  reason: collision with root package name */
        public final V f13173d;

        public b(WireFormat.FieldType fieldType, K k10, WireFormat.FieldType fieldType2, V v10) {
            this.f13170a = fieldType;
            this.f13171b = k10;
            this.f13172c = fieldType2;
            this.f13173d = v10;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> int a(b<K, V> bVar, K k10, V v10) {
        return t.g(bVar.f13170a, 1, k10) + t.g(bVar.f13172c, 2, v10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> Map.Entry<K, V> b(i iVar, b<K, V> bVar, q qVar) throws IOException {
        Object obj = bVar.f13171b;
        Object obj2 = bVar.f13173d;
        while (true) {
            int F = iVar.F();
            if (F == 0) {
                break;
            } else if (F == WireFormat.c(1, bVar.f13170a.getWireType())) {
                obj = c(iVar, qVar, bVar.f13170a, obj);
            } else if (F == WireFormat.c(2, bVar.f13172c.getWireType())) {
                obj2 = c(iVar, qVar, bVar.f13172c, obj2);
            } else if (!iVar.I(F)) {
                break;
            }
        }
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    static <T> T c(i iVar, q qVar, WireFormat.FieldType fieldType, T t10) throws IOException {
        int i10 = a.f13169a[fieldType.ordinal()];
        if (i10 == 1) {
            e0.a builder = ((e0) t10).toBuilder();
            iVar.w(builder, qVar);
            return (T) builder.buildPartial();
        } else if (i10 == 2) {
            return (T) Integer.valueOf(iVar.o());
        } else {
            if (i10 != 3) {
                return (T) t.B(iVar, fieldType, true);
            }
            throw new RuntimeException("Groups are not allowed in maps.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> void d(CodedOutputStream codedOutputStream, b<K, V> bVar, K k10, V v10) throws IOException {
        t.F(codedOutputStream, bVar.f13170a, 1, k10);
        t.F(codedOutputStream, bVar.f13172c, 2, v10);
    }
}
