package com.huawei.hms.scankit.p;

import android.graphics.Point;
import android.util.SparseArray;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.ml.scan.HmsScanBase;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import com.huawei.hms.scankit.aiscan.common.x;
import com.huawei.hms.scankit.aiscan.common.z;
import java.util.ArrayList;
import java.util.regex.Pattern;
/* compiled from: ResultParser.java */
/* renamed from: com.huawei.hms.scankit.p.pb  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC0619pb {

    /* renamed from: b  reason: collision with root package name */
    private static final SparseArray<Integer> f14891b;

    /* renamed from: a  reason: collision with root package name */
    private static final AbstractC0619pb[] f14890a = {new C0597ib(), new C0610mb(), new C0624rb(), new C0622qb(), new C0636vb(), new C0585fb(), new C0630tb(), new C0633ub(), new C0604kb(), new C0627sb(), new C0613nb(), new C0581eb(), new C0577db(), new C0607lb(), new C0616ob(), new C0593hb()};

    /* renamed from: c  reason: collision with root package name */
    private static final Pattern f14892c = Pattern.compile("\\d+");

    /* renamed from: d  reason: collision with root package name */
    private static final Pattern f14893d = Pattern.compile(ContainerUtils.FIELD_DELIMITER);

    /* renamed from: e  reason: collision with root package name */
    private static final Pattern f14894e = Pattern.compile(ContainerUtils.KEY_VALUE_DELIMITER);

    /* renamed from: f  reason: collision with root package name */
    static final String[] f14895f = new String[0];

    static {
        SparseArray<Integer> sparseArray = new SparseArray<>();
        f14891b = sparseArray;
        sparseArray.put(BarcodeFormat.AZTEC.ordinal(), Integer.valueOf(HmsScanBase.AZTEC_SCAN_TYPE));
        sparseArray.put(BarcodeFormat.CODABAR.ordinal(), Integer.valueOf(HmsScanBase.CODABAR_SCAN_TYPE));
        sparseArray.put(BarcodeFormat.CODE_39.ordinal(), Integer.valueOf(HmsScanBase.CODE39_SCAN_TYPE));
        sparseArray.put(BarcodeFormat.CODE_93.ordinal(), Integer.valueOf(HmsScanBase.CODE93_SCAN_TYPE));
        sparseArray.put(BarcodeFormat.CODE_128.ordinal(), Integer.valueOf(HmsScanBase.CODE128_SCAN_TYPE));
        sparseArray.put(BarcodeFormat.DATA_MATRIX.ordinal(), Integer.valueOf(HmsScanBase.DATAMATRIX_SCAN_TYPE));
        sparseArray.put(BarcodeFormat.EAN_8.ordinal(), Integer.valueOf(HmsScanBase.EAN8_SCAN_TYPE));
        sparseArray.put(BarcodeFormat.EAN_13.ordinal(), Integer.valueOf(HmsScanBase.EAN13_SCAN_TYPE));
        sparseArray.put(BarcodeFormat.ITF.ordinal(), Integer.valueOf(HmsScanBase.ITF14_SCAN_TYPE));
        sparseArray.put(BarcodeFormat.PDF_417.ordinal(), Integer.valueOf(HmsScanBase.PDF417_SCAN_TYPE));
        sparseArray.put(BarcodeFormat.QR_CODE.ordinal(), Integer.valueOf(HmsScanBase.QRCODE_SCAN_TYPE));
        sparseArray.put(BarcodeFormat.UPC_A.ordinal(), Integer.valueOf(HmsScanBase.UPCCODE_A_SCAN_TYPE));
        sparseArray.put(BarcodeFormat.UPC_E.ordinal(), Integer.valueOf(HmsScanBase.UPCCODE_E_SCAN_TYPE));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int a(char c10) {
        if (c10 >= '0' && c10 <= '9') {
            return c10 - '0';
        }
        char c11 = 'a';
        if (c10 < 'a' || c10 > 'f') {
            c11 = 'A';
            if (c10 < 'A' || c10 > 'F') {
                return -1;
            }
        }
        return (c10 - c11) + 10;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int a(BarcodeFormat barcodeFormat) {
        if (barcodeFormat == null) {
            return HmsScanBase.FORMAT_UNKNOWN;
        }
        Integer num = f14891b.get(barcodeFormat.ordinal());
        return num == null ? HmsScanBase.FORMAT_UNKNOWN : num.intValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String b(String str) {
        int indexOf = str.indexOf(92);
        if (indexOf < 0) {
            return str;
        }
        int length = str.length();
        StringBuilder sb2 = new StringBuilder(length - 1);
        sb2.append(str.toCharArray(), 0, indexOf);
        boolean z10 = false;
        while (indexOf < length) {
            char charAt = str.charAt(indexOf);
            if (z10 || charAt != '\\') {
                sb2.append(charAt);
                z10 = false;
            } else {
                z10 = true;
            }
            indexOf++;
        }
        return sb2.toString();
    }

    public static HmsScan c(x xVar) {
        if (xVar == null) {
            return null;
        }
        for (AbstractC0619pb pbVar : f14890a) {
            HmsScan b10 = pbVar.b(xVar);
            if (b10 != null) {
                return b10;
            }
        }
        return new HmsScan(xVar.g(), a(xVar.b()), xVar.g(), HmsScan.PURE_TEXT_FORM, xVar.e(), a(xVar.f()), null, null).setZoomValue(xVar.h());
    }

    public abstract HmsScan b(x xVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public static Point[] a(z[] zVarArr) {
        if (zVarArr == null || zVarArr.length <= 0) {
            return new Point[0];
        }
        Point[] pointArr = new Point[zVarArr.length];
        for (int i10 = 0; i10 < zVarArr.length; i10++) {
            if (zVarArr[i10] != null) {
                pointArr[i10] = new Point((int) zVarArr[i10].b(), (int) zVarArr[i10].c());
            }
        }
        return pointArr;
    }

    private static int b(CharSequence charSequence, int i10) {
        int i11 = 0;
        for (int i12 = i10 - 1; i12 >= 0 && charSequence.charAt(i12) == '\\'; i12--) {
            i11++;
        }
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String a(x xVar) {
        String g10 = xVar.g();
        return g10 == null ? "" : g10.startsWith("\ufeff") ? g10.substring(1) : g10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b(String str, String str2, char c10, boolean z10) {
        String[] a10 = a(str, str2, c10, z10);
        return (a10 == null || a10.length == 0 || a10[0] == null) ? "" : a10[0];
    }

    public static HmsScan[] a(x[] xVarArr) {
        if (xVarArr == null || xVarArr.length <= 0) {
            return new HmsScan[0];
        }
        HmsScan[] hmsScanArr = new HmsScan[xVarArr.length];
        for (int i10 = 0; i10 < xVarArr.length; i10++) {
            if (xVarArr[i10] == null) {
                hmsScanArr[i10] = null;
            } else {
                hmsScanArr[i10] = c(xVarArr[i10]);
            }
        }
        return hmsScanArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean a(CharSequence charSequence, int i10) {
        return charSequence != null && i10 > 0 && i10 == charSequence.length() && f14892c.matcher(charSequence).matches();
    }

    static String[] a(String str, String str2, char c10, boolean z10) {
        int length = str2.length();
        ArrayList arrayList = null;
        int i10 = 0;
        while (i10 < length) {
            int indexOf = str2.indexOf(str, i10);
            if (indexOf < 0) {
                break;
            }
            int length2 = indexOf + str.length();
            boolean z11 = true;
            ArrayList arrayList2 = arrayList;
            int i11 = length2;
            while (z11) {
                int indexOf2 = str2.indexOf(c10, i11);
                if (indexOf2 < 0) {
                    i11 = str2.length();
                } else if (b(str2, indexOf2) % 2 != 0) {
                    i11 = indexOf2 + 1;
                } else {
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList(3);
                    }
                    String b10 = b(str2.substring(length2, indexOf2));
                    if (z10) {
                        b10 = b10.trim();
                    }
                    arrayList2.add(b10);
                    i11 = indexOf2 + 1;
                }
                z11 = false;
            }
            i10 = i11;
            arrayList = arrayList2;
        }
        if (arrayList == null) {
            return null;
        }
        return (String[]) arrayList.toArray(f14895f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String a(String str) {
        if (str == null) {
            return str;
        }
        int length = str.length();
        while (length > 0 && str.charAt(length - 1) <= ' ') {
            length--;
        }
        return length < str.length() ? str.substring(0, length) : str;
    }
}
