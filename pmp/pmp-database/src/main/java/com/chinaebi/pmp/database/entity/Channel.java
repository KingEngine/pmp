package com.chinaebi.pmp.database.entity;


/**
 * 对应表 channel
 * @author king
 *
 */
public class Channel implements java.io.Serializable{
  private static final long serialVersionUID = 1580335715244221319L;
  private int cid;/*对应表中cid*/
  private String chanName;/*对应表中chan_name*/
  private String chanAbbrev;/*对应表中chan_abbrev*/
  private int industry;/*对应表中industry*/
  private int chanStatus;/*对应表中chan_status*/
  private String chanSign;/*对应表中chan_sign*/
  private String keyIndex;/*对应表中key_index*/
    public int getCid(){  
      return cid;  
    }  
    public void setCid(int cid){  
      this.cid = cid;  
    }  
    public String getChanName(){  
      return chanName;  
    }  
    public void setChanName(String chanName){  
      this.chanName = chanName;  
    }  
    public String getChanAbbrev(){  
      return chanAbbrev;  
    }  
    public void setChanAbbrev(String chanAbbrev){  
      this.chanAbbrev = chanAbbrev;  
    }  
    public int getIndustry(){  
      return industry;  
    }  
    public void setIndustry(int industry){  
      this.industry = industry;  
    }  
    public int getChanStatus(){  
      return chanStatus;  
    }  
    public void setChanStatus(int chanStatus){  
      this.chanStatus = chanStatus;  
    }  
    public String getChanSign(){  
      return chanSign;  
    }  
    public void setChanSign(String chanSign){  
      this.chanSign = chanSign;  
    }  
    public String getKeyIndex(){  
      return keyIndex;  
    }  
    public void setKeyIndex(String keyIndex){  
      this.keyIndex = keyIndex;  
    }  
}


