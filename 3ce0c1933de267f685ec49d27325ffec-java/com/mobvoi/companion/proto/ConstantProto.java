package com.mobvoi.companion.proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.m0;
import com.google.protobuf.o;
import com.google.protobuf.q;
import com.google.protobuf.u;
/* loaded from: classes2.dex */
public final class ConstantProto {
    private static Descriptors.FileDescriptor descriptor;

    /* loaded from: classes2.dex */
    public enum DeviceType implements m0 {
        UNKNOWN_DEVICE_TYPE(0),
        TIC_WATCH(1),
        TIC_MIRROR(2),
        TIC_HOME(3),
        TIC_ASSISTANT(4),
        TIC_ASSISTANT_IOS(5),
        TIC_HOME_MINI(6),
        TIC_PODS(7),
        TIC_BAND(8),
        TIC_KIDS(9),
        TIC_LIFE(10),
        TIC_ASSISTANT_OEM(11),
        TIC_KIDS_ON_TIC_WATCH(12),
        TIC_MEET(13),
        MOBVOI_AIRECORDER(14),
        MOBVOI_AISPEAKERPHONE(15),
        UNRECOGNIZED(-1);
        
        public static final int MOBVOI_AIRECORDER_VALUE = 14;
        public static final int MOBVOI_AISPEAKERPHONE_VALUE = 15;
        public static final int TIC_ASSISTANT_IOS_VALUE = 5;
        public static final int TIC_ASSISTANT_OEM_VALUE = 11;
        public static final int TIC_ASSISTANT_VALUE = 4;
        public static final int TIC_BAND_VALUE = 8;
        public static final int TIC_HOME_MINI_VALUE = 6;
        public static final int TIC_HOME_VALUE = 3;
        public static final int TIC_KIDS_ON_TIC_WATCH_VALUE = 12;
        public static final int TIC_KIDS_VALUE = 9;
        public static final int TIC_LIFE_VALUE = 10;
        public static final int TIC_MEET_VALUE = 13;
        public static final int TIC_MIRROR_VALUE = 2;
        public static final int TIC_PODS_VALUE = 7;
        public static final int TIC_WATCH_VALUE = 1;
        public static final int UNKNOWN_DEVICE_TYPE_VALUE = 0;
        private final int value;
        private static final u.b<DeviceType> internalValueMap = new u.b<DeviceType>() { // from class: com.mobvoi.companion.proto.ConstantProto.DeviceType.1
            public DeviceType findValueByNumber(int i10) {
                return DeviceType.forNumber(i10);
            }
        };
        private static final DeviceType[] VALUES = values();

        DeviceType(int i10) {
            this.value = i10;
        }

        public static DeviceType forNumber(int i10) {
            switch (i10) {
                case 0:
                    return UNKNOWN_DEVICE_TYPE;
                case 1:
                    return TIC_WATCH;
                case 2:
                    return TIC_MIRROR;
                case 3:
                    return TIC_HOME;
                case 4:
                    return TIC_ASSISTANT;
                case 5:
                    return TIC_ASSISTANT_IOS;
                case 6:
                    return TIC_HOME_MINI;
                case 7:
                    return TIC_PODS;
                case 8:
                    return TIC_BAND;
                case 9:
                    return TIC_KIDS;
                case 10:
                    return TIC_LIFE;
                case 11:
                    return TIC_ASSISTANT_OEM;
                case 12:
                    return TIC_KIDS_ON_TIC_WATCH;
                case 13:
                    return TIC_MEET;
                case 14:
                    return MOBVOI_AIRECORDER;
                case 15:
                    return MOBVOI_AISPEAKERPHONE;
                default:
                    return null;
            }
        }

        public static final Descriptors.d getDescriptor() {
            return ConstantProto.getDescriptor().i().get(0);
        }

        public static u.b<DeviceType> internalGetValueMap() {
            return internalValueMap;
        }

        public final Descriptors.d getDescriptorForType() {
            return getDescriptor();
        }

        @Override // com.google.protobuf.u.a
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        public final Descriptors.e getValueDescriptor() {
            return getDescriptor().i().get(ordinal());
        }

        @Deprecated
        public static DeviceType valueOf(int i10) {
            return forNumber(i10);
        }

        public static DeviceType valueOf(Descriptors.e eVar) {
            if (eVar.g() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            } else if (eVar.f() == -1) {
                return UNRECOGNIZED;
            } else {
                return VALUES[eVar.f()];
            }
        }
    }

    static {
        Descriptors.FileDescriptor.q(new String[]{"\n\u000fconstants.proto\u0012\u001acom.mobvoi.companion.proto*¹\u0002\n\nDeviceType\u0012\u0017\n\u0013UNKNOWN_DEVICE_TYPE\u0010\u0000\u0012\r\n\tTIC_WATCH\u0010\u0001\u0012\u000e\n\nTIC_MIRROR\u0010\u0002\u0012\f\n\bTIC_HOME\u0010\u0003\u0012\u0011\n\rTIC_ASSISTANT\u0010\u0004\u0012\u0015\n\u0011TIC_ASSISTANT_IOS\u0010\u0005\u0012\u0011\n\rTIC_HOME_MINI\u0010\u0006\u0012\f\n\bTIC_PODS\u0010\u0007\u0012\f\n\bTIC_BAND\u0010\b\u0012\f\n\bTIC_KIDS\u0010\t\u0012\f\n\bTIC_LIFE\u0010\n\u0012\u0015\n\u0011TIC_ASSISTANT_OEM\u0010\u000b\u0012\u0019\n\u0015TIC_KIDS_ON_TIC_WATCH\u0010\f\u0012\f\n\bTIC_MEET\u0010\r\u0012\u0015\n\u0011MOBVOI_AIRECORDER\u0010\u000e\u0012\u0019\n\u0015MOBVOI_AISPEAKERPHONE\u0010\u000fB\u000fB\rConstantProtob\u0006proto3"}, new Descriptors.FileDescriptor[0], new Descriptors.FileDescriptor.a() { // from class: com.mobvoi.companion.proto.ConstantProto.1
            @Override // com.google.protobuf.Descriptors.FileDescriptor.a
            public o assignDescriptors(Descriptors.FileDescriptor fileDescriptor) {
                Descriptors.FileDescriptor unused = ConstantProto.descriptor = fileDescriptor;
                return null;
            }
        });
    }

    private ConstantProto() {
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    public static void registerAllExtensions(o oVar) {
        registerAllExtensions((q) oVar);
    }

    public static void registerAllExtensions(q qVar) {
    }
}
