package com.ivan.blog.params;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Programe : com.ivan.blog
 * Created by ivankim on 2017. 3. 30..
 * Description : File Upload VO
 */
public class UploadFileVO {

    @JsonIgnore
    private String file_name = "";
    @JsonIgnore
    private String upload_path = "";
    @JsonIgnore
    private String new_file_name = "";
    @JsonIgnore
    private String file_location = "";
    @JsonIgnore
    private Long file_size = 0L;
    @JsonIgnore
    private String image_domain = "";

    private String thumb_filenm = "";

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public String getUpload_path() {
        return upload_path;
    }

    public void setUpload_path(String upload_path) {
        this.upload_path = upload_path;
    }

    public String getNew_file_name() {
        return new_file_name;
    }

    public void setNew_file_name(String new_file_name) {
        this.new_file_name = new_file_name;
    }

    public String getFile_location() {
        return file_location;
    }

    public void setFile_location(String file_location) {
        this.file_location = file_location;
    }

    public Long getFile_size() {
        return file_size;
    }

    public void setFile_size(Long file_size) {
        this.file_size = file_size;
    }

    public String getImage_domain() {
        return image_domain;
    }

    public void setImage_domain(String image_domain) {
        this.image_domain = image_domain;
    }

    public String getThumb_filenm() {
        return thumb_filenm;
    }

    public void setThumb_filenm(String thumb_filenm) {
        this.thumb_filenm = thumb_filenm;
    }

}
