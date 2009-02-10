/**
 * Title：Exception.java
 * Description：axis2Samples
 * Copyright：Copyright (c)2009 Sobey,Inc
 * Company：Sobey,Inc
 * @author Zheng.Won &lt;<a href="mailto:hbyw618@hotmail.com">hbyw618@hotmail.com</a>&gt; 2009-2-10 下午04:43:54
 * @version 0.9 beta
 */
package sample.axisversion;

import java.util.ArrayList;
import java.util.Vector;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;

import org.apache.axiom.om.OMConstants;
import org.apache.axiom.om.OMDataSource;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.impl.llom.OMSourcedElementImpl;
import org.apache.axis2.databinding.ADBBean;
import org.apache.axis2.databinding.ADBDataSource;
import org.apache.axis2.databinding.ADBException;
import org.apache.axis2.databinding.utils.BeanUtil;
import org.apache.axis2.databinding.utils.ConverterUtil;
import org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl;
import org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter;

/**
 *
 *
 *
 *
 **/
public class Exception implements org.apache.axis2.databinding.ADBBean {
	/*
	 * This type was generated from the piece of schema that had name =
	 * Exception Namespace URI = http://axisversion.sample Namespace Prefix =
	 * ns1
	 */

	private static java.lang.String generatePrefix(java.lang.String namespace) {
		if (namespace.equals("http://axisversion.sample")) {
			return "ns1";
		}
		return BeanUtil.getUniquePrefix();
	}

	/**
	 * field for Exception
	 */

	protected Object localException;

	/*
	 * This tracker boolean wil be used to detect whether the user called the
	 * set method for this attribute. It will be used to determine whether to
	 * include this field in the serialized XML
	 */
	protected boolean localExceptionTracker = false;

	/**
	 * Auto generated getter method
	 * 
	 * @return java.lang.Object
	 */
	public Object getException() {
		return localException;
	}

	/**
	 * Auto generated setter method
	 * 
	 * @param param
	 *            Exception
	 */
	public void setException(Object param) {

		if (param != null) {
			// update the setting tracker
			localExceptionTracker = true;
		} else {
			localExceptionTracker = true;

		}

		this.localException = param;

	}

	/**
	 * isReaderMTOMAware
	 * 
	 * @return true if the reader supports MTOM
	 */
	public static boolean isReaderMTOMAware(XMLStreamReader reader) {
		boolean isReaderMTOMAware = false;

		try {
			isReaderMTOMAware = Boolean.TRUE.equals(reader
					.getProperty(OMConstants.IS_DATA_HANDLERS_AWARE));
		} catch (IllegalArgumentException e) {
			isReaderMTOMAware = false;
		}
		return isReaderMTOMAware;
	}

	/**
	 * 
	 * @param parentQName
	 * @param factory
	 * @return org.apache.axiom.om.OMElement
	 */
	public OMElement getOMElement(final QName parentQName,
			final OMFactory factory) throws ADBException {

		OMDataSource dataSource = new ADBDataSource(this, parentQName) {

			public void serialize(MTOMAwareXMLStreamWriter xmlWriter)
					throws XMLStreamException {
				Exception.this.serialize(parentQName, factory, xmlWriter);
			}
		};
		return new OMSourcedElementImpl(parentQName, factory, dataSource);

	}

	public void serialize(final QName parentQName, final OMFactory factory,
			MTOMAwareXMLStreamWriter xmlWriter) throws XMLStreamException,
			ADBException {
		serialize(parentQName, factory, xmlWriter, false);
	}

