package com.example.english;

import android.os.Bundle;
import android.content.Intent;
import android.media.MediaPlayer;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button Login, Register;
    EditText Email, Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Register = findViewById(R.id.DangKy);
        Login = findViewById(R.id.DangNhap);
        Email = findViewById(R.id.Email);
        Password = findViewById(R.id.Password);  // Initialize Password here

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    private void login() {
        String email = Email.getText().toString();
        String pass = Password.getText().toString();

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Vui lòng nhập Email!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(pass)) {
            Toast.makeText(this, "Vui lòng nhập Password!", Toast.LENGTH_SHORT).show();
            return;
        }

        // Sử dụng SQLiteHelper để kiểm tra thông tin đăng nhập
        SQLiteHelper dbHelper = new SQLiteHelper(this);
        if (dbHelper.checkUser(email, pass)) {
            Toast.makeText(this, "Đăng nhập thành công!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, correctword.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Sai thông tin đăng nhập!", Toast.LENGTH_SHORT).show();
        }

        // Here you can add code for login logic, like using Firebase Authentication
    }
}
