package b4;

import a4.d;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.KeyEvent;
/* loaded from: classes.dex */
public class b {

    /* loaded from: classes.dex */
    public static class a implements DialogInterface.OnKeyListener {
        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
            return i10 == 4;
        }
    }

    public static AlertDialog.Builder a(Context context, String str, String str2, DialogInterface.OnClickListener onClickListener, String str3, DialogInterface.OnClickListener onClickListener2) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        if (!TextUtils.isEmpty(str3) && onClickListener2 != null) {
            builder.setPositiveButton(str3, onClickListener2);
        }
        if (!TextUtils.isEmpty(str2) && onClickListener != null) {
            builder.setNegativeButton(str2, onClickListener);
        }
        return builder;
    }

    public static Dialog b(Context context, String str, String str2, String str3, DialogInterface.OnClickListener onClickListener, String str4, DialogInterface.OnClickListener onClickListener2) {
        AlertDialog.Builder a10 = a(context, str, str3, onClickListener, str4, onClickListener2);
        a10.setTitle(str);
        a10.setMessage(str2);
        AlertDialog create = a10.create();
        create.setCanceledOnTouchOutside(false);
        create.setOnKeyListener(new a());
        try {
            create.show();
        } catch (Throwable th2) {
            d.c("mspl", "showDialog ", th2);
        }
        return create;
    }
}
