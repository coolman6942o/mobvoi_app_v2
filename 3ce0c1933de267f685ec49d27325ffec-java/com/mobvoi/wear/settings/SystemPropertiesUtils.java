package com.mobvoi.wear.settings;

import android.content.Context;
import android.os.AsyncTask;
import android.os.IBinder;
import android.os.Parcel;
import android.util.Log;
/* loaded from: classes2.dex */
public class SystemPropertiesUtils {
    private static final String TAG = "SystemPropertiesUtils";

    /* loaded from: classes2.dex */
    static class SystemPropPoker extends AsyncTask<Void, Void, Void> {
        private Context mContext;

        private SystemPropPoker(Context context) {
            this.mContext = context;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public Void doInBackground(Void... voidArr) {
            String[] strArr;
            try {
                Class<?> loadClass = this.mContext.getClassLoader().loadClass("android.os.ServiceManager");
                for (String str : (String[]) loadClass.getMethod("listServices", new Class[0]).invoke(loadClass, new Object[0])) {
                    IBinder iBinder = (IBinder) loadClass.getMethod("checkService", String.class).invoke(loadClass, str);
                    if (iBinder != null) {
                        Parcel obtain = Parcel.obtain();
                        try {
                            iBinder.transact(((Integer) IBinder.class.getField("SYSPROPS_TRANSACTION").get(null)).intValue(), obtain, null, 0);
                        } catch (Exception e10) {
                            Log.e(SystemPropertiesUtils.TAG, "received and discard a bad service : " + str + "." + e10);
                        }
                        obtain.recycle();
                    }
                }
                return null;
            } catch (Exception e11) {
                e11.printStackTrace();
                return null;
            }
        }
    }

    public static void pokeSystemProperties(Context context) {
        new SystemPropPoker(context).execute(new Void[0]);
    }
}
