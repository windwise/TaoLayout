package com.example.huangtao_gz.taoswiperrefreshlayout;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ScrollingActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        new NetWorkAsyncTask("Search").execute("Android");
    }

    //从InputStream中读取数据，转换成byte数组，最后关闭InputStream
    private byte[] getBytesByInputStream(InputStream is) {
        byte[] bytes = null;
        BufferedInputStream bis = new BufferedInputStream(is);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        BufferedOutputStream bos = new BufferedOutputStream(baos);
        byte[] buffer = new byte[1024 * 8];
        int length;
        try {
            while ((length = bis.read(buffer)) > 0) {
                bos.write(buffer, 0, length);
            }
            bos.flush();
            bytes = baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return bytes;
    }

    class NetWorkAsyncTask extends AsyncTask<String, Integer, String> {
        private String requestType;

        NetWorkAsyncTask(String requestType) {
            this.requestType = requestType;
        }

        /**
         * Override this method to perform a computation on a background thread. The
         * specified parameters are the parameters passed to {@link #execute}
         * by the caller of this task.
         * <p>
         * This method can call {@link #publishProgress} to publish updates
         * on the UI thread.
         *
         * @param params The parameters of the task.
         * @return A result, defined by the subclass of this task.
         * @see #onPreExecute()
         * @see #onPostExecute
         * @see #publishProgress
         */
        @Override
        protected String doInBackground(String... params) {
            switch (requestType) {
                case "Search":
                    return executeUrlConnection("http://www.ydo.tv/open/api/v1/dht?keyword=" + params[0] + "&p=1&Ex[]=.mp4&Ex[]=.mkv&Ex[]=.rmvb&Ex[]=.avi&Ex[]=.mov&Ex[]=.wmv");
                case "GET_DETAIL_INFO":
                    return executeUrlConnection("http://www.ydo.tv/open/api/v1/file?YdoID=" + params[0]);
                default:
                    return null;
            }
        }

        private String executeUrlConnection(String urlString) {
            String result;
            try {
                URL url = new URL(urlString);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.connect();
                InputStream is = connection.getInputStream();
                result = new String(getBytesByInputStream(is));
            } catch (IOException e) {
                result = null;
            }
            return result;
        }

        /**
         * <p>Runs on the UI thread after {@link #doInBackground}. The
         * specified result is the value returned by {@link #doInBackground}.</p>
         * <p>
         * <p>This method won't be invoked if the task was cancelled.</p>
         *
         * @param s The result of the operation computed by {@link #doInBackground}.
         * @see #onPreExecute
         * @see #doInBackground
         * @see #onCancelled(Object)
         */
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            switch (requestType) {
                case "Search":
                    SearchResult searResult = new Gson().fromJson(s, SearchResult.class);
                    Log.d("测试HT1", searResult.getCode() + ",文件个数" + searResult.getMessage().size());
                    if (searResult.getCode().equals("202") && searResult.getMessage().size() > 0) {
                        new NetWorkAsyncTask("GET_DETAIL_INFO").execute(searResult.getMessage().get(0).getYdoID());
                    }

                    break;
                case "GET_DETAIL_INFO":
                    ResultDetailResult detailResult = new Gson().fromJson(s, ResultDetailResult.class);
                    ResultDetailResult.MessageBean message = detailResult.getMessage();
                    String magnetUrl = "magnet:?" + "dn=" + message.getName() + message.getExtension() + "&xl=" + message.getLength() + "&xt=urn:sha1:" + message.getInfo_hash();
                    Log.d("测试HT2", magnetUrl);
                    break;
            }

        }
    }
}
