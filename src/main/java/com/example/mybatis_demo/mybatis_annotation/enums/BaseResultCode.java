package com.example.mybatis_demo.mybatis_annotation.enums;

import com.google.common.collect.ImmutableMap;

/**
 * 枚举结果代码
 */
public enum BaseResultCode implements ResultCode {

    SUCCESS("0000", "成功"),
    HB_0001("0001", "必输项不能为空"),
    HB_0002("0002", "您尚未申请授权码"),
    HB_0003("0003", "该授权码不正确"),
    HB_0004("0004", "您已申请该授权码，请等候结果"),
    HB_0005("0005", "流程模型id为空"),
    HB_0006("0006", "没有设计流程图!"),
    HB_0007("0007", "流程定义ID不能为空!"),
    HB_0008("0008", "任务ID不能为空!"),
    HB_0009("0009", "流程实例ID不能为空!"),
    HB_0010("0010", "节点类型不能为空!"),
    HB_0011("0011", "处理人不能为空!"),
    HB_0012("0012", "业务ID不能为空!"),
    HB_0013("0013", "用户不存在!"),
    HB_0014("0014", "用户名或密码错误，您今天还有[code]次机会!"),
    HB_0015("0015", "此账户已冻结，可重置密码或明日零点解除!"),
    HB_0016("0016", "验证码错误!"),
    HB_0017("0017", "验证码已过期!"),
    HB_0018("0018", "该名称已注册!"),
    HB_0019("0019", "手机号码已注册!"),
    HB_0020("0020", "用户名或密码输入不正确!"),
    HB_0021("0021", "手机号码不为空!"),
    HB_0022("0022", "订单已付款!"),
    NOT_EXIST("40000", "请求不存在"),
    RECORD_NOT_EXIST("40001", "记录不存在"),
    HB_LOGOUT("40003", "成功退出"),
    NO_RIGHT("40004", "没有权限访问"),
    NO_LOGIN("40005", "请登录"),
    CHECK_PARAMS("40006", "检验参数返回码"),
    ILLEGAL_PARAMS("40007", "包含非法字符"),
    ERROR("40008", "请求失败"),
    PROCCESSING("40009", "处理中"),
    SYSTEM_ERROR("50000", "系统异常"),
    SYSTEM_BUSY("50001", "系统繁忙, 请稍后再试"),
    SQL_ERROR("50002", "数据库操作出错");

    private final String code;

    private final String message;

    private static final ImmutableMap<String, BaseResultCode> CACHE;

    static {
        final ImmutableMap.Builder<String, BaseResultCode> builder = ImmutableMap.builder();
        for (BaseResultCode statusCode : values()) {
            builder.put(statusCode.code(), statusCode);
        }
        CACHE = builder.build();
    }

    BaseResultCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public static BaseResultCode valueOfCode(String code) {
        final BaseResultCode status = CACHE.get(code);
        if (status == null) {
            throw new IllegalArgumentException("No matching constant for [" + code + "]");
        }
        return status;
    }

    @Override
    public String code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }

    public static void main(String[] args){
        String a = "dsfdsffdsdsfsdf[code]dfsdfsdfdsf";
        System.out.println(a.replace("[code]","333"));
    }

    public String repayMessage(Object code) {
        return message.replace("[code]",code.toString());
    }
}
