package com.mobvoi.record.utils;

import android.content.Context;
import com.mobvoi.record.k;
import com.mobvoi.wear.util.LogCleaner;
import java.text.SimpleDateFormat;
import java.util.Date;
/* compiled from: TimeConvertUtil.java */
/* loaded from: classes2.dex */
public class d {
    public static String a(long j10) {
        int i10 = (int) (j10 / 1000);
        return String.format("%02d:%02d:%02d", Integer.valueOf(i10 / 3600), Integer.valueOf((i10 / 60) % 60), Integer.valueOf(i10 % 60));
    }

    public static String b(long j10) {
        long j11 = j10 / LogCleaner.ONE_MINUTE;
        long round = Math.round(((float) (j10 % LogCleaner.ONE_MINUTE)) / 1000.0f);
        String str = "";
        if (j11 < 10) {
            str = str + "0";
        }
        String str2 = str + j11 + ":";
        if (round < 10) {
            str2 = str2 + "0";
        }
        return str2 + round;
    }

    public static String c(Context context, int i10) {
        int i11 = i10 / 1000;
        int i12 = i11 % 60;
        int i13 = (i11 / 60) % 60;
        int i14 = i11 / 3600;
        return i14 > 0 ? i14 == 1 ? String.format(context.getResources().getString(k.f20681y), Integer.valueOf(i14)) : String.format(context.getResources().getString(k.f20682z), Integer.valueOf(i14)) : i13 > 0 ? String.format(context.getResources().getString(k.A), Integer.valueOf(i13)) : context.getResources().getString(k.B);
    }

    public static String d(long j10) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date(j10));
    }
}
