package d3;

import android.annotation.TargetApi;
import android.graphics.Path;
import android.os.Build;
import com.airbnb.lottie.model.content.MergePaths;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
/* compiled from: MergePathsContent.java */
@TargetApi(19)
/* loaded from: classes.dex */
public class l implements m, j {

    /* renamed from: a  reason: collision with root package name */
    private final Path f25074a = new Path();

    /* renamed from: b  reason: collision with root package name */
    private final Path f25075b = new Path();

    /* renamed from: c  reason: collision with root package name */
    private final Path f25076c = new Path();

    /* renamed from: d  reason: collision with root package name */
    private final List<m> f25077d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    private final MergePaths f25078e;

    /* compiled from: MergePathsContent.java */
    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f25079a;

        static {
            int[] iArr = new int[MergePaths.MergePathsMode.values().length];
            f25079a = iArr;
            try {
                iArr[MergePaths.MergePathsMode.MERGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f25079a[MergePaths.MergePathsMode.ADD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f25079a[MergePaths.MergePathsMode.SUBTRACT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f25079a[MergePaths.MergePathsMode.INTERSECT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f25079a[MergePaths.MergePathsMode.EXCLUDE_INTERSECTIONS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public l(MergePaths mergePaths) {
        if (Build.VERSION.SDK_INT >= 19) {
            mergePaths.c();
            this.f25078e = mergePaths;
            return;
        }
        throw new IllegalStateException("Merge paths are not supported pre-KitKat.");
    }

    private void b() {
        for (int i10 = 0; i10 < this.f25077d.size(); i10++) {
            this.f25076c.addPath(this.f25077d.get(i10).a());
        }
    }

    @TargetApi(19)
    private void d(Path.Op op2) {
        this.f25075b.reset();
        this.f25074a.reset();
        for (int size = this.f25077d.size() - 1; size >= 1; size--) {
            m mVar = this.f25077d.get(size);
            if (mVar instanceof d) {
                d dVar = (d) mVar;
                List<m> j10 = dVar.j();
                for (int size2 = j10.size() - 1; size2 >= 0; size2--) {
                    Path a10 = j10.get(size2).a();
                    a10.transform(dVar.k());
                    this.f25075b.addPath(a10);
                }
            } else {
                this.f25075b.addPath(mVar.a());
            }
        }
        m mVar2 = this.f25077d.get(0);
        if (mVar2 instanceof d) {
            d dVar2 = (d) mVar2;
            List<m> j11 = dVar2.j();
            for (int i10 = 0; i10 < j11.size(); i10++) {
                Path a11 = j11.get(i10).a();
                a11.transform(dVar2.k());
                this.f25074a.addPath(a11);
            }
        } else {
            this.f25074a.set(mVar2.a());
        }
        this.f25076c.op(this.f25074a, this.f25075b, op2);
    }

    @Override // d3.m
    public Path a() {
        this.f25076c.reset();
        if (this.f25078e.d()) {
            return this.f25076c;
        }
        int i10 = a.f25079a[this.f25078e.b().ordinal()];
        if (i10 == 1) {
            b();
        } else if (i10 == 2) {
            d(Path.Op.UNION);
        } else if (i10 == 3) {
            d(Path.Op.REVERSE_DIFFERENCE);
        } else if (i10 == 4) {
            d(Path.Op.INTERSECT);
        } else if (i10 == 5) {
            d(Path.Op.XOR);
        }
        return this.f25076c;
    }

    @Override // d3.c
    public void c(List<c> list, List<c> list2) {
        for (int i10 = 0; i10 < this.f25077d.size(); i10++) {
            this.f25077d.get(i10).c(list, list2);
        }
    }

    @Override // d3.j
    public void f(ListIterator<c> listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        while (listIterator.hasPrevious()) {
            c previous = listIterator.previous();
            if (previous instanceof m) {
                this.f25077d.add((m) previous);
                listIterator.remove();
            }
        }
    }
}
