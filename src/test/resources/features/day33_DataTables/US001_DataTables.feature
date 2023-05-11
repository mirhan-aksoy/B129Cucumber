Feature: US001_Amazon_Urun_Aratma
  Scenario: TC01_Amazonda_Urun_Aratma
    Given kullanici_amazon_sayfasina_gider
    And kullanici_verilen_urunleri_aratir
      | Urunler  |
      | samsung  |
      | nokia    |
      | iphone   |
      | motorola |
    And sayfayi_kapatir

    #DataTable; scenario'lardaki satır ve sütun için bir veri tablosu temsil eder.
#Bunun için kullanılmak istenen her stepten sonra yukarıdaki örnekteki bir tablo yapısı oluştururuz.
#ve bu stepin methodunu stepDefinition'da oluşturduğumuz zaman buradaki verileri alabilmemiz için
#oluşturulan methoda DataTable parametresi eklenir.
#Bu parametre ismi ile bir list oluşturulabilir.
#yada direkt asList() methodu ile row'lara ulaşabiliriz.