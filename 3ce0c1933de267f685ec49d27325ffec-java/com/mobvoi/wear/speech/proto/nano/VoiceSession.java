package com.mobvoi.wear.speech.proto.nano;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.a;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.c;
import com.google.protobuf.nano.e;
import java.io.IOException;
/* loaded from: classes2.dex */
public final class VoiceSession extends c {
    public static final int GESTURE = 5;
    public static final int HELP_LIST = 4;
    public static final int HOTWORD = 1;
    public static final int RETRY = 3;
    public static final int SWIPE = 2;
    public static final int UNKNOWN_TYPE = 0;
    public static final int USER_CLICK = 6;
    public static final int VOICE_INPUT = 7;
    private static volatile VoiceSession[] _emptyArray;
    public Event[] events;

    /* renamed from: id  reason: collision with root package name */
    public int f20961id;
    public long messageIdLsb;
    public long messageIdMsb;
    public NetworkInfo phoneNetworkInfo;
    public int triggerType;
    public NetworkInfo watchNetworkInfo;

    public VoiceSession() {
        clear();
    }

    public static VoiceSession[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (b.f13297b) {
                if (_emptyArray == null) {
                    _emptyArray = new VoiceSession[0];
                }
            }
        }
        return _emptyArray;
    }

    public static VoiceSession parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (VoiceSession) c.mergeFrom(new VoiceSession(), bArr);
    }

    public VoiceSession clear() {
        this.f20961id = 0;
        this.triggerType = 0;
        this.events = Event.emptyArray();
        this.messageIdLsb = 0L;
        this.messageIdMsb = 0L;
        this.watchNetworkInfo = null;
        this.phoneNetworkInfo = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.c
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize() + CodedOutputByteBufferNano.h(1, this.f20961id);
        int i10 = this.triggerType;
        if (i10 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.h(2, i10);
        }
        Event[] eventArr = this.events;
        if (eventArr != null && eventArr.length > 0) {
            int i11 = 0;
            while (true) {
                Event[] eventArr2 = this.events;
                if (i11 >= eventArr2.length) {
                    break;
                }
                Event event = eventArr2[i11];
                if (event != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.l(3, event);
                }
                i11++;
            }
        }
        long j10 = this.messageIdLsb;
        if (j10 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.p(4, j10);
        }
        long j11 = this.messageIdMsb;
        if (j11 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.p(5, j11);
        }
        NetworkInfo networkInfo = this.watchNetworkInfo;
        if (networkInfo != null) {
            computeSerializedSize += CodedOutputByteBufferNano.l(6, networkInfo);
        }
        NetworkInfo networkInfo2 = this.phoneNetworkInfo;
        return networkInfo2 != null ? computeSerializedSize + CodedOutputByteBufferNano.l(7, networkInfo2) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.c
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.M(1, this.f20961id);
        int i10 = this.triggerType;
        if (i10 != 0) {
            codedOutputByteBufferNano.M(2, i10);
        }
        Event[] eventArr = this.events;
        if (eventArr != null && eventArr.length > 0) {
            int i11 = 0;
            while (true) {
                Event[] eventArr2 = this.events;
                if (i11 >= eventArr2.length) {
                    break;
                }
                Event event = eventArr2[i11];
                if (event != null) {
                    codedOutputByteBufferNano.Q(3, event);
                }
                i11++;
            }
        }
        long j10 = this.messageIdLsb;
        if (j10 != 0) {
            codedOutputByteBufferNano.Z(4, j10);
        }
        long j11 = this.messageIdMsb;
        if (j11 != 0) {
            codedOutputByteBufferNano.Z(5, j11);
        }
        NetworkInfo networkInfo = this.watchNetworkInfo;
        if (networkInfo != null) {
            codedOutputByteBufferNano.Q(6, networkInfo);
        }
        NetworkInfo networkInfo2 = this.phoneNetworkInfo;
        if (networkInfo2 != null) {
            codedOutputByteBufferNano.Q(7, networkInfo2);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static VoiceSession parseFrom(a aVar) throws IOException {
        return new VoiceSession().mergeFrom(aVar);
    }

    @Override // com.google.protobuf.nano.c
    public VoiceSession mergeFrom(a aVar) throws IOException {
        while (true) {
            int v10 = aVar.v();
            if (v10 == 0) {
                return this;
            }
            if (v10 == 8) {
                this.f20961id = aVar.k();
            } else if (v10 == 16) {
                int k10 = aVar.k();
                switch (k10) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                        this.triggerType = k10;
                        continue;
                }
            } else if (v10 == 26) {
                int a10 = e.a(aVar, 26);
                Event[] eventArr = this.events;
                int length = eventArr == null ? 0 : eventArr.length;
                int i10 = a10 + length;
                Event[] eventArr2 = new Event[i10];
                if (length != 0) {
                    System.arraycopy(eventArr, 0, eventArr2, 0, length);
                }
                while (length < i10 - 1) {
                    eventArr2[length] = new Event();
                    aVar.m(eventArr2[length]);
                    aVar.v();
                    length++;
                }
                eventArr2[length] = new Event();
                aVar.m(eventArr2[length]);
                this.events = eventArr2;
            } else if (v10 == 32) {
                this.messageIdLsb = aVar.t();
            } else if (v10 == 40) {
                this.messageIdMsb = aVar.t();
            } else if (v10 == 50) {
                if (this.watchNetworkInfo == null) {
                    this.watchNetworkInfo = new NetworkInfo();
                }
                aVar.m(this.watchNetworkInfo);
            } else if (v10 == 58) {
                if (this.phoneNetworkInfo == null) {
                    this.phoneNetworkInfo = new NetworkInfo();
                }
                aVar.m(this.phoneNetworkInfo);
            } else if (!e.e(aVar, v10)) {
                return this;
            }
        }
    }
}
