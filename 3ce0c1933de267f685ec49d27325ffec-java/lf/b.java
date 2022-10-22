package lf;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import com.mobvoi.wear.util.UnitsUtility;
import ef.u;
/* compiled from: SportSummaryUtil.java */
/* loaded from: classes2.dex */
public class b {
    public static CharSequence a(String str, int i10, int i11) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("");
        spannableStringBuilder.append((CharSequence) str);
        int length = spannableStringBuilder.length();
        if (i10 > 0) {
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan(i10, false), 0, length, 33);
        }
        SpannableString spannableString = new SpannableString(spannableStringBuilder);
        if (i11 != 0) {
            spannableString.setSpan(new ForegroundColorSpan(i11), 0, length, 33);
        }
        return spannableString;
    }

    public static float b(u uVar) {
        int i10;
        long j10 = uVar.f25991j;
        if (j10 <= 0 || (i10 = uVar.f25992k) <= 0) {
            return 0.0f;
        }
        return (((float) j10) / 1000.0f) / i10;
    }

    public static float c(u uVar) {
        int i10;
        long j10 = uVar.f25991j;
        if (j10 <= 0 || (i10 = uVar.f25992k) <= 0) {
            return 0.0f;
        }
        return i10 / (((float) j10) / 1000.0f);
    }

    public static float d(u uVar) {
        int i10;
        int i11 = uVar.f25995n;
        if (i11 <= 0 || (i10 = uVar.f25992k) <= 0) {
            return 0.0f;
        }
        return i10 / i11;
    }

    public static int e(u uVar) {
        int i10 = uVar.f25995n;
        if (i10 > 0) {
            long j10 = uVar.f25991j;
            if (j10 > 0) {
                return (int) (i10 / UnitsUtility.Time.ms2min(j10));
            }
        }
        return 0;
    }

    public static boolean f(u uVar) {
        return uVar.f26000s > 0.0f || uVar.f25999r > 0.0f;
    }

    public static String g(Context context, int i10) {
        if (i10 == 1) {
            return context.getString(ue.b.f35387d);
        }
        if (i10 == 2) {
            return context.getString(ue.b.f35385b);
        }
        if (i10 == 3) {
            return context.getString(ue.b.f35384a);
        }
        if (i10 != 4) {
            return context.getString(ue.b.f35388e);
        }
        return context.getString(ue.b.f35386c);
    }
}
