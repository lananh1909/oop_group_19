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
		out.write(idx + "\n");
		
		WebElement idxChange = this.index.findElement(By.id(this.san + "_idxchg"));
		String idxchg = idxChange.getText();
		out.write(idxchg + "\t");
		
		WebElement idxPct = this.index.findElement(By.id(this.san + "_idxpct"));
		String idxpct = idxPct.getText();
		out.write(idxpct + "\n");		
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
					out.write(w.getText().replace(",", "") + "\t");
				} else {
					WebElement w = columns.get(i);
					out.write(w.getText().replace(",", "") + "\t");
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
					out.write(w.getText().replace(",", "") + "\t");
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
//					String cell_text = columns_row.get(j).getText().replace(",", "");
//					if(cell_text.equals("")) cell_text = "0";
//					//System.out.println(cell_text);
//					out.write(cell_text + "\t");
//				}
				
				for (int j = 1; j < columns_count; j++) {
					if(j==11 || j==17 || j==18 || j==4 || j==25) continue;
					String cell_text = columns_row.get(j).getText().replace(",","");
					if(cell_text.equals("")) cell_text = "0";
					//System.out.println(cell_text);
					out.write(cell_text + "\t");
				}
				out.write("\n");
			}
		} finally {
			if (out != null) out.close();
		}
	}
	
	public static void main (String [] args) throws InterruptedException, IOException {
//		GetDataFromWeb app = new GetDataFromWeb("VN30","data/21052020/VN30-2105.txt");
//		GetDataFromWeb app = new GetDataFromWeb("HOSE","data/21052020/HOSE-2105.txt");
//		GetDataFromWeb app = new GetDataFromWeb("VN100","data/21052020/VN100-2105.txt");
//		GetDataFromWeb app = new GetDataFromWeb("VNX50","data/21052020/VNX50-2105.txt");
//		GetDataFromWeb app = new GetDataFromWeb("VNALL","data/21052020/VNALL-2105.txt");
//		GetDataFromWeb app = new GetDataFromWeb("VNMID","data/21052020/VNMID-2105.txt");
//		GetDataFromWeb app = new GetDataFromWeb("VNSML","data/21052020/VNSML-2105.txt");
//		GetDataFromWeb app = new GetDataFromWeb("VNSI","data/21052020/VNSI-2105.txt");
//		GetDataFromWeb app = new GetDataFromWeb("HNX","data/21052020/HNX-2105.txt");
//		GetDataFromWeb app = new GetDataFromWeb("HNX30","data/21052020/HNX30-2105.txt");
//		GetDataFromWeb app = new GetDataFromWeb("HNXCON","data/21052020/HNXCON-2105.txt");
//		GetDataFromWeb app = new GetDataFromWeb("HNXFIN","data/21052020/HNXFIN-2105.txt");
//		GetDataFromWeb app = new GetDataFromWeb("HNXLCAP","data/21052020/HNXLCAP-2105.txt");
//		GetDataFromWeb app = new GetDataFromWeb("HNXMSCAP","data/21052020/HNXMSCAP-2105.txt");
//		GetDataFromWeb app = new GetDataFromWeb("HNXMAN","data/21052020/HNXMAN-2105.txt");
		GetDataFromWeb app = new GetDataFromWeb("UPCOM","data/21052020/UPCOM-2105.txt");
	
		app.getElement();
		app.getIndex();
//		app.getIndexDetail();
		app.getIndexDetail1();
		app.getData();
	}
	
}
