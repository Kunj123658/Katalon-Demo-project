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
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebElement as WebElement


List<WebElement> getAllLinks = WebUI.getAllLinksOnCurrentPage(false, null)
println(getAllLinks)

println("Page Height:- "+WebUI.getPageHeight())
println("Page Width:- "+WebUI.getPageWidth())

WebUI.click(findTestObject('AboutPage/btnDrawerMenu'))

WebUI.sendKeys(findTestObject('AboutPage/btnAbout'),Keys.chord(Keys.CONTROL + Keys.SHIFT + Keys.ENTER))

int mainWindow = WebUI.getWindowIndex()

WebUI.switchToWindowIndex(mainWindow + 1)

String aboutPageTitle = WebUI.getWindowTitle()
println(WebUI.getWindowTitle())
WebUI.closeWindowTitle(aboutPageTitle)

WebUI.switchToWindowIndex(mainWindow)

WebUI.click(findTestObject('AboutPage/btnDrawerMenu'))