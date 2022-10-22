package b6;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import com.google.android.gms.common.api.internal.h;
/* loaded from: classes.dex */
public abstract class e implements DialogInterface.OnClickListener {
    public static e a(Activity activity, Intent intent, int i10) {
        return new l(intent, activity, i10);
    }

    public static e b(h hVar, Intent intent, int i10) {
        return new m(intent, hVar, i10);
    }

    protected abstract void c();

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i10) {
        try {
            c();
        } catch (ActivityNotFoundException e10) {
            Log.e("DialogRedirect", "Failed to start resolution intent", e10);
        } finally {
            dialogInterface.dismiss();
        }
    }
}
