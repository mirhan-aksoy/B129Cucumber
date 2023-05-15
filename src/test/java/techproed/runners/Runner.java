package techproed.runners;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
/*
Runner class; testNG deki .xml file larda belirttiğimiz class'ları,packageları veya methodları nasıl
çalıştırıyorsak, Cucumber frameworkundede Runner class'ındaki tags parametresi ile belirttiğimiz
senaryoyu çalıştırabiliriz
 */

//Cucumber ile JUnit'in entegre olmasını sağlayan test çalıştırıcı notasyonudur
@RunWith(Cucumber.class)

//Seneryoların nerede ve nasıl çalışacağı, hangi raporu kullanacağıyla alakalı seçenekleri ayarlarız
@CucumberOptions(plugin = {"pretty","html:src/test/resources/features/htmlReport/cucumberHooks.html",
        "json:src/test/resources/features/htmlReport/cucumber.json",
        "junit:src/test/resources/features/htmlReport/cucumber.xml"},
         //plugin parametresi ile pretty ifadesi kullanılırsa konsolda senaryo ile bilgi gösterir
        features = "src/test/resources/features",
        glue = {"techproed/stepDefinitions"},//Bu parametre ile kodlarımızı yazdığımız stepDefinition
                                             //class'ının packege'ını belirtiriz

        tags = "@hooks",
        dryRun=false,     // dryRun default olarak false'dur.
                          // true dersek testlerimizi gercekte calistirmaz
                          // sadece calistiriyormus gibi kontrol eder.
                          // ornegin true'da sayfaya gitmez.
                          // false yaparsak driver acilir ve sayfaya gider
        monochrome = true
)
/*
features ===> features'ların olduğu dosyanın yolunu ver(ContentRoot)
        glue ====> stepDefinition'ların olduğu dosyanın yolunu ver(Source Root)
        tags ====> çalıştırmak istediğin grubu yaz
        :white_check_mark:
        2
*/
public class Runner {
}
