package com.bjleisen.iface.sdk.oma;

import android.text.TextUtils;
import com.bjleisen.iface.sdk.enums.EnumStatusCode;
import h9.a;
import h9.b;
import org.simalliance.openmobileapi.Channel;
import org.simalliance.openmobileapi.Reader;
import org.simalliance.openmobileapi.SEService;
import org.simalliance.openmobileapi.Session;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class SmartCardRequest {
    private static final String TAG = "SmartCardRequest";
    private Channel mChannel;
    private SEService mSEService;
    private Session mSession;

    /* JADX INFO: Access modifiers changed from: protected */
    public SmartCardRequest(SEService sEService) {
        this.mSEService = sEService;
    }

    private Reader getCurrentAvailableReader() {
        b.g(TAG, "select reader name:" + SmartCard.mReaderType.getValue());
        Reader[] readers = this.mSEService.getReaders();
        if (readers == null || readers.length <= 0) {
            b.g(TAG, "no available reader");
            return null;
        }
        for (Reader reader : readers) {
            b.g(TAG, "reader name:" + reader.getName());
            if (reader.getName().startsWith(SmartCard.mReaderType.getValue())) {
                return reader;
            }
        }
        b.g(TAG, "select reader not in available readers");
        return null;
    }

    private int openCurrentAvailableChannel(String str) {
        Reader currentAvailableReader = getCurrentAvailableReader();
        if (currentAvailableReader == null) {
            EnumStatusCode enumStatusCode = EnumStatusCode.STATUS_SMARTCARD_READER_NOT_EXIST;
            b.g(TAG, enumStatusCode.getMsg());
            return enumStatusCode.getStatus();
        } else if (!currentAvailableReader.isSecureElementPresent()) {
            EnumStatusCode enumStatusCode2 = EnumStatusCode.STATUS_SMARTCARD_OPEN_CHANNEL_FAIL;
            b.g(TAG, enumStatusCode2.getMsg());
            return enumStatusCode2.getStatus();
        } else {
            this.mSession = currentAvailableReader.openSession();
            byte[] c10 = a.c(str);
            b.j(TAG, "打开通道的Aid：" + str);
            Session session = this.mSession;
            if (session != null) {
                this.mChannel = session.openLogicalChannel(c10);
            }
            if (this.mChannel != null) {
                return 0;
            }
            EnumStatusCode enumStatusCode3 = EnumStatusCode.STATUS_SMARTCARD_OPEN_CHANNEL_FAIL;
            b.g(TAG, enumStatusCode3.getMsg());
            return enumStatusCode3.getStatus();
        }
    }

    public void closeChannelAndSession() {
        try {
            Channel channel = this.mChannel;
            if (channel != null && !channel.isClosed()) {
                this.mChannel.close();
                this.mChannel = null;
                b.j(TAG, "Channel正常关闭");
            }
        } catch (Exception e10) {
            b.g(TAG, "Channel关闭异常" + e10.getMessage());
        }
        try {
            Session session = this.mSession;
            if (session != null && !session.isClosed()) {
                this.mSession.close();
                this.mSession = null;
                b.j(TAG, "Session正常关闭");
            }
        } catch (Exception e11) {
            b.g(TAG, "Session关闭异常" + e11.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized CardResult executeApduCmd(String str) {
        if (!TextUtils.isEmpty(str) && str.length() >= 6) {
            if ("00A404".equalsIgnoreCase(str.substring(0, 6))) {
                closeChannelAndSession();
                int openCurrentAvailableChannel = openCurrentAvailableChannel(str.substring(str.length() - (Integer.parseInt(str.substring(8, 10), 16) << 1), str.length()));
                if (openCurrentAvailableChannel == 0) {
                    String a10 = a.a(this.mChannel.getSelectResponse());
                    b.j(TAG, "执行开通道APDU:" + str + "，返回的RAPDU为：" + a10);
                    return new CardResult(a10, 0, null);
                }
                return new CardResult(openCurrentAvailableChannel, "Open channal failure");
            }
            byte[] c10 = a.c(str);
            Channel channel = this.mChannel;
            if (channel != null) {
                String a11 = a.a(channel.transmit(c10));
                b.j(TAG, "执行APDU:" + str + "，返回的RAPDU为：" + a11);
                return new CardResult(a11, 0, null);
            }
            return new CardResult(-1, "Channal is not open");
        }
        return new CardResult(-1, "Command is null or length is not enough");
    }
}
