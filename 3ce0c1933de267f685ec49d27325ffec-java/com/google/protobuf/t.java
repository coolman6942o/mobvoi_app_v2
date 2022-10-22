package com.google.protobuf;

import com.google.protobuf.WireFormat;
import com.google.protobuf.e0;
import com.google.protobuf.t.b;
import com.google.protobuf.u;
import com.google.protobuf.v;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FieldSet.java */
/* loaded from: classes.dex */
public final class t<FieldDescriptorType extends b<FieldDescriptorType>> {

    /* renamed from: d  reason: collision with root package name */
    private static final t f13355d = new t(true);

    /* renamed from: b  reason: collision with root package name */
    private boolean f13357b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f13358c = false;

    /* renamed from: a  reason: collision with root package name */
    private final r0<FieldDescriptorType, Object> f13356a = r0.p(16);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FieldSet.java */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f13359a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f13360b;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            f13360b = iArr;
            try {
                iArr[WireFormat.FieldType.DOUBLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f13360b[WireFormat.FieldType.FLOAT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f13360b[WireFormat.FieldType.INT64.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f13360b[WireFormat.FieldType.UINT64.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f13360b[WireFormat.FieldType.INT32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f13360b[WireFormat.FieldType.FIXED64.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f13360b[WireFormat.FieldType.FIXED32.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f13360b[WireFormat.FieldType.BOOL.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f13360b[WireFormat.FieldType.GROUP.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f13360b[WireFormat.FieldType.MESSAGE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f13360b[WireFormat.FieldType.STRING.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f13360b[WireFormat.FieldType.BYTES.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f13360b[WireFormat.FieldType.UINT32.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f13360b[WireFormat.FieldType.SFIXED32.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f13360b[WireFormat.FieldType.SFIXED64.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f13360b[WireFormat.FieldType.SINT32.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f13360b[WireFormat.FieldType.SINT64.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f13360b[WireFormat.FieldType.ENUM.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            int[] iArr2 = new int[WireFormat.JavaType.values().length];
            f13359a = iArr2;
            try {
                iArr2[WireFormat.JavaType.INT.ordinal()] = 1;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f13359a[WireFormat.JavaType.LONG.ordinal()] = 2;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f13359a[WireFormat.JavaType.FLOAT.ordinal()] = 3;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                f13359a[WireFormat.JavaType.DOUBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                f13359a[WireFormat.JavaType.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                f13359a[WireFormat.JavaType.STRING.ordinal()] = 6;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                f13359a[WireFormat.JavaType.BYTE_STRING.ordinal()] = 7;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                f13359a[WireFormat.JavaType.ENUM.ordinal()] = 8;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                f13359a[WireFormat.JavaType.MESSAGE.ordinal()] = 9;
            } catch (NoSuchFieldError unused27) {
            }
        }
    }

    /* compiled from: FieldSet.java */
    /* loaded from: classes.dex */
    public interface b<T extends b<T>> extends Comparable<T> {
        int getNumber();

        boolean o();

        WireFormat.FieldType p();

        e0.a r(e0.a aVar, e0 e0Var);

        WireFormat.JavaType s();

        boolean t();
    }

    private t() {
    }

    public static <T extends b<T>> t<T> A() {
        return new t<>();
    }

    public static Object B(i iVar, WireFormat.FieldType fieldType, boolean z10) throws IOException {
        if (z10) {
            return WireFormat.d(iVar, fieldType, WireFormat.b.STRICT);
        }
        return WireFormat.d(iVar, fieldType, WireFormat.b.LOOSE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0024, code lost:
        if ((r3 instanceof com.google.protobuf.u.a) == false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002d, code lost:
        if ((r3 instanceof byte[]) == false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0030, code lost:
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x001b, code lost:
        if ((r3 instanceof com.google.protobuf.v) == false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void E(WireFormat.FieldType fieldType, Object obj) {
        Objects.requireNonNull(obj);
        boolean z10 = true;
        boolean z11 = false;
        switch (a.f13359a[fieldType.getJavaType().ordinal()]) {
            case 1:
                z11 = obj instanceof Integer;
                break;
            case 2:
                z11 = obj instanceof Long;
                break;
            case 3:
                z11 = obj instanceof Float;
                break;
            case 4:
                z11 = obj instanceof Double;
                break;
            case 5:
                z11 = obj instanceof Boolean;
                break;
            case 6:
                z11 = obj instanceof String;
                break;
            case 7:
                if (!(obj instanceof ByteString)) {
                    break;
                }
                z11 = z10;
                break;
            case 8:
                if (!(obj instanceof Integer)) {
                    break;
                }
                z11 = z10;
                break;
            case 9:
                if (!(obj instanceof e0)) {
                    break;
                }
                z11 = z10;
                break;
        }
        if (!z11) {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void F(CodedOutputStream codedOutputStream, WireFormat.FieldType fieldType, int i10, Object obj) throws IOException {
        if (fieldType == WireFormat.FieldType.GROUP) {
            codedOutputStream.u0(i10, (e0) obj);
            return;
        }
        codedOutputStream.L0(i10, r(fieldType, false));
        G(codedOutputStream, fieldType, obj);
    }

    static void G(CodedOutputStream codedOutputStream, WireFormat.FieldType fieldType, Object obj) throws IOException {
        switch (a.f13360b[fieldType.ordinal()]) {
            case 1:
                codedOutputStream.l0(((Double) obj).doubleValue());
                return;
            case 2:
                codedOutputStream.t0(((Float) obj).floatValue());
                return;
            case 3:
                codedOutputStream.z0(((Long) obj).longValue());
                return;
            case 4:
                codedOutputStream.P0(((Long) obj).longValue());
                return;
            case 5:
                codedOutputStream.x0(((Integer) obj).intValue());
                return;
            case 6:
                codedOutputStream.r0(((Long) obj).longValue());
                return;
            case 7:
                codedOutputStream.p0(((Integer) obj).intValue());
                return;
            case 8:
                codedOutputStream.f0(((Boolean) obj).booleanValue());
                return;
            case 9:
                codedOutputStream.v0((e0) obj);
                return;
            case 10:
                codedOutputStream.B0((e0) obj);
                return;
            case 11:
                if (obj instanceof ByteString) {
                    codedOutputStream.j0((ByteString) obj);
                    return;
                } else {
                    codedOutputStream.K0((String) obj);
                    return;
                }
            case 12:
                if (obj instanceof ByteString) {
                    codedOutputStream.j0((ByteString) obj);
                    return;
                } else {
                    codedOutputStream.g0((byte[]) obj);
                    return;
                }
            case 13:
                codedOutputStream.N0(((Integer) obj).intValue());
                return;
            case 14:
                codedOutputStream.F0(((Integer) obj).intValue());
                return;
            case 15:
                codedOutputStream.G0(((Long) obj).longValue());
                return;
            case 16:
                codedOutputStream.H0(((Integer) obj).intValue());
                return;
            case 17:
                codedOutputStream.I0(((Long) obj).longValue());
                return;
            case 18:
                if (obj instanceof u.a) {
                    codedOutputStream.n0(((u.a) obj).getNumber());
                    return;
                } else {
                    codedOutputStream.n0(((Integer) obj).intValue());
                    return;
                }
            default:
                return;
        }
    }

    public static void H(b<?> bVar, Object obj, CodedOutputStream codedOutputStream) throws IOException {
        WireFormat.FieldType p10 = bVar.p();
        int number = bVar.getNumber();
        if (bVar.o()) {
            List<Object> list = (List) obj;
            if (bVar.t()) {
                codedOutputStream.L0(number, 2);
                int i10 = 0;
                for (Object obj2 : list) {
                    i10 += h(p10, obj2);
                }
                codedOutputStream.E0(i10);
                for (Object obj3 : list) {
                    G(codedOutputStream, p10, obj3);
                }
                return;
            }
            for (Object obj4 : list) {
                F(codedOutputStream, p10, number, obj4);
            }
        } else if (obj instanceof v) {
            F(codedOutputStream, p10, number, ((v) obj).g());
        } else {
            F(codedOutputStream, p10, number, obj);
        }
    }

    private void J(Map.Entry<FieldDescriptorType, Object> entry, CodedOutputStream codedOutputStream) throws IOException {
        FieldDescriptorType key = entry.getKey();
        if (key.s() != WireFormat.JavaType.MESSAGE || key.o() || key.t()) {
            H(key, entry.getValue(), codedOutputStream);
            return;
        }
        Object value = entry.getValue();
        if (value instanceof v) {
            value = ((v) value).g();
        }
        codedOutputStream.C0(entry.getKey().getNumber(), (e0) value);
    }

    private void e(Map<FieldDescriptorType, Object> map, Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof v) {
            map.put(key, ((v) value).g());
        } else {
            map.put(key, value);
        }
    }

    private Object f(Object obj) {
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int g(WireFormat.FieldType fieldType, int i10, Object obj) {
        int P = CodedOutputStream.P(i10);
        if (fieldType == WireFormat.FieldType.GROUP) {
            P *= 2;
        }
        return P + h(fieldType, obj);
    }

    static int h(WireFormat.FieldType fieldType, Object obj) {
        switch (a.f13360b[fieldType.ordinal()]) {
            case 1:
                return CodedOutputStream.k(((Double) obj).doubleValue());
            case 2:
                return CodedOutputStream.s(((Float) obj).floatValue());
            case 3:
                return CodedOutputStream.y(((Long) obj).longValue());
            case 4:
                return CodedOutputStream.T(((Long) obj).longValue());
            case 5:
                return CodedOutputStream.w(((Integer) obj).intValue());
            case 6:
                return CodedOutputStream.q(((Long) obj).longValue());
            case 7:
                return CodedOutputStream.o(((Integer) obj).intValue());
            case 8:
                return CodedOutputStream.f(((Boolean) obj).booleanValue());
            case 9:
                return CodedOutputStream.u((e0) obj);
            case 10:
                if (obj instanceof v) {
                    return CodedOutputStream.B((v) obj);
                }
                return CodedOutputStream.F((e0) obj);
            case 11:
                if (obj instanceof ByteString) {
                    return CodedOutputStream.i((ByteString) obj);
                }
                return CodedOutputStream.O((String) obj);
            case 12:
                if (obj instanceof ByteString) {
                    return CodedOutputStream.i((ByteString) obj);
                }
                return CodedOutputStream.g((byte[]) obj);
            case 13:
                return CodedOutputStream.R(((Integer) obj).intValue());
            case 14:
                return CodedOutputStream.J(((Integer) obj).intValue());
            case 15:
                return CodedOutputStream.K(((Long) obj).longValue());
            case 16:
                return CodedOutputStream.L(((Integer) obj).intValue());
            case 17:
                return CodedOutputStream.M(((Long) obj).longValue());
            case 18:
                if (obj instanceof u.a) {
                    return CodedOutputStream.m(((u.a) obj).getNumber());
                }
                return CodedOutputStream.m(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int i(b<?> bVar, Object obj) {
        WireFormat.FieldType p10 = bVar.p();
        int number = bVar.getNumber();
        if (!bVar.o()) {
            return g(p10, number, obj);
        }
        int i10 = 0;
        if (bVar.t()) {
            for (Object obj2 : (List) obj) {
                i10 += h(p10, obj2);
            }
            return CodedOutputStream.P(number) + i10 + CodedOutputStream.I(i10);
        }
        for (Object obj3 : (List) obj) {
            i10 += g(p10, number, obj3);
        }
        return i10;
    }

    public static <T extends b<T>> t<T> j() {
        return f13355d;
    }

    private int n(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType key = entry.getKey();
        Object value = entry.getValue();
        if (key.s() != WireFormat.JavaType.MESSAGE || key.o() || key.t()) {
            return i(key, value);
        }
        if (value instanceof v) {
            return CodedOutputStream.z(entry.getKey().getNumber(), (v) value);
        }
        return CodedOutputStream.D(entry.getKey().getNumber(), (e0) value);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int r(WireFormat.FieldType fieldType, boolean z10) {
        if (z10) {
            return 2;
        }
        return fieldType.getWireType();
    }

    private boolean v(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType key = entry.getKey();
        if (key.s() == WireFormat.JavaType.MESSAGE) {
            if (key.o()) {
                for (e0 e0Var : (List) entry.getValue()) {
                    if (!e0Var.isInitialized()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof e0) {
                    if (!((e0) value).isInitialized()) {
                        return false;
                    }
                } else if (value instanceof v) {
                    return true;
                } else {
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    private void z(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof v) {
            value = ((v) value).g();
        }
        if (key.o()) {
            Object l10 = l(key);
            if (l10 == null) {
                l10 = new ArrayList();
            }
            for (Object obj : (List) value) {
                ((List) l10).add(f(obj));
            }
            this.f13356a.put(key, l10);
        } else if (key.s() == WireFormat.JavaType.MESSAGE) {
            Object l11 = l(key);
            if (l11 == null) {
                this.f13356a.put(key, f(value));
                return;
            }
            this.f13356a.put(key, key.r(((e0) l11).toBuilder(), (e0) value).build());
        } else {
            this.f13356a.put(key, f(value));
        }
    }

    public void C(FieldDescriptorType fielddescriptortype, Object obj) {
        if (!fielddescriptortype.o()) {
            E(fielddescriptortype.p(), obj);
        } else if (obj instanceof List) {
            ArrayList<Object> arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            for (Object obj2 : arrayList) {
                E(fielddescriptortype.p(), obj2);
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof v) {
            this.f13358c = true;
        }
        this.f13356a.put(fielddescriptortype, obj);
    }

    public void D(FieldDescriptorType fielddescriptortype, int i10, Object obj) {
        if (fielddescriptortype.o()) {
            Object l10 = l(fielddescriptortype);
            if (l10 != null) {
                E(fielddescriptortype.p(), obj);
                ((List) l10).set(i10, obj);
                return;
            }
            throw new IndexOutOfBoundsException();
        }
        throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    }

    public void I(CodedOutputStream codedOutputStream) throws IOException {
        for (int i10 = 0; i10 < this.f13356a.j(); i10++) {
            J(this.f13356a.i(i10), codedOutputStream);
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : this.f13356a.l()) {
            J(entry, codedOutputStream);
        }
    }

    public void K(CodedOutputStream codedOutputStream) throws IOException {
        for (int i10 = 0; i10 < this.f13356a.j(); i10++) {
            Map.Entry<FieldDescriptorType, Object> i11 = this.f13356a.i(i10);
            H(i11.getKey(), i11.getValue(), codedOutputStream);
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : this.f13356a.l()) {
            H(entry.getKey(), entry.getValue(), codedOutputStream);
        }
    }

    public void a(FieldDescriptorType fielddescriptortype, Object obj) {
        List list;
        if (fielddescriptortype.o()) {
            E(fielddescriptortype.p(), obj);
            Object l10 = l(fielddescriptortype);
            if (l10 == null) {
                list = new ArrayList();
                this.f13356a.put(fielddescriptortype, list);
            } else {
                list = (List) l10;
            }
            list.add(obj);
            return;
        }
        throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
    }

    public void b() {
        this.f13356a.clear();
        this.f13358c = false;
    }

    public void c(FieldDescriptorType fielddescriptortype) {
        this.f13356a.remove(fielddescriptortype);
        if (this.f13356a.isEmpty()) {
            this.f13358c = false;
        }
    }

    /* renamed from: d */
    public t<FieldDescriptorType> clone() {
        t<FieldDescriptorType> A = A();
        for (int i10 = 0; i10 < this.f13356a.j(); i10++) {
            Map.Entry<FieldDescriptorType, Object> i11 = this.f13356a.i(i10);
            A.C(i11.getKey(), i11.getValue());
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : this.f13356a.l()) {
            A.C(entry.getKey(), entry.getValue());
        }
        A.f13358c = this.f13358c;
        return A;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t)) {
            return false;
        }
        return this.f13356a.equals(((t) obj).f13356a);
    }

    public int hashCode() {
        return this.f13356a.hashCode();
    }

    public Map<FieldDescriptorType, Object> k() {
        if (!this.f13358c) {
            return this.f13356a.n() ? this.f13356a : Collections.unmodifiableMap(this.f13356a);
        }
        r0 p10 = r0.p(16);
        for (int i10 = 0; i10 < this.f13356a.j(); i10++) {
            e(p10, this.f13356a.i(i10));
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : this.f13356a.l()) {
            e(p10, entry);
        }
        if (this.f13356a.n()) {
            p10.o();
        }
        return p10;
    }

    public Object l(FieldDescriptorType fielddescriptortype) {
        Object obj = this.f13356a.get(fielddescriptortype);
        return obj instanceof v ? ((v) obj).g() : obj;
    }

    public int m() {
        int i10 = 0;
        for (int i11 = 0; i11 < this.f13356a.j(); i11++) {
            i10 += n(this.f13356a.i(i11));
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : this.f13356a.l()) {
            i10 += n(entry);
        }
        return i10;
    }

    public Object o(FieldDescriptorType fielddescriptortype, int i10) {
        if (fielddescriptortype.o()) {
            Object l10 = l(fielddescriptortype);
            if (l10 != null) {
                return ((List) l10).get(i10);
            }
            throw new IndexOutOfBoundsException();
        }
        throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    }

    public int p(FieldDescriptorType fielddescriptortype) {
        if (fielddescriptortype.o()) {
            Object l10 = l(fielddescriptortype);
            if (l10 == null) {
                return 0;
            }
            return ((List) l10).size();
        }
        throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    }

    public int q() {
        int i10 = 0;
        for (int i11 = 0; i11 < this.f13356a.j(); i11++) {
            Map.Entry<FieldDescriptorType, Object> i12 = this.f13356a.i(i11);
            i10 += i(i12.getKey(), i12.getValue());
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : this.f13356a.l()) {
            i10 += i(entry.getKey(), entry.getValue());
        }
        return i10;
    }

    public boolean s(FieldDescriptorType fielddescriptortype) {
        if (!fielddescriptortype.o()) {
            return this.f13356a.get(fielddescriptortype) != null;
        }
        throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
    }

    public boolean t() {
        return this.f13357b;
    }

    public boolean u() {
        for (int i10 = 0; i10 < this.f13356a.j(); i10++) {
            if (!v(this.f13356a.i(i10))) {
                return false;
            }
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : this.f13356a.l()) {
            if (!v(entry)) {
                return false;
            }
        }
        return true;
    }

    public Iterator<Map.Entry<FieldDescriptorType, Object>> w() {
        if (this.f13358c) {
            return new v.c(this.f13356a.entrySet().iterator());
        }
        return this.f13356a.entrySet().iterator();
    }

    public void x() {
        if (!this.f13357b) {
            this.f13356a.o();
            this.f13357b = true;
        }
    }

    public void y(t<FieldDescriptorType> tVar) {
        for (int i10 = 0; i10 < tVar.f13356a.j(); i10++) {
            z(tVar.f13356a.i(i10));
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : tVar.f13356a.l()) {
            z(entry);
        }
    }

    private t(boolean z10) {
        x();
    }
}
