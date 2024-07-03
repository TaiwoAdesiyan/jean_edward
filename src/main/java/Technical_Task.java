import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class Technical_Task {

    public static void main(String[] args) throws InterruptedException {

        //Invoke the browser
        System.setProperty("web-driver.chrome.driver", "chromedriver.exe");
        //Add chrome options menu
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-web-security");
        //Open the browser
        WebDriver driver = new ChromeDriver(options);
        //Maximise the browser
        driver.manage().window().maximize();
        //Navigate to url
        driver.get("https://www.saucedemo.com/");
        //user input valid user name
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //user input valid password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //user clicks login button
        driver.findElement(By.id("login-button")).click();
        //User clicks on T-shirt image
        Thread.sleep(4000);
        driver.findElement(By.xpath("//img[@alt='Sauce Labs Bolt T-Shirt']")).click();
        //User checks if t shirt image is display
        Boolean T_shirt= driver.findElement(By.xpath("//img[@alt='Sauce Labs Bolt T-Shirt']")).isDisplayed();
        System.out.println("check if t shirt is display " + T_shirt);
        // user clicks add to cart icon
        driver.findElement(By.id("add-to-cart")).click();
        //User clicks add to cart menu
        driver.findElement(By.className("shopping_cart_badge")).click();
        //user verify if cart page is display
      Boolean cart =  driver.findElement(By.className("shopping_cart_badge")).isDisplayed();
        System.out.println("check if cart is display " + cart);
        //user clicks on check out button
        Thread.sleep(4000);
        driver.findElement(By.xpath("//button[@id='checkout']")).click();
        // User checks if check out information is display
        Thread.sleep(4000);
       Boolean checkout = driver.findElement(By.xpath("//span[contains(text(),'Checkout: Your Information')]")).isDisplayed();
        System.out.println("check if check out is display " + checkout);
        //User input name in the checkout information
        driver.findElement(By.id("first-name")).sendKeys("Taiwo");
        // User input last name
        driver.findElement(By.id("last-name")).sendKeys("Hassan");
        //User input zip/postal code
        driver.findElement(By.id("postal-code")).sendKeys("12, Ben Street UK");
        //user click on continue button
        driver.findElement(By.id("continue")).click();
        //user clicks finish button
        driver.findElement(By.id("finish")).click();
        //user checks order confirmation page is displayed, indicating a successful purchase
        Boolean success_purchase
                =driver.findElement(By.xpath("//span[@class='title']")).isDisplayed();
        System.out.println(success_purchase);
        //user clicks on react burger menu
        driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).click();
        //User clicks on log out menu
        driver.findElement(By.id("logout_sidebar_link")).click();
        // verify current and expected url
        String current_url =   driver.getCurrentUrl();
        String expected_url = "https://www.saucedemo.com/";
        Assert.assertTrue(expected_url.equalsIgnoreCase(current_url));
        //quit browser
        driver.quit();
    }
}
