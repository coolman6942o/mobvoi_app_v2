package com.unionpay.mobile.android.model;
/* loaded from: classes2.dex */
public final class a implements c {

    /* renamed from: a  reason: collision with root package name */
    private int f23485a;

    /* renamed from: b  reason: collision with root package name */
    private int f23486b;

    /* renamed from: c  reason: collision with root package name */
    private String f23487c;

    /* renamed from: d  reason: collision with root package name */
    private String f23488d;

    /* renamed from: e  reason: collision with root package name */
    private String f23489e;

    /* renamed from: f  reason: collision with root package name */
    private String f23490f;

    public a() {
        this.f23485a = 2;
        this.f23486b = 0;
        this.f23487c = null;
        this.f23488d = null;
        this.f23489e = null;
        this.f23487c = null;
        this.f23488d = null;
        this.f23489e = null;
    }

    public a(int i10, String str, String str2, String str3, int i11) {
        this.f23485a = 2;
        this.f23486b = 0;
        this.f23487c = null;
        this.f23488d = null;
        this.f23489e = null;
        this.f23486b = i10;
        this.f23485a = i11;
        this.f23487c = str;
        this.f23488d = str2;
        this.f23489e = str3;
    }

    private a(String str, String str2, String str3) {
        this(0, str, str2, str3, 2);
    }

    public a(String str, String str2, String str3, byte b10) {
        this(str, str2, str3);
    }

    @Override // com.unionpay.mobile.android.model.c
    public final String a() {
        return this.f23487c;
    }

    @Override // com.unionpay.mobile.android.model.c
    public final void a(String str) {
        this.f23490f = str;
    }

    @Override // com.unionpay.mobile.android.model.c
    public final String b() {
        return this.f23489e;
    }

    @Override // com.unionpay.mobile.android.model.c
    public final int c() {
        return this.f23486b;
    }

    @Override // com.unionpay.mobile.android.model.c
    public final int d() {
        return this.f23485a;
    }

    @Override // com.unionpay.mobile.android.model.c
    public final String e() {
        return this.f23486b == 0 ? this.f23488d : String.format("<font color=\"#FF0000\">%s</font>", this.f23490f);
    }

    public final String toString() {
        return this.f23487c + "," + this.f23488d + "," + this.f23489e;
    }
}
