package com.ivan.blog.util;

import java.io.*;
import java.nio.file.*;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * <pre>
 * 파일관련 공통
 * </pre>
 * @pakege : com.ysm.market.sellermanager.util
 * @Class : FileManager.java
 * @date 2016. 4. 21.
 * @author jk.han
 */
@Component
public class FileManager {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * <pre>
	 * file 목록 불러오기
	 * </pre>
	 * @Method Name : getDirFileList
	 * @date 2016. 4. 21.
	 * @author jk.han
	 */
	public List<File> getDirFileList(String dirPath) {
		List<File> dirFileList = null;
		File dir = new File(dirPath);
		if (dir.exists()) {
			File[] files = dir.listFiles();
			dirFileList = Arrays.asList(files);
		}
		return dirFileList;
	}
	
			
	/**
	 * <pre>
	 * 파일 카피
	 * </pre>
	 * @Method Name : fileCopy
	 * @date 2016. 4. 21.
	 * @author jk.han
	 */
	public void fileCopy(String inFileName, String outFileName) throws Exception {
		
			FileInputStream fis = new FileInputStream(inFileName);
			FileOutputStream fos = new FileOutputStream(outFileName);
			int data = 0;
			while ((data = fis.read()) != -1) {
				fos.write(data);
			}
			fis.close();
			fos.close();
		
	}
	
	/**
	 * <pre>
	 * 파일삭제
	 * </pre>
	 * @Method Name : fileDelete
	 * @date 2016. 4. 21.
	 * @author jk.han
	 */
	public void fileDelete(String deleteFileName) {
		File deleteFile = new File(deleteFileName);
		deleteFile.delete();
	}
	
			
	/**
	 * <pre>
	 * 디렉토리 삭제
	 * </pre>
	 * @Method Name : directoryDelete
	 * @date 2016. 4. 21.
	 * @author jk.han
	 */
	public void directoryDelete(File deleteDirectoryName) {
		File[] listFile = deleteDirectoryName.listFiles();
		if (!(listFile == null)) {
			for (File file : listFile) {
				file.delete();
			}
		}
		deleteDirectoryName.delete();
	}
	
	
	/**
	 * <pre>
	 * 디렉토리 생성
	 * </pre>
	 * @Method Name : directoryCreate
	 * @date 2016. 4. 21.
	 * @author jk.han
	 */
	public void directoryCreate(String dir) {
		File fileDir = new File(dir);
		if(fileDir.exists() == false){
			fileDir.mkdirs();
		}
	}
	
	
	/**
	 * <pre>
	 * 디렉토리 존재여부 확인
	 * </pre>
	 * @Method Name : isDirectory
	 * @date 2016. 9. 23.
	 * @author jaesik
	 */
	public boolean isDirectory(String dir) {
		File fileDir = new File(dir);
		if(fileDir.exists() && fileDir.isDirectory()) { 
			return false;
		}else {
			return true;
		}
	}
}
