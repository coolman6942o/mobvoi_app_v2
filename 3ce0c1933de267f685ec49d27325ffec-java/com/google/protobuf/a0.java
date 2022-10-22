package com.google.protobuf;

import com.google.protobuf.Descriptors;
import com.google.protobuf.WireFormat;
import com.google.protobuf.a;
import com.google.protobuf.b0;
import com.google.protobuf.d0;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
/* compiled from: MapEntry.java */
/* loaded from: classes.dex */
public final class a0<K, V> extends com.google.protobuf.a {

    /* renamed from: a  reason: collision with root package name */
    private final K f13146a;

    /* renamed from: b  reason: collision with root package name */
    private final V f13147b;

    /* renamed from: c  reason: collision with root package name */
    private final c<K, V> f13148c;

    /* renamed from: d  reason: collision with root package name */
    private volatile int f13149d;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MapEntry.java */
    /* loaded from: classes.dex */
    public static final class c<K, V> extends b0.b<K, V> {

        /* renamed from: e  reason: collision with root package name */
        public final Descriptors.b f13153e;

        /* renamed from: f  reason: collision with root package name */
        public final l0<a0<K, V>> f13154f = new a();

        /* compiled from: MapEntry.java */
        /* loaded from: classes.dex */
        class a extends com.google.protobuf.c<a0<K, V>> {
            a() {
            }

            /* renamed from: a */
            public a0<K, V> parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
                return new a0<>(c.this, iVar, qVar);
            }
        }

