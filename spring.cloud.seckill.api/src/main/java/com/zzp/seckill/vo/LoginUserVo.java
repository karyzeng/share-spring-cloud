package com.zzp.seckill.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @Description 用户登录vo
 * @Author karyzeng
 * @since 2021.01.23
 **/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class LoginUserVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 登录账号
     */
    @NotBlank(message = "账号不能为空")
    private String loginId;

    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空")
    private String password;

}
