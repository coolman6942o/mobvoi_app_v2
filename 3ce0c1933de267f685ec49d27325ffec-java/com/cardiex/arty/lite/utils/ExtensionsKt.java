package com.cardiex.arty.lite.utils;

import com.mobvoi.wear.companion.setup.settings.SettingConstants;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.jvm.internal.i;
/* compiled from: Extensions.kt */
/* loaded from: classes.dex */
public final class ExtensionsKt {
    public static final String toFormat(Date date, String format) {
        i.f(date, "<this>");
        i.f(format, "format");
        return new SimpleDateFormat(format, Locale.getDefault()).format(date);
    }

    public static /* synthetic */ String toFormat$default(Date date, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = SettingConstants.DATE_FORMAT_DEFAULT;
        }
        return toFormat(date, str);
    }
}
