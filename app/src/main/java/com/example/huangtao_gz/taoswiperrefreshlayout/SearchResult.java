package com.example.huangtao_gz.taoswiperrefreshlayout;

import java.util.List;

/**
 * Created by huangtao-gz on 2017/04/29.
 */

public class SearchResult {
    private String Code;
    private List<ResultInfo> Message;

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public List<ResultInfo> getMessage() {
        return Message;
    }

    public void setMessage(List<ResultInfo> message) {
        Message = message;
    }

    @Override
    public String toString() {
        return "SearchResult{" +
                "Code='" + Code + '\'' +
                ", Message=" + Message +
                '}';
    }

    public static class ResultInfo {
        private String title;
        private String FileSize;
        private String FileFormat;
        private String YdoID;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getFileSize() {
            return FileSize;
        }

        public void setFileSize(String fileSize) {
            FileSize = fileSize;
        }

        public String getFileFormat() {
            return FileFormat;
        }

        public void setFileFormat(String fileFormat) {
            FileFormat = fileFormat;
        }

        public String getYdoID() {
            return YdoID;
        }

        public void setYdoID(String ydoID) {
            YdoID = ydoID;
        }

        @Override
        public String toString() {
            return "ResultInfo{" +
                    "title='" + title + '\'' +
                    ", FileSize='" + FileSize + '\'' +
                    ", FileFormat='" + FileFormat + '\'' +
                    ", YdoID='" + YdoID + '\'' +
                    '}';
        }
    }
}
