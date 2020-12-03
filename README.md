# Tutorial APAP

## Authors

* Kamila Kaffah - 1806191225 - A

## Tutorial 7

### Jelaskan apa yang Anda lakukan di latihan dalam satu paragraf per-soal. Berikan screenshot sebagai ilustrasi dari apa yang Anda jelaskan.

Latihan 1: Saya menghapus baris kode yang memunculkan checkbox di file index.js pada komponen item. Berikut adalah screenshot code yang saya hapus.

![image](https://user-images.githubusercontent.com/60377103/101053172-0a6c7000-35ba-11eb-982c-2a55e3ed3cdb.png)

Latihan 2 : Saya menambahkan kode {this.state.favItems.length > 0 && <button type="button" onClick={this.handleDelete}>Delete</button>} pada kontainer yang memunculkan List My Favorites. Kode tersebut memanggil event handler delete yang bekerja dengan cara mengupdate list dengan list kosong. Selain itu, baris kode itu juga mengecek apakah panjang dari suatu list lebih dari 0 atau tidak. Berikut adalah screenshot code eventhandler-nya.

![image](https://user-images.githubusercontent.com/60377103/101053960-f4ab7a80-35ba-11eb-9074-50a031f048ff.png)

Latihan 3 : Saya membuat event handler baru untuk menghandle kolom kiri dengan cara mengcopy event handler sebelumnya dan menghapus satu baris code conditional else (else newItems.splice(targetInd,1);). Sedangkan untuk kolom kanan, tetap menggunakan event handler yang lama. Berikut adalah screenshot code even handler yang baru.

![image](https://user-images.githubusercontent.com/60377103/101054353-64216a00-35bb-11eb-9f2c-ef255d9e921f.png)

Latihan 4: Saya mengimport Switch dari antd library dan digunakan untuk membuat toggle. Selanjutnya, saya membuat status checked pada state defaulf false dan constructornya. Lalu, saya membuat handleChange yang mengubah status checked. Event handler tersebut digunakan pada code bagian ketika ingin menampilkan kolom favorite movies. Pada kontainer List fav movies, akan dicheck terlebih dahulu apakah status checked atau tidak. Jika ya maka kolom akan fav movies akan ditampilkan. Berikut adalah code pengerjaan no 4 pada App.js.

![image](https://user-images.githubusercontent.com/60377103/101055128-3daffe80-35bc-11eb-9ff6-6ddcc4b38495.png)
![image](https://user-images.githubusercontent.com/60377103/101055342-63d59e80-35bc-11eb-9ccf-329b90c83f6c.png)
![image](https://user-images.githubusercontent.com/60377103/101055456-7fd94000-35bc-11eb-9f03-d4ced4b37614.png)

Latihan 5: Saya menambahkan dua baris kode yang pertama-tama ia mengecek apakah jumlah item di List Fav Movies kosong atau tidak. Jika 0, maka saya menambahkan pesan bahwa list masih kosong. Dua baris kode tersebut saya letakkan di dalam kontainer List fav movies. 
Berikut adalah kedua kode tersebut.
![image](https://user-images.githubusercontent.com/60377103/101057028-2b36c480-35be-11eb-93a7-468a39eb7bcb.png)

### Menurut pemahaman kamu selama pengerjaan tutorial ini, apa perbedaan antara state dan props?

Prop merupakan singkatan dari property yang mirip dengan konsep tag pada HTML. Pada component class, prop adalah property dari class itu sendiri yang diakses melalui keyword 'this'. Pada functional component, prop ini adalah parameternya. Prop bersifat read-only. Sebagai contoh, pada functional component, function tersebut hanya bisa membaca parameter dan tidak bisa mengubahnya.

State adalah data private sebuah component. Data tersebut hanya tersedia pada componentnya dan tidak bisa diakses dari component lain. Component dapat merubah statenya sendiri. Pada functional component, state tidak dimiliki (stateless). Hal itu karena dengan function menyebabkan codenya lebih ringkas.

### Apa keuntungan menggunakan component (e.g. List, Item) di React? Berikan contohnya!

Salah satu keuntungan dari penggunaan component pada react adalah component yang bisa digunakan kembali (reusable). Sebagai contoh: pada tutorial ini, component item dan list digunakan berkali-kali pada aplikasi react. Jadi, sebagai developer, kita tidak perlu menuliskan kembali baris code pada file App.js. 

### Menurut kamu, apa saja kelebihan menggunakan React dalam pengembangan web?

Berikut adalah kelebihan penggunaan reactt:

- React memiliki JavaScript Library: adanya JavaScript Library yang kaya memberikan fleksibilitas lebih kepada developer untuk memilih UI yang mereka inginkan

- Aplikasi React mudah untuk diuji: hal tersebut menawarkan developer untuk dapat menguji dan men-debug kode mereka dengan bantuan alat asli

- Library dan komunitas yang luas: React memiliki sangat banyak Library di NPM dan memiliki dukungan komunitas online yang luas di seluruh penjuru dunia

- Komponen reusable: setiap component pada React memiliki logika dan kontrolnya sendiri. Component tersebut bertanggung jawab mengeluarkan sepotong kecil kode HTML yang bis digunakan kembali

### Menurut kamu, apa saja kekurangan menggunakan React dalam pengembangan web?

Berikut adalah beberapa kekurangan dalam penggunaan React:

-Dokumentasi yang buruk: pengembangan teknologi React terus diperbaharui sehingga tidak ada waktu untuk membuat dokumentasi yang tepat. 

-View bagian: react hanya mencakup UI layer saja dan tidak ada yang lain. Kita memerlukan beberapa teknologi lain untuk pengembangan proyek tersebut.

-Laju pembangunan yang tinggi: lingkungan yang terus berubah dengan cepat dapat menyebabkan beberapa developer merasa tidak nyaman untuk mempelajari kembali cara-cara yang baru. Developer perlu selalu belajar untuk mengikuti perkembangan react yang cepat. 

### Sumber:

https://medium.com/coderupa/react-prop-state-apa-bedanya-7ee61df8257f

https://www.konsepkoding.com/2020/08/1-pengenalan-reactjs-kekurangan-dan.html


## Tutorial 6

### Pertanyaan 1: Jelaskan secara singkat perbedaan Otentikasi dan Otorisasi! Di bagian mana (dalam kode yang telah anda buat) konsep tersebut diimplementasi?

Otentikasi merupakan proses pembuktian identitas seorang user. Contohnya dengan menggunakan login username dan password. Sedangkan Otorisasi adalah proses yang akan terjadi setelah user teridentifikasi (sudah melewati proses Otentikasi). Proses Otorisasi akan memberikan hak kepada seorang user untuk dapat mengakses fitur-fitur pada sistem.
Implementasi Otorisasi ada pada kode di kelas WebSecurityConfig.java dan fungsi cofigure yang mengoverride fungsi kelas WebSeurityConfigurerAdapter. Sedangkan proses Otentikasi diimplementasikan pada kode bagian login.html, PageController, dan WebSecurityConfig.java (fungsi configureGlobal/configAuthentication).

### Pertanyaan 2: Apa itu BCryptPasswordEncoder? Jelaskan secara singkat cara kerja dan tujuannya.

BCryptPasswordEncoder merupakan fungsi yang melakukan enkripsi password dengan cara hashing-code dengan algoritma BCrypt. Tujuan dari fungsi BCryptPasswordEncoder adalah untuk mengamankan password agar tidak terbaca oleh orang lain seperti hacker.

### Pertanyaan 3: Jelaskan secara singkat apa itu UUID beserta penggunaannya!

UUID merupakan singkatan dari Universally Unique Identifier yang berarti identifier tersebut bersifat unik secara global. Penggunaan UUID sendiri ditujukan untuk mengidentifikasi informasi yang ada di sistem komputer.

### Pertanyaan 4: Apa kegunaan class UserDetailsServiceImpl.java? Mengapa harus ada class tersebut padahal kita sudah memiliki class UserRoleServiceImpl.java?

UserDetailsServiceImpl class berguna untuk pengimplementasian UserDetails interface dari Spring Security. Terdapat kemudahan yang diberikan oleh interface UserDetails, yaitu developer bisa mengambil dan menyimpan segala bentuk informasi secara langsung, baik yang secure maupun non-secure. Informasi tersebut disimpan dan dienkapsulasi menjadi Authentication Object. Sementara class UserRoleServiceImpl berbeda dengan UserDetailsServiceImpl, dimana UserRoleServiceImpl mengharuskan developer untuk mengidentifikasi informasi yang perlu diambil dan disimpan.
Selain itu, UserDetailsServiceImpl juga dibuat agar kita dapat memiliki service mengenai user details kita sendiri. Hal tersebut dilakukan dengan cara mendefinisikan ulang fungsi loadUserByUsername(fungsi pada UserDetailsService).

### Sumber

https://degananda.com/perbedaan-antara-autentikasi-dan-autorisasi-dalam-dunia-software-engineering/
wikipedia.org

## Tutorial 5

### Pertanyaan 1: Apa itu Postman? Apa kegunaannya?

Postman adalah tool yang otomatis dan saling berinteraksi dengan HTTP APIs. Aplikasi postman merepresentasikan tampilan dengan friendly GUI interface untuk menyusun requests dan membaca responses. Ia bekerja pada backend dan memastikan bahwa setiap API bekerja dengan baik.

Kegunaan dari aplikasi postman adalah kita bisa memubuat requests dan postman akan menampilkan respons serta memastikannya bahwa respons tersebut merupakan elemen yang diinginkan. Sebagai tool otomatis, ia mengimproves secara drastis dari segi waktu testing dan kualitas dari project. Ia juga membantu dalam deteksi dini bugs yang kemungkinan jika tidak terdeteksi akan menimbulkan kerusakan yang lebih besar pada sistem. 

### Pertanyaan 2: Jelaskan fungsi dari anotasi @JsonIgnoreProperties dan @JsonProperty.

Anotasi @JsonProperty digunakan untuk memetakan property names dengan JSON keys selama serialization dan deserialization.

Anotasi @JsonIgnoreProperties digunakan untuk meng-ignores logical properties secara spesifika dalam JSON serialization dan deserialization. Ia dianotasikan pada level kelas.

### Pertanyaan 3: Apa kegunaan atribut WebClient?

Implementasi webClient merupakan bagian dari WebFlux framework. WebClient dapat digunakan untuk membangun dan mengirim setiap tipe dari URI. Selanjutnya, terdapat WebClientBuilder class yang memiliki uri() method yang menyediakan UriBuilder instance sebagai argumen dan digunakan untuk mengkonstruksi URIs. 

### Pertanyaan 4: Apa itu ResponseEntity dan BindingResult? Apa kegunaannya?

ResponseEntity merepresentasikan HTTP response secara keseluruhan yang berupa status code, headers, dan body. Sebagai hasilnya, kita dapat menggunakannya untuk mengkonfigurasi HTTP response. Jika kita ingin menggunakannya, kita harus mengembalikannya dari endpoint dan Spring akan mengerjakan sisanya. ResponseEntity merupakan tipe generik sehingga kita bisa menggunakan tipe apa saja sebagai response body.

BindingResult merupakan suatu general interface yang objeknya digunakan sebagai argumen untuk memvalidasi method of Validator dalam Controller. Selain itu, BindingResult object juga akan hold the validation errors.

### Sumber

https://www.axelerant.com/resources/team-blog/api-testing-with-postman#

https://dzone.com/articles/jackson-annotations-for-json-part-4-general#

https://www.baeldung.com/spring-response-entity

https://www.javapedia.net/Spring-MVC-Interview-questions/1554


## Tutorial 4

### Pertanyaan 1: Jelaskan perbedaan th:include dan th:replace!

Berdasarkan dokumentasi, jika kita memiliki code `<div th:include=”...”> Content here </div>` fragment akan diletakan di dalam tag `<div>`. Sedangkan ketika kita memiliki code `<div th:replace=”...”> content here </div>` maka tag `<div>` akan digantikan oleh fragments. Dengan kata lain, Thymeleaf menggunakan `th:include` untuk mengikutsertakan bagian dari pages lain sebagai fragments. Sedangkan, dengan `th:replace`, Thymeleaf akan mensubtitusi suatu host tag dengan fragments.

### Pertanyaan 2: Jelaskan apa fungsi dari th:object!

th:object merupakan salah satu tag pada thymeleaf yang berfungsi untuk menampung object yang berasal dari fungsi controller. Bisa juga, th:object digunakan untuk menspesifikasikan object yang akan ditampung oleh submitted form.

### Pertanyaan 3: Jelaskan perbedaan dari * dan $ pada saat penggunaan th:object! Kapan harus dipakai?

Perbedaan antara * dan $ adalah dalam penggunaannya, *{} dapat mengekspresikan sebagian variable object yang belum dispesifikasikan oleh selected object, sedangkan ${} harus mengekspresikan variable object secara lengkap (eksplisit). Tag `${}` digunakan ketika kita ingin menggunakan variable expressions. Sedangkan `*{}` digunakan ketika kita ingin menggunakan selection expressions. Sama seperti variable expressions, tetapi selection expressions akan dieksekusi pada selection object sebelumnya.

### Pertanyaan 4: Bagaimana kamu menyelesaikan latihan no 3?

Saya menambahkan integer navFlag yang bernilai 0 untuk view hotel, 1 untuk delete hotel, dan 2 untuk update hotel. NavFlag tersebut saya tambahkan pada fungsi home, view, dan update hotel di file HotelController. Selanjutnya, sebelum fungsi mereturn html, saya menambahkan navFlag tersebut ke thymeleaf. Pada file fragment, saya menambahkan kondisional menggunakan tag <div th:if...> dengan menggunakan parameter navFlag tersebut. Jika navFlag sama dengan 0, maka ditambahkan navbar home, jika navFlag bernilai 1 maka ditambahkan navbar view hotel, dan jika navFlag bernilai 2 akan ditambahkan navbar update hotel.

### Sumber
https://stackoverflow.com/questions/37103958/difference-between-thymeleaf-include-and-replace
https://stackoverflow.com/questions/57511424/difference-between-and
https://www.baeldung.com/thymeleaf-in-spring-mvc#:~:text=Handling%20User%20Input,form%20data%20will%20be%20bound.

## Turoial 3

### Pertanyaan 1: Pada class KamarDb, terdapat method findAllByHotelId, apakah kegunaan dari method tersebut?

Seperti yang kita tahu, hotel dan kamar memiliki relasi one-to-many dimana object hotel dapat memiliki banyak kamar dan object kamar hanya dapat dimiliki oleh satu hotel. Selain itu, relasi hotel memiliki kamar adalah relasi parsial yang artinya suatu hotel dapat tidak memiliki kamar. Tetapi, relasi kamar dimiliki hotel adalah relasi total yang artinya setiap kamar pasti dimiliki oleh suatu hotel.
Berdasarkan penjelasan sebelumnya, diketahui bahwa suatu hotel dapat memiliki banyak kamar. Dengan method `findByHotelId`, kita akan mendapatkan suatu listKamar yang berisi seluruh object kamar yang dimiliki oleh hotel dengan id tertentu. Method tersebut digunakan ketika kita memerlukan seluruh list kamar pada suatu hotel untuk ditampilkan. Pada tutorial 3 ini, method `findByHotelId` digunakan pada method `findAllKamarByHotelId` yang ada pada kamarService. Method `findAllKamarByHotelId` dipanggil method viewDetailHotel pada file HotelController (tidak ada method `findAllByHotelId` di KamarDb Kak, adanya method `findByHotelId`).

### Pertanyaan 2: Pada class HotelController, jelaskan perbedaan method addHotelFormPage dan addHotelSubmit?

Terdapat perbedaan antara method addHotelFormPage dan addHotelSubmit, yaitu sebagai berikut.
- Pada home, terdapat tombol tambah hotel yang ketika diklik akan memanggil controller method `addHotelFormPage`. Lalu, method tersebut akan mereturn template form-add-hotel.html yang memiliki melakukan method POST. Nilai yang dimasukan pada form-add-hotel akan di-POST ketika menekan tombol submit
- Selanjutnya, ketika menekan tombol submit, method `addHotelSubmit` akan dijalankan. Method tersebut akan GET nilai yang di-POST oleh pada halaman form-add-hotel dan akan memanggil hotelService method addHotel. Dengan begitu, object hotel yang didapatkan akan disimpan ke database hotel. Terakhir, method `addHotelSubmit` akan mereturn template add-hotel.html yang menyatakan hotel berhasil ditambahkan

### Pertanyaan 3: Jelaskan kegunaan dari JPA Repository!

Ketika kita mengimplementasikan suatu aplikasi, seharusnya kita lebih fokus kepada business logic dibandingkan dengan technical complexity dan penulis code secara berulang (boilerplate code). Dengan JPA Repository, kita dapat mengurangi jumlah dari boilerplate code dan membuat implementasi pengembangan layer lebih mudah dan cepat. Berikut adalah beberapa contoh method yang disediakan oleh JPA Repository yang dapat memudahkan kita dalam pengembangan aplikasi.
- Method untuk update, remove, and persist satu atau multiple Author entities
- Method untuk mencari satu atau lebih Authors dengan primary keys-nya
- Method untuk menghitung, mendapatkan, dan menghapus semua Authors
- Method untuk memeriksa apakah suatu Author dengan primary key tertentu exists dalam suatu database

### Pertanyaan 4: Sebutkan dan jelaskan di bagian kode mana sebuah relasi antara HotelModel dan KamarModel dibuat?

Pada file KamarModel.java terdapat bagian kode yang membentuk relasi antara HotelModel dan KamarModel. Berikut adalah tampilan kodenya.

![messageImage_1602230196800](https://user-images.githubusercontent.com/60377103/95562452-5e3d5b80-0a46-11eb-897f-807ee58d6b2b.jpg)

Dari kode tersebut kita dapat mengetahui bahwa KamarModel memiliki relasi ManyToOne dengan HotelModel yang artinya beberapa kamar dapat dimiliki oleh satu hotel tetapi satu kamar tidak bisa dimiliki oleh beberapa hotel. Pada @JoinColumn terlihat bahwa KamarModel memiliki relasi yang direpresentasikan dengan kolom bernama “hotelId” dan referensi kolom “id” pada HotelModel. Dari @JoinColumn terdapat nilai nullable = false yang artinya suatu kamar harus memiliki hotelId. Dengan begitu, suatu kamar tidak dapat exists apabila tidak dimiliki oleh hotel. Terakhir, dari @OnDelete memiliki value action = OnDeleteAction.CASCADE yang artinya terdapat constraints dimana ketika object hotel dihapus maka object kamar yang dimiliki hotel tersebut juga akan dihapus.

### Pertanyaan 5: Jelaskan kegunaan FetchType.LAZY, CascadeType.ALL, dan FetchType.EAGER!

Ketika kita bekerja dengan Object Relational Mapping (ORM), data fetching/loading dapat diklasifikasikan menjadi dua, yaitu eager dan lazy. Kedua fetching tersebut digunakan dalam Hibernate. Dengan FetchType.EAGER, ketika kita load the User data, semua orders yang berhubungan dengan data tersebut juga akan diproses dan disimpan pada memori. Sedangkan ketika kita menggunakan FetchType.LAZY, OrderDetail data tidak akan diinisiasi dan diproses pada memory sampai terdapat method yang memanggil secara eksplisit. 
Selanjutnya, terdapat CascadeType.ALL yang memungkinkan pengguna untuk menggunakan semua operasi dari EntityManager yang terdiri dari REMOVE, REFRESH, DETACH, PERSIST pada suatu object dan semua object yang memiliki relasi dengan object tersebut.

### Sumber:

https://thorben-janssen.com/what-is-spring-data-jpa-and-why-should-you-use-it/
https://www.baeldung.com/hibernate-lazy-eager-loading


## Tutorial 2

### Pertanyaan 1: Cobalah untuk menambahkan sebuah Hotel dengan mengakses link berikut: http://localhost:8080/hotel/add?idHotel=1&namaHotel=Papa%20APAP&alamat=Quanta%20Fasilkom&noTelepon=081xxxApa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi.

Ketika membuka link tersebut, object hotel akan ditambahkan ke dalam listHotel. Namun, akan terjadi error karena HotelController memanggil template add-hotel sedangkan file add-hotel.html belum dibuat.

### Pertanyaan 2: Menurut kamu anotasi @Autowired pada class Controller tersebut merupakan implementasi dari konsep apa? Dan jelaskan secara singkat cara kerja @Autowired tersebut dalam konteks service dan controller yang telah kamu buat

@Autowired menggunakan konsep Dependency Injection. Berdasarkan code kelas di kelas controller, terlihat bahwa HotelController memiliki properti hotelService, dimana kelas HotelController tidak akan bisa terbentuk tanpa terbentuknya hotelService. Selanjutnya, pada properti hotelService terdapat anotasi @Autowired yang digunakan untuk menginjeksikan bean HotelService. Selanjutnya, secara otomatis kelas HotelController akan berisikan interface hotelService.

### Pertanyaan 3: Pertanyaan 3: Cobalah untuk menambahkan sebuah Hotel dengan mengakses link berikut: http://localhost:8080/hotel/add?idHotel=1&namaHotel=Papa%20APAP&alamat=Quanta%20Fasilkom Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi.

Link tersebut merupakan RequestParam yang akan menambahkan object hotel ke listHotel. Namun, RequestParam tidak berhasil dan mengeluarkan error karena RequestParam tersebut tidak memiliki parameter nomor telepon. Hal itu menyebabkan object hotel tidak dapat dibuat karena kekurangan parameter untuk constructor.

### Pertanyaan 4: Jika Papa APAP ingin melihat Hotel dengan nama Papa APAP, link apa yang harus diakses?

Papa APAP bisa membuka link http://localhost:8080/hotel/view?idHotel=1/ atau http://localhost:8080/hotel/view/id-hotel/1

### Pertanyaan 5: Tambahkan 1 contoh Hotel lainnya sesukamu. Lalu cobalah untuk mengakses http://localhost:8080/hotel/viewall , apa yang akan ditampilkan? Sertakan juga bukti screenshotmu.

Ketika link tersebut diakses maka ia akan menampilkan informasi semua object hotel yang sudah dibuat. Berikut adalah hasil screenshotnya.

![messageImage_1601564556078](https://user-images.githubusercontent.com/60377103/94827433-a0591280-0432-11eb-92b7-c951ff48b2e4.jpg)

## Tutorial 1

### What I have learned today

Berikut adalah hal-hal yang saya pelajari hari ini. Ketika mencari jawaban dari setiap peryanyaan, saya melakukan research sendiri di internet.

### Github

1. Apa itu Issue Tracker? Apa saja masalah yang dapat diselesaikan dengan Issue Tracker?

Issue tracking pada GitHub adalah fitur yang melacak suatu masalah yang terjadi dalam projects yang sedang dikembangkan. Ia dapat di-share maupun didiskusikan oleh anggota pengembang yang tergabung pada repository. Fitur ini dibekali dengan milestone, labels, assigness, dan search engine. Selain itu, Issue tracking juga memiliki section sendiri pada setiap repository dan ia cukup special. Hal itu dikarenakan ia fokus terhadap kolaborasi, referensi, dan formating teks yang sempurna. Berikut adalah masalah-masalah yang dapat diselesaikan oleh Issue Tracker.
- Judul dan deskripsi mendeskripsikan tentang semua hal mengenai issue
- Label color-coded mengkategorikan dan memfilter suatu issue
- Sebuah milestone berlaku seperti kontainer untuk issue kita. Hal ini berguna untuk mengasosiasikan masalah dengan spesifik fitur atau fase dalam proyek
- Menyediakan keyboard shortcuts
- Menutup issue dari pesan commit

2. Apa perbedaan dari git merge dan git merge --squash?

Pemisahan antara branch dan master memiliki tujuan sendiri demi memudahkan dalam pengembangan suatu aplikasi. Terdapat beberapa istilah  Ketika kita melakukan penggabungan branch dengan master, salah satunya adalah git merge dan git merge --squash yang memiliki sedikit perbedaan. Ketika kita melakukan git merge maka semua history commit yang ada pada branch akan bergabung dengan history log pada master. Selanjutnya, ketika kita menjalankan command git merge --squash, sama seperti git merge, yaitu semua history commit yang ada pada branch bergabung dengan log commit master tetapi history commit pada branch sebelumnya tidak hilang.

3. Apa keunggulan menggunakan Version Control System seperti Git dalam pengembangan suatu aplikasi? 

Berikut adalah keunggulan Git dalam pengembangan suatu aplikasi.
- Git memiliki desain yang mudah dipahami
- Memudahkan developer dalam mengetahui jika terdapat perubahan pada source code sehingga akan memudahkan dalam berkolaborasi dengan rekan kita dalam melakukan update code secara real time
- Git mendukung dalam pengembangan aplikasi atau proyek secara paralel
- Memiliki sistem yang terdistribusi, peer to peer
- Mendukung pengembangan proyek besar seperti Kernel Linux
- Ketika mengakses git, kita hanya perlu command line dan tidak perlu untuk mengakses client server
- Penyimpanan Git murni berbasis file (tidak menggunakan database/SQL) Open Source atau dengan kata lain gratis

### Spring

1. Apa itu library & dependency?

Library adalah sebuah kode yang sudah dikompilasi menjadi sebuah set file objek. Konsep dari library dapat dikatakan konsep dasar karena ia fleksibel ketika digunakan. Sebagai contoh, kita bisa memiliki header yang sama untuk library yang berbeda. Selain itu, untuk setiap library memungkinkan untuk mengimplementasi fungsional dalam cara yang berbeda. Kita dapat mengganti library tanpa merubah kode. Selanjutnya, kita juga dapat mengganti implementasi sebuah library tanpa harus breaking the calling code. 

Dependency merupakan konsep yang umum dikenal  sebagai Dependency Injection (DI) pada Spring Framework. Sederhananya, DI adalah pattern yang menitikberatkan pada penulisan kode secara clean dan loosely coupled. Dengan begitu, ketika menggunakan Spring Framework dan kita ingin membuat kelas, kita cukup membuat kelas dan menandainya sebagai Spring Bean dan disimpan pada Bean Container. Hal itu memberikan manfaat spring bean dapat digunakan di kelas mana saja ketika dibutuhkan tanpa harus mendefinisikan ulang.

2. Mengapa kita menggunakan Maven? Apakah ada alternatif dari Maven?

Menggunakan maven akan memberikan pengguna kemudahan-kemudahan seperti: menyediakan informasi proyek seperti log document, dependency list, unit test reports, dan lain-lain. Maven sangat membantu untuk mengembangkan proyek terutama ketika programmer melakukan update central repository of JARs dan lainnya. Selain itu, Maven juga memberikan kemudahan untuk pengguna dalam membangun sejumlah proyek menjadi output berupa JAR, WAR, dan lain-lain tanpa harus melakukan scripting. Dalam mengintegrasikan proyek dengan source control system seperti Git, Maven membuat hal tersebut mudah dilakukan. Terdapat alternatif lain dari Maven sebagai build automation tools, yaitu Ant dan Gradle.

3. Selain untuk pengembangan web, apa saja yang bisa dikembangkan dengan Spring framework? 

Selain pengembangan web, Spring Framework dapat juga digunakan untuk pengembangan aplikasi enterprise, yaitu aplikasi skala besar dan kompleks untuk memenuhi kebutuhan organisasi atau perusahaan. Selain itu, para developer juga dapat mengembangkan aplikasi berbasis big data dan aplikasi untuk keamanan.

4. Apa perbedaan dari @RequestParam dan @PathVariable? Kapan sebaiknya menggunakan @RequestParam atau @PathVariable?

@RequestParam dan @PathVariable dapat digunakan untuk mengekstrak nilai dari request URI, akan tetapi keduanya memiliki sedikit perbedaan, yaitu sebagai berikut.
- @RequestParams mengekstrak nilai dari query string sedangkan @PathVariables mengekstrak nilai dari URI path
- Karena @PathVariable mengekstrak nilai dari URI path, maka ia tidak di-encode. Sedangkan untuk @RequestParam request, parameternya adalah URL decoded

@PathVariable digunakan ketika mengidentifikasi resources/resource secara spesifik sedangankan @RequestParam digunakan ketika melakukan sorting atau filter resources tersebut. Sebagai contoh, kita ingin mengidentifikasi karyawan berdasarkan id karyawan, maka pada contoh ini kita menggunakan @PathVariable GET /employee/{employeeID}. Contoh lain, ketika kita ingin memfilter karyawan berdasarkan designation, kita bisa menggunakan @RequestParam GET /employee?designation=SSE.

Sumber

https://guides.github.com/features/issues/
https://idcloudhost.com/mengenal-apa-itu-git-serta-manfaat-dan-fiturnya-untuk-developer/
https://daengweb.id/berkenalan-dengan-spring-boot
https://www.geeksforgeeks.org/introduction-apache-maven-build-automation-tool-java-projects/
https://www.baeldung.com/ant-maven-gradle
https://www.baeldung.com/spring-requestparam-vs-pathvariable
https://dzone.com/articles/understanding-the-uri-param-and-query-param-with-r

### What I did not understand

Bagaimana cara kerja dari spring initializr?

Bagaimana cara kerja dari tiga dependencies (Spring Web, Thymeleaf, dan Spring Boot DevTools) yang digunakan pada tutorial kali ini?

Apa yang dilakukan class BMI dan BMIController?

Mengapa model dan controller harus dibuat package?
