package cn.com.fmsh.script.exception;

import cn.com.fmsh.FM_Exception;
import x2.a;
import x2.d;
import x2.e;
import x2.f;
/* loaded from: classes.dex */
public class FMScriptHandleException extends FM_Exception {
    private static final /* synthetic */ long serialVersionUID = 1872758501585762351L;

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ ScriptHandleExceptionType f6123a;

    /* loaded from: classes.dex */
    public enum ScriptHandleExceptionType {
        STOPED((byte) 1, f.a("彘剅擈佞裴倀欻", 3)),
        INVALID_FIRST_ID((byte) 2, a.b("笢专朹捚仦斧攄", 286, 37)),
        INVALID_NEXT((byte) 3, e.a(6, "乐朿挆仠庈叽太亞彀剛庖叫")),
        OPENMOBILE_TRANSMIT_EXCEPTION((byte) 4, d.c("<4ph7e6(2 x.亻亂弃幪", 96)),
        UNKNOW((byte) -1, a.b("杹矾镚认", 3, 40));
        

        /* renamed from: a  reason: collision with root package name */
        private /* synthetic */ byte f6125a;

        /* renamed from: b  reason: collision with root package name */
        private /* synthetic */ String f6126b;

        /* synthetic */ ScriptHandleExceptionType(byte b10, String str) {
            this.f6125a = b10;
            this.f6126b = str;
        }

        public String getDescription() {
            return this.f6126b;
        }

        public int getValue() {
            return this.f6125a;
        }
    }

    public FMScriptHandleException(String str) {
        super(str);
    }

    public ScriptHandleExceptionType getType() {
        return this.f6123a;
    }

    public void setType(ScriptHandleExceptionType scriptHandleExceptionType) {
        this.f6123a = scriptHandleExceptionType;
    }
}
