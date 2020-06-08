package getdata;

import java.io.IOException;

public class AppGet {
	
	public static void main(String[] args) {
		try {
			new GetDataHNX("HNX", "data/08062020/HNX-0806.txt").getData();
			new GetDataHNX("HNX30", "data/08062020/HNX30-0806.txt").getData();
			
			new GetDataHOSE("HOSE", "data/08062020/HOSE-0806.txt").getData();
			new GetDataHOSE("VN30", "data/08062020/VN30-0806.txt").getData();	
			
			new GetDataUPCOM("UPCOM", "data/08062020/UPCOM-0806.txt").getData();	
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
