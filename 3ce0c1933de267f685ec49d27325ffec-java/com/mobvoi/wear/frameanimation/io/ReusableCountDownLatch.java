package com.mobvoi.wear.frameanimation.io;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;
/* compiled from: ReusableCountDownLatch.kt */
/* loaded from: classes2.dex */
public final class ReusableCountDownLatch {
    private int count;
    private final Sync sync;

    /* compiled from: ReusableCountDownLatch.kt */
    /* loaded from: classes2.dex */
    private static final class Sync extends AbstractQueuedSynchronizer {
        public final int getCount() {
            return getState();
        }

        public final void setCount(int i10) {
            setState(i10);
        }

        @Override // java.util.concurrent.locks.AbstractQueuedSynchronizer
        protected int tryAcquireShared(int i10) {
            return getState() == 0 ? 1 : -1;
        }

        @Override // java.util.concurrent.locks.AbstractQueuedSynchronizer
        protected boolean tryReleaseShared(int i10) {
            int state;
            int i11;
            do {
                state = getState();
                if (state == 0) {
                    return false;
                }
                i11 = state - 1;
            } while (!compareAndSetState(state, i11));
            return i11 == 0;
        }
    }

    public ReusableCountDownLatch() {
        Sync sync = new Sync();
        this.sync = sync;
        sync.setCount(this.count);
    }

    public final void await() throws InterruptedException {
        try {
            this.sync.acquireSharedInterruptibly(1);
        } catch (InterruptedException e10) {
            this.sync.setCount(0);
            throw e10;
        }
    }

    public final void countDown() {
        this.sync.releaseShared(1);
    }

    public final int getCount() {
        return this.count;
    }

    public final void setCount(int i10) {
        if (i10 < 1) {
            throw new IllegalArgumentException("count < 1");
        } else if (this.sync.getCount() == 0) {
            this.sync.setCount(i10);
            this.count = i10;
        } else {
            throw new IllegalStateException("last task has not ended");
        }
    }
}
