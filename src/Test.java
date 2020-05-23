import com.modelDataCK.StockModel;
import com.modelDataCK.TotalDataModel;
import com.service.IGetDataService;
import com.service_impl.GetDataService;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        File file = new File("data\\21052020\\VN30-2105.txt");
        IGetDataService getData = new GetDataService();
        List<StockModel> stockModels = new ArrayList<>();
        stockModels = getData.getDataToList(file);
        System.out.println(stockModels.size());
        TotalDataModel dataModel = new TotalDataModel();
        dataModel = ((GetDataService) getData).getDataModel();
        System.out.println(dataModel.getNameExchange());
    }
}
