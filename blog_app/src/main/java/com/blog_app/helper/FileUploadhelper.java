package com.blog_app.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadhelper {
    
//private String upload_dir = "D:\\Project\\SpringBoot\\blogapp\\blog_app\\src\\main\\resources\\static\\images";

private final String upload_dir = new ClassPathResource("/static/images").getFile().getAbsolutePath();

public FileUploadhelper() throws  IOException{}

public boolean UploadFile(MultipartFile mulfile){
boolean f = false;
try{

    InputStream is = mulfile.getInputStream();
    byte data[] = new byte[is.available()];
    is.read(data);

    FileOutputStream fos = new FileOutputStream(upload_dir+File.separator+mulfile.getOriginalFilename());

    fos.write(data);

    fos.flush();
    fos.close();
    f=true;

    //Files.copy(mulfile.getInputStream(), Paths.get(upload_dir+File.separator+mulfile.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
}
catch(Exception e){
    
   e.printStackTrace();
}

return f;

}


}
