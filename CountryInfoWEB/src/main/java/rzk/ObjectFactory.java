
package rzk;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the rzk package. 
 * &lt;p&gt;An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetCountryInfo_QNAME = new QName("http://rzk/", "getCountryInfo");
    private final static QName _GetCountryInfoResponse_QNAME = new QName("http://rzk/", "getCountryInfoResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: rzk
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetCountryInfo }
     * 
     */
    public GetCountryInfo createGetCountryInfo() {
        return new GetCountryInfo();
    }

    /**
     * Create an instance of {@link GetCountryInfoResponse }
     * 
     */
    public GetCountryInfoResponse createGetCountryInfoResponse() {
        return new GetCountryInfoResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCountryInfo }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetCountryInfo }{@code >}
     */
    @XmlElementDecl(namespace = "http://rzk/", name = "getCountryInfo")
    public JAXBElement<GetCountryInfo> createGetCountryInfo(GetCountryInfo value) {
        return new JAXBElement<GetCountryInfo>(_GetCountryInfo_QNAME, GetCountryInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCountryInfoResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetCountryInfoResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://rzk/", name = "getCountryInfoResponse")
    public JAXBElement<GetCountryInfoResponse> createGetCountryInfoResponse(GetCountryInfoResponse value) {
        return new JAXBElement<GetCountryInfoResponse>(_GetCountryInfoResponse_QNAME, GetCountryInfoResponse.class, null, value);
    }

}
