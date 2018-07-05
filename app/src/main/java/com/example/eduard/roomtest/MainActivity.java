package com.example.eduard.roomtest;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyTask task = new MyTask();
        task.execute();
    }

    public static class MyDataModel {
        public String key;
        public String message;
    }

    private static class MyTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            String dataId = "some-data-id";
            String key = "some-key";
            String message = "some-message";

            MyData myData = MyData.Companion.create(dataId, key, message);

            MyDataDao dao = MyApp.getDb().myDataDao();
            dao.put(myData);

            List<MyDataModel> gotData = dao.getList(dataId, "%key%");
            for (MyDataModel data : gotData) {
                Log.e("test", "data: " + data.message);
            }

            gotData = dao.getListOrig(dataId, "%key%");
            for (MyDataModel data : gotData) {
                Log.e("test", "data: " + data.message);
            }

            return null;
        }
    }
}
