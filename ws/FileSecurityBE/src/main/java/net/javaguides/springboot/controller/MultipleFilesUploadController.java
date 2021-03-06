package net.javaguides.springboot.controller;

import techgeeknext.util.FileUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.util.concurrent.ThreadLocalRandom;

import net.javaguides.ecc.*;
import com.aspose.cloud.storage.Folder;
@Controller
//@CrossOrigin(origins = "http://localhost:8082") open for specific port
@CrossOrigin() // open for all ports
public class MultipleFilesUploadController {


    /**
     * Method to upload multiple files
     * @param files
     * @return FileResponse
     */
    @PostMapping("/upload")
    public ResponseEntity<FileUploadResponse> uploadFiles(@RequestParam("files") MultipartFile[] files) {
        try {
            createDirIfNotExist();

            List<String> fileNames = new ArrayList<>();

            // read and write the file to the local folder
            Arrays.asList(files).stream().forEach(file -> {
                byte[] bytes = new byte[0];
                byte[] encbytes = new byte[0];
                try {
                    bytes = file.getBytes();
                    Files.write(Paths.get(FileUtil.folderPath + file.getOriginalFilename()), bytes);
                    fileNames.add(file.getOriginalFilename());
                    
                    
                    //for encryption
                   // File resource = new ClassPathResource(file.getOriginalFilename()).getFile();                    
                    String text = new String(Files.readAllBytes(Paths.get(FileUtil.folderPath + file.getOriginalFilename())));
                    TestECCrypto obj = new TestECCrypto();
                    String enc_text = obj.ECCEncryption(text);
                    encbytes = enc_text.getBytes();
                    Files.write(Paths.get(FileUtil.folderEncPath + file.getOriginalFilename()), encbytes);
                    fileNames.add(file.getOriginalFilename());
                    
                    String result = storeData(encbytes,file.getOriginalFilename());
                    
                } catch (IOException e) {
                	String x = e.getMessage();
                }
            });

            return ResponseEntity.status(HttpStatus.OK)
                    .body(new FileUploadResponse("Files uploaded successfully: " + fileNames));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                    .body(new FileUploadResponse("Exception to upload files!"));
        }
    }

    
  //@Override
  	public String storeData(byte[] data, String fileName)
  			throws RemoteException {
  		try {
  			String result = "";
  			//FileInformationForm.txtInforamtion.append("\n\nUpload Data Request From  :" + getClientHost(), null);
  			//FileInformationForm.txtInforamtion.append("\n\nUpload File Name :"+ hash, null);			
                          
            byte[] dataByte = null;
  			FileOutputStream outputStream = new FileOutputStream("enc-files/"+ fileName);
  			dataByte = data;
  			outputStream.write(dataByte);
  			outputStream.close();
                          
            //.clouduser.5555
            com.aspose.cloud.common.Product.setBaseProductUri("http://api.aspose.com/v1.1");
  			// sepcify App SID
  			com.aspose.cloud.common.AsposeApp.setAppSID("4efc853b-3973-4a69-aba8-bb042027a727");
  			// sepcify App Key
  			com.aspose.cloud.common.AsposeApp.setAppKey("3ec1647db35beb79dd8f5ccbcc314be2");
  			String folderName = "";
  			Folder folder = new Folder();
  			folder.UploadFile("enc-files/" + fileName, folderName);
            
  			result = result.equals("Sucessfull") ? "Saved in Storage" : result;
  			
  			return result;
  		} catch (Exception e) {
  			e.printStackTrace();
  		}
  		return null;
  	}
       
  	
    /**
     * Create directory to save files, if not exist
     */
    private void createDirIfNotExist() {
        //create directory to save the files
        File directory = new File(FileUtil.folderPath);
        if (! directory.exists()){
            directory.mkdir();
        }
    }
    
//    private final FileEntityRepository fileEntityRepository = null;
//    @GetMapping
//	public ResponseEntity<byte[]> getRandomFile() {
//	 
//	  long amountOfFiles = fileEntityRepository.count();
//	  Long randomPrimaryKey;
//	 
//	  if (amountOfFiles == 0) {
//	     return ResponseEntity.ok(new byte[0]);
//	   } else if (amountOfFiles == 1) {
//	     randomPrimaryKey = 1L;
//	   } else {
//	     randomPrimaryKey = ThreadLocalRandom.current().nextLong(1, amountOfFiles + 1);
//	   }
//	 
//	  
//	 
//	   HttpHeaders header = new HttpHeaders();
//	   header.setContentType(MediaType.valueOf(fileEntity.getContentType()));
//	   header.setContentLength(fileEntity.getData().length);
//	   header.set("Content-Disposition", "attachment; filename=" + fileEntity.getFileName());
//	 
//	   return new ResponseEntity<>(fileEntity.getData(), header, HttpStatus.OK);
//	}
	
    /**
     * Method to get the list of files from the file storage folder.
     * @return file
     */
    @GetMapping("/files")
    public ResponseEntity<String[]> getListFiles() {
        return ResponseEntity.status(HttpStatus.OK)
                .body( new File(FileUtil.folderPath).list());
    }

}
