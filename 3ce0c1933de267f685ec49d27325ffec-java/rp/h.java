package rp;

import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.i;
import okio.Segment;
/* compiled from: SegmentPool.kt */
/* loaded from: classes3.dex */
public final class h {

    /* renamed from: c  reason: collision with root package name */
    private static final int f33672c;

    /* renamed from: d  reason: collision with root package name */
    private static final AtomicReference<Segment>[] f33673d;

    /* renamed from: e  reason: collision with root package name */
    public static final h f33674e = new h();

    /* renamed from: a  reason: collision with root package name */
    private static final int f33670a = WXMediaMessage.THUMB_LENGTH_LIMIT;

    /* renamed from: b  reason: collision with root package name */
    private static final g f33671b = new g(new byte[0], 0, 0, false, false);

    static {
        int highestOneBit = Integer.highestOneBit((Runtime.getRuntime().availableProcessors() * 2) - 1);
        f33672c = highestOneBit;
        AtomicReference<Segment>[] atomicReferenceArr = new AtomicReference[highestOneBit];
        for (int i10 = 0; i10 < highestOneBit; i10++) {
            atomicReferenceArr[i10] = new AtomicReference<>();
        }
        f33673d = atomicReferenceArr;
    }

    private h() {
    }

    private final AtomicReference<g> a() {
        Thread currentThread = Thread.currentThread();
        i.e(currentThread, "Thread.currentThread()");
        return f33673d[(int) (currentThread.getId() & (f33672c - 1))];
    }

    public static final void b(g segment) {
        AtomicReference<g> a10;
        g gVar;
        i.f(segment, "segment");
        if (!(segment.f33668f == null && segment.f33669g == null)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        } else if (!segment.f33666d && (gVar = (a10 = f33674e.a()).get()) != f33671b) {
            int i10 = gVar != null ? gVar.f33665c : 0;
            if (i10 < f33670a) {
                segment.f33668f = gVar;
                segment.f33664b = 0;
                segment.f33665c = i10 + 8192;
                if (!a10.compareAndSet(gVar, segment)) {
                    segment.f33668f = null;
                }
            }
        }
    }

    public static final g c() {
        AtomicReference<g> a10 = f33674e.a();
        g gVar = f33671b;
        g andSet = a10.getAndSet(gVar);
        if (andSet == gVar) {
            return new g();
        }
        if (andSet == null) {
            a10.set(null);
            return new g();
        }
        a10.set(andSet.f33668f);
        andSet.f33668f = null;
        andSet.f33665c = 0;
        return andSet;
    }
}
