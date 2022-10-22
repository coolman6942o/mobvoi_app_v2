package ac;

import cc.d;
import cc.g;
import com.mobvoi.companion.setting.CompanionSetting;
import com.mobvoi.wear.companion.setup.settings.SettingConstants;
import com.mobvoi.wear.info.WearInfo;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.y;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.c;
/* compiled from: WatchFaceApiHelper.kt */
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final ac.a f167a;

    /* compiled from: WatchFaceApiHelper.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    static {
        new a(null);
    }

    public b() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(null, 1, null);
        httpLoggingInterceptor.b(HttpLoggingInterceptor.Level.BODY);
        Retrofit.Builder addConverterFactory = new Retrofit.Builder().baseUrl("https://awch-appstore.ticwear.com/").addCallAdapterFactory(RxJavaCallAdapterFactory.create()).addConverterFactory(GsonConverterFactory.create());
        y.a a10 = new y.a().a(httpLoggingInterceptor).a(new bc.a());
        TimeUnit timeUnit = TimeUnit.SECONDS;
        Object create = addConverterFactory.client(a10.M(60L, timeUnit).e(60L, timeUnit).c()).build().create(ac.a.class);
        i.e(create, "retrofit.create(WatchFaceApi::class.java)");
        this.f167a = (ac.a) create;
    }

    private final HashMap<String, String> a() {
        WearInfo e10 = com.mobvoi.companion.wear.a.f().e();
        HashMap<String, String> hashMap = new HashMap<>();
        if (e10 != null) {
            String str = e10.wearDeviceId;
            if (str != null) {
                hashMap.put("device_id", str);
            }
            hashMap.put("device_type", i.n("", e10.wearType));
        }
        hashMap.put("is_ios", "false");
        hashMap.put(SettingConstants.LANGUAGE, "zh-cn");
        String wearModel = CompanionSetting.getWearModel();
        i.e(wearModel, "getWearModel()");
        hashMap.put("watch_model", wearModel);
        hashMap.put("version", i.n("", Long.valueOf(CompanionSetting.getWearVersionNumber())));
        hashMap.put("filter_watchface", "2");
        String x10 = ta.a.x();
        i.e(x10, "getWwid()");
        hashMap.put("wwid", x10);
        hashMap.put("uid", "30116835");
        hashMap.put("wear_exist_account", "1");
        hashMap.put("filter_tic_apps", "0");
        return hashMap;
    }

    public final c<d> b(int i10, int i11, int i12, int i13, String wwid, boolean z10) {
        i.f(wwid, "wwid");
        return this.f167a.c(i10, i11, i12, i13, wwid, a(), z10);
    }

    public final c<cc.f> c(boolean z10, String wwid) {
        i.f(wwid, "wwid");
        return this.f167a.a(z10, wwid, a());
    }

    public final c<g> d(String pkgName, boolean z10) {
        i.f(pkgName, "pkgName");
        return this.f167a.b(pkgName, z10);
    }

    public final c<d> e(String pageNum, String pageSize, boolean z10) {
        i.f(pageNum, "pageNum");
        i.f(pageSize, "pageSize");
        return this.f167a.d(pageNum, pageSize, a(), z10);
    }
}
