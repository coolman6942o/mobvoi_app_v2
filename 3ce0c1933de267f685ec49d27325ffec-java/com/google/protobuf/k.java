package com.google.protobuf;

import com.google.protobuf.Descriptors;
import com.google.protobuf.a;
import com.google.protobuf.d0;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
/* compiled from: DynamicMessage.java */
/* loaded from: classes.dex */
public final class k extends com.google.protobuf.a {

    /* renamed from: a  reason: collision with root package name */
    private final Descriptors.b f13273a;

    /* renamed from: b  reason: collision with root package name */
    private final t<Descriptors.FieldDescriptor> f13274b;

    /* renamed from: c  reason: collision with root package name */
    private final Descriptors.FieldDescriptor[] f13275c;

    /* renamed from: d  reason: collision with root package name */
    private final a1 f13276d;

    /* renamed from: e  reason: collision with root package name */
    private int f13277e = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DynamicMessage.java */
    /* loaded from: classes.dex */
    public class a extends c<k> {
        a() {
        }

        /* renamed from: a */
        public k parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
            b j10 = k.j(k.this.f13273a);
            try {
                j10.mergeFrom(iVar, qVar);
                return j10.buildPartial();
            } catch (InvalidProtocolBufferException e10) {
                throw e10.setUnfinishedMessage(j10.buildPartial());
            } catch (IOException e11) {
                throw new InvalidProtocolBufferException(e11.getMessage()).setUnfinishedMessage(j10.buildPartial());
            }
        }
    }

    /* compiled from: DynamicMessage.java */
    /* loaded from: classes.dex */
    public static final class b extends a.AbstractC0170a<b> {

        /* renamed from: a  reason: collision with root package name */
        private final Descriptors.b f13279a;

        /* renamed from: b  reason: collision with root package name */
        private t<Descriptors.FieldDescriptor> f13280b;

        /* renamed from: c  reason: collision with root package name */
        private final Descriptors.FieldDescriptor[] f13281c;

        /* renamed from: d  reason: collision with root package name */
        private a1 f13282d;

        /* synthetic */ b(Descriptors.b bVar, a aVar) {
            this(bVar);
        }

        private void i(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            if (fieldDescriptor.o()) {
                for (Object obj2 : (List) obj) {
                    k(fieldDescriptor, obj2);
                }
                return;
            }
            k(fieldDescriptor, obj);
        }

        private void j() {
            if (this.f13280b.t()) {
                this.f13280b = this.f13280b.clone();
            }
        }

        private void k(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            Objects.requireNonNull(obj);
            if (!(obj instanceof Descriptors.e)) {
                throw new IllegalArgumentException("DynamicMessage should use EnumValueDescriptor to set Enum Value.");
            }
        }

        private void r(Descriptors.FieldDescriptor fieldDescriptor) {
            if (fieldDescriptor.k() != this.f13279a) {
                throw new IllegalArgumentException("FieldDescriptor does not match message type.");
            }
        }

        private void s(Descriptors.h hVar) {
            if (hVar.f() != this.f13279a) {
                throw new IllegalArgumentException("OneofDescriptor does not match message type.");
            }
        }

        /* renamed from: a */
        public b addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            r(fieldDescriptor);
            j();
            this.f13280b.a(fieldDescriptor, obj);
            return this;
        }

        /* renamed from: b */
        public k build() {
            if (isInitialized()) {
                return buildPartial();
            }
            Descriptors.b bVar = this.f13279a;
            t<Descriptors.FieldDescriptor> tVar = this.f13280b;
            Descriptors.FieldDescriptor[] fieldDescriptorArr = this.f13281c;
            throw a.AbstractC0170a.newUninitializedMessageException((d0) new k(bVar, tVar, (Descriptors.FieldDescriptor[]) Arrays.copyOf(fieldDescriptorArr, fieldDescriptorArr.length), this.f13282d));
        }

        /* renamed from: c */
        public k buildPartial() {
            this.f13280b.x();
            Descriptors.b bVar = this.f13279a;
            t<Descriptors.FieldDescriptor> tVar = this.f13280b;
            Descriptors.FieldDescriptor[] fieldDescriptorArr = this.f13281c;
            return new k(bVar, tVar, (Descriptors.FieldDescriptor[]) Arrays.copyOf(fieldDescriptorArr, fieldDescriptorArr.length), this.f13282d);
        }

        /* renamed from: d */
        public b clear() {
            if (this.f13280b.t()) {
                this.f13280b = t.A();
            } else {
                this.f13280b.b();
            }
            this.f13282d = a1.c();
            return this;
        }

        /* renamed from: e */
        public b clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            r(fieldDescriptor);
            j();
            Descriptors.h j10 = fieldDescriptor.j();
            if (j10 != null) {
                int h10 = j10.h();
                Descriptors.FieldDescriptor[] fieldDescriptorArr = this.f13281c;
                if (fieldDescriptorArr[h10] == fieldDescriptor) {
                    fieldDescriptorArr[h10] = null;
                }
            }
            this.f13280b.c(fieldDescriptor);
            return this;
        }

        /* renamed from: f */
        public b clearOneof2(Descriptors.h hVar) {
            s(hVar);
            Descriptors.FieldDescriptor fieldDescriptor = this.f13281c[hVar.h()];
            if (fieldDescriptor != null) {
                clearField(fieldDescriptor);
            }
            return this;
        }

        /* renamed from: g */
        public b clone() {
            b bVar = new b(this.f13279a);
            bVar.f13280b.y(this.f13280b);
            bVar.mergeUnknownFields2(this.f13282d);
            Descriptors.FieldDescriptor[] fieldDescriptorArr = this.f13281c;
            System.arraycopy(fieldDescriptorArr, 0, bVar.f13281c, 0, fieldDescriptorArr.length);
            return bVar;
        }

        @Override // com.google.protobuf.g0
        public Map<Descriptors.FieldDescriptor, Object> getAllFields() {
            return this.f13280b.k();
        }

        @Override // com.google.protobuf.d0.a, com.google.protobuf.g0
        public Descriptors.b getDescriptorForType() {
            return this.f13279a;
        }

        @Override // com.google.protobuf.g0
        public Object getField(Descriptors.FieldDescriptor fieldDescriptor) {
            r(fieldDescriptor);
            Object l10 = this.f13280b.l(fieldDescriptor);
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

        @Override // com.google.protobuf.a.AbstractC0170a
        public d0.a getFieldBuilder(Descriptors.FieldDescriptor fieldDescriptor) {
            throw new UnsupportedOperationException("getFieldBuilder() called on a dynamic message type.");
        }

        @Override // com.google.protobuf.a.AbstractC0170a
        public Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.h hVar) {
            s(hVar);
            return this.f13281c[hVar.h()];
        }

        @Override // com.google.protobuf.a.AbstractC0170a
        public d0.a getRepeatedFieldBuilder(Descriptors.FieldDescriptor fieldDescriptor, int i10) {
            throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on a dynamic message type.");
        }

        @Override // com.google.protobuf.g0
        public a1 getUnknownFields() {
            return this.f13282d;
        }

        @Override // com.google.protobuf.g0
        public boolean hasField(Descriptors.FieldDescriptor fieldDescriptor) {
            r(fieldDescriptor);
            return this.f13280b.s(fieldDescriptor);
        }

        @Override // com.google.protobuf.a.AbstractC0170a
        public boolean hasOneof(Descriptors.h hVar) {
            s(hVar);
            return this.f13281c[hVar.h()] != null;
        }

        @Override // com.google.protobuf.f0
        public boolean isInitialized() {
            return k.i(this.f13279a, this.f13280b);
        }

        /* renamed from: l */
        public k getDefaultInstanceForType() {
            return k.g(this.f13279a);
        }

        /* renamed from: m */
        public b mergeFrom(d0 d0Var) {
            if (!(d0Var instanceof k)) {
                return (b) super.mergeFrom(d0Var);
            }
            k kVar = (k) d0Var;
            if (kVar.f13273a == this.f13279a) {
                j();
                this.f13280b.y(kVar.f13274b);
                mergeUnknownFields2(kVar.f13276d);
                int i10 = 0;
                while (true) {
                    Descriptors.FieldDescriptor[] fieldDescriptorArr = this.f13281c;
                    if (i10 >= fieldDescriptorArr.length) {
                        return this;
                    }
                    if (fieldDescriptorArr[i10] == null) {
                        fieldDescriptorArr[i10] = kVar.f13275c[i10];
                    } else if (!(kVar.f13275c[i10] == null || this.f13281c[i10] == kVar.f13275c[i10])) {
                        this.f13280b.c(this.f13281c[i10]);
                        this.f13281c[i10] = kVar.f13275c[i10];
                    }
                    i10++;
                }
            } else {
                throw new IllegalArgumentException("mergeFrom(Message) can only merge messages of the same type.");
            }
        }

        /* renamed from: n */
        public b mergeUnknownFields2(a1 a1Var) {
            if (getDescriptorForType().a().n() == Descriptors.FileDescriptor.Syntax.PROTO3) {
                return this;
            }
            this.f13282d = a1.h(this.f13282d).o(a1Var).build();
            return this;
        }

        /* renamed from: o */
        public b newBuilderForField(Descriptors.FieldDescriptor fieldDescriptor) {
            r(fieldDescriptor);
            if (fieldDescriptor.u() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                return new b(fieldDescriptor.v());
            }
            throw new IllegalArgumentException("newBuilderForField is only valid for fields with message type.");
        }

        /* renamed from: p */
        public b setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            r(fieldDescriptor);
            j();
            if (fieldDescriptor.x() == Descriptors.FieldDescriptor.Type.ENUM) {
                i(fieldDescriptor, obj);
            }
            Descriptors.h j10 = fieldDescriptor.j();
            if (j10 != null) {
                int h10 = j10.h();
                Descriptors.FieldDescriptor fieldDescriptor2 = this.f13281c[h10];
                if (!(fieldDescriptor2 == null || fieldDescriptor2 == fieldDescriptor)) {
                    this.f13280b.c(fieldDescriptor2);
                }
                this.f13281c[h10] = fieldDescriptor;
            } else if (fieldDescriptor.a().n() == Descriptors.FileDescriptor.Syntax.PROTO3 && !fieldDescriptor.o() && fieldDescriptor.u() != Descriptors.FieldDescriptor.JavaType.MESSAGE && obj.equals(fieldDescriptor.l())) {
                this.f13280b.c(fieldDescriptor);
                return this;
            }
            this.f13280b.C(fieldDescriptor, obj);
            return this;
        }

        /* renamed from: q */
        public b setUnknownFields(a1 a1Var) {
            if (getDescriptorForType().a().n() == Descriptors.FileDescriptor.Syntax.PROTO3) {
                return this;
            }
            this.f13282d = a1Var;
            return this;
        }

        private b(Descriptors.b bVar) {
            this.f13279a = bVar;
            this.f13280b = t.A();
            this.f13282d = a1.c();
            this.f13281c = new Descriptors.FieldDescriptor[bVar.d().getOneofDeclCount()];
        }
    }

    k(Descriptors.b bVar, t<Descriptors.FieldDescriptor> tVar, Descriptors.FieldDescriptor[] fieldDescriptorArr, a1 a1Var) {
        this.f13273a = bVar;
        this.f13274b = tVar;
        this.f13275c = fieldDescriptorArr;
        this.f13276d = a1Var;
    }

    public static k g(Descriptors.b bVar) {
        return new k(bVar, t.j(), new Descriptors.FieldDescriptor[bVar.d().getOneofDeclCount()], a1.c());
    }

    static boolean i(Descriptors.b bVar, t<Descriptors.FieldDescriptor> tVar) {
        for (Descriptors.FieldDescriptor fieldDescriptor : bVar.l()) {
            if (fieldDescriptor.C() && !tVar.s(fieldDescriptor)) {
                return false;
            }
        }
        return tVar.u();
    }

    public static b j(Descriptors.b bVar) {
        return new b(bVar, null);
    }

    private void m(Descriptors.FieldDescriptor fieldDescriptor) {
        if (fieldDescriptor.k() != this.f13273a) {
            throw new IllegalArgumentException("FieldDescriptor does not match message type.");
        }
    }

    private void n(Descriptors.h hVar) {
        if (hVar.f() != this.f13273a) {
            throw new IllegalArgumentException("OneofDescriptor does not match message type.");
        }
    }

    @Override // com.google.protobuf.g0
    public Map<Descriptors.FieldDescriptor, Object> getAllFields() {
        return this.f13274b.k();
    }

    @Override // com.google.protobuf.g0
    public Descriptors.b getDescriptorForType() {
        return this.f13273a;
    }

    @Override // com.google.protobuf.g0
    public Object getField(Descriptors.FieldDescriptor fieldDescriptor) {
        m(fieldDescriptor);
        Object l10 = this.f13274b.l(fieldDescriptor);
        if (l10 != null) {
            return l10;
        }
        if (fieldDescriptor.o()) {
            return Collections.emptyList();
        }
        if (fieldDescriptor.u() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
            return g(fieldDescriptor.v());
        }
        return fieldDescriptor.l();
    }

    @Override // com.google.protobuf.a
    public Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.h hVar) {
        n(hVar);
        return this.f13275c[hVar.h()];
    }

    @Override // com.google.protobuf.e0, com.google.protobuf.d0
    public l0<k> getParserForType() {
        return new a();
    }

    @Override // com.google.protobuf.a, com.google.protobuf.e0
    public int getSerializedSize() {
        int i10;
        int i11;
        int i12 = this.f13277e;
        if (i12 != -1) {
            return i12;
        }
        if (this.f13273a.q().getMessageSetWireFormat()) {
            i11 = this.f13274b.m();
            i10 = this.f13276d.f();
        } else {
            i11 = this.f13274b.q();
            i10 = this.f13276d.getSerializedSize();
        }
        int i13 = i11 + i10;
        this.f13277e = i13;
        return i13;
    }

    @Override // com.google.protobuf.g0
    public a1 getUnknownFields() {
        return this.f13276d;
    }

    /* renamed from: h */
    public k getDefaultInstanceForType() {
        return g(this.f13273a);
    }

    @Override // com.google.protobuf.g0
    public boolean hasField(Descriptors.FieldDescriptor fieldDescriptor) {
        m(fieldDescriptor);
        return this.f13274b.s(fieldDescriptor);
    }

    @Override // com.google.protobuf.a
    public boolean hasOneof(Descriptors.h hVar) {
        n(hVar);
        return this.f13275c[hVar.h()] != null;
    }

    @Override // com.google.protobuf.a, com.google.protobuf.f0
    public boolean isInitialized() {
        return i(this.f13273a, this.f13274b);
    }

    /* renamed from: k */
    public b newBuilderForType() {
        return new b(this.f13273a, null);
    }

    /* renamed from: l */
    public b toBuilder() {
        return newBuilderForType().mergeFrom(this);
    }

    @Override // com.google.protobuf.a, com.google.protobuf.e0
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (this.f13273a.q().getMessageSetWireFormat()) {
            this.f13274b.I(codedOutputStream);
            this.f13276d.k(codedOutputStream);
            return;
        }
        this.f13274b.K(codedOutputStream);
        this.f13276d.writeTo(codedOutputStream);
    }
}
