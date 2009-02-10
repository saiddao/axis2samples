package sample.axisversion;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.xml.namespace.QName;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMNamespace;
import org.apache.axiom.soap.SOAP12Constants;
import org.apache.axiom.soap.SOAPEnvelope;
import org.apache.axiom.soap.SOAPFactory;
import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.OperationClient;
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.client.Stub;
import org.apache.axis2.client.async.AxisCallback;
import org.apache.axis2.context.ConfigurationContext;
import org.apache.axis2.context.MessageContext;
import org.apache.axis2.description.AxisOperation;
import org.apache.axis2.description.AxisService;
import org.apache.axis2.description.OutInAxisOperation;
import org.apache.axis2.description.WSDL2Constants;
import org.apache.axis2.util.CallbackReceiver;
import org.apache.axis2.wsdl.WSDLConstants;

/*
 *  VersionStub java implementation
 */

public class VersionStub extends Stub {
	protected AxisOperation[] _operations;

	// hashmaps to keep the fault mapping
	private HashMap faultExceptionNameMap = new HashMap();
	private HashMap faultExceptionClassNameMap = new HashMap();
	private HashMap faultMessageMap = new HashMap();

	private static int counter = 0;

	private static synchronized String getUniqueSuffix() {
		// reset the counter if it is greater than 99999
		if (counter > 99999) {
			counter = 0;
		}
		counter = counter + 1;
		return Long.toString(System.currentTimeMillis()) + "_" + counter;
	}

	private void populateAxisService() throws AxisFault {

		// creating the Service with a unique name
		_service = new AxisService("Version" + getUniqueSuffix());
		addAnonymousOperations();

		// creating the operations
		AxisOperation __operation;

		_operations = new AxisOperation[1];

		__operation = new OutInAxisOperation();

		__operation
				.setName(new QName("http://axisversion.sample", "getVersion"));
		_service.addOperation(__operation);

		_operations[0] = __operation;

	}

	// populates the faults
	private void populateFaults() {

		faultExceptionNameMap.put(new QName("http://axisversion.sample",
				"Exception"), "sample.axisversion.ExceptionException0");
		faultExceptionClassNameMap.put(new QName("http://axisversion.sample",
				"Exception"), "sample.axisversion.ExceptionException0");
		faultMessageMap.put(new javax.xml.namespace.QName(
				"http://axisversion.sample", "Exception"),
				"sample.axisversion.VersionStub$ExceptionE");

	}

	/**
	 *Constructor that takes in a configContext
	 */

	public VersionStub(ConfigurationContext configurationContext,
			String targetEndpoint) throws AxisFault {
		this(configurationContext, targetEndpoint, false);
	}

	/**
	 * Constructor that takes in a configContext and useseperate listner
	 */
	public VersionStub(ConfigurationContext configurationContext,
			String targetEndpoint, boolean useSeparateListener)
			throws AxisFault {
		// To populate AxisService
		populateAxisService();
		populateFaults();

		_serviceClient = new ServiceClient(configurationContext, _service);

		configurationContext = _serviceClient.getServiceContext()
				.getConfigurationContext();

		_serviceClient.getOptions()
				.setTo(new EndpointReference(targetEndpoint));
		_serviceClient.getOptions().setUseSeparateListener(useSeparateListener);

		// Set the soap version
		_serviceClient.getOptions().setSoapVersionURI(
				SOAP12Constants.SOAP_ENVELOPE_NAMESPACE_URI);

	}

	/**
	 * Default Constructor
	 */
	public VersionStub(ConfigurationContext configurationContext)
			throws AxisFault {

		this(configurationContext,
				"http://172.16.0.217:8080/axis2/services/Version.VersionHttpSoap12Endpoint/");

	}

	/**
	 * Default Constructor
	 */
	public VersionStub() throws org.apache.axis2.AxisFault {

		this(
				"http://172.16.0.217:8080/axis2/services/Version.VersionHttpSoap12Endpoint/");

	}

	/**
	 * Constructor taking the target endpoint
	 */
	public VersionStub(String targetEndpoint) throws AxisFault {
		this(null, targetEndpoint);
	}

	/**
	 * Auto generated method signature
	 * 
	 * @see sample.axisversion.Version#getVersion
	 * @throws sample.axisversion.ExceptionException0
	 *             :
	 */

