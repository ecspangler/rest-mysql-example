package org.example.step.definitions;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.example.model.Customer;
import org.example.validation.error.ValidationError;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CustomerValidationSteps {

	private static final String UNIQUE_ID = "Unique Id";
	private static final String FIRST_NAME = "First Name";
	private static final String LAST_NAME = "Last Name";
	private static final String ACCOUNT_NUMBER = "Account Number";
	private static final String FAVORITE_COLOR = "Favorite Color";
	private static final String ERROR_CODE = "Error Code";
	private static final String ERROR_DESCRIPTION = "Error Description";

	private CustomerValidationTestContext testContext = new CustomerValidationTestContext();

	@Given("^I have a Customer with the following:$")
	public void i_have_a_Customer_with_the_following(DataTable customerTable) throws Throwable {
		testContext.setCustomer(makeCustomer(customerTable));
	}

	@When("^I validate the Customer$")
	public void i_validate_the_Customer() throws Throwable {
		testContext.execute();
	}

	@Then("^I expect the following validation errors:$")
	public void i_expect_the_following_validation_errors(DataTable errorsTable) throws Throwable {
		List<ValidationError> expectedErrors = makeValidationErrors(errorsTable);
		List<ValidationError> actualErrors = testContext.getErrors();

		System.out.println("\n\nExpected errors: " + expectedErrors);
		System.out.println("Actual errors: " + actualErrors);

		assertEquals(expectedErrors.size(), actualErrors.size());

		testContext.getErrors().forEach(actualError -> {
			expectedErrors.forEach(expectedError -> {
				assertEquals(actualError.getErrorCode(), expectedError.getErrorCode());
				assertEquals(actualError.getErrorDescription(), expectedError.getErrorDescription());
			});
		});
	}

	private Customer makeCustomer(DataTable customerTable) {
		Customer customer = new Customer();

		List<Map<String, String>> rows = customerTable.asMaps(String.class, String.class);
		rows.forEach(row -> {
			customer.setUniqueId(row.get(UNIQUE_ID));
			customer.setFirstName(row.get(FIRST_NAME));
			customer.setLastName(row.get(LAST_NAME));
			customer.setAccountNumber(row.get(ACCOUNT_NUMBER));
			customer.setFavoriteColor(row.get(FAVORITE_COLOR));
		});

		return customer;
	}

	private List<ValidationError> makeValidationErrors(DataTable validationErrorsTable) {
		List<ValidationError> expectedErrors = new ArrayList<ValidationError>();

		List<Map<String, String>> rows = validationErrorsTable.asMaps(String.class, String.class);
		rows.forEach(row -> {
			// if (!(row.get(ERROR_CODE) == null || row.get(ERROR_CODE).equals(""))) {
			if (!row.get(ERROR_CODE).equals("")) {
				ValidationError expectedError = new ValidationError();
				expectedError.setErrorCode(row.get(ERROR_CODE));
				expectedError.setErrorDescription(row.get(ERROR_DESCRIPTION));
				expectedErrors.add(expectedError);
			}
		});

		return expectedErrors;
	}

}
