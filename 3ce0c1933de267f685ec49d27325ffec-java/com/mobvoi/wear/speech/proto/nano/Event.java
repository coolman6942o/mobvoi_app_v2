package com.mobvoi.wear.speech.proto.nano;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.a;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.c;
import com.google.protobuf.nano.e;
import java.io.IOException;
import java.util.Arrays;
/* loaded from: classes2.dex */
public final class Event extends c {
    public static final int BEGIN_OF_SPEECH = 9;
    public static final int COMPANION = 2;
    public static final int DISPLAY_RESULT = 13;
    public static final int EMPTY_RESULT = 14;
    public static final int END_SESSION = 12;
    public static final int ERROR = 10;
    public static final int FINAL_TRANSCRIPTION = 6;
    public static final int HOME = 1;
    public static final int LOCAL_END_OF_SPEECH = 5;
    public static final int PARTIAL_TRANSCRIPTION = 4;
    public static final int REMOTE_END_OF_SPEECH = 15;
    public static final int SEARCH_RESULT = 7;
    public static final int START_SESSION = 1;
    public static final int START_TEXT_QUERY = 16;
    public static final int TRANSCRIPTION_RESULT = 11;
    public static final int UNKNOWN_SOURCE = 0;
    public static final int UNKNOWN_TYPE = 0;
    public static final int USER_CANCEL = 3;
    public static final int USER_STOP_AND_WAIT = 2;
    public static final int VOICE_ACTION_RESULT = 8;
    private static volatile Event[] _emptyArray;
    public byte[] data;
    public int source;
    public long time;
    public int type;

    public Event() {
        clear();
    }

    public static Event[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (b.f13297b) {
                if (_emptyArray == null) {
                    _emptyArray = new Event[0];
                }
            }
        }
        return _emptyArray;
    }

    public static Event parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (Event) c.mergeFrom(new Event(), bArr);
    }

    public Event clear() {
        this.source = 0;
        this.time = 0L;
        this.type = 0;
        this.data = e.f13298a;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.c
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize() + CodedOutputByteBufferNano.h(1, this.source) + CodedOutputByteBufferNano.j(2, this.time) + CodedOutputByteBufferNano.h(3, this.type);
        return !Arrays.equals(this.data, e.f13298a) ? computeSerializedSize + CodedOutputByteBufferNano.d(4, this.data) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.c
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.M(1, this.source);
        codedOutputByteBufferNano.O(2, this.time);
        codedOutputByteBufferNano.M(3, this.type);
        if (!Arrays.equals(this.data, e.f13298a)) {
            codedOutputByteBufferNano.I(4, this.data);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static Event parseFrom(a aVar) throws IOException {
        return new Event().mergeFrom(aVar);
    }

    @Override // com.google.protobuf.nano.c
    public Event mergeFrom(a aVar) throws IOException {
        while (true) {
            int v10 = aVar.v();
            if (v10 == 0) {
                return this;
            }
            if (v10 == 8) {
                int k10 = aVar.k();
                if (k10 == 0 || k10 == 1 || k10 == 2) {
                    this.source = k10;
                }
            } else if (v10 == 16) {
                this.time = aVar.l();
            } else if (v10 == 24) {
                int k11 = aVar.k();
                switch (k11) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                    case 16:
                        this.type = k11;
                        continue;
                }
            } else if (v10 == 34) {
                this.data = aVar.i();
            } else if (!e.e(aVar, v10)) {
                return this;
            }
        }
    }
}
