package com.spellchain.passbook.dao;

import com.spellchain.passbook.entity.Merchants;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <h1>Merchants Dao 接口</h1>
 * @author jackson.yu
 * @version 1.0 2018年07月27日
 * @since 1.8
 */
public interface MerchantsDao extends JpaRepository<Merchants, Integer> {

    /**
     * <h2>根据 id 获取商户</h2>
     * @param id 商户 id
     * @return {@link Merchants}
     */
    Merchants queryById(Integer id);

    /**
     * <h2>根据商户名称获取商户对象</h2>
     * @param name 商户名称
     * @return {@link Merchants}
     */
    Merchants queryByName(String name);
}
