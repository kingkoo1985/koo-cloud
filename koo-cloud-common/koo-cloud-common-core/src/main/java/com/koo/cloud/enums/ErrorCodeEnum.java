package com.koo.cloud.enums;

public enum ErrorCodeEnum {
	/**
	 * Gl 99990100 error code enum.
	 */
	GL99990100(9999100, "参数异常"),
	/**
	 * Gl 99990401 error code enum.
	 */
	GL99990401(99990401, "无访问权限"),
	/**
	 * Gl 000500 error code enum.
	 */
	GL99990500(500, "未知异常"),
	
	/**
	 * Opc 10040004 error code enum.
	 */
	OPC10040004(10040004, "发送短信失败"),
	/**
	 * Opc 10040005 error code enum.
	 */
	OPC10040005(10040005, "生成邮件消息体失败"),
	/**
	 * Opc 10040006 error code enum.
	 */
	OPC10040006(10040006, "获取模板信息失败"),
	
	/**
	 * Tpc 10050001 error code enum.
	 */
// 1005 任务中心
	TPC10050001(10050001, "消息的消费Topic不能为空"),
	/**
	 * Tpc 10050002 error code enum.
	 */
	TPC10050002(10050002, "根据消息key查找的消息为空"),
	/**
	 * Tpc 10050003 error code enum.
	 */
	TPC10050003(10050003, "删除消息失败,messageKey=%s"),
	/**
	 * Tpc 10050004 error code enum.
	 */
	TPC10050004(10050004, "消息中心接口异常,message=%s, messageKey=%s"),
	/**
	 * Tpc 10050005 error code enum.
	 */
	TPC10050005(10050005, "目标接口参数不能为空"),
	/**
	 * Tpc 10050006 error code enum.
	 */
	TPC10050006(10050006, "根据任务Id查找的消息为空"),

	/**
	 * Tpc 10050007 error code enum.
	 */
	TPC10050007(10050007, "消息数据不能为空"),
	/**
	 * Tpc 10050008 error code enum.
	 */
	TPC10050008(10050008, "消息体不能为空,messageKey=%s"),
	/**
	 * Tpc 10050009 error code enum.
	 */
	TPC10050009(10050009, "消息KEY不能为空"),
	/**
	 * Tpc 100500010 error code enum.
	 */
	TPC100500010(10050010, "Topic=%s, 无消费者订阅"),
	/**
	 * Tpc 100500011 error code enum.
	 */
	TPC100500011(10050011, "Mq编码转换异常, MessageKey=%s"),
	/**
	 * Tpc 100500012 error code enum.
	 */
	TPC100500012(10050012, "发送MQ失败, MessageKey=%s"),
	/**
	 * Tpc 100500013 error code enum.
	 */
	TPC100500013(10050013, "延迟级别错误, Topic=%s, MessageKey=%s"),
	/**
	 * Tpc 100500014 error code enum.
	 */
	TPC100500014(10050014, "MQ重试三次,仍然发送失败, Topic=%s, MessageKey=%s"),
	/**
	 * Tpc 100500015 error code enum.
	 */
	TPC100500015(10050015, "消息PID不能为空, messageKey=%s"),;
	private int code;
	private String msg;

	/**
	 * Msg string.
	 *
	 * @return the string
	 */
	public String msg() {
		return msg;
	}

	/**
	 * Code int.
	 *
	 * @return the int
	 */
	public int code() {
		return code;
	}

	ErrorCodeEnum(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	/**
	 * Gets enum.
	 *
	 * @param code the code
	 *
	 * @return the enum
	 */
	public static ErrorCodeEnum getEnum(int code) {
		for (ErrorCodeEnum ele : ErrorCodeEnum.values()) {
			if (ele.code() == code) {
				return ele;
			}
		}
		return null;
	}
}
