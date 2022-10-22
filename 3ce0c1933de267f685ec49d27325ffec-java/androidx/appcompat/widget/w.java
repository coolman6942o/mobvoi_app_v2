package androidx.appcompat.widget;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.text.Selection;
import android.text.Spannable;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.c;
import androidx.core.view.d0;
/* compiled from: AppCompatReceiveContentHelper.java */
/* loaded from: classes.dex */
final class w {

    /* compiled from: AppCompatReceiveContentHelper.java */
    /* loaded from: classes.dex */
    private static final class a {
        /* JADX WARN: Finally extract failed */
        static boolean a(DragEvent dragEvent, TextView textView, Activity activity) {
            activity.requestDragAndDropPermissions(dragEvent);
            int offsetForPosition = textView.getOffsetForPosition(dragEvent.getX(), dragEvent.getY());
            textView.beginBatchEdit();
            try {
                Selection.setSelection((Spannable) textView.getText(), offsetForPosition);
                d0.j0(textView, new c.a(dragEvent.getClipData(), 3).a());
                textView.endBatchEdit();
                return true;
            } catch (Throwable th2) {
                textView.endBatchEdit();
                throw th2;
            }
        }

        static boolean b(DragEvent dragEvent, View view, Activity activity) {
            activity.requestDragAndDropPermissions(dragEvent);
            d0.j0(view, new c.a(dragEvent.getClipData(), 3).a());
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(View view, DragEvent dragEvent) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 31 && i10 >= 24 && dragEvent.getLocalState() == null && d0.H(view) != null) {
            Activity c10 = c(view);
            if (c10 == null) {
                Log.i("ReceiveContent", "Can't handle drop: no activity: view=" + view);
                return false;
            } else if (dragEvent.getAction() == 1) {
                return !(view instanceof TextView);
            } else {
                if (dragEvent.getAction() == 3) {
                    if (view instanceof TextView) {
                        return a.a(dragEvent, (TextView) view, c10);
                    }
                    return a.b(dragEvent, view, c10);
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b(TextView textView, int i10) {
        int i11 = 0;
        if (Build.VERSION.SDK_INT >= 31 || d0.H(textView) == null || (i10 != 16908322 && i10 != 16908337)) {
            return false;
        }
        ClipboardManager clipboardManager = (ClipboardManager) textView.getContext().getSystemService("clipboard");
        ClipData primaryClip = clipboardManager == null ? null : clipboardManager.getPrimaryClip();
        if (primaryClip != null && primaryClip.getItemCount() > 0) {
            c.a aVar = new c.a(primaryClip, 1);
            if (i10 != 16908322) {
                i11 = 1;
            }
            d0.j0(textView, aVar.c(i11).a());
        }
        return true;
    }

    static Activity c(View view) {
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
        }
        return null;
    }
}
