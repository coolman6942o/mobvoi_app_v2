package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.view.menu.k;
import androidx.appcompat.widget.x0;
import androidx.core.view.d0;
import d.a;
import d.f;
import d.g;
import d.j;
/* loaded from: classes.dex */
public class ListMenuItemView extends LinearLayout implements k.a, AbsListView.SelectionBoundsAdjuster {

    /* renamed from: a  reason: collision with root package name */
    private g f619a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f620b;

    /* renamed from: c  reason: collision with root package name */
    private RadioButton f621c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f622d;

    /* renamed from: e  reason: collision with root package name */
    private CheckBox f623e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f624f;

    /* renamed from: g  reason: collision with root package name */
    private ImageView f625g;

    /* renamed from: h  reason: collision with root package name */
    private ImageView f626h;

    /* renamed from: i  reason: collision with root package name */
    private LinearLayout f627i;

    /* renamed from: j  reason: collision with root package name */
    private Drawable f628j;

    /* renamed from: k  reason: collision with root package name */
    private int f629k;

    /* renamed from: l  reason: collision with root package name */
    private Context f630l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f631m;

    /* renamed from: n  reason: collision with root package name */
    private Drawable f632n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f633o;

    /* renamed from: p  reason: collision with root package name */
    private LayoutInflater f634p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f635q;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.F);
    }

    private void a(View view) {
        b(view, -1);
    }

    private void b(View view, int i10) {
        LinearLayout linearLayout = this.f627i;
        if (linearLayout != null) {
            linearLayout.addView(view, i10);
        } else {
            addView(view, i10);
        }
    }

    private void c() {
        CheckBox checkBox = (CheckBox) getInflater().inflate(g.f24822h, (ViewGroup) this, false);
        this.f623e = checkBox;
        a(checkBox);
    }

    private void f() {
        ImageView imageView = (ImageView) getInflater().inflate(g.f24823i, (ViewGroup) this, false);
        this.f620b = imageView;
        b(imageView, 0);
    }

    private void g() {
        RadioButton radioButton = (RadioButton) getInflater().inflate(g.f24825k, (ViewGroup) this, false);
        this.f621c = radioButton;
        a(radioButton);
    }

    private LayoutInflater getInflater() {
        if (this.f634p == null) {
            this.f634p = LayoutInflater.from(getContext());
        }
        return this.f634p;
    }

    private void setSubMenuArrowVisible(boolean z10) {
        ImageView imageView = this.f625g;
        if (imageView != null) {
            imageView.setVisibility(z10 ? 0 : 8);
        }
    }

    @Override // android.widget.AbsListView.SelectionBoundsAdjuster
    public void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.f626h;
        if (imageView != null && imageView.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f626h.getLayoutParams();
            rect.top += this.f626h.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
        }
    }

    @Override // androidx.appcompat.view.menu.k.a
    public boolean d() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.k.a
    public void e(g gVar, int i10) {
        this.f619a = gVar;
        setVisibility(gVar.isVisible() ? 0 : 8);
        setTitle(gVar.i(this));
        setCheckable(gVar.isCheckable());
        h(gVar.A(), gVar.g());
        setIcon(gVar.getIcon());
        setEnabled(gVar.isEnabled());
        setSubMenuArrowVisible(gVar.hasSubMenu());
        setContentDescription(gVar.getContentDescription());
    }

    @Override // androidx.appcompat.view.menu.k.a
    public g getItemData() {
        return this.f619a;
    }

    public void h(boolean z10, char c10) {
        int i10 = (!z10 || !this.f619a.A()) ? 8 : 0;
        if (i10 == 0) {
            this.f624f.setText(this.f619a.h());
        }
        if (this.f624f.getVisibility() != i10) {
            this.f624f.setVisibility(i10);
        }
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        d0.x0(this, this.f628j);
        TextView textView = (TextView) findViewById(f.M);
        this.f622d = textView;
        int i10 = this.f629k;
        if (i10 != -1) {
            textView.setTextAppearance(this.f630l, i10);
        }
        this.f624f = (TextView) findViewById(f.F);
        ImageView imageView = (ImageView) findViewById(f.I);
        this.f625g = imageView;
        if (imageView != null) {
            imageView.setImageDrawable(this.f632n);
        }
        this.f626h = (ImageView) findViewById(f.f24806r);
        this.f627i = (LinearLayout) findViewById(f.f24800l);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i10, int i11) {
        if (this.f620b != null && this.f631m) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f620b.getLayoutParams();
            int i12 = layoutParams.height;
            if (i12 > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = i12;
            }
        }
        super.onMeasure(i10, i11);
    }

    public void setCheckable(boolean z10) {
        CompoundButton compoundButton;
        CompoundButton compoundButton2;
        if (z10 || this.f621c != null || this.f623e != null) {
            if (this.f619a.m()) {
                if (this.f621c == null) {
                    g();
                }
                compoundButton2 = this.f621c;
                compoundButton = this.f623e;
            } else {
                if (this.f623e == null) {
                    c();
                }
                compoundButton2 = this.f623e;
                compoundButton = this.f621c;
            }
            if (z10) {
                compoundButton2.setChecked(this.f619a.isChecked());
                if (compoundButton2.getVisibility() != 0) {
                    compoundButton2.setVisibility(0);
                }
                if (compoundButton != null && compoundButton.getVisibility() != 8) {
                    compoundButton.setVisibility(8);
                    return;
                }
                return;
            }
            CheckBox checkBox = this.f623e;
            if (checkBox != null) {
                checkBox.setVisibility(8);
            }
            RadioButton radioButton = this.f621c;
            if (radioButton != null) {
                radioButton.setVisibility(8);
            }
        }
    }

    public void setChecked(boolean z10) {
        CompoundButton compoundButton;
        if (this.f619a.m()) {
            if (this.f621c == null) {
                g();
            }
            compoundButton = this.f621c;
        } else {
            if (this.f623e == null) {
                c();
            }
            compoundButton = this.f623e;
        }
        compoundButton.setChecked(z10);
    }

    public void setForceShowIcon(boolean z10) {
        this.f635q = z10;
        this.f631m = z10;
    }

    public void setGroupDividerEnabled(boolean z10) {
        ImageView imageView = this.f626h;
        if (imageView != null) {
            imageView.setVisibility((this.f633o || !z10) ? 8 : 0);
        }
    }

    public void setIcon(Drawable drawable) {
        boolean z10 = this.f619a.z() || this.f635q;
        if (z10 || this.f631m) {
            ImageView imageView = this.f620b;
            if (imageView != null || drawable != null || this.f631m) {
                if (imageView == null) {
                    f();
                }
                if (drawable != null || this.f631m) {
                    ImageView imageView2 = this.f620b;
                    if (!z10) {
                        drawable = null;
                    }
                    imageView2.setImageDrawable(drawable);
                    if (this.f620b.getVisibility() != 0) {
                        this.f620b.setVisibility(0);
                        return;
                    }
                    return;
                }
                this.f620b.setVisibility(8);
            }
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.f622d.setText(charSequence);
            if (this.f622d.getVisibility() != 0) {
                this.f622d.setVisibility(0);
            }
        } else if (this.f622d.getVisibility() != 8) {
            this.f622d.setVisibility(8);
        }
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet);
        x0 v10 = x0.v(getContext(), attributeSet, j.X1, i10, 0);
        this.f628j = v10.g(j.Z1);
        this.f629k = v10.n(j.Y1, -1);
        this.f631m = v10.a(j.f24857a2, false);
        this.f630l = context;
        this.f632n = v10.g(j.f24862b2);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, new int[]{16843049}, a.C, 0);
        this.f633o = obtainStyledAttributes.hasValue(0);
        v10.w();
        obtainStyledAttributes.recycle();
    }
}
