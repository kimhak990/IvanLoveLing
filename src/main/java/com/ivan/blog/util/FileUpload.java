package com.ivan.blog.util;

import com.ivan.blog.params.UploadFileVO;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by ivankim on 2017. 3. 30..
 */
public class FileUpload {
    /**
     * File Upload And Change FileName.
     * getExuploadFiles ( List<MultipartFile files, String "Real Upload Path" , String "Upload Sub-Path",
     *                    Long "Limit Size", String "Change FileName preFix_yyyymmdd_time" )
     */
    public static UploadFileVO getExUploadFile(MultipartFile file, String fileUploadDir, Long limitFileSize, String preFix) throws Exception{

        String fileLocation = fileUploadDir + getDirDate();

        UploadFileVO uploadFileVO = getUploadFile(file, getDirDate(), fileLocation, limitFileSize, preFix);

        return uploadFileVO;
    }

    /**
     * Upload Single File
     */
    public static UploadFileVO getUploadFile(MultipartFile file, String uploadPath, String path, Long limitFileSize, String preFix) throws Exception{

        String filePath;
        String fileName;
        Long fileSize;

        UploadFileVO uploadFileVO = new UploadFileVO();

        File uploadDir = new File(path);
        if(!uploadDir.exists()){
            uploadDir.mkdirs();
        }

        if(file != null){
            fileName = file.getOriginalFilename();
            fileSize = file.getSize();

            if(fileSize <= limitFileSize){

                if(StringUtils.isNotEmpty(fileName)){
                    //Send File
                    filePath = FilenameUtils.concat(path, fileName);

                    //If FileName is Overlapped, than rename
                    File newFile = new File(filePath);
                    if(null!=preFix){
                        newFile = new FileRenamePolicy().renameWithPrefixDateTime(newFile, preFix,"_");
                    } else {
                        newFile = new FileRenamePolicy().rename(newFile);
                    }

                    file.transferTo(newFile);

                    uploadFileVO.setFile_name(fileName);
                    uploadFileVO.setUpload_path(uploadPath);
                    uploadFileVO.setNew_file_name(newFile.getName());
                    uploadFileVO.setFile_location(path);
                    uploadFileVO.setFile_size(fileSize);
                }
            }
        }
        return uploadFileVO;
    }

    /**
     * File Upload
     */
    public static List<UploadFileVO> getUploadFiles(List<MultipartFile> files, String uploadPath, String path, Long limitFileSize) throws Exception{

        String filePath;
        String fileName;
        Long fileSize;

        List<UploadFileVO> fileList = new ArrayList<UploadFileVO>();

        File uploadDir = new File(path);
        if(!uploadDir.exists()){
            uploadDir.mkdirs();
        }

        if(files != null && files.size() > 0) {
            for (MultipartFile multipartFile : files) {
                if(multipartFile != null) {

                    fileName = multipartFile.getOriginalFilename();
                    fileSize = multipartFile.getSize();
                    if(fileSize <= limitFileSize){
                        if(StringUtils.isNotEmpty(fileName)){

                            //Send File
                            filePath = FilenameUtils.concat(path, fileName);

                            //Rename File When File name is Overlapped
                            File newFile = new File(filePath);
                            newFile = new FileRenamePolicy().rename(newFile);

                            multipartFile.transferTo(newFile);

                            UploadFileVO uploadFileVO = new UploadFileVO();
                            uploadFileVO.setFile_name(fileName);
                            uploadFileVO.setUpload_path(uploadPath);
                            uploadFileVO.setNew_file_name(newFile.getName());
                            uploadFileVO.setFile_location(path);
                            uploadFileVO.setFile_size(fileSize);

                            fileList.add(uploadFileVO);
                        } // end of if
                    }
                }// end of if
            } // end of if
        } // end of if

        return fileList;
    }


    /**
     * YYYY-MM-DD
     * @Return : String
     */
    private static String getDirDate(){
        Calendar calendar = Calendar.getInstance();
        String dateString;
        dateString = String.format("/%04d/%02d/02d",calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH)+1,calendar.get(Calendar.DAY_OF_MONTH));

        return dateString;
    }
}
