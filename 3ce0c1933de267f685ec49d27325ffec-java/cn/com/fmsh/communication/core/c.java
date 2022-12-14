package cn.com.fmsh.communication.core;

import cn.com.fmsh.FM_Exception;
import cn.com.fmsh.communication.core.ControlWord;
import cn.com.fmsh.communication.core.MessageHead;
import cn.com.fmsh.communication.exception.CommunicationException;
import cn.com.fmsh.communication.exception.SocketException;
import cn.com.fmsh.communication.exception.session.CloseSessionException;
import cn.com.fmsh.communication.exception.session.OpenSessionException;
import cn.com.fmsh.exception.InvalidParameterException;
import d2.b;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import x2.d;
import x2.e;
import x2.f;
import x2.g;
import x2.h;
import z2.a;
/* loaded from: classes.dex */
public class c implements d2.c {

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ DataInputStream f6070b;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ DataOutputStream f6071c;

    /* renamed from: d  reason: collision with root package name */
    private /* synthetic */ b f6072d;

    /* renamed from: e  reason: collision with root package name */
    private /* synthetic */ byte[] f6073e;

    /* renamed from: f  reason: collision with root package name */
    private /* synthetic */ byte[] f6074f;

    /* renamed from: j  reason: collision with root package name */
    private volatile /* synthetic */ long f6078j;

    /* renamed from: l  reason: collision with root package name */
    private volatile /* synthetic */ long f6080l;

    /* renamed from: q  reason: collision with root package name */
    private /* synthetic */ a f6085q;

    /* renamed from: s  reason: collision with root package name */
    private /* synthetic */ a3.b f6087s;

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ Socket f6069a = null;

    /* renamed from: h  reason: collision with root package name */
    private /* synthetic */ int f6076h = 4;

    /* renamed from: i  reason: collision with root package name */
    private /* synthetic */ int f6077i = 12;

    /* renamed from: n  reason: collision with root package name */
    private volatile /* synthetic */ boolean f6082n = false;

    /* renamed from: o  reason: collision with root package name */
    private volatile /* synthetic */ boolean f6083o = false;

    /* renamed from: p  reason: collision with root package name */
    private /* synthetic */ int f6084p = 5000;

    /* renamed from: r  reason: collision with root package name */
    private /* synthetic */ String f6086r = c.class.getName();

    /* renamed from: t  reason: collision with root package name */
    private volatile /* synthetic */ long f6088t = 0;

    /* renamed from: u  reason: collision with root package name */
    private volatile /* synthetic */ long f6089u = 0;

    /* renamed from: m  reason: collision with root package name */
    private /* synthetic */ a3.a f6081m = new a();

    /* renamed from: g  reason: collision with root package name */
    private /* synthetic */ byte[] f6075g = new byte[16];

    /* renamed from: k  reason: collision with root package name */
    private /* synthetic */ byte[] f6079k = new byte[4];

    /* renamed from: v  reason: collision with root package name */
    private /* synthetic */ Lock f6090v = new ReentrantLock();

    public c() {
        this.f6085q = null;
        this.f6085q = z2.b.a().b();
        new LinkedList();
    }

    private final /* bridge */ /* synthetic */ void i() {
        this.f6080l = this.f6078j >= 4294967295L ? 0L : this.f6078j + 1;
    }

