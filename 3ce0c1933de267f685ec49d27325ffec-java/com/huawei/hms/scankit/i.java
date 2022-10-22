package com.huawei.hms.scankit;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* compiled from: DecodeFormatManager.java */
/* loaded from: classes2.dex */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    public static final Set<BarcodeFormat> f14373a;

    /* renamed from: b  reason: collision with root package name */
    public static final Set<BarcodeFormat> f14374b;

    /* renamed from: c  reason: collision with root package name */
    public static final Set<BarcodeFormat> f14375c;

    /* renamed from: d  reason: collision with root package name */
    public static final Set<BarcodeFormat> f14376d;

    /* renamed from: e  reason: collision with root package name */
    public static final Set<BarcodeFormat> f14377e;

    /* renamed from: f  reason: collision with root package name */
    public static final Set<BarcodeFormat> f14378f;

    /* renamed from: g  reason: collision with root package name */
    public static final Set<BarcodeFormat> f14379g;

    /* renamed from: h  reason: collision with root package name */
    private static final Map<String, Set<BarcodeFormat>> f14380h;

    static {
        EnumSet of2 = EnumSet.of(BarcodeFormat.QR_CODE);
        f14376d = of2;
        EnumSet of3 = EnumSet.of(BarcodeFormat.DATA_MATRIX);
        f14377e = of3;
        EnumSet of4 = EnumSet.of(BarcodeFormat.AZTEC);
        f14378f = of4;
        EnumSet of5 = EnumSet.of(BarcodeFormat.PDF_417);
        f14379g = of5;
        EnumSet of6 = EnumSet.of(BarcodeFormat.UPC_A, BarcodeFormat.UPC_E, BarcodeFormat.EAN_13, BarcodeFormat.EAN_8);
        f14373a = of6;
        EnumSet of7 = EnumSet.of(BarcodeFormat.CODE_39, BarcodeFormat.CODE_93, BarcodeFormat.CODE_128, BarcodeFormat.ITF, BarcodeFormat.CODABAR);
        f14374b = of7;
        EnumSet copyOf = EnumSet.copyOf((Collection) of6);
        f14375c = copyOf;
        copyOf.addAll(of7);
        HashMap hashMap = new HashMap();
        f14380h = hashMap;
        hashMap.put("ONE_D_MODE", copyOf);
        hashMap.put("PRODUCT_MODE", of6);
        hashMap.put("QR_CODE_MODE", of2);
        hashMap.put("DATA_MATRIX_MODE", of3);
        hashMap.put("AZTEC_MODE", of4);
        hashMap.put("PDF417_MODE", of5);
    }
}
