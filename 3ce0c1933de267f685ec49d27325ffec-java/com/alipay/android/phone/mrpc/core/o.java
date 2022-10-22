package com.alipay.android.phone.mrpc.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.Header;
/* loaded from: classes.dex */
public final class o extends t {

    /* renamed from: b  reason: collision with root package name */
    public String f6765b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f6766c;

    /* renamed from: g  reason: collision with root package name */
    public boolean f6770g;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<Header> f6768e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    public Map<String, String> f6769f = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    public String f6767d = "application/x-www-form-urlencoded";

    public o(String str) {
        this.f6765b = str;
    }

    public final String a() {
        return this.f6765b;
    }

    public final void a(String str) {
        this.f6767d = str;
    }

    public final void a(String str, String str2) {
        if (this.f6769f == null) {
            this.f6769f = new HashMap();
        }
        this.f6769f.put(str, str2);
    }

    public final void a(Header header) {
        this.f6768e.add(header);
    }

    public final void a(boolean z10) {
        this.f6770g = z10;
    }

    public final void a(byte[] bArr) {
        this.f6766c = bArr;
    }

    public final String b(String str) {
        Map<String, String> map = this.f6769f;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    public final byte[] b() {
        return this.f6766c;
    }

    public final String c() {
        return this.f6767d;
    }

    public final ArrayList<Header> d() {
        return this.f6768e;
    }

    public final boolean e() {
        return this.f6770g;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || o.class != obj.getClass()) {
            return false;
        }
        o oVar = (o) obj;
        byte[] bArr = this.f6766c;
        if (bArr == null) {
            if (oVar.f6766c != null) {
                return false;
            }
        } else if (!bArr.equals(oVar.f6766c)) {
            return false;
        }
        String str = this.f6765b;
        String str2 = oVar.f6765b;
        if (str == null) {
            if (str2 != null) {
                return false;
            }
        } else if (!str.equals(str2)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        Map<String, String> map = this.f6769f;
        int hashCode = ((map == null || !map.containsKey("id")) ? 1 : this.f6769f.get("id").hashCode() + 31) * 31;
        String str = this.f6765b;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        return String.format("Url : %s,HttpHeader: %s", this.f6765b, this.f6768e);
    }
}
