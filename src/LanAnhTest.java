import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.dao.IGetDataDAO;
import com.dao_impl.GetDataDAO;
import com.modelDataCK.StockModel;
import com.sentences.stockCodeExchangeByDay.DaoDongGia;
import com.sentences.stockCodeExchangeByDay.GiaRotManh;
import com.sentences.stockCodeExchangeByDay.KhopLenhTrongTuan;
import com.sentences.stockCodeExchangeByDay.RoomNN;

public class LanAnhTest {
	private IGetDataDAO getDataDAO = new GetDataDAO();;
	private List<StockModel> stockModel = new ArrayList<StockModel>();
	private HashMap<String, ArrayList<StockModel>> hashMap = new HashMap<String, ArrayList<StockModel>>(); 
	
	public void getHashMap(){
		String lst [] = {
				"2105",
				"2205",
				"2505",
				"2605"
		};
	
		for (int i = 0; i<lst.length; i++) {
			String file = "data\\" + lst[i] + "2020\\HOSE-" + lst[i] + ".txt";
			List<StockModel> stockList = getDataDAO.getDataToList(file);
			if (i==0) {
				for (StockModel stock: stockList) {
					hashMap.put(stock.getStockCode(), new ArrayList<StockModel>());
					hashMap.get(stock.getStockCode()).add(stock);
				}
			} else {
				for (StockModel stock: stockList) {
					hashMap.get(stock.getStockCode()).add(stock);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		LanAnhTest test = new LanAnhTest();
		test.getHashMap();
		
		for (String key: test.hashMap.keySet()) {
			List<StockModel> stockModel = test.hashMap.get(key);
			System.out.println(key + ":");
			System.out.println(new DaoDongGia(stockModel).createSentence());
			if (! new GiaRotManh(stockModel).createSentence().equals("")) {
					System.out.println(new GiaRotManh(stockModel).createSentence());
				}
				System.out.println(new KhopLenhTrongTuan(stockModel).createSentence());
				System.out.println(new RoomNN(stockModel).createSentence());
			}
		}
	}
