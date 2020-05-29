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
	
	public void getElement () {
		WebDriver driver = new ChromeDriver();
//		driver.get("http://priceboard1.vcsc.com.vn/vcsc/vnSml");
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void getIndexDetail(){
		WebElement detail = this.index.findElement(By.id("hoseIndexDetail")).findElement(By.tagName("table")).findElement(By.tagName("tbody"));
		List<WebElement> rows = detail.findElements(By.tagName("tr"));
		try {
			for(WebElement row: rows) {
				List<WebElement> columns = row.findElements(By.tagName("td"));
				int count = columns.size();
				for (int i = 0; i < count; i++) {
					if (i==0 || i==2 || i==4 || i==6 || i>=8) continue;
					if (i==3) {
						WebElement w = columns.get(i).findElement(By.tagName("label"));
						out.write(w.getText().replace(",", "") + "\t");
					} else {
						WebElement w = columns.get(i);
						out.write(w.getText().replace(",", "") + "\t");
					}
				}
				out.write("\n");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void getIndexDetail1() {
		WebElement detail = this.index.findElement(By.id("hnxIndexDetail")).findElement(By.tagName("table")).findElement(By.tagName("tbody"));
		List<WebElement> rows = detail.findElements(By.tagName("tr"));
		try {
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
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void getIndexDetail2() {
		WebElement detail = this.index.findElement(By.id("upcomIndexDetail")).findElement(By.tagName("table")).findElement(By.tagName("tbody"));
		List<WebElement> rows = detail.findElements(By.tagName("tr"));
		try {
			for(WebElement row: rows) {
				List<WebElement> columns = row.findElements(By.tagName("td"));
				int count = columns.size();
				for (int i = 0; i < count; i++) {
					if (i==1 || i==3) {
						WebElement w = columns.get(i);
						out.write(w.getText().replace(",", "") + "\t");
					} else 
						continue;
				}
				out.write("\n");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void getData() throws IOException {
		try {
			List<WebElement> rows_table = table.findElements(By.tagName("tr"));
			int rows_count = rows_table.size();
			System.out.println(rows_count);
			for (int i = 2; i < rows_count; i++) {
				List <WebElement> columns_row = rows_table.get(i).findElements(By.tagName("td"));
				int columns_count = columns_row.size();
				String name = columns_row.get(0).findElement(By.tagName("div")).findElement(By.tagName("span")).getText();
//				String companyName = columns_row.get(0).getAttribute("en").replace(" ", "-");
				out.write(name + "\t");
//				out.write(companyName + "\t");
				
//				for (int j = 1; j < columns_count; j++) {
//					if(j==10 || j==16 || j==17) continue;
//					String cell_text = columns_row.get(j).getText().replace(",", "");
//					if(cell_text.equals("")) cell_text = "0";
//					out.write(cell_text + "\t");
//				}
				
				for (int j = 1; j < columns_count; j++) {
					if(j==11 || j==17 || j==18 || j==4 || j==25) continue;
					String cell_text = columns_row.get(j).getText().replace(",","");
					if(cell_text.equals("")) cell_text = "0";
					out.write(cell_text + "\t");
				}
				out.write("\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null) out.close();
		}
	}
	
	public static void main (String [] args) {
		try {
//			GetDataFromWeb app = new GetDataFromWeb("VN30","data/29052020/VN30-2905.txt");
//			GetDataFromWeb app = new GetDataFromWeb("HOSE","data/29052020/HOSE-2905.txt");
//			GetDataFromWeb app = new GetDataFromWeb("VN100","data/29052020/VN100-2905.txt");
//			GetDataFromWeb app = new GetDataFromWeb("VNX50","data/29052020/VNX50-2905.txt");
//			GetDataFromWeb app = new GetDataFromWeb("VNALL","data/29052020/VNALL-2905.txt");
//			GetDataFromWeb app = new GetDataFromWeb("VNMID","data/29052020/VNMID-2905.txt");
//			GetDataFromWeb app = new GetDataFromWeb("VNSML","data/29052020/VNSML-2905.txt");
//			GetDataFromWeb app = new GetDataFromWeb("VNSI","data/29052020/VNSI-2905.txt");
//			GetDataFromWeb app = new GetDataFromWeb("HNX","data/29052020/HNX-2905.txt");
//			GetDataFromWeb app = new GetDataFromWeb("HNX30","data/29052020/HNX30-2905.txt");
//			GetDataFromWeb app = new GetDataFromWeb("HNXCON","data/29052020/HNXCON-2905.txt");
//			GetDataFromWeb app = new GetDataFromWeb("HNXFIN","data/29052020/HNXFIN-2905.txt");
//			GetDataFromWeb app = new GetDataFromWeb("HNXLCAP","data/29052020/HNXLCAP-2905.txt");
//			GetDataFromWeb app = new GetDataFromWeb("HNXMSCAP","data/29052020/HNXMSCAP-2905.txt");
//			GetDataFromWeb app = new GetDataFromWeb("HNXMAN","data/29052020/HNXMAN-2905.txt");
			GetDataFromWeb app = new GetDataFromWeb("UPCOM","data/29052020/UPCOM-2905.txt");
		
			app.getElement();
			app.getIndex();
//			app.getIndexDetail();
//			app.getIndexDetail1();
			app.getIndexDetail2();
			app.getData();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
