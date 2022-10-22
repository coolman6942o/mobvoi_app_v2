package wm;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.constant.RefreshState;
import sm.a;
import sm.c;
import sm.d;
import sm.e;
import sm.f;
/* compiled from: SimpleComponent.java */
/* loaded from: classes2.dex */
public abstract class b extends RelativeLayout implements a {

    /* renamed from: a  reason: collision with root package name */
    protected View f36330a;

    /* renamed from: b  reason: collision with root package name */
    protected tm.b f36331b;

    /* renamed from: c  reason: collision with root package name */
    protected a f36332c;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(View view) {
        this(view, view instanceof a ? (a) view : null);
    }

    public void a(e eVar, int i10, int i11) {
        a aVar = this.f36332c;
        if (aVar == null || aVar == this) {
            View view = this.f36330a;
            if (view != null) {
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams instanceof SmartRefreshLayout.k) {
                    eVar.a(this, ((SmartRefreshLayout.k) layoutParams).f22404a);
                    return;
                }
                return;
            }
            return;
        }
        aVar.a(eVar, i10, i11);
    }

    @SuppressLint({"RestrictedApi"})
    public boolean c(boolean z10) {
        a aVar = this.f36332c;
        return (aVar instanceof c) && ((c) aVar).c(z10);
    }

    @Override // sm.a
    public void d(float f10, int i10, int i11) {
        a aVar = this.f36332c;
        if (aVar != null && aVar != this) {
            aVar.d(f10, i10, i11);
        }
    }

    @Override // sm.a
    public boolean e() {
        a aVar = this.f36332c;
        return (aVar == null || aVar == this || !aVar.e()) ? false : true;
    }

    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return (obj instanceof a) && getView() == ((a) obj).getView();
        }
        return true;
    }

    @Override // sm.a
    public tm.b getSpinnerStyle() {
        int i10;
        tm.b[] bVarArr;
        tm.b bVar = this.f36331b;
        if (bVar != null) {
            return bVar;
        }
        a aVar = this.f36332c;
        if (!(aVar == null || aVar == this)) {
            return aVar.getSpinnerStyle();
        }
        View view = this.f36330a;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof SmartRefreshLayout.k) {
                tm.b bVar2 = ((SmartRefreshLayout.k) layoutParams).f22405b;
                this.f36331b = bVar2;
                if (bVar2 != null) {
                    return bVar2;
                }
            }
            if (layoutParams != null && ((i10 = layoutParams.height) == 0 || i10 == -1)) {
                for (tm.b bVar3 : tm.b.f35229i) {
                    if (bVar3.f35232c) {
                        this.f36331b = bVar3;
                        return bVar3;
                    }
                }
            }
        }
        tm.b bVar4 = tm.b.f35224d;
        this.f36331b = bVar4;
        return bVar4;
    }

    @Override // sm.a
    public View getView() {
        View view = this.f36330a;
        return view == null ? this : view;
    }

    public int h(f fVar, boolean z10) {
        a aVar = this.f36332c;
        if (aVar == null || aVar == this) {
            return 0;
        }
        return aVar.h(fVar, z10);
    }

    public void j(f fVar, int i10, int i11) {
        a aVar = this.f36332c;
        if (aVar != null && aVar != this) {
            aVar.j(fVar, i10, i11);
        }
    }

    @Override // sm.a
    public void m(boolean z10, float f10, int i10, int i11, int i12) {
        a aVar = this.f36332c;
        if (aVar != null && aVar != this) {
            aVar.m(z10, f10, i10, i11, i12);
        }
    }

    public void n(f fVar, int i10, int i11) {
        a aVar = this.f36332c;
        if (aVar != null && aVar != this) {
            aVar.n(fVar, i10, i11);
        }
    }

    public void q(f fVar, RefreshState refreshState, RefreshState refreshState2) {
        a aVar = this.f36332c;
        if (aVar != null && aVar != this) {
            if ((this instanceof c) && (aVar instanceof d)) {
                if (refreshState.isFooter) {
                    refreshState = refreshState.toHeader();
                }
                if (refreshState2.isFooter) {
                    refreshState2 = refreshState2.toHeader();
                }
            } else if ((this instanceof d) && (aVar instanceof c)) {
                if (refreshState.isHeader) {
                    refreshState = refreshState.toFooter();
                }
                if (refreshState2.isHeader) {
                    refreshState2 = refreshState2.toFooter();
                }
            }
            a aVar2 = this.f36332c;
            if (aVar2 != null) {
                aVar2.q(fVar, refreshState, refreshState2);
            }
        }
    }

    public void setPrimaryColors(int... iArr) {
        a aVar = this.f36332c;
        if (aVar != null && aVar != this) {
            aVar.setPrimaryColors(iArr);
        }
    }

    protected b(View view, a aVar) {
        super(view.getContext(), null, 0);
        this.f36330a = view;
        this.f36332c = aVar;
        if ((this instanceof c) && (aVar instanceof d) && aVar.getSpinnerStyle() == tm.b.f35228h) {
            aVar.getView().setScaleY(-1.0f);
        } else if (this instanceof d) {
            a aVar2 = this.f36332c;
            if ((aVar2 instanceof c) && aVar2.getSpinnerStyle() == tm.b.f35228h) {
                aVar.getView().setScaleY(-1.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public b(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
