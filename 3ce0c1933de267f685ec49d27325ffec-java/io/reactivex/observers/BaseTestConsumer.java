package io.reactivex.observers;

import io.reactivex.internal.util.VolatileSizeArrayList;
import io.reactivex.observers.BaseTestConsumer;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import xn.b;
/* loaded from: classes3.dex */
public abstract class BaseTestConsumer<T, U extends BaseTestConsumer<T, U>> implements b {

    /* renamed from: d  reason: collision with root package name */
    protected long f29268d;

    /* renamed from: e  reason: collision with root package name */
    protected boolean f29269e;

    /* renamed from: f  reason: collision with root package name */
    protected int f29270f;

    /* renamed from: g  reason: collision with root package name */
    protected int f29271g;

    /* renamed from: b  reason: collision with root package name */
    protected final List<T> f29266b = new VolatileSizeArrayList();

    /* renamed from: c  reason: collision with root package name */
    protected final List<Throwable> f29267c = new VolatileSizeArrayList();

    /* renamed from: a  reason: collision with root package name */
    protected final CountDownLatch f29265a = new CountDownLatch(1);

    /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
    /* loaded from: classes3.dex */
    public static abstract class TestWaitStrategy extends Enum<TestWaitStrategy> implements Runnable {
        private static final /* synthetic */ TestWaitStrategy[] $VALUES;
        public static final TestWaitStrategy SLEEP_1000MS;
        public static final TestWaitStrategy SLEEP_100MS;
        public static final TestWaitStrategy SLEEP_10MS;
        public static final TestWaitStrategy SLEEP_1MS;
        public static final TestWaitStrategy SPIN;
        public static final TestWaitStrategy YIELD;

        /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
        /* loaded from: classes3.dex */
        static class a extends TestWaitStrategy {
            a(String str, int i10) {
                super(str, i10);
            }

            @Override // io.reactivex.observers.BaseTestConsumer.TestWaitStrategy, java.lang.Runnable
            public void run() {
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
        /* loaded from: classes3.dex */
        static class b extends TestWaitStrategy {
            b(String str, int i10) {
                super(str, i10);
            }

            @Override // io.reactivex.observers.BaseTestConsumer.TestWaitStrategy, java.lang.Runnable
            public void run() {
                Thread.yield();
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
        /* loaded from: classes3.dex */
        static class c extends TestWaitStrategy {
            c(String str, int i10) {
                super(str, i10);
            }

            @Override // io.reactivex.observers.BaseTestConsumer.TestWaitStrategy, java.lang.Runnable
            public void run() {
                TestWaitStrategy.a(1);
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
        /* loaded from: classes3.dex */
        static class d extends TestWaitStrategy {
            d(String str, int i10) {
                super(str, i10);
            }

            @Override // io.reactivex.observers.BaseTestConsumer.TestWaitStrategy, java.lang.Runnable
            public void run() {
                TestWaitStrategy.a(10);
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
        /* loaded from: classes3.dex */
        static class e extends TestWaitStrategy {
            e(String str, int i10) {
                super(str, i10);
            }

            @Override // io.reactivex.observers.BaseTestConsumer.TestWaitStrategy, java.lang.Runnable
            public void run() {
                TestWaitStrategy.a(100);
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
        /* loaded from: classes3.dex */
        static class f extends TestWaitStrategy {
            f(String str, int i10) {
                super(str, i10);
            }

            @Override // io.reactivex.observers.BaseTestConsumer.TestWaitStrategy, java.lang.Runnable
            public void run() {
                TestWaitStrategy.a(1000);
            }
        }

        static {
            a aVar = new a("SPIN", 0);
            SPIN = aVar;
            b bVar = new b("YIELD", 1);
            YIELD = bVar;
            c cVar = new c("SLEEP_1MS", 2);
            SLEEP_1MS = cVar;
            d dVar = new d("SLEEP_10MS", 3);
            SLEEP_10MS = dVar;
            e eVar = new e("SLEEP_100MS", 4);
            SLEEP_100MS = eVar;
            f fVar = new f("SLEEP_1000MS", 5);
            SLEEP_1000MS = fVar;
            $VALUES = new TestWaitStrategy[]{aVar, bVar, cVar, dVar, eVar, fVar};
        }

        private TestWaitStrategy(String str, int i10) {
        }

        static void a(int i10) {
            try {
                Thread.sleep(i10);
            } catch (InterruptedException e10) {
                throw new RuntimeException(e10);
            }
        }

        public static TestWaitStrategy valueOf(String str) {
            return (TestWaitStrategy) Enum.valueOf(TestWaitStrategy.class, str);
        }

        public static TestWaitStrategy[] values() {
            return (TestWaitStrategy[]) $VALUES.clone();
        }

        @Override // java.lang.Runnable
        public abstract void run();
    }
}
