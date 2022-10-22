package n1;

import android.animation.TimeInterpolator;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;
import n1.m;
/* compiled from: TransitionSet.java */
/* loaded from: classes.dex */
public class q extends m {
    int L;
    private ArrayList<m> J = new ArrayList<>();
    private boolean K = true;
    boolean M = false;
    private int N = 0;

    /* compiled from: TransitionSet.java */
    /* loaded from: classes.dex */
    class a extends n {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ m f30981a;

        a(q qVar, m mVar) {
            this.f30981a = mVar;
        }

        @Override // n1.m.f
        public void b(m mVar) {
            this.f30981a.T();
            mVar.P(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TransitionSet.java */
    /* loaded from: classes.dex */
    public static class b extends n {

        /* renamed from: a  reason: collision with root package name */
        q f30982a;

        b(q qVar) {
            this.f30982a = qVar;
        }

        @Override // n1.n, n1.m.f
        public void a(m mVar) {
            q qVar = this.f30982a;
            if (!qVar.M) {
                qVar.a0();
                this.f30982a.M = true;
            }
        }

        @Override // n1.m.f
        public void b(m mVar) {
            q qVar = this.f30982a;
            int i10 = qVar.L - 1;
            qVar.L = i10;
            if (i10 == 0) {
                qVar.M = false;
                qVar.p();
            }
            mVar.P(this);
        }
    }

    private void f0(m mVar) {
        this.J.add(mVar);
        mVar.f30957r = this;
    }

    private void o0() {
        b bVar = new b(this);
        Iterator<m> it = this.J.iterator();
        while (it.hasNext()) {
            it.next().a(bVar);
        }
        this.L = this.J.size();
    }

    @Override // n1.m
    public void N(View view) {
        super.N(view);
        int size = this.J.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.J.get(i10).N(view);
        }
    }

    @Override // n1.m
    public void R(View view) {
        super.R(view);
        int size = this.J.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.J.get(i10).R(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // n1.m
    public void T() {
        if (this.J.isEmpty()) {
            a0();
            p();
            return;
        }
        o0();
        if (!this.K) {
            for (int i10 = 1; i10 < this.J.size(); i10++) {
                this.J.get(i10 - 1).a(new a(this, this.J.get(i10)));
            }
            m mVar = this.J.get(0);
            if (mVar != null) {
                mVar.T();
                return;
            }
            return;
        }
        Iterator<m> it = this.J.iterator();
        while (it.hasNext()) {
            it.next().T();
        }
    }

    @Override // n1.m
    public void V(m.e eVar) {
        super.V(eVar);
        this.N |= 8;
        int size = this.J.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.J.get(i10).V(eVar);
        }
    }

    @Override // n1.m
    public void X(g gVar) {
        super.X(gVar);
        this.N |= 4;
        if (this.J != null) {
            for (int i10 = 0; i10 < this.J.size(); i10++) {
                this.J.get(i10).X(gVar);
            }
        }
    }

    @Override // n1.m
    public void Y(p pVar) {
        super.Y(pVar);
        this.N |= 2;
        int size = this.J.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.J.get(i10).Y(pVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // n1.m
    public String b0(String str) {
        String b02 = super.b0(str);
        for (int i10 = 0; i10 < this.J.size(); i10++) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(b02);
            sb2.append("\n");
            sb2.append(this.J.get(i10).b0(str + "  "));
            b02 = sb2.toString();
        }
        return b02;
    }

    /* renamed from: c0 */
    public q a(m.f fVar) {
        return (q) super.a(fVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // n1.m
    public void cancel() {
        super.cancel();
        int size = this.J.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.J.get(i10).cancel();
        }
    }

    /* renamed from: d0 */
    public q b(View view) {
        for (int i10 = 0; i10 < this.J.size(); i10++) {
            this.J.get(i10).b(view);
        }
        return (q) super.b(view);
    }

    public q e0(m mVar) {
        f0(mVar);
        long j10 = this.f30942c;
        if (j10 >= 0) {
            mVar.U(j10);
        }
        if ((this.N & 1) != 0) {
            mVar.W(s());
        }
        if ((this.N & 2) != 0) {
            mVar.Y(w());
        }
        if ((this.N & 4) != 0) {
            mVar.X(v());
        }
        if ((this.N & 8) != 0) {
            mVar.V(r());
        }
        return this;
    }

    @Override // n1.m
    public void f(s sVar) {
        if (G(sVar.f30987b)) {
            Iterator<m> it = this.J.iterator();
            while (it.hasNext()) {
                m next = it.next();
                if (next.G(sVar.f30987b)) {
                    next.f(sVar);
                    sVar.f30988c.add(next);
                }
            }
        }
    }

    public m g0(int i10) {
        if (i10 < 0 || i10 >= this.J.size()) {
            return null;
        }
        return this.J.get(i10);
    }

    public int h0() {
        return this.J.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // n1.m
    public void i(s sVar) {
        super.i(sVar);
        int size = this.J.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.J.get(i10).i(sVar);
        }
    }

    /* renamed from: i0 */
    public q P(m.f fVar) {
        return (q) super.P(fVar);
    }

    @Override // n1.m
    public void j(s sVar) {
        if (G(sVar.f30987b)) {
            Iterator<m> it = this.J.iterator();
            while (it.hasNext()) {
                m next = it.next();
                if (next.G(sVar.f30987b)) {
                    next.j(sVar);
                    sVar.f30988c.add(next);
                }
            }
        }
    }

    /* renamed from: j0 */
    public q Q(View view) {
        for (int i10 = 0; i10 < this.J.size(); i10++) {
            this.J.get(i10).Q(view);
        }
        return (q) super.Q(view);
    }

    /* renamed from: k0 */
    public q U(long j10) {
        ArrayList<m> arrayList;
        super.U(j10);
        if (this.f30942c >= 0 && (arrayList = this.J) != null) {
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.J.get(i10).U(j10);
            }
        }
        return this;
    }

    /* renamed from: l0 */
    public q W(TimeInterpolator timeInterpolator) {
        this.N |= 1;
        ArrayList<m> arrayList = this.J;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.J.get(i10).W(timeInterpolator);
            }
        }
        return (q) super.W(timeInterpolator);
    }

    @Override // n1.m
    /* renamed from: m */
    public m clone() {
        q qVar = (q) super.clone();
        qVar.J = new ArrayList<>();
        int size = this.J.size();
        for (int i10 = 0; i10 < size; i10++) {
            qVar.f0(this.J.get(i10).clone());
        }
        return qVar;
    }

    public q m0(int i10) {
        if (i10 == 0) {
            this.K = true;
        } else if (i10 == 1) {
            this.K = false;
        } else {
            throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + i10);
        }
        return this;
    }

    /* renamed from: n0 */
    public q Z(long j10) {
        return (q) super.Z(j10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // n1.m
    public void o(ViewGroup viewGroup, t tVar, t tVar2, ArrayList<s> arrayList, ArrayList<s> arrayList2) {
        long y10 = y();
        int size = this.J.size();
        for (int i10 = 0; i10 < size; i10++) {
            m mVar = this.J.get(i10);
            if (y10 > 0 && (this.K || i10 == 0)) {
                long y11 = mVar.y();
                if (y11 > 0) {
                    mVar.Z(y11 + y10);
                } else {
                    mVar.Z(y10);
                }
            }
            mVar.o(viewGroup, tVar, tVar2, arrayList, arrayList2);
        }
    }
}
