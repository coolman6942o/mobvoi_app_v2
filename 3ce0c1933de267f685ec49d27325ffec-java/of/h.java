package of;

import android.content.Context;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.wear.util.MsgCallBack;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.fastjson.FastJsonConverterFactory;
import vf.d;
import wf.p;
import wf.q;
import wf.r;
/* compiled from: UserSettingHelper.java */
/* loaded from: classes2.dex */
public class h {

    /* renamed from: c  reason: collision with root package name */
    private static volatile h f31628c;

    /* renamed from: b  reason: collision with root package name */
    protected final nf.h<q> f31630b = new nf.a();

    /* renamed from: a  reason: collision with root package name */
    private final d f31629a = (d) new Retrofit.Builder().baseUrl("https://fitness.mobvoi.com").addConverterFactory(FastJsonConverterFactory.create()).build().create(d.class);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UserSettingHelper.java */
    /* loaded from: classes2.dex */
    public class a implements Callback<r> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ q f31631a;

        a(q qVar) {
            this.f31631a = qVar;
        }

        @Override // retrofit2.Callback
        public void onFailure(Call<r> call, Throwable th2) {
            k.a("UserSettingHelper", "upload user setting failure");
        }

        @Override // retrofit2.Callback
        public void onResponse(Call<r> call, Response<r> response) {
            k.c("UserSettingHelper", "upload user setting success! response : %s", response);
            nf.h<q> hVar = h.this.f31630b;
            if (hVar != null) {
                hVar.f(this.f31631a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UserSettingHelper.java */
    /* loaded from: classes2.dex */
    public class b implements Callback<r> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f31633a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ MsgCallBack f31634b;

        b(Context context, MsgCallBack msgCallBack) {
            this.f31633a = context;
            this.f31634b = msgCallBack;
        }

        @Override // retrofit2.Callback
        public void onFailure(Call<r> call, Throwable th2) {
            k.a("UserSettingHelper", "get user setting failure");
            h.this.j(this.f31634b);
        }

        @Override // retrofit2.Callback
        public void onResponse(Call<r> call, Response<r> response) {
            if (response.isSuccessful()) {
                k.c("UserSettingHelper", "getUserSetting success! response : %s", response);
                r body = response.body();
                k.c("UserSettingHelper", "getUserSetting body = %s", body.toString());
                List<r.a> list = body.list;
                if (list != null && list.size() > 0) {
                    String str = list.get(0).value;
                    k.c("UserSettingHelper", "getUserSetting value = %s", str);
                    h.this.l(this.f31633a, str);
                }
            }
            h.this.j(this.f31634b);
        }
    }

    /* compiled from: UserSettingHelper.java */
    /* loaded from: classes2.dex */
    class c implements Callback<p> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f31636a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f31637b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ MsgCallBack f31638c;

        c(Context context, String str, MsgCallBack msgCallBack) {
            this.f31636a = context;
            this.f31637b = str;
            this.f31638c = msgCallBack;
        }

        @Override // retrofit2.Callback
        public void onFailure(Call<p> call, Throwable th2) {
            k.a("UserSettingHelper", "get SupportRRI failure");
            h.this.j(this.f31638c);
        }

        @Override // retrofit2.Callback
        public void onResponse(Call<p> call, Response<p> response) {
            p.a aVar;
            if (response.isSuccessful()) {
                k.c("UserSettingHelper", "getSupportRRIByCode success! response : %s", response);
                p body = response.body();
                if (body != null && (aVar = body.data) != null && aVar != null) {
                    boolean z10 = true ^ aVar.rriDisabled;
                    h.this.k(this.f31636a, z10);
                    if (z10) {
                        h.this.g(this.f31636a, "rri", this.f31637b, this.f31638c);
                        return;
                    }
                    h.b().m(this.f31636a, "rri", "0", this.f31637b);
                    h.this.j(this.f31638c);
                    h.this.l(this.f31636a, "0");
                }
            }
        }
    }

    private h() {
    }

    public static h b() {
        if (f31628c == null) {
            synchronized (h.class) {
                if (f31628c == null) {
                    f31628c = new h();
                }
            }
        }
        return f31628c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(MsgCallBack msgCallBack) {
        if (msgCallBack != null) {
            msgCallBack.sendRRIMsg(b().e(com.mobvoi.android.common.utils.b.e()));
        }
    }

    public boolean c(Context context) {
        return com.mobvoi.android.common.utils.q.a(context, "rri_sp", "IS_SUPPORT_RRI", false);
    }

    public String d(Context context) {
        return com.mobvoi.android.common.utils.q.d(context, "rri_sp", "RRI_SWITCH", "0");
    }

    public String e(Context context) {
        return c(context) ? d(context) : "0";
    }

    public void f(Context context, String str, String str2, String str3, String str4, MsgCallBack msgCallBack) {
        this.f31629a.c(str2, str3, str4).enqueue(new c(context, str, msgCallBack));
    }

    public void g(Context context, String str, String str2, MsgCallBack msgCallBack) {
        this.f31629a.b(str2, str).enqueue(new b(context, msgCallBack));
    }

    public nf.h<q> h() {
        return this.f31630b;
    }

    public boolean i(Context context) {
        return "1".equals(e(context));
    }

    public void k(Context context, boolean z10) {
        com.mobvoi.android.common.utils.q.e(context, "rri_sp", "IS_SUPPORT_RRI", z10);
    }

    public void l(Context context, String str) {
        com.mobvoi.android.common.utils.q.h(context, "rri_sp", "RRI_SWITCH", str);
    }

    public void m(Context context, String str, String str2, String str3) {
        q qVar = new q(str, str2);
        this.f31629a.a(str3, qVar).enqueue(new a(qVar));
    }
}
