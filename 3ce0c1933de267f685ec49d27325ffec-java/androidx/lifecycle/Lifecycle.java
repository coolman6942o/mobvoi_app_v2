package androidx.lifecycle;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public abstract class Lifecycle {

    /* loaded from: classes.dex */
    public enum Event {
        ON_CREATE,
        ON_START,
        ON_RESUME,
        ON_PAUSE,
        ON_STOP,
        ON_DESTROY,
        ON_ANY;

        public static Event downFrom(State state) {
            int i10 = a.f3242a[state.ordinal()];
            if (i10 == 1) {
                return ON_DESTROY;
            }
            if (i10 == 2) {
                return ON_STOP;
            }
            if (i10 != 3) {
                return null;
            }
            return ON_PAUSE;
        }

        public static Event downTo(State state) {
            int i10 = a.f3242a[state.ordinal()];
            if (i10 == 1) {
                return ON_STOP;
            }
            if (i10 == 2) {
                return ON_PAUSE;
            }
            if (i10 != 4) {
                return null;
            }
            return ON_DESTROY;
        }

        public static Event upFrom(State state) {
            int i10 = a.f3242a[state.ordinal()];
            if (i10 == 1) {
                return ON_START;
            }
            if (i10 == 2) {
                return ON_RESUME;
            }
            if (i10 != 5) {
                return null;
            }
            return ON_CREATE;
        }

        public static Event upTo(State state) {
            int i10 = a.f3242a[state.ordinal()];
            if (i10 == 1) {
                return ON_CREATE;
            }
            if (i10 == 2) {
                return ON_START;
            }
            if (i10 != 3) {
                return null;
            }
            return ON_RESUME;
        }

        public State getTargetState() {
            switch (a.f3243b[ordinal()]) {
                case 1:
                case 2:
                    return State.CREATED;
                case 3:
                case 4:
                    return State.STARTED;
                case 5:
                    return State.RESUMED;
                case 6:
                    return State.DESTROYED;
                default:
                    throw new IllegalArgumentException(this + " has no target state");
            }
        }
    }

    /* loaded from: classes.dex */
    public enum State {
        DESTROYED,
        INITIALIZED,
        CREATED,
        STARTED,
        RESUMED;

        public boolean isAtLeast(State state) {
            return compareTo(state) >= 0;
        }
    }

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3242a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f3243b;

        static {
            int[] iArr = new int[Event.values().length];
            f3243b = iArr;
            try {
                iArr[Event.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3243b[Event.ON_STOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3243b[Event.ON_START.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3243b[Event.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3243b[Event.ON_RESUME.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3243b[Event.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3243b[Event.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr2 = new int[State.values().length];
            f3242a = iArr2;
            try {
                iArr2[State.CREATED.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f3242a[State.STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f3242a[State.RESUMED.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f3242a[State.DESTROYED.ordinal()] = 4;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f3242a[State.INITIALIZED.ordinal()] = 5;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    public Lifecycle() {
        new AtomicReference();
    }

    public abstract void a(o oVar);

    public abstract State b();

    public abstract void c(o oVar);
}
