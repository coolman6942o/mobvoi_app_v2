package ah;

import android.text.TextUtils;
import com.mobvoi.fitness.core.data.bt.e;
import com.mobvoi.wear.info.AccountInfoHelper;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
/* compiled from: AccountProfile.java */
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: e  reason: collision with root package name */
    private static final SimpleDateFormat f207e = new SimpleDateFormat("yyyy.MM.dd", Locale.getDefault());

    /* renamed from: a  reason: collision with root package name */
    public String f208a;

    /* renamed from: b  reason: collision with root package name */
    public String f209b;

    /* renamed from: c  reason: collision with root package name */
    public String f210c;

    /* renamed from: d  reason: collision with root package name */
    public String f211d;

    private Calendar a(String str) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        if (!TextUtils.isEmpty(str)) {
            try {
                calendar.setTime(f207e.parse(str));
            } catch (ParseException unused) {
            }
        }
        return calendar;
    }

    public boolean b(e eVar) {
        boolean z10 = false;
        if (eVar.birthday > 0) {
            Calendar a10 = a(this.f208a);
            try {
                int i10 = eVar.birthday;
                if (!a10.isSet(5)) {
                    a10.set(5, 1);
                }
                if (!a10.isSet(2)) {
                    a10.set(2, 0);
                }
                a10.set(1, i10);
                String format = f207e.format(a10.getTime());
                if (!TextUtils.equals(format, this.f208a)) {
                    this.f208a = format;
                    z10 = true;
                }
            } catch (NumberFormatException unused) {
            }
        }
        float f10 = eVar.height;
        if (f10 > 0.0f) {
            String valueOf = String.valueOf(f10);
            if (!TextUtils.equals(valueOf, this.f209b)) {
                this.f209b = valueOf;
                z10 = true;
            }
        }
        float f11 = eVar.weight;
        if (f11 > 0.0f) {
            String valueOf2 = String.valueOf(f11);
            if (!TextUtils.equals(valueOf2, this.f210c)) {
                this.f210c = valueOf2;
                z10 = true;
            }
        }
        int i11 = eVar.sex;
        if (i11 != -1) {
            String str = i11 != 0 ? i11 != 1 ? "" : AccountInfoHelper.AccountInfo.VAL_SEX_MALE : AccountInfoHelper.AccountInfo.VAL_SEX_FEMALE;
            if (!TextUtils.equals(str, this.f211d)) {
                this.f211d = str;
                return true;
            }
        }
        return z10;
    }
}