    private final /* bridge */ /* synthetic */ byte[] k(byte[] bArr, boolean z10) throws CommunicationException, SocketException {
        CommunicationException communicationException;
        if (bArr == null || bArr.length < 1) {
            a aVar = this.f6085q;
            if (aVar != null) {
                aVar.c(this.f6086r, f.a("?????????????????????????????????????????????????????????", 3));
            }
            communicationException = new CommunicationException(x2.b.b(1, "?????????????????????????????????????????????????????????"));
            communicationException.setExceptionType(CommunicationException.CommunicationExceptionType.NO_REPONSE);
            if (!z10) {
                throw communicationException;
            }
        } else if (bArr.length < 12) {
            a aVar2 = this.f6085q;
            if (aVar2 != null) {
                aVar2.b(this.f6086r, FM_Exception.insert(2, 29, "???????????????????????????????????????????????????????????????????????????"));
            }
            communicationException = new CommunicationException(d.c("???????????????????????????????????????????????????????????????????????????", 362));
            communicationException.setExceptionType(CommunicationException.CommunicationExceptionType.INVALID_REPONSE);
            communicationException.setDirection(CommunicationException.CommandDirection.RESPONSE);
            if (!z10) {
                throw communicationException;
            }
        } else {
            MessageHead messageHead = new MessageHead();
            messageHead.a(Arrays.copyOf(bArr, 12));
            ControlWord b10 = messageHead.b();
            if (b10.d() != ControlWord.Direction.RESPONSE) {
                a aVar3 = this.f6085q;
                if (aVar3 != null) {
                    aVar3.c(this.f6086r, FM_Exception.insert(3, 99, "?????????????????????????????????????????????????????????????????????"));
                }
                communicationException = new CommunicationException(x2.a.b("?????????????????????????????????????????????????????????????????????", 166, 17));
                communicationException.setExceptionType(CommunicationException.CommunicationExceptionType.INVALID_DIRECTION);
                communicationException.setDirection(CommunicationException.CommandDirection.RESPONSE);
                if (!z10) {
                    throw communicationException;
                }
            } else {
                if (!Arrays.equals(this.f6079k, messageHead.e())) {
                    a aVar4 = this.f6085q;
                    if (aVar4 != null) {
                        aVar4.c(this.f6086r, x2.a.b("?????????????????????????????????????????????????????????????????????", 336, 72));
                    }
                    this.f6083o = false;
                    CommunicationException communicationException2 = new CommunicationException(g.a(6, 44, "?????????????????????????????????????????????????????????????????????"));
                    communicationException2.setExceptionType(CommunicationException.CommunicationExceptionType.INVALID_SESSION);
                    communicationException2.setDirection(CommunicationException.CommandDirection.RESPONSE);
                    if (z10) {
                        this.f6072d.c(communicationException2, CommunicationException.class);
                    } else {
                        throw communicationException2;
                    }
                }
                if (this.f6080l != messageHead.d()) {
                    a aVar5 = this.f6085q;
                    if (aVar5 != null) {
                        aVar5.c(this.f6086r, FM_Exception.insert(2, 19, "?????????????????????????????????????????????????????????????????????"));
                    }
                    this.f6083o = false;
                    CommunicationException communicationException3 = new CommunicationException(f.a("?????????????????????????????????????????????????????????????????????", 112));
                    communicationException3.setExceptionType(CommunicationException.CommunicationExceptionType.INVALID_SESSION_NUMBER);
                    communicationException3.setDirection(CommunicationException.CommandDirection.RESPONSE);
                    if (z10) {
                        this.f6072d.c(communicationException3, CommunicationException.class);
                    } else {
                        throw communicationException3;
                    }
                } else {
                    this.f6078j = this.f6080l;
                }
                if (b10.e() == 0 || b10.e() == 14) {
                    byte[] c10 = messageHead.c();
                    if (!(c10[0] == MessageHead.SecurityLevel.CIPHER.getValue() || c10[1] == MessageHead.CheckType.MAC.getValue())) {
                        a aVar6 = this.f6085q;
                        if (aVar6 != null) {
                            aVar6.c(this.f6086r, g.a(178, 84, "???????????????????????????????????????????????????????????????????????????"));
                        }
                        CommunicationException communicationException4 = new CommunicationException(FM_Exception.insert(4, 36, "???????????????????????????????????????????????????????????????????????????"));
                        communicationException4.setExceptionType(CommunicationException.CommunicationExceptionType.CHECK_FAILED);
                        communicationException4.setDirection(CommunicationException.CommandDirection.RESPONSE);
                        if (z10) {
                            this.f6072d.c(communicationException4, CommunicationException.class);
                        } else {
                            throw communicationException4;
                        }
                    }
                    byte[] copyOfRange = Arrays.copyOfRange(bArr, bArr.length - 4, bArr.length);
                    byte[] a10 = y2.b.a(Arrays.copyOfRange(this.f6075g, this.f6076h, this.f6077i), new byte[8], Arrays.copyOf(bArr, bArr.length - 4));
                    if (!Arrays.equals(copyOfRange, Arrays.copyOf(a10, 4))) {
                        a aVar7 = this.f6085q;
                        if (aVar7 != null) {
                            String str = this.f6086r;
                            aVar7.c(str, FM_Exception.insert(3, 54, "????????????????????????Z\f@?????????????????????\u001eH\\\u000e") + x2.c.c(copyOfRange) + d.c("\u000bk????????????QL\u001d\u0014", 3) + x2.c.c(a10) + "]");
                        }
                        CommunicationException communicationException5 = new CommunicationException(h.e("????????????????????????\u0017TS?????????????????????????????????", 5, 91));
                        communicationException5.setExceptionType(CommunicationException.CommunicationExceptionType.CHECK_FAILED);
                        communicationException5.setDirection(CommunicationException.CommandDirection.RESPONSE);
                        if (z10) {
                            this.f6072d.c(communicationException5, CommunicationException.class);
                        } else {
                            throw communicationException5;
                        }
                    }
                    byte[] copyOfRange2 = Arrays.copyOfRange(bArr, 12, bArr.length - 4);
                    if (copyOfRange2.length < 1 || bArr.length % 8 != 0) {
                        CommunicationException communicationException6 = new CommunicationException(x2.c.i("??????????????????????????????????????????A\u001aJ???????????????????????????????????????", 2, 58));
                        communicationException6.setExceptionType(CommunicationException.CommunicationExceptionType.UNKNOW);
                        communicationException6.setDirection(CommunicationException.CommandDirection.RESPONSE);
                        if (z10) {
                            this.f6072d.c(communicationException6, CommunicationException.class);
                        } else {
                            throw communicationException6;
                        }
                    }
                    byte[] b11 = y2.a.b(this.f6075g, copyOfRange2);
                    if (!x2.c.r(b11)) {
                        a aVar8 = this.f6085q;
                        if (aVar8 != null) {
                            aVar8.c(this.f6086r, d.c("????????????????????????????????????", 3));
                        }
                        CommunicationException communicationException7 = new CommunicationException(h.e("????????????????????????????????????", 5, 24));
                        communicationException7.setExceptionType(CommunicationException.CommunicationExceptionType.UNKNOW);
                        communicationException7.setDirection(CommunicationException.CommandDirection.RESPONSE);
                        if (z10) {
                            this.f6072d.c(communicationException7, CommunicationException.class);
                        } else {
                            throw communicationException7;
                        }
                    }
                    byte[] b12 = x2.c.b(b11);
                    if (z10) {
                        this.f6072d.b(b12);
                    }
                    a aVar9 = this.f6085q;
                    if (aVar9 != null) {
                        String str2 = this.f6086r;
                        aVar9.a(str2, x2.b.b(344, "??????????????????+\u007fx; ?.1e") + x2.c.c(b12));
                    }
                    if (b10.f()) {
                        this.f6072d.a();
                    }
                    return b12;
                }
                CommunicationException.CommunicationExceptionType instance = CommunicationException.CommunicationExceptionType.instance(b10.e());
                if (CommunicationException.CommunicationExceptionType.INVALID_SESSION == instance || CommunicationException.CommunicationExceptionType.INVALID_SESSION_NUMBER == instance) {
                    this.f6083o = false;
                }
                CommunicationException communicationException8 = new CommunicationException(e.a(2, "??????????????????3") + instance.getDescription());
                communicationException8.setExceptionType(instance);
                communicationException8.setDirection(CommunicationException.CommandDirection.RESPONSE);
                throw communicationException8;
            }
        }
        this.f6072d.c(communicationException, CommunicationException.class);
        return null;
    }

