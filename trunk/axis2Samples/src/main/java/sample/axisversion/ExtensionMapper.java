/**
 * Title：ExtensionMapper.java
 * Description：axis2Samples
 * Copyright：Copyright (c)2009 Sobey,Inc
 * Company：Sobey,Inc
 * @author Zheng.Won &lt;<a href="mailto:hbyw618@hotmail.com">hbyw618@hotmail.com</a>&gt; 2009-2-10 下午05:16:36
 * @version 0.9 beta
 */
package sample.axisversion;

import javax.xml.stream.XMLStreamReader;

import org.apache.axis2.databinding.ADBException;

/**
 *
 *
 *
 *
 **/
public  class ExtensionMapper {

	public static Object getTypeObject(
			String namespaceURI, String typeName,
			XMLStreamReader reader)
			throws java.lang.Exception {

		if ("http://axisversion.sample".equals(namespaceURI)
				&& "Exception".equals(typeName)) {

			return Exception.Factory.parse(reader);

		}

		throw new ADBException(
				"Unsupported type " + namespaceURI + " " + typeName);
	}

}