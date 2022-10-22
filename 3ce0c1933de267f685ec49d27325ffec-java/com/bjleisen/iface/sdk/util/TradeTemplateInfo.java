package com.bjleisen.iface.sdk.util;

import java.util.List;
/* loaded from: classes.dex */
public class TradeTemplateInfo {
    private List<ApdusBean> apdus;
    private ParserTemplateBean parserTemplate;

    /* loaded from: classes.dex */
    public static class ApdusBean {
        private String apdu;
        private int index;
        private String sw;

        public String getApdu() {
            return this.apdu;
        }

        public int getIndex() {
            return this.index;
        }

        public String getSw() {
            return this.sw;
        }

        public void setApdu(String str) {
            this.apdu = str;
        }

        public void setIndex(int i10) {
            this.index = i10;
        }

        public void setSw(String str) {
            this.sw = str;
        }
    }

    /* loaded from: classes.dex */
    public static class ParserTemplateBean {
        private int apduEndIndex;
        private int apduStartIndex;
        private String functionDesc;
        private String functionName;
        private List<SubDatasBean> subDatas;

        /* loaded from: classes.dex */
        public static class SubDatasBean {
            private int endIndex;
            private String functionDesc;
            private String functionName;
            private ParserMethodBean parserMethod;
            private int startIndex;

            /* loaded from: classes.dex */
            public static class ParserMethodBean {
                private boolean isTransferDecimalSystem;

                public boolean isIsTransferDecimalSystem() {
                    return this.isTransferDecimalSystem;
                }

                public void setIsTransferDecimalSystem(boolean z10) {
                    this.isTransferDecimalSystem = z10;
                }
            }

            public int getEndIndex() {
                return this.endIndex;
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

            public int getStartIndex() {
                return this.startIndex;
            }

            public void setEndIndex(int i10) {
                this.endIndex = i10;
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

            public void setStartIndex(int i10) {
                this.startIndex = i10;
            }
        }

        public int getApduEndIndex() {
            return this.apduEndIndex;
        }

        public int getApduStartIndex() {
            return this.apduStartIndex;
        }

        public String getFunctionDesc() {
            return this.functionDesc;
        }

        public String getFunctionName() {
            return this.functionName;
        }

        public List<SubDatasBean> getSubDatas() {
            return this.subDatas;
        }

        public void setApduEndIndex(int i10) {
            this.apduEndIndex = i10;
        }

        public void setApduStartIndex(int i10) {
            this.apduStartIndex = i10;
        }

        public void setFunctionDesc(String str) {
            this.functionDesc = str;
        }

        public void setFunctionName(String str) {
            this.functionName = str;
        }

        public void setSubDatas(List<SubDatasBean> list) {
            this.subDatas = list;
        }
    }

    public List<ApdusBean> getApdus() {
        return this.apdus;
    }

    public ParserTemplateBean getParserTemplate() {
        return this.parserTemplate;
    }

    public void setApdus(List<ApdusBean> list) {
        this.apdus = list;
    }

    public void setParserTemplate(ParserTemplateBean parserTemplateBean) {
        this.parserTemplate = parserTemplateBean;
    }
}
