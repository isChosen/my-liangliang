package com.liangliang.controller;


import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 *
 * Author: Administrator
 * Date: 2018/6/10
 * Description
 */

@RestController
@RequestMapping("/file")
public class FileHandlerController {

    @CrossOrigin(origins = {"http://localhost:63343", "http://localhost:8020", "http://localhost:4300"})
    @RequestMapping(value="/upload", method = RequestMethod.POST)
    public String upLoadFiles(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {

        if (!file.isEmpty()) {
            String saveFileName = file.getOriginalFilename();
            File saveFile = new File(request.getSession().getServletContext().getRealPath("/upload/") + saveFileName);
            if (!saveFile.getParentFile().exists()) {
                saveFile.getParentFile().mkdirs();
            }
            /*try {
                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(saveFile));
                out.write(file.getBytes());
                out.flush();
                out.close();
                return ResultUtils.buildResult(saveFile.getName() + " 上传成功");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return ResultUtils.buildResult("上传失败," + e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
                return ResultUtils.buildResult("上传失败," + e.getMessage());
            }*/
        } else {
            // return ResultUtils.buildResult("上传失败，因为文件为空.");
        }



        return "upload file success";
    }
}
