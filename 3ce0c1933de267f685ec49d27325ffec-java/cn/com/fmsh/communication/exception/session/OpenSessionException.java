package cn.com.fmsh.communication.exception.session;

import cn.com.fmsh.FM_Exception;
import com.realsil.sdk.dfu.DfuException;
import x2.d;
import x2.e;
import x2.f;
import x2.g;
import x2.h;
/* loaded from: classes.dex */
public class OpenSessionException extends FM_Exception {
    private static final /* synthetic */ long serialVersionUID = -638900000836743962L;

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ OpenSessionExceptionType f6114a;

    /* loaded from: classes.dex */
    public enum OpenSessionExceptionType {
        SYSTEM_BUSY(Byte.MIN_VALUE, h.e("糨纆忆ｉ暉倍掲儸李动", 150, 70)),
        INVALID_TERMINAL((byte) -127, d.c("斻攄纕窡籤垛", DfuException.ERROR_CONNECT_ERROR)),
        INVALID_KEY_INDEX((byte) -126, d.c("笨剷伧畡寜钮紾弘斾攇", 3)),
        DECRYPT_FAIL((byte) -125, h.e("签剬讯氖攠挢覫宂奱赹", 3, 124)),
        DATA_FORMAT_ERROR((byte) -124, e.a(DfuException.ERROR_DFU_ENABLE_BUFFER_CHECK_NO_RESPONSE, "筯判诠汘敭据栿弉锐诣")),
        INVALID_TERMINAL_ID((byte) -123, d.c("斵攎纟窧缏叽", 2)),
        SECURITY_CODE((byte) -122, f.a("阸伭砅骍讟奪赽", 2)),
        INVALID_TIME((byte) -121, h.e("纖竤斮闱弐幧", 1, 45)),
        UNKNOW((byte) -1, g.a(294, 118, "朼矩锛讷"));
        

        /* renamed from: a  reason: collision with root package name */
        private /* synthetic */ byte f6116a;

        /* renamed from: b  reason: collision with root package name */
        private /* synthetic */ String f6117b;

        /* synthetic */ OpenSessionExceptionType(byte b10, String str) {
            this.f6116a = b10;
            this.f6117b = str;
        }

        public static OpenSessionExceptionType instance(int i10) {
            OpenSessionExceptionType[] values;
            for (OpenSessionExceptionType openSessionExceptionType : values()) {
                if (openSessionExceptionType.getValue() == i10) {
                    return openSessionExceptionType;
                }
            }
            return UNKNOW;
        }

        public String getDescription() {
            return this.f6117b;
        }

        public int getValue() {
            return this.f6116a;
        }
    }

    public OpenSessionException(String str) {
        super(str);
    }

    public OpenSessionExceptionType getExceptionType() {
        return this.f6114a;
    }

    public void setExceptionType(OpenSessionExceptionType openSessionExceptionType) {
        this.f6114a = openSessionExceptionType;
    }
}
