package com.android.s19110227;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtTienGui, edtLaiSuat, edtKyHan;
    Button btnKetQua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();

        btnKetQua.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if (edtTienGui.getText().length() == 0 || edtLaiSuat.getText().length() == 0
                        || edtKyHan.getText().length() == 0) {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                } else {
                    double soTienGui = Double.parseDouble(edtTienGui.getText().toString());
                    double laiSuat = Double.parseDouble(edtLaiSuat.getText().toString());
                    double kyHan = Double.parseDouble(edtKyHan.getText().toString());

                    Intent intentResult = new Intent(MainActivity.this, MainActivity2.class);
                    Bundle bundle = new Bundle();
                    bundle.putDouble("tiengui", soTienGui);
                    bundle.putDouble("laisuat", laiSuat);
                    bundle.putDouble("kyhan", kyHan);
                    intentResult.putExtra("result", bundle);
                    startActivity(intentResult);
                }
            }
        });
    }

    private void AnhXa() {
        edtTienGui = (EditText) findViewById(R.id.editTextSoTienGui);
        edtLaiSuat = (EditText) findViewById(R.id.editTextLaiSuat);
        edtKyHan = (EditText) findViewById(R.id.editTextKyHanGui);
        btnKetQua = (Button) findViewById(R.id.buttonKetQua);
    }


}