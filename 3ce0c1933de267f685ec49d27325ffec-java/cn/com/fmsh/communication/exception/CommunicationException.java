package cn.com.fmsh.communication.exception;

import cn.com.fmsh.FM_Exception;
import x2.b;
import x2.c;
import x2.d;
import x2.e;
import x2.f;
import x2.g;
/* loaded from: classes.dex */
public class CommunicationException extends FM_Exception {
    private static final /* synthetic */ long serialVersionUID = -638900000836743962L;

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ CommunicationExceptionType f6106a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ CommandDirection f6107b;

    /* loaded from: classes.dex */
    public enum CommandDirection {
        REQUESR((byte) 0, b.b(294, "绛竱设氖")),
        RESPONSE((byte) 1, e.a(310, "幸叾哜庀"));
        

        /* renamed from: a  reason: collision with root package name */
        private /* synthetic */ byte f6109a;

        /* renamed from: b  reason: collision with root package name */
        private /* synthetic */ String f6110b;

        /* synthetic */ CommandDirection(byte b10, String str) {
            this.f6109a = b10;
            this.f6110b = str;
        }

        public String getDescription() {
            return this.f6110b;
        }

        public int getValue() {
            return this.f6109a;
        }
    }

    /* loaded from: classes.dex */
    public enum CommunicationExceptionType {
        INVALID_VERSION((byte) 1, d.c("斡攚匌论牍机", 238)),
        INVALID_FORMAT((byte) 2, g.a(122, 28, "拯斁栾弑斺攞")),
        CHECK_FAILED((byte) 3, f.a("抩斎棆骏失赸", 4)),
        INVALID_CONTROL((byte) 4, c.i("拼斂掶别孞旵攉", 2, 12)),
        INVALID_SESSION((byte) 5, g.a(3, 87, "佉讗旡攐")),
        INVALID_SESSION_NUMBER((byte) 6, d.c("住讛洖汼旹敂", 2)),
        INVALID_DIRECTION((byte) 7, g.a(3, 94, "攣挿斶吜彉幱")),
        NO_REPONSE((byte) 8, b.b(2, "朥攬刵哝序收挿")),
        INVALID_REPONSE((byte) 9, FM_Exception.insert(3, 30, "哊庑攳振乒吕泎")),
        UNKNOW((byte) -1, c.i("杳瞨镘论", 130, 116));
        

        /* renamed from: a  reason: collision with root package name */
        private /* synthetic */ byte f6112a;

        /* renamed from: b  reason: collision with root package name */
        private /* synthetic */ String f6113b;

        /* synthetic */ CommunicationExceptionType(byte b10, String str) {
            this.f6112a = b10;
            this.f6113b = str;
        }

        public static CommunicationExceptionType instance(int i10) {
            CommunicationExceptionType[] values;
            for (CommunicationExceptionType communicationExceptionType : values()) {
                if (communicationExceptionType.getValue() == i10) {
                    return communicationExceptionType;
                }
            }
            return UNKNOW;
        }

        public String getDescription() {
            return this.f6113b;
        }

        public int getValue() {
            return this.f6112a;
        }
    }

    public CommunicationException(String str) {
        super(str);
    }

    public CommandDirection getDirection() {
        return this.f6107b;
    }

    public CommunicationExceptionType getExceptionType() {
        return this.f6106a;
    }

    public void setDirection(CommandDirection commandDirection) {
        this.f6107b = commandDirection;
    }

    public void setExceptionType(CommunicationExceptionType communicationExceptionType) {
        this.f6106a = communicationExceptionType;
    }
}
