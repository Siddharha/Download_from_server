package com.creativelizard.siddhartha.intro;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.webkit.URLUtil;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnDownload;
    private String myUrl = "http://pluto.androidapksfree.com/mamba/com.duolingo_v3.14.2-250_Android-4.3.apk";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
        onClick();
    }

    private void initialize() {
        btnDownload = (Button)findViewById(R.id.btnDownload);
    }

    private void onClick() {
        btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DownloadManager.Request r = new DownloadManager.Request(Uri.parse(myUrl));
                r.setTitle("Downloading...");
                r.allowScanningByMediaScanner();
                r.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE);
                String fileName = URLUtil.guessFileName(myUrl,null, MimeTypeMap.getFileExtensionFromUrl(myUrl));
                r.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,fileName);

                DownloadManager d = (DownloadManager)getSystemService(Context.DOWNLOAD_SERVICE);
                d.enqueue(r);

            }
        });
    }
}
