package com.mobvoi.companion.contacts;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.core.app.g;
import com.mobvoi.android.common.utils.k;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
/* compiled from: StartJobIntentServiceReceiver.kt */
/* loaded from: classes2.dex */
public final class StartJobIntentServiceReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public static final a f16670a = new a(null);

    /* renamed from: b  reason: collision with root package name */
    private static final String f16671b = "StartJobISReceiver";

    /* compiled from: StartJobIntentServiceReceiver.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final Intent a(Context context, Intent intent, int i10) {
            i.f(context, "context");
            i.f(intent, "intent");
            ComponentName component = intent.getComponent();
            if (component != null) {
                Intent putExtra = new Intent(intent).putExtra("extra_service_class", component.getClassName()).putExtra("extra_job_id", i10);
                i.e(putExtra, "Intent(intent)\n                    .putExtra(EXTRA_SERVICE_CLASS, component.className)\n                    .putExtra(EXTRA_JOB_ID, jobId)");
                putExtra.setClass(context, StartJobIntentServiceReceiver.class);
                return putExtra;
            }
            throw new RuntimeException("Missing intent component");
        }
    }

    public static final Intent a(Context context, Intent intent, int i10) {
        return f16670a.a(context, intent, i10);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Bundle extras;
        if (intent == null) {
            extras = null;
        } else {
            try {
                extras = intent.getExtras();
            } catch (Exception e10) {
                k.d(f16671b, i.n("Error starting service from receiver: ", e10.getMessage()));
                return;
            }
        }
        if (extras != null) {
            String stringExtra = intent.getStringExtra("extra_service_class");
            if (stringExtra != null) {
                Class<?> cls = Class.forName(stringExtra);
                if (g.class.isAssignableFrom(cls)) {
                    i.d(context);
                    intent.setClass(context, cls);
                    Bundle extras2 = intent.getExtras();
                    boolean z10 = true;
                    if (extras2 == null || !extras2.containsKey("extra_job_id")) {
                        z10 = false;
                    }
                    if (!z10) {
                        g.d(context, cls, intent.getIntExtra("extra_job_id", 0), intent);
                        return;
                    }
                    throw new Exception("No job ID found in extras");
                }
                throw new Exception(i.n("Service class found is not a JobIntentService: ", cls.getName()));
            }
            throw new Exception("No service class found in extras");
        }
        throw new Exception("No extras found");
    }
}
