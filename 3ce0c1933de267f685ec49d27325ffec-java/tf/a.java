package tf;

import eg.j;
import java.util.LinkedList;
import java.util.Queue;
/* compiled from: TimeMovingAverageFilter.java */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private final double f35145a;

    /* renamed from: b  reason: collision with root package name */
    private final Queue<b> f35146b;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TimeMovingAverageFilter.java */
    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        final double f35147a;

        /* renamed from: b  reason: collision with root package name */
        final double f35148b;

        private b(double d10, double d11) {
            this.f35147a = d10;
            this.f35148b = d11;
        }
    }

    public a(double d10) {
        if (d10 >= 0.0d) {
            this.f35145a = d10;
            this.f35146b = new LinkedList();
            b();
            return;
        }
        throw new IllegalArgumentException("Window time can NOT be negative");
    }

    public double a(double d10, double d11) {
        this.f35146b.offer(new b(d10, d11));
        while (d10 - this.f35146b.peek().f35147a > this.f35145a) {
            this.f35146b.poll();
        }
        double[] dArr = new double[this.f35146b.size()];
        int i10 = 0;
        for (b bVar : this.f35146b) {
            i10++;
            dArr[i10] = bVar.f35148b;
        }
        return new j(dArr).a();
    }

    public void b() {
        this.f35146b.clear();
    }
}
