package com.google.android.gms.internal.measurement;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import android.util.Pair;
import androidx.collection.a;
import b6.i;
import com.mobvoi.wear.lpa.LpaConstants;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class x extends i5 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public x(j5 j5Var) {
        super(j5Var);
    }

    private final Boolean A(long j10, x5 x5Var) {
        try {
            return F(new BigDecimal(j10), x5Var, 0.0d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    private static Boolean B(Boolean bool, boolean z10) {
        if (bool == null) {
            return null;
        }
        return Boolean.valueOf(bool.booleanValue() ^ z10);
    }

    private final Boolean C(String str, int i10, boolean z10, String str2, List<String> list, String str3) {
        boolean startsWith;
        if (str == null) {
            return null;
        }
        if (i10 == 6) {
            if (list == null || list.size() == 0) {
                return null;
            }
        } else if (str2 == null) {
            return null;
        }
        if (!z10 && i10 != 1) {
            str = str.toUpperCase(Locale.ENGLISH);
        }
        switch (i10) {
            case 1:
                try {
                    return Boolean.valueOf(Pattern.compile(str3, z10 ? 0 : 66).matcher(str).matches());
                } catch (PatternSyntaxException unused) {
                    c().N().d("Invalid regular expression in REGEXP audience filter. expression", str3);
                    return null;
                }
            case 2:
                startsWith = str.startsWith(str2);
                break;
            case 3:
                startsWith = str.endsWith(str2);
                break;
            case 4:
                startsWith = str.contains(str2);
                break;
            case 5:
                startsWith = str.equals(str2);
                break;
            case 6:
                startsWith = list.contains(str);
                break;
            default:
                return null;
        }
        return Boolean.valueOf(startsWith);
    }

    private final Boolean D(String str, x5 x5Var) {
        if (!r5.l0(str)) {
            return null;
        }
        try {
            return F(new BigDecimal(str), x5Var, 0.0d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    private final Boolean E(String str, z5 z5Var) {
        Integer num;
        List<String> list;
        i.k(z5Var);
        if (str == null || (num = z5Var.f9855c) == null || num.intValue() == 0) {
            return null;
        }
        if (z5Var.f9855c.intValue() == 6) {
            String[] strArr = z5Var.f9858f;
            if (strArr == null || strArr.length == 0) {
                return null;
            }
        } else if (z5Var.f9856d == null) {
            return null;
        }
        int intValue = z5Var.f9855c.intValue();
        Boolean bool = z5Var.f9857e;
        boolean z10 = bool != null && bool.booleanValue();
        String upperCase = (z10 || intValue == 1 || intValue == 6) ? z5Var.f9856d : z5Var.f9856d.toUpperCase(Locale.ENGLISH);
        String[] strArr2 = z5Var.f9858f;
        if (strArr2 == null) {
            list = null;
        } else if (z10) {
            list = Arrays.asList(strArr2);
        } else {
            ArrayList arrayList = new ArrayList();
            for (String str2 : strArr2) {
                arrayList.add(str2.toUpperCase(Locale.ENGLISH));
            }
            list = arrayList;
        }
        return C(str, intValue, z10, upperCase, list, intValue == 1 ? upperCase : null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x006f, code lost:
        if (r3 != null) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Boolean F(BigDecimal bigDecimal, x5 x5Var, double d10) {
        BigDecimal bigDecimal2;
        BigDecimal bigDecimal3;
        BigDecimal bigDecimal4;
        i.k(x5Var);
        Integer num = x5Var.f9801c;
        if (!(num == null || num.intValue() == 0)) {
            if (x5Var.f9801c.intValue() == 4) {
                if (x5Var.f9804f == null || x5Var.f9805g == null) {
                    return null;
                }
            } else if (x5Var.f9803e == null) {
                return null;
            }
            int intValue = x5Var.f9801c.intValue();
            if (x5Var.f9801c.intValue() == 4) {
                if (r5.l0(x5Var.f9804f) && r5.l0(x5Var.f9805g)) {
                    try {
                        bigDecimal2 = new BigDecimal(x5Var.f9804f);
                        bigDecimal3 = new BigDecimal(x5Var.f9805g);
                        bigDecimal4 = null;
                    } catch (NumberFormatException unused) {
                    }
                }
                return null;
            } else if (!r5.l0(x5Var.f9803e)) {
                return null;
            } else {
                try {
                    bigDecimal4 = new BigDecimal(x5Var.f9803e);
                    bigDecimal2 = null;
                    bigDecimal3 = null;
                } catch (NumberFormatException unused2) {
                }
            }
            if (intValue == 4) {
                if (bigDecimal2 == null) {
                    return null;
                }
            }
            boolean z10 = false;
            if (intValue == 1) {
                if (bigDecimal.compareTo(bigDecimal4) == -1) {
                    z10 = true;
                }
                return Boolean.valueOf(z10);
            } else if (intValue == 2) {
                if (bigDecimal.compareTo(bigDecimal4) == 1) {
                    z10 = true;
                }
                return Boolean.valueOf(z10);
            } else if (intValue != 3) {
                if (intValue == 4) {
                    if (!(bigDecimal.compareTo(bigDecimal2) == -1 || bigDecimal.compareTo(bigDecimal3) == 1)) {
                        z10 = true;
                    }
                    return Boolean.valueOf(z10);
                }
            } else if (d10 != 0.0d) {
                if (bigDecimal.compareTo(bigDecimal4.subtract(new BigDecimal(d10).multiply(new BigDecimal(2)))) == 1 && bigDecimal.compareTo(bigDecimal4.add(new BigDecimal(d10).multiply(new BigDecimal(2)))) == -1) {
                    z10 = true;
                }
                return Boolean.valueOf(z10);
            } else {
                if (bigDecimal.compareTo(bigDecimal4) == 0) {
                    z10 = true;
                }
                return Boolean.valueOf(z10);
            }
        }
        return null;
    }

    private final Boolean z(double d10, x5 x5Var) {
        try {
            return F(new BigDecimal(d10), x5Var, Math.ulp(d10));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0386  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x03a6  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x06f9  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x06fc  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0704  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x070c  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x09e6  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x09e9  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x09f1  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x0a08  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x030a  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x035c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final d6[] G(String str, e6[] e6VarArr, j6[] j6VarArr) {
        String str2;
        Object obj;
        b1 b1Var;
        Object e10;
        int f10;
        byte[] bArr;
        ContentValues contentValues;
        String str3;
        Iterator<y5> it;
        String str4;
        a aVar;
        Boolean bool;
        String str5;
        String str6;
        b1 b1Var2;
        Boolean E;
        a aVar2;
        a aVar3;
        String str7;
        a aVar4;
        int i10;
        int i11;
        String str8;
        HashSet hashSet;
        String str9;
        x xVar;
        String str10;
        a aVar5;
        HashSet hashSet2;
        int i12;
        String str11;
        l0 m02;
        String str12;
        a aVar6;
        HashSet hashSet3;
        f6[] f6VarArr;
        l0 l0Var;
        String str13;
        Map<Integer, List<v5>> map;
        Iterator<Integer> it2;
        a aVar7;
        Iterator<v5> it3;
        Iterator<Integer> it4;
        String str14;
        a aVar8;
        long j10;
        Boolean bool2;
        b1 N;
        String M;
        String N2;
        String str15;
        Boolean bool3;
        Boolean z10;
        Boolean A;
        e6 e6Var;
        Long l10;
        String str16;
        HashSet hashSet4;
        e6 e6Var2;
        e6 e6Var3;
        e6 e6Var4;
        int length;
        int i13;
        int i14;
        boolean z11;
        SQLiteException e11;
        SQLiteDatabase B;
        String[] strArr;
        Object obj2;
        Map<Integer, i6> map2;
        a aVar9;
        Iterator<Integer> it5;
        x xVar2 = this;
        String str17 = str;
        e6[] e6VarArr2 = e6VarArr;
        i.g(str);
        HashSet hashSet5 = new HashSet();
        a aVar10 = new a();
        a aVar11 = new a();
        a aVar12 = new a();
        Map<Integer, i6> i02 = u().i0(str17);
        if (i02 != null) {
            Iterator<Integer> it6 = i02.keySet().iterator();
            while (it6.hasNext()) {
                int intValue = it6.next().intValue();
                i6 i6Var = i02.get(Integer.valueOf(intValue));
                BitSet bitSet = (BitSet) aVar11.get(Integer.valueOf(intValue));
                BitSet bitSet2 = (BitSet) aVar12.get(Integer.valueOf(intValue));
                if (bitSet == null) {
                    bitSet = new BitSet();
                    aVar11.put(Integer.valueOf(intValue), bitSet);
                    bitSet2 = new BitSet();
                    aVar12.put(Integer.valueOf(intValue), bitSet2);
                }
                int i15 = 0;
                while (true) {
                    long[] jArr = i6Var.f9371c;
                    map2 = i02;
                    if (i15 < (jArr.length << 6)) {
                        if (r5.T(jArr, i15)) {
                            it5 = it6;
                            aVar9 = aVar11;
                            c().R().c("Filter already evaluated. audience ID, filter ID", Integer.valueOf(intValue), Integer.valueOf(i15));
                            bitSet2.set(i15);
                            if (r5.T(i6Var.f9372d, i15)) {
                                bitSet.set(i15);
                            }
                        } else {
                            it5 = it6;
                            aVar9 = aVar11;
                        }
                        i15++;
                        i02 = map2;
                        it6 = it5;
                        aVar11 = aVar9;
                    }
                }
                it6 = it6;
                d6 d6Var = new d6();
                aVar10.put(Integer.valueOf(intValue), d6Var);
                d6Var.f9237f = Boolean.FALSE;
                d6Var.f9236e = i6Var;
                i6 i6Var2 = new i6();
                d6Var.f9235d = i6Var2;
                i6Var2.f9372d = r5.W(bitSet);
                d6Var.f9235d.f9371c = r5.W(bitSet2);
                i02 = map2;
            }
        }
        a aVar13 = aVar11;
        String str18 = "Filter definition";
        String str19 = "Skipping failed audience ID";
        if (e6VarArr2 != null) {
            a aVar14 = new a();
            int length2 = e6VarArr2.length;
            long j11 = 0;
            e6 e6Var5 = null;
            int i16 = 0;
            Long l11 = null;
            while (i16 < length2) {
                e6 e6Var6 = e6VarArr2[i16];
                String str20 = str18;
                String str21 = e6Var6.f9258d;
                a aVar15 = aVar12;
                f6[] f6VarArr2 = e6Var6.f9257c;
                if (s().H(str17, p0.P)) {
                    p();
                    Long l12 = (Long) r5.Y(e6Var6, "_eid");
                    boolean z12 = l12 != null;
                    i10 = i16;
                    if (z12 && str21.equals("_ep")) {
                        p();
                        String str22 = (String) r5.Y(e6Var6, "_en");
                        if (TextUtils.isEmpty(str22)) {
                            c().K().d("Extra parameter without an event name. eventId", l12);
                            e6Var2 = e6Var5;
                            i11 = length2;
                            aVar4 = aVar14;
                            str16 = str19;
                            hashSet4 = hashSet5;
                        } else {
                            if (e6Var5 == null || l11 == null || l12.longValue() != l11.longValue()) {
                                Pair<e6, Long> G = u().G(str17, l12);
                                e6Var2 = e6Var5;
                                if (G == null || (obj2 = G.first) == null) {
                                    i11 = length2;
                                    aVar4 = aVar14;
                                    str16 = str19;
                                    hashSet4 = hashSet5;
                                    c().K().c("Extra parameter without existing main event. eventName, eventId", str22, l12);
                                } else {
                                    e6 e6Var7 = (e6) obj2;
                                    j11 = ((Long) G.second).longValue();
                                    p();
                                    l11 = (Long) r5.Y(e6Var7, "_eid");
                                    e6Var3 = e6Var7;
                                }
                            } else {
                                e6Var3 = e6Var5;
                            }
                            j11--;
                            if (j11 <= 0) {
                                d0 u10 = u();
                                u10.e();
                                u10.c().R().d("Clearing complex main event info. appId", str17);
                                try {
                                    B = u10.B();
                                    i11 = length2;
                                    hashSet2 = hashSet5;
                                    z11 = true;
                                    try {
                                        strArr = new String[1];
                                        i12 = 0;
                                    } catch (SQLiteException e12) {
                                        e11 = e12;
                                        i12 = 0;
                                        u10.c().K().d("Error clearing complex main event", e11);
                                        aVar5 = aVar14;
                                        str10 = str19;
                                        e6Var4 = e6Var3;
                                        f6[] f6VarArr3 = e6Var4.f9257c;
                                        int length3 = f6VarArr3.length + f6VarArr2.length;
                                        f6[] f6VarArr4 = new f6[length3];
                                        length = f6VarArr3.length;
                                        i13 = i12;
                                        i14 = i13;
                                        while (i13 < length) {
                                        }
                                        if (i14 > 0) {
                                        }
                                        e6Var5 = e6Var4;
                                        str11 = str22;
                                        m02 = u().m0(str17, e6Var6.f9258d);
                                        if (m02 != null) {
                                        }
                                        u().M(l0Var);
                                        long j12 = l0Var.f9472c;
                                        a aVar16 = aVar5;
                                        String str23 = str12;
                                        map = (Map) aVar16.get(str23);
                                        if (map == null) {
                                        }
                                        it2 = map.keySet().iterator();
                                        while (it2.hasNext()) {
                                        }
                                        xVar = this;
                                        str9 = str13;
                                        aVar4 = aVar16;
                                        str8 = str10;
                                        hashSet = hashSet3;
                                        aVar10 = aVar6;
                                        i16 = i10 + 1;
                                        e6VarArr2 = e6VarArr;
                                        xVar2 = xVar;
                                        str17 = str9;
                                        str19 = str8;
                                        length2 = i11;
                                        aVar14 = aVar4;
                                        str18 = str7;
                                        aVar13 = aVar3;
                                        hashSet5 = hashSet;
                                        aVar12 = aVar2;
                                    }
                                } catch (SQLiteException e13) {
                                    e11 = e13;
                                    i11 = length2;
                                    hashSet2 = hashSet5;
                                    z11 = true;
                                }
                                try {
                                    strArr[0] = str17;
                                    B.execSQL("delete from main_event_params where app_id=?", strArr);
                                } catch (SQLiteException e14) {
                                    e11 = e14;
                                    u10.c().K().d("Error clearing complex main event", e11);
                                    aVar5 = aVar14;
                                    str10 = str19;
                                    e6Var4 = e6Var3;
                                    f6[] f6VarArr32 = e6Var4.f9257c;
                                    int length32 = f6VarArr32.length + f6VarArr2.length;
                                    f6[] f6VarArr42 = new f6[length32];
                                    length = f6VarArr32.length;
                                    i13 = i12;
                                    i14 = i13;
                                    while (i13 < length) {
                                    }
                                    if (i14 > 0) {
                                    }
                                    e6Var5 = e6Var4;
                                    str11 = str22;
                                    m02 = u().m0(str17, e6Var6.f9258d);
                                    if (m02 != null) {
                                    }
                                    u().M(l0Var);
                                    long j122 = l0Var.f9472c;
                                    a aVar162 = aVar5;
                                    String str232 = str12;
                                    map = (Map) aVar162.get(str232);
                                    if (map == null) {
                                    }
                                    it2 = map.keySet().iterator();
                                    while (it2.hasNext()) {
                                    }
                                    xVar = this;
                                    str9 = str13;
                                    aVar4 = aVar162;
                                    str8 = str10;
                                    hashSet = hashSet3;
                                    aVar10 = aVar6;
                                    i16 = i10 + 1;
                                    e6VarArr2 = e6VarArr;
                                    xVar2 = xVar;
                                    str17 = str9;
                                    str19 = str8;
                                    length2 = i11;
                                    aVar14 = aVar4;
                                    str18 = str7;
                                    aVar13 = aVar3;
                                    hashSet5 = hashSet;
                                    aVar12 = aVar2;
                                }
                                aVar5 = aVar14;
                                str10 = str19;
                                e6Var4 = e6Var3;
                            } else {
                                i11 = length2;
                                hashSet2 = hashSet5;
                                i12 = 0;
                                aVar5 = aVar14;
                                str10 = str19;
                                e6 e6Var8 = e6Var3;
                                u().X(str, l12, j11, e6Var8);
                                e6Var4 = e6Var8;
                            }
                            f6[] f6VarArr322 = e6Var4.f9257c;
                            int length322 = f6VarArr322.length + f6VarArr2.length;
                            f6[] f6VarArr422 = new f6[length322];
                            length = f6VarArr322.length;
                            i13 = i12;
                            i14 = i13;
                            while (i13 < length) {
                                f6 f6Var = f6VarArr322[i13];
                                p();
                                f6VarArr322 = f6VarArr322;
                                if (r5.E(e6Var6, f6Var.f9274c) == null) {
                                    i14++;
                                    f6VarArr422[i14] = f6Var;
                                }
                                i13++;
                            }
                            if (i14 > 0) {
                                int length4 = f6VarArr2.length;
                                for (int i17 = i12; i17 < length4; i17++) {
                                    i14++;
                                    f6VarArr422[i14] = f6VarArr2[i17];
                                }
                                f6VarArr2 = i14 == length322 ? f6VarArr422 : (f6[]) Arrays.copyOf(f6VarArr422, i14);
                            } else {
                                c().N().d("No unique parameters in main event. eventName", str22);
                            }
                            e6Var5 = e6Var4;
                            str11 = str22;
                        }
                        xVar = xVar2;
                        str9 = str17;
                        aVar3 = aVar13;
                        str7 = str20;
                        aVar2 = aVar15;
                        e6Var5 = e6Var2;
                        hashSet = hashSet4;
                        str8 = str16;
                        i16 = i10 + 1;
                        e6VarArr2 = e6VarArr;
                        xVar2 = xVar;
                        str17 = str9;
                        str19 = str8;
                        length2 = i11;
                        aVar14 = aVar4;
                        str18 = str7;
                        aVar13 = aVar3;
                        hashSet5 = hashSet;
                        aVar12 = aVar2;
                    } else {
                        e6Var = e6Var5;
                        i11 = length2;
                        aVar5 = aVar14;
                        str10 = str19;
                        hashSet2 = hashSet5;
                        i12 = 0;
                        if (z12) {
                            p();
                            Object obj3 = 0L;
                            Object Y = r5.Y(e6Var6, "_epc");
                            if (Y != null) {
                                obj3 = Y;
                            }
                            j11 = ((Long) obj3).longValue();
                            if (j11 <= 0) {
                                c().N().d("Complex event with zero extra param count. eventName", str21);
                                l10 = l12;
                            } else {
                                l10 = l12;
                                u().X(str, l12, j11, e6Var6);
                            }
                            str11 = str21;
                            e6Var5 = e6Var6;
                            l11 = l10;
                        }
                    }
                    m02 = u().m0(str17, e6Var6.f9258d);
                    if (m02 != null) {
                        c().N().c("Event aggregate wasn't created during raw event logging. appId, event", z0.I(str), o().M(str11));
                        str7 = str20;
                        f6VarArr = f6VarArr2;
                        aVar3 = aVar13;
                        aVar2 = aVar15;
                        str12 = str11;
                        aVar6 = aVar10;
                        hashSet3 = hashSet2;
                        str13 = str17;
                        l0Var = new l0(str, e6Var6.f9258d, 1L, 1L, e6Var6.f9259e.longValue(), 0L, null, null, null);
                    } else {
                        f6VarArr = f6VarArr2;
                        str12 = str11;
                        aVar6 = aVar10;
                        str13 = str17;
                        aVar3 = aVar13;
                        str7 = str20;
                        aVar2 = aVar15;
                        hashSet3 = hashSet2;
                        l0Var = m02.d();
                    }
                    u().M(l0Var);
                    long j1222 = l0Var.f9472c;
                    a aVar1622 = aVar5;
                    String str2322 = str12;
                    map = (Map) aVar1622.get(str2322);
                    if (map == null) {
                        map = u().G0(str13, str2322);
                        if (map == null) {
                            map = new a<>();
                        }
                        aVar1622.put(str2322, map);
                    }
                    it2 = map.keySet().iterator();
                    while (it2.hasNext()) {
                        int intValue2 = it2.next().intValue();
                        HashSet hashSet6 = hashSet3;
                        if (hashSet6.contains(Integer.valueOf(intValue2))) {
                            c().R().d(str10, Integer.valueOf(intValue2));
                            hashSet3 = hashSet6;
                        } else {
                            str10 = str10;
                            a aVar17 = aVar6;
                            d6 d6Var2 = (d6) aVar17.get(Integer.valueOf(intValue2));
                            a aVar18 = aVar3;
                            BitSet bitSet3 = (BitSet) aVar18.get(Integer.valueOf(intValue2));
                            a aVar19 = aVar2;
                            BitSet bitSet4 = (BitSet) aVar19.get(Integer.valueOf(intValue2));
                            if (d6Var2 == null) {
                                d6 d6Var3 = new d6();
                                aVar17.put(Integer.valueOf(intValue2), d6Var3);
                                d6Var3.f9237f = Boolean.TRUE;
                                bitSet3 = new BitSet();
                                aVar18.put(Integer.valueOf(intValue2), bitSet3);
                                bitSet4 = new BitSet();
                                aVar19.put(Integer.valueOf(intValue2), bitSet4);
                            }
                            Iterator<v5> it7 = map.get(Integer.valueOf(intValue2)).iterator();
                            while (it7.hasNext()) {
                                e6 e6Var9 = e6Var5;
                                v5 next = it7.next();
                                a aVar20 = aVar1622;
                                Map<Integer, List<v5>> map3 = map;
                                if (c().z(2)) {
                                    it4 = it2;
                                    it3 = it7;
                                    aVar7 = aVar19;
                                    c().R().b("Evaluating filter. audience, filter, event", Integer.valueOf(intValue2), next.f9750c, o().M(next.f9751d));
                                    str14 = str7;
                                    c().R().d(str14, o().A(next));
                                } else {
                                    aVar7 = aVar19;
                                    it4 = it2;
                                    it3 = it7;
                                    str14 = str7;
                                }
                                Integer num = next.f9750c;
                                if (num == null || num.intValue() > 256) {
                                    j10 = j1222;
                                    str7 = str14;
                                    aVar8 = aVar18;
                                    c().N().c("Invalid event filter ID. appId, id", z0.I(str), String.valueOf(next.f9750c));
                                } else if (bitSet3.get(next.f9750c.intValue())) {
                                    c().R().c("Event filter already evaluated true. audience ID, filter ID", Integer.valueOf(intValue2), next.f9750c);
                                    str7 = str14;
                                    map = map3;
                                    e6Var5 = e6Var9;
                                    it2 = it4;
                                    it7 = it3;
                                    aVar1622 = aVar20;
                                    aVar19 = aVar7;
                                } else {
                                    x5 x5Var = next.f9754g;
                                    if (x5Var != null) {
                                        Boolean A2 = A(j1222, x5Var);
                                        if (A2 == null) {
                                            j10 = j1222;
                                            str7 = str14;
                                            aVar8 = aVar18;
                                            bool2 = null;
                                            c().R().d("Event filter result", bool2 == null ? LpaConstants.VALUE_NULL : bool2);
                                            if (bool2 == null) {
                                                hashSet6.add(Integer.valueOf(intValue2));
                                            } else {
                                                bitSet4.set(next.f9750c.intValue());
                                                if (bool2.booleanValue()) {
                                                    bitSet3.set(next.f9750c.intValue());
                                                }
                                            }
                                        } else if (!A2.booleanValue()) {
                                            bool2 = Boolean.FALSE;
                                            j10 = j1222;
                                            str7 = str14;
                                            aVar8 = aVar18;
                                            c().R().d("Event filter result", bool2 == null ? LpaConstants.VALUE_NULL : bool2);
                                            if (bool2 == null) {
                                            }
                                        }
                                    }
                                    HashSet hashSet7 = new HashSet();
                                    w5[] w5VarArr = next.f9752e;
                                    j10 = j1222;
                                    int length5 = w5VarArr.length;
                                    for (int i18 = 0; i18 < length5; i18++) {
                                        length5 = length5;
                                        w5 w5Var = w5VarArr[i18];
                                        w5VarArr = w5VarArr;
                                        if (TextUtils.isEmpty(w5Var.f9783f)) {
                                            c().N().d("null or empty param name in filter. event", o().M(str2322));
                                            str7 = str14;
                                            break;
                                        }
                                        hashSet7.add(w5Var.f9783f);
                                    }
                                    a aVar21 = new a();
                                    f6[] f6VarArr5 = f6VarArr;
                                    int length6 = f6VarArr5.length;
                                    str7 = str14;
                                    int i19 = 0;
                                    while (true) {
                                        if (i19 < length6) {
                                            length6 = length6;
                                            f6 f6Var2 = f6VarArr5[i19];
                                            f6VarArr = f6VarArr5;
                                            if (hashSet7.contains(f6Var2.f9274c)) {
                                                Object obj4 = f6Var2.f9276e;
                                                if (obj4 == null && (obj4 = f6Var2.f9278g) == null && (obj4 = f6Var2.f9275d) == null) {
                                                    c().N().c("Unknown value for param. event, param", o().M(str2322), o().N(f6Var2.f9274c));
                                                    break;
                                                }
                                                aVar21.put(f6Var2.f9274c, obj4);
                                            }
                                            i19++;
                                            f6VarArr5 = f6VarArr;
                                        } else {
                                            f6VarArr = f6VarArr5;
                                            w5[] w5VarArr2 = next.f9752e;
                                            int length7 = w5VarArr2.length;
                                            int i20 = 0;
                                            while (i20 < length7) {
                                                w5 w5Var2 = w5VarArr2[i20];
                                                w5VarArr2 = w5VarArr2;
                                                length7 = length7;
                                                boolean equals = Boolean.TRUE.equals(w5Var2.f9782e);
                                                String str24 = w5Var2.f9783f;
                                                if (TextUtils.isEmpty(str24)) {
                                                    c().N().d("Event has empty param name. event", o().M(str2322));
                                                } else {
                                                    aVar8 = aVar18;
                                                    V v10 = aVar21.get(str24);
                                                    aVar21 = aVar21;
                                                    if (v10 instanceof Long) {
                                                        if (w5Var2.f9781d == null) {
                                                            N = c().N();
                                                            M = o().M(str2322);
                                                            N2 = o().N(str24);
                                                            str15 = "No number filter for long param. event, param";
                                                            N.c(str15, M, N2);
                                                        } else {
                                                            if (A(((Long) v10).longValue(), w5Var2.f9781d) != null) {
                                                                if (equals ^ (!A.booleanValue())) {
                                                                    bool2 = Boolean.FALSE;
                                                                    break;
                                                                }
                                                                i20++;
                                                                aVar18 = aVar8;
                                                            }
                                                        }
                                                    } else if (v10 instanceof Double) {
                                                        if (w5Var2.f9781d == null) {
                                                            N = c().N();
                                                            M = o().M(str2322);
                                                            N2 = o().N(str24);
                                                            str15 = "No number filter for double param. event, param";
                                                            N.c(str15, M, N2);
                                                        } else {
                                                            if (z(((Double) v10).doubleValue(), w5Var2.f9781d) != null) {
                                                                if (equals ^ (!z10.booleanValue())) {
                                                                    bool2 = Boolean.FALSE;
                                                                    break;
                                                                }
                                                                i20++;
                                                                aVar18 = aVar8;
                                                            }
                                                        }
                                                    } else if (v10 instanceof String) {
                                                        z5 z5Var = w5Var2.f9780c;
                                                        if (z5Var != null) {
                                                            bool3 = E((String) v10, z5Var);
                                                        } else {
                                                            if (w5Var2.f9781d != null) {
                                                                String str25 = (String) v10;
                                                                if (r5.l0(str25)) {
                                                                    bool3 = D(str25, w5Var2.f9781d);
                                                                } else {
                                                                    N = c().N();
                                                                    M = o().M(str2322);
                                                                    N2 = o().N(str24);
                                                                    str15 = "Invalid param value for number filter. event, param";
                                                                }
                                                            } else {
                                                                N = c().N();
                                                                M = o().M(str2322);
                                                                N2 = o().N(str24);
                                                                str15 = "No filter for String param. event, param";
                                                            }
                                                            N.c(str15, M, N2);
                                                        }
                                                        if (bool3 != null) {
                                                            if (equals ^ (!bool3.booleanValue())) {
                                                                bool2 = Boolean.FALSE;
                                                                break;
                                                            }
                                                            i20++;
                                                            aVar18 = aVar8;
                                                        }
                                                    } else {
                                                        z0 c10 = c();
                                                        if (v10 == 0) {
                                                            c10.R().c("Missing param for filter. event, param", o().M(str2322), o().N(str24));
                                                            bool2 = Boolean.FALSE;
                                                            break;
                                                        }
                                                        N = c10.N();
                                                        M = o().M(str2322);
                                                        N2 = o().N(str24);
                                                        str15 = "Unknown param type. event, param";
                                                        N.c(str15, M, N2);
                                                    }
                                                }
                                            }
                                            aVar8 = aVar18;
                                            bool2 = Boolean.TRUE;
                                        }
                                    }
                                    aVar8 = aVar18;
                                    bool2 = null;
                                    c().R().d("Event filter result", bool2 == null ? LpaConstants.VALUE_NULL : bool2);
                                    if (bool2 == null) {
                                    }
                                }
                                map = map3;
                                e6Var5 = e6Var9;
                                it2 = it4;
                                it7 = it3;
                                j1222 = j10;
                                aVar1622 = aVar20;
                                aVar18 = aVar8;
                                aVar19 = aVar7;
                            }
                            it2 = it2;
                            aVar2 = aVar19;
                            hashSet3 = hashSet6;
                            aVar6 = aVar17;
                            aVar3 = aVar18;
                            str13 = str;
                        }
                    }
                    xVar = this;
                    str9 = str13;
                    aVar4 = aVar1622;
                    str8 = str10;
                    hashSet = hashSet3;
                    aVar10 = aVar6;
                    i16 = i10 + 1;
                    e6VarArr2 = e6VarArr;
                    xVar2 = xVar;
                    str17 = str9;
                    str19 = str8;
                    length2 = i11;
                    aVar14 = aVar4;
                    str18 = str7;
                    aVar13 = aVar3;
                    hashSet5 = hashSet;
                    aVar12 = aVar2;
                } else {
                    e6Var = e6Var5;
                    i10 = i16;
                    i11 = length2;
                    aVar5 = aVar14;
                    str10 = str19;
                    hashSet2 = hashSet5;
                    i12 = 0;
                }
                str11 = str21;
                e6Var5 = e6Var;
                m02 = u().m0(str17, e6Var6.f9258d);
                if (m02 != null) {
                }
                u().M(l0Var);
                long j12222 = l0Var.f9472c;
                a aVar16222 = aVar5;
                String str23222 = str12;
                map = (Map) aVar16222.get(str23222);
                if (map == null) {
                }
                it2 = map.keySet().iterator();
                while (it2.hasNext()) {
                }
                xVar = this;
                str9 = str13;
                aVar4 = aVar16222;
                str8 = str10;
                hashSet = hashSet3;
                aVar10 = aVar6;
                i16 = i10 + 1;
                e6VarArr2 = e6VarArr;
                xVar2 = xVar;
                str17 = str9;
                str19 = str8;
                length2 = i11;
                aVar14 = aVar4;
                str18 = str7;
                aVar13 = aVar3;
                hashSet5 = hashSet;
                aVar12 = aVar2;
            }
        }
        x xVar3 = xVar2;
        String str26 = str18;
        a aVar22 = aVar12;
        HashSet hashSet8 = hashSet5;
        String str27 = str17;
        a aVar23 = aVar13;
        String str28 = str19;
        j6[] j6VarArr2 = j6VarArr;
        if (j6VarArr2 != null) {
            a aVar24 = new a();
            int length8 = j6VarArr2.length;
            int i21 = 0;
            while (i21 < length8) {
                j6 j6Var = j6VarArr2[i21];
                Map<Integer, List<y5>> map4 = (Map) aVar24.get(j6Var.f9413d);
                if (map4 == null) {
                    map4 = u().H0(str27, j6Var.f9413d);
                    if (map4 == null) {
                        map4 = new a<>();
                    }
                    aVar24.put(j6Var.f9413d, map4);
                }
                Iterator<Integer> it8 = map4.keySet().iterator();
                while (it8.hasNext()) {
                    int intValue3 = it8.next().intValue();
                    if (hashSet8.contains(Integer.valueOf(intValue3))) {
                        c().R().d(str28, Integer.valueOf(intValue3));
                    } else {
                        d6 d6Var4 = (d6) aVar10.get(Integer.valueOf(intValue3));
                        a aVar25 = aVar23;
                        BitSet bitSet5 = (BitSet) aVar25.get(Integer.valueOf(intValue3));
                        a aVar26 = aVar24;
                        a aVar27 = aVar22;
                        BitSet bitSet6 = (BitSet) aVar27.get(Integer.valueOf(intValue3));
                        if (d6Var4 == null) {
                            d6 d6Var5 = new d6();
                            aVar10.put(Integer.valueOf(intValue3), d6Var5);
                            d6Var5.f9237f = Boolean.TRUE;
                            bitSet5 = new BitSet();
                            aVar25.put(Integer.valueOf(intValue3), bitSet5);
                            bitSet6 = new BitSet();
                            aVar27.put(Integer.valueOf(intValue3), bitSet6);
                        }
                        Iterator<y5> it9 = map4.get(Integer.valueOf(intValue3)).iterator();
                        while (it9.hasNext()) {
                            int i22 = length8;
                            y5 next2 = it9.next();
                            Map<Integer, List<y5>> map5 = map4;
                            Iterator<Integer> it10 = it8;
                            if (c().z(2)) {
                                str3 = str28;
                                it = it9;
                                c().R().b("Evaluating filter. audience, filter, property", Integer.valueOf(intValue3), next2.f9821c, o().O(next2.f9822d));
                                str4 = str26;
                                c().R().d(str4, o().B(next2));
                            } else {
                                str3 = str28;
                                it = it9;
                                str4 = str26;
                            }
                            Integer num2 = next2.f9821c;
                            if (num2 == null || num2.intValue() > 256) {
                                aVar10 = aVar10;
                                c().N().c("Invalid property filter ID. appId, id", z0.I(str), String.valueOf(next2.f9821c));
                                hashSet8.add(Integer.valueOf(intValue3));
                                aVar24 = aVar26;
                                aVar22 = aVar27;
                                str26 = str4;
                                aVar23 = aVar25;
                                map4 = map5;
                                length8 = i22;
                                it8 = it10;
                                str28 = str3;
                                break;
                            } else if (bitSet5.get(next2.f9821c.intValue())) {
                                c().R().c("Property filter already evaluated true. audience ID, filter ID", Integer.valueOf(intValue3), next2.f9821c);
                                str26 = str4;
                                map4 = map5;
                                length8 = i22;
                                it8 = it10;
                                it9 = it;
                                str28 = str3;
                            } else {
                                w5 w5Var3 = next2.f9823e;
                                if (w5Var3 == null) {
                                    c().N().d("Missing property filter. property", o().O(j6Var.f9413d));
                                } else {
                                    boolean equals2 = Boolean.TRUE.equals(w5Var3.f9782e);
                                    Long l13 = j6Var.f9415f;
                                    if (l13 == null) {
                                        aVar = aVar10;
                                        Double d10 = j6Var.f9417h;
                                        if (d10 == null) {
                                            String str29 = j6Var.f9414e;
                                            if (str29 != null) {
                                                z5 z5Var2 = w5Var3.f9780c;
                                                if (z5Var2 != null) {
                                                    E = xVar3.E(str29, z5Var2);
                                                } else if (w5Var3.f9781d == null) {
                                                    b1Var2 = c().N();
                                                    str6 = o().O(j6Var.f9413d);
                                                    str5 = "No string or number filter defined. property";
                                                } else if (r5.l0(str29)) {
                                                    E = xVar3.D(j6Var.f9414e, w5Var3.f9781d);
                                                } else {
                                                    c().N().c("Invalid user property value for Numeric number filter. property, value", o().O(j6Var.f9413d), j6Var.f9414e);
                                                    bool = null;
                                                    c().R().d("Property filter result", bool == null ? LpaConstants.VALUE_NULL : bool);
                                                    if (bool == null) {
                                                    }
                                                    str26 = str4;
                                                    map4 = map5;
                                                    length8 = i22;
                                                    it8 = it10;
                                                    it9 = it;
                                                    str28 = str3;
                                                    aVar10 = aVar;
                                                }
                                            } else {
                                                b1Var2 = c().N();
                                                str6 = o().O(j6Var.f9413d);
                                                str5 = "User property has no value, property";
                                            }
                                            b1Var2.d(str5, str6);
                                            bool = null;
                                            c().R().d("Property filter result", bool == null ? LpaConstants.VALUE_NULL : bool);
                                            if (bool == null) {
                                            }
                                            str26 = str4;
                                            map4 = map5;
                                            length8 = i22;
                                            it8 = it10;
                                            it9 = it;
                                            str28 = str3;
                                            aVar10 = aVar;
                                        } else if (w5Var3.f9781d == null) {
                                            b1Var2 = c().N();
                                            str6 = o().O(j6Var.f9413d);
                                            str5 = "No number filter for double property. property";
                                            b1Var2.d(str5, str6);
                                            bool = null;
                                            c().R().d("Property filter result", bool == null ? LpaConstants.VALUE_NULL : bool);
                                            if (bool == null) {
                                                hashSet8.add(Integer.valueOf(intValue3));
                                            } else {
                                                bitSet6.set(next2.f9821c.intValue());
                                                if (bool.booleanValue()) {
                                                    bitSet5.set(next2.f9821c.intValue());
                                                }
                                            }
                                            str26 = str4;
                                            map4 = map5;
                                            length8 = i22;
                                            it8 = it10;
                                            it9 = it;
                                            str28 = str3;
                                            aVar10 = aVar;
                                        } else {
                                            E = xVar3.z(d10.doubleValue(), w5Var3.f9781d);
                                        }
                                    } else if (w5Var3.f9781d == null) {
                                        c().N().d("No number filter for long property. property", o().O(j6Var.f9413d));
                                    } else {
                                        aVar = aVar10;
                                        E = xVar3.A(l13.longValue(), w5Var3.f9781d);
                                    }
                                    bool = B(E, equals2);
                                    c().R().d("Property filter result", bool == null ? LpaConstants.VALUE_NULL : bool);
                                    if (bool == null) {
                                    }
                                    str26 = str4;
                                    map4 = map5;
                                    length8 = i22;
                                    it8 = it10;
                                    it9 = it;
                                    str28 = str3;
                                    aVar10 = aVar;
                                }
                                aVar = aVar10;
                                bool = null;
                                c().R().d("Property filter result", bool == null ? LpaConstants.VALUE_NULL : bool);
                                if (bool == null) {
                                }
                                str26 = str4;
                                map4 = map5;
                                length8 = i22;
                                it8 = it10;
                                it9 = it;
                                str28 = str3;
                                aVar10 = aVar;
                            }
                        }
                        aVar24 = aVar26;
                        aVar22 = aVar27;
                        aVar23 = aVar25;
                    }
                }
                i21++;
                str27 = str;
                j6VarArr2 = j6VarArr;
            }
        }
        a aVar28 = aVar10;
        a aVar29 = aVar23;
        a aVar30 = aVar22;
        d6[] d6VarArr = new d6[aVar29.size()];
        int i23 = 0;
        for (K k10 : aVar29.keySet()) {
            int intValue4 = k10.intValue();
            if (!hashSet8.contains(Integer.valueOf(intValue4))) {
                a aVar31 = aVar28;
                d6 d6Var6 = (d6) aVar31.get(Integer.valueOf(intValue4));
                if (d6Var6 == null) {
                    d6Var6 = new d6();
                }
                i23++;
                d6VarArr[i23] = d6Var6;
                d6Var6.f9234c = Integer.valueOf(intValue4);
                i6 i6Var3 = new i6();
                d6Var6.f9235d = i6Var3;
                i6Var3.f9372d = r5.W((BitSet) aVar29.get(Integer.valueOf(intValue4)));
                d6Var6.f9235d.f9371c = r5.W((BitSet) aVar30.get(Integer.valueOf(intValue4)));
                d0 u11 = u();
                i6 i6Var4 = d6Var6.f9235d;
                u11.w();
                u11.e();
                i.g(str);
                i.k(i6Var4);
                try {
                    f10 = i6Var4.f();
                    bArr = new byte[f10];
                } catch (IOException e15) {
                    e10 = e15;
                }
                try {
                    h p10 = h.p(bArr, 0, f10);
                    i6Var4.b(p10);
                    p10.B();
                    contentValues = new ContentValues();
                    contentValues.put("app_id", str);
                    contentValues.put("audience_id", Integer.valueOf(intValue4));
                    contentValues.put("current_results", bArr);
                    try {
                    } catch (SQLiteException e16) {
                        e10 = e16;
                    }
                } catch (IOException e17) {
                    e10 = e17;
                    b1Var = u11.c().K();
                    obj = z0.I(str);
                    str2 = "Configuration loss. Failed to serialize filter results. appId";
                    b1Var.c(str2, obj, e10);
                    aVar28 = aVar31;
                }
                try {
                    if (u11.B().insertWithOnConflict("audience_filter_values", null, contentValues, 5) == -1) {
                        u11.c().K().d("Failed to insert filter results (got -1). appId", z0.I(str));
                    }
                } catch (SQLiteException e18) {
                    e10 = e18;
                    b1Var = u11.c().K();
                    obj = z0.I(str);
                    str2 = "Error storing filter results. appId";
                    b1Var.c(str2, obj, e10);
                    aVar28 = aVar31;
                }
                aVar28 = aVar31;
            }
        }
        return (d6[]) Arrays.copyOf(d6VarArr, i23);
    }

    @Override // com.google.android.gms.internal.measurement.i5
    protected final boolean x() {
        return false;
    }
}
