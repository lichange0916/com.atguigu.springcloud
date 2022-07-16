package com.atguigu.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Payment)实体类
 *
 * @author makejava
 * @since 2022-03-02 21:23:36
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {
    
    private long id;
    
    private String serial;

}

