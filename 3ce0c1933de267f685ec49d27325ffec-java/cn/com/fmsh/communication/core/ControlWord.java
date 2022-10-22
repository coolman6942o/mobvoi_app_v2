package cn.com.fmsh.communication.core;
/* loaded from: classes.dex */
public class ControlWord {

    /* renamed from: f  reason: collision with root package name */
    private static /* synthetic */ int[] f6038f;

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ MessageType f6039a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ Direction f6040b;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ CommandType f6041c;

    /* renamed from: d  reason: collision with root package name */
    private /* synthetic */ boolean f6042d;

    /* renamed from: e  reason: collision with root package name */
    private /* synthetic */ byte f6043e;

    /* loaded from: classes.dex */
    public enum CommandType {
        HEARTBEAT(0),
        OPENSESSION(1),
        CLOSESESSION(2),
        BUSINESS_ERROR(3);
        

        /* renamed from: a  reason: collision with root package name */
        private /* synthetic */ int f6045a;

        /* synthetic */ CommandType(int i10) {
            this.f6045a = i10;
        }
    }

    /* loaded from: classes.dex */
    public enum Direction {
        REQUEST(0),
        RESPONSE(1);
        

        /* renamed from: a  reason: collision with root package name */
        private /* synthetic */ int f6047a;

        /* synthetic */ Direction(int i10) {
            this.f6047a = i10;
        }
    }

    /* loaded from: classes.dex */
    public enum MessageType {
        BUSINESS(0),
        CONTROL(1);
        

        /* renamed from: a  reason: collision with root package name */
        private /* synthetic */ int f6049a;

        /* synthetic */ MessageType(int i10) {
            this.f6049a = i10;
        }
    }

    static /* bridge */ /* synthetic */ int[] a() {
        int[] iArr = f6038f;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[CommandType.values().length];
        try {
            iArr2[CommandType.BUSINESS_ERROR.ordinal()] = 4;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[CommandType.CLOSESESSION.ordinal()] = 3;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[CommandType.HEARTBEAT.ordinal()] = 1;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr2[CommandType.OPENSESSION.ordinal()] = 2;
        } catch (NoSuchFieldError unused4) {
        }
        f6038f = iArr2;
        return iArr2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0047, code lost:
        if ((r5 & 15) == 0) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0049, code lost:
        r4.f6042d = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x004c, code lost:
        r4.f6042d = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0057, code lost:
        if (r5 == 0) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:?, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(byte b10) {
        CommandType commandType;
        if ((b10 & 128) == 0) {
            this.f6039a = MessageType.BUSINESS;
        } else {
            this.f6039a = MessageType.CONTROL;
            byte b11 = (byte) (((byte) (b10 & 96)) >> 5);
            if (b11 == 0) {
                commandType = CommandType.HEARTBEAT;
            } else if (b11 == 1) {
                commandType = CommandType.OPENSESSION;
            } else if (b11 == 2) {
                commandType = CommandType.CLOSESESSION;
            } else if (b11 == 3) {
                commandType = CommandType.BUSINESS_ERROR;
            }
            this.f6041c = commandType;
        }
        this.f6040b = ((byte) (b10 & 16)) == 0 ? Direction.REQUEST : Direction.RESPONSE;
        if (this.f6040b != Direction.RESPONSE) {
            return;
        }
        if (this.f6039a != MessageType.BUSINESS) {
            int i10 = b10 & 15;
            if (this.f6041c != CommandType.HEARTBEAT) {
                this.f6043e = (byte) i10;
            }
        }
    }

    public CommandType c() {
        return this.f6041c;
    }

    public Direction d() {
        return this.f6040b;
    }

    public byte e() {
        return this.f6043e;
    }

    public boolean f() {
        return this.f6042d;
    }

    public void g(CommandType commandType) {
        this.f6041c = commandType;
    }

    public void h(Direction direction) {
        this.f6040b = direction;
    }

    public void i(MessageType messageType) {
        this.f6039a = messageType;
    }

    public byte j() {
        byte b10;
        int i10;
        int i11;
        if (this.f6039a == MessageType.CONTROL) {
            b10 = (byte) (-128);
            int i12 = a()[this.f6041c.ordinal()];
            if (i12 == 2) {
                i11 = b10 | 32;
            } else if (i12 == 3) {
                i11 = b10 | 64;
            } else if (i12 == 4) {
                i11 = b10 | 96;
            }
            b10 = (byte) i11;
        } else {
            b10 = 0;
        }
        if (this.f6040b != Direction.RESPONSE) {
            return b10;
        }
        byte b11 = (byte) (b10 & 16);
        if (this.f6041c != CommandType.HEARTBEAT && this.f6039a != MessageType.BUSINESS) {
            i10 = b11 | (this.f6043e & 15);
        } else if (!this.f6042d) {
            return b11;
        } else {
            i10 = b11 | 1;
        }
        return (byte) i10;
    }
}
