package new1;

public class Select {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
WebElement dropdownElement = driver.findElement(By.id("dropdownId"));

//Create a Select object
Select dropdown = new Select(dropdownElement);

//Select an option by visible text
dropdown.selectByVisibleText("Option Text");

//Select an option by value attribute
dropdown.selectByValue("optionValue");

//Select an option by index
dropdown.selectByIndex(1);
