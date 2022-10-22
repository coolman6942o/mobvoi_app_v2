package n1;

import android.animation.LayoutTransition;
import android.util.Log;
import android.view.ViewGroup;
import com.unionpay.tsmservice.data.Constant;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* compiled from: ViewGroupUtilsApi14.java */
/* loaded from: classes.dex */
class y {

    /* renamed from: a  reason: collision with root package name */
    private static LayoutTransition f30995a;

    /* renamed from: b  reason: collision with root package name */
    private static Field f30996b;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f30997c;

    /* renamed from: d  reason: collision with root package name */
    private static Method f30998d;

    /* renamed from: e  reason: collision with root package name */
    private static boolean f30999e;

    /* compiled from: ViewGroupUtilsApi14.java */
    /* loaded from: classes.dex */
    static class a extends LayoutTransition {
        a() {
        }

        @Override // android.animation.LayoutTransition
        public boolean isChangingLayout() {
            return true;
        }
    }

    private static void a(LayoutTransition layoutTransition) {
        if (!f30999e) {
            try {
                Method declaredMethod = LayoutTransition.class.getDeclaredMethod(Constant.CASH_LOAD_CANCEL, new Class[0]);
                f30998d = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
                Log.i("ViewGroupUtilsApi14", "Failed to access cancel method by reflection");
            }
            f30999e = true;
        }
        Method method = f30998d;
        if (method != null) {
            try {
                method.invoke(layoutTransition, new Object[0]);
            } catch (IllegalAccessException unused2) {
                Log.i("ViewGroupUtilsApi14", "Failed to access cancel method by reflection");
            } catch (InvocationTargetException unused3) {
                Log.i("ViewGroupUtilsApi14", "Failed to invoke cancel method by reflection");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void b(ViewGroup viewGroup, boolean z10) {
        LayoutTransition layoutTransition;
        boolean z11 = false;
        if (f30995a == null) {
            a aVar = new a();
            f30995a = aVar;
            aVar.setAnimator(2, null);
            f30995a.setAnimator(0, null);
            f30995a.setAnimator(1, null);
            f30995a.setAnimator(3, null);
            f30995a.setAnimator(4, null);
        }
        if (z10) {
            LayoutTransition layoutTransition2 = viewGroup.getLayoutTransition();
            if (layoutTransition2 != null) {
                if (layoutTransition2.isRunning()) {
                    a(layoutTransition2);
                }
                if (layoutTransition2 != f30995a) {
                    viewGroup.setTag(j.f30918d, layoutTransition2);
                }
            }
            viewGroup.setLayoutTransition(f30995a);
            return;
        }
        viewGroup.setLayoutTransition(null);
        if (!f30997c) {
            try {
                Field declaredField = ViewGroup.class.getDeclaredField("mLayoutSuppressed");
                f30996b = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                Log.i("ViewGroupUtilsApi14", "Failed to access mLayoutSuppressed field by reflection");
            }
            f30997c = true;
        }
        Field field = f30996b;
        if (field != null) {
            try {
                boolean z12 = field.getBoolean(viewGroup);
                if (z12) {
                    try {
                        f30996b.setBoolean(viewGroup, false);
                    } catch (IllegalAccessException unused2) {
                        z11 = z12;
                        Log.i("ViewGroupUtilsApi14", "Failed to get mLayoutSuppressed field by reflection");
                        if (z11) {
                        }
                        int i10 = j.f30918d;
                        layoutTransition = (LayoutTransition) viewGroup.getTag(i10);
                        if (layoutTransition == null) {
                        }
                    }
                }
                z11 = z12;
            } catch (IllegalAccessException unused3) {
            }
        }
        if (z11) {
            viewGroup.requestLayout();
        }
        int i102 = j.f30918d;
        layoutTransition = (LayoutTransition) viewGroup.getTag(i102);
        if (layoutTransition == null) {
            viewGroup.setTag(i102, null);
            viewGroup.setLayoutTransition(layoutTransition);
        }
    }
}
