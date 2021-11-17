## Tutorial 5

1. Apa itu Postman? Apa kegunaannya?
Postman adalah sebuah platform API untuk membangun dan menggunakan API dengan menyederhanakan tiap tahapan lifecycle API dan mempersingkat collaboration sehingga API yang dibuat menjadi lebih cepat dan lebih baik. Postman digunakan untuk membuat sebuah test menjadi lebih singkat dan mudah, format JSON dapat dilihat dengan mudah, dan cukup klik Send untuk menguji test. Dengan user interface yang baik dan human-friendly, Postman menjadi alat yang efektif dalam membedah API yang dibuat oleh orang lain atau sekadar test yang saya buat.

Selain itu, Postman juga sangat mudah untuk diakses dan dengan beragamnya fitur-fitur yang ada pada aplikasi tersebut, menggunakan Postman menjadi sangat efisien dan nyaman. Selain itu, Postman menyimpan hasil dari request dan response-response yang didapatkan, dan kita juga bisa menyimpan hasil proses yang dieksekusi.
https://www.digitalcrafts.com/blog/student-blog-what-postman-and-why-use-it
https://dzone.com/articles/postman-for-api-testing-pros-cons-and-alternative
 
2. Jelaskan fungsi dari anotasi @JsonIgnoreProperties dan @JsonProperty.
@JsonIgnoreProperties dinotasikan di level class dan kita harus spesifikasi properti dari class tersebut untuk di-ignore atau dibiarkan. Anotasi ini akan membiarkan properti yang spesifik pada serialization dan deserialization JSON. Anotasi ini memiliki elemen seperti allowGetters, allowSetters, ignoreUnknown dan value. Contohnya pada tutorial yang kita kerjakan ini adalah value pada model Destinasi adalah list Travel Agensi.
@JsonProperty digunakan untuk memetakan nama properti dengan keys dari JSON ketika serialization dan deserialization. Kita dapat menggunakan anotasi ini ketika deserialization ketika nama dari properti JSON dan nama field dari object tidak sesuai
https://www.concretepage.com/jackson-api/jackson-jsonignore-jsonignoreproperties-and-jsonignoretype#JsonIgnoreProperties
https://dzone.com/articles/jackson-annotations-for-json-part-4-general.

3. Apa kegunaan atribut WebClient?
Web Client adalah interface yang merepresentasikan titik entri utama untuk melakukan web request dengan menyediakan API fungsional yang memanfaatkan Lambda dari Java 8. Secara default, Web Client menggunakan Reactor Netty sebagai library HTTP Client, namun library lain bisa dipasangkan melalui kustomisasi ClientHttpConnector. Dalam menggunakan WebClient dengan remote Rest APIs, awalnya kita perlu Spring WebFlux sebagai dependensi proyek.

4. Apa itu ResponseEntity dan BindingResult? Apa kegunaannya?
ResponseEntity merepresentasikan HTTP response, meliputi header, body, dan status dalam spring rest API. ResponseEntity memungkinkan kita untuk menambahkan header dan status code juga. Response Entity digunakan ketika kita ingin mengubah header HTTP atau status code HTTP berdasarkan business logic atau request langsung. ResponseEntity tetap bisa dijalankan jika kita ingin mengembalikan sebuah object ataupun null. ResponseEntity menyediakan fleksibilitas untuk mengatur dan kustomisasi header HTTP.
BindingResult adalah objek dari Spring yang menyimpan hasil dari validasi dan binding, dimana BindingResult mengandung error yang sudah terjadi. BindingResult harus muncul tepat setelah model object yang sudah divalidasi, atau Spring akan gagal memvalidasi objek dan mengeluarkan exception. BindingResult dapat digunakan sebagai argumen untuk memvalidasi sebuah method dari Validator dalam Controller.

https://programmertoday.com/spring-responseentity-responsebody-resonsestatus/
https://stackoverflow.com/questions/10413886/what-is-the-use-of-bindingresult-interface-in-spring-mvc/36715053#:~:text=%5B%20BindingResult%20%5D%20is%20Spring's%20object%20that,object%20and%20throw%20an%20exception. 

## Tutorial 4

1. Jelaskan perbedaan th:include dan th:replace!
th:replace - Menggantikan tag host dengan frament content tertentu. th:replace akan menjadi subtitusi dari tag host melalui fragment yang telah dibuat.
th:include — Similar to th:insert but it only inserts the contents of the specified fragment Mirip dengan th:insert, bedanya hanya th:include insert pada konten dari fragment tertentu.

https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html#difference-between-thinsert-and-threplace-and-thinclude

3. Jelaskan apa fungsi dari th:object!
th:object adalah ekspresi atau atribut pada Thymeleaf yang digunakan untuk melakukan selection pada sebuah object

