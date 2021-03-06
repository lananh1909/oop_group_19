package getdata;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GetDataHOSE extends GetDataFromWeb {
	
	public GetDataHOSE (String san, String file) throws IOException {
		super(san, file);
	}
	
	@Override
	public void getIndexDetail() {
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
	
	@Override
	public void getData() {
		try {
			getElement();
			getIndex();
			getIndexDetail();
			List<WebElement> rows_table = table.findElements(By.tagName("tr"));
			int rows_count = rows_table.size();
			System.out.println(rows_count);
			for (int i = 2; i < rows_count; i++) {
				List <WebElement> columns_row = rows_table.get(i).findElements(By.tagName("td"));
				int columns_count = columns_row.size();
				String name = columns_row.get(0).findElement(By.tagName("div")).findElement(By.tagName("span")).getText();
				out.write(name + "\t");
				
				for (int j = 1; j < columns_count; j++) {
					if(j==10 || j==16 || j==17) continue;
					String cell_text = columns_row.get(j).getText().replace(",", "");
					if(cell_text.equals("")) cell_text = "0";
					out.write(cell_text + "\t");
				}
				out.write("\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null)
				try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			driver.close();
		}
	}
}

