package com.dao_impl;

import com.dao.IGetDataDAO;
import com.dao.IStockSum;
import com.modeldatack.StockModel;
import com.modeldatack.TotalDataHNXModel;
import com.modeldatack.TotalDataHOSEModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StockSum extends GetDataDAO implements IStockSum {
    //    String[] listFile = {"HNX30-", "HNX-", "HNXCON-", "HNXFIN-", "HNXLCAP-",
//            "HNXMAN-", "HNXMSCAP-", "HOSE-","VN30-", "VN100-", "VNALL-",
//            "VNMID-", "VNX50-"};
    String[] listFile = {"HNX-",  "HNX30-", "HOSE-","VN30-"};

    @Override
    public List<StockModel> sumList(String date) {

        List<StockModel> listStock = new ArrayList<>();

        IGetDataDAO getDataDAO = new GetDataDAO();

        for(int i = 0; i<listFile.length; i++){
            String file = "data\\" + date + "2020\\" + listFile[1] + "-" + date + ".txt";
            listStock.addAll(getDataDAO.getDataToList(file));
        }
        return listStock;
    }

    @Override
    public List<TotalDataHNXModel> sumIndexHNX(String date) throws IOException {
//        String[] listFile = {"HNX30-", "HNX-", "HNXCON-", "HNXFIN-", "HNXLCAP-",
//                "HNXMAN-", "HNXMSCAP-", "HOSE-","VN30-", "VN100-", "VNALL-",
//                "VNMID-", "VNX50-"};
        List<TotalDataHNXModel> hnxModelList = new ArrayList<>();
        for(int i = 0; i < listFile.length; i++){
            if(listFile[i].contains("HNX") || listFile[i].contains("UPCOM")){
                String file = "data\\" + date + "2020\\" + listFile[i] + date + ".txt";
                IGetDataDAO getDataDAO = new GetDataDAO();
                hnxModelList.add(((GetDataDAO) getDataDAO).getDataToHNX(file));
            }
        }
        return hnxModelList;
    }

    @Override
    public List<TotalDataHOSEModel> sumIndexNotHNX(String date) throws IOException {
//        String[] listFile = {"HNX30-", "HNX-", "HNXCON-", "HNXFIN-", "HNXLCAP-",
//                "HNXMAN-", "HNXMSCAP-", "HOSE-","VN30-", "VN100-", "VNALL-",
//                "VNMID-", "VNX50-"};
        List<TotalDataHOSEModel> modelList = new ArrayList<>();
        for(int i = 0; i < listFile.length; i++){
            if(!listFile[i].contains("HNX") && !listFile[i].contains("UPCOM")){
                String file = "data\\" + date + "2020\\" + listFile[i] + date + ".txt";
                IGetDataDAO getDataDAO = new GetDataDAO();
                modelList.add(((GetDataDAO) getDataDAO).getDataToModel(file));
            }
        }
        return modelList;
    }

    @Override
    public List<StockModel> sumListOfExchange(String date, String floor) {
        String file = "data\\" + date + "2020\\" + floor + "-" + date + ".txt";
        IGetDataDAO getDataDAO = new GetDataDAO();
        return getDataDAO.getDataToList(file);
    }
}
