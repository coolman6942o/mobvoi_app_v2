package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.n;
import androidx.lifecycle.p;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
/* loaded from: classes.dex */
public abstract class ActivityResultRegistry {

    /* renamed from: a  reason: collision with root package name */
    private Random f325a = new Random();

    /* renamed from: b  reason: collision with root package name */
    private final Map<Integer, String> f326b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    final Map<String, Integer> f327c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private final Map<String, d> f328d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    ArrayList<String> f329e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    final transient Map<String, c<?>> f330f = new HashMap();

    /* renamed from: g  reason: collision with root package name */
    final Map<String, Object> f331g = new HashMap();

    /* renamed from: h  reason: collision with root package name */
    final Bundle f332h = new Bundle();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends androidx.activity.result.b<I> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f337a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ c.a f338b;

        a(String str, c.a aVar) {
            this.f337a = str;
            this.f338b = aVar;
        }

        @Override // androidx.activity.result.b
        public void b(I i10, androidx.core.app.b bVar) {
            Integer num = ActivityResultRegistry.this.f327c.get(this.f337a);
            if (num != null) {
                ActivityResultRegistry.this.f329e.add(this.f337a);
                try {
                    ActivityResultRegistry.this.f(num.intValue(), this.f338b, i10, bVar);
                } catch (Exception e10) {
                    ActivityResultRegistry.this.f329e.remove(this.f337a);
                    throw e10;
                }
            } else {
                throw new IllegalStateException("Attempting to launch an unregistered ActivityResultLauncher with contract " + this.f338b + " and input " + i10 + ". You must ensure the ActivityResultLauncher is registered before calling launch().");
            }
        }

