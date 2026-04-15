package com.hzf.service.core.service;

import com.hzf.service.core.entity.Borrower;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 借款人 服务类
 * </p>
 *
 * @author hzf
 * @since 2026-03-17
 */
public interface IBorrowerService extends IService<Borrower> {

    /**
     * 保存借款人信息（包含参数校验）
     *
     * @param borrower 借款人实体对象
     */
    void saveBorrower(Borrower borrower);

    /**
     * 根据ID查询借款人，不存在则抛出业务异常
     *
     * @param id 借款人ID
     * @return 借款人信息
     */
    Borrower getBorrowerById(Long id);

    /**
     * 根据用户ID查询借款人列表
     *
     * @param userId 用户ID
     * @return 该用户的借款人信息列表
     */
    List<Borrower> getBorrowerByUserId(Long userId);

    /**
     * 根据姓名查询借款人列表
     *
     * @param name 借款人姓名
     * @return 该姓名的借款人信息列表
     */
    List<Borrower> getBorrowerByName(String name);

    /**
     * 根据身份证号查询借款人信息
     *
     * @param idCard 身份证号
     * @return 借款人信息
     */
    Borrower getBorrowerByIdCard(String idCard);

    /**
     * 根据ID更新借款人信息，不存在则抛出业务异常
     *
     * @param id       借款人ID
     * @param borrower 借款人实体对象（需包含更新字段）
     */
    void updateBorrowerById(Long id, Borrower borrower);

    /**
     * 根据ID删除借款人信息（逻辑删除），不存在则抛出业务异常
     *
     * @param id 借款人ID
     */
    void removeBorrowerById(Long id);
}
