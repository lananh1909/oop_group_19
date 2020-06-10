package getdata;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;;

public abstract class GetDataFromWeb {	
	String san;
	WebElement index;
	WebElement table;	
	FileWriter out = null;
	WebDriver driver = new ChromeDriver();
	
	public GetDataFromWeb (String san, String file) throws IOException {
		this.san = san;
		this.out = new FileWriter(new File(file));
		out.write(san + "\n");
	}
	
	public void getElement () {
		driver.get("http://priceboard1.vcsc.com.vn/vcsc/" + this.san.toLowerCase());
		
		this.index = driver.findElement(By.id(this.san + "_index"));
		
		this.table = driver.findElement(By.xpath("//*[@id=\"stockTable\"]/tbody"));
	}
	
	public void getIndex() {
		WebElement inD = this.index.findElement(By.id(this.san + "_idx"));
		String idx = inD.getText().replace(",", "");
		try {
			out.write(idx + "\n");
		
		WebElement idxChange = this.index.findElement(By.id(this.san + "_idxchg"));
		String idxchg = idxChange.getText().replace(",", "");
		out.write(idxchg + "\t");
		
		WebElement idxPct = this.index.findElement(By.id(this.san + "_idxpct"));
		String idxpct = idxPct.getText().replace(",", "");
		out.write(idxpct + "\n");	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public abstract void getIndexDetail();
	
	public abstract void getData();
}