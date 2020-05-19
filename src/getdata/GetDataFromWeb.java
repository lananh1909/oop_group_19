package getdata;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetDataFromWeb {	
	private String san;
	private WebElement index;
	private WebElement table;	
	private FileWriter out = null;
	
	public GetDataFromWeb (String san, String file) throws IOException {
		this.san = san;
		this.out = new FileWriter(new File(file));
		out.write(san + "\n");
	}
	
	public void getElement () throws InterruptedException {
		WebDriver driver = new ChromeDriver();
//		driver.get("http://priceboard1.vcsc.com.vn/vcsc/vnSml");
		driver.get("http://priceboard1.vcsc.com.vn/vcsc/" + this.san.toLowerCase());
		
		this.index = driver.findElement(By.id(this.san + "_index"));
		
		this.table = driver.findElement(By.xpath("//*[@id=\"stockTable\"]/tbody"));
	}
	
	public void getIndex() throws IOException {
		WebElement inD = this.index.findElement(By.id(this.san + "_idx"));
		String idx = inD.getText();
		String color1 = inD.getAttribute("class");
		out.write(idx + "\t" + color1 + "\n");
		
		WebElement idxChange = this.index.findElement(By.id(this.san + "_idxchg"));
		String idxchg = idxChange.getText();
		String color2 = idxChange.getAttribute("class");
		out.write(idxchg + "\t" + color2 + "\t");
		
		WebElement idxPct = this.index.findElement(By.id(this.san + "_idxpct"));
		String idxpct = idxPct.getText();
		String color3 = idxPct.getAttribute("class");
		out.write(idxpct + "\t" + color3 + "\n");		
	}
	
	public void getIndexDetail() throws IOException {
		WebElement detail = this.index.findElement(By.id("hoseIndexDetail")).findElement(By.tagName("table")).findElement(By.tagName("tbody"));
		List<WebElement> rows = detail.findElements(By.tagName("tr"));
		for(WebElement row: rows) {
			List<WebElement> columns = row.findElements(By.tagName("td"));
			int count = columns.size();
			for (int i = 0; i < count; i++) {
				if (i==0 || i==4 || i==6 || i>=8) continue;
				if (i==2 || i==3) {
					WebElement w = columns.get(i).findElement(By.tagName("label"));
					out.write(w.getText() + "\t" + w.getAttribute("class") + "\t");
				} else {
					WebElement w = columns.get(i);
					out.write(w.getText() + "\t" + w.getAttribute("class") + "\t");
				}
			}
			out.write("\n");
		}
	}
	
	public void getIndexDetail1() throws IOException {
		WebElement detail = this.index.findElement(By.id("upcomIndexDetail")).findElement(By.tagName("table")).findElement(By.tagName("tbody"));
		List<WebElement> rows = detail.findElements(By.tagName("tr"));
		for(WebElement row: rows) {
			List<WebElement> columns = row.findElements(By.tagName("td"));
			int count = columns.size();
			for (int i = 0; i < count; i++) {
				if (i==2 || i==4) {
					WebElement w = columns.get(i);
					out.write(w.getText() + "\t" + w.getAttribute("class") + "\t");
				} else 
					continue;
			}
			out.write("\n");
		}
	}
	
	public void getData() throws InterruptedException, IOException {
		try {
			List<WebElement> rows_table = table.findElements(By.tagName("tr"));
			int rows_count = rows_table.size();
			System.out.println(rows_count);
			for (int i = 2; i < rows_count; i++) {
				List <WebElement> columns_row = rows_table.get(i).findElements(By.tagName("td"));
				int columns_count = columns_row.size();
				String name = columns_row.get(0).findElement(By.tagName("div")).findElement(By.tagName("span")).getText();
//				System.out.println(name);
				out.write(name + "\t");
				
//				for (int j = 1; j < columns_count; j++) {
//					if(j==10 || j==16 || j==17) continue;
//					String color = columns_row.get(j).getAttribute("class");
//					String cell_text = columns_row.get(j).getText();
//					//System.out.println(cell_text);
//					out.write(cell_text + "\t" + color + "\t");
//				}
				
				for (int j = 1; j < columns_count; j++) {
					if(j==11 || j==17 || j==18 || j==4 || j==25) continue;
					String color = columns_row.get(j).getAttribute("class");
					String cell_text = columns_row.get(j).getText();
					//System.out.println(cell_text);
					out.write(cell_text + "\t" + color + "\t");
				}
				out.write("\n");
			}
		} finally {
			if (out != null) out.close();
		}
	}
	
	public static void main (String [] args) throws InterruptedException, IOException {
//		GetDataFromWeb app = new GetDataFromWeb("VN30","data/19052020/VN30-1905.txt");
//		GetDataFromWeb app = new GetDataFromWeb("HOSE","data/19052020/HOSE-1905.txt");
//		GetDataFromWeb app = new GetDataFromWeb("VN100","data/19052020/VN100-1905.txt");
//		GetDataFromWeb app = new GetDataFromWeb("VNX50","data/19052020/VNX50-1905.txt");
//		GetDataFromWeb app = new GetDataFromWeb("VNALL","data/19052020/VNALL-1905.txt");
//		GetDataFromWeb app = new GetDataFromWeb("VNMID","data/19052020/VNMID-1905.txt");
//		GetDataFromWeb app = new GetDataFromWeb("VNSML","data/19052020/VNSML-1905.txt");
//		GetDataFromWeb app = new GetDataFromWeb("VNSI","data/19052020/VNSI-1905.txt");
//		GetDataFromWeb app = new GetDataFromWeb("HNX","data/19052020/HNX-1905.txt");
//		GetDataFromWeb app = new GetDataFromWeb("HNX30","data/19052020/HNX30-1905.txt");
//		GetDataFromWeb app = new GetDataFromWeb("HNXCON","data/19052020/HNXCON-1905.txt");
//		GetDataFromWeb app = new GetDataFromWeb("HNXFIN","data/19052020/HNXFIN-1905.txt");
//		GetDataFromWeb app = new GetDataFromWeb("HNXLCAP","data/19052020/HNXLCAP-1905.txt");
//		GetDataFromWeb app = new GetDataFromWeb("HNXMSCAP","data/19052020/HNXMSCAP-1905.txt");
//		GetDataFromWeb app = new GetDataFromWeb("HNXMAN","data/19052020/HNXMAN-1905.txt");
		GetDataFromWeb app = new GetDataFromWeb("UPCOM","data/19052020/UPCOM-1905.txt");
	
		app.getElement();
		app.getIndex();
//		app.getIndexDetail();
		app.getIndexDetail1();
		app.getData();
	}
	
}
