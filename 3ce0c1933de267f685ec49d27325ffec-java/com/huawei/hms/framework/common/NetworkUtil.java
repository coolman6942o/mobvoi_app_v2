package com.huawei.hms.framework.common;

import android.app.ActivityManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.DhcpInfo;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.PowerManager;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.huawei.android.os.BuildEx;
import com.huawei.android.telephony.ServiceStateEx;
import com.mobvoi.wear.info.SharedWearInfoHelper;
import java.lang.reflect.InvocationTargetException;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class NetworkUtil {
    private static final String TAG = "NetworkUtil";
    private static final int TYPE_WIFI_P2P = 13;

    /* loaded from: classes.dex */
    public static final class NetType {
        public static final int TYPE_2G = 2;
        public static final int TYPE_3G = 3;
        public static final int TYPE_4G = 4;
        public static final int TYPE_5G = 5;
        public static final int TYPE_NO_NETWORK = -1;
        public static final int TYPE_UNKNOWN = 0;
        public static final int TYPE_WIFI = 1;
    }

    public static String getDnsServerIps(Context context) {
        return Arrays.toString(getDnsServerIpsFromConnectionManager(context));
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0054  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String[] getDnsServerIpsFromConnectionManager(Context context) {
        ConnectivityManager connectivityManager;
        Object e10;
        StringBuilder sb2;
        String str;
        LinkedList<String> linkedList = new LinkedList<>();
        if (!(Build.VERSION.SDK_INT < 21 || context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null)) {
            try {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    linkedList = getDnsServerIpsFromLinkProperties(connectivityManager, activeNetworkInfo);
                }
            } catch (SecurityException e11) {
                e10 = e11;
                str = TAG;
                sb2 = new StringBuilder();
                sb2.append("getActiveNetworkInfo failed, exception:");
                sb2.append(e10.getClass().getSimpleName());
                Logger.i(str, sb2.toString());
                if (linkedList.isEmpty()) {
                }
            } catch (RuntimeException e12) {
                e10 = e12;
                str = TAG;
                sb2 = new StringBuilder();
                sb2.append("getActiveNetworkInfo failed, exception:");
                sb2.append(e10.getClass().getSimpleName());
                Logger.i(str, sb2.toString());
                if (linkedList.isEmpty()) {
                }
            }
        }
        return linkedList.isEmpty() ? new String[0] : (String[]) linkedList.toArray(new String[linkedList.size()]);
    }

    private static LinkedList<String> getDnsServerIpsFromLinkProperties(ConnectivityManager connectivityManager, NetworkInfo networkInfo) {
        LinkProperties linkProperties;
        LinkedList<String> linkedList = new LinkedList<>();
        Network[] allNetworks = connectivityManager.getAllNetworks();
        if (!(allNetworks == null || allNetworks.length == 0)) {
            for (Network network : allNetworks) {
                if (network != null) {
                    NetworkInfo networkInfo2 = null;
                    try {
                        networkInfo2 = connectivityManager.getNetworkInfo(network);
                    } catch (NullPointerException e10) {
                        Logger.i(TAG, "connectivityManager getNetworkInfo failed, exception:" + e10.getClass().getSimpleName());
                    }
                    if (!(networkInfo2 == null || networkInfo2.getType() != networkInfo.getType() || (linkProperties = connectivityManager.getLinkProperties(network)) == null)) {
                        for (InetAddress inetAddress : linkProperties.getDnsServers()) {
                            linkedList.add(inetAddress.getHostAddress());
                        }
                    }
                }
            }
        }
        return linkedList;
    }

    public static String getHost(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            URI uri = new URI(str);
            if (uri.getPort() == -1) {
                return uri.getHost();
            }
            return uri.getHost() + ":" + uri.getPort();
        } catch (URISyntaxException e10) {
            Logger.w(TAG, e10.getClass().getSimpleName());
            return "";
        }
    }

    private static int getHwNetworkType(Context context) {
        TelephonyManager telephonyManager;
        String str;
        String str2;
        ServiceState serviceState;
        int i10 = 0;
        if (!EmuiUtil.isEMUI()) {
            return 0;
        }
        if (!(context == null || (telephonyManager = (TelephonyManager) context.getSystemService(SharedWearInfoHelper.PhoneInfo.TABLE)) == null)) {
            try {
                if (BuildEx.VERSION.EMUI_SDK_INT >= 21 && (serviceState = telephonyManager.getServiceState()) != null) {
                    i10 = ServiceStateEx.getConfigRadioTechnology(serviceState);
                    String str3 = TAG;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("getHwNetworkType return networkType is:");
                    sb2.append(i10);
                    Logger.i(str3, sb2.toString());
                }
            } catch (NoClassDefFoundError unused) {
                str = TAG;
                str2 = "NoClassDefFoundError occur in method getHwNetworkType.";
                Logger.w(str, str2);
                return i10;
            } catch (NoSuchMethodError unused2) {
                str = TAG;
                str2 = "NoSuchMethodError occur in method getHwNetworkType.";
                Logger.w(str, str2);
                return i10;
            } catch (SecurityException unused3) {
                str = TAG;
                str2 = "requires permission maybe missing.";
                Logger.w(str, str2);
                return i10;
            }
        }
        return i10;
    }

    public static int getMobileRsrp(Context context) {
        String str;
        String str2;
        if (context == null) {
            return 0;
        }
        Object systemService = context.getSystemService(SharedWearInfoHelper.PhoneInfo.TABLE);
        SignalStrength signalStrength = null;
        TelephonyManager telephonyManager = systemService instanceof TelephonyManager ? (TelephonyManager) systemService : null;
        if (telephonyManager == null) {
            return 0;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            signalStrength = telephonyManager.createForSubscriptionId(SubscriptionManager.getDefaultDataSubscriptionId()).getSignalStrength();
        }
        if (signalStrength == null) {
            return 0;
        }
        try {
            return ((Integer) SignalStrength.class.getDeclaredMethod("getDbm", new Class[0]).invoke(signalStrength, new Object[0])).intValue();
        } catch (IllegalAccessException unused) {
            str = TAG;
            str2 = "getDbm: cannot access";
            Logger.i(str, str2);
            return 0;
        } catch (NoSuchMethodException unused2) {
            str = TAG;
            str2 = "getDbm: function not found";
            Logger.i(str, str2);
            return 0;
        } catch (InvocationTargetException unused3) {
            str = TAG;
            str2 = "getDbm: InvocationTargetException";
            Logger.i(str, str2);
            return 0;
        }
    }

    public static int getMobileRsrpLevel(Context context) {
        String str;
        String str2;
        if (context == null) {
            return 0;
        }
        Object systemService = context.getSystemService(SharedWearInfoHelper.PhoneInfo.TABLE);
        SignalStrength signalStrength = null;
        TelephonyManager telephonyManager = systemService instanceof TelephonyManager ? (TelephonyManager) systemService : null;
        if (telephonyManager == null) {
            return 0;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            signalStrength = telephonyManager.getSignalStrength();
        }
        if (signalStrength == null) {
            return 0;
        }
        try {
            return ((Integer) SignalStrength.class.getDeclaredMethod("getLteLevel", new Class[0]).invoke(signalStrength, new Object[0])).intValue();
        } catch (IllegalAccessException unused) {
            str = TAG;
            str2 = "getDbm: cannot access";
            Logger.i(str, str2);
            return 0;
        } catch (NoSuchMethodException unused2) {
            str = TAG;
            str2 = "getDbm: function not found";
            Logger.i(str, str2);
            return 0;
        } catch (InvocationTargetException unused3) {
            str = TAG;
            str2 = "getDbm: InvocationTargetException";
            Logger.i(str, str2);
            return 0;
        }
    }

    public static NetworkInfo getNetworkInfo(Context context) {
        ConnectivityManager connectivityManager;
        if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
            return null;
        }
        try {
            return connectivityManager.getActiveNetworkInfo();
        } catch (SecurityException unused) {
            return null;
        } catch (RuntimeException e10) {
            String str = TAG;
            Logger.i(str, "getActiveNetworkInfo failed, exception:" + e10.getClass().getSimpleName());
            return null;
        }
    }

    public static int getNetworkType(Context context) {
        if (context != null) {
            return getNetworkType(getNetworkInfo(context), context);
        }
        return 0;
    }

    public static int getNetworkType(NetworkInfo networkInfo) {
        int i10 = 1;
        if (networkInfo == null || !networkInfo.isConnected()) {
            return -1;
        }
        int type = networkInfo.getType();
        if (!(1 == type || 13 == type)) {
            if (type == 0) {
                int subtype = networkInfo.getSubtype();
                switch (subtype) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                        i10 = 2;
                        break;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                        i10 = 3;
                        break;
                    case 13:
                        i10 = 4;
                        break;
                    default:
                        i10 = 0;
                        break;
                }
                if (i10 == 0 && Build.VERSION.SDK_INT >= 25) {
                    if (subtype == 16) {
                        return 2;
                    }
                    if (subtype == 17) {
                        return 3;
                    }
                }
            }
            return 0;
        }
        return i10;
    }

    public static int getNetworkType(NetworkInfo networkInfo, Context context) {
        int i10;
        if (networkInfo == null || !networkInfo.isConnected()) {
            return -1;
        }
        int type = networkInfo.getType();
        if (1 == type || 13 == type) {
            return 1;
        }
        if (type == 0) {
            int hwNetworkType = getHwNetworkType(context);
            Logger.v(TAG, "getHwNetworkType return is: " + hwNetworkType);
            if (hwNetworkType == 0) {
                hwNetworkType = networkInfo.getSubtype();
            }
            if (hwNetworkType != 20) {
                switch (hwNetworkType) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                        i10 = 2;
                        break;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                        i10 = 3;
                        break;
                    case 13:
                        i10 = 4;
                        break;
                    default:
                        i10 = 0;
                        break;
                }
            } else {
                i10 = 5;
            }
            if (i10 != 0 || Build.VERSION.SDK_INT < 25) {
                return i10;
            }
            if (hwNetworkType == 16) {
                return 2;
            }
            if (hwNetworkType == 17) {
                return 3;
            }
        }
        return 0;
    }

    public static String getSSIDByNetWorkId(Context context) {
        return "";
    }

    public static String getWifiGatewayIp(Context context) {
        if (context == null) {
            return " ";
        }
        Object systemService = context.getApplicationContext().getSystemService("wifi");
        WifiManager wifiManager = systemService instanceof WifiManager ? (WifiManager) systemService : null;
        if (wifiManager == null) {
            return " ";
        }
        try {
            DhcpInfo dhcpInfo = wifiManager.getDhcpInfo();
            if (dhcpInfo == null) {
                return " ";
            }
            int i10 = dhcpInfo.gateway;
            try {
                return InetAddress.getByAddress(new byte[]{(byte) (i10 & 255), (byte) ((i10 >> 8) & 255), (byte) ((i10 >> 16) & 255), (byte) ((i10 >> 24) & 255)}).getHostAddress();
            } catch (Exception unused) {
                Logger.i(TAG, "getWifiGatewayIp: can not get ip addr");
                return " ";
            }
        } catch (SecurityException unused2) {
            Logger.i(TAG, "getWifiGatewayIp did not has permission!");
            return " ";
        }
    }

    public static int getWifiRssi(Context context) {
        if (context == null) {
            return 0;
        }
        Object systemService = context.getApplicationContext().getSystemService("wifi");
        WifiManager wifiManager = systemService instanceof WifiManager ? (WifiManager) systemService : null;
        if (wifiManager == null) {
            return 0;
        }
        try {
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            if (connectionInfo == null || connectionInfo.getBSSID() == null) {
                return 0;
            }
            return connectionInfo.getRssi();
        } catch (SecurityException unused) {
            Logger.i(TAG, "getWifiRssiLevel did not has permission!");
            return 0;
        }
    }

    public static int getWifiRssiLevel(Context context) {
        if (context == null) {
            return 0;
        }
        Object systemService = context.getApplicationContext().getSystemService("wifi");
        WifiManager wifiManager = systemService instanceof WifiManager ? (WifiManager) systemService : null;
        if (wifiManager == null) {
            return 0;
        }
        try {
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            if (connectionInfo == null || connectionInfo.getBSSID() == null) {
                return 0;
            }
            return WifiManager.calculateSignalLevel(connectionInfo.getRssi(), 5);
        } catch (SecurityException unused) {
            Logger.i(TAG, "getWifiRssiLevel did not has permission!");
            return 0;
        }
    }

    public static boolean isForeground(Context context) {
        ActivityManager activityManager;
        if (context == null || (activityManager = (ActivityManager) context.getSystemService("activity")) == null) {
            return false;
        }
        List<ActivityManager.RunningAppProcessInfo> list = null;
        try {
            list = activityManager.getRunningAppProcesses();
        } catch (Exception e10) {
            Logger.w(TAG, "activityManager getRunningAppProcesses occur exception: ", e10);
        }
        if (list == null) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : list) {
            String str = runningAppProcessInfo.processName;
            if (str != null && str.equals(context.getPackageName()) && runningAppProcessInfo.importance == 100) {
                Logger.v(TAG, "isForeground true");
                return true;
            }
        }
        return false;
    }

    public static boolean isInteractive(Context context) {
        if (context != null) {
            Object systemService = context.getSystemService("power");
            PowerManager powerManager = systemService instanceof PowerManager ? (PowerManager) systemService : null;
            if (powerManager != null && Build.VERSION.SDK_INT >= 20) {
                return powerManager.isInteractive();
            }
        }
        return false;
    }

    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager;
        if (!(context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null)) {
            try {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    return activeNetworkInfo.isConnected();
                }
            } catch (SecurityException unused) {
                Logger.w(TAG, "networkIsConnected catch SecurityException");
                return true;
            }
        }
        return false;
    }

    public static NetworkInfo.DetailedState networkStatus(Context context) {
        String str;
        String str2;
        NetworkInfo activeNetworkInfo;
        NetworkInfo.DetailedState detailedState = NetworkInfo.DetailedState.IDLE;
        if (context != null) {
            Object systemService = context.getSystemService("connectivity");
            ConnectivityManager connectivityManager = systemService instanceof ConnectivityManager ? (ConnectivityManager) systemService : null;
            if (connectivityManager != null) {
                try {
                    activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                } catch (SecurityException unused) {
                }
                if (activeNetworkInfo != null) {
                    return activeNetworkInfo.getDetailedState();
                }
                Logger.i(TAG, "networkIsConnected netInfo is null!");
                return detailedState;
            }
            str = TAG;
            str2 = "networkStatus ConnectivityManager is null!";
        } else {
            str = TAG;
            str2 = "networkStatus Context is null!";
        }
        Logger.i(str, str2);
        return detailedState;
    }
}