	public void serialize(final QName parentQName, final OMFactory factory,
			MTOMAwareXMLStreamWriter xmlWriter, boolean serializeType)
			throws XMLStreamException, ADBException {

		String prefix = null;
		String namespace = null;

		prefix = parentQName.getPrefix();
		namespace = parentQName.getNamespaceURI();

		if ((namespace != null) && (namespace.trim().length() > 0)) {
			java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
			if (writerPrefix != null) {
				xmlWriter.writeStartElement(namespace, parentQName
						.getLocalPart());
			} else {
				if (prefix == null) {
					prefix = generatePrefix(namespace);
				}

				xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(),
						namespace);
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
		} else {
			xmlWriter.writeStartElement(parentQName.getLocalPart());
		}

		if (serializeType) {

			java.lang.String namespacePrefix = registerPrefix(xmlWriter,
					"http://axisversion.sample");
			if ((namespacePrefix != null)
					&& (namespacePrefix.trim().length() > 0)) {
				writeAttribute("xsi",
						"http://www.w3.org/2001/XMLSchema-instance", "type",
						namespacePrefix + ":Exception", xmlWriter);
			} else {
				writeAttribute("xsi",
						"http://www.w3.org/2001/XMLSchema-instance", "type",
						"Exception", xmlWriter);
			}

		}
		if (localExceptionTracker) {

			if (localException != null) {
				if (localException instanceof  ADBBean) {
					(( ADBBean) localException)
							.serialize(new  QName(
									"http://axisversion.sample", "Exception"),
									factory, xmlWriter, true);
				} else {
					 String namespace2 = "http://axisversion.sample";
					if (!namespace2.equals("")) {
						 String prefix2 = xmlWriter
								.getPrefix(namespace2);

						if (prefix2 == null) {
							prefix2 = generatePrefix(namespace2);

							xmlWriter.writeStartElement(prefix2, "Exception",
									namespace2);
							xmlWriter.writeNamespace(prefix2, namespace2);
							xmlWriter.setPrefix(prefix2, namespace2);

						} else {
							xmlWriter
									.writeStartElement(namespace2, "Exception");
						}

					} else {
						xmlWriter.writeStartElement("Exception");
					}
					 ConverterUtil
							.serializeAnyType(localException, xmlWriter);
					xmlWriter.writeEndElement();
				}
			} else {

				// write null attribute
				String namespace2 = "http://axisversion.sample";
				if (!namespace2.equals("")) {
					String prefix2 = xmlWriter.getPrefix(namespace2);

					if (prefix2 == null) {
						prefix2 = generatePrefix(namespace2);

						xmlWriter.writeStartElement(prefix2, "Exception",
								namespace2);
						xmlWriter.writeNamespace(prefix2, namespace2);
						xmlWriter.setPrefix(prefix2, namespace2);

					} else {
						xmlWriter.writeStartElement(namespace2, "Exception");
					}

				} else {
					xmlWriter.writeStartElement("Exception");
				}

				// write the nil attribute
				writeAttribute("xsi",
						"http://www.w3.org/2001/XMLSchema-instance", "nil",
						"1", xmlWriter);
				xmlWriter.writeEndElement();

			}

		}
		xmlWriter.writeEndElement();

	}

	/**
	 * Util method to write an attribute with the ns prefix
	 */
	private void writeAttribute(String prefix,
			String namespace, String attName,
			String attValue,
			XMLStreamWriter xmlWriter)
			throws XMLStreamException {
		if (xmlWriter.getPrefix(namespace) == null) {
			xmlWriter.writeNamespace(prefix, namespace);
			xmlWriter.setPrefix(prefix, namespace);

		}

		xmlWriter.writeAttribute(namespace, attName, attValue);

	}

	/**
	 * Util method to write an attribute without the ns prefix
	 */
	private void writeAttribute(String namespace,
			String attName, String attValue,
			XMLStreamWriter xmlWriter)
			throws XMLStreamException {
		if (namespace.equals("")) {
			xmlWriter.writeAttribute(attName, attValue);
		} else {
			registerPrefix(xmlWriter, namespace);
			xmlWriter.writeAttribute(namespace, attName, attValue);
		}
	}

	/**
	 * Util method to write an attribute without the ns prefix
	 */
	private void writeQNameAttribute(String namespace,
			String attName, QName qname,
			XMLStreamWriter xmlWriter)
			throws XMLStreamException {

		String attributeNamespace = qname.getNamespaceURI();
		String attributePrefix = xmlWriter
				.getPrefix(attributeNamespace);
		if (attributePrefix == null) {
			attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
		}
		String attributeValue;
		if (attributePrefix.trim().length() > 0) {
			attributeValue = attributePrefix + ":" + qname.getLocalPart();
		} else {
			attributeValue = qname.getLocalPart();
		}

		if (namespace.equals("")) {
			xmlWriter.writeAttribute(attName, attributeValue);
		} else {
			registerPrefix(xmlWriter, namespace);
			xmlWriter.writeAttribute(namespace, attName, attributeValue);
		}
	}

	/**
	 * method to handle Qnames
	 */

	private void writeQName(QName qname,
			XMLStreamWriter xmlWriter)
			throws XMLStreamException {
		String namespaceURI = qname.getNamespaceURI();
		if (namespaceURI != null) {
			String prefix = xmlWriter.getPrefix(namespaceURI);
			if (prefix == null) {
				prefix = generatePrefix(namespaceURI);
				xmlWriter.writeNamespace(prefix, namespaceURI);
				xmlWriter.setPrefix(prefix, namespaceURI);
			}

			if (prefix.trim().length() > 0) {
				xmlWriter.writeCharacters(prefix
						+ ":"
						+ ConverterUtil
								.convertToString(qname));
			} else {
				// i.e this is the default namespace
				xmlWriter
						.writeCharacters(ConverterUtil
								.convertToString(qname));
			}

		} else {
			xmlWriter
					.writeCharacters(ConverterUtil
							.convertToString(qname));
		}
	}

