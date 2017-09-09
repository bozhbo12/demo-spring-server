package com.spring.logic.role.service;

import java.util.function.Function;

import com.spring.logic.message.request.world.login.LoginResp;

public interface RoleLoginService {

	public void roleLogin(int gateId, int roleId, String account, String password, String validate, LoginResp resp, Function<LoginResp, Integer> function);
}
