package ul;

import com.realsil.sdk.dfu.DfuException;
import il.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: h  reason: collision with root package name */
    public static boolean f35465h = false;

    /* renamed from: i  reason: collision with root package name */
    public static final ArrayList<a> f35466i;

    /* renamed from: j  reason: collision with root package name */
    public static final ArrayList<a> f35467j;

    /* renamed from: k  reason: collision with root package name */
    public static final ArrayList<a> f35468k;

    /* renamed from: l  reason: collision with root package name */
    public static final ArrayList<a> f35469l;

    /* renamed from: a  reason: collision with root package name */
    public int f35470a;

    /* renamed from: b  reason: collision with root package name */
    public String f35471b;

    /* renamed from: c  reason: collision with root package name */
    public int f35472c;

    /* renamed from: d  reason: collision with root package name */
    public int f35473d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f35474e;

    /* renamed from: f  reason: collision with root package name */
    public int f35475f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f35476g;

    static {
        ArrayList<a> arrayList = new ArrayList<>();
        f35466i = arrayList;
        arrayList.add(new a(0, "Patch (Both MP and OTA)", null, -1, true, 7));
        arrayList.add(new a(1, "App bank 0 image (Both MP and OTA)", null, -1, true, 7));
        arrayList.add(new a(2, "APP bank 1 image (OTA)", null, -1, true, 7));
        arrayList.add(new a(3, "User data (MP)", null, -1, true, 7));
        arrayList.add(new a(4, "Patch extension image (Both MP and OTA)", null, -1, true, 7));
        arrayList.add(new a(5, "Config file (MP)", null, -1, true, 7));
        arrayList.add(new a(6, "External Flash (MP)", null, -1, true, 7));
        ArrayList<a> arrayList2 = new ArrayList<>();
        f35467j = arrayList2;
        arrayList2.add(new a(0, "SOCV Config File", null, DfuException.ERROR_FILE_IO_EXCEPTION, true, 3));
        arrayList2.add(new a(1, "System Config", null, 256, true, 3));
        for (int i10 = 0; i10 < 2; i10++) {
            ArrayList<a> arrayList3 = f35467j;
            int i11 = i10 * 16;
            arrayList3.add(new a(i11 + 2, "OTA Header", null, 2048, true, 2));
            arrayList3.add(new a(i11 + 3, "Secure Boot Loader", null, 1792, true, 3));
            arrayList3.add(new a(i11 + 4, "ROM Patch", null, 512, true, 3));
            arrayList3.add(new a(i11 + 5, "App", null, 768, true, 3));
            arrayList3.add(new a(i11 + 6, "APP Data1 File", null, 2305, false, 3));
            arrayList3.add(new a(i11 + 7, "APP Data2 File", null, 2306, false, 3));
            arrayList3.add(new a(i11 + 8, "APP Data3 File", null, 2307, false, 3));
            arrayList3.add(new a(i11 + 9, "APP Data4 File", null, 2308, false, 3));
            arrayList3.add(new a(i11 + 10, "APP Data5 File", null, 2309, false, 3));
            arrayList3.add(new a(i11 + 11, "APP Data6 File", null, 2310, false, 3));
            arrayList3.add(new a(i11 + 12, "Upper Stack", null, 2560, true, 3));
        }
        ArrayList<a> arrayList4 = new ArrayList<>();
        f35468k = arrayList4;
        arrayList4.add(new a(0, "SOCV Config File", null, DfuException.ERROR_FILE_IO_EXCEPTION, false, 1));
        arrayList4.add(new a(1, "System Config", null, 256, true, 1));
        for (int i12 = 0; i12 < 2; i12++) {
            ArrayList<a> arrayList5 = f35468k;
            int i13 = i12 * 16;
            arrayList5.add(new a(i13 + 2, "OTA Header", null, 10128, 2048, true, 1, false));
            arrayList5.add(new a(i13 + 3, "Secure Boot Loader", null, 10129, 1792, true, 3, false));
            arrayList5.add(new a(i13 + 4, "ROM Patch", null, 10130, 512, true, 3, false));
            arrayList5.add(new a(i13 + 5, "App", null, 10131, 768, true, 5, false));
            arrayList5.add(new a(i13 + 6, "DSP System", null, 10132, 1280, true, 515, false));
            arrayList5.add(new a(i13 + 7, "DSP App", null, 10133, 1538, true, 515, false));
            arrayList5.add(new a(i13 + 8, "DSP Config", null, 10135, 1040, true, 514, true));
            arrayList5.add(new a(i13 + 9, "App Config", null, 10134, 1024, true, 2, true));
            arrayList5.add(new a(i13 + 10, "Ext Image 0", null, 10136, 2304, false, 1, true));
            arrayList5.add(new a(i13 + 11, "Ext Image 1", null, 10137, 2305, false, 1, false));
            arrayList5.add(new a(i13 + 12, "Ext Image 2", null, 10138, 2306, false, 1, false));
            arrayList5.add(new a(i13 + 13, "Ext Image 3", null, 10139, 2307, false, 1, false));
            arrayList5.add(new a(i13 + 17, "Sys Patch", null, 10140, 513, false, 3, false));
            arrayList5.add(new a(i13 + 18, "Stack Patch", null, 10141, 514, false, 3, false));
            arrayList5.add(new a(i13 + 19, "Upper Stack", null, 10142, 515, false, 1, false));
            arrayList5.add(new a(i13 + 20, "Framework", null, 10143, 516, false, 1, false));
        }
        ArrayList<a> arrayList6 = f35468k;
        arrayList6.add(new a(14, "Factory", null, 2560, false, 1));
        arrayList6.add(new a(15, "Backup Data 1", null, 2816, false, 1));
        arrayList6.add(new a(16, "Backup Data 2", null, 2817, false, 1));
        arrayList6.add(new a(24, "Voice Prompt Data", null, 10148, DfuException.ERROR_REMOTE_FLASH_ERASE_ERROR, false, 2, false));
        arrayList6.add(new a(24, "Platform Ext", null, 10145, DfuException.ERROR_REMOTE_CRC_ERROR, false, 1, false));
        ArrayList<a> arrayList7 = new ArrayList<>();
        f35469l = arrayList7;
        arrayList7.add(new a(0, "SOCV Config File", null, DfuException.ERROR_FILE_IO_EXCEPTION, false, 1));
        arrayList7.add(new a(1, "System Config", null, 256, true, 1));
        arrayList7.add(new a(2, "OTA Header", null, 10128, 2048, true, 1, false));
        arrayList7.add(new a(3, "Secure Boot Loader", null, 10129, 1792, true, 3, false));
        arrayList7.add(new a(4, "ROM Patch", null, 10130, 512, true, 3, false));
        arrayList7.add(new a(5, "App", null, 10131, 768, true, 5, false));
        arrayList7.add(new a(6, "DSP System", null, 10132, 1280, true, 515, false));
        arrayList7.add(new a(7, "DSP App", null, 10133, 1538, true, 515, false));
        arrayList7.add(new a(8, "DSP Config", null, 10135, 1040, true, 514, true));
        arrayList7.add(new a(9, "App Config", null, 10134, 1024, true, 2, true));
        arrayList7.add(new a(10, "Ext Image 0", null, 10136, 2304, false, 1, true));
        arrayList7.add(new a(11, "Ext Image 1", null, 10137, 2305, false, 1, false));
        arrayList7.add(new a(12, "Ext Image 2", null, 10138, 2306, false, 1, false));
        arrayList7.add(new a(13, "Ext Image 3", null, 10139, 2307, false, 1, false));
        arrayList7.add(new a(17, "Sys Patch", null, 10140, 513, false, 3, false));
        arrayList7.add(new a(18, "Stack Patch", null, 10141, 514, false, 3, false));
        arrayList7.add(new a(19, "Upper Stack", null, 10142, 515, false, 1, false));
        arrayList7.add(new a(20, "Framework", null, 10143, 516, false, 1, false));
        arrayList7.add(new a(14, "Factory Image", null, 2560, false, 1));
        arrayList7.add(new a(15, "Backup Data 1", null, 2816, false, 1));
        arrayList7.add(new a(16, "Backup Data 2", null, 2817, false, 1));
        arrayList7.add(new a(24, "Platform Ext", null, 10145, DfuException.ERROR_REMOTE_CRC_ERROR, false, 3, false));
        arrayList7.add(new a(24, "Stack Patch", null, 10141, 518, false, 1, false));
        arrayList7.add(new a(24, "Upper stack", null, 10142, 519, false, 3, false));
        arrayList7.add(new a(24, "Voice Prompt Data", null, 10148, DfuException.ERROR_REMOTE_FLASH_ERASE_ERROR, false, 2, false));
        arrayList7.add(new a(24, "User Data 1", null, 10145, 61441, false, 1, false));
        arrayList7.add(new a(24, "User Data 2", null, 10145, 61442, false, 1, false));
        arrayList7.add(new a(24, "User Data 3", null, 10145, 61443, false, 1, false));
        arrayList7.add(new a(24, "User Data 4", null, 10145, 61444, false, 1, false));
        arrayList7.add(new a(24, "User Data 5", null, 10145, 61445, false, 1, false));
        arrayList7.add(new a(24, "User Data 6", null, 10145, 61446, false, 1, false));
        arrayList7.add(new a(24, "User Data 7", null, 10145, 61447, false, 1, false));
        arrayList7.add(new a(24, "User Data 8", null, 10145, 61448, false, 1, false));
    }

    public a(int i10, String str, String str2, int i11, int i12, boolean z10, int i13, boolean z11) {
        this.f35474e = true;
        this.f35475f = 1;
        this.f35470a = i10;
        this.f35471b = str;
        this.f35472c = i11;
        this.f35473d = i12;
        this.f35474e = z10;
        this.f35475f = i13;
        this.f35476g = z11;
    }

    public a(int i10, String str, String str2, int i11, boolean z10, int i12) {
        this(i10, str, str2, 0, i11, z10, i12, false);
    }

    public static a a(ArrayList<a> arrayList, int i10) {
        Iterator<a> it = arrayList.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.f35470a == i10) {
                return next;
            }
        }
        b.j("undefined indicator, bitNumber=" + i10);
        return null;
    }

    public static a b(ArrayList<a> arrayList, int i10, boolean z10) {
        Iterator<a> it = arrayList.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.f35470a == i10 && next.f35474e == z10) {
                return next;
            }
        }
        b.j("undefined indicator, bitNumber=" + i10);
        return null;
    }

    public static boolean c(int i10, int i11) {
        return i10 == -1 || ((i10 >> i11) & 1) != 0;
    }

    public static String d(int i10, int i11) {
        if (i10 <= 3) {
            Iterator<a> it = f35466i.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next.f35470a == i11) {
                    return next.f35471b;
                }
            }
            return "NA";
        } else if (i10 == 5 || i10 == 9 || i10 == 12) {
            Iterator<a> it2 = f35467j.iterator();
            while (it2.hasNext()) {
                a next2 = it2.next();
                if (next2.f35470a == i11) {
                    return next2.f35471b;
                }
            }
            return "NA";
        } else if (i10 != 4 && i10 != 6 && i10 != 7 && i10 != 8 && i10 != 10 && i10 != 11) {
            return "NA";
        } else {
            Iterator<a> it3 = f35468k.iterator();
            while (it3.hasNext()) {
                a next3 = it3.next();
                if (next3.f35470a == i11) {
                    return next3.f35471b;
                }
            }
            return "NA";
        }
    }

    public static String e(int i10, int i11) {
        if (i10 <= 3) {
            Iterator<a> it = f35466i.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next.f35472c == i11) {
                    return next.f35471b;
                }
            }
            return "NA";
        } else if (i10 == 5 || i10 == 9 || i10 == 12) {
            Iterator<a> it2 = f35467j.iterator();
            while (it2.hasNext()) {
                a next2 = it2.next();
                if (next2.f35472c == i11) {
                    return next2.f35471b;
                }
            }
            return "NA";
        } else if (i10 != 4 && i10 != 6 && i10 != 7 && i10 != 8 && i10 != 10 && i10 != 11) {
            return "NA";
        } else {
            Iterator<a> it3 = f35468k.iterator();
            while (it3.hasNext()) {
                a next3 = it3.next();
                if (f35465h) {
                    b.j(String.format("%04x, %04X", Integer.valueOf(next3.f35472c), Integer.valueOf(i11)));
                    b.j(next3.toString());
                }
                if (next3.f35472c == i11) {
                    return next3.f35471b;
                }
            }
            return "NA";
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        Locale locale = Locale.US;
        sb2.append(String.format(locale, "bitNumber=%d, flashLayoutName=%s, imageId=0x%04X, subBinId=0x%04X", Integer.valueOf(this.f35470a), this.f35471b, Integer.valueOf(this.f35472c), Integer.valueOf(this.f35473d)));
        sb2.append(String.format(locale, ", versionCheckEnabled=%b, versionFormat=%d, isConfigEnabled=%b", Boolean.valueOf(this.f35474e), Integer.valueOf(this.f35475f), Boolean.valueOf(this.f35476g)));
        return sb2.toString();
    }
}
