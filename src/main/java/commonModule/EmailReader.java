package commonModule;

import lombok.val;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.openqa.selenium.WebElement;

import javax.mail.*;
import javax.mail.internet.MimeMultipart;
import javax.mail.search.*;
import java.io.*;
import java.lang.management.ThreadInfo;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailReader {
   // private String saveDirectory = System.getProperty("user.dir") + "\\SaveEmails";

    public static String readMails(String host, int port, String storeType,
                                   String user, String password, String emailSubject, String fromAddress) {
        String mailBody = "";
        Object objMailBody;
        try {
            //1) get the session object
            Properties properties = new Properties();
            //properties.put("mail.debug", "true");
            // properties.put("mail.pop3s.host",imapHost);
            // properties.put("mail.pop3s.port",String.valueOf(port));
            //properties.put("mail.pop3s.starttls.enable","true");
            Session session = Session.getDefaultInstance(properties);
            //session.setDebug(true);
            //2) create the POP3 store object and connect with the pop server
            Store store = (Store) session.getStore(storeType);
            store.connect(host, port, user, password);
            //3) create the folder object and open it
            Folder folder = store.getFolder("INBOX");
            if (!folder.exists()) {
                System.out.println("No such folder named \"" + folder.getName() + "\".");
                System.exit(0);
            }
            folder.open(Folder.READ_WRITE);
            // search for all "unseen" messages
            Flags seen = new Flags(Flags.Flag.SEEN);// try changing this SEEN to RECENT
            Flags recent = new Flags(Flags.Flag.RECENT);
            // set it true or false for seen & unseen mail
            FlagTerm unseenFlagTerm = new FlagTerm(seen, false);
            FlagTerm seenFlagTerm = new FlagTerm(seen, true);
            FlagTerm recentFlagTerm = new FlagTerm(recent, true);

            SearchTerm searchTerm = new AndTerm(unseenFlagTerm, new SubjectTerm(emailSubject));
            SearchTerm finalSearch = new AndTerm(searchTerm, new FromStringTerm(fromAddress));
            //4) retrieve the messages from the folder in an array and print it
            // Message[] messages = folder.getMessages();
            //Retrieve Unseen messages
            Message messages[] = folder.search(finalSearch);
          //  System.out.println("Count of unseen messages" + messages.length);
            if (messages.length > 1) {
                Arrays.sort(messages, (m1, m2) -> {
                    try {
                        return m2.getSentDate().compareTo(m1.getSentDate());
                    } catch (MessagingException e) {
                        throw new RuntimeException(e);
                    }
                });
            }
            //System.out.println("\n new message count" + folder.getNewMessageCount());

            //for (Message message : messages) {
              //  System.out.println("Message: "+message);
               // System.out.println("Subject" +
                 //       message.getSubject() +
                   //     "\n Body Content type: "+message.getContentType()+
                     //   "\n Body Content :"+message.getContent());
                //objMailBody=message.getContent();
            Message message=messages[0];
                mailBody = getTextFromMessage(message);
             //    System.out.println("read mail body: "+ mailBody);
                message.setFlag(Flags.Flag.SEEN, true);
              // break;
            //}

            //5) close the store and folder objects
            folder.close(false);
            store.close();

        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
       // System.out.println("mail body: "+mailBody);
        return mailBody;
    }

    private static String getTextFromMessage(Message message) throws MessagingException, IOException {
        String result = "";
        if (message.isMimeType("text/plain")) {
            result = message.getContent().toString();
           System.out.println("text/plain Result: ");
        }else if(message.isMimeType("text/html")){
             result = (String) message.getContent();
            System.out.println("text/html Result: ");
         //result =Jsoup.parse(result1).text();
        } else if (message.isMimeType("multipart/*")) {
          //  System.out.println("is mime multipart: "+message.isMimeType("multipart/*"));
            MimeMultipart mimeMultipart = (MimeMultipart) message.getContent();
            result = getTextFromMimeMultipart(mimeMultipart);
           System.out.println("multipart Result: ");
        }
        return result;
    }

    private static String getTextFromMimeMultipart(
            MimeMultipart mimeMultipart) throws MessagingException, IOException {
        String result = "";
        int count = mimeMultipart.getCount();
        for (int i = 0; i < count; i++) {
            BodyPart bodyPart = mimeMultipart.getBodyPart(i);
            if (bodyPart.isMimeType("text/plain")) {
                result = result + "\n" + bodyPart.getContent();
             //   System.out.println("Result: "+result);
                break; // without break same text appears twice in my tests
            } else if (bodyPart.isMimeType("text/html")) {
                String html = (String) bodyPart.getContent();
                result = result + "\n" + Jsoup.parse(html).text();
               // System.out.println("Html Result: "+result);
            } else if (bodyPart.getContent() instanceof MimeMultipart) {
                result = result + getTextFromMimeMultipart((MimeMultipart) bodyPart.getContent());
                //System.out.println("result: "+result);
            }
        }
        return result;
    }

    public static String getStrResetPass(String host, int port, String storeType, String user, String password, String emailSubject, String fromAddress) {
        String shtml = readMails(host, port, storeType, user, password, emailSubject, fromAddress);
        // String shtml = ReadEmailWithImap.readEmailByDateFromAndSubject("", "", smtpUserName , smtpPassword, date, fromAddress,emailSubject,"").getMessageBody();
        String resetPassLink = "";
        List<WebElement> aTag;
      // System.out.println("shtml:  "+shtml);

        if (shtml != null) {
            Document doc=Jsoup.parse(shtml);
           System.out.println("document:"+ doc);
           List<Element> aTags= doc.body().select(" a");
         //resetPassLink= doc.body().select(" a").attr("href");
           resetPassLink=aTags.get(1).attr("href");
           // System.out.println("textlink: "+textlink);
          //  String regEx = "Reset Password<(.+)>";
           // Pattern pattern = Pattern.compile(regEx);
            //Matcher matcher = pattern.matcher(shtml);
           // if (matcher.find(1)) {
             //   resetPassLink = matcher.group(1);
               // System.out.println("reset password link: "+resetPassLink);
         } else {
                System.out.println("no matching link found");
            }

        return resetPassLink;
    }
}