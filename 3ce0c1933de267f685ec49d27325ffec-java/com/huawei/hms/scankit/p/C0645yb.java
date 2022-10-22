package com.huawei.hms.scankit.p;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.hmsscankit.WriterException;
import com.huawei.hms.hmsscankit.g;
import com.huawei.hms.ml.scan.HmsBuildBitmapOption;
import com.huawei.hms.ml.scan.HmsScanBase;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import com.huawei.hms.scankit.util.a;
import com.huawei.hms.scankit.util.b;
import java.util.Hashtable;
import java.util.Map;
/* compiled from: MultiFormatWriter.java */
/* renamed from: com.huawei.hms.scankit.p.yb  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0645yb implements AbstractC0648zb {
    @Override // com.huawei.hms.scankit.p.AbstractC0648zb
    public C0595i a(String str, BarcodeFormat barcodeFormat, int i10, int i11, Map<tc, ?> map) throws WriterException {
        AbstractC0648zb zbVar;
        switch (C0642xb.f15002a[barcodeFormat.ordinal()]) {
            case 1:
                zbVar = new C0570bc();
                break;
            case 2:
                zbVar = new C0590gc();
                break;
            case 3:
                zbVar = new C0566ac();
                break;
            case 4:
                zbVar = new C0582ec();
                break;
            case 5:
                zbVar = new qc();
                break;
            case 6:
                zbVar = new Zb();
                break;
            case 7:
                zbVar = new _b();
                break;
            case 8:
                zbVar = new Yb();
                break;
            case 9:
                zbVar = new C0574cc();
                break;
            case 10:
                zbVar = new C0594hc();
                break;
            case 11:
                zbVar = new Xb();
                break;
            case 12:
                zbVar = new Ib();
                break;
            case 13:
                zbVar = new Ab();
                break;
            default:
                throw new IllegalArgumentException("No encoder available for format " + barcodeFormat);
        }
        return zbVar.a(str, barcodeFormat, i10, i11, map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x012a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0211 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0212 A[Catch: Exception -> 0x01dc, IllegalArgumentException -> 0x01df, OutOfMemoryError -> 0x01e2, TryCatch #7 {OutOfMemoryError -> 0x01e2, blocks: (B:100:0x0126, B:103:0x012c, B:105:0x0130, B:107:0x014d, B:110:0x0154, B:114:0x01a7, B:116:0x01ab, B:118:0x01af, B:120:0x01b3, B:122:0x01b7, B:123:0x01c8, B:125:0x01ce, B:126:0x01d4, B:127:0x01d9, B:134:0x01e5, B:135:0x01e8, B:139:0x020b, B:142:0x0212, B:146:0x0224, B:148:0x022a, B:149:0x0230, B:150:0x0235, B:151:0x0238, B:152:0x023b), top: B:193:0x0126 }] */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0285  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x028a  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0115  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Bitmap a(String str, int i10, int i11, int i12, HmsBuildBitmapOption hmsBuildBitmapOption) throws WriterException {
        int i13;
        boolean z10;
        BarcodeFormat barcodeFormat;
        OutOfMemoryError e10;
        IllegalArgumentException e11;
        BarcodeFormat barcodeFormat2;
        Exception e12;
        BarcodeFormat barcodeFormat3;
        Bitmap bitmap;
        Bitmap bitmap2;
        C0595i a10;
        BarcodeFormat barcodeFormat4;
        BarcodeFormat barcodeFormat5;
        Bundle a11 = g.a(str, i10, i11, i12, hmsBuildBitmapOption);
        Bitmap bitmap3 = 0;
        r10 = 0;
        bitmap3 = 0;
        Bitmap bitmap4 = 0;
        Bitmap bitmap5 = 0;
        if (i11 <= 0 || i12 <= 0 || i11 > 5120 || i12 > 5120) {
            g.a(-1010, (Bitmap) null, a11);
            throw new WriterException("IllegalArgumentException:width & height should >0 & <5120");
        } else if (TextUtils.isEmpty(str)) {
            g.a(-1011, (Bitmap) null, a11);
            throw new WriterException("Content is empty");
        } else if (str.length() <= 2953) {
            int i14 = HmsScanBase.QRCODE_SCAN_TYPE;
            try {
                try {
                    try {
                        try {
                            if (i10 != i14) {
                                if (i10 == HmsScanBase.PDF417_SCAN_TYPE) {
                                    i13 = i11 / 30;
                                } else if (i10 == HmsScanBase.EAN13_SCAN_TYPE || i10 == HmsScanBase.EAN8_SCAN_TYPE || i10 == HmsScanBase.CODE39_SCAN_TYPE || i10 == HmsScanBase.CODE93_SCAN_TYPE || i10 == HmsScanBase.CODE128_SCAN_TYPE || i10 == HmsScanBase.CODABAR_SCAN_TYPE || i10 == HmsScanBase.ITF14_SCAN_TYPE || i10 == HmsScanBase.UPCCODE_A_SCAN_TYPE || i10 == HmsScanBase.UPCCODE_E_SCAN_TYPE) {
                                    i13 = 6;
                                }
                                int i15 = -16777216;
                                int i16 = -197381;
                                EnumC0647za zaVar = EnumC0647za.L;
                                String str2 = zaVar.toString();
                                if (hmsBuildBitmapOption != null) {
                                    int i17 = hmsBuildBitmapOption.margin;
                                    if (i17 != 1) {
                                        i13 = i17;
                                    }
                                    int i18 = hmsBuildBitmapOption.bimapColor;
                                    if (i18 != -1) {
                                        i15 = i18;
                                    }
                                    int i19 = hmsBuildBitmapOption.bitmapBackgroundColor;
                                    if (i19 != -1) {
                                        i16 = i19;
                                    }
                                    HmsBuildBitmapOption.ErrorCorrectionLevel errorCorrectionLevel = hmsBuildBitmapOption.QRErrorCorrection;
                                    str2 = errorCorrectionLevel == null ? zaVar.toString() : errorCorrectionLevel.value;
                                }
                                int i20 = i13;
                                int i21 = i16;
                                String str3 = str2;
                                int i22 = i15;
                                Hashtable hashtable = new Hashtable();
                                hashtable.put(tc.CHARACTER_SET, "utf-8");
                                hashtable.put(tc.MARGIN, Integer.valueOf(i20));
                                if (i10 != HmsScanBase.AZTEC_SCAN_TYPE) {
                                    barcodeFormat4 = BarcodeFormat.AZTEC;
                                } else if (i10 == HmsScanBase.DATAMATRIX_SCAN_TYPE) {
                                    barcodeFormat4 = BarcodeFormat.DATA_MATRIX;
                                } else {
                                    if (i10 == HmsScanBase.PDF417_SCAN_TYPE) {
                                        barcodeFormat5 = BarcodeFormat.PDF_417;
                                        hashtable.put(tc.ERROR_CORRECTION, 2);
                                    } else if (i10 == i14) {
                                        barcodeFormat4 = BarcodeFormat.QR_CODE;
                                        hashtable.put(tc.ERROR_CORRECTION, str3);
                                    } else if (i10 == HmsScanBase.CODABAR_SCAN_TYPE) {
                                        barcodeFormat5 = BarcodeFormat.CODABAR;
                                    } else if (i10 == HmsScanBase.CODE39_SCAN_TYPE) {
                                        barcodeFormat5 = BarcodeFormat.CODE_39;
                                    } else if (i10 == HmsScanBase.CODE93_SCAN_TYPE) {
                                        barcodeFormat5 = BarcodeFormat.CODE_93;
                                    } else if (i10 == HmsScanBase.CODE128_SCAN_TYPE) {
                                        barcodeFormat5 = BarcodeFormat.CODE_128;
                                    } else if (i10 == HmsScanBase.EAN8_SCAN_TYPE) {
                                        barcodeFormat5 = BarcodeFormat.EAN_8;
                                    } else if (i10 == HmsScanBase.EAN13_SCAN_TYPE) {
                                        barcodeFormat5 = BarcodeFormat.EAN_13;
                                    } else if (i10 == HmsScanBase.ITF14_SCAN_TYPE) {
                                        barcodeFormat5 = BarcodeFormat.ITF;
                                    } else if (i10 == HmsScanBase.UPCCODE_A_SCAN_TYPE) {
                                        barcodeFormat5 = BarcodeFormat.UPC_A;
                                    } else if (i10 == HmsScanBase.UPCCODE_E_SCAN_TYPE) {
                                        barcodeFormat5 = BarcodeFormat.UPC_E;
                                    } else {
                                        barcodeFormat4 = BarcodeFormat.QR_CODE;
                                        hashtable.put(tc.ERROR_CORRECTION, str3);
                                    }
                                    barcodeFormat = barcodeFormat5;
                                    z10 = true;
                                    if (hmsBuildBitmapOption != null || hmsBuildBitmapOption.logoBitmap == null || barcodeFormat == BarcodeFormat.QR_CODE) {
                                        if (barcodeFormat == BarcodeFormat.QR_CODE || hmsBuildBitmapOption == null || hmsBuildBitmapOption.logoBitmap == null) {
                                            a10 = a(str, barcodeFormat, i11, i12, hashtable);
                                            if (a10 == null) {
                                                return null;
                                            }
                                            int d10 = a10.d();
                                            int b10 = a10.b();
                                            int[] iArr = new int[d10 * b10];
                                            for (int i23 = 0; i23 < b10; i23++) {
                                                for (int i24 = 0; i24 < d10; i24++) {
                                                    if (a10.b(i24, i23)) {
                                                        iArr[(i23 * d10) + i24] = i22;
                                                    } else {
                                                        iArr[(i23 * d10) + i24] = i21;
                                                    }
                                                }
                                            }
                                            bitmap2 = Bitmap.createBitmap(d10, b10, Bitmap.Config.ARGB_8888);
                                            bitmap2.setPixels(iArr, 0, d10, 0, 0, d10, b10);
                                            float f10 = d10;
                                            float f11 = f10 / i11;
                                            float f12 = b10;
                                            float f13 = f12 / i12;
                                            if (!(f11 == 1.0f || f13 == 1.0f || !z10)) {
                                                if (f11 > f13) {
                                                    bitmap = b.a(bitmap2, i11, (int) (f12 / f11));
                                                } else {
                                                    bitmap = b.a(bitmap2, (int) (f10 / f13), i12);
                                                }
                                                if (bitmap == null) {
                                                    g.a(0, bitmap, a11);
                                                } else {
                                                    g.a(-1015, bitmap, a11);
                                                }
                                                return bitmap;
                                            }
                                            a.a("MultiFormatWriter", "wMultiple == 1f || hMultiple == 1f || !reFormFlag");
                                        } else {
                                            hashtable.put(tc.ERROR_CORRECTION, EnumC0647za.H.toString());
                                            hashtable.put(tc.LOGO, Boolean.TRUE);
                                            C0595i a12 = a(str, barcodeFormat, i11, i12, hashtable);
                                            if (a12 == null) {
                                                return null;
                                            }
                                            int d11 = (a12.d() - (i20 * 2)) / 8;
                                            int d12 = a12.d() / 2;
                                            int b11 = a12.b() / 2;
                                            Matrix matrix = new Matrix();
                                            float f14 = d11 * 2.0f;
                                            matrix.setScale(f14 / hmsBuildBitmapOption.logoBitmap.getWidth(), f14 / hmsBuildBitmapOption.logoBitmap.getHeight());
                                            Bitmap bitmap6 = hmsBuildBitmapOption.logoBitmap;
                                            Bitmap createBitmap = Bitmap.createBitmap(bitmap6, 0, 0, bitmap6.getWidth(), hmsBuildBitmapOption.logoBitmap.getHeight(), matrix, false);
                                            int[] iArr2 = new int[i11 * i11];
                                            for (int i25 = 0; i25 < i11; i25++) {
                                                for (int i26 = 0; i26 < i11; i26++) {
                                                    if (i26 > d12 - d11 && i26 < d12 + d11 && i25 > b11 - d11 && i25 < b11 + d11) {
                                                        iArr2[(i25 * i11) + i26] = createBitmap.getPixel((i26 - d12) + d11, (i25 - b11) + d11);
                                                    } else if (a12.b(i26, i25)) {
                                                        iArr2[(i25 * i11) + i26] = i22;
                                                    } else {
                                                        iArr2[(i25 * i11) + i26] = i21;
                                                    }
                                                }
                                            }
                                            bitmap2 = Bitmap.createBitmap(i11, i11, Bitmap.Config.ARGB_8888);
                                            bitmap2.setPixels(iArr2, 0, i11, 0, 0, i11, i11);
                                        }
                                        bitmap = bitmap2;
                                        if (bitmap == null) {
                                        }
                                        return bitmap;
                                    }
                                    throw new WriterException("Non-QR code should not contains logos");
                                }
                                barcodeFormat = barcodeFormat4;
                                z10 = false;
                                if (hmsBuildBitmapOption != null) {
                                }
                                if (barcodeFormat == BarcodeFormat.QR_CODE) {
                                }
                                a10 = a(str, barcodeFormat, i11, i12, hashtable);
                                if (a10 == null) {
                                }
                            }
                            if (barcodeFormat == BarcodeFormat.QR_CODE) {
                            }
                            a10 = a(str, barcodeFormat, i11, i12, hashtable);
                            if (a10 == null) {
                            }
                        } catch (IllegalArgumentException e13) {
                            e11 = e13;
                            bitmap3 = hmsBuildBitmapOption;
                            g.a(-1016, bitmap3, a11);
                            throw new WriterException(e11.getMessage(), barcodeFormat2.toString());
                        } catch (Exception e14) {
                            e12 = e14;
                            bitmap5 = hmsBuildBitmapOption;
                            g.a(-1013, bitmap5, a11);
                            throw new WriterException(e12.getMessage(), barcodeFormat3.toString());
                        } catch (OutOfMemoryError e15) {
                            e10 = e15;
                            bitmap4 = hmsBuildBitmapOption;
                            g.a(-1014, bitmap4, a11);
                            throw new WriterException(e10.getMessage());
                        }
                    } catch (IllegalArgumentException e16) {
                        e11 = e16;
                        g.a(-1016, bitmap3, a11);
                        throw new WriterException(e11.getMessage(), barcodeFormat2.toString());
                    } catch (Exception e17) {
                        e12 = e17;
                        g.a(-1013, bitmap5, a11);
                        throw new WriterException(e12.getMessage(), barcodeFormat3.toString());
                    }
                } catch (OutOfMemoryError e18) {
                    e10 = e18;
                }
            } catch (IllegalArgumentException e19) {
                e11 = e19;
                barcodeFormat2 = barcodeFormat;
            } catch (Exception e20) {
                e12 = e20;
                barcodeFormat3 = barcodeFormat;
            }
            i13 = 1;
            int i152 = -16777216;
            int i162 = -197381;
            EnumC0647za zaVar2 = EnumC0647za.L;
            String str22 = zaVar2.toString();
            if (hmsBuildBitmapOption != null) {
            }
            int i202 = i13;
            int i212 = i162;
            String str32 = str22;
            int i222 = i152;
            Hashtable hashtable2 = new Hashtable();
            hashtable2.put(tc.CHARACTER_SET, "utf-8");
            hashtable2.put(tc.MARGIN, Integer.valueOf(i202));
            if (i10 != HmsScanBase.AZTEC_SCAN_TYPE) {
            }
            barcodeFormat = barcodeFormat4;
            z10 = false;
            if (hmsBuildBitmapOption != null) {
            }
        } else {
            g.a(-1012, (Bitmap) null, a11);
            throw new WriterException("IllegalArgumentException:contents.length > 2953");
        }
    }
}
