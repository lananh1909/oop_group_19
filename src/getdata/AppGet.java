package getdata;

import java.io.IOException;

public class AppGet {
	
	public static void main(String[] args) {
		try {
//			new GetDataHNX("HNX", "data/03062020/HNX-0306.txt").getData();
//			new GetDataHNX("HNX30", "data/03062020/HNX30-0306.txt").getData();
			
			new GetDataHOSE("HOSE", "data/03062020/HOSE-0306.txt").getData();
			new GetDataHOSE("VN30", "data/03062020/VN30-0306.txt").getData();	
			
			new GetDataUPCOM("UPCOM", "data/03062020/UPCOM-0306.txt").getData();	
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