        public c(Descriptors.b bVar, a0<K, V> a0Var, WireFormat.FieldType fieldType, WireFormat.FieldType fieldType2) {
            super(fieldType, ((a0) a0Var).f13146a, fieldType2, ((a0) a0Var).f13147b);
            this.f13153e = bVar;
        }
    }

    private void d(Descriptors.FieldDescriptor fieldDescriptor) {
        if (fieldDescriptor.k() != this.f13148c.f13153e) {
            throw new RuntimeException("Wrong FieldDescriptor \"" + fieldDescriptor.b() + "\" used in message \"" + this.f13148c.f13153e.b());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <V> boolean j(c cVar, V v10) {
        if (cVar.f13172c.getJavaType() == WireFormat.JavaType.MESSAGE) {
            return ((e0) v10).isInitialized();
        }
        return true;
    }

    public static <K, V> a0<K, V> l(Descriptors.b bVar, WireFormat.FieldType fieldType, K k10, WireFormat.FieldType fieldType2, V v10) {
        return new a0<>(bVar, fieldType, k10, fieldType2, v10);
    }

    /* renamed from: g */
    public a0<K, V> getDefaultInstanceForType() {
        c<K, V> cVar = this.f13148c;
        return new a0<>(cVar, cVar.f13171b, cVar.f13173d);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.g0
    public Map<Descriptors.FieldDescriptor, Object> getAllFields() {
        TreeMap treeMap = new TreeMap();
        for (Descriptors.FieldDescriptor fieldDescriptor : this.f13148c.f13153e.l()) {
            if (hasField(fieldDescriptor)) {
                treeMap.put(fieldDescriptor, getField(fieldDescriptor));
            }
        }
        return Collections.unmodifiableMap(treeMap);
    }

    @Override // com.google.protobuf.g0
    public Descriptors.b getDescriptorForType() {
        return this.f13148c.f13153e;
    }

    @Override // com.google.protobuf.g0
    public Object getField(Descriptors.FieldDescriptor fieldDescriptor) {
        d(fieldDescriptor);
        Object h10 = fieldDescriptor.getNumber() == 1 ? h() : i();
        return fieldDescriptor.x() == Descriptors.FieldDescriptor.Type.ENUM ? fieldDescriptor.m().h(((Integer) h10).intValue()) : h10;
    }

    @Override // com.google.protobuf.e0, com.google.protobuf.d0
    public l0<a0<K, V>> getParserForType() {
        return this.f13148c.f13154f;
    }

    @Override // com.google.protobuf.a, com.google.protobuf.e0
    public int getSerializedSize() {
        if (this.f13149d != -1) {
            return this.f13149d;
        }
        int a10 = b0.a(this.f13148c, this.f13146a, this.f13147b);
        this.f13149d = a10;
        return a10;
    }

    @Override // com.google.protobuf.g0
    public a1 getUnknownFields() {
        return a1.c();
    }

    public K h() {
        return this.f13146a;
    }

    @Override // com.google.protobuf.g0
    public boolean hasField(Descriptors.FieldDescriptor fieldDescriptor) {
        d(fieldDescriptor);
        return true;
    }

    public V i() {
        return this.f13147b;
    }

    @Override // com.google.protobuf.a, com.google.protobuf.f0
    public boolean isInitialized() {
        return j(this.f13148c, this.f13147b);
    }

    /* renamed from: k */
    public b<K, V> newBuilderForType() {
        return new b<>(this.f13148c);
    }

    /* renamed from: m */
    public b<K, V> toBuilder() {
        return new b<>(this.f13148c, this.f13146a, this.f13147b);
    }

    @Override // com.google.protobuf.a, com.google.protobuf.e0
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        b0.d(codedOutputStream, this.f13148c, this.f13146a, this.f13147b);
    }

    /* compiled from: MapEntry.java */
    /* loaded from: classes.dex */
    public static class b<K, V> extends a.AbstractC0170a<b<K, V>> {

        /* renamed from: a  reason: collision with root package name */
        private final c<K, V> f13150a;

        /* renamed from: b  reason: collision with root package name */
        private K f13151b;

        /* renamed from: c  reason: collision with root package name */
        private V f13152c;

        private void d(Descriptors.FieldDescriptor fieldDescriptor) {
            if (fieldDescriptor.k() != this.f13150a.f13153e) {
                throw new RuntimeException("Wrong FieldDescriptor \"" + fieldDescriptor.b() + "\" used in message \"" + this.f13150a.f13153e.b());
            }
        }

        /* renamed from: a */
        public b<K, V> addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            throw new RuntimeException("There is no repeated field in a map entry message.");
        }

        /* renamed from: b */
        public a0<K, V> build() {
            a0<K, V> c10 = buildPartial();
            if (c10.isInitialized()) {
                return c10;
            }
            throw a.AbstractC0170a.newUninitializedMessageException((d0) c10);
        }

        /* renamed from: c */
        public a0<K, V> buildPartial() {
            return new a0<>(this.f13150a, this.f13151b, this.f13152c);
        }

        /* renamed from: e */
        public b<K, V> clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            d(fieldDescriptor);
            if (fieldDescriptor.getNumber() == 1) {
                f();
            } else {
                g();
            }
            return this;
        }

        public b<K, V> f() {
            this.f13151b = this.f13150a.f13171b;
            return this;
        }

        public b<K, V> g() {
            this.f13152c = this.f13150a.f13173d;
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.g0
        public Map<Descriptors.FieldDescriptor, Object> getAllFields() {
            TreeMap treeMap = new TreeMap();
            for (Descriptors.FieldDescriptor fieldDescriptor : this.f13150a.f13153e.l()) {
                if (hasField(fieldDescriptor)) {
                    treeMap.put(fieldDescriptor, getField(fieldDescriptor));
                }
            }
            return Collections.unmodifiableMap(treeMap);
        }

        @Override // com.google.protobuf.d0.a, com.google.protobuf.g0
        public Descriptors.b getDescriptorForType() {
            return this.f13150a.f13153e;
        }

        @Override // com.google.protobuf.g0
        public Object getField(Descriptors.FieldDescriptor fieldDescriptor) {
            d(fieldDescriptor);
            Object k10 = fieldDescriptor.getNumber() == 1 ? k() : l();
            return fieldDescriptor.x() == Descriptors.FieldDescriptor.Type.ENUM ? fieldDescriptor.m().h(((Integer) k10).intValue()) : k10;
        }

        @Override // com.google.protobuf.g0
        public a1 getUnknownFields() {
            return a1.c();
        }

        @Override // com.google.protobuf.g0
        public boolean hasField(Descriptors.FieldDescriptor fieldDescriptor) {
            d(fieldDescriptor);
            return true;
        }

        /* renamed from: i */
        public b<K, V> clone() {
            return new b<>(this.f13150a, this.f13151b, this.f13152c);
        }

        @Override // com.google.protobuf.f0
        public boolean isInitialized() {
            return a0.j(this.f13150a, this.f13152c);
        }

        /* renamed from: j */
        public a0<K, V> getDefaultInstanceForType() {
            c<K, V> cVar = this.f13150a;
            return new a0<>(cVar, cVar.f13171b, cVar.f13173d);
        }

        public K k() {
            return this.f13151b;
        }

        public V l() {
            return this.f13152c;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: m */
        public b<K, V> setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            d(fieldDescriptor);
            if (fieldDescriptor.getNumber() == 1) {
                n(obj);
            } else {
                if (fieldDescriptor.x() == Descriptors.FieldDescriptor.Type.ENUM) {
                    obj = Integer.valueOf(((Descriptors.e) obj).getNumber());
                } else if (fieldDescriptor.x() == Descriptors.FieldDescriptor.Type.MESSAGE && obj != null && !this.f13150a.f13173d.getClass().isInstance(obj)) {
                    obj = ((d0) this.f13150a.f13173d).toBuilder().mergeFrom((d0) obj).build();
                }
                p(obj);
            }
            return this;
        }

        public b<K, V> n(K k10) {
            this.f13151b = k10;
            return this;
        }

        @Override // com.google.protobuf.d0.a
        public d0.a newBuilderForField(Descriptors.FieldDescriptor fieldDescriptor) {
            d(fieldDescriptor);
            if (fieldDescriptor.getNumber() == 2 && fieldDescriptor.u() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                return ((d0) this.f13152c).newBuilderForType();
            }
            throw new RuntimeException("\"" + fieldDescriptor.b() + "\" is not a message value field.");
        }

        /* renamed from: o */
        public b<K, V> setUnknownFields(a1 a1Var) {
            return this;
        }

        public b<K, V> p(V v10) {
            this.f13152c = v10;
            return this;
        }

        private b(c<K, V> cVar) {
            this(cVar, cVar.f13171b, cVar.f13173d);
        }

        private b(c<K, V> cVar, K k10, V v10) {
            this.f13150a = cVar;
            this.f13151b = k10;
            this.f13152c = v10;
        }
    }

    private a0(Descriptors.b bVar, WireFormat.FieldType fieldType, K k10, WireFormat.FieldType fieldType2, V v10) {
        this.f13149d = -1;
        this.f13146a = k10;
        this.f13147b = v10;
        this.f13148c = new c<>(bVar, this, fieldType, fieldType2);
    }

    private a0(c cVar, K k10, V v10) {
        this.f13149d = -1;
        this.f13146a = k10;
        this.f13147b = v10;
        this.f13148c = cVar;
    }

    private a0(c<K, V> cVar, i iVar, q qVar) throws InvalidProtocolBufferException {
        this.f13149d = -1;
        try {
            this.f13148c = cVar;
            Map.Entry b10 = b0.b(iVar, cVar, qVar);
            this.f13146a = (K) b10.getKey();
            this.f13147b = (V) b10.getValue();
        } catch (InvalidProtocolBufferException e10) {
            throw e10.setUnfinishedMessage(this);
        } catch (IOException e11) {
            throw new InvalidProtocolBufferException(e11.getMessage()).setUnfinishedMessage(this);
        }
    }
}
