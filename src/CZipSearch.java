import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

//==============================================
//작성자      : 안성호
//작성일      : 2014-10-14(수)
//Comment : 본 프로그램은 우편번호를 검색해주는 프로그램 임. 
//Version     : 1.0
//==============================================

public class CZipSearch {

	private BufferedReader brZipData;											//ZipData 파일을 읽을 때 사용 할 BufferedReader
	private String strDongName;														
	private String strFilePath;
	private String strRowData;												    //Zip코드 저장 파일로 부터 읽어 들인 한줄 전체 데이터 	
	public String[] strArrSpliteData;											//한줄 전체 데이터로 부터 탭 값으로 분리해낸 데이터
	public int iRowNum = -1;
	CZipSearch(){
		
		brZipData = null;
		strDongName = null;
		strRowData = null;
		iRowNum = -1;

	}
	CZipSearch(String _strFilePath){
	
		brZipData = null;
		strDongName = null;
		strRowData = null;
		strFilePath = _strFilePath;
		
	}
	

	protected BufferedReader getBrZipData() {
		return brZipData;
	}

	protected void setBrZipData(BufferedReader brZipData) {
		this.brZipData = brZipData;
	}

	protected String getStrDongName() {
		return strDongName;
	}

	protected void setStrDongName(String strDongName) {
		this.strDongName = strDongName;
	}

	protected String getStrFilePath() {
		return strFilePath;
	}

	protected void setStrFilePath(String strFilePath) {
		this.strFilePath = strFilePath;
	}

	protected String getStrRowData() {
		return strRowData;
	}

	protected void setStrRowData(String strRowData) {
		this.strRowData = strRowData;
	}
	
	
	//InitBufferReader 초기화
	public void InitBufferReader(){
		
		try {
			brZipData = new BufferedReader(new FileReader(strFilePath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	//Step 2 : 사용자 입력 값 유효성 검사
	public Boolean InputValidation(){
		if(strDongName.length() < 2){
			
			return false;
		}
		if(strDongName.matches(".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*") == false){
			
			return false;
		}
		
		return true;
	}
	
	//Step 3 : 데이터 Read
	public Boolean ReadZipCode(){
		 try{
			 	strRowData  = brZipData.readLine();
			 	if(strRowData == null){
			 		return false;
			 	}
		 }catch(IOException e){
			 e.printStackTrace();
		 }
		 return true;
	 }
	 
	 //Step 4 : RowData 문자열 분리 : "\t" 값으로 분리..
	public void SpliteRowData(){
		 String strArrData[] = strRowData.split("\t"); 
		 this.strArrSpliteData = strArrData;
	 }
	 
	 //Step 5 : 동 이름 비교 ->사용자가 입력 한 동 이름과 읽어 들인 데이터가 같은지 비교 -> 같으면 true 다르면 false 
	public Boolean CheckDongNameYn(){
		if(!strArrSpliteData[3].startsWith(strDongName)){
			return false;
		}
		iRowNum++;
		return true;
	}
	
	//Step 6 : 출력 
	public String DisplayData(){
		String strResult = String.format("[%s]\t%s\t%s\t%s\t%s\t%s\r\n",strArrSpliteData[0],strArrSpliteData[1],strArrSpliteData[2],strArrSpliteData[3],strArrSpliteData[4],strArrSpliteData[5]);
		return strResult;
	}
	
	//Step 7 : BufferReader Close ->자원반납
	public void CloseBuffrerReader(){
	
		if(brZipData != null){
			try{brZipData.close();}catch(IOException e){}
		}
	}

}
