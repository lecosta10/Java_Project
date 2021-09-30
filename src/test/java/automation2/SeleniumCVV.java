package automation2;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;


public class SeleniumCVV {
    private WebDriver driver;

    /* Validar abrir navegador e acessar o site */
    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\Windows\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://front.serverest.dev/login");
    }

    /* Validar inserir dados para realizar o cadastro */
      @Test
    public void inserirDadosParaCadastro() {
        driver.findElement(By.linkText("Cadastre-se")).click();
        driver.findElement(By.name("nome")).sendKeys("Leticia");
        driver.findElement(By.name("email")).sendKeys("lecosta893@gmail.com");
        driver.findElement(By.name("password")).sendKeys("testing123");
        driver.findElement(By.xpath("//button[@data-testid='cadastrar']")).click();

        /* Validar mensagem de erro após digitar email já cadastrado*/
      /*  WebElement error = driver.findElement(By.className("alert alert-dismissible alert-secondary"));
        String errormessage = error.getText();
        Assert.assertEquals("Este email já está sendo usado", errormessage);*/

    }

    /* Validar inserir as credencias de acesso e confirmar */
    @Test
    public void inserirCredenciaisDeAcesso() {
        driver.findElement(By.name("email")).sendKeys("lecosta893@gmail.com");
        driver.findElement(By.name("password")).sendKeys("testing123");
        driver.findElement(By.xpath("//button[@data-testid='entrar']")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        /* Validar acesso a homepage */
        WebElement home = driver.findElement(By.linkText("Home"));
        String texthome = home.getText();
        Assert.assertEquals("Home", texthome);

        driver.findElement(By.xpath("//button[@data-testid='logout']")).click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    }

    @Test
    public void Login() {
        /* Validar inserir as credenciais de acesso e confirmar */
        driver.findElement(By.name("email")).sendKeys("lecosta893@gmail.com");
        driver.findElement(By.name("password")).sendKeys("testing123");
        driver.findElement(By.xpath("//button[@data-testid='entrar']")).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        /* Validar acesso a homepage */
        WebElement home = driver.findElement(By.linkText("Home"));
        String texthome = home.getText();
        Assert.assertEquals("Home", texthome);

        /* Validar cadastrar um produto
        driver.findElement(By.xpath("//a[@data-testid='cadastrarProdutos']")).click();
        driver.findElement(By.name("name")).sendKeys("Fogao");
        driver.findElement(By.name("price")).sendKeys("2399");
        driver.findElement(By.id("exampleFormControlTextarea1")).sendKeys("fogao 5 bocas muito quente");
        driver.findElement(By.name("quantity")).sendKeys("1");
        driver.findElement(By.xpath("//button[@data-testid='cadastarProdutos']")).click();*/


    }

    @After
    public void fecharNavegador() {
        driver.quit();
    }
}