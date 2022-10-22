package j8;

import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
/* compiled from: ISO8601Utils.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final TimeZone f29446a = TimeZone.getTimeZone("UTC");

    private static boolean c(String str, int i10, char c10) {
        return i10 < str.length() && str.charAt(i10) == c10;
    }

    private static int d(String str, int i10) {
        while (i10 < str.length()) {
            char charAt = str.charAt(i10);
            if (charAt < '0' || charAt > '9') {
                return i10;
            }
            i10++;
        }
        return str.length();
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00cf A[Catch: IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01bc, NumberFormatException -> 0x01be, IndexOutOfBoundsException -> 0x01c0, TryCatch #2 {IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01bc, blocks: (B:3:0x0004, B:5:0x0016, B:6:0x0018, B:8:0x0024, B:9:0x0026, B:11:0x0035, B:13:0x003b, B:17:0x0050, B:19:0x0060, B:20:0x0062, B:22:0x006e, B:23:0x0070, B:25:0x0076, B:29:0x0080, B:34:0x0090, B:36:0x0098, B:40:0x00b0, B:41:0x00b3, B:47:0x00c9, B:49:0x00cf, B:51:0x00d6, B:55:0x00e0, B:56:0x00fb, B:57:0x00fc, B:60:0x0107, B:61:0x0118, B:63:0x0125, B:66:0x012e, B:68:0x014d, B:71:0x015c, B:72:0x017e, B:74:0x0181, B:75:0x0183, B:77:0x01b4, B:78:0x01bb), top: B:90:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01b4 A[Catch: IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01bc, NumberFormatException -> 0x01be, IndexOutOfBoundsException -> 0x01c0, TryCatch #2 {IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01bc, blocks: (B:3:0x0004, B:5:0x0016, B:6:0x0018, B:8:0x0024, B:9:0x0026, B:11:0x0035, B:13:0x003b, B:17:0x0050, B:19:0x0060, B:20:0x0062, B:22:0x006e, B:23:0x0070, B:25:0x0076, B:29:0x0080, B:34:0x0090, B:36:0x0098, B:40:0x00b0, B:41:0x00b3, B:47:0x00c9, B:49:0x00cf, B:51:0x00d6, B:55:0x00e0, B:56:0x00fb, B:57:0x00fc, B:60:0x0107, B:61:0x0118, B:63:0x0125, B:66:0x012e, B:68:0x014d, B:71:0x015c, B:72:0x017e, B:74:0x0181, B:75:0x0183, B:77:0x01b4, B:78:0x01bb), top: B:90:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Date e(String str, ParsePosition parsePosition) throws ParseException {
        String str2;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        TimeZone timeZone;
        char charAt;
        try {
            int index = parsePosition.getIndex();
            int i15 = index + 4;
            int f10 = f(str, index, i15);
            if (c(str, i15, '-')) {
                i15++;
            }
            int i16 = i15 + 2;
            int f11 = f(str, i15, i16);
            if (c(str, i16, '-')) {
                i16++;
            }
            int i17 = i16 + 2;
            int f12 = f(str, i16, i17);
            boolean c10 = c(str, i17, 'T');
            if (c10 || str.length() > i17) {
                if (c10) {
                    int i18 = i17 + 1;
                    int i19 = i18 + 2;
                    int f13 = f(str, i18, i19);
                    if (c(str, i19, ':')) {
                        i19++;
                    }
                    int i20 = i19 + 2;
                    int f14 = f(str, i19, i20);
                    if (c(str, i20, ':')) {
                        i20++;
                    }
                    if (str.length() <= i20 || (charAt = str.charAt(i20)) == 'Z' || charAt == '+' || charAt == '-') {
                        i12 = f14;
                        i11 = 0;
                        i13 = f13;
                        i17 = i20;
                    } else {
                        int i21 = i20 + 2;
                        i10 = f(str, i20, i21);
                        if (i10 > 59 && i10 < 63) {
                            i10 = 59;
                        }
                        if (c(str, i21, '.')) {
                            int i22 = i21 + 1;
                            int d10 = d(str, i22 + 1);
                            int min = Math.min(d10, i22 + 3);
                            int f15 = f(str, i22, min);
                            int i23 = min - i22;
                            if (i23 == 1) {
                                f15 *= 100;
                            } else if (i23 == 2) {
                                f15 *= 10;
                            }
                            i12 = f14;
                            i11 = f15;
                            i13 = f13;
                            i17 = d10;
                        } else {
                            i12 = f14;
                            i13 = f13;
                            i17 = i21;
                            i11 = 0;
                        }
                        if (str.length() <= i17) {
                            char charAt2 = str.charAt(i17);
                            if (charAt2 == 'Z') {
                                timeZone = f29446a;
                                i14 = i17 + 1;
                            } else {
                                if (!(charAt2 == '+' || charAt2 == '-')) {
                                    throw new IndexOutOfBoundsException("Invalid time zone indicator '" + charAt2 + "'");
                                }
                                String substring = str.substring(i17);
                                if (substring.length() < 5) {
                                    substring = substring + "00";
                                }
                                i14 = i17 + substring.length();
                                if (!"+0000".equals(substring) && !"+00:00".equals(substring)) {
                                    String str3 = "GMT" + substring;
                                    TimeZone timeZone2 = TimeZone.getTimeZone(str3);
                                    String id2 = timeZone2.getID();
                                    if (!id2.equals(str3) && !id2.replace(":", "").equals(str3)) {
                                        throw new IndexOutOfBoundsException("Mismatching time zone indicator: " + str3 + " given, resolves to " + timeZone2.getID());
                                    }
                                    timeZone = timeZone2;
                                }
                                timeZone = f29446a;
                            }
                            GregorianCalendar gregorianCalendar = new GregorianCalendar(timeZone);
                            gregorianCalendar.setLenient(false);
                            gregorianCalendar.set(1, f10);
                            gregorianCalendar.set(2, f11 - 1);
                            gregorianCalendar.set(5, f12);
                            gregorianCalendar.set(11, i13);
                            gregorianCalendar.set(12, i12);
                            gregorianCalendar.set(13, i10);
                            gregorianCalendar.set(14, i11);
                            parsePosition.setIndex(i14);
                            return gregorianCalendar.getTime();
                        }
                        throw new IllegalArgumentException("No time zone indicator");
                    }
                } else {
                    i13 = 0;
                    i12 = 0;
                    i11 = 0;
                }
                i10 = 0;
                if (str.length() <= i17) {
                }
            } else {
                GregorianCalendar gregorianCalendar2 = new GregorianCalendar(f10, f11 - 1, f12);
                parsePosition.setIndex(i17);
                return gregorianCalendar2.getTime();
            }
        } catch (IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException e10) {
            if (str == null) {
                str2 = null;
            } else {
                str2 = '\"' + str + '\"';
            }
            String message = e10.getMessage();
            if (message == null || message.isEmpty()) {
                message = "(" + e10.getClass().getName() + ")";
            }
            ParseException parseException = new ParseException("Failed to parse date [" + str2 + "]: " + message, parsePosition.getIndex());
            parseException.initCause(e10);
            throw parseException;
        }
    }

    private static int f(String str, int i10, int i11) throws NumberFormatException {
        int i12;
        if (i10 < 0 || i11 > str.length() || i10 > i11) {
            throw new NumberFormatException(str);
        }
        int i13 = 0;
        if (i10 < i11) {
            i12 = i10 + 1;
            int digit = Character.digit(str.charAt(i10), 10);
            if (digit >= 0) {
                i13 = -digit;
            } else {
                throw new NumberFormatException("Invalid number: " + str.substring(i10, i11));
            }
        } else {
            i12 = i10;
        }
        while (i12 < i11) {
            i12++;
            int digit2 = Character.digit(str.charAt(i12), 10);
            if (digit2 >= 0) {
                i13 = (i13 * 10) - digit2;
            } else {
                throw new NumberFormatException("Invalid number: " + str.substring(i10, i11));
            }
        }
        return -i13;
    }
}
