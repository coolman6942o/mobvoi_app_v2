package s;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
/* compiled from: KeyCycleOscillator.java */
/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a  reason: collision with root package name */
    private a f34205a;

    /* renamed from: b  reason: collision with root package name */
    private String f34206b;

    /* renamed from: c  reason: collision with root package name */
    private int f34207c = 0;

    /* renamed from: d  reason: collision with root package name */
    private String f34208d = null;

    /* renamed from: e  reason: collision with root package name */
    public int f34209e = 0;

    /* renamed from: f  reason: collision with root package name */
    ArrayList<b> f34210f = new ArrayList<>();

    /* compiled from: KeyCycleOscillator.java */
    /* loaded from: classes.dex */
    static class a {
        public double a(float f10) {
            throw null;
        }
    }

    /* compiled from: KeyCycleOscillator.java */
    /* loaded from: classes.dex */
    static class b {

        /* renamed from: a  reason: collision with root package name */
        int f34211a;

        /* renamed from: b  reason: collision with root package name */
        float f34212b;
    }

    public float a(float f10) {
        return (float) this.f34205a.a(f10);
    }

    public String toString() {
        String str = this.f34206b;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        Iterator<b> it = this.f34210f.iterator();
        while (it.hasNext()) {
            b next = it.next();
            str = str + "[" + next.f34211a + " , " + decimalFormat.format(next.f34212b) + "] ";
        }
        return str;
    }
}
