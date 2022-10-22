package com.mobvoi.wear.frameanimation.io;

import io.m;
import kotlin.jvm.internal.Lambda;
import qo.a;
/* compiled from: BitmapPoolImpl.kt */
/* loaded from: classes2.dex */
final class BitmapPoolImpl$start$1 extends Lambda implements a<m> {
    final /* synthetic */ BitmapPoolImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BitmapPoolImpl$start$1(BitmapPoolImpl bitmapPoolImpl) {
        super(0);
        this.this$0 = bitmapPoolImpl;
    }

    @Override // qo.a
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        int i10;
        while (true) {
            try {
                i10 = this.this$0.state;
                if (i10 != 2 || Thread.currentThread().isInterrupted()) {
                    break;
                }
                this.this$0.decodeBitmap();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
        this.this$0.clearAndStop();
    }
}
