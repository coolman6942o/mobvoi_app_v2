package vg;

import android.content.SharedPreferences;
import com.mobvoi.android.common.utils.b;
import java.util.HashSet;
import java.util.Set;
/* compiled from: SportSettings.java */
/* loaded from: classes2.dex */
public class a implements SharedPreferences.OnSharedPreferenceChangeListener {

    /* renamed from: c  reason: collision with root package name */
    private static a f35772c;

    /* renamed from: a  reason: collision with root package name */
    private SharedPreferences f35773a;

    /* renamed from: b  reason: collision with root package name */
    private final Set<AbstractC0515a> f35774b = new HashSet();

    /* compiled from: SportSettings.java */
    /* renamed from: vg.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface AbstractC0515a {
        void a(a aVar, String str);
    }

    private a() {
        SharedPreferences sharedPreferences = b.e().getSharedPreferences("PERF_HEALTH_SPORT", 0);
        this.f35773a = sharedPreferences;
        sharedPreferences.registerOnSharedPreferenceChangeListener(this);
    }

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (f35772c == null) {
                f35772c = new a();
            }
            aVar = f35772c;
        }
        return aVar;
    }

    public boolean b() {
        return com.mobvoi.companion.base.settings.a.isOversea();
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        for (AbstractC0515a aVar : this.f35774b) {
            aVar.a(this, str);
        }
    }
}
