package kg;

import android.content.Context;
import android.text.TextUtils;
import bf.c;
import com.mobvoi.android.common.utils.b;
import com.mobvoi.android.common.utils.m;
import com.mobvoi.health.common.data.pojo.SportType;
import com.mobvoi.wear.providers.HealthFlagsHelper;
import eg.d;
import hf.a;
import java.util.List;
/* compiled from: UserSportTypeSettingHelper.java */
/* loaded from: classes2.dex */
public class k implements a {

    /* renamed from: a  reason: collision with root package name */
    private Context f29898a;

    /* renamed from: b  reason: collision with root package name */
    private c f29899b;

    public k(Context context) {
        this.f29898a = context;
        this.f29899b = new j(context);
    }

    private jg.a i() {
        return (jg.a) this.f29899b.a(jg.a.class);
    }

    @Override // hf.a
    public boolean isConnected() {
        if (d.a(b.e())) {
            return HealthFlagsHelper.isFeatureEnabled(HealthFlagsHelper.FLAG_NETWORK_SYNC) && m.b(this.f29898a) && !TextUtils.isEmpty(this.f29899b.b());
        }
        d.d(b.e());
        return false;
    }

    public rx.c<lg.a> j() {
        return i().b();
    }

    public rx.c<lg.a> k(List<SportType> list) {
        return i().a(list);
    }
}
