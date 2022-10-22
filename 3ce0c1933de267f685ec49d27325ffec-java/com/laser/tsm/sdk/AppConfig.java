package com.laser.tsm.sdk;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.laser.tsm.sdk.bean.DeviceInfo;
import com.laser.tsm.sdk.tsm.IMobvoiTsmBluetoothInterface;
import com.laser.tsm.sdk.tsm.IMobvoiTsmSingleTransBluetoothInterface;
import com.laser.tsm.sdk.util.DataConvertUtil;
import com.mobvoi.wear.info.SharedWearInfoHelper;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes2.dex */
public class AppConfig {
    public static final String APDU_GETCIN = "80CA004500";
    public static final String APDU_GETCPLC = "80CA9f7f00";
    public static final String APDU_GETIIN = "80CA004200";
    public static final String APDU_SELECT = "00A4040008A000000151000000";
    public static final String APDU_SELECT_CRS = "00A4040009A00000015143525300";
    public static String CLIENTVERSION = "1.0";
    public static String CPLC = "";
    public static final int FINISHFLAG_FINISH = 0;
    public static final int FINISHFLAG_UNFINISH = 1;
    public static String IMEI = null;
    public static String IMSI = null;
    public static String MOBILETYPE = null;
    public static String SEID = "";
    public static final String SFK_APPLET_SELECT = "00A4040010F0000000000190777F05010100000081";
    public static final String SFK_BALANCE_COMMAND = "8050000000";
    public static final int STATUS_BIND_BLUETOOTHSERVICE_ERROR = 4099;
    public static final int STATUS_CONNECTION_DEVICE_FAILURE = 4100;
    public static final int STATUS_CPLC_IS_NULL = 4101;
    public static final int STATUS_DATA_PARSE_FAILURE = 4097;
    public static final int STATUS_GET_DEVICEINFO_FAILURE = 4102;
    public static final int STATUS_NULL_PARAMS = 4103;
    public static final int STATUS_REQUEST_FAILURE = 4096;
    public static final int STATUS_SMARTCARD_OPER_FAILURE = 4098;
    public static final int STATUS_SUCCESS = 100000;
    public static String STREAMURL = "";
    public static final String STREAMURL_BETA = "http://219.239.243.149:19001/apkp/TSMServer/applicationBusiness.action";
    public static final String VERSION = "1.0";
    public static DeviceInfo deviceInfo;
    public static IMobvoiTsmBluetoothInterface multiBluetoothInterfaceService;
    public static IMobvoiTsmSingleTransBluetoothInterface singleluetoothInterfaceService;

    public static String bytesToHexString(byte[] bArr) {
        StringBuilder sb2 = new StringBuilder("");
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        for (byte b10 : bArr) {
            String hexString = Integer.toHexString(b10 & 255);
            if (hexString.length() < 2) {
                sb2.append(0);
            }
            sb2.append(hexString);
        }
        return sb2.toString();
    }

    private static byte charToByte(char c10) {
        return (byte) "0123456789ABCDEF".indexOf(c10);
    }

    public static void clearDeviceData() {
        CPLC = null;
        SEID = null;
        deviceInfo = null;
    }

    private static byte[] commandHeader(byte b10, byte b11, byte b12, byte b13) {
        return new byte[]{b10, b11, b12, b13};
    }

    public static final byte[] generateAPDU(byte b10, byte b11, byte b12, byte b13, byte[] bArr) {
        byte[] commandHeader = commandHeader(b10, b11, b12, b13);
        if (bArr == null || bArr.length == 0) {
            return commandHeader;
        }
        byte[] bArr2 = new byte[bArr.length + 5];
        bArr2[4] = (byte) bArr.length;
        System.arraycopy(commandHeader, 0, bArr2, 0, 4);
        System.arraycopy(bArr, 0, bArr2, 5, bArr.length);
        return bArr2;
    }

    private static final byte[] generateData(byte b10, byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length + 2];
        bArr2[0] = b10;
        bArr2[1] = (byte) bArr.length;
        System.arraycopy(bArr, 0, bArr2, 2, bArr.length);
        return bArr2;
    }

    public static String getAppletOperCommand(byte b10, String str) {
        return bytesToHexString(generateAPDU(Byte.MIN_VALUE, (byte) -16, (byte) 1, b10, generateData((byte) 79, hexStringToBytes(str))));
    }

    public static String getCurrentTime() {
        return new SimpleDateFormat("yyyyMMddHHmmss").format((Date) new java.sql.Date(System.currentTimeMillis()));
    }

    public static String getDefaultAppletCommand(String str) {
        return bytesToHexString(generateAPDU(Byte.MIN_VALUE, (byte) -14, (byte) 64, (byte) 0, hexStringToBytes(bytesToHexString(generateData((byte) 79, hexStringToBytes(str))) + bytesToHexString(generateData((byte) 92, hexStringToBytes("4F9F70"))))));
    }

    private static String getImei(Context context) {
        return ((TelephonyManager) context.getSystemService(SharedWearInfoHelper.PhoneInfo.TABLE)).getDeviceId();
    }

    private static String getImsi(Context context) {
        return ((TelephonyManager) context.getSystemService(SharedWearInfoHelper.PhoneInfo.TABLE)).getSubscriberId();
    }

    public static String getRechargeCommand(byte[] bArr) {
        return DataConvertUtil.bytesToHexString(generateAPDU(Byte.MIN_VALUE, (byte) 48, (byte) 0, (byte) 0, bArr));
    }

    private static String getVersionName(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public static byte[] hexStringToBytes(String str) {
        if (str == null || str.equals("")) {
            return null;
        }
        String upperCase = str.toUpperCase();
        int length = upperCase.length() / 2;
        char[] charArray = upperCase.toCharArray();
        byte[] bArr = new byte[length];
        for (int i10 = 0; i10 < length; i10++) {
            int i11 = i10 * 2;
            bArr[i10] = (byte) (charToByte(charArray[i11 + 1]) | (charToByte(charArray[i11]) << 4));
        }
        return bArr;
    }

    public static final void init(Context context) {
        CLIENTVERSION = getVersionName(context);
        MOBILETYPE = Build.MODEL;
    }
}
