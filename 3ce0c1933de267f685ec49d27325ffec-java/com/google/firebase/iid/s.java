package com.google.firebase.iid;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import c8.b;
import com.google.android.gms.tasks.c;
import com.google.firebase.a;
import com.mobvoi.wear.util.TelephonyUtil;
import java.io.IOException;
import java.util.concurrent.ScheduledThreadPoolExecutor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class s implements v {

    /* renamed from: a  reason: collision with root package name */
    private final a f12517a;

    /* renamed from: b  reason: collision with root package name */
    private final FirebaseInstanceId f12518b;

    /* renamed from: c  reason: collision with root package name */
    private final b f12519c;

    /* renamed from: d  reason: collision with root package name */
    private final j f12520d;

    /* renamed from: e  reason: collision with root package name */
    private final ScheduledThreadPoolExecutor f12521e = new ScheduledThreadPoolExecutor(1);

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(a aVar, FirebaseInstanceId firebaseInstanceId, b bVar) {
        this.f12517a = aVar;
        this.f12518b = firebaseInstanceId;
        this.f12519c = bVar;
        this.f12520d = new j(aVar.b(), bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String b(Bundle bundle) throws IOException {
        if (bundle != null) {
            String string = bundle.getString("registration_id");
            if (string != null) {
                return string;
            }
            String string2 = bundle.getString("unregistered");
            if (string2 != null) {
                return string2;
            }
            String string3 = bundle.getString("error");
            if ("RST".equals(string3)) {
                this.f12518b.v();
                throw new IOException("INSTANCE_ID_RESET");
            } else if (string3 != null) {
                throw new IOException(string3);
            } else {
                String valueOf = String.valueOf(bundle);
                StringBuilder sb2 = new StringBuilder(valueOf.length() + 21);
                sb2.append("Unexpected response: ");
                sb2.append(valueOf);
                Log.w("FirebaseInstanceId", sb2.toString(), new Throwable());
                throw new IOException("SERVICE_NOT_AVAILABLE");
            }
        } else {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
    }

    private final Bundle f(String str, String str2, Bundle bundle) {
        bundle.putString("scope", str2);
        bundle.putString("sender", str);
        bundle.putString(TelephonyUtil.KEY_SIM_ACTIVITIED_CHANNLE, str);
        bundle.putString("appid", FirebaseInstanceId.q());
        bundle.putString("gmp_app_id", this.f12517a.e().c());
        bundle.putString("gmsv", Integer.toString(this.f12519c.c()));
        bundle.putString("osv", Integer.toString(Build.VERSION.SDK_INT));
        bundle.putString("app_ver", this.f12519c.g());
        bundle.putString("app_ver_name", this.f12519c.h());
        bundle.putString("cliv", "fiid-12451000");
        return bundle;
    }

    @Override // com.google.firebase.iid.v
    public final com.google.android.gms.tasks.b<String> a(String str, String str2) {
        final Bundle bundle = new Bundle();
        f(str, str2, bundle);
        final c cVar = new c();
        this.f12521e.execute(new Runnable(this, bundle, cVar) { // from class: com.google.firebase.iid.t

            /* renamed from: a  reason: collision with root package name */
            private final s f12522a;

            /* renamed from: b  reason: collision with root package name */
            private final Bundle f12523b;

            /* renamed from: c  reason: collision with root package name */
            private final c f12524c;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f12522a = this;
                this.f12523b = bundle;
                this.f12524c = cVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f12522a.e(this.f12523b, this.f12524c);
            }
        });
        return cVar.a().i(this.f12521e, new u(this));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String d(String str, String str2, Bundle bundle) throws IOException {
        f(str, str2, bundle);
        return b(this.f12520d.f(bundle));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void e(Bundle bundle, c cVar) {
        try {
            cVar.c(this.f12520d.f(bundle));
        } catch (IOException e10) {
            cVar.b(e10);
        }
    }
}
