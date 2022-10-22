package com.alipay.android.phone.mrpc.core;

import android.text.format.Time;
import com.amap.api.services.core.AMapException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    public static final Pattern f6748a = Pattern.compile("([0-9]{1,2})[- ]([A-Za-z]{3,9})[- ]([0-9]{2,4})[ ]([0-9]{1,2}:[0-9][0-9]:[0-9][0-9])");

    /* renamed from: b  reason: collision with root package name */
    public static final Pattern f6749b = Pattern.compile("[ ]([A-Za-z]{3,9})[ ]+([0-9]{1,2})[ ]([0-9]{1,2}:[0-9][0-9]:[0-9][0-9])[ ]([0-9]{2,4})");

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f6750a;

        /* renamed from: b  reason: collision with root package name */
        public int f6751b;

        /* renamed from: c  reason: collision with root package name */
        public int f6752c;

        public a(int i10, int i11, int i12) {
            this.f6750a = i10;
            this.f6751b = i11;
            this.f6752c = i12;
        }
    }

    public static long a(String str) {
        int i10;
        int i11;
        int i12;
        a aVar;
        int i13;
        int i14;
        int i15;
        Matcher matcher = f6748a.matcher(str);
        if (matcher.find()) {
            i10 = b(matcher.group(1));
            i12 = c(matcher.group(2));
            i11 = d(matcher.group(3));
            aVar = e(matcher.group(4));
        } else {
            Matcher matcher2 = f6749b.matcher(str);
            if (matcher2.find()) {
                i12 = c(matcher2.group(1));
                i10 = b(matcher2.group(2));
                aVar = e(matcher2.group(3));
                i11 = d(matcher2.group(4));
            } else {
                throw new IllegalArgumentException();
            }
        }
        if (i11 >= 2038) {
            i14 = 0;
            i13 = 2038;
            i15 = 1;
        } else {
            i15 = i10;
            i14 = i12;
            i13 = i11;
        }
        Time time = new Time("UTC");
        time.set(aVar.f6752c, aVar.f6751b, aVar.f6750a, i15, i14, i13);
        return time.toMillis(false);
    }

    public static int b(String str) {
        return str.length() == 2 ? ((str.charAt(0) - '0') * 10) + (str.charAt(1) - '0') : str.charAt(0) - '0';
    }

    public static int c(String str) {
        int lowerCase = ((Character.toLowerCase(str.charAt(0)) + Character.toLowerCase(str.charAt(1))) + Character.toLowerCase(str.charAt(2))) - 291;
        if (lowerCase == 9) {
            return 11;
        }
        if (lowerCase == 10) {
            return 1;
        }
        if (lowerCase == 22) {
            return 0;
        }
        if (lowerCase == 26) {
            return 7;
        }
        if (lowerCase == 29) {
            return 2;
        }
        if (lowerCase == 32) {
            return 3;
        }
        if (lowerCase == 40) {
            return 6;
        }
        if (lowerCase == 42) {
            return 5;
        }
        if (lowerCase == 48) {
            return 10;
        }
        switch (lowerCase) {
            case 35:
                return 9;
            case 36:
                return 4;
            case 37:
                return 8;
            default:
                throw new IllegalArgumentException();
        }
    }

    public static int d(String str) {
        if (str.length() == 2) {
            int charAt = ((str.charAt(0) - '0') * 10) + (str.charAt(1) - '0');
            return charAt >= 70 ? charAt + AMapException.CODE_AMAP_CLIENT_UNKNOWN_ERROR : charAt + 2000;
        } else if (str.length() == 3) {
            return ((str.charAt(0) - '0') * 100) + ((str.charAt(1) - '0') * 10) + (str.charAt(2) - '0') + AMapException.CODE_AMAP_CLIENT_UNKNOWN_ERROR;
        } else {
            if (str.length() == 4) {
                return ((str.charAt(0) - '0') * 1000) + ((str.charAt(1) - '0') * 100) + ((str.charAt(2) - '0') * 10) + (str.charAt(3) - '0');
            }
            return 1970;
        }
    }

    public static a e(String str) {
        int i10;
        int i11;
        int i12;
        int charAt = str.charAt(0) - '0';
        if (str.charAt(1) != ':') {
            i10 = 2;
            charAt = (charAt * 10) + (str.charAt(1) - '0');
        } else {
            i10 = 1;
        }
        int i13 = i10 + 1 + 1 + 1 + 1;
        return new a(charAt, ((str.charAt(i11) - '0') * 10) + (str.charAt(i12) - '0'), ((str.charAt(i13) - '0') * 10) + (str.charAt(i13 + 1) - '0'));
    }
}