	private void writeQNames(QName[] qnames,
			XMLStreamWriter xmlWriter)
			throws XMLStreamException {

		if (qnames != null) {
			// we have to store this data until last moment since it is not
			// possible to write any
			// namespace data after writing the charactor data
			StringBuffer stringToWrite = new StringBuffer();
			String namespaceURI = null;
			String prefix = null;

			for (int i = 0; i < qnames.length; i++) {
				if (i > 0) {
					stringToWrite.append(" ");
				}
				namespaceURI = qnames[i].getNamespaceURI();
				if (namespaceURI != null) {
					prefix = xmlWriter.getPrefix(namespaceURI);
					if ((prefix == null) || (prefix.length() == 0)) {
						prefix = generatePrefix(namespaceURI);
						xmlWriter.writeNamespace(prefix, namespaceURI);
						xmlWriter.setPrefix(prefix, namespaceURI);
					}

					if (prefix.trim().length() > 0) {
						stringToWrite
								.append(prefix)
								.append(":")
								.append(
										ConverterUtil
												.convertToString(qnames[i]));
					} else {
						stringToWrite
								.append(ConverterUtil
										.convertToString(qnames[i]));
					}
				} else {
					stringToWrite
							.append(ConverterUtil
									.convertToString(qnames[i]));
				}
			}
			xmlWriter.writeCharacters(stringToWrite.toString());
		}

	}

	/**
	 * Register a namespace prefix
	 */
	private String registerPrefix(
			XMLStreamWriter xmlWriter,
			String namespace)
			throws XMLStreamException {
		String prefix = xmlWriter.getPrefix(namespace);

		if (prefix == null) {
			prefix = generatePrefix(namespace);

			while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
				prefix = BeanUtil
						.getUniquePrefix();
			}

			xmlWriter.writeNamespace(prefix, namespace);
			xmlWriter.setPrefix(prefix, namespace);
		}

		return prefix;
	}

	/**
	 * databinding method to get an XML representation of this object
	 * 
	 */
	public XMLStreamReader getPullParser(
			QName qName)
			throws ADBException {

		ArrayList elementList = new ArrayList();
		ArrayList attribList = new ArrayList();

		if (localExceptionTracker) {
			elementList.add(new QName(
					"http://axisversion.sample", "Exception"));

			elementList.add(localException == null ? null : localException);
		}

		return new ADBXMLStreamReaderImpl(
				qName, elementList.toArray(), attribList.toArray());

	}

	/**
	 * Factory class that keeps the parse method
	 */
	public static class Factory {

		/**
		 * static method to create the object Precondition: If this object is an
		 * element, the current or next start element starts this object and any
		 * intervening reader events are ignorable If this object is not an
		 * element, it is a complex type and the reader is at the event just
		 * after the outer start element Postcondition: If this object is an
		 * element, the reader is positioned at its end element If this object
		 * is a complex type, the reader is positioned at the end element of its
		 * outer element
		 */
		public static Exception parse(XMLStreamReader reader)
				throws java.lang.Exception {
			Exception object = new Exception();

			int event;
			String nillableValue = null;
			String prefix = "";
			String namespaceuri = "";
			try {

				while (!reader.isStartElement() && !reader.isEndElement())
					reader.next();

				if (reader.getAttributeValue(
						"http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
					String fullTypeName = reader
							.getAttributeValue(
									"http://www.w3.org/2001/XMLSchema-instance",
									"type");
					if (fullTypeName != null) {
						String nsPrefix = null;
						if (fullTypeName.indexOf(":") > -1) {
							nsPrefix = fullTypeName.substring(0, fullTypeName
									.indexOf(":"));
						}
						nsPrefix = nsPrefix == null ? "" : nsPrefix;

						String type = fullTypeName
								.substring(fullTypeName.indexOf(":") + 1);

						if (!"Exception".equals(type)) {
							// find namespace for the prefix
							String nsUri = reader
									.getNamespaceContext().getNamespaceURI(
											nsPrefix);
							return (Exception) ExtensionMapper.getTypeObject(
									nsUri, type, reader);
						}

					}

				}

				// Note all attributes that were handled. Used to differ
				// normal attributes
				// from anyAttributes.
				Vector handledAttributes = new Vector();

				reader.next();

				while (!reader.isStartElement() && !reader.isEndElement())
					reader.next();

				if (reader.isStartElement()
						&& new QName(
								"http://axisversion.sample", "Exception")
								.equals(reader.getName())) {

					object
							.setException(ConverterUtil
									.getAnyTypeObject(reader,
											ExtensionMapper.class));

					reader.next();

				} // End of if for expected property start element

				else {

				}

				while (!reader.isStartElement() && !reader.isEndElement())
					reader.next();

				if (reader.isStartElement())
					// A start element we are not expecting indicates a
					// trailing invalid property
					throw new ADBException(
							"Unexpected subelement " + reader.getLocalName());

			} catch (XMLStreamException e) {
				throw new java.lang.Exception(e);
			}

			return object;
		}

	}// end of factory class

}