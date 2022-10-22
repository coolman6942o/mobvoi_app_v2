package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.core.view.g0;
import androidx.core.view.y;
import androidx.fragment.app.d0;
import androidx.fragment.app.g;
import g0.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* compiled from: DefaultSpecialEffectsController.java */
/* loaded from: classes.dex */
class b extends d0 {

    /* compiled from: DefaultSpecialEffectsController.java */
    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3050a;

        static {
            int[] iArr = new int[d0.e.c.values().length];
            f3050a = iArr;
            try {
                iArr[d0.e.c.GONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3050a[d0.e.c.INVISIBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3050a[d0.e.c.REMOVED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3050a[d0.e.c.VISIBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* compiled from: DefaultSpecialEffectsController.java */
    /* renamed from: androidx.fragment.app.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class RunnableC0031b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ List f3051a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ d0.e f3052b;

        RunnableC0031b(List list, d0.e eVar) {
            this.f3051a = list;
            this.f3052b = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f3051a.contains(this.f3052b)) {
                this.f3051a.remove(this.f3052b);
                b.this.s(this.f3052b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DefaultSpecialEffectsController.java */
    /* loaded from: classes.dex */
    public class c extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ViewGroup f3054a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f3055b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f3056c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ d0.e f3057d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ k f3058e;

        c(b bVar, ViewGroup viewGroup, View view, boolean z10, d0.e eVar, k kVar) {
            this.f3054a = viewGroup;
            this.f3055b = view;
            this.f3056c = z10;
            this.f3057d = eVar;
            this.f3058e = kVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f3054a.endViewTransition(this.f3055b);
            if (this.f3056c) {
                this.f3057d.e().a(this.f3055b);
            }
            this.f3058e.a();
            if (FragmentManager.H0(2)) {
                Log.v("FragmentManager", "Animator from operation " + this.f3057d + " has ended.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DefaultSpecialEffectsController.java */
    /* loaded from: classes.dex */
    public class d implements c.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Animator f3059a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ d0.e f3060b;

        d(b bVar, Animator animator, d0.e eVar) {
            this.f3059a = animator;
            this.f3060b = eVar;
        }

        @Override // g0.c.a
        public void onCancel() {
            this.f3059a.end();
            if (FragmentManager.H0(2)) {
                Log.v("FragmentManager", "Animator from operation " + this.f3060b + " has been canceled.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DefaultSpecialEffectsController.java */
    /* loaded from: classes.dex */
    public class e implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d0.e f3061a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ViewGroup f3062b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ View f3063c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ k f3064d;

        /* compiled from: DefaultSpecialEffectsController.java */
        /* loaded from: classes.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                e eVar = e.this;
                eVar.f3062b.endViewTransition(eVar.f3063c);
                e.this.f3064d.a();
            }
        }

        e(b bVar, d0.e eVar, ViewGroup viewGroup, View view, k kVar) {
            this.f3061a = eVar;
            this.f3062b = viewGroup;
            this.f3063c = view;
            this.f3064d = kVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f3062b.post(new a());
            if (FragmentManager.H0(2)) {
                Log.v("FragmentManager", "Animation from operation " + this.f3061a + " has ended.");
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            if (FragmentManager.H0(2)) {
                Log.v("FragmentManager", "Animation from operation " + this.f3061a + " has reached onAnimationStart.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DefaultSpecialEffectsController.java */
    /* loaded from: classes.dex */
    public class f implements c.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f3066a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ViewGroup f3067b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ k f3068c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ d0.e f3069d;

        f(b bVar, View view, ViewGroup viewGroup, k kVar, d0.e eVar) {
            this.f3066a = view;
            this.f3067b = viewGroup;
            this.f3068c = kVar;
            this.f3069d = eVar;
        }

        @Override // g0.c.a
        public void onCancel() {
            this.f3066a.clearAnimation();
            this.f3067b.endViewTransition(this.f3066a);
            this.f3068c.a();
            if (FragmentManager.H0(2)) {
                Log.v("FragmentManager", "Animation from operation " + this.f3069d + " has been cancelled.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DefaultSpecialEffectsController.java */
    /* loaded from: classes.dex */
    public class g implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d0.e f3070a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ d0.e f3071b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f3072c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ androidx.collection.a f3073d;

        g(b bVar, d0.e eVar, d0.e eVar2, boolean z10, androidx.collection.a aVar) {
            this.f3070a = eVar;
            this.f3071b = eVar2;
            this.f3072c = z10;
            this.f3073d = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            x.a(this.f3070a.f(), this.f3071b.f(), this.f3072c, this.f3073d, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DefaultSpecialEffectsController.java */
    /* loaded from: classes.dex */
    public class h implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ z f3074a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f3075b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Rect f3076c;

        h(b bVar, z zVar, View view, Rect rect) {
            this.f3074a = zVar;
            this.f3075b = view;
            this.f3076c = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f3074a.h(this.f3075b, this.f3076c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DefaultSpecialEffectsController.java */
    /* loaded from: classes.dex */
    public class i implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ArrayList f3077a;

        i(b bVar, ArrayList arrayList) {
            this.f3077a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            x.d(this.f3077a, 4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DefaultSpecialEffectsController.java */
    /* loaded from: classes.dex */
    public class j implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ m f3078a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ d0.e f3079b;

        j(b bVar, m mVar, d0.e eVar) {
            this.f3078a = mVar;
            this.f3079b = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f3078a.a();
            if (FragmentManager.H0(2)) {
                Log.v("FragmentManager", "Transition for operation " + this.f3079b + "has completed");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DefaultSpecialEffectsController.java */
    /* loaded from: classes.dex */
    public static class k extends l {

        /* renamed from: c  reason: collision with root package name */
        private boolean f3080c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f3081d = false;

        /* renamed from: e  reason: collision with root package name */
        private g.a f3082e;

        k(d0.e eVar, g0.c cVar, boolean z10) {
            super(eVar, cVar);
            this.f3080c = z10;
        }

        g.a e(Context context) {
            if (this.f3081d) {
                return this.f3082e;
            }
            g.a b10 = androidx.fragment.app.g.b(context, b().f(), b().e() == d0.e.c.VISIBLE, this.f3080c);
            this.f3082e = b10;
            this.f3081d = true;
            return b10;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DefaultSpecialEffectsController.java */
    /* loaded from: classes.dex */
    public static class l {

        /* renamed from: a  reason: collision with root package name */
        private final d0.e f3083a;

        /* renamed from: b  reason: collision with root package name */
        private final g0.c f3084b;

        l(d0.e eVar, g0.c cVar) {
            this.f3083a = eVar;
            this.f3084b = cVar;
        }

        void a() {
            this.f3083a.d(this.f3084b);
        }

        d0.e b() {
            return this.f3083a;
        }

        g0.c c() {
            return this.f3084b;
        }

        boolean d() {
            d0.e.c cVar;
            d0.e.c c10 = d0.e.c.c(this.f3083a.f().mView);
            d0.e.c e10 = this.f3083a.e();
            return c10 == e10 || !(c10 == (cVar = d0.e.c.VISIBLE) || e10 == cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DefaultSpecialEffectsController.java */
    /* loaded from: classes.dex */
    public static class m extends l {

        /* renamed from: c  reason: collision with root package name */
        private final Object f3085c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f3086d;

        /* renamed from: e  reason: collision with root package name */
        private final Object f3087e;

        m(d0.e eVar, g0.c cVar, boolean z10, boolean z11) {
            super(eVar, cVar);
            Object obj;
            Object obj2;
            boolean z12;
            if (eVar.e() == d0.e.c.VISIBLE) {
                if (z10) {
                    obj2 = eVar.f().getReenterTransition();
                } else {
                    obj2 = eVar.f().getEnterTransition();
                }
                this.f3085c = obj2;
                if (z10) {
                    z12 = eVar.f().getAllowReturnTransitionOverlap();
                } else {
                    z12 = eVar.f().getAllowEnterTransitionOverlap();
                }
                this.f3086d = z12;
            } else {
                if (z10) {
                    obj = eVar.f().getReturnTransition();
                } else {
                    obj = eVar.f().getExitTransition();
                }
                this.f3085c = obj;
                this.f3086d = true;
            }
            if (!z11) {
                this.f3087e = null;
            } else if (z10) {
                this.f3087e = eVar.f().getSharedElementReturnTransition();
            } else {
                this.f3087e = eVar.f().getSharedElementEnterTransition();
            }
        }

        private z f(Object obj) {
            if (obj == null) {
                return null;
            }
            z zVar = x.f3219a;
            if (zVar != null && zVar.e(obj)) {
                return zVar;
            }
            z zVar2 = x.f3220b;
            if (zVar2 != null && zVar2.e(obj)) {
                return zVar2;
            }
            throw new IllegalArgumentException("Transition " + obj + " for fragment " + b().f() + " is not a valid framework Transition or AndroidX Transition");
        }

        z e() {
            z f10 = f(this.f3085c);
            z f11 = f(this.f3087e);
            if (f10 == null || f11 == null || f10 == f11) {
                return f10 != null ? f10 : f11;
            }
            throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + b().f() + " returned Transition " + this.f3085c + " which uses a different Transition  type than its shared element transition " + this.f3087e);
        }

        public Object g() {
            return this.f3087e;
        }

        Object h() {
            return this.f3085c;
        }

        public boolean i() {
            return this.f3087e != null;
        }

        boolean j() {
            return this.f3086d;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ViewGroup viewGroup) {
        super(viewGroup);
    }

    private void w(List<k> list, List<d0.e> list2, boolean z10, Map<d0.e, Boolean> map) {
        int i10;
        boolean z11;
        int i11;
        d0.e eVar;
        ViewGroup m10 = m();
        Context context = m10.getContext();
        ArrayList arrayList = new ArrayList();
        Iterator<k> it = list.iterator();
        boolean z12 = false;
        while (true) {
            i10 = 2;
            if (!it.hasNext()) {
                break;
            }
            k next = it.next();
            if (next.d()) {
                next.a();
            } else {
                g.a e10 = next.e(context);
                if (e10 == null) {
                    next.a();
                } else {
                    Animator animator = e10.f3136b;
                    if (animator == null) {
                        arrayList.add(next);
                    } else {
                        d0.e b10 = next.b();
                        Fragment f10 = b10.f();
                        if (Boolean.TRUE.equals(map.get(b10))) {
                            if (FragmentManager.H0(2)) {
                                Log.v("FragmentManager", "Ignoring Animator set on " + f10 + " as this Fragment was involved in a Transition.");
                            }
                            next.a();
                        } else {
                            boolean z13 = b10.e() == d0.e.c.GONE;
                            if (z13) {
                                list2.remove(b10);
                            }
                            View view = f10.mView;
                            m10.startViewTransition(view);
                            animator.addListener(new c(this, m10, view, z13, b10, next));
                            animator.setTarget(view);
                            animator.start();
                            if (FragmentManager.H0(2)) {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("Animator from operation ");
                                eVar = b10;
                                sb2.append(eVar);
                                sb2.append(" has started.");
                                Log.v("FragmentManager", sb2.toString());
                            } else {
                                eVar = b10;
                            }
                            next.c().d(new d(this, animator, eVar));
                            z12 = true;
                        }
                    }
                }
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            k kVar = (k) it2.next();
            d0.e b11 = kVar.b();
            Fragment f11 = b11.f();
            if (z10) {
                if (FragmentManager.H0(i10)) {
                    Log.v("FragmentManager", "Ignoring Animation set on " + f11 + " as Animations cannot run alongside Transitions.");
                }
                kVar.a();
            } else if (z12) {
                if (FragmentManager.H0(i10)) {
                    Log.v("FragmentManager", "Ignoring Animation set on " + f11 + " as Animations cannot run alongside Animators.");
                }
                kVar.a();
            } else {
                View view2 = f11.mView;
                Animation animation = (Animation) j0.h.g(((g.a) j0.h.g(kVar.e(context))).f3135a);
                if (b11.e() != d0.e.c.REMOVED) {
                    view2.startAnimation(animation);
                    kVar.a();
                    z11 = z12;
                    i11 = i10;
                } else {
                    m10.startViewTransition(view2);
                    g.b bVar = new g.b(animation, m10, view2);
                    z11 = z12;
                    bVar.setAnimationListener(new e(this, b11, m10, view2, kVar));
                    view2.startAnimation(bVar);
                    i11 = 2;
                    if (FragmentManager.H0(2)) {
                        Log.v("FragmentManager", "Animation from operation " + b11 + " has started.");
                    }
                }
                kVar.c().d(new f(this, view2, m10, kVar, b11));
                i10 = i11;
                z12 = z11;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Map<d0.e, Boolean> x(List<m> list, List<d0.e> list2, boolean z10, d0.e eVar, d0.e eVar2) {
        String str;
        String str2;
        ArrayList<View> arrayList;
        ArrayList<View> arrayList2;
        View view;
        String str3;
        View view2;
        Object obj;
        HashMap hashMap;
        Object obj2;
        Object obj3;
        androidx.collection.a aVar;
        HashMap hashMap2;
        d0.e eVar3;
        z zVar;
        View view3;
        Rect rect;
        ArrayList<View> arrayList3;
        d0.e eVar4;
        ArrayList<View> arrayList4;
        View view4;
        View view5;
        boolean z11 = z10;
        d0.e eVar5 = eVar;
        d0.e eVar6 = eVar2;
        HashMap hashMap3 = new HashMap();
        z zVar2 = null;
        for (m mVar : list) {
            if (!mVar.d()) {
                z e10 = mVar.e();
                if (zVar2 == null) {
                    zVar2 = e10;
                } else if (!(e10 == null || zVar2 == e10)) {
                    throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + mVar.b().f() + " returned Transition " + mVar.h() + " which uses a different Transition  type than other Fragments.");
                }
            }
        }
        if (zVar2 == null) {
            for (m mVar2 : list) {
                hashMap3.put(mVar2.b(), Boolean.FALSE);
                mVar2.a();
            }
            return hashMap3;
        }
        View view6 = new View(m().getContext());
        Rect rect2 = new Rect();
        ArrayList<View> arrayList5 = new ArrayList<>();
        ArrayList<View> arrayList6 = new ArrayList<>();
        androidx.collection.a aVar2 = new androidx.collection.a();
        Iterator<m> it = list.iterator();
        Object obj4 = null;
        View view7 = null;
        boolean z12 = false;
        while (true) {
            str = "FragmentManager";
            if (!it.hasNext()) {
                break;
            }
            m next = it.next();
            if (!next.i() || eVar5 == null || eVar6 == null) {
                view7 = view7;
                aVar = aVar2;
                arrayList4 = arrayList6;
                eVar4 = eVar5;
                arrayList3 = arrayList5;
                rect = rect2;
                zVar = zVar2;
                hashMap2 = hashMap3;
                view3 = view6;
                eVar3 = eVar6;
            } else {
                Object u10 = zVar2.u(zVar2.f(next.g()));
                ArrayList<String> sharedElementSourceNames = eVar2.f().getSharedElementSourceNames();
                ArrayList<String> sharedElementSourceNames2 = eVar.f().getSharedElementSourceNames();
                ArrayList<String> sharedElementTargetNames = eVar.f().getSharedElementTargetNames();
                View view8 = view7;
                for (int i10 = 0; i10 < sharedElementTargetNames.size(); i10++) {
                    int indexOf = sharedElementSourceNames.indexOf(sharedElementTargetNames.get(i10));
                    sharedElementTargetNames = sharedElementTargetNames;
                    if (indexOf != -1) {
                        sharedElementSourceNames.set(indexOf, sharedElementSourceNames2.get(i10));
                    }
                }
                ArrayList<String> sharedElementTargetNames2 = eVar2.f().getSharedElementTargetNames();
                if (!z11) {
                    eVar.f().getExitTransitionCallback();
                    eVar2.f().getEnterTransitionCallback();
                } else {
                    eVar.f().getEnterTransitionCallback();
                    eVar2.f().getExitTransitionCallback();
                }
                int size = sharedElementSourceNames.size();
                for (int i11 = 0; i11 < size; i11++) {
                    size = size;
                    aVar2.put(sharedElementSourceNames.get(i11), sharedElementTargetNames2.get(i11));
                }
                if (FragmentManager.H0(2)) {
                    Log.v(str, ">>> entering view names <<<");
                    Iterator<String> it2 = sharedElementTargetNames2.iterator();
                    while (it2.hasNext()) {
                        it2 = it2;
                        Log.v(str, "Name: " + it2.next());
                    }
                    Log.v(str, ">>> exiting view names <<<");
                    Iterator<String> it3 = sharedElementSourceNames.iterator();
                    while (it3.hasNext()) {
                        it3 = it3;
                        Log.v(str, "Name: " + it3.next());
                    }
                }
                androidx.collection.a<String, View> aVar3 = new androidx.collection.a<>();
                u(aVar3, eVar.f().mView);
                aVar3.p(sharedElementSourceNames);
                aVar2.p(aVar3.keySet());
                androidx.collection.a<String, View> aVar4 = new androidx.collection.a<>();
                u(aVar4, eVar2.f().mView);
                aVar4.p(sharedElementTargetNames2);
                aVar4.p(aVar2.values());
                x.c(aVar2, aVar4);
                v(aVar3, aVar2.keySet());
                v(aVar4, aVar2.values());
                if (aVar2.isEmpty()) {
                    arrayList5.clear();
                    arrayList6.clear();
                    aVar = aVar2;
                    arrayList4 = arrayList6;
                    eVar4 = eVar5;
                    arrayList3 = arrayList5;
                    rect = rect2;
                    view3 = view6;
                    zVar = zVar2;
                    view7 = view8;
                    obj4 = null;
                    eVar3 = eVar2;
                    hashMap2 = hashMap3;
                } else {
                    x.a(eVar2.f(), eVar.f(), z11, aVar3, true);
                    hashMap2 = hashMap3;
                    View view9 = view6;
                    aVar = aVar2;
                    arrayList4 = arrayList6;
                    y.a(m(), new g(this, eVar2, eVar, z10, aVar4));
                    arrayList5.addAll(aVar3.values());
                    if (!sharedElementSourceNames.isEmpty()) {
                        View view10 = aVar3.get(sharedElementSourceNames.get(0));
                        zVar2.p(u10, view10);
                        view7 = view10;
                    } else {
                        view7 = view8;
                    }
                    arrayList4.addAll(aVar4.values());
                    if (sharedElementTargetNames2.isEmpty() || (view5 = aVar4.get(sharedElementTargetNames2.get(0))) == null) {
                        view4 = view9;
                    } else {
                        y.a(m(), new h(this, zVar2, view5, rect2));
                        view4 = view9;
                        z12 = true;
                    }
                    zVar2.s(u10, view4, arrayList5);
                    arrayList3 = arrayList5;
                    rect = rect2;
                    view3 = view4;
                    zVar = zVar2;
                    zVar2.n(u10, null, null, null, null, u10, arrayList4);
                    Boolean bool = Boolean.TRUE;
                    eVar4 = eVar;
                    hashMap2.put(eVar4, bool);
                    eVar3 = eVar2;
                    hashMap2.put(eVar3, bool);
                    obj4 = u10;
                }
            }
            eVar5 = eVar4;
            arrayList5 = arrayList3;
            rect2 = rect;
            hashMap3 = hashMap2;
            aVar2 = aVar;
            z11 = z10;
            arrayList6 = arrayList4;
            zVar2 = zVar;
            eVar6 = eVar3;
            view6 = view3;
        }
        View view11 = view7;
        androidx.collection.a aVar5 = aVar2;
        Collection<?> collection = arrayList6;
        d0.e eVar7 = eVar5;
        Collection<?> collection2 = arrayList5;
        Rect rect3 = rect2;
        z zVar3 = zVar2;
        HashMap hashMap4 = hashMap3;
        View view12 = view6;
        d0.e eVar8 = eVar6;
        ArrayList arrayList7 = new ArrayList();
        Object obj5 = null;
        Object obj6 = null;
        for (m mVar3 : list) {
            if (mVar3.d()) {
                hashMap4.put(mVar3.b(), Boolean.FALSE);
                mVar3.a();
            } else {
                Object f10 = zVar3.f(mVar3.h());
                d0.e b10 = mVar3.b();
                boolean z13 = obj4 != null && (b10 == eVar7 || b10 == eVar8);
                if (f10 == null) {
                    if (!z13) {
                        hashMap4.put(b10, Boolean.FALSE);
                        mVar3.a();
                    }
                    arrayList = collection;
                    str3 = str;
                    arrayList2 = collection2;
                    view = view12;
                    obj = obj5;
                    hashMap = hashMap4;
                    view2 = view11;
                } else {
                    str3 = str;
                    ArrayList<View> arrayList8 = new ArrayList<>();
                    Object obj7 = obj5;
                    t(arrayList8, b10.f().mView);
                    if (z13) {
                        if (b10 == eVar7) {
                            arrayList8.removeAll(collection2);
                        } else {
                            arrayList8.removeAll(collection);
                        }
                    }
                    if (arrayList8.isEmpty()) {
                        zVar3.a(f10, view12);
                        arrayList = collection;
                        arrayList2 = collection2;
                        view = view12;
                        obj3 = obj6;
                        hashMap = hashMap4;
                        obj2 = obj7;
                    } else {
                        zVar3.b(f10, arrayList8);
                        view = view12;
                        obj2 = obj7;
                        arrayList2 = collection2;
                        obj3 = obj6;
                        arrayList = collection;
                        hashMap = hashMap4;
                        zVar3.n(f10, f10, arrayList8, null, null, null, null);
                        if (b10.e() == d0.e.c.GONE) {
                            list2.remove(b10);
                            ArrayList<View> arrayList9 = new ArrayList<>(arrayList8);
                            arrayList9.remove(b10.f().mView);
                            zVar3.m(f10, b10.f().mView, arrayList9);
                            y.a(m(), new i(this, arrayList8));
                        }
                    }
                    if (b10.e() == d0.e.c.VISIBLE) {
                        arrayList7.addAll(arrayList8);
                        if (z12) {
                            zVar3.o(f10, rect3);
                        }
                        view2 = view11;
                    } else {
                        view2 = view11;
                        zVar3.p(f10, view2);
                    }
                    hashMap.put(b10, Boolean.TRUE);
                    if (mVar3.j()) {
                        obj6 = zVar3.k(obj3, f10, null);
                        obj = obj2;
                    } else {
                        obj = zVar3.k(obj2, f10, null);
                        obj6 = obj3;
                    }
                }
                eVar8 = eVar2;
                hashMap4 = hashMap;
                obj5 = obj;
                view11 = view2;
                str = str3;
                view12 = view;
                collection2 = arrayList2;
                collection = arrayList;
            }
        }
        ArrayList<View> arrayList10 = collection;
        String str4 = str;
        ArrayList<View> arrayList11 = collection2;
        HashMap hashMap5 = hashMap4;
        Object j10 = zVar3.j(obj6, obj5, obj4);
        if (j10 == null) {
            return hashMap5;
        }
        for (m mVar4 : list) {
            if (!mVar4.d()) {
                Object h10 = mVar4.h();
                d0.e b11 = mVar4.b();
                hashMap5 = hashMap5;
                boolean z14 = obj4 != null && (b11 == eVar7 || b11 == eVar2);
                if (h10 == null && !z14) {
                    str2 = str4;
                } else if (!androidx.core.view.d0.X(m())) {
                    if (FragmentManager.H0(2)) {
                        str2 = str4;
                        Log.v(str2, "SpecialEffectsController: Container " + m() + " has not been laid out. Completing operation " + b11);
                    } else {
                        str2 = str4;
                    }
                    mVar4.a();
                } else {
                    str2 = str4;
                    zVar3.q(mVar4.b().f(), j10, mVar4.c(), new j(this, mVar4, b11));
                }
                str4 = str2;
            }
        }
        HashMap hashMap6 = hashMap5;
        String str5 = str4;
        if (!androidx.core.view.d0.X(m())) {
            return hashMap6;
        }
        x.d(arrayList7, 4);
        ArrayList<String> l10 = zVar3.l(arrayList10);
        if (FragmentManager.H0(2)) {
            Log.v(str5, ">>>>> Beginning transition <<<<<");
            Log.v(str5, ">>>>> SharedElementFirstOutViews <<<<<");
            Iterator<View> it4 = arrayList11.iterator();
            while (it4.hasNext()) {
                View next2 = it4.next();
                Log.v(str5, "View: " + next2 + " Name: " + androidx.core.view.d0.N(next2));
            }
            Log.v(str5, ">>>>> SharedElementLastInViews <<<<<");
            Iterator<View> it5 = arrayList10.iterator();
            while (it5.hasNext()) {
                View next3 = it5.next();
                Log.v(str5, "View: " + next3 + " Name: " + androidx.core.view.d0.N(next3));
            }
        }
        zVar3.c(m(), j10);
        zVar3.r(m(), arrayList11, arrayList10, l10, aVar5);
        x.d(arrayList7, 0);
        zVar3.t(obj4, arrayList11, arrayList10);
        return hashMap6;
    }

    @Override // androidx.fragment.app.d0
    void f(List<d0.e> list, boolean z10) {
        d0.e eVar = null;
        d0.e eVar2 = null;
        for (d0.e eVar3 : list) {
            d0.e.c c10 = d0.e.c.c(eVar3.f().mView);
            int i10 = a.f3050a[eVar3.e().ordinal()];
            if (i10 == 1 || i10 == 2 || i10 == 3) {
                if (c10 == d0.e.c.VISIBLE && eVar == null) {
                    eVar = eVar3;
                }
            } else if (i10 == 4 && c10 != d0.e.c.VISIBLE) {
                eVar2 = eVar3;
            }
        }
        if (FragmentManager.H0(2)) {
            Log.v("FragmentManager", "Executing operations from " + eVar + " to " + eVar2);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList<d0.e> arrayList3 = new ArrayList(list);
        for (d0.e eVar4 : list) {
            g0.c cVar = new g0.c();
            eVar4.j(cVar);
            arrayList.add(new k(eVar4, cVar, z10));
            g0.c cVar2 = new g0.c();
            eVar4.j(cVar2);
            boolean z11 = false;
            if (z10) {
                if (eVar4 != eVar) {
                    arrayList2.add(new m(eVar4, cVar2, z10, z11));
                    eVar4.a(new RunnableC0031b(arrayList3, eVar4));
                }
                z11 = true;
                arrayList2.add(new m(eVar4, cVar2, z10, z11));
                eVar4.a(new RunnableC0031b(arrayList3, eVar4));
            } else {
                if (eVar4 != eVar2) {
                    arrayList2.add(new m(eVar4, cVar2, z10, z11));
                    eVar4.a(new RunnableC0031b(arrayList3, eVar4));
                }
                z11 = true;
                arrayList2.add(new m(eVar4, cVar2, z10, z11));
                eVar4.a(new RunnableC0031b(arrayList3, eVar4));
            }
        }
        Map<d0.e, Boolean> x10 = x(arrayList2, arrayList3, z10, eVar, eVar2);
        w(arrayList, arrayList3, x10.containsValue(Boolean.TRUE), x10);
        for (d0.e eVar5 : arrayList3) {
            s(eVar5);
        }
        arrayList3.clear();
        if (FragmentManager.H0(2)) {
            Log.v("FragmentManager", "Completed executing operations from " + eVar + " to " + eVar2);
        }
    }

    void s(d0.e eVar) {
        eVar.e().a(eVar.f().mView);
    }

    void t(ArrayList<View> arrayList, View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (!g0.a(viewGroup)) {
                int childCount = viewGroup.getChildCount();
                for (int i10 = 0; i10 < childCount; i10++) {
                    View childAt = viewGroup.getChildAt(i10);
                    if (childAt.getVisibility() == 0) {
                        t(arrayList, childAt);
                    }
                }
            } else if (!arrayList.contains(view)) {
                arrayList.add(viewGroup);
            }
        } else if (!arrayList.contains(view)) {
            arrayList.add(view);
        }
    }

    void u(Map<String, View> map, View view) {
        String N = androidx.core.view.d0.N(view);
        if (N != null) {
            map.put(N, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = viewGroup.getChildAt(i10);
                if (childAt.getVisibility() == 0) {
                    u(map, childAt);
                }
            }
        }
    }

    void v(androidx.collection.a<String, View> aVar, Collection<String> collection) {
        Iterator<Map.Entry<String, View>> it = aVar.entrySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(androidx.core.view.d0.N(it.next().getValue()))) {
                it.remove();
            }
        }
    }
}
