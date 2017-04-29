package com.example.huangtao_gz.taoswiperrefreshlayout;

import java.util.List;

/**
 * Created by huangtao-gz on 2017/04/29.
 */

public class ResultDetailResult {

    /**
     * Code : 202
     * Message : {"info_hash":"f7c6739537e49bdd654a71c9c15bbcff8c03e188","category":"video","data_hash":"2de58d87a4d0e9951a95aae85e58c9bc","name":"The Meerkats [BDRip-720p] (www.kinokopilka.tv)","extension":".mkv","length":5669497122,"create_time":"2016-10-06 05:47:33","source_ip":"95.24.61.176","file":[{"path":"The Meerkats  [BDRip-720p] (www.kinokopilka.tv).mkv","length":5669462483},{"path":"The Meerkats  [BDRip-720p] (www.kinokopilka.tv).jpg","length":34238},{"path":"Внимание формат MKV.txt","length":247},{"path":"KinoKopilka.tv - Best Movies BitTorrent Network.url","length":154}]}
     * Script : 1
     */

    private String Code;
    private MessageBean Message;
    private String Script;

    public String getCode() {
        return Code;
    }

    public void setCode(String Code) {
        this.Code = Code;
    }

    public MessageBean getMessage() {
        return Message;
    }

    public void setMessage(MessageBean Message) {
        this.Message = Message;
    }

    public String getScript() {
        return Script;
    }

    public void setScript(String Script) {
        this.Script = Script;
    }

    public static class MessageBean {
        /**
         * info_hash : f7c6739537e49bdd654a71c9c15bbcff8c03e188
         * category : video
         * data_hash : 2de58d87a4d0e9951a95aae85e58c9bc
         * name : The Meerkats [BDRip-720p] (www.kinokopilka.tv)
         * extension : .mkv
         * length : 5669497122
         * create_time : 2016-10-06 05:47:33
         * source_ip : 95.24.61.176
         * file : [{"path":"The Meerkats  [BDRip-720p] (www.kinokopilka.tv).mkv","length":5669462483},{"path":"The Meerkats  [BDRip-720p] (www.kinokopilka.tv).jpg","length":34238},{"path":"Внимание формат MKV.txt","length":247},{"path":"KinoKopilka.tv - Best Movies BitTorrent Network.url","length":154}]
         */

        private String info_hash;
        private String category;
        private String data_hash;
        private String name;
        private String extension;
        private long length;
        private String create_time;
        private String source_ip;
        private List<FileBean> file;

        public String getInfo_hash() {
            return info_hash;
        }

        public void setInfo_hash(String info_hash) {
            this.info_hash = info_hash;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getData_hash() {
            return data_hash;
        }

        public void setData_hash(String data_hash) {
            this.data_hash = data_hash;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getExtension() {
            return extension;
        }

        public void setExtension(String extension) {
            this.extension = extension;
        }

        public long getLength() {
            return length;
        }

        public void setLength(long length) {
            this.length = length;
        }

        public String getCreate_time() {
            return create_time;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }

        public String getSource_ip() {
            return source_ip;
        }

        public void setSource_ip(String source_ip) {
            this.source_ip = source_ip;
        }

        public List<FileBean> getFile() {
            return file;
        }

        public void setFile(List<FileBean> file) {
            this.file = file;
        }

        public static class FileBean {
            /**
             * path : The Meerkats  [BDRip-720p] (www.kinokopilka.tv).mkv
             * length : 5669462483
             */

            private String path;
            private long length;

            public String getPath() {
                return path;
            }

            public void setPath(String path) {
                this.path = path;
            }

            public long getLength() {
                return length;
            }

            public void setLength(long length) {
                this.length = length;
            }
        }
    }
}