    /* JADX WARN: Finally extract failed */
    private final /* bridge */ /* synthetic */ byte[] l(byte[] bArr, byte[] bArr2) throws IOException {
        if (this.f6070b == null) {
            a aVar = this.f6085q;
            if (aVar != null) {
                aVar.c(c.class.getName(), x2.c.i("\u00176ml+f`7upw'n|gvys*4#*7", 4, 4));
            }
            throw new IOException(d.c("\u0005(;\"\u007f\u007f???????????????}???????????????", 3));
        } else if (this.f6071c == null) {
            a aVar2 = this.f6085q;
            if (aVar2 != null) {
                aVar2.c(c.class.getName(), FM_Exception.insert(3, 81, "K1g1ku>>a/e\"6w!'u$py3i9"));
            }
            throw new IOException(x2.c.i("\u000fc\u007fgy8??????????????? ???????????????", 5, 16));
        } else {
            this.f6090v.lock();
            try {
                try {
                    byte[] s10 = x2.c.s(bArr, bArr2);
                    this.f6071c.write(s10);
                    a aVar3 = this.f6085q;
                    if (aVar3 != null) {
                        String name = c.class.getName();
                        aVar3.a(name, f.a("\u007flhg 9;#5k", 4) + x2.c.c(s10));
                    }
                    this.f6071c.flush();
                    a3.b a10 = a3.b.a();
                    this.f6087s = a10;
                    byte[] b10 = a10.b(this.f6081m, this.f6084p, this.f6070b);
                    this.f6090v.unlock();
                    a aVar4 = this.f6085q;
                    if (aVar4 != null) {
                        String name2 = c.class.getName();
                        aVar4.a(name2, x2.b.b(164, "cy$;8>6~mukk/") + x2.c.c(b10));
                    }
                    return b10;
                } catch (IOException e10) {
                    a aVar5 = this.f6085q;
                    if (aVar5 != null) {
                        aVar5.c(c.class.getName(), e.a(332, "2+$!($s%<2;b!)?/q1/98pwofb"));
                    }
                    a aVar6 = this.f6085q;
                    if (aVar6 != null) {
                        aVar6.b(c.class.getName(), h.f(e10));
                        this.f6085q.a(c.class.getName(), x2.c.i("????????????8s*e<", 3, 71));
                    }
                    throw new IOException(f.a("Yhgj;/???????????????e????????????", 2) + h.f(e10));
                }
            } catch (Throwable th2) {
                this.f6090v.unlock();
                throw th2;
            }
        }
    }

