package com.google.android.gms.common.server.response;

import android.os.Parcel;
import b6.h;
import b6.i;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.server.converter.zaa;
import com.mobvoi.wear.lpa.LpaConstants;
import com.mobvoi.wear.twappstore.WearableAppXmlParser;
import h6.c;
import h6.l;
import h6.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public abstract class FastJsonResponse {

    /* loaded from: classes.dex */
    public interface a<I, O> {
        I h(O o10);
    }

    private static void f(StringBuilder sb2, Field field, Object obj) {
        int i10 = field.f8994b;
        if (i10 == 11) {
            sb2.append(field.f9000h.cast(obj).toString());
        } else if (i10 == 7) {
            sb2.append("\"");
            sb2.append(l.a((String) obj));
            sb2.append("\"");
        } else {
            sb2.append(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public static <O, I> I g(Field<I, O> field, Object obj) {
        return ((Field) field).f9003k != null ? field.h(obj) : obj;
    }

    public abstract Map<String, Field<?, ?>> a();

    /* JADX INFO: Access modifiers changed from: protected */
    public Object b(Field field) {
        String str = field.f8998f;
        if (field.f9000h == null) {
            return c(str);
        }
        i.p(c(str) == null, "Concrete field shouldn't be value object: %s", field.f8998f);
        try {
            char upperCase = Character.toUpperCase(str.charAt(0));
            String substring = str.substring(1);
            StringBuilder sb2 = new StringBuilder(String.valueOf(substring).length() + 4);
            sb2.append("get");
            sb2.append(upperCase);
            sb2.append(substring);
            return getClass().getMethod(sb2.toString(), new Class[0]).invoke(this, new Object[0]);
        } catch (Exception e10) {
            throw new RuntimeException(e10);
        }
    }

    protected abstract Object c(String str);

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean d(Field field) {
        if (field.f8996d != 11) {
            return e(field.f8998f);
        }
        if (field.f8997e) {
            throw new UnsupportedOperationException("Concrete type arrays not supported");
        }
        throw new UnsupportedOperationException("Concrete types not supported");
    }

    protected abstract boolean e(String str);

    public String toString() {
        Map<String, Field<?, ?>> a10 = a();
        StringBuilder sb2 = new StringBuilder(100);
        for (String str : a10.keySet()) {
            Field<?, ?> field = a10.get(str);
            if (d(field)) {
                Object g10 = g(field, b(field));
                if (sb2.length() == 0) {
                    sb2.append("{");
                } else {
                    sb2.append(",");
                }
                sb2.append("\"");
                sb2.append(str);
                sb2.append("\":");
                if (g10 != null) {
                    switch (field.f8996d) {
                        case 8:
                            sb2.append("\"");
                            sb2.append(c.a((byte[]) g10));
                            sb2.append("\"");
                            continue;
                        case 9:
                            sb2.append("\"");
                            sb2.append(c.b((byte[]) g10));
                            sb2.append("\"");
                            continue;
                        case 10:
                            m.a(sb2, (HashMap) g10);
                            continue;
                        default:
                            if (!field.f8995c) {
                                f(sb2, field, g10);
                                break;
                            } else {
                                ArrayList arrayList = (ArrayList) g10;
                                sb2.append("[");
                                int size = arrayList.size();
                                for (int i10 = 0; i10 < size; i10++) {
                                    if (i10 > 0) {
                                        sb2.append(",");
                                    }
                                    Object obj = arrayList.get(i10);
                                    if (obj != null) {
                                        f(sb2, field, obj);
                                    }
                                }
                                sb2.append("]");
                                continue;
                            }
                    }
                } else {
                    sb2.append(LpaConstants.VALUE_NULL);
                }
            }
        }
        if (sb2.length() > 0) {
            sb2.append("}");
        } else {
            sb2.append("{}");
        }
        return sb2.toString();
    }

    /* loaded from: classes.dex */
    public static class Field<I, O> extends AbstractSafeParcelable {
        public static final com.google.android.gms.common.server.response.a CREATOR = new com.google.android.gms.common.server.response.a();

        /* renamed from: a  reason: collision with root package name */
        private final int f8993a;

        /* renamed from: b  reason: collision with root package name */
        protected final int f8994b;

        /* renamed from: c  reason: collision with root package name */
        protected final boolean f8995c;

        /* renamed from: d  reason: collision with root package name */
        protected final int f8996d;

        /* renamed from: e  reason: collision with root package name */
        protected final boolean f8997e;

        /* renamed from: f  reason: collision with root package name */
        protected final String f8998f;

        /* renamed from: g  reason: collision with root package name */
        protected final int f8999g;

        /* renamed from: h  reason: collision with root package name */
        protected final Class<? extends FastJsonResponse> f9000h;

        /* renamed from: i  reason: collision with root package name */
        private final String f9001i;

        /* renamed from: j  reason: collision with root package name */
        private zak f9002j;

        /* renamed from: k  reason: collision with root package name */
        private a<I, O> f9003k;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Field(int i10, int i11, boolean z10, int i12, boolean z11, String str, int i13, String str2, zaa zaaVar) {
            this.f8993a = i10;
            this.f8994b = i11;
            this.f8995c = z10;
            this.f8996d = i12;
            this.f8997e = z11;
            this.f8998f = str;
            this.f8999g = i13;
            if (str2 == null) {
                this.f9000h = null;
                this.f9001i = null;
            } else {
                this.f9000h = SafeParcelResponse.class;
                this.f9001i = str2;
            }
            if (zaaVar == null) {
                this.f9003k = null;
            } else {
                this.f9003k = (a<I, O>) zaaVar.H0();
            }
        }

        public static Field<byte[], byte[]> G0(String str, int i10) {
            return new Field<>(8, false, 8, false, str, i10, null, null);
        }

        public static <T extends FastJsonResponse> Field<T, T> H0(String str, int i10, Class<T> cls) {
            return new Field<>(11, false, 11, false, str, i10, cls, null);
        }

        public static <T extends FastJsonResponse> Field<ArrayList<T>, ArrayList<T>> I0(String str, int i10, Class<T> cls) {
            return new Field<>(11, true, 11, true, str, i10, cls, null);
        }

        public static Field<Integer, Integer> J0(String str, int i10) {
            return new Field<>(0, false, 0, false, str, i10, null, null);
        }

        public static Field<String, String> K0(String str, int i10) {
            return new Field<>(7, false, 7, false, str, i10, null, null);
        }

        public static Field<ArrayList<String>, ArrayList<String>> L0(String str, int i10) {
            return new Field<>(7, true, 7, true, str, i10, null, null);
        }

        private final String P0() {
            String str = this.f9001i;
            if (str == null) {
                return null;
            }
            return str;
        }

        private final zaa R0() {
            a<I, O> aVar = this.f9003k;
            if (aVar == null) {
                return null;
            }
            return zaa.G0(aVar);
        }

        public int M0() {
            return this.f8999g;
        }

        public final void O0(zak zakVar) {
            this.f9002j = zakVar;
        }

        public final boolean Q0() {
            return this.f9003k != null;
        }

        public final Map<String, Field<?, ?>> S0() {
            i.k(this.f9001i);
            i.k(this.f9002j);
            return this.f9002j.I0(this.f9001i);
        }

        public final I h(O o10) {
            return this.f9003k.h(o10);
        }

        public String toString() {
            h.a a10 = h.c(this).a(WearableAppXmlParser.VERSION_CODE_TAG, Integer.valueOf(this.f8993a)).a("typeIn", Integer.valueOf(this.f8994b)).a("typeInArray", Boolean.valueOf(this.f8995c)).a("typeOut", Integer.valueOf(this.f8996d)).a("typeOutArray", Boolean.valueOf(this.f8997e)).a("outputFieldName", this.f8998f).a("safeParcelFieldId", Integer.valueOf(this.f8999g)).a("concreteTypeName", P0());
            Class<? extends FastJsonResponse> cls = this.f9000h;
            if (cls != null) {
                a10.a("concreteType.class", cls.getCanonicalName());
            }
            a<I, O> aVar = this.f9003k;
            if (aVar != null) {
                a10.a("converterName", aVar.getClass().getCanonicalName());
            }
            return a10.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            int a10 = c6.a.a(parcel);
            c6.a.l(parcel, 1, this.f8993a);
            c6.a.l(parcel, 2, this.f8994b);
            c6.a.c(parcel, 3, this.f8995c);
            c6.a.l(parcel, 4, this.f8996d);
            c6.a.c(parcel, 5, this.f8997e);
            c6.a.t(parcel, 6, this.f8998f, false);
            c6.a.l(parcel, 7, M0());
            c6.a.t(parcel, 8, P0(), false);
            c6.a.r(parcel, 9, R0(), i10, false);
            c6.a.b(parcel, a10);
        }

        private Field(int i10, boolean z10, int i11, boolean z11, String str, int i12, Class<? extends FastJsonResponse> cls, a<I, O> aVar) {
            this.f8993a = 1;
            this.f8994b = i10;
            this.f8995c = z10;
            this.f8996d = i11;
            this.f8997e = z11;
            this.f8998f = str;
            this.f8999g = i12;
            this.f9000h = cls;
            if (cls == null) {
                this.f9001i = null;
            } else {
                this.f9001i = cls.getCanonicalName();
            }
            this.f9003k = aVar;
        }
    }
}
