package vl;

import android.content.Context;
import il.b;
import java.io.IOException;
import java.nio.BufferUnderflowException;
import java.util.Locale;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f35828a;

    /* renamed from: b  reason: collision with root package name */
    public String f35829b;

    /* renamed from: c  reason: collision with root package name */
    public int f35830c;

    /* renamed from: d  reason: collision with root package name */
    public int f35831d;

    /* renamed from: e  reason: collision with root package name */
    public long f35832e;

    /* renamed from: f  reason: collision with root package name */
    public int f35833f;

    /* renamed from: g  reason: collision with root package name */
    public int f35834g;

    /* renamed from: h  reason: collision with root package name */
    public int f35835h;

    /* renamed from: i  reason: collision with root package name */
    public int f35836i;

    /* renamed from: j  reason: collision with root package name */
    public int f35837j;

    /* renamed from: k  reason: collision with root package name */
    public byte[] f35838k;

    public a(int i10, int i11, String str, int i12, int i13, long j10, int i14, int i15, int i16) {
        this.f35828a = i10;
        this.f35829b = str;
        this.f35830c = i12;
        this.f35831d = i13;
        this.f35832e = j10;
        this.f35833f = i14;
        this.f35834g = i15;
        this.f35835h = i16;
    }

    public static a c(int i10, String str, int i11, int i12, long j10, byte[] bArr) {
        a aVar = new a(i10, 0, str, i11, i12, j10, ((bArr[3] << 24) & (-16777216)) | ((bArr[2] << 16) & 16711680) | ((bArr[1] << 8) & 65280) | (bArr[0] & 255), ((bArr[7] << 24) & (-16777216)) | ((bArr[6] << 16) & 16711680) | ((bArr[5] << 8) & 65280) | (bArr[4] & 255), 0);
        aVar.a();
        return aVar;
    }

    public static a d(Context context, int i10, String str, int i11, int i12, long j10, byte[] bArr) {
        a aVar = new a(i10, 1, str, i11, i12, j10, ((bArr[3] << 24) & (-16777216)) | ((bArr[2] << 16) & 16711680) | ((bArr[1] << 8) & 65280) | (bArr[0] & 255), ((bArr[7] << 24) & (-16777216)) | ((bArr[6] << 16) & 16711680) | ((bArr[5] << 8) & 65280) | (bArr[4] & 255), 0);
        aVar.b(context);
        b.j(aVar.toString());
        return aVar;
    }

    public final void a() {
        wl.a f10 = f(this.f35828a);
        if (f10 != null) {
            f10.h0();
            f10.T();
            this.f35836i = f10.w();
            this.f35837j = f10.O();
            this.f35838k = f10.W();
            try {
                f10.close();
            } catch (Exception unused) {
            }
        }
    }

    public final void b(Context context) {
        try {
            wl.a e10 = e(context, this.f35828a);
            if (e10 != null) {
                e10.h0();
                e10.T();
                this.f35836i = e10.w();
                this.f35837j = e10.O();
                this.f35838k = e10.W();
                e10.close();
            }
        } catch (IOException | BufferUnderflowException e11) {
            b.l(e11.toString());
        }
    }

    public wl.a e(Context context, int i10) {
        try {
            wl.a k10 = zl.a.k(context, i10, this.f35829b, this.f35832e);
            if (k10 != null) {
                k10.r0(this.f35838k);
            }
            return k10;
        } catch (Exception e10) {
            b.l(e10.toString());
            return null;
        }
    }

    public wl.a f(int i10) {
        try {
            wl.a l10 = zl.a.l(i10, this.f35829b, this.f35832e);
            if (l10 != null) {
                l10.r0(this.f35838k);
            }
            return l10;
        } catch (Exception e10) {
            b.l(e10.toString());
            return null;
        }
    }

    public int g() {
        int i10 = this.f35831d;
        return i10 == 0 ? this.f35830c : this.f35830c % i10;
    }

    public String toString() {
        return String.format(Locale.US, "icType=0x%02X, bitNumber=%d(%d）, binId=0x%04X, imageId=0x%04X, startAddr=%d, downloadAddr=0x%08x, size(include mp header+data)=0x%08x(%d), reserved=%d", Integer.valueOf(this.f35828a), Integer.valueOf(this.f35830c), Integer.valueOf(this.f35831d), Integer.valueOf(this.f35836i), Integer.valueOf(this.f35837j), Long.valueOf(this.f35832e), Integer.valueOf(this.f35833f), Integer.valueOf(this.f35834g), Integer.valueOf(this.f35834g), Integer.valueOf(this.f35835h));
    }
}
