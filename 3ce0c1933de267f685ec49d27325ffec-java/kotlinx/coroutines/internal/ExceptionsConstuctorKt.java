package kotlinx.coroutines.internal;

import io.h;
import io.m;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Result;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.e0;
import qo.l;
/* compiled from: ExceptionsConstuctor.kt */
/* loaded from: classes3.dex */
public final class ExceptionsConstuctorKt {

    /* renamed from: a  reason: collision with root package name */
    private static final int f30192a = d(Throwable.class, -1);

    /* renamed from: b  reason: collision with root package name */
    private static final ReentrantReadWriteLock f30193b = new ReentrantReadWriteLock();

    /* renamed from: c  reason: collision with root package name */
    private static final WeakHashMap<Class<? extends Throwable>, l<Throwable, Throwable>> f30194c = new WeakHashMap<>();

    /* compiled from: Comparisons.kt */
    /* loaded from: classes3.dex */
    public static final class a<T> implements Comparator<T> {
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            int a10;
            a10 = jo.b.a(Integer.valueOf(((Constructor) t11).getParameterTypes().length), Integer.valueOf(((Constructor) t10).getParameterTypes().length));
            return a10;
        }
    }

    /* compiled from: ExceptionsConstuctor.kt */
    /* loaded from: classes3.dex */
    static final class b extends Lambda implements l {
        public static final b INSTANCE = new b();

        b() {
            super(1);
        }

        /* renamed from: a */
        public final Void invoke(Throwable th2) {
            return null;
        }
    }

    /* compiled from: ExceptionsConstuctor.kt */
    /* loaded from: classes3.dex */
    static final class c extends Lambda implements l {
        public static final c INSTANCE = new c();

        c() {
            super(1);
        }

        /* renamed from: a */
        public final Void invoke(Throwable th2) {
            return null;
        }
    }

    private static final l<Throwable, Throwable> a(Constructor<?> constructor) {
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        int length = parameterTypes.length;
        if (length == 0) {
            return new ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$4(constructor);
        }
        if (length == 1) {
            Class<?> cls = parameterTypes[0];
            if (i.b(cls, Throwable.class)) {
                return new ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$2(constructor);
            }
            if (i.b(cls, String.class)) {
                return new ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$3(constructor);
            }
            return null;
        } else if (length == 2 && i.b(parameterTypes[0], String.class) && i.b(parameterTypes[1], Throwable.class)) {
            return new ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$1(constructor);
        } else {
            return null;
        }
    }

    private static final int b(Class<?> cls, int i10) {
        Field[] declaredFields;
        do {
            int length = cls.getDeclaredFields().length;
            int i11 = 0;
            for (int i12 = 0; i12 < length; i12++) {
                if (!Modifier.isStatic(declaredFields[i12].getModifiers())) {
                    i11++;
                }
            }
            i10 += i11;
            cls = cls.getSuperclass();
        } while (cls != null);
        return i10;
    }

    static /* synthetic */ int c(Class cls, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 0;
        }
        return b(cls, i10);
    }

    private static final int d(Class<?> cls, int i10) {
        Object obj;
        po.a.c(cls);
        try {
            Result.a aVar = Result.Companion;
            obj = Result.m28constructorimpl(Integer.valueOf(c(cls, 0, 1, null)));
        } catch (Throwable th2) {
            Result.a aVar2 = Result.Companion;
            obj = Result.m28constructorimpl(h.a(th2));
        }
        obj = Integer.valueOf(i10);
        if (Result.m33isFailureimpl(obj)) {
        }
        return ((Number) obj).intValue();
    }

    /* JADX WARN: Finally extract failed */
    public static final <E extends Throwable> E e(E e10) {
        Object obj;
        List B;
        ReentrantReadWriteLock.ReadLock readLock;
        int readHoldCount;
        ReentrantReadWriteLock.WriteLock writeLock;
        Object obj2 = null;
        if (e10 instanceof e0) {
            try {
                Result.a aVar = Result.Companion;
                obj = Result.m28constructorimpl(((e0) e10).createCopy());
            } catch (Throwable th2) {
                Result.a aVar2 = Result.Companion;
                obj = Result.m28constructorimpl(h.a(th2));
            }
            if (!Result.m33isFailureimpl(obj)) {
                obj2 = obj;
            }
            return (E) obj2;
        }
        ReentrantReadWriteLock reentrantReadWriteLock = f30193b;
        ReentrantReadWriteLock.ReadLock readLock2 = reentrantReadWriteLock.readLock();
        readLock2.lock();
        try {
            l<Throwable, Throwable> lVar = f30194c.get(e10.getClass());
            readLock2.unlock();
            if (lVar != null) {
                return (E) lVar.invoke(e10);
            }
            int i10 = 0;
            if (f30192a != d(e10.getClass(), 0)) {
                readLock = reentrantReadWriteLock.readLock();
                readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
                for (int i11 = 0; i11 < readHoldCount; i11++) {
                    readLock.unlock();
                }
                writeLock = reentrantReadWriteLock.writeLock();
                writeLock.lock();
                try {
                    f30194c.put(e10.getClass(), b.INSTANCE);
                    m mVar = m.f28349a;
                    return null;
                } finally {
                    while (i10 < readHoldCount) {
                        readLock.lock();
                        i10++;
                    }
                    writeLock.unlock();
                }
            } else {
                B = kotlin.collections.i.B(e10.getClass().getConstructors(), new a());
                Iterator it = B.iterator();
                l<Throwable, Throwable> lVar2 = null;
                while (it.hasNext() && (lVar2 = a((Constructor) it.next())) == null) {
                }
                ReentrantReadWriteLock reentrantReadWriteLock2 = f30193b;
                readLock = reentrantReadWriteLock2.readLock();
                readHoldCount = reentrantReadWriteLock2.getWriteHoldCount() == 0 ? reentrantReadWriteLock2.getReadHoldCount() : 0;
                for (int i12 = 0; i12 < readHoldCount; i12++) {
                    readLock.unlock();
                }
                writeLock = reentrantReadWriteLock2.writeLock();
                writeLock.lock();
                try {
                    f30194c.put(e10.getClass(), lVar2 == null ? c.INSTANCE : lVar2);
                    m mVar2 = m.f28349a;
                    while (i10 < readHoldCount) {
                        readLock.lock();
                        i10++;
                    }
                    writeLock.unlock();
                    if (lVar2 == null) {
                        return null;
                    }
                    return (E) lVar2.invoke(e10);
                } finally {
                    while (i10 < readHoldCount) {
                        readLock.lock();
                        i10++;
                    }
                    writeLock.unlock();
                }
            }
        } catch (Throwable th3) {
            readLock2.unlock();
            throw th3;
        }
    }
}
