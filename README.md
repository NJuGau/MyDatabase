Dokumentasi Tugas Tambahan
Mobile Programming
Nama	: Nathanael Juan Gauthama
NIM	: 2501967253
Kelas	: LK01

MyDatabase
MyDatabase adalah sebuah aplikasi untuk menyimpan dan melihat informasi mahasiswa dalam database serta melihat informasi mengenai Binus Alam Sutera.
Adapun aplikasi MyDatabase terdiri dari 3 activity:
1.	Input Activity
Pada activity input, user dapat memasukkan data mahasiswa ke dalam database. Adapun data yang dimasukkan antara lain: nama, NIM, email, dan nomor telepon. Dalam pengisian data, terdapat beberapa validasi data yang harus dipenuhi, seperti:
-	Nama: Harus diisi
-	NIM: Harus diisi, harus berupa angka
-	Email: Harus diisi, harus berakhiran ‘@binus.ac.id’
-	Nomor telepon: Harus diisi, harus berupa angka, dan harus memiliki panjang minimal 6 karakter / digit.
-	Sistem juga akan mendeteksi ketika terjadi kesalahan dalam database.
Setelah memasukkan informasi tersebut, user dapat menekan tombol ‘save’ untuk menyimpan data ke dalam database.
Database yang digunakan adalah SQLite dengan nama ‘mydatabasedb’. Database dihubungkan dengan menggunakan class SQLiteHelper. Data kemudian disimpan dalam table yang bernama ‘msstudent’.
Tampilan kosong form input:
![image](https://github.com/NJuGau/MyDatabase/assets/102814657/48485d60-f4d4-487b-ad63-3d6c9a8d6e99)

Tampilan form terisi:
![image](https://github.com/NJuGau/MyDatabase/assets/102814657/174d46f6-9dca-45b5-a788-7e0c488584ec)

Tampilan data berhasil masuk ke dalam database:
![image](https://github.com/NJuGau/MyDatabase/assets/102814657/6f0ad22d-bb35-4fbb-87da-ef088261c09c)

Tampilan contoh validasi data gagal:
![image](https://github.com/NJuGau/MyDatabase/assets/102814657/ebfdf562-48f0-4f39-aa7b-d13dc9eaa32a)

2.	View Activity
Pada activity view, user dapat melihat kumpulan data yang telah dimasukkan ke dalam database sebelumnya. User dapat melakukan scroll bila data melebihi Panjang screen. Dalam hal ini, data ditampilkan dengan menggunakan recycler view dan ditampung di dalam class StudentAdapter. Bila table dalam database masih kosong, maka akan ditampilkan list kosong.
Tampilan view bila data kosong:
![image](https://github.com/NJuGau/MyDatabase/assets/102814657/9aa182ef-f54e-4aa2-898b-3fc8f19df906)

Tampilan view ketika terdapat data:
![image](https://github.com/NJuGau/MyDatabase/assets/102814657/d30a1ea9-dc10-4081-a42d-4d059e96e457)

4.	About Us Activity
Pada about us activity, user dapat melihat gambar dan informasi dari Binus University @ Alam Sutera Campus. User dapat melihat gambar, nama, dan alamat dari universitas.
Tampilan about us activity:
![image](https://github.com/NJuGau/MyDatabase/assets/102814657/ee23ee42-4809-426d-a377-277e75d0d21d)
 
Selain itu, MyDatabase juga dilengkapi dengan option menu yang memperbolehkan user untuk dapat menavigasi menu. Menu dapat diakses dengan menekan tombol ‘More’ / ikon titik 3 pada action bar. Terdapat 3 menu, yakni ‘Input’, ‘View’, dan ‘About Us’.
Tampilan option menu:
![image](https://github.com/NJuGau/MyDatabase/assets/102814657/aa0b9c0a-5246-441c-b212-9bb0c86ff09f)



