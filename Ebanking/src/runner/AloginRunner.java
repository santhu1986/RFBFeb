package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features= {"D:\\SeleniumJan25Prj\\Ebanking\\src\\feature\\AdminLogin.feature",
	                     	"D:\\SeleniumJan25Prj\\Ebanking\\src\\feature\\RoleCreation.feature"},
                    glue="stepdefination",monochrome=true,
                    plugin={"pretty"})
public class AloginRunner
{

}