    @Override // d2.c
    public boolean a() throws SocketException {
        a aVar = this.f6085q;
        if (aVar != null) {
            aVar.a(this.f6086r, h.e("eylmr\"5/:|9(;j", 4, 15));
        }
        this.f6082n = false;
        try {
            DataOutputStream dataOutputStream = this.f6071c;
            if (dataOutputStream != null) {
                dataOutputStream.close();
            }
        } catch (IOException e10) {
            a aVar2 = this.f6085q;
            if (aVar2 != null) {
                aVar2.b(this.f6086r, h.f(e10));
            }
        }
        this.f6071c = null;
        try {
            DataInputStream dataInputStream = this.f6070b;
            if (dataInputStream != null) {
                dataInputStream.close();
            }
        } catch (IOException e11) {
            a aVar3 = this.f6085q;
            if (aVar3 != null) {
                aVar3.b(this.f6086r, h.f(e11));
            }
        }
        this.f6070b = null;
        try {
            Socket socket = this.f6069a;
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e12) {
            a aVar4 = this.f6085q;
            if (aVar4 != null) {
                aVar4.b(this.f6086r, h.f(e12));
            }
        }
        this.f6069a = null;
        return true;
    }

    @Override // d2.c
    public boolean b(e2.c cVar, boolean z10) throws InvalidParameterException, SocketException, CommunicationException, OpenSessionException {
        if (this.f6085q == null) {
            this.f6085q = z2.b.a().b();
        }
        if (this.f6083o) {
            return true;
        }
        if (cVar != null) {
            ControlWord controlWord = new ControlWord();
            controlWord.h(ControlWord.Direction.REQUEST);
            controlWord.i(ControlWord.MessageType.CONTROL);
            controlWord.g(ControlWord.CommandType.OPENSESSION);
            MessageHead messageHead = new MessageHead();
            messageHead.g((byte) 17);
            MessageHead.SecurityLevel securityLevel = MessageHead.SecurityLevel.PLAIN;
            MessageHead.CheckType checkType = MessageHead.CheckType.CRC16;
            messageHead.h(new byte[]{(byte) securityLevel.getValue(), (byte) checkType.getValue()});
            messageHead.f(controlWord);
            byte[] k10 = messageHead.k();
            d dVar = new d();
            dVar.k(cVar.g());
            dVar.c(cVar.a());
            dVar.e(cVar.c());
            dVar.d(cVar.b());
            dVar.f(cVar.d());
            dVar.g(cVar.e());
            dVar.i(cVar.f());
            Random random = new Random();
            byte[] bArr = new byte[8];
            this.f6074f = bArr;
            random.nextBytes(bArr);
            dVar.j(this.f6074f);
            byte[] bArr2 = new byte[16];
            this.f6073e = bArr2;
            random.nextBytes(bArr2);
            dVar.h(this.f6073e);
            byte[] l10 = dVar.l();
            if (l10 != null) {
                byte[] s10 = x2.c.s(k10, l10);
                byte[] s11 = x2.c.s(s10, x2.b.a(s10));
                try {
                    byte[] l11 = l(this.f6081m.b(s11.length), s11);
                    if (l11 == null) {
                        a aVar = this.f6085q;
                        if (aVar != null) {
                            aVar.b(this.f6086r, d.c("???????????????????????????????????????????????????????????????", 1));
                        }
                        throw new CommunicationException(g.a(328, 20, "???????????????????????????????????????????????????????????????"));
                    } else if (l11.length >= 12) {
                        messageHead.a(Arrays.copyOf(l11, 12));
                        ControlWord b10 = messageHead.b();
                        if (b10.d() == ControlWord.Direction.RESPONSE) {
                            byte[] c10 = messageHead.c();
                            if (c10[0] != securityLevel.getValue() || c10[1] != checkType.getValue()) {
                                a aVar2 = this.f6085q;
                                if (aVar2 != null) {
                                    aVar2.c(this.f6086r, e.a(1, "???????????????????????????????????????????????????????????????"));
                                }
                                throw new OpenSessionException(h.e("???????????????????????????????????????????????????????????????", 108, 10));
                            } else if (!Arrays.equals(x2.b.a(Arrays.copyOf(l11, l11.length - 2)), Arrays.copyOfRange(l11, l11.length - 2, l11.length))) {
                                a aVar3 = this.f6085q;
                                if (aVar3 != null) {
                                    aVar3.c(this.f6086r, x2.c.i("??????????????????????????????????????????Z\u0017\u0012????????????", 186, 44));
                                }
                                throw new OpenSessionException(g.a(5, 28, "??????????????????????????????????????????\u001eKV????????????"));
                            } else {
                                byte[] copyOfRange = Arrays.copyOfRange(l11, 12, l11.length - 2);
                                if (b10.e() != 0 && b10.e() != 14) {
                                    CommunicationException.CommunicationExceptionType instance = CommunicationException.CommunicationExceptionType.instance(b10.e());
                                    CommunicationException communicationException = new CommunicationException(FM_Exception.insert(4, 30, "????????????:") + instance.getDescription());
                                    communicationException.setExceptionType(instance);
                                    communicationException.setDirection(CommunicationException.CommandDirection.RESPONSE);
                                    throw communicationException;
                                } else if (copyOfRange.length < 1) {
                                    throw new CommunicationException(x2.a.b("??????????????????????????????????????????????????????????????????", 3, 57));
                                } else if (b10.e() != 14) {
                                    byte[] b11 = y2.a.b(this.f6073e, copyOfRange);
                                    if (!x2.c.r(b11)) {
                                        a aVar4 = this.f6085q;
                                        if (aVar4 != null) {
                                            aVar4.c(this.f6086r, g.a(1, 56, "??????????????????r\u001dt:?????????????????????"));
                                        }
                                        throw new OpenSessionException(h.e("??????????????????8\u0003f,?????????????????????", 70, 60));
                                    }
                                    byte[] b12 = x2.c.b(b11);
                                    b bVar = new b();
                                    bVar.a(b12);
                                    if (Arrays.equals(bVar.e(), this.f6074f)) {
                                        byte[] c11 = bVar.c();
                                        this.f6075g = c11;
                                        if (c11 == null || c11.length != 16) {
                                            throw new OpenSessionException(h.e("?????????????????????????????????????????????", 4, 79));
                                        }
                                        this.f6078j = x2.c.g(x2.c.s(new byte[1], bVar.b())) - 1;
                                        this.f6079k = bVar.d();
                                        this.f6083o = true;
                                        this.f6089u = System.currentTimeMillis();
                                        this.f6088t = System.currentTimeMillis();
                                        return true;
                                    }
                                    throw new OpenSessionException(h.e("??????????????????????????????????????????????????????????????????", 3, 110));
                                } else {
                                    OpenSessionException.OpenSessionExceptionType instance2 = OpenSessionException.OpenSessionExceptionType.instance(copyOfRange[0]);
                                    OpenSessionException openSessionException = new OpenSessionException(instance2.getDescription());
                                    openSessionException.setExceptionType(instance2);
                                    throw openSessionException;
                                }
                            }
                        } else {
                            CommunicationException communicationException2 = new CommunicationException(x2.c.i("??????????????????????????????????????????????????????????????????????????????", 3, 66));
                            communicationException2.setExceptionType(CommunicationException.CommunicationExceptionType.INVALID_DIRECTION);
                            communicationException2.setDirection(CommunicationException.CommandDirection.RESPONSE);
                            throw communicationException2;
                        }
                    } else {
                        CommunicationException communicationException3 = new CommunicationException(e.a(3, "??????????????????????????????????????????????????????????????????????????????"));
                        communicationException3.setExceptionType(CommunicationException.CommunicationExceptionType.INVALID_FORMAT);
                        communicationException3.setDirection(CommunicationException.CommandDirection.RESPONSE);
                        throw communicationException3;
                    }
                } catch (IOException e10) {
                    this.f6082n = false;
                    a aVar5 = this.f6085q;
                    if (aVar5 != null) {
                        String str = this.f6086r;
                        aVar5.b(str, x2.b.b(96, "?????????????????????????????????") + h.f(e10));
                    }
                    throw new SocketException(h.f(e10));
                } catch (Exception e11) {
                    this.f6082n = false;
                    throw new SocketException(h.f(e11));
                }
            } else {
                throw new OpenSessionException(FM_Exception.insert(5, 109, "??????????????????????????????)wak?????????????????????"));
            }
        } else {
            throw new InvalidParameterException(f.a("?????????????????????????????????????????????????????????", 1));
        }
    }

