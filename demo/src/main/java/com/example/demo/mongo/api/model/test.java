package com.example.demo.mongo.api.model;


//import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;
 

 
@Document(collection = "test2")
public class test {
 
	 @MongoId(value = FieldType.OBJECT_ID)
	private String id;
	private String MainLevel_id;
	
	private String XRmean;
	private String XRmin;
	private String XRmax;
	private String SDNN;
	private String Rmssd;
	private String NN50;
	private String pNN50;
	private String ValueIndex;
	private String created_at;
    
	public test() {}

	
	
	
	 public test( 	
		     String MainLevel_id,
		     String XRmean, 
			 String XRmin, 
			 String XRmax, 
			 String SDNN, 
			 String Rmssd, 
			 String NN50, 
			 String pNN50,
			 String ValueIndex,
			 String created_at) {
		 
		    this.XRmean = XRmean;
		    this. MainLevel_id=MainLevel_id;
		    this.XRmean=XRmean;
		    this.XRmin=XRmin;
		    this.XRmax=XRmax;
		    this.SDNN=SDNN;
		    this.Rmssd=Rmssd;
		    this.NN50=NN50;
		    this.pNN50=pNN50;
		    this. ValueIndex=ValueIndex;
		    this.created_at=created_at;
		  }
    public String getId() {        return id;    }
    public void setId(String id) {   this.id = id;    }
   
    public String getMainLevel_id() {   return MainLevel_id;    }
    public void setMainLevel_id(String MainLevel_id) { this.MainLevel_id = MainLevel_id;   }
    
    
    
    public String getSDNN() {return SDNN; }
    public void setSDNN(String SDNN) { this.SDNN = SDNN;}    
    public String getXRmean() {     return XRmean;   }
    public void setXRmean(String XRmean) {      this.XRmean = XRmean;  }
    public String getXRmin() {      return XRmin;   }
    public void setXRmin(String XRmin) {  this.XRmin = XRmin;   }
   
    public String getXRmax() {      return XRmax;   }
    public void setXRmax(String XRmax) {  this.XRmax = XRmax;   } 
    
    public String getRmssd() {      return Rmssd;   }
    public void setRmssd(String Rmssd) {  this.Rmssd = Rmssd;   } 
   
    public String getNN50() {      return NN50;   }
    public void setNN50(String NN50) {  this.NN50 = NN50;   } 
 
    public String getpNN50() {      return pNN50;   }
    public void setpNN50(String pNN50) {  this.pNN50 = pNN50;   } 
    
    public String getValueIndex() {      return ValueIndex;   }
    public void setValueIndex(String ValueIndex) {  this.ValueIndex = ValueIndex;   } 
    
    public String getcreated_at() {      return created_at;   }
    public void setcreated_at(String created_at) {  this.created_at = created_at;   } 

    
    
}
