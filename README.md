## Tutorial 2

Pertanyaan 1: 
http://localhost:8080/agensi/add?idAgensi=1&namaAgensi=Papa%20APAP&alamat=Maung%20Fasilkom&noTelepon=081xxx Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi

Yang terjadi adalah adanya error Whitelabel yang memberitahukan bahwa tidak ada mapping. Hal tersebut terjadi karena belum ada template dimana thyleaf tidak dapat menangkap mapping yang ada, maka dari itu keluar notifikasi error Whitelabel.

Pertanyaan 2: Menurut kamu anotasi @Autowired pada class Controller tersebut merupakan implementasi dari konsep apa? Dan jelaskan secara singkat cara kerja @Autowired tersebut dalam konteks service dan controller yang telah kamu buat

Autowired menginjeksikan objek array dan koleksi java, seperti list, set, map, dan array diinjeksi menggunakan anotasi Autowired. Pada implementasi lab ini, Autowired digunakan untuk memudahkan kita dalam menggunakan constructor dan setter getter, Autowired memungkinkan Controller pada lab ini secara otomatis mencari service yang mengimplementasikan interface. Maka dari itu, kita tidak perlu membuat constructor dan setter getter karena Autowired sudah mengatasinya.

Pertanyaan 3: http://localhost:8080/agensi/add?idAgensi=1&namaAgensi=Papa%20APAP&alamat=Maung%20Fasilkom Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi
Terjadi error. Hal ini dikarenakan pada pembuatan agensi, diperlukan beberapa informasi seperti nama, id, alamat, dan nomor telepon. Sedangkan pada link yang tertera di soal ini, hanya ada nama, id, alamat agensi dan tidak ada nomor telepon. Maka dari itu, ada error karena penambahan data harus dilengkapi 4 aspek tersebut.

Pertanyaan 4: Jika Papa APAP ingin melihat Travel Agensi dengan nama Papa APAP, link apa yang harus diakses?
Link yang harus diakses adalah http://localhost:8080/agensi/view/id-agensi/1. Link ini akan mendirect ke View yang akan memperlihatkan informasi dari sebuah ID Agensi tertentu.

Pertanyaan 5: Tambahkan 1 contoh Travel Agensi lainnya sesukamu. Lalu cobalah untuk mengakses http://localhost:8080/agensi/viewAll , apa yang akan ditampilkan? Sertakan juga bukti screenshotmu.

Disini saya menambahkan Papa APAP dengan ID 1, tampilan menjadi seperti ini:
https://ibb.co/T2mZJzM

Jika di View all, tampilan menjadi seperti ini:
https://ibb.co/9mxbcyH



## Tutorial 1
### What I have learned today

### Github
1. Apa itu Issue Tracker? Apa saja masalah yang dapat diselesaikan dengan Issue Tracker?

Issue tracker adalah sebuah perangkat lunak yang memungkinkan developer-developer untuk mencatat 'bugs', memprioritaskan itu, dan men-track progres dalam memperbaiki bug. Namun, pencatatan bisa dalam bentuk apapun selain bugs, seperti pengembangan ide. Dengan Issue Tracker ini, pengguna dapat menemukan solusi untuk masalah yang mereka hadapi dengan baik dan detail, karena semua tercatat oleh tracker. Hal ini mempermudah pengguna untuk melakukan 'debugging'.

https://monday.com/blog/project-management/issue-tracker/#:~:text=As%20the%20name%20implies%2C%20an%20issue%20tracker%20is,ideas%2C%20elements%20that%20users%20have%20complained%20about%2C%20etc.

2. Apa perbedaan dari git merge dan git merge --squash?

Git merge adalah salah satu command yang digunakan untuk membuat branch-branch, menjadi satu dengan menganalisis persamaan yang ada antara branch-branch yang ingin di gabungkan menjadi satu. Sedangkan git merge --squash berarti bahwa seluruh commit dari 'header' branch digabung atau di 'squash' menjadi satu commit, baru kemudian ditambahkan pada 'main' branch.

https://ooloo.io/project/github-flow/task-1-merge-vs-squash-merge

4. Apa keunggulan menggunakan Version Control System seperti Git dalam pengembangan
suatu aplikasi?

