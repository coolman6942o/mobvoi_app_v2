package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.k;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.a1;
import androidx.appcompat.widget.b0;
import androidx.appcompat.widget.j0;
import d.j;
/* loaded from: classes.dex */
public class ActionMenuItemView extends b0 implements k.a, View.OnClickListener, ActionMenuView.a {

    /* renamed from: g  reason: collision with root package name */
    g f604g;

    /* renamed from: h  reason: collision with root package name */
    private CharSequence f605h;

    /* renamed from: i  reason: collision with root package name */
    private Drawable f606i;

    /* renamed from: j  reason: collision with root package name */
    e.b f607j;

    /* renamed from: k  reason: collision with root package name */
    private j0 f608k;

    /* renamed from: l  reason: collision with root package name */
    b f609l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f610m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f611n;

    /* renamed from: o  reason: collision with root package name */
    private int f612o;

    /* renamed from: p  reason: collision with root package name */
    private int f613p;

    /* renamed from: q  reason: collision with root package name */
    private int f614q;

    /* loaded from: classes.dex */
    private class a extends j0 {
        public a() {
            super(ActionMenuItemView.this);
        }

        @Override // androidx.appcompat.widget.j0
        public j.e b() {
            b bVar = ActionMenuItemView.this.f609l;
            if (bVar != null) {
                return bVar.a();
            }
            return null;
        }

        @Override // androidx.appcompat.widget.j0
        protected boolean c() {
            j.e b10;
            ActionMenuItemView actionMenuItemView = ActionMenuItemView.this;
            e.b bVar = actionMenuItemView.f607j;
            return bVar != null && bVar.a(actionMenuItemView.f604g) && (b10 = b()) != null && b10.b();
        }
    }

    /* loaded from: classes.dex */
    public static abstract class b {
        public abstract j.e a();
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private boolean g() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i10 = configuration.screenWidthDp;
        return i10 >= 480 || (i10 >= 640 && configuration.screenHeightDp >= 480) || configuration.orientation == 2;
    }

    private void h() {
        boolean z10 = true;
        boolean z11 = !TextUtils.isEmpty(this.f605h);
        if (this.f606i != null && (!this.f604g.B() || (!this.f610m && !this.f611n))) {
            z10 = false;
        }
        boolean z12 = z11 & z10;
        CharSequence charSequence = null;
        setText(z12 ? this.f605h : null);
        CharSequence contentDescription = this.f604g.getContentDescription();
        if (TextUtils.isEmpty(contentDescription)) {
            setContentDescription(z12 ? null : this.f604g.getTitle());
        } else {
            setContentDescription(contentDescription);
        }
        CharSequence tooltipText = this.f604g.getTooltipText();
        if (TextUtils.isEmpty(tooltipText)) {
            if (!z12) {
                charSequence = this.f604g.getTitle();
            }
            a1.a(this, charSequence);
            return;
        }
        a1.a(this, tooltipText);
    }

    @Override // androidx.appcompat.widget.ActionMenuView.a
    public boolean a() {
        return f();
    }

    @Override // androidx.appcompat.widget.ActionMenuView.a
    public boolean b() {
        return f() && this.f604g.getIcon() == null;
    }

    @Override // androidx.appcompat.view.menu.k.a
    public boolean d() {
        return true;
    }

    @Override // androidx.appcompat.view.menu.k.a
    public void e(g gVar, int i10) {
        this.f604g = gVar;
        setIcon(gVar.getIcon());
        setTitle(gVar.i(this));
        setId(gVar.getItemId());
        setVisibility(gVar.isVisible() ? 0 : 8);
        setEnabled(gVar.isEnabled());
        if (gVar.hasSubMenu() && this.f608k == null) {
            this.f608k = new a();
        }
    }

    public boolean f() {
        return !TextUtils.isEmpty(getText());
    }

    @Override // androidx.appcompat.view.menu.k.a
    public g getItemData() {
        return this.f604g;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        e.b bVar = this.f607j;
        if (bVar != null) {
            bVar.a(this.f604g);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f610m = g();
        h();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.b0, android.widget.TextView, android.view.View
    public void onMeasure(int i10, int i11) {
        int i12;
        int i13;
        boolean f10 = f();
        if (f10 && (i13 = this.f613p) >= 0) {
            super.setPadding(i13, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i10, i11);
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        int measuredWidth = getMeasuredWidth();
        if (mode == Integer.MIN_VALUE) {
            i12 = Math.min(size, this.f612o);
        } else {
            i12 = this.f612o;
        }
        if (mode != 1073741824 && this.f612o > 0 && measuredWidth < i12) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(i12, 1073741824), i11);
        }
        if (!f10 && this.f606i != null) {
            super.setPadding((getMeasuredWidth() - this.f606i.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        j0 j0Var;
        if (!this.f604g.hasSubMenu() || (j0Var = this.f608k) == null || !j0Var.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    public void setCheckable(boolean z10) {
    }

    public void setChecked(boolean z10) {
    }

    public void setExpandedFormat(boolean z10) {
        if (this.f611n != z10) {
            this.f611n = z10;
            g gVar = this.f604g;
            if (gVar != null) {
                gVar.c();
            }
        }
    }

    public void setIcon(Drawable drawable) {
        this.f606i = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i10 = this.f614q;
            if (intrinsicWidth > i10) {
                intrinsicHeight = (int) (intrinsicHeight * (i10 / intrinsicWidth));
                intrinsicWidth = i10;
            }
            if (intrinsicHeight > i10) {
                intrinsicWidth = (int) (intrinsicWidth * (i10 / intrinsicHeight));
            } else {
                i10 = intrinsicHeight;
            }
            drawable.setBounds(0, 0, intrinsicWidth, i10);
        }
        setCompoundDrawables(drawable, null, null, null);
        h();
    }

    public void setItemInvoker(e.b bVar) {
        this.f607j = bVar;
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i10, int i11, int i12, int i13) {
        this.f613p = i10;
        super.setPadding(i10, i11, i12, i13);
    }

    public void setPopupCallback(b bVar) {
        this.f609l = bVar;
    }

    public void setTitle(CharSequence charSequence) {
        this.f605h = charSequence;
        h();
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        Resources resources = context.getResources();
        this.f610m = g();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.f24959v, i10, 0);
        this.f612o = obtainStyledAttributes.getDimensionPixelSize(j.f24964w, 0);
        obtainStyledAttributes.recycle();
        this.f614q = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.f613p = -1;
        setSaveEnabled(false);
    }
}
