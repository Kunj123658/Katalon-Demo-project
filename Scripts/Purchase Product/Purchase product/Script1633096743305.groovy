import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import org.stringtemplate.v4.compiler.STParser.element_return as element_return
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
import jdk.internal.instrumentation.MethodCallInliner.CatchBlock as CatchBlock

WebUI.click(findTestObject('Addtocart/btnAddtocartFirstProduct'))

//String a = WebUI.getText('Addtocart/firstProductName')
WebUI.click(findTestObject('Addtocart/btnCart'))

WebUI.click(findTestObject('BuyProduct/btnCheckout'))

WebUI.setText(findTestObject('BuyProduct/txtUserFirstName'), FirstName)

WebUI.setText(findTestObject('BuyProduct/txtUserLastName'), LastName)

WebUI.setText(findTestObject('BuyProduct/txtUserZipCode'), ZipCode)

WebUI.click(findTestObject('BuyProduct/btnContinue'))



try {
	if (WebUI.verifyElementVisible(findTestObject('BuyProduct/errorMessage'), FailureHandling.CONTINUE_ON_FAILURE)) {
		println(WebUI.getText(findTestObject('BuyProduct/errorMessage')))
	} else {
		println('User redirected on checkout page successfully')
	}
}
catch (Exception e) {
	println(e.getMessage())
} 

