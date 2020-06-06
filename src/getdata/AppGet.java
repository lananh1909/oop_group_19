package getdata;

import java.io.IOException;

public class AppGet {
	
	public static void main(String[] args) {
		try {
			new GetDataHNX("HNX", "data/05062020/HNX-0506.txt").getData();
			new GetDataHNX("HNX30", "data/05062020/HNX30-0506.txt").getData();
			
			new GetDataHOSE("HOSE", "data/05062020/HOSE-0506.txt").getData();
			new GetDataHOSE("VN30", "data/05062020/VN30-0506.txt").getData();	
			
			new GetDataUPCOM("UPCOM", "data/05062020/UPCOM-0506.txt").getData();	
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
