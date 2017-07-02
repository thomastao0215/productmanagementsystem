package com.ytmanager.FileUpload;

/**
 * Created by jiachen215 on 2017/5/27.
 */

import com.ytmanager.FileUpload.FileMeta;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.net.URL;
import java.net.URLConnection;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.request.UploadFileRequest;


@CrossOrigin
@Controller
@RequestMapping("/controller")
public class FileUploadController {


    LinkedList<FileMeta> files = new LinkedList<FileMeta>();
    FileMeta fileMeta = null;

    String bucketName = "ytmanager";
    int appId = 1252012264;
    String secretId = "AKIDRn7HH9yOkwxqZ7zgiaHn8JJ8lDUZMDnC";
    String secretKey = "NbeWDnDVcYJsGTWO5byEKF0b0EG9rOju";

    COSClient cosClient = new COSClient(appId,secretId,secretKey);


    @CrossOrigin
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public @ResponseBody LinkedList<FileMeta> upload(MultipartHttpServletRequest request , HttpServletResponse response) {
        Iterator<String > itr = request.getFileNames();
        MultipartFile mpf = null;

        while(itr.hasNext()){
            mpf = request.getFile(itr.next());
            System.out.println(mpf.getOriginalFilename() + "uploaded!" +files.size());
        }

        if (files.size() >= 10)
            files.pop();
        fileMeta = new FileMeta();
        fileMeta.setFileName(mpf.getOriginalFilename());
        fileMeta.setFileSize(mpf.getSize()/1024+" Kb");
        fileMeta.setFileType(mpf.getContentType());

        try {
            fileMeta.setBytes(mpf.getBytes());

            long currentTimeMillis = System.currentTimeMillis();

            String localPath = "./"+currentTimeMillis+mpf.getOriginalFilename();
            File outFile = new File(localPath);
            FileOutputStream fileOutputStream = new FileOutputStream(outFile);
            FileCopyUtils.copy(mpf.getBytes(),fileOutputStream);
            try {
                String cosPath = "/UserImages/" + currentTimeMillis + mpf.getOriginalFilename();
                UploadFileRequest uploadFileRequest = new UploadFileRequest(bucketName, cosPath, localPath);

                cosClient.uploadFile(uploadFileRequest);
//                if (outFile.exists()) {
//                    outFile.delete();
//                }
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                cosClient.shutdown();
            }



        }catch (IOException e){
            e.printStackTrace();
        }

        files.add(fileMeta);

        return files;
    }

    @CrossOrigin
    @RequestMapping(value = "/get/{value}",method = RequestMethod.GET)
    public void get(HttpServletResponse response,@PathVariable String value) {
        FileMeta getFile = files.get(Integer.parseInt(value));
        try {
            response.setContentType(getFile.getFileType());
            response.setHeader("Content-disposition", "attachment; filename=\""+getFile.getFileName()+"\"");
            FileCopyUtils.copy(getFile.getBytes(),response.getOutputStream());
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}
