package com.paypal.android.sdk;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
/* loaded from: classes2.dex */
public class eu extends SimpleDateFormat {

    /* renamed from: a  reason: collision with root package name */
    private static final String f21192a = eu.class.getSimpleName();
    private static final long serialVersionUID = 5709634976027470847L;

    public eu() {
        this(TimeZone.getTimeZone("UTC"));
    }

    private eu(TimeZone timeZone) {
        super("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US);
        setTimeZone(timeZone);
    }

    public static Date a(String str) {
        Date parse;
        if (str == null) {
            return null;
        }
        String[] strArr = {"yyyy-MM-dd'T'HH:mm:ssZ", "yyyy-MM-dd'T'HH:mm:ss.SSSZ", "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", "yyyy-MM-dd'T'HH:mm:ss'Z'"};
        for (int i10 = 0; i10 < 4; i10++) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(strArr[i10], Locale.US);
            simpleDateFormat.setLenient(true);
            try {
                parse = simpleDateFormat.parse(str);
            } catch (ParseException e10) {
                e10.getMessage();
            }
            if (parse != null) {
                return parse;
            }
        }
        return null;
    }
}
