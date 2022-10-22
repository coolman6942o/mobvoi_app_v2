package d2;

import cn.com.fmsh.communication.core.LinkInfo;
import cn.com.fmsh.communication.exception.CommunicationException;
import cn.com.fmsh.communication.exception.SocketException;
import cn.com.fmsh.communication.exception.session.CloseSessionException;
import cn.com.fmsh.communication.exception.session.OpenSessionException;
import cn.com.fmsh.exception.InvalidParameterException;
import e2.a;
/* loaded from: classes.dex */
public interface c {
    boolean a() throws SocketException;

    boolean b(e2.c cVar, boolean z10) throws InvalidParameterException, SocketException, CommunicationException, OpenSessionException;

    boolean c();

    boolean d(a aVar) throws InvalidParameterException, SocketException, CommunicationException, CloseSessionException;

    byte[] e(byte[] bArr) throws InvalidParameterException, SocketException, CommunicationException;

    boolean f(LinkInfo linkInfo) throws InvalidParameterException, SocketException;

    void g(b bVar);

    boolean h();
}
