package MuhammadArasy.UTS.mydataapp;

public class UserData {
    private String nim;
    private String nama;
    private String prodi;
    private String kelas;
    private String alamat;
    private String email;

    public UserData(String nim, String nama, String prodi, String kelas, String alamat, String email) {
        this.nim = nim;
        this.nama = nama;
        this.prodi = prodi;
        this.kelas = kelas;
        this.alamat = alamat;
        this.email = email;
    }

    public String getNim() { return nim; }
    public String getNama() { return nama; }
    public String getProdi() { return prodi; }
    public String getKelas() { return kelas; }
    public String getAlamat() { return alamat; }
    public String getEmail() { return email; }
}