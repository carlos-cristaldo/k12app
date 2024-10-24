package tests.examples;

import data.CustomData;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import tests.BaseTest;
import model.User;
import model.UserData;
import org.testng.Assert;
import org.testng.annotations.Test;

import static utilities.Utils.getUser;

public class ExampleTests extends BaseTest {

    @Test
    public void simpleTest() {
        User user = getUser("user1");
        Assert.assertEquals(user.getUserdata().getUsername(), "RithuPS1");
    }

    @Test(
            dataProvider = CustomData.DP_NAME,
            dataProviderClass = CustomData.class,
            groups = {regression}
    )
    @Severity(SeverityLevel.NORMAL)
    @Description("smoking test")
    public void simpleTest1(UserData userData) {
        softAssert.assertTrue(userData.getUsername() != null);
        softAssert.assertTrue(userData.getPassword() != null);
        softAssert.assertAll();
    }

    @Test(groups = {smoke})
    public void failTest(){
        forceWait(2000);
        Assert.assertEquals(2,3);
    }
}
