package com.huawei.hms.framework.common;

import android.text.TextUtils;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.NoRouteToHostException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
/* loaded from: classes.dex */
public class ExceptionCode {
    public static final int CANCEL = 1104;
    private static final String CONNECT = "connect";
    public static final int CONNECTION_ABORT = 110205;
    public static final int CONNECTION_REFUSED = 110209;
    public static final int CONNECTION_RESET = 110204;
    public static final int CONNECT_FAILED = 110206;
    public static final int CRASH_EXCEPTION = 1103;
    public static final int INTERRUPT_CONNECT_CLOSE = 110214;
    public static final int INTERRUPT_EXCEPTION = 110213;
    public static final int NETWORK_CHANGED = 110216;
    public static final int NETWORK_IO_EXCEPTION = 1102;
    public static final int NETWORK_UNREACHABLE = 110208;
    public static final int PROTOCOL_ERROR = 110217;
    private static final String READ = "read";
    public static final int READ_ERROR = 110203;
    public static final int ROUTE_FAILED = 110207;
    public static final int SHUTDOWN_EXCEPTION = 110218;
    public static final int SOCKET_CLOSE = 110215;
    public static final int SOCKET_CONNECT_TIMEOUT = 110221;
    public static final int SOCKET_READ_TIMEOUT = 110223;
    public static final int SOCKET_TIMEOUT = 110200;
    public static final int SOCKET_WRITE_TIMEOUT = 110225;
    public static final int SSL_HANDSHAKE_EXCEPTION = 110211;
    public static final int SSL_PEERUNVERIFIED_EXCEPTION = 110212;
    public static final int SSL_PROTOCOL_EXCEPTION = 110210;
    public static final int UNABLE_TO_RESOLVE_HOST = 110202;
    public static final int UNEXPECTED_EOF = 110201;
    private static final String WRITE = "write";

    private static String checkExceptionContainsKey(Exception exc, String... strArr) {
        String checkStrContainsKey = checkStrContainsKey(StringUtils.toLowerCase(exc.getMessage()), strArr);
        if (!TextUtils.isEmpty(checkStrContainsKey)) {
            return checkStrContainsKey;
        }
        for (StackTraceElement stackTraceElement : exc.getStackTrace()) {
            checkStrContainsKey = checkStrContainsKey(StringUtils.toLowerCase(stackTraceElement.toString()), strArr);
            if (!TextUtils.isEmpty(checkStrContainsKey)) {
                return checkStrContainsKey;
            }
        }
        return checkStrContainsKey;
    }

    private static String checkStrContainsKey(String str, String... strArr) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        for (String str2 : strArr) {
            if (str.contains(str2)) {
                return str2;
            }
        }
        return "";
    }

    public static int getErrorCodeFromException(Exception exc) {
        if (exc == null) {
            return 1102;
        }
        if (!(exc instanceof IOException)) {
            return 1103;
        }
        String message = exc.getMessage();
        if (message == null) {
            return 1102;
        }
        String lowerCase = StringUtils.toLowerCase(message);
        int errorCodeFromMsg = getErrorCodeFromMsg(lowerCase);
        return errorCodeFromMsg != 1102 ? errorCodeFromMsg : exc instanceof SocketTimeoutException ? getErrorCodeSocketTimeout(exc) : exc instanceof ConnectException ? CONNECT_FAILED : exc instanceof NoRouteToHostException ? ROUTE_FAILED : exc instanceof SSLProtocolException ? SSL_PROTOCOL_EXCEPTION : exc instanceof SSLHandshakeException ? SSL_HANDSHAKE_EXCEPTION : exc instanceof SSLPeerUnverifiedException ? SSL_PEERUNVERIFIED_EXCEPTION : exc instanceof UnknownHostException ? UNABLE_TO_RESOLVE_HOST : exc instanceof InterruptedIOException ? lowerCase.contains("connection has been shut down") ? INTERRUPT_CONNECT_CLOSE : INTERRUPT_EXCEPTION : errorCodeFromMsg;
    }

    private static int getErrorCodeFromMsg(String str) {
        if (str.contains("unexpected end of stream")) {
            return UNEXPECTED_EOF;
        }
        if (str.contains("unable to resolve host")) {
            return UNABLE_TO_RESOLVE_HOST;
        }
        if (str.contains("read error")) {
            return READ_ERROR;
        }
        if (str.contains("connection reset")) {
            return CONNECTION_RESET;
        }
        if (str.contains("software caused connection abort")) {
            return CONNECTION_ABORT;
        }
        if (str.contains("failed to connect to")) {
            return CONNECT_FAILED;
        }
        if (str.contains("connection refused")) {
            return CONNECTION_REFUSED;
        }
        if (str.contains("connection timed out")) {
            return SOCKET_CONNECT_TIMEOUT;
        }
        if (str.contains("no route to host")) {
            return ROUTE_FAILED;
        }
        if (str.contains("network is unreachable")) {
            return NETWORK_UNREACHABLE;
        }
        if (str.contains("socket closed")) {
            return SOCKET_CLOSE;
        }
        return 1102;
    }

    private static int getErrorCodeSocketTimeout(Exception exc) {
        String checkExceptionContainsKey = checkExceptionContainsKey(exc, CONNECT, READ, WRITE);
        checkExceptionContainsKey.hashCode();
        char c10 = 65535;
        switch (checkExceptionContainsKey.hashCode()) {
            case 3496342:
                if (checkExceptionContainsKey.equals(READ)) {
                    c10 = 0;
                    break;
                }
                break;
            case 113399775:
                if (checkExceptionContainsKey.equals(WRITE)) {
                    c10 = 1;
                    break;
                }
                break;
            case 951351530:
                if (checkExceptionContainsKey.equals(CONNECT)) {
                    c10 = 2;
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
                return SOCKET_READ_TIMEOUT;
            case 1:
                return SOCKET_WRITE_TIMEOUT;
            case 2:
                return SOCKET_CONNECT_TIMEOUT;
            default:
                return SOCKET_TIMEOUT;
        }
    }
}
