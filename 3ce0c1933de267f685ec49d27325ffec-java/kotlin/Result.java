package kotlin;

import java.io.Serializable;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
/* compiled from: Result.kt */
/* loaded from: classes3.dex */
public final class Result<T> implements Serializable {
    public static final a Companion = new a(null);
    private final Object value;

    /* compiled from: Result.kt */
    /* loaded from: classes3.dex */
    public static final class Failure implements Serializable {
        public final Throwable exception;

        public Failure(Throwable exception) {
            i.f(exception, "exception");
            this.exception = exception;
        }

        public boolean equals(Object obj) {
            return (obj instanceof Failure) && i.b(this.exception, ((Failure) obj).exception);
        }

        public int hashCode() {
            return this.exception.hashCode();
        }

        public String toString() {
            return "Failure(" + this.exception + ')';
        }
    }

    /* compiled from: Result.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    private /* synthetic */ Result(Object obj) {
        this.value = obj;
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ Result m27boximpl(Object obj) {
        return new Result(obj);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static Object m28constructorimpl(Object obj) {
        return obj;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m29equalsimpl(Object obj, Object obj2) {
        return (obj2 instanceof Result) && i.b(obj, ((Result) obj2).m36unboximpl());
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m30equalsimpl0(Object obj, Object obj2) {
        return i.b(obj, obj2);
    }

    /* renamed from: exceptionOrNull-impl  reason: not valid java name */
    public static final Throwable m31exceptionOrNullimpl(Object obj) {
        if (obj instanceof Failure) {
            return ((Failure) obj).exception;
        }
        return null;
    }

    public static /* synthetic */ void getValue$annotations() {
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m32hashCodeimpl(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    /* renamed from: isFailure-impl  reason: not valid java name */
    public static final boolean m33isFailureimpl(Object obj) {
        return obj instanceof Failure;
    }

    /* renamed from: isSuccess-impl  reason: not valid java name */
    public static final boolean m34isSuccessimpl(Object obj) {
        return !(obj instanceof Failure);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m35toStringimpl(Object obj) {
        if (obj instanceof Failure) {
            return obj.toString();
        }
        return "Success(" + obj + ')';
    }

    public boolean equals(Object obj) {
        return m29equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m32hashCodeimpl(this.value);
    }

    public String toString() {
        return m35toStringimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ Object m36unboximpl() {
        return this.value;
    }
}
