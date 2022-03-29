package com.android.s19110227;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    int REQUEST_CODE_CAMERA = 1111;
    TextView txtSoTienLai, txtTongTien;
    Button btnTakeAPic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        txtSoTienLai = (TextView) findViewById(R.id.textViewSoTienLai);
        txtTongTien = (TextView) findViewById(R.id.textViewTongTien);
        btnTakeAPic = (Button) findViewById(R.id.buttonTakeAPicture);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("result");

        double soTienGui = bundle.getDouble("tiengui");
        double laiSuat = bundle.getDouble("laisuat");
        double kyHan = bundle.getDouble("kyhan");

        double TienLai = (soTienGui * laiSuat * kyHan * 30) / 36000;
        double TongTien = TienLai + soTienGui;
        txtSoTienLai.setText(TienLai + getString(R.string.vnd));
        txtTongTien.setText(TongTien + getString(R.string.vnd));

        btnTakeAPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentCam = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intentCam, REQUEST_CODE_CAMERA);
                finish();
            }
        });
    }
}
