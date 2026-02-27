# android-02-veri-tasima

Bu proje, Android'de **iki Activity arasında veri taşıma** konusunu gösteren temel bir örnektir.

## Projenin Genel Yapısı

- **Tek modül:** `app`
- **UI katmanı:** XML layout dosyaları (`activity_main.xml`, `activity_ikinci.xml`)
- **Ekranlar:**
  - `MainActivity`: Kullanıcıdan isim alır ve ikinci sayfaya gönderir.
  - `IkinciActivity`: Gönderilen ismi ekranda gösterir.
- **Build sistemi:** Gradle Kotlin DSL (`build.gradle.kts`, `app/build.gradle.kts`)
- **Paket adı:** `com.celalalbayrak.benimbirinciuygulamam`

## Akış (Flow)

1. Uygulama `MainActivity` ile açılır.
2. Kullanıcı `EditText` alanına isim girer.
3. “sonraki sayfaya veriyi gönder” butonu `sonrakisayfa` fonksiyonunu tetikler.
4. `Intent` ile `isim` anahtarı üzerinden veri `IkinciActivity`'ye taşınır.
5. `IkinciActivity` gelen değeri `textView2` üzerinde gösterir.

## Yeni Katılanlar İçin Önemli Noktalar

### 1) View Binding aktif
`app/build.gradle.kts` içinde `viewBinding = true` açık olduğu için Activity içinde:

- `findViewById` yerine binding kullanılır.
- `binding = ActivityMainBinding.inflate(layoutInflater)` benzeri kurulum yapılır.

### 2) Intent ile veri aktarımı
- Gönderme: `intent.putExtra("isim", kullaniciGirdigiDeger)`
- Alma: `intent.getStringExtra("isim")`
- Anahtar (`isim`) iki tarafta aynı olmalıdır.

### 3) Activity lifecycle logları
`MainActivity` içinde `onCreate/onStart/onResume/onPause/onStop/onDestroy` içinde `println` çağrıları var.

> Not: Gerçek projede `println` yerine `Log.d(...)` tercih edilmesi daha doğru olur.

### 4) XML tarafında `onClick`
Buton üzerinden `android:onClick="sonrakisayfa"` gibi kullanım mevcut. Bu yaklaşım çalışır; ancak büyüyen projelerde click listener'ları Kotlin dosyasında binding üzerinden kurmak daha yönetilebilir olur.

### 5) Mevcut bir uyumsuzluk
`activity_ikinci.xml` içinde `android:onClick="anasayfayagec"` tanımı var; fakat ilgili fonksiyon `IkinciActivity` içinde yorum satırında.

- Bu butona basılırsa uygulama `onClick` methodu bulunamadığı için hata verebilir.
- İlk iyileştirme adımlarından biri bu fonksiyonu geri açmak veya XML'deki `onClick` tanımını kaldırmaktır.

## Sonraki Aşamada Öğrenilmesi Gerekenler

1. **Navigation Component**
   - Activity yerine Fragment tabanlı yapı
   - Güvenli argüman taşıma (Safe Args)

2. **MVVM mimarisi**
   - ViewModel + UI state yönetimi
   - Test edilebilirlik ve ölçeklenebilirlik

3. **Girdi doğrulama**
   - Boş isim kontrolü
   - Hata mesajı gösterimi

4. **Loglama ve hata yönetimi**
   - `Logcat` üzerinden doğru seviye logları (`Log.d`, `Log.e`)

5. **Testler**
   - Unit testte yardımcı fonksiyonları ayrıştırma
   - Instrumented test ile ekran akışını doğrulama (Espresso)

6. **Kod kalitesi**
   - `strings.xml` kullanımını artırma
   - Fonksiyon/isimlendirmelerde tek bir dil standardı (TR/EN) belirleme

## Hızlı Başlangıç

```bash
./gradlew test
./gradlew assembleDebug
```

APK'yı Android Studio veya `adb` ile cihaza/emülatöre yükleyerek akışı deneyebilirsiniz.
