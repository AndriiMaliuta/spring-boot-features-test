package com.anma.bh.sb.springtesting.core.controllers;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.*;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;

@Controller
@Slf4j
public class ExcelController {

    @GetMapping("/excel")
    public String getExcelPage(Model model) {

//        final String FILE_NAME = "/excel1.xlsx";
//        model.addAttribute("fileName", FILE_NAME);

//        try {
            log.info("test");
//            new InputStreamReader()
//            log.info(Files.readString(Paths.get("../src/main/resources/application.yml")));
//            log.info(new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("111.txt"))).readLine());

//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        return "excel";
    }

    @GetMapping(
            value = "/image",
            produces = MediaType.IMAGE_JPEG_VALUE
    )
    @ResponseBody
    public byte[] getImageWithMediaType() throws IOException {
        InputStream in = getClass()
                .getResourceAsStream("/com/baeldung/produceimage/image.jpg");
        return IOUtils.toByteArray(in);
    }

    @GetMapping("/excel/create")
    public String createExcel(@RequestParam String fileName, Model model) throws IOException {

        model.addAttribute("fileName", fileName);
        Path createdFIle = Files.createFile(Paths.get("/uploads/" + fileName), PosixFilePermissions.asFileAttribute(Set.of(PosixFilePermission.GROUP_WRITE)));
        log.info(">>> created file " + createdFIle.getFileName());

        return "redirect:/excel";
    }
}
