package com.chinaebi.pmp.database.entity;

import java.math.BigInteger;

/**
 * 对应表 oper_info
 * @author king
 *
 */
public class OperInfo implements java.io.Serializable{
  private static final long serialVersionUID = 1517723797394716897L;
  private int mid;/*对应表中mid*/
  private int operId;/*对应表中oper_id*/
  private String operPass;/*对应表中oper_pass*/
  private String operName;/*对应表中oper_name*/
  private String operTel;/*对应表中oper_tel*/
  private String operEmail;/*对应表中oper_email*/
  private int regDate;/*对应表中reg_date*/
  private Integer state;/*对应表中state*/
  private String logined;/*对应表中logined*/
  private int mtype;/*对应表中mtype*/
  private String auth;/*对应表中auth*/
  private int role;/*对应表中role*/
  private int errCount;/*对应表中err_count*/
  private int lastUpdat;/*对应表中last_updat*/
  private BigInteger errTime;/*对应表中err_time*/
  private String innerMercode;/*对应表中inner_mercode*/
    public int getMid(){  
      return mid;  
    }  
    public void setMid(int mid){  
      this.mid = mid;  
    }  
    public int getOperId(){  
      return operId;  
    }  
    public void setOperId(int operId){  
      this.operId = operId;  
    }  
    public String getOperPass(){  
      return operPass;  
    }  
    public void setOperPass(String operPass){  
      this.operPass = operPass;  
    }  
    public String getOperName(){  
      return operName;  
    }  
    public void setOperName(String operName){  
      this.operName = operName;  
    }  
    public String getOperTel(){  
      return operTel;  
    }  
    public void setOperTel(String operTel){  
      this.operTel = operTel;  
    }  
    public String getOperEmail(){  
      return operEmail;  
    }  
    public void setOperEmail(String operEmail){  
      this.operEmail = operEmail;  
    }  
    public int getRegDate(){  
      return regDate;  
    }  
    public void setRegDate(int regDate){  
      this.regDate = regDate;  
    }  
    public Integer getState(){  
      return state;  
    }  
    public void setState(Integer state){  
      this.state = state;  
    }  
    public String getLogined(){  
      return logined;  
    }  
    public void setLogined(String logined){  
      this.logined = logined;  
    }  
    public int getMtype(){  
      return mtype;  
    }  
    public void setMtype(int mtype){  
      this.mtype = mtype;  
    }  
    public String getAuth(){  
      return auth;  
    }  
    public void setAuth(String auth){  
      this.auth = auth;  
    }  
    public int getRole(){  
      return role;  
    }  
    public void setRole(int role){  
      this.role = role;  
    }  
    public int getErrCount(){  
      return errCount;  
    }  
    public void setErrCount(int errCount){  
      this.errCount = errCount;  
    }  
    public int getLastUpdat(){  
      return lastUpdat;  
    }  
    public void setLastUpdat(int lastUpdat){  
      this.lastUpdat = lastUpdat;  
    }  
    public BigInteger getErrTime(){  
      return errTime;  
    }  
    public void setErrTime(BigInteger errTime){  
      this.errTime = errTime;  
    }  
    public String getInnerMercode(){  
      return innerMercode;  
    }  
    public void setInnerMercode(String innerMercode){  
      this.innerMercode = innerMercode;  
    }  
}