https://www.thymeleaf.org/doc/tutorials/2.1/usingthymeleaf.html

4. Jelaskan perbedaan dari * dan $ pada saat penggunaan th:object! Kapan harus dipakai?
${...} : adalah sebuah variable expression atau OGNL expression
*{...} : adalah sebuah selection expression. Sama seperti dollar, bedanya adalah dengan *, tempat di eksekusi, yaitu di sebelum object yang di select saja

https://stackoverflow.com/questions/37728515/thymeleaf-the-difference-between-thfield-and-thfield/40028263


## Tutorial 3

1. Tolong jelaskan secara singkat apa kegunaan dari anotasi-anotasi yang ada pada model (@AllArgsConstructor, @NoArgsConstructor, @Setter, @Getter, @Entity, @Table)

@AllArgsConstructor menghasilkan satu constructor dengan satu parameter pada tiap method yang ada di class. Sedangkan @Setter dan @Getter jika ditambahkan akan generate method setter dan getter untuk tiap metode dalam class, dan @NoArgsConstructor akan membuat constructor dengan isi kosong. @Entity akan menspesifikasikan sebuah class sebagai entitas, dan @Table akan menentukan table utama untuk sebuah entitas.
https://www.baeldung.com/spring-injection-lombok
https://www.baeldung.com/intro-to-project-lombok


2. Pada class TravelAgensiDb, terdapat method findByNoAgensi, apakah kegunaan dari method tersebut?

findByNoAgensi adalah sebuah method derived query yang digunakan untuk mencari agensi dari noAgensi, yang berasal dari spring Data JPA. Kata kuncinya adalah kata ‘By’ yang menandakan derived methodnya, yaitu find sebagai introduction dan NoAgensi sebagai spesifikasinya.
https://www.baeldung.com/spring-data-derived-queries

3. Jelaskan perbedaan kegunaan dari anotasi @JoinTable dan @JoinColumn

@JoinTable akan menyimpan ID dari kedua entitas ke tabel yang terpisah, sedangkan @JoinColumn akan menyimpan ID ke entitas lain di kolom yang baru dalam table yang sama. @JoinColumn biasanya digunakan ketika entitas memiliki direct relationship, seperti foreign key yang berada antara dua entitas, sedangkan @JoinTable sering digunakan ketika ingin mengatur relationship antar entitas di table lain.
https://javakeypoint.wordpress.com/2020/04/21/difference-between-joincolumn-and-jointable-in-hibernate/#:~:text=%40JoinTable%20stores%20the%20id%20of%20both%20the%20entity,manage%20the%20relationship%20between%20entities%20in%20another%20table.

4. Pada class TourGuideModel, digunakan anotasi @JoinColumn pada atribut agensi, apa kegunaan dari name, referencedColumnName, dan nullable dalam anotasi tersebut? dan apa perbedaan nullable dan penggunaan anotasi @NotNull

Kegunaan dari name adalah untuk memberikan nama dari foreign key pada kolom. referencedColumnName digunakan untuk memberikan nama pada kolom yang direferensikan oleh sebuah foreign key pada kolom. Nullable digunakan untuk mengetahui apakah foreign key pada kolom nullable atau tidak. Perbedaan dari nullable dan @NotNull adalah nullable membantu kita untuk mengidentifikasi apakah pemanggilan method atau variable dapat mengembalikan atau berisi null, sedangkan @NotNull adalah kode yang secara eksplisit mendeklarasikan bahwa metode tidak boleh mengembalikan null dan variable tidak dapat berisi null.
https://www.jetbrains.com/help/idea/nullable-and-notnull-annotations.html
https://docs.oracle.com/javaee/6/api/javax/persistence/JoinColumn.html


5. Jelaskan kegunaan FetchType.LAZY, CascadeType.ALL, dan FetchType.EAGER
FetchType.LAZY memiliki kegunaan untuk memberikan informasi kepada Hibernate untuk mengambil entitas yang berkaitan saja dari database ketika kita sedang menggunakan relationship. FetchType.LAZY menjadi alternatif yang baik karena kita tidak perlu memilih entitas yang tidak kita butuhkan untuk uses case kita. CascadeTypeALL berisi operasi-operasi seperti PERSIST, MERGE, REMOVE, dll yang disebarkan ke entitas (parent) yang berasosiasi dengan entitas lainnya (child). FetchType.EAGER memiliki kegunaan untuk memberikan hibernate untuk mendapatkan seluruh elemen dari sebuah relationship ketika memilih sebuah entitas parent.
https://thorben-janssen.com/entity-mappings-introduction-jpa-fetchtypes/
https://www.baeldung.com/jpa-cascade-types



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
