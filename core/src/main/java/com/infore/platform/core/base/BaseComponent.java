package com.infore.platform.core.base;

import com.infore.platform.core.common.utils.Asserts;
import com.infore.platform.core.common.utils.uuid.UUIDGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BaseComponent {
	@Autowired
	protected Asserts asserts;

	@Value("${application.key}")
	protected String appKey;

	@Autowired
	protected UUIDGenerator uuidGenerator;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	protected void debug(String log) {
		log = "[RequestId: " + this.asserts.getRequestId() + "] " + log;
		this.logger.debug(log);
	}

	protected void debug(String log, Object value1) {
		log = "[RequestId: " + this.asserts.getRequestId() + "] " + log;
		this.logger.debug(log, value1);
	}

	protected void debug(String log, Object value1, Object value2) {
		log = "[RequestId: " + this.asserts.getRequestId() + "] " + log;
		this.logger.debug(log, value1, value2);
	}

	protected void debug(String log, Object... values) {
		log = "[RequestId: " + this.asserts.getRequestId() + "] " + log;
		this.logger.debug(log, values);
	}

	protected void info(String log) {
		log = "[RequestId: " + this.asserts.getRequestId() + "] " + log;
		this.logger.info(log);
	}

	protected void info(String log, Object value1) {
		log = "[RequestId: " + this.asserts.getRequestId() + "] " + log;
		this.logger.info(log, value1);
	}

	protected void info(String log, Object value1, Object value2) {
		log = "[RequestId: " + this.asserts.getRequestId() + "] " + log;
		this.logger.info(log, value1, value2);
	}

	protected void info(String log, Object... values) {
		log = "[RequestId: " + this.asserts.getRequestId() + "] " + log;
		this.logger.info(log, values);
	}

	protected void warn(String log) {
		log = "[RequestId: " + this.asserts.getRequestId() + "] " + log;
		this.logger.warn(log);
	}

	protected void warn(String log, Object value1) {
		log = "[RequestId: " + this.asserts.getRequestId() + "] " + log;
		this.logger.warn(log, value1);
	}

	protected void warn(String log, Object value1, Object value2) {
		log = "[RequestId: " + this.asserts.getRequestId() + "] " + log;
		this.logger.warn(log, value1, value2);
	}

	protected void warn(String log, Object... values) {
		log = "[RequestId: " + this.asserts.getRequestId() + "] " + log;
		this.logger.warn(log, values);
	}

	protected void error(String log) {
		log = "[RequestId: " + this.asserts.getRequestId() + "] " + log;
		this.logger.error(log);
	}

	protected void error(String log, Object value1) {
		log = "[RequestId: " + this.asserts.getRequestId() + "] " + log;
		this.logger.error(log, value1);
	}

	protected void error(String log, Object value1, Object value2) {
		log = "[RequestId: " + this.asserts.getRequestId() + "] " + log;
		this.logger.error(log, value1, value2);
	}

	protected void error(String log, Object... values) {
		log = "[RequestId: " + this.asserts.getRequestId() + "] " + log;
		this.logger.error(log, values);
	}
}