Beberapa keunggulan utama dalam menggunakan Version Control System seperti Git adalah:
  - Merampingkan proses perkembangan
  - Mudah untuk mengatur program code untuk beberapa projek
  - Menyimpan 'history' dengan seluruh perubahan yang ada pada kode
  - Menyimpan seluruh perubahan pada repositori
  - Developer dapat memperbaiki kesalahan mereka dengan mudah

https://hackernoon.com/top-10-version-control-systems-4d314cf7adea#:~:text=The%20main%20advantages%20of%20using%20a%20version%20control,developers%20make%20a%20mistake%2C%20they%20can%20undo%20it.

### Spring
5. Apa itu library & dependency?

Library adalah salah satu bagian yang spesifik dari perangkat lunak yang akan digunakan oleh sebuah program. Library akan me-refer ke sebuah grup yang spesifik. Library bisa saja berasal dari internal ataupun pihak luar. Sedangkan dependency adalah hubungan antara dua potongan kode, dimana kode pertama akan refer ke kode kedua untuk melakukan sebuah aksi, atau mengembalikan sebuah informasi.

https://softwareengineering.stackexchange.com/questions/408739/what-is-the-difference-between-a-library-and-a-dependency

6. Apa itu Maven? Mengapa kita menggunakan Maven? Apakah ada alternatif dari Maven?

Maven adalah alat yang dibuat berdasarkan konsep dari Project Object Model 
(POM), dimana Maven dapat mengatur pembangunan, pelaporan, dan dokumentasi sebuah projek dari potongan informasi. Kita menggunakan Maven agar kita dapat membangun dan mengatur projek dengan basic Java, karena Maven memungkinkan kita untuk menciptakan projek dengan POM dan plugin. Alternatif yang bisa digunakan selain Maven adalah CMake, GNU, Gradle, SCons, dll.

https://www.cidevops.com/2020/03/what-is-maven-why-we-need-maven.html#:~:text=Maven%20is%20a%20popular%20tool%20for%20building%20and,Its%20development%20process%20is%20very%20similar%20to%20ANT.

https://www.bing.com/search?q=alternatives+for+maven+java&qs=n&form=QBRE&sp=-1&pq=alternatives+for+maven+ja&sc=0-25&sk=&cvid=8BF2D4EA3B38401FB3D2598F0EA5F73D

8. Selain untuk pengembangan web, apa saja yang bisa dikembangkan dengan Spring
framework?

Spring Framework dapat digunakan untuk aplikasi Java-based, namun Spring Framework juga memungkinkan developer untuk mengembangkan aplikasi sebesar enterprise dengan POJO.

https://www.tutorialspoint.com/spring/spring_overview.htm

7. Apa perbedaan dari @RequestParam dan @PathVariable? Kapan sebaiknya
menggunakan @RequestParam atau @PathVariable?

RequestParam digunakan untuk mengekstraksi parameter query-query, sedangkan PathVariable digunakan untuk mengekstraksi value data secara langsung dari URI. Kita menggunakan RequestParam ketika ingin membaca HTML form data yang disediakan oleh pengguna dan mengikatnya ke parameter request, sedangkan kita dapat menggunakan PathVariable jika ingin mengidentifikasi sumber secara langsung.

https://www.javatpoint.com/spring-mvc-requestparam-annotation#:~:text=The%20%40RequestParam%20is%20used%20to%20read%20the%20HTML,it%20to%20view%20page.%20String%20msg%3D%22Sorry%20%22%2B%20name%2B%22.

https://medium.com/@fullsour/when-should-you-use-path-variable-and-query-parameter-a346790e8a6d#:~:text=When%20should%20you%20use%20Path%20Variable%2C%20and%20how,filter%20items%2C%20then%20you%20should%20use%20query%20parameter.

### What I did not understand
(tuliskan apa saja yang kurang Anda mengerti, Anda dapat men-_check_ apabila Anda
sudah mengerti dikemudian hari, dan tambahkan tulisan yang membuat Anda mengerti)
- [ ] Kenapa saya harus belajar APAP?
- [x] Kenapa pada saat saya mencoba melakukan git revert, file tidak dapat di ekstrak sesua dengan keinginan saya?
Karena bisa jadi ada yang bermasalah dengan file .git, maka dari itu, saya belajar bahwa melakukan commit adalah salah satu hal yang krusial dalam pengerjaan tutorial, karena jika ada kesalahan, saya bisa kembali pada potongan kode saya sebelumnya.
