package dl;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import fl.a;
import il.b;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes2.dex */
public class d {
    public static boolean a(BluetoothProfile bluetoothProfile, String str, BluetoothDevice bluetoothDevice) {
        String str2;
        StringBuilder sb2;
        String invocationTargetException;
        if (bluetoothProfile == null || bluetoothDevice == null) {
            return false;
        }
        try {
            b.j("connectProfile :" + a.c(bluetoothDevice.getAddress(), true));
            Class<? extends U> asSubclass = bluetoothProfile.getClass().asSubclass(Class.forName(str));
            if (asSubclass == 0) {
                b.l("no class found: " + str);
                return false;
            }
            Method method = asSubclass.getMethod("connect", BluetoothDevice.class);
            method.setAccessible(true);
            return ((Boolean) method.invoke(bluetoothProfile, bluetoothDevice)).booleanValue();
        } catch (ClassNotFoundException e10) {
            sb2 = new StringBuilder();
            sb2.append("Could not find clas: ");
            sb2.append(str);
            sb2.append(", ignoring request.");
            invocationTargetException = e10.toString();
            sb2.append(invocationTargetException);
            str2 = sb2.toString();
            b.l(str2);
            return false;
        } catch (IllegalAccessException e11) {
            sb2 = new StringBuilder();
            sb2.append("Could not execute method 'connect' in profile ");
            sb2.append(str);
            sb2.append(", ignoring request.");
            invocationTargetException = e11.toString();
            sb2.append(invocationTargetException);
            str2 = sb2.toString();
            b.l(str2);
            return false;
        } catch (NoSuchMethodException unused) {
            str2 = "No connect method in the " + str + " class, ignoring request.";
            b.l(str2);
            return false;
        } catch (InvocationTargetException e12) {
            sb2 = new StringBuilder();
            sb2.append("Could not execute method 'connect' in profile ");
            sb2.append(str);
            sb2.append(", ignoring request.");
            invocationTargetException = e12.toString();
            sb2.append(invocationTargetException);
            str2 = sb2.toString();
            b.l(str2);
            return false;
        }
    }

    public static boolean b(BluetoothProfile bluetoothProfile, BluetoothDevice bluetoothDevice) {
        String str;
        ReflectiveOperationException e10;
        if (bluetoothProfile == null || bluetoothDevice == null) {
            return false;
        }
        try {
            b.j(String.format("disconnect : %s : %s", bluetoothProfile.getClass().getName(), a.c(bluetoothDevice.getAddress(), true)));
            Method method = bluetoothProfile.getClass().getMethod("disconnect", BluetoothDevice.class);
            method.setAccessible(true);
            return ((Boolean) method.invoke(bluetoothProfile, bluetoothDevice)).booleanValue();
        } catch (IllegalAccessException e11) {
            e10 = e11;
            str = "Could not execute method 'disconnect' in profile , ignoring request." + e10.toString();
            b.e(str);
            return false;
        } catch (NoSuchMethodException unused) {
            str = "No disconnect method in the  class, ignoring request.";
            b.e(str);
            return false;
        } catch (InvocationTargetException e12) {
            e10 = e12;
            str = "Could not execute method 'disconnect' in profile , ignoring request." + e10.toString();
            b.e(str);
            return false;
        }
    }

    @TargetApi(19)
    public static int c(BluetoothProfile bluetoothProfile, String str, BluetoothDevice bluetoothDevice) {
        String str2;
        ReflectiveOperationException e10;
        if (bluetoothProfile == null || bluetoothDevice == null) {
            return 0;
        }
        try {
            Method method = bluetoothProfile.getClass().asSubclass(Class.forName(str)).getMethod("getConnectionState", BluetoothDevice.class);
            method.setAccessible(true);
            return ((Integer) method.invoke(bluetoothProfile, bluetoothDevice)).intValue();
        } catch (ClassNotFoundException e11) {
            str2 = "Could not find clas: " + str + ", ignoring request." + e11.toString();
            b.l(str2);
            return 0;
        } catch (IllegalAccessException e12) {
            e10 = e12;
            str2 = "Could not execute method 'connect' in profile CLASS_NAME, ignoring request." + e10.toString();
            b.l(str2);
            return 0;
        } catch (NoSuchMethodException unused) {
            str2 = "No connect method in the CLASS_NAME class, ignoring request.";
            b.l(str2);
            return 0;
        } catch (InvocationTargetException e13) {
            e10 = e13;
            str2 = "Could not execute method 'connect' in profile CLASS_NAME, ignoring request." + e10.toString();
            b.l(str2);
            return 0;
        }
    }

    public static void d(BluetoothProfile bluetoothProfile, BluetoothDevice bluetoothDevice, int i10) {
        if (bluetoothProfile != null) {
            try {
                bluetoothProfile.getClass().getMethod("setPriority", BluetoothDevice.class, Integer.TYPE).invoke(bluetoothProfile, bluetoothDevice, Integer.valueOf(i10));
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }
}
