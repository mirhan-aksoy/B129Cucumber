Feature: US001_Amazon_Sayfasinda_Urun_Aratma
  Scenario: TC01_Amazon_sayfasinda_Urun_Selenim_Aratma
    Given kullanici_amazon_sayfasina_gider
    And arama_kutusunda_iphone_Selenium_aratir
    And sayfayi_kapatir
