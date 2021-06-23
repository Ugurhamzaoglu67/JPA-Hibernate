# JPA-Hibernate

1 - sts download
2- preferences ->validation -> suspend all.
   preferecense -> console -> 8000 sınırını kaldır

3- new create ->maven project -> 
	Group id : com.ugurhmz
	Artifac id  : petclinic_app

3- pom.xml içini, doldur.
4- proje sağ tık- > Maven -> update project

5- console  sağ taraftan -> Maven console seç.
6- src/main/resources -> New File ->  log4j.xml

7- src/main/resources -> New File ->Hibernate Configuration File (cfg.xml) -> 5.2 sürümü seç oluştur

8- h2 veri tabanı için cmd aç ->
	java -jar .m2\repository\com\h2database\h2\1.4.196\h2-1.4.196.jar

BUNUN YERİNE CONSOLDAN AÇMAK için

9-  ctrl+ shift+t  ->Çıkan yere Console -> org.h2.tools ... seçiyoruz -> Sonra o
Dosyayayı sağ tık + RUn as java app. Bu şekildede h2 database açabiliriz (Bnu seç 8yerine)

10- hibernate.cfg.xml 'de h2 ile ilgili bağlantı tanımları için
 -> Session Factory olan tarafa geç -> Driver Class Browse seç ->  org.h2.Driver yaz
 -> URL : jdbch2:tcp://localhost/~/test
 -> Username : sa

Sonra hibernate.cfg.xml  -> source içine gir -> <session-factory'deki name attr sil. kaydet çık.

11________________________________________SESSION FACTORY _________________
12- src/main/java -> new -> Package  name : -> com.ugurhmz.petclinic.config

13 -Bu oluşturuluan com.ugurhmz.petclinic.config sağ tık -> new -> class HibernateConfig

*Not -> SessionFactory uygulama genelinde, bir defaya mahsus oluşturulan nesne
	ve çok kullanıcılı ortamda, birden fazla kullanıcı bu SessionFactory nesnesine erişebilmekte.
	SessionFactory nesnesi üzerinden hibernate session bilgileri elde edilerek, persistance işlemleri
	yapılmaktadır.

	**SessionFactory her yerden erişilebilcek, static değişkende tutulabilir.
	
	** static block içerisinde initializing işlemini gerçekleştiriyoruz.


14- SessionFactory işlemini test etmek için 
src/test/java -> package name -> com.ugurhmz.petclinic_test

<groupId>com.ugurhmz</groupId>
	<artifactId>petclinic_jpa</artifactId>






15- hibernate.properties -> Sql kodlarının konsolda görünmesini sağlamak için.

@Id ->Primary key özelliği sağlar. id keyinin 
     Entity sınıfları mutlaka @Id anatasyonu ile işaraletlenmiş id attributeleri olmak zorundadır.

@Basic -> JPA'da Long,int,boolean, String, Character, class gibileri Veri tabanının ilgili yerleriyle
eşleştiren anatasyondur.
	Kullanımı zorunlu değildir.

@Column ->Default durumda, attribute ismiyle eşleştirme yapar.



16) *Not -> Unknown Entity hatası çözümü için -> hibernate.cfg.xml içine mapping olmalı

Sınıfın ismini -> Copy Qualified name -> hibernate.cfg.xml içine : 

<mapping class="com.ugurhmz.petclinic.model.MyPet" />


17) Hibernati JPA API'si üzerinden kullandığımız durumlarda ise, META-INF üst dizi kök class path 
kabul edilip, entity sınıflar buradan itibaren taranmakta, JPA anatosyanlarına karşılık gelen
meta data oto yüklenmektedir.


18) Entity'nin, GETTER & SETTER ihtiyacını REFLECTION API (field level ac.)
	


(19) Persistence işlemlerini gerçekleştirmek için -> Mutlaka aktif bir transactiona ihtiyacımız var.
JPA işlemlerinde Aktif bir Transaction yoksa, Yani INSERT,DELETE,UPDATE operasyanloru veri tabanına
yansıtılırken hata alırız. JPA aktif transaction olmadan bunların veri tabanına yansıtılmasına izin vermez.


(20) entityManager.flush() -> Persist context senkronizasyonunu tetikler. Transaction ihtiyacını 
söyleyen hata olur.

flush'a Transaction işleminde gerek yok.



(21) hibernate.properties içinde :
hibernate.allow_update_outside_transaction=true  ile  Transaction yapmamıza gerek kalmıyor. Autocommit
mod deniyor. Bazı yerlerde tercih edilebiliyor.


(22) @Basic -> Anatasyonun optinal="false" dediğimiz vakit ilgili attributeye bir değer atamadan
gerçekleştirilen persistence işlemlerinden önce, hibernate'in property değerinin mevcut olup olmadığını
kontrol etmesini sağlayabiliriz. Benzer biçimde column anatasyonunun nullable attribute'side aynı amaçlı 
kullanılabilir.



(23) GenerationType.TABLE ->Performans açısından kullanılması önerilmez.
     GenerationType.AUTO -> Default Stratejinin kullanılmasını sağlar. 


(24) Her bir Entity için Ayrı ayrı sequence'de tanımlayabiliriz.


(25) Bileşke PK sınıflarının üzerine
@Embeddable   anatasyonu konur. ->Kendilerine ait PK'leri yoktur.  

@Embedded  anatasyonuda konabilir.


(26) Entity Sınıfların Mutlaka kendilerine ait PK'leri olur.
     Entity'ler birbirinden bağımsız biçimde CRUD olabilirler.
     @Embeddable nesnelerin kendilerine ait PK'leri olmaz. Bu nesneler Mutlaka Bir Entity Nesneye
     bağlı olarak yaşamak zorundadırlar.
     @Embeddable nesnelere Doğrudan erişim imkanıda yoktur.


(27) @MappedSuperclass   anatasyonu ile işaretlenmiş, üst sınıf  herhangi bir şekilde
Entity sınıf olarak kabul edilmez. Ona ait Tablonunda DB'de olması söz konu değildir.


(28) Java SQL Tip Dönüşümü
@Embeddable -> anatasyonu varsa bileşen eşlemesi yapar.
Serializable  ise varbinary tipi ile eşleştirilir.

(29) Entity olan her bir sınıf için -> Mapping eklemeyi unutma (hibernate.cfg.xml) 'e eklencek.


(30) enum değerlerin ordinal karşılıkları -> Enum sınıf içersindeki  tanım sırasına göre 0'dan başlamaktadır.
enum sınıflarında araya yapılacak ekleme, diğer değerlerin ordinal sırasını kaydırır.

	
