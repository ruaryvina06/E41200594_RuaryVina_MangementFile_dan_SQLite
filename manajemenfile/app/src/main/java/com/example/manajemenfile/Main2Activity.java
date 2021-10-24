package com.example.manajemenfile;

import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Main2Activity extends AppCompatActivity{
    TextView showText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        showText = (TextView) findViewById(R.id.getText);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void getPublic(View view) {
        String folder = Environment.getExternalStorageState(new File(Environment.DIRECTORY_DOWNLOADS));
        File myFile = new File(folder,"myData1.txt");
        String text = getData(myFile);
        if (text != null) {
            showText.setText(text);
        }else {
            showText.setText("No Data");
        }
    }

    public void getPrivate(View view) {
        File folder = getExternalFilesDir("arvita");
        File myFile = new File(folder, "myData2.txt");
        String text = getData(myFile);
        if (text != null) {
            showText.setText(text);
        }else {
            showText.setText("No Data");
        }
    }



    private String getData(File myFile) {
        FileInputStream fileInputStream = null;
        try {
            String myfile = null;
            fileInputStream = new FileInputStream(myfile);
            int i =-1;
            StringBuffer buffer = new StringBuffer();
            while ((i = fileInputStream.read()) != -1) {
                buffer.append((char) i);
            }
            return buffer.toString();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
