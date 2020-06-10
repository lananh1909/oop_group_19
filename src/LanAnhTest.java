import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.dao_impl.GetDataDAO;
import com.modeldatack.GenericTotalModel;
import com.modeldatack.StockModel;
import com.modeldatack.TotalDataHNXModel;
import com.modeldatack.TotalDataHOSEModel;
import com.process.FormatDate;
import com.sentences.exchangeOnDay.DiemSang;
import com.sentences.exchangeOnDay.KhoiLuongGiaoDichLon;
import com.sentences.exchangeOnDay.MaGiaBanCao;
import com.sentences.exchangeOnDay.NNBan;
import com.sentences.exchangeOnDay.NNmua;
import com.sentences.exchangeOnDay.RoomNNcao;
import com.sentences.exchangeOnDay.TDGiaCaoNhat;
import com.sentences.exchangeOnDay.TangVotGiamManh;
import com.sentences.indexOfExChange.IndexSentenceHNX;
import com.sentences.indexOfExChange.IndexSentenceHOSE;
import com.sentences.stockCodeOnDay.CaoNhatThapNhat;

public class LanAnhTest {
	private GetDataDAO getDataDAO = new GetDataDAO();
	private GenericTotalModel generic;
	private List<StockModel> stockModel = new ArrayList<StockModel>();
	private HashMap<String, ArrayList<StockModel>> hashMap = new HashMap<String, ArrayList<StockModel>>(); 
	private final String lst [] = {
			"2105",
			"2205",
			"2505",
			"2605",
			"2705",
			"2805",
			"2905",
			"0106",
			"0206",
			"0306",
			"0406",
			"0506"
	};
	
	public void getHashMap(String san){
		for (int i = 0; i<lst.length; i++) {
			String file = "data\\" + lst[i] + "2020\\" + san + "-" + lst[i] + ".txt";
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
	
	public void exchangeOnDay(String san) throws IOException {
		String file1 = "data\\21052020\\" + san + "-2105" + ".txt";
		List<StockModel> firstDay = getDataDAO.getDataToList(file1);
		for (int i = 0; i<lst.length; i++) {
			System.out.println(new FormatDate().formatDate(lst[i]) + ":");
			String file = "data\\" + lst[i] + "2020\\" + san + "-" + lst[i] + ".txt";
			List<StockModel> stockList = getDataDAO.getDataToList(file);
			

			if (san.contains("HNX") || san.contains("UPCOM")) {
				generic = getDataDAO.getDataToHNX(file);
				TotalDataHNXModel total = (TotalDataHNXModel) generic;
				System.out.println(new IndexSentenceHNX(total).createSentence());
			} else { 
				generic = getDataDAO.getDataToModel(file);
				TotalDataHOSEModel total1 = (TotalDataHOSEModel) generic;
				System.out.println(new IndexSentenceHOSE(total1).createSentence());
			}	
			
			System.out.println(new TangVotGiamManh(stockList, generic).createSentence());	
			
			System.out.println(new MaGiaBanCao(stockList).createSentence());
			System.out.println(new DiemSang(stockList).createSentence());
			System.out.println(new KhoiLuongGiaoDichLon(stockList).createSentence());
			System.out.println(new NNmua(stockList).createSentence());
			System.out.println(new NNBan(stockList).createSentence());
			System.out.println(new RoomNNcao(stockList).createSentence());
			System.out.println(new TDGiaCaoNhat(stockList).createSentence());
			
		}
	}
	
	public void stockCodeOnDay (String san, String date) {
		System.out.println(new FormatDate().formatDate(date) + ":");
		String file = "data\\" + date + "2020\\" + san + "-" + date + ".txt";
		List<StockModel> stockList = getDataDAO.getDataToList(file);
		for (StockModel s : stockList) {
			System.out.println(s.getStockCode() + ":");
			System.out.println("\t" + new CaoNhatThapNhat(s).createSentence());
		}
	}
	
	public static void main(String[] args) {
		LanAnhTest test = new LanAnhTest();
//		test.stockCodeOnDay("UPCOM", "2605");
		try {
			test.exchangeOnDay("UPCOM");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		test.getHashMap("HOSE");
//		chạy r đó
//		for (String key: test.hashMap.keySet()) {
//			List<StockModel> stock = test.hashMap.get(key);
//			System.out.println(key + ":");
//			boolean a = new CacNgayGiam(stock).createSentence().equals("");
//			if (!a) {
//				System.out.println(new CacNgayGiam(stock).createSentence());
//			}
//			System.out.println(new DaoDongGia(stock).createSentence());
//			boolean d = new GiaRotManh(stock).createSentence().equals("");
//			if (!d) {
//					System.out.println(new GiaRotManh(stock).createSentence());
//				}
//			System.out.println(new KhopLenhTrongTuan(stock).createSentence());
//			System.out.println(new RoomNN(stock).createSentence());
//			boolean d1 = new TangLienTiep(stock).createSentence().equals("");
//			if (!d1) {
//					System.out.println(new TangLienTiep(stock).createSentence());
//				}
//			boolean d2 = new GiamLienTiep(stock).createSentence().equals("");
//			if (!d2) {
//					System.out.println(new GiamLienTiep(stock).createSentence());
//				}
//			boolean d3 = new DungGiaThamChieu(stock).createSentence().equals("");
//			if (!d3) {
//					System.out.println(new DungGiaThamChieu(stock).createSentence());
//				}
//			}
		}
	}
