package com.spellchain.passbook.vo;

import com.spellchain.passbook.constant.ErrorCode;
import com.spellchain.passbook.dao.MerchantsDao;
import com.spellchain.passbook.entity.Merchants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <h1>创建商户请求对象</h1>
 * @author jackson.yu
 * @version 1.0 2018年07月28日
 * @since 1.8
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateMerchantsRequest {

    /** 商户名称 */
    private String name;

    /** 商户 logo  */
    private String logoUrl;

    /** 商户营业执照 */
    private String businessLicenseUrl;

    /** 商户电话 */
    private String phone;

    /** 商户地址 */
    private String address;

    /**
     * <h2>验证请求的有效性</h2>
     * @param merchantsDao {@link MerchantsDao}
     * @return {@link ErrorCode}
     */
    public ErrorCode validate(MerchantsDao merchantsDao){

        if (merchantsDao.queryByName(this.name) != null){
            return ErrorCode.EMPTY_NAME;
        }

        if (null == this.logoUrl) {
            return ErrorCode.EMPTY_LOGO;
        }

        if (null == this.businessLicenseUrl){
            return ErrorCode.EMPTY_BUSINESS_LICENSE;
        }

        if (null == this.address){
            return ErrorCode.EMPTY_ADDRESS;
        }

        if (null == this.phone){
            return ErrorCode.ERROR_PHONE;
        }

        return ErrorCode.SUCCESS;
    }

    /**
     * <h2>将请求对象转换成商户对象</h2>
     * @return {@link Merchants}
     */
    public Merchants toMerchants(){

        Merchants merchants = new Merchants();
        merchants.setName(name);
        merchants.setLogoUrl(logoUrl);
        merchants.setBusinessLicenseUrl(businessLicenseUrl);
        merchants.setPhone(phone);
        merchants.setAddress(address);
        merchants.setIsAudit(false);
        return merchants;
    }
}
