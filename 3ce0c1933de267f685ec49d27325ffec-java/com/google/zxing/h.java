package com.google.zxing;

import java.util.EnumMap;
import java.util.Map;
/* compiled from: Result.java */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    private final String f13447a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f13448b;

    /* renamed from: c  reason: collision with root package name */
    private i[] f13449c;

    /* renamed from: d  reason: collision with root package name */
    private final BarcodeFormat f13450d;

    /* renamed from: e  reason: collision with root package name */
    private Map<ResultMetadataType, Object> f13451e;

    public h(String str, byte[] bArr, i[] iVarArr, BarcodeFormat barcodeFormat) {
        this(str, bArr, iVarArr, barcodeFormat, System.currentTimeMillis());
    }

    public void a(i[] iVarArr) {
        i[] iVarArr2 = this.f13449c;
        if (iVarArr2 == null) {
            this.f13449c = iVarArr;
        } else if (iVarArr != null && iVarArr.length > 0) {
            i[] iVarArr3 = new i[iVarArr2.length + iVarArr.length];
            System.arraycopy(iVarArr2, 0, iVarArr3, 0, iVarArr2.length);
            System.arraycopy(iVarArr, 0, iVarArr3, iVarArr2.length, iVarArr.length);
            this.f13449c = iVarArr3;
        }
    }

    public BarcodeFormat b() {
        return this.f13450d;
    }

    public byte[] c() {
        return this.f13448b;
    }

    public Map<ResultMetadataType, Object> d() {
        return this.f13451e;
    }

    public i[] e() {
        return this.f13449c;
    }

    public String f() {
        return this.f13447a;
    }

    public void g(Map<ResultMetadataType, Object> map) {
        if (map != null) {
            Map<ResultMetadataType, Object> map2 = this.f13451e;
            if (map2 == null) {
                this.f13451e = map;
            } else {
                map2.putAll(map);
            }
        }
    }

    public void h(ResultMetadataType resultMetadataType, Object obj) {
        if (this.f13451e == null) {
            this.f13451e = new EnumMap(ResultMetadataType.class);
        }
        this.f13451e.put(resultMetadataType, obj);
    }

    public String toString() {
        return this.f13447a;
    }

    public h(String str, byte[] bArr, i[] iVarArr, BarcodeFormat barcodeFormat, long j10) {
        this(str, bArr, bArr == null ? 0 : bArr.length * 8, iVarArr, barcodeFormat, j10);
    }

    public h(String str, byte[] bArr, int i10, i[] iVarArr, BarcodeFormat barcodeFormat, long j10) {
        this.f13447a = str;
        this.f13448b = bArr;
        this.f13449c = iVarArr;
        this.f13450d = barcodeFormat;
        this.f13451e = null;
    }
}
