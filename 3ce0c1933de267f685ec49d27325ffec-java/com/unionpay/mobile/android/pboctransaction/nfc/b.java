package com.unionpay.mobile.android.pboctransaction.nfc;

import android.nfc.tech.IsoDep;
import android.util.Log;
import java.nio.ByteBuffer;
import java.util.Arrays;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f23782a = {0};

    /* renamed from: b  reason: collision with root package name */
    protected byte[] f23783b;

    /* loaded from: classes2.dex */
    public static final class a extends b {

        /* renamed from: c  reason: collision with root package name */
        public static final byte[] f23784c = new byte[0];

        /* renamed from: d  reason: collision with root package name */
        public static final byte[] f23785d = {111, 0};

        public a(byte[] bArr) {
            super((bArr == null || bArr.length < 2) ? f23785d : bArr);
        }

        @Override // com.unionpay.mobile.android.pboctransaction.nfc.b
        public final byte[] a() {
            if (!b()) {
                return f23784c;
            }
            byte[] bArr = this.f23783b;
            return Arrays.copyOfRange(bArr, 0, bArr.length - 2);
        }

        public final boolean b() {
            byte[] bArr = this.f23783b;
            int length = bArr.length;
            return ((short) ((bArr[length - 1] & 255) | (bArr[length + (-2)] << 8))) == -28672;
        }
    }

    /* renamed from: com.unionpay.mobile.android.pboctransaction.nfc.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0264b {

        /* renamed from: a  reason: collision with root package name */
        private final IsoDep f23786a;

        public C0264b(IsoDep isoDep) {
            this.f23786a = isoDep;
        }

        public static String c(byte[] bArr) {
            String str = "";
            for (byte b10 : bArr) {
                String hexString = Integer.toHexString(b10 & 255);
                if (hexString.length() == 1) {
                    hexString = "0" + hexString;
                }
                str = str + hexString.toUpperCase() + " ";
            }
            return str;
        }

        public final a a(byte... bArr) {
            ByteBuffer allocate = ByteBuffer.allocate(bArr.length + 6);
            allocate.put((byte) 0).put((byte) -92).put((byte) 4).put((byte) 0).put((byte) bArr.length).put(bArr).put((byte) 0);
            Log.e("PBOC Transceive", c(allocate.array()));
            a aVar = new a(b(allocate.array()));
            Log.e("PBOC receive", c(aVar.a()));
            return aVar;
        }

        public final void a() {
            try {
                this.f23786a.connect();
            } catch (Exception unused) {
            }
        }

        public final byte[] b(byte[] bArr) {
            try {
                return this.f23786a.transceive(bArr);
            } catch (Exception unused) {
                return a.f23785d;
            }
        }
    }

    protected b(byte[] bArr) {
        this.f23783b = bArr == null ? f23782a : bArr;
    }

    public byte[] a() {
        return this.f23783b;
    }

    public String toString() {
        byte[] bArr = this.f23783b;
        return c.a(bArr, bArr.length);
    }
}
