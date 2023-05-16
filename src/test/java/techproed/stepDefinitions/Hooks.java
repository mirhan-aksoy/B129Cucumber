package techproed.stepDefinitions;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelUtils;
import techproed.utilities.ReusableMethods;

public class Hooks {
    /*
    Scenario'lar arasındaki bağlantıyı sağlayan glue parametresine koyduğumuz stepDefinition package'ı içerisinde
@Before ve @After gibi bir notasyon varsa extend yapmamıza gerek kalmadan her scenariodan önce veya sonra bu
methodlar çalışacaktır.
    Cucumber'da @Before, @After kullanma ihtiyacımız olursa bunu Hooks class'ına koyarız
    istersek yeni bir package oluşturup içine Hooks u koyabiliriz, budurumda Runner class ındaki
     "glue "    parametresine bu package ıda eklememiz gerekir
     Kullandığımz @Before @After notasyonları Junit ten değil, Cucumber dan olmalıdır
 */

    @Before("@All")//import io.cucumber.java.Before
    public void setUp1(){
        System.out.println("Testler çalışmaya başladı");
    }
    @Before("@gr1")
    public void setUp2(){
        System.out.println("Amazonda SQL aratildi");
    }
    @Before("@gr2")
    public void setUp3(){
        System.out.println("Amazonda Java aratıldı");
    }
    @Before("@gr3")
    public void setUp4(){
        System.out.println("Amazonda selenium aratıldı");
    }

    @Before("@Excel")
    public void setUp5(){

        Driver.getDriver().get(ConfigReader.getProperty("blueRentACarUrl"));
        BlueRentalPage blueRentalPage=new BlueRentalPage();
        //excel dosya yolunu aldım ve içeriği for ile döngüde kullanacağım
        ExcelUtils excelUtils = new ExcelUtils("src/test/resources/mysmoketestdata (1).xlsx", "customer_info");
        for(int i=1; i<=excelUtils.rowCount() ; i++){
            String email=excelUtils.getCellData(i,0);
            String passsword=excelUtils.getCellData(i,1);
            blueRentalPage.loginButton.click();
            ReusableMethods.bekle(2);
            blueRentalPage.emailBox.sendKeys(email, Keys.TAB,passsword,Keys.ENTER);
            ReusableMethods.bekle(2);
            blueRentalPage.userDropDown.click();
            ReusableMethods.bekle(2);
            blueRentalPage.profile.click();
            ReusableMethods.bekle(2);
            Assert.assertEquals(blueRentalPage.verifyEmail.getText(),email);
            ReusableMethods.bekle(2);
            blueRentalPage.userDropDown.click();
            ReusableMethods.bekle(2);
            blueRentalPage.logOut.click();
            ReusableMethods.bekle(2);
            blueRentalPage.OK.click();
    }
    }





    @After //import io.cucumber.java.Before
    public void tearDown(Scenario scenario){

        //Bu methoda Scenario class'ından bir parametre ataması yapılır
        //Bu method'u fail olan scenario'larımızın resmi almak için kullanırız

        if(scenario.isFailed()){
            TakesScreenshot ts= (TakesScreenshot) Driver.getDriver();
            scenario.attach(ts.getScreenshotAs(OutputType.BYTES),"image/jpeg","screenShot_"+scenario.getName());

        }
        Driver.closeDriver();

    }

}


