package androidx.core.view;

import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
/* compiled from: ViewParentCompat.java */
/* loaded from: classes.dex */
public final class h0 {
    public static boolean a(ViewParent viewParent, View view, float f10, float f11, boolean z10) {
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                return viewParent.onNestedFling(view, f10, f11, z10);
            } catch (AbstractMethodError e10) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedFling", e10);
                return false;
            }
        } else if (viewParent instanceof t) {
            return ((t) viewParent).onNestedFling(view, f10, f11, z10);
        } else {
            return false;
        }
    }

    public static boolean b(ViewParent viewParent, View view, float f10, float f11) {
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                return viewParent.onNestedPreFling(view, f10, f11);
            } catch (AbstractMethodError e10) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedPreFling", e10);
                return false;
            }
        } else if (viewParent instanceof t) {
            return ((t) viewParent).onNestedPreFling(view, f10, f11);
        } else {
            return false;
        }
    }

    public static void c(ViewParent viewParent, View view, int i10, int i11, int[] iArr, int i12) {
        if (viewParent instanceof r) {
            ((r) viewParent).o(view, i10, i11, iArr, i12);
        } else if (i12 != 0) {
        } else {
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    viewParent.onNestedPreScroll(view, i10, i11, iArr);
                } catch (AbstractMethodError e10) {
                    Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedPreScroll", e10);
                }
            } else if (viewParent instanceof t) {
                ((t) viewParent).onNestedPreScroll(view, i10, i11, iArr);
            }
        }
    }

    public static void d(ViewParent viewParent, View view, int i10, int i11, int i12, int i13, int i14, int[] iArr) {
        if (viewParent instanceof s) {
            ((s) viewParent).j(view, i10, i11, i12, i13, i14, iArr);
            return;
        }
        iArr[0] = iArr[0] + i12;
        iArr[1] = iArr[1] + i13;
        if (viewParent instanceof r) {
            ((r) viewParent).k(view, i10, i11, i12, i13, i14);
        } else if (i14 != 0) {
        } else {
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    viewParent.onNestedScroll(view, i10, i11, i12, i13);
                } catch (AbstractMethodError e10) {
                    Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedScroll", e10);
                }
            } else if (viewParent instanceof t) {
                ((t) viewParent).onNestedScroll(view, i10, i11, i12, i13);
            }
        }
    }

    public static void e(ViewParent viewParent, View view, View view2, int i10, int i11) {
        if (viewParent instanceof r) {
            ((r) viewParent).m(view, view2, i10, i11);
        } else if (i11 != 0) {
        } else {
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    viewParent.onNestedScrollAccepted(view, view2, i10);
                } catch (AbstractMethodError e10) {
                    Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedScrollAccepted", e10);
                }
            } else if (viewParent instanceof t) {
                ((t) viewParent).onNestedScrollAccepted(view, view2, i10);
            }
        }
    }

    public static boolean f(ViewParent viewParent, View view, View view2, int i10, int i11) {
        if (viewParent instanceof r) {
            return ((r) viewParent).l(view, view2, i10, i11);
        }
        if (i11 != 0) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                return viewParent.onStartNestedScroll(view, view2, i10);
            } catch (AbstractMethodError e10) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onStartNestedScroll", e10);
                return false;
            }
        } else if (viewParent instanceof t) {
            return ((t) viewParent).onStartNestedScroll(view, view2, i10);
        } else {
            return false;
        }
    }

    public static void g(ViewParent viewParent, View view, int i10) {
        if (viewParent instanceof r) {
            ((r) viewParent).n(view, i10);
        } else if (i10 != 0) {
        } else {
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    viewParent.onStopNestedScroll(view);
                } catch (AbstractMethodError e10) {
                    Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onStopNestedScroll", e10);
                }
            } else if (viewParent instanceof t) {
                ((t) viewParent).onStopNestedScroll(view);
            }
        }
    }
}