	public GetVersionResponse getVersion(

	) throws RemoteException, ExceptionException0 {
		MessageContext _messageContext = null;
		try {
			OperationClient _operationClient = _serviceClient
					.createClient(_operations[0].getName());
			_operationClient.getOptions().setAction("urn:getVersion");
			_operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(
					true);

			addPropertyToOperationClient(
					_operationClient,
					org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
					"&");

			// create a message context
			_messageContext = new MessageContext();

			// create SOAP envelope with that payload
			SOAPEnvelope env = null;

			// Style is taken to be "document". No input parameters
			// according to the WS-Basic profile in this case we have to send an
			// empty soap message
			SOAPFactory factory = getFactory(_operationClient.getOptions()
					.getSoapVersionURI());
			env = factory.getDefaultEnvelope();

			// adding SOAP soap_headers
			_serviceClient.addHeadersToEnvelope(env);
			// set the message context with that soap envelope
			_messageContext.setEnvelope(env);

			// add the message contxt to the operation client
			_operationClient.addMessageContext(_messageContext);

			// execute the operation client
			_operationClient.execute(true);

			MessageContext _returnMessageContext = _operationClient
					.getMessageContext(WSDLConstants.MESSAGE_LABEL_IN_VALUE);
			SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();

			Object object = fromOM(_returnEnv.getBody().getFirstElement(),
					GetVersionResponse.class, getEnvelopeNamespaces(_returnEnv));

			return (GetVersionResponse) object;

		} catch (AxisFault f) {

			OMElement faultElt = f.getDetail();
			if (faultElt != null) {
				if (faultExceptionNameMap.containsKey(faultElt.getQName())) {
					// make the fault by reflection
					try {
						String exceptionClassName = (String) faultExceptionClassNameMap
								.get(faultElt.getQName());
						Class exceptionClass = Class
								.forName(exceptionClassName);
						java.lang.Exception ex = (java.lang.Exception) exceptionClass
								.newInstance();
						// message class
						String messageClassName = (String) faultMessageMap
								.get(faultElt.getQName());
						Class messageClass = Class.forName(messageClassName);
						Object messageObject = fromOM(faultElt, messageClass,
								null);
						Method m = exceptionClass.getMethod("setFaultMessage",
								new java.lang.Class[] { messageClass });
						m.invoke(ex, new java.lang.Object[] { messageObject });

						if (ex instanceof ExceptionException0) {
							throw (ExceptionException0) ex;
						}

						throw new RemoteException(ex.getMessage(), ex);
					} catch (ClassCastException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					} catch (ClassNotFoundException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					} catch (NoSuchMethodException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					} catch (InvocationTargetException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					} catch (IllegalAccessException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					} catch (InstantiationException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					}
				} else {
					throw f;
				}
			} else {
				throw f;
			}
		} finally {
			_messageContext.getTransportOut().getSender().cleanup(
					_messageContext);
		}
	}

	/**
	 * Auto generated method signature for Asynchronous Invocations
	 * 
	 * @see sample.axisversion.Version#startgetVersion
	 */
	public void startgetVersion(final VersionCallbackHandler callback)
			throws java.rmi.RemoteException {

		OperationClient _operationClient = _serviceClient
				.createClient(_operations[0].getName());
		_operationClient.getOptions().setAction("urn:getVersion");
		_operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

		addPropertyToOperationClient(_operationClient,
				WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR, "&");

		// create SOAP envelope with that payload
		SOAPEnvelope env = null;
		final MessageContext _messageContext = new MessageContext();

		// Style is taken to be "document". No input parameters
		// according to the WS-Basic profile in this case we have to send an
		// empty soap message
		SOAPFactory factory = getFactory(_operationClient.getOptions()
				.getSoapVersionURI());
		env = factory.getDefaultEnvelope();

		// adding SOAP soap_headers
		_serviceClient.addHeadersToEnvelope(env);
		// create message context with that soap envelope
		_messageContext.setEnvelope(env);

		// add the message context to the operation client
		_operationClient.addMessageContext(_messageContext);

		_operationClient.setCallback(new AxisCallback() {
			public void onMessage(MessageContext resultContext) {
				try {
					SOAPEnvelope resultEnv = resultContext.getEnvelope();

					Object object = fromOM(resultEnv.getBody()
							.getFirstElement(), GetVersionResponse.class,
							getEnvelopeNamespaces(resultEnv));
					callback
							.receiveResultgetVersion((GetVersionResponse) object);

				} catch (AxisFault e) {
					callback.receiveErrorgetVersion(e);
				}
			}

			public void onError(java.lang.Exception error) {
				if (error instanceof AxisFault) {
					AxisFault f = (AxisFault) error;
					OMElement faultElt = f.getDetail();
					if (faultElt != null) {
						if (faultExceptionNameMap.containsKey(faultElt
								.getQName())) {
							// make the fault by reflection
							try {
								String exceptionClassName = (String) faultExceptionClassNameMap
										.get(faultElt.getQName());
								Class exceptionClass = Class
										.forName(exceptionClassName);
								java.lang.Exception ex = (java.lang.Exception) exceptionClass
										.newInstance();
								// message class
								String messageClassName = (String) faultMessageMap
										.get(faultElt.getQName());
								Class messageClass = Class
										.forName(messageClassName);
								Object messageObject = fromOM(faultElt,
										messageClass, null);
								Method m = exceptionClass.getMethod(
										"setFaultMessage",
										new Class[] { messageClass });
								m.invoke(ex, new Object[] { messageObject });

								if (ex instanceof ExceptionException0) {
									callback
											.receiveErrorgetVersion((ExceptionException0) ex);
									return;
								}

								callback
										.receiveErrorgetVersion(new RemoteException(
												ex.getMessage(), ex));
							} catch (ClassCastException e) {
								// we cannot intantiate the class -
								// throw the original Axis fault
								callback.receiveErrorgetVersion(f);
							} catch (ClassNotFoundException e) {
								// we cannot intantiate the class -
								// throw the original Axis fault
								callback.receiveErrorgetVersion(f);
							} catch (NoSuchMethodException e) {
								// we cannot intantiate the class -
								// throw the original Axis fault
								callback.receiveErrorgetVersion(f);
							} catch (InvocationTargetException e) {
								// we cannot intantiate the class -
								// throw the original Axis fault
								callback.receiveErrorgetVersion(f);
							} catch (IllegalAccessException e) {
								// we cannot intantiate the class -
								// throw the original Axis fault
								callback.receiveErrorgetVersion(f);
							} catch (InstantiationException e) {
								// we cannot intantiate the class -
								// throw the original Axis fault
								callback.receiveErrorgetVersion(f);
							} catch (AxisFault e) {
								// we cannot intantiate the class -
								// throw the original Axis fault
								callback.receiveErrorgetVersion(f);
							}
						} else {
							callback.receiveErrorgetVersion(f);
						}
					} else {
						callback.receiveErrorgetVersion(f);
					}
				} else {
					callback.receiveErrorgetVersion(error);
				}
			}

			public void onFault(MessageContext faultContext) {
				AxisFault fault = org.apache.axis2.util.Utils
						.getInboundFaultFromMessageContext(faultContext);
				onError(fault);
			}

			public void onComplete() {
				try {
					_messageContext.getTransportOut().getSender().cleanup(
							_messageContext);
				} catch (AxisFault axisFault) {
					callback.receiveErrorgetVersion(axisFault);
				}
			}
		});

		CallbackReceiver _callbackReceiver = null;
		if (_operations[0].getMessageReceiver() == null
				&& _operationClient.getOptions().isUseSeparateListener()) {
			_callbackReceiver = new CallbackReceiver();
			_operations[0].setMessageReceiver(_callbackReceiver);
		}

		// execute the operation client
		_operationClient.execute(false);

	}

