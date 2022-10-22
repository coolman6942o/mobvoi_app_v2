package rx.internal.util.unsafe;
/* compiled from: SpscArrayQueue.java */
/* loaded from: classes3.dex */
abstract class s<E> extends f<E> {

    /* renamed from: f  reason: collision with root package name */
    private static final Integer f34174f = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);

    public s(int i10) {
        super(i10);
        Math.min(i10 / 4, f34174f.intValue());
    }
}
