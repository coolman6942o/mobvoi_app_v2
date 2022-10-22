package z5;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Bundle;
import b6.i;
/* loaded from: classes.dex */
public class a extends DialogFragment {

    /* renamed from: a  reason: collision with root package name */
    private Dialog f37285a = null;

    /* renamed from: b  reason: collision with root package name */
    private DialogInterface.OnCancelListener f37286b = null;

    public static a a(Dialog dialog, DialogInterface.OnCancelListener onCancelListener) {
        a aVar = new a();
        Dialog dialog2 = (Dialog) i.l(dialog, "Cannot display null dialog");
        dialog2.setOnCancelListener(null);
        dialog2.setOnDismissListener(null);
        aVar.f37285a = dialog2;
        if (onCancelListener != null) {
            aVar.f37286b = onCancelListener;
        }
        return aVar;
    }

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.f37286b;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    @Override // android.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        if (this.f37285a == null) {
            setShowsDialog(false);
        }
        return this.f37285a;
    }

    @Override // android.app.DialogFragment
    public void show(FragmentManager fragmentManager, String str) {
        super.show(fragmentManager, str);
    }
}
