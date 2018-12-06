/**
 * Copyright 2018 人人开源 http://www.renren.io
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package cn.vpclub.demo.web;


import cn.vpclub.demo.common.exception.RRException;
import cn.vpclub.demo.domain.entity.SysMenuEntity;

import cn.vpclub.demo.service.ShiroService;
import cn.vpclub.demo.service.SysMenuService;
import cn.vpclub.demo.service.SysUserTokenService;
import cn.vpclub.demo.utils.Constant;
import cn.vpclub.moses.core.enums.ReturnCodeEnum;
import cn.vpclub.moses.core.model.response.BackResponseUtil;
import cn.vpclub.moses.core.model.response.BaseResponse;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

/**
 * 用户Token 前端控制器
 *
 * @author yk
 * @since 2018-06-01
 */
@RestController
@RequestMapping("/sys/token")
public class SysUserTokenController extends AbstractController {

	@Autowired
	private SysUserTokenService sysUserTokenService;

	@Autowired
	private ShiroService shiroService;

	/**
	 * 生成token
	 */
	@PostMapping("/createToken")
	public BaseResponse createToken(@RequestParam("userId") long userId) {
        BaseResponse token = sysUserTokenService.createToken(userId);
        return token;
    }

	/**
	 * 退出，修改token值
	 */
	@PostMapping("/logout")
	public BaseResponse logout(@RequestParam("userId") long userId){
		BaseResponse updateToken = sysUserTokenService.logout(userId);
		return updateToken;
	}
}
