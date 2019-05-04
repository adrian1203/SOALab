//import javax.ejb.MessageDriven;
//import javax.jms.JMSException;
//import javax.jms.Message;
//import javax.jms.MessageListener;
//import javax.jms.TextMessage;
//import java.util.logging.Logger;
//
//@MessageDriven(mappedName="jms/Queue")
//public class MyMessageBean implements MessageListener {
//    Logger logger = Logger.getLogger(MyMessageBean.class.getName());
//
//    public void onMessage(Message msg) {
//        TextMessage txtMsg = null;
//        try {
//            logger.info("Działam jestem tu");
//            if (msg instanceof TextMessage) {
//                txtMsg = (TextMessage) msg;
//                String txt = txtMsg.getText();
//
//            }
//        } catch (JMSException e) {
//
//        }
//    }
//}