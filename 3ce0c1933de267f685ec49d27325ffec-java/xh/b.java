package xh;

import android.app.Application;
import android.graphics.drawable.StateListDrawable;
import kotlin.jvm.internal.i;
/* compiled from: BadgeFactory.kt */
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f36555a = new b();

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f36556b = {-16842913};

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f36557c = {16842913};

    private b() {
    }

    public final StateListDrawable a(String number) {
        i.f(number, "number");
        StateListDrawable stateListDrawable = new StateListDrawable();
        int[] iArr = f36556b;
        Application e10 = com.mobvoi.android.common.utils.b.e();
        i.e(e10, "getApplication()");
        stateListDrawable.addState(iArr, new c(e10, number));
        int[] iArr2 = f36557c;
        Application e11 = com.mobvoi.android.common.utils.b.e();
        i.e(e11, "getApplication()");
        stateListDrawable.addState(iArr2, new a(e11, number, false, 4, null));
        return stateListDrawable;
    }

    public final StateListDrawable b(String number) {
        i.f(number, "number");
        StateListDrawable stateListDrawable = new StateListDrawable();
        int[] iArr = f36556b;
        Application e10 = com.mobvoi.android.common.utils.b.e();
        i.e(e10, "getApplication()");
        stateListDrawable.addState(iArr, new c(e10, number));
        int[] iArr2 = f36557c;
        Application e11 = com.mobvoi.android.common.utils.b.e();
        i.e(e11, "getApplication()");
        stateListDrawable.addState(iArr2, new d(e11, number, false, 4, null));
        return stateListDrawable;
    }
}
