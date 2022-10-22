package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import d.j;
import i.b;
/* compiled from: ActionBar.java */
/* loaded from: classes.dex */
public abstract class a {

    /* compiled from: ActionBar.java */
    /* loaded from: classes.dex */
    public interface b {
        void a(boolean z10);
    }

    /* compiled from: ActionBar.java */
    @Deprecated
    /* loaded from: classes.dex */
    public static abstract class c {
        public abstract CharSequence a();

        public abstract View b();

        public abstract Drawable c();

        public abstract CharSequence d();

        public abstract void e();
    }

    public abstract void A(CharSequence charSequence);

    public i.b B(b.a aVar) {
        return null;
    }

    public boolean g() {
        return false;
    }

    public abstract boolean h();

    public abstract void i(boolean z10);

    public abstract int j();

    public abstract Context k();

    public abstract void l();

    public boolean m() {
        return false;
    }

    public void n(Configuration configuration) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o() {
    }

    public abstract boolean p(int i10, KeyEvent keyEvent);

    public boolean q(KeyEvent keyEvent) {
        return false;
    }

    public boolean r() {
        return false;
    }

    public abstract void s(boolean z10);

    public abstract void t(boolean z10);

    public abstract void u(boolean z10);

    public abstract void v(int i10);

    public abstract void w(int i10);

    public abstract void x(Drawable drawable);

    public abstract void y(boolean z10);

    public abstract void z(CharSequence charSequence);

    /* compiled from: ActionBar.java */
    /* renamed from: androidx.appcompat.app.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0005a extends ViewGroup.MarginLayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public int f512a;

        public C0005a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f512a = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.f24949t);
            this.f512a = obtainStyledAttributes.getInt(j.f24954u, 0);
            obtainStyledAttributes.recycle();
        }

        public C0005a(int i10, int i11) {
            super(i10, i11);
            this.f512a = 0;
            this.f512a = 8388627;
        }

        public C0005a(C0005a aVar) {
            super((ViewGroup.MarginLayoutParams) aVar);
            this.f512a = 0;
            this.f512a = aVar.f512a;
        }

        public C0005a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f512a = 0;
        }
    }
}
