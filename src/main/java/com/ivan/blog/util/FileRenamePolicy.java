package com.ivan.blog.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Program : com.ivan.blog.common
 * Description : Create New FileName
 * Created by ivankim on 2017. 3. 30..
 */
public class FileRenamePolicy {

    public static void FileMkdir(String filePath){
        File file = null;
        file = new File(filePath);
        if(file.mkdir()){
            System.out.println("Directory make complete!");
        }
    }

    /**
     * Rename
     *
     * @param f the f
     * @Return the file
     */
    public File rename(File f){
        if(createNewFile(f)){
            return f;
        }

        String name = f.getName();
        String body = null;
        String ext = null;

        int dot = name.lastIndexOf(".");
        if(dot != -1){ //if has extension
            body = name.substring(0,dot);
        } else { // no extension
            body = name;
            ext = "";
        }

        int count = 0;
        // if file is Overlapped
        // add 'a.number' on last...until 9999
        while (!createNewFile(f) && count < 9999){
            count++;
            String newName = body + count + ext;
            f = new File(f.getParent(), newName);
        }

        return f;
    }

    /**
     *Flow this kinds of pattern to Rename File
     */
    public File renameWithPrefixDateTime(File f, String preFix, String delimeter) {
        String name = f.getName();
        String body = null;
        String ext = null;

        int dot = name.lastIndexOf(".");
        if(dot != -1){//if has extension
            body = name.substring(0, dot);
            ext = name.substring(dot);
        } else {// no extension
            body = name;
            ext = "";
        }

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        long time = calendar.getTimeInMillis();

        String sDate = sdf.format(calendar.getTime());

        body = preFix+delimeter+sDate+delimeter+time;

        String newName = body + ext;
        f = new File(f.getParent(), newName);

        return f;
    }

    /**
     * Create the New file.
     *
     * @Param f the f
     * @Return thr, if successful
     */
    private boolean createNewFile(File f ){
        try {
            return f.createNewFile();
        }catch (IOException ignored){
            return false;
        }
    }
}