    @Override // d2.c
    public boolean c() {
        if (this.f6082n && System.currentTimeMillis() - this.f6088t >= 540000) {
            a aVar = this.f6085q;
            if (aVar != null) {
                aVar.a(c.class.getName(), FM_Exception.insert(5, 45, "zs1fx87(8p xq;2i6sga"));
            }
            this.f6082n = false;
        }
        return this.f6082n;
    }

    @Override // d2.c
    public boolean d(e2.a aVar) throws InvalidParameterException, SocketException, CommunicationException, CloseSessionException {
        if (this.f6085q == null) {
            this.f6085q = z2.b.a().b();
        }
        a aVar2 = this.f6085q;
        if (aVar2 != null) {
            aVar2.a(this.f6086r, x2.a.b("io-3qw5e(-s;\u000f\u007fk%=}~`b$&", 4, 94));
        }
        this.f6083o = false;
        ControlWord controlWord = new ControlWord();
        controlWord.h(ControlWord.Direction.REQUEST);
        controlWord.i(ControlWord.MessageType.CONTROL);
        ControlWord.CommandType commandType = ControlWord.CommandType.CLOSESESSION;
        controlWord.g(commandType);
        i();
        MessageHead messageHead = new MessageHead();
        messageHead.g((byte) 17);
        messageHead.j(this.f6079k);
        messageHead.i(this.f6080l);
        messageHead.h(new byte[]{(byte) MessageHead.SecurityLevel.PLAIN.getValue(), (byte) MessageHead.CheckType.MAC.getValue()});
        messageHead.f(controlWord);
        if (aVar == null) {
            aVar = new e2.a();
        }
        byte[] s10 = x2.c.s(messageHead.k(), aVar.a());
        byte[] s11 = x2.c.s(s10, Arrays.copyOf(y2.b.a(Arrays.copyOfRange(this.f6075g, this.f6076h, this.f6077i), new byte[8], s10), 4));
        a aVar3 = this.f6085q;
        if (aVar3 != null) {
            String str = this.f6086r;
            aVar3.a(str, FM_Exception.insert(5, 62, "j+j0d?.~*d<|?/?n:r p5%") + x2.c.c(s11));
        }
        try {
            byte[] l10 = l(this.f6081m.b(s11.length), s11);
            if (l10 == null) {
                a aVar4 = this.f6085q;
                if (aVar4 != null) {
                    aVar4.b(this.f6086r, d.c("?????????????????????????????????????????????????????????", 82));
                }
                throw new CommunicationException(f.a("?????????????????????????????????????????????????????????", 5));
            }
            a aVar5 = this.f6085q;
            if (aVar5 != null) {
                String str2 = this.f6086r;
                aVar5.a(str2, e.a(4, "???????????????") + x2.c.c(l10));
            }
            if (l10.length < 12) {
                a aVar6 = this.f6085q;
                if (aVar6 != null) {
                    aVar6.b(this.f6086r, x2.c.i("???????????????????????????????????????????????????????????????", 154, 68));
                }
                CommunicationException communicationException = new CommunicationException(x2.a.b("???????????????????????????????????????????????????????????????", 5, 84));
                communicationException.setExceptionType(CommunicationException.CommunicationExceptionType.INVALID_FORMAT);
                communicationException.setDirection(CommunicationException.CommandDirection.RESPONSE);
                throw communicationException;
            }
            messageHead.a(Arrays.copyOf(l10, 12));
            ControlWord b10 = messageHead.b();
            if (b10.d() != ControlWord.Direction.RESPONSE) {
                CommunicationException communicationException2 = new CommunicationException(x2.b.b(270, "????????????????????????????????????????????????????????????????????????"));
                communicationException2.setExceptionType(CommunicationException.CommunicationExceptionType.INVALID_DIRECTION);
                communicationException2.setDirection(CommunicationException.CommandDirection.RESPONSE);
                throw communicationException2;
            } else if (b10.e() != 0) {
                CommunicationException.CommunicationExceptionType instance = CommunicationException.CommunicationExceptionType.instance(b10.e());
                CommunicationException communicationException3 = new CommunicationException(x2.a.b("????????????6", 316, 120) + instance.getDescription());
                communicationException3.setExceptionType(instance);
                communicationException3.setDirection(CommunicationException.CommandDirection.RESPONSE);
                throw communicationException3;
            } else if (b10.c() == commandType) {
                return true;
            } else {
                throw new CommunicationException(h.e("???????????????????????????????????????????????????????????????", 206, 3));
            }
        } catch (IOException e10) {
            this.f6082n = false;
            throw new SocketException(h.f(e10));
        } catch (Exception e11) {
            this.f6082n = false;
            throw new SocketException(h.f(e11));
        }
    }