	/**
	 * A utility method that copies the namepaces from the SOAPEnvelope
	 */
	private Map getEnvelopeNamespaces(SOAPEnvelope env) {
		Map returnMap = new HashMap();
		Iterator namespaceIterator = env.getAllDeclaredNamespaces();
		while (namespaceIterator.hasNext()) {
			OMNamespace ns = (OMNamespace) namespaceIterator.next();
			returnMap.put(ns.getPrefix(), ns.getNamespaceURI());
		}
		return returnMap;
	}

	private QName[] opNameArray = null;

	private boolean optimizeContent(QName opName) {

		if (opNameArray == null) {
			return false;
		}
		for (int i = 0; i < opNameArray.length; i++) {
			if (opName.equals(opNameArray[i])) {
				return true;
			}
		}
		return false;
	}

	private org.apache.axiom.om.OMElement toOM(GetVersionResponse param,
			boolean optimizeContent) throws org.apache.axis2.AxisFault {

		try {
			return param.getOMElement(GetVersionResponse.MY_QNAME,
					org.apache.axiom.om.OMAbstractFactory.getOMFactory());
		} catch (org.apache.axis2.databinding.ADBException e) {
			throw org.apache.axis2.AxisFault.makeFault(e);
		}

	}

	private org.apache.axiom.om.OMElement toOM(ExceptionE param,
			boolean optimizeContent) throws org.apache.axis2.AxisFault {

		try {
			return param.getOMElement(ExceptionE.MY_QNAME,
					org.apache.axiom.om.OMAbstractFactory.getOMFactory());
		} catch (org.apache.axis2.databinding.ADBException e) {
			throw org.apache.axis2.AxisFault.makeFault(e);
		}

	}

	/**
	 * get the default envelope
	 */
	private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
			org.apache.axiom.soap.SOAPFactory factory) {
		return factory.getDefaultEnvelope();
	}

	private java.lang.Object fromOM(org.apache.axiom.om.OMElement param,
			java.lang.Class type, java.util.Map extraNamespaces)
			throws org.apache.axis2.AxisFault {

		try {

			if (GetVersionResponse.class.equals(type)) {

				return GetVersionResponse.Factory.parse(param
						.getXMLStreamReaderWithoutCaching());

			}

			if (ExceptionE.class.equals(type)) {

				return ExceptionE.Factory.parse(param
						.getXMLStreamReaderWithoutCaching());

			}

		} catch (java.lang.Exception e) {
			throw org.apache.axis2.AxisFault.makeFault(e);
		}
		return null;
	}

}
