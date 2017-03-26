package stlab2;

import java.io.IOException;
import java.nio.charset.Charset;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.*;
import com.csvreader.CsvReader;

public class stlab2 {
	public static void main(String[] args) throws IOException {
        CsvReader r = new CsvReader("D://大三下学习资料//软件测试//实验二//inputgit.csv", ',',Charset.forName("GBK"));
        r.readHeaders();
        while (r.readRecord()) {                        
        r.readRecord();             
        String number_csv = r.get("学号");              
        String name_csv = r.get("姓名");
        String address_csv = r.get("github地址");
        String pwd_csv = number_csv.substring(number_csv.length()-6,number_csv.length());
        
        System.setProperty("webdriver.firefox.bin", "C:/Program Files (x86)/Mozilla Firefox/firefox.exe"); 
        WebDriver driver = new FirefoxDriver();
       driver.get("http://121.193.130.195:8080/");               
       driver.manage().window().maximize();
      //输入用户名
       WebElement input_name = driver.findElement(By.id("name"));
       input_name.clear();
       input_name.sendKeys(number_csv);
      //输入密码
       WebElement input_pwd = driver.findElement(By.id("pwd"));
       input_pwd.clear();
       input_pwd.sendKeys(pwd_csv);
      //点击登录按钮
       WebElement btn = driver.findElement(By.id("submit")); 
       btn.click();
     //登录成功之后，获得当前页面的用户信息
       String info_web = driver.findElement(By.xpath("//tbody[@id='table-main']")).getText();
       String name_web = info_web.substring(info_web.indexOf("名") + 2, info_web.indexOf("学") - 1);
       String number_web = info_web.substring(info_web.indexOf("号") + 2, info_web.indexOf("G") - 1);
       String address_web = info_web.substring(info_web.indexOf("址") + 2);
    //比较查询信息            
       if(name_csv.equals(name_web)&&number_csv.equals(number_web)&&address_csv.equals(address_web))         
                System.out.println("用户信息一致.");        
       else       
                System.out.println(name_web+"的信息不一致.");
        driver.close();
       }
         r.close();
	}
}
