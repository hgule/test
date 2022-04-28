package com.example.demo.mongo.api.resource;

import com.example.demo.mongo.api.repository.testRepository;
import com.example.demo.mongo.api.model.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
 


import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

@RestController
public class testController {
	@Autowired
	private testRepository  repository  ;
	
 
    @GetMapping(value = "/welcome", produces = MediaType.TEXT_HTML_VALUE)
    public String uploadStatus() {
        return "<!DOCTYPE html><html><body><h1>csv file ekle</h1>\r\n"
        		+ "<form action='/upload'  method='post' enctype='multipart/form-data'>\r\n"
        		+ "<label for='file'>Select a file:</label> <input type='file' id='file' name='file'><br><br>\r\n"
        		+ "  <input type='submit'></form><br><br><a href='findAllTest'><i>json git</i> </a> </body></html> ";
    }   
    
    @PostMapping("/upload") // //new annotation since 4.3
    public String singleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {

        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:uploadStatus";
        }

        
        try {
		      List<test> tutorials = csvToTutorials(file.getInputStream());
		      repository.saveAll(tutorials);
		    } catch (IOException e) {
		      throw new RuntimeException("fail to store csv data: " + e.getMessage());
		    }
 
        return "Dosya başarı ile yüklendi. <a href='findAllTest'><i>json git</i> </a>";
    }
    
	@PostMapping("/addTest")
	public String saveBook(@RequestBody test Test) {
		repository.save(Test);
		return "eklendi"  + Test.getId();
	}
	
	@GetMapping("/findAllTest")
	public List<test>  getTests(){
		return repository.findAll();
	}
	
	@GetMapping("/findAllTest/{id}")
	public Optional<test>  getTest(@PathVariable String id){
		return repository.findById(id);
	}
	
	@GetMapping("/delete/{id}")
	public String deleteTest(@PathVariable String id){
		  repository.deleteById(id);
			return "silindi"  + id;
	}
	
	public static List<test> csvToTutorials(InputStream is) {
		    try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
		        CSVParser csvParser = new CSVParser(fileReader,
		            CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {
		      List<test> tutorials = new ArrayList<test>();
		      Iterable<CSVRecord> csvRecords = csvParser.getRecords();
		      for (CSVRecord csvRecord : csvRecords) {
		    	  test Test = new test(
		         			 csvRecord.get("MainLevel_id"),
		         			 csvRecord.get("XRmean"),
		         			 csvRecord.get("XRmin"),
		         			 csvRecord.get("XRmax"),
		         			 csvRecord.get("SDNN"),			 
		         			 csvRecord.get("Rmssd"),
		         			 csvRecord.get("NN50"),
		         			 csvRecord.get("pNN50"),
		         			 csvRecord.get("ValueIndex"),
		         			 csvRecord.get("created_at") );
		        tutorials.add(Test);
		      }
		      return tutorials;
		    } catch (IOException e) {
		      throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
		    }
		  }
	  
}
