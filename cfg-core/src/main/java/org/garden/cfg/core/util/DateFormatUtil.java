package org.garden.cfg.core.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.garden.cfg.core.exception.DataException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateFormatUtil {
	private static final Logger LOG = LoggerFactory.getLogger(DateFormatUtil.class);
	
	private static final String defaultPattern = "yyyy-MM-dd hh:mm:ss";
	private static SimpleDateFormat format = new SimpleDateFormat(defaultPattern);
	
	public static String format(Date date){
		return format.format(date);
	}
	
	public static Date parse(String dateStr){
		try {
			return format.parse(dateStr);
		} catch (ParseException e) {
			LOG.warn("日期格式不符合要求（yyyy-MM-dd hh:mm:ss）:{}", dateStr);
			throw new DataException("日期格式不符合要求（yyyy-MM-dd hh:mm:ss）");
		}
	}
}
