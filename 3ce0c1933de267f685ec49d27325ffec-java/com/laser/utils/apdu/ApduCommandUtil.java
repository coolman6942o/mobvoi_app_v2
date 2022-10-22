package com.laser.utils.apdu;

import java.io.Serializable;
/* loaded from: classes2.dex */
public final class ApduCommandUtil implements Serializable {
    private static final long serialVersionUID = 1;

    private static byte[] a(byte b10, byte b11, byte b12, byte b13) {
        return new byte[]{b10, b11, b12, b13};
    }

    public static final byte[] generateAPDU(byte b10, byte b11, byte b12, byte b13) throws GenerateAPDUException {
        try {
            return a(b10, b11, b12, b13);
        } catch (Exception e10) {
            throw new GenerateAPDUException("case 1: error!", e10);
        }
    }

    public static final byte[] generateAPDU(byte b10, byte b11, byte b12, byte b13, byte b14) throws GenerateAPDUException {
        try {
            byte[] bArr = new byte[5];
            System.arraycopy(a(b10, b11, b12, b13), 0, bArr, 0, 4);
            bArr[4] = b14;
            return bArr;
        } catch (Exception e10) {
            throw new GenerateAPDUException("case 2: error!", e10);
        }
    }

    public static final byte[] generateAPDU(byte b10, byte b11, byte b12, byte b13, byte[] bArr) throws GenerateAPDUException {
        try {
            byte[] a10 = a(b10, b11, b12, b13);
            if (bArr == null || bArr.length == 0) {
                return a10;
            }
            byte[] bArr2 = new byte[bArr.length + 5];
            bArr2[4] = (byte) bArr.length;
            System.arraycopy(a10, 0, bArr2, 0, 4);
            System.arraycopy(bArr, 0, bArr2, 5, bArr.length);
            return bArr2;
        } catch (Exception e10) {
            throw new GenerateAPDUException("case 3: error!", e10);
        }
    }

    public static final byte[] generateAPDU(byte b10, byte b11, byte b12, byte b13, byte[] bArr, int i10, int i11) throws GenerateAPDUException {
        try {
            byte[] a10 = a(b10, b11, b12, b13);
            if (bArr == null || bArr.length == 0) {
                return a10;
            }
            byte[] bArr2 = new byte[i11 + 5];
            bArr2[4] = (byte) i11;
            System.arraycopy(a10, 0, bArr2, 0, 4);
            System.arraycopy(bArr, i10, bArr2, 5, i11);
            return bArr2;
        } catch (Exception e10) {
            throw new GenerateAPDUException("case 3: error!", e10);
        }
    }

    public static final byte[] generateAPDU(byte b10, byte b11, byte b12, byte b13, byte[] bArr, byte b14) throws GenerateAPDUException {
        try {
            byte[] a10 = a(b10, b11, b12, b13);
            byte[] bArr2 = new byte[bArr.length + 6];
            bArr2[4] = (byte) bArr.length;
            System.arraycopy(a10, 0, bArr2, 0, 4);
            System.arraycopy(bArr, 0, bArr2, 5, bArr.length);
            bArr2[bArr.length + 5] = b14;
            return bArr2;
        } catch (Exception e10) {
            throw new GenerateAPDUException("case 4: error!", e10);
        }
    }

    public static final byte[] generateAPDU(byte b10, byte b11, byte b12, byte b13, byte[] bArr, int i10, int i11, byte b14) throws GenerateAPDUException {
        try {
            byte[] a10 = a(b10, b11, b12, b13);
            byte[] bArr2 = new byte[i11 + 6];
            bArr2[4] = (byte) i11;
            System.arraycopy(a10, 0, bArr2, 0, 4);
            System.arraycopy(bArr, i10, bArr2, 5, i11);
            bArr2[i11 + 5] = b14;
            return bArr2;
        } catch (Exception e10) {
            throw new GenerateAPDUException("case 4: error!", e10);
        }
    }
}
