package com.service_impl;

import com.modelDataCK.StockModel;
import com.modelDataCK.TotalDataHNXModel;
import com.modelDataCK.TotalDataModel;
import com.service.IGetDataDAO;
import com.service.IStockSum;

import java.util.ArrayList;
import java.util.List;

public class StockSum extends GetDataDAO implements IStockSum {
    @Override
    public List<StockModel> sumList(String date) {
        String[] listFile = {"HNX30-2105.txt", "HNX-2105.txt", "HNXCON-2105.txt", "HNXFin-2105.txt", "HNXLCAP-2105.txt",
                "HNXMAN-2105.txt", "HNXMSCAP-2105.txt", "HOSE-2105.txt","VN30-2105.txt", "VN100-2105.txt",
                "VNALL-2105.txt", "VNMID-2105.txt", "VNSML-2105.txt", "VNX50-2105.txt"};

        List<StockModel> listStock = new ArrayList<>();

        List<TotalDataHNXModel> dataHNXModels = new ArrayList<>();

        List<TotalDataModel> dataModels = new ArrayList<>();

        for (int i = 0; i < listFile.length; i++) {
            IGetDataDAO getDataDAO = new GetDataDAO();
            String file = "data\\" + date + "052020\\" + listFile[i];
            listStock.addAll(getDataDAO.getDataToList(file));
            if(file.contains("HNX")){
                dataHNXModels.add(((GetDataDAO) getDataDAO).getDataHNXModel());
            }
            else {
                dataModels.add(((GetDataDAO) getDataDAO).getDataModel());
            }
        }
        return listStock;
    }
}
