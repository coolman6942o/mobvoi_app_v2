package com.google.protobuf;

import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.MessageReflection;
import com.google.protobuf.WireFormat;
import com.google.protobuf.a;
import com.google.protobuf.a1;
import com.google.protobuf.d0;
import com.google.protobuf.e0;
import com.google.protobuf.u;
import com.google.protobuf.v;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes.dex */
public abstract class GeneratedMessageV3 extends com.google.protobuf.a implements Serializable {
    protected static boolean alwaysUseFieldBuilders = false;
    private static final long serialVersionUID = 1;
    protected a1 unknownFields;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a.b f13029a;

        a(GeneratedMessageV3 generatedMessageV3, a.b bVar) {
            this.f13029a = bVar;
        }

        @Override // com.google.protobuf.a.b
        public void a() {
            this.f13029a.a();
        }
    }

    /* loaded from: classes.dex */
    public static abstract class b<BuilderType extends b<BuilderType>> extends a.AbstractC0170a<BuilderType> {
        private c builderParent;
        private boolean isClean;
        private b<BuilderType>.a meAsParent;
        private a1 unknownFields;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public class a implements c {
            private a() {
            }

            @Override // com.google.protobuf.a.b
            public void a() {
                b.this.onChanged();
            }

            /* synthetic */ a(b bVar, a aVar) {
                this();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public b() {
            this(null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Map<Descriptors.FieldDescriptor, Object> getAllFieldsMutable() {
            TreeMap treeMap = new TreeMap();
            List<Descriptors.FieldDescriptor> l10 = internalGetFieldAccessorTable().f13032a.l();
            int i10 = 0;
            while (i10 < l10.size()) {
                Descriptors.FieldDescriptor fieldDescriptor = l10.get(i10);
                Descriptors.h j10 = fieldDescriptor.j();
                if (j10 != null) {
                    i10 += j10.g() - 1;
                    if (!hasOneof(j10)) {
                        i10++;
                    } else {
                        fieldDescriptor = getOneofFieldDescriptor(j10);
                        treeMap.put(fieldDescriptor, getField(fieldDescriptor));
                        i10++;
                    }
                } else {
                    if (fieldDescriptor.o()) {
                        List list = (List) getField(fieldDescriptor);
                        if (!list.isEmpty()) {
                            treeMap.put(fieldDescriptor, list);
                        }
                    } else {
                        if (!hasField(fieldDescriptor)) {
                        }
                        treeMap.put(fieldDescriptor, getField(fieldDescriptor));
                    }
                    i10++;
                }
            }
            return treeMap;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.protobuf.a.AbstractC0170a
        public void dispose() {
            this.builderParent = null;
        }

        @Override // com.google.protobuf.g0
        public Map<Descriptors.FieldDescriptor, Object> getAllFields() {
            return Collections.unmodifiableMap(getAllFieldsMutable());
        }

        public Descriptors.b getDescriptorForType() {
            return internalGetFieldAccessorTable().f13032a;
        }

        @Override // com.google.protobuf.g0
        public Object getField(Descriptors.FieldDescriptor fieldDescriptor) {
            Object n10 = internalGetFieldAccessorTable().f(fieldDescriptor).n(this);
            return fieldDescriptor.o() ? Collections.unmodifiableList((List) n10) : n10;
        }

        @Override // com.google.protobuf.a.AbstractC0170a
        public d0.a getFieldBuilder(Descriptors.FieldDescriptor fieldDescriptor) {
            return internalGetFieldAccessorTable().f(fieldDescriptor).m(this);
        }

        @Override // com.google.protobuf.a.AbstractC0170a
        public Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.h hVar) {
            return internalGetFieldAccessorTable().g(hVar).b(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public c getParentForChildren() {
            if (this.meAsParent == null) {
                this.meAsParent = new a(this, null);
            }
            return this.meAsParent;
        }

        public Object getRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i10) {
            return internalGetFieldAccessorTable().f(fieldDescriptor).l(this, i10);
        }

        @Override // com.google.protobuf.a.AbstractC0170a
        public d0.a getRepeatedFieldBuilder(Descriptors.FieldDescriptor fieldDescriptor, int i10) {
            return internalGetFieldAccessorTable().f(fieldDescriptor).c(this, i10);
        }

        public int getRepeatedFieldCount(Descriptors.FieldDescriptor fieldDescriptor) {
            return internalGetFieldAccessorTable().f(fieldDescriptor).e(this);
        }

        @Override // com.google.protobuf.g0
        public final a1 getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.google.protobuf.g0
        public boolean hasField(Descriptors.FieldDescriptor fieldDescriptor) {
            return internalGetFieldAccessorTable().f(fieldDescriptor).p(this);
        }

        @Override // com.google.protobuf.a.AbstractC0170a
        public boolean hasOneof(Descriptors.h hVar) {
            return internalGetFieldAccessorTable().g(hVar).d(this);
        }

        protected abstract e internalGetFieldAccessorTable();

        protected c0 internalGetMapField(int i10) {
            throw new RuntimeException("No map fields found in " + getClass().getName());
        }

        protected c0 internalGetMutableMapField(int i10) {
            throw new RuntimeException("No map fields found in " + getClass().getName());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public boolean isClean() {
            return this.isClean;
        }

        @Override // com.google.protobuf.f0
        public boolean isInitialized() {
            for (Descriptors.FieldDescriptor fieldDescriptor : getDescriptorForType().l()) {
                if (fieldDescriptor.C() && !hasField(fieldDescriptor)) {
                    return false;
                }
                if (fieldDescriptor.u() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                    if (fieldDescriptor.o()) {
                        for (d0 d0Var : (List) getField(fieldDescriptor)) {
                            if (!d0Var.isInitialized()) {
                                return false;
                            }
                        }
                        continue;
                    } else if (hasField(fieldDescriptor) && !((d0) getField(fieldDescriptor)).isInitialized()) {
                        return false;
                    }
                }
            }
            return true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.a.AbstractC0170a
        public void markClean() {
            this.isClean = true;
        }

        @Override // com.google.protobuf.d0.a
        public d0.a newBuilderForField(Descriptors.FieldDescriptor fieldDescriptor) {
            return internalGetFieldAccessorTable().f(fieldDescriptor).b();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void onBuilt() {
            if (this.builderParent != null) {
                markClean();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final void onChanged() {
            c cVar;
            if (this.isClean && (cVar = this.builderParent) != null) {
                cVar.a();
                this.isClean = false;
            }
        }

        protected boolean parseUnknownField(i iVar, a1.b bVar, q qVar, int i10) throws IOException {
            return bVar.l(i10, iVar);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public b(c cVar) {
            this.unknownFields = a1.c();
            this.builderParent = cVar;
        }

        public BuilderType addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            internalGetFieldAccessorTable().f(fieldDescriptor).a(this, obj);
            return this;
        }

        public BuilderType clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            internalGetFieldAccessorTable().f(fieldDescriptor).f(this);
            return this;
        }

        public BuilderType setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            internalGetFieldAccessorTable().f(fieldDescriptor).j(this, obj);
            return this;
        }

        public BuilderType setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i10, Object obj) {
            internalGetFieldAccessorTable().f(fieldDescriptor).k(this, i10, obj);
            return this;
        }

        public BuilderType setUnknownFields(a1 a1Var) {
            this.unknownFields = a1Var;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.a.AbstractC0170a
        public BuilderType clearOneof(Descriptors.h hVar) {
            internalGetFieldAccessorTable().g(hVar).a(this);
            return this;
        }

        @Override // com.google.protobuf.a.AbstractC0170a
        public BuilderType mergeUnknownFields(a1 a1Var) {
            this.unknownFields = a1.h(this.unknownFields).o(a1Var).build();
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.a.AbstractC0170a
        public BuilderType clear() {
            this.unknownFields = a1.c();
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.a.AbstractC0170a, com.google.protobuf.b.a
        public BuilderType clone() {
            BuilderType buildertype = (BuilderType) getDefaultInstanceForType().newBuilderForType();
            buildertype.mergeFrom(buildPartial());
            return buildertype;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public interface c extends a.b {
    }

    /* loaded from: classes.dex */
    public static final class e {

        /* renamed from: a  reason: collision with root package name */
        private final Descriptors.b f13032a;

        /* renamed from: b  reason: collision with root package name */
        private final a[] f13033b;

        /* renamed from: c  reason: collision with root package name */
        private String[] f13034c;

        /* renamed from: d  reason: collision with root package name */
        private final c[] f13035d;

        /* renamed from: e  reason: collision with root package name */
        private volatile boolean f13036e = false;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public interface a {
            void a(b bVar, Object obj);

            d0.a b();

            d0.a c(b bVar, int i10);

            Object d(GeneratedMessageV3 generatedMessageV3);

            int e(b bVar);

            void f(b bVar);

            int g(GeneratedMessageV3 generatedMessageV3);

            Object h(GeneratedMessageV3 generatedMessageV3);

            boolean i(GeneratedMessageV3 generatedMessageV3);

            void j(b bVar, Object obj);

            void k(b bVar, int i10, Object obj);

            Object l(b bVar, int i10);

            d0.a m(b bVar);

            Object n(b bVar);

            Object o(GeneratedMessageV3 generatedMessageV3, int i10);

            boolean p(b bVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static class b implements a {

            /* renamed from: a  reason: collision with root package name */
            private final Descriptors.FieldDescriptor f13037a;

            /* renamed from: b  reason: collision with root package name */
            private final d0 f13038b;

            b(Descriptors.FieldDescriptor fieldDescriptor, String str, Class<? extends GeneratedMessageV3> cls, Class<? extends b> cls2) {
                this.f13037a = fieldDescriptor;
                this.f13038b = s((GeneratedMessageV3) GeneratedMessageV3.invokeOrDie(GeneratedMessageV3.getMethodOrDie(cls, "getDefaultInstance", new Class[0]), null, new Object[0])).k();
            }

            private d0 q(d0 d0Var) {
                if (d0Var == null) {
                    return null;
                }
                return this.f13038b.getClass().isInstance(d0Var) ? d0Var : this.f13038b.toBuilder().mergeFrom(d0Var).build();
            }

            private c0<?, ?> r(b bVar) {
                return bVar.internalGetMapField(this.f13037a.getNumber());
            }

            private c0<?, ?> s(GeneratedMessageV3 generatedMessageV3) {
                return generatedMessageV3.internalGetMapField(this.f13037a.getNumber());
            }

            private c0<?, ?> t(b bVar) {
                return bVar.internalGetMutableMapField(this.f13037a.getNumber());
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.a
            public void a(b bVar, Object obj) {
                t(bVar).l().add(q((d0) obj));
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.a
            public d0.a b() {
                return this.f13038b.newBuilderForType();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.a
            public d0.a c(b bVar, int i10) {
                throw new UnsupportedOperationException("Nested builder not supported for map fields.");
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.a
            public Object d(GeneratedMessageV3 generatedMessageV3) {
                return h(generatedMessageV3);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.a
            public int e(b bVar) {
                return r(bVar).i().size();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.a
            public void f(b bVar) {
                t(bVar).l().clear();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.a
            public int g(GeneratedMessageV3 generatedMessageV3) {
                return s(generatedMessageV3).i().size();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.a
            public Object h(GeneratedMessageV3 generatedMessageV3) {
                ArrayList arrayList = new ArrayList();
                for (int i10 = 0; i10 < g(generatedMessageV3); i10++) {
                    arrayList.add(o(generatedMessageV3, i10));
                }
                return Collections.unmodifiableList(arrayList);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.a
            public boolean i(GeneratedMessageV3 generatedMessageV3) {
                throw new UnsupportedOperationException("hasField() is not supported for repeated fields.");
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.a
            public void j(b bVar, Object obj) {
                f(bVar);
                for (Object obj2 : (List) obj) {
                    a(bVar, obj2);
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.a
            public void k(b bVar, int i10, Object obj) {
                t(bVar).l().set(i10, q((d0) obj));
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.a
            public Object l(b bVar, int i10) {
                return r(bVar).i().get(i10);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.a
            public d0.a m(b bVar) {
                throw new UnsupportedOperationException("Nested builder not supported for map fields.");
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.a
            public Object n(b bVar) {
                ArrayList arrayList = new ArrayList();
                for (int i10 = 0; i10 < e(bVar); i10++) {
                    arrayList.add(l(bVar, i10));
                }
                return Collections.unmodifiableList(arrayList);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.a
            public Object o(GeneratedMessageV3 generatedMessageV3, int i10) {
                return s(generatedMessageV3).i().get(i10);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.a
            public boolean p(b bVar) {
                throw new UnsupportedOperationException("hasField() is not supported for repeated fields.");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static class c {

            /* renamed from: a  reason: collision with root package name */
            private final Descriptors.b f13039a;

            /* renamed from: b  reason: collision with root package name */
            private final Method f13040b;

            /* renamed from: c  reason: collision with root package name */
            private final Method f13041c;

            /* renamed from: d  reason: collision with root package name */
            private final Method f13042d;

            c(Descriptors.b bVar, String str, Class<? extends GeneratedMessageV3> cls, Class<? extends b> cls2) {
                this.f13039a = bVar;
                this.f13040b = GeneratedMessageV3.getMethodOrDie(cls, "get" + str + "Case", new Class[0]);
                this.f13041c = GeneratedMessageV3.getMethodOrDie(cls2, "get" + str + "Case", new Class[0]);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("clear");
                sb2.append(str);
                this.f13042d = GeneratedMessageV3.getMethodOrDie(cls2, sb2.toString(), new Class[0]);
            }

            public void a(b bVar) {
                GeneratedMessageV3.invokeOrDie(this.f13042d, bVar, new Object[0]);
            }

            public Descriptors.FieldDescriptor b(b bVar) {
                int number = ((u.a) GeneratedMessageV3.invokeOrDie(this.f13041c, bVar, new Object[0])).getNumber();
                if (number > 0) {
                    return this.f13039a.i(number);
                }
                return null;
            }

            public Descriptors.FieldDescriptor c(GeneratedMessageV3 generatedMessageV3) {
                int number = ((u.a) GeneratedMessageV3.invokeOrDie(this.f13040b, generatedMessageV3, new Object[0])).getNumber();
                if (number > 0) {
                    return this.f13039a.i(number);
                }
                return null;
            }

            public boolean d(b bVar) {
                return ((u.a) GeneratedMessageV3.invokeOrDie(this.f13041c, bVar, new Object[0])).getNumber() != 0;
            }

            public boolean e(GeneratedMessageV3 generatedMessageV3) {
                return ((u.a) GeneratedMessageV3.invokeOrDie(this.f13040b, generatedMessageV3, new Object[0])).getNumber() != 0;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class d extends C0168e {

            /* renamed from: k  reason: collision with root package name */
            private Descriptors.d f13043k;

            /* renamed from: l  reason: collision with root package name */
            private final Method f13044l = GeneratedMessageV3.getMethodOrDie(this.f13051a, "valueOf", Descriptors.e.class);

            /* renamed from: m  reason: collision with root package name */
            private final Method f13045m = GeneratedMessageV3.getMethodOrDie(this.f13051a, "getValueDescriptor", new Class[0]);

            /* renamed from: n  reason: collision with root package name */
            private boolean f13046n;

            /* renamed from: o  reason: collision with root package name */
            private Method f13047o;

            /* renamed from: p  reason: collision with root package name */
            private Method f13048p;

            /* renamed from: q  reason: collision with root package name */
            private Method f13049q;

            /* renamed from: r  reason: collision with root package name */
            private Method f13050r;

            d(Descriptors.FieldDescriptor fieldDescriptor, String str, Class<? extends GeneratedMessageV3> cls, Class<? extends b> cls2) {
                super(fieldDescriptor, str, cls, cls2);
                this.f13043k = fieldDescriptor.m();
                boolean v10 = fieldDescriptor.a().v();
                this.f13046n = v10;
                if (v10) {
                    Class cls3 = Integer.TYPE;
                    this.f13047o = GeneratedMessageV3.getMethodOrDie(cls, "get" + str + "Value", cls3);
                    this.f13048p = GeneratedMessageV3.getMethodOrDie(cls2, "get" + str + "Value", cls3);
                    this.f13049q = GeneratedMessageV3.getMethodOrDie(cls2, "set" + str + "Value", cls3, cls3);
                    this.f13050r = GeneratedMessageV3.getMethodOrDie(cls2, "add" + str + "Value", cls3);
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.C0168e, com.google.protobuf.GeneratedMessageV3.e.a
            public void a(b bVar, Object obj) {
                if (this.f13046n) {
                    GeneratedMessageV3.invokeOrDie(this.f13050r, bVar, Integer.valueOf(((Descriptors.e) obj).getNumber()));
                } else {
                    super.a(bVar, GeneratedMessageV3.invokeOrDie(this.f13044l, null, obj));
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.C0168e, com.google.protobuf.GeneratedMessageV3.e.a
            public Object h(GeneratedMessageV3 generatedMessageV3) {
                ArrayList arrayList = new ArrayList();
                int g10 = g(generatedMessageV3);
                for (int i10 = 0; i10 < g10; i10++) {
                    arrayList.add(o(generatedMessageV3, i10));
                }
                return Collections.unmodifiableList(arrayList);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.C0168e, com.google.protobuf.GeneratedMessageV3.e.a
            public void k(b bVar, int i10, Object obj) {
                if (this.f13046n) {
                    GeneratedMessageV3.invokeOrDie(this.f13049q, bVar, Integer.valueOf(i10), Integer.valueOf(((Descriptors.e) obj).getNumber()));
                } else {
                    super.k(bVar, i10, GeneratedMessageV3.invokeOrDie(this.f13044l, null, obj));
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.C0168e, com.google.protobuf.GeneratedMessageV3.e.a
            public Object l(b bVar, int i10) {
                if (this.f13046n) {
                    return this.f13043k.h(((Integer) GeneratedMessageV3.invokeOrDie(this.f13048p, bVar, Integer.valueOf(i10))).intValue());
                }
                return GeneratedMessageV3.invokeOrDie(this.f13045m, super.l(bVar, i10), new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.C0168e, com.google.protobuf.GeneratedMessageV3.e.a
            public Object n(b bVar) {
                ArrayList arrayList = new ArrayList();
                int e10 = e(bVar);
                for (int i10 = 0; i10 < e10; i10++) {
                    arrayList.add(l(bVar, i10));
                }
                return Collections.unmodifiableList(arrayList);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.C0168e, com.google.protobuf.GeneratedMessageV3.e.a
            public Object o(GeneratedMessageV3 generatedMessageV3, int i10) {
                if (this.f13046n) {
                    return this.f13043k.h(((Integer) GeneratedMessageV3.invokeOrDie(this.f13047o, generatedMessageV3, Integer.valueOf(i10))).intValue());
                }
                return GeneratedMessageV3.invokeOrDie(this.f13045m, super.o(generatedMessageV3, i10), new Object[0]);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.google.protobuf.GeneratedMessageV3$e$e  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0168e implements a {

            /* renamed from: a  reason: collision with root package name */
            protected final Class f13051a;

            /* renamed from: b  reason: collision with root package name */
            protected final Method f13052b;

            /* renamed from: c  reason: collision with root package name */
            protected final Method f13053c;

            /* renamed from: d  reason: collision with root package name */
            protected final Method f13054d;

            /* renamed from: e  reason: collision with root package name */
            protected final Method f13055e;

            /* renamed from: f  reason: collision with root package name */
            protected final Method f13056f;

            /* renamed from: g  reason: collision with root package name */
            protected final Method f13057g;

            /* renamed from: h  reason: collision with root package name */
            protected final Method f13058h;

            /* renamed from: i  reason: collision with root package name */
            protected final Method f13059i;

            /* renamed from: j  reason: collision with root package name */
            protected final Method f13060j;

            C0168e(Descriptors.FieldDescriptor fieldDescriptor, String str, Class<? extends GeneratedMessageV3> cls, Class<? extends b> cls2) {
                this.f13052b = GeneratedMessageV3.getMethodOrDie(cls, "get" + str + "List", new Class[0]);
                this.f13053c = GeneratedMessageV3.getMethodOrDie(cls2, "get" + str + "List", new Class[0]);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("get");
                sb2.append(str);
                String sb3 = sb2.toString();
                Class cls3 = Integer.TYPE;
                Method methodOrDie = GeneratedMessageV3.getMethodOrDie(cls, sb3, cls3);
                this.f13054d = methodOrDie;
                this.f13055e = GeneratedMessageV3.getMethodOrDie(cls2, "get" + str, cls3);
                Class<?> returnType = methodOrDie.getReturnType();
                this.f13051a = returnType;
                this.f13056f = GeneratedMessageV3.getMethodOrDie(cls2, "set" + str, cls3, returnType);
                this.f13057g = GeneratedMessageV3.getMethodOrDie(cls2, "add" + str, returnType);
                this.f13058h = GeneratedMessageV3.getMethodOrDie(cls, "get" + str + "Count", new Class[0]);
                this.f13059i = GeneratedMessageV3.getMethodOrDie(cls2, "get" + str + "Count", new Class[0]);
                StringBuilder sb4 = new StringBuilder();
                sb4.append("clear");
                sb4.append(str);
                this.f13060j = GeneratedMessageV3.getMethodOrDie(cls2, sb4.toString(), new Class[0]);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.a
            public void a(b bVar, Object obj) {
                GeneratedMessageV3.invokeOrDie(this.f13057g, bVar, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.a
            public d0.a b() {
                throw new UnsupportedOperationException("newBuilderForField() called on a non-Message type.");
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.a
            public d0.a c(b bVar, int i10) {
                throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on a non-Message type.");
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.a
            public Object d(GeneratedMessageV3 generatedMessageV3) {
                return h(generatedMessageV3);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.a
            public int e(b bVar) {
                return ((Integer) GeneratedMessageV3.invokeOrDie(this.f13059i, bVar, new Object[0])).intValue();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.a
            public void f(b bVar) {
                GeneratedMessageV3.invokeOrDie(this.f13060j, bVar, new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.a
            public int g(GeneratedMessageV3 generatedMessageV3) {
                return ((Integer) GeneratedMessageV3.invokeOrDie(this.f13058h, generatedMessageV3, new Object[0])).intValue();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.a
            public Object h(GeneratedMessageV3 generatedMessageV3) {
                return GeneratedMessageV3.invokeOrDie(this.f13052b, generatedMessageV3, new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.a
            public boolean i(GeneratedMessageV3 generatedMessageV3) {
                throw new UnsupportedOperationException("hasField() called on a repeated field.");
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.a
            public void j(b bVar, Object obj) {
                f(bVar);
                for (Object obj2 : (List) obj) {
                    a(bVar, obj2);
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.a
            public void k(b bVar, int i10, Object obj) {
                GeneratedMessageV3.invokeOrDie(this.f13056f, bVar, Integer.valueOf(i10), obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.a
            public Object l(b bVar, int i10) {
                return GeneratedMessageV3.invokeOrDie(this.f13055e, bVar, Integer.valueOf(i10));
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.a
            public d0.a m(b bVar) {
                throw new UnsupportedOperationException("getFieldBuilder() called on a non-Message type.");
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.a
            public Object n(b bVar) {
                return GeneratedMessageV3.invokeOrDie(this.f13053c, bVar, new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.a
            public Object o(GeneratedMessageV3 generatedMessageV3, int i10) {
                return GeneratedMessageV3.invokeOrDie(this.f13054d, generatedMessageV3, Integer.valueOf(i10));
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.a
            public boolean p(b bVar) {
                throw new UnsupportedOperationException("hasField() called on a repeated field.");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class f extends C0168e {

            /* renamed from: k  reason: collision with root package name */
            private final Method f13061k = GeneratedMessageV3.getMethodOrDie(this.f13051a, "newBuilder", new Class[0]);

            /* renamed from: l  reason: collision with root package name */
            private final Method f13062l;

            f(Descriptors.FieldDescriptor fieldDescriptor, String str, Class<? extends GeneratedMessageV3> cls, Class<? extends b> cls2) {
                super(fieldDescriptor, str, cls, cls2);
                this.f13062l = GeneratedMessageV3.getMethodOrDie(cls2, "get" + str + "Builder", Integer.TYPE);
            }

            private Object q(Object obj) {
                return this.f13051a.isInstance(obj) ? obj : ((d0.a) GeneratedMessageV3.invokeOrDie(this.f13061k, null, new Object[0])).mergeFrom((d0) obj).build();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.C0168e, com.google.protobuf.GeneratedMessageV3.e.a
            public void a(b bVar, Object obj) {
                super.a(bVar, q(obj));
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.C0168e, com.google.protobuf.GeneratedMessageV3.e.a
            public d0.a b() {
                return (d0.a) GeneratedMessageV3.invokeOrDie(this.f13061k, null, new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.C0168e, com.google.protobuf.GeneratedMessageV3.e.a
            public d0.a c(b bVar, int i10) {
                return (d0.a) GeneratedMessageV3.invokeOrDie(this.f13062l, bVar, Integer.valueOf(i10));
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.C0168e, com.google.protobuf.GeneratedMessageV3.e.a
            public void k(b bVar, int i10, Object obj) {
                super.k(bVar, i10, q(obj));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class g extends h {

            /* renamed from: m  reason: collision with root package name */
            private Descriptors.d f13063m;

            /* renamed from: n  reason: collision with root package name */
            private Method f13064n = GeneratedMessageV3.getMethodOrDie(this.f13070a, "valueOf", Descriptors.e.class);

            /* renamed from: o  reason: collision with root package name */
            private Method f13065o = GeneratedMessageV3.getMethodOrDie(this.f13070a, "getValueDescriptor", new Class[0]);

            /* renamed from: p  reason: collision with root package name */
            private boolean f13066p;

            /* renamed from: q  reason: collision with root package name */
            private Method f13067q;

            /* renamed from: r  reason: collision with root package name */
            private Method f13068r;

            /* renamed from: s  reason: collision with root package name */
            private Method f13069s;

            g(Descriptors.FieldDescriptor fieldDescriptor, String str, Class<? extends GeneratedMessageV3> cls, Class<? extends b> cls2, String str2) {
                super(fieldDescriptor, str, cls, cls2, str2);
                this.f13063m = fieldDescriptor.m();
                boolean v10 = fieldDescriptor.a().v();
                this.f13066p = v10;
                if (v10) {
                    this.f13067q = GeneratedMessageV3.getMethodOrDie(cls, "get" + str + "Value", new Class[0]);
                    this.f13068r = GeneratedMessageV3.getMethodOrDie(cls2, "get" + str + "Value", new Class[0]);
                    this.f13069s = GeneratedMessageV3.getMethodOrDie(cls2, "set" + str + "Value", Integer.TYPE);
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.h, com.google.protobuf.GeneratedMessageV3.e.a
            public Object h(GeneratedMessageV3 generatedMessageV3) {
                if (!this.f13066p) {
                    return GeneratedMessageV3.invokeOrDie(this.f13065o, super.h(generatedMessageV3), new Object[0]);
                }
                return this.f13063m.h(((Integer) GeneratedMessageV3.invokeOrDie(this.f13067q, generatedMessageV3, new Object[0])).intValue());
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.h, com.google.protobuf.GeneratedMessageV3.e.a
            public void j(b bVar, Object obj) {
                if (this.f13066p) {
                    GeneratedMessageV3.invokeOrDie(this.f13069s, bVar, Integer.valueOf(((Descriptors.e) obj).getNumber()));
                } else {
                    super.j(bVar, GeneratedMessageV3.invokeOrDie(this.f13064n, null, obj));
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.h, com.google.protobuf.GeneratedMessageV3.e.a
            public Object n(b bVar) {
                if (!this.f13066p) {
                    return GeneratedMessageV3.invokeOrDie(this.f13065o, super.n(bVar), new Object[0]);
                }
                return this.f13063m.h(((Integer) GeneratedMessageV3.invokeOrDie(this.f13068r, bVar, new Object[0])).intValue());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static class h implements a {

            /* renamed from: a  reason: collision with root package name */
            protected final Class<?> f13070a;

            /* renamed from: b  reason: collision with root package name */
            protected final Method f13071b;

            /* renamed from: c  reason: collision with root package name */
            protected final Method f13072c;

            /* renamed from: d  reason: collision with root package name */
            protected final Method f13073d;

            /* renamed from: e  reason: collision with root package name */
            protected final Method f13074e;

            /* renamed from: f  reason: collision with root package name */
            protected final Method f13075f;

            /* renamed from: g  reason: collision with root package name */
            protected final Method f13076g;

            /* renamed from: h  reason: collision with root package name */
            protected final Method f13077h;

            /* renamed from: i  reason: collision with root package name */
            protected final Method f13078i;

            /* renamed from: j  reason: collision with root package name */
            protected final Descriptors.FieldDescriptor f13079j;

            /* renamed from: k  reason: collision with root package name */
            protected final boolean f13080k;

            /* renamed from: l  reason: collision with root package name */
            protected final boolean f13081l;

            h(Descriptors.FieldDescriptor fieldDescriptor, String str, Class<? extends GeneratedMessageV3> cls, Class<? extends b> cls2, String str2) {
                Method method;
                Method method2;
                Method method3;
                this.f13079j = fieldDescriptor;
                boolean z10 = fieldDescriptor.j() != null;
                this.f13080k = z10;
                boolean z11 = e.i(fieldDescriptor.a()) || (!z10 && fieldDescriptor.u() == Descriptors.FieldDescriptor.JavaType.MESSAGE);
                this.f13081l = z11;
                Method methodOrDie = GeneratedMessageV3.getMethodOrDie(cls, "get" + str, new Class[0]);
                this.f13071b = methodOrDie;
                this.f13072c = GeneratedMessageV3.getMethodOrDie(cls2, "get" + str, new Class[0]);
                Class<?> returnType = methodOrDie.getReturnType();
                this.f13070a = returnType;
                this.f13073d = GeneratedMessageV3.getMethodOrDie(cls2, "set" + str, returnType);
                Method method4 = null;
                if (z11) {
                    method = GeneratedMessageV3.getMethodOrDie(cls, "has" + str, new Class[0]);
                } else {
                    method = null;
                }
                this.f13074e = method;
                if (z11) {
                    method2 = GeneratedMessageV3.getMethodOrDie(cls2, "has" + str, new Class[0]);
                } else {
                    method2 = null;
                }
                this.f13075f = method2;
                this.f13076g = GeneratedMessageV3.getMethodOrDie(cls2, "clear" + str, new Class[0]);
                if (z10) {
                    method3 = GeneratedMessageV3.getMethodOrDie(cls, "get" + str2 + "Case", new Class[0]);
                } else {
                    method3 = null;
                }
                this.f13077h = method3;
                if (z10) {
                    method4 = GeneratedMessageV3.getMethodOrDie(cls2, "get" + str2 + "Case", new Class[0]);
                }
                this.f13078i = method4;
            }

            private int q(b bVar) {
                return ((u.a) GeneratedMessageV3.invokeOrDie(this.f13078i, bVar, new Object[0])).getNumber();
            }

            private int r(GeneratedMessageV3 generatedMessageV3) {
                return ((u.a) GeneratedMessageV3.invokeOrDie(this.f13077h, generatedMessageV3, new Object[0])).getNumber();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.a
            public void a(b bVar, Object obj) {
                throw new UnsupportedOperationException("addRepeatedField() called on a singular field.");
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.a
            public d0.a b() {
                throw new UnsupportedOperationException("newBuilderForField() called on a non-Message type.");
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.a
            public d0.a c(b bVar, int i10) {
                throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on a non-Message type.");
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.a
            public Object d(GeneratedMessageV3 generatedMessageV3) {
                return h(generatedMessageV3);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.a
            public int e(b bVar) {
                throw new UnsupportedOperationException("getRepeatedFieldSize() called on a singular field.");
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.a
            public void f(b bVar) {
                GeneratedMessageV3.invokeOrDie(this.f13076g, bVar, new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.a
            public int g(GeneratedMessageV3 generatedMessageV3) {
                throw new UnsupportedOperationException("getRepeatedFieldSize() called on a singular field.");
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.a
            public Object h(GeneratedMessageV3 generatedMessageV3) {
                return GeneratedMessageV3.invokeOrDie(this.f13071b, generatedMessageV3, new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.a
            public boolean i(GeneratedMessageV3 generatedMessageV3) {
                if (this.f13081l) {
                    return ((Boolean) GeneratedMessageV3.invokeOrDie(this.f13074e, generatedMessageV3, new Object[0])).booleanValue();
                }
                if (this.f13080k) {
                    return r(generatedMessageV3) == this.f13079j.getNumber();
                }
                return !h(generatedMessageV3).equals(this.f13079j.l());
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.a
            public void j(b bVar, Object obj) {
                GeneratedMessageV3.invokeOrDie(this.f13073d, bVar, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.a
            public void k(b bVar, int i10, Object obj) {
                throw new UnsupportedOperationException("setRepeatedField() called on a singular field.");
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.a
            public Object l(b bVar, int i10) {
                throw new UnsupportedOperationException("getRepeatedField() called on a singular field.");
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.a
            public d0.a m(b bVar) {
                throw new UnsupportedOperationException("getFieldBuilder() called on a non-Message type.");
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.a
            public Object n(b bVar) {
                return GeneratedMessageV3.invokeOrDie(this.f13072c, bVar, new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.a
            public Object o(GeneratedMessageV3 generatedMessageV3, int i10) {
                throw new UnsupportedOperationException("getRepeatedField() called on a singular field.");
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.a
            public boolean p(b bVar) {
                if (this.f13081l) {
                    return ((Boolean) GeneratedMessageV3.invokeOrDie(this.f13075f, bVar, new Object[0])).booleanValue();
                }
                if (this.f13080k) {
                    return q(bVar) == this.f13079j.getNumber();
                }
                return !n(bVar).equals(this.f13079j.l());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class i extends h {

            /* renamed from: m  reason: collision with root package name */
            private final Method f13082m = GeneratedMessageV3.getMethodOrDie(this.f13070a, "newBuilder", new Class[0]);

            /* renamed from: n  reason: collision with root package name */
            private final Method f13083n;

            i(Descriptors.FieldDescriptor fieldDescriptor, String str, Class<? extends GeneratedMessageV3> cls, Class<? extends b> cls2, String str2) {
                super(fieldDescriptor, str, cls, cls2, str2);
                this.f13083n = GeneratedMessageV3.getMethodOrDie(cls2, "get" + str + "Builder", new Class[0]);
            }

            private Object s(Object obj) {
                return this.f13070a.isInstance(obj) ? obj : ((d0.a) GeneratedMessageV3.invokeOrDie(this.f13082m, null, new Object[0])).mergeFrom((d0) obj).buildPartial();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.h, com.google.protobuf.GeneratedMessageV3.e.a
            public d0.a b() {
                return (d0.a) GeneratedMessageV3.invokeOrDie(this.f13082m, null, new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.h, com.google.protobuf.GeneratedMessageV3.e.a
            public void j(b bVar, Object obj) {
                super.j(bVar, s(obj));
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.h, com.google.protobuf.GeneratedMessageV3.e.a
            public d0.a m(b bVar) {
                return (d0.a) GeneratedMessageV3.invokeOrDie(this.f13083n, bVar, new Object[0]);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class j extends h {

            /* renamed from: m  reason: collision with root package name */
            private final Method f13084m;

            /* renamed from: n  reason: collision with root package name */
            private final Method f13085n;

            j(Descriptors.FieldDescriptor fieldDescriptor, String str, Class<? extends GeneratedMessageV3> cls, Class<? extends b> cls2, String str2) {
                super(fieldDescriptor, str, cls, cls2, str2);
                this.f13084m = GeneratedMessageV3.getMethodOrDie(cls, "get" + str + "Bytes", new Class[0]);
                GeneratedMessageV3.getMethodOrDie(cls2, "get" + str + "Bytes", new Class[0]);
                this.f13085n = GeneratedMessageV3.getMethodOrDie(cls2, "set" + str + "Bytes", ByteString.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.h, com.google.protobuf.GeneratedMessageV3.e.a
            public Object d(GeneratedMessageV3 generatedMessageV3) {
                return GeneratedMessageV3.invokeOrDie(this.f13084m, generatedMessageV3, new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.e.h, com.google.protobuf.GeneratedMessageV3.e.a
            public void j(b bVar, Object obj) {
                if (obj instanceof ByteString) {
                    GeneratedMessageV3.invokeOrDie(this.f13085n, bVar, obj);
                } else {
                    super.j(bVar, obj);
                }
            }
        }

        public e(Descriptors.b bVar, String[] strArr) {
            this.f13032a = bVar;
            this.f13034c = strArr;
            this.f13033b = new a[bVar.l().size()];
            this.f13035d = new c[bVar.n().size()];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a f(Descriptors.FieldDescriptor fieldDescriptor) {
            if (fieldDescriptor.k() != this.f13032a) {
                throw new IllegalArgumentException("FieldDescriptor does not match message type.");
            } else if (!fieldDescriptor.y()) {
                return this.f13033b[fieldDescriptor.q()];
            } else {
                throw new IllegalArgumentException("This type does not have extensions.");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public c g(Descriptors.h hVar) {
            if (hVar.f() == this.f13032a) {
                return this.f13035d[hVar.h()];
            }
            throw new IllegalArgumentException("OneofDescriptor does not match message type.");
        }

        private boolean h(Descriptors.FieldDescriptor fieldDescriptor) {
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean i(Descriptors.FileDescriptor fileDescriptor) {
            return fileDescriptor.n() == Descriptors.FileDescriptor.Syntax.PROTO2;
        }

        public e e(Class<? extends GeneratedMessageV3> cls, Class<? extends b> cls2) {
            if (this.f13036e) {
                return this;
            }
            synchronized (this) {
                if (this.f13036e) {
                    return this;
                }
                int length = this.f13033b.length;
                int i10 = 0;
                while (true) {
                    String str = null;
                    if (i10 >= length) {
                        break;
                    }
                    Descriptors.FieldDescriptor fieldDescriptor = this.f13032a.l().get(i10);
                    if (fieldDescriptor.j() != null) {
                        str = this.f13034c[fieldDescriptor.j().h() + length];
                    }
                    String str2 = str;
                    if (fieldDescriptor.o()) {
                        if (fieldDescriptor.u() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                            if (!fieldDescriptor.z() || !h(fieldDescriptor)) {
                                this.f13033b[i10] = new f(fieldDescriptor, this.f13034c[i10], cls, cls2);
                            } else {
                                this.f13033b[i10] = new b(fieldDescriptor, this.f13034c[i10], cls, cls2);
                            }
                        } else if (fieldDescriptor.u() == Descriptors.FieldDescriptor.JavaType.ENUM) {
                            this.f13033b[i10] = new d(fieldDescriptor, this.f13034c[i10], cls, cls2);
                        } else {
                            this.f13033b[i10] = new C0168e(fieldDescriptor, this.f13034c[i10], cls, cls2);
                        }
                    } else if (fieldDescriptor.u() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                        this.f13033b[i10] = new i(fieldDescriptor, this.f13034c[i10], cls, cls2, str2);
                    } else if (fieldDescriptor.u() == Descriptors.FieldDescriptor.JavaType.ENUM) {
                        this.f13033b[i10] = new g(fieldDescriptor, this.f13034c[i10], cls, cls2, str2);
                    } else if (fieldDescriptor.u() == Descriptors.FieldDescriptor.JavaType.STRING) {
                        this.f13033b[i10] = new j(fieldDescriptor, this.f13034c[i10], cls, cls2, str2);
                    } else {
                        this.f13033b[i10] = new h(fieldDescriptor, this.f13034c[i10], cls, cls2, str2);
                    }
                    i10++;
                }
                int length2 = this.f13035d.length;
                for (int i11 = 0; i11 < length2; i11++) {
                    this.f13035d[i11] = new c(this.f13032a, this.f13034c[i11 + length], cls, cls2);
                }
                this.f13036e = true;
                this.f13034c = null;
                return this;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public GeneratedMessageV3() {
        this.unknownFields = a1.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <MessageType extends ExtendableMessage<MessageType>, T> Extension<MessageType, T> checkNotLite(n<MessageType, T> nVar) {
        if (!nVar.b()) {
            return (Extension) nVar;
        }
        throw new IllegalArgumentException("Expected non-lite extension.");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int computeStringSize(int i10, Object obj) {
        if (obj instanceof String) {
            return CodedOutputStream.N(i10, (String) obj);
        }
        return CodedOutputStream.h(i10, (ByteString) obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int computeStringSizeNoTag(Object obj) {
        if (obj instanceof String) {
            return CodedOutputStream.O((String) obj);
        }
        return CodedOutputStream.i((ByteString) obj);
    }

    static void enableAlwaysUseFieldBuildersForTesting() {
        alwaysUseFieldBuilders = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<Descriptors.FieldDescriptor, Object> getAllFieldsMutable(boolean z10) {
        TreeMap treeMap = new TreeMap();
        List<Descriptors.FieldDescriptor> l10 = internalGetFieldAccessorTable().f13032a.l();
        int i10 = 0;
        while (i10 < l10.size()) {
            Descriptors.FieldDescriptor fieldDescriptor = l10.get(i10);
            Descriptors.h j10 = fieldDescriptor.j();
            if (j10 != null) {
                i10 += j10.g() - 1;
                if (!hasOneof(j10)) {
                    i10++;
                } else {
                    fieldDescriptor = getOneofFieldDescriptor(j10);
                    if (z10 || fieldDescriptor.u() != Descriptors.FieldDescriptor.JavaType.STRING) {
                        treeMap.put(fieldDescriptor, getField(fieldDescriptor));
                    } else {
                        treeMap.put(fieldDescriptor, getFieldRaw(fieldDescriptor));
                    }
                    i10++;
                }
            } else {
                if (fieldDescriptor.o()) {
                    List list = (List) getField(fieldDescriptor);
                    if (!list.isEmpty()) {
                        treeMap.put(fieldDescriptor, list);
                    }
                } else {
                    if (!hasField(fieldDescriptor)) {
                    }
                    if (z10) {
                    }
                    treeMap.put(fieldDescriptor, getField(fieldDescriptor));
                }
                i10++;
            }
        }
        return treeMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Method getMethodOrDie(Class cls, String str, Class... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException e10) {
            throw new RuntimeException("Generated message class \"" + cls.getName() + "\" missing method \"" + str + "\".", e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object invokeOrDie(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e10) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e10);
        } catch (InvocationTargetException e11) {
            Throwable cause = e11.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
        }
    }

    private static <V> void maybeSerializeBooleanEntryTo(CodedOutputStream codedOutputStream, Map<Boolean, V> map, a0<Boolean, V> a0Var, int i10, boolean z10) throws IOException {
        if (map.containsKey(Boolean.valueOf(z10))) {
            codedOutputStream.A0(i10, a0Var.newBuilderForType().n(Boolean.valueOf(z10)).p(map.get(Boolean.valueOf(z10))).build());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <M extends d0> M parseDelimitedWithIOException(l0<M> l0Var, InputStream inputStream) throws IOException {
        try {
            return l0Var.parseDelimitedFrom(inputStream);
        } catch (InvalidProtocolBufferException e10) {
            throw e10.unwrapIOException();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <M extends d0> M parseWithIOException(l0<M> l0Var, InputStream inputStream) throws IOException {
        try {
            return l0Var.parseFrom(inputStream);
        } catch (InvalidProtocolBufferException e10) {
            throw e10.unwrapIOException();
        }
    }

    protected static <V> void serializeBooleanMapTo(CodedOutputStream codedOutputStream, c0<Boolean, V> c0Var, a0<Boolean, V> a0Var, int i10) throws IOException {
        Map<Boolean, V> j10 = c0Var.j();
        if (!codedOutputStream.Y()) {
            serializeMapTo(codedOutputStream, j10, a0Var, i10);
            return;
        }
        maybeSerializeBooleanEntryTo(codedOutputStream, j10, a0Var, i10, false);
        maybeSerializeBooleanEntryTo(codedOutputStream, j10, a0Var, i10, true);
    }

    protected static <V> void serializeIntegerMapTo(CodedOutputStream codedOutputStream, c0<Integer, V> c0Var, a0<Integer, V> a0Var, int i10) throws IOException {
        Map<Integer, V> j10 = c0Var.j();
        if (!codedOutputStream.Y()) {
            serializeMapTo(codedOutputStream, j10, a0Var, i10);
            return;
        }
        int size = j10.size();
        int[] iArr = new int[size];
        int i11 = 0;
        for (Integer num : j10.keySet()) {
            i11++;
            iArr[i11] = num.intValue();
        }
        Arrays.sort(iArr);
        for (int i12 = 0; i12 < size; i12++) {
            int i13 = iArr[i12];
            codedOutputStream.A0(i10, a0Var.newBuilderForType().n(Integer.valueOf(i13)).p(j10.get(Integer.valueOf(i13))).build());
        }
    }

    protected static <V> void serializeLongMapTo(CodedOutputStream codedOutputStream, c0<Long, V> c0Var, a0<Long, V> a0Var, int i10) throws IOException {
        Map<Long, V> j10 = c0Var.j();
        if (!codedOutputStream.Y()) {
            serializeMapTo(codedOutputStream, j10, a0Var, i10);
            return;
        }
        int size = j10.size();
        long[] jArr = new long[size];
        int i11 = 0;
        for (Long l10 : j10.keySet()) {
            i11++;
            jArr[i11] = l10.longValue();
        }
        Arrays.sort(jArr);
        for (int i12 = 0; i12 < size; i12++) {
            long j11 = jArr[i12];
            codedOutputStream.A0(i10, a0Var.newBuilderForType().n(Long.valueOf(j11)).p(j10.get(Long.valueOf(j11))).build());
        }
    }

    private static <K, V> void serializeMapTo(CodedOutputStream codedOutputStream, Map<K, V> map, a0<K, V> a0Var, int i10) throws IOException {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            codedOutputStream.A0(i10, a0Var.newBuilderForType().n(entry.getKey()).p(entry.getValue()).build());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <V> void serializeStringMapTo(CodedOutputStream codedOutputStream, c0<String, V> c0Var, a0<String, V> a0Var, int i10) throws IOException {
        Map<String, V> j10 = c0Var.j();
        if (!codedOutputStream.Y()) {
            serializeMapTo(codedOutputStream, j10, a0Var, i10);
            return;
        }
        String[] strArr = (String[]) j10.keySet().toArray(new String[j10.size()]);
        Arrays.sort(strArr);
        for (String str : strArr) {
            codedOutputStream.A0(i10, a0Var.newBuilderForType().n(str).p(j10.get(str)).build());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void writeString(CodedOutputStream codedOutputStream, int i10, Object obj) throws IOException {
        if (obj instanceof String) {
            codedOutputStream.J0(i10, (String) obj);
        } else {
            codedOutputStream.i0(i10, (ByteString) obj);
        }
    }

    protected static void writeStringNoTag(CodedOutputStream codedOutputStream, Object obj) throws IOException {
        if (obj instanceof String) {
            codedOutputStream.K0((String) obj);
        } else {
            codedOutputStream.j0((ByteString) obj);
        }
    }

    @Override // com.google.protobuf.g0
    public Map<Descriptors.FieldDescriptor, Object> getAllFields() {
        return Collections.unmodifiableMap(getAllFieldsMutable(false));
    }

    Map<Descriptors.FieldDescriptor, Object> getAllFieldsRaw() {
        return Collections.unmodifiableMap(getAllFieldsMutable(true));
    }

    @Override // com.google.protobuf.f0, com.google.protobuf.g0
    public abstract /* synthetic */ d0 getDefaultInstanceForType();

    @Override // com.google.protobuf.f0, com.google.protobuf.g0
    public abstract /* synthetic */ e0 getDefaultInstanceForType();

    @Override // com.google.protobuf.g0
    public Descriptors.b getDescriptorForType() {
        return internalGetFieldAccessorTable().f13032a;
    }

    @Override // com.google.protobuf.g0
    public Object getField(Descriptors.FieldDescriptor fieldDescriptor) {
        return internalGetFieldAccessorTable().f(fieldDescriptor).h(this);
    }

    Object getFieldRaw(Descriptors.FieldDescriptor fieldDescriptor) {
        return internalGetFieldAccessorTable().f(fieldDescriptor).d(this);
    }

    @Override // com.google.protobuf.a
    public Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.h hVar) {
        return internalGetFieldAccessorTable().g(hVar).c(this);
    }

    @Override // com.google.protobuf.e0, com.google.protobuf.d0
    public l0<? extends GeneratedMessageV3> getParserForType() {
        throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }

    public Object getRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i10) {
        return internalGetFieldAccessorTable().f(fieldDescriptor).o(this, i10);
    }

    public int getRepeatedFieldCount(Descriptors.FieldDescriptor fieldDescriptor) {
        return internalGetFieldAccessorTable().f(fieldDescriptor).g(this);
    }

    @Override // com.google.protobuf.a, com.google.protobuf.e0
    public int getSerializedSize() {
        int i10 = this.memoizedSize;
        if (i10 != -1) {
            return i10;
        }
        int e10 = MessageReflection.e(this, getAllFieldsRaw());
        this.memoizedSize = e10;
        return e10;
    }

    public a1 getUnknownFields() {
        throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }

    @Override // com.google.protobuf.g0
    public boolean hasField(Descriptors.FieldDescriptor fieldDescriptor) {
        return internalGetFieldAccessorTable().f(fieldDescriptor).i(this);
    }

    @Override // com.google.protobuf.a
    public boolean hasOneof(Descriptors.h hVar) {
        return internalGetFieldAccessorTable().g(hVar).e(this);
    }

    protected abstract e internalGetFieldAccessorTable();

    protected c0 internalGetMapField(int i10) {
        throw new RuntimeException("No map fields found in " + getClass().getName());
    }

    @Override // com.google.protobuf.a, com.google.protobuf.f0
    public boolean isInitialized() {
        for (Descriptors.FieldDescriptor fieldDescriptor : getDescriptorForType().l()) {
            if (fieldDescriptor.C() && !hasField(fieldDescriptor)) {
                return false;
            }
            if (fieldDescriptor.u() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                if (fieldDescriptor.o()) {
                    for (d0 d0Var : (List) getField(fieldDescriptor)) {
                        if (!d0Var.isInitialized()) {
                            return false;
                        }
                    }
                    continue;
                } else if (hasField(fieldDescriptor) && !((d0) getField(fieldDescriptor)).isInitialized()) {
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void makeExtensionsImmutable() {
    }

    @Override // com.google.protobuf.e0, com.google.protobuf.d0
    public abstract /* synthetic */ d0.a newBuilderForType();

    protected abstract d0.a newBuilderForType(c cVar);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.a
    public d0.a newBuilderForType(a.b bVar) {
        return newBuilderForType((c) new a(this, bVar));
    }

    @Override // com.google.protobuf.e0, com.google.protobuf.d0
    public abstract /* synthetic */ e0.a newBuilderForType();

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean parseUnknownField(i iVar, a1.b bVar, q qVar, int i10) throws IOException {
        return bVar.l(i10, iVar);
    }

    @Override // com.google.protobuf.e0, com.google.protobuf.d0
    public abstract /* synthetic */ d0.a toBuilder();

    @Override // com.google.protobuf.e0, com.google.protobuf.d0
    public abstract /* synthetic */ e0.a toBuilder();

    protected Object writeReplace() throws ObjectStreamException {
        return new GeneratedMessageLite$SerializedForm(this);
    }

    @Override // com.google.protobuf.a, com.google.protobuf.e0
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        MessageReflection.k(this, getAllFieldsRaw(), codedOutputStream, false);
    }

    /* loaded from: classes.dex */
    public static abstract class ExtendableMessage<MessageType extends ExtendableMessage> extends GeneratedMessageV3 implements g0 {
        private static final long serialVersionUID = 1;
        private final t<Descriptors.FieldDescriptor> extensions;

        /* loaded from: classes.dex */
        protected class a {

            /* renamed from: a  reason: collision with root package name */
            private final Iterator<Map.Entry<Descriptors.FieldDescriptor, Object>> f13025a;

            /* renamed from: b  reason: collision with root package name */
            private Map.Entry<Descriptors.FieldDescriptor, Object> f13026b;

            /* renamed from: c  reason: collision with root package name */
            private final boolean f13027c;

            /* synthetic */ a(ExtendableMessage extendableMessage, boolean z10, a aVar) {
                this(z10);
            }

            public void a(int i10, CodedOutputStream codedOutputStream) throws IOException {
                while (true) {
                    Map.Entry<Descriptors.FieldDescriptor, Object> entry = this.f13026b;
                    if (entry != null && entry.getKey().getNumber() < i10) {
                        Descriptors.FieldDescriptor key = this.f13026b.getKey();
                        if (!this.f13027c || key.s() != WireFormat.JavaType.MESSAGE || key.o()) {
                            t.H(key, this.f13026b.getValue(), codedOutputStream);
                        } else if (this.f13026b instanceof v.b) {
                            codedOutputStream.D0(key.getNumber(), ((v.b) this.f13026b).a().f());
                        } else {
                            codedOutputStream.C0(key.getNumber(), (d0) this.f13026b.getValue());
                        }
                        if (this.f13025a.hasNext()) {
                            this.f13026b = this.f13025a.next();
                        } else {
                            this.f13026b = null;
                        }
                    } else {
                        return;
                    }
                }
            }

            private a(boolean z10) {
                Iterator<Map.Entry<Descriptors.FieldDescriptor, Object>> w10 = ExtendableMessage.this.extensions.w();
                this.f13025a = w10;
                if (w10.hasNext()) {
                    this.f13026b = w10.next();
                }
                this.f13027c = z10;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public ExtendableMessage() {
            this.extensions = t.A();
        }

        private void h(Descriptors.FieldDescriptor fieldDescriptor) {
            if (fieldDescriptor.k() != getDescriptorForType()) {
                throw new IllegalArgumentException("FieldDescriptor does not match message type.");
            }
        }

        private void i(Extension<MessageType, ?> extension) {
            if (extension.d().k() != getDescriptorForType()) {
                throw new IllegalArgumentException("Extension is for type \"" + extension.d().k().b() + "\" which does not match message type \"" + getDescriptorForType().b() + "\".");
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public boolean b() {
            return this.extensions.u();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public int c() {
            return this.extensions.q();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public Map<Descriptors.FieldDescriptor, Object> d() {
            return this.extensions.k();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public ExtendableMessage<MessageType>.a g() {
            return new a(this, false, null);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.g0
        public Map<Descriptors.FieldDescriptor, Object> getAllFields() {
            Map allFieldsMutable = getAllFieldsMutable(false);
            allFieldsMutable.putAll(d());
            return Collections.unmodifiableMap(allFieldsMutable);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public Map<Descriptors.FieldDescriptor, Object> getAllFieldsRaw() {
            Map allFieldsMutable = getAllFieldsMutable(false);
            allFieldsMutable.putAll(d());
            return Collections.unmodifiableMap(allFieldsMutable);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
        public abstract /* synthetic */ d0 getDefaultInstanceForType();

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.f0, com.google.protobuf.g0
        public abstract /* synthetic */ e0 getDefaultInstanceForType();

        public final <Type> Type getExtension(n<MessageType, Type> nVar) {
            Extension<MessageType, ?> checkNotLite = GeneratedMessageV3.checkNotLite(nVar);
            i(checkNotLite);
            Descriptors.FieldDescriptor d10 = checkNotLite.d();
            Object l10 = this.extensions.l(d10);
            if (l10 != null) {
                return (Type) checkNotLite.c(l10);
            }
            if (d10.o()) {
                return (Type) Collections.emptyList();
            }
            if (d10.u() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                return (Type) checkNotLite.a();
            }
            return (Type) checkNotLite.c(d10.l());
        }

        public final <Type> int getExtensionCount(n<MessageType, List<Type>> nVar) {
            Extension<MessageType, ?> checkNotLite = GeneratedMessageV3.checkNotLite(nVar);
            i(checkNotLite);
            return this.extensions.p(checkNotLite.d());
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.g0
        public Object getField(Descriptors.FieldDescriptor fieldDescriptor) {
            if (!fieldDescriptor.y()) {
                return GeneratedMessageV3.super.getField(fieldDescriptor);
            }
            h(fieldDescriptor);
            Object l10 = this.extensions.l(fieldDescriptor);
            if (l10 != null) {
                return l10;
            }
            if (fieldDescriptor.o()) {
                return Collections.emptyList();
            }
            if (fieldDescriptor.u() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                return k.g(fieldDescriptor.v());
            }
            return fieldDescriptor.l();
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public Object getRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i10) {
            if (!fieldDescriptor.y()) {
                return GeneratedMessageV3.super.getRepeatedField(fieldDescriptor, i10);
            }
            h(fieldDescriptor);
            return this.extensions.o(fieldDescriptor, i10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public int getRepeatedFieldCount(Descriptors.FieldDescriptor fieldDescriptor) {
            if (!fieldDescriptor.y()) {
                return GeneratedMessageV3.super.getRepeatedFieldCount(fieldDescriptor);
            }
            h(fieldDescriptor);
            return this.extensions.p(fieldDescriptor);
        }

        public final <Type> boolean hasExtension(n<MessageType, Type> nVar) {
            Extension<MessageType, ?> checkNotLite = GeneratedMessageV3.checkNotLite(nVar);
            i(checkNotLite);
            return this.extensions.s(checkNotLite.d());
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.g0
        public boolean hasField(Descriptors.FieldDescriptor fieldDescriptor) {
            if (!fieldDescriptor.y()) {
                return GeneratedMessageV3.super.hasField(fieldDescriptor);
            }
            h(fieldDescriptor);
            return this.extensions.s(fieldDescriptor);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.a, com.google.protobuf.f0
        public boolean isInitialized() {
            return GeneratedMessageV3.super.isInitialized() && b();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public void makeExtensionsImmutable() {
            this.extensions.x();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public abstract /* synthetic */ d0.a newBuilderForType();

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public abstract /* synthetic */ e0.a newBuilderForType();

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public boolean parseUnknownField(i iVar, a1.b bVar, q qVar, int i10) throws IOException {
            return MessageReflection.g(iVar, bVar, qVar, getDescriptorForType(), new MessageReflection.c(this.extensions), i10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public abstract /* synthetic */ d0.a toBuilder();

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.e0, com.google.protobuf.d0
        public abstract /* synthetic */ e0.a toBuilder();

        /* JADX INFO: Access modifiers changed from: protected */
        public ExtendableMessage(d<MessageType, ?> dVar) {
            super(dVar);
            this.extensions = dVar.c();
        }

        public final <Type> boolean hasExtension(Extension<MessageType, Type> extension) {
            return hasExtension((n) extension);
        }

        public final <Type> int getExtensionCount(Extension<MessageType, List<Type>> extension) {
            return getExtensionCount((n) extension);
        }

        public final <Type> boolean hasExtension(GeneratedMessage.j<MessageType, Type> jVar) {
            return hasExtension((n) jVar);
        }

        public final <Type> int getExtensionCount(GeneratedMessage.j<MessageType, List<Type>> jVar) {
            return getExtensionCount((n) jVar);
        }

        public final <Type> Type getExtension(n<MessageType, List<Type>> nVar, int i10) {
            Extension<MessageType, ?> checkNotLite = GeneratedMessageV3.checkNotLite(nVar);
            i(checkNotLite);
            return (Type) checkNotLite.e(this.extensions.o(checkNotLite.d(), i10));
        }

        public final <Type> Type getExtension(Extension<MessageType, Type> extension) {
            return (Type) getExtension((n<MessageType, Object>) extension);
        }

        public final <Type> Type getExtension(GeneratedMessage.j<MessageType, Type> jVar) {
            return (Type) getExtension((n<MessageType, Object>) jVar);
        }

        public final <Type> Type getExtension(Extension<MessageType, List<Type>> extension, int i10) {
            return (Type) getExtension((n<MessageType, List<Object>>) extension, i10);
        }

        public final <Type> Type getExtension(GeneratedMessage.j<MessageType, List<Type>> jVar, int i10) {
            return (Type) getExtension((n<MessageType, List<Object>>) jVar, i10);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class d<MessageType extends ExtendableMessage, BuilderType extends d<MessageType, BuilderType>> extends b<BuilderType> implements g0 {

        /* renamed from: a  reason: collision with root package name */
        private t<Descriptors.FieldDescriptor> f13031a = t.j();

        /* JADX INFO: Access modifiers changed from: protected */
        public d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public t<Descriptors.FieldDescriptor> c() {
            this.f13031a.x();
            return this.f13031a;
        }

        private void g() {
            if (this.f13031a.t()) {
                this.f13031a = this.f13031a.clone();
            }
        }

        private void m(Descriptors.FieldDescriptor fieldDescriptor) {
            if (fieldDescriptor.k() != getDescriptorForType()) {
                throw new IllegalArgumentException("FieldDescriptor does not match message type.");
            }
        }

        /* renamed from: b */
        public BuilderType addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            if (!fieldDescriptor.y()) {
                return (BuilderType) super.addRepeatedField(fieldDescriptor, obj);
            }
            m(fieldDescriptor);
            g();
            this.f13031a.a(fieldDescriptor, obj);
            onChanged();
            return this;
        }

        /* renamed from: d */
        public BuilderType clear() {
            this.f13031a = t.j();
            return (BuilderType) super.clear();
        }

        /* renamed from: e */
        public BuilderType clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            if (!fieldDescriptor.y()) {
                return (BuilderType) super.clearField(fieldDescriptor);
            }
            m(fieldDescriptor);
            g();
            this.f13031a.c(fieldDescriptor);
            onChanged();
            return this;
        }

        /* renamed from: f */
        public BuilderType clone() {
            return (BuilderType) super.clone();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.g0
        public Map<Descriptors.FieldDescriptor, Object> getAllFields() {
            Map allFieldsMutable = getAllFieldsMutable();
            allFieldsMutable.putAll(this.f13031a.k());
            return Collections.unmodifiableMap(allFieldsMutable);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.g0
        public Object getField(Descriptors.FieldDescriptor fieldDescriptor) {
            if (!fieldDescriptor.y()) {
                return super.getField(fieldDescriptor);
            }
            m(fieldDescriptor);
            Object l10 = this.f13031a.l(fieldDescriptor);
            if (l10 != null) {
                return l10;
            }
            if (fieldDescriptor.u() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                return k.g(fieldDescriptor.v());
            }
            return fieldDescriptor.l();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.b
        public Object getRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i10) {
            if (!fieldDescriptor.y()) {
                return super.getRepeatedField(fieldDescriptor, i10);
            }
            m(fieldDescriptor);
            return this.f13031a.o(fieldDescriptor, i10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.b
        public int getRepeatedFieldCount(Descriptors.FieldDescriptor fieldDescriptor) {
            if (!fieldDescriptor.y()) {
                return super.getRepeatedFieldCount(fieldDescriptor);
            }
            m(fieldDescriptor);
            return this.f13031a.p(fieldDescriptor);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.g0
        public boolean hasField(Descriptors.FieldDescriptor fieldDescriptor) {
            if (!fieldDescriptor.y()) {
                return super.hasField(fieldDescriptor);
            }
            m(fieldDescriptor);
            return this.f13031a.s(fieldDescriptor);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public boolean i() {
            return this.f13031a.u();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.b, com.google.protobuf.f0
        public boolean isInitialized() {
            return super.isInitialized() && i();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final void j(ExtendableMessage extendableMessage) {
            g();
            this.f13031a.y(extendableMessage.extensions);
            onChanged();
        }

        /* renamed from: k */
        public BuilderType setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            if (!fieldDescriptor.y()) {
                return (BuilderType) super.setField(fieldDescriptor, obj);
            }
            m(fieldDescriptor);
            g();
            this.f13031a.C(fieldDescriptor, obj);
            onChanged();
            return this;
        }

        /* renamed from: l */
        public BuilderType setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i10, Object obj) {
            if (!fieldDescriptor.y()) {
                return (BuilderType) super.setRepeatedField(fieldDescriptor, i10, obj);
            }
            m(fieldDescriptor);
            g();
            this.f13031a.D(fieldDescriptor, i10, obj);
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.b
        protected boolean parseUnknownField(i iVar, a1.b bVar, q qVar, int i10) throws IOException {
            return MessageReflection.g(iVar, bVar, qVar, getDescriptorForType(), new MessageReflection.b(this), i10);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public d(c cVar) {
            super(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public GeneratedMessageV3(b<?> bVar) {
        this.unknownFields = bVar.getUnknownFields();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <M extends d0> M parseDelimitedWithIOException(l0<M> l0Var, InputStream inputStream, q qVar) throws IOException {
        try {
            return l0Var.parseDelimitedFrom(inputStream, qVar);
        } catch (InvalidProtocolBufferException e10) {
            throw e10.unwrapIOException();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <M extends d0> M parseWithIOException(l0<M> l0Var, InputStream inputStream, q qVar) throws IOException {
        try {
            return l0Var.parseFrom(inputStream, qVar);
        } catch (InvalidProtocolBufferException e10) {
            throw e10.unwrapIOException();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <M extends d0> M parseWithIOException(l0<M> l0Var, i iVar) throws IOException {
        try {
            return l0Var.parseFrom(iVar);
        } catch (InvalidProtocolBufferException e10) {
            throw e10.unwrapIOException();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <M extends d0> M parseWithIOException(l0<M> l0Var, i iVar, q qVar) throws IOException {
        try {
            return l0Var.parseFrom(iVar, qVar);
        } catch (InvalidProtocolBufferException e10) {
            throw e10.unwrapIOException();
        }
    }
}
