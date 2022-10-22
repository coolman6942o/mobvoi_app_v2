package e9;

import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.i;
import com.google.zxing.j;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
/* compiled from: FinderPatternFinder.java */
/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private final com.google.zxing.common.b f25870a;

    /* renamed from: c  reason: collision with root package name */
    private boolean f25872c;

    /* renamed from: e  reason: collision with root package name */
    private final j f25874e;

    /* renamed from: b  reason: collision with root package name */
    private final List<d> f25871b = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private final int[] f25873d = new int[5];

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FinderPatternFinder.java */
    /* loaded from: classes.dex */
    public static final class b implements Serializable, Comparator<d> {
        private final float average;

        /* renamed from: a */
        public int compare(d dVar, d dVar2) {
            if (dVar2.h() != dVar.h()) {
                return dVar2.h() - dVar.h();
            }
            float abs = Math.abs(dVar2.i() - this.average);
            float abs2 = Math.abs(dVar.i() - this.average);
            if (abs < abs2) {
                return 1;
            }
            return abs == abs2 ? 0 : -1;
        }

        private b(float f10) {
            this.average = f10;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FinderPatternFinder.java */
    /* loaded from: classes.dex */
    public static final class c implements Serializable, Comparator<d> {
        private final float average;

        /* renamed from: a */
        public int compare(d dVar, d dVar2) {
            float abs = Math.abs(dVar2.i() - this.average);
            float abs2 = Math.abs(dVar.i() - this.average);
            if (abs < abs2) {
                return -1;
            }
            return abs == abs2 ? 0 : 1;
        }

        private c(float f10) {
            this.average = f10;
        }
    }

    public e(com.google.zxing.common.b bVar, j jVar) {
        this.f25870a = bVar;
        this.f25874e = jVar;
    }

    private static float a(int[] iArr, int i10) {
        return ((i10 - iArr[4]) - iArr[3]) - (iArr[2] / 2.0f);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002a, code lost:
        if (r18 >= r6) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x002e, code lost:
        if (r17 < r6) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0030, code lost:
        if (r18 < r6) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x003c, code lost:
        if (r16.f25870a.d(r18 - r6, r17 - r6) != false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0040, code lost:
        if (r4[1] > r19) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0042, code lost:
        r4[1] = r4[1] + 1;
        r6 = r6 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x004a, code lost:
        if (r17 < r6) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x004c, code lost:
        if (r18 < r6) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0050, code lost:
        if (r4[1] <= r19) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0054, code lost:
        if (r17 < r6) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0056, code lost:
        if (r18 < r6) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0062, code lost:
        if (r16.f25870a.d(r18 - r6, r17 - r6) == false) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0066, code lost:
        if (r4[0] > r19) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0068, code lost:
        r4[0] = r4[0] + 1;
        r6 = r6 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0072, code lost:
        if (r4[0] <= r19) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0074, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0075, code lost:
        r6 = r16.f25870a.g();
        r9 = r16.f25870a.k();
        r10 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0082, code lost:
        r11 = r17 + r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0084, code lost:
        if (r11 >= r6) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0086, code lost:
        r12 = r18 + r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0088, code lost:
        if (r12 >= r9) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0090, code lost:
        if (r16.f25870a.d(r12, r11) == false) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0092, code lost:
        r4[2] = r4[2] + 1;
        r10 = r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x009a, code lost:
        if (r11 >= r6) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x009e, code lost:
        if ((r18 + r10) < r9) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00a2, code lost:
        r11 = r17 + r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00a5, code lost:
        if (r11 >= r6) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00a7, code lost:
        r13 = r18 + r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00a9, code lost:
        if (r13 >= r9) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00b1, code lost:
        if (r16.f25870a.d(r13, r11) != false) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00b5, code lost:
        if (r4[3] >= r19) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00b7, code lost:
        r4[3] = r4[3] + 1;
        r10 = r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00bf, code lost:
        if (r11 >= r6) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00c3, code lost:
        if ((r18 + r10) >= r9) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00c7, code lost:
        if (r4[3] < r19) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00ca, code lost:
        r11 = r17 + r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00cd, code lost:
        if (r11 >= r6) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00cf, code lost:
        r14 = r18 + r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00d1, code lost:
        if (r14 >= r9) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00d9, code lost:
        if (r16.f25870a.d(r14, r11) == false) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00dd, code lost:
        if (r4[4] >= r19) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00df, code lost:
        r4[4] = r4[4] + 1;
        r10 = r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00e9, code lost:
        if (r4[4] < r19) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00eb, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0102, code lost:
        if (java.lang.Math.abs(((((r4[0] + r4[1]) + r4[2]) + r4[3]) + r4[4]) - r20) >= (r20 * 2)) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0108, code lost:
        if (g(r4) == false) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x010a, code lost:
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean b(int i10, int i11, int i12, int i13) {
        int[] h10 = h();
        int i14 = 0;
        while (i10 >= i14 && i11 >= i14 && this.f25870a.d(i11 - i14, i10 - i14)) {
            h10[2] = h10[2] + 1;
            i14++;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x003a, code lost:
        if (r2[1] <= r13) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003f, code lost:
        if (r3 < 0) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0045, code lost:
        if (r0.d(r3, r12) == false) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0049, code lost:
        if (r2[0] > r13) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x004b, code lost:
        r2[0] = r2[0] + 1;
        r3 = r3 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0055, code lost:
        if (r2[0] <= r13) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0057, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0058, code lost:
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0059, code lost:
        if (r11 >= r1) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x005f, code lost:
        if (r0.d(r11, r12) == false) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0061, code lost:
        r2[2] = r2[2] + 1;
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0069, code lost:
        if (r11 != r1) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x006b, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x006d, code lost:
        if (r11 >= r1) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0073, code lost:
        if (r0.d(r11, r12) != false) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0077, code lost:
        if (r2[3] >= r13) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0079, code lost:
        r2[3] = r2[3] + 1;
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0081, code lost:
        if (r11 == r1) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0085, code lost:
        if (r2[3] < r13) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0089, code lost:
        if (r11 >= r1) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x008f, code lost:
        if (r0.d(r11, r12) == false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0093, code lost:
        if (r2[4] >= r13) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0095, code lost:
        r2[4] = r2[4] + 1;
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x009f, code lost:
        if (r2[4] < r13) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00a1, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00b7, code lost:
        if ((java.lang.Math.abs(((((r2[0] + r2[1]) + r2[2]) + r2[3]) + r2[4]) - r14) * 5) < r14) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00b9, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00be, code lost:
        if (g(r2) == false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00c4, code lost:
        return a(r2, r11);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private float c(int i10, int i11, int i12, int i13) {
        com.google.zxing.common.b bVar = this.f25870a;
        int k10 = bVar.k();
        int[] h10 = h();
        int i14 = i10;
        while (i14 >= 0 && bVar.d(i14, i11)) {
            h10[2] = h10[2] + 1;
            i14--;
        }
        if (i14 < 0) {
            return Float.NaN;
        }
        while (i14 >= 0 && !bVar.d(i14, i11) && h10[1] <= i12) {
            h10[1] = h10[1] + 1;
            i14--;
        }
        return Float.NaN;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x003a, code lost:
        if (r2[1] <= r13) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003f, code lost:
        if (r3 < 0) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0045, code lost:
        if (r0.d(r12, r3) == false) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0049, code lost:
        if (r2[0] > r13) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x004b, code lost:
        r2[0] = r2[0] + 1;
        r3 = r3 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0055, code lost:
        if (r2[0] <= r13) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0057, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0058, code lost:
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0059, code lost:
        if (r11 >= r1) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x005f, code lost:
        if (r0.d(r12, r11) == false) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0061, code lost:
        r2[2] = r2[2] + 1;
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0069, code lost:
        if (r11 != r1) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x006b, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x006d, code lost:
        if (r11 >= r1) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0073, code lost:
        if (r0.d(r12, r11) != false) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0077, code lost:
        if (r2[3] >= r13) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0079, code lost:
        r2[3] = r2[3] + 1;
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0081, code lost:
        if (r11 == r1) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0085, code lost:
        if (r2[3] < r13) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0089, code lost:
        if (r11 >= r1) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x008f, code lost:
        if (r0.d(r12, r11) == false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0093, code lost:
        if (r2[4] >= r13) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0095, code lost:
        r2[4] = r2[4] + 1;
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x009f, code lost:
        if (r2[4] < r13) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00a1, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00b8, code lost:
        if ((java.lang.Math.abs(((((r2[0] + r2[1]) + r2[2]) + r2[3]) + r2[4]) - r14) * 5) < (r14 * 2)) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00ba, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00bf, code lost:
        if (g(r2) == false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00c5, code lost:
        return a(r2, r11);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private float d(int i10, int i11, int i12, int i13) {
        com.google.zxing.common.b bVar = this.f25870a;
        int g10 = bVar.g();
        int[] h10 = h();
        int i14 = i10;
        while (i14 >= 0 && bVar.d(i11, i14)) {
            h10[2] = h10[2] + 1;
            i14--;
        }
        if (i14 < 0) {
            return Float.NaN;
        }
        while (i14 >= 0 && !bVar.d(i11, i14) && h10[1] <= i12) {
            h10[1] = h10[1] + 1;
            i14--;
        }
        return Float.NaN;
    }

    private int f() {
        if (this.f25871b.size() <= 1) {
            return 0;
        }
        d dVar = null;
        for (d dVar2 : this.f25871b) {
            if (dVar2.h() >= 2) {
                if (dVar == null) {
                    dVar = dVar2;
                } else {
                    this.f25872c = true;
                    return ((int) (Math.abs(dVar.c() - dVar2.c()) - Math.abs(dVar.d() - dVar2.d()))) / 2;
                }
            }
        }
        return 0;
    }

    protected static boolean g(int[] iArr) {
        int i10 = 0;
        for (int i11 = 0; i11 < 5; i11++) {
            int i12 = iArr[i11];
            if (i12 == 0) {
                return false;
            }
            i10 += i12;
        }
        if (i10 < 7) {
            return false;
        }
        float f10 = i10 / 7.0f;
        float f11 = f10 / 2.0f;
        return Math.abs(f10 - ((float) iArr[0])) < f11 && Math.abs(f10 - ((float) iArr[1])) < f11 && Math.abs((f10 * 3.0f) - ((float) iArr[2])) < 3.0f * f11 && Math.abs(f10 - ((float) iArr[3])) < f11 && Math.abs(f10 - ((float) iArr[4])) < f11;
    }

    private int[] h() {
        int[] iArr = this.f25873d;
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        iArr[3] = 0;
        iArr[4] = 0;
        return iArr;
    }

    private boolean j() {
        int size = this.f25871b.size();
        float f10 = 0.0f;
        float f11 = 0.0f;
        int i10 = 0;
        for (d dVar : this.f25871b) {
            if (dVar.h() >= 2) {
                i10++;
                f11 += dVar.i();
            }
        }
        if (i10 < 3) {
            return false;
        }
        float f12 = f11 / size;
        for (d dVar2 : this.f25871b) {
            f10 += Math.abs(dVar2.i() - f12);
        }
        return f10 <= f11 * 0.05f;
    }

    private d[] k() throws NotFoundException {
        float f10;
        int size = this.f25871b.size();
        if (size >= 3) {
            float f11 = 0.0f;
            if (size > 3) {
                float f12 = 0.0f;
                float f13 = 0.0f;
                for (d dVar : this.f25871b) {
                    float i10 = dVar.i();
                    f12 += i10;
                    f13 += i10 * i10;
                }
                float f14 = f12 / size;
                float sqrt = (float) Math.sqrt((f13 / f10) - (f14 * f14));
                Collections.sort(this.f25871b, new c(f14));
                float max = Math.max(0.2f * f14, sqrt);
                int i11 = 0;
                while (i11 < this.f25871b.size() && this.f25871b.size() > 3) {
                    if (Math.abs(this.f25871b.get(i11).i() - f14) > max) {
                        this.f25871b.remove(i11);
                        i11--;
                    }
                    i11++;
                }
            }
            if (this.f25871b.size() > 3) {
                for (d dVar2 : this.f25871b) {
                    f11 += dVar2.i();
                }
                Collections.sort(this.f25871b, new b(f11 / this.f25871b.size()));
                List<d> list = this.f25871b;
                list.subList(3, list.size()).clear();
            }
            return new d[]{this.f25871b.get(0), this.f25871b.get(1), this.f25871b.get(2)};
        }
        throw NotFoundException.getNotFoundInstance();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final f e(Map<DecodeHintType, ?> map) throws NotFoundException {
        boolean z10 = map != null && map.containsKey(DecodeHintType.TRY_HARDER);
        boolean z11 = map != null && map.containsKey(DecodeHintType.PURE_BARCODE);
        int g10 = this.f25870a.g();
        int k10 = this.f25870a.k();
        int i10 = (g10 * 3) / 228;
        if (i10 < 3 || z10) {
            i10 = 3;
        }
        int[] iArr = new int[5];
        int i11 = i10 - 1;
        boolean z12 = false;
        while (i11 < g10 && !z12) {
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            iArr[3] = 0;
            iArr[4] = 0;
            int i12 = 0;
            int i13 = 0;
            while (i12 < k10) {
                if (this.f25870a.d(i12, i11)) {
                    if ((i13 & 1) == 1) {
                        i13++;
                    }
                    iArr[i13] = iArr[i13] + 1;
                } else if ((i13 & 1) != 0) {
                    iArr[i13] = iArr[i13] + 1;
                } else if (i13 == 4) {
                    if (!g(iArr)) {
                        iArr[0] = iArr[2];
                        iArr[1] = iArr[3];
                        iArr[2] = iArr[4];
                        iArr[3] = 1;
                        iArr[4] = 0;
                    } else if (i(iArr, i11, i12, z11)) {
                        if (this.f25872c) {
                            z12 = j();
                        } else {
                            int f10 = f();
                            if (f10 > iArr[2]) {
                                i11 += (f10 - iArr[2]) - 2;
                                i12 = k10 - 1;
                            }
                        }
                        iArr[0] = 0;
                        iArr[1] = 0;
                        iArr[2] = 0;
                        iArr[3] = 0;
                        iArr[4] = 0;
                        i13 = 0;
                        i10 = 2;
                    } else {
                        iArr[0] = iArr[2];
                        iArr[1] = iArr[3];
                        iArr[2] = iArr[4];
                        iArr[3] = 1;
                        iArr[4] = 0;
                    }
                    i13 = 3;
                } else {
                    i13++;
                    iArr[i13] = iArr[i13] + 1;
                }
                i12++;
            }
            if (g(iArr) && i(iArr, i11, k10, z11)) {
                i10 = iArr[0];
                if (this.f25872c) {
                    z12 = j();
                }
            }
            i11 += i10;
        }
        d[] k11 = k();
        i.e(k11);
        return new f(k11);
    }

    protected final boolean i(int[] iArr, int i10, int i11, boolean z10) {
        boolean z11 = false;
        int i12 = iArr[0] + iArr[1] + iArr[2] + iArr[3] + iArr[4];
        int a10 = (int) a(iArr, i11);
        float d10 = d(i10, a10, iArr[2], i12);
        if (!Float.isNaN(d10)) {
            int i13 = (int) d10;
            float c10 = c(a10, i13, iArr[2], i12);
            if (!Float.isNaN(c10) && (!z10 || b(i13, (int) c10, iArr[2], i12))) {
                float f10 = i12 / 7.0f;
                int i14 = 0;
                while (true) {
                    if (i14 >= this.f25871b.size()) {
                        break;
                    }
                    d dVar = this.f25871b.get(i14);
                    if (dVar.f(f10, d10, c10)) {
                        this.f25871b.set(i14, dVar.g(d10, c10, f10));
                        z11 = true;
                        break;
                    }
                    i14++;
                }
                if (!z11) {
                    d dVar2 = new d(c10, d10, f10);
                    this.f25871b.add(dVar2);
                    j jVar = this.f25874e;
                    if (jVar != null) {
                        jVar.a(dVar2);
                    }
                }
                return true;
            }
        }
        return false;
    }
}
