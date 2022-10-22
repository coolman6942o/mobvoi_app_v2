package com.huawei.hms.scankit.aiscan.common;

import java.util.List;
/* compiled from: DecoderResult.java */
/* renamed from: com.huawei.hms.scankit.aiscan.common.e  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0554e {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f14206a;

    /* renamed from: b  reason: collision with root package name */
    private int f14207b;

    /* renamed from: c  reason: collision with root package name */
    private final String f14208c;

    /* renamed from: d  reason: collision with root package name */
    private final List<byte[]> f14209d;

    /* renamed from: e  reason: collision with root package name */
    private final String f14210e;

    /* renamed from: f  reason: collision with root package name */
    private Integer f14211f;

    /* renamed from: g  reason: collision with root package name */
    private Integer f14212g;

    /* renamed from: h  reason: collision with root package name */
    private Object f14213h;

    /* renamed from: i  reason: collision with root package name */
    private final int f14214i;

    /* renamed from: j  reason: collision with root package name */
    private final int f14215j;

    public C0554e(byte[] bArr, String str, List<byte[]> list, String str2) {
        this(bArr, str, list, str2, -1, -1);
    }

    public int a() {
        return this.f14207b;
    }

    public void b(Integer num) {
        this.f14211f = num;
    }

    public byte[] c() {
        return this.f14206a;
    }

    public String d() {
        return this.f14208c;
    }

    public C0554e(byte[] bArr, String str, List<byte[]> list, String str2, int i10, int i11) {
        this.f14206a = bArr;
        this.f14207b = bArr == null ? 0 : bArr.length * 8;
        this.f14208c = str;
        this.f14209d = list;
        this.f14210e = str2;
        this.f14214i = i11;
        this.f14215j = i10;
    }

    public void a(int i10) {
        this.f14207b = i10;
    }

    public Object b() {
        return this.f14213h;
    }

    public void a(Integer num) {
        this.f14212g = num;
    }

    public void a(Object obj) {
        this.f14213h = obj;
    }
}
