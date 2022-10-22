package zl;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import com.realsil.sdk.dfu.exception.LoadFileException;
import com.realsil.sdk.dfu.image.wrapper.SocImageWrapper;
import com.realsil.sdk.dfu.model.ImageVersionInfo;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kl.b;
import sl.c;
import sl.d;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f37626a = true;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f37627b = b.f30016b;

    public static cm.a a(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            String b10 = jl.b.b(str);
            if (b10 == null || !b10.equalsIgnoreCase(str2)) {
                il.b.l("invalid suffix: " + b10);
                throw new LoadFileException("invalid suffix", 4099);
            }
            File file = new File(str);
            if (file.exists()) {
                cm.a aVar = new cm.a();
                aVar.f5978a = file.getPath();
                aVar.f5979b = file.getName();
                aVar.f5980c = file.length();
                return aVar;
            }
            throw new LoadFileException("image file not exist", 4100);
        }
        throw new LoadFileException("invalid path: ", 4098);
    }

    public static wl.a b(int i10, InputStream inputStream, long j10) {
        if (f37627b) {
            il.b.j(String.format(Locale.US, "icType=0x%02X, skipOffset=%d", Integer.valueOf(i10), Long.valueOf(j10)));
        }
        inputStream.skip(j10);
        if (i10 <= 3) {
            return new c(inputStream);
        }
        if (i10 == 4 || i10 == 6 || i10 == 7 || i10 == 8) {
            return new sl.b(inputStream);
        }
        if (i10 == 11 || i10 == 10 || i10 == 13) {
            return new sl.a(inputStream);
        }
        if (i10 == 5 || i10 == 9 || i10 == 12) {
            return new d(inputStream);
        }
        il.b.j(String.format("not support icType=0x%02X", Integer.valueOf(i10)));
        return null;
    }

    public static boolean c(int i10, int i11) {
        return i11 <= 3 ? i10 <= 3 : (i11 == 4 || i11 == 8 || i11 == 6) ? i10 == 4 || i10 == 8 || i10 == 6 : i11 == i10;
    }

    public static cm.a d(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            String b10 = jl.b.b(str);
            if (b10 == null || !b10.equalsIgnoreCase(str2)) {
                il.b.l("the file suffix is not right, suffix=" + b10);
                throw new LoadFileException("invalid suffix", 4099);
            }
            cm.a aVar = new cm.a();
            aVar.f5978a = str;
            aVar.f5979b = lm.d.c(str);
            return aVar;
        }
        throw new LoadFileException("invalid path", 4098);
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x00cf, code lost:
        if (r11 != 21) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0227, code lost:
        if (r11 != 21) goto L103;
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x005c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int e(int i10, wl.a aVar, cm.d dVar) {
        String format;
        String format2;
        ArrayList<ul.a> arrayList;
        if (dVar == null) {
            return 1;
        }
        int i11 = aVar.f36312l;
        int i12 = aVar.f36308h;
        if (dVar.f6005k != 0) {
            ul.a aVar2 = null;
            int i13 = dVar.f6004j;
            if (i13 <= 3) {
                il.b.c("not support version check for bee1 when otaVersion=1");
                return 1;
            }
            if (i13 == 5 || i13 == 9 || i13 == 12) {
                arrayList = ul.a.f35467j;
            } else {
                if (i13 == 4 || i13 == 6 || i13 == 7 || i13 == 8) {
                    arrayList = ul.a.f35468k;
                }
                if (aVar2 != null) {
                    il.b.c(aVar2.toString());
                    List<ImageVersionInfo> v10 = dVar.v();
                    if (v10 != null && v10.size() > 0) {
                        for (ImageVersionInfo imageVersionInfo : v10) {
                            if (imageVersionInfo.a() == i10 || imageVersionInfo.a() + 16 == i10) {
                                if (g(i11, i12, imageVersionInfo.d(), dVar.f6005k, aVar2.f35475f) <= 0) {
                                    format2 = String.format(Locale.US, "image: bitNumber=%d, file(%08X)<device(%08X)", Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(imageVersionInfo.d()));
                                    il.b.l(format2);
                                    return -1;
                                }
                                il.b.j("version validate ok: " + i11);
                            }
                            while (r3.hasNext()) {
                            }
                        }
                    }
                }
                return 1;
            }
            aVar2 = ul.a.b(arrayList, i10, true);
            if (aVar2 != null) {
            }
            return 1;
        }
        int i14 = dVar.f6004j;
        if (i14 != 12) {
            switch (i14) {
                case 3:
                    if (i10 != 0) {
                        if (i10 != 1 && i10 != 2) {
                            if (i10 == 4) {
                                if (i11 < dVar.B()) {
                                    format2 = String.format(Locale.US, "patch extension : file(%08X)<device(%08X)", Integer.valueOf(i11), Integer.valueOf(dVar.B()));
                                    il.b.l(format2);
                                    return -1;
                                } else if (i11 == dVar.B()) {
                                    format = String.format(Locale.US, "patch extension : file(%08X)<device(%08X)", Integer.valueOf(i11), Integer.valueOf(dVar.B()));
                                    il.b.l(format);
                                    return 0;
                                }
                            }
                            return 1;
                        } else if (i11 < dVar.s()) {
                            format2 = String.format(Locale.US, "app : file(%08X)<device(%08X)", Integer.valueOf(i11), Integer.valueOf(dVar.s()));
                            il.b.l(format2);
                            return -1;
                        } else {
                            if (i11 == dVar.s()) {
                                format = String.format(Locale.US, "app : file(%08X)<device(%08X)", Integer.valueOf(i11), Integer.valueOf(dVar.s()));
                                il.b.l(format);
                                return 0;
                            }
                            return 1;
                        }
                    } else if (i11 < dVar.C()) {
                        format2 = String.format(Locale.US, "patch : file(%08X)<device(%08X)", Integer.valueOf(i11), Integer.valueOf(dVar.C()));
                        il.b.l(format2);
                        return -1;
                    } else {
                        if (i11 == dVar.C()) {
                            format = String.format(Locale.US, "patch : file(%08X)<device(%08X)", Integer.valueOf(i11), Integer.valueOf(dVar.C()));
                            il.b.l(format);
                            return 0;
                        }
                        return 1;
                    }
                case 4:
                case 6:
                case 7:
                case 8:
                    if (i10 != 4) {
                        if (i10 != 5) {
                            if (i10 != 20) {
                            }
                        }
                        if (i11 < dVar.s()) {
                            format2 = String.format(Locale.US, "app: file(%08X)<device(%08X)", Integer.valueOf(i11), Integer.valueOf(dVar.s()));
                            il.b.l(format2);
                            return -1;
                        }
                        if (i11 == dVar.s()) {
                            format = String.format(Locale.US, "app: file(%08X)<device(%08X)", Integer.valueOf(i11), Integer.valueOf(dVar.s()));
                            il.b.l(format);
                            return 0;
                        }
                        return 1;
                    }
                    if (i11 < dVar.C()) {
                        format2 = String.format(Locale.US, "patch : file(%08X)<device(%08X)", Integer.valueOf(i11), Integer.valueOf(dVar.C()));
                        il.b.l(format2);
                        return -1;
                    }
                    if (i11 == dVar.C()) {
                        format = String.format(Locale.US, "patch : file(%08X)<device(%08X)", Integer.valueOf(i11), Integer.valueOf(dVar.C()));
                        il.b.l(format);
                        return 0;
                    }
                    return 1;
                case 5:
                case 9:
                    break;
                default:
                    return 1;
            }
        }
        if (i10 != 4) {
            if (i10 != 5) {
                if (i10 != 20) {
                }
            }
            if (i11 <= dVar.s()) {
                format2 = String.format(Locale.US, "app : file(%08X)<device(%08X)", Integer.valueOf(i11), Integer.valueOf(dVar.s()));
                il.b.l(format2);
                return -1;
            }
            if (i11 <= dVar.s()) {
                format = String.format(Locale.US, "app : file(%08X)<device(%08X)", Integer.valueOf(i11), Integer.valueOf(dVar.s()));
                il.b.l(format);
                return 0;
            }
            return 1;
        }
        if (i11 <= dVar.C()) {
            format2 = String.format(Locale.US, "patch: file(%08X)<device(%08X)", Integer.valueOf(i11), Integer.valueOf(dVar.C()));
            il.b.l(format2);
            return -1;
        }
        if (i11 <= dVar.C()) {
            format = String.format(Locale.US, "patch: file(%08X)<device(%08X)", Integer.valueOf(i11), Integer.valueOf(dVar.C()));
            il.b.l(format);
            return 0;
        }
        return 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0052, code lost:
        if (r6.f35474e != false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x006d, code lost:
        if (r6.f35474e != false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x006f, code lost:
        r5 = r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int f(wl.a aVar, cm.d dVar) {
        String format;
        ul.a aVar2;
        ul.a aVar3;
        if (dVar == null) {
            return 1;
        }
        int w10 = aVar.w();
        int i10 = aVar.f36312l;
        int i11 = aVar.f36308h;
        if (dVar.f6005k != 0) {
            int i12 = dVar.f6004j;
            if (i12 <= 3) {
                il.b.c("not support version check for bee1 when otaVersion=1");
                return 1;
            }
            if (i12 == 5 || i12 == 9 || i12 == 12) {
                Iterator<ul.a> it = ul.a.f35467j.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    aVar3 = it.next();
                    if (aVar3.f35473d == w10) {
                    }
                }
                aVar2 = null;
            } else {
                if (i12 == 4 || i12 == 6 || i12 == 7 || i12 == 8) {
                    Iterator<ul.a> it2 = ul.a.f35468k.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        aVar3 = it2.next();
                        if (aVar3.f35473d == w10) {
                        }
                    }
                }
                aVar2 = null;
            }
            if (aVar2 != null) {
                il.b.c(aVar2.toString());
                List<ImageVersionInfo> v10 = dVar.v();
                if (v10 != null && v10.size() > 0) {
                    Iterator<ImageVersionInfo> it3 = v10.iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            break;
                        }
                        ImageVersionInfo next = it3.next();
                        if (next.a() == aVar2.f35470a) {
                            if (g(i10, i11, next.d(), dVar.f6005k, aVar2.f35475f) <= 0) {
                                format = String.format(Locale.US, "image: bitNumber=%d, file(%08X)<device(%08X)", Integer.valueOf(aVar2.f35470a), Integer.valueOf(i10), Integer.valueOf(next.d()));
                            } else {
                                il.b.j("version validate ok: " + i10);
                            }
                        }
                    }
                }
            }
            return 1;
        }
        int i13 = dVar.f6004j;
        if (i13 <= 3) {
            il.b.j("not support version check for bee1 when otaVersion=0");
            return 1;
        } else if (i13 != 4 && i13 != 6 && i13 != 7 && i13 != 8) {
            if (i13 == 5 || i13 == 9 || i13 == 12) {
                if (w10 != 512) {
                    if (w10 == 768 && i10 < dVar.s()) {
                        format = String.format(Locale.US, "app iamge : file(%08X)<device(%08X)", Integer.valueOf(i10), Integer.valueOf(dVar.s()));
                        il.b.l(format);
                        return -1;
                    }
                } else if (i10 < dVar.C()) {
                    format = String.format(Locale.US, "patch iamge: file(%08X)<device(%08X)", Integer.valueOf(i10), Integer.valueOf(dVar.C()));
                    il.b.l(format);
                    return -1;
                }
            }
            return 1;
        } else if (w10 != 512) {
            if (w10 == 768 && i10 < dVar.s()) {
                format = String.format(Locale.US, "app iamge: file(%08X)<device(%08X)", Integer.valueOf(i10), Integer.valueOf(dVar.s()));
                il.b.l(format);
                return -1;
            }
            return 1;
        } else {
            if (i10 < dVar.C()) {
                format = String.format(Locale.US, "patch iamge : file(%08X)<device(%08X)", Integer.valueOf(i10), Integer.valueOf(dVar.C()));
                il.b.l(format);
                return -1;
            }
            return 1;
        }
    }

    public static int g(int i10, int i11, int i12, int i13, int i14) {
        il.b.j(String.format(Locale.US, "checkVersion: bin=%08X(%d) %s, soc=%08X(%d) %s", Integer.valueOf(i10), Integer.valueOf(i10), lm.d.b(i11, i10, i14), Integer.valueOf(i12), Integer.valueOf(i12), lm.d.b(i13, i12, i14)));
        if (i12 == -1) {
            return 1;
        }
        if (i11 <= 0) {
            return ol.b.b(i10, nl.c.a(i12, i13, i14));
        }
        if (i13 <= 0) {
            return ol.b.b(nl.c.a(i10, i11, i14), i12);
        }
        if (i14 == 1) {
            return new nl.b(i10 & 255, (i10 >> 8) & 255, (i10 >> 16) & 255, (i10 >> 24) & 255).a(new nl.b(i12 & 255, (i12 >> 8) & 255, (i12 >> 16) & 255, (i12 >> 24) & 255));
        }
        if (!(i14 == 515 || i14 == 2)) {
            if (i14 == 3) {
                return new nl.b(i10 & 15, (i10 >> 4) & 255, (i10 >> 12) & 32767, (i10 >> 27) & 31).a(new nl.b(i12 & 15, (i12 >> 4) & 255, (i12 >> 12) & 32767, (i12 >> 27) & 31));
            }
            if (i14 == 5) {
                return new nl.b(i10 & 15, (i10 >> 4) & 255, (i10 >> 12) & 511, (i10 >> 21) & 32767).a(new nl.b(i12 & 15, (i12 >> 4) & 255, (i12 >> 12) & 511, (i12 >> 21) & 32767));
            }
            if (!(i14 == 4 || i14 == 7 || i14 != 514)) {
                return new nl.b((i10 >> 8) & 255, i10 & 255, (i10 >> 24) & 255, (i10 >> 16) & 255).a(new nl.b((i12 >> 8) & 255, i12 & 255, (i12 >> 24) & 255, (i12 >> 16) & 255));
            }
            return ol.b.b(i10, i12);
        }
        return new nl.b((i10 >> 24) & 255, (i10 >> 16) & 255, (i10 >> 8) & 255, i10 & 255).a(new nl.b((i12 >> 24) & 255, (i12 >> 16) & 255, (i12 >> 8) & 255, i12 & 255));
    }

    public static int h(int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, boolean z10) {
        return i(i11, i13, i14, i18).a(j(i10, i15, i17, i12, i16, z10));
    }

    public static nl.b i(int i10, int i11, int i12, int i13) {
        il.b.j(String.format(Locale.US, "checkVersion: bin=%08X(%d) %s", Integer.valueOf(i11), Integer.valueOf(i11), lm.d.b(i12, i11, i13)));
        if (i12 == 2 && i10 == 1040) {
            i13 = 516;
        }
        if (i12 <= 0) {
            i13 = 7;
        }
        return nl.b.b(i13, i11);
    }

    public static nl.b j(int i10, int i11, int i12, int i13, int i14, boolean z10) {
        int g10 = SocImageWrapper.g(i10, i11, i12, i13, z10);
        il.b.j(String.format(Locale.US, "checkVersion: soc=%08X(%d) %s", Integer.valueOf(i14), Integer.valueOf(i14), lm.d.b(i12, i14, g10)));
        return nl.b.b(g10, i14);
    }

    public static wl.a k(Context context, int i10, String str, long j10) {
        il.b.k(f37627b, String.format(Locale.US, "fileName=%s, icType=%d", str, Integer.valueOf(i10)));
        AssetManager assets = context.getAssets();
        if (assets != null) {
            InputStream open = assets.open(str);
            if (open != null) {
                return b(i10, open, j10);
            }
            il.b.c("open asset file failed");
            return null;
        }
        il.b.l("assetManager is null");
        return null;
    }

    public static wl.a l(int i10, String str, long j10) {
        return b(i10, new FileInputStream(str), j10);
    }

    public static int m(int i10, int i11) {
        return i11 == 0 ? i10 : i10 % i11;
    }

    public static int n(int i10, int i11, int i12) {
        int i13 = (i11 >> (i10 * 2)) & 3;
        if (i13 == 0) {
            if (i12 != 2) {
                return i10;
            }
        } else if (i13 != 1) {
            return i10;
        }
        return i10 + 16;
    }
}
