import javax.xml.namespace.QName;
import javax.xml.soap.*;
import java.io.IOException;
import java.util.Iterator;

/**
 * Created by di.ruizdechavez on 23/01/2017.
 */
public class Main {

    private static String URI = "http://ws/";

    public static void main(String[] args) {


        try {
            //instancia para conexión a servicio
            SOAPConnectionFactory factory = SOAPConnectionFactory.newInstance();
            //conexión a servicio
            SOAPConnection conexion = factory.createConnection();
            String urlConexion = "http://localhost:8080/estados";
            //llamada a servicio
            //SOAPMessage response = conexion.call(generarMensaje(),urlConexion);
            SOAPMessage response = conexion.call(generarTodo(),urlConexion);
            //generarMensaje();
            //imprimirRespuesta(response);
            imprimirTodo(response);
            conexion.close();
        } catch (SOAPException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void imprimirRespuesta(SOAPMessage response) throws SOAPException{
        SOAPBody body = response.getSOAPBody();
        SOAPElement elemento = (SOAPElement) body.getChildElements(new QName(URI,"getCapitalResponse")).next();
        SOAPElement elemento2 = (SOAPElement) elemento.getChildElements(new QName("return")).next();
        String respuesta = elemento2.getTextContent();
        System.out.println("\n" + respuesta);
    }

    public static void imprimirTodo(SOAPMessage response) throws SOAPException{
        SOAPBody body = response.getSOAPBody();
        SOAPElement elemento = (SOAPElement) body.getChildElements(new QName(URI,"getEstadosResponse")).next();
        Iterator<SOAPElement> iterator = elemento.getChildElements(new QName("estado"));
        iterator.forEachRemaining(elementoSOAP->{
            System.out.println("\n----------");
            Iterator<SOAPElement> iteratorInterno = elementoSOAP.getChildElements();
            iteratorInterno.forEachRemaining(etiquetaInterna->{
                System.out.println(etiquetaInterna.getNodeName() + ":" + etiquetaInterna.getTextContent());
            });
            System.out.println();
            //System.out.println("----------");
        });
    }

    private static SOAPMessage generarMensaje() throws SOAPException, IOException {

        //SOAPEnvelope envelope1 = MessageFactory.newInstance().createMessage().getSOAPPart().getEnvelope();
        MessageFactory factory = MessageFactory.newInstance();
        SOAPMessage mensaje = factory.createMessage();
        SOAPPart parte = mensaje.getSOAPPart();
        SOAPEnvelope envelope = parte.getEnvelope();
        envelope.addNamespaceDeclaration("ws",URI);
        SOAPBody cuerpo = envelope.getBody();
        SOAPElement elemento = cuerpo.addChildElement("getCapital","ws");
        SOAPElement elementoInterno = elemento.addChildElement("estado");
        elementoInterno.addTextNode("Guanajuato");
        mensaje.saveChanges();
        mensaje.writeTo(System.out);
        return mensaje;
    }

    private static SOAPMessage generarTodo() throws SOAPException, IOException {

        //SOAPEnvelope envelope1 = MessageFactory.newInstance().createMessage().getSOAPPart().getEnvelope();
        MessageFactory factory = MessageFactory.newInstance();
        SOAPMessage mensaje = factory.createMessage();
        SOAPPart parte = mensaje.getSOAPPart();
        SOAPEnvelope envelope = parte.getEnvelope();
        envelope.addNamespaceDeclaration("ws",URI);
        SOAPBody cuerpo = envelope.getBody();
        SOAPElement elemento = cuerpo.addChildElement("getEstados","ws");
        mensaje.saveChanges();
        mensaje.writeTo(System.out);
        return mensaje;
    }
}
