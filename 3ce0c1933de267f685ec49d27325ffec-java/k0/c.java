package k0;

import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import com.mobvoi.wear.lpa.LpaConstants;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import k0.f;
/* compiled from: AccessibilityNodeInfoCompat.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: d  reason: collision with root package name */
    private static int f29691d;

    /* renamed from: a  reason: collision with root package name */
    private final AccessibilityNodeInfo f29692a;

    /* renamed from: b  reason: collision with root package name */
    public int f29693b = -1;

    /* renamed from: c  reason: collision with root package name */
    private int f29694c = -1;

    /* compiled from: AccessibilityNodeInfoCompat.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: e  reason: collision with root package name */
        public static final a f29695e = new a(1, null);

        /* renamed from: f  reason: collision with root package name */
        public static final a f29696f = new a(2, null);

        /* renamed from: g  reason: collision with root package name */
        public static final a f29697g = new a(16, null);

        /* renamed from: h  reason: collision with root package name */
        public static final a f29698h = new a(4096, null);

        /* renamed from: i  reason: collision with root package name */
        public static final a f29699i = new a(8192, null);

        /* renamed from: j  reason: collision with root package name */
        public static final a f29700j = new a(262144, null);

        /* renamed from: k  reason: collision with root package name */
        public static final a f29701k = new a(524288, null);

        /* renamed from: l  reason: collision with root package name */
        public static final a f29702l = new a(1048576, null);

        /* renamed from: m  reason: collision with root package name */
        public static final a f29703m;

        /* renamed from: n  reason: collision with root package name */
        public static final a f29704n;

        /* renamed from: a  reason: collision with root package name */
        final Object f29705a;

        /* renamed from: b  reason: collision with root package name */
        private final int f29706b;

        /* renamed from: c  reason: collision with root package name */
        private final Class<? extends f.a> f29707c;

        /* renamed from: d  reason: collision with root package name */
        protected final f f29708d;

        static {
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction = null;
            new a(4, null);
            new a(8, null);
            new a(32, null);
            new a(64, null);
            new a(128, null);
            new a(256, (CharSequence) null, f.b.class);
            new a(512, (CharSequence) null, f.b.class);
            new a(1024, (CharSequence) null, f.c.class);
            new a(2048, (CharSequence) null, f.c.class);
            new a(16384, null);
            new a(32768, null);
            new a(WXMediaMessage.THUMB_LENGTH_LIMIT, null);
            new a((int) WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT, (CharSequence) null, f.g.class);
            new a(2097152, (CharSequence) null, f.h.class);
            int i10 = Build.VERSION.SDK_INT;
            new a(i10 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN : null, 16908342, null, null, null);
            new a(i10 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION : null, 16908343, null, null, f.e.class);
            f29703m = new a(i10 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP : null, 16908344, null, null, null);
            new a(i10 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT : null, 16908345, null, null, null);
            f29704n = new a(i10 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN : null, 16908346, null, null, null);
            new a(i10 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT : null, 16908347, null, null, null);
            new a(i10 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP : null, 16908358, null, null, null);
            new a(i10 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN : null, 16908359, null, null, null);
            new a(i10 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT : null, 16908360, null, null, null);
            new a(i10 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT : null, 16908361, null, null, null);
            new a(i10 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK : null, 16908348, null, null, null);
            new a(i10 >= 24 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS : null, 16908349, null, null, f.C0360f.class);
            new a(i10 >= 26 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW : null, 16908354, null, null, f.d.class);
            new a(i10 >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP : null, 16908356, null, null, null);
            new a(i10 >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP : null, 16908357, null, null, null);
            new a(i10 >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD : null, 16908362, null, null, null);
            if (i10 >= 30) {
                accessibilityAction = AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER;
            }
            new a(accessibilityAction, 16908372, null, null, null);
        }

        public a(int i10, CharSequence charSequence) {
            this(null, i10, charSequence, null, null);
        }

        public a a(CharSequence charSequence, f fVar) {
            return new a(null, this.f29706b, charSequence, fVar, this.f29707c);
        }

        public int b() {
            if (Build.VERSION.SDK_INT >= 21) {
                return ((AccessibilityNodeInfo.AccessibilityAction) this.f29705a).getId();
            }
            return 0;
        }

        public CharSequence c() {
            if (Build.VERSION.SDK_INT >= 21) {
                return ((AccessibilityNodeInfo.AccessibilityAction) this.f29705a).getLabel();
            }
            return null;
        }

        public boolean d(View view, Bundle bundle) {
            Exception e10;
            f.a newInstance;
            if (this.f29708d == null) {
                return false;
            }
            f.a aVar = null;
            Class<? extends f.a> cls = this.f29707c;
            if (cls != null) {
                try {
                    newInstance = cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Exception e11) {
                    e10 = e11;
                }
                try {
                    newInstance.a(bundle);
                    aVar = newInstance;
                } catch (Exception e12) {
                    e10 = e12;
                    aVar = newInstance;
                    Class<? extends f.a> cls2 = this.f29707c;
                    String name = cls2 == null ? LpaConstants.VALUE_NULL : cls2.getName();
                    Log.e("A11yActionCompat", "Failed to execute command with argument class ViewCommandArgument: " + name, e10);
                    return this.f29708d.a(view, aVar);
                }
            }
            return this.f29708d.a(view, aVar);
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            Object obj2 = this.f29705a;
            return obj2 == null ? aVar.f29705a == null : obj2.equals(aVar.f29705a);
        }

        public int hashCode() {
            Object obj = this.f29705a;
            if (obj != null) {
                return obj.hashCode();
            }
            return 0;
        }

        public a(int i10, CharSequence charSequence, f fVar) {
            this(null, i10, charSequence, fVar, null);
        }

        a(Object obj) {
            this(obj, 0, null, null, null);
        }

        private a(int i10, CharSequence charSequence, Class<? extends f.a> cls) {
            this(null, i10, charSequence, null, cls);
        }

        a(Object obj, int i10, CharSequence charSequence, f fVar, Class<? extends f.a> cls) {
            this.f29706b = i10;
            this.f29708d = fVar;
            if (Build.VERSION.SDK_INT < 21 || obj != null) {
                this.f29705a = obj;
            } else {
                this.f29705a = new AccessibilityNodeInfo.AccessibilityAction(i10, charSequence);
            }
            this.f29707c = cls;
        }
    }

    /* compiled from: AccessibilityNodeInfoCompat.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        final Object f29709a;

        b(Object obj) {
            this.f29709a = obj;
        }

        public static b a(int i10, int i11, boolean z10, int i12) {
            int i13 = Build.VERSION.SDK_INT;
            if (i13 >= 21) {
                return new b(AccessibilityNodeInfo.CollectionInfo.obtain(i10, i11, z10, i12));
            }
            if (i13 >= 19) {
                return new b(AccessibilityNodeInfo.CollectionInfo.obtain(i10, i11, z10));
            }
            return new b(null);
        }
    }

    /* compiled from: AccessibilityNodeInfoCompat.java */
    /* renamed from: k0.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0359c {

        /* renamed from: a  reason: collision with root package name */
        final Object f29710a;

        C0359c(Object obj) {
            this.f29710a = obj;
        }

        public static C0359c a(int i10, int i11, int i12, int i13, boolean z10, boolean z11) {
            int i14 = Build.VERSION.SDK_INT;
            if (i14 >= 21) {
                return new C0359c(AccessibilityNodeInfo.CollectionItemInfo.obtain(i10, i11, i12, i13, z10, z11));
            }
            if (i14 >= 19) {
                return new C0359c(AccessibilityNodeInfo.CollectionItemInfo.obtain(i10, i11, i12, i13, z10));
            }
            return new C0359c(null);
        }
    }

    private c(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.f29692a = accessibilityNodeInfo;
    }

    public static c D0(AccessibilityNodeInfo accessibilityNodeInfo) {
        return new c(accessibilityNodeInfo);
    }

    public static c N() {
        return D0(AccessibilityNodeInfo.obtain());
    }

    public static c O(View view) {
        return D0(AccessibilityNodeInfo.obtain(view));
    }

    public static c P(c cVar) {
        return D0(AccessibilityNodeInfo.obtain(cVar.f29692a));
    }

    private void T(View view) {
        SparseArray<WeakReference<ClickableSpan>> v10 = v(view);
        if (v10 != null) {
            ArrayList arrayList = new ArrayList();
            for (int i10 = 0; i10 < v10.size(); i10++) {
                if (v10.valueAt(i10).get() == null) {
                    arrayList.add(Integer.valueOf(i10));
                }
            }
            for (int i11 = 0; i11 < arrayList.size(); i11++) {
                v10.remove(((Integer) arrayList.get(i11)).intValue());
            }
        }
    }

    private void V(int i10, boolean z10) {
        Bundle s10 = s();
        if (s10 != null) {
            int i11 = s10.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & (~i10);
            if (!z10) {
                i10 = 0;
            }
            s10.putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", i10 | i11);
        }
    }

    private void e(ClickableSpan clickableSpan, Spanned spanned, int i10) {
        h("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").add(Integer.valueOf(spanned.getSpanStart(clickableSpan)));
        h("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY").add(Integer.valueOf(spanned.getSpanEnd(clickableSpan)));
        h("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY").add(Integer.valueOf(spanned.getSpanFlags(clickableSpan)));
        h("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY").add(Integer.valueOf(i10));
    }

    private void g() {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f29692a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
            this.f29692a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
            this.f29692a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
            this.f29692a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
        }
    }

    private List<Integer> h(String str) {
        if (Build.VERSION.SDK_INT < 19) {
            return new ArrayList();
        }
        ArrayList<Integer> integerArrayList = this.f29692a.getExtras().getIntegerArrayList(str);
        if (integerArrayList != null) {
            return integerArrayList;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        this.f29692a.getExtras().putIntegerArrayList(str, arrayList);
        return arrayList;
    }

    private static String j(int i10) {
        if (i10 == 1) {
            return "ACTION_FOCUS";
        }
        if (i10 == 2) {
            return "ACTION_CLEAR_FOCUS";
        }
        switch (i10) {
            case 4:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case 16:
                return "ACTION_CLICK";
            case 32:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case 128:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case 256:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case 4096:
                return "ACTION_SCROLL_FORWARD";
            case 8192:
                return "ACTION_SCROLL_BACKWARD";
            case 16384:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case WXMediaMessage.THUMB_LENGTH_LIMIT /* 65536 */:
                return "ACTION_CUT";
            case WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT /* 131072 */:
                return "ACTION_SET_SELECTION";
            case 262144:
                return "ACTION_EXPAND";
            case 524288:
                return "ACTION_COLLAPSE";
            case 2097152:
                return "ACTION_SET_TEXT";
            case 16908354:
                return "ACTION_MOVE_WINDOW";
            case 16908372:
                return "ACTION_IME_ENTER";
            default:
                switch (i10) {
                    case 16908342:
                        return "ACTION_SHOW_ON_SCREEN";
                    case 16908343:
                        return "ACTION_SCROLL_TO_POSITION";
                    case 16908344:
                        return "ACTION_SCROLL_UP";
                    case 16908345:
                        return "ACTION_SCROLL_LEFT";
                    case 16908346:
                        return "ACTION_SCROLL_DOWN";
                    case 16908347:
                        return "ACTION_SCROLL_RIGHT";
                    case 16908348:
                        return "ACTION_CONTEXT_CLICK";
                    case 16908349:
                        return "ACTION_SET_PROGRESS";
                    default:
                        switch (i10) {
                            case 16908356:
                                return "ACTION_SHOW_TOOLTIP";
                            case 16908357:
                                return "ACTION_HIDE_TOOLTIP";
                            case 16908358:
                                return "ACTION_PAGE_UP";
                            case 16908359:
                                return "ACTION_PAGE_DOWN";
                            case 16908360:
                                return "ACTION_PAGE_LEFT";
                            case 16908361:
                                return "ACTION_PAGE_RIGHT";
                            case 16908362:
                                return "ACTION_PRESS_AND_HOLD";
                            default:
                                return "ACTION_UNKNOWN";
                        }
                }
        }
    }

    private boolean l(int i10) {
        Bundle s10 = s();
        return s10 != null && (s10.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & i10) == i10;
    }

    public static ClickableSpan[] q(CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            return (ClickableSpan[]) ((Spanned) charSequence).getSpans(0, charSequence.length(), ClickableSpan.class);
        }
        return null;
    }

    private SparseArray<WeakReference<ClickableSpan>> t(View view) {
        SparseArray<WeakReference<ClickableSpan>> v10 = v(view);
        if (v10 != null) {
            return v10;
        }
        SparseArray<WeakReference<ClickableSpan>> sparseArray = new SparseArray<>();
        view.setTag(z.b.I, sparseArray);
        return sparseArray;
    }

    private SparseArray<WeakReference<ClickableSpan>> v(View view) {
        return (SparseArray) view.getTag(z.b.I);
    }

    private boolean y() {
        return !h("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").isEmpty();
    }

    private int z(ClickableSpan clickableSpan, SparseArray<WeakReference<ClickableSpan>> sparseArray) {
        if (sparseArray != null) {
            for (int i10 = 0; i10 < sparseArray.size(); i10++) {
                if (clickableSpan.equals(sparseArray.valueAt(i10).get())) {
                    return sparseArray.keyAt(i10);
                }
            }
        }
        int i11 = f29691d;
        f29691d = i11 + 1;
        return i11;
    }

    public boolean A() {
        if (Build.VERSION.SDK_INT >= 16) {
            return this.f29692a.isAccessibilityFocused();
        }
        return false;
    }

    public void A0(View view) {
        if (Build.VERSION.SDK_INT >= 22) {
            this.f29692a.setTraversalAfter(view);
        }
    }

    public boolean B() {
        return this.f29692a.isCheckable();
    }

    public void B0(boolean z10) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.f29692a.setVisibleToUser(z10);
        }
    }

    public boolean C() {
        return this.f29692a.isChecked();
    }

    public AccessibilityNodeInfo C0() {
        return this.f29692a;
    }

    public boolean D() {
        return this.f29692a.isClickable();
    }

    public boolean E() {
        return this.f29692a.isEnabled();
    }

    public boolean F() {
        return this.f29692a.isFocusable();
    }

    public boolean G() {
        return this.f29692a.isFocused();
    }

    public boolean H() {
        return this.f29692a.isLongClickable();
    }

    public boolean I() {
        return this.f29692a.isPassword();
    }

    public boolean J() {
        return this.f29692a.isScrollable();
    }

    public boolean K() {
        return this.f29692a.isSelected();
    }

    public boolean L() {
        if (Build.VERSION.SDK_INT >= 26) {
            return this.f29692a.isShowingHintText();
        }
        return l(4);
    }

    public boolean M() {
        if (Build.VERSION.SDK_INT >= 16) {
            return this.f29692a.isVisibleToUser();
        }
        return false;
    }

    public boolean Q(int i10, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            return this.f29692a.performAction(i10, bundle);
        }
        return false;
    }

    public void R() {
        this.f29692a.recycle();
    }

    public boolean S(a aVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            return this.f29692a.removeAction((AccessibilityNodeInfo.AccessibilityAction) aVar.f29705a);
        }
        return false;
    }

    public void U(boolean z10) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.f29692a.setAccessibilityFocused(z10);
        }
    }

    @Deprecated
    public void W(Rect rect) {
        this.f29692a.setBoundsInParent(rect);
    }

    public void X(Rect rect) {
        this.f29692a.setBoundsInScreen(rect);
    }

    public void Y(boolean z10) {
        this.f29692a.setCheckable(z10);
    }

    public void Z(boolean z10) {
        this.f29692a.setChecked(z10);
    }

    public void a(int i10) {
        this.f29692a.addAction(i10);
    }

    public void a0(CharSequence charSequence) {
        this.f29692a.setClassName(charSequence);
    }

    public void b(a aVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f29692a.addAction((AccessibilityNodeInfo.AccessibilityAction) aVar.f29705a);
        }
    }

    public void b0(boolean z10) {
        this.f29692a.setClickable(z10);
    }

    public void c(View view) {
        this.f29692a.addChild(view);
    }

    public void c0(Object obj) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f29692a.setCollectionInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionInfo) ((b) obj).f29709a);
        }
    }

    public void d(View view, int i10) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.f29692a.addChild(view, i10);
        }
    }

    public void d0(Object obj) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f29692a.setCollectionItemInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionItemInfo) ((C0359c) obj).f29710a);
        }
    }

    public void e0(CharSequence charSequence) {
        this.f29692a.setContentDescription(charSequence);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        AccessibilityNodeInfo accessibilityNodeInfo = this.f29692a;
        if (accessibilityNodeInfo == null) {
            if (cVar.f29692a != null) {
                return false;
            }
        } else if (!accessibilityNodeInfo.equals(cVar.f29692a)) {
            return false;
        }
        return this.f29694c == cVar.f29694c && this.f29693b == cVar.f29693b;
    }

    public void f(CharSequence charSequence, View view) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 19 && i10 < 26) {
            g();
            T(view);
            ClickableSpan[] q5 = q(charSequence);
            if (q5 != null && q5.length > 0) {
                s().putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY", z.b.f37156a);
                SparseArray<WeakReference<ClickableSpan>> t10 = t(view);
                for (int i11 = 0; i11 < q5.length; i11++) {
                    int z10 = z(q5[i11], t10);
                    t10.put(z10, new WeakReference<>(q5[i11]));
                    e(q5[i11], (Spanned) charSequence, z10);
                }
            }
        }
    }

    public void f0(boolean z10) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f29692a.setDismissable(z10);
        }
    }

    public void g0(boolean z10) {
        this.f29692a.setEnabled(z10);
    }

    public void h0(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f29692a.setError(charSequence);
        }
    }

    public int hashCode() {
        AccessibilityNodeInfo accessibilityNodeInfo = this.f29692a;
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        return accessibilityNodeInfo.hashCode();
    }

    public List<a> i() {
        List<AccessibilityNodeInfo.AccessibilityAction> actionList = Build.VERSION.SDK_INT >= 21 ? this.f29692a.getActionList() : null;
        if (actionList == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        int size = actionList.size();
        for (int i10 = 0; i10 < size; i10++) {
            arrayList.add(new a(actionList.get(i10)));
        }
        return arrayList;
    }

    public void i0(boolean z10) {
        this.f29692a.setFocusable(z10);
    }

    public void j0(boolean z10) {
        this.f29692a.setFocused(z10);
    }

    public int k() {
        return this.f29692a.getActions();
    }

    public void k0(boolean z10) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f29692a.setHeading(z10);
        } else {
            V(2, z10);
        }
    }

    public void l0(CharSequence charSequence) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 26) {
            this.f29692a.setHintText(charSequence);
        } else if (i10 >= 19) {
            this.f29692a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY", charSequence);
        }
    }

    @Deprecated
    public void m(Rect rect) {
        this.f29692a.getBoundsInParent(rect);
    }

    public void m0(int i10) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f29692a.setMaxTextLength(i10);
        }
    }

    public void n(Rect rect) {
        this.f29692a.getBoundsInScreen(rect);
    }

    public void n0(CharSequence charSequence) {
        this.f29692a.setPackageName(charSequence);
    }

    public int o() {
        return this.f29692a.getChildCount();
    }

    public void o0(CharSequence charSequence) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 28) {
            this.f29692a.setPaneTitle(charSequence);
        } else if (i10 >= 19) {
            this.f29692a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY", charSequence);
        }
    }

    public CharSequence p() {
        return this.f29692a.getClassName();
    }

    public void p0(View view) {
        this.f29693b = -1;
        this.f29692a.setParent(view);
    }

    public void q0(View view, int i10) {
        this.f29693b = i10;
        if (Build.VERSION.SDK_INT >= 16) {
            this.f29692a.setParent(view, i10);
        }
    }

    public CharSequence r() {
        return this.f29692a.getContentDescription();
    }

    public void r0(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f29692a.getExtras().putCharSequence("AccessibilityNodeInfo.roleDescription", charSequence);
        }
    }

    public Bundle s() {
        if (Build.VERSION.SDK_INT >= 19) {
            return this.f29692a.getExtras();
        }
        return new Bundle();
    }

    public void s0(boolean z10) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f29692a.setScreenReaderFocusable(z10);
        } else {
            V(1, z10);
        }
    }

    public void t0(boolean z10) {
        this.f29692a.setScrollable(z10);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        Rect rect = new Rect();
        m(rect);
        sb2.append("; boundsInParent: " + rect);
        n(rect);
        sb2.append("; boundsInScreen: " + rect);
        sb2.append("; packageName: ");
        sb2.append(u());
        sb2.append("; className: ");
        sb2.append(p());
        sb2.append("; text: ");
        sb2.append(w());
        sb2.append("; contentDescription: ");
        sb2.append(r());
        sb2.append("; viewId: ");
        sb2.append(x());
        sb2.append("; checkable: ");
        sb2.append(B());
        sb2.append("; checked: ");
        sb2.append(C());
        sb2.append("; focusable: ");
        sb2.append(F());
        sb2.append("; focused: ");
        sb2.append(G());
        sb2.append("; selected: ");
        sb2.append(K());
        sb2.append("; clickable: ");
        sb2.append(D());
        sb2.append("; longClickable: ");
        sb2.append(H());
        sb2.append("; enabled: ");
        sb2.append(E());
        sb2.append("; password: ");
        sb2.append(I());
        sb2.append("; scrollable: " + J());
        sb2.append("; [");
        if (Build.VERSION.SDK_INT >= 21) {
            List<a> i10 = i();
            for (int i11 = 0; i11 < i10.size(); i11++) {
                a aVar = i10.get(i11);
                String j10 = j(aVar.b());
                if (j10.equals("ACTION_UNKNOWN") && aVar.c() != null) {
                    j10 = aVar.c().toString();
                }
                sb2.append(j10);
                if (i11 != i10.size() - 1) {
                    sb2.append(", ");
                }
            }
        } else {
            int k10 = k();
            while (k10 != 0) {
                int numberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(k10);
                k10 &= ~numberOfTrailingZeros;
                sb2.append(j(numberOfTrailingZeros));
                if (k10 != 0) {
                    sb2.append(", ");
                }
            }
        }
        sb2.append("]");
        return sb2.toString();
    }

    public CharSequence u() {
        return this.f29692a.getPackageName();
    }

    public void u0(boolean z10) {
        this.f29692a.setSelected(z10);
    }

    public void v0(boolean z10) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f29692a.setShowingHintText(z10);
        } else {
            V(4, z10);
        }
    }

    public CharSequence w() {
        if (!y()) {
            return this.f29692a.getText();
        }
        List<Integer> h10 = h("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
        List<Integer> h11 = h("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
        List<Integer> h12 = h("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
        List<Integer> h13 = h("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
        SpannableString spannableString = new SpannableString(TextUtils.substring(this.f29692a.getText(), 0, this.f29692a.getText().length()));
        for (int i10 = 0; i10 < h10.size(); i10++) {
            spannableString.setSpan(new k0.a(h13.get(i10).intValue(), this, s().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY")), h10.get(i10).intValue(), h11.get(i10).intValue(), h12.get(i10).intValue());
        }
        return spannableString;
    }

    public void w0(View view) {
        this.f29694c = -1;
        this.f29692a.setSource(view);
    }

    public String x() {
        if (Build.VERSION.SDK_INT >= 18) {
            return this.f29692a.getViewIdResourceName();
        }
        return null;
    }

    public void x0(View view, int i10) {
        this.f29694c = i10;
        if (Build.VERSION.SDK_INT >= 16) {
            this.f29692a.setSource(view, i10);
        }
    }

    public void y0(CharSequence charSequence) {
        if (g0.a.b()) {
            this.f29692a.setStateDescription(charSequence);
        } else if (Build.VERSION.SDK_INT >= 19) {
            this.f29692a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY", charSequence);
        }
    }

    public void z0(CharSequence charSequence) {
        this.f29692a.setText(charSequence);
    }
}