        @Override // androidx.activity.result.b
        public void c() {
            ActivityResultRegistry.this.l(this.f337a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends androidx.activity.result.b<I> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f340a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ c.a f341b;

        b(String str, c.a aVar) {
            this.f340a = str;
            this.f341b = aVar;
        }

        @Override // androidx.activity.result.b
        public void b(I i10, androidx.core.app.b bVar) {
            Integer num = ActivityResultRegistry.this.f327c.get(this.f340a);
            if (num != null) {
                ActivityResultRegistry.this.f329e.add(this.f340a);
                ActivityResultRegistry.this.f(num.intValue(), this.f341b, i10, bVar);
                return;
            }
            throw new IllegalStateException("Attempting to launch an unregistered ActivityResultLauncher with contract " + this.f341b + " and input " + i10 + ". You must ensure the ActivityResultLauncher is registered before calling launch().");
        }

        @Override // androidx.activity.result.b
        public void c() {
            ActivityResultRegistry.this.l(this.f340a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c<O> {

        /* renamed from: a  reason: collision with root package name */
        final androidx.activity.result.a<O> f343a;

        /* renamed from: b  reason: collision with root package name */
        final c.a<?, O> f344b;

        c(androidx.activity.result.a<O> aVar, c.a<?, O> aVar2) {
            this.f343a = aVar;
            this.f344b = aVar2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        final Lifecycle f345a;

        /* renamed from: b  reason: collision with root package name */
        private final ArrayList<n> f346b = new ArrayList<>();

        d(Lifecycle lifecycle) {
            this.f345a = lifecycle;
        }

        void a(n nVar) {
            this.f345a.a(nVar);
            this.f346b.add(nVar);
        }

        void b() {
            Iterator<n> it = this.f346b.iterator();
            while (it.hasNext()) {
                this.f345a.c(it.next());
            }
            this.f346b.clear();
        }
    }

    private void a(int i10, String str) {
        this.f326b.put(Integer.valueOf(i10), str);
        this.f327c.put(str, Integer.valueOf(i10));
    }

    private <O> void d(String str, int i10, Intent intent, c<O> cVar) {
        if (cVar == null || cVar.f343a == null || !this.f329e.contains(str)) {
            this.f331g.remove(str);
            this.f332h.putParcelable(str, new ActivityResult(i10, intent));
            return;
        }
        cVar.f343a.a(cVar.f344b.c(i10, intent));
        this.f329e.remove(str);
    }

    private int e() {
        int nextInt = this.f325a.nextInt(2147418112);
        while (true) {
            int i10 = nextInt + WXMediaMessage.THUMB_LENGTH_LIMIT;
            if (!this.f326b.containsKey(Integer.valueOf(i10))) {
                return i10;
            }
            nextInt = this.f325a.nextInt(2147418112);
        }
    }

    private void k(String str) {
        if (this.f327c.get(str) == null) {
            a(e(), str);
        }
    }

    public final boolean b(int i10, int i11, Intent intent) {
        String str = this.f326b.get(Integer.valueOf(i10));
        if (str == null) {
            return false;
        }
        d(str, i11, intent, this.f330f.get(str));
        return true;
    }

    public final <O> boolean c(int i10, @SuppressLint({"UnknownNullness"}) O o10) {
        androidx.activity.result.a<?> aVar;
        String str = this.f326b.get(Integer.valueOf(i10));
        if (str == null) {
            return false;
        }
        c<?> cVar = this.f330f.get(str);
        if (cVar == null || (aVar = cVar.f343a) == null) {
            this.f332h.remove(str);
            this.f331g.put(str, o10);
            return true;
        } else if (!this.f329e.remove(str)) {
            return true;
        } else {
            aVar.a(o10);
            return true;
        }
    }

    public abstract <I, O> void f(int i10, c.a<I, O> aVar, @SuppressLint({"UnknownNullness"}) I i11, androidx.core.app.b bVar);

    public final void g(Bundle bundle) {
        if (bundle != null) {
            ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
            ArrayList<String> stringArrayList = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
            if (!(stringArrayList == null || integerArrayList == null)) {
                this.f329e = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
                this.f325a = (Random) bundle.getSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT");
                this.f332h.putAll(bundle.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT"));
                for (int i10 = 0; i10 < stringArrayList.size(); i10++) {
                    String str = stringArrayList.get(i10);
                    if (this.f327c.containsKey(str)) {
                        Integer remove = this.f327c.remove(str);
                        if (!this.f332h.containsKey(str)) {
                            this.f326b.remove(remove);
                        }
                    }
                    a(integerArrayList.get(i10).intValue(), stringArrayList.get(i10));
                }
            }
        }
    }

    public final void h(Bundle bundle) {
        bundle.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList<>(this.f327c.values()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList<>(this.f327c.keySet()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList<>(this.f329e));
        bundle.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", (Bundle) this.f332h.clone());
        bundle.putSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT", this.f325a);
    }

    public final <I, O> androidx.activity.result.b<I> i(final String str, p pVar, final c.a<I, O> aVar, final androidx.activity.result.a<O> aVar2) {
        Lifecycle lifecycle = pVar.getLifecycle();
        if (!lifecycle.b().isAtLeast(Lifecycle.State.STARTED)) {
            k(str);
            d dVar = this.f328d.get(str);
            if (dVar == null) {
                dVar = new d(lifecycle);
            }
            dVar.a(new n() { // from class: androidx.activity.result.ActivityResultRegistry.1
                @Override // androidx.lifecycle.n
                public void c(p pVar2, Lifecycle.Event event) {
                    if (Lifecycle.Event.ON_START.equals(event)) {
                        ActivityResultRegistry.this.f330f.put(str, new c<>(aVar2, aVar));
                        if (ActivityResultRegistry.this.f331g.containsKey(str)) {
                            Object obj = ActivityResultRegistry.this.f331g.get(str);
                            ActivityResultRegistry.this.f331g.remove(str);
                            aVar2.a(obj);
                        }
                        ActivityResult activityResult = (ActivityResult) ActivityResultRegistry.this.f332h.getParcelable(str);
                        if (activityResult != null) {
                            ActivityResultRegistry.this.f332h.remove(str);
                            aVar2.a(aVar.c(activityResult.b(), activityResult.a()));
                        }
                    } else if (Lifecycle.Event.ON_STOP.equals(event)) {
                        ActivityResultRegistry.this.f330f.remove(str);
                    } else if (Lifecycle.Event.ON_DESTROY.equals(event)) {
                        ActivityResultRegistry.this.l(str);
                    }
                }
            });
            this.f328d.put(str, dVar);
            return new a(str, aVar);
        }
        throw new IllegalStateException("LifecycleOwner " + pVar + " is attempting to register while current state is " + lifecycle.b() + ". LifecycleOwners must call register before they are STARTED.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <I, O> androidx.activity.result.b<I> j(String str, c.a<I, O> aVar, androidx.activity.result.a<O> aVar2) {
        k(str);
        this.f330f.put(str, new c<>(aVar2, aVar));
        if (this.f331g.containsKey(str)) {
            Object obj = this.f331g.get(str);
            this.f331g.remove(str);
            aVar2.a(obj);
        }
        ActivityResult activityResult = (ActivityResult) this.f332h.getParcelable(str);
        if (activityResult != null) {
            this.f332h.remove(str);
            aVar2.a(aVar.c(activityResult.b(), activityResult.a()));
        }
        return new b(str, aVar);
    }

    final void l(String str) {
        Integer remove;
        if (!this.f329e.contains(str) && (remove = this.f327c.remove(str)) != null) {
            this.f326b.remove(remove);
        }
        this.f330f.remove(str);
        if (this.f331g.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + this.f331g.get(str));
            this.f331g.remove(str);
        }
        if (this.f332h.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + this.f332h.getParcelable(str));
            this.f332h.remove(str);
        }
        d dVar = this.f328d.get(str);
        if (dVar != null) {
            dVar.b();
            this.f328d.remove(str);
        }
    }
}
