package com.app.demo.stepdef;

import com.app.demo.base.BaseUtil;
import com.app.demo.base.WaiTime;
import io.cucumber.java.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class Hook extends BaseUtil{

    private BaseUtil base;

    public Hook(BaseUtil base) {
        this.base = base;
    }

    @Before
    public void InitializeTest() {
        WebDriverManager.chromedriver().setup();
        base.Driver = new ChromeDriver();
        base.Driver.manage().window().maximize();
        base.Driver.manage().timeouts().implicitlyWait(WaiTime.MEDIUM_WAIT_TIME, TimeUnit.SECONDS);
    }


    @After
    public void TearDownTest() {
        base.Driver.quit();
    }

}
