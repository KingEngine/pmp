package com.chinaebi.pmp.database.entity;


/**
 * 对应表 commercial_tenant_unionpay
 * @author king
 *
 */
public class CommercialTenantUnionpay implements java.io.Serializable{
  private int commercialTenantUnionpayId;/*对应表中commercial_tenant_unionpay_id*/
  private String unionpayMerId;/*对应表中unionpay_mer_id*/
  private String unionpayTermId;/*对应表中unionpay_term_id*/
  private String mccCode;/*对应表中mcc_code*/
  private int acqBankId;/*对应表中acq_bank_id*/
  private int gateRouteId;/*对应表中gate_route_id*/
  private String className;/*对应表中class_name*/
  private String keyValue;/*对应表中key_value*/
  private int keyIndex;/*对应表中key_index*/
  private String deductNo;/*对应表中deduct_no*/
  private int sign;/*对应表中sign*/
  private String remark;/*对应表中remark*/
  private String channelCode;/*对应表中channel_code*/
  private String unionpayMerName;/*对应表中unionpay_mer_name*/
  private int status;/*对应表中status*/
    public int getCommercialTenantUnionpayId(){  
      return commercialTenantUnionpayId;  
    }  
    public void setCommercialTenantUnionpayId(int commercialTenantUnionpayId){  
      this.commercialTenantUnionpayId = commercialTenantUnionpayId;  
    }  
    public String getUnionpayMerId(){  
      return unionpayMerId;  
    }  
    public void setUnionpayMerId(String unionpayMerId){  
      this.unionpayMerId = unionpayMerId;  
    }  
    public String getUnionpayTermId(){  
      return unionpayTermId;  
    }  
    public void setUnionpayTermId(String unionpayTermId){  
      this.unionpayTermId = unionpayTermId;  
    }  
    public String getMccCode(){  
      return mccCode;  
    }  
    public void setMccCode(String mccCode){  
      this.mccCode = mccCode;  
    }  
    public int getAcqBankId(){  
      return acqBankId;  
    }  
    public void setAcqBankId(int acqBankId){  
      this.acqBankId = acqBankId;  
    }  
    public int getGateRouteId(){  
      return gateRouteId;  
    }  
    public void setGateRouteId(int gateRouteId){  
      this.gateRouteId = gateRouteId;  
    }  
    public String getClassName(){  
      return className;  
    }  
    public void setClassName(String className){  
      this.className = className;  
    }  
    public String getKeyValue(){  
      return keyValue;  
    }  
    public void setKeyValue(String keyValue){  
      this.keyValue = keyValue;  
    }  
    public int getKeyIndex(){  
      return keyIndex;  
    }  
    public void setKeyIndex(int keyIndex){  
      this.keyIndex = keyIndex;  
    }  
    public String getDeductNo(){  
      return deductNo;  
    }  
    public void setDeductNo(String deductNo){  
      this.deductNo = deductNo;  
    }  
    public int getSign(){  
      return sign;  
    }  
    public void setSign(int sign){  
      this.sign = sign;  
    }  
    public String getRemark(){  
      return remark;  
    }  
    public void setRemark(String remark){  
      this.remark = remark;  
    }  
    public String getChannelCode(){  
      return channelCode;  
    }  
    public void setChannelCode(String channelCode){  
      this.channelCode = channelCode;  
    }  
    public String getUnionpayMerName(){  
      return unionpayMerName;  
    }  
    public void setUnionpayMerName(String unionpayMerName){  
      this.unionpayMerName = unionpayMerName;  
    }  
    public int getStatus(){  
      return status;  
    }  
    public void setStatus(int status){  
      this.status = status;  
    }  
}


