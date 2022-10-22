package sk;

import android.content.Context;
import android.os.RemoteException;
import android.telephony.TelephonyManager;
import com.android.internal.telephony.ITelephony;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.wear.info.SharedWearInfoHelper;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* compiled from: SupportTelephonyInterface.java */
/* loaded from: classes2.dex */
public class c implements d {

    /* renamed from: a  reason: collision with root package name */
    private TelephonyManager f35022a;

    public c(Context context) {
        this.f35022a = (TelephonyManager) context.getSystemService(SharedWearInfoHelper.PhoneInfo.TABLE);
        context.getApplicationContext();
    }

    @Override // sk.d
    public boolean endCall() {
        boolean z10 = false;
        try {
            Method declaredMethod = Class.forName(this.f35022a.getClass().getName()).getDeclaredMethod("getITelephony", new Class[0]);
            declaredMethod.setAccessible(true);
            z10 = ((ITelephony) declaredMethod.invoke(this.f35022a, new Object[0])).endCall();
        } catch (RemoteException e10) {
            k.e("SupportTelephony", "Failed to end call", e10);
        } catch (ClassNotFoundException e11) {
            k.e("SupportTelephony", "Failed to end call", e11);
        } catch (IllegalAccessException e12) {
            k.e("SupportTelephony", "Failed to end call", e12);
        } catch (NoSuchMethodException e13) {
            k.e("SupportTelephony", "Failed to end call", e13);
            try {
                Method declaredMethod2 = Class.forName(this.f35022a.getClass().getName()).getDeclaredMethod("endCall", new Class[0]);
                declaredMethod2.setAccessible(true);
                declaredMethod2.invoke(this.f35022a, new Object[0]);
            } catch (Exception e14) {
                e14.printStackTrace();
            }
        } catch (InvocationTargetException e15) {
            k.e("SupportTelephony", "Failed to end call", e15);
        }
        k.a("SupportTelephony", "endCall flag = " + z10);
        return z10;
    }
}
