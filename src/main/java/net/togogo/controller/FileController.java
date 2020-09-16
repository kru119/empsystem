package net.togogo.controller;

import net.togogo.bean.Data;
import net.togogo.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;

@Controller
public class FileController {
    @Autowired
    FileService fileService;
    @GetMapping("/data")
    public String goPage(Model model) {
        List<Data> files = fileService.getAll();
        model.addAttribute("files",files);
        return "file/datacenter";
    }
    @GetMapping("/datatwo")
    public String goPagetwo(Model model) {
        List<Data> files = fileService.getAll();
        model.addAttribute("files",files);
        return "file/centertwo";
    }


    @PostMapping("/SingleFile/upload")
    public String SingleFileUpLoad(@RequestParam("myfile") MultipartFile file, Model model) {
        //判断文件是否为空
        if (file.isEmpty()) {
            model.addAttribute("result_singlefile", "文件为空");
            return "redirect:/data";
        }

        //创建输入输出流
        InputStream inputStream = null;
        OutputStream outputStream = null;

        try {
            //指定上传的位置为 d:/upload/
            String path = "d:/upload/";
            //获取文件的输入流
            inputStream = file.getInputStream();
            //获取上传时的文件名
            String fileName = file.getOriginalFilename();
            fileService.add(path + fileName);
            //注意是路径+文件名
            File targetFile = new File(path + fileName);

            //判断文件父目录是否存在
            if (!targetFile.getParentFile().exists()) {
                //不存在就创建一个
                targetFile.getParentFile().mkdir();
            }

            //获取文件的输出流
            outputStream = new FileOutputStream(targetFile);
            //最后使用资源访问器FileCopyUtils的copy方法拷贝文件
            FileCopyUtils.copy(inputStream, outputStream);


            //告诉页面上传成功了
            model.addAttribute("result_singlefile", "上传成功");
        } catch (IOException e) {
            e.printStackTrace();
            //出现异常，则告诉页面失败
            model.addAttribute("result_singlefile", "上传失败");
        } finally {
            //无论成功与否，都有关闭输入输出流
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return "redirect:/data";
    }
    @PostMapping("/SingleFile/uploadtwo")
    public String SingleFileUpLoadtwo(@RequestParam("myfile") MultipartFile file, Model model) {
        //判断文件是否为空
        if (file.isEmpty()) {
            model.addAttribute("result_singlefile", "文件为空");
            return "redirect:/datatwo";
        }

        //创建输入输出流
        InputStream inputStream = null;
        OutputStream outputStream = null;

        try {
            //指定上传的位置为 d:/upload/
            String path = "d:/upload/";
            //获取文件的输入流
            inputStream = file.getInputStream();
            //获取上传时的文件名
            String fileName = file.getOriginalFilename();
            fileService.add(path + fileName);
            //注意是路径+文件名
            File targetFile = new File(path + fileName);

            //判断文件父目录是否存在
            if (!targetFile.getParentFile().exists()) {
                //不存在就创建一个
                targetFile.getParentFile().mkdir();
            }

            //获取文件的输出流
            outputStream = new FileOutputStream(targetFile);
            //最后使用资源访问器FileCopyUtils的copy方法拷贝文件
            FileCopyUtils.copy(inputStream, outputStream);


            //告诉页面上传成功了
            model.addAttribute("result_singlefile", "上传成功");
        } catch (IOException e) {
            e.printStackTrace();
            //出现异常，则告诉页面失败
            model.addAttribute("result_singlefile", "上传失败");
        } finally {
            //无论成功与否，都有关闭输入输出流
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return "redirect:/datatwo";
    }
}
