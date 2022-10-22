package jp;

import gp.b;
import io.m;
import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.jvm.internal.i;
/* compiled from: dates.kt */
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static final a f29656a = new a();

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f29657b;

    /* renamed from: c  reason: collision with root package name */
    private static final DateFormat[] f29658c;

    /* compiled from: dates.kt */
    /* loaded from: classes3.dex */
    public static final class a extends ThreadLocal<DateFormat> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: a */
        public DateFormat initialValue() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
            simpleDateFormat.setLenient(false);
            simpleDateFormat.setTimeZone(b.f27630f);
            return simpleDateFormat;
        }
    }

    static {
        String[] strArr = {"EEE, dd MMM yyyy HH:mm:ss zzz", "EEEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z", "EEE MMM d yyyy HH:mm:ss z"};
        f29657b = strArr;
        f29658c = new DateFormat[strArr.length];
    }

    public static final Date a(String toHttpDateOrNull) {
        i.f(toHttpDateOrNull, "$this$toHttpDateOrNull");
        if (toHttpDateOrNull.length() == 0) {
            return null;
        }
        ParsePosition parsePosition = new ParsePosition(0);
        Date parse = f29656a.get().parse(toHttpDateOrNull, parsePosition);
        if (parsePosition.getIndex() == toHttpDateOrNull.length()) {
            return parse;
        }
        String[] strArr = f29657b;
        synchronized (strArr) {
            int length = strArr.length;
            for (int i10 = 0; i10 < length; i10++) {
                DateFormat[] dateFormatArr = f29658c;
                DateFormat dateFormat = dateFormatArr[i10];
                SimpleDateFormat simpleDateFormat = dateFormat;
                if (dateFormat == null) {
                    SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(f29657b[i10], Locale.US);
                    simpleDateFormat2.setTimeZone(b.f27630f);
                    dateFormatArr[i10] = simpleDateFormat2;
                    simpleDateFormat = simpleDateFormat2;
                }
                parsePosition.setIndex(0);
                Date parse2 = simpleDateFormat.parse(toHttpDateOrNull, parsePosition);
                if (parsePosition.getIndex() != 0) {
                    return parse2;
                }
            }
            m mVar = m.f28349a;
            return null;
        }
    }

    public static final String b(Date toHttpDateString) {
        i.f(toHttpDateString, "$this$toHttpDateString");
        String format = f29656a.get().format(toHttpDateString);
        i.e(format, "STANDARD_DATE_FORMAT.get().format(this)");
        return format;
    }
}