    /* JADX WARN: Finally extract failed */
    @Override // d2.c
    public byte[] e(byte[] bArr) throws InvalidParameterException, SocketException, CommunicationException {
        if (this.f6085q == null) {
            this.f6085q = z2.b.a().b();
        }
        a aVar = this.f6085q;
        if (aVar != null) {
            String str = this.f6086r;
            aVar.a(str, x2.a.b("????????????????????????z-/'-iuy<", 278, 10) + x2.c.c(bArr));
        }
        if (bArr == null || bArr.length < 1) {
            a aVar2 = this.f6085q;
            if (aVar2 != null) {
                aVar2.c(this.f6086r, e.a(3, "???????????????????????????????????????????????????????????????"));
            }
            throw new InvalidParameterException(h.e("???????????????????????????????????????????????????????????????", 86, 40));
        }
        ControlWord controlWord = new ControlWord();
        controlWord.h(ControlWord.Direction.REQUEST);
        controlWord.i(ControlWord.MessageType.BUSINESS);
        MessageHead messageHead = new MessageHead();
        messageHead.g((byte) 17);
        messageHead.h(new byte[]{(byte) MessageHead.SecurityLevel.CIPHER.getValue(), (byte) MessageHead.CheckType.MAC.getValue()});
        messageHead.f(controlWord);
        i();
        messageHead.i(this.f6080l);
        messageHead.j(this.f6079k);
        byte[] s10 = x2.c.s(messageHead.k(), y2.a.d(this.f6075g, x2.c.a(bArr)));
        byte[] s11 = x2.c.s(s10, Arrays.copyOf(y2.b.a(Arrays.copyOfRange(this.f6075g, this.f6076h, this.f6077i), new byte[8], s10), 4));
        j(true);
        try {
            try {
                byte[] l10 = l(this.f6081m.b(s11.length), s11);
                this.f6089u = System.currentTimeMillis();
                this.f6088t = System.currentTimeMillis();
                j(false);
                return k(l10, false);
            } catch (Exception e10) {
                a aVar3 = this.f6085q;
                if (aVar3 != null) {
                    aVar3.c(this.f6086r, x2.c.i("????????????????????????????????????????????????48< ", 3, 124));
                }
                this.f6082n = false;
                throw new SocketException(h.f(e10));
            }
        } catch (Throwable th2) {
            this.f6089u = System.currentTimeMillis();
            this.f6088t = System.currentTimeMillis();
            j(false);
            throw th2;
        }
    }

