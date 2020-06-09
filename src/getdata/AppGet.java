package getdata;

import java.io.IOException;

public class AppGet {
	
	public static void main(String[] args) {
		try {
			new GetDataHNX("HNX", "data//09062020//HNX-0906.txt").getData();
			new GetDataHNX("HNX30", "data//09062020//HNX30-0906.txt").getData();
			new GetDataHOSE("HOSE", "data//09062020//HOSE-0906.txt").getData();
			new GetDataHOSE("VN30", "data//09062020//VN30-0906.txt").getData();
			new GetDataUPCOM("UPCOM", "data//09062020//UPCOM-0906.txt").getData();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
