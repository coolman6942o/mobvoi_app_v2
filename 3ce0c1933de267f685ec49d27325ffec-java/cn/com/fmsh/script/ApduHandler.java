package cn.com.fmsh.script;

import cn.com.fmsh.script.exception.FMScriptHandleException;
import x2.e;
import x2.h;
/* loaded from: classes.dex */
public interface ApduHandler {

    /* loaded from: classes.dex */
    public enum ApduHandlerType {
        OPEN_MOBILE(1, e.a(5, "5-emKfnf~p")),
        NFC(2, e.a(2, "\u0019\u001c\u001e")),
        FM8301(3, h.e("94k~wp", 2, 122)),
        BLUETOOTH(4, e.a(5, "81ufRfc{z"));
        

        /* renamed from: a  reason: collision with root package name */
        private /* synthetic */ int f6121a;

        /* renamed from: b  reason: collision with root package name */
        private /* synthetic */ String f6122b;

        /* synthetic */ ApduHandlerType(int i10, String str) {
            this.f6121a = i10;
            this.f6122b = str;
        }

        public String getDescription() {
            return this.f6122b;
        }

        public int getValue() {
            return this.f6121a;
        }
    }

    boolean b();

    boolean c();

    void close();

    byte[] d(byte[] bArr) throws FMScriptHandleException;

    boolean e(byte[] bArr);

    ApduHandlerType f();
}
