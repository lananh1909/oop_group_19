package getdata;

import java.io.IOException;

public class AppGet {
	
	public static void main(String[] args) {
		try {
			new GetDataHNX("HNX", "data/04062020/HNX-0406.txt").getData();
			new GetDataHNX("HNX30", "data/04062020/HNX30-0406.txt").getData();
			
			new GetDataHOSE("HOSE", "data/04062020/HOSE-0406.txt").getData();
			new GetDataHOSE("VN30", "data/04062020/VN30-0406.txt").getData();	
			
			new GetDataUPCOM("UPCOM", "data/04062020/UPCOM-0406.txt").getData();	
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
