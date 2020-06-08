package com.dao_impl;

import com.modelDataCK.StockModel;
import com.modelDataCK.TotalDataHNXModel;
import com.modelDataCK.TotalDataHOSEModel;
import com.dao.IGetDataDAO;
import com.dao.IStockSum;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StockSum extends GetDataDAO implements IStockSum {
    @Override
    public List<StockModel> sumList(String date) throws IOException {
        String[] listFile = {"HNX30-", "HNX-", "HNXCON-", "HNXFin-", "HNXLCAP-",
                "HNXMAN-", "HNXMSCAP-", "HOSE-","VN30-", "VN100-", "VNALL-",
                "VNMID-", "VNSML-", "VNX50-"};

        List<StockModel> listStock = new ArrayList<>();

        List<TotalDataHNXModel> dataHNXModels = new ArrayList<>();

        List<TotalDataHOSEModel> dataModels = new ArrayList<>();

        for (int i = 0; i < listFile.length; i++) {
            IGetDataDAO getDataDAO = new GetDataDAO();
            String file = "data\\" + date + "052020\\" + listFile[i] + date + "05.txt";
            listStock.addAll(getDataDAO.getDataToList(file));
            if(file.contains("HNX")){
                dataHNXModels.add(((GetDataDAO) getDataDAO).getDataToHNX(file));
            }
            else {
                dataModels.add(((GetDataDAO) getDataDAO).getDataToModel(file));
            }
        }
        return listStock;
    }
}
