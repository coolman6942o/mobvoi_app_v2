package k6;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
/* loaded from: classes.dex */
final class h implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ Context f29791a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ Intent f29792b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(Context context, Intent intent) {
        this.f29791a = context;
        this.f29792b = intent;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            this.f29791a.startActivity(this.f29792b);
        } catch (ActivityNotFoundException e10) {
            Log.e("DeferredLifecycleHelper", "Failed to start resolution intent", e10);
        }
    }
}
