package com.google.common.util.concurrent;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.s5;
import com.google.common.collect.u5;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/* loaded from: classes.dex */
public class CycleDetectingLockFactory {

    /* renamed from: a  reason: collision with root package name */
    private static final Logger f12393a = Logger.getLogger(CycleDetectingLockFactory.class.getName());

    /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
    /* loaded from: classes.dex */
    public static abstract class Policies extends Enum<Policies> {
        public static final Policies THROW = new a("THROW", 0);
        public static final Policies WARN = new b("WARN", 1);
        public static final Policies DISABLED = new c("DISABLED", 2);
        private static final /* synthetic */ Policies[] $VALUES = a();

        /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
        /* loaded from: classes.dex */
        final class a extends Policies {
            a(String str, int i10) {
                super(str, i10, null);
            }

            @Override // com.google.common.util.concurrent.CycleDetectingLockFactory.Policies
            public void handlePotentialDeadlock(PotentialDeadlockException potentialDeadlockException) {
                throw potentialDeadlockException;
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
        /* loaded from: classes.dex */
        final class b extends Policies {
            b(String str, int i10) {
                super(str, i10, null);
            }

            @Override // com.google.common.util.concurrent.CycleDetectingLockFactory.Policies
            public void handlePotentialDeadlock(PotentialDeadlockException potentialDeadlockException) {
                CycleDetectingLockFactory.f12393a.log(Level.SEVERE, "Detected potential deadlock", (Throwable) potentialDeadlockException);
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
        /* loaded from: classes.dex */
        final class c extends Policies {
            c(String str, int i10) {
                super(str, i10, null);
            }

            @Override // com.google.common.util.concurrent.CycleDetectingLockFactory.Policies
            public void handlePotentialDeadlock(PotentialDeadlockException potentialDeadlockException) {
            }
        }

        private Policies(String str, int i10) {
        }

        private static /* synthetic */ Policies[] a() {
            return new Policies[]{THROW, WARN, DISABLED};
        }

        public static Policies valueOf(String str) {
            return (Policies) Enum.valueOf(Policies.class, str);
        }

        public static Policies[] values() {
            return (Policies[]) $VALUES.clone();
        }

        public abstract /* synthetic */ void handlePotentialDeadlock(PotentialDeadlockException potentialDeadlockException);

        /* synthetic */ Policies(String str, int i10, a aVar) {
            this(str, i10);
        }
    }

    /* loaded from: classes.dex */
    public static final class PotentialDeadlockException extends b {
        private final b conflictingStackTrace;

        public b getConflictingStackTrace() {
            return this.conflictingStackTrace;
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            StringBuilder sb2 = new StringBuilder(super.getMessage());
            for (Throwable th2 = this.conflictingStackTrace; th2 != null; th2 = th2.getCause()) {
                sb2.append(", ");
                sb2.append(th2.getMessage());
            }
            return sb2.toString();
        }
    }

    /* loaded from: classes.dex */
    class a extends ThreadLocal<ArrayList<c>> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: a */
        public ArrayList<c> initialValue() {
            return s5.j(3);
        }
    }

    /* loaded from: classes.dex */
    private static class b extends IllegalStateException {
        static final StackTraceElement[] EMPTY_STACK_TRACE = new StackTraceElement[0];
        static final ImmutableSet<String> EXCLUDED_CLASS_NAMES = ImmutableSet.of(CycleDetectingLockFactory.class.getName(), b.class.getName(), c.class.getName());
    }

    /* loaded from: classes.dex */
    private static class c {
    }

    static {
        new u5().h().f();
        new a();
    }
}
