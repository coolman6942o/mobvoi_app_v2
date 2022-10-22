package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.IntentSenderRequest;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.fragment.app.w;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.i0;
import androidx.lifecycle.j0;
import androidx.lifecycle.p;
import androidx.savedstate.SavedStateRegistry;
import com.mobvoi.wear.lpa.LpaConstants;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public abstract class FragmentManager {
    private static boolean N = false;
    private androidx.activity.result.b<String[]> A;
    private boolean C;
    private boolean D;
    private boolean E;
    private boolean F;
    private boolean G;
    private ArrayList<androidx.fragment.app.a> H;
    private ArrayList<Boolean> I;
    private ArrayList<Fragment> J;
    private p K;
    private FragmentStrictMode.b L;

    /* renamed from: b  reason: collision with root package name */
    private boolean f2974b;

    /* renamed from: d  reason: collision with root package name */
    ArrayList<androidx.fragment.app.a> f2976d;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<Fragment> f2977e;

    /* renamed from: g  reason: collision with root package name */
    private OnBackPressedDispatcher f2979g;

    /* renamed from: m  reason: collision with root package name */
    private ArrayList<l> f2985m;

    /* renamed from: q  reason: collision with root package name */
    private androidx.fragment.app.k<?> f2989q;

    /* renamed from: r  reason: collision with root package name */
    private androidx.fragment.app.h f2990r;

    /* renamed from: s  reason: collision with root package name */
    private Fragment f2991s;

    /* renamed from: t  reason: collision with root package name */
    Fragment f2992t;

    /* renamed from: y  reason: collision with root package name */
    private androidx.activity.result.b<Intent> f2997y;

    /* renamed from: z  reason: collision with root package name */
    private androidx.activity.result.b<IntentSenderRequest> f2998z;

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<m> f2973a = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    private final v f2975c = new v();

    /* renamed from: f  reason: collision with root package name */
    private final androidx.fragment.app.l f2978f = new androidx.fragment.app.l(this);

    /* renamed from: h  reason: collision with root package name */
    private final androidx.activity.e f2980h = new a(false);

    /* renamed from: i  reason: collision with root package name */
    private final AtomicInteger f2981i = new AtomicInteger();

    /* renamed from: j  reason: collision with root package name */
    private final Map<String, BackStackState> f2982j = Collections.synchronizedMap(new HashMap());

    /* renamed from: k  reason: collision with root package name */
    private final Map<String, Bundle> f2983k = Collections.synchronizedMap(new HashMap());

    /* renamed from: l  reason: collision with root package name */
    private final Map<String, Object> f2984l = Collections.synchronizedMap(new HashMap());

    /* renamed from: n  reason: collision with root package name */
    private final androidx.fragment.app.m f2986n = new androidx.fragment.app.m(this);

    /* renamed from: o  reason: collision with root package name */
    private final CopyOnWriteArrayList<q> f2987o = new CopyOnWriteArrayList<>();

    /* renamed from: p  reason: collision with root package name */
    int f2988p = -1;

    /* renamed from: u  reason: collision with root package name */
    private androidx.fragment.app.j f2993u = null;

    /* renamed from: v  reason: collision with root package name */
    private androidx.fragment.app.j f2994v = new b();

    /* renamed from: w  reason: collision with root package name */
    private e0 f2995w = null;

    /* renamed from: x  reason: collision with root package name */
    private e0 f2996x = new c(this);
    ArrayDeque<LaunchedFragmentInfo> B = new ArrayDeque<>();
    private Runnable M = new d();

    /* renamed from: androidx.fragment.app.FragmentManager$5  reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass5 implements androidx.lifecycle.n {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f2999a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ s f3000b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Lifecycle f3001c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ FragmentManager f3002d;

        @Override // androidx.lifecycle.n
        public void c(p pVar, Lifecycle.Event event) {
            Bundle bundle;
            if (event == Lifecycle.Event.ON_START && (bundle = (Bundle) this.f3002d.f2983k.get(this.f2999a)) != null) {
                this.f3000b.a(this.f2999a, bundle);
                this.f3002d.q(this.f2999a);
            }
            if (event == Lifecycle.Event.ON_DESTROY) {
                this.f3001c.c(this);
                this.f3002d.f2984l.remove(this.f2999a);
            }
        }
    }

    /* loaded from: classes.dex */
    class a extends androidx.activity.e {
        a(boolean z10) {
            super(z10);
        }

        @Override // androidx.activity.e
        public void b() {
            FragmentManager.this.D0();
        }
    }

    /* loaded from: classes.dex */
    class b extends androidx.fragment.app.j {
        b() {
        }

        @Override // androidx.fragment.app.j
        public Fragment a(ClassLoader classLoader, String str) {
            return FragmentManager.this.u0().b(FragmentManager.this.u0().f(), str, null);
        }
    }

    /* loaded from: classes.dex */
    class c implements e0 {
        c(FragmentManager fragmentManager) {
        }

        @Override // androidx.fragment.app.e0
        public d0 a(ViewGroup viewGroup) {
            return new androidx.fragment.app.b(viewGroup);
        }
    }

    /* loaded from: classes.dex */
    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FragmentManager.this.Y(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e implements q {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Fragment f3008a;

        e(FragmentManager fragmentManager, Fragment fragment) {
            this.f3008a = fragment;
        }

        @Override // androidx.fragment.app.q
        public void a(FragmentManager fragmentManager, Fragment fragment) {
            this.f3008a.onAttachFragment(fragment);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f implements androidx.activity.result.a<ActivityResult> {
        f() {
        }

        /* renamed from: b */
        public void a(ActivityResult activityResult) {
            LaunchedFragmentInfo pollFirst = FragmentManager.this.B.pollFirst();
            if (pollFirst == null) {
                Log.w("FragmentManager", "No Activities were started for result for " + this);
                return;
            }
            String str = pollFirst.f3003a;
            int i10 = pollFirst.f3004b;
            Fragment i11 = FragmentManager.this.f2975c.i(str);
            if (i11 == null) {
                Log.w("FragmentManager", "Activity result delivered for unknown Fragment " + str);
                return;
            }
            i11.onActivityResult(i10, activityResult.b(), activityResult.a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class g implements androidx.activity.result.a<ActivityResult> {
        g() {
        }

        /* renamed from: b */
        public void a(ActivityResult activityResult) {
            LaunchedFragmentInfo pollFirst = FragmentManager.this.B.pollFirst();
            if (pollFirst == null) {
                Log.w("FragmentManager", "No IntentSenders were started for " + this);
                return;
            }
            String str = pollFirst.f3003a;
            int i10 = pollFirst.f3004b;
            Fragment i11 = FragmentManager.this.f2975c.i(str);
            if (i11 == null) {
                Log.w("FragmentManager", "Intent Sender result delivered for unknown Fragment " + str);
                return;
            }
            i11.onActivityResult(i10, activityResult.b(), activityResult.a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class h implements androidx.activity.result.a<Map<String, Boolean>> {
        h() {
        }

        @SuppressLint({"SyntheticAccessor"})
        /* renamed from: b */
        public void a(Map<String, Boolean> map) {
            String[] strArr = (String[]) map.keySet().toArray(new String[0]);
            ArrayList arrayList = new ArrayList(map.values());
            int[] iArr = new int[arrayList.size()];
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                iArr[i10] = ((Boolean) arrayList.get(i10)).booleanValue() ? 0 : -1;
            }
            LaunchedFragmentInfo pollFirst = FragmentManager.this.B.pollFirst();
            if (pollFirst == null) {
                Log.w("FragmentManager", "No permissions were requested for " + this);
                return;
            }
            String str = pollFirst.f3003a;
            int i11 = pollFirst.f3004b;
            Fragment i12 = FragmentManager.this.f2975c.i(str);
            if (i12 == null) {
                Log.w("FragmentManager", "Permission request result delivered for unknown Fragment " + str);
                return;
            }
            i12.onRequestPermissionsResult(i11, strArr, iArr);
        }
    }

    /* loaded from: classes.dex */
    public interface i {
        String getName();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class j extends c.a<IntentSenderRequest, ActivityResult> {
        j() {
        }

        /* renamed from: d */
        public Intent a(Context context, IntentSenderRequest intentSenderRequest) {
            Bundle bundleExtra;
            Intent intent = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST");
            Intent a10 = intentSenderRequest.a();
            if (!(a10 == null || (bundleExtra = a10.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) == null)) {
                intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundleExtra);
                a10.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                if (a10.getBooleanExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", false)) {
                    intentSenderRequest = new IntentSenderRequest.b(intentSenderRequest.d()).b(null).c(intentSenderRequest.c(), intentSenderRequest.b()).a();
                }
            }
            intent.putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", intentSenderRequest);
            if (FragmentManager.H0(2)) {
                Log.v("FragmentManager", "CreateIntent created the following intent: " + intent);
            }
            return intent;
        }

        /* renamed from: e */
        public ActivityResult c(int i10, Intent intent) {
            return new ActivityResult(i10, intent);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class k {
    }

    /* loaded from: classes.dex */
    public interface l {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface m {
        boolean a(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2);
    }

    /* loaded from: classes.dex */
    private class n implements m {

        /* renamed from: a  reason: collision with root package name */
        final String f3012a;

        /* renamed from: b  reason: collision with root package name */
        final int f3013b;

        /* renamed from: c  reason: collision with root package name */
        final int f3014c;

        n(String str, int i10, int i11) {
            this.f3012a = str;
            this.f3013b = i10;
            this.f3014c = i11;
        }

        @Override // androidx.fragment.app.FragmentManager.m
        public boolean a(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2) {
            Fragment fragment = FragmentManager.this.f2992t;
            if (fragment == null || this.f3013b >= 0 || this.f3012a != null || !fragment.getChildFragmentManager().Z0()) {
                return FragmentManager.this.c1(arrayList, arrayList2, this.f3012a, this.f3013b, this.f3014c);
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Fragment B0(View view) {
        Object tag = view.getTag(v0.b.f35560a);
        if (tag instanceof Fragment) {
            return (Fragment) tag;
        }
        return null;
    }

    public static boolean H0(int i10) {
        return N || Log.isLoggable("FragmentManager", i10);
    }

    private boolean I0(Fragment fragment) {
        return (fragment.mHasMenu && fragment.mMenuVisible) || fragment.mChildFragmentManager.m();
    }

    private void J(Fragment fragment) {
        if (fragment != null && fragment.equals(d0(fragment.mWho))) {
            fragment.performPrimaryNavigationFragmentChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Bundle O0() {
        Bundle bundle = new Bundle();
        Parcelable k12 = k1();
        if (k12 != null) {
            bundle.putParcelable("android:support:fragments", k12);
        }
        return bundle;
    }

    /* JADX WARN: Finally extract failed */
    private void Q(int i10) {
        try {
            this.f2974b = true;
            this.f2975c.d(i10);
            S0(i10, false);
            for (d0 d0Var : r()) {
                d0Var.j();
            }
            this.f2974b = false;
            Y(true);
        } catch (Throwable th2) {
            this.f2974b = false;
            throw th2;
        }
    }

    private void T() {
        if (this.G) {
            this.G = false;
            s1();
        }
    }

    private void V() {
        for (d0 d0Var : r()) {
            d0Var.j();
        }
    }

    private void X(boolean z10) {
        if (this.f2974b) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        } else if (this.f2989q == null) {
            if (this.F) {
                throw new IllegalStateException("FragmentManager has been destroyed");
            }
            throw new IllegalStateException("FragmentManager has not been attached to a host.");
        } else if (Looper.myLooper() == this.f2989q.g().getLooper()) {
            if (!z10) {
                n();
            }
            if (this.H == null) {
                this.H = new ArrayList<>();
                this.I = new ArrayList<>();
            }
        } else {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
    }

    private static void a0(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2, int i10, int i11) {
        while (i10 < i11) {
            androidx.fragment.app.a aVar = arrayList.get(i10);
            if (arrayList2.get(i10).booleanValue()) {
                aVar.A(-1);
                aVar.F();
            } else {
                aVar.A(1);
                aVar.E();
            }
            i10++;
        }
    }

    private void b0(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2, int i10, int i11) {
        boolean z10 = arrayList.get(i10).f3208p;
        ArrayList<Fragment> arrayList3 = this.J;
        if (arrayList3 == null) {
            this.J = new ArrayList<>();
        } else {
            arrayList3.clear();
        }
        this.J.addAll(this.f2975c.o());
        Fragment y02 = y0();
        boolean z11 = false;
        for (int i12 = i10; i12 < i11; i12++) {
            androidx.fragment.app.a aVar = arrayList.get(i12);
            if (!arrayList2.get(i12).booleanValue()) {
                y02 = aVar.G(this.J, y02);
            } else {
                y02 = aVar.I(this.J, y02);
            }
            z11 = z11 || aVar.f3199g;
        }
        this.J.clear();
        if (!z10 && this.f2988p >= 1) {
            for (int i13 = i10; i13 < i11; i13++) {
                Iterator<w.a> it = arrayList.get(i13).f3193a.iterator();
                while (it.hasNext()) {
                    Fragment fragment = it.next().f3211b;
                    if (!(fragment == null || fragment.mFragmentManager == null)) {
                        this.f2975c.r(t(fragment));
                    }
                }
            }
        }
        a0(arrayList, arrayList2, i10, i11);
        boolean booleanValue = arrayList2.get(i11 - 1).booleanValue();
        for (int i14 = i10; i14 < i11; i14++) {
            androidx.fragment.app.a aVar2 = arrayList.get(i14);
            if (booleanValue) {
                for (int size = aVar2.f3193a.size() - 1; size >= 0; size--) {
                    Fragment fragment2 = aVar2.f3193a.get(size).f3211b;
                    if (fragment2 != null) {
                        t(fragment2).m();
                    }
                }
            } else {
                Iterator<w.a> it2 = aVar2.f3193a.iterator();
                while (it2.hasNext()) {
                    Fragment fragment3 = it2.next().f3211b;
                    if (fragment3 != null) {
                        t(fragment3).m();
                    }
                }
            }
        }
        S0(this.f2988p, true);
        for (d0 d0Var : s(arrayList, i10, i11)) {
            d0Var.r(booleanValue);
            d0Var.p();
            d0Var.g();
        }
        while (i10 < i11) {
            androidx.fragment.app.a aVar3 = arrayList.get(i10);
            if (arrayList2.get(i10).booleanValue() && aVar3.f3043t >= 0) {
                aVar3.f3043t = -1;
            }
            aVar3.H();
            i10++;
        }
        if (z11) {
            h1();
        }
    }

    private boolean b1(String str, int i10, int i11) {
        Y(false);
        X(true);
        Fragment fragment = this.f2992t;
        if (fragment != null && i10 < 0 && str == null && fragment.getChildFragmentManager().Z0()) {
            return true;
        }
        boolean c12 = c1(this.H, this.I, str, i10, i11);
        if (c12) {
            this.f2974b = true;
            try {
                f1(this.H, this.I);
            } finally {
                o();
            }
        }
        u1();
        T();
        this.f2975c.b();
        return c12;
    }

    private int e0(String str, int i10, boolean z10) {
        ArrayList<androidx.fragment.app.a> arrayList = this.f2976d;
        if (arrayList == null || arrayList.isEmpty()) {
            return -1;
        }
        if (str != null || i10 >= 0) {
            int size = this.f2976d.size() - 1;
            while (size >= 0) {
                androidx.fragment.app.a aVar = this.f2976d.get(size);
                if ((str != null && str.equals(aVar.getName())) || (i10 >= 0 && i10 == aVar.f3043t)) {
                    break;
                }
                size--;
            }
            if (size < 0) {
                return size;
            }
            if (z10) {
                while (size > 0) {
                    androidx.fragment.app.a aVar2 = this.f2976d.get(size - 1);
                    if ((str == null || !str.equals(aVar2.getName())) && (i10 < 0 || i10 != aVar2.f3043t)) {
                        return size;
                    }
                    size--;
                }
                return size;
            } else if (size == this.f2976d.size() - 1) {
                return -1;
            } else {
                return size + 1;
            }
        } else if (z10) {
            return 0;
        } else {
            return this.f2976d.size() - 1;
        }
    }

    private void f1(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2) {
        if (!arrayList.isEmpty()) {
            if (arrayList.size() == arrayList2.size()) {
                int size = arrayList.size();
                int i10 = 0;
                int i11 = 0;
                while (i10 < size) {
                    if (!arrayList.get(i10).f3208p) {
                        if (i11 != i10) {
                            b0(arrayList, arrayList2, i11, i10);
                        }
                        i11 = i10 + 1;
                        if (arrayList2.get(i10).booleanValue()) {
                            while (i11 < size && arrayList2.get(i11).booleanValue() && !arrayList.get(i11).f3208p) {
                                i11++;
                            }
                        }
                        b0(arrayList, arrayList2, i10, i11);
                        i10 = i11 - 1;
                    }
                    i10++;
                }
                if (i11 != size) {
                    b0(arrayList, arrayList2, i11, size);
                    return;
                }
                return;
            }
            throw new IllegalStateException("Internal error with the back stack records");
        }
    }

    private void h1() {
        if (this.f2985m != null) {
            for (int i10 = 0; i10 < this.f2985m.size(); i10++) {
                this.f2985m.get(i10).a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static FragmentManager i0(View view) {
        Fragment j02 = j0(view);
        if (j02 == null) {
            Context context = view.getContext();
            androidx.fragment.app.f fVar = null;
            while (true) {
                if (!(context instanceof ContextWrapper)) {
                    break;
                } else if (context instanceof androidx.fragment.app.f) {
                    fVar = (androidx.fragment.app.f) context;
                    break;
                } else {
                    context = ((ContextWrapper) context).getBaseContext();
                }
            }
            if (fVar != null) {
                return fVar.getSupportFragmentManager();
            }
            throw new IllegalStateException("View " + view + " is not within a subclass of FragmentActivity.");
        } else if (j02.isAdded()) {
            return j02.getChildFragmentManager();
        } else {
            throw new IllegalStateException("The Fragment " + j02 + " that owns View " + view + " has already been destroyed. Nested fragments should always use the child FragmentManager.");
        }
    }

    private static Fragment j0(View view) {
        while (view != null) {
            Fragment B0 = B0(view);
            if (B0 != null) {
                return B0;
            }
            ViewParent parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int j1(int i10) {
        if (i10 == 4097) {
            return 8194;
        }
        if (i10 == 8194) {
            return 4097;
        }
        if (i10 == 8197) {
            return 4100;
        }
        if (i10 != 4099) {
            return i10 != 4100 ? 0 : 8197;
        }
        return 4099;
    }

    private void k0() {
        for (d0 d0Var : r()) {
            d0Var.k();
        }
    }

    private boolean l0(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2) {
        synchronized (this.f2973a) {
            if (this.f2973a.isEmpty()) {
                return false;
            }
            int size = this.f2973a.size();
            boolean z10 = false;
            for (int i10 = 0; i10 < size; i10++) {
                z10 |= this.f2973a.get(i10).a(arrayList, arrayList2);
            }
            this.f2973a.clear();
            this.f2989q.g().removeCallbacks(this.M);
            return z10;
        }
    }

    private void n() {
        if (N0()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    private void o() {
        this.f2974b = false;
        this.I.clear();
        this.H.clear();
    }

    private p o0(Fragment fragment) {
        return this.K.f(fragment);
    }

    private void p() {
        androidx.fragment.app.k<?> kVar = this.f2989q;
        boolean z10 = true;
        if (kVar instanceof j0) {
            z10 = this.f2975c.p().j();
        } else if (kVar.f() instanceof Activity) {
            z10 = true ^ ((Activity) this.f2989q.f()).isChangingConfigurations();
        }
        if (z10) {
            for (BackStackState backStackState : this.f2982j.values()) {
                for (String str : backStackState.f2930a) {
                    this.f2975c.p().c(str);
                }
            }
        }
    }

    private void q1(Fragment fragment) {
        ViewGroup r02 = r0(fragment);
        if (r02 != null && fragment.getEnterAnim() + fragment.getExitAnim() + fragment.getPopEnterAnim() + fragment.getPopExitAnim() > 0) {
            int i10 = v0.b.f35562c;
            if (r02.getTag(i10) == null) {
                r02.setTag(i10, fragment);
            }
            ((Fragment) r02.getTag(i10)).setPopDirection(fragment.getPopDirection());
        }
    }

    private Set<d0> r() {
        HashSet hashSet = new HashSet();
        for (t tVar : this.f2975c.k()) {
            ViewGroup viewGroup = tVar.k().mContainer;
            if (viewGroup != null) {
                hashSet.add(d0.o(viewGroup, z0()));
            }
        }
        return hashSet;
    }

    private ViewGroup r0(Fragment fragment) {
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null) {
            return viewGroup;
        }
        if (fragment.mContainerId > 0 && this.f2990r.d()) {
            View c10 = this.f2990r.c(fragment.mContainerId);
            if (c10 instanceof ViewGroup) {
                return (ViewGroup) c10;
            }
        }
        return null;
    }

    private Set<d0> s(ArrayList<androidx.fragment.app.a> arrayList, int i10, int i11) {
        ViewGroup viewGroup;
        HashSet hashSet = new HashSet();
        while (i10 < i11) {
            Iterator<w.a> it = arrayList.get(i10).f3193a.iterator();
            while (it.hasNext()) {
                Fragment fragment = it.next().f3211b;
                if (!(fragment == null || (viewGroup = fragment.mContainer) == null)) {
                    hashSet.add(d0.n(viewGroup, this));
                }
            }
            i10++;
        }
        return hashSet;
    }

    private void s1() {
        for (t tVar : this.f2975c.k()) {
            V0(tVar);
        }
    }

    private void t1(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new c0("FragmentManager"));
        androidx.fragment.app.k<?> kVar = this.f2989q;
        if (kVar != null) {
            try {
                kVar.h("  ", null, printWriter, new String[0]);
            } catch (Exception e10) {
                Log.e("FragmentManager", "Failed dumping state", e10);
            }
        } else {
            try {
                U("  ", null, printWriter, new String[0]);
            } catch (Exception e11) {
                Log.e("FragmentManager", "Failed dumping state", e11);
            }
        }
        throw runtimeException;
    }

    private void u1() {
        synchronized (this.f2973a) {
            boolean z10 = true;
            if (!this.f2973a.isEmpty()) {
                this.f2980h.f(true);
                return;
            }
            androidx.activity.e eVar = this.f2980h;
            if (n0() <= 0 || !L0(this.f2991s)) {
                z10 = false;
            }
            eVar.f(z10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean A(Menu menu, MenuInflater menuInflater) {
        if (this.f2988p < 1) {
            return false;
        }
        ArrayList<Fragment> arrayList = null;
        boolean z10 = false;
        for (Fragment fragment : this.f2975c.o()) {
            if (fragment != null && K0(fragment) && fragment.performCreateOptionsMenu(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(fragment);
                z10 = true;
            }
        }
        if (this.f2977e != null) {
            for (int i10 = 0; i10 < this.f2977e.size(); i10++) {
                Fragment fragment2 = this.f2977e.get(i10);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.onDestroyOptionsMenu();
                }
            }
        }
        this.f2977e = arrayList;
        return z10;
    }

    public FragmentStrictMode.b A0() {
        return this.L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void B() {
        this.F = true;
        Y(true);
        V();
        p();
        Q(-1);
        this.f2989q = null;
        this.f2990r = null;
        this.f2991s = null;
        if (this.f2979g != null) {
            this.f2980h.d();
            this.f2979g = null;
        }
        androidx.activity.result.b<Intent> bVar = this.f2997y;
        if (bVar != null) {
            bVar.c();
            this.f2998z.c();
            this.A.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void C() {
        Q(1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i0 C0(Fragment fragment) {
        return this.K.i(fragment);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void D() {
        for (Fragment fragment : this.f2975c.o()) {
            if (fragment != null) {
                fragment.performLowMemory();
            }
        }
    }

    void D0() {
        Y(true);
        if (this.f2980h.c()) {
            Z0();
        } else {
            this.f2979g.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void E(boolean z10) {
        for (Fragment fragment : this.f2975c.o()) {
            if (fragment != null) {
                fragment.performMultiWindowModeChanged(z10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void E0(Fragment fragment) {
        if (H0(2)) {
            Log.v("FragmentManager", "hide: " + fragment);
        }
        if (!fragment.mHidden) {
            fragment.mHidden = true;
            fragment.mHiddenChanged = true ^ fragment.mHiddenChanged;
            q1(fragment);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void F(Fragment fragment) {
        Iterator<q> it = this.f2987o.iterator();
        while (it.hasNext()) {
            it.next().a(this, fragment);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void F0(Fragment fragment) {
        if (fragment.mAdded && I0(fragment)) {
            this.C = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void G() {
        for (Fragment fragment : this.f2975c.l()) {
            if (fragment != null) {
                fragment.onHiddenChanged(fragment.isHidden());
                fragment.mChildFragmentManager.G();
            }
        }
    }

    public boolean G0() {
        return this.F;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean H(MenuItem menuItem) {
        if (this.f2988p < 1) {
            return false;
        }
        for (Fragment fragment : this.f2975c.o()) {
            if (fragment != null && fragment.performOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void I(Menu menu) {
        if (this.f2988p >= 1) {
            for (Fragment fragment : this.f2975c.o()) {
                if (fragment != null) {
                    fragment.performOptionsMenuClosed(menu);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean J0(Fragment fragment) {
        if (fragment == null) {
            return false;
        }
        return fragment.isHidden();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void K() {
        Q(5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean K0(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        return fragment.isMenuVisible();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void L(boolean z10) {
        for (Fragment fragment : this.f2975c.o()) {
            if (fragment != null) {
                fragment.performPictureInPictureModeChanged(z10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean L0(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        FragmentManager fragmentManager = fragment.mFragmentManager;
        return fragment.equals(fragmentManager.y0()) && L0(fragmentManager.f2991s);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean M(Menu menu) {
        boolean z10 = false;
        if (this.f2988p < 1) {
            return false;
        }
        for (Fragment fragment : this.f2975c.o()) {
            if (fragment != null && K0(fragment) && fragment.performPrepareOptionsMenu(menu)) {
                z10 = true;
            }
        }
        return z10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean M0(int i10) {
        return this.f2988p >= i10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void N() {
        u1();
        J(this.f2992t);
    }

    public boolean N0() {
        return this.D || this.E;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void O() {
        this.D = false;
        this.E = false;
        this.K.l(false);
        Q(7);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void P() {
        this.D = false;
        this.E = false;
        this.K.l(false);
        Q(5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void P0(Fragment fragment, String[] strArr, int i10) {
        if (this.A != null) {
            this.B.addLast(new LaunchedFragmentInfo(fragment.mWho, i10));
            this.A.a(strArr);
            return;
        }
        this.f2989q.k(fragment, strArr, i10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Q0(Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i10, Bundle bundle) {
        if (this.f2997y != null) {
            this.B.addLast(new LaunchedFragmentInfo(fragment.mWho, i10));
            if (!(intent == null || bundle == null)) {
                intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
            }
            this.f2997y.a(intent);
            return;
        }
        this.f2989q.m(fragment, intent, i10, bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void R() {
        this.E = true;
        this.K.l(true);
        Q(4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void R0(Fragment fragment, @SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i10, Intent intent, int i11, int i12, int i13, Bundle bundle) throws IntentSender.SendIntentException {
        Intent intent2;
        if (this.f2998z != null) {
            if (bundle != null) {
                if (intent == null) {
                    intent2 = new Intent();
                    intent2.putExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", true);
                } else {
                    intent2 = intent;
                }
                if (H0(2)) {
                    Log.v("FragmentManager", "ActivityOptions " + bundle + " were added to fillInIntent " + intent2 + " for fragment " + fragment);
                }
                intent2.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
            } else {
                intent2 = intent;
            }
            IntentSenderRequest a10 = new IntentSenderRequest.b(intentSender).b(intent2).c(i12, i11).a();
            this.B.addLast(new LaunchedFragmentInfo(fragment.mWho, i10));
            if (H0(2)) {
                Log.v("FragmentManager", "Fragment " + fragment + "is launching an IntentSender for result ");
            }
            this.f2998z.a(a10);
            return;
        }
        this.f2989q.n(fragment, intentSender, i10, intent, i11, i12, i13, bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void S() {
        Q(2);
    }

    void S0(int i10, boolean z10) {
        androidx.fragment.app.k<?> kVar;
        if (this.f2989q == null && i10 != -1) {
            throw new IllegalStateException("No activity");
        } else if (z10 || i10 != this.f2988p) {
            this.f2988p = i10;
            this.f2975c.t();
            s1();
            if (this.C && (kVar = this.f2989q) != null && this.f2988p == 7) {
                kVar.o();
                this.C = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void T0() {
        if (this.f2989q != null) {
            this.D = false;
            this.E = false;
            this.K.l(false);
            for (Fragment fragment : this.f2975c.o()) {
                if (fragment != null) {
                    fragment.noteStateNotSaved();
                }
            }
        }
    }

    public void U(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        String str2 = str + "    ";
        this.f2975c.e(str, fileDescriptor, printWriter, strArr);
        ArrayList<Fragment> arrayList = this.f2977e;
        if (arrayList != null && (size2 = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i10 = 0; i10 < size2; i10++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i10);
                printWriter.print(": ");
                printWriter.println(this.f2977e.get(i10).toString());
            }
        }
        ArrayList<androidx.fragment.app.a> arrayList2 = this.f2976d;
        if (arrayList2 != null && (size = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i11 = 0; i11 < size; i11++) {
                androidx.fragment.app.a aVar = this.f2976d.get(i11);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i11);
                printWriter.print(": ");
                printWriter.println(aVar.toString());
                aVar.C(str2, printWriter);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.f2981i.get());
        synchronized (this.f2973a) {
            int size3 = this.f2973a.size();
            if (size3 > 0) {
                printWriter.print(str);
                printWriter.println("Pending Actions:");
                for (int i12 = 0; i12 < size3; i12++) {
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i12);
                    printWriter.print(": ");
                    printWriter.println(this.f2973a.get(i12));
                }
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.f2989q);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.f2990r);
        if (this.f2991s != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.f2991s);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.f2988p);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.D);
        printWriter.print(" mStopped=");
        printWriter.print(this.E);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.F);
        if (this.C) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.C);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void U0(FragmentContainerView fragmentContainerView) {
        View view;
        for (t tVar : this.f2975c.k()) {
            Fragment k10 = tVar.k();
            if (k10.mContainerId == fragmentContainerView.getId() && (view = k10.mView) != null && view.getParent() == null) {
                k10.mContainer = fragmentContainerView;
                tVar.b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void V0(t tVar) {
        Fragment k10 = tVar.k();
        if (!k10.mDeferStart) {
            return;
        }
        if (this.f2974b) {
            this.G = true;
            return;
        }
        k10.mDeferStart = false;
        tVar.m();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void W(m mVar, boolean z10) {
        if (!z10) {
            if (this.f2989q != null) {
                n();
            } else if (this.F) {
                throw new IllegalStateException("FragmentManager has been destroyed");
            } else {
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
        }
        synchronized (this.f2973a) {
            if (this.f2989q != null) {
                this.f2973a.add(mVar);
                m1();
            } else if (!z10) {
                throw new IllegalStateException("Activity has been destroyed");
            }
        }
    }

    public void W0() {
        W(new n(null, -1, 0), false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void X0(int i10, int i11, boolean z10) {
        if (i10 >= 0) {
            W(new n(null, i10, i11), z10);
            return;
        }
        throw new IllegalArgumentException("Bad id: " + i10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Finally extract failed */
    public boolean Y(boolean z10) {
        X(z10);
        boolean z11 = false;
        while (l0(this.H, this.I)) {
            this.f2974b = true;
            try {
                f1(this.H, this.I);
                o();
                z11 = true;
            } catch (Throwable th2) {
                o();
                throw th2;
            }
        }
        u1();
        T();
        this.f2975c.b();
        return z11;
    }

    public void Y0(String str, int i10) {
        W(new n(str, -1, i10), false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Z(m mVar, boolean z10) {
        if (!z10 || (this.f2989q != null && !this.F)) {
            X(z10);
            if (mVar.a(this.H, this.I)) {
                this.f2974b = true;
                try {
                    f1(this.H, this.I);
                } finally {
                    o();
                }
            }
            u1();
            T();
            this.f2975c.b();
        }
    }

    public boolean Z0() {
        return b1(null, -1, 0);
    }

    public boolean a1(String str, int i10) {
        return b1(str, -1, i10);
    }

    public boolean c0() {
        boolean Y = Y(true);
        k0();
        return Y;
    }

    boolean c1(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2, String str, int i10, int i11) {
        int e02 = e0(str, i10, (i11 & 1) != 0);
        if (e02 < 0) {
            return false;
        }
        for (int size = this.f2976d.size() - 1; size >= e02; size--) {
            arrayList.add(this.f2976d.remove(size));
            arrayList2.add(Boolean.TRUE);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment d0(String str) {
        return this.f2975c.f(str);
    }

    public void d1(Bundle bundle, String str, Fragment fragment) {
        if (fragment.mFragmentManager != this) {
            t1(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        bundle.putString(str, fragment.mWho);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(androidx.fragment.app.a aVar) {
        if (this.f2976d == null) {
            this.f2976d = new ArrayList<>();
        }
        this.f2976d.add(aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e1(Fragment fragment) {
        if (H0(2)) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.mBackStackNesting);
        }
        boolean z10 = !fragment.isInBackStack();
        if (!fragment.mDetached || z10) {
            this.f2975c.u(fragment);
            if (I0(fragment)) {
                this.C = true;
            }
            fragment.mRemoving = true;
            q1(fragment);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public t f(Fragment fragment) {
        String str = fragment.mPreviousWho;
        if (str != null) {
            FragmentStrictMode.h(fragment, str);
        }
        if (H0(2)) {
            Log.v("FragmentManager", "add: " + fragment);
        }
        t t10 = t(fragment);
        fragment.mFragmentManager = this;
        this.f2975c.r(t10);
        if (!fragment.mDetached) {
            this.f2975c.a(fragment);
            fragment.mRemoving = false;
            if (fragment.mView == null) {
                fragment.mHiddenChanged = false;
            }
            if (I0(fragment)) {
                this.C = true;
            }
        }
        return t10;
    }

    public Fragment f0(int i10) {
        return this.f2975c.g(i10);
    }

    public void g(q qVar) {
        this.f2987o.add(qVar);
    }

    public Fragment g0(String str) {
        return this.f2975c.h(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g1(Fragment fragment) {
        this.K.k(fragment);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(Fragment fragment) {
        this.K.a(fragment);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment h0(String str) {
        return this.f2975c.i(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int i() {
        return this.f2981i.getAndIncrement();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i1(Parcelable parcelable) {
        FragmentManagerState fragmentManagerState;
        ArrayList<FragmentState> arrayList;
        t tVar;
        if (!(parcelable == null || (arrayList = (fragmentManagerState = (FragmentManagerState) parcelable).f3016a) == null)) {
            this.f2975c.x(arrayList);
            this.f2975c.v();
            Iterator<String> it = fragmentManagerState.f3017b.iterator();
            while (it.hasNext()) {
                FragmentState B = this.f2975c.B(it.next(), null);
                if (B != null) {
                    Fragment e10 = this.K.e(B.f3028b);
                    if (e10 != null) {
                        if (H0(2)) {
                            Log.v("FragmentManager", "restoreSaveState: re-attaching retained " + e10);
                        }
                        tVar = new t(this.f2986n, this.f2975c, e10, B);
                    } else {
                        tVar = new t(this.f2986n, this.f2975c, this.f2989q.f().getClassLoader(), s0(), B);
                    }
                    Fragment k10 = tVar.k();
                    k10.mFragmentManager = this;
                    if (H0(2)) {
                        Log.v("FragmentManager", "restoreSaveState: active (" + k10.mWho + "): " + k10);
                    }
                    tVar.o(this.f2989q.f().getClassLoader());
                    this.f2975c.r(tVar);
                    tVar.u(this.f2988p);
                }
            }
            for (Fragment fragment : this.K.h()) {
                if (!this.f2975c.c(fragment.mWho)) {
                    if (H0(2)) {
                        Log.v("FragmentManager", "Discarding retained Fragment " + fragment + " that was not found in the set of active Fragments " + fragmentManagerState.f3017b);
                    }
                    this.K.k(fragment);
                    fragment.mFragmentManager = this;
                    t tVar2 = new t(this.f2986n, this.f2975c, fragment);
                    tVar2.u(1);
                    tVar2.m();
                    fragment.mRemoving = true;
                    tVar2.m();
                }
            }
            this.f2975c.w(fragmentManagerState.f3018c);
            if (fragmentManagerState.f3019d != null) {
                this.f2976d = new ArrayList<>(fragmentManagerState.f3019d.length);
                int i10 = 0;
                while (true) {
                    BackStackRecordState[] backStackRecordStateArr = fragmentManagerState.f3019d;
                    if (i10 >= backStackRecordStateArr.length) {
                        break;
                    }
                    androidx.fragment.app.a b10 = backStackRecordStateArr[i10].b(this);
                    if (H0(2)) {
                        Log.v("FragmentManager", "restoreAllState: back stack #" + i10 + " (index " + b10.f3043t + "): " + b10);
                        PrintWriter printWriter = new PrintWriter(new c0("FragmentManager"));
                        b10.D("  ", printWriter, false);
                        printWriter.close();
                    }
                    this.f2976d.add(b10);
                    i10++;
                }
            } else {
                this.f2976d = null;
            }
            this.f2981i.set(fragmentManagerState.f3020e);
            String str = fragmentManagerState.f3021f;
            if (str != null) {
                Fragment d02 = d0(str);
                this.f2992t = d02;
                J(d02);
            }
            ArrayList<String> arrayList2 = fragmentManagerState.f3022g;
            if (arrayList2 != null) {
                for (int i11 = 0; i11 < arrayList2.size(); i11++) {
                    this.f2982j.put(arrayList2.get(i11), fragmentManagerState.f3023h.get(i11));
                }
            }
            ArrayList<String> arrayList3 = fragmentManagerState.f3024i;
            if (arrayList3 != null) {
                for (int i12 = 0; i12 < arrayList3.size(); i12++) {
                    Bundle bundle = fragmentManagerState.f3025j.get(i12);
                    bundle.setClassLoader(this.f2989q.f().getClassLoader());
                    this.f2983k.put(arrayList3.get(i12), bundle);
                }
            }
            this.B = new ArrayDeque<>(fragmentManagerState.f3026k);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({"SyntheticAccessor"})
    public void j(androidx.fragment.app.k<?> kVar, androidx.fragment.app.h hVar, Fragment fragment) {
        String str;
        if (this.f2989q == null) {
            this.f2989q = kVar;
            this.f2990r = hVar;
            this.f2991s = fragment;
            if (fragment != null) {
                g(new e(this, fragment));
            } else if (kVar instanceof q) {
                g((q) kVar);
            }
            if (this.f2991s != null) {
                u1();
            }
            if (kVar instanceof androidx.activity.f) {
                androidx.activity.f fVar = (androidx.activity.f) kVar;
                OnBackPressedDispatcher onBackPressedDispatcher = fVar.getOnBackPressedDispatcher();
                this.f2979g = onBackPressedDispatcher;
                p pVar = fVar;
                if (fragment != null) {
                    pVar = fragment;
                }
                onBackPressedDispatcher.a(pVar, this.f2980h);
            }
            if (fragment != null) {
                this.K = fragment.mFragmentManager.o0(fragment);
            } else if (kVar instanceof j0) {
                this.K = p.g(((j0) kVar).getViewModelStore());
            } else {
                this.K = new p(false);
            }
            this.K.l(N0());
            this.f2975c.A(this.K);
            androidx.fragment.app.k<?> kVar2 = this.f2989q;
            if ((kVar2 instanceof androidx.savedstate.c) && fragment == null) {
                SavedStateRegistry savedStateRegistry = ((androidx.savedstate.c) kVar2).getSavedStateRegistry();
                savedStateRegistry.d("android:support:fragments", new SavedStateRegistry.b() { // from class: androidx.fragment.app.n
                    @Override // androidx.savedstate.SavedStateRegistry.b
                    public final Bundle a() {
                        Bundle O0;
                        O0 = FragmentManager.this.O0();
                        return O0;
                    }
                });
                Bundle a10 = savedStateRegistry.a("android:support:fragments");
                if (a10 != null) {
                    i1(a10.getParcelable("android:support:fragments"));
                }
            }
            androidx.fragment.app.k<?> kVar3 = this.f2989q;
            if (kVar3 instanceof androidx.activity.result.c) {
                ActivityResultRegistry activityResultRegistry = ((androidx.activity.result.c) kVar3).getActivityResultRegistry();
                if (fragment != null) {
                    str = fragment.mWho + ":";
                } else {
                    str = "";
                }
                String str2 = "FragmentManager:" + str;
                this.f2997y = activityResultRegistry.j(str2 + "StartActivityForResult", new c.c(), new f());
                this.f2998z = activityResultRegistry.j(str2 + "StartIntentSenderForResult", new j(), new g());
                this.A = activityResultRegistry.j(str2 + "RequestPermissions", new c.b(), new h());
                return;
            }
            return;
        }
        throw new IllegalStateException("Already attached");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(Fragment fragment) {
        if (H0(2)) {
            Log.v("FragmentManager", "attach: " + fragment);
        }
        if (fragment.mDetached) {
            fragment.mDetached = false;
            if (!fragment.mAdded) {
                this.f2975c.a(fragment);
                if (H0(2)) {
                    Log.v("FragmentManager", "add from attach: " + fragment);
                }
                if (I0(fragment)) {
                    this.C = true;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Parcelable k1() {
        int size;
        k0();
        V();
        Y(true);
        this.D = true;
        this.K.l(true);
        ArrayList<String> y10 = this.f2975c.y();
        ArrayList<FragmentState> m10 = this.f2975c.m();
        BackStackRecordState[] backStackRecordStateArr = null;
        if (m10.isEmpty()) {
            if (H0(2)) {
                Log.v("FragmentManager", "saveAllState: no fragments!");
            }
            return null;
        }
        ArrayList<String> z10 = this.f2975c.z();
        ArrayList<androidx.fragment.app.a> arrayList = this.f2976d;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            backStackRecordStateArr = new BackStackRecordState[size];
            for (int i10 = 0; i10 < size; i10++) {
                backStackRecordStateArr[i10] = new BackStackRecordState(this.f2976d.get(i10));
                if (H0(2)) {
                    Log.v("FragmentManager", "saveAllState: adding back stack #" + i10 + ": " + this.f2976d.get(i10));
                }
            }
        }
        FragmentManagerState fragmentManagerState = new FragmentManagerState();
        fragmentManagerState.f3016a = m10;
        fragmentManagerState.f3017b = y10;
        fragmentManagerState.f3018c = z10;
        fragmentManagerState.f3019d = backStackRecordStateArr;
        fragmentManagerState.f3020e = this.f2981i.get();
        Fragment fragment = this.f2992t;
        if (fragment != null) {
            fragmentManagerState.f3021f = fragment.mWho;
        }
        fragmentManagerState.f3022g.addAll(this.f2982j.keySet());
        fragmentManagerState.f3023h.addAll(this.f2982j.values());
        fragmentManagerState.f3024i.addAll(this.f2983k.keySet());
        fragmentManagerState.f3025j.addAll(this.f2983k.values());
        fragmentManagerState.f3026k = new ArrayList<>(this.B);
        return fragmentManagerState;
    }

    public w l() {
        return new androidx.fragment.app.a(this);
    }

    public Fragment.SavedState l1(Fragment fragment) {
        t n10 = this.f2975c.n(fragment.mWho);
        if (n10 == null || !n10.k().equals(fragment)) {
            t1(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        return n10.r();
    }

    boolean m() {
        boolean z10 = false;
        for (Fragment fragment : this.f2975c.l()) {
            if (fragment != null) {
                z10 = I0(fragment);
                continue;
            }
            if (z10) {
                return true;
            }
        }
        return false;
    }

    public i m0(int i10) {
        return this.f2976d.get(i10);
    }

    void m1() {
        synchronized (this.f2973a) {
            boolean z10 = true;
            if (this.f2973a.size() != 1) {
                z10 = false;
            }
            if (z10) {
                this.f2989q.g().removeCallbacks(this.M);
                this.f2989q.g().post(this.M);
                u1();
            }
        }
    }

    public int n0() {
        ArrayList<androidx.fragment.app.a> arrayList = this.f2976d;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n1(Fragment fragment, boolean z10) {
        ViewGroup r02 = r0(fragment);
        if (r02 != null && (r02 instanceof FragmentContainerView)) {
            ((FragmentContainerView) r02).setDrawDisappearingViewsLast(!z10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o1(Fragment fragment, Lifecycle.State state) {
        if (!fragment.equals(d0(fragment.mWho)) || !(fragment.mHost == null || fragment.mFragmentManager == this)) {
            throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
        }
        fragment.mMaxState = state;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public androidx.fragment.app.h p0() {
        return this.f2990r;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p1(Fragment fragment) {
        if (fragment == null || (fragment.equals(d0(fragment.mWho)) && (fragment.mHost == null || fragment.mFragmentManager == this))) {
            Fragment fragment2 = this.f2992t;
            this.f2992t = fragment;
            J(fragment2);
            J(this.f2992t);
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    public final void q(String str) {
        this.f2983k.remove(str);
        if (H0(2)) {
            Log.v("FragmentManager", "Clearing fragment result with key " + str);
        }
    }

    public Fragment q0(Bundle bundle, String str) {
        String string = bundle.getString(str);
        if (string == null) {
            return null;
        }
        Fragment d02 = d0(string);
        if (d02 == null) {
            t1(new IllegalStateException("Fragment no longer exists for key " + str + ": unique id " + string));
        }
        return d02;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r1(Fragment fragment) {
        if (H0(2)) {
            Log.v("FragmentManager", "show: " + fragment);
        }
        if (fragment.mHidden) {
            fragment.mHidden = false;
            fragment.mHiddenChanged = !fragment.mHiddenChanged;
        }
    }

    public androidx.fragment.app.j s0() {
        androidx.fragment.app.j jVar = this.f2993u;
        if (jVar != null) {
            return jVar;
        }
        Fragment fragment = this.f2991s;
        if (fragment != null) {
            return fragment.mFragmentManager.s0();
        }
        return this.f2994v;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public t t(Fragment fragment) {
        t n10 = this.f2975c.n(fragment.mWho);
        if (n10 != null) {
            return n10;
        }
        t tVar = new t(this.f2986n, this.f2975c, fragment);
        tVar.o(this.f2989q.f().getClassLoader());
        tVar.u(this.f2988p);
        return tVar;
    }

    public List<Fragment> t0() {
        return this.f2975c.o();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append("FragmentManager{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append(" in ");
        Fragment fragment = this.f2991s;
        if (fragment != null) {
            sb2.append(fragment.getClass().getSimpleName());
            sb2.append("{");
            sb2.append(Integer.toHexString(System.identityHashCode(this.f2991s)));
            sb2.append("}");
        } else {
            androidx.fragment.app.k<?> kVar = this.f2989q;
            if (kVar != null) {
                sb2.append(kVar.getClass().getSimpleName());
                sb2.append("{");
                sb2.append(Integer.toHexString(System.identityHashCode(this.f2989q)));
                sb2.append("}");
            } else {
                sb2.append(LpaConstants.VALUE_NULL);
            }
        }
        sb2.append("}}");
        return sb2.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u(Fragment fragment) {
        if (H0(2)) {
            Log.v("FragmentManager", "detach: " + fragment);
        }
        if (!fragment.mDetached) {
            fragment.mDetached = true;
            if (fragment.mAdded) {
                if (H0(2)) {
                    Log.v("FragmentManager", "remove from detach: " + fragment);
                }
                this.f2975c.u(fragment);
                if (I0(fragment)) {
                    this.C = true;
                }
                q1(fragment);
            }
        }
    }

    public androidx.fragment.app.k<?> u0() {
        return this.f2989q;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v() {
        this.D = false;
        this.E = false;
        this.K.l(false);
        Q(4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LayoutInflater.Factory2 v0() {
        return this.f2978f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w() {
        this.D = false;
        this.E = false;
        this.K.l(false);
        Q(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public androidx.fragment.app.m w0() {
        return this.f2986n;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x(Configuration configuration) {
        for (Fragment fragment : this.f2975c.o()) {
            if (fragment != null) {
                fragment.performConfigurationChanged(configuration);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment x0() {
        return this.f2991s;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean y(MenuItem menuItem) {
        if (this.f2988p < 1) {
            return false;
        }
        for (Fragment fragment : this.f2975c.o()) {
            if (fragment != null && fragment.performContextItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public Fragment y0() {
        return this.f2992t;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void z() {
        this.D = false;
        this.E = false;
        this.K.l(false);
        Q(1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e0 z0() {
        e0 e0Var = this.f2995w;
        if (e0Var != null) {
            return e0Var;
        }
        Fragment fragment = this.f2991s;
        if (fragment != null) {
            return fragment.mFragmentManager.z0();
        }
        return this.f2996x;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({"BanParcelableUsage"})
    /* loaded from: classes.dex */
    public static class LaunchedFragmentInfo implements Parcelable {
        public static final Parcelable.Creator<LaunchedFragmentInfo> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        String f3003a;

        /* renamed from: b  reason: collision with root package name */
        int f3004b;

        /* loaded from: classes.dex */
        class a implements Parcelable.Creator<LaunchedFragmentInfo> {
            a() {
            }

            /* renamed from: a */
            public LaunchedFragmentInfo createFromParcel(Parcel parcel) {
                return new LaunchedFragmentInfo(parcel);
            }

            /* renamed from: b */
            public LaunchedFragmentInfo[] newArray(int i10) {
                return new LaunchedFragmentInfo[i10];
            }
        }

        LaunchedFragmentInfo(String str, int i10) {
            this.f3003a = str;
            this.f3004b = i10;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeString(this.f3003a);
            parcel.writeInt(this.f3004b);
        }

        LaunchedFragmentInfo(Parcel parcel) {
            this.f3003a = parcel.readString();
            this.f3004b = parcel.readInt();
        }
    }
}
