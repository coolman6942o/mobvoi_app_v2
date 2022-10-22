package com.mobvoi.android.common.utils;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
/* compiled from: WeakListenerManager.java */
/* loaded from: classes2.dex */
public class t<IListener> {
    private static final boolean DEV_LOG = false;
    private static final String TAG = "WeakListenerManager";
    private final List<t<IListener>.a> mListeners = new ArrayList();

    /* compiled from: WeakListenerManager.java */
    /* loaded from: classes2.dex */
    private class a {

        /* renamed from: a  reason: collision with root package name */
        String f15456a;

        /* renamed from: b  reason: collision with root package name */
        WeakReference<IListener> f15457b;

        a(t tVar, IListener ilistener) {
            this.f15456a = ilistener.getClass().getName();
            this.f15457b = new WeakReference<>(ilistener);
        }
    }

    /* compiled from: WeakListenerManager.java */
    /* loaded from: classes2.dex */
    public interface b<IListener> {
        void notify(IListener ilistener);
    }

    public void addListener(IListener ilistener) {
        synchronized (this.mListeners) {
            if (this.mListeners.size() == 0) {
                onFirstListenerAdd();
            }
            for (t<IListener>.a aVar : this.mListeners) {
                if (aVar.f15457b.get() == ilistener) {
                    return;
                }
            }
            this.mListeners.add(new a(this, ilistener));
            onListenerAdded(ilistener);
        }
    }

    public void notifyListeners(b<IListener> bVar) {
        synchronized (this.mListeners) {
            int i10 = 0;
            while (i10 < this.mListeners.size()) {
                t<IListener>.a aVar = this.mListeners.get(i10);
                IListener ilistener = aVar.f15457b.get();
                if (ilistener == null) {
                    k.d(TAG, "listener leak found: " + aVar.f15456a);
                    this.mListeners.remove(i10);
                } else {
                    bVar.notify(ilistener);
                    i10++;
                }
            }
        }
    }

    protected void onFirstListenerAdd() {
    }

    protected void onLastListenerRemoved() {
    }

    protected void onListenerAdded(IListener ilistener) {
    }

    public void removeListener(IListener ilistener) {
        synchronized (this.mListeners) {
            int size = this.mListeners.size();
            boolean z10 = false;
            int i10 = 0;
            while (true) {
                if (i10 >= size) {
                    break;
                } else if (this.mListeners.get(i10).f15457b.get() == ilistener) {
                    this.mListeners.remove(i10);
                    z10 = true;
                    break;
                } else {
                    i10++;
                }
            }
            if (this.mListeners.size() == 0 && z10) {
                onLastListenerRemoved();
            }
        }
    }
}
