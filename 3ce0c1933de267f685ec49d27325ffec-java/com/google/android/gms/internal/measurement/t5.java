package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.net.SocketException;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Arrays;
import javax.net.ssl.HandshakeCompletedListener;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class t5 extends SSLSocket {

    /* renamed from: a  reason: collision with root package name */
    private final SSLSocket f9680a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t5(s5 s5Var, SSLSocket sSLSocket) {
        this.f9680a = sSLSocket;
    }

    @Override // javax.net.ssl.SSLSocket
    public final void addHandshakeCompletedListener(HandshakeCompletedListener handshakeCompletedListener) {
        this.f9680a.addHandshakeCompletedListener(handshakeCompletedListener);
    }

    @Override // java.net.Socket
    public final void bind(SocketAddress socketAddress) throws IOException {
        this.f9680a.bind(socketAddress);
    }

    @Override // java.net.Socket, java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() throws IOException {
        this.f9680a.close();
    }

    @Override // java.net.Socket
    public final void connect(SocketAddress socketAddress) throws IOException {
        this.f9680a.connect(socketAddress);
    }

    @Override // java.net.Socket
    public final void connect(SocketAddress socketAddress, int i10) throws IOException {
        this.f9680a.connect(socketAddress, i10);
    }

    public final boolean equals(Object obj) {
        return this.f9680a.equals(obj);
    }

    @Override // java.net.Socket
    public final SocketChannel getChannel() {
        return this.f9680a.getChannel();
    }

    @Override // javax.net.ssl.SSLSocket
    public final boolean getEnableSessionCreation() {
        return this.f9680a.getEnableSessionCreation();
    }

    @Override // javax.net.ssl.SSLSocket
    public final String[] getEnabledCipherSuites() {
        return this.f9680a.getEnabledCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocket
    public final String[] getEnabledProtocols() {
        return this.f9680a.getEnabledProtocols();
    }

    @Override // java.net.Socket
    public final InetAddress getInetAddress() {
        return this.f9680a.getInetAddress();
    }

    @Override // java.net.Socket
    public final InputStream getInputStream() throws IOException {
        return this.f9680a.getInputStream();
    }

    @Override // java.net.Socket
    public final boolean getKeepAlive() throws SocketException {
        return this.f9680a.getKeepAlive();
    }

    @Override // java.net.Socket
    public final InetAddress getLocalAddress() {
        return this.f9680a.getLocalAddress();
    }

    @Override // java.net.Socket
    public final int getLocalPort() {
        return this.f9680a.getLocalPort();
    }

    @Override // java.net.Socket
    public final SocketAddress getLocalSocketAddress() {
        return this.f9680a.getLocalSocketAddress();
    }

    @Override // javax.net.ssl.SSLSocket
    public final boolean getNeedClientAuth() {
        return this.f9680a.getNeedClientAuth();
    }

    @Override // java.net.Socket
    public final boolean getOOBInline() throws SocketException {
        return this.f9680a.getOOBInline();
    }

    @Override // java.net.Socket
    public final OutputStream getOutputStream() throws IOException {
        return this.f9680a.getOutputStream();
    }

    @Override // java.net.Socket
    public final int getPort() {
        return this.f9680a.getPort();
    }

    @Override // java.net.Socket
    public final synchronized int getReceiveBufferSize() throws SocketException {
        return this.f9680a.getReceiveBufferSize();
    }

    @Override // java.net.Socket
    public final SocketAddress getRemoteSocketAddress() {
        return this.f9680a.getRemoteSocketAddress();
    }

    @Override // java.net.Socket
    public final boolean getReuseAddress() throws SocketException {
        return this.f9680a.getReuseAddress();
    }

    @Override // java.net.Socket
    public final synchronized int getSendBufferSize() throws SocketException {
        return this.f9680a.getSendBufferSize();
    }

    @Override // javax.net.ssl.SSLSocket
    public final SSLSession getSession() {
        return this.f9680a.getSession();
    }

    @Override // java.net.Socket
    public final int getSoLinger() throws SocketException {
        return this.f9680a.getSoLinger();
    }

    @Override // java.net.Socket
    public final synchronized int getSoTimeout() throws SocketException {
        return this.f9680a.getSoTimeout();
    }

    @Override // javax.net.ssl.SSLSocket
    public final String[] getSupportedCipherSuites() {
        return this.f9680a.getSupportedCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocket
    public final String[] getSupportedProtocols() {
        return this.f9680a.getSupportedProtocols();
    }

    @Override // java.net.Socket
    public final boolean getTcpNoDelay() throws SocketException {
        return this.f9680a.getTcpNoDelay();
    }

    @Override // java.net.Socket
    public final int getTrafficClass() throws SocketException {
        return this.f9680a.getTrafficClass();
    }

    @Override // javax.net.ssl.SSLSocket
    public final boolean getUseClientMode() {
        return this.f9680a.getUseClientMode();
    }

    @Override // javax.net.ssl.SSLSocket
    public final boolean getWantClientAuth() {
        return this.f9680a.getWantClientAuth();
    }

    @Override // java.net.Socket
    public final boolean isBound() {
        return this.f9680a.isBound();
    }

    @Override // java.net.Socket
    public final boolean isClosed() {
        return this.f9680a.isClosed();
    }

    @Override // java.net.Socket
    public final boolean isConnected() {
        return this.f9680a.isConnected();
    }

    @Override // java.net.Socket
    public final boolean isInputShutdown() {
        return this.f9680a.isInputShutdown();
    }

    @Override // java.net.Socket
    public final boolean isOutputShutdown() {
        return this.f9680a.isOutputShutdown();
    }

    @Override // javax.net.ssl.SSLSocket
    public final void removeHandshakeCompletedListener(HandshakeCompletedListener handshakeCompletedListener) {
        this.f9680a.removeHandshakeCompletedListener(handshakeCompletedListener);
    }

    @Override // java.net.Socket
    public final void sendUrgentData(int i10) throws IOException {
        this.f9680a.sendUrgentData(i10);
    }

    @Override // javax.net.ssl.SSLSocket
    public final void setEnableSessionCreation(boolean z10) {
        this.f9680a.setEnableSessionCreation(z10);
    }

    @Override // javax.net.ssl.SSLSocket
    public final void setEnabledCipherSuites(String[] strArr) {
        this.f9680a.setEnabledCipherSuites(strArr);
    }

    @Override // javax.net.ssl.SSLSocket
    public final void setEnabledProtocols(String[] strArr) {
        if (strArr != null && Arrays.asList(strArr).contains("SSLv3")) {
            ArrayList arrayList = new ArrayList(Arrays.asList(this.f9680a.getEnabledProtocols()));
            if (arrayList.size() > 1) {
                arrayList.remove("SSLv3");
            }
            strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
        }
        this.f9680a.setEnabledProtocols(strArr);
    }

    @Override // java.net.Socket
    public final void setKeepAlive(boolean z10) throws SocketException {
        this.f9680a.setKeepAlive(z10);
    }

    @Override // javax.net.ssl.SSLSocket
    public final void setNeedClientAuth(boolean z10) {
        this.f9680a.setNeedClientAuth(z10);
    }

    @Override // java.net.Socket
    public final void setOOBInline(boolean z10) throws SocketException {
        this.f9680a.setOOBInline(z10);
    }

    @Override // java.net.Socket
    public final void setPerformancePreferences(int i10, int i11, int i12) {
        this.f9680a.setPerformancePreferences(i10, i11, i12);
    }

    @Override // java.net.Socket
    public final synchronized void setReceiveBufferSize(int i10) throws SocketException {
        this.f9680a.setReceiveBufferSize(i10);
    }

    @Override // java.net.Socket
    public final void setReuseAddress(boolean z10) throws SocketException {
        this.f9680a.setReuseAddress(z10);
    }

    @Override // java.net.Socket
    public final synchronized void setSendBufferSize(int i10) throws SocketException {
        this.f9680a.setSendBufferSize(i10);
    }

    @Override // java.net.Socket
    public final void setSoLinger(boolean z10, int i10) throws SocketException {
        this.f9680a.setSoLinger(z10, i10);
    }

    @Override // java.net.Socket
    public final synchronized void setSoTimeout(int i10) throws SocketException {
        this.f9680a.setSoTimeout(i10);
    }

    @Override // java.net.Socket
    public final void setTcpNoDelay(boolean z10) throws SocketException {
        this.f9680a.setTcpNoDelay(z10);
    }

    @Override // java.net.Socket
    public final void setTrafficClass(int i10) throws SocketException {
        this.f9680a.setTrafficClass(i10);
    }

    @Override // javax.net.ssl.SSLSocket
    public final void setUseClientMode(boolean z10) {
        this.f9680a.setUseClientMode(z10);
    }

    @Override // javax.net.ssl.SSLSocket
    public final void setWantClientAuth(boolean z10) {
        this.f9680a.setWantClientAuth(z10);
    }

    @Override // java.net.Socket
    public final void shutdownInput() throws IOException {
        this.f9680a.shutdownInput();
    }

    @Override // java.net.Socket
    public final void shutdownOutput() throws IOException {
        this.f9680a.shutdownOutput();
    }

    @Override // javax.net.ssl.SSLSocket
    public final void startHandshake() throws IOException {
        this.f9680a.startHandshake();
    }

    @Override // javax.net.ssl.SSLSocket, java.net.Socket
    public final String toString() {
        return this.f9680a.toString();
    }
}
