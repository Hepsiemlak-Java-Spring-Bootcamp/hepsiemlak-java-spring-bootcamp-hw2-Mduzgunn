>####Creational Patterns neler? Önceki ödevde oluşturulan nesnelerinizi factory Design patterni ile oluşacak şekilde düzenleyin.

**_Factory Method_**
Üst sınıfta nesneler oluşturmak için bir arabirim sağlayan, ancak alt sınıfların oluşturulacak bu nesne türünü değiştirmesine izin veren bir creational pattern türüdür.

**_Abstract Factory_**
Birbiri ile ilişki classları, methodların içeriğini belirlemeden oluşturmayı sağlıyor.

**_Builder_**
Karmaşık nesnelerin adım adım oluşturulduğu yaratımsal bir tasarım desenidir. Bu desen aynı kurucu kod ile farklı tür ve gösterimdeki nesneleri oluşturmanıza olanak sağlar.

**_Prototype_**
Bir objeyi, kodunuz onun sınıflarına bağımlı hale gelmeden kopyalamayı sağlayan bir tasarım desenidir.

**_Singleton_**
Bir nesnenin sadece bir örneğinin olduğundan emin olmak ve bu nesneye ihtiyacınız olduğunda kodunuzda her yerde tek örneğinin çağırılmasını sağlamak için kullanılır.


---
>####Java dünyasındaki framework’ler ve çözdükleri problemler nedir? Kod Örneklendirini de içermelidir.

Spring Framework, daha hızlı geliştirme için çözüm sunar. Bu nedenle, yalnızca işlevsellik ve iş mantığına odaklanmanız gerekir,
Bean/Nesne yönetimi, İşlem yönetimi ve cofig öğeleri gibi geri kalan şeyler Framework tarafından halledilecektir.

A sınıfı B sınıfını kullanıyorsa, DI, B sınıfını A sınıfına sağlama sorumluluğunu üstlenir. Yaygın olarak, Spring'in farklı bir B sınıfı sağlayacağı (örneğin sahte) test için kullanılır.
Elbette, bunların hepsini kendiniz yapabilirsiniz, ancak Spring'in (veya başka bir DI çerçevesinin) bunu sizin için yapmasına izin verirseniz, genellikle daha az iş olur.

@Transaction'dan örnek vermek gerekirse

eğer @Transaction kullanmayacaksak aşağıdaki gibi yazmamız gerekir. Böylece hata oranı yüksek ve kendini tekrar eden kodlar yazma ihtimalimiz artacaktır.

UserTransaction utx = entityManager.getTransaction();

try {
utx.begin();
businessLogic();
utx.commit();
} catch(Exception ex) {
utx.rollback();
throw ex;
}

kısa hali

@Transactional
public void businessLogic() {
}

---
>####Spring frameworkünün kullandığı design patternlar neler?

**_Singleton pattern_**
uygulama başına bir nesnenin yalnızca bir örneğinin var olmasını sağlayan bir mekanizmadır. Dışarı açılan kaynakları yönetirken faydalı olabilir.

**_Factory Method pattern_**
istenilen nesneleri oluşturmayı yöneten mekanizmaya sahiptir. Nesne oluşturma işlerini üstlenen fabrika gibi düşünülebilir

**_Proxy pattern_**
Bir nesnenin (proxy) başka bir nesneye (nesne veya hizmet) erişimi kontrol etmesine olanak tanıyan bir tekniktir.

**_Template pattern_**