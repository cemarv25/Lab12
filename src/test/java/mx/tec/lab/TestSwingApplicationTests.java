package mx.tec.lab;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestSwingApplicationTests {
	TestSwingApplication application = new TestSwingApplication();

	@Test
	void givenTwoIntegers_WhenSum_ThenCorrectResult() {
		// Given 5 and 7
		application.numberOneTextField.setText("5");
		application.numberTwoTextField.setText("7");
		String expectedResult = "12";
		
		// When operation is sum
		application.operationButton.doClick();
		
		// Then result is 12
		String actualResult = application.resultTextField.getText();
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	void givenANonInteger_WhenSum_ThenError() {
		// Given 5 and 7
		application.numberOneTextField.setText("abc");
		application.numberTwoTextField.setText("7");
		String expectedResult = "Insert a valid integer.";
		
		// When operation is sum
		application.operationButton.doClick();
		
		// Then result is 12
		String actualResult = application.resultTextField.getText();
		assertEquals(expectedResult, actualResult);
	}

}
