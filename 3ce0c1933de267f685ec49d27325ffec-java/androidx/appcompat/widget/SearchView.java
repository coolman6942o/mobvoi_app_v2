package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.d0;
import androidx.customview.view.AbsSavedState;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public class SearchView extends LinearLayoutCompat implements i.c {

    /* renamed from: z0  reason: collision with root package name */
    static final n f940z0;
    private Rect A;
    private int[] B;
    private int[] C;
    private final ImageView D;
    private final Drawable E;
    private final int F;
    private final int G;
    private final Intent H;
    private final Intent I;
    private final CharSequence J;
    private l K;
    private k L;
    View.OnFocusChangeListener M;
    private m N;
    private View.OnClickListener O;
    private boolean P;
    private boolean Q;
    n0.a R;
    private boolean S;
    private CharSequence T;
    private boolean U;
    private boolean V;
    private int W;

    /* renamed from: j0  reason: collision with root package name */
    private boolean f941j0;

    /* renamed from: k0  reason: collision with root package name */
    private CharSequence f942k0;

    /* renamed from: l0  reason: collision with root package name */
    private CharSequence f943l0;

    /* renamed from: m0  reason: collision with root package name */
    private boolean f944m0;

    /* renamed from: n0  reason: collision with root package name */
    private int f945n0;

    /* renamed from: o0  reason: collision with root package name */
    SearchableInfo f946o0;

    /* renamed from: p  reason: collision with root package name */
    final SearchAutoComplete f947p;

    /* renamed from: p0  reason: collision with root package name */
    private Bundle f948p0;

    /* renamed from: q  reason: collision with root package name */
    private final View f949q;

    /* renamed from: q0  reason: collision with root package name */
    private final Runnable f950q0;

    /* renamed from: r  reason: collision with root package name */
    private final View f951r;

    /* renamed from: r0  reason: collision with root package name */
    private Runnable f952r0;

    /* renamed from: s  reason: collision with root package name */
    private final View f953s;

    /* renamed from: s0  reason: collision with root package name */
    private final WeakHashMap<String, Drawable.ConstantState> f954s0;

    /* renamed from: t  reason: collision with root package name */
    final ImageView f955t;

    /* renamed from: t0  reason: collision with root package name */
    private final View.OnClickListener f956t0;

    /* renamed from: u  reason: collision with root package name */
    final ImageView f957u;

    /* renamed from: u0  reason: collision with root package name */
    View.OnKeyListener f958u0;

    /* renamed from: v  reason: collision with root package name */
    final ImageView f959v;

    /* renamed from: v0  reason: collision with root package name */
    private final TextView.OnEditorActionListener f960v0;

    /* renamed from: w  reason: collision with root package name */
    final ImageView f961w;

    /* renamed from: w0  reason: collision with root package name */
    private final AdapterView.OnItemClickListener f962w0;

    /* renamed from: x  reason: collision with root package name */
    private final View f963x;

    /* renamed from: x0  reason: collision with root package name */
    private final AdapterView.OnItemSelectedListener f964x0;

    /* renamed from: y  reason: collision with root package name */
    private o f965y;

    /* renamed from: y0  reason: collision with root package name */
    private TextWatcher f966y0;

    /* renamed from: z  reason: collision with root package name */
    private Rect f967z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: c  reason: collision with root package name */
        boolean f968c;

        /* loaded from: classes.dex */
        class a implements Parcelable.ClassLoaderCreator<SavedState> {
            a() {
            }

            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            /* renamed from: b */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            /* renamed from: c */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.f968c + "}";
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeValue(Boolean.valueOf(this.f968c));
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f968c = ((Boolean) parcel.readValue(null)).booleanValue();
        }
    }

    /* loaded from: classes.dex */
    public static class SearchAutoComplete extends androidx.appcompat.widget.c {

        /* renamed from: e  reason: collision with root package name */
        private int f969e;

        /* renamed from: f  reason: collision with root package name */
        private SearchView f970f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f971g;

        /* renamed from: h  reason: collision with root package name */
        final Runnable f972h;

        /* loaded from: classes.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SearchAutoComplete.this.c();
            }
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, d.a.f24728p);
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int i10 = configuration.screenWidthDp;
            int i11 = configuration.screenHeightDp;
            if (i10 >= 960 && i11 >= 720 && configuration.orientation == 2) {
                return 256;
            }
            if (i10 < 600) {
                return (i10 < 640 || i11 < 480) ? 160 : 192;
            }
            return 192;
        }

        void a() {
            if (Build.VERSION.SDK_INT >= 29) {
                setInputMethodMode(1);
                if (enoughToFilter()) {
                    showDropDown();
                    return;
                }
                return;
            }
            SearchView.f940z0.c(this);
        }

        boolean b() {
            return TextUtils.getTrimmedLength(getText()) == 0;
        }

        void c() {
            if (this.f971g) {
                ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
                this.f971g = false;
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public boolean enoughToFilter() {
            return this.f969e <= 0 || super.enoughToFilter();
        }

        @Override // androidx.appcompat.widget.c, android.widget.TextView, android.view.View
        public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (this.f971g) {
                removeCallbacks(this.f972h);
                post(this.f972h);
            }
            return onCreateInputConnection;
        }

        @Override // android.view.View
        protected void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        protected void onFocusChanged(boolean z10, int i10, Rect rect) {
            super.onFocusChanged(z10, i10, rect);
            this.f970f.Z();
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public boolean onKeyPreIme(int i10, KeyEvent keyEvent) {
            if (i10 == 4) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                    }
                    return true;
                } else if (keyEvent.getAction() == 1) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.f970f.clearFocus();
                        setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i10, keyEvent);
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public void onWindowFocusChanged(boolean z10) {
            super.onWindowFocusChanged(z10);
            if (z10 && this.f970f.hasFocus() && getVisibility() == 0) {
                this.f971g = true;
                if (SearchView.M(getContext())) {
                    a();
                }
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public void performCompletion() {
        }

        @Override // android.widget.AutoCompleteTextView
        protected void replaceText(CharSequence charSequence) {
        }

        void setImeVisibility(boolean z10) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            if (!z10) {
                this.f971g = false;
                removeCallbacks(this.f972h);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else if (inputMethodManager.isActive(this)) {
                this.f971g = false;
                removeCallbacks(this.f972h);
                inputMethodManager.showSoftInput(this, 0);
            } else {
                this.f971g = true;
            }
        }

        void setSearchView(SearchView searchView) {
            this.f970f = searchView;
        }

        @Override // android.widget.AutoCompleteTextView
        public void setThreshold(int i10) {
            super.setThreshold(i10);
            this.f969e = i10;
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i10) {
            super(context, attributeSet, i10);
            this.f972h = new a();
            this.f969e = getThreshold();
        }
    }

    /* loaded from: classes.dex */
    class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            SearchView.this.Y(charSequence);
        }
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SearchView.this.f0();
        }
    }

    /* loaded from: classes.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            n0.a aVar = SearchView.this.R;
            if (aVar instanceof r0) {
                aVar.a(null);
            }
        }
    }

    /* loaded from: classes.dex */
    class d implements View.OnFocusChangeListener {
        d() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z10) {
            SearchView searchView = SearchView.this;
            View.OnFocusChangeListener onFocusChangeListener = searchView.M;
            if (onFocusChangeListener != null) {
                onFocusChangeListener.onFocusChange(searchView, z10);
            }
        }
    }

    /* loaded from: classes.dex */
    class e implements View.OnLayoutChangeListener {
        e() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
            SearchView.this.B();
        }
    }

    /* loaded from: classes.dex */
    class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SearchView searchView = SearchView.this;
            if (view == searchView.f955t) {
                searchView.V();
            } else if (view == searchView.f959v) {
                searchView.R();
            } else if (view == searchView.f957u) {
                searchView.W();
            } else if (view == searchView.f961w) {
                searchView.a0();
            } else if (view == searchView.f947p) {
                searchView.H();
            }
        }
    }

    /* loaded from: classes.dex */
    class g implements View.OnKeyListener {
        g() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i10, KeyEvent keyEvent) {
            SearchView searchView = SearchView.this;
            if (searchView.f946o0 == null) {
                return false;
            }
            if (searchView.f947p.isPopupShowing() && SearchView.this.f947p.getListSelection() != -1) {
                return SearchView.this.X(view, i10, keyEvent);
            }
            if (SearchView.this.f947p.b() || !keyEvent.hasNoModifiers() || keyEvent.getAction() != 1 || i10 != 66) {
                return false;
            }
            view.cancelLongPress();
            SearchView searchView2 = SearchView.this;
            searchView2.P(0, null, searchView2.f947p.getText().toString());
            return true;
        }
    }

    /* loaded from: classes.dex */
    class h implements TextView.OnEditorActionListener {
        h() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i10, KeyEvent keyEvent) {
            SearchView.this.W();
            return true;
        }
    }

    /* loaded from: classes.dex */
    class i implements AdapterView.OnItemClickListener {
        i() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
            SearchView.this.S(i10, 0, null);
        }
    }

    /* loaded from: classes.dex */
    class j implements AdapterView.OnItemSelectedListener {
        j() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i10, long j10) {
            SearchView.this.T(i10);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* loaded from: classes.dex */
    public interface k {
        boolean a();
    }

    /* loaded from: classes.dex */
    public interface l {
        boolean a(String str);

        boolean b(String str);
    }

    /* loaded from: classes.dex */
    public interface m {
        boolean a(int i10);

        boolean b(int i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class n {

        /* renamed from: a  reason: collision with root package name */
        private Method f984a;

        /* renamed from: b  reason: collision with root package name */
        private Method f985b;

        /* renamed from: c  reason: collision with root package name */
        private Method f986c;

        @SuppressLint({"DiscouragedPrivateApi", "SoonBlockedPrivateApi"})
        n() {
            this.f984a = null;
            this.f985b = null;
            this.f986c = null;
            d();
            try {
                Method declaredMethod = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
                this.f984a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            try {
                Method declaredMethod2 = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
                this.f985b = declaredMethod2;
                declaredMethod2.setAccessible(true);
            } catch (NoSuchMethodException unused2) {
            }
            try {
                Method method = AutoCompleteTextView.class.getMethod("ensureImeVisible", Boolean.TYPE);
                this.f986c = method;
                method.setAccessible(true);
            } catch (NoSuchMethodException unused3) {
            }
        }

        private static void d() {
            if (Build.VERSION.SDK_INT >= 29) {
                throw new UnsupportedClassVersionError("This function can only be used for API Level < 29.");
            }
        }

        void a(AutoCompleteTextView autoCompleteTextView) {
            d();
            Method method = this.f985b;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception unused) {
                }
            }
        }

        void b(AutoCompleteTextView autoCompleteTextView) {
            d();
            Method method = this.f984a;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception unused) {
                }
            }
        }

        void c(AutoCompleteTextView autoCompleteTextView) {
            d();
            Method method = this.f986c;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, Boolean.TRUE);
                } catch (Exception unused) {
                }
            }
        }
    }

    /* loaded from: classes.dex */
    private static class o extends TouchDelegate {

        /* renamed from: a  reason: collision with root package name */
        private final View f987a;

        /* renamed from: e  reason: collision with root package name */
        private final int f991e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f992f;

        /* renamed from: b  reason: collision with root package name */
        private final Rect f988b = new Rect();

        /* renamed from: d  reason: collision with root package name */
        private final Rect f990d = new Rect();

        /* renamed from: c  reason: collision with root package name */
        private final Rect f989c = new Rect();

        public o(Rect rect, Rect rect2, View view) {
            super(rect, view);
            this.f991e = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            a(rect, rect2);
            this.f987a = view;
        }

        public void a(Rect rect, Rect rect2) {
            this.f988b.set(rect);
            this.f990d.set(rect);
            Rect rect3 = this.f990d;
            int i10 = this.f991e;
            rect3.inset(-i10, -i10);
            this.f989c.set(rect2);
        }

        @Override // android.view.TouchDelegate
        public boolean onTouchEvent(MotionEvent motionEvent) {
            boolean z10;
            boolean z11;
            int x10 = (int) motionEvent.getX();
            int y10 = (int) motionEvent.getY();
            int action = motionEvent.getAction();
            boolean z12 = true;
            if (action != 0) {
                if (action == 1 || action == 2) {
                    z11 = this.f992f;
                    if (z11 && !this.f990d.contains(x10, y10)) {
                        z12 = z11;
                        z10 = false;
                    }
                } else {
                    if (action == 3) {
                        z11 = this.f992f;
                        this.f992f = false;
                    }
                    z10 = true;
                    z12 = false;
                }
                z12 = z11;
                z10 = true;
            } else {
                if (this.f988b.contains(x10, y10)) {
                    this.f992f = true;
                    z10 = true;
                }
                z10 = true;
                z12 = false;
            }
            if (!z12) {
                return false;
            }
            if (!z10 || this.f989c.contains(x10, y10)) {
                Rect rect = this.f989c;
                motionEvent.setLocation(x10 - rect.left, y10 - rect.top);
            } else {
                motionEvent.setLocation(this.f987a.getWidth() / 2, this.f987a.getHeight() / 2);
            }
            return this.f987a.dispatchTouchEvent(motionEvent);
        }
    }

    static {
        f940z0 = Build.VERSION.SDK_INT < 29 ? new n() : null;
    }

    public SearchView(Context context) {
        this(context, null);
    }

    private Intent C(String str, Uri uri, String str2, String str3, int i10, String str4) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.f943l0);
        if (str3 != null) {
            intent.putExtra("query", str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        Bundle bundle = this.f948p0;
        if (bundle != null) {
            intent.putExtra("app_data", bundle);
        }
        if (i10 != 0) {
            intent.putExtra("action_key", i10);
            intent.putExtra("action_msg", str4);
        }
        intent.setComponent(this.f946o0.getSearchActivity());
        return intent;
    }

    private Intent D(Cursor cursor, int i10, String str) {
        int i11;
        Uri uri;
        String o10;
        try {
            String o11 = r0.o(cursor, "suggest_intent_action");
            if (o11 == null) {
                o11 = this.f946o0.getSuggestIntentAction();
            }
            if (o11 == null) {
                o11 = "android.intent.action.SEARCH";
            }
            String str2 = o11;
            String o12 = r0.o(cursor, "suggest_intent_data");
            if (o12 == null) {
                o12 = this.f946o0.getSuggestIntentData();
            }
            if (!(o12 == null || (o10 = r0.o(cursor, "suggest_intent_data_id")) == null)) {
                o12 = o12 + "/" + Uri.encode(o10);
            }
            if (o12 == null) {
                uri = null;
            } else {
                uri = Uri.parse(o12);
            }
            return C(str2, uri, r0.o(cursor, "suggest_intent_extra_data"), r0.o(cursor, "suggest_intent_query"), i10, str);
        } catch (RuntimeException e10) {
            try {
                i11 = cursor.getPosition();
            } catch (RuntimeException unused) {
                i11 = -1;
            }
            Log.w("SearchView", "Search suggestions cursor at row " + i11 + " returned exception.", e10);
            return null;
        }
    }

    private Intent E(Intent intent, SearchableInfo searchableInfo) {
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        Intent intent2 = new Intent("android.intent.action.SEARCH");
        intent2.setComponent(searchActivity);
        PendingIntent activity = PendingIntent.getActivity(getContext(), 0, intent2, 1107296256);
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f948p0;
        if (bundle2 != null) {
            bundle.putParcelable("app_data", bundle2);
        }
        Intent intent3 = new Intent(intent);
        int i10 = 1;
        Resources resources = getResources();
        String string = searchableInfo.getVoiceLanguageModeId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageModeId()) : "free_form";
        String str = null;
        String string2 = searchableInfo.getVoicePromptTextId() != 0 ? resources.getString(searchableInfo.getVoicePromptTextId()) : null;
        String string3 = searchableInfo.getVoiceLanguageId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageId()) : null;
        if (searchableInfo.getVoiceMaxResults() != 0) {
            i10 = searchableInfo.getVoiceMaxResults();
        }
        intent3.putExtra("android.speech.extra.LANGUAGE_MODEL", string);
        intent3.putExtra("android.speech.extra.PROMPT", string2);
        intent3.putExtra("android.speech.extra.LANGUAGE", string3);
        intent3.putExtra("android.speech.extra.MAX_RESULTS", i10);
        if (searchActivity != null) {
            str = searchActivity.flattenToShortString();
        }
        intent3.putExtra("calling_package", str);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", activity);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
        return intent3;
    }

    private Intent F(Intent intent, SearchableInfo searchableInfo) {
        Intent intent2 = new Intent(intent);
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        intent2.putExtra("calling_package", searchActivity == null ? null : searchActivity.flattenToShortString());
        return intent2;
    }

    private void G() {
        this.f947p.dismissDropDown();
    }

    private void I(View view, Rect rect) {
        view.getLocationInWindow(this.B);
        getLocationInWindow(this.C);
        int[] iArr = this.B;
        int i10 = iArr[1];
        int[] iArr2 = this.C;
        int i11 = i10 - iArr2[1];
        int i12 = iArr[0] - iArr2[0];
        rect.set(i12, i11, view.getWidth() + i12, view.getHeight() + i11);
    }

    private CharSequence J(CharSequence charSequence) {
        if (!this.P || this.E == null) {
            return charSequence;
        }
        int textSize = (int) (this.f947p.getTextSize() * 1.25d);
        this.E.setBounds(0, 0, textSize, textSize);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
        spannableStringBuilder.setSpan(new ImageSpan(this.E), 1, 2, 33);
        spannableStringBuilder.append(charSequence);
        return spannableStringBuilder;
    }

    private boolean K() {
        SearchableInfo searchableInfo = this.f946o0;
        if (searchableInfo == null || !searchableInfo.getVoiceSearchEnabled()) {
            return false;
        }
        Intent intent = null;
        if (this.f946o0.getVoiceSearchLaunchWebSearch()) {
            intent = this.H;
        } else if (this.f946o0.getVoiceSearchLaunchRecognizer()) {
            intent = this.I;
        }
        return (intent == null || getContext().getPackageManager().resolveActivity(intent, WXMediaMessage.THUMB_LENGTH_LIMIT) == null) ? false : true;
    }

    static boolean M(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    private boolean N() {
        return (this.S || this.f941j0) && !L();
    }

    private void O(Intent intent) {
        if (intent != null) {
            try {
                getContext().startActivity(intent);
            } catch (RuntimeException e10) {
                Log.e("SearchView", "Failed launch activity: " + intent, e10);
            }
        }
    }

    private boolean Q(int i10, int i11, String str) {
        Cursor b10 = this.R.b();
        if (b10 == null || !b10.moveToPosition(i10)) {
            return false;
        }
        O(D(b10, i11, str));
        return true;
    }

    private void b0() {
        post(this.f950q0);
    }

    private void c0(int i10) {
        Editable text = this.f947p.getText();
        Cursor b10 = this.R.b();
        if (b10 != null) {
            if (b10.moveToPosition(i10)) {
                CharSequence c10 = this.R.c(b10);
                if (c10 != null) {
                    setQuery(c10);
                } else {
                    setQuery(text);
                }
            } else {
                setQuery(text);
            }
        }
    }

    private void e0() {
        boolean z10 = true;
        boolean z11 = !TextUtils.isEmpty(this.f947p.getText());
        int i10 = 0;
        if (!z11 && (!this.P || this.f944m0)) {
            z10 = false;
        }
        ImageView imageView = this.f959v;
        if (!z10) {
            i10 = 8;
        }
        imageView.setVisibility(i10);
        Drawable drawable = this.f959v.getDrawable();
        if (drawable != null) {
            drawable.setState(z11 ? ViewGroup.ENABLED_STATE_SET : ViewGroup.EMPTY_STATE_SET);
        }
    }

    private void g0() {
        CharSequence queryHint = getQueryHint();
        SearchAutoComplete searchAutoComplete = this.f947p;
        if (queryHint == null) {
            queryHint = "";
        }
        searchAutoComplete.setHint(J(queryHint));
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(d.d.f24754g);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(d.d.f24755h);
    }

    private void h0() {
        this.f947p.setThreshold(this.f946o0.getSuggestThreshold());
        this.f947p.setImeOptions(this.f946o0.getImeOptions());
        int inputType = this.f946o0.getInputType();
        int i10 = 1;
        if ((inputType & 15) == 1) {
            inputType &= -65537;
            if (this.f946o0.getSuggestAuthority() != null) {
                inputType = inputType | WXMediaMessage.THUMB_LENGTH_LIMIT | 524288;
            }
        }
        this.f947p.setInputType(inputType);
        n0.a aVar = this.R;
        if (aVar != null) {
            aVar.a(null);
        }
        if (this.f946o0.getSuggestAuthority() != null) {
            r0 r0Var = new r0(getContext(), this, this.f946o0, this.f954s0);
            this.R = r0Var;
            this.f947p.setAdapter(r0Var);
            r0 r0Var2 = (r0) this.R;
            if (this.U) {
                i10 = 2;
            }
            r0Var2.x(i10);
        }
    }

    private void i0() {
        this.f953s.setVisibility((!N() || !(this.f957u.getVisibility() == 0 || this.f961w.getVisibility() == 0)) ? 8 : 0);
    }

    private void j0(boolean z10) {
        this.f957u.setVisibility((!this.S || !N() || !hasFocus() || (!z10 && this.f941j0)) ? 8 : 0);
    }

    private void k0(boolean z10) {
        this.Q = z10;
        int i10 = 0;
        int i11 = z10 ? 0 : 8;
        boolean z11 = !TextUtils.isEmpty(this.f947p.getText());
        this.f955t.setVisibility(i11);
        j0(z11);
        this.f949q.setVisibility(z10 ? 8 : 0);
        if (this.D.getDrawable() == null || this.P) {
            i10 = 8;
        }
        this.D.setVisibility(i10);
        e0();
        l0(!z11);
        i0();
    }

    private void l0(boolean z10) {
        int i10 = 8;
        if (this.f941j0 && !L() && z10) {
            i10 = 0;
            this.f957u.setVisibility(8);
        }
        this.f961w.setVisibility(i10);
    }

    private void setQuery(CharSequence charSequence) {
        this.f947p.setText(charSequence);
        this.f947p.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    void B() {
        int i10;
        if (this.f963x.getWidth() > 1) {
            Resources resources = getContext().getResources();
            int paddingLeft = this.f951r.getPaddingLeft();
            Rect rect = new Rect();
            boolean b10 = e1.b(this);
            int dimensionPixelSize = this.P ? resources.getDimensionPixelSize(d.d.f24752e) + resources.getDimensionPixelSize(d.d.f24753f) : 0;
            this.f947p.getDropDownBackground().getPadding(rect);
            if (b10) {
                i10 = -rect.left;
            } else {
                i10 = paddingLeft - (rect.left + dimensionPixelSize);
            }
            this.f947p.setDropDownHorizontalOffset(i10);
            this.f947p.setDropDownWidth((((this.f963x.getWidth() + rect.left) + rect.right) + dimensionPixelSize) - paddingLeft);
        }
    }

    void H() {
        if (Build.VERSION.SDK_INT >= 29) {
            this.f947p.refreshAutoCompleteResults();
            return;
        }
        n nVar = f940z0;
        nVar.b(this.f947p);
        nVar.a(this.f947p);
    }

    public boolean L() {
        return this.Q;
    }

    void P(int i10, String str, String str2) {
        getContext().startActivity(C("android.intent.action.SEARCH", null, null, str2, i10, str));
    }

    void R() {
        if (!TextUtils.isEmpty(this.f947p.getText())) {
            this.f947p.setText("");
            this.f947p.requestFocus();
            this.f947p.setImeVisibility(true);
        } else if (this.P) {
            k kVar = this.L;
            if (kVar == null || !kVar.a()) {
                clearFocus();
                k0(true);
            }
        }
    }

    boolean S(int i10, int i11, String str) {
        m mVar = this.N;
        if (mVar != null && mVar.b(i10)) {
            return false;
        }
        Q(i10, 0, null);
        this.f947p.setImeVisibility(false);
        G();
        return true;
    }

    boolean T(int i10) {
        m mVar = this.N;
        if (mVar != null && mVar.a(i10)) {
            return false;
        }
        c0(i10);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void U(CharSequence charSequence) {
        setQuery(charSequence);
    }

    void V() {
        k0(false);
        this.f947p.requestFocus();
        this.f947p.setImeVisibility(true);
        View.OnClickListener onClickListener = this.O;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    void W() {
        Editable text = this.f947p.getText();
        if (text != null && TextUtils.getTrimmedLength(text) > 0) {
            l lVar = this.K;
            if (lVar == null || !lVar.b(text.toString())) {
                if (this.f946o0 != null) {
                    P(0, null, text.toString());
                }
                this.f947p.setImeVisibility(false);
                G();
            }
        }
    }

    boolean X(View view, int i10, KeyEvent keyEvent) {
        if (this.f946o0 != null && this.R != null && keyEvent.getAction() == 0 && keyEvent.hasNoModifiers()) {
            if (i10 == 66 || i10 == 84 || i10 == 61) {
                return S(this.f947p.getListSelection(), 0, null);
            }
            if (i10 == 21 || i10 == 22) {
                this.f947p.setSelection(i10 == 21 ? 0 : this.f947p.length());
                this.f947p.setListSelection(0);
                this.f947p.clearListSelection();
                this.f947p.a();
                return true;
            } else if (i10 == 19) {
                this.f947p.getListSelection();
                return false;
            }
        }
        return false;
    }

    void Y(CharSequence charSequence) {
        Editable text = this.f947p.getText();
        this.f943l0 = text;
        boolean z10 = !TextUtils.isEmpty(text);
        j0(z10);
        l0(!z10);
        e0();
        i0();
        if (this.K != null && !TextUtils.equals(charSequence, this.f942k0)) {
            this.K.a(charSequence.toString());
        }
        this.f942k0 = charSequence.toString();
    }

    void Z() {
        k0(L());
        b0();
        if (this.f947p.hasFocus()) {
            H();
        }
    }

    void a0() {
        SearchableInfo searchableInfo = this.f946o0;
        if (searchableInfo != null) {
            try {
                if (searchableInfo.getVoiceSearchLaunchWebSearch()) {
                    getContext().startActivity(F(this.H, searchableInfo));
                } else if (searchableInfo.getVoiceSearchLaunchRecognizer()) {
                    getContext().startActivity(E(this.I, searchableInfo));
                }
            } catch (ActivityNotFoundException unused) {
                Log.w("SearchView", "Could not find voice search activity");
            }
        }
    }

    @Override // i.c
    public void c() {
        if (!this.f944m0) {
            this.f944m0 = true;
            int imeOptions = this.f947p.getImeOptions();
            this.f945n0 = imeOptions;
            this.f947p.setImeOptions(imeOptions | 33554432);
            this.f947p.setText("");
            setIconified(false);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void clearFocus() {
        this.V = true;
        super.clearFocus();
        this.f947p.clearFocus();
        this.f947p.setImeVisibility(false);
        this.V = false;
    }

    public void d0(CharSequence charSequence, boolean z10) {
        this.f947p.setText(charSequence);
        if (charSequence != null) {
            SearchAutoComplete searchAutoComplete = this.f947p;
            searchAutoComplete.setSelection(searchAutoComplete.length());
            this.f943l0 = charSequence;
        }
        if (z10 && !TextUtils.isEmpty(charSequence)) {
            W();
        }
    }

    @Override // i.c
    public void f() {
        d0("", false);
        clearFocus();
        k0(true);
        this.f947p.setImeOptions(this.f945n0);
        this.f944m0 = false;
    }

    void f0() {
        int[] iArr = this.f947p.hasFocus() ? ViewGroup.FOCUSED_STATE_SET : ViewGroup.EMPTY_STATE_SET;
        Drawable background = this.f951r.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        Drawable background2 = this.f953s.getBackground();
        if (background2 != null) {
            background2.setState(iArr);
        }
        invalidate();
    }

    public int getImeOptions() {
        return this.f947p.getImeOptions();
    }

    public int getInputType() {
        return this.f947p.getInputType();
    }

    public int getMaxWidth() {
        return this.W;
    }

    public CharSequence getQuery() {
        return this.f947p.getText();
    }

    public CharSequence getQueryHint() {
        CharSequence charSequence = this.T;
        if (charSequence != null) {
            return charSequence;
        }
        SearchableInfo searchableInfo = this.f946o0;
        if (searchableInfo == null || searchableInfo.getHintId() == 0) {
            return this.J;
        }
        return getContext().getText(this.f946o0.getHintId());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getSuggestionCommitIconResId() {
        return this.G;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getSuggestionRowLayout() {
        return this.F;
    }

    public n0.a getSuggestionsAdapter() {
        return this.R;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.f950q0);
        post(this.f952r0);
        super.onDetachedFromWindow();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        if (z10) {
            I(this.f947p, this.f967z);
            Rect rect = this.A;
            Rect rect2 = this.f967z;
            rect.set(rect2.left, 0, rect2.right, i13 - i11);
            o oVar = this.f965y;
            if (oVar == null) {
                o oVar2 = new o(this.A, this.f967z, this.f947p);
                this.f965y = oVar2;
                setTouchDelegate(oVar2);
                return;
            }
            oVar.a(this.A, this.f967z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    public void onMeasure(int i10, int i11) {
        int i12;
        if (L()) {
            super.onMeasure(i10, i11);
            return;
        }
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        if (mode == Integer.MIN_VALUE) {
            int i13 = this.W;
            size = i13 > 0 ? Math.min(i13, size) : Math.min(getPreferredWidth(), size);
        } else if (mode == 0) {
            size = this.W;
            if (size <= 0) {
                size = getPreferredWidth();
            }
        } else if (mode == 1073741824 && (i12 = this.W) > 0) {
            size = Math.min(i12, size);
        }
        int mode2 = View.MeasureSpec.getMode(i11);
        int size2 = View.MeasureSpec.getSize(i11);
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(getPreferredHeight(), size2);
        } else if (mode2 == 0) {
            size2 = getPreferredHeight();
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        k0(savedState.f968c);
        requestLayout();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f968c = L();
        return savedState;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        b0();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean requestFocus(int i10, Rect rect) {
        if (this.V || !isFocusable()) {
            return false;
        }
        if (L()) {
            return super.requestFocus(i10, rect);
        }
        boolean requestFocus = this.f947p.requestFocus(i10, rect);
        if (requestFocus) {
            k0(false);
        }
        return requestFocus;
    }

    public void setAppSearchData(Bundle bundle) {
        this.f948p0 = bundle;
    }

    public void setIconified(boolean z10) {
        if (z10) {
            R();
        } else {
            V();
        }
    }

    public void setIconifiedByDefault(boolean z10) {
        if (this.P != z10) {
            this.P = z10;
            k0(z10);
            g0();
        }
    }

    public void setImeOptions(int i10) {
        this.f947p.setImeOptions(i10);
    }

    public void setInputType(int i10) {
        this.f947p.setInputType(i10);
    }

    public void setMaxWidth(int i10) {
        this.W = i10;
        requestLayout();
    }

    public void setOnCloseListener(k kVar) {
        this.L = kVar;
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.M = onFocusChangeListener;
    }

    public void setOnQueryTextListener(l lVar) {
        this.K = lVar;
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.O = onClickListener;
    }

    public void setOnSuggestionListener(m mVar) {
        this.N = mVar;
    }

    public void setQueryHint(CharSequence charSequence) {
        this.T = charSequence;
        g0();
    }

    public void setQueryRefinementEnabled(boolean z10) {
        this.U = z10;
        n0.a aVar = this.R;
        if (aVar instanceof r0) {
            ((r0) aVar).x(z10 ? 2 : 1);
        }
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.f946o0 = searchableInfo;
        if (searchableInfo != null) {
            h0();
            g0();
        }
        boolean K = K();
        this.f941j0 = K;
        if (K) {
            this.f947p.setPrivateImeOptions("nm");
        }
        k0(L());
    }

    public void setSubmitButtonEnabled(boolean z10) {
        this.S = z10;
        k0(L());
    }

    public void setSuggestionsAdapter(n0.a aVar) {
        this.R = aVar;
        this.f947p.setAdapter(aVar);
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, d.a.K);
    }

    public SearchView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f967z = new Rect();
        this.A = new Rect();
        this.B = new int[2];
        this.C = new int[2];
        this.f950q0 = new b();
        this.f952r0 = new c();
        this.f954s0 = new WeakHashMap<>();
        f fVar = new f();
        this.f956t0 = fVar;
        this.f958u0 = new g();
        h hVar = new h();
        this.f960v0 = hVar;
        i iVar = new i();
        this.f962w0 = iVar;
        j jVar = new j();
        this.f964x0 = jVar;
        this.f966y0 = new a();
        int[] iArr = d.j.f24897i2;
        x0 v10 = x0.v(context, attributeSet, iArr, i10, 0);
        d0.r0(this, context, iArr, attributeSet, v10.r(), i10, 0);
        LayoutInflater.from(context).inflate(v10.n(d.j.f24947s2, d.g.f24832r), (ViewGroup) this, true);
        SearchAutoComplete searchAutoComplete = (SearchAutoComplete) findViewById(d.f.D);
        this.f947p = searchAutoComplete;
        searchAutoComplete.setSearchView(this);
        this.f949q = findViewById(d.f.f24814z);
        View findViewById = findViewById(d.f.C);
        this.f951r = findViewById;
        View findViewById2 = findViewById(d.f.J);
        this.f953s = findViewById2;
        ImageView imageView = (ImageView) findViewById(d.f.f24812x);
        this.f955t = imageView;
        ImageView imageView2 = (ImageView) findViewById(d.f.A);
        this.f957u = imageView2;
        ImageView imageView3 = (ImageView) findViewById(d.f.f24813y);
        this.f959v = imageView3;
        ImageView imageView4 = (ImageView) findViewById(d.f.E);
        this.f961w = imageView4;
        ImageView imageView5 = (ImageView) findViewById(d.f.B);
        this.D = imageView5;
        d0.x0(findViewById, v10.g(d.j.f24952t2));
        d0.x0(findViewById2, v10.g(d.j.f24972x2));
        int i11 = d.j.f24967w2;
        imageView.setImageDrawable(v10.g(i11));
        imageView2.setImageDrawable(v10.g(d.j.f24937q2));
        imageView3.setImageDrawable(v10.g(d.j.f24922n2));
        imageView4.setImageDrawable(v10.g(d.j.f24982z2));
        imageView5.setImageDrawable(v10.g(i11));
        this.E = v10.g(d.j.f24962v2);
        a1.a(imageView, getResources().getString(d.h.f24848n));
        this.F = v10.n(d.j.f24977y2, d.g.f24831q);
        this.G = v10.n(d.j.f24927o2, 0);
        imageView.setOnClickListener(fVar);
        imageView3.setOnClickListener(fVar);
        imageView2.setOnClickListener(fVar);
        imageView4.setOnClickListener(fVar);
        searchAutoComplete.setOnClickListener(fVar);
        searchAutoComplete.addTextChangedListener(this.f966y0);
        searchAutoComplete.setOnEditorActionListener(hVar);
        searchAutoComplete.setOnItemClickListener(iVar);
        searchAutoComplete.setOnItemSelectedListener(jVar);
        searchAutoComplete.setOnKeyListener(this.f958u0);
        searchAutoComplete.setOnFocusChangeListener(new d());
        setIconifiedByDefault(v10.a(d.j.f24942r2, true));
        int f10 = v10.f(d.j.f24907k2, -1);
        if (f10 != -1) {
            setMaxWidth(f10);
        }
        this.J = v10.p(d.j.f24932p2);
        this.T = v10.p(d.j.f24957u2);
        int k10 = v10.k(d.j.f24917m2, -1);
        if (k10 != -1) {
            setImeOptions(k10);
        }
        int k11 = v10.k(d.j.f24912l2, -1);
        if (k11 != -1) {
            setInputType(k11);
        }
        setFocusable(v10.a(d.j.f24902j2, true));
        v10.w();
        Intent intent = new Intent("android.speech.action.WEB_SEARCH");
        this.H = intent;
        intent.addFlags(268435456);
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        Intent intent2 = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.I = intent2;
        intent2.addFlags(268435456);
        View findViewById3 = findViewById(searchAutoComplete.getDropDownAnchor());
        this.f963x = findViewById3;
        if (findViewById3 != null) {
            findViewById3.addOnLayoutChangeListener(new e());
        }
        k0(this.P);
        g0();
    }
}
