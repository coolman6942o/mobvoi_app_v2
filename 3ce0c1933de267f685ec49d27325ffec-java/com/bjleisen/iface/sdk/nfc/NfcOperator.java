package com.bjleisen.iface.sdk.nfc;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.tech.IsoDep;
import android.nfc.tech.MifareClassic;
import android.nfc.tech.Ndef;
import android.nfc.tech.NfcA;
import android.os.Build;
import com.unionpay.tsmservice.data.Constant;
import h9.a;
import h9.b;
/* loaded from: classes.dex */
public class NfcOperator {
    private static NfcOperator sInstance;
    private Activity mActivity;
    private IntentFilter[] mFilters;
    private Intent mIntent;
    private IsoDep mIsoDep;
    private PendingIntent mPendingIntent;
    private String[][] mTechLists;
    private NfcAdapter nfcAdapter;

    private NfcOperator() {
    }

    private String ByteArrayToHexString(byte[] bArr) {
        String[] strArr = {"0", "1", "2", Constant.APPLY_MODE_DECIDED_BY_BANK, "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
        String str = "";
        for (byte b10 : bArr) {
            int i10 = b10 & 255;
            str = (str + strArr[(i10 >> 4) & 15]) + strArr[i10 & 15];
        }
        return str;
    }

    public static synchronized NfcOperator getInstance() {
        NfcOperator nfcOperator;
        synchronized (NfcOperator.class) {
            if (sInstance == null) {
                sInstance = new NfcOperator();
            }
            nfcOperator = sInstance;
        }
        return nfcOperator;
    }

    private void setOperateTag(Tag tag) {
        if (tag != null) {
            IsoDep isoDep = IsoDep.get(tag);
            this.mIsoDep = isoDep;
            if (isoDep != null) {
                isoDep.setTimeout(30000);
                return;
            }
            throw new IllegalArgumentException("mIsoDep is null");
        }
        throw new IllegalArgumentException("tag param can not be null");
    }

    public void closeChannel() {
        IsoDep isoDep = this.mIsoDep;
        if (isoDep != null && isoDep.isConnected()) {
            this.mIsoDep.close();
            this.mIsoDep = null;
            b.i("IsoDep is closed");
        }
    }

    public String execute(String str) {
        IsoDep isoDep;
        b.i("execute command: " + str);
        if (!(str == null || (isoDep = this.mIsoDep) == null)) {
            if (!isoDep.isConnected()) {
                this.mIsoDep.connect();
            }
            byte[] transceive = this.mIsoDep.transceive(a.c(str));
            b.i("execute result rapdu1: " + transceive);
            if (transceive != null) {
                String a10 = a.a(transceive);
                b.i("execute result rapdu: " + a10);
                return a10;
            }
        }
        return null;
    }

    public String getUid() {
        Intent intent = this.mIntent;
        if (intent != null) {
            return ByteArrayToHexString(intent.getByteArrayExtra("android.nfc.extra.ID"));
        }
        throw new IllegalArgumentException("intent is null");
    }

    @SuppressLint({"NewApi"})
    public int init(Context context) {
        if (Build.VERSION.SDK_INT < 10) {
            return -1;
        }
        try {
            NfcAdapter defaultAdapter = NfcAdapter.getDefaultAdapter(context);
            this.nfcAdapter = defaultAdapter;
            if (defaultAdapter == null) {
                b.e(getClass().getName(), "手机不支持NFC功能！");
                return -1;
            }
            IntentFilter intentFilter = new IntentFilter("android.nfc.action.NDEF_DISCOVERED");
            IntentFilter intentFilter2 = new IntentFilter("android.nfc.action.TECH_DISCOVERED");
            IntentFilter intentFilter3 = new IntentFilter("android.nfc.action.TAG_DISCOVERED");
            try {
                intentFilter.addDataType("*/*");
                this.mFilters = new IntentFilter[]{intentFilter, intentFilter2, intentFilter3};
                this.mTechLists = new String[][]{new String[]{Ndef.class.getName(), MifareClassic.class.getName(), NfcA.class.getName()}};
                if (this.nfcAdapter.isEnabled()) {
                    return 0;
                }
                b.e(getClass().getName(), "手机NFC功能没有打开！");
                return -2;
            } catch (IntentFilter.MalformedMimeTypeException e10) {
                throw new RuntimeException(Constant.CASH_LOAD_FAIL, e10);
            }
        } catch (Exception unused) {
            this.nfcAdapter = null;
            return -1;
        }
    }

    @SuppressLint({"NewApi"})
    public void onPause(Activity activity) {
        NfcAdapter nfcAdapter = this.nfcAdapter;
        if (nfcAdapter != null) {
            nfcAdapter.disableForegroundDispatch(activity);
        }
        this.mActivity = null;
    }

    @SuppressLint({"NewApi"})
    public void onResume(Activity activity) {
        if (this.nfcAdapter != null) {
            Activity activity2 = this.mActivity;
            if (activity2 == null) {
                this.mActivity = activity;
                Activity activity3 = this.mActivity;
                PendingIntent activity4 = PendingIntent.getActivity(activity, 0, new Intent(activity3, activity3.getClass()).addFlags(536870912), 0);
                this.mPendingIntent = activity4;
                this.nfcAdapter.enableForegroundDispatch(activity, activity4, this.mFilters, this.mTechLists);
            } else if (!activity2.getClass().equals(activity.getClass())) {
                this.mActivity = activity;
                Activity activity5 = this.mActivity;
                PendingIntent activity6 = PendingIntent.getActivity(activity, 0, new Intent(activity5, activity5.getClass()).addFlags(536870912), 0);
                this.mPendingIntent = activity6;
                this.nfcAdapter.enableForegroundDispatch(activity, activity6, this.mFilters, this.mTechLists);
            }
        }
    }

    public void setOperateIntent(Intent intent) {
        if (intent != null) {
            this.mIntent = intent;
            Tag tag = (Tag) intent.getParcelableExtra("android.nfc.extra.TAG");
            if (tag != null) {
                setOperateTag(tag);
                return;
            }
            throw new IllegalArgumentException("intent params not contain nfc tag info");
        }
        throw new IllegalArgumentException("intent params can not be null");
    }
}
