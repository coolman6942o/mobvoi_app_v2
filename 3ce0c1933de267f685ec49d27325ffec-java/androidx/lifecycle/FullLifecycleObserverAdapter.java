package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class FullLifecycleObserverAdapter implements n {

    /* renamed from: a  reason: collision with root package name */
    private final h f3239a;

    /* renamed from: b  reason: collision with root package name */
    private final n f3240b;

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3241a;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            f3241a = iArr;
            try {
                iArr[Lifecycle.Event.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3241a[Lifecycle.Event.ON_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3241a[Lifecycle.Event.ON_RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3241a[Lifecycle.Event.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3241a[Lifecycle.Event.ON_STOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3241a[Lifecycle.Event.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3241a[Lifecycle.Event.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FullLifecycleObserverAdapter(h hVar, n nVar) {
        this.f3239a = hVar;
        this.f3240b = nVar;
    }

    @Override // androidx.lifecycle.n
    public void c(p pVar, Lifecycle.Event event) {
        switch (a.f3241a[event.ordinal()]) {
            case 1:
                this.f3239a.b(pVar);
                break;
            case 2:
                this.f3239a.i(pVar);
                break;
            case 3:
                this.f3239a.a(pVar);
                break;
            case 4:
                this.f3239a.e(pVar);
                break;
            case 5:
                this.f3239a.f(pVar);
                break;
            case 6:
                this.f3239a.g(pVar);
                break;
            case 7:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
        }
        n nVar = this.f3240b;
        if (nVar != null) {
            nVar.c(pVar, event);
        }
    }
}
