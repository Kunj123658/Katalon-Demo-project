import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import org.openqa.selenium.WebDriver as WebDriver
import org.eclipse.persistence.internal.oxm.record.json.JSONParser.object_return as object_return
import org.junit.After as After
import org.openqa.selenium.By as By
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

ArrayList<String> firstList = new ArrayList<String>()

ArrayList<String> secondList = new ArrayList<String>()

List<WebElement> thirdList = new ArrayList<String>()

List<WebElement> btnAddToCart = CustomKeywords.'mypack.CommonFunctions.getDriver'().findElements(By.xpath('//div[2]/button'))

List<WebElement> getProductName = CustomKeywords.'mypack.CommonFunctions.getDriver'().findElements(By.xpath('//a/div'))

for (int i = 0; i < btnAddToCart.size(); i++) {
    btnAddToCart.get(i).click()

    firstList.add(getProductName.get(i).getText())

    GlobalVariable.count += 1

    String j = String.valueOf(GlobalVariable.count)

    WebUI.verifyMatch(j, WebUI.getText(findTestObject('Addtocart/countOfProducts')), true)
}

WebUI.click(findTestObject('Addtocart/btnCart'))

List<WebElement> getAddedProductName = CustomKeywords.'mypack.CommonFunctions.getDriver'().findElements(By.xpath('//a/div'))

List<WebElement> btnRemove = CustomKeywords.'mypack.CommonFunctions.getDriver'().findElements(By.xpath('//*/text()[normalize-space(.)="Remove"]/parent::*'))

for (int i = 0; i < btnRemove.size(); i++) {
    secondList.add(getAddedProductName.get(i).getText())
}

WebUI.verifyEqual(firstList, secondList)

println('Products are added successfully into cart')

//---------------------------------------------------Remove all products from cart----------------------------------------------
for (int i = 0; i < btnRemove.size(); i++) {
    btnRemove.get(i).click()

    List<WebElement> remainingProducts = CustomKeywords.'mypack.CommonFunctions.getDriver'().findElements(By.xpath('//a/div'))

    for (WebElement e : remainingProducts) {
        thirdList.add(e.getText())
    }
    
    for (int j = 0; j < thirdList.size(); j++) {
        if (secondList.get(i).equals(thirdList.get(j))) {
            GlobalVariable.flag = 1
        } else {
            GlobalVariable.count += 1
        }
    }
    
    remainingProducts.clear()

    thirdList.clear()

    GlobalVariable.count = 0
}

if (GlobalVariable.flag == 0) {
    println('All products are removed successfully from cart')
} else {
    println('There is an issue in removing products from cart')
}

WebUI.click(findTestObject('Addtocart/btnContinueShopping'))

