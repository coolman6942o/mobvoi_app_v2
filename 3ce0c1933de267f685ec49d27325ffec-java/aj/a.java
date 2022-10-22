package aj;

import android.content.SharedPreferences;
import com.mobvoi.android.common.utils.b;
import java.util.ArrayList;
import kotlin.jvm.internal.i;
/* compiled from: PeriodPreferenceHelper.kt */
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f215a = new a();

    static {
        new ArrayList();
    }

    private a() {
    }

    private final SharedPreferences d() {
        SharedPreferences sharedPreferences = b.e().getSharedPreferences("period_info", 0);
        i.e(sharedPreferences, "getApplication()\n            .getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)");
        return sharedPreferences;
    }

    public final void a() {
        k(0L);
        i(-1);
        h(-1);
        j(false);
    }

    public final int b() {
        return d().getInt("key_cycle_length", -1);
    }

    public final int c() {
        return d().getInt("key_menstruation_length", -1);
    }

    public final long e() {
        return d().getLong("key_start_date", -1L);
    }

    public final boolean f() {
        return e() > 0 && c() > 0 && b() > 0;
    }

    public final boolean g() {
        return d().getBoolean("key_remind_is_open", false);
    }

    public final void h(int i10) {
        d().edit().putInt("key_cycle_length", i10).apply();
    }

    public final void i(int i10) {
        d().edit().putInt("key_menstruation_length", i10).apply();
    }

    public final void j(boolean z10) {
        d().edit().putBoolean("key_remind_is_open", z10).apply();
    }

    public final void k(long j10) {
        d().edit().putLong("key_start_date", j10).apply();
    }
}
