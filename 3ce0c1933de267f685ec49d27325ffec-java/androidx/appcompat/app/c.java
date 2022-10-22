package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AlertController;
/* compiled from: AlertDialog.java */
/* loaded from: classes.dex */
public class c extends g {

    /* renamed from: c  reason: collision with root package name */
    final AlertController f513c = new AlertController(getContext(), this, getWindow());

    /* compiled from: AlertDialog.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final AlertController.f f514a;

        /* renamed from: b  reason: collision with root package name */
        private final int f515b;

        public a(Context context) {
            this(context, c.f(context, 0));
        }

        public c a() {
            c cVar = new c(this.f514a.f394a, this.f515b);
            this.f514a.a(cVar.f513c);
            cVar.setCancelable(this.f514a.f411r);
            if (this.f514a.f411r) {
                cVar.setCanceledOnTouchOutside(true);
            }
            cVar.setOnCancelListener(this.f514a.f412s);
            cVar.setOnDismissListener(this.f514a.f413t);
            DialogInterface.OnKeyListener onKeyListener = this.f514a.f414u;
            if (onKeyListener != null) {
                cVar.setOnKeyListener(onKeyListener);
            }
            return cVar;
        }

        public Context b() {
            return this.f514a.f394a;
        }

        public a c(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.f514a;
            fVar.f416w = listAdapter;
            fVar.f417x = onClickListener;
            return this;
        }

        public a d(boolean z10) {
            this.f514a.f411r = z10;
            return this;
        }

        public a e(View view) {
            this.f514a.f400g = view;
            return this;
        }

        public a f(Drawable drawable) {
            this.f514a.f397d = drawable;
            return this;
        }

        public a g(CharSequence[] charSequenceArr, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.f514a;
            fVar.f415v = charSequenceArr;
            fVar.f417x = onClickListener;
            return this;
        }

        public a h(int i10) {
            AlertController.f fVar = this.f514a;
            fVar.f401h = fVar.f394a.getText(i10);
            return this;
        }

        public a i(CharSequence charSequence) {
            this.f514a.f401h = charSequence;
            return this;
        }

        public a j(int i10, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.f514a;
            fVar.f405l = fVar.f394a.getText(i10);
            this.f514a.f407n = onClickListener;
            return this;
        }

        public a k(DialogInterface.OnCancelListener onCancelListener) {
            this.f514a.f412s = onCancelListener;
            return this;
        }

        public a l(DialogInterface.OnKeyListener onKeyListener) {
            this.f514a.f414u = onKeyListener;
            return this;
        }

        public a m(int i10, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.f514a;
            fVar.f402i = fVar.f394a.getText(i10);
            this.f514a.f404k = onClickListener;
            return this;
        }

        public a n(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.f514a;
            fVar.f402i = charSequence;
            fVar.f404k = onClickListener;
            return this;
        }

        public a o(int i10, int i11, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.f514a;
            fVar.f415v = fVar.f394a.getResources().getTextArray(i10);
            AlertController.f fVar2 = this.f514a;
            fVar2.f417x = onClickListener;
            fVar2.I = i11;
            fVar2.H = true;
            return this;
        }

        public a p(ListAdapter listAdapter, int i10, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.f514a;
            fVar.f416w = listAdapter;
            fVar.f417x = onClickListener;
            fVar.I = i10;
            fVar.H = true;
            return this;
        }

        public a q(int i10) {
            AlertController.f fVar = this.f514a;
            fVar.f399f = fVar.f394a.getText(i10);
            return this;
        }

        public a r(CharSequence charSequence) {
            this.f514a.f399f = charSequence;
            return this;
        }

        public a s(View view) {
            AlertController.f fVar = this.f514a;
            fVar.f419z = view;
            fVar.f418y = 0;
            fVar.E = false;
            return this;
        }

        public c t() {
            c a10 = a();
            a10.show();
            return a10;
        }

        public a(Context context, int i10) {
            this.f514a = new AlertController.f(new ContextThemeWrapper(context, c.f(context, i10)));
            this.f515b = i10;
        }
    }

    protected c(Context context, int i10) {
        super(context, f(context, i10));
    }

    static int f(Context context, int i10) {
        if (((i10 >>> 24) & 255) >= 1) {
            return i10;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(d.a.f24727o, typedValue, true);
        return typedValue.resourceId;
    }

    public ListView e() {
        return this.f513c.d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.g, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f513c.e();
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (this.f513c.g(i10, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i10, keyEvent);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i10, KeyEvent keyEvent) {
        if (this.f513c.h(i10, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i10, keyEvent);
    }

    @Override // androidx.appcompat.app.g, android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.f513c.q(charSequence);
    }
}
