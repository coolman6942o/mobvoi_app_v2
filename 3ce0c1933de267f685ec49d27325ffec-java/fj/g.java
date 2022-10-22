package fj;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.f;
import com.mobvoi.android.common.utils.l;
import java.util.ArrayList;
import java.util.List;
import rx.c;
import rx.subjects.b;
import rx.subjects.d;
/* compiled from: RequestPermissionFragment.java */
/* loaded from: classes2.dex */
public class g extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    private String[] f27053a;

    /* renamed from: b  reason: collision with root package name */
    private d<List<e>, List<e>> f27054b = null;

    /* renamed from: c  reason: collision with root package name */
    private boolean f27055c = false;

    public static g Z(f fVar) {
        g gVar = (g) fVar.getSupportFragmentManager().g0("PermissionFragment");
        if (gVar != null) {
            return gVar;
        }
        g gVar2 = new g();
        fVar.getSupportFragmentManager().l().e(gVar2, "PermissionFragment").k();
        return gVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a0(String[] strArr) {
        this.f27055c = false;
        if (isAdded()) {
            requestPermissions(strArr, 10);
            this.f27055c = true;
        }
    }

    private void b0(long j10, final String... strArr) {
        l.a().postDelayed(new Runnable() { // from class: fj.f
            @Override // java.lang.Runnable
            public final void run() {
                g.this.a0(strArr);
            }
        }, j10);
    }

    public c<List<e>> c0(String... strArr) {
        this.f27053a = strArr;
        this.f27054b = b.o0();
        b0(10L, this.f27053a);
        return this.f27054b;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        String[] strArr = this.f27053a;
        if (strArr != null && !this.f27055c) {
            b0(0L, strArr);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        int length;
        super.onRequestPermissionsResult(i10, strArr, iArr);
        if (i10 == 10 && (length = strArr.length) != 0) {
            ArrayList arrayList = new ArrayList();
            for (int i11 = 0; i11 < length; i11++) {
                arrayList.add(new e(strArr[i11], iArr[i11] == 0));
            }
            d<List<e>, List<e>> dVar = this.f27054b;
            if (dVar != null) {
                dVar.onNext(arrayList);
                this.f27054b.onCompleted();
            }
        }
    }
}
