package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.internal.e;
import com.huawei.hms.feature.dynamic.b;
@KeepName
/* loaded from: classes.dex */
public class GoogleApiActivity extends Activity implements DialogInterface.OnCancelListener {

    /* renamed from: a  reason: collision with root package name */
    private int f8441a = 0;

    public static PendingIntent a(Context context, PendingIntent pendingIntent, int i10) {
        return PendingIntent.getActivity(context, 0, b(context, pendingIntent, i10, true), 134217728);
    }

    public static Intent b(Context context, PendingIntent pendingIntent, int i10, boolean z10) {
        Intent intent = new Intent(context, GoogleApiActivity.class);
        intent.putExtra("pending_intent", pendingIntent);
        intent.putExtra("failing_client_id", i10);
        intent.putExtra("notify_manager", z10);
        return intent;
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i10 == 1) {
            boolean booleanExtra = getIntent().getBooleanExtra("notify_manager", true);
            this.f8441a = 0;
            setResult(i11, intent);
            if (booleanExtra) {
                e m10 = e.m(this);
                if (i11 == -1) {
                    m10.A();
                } else if (i11 == 0) {
                    m10.h(new ConnectionResult(13, null), getIntent().getIntExtra("failing_client_id", -1));
                }
            }
        } else if (i10 == 2) {
            this.f8441a = 0;
            setResult(i11, intent);
        }
        finish();
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f8441a = 0;
        setResult(0);
        finish();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f8441a = bundle.getInt(b.f13797h);
        }
        if (this.f8441a != 1) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                Log.e("GoogleApiActivity", "Activity started without extras");
                finish();
                return;
            }
            PendingIntent pendingIntent = (PendingIntent) extras.get("pending_intent");
            Integer num = (Integer) extras.get("error_code");
            if (pendingIntent == null && num == null) {
                Log.e("GoogleApiActivity", "Activity started without resolution");
                finish();
            } else if (pendingIntent != null) {
                try {
                    startIntentSenderForResult(pendingIntent.getIntentSender(), 1, null, 0, 0, 0);
                    this.f8441a = 1;
                } catch (IntentSender.SendIntentException e10) {
                    Log.e("GoogleApiActivity", "Failed to launch pendingIntent", e10);
                    finish();
                }
            } else {
                com.google.android.gms.common.b.q().s(this, num.intValue(), 2, this);
                this.f8441a = 1;
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt(b.f13797h, this.f8441a);
        super.onSaveInstanceState(bundle);
    }
}
