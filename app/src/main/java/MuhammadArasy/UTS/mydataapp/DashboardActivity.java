package MuhammadArasy.UTS.mydataapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class DashboardActivity extends AppCompatActivity {

    private EditText etNim, etNama, etProdi, etKelas, etAlamat, etEmail;
    private ListView lvData;
    private ArrayList<UserData> dataList;
    private DataAdapter adapter;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);

        etNim = findViewById(R.id.etNim);
        etNama = findViewById(R.id.etNama);
        etProdi = findViewById(R.id.etProdi);
        etKelas = findViewById(R.id.etKelas);
        etAlamat = findViewById(R.id.etAlamat);
        etEmail = findViewById(R.id.etEmail);
        lvData = findViewById(R.id.lvData);
        Button btnTambah = findViewById(R.id.btnTambah);
        Button btnLogout = findViewById(R.id.btnLogout);

        dataList = new ArrayList<>();
        adapter = new DataAdapter(this, dataList);
        lvData.setAdapter(adapter);

        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tambahData();
            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });
    }

    private void tambahData() {
        String nim = etNim.getText().toString().trim();
        String nama = etNama.getText().toString().trim();
        String prodi = etProdi.getText().toString().trim();
        String kelas = etKelas.getText().toString().trim();
        String alamat = etAlamat.getText().toString().trim();
        String email = etEmail.getText().toString().trim();

        if (nim.isEmpty() || nama.isEmpty() || prodi.isEmpty() || kelas.isEmpty() || alamat.isEmpty() || email.isEmpty()) {
            Toast.makeText(this, "Harap isi semua field", Toast.LENGTH_SHORT).show();
            return;
        }

        UserData newData = new UserData(nim, nama, prodi, kelas, alamat, email);
        dataList.add(newData);
        adapter.notifyDataSetChanged();

        // Clear input fields
        etNim.setText("");
        etNama.setText("");
        etProdi.setText("");
        etKelas.setText("");
        etAlamat.setText("");
        etEmail.setText("");

        Toast.makeText(this, "Data berhasil ditambahkan", Toast.LENGTH_SHORT).show();
    }

    private void logout() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("isLoggedIn", false);
        editor.apply();

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}