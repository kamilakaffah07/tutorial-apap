# Tutorial APAP

## Authors

* Kamila Kaffah - 1806191225 - A

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
