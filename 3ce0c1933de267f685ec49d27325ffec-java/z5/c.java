package z5;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import b6.i;
/* loaded from: classes.dex */
public class c extends androidx.fragment.app.c {

    /* renamed from: q  reason: collision with root package name */
    private Dialog f37288q = null;

    /* renamed from: r  reason: collision with root package name */
    private DialogInterface.OnCancelListener f37289r = null;

    public static c q0(Dialog dialog, DialogInterface.OnCancelListener onCancelListener) {
        c cVar = new c();
        Dialog dialog2 = (Dialog) i.l(dialog, "Cannot display null dialog");
        dialog2.setOnCancelListener(null);
        dialog2.setOnDismissListener(null);
        cVar.f37288q = dialog2;
        if (onCancelListener != null) {
            cVar.f37289r = onCancelListener;
        }
        return cVar;
    }

    @Override // androidx.fragment.app.c
    public Dialog h0(Bundle bundle) {
        if (this.f37288q == null) {
            m0(false);
        }
        return this.f37288q;
    }

    @Override // androidx.fragment.app.c, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.f37289r;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    @Override // androidx.fragment.app.c
    public void p0(FragmentManager fragmentManager, String str) {
        super.p0(fragmentManager, str);
    }
}
