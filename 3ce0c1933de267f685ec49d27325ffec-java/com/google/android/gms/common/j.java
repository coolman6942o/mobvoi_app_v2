package com.google.android.gms.common;

import android.os.RemoteException;
import android.util.Log;
import b6.i;
import com.google.android.gms.common.internal.x;
import com.google.android.gms.common.internal.y;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import k6.b;
import k6.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class j extends y {

    /* renamed from: a  reason: collision with root package name */
    private int f8972a;

    /* JADX INFO: Access modifiers changed from: protected */
    public j(byte[] bArr) {
        i.a(bArr.length == 25);
        this.f8972a = Arrays.hashCode(bArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static byte[] A2(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e10) {
            throw new AssertionError(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract byte[] U1();

    @Override // com.google.android.gms.common.internal.x
    public final b Y1() {
        return d.A2(U1());
    }

    public boolean equals(Object obj) {
        b Y1;
        if (obj != null && (obj instanceof x)) {
            try {
                x xVar = (x) obj;
                if (xVar.t2() == hashCode() && (Y1 = xVar.Y1()) != null) {
                    return Arrays.equals(U1(), (byte[]) d.U1(Y1));
                }
                return false;
            } catch (RemoteException e10) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e10);
            }
        }
        return false;
    }

    public int hashCode() {
        return this.f8972a;
    }

    @Override // com.google.android.gms.common.internal.x
    public final int t2() {
        return hashCode();
    }
}
