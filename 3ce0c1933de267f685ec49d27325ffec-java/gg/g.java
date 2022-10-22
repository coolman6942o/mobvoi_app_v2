package gg;

import java.util.Objects;
/* compiled from: McuUploadArtyDataInfo.java */
/* loaded from: classes2.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public long f27466a;

    /* renamed from: b  reason: collision with root package name */
    public int f27467b;

    /* renamed from: c  reason: collision with root package name */
    public int f27468c;

    /* renamed from: d  reason: collision with root package name */
    public int f27469d;

    /* renamed from: e  reason: collision with root package name */
    public int f27470e;

    /* renamed from: f  reason: collision with root package name */
    public int f27471f;

    /* renamed from: g  reason: collision with root package name */
    public int f27472g;

    /* renamed from: h  reason: collision with root package name */
    public int f27473h;

    /* renamed from: i  reason: collision with root package name */
    public int f27474i;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || g.class != obj.getClass()) {
            return false;
        }
        g gVar = (g) obj;
        return this.f27466a == gVar.f27466a && this.f27467b == gVar.f27467b && this.f27468c == gVar.f27468c && this.f27469d == gVar.f27469d && this.f27470e == gVar.f27470e && this.f27471f == gVar.f27471f && this.f27472g == gVar.f27472g && this.f27473h == gVar.f27473h && this.f27474i == gVar.f27474i;
    }

    public int hashCode() {
        return Objects.hash(Long.valueOf(this.f27466a), Integer.valueOf(this.f27467b), Integer.valueOf(this.f27468c), Integer.valueOf(this.f27469d), Integer.valueOf(this.f27470e), Integer.valueOf(this.f27471f), Integer.valueOf(this.f27472g), Integer.valueOf(this.f27473h), Integer.valueOf(this.f27474i));
    }

    public String toString() {
        return "ArtyDataInfo{time = " + this.f27466a + ", week = " + this.f27467b + ", score = " + this.f27468c + ", truHR = " + this.f27469d + ", eCAP = " + this.f27470e + ", hSX = " + this.f27471f + ", Age_min = " + this.f27472g + ", Age_max = " + this.f27473h + ", signal = " + this.f27474i + '}';
    }
}
