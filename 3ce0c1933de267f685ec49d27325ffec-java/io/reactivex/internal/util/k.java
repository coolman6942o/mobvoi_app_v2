package io.reactivex.internal.util;

import co.f;
import co.g;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.r;
import vp.c;
import xn.b;
/* compiled from: QueueDrainHelper.java */
/* loaded from: classes3.dex */
public final class k {
    public static <T, U> boolean a(boolean z10, boolean z11, r<?> rVar, boolean z12, g<?> gVar, b bVar, h<T, U> hVar) {
        if (hVar.b()) {
            gVar.clear();
            bVar.dispose();
            return true;
        } else if (!z10) {
            return false;
        } else {
            if (!z12) {
                Throwable d10 = hVar.d();
                if (d10 != null) {
                    gVar.clear();
                    if (bVar != null) {
                        bVar.dispose();
                    }
                    rVar.onError(d10);
                    return true;
                } else if (!z11) {
                    return false;
                } else {
                    if (bVar != null) {
                        bVar.dispose();
                    }
                    rVar.onComplete();
                    return true;
                }
            } else if (!z11) {
                return false;
            } else {
                if (bVar != null) {
                    bVar.dispose();
                }
                Throwable d11 = hVar.d();
                if (d11 != null) {
                    rVar.onError(d11);
                } else {
                    rVar.onComplete();
                }
                return true;
            }
        }
    }

    public static <T> g<T> b(int i10) {
        if (i10 < 0) {
            return new io.reactivex.internal.queue.b(-i10);
        }
        return new SpscArrayQueue(i10);
    }

    public static <T, U> void c(f<T> fVar, r<? super U> rVar, boolean z10, b bVar, h<T, U> hVar) {
        int i10 = 1;
        while (!a(hVar.a(), fVar.isEmpty(), rVar, z10, fVar, bVar, hVar)) {
            while (true) {
                boolean a10 = hVar.a();
                T poll = fVar.poll();
                boolean z11 = poll == null;
                if (!a(a10, z11, rVar, z10, fVar, bVar, hVar)) {
                    if (z11) {
                        i10 = hVar.e(-i10);
                        if (i10 == 0) {
                            return;
                        }
                    } else {
                        hVar.c(rVar, poll);
                    }
                } else {
                    return;
                }
            }
        }
    }

    public static void d(c cVar, int i10) {
        cVar.request(i10 < 0 ? Long.MAX_VALUE : i10);
    }
}
