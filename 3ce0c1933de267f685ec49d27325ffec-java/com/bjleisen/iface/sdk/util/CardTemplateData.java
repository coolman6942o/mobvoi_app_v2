package com.bjleisen.iface.sdk.util;

import java.util.List;
/* loaded from: classes.dex */
public class CardTemplateData {
    private List<ApdusBean> apdus;

    /* loaded from: classes.dex */
    public static class ApdusBean {
        private String apdu;
        private int index;
        private boolean isInterruptedNextApdu;
        private List<ParserTemplateBean> parserTemplate;
        private String sw;

        /* loaded from: classes.dex */
        public static class ParserTemplateBean {
            private String functionDesc;
            private String functionName;
            private ParserMethodBean parserMethod;
            private SubDatasBean subDatas;
            private String swReferData;

            /* loaded from: classes.dex */
            public static class ParserMethodBean {
                private boolean isTransferDecimalSystem;
                private boolean isTransferLittleEndian;

                public boolean isTransferDecimalSystem() {
                    return this.isTransferDecimalSystem;
                }

                public boolean isTransferLittleEndian() {
                    return this.isTransferLittleEndian;
                }

                public void setIsTransferDecimalSystem(boolean z10) {
                    this.isTransferDecimalSystem = z10;
                }

                public void setIsTransferLittleEndian(boolean z10) {
                    this.isTransferLittleEndian = z10;
                }
            }

            /* loaded from: classes.dex */
            public static class SubDatasBean {
                private int endIndex;
                private int startIndex;

                public int getEndIndex() {
                    return this.endIndex;
                }

                public int getStartIndex() {
                    return this.startIndex;
                }

                public void setEndIndex(int i10) {
                    this.endIndex = i10;
                }

                public void setStartIndex(int i10) {
                    this.startIndex = i10;
                }
            }

            public String getFunctionDesc() {
                return this.functionDesc;
            }

            public String getFunctionName() {
                return this.functionName;
            }

            public ParserMethodBean getParserMethod() {
                return this.parserMethod;
            }

            public SubDatasBean getSubDatas() {
                return this.subDatas;
            }

            public String getSwReferData() {
                return this.swReferData;
            }

            public void setFunctionDesc(String str) {
                this.functionDesc = str;
            }

            public void setFunctionName(String str) {
                this.functionName = str;
            }

            public void setParserMethod(ParserMethodBean parserMethodBean) {
                this.parserMethod = parserMethodBean;
            }

            public void setSubDatas(SubDatasBean subDatasBean) {
                this.subDatas = subDatasBean;
            }

            public void setSwReferData(String str) {
                this.swReferData = str;
            }
        }

        public String getApdu() {
            return this.apdu;
        }

        public int getIndex() {
            return this.index;
        }

        public List<ParserTemplateBean> getParserTemplate() {
            return this.parserTemplate;
        }

        public String getSw() {
            return this.sw;
        }

        public boolean isInterruptedNextApdu() {
            return this.isInterruptedNextApdu;
        }

        public void setApdu(String str) {
            this.apdu = str;
        }

        public void setIndex(int i10) {
            this.index = i10;
        }

        public void setInterruptedNextApdu(boolean z10) {
            this.isInterruptedNextApdu = z10;
        }

        public void setParserTemplate(List<ParserTemplateBean> list) {
            this.parserTemplate = list;
        }

        public void setSw(String str) {
            this.sw = str;
        }
    }

    public List<ApdusBean> getApdus() {
        return this.apdus;
    }

    public void setApdus(List<ApdusBean> list) {
        this.apdus = list;
    }
}
