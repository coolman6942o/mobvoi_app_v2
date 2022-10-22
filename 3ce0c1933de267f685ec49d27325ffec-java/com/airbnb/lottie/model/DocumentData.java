package com.airbnb.lottie.model;
/* loaded from: classes.dex */
public class DocumentData {

    /* renamed from: a  reason: collision with root package name */
    public final String f6543a;

    /* renamed from: b  reason: collision with root package name */
    public final String f6544b;

    /* renamed from: c  reason: collision with root package name */
    public final float f6545c;

    /* renamed from: d  reason: collision with root package name */
    public final Justification f6546d;

    /* renamed from: e  reason: collision with root package name */
    public final int f6547e;

    /* renamed from: f  reason: collision with root package name */
    public final float f6548f;

    /* renamed from: g  reason: collision with root package name */
    public final float f6549g;

    /* renamed from: h  reason: collision with root package name */
    public final int f6550h;

    /* renamed from: i  reason: collision with root package name */
    public final int f6551i;

    /* renamed from: j  reason: collision with root package name */
    public final float f6552j;

    /* renamed from: k  reason: collision with root package name */
    public final boolean f6553k;

    /* loaded from: classes.dex */
    public enum Justification {
        LEFT_ALIGN,
        RIGHT_ALIGN,
        CENTER
    }

    public DocumentData(String str, String str2, float f10, Justification justification, int i10, float f11, float f12, int i11, int i12, float f13, boolean z10) {
        this.f6543a = str;
        this.f6544b = str2;
        this.f6545c = f10;
        this.f6546d = justification;
        this.f6547e = i10;
        this.f6548f = f11;
        this.f6549g = f12;
        this.f6550h = i11;
        this.f6551i = i12;
        this.f6552j = f13;
        this.f6553k = z10;
    }

    public int hashCode() {
        int hashCode = (((((int) ((((this.f6543a.hashCode() * 31) + this.f6544b.hashCode()) * 31) + this.f6545c)) * 31) + this.f6546d.ordinal()) * 31) + this.f6547e;
        long floatToRawIntBits = Float.floatToRawIntBits(this.f6548f);
        return (((hashCode * 31) + ((int) (floatToRawIntBits ^ (floatToRawIntBits >>> 32)))) * 31) + this.f6550h;
    }
}
