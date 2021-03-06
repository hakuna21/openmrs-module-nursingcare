package org.openmrs.module.nursingkardex.util;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class JavaBeanCopier {
	/**
	 * Returns a deeply cloned java bean.
	 * 
	 * @param fromBean
	 *            java bean to be cloned.
	 * @return a new java bean cloned from fromBean.
	 */
	public static Object copy(Object fromBean) {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		XMLEncoder out = new XMLEncoder(bos);
		out.writeObject(fromBean);
		out.close();
		ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
		XMLDecoder in = new XMLDecoder(bis);
		Object toBean = in.readObject();
		in.close();
		return toBean;
	}
}