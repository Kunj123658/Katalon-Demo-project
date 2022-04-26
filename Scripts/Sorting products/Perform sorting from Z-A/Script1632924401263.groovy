import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
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
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory


ArrayList<String> firstList = new ArrayList<String>()

List<String> getProductsName = CustomKeywords.'mypack.CommonFunctions.getDriver'().findElements(By.xpath('//a/div'))

ArrayList<String> secondList = new ArrayList<String>()

for (WebElement e : getProductsName) {
    firstList.add(e.getText())
}

Collections.reverse(firstList)

WebUI.click(findTestObject('Addtocart/btnFilter'))

WebUI.selectOptionByIndex(findTestObject('Addtocart/valuesDropdown'), 1)

List<String> sortedProductsName = CustomKeywords.'mypack.CommonFunctions.getDriver'().findElements(By.xpath('//a/div'))

for (WebElement e : sortedProductsName) {
    secondList.add(e.getText())
}

WebUI.verifyEqual(firstList, secondList)
println("Products are sorted in correct order")

