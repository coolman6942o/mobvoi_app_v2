package com.bumptech.glide.request;

import j5.a;
/* loaded from: classes.dex */
public interface RequestCoordinator {

    /* loaded from: classes.dex */
    public enum RequestState {
        RUNNING(false),
        PAUSED(false),
        CLEARED(false),
        SUCCESS(true),
        FAILED(true);
        
        private final boolean isComplete;

        RequestState(boolean z10) {
            this.isComplete = z10;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean a() {
            return this.isComplete;
        }
    }

    void a(a aVar);

    boolean c();

    boolean g(a aVar);

    boolean h(a aVar);

    boolean i(a aVar);

    void j(a aVar);
}
