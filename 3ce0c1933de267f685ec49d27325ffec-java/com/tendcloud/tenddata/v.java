package com.tendcloud.tenddata;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArraySet;
/* compiled from: td */
/* loaded from: classes2.dex */
public final class v {

    /* renamed from: a  reason: collision with root package name */
    private static volatile v f23023a;

    /* renamed from: b  reason: collision with root package name */
    private final ConcurrentMap<Class<?>, Set<x>> f23024b = new ConcurrentHashMap();

    /* renamed from: c  reason: collision with root package name */
    private final ThreadLocal<ConcurrentLinkedQueue<a>> f23025c = new ThreadLocal<ConcurrentLinkedQueue<a>>() { // from class: com.tendcloud.tenddata.v.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public ConcurrentLinkedQueue<a> initialValue() {
            return new ConcurrentLinkedQueue<>();
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private final ThreadLocal<Boolean> f23026d = new ThreadLocal<Boolean>() { // from class: com.tendcloud.tenddata.v.2
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.lang.ThreadLocal
        public Boolean initialValue() {
            return Boolean.FALSE;
        }
    };

    /* renamed from: e  reason: collision with root package name */
    private final Map<Class<?>, Set<Class<?>>> f23027e = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: td */
    /* loaded from: classes2.dex */
    public static class a {
        final Object event;
        final x handler;

        public a(Object obj, x xVar) {
            this.event = obj;
            this.handler = xVar;
        }
    }

    private v() {
    }

    public static v a() {
        if (f23023a == null) {
            synchronized (v.class) {
                if (f23023a == null) {
                    f23023a = new v();
                }
            }
        }
        return f23023a;
    }

    private Set<Class<?>> c(Class<?> cls) {
        try {
            LinkedList linkedList = new LinkedList();
            HashSet hashSet = new HashSet();
            linkedList.add(cls);
            while (!linkedList.isEmpty()) {
                Class cls2 = (Class) linkedList.remove(0);
                hashSet.add(cls2);
                Class superclass = cls2.getSuperclass();
                if (superclass != null) {
                    linkedList.add(superclass);
                }
            }
            return hashSet;
        } catch (Throwable th2) {
            bf.postSDKError(th2);
            return null;
        }
    }

    protected void b() {
        try {
            if (!this.f23026d.get().booleanValue()) {
                this.f23026d.set(Boolean.TRUE);
                while (true) {
                    a poll = this.f23025c.get().poll();
                    if (poll != null) {
                        if (poll.handler.a()) {
                            b(poll.event, poll.handler);
                        }
                    } else {
                        return;
                    }
                }
            }
        } finally {
            this.f23026d.set(Boolean.FALSE);
        }
    }

    public void post(Object obj) {
        if (obj != null) {
            try {
                boolean z10 = false;
                for (Class<?> cls : b(obj.getClass())) {
                    Set<x> a10 = a(cls);
                    if (a10 != null && !a10.isEmpty()) {
                        z10 = true;
                        for (x xVar : a10) {
                            a(obj, xVar);
                        }
                    }
                }
                if (!z10 && !(obj instanceof y)) {
                    post(new y(this, obj));
                }
                b();
            } catch (Throwable th2) {
                bf.postSDKError(th2);
            }
        }
    }

    public void register(Object obj) {
        Set<x> putIfAbsent;
        if (obj != null) {
            try {
                Map<Class<?>, Set<x>> a10 = w.a(obj);
                for (Class<?> cls : a10.keySet()) {
                    Set<x> set = this.f23024b.get(cls);
                    if (set == null && (putIfAbsent = this.f23024b.putIfAbsent(cls, (set = new CopyOnWriteArraySet<>()))) != null) {
                        set = putIfAbsent;
                    }
                    if (!set.addAll(a10.get(cls))) {
                        return;
                    }
                }
            } catch (Throwable th2) {
                bf.postSDKError(th2);
            }
        }
    }

    public void unregister(Object obj) {
        if (obj != null) {
            try {
                for (Map.Entry<Class<?>, Set<x>> entry : w.a(obj).entrySet()) {
                    Set<x> a10 = a(entry.getKey());
                    Set<x> value = entry.getValue();
                    if (a10 != null && a10.containsAll(value)) {
                        for (x xVar : a10) {
                            if (value.contains(xVar)) {
                                xVar.b();
                            }
                        }
                        a10.removeAll(value);
                    }
                    return;
                }
            } catch (Throwable th2) {
                bf.postSDKError(th2);
            }
        }
    }

    protected void a(Object obj, x xVar) {
        try {
            this.f23025c.get().offer(new a(obj, xVar));
        } catch (Throwable th2) {
            bf.postSDKError(th2);
        }
    }

    Set<x> a(Class<?> cls) {
        try {
            return this.f23024b.get(cls);
        } catch (Throwable th2) {
            bf.postSDKError(th2);
            return null;
        }
    }

    protected void b(Object obj, x xVar) {
        try {
            xVar.handleEvent(obj);
        } catch (Throwable th2) {
            bf.postSDKError(th2);
        }
    }

    Set<Class<?>> b(Class<?> cls) {
        try {
            Set<Class<?>> set = this.f23027e.get(cls);
            if (set != null) {
                return set;
            }
            Set<Class<?>> c10 = c(cls);
            this.f23027e.put(cls, c10);
            return c10;
        } catch (Throwable th2) {
            bf.postSDKError(th2);
            return null;
        }
    }
}