    /* JADX WARN: Finally extract failed */
    @Override // d2.c
    public boolean f(LinkInfo linkInfo) throws InvalidParameterException, SocketException {
        if (this.f6085q == null) {
            this.f6085q = z2.b.a().b();
        }
        if (c()) {
            return true;
        }
        if (linkInfo == null) {
            a aVar = this.f6085q;
            if (aVar != null) {
                aVar.c(this.f6086r, x2.a.b("????????????????????????????????????????????????", 3, 64));
            }
            throw new InvalidParameterException(x2.b.b(310, "????????????????????????????????????????????????"));
        } else if (linkInfo.b() < 1 || linkInfo.b() >= 65535) {
            a aVar2 = this.f6085q;
            if (aVar2 != null) {
                aVar2.b(this.f6086r, g.a(4, 63, "????????????????????????????????????????????????"));
            }
            throw new InvalidParameterException(x2.c.i("????????????????????????????????????????????????", 1, 105));
        } else if (linkInfo.a() == null || linkInfo.a().length() < 1) {
            a aVar3 = this.f6085q;
            if (aVar3 != null) {
                aVar3.b(this.f6086r, x2.b.b(2, "????????????????????????????????????????????????"));
            }
            throw new InvalidParameterException(x2.b.b(5, "????????????????????????????????????????????????"));
        } else {
            if (linkInfo.c() != -1) {
                this.f6084p = linkInfo.c();
            }
            this.f6090v.lock();
            try {
                try {
                    Socket socket = new Socket(linkInfo.a(), linkInfo.b());
                    this.f6069a = socket;
                    if (socket.getSoTimeout() == 0) {
                        this.f6069a.setSoTimeout(this.f6084p);
                    }
                    this.f6070b = new DataInputStream(this.f6069a.getInputStream());
                    this.f6071c = new DataOutputStream(this.f6069a.getOutputStream());
                    this.f6090v.unlock();
                    this.f6082n = true;
                    this.f6088t = System.currentTimeMillis();
                    return true;
                } catch (IOException e10) {
                    a aVar4 = this.f6085q;
                    if (aVar4 != null) {
                        String str = this.f6086r;
                        aVar4.a(str, e.a(2, "\u00076<tei{a/") + linkInfo.a() + ":" + linkInfo.b());
                        this.f6085q.b(this.f6086r, h.f(e10));
                    }
                    throw new SocketException(h.f(e10));
                } catch (Exception e11) {
                    a aVar5 = this.f6085q;
                    if (aVar5 != null) {
                        String str2 = this.f6086r;
                        aVar5.a(str2, FM_Exception.insert(3, 118, "W12=9:9,7") + linkInfo.a() + ":" + linkInfo.b());
                        this.f6085q.b(this.f6086r, h.f(e11));
                    }
                    throw new SocketException(h.f(e11));
                }
            } catch (Throwable th2) {
                this.f6090v.unlock();
                throw th2;
            }
        }
    }

    @Override // d2.c
    public void g(b bVar) {
        this.f6072d = bVar;
    }

    @Override // d2.c
    public boolean h() {
        if (this.f6083o && System.currentTimeMillis() - this.f6089u >= 540000) {
            a aVar = this.f6085q;
            if (aVar != null) {
                aVar.a(c.class.getName(), f.a("\u007fltue/z;=?%k<,/:3,\"r", 4));
            }
            this.f6083o = false;
        }
        return this.f6083o;
    }

    final /* bridge */ /* synthetic */ void j(boolean z10) {
    }
}
