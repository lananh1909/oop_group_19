package com.dao;

import com.modeldatack.StockModel;
import com.modeldatack.TotalDataHNXModel;
import com.modeldatack.TotalDataHOSEModel;

import java.io.IOException;
import java.util.List;

public interface IGetDataDAO {
	
    List<StockModel> getDataToList(String file);

    String [] getDataToArray(String line);

	TotalDataHNXModel getDataToHNX(String file) throws IOException;

	TotalDataHOSEModel getDataToModel(String file) throws IOException;

}
