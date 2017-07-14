package com.ogoodo.springmvc;  
  
import java.io.File;  
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;  
import org.springframework.context.annotation.Scope;  
import org.springframework.http.HttpHeaders;  
import org.springframework.http.HttpStatus;  
import org.springframework.http.MediaType;  
import org.springframework.http.ResponseEntity;  
import org.springframework.stereotype.Component;  
import org.springframework.web.bind.annotation.RequestMapping;  

// 测试地址:  http://localhost:8080/HelloSpringMVC/downloadTest.html
/** 
 * <一句话功能简述> 
 * <功能详细描述> 
 *  
 * @author  Administrator 
 * @version  [版本号, 2014年3月7日] 
 * @see  [相关类/方法] 
 * @since  [产品/模块版本] 
 */  
@Component  
@Scope("prototype")   
@RequestMapping("/downloadFile")  
public class DownloadController 
{  
  
    @RequestMapping("download")    
    public ResponseEntity<byte[]> download(HttpServletRequest request) throws IOException {    

        String realPath = request.getSession().getServletContext().getRealPath("/WEB-INF/upload");
        System.out.println(realPath);
        String path = realPath + "/help.txt"; // 注意目录下面要有这个文件
        File file=new File(path);  
        HttpHeaders headers = new HttpHeaders();    
        String fileName=new String("你好.xlsx".getBytes("UTF-8"),"iso-8859-1");//为了解决中文名称乱码问题  
        headers.setContentDispositionFormData("attachment", fileName);   
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);   
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),    
                                          headers, HttpStatus.CREATED);    
    }    
} 