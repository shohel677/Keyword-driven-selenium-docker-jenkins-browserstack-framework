package Pages;

import AbstractComponents.GenericWebPage;

public class InitialPage extends GenericWebPage {

    public void appAccess(String appAddress)  {
        instanceDriver.get(appAddress);
        logger.info("Open URL: " + appAddress);
        instanceDriver.manage().window().maximize();
    }



}
