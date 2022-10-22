package com.tendcloud.tenddata;
/* compiled from: td */
/* loaded from: classes2.dex */
public class af {

    /* compiled from: td */
    /* loaded from: classes2.dex */
    public enum Gender {
        UNKNOW(0),
        MALE(1),
        FEMALE(2);
        
        private final int index;

        Gender(int i10) {
            this.index = i10;
        }

        public int index() {
            return this.index;
        }
    }

    /* compiled from: td */
    /* loaded from: classes2.dex */
    public enum ProfileType {
        ANONYMOUS(0),
        REGISTERED(1),
        SINA_WEIBO(2),
        QQ(3),
        QQ_WEIBO(4),
        ND91(5),
        WEIXIN(6),
        TYPE1(11),
        TYPE2(12),
        TYPE3(13),
        TYPE4(14),
        TYPE5(15),
        TYPE6(16),
        TYPE7(17),
        TYPE8(18),
        TYPE9(19),
        TYPE10(20);
        
        private final int index;

        ProfileType(int i10) {
            this.index = i10;
        }

        public int index() {
            return this.index;
        }
    }
}
