package cn.ruvik.spring.cloud.alibaba.dubbo.gateway.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created on 2020/8/24 9:42 上午
 *
 * @author barry
 * Description:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PermissionDTO implements Serializable {
    private String name;
    private String uri;
    private String method;
}
