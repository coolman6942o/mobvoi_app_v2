package com.google.android.gms.common.server.response;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import b6.i;
import c6.a;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.server.response.FastJsonResponse;
import h6.b;
import h6.c;
import h6.l;
import h6.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class SafeParcelResponse extends FastSafeParcelableJsonResponse {
    public static final Parcelable.Creator<SafeParcelResponse> CREATOR = new e();

    /* renamed from: a  reason: collision with root package name */
    private final int f9004a;

    /* renamed from: b  reason: collision with root package name */
    private final Parcel f9005b;

    /* renamed from: c  reason: collision with root package name */
    private final int f9006c = 2;

    /* renamed from: d  reason: collision with root package name */
    private final zak f9007d;

    /* renamed from: e  reason: collision with root package name */
    private final String f9008e;

    /* renamed from: f  reason: collision with root package name */
    private int f9009f;

    /* renamed from: g  reason: collision with root package name */
    private int f9010g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SafeParcelResponse(int i10, Parcel parcel, zak zakVar) {
        this.f9004a = i10;
        this.f9005b = (Parcel) i.k(parcel);
        this.f9007d = zakVar;
        if (zakVar == null) {
            this.f9008e = null;
        } else {
            this.f9008e = zakVar.H0();
        }
        this.f9009f = 2;
    }

    private static void h(StringBuilder sb2, int i10, Object obj) {
        switch (i10) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                sb2.append(obj);
                return;
            case 7:
                sb2.append("\"");
                sb2.append(l.a(obj.toString()));
                sb2.append("\"");
                return;
            case 8:
                sb2.append("\"");
                sb2.append(c.a((byte[]) obj));
                sb2.append("\"");
                return;
            case 9:
                sb2.append("\"");
                sb2.append(c.b((byte[]) obj));
                sb2.append("\"");
                return;
            case 10:
                m.a(sb2, (HashMap) obj);
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                StringBuilder sb3 = new StringBuilder(26);
                sb3.append("Unknown type = ");
                sb3.append(i10);
                throw new IllegalArgumentException(sb3.toString());
        }
    }

    private final void i(StringBuilder sb2, Map<String, FastJsonResponse.Field<?, ?>> map, Parcel parcel) {
        SparseArray sparseArray = new SparseArray();
        for (Map.Entry<String, FastJsonResponse.Field<?, ?>> entry : map.entrySet()) {
            sparseArray.put(entry.getValue().M0(), entry);
        }
        sb2.append('{');
        int L = SafeParcelReader.L(parcel);
        boolean z10 = false;
        while (parcel.dataPosition() < L) {
            int B = SafeParcelReader.B(parcel);
            Map.Entry entry2 = (Map.Entry) sparseArray.get(SafeParcelReader.u(B));
            if (entry2 != null) {
                if (z10) {
                    sb2.append(",");
                }
                FastJsonResponse.Field<?, ?> field = (FastJsonResponse.Field) entry2.getValue();
                sb2.append("\"");
                sb2.append((String) entry2.getKey());
                sb2.append("\":");
                if (field.Q0()) {
                    switch (field.f8996d) {
                        case 0:
                            j(sb2, field, FastJsonResponse.g(field, Integer.valueOf(SafeParcelReader.D(parcel, B))));
                            break;
                        case 1:
                            j(sb2, field, FastJsonResponse.g(field, SafeParcelReader.c(parcel, B)));
                            break;
                        case 2:
                            j(sb2, field, FastJsonResponse.g(field, Long.valueOf(SafeParcelReader.G(parcel, B))));
                            break;
                        case 3:
                            j(sb2, field, FastJsonResponse.g(field, Float.valueOf(SafeParcelReader.z(parcel, B))));
                            break;
                        case 4:
                            j(sb2, field, FastJsonResponse.g(field, Double.valueOf(SafeParcelReader.x(parcel, B))));
                            break;
                        case 5:
                            j(sb2, field, FastJsonResponse.g(field, SafeParcelReader.a(parcel, B)));
                            break;
                        case 6:
                            j(sb2, field, FastJsonResponse.g(field, Boolean.valueOf(SafeParcelReader.v(parcel, B))));
                            break;
                        case 7:
                            j(sb2, field, FastJsonResponse.g(field, SafeParcelReader.o(parcel, B)));
                            break;
                        case 8:
                        case 9:
                            j(sb2, field, FastJsonResponse.g(field, SafeParcelReader.g(parcel, B)));
                            break;
                        case 10:
                            Bundle f10 = SafeParcelReader.f(parcel, B);
                            HashMap hashMap = new HashMap();
                            for (String str : f10.keySet()) {
                                hashMap.put(str, f10.getString(str));
                            }
                            j(sb2, field, FastJsonResponse.g(field, hashMap));
                            break;
                        case 11:
                            throw new IllegalArgumentException("Method does not accept concrete type.");
                        default:
                            int i10 = field.f8996d;
                            StringBuilder sb3 = new StringBuilder(36);
                            sb3.append("Unknown field out type = ");
                            sb3.append(i10);
                            throw new IllegalArgumentException(sb3.toString());
                    }
                } else if (field.f8997e) {
                    sb2.append("[");
                    switch (field.f8996d) {
                        case 0:
                            b.f(sb2, SafeParcelReader.j(parcel, B));
                            break;
                        case 1:
                            b.h(sb2, SafeParcelReader.d(parcel, B));
                            break;
                        case 2:
                            b.g(sb2, SafeParcelReader.k(parcel, B));
                            break;
                        case 3:
                            b.e(sb2, SafeParcelReader.i(parcel, B));
                            break;
                        case 4:
                            b.d(sb2, SafeParcelReader.h(parcel, B));
                            break;
                        case 5:
                            b.h(sb2, SafeParcelReader.b(parcel, B));
                            break;
                        case 6:
                            b.i(sb2, SafeParcelReader.e(parcel, B));
                            break;
                        case 7:
                            b.j(sb2, SafeParcelReader.p(parcel, B));
                            break;
                        case 8:
                        case 9:
                        case 10:
                            throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
                        case 11:
                            Parcel[] m10 = SafeParcelReader.m(parcel, B);
                            int length = m10.length;
                            for (int i11 = 0; i11 < length; i11++) {
                                if (i11 > 0) {
                                    sb2.append(",");
                                }
                                m10[i11].setDataPosition(0);
                                i(sb2, field.S0(), m10[i11]);
                            }
                            break;
                        default:
                            throw new IllegalStateException("Unknown field type out.");
                    }
                    sb2.append("]");
                } else {
                    switch (field.f8996d) {
                        case 0:
                            sb2.append(SafeParcelReader.D(parcel, B));
                            break;
                        case 1:
                            sb2.append(SafeParcelReader.c(parcel, B));
                            break;
                        case 2:
                            sb2.append(SafeParcelReader.G(parcel, B));
                            break;
                        case 3:
                            sb2.append(SafeParcelReader.z(parcel, B));
                            break;
                        case 4:
                            sb2.append(SafeParcelReader.x(parcel, B));
                            break;
                        case 5:
                            sb2.append(SafeParcelReader.a(parcel, B));
                            break;
                        case 6:
                            sb2.append(SafeParcelReader.v(parcel, B));
                            break;
                        case 7:
                            String o10 = SafeParcelReader.o(parcel, B);
                            sb2.append("\"");
                            sb2.append(l.a(o10));
                            sb2.append("\"");
                            break;
                        case 8:
                            byte[] g10 = SafeParcelReader.g(parcel, B);
                            sb2.append("\"");
                            sb2.append(c.a(g10));
                            sb2.append("\"");
                            break;
                        case 9:
                            byte[] g11 = SafeParcelReader.g(parcel, B);
                            sb2.append("\"");
                            sb2.append(c.b(g11));
                            sb2.append("\"");
                            break;
                        case 10:
                            Bundle f11 = SafeParcelReader.f(parcel, B);
                            Set<String> keySet = f11.keySet();
                            keySet.size();
                            sb2.append("{");
                            boolean z11 = true;
                            for (String str2 : keySet) {
                                if (!z11) {
                                    sb2.append(",");
                                }
                                sb2.append("\"");
                                sb2.append(str2);
                                sb2.append("\"");
                                sb2.append(":");
                                sb2.append("\"");
                                sb2.append(l.a(f11.getString(str2)));
                                sb2.append("\"");
                                z11 = false;
                            }
                            sb2.append("}");
                            break;
                        case 11:
                            Parcel l10 = SafeParcelReader.l(parcel, B);
                            l10.setDataPosition(0);
                            i(sb2, field.S0(), l10);
                            break;
                        default:
                            throw new IllegalStateException("Unknown field type out");
                    }
                }
                z10 = true;
            }
        }
        if (parcel.dataPosition() == L) {
            sb2.append('}');
            return;
        }
        StringBuilder sb4 = new StringBuilder(37);
        sb4.append("Overread allowed size end=");
        sb4.append(L);
        throw new SafeParcelReader.ParseException(sb4.toString(), parcel);
    }

    private final void j(StringBuilder sb2, FastJsonResponse.Field<?, ?> field, Object obj) {
        if (field.f8995c) {
            ArrayList arrayList = (ArrayList) obj;
            sb2.append("[");
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                if (i10 != 0) {
                    sb2.append(",");
                }
                h(sb2, field.f8994b, arrayList.get(i10));
            }
            sb2.append("]");
            return;
        }
        h(sb2, field.f8994b, obj);
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0005, code lost:
        if (r0 != 1) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Parcel k() {
        int i10 = this.f9009f;
        if (i10 == 0) {
            this.f9010g = a.a(this.f9005b);
        }
        a.b(this.f9005b, this.f9010g);
        this.f9009f = 2;
        return this.f9005b;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public Map<String, FastJsonResponse.Field<?, ?>> a() {
        zak zakVar = this.f9007d;
        if (zakVar == null) {
            return null;
        }
        return zakVar.I0(this.f9008e);
    }

    @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse, com.google.android.gms.common.server.response.FastJsonResponse
    public Object c(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse, com.google.android.gms.common.server.response.FastJsonResponse
    public boolean e(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public String toString() {
        i.l(this.f9007d, "Cannot convert to JSON on client side.");
        Parcel k10 = k();
        k10.setDataPosition(0);
        StringBuilder sb2 = new StringBuilder(100);
        i(sb2, this.f9007d.I0(this.f9008e), k10);
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        zak zakVar;
        int a10 = a.a(parcel);
        a.l(parcel, 1, this.f9004a);
        a.q(parcel, 2, k(), false);
        int i11 = this.f9006c;
        if (i11 == 0) {
            zakVar = null;
        } else if (i11 == 1) {
            zakVar = this.f9007d;
        } else if (i11 == 2) {
            zakVar = this.f9007d;
        } else {
            int i12 = this.f9006c;
            StringBuilder sb2 = new StringBuilder(34);
            sb2.append("Invalid creation type: ");
            sb2.append(i12);
            throw new IllegalStateException(sb2.toString());
        }
        a.r(parcel, 3, zakVar, i10, false);
        a.b(parcel, a10);
    }
}
