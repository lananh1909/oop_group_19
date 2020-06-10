package getdata;

import java.io.IOException;

public class AppGet {
	
	public static void main(String[] args) {
		try {
			new GetDataHNX("HNX", "data//10062020//HNX-1006.txt").getData();
			new GetDataHNX("HNX30", "data//10062020//HNX30-1006.txt").getData();
			new GetDataHOSE("HOSE", "data//10062020//HOSE-1006.txt").getData();
			new GetDataHOSE("VN30", "data//10062020//VN30-1006.txt").getData();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
