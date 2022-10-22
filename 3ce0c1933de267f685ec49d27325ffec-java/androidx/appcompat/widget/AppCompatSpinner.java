package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;
import androidx.appcompat.app.c;
import androidx.core.view.b0;
import androidx.core.view.d0;
import d.g;
import d.j;
/* loaded from: classes.dex */
public class AppCompatSpinner extends Spinner implements b0 {

    /* renamed from: i  reason: collision with root package name */
    private static final int[] f889i = {16843505};

    /* renamed from: a  reason: collision with root package name */
    private final androidx.appcompat.widget.d f890a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f891b;

    /* renamed from: c  reason: collision with root package name */
    private j0 f892c;

    /* renamed from: d  reason: collision with root package name */
    private SpinnerAdapter f893d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f894e;

    /* renamed from: f  reason: collision with root package name */
    private f f895f;

    /* renamed from: g  reason: collision with root package name */
    int f896g;

    /* renamed from: h  reason: collision with root package name */
    final Rect f897h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        boolean f898a;

        /* loaded from: classes.dex */
        class a implements Parcelable.Creator<SavedState> {
            a() {
            }

            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* renamed from: b */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeByte(this.f898a ? (byte) 1 : (byte) 0);
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.f898a = parcel.readByte() != 0;
        }
    }

    /* loaded from: classes.dex */
    class a extends j0 {

        /* renamed from: j  reason: collision with root package name */
        final /* synthetic */ e f899j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(View view, e eVar) {
            super(view);
            this.f899j = eVar;
        }

        @Override // androidx.appcompat.widget.j0
        public j.e b() {
            return this.f899j;
        }

        @Override // androidx.appcompat.widget.j0
        @SuppressLint({"SyntheticAccessor"})
        public boolean c() {
            if (AppCompatSpinner.this.getInternalPopup().b()) {
                return true;
            }
            AppCompatSpinner.this.b();
            return true;
        }
    }

    /* loaded from: classes.dex */
    class b implements ViewTreeObserver.OnGlobalLayoutListener {
        b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!AppCompatSpinner.this.getInternalPopup().b()) {
                AppCompatSpinner.this.b();
            }
            ViewTreeObserver viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver();
            if (viewTreeObserver == null) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 16) {
                viewTreeObserver.removeOnGlobalLayoutListener(this);
            } else {
                viewTreeObserver.removeGlobalOnLayoutListener(this);
            }
        }
    }

    /* loaded from: classes.dex */
    class c implements f, DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        androidx.appcompat.app.c f902a;

        /* renamed from: b  reason: collision with root package name */
        private ListAdapter f903b;

        /* renamed from: c  reason: collision with root package name */
        private CharSequence f904c;

        c() {
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.f
        public boolean b() {
            androidx.appcompat.app.c cVar = this.f902a;
            if (cVar != null) {
                return cVar.isShowing();
            }
            return false;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.f
        public void c(Drawable drawable) {
            Log.e("AppCompatSpinner", "Cannot set popup background for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.f
        public int d() {
            return 0;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.f
        public void dismiss() {
            androidx.appcompat.app.c cVar = this.f902a;
            if (cVar != null) {
                cVar.dismiss();
                this.f902a = null;
            }
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.f
        public void f(int i10) {
            Log.e("AppCompatSpinner", "Cannot set horizontal offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.f
        public CharSequence g() {
            return this.f904c;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.f
        public Drawable i() {
            return null;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.f
        public void j(CharSequence charSequence) {
            this.f904c = charSequence;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.f
        public void l(int i10) {
            Log.e("AppCompatSpinner", "Cannot set vertical offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.f
        public void m(int i10) {
            Log.e("AppCompatSpinner", "Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.f
        public void n(int i10, int i11) {
            if (this.f903b != null) {
                c.a aVar = new c.a(AppCompatSpinner.this.getPopupContext());
                CharSequence charSequence = this.f904c;
                if (charSequence != null) {
                    aVar.r(charSequence);
                }
                androidx.appcompat.app.c a10 = aVar.p(this.f903b, AppCompatSpinner.this.getSelectedItemPosition(), this).a();
                this.f902a = a10;
                ListView e10 = a10.e();
                if (Build.VERSION.SDK_INT >= 17) {
                    e10.setTextDirection(i10);
                    e10.setTextAlignment(i11);
                }
                this.f902a.show();
            }
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.f
        public int o() {
            return 0;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            AppCompatSpinner.this.setSelection(i10);
            if (AppCompatSpinner.this.getOnItemClickListener() != null) {
                AppCompatSpinner.this.performItemClick(null, i10, this.f903b.getItemId(i10));
            }
            dismiss();
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.f
        public void p(ListAdapter listAdapter) {
            this.f903b = listAdapter;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class d implements ListAdapter, SpinnerAdapter {

        /* renamed from: a  reason: collision with root package name */
        private SpinnerAdapter f906a;

        /* renamed from: b  reason: collision with root package name */
        private ListAdapter f907b;

        public d(SpinnerAdapter spinnerAdapter, Resources.Theme theme) {
            this.f906a = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.f907b = (ListAdapter) spinnerAdapter;
            }
            if (theme == null) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 23 && (spinnerAdapter instanceof ThemedSpinnerAdapter)) {
                ThemedSpinnerAdapter themedSpinnerAdapter = (ThemedSpinnerAdapter) spinnerAdapter;
                if (themedSpinnerAdapter.getDropDownViewTheme() != theme) {
                    themedSpinnerAdapter.setDropDownViewTheme(theme);
                }
            } else if (spinnerAdapter instanceof t0) {
                t0 t0Var = (t0) spinnerAdapter;
                if (t0Var.getDropDownViewTheme() == null) {
                    t0Var.setDropDownViewTheme(theme);
                }
            }
        }

        @Override // android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.f907b;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            SpinnerAdapter spinnerAdapter = this.f906a;
            if (spinnerAdapter == null) {
                return 0;
            }
            return spinnerAdapter.getCount();
        }

        @Override // android.widget.SpinnerAdapter
        public View getDropDownView(int i10, View view, ViewGroup viewGroup) {
            SpinnerAdapter spinnerAdapter = this.f906a;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getDropDownView(i10, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public Object getItem(int i10) {
            SpinnerAdapter spinnerAdapter = this.f906a;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getItem(i10);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i10) {
            SpinnerAdapter spinnerAdapter = this.f906a;
            if (spinnerAdapter == null) {
                return -1L;
            }
            return spinnerAdapter.getItemId(i10);
        }

        @Override // android.widget.Adapter
        public int getItemViewType(int i10) {
            return 0;
        }

        @Override // android.widget.Adapter
        public View getView(int i10, View view, ViewGroup viewGroup) {
            return getDropDownView(i10, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public int getViewTypeCount() {
            return 1;
        }

        @Override // android.widget.Adapter
        public boolean hasStableIds() {
            SpinnerAdapter spinnerAdapter = this.f906a;
            return spinnerAdapter != null && spinnerAdapter.hasStableIds();
        }

        @Override // android.widget.Adapter
        public boolean isEmpty() {
            return getCount() == 0;
        }

        @Override // android.widget.ListAdapter
        public boolean isEnabled(int i10) {
            ListAdapter listAdapter = this.f907b;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i10);
            }
            return true;
        }

        @Override // android.widget.Adapter
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f906a;
            if (spinnerAdapter != null) {
                spinnerAdapter.registerDataSetObserver(dataSetObserver);
            }
        }

        @Override // android.widget.Adapter
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f906a;
            if (spinnerAdapter != null) {
                spinnerAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    /* loaded from: classes.dex */
    class e extends k0 implements f {
        private CharSequence I;
        ListAdapter J;
        private final Rect K = new Rect();
        private int L;

        /* loaded from: classes.dex */
        class a implements AdapterView.OnItemClickListener {
            a(AppCompatSpinner appCompatSpinner) {
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
                AppCompatSpinner.this.setSelection(i10);
                if (AppCompatSpinner.this.getOnItemClickListener() != null) {
                    e eVar = e.this;
                    AppCompatSpinner.this.performItemClick(view, i10, eVar.J.getItemId(i10));
                }
                e.this.dismiss();
            }
        }

        /* loaded from: classes.dex */
        class b implements ViewTreeObserver.OnGlobalLayoutListener {
            b() {
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                e eVar = e.this;
                if (!eVar.U(AppCompatSpinner.this)) {
                    e.this.dismiss();
                    return;
                }
                e.this.S();
                e.super.a();
            }
        }

        /* loaded from: classes.dex */
        class c implements PopupWindow.OnDismissListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener f910a;

            c(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
                this.f910a = onGlobalLayoutListener;
            }

            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                ViewTreeObserver viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    viewTreeObserver.removeGlobalOnLayoutListener(this.f910a);
                }
            }
        }

        public e(Context context, AttributeSet attributeSet, int i10) {
            super(context, attributeSet, i10);
            D(AppCompatSpinner.this);
            J(true);
            O(0);
            L(new a(AppCompatSpinner.this));
        }

        void S() {
            int i10;
            Drawable i11 = i();
            int i12 = 0;
            if (i11 != null) {
                i11.getPadding(AppCompatSpinner.this.f897h);
                i12 = e1.b(AppCompatSpinner.this) ? AppCompatSpinner.this.f897h.right : -AppCompatSpinner.this.f897h.left;
            } else {
                Rect rect = AppCompatSpinner.this.f897h;
                rect.right = 0;
                rect.left = 0;
            }
            int paddingLeft = AppCompatSpinner.this.getPaddingLeft();
            int paddingRight = AppCompatSpinner.this.getPaddingRight();
            int width = AppCompatSpinner.this.getWidth();
            AppCompatSpinner appCompatSpinner = AppCompatSpinner.this;
            int i13 = appCompatSpinner.f896g;
            if (i13 == -2) {
                int a10 = appCompatSpinner.a((SpinnerAdapter) this.J, i());
                int i14 = AppCompatSpinner.this.getContext().getResources().getDisplayMetrics().widthPixels;
                Rect rect2 = AppCompatSpinner.this.f897h;
                int i15 = (i14 - rect2.left) - rect2.right;
                if (a10 > i15) {
                    a10 = i15;
                }
                F(Math.max(a10, (width - paddingLeft) - paddingRight));
            } else if (i13 == -1) {
                F((width - paddingLeft) - paddingRight);
            } else {
                F(i13);
            }
            if (e1.b(AppCompatSpinner.this)) {
                i10 = i12 + (((width - paddingRight) - z()) - T());
            } else {
                i10 = i12 + paddingLeft + T();
            }
            f(i10);
        }

        public int T() {
            return this.L;
        }

        boolean U(View view) {
            return d0.W(view) && view.getGlobalVisibleRect(this.K);
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.f
        public CharSequence g() {
            return this.I;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.f
        public void j(CharSequence charSequence) {
            this.I = charSequence;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.f
        public void m(int i10) {
            this.L = i10;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.f
        public void n(int i10, int i11) {
            ViewTreeObserver viewTreeObserver;
            boolean b10 = b();
            S();
            I(2);
            super.a();
            ListView k10 = k();
            k10.setChoiceMode(1);
            if (Build.VERSION.SDK_INT >= 17) {
                k10.setTextDirection(i10);
                k10.setTextAlignment(i11);
            }
            P(AppCompatSpinner.this.getSelectedItemPosition());
            if (!b10 && (viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver()) != null) {
                b bVar = new b();
                viewTreeObserver.addOnGlobalLayoutListener(bVar);
                K(new c(bVar));
            }
        }

        @Override // androidx.appcompat.widget.k0, androidx.appcompat.widget.AppCompatSpinner.f
        public void p(ListAdapter listAdapter) {
            super.p(listAdapter);
            this.J = listAdapter;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface f {
        boolean b();

        void c(Drawable drawable);

        int d();

        void dismiss();

        void f(int i10);

        CharSequence g();

        Drawable i();

        void j(CharSequence charSequence);

        void l(int i10);

        void m(int i10);

        void n(int i10, int i11);

        int o();

        void p(ListAdapter listAdapter);
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, d.a.M);
    }

    int a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i10 = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int max = Math.max(0, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        View view = null;
        int i11 = 0;
        for (int max2 = Math.max(0, max - (15 - (min - max))); max2 < min; max2++) {
            int itemViewType = spinnerAdapter.getItemViewType(max2);
            if (itemViewType != i10) {
                view = null;
                i10 = itemViewType;
            }
            view = spinnerAdapter.getView(max2, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i11 = Math.max(i11, view.getMeasuredWidth());
        }
        if (drawable == null) {
            return i11;
        }
        drawable.getPadding(this.f897h);
        Rect rect = this.f897h;
        return i11 + rect.left + rect.right;
    }

    void b() {
        if (Build.VERSION.SDK_INT >= 17) {
            this.f895f.n(getTextDirection(), getTextAlignment());
        } else {
            this.f895f.n(-1, -1);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        androidx.appcompat.widget.d dVar = this.f890a;
        if (dVar != null) {
            dVar.b();
        }
    }

    @Override // android.widget.Spinner
    public int getDropDownHorizontalOffset() {
        f fVar = this.f895f;
        if (fVar != null) {
            return fVar.d();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownHorizontalOffset();
        }
        return 0;
    }

    @Override // android.widget.Spinner
    public int getDropDownVerticalOffset() {
        f fVar = this.f895f;
        if (fVar != null) {
            return fVar.o();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownVerticalOffset();
        }
        return 0;
    }

    @Override // android.widget.Spinner
    public int getDropDownWidth() {
        if (this.f895f != null) {
            return this.f896g;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownWidth();
        }
        return 0;
    }

    final f getInternalPopup() {
        return this.f895f;
    }

    @Override // android.widget.Spinner
    public Drawable getPopupBackground() {
        f fVar = this.f895f;
        if (fVar != null) {
            return fVar.i();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getPopupBackground();
        }
        return null;
    }

    @Override // android.widget.Spinner
    public Context getPopupContext() {
        return this.f891b;
    }

    @Override // android.widget.Spinner
    public CharSequence getPrompt() {
        f fVar = this.f895f;
        return fVar != null ? fVar.g() : super.getPrompt();
    }

    @Override // androidx.core.view.b0
    public ColorStateList getSupportBackgroundTintList() {
        androidx.appcompat.widget.d dVar = this.f890a;
        if (dVar != null) {
            return dVar.c();
        }
        return null;
    }

    @Override // androidx.core.view.b0
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        androidx.appcompat.widget.d dVar = this.f890a;
        if (dVar != null) {
            return dVar.d();
        }
        return null;
    }

    @Override // android.widget.Spinner, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        f fVar = this.f895f;
        if (fVar != null && fVar.b()) {
            this.f895f.dismiss();
        }
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    protected void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        if (this.f895f != null && View.MeasureSpec.getMode(i10) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), View.MeasureSpec.getSize(i10)), getMeasuredHeight());
        }
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        ViewTreeObserver viewTreeObserver;
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.f898a && (viewTreeObserver = getViewTreeObserver()) != null) {
            viewTreeObserver.addOnGlobalLayoutListener(new b());
        }
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        f fVar = this.f895f;
        savedState.f898a = fVar != null && fVar.b();
        return savedState;
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        j0 j0Var = this.f892c;
        if (j0Var == null || !j0Var.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean performClick() {
        f fVar = this.f895f;
        if (fVar == null) {
            return super.performClick();
        }
        if (fVar.b()) {
            return true;
        }
        b();
        return true;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        androidx.appcompat.widget.d dVar = this.f890a;
        if (dVar != null) {
            dVar.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i10) {
        super.setBackgroundResource(i10);
        androidx.appcompat.widget.d dVar = this.f890a;
        if (dVar != null) {
            dVar.g(i10);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownHorizontalOffset(int i10) {
        f fVar = this.f895f;
        if (fVar != null) {
            fVar.m(i10);
            this.f895f.f(i10);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownHorizontalOffset(i10);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownVerticalOffset(int i10) {
        f fVar = this.f895f;
        if (fVar != null) {
            fVar.l(i10);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownVerticalOffset(i10);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownWidth(int i10) {
        if (this.f895f != null) {
            this.f896g = i10;
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownWidth(i10);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundDrawable(Drawable drawable) {
        f fVar = this.f895f;
        if (fVar != null) {
            fVar.c(drawable);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundResource(int i10) {
        setPopupBackgroundDrawable(e.a.b(getPopupContext(), i10));
    }

    @Override // android.widget.Spinner
    public void setPrompt(CharSequence charSequence) {
        f fVar = this.f895f;
        if (fVar != null) {
            fVar.j(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    @Override // androidx.core.view.b0
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        androidx.appcompat.widget.d dVar = this.f890a;
        if (dVar != null) {
            dVar.i(colorStateList);
        }
    }

    @Override // androidx.core.view.b0
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        androidx.appcompat.widget.d dVar = this.f890a;
        if (dVar != null) {
            dVar.j(mode);
        }
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, -1);
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner
    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.f894e) {
            this.f893d = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        if (this.f895f != null) {
            Context context = this.f891b;
            if (context == null) {
                context = getContext();
            }
            this.f895f.p(new d(spinnerAdapter, context.getTheme()));
        }
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet, int i10, int i11) {
        this(context, attributeSet, i10, i11, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0060, code lost:
        if (r11 == null) goto L27;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v13 */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v5, types: [android.content.res.TypedArray] */
    /* JADX WARN: Type inference failed for: r6v0, types: [androidx.appcompat.widget.AppCompatSpinner, android.view.View, android.widget.Spinner] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public AppCompatSpinner(Context context, AttributeSet attributeSet, int i10, int i11, Resources.Theme theme) {
        super(context, attributeSet, i10);
        Throwable th2;
        TypedArray typedArray;
        Exception e10;
        this.f897h = new Rect();
        s0.a(this, getContext());
        x0 v10 = x0.v(context, attributeSet, j.A2, i10, 0);
        this.f890a = new androidx.appcompat.widget.d(this);
        if (theme != null) {
            this.f891b = new i.d(context, theme);
        } else {
            int n10 = v10.n(j.F2, 0);
            if (n10 != 0) {
                this.f891b = new i.d(context, n10);
            } else {
                this.f891b = context;
            }
        }
        ?? r11 = -1;
        TypedArray typedArray2 = null;
        try {
            if (i11 == -1) {
                try {
                    typedArray = context.obtainStyledAttributes(attributeSet, f889i, i10, 0);
                    try {
                        boolean hasValue = typedArray.hasValue(0);
                        r11 = typedArray;
                        if (hasValue) {
                            i11 = typedArray.getInt(0, 0);
                            r11 = typedArray;
                        }
                    } catch (Exception e11) {
                        e10 = e11;
                        Log.i("AppCompatSpinner", "Could not read android:spinnerMode", e10);
                        r11 = typedArray;
                    }
                } catch (Exception e12) {
                    e10 = e12;
                    typedArray = null;
                } catch (Throwable th3) {
                    th2 = th3;
                    if (typedArray2 != null) {
                        typedArray2.recycle();
                    }
                    throw th2;
                }
                r11.recycle();
            }
            if (i11 == 0) {
                c cVar = new c();
                this.f895f = cVar;
                cVar.j(v10.o(j.D2));
            } else if (i11 == 1) {
                e eVar = new e(this.f891b, attributeSet, i10);
                x0 v11 = x0.v(this.f891b, attributeSet, j.A2, i10, 0);
                this.f896g = v11.m(j.E2, -2);
                eVar.c(v11.g(j.C2));
                eVar.j(v10.o(j.D2));
                v11.w();
                this.f895f = eVar;
                this.f892c = new a(this, eVar);
            }
            CharSequence[] q5 = v10.q(j.B2);
            if (q5 != null) {
                ArrayAdapter arrayAdapter = new ArrayAdapter(context, 17367048, q5);
                arrayAdapter.setDropDownViewResource(g.f24834t);
                setAdapter(arrayAdapter);
            }
            v10.w();
            this.f894e = true;
            SpinnerAdapter spinnerAdapter = this.f893d;
            if (spinnerAdapter != null) {
                setAdapter(spinnerAdapter);
                this.f893d = null;
            }
            this.f890a.e(attributeSet, i10);
        } catch (Throwable th4) {
            th2 = th4;
            typedArray2 = r11;
        }
    }
}
