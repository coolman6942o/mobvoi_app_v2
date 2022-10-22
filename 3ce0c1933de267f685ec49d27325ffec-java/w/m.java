package w;

import androidx.constraintlayout.core.widgets.d;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RunGroup.java */
/* loaded from: classes.dex */
public class m {

    /* renamed from: c  reason: collision with root package name */
    public static int f35895c;

    /* renamed from: a  reason: collision with root package name */
    p f35896a;

    /* renamed from: b  reason: collision with root package name */
    ArrayList<p> f35897b = new ArrayList<>();

    public m(p pVar, int i10) {
        this.f35896a = null;
        f35895c++;
        this.f35896a = pVar;
    }

    private long c(f fVar, long j10) {
        p pVar = fVar.f35880d;
        if (pVar instanceof k) {
            return j10;
        }
        int size = fVar.f35887k.size();
        long j11 = j10;
        for (int i10 = 0; i10 < size; i10++) {
            d dVar = fVar.f35887k.get(i10);
            if (dVar instanceof f) {
                f fVar2 = (f) dVar;
                if (fVar2.f35880d != pVar) {
                    j11 = Math.min(j11, c(fVar2, fVar2.f35882f + j10));
                }
            }
        }
        if (fVar != pVar.f35915i) {
            return j11;
        }
        long j12 = j10 - pVar.j();
        return Math.min(Math.min(j11, c(pVar.f35914h, j12)), j12 - pVar.f35914h.f35882f);
    }

    private long d(f fVar, long j10) {
        p pVar = fVar.f35880d;
        if (pVar instanceof k) {
            return j10;
        }
        int size = fVar.f35887k.size();
        long j11 = j10;
        for (int i10 = 0; i10 < size; i10++) {
            d dVar = fVar.f35887k.get(i10);
            if (dVar instanceof f) {
                f fVar2 = (f) dVar;
                if (fVar2.f35880d != pVar) {
                    j11 = Math.max(j11, d(fVar2, fVar2.f35882f + j10));
                }
            }
        }
        if (fVar != pVar.f35914h) {
            return j11;
        }
        long j12 = j10 + pVar.j();
        return Math.max(Math.max(j11, d(pVar.f35915i, j12)), j12 - pVar.f35915i.f35882f);
    }

    public void a(p pVar) {
        this.f35897b.add(pVar);
    }

    public long b(d dVar, int i10) {
        int i11;
        long j10;
        p pVar;
        f fVar;
        f fVar2;
        p pVar2;
        p pVar3 = this.f35896a;
        long j11 = 0;
        if (pVar3 instanceof c) {
            if (((c) pVar3).f35912f != i10) {
                return 0L;
            }
        } else if (i10 == 0) {
            if (!(pVar3 instanceof l)) {
                return 0L;
            }
        } else if (!(pVar3 instanceof n)) {
            return 0L;
        }
        f fVar3 = (i10 == 0 ? dVar.f1591d : dVar.f1593e).f35914h;
        f fVar4 = (i10 == 0 ? dVar.f1591d : dVar.f1593e).f35915i;
        boolean contains = pVar3.f35914h.f35888l.contains(fVar3);
        boolean contains2 = this.f35896a.f35915i.f35888l.contains(fVar4);
        long j12 = this.f35896a.j();
        if (contains && contains2) {
            long d10 = d(this.f35896a.f35914h, 0L);
            long c10 = c(this.f35896a.f35915i, 0L);
            long j13 = d10 - j12;
            p pVar4 = this.f35896a;
            int i12 = pVar4.f35915i.f35882f;
            if (j13 >= (-i12)) {
                j13 += i12;
            }
            int i13 = pVar4.f35914h.f35882f;
            long j14 = ((-c10) - j12) - i13;
            if (j14 >= i13) {
                j14 -= i13;
            }
            float o10 = pVar4.f35908b.o(i10);
            if (o10 > 0.0f) {
                j11 = (((float) j14) / o10) + (((float) j13) / (1.0f - o10));
            }
            float f10 = (float) j11;
            long j15 = (f10 * o10) + 0.5f + j12 + (f10 * (1.0f - o10)) + 0.5f;
            j10 = pVar2.f35914h.f35882f + j15;
            i11 = this.f35896a.f35915i.f35882f;
        } else if (contains) {
            return Math.max(d(this.f35896a.f35914h, fVar2.f35882f), this.f35896a.f35914h.f35882f + j12);
        } else if (contains2) {
            return Math.max(-c(this.f35896a.f35915i, fVar.f35882f), (-this.f35896a.f35915i.f35882f) + j12);
        } else {
            j10 = pVar.f35914h.f35882f + this.f35896a.j();
            i11 = this.f35896a.f35915i.f35882f;
        }
        return j10 - i11;
    }
}
