//import javax.annotation.Resource;
//import javax.jms.*;
//
//public class Server{
//
//
//
//    @Resource(mappedName = "jms/ConnectionFactory")
//    private static ConnectionFactory cf;
//    @Resource(mappedName ="JM/SOATest")
//    private  static Queue queue;
//
//    public static void send() throws JMSException {
//        Connection conn = cf.createConnection();
//        Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
//        MessageProducer producer = session.createProducer(queue);
//        TextMessage msg = session.createTextMessage();
//
//        msg.setText("Komunikat testowy");
//        producer.send(msg);
//    }
//
//
//
//}
