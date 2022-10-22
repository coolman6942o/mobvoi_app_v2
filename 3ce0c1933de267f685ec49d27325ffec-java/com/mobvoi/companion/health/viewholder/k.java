package com.mobvoi.companion.health.viewholder;

import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
/* compiled from: VpaCardEnum.kt */
/* loaded from: classes2.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    private final byte f17109a;

    /* renamed from: b  reason: collision with root package name */
    private final int f17110b;

    /* renamed from: c  reason: collision with root package name */
    private String f17111c;

    /* renamed from: d  reason: collision with root package name */
    private String f17112d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f17113e;

    public k(byte b10, int i10, String str, String str2, boolean z10) {
        this.f17109a = b10;
        this.f17110b = i10;
        this.f17111c = str;
        this.f17112d = str2;
        this.f17113e = z10;
    }

    public static /* synthetic */ k b(k kVar, byte b10, int i10, String str, String str2, boolean z10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            b10 = kVar.f17109a;
        }
        if ((i11 & 2) != 0) {
            i10 = kVar.f17110b;
        }
        int i12 = i10;
        if ((i11 & 4) != 0) {
            str = kVar.f17111c;
        }
        String str3 = str;
        if ((i11 & 8) != 0) {
            str2 = kVar.f17112d;
        }
        String str4 = str2;
        if ((i11 & 16) != 0) {
            z10 = kVar.f17113e;
        }
        return kVar.a(b10, i12, str3, str4, z10);
    }

    public final k a(byte b10, int i10, String str, String str2, boolean z10) {
        return new k(b10, i10, str, str2, z10);
    }

    public final String c() {
        return this.f17112d;
    }

    public final String d() {
        return this.f17111c;
    }

    public final int e() {
        return this.f17110b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return this.f17109a == kVar.f17109a && this.f17110b == kVar.f17110b && i.b(this.f17111c, kVar.f17111c) && i.b(this.f17112d, kVar.f17112d) && this.f17113e == kVar.f17113e;
    }

    public final boolean f() {
        return this.f17113e;
    }

    public final void g(String str) {
        this.f17112d = str;
    }

    public final void h(String str) {
        this.f17111c = str;
    }

    public int hashCode() {
        int i10 = ((this.f17109a * 31) + this.f17110b) * 31;
        String str = this.f17111c;
        int i11 = 0;
        int hashCode = (i10 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f17112d;
        if (str2 != null) {
            i11 = str2.hashCode();
        }
        int i12 = (hashCode + i11) * 31;
        boolean z10 = this.f17113e;
        if (z10) {
            z10 = true;
        }
        int i13 = z10 ? 1 : 0;
        int i14 = z10 ? 1 : 0;
        return i12 + i13;
    }

    public final void i(boolean z10) {
        this.f17113e = z10;
    }

    public String toString() {
        return "VPACard(type=" + ((int) this.f17109a) + ", cardNameStrRes=" + this.f17110b + ", cardDescStr=" + ((Object) this.f17111c) + ", card=" + ((Object) this.f17112d) + ", existed=" + this.f17113e + ')';
    }

    public /* synthetic */ k(byte b10, int i10, String str, String str2, boolean z10, int i11, f fVar) {
        this(b10, i10, (i11 & 4) != 0 ? null : str, (i11 & 8) != 0 ? null : str2, (i11 & 16) != 0 ? true : z10);
    }
}
