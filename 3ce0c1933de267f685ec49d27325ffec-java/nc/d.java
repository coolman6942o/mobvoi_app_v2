package nc;

import android.content.Context;
import android.text.TextUtils;
import com.google.common.base.v;
import com.google.firebase.iid.FirebaseInstanceId;
import com.mobvoi.android.common.utils.e;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.be.common.ConstantProto;
import com.mobvoi.be.pushunicorn.PushUnicornProto;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import yd.c;
/* compiled from: MobvoiPushApiHelper.kt */
/* loaded from: classes2.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final Context f31124a;

    /* renamed from: b  reason: collision with root package name */
    public v<nc.a> f31125b;

    /* renamed from: c  reason: collision with root package name */
    public v<nc.a> f31126c;

    /* compiled from: MobvoiPushApiHelper.kt */
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

    public d(Context context) {
        i.f(context, "context");
        this.f31124a = context;
    }

    private final nc.a e() {
        String str;
        nc.a aVar;
        if (c.c()) {
            aVar = c().get();
            str = "devPushApi.get()";
        } else {
            aVar = d().get();
            str = "pushApi.get()";
        }
        i.e(aVar, str);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(PushUnicornProto.UserPushResponse userPushResponse) {
        i.f(userPushResponse, "userPushResponse");
        k.c("MobvoiPushApiHelper", "register push : %s", userPushResponse.getErrMsg());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(Throwable th2) {
        k.e("MobvoiPushApiHelper", "register push error : ", th2);
    }

    public final v<nc.a> c() {
        v<nc.a> vVar = this.f31126c;
        if (vVar != null) {
            return vVar;
        }
        i.u("devPushApi");
        throw null;
    }

    public final v<nc.a> d() {
        v<nc.a> vVar = this.f31125b;
        if (vVar != null) {
            return vVar;
        }
        i.u("pushApi");
        throw null;
    }

    public final void f() {
        String x10 = ta.a.x();
        String e10 = e.e(this.f31124a);
        PushUnicornProto.UserPushRequest.b o10 = PushUnicornProto.UserPushRequest.newBuilder().q(ConstantProto.DeviceType.TIC_ASSISTANT).o(e10);
        String c10 = FirebaseInstanceId.b().c();
        if (!TextUtils.isEmpty(x10) && !TextUtils.isEmpty(c10)) {
            o10.v(x10);
            o10.p(c10);
            k.c("MobvoiPushApiHelper", "registerPush  wwid = %s", x10);
            k.c("MobvoiPushApiHelper", "registerPush  deviceId = %s", e10);
            k.c("MobvoiPushApiHelper", "registerPush  firebaseToken = %s", c10);
            e().a(o10.build()).Z(cq.a.c()).H(xp.a.b()).Y(b.f31122a, c.f31123a);
        }
    }
}
